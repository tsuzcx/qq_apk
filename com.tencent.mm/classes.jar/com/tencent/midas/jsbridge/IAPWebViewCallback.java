package com.tencent.midas.jsbridge;

import android.graphics.Bitmap;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;

public abstract interface IAPWebViewCallback
{
  public abstract boolean WebChromeClientJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult);
  
  public abstract boolean WebChromeClientJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult);
  
  public abstract void WebViewClientPageFinished(WebView paramWebView, String paramString);
  
  public abstract void WebViewClientPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  public abstract void WebViewClientReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.jsbridge.IAPWebViewCallback
 * JD-Core Version:    0.7.0.1
 */