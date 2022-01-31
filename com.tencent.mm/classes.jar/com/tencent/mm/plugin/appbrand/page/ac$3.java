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
import com.tencent.mm.sdk.platformtools.bk;

final class ac$3
  extends WebViewClient
{
  ac$3(ac paramac) {}
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    ac.a(this.gVF).anD();
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if (paramSslError.getPrimaryError() == 3)
    {
      if (ac.a(this.gVF).a(paramSslError.getCertificate()))
      {
        paramSslErrorHandler.proceed();
        return;
      }
      paramSslErrorHandler.cancel();
      return;
    }
    paramSslErrorHandler.cancel();
  }
  
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if (Build.VERSION.SDK_INT < 21) {}
    while ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null) || (bk.bl(paramWebResourceRequest.getUrl().toString()))) {
      return null;
    }
    paramWebView = paramWebResourceRequest.getUrl().toString();
    return ac.a(this.gVF).vO(paramWebView);
  }
  
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return ac.a(this.gVF).vO(paramString);
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ac.3
 * JD-Core Version:    0.7.0.1
 */