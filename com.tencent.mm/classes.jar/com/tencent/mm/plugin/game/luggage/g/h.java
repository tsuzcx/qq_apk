package com.tencent.mm.plugin.game.luggage.g;

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
import com.tencent.xweb.aa;
import com.tencent.xweb.r;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends com.tencent.mm.plugin.webview.luggage.d.a
{
  private static final Object lock;
  private boolean CCA;
  private boolean CCB;
  private boolean CCC;
  private GameWebPerformanceInfo CCD;
  private boolean CCE;
  private Object CCF;
  private boolean CCG;
  private boolean CCH;
  private Runnable CCI;
  protected com.tencent.mm.plugin.wepkg.f CCu;
  private boolean CCv;
  Map<String, String> CCw;
  private String CCx;
  private boolean CCy;
  private boolean CCz;
  String CzZ;
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
    this.CCv = false;
    this.CCy = false;
    this.CCz = false;
    this.CCA = false;
    this.CCB = false;
    this.CCC = false;
    this.CCE = false;
    this.CCF = new Object();
    this.CCG = false;
    this.CCH = false;
    this.CCI = new Runnable()
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
            com.tencent.mm.plugin.report.service.h.IzE.p(949L, 0L, 1L);
          }
          AppMethodBeat.o(83134);
          return;
        }
      }
    };
    getSettings().setForceDarkBehavior(1);
    this.CCu = new com.tencent.mm.plugin.wepkg.f();
    Log.i("MicroMsg.GameWebCoreImpl", "create, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(83155);
  }
  
  private void ewS()
  {
    AppMethodBeat.i(83161);
    if ((this.CCA) && (this.CCB)) {
      postDelayed(this.CCI, 3000L);
    }
    AppMethodBeat.o(83161);
  }
  
  public void Ou()
  {
    AppMethodBeat.i(83159);
    super.Ou();
    getWebCore().crR.a(new com.tencent.mm.plugin.game.luggage.c(this));
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
        AppMethodBeat.i(231445);
        h.this.init();
        AppMethodBeat.o(231445);
      }
    });
    AppMethodBeat.o(83158);
  }
  
  public final boolean aJv(String paramString)
  {
    AppMethodBeat.i(83168);
    Log.d("MicroMsg.GameWebCoreImpl", "isWebCacheUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.CCv) });
    if (!this.CCv)
    {
      this.CCu.m(paramString, true, false);
      this.CCv = true;
    }
    boolean bool = this.CCu.boi(paramString);
    AppMethodBeat.o(83168);
    return bool;
  }
  
  protected void b(WebView arg1, String paramString)
  {
    AppMethodBeat.i(83163);
    Log.i("MicroMsg.GameWebCoreImpl", "onPageFinished, blockImg: %b", new Object[] { Boolean.valueOf(this.CCz) });
    if (this.CCD.jTP == 0L)
    {
      this.CCD.jTP = System.currentTimeMillis();
      Log.i("MicroMsg.GameWebCoreImpl", "onPageFinished, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.CCD.jTP) });
    }
    if (com.tencent.mm.plugin.webview.ui.tools.game.h.bmI(this.CCx).Qou == 0L) {
      com.tencent.mm.plugin.webview.ui.tools.game.h.bmI(this.CCx).Qou = System.currentTimeMillis();
    }
    synchronized (lock)
    {
      getSettings().setBlockNetworkImage(this.CCz);
      this.CCy = true;
      if (this.CCD.jTM == 0L) {
        this.CCD.jTM = System.currentTimeMillis();
      }
      AppMethodBeat.o(83163);
      return;
    }
  }
  
  protected void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(83162);
    this.CCA = true;
    ewS();
    if (this.CCD.jTO == 0L)
    {
      this.CCD.jTO = System.currentTimeMillis();
      Log.i("MicroMsg.GameWebCoreImpl", "onPageStarted, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.CCD.jTO) });
    }
    if (com.tencent.mm.plugin.webview.ui.tools.game.h.bmI(this.CCx).Qot == 0L) {
      com.tencent.mm.plugin.webview.ui.tools.game.h.bmI(this.CCx).Qot = System.currentTimeMillis();
    }
    AppMethodBeat.o(83162);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(83165);
    this.CCu.DD(this.CCC);
    super.destroy();
    AppMethodBeat.o(83165);
  }
  
  public final boolean ewT()
  {
    return (this.CCy) && (!this.CCG);
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public com.tencent.mm.plugin.wepkg.f getWePkgPlugin()
  {
    return this.CCu;
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
    AppMethodBeat.i(231845);
    if (this.CCD == null)
    {
      this.CCD = GameWebPerformanceInfo.LZ(paramString1);
      this.CCD.jTN = System.currentTimeMillis();
    }
    Log.d("MicroMsg.GameWebCoreImpl", "loadDataWithBaseURL, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.CCv) });
    if (!this.CCv)
    {
      this.CCu.m(paramString1, true, true);
      this.CCv = true;
    }
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(231845);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(83166);
    Log.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time : %d, hashCode: %d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    if (this.CCD == null)
    {
      this.CCD = GameWebPerformanceInfo.LZ(this.CCx);
      this.CCD.jTN = System.currentTimeMillis();
    }
    Log.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.CCv) });
    if (!this.CCv)
    {
      this.CCu.m(paramString, true, false);
      this.CCv = true;
    }
    String str = this.CCu.hem();
    Log.i("MicroMsg.GameWebCoreImpl", "loadUrl:%s", new Object[] { paramString });
    if (Util.isNullOrNil(str)) {}
    try
    {
      com.tencent.mm.game.report.api.a.jTp.a(5, URLEncoder.encode(paramString), "0", 0L);
      label156:
      super.loadUrl(paramString);
      AppMethodBeat.o(83166);
      return;
      Log.d("MicroMsg.GameWebCoreImpl", "use PageCache:%s", new Object[] { str });
      try
      {
        com.tencent.mm.game.report.api.a.jTp.a(5, URLEncoder.encode(paramString), "1", 0L);
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
    if (this.CCD == null)
    {
      this.CCD = GameWebPerformanceInfo.LZ(this.CCx);
      this.CCD.jTN = System.currentTimeMillis();
    }
    Log.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.CCv) });
    if (!this.CCv)
    {
      this.CCu.m(paramString, true, false);
      this.CCv = true;
    }
    String str = this.CCu.hem();
    Log.i("MicroMsg.GameWebCoreImpl", "loadUrl:%s", new Object[] { paramString });
    if (Util.isNullOrNil(str))
    {
      com.tencent.mm.game.report.api.a.jTp.a(5, URLEncoder.encode(paramString), "0", 0L);
      super.loadUrl(paramString, paramMap);
      AppMethodBeat.o(83167);
      return;
    }
    Log.d("MicroMsg.GameWebCoreImpl", "use PageCache:%s", new Object[] { str });
    com.tencent.mm.game.report.api.a.jTp.a(5, URLEncoder.encode(paramString), "1", 0L);
    super.loadDataWithBaseURL(paramString, str, "text/html", "utf-8", null);
    AppMethodBeat.o(83167);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(83156);
    super.onAttachedToWindow();
    Log.i("MicroMsg.GameWebCoreImpl", "onAttachedToWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.CCB = true;
    ewS();
    AppMethodBeat.o(83156);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(83157);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.GameWebCoreImpl", "onDetachedFromWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    removeCallbacks(this.CCI);
    AppMethodBeat.o(83157);
  }
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(83164);
    Log.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage, blockImg: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.CCz = paramBoolean;
    if (this.CCy) {
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
    this.CCx = paramString;
  }
  
  public void setShouldCleanPkgWhenDestroy(boolean paramBoolean)
  {
    this.CCC = paramBoolean;
  }
  
  public final class a
    extends com.tencent.mm.plugin.webview.luggage.f
  {
    public a() {}
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83143);
      Log.i("MicroMsg.GameWebCoreImpl", "onReceivedTitle, title = %s", new Object[] { paramString });
      if (!com.tencent.mm.plugin.webview.luggage.c.c.ane(paramString)) {
        h.a(h.this, paramString);
      }
      super.d(paramWebView, paramString);
      AppMethodBeat.o(83143);
    }
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(83144);
      if (h.this.CCu != null) {
        h.this.CCu.a(paramConsoleMessage);
      }
      final String str;
      if (paramConsoleMessage != null)
      {
        str = paramConsoleMessage.message();
        if ((!str.contains("luggage_err")) && (!str.contains("luggageBridge is not defined"))) {
          break label95;
        }
        Log.i("MicroMsg.GameWebCoreImpl", "luggage bridge error");
        h.d(h.this).jTY = str;
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
          com.tencent.mm.plugin.webview.ui.tools.game.h.bS(h.e(h.this), l);
          for (;;)
          {
            label157:
            com.tencent.e.h.ZvG.be(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(231739);
                Log.i("MicroMsg.GameWebCoreImpl", str);
                AppMethodBeat.o(231739);
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
                  com.tencent.mm.plugin.webview.ui.tools.game.h localh = com.tencent.mm.plugin.webview.ui.tools.game.h.bmJ(h.e(h.this));
                  if (localh != null)
                  {
                    localh.QoB = (((JSONObject)localObject).optLong("domainLookupEnd") - ((JSONObject)localObject).optLong("domainLookupStart"));
                    localh.QoC = (((JSONObject)localObject).optLong("connectEnd") - ((JSONObject)localObject).optLong("connectStart"));
                    localh.qRk = (((JSONObject)localObject).optLong("responseEnd") - ((JSONObject)localObject).optLong("requestStart"));
                    localh.QoD = (((JSONObject)localObject).optLong("domInteractive") - ((JSONObject)localObject).optLong("domLoading"));
                    localh.QoF = (((JSONObject)localObject).optLong("domContentLoadedEventEnd") - ((JSONObject)localObject).optLong("responseEnd"));
                    localh.QoG = (((JSONObject)localObject).optLong("domComplete") - ((JSONObject)localObject).optLong("responseEnd"));
                    localh.QoH = ((JSONObject)localObject).optLong("navigationStart");
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
      WebResourceResponse localWebResourceResponse = h.this.CCu.a(paramWebView, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest);
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
      WebResourceResponse localWebResourceResponse = h.this.CCu.a(paramWebView, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest);
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
      com.tencent.mm.plugin.report.service.h.IzE.p(949L, 1L, 1L);
      AppMethodBeat.o(83152);
    }
    
    public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
    {
      AppMethodBeat.i(83154);
      super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
      Log.e("MicroMsg.GameWebCoreImpl", "onReceivedHttpError， errorCode: %d", new Object[] { Integer.valueOf(paramWebResourceResponse.mStatusCode) });
      h.c(h.this);
      com.tencent.mm.plugin.report.service.h.IzE.p(949L, 3L, 1L);
      AppMethodBeat.o(83154);
    }
    
    public final void a(WebView paramWebView, r paramr, SslError paramSslError)
    {
      AppMethodBeat.i(83153);
      super.a(paramWebView, paramr, paramSslError);
      Log.e("MicroMsg.GameWebCoreImpl", "onReceivedSslError， error: ".concat(String.valueOf(paramSslError)));
      h.c(h.this);
      com.tencent.mm.plugin.report.service.h.IzE.p(949L, 2L, 1L);
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
      h.this.CCu.boh(paramString);
      super.b(paramWebView, paramString);
      h.this.b(paramWebView, paramString);
      h.a(h.this);
      AppMethodBeat.o(83146);
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(83145);
      Log.i("MicroMsg.GameWebCoreImpl", "onPageStarted, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      h.this.CCu.bog(paramString);
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
      WebResourceResponse localWebResourceResponse = h.this.CCu.a(paramWebView, paramString, null);
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
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.h
 * JD-Core Version:    0.7.0.1
 */