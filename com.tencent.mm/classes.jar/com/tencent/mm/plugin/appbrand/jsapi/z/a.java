package com.tencent.mm.plugin.appbrand.jsapi.z;

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
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.b.e;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.model.q;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.t;
import com.tencent.xweb.y;
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
  private com.tencent.mm.plugin.appbrand.widget.input.u cnX;
  private final u.c cnY;
  private MMFalseProgressBar gQj;
  public MMWebView gQk;
  ae jzr;
  private c kwM;
  private com.tencent.mm.plugin.appbrand.page.b.f kwN;
  final e.a kwO;
  private String kwP;
  private boolean kwQ;
  boolean kwR;
  private boolean kwS;
  private d kwT;
  private final Set<a> kwU;
  private com.tencent.xweb.aa kwV;
  private com.tencent.xweb.x5.export.external.extension.proxy.a kwW;
  private String mAppId;
  boolean mDestroyed;
  private int mViewId;
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public a(Context paramContext, AppBrandRuntime paramAppBrandRuntime, ae paramae)
  {
    super(new MutableContextWrapper(paramContext));
    AppMethodBeat.i(46990);
    this.mViewId = 0;
    this.kwP = "";
    this.kwQ = true;
    this.kwR = false;
    this.cnX = null;
    this.cnY = new u.c()
    {
      private int cgR = 0;
      
      public final void bu(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46965);
        a.a(a.this).s(paramAnonymousBoolean, this.cgR);
        AppMethodBeat.o(46965);
      }
      
      public final void gM(int paramAnonymousInt)
      {
        this.cgR = paramAnonymousInt;
      }
      
      public final int getHeight()
      {
        return this.cgR;
      }
    };
    this.kwU = new android.support.v4.e.b();
    this.mDestroyed = false;
    this.kwV = new a.7(this);
    this.kwW = new a.8(this);
    ad.i("MicroMsg.AppBrandHTMLWebView", "<init> start hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.kwM = new c();
    this.kwM.g(paramae);
    this.jzr = paramae;
    this.gQk = MMWebViewWithJsApi.a.gJ(new MutableContextWrapper(paramContext));
    this.gQk.setBackgroundColor(0);
    this.gQk.getSettings().frg();
    this.gQk.getSettings().setJavaScriptEnabled(true);
    this.gQk.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.gQk.getSettings().fri();
    paramae = this.gQk.getSettings().getUserAgentString();
    paramAppBrandRuntime = paramae;
    if (!x.aCK(paramae)) {
      paramAppBrandRuntime = x.bR(getContext(), paramae);
    }
    paramAppBrandRuntime = paramAppBrandRuntime + " miniProgram";
    this.gQk.getSettings().setUserAgentString(paramAppBrandRuntime);
    this.gQk.getView().setHorizontalScrollBarEnabled(false);
    this.gQk.getView().setVerticalScrollBarEnabled(false);
    this.gQk.getSettings().setBuiltInZoomControls(true);
    this.gQk.getSettings().setUseWideViewPort(true);
    this.gQk.getSettings().setLoadWithOverviewMode(true);
    this.gQk.getSettings().fqZ();
    this.gQk.getSettings().fqY();
    this.gQk.getSettings().setGeolocationEnabled(true);
    this.gQk.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.gQk.getSettings().fre();
    this.gQk.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.gQk.getSettings().frd();
    this.gQk.getSettings().frf();
    this.gQk.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.ahY() + "databases/");
    this.gQk.setWebViewCallbackClient(this.kwV);
    if (this.gQk.getIsX5Kernel()) {
      this.gQk.setWebViewClientExtension(this.kwW);
    }
    this.gQk.getSettings().setUsingForAppBrand(2);
    this.gQk.setDownloadListener(new a.2(this));
    ad.i("MicroMsg.AppBrandHTMLWebView", "<init> end WebView construct hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    addView(this.gQk, new ViewGroup.LayoutParams(-1, -1));
    this.gQj = new MMFalseProgressBar(paramContext);
    this.gQj.setProgressDrawable(com.tencent.mm.cd.a.l(paramContext, 2131233300));
    addView(this.gQj, new ViewGroup.LayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(paramContext, 3)));
    this.kwO = new f(this);
    this.jzr.a(new f.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(46967);
        a.this.destroy();
        AppMethodBeat.o(46967);
      }
    });
    getReporter().lsu = true;
    paramContext = b.kwZ;
    b.i(this);
    paramContext = this.gQk.setVideoJsCallback(new a.4(this));
    if ((paramContext != null) && (paramContext.fqN())) {}
    for (boolean bool = true;; bool = false)
    {
      this.kwS = bool;
      ad.i("MicroMsg.AppBrandHTMLWebView", "<init> end total construct hash[%d], supportOrientationControl[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.kwS) });
      AppMethodBeat.o(46990);
      return;
    }
  }
  
  private void bey()
  {
    AppMethodBeat.i(47003);
    this.gQk.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
    AppMethodBeat.o(47003);
  }
  
  private q getGameResourceReporter()
  {
    AppMethodBeat.i(180293);
    q localq = this.jzr.getRuntime().aNd().getReporter().bhB();
    AppMethodBeat.o(180293);
    return localq;
  }
  
  private void setCurrentURL(String paramString)
  {
    AppMethodBeat.i(47005);
    this.kwP = paramString;
    if (!bt.isNullOrNil(paramString))
    {
      paramString = Uri.parse(paramString).getHost();
      if (!bt.isNullOrNil(paramString))
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
    if (this.kwN != null) {
      this.kwN.setPullDownText(paramString);
    }
    AppMethodBeat.o(47006);
  }
  
  public final boolean CZ()
  {
    return this.jzr instanceof d;
  }
  
  public final void JH(String paramString)
  {
    AppMethodBeat.i(46998);
    if ((TextUtils.isEmpty(paramString)) || (URLUtil.isValidUrl(paramString)))
    {
      AppMethodBeat.o(46998);
      return;
    }
    this.jzr.Hx(paramString);
    AppMethodBeat.o(46998);
  }
  
  public final void JI(String paramString)
  {
    AppMethodBeat.i(46999);
    ad.i("MicroMsg.AppBrandHTMLWebView", "onPageStarted url[%s] hash[%d] destroyed[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed) });
    if (this.mDestroyed)
    {
      AppMethodBeat.o(46999);
      return;
    }
    bey();
    this.gQj.start();
    new a.c((byte)0).g(this.jzr).r("src", paramString).r("htmlId", Integer.valueOf(this.mViewId)).aXQ();
    AppMethodBeat.o(46999);
  }
  
  public final void JJ(String paramString)
  {
    AppMethodBeat.i(195966);
    if (this.mDestroyed)
    {
      ad.i("MicroMsg.AppBrandHTMLWebView", "onPageCommitVisible url[%s] hash[%d] destroyed[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed) });
      AppMethodBeat.o(195966);
      return;
    }
    bey();
    AppMethodBeat.o(195966);
  }
  
  public final void V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46997);
    this.kwM.a(this.jzr.getRuntime().aNe(), this.jzr.aOd()).HJ(paramJSONObject.toString()).aXQ();
    AppMethodBeat.o(46997);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(46986);
    if (!this.mDestroyed) {
      this.kwU.add(parama);
    }
    AppMethodBeat.o(46986);
  }
  
  public final void a(String paramString, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(180294);
    Object localObject1 = getGameResourceReporter();
    Object localObject2 = this.jzr;
    if ((((q)localObject1).lrh) || (paramWebResourceRequest == null))
    {
      AppMethodBeat.o(180294);
      return;
    }
    ((q)localObject1).jzG = paramString;
    ((q)localObject1).url = paramWebResourceRequest.getUrl().toString();
    ((q)localObject1).method = paramWebResourceRequest.getMethod();
    ((q)localObject1).referer = ((String)paramWebResourceRequest.getRequestHeaders().get("Referer"));
    paramString = ((ae)localObject2).getRuntime().aNb();
    if (paramString != null) {
      ((q)localObject1).aAS = paramString.jdS.pkgVersion;
    }
    ((q)localObject1).lrk = com.tencent.mm.plugin.appbrand.report.h.getNetworkType(aj.getContext());
    paramString = ((ae)localObject2).getRuntime();
    if (paramString == null)
    {
      paramString = null;
      if (paramString == null) {
        break label410;
      }
      ((q)localObject1).appType = paramString.cfd;
    }
    for (;;)
    {
      ((q)localObject1).appType += 1000;
      if (!((q)localObject1).lrh)
      {
        ad.i("MicroMsg.AppBrand.Report.kv_19358", "report " + ((q)localObject1).toString());
        paramString = ((q)localObject1).appId;
        int i = ((q)localObject1).aAS;
        int j = ((q)localObject1).dbs;
        int k = ((q)localObject1).appType;
        paramWebResourceRequest = ((q)localObject1).lrk;
        localObject2 = ((q)localObject1).jzG;
        String str1 = ((q)localObject1).url;
        String str2 = ((q)localObject1).method;
        int m = ((q)localObject1).lsx;
        int n = ((q)localObject1).lsy;
        int i1 = ((q)localObject1).statusCode;
        int i2 = ((q)localObject1).lsz;
        localObject1 = ((q)localObject1).referer;
        com.tencent.mm.plugin.report.service.h.vKh.f(19358, com.tencent.mm.plugin.appbrand.report.p.k(new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramWebResourceRequest, localObject2, str1, str2, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), localObject1 }));
      }
      AppMethodBeat.o(180294);
      return;
      paramString = paramString.aNc();
      break;
      label410:
      ((q)localObject1).appType = i.Mu(((q)localObject1).appId);
      ad.i("MicroMsg.AppBrand.Report.kv_19358", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(((q)localObject1).appType) });
    }
  }
  
  public final void bV(String paramString)
  {
    AppMethodBeat.i(47000);
    ad.i("MicroMsg.AppBrandHTMLWebView", "onPageFinished url[%s] hash[%d] destroyed[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed) });
    if (this.mDestroyed)
    {
      AppMethodBeat.o(47000);
      return;
    }
    bey();
    this.gQj.finish();
    if ((!this.kwQ) && (!this.kwR))
    {
      com.tencent.mm.plugin.appbrand.report.model.p localp = getReporter();
      ae localae = this.jzr;
      String str = this.kwP;
      localp.lrl = ((String)localp.lss.peekFirst());
      localp.lrm = 2;
      localp.lrn = paramString;
      localp.lss.push(str);
      localp.w(localae);
    }
    this.kwQ = false;
    this.kwR = false;
    setCurrentURL(paramString);
    new a.b((byte)0).g(this.jzr).r("src", paramString).r("htmlId", Integer.valueOf(this.mViewId)).aXQ();
    aq.n(new a.6(this), 1000L);
    AppMethodBeat.o(47000);
  }
  
  public final void beu()
  {
    AppMethodBeat.i(46988);
    ad.i("MicroMsg.AppBrandHTMLWebView", "restoreRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.gQk.onShow();
    AppMethodBeat.o(46988);
  }
  
  public final void bev()
  {
    AppMethodBeat.i(46989);
    ad.i("MicroMsg.AppBrandHTMLWebView", "pauseRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.gQk.onHide();
    AppMethodBeat.o(46989);
  }
  
  public final boolean bew()
  {
    return !this.kwS;
  }
  
  public final void bex()
  {
    AppMethodBeat.i(47002);
    this.jzr.getRuntime().aNd().Lz("scene_other");
    AppMethodBeat.o(47002);
  }
  
  public final boolean bez()
  {
    AppMethodBeat.i(47008);
    try
    {
      if (this.jzr.getRuntime().aNb().cfe)
      {
        bool = this.jzr.getRuntime().aNb().cft;
        AppMethodBeat.o(47008);
        return bool;
      }
      boolean bool = this.jzr.getRuntime().aNb().cfq;
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
          ad.i("MicroMsg.AppBrandHTMLWebView", "destroy hash[%d]", new Object[] { Integer.valueOf(a.this.hashCode()) });
          a.a(a.this).cleanup();
          a.d(a.this).stopLoading();
          a.d(a.this).destroy();
          a.e(a.this).clear();
          b localb = b.kwZ;
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
      if ((!bool) && (this.kwN != null)) {
        this.kwN.requestDisallowInterceptTouchEvent(false);
      }
      AppMethodBeat.o(46992);
      return bool;
      if (this.kwN != null)
      {
        this.kwN.requestDisallowInterceptTouchEvent(true);
        continue;
        if (this.kwN != null) {
          this.kwN.requestDisallowInterceptTouchEvent(false);
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
    int i = this.kwO.getBinderID();
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
    Object localObject5 = this.jzr;
    Object localObject2 = ((ae)localObject5).getRuntime();
    Object localObject4 = ((com.tencent.luggage.sdk.d.c)localObject2).DZ().cfo;
    Object localObject3 = ((o)localObject2).aNc();
    Object localObject1 = ((ae)localObject5).bkd();
    String str1 = ((AppBrandStatObject)localObject4).scene;
    String str2 = ((AppBrandStatObject)localObject4).dbt;
    String str3 = ((AppBrandRuntime)localObject2).mAppId;
    String str4 = ((o)localObject2).aNb().jdS.pkgVersion;
    localObject3 = ((AppBrandInitConfigWC)localObject3).Da();
    String str5 = ((o)localObject2).aNb().jdS.iOQ + 1;
    String str6 = ((AppBrandStatObject)localObject4).lpL;
    String str7 = ((com.tencent.mm.plugin.appbrand.page.aa)localObject5).jzm;
    if (localObject1 == null) {}
    for (localObject1 = "";; localObject1 = ((a)localObject1).getWebView().getUrl())
    {
      localObject5 = com.tencent.mm.plugin.appbrand.report.h.getNetworkType(((ae)localObject5).getContext());
      String str8 = ((AppBrandStatObject)localObject4).dzS;
      localObject4 = ((AppBrandStatObject)localObject4).dzT;
      localObject2 = ((o)localObject2).aNc().cfd + 1000;
      AppMethodBeat.o(47007);
      return new String[] { str1, str2, str3, str4, localObject3, str5, str6, str7, localObject1, localObject5, "", "", "", "", "", "", str8, localObject4, localObject2 };
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.page.aa getPageView()
  {
    return this.jzr;
  }
  
  final com.tencent.mm.plugin.appbrand.report.model.p getReporter()
  {
    AppMethodBeat.i(47004);
    com.tencent.mm.plugin.appbrand.report.model.p localp = this.jzr.getRuntime().aNd().getReporter().bhA();
    AppMethodBeat.o(47004);
    return localp;
  }
  
  public final MMWebView getWebView()
  {
    return this.gQk;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(46994);
    super.onAttachedToWindow();
    this.cnX = n.db(this);
    if (this.cnX != null) {
      this.cnX.a(this.cnY);
    }
    this.kwN = ((com.tencent.mm.plugin.appbrand.page.b.f)this.jzr.Q(com.tencent.mm.plugin.appbrand.page.b.f.class));
    this.kwT = new d((byte)0);
    d locald = this.kwT;
    locald.kwX.jzr.a(locald);
    locald.kwX.jzr.a(locald);
    this.kwT.onForeground();
    AppMethodBeat.o(46994);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(46995);
    super.onDetachedFromWindow();
    if (!this.jzr.isRunning()) {
      destroy();
    }
    if (this.cnX != null) {
      this.cnX.b(this.cnY);
    }
    if (this.kwT != null)
    {
      this.kwT.onBackground();
      d locald = this.kwT;
      locald.kwX.jzr.b(locald);
      locald.kwX.jzr.b(locald);
      this.kwT = null;
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
    new a.e((byte)0).g(this.jzr).r("htmlId", Integer.valueOf(this.mViewId)).r("errorCode", Integer.valueOf(paramInt)).r("description", paramString2).r("src", paramString1).aXQ();
    AppMethodBeat.o(47001);
  }
  
  public final void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(46996);
    if (aq.isMainThread())
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
      Iterator localIterator = this.kwU.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).beB();
      }
    }
    AppMethodBeat.o(46987);
  }
  
  public static abstract interface a
  {
    public abstract void beB();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.a
 * JD-Core Version:    0.7.0.1
 */