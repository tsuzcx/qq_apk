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
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.q;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.e;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/preload/api/ITmplShareWebView;", "()V", "TAG", "", "_webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "get_webView", "()Lcom/tencent/mm/ui/widget/MMWebView;", "set_webView", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "contentRoot", "Landroid/view/ViewGroup;", "getContentRoot", "()Landroid/view/ViewGroup;", "contentRoot$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "density", "", "enterId", "", "getEnterId", "()I", "enterId$delegate", "enterPageTime", "", "getEnterPageTime", "()J", "setEnterPageTime", "(J)V", "mOnForegroundListener", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1;", "mpMenuHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "getMpMenuHelper", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "setMpMenuHelper", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;)V", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "msgInfo$delegate", "nativePageRootLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getNativePageRootLayout", "()Landroid/view/View;", "nativePageRootLayout$delegate", "pageController", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "getPageController", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "setPageController", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;)V", "pageStayTime", "getPageStayTime", "setPageStayTime", "publishId", "getPublishId", "()Ljava/lang/String;", "publishId$delegate", "redirectedFullScreenH5", "", "getRedirectedFullScreenH5", "()Z", "setRedirectedFullScreenH5", "(Z)V", "resumePageTime", "getResumePageTime", "setResumePageTime", "scene", "getScene", "scene$delegate", "shareLayout", "Landroid/widget/RelativeLayout;", "getShareLayout", "()Landroid/widget/RelativeLayout;", "shareLayout$delegate", "subScene", "getSubScene", "subScene$delegate", "timeLineSessionId", "getTimeLineSessionId", "timeLineSessionId$delegate", "videoEnterId", "getVideoEnterId", "setVideoEnterId", "(I)V", "webView", "getWebView", "webView$delegate", "adWebviewReady", "", "bundle", "Landroid/os/Bundle;", "canTryPreloadNextWebView", "closeAdWebview", "closeDotWebview", "convertFuncFlag", "flag", "createAdWebview", "createWebView", "doOnDestroy", "dotWebviewReady", "enableMinimize", "getFuncFlag", "getMPVideoState", "getNaitivePageLayoutID", "hideDotWebview", "isNativePage", "loadForceUrl", "forceUrl", "fullScreen", "modifyForceUrl", "url", "needShowBottom", "onDestroy", "onPause", "onReset", "onResetAfterCreate", "onResume", "onWebViewScrollChanged", "scrollY", "opPlayer", "redirectFullScreenH5", "redirectUrl", "sendMPPageData", "setDotScriptData", "setFuncFlag", "setShareFuncFlag", "showReaderModeMenu", "showShareMenu", "switchVideo", "updateMenu", "updateShareContentHeight", "plugin-brandservice_release"})
public abstract class TmplShareWebViewToolUI
  extends TmplWebViewToolUI
  implements com.tencent.mm.plugin.webview.g.a.c
{
  private final String TAG = "MicroMsg.TmplShareWebViewToolUI";
  private float density = 3.0F;
  protected long lBM;
  MMWebView nKA;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nKB = q.a(this.nLf, (d.g.a.a)new n(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nKC = q.a(this.nLf, (d.g.a.a)new f(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nKD = q.a(this.nLf, (d.g.a.a)new e(this));
  public b nKE = new b();
  protected com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o nKF = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o();
  protected long nKG;
  protected long nKH;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nKI = q.a(this.nLf, (d.g.a.a)new j(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nKJ = q.a(this.nLf, (d.g.a.a)new l(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nKK = q.a(this.nLf, (d.g.a.a)new c(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nKL = q.a(this.nLf, (d.g.a.a)new h(this));
  protected final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nKM = q.a(this.nLf, (d.g.a.a)new m(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nKN = q.a(this.nLf, (d.g.a.a)new k(this));
  private int nKO;
  private boolean nKP;
  private final d nKQ = new d(this);
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nKz = q.a(this.nLf, (d.g.a.a)new a(this));
  
  public final void O(Bundle paramBundle)
  {
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o localo = this.nKF;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getString("extInfo");; paramBundle = null)
    {
      localo.nPu = paramBundle;
      this.nKF.jg(true);
      return;
    }
  }
  
  public void P(Bundle paramBundle)
  {
    Object localObject = new x();
    ((x)localObject).t(paramBundle);
    ((x)localObject).t(getIntent());
    paramBundle = ((x)localObject).hkX.url;
    d.g.b.k.g(paramBundle, "msgInfo.item.url");
    paramBundle = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(paramBundle, "isNativePage", "2"), "enterid", String.valueOf(bMl()));
    localObject = new b.a();
    AppCompatActivity localAppCompatActivity = getContext();
    d.g.b.k.g(localAppCompatActivity, "context");
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.a((Context)localAppCompatActivity, paramBundle, getIntent().getIntExtra(e.m.HhB, -1), getIntent().getIntExtra(e.m.Hhx, -1), getIntent().getIntExtra(e.m.Hhy, -1), getIntent(), -1, (b.a)localObject, false);
    onReset();
  }
  
  public boolean Q(Bundle paramBundle)
  {
    return false;
  }
  
  public void R(Bundle paramBundle) {}
  
  public void S(Bundle paramBundle) {}
  
  public void T(Bundle paramBundle) {}
  
  public void U(Bundle paramBundle) {}
  
  public final void Uj(String paramString)
  {
    d.g.b.k.h(paramString, "redirectUrl");
    if (this.nKP) {
      return;
    }
    this.nKP = true;
    AppCompatActivity localAppCompatActivity = getContext();
    d.g.b.k.g(localAppCompatActivity, "context");
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a((Context)localAppCompatActivity, bMi(), paramString);
    ap.n((Runnable)new i(this), 300L);
    com.tencent.mm.plugin.webview.h.a.Vj(5);
  }
  
  public void V(Bundle paramBundle) {}
  
  public void W(Bundle paramBundle) {}
  
  public final void WT()
  {
    this.nKF.WT();
  }
  
  protected final ViewGroup bMg()
  {
    return (ViewGroup)this.nKz.a($$delegatedProperties[0]);
  }
  
  public final View bMh()
  {
    return (View)this.nKC.a($$delegatedProperties[2]);
  }
  
  protected final x bMi()
  {
    return (x)this.nKD.a($$delegatedProperties[3]);
  }
  
  protected final String bMj()
  {
    return (String)this.nKL.a($$delegatedProperties[7]);
  }
  
  public final RelativeLayout bMk()
  {
    return (RelativeLayout)this.nKN.a($$delegatedProperties[9]);
  }
  
  protected final int bMl()
  {
    if (this.nKO == 0) {}
    for (int i = ((Number)this.nKK.a($$delegatedProperties[6])).intValue();; i = this.nKO)
    {
      this.nKO = i;
      return this.nKO;
    }
  }
  
  public final MMWebView bMm()
  {
    MMWebView localMMWebView = super.bMm();
    if (localMMWebView != null)
    {
      this.nKA = localMMWebView;
      localMMWebView.a((MMWebView.e)new b(this));
      return localMMWebView;
    }
    return null;
  }
  
  public boolean bMn()
  {
    return false;
  }
  
  public void bMo()
  {
    super.bMo();
    this.nKG = System.currentTimeMillis();
    com.tencent.mm.sdk.b.a.GpY.c((com.tencent.mm.sdk.b.c)this.nKQ);
    MMWebView localMMWebView = this.nKq;
    if (localMMWebView != null) {
      localMMWebView.setOnLongClickListener((View.OnLongClickListener)g.nKS);
    }
    this.density = getWebView().getMMDensity();
  }
  
  public void bMp() {}
  
  public final boolean bMq()
  {
    return false;
  }
  
  public final void bMr()
  {
    this.nKF.jg(false);
    this.nKE.nLI.eb(20, 0);
  }
  
  public final Bundle bMs()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("funcFlag", zi(this.nKE.hhc));
    return localBundle;
  }
  
  public final void bMt() {}
  
  public void bMu() {}
  
  public void bMv() {}
  
  public Bundle bMw()
  {
    return new Bundle();
  }
  
  public final boolean bMx()
  {
    return true;
  }
  
  protected final int getScene()
  {
    return ((Number)this.nKI.a($$delegatedProperties[4])).intValue();
  }
  
  protected final int getSubScene()
  {
    return ((Number)this.nKJ.a($$delegatedProperties[5])).intValue();
  }
  
  protected final MMWebView getWebView()
  {
    return (MMWebView)this.nKB.a($$delegatedProperties[1]);
  }
  
  public void onDestroy()
  {
    bMp();
    super.onDestroy();
    com.tencent.mm.sdk.b.a.GpY.d((com.tencent.mm.sdk.b.c)this.nKQ);
  }
  
  public void onPause()
  {
    super.onPause();
    long l = System.currentTimeMillis();
    this.lBM += l - this.nKH;
    this.nKH = l;
  }
  
  public void onReset()
  {
    this.nKA = null;
    Object localObject = bMh();
    d.g.b.k.g(localObject, "nativePageRootLayout");
    localObject = ((View)localObject).getParent();
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)localObject).removeView(bMh());
    localObject = bMk().getParent();
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)localObject).removeView((View)bMk());
    super.onReset();
  }
  
  public void onResume()
  {
    super.onResume();
    this.nKH = System.currentTimeMillis();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void zh(int paramInt) {}
  
  protected final int zi(int paramInt)
  {
    if (paramInt == -1) {
      return -1;
    }
    int j;
    int i;
    if ((paramInt & 0x8) == 0)
    {
      j = 1;
      if ((paramInt & 0x10) != 0) {
        break label69;
      }
      i = 1;
      label25:
      if (j == 0) {
        break label74;
      }
    }
    label69:
    label74:
    for (paramInt = 1;; paramInt = 0)
    {
      j = paramInt;
      if (i != 0) {
        j = paramInt | 0x2;
      }
      ac.i(this.TAG, "convertFuncFlag %d", new Object[] { Integer.valueOf(j) });
      return j;
      j = 0;
      break;
      i = 0;
      break label25;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<ViewGroup>
  {
    a(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "", "scrollY", "<anonymous parameter 2>", "<anonymous parameter 3>", "onWebViewScrollChanged", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$createWebView$1$1"})
  static final class b
    implements MMWebView.e
  {
    b(TmplShareWebViewToolUI paramTmplShareWebViewToolUI) {}
    
    public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(6869);
      this.nKR.zh(paramInt2);
      AppMethodBeat.o(6869);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    c(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AppActiveEvent;", "callback", "", "event", "plugin-brandservice_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.k>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/message/MPMsgInfo;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<x>
  {
    e(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    f(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class g
    implements View.OnLongClickListener
  {
    public static final g nKS;
    
    static
    {
      AppMethodBeat.i(6874);
      nKS = new g();
      AppMethodBeat.o(6874);
    }
    
    public final boolean onLongClick(View paramView)
    {
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    h(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(TmplShareWebViewToolUI paramTmplShareWebViewToolUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(6876);
      this.nKR.finish();
      AppMethodBeat.o(6876);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    j(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/RelativeLayout;", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<RelativeLayout>
  {
    k(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    l(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    m(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMWebView;", "invoke"})
  static final class n
    extends d.g.b.l
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