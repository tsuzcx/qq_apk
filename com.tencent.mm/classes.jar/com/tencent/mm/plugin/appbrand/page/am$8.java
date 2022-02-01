package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.r;

final class am$8
  extends ac
{
  am$8(am paramam) {}
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(227329);
    if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null) || (Util.isNullOrNil(paramWebResourceRequest.getUrl().toString())))
    {
      AppMethodBeat.o(227329);
      return null;
    }
    paramWebView = paramWebResourceRequest.getUrl().toString();
    paramWebView = am.a(this.nsp, paramWebView);
    AppMethodBeat.o(227329);
    return paramWebView;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(227330);
    if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null) || (Util.isNullOrNil(paramWebResourceRequest.getUrl().toString())))
    {
      AppMethodBeat.o(227330);
      return null;
    }
    paramWebView = paramWebResourceRequest.getUrl().toString();
    paramWebView = am.a(this.nsp, paramWebView);
    AppMethodBeat.o(227330);
    return paramWebView;
  }
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(227331);
    Log.e("MicroMsg.AppBrandWebView", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(227331);
  }
  
  public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    AppMethodBeat.i(227332);
    paramWebView = paramWebResourceRequest.getUrl();
    if (paramWebView == null) {}
    for (paramWebView = "null";; paramWebView = paramWebView.toString())
    {
      Log.e("MicroMsg.AppBrandWebView", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", new Object[] { paramWebView, paramWebResourceResponse.mMimeType, Integer.valueOf(paramWebResourceResponse.mStatusCode) });
      AppMethodBeat.o(227332);
      return;
    }
  }
  
  public final void a(WebView paramWebView, r paramr, SslError paramSslError)
  {
    AppMethodBeat.i(227327);
    if (paramSslError.getPrimaryError() == 3)
    {
      if (am.d(this.nsp).a(paramSslError.getCertificate()))
      {
        paramr.proceed();
        AppMethodBeat.o(227327);
        return;
      }
      paramr.cancel();
      AppMethodBeat.o(227327);
      return;
    }
    paramr.cancel();
    AppMethodBeat.o(227327);
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(227326);
    Log.i("MicroMsg.AppBrandWebView", "shouldOverrideUrlLoading, url = %s", new Object[] { paramString });
    AppMethodBeat.o(227326);
    return true;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(227325);
    am.d(this.nsp).cW(paramString);
    AppMethodBeat.o(227325);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(227324);
    am.d(this.nsp);
    AppMethodBeat.o(227324);
  }
  
  public final WebResourceResponse c(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(227328);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(227328);
      return null;
    }
    paramWebView = am.a(this.nsp, paramString);
    AppMethodBeat.o(227328);
    return paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.am.8
 * JD-Core Version:    0.7.0.1
 */