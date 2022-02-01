package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.plugin.brandservice.a.b.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.e;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/preload/api/ITmplShareWebView;", "()V", "TAG", "", "_webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "get_webView", "()Lcom/tencent/mm/ui/widget/MMWebView;", "set_webView", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "contentRoot", "Landroid/view/ViewGroup;", "getContentRoot", "()Landroid/view/ViewGroup;", "contentRoot$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "density", "", "enterId", "", "getEnterId", "()I", "enterId$delegate", "enterPageTime", "", "getEnterPageTime", "()J", "setEnterPageTime", "(J)V", "mOnForegroundListener", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1;", "mpMenuHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "getMpMenuHelper", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "setMpMenuHelper", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;)V", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "msgInfo$delegate", "nativePageRootLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getNativePageRootLayout", "()Landroid/view/View;", "nativePageRootLayout$delegate", "pageController", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "getPageController", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "setPageController", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;)V", "pageStayTime", "getPageStayTime", "setPageStayTime", "publishId", "getPublishId", "()Ljava/lang/String;", "publishId$delegate", "redirectedFullScreenH5", "", "getRedirectedFullScreenH5", "()Z", "setRedirectedFullScreenH5", "(Z)V", "resumePageTime", "getResumePageTime", "setResumePageTime", "scene", "getScene", "scene$delegate", "shareLayout", "Landroid/widget/RelativeLayout;", "getShareLayout", "()Landroid/widget/RelativeLayout;", "shareLayout$delegate", "subScene", "getSubScene", "subScene$delegate", "timeLineSessionId", "getTimeLineSessionId", "timeLineSessionId$delegate", "videoEnterId", "getVideoEnterId", "setVideoEnterId", "(I)V", "webView", "getWebView", "webView$delegate", "adWebviewReady", "", "bundle", "Landroid/os/Bundle;", "canTryPreloadNextWebView", "closeAdWebview", "closeDotWebview", "convertFuncFlag", "flag", "createAdWebview", "createWebView", "doOnDestroy", "dotWebviewReady", "enableMinimize", "getMPVideoState", "getNaitivePageLayoutID", "hideDotWebview", "isNativePage", "loadForceUrl", "forceUrl", "fullScreen", "modifyForceUrl", "url", "needShowBottom", "onDestroy", "onPause", "onReset", "onResetAfterCreate", "onResume", "onWebViewScrollChanged", "scrollY", "opPlayer", "redirectFullScreenH5", "redirectUrl", "sendMPPageData", "setDotScriptData", "setFuncFlag", "setShareFuncFlag", "showReaderModeMenu", "showShareMenu", "switchVideo", "updateMenu", "updateShareContentHeight", "plugin-brandservice_release"})
public abstract class TmplShareWebViewToolUI
  extends TmplWebViewToolUI
  implements com.tencent.mm.plugin.webview.g.a.c
{
  protected final String TAG = "MicroMsg.TmplShareWebViewToolUI";
  private float density = 3.0F;
  protected long mbn;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o onf = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new a(this));
  MMWebView ong;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o onh = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new n(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o oni = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new f(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o onj = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new e(this));
  public com.tencent.mm.plugin.brandservice.ui.timeline.video.b onk = new com.tencent.mm.plugin.brandservice.ui.timeline.video.b();
  protected com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o onl = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o();
  protected long onm;
  protected long onn;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o ono = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new j(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o onp = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new l(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o onq = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new c(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o onr = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new h(this));
  protected final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o ons = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new m(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o ont = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new k(this));
  private int onu;
  private boolean onv;
  private final d onw = new d(this);
  
  public final void Q(Bundle paramBundle)
  {
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o localo = this.onl;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getString("extInfo");; paramBundle = null)
    {
      localo.osa = paramBundle;
      this.onl.jr(true);
      return;
    }
  }
  
  public void R(Bundle paramBundle)
  {
    Object localObject = new x();
    ((x)localObject).t(paramBundle);
    ((x)localObject).t(getIntent());
    paramBundle = ((x)localObject).hDg.url;
    p.g(paramBundle, "msgInfo.item.url");
    paramBundle = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(paramBundle, "isNativePage", "2"), "enterid", String.valueOf(bQM()));
    localObject = new b.a();
    AppCompatActivity localAppCompatActivity = getContext();
    p.g(localAppCompatActivity, "context");
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.a((Context)localAppCompatActivity, paramBundle, getIntent().getIntExtra(e.m.IUR, -1), getIntent().getIntExtra(e.m.IUN, -1), getIntent().getIntExtra(e.m.IUO, -1), getIntent(), -1, (b.a)localObject, false);
    onReset();
  }
  
  public boolean S(Bundle paramBundle)
  {
    return false;
  }
  
  public void T(Bundle paramBundle) {}
  
  public void U(Bundle paramBundle) {}
  
  public void V(Bundle paramBundle) {}
  
  public void W(Bundle paramBundle) {}
  
  public void X(Bundle paramBundle) {}
  
  public final void XS(String paramString)
  {
    p.h(paramString, "redirectUrl");
    if (this.onv) {
      return;
    }
    this.onv = true;
    AppCompatActivity localAppCompatActivity = getContext();
    p.g(localAppCompatActivity, "context");
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a((Context)localAppCompatActivity, bQJ(), paramString);
    aq.o((Runnable)new i(this), 300L);
    com.tencent.mm.plugin.webview.h.a.WZ(5);
  }
  
  public void Y(Bundle paramBundle) {}
  
  public final void Zm()
  {
    this.onl.Zm();
  }
  
  protected final ViewGroup bQH()
  {
    return (ViewGroup)this.onf.a(cwV[0]);
  }
  
  public final View bQI()
  {
    return (View)this.oni.a(cwV[2]);
  }
  
  protected final x bQJ()
  {
    return (x)this.onj.a(cwV[3]);
  }
  
  protected final String bQK()
  {
    return (String)this.onr.a(cwV[7]);
  }
  
  public final RelativeLayout bQL()
  {
    return (RelativeLayout)this.ont.a(cwV[9]);
  }
  
  protected final int bQM()
  {
    if (this.onu == 0) {}
    for (int i = ((Number)this.onq.a(cwV[6])).intValue();; i = this.onu)
    {
      this.onu = i;
      return this.onu;
    }
  }
  
  public final MMWebView bQN()
  {
    MMWebView localMMWebView = super.bQN();
    if (localMMWebView != null)
    {
      this.ong = localMMWebView;
      localMMWebView.a((MMWebView.e)new b(this));
      return localMMWebView;
    }
    return null;
  }
  
  public boolean bQO()
  {
    return false;
  }
  
  public void bQP()
  {
    super.bQP();
    this.onm = System.currentTimeMillis();
    com.tencent.mm.sdk.b.a.IbL.c((com.tencent.mm.sdk.b.c)this.onw);
    MMWebView localMMWebView = this.omW;
    if (localMMWebView != null) {
      localMMWebView.setOnLongClickListener((View.OnLongClickListener)g.ony);
    }
    this.density = getWebView().getMMDensity();
  }
  
  public void bQQ() {}
  
  public final boolean bQR()
  {
    return false;
  }
  
  public final void bQS()
  {
    this.onl.jr(false);
    this.onk.ooo.ed(20, 0);
  }
  
  public final void bQT() {}
  
  public void bQU() {}
  
  public void bQV() {}
  
  public Bundle bQW()
  {
    return new Bundle();
  }
  
  public final boolean bQX()
  {
    return true;
  }
  
  protected final int getScene()
  {
    return ((Number)this.ono.a(cwV[4])).intValue();
  }
  
  protected final int getSubScene()
  {
    return ((Number)this.onp.a(cwV[5])).intValue();
  }
  
  protected final MMWebView getWebView()
  {
    return (MMWebView)this.onh.a(cwV[1]);
  }
  
  public void onDestroy()
  {
    bQQ();
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IbL.d((com.tencent.mm.sdk.b.c)this.onw);
  }
  
  public void onPause()
  {
    super.onPause();
    long l = System.currentTimeMillis();
    this.mbn += l - this.onn;
    this.onn = l;
  }
  
  public void onReset()
  {
    this.ong = null;
    Object localObject = bQI();
    p.g(localObject, "nativePageRootLayout");
    localObject = ((View)localObject).getParent();
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)localObject).removeView(bQI());
    localObject = bQL().getParent();
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)localObject).removeView((View)bQL());
    super.onReset();
  }
  
  public void onResume()
  {
    super.onResume();
    this.onn = System.currentTimeMillis();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void zR(int paramInt) {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<ViewGroup>
  {
    a(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "", "scrollY", "<anonymous parameter 2>", "<anonymous parameter 3>", "onWebViewScrollChanged", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$createWebView$1$1"})
  static final class b
    implements MMWebView.e
  {
    b(TmplShareWebViewToolUI paramTmplShareWebViewToolUI) {}
    
    public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(6869);
      this.onx.zR(paramInt2);
      AppMethodBeat.o(6869);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    c(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AppActiveEvent;", "callback", "", "event", "plugin-brandservice_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.k>
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/message/MPMsgInfo;", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<x>
  {
    e(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.a<View>
  {
    f(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class g
    implements View.OnLongClickListener
  {
    public static final g ony;
    
    static
    {
      AppMethodBeat.i(6874);
      ony = new g();
      AppMethodBeat.o(6874);
    }
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(210079);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$onResetAfterCreate$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$onResetAfterCreate$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(210079);
      return true;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    h(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(TmplShareWebViewToolUI paramTmplShareWebViewToolUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(6876);
      this.onx.finish();
      AppMethodBeat.o(6876);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    j(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/RelativeLayout;", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.a<RelativeLayout>
  {
    k(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    l(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    m(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMWebView;", "invoke"})
  static final class n
    extends d.g.b.q
    implements d.g.a.a<MMWebView>
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