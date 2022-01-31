package com.tencent.mm.plugin.game.luggage;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;

public final class c$b
  extends g
{
  public c$b(c paramc) {}
  
  public final m a(WebView paramWebView, l paraml)
  {
    com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paraml.getUrl().toString() });
    if (paraml.getUrl().toString().equals("https://game.weixin.qq.com/favicon.ico")) {
      return new m("img/png", null, null);
    }
    m localm = c.c(this.kMw).UP(paraml.getUrl().toString());
    if (localm != null)
    {
      com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
      return localm;
    }
    return super.a(paramWebView, paraml);
  }
  
  public final m a(WebView paramWebView, l paraml, Bundle paramBundle)
  {
    com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paraml.getUrl().toString() });
    if (paraml.getUrl().toString().equals("https://game.weixin.qq.com/favicon.ico")) {
      return new m("img/png", null, null);
    }
    m localm = c.c(this.kMw).UP(paraml.getUrl().toString());
    if (localm != null)
    {
      com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
      return localm;
    }
    return super.a(paramWebView, paraml, paramBundle);
  }
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    com.tencent.luggage.j.c.e("MicroMsg.GameWebCoreImpl", "onReceivedError, desc: %s, url: %s", new Object[] { paramString1, paramString2 });
    com.tencent.mm.plugin.report.service.h.nFQ.h(949L, 1L, 1L);
  }
  
  public final void a(WebView paramWebView, com.tencent.xweb.h paramh, SslError paramSslError)
  {
    super.a(paramWebView, paramh, paramSslError);
    com.tencent.luggage.j.c.e("MicroMsg.GameWebCoreImpl", "onReceivedSslError， error: " + paramSslError);
    com.tencent.mm.plugin.report.service.h.nFQ.h(949L, 2L, 1L);
  }
  
  public final void a(WebView paramWebView, l paraml, m paramm)
  {
    super.a(paramWebView, paraml, paramm);
    com.tencent.luggage.j.c.e("MicroMsg.GameWebCoreImpl", "onReceivedHttpError， errorCode: %d", new Object[] { Integer.valueOf(paramm.mStatusCode) });
    com.tencent.mm.plugin.report.service.h.nFQ.h(949L, 3L, 1L);
  }
  
  public final void a(WebView paramWebView, String paramString)
  {
    com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "onPageFinished, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    this.kMw.a(paramWebView, paramString);
    c.c(this.kMw).h(paramWebView, paramString);
    super.a(paramWebView, paramString);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "onPageStarted, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    this.kMw.b(paramWebView, paramString, paramBitmap);
    c.c(this.kMw).g(paramWebView, paramString);
    super.b(paramWebView, paramString, paramBitmap);
  }
  
  public final boolean b(WebView paramWebView, String paramString)
  {
    return super.b(paramWebView, paramString);
  }
  
  public final m c(WebView paramWebView, String paramString)
  {
    com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramString });
    if (paramString.equals("https://game.weixin.qq.com/favicon.ico")) {
      return new m("img/png", null, null);
    }
    m localm = c.c(this.kMw).UP(paramString);
    if (localm != null)
    {
      com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
      return localm;
    }
    return super.c(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.b
 * JD-Core Version:    0.7.0.1
 */