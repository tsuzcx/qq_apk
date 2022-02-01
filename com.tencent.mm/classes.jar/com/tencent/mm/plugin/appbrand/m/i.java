package com.tencent.mm.plugin.appbrand.m;

import android.webkit.ValueCallback;
import java.net.URL;

public abstract interface i
  extends o
{
  public abstract <T extends j> T R(Class<T> paramClass);
  
  public abstract void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback);
  
  public abstract void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback);
  
  public abstract void addJavascriptInterface(Object paramObject, String paramString);
  
  public abstract void destroy();
  
  public abstract void setJsExceptionHandler(h paramh);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.i
 * JD-Core Version:    0.7.0.1
 */