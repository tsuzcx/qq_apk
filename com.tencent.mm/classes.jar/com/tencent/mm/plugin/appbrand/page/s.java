package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.h.b.a.ak;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.v.k;
import com.tencent.mm.plugin.appbrand.v.k.a;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.b;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.f;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class s
  extends q
  implements com.tencent.mm.plugin.appbrand.jsapi.f
{
  private com.tencent.mm.plugin.appbrand.n fzW;
  public e gUh;
  private AppBrandRecentView gUi;
  public final com.tencent.mm.plugin.appbrand.report.model.c gUj = new com.tencent.mm.plugin.appbrand.report.model.c(hashCode());
  private long gUk = System.currentTimeMillis();
  private long gUl;
  private long gUm;
  private ak gUn = null;
  public final Runnable gUo = new s.9(this);
  private boolean gUp = false;
  private boolean gUq = false;
  private boolean gUr = false;
  
  private void anu()
  {
    h.nFQ.a(370L, 1L, 1L, false);
    k.a(ahK(), com.tencent.mm.plugin.appbrand.u.d.wB("wxa_library/android.js"), null);
    String str = WxaCommLibRuntimeReader.qX("WAWebview.js");
    final long l = System.currentTimeMillis();
    if (str == null) {}
    for (int i = 0;; i = str.length())
    {
      final boolean bool = aan();
      k.a(ahK(), str, new k.a()
      {
        public final void fM(String paramAnonymousString)
        {
          int j = 0;
          y.e("MicroMsg.AppBrandPageViewWC", "Inject SDK Page Script Failed: %s", new Object[] { paramAnonymousString });
          h.nFQ.a(370L, 2L, 1L, false);
          com.tencent.mm.plugin.appbrand.report.c.H(s.this.mAppId, 24, 0);
          int i = -1;
          if (s.b(s.this) != null)
          {
            j = s.b(s.this).aaa().fPS.fEN;
            i = s.b(s.this).aaa().fPS.fEM;
          }
          com.tencent.mm.plugin.appbrand.report.c.a(s.this.mAppId, j, i, 370, 2);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          com.tencent.mm.plugin.appbrand.report.quality.a.aov();
          com.tencent.mm.plugin.appbrand.report.quality.b.a(bool, s.this.mAppId, l, "WAWebview.js", this.fAf);
          h.nFQ.a(370L, 3L, 1L, false);
        }
      });
      return;
    }
  }
  
  public final void E(int paramInt, boolean paramBoolean)
  {
    super.E(paramInt, paramBoolean);
  }
  
  protected final void F(JSONObject paramJSONObject)
  {
    super.F(paramJSONObject);
    com.tencent.mm.plugin.appbrand.e.d.o(paramJSONObject);
  }
  
  public final com.tencent.mm.plugin.appbrand.menu.n a(com.tencent.mm.plugin.appbrand.menu.o paramo)
  {
    if (paramo == null) {
      return null;
    }
    return super.lY(paramo.ordinal());
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.appbrand.i parami)
  {
    this.fzW = ((com.tencent.mm.plugin.appbrand.n)parami);
    super.a(paramContext, parami);
    this.gUj.mAppId = parami.mAppId;
    com.tencent.mm.plugin.appbrand.widget.input.n.v(this);
    com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
    this.gUi = ((com.tencent.mm.plugin.appbrand.widget.recentview.d)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).a(this.mContext, d.b.hDj, new s.5(this));
    this.gUh = new e(this.mContext);
    this.gUh.setWidth(-1);
    this.gUh.setBackgroundDrawable(new ColorDrawable());
    if (this.gUi != null)
    {
      this.gUi.refresh();
      this.gUh.setHeight(this.gUi.getLayoutParams().height);
      this.gUi.setBackground(com.tencent.mm.cb.a.g(this.mContext, y.f.app_brand_game_recent_popwindow_background));
      this.gUh.setContentView(this.gUi);
      this.gUi.setOnItemClickListener(new s.6(this));
    }
    for (;;)
    {
      this.gTC.setCapsuleHomeButtonLongClickListener(new s.7(this));
      this.gTC.setCloseButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          com.tencent.mm.plugin.appbrand.report.c.a(s.this.mAppId, s.this.getURL(), 22, "", bk.UX(), 1, 0);
        }
      });
      this.geK = new com.tencent.mm.plugin.appbrand.c((com.tencent.mm.plugin.appbrand.n)parami, this);
      return;
      y.w("MicroMsg.AppBrandPageViewWC", "AppBrandRecentView is null, appId: %s", new Object[] { this.mAppId });
    }
  }
  
  public final p aae()
  {
    return (p)super.Zy();
  }
  
  protected final void aao()
  {
    anu();
    this.gUp = true;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.i> aau()
  {
    return com.tencent.mm.plugin.appbrand.jsapi.m.ahP();
  }
  
  public void agQ()
  {
    super.agQ();
    this.fzW.fzG.n(4, System.currentTimeMillis() - this.gUm);
    AppBrandPerformanceManager.b(this.mAppId, 203, System.currentTimeMillis() - this.gUl);
    com.tencent.mm.plugin.appbrand.performance.a.a(this.mAppId, "Native", "PageLoad", this.gUl, System.currentTimeMillis(), "");
    this.gUj.aog();
  }
  
  public void agR()
  {
    super.agR();
    this.gUj.pY();
  }
  
  public void agS()
  {
    super.agS();
    if (this.gUh != null) {
      this.gUh.dismiss();
    }
    this.gUj.qa();
  }
  
  public void agT()
  {
    super.agT();
    Object localObject = this.gUj;
    ((com.tencent.mm.plugin.appbrand.report.model.c)localObject).gYi.aof();
    localObject = ((com.tencent.mm.plugin.appbrand.report.model.c)localObject).gYi;
    ((j)localObject).quit();
    ((j)localObject).mStopped = true;
  }
  
  public void agV()
  {
    super.agV();
    if (this.gUi != null) {
      this.gUi.release();
    }
    if (this.gUh != null)
    {
      e locale = this.gUh;
      locale.dismiss();
      if (locale.hoZ != null)
      {
        locale.hoZ.removeAllViews();
        locale.hoZ = null;
      }
    }
    com.tencent.mm.sdk.platformtools.ai.S(this.gUo);
  }
  
  public View ahb()
  {
    if (anp())
    {
      AppBrandActionHeaderLayout localAppBrandActionHeaderLayout = new AppBrandActionHeaderLayout(this.mContext);
      localAppBrandActionHeaderLayout.setAppId(this.mAppId);
      localAppBrandActionHeaderLayout.setActionHeaderStyle(this.gTO);
      y.w("MicroMsg.AppBrandPageViewWC", "getActionSheetHeader orientation:%d,mActionSheetTitleStrId:%d", new Object[] { Integer.valueOf(((MMActivity)this.mContext).getRequestedOrientation()), Integer.valueOf(this.gTP) });
      if (this.gTP > 0) {
        localAppBrandActionHeaderLayout.setStatusId(this.gTP);
      }
      localAppBrandActionHeaderLayout.bX(((com.tencent.mm.plugin.appbrand.n)super.getRuntime()).aac().iconUrl, ((com.tencent.mm.plugin.appbrand.n)super.getRuntime()).aac().bJw);
      return localAppBrandActionHeaderLayout;
    }
    return super.ahb();
  }
  
  public Bitmap ahe()
  {
    View localView = ((w)this.gTF).getView();
    if (localView == null) {
      return null;
    }
    int i = localView.getWidth();
    int j = localView.getHeight();
    int k = localView.getScrollX();
    int m = localView.getScrollY();
    if ((i == 0) || (j == 0)) {
      return null;
    }
    localView.scrollTo(0, 0);
    if (((w)this.gTF).isXWalkKernel())
    {
      localBitmap1 = e(localView, agO());
      localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, 0, i, j);
      localBitmap1.recycle();
      localView.postDelayed(new s.10(this, localView, k, m), 500L);
      return localBitmap2;
    }
    Bitmap localBitmap1 = e(localView, agO());
    Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, 0, i, j);
    localBitmap1.recycle();
    localView.scrollTo(k, m);
    return localBitmap2;
  }
  
  protected final List<com.tencent.mm.plugin.appbrand.menu.n> ane()
  {
    boolean bool2 = true;
    Object localObject = this.mAppId;
    LinkedList localLinkedList = new LinkedList();
    WxaMenuHelper.c(localLinkedList, com.tencent.mm.plugin.appbrand.menu.o.gPi.ordinal(), false);
    WxaMenuHelper.c(localLinkedList, com.tencent.mm.plugin.appbrand.menu.o.gPj.ordinal(), false);
    WxaMenuHelper.c(localLinkedList, com.tencent.mm.plugin.appbrand.menu.o.gPk.ordinal(), true);
    WxaMenuHelper.c(localLinkedList, com.tencent.mm.plugin.appbrand.menu.o.gPr.ordinal(), false);
    localObject = com.tencent.mm.plugin.appbrand.a.qo((String)localObject);
    if (!com.tencent.mm.sdk.a.b.cqk())
    {
      bool1 = bool2;
      if (localObject != null) {
        if (((com.tencent.mm.plugin.appbrand.config.i)localObject).aej() != 1) {
          break label203;
        }
      }
    }
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      WxaMenuHelper.c(localLinkedList, com.tencent.mm.plugin.appbrand.menu.o.gPs.ordinal(), bool1);
      WxaMenuHelper.c(localLinkedList, com.tencent.mm.plugin.appbrand.menu.o.gPt.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, com.tencent.mm.plugin.appbrand.menu.o.gPu.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, com.tencent.mm.plugin.appbrand.menu.o.gPm.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, com.tencent.mm.plugin.appbrand.menu.o.gPo.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, com.tencent.mm.plugin.appbrand.menu.o.gPx.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, com.tencent.mm.plugin.appbrand.menu.o.gPn.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, com.tencent.mm.plugin.appbrand.menu.o.gPp.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, com.tencent.mm.plugin.appbrand.menu.o.gPw.ordinal(), false);
      WxaMenuHelper.c(localLinkedList, com.tencent.mm.plugin.appbrand.menu.o.gPq.ordinal(), false);
      return localLinkedList;
    }
  }
  
  public final String ang()
  {
    if (this.fzW == null) {
      return "https://servicewechat.com/" + "preload/";
    }
    return "https://servicewechat.com/" + String.format(Locale.US, "%s/%d/", new Object[] { this.mAppId, Integer.valueOf(this.fzW.aaa().fPS.fEN) });
  }
  
  protected final void anj()
  {
    if (((com.tencent.mm.plugin.appbrand.n)super.getRuntime()).aab().scene == 1023)
    {
      anl();
      return;
    }
    if ((!((com.tencent.mm.plugin.appbrand.n)super.getRuntime()).ZG()) && (((com.tencent.mm.plugin.appbrand.n)super.getRuntime()).aad().getPageCount() == 1))
    {
      anl();
      return;
    }
    ank();
  }
  
  protected final String ano()
  {
    if ((this.fzW == null) || (this.fzW.fyz.amA())) {}
    for (boolean bool = true;; bool = false)
    {
      this.gUr = bool;
      if (!this.gUr) {
        break;
      }
      return WxaCommLibRuntimeReader.qX("WAPageFrame.html");
    }
    return aq.a(this.fzW, "page-frame.html");
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.t.a ans()
  {
    View localView = getContentView().findViewById(y.g.app_brand_pageview_html_webview);
    if ((localView instanceof com.tencent.mm.plugin.appbrand.jsapi.t.a)) {
      return (com.tencent.mm.plugin.appbrand.jsapi.t.a)localView;
    }
    return null;
  }
  
  public final void ant()
  {
    int i = 1;
    q.runOnUiThread(new q.23(this));
    if (((com.tencent.mm.plugin.appbrand.n)super.getRuntime()).aad().getPageCount() < 2) {
      ((com.tencent.mm.plugin.appbrand.n)super.getRuntime()).fyC = true;
    }
    c localc = new c(this.mContext);
    com.tencent.mm.plugin.appbrand.n localn = (com.tencent.mm.plugin.appbrand.n)super.getRuntime();
    c.inflate(localc.getContext(), y.h.app_brand_error_page_layout, localc);
    localc.gSx = ((ImageView)localc.findViewById(y.g.app_brand_error_page_iv));
    localc.gSy = ((TextView)localc.findViewById(y.g.app_brand_error_page_tips));
    localc.gSz = ((Button)localc.findViewById(y.g.app_brand_error_page_index));
    localc.gSy.setText(localc.getResources().getString(y.j.luggage_app_brand_error_guide, new Object[] { localn.ZB().bJw }));
    Object localObject = (LinearLayout.LayoutParams)localc.gSx.getLayoutParams();
    if ((localn.getAppConfig() != null) && (localn.getAppConfig().fNB != null) && (localn.getAppConfig().fNB.adW())) {}
    for (;;)
    {
      if ((i != 0) || (localn.ZH()))
      {
        ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cb.a.ab(localc.getContext(), y.e.app_brand_error_page_top_margin);
        localc.gSx.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localc.requestLayout();
      }
      localObject = new ColorMatrix();
      ((ColorMatrix)localObject).setSaturation(0.0F);
      localObject = new ColorMatrixColorFilter((ColorMatrix)localObject);
      localc.gSx.setColorFilter((ColorFilter)localObject);
      com.tencent.mm.modelappbrand.a.b.JD().a(localc.gSx, localn.ZB().fPM, com.tencent.mm.modelappbrand.a.a.JC(), com.tencent.mm.modelappbrand.a.f.eaL);
      localc.gSz.setVisibility(8);
      localc.setBackgroundColor(-1);
      com.tencent.mm.plugin.appbrand.report.c.H(localn.ZB().appId, 27, 0);
      aha().addView(localc);
      return;
      i = 0;
    }
  }
  
  protected final void az(List<com.tencent.mm.plugin.appbrand.menu.n> paramList)
  {
    new m(this, paramList).amW();
  }
  
  public af cg(Context paramContext)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = com.tencent.mm.sdk.platformtools.ae.getContext();
    }
    return new w(localContext, this.gTV);
  }
  
  public ai ch(Context paramContext)
  {
    return new s.3(this, paramContext);
  }
  
  public final void dw(boolean paramBoolean)
  {
    com.tencent.mm.plugin.appbrand.permission.d locald = ((com.tencent.mm.plugin.appbrand.n)super.getRuntime()).fzB;
    if ((locald.a(this, s.a.class)) || (locald.a((p)super.Zy(), com.tencent.mm.plugin.appbrand.jsapi.k.o.class)) || (locald.a(this, com.tencent.mm.plugin.appbrand.jsapi.k.o.class))) {
      super.dw(paramBoolean);
    }
  }
  
  public final Bitmap e(View paramView1, View paramView2)
  {
    if (paramView1 == null) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramView1.getWidth(), paramView1.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Drawable localDrawable = paramView1.getBackground();
    if (localDrawable != null) {
      localDrawable.draw(localCanvas);
    }
    if (((w)this.gTF).isXWalkKernel()) {
      ((w)this.gTF).drawCanvas(localCanvas);
    }
    for (;;)
    {
      if (!(paramView1 instanceof com.tencent.mm.plugin.appbrand.jsapi.coverview.n)) {
        com.tencent.mm.sdk.platformtools.c.a(localCanvas, paramView2);
      }
      return localBitmap;
      paramView1.draw(localCanvas);
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.n getRuntime()
  {
    return (com.tencent.mm.plugin.appbrand.n)super.getRuntime();
  }
  
  public void initView()
  {
    super.initView();
    anf().a(new ae()
    {
      final void ajc()
      {
        com.tencent.mm.plugin.webview.ui.tools.widget.o.Dh(2);
      }
      
      final void anw()
      {
        com.tencent.mm.plugin.webview.ui.tools.widget.o.Dh(1);
      }
    });
  }
  
  public boolean isFullScreen()
  {
    return this.gTS.ahi() == c.a.gVY;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.sdk.platformtools.ai.d(new s.8(this, paramConfiguration));
  }
  
  protected final void onCreate()
  {
    com.tencent.mm.plugin.appbrand.m.qI(this.mAppId).fzv.set(((w)this.gTF).getIsX5Kernel());
    boolean bool = ((w)this.gTF).getIsX5Kernel();
    Object localObject1 = h.nFQ;
    int i;
    label102:
    Object localObject2;
    if (bool)
    {
      i = 2;
      ((h)localObject1).a(482, 482, 1, i, 1, 1, false);
      ahK().evaluateJavascript(String.format(Locale.US, "history.pushState({},\"\",\"%s\");", new Object[] { anh() }), null);
      if (this.gUp) {
        break label246;
      }
      anu();
      localObject2 = "";
      localObject1 = localObject2;
      if (this.fzW.aaa().fPN)
      {
        localObject1 = localObject2;
        if (!this.fzW.aah()) {
          localObject1 = WxaCommLibRuntimeReader.qX("WAVConsole.js");
        }
      }
      if (bk.bl((String)localObject1)) {
        break label254;
      }
      long l = System.currentTimeMillis();
      bool = aan();
      ahK().evaluateJavascript((String)localObject1, new s.2(this, bool, l, (String)localObject1));
    }
    for (;;)
    {
      if (!this.gUq)
      {
        this.gUq = true;
        this.fzW.fzG.n(3, System.currentTimeMillis() - this.gUk);
        com.tencent.mm.plugin.appbrand.performance.a.a(this.mAppId, "Native", "WebViewInit+PageFrameLoad", this.gUk, System.currentTimeMillis(), "");
      }
      return;
      i = 3;
      break;
      label246:
      this.gUp = false;
      break label102;
      label254:
      localObject2 = new StringBuilder();
      localObject1 = "";
      if (AppBrandPerformanceManager.vS(this.mAppId)) {
        localObject1 = WxaCommLibRuntimeReader.qX("WAPerf.js");
      }
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = "";
      if (this.fzW.aah()) {
        localObject1 = ";" + WxaCommLibRuntimeReader.qX("WARemoteDebug.js");
      }
      localObject1 = (String)localObject1;
      ahK().evaluateJavascript((String)localObject1, null);
    }
  }
  
  public boolean tB(String paramString)
  {
    this.gUj.wc(paramString);
    this.gUl = System.currentTimeMillis();
    return super.tB(paramString);
  }
  
  protected final void vJ(String paramString)
  {
    this.gUm = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (this.gUr)
    {
      if (this.fzW.fyz.amA()) {
        ahK().evaluateJavascript(aq.a(this.fzW, "app-wxss.js"), null);
      }
    }
    else if (this.fzW.fyz.amA())
    {
      paramString = com.tencent.luggage.j.g.bi(paramString);
      paramString = this.fzW.fyz.vk(paramString);
      localStringBuilder = new StringBuilder().append(paramString);
      if (!paramString.endsWith("/")) {
        break label163;
      }
    }
    label163:
    for (paramString = "";; paramString = "/")
    {
      paramString = paramString + "page-frame.js";
      ahK().evaluateJavascript(aq.a(this.fzW, paramString), null);
      return;
      ahK().evaluateJavascript(r.vN(ano()), null);
      break;
    }
  }
  
  protected final void vK(String paramString)
  {
    if (!((com.tencent.mm.plugin.appbrand.n)super.getRuntime()).fzB.a(this, s.b.class))
    {
      ant();
      return;
    }
    y.i("MicroMsg.AppBrandPageViewWC", "publishPageNotFound url:%s", new Object[] { paramString });
    HashMap localHashMap = new HashMap();
    localHashMap.put("path", com.tencent.luggage.j.g.bi(paramString));
    localHashMap.put("query", com.tencent.luggage.j.g.bj(paramString));
    localHashMap.put("rawPath", paramString);
    localHashMap.put("isEntryPage", Boolean.valueOf(bk.pm(paramString).equals(((com.tencent.mm.plugin.appbrand.n)super.getRuntime()).ZF())));
    b(new s.b((byte)0).o(localHashMap));
    com.tencent.mm.sdk.platformtools.ai.l(this.gUo, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.s
 * JD-Core Version:    0.7.0.1
 */