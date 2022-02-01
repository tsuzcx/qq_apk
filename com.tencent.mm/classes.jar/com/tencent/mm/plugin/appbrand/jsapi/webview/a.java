package com.tencent.mm.plugin.appbrand.jsapi.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import androidx.core.g.w;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.au.e;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.platform.window.d.a;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.model.p;
import com.tencent.mm.plugin.appbrand.report.model.q;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.aa;
import com.tencent.xweb.ac;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

@SuppressLint({"ViewConstructor"})
public final class a
  extends FrameLayout
  implements g, g.c
{
  private int Go;
  private com.tencent.mm.plugin.appbrand.widget.input.u cKH;
  private final u.c cKO;
  private MMFalseProgressBar lwZ;
  private MMWebView lxa;
  private String mAppId;
  private boolean mDestroyed;
  private ah oxm;
  private d pFS;
  private com.tencent.mm.plugin.appbrand.page.a.f pFT;
  private final g.a pFU;
  private volatile String pFV;
  private boolean pFW;
  private boolean pFX;
  private boolean pFY;
  private a pFZ;
  private final Set<g.c.a> pGa;
  private final g.b pGb;
  private ac pGc;
  private com.tencent.xweb.x5.export.external.extension.proxy.a pGd;
  
  @SuppressLint({"SetJavaScriptEnabled"})
  a(Context paramContext, AppBrandRuntime paramAppBrandRuntime, ah paramah)
  {
    super(new MutableContextWrapper(paramContext));
    AppMethodBeat.i(46990);
    this.Go = 0;
    this.pFV = "";
    this.pFW = true;
    this.pFX = false;
    this.cKH = null;
    this.cKO = new u.c()
    {
      private int cpD = 0;
      
      public final void ca(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46965);
        a.a(a.this).v(paramAnonymousBoolean, this.cpD);
        AppMethodBeat.o(46965);
      }
      
      public final int getHeight()
      {
        return this.cpD;
      }
      
      public final void iF(int paramAnonymousInt)
      {
        this.cpD = paramAnonymousInt;
      }
    };
    this.pGa = new androidx.b.b();
    this.mDestroyed = false;
    this.pGb = new g.b()
    {
      public final void Bi(int paramAnonymousInt)
      {
        AppMethodBeat.i(272276);
        com.tencent.mm.plugin.report.service.h.IzE.el(1097, paramAnonymousInt);
        try
        {
          t localt = a.c(a.this).getRuntime();
          j.b(a.this.getAppId(), localt.bDy().appVersion, localt.ntz.cBI, 1097, paramAnonymousInt);
          AppMethodBeat.o(272276);
          return;
        }
        catch (NullPointerException localNullPointerException)
        {
          AppMethodBeat.o(272276);
        }
      }
      
      public final void I(ArrayList<IDKey> paramAnonymousArrayList)
      {
        AppMethodBeat.i(272277);
        com.tencent.mm.plugin.report.service.h.IzE.b(paramAnonymousArrayList, false);
        try
        {
          t localt = a.c(a.this).getRuntime();
          paramAnonymousArrayList = paramAnonymousArrayList.iterator();
          while (paramAnonymousArrayList.hasNext())
          {
            IDKey localIDKey = (IDKey)paramAnonymousArrayList.next();
            long l1 = localIDKey.GetID();
            long l2 = localIDKey.GetKey();
            j.a(a.this.getAppId(), localt.bDy().appVersion, localt.ntz.cBI, l1, l2, 1L);
          }
          AppMethodBeat.o(272277);
        }
        catch (NullPointerException paramAnonymousArrayList)
        {
          AppMethodBeat.o(272277);
          return;
        }
      }
    };
    this.pGc = new ac()
    {
      public final void computeScroll(View paramAnonymousView)
      {
        AppMethodBeat.i(283201);
        a.b(a.this).hZQ();
        AppMethodBeat.o(283201);
      }
      
      public final boolean dispatchTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(283207);
        boolean bool = a.b(a.this).av(paramAnonymousMotionEvent);
        AppMethodBeat.o(283207);
        return bool;
      }
      
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(283209);
        boolean bool = a.b(a.this).aw(paramAnonymousMotionEvent);
        AppMethodBeat.o(283209);
        return bool;
      }
      
      @TargetApi(9)
      public final void onOverScrolled(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, View paramAnonymousView)
      {
        AppMethodBeat.i(283203);
        a.b(a.this).g(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(283203);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(283205);
        a.b(a.this).W(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(283205);
      }
      
      public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(283198);
        boolean bool = a.b(a.this).au(paramAnonymousMotionEvent);
        AppMethodBeat.o(283198);
        return bool;
      }
      
      public final boolean overScrollBy(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean, View paramAnonymousView)
      {
        AppMethodBeat.i(283200);
        paramAnonymousBoolean = a.b(a.this).b(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
        AppMethodBeat.o(283200);
        return paramAnonymousBoolean;
      }
    };
    this.pGd = new com.tencent.xweb.x5.export.external.extension.proxy.a()
    {
      public final void computeScroll(View paramAnonymousView)
      {
        AppMethodBeat.i(270916);
        a.i(a.this).computeScroll(paramAnonymousView);
        AppMethodBeat.o(270916);
      }
      
      public final boolean dispatchTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(270911);
        boolean bool = a.i(a.this).dispatchTouchEvent(paramAnonymousMotionEvent, paramAnonymousView);
        AppMethodBeat.o(270911);
        return bool;
      }
      
      public final void invalidate() {}
      
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(270909);
        boolean bool = a.i(a.this).onInterceptTouchEvent(paramAnonymousMotionEvent, paramAnonymousView);
        AppMethodBeat.o(270909);
        return bool;
      }
      
      public final Object onMiscCallBack(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(270917);
        if ((Util.isNullOrNil(paramAnonymousString)) || (paramAnonymousBundle == null))
        {
          AppMethodBeat.o(270917);
          return null;
        }
        Log.i("MicroMsg.AppBrandHTMLWebView", "method = %s", new Object[] { paramAnonymousString });
        if ("onJavascriptCloseWindow".equals(paramAnonymousString))
        {
          paramAnonymousString = Boolean.TRUE;
          AppMethodBeat.o(270917);
          return paramAnonymousString;
        }
        AppMethodBeat.o(270917);
        return null;
      }
      
      public final void onOverScrolled(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, View paramAnonymousView)
      {
        AppMethodBeat.i(270915);
        a.i(a.this).onOverScrolled(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousView);
        AppMethodBeat.o(270915);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(270914);
        a.i(a.this).onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousView);
        AppMethodBeat.o(270914);
      }
      
      public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(270908);
        boolean bool = a.i(a.this).onTouchEvent(paramAnonymousMotionEvent, paramAnonymousView);
        AppMethodBeat.o(270908);
        return bool;
      }
      
      public final boolean overScrollBy(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean, View paramAnonymousView)
      {
        AppMethodBeat.i(270912);
        paramAnonymousBoolean = a.i(a.this).overScrollBy(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean, paramAnonymousView);
        AppMethodBeat.o(270912);
        return paramAnonymousBoolean;
      }
    };
    Log.i("MicroMsg.AppBrandHTMLWebView", "<init> start hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.pFS = new d();
    this.pFS.i(paramah);
    this.oxm = paramah;
    this.lxa = MMWebViewWithJsApi.a.jd(new MutableContextWrapper(paramContext));
    this.lxa.setBackgroundColor(0);
    this.lxa.getSettings().iwC();
    this.lxa.getSettings().setJavaScriptEnabled(true);
    this.lxa.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.lxa.getSettings().iwE();
    paramah = this.lxa.getSettings().getUserAgentString();
    paramAppBrandRuntime = paramah;
    if (!ab.bsa(paramah)) {
      paramAppBrandRuntime = ab.cC(getContext(), paramah);
    }
    paramAppBrandRuntime = paramAppBrandRuntime + " miniProgram";
    this.lxa.getSettings().setUserAgentString(paramAppBrandRuntime);
    this.lxa.getView().setHorizontalScrollBarEnabled(false);
    this.lxa.getView().setVerticalScrollBarEnabled(false);
    this.lxa.getSettings().setBuiltInZoomControls(true);
    this.lxa.getSettings().setUseWideViewPort(true);
    this.lxa.getSettings().setLoadWithOverviewMode(true);
    this.lxa.getSettings().iwx();
    this.lxa.getSettings().iww();
    this.lxa.getSettings().setGeolocationEnabled(true);
    this.lxa.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.lxa.getSettings().iwA();
    this.lxa.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.lxa.getSettings().iwz();
    this.lxa.getSettings().iwB();
    this.lxa.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.aSC() + "databases/");
    this.lxa.getSettings().iwF();
    this.lxa.setWebViewCallbackClient(this.pGc);
    if (this.lxa.getIsX5Kernel()) {
      this.lxa.setWebViewClientExtension(this.pGd);
    }
    this.lxa.getSettings().setUsingForAppBrand(2);
    this.lxa.setDownloadListener(new DownloadListener()
    {
      public final void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        AppMethodBeat.i(46966);
        Log.i("MicroMsg.AppBrandHTMLWebView", "onDownloadStart page[%s], downloadUrl[%s], userAgent[%s], contentDisposition[%s], mime[%s], contentLength[%d], allowDownloadByExpt[%b]", new Object[] { a.c(a.this).oxe, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4, Long.valueOf(paramAnonymousLong), Boolean.FALSE });
        a.d(a.this).Bi(0);
        AppMethodBeat.o(46966);
      }
    });
    Log.i("MicroMsg.AppBrandHTMLWebView", "<init> end WebView construct hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    addView(this.lxa, new ViewGroup.LayoutParams(-1, -1));
    this.lwZ = new MMFalseProgressBar(paramContext);
    this.lwZ.setProgressDrawable(com.tencent.mm.ci.a.m(paramContext, au.e.mm_webview_progress_horizontal));
    addView(this.lwZ, new ViewGroup.LayoutParams(-1, com.tencent.mm.ci.a.fromDPToPix(paramContext, 3)));
    this.lwZ.start();
    this.pFU = new h(this);
    this.oxm.a(new h.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(46967);
        a.this.destroy();
        AppMethodBeat.o(46967);
      }
    });
    getExitReporter().qMp = true;
    paramContext = c.pGg;
    c.a(this);
    paramContext = this.lxa.setVideoJsCallback(new f()
    {
      public final boolean Bh(int paramAnonymousInt)
      {
        AppMethodBeat.i(280444);
        if (a.c(a.this) == null) {}
        for (com.tencent.mm.plugin.appbrand.platform.window.d locald = null; locald != null; locald = a.c(a.this).getFullscreenImpl())
        {
          locald.yS(d.a.CC(paramAnonymousInt));
          AppMethodBeat.o(280444);
          return true;
        }
        Log.w("MicroMsg.AppBrandHTMLWebView", "onSetRequestedOrientation hash[%d] NULL fullscreenImpl", new Object[] { Integer.valueOf(a.this.hashCode()) });
        AppMethodBeat.o(280444);
        return false;
      }
    });
    if ((paramContext != null) && (paramContext.iwi())) {}
    for (boolean bool = true;; bool = false)
    {
      this.pFY = bool;
      Log.i("MicroMsg.AppBrandHTMLWebView", "<init> end total construct hash[%d], supportOrientationControl[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.pFY) });
      AppMethodBeat.o(46990);
      return;
    }
  }
  
  private void ajx(String paramString)
  {
    AppMethodBeat.i(47006);
    if (this.pFT != null) {
      this.pFT.setPullDownText(paramString);
    }
    AppMethodBeat.o(47006);
  }
  
  private void bXv()
  {
    AppMethodBeat.i(47003);
    this.lxa.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
    AppMethodBeat.o(47003);
  }
  
  private p getExitReporter()
  {
    AppMethodBeat.i(284507);
    p localp = this.oxm.getRuntime().bDz().getReporter().caS();
    AppMethodBeat.o(284507);
    return localp;
  }
  
  public final void A(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(47001);
    new g.f().i(this.oxm).o("htmlId", Integer.valueOf(this.Go)).o("errorCode", Integer.valueOf(paramInt)).o("description", paramString2).o("src", paramString1).bPO();
    AppMethodBeat.o(47001);
  }
  
  public final void PE()
  {
    AppMethodBeat.i(284501);
    this.lxa.getView().scrollTo(this.lxa.getWebScrollX(), 0);
    AppMethodBeat.o(284501);
  }
  
  public final boolean Qv()
  {
    return this.oxm instanceof com.tencent.mm.plugin.appbrand.game.f.d;
  }
  
  public final void a(g.c.a parama)
  {
    AppMethodBeat.i(284493);
    if (!this.mDestroyed) {
      this.pGa.add(parama);
    }
    AppMethodBeat.o(284493);
  }
  
  public final void a(String paramString, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(180294);
    this.oxm.getRuntime().bDz().getReporter().caT().a(this.oxm, paramString, paramWebResourceRequest);
    AppMethodBeat.o(180294);
  }
  
  public final void aD(Context paramContext)
  {
    AppMethodBeat.i(284500);
    if (paramContext == null)
    {
      AppMethodBeat.o(284500);
      return;
    }
    if ((getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    }
    this.lxa.aD(paramContext);
    AppMethodBeat.o(284500);
  }
  
  public final void ajv(String paramString)
  {
    AppMethodBeat.i(46998);
    if ((TextUtils.isEmpty(paramString)) || (URLUtil.isValidUrl(paramString)))
    {
      AppMethodBeat.o(46998);
      return;
    }
    this.oxm.agC(paramString);
    AppMethodBeat.o(46998);
  }
  
  public final void ajw(String paramString)
  {
    AppMethodBeat.i(284506);
    if (this.mDestroyed)
    {
      Log.i("MicroMsg.AppBrandHTMLWebView", "onPageCommitVisible url[%s] hash[%d] destroyed[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed) });
      AppMethodBeat.o(284506);
      return;
    }
    bXv();
    AppMethodBeat.o(284506);
  }
  
  public final void al(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46997);
    this.pFS.a(this.oxm.getRuntime().bDA(), this.oxm.getComponentId()).agT(paramJSONObject.toString()).bPO();
    AppMethodBeat.o(46997);
  }
  
  public final void bXq()
  {
    AppMethodBeat.i(46988);
    Log.i("MicroMsg.AppBrandHTMLWebView", "restoreRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.lxa.onShow();
    AppMethodBeat.o(46988);
  }
  
  public final void bXr()
  {
    AppMethodBeat.i(46989);
    Log.i("MicroMsg.AppBrandHTMLWebView", "pauseRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.lxa.onHide();
    AppMethodBeat.o(46989);
  }
  
  public final boolean bXs()
  {
    return !this.pFY;
  }
  
  public final boolean bXt()
  {
    AppMethodBeat.i(284503);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(284503);
      return false;
    }
    if (getWebView().canGoBack())
    {
      getExitReporter().a(this.oxm, true);
      getWebView().goBack();
      this.pFX = true;
      AppMethodBeat.o(284503);
      return true;
    }
    getExitReporter().a(this.oxm, false);
    AppMethodBeat.o(284503);
    return false;
  }
  
  public final void bXu()
  {
    AppMethodBeat.i(47002);
    this.oxm.getRuntime().bDz().alA("scene_other");
    AppMethodBeat.o(47002);
  }
  
  public final boolean bXw()
  {
    AppMethodBeat.i(47008);
    try
    {
      if (this.oxm.getRuntime().bDx().cwS)
      {
        bool = this.oxm.getRuntime().bDx().cxj;
        AppMethodBeat.o(47008);
        return bool;
      }
      boolean bool = this.oxm.getRuntime().bDx().cxh;
      AppMethodBeat.o(47008);
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(47008);
    }
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(46991);
    Runnable local5 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(180277);
        if (!a.e(a.this))
        {
          Log.i("MicroMsg.AppBrandHTMLWebView", "destroy hash[%d]", new Object[] { Integer.valueOf(a.this.hashCode()) });
          a.a(a.this).cleanup();
          a.b(a.this).stopLoading();
          a.b(a.this).destroy();
          a.f(a.this).clear();
          c localc = c.pGg;
          c.b(a.this);
          a.g(a.this);
        }
        AppMethodBeat.o(180277);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local5.run();
      AppMethodBeat.o(46991);
      return;
    }
    new Handler(Looper.getMainLooper()).post(local5);
    AppMethodBeat.o(46991);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(46992);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(46992);
      return false;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      if ((!bool) && (this.pFT != null)) {
        this.pFT.requestDisallowInterceptTouchEvent(false);
      }
      AppMethodBeat.o(46992);
      return bool;
      if (this.pFT != null)
      {
        this.pFT.requestDisallowInterceptTouchEvent(true);
        continue;
        if (this.pFT != null) {
          this.pFT.requestDisallowInterceptTouchEvent(false);
        }
      }
    }
  }
  
  public final void dv(String paramString)
  {
    AppMethodBeat.i(284505);
    Log.i("MicroMsg.AppBrandHTMLWebView", "onPageStarted url[%s] hash[%d] destroyed[%b] attached[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed), Boolean.valueOf(w.al(this)) });
    if (this.mDestroyed)
    {
      AppMethodBeat.o(284505);
      return;
    }
    bXv();
    this.lwZ.start();
    new g.e().i(this.oxm).o("src", paramString).o("htmlId", Integer.valueOf(this.Go)).bPO();
    AppMethodBeat.o(284505);
  }
  
  public final void dw(String paramString)
  {
    AppMethodBeat.i(47000);
    Log.i("MicroMsg.AppBrandHTMLWebView", "onPageFinished url[%s] hash[%d] destroyed[%b] attached[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed), Boolean.valueOf(w.al(this)) });
    if (this.mDestroyed)
    {
      AppMethodBeat.o(47000);
      return;
    }
    bXv();
    this.lwZ.finish();
    if ((!this.pFW) && (!this.pFX)) {
      getExitReporter().a(this.oxm, this.pFV, paramString);
    }
    this.pFW = false;
    this.pFX = false;
    this.pFV = paramString;
    if (!Util.isNullOrNil(paramString))
    {
      String str = Uri.parse(paramString).getHost();
      if (!Util.isNullOrNil(str)) {
        ajx(getContext().getString(au.i.webview_logo_url, new Object[] { str }));
      }
    }
    for (;;)
    {
      new g.d().i(this.oxm).o("src", paramString).o("htmlId", Integer.valueOf(this.Go)).bPO();
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(283024);
          new com.tencent.mm.plugin.appbrand.game.e.b.b().a(a.c(a.this).bDA(), b.a.onU, a.h(a.this));
          AppMethodBeat.o(283024);
        }
      }, 1000L);
      AppMethodBeat.o(47000);
      return;
      ajx("");
    }
  }
  
  public final Context getAndroidContext()
  {
    AppMethodBeat.i(284497);
    Context localContext = getContext();
    AppMethodBeat.o(284497);
    return localContext;
  }
  
  public final View getAndroidView()
  {
    return this;
  }
  
  public final String getAppId()
  {
    return this.mAppId;
  }
  
  public final int getBinderID()
  {
    AppMethodBeat.i(174921);
    int i = this.pFU.getBinderID();
    AppMethodBeat.o(174921);
    return i;
  }
  
  public final g.a getController()
  {
    return this.pFU;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(284509);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      str = this.lxa.getUrl();
      if (!TextUtils.isEmpty(str))
      {
        AppMethodBeat.o(284509);
        return str;
      }
    }
    String str = this.pFV;
    AppMethodBeat.o(284509);
    return str;
  }
  
  public final String[] getJsApiReportArgs()
  {
    AppMethodBeat.i(47007);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(47007);
      return new String[0];
    }
    String[] arrayOfString = b.c(this.oxm);
    AppMethodBeat.o(47007);
    return arrayOfString;
  }
  
  public final ad getPageView()
  {
    return this.oxm;
  }
  
  public final g.b getReporter()
  {
    return this.pGb;
  }
  
  public final MMWebView getWebView()
  {
    return this.lxa;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(46994);
    super.onAttachedToWindow();
    this.cKH = n.dr(this);
    if (this.cKH != null) {
      this.cKH.a(this.cKO);
    }
    this.pFT = ((com.tencent.mm.plugin.appbrand.page.a.f)this.oxm.R(com.tencent.mm.plugin.appbrand.page.a.f.class));
    this.pFZ = new a((byte)0);
    a locala = this.pFZ;
    locala.pGe.oxm.a(locala);
    locala.pGe.oxm.a(locala);
    this.pFZ.onForeground();
    AppMethodBeat.o(46994);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(46995);
    super.onDetachedFromWindow();
    if (!this.oxm.isRunning()) {
      destroy();
    }
    if (this.cKH != null) {
      this.cKH.b(this.cKO);
    }
    if (this.pFZ != null)
    {
      this.pFZ.onBackground();
      a locala = this.pFZ;
      locala.pGe.oxm.b(locala);
      locala.pGe.oxm.b(locala);
      this.pFZ = null;
    }
    AppMethodBeat.o(46995);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46993);
    int i = paramInt2;
    ViewGroup localViewGroup;
    if ((getParent() instanceof ViewGroup))
    {
      localViewGroup = (ViewGroup)getParent();
      switch (View.MeasureSpec.getMode(paramInt2))
      {
      default: 
        i = paramInt2;
      }
    }
    for (;;)
    {
      super.onMeasure(paramInt1, i);
      AppMethodBeat.o(46993);
      return;
      i = View.MeasureSpec.makeMeasureSpec(localViewGroup.getMeasuredHeight(), -2147483648);
      continue;
      i = View.MeasureSpec.makeMeasureSpec(Math.max(0, Math.min(localViewGroup.getMeasuredHeight(), View.MeasureSpec.getSize(paramInt2))), -2147483648);
      continue;
      i = paramInt2;
      if (View.MeasureSpec.getSize(paramInt2) > localViewGroup.getMeasuredHeight()) {
        i = View.MeasureSpec.makeMeasureSpec(localViewGroup.getMeasuredHeight(), 1073741824);
      }
    }
  }
  
  public final void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(46996);
    if (MMHandlerThread.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(46996);
      return;
    }
    post(paramRunnable);
    AppMethodBeat.o(46996);
  }
  
  public final void setAndroidViewId(int paramInt)
  {
    AppMethodBeat.i(284498);
    getAndroidView().setId(paramInt);
    AppMethodBeat.o(284498);
  }
  
  public final void setCoverViewId(int paramInt)
  {
    this.Go = paramInt;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(46987);
    if (paramInt != getVisibility())
    {
      super.setVisibility(paramInt);
      Iterator localIterator = this.pGa.iterator();
      while (localIterator.hasNext()) {
        ((g.c.a)localIterator.next()).bXz();
      }
    }
    AppMethodBeat.o(46987);
  }
  
  final class a
    implements h.b, h.d
  {
    private a() {}
    
    public final void onBackground()
    {
      AppMethodBeat.i(46984);
      a.b(a.this).onPause();
      a.a(a.this).onBackground();
      AppMethodBeat.o(46984);
    }
    
    public final void onForeground()
    {
      AppMethodBeat.i(46985);
      a.b(a.this).onResume();
      a.a(a.this).onForeground();
      AppMethodBeat.o(46985);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a
 * JD-Core Version:    0.7.0.1
 */