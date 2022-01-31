package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView;
import com.tencent.xweb.m;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.w;

final class ad$5
  extends w
{
  ad$5(ad paramad) {}
  
  public final s a(WebView paramWebView, r paramr)
  {
    AppMethodBeat.i(132448);
    if ((paramr == null) || (paramr.getUrl() == null) || (bo.isNullOrNil(paramr.getUrl().toString())))
    {
      AppMethodBeat.o(132448);
      return null;
    }
    paramWebView = paramr.getUrl().toString();
    paramWebView = ad.a(this.iys, paramWebView);
    AppMethodBeat.o(132448);
    return paramWebView;
  }
  
  public final s a(WebView paramWebView, r paramr, Bundle paramBundle)
  {
    AppMethodBeat.i(132449);
    if ((paramr == null) || (paramr.getUrl() == null) || (bo.isNullOrNil(paramr.getUrl().toString())))
    {
      AppMethodBeat.o(132449);
      return null;
    }
    paramWebView = paramr.getUrl().toString();
    paramWebView = ad.a(this.iys, paramWebView);
    AppMethodBeat.o(132449);
    return paramWebView;
  }
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(132450);
    ab.e("MicroMsg.AppBrandWebView", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(132450);
  }
  
  public final void a(WebView paramWebView, m paramm, SslError paramSslError)
  {
    AppMethodBeat.i(132446);
    if (paramSslError.getPrimaryError() == 3)
    {
      if (ad.a(this.iys).a(paramSslError.getCertificate()))
      {
        paramm.proceed();
        AppMethodBeat.o(132446);
        return;
      }
      paramm.cancel();
      AppMethodBeat.o(132446);
      return;
    }
    paramm.cancel();
    AppMethodBeat.o(132446);
  }
  
  public final void a(WebView paramWebView, r paramr, s params)
  {
    AppMethodBeat.i(132451);
    paramWebView = paramr.getUrl();
    if (paramWebView == null) {}
    for (paramWebView = "null";; paramWebView = paramWebView.toString())
    {
      ab.e("MicroMsg.AppBrandWebView", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", new Object[] { paramWebView, params.mMimeType, Integer.valueOf(params.mStatusCode) });
      AppMethodBeat.o(132451);
      return;
    }
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(132445);
    ab.i("MicroMsg.AppBrandWebView", "shouldOverrideUrlLoading, url = %s", new Object[] { paramString });
    AppMethodBeat.o(132445);
    return true;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(132444);
    ad.a(this.iys).bF(paramString);
    AppMethodBeat.o(132444);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(132443);
    ad.a(this.iys);
    AppMethodBeat.o(132443);
  }
  
  public final s c(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(132447);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(132447);
      return null;
    }
    paramWebView = ad.a(this.iys, paramString);
    AppMethodBeat.o(132447);
    return paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ad.5
 * JD-Core Version:    0.7.0.1
 */