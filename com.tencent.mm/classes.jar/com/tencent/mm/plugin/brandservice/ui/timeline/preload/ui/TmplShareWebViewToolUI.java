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
import com.tencent.mm.ah.x;
import com.tencent.mm.plugin.brandservice.a.b.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.o;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.e;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/preload/api/ITmplShareWebView;", "()V", "TAG", "", "_webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "get_webView", "()Lcom/tencent/mm/ui/widget/MMWebView;", "set_webView", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "contentRoot", "Landroid/view/ViewGroup;", "getContentRoot", "()Landroid/view/ViewGroup;", "contentRoot$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "density", "", "enterId", "", "getEnterId", "()I", "enterId$delegate", "enterPageTime", "", "getEnterPageTime", "()J", "setEnterPageTime", "(J)V", "mOnForegroundListener", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1;", "mpMenuHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "getMpMenuHelper", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "setMpMenuHelper", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;)V", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "msgInfo$delegate", "nativePageRootLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getNativePageRootLayout", "()Landroid/view/View;", "nativePageRootLayout$delegate", "pageController", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "getPageController", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "setPageController", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;)V", "pageStayTime", "getPageStayTime", "setPageStayTime", "publishId", "getPublishId", "()Ljava/lang/String;", "publishId$delegate", "redirectedFullScreenH5", "", "getRedirectedFullScreenH5", "()Z", "setRedirectedFullScreenH5", "(Z)V", "resumePageTime", "getResumePageTime", "setResumePageTime", "scene", "getScene", "scene$delegate", "shareLayout", "Landroid/widget/RelativeLayout;", "getShareLayout", "()Landroid/widget/RelativeLayout;", "shareLayout$delegate", "subScene", "getSubScene", "subScene$delegate", "timeLineSessionId", "getTimeLineSessionId", "timeLineSessionId$delegate", "videoEnterId", "getVideoEnterId", "setVideoEnterId", "(I)V", "webView", "getWebView", "webView$delegate", "adWebviewReady", "", "bundle", "Landroid/os/Bundle;", "canTryPreloadNextWebView", "closeAdWebview", "closeDotWebview", "convertFuncFlag", "flag", "createAdWebview", "createWebView", "doOnDestroy", "dotWebviewReady", "enableMinimize", "getMPVideoState", "getNaitivePageLayoutID", "hideDotWebview", "isNativePage", "loadForceUrl", "forceUrl", "fullScreen", "modifyForceUrl", "url", "needShowBottom", "onDestroy", "onPause", "onReset", "onResetAfterCreate", "onResume", "onWebViewScrollChanged", "scrollY", "opPlayer", "redirectFullScreenH5", "redirectUrl", "sendMPPageData", "setDotScriptData", "setFuncFlag", "setShareFuncFlag", "showReaderModeMenu", "showShareMenu", "switchVideo", "updateMenu", "updateShareContentHeight", "plugin-brandservice_release"})
public abstract class TmplShareWebViewToolUI
  extends TmplWebViewToolUI
  implements com.tencent.mm.plugin.webview.g.a.c
{
  protected final String TAG = "MicroMsg.TmplShareWebViewToolUI";
  private float density = 3.0F;
  protected long mfG;
  private final o osV = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new a(this));
  MMWebView osW;
  private final o osX = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new n(this));
  private final o osY = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new f(this));
  private final o osZ = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new e(this));
  public com.tencent.mm.plugin.brandservice.ui.timeline.video.b ota = new com.tencent.mm.plugin.brandservice.ui.timeline.video.b();
  protected com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p otb = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p();
  protected long otc;
  protected long otd;
  private final o ote = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new j(this));
  private final o otf = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new l(this));
  private final o otg = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new c(this));
  private final o oth = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new h(this));
  protected final o oti = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new m(this));
  private final o otj = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new k(this));
  private int otk;
  private boolean otl;
  private final d otm = new d(this);
  
  public void Aa(int paramInt) {}
  
  public final void R(Bundle paramBundle)
  {
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p localp = this.otb;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getString("extInfo");; paramBundle = null)
    {
      localp.oyB = paramBundle;
      this.otb.jq(true);
      return;
    }
  }
  
  public void S(Bundle paramBundle)
  {
    Object localObject = new x();
    ((x)localObject).u(paramBundle);
    ((x)localObject).t(getIntent());
    paramBundle = ((x)localObject).hFY.url;
    d.g.b.p.g(paramBundle, "msgInfo.item.url");
    paramBundle = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(paramBundle, "isNativePage", "2"), "enterid", String.valueOf(bRN()));
    localObject = new b.a();
    AppCompatActivity localAppCompatActivity = getContext();
    d.g.b.p.g(localAppCompatActivity, "context");
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.a((Context)localAppCompatActivity, paramBundle, getIntent().getIntExtra(e.m.Jpz, -1), getIntent().getIntExtra(e.m.Jpv, -1), getIntent().getIntExtra(e.m.Jpw, -1), getIntent(), -1, (b.a)localObject, false);
    onReset();
  }
  
  public boolean T(Bundle paramBundle)
  {
    return false;
  }
  
  public void U(Bundle paramBundle) {}
  
  public void V(Bundle paramBundle) {}
  
  public void W(Bundle paramBundle) {}
  
  public void X(Bundle paramBundle) {}
  
  public void Y(Bundle paramBundle) {}
  
  public final void YF(String paramString)
  {
    d.g.b.p.h(paramString, "redirectUrl");
    if (this.otl) {
      return;
    }
    this.otl = true;
    AppCompatActivity localAppCompatActivity = getContext();
    d.g.b.p.g(localAppCompatActivity, "context");
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a((Context)localAppCompatActivity, bRK(), paramString);
    ar.o((Runnable)new i(this), 300L);
    com.tencent.mm.plugin.webview.h.a.XF(5);
  }
  
  public void Z(Bundle paramBundle) {}
  
  public final void Zv()
  {
    this.otb.Zv();
  }
  
  protected final ViewGroup bRI()
  {
    return (ViewGroup)this.osV.a(cxA[0]);
  }
  
  public final View bRJ()
  {
    return (View)this.osY.a(cxA[2]);
  }
  
  protected final x bRK()
  {
    return (x)this.osZ.a(cxA[3]);
  }
  
  protected final String bRL()
  {
    return (String)this.oth.a(cxA[7]);
  }
  
  public final RelativeLayout bRM()
  {
    return (RelativeLayout)this.otj.a(cxA[9]);
  }
  
  protected final int bRN()
  {
    if (this.otk == 0) {}
    for (int i = ((Number)this.otg.a(cxA[6])).intValue();; i = this.otk)
    {
      this.otk = i;
      return this.otk;
    }
  }
  
  public final MMWebView bRO()
  {
    MMWebView localMMWebView = super.bRO();
    if (localMMWebView != null)
    {
      this.osW = localMMWebView;
      localMMWebView.a((MMWebView.e)new b(this));
      return localMMWebView;
    }
    return null;
  }
  
  public boolean bRP()
  {
    return false;
  }
  
  public void bRQ()
  {
    super.bRQ();
    this.otc = System.currentTimeMillis();
    com.tencent.mm.sdk.b.a.IvT.c((com.tencent.mm.sdk.b.c)this.otm);
    MMWebView localMMWebView = this.osM;
    if (localMMWebView != null) {
      localMMWebView.setOnLongClickListener((View.OnLongClickListener)g.oto);
    }
    this.density = getWebView().getMMDensity();
  }
  
  public void bRR() {}
  
  public final boolean bRS()
  {
    return false;
  }
  
  public final void bRT()
  {
    this.otb.jq(false);
    this.ota.ouf.ed(20, 0);
  }
  
  public final void bRU() {}
  
  public void bRV() {}
  
  public void bRW() {}
  
  public Bundle bRX()
  {
    return new Bundle();
  }
  
  public final boolean bRY()
  {
    return true;
  }
  
  protected final int getScene()
  {
    return ((Number)this.ote.a(cxA[4])).intValue();
  }
  
  protected final int getSubScene()
  {
    return ((Number)this.otf.a(cxA[5])).intValue();
  }
  
  protected final MMWebView getWebView()
  {
    return (MMWebView)this.osX.a(cxA[1]);
  }
  
  public void onDestroy()
  {
    bRR();
    super.onDestroy();
    com.tencent.mm.sdk.b.a.IvT.d((com.tencent.mm.sdk.b.c)this.otm);
  }
  
  public void onPause()
  {
    super.onPause();
    long l = System.currentTimeMillis();
    this.mfG += l - this.otd;
    this.otd = l;
  }
  
  public void onReset()
  {
    this.osW = null;
    Object localObject = bRJ();
    d.g.b.p.g(localObject, "nativePageRootLayout");
    localObject = ((View)localObject).getParent();
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)localObject).removeView(bRJ());
    localObject = bRM().getParent();
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)localObject).removeView((View)bRM());
    super.onReset();
  }
  
  public void onResume()
  {
    super.onResume();
    this.otd = System.currentTimeMillis();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<ViewGroup>
  {
    a(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "", "scrollY", "<anonymous parameter 2>", "<anonymous parameter 3>", "onWebViewScrollChanged", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$createWebView$1$1"})
  static final class b
    implements MMWebView.e
  {
    b(TmplShareWebViewToolUI paramTmplShareWebViewToolUI) {}
    
    public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(6869);
      this.otn.Aa(paramInt2);
      AppMethodBeat.o(6869);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    c(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AppActiveEvent;", "callback", "", "event", "plugin-brandservice_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.k>
  {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/message/MPMsgInfo;", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<x>
  {
    e(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.a<View>
  {
    f(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class g
    implements View.OnLongClickListener
  {
    public static final g oto;
    
    static
    {
      AppMethodBeat.i(6874);
      oto = new g();
      AppMethodBeat.o(6874);
    }
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(209069);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$onResetAfterCreate$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$onResetAfterCreate$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(209069);
      return true;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    h(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(TmplShareWebViewToolUI paramTmplShareWebViewToolUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(6876);
      this.otn.finish();
      AppMethodBeat.o(6876);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    j(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/RelativeLayout;", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.a<RelativeLayout>
  {
    k(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    l(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    m(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMWebView;", "invoke"})
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