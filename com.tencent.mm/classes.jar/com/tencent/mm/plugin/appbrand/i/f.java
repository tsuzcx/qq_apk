package com.tencent.mm.plugin.appbrand.i;

import android.webkit.ValueCallback;
import java.net.URL;

public abstract interface f
  extends g
{
  public abstract <T extends g> T I(Class<T> paramClass);
  
  public abstract void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback);
  
  public abstract void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback);
  
  public abstract void addJavascriptInterface(Object paramObject, String paramString);
  
  public abstract void destroy();
  
  public abstract void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback);
  
  public abstract void setJsExceptionHandler(e parame);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.f
 * JD-Core Version:    0.7.0.1
 */