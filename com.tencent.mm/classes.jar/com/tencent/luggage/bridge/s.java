package com.tencent.luggage.bridge;

import android.content.Context;
import android.webkit.ValueCallback;

public abstract interface s
{
  public abstract void addJavascriptInterface(Object paramObject, String paramString);
  
  public abstract void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback);
  
  public abstract Context getContext();
  
  public abstract String getUserAgent();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.s
 * JD-Core Version:    0.7.0.1
 */