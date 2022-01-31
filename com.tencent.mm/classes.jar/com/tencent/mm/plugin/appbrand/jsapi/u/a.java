package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
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
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.b.d;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.t;
import java.io.File;
import java.util.LinkedList;
import org.json.JSONObject;

public final class a
  extends FrameLayout
  implements c.c
{
  private MMFalseProgressBar foI;
  MMWebView foJ;
  z hzR;
  private b igF;
  private d igG;
  private final c.b igH;
  private String igI;
  private boolean igJ;
  boolean igK;
  private com.tencent.mm.plugin.appbrand.widget.input.u igL;
  private final u.c igM;
  private a.c igN;
  private com.tencent.xweb.v igO;
  private com.tencent.xweb.x5.a.a.a.a.b igP;
  private String mAppId;
  private int mViewId;
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public a(Context paramContext, i parami, z paramz)
  {
    super(paramContext);
    AppMethodBeat.i(131650);
    this.mViewId = 0;
    this.igI = "";
    this.igJ = true;
    this.igK = false;
    this.igL = null;
    this.igM = new a.1(this);
    this.igO = new a.4(this);
    this.igP = new a.5(this);
    this.mAppId = parami.mAppId;
    this.igF = new b();
    this.igF.i(paramz);
    this.hzR = paramz;
    this.foJ = f.a.vsl.dz(paramContext);
    this.foJ.getSettings().dYx();
    this.foJ.getSettings().setJavaScriptEnabled(true);
    this.foJ.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.foJ.getSettings().dYz();
    paramz = this.foJ.getSettings().getUserAgentString();
    parami = paramz;
    if (!com.tencent.mm.pluginsdk.ui.tools.u.amS(paramz)) {
      parami = com.tencent.mm.pluginsdk.ui.tools.u.bD(getContext(), paramz);
    }
    parami = parami + " miniProgram";
    this.foJ.getSettings().setUserAgentString(parami);
    this.foJ.getView().setHorizontalScrollBarEnabled(false);
    this.foJ.getView().setVerticalScrollBarEnabled(false);
    this.foJ.getSettings().setBuiltInZoomControls(true);
    this.foJ.getSettings().setUseWideViewPort(true);
    this.foJ.getSettings().setLoadWithOverviewMode(true);
    this.foJ.getSettings().dYs();
    this.foJ.getSettings().dYr();
    this.foJ.getSettings().setGeolocationEnabled(true);
    this.foJ.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.foJ.getSettings().dYv();
    this.foJ.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.foJ.getSettings().dYu();
    this.foJ.getSettings().dYw();
    this.foJ.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.eQu + "databases/");
    this.foJ.setWebViewCallbackClient(this.igO);
    if (this.foJ.getIsX5Kernel()) {
      this.foJ.setWebViewClientExtension(this.igP);
    }
    this.foJ.getSettings().setUsingForAppBrand(2);
    this.foJ.setDownloadListener(new a.2(this));
    addView(this.foJ, new ViewGroup.LayoutParams(-1, -1));
    this.foI = new MMFalseProgressBar(paramContext);
    this.foI.setProgressDrawable(com.tencent.mm.cb.a.k(paramContext, 2130839677));
    addView(this.foI, new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(paramContext, 3)));
    this.igH = ((c.a)com.tencent.luggage.a.e.q(c.a.class)).a(this);
    this.hzR.a(new a.3(this));
    getReporter().iIh = true;
    AppMethodBeat.o(131650);
  }
  
  private void aGj()
  {
    AppMethodBeat.i(131662);
    this.foJ.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
    AppMethodBeat.o(131662);
  }
  
  private void setCurrentURL(String paramString)
  {
    AppMethodBeat.i(131664);
    this.igI = paramString;
    if (!bo.isNullOrNil(paramString))
    {
      paramString = Uri.parse(paramString).getHost();
      if (!bo.isNullOrNil(paramString))
      {
        setPullDownText$d3a6df8(getContext().getString(2131305882, new Object[] { paramString }));
        AppMethodBeat.o(131664);
        return;
      }
    }
    setPullDownText$d3a6df8("");
    AppMethodBeat.o(131664);
  }
  
  private void setPullDownText$d3a6df8(String paramString)
  {
    AppMethodBeat.i(143440);
    if (this.igG != null) {
      this.igG.setPullDownText(paramString);
    }
    AppMethodBeat.o(143440);
  }
  
  public final void Da(String paramString)
  {
    AppMethodBeat.i(131657);
    if ((TextUtils.isEmpty(paramString)) || (URLUtil.isValidUrl(paramString)))
    {
      AppMethodBeat.o(131657);
      return;
    }
    this.hzR.BC(paramString);
    AppMethodBeat.o(131657);
  }
  
  public final void Db(String paramString)
  {
    AppMethodBeat.i(131658);
    aGj();
    this.foI.start();
    new a.b((byte)0).i(this.hzR).m("src", paramString).m("htmlId", Integer.valueOf(this.mViewId)).aBz();
    AppMethodBeat.o(131658);
  }
  
  public final void I(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(131656);
    this.igF.a(this.hzR.getRuntime().atU(), this.hzR.hashCode()).BM(paramJSONObject.toString()).aBz();
    AppMethodBeat.o(131656);
  }
  
  public final void aGi()
  {
    AppMethodBeat.i(131661);
    this.hzR.getRuntime().atT().aIZ();
    AppMethodBeat.o(131661);
  }
  
  public final boolean aGk()
  {
    AppMethodBeat.i(131667);
    try
    {
      if (this.hzR.getRuntime().atR().bCW)
      {
        bool = this.hzR.getRuntime().atR().bDm;
        AppMethodBeat.o(131667);
        return bool;
      }
      boolean bool = this.hzR.getRuntime().atR().bDj;
      AppMethodBeat.o(131667);
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(131667);
    }
    return false;
  }
  
  public final void bF(String paramString)
  {
    AppMethodBeat.i(131659);
    aGj();
    this.foI.finish();
    if ((!this.igJ) && (!this.igK))
    {
      com.tencent.mm.plugin.appbrand.report.model.o localo = getReporter();
      z localz = this.hzR;
      String str = this.igI;
      localo.iHi = ((String)localo.iIf.peekFirst());
      localo.iHj = 2;
      localo.iHk = paramString;
      localo.iIf.push(str);
      localo.n(localz);
    }
    this.igJ = false;
    this.igK = false;
    setCurrentURL(paramString);
    new a.a((byte)0).i(this.hzR).m("src", paramString).m("htmlId", Integer.valueOf(this.mViewId)).aBz();
    AppMethodBeat.o(131659);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(131651);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      if ((!bool) && (this.igG != null)) {
        this.igG.requestDisallowInterceptTouchEvent(false);
      }
      AppMethodBeat.o(131651);
      return bool;
      if (this.igG != null)
      {
        this.igG.requestDisallowInterceptTouchEvent(true);
        continue;
        if (this.igG != null) {
          this.igG.requestDisallowInterceptTouchEvent(false);
        }
      }
    }
  }
  
  public final String getAppId()
  {
    return this.mAppId;
  }
  
  public final String[] getJsApiReportArgs()
  {
    AppMethodBeat.i(131666);
    Object localObject5 = this.hzR;
    Object localObject2 = ((z)localObject5).getRuntime();
    Object localObject4 = ((com.tencent.luggage.sdk.d.b)localObject2).wS().bDh;
    Object localObject3 = ((com.tencent.mm.plugin.appbrand.o)localObject2).atS();
    Object localObject1 = ((z)localObject5).aJz();
    String str1 = ((AppBrandStatObject)localObject4).scene;
    String str2 = ((AppBrandStatObject)localObject4).cmF;
    String str3 = ((i)localObject2).mAppId;
    String str4 = ((com.tencent.mm.plugin.appbrand.o)localObject2).atR().hiX.gXf;
    localObject3 = ((AppBrandInitConfigWC)localObject3).vZ();
    String str5 = ((com.tencent.mm.plugin.appbrand.o)localObject2).atR().hiX.gXe + 1;
    String str6 = ((AppBrandStatObject)localObject4).iFX;
    String str7 = ((com.tencent.mm.plugin.appbrand.page.v)localObject5).hzM;
    if (localObject1 == null) {}
    for (localObject1 = "";; localObject1 = ((a)localObject1).getWebView().getUrl())
    {
      localObject5 = com.tencent.mm.plugin.appbrand.report.e.cZ(((z)localObject5).getContext());
      String str8 = ((AppBrandStatObject)localObject4).cJb;
      localObject4 = ((AppBrandStatObject)localObject4).cJc;
      localObject2 = ((com.tencent.mm.plugin.appbrand.o)localObject2).atS().bCV + 1000;
      AppMethodBeat.o(131666);
      return new String[] { str1, str2, str3, str4, localObject3, str5, str6, str7, localObject1, localObject5, "", "", "", "", "", "", str8, localObject4, localObject2 };
    }
  }
  
  final com.tencent.mm.plugin.appbrand.report.model.o getReporter()
  {
    AppMethodBeat.i(131663);
    com.tencent.mm.plugin.appbrand.report.model.o localo = this.hzR.getRuntime().atT().getReporter().aHG();
    AppMethodBeat.o(131663);
    return localo;
  }
  
  public final MMWebView getWebView()
  {
    return this.foJ;
  }
  
  public final void m(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(131660);
    new a.d((byte)0).i(this.hzR).m("htmlId", Integer.valueOf(this.mViewId)).m("errorCode", Integer.valueOf(paramInt)).m("description", paramString2).m("src", paramString1).aBz();
    AppMethodBeat.o(131660);
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(131653);
    super.onAttachedToWindow();
    this.igL = n.cL(this);
    if (this.igL != null) {
      this.igL.a(this.igM);
    }
    this.igG = ((d)this.hzR.x(d.class));
    this.igN = new a.c(this, (byte)0);
    a.c localc = this.igN;
    localc.igQ.hzR.a(localc);
    localc.igQ.hzR.a(localc);
    this.igN.onForeground();
    AppMethodBeat.o(131653);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(131654);
    super.onDetachedFromWindow();
    if (!this.hzR.isRunning()) {
      getWebView().destroy();
    }
    if (this.igL != null) {
      this.igL.b(this.igM);
    }
    if (this.igN != null)
    {
      this.igN.onBackground();
      a.c localc = this.igN;
      localc.igQ.hzR.b(localc);
      localc.igQ.hzR.b(localc);
      this.igN = null;
    }
    AppMethodBeat.o(131654);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131652);
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
      AppMethodBeat.o(131652);
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
    AppMethodBeat.i(131655);
    if (al.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(131655);
      return;
    }
    post(paramRunnable);
    AppMethodBeat.o(131655);
  }
  
  public final void setViewId(int paramInt)
  {
    this.mViewId = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a
 * JD-Core Version:    0.7.0.1
 */