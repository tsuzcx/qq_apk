package com.tencent.mm.plugin.appbrand.jsapi.y;

import android.annotation.SuppressLint;
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
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.b.e;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.plugin.appbrand.report.model.q;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.ab;
import com.tencent.xweb.z;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class a
  extends FrameLayout
  implements e.b, e
{
  private com.tencent.mm.plugin.appbrand.widget.input.u ckZ;
  private final u.c clb;
  private MMFalseProgressBar hqJ;
  public MMWebView hqK;
  ae jZO;
  private c kYa;
  private com.tencent.mm.plugin.appbrand.page.b.f kYb;
  final e.a kYc;
  private String kYd;
  private boolean kYe;
  boolean kYf;
  private boolean kYg;
  private d kYh;
  private final Set<a> kYi;
  private ab kYj;
  private com.tencent.xweb.x5.export.external.extension.proxy.a kYk;
  private String mAppId;
  boolean mDestroyed;
  private int mViewId;
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public a(Context paramContext, AppBrandRuntime paramAppBrandRuntime, ae paramae)
  {
    super(new MutableContextWrapper(paramContext));
    AppMethodBeat.i(46990);
    this.mViewId = 0;
    this.kYd = "";
    this.kYe = true;
    this.kYf = false;
    this.ckZ = null;
    this.clb = new u.c()
    {
      private int cdN = 0;
      
      public final void bt(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46965);
        a.a(a.this).t(paramAnonymousBoolean, this.cdN);
        AppMethodBeat.o(46965);
      }
      
      public final int getHeight()
      {
        return this.cdN;
      }
      
      public final void gw(int paramAnonymousInt)
      {
        this.cdN = paramAnonymousInt;
      }
    };
    this.kYi = new android.support.v4.e.b();
    this.mDestroyed = false;
    this.kYj = new a.7(this);
    this.kYk = new a.8(this);
    ac.i("MicroMsg.AppBrandHTMLWebView", "<init> start hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.kYa = new c();
    this.kYa.g(paramae);
    this.jZO = paramae;
    this.hqK = MMWebViewWithJsApi.a.gU(new MutableContextWrapper(paramContext));
    this.hqK.setBackgroundColor(0);
    this.hqK.getSettings().fJH();
    this.hqK.getSettings().setJavaScriptEnabled(true);
    this.hqK.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.hqK.getSettings().fJJ();
    paramae = this.hqK.getSettings().getUserAgentString();
    paramAppBrandRuntime = paramae;
    if (!x.aIc(paramae)) {
      paramAppBrandRuntime = x.bS(getContext(), paramae);
    }
    paramAppBrandRuntime = paramAppBrandRuntime + " miniProgram";
    this.hqK.getSettings().setUserAgentString(paramAppBrandRuntime);
    this.hqK.getView().setHorizontalScrollBarEnabled(false);
    this.hqK.getView().setVerticalScrollBarEnabled(false);
    this.hqK.getSettings().setBuiltInZoomControls(true);
    this.hqK.getSettings().setUseWideViewPort(true);
    this.hqK.getSettings().setLoadWithOverviewMode(true);
    this.hqK.getSettings().fJA();
    this.hqK.getSettings().fJz();
    this.hqK.getSettings().setGeolocationEnabled(true);
    this.hqK.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.hqK.getSettings().fJF();
    this.hqK.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.hqK.getSettings().fJE();
    this.hqK.getSettings().fJG();
    this.hqK.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.aoY() + "databases/");
    this.hqK.setWebViewCallbackClient(this.kYj);
    if (this.hqK.getIsX5Kernel()) {
      this.hqK.setWebViewClientExtension(this.kYk);
    }
    this.hqK.getSettings().setUsingForAppBrand(2);
    this.hqK.setDownloadListener(new a.2(this));
    ac.i("MicroMsg.AppBrandHTMLWebView", "<init> end WebView construct hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    addView(this.hqK, new ViewGroup.LayoutParams(-1, -1));
    this.hqJ = new MMFalseProgressBar(paramContext);
    this.hqJ.setProgressDrawable(com.tencent.mm.cc.a.l(paramContext, 2131233300));
    addView(this.hqJ, new ViewGroup.LayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(paramContext, 3)));
    this.kYc = new f(this);
    this.jZO.a(new f.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(46967);
        a.this.destroy();
        AppMethodBeat.o(46967);
      }
    });
    getReporter().lUo = true;
    paramContext = b.kYn;
    b.i(this);
    paramContext = this.hqK.setVideoJsCallback(new a.4(this));
    if ((paramContext != null) && (paramContext.fJn())) {}
    for (boolean bool = true;; bool = false)
    {
      this.kYg = bool;
      ac.i("MicroMsg.AppBrandHTMLWebView", "<init> end total construct hash[%d], supportOrientationControl[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.kYg) });
      AppMethodBeat.o(46990);
      return;
    }
  }
  
  private void bls()
  {
    AppMethodBeat.i(47003);
    this.hqK.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
    AppMethodBeat.o(47003);
  }
  
  private q getGameResourceReporter()
  {
    AppMethodBeat.i(180293);
    q localq = this.jZO.getRuntime().aTT().getReporter().bov();
    AppMethodBeat.o(180293);
    return localq;
  }
  
  private void setCurrentURL(String paramString)
  {
    AppMethodBeat.i(47005);
    this.kYd = paramString;
    if (!bs.isNullOrNil(paramString))
    {
      paramString = Uri.parse(paramString).getHost();
      if (!bs.isNullOrNil(paramString))
      {
        setPullDownText$d3a6df8(getContext().getString(2131766116, new Object[] { paramString }));
        AppMethodBeat.o(47005);
        return;
      }
    }
    setPullDownText$d3a6df8("");
    AppMethodBeat.o(47005);
  }
  
  private void setPullDownText$d3a6df8(String paramString)
  {
    AppMethodBeat.i(47006);
    if (this.kYb != null) {
      this.kYb.setPullDownText(paramString);
    }
    AppMethodBeat.o(47006);
  }
  
  public final boolean CC()
  {
    return this.jZO instanceof d;
  }
  
  public final void NO(String paramString)
  {
    AppMethodBeat.i(46998);
    if ((TextUtils.isEmpty(paramString)) || (URLUtil.isValidUrl(paramString)))
    {
      AppMethodBeat.o(46998);
      return;
    }
    this.jZO.LB(paramString);
    AppMethodBeat.o(46998);
  }
  
  public final void NP(String paramString)
  {
    AppMethodBeat.i(46999);
    ac.i("MicroMsg.AppBrandHTMLWebView", "onPageStarted url[%s] hash[%d] destroyed[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed) });
    if (this.mDestroyed)
    {
      AppMethodBeat.o(46999);
      return;
    }
    bls();
    this.hqJ.start();
    new c((byte)0).g(this.jZO).q("src", paramString).q("htmlId", Integer.valueOf(this.mViewId)).beN();
    AppMethodBeat.o(46999);
  }
  
  public final void NQ(String paramString)
  {
    AppMethodBeat.i(186788);
    if (this.mDestroyed)
    {
      ac.i("MicroMsg.AppBrandHTMLWebView", "onPageCommitVisible url[%s] hash[%d] destroyed[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed) });
      AppMethodBeat.o(186788);
      return;
    }
    bls();
    AppMethodBeat.o(186788);
  }
  
  public final void V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46997);
    this.kYa.a(this.jZO.getRuntime().aTU(), this.jZO.aUT()).LN(paramJSONObject.toString()).beN();
    AppMethodBeat.o(46997);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(46986);
    if (!this.mDestroyed) {
      this.kYi.add(parama);
    }
    AppMethodBeat.o(46986);
  }
  
  public final void a(String paramString, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(180294);
    Object localObject1 = getGameResourceReporter();
    Object localObject2 = this.jZO;
    if ((((q)localObject1).lTc) || (paramWebResourceRequest == null))
    {
      AppMethodBeat.o(180294);
      return;
    }
    ((q)localObject1).pageUrl = paramString;
    ((q)localObject1).url = paramWebResourceRequest.getUrl().toString();
    ((q)localObject1).method = paramWebResourceRequest.getMethod();
    ((q)localObject1).referer = ((String)paramWebResourceRequest.getRequestHeaders().get("Referer"));
    paramString = ((ae)localObject2).getRuntime().aTR();
    if (paramString != null) {
      ((q)localObject1).aBM = paramString.jEg.pkgVersion;
    }
    ((q)localObject1).lTf = g.getNetworkType(ai.getContext());
    paramString = ((ae)localObject2).getRuntime();
    if (paramString == null)
    {
      paramString = null;
      if (paramString == null) {
        break label410;
      }
      ((q)localObject1).appType = paramString.cca;
    }
    for (;;)
    {
      ((q)localObject1).appType += 1000;
      if (!((q)localObject1).lTc)
      {
        ac.i("MicroMsg.AppBrand.Report.kv_19358", "report " + ((q)localObject1).toString());
        paramString = ((q)localObject1).appId;
        int i = ((q)localObject1).aBM;
        int j = ((q)localObject1).cYO;
        int k = ((q)localObject1).appType;
        paramWebResourceRequest = ((q)localObject1).lTf;
        localObject2 = ((q)localObject1).pageUrl;
        String str1 = ((q)localObject1).url;
        String str2 = ((q)localObject1).method;
        int m = ((q)localObject1).lUr;
        int n = ((q)localObject1).lUs;
        int i1 = ((q)localObject1).statusCode;
        int i2 = ((q)localObject1).lUt;
        localObject1 = ((q)localObject1).referer;
        com.tencent.mm.plugin.report.service.h.wUl.f(19358, com.tencent.mm.plugin.appbrand.report.o.l(new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramWebResourceRequest, localObject2, str1, str2, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), localObject1 }));
      }
      AppMethodBeat.o(180294);
      return;
      paramString = paramString.aTS();
      break;
      label410:
      ((q)localObject1).appType = com.tencent.mm.plugin.appbrand.report.h.QD(((q)localObject1).appId);
      ac.i("MicroMsg.AppBrand.Report.kv_19358", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(((q)localObject1).appType) });
    }
  }
  
  public final void bL(String paramString)
  {
    AppMethodBeat.i(47000);
    ac.i("MicroMsg.AppBrandHTMLWebView", "onPageFinished url[%s] hash[%d] destroyed[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed) });
    if (this.mDestroyed)
    {
      AppMethodBeat.o(47000);
      return;
    }
    bls();
    this.hqJ.finish();
    if ((!this.kYe) && (!this.kYf))
    {
      com.tencent.mm.plugin.appbrand.report.model.p localp = getReporter();
      ae localae = this.jZO;
      String str = this.kYd;
      localp.lTg = ((String)localp.lUm.peekFirst());
      localp.lTh = 2;
      localp.lTi = paramString;
      localp.lUm.push(str);
      localp.w(localae);
    }
    this.kYe = false;
    this.kYf = false;
    setCurrentURL(paramString);
    new b((byte)0).g(this.jZO).q("src", paramString).q("htmlId", Integer.valueOf(this.mViewId)).beN();
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186773);
        new com.tencent.mm.plugin.appbrand.game.e.b.b().a(a.b(a.this).aTU(), b.a.jRK, a.g(a.this));
        AppMethodBeat.o(186773);
      }
    }, 1000L);
    AppMethodBeat.o(47000);
  }
  
  public final void blo()
  {
    AppMethodBeat.i(46988);
    ac.i("MicroMsg.AppBrandHTMLWebView", "restoreRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.hqK.onShow();
    AppMethodBeat.o(46988);
  }
  
  public final void blp()
  {
    AppMethodBeat.i(46989);
    ac.i("MicroMsg.AppBrandHTMLWebView", "pauseRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.hqK.onHide();
    AppMethodBeat.o(46989);
  }
  
  public final boolean blq()
  {
    return !this.kYg;
  }
  
  public final void blr()
  {
    AppMethodBeat.i(47002);
    this.jZO.getRuntime().aTT().PH("scene_other");
    AppMethodBeat.o(47002);
  }
  
  public final boolean blt()
  {
    AppMethodBeat.i(47008);
    try
    {
      if (this.jZO.getRuntime().aTR().ccb)
      {
        bool = this.jZO.getRuntime().aTR().ccq;
        AppMethodBeat.o(47008);
        return bool;
      }
      boolean bool = this.jZO.getRuntime().aTR().ccn;
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
        if (!a.c(a.this))
        {
          ac.i("MicroMsg.AppBrandHTMLWebView", "destroy hash[%d]", new Object[] { Integer.valueOf(a.this.hashCode()) });
          a.a(a.this).cleanup();
          a.d(a.this).stopLoading();
          a.d(a.this).destroy();
          a.e(a.this).clear();
          b localb = b.kYn;
          b.j(a.this);
          a.f(a.this);
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
      if ((!bool) && (this.kYb != null)) {
        this.kYb.requestDisallowInterceptTouchEvent(false);
      }
      AppMethodBeat.o(46992);
      return bool;
      if (this.kYb != null)
      {
        this.kYb.requestDisallowInterceptTouchEvent(true);
        continue;
        if (this.kYb != null) {
          this.kYb.requestDisallowInterceptTouchEvent(false);
        }
      }
    }
  }
  
  public final String getAppId()
  {
    return this.mAppId;
  }
  
  public final int getBinderID()
  {
    AppMethodBeat.i(174921);
    int i = this.kYc.getBinderID();
    AppMethodBeat.o(174921);
    return i;
  }
  
  public final String[] getJsApiReportArgs()
  {
    AppMethodBeat.i(47007);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(47007);
      return new String[0];
    }
    Object localObject5 = this.jZO;
    Object localObject2 = ((ae)localObject5).getRuntime();
    Object localObject4 = ((com.tencent.luggage.sdk.d.c)localObject2).DC().ccl;
    Object localObject3 = ((com.tencent.mm.plugin.appbrand.o)localObject2).aTS();
    Object localObject1 = ((ae)localObject5).bqU();
    String str1 = ((AppBrandStatObject)localObject4).scene;
    String str2 = ((AppBrandStatObject)localObject4).cYP;
    String str3 = ((AppBrandRuntime)localObject2).mAppId;
    String str4 = ((com.tencent.mm.plugin.appbrand.o)localObject2).aTR().jEg.pkgVersion;
    localObject3 = ((AppBrandInitConfigWC)localObject3).CD();
    String str5 = ((com.tencent.mm.plugin.appbrand.o)localObject2).aTR().jEg.jpa + 1;
    String str6 = ((AppBrandStatObject)localObject4).lRH;
    String str7 = ((aa)localObject5).jZJ;
    if (localObject1 == null) {}
    for (localObject1 = "";; localObject1 = ((a)localObject1).getWebView().getUrl())
    {
      localObject5 = g.getNetworkType(((ae)localObject5).getContext());
      String str8 = ((AppBrandStatObject)localObject4).dxE;
      localObject4 = ((AppBrandStatObject)localObject4).dxF;
      localObject2 = ((com.tencent.mm.plugin.appbrand.o)localObject2).aTS().cca + 1000;
      AppMethodBeat.o(47007);
      return new String[] { str1, str2, str3, str4, localObject3, str5, str6, str7, localObject1, localObject5, "", "", "", "", "", "", str8, localObject4, localObject2 };
    }
  }
  
  public final aa getPageView()
  {
    return this.jZO;
  }
  
  final com.tencent.mm.plugin.appbrand.report.model.p getReporter()
  {
    AppMethodBeat.i(47004);
    com.tencent.mm.plugin.appbrand.report.model.p localp = this.jZO.getRuntime().aTT().getReporter().bou();
    AppMethodBeat.o(47004);
    return localp;
  }
  
  public final MMWebView getWebView()
  {
    return this.hqK;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(46994);
    super.onAttachedToWindow();
    this.ckZ = n.dd(this);
    if (this.ckZ != null) {
      this.ckZ.a(this.clb);
    }
    this.kYb = ((com.tencent.mm.plugin.appbrand.page.b.f)this.jZO.Q(com.tencent.mm.plugin.appbrand.page.b.f.class));
    this.kYh = new d((byte)0);
    d locald = this.kYh;
    locald.kYl.jZO.a(locald);
    locald.kYl.jZO.a(locald);
    this.kYh.onForeground();
    AppMethodBeat.o(46994);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(46995);
    super.onDetachedFromWindow();
    if (!this.jZO.isRunning()) {
      destroy();
    }
    if (this.ckZ != null) {
      this.ckZ.b(this.clb);
    }
    if (this.kYh != null)
    {
      this.kYh.onBackground();
      d locald = this.kYh;
      locald.kYl.jZO.b(locald);
      locald.kYl.jZO.b(locald);
      this.kYh = null;
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
  
  public final void r(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(47001);
    new e((byte)0).g(this.jZO).q("htmlId", Integer.valueOf(this.mViewId)).q("errorCode", Integer.valueOf(paramInt)).q("description", paramString2).q("src", paramString1).beN();
    AppMethodBeat.o(47001);
  }
  
  public final void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(46996);
    if (ap.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(46996);
      return;
    }
    post(paramRunnable);
    AppMethodBeat.o(46996);
  }
  
  public final void setViewId(int paramInt)
  {
    this.mViewId = paramInt;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(46987);
    if (paramInt != getVisibility())
    {
      super.setVisibility(paramInt);
      Iterator localIterator = this.kYi.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).blv();
      }
    }
    AppMethodBeat.o(46987);
  }
  
  public static abstract interface a
  {
    public abstract void blv();
  }
  
  static final class b
    extends com.tencent.mm.plugin.appbrand.jsapi.p
  {
    public static final int CTRL_INDEX = 505;
    public static final String NAME = "onWebviewFinishLoad";
  }
  
  static final class c
    extends com.tencent.mm.plugin.appbrand.jsapi.p
  {
    public static final int CTRL_INDEX = 504;
    public static final String NAME = "onWebviewStartLoad";
  }
  
  final class d
    implements f.b, f.d
  {
    private d() {}
    
    public final void onBackground()
    {
      AppMethodBeat.i(46984);
      a.a(a.this).onBackground();
      AppMethodBeat.o(46984);
    }
    
    public final void onForeground()
    {
      AppMethodBeat.i(46985);
      a.a(a.this).onForeground();
      AppMethodBeat.o(46985);
    }
  }
  
  static final class e
    extends com.tencent.mm.plugin.appbrand.jsapi.p
  {
    public static final int CTRL_INDEX = 506;
    public static final String NAME = "onWebviewError";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.a
 * JD-Core Version:    0.7.0.1
 */