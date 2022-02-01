package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.ag.x;
import com.tencent.mm.plugin.brandservice.a.b.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.s;
import com.tencent.mm.plugin.webview.h.a.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.e;
import java.util.HashMap;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/preload/api/ITmplShareWebView;", "()V", "TAG", "", "_webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "get_webView", "()Lcom/tencent/mm/ui/widget/MMWebView;", "set_webView", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "contentRoot", "Landroid/view/ViewGroup;", "getContentRoot", "()Landroid/view/ViewGroup;", "contentRoot$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "density", "", "enterId", "", "getEnterId", "()I", "enterId$delegate", "enterPageTime", "", "getEnterPageTime", "()J", "setEnterPageTime", "(J)V", "mOnForegroundListener", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1;", "mpMenuHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "getMpMenuHelper", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "setMpMenuHelper", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;)V", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "msgInfo$delegate", "nativePageRootLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getNativePageRootLayout", "()Landroid/view/View;", "nativePageRootLayout$delegate", "pageController", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "getPageController", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "setPageController", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;)V", "pageStayTime", "getPageStayTime", "setPageStayTime", "publishId", "getPublishId", "()Ljava/lang/String;", "publishId$delegate", "redirectedFullScreenH5", "", "getRedirectedFullScreenH5", "()Z", "setRedirectedFullScreenH5", "(Z)V", "resumePageTime", "getResumePageTime", "setResumePageTime", "scene", "getScene", "scene$delegate", "shareLayout", "Landroid/widget/RelativeLayout;", "getShareLayout", "()Landroid/widget/RelativeLayout;", "shareLayout$delegate", "subScene", "getSubScene", "subScene$delegate", "timeLineSessionId", "getTimeLineSessionId", "timeLineSessionId$delegate", "videoEnterId", "getVideoEnterId", "setVideoEnterId", "(I)V", "webView", "getWebView", "webView$delegate", "adWebviewReady", "", "bundle", "Landroid/os/Bundle;", "canTryPreloadNextWebView", "closeAdWebview", "closeDotWebview", "convertFuncFlag", "flag", "createAdWebview", "createWebView", "doOnDestroy", "dotWebviewReady", "enableMinimize", "getMPVideoState", "getNaitivePageLayoutID", "hideDotWebview", "isNativePage", "loadForceUrl", "forceUrl", "fullScreen", "modifyForceUrl", "url", "needShowBottom", "onDestroy", "onPause", "onReset", "onResetAfterCreate", "onResume", "onWebViewScrollChanged", "scrollY", "opPlayer", "redirectFullScreenH5", "redirectUrl", "sendMPPageData", "setDotScriptData", "setFuncFlag", "setShareFuncFlag", "showReaderModeMenu", "showShareMenu", "switchVideo", "updateMenu", "updateShareContentHeight", "plugin-brandservice_release"})
public abstract class TmplShareWebViewToolUI
  extends TmplWebViewToolUI
  implements c
{
  protected final String TAG = "MicroMsg.TmplShareWebViewToolUI";
  private HashMap _$_findViewCache;
  private float density = 3.0F;
  protected long nqe;
  protected long pGA;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pGB = s.a(this.pGZ, (kotlin.g.a.a)new j(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pGC = s.a(this.pGZ, (kotlin.g.a.a)new l(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pGD = s.a(this.pGZ, (kotlin.g.a.a)new c(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pGE = s.a(this.pGZ, (kotlin.g.a.a)new h(this));
  protected final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pGF = s.a(this.pGZ, (kotlin.g.a.a)new m(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pGG = s.a(this.pGZ, (kotlin.g.a.a)new k(this));
  private int pGH;
  private boolean pGI;
  private final d pGJ = new d(this);
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pGs = s.a(this.pGZ, (kotlin.g.a.a)new a(this));
  MMWebView pGt;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pGu = s.a(this.pGZ, (kotlin.g.a.a)new n(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pGv = s.a(this.pGZ, (kotlin.g.a.a)new f(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pGw = s.a(this.pGZ, (kotlin.g.a.a)new e(this));
  public com.tencent.mm.plugin.brandservice.ui.timeline.video.b pGx = new com.tencent.mm.plugin.brandservice.ui.timeline.video.b();
  protected com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p pGy = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p();
  protected long pGz;
  
  public void DG(int paramInt) {}
  
  public final void X(Bundle paramBundle)
  {
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p localp = this.pGy;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getString("extInfo");; paramBundle = null)
    {
      localp.pMf = paramBundle;
      this.pGy.ks(true);
      return;
    }
  }
  
  public void Y(Bundle paramBundle)
  {
    Object localObject = new x();
    ((x)localObject).A(paramBundle);
    ((x)localObject).t(getIntent());
    paramBundle = ((x)localObject).iAi.url;
    kotlin.g.b.p.g(paramBundle, "msgInfo.item.url");
    paramBundle = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(paramBundle, "isNativePage", "2"), "enterid", String.valueOf(cpx()));
    localObject = new b.a();
    AppCompatActivity localAppCompatActivity = getContext();
    kotlin.g.b.p.g(localAppCompatActivity, "context");
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a((Context)localAppCompatActivity, paramBundle, getIntent().getIntExtra(e.p.OzA, -1), getIntent().getIntExtra(e.p.Ozw, -1), getIntent().getIntExtra(e.p.Ozx, -1), getIntent(), -1, (b.a)localObject, false);
    onReset();
  }
  
  public boolean Z(Bundle paramBundle)
  {
    return false;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void aa(Bundle paramBundle) {}
  
  public void ab(Bundle paramBundle) {}
  
  public void ac(Bundle paramBundle) {}
  
  public void ad(Bundle paramBundle) {}
  
  public void ae(Bundle paramBundle) {}
  
  public void af(Bundle paramBundle) {}
  
  public final void aiE(String paramString)
  {
    kotlin.g.b.p.h(paramString, "redirectUrl");
    if (this.pGI) {
      return;
    }
    this.pGI = true;
    AppCompatActivity localAppCompatActivity = getContext();
    kotlin.g.b.p.g(localAppCompatActivity, "context");
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a((Context)localAppCompatActivity, cpu(), paramString);
    MMHandlerThread.postToMainThreadDelayed((Runnable)new i(this), 300L);
    com.tencent.mm.plugin.webview.i.a.agn(5);
  }
  
  public final void ani()
  {
    this.pGy.ani();
  }
  
  public void cpA()
  {
    super.cpA();
    this.pGz = System.currentTimeMillis();
    EventCenter.instance.addListener((IListener)this.pGJ);
    MMWebView localMMWebView = this.pGj;
    if (localMMWebView != null) {
      localMMWebView.setOnLongClickListener((View.OnLongClickListener)g.pGL);
    }
    this.density = getWebView().getMMDensity();
  }
  
  public void cpB() {}
  
  public final boolean cpC()
  {
    return false;
  }
  
  public final void cpD()
  {
    this.pGy.ks(false);
    this.pGx.pHC.er(20, 0);
  }
  
  public final void cpE() {}
  
  public void cpF() {}
  
  public void cpG() {}
  
  public Bundle cpH()
  {
    return new Bundle();
  }
  
  public final boolean cpI()
  {
    return true;
  }
  
  protected final ViewGroup cps()
  {
    return (ViewGroup)this.pGs.a(cLI[0]);
  }
  
  public final View cpt()
  {
    return (View)this.pGv.a(cLI[2]);
  }
  
  protected final x cpu()
  {
    return (x)this.pGw.a(cLI[3]);
  }
  
  protected final String cpv()
  {
    return (String)this.pGE.a(cLI[7]);
  }
  
  public final RelativeLayout cpw()
  {
    return (RelativeLayout)this.pGG.a(cLI[9]);
  }
  
  protected final int cpx()
  {
    if (this.pGH == 0) {}
    for (int i = ((Number)this.pGD.a(cLI[6])).intValue();; i = this.pGH)
    {
      this.pGH = i;
      return this.pGH;
    }
  }
  
  public final MMWebView cpy()
  {
    MMWebView localMMWebView = super.cpy();
    if (localMMWebView != null)
    {
      this.pGt = localMMWebView;
      localMMWebView.a((MMWebView.e)new b(this));
      return localMMWebView;
    }
    return null;
  }
  
  public boolean cpz()
  {
    return false;
  }
  
  protected final int getScene()
  {
    return ((Number)this.pGB.a(cLI[4])).intValue();
  }
  
  protected final int getSubScene()
  {
    return ((Number)this.pGC.a(cLI[5])).intValue();
  }
  
  protected final MMWebView getWebView()
  {
    return (MMWebView)this.pGu.a(cLI[1]);
  }
  
  public void onDestroy()
  {
    cpB();
    super.onDestroy();
    EventCenter.instance.removeListener((IListener)this.pGJ);
  }
  
  public void onPause()
  {
    super.onPause();
    long l = System.currentTimeMillis();
    this.nqe += l - this.pGA;
    this.pGA = l;
  }
  
  public void onReset()
  {
    this.pGt = null;
    Object localObject = cpt();
    kotlin.g.b.p.g(localObject, "nativePageRootLayout");
    localObject = ((View)localObject).getParent();
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)localObject).removeView(cpt());
    localObject = cpw().getParent();
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)localObject).removeView((View)cpw());
    super.onReset();
  }
  
  public void onResume()
  {
    super.onResume();
    this.pGA = System.currentTimeMillis();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ViewGroup>
  {
    a(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "", "scrollY", "<anonymous parameter 2>", "<anonymous parameter 3>", "onWebViewScrollChanged", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$createWebView$1$1"})
  static final class b
    implements MMWebView.e
  {
    b(TmplShareWebViewToolUI paramTmplShareWebViewToolUI) {}
    
    public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(6869);
      this.pGK.DG(paramInt2);
      AppMethodBeat.o(6869);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    c(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AppActiveEvent;", "callback", "", "event", "plugin-brandservice_release"})
  public static final class d
    extends IListener<com.tencent.mm.g.a.l>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/message/MPMsgInfo;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    f(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class g
    implements View.OnLongClickListener
  {
    public static final g pGL;
    
    static
    {
      AppMethodBeat.i(6874);
      pGL = new g();
      AppMethodBeat.o(6874);
    }
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(195867);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$onResetAfterCreate$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$onResetAfterCreate$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(195867);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    h(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(TmplShareWebViewToolUI paramTmplShareWebViewToolUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(6876);
      this.pGK.finish();
      AppMethodBeat.o(6876);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    j(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/RelativeLayout;", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RelativeLayout>
  {
    k(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    l(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    m(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMWebView;", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MMWebView>
  {
    n(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI
 * JD-Core Version:    0.7.0.1
 */