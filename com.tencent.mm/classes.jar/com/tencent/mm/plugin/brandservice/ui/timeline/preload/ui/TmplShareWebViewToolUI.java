package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.f.b.j;
import a.l;
import a.v;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.q;
import com.tencent.mm.af.s;
import com.tencent.mm.plugin.brandservice.a.b.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.m;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.p;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPWriteCommentLayout;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.e.l;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.d;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.w;
import org.xwalk.core.XWalkEnvironment;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/preload/api/ITmplShareWebView;", "()V", "TAG", "", "_webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "get_webView", "()Lcom/tencent/mm/ui/widget/MMWebView;", "set_webView", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "contentRoot", "Landroid/view/ViewGroup;", "getContentRoot", "()Landroid/view/ViewGroup;", "contentRoot$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "getController", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "setController", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;)V", "density", "", "enterId", "", "getEnterId", "()I", "enterId$delegate", "enterPageTime", "", "getEnterPageTime", "()J", "setEnterPageTime", "(J)V", "mOnForegroundListener", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1;", "minShareContentHeight", "mpMenuHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "getMpMenuHelper", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "setMpMenuHelper", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;)V", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "msgInfo$delegate", "nativePageRootLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getNativePageRootLayout", "()Landroid/view/View;", "nativePageRootLayout$delegate", "originShareContentHeight", "pageStayTime", "getPageStayTime", "setPageStayTime", "publishId", "getPublishId", "()Ljava/lang/String;", "publishId$delegate", "redirectedFullScreenH5", "", "getRedirectedFullScreenH5", "()Z", "setRedirectedFullScreenH5", "(Z)V", "resumePageTime", "getResumePageTime", "setResumePageTime", "scene", "getScene", "scene$delegate", "screenHeight", "getScreenHeight", "setScreenHeight", "(I)V", "screenWidth", "getScreenWidth", "setScreenWidth", "shareLayout", "Landroid/widget/RelativeLayout;", "getShareLayout", "()Landroid/widget/RelativeLayout;", "shareLayout$delegate", "subScene", "getSubScene", "subScene$delegate", "timeLineSessionId", "getTimeLineSessionId", "timeLineSessionId$delegate", "tmplFinished", "webView", "getWebView", "webView$delegate", "writeCommentContainer", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout;", "getWriteCommentContainer", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout;", "writeCommentContainer$delegate", "adWebviewReady", "", "bundle", "Landroid/os/Bundle;", "canTryPreloadNextWebView", "closeAdWebview", "closeComment", "convertFuncFlag", "flag", "createAdWebview", "createWebView", "createWebViewClient", "Lcom/tencent/xweb/WebViewClient;", "destroyReport", "enableMinimize", "fixContentMarginImpl", "getFuncFlag", "getMPVideoState", "getNaitivePageLayoutID", "initCustomActionBarColorIfNeed", "initNewWebViewUIStyleParams", "loadForceUrl", "forceUrl", "fullScreen", "modifyForceUrl", "url", "onDestroy", "onPageReady", "onPause", "onReset", "onResetAfterCreate", "onResume", "onShareLayoutHeightChange", "height", "redirectFullScreenH5", "redirectUrl", "sendMPPageData", "setFuncFlag", "setShareContentHeight", "originHeight", "minHeight", "setShareFuncFlag", "showReaderModeMenu", "showShareMenu", "showToast", "switchVideo", "updateShareContentHeight", "writeComment", "writeWowComment", "plugin-brandservice_release"})
public abstract class TmplShareWebViewToolUI
  extends TmplWebViewToolUI
  implements com.tencent.mm.plugin.webview.preload.a.a
{
  private final String TAG = "MicroMsg.TmplShareWebViewToolUI";
  private float density = 3.0F;
  public int iiW;
  public int iiX;
  protected long iwM;
  public com.tencent.mm.plugin.brandservice.ui.timeline.video.b jXn = new com.tencent.mm.plugin.brandservice.ui.timeline.video.b();
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kcS = m.a(this.keg, (a.f.a.a)new TmplShareWebViewToolUI.a(this));
  MMWebView kcT;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kcU = m.a(this.keg, (a.f.a.a)new TmplShareWebViewToolUI.q(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kcV = m.a(this.keg, (a.f.a.a)new TmplShareWebViewToolUI.g(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kcW = m.a(this.keg, (a.f.a.a)new TmplShareWebViewToolUI.f(this));
  protected i kcX = new i();
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kcY = m.a(this.keg, (a.f.a.a)new TmplShareWebViewToolUI.r(this));
  protected long kcZ;
  protected long kda;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kdb = m.a(this.keg, (a.f.a.a)new TmplShareWebViewToolUI.k(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kdc = m.a(this.keg, (a.f.a.a)new TmplShareWebViewToolUI.m(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kdd = m.a(this.keg, (a.f.a.a)new TmplShareWebViewToolUI.d(this));
  protected final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kde = m.a(this.keg, (a.f.a.a)new TmplShareWebViewToolUI.i(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kdf = m.a(this.keg, (a.f.a.a)new TmplShareWebViewToolUI.n(this));
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kdg = m.a(this.keg, (a.f.a.a)new TmplShareWebViewToolUI.l(this));
  private boolean kdh;
  private int kdi;
  private int kdj;
  private boolean kdk;
  private final e kdl = new e(this);
  
  private final void aYj()
  {
    float f1 = (getWebView().getHeight() - this.kdj) / this.density - am.getStatusBarHeight((Context)getContext());
    float f2 = this.kdi / this.density;
    ab.d(this.TAG, "updateShareContentHeight minHeight:" + f1 + " marginTop:" + f2);
    getWebView().evaluateJavascript("document.body.style.marginTop='" + f2 + "px';document.body.style.minHeight='" + f1 + "px';'set marginTop&minHeight'", (ValueCallback)new o(this));
    getWebView().evaluateJavascript("window.getInnerHeight=function(){return window.innerHeight - " + f2 + " + Math.min(document.body.scrollTop, " + f2 + " + " + f1 + " - window.innerHeight)};getInnerHeight()", (ValueCallback)new p(this));
  }
  
  private MMWebView getWebView()
  {
    return (MMWebView)this.kcU.a(eOJ[1]);
  }
  
  private final int sA(int paramInt)
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
      ab.i(this.TAG, "convertFuncFlag %d", new Object[] { Integer.valueOf(j) });
      return j;
      j = 0;
      break;
      i = 0;
      break label25;
    }
  }
  
  public final void Hg(String paramString)
  {
    j.q(paramString, "redirectUrl");
    if (this.kdh) {
      return;
    }
    this.kdh = true;
    AppCompatActivity localAppCompatActivity = getContext();
    j.p(localAppCompatActivity, "context");
    e.a((Context)localAppCompatActivity, aYe(), paramString);
    al.p((Runnable)new TmplShareWebViewToolUI.j(this), 300L);
    com.tencent.mm.plugin.webview.ui.tools.b.Ko(5);
  }
  
  protected final String Hh(String paramString)
  {
    j.q(paramString, "url");
    return p.I(super.Hh(paramString), "isNativePage", "1");
  }
  
  public final void K(Bundle paramBundle)
  {
    if (paramBundle != null) {
      aYf().setCommentTopicId(paramBundle.getLong("commentTopicId"));
    }
    aYf().fQ(false);
  }
  
  public final void L(Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject3 = aYf();
    if (paramBundle != null)
    {
      localObject1 = paramBundle.getString("status");
      if (!j.e("loading", localObject1)) {
        break label52;
      }
      ((MPWriteCommentLayout)localObject3).Ht(((MPWriteCommentLayout)localObject3).getContext().getString(2131297112));
    }
    label52:
    do
    {
      return;
      localObject1 = null;
      break;
      if (j.e("dismissloading", localObject1))
      {
        ((MPWriteCommentLayout)localObject3).aZM();
        return;
      }
    } while (!j.e("success", localObject1));
    localObject3 = ((MPWriteCommentLayout)localObject3).getContext();
    Object localObject1 = localObject2;
    if (paramBundle != null) {
      localObject1 = paramBundle.getString("wording");
    }
    t.bP((Context)localObject3, (String)localObject1);
  }
  
  public void M(Bundle paramBundle)
  {
    Object localObject1 = new s();
    ((s)localObject1).r(paramBundle);
    ((s)localObject1).t(getIntent());
    paramBundle = ((s)localObject1).fjD.url;
    j.p(paramBundle, "msgInfo.item.url");
    paramBundle = p.I(p.I(paramBundle, "isNativePage", "1"), "enterid", String.valueOf(getEnterId()));
    localObject1 = new b.a();
    Object localObject2 = getContext();
    j.p(localObject2, "context");
    localObject2 = (Context)localObject2;
    int i = getIntent().getIntExtra(e.l.yVt, -1);
    int j = getIntent().getIntExtra(e.l.yVp, -1);
    int k = getIntent().getIntExtra(e.l.yVq, -1);
    Intent localIntent = getIntent();
    j.p(localIntent, "intent");
    PreloadLogic.a((Context)localObject2, paramBundle, i, true, j, k, localIntent, -1, (b.a)localObject1, false);
    onReset();
  }
  
  public boolean N(Bundle paramBundle)
  {
    return false;
  }
  
  public void O(Bundle paramBundle) {}
  
  protected final void aJe()
  {
    ab.d(this.TAG, "onPageReady set shareContentHeight");
    this.kdk = true;
    super.aJe();
    if (this.kdi > 0) {
      aYj();
    }
  }
  
  protected final ViewGroup aYc()
  {
    return (ViewGroup)this.kcS.a(eOJ[0]);
  }
  
  public final View aYd()
  {
    return (View)this.kcV.a(eOJ[2]);
  }
  
  public final s aYe()
  {
    return (s)this.kcW.a(eOJ[3]);
  }
  
  protected final MPWriteCommentLayout aYf()
  {
    return (MPWriteCommentLayout)this.kcY.a(eOJ[4]);
  }
  
  public final RelativeLayout aYg()
  {
    return (RelativeLayout)this.kdg.a(eOJ[10]);
  }
  
  public final MMWebView aYh()
  {
    MMWebView localMMWebView = super.aYh();
    if (localMMWebView != null)
    {
      localMMWebView.getWebViewUI().setBackgroundColor(0);
      this.kcT = localMMWebView;
      localMMWebView.a((MMWebView.d)new TmplShareWebViewToolUI.b(this));
      return localMMWebView;
    }
    return null;
  }
  
  public final boolean aYi()
  {
    return false;
  }
  
  public final w aYk()
  {
    if (!aYK().aYa()) {
      return (w)new TmplShareWebViewToolUI.c(this);
    }
    return super.aYk();
  }
  
  protected final boolean aYl()
  {
    return false;
  }
  
  public void aYm()
  {
    super.aYm();
    this.kcZ = System.currentTimeMillis();
    com.tencent.mm.sdk.b.a.ymk.c((c)this.kdl);
    Object localObject = this.pOd;
    if (localObject != null) {
      ((MMWebView)localObject).setOnLongClickListener((View.OnLongClickListener)TmplShareWebViewToolUI.h.kdn);
    }
    this.density = com.tencent.mm.cc.a.dqZ();
    if ((getWebView().getWebCoreType() == WebView.d.BEq) && (XWalkEnvironment.getUsingCustomContext()))
    {
      localObject = getWebView().getResources();
      j.p(localObject, "webView.resources");
      this.density = ((Resources)localObject).getDisplayMetrics().density;
    }
  }
  
  public void aYn() {}
  
  public final void aYo()
  {
    this.kcX.fS(false);
  }
  
  public final void aYp()
  {
    this.kcX.fS(true);
  }
  
  public final void aYq()
  {
    aYf().fQ(true);
  }
  
  public final void aYr()
  {
    MPWriteCommentLayout localMPWriteCommentLayout = aYf();
    localMPWriteCommentLayout.hide();
    localMPWriteCommentLayout.khg.setText((CharSequence)"");
  }
  
  public final Bundle aYs()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("funcFlag", sA(this.jXn.fgk));
    return localBundle;
  }
  
  public final void aYt() {}
  
  public void aYu() {}
  
  public void aYv() {}
  
  public Bundle aYw()
  {
    return new Bundle();
  }
  
  public final void aYx() {}
  
  public final void aYy() {}
  
  public final void aYz() {}
  
  protected final void aw(String paramString, boolean paramBoolean)
  {
    j.q(paramString, "forceUrl");
    ab.d(this.TAG, "loadForceUrl ".concat(String.valueOf(paramString)));
    if (paramBoolean)
    {
      Hg(p.dk(paramString, "isNativePage"));
      return;
    }
    super.aw(paramString, paramBoolean);
  }
  
  public final void dL(int paramInt1, int paramInt2)
  {
    this.kdi = paramInt1;
    this.kdj = paramInt2;
    if (this.kdk) {
      aYj();
    }
  }
  
  protected final int getEnterId()
  {
    return ((Number)this.kdd.a(eOJ[7])).intValue();
  }
  
  protected final int getScene()
  {
    return ((Number)this.kdb.a(eOJ[5])).intValue();
  }
  
  protected final int getSubScene()
  {
    return ((Number)this.kdc.a(eOJ[6])).intValue();
  }
  
  protected final int getTimeLineSessionId()
  {
    return ((Number)this.kdf.a(eOJ[9])).intValue();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    aYn();
    com.tencent.mm.sdk.b.a.ymk.d((c)this.kdl);
  }
  
  public void onPause()
  {
    super.onPause();
    long l = System.currentTimeMillis();
    this.iwM += l - this.kda;
    this.kda = l;
  }
  
  public void onReset()
  {
    this.kcT = null;
    Object localObject = aYd();
    j.p(localObject, "nativePageRootLayout");
    localObject = ((View)localObject).getParent();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)localObject).removeView(aYd());
    localObject = aYg().getParent();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.view.ViewGroup");
    }
    ((ViewGroup)localObject).removeView((View)aYg());
    super.onReset();
  }
  
  public void onResume()
  {
    super.onResume();
    this.kda = System.currentTimeMillis();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void sy(int paramInt) {}
  
  protected final void sz(int paramInt)
  {
    Object localObject2 = this.jXn;
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject2).fgk = paramInt;
    if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject2).aZg())
    {
      localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject2).jXm;
      if (localObject1 == null) {
        j.ays("msgInfo");
      }
      localObject2 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject2).jXm;
      if (localObject2 == null) {
        j.ays("msgInfo");
      }
      ((s)localObject2).fgk |= 0x1;
    }
    Object localObject1 = this.kcX;
    if (((i)localObject1).kiI) {
      ((i)localObject1).fS(((i)localObject1).kiH);
    }
    localObject1 = this.uQS;
    if (localObject1 != null) {
      ((d)localObject1).dU("setFuncFlag", sA(paramInt));
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AppActiveEvent;", "callback", "", "event", "plugin-brandservice_release"})
  public static final class e
    extends c<com.tencent.mm.g.a.k>
  {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
  static final class o<T>
    implements ValueCallback<String>
  {
    o(TmplShareWebViewToolUI paramTmplShareWebViewToolUI) {}
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
  static final class p<T>
    implements ValueCallback<String>
  {
    p(TmplShareWebViewToolUI paramTmplShareWebViewToolUI) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI
 * JD-Core Version:    0.7.0.1
 */