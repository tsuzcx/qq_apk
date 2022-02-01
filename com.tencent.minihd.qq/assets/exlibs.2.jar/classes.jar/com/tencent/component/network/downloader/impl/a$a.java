package com.tencent.component.network.downloader.impl;

import com.tencent.component.network.downloader.DownloadResult;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

public abstract interface a$a
{
  public abstract int a();
  
  public abstract String a(String paramString);
  
  public abstract HttpHost a();
  
  public abstract void a(String paramString, long paramLong, float paramFloat);
  
  public abstract void a(String paramString1, String paramString2, HttpRequest paramHttpRequest);
  
  public abstract boolean a(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse);
  
  public abstract String b(String paramString);
  
  public abstract void b(String paramString1, String paramString2, HttpRequest paramHttpRequest);
  
  public abstract String c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.a.a
 * JD-Core Version:    0.7.0.1
 */