package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

final class au$3
  extends WebViewClient
{
  au$3(au paramau) {}
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(135254);
    au.a(this.lEN).bL(paramString);
    AppMethodBeat.o(135254);
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(135253);
    au.a(this.lEN);
    AppMethodBeat.o(135253);
  }
  
  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    AppMethodBeat.i(135255);
    if (paramSslError.getPrimaryError() == 3)
    {
      if (au.a(this.lEN).a(paramSslError.getCertificate()))
      {
        paramSslErrorHandler.proceed();
        AppMethodBeat.o(135255);
        return;
      }
      paramSslErrorHandler.cancel();
      AppMethodBeat.o(135255);
      return;
    }
    paramSslErrorHandler.cancel();
    AppMethodBeat.o(135255);
  }
  
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(135257);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(135257);
      return null;
    }
    if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null) || (bs.isNullOrNil(paramWebResourceRequest.getUrl().toString())))
    {
      AppMethodBeat.o(135257);
      return null;
    }
    paramWebView = paramWebResourceRequest.getUrl().toString();
    paramWebView = au.a(this.lEN).PP(paramWebView);
    AppMethodBeat.o(135257);
    return paramWebView;
  }
  
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(135256);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(135256);
      return null;
    }
    paramWebView = au.a(this.lEN).PP(paramString);
    AppMethodBeat.o(135256);
    return paramWebView;
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.au.3
 * JD-Core Version:    0.7.0.1
 */