package com.wayster.produtosapi.Controller;

import com.wayster.produtosapi.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.wayster.produtosapi.model.ProdutoEntity;


@RestController
@RequestMapping("produtos")
public class Produto {

    public final ProdutoRepository produtoRepository;


    @Autowired
    public Produto(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public ProdutoEntity salvar (@RequestBody ProdutoEntity produto){
       return produtoRepository.save(produto);
    }

    @GetMapping
    public List<ProdutoEntity> getListaDeProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<ProdutoEntity> getProdutoById(@PathVariable("id") Integer id){
        return produtoRepository.findById(id);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") Integer id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") Integer id, @RequestBody ProdutoEntity produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }


 }
