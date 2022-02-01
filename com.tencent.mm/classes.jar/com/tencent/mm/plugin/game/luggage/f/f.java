package com.tencent.mm.plugin.game.luggage.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import com.tencent.e.h;
import com.tencent.luggage.d.p;
import com.tencent.luggage.webview.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.game.luggage.c;
import com.tencent.mm.plugin.wepkg.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.z;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class f
  extends com.tencent.mm.plugin.webview.luggage.d.a
{
  private static final Object lock;
  private String mTitle;
  String uee;
  protected d ufZ;
  private boolean uga;
  Map<String, String> ugb;
  private String ugc;
  private boolean ugd;
  private boolean uge;
  private boolean ugf;
  private boolean ugg;
  private boolean ugh;
  private GameWebPerformanceInfo ugi;
  private boolean ugj;
  private Object ugk;
  private Runnable ugl;
  
  static
  {
    AppMethodBeat.i(83171);
    lock = new Object();
    AppMethodBeat.o(83171);
  }
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(83155);
    this.uga = false;
    this.ugd = false;
    this.uge = false;
    this.ugf = false;
    this.ugg = false;
    this.ugh = false;
    this.ugj = false;
    this.ugk = new Object();
    this.ugl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83134);
        synchronized (f.lock)
        {
          if (f.this.getSettings().getBlockNetworkImage())
          {
            ae.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage time out");
            f.this.getSettings().setBlockNetworkImage(false);
            com.tencent.mm.plugin.report.service.g.yxI.n(949L, 0L, 1L);
          }
          AppMethodBeat.o(83134);
          return;
        }
      }
    };
    getSettings().setForceDarkBehavior(1);
    this.ufZ = new d();
    ae.i("MicroMsg.GameWebCoreImpl", "create, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(83155);
  }
  
  private void dac()
  {
    AppMethodBeat.i(83161);
    if ((this.ugf) && (this.ugg)) {
      postDelayed(this.ugl, 3000L);
    }
    AppMethodBeat.o(83161);
  }
  
  public void Cn()
  {
    AppMethodBeat.i(83159);
    super.Cn();
    getWebCore().chR.a(new c(this));
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
        AppMethodBeat.i(193068);
        f.this.init();
        AppMethodBeat.o(193068);
      }
    });
    AppMethodBeat.o(83158);
  }
  
  public final boolean amu(String paramString)
  {
    AppMethodBeat.i(83168);
    ae.d("MicroMsg.GameWebCoreImpl", "isWebCacheUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.uga) });
    if (!this.uga)
    {
      this.ufZ.k(paramString, true, false);
      this.uga = true;
    }
    boolean bool = this.ufZ.aLQ(paramString);
    AppMethodBeat.o(83168);
    return bool;
  }
  
  protected void b(WebView arg1, String paramString)
  {
    AppMethodBeat.i(83163);
    ae.i("MicroMsg.GameWebCoreImpl", "onPageFinished, blockImg: %b", new Object[] { Boolean.valueOf(this.uge) });
    if (this.ugi.gvc == 0L)
    {
      this.ugi.gvc = System.currentTimeMillis();
      ae.i("MicroMsg.GameWebCoreImpl", "onPageFinished, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.ugi.gvc) });
    }
    if (com.tencent.mm.plugin.webview.ui.tools.game.g.aKw(this.ugc).EBw == 0L) {
      com.tencent.mm.plugin.webview.ui.tools.game.g.aKw(this.ugc).EBw = System.currentTimeMillis();
    }
    synchronized (lock)
    {
      getSettings().setBlockNetworkImage(this.uge);
      this.ugd = true;
      if (this.ugi.guZ == 0L) {
        this.ugi.guZ = System.currentTimeMillis();
      }
      AppMethodBeat.o(83163);
      return;
    }
  }
  
  protected void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(83162);
    this.ugf = true;
    dac();
    if (this.ugi.gvb == 0L)
    {
      this.ugi.gvb = System.currentTimeMillis();
      ae.i("MicroMsg.GameWebCoreImpl", "onPageStarted, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.ugi.gvb) });
    }
    if (com.tencent.mm.plugin.webview.ui.tools.game.g.aKw(this.ugc).EBv == 0L) {
      com.tencent.mm.plugin.webview.ui.tools.game.g.aKw(this.ugc).EBv = System.currentTimeMillis();
    }
    AppMethodBeat.o(83162);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(83165);
    this.ufZ.vI(this.ugh);
    super.destroy();
    AppMethodBeat.o(83165);
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public d getWePkgPlugin()
  {
    return this.ufZ;
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
    AppMethodBeat.i(193070);
    if (this.ugi == null)
    {
      this.ugi = GameWebPerformanceInfo.wP(paramString1);
      this.ugi.gva = System.currentTimeMillis();
    }
    ae.d("MicroMsg.GameWebCoreImpl", "loadDataWithBaseURL, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.uga) });
    if (!this.uga)
    {
      this.ufZ.k(paramString1, true, true);
      this.uga = true;
    }
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(193070);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(83166);
    ae.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time : %d, hashCode: %d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    if (this.ugi == null)
    {
      this.ugi = GameWebPerformanceInfo.wP(this.ugc);
      this.ugi.gva = System.currentTimeMillis();
    }
    ae.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.uga) });
    if (!this.uga)
    {
      this.ufZ.k(paramString, true, false);
      this.uga = true;
    }
    String str = this.ufZ.fbp();
    ae.i("MicroMsg.GameWebCoreImpl", "loadUrl:%s", new Object[] { paramString });
    if (bu.isNullOrNil(str)) {}
    try
    {
      com.tencent.mm.game.report.api.a.guC.a(5, URLEncoder.encode(paramString), "0", 0L);
      label156:
      super.loadUrl(paramString);
      AppMethodBeat.o(83166);
      return;
      ae.d("MicroMsg.GameWebCoreImpl", "use PageCache:%s", new Object[] { str });
      try
      {
        com.tencent.mm.game.report.api.a.guC.a(5, URLEncoder.encode(paramString), "1", 0L);
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
    ae.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time: %d， HEADER", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.ugi == null)
    {
      this.ugi = GameWebPerformanceInfo.wP(this.ugc);
      this.ugi.gva = System.currentTimeMillis();
    }
    ae.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.uga) });
    if (!this.uga)
    {
      this.ufZ.k(paramString, true, false);
      this.uga = true;
    }
    String str = this.ufZ.fbp();
    ae.i("MicroMsg.GameWebCoreImpl", "loadUrl:%s", new Object[] { paramString });
    if (bu.isNullOrNil(str))
    {
      com.tencent.mm.game.report.api.a.guC.a(5, URLEncoder.encode(paramString), "0", 0L);
      super.loadUrl(paramString, paramMap);
      AppMethodBeat.o(83167);
      return;
    }
    ae.d("MicroMsg.GameWebCoreImpl", "use PageCache:%s", new Object[] { str });
    com.tencent.mm.game.report.api.a.guC.a(5, URLEncoder.encode(paramString), "1", 0L);
    super.loadDataWithBaseURL(paramString, str, "text/html", "utf-8", null);
    AppMethodBeat.o(83167);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(83156);
    super.onAttachedToWindow();
    ae.i("MicroMsg.GameWebCoreImpl", "onAttachedToWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.ugg = true;
    dac();
    AppMethodBeat.o(83156);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(83157);
    super.onDetachedFromWindow();
    ae.i("MicroMsg.GameWebCoreImpl", "onDetachedFromWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    removeCallbacks(this.ugl);
    AppMethodBeat.o(83157);
  }
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(83164);
    ae.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage, blockImg: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.uge = paramBoolean;
    if (this.ugd) {
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
    this.ugc = paramString;
  }
  
  public void setShouldCleanPkgWhenDestroy(boolean paramBoolean)
  {
    this.ugh = paramBoolean;
  }
  
  public final class a
    extends com.tencent.mm.plugin.webview.luggage.f
  {
    public a() {}
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83143);
      ae.i("MicroMsg.GameWebCoreImpl", "onReceivedTitle, title = %s", new Object[] { paramString });
      if (!com.tencent.mm.plugin.webview.luggage.c.b.VG(paramString)) {
        f.a(f.this, paramString);
      }
      super.d(paramWebView, paramString);
      AppMethodBeat.o(83143);
    }
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(83144);
      if (f.this.ufZ != null) {
        f.this.ufZ.a(paramConsoleMessage);
      }
      if (paramConsoleMessage != null) {}
      for (final String str = paramConsoleMessage.message();; str = "")
      {
        h.MqF.aO(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193069);
            if ((str.contains("luggage_err")) || (str.contains("luggageBridge is not defined")))
            {
              ae.i("MicroMsg.GameWebCoreImpl", "luggage bridge error");
              f.b(f.this).gvl = str;
              AppMethodBeat.o(193069);
              return;
            }
            Object localObject;
            if (str.startsWith("WXGAMEPERF:"))
            {
              if (!str.contains("first-contentful-paint")) {
                break label143;
              }
              localObject = str.replaceFirst("WXGAMEPERF:", "").trim();
            }
            try
            {
              long l = new JSONObject((String)localObject).optDouble("startTime", 0.0D);
              com.tencent.mm.plugin.webview.ui.tools.game.g.bK(f.c(f.this), l);
              for (;;)
              {
                label128:
                ae.i("MicroMsg.GameWebCoreImpl", str);
                AppMethodBeat.o(193069);
                return;
                label143:
                if (str.contains("timing"))
                {
                  localObject = str.replaceFirst("WXGAMEPERF:", "").trim();
                  try
                  {
                    localObject = new JSONObject((String)localObject).optJSONObject("timing");
                    if (localObject != null)
                    {
                      com.tencent.mm.plugin.webview.ui.tools.game.g localg = com.tencent.mm.plugin.webview.ui.tools.game.g.aKx(f.c(f.this));
                      if (localg != null)
                      {
                        localg.EBD = (((JSONObject)localObject).optLong("domainLookupEnd") - ((JSONObject)localObject).optLong("domainLookupStart"));
                        localg.EBE = (((JSONObject)localObject).optLong("connectEnd") - ((JSONObject)localObject).optLong("connectStart"));
                        localg.mCg = (((JSONObject)localObject).optLong("responseEnd") - ((JSONObject)localObject).optLong("requestStart"));
                        localg.EBF = (((JSONObject)localObject).optLong("domInteractive") - ((JSONObject)localObject).optLong("domLoading"));
                        localg.EBH = (((JSONObject)localObject).optLong("domContentLoadedEventEnd") - ((JSONObject)localObject).optLong("responseEnd"));
                        localg.EBI = (((JSONObject)localObject).optLong("domComplete") - ((JSONObject)localObject).optLong("responseEnd"));
                        localg.EBJ = ((JSONObject)localObject).optLong("navigationStart");
                      }
                    }
                  }
                  catch (Exception localException) {}
                }
              }
            }
            catch (JSONException localJSONException)
            {
              break label128;
            }
          }
        });
        boolean bool = super.onConsoleMessage(paramConsoleMessage);
        AppMethodBeat.o(83144);
        return bool;
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
      ae.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramWebResourceRequest.getUrl().toString() });
      if (paramWebResourceRequest.getUrl().toString().equals("https://game.weixin.qq.com/favicon.ico"))
      {
        paramWebView = new WebResourceResponse("img/png", null, null);
        AppMethodBeat.o(83150);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = f.this.ufZ.p(paramWebView, paramWebResourceRequest.getUrl().toString());
      if (localWebResourceResponse != null)
      {
        ae.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
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
      ae.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramWebResourceRequest.getUrl().toString() });
      if (paramWebResourceRequest.getUrl().toString().equals("https://game.weixin.qq.com/favicon.ico"))
      {
        paramWebView = new WebResourceResponse("img/png", null, null);
        AppMethodBeat.o(83151);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = f.this.ufZ.p(paramWebView, paramWebResourceRequest.getUrl().toString());
      if (localWebResourceResponse != null)
      {
        ae.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
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
      ae.e("MicroMsg.GameWebCoreImpl", "onReceivedError, desc: %s, url: %s", new Object[] { paramString1, paramString2 });
      com.tencent.mm.plugin.report.service.g.yxI.n(949L, 1L, 1L);
      AppMethodBeat.o(83152);
    }
    
    public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
    {
      AppMethodBeat.i(83154);
      super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
      ae.e("MicroMsg.GameWebCoreImpl", "onReceivedHttpError， errorCode: %d", new Object[] { Integer.valueOf(paramWebResourceResponse.mStatusCode) });
      com.tencent.mm.plugin.report.service.g.yxI.n(949L, 3L, 1L);
      AppMethodBeat.o(83154);
    }
    
    public final void a(WebView paramWebView, r paramr, SslError paramSslError)
    {
      AppMethodBeat.i(83153);
      super.a(paramWebView, paramr, paramSslError);
      ae.e("MicroMsg.GameWebCoreImpl", "onReceivedSslError， error: ".concat(String.valueOf(paramSslError)));
      com.tencent.mm.plugin.report.service.g.yxI.n(949L, 2L, 1L);
      AppMethodBeat.o(83153);
    }
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83148);
      ae.i("MicroMsg.GameWebCoreImpl", "shouldOverrideUrlLoading, url: %s", new Object[] { paramString });
      if (DownloadChecker.a(paramString, f.a(f.this), paramWebView))
      {
        ae.i("MicroMsg.GameWebCoreImpl", "use the downloader to download");
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
      ae.i("MicroMsg.GameWebCoreImpl", "onPageFinished, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      f.this.ufZ.o(paramWebView, paramString);
      super.b(paramWebView, paramString);
      f.this.b(paramWebView, paramString);
      AppMethodBeat.o(83146);
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(83145);
      ae.i("MicroMsg.GameWebCoreImpl", "onPageStarted, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      f.this.ufZ.aLP(paramString);
      super.b(paramWebView, paramString, paramBitmap);
      f.this.b(paramWebView, paramString, paramBitmap);
      AppMethodBeat.o(83145);
    }
    
    public final WebResourceResponse c(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83149);
      ae.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramString });
      if (paramString.equals("https://game.weixin.qq.com/favicon.ico"))
      {
        paramWebView = new WebResourceResponse("img/png", null, null);
        AppMethodBeat.o(83149);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = f.this.ufZ.p(paramWebView, paramString);
      if (localWebResourceResponse != null)
      {
        ae.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
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
      ae.i("MicroMsg.GameWebCoreImpl", "onLoadResource, url: %s", new Object[] { paramString });
      AppMethodBeat.o(83147);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f.f
 * JD-Core Version:    0.7.0.1
 */