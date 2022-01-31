package com.tencent.luggage.webview.default_impl;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tencent.luggage.webview.a.a;

class DefaultWebCore$6
  extends WebChromeClient
{
  DefaultWebCore$6(a parama, a.a parama1) {}
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    paramWebView = this.bjP.bg(paramString2);
    if (paramWebView == null) {
      return false;
    }
    paramJsPromptResult.confirm(paramWebView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.webview.default_impl.DefaultWebCore.6
 * JD-Core Version:    0.7.0.1
 */