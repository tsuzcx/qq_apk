package com.tencent.component.network.downloader.strategy;

import org.apache.http.HttpRequest;

public abstract interface DownloadPreprocessStrategy
{
  public abstract DownloadPreprocessStrategy.DownloadPool a(String paramString1, String paramString2);
  
  public abstract String a(String paramString);
  
  public abstract void a(String paramString1, String paramString2, HttpRequest paramHttpRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy
 * JD-Core Version:    0.7.0.1
 */