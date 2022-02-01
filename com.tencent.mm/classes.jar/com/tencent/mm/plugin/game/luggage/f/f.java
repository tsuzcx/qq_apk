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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  String tTn;
  protected d tVd;
  private boolean tVe;
  Map<String, String> tVf;
  private String tVg;
  private boolean tVh;
  private boolean tVi;
  private boolean tVj;
  private boolean tVk;
  private boolean tVl;
  private GameWebPerformanceInfo tVm;
  private boolean tVn;
  private Object tVo;
  private Runnable tVp;
  
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
    this.tVe = false;
    this.tVh = false;
    this.tVi = false;
    this.tVj = false;
    this.tVk = false;
    this.tVl = false;
    this.tVn = false;
    this.tVo = new Object();
    this.tVp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83134);
        synchronized (f.lock)
        {
          if (f.this.getSettings().getBlockNetworkImage())
          {
            ad.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage time out");
            f.this.getSettings().setBlockNetworkImage(false);
            com.tencent.mm.plugin.report.service.g.yhR.n(949L, 0L, 1L);
          }
          AppMethodBeat.o(83134);
          return;
        }
      }
    };
    getSettings().setForceDarkBehavior(1);
    this.tVd = new d();
    ad.i("MicroMsg.GameWebCoreImpl", "create, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(83155);
  }
  
  private void cXs()
  {
    AppMethodBeat.i(83161);
    if ((this.tVj) && (this.tVk)) {
      postDelayed(this.tVp, 3000L);
    }
    AppMethodBeat.o(83161);
  }
  
  public void Ck()
  {
    AppMethodBeat.i(83159);
    super.Ck();
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
        AppMethodBeat.i(211673);
        f.this.init();
        AppMethodBeat.o(211673);
      }
    });
    AppMethodBeat.o(83158);
  }
  
  public final boolean alw(String paramString)
  {
    AppMethodBeat.i(83168);
    ad.d("MicroMsg.GameWebCoreImpl", "isWebCacheUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.tVe) });
    if (!this.tVe)
    {
      this.tVd.k(paramString, true, false);
      this.tVe = true;
    }
    boolean bool = this.tVd.aKu(paramString);
    AppMethodBeat.o(83168);
    return bool;
  }
  
  protected void b(WebView arg1, String paramString)
  {
    AppMethodBeat.i(83163);
    ad.i("MicroMsg.GameWebCoreImpl", "onPageFinished, blockImg: %b", new Object[] { Boolean.valueOf(this.tVi) });
    if (this.tVm.gsB == 0L)
    {
      this.tVm.gsB = System.currentTimeMillis();
      ad.i("MicroMsg.GameWebCoreImpl", "onPageFinished, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.tVm.gsB) });
    }
    if (com.tencent.mm.plugin.webview.ui.tools.game.g.aJd(this.tVg).Ejs == 0L) {
      com.tencent.mm.plugin.webview.ui.tools.game.g.aJd(this.tVg).Ejs = System.currentTimeMillis();
    }
    synchronized (lock)
    {
      getSettings().setBlockNetworkImage(this.tVi);
      this.tVh = true;
      if (this.tVm.gsy == 0L) {
        this.tVm.gsy = System.currentTimeMillis();
      }
      AppMethodBeat.o(83163);
      return;
    }
  }
  
  protected void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(83162);
    this.tVj = true;
    cXs();
    if (this.tVm.gsA == 0L)
    {
      this.tVm.gsA = System.currentTimeMillis();
      ad.i("MicroMsg.GameWebCoreImpl", "onPageStarted, url: %s, time: %d", new Object[] { paramString, Long.valueOf(this.tVm.gsA) });
    }
    if (com.tencent.mm.plugin.webview.ui.tools.game.g.aJd(this.tVg).Ejr == 0L) {
      com.tencent.mm.plugin.webview.ui.tools.game.g.aJd(this.tVg).Ejr = System.currentTimeMillis();
    }
    AppMethodBeat.o(83162);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(83165);
    this.tVd.vz(this.tVl);
    super.destroy();
    AppMethodBeat.o(83165);
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public d getWePkgPlugin()
  {
    return this.tVd;
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
    AppMethodBeat.i(211675);
    if (this.tVm == null)
    {
      this.tVm = GameWebPerformanceInfo.wg(paramString1);
      this.tVm.gsz = System.currentTimeMillis();
    }
    ad.d("MicroMsg.GameWebCoreImpl", "loadDataWithBaseURL, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.tVe) });
    if (!this.tVe)
    {
      this.tVd.k(paramString1, true, true);
      this.tVe = true;
    }
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(211675);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(83166);
    ad.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time : %d, hashCode: %d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    if (this.tVm == null)
    {
      this.tVm = GameWebPerformanceInfo.wg(this.tVg);
      this.tVm.gsz = System.currentTimeMillis();
    }
    ad.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.tVe) });
    if (!this.tVe)
    {
      this.tVd.k(paramString, true, false);
      this.tVe = true;
    }
    String str = this.tVd.eXD();
    ad.i("MicroMsg.GameWebCoreImpl", "loadUrl:%s", new Object[] { paramString });
    if (bt.isNullOrNil(str)) {}
    try
    {
      com.tencent.mm.game.report.api.a.gsb.a(5, URLEncoder.encode(paramString), "0", 0L);
      label156:
      super.loadUrl(paramString);
      AppMethodBeat.o(83166);
      return;
      ad.d("MicroMsg.GameWebCoreImpl", "use PageCache:%s", new Object[] { str });
      try
      {
        com.tencent.mm.game.report.api.a.gsb.a(5, URLEncoder.encode(paramString), "1", 0L);
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
    ad.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time: %d， HEADER", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.tVm == null)
    {
      this.tVm = GameWebPerformanceInfo.wg(this.tVg);
      this.tVm.gsz = System.currentTimeMillis();
    }
    ad.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", new Object[] { Boolean.valueOf(this.tVe) });
    if (!this.tVe)
    {
      this.tVd.k(paramString, true, false);
      this.tVe = true;
    }
    String str = this.tVd.eXD();
    ad.i("MicroMsg.GameWebCoreImpl", "loadUrl:%s", new Object[] { paramString });
    if (bt.isNullOrNil(str))
    {
      com.tencent.mm.game.report.api.a.gsb.a(5, URLEncoder.encode(paramString), "0", 0L);
      super.loadUrl(paramString, paramMap);
      AppMethodBeat.o(83167);
      return;
    }
    ad.d("MicroMsg.GameWebCoreImpl", "use PageCache:%s", new Object[] { str });
    com.tencent.mm.game.report.api.a.gsb.a(5, URLEncoder.encode(paramString), "1", 0L);
    super.loadDataWithBaseURL(paramString, str, "text/html", "utf-8", null);
    AppMethodBeat.o(83167);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(83156);
    super.onAttachedToWindow();
    ad.i("MicroMsg.GameWebCoreImpl", "onAttachedToWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.tVk = true;
    cXs();
    AppMethodBeat.o(83156);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(83157);
    super.onDetachedFromWindow();
    ad.i("MicroMsg.GameWebCoreImpl", "onDetachedFromWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    removeCallbacks(this.tVp);
    AppMethodBeat.o(83157);
  }
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(83164);
    ad.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage, blockImg: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.tVi = paramBoolean;
    if (this.tVh) {
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
    this.tVg = paramString;
  }
  
  public void setShouldCleanPkgWhenDestroy(boolean paramBoolean)
  {
    this.tVl = paramBoolean;
  }
  
  public final class a
    extends com.tencent.mm.plugin.webview.luggage.f
  {
    public a() {}
    
    public final void d(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83143);
      ad.i("MicroMsg.GameWebCoreImpl", "onReceivedTitle, title = %s", new Object[] { paramString });
      if (!com.tencent.mm.plugin.webview.luggage.c.b.UV(paramString)) {
        f.a(f.this, paramString);
      }
      super.d(paramWebView, paramString);
      AppMethodBeat.o(83143);
    }
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(83144);
      if (f.this.tVd != null) {
        f.this.tVd.a(paramConsoleMessage);
      }
      if (paramConsoleMessage != null) {}
      for (final String str = paramConsoleMessage.message();; str = "")
      {
        h.LTJ.aR(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(211674);
            if ((str.contains("luggage_err")) || (str.contains("luggageBridge is not defined")))
            {
              ad.i("MicroMsg.GameWebCoreImpl", "luggage bridge error");
              f.b(f.this).gsK = str;
              AppMethodBeat.o(211674);
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
              com.tencent.mm.plugin.webview.ui.tools.game.g.bJ(f.c(f.this), l);
              for (;;)
              {
                label128:
                ad.i("MicroMsg.GameWebCoreImpl", str);
                AppMethodBeat.o(211674);
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
                      com.tencent.mm.plugin.webview.ui.tools.game.g localg = com.tencent.mm.plugin.webview.ui.tools.game.g.aJe(f.c(f.this));
                      if (localg != null)
                      {
                        localg.Ejz = (((JSONObject)localObject).optLong("domainLookupEnd") - ((JSONObject)localObject).optLong("domainLookupStart"));
                        localg.EjA = (((JSONObject)localObject).optLong("connectEnd") - ((JSONObject)localObject).optLong("connectStart"));
                        localg.mxj = (((JSONObject)localObject).optLong("responseEnd") - ((JSONObject)localObject).optLong("requestStart"));
                        localg.EjB = (((JSONObject)localObject).optLong("domInteractive") - ((JSONObject)localObject).optLong("domLoading"));
                        localg.EjD = (((JSONObject)localObject).optLong("domContentLoadedEventEnd") - ((JSONObject)localObject).optLong("responseEnd"));
                        localg.EjE = (((JSONObject)localObject).optLong("domComplete") - ((JSONObject)localObject).optLong("responseEnd"));
                        localg.EjF = ((JSONObject)localObject).optLong("navigationStart");
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
      ad.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", new Object[] { paramWebResourceRequest.getUrl().toString() });
      if (paramWebResourceRequest.getUrl().toString().equals("https://game.weixin.qq.com/favicon.ico"))
      {
        paramWebView = new WebResourceResponse("img/png", null, null);
        AppMethodBeat.o(83150);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = f.this.tVd.o(paramWebView, paramWebResourceRequest.getUrl().toString());
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
      WebResourceResponse localWebResourceResponse = f.this.tVd.o(paramWebView, paramWebResourceRequest.getUrl().toString());
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
      com.tencent.mm.plugin.report.service.g.yhR.n(949L, 1L, 1L);
      AppMethodBeat.o(83152);
    }
    
    public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
    {
      AppMethodBeat.i(83154);
      super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
      ad.e("MicroMsg.GameWebCoreImpl", "onReceivedHttpError， errorCode: %d", new Object[] { Integer.valueOf(paramWebResourceResponse.mStatusCode) });
      com.tencent.mm.plugin.report.service.g.yhR.n(949L, 3L, 1L);
      AppMethodBeat.o(83154);
    }
    
    public final void a(WebView paramWebView, r paramr, SslError paramSslError)
    {
      AppMethodBeat.i(83153);
      super.a(paramWebView, paramr, paramSslError);
      ad.e("MicroMsg.GameWebCoreImpl", "onReceivedSslError， error: ".concat(String.valueOf(paramSslError)));
      com.tencent.mm.plugin.report.service.g.yhR.n(949L, 2L, 1L);
      AppMethodBeat.o(83153);
    }
    
    public final boolean a(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(83148);
      ad.i("MicroMsg.GameWebCoreImpl", "shouldOverrideUrlLoading, url: %s", new Object[] { paramString });
      if (DownloadChecker.a(paramString, f.a(f.this), paramWebView))
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
      f.this.tVd.n(paramWebView, paramString);
      super.b(paramWebView, paramString);
      f.this.b(paramWebView, paramString);
      AppMethodBeat.o(83146);
    }
    
    public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(83145);
      ad.i("MicroMsg.GameWebCoreImpl", "onPageStarted, __Time__, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      f.this.tVd.aKt(paramString);
      super.b(paramWebView, paramString, paramBitmap);
      f.this.b(paramWebView, paramString, paramBitmap);
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
      WebResourceResponse localWebResourceResponse = f.this.tVd.o(paramWebView, paramString);
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
      AppMethodBeat.o(83147);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f.f
 * JD-Core Version:    0.7.0.1
 */