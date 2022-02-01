package com.tencent.mm.plugin.game.luggage.page;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import com.tencent.luggage.d.p;
import com.tencent.luggage.webview.a.a;
import com.tencent.luggage.webview.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.game.luggage.j.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import com.tencent.xweb.t;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends com.tencent.mm.plugin.webview.luggage.d.a
{
  private static final Object lock;
  String ItK;
  private boolean IwA;
  private boolean IwB;
  private boolean IwC;
  private boolean IwD;
  private GameWebPerformanceInfo IwE;
  private boolean IwF;
  private Object IwG;
  private boolean IwH;
  private boolean IwI;
  private Runnable IwJ;
  protected com.tencent.mm.plugin.wepkg.f Iwv;
  private boolean Iww;
  Map<String, String> Iwx;
  private String Iwy;
  private boolean Iwz;
  private String mTitle;
  
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
    this.Iww = false;
    this.Iwz = false;
    this.IwA = false;
    this.IwB = false;
    this.IwC = false;
    this.IwD = false;
    this.IwF = false;
    this.IwG = new Object();
    this.IwH = false;
    this.IwI = false;
    this.IwJ = new Runnable()
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
            com.tencent.mm.plugin.report.service.h.OAn.p(949L, 0L, 1L);
          }
          AppMethodBeat.o(83134);
          return;
        }
      }
    };
    getSettings().setForceDarkBehavior(1);
    this.Iwv = new com.tencent.mm.plugin.wepkg.f();
    Log.i("MicroMsg.GameWebCoreImpl", "create, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(83155);
  }
  
  private void fEN()
  {
    AppMethodBeat.i(83161);
    if ((this.IwB) && (this.IwC)) {
      postDelayed(this.IwJ, 3000L);
    }
    AppMethodBeat.o(83161);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(83158);
    super.a(parama);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(277032);
        h.this.init();
        AppMethodBeat.o(277032);
      }
    });
    AppMethodBeat.o(83158);
  }
  
  public final boolean aGj(String paramString)
  {
    AppMethodBeat.i(83168);
    Log.d("MicroMsg.GameWebCoreImpl", "isWebCacheUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.Iww) });
    if (!this.Iww)
    {
      this.Iwv.q(paramString, true, false);
      this.Iww = true;
    }
    boolean bool = this.Iwv.bnW(paramString);
    AppMethodBeat.o(83168);
    return bool;
  }
  
  public void aoC()
  {
    AppMethodBeat.i(83159);
    super.aoC();
    getWebCore().ejL.a(new com.tencent.mm.plugin.game.luggage.c(this));
    AppMethodBeat.o(83159);
  }
  
  protected void b(WebView arg1, String paramString)
  {
    AppMethodBeat.i(83163);
    Log.i("MicroMsg.GameWebCoreImpl", "onPageFinished, blockImg: %b", new Object[] { Boolean.valueOf(this.IwA) });
    if (this.IwE.muh == 0L)
    {
      this.IwE.muh = System.currentTimeMillis();
      Log.i("MicroMsg.GameWebCoreImpl", "onPageFinished, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.IwE.muh) });
    }
    if (com.tencent.mm.plugin.webview.ui.tools.game.h.bmm(this.Iwy).XgI == 0L) {
      com.tencent.mm.plugin.webview.ui.tools.game.h.bmm(this.Iwy).XgI = System.currentTimeMillis();
    }
    synchronized (lock)
    {
      getSettings().setBlockNetworkImage(this.IwA);
      this.Iwz = true;
      if (this.IwE.mue == 0L) {
        this.IwE.mue = System.currentTimeMillis();
      }
      AppMethodBeat.o(83163);
      return;
    }
  }
  
  protected void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(83162);
    this.IwB = true;
    fEN();
    if (this.IwE.mug == 0L)
    {
      this.IwE.mug = System.currentTimeMillis();
      Log.i("MicroMsg.GameWebCoreImpl", "onPageStarted, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.IwE.mug) });
    }
    if (com.tencent.mm.plugin.webview.ui.tools.game.h.bmm(this.Iwy).XgH == 0L) {
      com.tencent.mm.plugin.webview.ui.tools.game.h.bmm(this.Iwy).XgH = System.currentTimeMillis();
    }
    AppMethodBeat.o(83162);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(83165);
    this.Iwv.Jk(this.IwD);
    super.destroy();
    AppMethodBeat.o(83165);
  }
  
  public final boolean fEO()
  {
    return (this.Iwz) && (!this.IwH);
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public com.tencent.mm.plugin.wepkg.f getWePkgPlugin()
  {
    return this.Iwv;
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
    AppMethodBeat.i(277128);
    if (this.IwE == null)
    {
      this.IwE = GameWebPerformanceInfo.EI(paramString1);
      this.IwE.muf = System.currentTimeMillis();
    }
    Log.d("MicroMsg.GameWebCoreImpl", "loadDataWithBaseURL, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.Iww) });
    if (!this.Iww)
    {
      this.Iwv.q(paramString1, true, true);
      this.Iww = true;
    }
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(277128);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(83166);
    Log.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time : %d, hashCode: %d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    if (this.IwE == null)
    {
      this.IwE = GameWebPerformanceInfo.EI(this.Iwy);
      this.IwE.muf = System.currentTimeMillis();
    }
    Log.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.Iww) });
    if (!this.Iww)
    {
      this.Iwv.q(paramString, true, false);
      this.Iww = true;
    }
    String str = this.Iwv.iEU();
    Log.i("MicroMsg.GameWebCoreImpl", "loadUrl:%s", new Object[] { paramString });
    if (Util.isNullOrNil(str)) {}
    try
    {
      com.tencent.mm.game.report.api.a.mtH.a(5, URLEncoder.encode(paramString), "0", 0L);
      label156:
      super.loadUrl(paramString);
      AppMethodBeat.o(83166);
      return;
      Log.d("MicroMsg.GameWebCoreImpl", "use PageCache:%s", new Object[] { str });
      try
      {
        com.tencent.mm.game.report.api.a.mtH.a(5, URLEncoder.encode(paramString), "1", 0L);
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
    if (this.IwE == null)
    {
      this.IwE = GameWebPerformanceInfo.EI(this.Iwy);
      this.IwE.muf = System.currentTimeMillis();
    }
    Log.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.Iww) });
    if (!this.Iww)
    {
      this.Iwv.q(paramString, true, false);
      this.Iww = true;
    }
    String str = this.Iwv.iEU();
    Log.i("MicroMsg.GameWebCoreImpl", "loadUrl:%s", new Object[] { paramString });
    if (Util.isNullOrNil(str))
    {
      com.tencent.mm.game.report.api.a.mtH.a(5, URLEncoder.encode(paramString), "0", 0L);
      super.loadUrl(paramString, paramMap);
      AppMethodBeat.o(83167);
      return;
    }
    Log.d("MicroMsg.GameWebCoreImpl", "use PageCache:%s", new Object[] { str });
    com.tencent.mm.game.report.api.a.mtH.a(5, URLEncoder.encode(paramString), "1", 0L);
    super.loadDataWithBaseURL(paramString, str, "text/html", "utf-8", null);
    AppMethodBeat.o(83167);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(83156);
    super.onAttachedToWindow();
    Log.i("MicroMsg.GameWebCoreImpl", "onAttachedToWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.IwC = true;
    fEN();
    AppMethodBeat.o(83156);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(83157);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.GameWebCoreImpl", "onDetachedFromWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    removeCallbacks(this.IwJ);
    AppMethodBeat.o(83157);
  }
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(83164);
    Log.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage, blockImg: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.IwA = paramBoolean;
    if (this.Iwz) {
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
    this.Iwy = paramString;
  }
  
  public void setShouldCleanPkgWhenDestroy(boolean paramBoolean)
  {
    this.IwD = paramBoolean;
  }
  
  public final class a
    extends com.tencent.mm.plugin.webview.luggage.f
  {
    public a() {}
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83143);
      Log.i("MicroMsg.GameWebCoreImpl", "onReceivedTitle, title = %s", new Object[] { paramString });
      if (!com.tencent.mm.plugin.webview.luggage.c.c.agu(paramString)) {
        h.a(h.this, paramString);
      }
      super.d(paramWebView, paramString);
      AppMethodBeat.o(83143);
    }
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(83144);
      if (h.this.Iwv != null) {
        h.this.Iwv.a(paramConsoleMessage);
      }
      final String str;
      if (paramConsoleMessage != null)
      {
        str = paramConsoleMessage.message();
        if ((!str.contains("luggage_err")) && (!str.contains("luggageBridge is not defined"))) {
          break label95;
        }
        Log.i("MicroMsg.GameWebCoreImpl", "luggage bridge error");
        h.d(h.this).muq = str;
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
          com.tencent.mm.plugin.webview.ui.tools.game.h.cd(h.e(h.this), l);
          for (;;)
          {
            label157:
            com.tencent.threadpool.h.ahAA.bm(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(277030);
                Log.i("MicroMsg.GameWebCoreImpl", str);
                AppMethodBeat.o(277030);
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
                  com.tencent.mm.plugin.webview.ui.tools.game.h localh = com.tencent.mm.plugin.webview.ui.tools.game.h.bmn(h.e(h.this));
                  if (localh != null)
                  {
                    localh.XgP = (((JSONObject)localObject).optLong("domainLookupEnd") - ((JSONObject)localObject).optLong("domainLookupStart"));
                    localh.XgQ = (((JSONObject)localObject).optLong("connectEnd") - ((JSONObject)localObject).optLong("connectStart"));
                    localh.tVS = (((JSONObject)localObject).optLong("responseEnd") - ((JSONObject)localObject).optLong("requestStart"));
                    localh.XgR = (((JSONObject)localObject).optLong("domInteractive") - ((JSONObject)localObject).optLong("domLoading"));
                    localh.XgT = (((JSONObject)localObject).optLong("domContentLoadedEventEnd") - ((JSONObject)localObject).optLong("responseEnd"));
                    localh.XgU = (((JSONObject)localObject).optLong("domComplete") - ((JSONObject)localObject).optLong("responseEnd"));
                    localh.XgV = ((JSONObject)localObject).optLong("navigationStart");
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
      if (paramWebResourceRequest.getUrl().toString().equals("https://" + WeChatHosts.domainString(j.f.host_game_weixin_qq_com) + "/favicon.ico"))
      {
        paramWebView = new WebResourceResponse("img/png", null, null);
        AppMethodBeat.o(83150);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = h.this.Iwv.a(paramWebView, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest);
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
      if (paramWebResourceRequest.getUrl().toString().equals("https://" + WeChatHosts.domainString(j.f.host_game_weixin_qq_com) + "/favicon.ico"))
      {
        paramWebView = new WebResourceResponse("img/png", null, null);
        AppMethodBeat.o(83151);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = h.this.Iwv.a(paramWebView, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest);
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
      com.tencent.mm.plugin.report.service.h.OAn.p(949L, 1L, 1L);
      AppMethodBeat.o(83152);
    }
    
    public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
    {
      AppMethodBeat.i(83154);
      super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
      Log.e("MicroMsg.GameWebCoreImpl", "onReceivedHttpError， errorCode: %d", new Object[] { Integer.valueOf(paramWebResourceResponse.mStatusCode) });
      h.c(h.this);
      com.tencent.mm.plugin.report.service.h.OAn.p(949L, 3L, 1L);
      AppMethodBeat.o(83154);
    }
    
    public final void a(WebView paramWebView, t paramt, SslError paramSslError)
    {
      AppMethodBeat.i(83153);
      super.a(paramWebView, paramt, paramSslError);
      Log.e("MicroMsg.GameWebCoreImpl", "onReceivedSslError， error: ".concat(String.valueOf(paramSslError)));
      h.c(h.this);
      com.tencent.mm.plugin.report.service.h.OAn.p(949L, 2L, 1L);
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
      h.this.Iwv.bnV(paramString);
      super.b(paramWebView, paramString);
      h.this.b(paramWebView, paramString);
      h.a(h.this);
      AppMethodBeat.o(83146);
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(83145);
      Log.i("MicroMsg.GameWebCoreImpl", "onPageStarted, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      h.this.Iwv.bnU(paramString);
      super.b(paramWebView, paramString, paramBitmap);
      h.this.b(paramWebView, paramString, paramBitmap);
      AppMethodBeat.o(83145);
    }
    
    public final WebResourceResponse c(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83149);
      Log.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramString });
      if (paramString.equals("https://" + WeChatHosts.domainString(j.f.host_game_weixin_qq_com) + "/favicon.ico"))
      {
        paramWebView = new WebResourceResponse("img/png", null, null);
        AppMethodBeat.o(83149);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = h.this.Iwv.a(paramWebView, paramString, null);
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
    
    public final void i(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83147);
      super.i(paramWebView, paramString);
      Log.i("MicroMsg.GameWebCoreImpl", "onLoadResource, url: %s", new Object[] { paramString });
      AppMethodBeat.o(83147);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.page.h
 * JD-Core Version:    0.7.0.1
 */