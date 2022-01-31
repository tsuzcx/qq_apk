package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.h;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;

final class w$5
  extends p
{
  w$5(w paramw) {}
  
  public final m a(WebView paramWebView, l paraml)
  {
    if ((paraml == null) || (paraml.getUrl() == null) || (bk.bl(paraml.getUrl().toString()))) {
      return null;
    }
    paramWebView = paraml.getUrl().toString();
    return w.a(this.gVh, paramWebView);
  }
  
  public final m a(WebView paramWebView, l paraml, Bundle paramBundle)
  {
    if ((paraml == null) || (paraml.getUrl() == null) || (bk.bl(paraml.getUrl().toString()))) {
      return null;
    }
    paramWebView = paraml.getUrl().toString();
    return w.a(this.gVh, paramWebView);
  }
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    y.e("MicroMsg.AppBrandWebView", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
  }
  
  public final void a(WebView paramWebView, h paramh, SslError paramSslError)
  {
    if (paramSslError.getPrimaryError() == 3)
    {
      if (w.a(this.gVh).a(paramSslError.getCertificate()))
      {
        paramh.proceed();
        return;
      }
      paramh.cancel();
      return;
    }
    paramh.cancel();
  }
  
  public final void a(WebView paramWebView, l paraml, m paramm)
  {
    paramWebView = paraml.getUrl();
    if (paramWebView == null) {}
    for (paramWebView = "null";; paramWebView = paramWebView.toString())
    {
      y.e("MicroMsg.AppBrandWebView", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", new Object[] { paramWebView, paramm.mMimeType, Integer.valueOf(paramm.mStatusCode) });
      return;
    }
  }
  
  public final void a(WebView paramWebView, String paramString)
  {
    w.a(this.gVh).anD();
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    w.a(this.gVh);
  }
  
  public final boolean b(WebView paramWebView, String paramString)
  {
    y.i("MicroMsg.AppBrandWebView", "shouldOverrideUrlLoading, url = %s", new Object[] { paramString });
    return true;
  }
  
  public final m c(WebView paramWebView, String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return w.a(this.gVh, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.w.5
 * JD-Core Version:    0.7.0.1
 */