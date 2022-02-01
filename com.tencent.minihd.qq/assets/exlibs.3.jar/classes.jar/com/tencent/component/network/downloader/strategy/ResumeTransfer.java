package com.tencent.component.network.downloader.strategy;

import com.tencent.component.network.downloader.a;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

public abstract interface ResumeTransfer
{
  public abstract String a(String paramString);
  
  public abstract void a();
  
  public abstract void a(a parama);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString1, String paramString2, HttpResponse paramHttpResponse);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(HttpGet paramHttpGet, String paramString1, String paramString2);
  
  public abstract void a(String[] paramArrayOfString, boolean paramBoolean);
  
  public abstract boolean a(String paramString1, String paramString2, HttpResponse paramHttpResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.ResumeTransfer
 * JD-Core Version:    0.7.0.1
 */