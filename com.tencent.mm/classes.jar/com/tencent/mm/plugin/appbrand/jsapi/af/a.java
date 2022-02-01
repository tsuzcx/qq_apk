package com.tencent.mm.plugin.appbrand.jsapi.af;

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
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.model.p;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
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
  private com.tencent.mm.plugin.appbrand.widget.input.u cKe;
  private final u.c cKk;
  private MMFalseProgressBar iGX;
  public MMWebView iGY;
  ag lBN;
  private String mAppId;
  boolean mDestroyed;
  private c mGN;
  private com.tencent.mm.plugin.appbrand.page.a.f mGO;
  final e.a mGP;
  private String mGQ;
  private boolean mGR;
  boolean mGS;
  private boolean mGT;
  private d mGU;
  private final Set<a> mGV;
  private final e.b mGW;
  private ab mGX;
  private com.tencent.xweb.x5.export.external.extension.proxy.a mGY;
  private int mViewId;
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public a(Context paramContext, AppBrandRuntime paramAppBrandRuntime, ag paramag)
  {
    super(new MutableContextWrapper(paramContext));
    AppMethodBeat.i(46990);
    this.mViewId = 0;
    this.mGQ = "";
    this.mGR = true;
    this.mGS = false;
    this.cKe = null;
    this.cKk = new u.c()
    {
      private int crC = 0;
      
      public final void bQ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46965);
        a.a(a.this).s(paramAnonymousBoolean, this.crC);
        AppMethodBeat.o(46965);
      }
      
      public final int getHeight()
      {
        return this.crC;
      }
      
      public final void hF(int paramAnonymousInt)
      {
        this.crC = paramAnonymousInt;
      }
    };
    this.mGV = new android.support.v4.e.b();
    this.mDestroyed = false;
    this.mGW = new e.b()
    {
      public final void H(ArrayList<IDKey> paramAnonymousArrayList)
      {
        AppMethodBeat.i(227008);
        h.CyF.b(paramAnonymousArrayList, false);
        try
        {
          com.tencent.mm.plugin.appbrand.q localq = a.b(a.this).getRuntime();
          paramAnonymousArrayList = paramAnonymousArrayList.iterator();
          while (paramAnonymousArrayList.hasNext())
          {
            IDKey localIDKey = (IDKey)paramAnonymousArrayList.next();
            long l1 = localIDKey.GetID();
            long l2 = localIDKey.GetKey();
            i.a(a.this.getAppId(), localq.bsC().appVersion, localq.kAq.eix, l1, l2, 1L);
          }
          AppMethodBeat.o(227008);
        }
        catch (NullPointerException paramAnonymousArrayList)
        {
          AppMethodBeat.o(227008);
          return;
        }
      }
      
      public final void xK(int paramAnonymousInt)
      {
        AppMethodBeat.i(227007);
        h.CyF.dN(1097, paramAnonymousInt);
        try
        {
          com.tencent.mm.plugin.appbrand.q localq = a.b(a.this).getRuntime();
          i.b(a.this.getAppId(), localq.bsC().appVersion, localq.kAq.eix, 1097, paramAnonymousInt);
          AppMethodBeat.o(227007);
          return;
        }
        catch (NullPointerException localNullPointerException)
        {
          AppMethodBeat.o(227007);
        }
      }
    };
    this.mGX = new a.8(this);
    this.mGY = new a.9(this);
    Log.i("MicroMsg.AppBrandHTMLWebView", "<init> start hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.mAppId = paramAppBrandRuntime.mAppId;
    this.mGN = new c();
    this.mGN.g(paramag);
    this.lBN = paramag;
    this.iGY = MMWebViewWithJsApi.a.hZ(new MutableContextWrapper(paramContext));
    this.iGY.setBackgroundColor(0);
    this.iGY.getSettings().hsU();
    this.iGY.getSettings().setJavaScriptEnabled(true);
    this.iGY.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.iGY.getSettings().hsW();
    paramag = this.iGY.getSettings().getUserAgentString();
    paramAppBrandRuntime = paramag;
    if (!com.tencent.mm.pluginsdk.ui.tools.z.bfF(paramag)) {
      paramAppBrandRuntime = com.tencent.mm.pluginsdk.ui.tools.z.cr(getContext(), paramag);
    }
    paramAppBrandRuntime = paramAppBrandRuntime + " miniProgram";
    this.iGY.getSettings().setUserAgentString(paramAppBrandRuntime);
    this.iGY.getView().setHorizontalScrollBarEnabled(false);
    this.iGY.getView().setVerticalScrollBarEnabled(false);
    this.iGY.getSettings().setBuiltInZoomControls(true);
    this.iGY.getSettings().setUseWideViewPort(true);
    this.iGY.getSettings().setLoadWithOverviewMode(true);
    this.iGY.getSettings().hsN();
    this.iGY.getSettings().hsM();
    this.iGY.getSettings().setGeolocationEnabled(true);
    this.iGY.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.iGY.getSettings().hsS();
    this.iGY.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.iGY.getSettings().hsR();
    this.iGY.getSettings().hsT();
    this.iGY.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.aKA() + "databases/");
    this.iGY.getSettings().hsX();
    this.iGY.setWebViewCallbackClient(this.mGX);
    if (this.iGY.getIsX5Kernel()) {
      this.iGY.setWebViewClientExtension(this.mGY);
    }
    this.iGY.getSettings().setUsingForAppBrand(2);
    this.iGY.setDownloadListener(new a.2(this));
    Log.i("MicroMsg.AppBrandHTMLWebView", "<init> end WebView construct hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    addView(this.iGY, new ViewGroup.LayoutParams(-1, -1));
    this.iGX = new MMFalseProgressBar(paramContext);
    this.iGX.setProgressDrawable(com.tencent.mm.cb.a.l(paramContext, 2131233975));
    addView(this.iGX, new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(paramContext, 3)));
    this.iGX.start();
    this.mGP = new f(this);
    this.lBN.a(new i.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(46967);
        a.this.destroy();
        AppMethodBeat.o(46967);
      }
    });
    getExitReporter().nKd = true;
    paramContext = b.mHb;
    b.j(this);
    paramContext = this.iGY.setVideoJsCallback(new a.4(this));
    if ((paramContext != null) && (paramContext.hsA())) {}
    for (boolean bool = true;; bool = false)
    {
      this.mGT = bool;
      Log.i("MicroMsg.AppBrandHTMLWebView", "<init> end total construct hash[%d], supportOrientationControl[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.mGT) });
      AppMethodBeat.o(46990);
      return;
    }
  }
  
  private void bLt()
  {
    AppMethodBeat.i(47003);
    this.iGY.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
    AppMethodBeat.o(47003);
  }
  
  private com.tencent.mm.plugin.appbrand.report.model.q getGameResourceReporter()
  {
    AppMethodBeat.i(180293);
    com.tencent.mm.plugin.appbrand.report.model.q localq = this.lBN.getRuntime().bsD().getReporter().bOC();
    AppMethodBeat.o(180293);
    return localq;
  }
  
  private void setCurrentURL(String paramString)
  {
    AppMethodBeat.i(47005);
    this.mGQ = paramString;
    if (!Util.isNullOrNil(paramString))
    {
      paramString = Uri.parse(paramString).getHost();
      if (!Util.isNullOrNil(paramString))
      {
        setPullDownText$d3a6df8(getContext().getString(2131768587, new Object[] { paramString }));
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
    if (this.mGO != null) {
      this.mGO.setPullDownText(paramString);
    }
    AppMethodBeat.o(47006);
  }
  
  public final boolean NA()
  {
    return this.lBN instanceof com.tencent.mm.plugin.appbrand.game.f.d;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(46986);
    if (!this.mDestroyed) {
      this.mGV.add(parama);
    }
    AppMethodBeat.o(46986);
  }
  
  public final void a(String paramString, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(180294);
    Object localObject1 = getGameResourceReporter();
    Object localObject2 = this.lBN;
    if ((((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).nIR) || (paramWebResourceRequest == null))
    {
      AppMethodBeat.o(180294);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).pageUrl = paramString;
    ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).url = paramWebResourceRequest.getUrl().toString();
    ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).method = paramWebResourceRequest.getMethod();
    ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).referer = ((String)paramWebResourceRequest.getRequestHeaders().get("Referer"));
    paramString = ((ag)localObject2).getRuntime().bsB();
    if (paramString != null) {
      ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).appVersion = paramString.leE.pkgVersion;
    }
    ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).networkType = i.getNetworkType(MMApplicationContext.getContext());
    paramString = ((ag)localObject2).getRuntime();
    if (paramString == null)
    {
      paramString = null;
      if (paramString == null) {
        break label410;
      }
      ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).appType = paramString.cyo;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).appType += 1000;
      if (!((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).nIR)
      {
        Log.i("MicroMsg.AppBrand.Report.kv_19358", "report " + ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).toString());
        paramString = ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).appId;
        int i = ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).appVersion;
        int j = ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).dCv;
        int k = ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).appType;
        paramWebResourceRequest = ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).networkType;
        localObject2 = ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).pageUrl;
        String str1 = ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).url;
        String str2 = ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).method;
        int m = ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).nKg;
        int n = ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).nKh;
        int i1 = ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).statusCode;
        int i2 = ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).nKi;
        localObject1 = ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).referer;
        h.CyF.a(19358, com.tencent.mm.plugin.appbrand.report.s.k(new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramWebResourceRequest, localObject2, str1, str2, Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), localObject1 }));
      }
      AppMethodBeat.o(180294);
      return;
      paramString = paramString.bsC();
      break;
      label410:
      ((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).appType = j.aeJ(((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).appId);
      Log.i("MicroMsg.AppBrand.Report.kv_19358", "prepareCommonFields null = initConfig! apptype:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.report.model.q)localObject1).appType) });
    }
  }
  
  public final void abB(String paramString)
  {
    AppMethodBeat.i(46998);
    if ((TextUtils.isEmpty(paramString)) || (URLUtil.isValidUrl(paramString)))
    {
      AppMethodBeat.o(46998);
      return;
    }
    this.lBN.YO(paramString);
    AppMethodBeat.o(46998);
  }
  
  public final void abC(String paramString)
  {
    AppMethodBeat.i(46999);
    Log.i("MicroMsg.AppBrandHTMLWebView", "onPageStarted url[%s] hash[%d] destroyed[%b] attached[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed), Boolean.valueOf(android.support.v4.view.u.aD(this)) });
    if (this.mDestroyed)
    {
      AppMethodBeat.o(46999);
      return;
    }
    bLt();
    this.iGX.start();
    new c((byte)0).g(this.lBN).p("src", paramString).p("htmlId", Integer.valueOf(this.mViewId)).bEo();
    AppMethodBeat.o(46999);
  }
  
  public final void abD(String paramString)
  {
    AppMethodBeat.i(227024);
    if (this.mDestroyed)
    {
      Log.i("MicroMsg.AppBrandHTMLWebView", "onPageCommitVisible url[%s] hash[%d] destroyed[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed) });
      AppMethodBeat.o(227024);
      return;
    }
    bLt();
    AppMethodBeat.o(227024);
  }
  
  public final void ah(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46997);
    this.mGN.a(this.lBN.getRuntime().bsE(), this.lBN.getComponentId()).Zg(paramJSONObject.toString()).bEo();
    AppMethodBeat.o(46997);
  }
  
  public final void bLp()
  {
    AppMethodBeat.i(46988);
    Log.i("MicroMsg.AppBrandHTMLWebView", "restoreRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.iGY.onShow();
    AppMethodBeat.o(46988);
  }
  
  public final void bLq()
  {
    AppMethodBeat.i(46989);
    Log.i("MicroMsg.AppBrandHTMLWebView", "pauseRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.iGY.onHide();
    AppMethodBeat.o(46989);
  }
  
  public final boolean bLr()
  {
    return !this.mGT;
  }
  
  public final void bLs()
  {
    AppMethodBeat.i(47002);
    this.lBN.getRuntime().bsD().adF("scene_other");
    AppMethodBeat.o(47002);
  }
  
  public final boolean bLu()
  {
    AppMethodBeat.i(47008);
    try
    {
      if (this.lBN.getRuntime().bsB().cyp)
      {
        bool = this.lBN.getRuntime().bsB().cyF;
        AppMethodBeat.o(47008);
        return bool;
      }
      boolean bool = this.lBN.getRuntime().bsB().cyC;
      AppMethodBeat.o(47008);
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(47008);
    }
    return false;
  }
  
  public final void cW(String paramString)
  {
    AppMethodBeat.i(47000);
    Log.i("MicroMsg.AppBrandHTMLWebView", "onPageFinished url[%s] hash[%d] destroyed[%b] attached[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed), Boolean.valueOf(android.support.v4.view.u.aD(this)) });
    if (this.mDestroyed)
    {
      AppMethodBeat.o(47000);
      return;
    }
    bLt();
    this.iGX.finish();
    if ((!this.mGR) && (!this.mGS))
    {
      p localp = getExitReporter();
      ag localag = this.lBN;
      String str = this.mGQ;
      localp.nIU = ((String)localp.nKb.peekFirst());
      localp.nIV = 2;
      localp.nIW = paramString;
      localp.nKb.push(str);
      localp.y(localag);
    }
    this.mGR = false;
    this.mGS = false;
    setCurrentURL(paramString);
    new b((byte)0).g(this.lBN).p("src", paramString).p("htmlId", Integer.valueOf(this.mViewId)).bEo();
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(227006);
        new com.tencent.mm.plugin.appbrand.game.e.b.b().a(a.b(a.this).bsE(), b.a.lsX, a.h(a.this));
        AppMethodBeat.o(227006);
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
          Log.i("MicroMsg.AppBrandHTMLWebView", "destroy hash[%d]", new Object[] { Integer.valueOf(a.this.hashCode()) });
          a.a(a.this).cleanup();
          a.e(a.this).stopLoading();
          a.e(a.this).destroy();
          a.f(a.this).clear();
          b localb = b.mHb;
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
      if ((!bool) && (this.mGO != null)) {
        this.mGO.requestDisallowInterceptTouchEvent(false);
      }
      AppMethodBeat.o(46992);
      return bool;
      if (this.mGO != null)
      {
        this.mGO.requestDisallowInterceptTouchEvent(true);
        continue;
        if (this.mGO != null) {
          this.mGO.requestDisallowInterceptTouchEvent(false);
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
    int i = this.mGP.getBinderID();
    AppMethodBeat.o(174921);
    return i;
  }
  
  public final p getExitReporter()
  {
    AppMethodBeat.i(227025);
    p localp = this.lBN.getRuntime().bsD().getReporter().bOB();
    AppMethodBeat.o(227025);
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
    Object localObject5 = this.lBN;
    Object localObject2 = ((ag)localObject5).getRuntime();
    Object localObject4 = ((com.tencent.luggage.sdk.d.d)localObject2).ON().cyA;
    Object localObject3 = ((com.tencent.mm.plugin.appbrand.q)localObject2).bsC();
    Object localObject1 = ((ag)localObject5).bRM();
    String str1 = ((AppBrandStatObject)localObject4).scene;
    String str2 = ((AppBrandStatObject)localObject4).dCw;
    String str3 = ((AppBrandRuntime)localObject2).mAppId;
    String str4 = ((com.tencent.mm.plugin.appbrand.q)localObject2).bsB().leE.pkgVersion;
    localObject3 = ((AppBrandInitConfigLU)localObject3).cym;
    String str5 = ((com.tencent.mm.plugin.appbrand.q)localObject2).bsB().leE.kNW + 1;
    String str6 = ((AppBrandStatObject)localObject4).nHt;
    String str7 = ((ac)localObject5).lBI;
    if (localObject1 == null) {}
    for (localObject1 = "";; localObject1 = ((a)localObject1).getWebView().getUrl())
    {
      localObject5 = i.getNetworkType(((ag)localObject5).getContext());
      String str8 = ((AppBrandStatObject)localObject4).ecU;
      localObject4 = ((AppBrandStatObject)localObject4).ecV;
      localObject2 = ((com.tencent.mm.plugin.appbrand.q)localObject2).bsC().cyo + 1000;
      AppMethodBeat.o(47007);
      return new String[] { str1, str2, str3, str4, localObject3, str5, str6, str7, localObject1, localObject5, "", "", "", "", "", "", str8, localObject4, localObject2 };
    }
  }
  
  public final ac getPageView()
  {
    return this.lBN;
  }
  
  public final e.b getReporter()
  {
    return this.mGW;
  }
  
  public final MMWebView getWebView()
  {
    return this.iGY;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(46994);
    super.onAttachedToWindow();
    this.cKe = n.cY(this);
    if (this.cKe != null) {
      this.cKe.a(this.cKk);
    }
    this.mGO = ((com.tencent.mm.plugin.appbrand.page.a.f)this.lBN.S(com.tencent.mm.plugin.appbrand.page.a.f.class));
    this.mGU = new d((byte)0);
    d locald = this.mGU;
    locald.mGZ.lBN.a(locald);
    locald.mGZ.lBN.a(locald);
    this.mGU.onForeground();
    AppMethodBeat.o(46994);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(46995);
    super.onDetachedFromWindow();
    if (!this.lBN.isRunning()) {
      destroy();
    }
    if (this.cKe != null) {
      this.cKe.b(this.cKk);
    }
    if (this.mGU != null)
    {
      this.mGU.onBackground();
      d locald = this.mGU;
      locald.mGZ.lBN.b(locald);
      locald.mGZ.lBN.b(locald);
      this.mGU = null;
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
      Iterator localIterator = this.mGV.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).bLw();
      }
    }
    AppMethodBeat.o(46987);
  }
  
  public final void z(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(47001);
    new e((byte)0).g(this.lBN).p("htmlId", Integer.valueOf(this.mViewId)).p("errorCode", Integer.valueOf(paramInt)).p("description", paramString2).p("src", paramString1).bEo();
    AppMethodBeat.o(47001);
  }
  
  public static abstract interface a
  {
    public abstract void bLw();
  }
  
  static final class b
    extends com.tencent.mm.plugin.appbrand.jsapi.s
  {
    public static final int CTRL_INDEX = 505;
    public static final String NAME = "onWebviewFinishLoad";
  }
  
  static final class c
    extends com.tencent.mm.plugin.appbrand.jsapi.s
  {
    public static final int CTRL_INDEX = 504;
    public static final String NAME = "onWebviewStartLoad";
  }
  
  final class d
    implements i.b, i.d
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
    extends com.tencent.mm.plugin.appbrand.jsapi.s
  {
    public static final int CTRL_INDEX = 506;
    public static final String NAME = "onWebviewError";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.a
 * JD-Core Version:    0.7.0.1
 */