package com.tencent.mm.plugin.appbrand.i;

import android.webkit.ValueCallback;
import java.net.URL;

public abstract interface i
  extends j
{
  public abstract void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback);
  
  public abstract void a(URL paramURL, String paramString1, String paramString2, String paramString3, ValueCallback<String> paramValueCallback);
  
  public abstract void addJavascriptInterface(Object paramObject, String paramString);
  
  public abstract void destroy();
  
  public abstract void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback);
  
  public abstract void setJsExceptionHandler(h paramh);
  
  public abstract <T extends j> T v(Class<T> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.i
 * JD-Core Version:    0.7.0.1
 */