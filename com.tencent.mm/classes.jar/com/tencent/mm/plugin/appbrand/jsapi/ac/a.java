package com.tencent.mm.plugin.appbrand.jsapi.ac;

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
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.model.q;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.ab;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class a
  extends FrameLayout
  implements e.c, e
{
  private com.tencent.mm.plugin.appbrand.widget.input.u cwf;
  private final u.c cwh;
  private MMFalseProgressBar hLU;
  public MMWebView hLV;
  ad kxA;
  private com.tencent.mm.plugin.appbrand.page.a.f lzA;
  final e.a lzB;
  private String lzC;
  private boolean lzD;
  boolean lzE;
  private boolean lzF;
  private d lzG;
  private final Set<a> lzH;
  private final e.b lzI;
  private ab lzJ;
  private com.tencent.xweb.x5.export.external.extension.proxy.a lzK;
  private c lzz;
  private String mAppId;
  boolean mDestroyed;
  private int mViewId;
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public a(Context paramContext, AppBrandRuntime paramAppBrandRuntime, ad paramad)
  {
    super(new MutableContextWrapper(paramContext));
    AppMethodBeat.i(46990);
    this.mViewId = 0;
    this.lzC = "";
    this.lzD = true;
    this.lzE = false;
    this.cwf = null;
    this.cwh = new u.c()
    {
      private int cof = 0;
      
      public final void bu(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46965);
        a.a(a.this).t(paramAnonymousBoolean, this.cof);
        AppMethodBeat.o(46965);
      }
      
      public final void gB(int paramAnonymousInt)
      {
        this.cof = paramAnonymousInt;
      }
      
      public final int getHeight()
      {
        return this.cof;
      }
    };
    this.lzH = new android.support.v4.e.b();
    this.mDestroyed = false;
    this.lzI = new e.b()
    {
      public final void C(ArrayList<IDKey> paramAnonymousArrayList)
      {
        AppMethodBeat.i(222697);
        g.yxI.b(paramAnonymousArrayList, false);
        try
        {
          com.tencent.mm.plugin.appbrand.p localp = a.b(a.this).getRuntime();
          paramAnonymousArrayList = paramAnonymousArrayList.iterator();
          while (paramAnonymousArrayList.hasNext())
          {
            IDKey localIDKey = (IDKey)paramAnonymousArrayList.next();
            long l1 = localIDKey.GetID();
            long l2 = localIDKey.GetKey();
            h.a(a.this.getAppId(), localp.aXx().aDD, localp.jzC.dQv, l1, l2, 1L);
          }
          AppMethodBeat.o(222697);
        }
        catch (NullPointerException paramAnonymousArrayList)
        {
          AppMethodBeat.o(222697);
          return;
        }
      }
      
      public final void tM(int paramAnonymousInt)
      {
        AppMethodBeat.i(222696);
        g.yxI.dD(1097, paramAnonymousInt);
        try
        {
          com.tencent.mm.plugin.appbrand.p localp = a.b(a.this).getRuntime();
          h.b(a.this.getAppId(), localp.aXx().aDD, localp.jzC.dQv, 1097, paramAnonymousInt);
          AppMethodBeat.o(222696);
          return;
        }
        catch (NullPointerException localNullPointerException)
        {
          AppMethodBeat.o(222696);
        }
      }
    };
    this.lzJ = new a.8(this);
    this.lzK = new a.9(this);
    ae.i("MicroMsg.AppBrandHTMLWebView", "<init> start hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.lzz = new c();
    this.lzz.g(paramad);
    this.kxA = paramad;
    this.hLV = MMWebViewWithJsApi.a.hf(new MutableContextWrapper(paramContext));
    this.hLV.setBackgroundColor(0);
    this.hLV.getSettings().gfD();
    this.hLV.getSettings().setJavaScriptEnabled(true);
    this.hLV.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.hLV.getSettings().gfF();
    paramad = this.hLV.getSettings().getUserAgentString();
    paramAppBrandRuntime = paramad;
    if (!x.aPb(paramad)) {
      paramAppBrandRuntime = x.bX(getContext(), paramad);
    }
    paramAppBrandRuntime = paramAppBrandRuntime + " miniProgram";
    this.hLV.getSettings().setUserAgentString(paramAppBrandRuntime);
    this.hLV.getView().setHorizontalScrollBarEnabled(false);
    this.hLV.getView().setVerticalScrollBarEnabled(false);
    this.hLV.getSettings().setBuiltInZoomControls(true);
    this.hLV.getSettings().setUseWideViewPort(true);
    this.hLV.getSettings().setLoadWithOverviewMode(true);
    this.hLV.getSettings().gfw();
    this.hLV.getSettings().gfv();
    this.hLV.getSettings().setGeolocationEnabled(true);
    this.hLV.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.hLV.getSettings().gfB();
    this.hLV.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.hLV.getSettings().gfA();
    this.hLV.getSettings().gfC();
    this.hLV.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.asa() + "databases/");
    this.hLV.setWebViewCallbackClient(this.lzJ);
    if (this.hLV.getIsX5Kernel()) {
      this.hLV.setWebViewClientExtension(this.lzK);
    }
    this.hLV.getSettings().setUsingForAppBrand(2);
    this.hLV.setDownloadListener(new a.2(this));
    ae.i("MicroMsg.AppBrandHTMLWebView", "<init> end WebView construct hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    addView(this.hLV, new ViewGroup.LayoutParams(-1, -1));
    this.hLU = new MMFalseProgressBar(paramContext);
    this.hLU.setProgressDrawable(com.tencent.mm.cb.a.l(paramContext, 2131233300));
    addView(this.hLU, new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(paramContext, 3)));
    this.lzB = new f(this);
    this.kxA.a(new f.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(46967);
        a.this.destroy();
        AppMethodBeat.o(46967);
      }
    });
    getExitReporter().mzc = true;
    paramContext = b.lzN;
    b.j(this);
    paramContext = this.hLV.setVideoJsCallback(new a.4(this));
    if ((paramContext != null) && (paramContext.gfj())) {}
    for (boolean bool = true;; bool = false)
    {
      this.lzF = bool;
      ae.i("MicroMsg.AppBrandHTMLWebView", "<init> end total construct hash[%d], supportOrientationControl[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.lzF) });
      AppMethodBeat.o(46990);
      return;
    }
  }
  
  private void bpN()
  {
    AppMethodBeat.i(47003);
    this.hLV.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
    AppMethodBeat.o(47003);
  }
  
  private q getGameResourceReporter()
  {
    AppMethodBeat.i(180293);
    q localq = this.kxA.getRuntime().aXy().getReporter().bsY();
    AppMethodBeat.o(180293);
    return localq;
  }
  
  private void setCurrentURL(String paramString)
  {
    AppMethodBeat.i(47005);
    this.lzC = paramString;
    if (!bu.isNullOrNil(paramString))
    {
      paramString = Uri.parse(paramString).getHost();
      if (!bu.isNullOrNil(paramString))
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
    if (this.lzA != null) {
      this.lzA.setPullDownText(paramString);
    }
    AppMethodBeat.o(47006);
  }
  
  public final boolean Ee()
  {
    return this.kxA instanceof com.tencent.mm.plugin.appbrand.game.f.d;
  }
  
  public final void RW(String paramString)
  {
    AppMethodBeat.i(46998);
    if ((TextUtils.isEmpty(paramString)) || (URLUtil.isValidUrl(paramString)))
    {
      AppMethodBeat.o(46998);
      return;
    }
    this.kxA.PD(paramString);
    AppMethodBeat.o(46998);
  }
  
  public final void RX(String paramString)
  {
    AppMethodBeat.i(46999);
    ae.i("MicroMsg.AppBrandHTMLWebView", "onPageStarted url[%s] hash[%d] destroyed[%b] attached[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed), Boolean.valueOf(t.aC(this)) });
    if (this.mDestroyed)
    {
      AppMethodBeat.o(46999);
      return;
    }
    bpN();
    this.hLU.start();
    new c((byte)0).g(this.kxA).p("src", paramString).p("htmlId", Integer.valueOf(this.mViewId)).bja();
    AppMethodBeat.o(46999);
  }
  
  public final void RY(String paramString)
  {
    AppMethodBeat.i(222713);
    if (this.mDestroyed)
    {
      ae.i("MicroMsg.AppBrandHTMLWebView", "onPageCommitVisible url[%s] hash[%d] destroyed[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed) });
      AppMethodBeat.o(222713);
      return;
    }
    bpN();
    AppMethodBeat.o(222713);
  }
  
  public final void X(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46997);
    this.lzz.a(this.kxA.getRuntime().aXz(), this.kxA.aXX()).PP(paramJSONObject.toString()).bja();
    AppMethodBeat.o(46997);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(46986);
    if (!this.mDestroyed) {
      this.lzH.add(parama);
    }
    AppMethodBeat.o(46986);
  }
  
  public final void a(String paramString, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(180294);
    Object localObject1 = getGameResourceReporter();
    Object localObject2 = this.kxA;
    if ((((q)localObject1).mxP) || (paramWebResourceRequest == null))
    {
      AppMethodBeat.o(180294);
      return;
    }
    ((q)localObject1).pageUrl = paramString;
    ((q)localObject1).url = paramWebResourceRequest.getUrl().toString();
    ((q)localObject1).method = paramWebResourceRequest.getMethod();
    ((q)localObject1).referer = ((String)paramWebResourceRequest.getRequestHeaders().get("Referer"));
    paramString = ((ad)localObject2).getRuntime().aXw();
    if (paramString != null) {
      ((q)localObject1).aDD = paramString.kbw.pkgVersion;
    }
    ((q)localObject1).mxS = h.getNetworkType(ak.getContext());
    paramString = ((ad)localObject2).getRuntime();
    if (paramString == null)
    {
      paramString = null;
      if (paramString == null) {
        break label410;
      }
      ((q)localObject1).appType = paramString.cmt;
    }
    for (;;)
    {
      ((q)localObject1).appType += 1000;
      if (!((q)localObject1).mxP)
      {
        ae.i("MicroMsg.AppBrand.Report.kv_19358", "report " + ((q)localObject1).toString());
        paramString = ((q)localObject1).appId;
        int i = ((q)localObject1).aDD;
        int j = ((q)localObject1).dli;
        int k = ((q)localObject1).appType;
        paramWebResourceRequest = ((q)localObject1).mxS;
        localObject2 = ((q)localObject1).pageUrl;
        String str1 = ((q)localObject1).url;
        String str2 = ((q)localObject1).method;
        int m = ((q)localObject1).mzf;
        int n = ((q)localObject1).mzg;
        int i1 = ((q)localObject1).statusCode;
        int i2 = ((q)localObject1).mzh;
        localObject1 = ((q)localObject1).referer;
        g.yxI.f(19358, com.tencent.mm.plugin.appbrand.report.p.k(new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramWebResourceRequest, localObject2, str1, str2, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), localObject1 }));
      }
      AppMethodBeat.o(180294);
      return;
      paramString = paramString.aXx();
      break;
      label410:
      ((q)localObject1).appType = i.UU(((q)localObject1).appId);
      ae.i("MicroMsg.AppBrand.Report.kv_19358", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(((q)localObject1).appType) });
    }
  }
  
  public final void bpJ()
  {
    AppMethodBeat.i(46988);
    ae.i("MicroMsg.AppBrandHTMLWebView", "restoreRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.hLV.onShow();
    AppMethodBeat.o(46988);
  }
  
  public final void bpK()
  {
    AppMethodBeat.i(46989);
    ae.i("MicroMsg.AppBrandHTMLWebView", "pauseRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.hLV.onHide();
    AppMethodBeat.o(46989);
  }
  
  public final boolean bpL()
  {
    return !this.lzF;
  }
  
  public final void bpM()
  {
    AppMethodBeat.i(47002);
    this.kxA.getRuntime().aXy().TT("scene_other");
    AppMethodBeat.o(47002);
  }
  
  public final boolean bpO()
  {
    AppMethodBeat.i(47008);
    try
    {
      if (this.kxA.getRuntime().aXw().cmu)
      {
        bool = this.kxA.getRuntime().aXw().cmJ;
        AppMethodBeat.o(47008);
        return bool;
      }
      boolean bool = this.kxA.getRuntime().aXw().cmG;
      AppMethodBeat.o(47008);
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(47008);
    }
    return false;
  }
  
  public final void cF(String paramString)
  {
    AppMethodBeat.i(47000);
    ae.i("MicroMsg.AppBrandHTMLWebView", "onPageFinished url[%s] hash[%d] destroyed[%b] attached[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed), Boolean.valueOf(t.aC(this)) });
    if (this.mDestroyed)
    {
      AppMethodBeat.o(47000);
      return;
    }
    bpN();
    this.hLU.finish();
    if ((!this.lzD) && (!this.lzE))
    {
      com.tencent.mm.plugin.appbrand.report.model.p localp = getExitReporter();
      ad localad = this.kxA;
      String str = this.lzC;
      localp.mxT = ((String)localp.mza.peekFirst());
      localp.mxU = 2;
      localp.mxV = paramString;
      localp.mza.push(str);
      localp.y(localad);
    }
    this.lzD = false;
    this.lzE = false;
    setCurrentURL(paramString);
    new b((byte)0).g(this.kxA).p("src", paramString).p("htmlId", Integer.valueOf(this.mViewId)).bja();
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222695);
        new com.tencent.mm.plugin.appbrand.game.e.b.b().a(a.b(a.this).aXz(), b.a.kpo, a.h(a.this));
        AppMethodBeat.o(222695);
      }
    }, 1000L);
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
          ae.i("MicroMsg.AppBrandHTMLWebView", "destroy hash[%d]", new Object[] { Integer.valueOf(a.this.hashCode()) });
          a.a(a.this).cleanup();
          a.e(a.this).stopLoading();
          a.e(a.this).destroy();
          a.f(a.this).clear();
          b localb = b.lzN;
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
      if ((!bool) && (this.lzA != null)) {
        this.lzA.requestDisallowInterceptTouchEvent(false);
      }
      AppMethodBeat.o(46992);
      return bool;
      if (this.lzA != null)
      {
        this.lzA.requestDisallowInterceptTouchEvent(true);
        continue;
        if (this.lzA != null) {
          this.lzA.requestDisallowInterceptTouchEvent(false);
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
    int i = this.lzB.getBinderID();
    AppMethodBeat.o(174921);
    return i;
  }
  
  public final com.tencent.mm.plugin.appbrand.report.model.p getExitReporter()
  {
    AppMethodBeat.i(222714);
    com.tencent.mm.plugin.appbrand.report.model.p localp = this.kxA.getRuntime().aXy().getReporter().bsX();
    AppMethodBeat.o(222714);
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
    Object localObject5 = this.kxA;
    Object localObject2 = ((ad)localObject5).getRuntime();
    Object localObject4 = ((com.tencent.luggage.sdk.d.d)localObject2).Fg().cmE;
    Object localObject3 = ((com.tencent.mm.plugin.appbrand.p)localObject2).aXx();
    Object localObject1 = ((ad)localObject5).bvG();
    String str1 = ((AppBrandStatObject)localObject4).scene;
    String str2 = ((AppBrandStatObject)localObject4).dlj;
    String str3 = ((AppBrandRuntime)localObject2).mAppId;
    String str4 = ((com.tencent.mm.plugin.appbrand.p)localObject2).aXw().kbw.pkgVersion;
    localObject3 = ((AppBrandInitConfigWC)localObject3).Ef();
    String str5 = ((com.tencent.mm.plugin.appbrand.p)localObject2).aXw().kbw.jLV + 1;
    String str6 = ((AppBrandStatObject)localObject4).mwv;
    String str7 = ((com.tencent.mm.plugin.appbrand.page.z)localObject5).kxv;
    if (localObject1 == null) {}
    for (localObject1 = "";; localObject1 = ((a)localObject1).getWebView().getUrl())
    {
      localObject5 = h.getNetworkType(((ad)localObject5).getContext());
      String str8 = ((AppBrandStatObject)localObject4).dLf;
      localObject4 = ((AppBrandStatObject)localObject4).dLg;
      localObject2 = ((com.tencent.mm.plugin.appbrand.p)localObject2).aXx().cmt + 1000;
      AppMethodBeat.o(47007);
      return new String[] { str1, str2, str3, str4, localObject3, str5, str6, str7, localObject1, localObject5, "", "", "", "", "", "", str8, localObject4, localObject2 };
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.page.z getPageView()
  {
    return this.kxA;
  }
  
  public final e.b getReporter()
  {
    return this.lzI;
  }
  
  public final MMWebView getWebView()
  {
    return this.hLV;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(46994);
    super.onAttachedToWindow();
    this.cwf = n.df(this);
    if (this.cwf != null) {
      this.cwf.a(this.cwh);
    }
    this.lzA = ((com.tencent.mm.plugin.appbrand.page.a.f)this.kxA.Q(com.tencent.mm.plugin.appbrand.page.a.f.class));
    this.lzG = new d((byte)0);
    d locald = this.lzG;
    locald.lzL.kxA.a(locald);
    locald.lzL.kxA.a(locald);
    this.lzG.onForeground();
    AppMethodBeat.o(46994);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(46995);
    super.onDetachedFromWindow();
    if (!this.kxA.isRunning()) {
      destroy();
    }
    if (this.cwf != null) {
      this.cwf.b(this.cwh);
    }
    if (this.lzG != null)
    {
      this.lzG.onBackground();
      d locald = this.lzG;
      locald.lzL.kxA.b(locald);
      locald.lzL.kxA.b(locald);
      this.lzG = null;
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
    if (ar.isMainThread())
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
      Iterator localIterator = this.lzH.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).bpQ();
      }
    }
    AppMethodBeat.o(46987);
  }
  
  public final void u(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(47001);
    new e((byte)0).g(this.kxA).p("htmlId", Integer.valueOf(this.mViewId)).p("errorCode", Integer.valueOf(paramInt)).p("description", paramString2).p("src", paramString1).bja();
    AppMethodBeat.o(47001);
  }
  
  public static abstract interface a
  {
    public abstract void bpQ();
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.a
 * JD-Core Version:    0.7.0.1
 */