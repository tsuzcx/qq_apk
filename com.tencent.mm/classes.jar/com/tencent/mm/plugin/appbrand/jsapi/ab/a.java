package com.tencent.mm.plugin.appbrand.jsapi.ab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.t;
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
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.b.e;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.model.q;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  implements e.c, e
{
  private com.tencent.mm.plugin.appbrand.widget.input.u cvB;
  private final u.c cvD;
  private MMFalseProgressBar hJb;
  public MMWebView hJc;
  ae kuk;
  private c lvb;
  private com.tencent.mm.plugin.appbrand.page.b.f lvc;
  final e.a lvd;
  private String lve;
  private boolean lvf;
  boolean lvg;
  private boolean lvh;
  private d lvi;
  private final Set<a> lvj;
  private final e.b lvk;
  private ab lvl;
  private com.tencent.xweb.x5.export.external.extension.proxy.a lvm;
  private String mAppId;
  boolean mDestroyed;
  private int mViewId;
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public a(Context paramContext, AppBrandRuntime paramAppBrandRuntime, ae paramae)
  {
    super(new MutableContextWrapper(paramContext));
    AppMethodBeat.i(46990);
    this.mViewId = 0;
    this.lve = "";
    this.lvf = true;
    this.lvg = false;
    this.cvB = null;
    this.cvD = new u.c()
    {
      private int cod = 0;
      
      public final void bu(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46965);
        a.a(a.this).s(paramAnonymousBoolean, this.cod);
        AppMethodBeat.o(46965);
      }
      
      public final void gB(int paramAnonymousInt)
      {
        this.cod = paramAnonymousInt;
      }
      
      public final int getHeight()
      {
        return this.cod;
      }
    };
    this.lvj = new android.support.v4.e.b();
    this.mDestroyed = false;
    this.lvk = new a.7(this);
    this.lvl = new a.8(this);
    this.lvm = new a.9(this);
    ad.i("MicroMsg.AppBrandHTMLWebView", "<init> start hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.lvb = new c();
    this.lvb.g(paramae);
    this.kuk = paramae;
    this.hJc = MMWebViewWithJsApi.a.gZ(new MutableContextWrapper(paramContext));
    this.hJc.setBackgroundColor(0);
    this.hJc.getSettings().gbb();
    this.hJc.getSettings().setJavaScriptEnabled(true);
    this.hJc.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.hJc.getSettings().gbd();
    paramae = this.hJc.getSettings().getUserAgentString();
    paramAppBrandRuntime = paramae;
    if (!x.aNE(paramae)) {
      paramAppBrandRuntime = x.bW(getContext(), paramae);
    }
    paramAppBrandRuntime = paramAppBrandRuntime + " miniProgram";
    this.hJc.getSettings().setUserAgentString(paramAppBrandRuntime);
    this.hJc.getView().setHorizontalScrollBarEnabled(false);
    this.hJc.getView().setVerticalScrollBarEnabled(false);
    this.hJc.getSettings().setBuiltInZoomControls(true);
    this.hJc.getSettings().setUseWideViewPort(true);
    this.hJc.getSettings().setLoadWithOverviewMode(true);
    this.hJc.getSettings().gaU();
    this.hJc.getSettings().gaT();
    this.hJc.getSettings().setGeolocationEnabled(true);
    this.hJc.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.hJc.getSettings().gaZ();
    this.hJc.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.hJc.getSettings().gaY();
    this.hJc.getSettings().gba();
    this.hJc.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.arL() + "databases/");
    this.hJc.setWebViewCallbackClient(this.lvl);
    if (this.hJc.getIsX5Kernel()) {
      this.hJc.setWebViewClientExtension(this.lvm);
    }
    this.hJc.getSettings().setUsingForAppBrand(2);
    this.hJc.setDownloadListener(new a.2(this));
    ad.i("MicroMsg.AppBrandHTMLWebView", "<init> end WebView construct hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    addView(this.hJc, new ViewGroup.LayoutParams(-1, -1));
    this.hJb = new MMFalseProgressBar(paramContext);
    this.hJb.setProgressDrawable(com.tencent.mm.cc.a.l(paramContext, 2131233300));
    addView(this.hJb, new ViewGroup.LayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(paramContext, 3)));
    this.lvd = new f(this);
    this.kuk.a(new f.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(46967);
        a.this.destroy();
        AppMethodBeat.o(46967);
      }
    });
    getExitReporter().muf = true;
    paramContext = b.lvp;
    b.j(this);
    paramContext = this.hJc.setVideoJsCallback(new a.4(this));
    if ((paramContext != null) && (paramContext.gaH())) {}
    for (boolean bool = true;; bool = false)
    {
      this.lvh = bool;
      ad.i("MicroMsg.AppBrandHTMLWebView", "<init> end total construct hash[%d], supportOrientationControl[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.lvh) });
      AppMethodBeat.o(46990);
      return;
    }
  }
  
  private void bpd()
  {
    AppMethodBeat.i(47003);
    this.hJc.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
    AppMethodBeat.o(47003);
  }
  
  private q getGameResourceReporter()
  {
    AppMethodBeat.i(180293);
    q localq = this.kuk.getRuntime().aXd().getReporter().bsn();
    AppMethodBeat.o(180293);
    return localq;
  }
  
  private void setCurrentURL(String paramString)
  {
    AppMethodBeat.i(47005);
    this.lve = paramString;
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
    if (this.lvc != null) {
      this.lvc.setPullDownText(paramString);
    }
    AppMethodBeat.o(47006);
  }
  
  public final boolean Eb()
  {
    return this.kuk instanceof d;
  }
  
  public final void Rn(String paramString)
  {
    AppMethodBeat.i(46998);
    if ((TextUtils.isEmpty(paramString)) || (URLUtil.isValidUrl(paramString)))
    {
      AppMethodBeat.o(46998);
      return;
    }
    this.kuk.OV(paramString);
    AppMethodBeat.o(46998);
  }
  
  public final void Ro(String paramString)
  {
    AppMethodBeat.i(46999);
    ad.i("MicroMsg.AppBrandHTMLWebView", "onPageStarted url[%s] hash[%d] destroyed[%b] attached[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed), Boolean.valueOf(t.aC(this)) });
    if (this.mDestroyed)
    {
      AppMethodBeat.o(46999);
      return;
    }
    bpd();
    this.hJb.start();
    new a.c((byte)0).g(this.kuk).p("src", paramString).p("htmlId", Integer.valueOf(this.mViewId)).bir();
    AppMethodBeat.o(46999);
  }
  
  public final void Rp(String paramString)
  {
    AppMethodBeat.i(188554);
    if (this.mDestroyed)
    {
      ad.i("MicroMsg.AppBrandHTMLWebView", "onPageCommitVisible url[%s] hash[%d] destroyed[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed) });
      AppMethodBeat.o(188554);
      return;
    }
    bpd();
    AppMethodBeat.o(188554);
  }
  
  public final void X(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46997);
    this.lvb.a(this.kuk.getRuntime().aXe(), this.kuk.aXC()).Ph(paramJSONObject.toString()).bir();
    AppMethodBeat.o(46997);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(46986);
    if (!this.mDestroyed) {
      this.lvj.add(parama);
    }
    AppMethodBeat.o(46986);
  }
  
  public final void a(String paramString, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(180294);
    Object localObject1 = getGameResourceReporter();
    Object localObject2 = this.kuk;
    if ((((q)localObject1).msS) || (paramWebResourceRequest == null))
    {
      AppMethodBeat.o(180294);
      return;
    }
    ((q)localObject1).pageUrl = paramString;
    ((q)localObject1).url = paramWebResourceRequest.getUrl().toString();
    ((q)localObject1).method = paramWebResourceRequest.getMethod();
    ((q)localObject1).referer = ((String)paramWebResourceRequest.getRequestHeaders().get("Referer"));
    paramString = ((ae)localObject2).getRuntime().aXb();
    if (paramString != null) {
      ((q)localObject1).aDD = paramString.jYh.pkgVersion;
    }
    ((q)localObject1).msV = h.getNetworkType(aj.getContext());
    paramString = ((ae)localObject2).getRuntime();
    if (paramString == null)
    {
      paramString = null;
      if (paramString == null) {
        break label410;
      }
      ((q)localObject1).appType = paramString.cmr;
    }
    for (;;)
    {
      ((q)localObject1).appType += 1000;
      if (!((q)localObject1).msS)
      {
        ad.i("MicroMsg.AppBrand.Report.kv_19358", "report " + ((q)localObject1).toString());
        paramString = ((q)localObject1).appId;
        int i = ((q)localObject1).aDD;
        int j = ((q)localObject1).dkg;
        int k = ((q)localObject1).appType;
        paramWebResourceRequest = ((q)localObject1).msV;
        localObject2 = ((q)localObject1).pageUrl;
        String str1 = ((q)localObject1).url;
        String str2 = ((q)localObject1).method;
        int m = ((q)localObject1).mui;
        int n = ((q)localObject1).muj;
        int i1 = ((q)localObject1).statusCode;
        int i2 = ((q)localObject1).muk;
        localObject1 = ((q)localObject1).referer;
        g.yhR.f(19358, com.tencent.mm.plugin.appbrand.report.p.l(new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramWebResourceRequest, localObject2, str1, str2, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), localObject1 }));
      }
      AppMethodBeat.o(180294);
      return;
      paramString = paramString.aXc();
      break;
      label410:
      ((q)localObject1).appType = i.Uj(((q)localObject1).appId);
      ad.i("MicroMsg.AppBrand.Report.kv_19358", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(((q)localObject1).appType) });
    }
  }
  
  public final void boZ()
  {
    AppMethodBeat.i(46988);
    ad.i("MicroMsg.AppBrandHTMLWebView", "restoreRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.hJc.onShow();
    AppMethodBeat.o(46988);
  }
  
  public final void bpa()
  {
    AppMethodBeat.i(46989);
    ad.i("MicroMsg.AppBrandHTMLWebView", "pauseRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.hJc.onHide();
    AppMethodBeat.o(46989);
  }
  
  public final boolean bpb()
  {
    return !this.lvh;
  }
  
  public final void bpc()
  {
    AppMethodBeat.i(47002);
    this.kuk.getRuntime().aXd().Tk("scene_other");
    AppMethodBeat.o(47002);
  }
  
  public final boolean bpe()
  {
    AppMethodBeat.i(47008);
    try
    {
      if (this.kuk.getRuntime().aXb().cms)
      {
        bool = this.kuk.getRuntime().aXb().cmH;
        AppMethodBeat.o(47008);
        return bool;
      }
      boolean bool = this.kuk.getRuntime().aXb().cmE;
      AppMethodBeat.o(47008);
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(47008);
    }
    return false;
  }
  
  public final void cE(String paramString)
  {
    AppMethodBeat.i(47000);
    ad.i("MicroMsg.AppBrandHTMLWebView", "onPageFinished url[%s] hash[%d] destroyed[%b] attached[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed), Boolean.valueOf(t.aC(this)) });
    if (this.mDestroyed)
    {
      AppMethodBeat.o(47000);
      return;
    }
    bpd();
    this.hJb.finish();
    if ((!this.lvf) && (!this.lvg))
    {
      com.tencent.mm.plugin.appbrand.report.model.p localp = getExitReporter();
      ae localae = this.kuk;
      String str = this.lve;
      localp.msW = ((String)localp.mud.peekFirst());
      localp.msX = 2;
      localp.msY = paramString;
      localp.mud.push(str);
      localp.x(localae);
    }
    this.lvf = false;
    this.lvg = false;
    setCurrentURL(paramString);
    new a.b((byte)0).g(this.kuk).p("src", paramString).p("htmlId", Integer.valueOf(this.mViewId)).bir();
    aq.o(new a.6(this), 1000L);
    AppMethodBeat.o(47000);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(46991);
    Runnable local5 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(180277);
        if (!a.d(a.this))
        {
          ad.i("MicroMsg.AppBrandHTMLWebView", "destroy hash[%d]", new Object[] { Integer.valueOf(a.this.hashCode()) });
          a.a(a.this).cleanup();
          a.e(a.this).stopLoading();
          a.e(a.this).destroy();
          a.f(a.this).clear();
          b localb = b.lvp;
          b.k(a.this);
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
      if ((!bool) && (this.lvc != null)) {
        this.lvc.requestDisallowInterceptTouchEvent(false);
      }
      AppMethodBeat.o(46992);
      return bool;
      if (this.lvc != null)
      {
        this.lvc.requestDisallowInterceptTouchEvent(true);
        continue;
        if (this.lvc != null) {
          this.lvc.requestDisallowInterceptTouchEvent(false);
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
    int i = this.lvd.getBinderID();
    AppMethodBeat.o(174921);
    return i;
  }
  
  public final com.tencent.mm.plugin.appbrand.report.model.p getExitReporter()
  {
    AppMethodBeat.i(188555);
    com.tencent.mm.plugin.appbrand.report.model.p localp = this.kuk.getRuntime().aXd().getReporter().bsm();
    AppMethodBeat.o(188555);
    return localp;
  }
  
  public final String[] getJsApiReportArgs()
  {
    AppMethodBeat.i(47007);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(47007);
      return new String[0];
    }
    Object localObject5 = this.kuk;
    Object localObject2 = ((ae)localObject5).getRuntime();
    Object localObject4 = ((com.tencent.luggage.sdk.d.c)localObject2).Fb().cmC;
    Object localObject3 = ((o)localObject2).aXc();
    Object localObject1 = ((ae)localObject5).buV();
    String str1 = ((AppBrandStatObject)localObject4).scene;
    String str2 = ((AppBrandStatObject)localObject4).dkh;
    String str3 = ((AppBrandRuntime)localObject2).mAppId;
    String str4 = ((o)localObject2).aXb().jYh.pkgVersion;
    localObject3 = ((AppBrandInitConfigWC)localObject3).Ec();
    String str5 = ((o)localObject2).aXb().jYh.jIU + 1;
    String str6 = ((AppBrandStatObject)localObject4).mrx;
    String str7 = ((aa)localObject5).kuf;
    if (localObject1 == null) {}
    for (localObject1 = "";; localObject1 = ((a)localObject1).getWebView().getUrl())
    {
      localObject5 = h.getNetworkType(((ae)localObject5).getContext());
      String str8 = ((AppBrandStatObject)localObject4).dJQ;
      localObject4 = ((AppBrandStatObject)localObject4).dJR;
      localObject2 = ((o)localObject2).aXc().cmr + 1000;
      AppMethodBeat.o(47007);
      return new String[] { str1, str2, str3, str4, localObject3, str5, str6, str7, localObject1, localObject5, "", "", "", "", "", "", str8, localObject4, localObject2 };
    }
  }
  
  public final aa getPageView()
  {
    return this.kuk;
  }
  
  public final e.b getReporter()
  {
    return this.lvk;
  }
  
  public final MMWebView getWebView()
  {
    return this.hJc;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(46994);
    super.onAttachedToWindow();
    this.cvB = n.df(this);
    if (this.cvB != null) {
      this.cvB.a(this.cvD);
    }
    this.lvc = ((com.tencent.mm.plugin.appbrand.page.b.f)this.kuk.Q(com.tencent.mm.plugin.appbrand.page.b.f.class));
    this.lvi = new d((byte)0);
    d locald = this.lvi;
    locald.lvn.kuk.a(locald);
    locald.lvn.kuk.a(locald);
    this.lvi.onForeground();
    AppMethodBeat.o(46994);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(46995);
    super.onDetachedFromWindow();
    if (!this.kuk.isRunning()) {
      destroy();
    }
    if (this.cvB != null) {
      this.cvB.b(this.cvD);
    }
    if (this.lvi != null)
    {
      this.lvi.onBackground();
      d locald = this.lvi;
      locald.lvn.kuk.b(locald);
      locald.lvn.kuk.b(locald);
      this.lvi = null;
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
    if (aq.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(46996);
      return;
    }
    post(paramRunnable);
    AppMethodBeat.o(46996);
  }
  
  public final void s(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(47001);
    new a.e((byte)0).g(this.kuk).p("htmlId", Integer.valueOf(this.mViewId)).p("errorCode", Integer.valueOf(paramInt)).p("description", paramString2).p("src", paramString1).bir();
    AppMethodBeat.o(47001);
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
      Iterator localIterator = this.lvj.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).bpg();
      }
    }
    AppMethodBeat.o(46987);
  }
  
  public static abstract interface a
  {
    public abstract void bpg();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.a
 * JD-Core Version:    0.7.0.1
 */