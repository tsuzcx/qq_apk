package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.luggage.b.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.y.f;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.f.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import java.io.File;
import java.util.LinkedList;
import org.json.JSONObject;

public final class a
  extends FrameLayout
  implements c.c
{
  private MMFalseProgressBar dYE;
  private MMWebView dYF;
  private b gGa;
  com.tencent.mm.plugin.appbrand.page.s gGb;
  private int gGc = 0;
  private final c.b gGd;
  private String gGe = "";
  private boolean gGf = true;
  boolean gGg = false;
  private com.tencent.xweb.o gGh = new a.2(this);
  private com.tencent.xweb.x5.a.a.a.a.b gGi = new a.3(this);
  private String mAppId;
  
  public a(Context paramContext, i parami, com.tencent.mm.plugin.appbrand.page.s params)
  {
    super(paramContext);
    this.mAppId = parami.mAppId;
    this.gGa = new b();
    this.gGa.d(params);
    this.gGb = params;
    this.dYF = f.a.rBZ.cO(paramContext);
    this.dYF.getSettings().cSs();
    this.dYF.getSettings().setJavaScriptEnabled(true);
    this.dYF.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.dYF.getSettings().cSu();
    this.dYF.getSettings().setUserAgentString(com.tencent.mm.pluginsdk.ui.tools.s.aX(getContext(), this.dYF.getSettings().getUserAgentString()) + " miniProgram");
    this.dYF.getView().setHorizontalScrollBarEnabled(false);
    this.dYF.getView().setVerticalScrollBarEnabled(false);
    this.dYF.getSettings().setBuiltInZoomControls(true);
    this.dYF.getSettings().setUseWideViewPort(true);
    this.dYF.getSettings().setLoadWithOverviewMode(true);
    this.dYF.getSettings().cSn();
    this.dYF.getSettings().cSm();
    this.dYF.getSettings().setGeolocationEnabled(true);
    this.dYF.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.dYF.getSettings().cSq();
    this.dYF.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
    this.dYF.getSettings().cSp();
    this.dYF.getSettings().cSr();
    this.dYF.getSettings().setDatabasePath(com.tencent.mm.loader.a.b.dOO + "databases/");
    this.dYF.setWebViewCallbackClient(this.gGh);
    if (this.dYF.getIsX5Kernel()) {
      this.dYF.setWebViewClientExtension(this.gGi);
    }
    try
    {
      parami = new Bundle(1);
      parami.putInt("flag", 2);
      org.b.a.cz(this.dYF.getX5WebViewExtension()).y("invokeMiscMethod", new Object[] { "setMiniProgramFlag", parami });
      this.dYF.getSettings().setUsingForAppBrand(2);
      addView(this.dYF, new ViewGroup.LayoutParams(-1, -1));
      this.dYE = new MMFalseProgressBar(paramContext);
      this.dYE.setProgressDrawable(com.tencent.mm.cb.a.g(paramContext, y.f.mm_webview_progress_horizontal));
      addView(this.dYE, new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(paramContext, 3)));
      this.gGd = ((c.a)e.i(c.a.class)).a(this);
      this.gGb.a(new a.1(this));
      getReporter().gZP = true;
      return;
    }
    catch (Exception parami)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrandHTMLWebView", "invokeMiscMethod e = %s", new Object[] { parami });
      }
    }
  }
  
  private void a(q paramq, String paramString)
  {
    paramq.getContentView().post(new a.4(this, paramq, paramString));
  }
  
  private void ali()
  {
    this.dYF.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
  }
  
  public final void B(JSONObject paramJSONObject)
  {
    this.gGa.a(this.gGb.getRuntime().aae(), this.gGb.hashCode()).tL(paramJSONObject.toString()).dispatch();
  }
  
  public final void alh()
  {
    this.gGb.getRuntime().aad().agL();
  }
  
  public final boolean alj()
  {
    if (this.gGb.getRuntime().aaa().fPx) {
      return this.gGb.getRuntime().aaa().fPV;
    }
    return this.gGb.getRuntime().aaa().fPN;
  }
  
  public final void bd(String paramString)
  {
    ali();
    this.dYE.finish();
    if ((!this.gGf) && (!this.gGg))
    {
      com.tencent.mm.plugin.appbrand.report.model.o localo = getReporter();
      com.tencent.mm.plugin.appbrand.page.s locals = this.gGb;
      String str = this.gGe;
      localo.gYT = ((String)localo.gZN.peekFirst());
      localo.gYU = 2;
      localo.gYV = paramString;
      localo.gZN.push(str);
      localo.k(locals);
    }
    this.gGf = false;
    this.gGg = false;
    setCurrentURL(paramString);
    new a.a((byte)0).d(this.gGb).l("src", paramString).l("htmlId", Integer.valueOf(this.gGc)).dispatch();
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      if (!bool) {
        this.gGb.gTG.requestDisallowInterceptTouchEvent(false);
      }
      return bool;
      this.gGb.gTG.requestDisallowInterceptTouchEvent(true);
      continue;
      this.gGb.gTG.requestDisallowInterceptTouchEvent(false);
    }
  }
  
  public final String getAppId()
  {
    return this.mAppId;
  }
  
  public final String[] getJsApiReportArgs()
  {
    com.tencent.mm.plugin.appbrand.page.s locals = this.gGb;
    com.tencent.mm.plugin.appbrand.n localn = locals.getRuntime();
    AppBrandStatObject localAppBrandStatObject = localn.aab();
    Object localObject2 = localn.aac();
    Object localObject1 = locals.ans();
    String str1 = localAppBrandStatObject.scene;
    String str2 = localAppBrandStatObject.bFv;
    String str3 = localn.mAppId;
    String str4 = localn.aaa().fPS.fEN;
    localObject2 = ((AppBrandInitConfigWC)localObject2).fJO;
    String str5 = localn.aaa().fPS.fEM + 1;
    String str6 = localAppBrandStatObject.gXG;
    String str7 = locals.getURL();
    if (localObject1 == null) {}
    for (localObject1 = "";; localObject1 = ((a)localObject1).getWebView().getUrl()) {
      return new String[] { str1, str2, str3, str4, localObject2, str5, str6, str7, localObject1, c.cv(locals.mContext), "", "", "", "", "", "", localAppBrandStatObject.caB, localAppBrandStatObject.caC, localn.aac().bFB + 1000 };
    }
  }
  
  final com.tencent.mm.plugin.appbrand.report.model.o getReporter()
  {
    return this.gGb.getRuntime().aad().getReporter().gYb;
  }
  
  public final MMWebView getWebView()
  {
    return this.dYF;
  }
  
  public final void k(String paramString1, int paramInt, String paramString2)
  {
    new a.c((byte)0).d(this.gGb).l("htmlId", Integer.valueOf(this.gGc)).l("errorCode", Integer.valueOf(paramInt)).l("description", paramString2).l("src", paramString1).dispatch();
  }
  
  public final void runOnUiThread(Runnable paramRunnable)
  {
    post(paramRunnable);
  }
  
  public final void setCurrentURL(String paramString)
  {
    this.gGe = paramString;
    if (!bk.bl(paramString))
    {
      paramString = Uri.parse(paramString).getHost();
      if (!bk.bl(paramString))
      {
        paramString = getContext().getString(y.j.webview_logo_url, new Object[] { paramString });
        a(this.gGb, paramString);
        return;
      }
    }
    a(this.gGb, "");
  }
  
  public final void setViewId(int paramInt)
  {
    this.gGc = paramInt;
  }
  
  public final void uI(String paramString)
  {
    this.gGb.tD(paramString);
  }
  
  public final void uJ(String paramString)
  {
    ali();
    this.dYE.start();
    new a.b((byte)0).d(this.gGb).l("src", paramString).l("htmlId", Integer.valueOf(this.gGc)).dispatch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a
 * JD-Core Version:    0.7.0.1
 */