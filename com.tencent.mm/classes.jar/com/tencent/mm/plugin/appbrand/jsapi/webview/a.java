package com.tencent.mm.plugin.appbrand.jsapi.webview;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
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
import androidx.core.g.z;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.platform.window.d.a;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.model.t;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.af;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public final class a
  extends FrameLayout
  implements g, g.c
{
  private int bms;
  private u eEs;
  private final u.c eEz;
  private String mAppId;
  private boolean mDestroyed;
  private MMFalseProgressBar ooy;
  private MMWebView ooz;
  private ah rAL;
  private d sLa;
  private com.tencent.mm.plugin.appbrand.page.a.f sLb;
  private final g.a sLd;
  private volatile String sLe;
  private boolean sLf;
  private boolean sLg;
  private boolean sLh;
  private a sLi;
  private final Set<g.c.a> sLj;
  private final g.b sLk;
  private af sLl;
  private com.tencent.xweb.x5.export.external.extension.proxy.a sLm;
  
  a(Context paramContext, AppBrandRuntime paramAppBrandRuntime, ah paramah)
  {
    super(new MutableContextWrapper(paramContext));
    AppMethodBeat.i(46990);
    this.bms = 0;
    this.sLe = "";
    this.sLf = true;
    this.sLg = false;
    this.eEs = null;
    this.eEz = new u.c()
    {
      private int ehr = 0;
      
      public final void cK(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46965);
        a.a(a.this).t(paramAnonymousBoolean, this.ehr);
        AppMethodBeat.o(46965);
      }
      
      public final int getHeight()
      {
        return this.ehr;
      }
      
      public final void mo(int paramAnonymousInt)
      {
        this.ehr = paramAnonymousInt;
      }
    };
    this.sLj = new androidx.b.b();
    this.mDestroyed = false;
    this.sLk = new g.b()
    {
      public final void M(ArrayList<IDKey> paramAnonymousArrayList)
      {
        AppMethodBeat.i(327448);
        com.tencent.mm.plugin.report.service.h.OAn.b(paramAnonymousArrayList, false);
        try
        {
          com.tencent.mm.plugin.appbrand.w localw = a.c(a.this).getRuntime();
          paramAnonymousArrayList = paramAnonymousArrayList.iterator();
          while (paramAnonymousArrayList.hasNext())
          {
            IDKey localIDKey = (IDKey)paramAnonymousArrayList.next();
            long l1 = localIDKey.GetID();
            long l2 = localIDKey.GetKey();
            j.a(a.this.getAppId(), localw.getInitConfig().appVersion, localw.qsh.eul, l1, l2, 1L);
          }
          AppMethodBeat.o(327448);
        }
        catch (NullPointerException paramAnonymousArrayList)
        {
          AppMethodBeat.o(327448);
          return;
        }
      }
      
      public final void zJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(327442);
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1097, paramAnonymousInt);
        try
        {
          com.tencent.mm.plugin.appbrand.w localw = a.c(a.this).getRuntime();
          j.b(a.this.getAppId(), localw.getInitConfig().appVersion, localw.qsh.eul, 1097, paramAnonymousInt);
          AppMethodBeat.o(327442);
          return;
        }
        catch (NullPointerException localNullPointerException)
        {
          AppMethodBeat.o(327442);
        }
      }
    };
    this.sLl = new a.8(this);
    this.sLm = new a.9(this);
    Log.i("MicroMsg.AppBrandHTMLWebView", "<init> start hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.sLa = new d();
    this.sLa.h(paramah);
    this.rAL = paramah;
    this.ooz = MMWebViewWithJsApi.a.ld(new MutableContextWrapper(paramContext));
    this.ooz.setBackgroundColor(0);
    this.ooz.getSettings().kfS();
    this.ooz.getSettings().setJavaScriptEnabled(true);
    this.ooz.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.ooz.getSettings().kfU();
    String str = this.mAppId;
    paramah = this.ooz.getSettings().getUserAgentString();
    paramAppBrandRuntime = paramah;
    if (!aa.brR(paramah)) {
      paramAppBrandRuntime = aa.cN(getContext(), paramah);
    }
    paramAppBrandRuntime = paramAppBrandRuntime + String.format(" miniProgram/%s", new Object[] { str });
    this.ooz.getSettings().setUserAgentString(paramAppBrandRuntime);
    this.ooz.getView().setHorizontalScrollBarEnabled(false);
    this.ooz.getView().setVerticalScrollBarEnabled(false);
    this.ooz.getSettings().setBuiltInZoomControls(true);
    this.ooz.getSettings().setUseWideViewPort(true);
    this.ooz.getSettings().setLoadWithOverviewMode(true);
    this.ooz.getSettings().kfN();
    this.ooz.getSettings().kfM();
    this.ooz.getSettings().setGeolocationEnabled(true);
    this.ooz.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.ooz.getSettings().kfQ();
    this.ooz.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.ooz.getSettings().kfP();
    this.ooz.getSettings().kfR();
    this.ooz.getSettings().setDatabasePath(com.tencent.mm.loader.i.b.bmq() + "databases/");
    this.ooz.getSettings().kfV();
    this.ooz.setWebViewCallbackClient(this.sLl);
    if (this.ooz.getIsX5Kernel()) {
      this.ooz.setWebViewClientExtension(this.sLm);
    }
    this.ooz.getSettings().setUsingForAppBrand(2);
    this.ooz.setDownloadListener(new DownloadListener()
    {
      public final void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        AppMethodBeat.i(46966);
        Log.i("MicroMsg.AppBrandHTMLWebView", "onDownloadStart page[%s], downloadUrl[%s], userAgent[%s], contentDisposition[%s], mime[%s], contentLength[%d], allowDownloadByExpt[%b]", new Object[] { a.c(a.this).cgR(), paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4, Long.valueOf(paramAnonymousLong), Boolean.FALSE });
        a.d(a.this).zJ(0);
        AppMethodBeat.o(46966);
      }
    });
    Log.i("MicroMsg.AppBrandHTMLWebView", "<init> end WebView construct hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    addView(this.ooz, new ViewGroup.LayoutParams(-1, -1));
    this.ooy = new MMFalseProgressBar(paramContext);
    this.ooy.setProgressDrawable(com.tencent.mm.cd.a.m(paramContext, ba.e.mm_webview_progress_horizontal));
    addView(this.ooy, new ViewGroup.LayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(paramContext, 3)));
    this.ooy.start();
    this.sLd = new h(this);
    this.rAL.a(new i.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(46967);
        a.this.destroy();
        AppMethodBeat.o(46967);
      }
    });
    getExitReporter().tQZ = true;
    paramContext = c.sLo;
    c.a(this);
    paramContext = this.ooz.setVideoJsCallback(new f()
    {
      public final boolean Bu(int paramAnonymousInt)
      {
        AppMethodBeat.i(327454);
        if (a.c(a.this) == null) {}
        for (com.tencent.mm.plugin.appbrand.platform.window.d locald = null; locald != null; locald = a.c(a.this).getFullscreenImpl())
        {
          locald.zb(d.a.CT(paramAnonymousInt));
          AppMethodBeat.o(327454);
          return true;
        }
        Log.w("MicroMsg.AppBrandHTMLWebView", "onSetRequestedOrientation hash[%d] NULL fullscreenImpl", new Object[] { Integer.valueOf(a.this.hashCode()) });
        AppMethodBeat.o(327454);
        return false;
      }
    });
    if ((paramContext != null) && (paramContext.kfw())) {}
    for (boolean bool = true;; bool = false)
    {
      this.sLh = bool;
      Log.i("MicroMsg.AppBrandHTMLWebView", "<init> end total construct hash[%d], supportOrientationControl[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.sLh) });
      AppMethodBeat.o(46990);
      return;
    }
  }
  
  private void acy(String paramString)
  {
    AppMethodBeat.i(47006);
    if (this.sLb != null) {
      this.sLb.setPullDownText(paramString);
    }
    AppMethodBeat.o(47006);
  }
  
  private void cxH()
  {
    AppMethodBeat.i(47003);
    this.ooz.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
    AppMethodBeat.o(47003);
  }
  
  private com.tencent.mm.plugin.appbrand.report.model.s getExitReporter()
  {
    AppMethodBeat.i(327472);
    com.tencent.mm.plugin.appbrand.report.model.s locals = this.rAL.getRuntime().ccN().getReporter().cBm();
    AppMethodBeat.o(327472);
    return locals;
  }
  
  public final void C(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(47001);
    new g.f().h(this.rAL).w("htmlId", Integer.valueOf(this.bms)).w("errorCode", Integer.valueOf(paramInt)).w("description", paramString2).w("src", paramString1).cpV();
    AppMethodBeat.o(47001);
  }
  
  public final void a(g.c.a parama)
  {
    AppMethodBeat.i(327517);
    if ((parama != null) && (!this.mDestroyed)) {
      this.sLj.add(parama);
    }
    AppMethodBeat.o(327517);
  }
  
  public final void a(String paramString, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(180294);
    this.rAL.getRuntime().ccN().getReporter().cBn().a(this.rAL, paramString, paramWebResourceRequest);
    AppMethodBeat.o(180294);
  }
  
  public final void acw(String paramString)
  {
    AppMethodBeat.i(46998);
    if ((TextUtils.isEmpty(paramString)) || (URLUtil.isValidUrl(paramString)))
    {
      AppMethodBeat.o(46998);
      return;
    }
    this.rAL.Zy(paramString);
    AppMethodBeat.o(46998);
  }
  
  public final void acx(String paramString)
  {
    AppMethodBeat.i(327656);
    if (this.mDestroyed)
    {
      Log.i("MicroMsg.AppBrandHTMLWebView", "onPageCommitVisible url[%s] hash[%d] destroyed[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed) });
      AppMethodBeat.o(327656);
      return;
    }
    cxH();
    AppMethodBeat.o(327656);
  }
  
  public final void apO()
  {
    AppMethodBeat.i(327592);
    this.ooz.getView().scrollTo(this.ooz.getWebScrollX(), 0);
    AppMethodBeat.o(327592);
  }
  
  public final boolean aqJ()
  {
    return this.rAL instanceof com.tencent.mm.plugin.appbrand.game.f.d;
  }
  
  public final void av(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46997);
    this.sLa.a(this.rAL.getRuntime().ccO(), this.rAL.getComponentId()).ZQ(paramJSONObject.toString()).cpV();
    AppMethodBeat.o(46997);
  }
  
  public final void bm(Context paramContext)
  {
    AppMethodBeat.i(327584);
    if (paramContext == null)
    {
      AppMethodBeat.o(327584);
      return;
    }
    if ((getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    }
    this.ooz.bm(paramContext);
    AppMethodBeat.o(327584);
  }
  
  public final void cxC()
  {
    AppMethodBeat.i(46988);
    Log.i("MicroMsg.AppBrandHTMLWebView", "restoreRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.ooz.onShow();
    AppMethodBeat.o(46988);
  }
  
  public final void cxD()
  {
    AppMethodBeat.i(46989);
    Log.i("MicroMsg.AppBrandHTMLWebView", "pauseRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.ooz.onHide();
    AppMethodBeat.o(46989);
  }
  
  public final boolean cxE()
  {
    return !this.sLh;
  }
  
  public final boolean cxF()
  {
    AppMethodBeat.i(327641);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(327641);
      return false;
    }
    if (getWebView().canGoBack())
    {
      getExitReporter().a(this.rAL, true);
      getWebView().goBack();
      this.sLg = true;
      AppMethodBeat.o(327641);
      return true;
    }
    getExitReporter().a(this.rAL, false);
    AppMethodBeat.o(327641);
    return false;
  }
  
  public final void cxG()
  {
    AppMethodBeat.i(47002);
    this.rAL.getRuntime().ccN().aeD("scene_other");
    AppMethodBeat.o(47002);
  }
  
  public final boolean cxI()
  {
    AppMethodBeat.i(47008);
    try
    {
      if (this.rAL.getRuntime().ccM().eoX)
      {
        bool = this.rAL.getRuntime().ccM().epB;
        AppMethodBeat.o(47008);
        return bool;
      }
      boolean bool = this.rAL.getRuntime().ccM().epz;
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
          c localc = c.sLo;
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
      if ((!bool) && (this.sLb != null)) {
        this.sLb.requestDisallowInterceptTouchEvent(false);
      }
      AppMethodBeat.o(46992);
      return bool;
      if (this.sLb != null)
      {
        this.sLb.requestDisallowInterceptTouchEvent(true);
        continue;
        if (this.sLb != null) {
          this.sLb.requestDisallowInterceptTouchEvent(false);
        }
      }
    }
  }
  
  public final void eG(String paramString)
  {
    AppMethodBeat.i(327648);
    Log.i("MicroMsg.AppBrandHTMLWebView", "onPageStarted url[%s] hash[%d] destroyed[%b] attached[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed), Boolean.valueOf(z.ay(this)) });
    if (this.mDestroyed)
    {
      AppMethodBeat.o(327648);
      return;
    }
    cxH();
    this.ooy.start();
    new g.e().h(this.rAL).w("src", paramString).w("htmlId", Integer.valueOf(this.bms)).cpV();
    AppMethodBeat.o(327648);
  }
  
  public final void eH(String paramString)
  {
    AppMethodBeat.i(47000);
    Log.i("MicroMsg.AppBrandHTMLWebView", "onPageFinished url[%s] hash[%d] destroyed[%b] attached[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed), Boolean.valueOf(z.ay(this)) });
    if (this.mDestroyed)
    {
      AppMethodBeat.o(47000);
      return;
    }
    cxH();
    this.ooy.finish();
    if ((!this.sLf) && (!this.sLg)) {
      getExitReporter().a(this.rAL, this.sLe, paramString);
    }
    this.sLf = false;
    this.sLg = false;
    this.sLe = paramString;
    if (!Util.isNullOrNil(paramString))
    {
      String str = Uri.parse(paramString).getHost();
      if (!Util.isNullOrNil(str)) {
        acy(getContext().getString(ba.i.webview_logo_url, new Object[] { str }));
      }
    }
    for (;;)
    {
      new g.d().h(this.rAL).w("src", paramString).w("htmlId", Integer.valueOf(this.bms)).cpV();
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(327457);
          new com.tencent.mm.plugin.appbrand.game.e.b.b().a(a.c(a.this).ccO(), b.a.rrD, a.h(a.this));
          AppMethodBeat.o(327457);
        }
      }, 1000L);
      AppMethodBeat.o(47000);
      return;
      acy("");
    }
  }
  
  public final Context getAndroidContext()
  {
    AppMethodBeat.i(327546);
    Context localContext = getContext();
    AppMethodBeat.o(327546);
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
    int i = this.sLd.getBinderID();
    AppMethodBeat.o(174921);
    return i;
  }
  
  public final g.a getController()
  {
    return this.sLd;
  }
  
  public final String getCurrentUrl()
  {
    AppMethodBeat.i(327661);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      str = this.ooz.getUrl();
      if (!TextUtils.isEmpty(str))
      {
        AppMethodBeat.o(327661);
        return str;
      }
    }
    String str = this.sLe;
    AppMethodBeat.o(327661);
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
    String[] arrayOfString = b.c(this.rAL);
    AppMethodBeat.o(47007);
    return arrayOfString;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.ad getPageView()
  {
    return this.rAL;
  }
  
  public final g.b getReporter()
  {
    return this.sLk;
  }
  
  public final MMWebView getWebView()
  {
    return this.ooz;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(46994);
    super.onAttachedToWindow();
    this.eEs = n.ef(this);
    if (this.eEs != null) {
      this.eEs.a(this.eEz);
    }
    this.sLb = ((com.tencent.mm.plugin.appbrand.page.a.f)this.rAL.aa(com.tencent.mm.plugin.appbrand.page.a.f.class));
    this.sLi = new a((byte)0);
    a locala = this.sLi;
    locala.sLn.rAL.a(locala);
    locala.sLn.rAL.a(locala);
    this.sLi.onForeground();
    AppMethodBeat.o(46994);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(46995);
    super.onDetachedFromWindow();
    if (!this.rAL.isRunning()) {
      destroy();
    }
    if (this.eEs != null) {
      this.eEs.b(this.eEz);
    }
    if (this.sLi != null)
    {
      this.sLi.onBackground();
      a locala = this.sLi;
      locala.sLn.rAL.b(locala);
      locala.sLn.rAL.b(locala);
      this.sLi = null;
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
    AppMethodBeat.i(327555);
    getAndroidView().setId(paramInt);
    AppMethodBeat.o(327555);
  }
  
  public final void setCoverViewId(int paramInt)
  {
    this.bms = paramInt;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(46987);
    if (paramInt != getVisibility())
    {
      super.setVisibility(paramInt);
      Iterator localIterator = this.sLj.iterator();
      while (localIterator.hasNext()) {
        ((g.c.a)localIterator.next()).onVisibilityChanged(paramInt);
      }
    }
    AppMethodBeat.o(46987);
  }
  
  final class a
    implements i.b, i.d
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a
 * JD-Core Version:    0.7.0.1
 */