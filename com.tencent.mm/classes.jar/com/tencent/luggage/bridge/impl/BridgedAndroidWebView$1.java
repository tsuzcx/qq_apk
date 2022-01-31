package com.tencent.luggage.bridge.impl;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.bridge.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BridgedAndroidWebView$1
  extends WebViewClient
{
  BridgedAndroidWebView$1(BridgedAndroidWebView paramBridgedAndroidWebView) {}
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(90750);
    BridgedAndroidWebView.a(this.byx).byn.onReady();
    AppMethodBeat.o(90750);
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(90749);
    BridgedAndroidWebView.a(this.byx).byn.tW();
    AppMethodBeat.o(90749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.BridgedAndroidWebView.1
 * JD-Core Version:    0.7.0.1
 */