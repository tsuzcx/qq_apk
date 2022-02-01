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
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.n;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.p;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.e;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/preload/api/ITmplShareWebView;", "()V", "TAG", "", "_webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "get_webView", "()Lcom/tencent/mm/ui/widget/MMWebView;", "set_webView", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "contentRoot", "Landroid/view/ViewGroup;", "getContentRoot", "()Landroid/view/ViewGroup;", "contentRoot$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "density", "", "enterId", "", "getEnterId", "()I", "enterId$delegate", "enterPageTime", "", "getEnterPageTime", "()J", "setEnterPageTime", "(J)V", "mOnForegroundListener", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1;", "mpMenuHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "getMpMenuHelper", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "setMpMenuHelper", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;)V", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "msgInfo$delegate", "nativePageRootLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getNativePageRootLayout", "()Landroid/view/View;", "nativePageRootLayout$delegate", "pageController", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "getPageController", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "setPageController", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;)V", "pageStayTime", "getPageStayTime", "setPageStayTime", "publishId", "getPublishId", "()Ljava/lang/String;", "publishId$delegate", "redirectedFullScreenH5", "", "getRedirectedFullScreenH5", "()Z", "setRedirectedFullScreenH5", "(Z)V", "resumePageTime", "getResumePageTime", "setResumePageTime", "scene", "getScene", "scene$delegate", "shareLayout", "Landroid/widget/RelativeLayout;", "getShareLayout", "()Landroid/widget/RelativeLayout;", "shareLayout$delegate", "subScene", "getSubScene", "subScene$delegate", "timeLineSessionId", "getTimeLineSessionId", "timeLineSessionId$delegate", "videoEnterId", "getVideoEnterId", "setVideoEnterId", "(I)V", "webView", "getWebView", "webView$delegate", "adWebviewReady", "", "bundle", "Landroid/os/Bundle;", "canTryPreloadNextWebView", "closeAdWebview", "closeDotWebview", "convertFuncFlag", "flag", "createAdWebview", "createWebView", "doOnDestroy", "dotWebviewReady", "enableMinimize", "getFuncFlag", "getMPVideoState", "getNaitivePageLayoutID", "hideDotWebview", "isNativePage", "loadForceUrl", "forceUrl", "fullScreen", "modifyForceUrl", "url", "needShowBottom", "onDestroy", "onPause", "onReset", "onResetAfterCreate", "onResume", "onWebViewScrollChanged", "scrollY", "opPlayer", "redirectFullScreenH5", "redirectUrl", "sendMPPageData", "setDotScriptData", "setFuncFlag", "setShareFuncFlag", "showReaderModeMenu", "showShareMenu", "switchVideo", "updateMenu", "updateShareContentHeight", "plugin-brandservice_release"})
public abstract class TmplShareWebViewToolUI
  extends TmplWebViewToolUI
  implements com.tencent.mm.plugin.webview.g.a.c
{
  private final String TAG = "MicroMsg.TmplShareWebViewToolUI";
  private float density = 3.0F;
  protected long lac;
  private final n nhG = p.a(this.nim, (d.g.a.a)new a(this));
  MMWebView nhH;
  private final n nhI = p.a(this.nim, (d.g.a.a)new n(this));
  private final n nhJ = p.a(this.nim, (d.g.a.a)new f(this));
  private final n nhK = p.a(this.nim, (d.g.a.a)new e(this));
  public b nhL = new b();
  protected o nhM = new o();
  protected long nhN;
  protected long nhO;
  private final n nhP = p.a(this.nim, (d.g.a.a)new j(this));
  private final n nhQ = p.a(this.nim, (d.g.a.a)new l(this));
  private final n nhR = p.a(this.nim, (d.g.a.a)new c(this));
  private final n nhS = p.a(this.nim, (d.g.a.a)new h(this));
  protected final n nhT = p.a(this.nim, (d.g.a.a)new m(this));
  private final n nhU = p.a(this.nim, (d.g.a.a)new k(this));
  private int nhV;
  private boolean nhW;
  private final d nhX = new d(this);
  
  public void O(Bundle paramBundle)
  {
    Object localObject = new x();
    ((x)localObject).t(paramBundle);
    ((x)localObject).t(getIntent());
    paramBundle = ((x)localObject).gKx.url;
    d.g.b.k.g(paramBundle, "msgInfo.item.url");
    paramBundle = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(paramBundle, "isNativePage", "2"), "enterid", String.valueOf(bEX()));
    localObject = new b.a();
    AppCompatActivity localAppCompatActivity = getContext();
    d.g.b.k.g(localAppCompatActivity, "context");
    j.a((Context)localAppCompatActivity, paramBundle, getIntent().getIntExtra(e.m.FIt, -1), getIntent().getIntExtra(e.m.FIp, -1), getIntent().getIntExtra(e.m.FIq, -1), getIntent(), -1, (b.a)localObject, false);
    onReset();
  }
  
  public boolean P(Bundle paramBundle)
  {
    return false;
  }
  
  public final void PX(String paramString)
  {
    d.g.b.k.h(paramString, "redirectUrl");
    if (this.nhW) {
      return;
    }
    this.nhW = true;
    AppCompatActivity localAppCompatActivity = getContext();
    d.g.b.k.g(localAppCompatActivity, "context");
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a((Context)localAppCompatActivity, bEU(), paramString);
    aq.n((Runnable)new i(this), 300L);
    com.tencent.mm.plugin.webview.h.a.Tb(5);
  }
  
  public void Q(Bundle paramBundle) {}
  
  public void R(Bundle paramBundle) {}
  
  public void S(Bundle paramBundle) {}
  
  public void T(Bundle paramBundle) {}
  
  public void U(Bundle paramBundle) {}
  
  public void V(Bundle paramBundle) {}
  
  public final void VV()
  {
    this.nhM.VV();
  }
  
  protected final ViewGroup bES()
  {
    return (ViewGroup)this.nhG.a($$delegatedProperties[0]);
  }
  
  public final View bET()
  {
    return (View)this.nhJ.a($$delegatedProperties[2]);
  }
  
  protected final x bEU()
  {
    return (x)this.nhK.a($$delegatedProperties[3]);
  }
  
  protected final String bEV()
  {
    return (String)this.nhS.a($$delegatedProperties[7]);
  }
  
  public final RelativeLayout bEW()
  {
    return (RelativeLayout)this.nhU.a($$delegatedProperties[9]);
  }
  
  protected final int bEX()
  {
    if (this.nhV == 0) {}
    for (int i = ((Number)this.nhR.a($$delegatedProperties[6])).intValue();; i = this.nhV)
    {
      this.nhV = i;
      return this.nhV;
    }
  }
  
  public final MMWebView bEY()
  {
    MMWebView localMMWebView = super.bEY();
    if (localMMWebView != null)
    {
      this.nhH = localMMWebView;
      localMMWebView.a((MMWebView.e)new b(this));
      return localMMWebView;
    }
    return null;
  }
  
  public boolean bEZ()
  {
    return false;
  }
  
  public void bFa()
  {
    super.bFa();
    this.nhN = System.currentTimeMillis();
    com.tencent.mm.sdk.b.a.ESL.c((com.tencent.mm.sdk.b.c)this.nhX);
    MMWebView localMMWebView = this.nhy;
    if (localMMWebView != null) {
      localMMWebView.setOnLongClickListener((View.OnLongClickListener)g.nhZ);
    }
    this.density = getWebView().getMMDensity();
  }
  
  public void bFb() {}
  
  public final boolean bFc()
  {
    return false;
  }
  
  public final void bFd()
  {
    this.nhM.iD(false);
    this.nhL.niP.ea(20, 0);
  }
  
  public final void bFe()
  {
    this.nhM.iD(true);
  }
  
  public final Bundle bFf()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("funcFlag", yr(this.nhL.gGB));
    return localBundle;
  }
  
  public final void bFg() {}
  
  public void bFh() {}
  
  public void bFi() {}
  
  public Bundle bFj()
  {
    return new Bundle();
  }
  
  public final boolean bFk()
  {
    return true;
  }
  
  protected final int getScene()
  {
    return ((Number)this.nhP.a($$delegatedProperties[4])).intValue();
  }
  
  protected final int getSubScene()
  {
    return ((Number)this.nhQ.a($$delegatedProperties[5])).intValue();
  }
  
  protected final MMWebView getWebView()
  {
    return (MMWebView)this.nhI.a($$delegatedProperties[1]);
  }
  
  public void onDestroy()
  {
    bFb();
    super.onDestroy();
    com.tencent.mm.sdk.b.a.ESL.d((com.tencent.mm.sdk.b.c)this.nhX);
  }
  
  public void onPause()
  {
    super.onPause();
    long l = System.currentTimeMillis();
    this.lac += l - this.nhO;
    this.nhO = l;
  }
  
  public void onReset()
  {
    this.nhH = null;
    Object localObject = bET();
    d.g.b.k.g(localObject, "nativePageRootLayout");
    localObject = ((View)localObject).getParent();
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)localObject).removeView(bET());
    localObject = bEW().getParent();
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)localObject).removeView((View)bEW());
    super.onReset();
  }
  
  public void onResume()
  {
    super.onResume();
    this.nhO = System.currentTimeMillis();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void yq(int paramInt) {}
  
  protected final int yr(int paramInt)
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
      ad.i(this.TAG, "convertFuncFlag %d", new Object[] { Integer.valueOf(j) });
      return j;
      j = 0;
      break;
      i = 0;
      break label25;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<ViewGroup>
  {
    a(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "", "scrollY", "<anonymous parameter 2>", "<anonymous parameter 3>", "onWebViewScrollChanged", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$createWebView$1$1"})
  static final class b
    implements MMWebView.e
  {
    b(TmplShareWebViewToolUI paramTmplShareWebViewToolUI) {}
    
    public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(6869);
      this.nhY.yq(paramInt2);
      AppMethodBeat.o(6869);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    c(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AppActiveEvent;", "callback", "", "event", "plugin-brandservice_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.k>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/message/MPMsgInfo;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<x>
  {
    e(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    f(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class g
    implements View.OnLongClickListener
  {
    public static final g nhZ;
    
    static
    {
      AppMethodBeat.i(6874);
      nhZ = new g();
      AppMethodBeat.o(6874);
    }
    
    public final boolean onLongClick(View paramView)
    {
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    h(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(TmplShareWebViewToolUI paramTmplShareWebViewToolUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(6876);
      this.nhY.finish();
      AppMethodBeat.o(6876);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    j(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/RelativeLayout;", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<RelativeLayout>
  {
    k(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    l(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    m(TmplShareWebViewToolUI paramTmplShareWebViewToolUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMWebView;", "invoke"})
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