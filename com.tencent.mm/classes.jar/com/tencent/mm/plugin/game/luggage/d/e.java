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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.z;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  extends com.tencent.mm.plugin.webview.luggage.d.a
{
  private static final Object lock;
  private String mTitle;
  String sWG;
  c sXS;
  boolean sXT;
  Map<String, String> sXU;
  private String sXV;
  private boolean sXW;
  private boolean sXX;
  private boolean sXY;
  private boolean sXZ;
  private boolean sYa;
  private GameWebPerformanceInfo sYb;
  private boolean sYc;
  private Object sYd;
  private Runnable sYe;
  
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
    this.sXT = false;
    this.sXW = false;
    this.sXX = false;
    this.sXY = false;
    this.sXZ = false;
    this.sYa = false;
    this.sYc = false;
    this.sYd = new Object();
    this.sYe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83134);
        synchronized (e.lock)
        {
          if (e.this.getSettings().getBlockNetworkImage())
          {
            ac.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage time out");
            e.this.getSettings().setBlockNetworkImage(false);
            com.tencent.mm.plugin.report.service.h.wUl.n(949L, 0L, 1L);
          }
          AppMethodBeat.o(83134);
          return;
        }
      }
    };
    getSettings().setForceDarkBehavior(1);
    this.sXS = new c();
    ac.i("MicroMsg.GameWebCoreImpl", "create, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(83155);
  }
  
  private void cOP()
  {
    AppMethodBeat.i(83161);
    if ((this.sXY) && (this.sXZ)) {
      postDelayed(this.sYe, 3000L);
    }
    AppMethodBeat.o(83161);
  }
  
  public void AK()
  {
    AppMethodBeat.i(83159);
    super.AK();
    getWebCore().bXv.a(new com.tencent.mm.plugin.game.luggage.b(this));
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
        AppMethodBeat.i(195145);
        e.this.init();
        AppMethodBeat.o(195145);
      }
    });
    AppMethodBeat.o(83158);
  }
  
  protected void b(WebView arg1, String paramString)
  {
    AppMethodBeat.i(83163);
    ac.i("MicroMsg.GameWebCoreImpl", "onPageFinished, blockImg: %b", new Object[] { Boolean.valueOf(this.sXX) });
    if (this.sYb.fZf == 0L)
    {
      this.sYb.fZf = System.currentTimeMillis();
      ac.i("MicroMsg.GameWebCoreImpl", "onPageFinished, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.sYb.fZf) });
    }
    if (com.tencent.mm.plugin.webview.ui.tools.game.h.aDC(this.sXV).CFH == 0L) {
      com.tencent.mm.plugin.webview.ui.tools.game.h.aDC(this.sXV).CFH = System.currentTimeMillis();
    }
    synchronized (lock)
    {
      getSettings().setBlockNetworkImage(this.sXX);
      this.sXW = true;
      if (this.sYb.fZc == 0L) {
        this.sYb.fZc = System.currentTimeMillis();
      }
      AppMethodBeat.o(83163);
      return;
    }
  }
  
  protected void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(83162);
    this.sXY = true;
    cOP();
    if (this.sYb.fZe == 0L)
    {
      this.sYb.fZe = System.currentTimeMillis();
      ac.i("MicroMsg.GameWebCoreImpl", "onPageStarted, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.sYb.fZe) });
    }
    if (com.tencent.mm.plugin.webview.ui.tools.game.h.aDC(this.sXV).CFG == 0L) {
      com.tencent.mm.plugin.webview.ui.tools.game.h.aDC(this.sXV).CFG = System.currentTimeMillis();
    }
    AppMethodBeat.o(83162);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(83165);
    this.sXS.uO(this.sYa);
    super.destroy();
    AppMethodBeat.o(83165);
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public c getWePkgPlugin()
  {
    return this.sXS;
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
    ac.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time : %d, hashCode: %d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    if (this.sYb == null)
    {
      this.sYb = GameWebPerformanceInfo.tq(this.sXV);
      this.sYb.fZd = System.currentTimeMillis();
    }
    ac.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.sXT) });
    if (!this.sXT)
    {
      this.sXS.cq(paramString, true);
      this.sXT = true;
    }
    String str = this.sXS.eIK();
    ac.i("MicroMsg.GameWebCoreImpl", "loadUrl:%s", new Object[] { paramString });
    if (bs.isNullOrNil(str)) {}
    try
    {
      com.tencent.mm.game.report.api.a.fYF.a(5, URLEncoder.encode(paramString), "0", 0L);
      label155:
      super.loadUrl(paramString);
      AppMethodBeat.o(83166);
      return;
      ac.d("MicroMsg.GameWebCoreImpl", "use PageCache:%s", new Object[] { str });
      try
      {
        com.tencent.mm.game.report.api.a.fYF.a(5, URLEncoder.encode(paramString), "1", 0L);
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
    ac.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time: %d， HEADER", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.sYb == null)
    {
      this.sYb = GameWebPerformanceInfo.tq(this.sXV);
      this.sYb.fZd = System.currentTimeMillis();
    }
    ac.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.sXT) });
    if (!this.sXT)
    {
      this.sXS.cq(paramString, true);
      this.sXT = true;
    }
    String str = this.sXS.eIK();
    ac.i("MicroMsg.GameWebCoreImpl", "loadUrl:%s", new Object[] { paramString });
    if (bs.isNullOrNil(str))
    {
      com.tencent.mm.game.report.api.a.fYF.a(5, URLEncoder.encode(paramString), "0", 0L);
      super.loadUrl(paramString, paramMap);
      AppMethodBeat.o(83167);
      return;
    }
    ac.d("MicroMsg.GameWebCoreImpl", "use PageCache:%s", new Object[] { str });
    com.tencent.mm.game.report.api.a.fYF.a(5, URLEncoder.encode(paramString), "1", 0L);
    super.loadDataWithBaseURL(paramString, str, "text/html", "utf-8", null);
    AppMethodBeat.o(83167);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(83156);
    super.onAttachedToWindow();
    ac.i("MicroMsg.GameWebCoreImpl", "onAttachedToWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.sXZ = true;
    cOP();
    AppMethodBeat.o(83156);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(83157);
    super.onDetachedFromWindow();
    ac.i("MicroMsg.GameWebCoreImpl", "onDetachedFromWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    removeCallbacks(this.sYe);
    AppMethodBeat.o(83157);
  }
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(83164);
    ac.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage, blockImg: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.sXX = paramBoolean;
    if (this.sXW) {
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
    this.sXV = paramString;
  }
  
  public void setShouldCleanPkgWhenDestroy(boolean paramBoolean)
  {
    this.sYa = paramBoolean;
  }
  
  public final class a
    extends com.tencent.mm.plugin.webview.luggage.e
  {
    public a() {}
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83143);
      ac.i("MicroMsg.GameWebCoreImpl", "onReceivedTitle, title = %s", new Object[] { paramString });
      if (!com.tencent.mm.plugin.webview.luggage.c.b.Rp(paramString)) {
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
        ac.i("MicroMsg.GameWebCoreImpl", "luggage bridge error");
        e.c(e.this).fZo = str;
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
          com.tencent.mm.plugin.webview.ui.tools.game.h.bG(e.d(e.this), l);
          for (;;)
          {
            label157:
            ac.i("MicroMsg.GameWebCoreImpl", str);
            break;
            if (str.contains("timing"))
            {
              localObject = str.replaceFirst("WXGAMEPERF:", "").trim();
              try
              {
                localObject = new JSONObject((String)localObject).optJSONObject("timing");
                if (localObject != null)
                {
                  com.tencent.mm.plugin.webview.ui.tools.game.h localh = com.tencent.mm.plugin.webview.ui.tools.game.h.aDD(e.d(e.this));
                  if (localh != null)
                  {
                    localh.CFO = (((JSONObject)localObject).optLong("domainLookupEnd") - ((JSONObject)localObject).optLong("domainLookupStart"));
                    localh.CFP = (((JSONObject)localObject).optLong("connectEnd") - ((JSONObject)localObject).optLong("connectStart"));
                    localh.lXu = (((JSONObject)localObject).optLong("responseEnd") - ((JSONObject)localObject).optLong("requestStart"));
                    localh.CFQ = (((JSONObject)localObject).optLong("domInteractive") - ((JSONObject)localObject).optLong("domLoading"));
                    localh.CFS = (((JSONObject)localObject).optLong("domContentLoadedEventEnd") - ((JSONObject)localObject).optLong("responseEnd"));
                    localh.CFT = (((JSONObject)localObject).optLong("domComplete") - ((JSONObject)localObject).optLong("responseEnd"));
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
      ac.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramWebResourceRequest.getUrl().toString() });
      if (paramWebResourceRequest.getUrl().toString().equals("https://game.weixin.qq.com/favicon.ico"))
      {
        paramWebView = new WebResourceResponse("img/png", null, null);
        AppMethodBeat.o(83150);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = e.a(e.this).aET(paramWebResourceRequest.getUrl().toString());
      if (localWebResourceResponse != null)
      {
        ac.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
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
      ac.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramWebResourceRequest.getUrl().toString() });
      if (paramWebResourceRequest.getUrl().toString().equals("https://game.weixin.qq.com/favicon.ico"))
      {
        paramWebView = new WebResourceResponse("img/png", null, null);
        AppMethodBeat.o(83151);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = e.a(e.this).aET(paramWebResourceRequest.getUrl().toString());
      if (localWebResourceResponse != null)
      {
        ac.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
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
      ac.e("MicroMsg.GameWebCoreImpl", "onReceivedError, desc: %s, url: %s", new Object[] { paramString1, paramString2 });
      com.tencent.mm.plugin.report.service.h.wUl.n(949L, 1L, 1L);
      AppMethodBeat.o(83152);
    }
    
    public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
    {
      AppMethodBeat.i(83154);
      super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
      ac.e("MicroMsg.GameWebCoreImpl", "onReceivedHttpError， errorCode: %d", new Object[] { Integer.valueOf(paramWebResourceResponse.mStatusCode) });
      com.tencent.mm.plugin.report.service.h.wUl.n(949L, 3L, 1L);
      AppMethodBeat.o(83154);
    }
    
    public final void a(WebView paramWebView, r paramr, SslError paramSslError)
    {
      AppMethodBeat.i(83153);
      super.a(paramWebView, paramr, paramSslError);
      ac.e("MicroMsg.GameWebCoreImpl", "onReceivedSslError， error: ".concat(String.valueOf(paramSslError)));
      com.tencent.mm.plugin.report.service.h.wUl.n(949L, 2L, 1L);
      AppMethodBeat.o(83153);
    }
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83148);
      ac.i("MicroMsg.GameWebCoreImpl", "shouldOverrideUrlLoading, url: %s", new Object[] { paramString });
      if (DownloadChecker.a(paramString, e.b(e.this), paramWebView))
      {
        ac.i("MicroMsg.GameWebCoreImpl", "use the downloader to download");
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
      ac.i("MicroMsg.GameWebCoreImpl", "onPageFinished, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      e.a(e.this).p(paramWebView, paramString);
      super.b(paramWebView, paramString);
      e.this.b(paramWebView, paramString);
      AppMethodBeat.o(83146);
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(83145);
      ac.i("MicroMsg.GameWebCoreImpl", "onPageStarted, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      e.a(e.this).o(paramWebView, paramString);
      super.b(paramWebView, paramString, paramBitmap);
      e.this.b(paramWebView, paramString, paramBitmap);
      AppMethodBeat.o(83145);
    }
    
    public final WebResourceResponse c(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83149);
      ac.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramString });
      if (paramString.equals("https://game.weixin.qq.com/favicon.ico"))
      {
        paramWebView = new WebResourceResponse("img/png", null, null);
        AppMethodBeat.o(83149);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = e.a(e.this).aET(paramString);
      if (localWebResourceResponse != null)
      {
        ac.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
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
      ac.i("MicroMsg.GameWebCoreImpl", "onLoadResource, url: %s", new Object[] { paramString });
      c localc = e.a(e.this);
      if ((!localc.CZB) && (!c.bP(paramString)))
      {
        localc.b(paramWebView, localc.aEU(localc.sXV));
        localc.CZB = true;
      }
      AppMethodBeat.o(83147);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.e
 * JD-Core Version:    0.7.0.1
 */