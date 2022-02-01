package com.tencent.mm.plugin.game.luggage.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import com.tencent.luggage.d.p;
import com.tencent.luggage.webview.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.game.luggage.c;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.ui.tools.game.g;
import com.tencent.mm.plugin.wepkg.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.z;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends com.tencent.mm.plugin.webview.luggage.webview_impl.a
{
  private static final Object lock;
  private String mTitle;
  String xwe;
  private Runnable xyA;
  protected e xyl;
  private boolean xym;
  Map<String, String> xyn;
  private String xyo;
  private boolean xyp;
  private boolean xyq;
  private boolean xyr;
  private boolean xyt;
  private boolean xyu;
  private GameWebPerformanceInfo xyv;
  private boolean xyw;
  private Object xyx;
  private boolean xyy;
  private boolean xyz;
  
  static
  {
    AppMethodBeat.i(83171);
    lock = new Object();
    AppMethodBeat.o(83171);
  }
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(83155);
    this.xym = false;
    this.xyp = false;
    this.xyq = false;
    this.xyr = false;
    this.xyt = false;
    this.xyu = false;
    this.xyw = false;
    this.xyx = new Object();
    this.xyy = false;
    this.xyz = false;
    this.xyA = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83134);
        synchronized (h.lock)
        {
          if (h.this.getSettings().getBlockNetworkImage())
          {
            Log.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage time out");
            h.this.getSettings().setBlockNetworkImage(false);
            com.tencent.mm.plugin.report.service.h.CyF.n(949L, 0L, 1L);
          }
          AppMethodBeat.o(83134);
          return;
        }
      }
    };
    getSettings().setForceDarkBehavior(1);
    this.xyl = new e();
    Log.i("MicroMsg.GameWebCoreImpl", "create, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(83155);
  }
  
  private void dTK()
  {
    AppMethodBeat.i(83161);
    if ((this.xyr) && (this.xyt)) {
      postDelayed(this.xyA, 3000L);
    }
    AppMethodBeat.o(83161);
  }
  
  public void LE()
  {
    AppMethodBeat.i(83159);
    super.LE();
    getWebCore().ctM.a(new c(this));
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
        AppMethodBeat.i(186954);
        h.this.init();
        AppMethodBeat.o(186954);
      }
    });
    AppMethodBeat.o(83158);
  }
  
  public final boolean azJ(String paramString)
  {
    AppMethodBeat.i(83168);
    Log.d("MicroMsg.GameWebCoreImpl", "isWebCacheUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.xym) });
    if (!this.xym)
    {
      this.xyl.m(paramString, true, false);
      this.xym = true;
    }
    boolean bool = this.xyl.bci(paramString);
    AppMethodBeat.o(83168);
    return bool;
  }
  
  protected void b(WebView arg1, String paramString)
  {
    AppMethodBeat.i(83163);
    Log.i("MicroMsg.GameWebCoreImpl", "onPageFinished, blockImg: %b", new Object[] { Boolean.valueOf(this.xyq) });
    if (this.xyv.hhR == 0L)
    {
      this.xyv.hhR = System.currentTimeMillis();
      Log.i("MicroMsg.GameWebCoreImpl", "onPageFinished, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.xyv.hhR) });
    }
    if (g.baK(this.xyo).JqX == 0L) {
      g.baK(this.xyo).JqX = System.currentTimeMillis();
    }
    synchronized (lock)
    {
      getSettings().setBlockNetworkImage(this.xyq);
      this.xyp = true;
      if (this.xyv.hhO == 0L) {
        this.xyv.hhO = System.currentTimeMillis();
      }
      AppMethodBeat.o(83163);
      return;
    }
  }
  
  protected void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(83162);
    this.xyr = true;
    dTK();
    if (this.xyv.hhQ == 0L)
    {
      this.xyv.hhQ = System.currentTimeMillis();
      Log.i("MicroMsg.GameWebCoreImpl", "onPageStarted, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.xyv.hhQ) });
    }
    if (g.baK(this.xyo).JqW == 0L) {
      g.baK(this.xyo).JqW = System.currentTimeMillis();
    }
    AppMethodBeat.o(83162);
  }
  
  public final boolean dTL()
  {
    return (this.xyp) && (!this.xyy);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(83165);
    this.xyl.zE(this.xyu);
    super.destroy();
    AppMethodBeat.o(83165);
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public e getWePkgPlugin()
  {
    return this.xyl;
  }
  
  protected final void init()
  {
    AppMethodBeat.i(83160);
    getSettings().setBlockNetworkImage(true);
    setWebViewClientProxy(new b());
    setWebChromeClientProxy(new a());
    AppMethodBeat.o(83160);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(186956);
    if (this.xyv == null)
    {
      this.xyv = GameWebPerformanceInfo.Fd(paramString1);
      this.xyv.hhP = System.currentTimeMillis();
    }
    Log.d("MicroMsg.GameWebCoreImpl", "loadDataWithBaseURL, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.xym) });
    if (!this.xym)
    {
      this.xyl.m(paramString1, true, true);
      this.xym = true;
    }
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(186956);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(83166);
    Log.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time : %d, hashCode: %d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    if (this.xyv == null)
    {
      this.xyv = GameWebPerformanceInfo.Fd(this.xyo);
      this.xyv.hhP = System.currentTimeMillis();
    }
    Log.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.xym) });
    if (!this.xym)
    {
      this.xyl.m(paramString, true, false);
      this.xym = true;
    }
    String str = this.xyl.gkv();
    Log.i("MicroMsg.GameWebCoreImpl", "loadUrl:%s", new Object[] { paramString });
    if (Util.isNullOrNil(str)) {}
    try
    {
      com.tencent.mm.game.report.api.a.hhr.a(5, URLEncoder.encode(paramString), "0", 0L);
      label156:
      super.loadUrl(paramString);
      AppMethodBeat.o(83166);
      return;
      Log.d("MicroMsg.GameWebCoreImpl", "use PageCache:%s", new Object[] { str });
      try
      {
        com.tencent.mm.game.report.api.a.hhr.a(5, URLEncoder.encode(paramString), "1", 0L);
        label199:
        super.loadDataWithBaseURL(paramString, str, "text/html", "utf-8", null);
        AppMethodBeat.o(83166);
        return;
      }
      catch (Exception localException2)
      {
        break label199;
      }
    }
    catch (Exception localException1)
    {
      break label156;
    }
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(83167);
    Log.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time: %d， HEADER", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.xyv == null)
    {
      this.xyv = GameWebPerformanceInfo.Fd(this.xyo);
      this.xyv.hhP = System.currentTimeMillis();
    }
    Log.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.xym) });
    if (!this.xym)
    {
      this.xyl.m(paramString, true, false);
      this.xym = true;
    }
    String str = this.xyl.gkv();
    Log.i("MicroMsg.GameWebCoreImpl", "loadUrl:%s", new Object[] { paramString });
    if (Util.isNullOrNil(str))
    {
      com.tencent.mm.game.report.api.a.hhr.a(5, URLEncoder.encode(paramString), "0", 0L);
      super.loadUrl(paramString, paramMap);
      AppMethodBeat.o(83167);
      return;
    }
    Log.d("MicroMsg.GameWebCoreImpl", "use PageCache:%s", new Object[] { str });
    com.tencent.mm.game.report.api.a.hhr.a(5, URLEncoder.encode(paramString), "1", 0L);
    super.loadDataWithBaseURL(paramString, str, "text/html", "utf-8", null);
    AppMethodBeat.o(83167);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(83156);
    super.onAttachedToWindow();
    Log.i("MicroMsg.GameWebCoreImpl", "onAttachedToWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.xyt = true;
    dTK();
    AppMethodBeat.o(83156);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(83157);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.GameWebCoreImpl", "onDetachedFromWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    removeCallbacks(this.xyA);
    AppMethodBeat.o(83157);
  }
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(83164);
    Log.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage, blockImg: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.xyq = paramBoolean;
    if (this.xyp) {
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
    this.xyo = paramString;
  }
  
  public void setShouldCleanPkgWhenDestroy(boolean paramBoolean)
  {
    this.xyu = paramBoolean;
  }
  
  public final class a
    extends f
  {
    public a() {}
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83143);
      Log.i("MicroMsg.GameWebCoreImpl", "onReceivedTitle, title = %s", new Object[] { paramString });
      if (!com.tencent.mm.plugin.webview.luggage.c.b.afC(paramString)) {
        h.a(h.this, paramString);
      }
      super.d(paramWebView, paramString);
      AppMethodBeat.o(83143);
    }
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(83144);
      if (h.this.xyl != null) {
        h.this.xyl.a(paramConsoleMessage);
      }
      final String str;
      if (paramConsoleMessage != null)
      {
        str = paramConsoleMessage.message();
        if ((!str.contains("luggage_err")) && (!str.contains("luggageBridge is not defined"))) {
          break label95;
        }
        Log.i("MicroMsg.GameWebCoreImpl", "luggage bridge error");
        h.d(h.this).hia = str;
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
          g.bL(h.e(h.this), l);
          for (;;)
          {
            label157:
            com.tencent.f.h.RTc.aX(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(186955);
                Log.i("MicroMsg.GameWebCoreImpl", str);
                AppMethodBeat.o(186955);
              }
            });
            break;
            if (str.contains("timing"))
            {
              localObject = str.replaceFirst("WXGAMEPERF:", "").trim();
              try
              {
                localObject = new JSONObject((String)localObject).optJSONObject("timing");
                if (localObject != null)
                {
                  g localg = g.baL(h.e(h.this));
                  if (localg != null)
                  {
                    localg.Jre = (((JSONObject)localObject).optLong("domainLookupEnd") - ((JSONObject)localObject).optLong("domainLookupStart"));
                    localg.Jrf = (((JSONObject)localObject).optLong("connectEnd") - ((JSONObject)localObject).optLong("connectStart"));
                    localg.nOC = (((JSONObject)localObject).optLong("responseEnd") - ((JSONObject)localObject).optLong("requestStart"));
                    localg.Jrg = (((JSONObject)localObject).optLong("domInteractive") - ((JSONObject)localObject).optLong("domLoading"));
                    localg.Jri = (((JSONObject)localObject).optLong("domContentLoadedEventEnd") - ((JSONObject)localObject).optLong("responseEnd"));
                    localg.Jrj = (((JSONObject)localObject).optLong("domComplete") - ((JSONObject)localObject).optLong("responseEnd"));
                    localg.Jrk = ((JSONObject)localObject).optLong("navigationStart");
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
    extends com.tencent.mm.plugin.webview.luggage.i
  {
    public b() {}
    
    public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(83150);
      Log.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramWebResourceRequest.getUrl().toString() });
      if (paramWebResourceRequest.getUrl().toString().equals("https://" + WeChatHosts.domainString(2131761707) + "/favicon.ico"))
      {
        paramWebView = new WebResourceResponse("img/png", null, null);
        AppMethodBeat.o(83150);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = h.this.xyl.p(paramWebView, paramWebResourceRequest.getUrl().toString());
      if (localWebResourceResponse != null)
      {
        Log.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
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
      Log.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramWebResourceRequest.getUrl().toString() });
      if (paramWebResourceRequest.getUrl().toString().equals("https://" + WeChatHosts.domainString(2131761707) + "/favicon.ico"))
      {
        paramWebView = new WebResourceResponse("img/png", null, null);
        AppMethodBeat.o(83151);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = h.this.xyl.p(paramWebView, paramWebResourceRequest.getUrl().toString());
      if (localWebResourceResponse != null)
      {
        Log.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
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
      Log.e("MicroMsg.GameWebCoreImpl", "onReceivedError, desc: %s, url: %s", new Object[] { paramString1, paramString2 });
      h.c(h.this);
      com.tencent.mm.plugin.report.service.h.CyF.n(949L, 1L, 1L);
      AppMethodBeat.o(83152);
    }
    
    public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
    {
      AppMethodBeat.i(83154);
      super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
      Log.e("MicroMsg.GameWebCoreImpl", "onReceivedHttpError， errorCode: %d", new Object[] { Integer.valueOf(paramWebResourceResponse.mStatusCode) });
      h.c(h.this);
      com.tencent.mm.plugin.report.service.h.CyF.n(949L, 3L, 1L);
      AppMethodBeat.o(83154);
    }
    
    public final void a(WebView paramWebView, r paramr, SslError paramSslError)
    {
      AppMethodBeat.i(83153);
      super.a(paramWebView, paramr, paramSslError);
      Log.e("MicroMsg.GameWebCoreImpl", "onReceivedSslError， error: ".concat(String.valueOf(paramSslError)));
      h.c(h.this);
      com.tencent.mm.plugin.report.service.h.CyF.n(949L, 2L, 1L);
      AppMethodBeat.o(83153);
    }
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83148);
      Log.i("MicroMsg.GameWebCoreImpl", "shouldOverrideUrlLoading, url: %s", new Object[] { paramString });
      if (DownloadChecker.a(paramString, h.b(h.this), paramWebView))
      {
        Log.i("MicroMsg.GameWebCoreImpl", "use the downloader to download");
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
      Log.i("MicroMsg.GameWebCoreImpl", "onPageFinished, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      h.this.xyl.bch(paramString);
      super.b(paramWebView, paramString);
      h.this.b(paramWebView, paramString);
      h.a(h.this);
      AppMethodBeat.o(83146);
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(83145);
      Log.i("MicroMsg.GameWebCoreImpl", "onPageStarted, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      h.this.xyl.bcg(paramString);
      super.b(paramWebView, paramString, paramBitmap);
      h.this.b(paramWebView, paramString, paramBitmap);
      AppMethodBeat.o(83145);
    }
    
    public final WebResourceResponse c(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83149);
      Log.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramString });
      if (paramString.equals("https://" + WeChatHosts.domainString(2131761707) + "/favicon.ico"))
      {
        paramWebView = new WebResourceResponse("img/png", null, null);
        AppMethodBeat.o(83149);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = h.this.xyl.p(paramWebView, paramString);
      if (localWebResourceResponse != null)
      {
        Log.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
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
      Log.i("MicroMsg.GameWebCoreImpl", "onLoadResource, url: %s", new Object[] { paramString });
      AppMethodBeat.o(83147);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.h
 * JD-Core Version:    0.7.0.1
 */