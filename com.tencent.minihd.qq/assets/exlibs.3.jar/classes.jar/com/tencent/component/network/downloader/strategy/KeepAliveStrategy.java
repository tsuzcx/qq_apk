package com.tencent.component.network.downloader.strategy;

import org.apache.http.HttpRequest;

public abstract interface KeepAliveStrategy
{
  public abstract KeepAliveStrategy.KeepAlive a(String paramString, HttpRequest paramHttpRequest);
  
  public abstract boolean a(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.KeepAliveStrategy
 * JD-Core Version:    0.7.0.1
 */