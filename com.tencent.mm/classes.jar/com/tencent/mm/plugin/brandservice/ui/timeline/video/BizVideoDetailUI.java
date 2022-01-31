package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings.RenderPriority;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.s;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.m;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.d.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.b;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoWrapper;
import com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.protocal.protobuf.el;
import com.tencent.mm.protocal.protobuf.ev;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.e.b;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import java.util.LinkedList;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "()V", "TAG", "", "adView", "Landroid/widget/FrameLayout;", "getAdView", "()Landroid/widget/FrameLayout;", "adView$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "adWebView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "getAdWebView", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "setAdWebView", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;)V", "adWebViewReady", "", "getAdWebViewReady", "()Z", "setAdWebViewReady", "(Z)V", "animationDone", "getAnimationDone", "setAnimationDone", "animationHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoImageAnimationHelper;", "animationIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAnimationIv", "()Landroid/widget/ImageView;", "animationIv$delegate", "animationLayout", "Landroid/view/View;", "getAnimationLayout", "()Landroid/view/View;", "animationLayout$delegate", "animationMaskView", "getAnimationMaskView", "animationMaskView$delegate", "appmsgDone", "getAppmsgDone", "setAppmsgDone", "backgroundContainerView", "getBackgroundContainerView", "backgroundContainerView$delegate", "cgiCallback", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "fullscreenImpl", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenImpl;", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "h5LoadingLayout", "getH5LoadingLayout", "h5LoadingLayout$delegate", "isInFullScreen", "maxVideoHeight", "", "getMaxVideoHeight", "()I", "setMaxVideoHeight", "(I)V", "minVideoHeight", "getMinVideoHeight", "setMinVideoHeight", "needShowWifiTipsView", "getNeedShowWifiTipsView", "setNeedShowWifiTipsView", "needToDoHeightAnimation", "getNeedToDoHeightAnimation", "setNeedToDoHeightAnimation", "networkListener", "Landroid/content/BroadcastReceiver;", "orientationHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper;", "playState", "getPlayState", "()Ljava/lang/String;", "setPlayState", "(Ljava/lang/String;)V", "setFullScreen", "showWifiTipsMode", "simcardTpye", "switchVideo", "getSwitchVideo", "setSwitchVideo", "videoAdTitleBack", "getVideoAdTitleBack", "videoAdTitleBack$delegate", "videoAdTitleBar", "Landroid/widget/LinearLayout;", "getVideoAdTitleBar", "()Landroid/widget/LinearLayout;", "videoAdTitleBar$delegate", "videoErrView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "getVideoErrView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "videoErrView$delegate", "videoHeight", "getVideoHeight", "setVideoHeight", "videoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoView", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "videoView$delegate", "videoViewContainer", "getVideoViewContainer", "videoViewContainer$delegate", "videoWifiTipsView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "getVideoWifiTipsView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "videoWifiTipsView$delegate", "adWebviewReady", "", "bundle", "Landroid/os/Bundle;", "checkInitOrientationHelper", "w", "h", "closeAdWebview", "createAdWebview", "destroyReport", "destroyWebView", "doPlayVideo", "urlInfo", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "autoPlay", "doVideoHeightAnimation", "enableOrientationListener", "enable", "finish", "getForceOrientation", "getFullscreenImpl", "getMPVideoState", "getSimecardType", "goneVideoErrorView", "hideVideoTitleBar", "hideWifiTipsView", "init", "initActionBar", "initCommentContainer", "initOrientationHelper", "initVideoBaseParam", "initVideoParam", "initVideoView", "keyDownGoBack", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAppMsgGet", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;", "onBackPressed", "onDestroy", "onMPVideoStateChange", "state", "errMsg", "onPageFinished", "view", "Lcom/tencent/xweb/WebView;", "url", "onPause", "onRefreshMaskClick", "onReset", "onResetAfterCreate", "onResetBeforeCreate", "onResume", "onShareLayoutHeightChange", "height", "onShowAd", "onStart", "postBinded", "sendMPPageData", "setTouchListener", "shouldInterceptLoadError", "errorCode", "description", "failingUrl", "shouldShowWifiTips", "duration", "showRefreshMask", "showVideoErrorView", "showWifiTipsView", "netChange", "startMonitorNetWorkChange", "stopMonitorNetWorkChange", "updateAdHeight", "plugin-brandservice_release"})
@com.tencent.mm.ui.base.a(6)
public class BizVideoDetailUI
  extends TmplShareWebViewToolUI
{
  private final String TAG;
  private int aXT;
  private final b.a hnw;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kfI;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kfJ;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kfK;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kfL;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kfM;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kfN;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kfO;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kfP;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kfQ;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kfR;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kfS;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kfT;
  private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.d kfU;
  private int kfV;
  private int kfW;
  MMWebViewWithJsApi kfX;
  private boolean kfY;
  boolean kfZ;
  private boolean kfj;
  private com.tencent.mm.plugin.brandservice.ui.widget.a kfk;
  private h kfl;
  private com.tencent.mm.plugin.brandservice.ui.widget.b kfm;
  boolean kga;
  boolean kgb;
  private boolean kgc;
  private String kgd;
  boolean kge;
  private boolean kgf;
  private BroadcastReceiver kgg;
  private boolean kgh;
  int videoHeight;
  
  static
  {
    AppMethodBeat.i(15179);
    eOJ = new a.j.k[] { (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(BizVideoDetailUI.class), "animationIv", "getAnimationIv()Landroid/widget/ImageView;")), (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(BizVideoDetailUI.class), "animationMaskView", "getAnimationMaskView()Landroid/view/View;")), (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(BizVideoDetailUI.class), "animationLayout", "getAnimationLayout()Landroid/view/View;")), (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(BizVideoDetailUI.class), "h5LoadingLayout", "getH5LoadingLayout()Landroid/view/View;")), (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(BizVideoDetailUI.class), "videoView", "getVideoView()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;")), (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(BizVideoDetailUI.class), "adView", "getAdView()Landroid/widget/FrameLayout;")), (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(BizVideoDetailUI.class), "backgroundContainerView", "getBackgroundContainerView()Landroid/widget/FrameLayout;")), (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(BizVideoDetailUI.class), "videoErrView", "getVideoErrView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;")), (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(BizVideoDetailUI.class), "videoWifiTipsView", "getVideoWifiTipsView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;")), (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(BizVideoDetailUI.class), "videoAdTitleBar", "getVideoAdTitleBar()Landroid/widget/LinearLayout;")), (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(BizVideoDetailUI.class), "videoAdTitleBack", "getVideoAdTitleBack()Landroid/view/View;")), (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(BizVideoDetailUI.class), "videoViewContainer", "getVideoViewContainer()Landroid/widget/FrameLayout;")) };
    AppMethodBeat.o(15179);
  }
  
  public BizVideoDetailUI()
  {
    AppMethodBeat.i(15211);
    this.TAG = "MicroMsg.BizVideoDetailUI";
    this.kfI = m.a(this.keg, (a.f.a.a)new BizVideoDetailUI.b(this));
    this.kfJ = m.a(this.keg, (a.f.a.a)new BizVideoDetailUI.d(this));
    this.kfK = m.a(this.keg, (a.f.a.a)new BizVideoDetailUI.c(this));
    this.kfL = m.a(this.keg, (a.f.a.a)new BizVideoDetailUI.l(this));
    this.kfM = m.a(this.keg, (a.f.a.a)new BizVideoDetailUI.ac(this));
    this.kfN = m.a(this.keg, (a.f.a.a)new BizVideoDetailUI.a(this));
    this.kfO = m.a(this.keg, (a.f.a.a)new BizVideoDetailUI.e(this));
    this.kfP = m.a(this.keg, (a.f.a.a)new BizVideoDetailUI.ab(this));
    this.kfQ = m.a(this.keg, (a.f.a.a)new BizVideoDetailUI.ae(this));
    this.kfR = m.a(this.keg, (a.f.a.a)new BizVideoDetailUI.aa(this));
    this.kfS = m.a(this.keg, (a.f.a.a)new BizVideoDetailUI.z(this));
    this.kfT = m.a(this.keg, (a.f.a.a)new BizVideoDetailUI.ad(this));
    this.kfl = new h();
    this.kgd = "";
    this.kfm = ((com.tencent.mm.plugin.brandservice.ui.widget.b)new BizVideoDetailUI.k(this));
    this.hnw = ((b.a)new BizVideoDetailUI.f(this));
    AppMethodBeat.o(15211);
  }
  
  private static void T(View paramView, int paramInt)
  {
    AppMethodBeat.i(15198);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null)
    {
      paramView = new a.v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(15198);
      throw paramView;
    }
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(15198);
  }
  
  private final void aZA()
  {
    AppMethodBeat.i(15208);
    MPVideoErrorView localMPVideoErrorView = aZn();
    j.p(localMPVideoErrorView, "videoErrView");
    localMPVideoErrorView.setVisibility(0);
    fN(false);
    this.kfl.aZR();
    AppMethodBeat.o(15208);
  }
  
  private final void aZB()
  {
    AppMethodBeat.i(152861);
    MPVideoWifiTipsView localMPVideoWifiTipsView = aZo();
    j.p(localMPVideoWifiTipsView, "videoWifiTipsView");
    localMPVideoWifiTipsView.setVisibility(8);
    aZC();
    AppMethodBeat.o(152861);
  }
  
  private final void aZC()
  {
    AppMethodBeat.i(152862);
    Object localObject = aZl();
    if (localObject != null)
    {
      if (((FrameLayout)localObject).getVisibility() == 8)
      {
        localObject = aZo();
        j.p(localObject, "videoWifiTipsView");
        if (((MPVideoWifiTipsView)localObject).getVisibility() == 8)
        {
          localObject = aZp();
          j.p(localObject, "videoAdTitleBar");
          ((LinearLayout)localObject).setVisibility(8);
        }
      }
      AppMethodBeat.o(152862);
      return;
    }
    AppMethodBeat.o(152862);
  }
  
  private final View aZc()
  {
    AppMethodBeat.i(15191);
    View localView = (View)this.kfK.a(eOJ[2]);
    AppMethodBeat.o(15191);
    return localView;
  }
  
  private final ImageView aZh()
  {
    AppMethodBeat.i(15190);
    ImageView localImageView = (ImageView)this.kfI.a(eOJ[0]);
    AppMethodBeat.o(15190);
    return localImageView;
  }
  
  private final View aZi()
  {
    AppMethodBeat.i(15180);
    View localView = (View)this.kfJ.a(eOJ[1]);
    AppMethodBeat.o(15180);
    return localView;
  }
  
  private final View aZj()
  {
    AppMethodBeat.i(152844);
    View localView = (View)this.kfL.a(eOJ[3]);
    AppMethodBeat.o(152844);
    return localView;
  }
  
  private final MPVideoView aZk()
  {
    AppMethodBeat.i(15181);
    MPVideoView localMPVideoView = (MPVideoView)this.kfM.a(eOJ[4]);
    AppMethodBeat.o(15181);
    return localMPVideoView;
  }
  
  private final FrameLayout aZl()
  {
    AppMethodBeat.i(15186);
    FrameLayout localFrameLayout = (FrameLayout)this.kfN.a(eOJ[5]);
    AppMethodBeat.o(15186);
    return localFrameLayout;
  }
  
  private final FrameLayout aZm()
  {
    AppMethodBeat.i(155385);
    FrameLayout localFrameLayout = (FrameLayout)this.kfO.a(eOJ[6]);
    AppMethodBeat.o(155385);
    return localFrameLayout;
  }
  
  private final MPVideoErrorView aZn()
  {
    AppMethodBeat.i(15182);
    MPVideoErrorView localMPVideoErrorView = (MPVideoErrorView)this.kfP.a(eOJ[7]);
    AppMethodBeat.o(15182);
    return localMPVideoErrorView;
  }
  
  private final MPVideoWifiTipsView aZo()
  {
    AppMethodBeat.i(152845);
    MPVideoWifiTipsView localMPVideoWifiTipsView = (MPVideoWifiTipsView)this.kfQ.a(eOJ[8]);
    AppMethodBeat.o(152845);
    return localMPVideoWifiTipsView;
  }
  
  private final LinearLayout aZp()
  {
    AppMethodBeat.i(152846);
    LinearLayout localLinearLayout = (LinearLayout)this.kfR.a(eOJ[9]);
    AppMethodBeat.o(152846);
    return localLinearLayout;
  }
  
  private final FrameLayout aZq()
  {
    AppMethodBeat.i(15183);
    FrameLayout localFrameLayout = (FrameLayout)this.kfT.a(eOJ[11]);
    AppMethodBeat.o(15183);
    return localFrameLayout;
  }
  
  private final int aZs()
  {
    AppMethodBeat.i(152851);
    if (this.igU == null)
    {
      i = this.kfV;
      AppMethodBeat.o(152851);
      return i;
    }
    Bundle localBundle = this.igU.i(110, new Bundle());
    if (localBundle != null) {
      this.kfV = localBundle.getInt("sim_card_type", 0);
    }
    int i = this.kfV;
    AppMethodBeat.o(152851);
    return i;
  }
  
  private final void aZt()
  {
    AppMethodBeat.i(15195);
    this.iiW = com.tencent.mm.cb.a.gw((Context)getContext());
    this.iiX = com.tencent.mm.cb.a.gx((Context)getContext());
    this.aXT = ((int)(0.65D * this.iiX));
    this.kfW = (this.iiW * 9 / 16);
    this.aXT = Math.max(this.aXT, this.kfW);
    this.videoHeight = this.kfW;
    aYf().setMinHeaderHeight(this.kfW);
    AppMethodBeat.o(15195);
  }
  
  private final void aZu()
  {
    AppMethodBeat.i(15196);
    if ((aYe().fjD.videoWidth > 0) && (aYe().fjD.videoHeight > 0))
    {
      i = this.iiW * aYe().fjD.videoHeight / aYe().fjD.videoWidth;
      if (i > this.aXT)
      {
        this.videoHeight = this.aXT;
        dM(aYe().fjD.videoWidth, aYe().fjD.videoHeight);
      }
    }
    else
    {
      if ((aYe().fjD.videoWidth <= 0) || (aYe().fjD.videoHeight <= 0)) {
        break label301;
      }
    }
    label301:
    for (int i = this.videoHeight;; i = this.kfW)
    {
      this.aXT = i;
      if (this.aXT - this.kfW < 10) {
        this.kfW = this.aXT;
      }
      h localh = this.kfl;
      Intent localIntent = getIntent();
      j.p(localIntent, "intent");
      Object localObject = getContext();
      j.p(localObject, "context");
      localObject = (Context)localObject;
      View localView = aZc();
      j.p(localView, "animationLayout");
      localh.a(localIntent, (Context)localObject, localView, aZi());
      aZk().a(aZh(), aYe().fjD.fjJ, this.iiW, this.videoHeight, aYe());
      dL(this.videoHeight, this.kfW);
      AppMethodBeat.o(15196);
      return;
      if (i < this.kfW)
      {
        this.videoHeight = this.kfW;
        break;
      }
      this.videoHeight = i;
      break;
    }
  }
  
  private final void aZw()
  {
    AppMethodBeat.i(15200);
    if (this.kfU != null)
    {
      AppMethodBeat.o(15200);
      return;
    }
    AppCompatActivity localAppCompatActivity = getContext();
    j.p(localAppCompatActivity, "context");
    this.kfU = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.d((Context)localAppCompatActivity, aZk());
    AppMethodBeat.o(15200);
  }
  
  private void aZx()
  {
    AppMethodBeat.i(152858);
    if (this.kfX == null)
    {
      AppMethodBeat.o(152858);
      return;
    }
    Object localObject = this.uQS;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject).aiV("disappear");
    }
    localObject = this.uQS;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject).aiV("destroy");
    }
    localObject = aZl();
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = aZl();
    if (localObject != null) {
      ((FrameLayout)localObject).removeView((View)this.kfX);
    }
    localObject = this.kfX;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getCurWebviewClient();
      if (!(localObject instanceof com.tencent.mm.plugin.webview.ui.tools.widget.k)) {
        break label162;
      }
      localObject = this.kfX;
      if (localObject == null) {
        break label150;
      }
    }
    label150:
    for (localObject = ((MMWebViewWithJsApi)localObject).getCurWebviewClient();; localObject = null)
    {
      if (localObject != null) {
        break label155;
      }
      localObject = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewClient");
      AppMethodBeat.o(152858);
      throw ((Throwable)localObject);
      localObject = null;
      break;
    }
    label155:
    ((com.tencent.mm.plugin.webview.ui.tools.widget.k)localObject).cleanup();
    label162:
    localObject = this.kfX;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).destroy();
    }
    localObject = this.kfX;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebChromeClient(null);
    }
    localObject = this.kfX;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebViewClient(null);
    }
    localObject = this.kfX;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnTouchListener(null);
    }
    localObject = this.kfX;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnLongClickListener(null);
    }
    localObject = this.kfX;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setVisibility(8);
    }
    localObject = this.kfX;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).removeAllViews();
    }
    localObject = this.kfX;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).clearView();
    }
    this.kfX = null;
    this.kfY = false;
    aZC();
    showOptionMenu(true);
    AppMethodBeat.o(152858);
  }
  
  private final void aZz()
  {
    AppMethodBeat.i(15207);
    MPVideoErrorView localMPVideoErrorView = aZn();
    j.p(localMPVideoErrorView, "videoErrView");
    localMPVideoErrorView.setVisibility(8);
    fN(true);
    AppMethodBeat.o(15207);
  }
  
  private final void dM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152853);
    if (paramInt1 > paramInt2)
    {
      aZw();
      locald = this.kfU;
      if (locald != null)
      {
        locald.fR(true);
        AppMethodBeat.o(152853);
        return;
      }
      AppMethodBeat.o(152853);
      return;
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.d locald = this.kfU;
    if (locald != null)
    {
      locald.fR(false);
      AppMethodBeat.o(152853);
      return;
    }
    AppMethodBeat.o(152853);
  }
  
  private final void fO(boolean paramBoolean)
  {
    AppMethodBeat.i(152860);
    com.tencent.mm.plugin.webview.ui.tools.b.Ko(16);
    this.jXn.kfB.dN(14, 0);
    aZk().a(aZo().getCoverIv(), aYe().fjD.fjJ, this.iiW, this.videoHeight, aYe());
    MPVideoWifiTipsView localMPVideoWifiTipsView = aZo();
    j.p(localMPVideoWifiTipsView, "videoWifiTipsView");
    localMPVideoWifiTipsView.setVisibility(0);
    aZo().n(this.jXn.kfu, paramBoolean);
    aZo().setStillPlayingOnClickListener((View.OnClickListener)new BizVideoDetailUI.y(this));
    AppMethodBeat.o(152860);
  }
  
  private final boolean sH(int paramInt)
  {
    AppMethodBeat.i(152868);
    if ((com.tencent.mm.sdk.platformtools.f.DEBUG) && (this.kgh))
    {
      AppMethodBeat.o(152868);
      return true;
    }
    if (aZk().getPlayStatus() == 4)
    {
      ab.i(this.TAG, "not show WifiTips, play end!");
      AppMethodBeat.o(152868);
      return false;
    }
    if ((paramInt > 0) && (aZk().getCacheTimeSec() >= paramInt))
    {
      ab.i(this.TAG, "not show WifiTips, video cached! " + aZk().getCacheTimeSec() + '/' + aZk().getDuration());
      AppMethodBeat.o(152868);
      return false;
    }
    if (this.jXn.kfz == 1)
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e locale = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e.kif;
      if (!com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e.o(at.isWifi((Context)getContext()), this.kfV))
      {
        AppMethodBeat.o(152868);
        return true;
      }
    }
    AppMethodBeat.o(152868);
    return false;
  }
  
  public final void Hr(String paramString)
  {
    AppMethodBeat.i(156725);
    j.q(paramString, "url");
    if (this.kew)
    {
      super.aw(paramString, false);
      AppMethodBeat.o(156725);
      return;
    }
    super.Hr(paramString);
    AppMethodBeat.o(156725);
  }
  
  public final void M(Bundle paramBundle)
  {
    AppMethodBeat.i(152854);
    this.kfl.kis = false;
    if (this.kfj) {
      aZk().l(false, 0);
    }
    aZx();
    super.M(paramBundle);
    this.kfl.kit = false;
    this.kfl.aZS();
    com.tencent.mm.plugin.webview.ui.tools.b.Ko(18);
    this.kga = true;
    paramBundle = aZj();
    j.p(paramBundle, "h5LoadingLayout");
    paramBundle.setVisibility(0);
    aZj().setPadding(0, this.videoHeight, 0, 0);
    AppMethodBeat.o(152854);
  }
  
  public final boolean N(Bundle paramBundle)
  {
    AppMethodBeat.i(152863);
    if ((paramBundle == null) || (!paramBundle.containsKey("adUrl")))
    {
      ab.w(this.TAG, "createAdWebview url not found");
      AppMethodBeat.o(152863);
      return false;
    }
    if (this.kfX != null)
    {
      ab.w(this.TAG, "createAdWebview adWebView existed!");
      AppMethodBeat.o(152863);
      return false;
    }
    com.tencent.mm.plugin.webview.ui.tools.b.Ko(28);
    paramBundle = paramBundle.getString("adUrl");
    ab.i(this.TAG, "createAdWebview adWebView url=".concat(String.valueOf(paramBundle)));
    this.kfY = false;
    Object localObject = a.keW;
    localObject = MMWebViewWithJsApi.a.fC((Context)getContext());
    j.p(localObject, "MMWebViewWithJsApi.Factory.create(this.context)");
    String str = (String)this.kde.a(TmplShareWebViewToolUI.eOJ[8]);
    j.p(str, "publishId");
    this.kfX = a.a((MMWebViewWithJsApi)localObject, str, (a.f.a.b)BizVideoDetailUI.g.kgj, (a.f.a.b)new BizVideoDetailUI.h(this), aio(aYe().HD()));
    localObject = this.kfX;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setCleanOnDetached(false);
    }
    localObject = this.kfX;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getSettings();
      if (localObject != null) {
        ((com.tencent.xweb.t)localObject).dYw();
      }
    }
    localObject = this.kfX;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getSettings();
      if (localObject != null) {
        ((com.tencent.xweb.t)localObject).setDatabasePath(com.tencent.mm.compatible.util.e.eQu + "databases/");
      }
    }
    localObject = this.kfX;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getSettings();
      if (localObject != null) {
        ((com.tencent.xweb.t)localObject).dYz();
      }
    }
    localObject = this.kfX;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getSettings();
      if (localObject != null) {
        ((com.tencent.xweb.t)localObject).dYx();
      }
    }
    localObject = this.kfX;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getSettings();
      if (localObject != null) {
        ((com.tencent.xweb.t)localObject).dYv();
      }
    }
    localObject = this.kfX;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getSettings();
      if (localObject != null) {
        ((com.tencent.xweb.t)localObject).dYu();
      }
    }
    localObject = this.kfX;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnLongClickListener((View.OnLongClickListener)BizVideoDetailUI.i.kgk);
    }
    localObject = this.kfX;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).loadUrl(paramBundle);
    }
    paramBundle = aZl();
    if (paramBundle != null) {
      paramBundle.removeAllViews();
    }
    paramBundle = aZm();
    if (paramBundle != null) {
      paramBundle.addView((View)this.kfX);
    }
    paramBundle = this.kfX;
    if (paramBundle != null) {
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(152863);
    return true;
  }
  
  public final void O(Bundle paramBundle)
  {
    AppMethodBeat.i(152867);
    if ((paramBundle == null) || (!paramBundle.containsKey("data")))
    {
      AppMethodBeat.o(152867);
      return;
    }
    String str = paramBundle.getString("data", "");
    paramBundle = paramBundle.getString("sendTo", "adWeb");
    ab.i(this.TAG, "sendMPPageData %s", new Object[] { paramBundle });
    if (j.e("adWeb", paramBundle))
    {
      if (this.kfX == null)
      {
        AppMethodBeat.o(152867);
        return;
      }
      paramBundle = this.kfX;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getJsapi();
        if (paramBundle != null)
        {
          paramBundle.aiU(str);
          AppMethodBeat.o(152867);
          return;
        }
      }
      AppMethodBeat.o(152867);
      return;
    }
    paramBundle = this.uQS;
    if (paramBundle != null)
    {
      paramBundle.aiU(str);
      AppMethodBeat.o(152867);
      return;
    }
    AppMethodBeat.o(152867);
  }
  
  public final void a(el paramel)
  {
    int i = 0;
    AppMethodBeat.i(15206);
    if (paramel == null)
    {
      AppMethodBeat.o(15206);
      return;
    }
    sz(paramel.wqB);
    if ((paramel.wqF != null) && (this.jXn.aZg())) {
      this.jXn.kfA = paramel.wqF;
    }
    this.jXn.fgl = paramel.fgl;
    Object localObject = paramel.wqE;
    if (localObject != null) {
      this.jXn.kfq = ((String)localObject);
    }
    this.jXn.Hq(paramel.url);
    localObject = paramel.url;
    if (localObject != null) {
      aYf().setUrl((String)localObject);
    }
    if ((paramel.wqD != null) && (paramel.wqD.cxa != 0))
    {
      ab.i(this.TAG, "play_error_info msg:" + paramel.wqD.cxb + " errCode:" + paramel.wqD.cxa);
      aZn().setPlayError$505cff1c(paramel.wqD.cxb);
      aZA();
      com.tencent.mm.plugin.webview.ui.tools.b.Ko(32);
      AppMethodBeat.o(15206);
      return;
    }
    aZz();
    if (bo.es((List)paramel.wqw))
    {
      ab.w(this.TAG, "url_info is null");
      this.kfl.aZR();
      com.tencent.mm.plugin.webview.ui.tools.b.Ko(4);
      AppMethodBeat.o(15206);
      return;
    }
    com.tencent.mm.plugin.webview.ui.tools.b.Ko(23);
    localObject = (ev)paramel.wqw.get(0);
    this.jXn.kfu = ((ev)localObject).kfu;
    boolean bool;
    label426:
    String str;
    int j;
    if ((paramel.wqA & 0x1) != 0)
    {
      bool = true;
      aZk().setInitialTime(com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e.Hu(aYe().HD() + "_" + paramel.fgl));
      j.p(localObject, "urlInfo");
      this.kfZ = false;
      this.jXn.kfz = ((ev)localObject).wra;
      ab.i(this.TAG, "doPlayVideo overSize=" + this.jXn.kfz);
      if (!sH(((ev)localObject).wqY / 1000)) {
        break label695;
      }
      if (this.kgf) {
        fO(false);
      }
      bool = false;
      aZk().setAutoPlay(bool);
      if (!bool) {
        this.kfl.aZP();
      }
      this.jXn.kfB.width = ((ev)localObject).width;
      this.jXn.kfB.height = ((ev)localObject).height;
      paramel = aZk();
      str = ((ev)localObject).url;
      j.p(str, "urlInfo.url");
      j = ((ev)localObject).wqY / 1000;
      j.q(str, "videoPath");
      ab.i(MPVideoView.TAG, "setVideoPath path=%s isLive=%s", new Object[] { str, Boolean.FALSE });
      if (!bo.isNullOrNil(str)) {
        break label702;
      }
      ab.v(MPVideoView.TAG, "setVideoPath videoPath empty");
    }
    for (;;)
    {
      paramel = aZk();
      if (((ev)localObject).width > ((ev)localObject).height) {
        i = 90;
      }
      paramel.setFullScreenDirection(i);
      dM(((ev)localObject).width, ((ev)localObject).height);
      if ((((ev)localObject).width <= 0) || (((ev)localObject).height <= 0) || (aYe().fjD.videoWidth > 0) || (aYe().fjD.videoHeight > 0)) {
        break label842;
      }
      aYe().fjD.videoWidth = ((ev)localObject).width;
      aYe().fjD.videoHeight = ((ev)localObject).height;
      if (!this.kfl.kit) {
        break label837;
      }
      aZv();
      AppMethodBeat.o(15206);
      return;
      bool = false;
      break;
      label695:
      aZB();
      break label426;
      label702:
      paramel.videoPath = str;
      paramel.stop();
      paramel.icJ = false;
      MPVideoWrapper localMPVideoWrapper = paramel.kjD;
      if (localMPVideoWrapper == null) {
        j.ebi();
      }
      localMPVideoWrapper.setVideoSource(paramel.icR);
      localMPVideoWrapper = paramel.kjD;
      if (localMPVideoWrapper == null) {
        j.ebi();
      }
      localMPVideoWrapper.c(false, str, j);
      if (paramel.icL > 0.0D)
      {
        localMPVideoWrapper = paramel.kjD;
        if (localMPVideoWrapper == null) {
          j.ebi();
        }
        localMPVideoWrapper.d(paramel.icL, paramel.mAutoPlay);
      }
      if (paramel.mAutoPlay)
      {
        ab.i(MPVideoView.TAG, "setVideoPath autoPlay");
        paramel.start();
      }
      paramel.setCover(str);
      paramel.setMute(paramel.mIsMute);
    }
    label837:
    this.kge = true;
    label842:
    AppMethodBeat.o(15206);
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(154592);
    j.q(paramWebView, "view");
    j.q(paramString1, "description");
    j.q(paramString2, "failingUrl");
    aZr();
    AppMethodBeat.o(154592);
    return true;
  }
  
  public final void aMf()
  {
    AppMethodBeat.i(152849);
    super.aMf();
    if (this.igU != null)
    {
      this.jXn.kfB.kil = this.igU.nT(aYe().HD());
      this.jXn.kfB.dN(1, 0);
    }
    this.jXn.kfy = aZs();
    this.kgb = false;
    this.jXn.aZe();
    AppMethodBeat.o(152849);
  }
  
  public final void aYO()
  {
    AppMethodBeat.i(152847);
    super.aYO();
    if (!this.kgc)
    {
      this.kgc = true;
      com.tencent.mm.pluginsdk.f.m((MMActivity)this);
      com.tencent.mm.plugin.webview.ui.tools.b.Ko(0);
    }
    getIntent().putExtra("vertical_scroll", false);
    this.vfw = true;
    this.vfx = true;
    AppMethodBeat.o(152847);
  }
  
  public final void aYm()
  {
    AppMethodBeat.i(152848);
    super.aYm();
    if (aYe().fjD == null)
    {
      finish();
      ab.w(this.TAG, "onCreate msgInfo.item is null");
      AppMethodBeat.o(152848);
      return;
    }
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("onCreate rawUrl is ");
    Object localObject3 = aYe().fjD;
    if (localObject3 == null) {
      j.ebi();
    }
    ab.i((String)localObject1, ((com.tencent.mm.af.q)localObject3).url);
    this.jXn.a(this.hnw);
    this.kcX.a((TmplShareWebViewToolUI)this, aYe(), this.jXn);
    setActionbarColor(com.tencent.mm.cb.a.m((Context)getContext(), 2131690605));
    setBackBtn((MenuItem.OnMenuItemClickListener)new BizVideoDetailUI.m(this), 2131230746);
    getController().n((Activity)this, -16777216);
    setMMTitle("");
    this.vec = true;
    localObject1 = getController();
    j.p(localObject1, "getController()");
    if (((com.tencent.mm.ui.q)localObject1).dCr() != null)
    {
      localObject1 = getController();
      j.p(localObject1, "getController()");
      localObject1 = ((com.tencent.mm.ui.q)localObject1).dCr();
      j.p(localObject1, "getController().actionBar");
      ((ActionBar)localObject1).getCustomView().setOnTouchListener((View.OnTouchListener)new BizVideoDetailUI.n(this));
    }
    this.jXn.kfx = getTimeLineSessionId();
    localObject1 = this.jXn;
    localObject2 = (TmplShareWebViewToolUI)this;
    int i = getScene();
    int j = getSubScene();
    localObject3 = aYe().fjD;
    if (localObject3 == null) {
      j.ebi();
    }
    ((b)localObject1).a((TmplShareWebViewToolUI)localObject2, i, j, (com.tencent.mm.af.q)localObject3, aYe(), getEnterId());
    com.tencent.mm.plugin.webview.ui.tools.b.Ko(1);
    aYg().addView((View)aZq());
    aZt();
    ab.i(this.TAG, "initVideoParam width " + aYe().fjD.videoWidth + " height " + aYe().fjD.videoHeight);
    if ((aYe().fjD.videoWidth <= 0) || (aYe().fjD.videoHeight <= 0))
    {
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e.kif;
      localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e.a(aYe());
      if (com.tencent.mm.vfs.e.cN((String)localObject2))
      {
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
        localObject2 = com.tencent.mm.sdk.platformtools.d.decodeFile((String)localObject2, (BitmapFactory.Options)localObject1);
        if ((((BitmapFactory.Options)localObject1).outWidth > 0) && (((BitmapFactory.Options)localObject1).outHeight > 0))
        {
          aYe().fjD.videoWidth = ((BitmapFactory.Options)localObject1).outWidth;
          aYe().fjD.videoHeight = ((BitmapFactory.Options)localObject1).outHeight;
          ab.i(this.TAG, "initVideoParam with cover: width " + aYe().fjD.videoWidth + " height " + aYe().fjD.videoHeight);
        }
        if (localObject2 != null) {
          ((Bitmap)localObject2).recycle();
        }
      }
    }
    aZu();
    T((View)aYg(), this.videoHeight);
    localObject1 = aZc();
    j.p(localObject1, "animationLayout");
    T((View)localObject1, this.videoHeight);
    ab.i(this.TAG, "initVideoParam minVideoHeight " + this.kfW + " maxVideoHeight " + this.aXT);
    aZk().setFullScreenDelegate((MPVideoView.b)new p(this));
    aZk().setMPVideoViewCallBack((MPVideoView.c)new q(this));
    ((View)this.kfS.a(eOJ[10])).setOnClickListener((View.OnClickListener)new r(this));
    aZk().setCustomOnTouchListener((View.OnTouchListener)new s(this));
    aZk().setTitle(aYe().fjD.title);
    aZk().setPlayBtnOnClickListener((View.OnClickListener)new BizVideoDetailUI.t(this));
    localObject1 = aZn();
    localObject2 = this.jXn;
    localObject3 = this.kfl;
    j.q(localObject2, "controller");
    ((MPVideoErrorView)localObject1).kgr.setOnClickListener((View.OnClickListener)new MPVideoErrorView.a((MPVideoErrorView)localObject1, (b)localObject2, (h)localObject3));
    this.vgh.setMMOverScrollOffsetListener((LogoWebViewWrapper.b)new BizVideoDetailUI.w(this));
    this.vgh.ddY();
    this.vgh.ddZ();
    this.vgh.dea();
    this.vgh.Kw(-16777216);
    this.vgh.dec();
    aYf().aZJ();
    aYf().a(this.jXn.scene, this.jXn.kbN, this.jXn.fgh, this.jXn.kfv, this.jXn.url, aYe().fjD.title);
    aYf().setCallback((MPWriteCommentLayout.c)new BizVideoDetailUI.o(this));
    aYf().setTimeLineSessionId(getTimeLineSessionId());
    localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    ((IntentFilter)localObject1).setPriority(2147483647);
    if (this.kgg == null) {
      this.kgg = ((BroadcastReceiver)new BizVideoDetailUI.startMonitorNetWorkChange.1(this));
    }
    getContext().registerReceiver(this.kgg, (IntentFilter)localObject1);
    AppMethodBeat.o(152848);
  }
  
  public final void aYn()
  {
    AppMethodBeat.i(152857);
    Object localObject = aZk();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((MPVideoView)localObject).getCurrPosSec());; localObject = null)
    {
      if (localObject == null) {
        j.ebi();
      }
      int j = ((Integer)localObject).intValue();
      localObject = aZk();
      int i = j;
      if (localObject != null)
      {
        i = j;
        if (j == ((MPVideoView)localObject).getDuration()) {
          i = 0;
        }
      }
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e.e(aYe().HD() + "_" + this.jXn.fgl, i);
      this.jXn.onDestroy();
      aZx();
      this.jXn.kfB.kii = aZk().getEndPlayTime();
      if (this.kcZ != 0L)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.iwM;
        this.iwM = (l1 - this.kda + l2);
        this.jXn.kfB.kij = ((int)(this.iwM / 1000L));
      }
      this.jXn.kfB.kih = ((int)aZk().getRealPlayTime());
      this.jXn.kfB.dN(2, 0);
      if (this.kgb) {
        break;
      }
      com.tencent.mm.plugin.webview.ui.tools.b.Ko(22);
      AppMethodBeat.o(152857);
      return;
    }
    if ((aZk().getPlayStart()) && (!aZk().getPlayStarted())) {
      com.tencent.mm.plugin.webview.ui.tools.b.Ko(26);
    }
    AppMethodBeat.o(152857);
  }
  
  public final void aYu()
  {
    AppMethodBeat.i(152864);
    aZx();
    AppMethodBeat.o(152864);
  }
  
  public final void aYv()
  {
    AppMethodBeat.i(152865);
    ab.i(this.TAG, "adWebviewReady");
    this.kfY = true;
    AppMethodBeat.o(152865);
  }
  
  public final Bundle aYw()
  {
    AppMethodBeat.i(152866);
    Bundle localBundle = new Bundle();
    localBundle.putInt("currentTime", aZk().getCurrPosSec());
    localBundle.putInt("duration", aZk().getDuration());
    localBundle.putString("state", this.kgd);
    localBundle.putString("vid", this.jXn.fgl);
    AppMethodBeat.o(152866);
    return localBundle;
  }
  
  public final void aZr()
  {
    AppMethodBeat.i(152850);
    super.aZr();
    Object localObject1 = aZj();
    j.p(localObject1, "h5LoadingLayout");
    ((View)localObject1).setVisibility(8);
    if (this.vfq == null)
    {
      AppMethodBeat.o(152850);
      return;
    }
    this.vfq.setBackgroundColor(com.tencent.mm.cb.a.m((Context)getContext(), 2131689758));
    localObject1 = (LinearLayout)this.vfq.findViewById(2131829524);
    ImageView localImageView = (ImageView)this.vfq.findViewById(2131829525);
    TextView localTextView = (TextView)this.vfq.findViewById(2131829526);
    localTextView.setTextColor(com.tencent.mm.cb.a.m((Context)getContext(), 2131689490));
    j.p(localImageView, "refreshIv");
    Object localObject2 = localImageView.getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new a.v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(152850);
      throw ((Throwable)localObject1);
    }
    localObject2 = (LinearLayout.LayoutParams)localObject2;
    ((LinearLayout.LayoutParams)localObject2).bottomMargin = com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 20);
    ((LinearLayout.LayoutParams)localObject2).topMargin = 0;
    ((LinearLayout.LayoutParams)localObject2).width = com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 32);
    ((LinearLayout.LayoutParams)localObject2).height = ((LinearLayout.LayoutParams)localObject2).width;
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localImageView.setImageResource(2130840915);
    ((LinearLayout)localObject1).setVerticalGravity(16);
    j.p(localTextView, "refreshTv");
    localTextView.setTextSize(com.tencent.mm.cb.a.dr((Context)getContext()) * 14.0F);
    if (this.videoHeight > this.iiW) {}
    for (int i = 20;; i = 80)
    {
      this.vfq.setPadding(0, this.videoHeight, 0, com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), i));
      al.p((Runnable)new BizVideoDetailUI.x(this), 50L);
      AppMethodBeat.o(152850);
      return;
    }
  }
  
  public final void aZv()
  {
    AppMethodBeat.i(15197);
    int i = this.videoHeight;
    aZt();
    aZu();
    ab.i(this.TAG, "initVideoParam with cgi: width " + aYe().fjD.videoWidth + " height " + aYe().fjD.videoHeight);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i, this.videoHeight });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new BizVideoDetailUI.j(this));
    j.p(localValueAnimator, "va");
    localValueAnimator.setDuration(100L);
    localValueAnimator.start();
    AppMethodBeat.o(15197);
  }
  
  public final void aZy()
  {
    AppMethodBeat.i(152859);
    finish();
    AppMethodBeat.o(152859);
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(152855);
    super.b(paramWebView, paramString);
    paramWebView = aZj();
    j.p(paramWebView, "h5LoadingLayout");
    paramWebView.setVisibility(8);
    AppMethodBeat.o(152855);
  }
  
  public final void fN(boolean paramBoolean)
  {
    AppMethodBeat.i(15199);
    if (this.kfU != null)
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.d locald = this.kfU;
      if (locald != null)
      {
        locald.fR(paramBoolean);
        AppMethodBeat.o(15199);
        return;
      }
    }
    AppMethodBeat.o(15199);
  }
  
  public void finish()
  {
    AppMethodBeat.i(138061);
    super.finish();
    overridePendingTransition(2131034130, 2131034228);
    AppMethodBeat.o(138061);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(15209);
    if (this.kcX.onActivityResult(paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(15209);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(15209);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(15205);
    if (this.kfj)
    {
      aZk().l(false, 0);
      AppMethodBeat.o(15205);
      return;
    }
    if (!aYf().aZK()) {
      finish();
    }
    AppMethodBeat.o(15205);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(15204);
    super.onDestroy();
    Object localObject1 = aZk();
    ab.i(MPVideoView.TAG, "onUIDestroy");
    ab.i(MPVideoView.TAG, "clean");
    ((MPVideoView)localObject1).stop();
    Object localObject2 = ((MPVideoView)localObject1).kjD;
    if (localObject2 == null) {
      j.ebi();
    }
    ((MPVideoWrapper)localObject2).aEM();
    localObject1 = ((MPVideoView)localObject1).kjE;
    if (localObject1 == null) {
      j.ebi();
    }
    ((MPVideoViewControlBar)localObject1).onDestroy();
    localObject1 = this.kfk;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.brandservice.ui.widget.a)localObject1).b(this.kfm);
    }
    localObject1 = this.kfU;
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.d)localObject1).kib.disable();
      localObject2 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.d)localObject1).bmB;
      if (localObject2 != null) {
        ((SensorManager)localObject2).unregisterListener((SensorEventListener)localObject1, ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.d)localObject1).khZ);
      }
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.d)localObject1).bmB = null;
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.d)localObject1).khZ = null;
    }
    aYf().onDestroy();
    getContext().unregisterReceiver(this.kgg);
    this.kgg = null;
    AppMethodBeat.o(15204);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(15203);
    super.onPause();
    Object localObject = aZk();
    ab.i(MPVideoView.TAG, "onUIPause");
    localObject = ((MPVideoView)localObject).kjD;
    if (localObject == null) {
      j.ebi();
    }
    ((MPVideoWrapper)localObject).alo();
    AppMethodBeat.o(15203);
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(152856);
    aYn();
    super.onReset();
    AppMethodBeat.o(152856);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(15201);
    super.onResume();
    Object localObject = aZk();
    ab.i(MPVideoView.TAG, "onUIResume");
    if (((MPVideoView)localObject).icV)
    {
      ab.i(MPVideoView.TAG, "onUIResume, should skip ui resume");
      ((MPVideoView)localObject).icV = false;
      AppMethodBeat.o(15201);
      return;
    }
    localObject = ((MPVideoView)localObject).kjD;
    if (localObject == null) {
      j.ebi();
    }
    ((MPVideoWrapper)localObject).alp();
    AppMethodBeat.o(15201);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(15202);
    super.onStart();
    if (aYe().fjD == null)
    {
      finish();
      ab.w(this.TAG, "onStart msgInfo.item is null");
      AppMethodBeat.o(15202);
      return;
    }
    aYd().bringToFront();
    Object localObject = this.kfl;
    if (!s.kr(aYe().fgk)) {}
    for (boolean bool = true;; bool = false)
    {
      ((h)localObject).enable = bool;
      if ((this.kgf) || (!this.kfl.hasInit)) {
        break;
      }
      this.kgf = true;
      localObject = this.pOd;
      if (localObject != null)
      {
        localObject = ((MMWebView)localObject).getSettings();
        if (localObject != null) {
          ((com.tencent.xweb.t)localObject).setRenderPriority(WebSettings.RenderPriority.LOW);
        }
      }
      this.kfl.a((e.b)new BizVideoDetailUI.v(this));
      if (this.pOd != null)
      {
        localObject = this.kfl;
        MMWebView localMMWebView = this.pOd;
        if (localMMWebView == null) {
          j.ebi();
        }
        ((h)localObject).kiv = localMMWebView.isXWalkKernel();
      }
      AppMethodBeat.o(15202);
      return;
    }
    localObject = aZk();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((MPVideoView)localObject).getCurrPosMs());; localObject = null)
    {
      if (((Integer)localObject).intValue() < 1000) {
        aZk().a(aYe().fjD.fjJ, this.iiW, this.videoHeight, aYe());
      }
      AppMethodBeat.o(15202);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void sy(int paramInt)
  {
    AppMethodBeat.i(152852);
    View localView = aZc();
    j.p(localView, "animationLayout");
    if (localView.getVisibility() == 0)
    {
      localView = aZc();
      j.p(localView, "animationLayout");
      T(localView, paramInt);
    }
    localView = this.vfq;
    j.p(localView, "refreshMask");
    if (localView.getVisibility() == 0) {
      this.vfq.setPadding(0, paramInt, 0, 0);
    }
    localView = aZj();
    j.p(localView, "h5LoadingLayout");
    if (localView.getVisibility() == 0) {
      aZj().setPadding(0, paramInt, 0, 0);
    }
    AppMethodBeat.o(152852);
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "enterFullScreen", "", "direction", "", "quitFullScreen", "plugin-brandservice_release"})
  public static final class p
    implements MPVideoView.b
  {
    public final void aDh()
    {
      AppMethodBeat.i(15159);
      BizVideoDetailUI.f(this.kgi).aIJ();
      this.kgi.setRequestedOrientation(1);
      BizVideoDetailUI.j(this.kgi).kfB.dN(6, 0);
      LinearLayout localLinearLayout = BizVideoDetailUI.i(this.kgi);
      j.p(localLinearLayout, "videoAdTitleBar");
      localLinearLayout.setVisibility(8);
      AppMethodBeat.o(15159);
    }
    
    public final boolean isFullScreen()
    {
      AppMethodBeat.i(15160);
      boolean bool = BizVideoDetailUI.c(this.kgi);
      AppMethodBeat.o(15160);
      return bool;
    }
    
    public final void oc(int paramInt)
    {
      AppMethodBeat.i(15158);
      BizVideoDetailUI.d(this.kgi).removeView((View)BizVideoDetailUI.e(this.kgi));
      BizVideoDetailUI.a(this.kgi, true);
      BizVideoDetailUI.f(this.kgi).J((View)BizVideoDetailUI.e(this.kgi), paramInt);
      if ((paramInt == 0) || (paramInt == 180)) {
        BizVideoDetailUI.e(this.kgi).setPageGestureInFullscreen(false);
      }
      for (;;)
      {
        Object localObject = BizVideoDetailUI.g(this.kgi);
        if ((localObject == null) || (((FrameLayout)localObject).getVisibility() != 0))
        {
          localObject = BizVideoDetailUI.h(this.kgi);
          j.p(localObject, "videoWifiTipsView");
          if (((MPVideoWifiTipsView)localObject).getVisibility() != 0) {}
        }
        else
        {
          localObject = BizVideoDetailUI.i(this.kgi);
          j.p(localObject, "videoAdTitleBar");
          ((LinearLayout)localObject).setVisibility(0);
        }
        BizVideoDetailUI.j(this.kgi).kfB.dN(5, 0);
        AppMethodBeat.o(15158);
        return;
        BizVideoDetailUI.e(this.kgi).setPageGestureInFullscreen(true);
      }
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$2", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "canHidOptionMenuNow", "", "getCanHidOptionMenuNow", "()Z", "setCanHidOptionMenuNow", "(Z)V", "playEnd", "getPlayEnd", "setPlayEnd", "startPlayTime", "", "getStartPlayTime", "()J", "setStartPlayTime", "(J)V", "startWaitTime", "getStartWaitTime", "setStartWaitTime", "onControlbarVisible", "", "visible", "onEndDragProgress", "onPlayError", "errorMsg", "", "errorCode", "", "onSeekTo", "time", "onUpdateProgress", "progressLen", "totalLen", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-brandservice_release"})
  public static final class q
    implements MPVideoView.c
  {
    private long fqZ = -1L;
    private long kgl = -1L;
    private boolean kgm;
    boolean kgn;
    
    public final void Hs(String paramString)
    {
      AppMethodBeat.i(15161);
      j.q(paramString, "errorMsg");
      BizVideoDetailUI.j(this.kgi).kfB.kik = paramString;
      BizVideoDetailUI.j(this.kgi).kfB.dN(11, 0);
      BizVideoDetailUI.n(this.kgi).setPlayError$505cff1c(paramString);
      BizVideoDetailUI.o(this.kgi);
      BizVideoDetailUI.a(this.kgi, "error", paramString);
      if (BizVideoDetailUI.e(this.kgi).getPlayStarted())
      {
        com.tencent.mm.plugin.webview.ui.tools.b.Ko(25);
        AppMethodBeat.o(15161);
        return;
      }
      com.tencent.mm.plugin.webview.ui.tools.b.Ko(24);
      AppMethodBeat.o(15161);
    }
    
    public final void aZD()
    {
      AppMethodBeat.i(152828);
      BizVideoDetailUI.j(this.kgi).kfB.dN(12, 0);
      AppMethodBeat.o(152828);
    }
    
    public final void aZE()
    {
      AppMethodBeat.i(152829);
      BizVideoDetailUI.j(this.kgi).kfB.dN(13, 0);
      AppMethodBeat.o(152829);
    }
    
    public final void aZF()
    {
      AppMethodBeat.i(154590);
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.f localf = BizVideoDetailUI.j(this.kgi).kfB;
      int i = (int)(System.currentTimeMillis() - this.kgl);
      if ((i < 0) || (i > 3600000L)) {}
      while (BizVideoDetailUI.e(this.kgi).isPlaying())
      {
        BizVideoDetailUI.a(this.kgi, "play", "");
        AppMethodBeat.o(154590);
        return;
        if (localf.kim)
        {
          localf.kim = false;
          localf.dN(16, i);
        }
        else
        {
          localf.dN(17, i);
        }
      }
      BizVideoDetailUI.a(this.kgi, "pause", "");
      AppMethodBeat.o(154590);
    }
    
    public final void aZG()
    {
      AppMethodBeat.i(152832);
      MPVideoErrorView localMPVideoErrorView = BizVideoDetailUI.n(this.kgi);
      j.p(localMPVideoErrorView, "videoErrView");
      if (localMPVideoErrorView.getVisibility() == 0) {
        BizVideoDetailUI.p(this.kgi);
      }
      AppMethodBeat.o(152832);
    }
    
    public final void fP(boolean paramBoolean)
    {
      AppMethodBeat.i(152831);
      if (paramBoolean)
      {
        this.kgi.showOptionMenu(true);
        AppMethodBeat.o(152831);
        return;
      }
      if (this.kgn) {
        this.kgi.showOptionMenu(false);
      }
      AppMethodBeat.o(152831);
    }
    
    public final void onVideoPause()
    {
      AppMethodBeat.i(152826);
      if (BizVideoDetailUI.e(this.kgi).getPlayStatus() == 2) {
        BizVideoDetailUI.j(this.kgi).kfB.dN(8, 0);
      }
      BizVideoDetailUI.a(this.kgi, "pause", "");
      AppMethodBeat.o(152826);
    }
    
    public final void onVideoPlay()
    {
      int j = 3;
      AppMethodBeat.i(152825);
      BizVideoDetailUI.j(this.kgi);
      int i = j;
      switch (BizVideoDetailUI.e(this.kgi).getPlayStatus())
      {
      default: 
        i = j;
      }
      for (;;)
      {
        BizVideoDetailUI.j(this.kgi).kfB.dN(i, 0);
        BizVideoDetailUI.k(this.kgi).aZP();
        BizVideoDetailUI.a(this.kgi, "play", "");
        if (this.fqZ < 0L)
        {
          com.tencent.mm.plugin.webview.ui.tools.b.Ko(6);
          if (this.kgi.kga) {
            com.tencent.mm.plugin.webview.ui.tools.b.Ko(19);
          }
          this.fqZ = System.currentTimeMillis();
          al.p((Runnable)new BizVideoDetailUI.q.a(this), 3000L);
        }
        al.p((Runnable)new BizVideoDetailUI.q.b(this), 300L);
        AppMethodBeat.o(152825);
        return;
        i = 4;
        continue;
        i = 8;
        continue;
        i = 9;
        continue;
        i = 10;
      }
    }
    
    public final void onVideoWaiting()
    {
      AppMethodBeat.i(152830);
      this.kgl = System.currentTimeMillis();
      BizVideoDetailUI.a(this.kgi, "waiting", "");
      AppMethodBeat.o(152830);
    }
    
    public final void xT()
    {
      AppMethodBeat.i(152827);
      BizVideoDetailUI.j(this.kgi).kfB.dN(7, 0);
      BizVideoDetailUI.a(this.kgi, "ended", "");
      BizVideoDetailUI.m(this.kgi);
      if (!this.kgm)
      {
        this.kgm = true;
        com.tencent.mm.plugin.webview.ui.tools.b.Ko(27);
      }
      AppMethodBeat.o(152827);
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class r
    implements View.OnClickListener
  {
    r(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(152833);
      BizVideoDetailUI.e(this.kgi).l(false, 0);
      AppMethodBeat.o(152833);
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "e", "Landroid/view/MotionEvent;", "onTouch"})
  static final class s
    implements View.OnTouchListener
  {
    s(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(152834);
      if (!BizVideoDetailUI.c(this.kgi)) {
        BizVideoDetailUI.q(this.kgi).P(paramMotionEvent);
      }
      AppMethodBeat.o(152834);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI
 * JD-Core Version:    0.7.0.1
 */