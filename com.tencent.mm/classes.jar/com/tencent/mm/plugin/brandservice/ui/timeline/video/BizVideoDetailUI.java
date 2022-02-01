package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.o;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p.a;
import com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.b;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.c;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar;
import com.tencent.mm.plugin.brandservice.ui.widget.c.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.MPSmileyFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.n.c;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.protobuf.dr;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.protocal.protobuf.ev;
import com.tencent.mm.protocal.protobuf.fe;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import d.g.b.y.d;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/preload/api/IBizVideoPage;", "()V", "TAG", "", "adView", "Landroid/widget/FrameLayout;", "getAdView", "()Landroid/widget/FrameLayout;", "adView$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "adWebView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "getAdWebView", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "setAdWebView", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;)V", "adWebViewReady", "", "getAdWebViewReady", "()Z", "setAdWebViewReady", "(Z)V", "animationIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAnimationIv", "()Landroid/widget/ImageView;", "animationIv$delegate", "animationLayout", "Landroid/view/View;", "getAnimationLayout", "()Landroid/view/View;", "animationLayout$delegate", "appMsgGetResp", "Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;", "getAppMsgGetResp", "()Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;", "setAppMsgGetResp", "(Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;)V", "appmsgDone", "getAppmsgDone", "setAppmsgDone", "backgroundContainerView", "getBackgroundContainerView", "backgroundContainerView$delegate", "bizVideoDotHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotHelper;", "bizVideoPosHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "getBizVideoPosHelper", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "setBizVideoPosHelper", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;)V", "bizVideoProfiler", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "cgiCallback", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "commentUrl", "currentDot", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "density", "", "getDensity", "()F", "setDensity", "(F)V", "dotView", "getDotView", "dotView$delegate", "dotWebView", "getDotWebView", "setDotWebView", "dotWebViewReady", "getDotWebViewReady", "setDotWebViewReady", "fullscreenImpl", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenImpl;", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "getAppMsgDone", "getGetAppMsgDone", "setGetAppMsgDone", "hideWifiTipsBarAnim", "Landroid/view/animation/Animation;", "insertVideoDone", "getInsertVideoDone", "setInsertVideoDone", "isInFullScreen", "isNetworkConnected", "needShowWifiTipsView", "getNeedShowWifiTipsView", "setNeedShowWifiTipsView", "networkListener", "Landroid/content/BroadcastReceiver;", "orientationHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper;", "playState", "getPlayState", "()Ljava/lang/String;", "setPlayState", "(Ljava/lang/String;)V", "setFullScreen", "showWifiTipsBarAnim", "showWifiTipsMode", "simcardTpye", "", "switchVideo", "getSwitchVideo", "setSwitchVideo", "switchingResolution", "getSwitchingResolution", "setSwitchingResolution", "titleBarHeight", "uin", "videoAdTitleBack", "getVideoAdTitleBack", "videoAdTitleBack$delegate", "videoAdTitleBar", "Landroid/widget/LinearLayout;", "getVideoAdTitleBar", "()Landroid/widget/LinearLayout;", "videoAdTitleBar$delegate", "videoControlBarHeight", "videoErrView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "getVideoErrView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "videoErrView$delegate", "videoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoView", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "videoView$delegate", "videoViewContainer", "getVideoViewContainer", "videoViewContainer$delegate", "videoWifiTipsView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "getVideoWifiTipsView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "videoWifiTipsView$delegate", "waitToDetroyTime", "", "adWebviewReady", "", "bundle", "Landroid/os/Bundle;", "checkInitOrientationHelper", "w", "h", "closeAdWebview", "closeDotWebview", "createAdWebview", "createDotWebview", "id", "url", "destroyDotWebView", "destroyWebView", "doOnDestroy", "doPlayVideo", "resp", "dotWebviewReady", "enableMinimize", "enableOrientationListener", "enable", "getCurrentDotId", "getCurrentPlayTime", "getForceOrientation", "getFullscreenImpl", "getLastPlayTimeKey", "getMPVideoState", "getMarginValue", "value", "", "fullValue", "getSimCardType", "goneVideoErrorView", "hideCoverLayout", "hideDotWebview", "hideVideoTitleBar", "hideWifiTipsView", "delay", "init", "initActionBar", "initComment", "initControlAreaHeight", "initDensity", "wv", "Lcom/tencent/mm/ui/widget/MMWebView;", "initOrientationHelper", "initReportParams", "initVideoParam", "initVideoView", "initView", "initWebviewSetting", "webview", "insertVideoNativeView", "params", "", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAppMsgGet", "onBackPressed", "onDestroy", "onDestroyReport", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onMPVideoStateChange", "state", "errMsg", "onPageFinished", "view", "Lcom/tencent/xweb/WebView;", "onPageReady", "onPause", "onReset", "onResetAfterCreate", "onResetBeforeCreate", "onResume", "onShowAd", "onShowDot", "onStart", "onWebViewScrollChanged", "scrollY", "opPlayer", "postBinded", "sendMPPageData", "setDotScriptData", "setTouchListener", "shouldShowWifiTips", "duration", "netChange", "showCoverLayout", "showVideoErrorView", "showWifiTipsView", "startMonitorNetWorkChange", "stopMonitorNetWorkChange", "updateDot", "updateDotAttr", "posInfo", "webviewId", "updateDotPos", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotPosInfo;", "updateDotPosIfNeed", "updateVideoPosition", "plugin-brandservice_release"})
public class BizVideoDetailUI
  extends TmplShareWebViewToolUI
  implements com.tencent.mm.plugin.webview.g.a.a
{
  private final String TAG;
  private float density;
  private String fmn;
  private boolean jEw;
  private final IPCRunCgi.a kis;
  MMWebViewWithJsApi ouA;
  MMWebViewWithJsApi ouB;
  private boolean ouC;
  private boolean ouD;
  boolean ouE;
  boolean ouF;
  boolean ouG;
  boolean ouH;
  private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c ouI;
  private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b ouJ;
  private boolean ouK;
  private final j.a ouL;
  private String ouM;
  private boolean ouN;
  private boolean ouO;
  private fg ouP;
  private Animation ouQ;
  private Animation ouR;
  private com.tencent.mm.plugin.brandservice.ui.widget.b ouS;
  private long ouT;
  private int ouU;
  private int ouV;
  private BroadcastReceiver ouW;
  private boolean ouX;
  private boolean ouY;
  private final o ouk;
  private final o oul;
  private final o oum;
  private final o oun;
  private final o ouo;
  private final o oup;
  private final o ouq;
  private final o our;
  private final o ous;
  private final o ouu;
  private final o ouv;
  private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h ouw;
  private com.tencent.mm.plugin.brandservice.ui.widget.a oux;
  private int ouy;
  i ouz;
  private int uin;
  
  static
  {
    AppMethodBeat.i(7140);
    cxA = new d.l.k[] { (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "animationIv", "getAnimationIv()Landroid/widget/ImageView;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "animationLayout", "getAnimationLayout()Landroid/view/View;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "videoView", "getVideoView()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "adView", "getAdView()Landroid/widget/FrameLayout;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "dotView", "getDotView()Landroid/widget/FrameLayout;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "backgroundContainerView", "getBackgroundContainerView()Landroid/widget/FrameLayout;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "videoErrView", "getVideoErrView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "videoWifiTipsView", "getVideoWifiTipsView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "videoAdTitleBar", "getVideoAdTitleBar()Landroid/widget/LinearLayout;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "videoAdTitleBack", "getVideoAdTitleBack()Landroid/view/View;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "videoViewContainer", "getVideoViewContainer()Landroid/widget/FrameLayout;")) };
    AppMethodBeat.o(7140);
  }
  
  public BizVideoDetailUI()
  {
    AppMethodBeat.i(7216);
    this.TAG = "MicroMsg.BizVideoDetailUI";
    this.ouk = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new b(this));
    this.oul = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new c(this));
    this.oum = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new ad(this));
    this.oun = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new a(this));
    this.ouo = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new j(this));
    this.oup = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new d(this));
    this.ouq = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new ac(this));
    this.our = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new af(this));
    this.ous = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new ab(this));
    this.ouu = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new aa(this));
    this.ouv = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.otC, (d.g.a.a)new ae(this));
    this.ouz = new i();
    this.ouJ = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b();
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
    this.ouL = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.YJ(toString());
    this.ouM = "";
    this.fmn = "";
    this.ouS = ((com.tencent.mm.plugin.brandservice.ui.widget.b)new k(this));
    this.ouU = -1;
    this.ouV = -1;
    this.kis = ((IPCRunCgi.a)new e(this));
    this.ouX = true;
    AppMethodBeat.o(7216);
  }
  
  private final boolean T(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(175519);
    if ((com.tencent.mm.sdk.platformtools.j.DEBUG) && (this.ouY))
    {
      AppMethodBeat.o(175519);
      return true;
    }
    if (!az.isNetworkConnected(ak.getContext()))
    {
      AppMethodBeat.o(175519);
      return false;
    }
    if (bSp().getPlayStatus() == 4)
    {
      ae.i(this.TAG, "not show WifiTips, play end!");
      AppMethodBeat.o(175519);
      return false;
    }
    if ((paramInt > 0) && (bSp().getCacheTimeSec() >= paramInt))
    {
      ae.i(this.TAG, "not show WifiTips, video cached! " + bSp().getCacheTimeSec() + '/' + bSp().getDuration());
      AppMethodBeat.o(175519);
      return false;
    }
    if (this.ota.otW)
    {
      ae.i(this.TAG, "not show WifiTips, has show!");
      AppMethodBeat.o(175519);
      return false;
    }
    if (paramBoolean)
    {
      localObject = MPVideoWifiTipsView.ows;
      if (!MPVideoWifiTipsView.a.Ah(this.ota.otV))
      {
        AppMethodBeat.o(175519);
        return false;
      }
    }
    else
    {
      localObject = MPVideoWifiTipsView.ows;
      if (!MPVideoWifiTipsView.a.Af(this.ota.otV))
      {
        localObject = MPVideoWifiTipsView.ows;
        if (!MPVideoWifiTipsView.a.Ag(this.ota.otV))
        {
          AppMethodBeat.o(175519);
          return false;
        }
      }
    }
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.oxU;
    if (!com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.z(az.isWifi(ak.getContext()), this.ouy))
    {
      AppMethodBeat.o(175519);
      return true;
    }
    AppMethodBeat.o(175519);
    return false;
  }
  
  private final int a(double paramDouble, int paramInt)
  {
    if (paramDouble < 0.0D) {
      return 0;
    }
    if (paramDouble < 1.0D) {
      return (int)(paramInt * paramDouble);
    }
    return (int)(this.density * paramDouble);
  }
  
  private final void a(com.tencent.mm.plugin.brandservice.ui.timeline.video.util.d paramd)
  {
    AppMethodBeat.i(7204);
    Object localObject = this.ouI;
    if (localObject == null) {
      d.g.b.p.gkB();
    }
    if (!((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).owO.gHg)
    {
      AppMethodBeat.o(7204);
      return;
    }
    bSM();
    FrameLayout localFrameLayout = bSr();
    if (localFrameLayout != null)
    {
      localObject = bSr();
      if (localObject != null) {}
      for (localObject = ((FrameLayout)localObject).getLayoutParams(); localObject == null; localObject = null)
      {
        paramd = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(7204);
        throw paramd;
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      ((RelativeLayout.LayoutParams)localObject).width = ((int)(paramd.width * this.density));
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(paramd.height * this.density));
      int i;
      int j;
      label176:
      int k;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c localc;
      if (this.jEw)
      {
        i = com.tencent.mm.cb.a.iu((Context)getContext());
        if (!this.jEw) {
          break label485;
        }
        j = com.tencent.mm.cb.a.iv((Context)getContext());
        k = j - this.ouV - this.ouU;
        j = k;
        if (!this.jEw)
        {
          if (bSp().bTQ()) {
            break label496;
          }
          localc = this.ouI;
          if (localc == null) {
            d.g.b.p.gkB();
          }
          localc.owK = false;
          j = k + this.ouU;
        }
        label237:
        k = a(paramd.owV, j);
        if (k < this.ouU)
        {
          localc = this.ouI;
          if (localc == null) {
            d.g.b.p.gkB();
          }
          localc.owL = true;
        }
        ((RelativeLayout.LayoutParams)localObject).leftMargin = a(paramd.owS, i);
        ((RelativeLayout.LayoutParams)localObject).topMargin = (a(paramd.owT, j) + this.ouV);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = a(paramd.owU, i);
        localc = this.ouI;
        if (localc == null) {
          d.g.b.p.gkB();
        }
        if ((!localc.owK) && (!this.jEw)) {
          break label522;
        }
        i = this.ouU;
        label358:
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = (i + k);
        if (!paramd.owY) {
          break label527;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
        label382:
        if (!paramd.oxa) {
          break label537;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
        label397:
        if (!paramd.owZ) {
          break label547;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        label412:
        if (!paramd.oxb) {
          break label557;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        label427:
        if (!paramd.owW) {
          break label567;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
        label442:
        if (!paramd.owX) {
          break label577;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
      }
      for (;;)
      {
        localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(7204);
        return;
        i = this.ouz.oxo;
        break;
        label485:
        j = this.ouz.oxn;
        break label176;
        label496:
        localc = this.ouI;
        if (localc == null) {
          d.g.b.p.gkB();
        }
        localc.owK = true;
        j = k;
        break label237;
        label522:
        i = 0;
        break label358;
        label527:
        ((RelativeLayout.LayoutParams)localObject).removeRule(9);
        break label382;
        label537:
        ((RelativeLayout.LayoutParams)localObject).removeRule(11);
        break label397;
        label547:
        ((RelativeLayout.LayoutParams)localObject).removeRule(10);
        break label412;
        label557:
        ((RelativeLayout.LayoutParams)localObject).removeRule(12);
        break label427;
        label567:
        ((RelativeLayout.LayoutParams)localObject).removeRule(15);
        break label442;
        label577:
        ((RelativeLayout.LayoutParams)localObject).removeRule(14);
      }
    }
    AppMethodBeat.o(7204);
  }
  
  private static void a(MMWebViewWithJsApi paramMMWebViewWithJsApi)
  {
    AppMethodBeat.i(7196);
    if (paramMMWebViewWithJsApi != null) {
      paramMMWebViewWithJsApi.setCleanOnDetached(false);
    }
    com.tencent.xweb.z localz;
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.gfC();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.setDatabasePath(com.tencent.mm.loader.j.b.asa() + "databases/");
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.gfF();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.gfD();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.gfB();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.gfA();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      paramMMWebViewWithJsApi.setOnLongClickListener((View.OnLongClickListener)BizVideoDetailUI.t.ovj);
      AppMethodBeat.o(7196);
      return;
    }
    AppMethodBeat.o(7196);
  }
  
  private boolean aF(int paramInt, String paramString)
  {
    AppMethodBeat.i(7202);
    d.g.b.p.h(paramString, "url");
    if (isFinishing())
    {
      AppMethodBeat.o(7202);
      return false;
    }
    if (this.ouB != null)
    {
      ae.w(this.TAG, "createDotWebview dotWebView existed!");
      AppMethodBeat.o(7202);
      return false;
    }
    com.tencent.mm.plugin.webview.h.a.XF(57);
    this.ouD = false;
    Object localObject = a.otI;
    localObject = MMWebViewWithJsApi.a.he((Context)getContext());
    d.g.b.p.g(localObject, "MMWebViewWithJsApi.Factory.create(this.context)");
    this.ouB = a.a((MMWebViewWithJsApi)localObject, bRL(), (d.g.a.m)new h(this), (d.g.a.m)new i(this), aHI(bRK().Wa()));
    d((MMWebView)this.ouB);
    a(this.ouB);
    localObject = bSr();
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = bSs();
    if (localObject != null) {
      ((FrameLayout)localObject).addView((View)this.ouB);
    }
    bSM();
    int i = this.ouz.height;
    int j = this.ouU;
    int k = this.ouV;
    paramString = UrlExKt.appendUrlParam(paramString, "dotId", String.valueOf(paramInt));
    localObject = this.ouB;
    if (localObject == null) {
      d.g.b.p.gkB();
    }
    paramString = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(paramString, "dotWebviewId", String.valueOf(((MMWebViewWithJsApi)localObject).hashCode())), "dotMinShowHeight", String.valueOf(i - j - k));
    ae.i(this.TAG, "createDotWebview dotView dotUrl=".concat(String.valueOf(paramString)));
    localObject = this.ouB;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).loadUrl(paramString);
    }
    paramString = this.ouB;
    if (paramString != null) {
      paramString.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(7202);
    return true;
  }
  
  private final void b(fg paramfg)
  {
    int j = 0;
    AppMethodBeat.i(175514);
    if (paramfg == null)
    {
      AppMethodBeat.o(175514);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.brandservice.ui.widget.c.oAe;
    com.tencent.mm.plugin.brandservice.ui.widget.c.bTM();
    this.ouP = paramfg;
    ae.i(this.TAG, "doPlayVideo getAppMsgDone: " + this.ouN + ", insertVideoDone: " + this.ouO);
    if ((!this.ouN) || (!this.ouO))
    {
      AppMethodBeat.o(175514);
      return;
    }
    localObject1 = this.ota.ouf;
    Object localObject2 = paramfg.FPM;
    d.g.b.p.g(localObject2, "resp.url_info");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject1).J((LinkedList)localObject2);
    com.tencent.mm.plugin.webview.h.a.XF(23);
    localObject1 = paramfg.FPM;
    d.g.b.p.g(localObject1, "resp.url_info");
    localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.k.I((LinkedList)localObject1);
    if (localObject1 == null)
    {
      AppMethodBeat.o(175514);
      return;
    }
    this.ota.ouf.oyc = ((fu)localObject1).FQz;
    this.ota.otU = ((fu)localObject1).otU;
    this.ota.otV = ((fu)localObject1).FQB;
    ae.i(this.TAG, "doPlayVideo filesize=" + this.ota.otU + " wifiTipsFlag=" + this.ota.otV);
    boolean bool;
    int i;
    if ((paramfg.FPQ & 0x1) != 0)
    {
      bool = true;
      if ((eWi() == null) || (!eWi().bLw())) {
        break label725;
      }
      localObject2 = eWi();
      d.g.b.p.g(localObject2, "webViewFloatBallHelper");
      i = ((com.tencent.mm.plugin.webview.ui.tools.floatball.a)localObject2).eXv();
      label295:
      bSp().setInitialTime(i * 1000);
      localObject2 = paramfg.FPY;
      if (localObject2 != null)
      {
        bSp().a(((dr)localObject2).bDT, ((dr)localObject2).bDX, ((dr)localObject2).FOr, ((dr)localObject2).FOs, ((dr)localObject2).lvB, ((dr)localObject2).lvC);
        ae.i(this.TAG, "maxInitBitrate = " + ((dr)localObject2).bDT + ", bandFraction = " + ((dr)localObject2).bDX + ", minDur = " + ((dr)localObject2).FOr + ", maxDur = " + ((dr)localObject2).FOs + ", minBuffer = " + ((dr)localObject2).lvB + ", maxBuffer = " + ((dr)localObject2).lvC);
      }
      this.ouE = false;
      if (!T(((fu)localObject1).FQw / 1000, false)) {
        break label744;
      }
      if (!bool) {
        break label736;
      }
      jn(false);
    }
    for (;;)
    {
      bSp().setAutoPlay(bool);
      if (!bool) {
        bSG();
      }
      this.ota.ouf.width = ((fu)localObject1).width;
      this.ota.ouf.height = ((fu)localObject1).height;
      localObject2 = bSp();
      String str = ((fu)localObject1).url;
      d.g.b.p.g(str, "urlInfo.url");
      ((MPVideoView)localObject2).cH(str, ((fu)localObject1).FQw / 1000);
      localObject2 = bSp();
      i = j;
      if (((fu)localObject1).width > ((fu)localObject1).height) {
        i = 90;
      }
      ((MPVideoView)localObject2).setFullScreenDirection(i);
      eR(((fu)localObject1).width, ((fu)localObject1).height);
      if ((((fu)localObject1).width > 0) && (((fu)localObject1).height > 0) && (bRK().hFY.videoWidth <= 0) && (bRK().hFY.videoHeight <= 0))
      {
        bRK().hFY.videoWidth = ((fu)localObject1).width;
        bRK().hFY.videoHeight = ((fu)localObject1).height;
      }
      localObject2 = bSp();
      paramfg = paramfg.FPM;
      d.g.b.p.g(paramfg, "resp.url_info");
      ((MPVideoView)localObject2).a(paramfg, (fu)localObject1);
      AppMethodBeat.o(175514);
      return;
      bool = false;
      break;
      label725:
      i = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.YN(bSF());
      break label295;
      label736:
      this.ouE = true;
      continue;
      label744:
      tG(0L);
    }
  }
  
  private void bSC()
  {
    AppMethodBeat.i(209092);
    if (bSp().isPlaying()) {
      bSp().bTN();
    }
    eV("leavePage", "");
    this.ouL.report();
    this.ota.ouf.oxX = bSp().getEndPlayTime();
    if (this.otc != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.mfG;
      this.mfG = (l1 - this.otd + l2);
      this.ota.ouf.oxY = ((int)(this.mfG / 1000L));
    }
    this.ota.ouf.oxW = ((int)bSp().getRealPlayTime());
    this.ota.ouf.ed(2, 0);
    if (!this.ouG)
    {
      com.tencent.mm.plugin.webview.h.a.XF(22);
      AppMethodBeat.o(209092);
      return;
    }
    if ((bSp().getPlayStart()) && (!bSp().getPlayStarted())) {
      com.tencent.mm.plugin.webview.h.a.XF(26);
    }
    AppMethodBeat.o(209092);
  }
  
  private void bSD()
  {
    AppMethodBeat.i(7183);
    if (this.ouA == null)
    {
      AppMethodBeat.o(7183);
      return;
    }
    Object localObject = this.DRx;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.c.f)localObject).aIb("disappear");
    }
    localObject = this.DRx;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.c.f)localObject).aIb("destroy");
    }
    localObject = bSq();
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = bSq();
    if (localObject != null) {
      ((FrameLayout)localObject).removeView((View)this.ouA);
    }
    localObject = this.ouA;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getCurWebviewClient();
      if (!(localObject instanceof com.tencent.mm.plugin.webview.ui.tools.widget.k)) {
        break label162;
      }
      localObject = this.ouA;
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
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewClient");
      AppMethodBeat.o(7183);
      throw ((Throwable)localObject);
      localObject = null;
      break;
    }
    label155:
    ((com.tencent.mm.plugin.webview.ui.tools.widget.k)localObject).cleanup();
    label162:
    localObject = this.ouA;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).destroy();
    }
    localObject = this.ouA;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebChromeClient(null);
    }
    localObject = this.ouA;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebViewClient(null);
    }
    localObject = this.ouA;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnTouchListener(null);
    }
    localObject = this.ouA;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnLongClickListener(null);
    }
    localObject = this.ouA;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setVisibility(8);
    }
    localObject = this.ouA;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).removeAllViews();
    }
    localObject = this.ouA;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).clearView();
    }
    this.ouA = null;
    this.ouC = false;
    bSJ();
    AppMethodBeat.o(7183);
  }
  
  private final String bSF()
  {
    AppMethodBeat.i(7188);
    String str = bRK().Wa() + '_' + this.uin + '_' + this.ota.hCa;
    AppMethodBeat.o(7188);
    return str;
  }
  
  private final void bSG()
  {
    AppMethodBeat.i(175515);
    View localView = bSo();
    d.g.b.p.g(localView, "animationLayout");
    localView.setVisibility(8);
    AppMethodBeat.o(175515);
  }
  
  private final void bSH()
  {
    AppMethodBeat.i(7189);
    MPVideoErrorView localMPVideoErrorView = bSt();
    d.g.b.p.g(localMPVideoErrorView, "videoErrView");
    if (localMPVideoErrorView.getVisibility() == 0)
    {
      localMPVideoErrorView = bSt();
      d.g.b.p.g(localMPVideoErrorView, "videoErrView");
      localMPVideoErrorView.setVisibility(8);
      eR(this.ouz.width, this.ouz.height);
    }
    AppMethodBeat.o(7189);
  }
  
  private final void bSI()
  {
    AppMethodBeat.i(7190);
    MPVideoErrorView localMPVideoErrorView = bSt();
    d.g.b.p.g(localMPVideoErrorView, "videoErrView");
    localMPVideoErrorView.setVisibility(0);
    jm(false);
    AppMethodBeat.o(7190);
  }
  
  private final void bSJ()
  {
    AppMethodBeat.i(7193);
    Object localObject = bSq();
    if (localObject != null)
    {
      if (((FrameLayout)localObject).getVisibility() == 8)
      {
        localObject = bSu();
        d.g.b.p.g(localObject, "videoWifiTipsView");
        if (((MPVideoWifiTipsView)localObject).getVisibility() == 8)
        {
          localObject = bSv();
          d.g.b.p.g(localObject, "videoAdTitleBar");
          ((LinearLayout)localObject).setVisibility(8);
        }
      }
      AppMethodBeat.o(7193);
      return;
    }
    AppMethodBeat.o(7193);
  }
  
  private final void bSK()
  {
    AppMethodBeat.i(7203);
    if (this.ouI != null)
    {
      Object localObject = bSr();
      if (localObject == null) {
        break label56;
      }
      if (((FrameLayout)localObject).getVisibility() == 0)
      {
        localObject = this.ouI;
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        a(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).owO);
      }
    }
    AppMethodBeat.o(7203);
    return;
    label56:
    AppMethodBeat.o(7203);
  }
  
  private final void bSL()
  {
    AppMethodBeat.i(7205);
    Object localObject1;
    if ((bSr() != null) && (this.ouI != null))
    {
      localObject1 = this.ouI;
      if (localObject1 == null) {
        d.g.b.p.gkB();
      }
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject1).owL) {}
    }
    else
    {
      AppMethodBeat.o(7205);
      return;
    }
    ae.i(this.TAG, "updateDotPosIfNeed");
    int i;
    Object localObject2;
    if (!this.jEw)
    {
      localObject1 = bSr();
      if (localObject1 != null) {}
      for (localObject1 = ((FrameLayout)localObject1).getLayoutParams(); localObject1 == null; localObject1 = null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(7205);
        throw ((Throwable)localObject1);
      }
      i = ((RelativeLayout.LayoutParams)localObject1).bottomMargin;
      localObject1 = new y.d();
      ((y.d)localObject1).NiW = i;
      if (!bSp().bTQ()) {
        break label228;
      }
      localObject2 = this.ouI;
      if (localObject2 == null) {
        d.g.b.p.gkB();
      }
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).owK) {
        break label228;
      }
    }
    for (((y.d)localObject1).NiW += this.ouU;; ((y.d)localObject1).NiW -= this.ouU)
    {
      localObject2 = ValueAnimator.ofInt(new int[] { i, ((y.d)localObject1).NiW });
      ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new z(this, (y.d)localObject1));
      d.g.b.p.g(localObject2, "va");
      ((ValueAnimator)localObject2).setDuration(200L);
      ((ValueAnimator)localObject2).start();
      AppMethodBeat.o(7205);
      return;
      label228:
      if (bSp().bTQ()) {
        break;
      }
      localObject2 = this.ouI;
      if (localObject2 == null) {
        d.g.b.p.gkB();
      }
      if (!((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).owK) {
        break;
      }
    }
    AppMethodBeat.o(7205);
  }
  
  private final void bSM()
  {
    AppMethodBeat.i(7206);
    if (this.ouU < 0)
    {
      this.ouU = com.tencent.mm.cb.a.ax((Context)getContext(), 2131166589);
      this.ouV = com.tencent.mm.ui.ar.dX((Context)getContext());
    }
    AppMethodBeat.o(7206);
  }
  
  private final void bSN()
  {
    AppMethodBeat.i(7207);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onShowDot ready: ").append(this.ouD).append(", hasWebView: ");
    if (this.ouB != null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i((String)localObject, bool);
      if ((this.ouD) && (this.ouB != null)) {
        break;
      }
      AppMethodBeat.o(7207);
      return;
    }
    com.tencent.mm.plugin.webview.h.a.XF(60);
    localObject = bSr();
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = bSs();
    if (localObject != null) {
      ((FrameLayout)localObject).removeView((View)this.ouB);
    }
    localObject = bSr();
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = bSr();
    if (localObject != null) {
      ((FrameLayout)localObject).addView((View)this.ouB);
    }
    localObject = bSr();
    if (localObject != null)
    {
      localObject = ((FrameLayout)localObject).getViewTreeObserver();
      if (localObject != null) {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new v(this));
      }
    }
    localObject = this.ouI;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).owJ = true;
    }
    localObject = this.ouI;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).owM = true;
    }
    bSL();
    AppMethodBeat.o(7207);
  }
  
  private final void bSQ()
  {
    AppMethodBeat.i(175518);
    if (this.ouW != null)
    {
      getContext().unregisterReceiver(this.ouW);
      this.ouW = null;
    }
    AppMethodBeat.o(175518);
  }
  
  private final View bSo()
  {
    AppMethodBeat.i(7143);
    View localView = (View)this.oul.a(cxA[1]);
    AppMethodBeat.o(7143);
    return localView;
  }
  
  private final MPVideoView bSp()
  {
    AppMethodBeat.i(7145);
    MPVideoView localMPVideoView = (MPVideoView)this.oum.a(cxA[2]);
    AppMethodBeat.o(7145);
    return localMPVideoView;
  }
  
  private final FrameLayout bSq()
  {
    AppMethodBeat.i(7146);
    FrameLayout localFrameLayout = (FrameLayout)this.oun.a(cxA[3]);
    AppMethodBeat.o(7146);
    return localFrameLayout;
  }
  
  private final FrameLayout bSr()
  {
    AppMethodBeat.i(7147);
    FrameLayout localFrameLayout = (FrameLayout)this.ouo.a(cxA[4]);
    AppMethodBeat.o(7147);
    return localFrameLayout;
  }
  
  private final FrameLayout bSs()
  {
    AppMethodBeat.i(7148);
    FrameLayout localFrameLayout = (FrameLayout)this.oup.a(cxA[5]);
    AppMethodBeat.o(7148);
    return localFrameLayout;
  }
  
  private final MPVideoErrorView bSt()
  {
    AppMethodBeat.i(7149);
    MPVideoErrorView localMPVideoErrorView = (MPVideoErrorView)this.ouq.a(cxA[6]);
    AppMethodBeat.o(7149);
    return localMPVideoErrorView;
  }
  
  private final MPVideoWifiTipsView bSu()
  {
    AppMethodBeat.i(7150);
    MPVideoWifiTipsView localMPVideoWifiTipsView = (MPVideoWifiTipsView)this.our.a(cxA[7]);
    AppMethodBeat.o(7150);
    return localMPVideoWifiTipsView;
  }
  
  private final LinearLayout bSv()
  {
    AppMethodBeat.i(7151);
    LinearLayout localLinearLayout = (LinearLayout)this.ous.a(cxA[8]);
    AppMethodBeat.o(7151);
    return localLinearLayout;
  }
  
  private final FrameLayout bSw()
  {
    AppMethodBeat.i(7152);
    FrameLayout localFrameLayout = (FrameLayout)this.ouv.a(cxA[10]);
    AppMethodBeat.o(7152);
    return localFrameLayout;
  }
  
  private final int bSy()
  {
    AppMethodBeat.i(175507);
    if (this.lzT == null)
    {
      i = this.ouy;
      AppMethodBeat.o(175507);
      return i;
    }
    try
    {
      Bundle localBundle = this.lzT.k(110, new Bundle());
      if (localBundle != null) {
        this.ouy = localBundle.getInt("sim_card_type", 0);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.w(this.TAG, "invoker ex :" + localException.getMessage());
      }
    }
    int i = this.ouy;
    AppMethodBeat.o(175507);
    return i;
  }
  
  private final void bSz()
  {
    AppMethodBeat.i(175509);
    View localView = bSo();
    d.g.b.p.g(localView, "animationLayout");
    if (localView.getVisibility() == 0)
    {
      localView = bSo();
      d.g.b.p.g(localView, "animationLayout");
      dG(localView);
    }
    dG((View)bRM());
    bSK();
    AppMethodBeat.o(175509);
  }
  
  private final void d(MMWebView paramMMWebView)
  {
    float f = 0.0F;
    AppMethodBeat.i(175517);
    if (this.density > 0.0F)
    {
      AppMethodBeat.o(175517);
      return;
    }
    if (paramMMWebView != null) {
      f = paramMMWebView.getMMDensity();
    }
    this.density = f;
    AppMethodBeat.o(175517);
  }
  
  private final void dG(View paramView)
  {
    AppMethodBeat.i(175510);
    this.ouz.dG(paramView);
    AppMethodBeat.o(175510);
  }
  
  private final void eR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7167);
    if (paramInt1 > paramInt2)
    {
      Object localObject1;
      if (this.ouw != null)
      {
        localObject1 = this.ouw;
        if (localObject1 != null)
        {
          Object localObject2 = getContext();
          d.g.b.p.g(localObject2, "context");
          localObject2 = (Context)localObject2;
          MPVideoView localMPVideoView = bSp();
          d.g.b.p.h(localObject2, "ctx");
          d.g.b.p.h(localMPVideoView, "video");
          ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h)localObject1).kwC = new WeakReference(localObject2);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h)localObject1).oxf = new WeakReference(localMPVideoView);
        }
      }
      for (;;)
      {
        jm(true);
        AppMethodBeat.o(7167);
        return;
        localObject1 = getContext();
        d.g.b.p.g(localObject1, "context");
        this.ouw = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h((Context)localObject1, bSp());
      }
    }
    jm(false);
    AppMethodBeat.o(7167);
  }
  
  private final void eV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(209093);
    if (bu.lX(this.ouM, paramString1))
    {
      AppMethodBeat.o(209093);
      return;
    }
    ae.d(this.TAG, "onMPVideoStateChange ".concat(String.valueOf(paramString1)));
    Object localObject = this.DRx;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.c.f)localObject).f(paramString1, this.ota.hCa, paramString2, String.valueOf(bSp().getCurrPosSec()), String.valueOf(bSp().getRealPlayTime() / 1000L));
    }
    localObject = this.ouA;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
      if (localObject != null) {
        ((com.tencent.mm.plugin.webview.c.f)localObject).f(paramString1, this.ota.hCa, paramString2, String.valueOf(bSp().getCurrPosSec()), String.valueOf(bSp().getRealPlayTime() / 1000L));
      }
    }
    this.ouM = paramString1;
    AppMethodBeat.o(209093);
  }
  
  private final void jn(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(7191);
    if (!T(bSp().getDuration(), paramBoolean))
    {
      ae.i(this.TAG, "showWifiTipsView should not show now");
      AppMethodBeat.o(7191);
      return;
    }
    ae.i(this.TAG, "showWifiTipsView ".concat(String.valueOf(paramBoolean)));
    com.tencent.mm.plugin.webview.h.a.XF(16);
    Object localObject;
    int i;
    if (!paramBoolean)
    {
      localObject = MPVideoWifiTipsView.ows;
      if (MPVideoWifiTipsView.a.Ag(this.ota.otV))
      {
        i = 2;
        this.ota.ouf.oye = i;
        this.ota.ouf.ed(14, 0);
        localObject = this.ota;
        if (!paramBoolean) {
          break label264;
        }
      }
    }
    for (;;)
    {
      ((b)localObject).Ad(j);
      this.ota.otW = true;
      this.ouE = false;
      bSu().q(this.ota.otU, i);
      if (this.ouQ == null)
      {
        this.ouQ = AnimationUtils.loadAnimation((Context)getContext(), 2130772105);
        localObject = this.ouQ;
        if (localObject != null) {
          ((Animation)localObject).setDuration(300L);
        }
      }
      bSu().clearAnimation();
      bSu().startAnimation(this.ouQ);
      localObject = bSu();
      d.g.b.p.g(localObject, "videoWifiTipsView");
      ((MPVideoWifiTipsView)localObject).setVisibility(0);
      com.tencent.mm.sdk.platformtools.ar.o((Runnable)new y(this), 3000L);
      AppMethodBeat.o(7191);
      return;
      i = 1;
      break;
      label264:
      j = 1;
    }
  }
  
  private final void tG(long paramLong)
  {
    AppMethodBeat.i(175516);
    Object localObject = bSu();
    d.g.b.p.g(localObject, "videoWifiTipsView");
    if (((MPVideoWifiTipsView)localObject).getVisibility() != 8)
    {
      if (paramLong > 0L)
      {
        if (this.ouR == null)
        {
          this.ouR = AnimationUtils.loadAnimation((Context)getContext(), 2130772109);
          localObject = this.ouR;
          if (localObject != null) {
            ((Animation)localObject).setDuration(paramLong);
          }
        }
        bSu().clearAnimation();
        bSu().startAnimation(this.ouR);
      }
      com.tencent.mm.sdk.platformtools.ar.o((Runnable)new l(this), paramLong);
    }
    AppMethodBeat.o(175516);
  }
  
  public final void Aa(int paramInt)
  {
    AppMethodBeat.i(175508);
    i locali = this.ouz;
    d.g.a.a locala = (d.g.a.a)new w(this);
    d.g.b.p.h(locala, "onUpdateView");
    boolean bool;
    if ((locali.width <= 0) || (locali.height <= 0))
    {
      ae.w("MicroMsg.BizVideoPosHelper", "onWebViewScrollChanged invalid params x=" + locali.x + ", y=" + locali.y + ", width=" + locali.width + ", height=" + locali.height);
      bool = false;
    }
    while (!bool)
    {
      AppMethodBeat.o(175508);
      return;
      int i = locali.oxw;
      locali.oxw = (locali.y - paramInt);
      if (locali.oxw < i) {
        if (locali.oxw > 0) {
          locali.Ai(locali.oxw);
        }
      }
      for (;;)
      {
        bool = true;
        break;
        if ((locali.oxs != 1) && (locali.oxo != locali.lxZ))
        {
          ae.d("MicroMsg.BizVideoPosHelper", "onWebViewScrollChanged currentVideoWidth=" + locali.oxo + ", screenWidth=" + locali.lxZ);
          locali.oxs = 1;
          locali.b(true, (d.g.a.a)new i.c(locala));
          bool = false;
          break;
        }
        bool = locali.Aj(Math.abs(locali.oxw));
        break;
        if (locali.oxw <= i) {
          break label388;
        }
        if (locali.oxw < 0)
        {
          bool = locali.Aj(Math.abs(locali.oxw));
          break;
        }
        if ((locali.oxs != 2) && (locali.oxo != locali.width))
        {
          locali.oxs = 2;
          locali.b(false, (d.g.a.a)new i.d(locala));
          bool = false;
          break;
        }
        locali.Ai(locali.oxw);
      }
      label388:
      bool = false;
    }
    bSz();
    AppMethodBeat.o(175508);
  }
  
  public final void S(Bundle paramBundle)
  {
    AppMethodBeat.i(7172);
    if (this.jEw) {
      bSp().q(false, 0);
    }
    this.ouL.YM("21");
    this.ouL.YM("22");
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.ouL.YL("3"), this.ouL);
    bSD();
    bSE();
    jm(false);
    super.S(paramBundle);
    com.tencent.mm.plugin.webview.h.a.XF(18);
    this.ouF = true;
    AppMethodBeat.o(7172);
  }
  
  public final boolean T(Bundle paramBundle)
  {
    AppMethodBeat.i(7195);
    if (isFinishing())
    {
      AppMethodBeat.o(7195);
      return false;
    }
    if ((paramBundle == null) || (!paramBundle.containsKey("adUrl")))
    {
      ae.w(this.TAG, "createAdWebview url not found");
      AppMethodBeat.o(7195);
      return false;
    }
    if (this.ouA != null)
    {
      ae.w(this.TAG, "createAdWebview adWebView existed!");
      AppMethodBeat.o(7195);
      return false;
    }
    com.tencent.mm.plugin.webview.h.a.XF(28);
    paramBundle = paramBundle.getString("adUrl");
    ae.i(this.TAG, "createAdWebview adWebView url=".concat(String.valueOf(paramBundle)));
    this.ouC = false;
    Object localObject = a.otI;
    localObject = MMWebViewWithJsApi.a.he((Context)getContext());
    d.g.b.p.g(localObject, "MMWebViewWithJsApi.Factory.create(this.context)");
    this.ouA = a.a((MMWebViewWithJsApi)localObject, bRL(), (d.g.a.m)BizVideoDetailUI.f.ova, (d.g.a.m)BizVideoDetailUI.g.ovb, aHI(bRK().Wa()));
    a(this.ouA);
    localObject = this.ouA;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).loadUrl(paramBundle);
    }
    paramBundle = bSq();
    if (paramBundle != null) {
      paramBundle.removeAllViews();
    }
    paramBundle = bSs();
    if (paramBundle != null) {
      paramBundle.addView((View)this.ouA);
    }
    paramBundle = this.ouA;
    if (paramBundle != null) {
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(7195);
    return true;
  }
  
  public final void U(Bundle paramBundle)
  {
    AppMethodBeat.i(7200);
    if ((paramBundle == null) || (!paramBundle.containsKey("data")))
    {
      AppMethodBeat.o(7200);
      return;
    }
    Object localObject = paramBundle.getString("data", "");
    String str = paramBundle.getString("sendTo", "adWeb");
    int j = paramBundle.getInt("webviewId", 0);
    ae.i(this.TAG, "sendMPPageData %s, webviewId = %d", new Object[] { str, Integer.valueOf(j) });
    if (d.g.b.p.i("adWeb", str))
    {
      if (this.ouA == null)
      {
        AppMethodBeat.o(7200);
        return;
      }
      paramBundle = this.ouA;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getJsapi();
        if (paramBundle != null)
        {
          paramBundle.aIa((String)localObject);
          AppMethodBeat.o(7200);
          return;
        }
      }
      AppMethodBeat.o(7200);
      return;
    }
    if (d.g.b.p.i("dot", str))
    {
      if (this.ouB == null)
      {
        AppMethodBeat.o(7200);
        return;
      }
      paramBundle = this.ouB;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label257;
        }
        paramBundle = this.TAG;
        localObject = this.ouB;
        if (localObject == null) {
          break label252;
        }
      }
      label252:
      for (int i = localObject.hashCode();; i = 0)
      {
        ae.i(paramBundle, "sendMPPageData id not match %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(7200);
        return;
        i = 0;
        break;
      }
      label257:
      paramBundle = this.ouB;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getJsapi();
        if (paramBundle != null)
        {
          paramBundle.aIa((String)localObject);
          AppMethodBeat.o(7200);
          return;
        }
      }
      AppMethodBeat.o(7200);
      return;
    }
    paramBundle = this.DRx;
    if (paramBundle != null)
    {
      paramBundle.aIa((String)localObject);
      AppMethodBeat.o(7200);
      return;
    }
    AppMethodBeat.o(7200);
  }
  
  public final void V(Bundle paramBundle)
  {
    AppMethodBeat.i(7208);
    if (this.ouB == null)
    {
      AppMethodBeat.o(7208);
      return;
    }
    if (paramBundle == null) {
      d.g.b.p.gkB();
    }
    int j = paramBundle.getInt("webviewId", 0);
    if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.bTl())
    {
      paramBundle = this.ouB;
      MMWebViewWithJsApi localMMWebViewWithJsApi;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label125;
        }
        paramBundle = this.TAG;
        localMMWebViewWithJsApi = this.ouB;
        if (localMMWebViewWithJsApi == null) {
          break label120;
        }
      }
      label120:
      for (int i = localMMWebViewWithJsApi.hashCode();; i = 0)
      {
        ae.i(paramBundle, "closeDotWebview id not match %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(7208);
        return;
        i = 0;
        break;
      }
    }
    label125:
    ae.i(this.TAG, "closeDotWebview");
    bSE();
    AppMethodBeat.o(7208);
  }
  
  public final void W(Bundle paramBundle)
  {
    AppMethodBeat.i(7209);
    if (this.ouB == null)
    {
      AppMethodBeat.o(7209);
      return;
    }
    if (paramBundle == null) {
      d.g.b.p.gkB();
    }
    int j = paramBundle.getInt("webviewId", 0);
    int i;
    MMWebViewWithJsApi localMMWebViewWithJsApi;
    if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.bTl())
    {
      paramBundle = this.ouB;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label125;
        }
        paramBundle = this.TAG;
        localMMWebViewWithJsApi = this.ouB;
        if (localMMWebViewWithJsApi == null) {
          break label120;
        }
      }
      label120:
      for (i = localMMWebViewWithJsApi.hashCode();; i = 0)
      {
        ae.i(paramBundle, "hideDotWebview id not match %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(7209);
        return;
        i = 0;
        break;
      }
    }
    label125:
    ae.i(this.TAG, "hideDotWebview");
    paramBundle = bSr();
    if ((paramBundle == null) || (paramBundle.getVisibility() != 0))
    {
      ae.i(this.TAG, "dotView not show");
      AppMethodBeat.o(7209);
      return;
    }
    paramBundle = bSr();
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.DRx;
    if (paramBundle != null)
    {
      i = bSO();
      localMMWebViewWithJsApi = this.ouB;
      if (localMMWebViewWithJsApi == null) {
        d.g.b.p.gkB();
      }
      paramBundle.N(i, localMMWebViewWithJsApi.hashCode(), "disappear");
    }
    paramBundle = this.ouB;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getJsapi();
      if (paramBundle != null)
      {
        i = bSO();
        localMMWebViewWithJsApi = this.ouB;
        if (localMMWebViewWithJsApi == null) {
          d.g.b.p.gkB();
        }
        paramBundle.N(i, localMMWebViewWithJsApi.hashCode(), "disappear");
        AppMethodBeat.o(7209);
        return;
      }
    }
    AppMethodBeat.o(7209);
  }
  
  public final void X(Bundle paramBundle)
  {
    AppMethodBeat.i(7210);
    if (this.ouB == null)
    {
      AppMethodBeat.o(7210);
      return;
    }
    if (paramBundle == null) {
      d.g.b.p.gkB();
    }
    int j = paramBundle.getInt("webviewId", 0);
    if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.bTl())
    {
      paramBundle = this.ouB;
      MMWebViewWithJsApi localMMWebViewWithJsApi;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label125;
        }
        paramBundle = this.TAG;
        localMMWebViewWithJsApi = this.ouB;
        if (localMMWebViewWithJsApi == null) {
          break label120;
        }
      }
      label120:
      for (int i = localMMWebViewWithJsApi.hashCode();; i = 0)
      {
        ae.i(paramBundle, "dotWebviewReady id not match %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(7210);
        return;
        i = 0;
        break;
      }
    }
    label125:
    ae.i(this.TAG, "dotWebViewReady %d", new Object[] { Integer.valueOf(j) });
    this.ouD = true;
    com.tencent.mm.plugin.webview.h.a.XF(59);
    AppMethodBeat.o(7210);
  }
  
  public final void Y(Bundle paramBundle)
  {
    AppMethodBeat.i(7211);
    Object localObject1 = this.ouJ;
    int k = bSp().getDuration();
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {
      ae.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData data invalid");
    }
    Object localObject2;
    int m;
    int i;
    for (;;)
    {
      bSP();
      localObject1 = bSp();
      paramBundle = new LinkedList((Collection)this.ouJ.owH);
      d.g.b.p.h(paramBundle, "list");
      localObject1 = ((MPVideoView)localObject1).oAp;
      if (localObject1 != null) {
        ((MPVideoViewControlBar)localObject1).L(paramBundle);
      }
      bSK();
      AppMethodBeat.o(7211);
      return;
      try
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).owH.clear();
        localObject2 = d.z.Nhr;
        paramBundle = paramBundle.getString("data", "");
        ae.d(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData data=".concat(String.valueOf(paramBundle)));
        try
        {
          paramBundle = new JSONObject(paramBundle).optJSONArray("items");
          if (paramBundle == null) {
            ae.w(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "itemList null");
          }
        }
        catch (Exception paramBundle)
        {
          ae.e(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData ex %s", new Object[] { paramBundle.getMessage() });
        }
      }
      finally
      {
        AppMethodBeat.o(7211);
      }
    }
    label238:
    boolean bool;
    if (i < m)
    {
      localObject2 = paramBundle.get(i);
      if (localObject2 == null)
      {
        paramBundle = new d.v("null cannot be cast to non-null type org.json.JSONObject");
        AppMethodBeat.o(7211);
        throw paramBundle;
      }
      localObject2 = (JSONObject)localObject2;
      j = ((JSONObject)localObject2).optInt("id");
      double d1 = ((JSONObject)localObject2).optDouble("startTime");
      double d2 = ((JSONObject)localObject2).optDouble("endTime");
      double d3 = ((JSONObject)localObject2).optDouble("minShowTime");
      String str = ((JSONObject)localObject2).optString("url");
      int n = ((JSONObject)localObject2).optInt("hasShow");
      d.g.b.p.g(str, "url");
      localObject2 = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c(j, d1, d2, d3, str);
      if (n != 1) {
        break label570;
      }
      bool = true;
      label378:
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).owJ = bool;
      if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).owP < ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).owQ) && (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).owP >= 0.0D) && (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).owQ <= k)) {
        break label576;
      }
      ae.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "dotInfo invalid, startTime = " + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).owP + ", endTime=" + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).owQ + ", duration=" + k);
    }
    label561:
    label570:
    label576:
    for (int j = 0;; j = 1)
    {
      if (j == 0)
      {
        ae.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "dotInfo invalid");
      }
      else
      {
        try
        {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).owH.add(localObject2);
          break label561;
        }
        finally
        {
          paramBundle = finally;
          AppMethodBeat.o(7211);
          throw paramBundle;
        }
        ae.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData end %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).owH.size()) });
        break;
      }
      i += 1;
      break label238;
      bool = false;
      break label378;
    }
  }
  
  public final void Z(Bundle paramBundle)
  {
    AppMethodBeat.i(7201);
    if ((paramBundle == null) || (!paramBundle.containsKey("opType")))
    {
      AppMethodBeat.o(7201);
      return;
    }
    paramBundle = paramBundle.getString("opType");
    ae.i(this.TAG, "opPlayer opType= ".concat(String.valueOf(paramBundle)));
    if (paramBundle == null)
    {
      AppMethodBeat.o(7201);
      return;
    }
    switch (paramBundle.hashCode())
    {
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(7201);
        return;
        if (paramBundle.equals("play"))
        {
          bSp().start();
          AppMethodBeat.o(7201);
          return;
          if (paramBundle.equals("stop")) {
            bSp().stop();
          }
        }
      }
    } while (!paramBundle.equals("pause"));
    bSp().pause();
    AppMethodBeat.o(7201);
  }
  
  public final void Z(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(175512);
    d.g.b.p.h(paramMap, "params");
    ae.i(this.TAG, "insertVideoNativeView");
    Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.ouL.YL("8"), this.ouL);
    Object localObject2 = this.ouL;
    localObject1 = this.otF;
    Object localObject3;
    float f1;
    float f2;
    boolean bool;
    label892:
    int i;
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((BaseWebViewController)localObject1).DYj;
      localObject3 = (r)localObject1;
      if (localObject3 != null)
      {
        localObject1 = (d.g.a.b)j.a.a.oxQ;
        long l5 = ((r)localObject3).aMK("getA8KeyStart");
        long l6 = ((r)localObject3).aMK("getA8KeyEnd");
        long l3 = ((r)localObject3).aMK("onPageStarted");
        long l2 = ((r)localObject3).aMK("onPageFinished");
        long l4 = ((r)localObject3).aMK("firstScreenTimestamp");
        long l7 = ((r)localObject3).aMK("firstScreenTime");
        long l1 = l2;
        if (l4 != 0L)
        {
          l1 = l2;
          if (l7 != 0L) {
            l1 = l4;
          }
        }
        l2 = l3;
        if (l4 != 0L)
        {
          l2 = l3;
          if (l7 != 0L) {
            l2 = l4 - l7;
          }
        }
        localObject3 = new es();
        ((es)localObject3).type = 5;
        LinkedList localLinkedList = ((es)localObject3).FLq;
        ev localev = new ev();
        localev.key = "EventType";
        localev.hKR = "6";
        localLinkedList.add(localev);
        localLinkedList = ((es)localObject3).FLq;
        localev = new ev();
        localev.key = "StartTime";
        localev.hKR = ((String)((d.g.a.b)localObject1).invoke(Long.valueOf(l5)));
        localLinkedList.add(localev);
        localLinkedList = ((es)localObject3).FLq;
        localev = new ev();
        localev.key = "EndTime";
        localev.hKR = ((String)((d.g.a.b)localObject1).invoke(Long.valueOf(l6)));
        localLinkedList.add(localev);
        ((j.a)localObject2).oxP.add(localObject3);
        localObject3 = new es();
        ((es)localObject3).type = 5;
        localLinkedList = ((es)localObject3).FLq;
        localev = new ev();
        localev.key = "EventType";
        localev.hKR = "7";
        localLinkedList.add(localev);
        localLinkedList = ((es)localObject3).FLq;
        localev = new ev();
        localev.key = "StartTime";
        localev.hKR = ((String)((d.g.a.b)localObject1).invoke(Long.valueOf(l2)));
        localLinkedList.add(localev);
        localLinkedList = ((es)localObject3).FLq;
        localev = new ev();
        localev.key = "EndTime";
        localev.hKR = ((String)((d.g.a.b)localObject1).invoke(Long.valueOf(l1)));
        localLinkedList.add(localev);
        ((j.a)localObject2).oxP.add(localObject3);
      }
      d(this.osM);
      localObject1 = this.ouz;
      localObject2 = getContext();
      d.g.b.p.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      f1 = this.density;
      d.g.b.p.h(localObject2, "context");
      d.g.b.p.h(paramMap, "params");
      ((i)localObject1).x = ((int)(bu.getInt((String)paramMap.get("x"), 0) * f1) - 2);
      ((i)localObject1).y = ((int)(bu.getInt((String)paramMap.get("y"), 0) * f1) - 2);
      ((i)localObject1).width = ((int)(bu.getInt((String)paramMap.get("width"), 0) * f1) + 4);
      ((i)localObject1).height = ((int)(bu.getInt((String)paramMap.get("height"), 0) * f1) + 4);
      ((i)localObject1).oxv = ((String)paramMap.get("reportParams"));
      float f3 = bu.getFloat((String)paramMap.get("playerMinRatioWhenPlaying"), 1.777778F);
      f2 = bu.getFloat((String)paramMap.get("playerMinRatioWhenNotPlaying"), 1.777778F);
      if (f3 > 0.0F)
      {
        f1 = f3;
        if (f3 < 4.0F) {}
      }
      else
      {
        f1 = 1.777778F;
      }
      if ((f2 <= 0.0F) || (f1 >= 4.0F)) {
        f2 = 1.777778F;
      }
      if ((((i)localObject1).width > 0) && (((i)localObject1).height > 0)) {
        break label1398;
      }
      ae.w("MicroMsg.BizVideoPosHelper", "init invalid params x=" + ((i)localObject1).x + ", y=" + ((i)localObject1).y + ", width=" + ((i)localObject1).width + ", height=" + ((i)localObject1).height);
      bool = false;
      this.ouO = bool;
      this.ota.oud = bu.getInt((String)paramMap.get("landingType"), 0);
      if (this.ouO)
      {
        bRM().addView((View)bSw());
        if ((this.ouz.width > 0) && (this.ouz.height > 0)) {
          eR(this.ouz.width, this.ouz.height);
        }
        bSp().a((ImageView)this.ouk.a(cxA[0]), bRK().hFY.hGe, this.ouz.width, this.ouz.oxn, bRK());
        localObject1 = bSp();
        localObject2 = bRK().hFY.hGe;
        i = this.ouz.width;
        j = this.ouz.oxn;
        localObject3 = bRK();
        d.g.b.p.h(localObject3, "msgInfo");
        paramMap = ((MPVideoView)localObject1).oAo;
        if (paramMap == null) {
          break label1746;
        }
      }
    }
    label1746:
    for (paramMap = paramMap.getCoverIv();; paramMap = null)
    {
      ((MPVideoView)localObject1).a(paramMap, (String)localObject2, i, j, (com.tencent.mm.ah.x)localObject3);
      dG((View)bRM());
      paramMap = bSo();
      d.g.b.p.g(paramMap, "animationLayout");
      dG(paramMap);
      this.ouz.a(0, bSp());
      ae.i(this.TAG, "initVideoParam minVideoHeight " + this.ouz.oxn + " maxVideoHeight " + this.ouz.bEk);
      paramMap = bSo();
      d.g.b.p.g(paramMap, "animationLayout");
      paramMap.setVisibility(0);
      bRJ().bringToFront();
      bSp().setFullScreenDelegate((MPVideoView.b)new o(this));
      bSp().setMPVideoViewCallBack((MPVideoView.c)new p(this));
      ((View)this.ouu.a(cxA[9])).setOnClickListener((View.OnClickListener)new BizVideoDetailUI.q(this));
      getWebView().setOnCustomTouchListener((View.OnTouchListener)new r(this));
      bSp().setTitle(bRK().hFY.title);
      bSp().setPlayBtnOnClickListener((View.OnClickListener)new s(this));
      paramMap = bSt();
      localObject1 = this.ota;
      d.g.b.p.h(localObject1, "controller");
      paramMap.fQH.setOnClickListener((View.OnClickListener)new MPVideoErrorView.a(paramMap, (b)localObject1));
      b(this.ouP);
      AppMethodBeat.o(175512);
      return;
      localObject1 = null;
      break;
      label1398:
      ((i)localObject1).lxZ = com.tencent.mm.cb.a.iu((Context)localObject2);
      if ((((i)localObject1).x <= 0) && (Math.abs(((i)localObject1).lxZ - ((i)localObject1).width) < 10))
      {
        ((i)localObject1).x = 0;
        ((i)localObject1).width = ((i)localObject1).lxZ;
      }
      ((i)localObject1).oxl = ((i)localObject1).x;
      ((i)localObject1).oxm = ((i)localObject1).y;
      ((i)localObject1).oxn = ((i)localObject1).height;
      ((i)localObject1).oxo = ((i)localObject1).width;
      ((i)localObject1).bEk = ((int)(((i)localObject1).lxZ * 1.0F / ((i)localObject1).width * ((i)localObject1).height));
      ((i)localObject1).oxp = ((i)localObject1).bEk;
      ((i)localObject1).oxq = d.k.j.lx((int)(((i)localObject1).lxZ * 1.0F / f1), ((i)localObject1).bEk);
      ((i)localObject1).oxr = d.k.j.lx((int)(((i)localObject1).lxZ * 1.0F / f2), ((i)localObject1).bEk);
      if ((((i)localObject1).oxq == ((i)localObject1).oxr) && (Math.abs(((i)localObject1).oxr - ((i)localObject1).bEk) < 10))
      {
        ((i)localObject1).oxq = ((i)localObject1).bEk;
        ((i)localObject1).oxr = ((i)localObject1).bEk;
      }
      ae.i("MicroMsg.BizVideoPosHelper", "init x=" + ((i)localObject1).x + ", y=" + ((i)localObject1).y + ", width=" + ((i)localObject1).width + ", height=" + ((i)localObject1).height + ", screenWidth=" + ((i)localObject1).lxZ + ", minVideoHeightWhenPlay = " + ((i)localObject1).oxq + ", minVideoHeightWhenPause = " + ((i)localObject1).oxr);
      bool = true;
      break label892;
    }
  }
  
  /* Error */
  public final void a(fg paramfg)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 7
    //   8: sipush 7187
    //   11: invokestatic 386	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_1
    //   15: ifnonnull +48 -> 63
    //   18: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:oxG	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   21: astore_1
    //   22: aload_0
    //   23: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ouL	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   26: ldc_w 2207
    //   29: invokevirtual 1765	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:YL	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/es;
    //   32: astore_1
    //   33: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:oxG	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   36: astore 5
    //   38: aload_1
    //   39: ldc_w 2209
    //   42: ldc_w 2211
    //   45: invokestatic 2214	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload_1
    //   49: aload_0
    //   50: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ouL	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   53: invokestatic 1768	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;)V
    //   56: sipush 7187
    //   59: invokestatic 442	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: return
    //   63: aload_1
    //   64: getfield 2217	com/tencent/mm/protocal/protobuf/fg:FPR	I
    //   67: istore 4
    //   69: aload_0
    //   70: getfield 604	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:ota	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   73: astore 8
    //   75: aload 8
    //   77: iload 4
    //   79: putfield 2220	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:hBZ	I
    //   82: aload 8
    //   84: invokevirtual 2223	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:bSm	()Z
    //   87: ifeq +51 -> 138
    //   90: aload 8
    //   92: getfield 2227	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:otY	Lcom/tencent/mm/ah/x;
    //   95: astore 5
    //   97: aload 5
    //   99: ifnonnull +9 -> 108
    //   102: ldc_w 2097
    //   105: invokestatic 2230	d/g/b/p:bdF	(Ljava/lang/String;)V
    //   108: aload 8
    //   110: getfield 2227	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:otY	Lcom/tencent/mm/ah/x;
    //   113: astore 8
    //   115: aload 8
    //   117: ifnonnull +9 -> 126
    //   120: ldc_w 2097
    //   123: invokestatic 2230	d/g/b/p:bdF	(Ljava/lang/String;)V
    //   126: aload 5
    //   128: aload 8
    //   130: getfield 2231	com/tencent/mm/ah/x:hBZ	I
    //   133: iconst_1
    //   134: ior
    //   135: putfield 2231	com/tencent/mm/ah/x:hBZ	I
    //   138: aload_0
    //   139: getfield 2235	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:otb	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/p;
    //   142: invokevirtual 2240	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/p:Zv	()V
    //   145: aload_0
    //   146: getfield 2241	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:DRx	Lcom/tencent/mm/plugin/webview/c/f;
    //   149: astore 5
    //   151: aload 5
    //   153: ifnull +18 -> 171
    //   156: iload 4
    //   158: iconst_m1
    //   159: if_icmpne +291 -> 450
    //   162: aload 5
    //   164: ldc_w 2243
    //   167: iload_3
    //   168: invokevirtual 2246	com/tencent/mm/plugin/webview/c/f:fL	(Ljava/lang/String;I)V
    //   171: aload_1
    //   172: getfield 2250	com/tencent/mm/protocal/protobuf/fg:FPV	Lcom/tencent/mm/protocal/protobuf/byj;
    //   175: ifnull +24 -> 199
    //   178: aload_0
    //   179: getfield 604	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:ota	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   182: invokevirtual 2223	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:bSm	()Z
    //   185: ifeq +14 -> 199
    //   188: aload_0
    //   189: getfield 604	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:ota	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   192: aload_1
    //   193: getfield 2250	com/tencent/mm/protocal/protobuf/fg:FPV	Lcom/tencent/mm/protocal/protobuf/byj;
    //   196: putfield 2253	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:oue	Lcom/tencent/mm/protocal/protobuf/byj;
    //   199: aload_0
    //   200: getfield 604	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:ota	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   203: aload_1
    //   204: getfield 2254	com/tencent/mm/protocal/protobuf/fg:hCa	Ljava/lang/String;
    //   207: putfield 1362	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:hCa	Ljava/lang/String;
    //   210: aload_0
    //   211: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ouL	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   214: astore 9
    //   216: aload_1
    //   217: getfield 2254	com/tencent/mm/protocal/protobuf/fg:hCa	Ljava/lang/String;
    //   220: astore 8
    //   222: aload 8
    //   224: astore 5
    //   226: aload 8
    //   228: ifnonnull +8 -> 236
    //   231: ldc_w 523
    //   234: astore 5
    //   236: aload 9
    //   238: aload 5
    //   240: putfield 2257	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:oxM	Ljava/lang/String;
    //   243: aload_0
    //   244: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ouL	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   247: aload_0
    //   248: invokevirtual 2260	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:getScene	()I
    //   251: invokestatic 1030	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   254: putfield 2263	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:oxN	Ljava/lang/String;
    //   257: aload_0
    //   258: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ouL	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   261: aload_0
    //   262: invokevirtual 2266	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:getSubScene	()I
    //   265: invokestatic 1030	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   268: putfield 2269	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:oxO	Ljava/lang/String;
    //   271: aload_1
    //   272: getfield 2272	com/tencent/mm/protocal/protobuf/fg:FPU	Ljava/lang/String;
    //   275: astore 5
    //   277: aload 5
    //   279: ifnull +12 -> 291
    //   282: aload_0
    //   283: getfield 604	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:ota	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   286: aload 5
    //   288: putfield 2275	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:otS	Ljava/lang/String;
    //   291: aload_0
    //   292: getfield 604	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:ota	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   295: aload_1
    //   296: getfield 2276	com/tencent/mm/protocal/protobuf/fg:url	Ljava/lang/String;
    //   299: invokevirtual 2279	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:YG	(Ljava/lang/String;)V
    //   302: aload_1
    //   303: getfield 2276	com/tencent/mm/protocal/protobuf/fg:url	Ljava/lang/String;
    //   306: astore 5
    //   308: aload 5
    //   310: ifnull +9 -> 319
    //   313: aload_0
    //   314: aload 5
    //   316: putfield 527	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:fmn	Ljava/lang/String;
    //   319: aload_1
    //   320: getfield 2283	com/tencent/mm/protocal/protobuf/fg:FPT	Lcom/tencent/mm/protocal/protobuf/dwq;
    //   323: ifnull +200 -> 523
    //   326: aload_1
    //   327: getfield 2283	com/tencent/mm/protocal/protobuf/fg:FPT	Lcom/tencent/mm/protocal/protobuf/dwq;
    //   330: getfield 2288	com/tencent/mm/protocal/protobuf/dwq:dxd	I
    //   333: ifeq +190 -> 523
    //   336: aload_0
    //   337: getfield 449	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:TAG	Ljava/lang/String;
    //   340: new 585	java/lang/StringBuilder
    //   343: dup
    //   344: ldc_w 2290
    //   347: invokespecial 589	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   350: aload_1
    //   351: getfield 2283	com/tencent/mm/protocal/protobuf/fg:FPT	Lcom/tencent/mm/protocal/protobuf/dwq;
    //   354: getfield 2293	com/tencent/mm/protocal/protobuf/dwq:dxe	Ljava/lang/String;
    //   357: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: ldc_w 2295
    //   363: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_1
    //   367: getfield 2283	com/tencent/mm/protocal/protobuf/fg:FPT	Lcom/tencent/mm/protocal/protobuf/dwq;
    //   370: getfield 2288	com/tencent/mm/protocal/protobuf/dwq:dxd	I
    //   373: invokevirtual 593	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: invokevirtual 600	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 580	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   382: aload_0
    //   383: invokespecial 1371	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bSt	()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;
    //   386: aload_1
    //   387: getfield 2283	com/tencent/mm/protocal/protobuf/fg:FPT	Lcom/tencent/mm/protocal/protobuf/dwq;
    //   390: getfield 2293	com/tencent/mm/protocal/protobuf/dwq:dxe	Ljava/lang/String;
    //   393: invokevirtual 2298	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView:setPlayError$505cff1c	(Ljava/lang/String;)V
    //   396: aload_0
    //   397: invokespecial 1670	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bSI	()V
    //   400: bipush 32
    //   402: invokestatic 962	com/tencent/mm/plugin/webview/h/a:XF	(I)V
    //   405: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:oxG	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   408: astore_1
    //   409: aload_0
    //   410: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ouL	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   413: ldc_w 2207
    //   416: invokevirtual 1765	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:YL	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/es;
    //   419: astore_1
    //   420: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:oxG	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   423: astore 5
    //   425: aload_1
    //   426: ldc_w 2209
    //   429: ldc_w 2211
    //   432: invokestatic 2214	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Ljava/lang/String;Ljava/lang/String;)V
    //   435: aload_1
    //   436: aload_0
    //   437: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ouL	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   440: invokestatic 1768	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;)V
    //   443: sipush 7187
    //   446: invokestatic 442	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   449: return
    //   450: iload 4
    //   452: bipush 8
    //   454: iand
    //   455: ifne +57 -> 512
    //   458: iconst_1
    //   459: istore_2
    //   460: iload 4
    //   462: bipush 16
    //   464: iand
    //   465: ifne +52 -> 517
    //   468: iconst_1
    //   469: istore 4
    //   471: iload_2
    //   472: ifeq +783 -> 1255
    //   475: iconst_1
    //   476: istore_2
    //   477: iload_2
    //   478: istore_3
    //   479: iload 4
    //   481: ifeq +7 -> 488
    //   484: iload_2
    //   485: iconst_2
    //   486: ior
    //   487: istore_3
    //   488: aload_0
    //   489: getfield 2299	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:TAG	Ljava/lang/String;
    //   492: ldc_w 2301
    //   495: iconst_1
    //   496: anewarray 807	java/lang/Object
    //   499: dup
    //   500: iconst_0
    //   501: iload_3
    //   502: invokestatic 1658	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   505: aastore
    //   506: invokestatic 1665	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   509: goto -347 -> 162
    //   512: iconst_0
    //   513: istore_2
    //   514: goto -54 -> 460
    //   517: iconst_0
    //   518: istore 4
    //   520: goto -49 -> 471
    //   523: aload_0
    //   524: invokespecial 1674	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bSH	()V
    //   527: aload_1
    //   528: getfield 2304	com/tencent/mm/protocal/protobuf/fg:FPZ	Ljava/util/LinkedList;
    //   531: astore 5
    //   533: aload 5
    //   535: ifnull +371 -> 906
    //   538: aload 5
    //   540: checkcast 2306	java/lang/Iterable
    //   543: astore 5
    //   545: new 2308	java/util/ArrayList
    //   548: dup
    //   549: aload 5
    //   551: bipush 10
    //   553: invokestatic 2313	d/a/j:a	(Ljava/lang/Iterable;I)I
    //   556: invokespecial 2315	java/util/ArrayList:<init>	(I)V
    //   559: checkcast 1861	java/util/Collection
    //   562: astore 9
    //   564: aload 5
    //   566: invokeinterface 2319 1 0
    //   571: astore 10
    //   573: aload 10
    //   575: invokeinterface 2324 1 0
    //   580: ifeq +326 -> 906
    //   583: aload 10
    //   585: invokeinterface 2328 1 0
    //   590: checkcast 2330	com/tencent/mm/protocal/protobuf/bwv
    //   593: astore 8
    //   595: getstatic 2336	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:owG	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/a;
    //   598: astore 5
    //   600: aload 8
    //   602: getfield 2337	com/tencent/mm/protocal/protobuf/bwv:url	Ljava/lang/String;
    //   605: astore 5
    //   607: aload 8
    //   609: getfield 2340	com/tencent/mm/protocal/protobuf/bwv:HjK	Ljava/lang/String;
    //   612: astore 11
    //   614: aload 5
    //   616: invokestatic 702	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   619: ifne +11 -> 630
    //   622: aload 11
    //   624: invokestatic 702	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   627: ifeq +26 -> 653
    //   630: getstatic 2341	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:TAG	Ljava/lang/String;
    //   633: ldc_w 2343
    //   636: invokestatic 2345	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: aload 9
    //   641: getstatic 1884	d/z:Nhr	Ld/z;
    //   644: invokeinterface 2346 2 0
    //   649: pop
    //   650: goto -77 -> 573
    //   653: invokestatic 2349	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:bTk	()Z
    //   656: ifne +15 -> 671
    //   659: getstatic 2341	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:TAG	Ljava/lang/String;
    //   662: ldc_w 2351
    //   665: invokestatic 2345	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   668: goto -29 -> 639
    //   671: new 585	java/lang/StringBuilder
    //   674: dup
    //   675: invokespecial 910	java/lang/StringBuilder:<init>	()V
    //   678: getstatic 2355	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:owF	Lcom/tencent/mm/sdk/platformtools/ap;
    //   681: invokevirtual 2360	com/tencent/mm/sdk/platformtools/ap:fnP	()Ljava/lang/Object;
    //   684: checkcast 2362	com/tencent/mm/vfs/k
    //   687: invokevirtual 2365	com/tencent/mm/vfs/k:getPath	()Ljava/lang/String;
    //   690: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: bipush 47
    //   695: invokevirtual 596	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   698: astore 8
    //   700: aload 5
    //   702: invokestatic 2371	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   705: astore 5
    //   707: aload 5
    //   709: ldc_w 2373
    //   712: invokestatic 981	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   715: new 2362	com/tencent/mm/vfs/k
    //   718: dup
    //   719: aload 8
    //   721: aload 5
    //   723: invokevirtual 2376	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   726: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: invokevirtual 600	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: invokespecial 2377	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   735: astore 5
    //   737: aload 5
    //   739: invokevirtual 2380	com/tencent/mm/vfs/k:exists	()Z
    //   742: ifne +25 -> 767
    //   745: new 2362	com/tencent/mm/vfs/k
    //   748: dup
    //   749: aload 5
    //   751: invokevirtual 2383	com/tencent/mm/vfs/k:getParent	()Ljava/lang/String;
    //   754: invokespecial 2377	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   757: invokevirtual 2386	com/tencent/mm/vfs/k:mkdirs	()Z
    //   760: pop
    //   761: aload 5
    //   763: invokevirtual 2389	com/tencent/mm/vfs/k:createNewFile	()Z
    //   766: pop
    //   767: aload 5
    //   769: invokestatic 2395	com/tencent/mm/vfs/o:aj	(Lcom/tencent/mm/vfs/k;)Ljava/io/OutputStream;
    //   772: checkcast 2397	java/io/Closeable
    //   775: astore 8
    //   777: aload 8
    //   779: checkcast 2399	java/io/OutputStream
    //   782: astore 12
    //   784: aload 11
    //   786: ifnull +114 -> 900
    //   789: getstatic 2405	d/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   792: astore 5
    //   794: aload 11
    //   796: ifnonnull +49 -> 845
    //   799: new 835	d/v
    //   802: dup
    //   803: ldc_w 2407
    //   806: invokespecial 838	d/v:<init>	(Ljava/lang/String;)V
    //   809: astore_1
    //   810: sipush 7187
    //   813: invokestatic 442	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   816: aload_1
    //   817: athrow
    //   818: astore 5
    //   820: sipush 7187
    //   823: invokestatic 442	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   826: aload 5
    //   828: athrow
    //   829: astore_1
    //   830: aload 8
    //   832: aload 5
    //   834: invokestatic 2412	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   837: sipush 7187
    //   840: invokestatic 442	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   843: aload_1
    //   844: athrow
    //   845: aload 11
    //   847: aload 5
    //   849: invokevirtual 2416	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   852: astore 5
    //   854: aload 5
    //   856: ldc_w 2418
    //   859: invokestatic 981	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   862: aload 12
    //   864: aload 5
    //   866: invokevirtual 2422	java/io/OutputStream:write	([B)V
    //   869: getstatic 2341	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:TAG	Ljava/lang/String;
    //   872: ldc_w 2424
    //   875: aload 11
    //   877: invokestatic 692	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   880: invokevirtual 696	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   883: invokestatic 2345	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   886: getstatic 1884	d/z:Nhr	Ld/z;
    //   889: astore 5
    //   891: aload 8
    //   893: aconst_null
    //   894: invokestatic 2412	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   897: goto -258 -> 639
    //   900: aconst_null
    //   901: astore 5
    //   903: goto -41 -> 862
    //   906: aload_1
    //   907: getfield 1092	com/tencent/mm/protocal/protobuf/fg:FPM	Ljava/util/LinkedList;
    //   910: checkcast 2426	java/util/List
    //   913: invokestatic 2430	com/tencent/mm/sdk/platformtools/bu:ht	(Ljava/util/List;)Z
    //   916: ifeq +24 -> 940
    //   919: aload_0
    //   920: getfield 449	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:TAG	Ljava/lang/String;
    //   923: ldc_w 2432
    //   926: invokestatic 957	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   929: iconst_4
    //   930: invokestatic 962	com/tencent/mm/plugin/webview/h/a:XF	(I)V
    //   933: sipush 7187
    //   936: invokestatic 442	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   939: return
    //   940: aload_0
    //   941: invokespecial 567	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bSp	()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;
    //   944: astore 9
    //   946: aload_0
    //   947: invokevirtual 992	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bRK	()Lcom/tencent/mm/ah/x;
    //   950: astore 8
    //   952: aload_1
    //   953: getfield 2435	com/tencent/mm/protocal/protobuf/fg:FQa	Ljava/lang/String;
    //   956: astore 7
    //   958: aload 7
    //   960: astore 5
    //   962: aload 7
    //   964: ifnonnull +8 -> 972
    //   967: ldc_w 523
    //   970: astore 5
    //   972: aload 8
    //   974: ldc_w 2097
    //   977: invokestatic 708	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   980: aload 5
    //   982: ldc_w 2437
    //   985: invokestatic 708	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   988: aload 9
    //   990: getfield 1870	com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView:oAp	Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar;
    //   993: astore 7
    //   995: aload 7
    //   997: ifnonnull +6 -> 1003
    //   1000: invokestatic 679	d/g/b/p:gkB	()V
    //   1003: aload 7
    //   1005: aload 8
    //   1007: getfield 2440	com/tencent/mm/ah/x:hFW	Ljava/lang/String;
    //   1010: aload 8
    //   1012: invokevirtual 997	com/tencent/mm/ah/x:Wa	()Ljava/lang/String;
    //   1015: aload 5
    //   1017: invokevirtual 2444	com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar:O	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1020: aload_0
    //   1021: iconst_1
    //   1022: putfield 1075	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ouN	Z
    //   1025: aload_1
    //   1026: getfield 1092	com/tencent/mm/protocal/protobuf/fg:FPM	Ljava/util/LinkedList;
    //   1029: astore 5
    //   1031: aload 5
    //   1033: ldc_w 1094
    //   1036: invokestatic 981	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1039: aload 5
    //   1041: invokestatic 1104	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/k:I	(Ljava/util/LinkedList;)Lcom/tencent/mm/protocal/protobuf/fu;
    //   1044: astore 8
    //   1046: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:oxG	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1049: astore 5
    //   1051: aload_0
    //   1052: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ouL	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   1055: ldc_w 2207
    //   1058: invokevirtual 1765	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:YL	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/es;
    //   1061: astore 7
    //   1063: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:oxG	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1066: astore 5
    //   1068: aload 7
    //   1070: ldc_w 2446
    //   1073: ldc_w 2448
    //   1076: invokestatic 2214	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Ljava/lang/String;Ljava/lang/String;)V
    //   1079: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:oxG	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1082: astore 5
    //   1084: aload 7
    //   1086: ldc_w 2450
    //   1089: ldc_w 2448
    //   1092: invokestatic 2214	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Ljava/lang/String;Ljava/lang/String;)V
    //   1095: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:oxG	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1098: astore 5
    //   1100: aload 8
    //   1102: ifnull +133 -> 1235
    //   1105: aload 8
    //   1107: getfield 1109	com/tencent/mm/protocal/protobuf/fu:FQz	I
    //   1110: invokestatic 1658	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1113: astore 5
    //   1115: aload 7
    //   1117: ldc_w 2452
    //   1120: aload 5
    //   1122: invokestatic 692	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1125: invokestatic 2214	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Ljava/lang/String;Ljava/lang/String;)V
    //   1128: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:oxG	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1131: astore 5
    //   1133: aload 8
    //   1135: ifnull +106 -> 1241
    //   1138: aload 8
    //   1140: getfield 1202	com/tencent/mm/protocal/protobuf/fu:width	I
    //   1143: invokestatic 1658	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1146: astore 5
    //   1148: aload 7
    //   1150: ldc_w 2454
    //   1153: aload 5
    //   1155: invokestatic 692	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1158: invokestatic 2214	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Ljava/lang/String;Ljava/lang/String;)V
    //   1161: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:oxG	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1164: astore 5
    //   1166: aload 6
    //   1168: astore 5
    //   1170: aload 8
    //   1172: ifnull +13 -> 1185
    //   1175: aload 8
    //   1177: getfield 1204	com/tencent/mm/protocal/protobuf/fu:height	I
    //   1180: invokestatic 1658	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1183: astore 5
    //   1185: aload 7
    //   1187: ldc_w 2456
    //   1190: aload 5
    //   1192: invokestatic 692	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1195: invokestatic 2214	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Ljava/lang/String;Ljava/lang/String;)V
    //   1198: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:oxG	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1201: astore 5
    //   1203: aload 7
    //   1205: ldc_w 2209
    //   1208: ldc_w 2448
    //   1211: invokestatic 2214	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Ljava/lang/String;Ljava/lang/String;)V
    //   1214: aload 7
    //   1216: aload_0
    //   1217: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ouL	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   1220: invokestatic 1768	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;)V
    //   1223: aload_0
    //   1224: aload_1
    //   1225: invokespecial 2174	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/fg;)V
    //   1228: sipush 7187
    //   1231: invokestatic 442	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1234: return
    //   1235: aconst_null
    //   1236: astore 5
    //   1238: goto -123 -> 1115
    //   1241: aconst_null
    //   1242: astore 5
    //   1244: goto -96 -> 1148
    //   1247: astore_1
    //   1248: aload 7
    //   1250: astore 5
    //   1252: goto -422 -> 830
    //   1255: iconst_0
    //   1256: istore_2
    //   1257: goto -780 -> 477
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1260	0	this	BizVideoDetailUI
    //   0	1260	1	paramfg	fg
    //   459	798	2	i	int
    //   1	501	3	j	int
    //   67	452	4	k	int
    //   36	757	5	localObject1	Object
    //   818	30	5	localThrowable	Throwable
    //   852	399	5	localObject2	Object
    //   3	1164	6	localObject3	Object
    //   6	1243	7	localObject4	Object
    //   73	1103	8	localObject5	Object
    //   214	775	9	localObject6	Object
    //   571	13	10	localIterator	java.util.Iterator
    //   612	264	11	str	String
    //   782	81	12	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   777	784	818	java/lang/Throwable
    //   789	794	818	java/lang/Throwable
    //   799	818	818	java/lang/Throwable
    //   845	862	818	java/lang/Throwable
    //   862	891	818	java/lang/Throwable
    //   820	829	829	finally
    //   777	784	1247	finally
    //   789	794	1247	finally
    //   799	818	1247	finally
    //   845	862	1247	finally
    //   862	891	1247	finally
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(7173);
    super.b(paramWebView, paramString);
    AppMethodBeat.o(7173);
  }
  
  public final void bAi()
  {
    AppMethodBeat.i(7156);
    super.bAi();
    if (this.lzT != null) {}
    try
    {
      this.ota.ouf.oya = this.lzT.An(bRK().Wa());
      this.ota.ouf.ed(1, 0);
      Object localObject = this.lzT;
      d.g.b.p.g(localObject, "invoker");
      this.uin = ((e)localObject).eVl();
      this.ota.oub = bSy();
      this.ouG = false;
      this.ota.bSj();
      this.ouL.YL("5");
      if (!bu.isNullOrNil(bRK().hFY.title))
      {
        localObject = eWi();
        if (localObject != null) {
          ((com.tencent.mm.plugin.webview.ui.tools.floatball.a)localObject).WY(bRK().hFY.title);
        }
      }
      localObject = eWi();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.webview.ui.tools.floatball.a)localObject).aKo("1");
        AppMethodBeat.o(7156);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.w(this.TAG, "invoker ex :" + localException.getMessage());
      }
      AppMethodBeat.o(7156);
    }
  }
  
  public final boolean bRP()
  {
    return true;
  }
  
  public final void bRQ()
  {
    AppMethodBeat.i(7154);
    super.bRQ();
    setBackBtn((MenuItem.OnMenuItemClickListener)new BizVideoDetailUI.m(this), 2131689492);
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
    es locales = this.ouL.YL("1");
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
    localObject = this.otF;
    boolean bool;
    if (localObject != null)
    {
      bool = ((MpWebViewController)localObject).bRx();
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (localObject = "1";; localObject = "0")
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "MiaoKai", (String)localObject);
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, this.ouL);
      AppMethodBeat.o(7154);
      return;
      bool = false;
      break;
    }
  }
  
  public final void bRR()
  {
    AppMethodBeat.i(175513);
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h localh = this.ouw;
    if (localh != null) {
      localh.release();
    }
    bSQ();
    this.ouJ.reset();
    eWm();
    this.otb.onDestroy();
    int i = bSB();
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.cF(bSF(), i);
    this.ota.onDestroy();
    bSD();
    bSE();
    bSp().onUIDestroy();
    AppMethodBeat.o(175513);
  }
  
  public final void bRV()
  {
    AppMethodBeat.i(7197);
    bSD();
    AppMethodBeat.o(7197);
  }
  
  public final void bRW()
  {
    AppMethodBeat.i(7198);
    ae.i(this.TAG, "adWebviewReady");
    this.ouC = true;
    AppMethodBeat.o(7198);
  }
  
  public final Bundle bRX()
  {
    AppMethodBeat.i(7199);
    Bundle localBundle = new Bundle();
    localBundle.putInt("currentTime", bSp().getCurrPosSec());
    localBundle.putInt("duration", bSp().getDuration());
    localBundle.putString("state", this.ouM);
    localBundle.putLong("playedTotalTime", bSp().getRealPlayTime() / 1000L);
    localBundle.putString("vid", this.ota.hCa);
    AppMethodBeat.o(7199);
    return localBundle;
  }
  
  public final void bSA()
  {
    AppMethodBeat.i(7169);
    com.tencent.mm.plugin.webview.ui.tools.widget.n localn = eWk();
    localn.setMinHeaderHeight(this.ouz.height);
    localn.setUrl(this.fmn);
    localn.eZs();
    localn.a(this.ota.scene, this.ota.otZ, this.ota.hBV, this.ota.otX, this.ota.url, bRK().hFY.title);
    localn.setCallback((n.c)new n(this));
    localn.setTimeLineSessionId(localn.getTimeLineSessionId());
    AppMethodBeat.o(7169);
  }
  
  public final int bSB()
  {
    AppMethodBeat.i(7181);
    Object localObject = bSp();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((MPVideoView)localObject).getCurrPosSec());; localObject = null)
    {
      int j = ((Integer)localObject).intValue();
      localObject = bSp();
      int i = j;
      if (localObject != null)
      {
        i = j;
        if (j == ((MPVideoView)localObject).getDuration()) {
          i = 0;
        }
      }
      AppMethodBeat.o(7181);
      return i;
    }
  }
  
  public final void bSE()
  {
    AppMethodBeat.i(7184);
    if (this.ouB == null)
    {
      AppMethodBeat.o(7184);
      return;
    }
    com.tencent.mm.plugin.webview.h.a.XF(61);
    if (!this.ouD) {
      com.tencent.mm.plugin.webview.h.a.XF(62);
    }
    Object localObject = this.DRx;
    int i;
    MMWebViewWithJsApi localMMWebViewWithJsApi;
    if (localObject != null)
    {
      i = bSO();
      localMMWebViewWithJsApi = this.ouB;
      if (localMMWebViewWithJsApi == null) {
        d.g.b.p.gkB();
      }
      ((com.tencent.mm.plugin.webview.c.f)localObject).N(i, localMMWebViewWithJsApi.hashCode(), "disappear");
    }
    localObject = this.DRx;
    if (localObject != null)
    {
      i = bSO();
      localMMWebViewWithJsApi = this.ouB;
      if (localMMWebViewWithJsApi == null) {
        d.g.b.p.gkB();
      }
      ((com.tencent.mm.plugin.webview.c.f)localObject).N(i, localMMWebViewWithJsApi.hashCode(), "destroy");
    }
    localObject = bSr();
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = bSr();
    if (localObject != null) {
      ((FrameLayout)localObject).removeView((View)this.ouB);
    }
    localObject = this.ouB;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getCurWebviewClient();
      if (!(localObject instanceof com.tencent.mm.plugin.webview.ui.tools.widget.k)) {
        break label223;
      }
      localObject = this.ouB;
      if (localObject == null) {
        break label211;
      }
    }
    label211:
    for (localObject = ((MMWebViewWithJsApi)localObject).getCurWebviewClient();; localObject = null)
    {
      if (localObject != null) {
        break label216;
      }
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewClient");
      AppMethodBeat.o(7184);
      throw ((Throwable)localObject);
      localObject = null;
      break;
    }
    label216:
    ((com.tencent.mm.plugin.webview.ui.tools.widget.k)localObject).cleanup();
    label223:
    localObject = this.ouB;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).destroy();
    }
    localObject = this.ouB;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebChromeClient(null);
    }
    localObject = this.ouB;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebViewClient(null);
    }
    localObject = this.ouB;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnTouchListener(null);
    }
    localObject = this.ouB;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnLongClickListener(null);
    }
    localObject = this.ouB;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setVisibility(8);
    }
    localObject = this.ouB;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).removeAllViews();
    }
    localObject = this.ouB;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).clearView();
    }
    this.ouB = null;
    this.ouD = false;
    localObject = this.ouI;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).del = false;
    }
    localObject = this.ouI;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).owM = false;
    }
    this.ouI = null;
    AppMethodBeat.o(7184);
  }
  
  public final int bSO()
  {
    AppMethodBeat.i(7212);
    if (this.ouI == null)
    {
      AppMethodBeat.o(7212);
      return -1;
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c localc = this.ouI;
    if (localc == null) {
      d.g.b.p.gkB();
    }
    int i = localc.id;
    AppMethodBeat.o(7212);
    return i;
  }
  
  public final void bSP()
  {
    AppMethodBeat.i(7213);
    if ((this.ouH) || (bSp().getCurrPosSec() <= 0))
    {
      AppMethodBeat.o(7213);
      return;
    }
    float f = bSp().getCurrPosMs() / 1000.0F;
    if ((this.ouB != null) && (this.ouJ.b(f, this.ouI)))
    {
      localObject = this.ouI;
      if (localObject == null) {
        d.g.b.p.gkB();
      }
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).del)
      {
        if (com.tencent.mm.sdk.platformtools.j.DEBUG) {
          ae.d(this.TAG, "dot end, wait h5 to close");
        }
        if (System.currentTimeMillis() - this.ouT >= 1000L)
        {
          ae.i(this.TAG, "dot end, time out to close");
          bSE();
        }
        AppMethodBeat.o(7213);
        return;
      }
      ae.i(this.TAG, "destroyDotWebView");
      localObject = bSr();
      if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
      {
        localObject = this.ouB;
        if (localObject == null) {
          break label267;
        }
      }
    }
    label267:
    for (Object localObject = ((MMWebViewWithJsApi)localObject).getJsapi();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = this.ouB;
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        if (((com.tencent.mm.plugin.webview.c.f)localObject).isReady()) {
          break;
        }
      }
      bSE();
      if (this.ouI == null) {
        break label360;
      }
      if (this.ouD)
      {
        localObject = bSr();
        if (((localObject == null) || (((FrameLayout)localObject).getVisibility() != 0)) && (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.a(f, this.ouI))) {
          bSN();
        }
      }
      AppMethodBeat.o(7213);
      return;
    }
    localObject = this.ouI;
    if (localObject == null) {
      d.g.b.p.gkB();
    }
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).del = true;
    this.ouT = System.currentTimeMillis();
    localObject = this.ouB;
    int i;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
      if (localObject != null)
      {
        i = bSO();
        MMWebViewWithJsApi localMMWebViewWithJsApi = this.ouB;
        if (localMMWebViewWithJsApi == null) {
          d.g.b.p.gkB();
        }
        ((com.tencent.mm.plugin.webview.c.f)localObject).N(i, localMMWebViewWithJsApi.hashCode(), "end");
        AppMethodBeat.o(7213);
        return;
      }
    }
    AppMethodBeat.o(7213);
    return;
    label360:
    this.ouI = this.ouJ.aU(f);
    if (this.ouI != null)
    {
      i = bSO();
      localObject = this.ouI;
      if (localObject == null) {
        d.g.b.p.gkB();
      }
      aF(i, ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).url);
    }
    AppMethodBeat.o(7213);
  }
  
  public final void bSx()
  {
    AppMethodBeat.i(7153);
    this.ouL.bTp();
    super.bSx();
    if (!this.ouK)
    {
      this.ouK = true;
      com.tencent.mm.pluginsdk.h.q((MMActivity)this);
      com.tencent.mm.plugin.webview.h.a.XF(0);
    }
    getIntent().putExtra("vertical_scroll", false);
    AppMethodBeat.o(7153);
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(7177);
    if (this.jEw)
    {
      int i = getRequestedOrientation();
      AppMethodBeat.o(7177);
      return i;
    }
    AppMethodBeat.o(7177);
    return 1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(7155);
    super.initView();
    if (bRK().hFY == null)
    {
      finish();
      ae.w(this.TAG, "onCreate msgInfo.item is null");
      AppMethodBeat.o(7155);
      return;
    }
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("onCreate rawUrl is ");
    Object localObject3 = bRK().hFY;
    if (localObject3 == null) {
      d.g.b.p.gkB();
    }
    ae.i((String)localObject1, ((com.tencent.mm.ah.v)localObject3).url);
    localObject3 = this.ouL;
    localObject1 = bRK().hFY;
    if (localObject1 == null) {
      d.g.b.p.gkB();
    }
    localObject2 = ((com.tencent.mm.ah.v)localObject1).url;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((j.a)localObject3).oxL = ((String)localObject1);
    this.ouL.oxJ = String.valueOf(bRN());
    this.ouL.oxK = String.valueOf(System.currentTimeMillis() / 1000L);
    localObject1 = this.ota;
    localObject2 = this.kis;
    d.g.b.p.h(localObject2, "callback");
    ((b)localObject1).kis = ((IPCRunCgi.a)localObject2);
    localObject1 = this.otb;
    localObject2 = (TmplShareWebViewToolUI)this;
    localObject3 = bRK();
    Object localObject4 = this.ota;
    d.g.b.p.h(localObject2, "ui");
    d.g.b.p.h(localObject3, "msgInfo");
    d.g.b.p.h(localObject4, "controller");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p)localObject1).lZK = new WeakReference(localObject2);
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p)localObject1).otY = ((com.tencent.mm.ah.x)localObject3);
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p)localObject1).ovq = ((b)localObject4);
    this.ota.oua = ((Number)this.oti.a(TmplShareWebViewToolUI.cxA[8])).intValue();
    this.ota.ouf.oxf = new WeakReference(bSp());
    localObject1 = this.ota;
    localObject3 = (TmplShareWebViewToolUI)this;
    int i = getScene();
    int j = getSubScene();
    localObject4 = bRK().hFY;
    if (localObject4 == null) {
      d.g.b.p.gkB();
    }
    localObject2 = bRK();
    int k = bRN();
    d.g.b.p.h(localObject3, "ui");
    d.g.b.p.h(localObject4, "readerItem");
    d.g.b.p.h(localObject2, "msgInfo");
    ((b)localObject1).lZK = new WeakReference(localObject3);
    ((b)localObject1).scene = i;
    ((b)localObject1).otZ = j;
    ((b)localObject1).YG(((com.tencent.mm.ah.v)localObject4).url);
    ((b)localObject1).oif = ((com.tencent.mm.ah.v)localObject4);
    ((b)localObject1).otY = ((com.tencent.mm.ah.x)localObject2);
    ((b)localObject1).hBV = ((com.tencent.mm.ah.v)localObject4).type;
    ((b)localObject1).otX = k;
    ((b)localObject1).dpP = ((com.tencent.mm.ah.x)localObject2).dpP;
    ((b)localObject1).otR = ((com.tencent.mm.ah.x)localObject2).hFW;
    ((b)localObject1).hCa = ((com.tencent.mm.ah.x)localObject2).hFY.hCa;
    localObject3 = ((b)localObject1).otT;
    d.g.b.p.h(localObject1, "controller");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.n)localObject3).ovq = ((b)localObject1);
    localObject3 = ((b)localObject1).ouf;
    d.g.b.p.h(localObject1, "controller");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject3).ovq = ((b)localObject1);
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject3).oyb = true;
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject3).oxZ = "";
    try
    {
      localObject2 = Uri.parse(((com.tencent.mm.ah.x)localObject2).hFY.url);
      ((b)localObject1).hGH = bu.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
      ((b)localObject1).idx = bu.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
      ae.i(((b)localObject1).TAG, "init vid=" + ((b)localObject1).hCa);
      localObject3 = this.ota;
      localObject2 = getIntent().getStringExtra("biz_video_channel_session_id");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      d.g.b.p.h(localObject1, "<set-?>");
      ((b)localObject3).ouc = ((String)localObject1);
      com.tencent.mm.plugin.webview.h.a.XF(1);
      this.ouJ.reset();
      this.Ewp.setMMOverScrollOffsetListener((LogoWebViewWrapper.b)new x(this));
      this.Ewp.eWa();
      this.Ewp.eWb();
      this.ouN = false;
      this.ouO = false;
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ((IntentFilter)localObject1).setPriority(2147483647);
      if (this.ouW == null) {
        this.ouW = ((BroadcastReceiver)new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(7132);
            d.g.b.p.h(paramAnonymousContext, "context");
            if ((paramAnonymousIntent == null) || (bu.isNullOrNil(paramAnonymousIntent.getAction())) || (!this.ouZ.ouG) || ((BizVideoDetailUI.k(this.ouZ).otW) && (!BizVideoDetailUI.v(this.ouZ))))
            {
              AppMethodBeat.o(7132);
              return;
            }
            boolean bool1 = az.isNetworkConnected(ak.getContext());
            if ((!BizVideoDetailUI.w(this.ouZ)) && (bool1))
            {
              paramAnonymousContext = BizVideoDetailUI.f(this.ouZ);
              paramAnonymousIntent = paramAnonymousContext.oAo;
              if (paramAnonymousIntent == null) {
                d.g.b.p.gkB();
              }
              if (paramAnonymousIntent.isPlaying())
              {
                paramAnonymousIntent = paramAnonymousContext.oAo;
                if (paramAnonymousIntent == null) {
                  d.g.b.p.gkB();
                }
                if (paramAnonymousIntent.lxB == null) {
                  break label421;
                }
                paramAnonymousIntent = paramAnonymousIntent.lxB;
                if (paramAnonymousIntent == null) {
                  d.g.b.p.gkB();
                }
                if (paramAnonymousIntent.getVisibility() != 0) {
                  break label421;
                }
              }
            }
            label421:
            for (int i = 1;; i = 0)
            {
              if (i != 0)
              {
                paramAnonymousIntent = paramAnonymousContext.oAo;
                if (paramAnonymousIntent == null) {
                  d.g.b.p.gkB();
                }
                if (paramAnonymousIntent.bTI())
                {
                  paramAnonymousIntent = paramAnonymousContext.oAo;
                  if (paramAnonymousIntent == null) {
                    d.g.b.p.gkB();
                  }
                  paramAnonymousContext = paramAnonymousContext.oAo;
                  if (paramAnonymousContext == null) {
                    d.g.b.p.gkB();
                  }
                  paramAnonymousIntent.V(paramAnonymousContext.getCurrPosMs(), true);
                }
              }
              BizVideoDetailUI.c(this.ouZ, bool1);
              bool1 = az.isWifi(ak.getContext());
              i = BizVideoDetailUI.x(this.ouZ);
              BizVideoDetailUI.a(this.ouZ, BizVideoDetailUI.y(this.ouZ));
              boolean bool2 = BizVideoDetailUI.b(this.ouZ, BizVideoDetailUI.f(this.ouZ).getDuration());
              ae.i(BizVideoDetailUI.m(this.ouZ), "net type change simcardTpye=" + BizVideoDetailUI.x(this.ouZ) + ", lastSimcardType=" + i + ", is wifi=" + bool1 + ", show=" + bool2);
              if (!bool2) {
                break label441;
              }
              paramAnonymousContext = BizVideoDetailUI.i(this.ouZ);
              d.g.b.p.g(paramAnonymousContext, "videoWifiTipsView");
              if (paramAnonymousContext.getVisibility() == 0) {
                break label449;
              }
              if ((!BizVideoDetailUI.f(this.ouZ).isPlaying()) || (this.ouZ.ouH) || ((BizVideoDetailUI.f(this.ouZ).bTQ()) && (BizVideoDetailUI.f(this.ouZ).bnx()))) {
                break;
              }
              BizVideoDetailUI.b(this.ouZ, true);
              AppMethodBeat.o(7132);
              return;
            }
            this.ouZ.ouE = true;
            AppMethodBeat.o(7132);
            return;
            label441:
            BizVideoDetailUI.a(this.ouZ, 0L);
            label449:
            AppMethodBeat.o(7132);
          }
        });
      }
      getContext().registerReceiver(this.ouW, (IntentFilter)localObject1);
      AppMethodBeat.o(7155);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        ae.w(((b)localObject1).TAG, "init parse url exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.w(((b)localObject1).TAG, "init parse url exp %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void jm(boolean paramBoolean)
  {
    AppMethodBeat.i(7166);
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h localh = this.ouw;
    if (localh != null)
    {
      ae.i("MicroMsg.BizVideoOrientationHelper", "enable :".concat(String.valueOf(paramBoolean)));
      if (localh.axU())
      {
        Object localObject;
        if (paramBoolean)
        {
          localh.oxi.enable();
          if (localh.mSensorManager == null)
          {
            localObject = ak.getContext().getSystemService("sensor");
            if (localObject == null)
            {
              localObject = new d.v("null cannot be cast to non-null type android.hardware.SensorManager");
              AppMethodBeat.o(7166);
              throw ((Throwable)localObject);
            }
            localh.mSensorManager = ((SensorManager)localObject);
            localObject = localh.mSensorManager;
            if (localObject != null) {}
            for (localObject = ((SensorManager)localObject).getDefaultSensor(1);; localObject = null)
            {
              localh.oxg = ((Sensor)localObject);
              localObject = localh.mSensorManager;
              if (localObject == null) {
                break;
              }
              ((SensorManager)localObject).registerListener((SensorEventListener)localh, localh.oxg, 3);
              AppMethodBeat.o(7166);
              return;
            }
            AppMethodBeat.o(7166);
          }
        }
        else
        {
          localh.oxi.disable();
          localObject = localh.kwC.get();
          if (localObject == null)
          {
            localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(7166);
            throw ((Throwable)localObject);
          }
          ((MMActivity)localObject).setRequestedOrientation(1);
          localh.hwP = 0;
        }
      }
      AppMethodBeat.o(7166);
      return;
    }
    AppMethodBeat.o(7166);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(7194);
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p localp = this.otb;
    Object localObject3;
    int i;
    if (paramInt1 == 1) {
      if (paramInt2 == -1)
      {
        localObject2 = (Context)localp.bSl();
        localObject3 = localp.bSl();
        if (localObject3 != null) {
          localObject1 = ((TmplShareWebViewToolUI)localObject3).getString(2131756660);
        }
        com.tencent.mm.ui.base.h.cj((Context)localObject2, (String)localObject1);
        if (localp.oyz)
        {
          i = 11;
          localObject1 = localp.ovq;
          if (localObject1 == null) {
            d.g.b.p.bdF("controller");
          }
          ((b)localObject1).otT.aG(i, localp.oyB);
        }
      }
      else
      {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label257;
      }
      AppMethodBeat.o(7194);
      return;
      i = 2;
      break;
      if (paramInt1 == 2)
      {
        if (paramInt2 == -1) {
          if (paramIntent == null) {
            break label245;
          }
        }
        label245:
        for (localObject1 = paramIntent.getStringExtra("Select_Conv_User");; localObject1 = null)
        {
          if (paramIntent != null) {
            localObject2 = paramIntent.getStringExtra("custom_send_text");
          }
          if (localObject1 != null)
          {
            localObject3 = g.oxe;
            localObject3 = localp.otY;
            if (localObject3 == null) {
              d.g.b.p.bdF("msgInfo");
            }
            b localb = localp.ovq;
            if (localb == null) {
              d.g.b.p.bdF("controller");
            }
            g.a((String)localObject1, (com.tencent.mm.ah.x)localObject3, (String)localObject2, localb, (com.tencent.mm.ipcinvoker.d)new p.a(localp));
          }
          i = 1;
          break;
        }
      }
      i = 0;
    }
    label257:
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(7194);
  }
  
  public void onBackPressed()
  {
    int i = 1;
    AppMethodBeat.i(7185);
    if (this.jEw)
    {
      bSp().q(false, 0);
      AppMethodBeat.o(7185);
      return;
    }
    com.tencent.mm.plugin.webview.ui.tools.widget.n localn = eWk();
    if ((localn.getSayFooter().eZq()) && (localn.bnS())) {
      localn.getSayFooter().ehh();
    }
    for (;;)
    {
      if (i == 0) {
        super.onBackPressed();
      }
      AppMethodBeat.o(7185);
      return;
      if ((localn.Ewz != -3) && (localn.bnS())) {
        localn.hide();
      } else {
        i = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7179);
    this.ouL.YM("21");
    this.ouL.YM("22");
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.ouL.YL("2"), this.ouL);
    bSC();
    super.onDestroy();
    localObject = this.oux;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.widget.a)localObject).b(this.ouS);
    }
    bRR();
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.YK(((BizVideoDetailUI)this).toString());
    AppMethodBeat.o(7179);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(7186);
    ae.i(this.TAG, "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.jEw))
    {
      bSp().q(false, 0);
      AppMethodBeat.o(7186);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(7186);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(7174);
    super.onPause();
    Object localObject = bSp();
    ae.i(MPVideoView.TAG, "onUIPause");
    localObject = ((MPVideoView)localObject).oAo;
    if (localObject == null) {
      d.g.b.p.gkB();
    }
    ((MPExoVideoWrapper)localObject).ozF = true;
    ((MPExoVideoWrapper)localObject).ozB.abn();
    ((MPExoVideoWrapper)localObject).setKeepScreenOn(false);
    ((MPExoVideoWrapper)localObject).lxK = ((MPExoVideoWrapper)localObject).isPlaying();
    ((MPExoVideoWrapper)localObject).pause();
    ((MPExoVideoWrapper)localObject).lxy = false;
    AppMethodBeat.o(7174);
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(7180);
    bSC();
    bRR();
    super.onReset();
    AppMethodBeat.o(7180);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(7170);
    super.onResume();
    Object localObject = bSp();
    ae.i(MPVideoView.TAG, "onUIResume");
    if (((MPVideoView)localObject).lpO)
    {
      ae.i(MPVideoView.TAG, "onUIResume, should skip ui resume");
      ((MPVideoView)localObject).lpO = false;
      AppMethodBeat.o(7170);
      return;
    }
    localObject = ((MPVideoView)localObject).oAo;
    if (localObject == null) {
      d.g.b.p.gkB();
    }
    ((MPExoVideoWrapper)localObject).ozF = false;
    ((MPExoVideoWrapper)localObject).lxy = true;
    if ((((MPExoVideoWrapper)localObject).ozz != null) && (((MPExoVideoWrapper)localObject).cvl) && ((((MPExoVideoWrapper)localObject).lxK) || (((MPExoVideoWrapper)localObject).ozD)))
    {
      ae.i(MPExoVideoWrapper.TAG, "onUIResume, isPlayOnUiPause =" + ((MPExoVideoWrapper)localObject).lxK + ", mPlayingWhenBackground " + ((MPExoVideoWrapper)localObject).ozD);
      ((MPExoVideoWrapper)localObject).start();
    }
    AppMethodBeat.o(7170);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(7171);
    super.onStart();
    if (bRK().hFY == null)
    {
      finish();
      ae.w(this.TAG, "onStart msgInfo.item is null");
      AppMethodBeat.o(7171);
      return;
    }
    ae.i(this.TAG, "alvinluo onStart handleAnimation coverUrl: %s", new Object[] { bRK().hFY.hGe });
    bRJ().bringToFront();
    bSp().bTE();
    AppMethodBeat.o(7171);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<FrameLayout>
  {
    a(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class aa
    extends d.g.b.q
    implements d.g.a.a<View>
  {
    aa(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ab
    extends d.g.b.q
    implements d.g.a.a<LinearLayout>
  {
    ab(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ac
    extends d.g.b.q
    implements d.g.a.a<MPVideoErrorView>
  {
    ac(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "invoke"})
  static final class ad
    extends d.g.b.q
    implements d.g.a.a<MPVideoView>
  {
    ad(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
  static final class ae
    extends d.g.b.q
    implements d.g.a.a<FrameLayout>
  {
    ae(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class af
    extends d.g.b.q
    implements d.g.a.a<MPVideoWifiTipsView>
  {
    af(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<ImageView>
  {
    b(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<View>
  {
    c(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<FrameLayout>
  {
    d(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class e
    implements IPCRunCgi.a
  {
    e(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(7087);
      BizVideoDetailUI.k(this.ouZ).bSk();
      if (paramb == null)
      {
        AppMethodBeat.o(7087);
        return;
      }
      ae.i(BizVideoDetailUI.m(this.ouZ), "onSceneEnd errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString + ", type: " + paramb.getType());
      Object localObject = paramb.aEU();
      if ((((localObject instanceof ff)) && (((ff)localObject).FPc != BizVideoDetailUI.k(this.ouZ).otX)) || (((localObject instanceof fe)) && (((fe)localObject).FPc != BizVideoDetailUI.k(this.ouZ).otX)))
      {
        AppMethodBeat.o(7087);
        return;
      }
      if (paramb.getType() == 1179)
      {
        this.ouZ.ouG = true;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          BizVideoDetailUI.s(this.ouZ);
          paramString = paramb.aEV();
          if (paramString == null)
          {
            paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgGetResp");
            AppMethodBeat.o(7087);
            throw paramString;
          }
          paramString = (fg)paramString;
          paramb = BizVideoDetailUI.m(this.ouZ);
          localObject = new StringBuilder("url_info size is ");
          LinkedList localLinkedList;
          if (paramString.FPM != null)
          {
            localLinkedList = paramString.FPM;
            if (localLinkedList == null) {
              d.g.b.p.gkB();
            }
          }
          for (paramInt1 = localLinkedList.size();; paramInt1 = 0)
          {
            ae.i(paramb, paramInt1);
            if ((paramString.FPN == 0) || (bu.isNullOrNil(paramString.FPO))) {
              break;
            }
            ae.i(BizVideoDetailUI.m(this.ouZ), "onSceneEnd redirect %s", new Object[] { paramString.FPO });
            paramb = this.ouZ;
            paramString = paramString.FPO;
            d.g.b.p.g(paramString, "resp.redirect_url");
            paramb.YF(paramString);
            AppMethodBeat.o(7087);
            return;
          }
          this.ouZ.a(paramString);
          AppMethodBeat.o(7087);
          return;
        }
        this.ouZ.a(null);
        BizVideoDetailUI.q(this.ouZ);
        paramb = BizVideoDetailUI.p(this.ouZ);
        paramb.ovm.setBackgroundResource(2131231310);
        if (!bu.isNullOrNil(paramString)) {
          paramb.ovl.setText((CharSequence)(paramb.getContext().getString(2131761343) + ' ' + paramString));
        }
        for (;;)
        {
          paramb.fQH.setClickable(true);
          if (paramInt1 != 2) {
            break;
          }
          com.tencent.mm.plugin.webview.h.a.XF(2);
          AppMethodBeat.o(7087);
          return;
          paramb.ovl.setText((CharSequence)paramb.getContext().getString(2131761343));
        }
        com.tencent.mm.plugin.webview.h.a.XF(3);
        AppMethodBeat.o(7087);
        return;
      }
      AppMethodBeat.o(7087);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "posInfo", "", "webvieId", "", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.m<String, Integer, d.z>
  {
    h(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Lcom/tencent/xweb/WebView;", "url", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.m<WebView, String, d.z>
  {
    i(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.a<FrameLayout>
  {
    j(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "onExitFullscreen", "", "plugin-brandservice_release"})
  public static final class k
    extends com.tencent.mm.plugin.brandservice.ui.widget.b
  {
    public final void DD()
    {
      AppMethodBeat.i(7099);
      BizVideoDetailUI.a(this.ouZ, false);
      if (BizVideoDetailUI.f(this.ouZ).getParent() == null) {
        BizVideoDetailUI.e(this.ouZ).addView((View)BizVideoDetailUI.f(this.ouZ), 0);
      }
      AppMethodBeat.o(7099);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(175501);
      MPVideoWifiTipsView localMPVideoWifiTipsView = BizVideoDetailUI.i(this.ouZ);
      d.g.b.p.g(localMPVideoWifiTipsView, "videoWifiTipsView");
      localMPVideoWifiTipsView.setVisibility(8);
      AppMethodBeat.o(175501);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initComment$1$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "onHide", "", "onShow", "plugin-brandservice_release"})
  public static final class n
    implements n.c
  {
    n(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void onHide()
    {
      AppMethodBeat.i(7103);
      BizVideoDetailUI.a(this.ouZ, this.ouZ.ouz.width, this.ouZ.ouz.height);
      AppMethodBeat.o(7103);
    }
    
    public final void onShow()
    {
      AppMethodBeat.i(7104);
      this.ouZ.jm(false);
      AppMethodBeat.o(7104);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "enterFullScreen", "", "direction", "", "quitFullScreen", "plugin-brandservice_release"})
  public static final class o
    implements MPVideoView.b
  {
    public final void blp()
    {
      AppMethodBeat.i(7107);
      BizVideoDetailUI.a(this.ouZ, "exitFullScreen", "");
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
      localObject = BizVideoDetailUI.d(this.ouZ).YL("18");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, "FullScreenSwitch", "2");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, BizVideoDetailUI.d(this.ouZ));
      com.tencent.mm.plugin.ball.f.f.bMs();
      BizVideoDetailUI.g(this.ouZ).aYo();
      this.ouZ.setRequestedOrientation(1);
      BizVideoDetailUI.k(this.ouZ).ouf.ed(6, 0);
      localObject = BizVideoDetailUI.j(this.ouZ);
      d.g.b.p.g(localObject, "videoAdTitleBar");
      ((LinearLayout)localObject).setVisibility(8);
      BizVideoDetailUI.l(this.ouZ);
      AppMethodBeat.o(7107);
    }
    
    public final boolean isFullScreen()
    {
      AppMethodBeat.i(7105);
      boolean bool = BizVideoDetailUI.c(this.ouZ);
      AppMethodBeat.o(7105);
      return bool;
    }
    
    public final void th(int paramInt)
    {
      AppMethodBeat.i(7106);
      BizVideoDetailUI.a(this.ouZ, "enterFullScreen", "");
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
      localObject = BizVideoDetailUI.d(this.ouZ).YL("18");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, "FullScreenSwitch", "1");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, BizVideoDetailUI.d(this.ouZ));
      com.tencent.mm.plugin.ball.f.f.bMt();
      BizVideoDetailUI.e(this.ouZ).removeView((View)BizVideoDetailUI.f(this.ouZ));
      this.ouZ.ouz.a(-16777216, BizVideoDetailUI.f(this.ouZ));
      BizVideoDetailUI.a(this.ouZ, true);
      BizVideoDetailUI.g(this.ouZ).O((View)BizVideoDetailUI.f(this.ouZ), paramInt);
      if ((paramInt == 0) || (paramInt == 180)) {
        BizVideoDetailUI.f(this.ouZ).setPageGestureInFullscreen(false);
      }
      for (;;)
      {
        localObject = BizVideoDetailUI.h(this.ouZ);
        if ((localObject == null) || (((FrameLayout)localObject).getVisibility() != 0))
        {
          localObject = BizVideoDetailUI.i(this.ouZ);
          d.g.b.p.g(localObject, "videoWifiTipsView");
          if (((MPVideoWifiTipsView)localObject).getVisibility() != 0) {}
        }
        else
        {
          localObject = BizVideoDetailUI.j(this.ouZ);
          d.g.b.p.g(localObject, "videoAdTitleBar");
          ((LinearLayout)localObject).setVisibility(0);
        }
        BizVideoDetailUI.k(this.ouZ).ouf.ed(5, 0);
        BizVideoDetailUI.l(this.ouZ);
        AppMethodBeat.o(7106);
        return;
        BizVideoDetailUI.f(this.ouZ).setPageGestureInFullscreen(true);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$2", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "bufferResolutionStartTime", "", "getBufferResolutionStartTime", "()J", "setBufferResolutionStartTime", "(J)V", "bufferSeekStartTime", "getBufferSeekStartTime", "setBufferSeekStartTime", "hasBufferingResolution", "", "getHasBufferingResolution", "()Z", "setHasBufferingResolution", "(Z)V", "hasBufferingSeek", "getHasBufferingSeek", "setHasBufferingSeek", "playEnd", "getPlayEnd", "setPlayEnd", "startPlayTime", "getStartPlayTime", "setStartPlayTime", "startWaitTime", "getStartWaitTime", "setStartWaitTime", "onControlbarVisible", "", "visible", "onEndDragProgress", "onGetVideoSize", "width", "", "height", "onHideSwitchResolutionLayout", "onHideSwitchSpeedLayout", "onPlayError", "errorMsg", "", "errorCode", "onSeekPre", "onSeekTo", "time", "onStartDragProgress", "onUpdateProgress", "progressLen", "totalLen", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoPrepare", "firstRenderTime", "onVideoWaiting", "onVideoWaitingEnd", "resolutionBtnClick", "speedBtnClick", "switchResolution", "beforeType", "afterType", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "switchSpeed", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
  public static final class p
    implements MPVideoView.c
  {
    private long hOz = -1L;
    private long ovc = -1L;
    private boolean ovd;
    private long ove = -1L;
    private long ovf = -1L;
    private boolean ovg;
    private boolean ovh;
    
    public final void YH(String paramString)
    {
      AppMethodBeat.i(7117);
      d.g.b.p.h(paramString, "errorMsg");
      BizVideoDetailUI.k(this.ouZ).ouf.oxZ = paramString;
      BizVideoDetailUI.k(this.ouZ).ouf.ed(11, 0);
      BizVideoDetailUI.p(this.ouZ).setPlayError$505cff1c(paramString);
      BizVideoDetailUI.q(this.ouZ);
      BizVideoDetailUI.a(this.ouZ, "error", paramString);
      if (BizVideoDetailUI.f(this.ouZ).getPlayStarted()) {
        com.tencent.mm.plugin.webview.h.a.XF(25);
      }
      for (;;)
      {
        BizVideoDetailUI.d(this.ouZ).YM("21");
        BizVideoDetailUI.d(this.ouZ).YM("22");
        Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
        localObject = BizVideoDetailUI.d(this.ouZ).YL("16");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, "PlayErrReason", paramString);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, BizVideoDetailUI.d(this.ouZ));
        AppMethodBeat.o(7117);
        return;
        com.tencent.mm.plugin.webview.h.a.XF(24);
      }
    }
    
    public final void a(int paramInt1, int paramInt2, fu paramfu)
    {
      Object localObject2 = null;
      AppMethodBeat.i(175503);
      this.ouZ.ouH = true;
      BizVideoDetailUI.k(this.ouZ).ouf.oyd = paramInt1;
      BizVideoDetailUI.k(this.ouZ).ouf.oyc = paramInt2;
      BizVideoDetailUI.k(this.ouZ).ouf.ed(22, 0);
      BizVideoDetailUI.d(this.ouZ).YM("21");
      BizVideoDetailUI.d(this.ouZ).YM("22");
      Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
      es locales = BizVideoDetailUI.d(this.ouZ).YL("4");
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "DefinitionBefore", String.valueOf(paramInt1));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "DefinitionAfter", String.valueOf(paramInt2));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "WidthBefore", String.valueOf(BizVideoDetailUI.k(this.ouZ).ouf.width));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "HeightBefore", String.valueOf(BizVideoDetailUI.k(this.ouZ).ouf.height));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
      if (paramfu != null) {}
      for (localObject1 = Integer.valueOf(paramfu.width);; localObject1 = null)
      {
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "WidthAfter", String.valueOf(localObject1));
        localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
        localObject1 = localObject2;
        if (paramfu != null) {
          localObject1 = Integer.valueOf(paramfu.height);
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "HeightAfter", String.valueOf(localObject1));
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, BizVideoDetailUI.d(this.ouZ));
        com.tencent.mm.plugin.webview.h.a.XF(81);
        this.ovf = System.currentTimeMillis();
        if (paramfu != null)
        {
          BizVideoDetailUI.k(this.ouZ).otU = paramfu.otU;
          BizVideoDetailUI.k(this.ouZ).otV = paramfu.FQB;
          BizVideoDetailUI.k(this.ouZ).ouf.width = paramfu.width;
          BizVideoDetailUI.k(this.ouZ).ouf.height = paramfu.height;
        }
        BizVideoDetailUI.a(this.ouZ, "switchVideo", "");
        AppMethodBeat.o(175503);
        return;
      }
    }
    
    public final void a(c.a parama1, c.a parama2)
    {
      AppMethodBeat.i(209090);
      BizVideoDetailUI.d(this.ouZ).YM("21");
      BizVideoDetailUI.d(this.ouZ).YM("22");
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
      es locales = BizVideoDetailUI.d(this.ouZ).YL("19");
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
      if (parama1 != null)
      {
        localObject = String.valueOf(parama1.oAl);
        parama1 = (c.a)localObject;
        if (localObject != null) {}
      }
      else
      {
        parama1 = "";
      }
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "SpeedBefore", parama1);
      parama1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
      if (parama2 != null)
      {
        parama2 = String.valueOf(parama2.oAl);
        parama1 = parama2;
        if (parama2 != null) {}
      }
      else
      {
        parama1 = "";
      }
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "SpeedAfter", parama1);
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, BizVideoDetailUI.d(this.ouZ));
      AppMethodBeat.o(209090);
    }
    
    public final void aqS()
    {
      AppMethodBeat.i(209089);
      BizVideoDetailUI.a(this.ouZ, "seekBegin", "");
      BizVideoDetailUI.d(this.ouZ).YM("21");
      BizVideoDetailUI.d(this.ouZ).YM("22");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(BizVideoDetailUI.d(this.ouZ).YL("20"), BizVideoDetailUI.d(this.ouZ));
      AppMethodBeat.o(209089);
    }
    
    public final void bSS()
    {
      AppMethodBeat.i(175502);
      i locali = this.ouZ.ouz;
      MPVideoView localMPVideoView = BizVideoDetailUI.f(this.ouZ);
      d.g.b.p.h(localMPVideoView, "videoVideo");
      locali.oxt = localMPVideoView;
      if (!localMPVideoView.bnx()) {
        locali.bTo();
      }
      AppMethodBeat.o(175502);
    }
    
    public final void bST()
    {
      AppMethodBeat.i(7113);
      BizVideoDetailUI.k(this.ouZ).ouf.ed(12, 0);
      this.ove = System.currentTimeMillis();
      BizVideoDetailUI.a(this.ouZ, "seekEnd", "");
      AppMethodBeat.o(7113);
    }
    
    public final void bSU()
    {
      AppMethodBeat.i(7114);
      BizVideoDetailUI.k(this.ouZ).ouf.ed(13, 0);
      this.ove = System.currentTimeMillis();
      BizVideoDetailUI.a(this.ouZ, "seekEnd", "");
      AppMethodBeat.o(7114);
    }
    
    public final void bSV()
    {
      AppMethodBeat.i(7116);
      String str;
      if (this.ovh)
      {
        BizVideoDetailUI.k(this.ouZ).ouf.eS((int)(System.currentTimeMillis() - this.ovc), 31);
        str = "3";
      }
      for (;;)
      {
        Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
        localObject = BizVideoDetailUI.d(this.ouZ).YL("17");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, "BufferReason", str);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, BizVideoDetailUI.d(this.ouZ), String.valueOf(System.currentTimeMillis() - 500L));
        this.ovf = -1L;
        this.ove = -1L;
        this.ovh = false;
        this.ovg = false;
        if (!BizVideoDetailUI.f(this.ouZ).isPlaying()) {
          break;
        }
        BizVideoDetailUI.a(this.ouZ, "play", "");
        AppMethodBeat.o(7116);
        return;
        if (this.ovg)
        {
          BizVideoDetailUI.k(this.ouZ).ouf.eS((int)(System.currentTimeMillis() - this.ovc), 30);
          str = "2";
        }
        else
        {
          BizVideoDetailUI.k(this.ouZ).ouf.eS((int)(System.currentTimeMillis() - this.ovc), 29);
          str = "1";
        }
      }
      BizVideoDetailUI.a(this.ouZ, "pause", "");
      AppMethodBeat.o(7116);
    }
    
    public final void bSW()
    {
      AppMethodBeat.i(7119);
      BizVideoDetailUI.s(this.ouZ);
      this.ouZ.bSP();
      AppMethodBeat.o(7119);
    }
    
    public final void bSX()
    {
      AppMethodBeat.i(7121);
      BizVideoDetailUI.k(this.ouZ).ouf.ed(21, 0);
      this.ouZ.ouH = true;
      this.ouZ.bSE();
      com.tencent.mm.plugin.webview.h.a.XF(80);
      BizVideoDetailUI.a(this.ouZ, 0L);
      AppMethodBeat.o(7121);
    }
    
    public final void bSY()
    {
      boolean bool = true;
      AppMethodBeat.i(175504);
      this.ouZ.ouH = false;
      BizVideoDetailUI localBizVideoDetailUI;
      if ((this.ouZ.ouE) && (BizVideoDetailUI.f(this.ouZ).isPlaying()))
      {
        localBizVideoDetailUI = this.ouZ;
        if (BizVideoDetailUI.f(this.ouZ).getCurrPosSec() <= 1) {
          break label70;
        }
      }
      for (;;)
      {
        BizVideoDetailUI.b(localBizVideoDetailUI, bool);
        AppMethodBeat.o(175504);
        return;
        label70:
        bool = false;
      }
    }
    
    public final void bnH()
    {
      AppMethodBeat.i(209088);
      BizVideoDetailUI.a(this.ouZ, "seekBegin", "");
      BizVideoDetailUI.d(this.ouZ).YM("21");
      BizVideoDetailUI.d(this.ouZ).YM("22");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(BizVideoDetailUI.d(this.ouZ).YL("20"), BizVideoDetailUI.d(this.ouZ));
      AppMethodBeat.o(209088);
    }
    
    public final void jo(boolean paramBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(7118);
      BizVideoDetailUI.r(this.ouZ);
      if (paramBoolean)
      {
        BizVideoDetailUI.a(this.ouZ, 0L);
        AppMethodBeat.o(7118);
        return;
      }
      BizVideoDetailUI localBizVideoDetailUI;
      if (this.ouZ.ouE)
      {
        localBizVideoDetailUI = this.ouZ;
        if (BizVideoDetailUI.f(this.ouZ).getCurrPosSec() <= 1) {
          break label77;
        }
      }
      label77:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        BizVideoDetailUI.b(localBizVideoDetailUI, paramBoolean);
        AppMethodBeat.o(7118);
        return;
      }
    }
    
    public final void onVideoEnded()
    {
      AppMethodBeat.i(7112);
      BizVideoDetailUI.k(this.ouZ).ouf.ed(7, 0);
      BizVideoDetailUI.a(this.ouZ, "ended", "");
      this.ouZ.bSE();
      BizVideoDetailUI.o(this.ouZ);
      if (!this.ovd)
      {
        this.ovd = true;
        com.tencent.mm.plugin.webview.h.a.XF(27);
      }
      AppMethodBeat.o(7112);
    }
    
    public final void onVideoPause()
    {
      AppMethodBeat.i(7111);
      if (BizVideoDetailUI.f(this.ouZ).getPlayStatus() == 2) {
        BizVideoDetailUI.k(this.ouZ).ouf.ed(8, 0);
      }
      BizVideoDetailUI.a(this.ouZ, "pause", "");
      BizVideoDetailUI.d(this.ouZ).YM("21");
      BizVideoDetailUI.d(this.ouZ).YL("22");
      AppMethodBeat.o(7111);
    }
    
    public final void onVideoPlay()
    {
      AppMethodBeat.i(7110);
      this.ouZ.ouH = false;
      BizVideoDetailUI.k(this.ouZ);
      int i = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.Al(BizVideoDetailUI.f(this.ouZ).getPlayStatus());
      BizVideoDetailUI.k(this.ouZ).ouf.ed(i, 0);
      BizVideoDetailUI.n(this.ouZ);
      BizVideoDetailUI.a(this.ouZ, "play", "");
      if (this.hOz < 0L)
      {
        com.tencent.mm.plugin.webview.h.a.XF(6);
        if (this.ouZ.ouF) {
          com.tencent.mm.plugin.webview.h.a.XF(19);
        }
        this.hOz = System.currentTimeMillis();
      }
      Object localObject1;
      if ((this.ouZ.ouE) && (!this.ouZ.ouH) && ((!BizVideoDetailUI.f(this.ouZ).bTQ()) || (!BizVideoDetailUI.f(this.ouZ).bnx())))
      {
        localObject1 = this.ouZ;
        if (BizVideoDetailUI.f(this.ouZ).getCurrPosSec() <= 1) {
          break label430;
        }
      }
      label430:
      for (boolean bool = true;; bool = false)
      {
        BizVideoDetailUI.b((BizVideoDetailUI)localObject1, bool);
        com.tencent.mm.sdk.platformtools.ar.o((Runnable)new a(this), 300L);
        localObject1 = this.ouZ.ouz;
        Object localObject2 = (d.g.a.a)new b(this);
        d.g.b.p.h(localObject2, "onUpdateView");
        if ((((i)localObject1).oxq != 0) && (((i)localObject1).oxw <= 0) && (((i)localObject1).oxo == ((i)localObject1).lxZ) && (((i)localObject1).oxn <= ((i)localObject1).oxr) && (!((i)localObject1).bTn()))
        {
          Object localObject3 = ((i)localObject1).oxt;
          if ((localObject3 != null) && (((MPVideoView)localObject3).isPlaying() == true))
          {
            ((i)localObject1).oxp = ((i)localObject1).bEk;
            localObject3 = ((i)localObject1).oxx;
            if (localObject3 != null) {
              ((ValueAnimator)localObject3).removeAllUpdateListeners();
            }
            ((i)localObject1).oxx = ValueAnimator.ofInt(new int[] { ((i)localObject1).oxn, ((i)localObject1).oxq });
            localObject3 = ((i)localObject1).oxx;
            if (localObject3 != null) {
              ((ValueAnimator)localObject3).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new i.f((i)localObject1, (d.g.a.a)localObject2));
            }
            localObject2 = ((i)localObject1).oxx;
            if (localObject2 != null) {
              ((ValueAnimator)localObject2).setDuration(200L);
            }
            localObject1 = ((i)localObject1).oxx;
            if (localObject1 != null) {
              ((ValueAnimator)localObject1).start();
            }
          }
        }
        BizVideoDetailUI.d(this.ouZ).YM("22");
        BizVideoDetailUI.d(this.ouZ).YL("21");
        AppMethodBeat.o(7110);
        return;
      }
    }
    
    public final void onVideoWaiting()
    {
      AppMethodBeat.i(7115);
      if (this.hOz > 0L) {
        BizVideoDetailUI.n(this.ouZ);
      }
      this.ovc = System.currentTimeMillis();
      BizVideoDetailUI.a(this.ouZ, "waiting", "");
      if ((this.ovf != -1L) && ((int)(System.currentTimeMillis() - this.ovf) < 1000L)) {
        this.ovh = true;
      }
      for (;;)
      {
        BizVideoDetailUI.d(this.ouZ).YM("21");
        BizVideoDetailUI.d(this.ouZ).YM("22");
        BizVideoDetailUI.d(this.ouZ).YL("17");
        AppMethodBeat.o(7115);
        return;
        if ((this.ove != -1L) && ((int)(System.currentTimeMillis() - this.ove) < 1000L)) {
          this.ovg = true;
        }
      }
    }
    
    public final void tH(long paramLong)
    {
      AppMethodBeat.i(177795);
      BizVideoDetailUI.k(this.ouZ).ouf.ed(32, (int)paramLong);
      ae.v(BizVideoDetailUI.m(this.ouZ), "[KEY_TIME] onVideoPrepare firstRenderTime = ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(177795);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BizVideoDetailUI.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7108);
        BizVideoDetailUI.bSR();
        AppMethodBeat.o(7108);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<d.z>
    {
      b(BizVideoDetailUI.p paramp)
      {
        super();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "e", "Landroid/view/MotionEvent;", "onTouch"})
  static final class r
    implements View.OnTouchListener
  {
    r(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(7123);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = BizVideoDetailUI.f(this.ouZ);
      localObject = (View)this.ouZ.bRM();
      d.g.b.p.g(paramMotionEvent, "e");
      d.g.b.p.h(localObject, "v");
      d.g.b.p.h(paramMotionEvent, "e");
      boolean bool;
      switch (paramMotionEvent.getAction())
      {
      default: 
        bool = paramView.oAB;
      }
      for (;;)
      {
        if (bool)
        {
          BizVideoDetailUI.f(this.ouZ).M(paramMotionEvent);
          if (paramMotionEvent.getAction() == 1) {
            paramMotionEvent.setAction(3);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(7123);
        return false;
        if ((!paramView.oAC) && (paramMotionEvent.getY() >= ((View)localObject).getY()) && (paramMotionEvent.getY() <= ((View)localObject).getY() + paramView.getHeight()) && (paramMotionEvent.getX() >= ((View)localObject).getX()) && (paramMotionEvent.getX() <= ((View)localObject).getX() + paramView.getWidth())) {
          paramView.oAB = true;
        }
        paramView.oAC = true;
        break;
        bool = paramView.oAB;
        paramView.oAB = false;
        paramView.oAC = false;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7124);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (BizVideoDetailUI.f(this.ouZ).isPlaying())
      {
        BizVideoDetailUI.f(this.ouZ).pause();
        paramView = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.oyh;
        m.a.Am(37);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7124);
        return;
        BizVideoDetailUI.f(this.ouZ).start();
        paramView = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.oyh;
        m.a.Am(38);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$onShowAd$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
  public static final class u
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(7126);
      Object localObject = BizVideoDetailUI.h(this.ouZ);
      if (localObject != null)
      {
        localObject = ((FrameLayout)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      localObject = this.ouZ.DRx;
      if (localObject != null) {
        ((com.tencent.mm.plugin.webview.c.f)localObject).aIb("appear");
      }
      localObject = this.ouZ.ouA;
      if (localObject != null)
      {
        localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.webview.c.f)localObject).aIb("appear");
          AppMethodBeat.o(7126);
          return;
        }
      }
      AppMethodBeat.o(7126);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$onShowDot$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
  public static final class v
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(7127);
      Object localObject = BizVideoDetailUI.u(this.ouZ);
      if (localObject != null)
      {
        localObject = ((FrameLayout)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      if (this.ouZ.ouB != null)
      {
        ae.i(BizVideoDetailUI.m(this.ouZ), "onShowDot appear");
        localObject = this.ouZ.DRx;
        int i;
        MMWebViewWithJsApi localMMWebViewWithJsApi;
        if (localObject != null)
        {
          i = this.ouZ.bSO();
          localMMWebViewWithJsApi = this.ouZ.ouB;
          if (localMMWebViewWithJsApi == null) {
            d.g.b.p.gkB();
          }
          ((com.tencent.mm.plugin.webview.c.f)localObject).N(i, localMMWebViewWithJsApi.hashCode(), "appear");
        }
        localObject = this.ouZ.ouB;
        if (localObject != null)
        {
          localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
          if (localObject != null)
          {
            i = this.ouZ.bSO();
            localMMWebViewWithJsApi = this.ouZ.ouB;
            if (localMMWebViewWithJsApi == null) {
              d.g.b.p.gkB();
            }
            ((com.tencent.mm.plugin.webview.c.f)localObject).N(i, localMMWebViewWithJsApi.hashCode(), "appear");
            AppMethodBeat.o(7127);
            return;
          }
        }
      }
      AppMethodBeat.o(7127);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class w
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    w(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$setTouchListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/LogoWebViewWrapper$MMOverScrollOffsetListener;", "onMMOverScrollOffset", "", "offset", "", "pointerDown", "", "onMMOverScrollUp", "plugin-brandservice_release"})
  public static final class x
    implements LogoWebViewWrapper.b
  {
    public final void U(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(7129);
      Object localObject1 = this.ouZ.bRM();
      Object localObject2 = this.ouZ.bRM().getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(7129);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      ((FrameLayout.LayoutParams)localObject2).topMargin = (this.ouZ.ouz.y - paramInt);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = BizVideoDetailUI.t(this.ouZ);
      d.g.b.p.g(localObject1, "animationLayout");
      if (((View)localObject1).getVisibility() == 0)
      {
        localObject1 = BizVideoDetailUI.t(this.ouZ);
        d.g.b.p.g(localObject1, "animationLayout");
        localObject2 = BizVideoDetailUI.t(this.ouZ);
        d.g.b.p.g(localObject2, "animationLayout");
        localObject2 = ((View)localObject2).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new d.v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(7129);
          throw ((Throwable)localObject1);
        }
        localObject2 = (FrameLayout.LayoutParams)localObject2;
        ((FrameLayout.LayoutParams)localObject2).topMargin = (this.ouZ.ouz.y - paramInt);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      AppMethodBeat.o(7129);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class y
    implements Runnable
  {
    y(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(175506);
      BizVideoDetailUI.a(this.ouZ, 300L);
      AppMethodBeat.o(175506);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class z
    implements ValueAnimator.AnimatorUpdateListener
  {
    z(BizVideoDetailUI paramBizVideoDetailUI, y.d paramd) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(7133);
      if (BizVideoDetailUI.u(this.ouZ) != null)
      {
        localFrameLayout = BizVideoDetailUI.u(this.ouZ);
        if (localFrameLayout == null) {
          d.g.b.p.gkB();
        }
        if (localFrameLayout.getVisibility() != 8) {}
      }
      else
      {
        AppMethodBeat.o(7133);
        return;
      }
      d.g.b.p.g(paramValueAnimator, "valueAnimator");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new d.v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(7133);
        throw paramValueAnimator;
      }
      int i = ((Integer)paramValueAnimator).intValue();
      FrameLayout localFrameLayout = BizVideoDetailUI.u(this.ouZ);
      if (localFrameLayout != null)
      {
        paramValueAnimator = BizVideoDetailUI.u(this.ouZ);
        if (paramValueAnimator != null) {}
        for (paramValueAnimator = paramValueAnimator.getLayoutParams(); paramValueAnimator == null; paramValueAnimator = null)
        {
          paramValueAnimator = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(7133);
          throw paramValueAnimator;
        }
        paramValueAnimator = (RelativeLayout.LayoutParams)paramValueAnimator;
        paramValueAnimator.bottomMargin = i;
        localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)paramValueAnimator);
      }
      if (i == this.ovk.NiW) {
        BizVideoDetailUI.l(this.ouZ);
      }
      AppMethodBeat.o(7133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI
 * JD-Core Version:    0.7.0.1
 */