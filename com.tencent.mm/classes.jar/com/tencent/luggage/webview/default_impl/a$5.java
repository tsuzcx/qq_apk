package com.tencent.luggage.webview.default_impl;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.luggage.webview.a.a;

final class a$5
  extends WebViewClient
{
  a$5(a parama, a.a parama1) {}
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    this.bjP.bd(paramString);
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.bjP.bc(paramString);
  }
  
  @TargetApi(21)
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return this.bjP.bf(paramWebResourceRequest.getUrl().toString());
  }
  
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    return this.bjP.bf(paramString);
  }
  
  @TargetApi(21)
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return this.bjP.be(paramWebResourceRequest.getUrl().toString());
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return this.bjP.be(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.webview.default_impl.a.5
 * JD-Core Version:    0.7.0.1
 */