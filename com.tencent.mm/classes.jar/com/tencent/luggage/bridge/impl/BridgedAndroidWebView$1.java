package com.tencent.luggage.bridge.impl;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.bridge.p;

final class BridgedAndroidWebView$1
  extends WebViewClient
{
  BridgedAndroidWebView$1(BridgedAndroidWebView paramBridgedAndroidWebView) {}
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    BridgedAndroidWebView.a(this.bhX).bhN.onReady();
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    BridgedAndroidWebView.a(this.bhX).bhN.pT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.BridgedAndroidWebView.1
 * JD-Core Version:    0.7.0.1
 */