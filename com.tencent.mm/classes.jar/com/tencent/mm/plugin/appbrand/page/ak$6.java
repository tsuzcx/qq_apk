package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;

final class ak$6
  extends com.tencent.xweb.ac
{
  ak$6(ak paramak) {}
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(47923);
    if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null) || (bs.isNullOrNil(paramWebResourceRequest.getUrl().toString())))
    {
      AppMethodBeat.o(47923);
      return null;
    }
    paramWebView = paramWebResourceRequest.getUrl().toString();
    paramWebView = ak.a(this.lDY, paramWebView);
    AppMethodBeat.o(47923);
    return paramWebView;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(47924);
    if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null) || (bs.isNullOrNil(paramWebResourceRequest.getUrl().toString())))
    {
      AppMethodBeat.o(47924);
      return null;
    }
    paramWebView = paramWebResourceRequest.getUrl().toString();
    paramWebView = ak.a(this.lDY, paramWebView);
    AppMethodBeat.o(47924);
    return paramWebView;
  }
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(47925);
    com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrandWebView", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(47925);
  }
  
  public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    AppMethodBeat.i(47926);
    paramWebView = paramWebResourceRequest.getUrl();
    if (paramWebView == null) {}
    for (paramWebView = "null";; paramWebView = paramWebView.toString())
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrandWebView", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", new Object[] { paramWebView, paramWebResourceResponse.mMimeType, Integer.valueOf(paramWebResourceResponse.mStatusCode) });
      AppMethodBeat.o(47926);
      return;
    }
  }
  
  public final void a(WebView paramWebView, r paramr, SslError paramSslError)
  {
    AppMethodBeat.i(47921);
    if (paramSslError.getPrimaryError() == 3)
    {
      if (ak.c(this.lDY).a(paramSslError.getCertificate()))
      {
        paramr.proceed();
        AppMethodBeat.o(47921);
        return;
      }
      paramr.cancel();
      AppMethodBeat.o(47921);
      return;
    }
    paramr.cancel();
    AppMethodBeat.o(47921);
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(47920);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandWebView", "shouldOverrideUrlLoading, url = %s", new Object[] { paramString });
    AppMethodBeat.o(47920);
    return true;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(47919);
    ak.c(this.lDY).bL(paramString);
    AppMethodBeat.o(47919);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(47918);
    ak.c(this.lDY);
    AppMethodBeat.o(47918);
  }
  
  public final WebResourceResponse c(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(47922);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47922);
      return null;
    }
    paramWebView = ak.a(this.lDY, paramString);
    AppMethodBeat.o(47922);
    return paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ak.6
 * JD-Core Version:    0.7.0.1
 */