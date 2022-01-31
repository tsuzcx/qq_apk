package com.tencent.magicbrush.bind;

import android.support.annotation.Keep;
import android.webkit.JavascriptInterface;

public abstract interface V8JSInterface
{
  @JavascriptInterface
  @Keep
  public abstract String invokeHandler(String paramString1, String paramString2, int paramInt);
  
  @JavascriptInterface
  @Keep
  public abstract boolean isDebugPackage();
  
  @JavascriptInterface
  @Keep
  public abstract void publishHandler(String paramString1, String paramString2, String paramString3);
  
  @JavascriptInterface
  @Keep
  public abstract String retrieveEvent(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.bind.V8JSInterface
 * JD-Core Version:    0.7.0.1
 */