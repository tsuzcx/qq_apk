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
import com.tencent.mm.sdk.platformtools.bo;

final class al$3
  extends WebViewClient
{
  al$3(al paramal) {}
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(87317);
    al.a(this.iyV).bF(paramString);
    AppMethodBeat.o(87317);
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(87316);
    al.a(this.iyV);
    AppMethodBeat.o(87316);
  }
  
  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    AppMethodBeat.i(87318);
    if (paramSslError.getPrimaryError() == 3)
    {
      if (al.a(this.iyV).a(paramSslError.getCertificate()))
      {
        paramSslErrorHandler.proceed();
        AppMethodBeat.o(87318);
        return;
      }
      paramSslErrorHandler.cancel();
      AppMethodBeat.o(87318);
      return;
    }
    paramSslErrorHandler.cancel();
    AppMethodBeat.o(87318);
  }
  
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(87320);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(87320);
      return null;
    }
    if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null) || (bo.isNullOrNil(paramWebResourceRequest.getUrl().toString())))
    {
      AppMethodBeat.o(87320);
      return null;
    }
    paramWebView = paramWebResourceRequest.getUrl().toString();
    paramWebView = al.a(this.iyV).Ep(paramWebView);
    AppMethodBeat.o(87320);
    return paramWebView;
  }
  
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(87319);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(87319);
      return null;
    }
    paramWebView = al.a(this.iyV).Ep(paramString);
    AppMethodBeat.o(87319);
    return paramWebView;
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.al.3
 * JD-Core Version:    0.7.0.1
 */