package com.tencent.mm.plugin.game.luggage.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.luggage.d.k;
import com.tencent.luggage.g.d;
import com.tencent.luggage.webview.a.a;
import com.tencent.luggage.webview.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.m;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.t;
import java.util.Map;

public class e
  extends com.tencent.mm.plugin.webview.luggage.d.a
{
  private static final Object lock;
  private String mTitle;
  String nji;
  private c nkm;
  private boolean nkn;
  Map<String, String> nko;
  private String nkp;
  private boolean nkq;
  private boolean nkr;
  private boolean nks;
  private boolean nkt;
  private boolean nku;
  private GameWebPerformanceInfo nkv;
  private ViewGroup nkw;
  private boolean nkx;
  private Object nky;
  private Runnable nkz;
  
  static
  {
    AppMethodBeat.i(135962);
    lock = new Object();
    AppMethodBeat.o(135962);
  }
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135946);
    this.nkn = false;
    this.nkq = false;
    this.nkr = false;
    this.nks = false;
    this.nkt = false;
    this.nku = false;
    this.nkx = false;
    this.nky = new Object();
    this.nkz = new e.1(this);
    this.nkm = new c();
    this.nkm.vEF = new e.2(this);
    d.i("MicroMsg.GameWebCoreImpl", "create, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(135946);
  }
  
  private void bFw()
  {
    AppMethodBeat.i(135952);
    if ((this.nks) && (this.nkt)) {
      postDelayed(this.nkz, 3000L);
    }
    AppMethodBeat.o(135952);
  }
  
  public final boolean PT(String paramString)
  {
    AppMethodBeat.i(135959);
    d.d("MicroMsg.GameWebCoreImpl", "isWebCacheUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.nkn) });
    if (!this.nkn)
    {
      this.nkm.bV(paramString, true);
      this.nkn = true;
    }
    boolean bool = this.nkm.akk(paramString);
    AppMethodBeat.o(135959);
    return bool;
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(135949);
    super.a(parama);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135933);
        e.this.init();
        AppMethodBeat.o(135933);
      }
    });
    AppMethodBeat.o(135949);
  }
  
  protected void b(WebView arg1, String paramString)
  {
    AppMethodBeat.i(135954);
    d.i("MicroMsg.GameWebCoreImpl", "onPageFinished, blockImg: %b", new Object[] { Boolean.valueOf(this.nkr) });
    if (this.nkv.eAm == 0L)
    {
      this.nkv.eAm = System.currentTimeMillis();
      d.i("MicroMsg.GameWebCoreImpl", "onPageFinished, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.nkv.eAm) });
    }
    if (com.tencent.mm.plugin.webview.ui.tools.game.g.aiO(paramString).vmZ == 0L) {
      com.tencent.mm.plugin.webview.ui.tools.game.g.aiO(paramString).vmZ = System.currentTimeMillis();
    }
    synchronized (lock)
    {
      getSettings().setBlockNetworkImage(this.nkr);
      this.nkq = true;
      if (this.nkv.eAj == 0L) {
        this.nkv.eAj = System.currentTimeMillis();
      }
      AppMethodBeat.o(135954);
      return;
    }
  }
  
  protected void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(135953);
    this.nks = true;
    bFw();
    if (this.nkv.eAl == 0L)
    {
      this.nkv.eAl = System.currentTimeMillis();
      d.i("MicroMsg.GameWebCoreImpl", "onPageStarted, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.nkv.eAl) });
    }
    if (com.tencent.mm.plugin.webview.ui.tools.game.g.aiO(paramString).vmY == 0L) {
      com.tencent.mm.plugin.webview.ui.tools.game.g.aiO(paramString).vmY = System.currentTimeMillis();
    }
    AppMethodBeat.o(135953);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(135956);
    this.nkm.oW(this.nku);
    super.destroy();
    AppMethodBeat.o(135956);
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public c getWePkgPlugin()
  {
    return this.nkm;
  }
  
  protected final void init()
  {
    AppMethodBeat.i(135951);
    getSettings().setBlockNetworkImage(true);
    setWebViewClientProxy(new b());
    setWebChromeClientProxy(new e.a(this));
    AppMethodBeat.o(135951);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(135957);
    d.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time : %d, hashCode: %d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    this.nkp = paramString;
    if (this.nkv == null)
    {
      this.nkv = GameWebPerformanceInfo.lN(paramString);
      this.nkv.eAk = System.currentTimeMillis();
    }
    d.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.nkn) });
    if (!this.nkn)
    {
      this.nkm.bV(paramString, true);
      this.nkn = true;
    }
    super.loadUrl(paramString);
    AppMethodBeat.o(135957);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(135958);
    d.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time: %d， HEADER", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    this.nkp = paramString;
    if (this.nkv == null)
    {
      this.nkv = GameWebPerformanceInfo.lN(paramString);
      this.nkv.eAk = System.currentTimeMillis();
    }
    d.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.nkn) });
    if (!this.nkn)
    {
      this.nkm.bV(paramString, true);
      this.nkn = true;
    }
    super.loadUrl(paramString, paramMap);
    AppMethodBeat.o(135958);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(135947);
    super.onAttachedToWindow();
    d.i("MicroMsg.GameWebCoreImpl", "onAttachedToWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.nkt = true;
    bFw();
    AppMethodBeat.o(135947);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(135948);
    super.onDetachedFromWindow();
    d.i("MicroMsg.GameWebCoreImpl", "onDetachedFromWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    removeCallbacks(this.nkz);
    AppMethodBeat.o(135948);
  }
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(135955);
    d.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage, blockImg: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nkr = paramBoolean;
    if (this.nkq) {
      synchronized (lock)
      {
        getSettings().setBlockNetworkImage(paramBoolean);
        AppMethodBeat.o(135955);
        return;
      }
    }
    AppMethodBeat.o(135955);
  }
  
  public void setShouldCleanPkgWhenDestroy(boolean paramBoolean)
  {
    this.nku = paramBoolean;
  }
  
  public void us()
  {
    AppMethodBeat.i(135950);
    super.us();
    getWebCore().bzi.a(new com.tencent.mm.plugin.game.luggage.a(this));
    AppMethodBeat.o(135950);
  }
  
  public final class b
    extends com.tencent.mm.plugin.webview.luggage.g
  {
    public b() {}
    
    public final s a(WebView paramWebView, r paramr)
    {
      AppMethodBeat.i(135941);
      d.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramr.getUrl().toString() });
      if (paramr.getUrl().toString().equals("https://game.weixin.qq.com/favicon.ico"))
      {
        paramWebView = new s("img/png", null, null);
        AppMethodBeat.o(135941);
        return paramWebView;
      }
      s locals = e.h(e.this).akj(paramr.getUrl().toString());
      if (locals != null)
      {
        d.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
        AppMethodBeat.o(135941);
        return locals;
      }
      paramWebView = super.a(paramWebView, paramr);
      AppMethodBeat.o(135941);
      return paramWebView;
    }
    
    public final s a(WebView paramWebView, r paramr, Bundle paramBundle)
    {
      AppMethodBeat.i(135942);
      d.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramr.getUrl().toString() });
      if (paramr.getUrl().toString().equals("https://game.weixin.qq.com/favicon.ico"))
      {
        paramWebView = new s("img/png", null, null);
        AppMethodBeat.o(135942);
        return paramWebView;
      }
      s locals = e.h(e.this).akj(paramr.getUrl().toString());
      if (locals != null)
      {
        d.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
        AppMethodBeat.o(135942);
        return locals;
      }
      paramWebView = super.a(paramWebView, paramr, paramBundle);
      AppMethodBeat.o(135942);
      return paramWebView;
    }
    
    public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(135943);
      super.a(paramWebView, paramInt, paramString1, paramString2);
      d.e("MicroMsg.GameWebCoreImpl", "onReceivedError, desc: %s, url: %s", new Object[] { paramString1, paramString2 });
      h.qsU.j(949L, 1L, 1L);
      AppMethodBeat.o(135943);
    }
    
    public final void a(WebView paramWebView, m paramm, SslError paramSslError)
    {
      AppMethodBeat.i(135944);
      super.a(paramWebView, paramm, paramSslError);
      d.e("MicroMsg.GameWebCoreImpl", "onReceivedSslError， error: ".concat(String.valueOf(paramSslError)));
      h.qsU.j(949L, 2L, 1L);
      AppMethodBeat.o(135944);
    }
    
    public final void a(WebView paramWebView, r paramr, s params)
    {
      AppMethodBeat.i(135945);
      super.a(paramWebView, paramr, params);
      d.e("MicroMsg.GameWebCoreImpl", "onReceivedHttpError， errorCode: %d", new Object[] { Integer.valueOf(params.mStatusCode) });
      h.qsU.j(949L, 3L, 1L);
      AppMethodBeat.o(135945);
    }
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(135939);
      d.i("MicroMsg.GameWebCoreImpl", "shouldOverrideUrlLoading, url: %s", new Object[] { paramString });
      if (DownloadChecker.a(paramString, e.i(e.this), paramWebView))
      {
        ab.i("MicroMsg.GameWebCoreImpl", "use the downloader to download");
        AppMethodBeat.o(135939);
        return true;
      }
      boolean bool = super.a(paramWebView, paramString);
      AppMethodBeat.o(135939);
      return bool;
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(135937);
      d.i("MicroMsg.GameWebCoreImpl", "onPageFinished, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      e.h(e.this).l(paramWebView, paramString);
      super.b(paramWebView, paramString);
      e.this.b(paramWebView, paramString);
      AppMethodBeat.o(135937);
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(135936);
      d.i("MicroMsg.GameWebCoreImpl", "onPageStarted, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      e.h(e.this).k(paramWebView, paramString);
      super.b(paramWebView, paramString, paramBitmap);
      e.this.b(paramWebView, paramString, paramBitmap);
      AppMethodBeat.o(135936);
    }
    
    public final s c(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(135940);
      d.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramString });
      if (paramString.equals("https://game.weixin.qq.com/favicon.ico"))
      {
        paramWebView = new s("img/png", null, null);
        AppMethodBeat.o(135940);
        return paramWebView;
      }
      s locals = e.h(e.this).akj(paramString);
      if (locals != null)
      {
        d.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
        AppMethodBeat.o(135940);
        return locals;
      }
      paramWebView = super.c(paramWebView, paramString);
      AppMethodBeat.o(135940);
      return paramWebView;
    }
    
    public final void h(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(135938);
      super.h(paramWebView, paramString);
      d.d("MicroMsg.GameWebCoreImpl", "onLoadResource, url: %s", new Object[] { paramString });
      AppMethodBeat.o(135938);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.e
 * JD-Core Version:    0.7.0.1
 */