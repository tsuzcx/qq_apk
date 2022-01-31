package com.tencent.luggage.bridge.impl;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.bridge.p;

class BridgedAndroidWebView$2
  extends WebChromeClient
{
  BridgedAndroidWebView$2(BridgedAndroidWebView paramBridgedAndroidWebView) {}
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    paramWebView = BridgedAndroidWebView.a(this.bhX).bhN.aW(paramString2);
    if (paramWebView != null)
    {
      paramJsPromptResult.confirm(paramWebView);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.BridgedAndroidWebView.2
 * JD-Core Version:    0.7.0.1
 */