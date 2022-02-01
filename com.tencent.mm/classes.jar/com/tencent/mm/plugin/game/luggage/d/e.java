package com.tencent.mm.plugin.game.luggage.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import com.tencent.luggage.d.k;
import com.tencent.luggage.webview.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.wepkg.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.q;
import com.tencent.xweb.y;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  extends com.tencent.mm.plugin.webview.luggage.d.a
{
  private static final Object lock;
  private String mTitle;
  String rOQ;
  c rQb;
  boolean rQc;
  Map<String, String> rQd;
  private String rQe;
  private boolean rQf;
  private boolean rQg;
  private boolean rQh;
  private boolean rQi;
  private boolean rQj;
  private GameWebPerformanceInfo rQk;
  private boolean rQl;
  private Object rQm;
  private Runnable rQn;
  
  static
  {
    AppMethodBeat.i(83171);
    lock = new Object();
    AppMethodBeat.o(83171);
  }
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(83155);
    this.rQc = false;
    this.rQf = false;
    this.rQg = false;
    this.rQh = false;
    this.rQi = false;
    this.rQj = false;
    this.rQl = false;
    this.rQm = new Object();
    this.rQn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83134);
        synchronized (e.lock)
        {
          if (e.this.getSettings().getBlockNetworkImage())
          {
            ad.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage time out");
            e.this.getSettings().setBlockNetworkImage(false);
            com.tencent.mm.plugin.report.service.h.vKh.m(949L, 0L, 1L);
          }
          AppMethodBeat.o(83134);
          return;
        }
      }
    };
    getSettings().setForceDarkBehavior(1);
    this.rQb = new c();
    ad.i("MicroMsg.GameWebCoreImpl", "create, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(83155);
  }
  
  private void cBE()
  {
    AppMethodBeat.i(83161);
    if ((this.rQh) && (this.rQi)) {
      postDelayed(this.rQn, 3000L);
    }
    AppMethodBeat.o(83161);
  }
  
  public void Bg()
  {
    AppMethodBeat.i(83159);
    super.Bg();
    getWebCore().cay.a(new com.tencent.mm.plugin.game.luggage.b(this));
    AppMethodBeat.o(83159);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(83158);
    super.a(parama);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190163);
        e.this.init();
        AppMethodBeat.o(190163);
      }
    });
    AppMethodBeat.o(83158);
  }
  
  protected void b(WebView arg1, String paramString)
  {
    AppMethodBeat.i(83163);
    ad.i("MicroMsg.GameWebCoreImpl", "onPageFinished, blockImg: %b", new Object[] { Boolean.valueOf(this.rQg) });
    if (this.rQk.fVk == 0L)
    {
      this.rQk.fVk = System.currentTimeMillis();
      ad.i("MicroMsg.GameWebCoreImpl", "onPageFinished, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.rQk.fVk) });
    }
    if (com.tencent.mm.plugin.webview.ui.tools.game.h.ayl(this.rQe).BnA == 0L) {
      com.tencent.mm.plugin.webview.ui.tools.game.h.ayl(this.rQe).BnA = System.currentTimeMillis();
    }
    synchronized (lock)
    {
      getSettings().setBlockNetworkImage(this.rQg);
      this.rQf = true;
      if (this.rQk.fVh == 0L) {
        this.rQk.fVh = System.currentTimeMillis();
      }
      AppMethodBeat.o(83163);
      return;
    }
  }
  
  protected void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(83162);
    this.rQh = true;
    cBE();
    if (this.rQk.fVj == 0L)
    {
      this.rQk.fVj = System.currentTimeMillis();
      ad.i("MicroMsg.GameWebCoreImpl", "onPageStarted, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.rQk.fVj) });
    }
    if (com.tencent.mm.plugin.webview.ui.tools.game.h.ayl(this.rQe).Bnz == 0L) {
      com.tencent.mm.plugin.webview.ui.tools.game.h.ayl(this.rQe).Bnz = System.currentTimeMillis();
    }
    AppMethodBeat.o(83162);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(83165);
    this.rQb.tM(this.rQj);
    super.destroy();
    AppMethodBeat.o(83165);
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public c getWePkgPlugin()
  {
    return this.rQb;
  }
  
  protected final void init()
  {
    AppMethodBeat.i(83160);
    getSettings().setBlockNetworkImage(true);
    setWebViewClientProxy(new b());
    setWebChromeClientProxy(new a());
    AppMethodBeat.o(83160);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(83166);
    ad.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time : %d, hashCode: %d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    if (this.rQk == null)
    {
      this.rQk = GameWebPerformanceInfo.qd(this.rQe);
      this.rQk.fVi = System.currentTimeMillis();
    }
    ad.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.rQc) });
    if (!this.rQc)
    {
      this.rQb.ck(paramString, true);
      this.rQc = true;
    }
    String str = this.rQb.etr();
    ad.i("MicroMsg.GameWebCoreImpl", "loadUrl:%s", new Object[] { paramString });
    if (bt.isNullOrNil(str)) {}
    try
    {
      com.tencent.mm.game.report.api.a.fUK.a(5, URLEncoder.encode(paramString), "0", 0L);
      label155:
      super.loadUrl(paramString);
      AppMethodBeat.o(83166);
      return;
      ad.d("MicroMsg.GameWebCoreImpl", "use PageCache:%s", new Object[] { str });
      try
      {
        com.tencent.mm.game.report.api.a.fUK.a(5, URLEncoder.encode(paramString), "1", 0L);
        label198:
        super.loadDataWithBaseURL(paramString, str, "text/html", "utf-8", null);
        AppMethodBeat.o(83166);
        return;
      }
      catch (Exception localException2)
      {
        break label198;
      }
    }
    catch (Exception localException1)
    {
      break label155;
    }
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(83167);
    ad.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time: %d， HEADER", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.rQk == null)
    {
      this.rQk = GameWebPerformanceInfo.qd(this.rQe);
      this.rQk.fVi = System.currentTimeMillis();
    }
    ad.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.rQc) });
    if (!this.rQc)
    {
      this.rQb.ck(paramString, true);
      this.rQc = true;
    }
    String str = this.rQb.etr();
    ad.i("MicroMsg.GameWebCoreImpl", "loadUrl:%s", new Object[] { paramString });
    if (bt.isNullOrNil(str))
    {
      com.tencent.mm.game.report.api.a.fUK.a(5, URLEncoder.encode(paramString), "0", 0L);
      super.loadUrl(paramString, paramMap);
      AppMethodBeat.o(83167);
      return;
    }
    ad.d("MicroMsg.GameWebCoreImpl", "use PageCache:%s", new Object[] { str });
    com.tencent.mm.game.report.api.a.fUK.a(5, URLEncoder.encode(paramString), "1", 0L);
    super.loadDataWithBaseURL(paramString, str, "text/html", "utf-8", null);
    AppMethodBeat.o(83167);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(83156);
    super.onAttachedToWindow();
    ad.i("MicroMsg.GameWebCoreImpl", "onAttachedToWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.rQi = true;
    cBE();
    AppMethodBeat.o(83156);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(83157);
    super.onDetachedFromWindow();
    ad.i("MicroMsg.GameWebCoreImpl", "onDetachedFromWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    removeCallbacks(this.rQn);
    AppMethodBeat.o(83157);
  }
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(83164);
    ad.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage, blockImg: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.rQg = paramBoolean;
    if (this.rQf) {
      synchronized (lock)
      {
        getSettings().setBlockNetworkImage(paramBoolean);
        AppMethodBeat.o(83164);
        return;
      }
    }
    AppMethodBeat.o(83164);
  }
  
  public void setRawUrl(String paramString)
  {
    this.rQe = paramString;
  }
  
  public void setShouldCleanPkgWhenDestroy(boolean paramBoolean)
  {
    this.rQj = paramBoolean;
  }
  
  public final class a
    extends com.tencent.mm.plugin.webview.luggage.e
  {
    public a() {}
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83143);
      ad.i("MicroMsg.GameWebCoreImpl", "onReceivedTitle, title = %s", new Object[] { paramString });
      if (!com.tencent.mm.plugin.webview.luggage.c.b.Ng(paramString)) {
        e.a(e.this, paramString);
      }
      super.d(paramWebView, paramString);
      AppMethodBeat.o(83143);
    }
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(83144);
      if (e.a(e.this) != null) {
        e.a(e.this).a(paramConsoleMessage);
      }
      String str;
      if (paramConsoleMessage != null)
      {
        str = paramConsoleMessage.message();
        if ((!str.contains("luggage_err")) && (!str.contains("luggageBridge is not defined"))) {
          break label95;
        }
        ad.i("MicroMsg.GameWebCoreImpl", "luggage bridge error");
        e.c(e.this).fVt = str;
      }
      for (;;)
      {
        boolean bool = super.onConsoleMessage(paramConsoleMessage);
        AppMethodBeat.o(83144);
        return bool;
        str = "";
        break;
        label95:
        if (!str.startsWith("WXGAMEPERF:")) {
          continue;
        }
        Object localObject;
        if (str.contains("first-contentful-paint")) {
          localObject = str.replaceFirst("WXGAMEPERF:", "").trim();
        }
        try
        {
          long l = new JSONObject((String)localObject).optDouble("startTime", 0.0D);
          com.tencent.mm.plugin.webview.ui.tools.game.h.bE(e.d(e.this), l);
          for (;;)
          {
            label157:
            ad.i("MicroMsg.GameWebCoreImpl", str);
            break;
            if (str.contains("timing"))
            {
              localObject = str.replaceFirst("WXGAMEPERF:", "").trim();
              try
              {
                localObject = new JSONObject((String)localObject).optJSONObject("timing");
                if (localObject != null)
                {
                  com.tencent.mm.plugin.webview.ui.tools.game.h localh = com.tencent.mm.plugin.webview.ui.tools.game.h.aym(e.d(e.this));
                  if (localh != null)
                  {
                    localh.BnH = (((JSONObject)localObject).optLong("domainLookupEnd") - ((JSONObject)localObject).optLong("domainLookupStart"));
                    localh.BnI = (((JSONObject)localObject).optLong("connectEnd") - ((JSONObject)localObject).optLong("connectStart"));
                    localh.lvA = (((JSONObject)localObject).optLong("responseEnd") - ((JSONObject)localObject).optLong("requestStart"));
                    localh.BnJ = (((JSONObject)localObject).optLong("domInteractive") - ((JSONObject)localObject).optLong("domLoading"));
                    localh.BnL = (((JSONObject)localObject).optLong("domContentLoadedEventEnd") - ((JSONObject)localObject).optLong("responseEnd"));
                    localh.BnM = (((JSONObject)localObject).optLong("domComplete") - ((JSONObject)localObject).optLong("responseEnd"));
                  }
                }
              }
              catch (Exception localException) {}
            }
          }
        }
        catch (JSONException localJSONException)
        {
          break label157;
        }
      }
    }
  }
  
  public final class b
    extends com.tencent.mm.plugin.webview.luggage.h
  {
    public b() {}
    
    public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(83150);
      ad.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramWebResourceRequest.getUrl().toString() });
      if (paramWebResourceRequest.getUrl().toString().equals("https://game.weixin.qq.com/favicon.ico"))
      {
        paramWebView = new WebResourceResponse("img/png", null, null);
        AppMethodBeat.o(83150);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = e.a(e.this).azC(paramWebResourceRequest.getUrl().toString());
      if (localWebResourceResponse != null)
      {
        ad.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
        AppMethodBeat.o(83150);
        return localWebResourceResponse;
      }
      paramWebView = super.a(paramWebView, paramWebResourceRequest);
      AppMethodBeat.o(83150);
      return paramWebView;
    }
    
    public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
    {
      AppMethodBeat.i(83151);
      ad.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramWebResourceRequest.getUrl().toString() });
      if (paramWebResourceRequest.getUrl().toString().equals("https://game.weixin.qq.com/favicon.ico"))
      {
        paramWebView = new WebResourceResponse("img/png", null, null);
        AppMethodBeat.o(83151);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = e.a(e.this).azC(paramWebResourceRequest.getUrl().toString());
      if (localWebResourceResponse != null)
      {
        ad.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
        AppMethodBeat.o(83151);
        return localWebResourceResponse;
      }
      paramWebView = super.a(paramWebView, paramWebResourceRequest, paramBundle);
      AppMethodBeat.o(83151);
      return paramWebView;
    }
    
    public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(83152);
      super.a(paramWebView, paramInt, paramString1, paramString2);
      ad.e("MicroMsg.GameWebCoreImpl", "onReceivedError, desc: %s, url: %s", new Object[] { paramString1, paramString2 });
      com.tencent.mm.plugin.report.service.h.vKh.m(949L, 1L, 1L);
      AppMethodBeat.o(83152);
    }
    
    public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
    {
      AppMethodBeat.i(83154);
      super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
      ad.e("MicroMsg.GameWebCoreImpl", "onReceivedHttpError， errorCode: %d", new Object[] { Integer.valueOf(paramWebResourceResponse.mStatusCode) });
      com.tencent.mm.plugin.report.service.h.vKh.m(949L, 3L, 1L);
      AppMethodBeat.o(83154);
    }
    
    public final void a(WebView paramWebView, q paramq, SslError paramSslError)
    {
      AppMethodBeat.i(83153);
      super.a(paramWebView, paramq, paramSslError);
      ad.e("MicroMsg.GameWebCoreImpl", "onReceivedSslError， error: ".concat(String.valueOf(paramSslError)));
      com.tencent.mm.plugin.report.service.h.vKh.m(949L, 2L, 1L);
      AppMethodBeat.o(83153);
    }
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83148);
      ad.i("MicroMsg.GameWebCoreImpl", "shouldOverrideUrlLoading, url: %s", new Object[] { paramString });
      if (DownloadChecker.a(paramString, e.b(e.this), paramWebView))
      {
        ad.i("MicroMsg.GameWebCoreImpl", "use the downloader to download");
        AppMethodBeat.o(83148);
        return true;
      }
      boolean bool = super.a(paramWebView, paramString);
      AppMethodBeat.o(83148);
      return bool;
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83146);
      ad.i("MicroMsg.GameWebCoreImpl", "onPageFinished, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      e.a(e.this).p(paramWebView, paramString);
      super.b(paramWebView, paramString);
      e.this.b(paramWebView, paramString);
      AppMethodBeat.o(83146);
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(83145);
      ad.i("MicroMsg.GameWebCoreImpl", "onPageStarted, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      e.a(e.this).o(paramWebView, paramString);
      super.b(paramWebView, paramString, paramBitmap);
      e.this.b(paramWebView, paramString, paramBitmap);
      AppMethodBeat.o(83145);
    }
    
    public final WebResourceResponse c(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83149);
      ad.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramString });
      if (paramString.equals("https://game.weixin.qq.com/favicon.ico"))
      {
        paramWebView = new WebResourceResponse("img/png", null, null);
        AppMethodBeat.o(83149);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = e.a(e.this).azC(paramString);
      if (localWebResourceResponse != null)
      {
        ad.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
        AppMethodBeat.o(83149);
        return localWebResourceResponse;
      }
      paramWebView = super.c(paramWebView, paramString);
      AppMethodBeat.o(83149);
      return paramWebView;
    }
    
    public final void h(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83147);
      super.h(paramWebView, paramString);
      ad.i("MicroMsg.GameWebCoreImpl", "onLoadResource, url: %s", new Object[] { paramString });
      c localc = e.a(e.this);
      if ((!localc.BHt) && (!c.bZ(paramString)))
      {
        localc.b(paramWebView, localc.azD(localc.rQe));
        localc.BHt = true;
      }
      AppMethodBeat.o(83147);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.e
 * JD-Core Version:    0.7.0.1
 */