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
import android.view.MenuItem;
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
import com.tencent.mm.ah.x;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o.a;
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
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.er;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.fp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.z;
import d.g.b.u;
import d.g.b.v.d;
import d.g.b.w;
import d.y;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/preload/api/IBizVideoPage;", "()V", "TAG", "", "adView", "Landroid/widget/FrameLayout;", "getAdView", "()Landroid/widget/FrameLayout;", "adView$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "adWebView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "getAdWebView", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "setAdWebView", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;)V", "adWebViewReady", "", "getAdWebViewReady", "()Z", "setAdWebViewReady", "(Z)V", "animationIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAnimationIv", "()Landroid/widget/ImageView;", "animationIv$delegate", "animationLayout", "Landroid/view/View;", "getAnimationLayout", "()Landroid/view/View;", "animationLayout$delegate", "appMsgGetResp", "Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;", "getAppMsgGetResp", "()Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;", "setAppMsgGetResp", "(Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;)V", "appmsgDone", "getAppmsgDone", "setAppmsgDone", "backgroundContainerView", "getBackgroundContainerView", "backgroundContainerView$delegate", "bizVideoDotHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotHelper;", "bizVideoPosHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "getBizVideoPosHelper", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "setBizVideoPosHelper", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;)V", "bizVideoProfiler", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "cgiCallback", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "commentUrl", "currentDot", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "density", "", "getDensity", "()F", "setDensity", "(F)V", "dotView", "getDotView", "dotView$delegate", "dotWebView", "getDotWebView", "setDotWebView", "dotWebViewReady", "getDotWebViewReady", "setDotWebViewReady", "fullscreenImpl", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenImpl;", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "getAppMsgDone", "getGetAppMsgDone", "setGetAppMsgDone", "hideWifiTipsBarAnim", "Landroid/view/animation/Animation;", "insertVideoDone", "getInsertVideoDone", "setInsertVideoDone", "isInFullScreen", "isNetworkConnected", "needShowWifiTipsView", "getNeedShowWifiTipsView", "setNeedShowWifiTipsView", "networkListener", "Landroid/content/BroadcastReceiver;", "orientationHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper;", "playState", "getPlayState", "()Ljava/lang/String;", "setPlayState", "(Ljava/lang/String;)V", "setFullScreen", "showWifiTipsBarAnim", "showWifiTipsMode", "simcardTpye", "", "switchVideo", "getSwitchVideo", "setSwitchVideo", "switchingResolution", "getSwitchingResolution", "setSwitchingResolution", "titleBarHeight", "uin", "videoAdTitleBack", "getVideoAdTitleBack", "videoAdTitleBack$delegate", "videoAdTitleBar", "Landroid/widget/LinearLayout;", "getVideoAdTitleBar", "()Landroid/widget/LinearLayout;", "videoAdTitleBar$delegate", "videoControlBarHeight", "videoErrView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "getVideoErrView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "videoErrView$delegate", "videoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoView", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "videoView$delegate", "videoViewContainer", "getVideoViewContainer", "videoViewContainer$delegate", "videoWifiTipsView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "getVideoWifiTipsView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "videoWifiTipsView$delegate", "waitToDetroyTime", "", "adWebviewReady", "", "bundle", "Landroid/os/Bundle;", "checkInitOrientationHelper", "w", "h", "closeAdWebview", "closeDotWebview", "createAdWebview", "createDotWebview", "id", "url", "destroyDotWebView", "destroyWebView", "doOnDestroy", "doPlayVideo", "resp", "dotWebviewReady", "enableMinimize", "enableOrientationListener", "enable", "getCurrentDotId", "getCurrentPlayTime", "getForceOrientation", "getFullscreenImpl", "getLastPlayTimeKey", "getMPVideoState", "getMarginValue", "value", "", "fullValue", "getSimCardType", "goneVideoErrorView", "hideCoverLayout", "hideDotWebview", "hideVideoTitleBar", "hideWifiTipsView", "delay", "init", "initActionBar", "initComment", "initControlAreaHeight", "initDensity", "wv", "Lcom/tencent/mm/ui/widget/MMWebView;", "initOrientationHelper", "initReportParams", "initVideoParam", "initVideoView", "initView", "initWebviewSetting", "webview", "insertVideoNativeView", "params", "", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAppMsgGet", "onBackPressed", "onDestroy", "onDestroyReport", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onMPVideoStateChange", "state", "errMsg", "onPageFinished", "view", "Lcom/tencent/xweb/WebView;", "onPageReady", "onPause", "onReset", "onResetAfterCreate", "onResetBeforeCreate", "onResume", "onShowAd", "onShowDot", "onStart", "onWebViewScrollChanged", "scrollY", "opPlayer", "postBinded", "sendMPPageData", "setDotScriptData", "setTouchListener", "shouldShowWifiTips", "duration", "netChange", "showCoverLayout", "showVideoErrorView", "showWifiTipsView", "startMonitorNetWorkChange", "stopMonitorNetWorkChange", "updateDot", "updateDotAttr", "posInfo", "webviewId", "updateDotPos", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotPosInfo;", "updateDotPosIfNeed", "updateVideoPosition", "plugin-brandservice_release"})
public class BizVideoDetailUI
  extends TmplShareWebViewToolUI
  implements com.tencent.mm.plugin.webview.g.a.a
{
  private final String TAG;
  private float density;
  private String eSb;
  private final IPCRunCgi.a jKR;
  private boolean jim;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nLN;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nLO;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nLP;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nLQ;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nLR;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nLS;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nLT;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nLU;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nLV;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nLW;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o nLX;
  private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h nLY;
  private com.tencent.mm.plugin.brandservice.ui.widget.a nLZ;
  private boolean nMA;
  private int nMa;
  i nMb;
  MMWebViewWithJsApi nMc;
  MMWebViewWithJsApi nMd;
  private boolean nMe;
  private boolean nMf;
  boolean nMg;
  boolean nMh;
  boolean nMi;
  boolean nMj;
  private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c nMk;
  private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b nMl;
  private boolean nMm;
  private final j.a nMn;
  private String nMo;
  private boolean nMp;
  private boolean nMq;
  private fb nMr;
  private Animation nMs;
  private Animation nMt;
  private com.tencent.mm.plugin.brandservice.ui.widget.b nMu;
  private long nMv;
  private int nMw;
  private int nMx;
  private BroadcastReceiver nMy;
  private boolean nMz;
  private int uin;
  
  static
  {
    AppMethodBeat.i(7140);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(BizVideoDetailUI.class), "animationIv", "getAnimationIv()Landroid/widget/ImageView;")), (d.l.k)w.a(new u(w.bn(BizVideoDetailUI.class), "animationLayout", "getAnimationLayout()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(BizVideoDetailUI.class), "videoView", "getVideoView()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;")), (d.l.k)w.a(new u(w.bn(BizVideoDetailUI.class), "adView", "getAdView()Landroid/widget/FrameLayout;")), (d.l.k)w.a(new u(w.bn(BizVideoDetailUI.class), "dotView", "getDotView()Landroid/widget/FrameLayout;")), (d.l.k)w.a(new u(w.bn(BizVideoDetailUI.class), "backgroundContainerView", "getBackgroundContainerView()Landroid/widget/FrameLayout;")), (d.l.k)w.a(new u(w.bn(BizVideoDetailUI.class), "videoErrView", "getVideoErrView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;")), (d.l.k)w.a(new u(w.bn(BizVideoDetailUI.class), "videoWifiTipsView", "getVideoWifiTipsView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;")), (d.l.k)w.a(new u(w.bn(BizVideoDetailUI.class), "videoAdTitleBar", "getVideoAdTitleBar()Landroid/widget/LinearLayout;")), (d.l.k)w.a(new u(w.bn(BizVideoDetailUI.class), "videoAdTitleBack", "getVideoAdTitleBack()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(BizVideoDetailUI.class), "videoViewContainer", "getVideoViewContainer()Landroid/widget/FrameLayout;")) };
    AppMethodBeat.o(7140);
  }
  
  public BizVideoDetailUI()
  {
    AppMethodBeat.i(7216);
    this.TAG = "MicroMsg.BizVideoDetailUI";
    this.nLN = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.nLf, (d.g.a.a)new b(this));
    this.nLO = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.nLf, (d.g.a.a)new c(this));
    this.nLP = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.nLf, (d.g.a.a)new ad(this));
    this.nLQ = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.nLf, (d.g.a.a)new a(this));
    this.nLR = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.nLf, (d.g.a.a)new j(this));
    this.nLS = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.nLf, (d.g.a.a)new d(this));
    this.nLT = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.nLf, (d.g.a.a)new ac(this));
    this.nLU = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.nLf, (d.g.a.a)new af(this));
    this.nLV = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.nLf, (d.g.a.a)new ab(this));
    this.nLW = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.nLf, (d.g.a.a)new aa(this));
    this.nLX = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.nLf, (d.g.a.a)new ae(this));
    this.nMb = new i();
    this.nMl = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b();
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
    this.nMn = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.Um(toString());
    this.nMo = "";
    this.eSb = "";
    this.nMu = ((com.tencent.mm.plugin.brandservice.ui.widget.b)new k(this));
    this.nMw = -1;
    this.nMx = -1;
    this.jKR = ((IPCRunCgi.a)new e(this));
    this.nMz = true;
    AppMethodBeat.o(7216);
  }
  
  private final boolean R(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(175519);
    if ((com.tencent.mm.sdk.platformtools.h.DEBUG) && (this.nMA))
    {
      AppMethodBeat.o(175519);
      return true;
    }
    if (!ax.isNetworkConnected(ai.getContext()))
    {
      AppMethodBeat.o(175519);
      return false;
    }
    if (bMO().getPlayStatus() == 4)
    {
      ac.i(this.TAG, "not show WifiTips, play end!");
      AppMethodBeat.o(175519);
      return false;
    }
    if ((paramInt > 0) && (bMO().getCacheTimeSec() >= paramInt))
    {
      ac.i(this.TAG, "not show WifiTips, video cached! " + bMO().getCacheTimeSec() + '/' + bMO().getDuration());
      AppMethodBeat.o(175519);
      return false;
    }
    if (this.nKE.nLz)
    {
      ac.i(this.TAG, "not show WifiTips, has show!");
      AppMethodBeat.o(175519);
      return false;
    }
    if (paramBoolean)
    {
      localObject = MPVideoWifiTipsView.nNq;
      if (!MPVideoWifiTipsView.a.zo(this.nKE.nLy))
      {
        AppMethodBeat.o(175519);
        return false;
      }
    }
    else
    {
      localObject = MPVideoWifiTipsView.nNq;
      if (!MPVideoWifiTipsView.a.zm(this.nKE.nLy))
      {
        localObject = MPVideoWifiTipsView.nNq;
        if (!MPVideoWifiTipsView.a.zn(this.nKE.nLy))
        {
          AppMethodBeat.o(175519);
          return false;
        }
      }
    }
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.nOS;
    if (!com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.y(ax.isWifi(ai.getContext()), this.nMa))
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
    Object localObject = this.nMk;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    if (!((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).nNM.gkP)
    {
      AppMethodBeat.o(7204);
      return;
    }
    bNl();
    FrameLayout localFrameLayout = bMQ();
    if (localFrameLayout != null)
    {
      localObject = bMQ();
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
      if (this.jim)
      {
        i = com.tencent.mm.cc.a.ig((Context)getContext());
        if (!this.jim) {
          break label485;
        }
        j = com.tencent.mm.cc.a.ih((Context)getContext());
        k = j - this.nMx - this.nMw;
        j = k;
        if (!this.jim)
        {
          if (bMO().bOc()) {
            break label496;
          }
          localc = this.nMk;
          if (localc == null) {
            d.g.b.k.fOy();
          }
          localc.nNI = false;
          j = k + this.nMw;
        }
        label237:
        k = a(paramd.nNT, j);
        if (k < this.nMw)
        {
          localc = this.nMk;
          if (localc == null) {
            d.g.b.k.fOy();
          }
          localc.nNJ = true;
        }
        ((RelativeLayout.LayoutParams)localObject).leftMargin = a(paramd.nNQ, i);
        ((RelativeLayout.LayoutParams)localObject).topMargin = (a(paramd.nNR, j) + this.nMx);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = a(paramd.nNS, i);
        localc = this.nMk;
        if (localc == null) {
          d.g.b.k.fOy();
        }
        if ((!localc.nNI) && (!this.jim)) {
          break label522;
        }
        i = this.nMw;
        label358:
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = (i + k);
        if (!paramd.nNW) {
          break label527;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
        label382:
        if (!paramd.nNY) {
          break label537;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
        label397:
        if (!paramd.nNX) {
          break label547;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        label412:
        if (!paramd.nNZ) {
          break label557;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        label427:
        if (!paramd.nNU) {
          break label567;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
        label442:
        if (!paramd.nNV) {
          break label577;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
      }
      for (;;)
      {
        localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(7204);
        return;
        i = this.nMb.nOm;
        break;
        label485:
        j = this.nMb.nOl;
        break label176;
        label496:
        localc = this.nMk;
        if (localc == null) {
          d.g.b.k.fOy();
        }
        localc.nNI = true;
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
    z localz;
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.fJG();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.setDatabasePath(com.tencent.mm.loader.j.b.aoY() + "databases/");
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.fJJ();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.fJH();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.fJF();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.fJE();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      paramMMWebViewWithJsApi.setOnLongClickListener((View.OnLongClickListener)BizVideoDetailUI.t.nML);
      AppMethodBeat.o(7196);
      return;
    }
    AppMethodBeat.o(7196);
  }
  
  private boolean aD(int paramInt, String paramString)
  {
    AppMethodBeat.i(7202);
    d.g.b.k.h(paramString, "url");
    if (isFinishing())
    {
      AppMethodBeat.o(7202);
      return false;
    }
    if (this.nMd != null)
    {
      ac.w(this.TAG, "createDotWebview dotWebView existed!");
      AppMethodBeat.o(7202);
      return false;
    }
    com.tencent.mm.plugin.webview.h.a.Vj(57);
    this.nMf = false;
    Object localObject = a.nLl;
    localObject = MMWebViewWithJsApi.a.gT((Context)getContext());
    d.g.b.k.g(localObject, "MMWebViewWithJsApi.Factory.create(this.context)");
    this.nMd = a.a((MMWebViewWithJsApi)localObject, bMj(), (d.g.a.m)new h(this), (d.g.a.m)new i(this), aAT(bMi().TC()));
    c((MMWebView)this.nMd);
    a(this.nMd);
    localObject = bMQ();
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = bMR();
    if (localObject != null) {
      ((FrameLayout)localObject).addView((View)this.nMd);
    }
    bNl();
    int i = this.nMb.height;
    int j = this.nMw;
    int k = this.nMx;
    paramString = UrlExKt.appendUrlParam(paramString, "dotId", String.valueOf(paramInt));
    localObject = this.nMd;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    paramString = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(paramString, "dotWebviewId", String.valueOf(((MMWebViewWithJsApi)localObject).hashCode())), "dotMinShowHeight", String.valueOf(i - j - k));
    ac.i(this.TAG, "createDotWebview dotView dotUrl=".concat(String.valueOf(paramString)));
    localObject = this.nMd;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).loadUrl(paramString);
    }
    paramString = this.nMd;
    if (paramString != null) {
      paramString.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(7202);
    return true;
  }
  
  private final void b(fb paramfb)
  {
    int j = 0;
    AppMethodBeat.i(175514);
    if (paramfb == null)
    {
      AppMethodBeat.o(175514);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.brandservice.ui.widget.c.nQW;
    com.tencent.mm.plugin.brandservice.ui.widget.c.bNY();
    this.nMr = paramfb;
    ac.i(this.TAG, "doPlayVideo getAppMsgDone: " + this.nMp + ", insertVideoDone: " + this.nMq);
    if ((!this.nMp) || (!this.nMq))
    {
      AppMethodBeat.o(175514);
      return;
    }
    localObject1 = this.nKE.nLI;
    Object localObject2 = paramfb.DRV;
    d.g.b.k.g(localObject2, "resp.url_info");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject1).J((LinkedList)localObject2);
    com.tencent.mm.plugin.webview.h.a.Vj(23);
    localObject1 = paramfb.DRV;
    d.g.b.k.g(localObject1, "resp.url_info");
    localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.k.I((LinkedList)localObject1);
    if (localObject1 == null)
    {
      AppMethodBeat.o(175514);
      return;
    }
    this.nKE.nLI.nPa = ((fp)localObject1).DSI;
    this.nKE.nLx = ((fp)localObject1).nLx;
    this.nKE.nLy = ((fp)localObject1).DSK;
    ac.i(this.TAG, "doPlayVideo filesize=" + this.nKE.nLx + " wifiTipsFlag=" + this.nKE.nLy);
    boolean bool;
    int i;
    if ((paramfb.DRZ & 0x1) != 0)
    {
      bool = true;
      if ((eDE() == null) || (!eDE().bGo())) {
        break label725;
      }
      localObject2 = eDE();
      d.g.b.k.g(localObject2, "webViewFloatBallHelper");
      i = ((com.tencent.mm.plugin.webview.ui.tools.b.a)localObject2).eEQ();
      label295:
      bMO().setInitialTime(i * 1000);
      localObject2 = paramfb.DSh;
      if (localObject2 != null)
      {
        bMO().a(((dq)localObject2).btD, ((dq)localObject2).btH, ((dq)localObject2).DQE, ((dq)localObject2).DQF, ((dq)localObject2).kUf, ((dq)localObject2).kUg);
        ac.i(this.TAG, "maxInitBitrate = " + ((dq)localObject2).btD + ", bandFraction = " + ((dq)localObject2).btH + ", minDur = " + ((dq)localObject2).DQE + ", maxDur = " + ((dq)localObject2).DQF + ", minBuffer = " + ((dq)localObject2).kUf + ", maxBuffer = " + ((dq)localObject2).kUg);
      }
      this.nMg = false;
      if (!R(((fp)localObject1).DSF / 1000, false)) {
        break label744;
      }
      if (!bool) {
        break label736;
      }
      jd(false);
    }
    for (;;)
    {
      bMO().setAutoPlay(bool);
      if (!bool) {
        bNf();
      }
      this.nKE.nLI.width = ((fp)localObject1).width;
      this.nKE.nLI.height = ((fp)localObject1).height;
      localObject2 = bMO();
      String str = ((fp)localObject1).url;
      d.g.b.k.g(str, "urlInfo.url");
      ((MPVideoView)localObject2).cA(str, ((fp)localObject1).DSF / 1000);
      localObject2 = bMO();
      i = j;
      if (((fp)localObject1).width > ((fp)localObject1).height) {
        i = 90;
      }
      ((MPVideoView)localObject2).setFullScreenDirection(i);
      eM(((fp)localObject1).width, ((fp)localObject1).height);
      if ((((fp)localObject1).width > 0) && (((fp)localObject1).height > 0) && (bMi().hkX.videoWidth <= 0) && (bMi().hkX.videoHeight <= 0))
      {
        bMi().hkX.videoWidth = ((fp)localObject1).width;
        bMi().hkX.videoHeight = ((fp)localObject1).height;
      }
      localObject2 = bMO();
      paramfb = paramfb.DRV;
      d.g.b.k.g(paramfb, "resp.url_info");
      ((MPVideoView)localObject2).a(paramfb, (fp)localObject1);
      AppMethodBeat.o(175514);
      return;
      bool = false;
      break;
      label725:
      i = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.Uq(bNe());
      break label295;
      label736:
      this.nMg = true;
      continue;
      label744:
      rt(0L);
    }
  }
  
  private final View bMN()
  {
    AppMethodBeat.i(7143);
    View localView = (View)this.nLO.a($$delegatedProperties[1]);
    AppMethodBeat.o(7143);
    return localView;
  }
  
  private final MPVideoView bMO()
  {
    AppMethodBeat.i(7145);
    MPVideoView localMPVideoView = (MPVideoView)this.nLP.a($$delegatedProperties[2]);
    AppMethodBeat.o(7145);
    return localMPVideoView;
  }
  
  private final FrameLayout bMP()
  {
    AppMethodBeat.i(7146);
    FrameLayout localFrameLayout = (FrameLayout)this.nLQ.a($$delegatedProperties[3]);
    AppMethodBeat.o(7146);
    return localFrameLayout;
  }
  
  private final FrameLayout bMQ()
  {
    AppMethodBeat.i(7147);
    FrameLayout localFrameLayout = (FrameLayout)this.nLR.a($$delegatedProperties[4]);
    AppMethodBeat.o(7147);
    return localFrameLayout;
  }
  
  private final FrameLayout bMR()
  {
    AppMethodBeat.i(7148);
    FrameLayout localFrameLayout = (FrameLayout)this.nLS.a($$delegatedProperties[5]);
    AppMethodBeat.o(7148);
    return localFrameLayout;
  }
  
  private final MPVideoErrorView bMS()
  {
    AppMethodBeat.i(7149);
    MPVideoErrorView localMPVideoErrorView = (MPVideoErrorView)this.nLT.a($$delegatedProperties[6]);
    AppMethodBeat.o(7149);
    return localMPVideoErrorView;
  }
  
  private final MPVideoWifiTipsView bMT()
  {
    AppMethodBeat.i(7150);
    MPVideoWifiTipsView localMPVideoWifiTipsView = (MPVideoWifiTipsView)this.nLU.a($$delegatedProperties[7]);
    AppMethodBeat.o(7150);
    return localMPVideoWifiTipsView;
  }
  
  private final LinearLayout bMU()
  {
    AppMethodBeat.i(7151);
    LinearLayout localLinearLayout = (LinearLayout)this.nLV.a($$delegatedProperties[8]);
    AppMethodBeat.o(7151);
    return localLinearLayout;
  }
  
  private final FrameLayout bMV()
  {
    AppMethodBeat.i(7152);
    FrameLayout localFrameLayout = (FrameLayout)this.nLX.a($$delegatedProperties[10]);
    AppMethodBeat.o(7152);
    return localFrameLayout;
  }
  
  private final int bMX()
  {
    AppMethodBeat.i(175507);
    if (this.kYt == null)
    {
      i = this.nMa;
      AppMethodBeat.o(175507);
      return i;
    }
    try
    {
      Bundle localBundle = this.kYt.k(110, new Bundle());
      if (localBundle != null) {
        this.nMa = localBundle.getInt("sim_card_type", 0);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.w(this.TAG, "invoker ex :" + localException.getMessage());
      }
    }
    int i = this.nMa;
    AppMethodBeat.o(175507);
    return i;
  }
  
  private final void bMY()
  {
    AppMethodBeat.i(175509);
    View localView = bMN();
    d.g.b.k.g(localView, "animationLayout");
    if (localView.getVisibility() == 0)
    {
      localView = bMN();
      d.g.b.k.g(localView, "animationLayout");
      dD(localView);
    }
    dD((View)bMk());
    bNj();
    AppMethodBeat.o(175509);
  }
  
  private void bNb()
  {
    AppMethodBeat.i(199153);
    if (bMO().isPlaying()) {
      bMO().bNZ();
    }
    eI("leavePage", "");
    this.nMn.report();
    this.nKE.nLI.nOV = bMO().getEndPlayTime();
    if (this.nKG != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.lBM;
      this.lBM = (l1 - this.nKH + l2);
      this.nKE.nLI.nOW = ((int)(this.lBM / 1000L));
    }
    this.nKE.nLI.nOU = ((int)bMO().getRealPlayTime());
    this.nKE.nLI.eb(2, 0);
    if (!this.nMi)
    {
      com.tencent.mm.plugin.webview.h.a.Vj(22);
      AppMethodBeat.o(199153);
      return;
    }
    if ((bMO().getPlayStart()) && (!bMO().getPlayStarted())) {
      com.tencent.mm.plugin.webview.h.a.Vj(26);
    }
    AppMethodBeat.o(199153);
  }
  
  private void bNc()
  {
    AppMethodBeat.i(7183);
    if (this.nMc == null)
    {
      AppMethodBeat.o(7183);
      return;
    }
    Object localObject = this.Cjc;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.c.f)localObject).aBl("disappear");
    }
    localObject = this.Cjc;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.c.f)localObject).aBl("destroy");
    }
    localObject = bMP();
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = bMP();
    if (localObject != null) {
      ((FrameLayout)localObject).removeView((View)this.nMc);
    }
    localObject = this.nMc;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getCurWebviewClient();
      if (!(localObject instanceof com.tencent.mm.plugin.webview.ui.tools.widget.k)) {
        break label162;
      }
      localObject = this.nMc;
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
    localObject = this.nMc;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).destroy();
    }
    localObject = this.nMc;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebChromeClient(null);
    }
    localObject = this.nMc;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebViewClient(null);
    }
    localObject = this.nMc;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnTouchListener(null);
    }
    localObject = this.nMc;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnLongClickListener(null);
    }
    localObject = this.nMc;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setVisibility(8);
    }
    localObject = this.nMc;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).removeAllViews();
    }
    localObject = this.nMc;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).clearView();
    }
    this.nMc = null;
    this.nMe = false;
    bNi();
    AppMethodBeat.o(7183);
  }
  
  private final String bNe()
  {
    AppMethodBeat.i(7188);
    String str = bMi().TC() + '_' + this.uin + '_' + this.nKE.hhd;
    AppMethodBeat.o(7188);
    return str;
  }
  
  private final void bNf()
  {
    AppMethodBeat.i(175515);
    View localView = bMN();
    d.g.b.k.g(localView, "animationLayout");
    localView.setVisibility(8);
    AppMethodBeat.o(175515);
  }
  
  private final void bNg()
  {
    AppMethodBeat.i(7189);
    MPVideoErrorView localMPVideoErrorView = bMS();
    d.g.b.k.g(localMPVideoErrorView, "videoErrView");
    if (localMPVideoErrorView.getVisibility() == 0)
    {
      localMPVideoErrorView = bMS();
      d.g.b.k.g(localMPVideoErrorView, "videoErrView");
      localMPVideoErrorView.setVisibility(8);
      eM(this.nMb.width, this.nMb.height);
    }
    AppMethodBeat.o(7189);
  }
  
  private final void bNh()
  {
    AppMethodBeat.i(7190);
    MPVideoErrorView localMPVideoErrorView = bMS();
    d.g.b.k.g(localMPVideoErrorView, "videoErrView");
    localMPVideoErrorView.setVisibility(0);
    jc(false);
    AppMethodBeat.o(7190);
  }
  
  private final void bNi()
  {
    AppMethodBeat.i(7193);
    Object localObject = bMP();
    if (localObject != null)
    {
      if (((FrameLayout)localObject).getVisibility() == 8)
      {
        localObject = bMT();
        d.g.b.k.g(localObject, "videoWifiTipsView");
        if (((MPVideoWifiTipsView)localObject).getVisibility() == 8)
        {
          localObject = bMU();
          d.g.b.k.g(localObject, "videoAdTitleBar");
          ((LinearLayout)localObject).setVisibility(8);
        }
      }
      AppMethodBeat.o(7193);
      return;
    }
    AppMethodBeat.o(7193);
  }
  
  private final void bNj()
  {
    AppMethodBeat.i(7203);
    if (this.nMk != null)
    {
      Object localObject = bMQ();
      if (localObject == null) {
        break label56;
      }
      if (((FrameLayout)localObject).getVisibility() == 0)
      {
        localObject = this.nMk;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        a(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).nNM);
      }
    }
    AppMethodBeat.o(7203);
    return;
    label56:
    AppMethodBeat.o(7203);
  }
  
  private final void bNk()
  {
    AppMethodBeat.i(7205);
    Object localObject1;
    if ((bMQ() != null) && (this.nMk != null))
    {
      localObject1 = this.nMk;
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject1).nNJ) {}
    }
    else
    {
      AppMethodBeat.o(7205);
      return;
    }
    ac.i(this.TAG, "updateDotPosIfNeed");
    int i;
    Object localObject2;
    if (!this.jim)
    {
      localObject1 = bMQ();
      if (localObject1 != null) {}
      for (localObject1 = ((FrameLayout)localObject1).getLayoutParams(); localObject1 == null; localObject1 = null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(7205);
        throw ((Throwable)localObject1);
      }
      i = ((RelativeLayout.LayoutParams)localObject1).bottomMargin;
      localObject1 = new v.d();
      ((v.d)localObject1).KUO = i;
      if (!bMO().bOc()) {
        break label228;
      }
      localObject2 = this.nMk;
      if (localObject2 == null) {
        d.g.b.k.fOy();
      }
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nNI) {
        break label228;
      }
    }
    for (((v.d)localObject1).KUO += this.nMw;; ((v.d)localObject1).KUO -= this.nMw)
    {
      localObject2 = ValueAnimator.ofInt(new int[] { i, ((v.d)localObject1).KUO });
      ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new z(this, (v.d)localObject1));
      d.g.b.k.g(localObject2, "va");
      ((ValueAnimator)localObject2).setDuration(200L);
      ((ValueAnimator)localObject2).start();
      AppMethodBeat.o(7205);
      return;
      label228:
      if (bMO().bOc()) {
        break;
      }
      localObject2 = this.nMk;
      if (localObject2 == null) {
        d.g.b.k.fOy();
      }
      if (!((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nNI) {
        break;
      }
    }
    AppMethodBeat.o(7205);
  }
  
  private final void bNl()
  {
    AppMethodBeat.i(7206);
    if (this.nMw < 0)
    {
      this.nMw = com.tencent.mm.cc.a.au((Context)getContext(), 2131166589);
      this.nMx = com.tencent.mm.ui.ap.dT((Context)getContext());
    }
    AppMethodBeat.o(7206);
  }
  
  private final void bNm()
  {
    AppMethodBeat.i(7207);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onShowDot ready: ").append(this.nMf).append(", hasWebView: ");
    if (this.nMd != null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i((String)localObject, bool);
      if ((this.nMf) && (this.nMd != null)) {
        break;
      }
      AppMethodBeat.o(7207);
      return;
    }
    com.tencent.mm.plugin.webview.h.a.Vj(60);
    localObject = bMQ();
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = bMR();
    if (localObject != null) {
      ((FrameLayout)localObject).removeView((View)this.nMd);
    }
    localObject = bMQ();
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = bMQ();
    if (localObject != null) {
      ((FrameLayout)localObject).addView((View)this.nMd);
    }
    localObject = bMQ();
    if (localObject != null)
    {
      localObject = ((FrameLayout)localObject).getViewTreeObserver();
      if (localObject != null) {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new v(this));
      }
    }
    localObject = this.nMk;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).nNH = true;
    }
    localObject = this.nMk;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).nNK = true;
    }
    bNk();
    AppMethodBeat.o(7207);
  }
  
  private final void bNp()
  {
    AppMethodBeat.i(175518);
    if (this.nMy != null)
    {
      getContext().unregisterReceiver(this.nMy);
      this.nMy = null;
    }
    AppMethodBeat.o(175518);
  }
  
  private final void c(MMWebView paramMMWebView)
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
  
  private final void dD(View paramView)
  {
    AppMethodBeat.i(175510);
    this.nMb.dD(paramView);
    AppMethodBeat.o(175510);
  }
  
  private final void eI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199154);
    if (bs.lr(this.nMo, paramString1))
    {
      AppMethodBeat.o(199154);
      return;
    }
    ac.d(this.TAG, "onMPVideoStateChange ".concat(String.valueOf(paramString1)));
    Object localObject = this.Cjc;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.c.f)localObject).f(paramString1, this.nKE.hhd, paramString2, String.valueOf(bMO().getCurrPosSec()), String.valueOf(bMO().getRealPlayTime() / 1000L));
    }
    localObject = this.nMc;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
      if (localObject != null) {
        ((com.tencent.mm.plugin.webview.c.f)localObject).f(paramString1, this.nKE.hhd, paramString2, String.valueOf(bMO().getCurrPosSec()), String.valueOf(bMO().getRealPlayTime() / 1000L));
      }
    }
    this.nMo = paramString1;
    AppMethodBeat.o(199154);
  }
  
  private final void eM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7167);
    if (paramInt1 > paramInt2)
    {
      Object localObject1;
      if (this.nLY != null)
      {
        localObject1 = this.nLY;
        if (localObject1 != null)
        {
          Object localObject2 = getContext();
          d.g.b.k.g(localObject2, "context");
          localObject2 = (Context)localObject2;
          MPVideoView localMPVideoView = bMO();
          d.g.b.k.h(localObject2, "ctx");
          d.g.b.k.h(localMPVideoView, "video");
          ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h)localObject1).jYQ = new WeakReference(localObject2);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h)localObject1).nOd = new WeakReference(localMPVideoView);
        }
      }
      for (;;)
      {
        jc(true);
        AppMethodBeat.o(7167);
        return;
        localObject1 = getContext();
        d.g.b.k.g(localObject1, "context");
        this.nLY = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h((Context)localObject1, bMO());
      }
    }
    jc(false);
    AppMethodBeat.o(7167);
  }
  
  private final void jd(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(7191);
    if (!R(bMO().getDuration(), paramBoolean))
    {
      ac.i(this.TAG, "showWifiTipsView should not show now");
      AppMethodBeat.o(7191);
      return;
    }
    ac.i(this.TAG, "showWifiTipsView ".concat(String.valueOf(paramBoolean)));
    com.tencent.mm.plugin.webview.h.a.Vj(16);
    Object localObject;
    int i;
    if (!paramBoolean)
    {
      localObject = MPVideoWifiTipsView.nNq;
      if (MPVideoWifiTipsView.a.zn(this.nKE.nLy))
      {
        i = 2;
        this.nKE.nLI.nPc = i;
        this.nKE.nLI.eb(14, 0);
        localObject = this.nKE;
        if (!paramBoolean) {
          break label264;
        }
      }
    }
    for (;;)
    {
      ((b)localObject).zl(j);
      this.nKE.nLz = true;
      this.nMg = false;
      bMT().q(this.nKE.nLx, i);
      if (this.nMs == null)
      {
        this.nMs = AnimationUtils.loadAnimation((Context)getContext(), 2130772105);
        localObject = this.nMs;
        if (localObject != null) {
          ((Animation)localObject).setDuration(300L);
        }
      }
      bMT().clearAnimation();
      bMT().startAnimation(this.nMs);
      localObject = bMT();
      d.g.b.k.g(localObject, "videoWifiTipsView");
      ((MPVideoWifiTipsView)localObject).setVisibility(0);
      com.tencent.mm.sdk.platformtools.ap.n((Runnable)new y(this), 3000L);
      AppMethodBeat.o(7191);
      return;
      i = 1;
      break;
      label264:
      j = 1;
    }
  }
  
  private final void rt(long paramLong)
  {
    AppMethodBeat.i(175516);
    Object localObject = bMT();
    d.g.b.k.g(localObject, "videoWifiTipsView");
    if (((MPVideoWifiTipsView)localObject).getVisibility() != 8)
    {
      if (paramLong > 0L)
      {
        if (this.nMt == null)
        {
          this.nMt = AnimationUtils.loadAnimation((Context)getContext(), 2130772109);
          localObject = this.nMt;
          if (localObject != null) {
            ((Animation)localObject).setDuration(paramLong);
          }
        }
        bMT().clearAnimation();
        bMT().startAnimation(this.nMt);
      }
      com.tencent.mm.sdk.platformtools.ap.n((Runnable)new l(this), paramLong);
    }
    AppMethodBeat.o(175516);
  }
  
  public final void P(Bundle paramBundle)
  {
    AppMethodBeat.i(7172);
    if (this.jim) {
      bMO().q(false, 0);
    }
    this.nMn.Up("21");
    this.nMn.Up("22");
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.nMn.Uo("3"), this.nMn);
    bNc();
    bNd();
    jc(false);
    super.P(paramBundle);
    com.tencent.mm.plugin.webview.h.a.Vj(18);
    this.nMh = true;
    AppMethodBeat.o(7172);
  }
  
  public final boolean Q(Bundle paramBundle)
  {
    AppMethodBeat.i(7195);
    if (isFinishing())
    {
      AppMethodBeat.o(7195);
      return false;
    }
    if ((paramBundle == null) || (!paramBundle.containsKey("adUrl")))
    {
      ac.w(this.TAG, "createAdWebview url not found");
      AppMethodBeat.o(7195);
      return false;
    }
    if (this.nMc != null)
    {
      ac.w(this.TAG, "createAdWebview adWebView existed!");
      AppMethodBeat.o(7195);
      return false;
    }
    com.tencent.mm.plugin.webview.h.a.Vj(28);
    paramBundle = paramBundle.getString("adUrl");
    ac.i(this.TAG, "createAdWebview adWebView url=".concat(String.valueOf(paramBundle)));
    this.nMe = false;
    Object localObject = a.nLl;
    localObject = MMWebViewWithJsApi.a.gT((Context)getContext());
    d.g.b.k.g(localObject, "MMWebViewWithJsApi.Factory.create(this.context)");
    this.nMc = a.a((MMWebViewWithJsApi)localObject, bMj(), (d.g.a.m)BizVideoDetailUI.f.nMC, (d.g.a.m)BizVideoDetailUI.g.nMD, aAT(bMi().TC()));
    a(this.nMc);
    localObject = this.nMc;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).loadUrl(paramBundle);
    }
    paramBundle = bMP();
    if (paramBundle != null) {
      paramBundle.removeAllViews();
    }
    paramBundle = bMR();
    if (paramBundle != null) {
      paramBundle.addView((View)this.nMc);
    }
    paramBundle = this.nMc;
    if (paramBundle != null) {
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(7195);
    return true;
  }
  
  public final void R(Bundle paramBundle)
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
    ac.i(this.TAG, "sendMPPageData %s, webviewId = %d", new Object[] { str, Integer.valueOf(j) });
    if (d.g.b.k.g("adWeb", str))
    {
      if (this.nMc == null)
      {
        AppMethodBeat.o(7200);
        return;
      }
      paramBundle = this.nMc;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getJsapi();
        if (paramBundle != null)
        {
          paramBundle.aBk((String)localObject);
          AppMethodBeat.o(7200);
          return;
        }
      }
      AppMethodBeat.o(7200);
      return;
    }
    if (d.g.b.k.g("dot", str))
    {
      if (this.nMd == null)
      {
        AppMethodBeat.o(7200);
        return;
      }
      paramBundle = this.nMd;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label257;
        }
        paramBundle = this.TAG;
        localObject = this.nMd;
        if (localObject == null) {
          break label252;
        }
      }
      label252:
      for (int i = localObject.hashCode();; i = 0)
      {
        ac.i(paramBundle, "sendMPPageData id not match %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(7200);
        return;
        i = 0;
        break;
      }
      label257:
      paramBundle = this.nMd;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getJsapi();
        if (paramBundle != null)
        {
          paramBundle.aBk((String)localObject);
          AppMethodBeat.o(7200);
          return;
        }
      }
      AppMethodBeat.o(7200);
      return;
    }
    paramBundle = this.Cjc;
    if (paramBundle != null)
    {
      paramBundle.aBk((String)localObject);
      AppMethodBeat.o(7200);
      return;
    }
    AppMethodBeat.o(7200);
  }
  
  public final void S(Bundle paramBundle)
  {
    AppMethodBeat.i(7208);
    if (this.nMd == null)
    {
      AppMethodBeat.o(7208);
      return;
    }
    if (paramBundle == null) {
      d.g.b.k.fOy();
    }
    int j = paramBundle.getInt("webviewId", 0);
    if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.bNz())
    {
      paramBundle = this.nMd;
      MMWebViewWithJsApi localMMWebViewWithJsApi;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label125;
        }
        paramBundle = this.TAG;
        localMMWebViewWithJsApi = this.nMd;
        if (localMMWebViewWithJsApi == null) {
          break label120;
        }
      }
      label120:
      for (int i = localMMWebViewWithJsApi.hashCode();; i = 0)
      {
        ac.i(paramBundle, "closeDotWebview id not match %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(7208);
        return;
        i = 0;
        break;
      }
    }
    label125:
    ac.i(this.TAG, "closeDotWebview");
    bNd();
    AppMethodBeat.o(7208);
  }
  
  public final void S(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(175512);
    d.g.b.k.h(paramMap, "params");
    ac.i(this.TAG, "insertVideoNativeView");
    Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.nMn.Uo("8"), this.nMn);
    Object localObject2 = this.nMn;
    localObject1 = this.nLi;
    Object localObject3;
    float f1;
    float f2;
    boolean bool;
    label892:
    int i;
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((BaseWebViewController)localObject1).Cdm;
      localObject3 = (com.tencent.mm.pluginsdk.q)localObject1;
      if (localObject3 != null)
      {
        localObject1 = (d.g.a.b)j.a.a.nOO;
        long l5 = ((com.tencent.mm.pluginsdk.q)localObject3).aFO("getA8KeyStart");
        long l6 = ((com.tencent.mm.pluginsdk.q)localObject3).aFO("getA8KeyEnd");
        long l3 = ((com.tencent.mm.pluginsdk.q)localObject3).aFO("onPageStarted");
        long l2 = ((com.tencent.mm.pluginsdk.q)localObject3).aFO("onPageFinished");
        long l4 = ((com.tencent.mm.pluginsdk.q)localObject3).aFO("firstScreenTimestamp");
        long l7 = ((com.tencent.mm.pluginsdk.q)localObject3).aFO("firstScreenTime");
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
        localObject3 = new eo();
        ((eo)localObject3).type = 5;
        LinkedList localLinkedList = ((eo)localObject3).DNM;
        er localer = new er();
        localer.key = "EventType";
        localer.hpH = "6";
        localLinkedList.add(localer);
        localLinkedList = ((eo)localObject3).DNM;
        localer = new er();
        localer.key = "StartTime";
        localer.hpH = ((String)((d.g.a.b)localObject1).ay(Long.valueOf(l5)));
        localLinkedList.add(localer);
        localLinkedList = ((eo)localObject3).DNM;
        localer = new er();
        localer.key = "EndTime";
        localer.hpH = ((String)((d.g.a.b)localObject1).ay(Long.valueOf(l6)));
        localLinkedList.add(localer);
        ((j.a)localObject2).nON.add(localObject3);
        localObject3 = new eo();
        ((eo)localObject3).type = 5;
        localLinkedList = ((eo)localObject3).DNM;
        localer = new er();
        localer.key = "EventType";
        localer.hpH = "7";
        localLinkedList.add(localer);
        localLinkedList = ((eo)localObject3).DNM;
        localer = new er();
        localer.key = "StartTime";
        localer.hpH = ((String)((d.g.a.b)localObject1).ay(Long.valueOf(l2)));
        localLinkedList.add(localer);
        localLinkedList = ((eo)localObject3).DNM;
        localer = new er();
        localer.key = "EndTime";
        localer.hpH = ((String)((d.g.a.b)localObject1).ay(Long.valueOf(l1)));
        localLinkedList.add(localer);
        ((j.a)localObject2).nON.add(localObject3);
      }
      c(this.nKq);
      localObject1 = this.nMb;
      localObject2 = getContext();
      d.g.b.k.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      f1 = this.density;
      d.g.b.k.h(localObject2, "context");
      d.g.b.k.h(paramMap, "params");
      ((i)localObject1).x = ((int)(bs.getInt((String)paramMap.get("x"), 0) * f1) - 2);
      ((i)localObject1).y = ((int)(bs.getInt((String)paramMap.get("y"), 0) * f1) - 2);
      ((i)localObject1).width = ((int)(bs.getInt((String)paramMap.get("width"), 0) * f1) + 4);
      ((i)localObject1).height = ((int)(bs.getInt((String)paramMap.get("height"), 0) * f1) + 4);
      ((i)localObject1).nOt = ((String)paramMap.get("reportParams"));
      float f3 = bs.getFloat((String)paramMap.get("playerMinRatioWhenPlaying"), 1.777778F);
      f2 = bs.getFloat((String)paramMap.get("playerMinRatioWhenNotPlaying"), 1.777778F);
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
      ac.w("MicroMsg.BizVideoPosHelper", "init invalid params x=" + ((i)localObject1).x + ", y=" + ((i)localObject1).y + ", width=" + ((i)localObject1).width + ", height=" + ((i)localObject1).height);
      bool = false;
      this.nMq = bool;
      this.nKE.nLG = bs.getInt((String)paramMap.get("landingType"), 0);
      if (this.nMq)
      {
        bMk().addView((View)bMV());
        if ((this.nMb.width > 0) && (this.nMb.height > 0)) {
          eM(this.nMb.width, this.nMb.height);
        }
        bMO().a((ImageView)this.nLN.a($$delegatedProperties[0]), bMi().hkX.hld, this.nMb.width, this.nMb.nOl, bMi());
        localObject1 = bMO();
        localObject2 = bMi().hkX.hld;
        i = this.nMb.width;
        j = this.nMb.nOl;
        localObject3 = bMi();
        d.g.b.k.h(localObject3, "msgInfo");
        paramMap = ((MPVideoView)localObject1).nRg;
        if (paramMap == null) {
          break label1746;
        }
      }
    }
    label1746:
    for (paramMap = paramMap.getCoverIv();; paramMap = null)
    {
      ((MPVideoView)localObject1).a(paramMap, (String)localObject2, i, j, (x)localObject3);
      dD((View)bMk());
      paramMap = bMN();
      d.g.b.k.g(paramMap, "animationLayout");
      dD(paramMap);
      this.nMb.a(0, bMO());
      ac.i(this.TAG, "initVideoParam minVideoHeight " + this.nMb.nOl + " maxVideoHeight " + this.nMb.btU);
      paramMap = bMN();
      d.g.b.k.g(paramMap, "animationLayout");
      paramMap.setVisibility(0);
      bMh().bringToFront();
      bMO().setFullScreenDelegate((MPVideoView.b)new o(this));
      bMO().setMPVideoViewCallBack((MPVideoView.c)new p(this));
      ((View)this.nLW.a($$delegatedProperties[9])).setOnClickListener((View.OnClickListener)new q(this));
      getWebView().setOnCustomTouchListener((View.OnTouchListener)new r(this));
      bMO().setTitle(bMi().hkX.title);
      bMO().setPlayBtnOnClickListener((View.OnClickListener)new s(this));
      paramMap = bMS();
      localObject1 = this.nKE;
      d.g.b.k.h(localObject1, "controller");
      paramMap.fvu.setOnClickListener((View.OnClickListener)new MPVideoErrorView.a(paramMap, (b)localObject1));
      b(this.nMr);
      AppMethodBeat.o(175512);
      return;
      localObject1 = null;
      break;
      label1398:
      ((i)localObject1).kWB = com.tencent.mm.cc.a.ig((Context)localObject2);
      if ((((i)localObject1).x <= 0) && (Math.abs(((i)localObject1).kWB - ((i)localObject1).width) < 10))
      {
        ((i)localObject1).x = 0;
        ((i)localObject1).width = ((i)localObject1).kWB;
      }
      ((i)localObject1).nOj = ((i)localObject1).x;
      ((i)localObject1).nOk = ((i)localObject1).y;
      ((i)localObject1).nOl = ((i)localObject1).height;
      ((i)localObject1).nOm = ((i)localObject1).width;
      ((i)localObject1).btU = ((int)(((i)localObject1).kWB * 1.0F / ((i)localObject1).width * ((i)localObject1).height));
      ((i)localObject1).nOn = ((i)localObject1).btU;
      ((i)localObject1).nOo = d.k.h.lb((int)(((i)localObject1).kWB * 1.0F / f1), ((i)localObject1).btU);
      ((i)localObject1).nOp = d.k.h.lb((int)(((i)localObject1).kWB * 1.0F / f2), ((i)localObject1).btU);
      if ((((i)localObject1).nOo == ((i)localObject1).nOp) && (Math.abs(((i)localObject1).nOp - ((i)localObject1).btU) < 10))
      {
        ((i)localObject1).nOo = ((i)localObject1).btU;
        ((i)localObject1).nOp = ((i)localObject1).btU;
      }
      ac.i("MicroMsg.BizVideoPosHelper", "init x=" + ((i)localObject1).x + ", y=" + ((i)localObject1).y + ", width=" + ((i)localObject1).width + ", height=" + ((i)localObject1).height + ", screenWidth=" + ((i)localObject1).kWB + ", minVideoHeightWhenPlay = " + ((i)localObject1).nOo + ", minVideoHeightWhenPause = " + ((i)localObject1).nOp);
      bool = true;
      break label892;
    }
  }
  
  public final void T(Bundle paramBundle)
  {
    AppMethodBeat.i(7209);
    if (this.nMd == null)
    {
      AppMethodBeat.o(7209);
      return;
    }
    if (paramBundle == null) {
      d.g.b.k.fOy();
    }
    int j = paramBundle.getInt("webviewId", 0);
    int i;
    MMWebViewWithJsApi localMMWebViewWithJsApi;
    if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.bNz())
    {
      paramBundle = this.nMd;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label125;
        }
        paramBundle = this.TAG;
        localMMWebViewWithJsApi = this.nMd;
        if (localMMWebViewWithJsApi == null) {
          break label120;
        }
      }
      label120:
      for (i = localMMWebViewWithJsApi.hashCode();; i = 0)
      {
        ac.i(paramBundle, "hideDotWebview id not match %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(7209);
        return;
        i = 0;
        break;
      }
    }
    label125:
    ac.i(this.TAG, "hideDotWebview");
    paramBundle = bMQ();
    if ((paramBundle == null) || (paramBundle.getVisibility() != 0))
    {
      ac.i(this.TAG, "dotView not show");
      AppMethodBeat.o(7209);
      return;
    }
    paramBundle = bMQ();
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.Cjc;
    if (paramBundle != null)
    {
      i = bNn();
      localMMWebViewWithJsApi = this.nMd;
      if (localMMWebViewWithJsApi == null) {
        d.g.b.k.fOy();
      }
      paramBundle.L(i, localMMWebViewWithJsApi.hashCode(), "disappear");
    }
    paramBundle = this.nMd;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getJsapi();
      if (paramBundle != null)
      {
        i = bNn();
        localMMWebViewWithJsApi = this.nMd;
        if (localMMWebViewWithJsApi == null) {
          d.g.b.k.fOy();
        }
        paramBundle.L(i, localMMWebViewWithJsApi.hashCode(), "disappear");
        AppMethodBeat.o(7209);
        return;
      }
    }
    AppMethodBeat.o(7209);
  }
  
  public final void U(Bundle paramBundle)
  {
    AppMethodBeat.i(7210);
    if (this.nMd == null)
    {
      AppMethodBeat.o(7210);
      return;
    }
    if (paramBundle == null) {
      d.g.b.k.fOy();
    }
    int j = paramBundle.getInt("webviewId", 0);
    if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.bNz())
    {
      paramBundle = this.nMd;
      MMWebViewWithJsApi localMMWebViewWithJsApi;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label125;
        }
        paramBundle = this.TAG;
        localMMWebViewWithJsApi = this.nMd;
        if (localMMWebViewWithJsApi == null) {
          break label120;
        }
      }
      label120:
      for (int i = localMMWebViewWithJsApi.hashCode();; i = 0)
      {
        ac.i(paramBundle, "dotWebviewReady id not match %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(7210);
        return;
        i = 0;
        break;
      }
    }
    label125:
    ac.i(this.TAG, "dotWebViewReady %d", new Object[] { Integer.valueOf(j) });
    this.nMf = true;
    com.tencent.mm.plugin.webview.h.a.Vj(59);
    AppMethodBeat.o(7210);
  }
  
  public final void V(Bundle paramBundle)
  {
    AppMethodBeat.i(7211);
    Object localObject1 = this.nMl;
    int k = bMO().getDuration();
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {
      ac.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData data invalid");
    }
    Object localObject2;
    int m;
    int i;
    for (;;)
    {
      bNo();
      localObject1 = bMO();
      paramBundle = new LinkedList((Collection)this.nMl.nNF);
      d.g.b.k.h(paramBundle, "list");
      localObject1 = ((MPVideoView)localObject1).nRh;
      if (localObject1 != null) {
        ((MPVideoViewControlBar)localObject1).L(paramBundle);
      }
      bNj();
      AppMethodBeat.o(7211);
      return;
      try
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).nNF.clear();
        localObject2 = y.KTp;
        paramBundle = paramBundle.getString("data", "");
        ac.d(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData data=".concat(String.valueOf(paramBundle)));
        try
        {
          paramBundle = new JSONObject(paramBundle).optJSONArray("items");
          if (paramBundle == null) {
            ac.w(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "itemList null");
          }
        }
        catch (Exception paramBundle)
        {
          ac.e(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData ex %s", new Object[] { paramBundle.getMessage() });
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
      d.g.b.k.g(str, "url");
      localObject2 = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c(j, d1, d2, d3, str);
      if (n != 1) {
        break label570;
      }
      bool = true;
      label378:
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nNH = bool;
      if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nNN < ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nNO) && (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nNN >= 0.0D) && (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nNO <= k)) {
        break label576;
      }
      ac.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "dotInfo invalid, startTime = " + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nNN + ", endTime=" + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nNO + ", duration=" + k);
    }
    label561:
    label570:
    label576:
    for (int j = 0;; j = 1)
    {
      if (j == 0)
      {
        ac.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "dotInfo invalid");
      }
      else
      {
        try
        {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).nNF.add(localObject2);
          break label561;
        }
        finally
        {
          paramBundle = finally;
          AppMethodBeat.o(7211);
          throw paramBundle;
        }
        ac.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData end %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).nNF.size()) });
        break;
      }
      i += 1;
      break label238;
      bool = false;
      break label378;
    }
  }
  
  public final void W(Bundle paramBundle)
  {
    AppMethodBeat.i(7201);
    if ((paramBundle == null) || (!paramBundle.containsKey("opType")))
    {
      AppMethodBeat.o(7201);
      return;
    }
    paramBundle = paramBundle.getString("opType");
    ac.i(this.TAG, "opPlayer opType= ".concat(String.valueOf(paramBundle)));
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
          bMO().start();
          AppMethodBeat.o(7201);
          return;
          if (paramBundle.equals("stop")) {
            bMO().stop();
          }
        }
      }
    } while (!paramBundle.equals("pause"));
    bMO().pause();
    AppMethodBeat.o(7201);
  }
  
  /* Error */
  public final void a(fb paramfb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: sipush 7187
    //   9: invokestatic 390	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_1
    //   13: ifnonnull +47 -> 60
    //   16: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nOE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nMn	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   24: ldc_w 2177
    //   27: invokevirtual 1714	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:Uo	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/eo;
    //   30: astore_1
    //   31: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nOE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   34: astore_3
    //   35: aload_1
    //   36: ldc_w 2179
    //   39: ldc_w 2181
    //   42: invokestatic 2184	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/eo;Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nMn	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   50: invokestatic 1717	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/eo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;)V
    //   53: sipush 7187
    //   56: invokestatic 446	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: aload_1
    //   61: getfield 2187	com/tencent/mm/protocal/protobuf/fb:DSa	I
    //   64: istore_2
    //   65: aload_0
    //   66: getfield 608	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:nKE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   69: astore 6
    //   71: aload 6
    //   73: iload_2
    //   74: putfield 2190	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:hhc	I
    //   77: aload 6
    //   79: invokevirtual 2193	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:bML	()Z
    //   82: ifeq +48 -> 130
    //   85: aload 6
    //   87: getfield 2197	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:nLB	Lcom/tencent/mm/ah/x;
    //   90: astore_3
    //   91: aload_3
    //   92: ifnonnull +9 -> 101
    //   95: ldc_w 1924
    //   98: invokestatic 2200	d/g/b/k:aVY	(Ljava/lang/String;)V
    //   101: aload 6
    //   103: getfield 2197	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:nLB	Lcom/tencent/mm/ah/x;
    //   106: astore 6
    //   108: aload 6
    //   110: ifnonnull +9 -> 119
    //   113: ldc_w 1924
    //   116: invokestatic 2200	d/g/b/k:aVY	(Ljava/lang/String;)V
    //   119: aload_3
    //   120: aload 6
    //   122: getfield 2201	com/tencent/mm/ah/x:hhc	I
    //   125: iconst_1
    //   126: ior
    //   127: putfield 2201	com/tencent/mm/ah/x:hhc	I
    //   130: aload_0
    //   131: getfield 2205	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:nKF	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/o;
    //   134: invokevirtual 2210	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/o:WT	()V
    //   137: aload_0
    //   138: getfield 2211	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:Cjc	Lcom/tencent/mm/plugin/webview/c/f;
    //   141: astore_3
    //   142: aload_3
    //   143: ifnull +15 -> 158
    //   146: aload_3
    //   147: ldc_w 2213
    //   150: aload_0
    //   151: iload_2
    //   152: invokespecial 2216	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:zi	(I)I
    //   155: invokevirtual 2219	com/tencent/mm/plugin/webview/c/f:fd	(Ljava/lang/String;I)V
    //   158: aload_1
    //   159: getfield 2223	com/tencent/mm/protocal/protobuf/fb:DSe	Lcom/tencent/mm/protocal/protobuf/btb;
    //   162: ifnull +24 -> 186
    //   165: aload_0
    //   166: getfield 608	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:nKE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   169: invokevirtual 2193	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:bML	()Z
    //   172: ifeq +14 -> 186
    //   175: aload_0
    //   176: getfield 608	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:nKE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   179: aload_1
    //   180: getfield 2223	com/tencent/mm/protocal/protobuf/fb:DSe	Lcom/tencent/mm/protocal/protobuf/btb;
    //   183: putfield 2226	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:nLH	Lcom/tencent/mm/protocal/protobuf/btb;
    //   186: aload_0
    //   187: getfield 608	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:nKE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   190: aload_1
    //   191: getfield 2227	com/tencent/mm/protocal/protobuf/fb:hhd	Ljava/lang/String;
    //   194: putfield 1417	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:hhd	Ljava/lang/String;
    //   197: aload_0
    //   198: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nMn	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   201: astore 7
    //   203: aload_1
    //   204: getfield 2227	com/tencent/mm/protocal/protobuf/fb:hhd	Ljava/lang/String;
    //   207: astore 6
    //   209: aload 6
    //   211: astore_3
    //   212: aload 6
    //   214: ifnonnull +7 -> 221
    //   217: ldc_w 527
    //   220: astore_3
    //   221: aload 7
    //   223: aload_3
    //   224: putfield 2230	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:nOK	Ljava/lang/String;
    //   227: aload_0
    //   228: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nMn	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   231: aload_0
    //   232: invokevirtual 2233	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:getScene	()I
    //   235: invokestatic 1033	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   238: putfield 2236	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:nOL	Ljava/lang/String;
    //   241: aload_0
    //   242: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nMn	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   245: aload_0
    //   246: invokevirtual 2239	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:getSubScene	()I
    //   249: invokestatic 1033	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   252: putfield 2242	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:nOM	Ljava/lang/String;
    //   255: aload_1
    //   256: getfield 2245	com/tencent/mm/protocal/protobuf/fb:DSd	Ljava/lang/String;
    //   259: astore_3
    //   260: aload_3
    //   261: ifnull +11 -> 272
    //   264: aload_0
    //   265: getfield 608	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:nKE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   268: aload_3
    //   269: putfield 2248	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:nLv	Ljava/lang/String;
    //   272: aload_0
    //   273: getfield 608	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:nKE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   276: aload_1
    //   277: getfield 2249	com/tencent/mm/protocal/protobuf/fb:url	Ljava/lang/String;
    //   280: invokevirtual 2252	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:Uk	(Ljava/lang/String;)V
    //   283: aload_1
    //   284: getfield 2249	com/tencent/mm/protocal/protobuf/fb:url	Ljava/lang/String;
    //   287: astore_3
    //   288: aload_3
    //   289: ifnull +8 -> 297
    //   292: aload_0
    //   293: aload_3
    //   294: putfield 531	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:eSb	Ljava/lang/String;
    //   297: aload_1
    //   298: getfield 2256	com/tencent/mm/protocal/protobuf/fb:DSc	Lcom/tencent/mm/protocal/protobuf/dqd;
    //   301: ifnull +126 -> 427
    //   304: aload_1
    //   305: getfield 2256	com/tencent/mm/protocal/protobuf/fb:DSc	Lcom/tencent/mm/protocal/protobuf/dqd;
    //   308: getfield 2261	com/tencent/mm/protocal/protobuf/dqd:dkl	I
    //   311: ifeq +116 -> 427
    //   314: aload_0
    //   315: getfield 453	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:TAG	Ljava/lang/String;
    //   318: new 589	java/lang/StringBuilder
    //   321: dup
    //   322: ldc_w 2263
    //   325: invokespecial 593	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   328: aload_1
    //   329: getfield 2256	com/tencent/mm/protocal/protobuf/fb:DSc	Lcom/tencent/mm/protocal/protobuf/dqd;
    //   332: getfield 2266	com/tencent/mm/protocal/protobuf/dqd:dkm	Ljava/lang/String;
    //   335: invokevirtual 921	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: ldc_w 2268
    //   341: invokevirtual 921	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload_1
    //   345: getfield 2256	com/tencent/mm/protocal/protobuf/fb:DSc	Lcom/tencent/mm/protocal/protobuf/dqd;
    //   348: getfield 2261	com/tencent/mm/protocal/protobuf/dqd:dkl	I
    //   351: invokevirtual 597	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: invokevirtual 604	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 584	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload_0
    //   361: invokespecial 1422	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bMS	()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;
    //   364: aload_1
    //   365: getfield 2256	com/tencent/mm/protocal/protobuf/fb:DSc	Lcom/tencent/mm/protocal/protobuf/dqd;
    //   368: getfield 2266	com/tencent/mm/protocal/protobuf/dqd:dkm	Ljava/lang/String;
    //   371: invokevirtual 2271	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView:setPlayError$505cff1c	(Ljava/lang/String;)V
    //   374: aload_0
    //   375: invokespecial 1674	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bNh	()V
    //   378: bipush 32
    //   380: invokestatic 965	com/tencent/mm/plugin/webview/h/a:Vj	(I)V
    //   383: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nOE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   386: astore_1
    //   387: aload_0
    //   388: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nMn	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   391: ldc_w 2177
    //   394: invokevirtual 1714	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:Uo	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/eo;
    //   397: astore_1
    //   398: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nOE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   401: astore_3
    //   402: aload_1
    //   403: ldc_w 2179
    //   406: ldc_w 2181
    //   409: invokestatic 2184	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/eo;Ljava/lang/String;Ljava/lang/String;)V
    //   412: aload_1
    //   413: aload_0
    //   414: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nMn	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   417: invokestatic 1717	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/eo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;)V
    //   420: sipush 7187
    //   423: invokestatic 446	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   426: return
    //   427: aload_0
    //   428: invokespecial 1683	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bNg	()V
    //   431: aload_1
    //   432: getfield 2274	com/tencent/mm/protocal/protobuf/fb:DSi	Ljava/util/LinkedList;
    //   435: astore_3
    //   436: aload_3
    //   437: ifnull +345 -> 782
    //   440: aload_3
    //   441: checkcast 2276	java/lang/Iterable
    //   444: astore_3
    //   445: new 2278	java/util/ArrayList
    //   448: dup
    //   449: aload_3
    //   450: bipush 10
    //   452: invokestatic 2283	d/a/j:a	(Ljava/lang/Iterable;I)I
    //   455: invokespecial 2285	java/util/ArrayList:<init>	(I)V
    //   458: checkcast 2068	java/util/Collection
    //   461: astore 7
    //   463: aload_3
    //   464: invokeinterface 2289 1 0
    //   469: astore 8
    //   471: aload 8
    //   473: invokeinterface 2294 1 0
    //   478: ifeq +304 -> 782
    //   481: aload 8
    //   483: invokeinterface 2298 1 0
    //   488: checkcast 2300	com/tencent/mm/protocal/protobuf/bro
    //   491: astore 6
    //   493: getstatic 2306	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:nNE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/a;
    //   496: astore_3
    //   497: aload 6
    //   499: getfield 2307	com/tencent/mm/protocal/protobuf/bro:url	Ljava/lang/String;
    //   502: astore_3
    //   503: aload 6
    //   505: getfield 2310	com/tencent/mm/protocal/protobuf/bro:FgH	Ljava/lang/String;
    //   508: astore 9
    //   510: aload_3
    //   511: invokestatic 706	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   514: ifne +11 -> 525
    //   517: aload 9
    //   519: invokestatic 706	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   522: ifeq +26 -> 548
    //   525: getstatic 2311	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:TAG	Ljava/lang/String;
    //   528: ldc_w 2313
    //   531: invokestatic 2315	com/tencent/mm/sdk/platformtools/ac:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: aload 7
    //   536: getstatic 2090	d/y:KTp	Ld/y;
    //   539: invokeinterface 2316 2 0
    //   544: pop
    //   545: goto -74 -> 471
    //   548: invokestatic 2319	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:bNy	()Z
    //   551: ifne +15 -> 566
    //   554: getstatic 2311	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:TAG	Ljava/lang/String;
    //   557: ldc_w 2321
    //   560: invokestatic 2315	com/tencent/mm/sdk/platformtools/ac:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   563: goto -29 -> 534
    //   566: new 589	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 913	java/lang/StringBuilder:<init>	()V
    //   573: getstatic 2325	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:nND	Lcom/tencent/mm/sdk/platformtools/an;
    //   576: invokevirtual 2330	com/tencent/mm/sdk/platformtools/an:eUr	()Ljava/lang/Object;
    //   579: checkcast 2332	com/tencent/mm/vfs/e
    //   582: invokevirtual 2335	com/tencent/mm/vfs/e:getPath	()Ljava/lang/String;
    //   585: invokevirtual 921	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: bipush 47
    //   590: invokevirtual 600	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   593: astore 6
    //   595: aload_3
    //   596: invokestatic 2341	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   599: astore_3
    //   600: aload_3
    //   601: ldc_w 2343
    //   604: invokestatic 984	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   607: new 2332	com/tencent/mm/vfs/e
    //   610: dup
    //   611: aload 6
    //   613: aload_3
    //   614: invokevirtual 2346	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   617: invokevirtual 921	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: invokevirtual 604	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: invokespecial 2347	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   626: astore_3
    //   627: aload_3
    //   628: invokevirtual 2350	com/tencent/mm/vfs/e:exists	()Z
    //   631: ifne +23 -> 654
    //   634: new 2332	com/tencent/mm/vfs/e
    //   637: dup
    //   638: aload_3
    //   639: invokevirtual 2353	com/tencent/mm/vfs/e:getParent	()Ljava/lang/String;
    //   642: invokespecial 2347	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   645: invokevirtual 2356	com/tencent/mm/vfs/e:mkdirs	()Z
    //   648: pop
    //   649: aload_3
    //   650: invokevirtual 2359	com/tencent/mm/vfs/e:createNewFile	()Z
    //   653: pop
    //   654: aload_3
    //   655: invokestatic 2365	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   658: checkcast 2367	java/io/Closeable
    //   661: astore 6
    //   663: aload 6
    //   665: checkcast 2369	java/io/OutputStream
    //   668: astore 10
    //   670: aload 9
    //   672: ifnull +105 -> 777
    //   675: getstatic 2375	d/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   678: astore_3
    //   679: aload 9
    //   681: ifnonnull +46 -> 727
    //   684: new 838	d/v
    //   687: dup
    //   688: ldc_w 2377
    //   691: invokespecial 841	d/v:<init>	(Ljava/lang/String;)V
    //   694: astore_1
    //   695: sipush 7187
    //   698: invokestatic 446	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   701: aload_1
    //   702: athrow
    //   703: astore_3
    //   704: sipush 7187
    //   707: invokestatic 446	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   710: aload_3
    //   711: athrow
    //   712: astore_1
    //   713: aload 6
    //   715: aload_3
    //   716: invokestatic 2382	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   719: sipush 7187
    //   722: invokestatic 446	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   725: aload_1
    //   726: athrow
    //   727: aload 9
    //   729: aload_3
    //   730: invokevirtual 2386	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   733: astore_3
    //   734: aload_3
    //   735: ldc_w 2388
    //   738: invokestatic 984	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   741: aload 10
    //   743: aload_3
    //   744: invokevirtual 2392	java/io/OutputStream:write	([B)V
    //   747: getstatic 2311	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:TAG	Ljava/lang/String;
    //   750: ldc_w 2394
    //   753: aload 9
    //   755: invokestatic 696	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   758: invokevirtual 700	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   761: invokestatic 2315	com/tencent/mm/sdk/platformtools/ac:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: getstatic 2090	d/y:KTp	Ld/y;
    //   767: astore_3
    //   768: aload 6
    //   770: aconst_null
    //   771: invokestatic 2382	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   774: goto -240 -> 534
    //   777: aconst_null
    //   778: astore_3
    //   779: goto -38 -> 741
    //   782: aload_1
    //   783: getfield 1095	com/tencent/mm/protocal/protobuf/fb:DRV	Ljava/util/LinkedList;
    //   786: checkcast 2396	java/util/List
    //   789: invokestatic 2400	com/tencent/mm/sdk/platformtools/bs:gY	(Ljava/util/List;)Z
    //   792: ifeq +24 -> 816
    //   795: aload_0
    //   796: getfield 453	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:TAG	Ljava/lang/String;
    //   799: ldc_w 2402
    //   802: invokestatic 960	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   805: iconst_4
    //   806: invokestatic 965	com/tencent/mm/plugin/webview/h/a:Vj	(I)V
    //   809: sipush 7187
    //   812: invokestatic 446	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   815: return
    //   816: aload_0
    //   817: invokespecial 571	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bMO	()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;
    //   820: astore 7
    //   822: aload_0
    //   823: invokevirtual 995	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bMi	()Lcom/tencent/mm/ah/x;
    //   826: astore 6
    //   828: aload_1
    //   829: getfield 2405	com/tencent/mm/protocal/protobuf/fb:DSj	Ljava/lang/String;
    //   832: astore 5
    //   834: aload 5
    //   836: astore_3
    //   837: aload 5
    //   839: ifnonnull +7 -> 846
    //   842: ldc_w 527
    //   845: astore_3
    //   846: aload 6
    //   848: ldc_w 1924
    //   851: invokestatic 712	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   854: aload_3
    //   855: ldc_w 2407
    //   858: invokestatic 712	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   861: aload 7
    //   863: getfield 2077	com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView:nRh	Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar;
    //   866: astore 5
    //   868: aload 5
    //   870: ifnonnull +6 -> 876
    //   873: invokestatic 683	d/g/b/k:fOy	()V
    //   876: aload 5
    //   878: aload 6
    //   880: getfield 2410	com/tencent/mm/ah/x:hkV	Ljava/lang/String;
    //   883: aload 6
    //   885: invokevirtual 1000	com/tencent/mm/ah/x:TC	()Ljava/lang/String;
    //   888: aload_3
    //   889: invokevirtual 2414	com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar:M	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   892: aload_0
    //   893: iconst_1
    //   894: putfield 1078	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nMp	Z
    //   897: aload_1
    //   898: getfield 1095	com/tencent/mm/protocal/protobuf/fb:DRV	Ljava/util/LinkedList;
    //   901: astore_3
    //   902: aload_3
    //   903: ldc_w 1097
    //   906: invokestatic 984	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   909: aload_3
    //   910: invokestatic 1107	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/k:I	(Ljava/util/LinkedList;)Lcom/tencent/mm/protocal/protobuf/fp;
    //   913: astore 6
    //   915: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nOE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   918: astore_3
    //   919: aload_0
    //   920: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nMn	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   923: ldc_w 2177
    //   926: invokevirtual 1714	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:Uo	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/eo;
    //   929: astore 5
    //   931: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nOE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   934: astore_3
    //   935: aload 5
    //   937: ldc_w 2416
    //   940: ldc_w 2418
    //   943: invokestatic 2184	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/eo;Ljava/lang/String;Ljava/lang/String;)V
    //   946: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nOE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   949: astore_3
    //   950: aload 5
    //   952: ldc_w 2420
    //   955: ldc_w 2418
    //   958: invokestatic 2184	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/eo;Ljava/lang/String;Ljava/lang/String;)V
    //   961: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nOE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   964: astore_3
    //   965: aload 6
    //   967: ifnull +123 -> 1090
    //   970: aload 6
    //   972: getfield 1112	com/tencent/mm/protocal/protobuf/fp:DSI	I
    //   975: invokestatic 1662	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   978: astore_3
    //   979: aload 5
    //   981: ldc_w 2422
    //   984: aload_3
    //   985: invokestatic 696	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   988: invokestatic 2184	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/eo;Ljava/lang/String;Ljava/lang/String;)V
    //   991: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nOE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   994: astore_3
    //   995: aload 6
    //   997: ifnull +98 -> 1095
    //   1000: aload 6
    //   1002: getfield 1205	com/tencent/mm/protocal/protobuf/fp:width	I
    //   1005: invokestatic 1662	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1008: astore_3
    //   1009: aload 5
    //   1011: ldc_w 2424
    //   1014: aload_3
    //   1015: invokestatic 696	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1018: invokestatic 2184	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/eo;Ljava/lang/String;Ljava/lang/String;)V
    //   1021: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nOE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1024: astore_3
    //   1025: aload 4
    //   1027: astore_3
    //   1028: aload 6
    //   1030: ifnull +12 -> 1042
    //   1033: aload 6
    //   1035: getfield 1207	com/tencent/mm/protocal/protobuf/fp:height	I
    //   1038: invokestatic 1662	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1041: astore_3
    //   1042: aload 5
    //   1044: ldc_w 2426
    //   1047: aload_3
    //   1048: invokestatic 696	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1051: invokestatic 2184	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/eo;Ljava/lang/String;Ljava/lang/String;)V
    //   1054: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nOE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1057: astore_3
    //   1058: aload 5
    //   1060: ldc_w 2179
    //   1063: ldc_w 2418
    //   1066: invokestatic 2184	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/eo;Ljava/lang/String;Ljava/lang/String;)V
    //   1069: aload 5
    //   1071: aload_0
    //   1072: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nMn	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   1075: invokestatic 1717	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/eo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;)V
    //   1078: aload_0
    //   1079: aload_1
    //   1080: invokespecial 1999	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/fb;)V
    //   1083: sipush 7187
    //   1086: invokestatic 446	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1089: return
    //   1090: aconst_null
    //   1091: astore_3
    //   1092: goto -113 -> 979
    //   1095: aconst_null
    //   1096: astore_3
    //   1097: goto -88 -> 1009
    //   1100: astore_1
    //   1101: aload 5
    //   1103: astore_3
    //   1104: goto -391 -> 713
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1107	0	this	BizVideoDetailUI
    //   0	1107	1	paramfb	fb
    //   64	88	2	i	int
    //   34	645	3	localObject1	Object
    //   703	27	3	localThrowable	Throwable
    //   733	371	3	localObject2	Object
    //   1	1025	4	localObject3	Object
    //   4	1098	5	localObject4	Object
    //   69	965	6	localObject5	Object
    //   201	661	7	localObject6	Object
    //   469	13	8	localIterator	java.util.Iterator
    //   508	246	9	str	String
    //   668	74	10	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   663	670	703	java/lang/Throwable
    //   675	679	703	java/lang/Throwable
    //   684	703	703	java/lang/Throwable
    //   727	741	703	java/lang/Throwable
    //   741	768	703	java/lang/Throwable
    //   704	712	712	finally
    //   663	670	1100	finally
    //   675	679	1100	finally
    //   684	703	1100	finally
    //   727	741	1100	finally
    //   741	768	1100	finally
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(7173);
    super.b(paramWebView, paramString);
    AppMethodBeat.o(7173);
  }
  
  public final void bMW()
  {
    AppMethodBeat.i(7153);
    this.nMn.bND();
    super.bMW();
    if (!this.nMm)
    {
      this.nMm = true;
      com.tencent.mm.pluginsdk.g.o((MMActivity)this);
      com.tencent.mm.plugin.webview.h.a.Vj(0);
    }
    getIntent().putExtra("vertical_scroll", false);
    AppMethodBeat.o(7153);
  }
  
  public final void bMZ()
  {
    AppMethodBeat.i(7169);
    com.tencent.mm.plugin.webview.ui.tools.widget.n localn = eDG();
    localn.setMinHeaderHeight(this.nMb.height);
    localn.setUrl(this.eSb);
    localn.eGF();
    localn.a(this.nKE.scene, this.nKE.nLC, this.nKE.hgY, this.nKE.nLA, this.nKE.url, bMi().hkX.title);
    localn.setCallback((n.c)new n(this));
    localn.setTimeLineSessionId(localn.getTimeLineSessionId());
    AppMethodBeat.o(7169);
  }
  
  public final boolean bMn()
  {
    return true;
  }
  
  public final void bMo()
  {
    AppMethodBeat.i(7154);
    super.bMo();
    setBackBtn((MenuItem.OnMenuItemClickListener)new m(this), 2131689492);
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
    eo localeo = this.nMn.Uo("1");
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
    localObject = this.nLi;
    boolean bool;
    if (localObject != null)
    {
      bool = ((MpWebViewController)localObject).bLV();
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (localObject = "1";; localObject = "0")
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localeo, "MiaoKai", (String)localObject);
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localeo, this.nMn);
      AppMethodBeat.o(7154);
      return;
      bool = false;
      break;
    }
  }
  
  public final void bMp()
  {
    AppMethodBeat.i(175513);
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h localh = this.nLY;
    if (localh != null) {
      localh.release();
    }
    bNp();
    this.nMl.reset();
    eDI();
    this.nKF.onDestroy();
    int i = bNa();
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.cy(bNe(), i);
    this.nKE.onDestroy();
    bNc();
    bNd();
    bMO().onUIDestroy();
    AppMethodBeat.o(175513);
  }
  
  public final void bMu()
  {
    AppMethodBeat.i(7197);
    bNc();
    AppMethodBeat.o(7197);
  }
  
  public final void bMv()
  {
    AppMethodBeat.i(7198);
    ac.i(this.TAG, "adWebviewReady");
    this.nMe = true;
    AppMethodBeat.o(7198);
  }
  
  public final Bundle bMw()
  {
    AppMethodBeat.i(7199);
    Bundle localBundle = new Bundle();
    localBundle.putInt("currentTime", bMO().getCurrPosSec());
    localBundle.putInt("duration", bMO().getDuration());
    localBundle.putString("state", this.nMo);
    localBundle.putLong("playedTotalTime", bMO().getRealPlayTime() / 1000L);
    localBundle.putString("vid", this.nKE.hhd);
    AppMethodBeat.o(7199);
    return localBundle;
  }
  
  public final int bNa()
  {
    AppMethodBeat.i(7181);
    Object localObject = bMO();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((MPVideoView)localObject).getCurrPosSec());; localObject = null)
    {
      int j = ((Integer)localObject).intValue();
      localObject = bMO();
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
  
  public final void bNd()
  {
    AppMethodBeat.i(7184);
    if (this.nMd == null)
    {
      AppMethodBeat.o(7184);
      return;
    }
    com.tencent.mm.plugin.webview.h.a.Vj(61);
    if (!this.nMf) {
      com.tencent.mm.plugin.webview.h.a.Vj(62);
    }
    Object localObject = this.Cjc;
    int i;
    MMWebViewWithJsApi localMMWebViewWithJsApi;
    if (localObject != null)
    {
      i = bNn();
      localMMWebViewWithJsApi = this.nMd;
      if (localMMWebViewWithJsApi == null) {
        d.g.b.k.fOy();
      }
      ((com.tencent.mm.plugin.webview.c.f)localObject).L(i, localMMWebViewWithJsApi.hashCode(), "disappear");
    }
    localObject = this.Cjc;
    if (localObject != null)
    {
      i = bNn();
      localMMWebViewWithJsApi = this.nMd;
      if (localMMWebViewWithJsApi == null) {
        d.g.b.k.fOy();
      }
      ((com.tencent.mm.plugin.webview.c.f)localObject).L(i, localMMWebViewWithJsApi.hashCode(), "destroy");
    }
    localObject = bMQ();
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = bMQ();
    if (localObject != null) {
      ((FrameLayout)localObject).removeView((View)this.nMd);
    }
    localObject = this.nMd;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getCurWebviewClient();
      if (!(localObject instanceof com.tencent.mm.plugin.webview.ui.tools.widget.k)) {
        break label223;
      }
      localObject = this.nMd;
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
    localObject = this.nMd;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).destroy();
    }
    localObject = this.nMd;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebChromeClient(null);
    }
    localObject = this.nMd;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebViewClient(null);
    }
    localObject = this.nMd;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnTouchListener(null);
    }
    localObject = this.nMd;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnLongClickListener(null);
    }
    localObject = this.nMd;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setVisibility(8);
    }
    localObject = this.nMd;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).removeAllViews();
    }
    localObject = this.nMd;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).clearView();
    }
    this.nMd = null;
    this.nMf = false;
    localObject = this.nMk;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).cRT = false;
    }
    localObject = this.nMk;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).nNK = false;
    }
    this.nMk = null;
    AppMethodBeat.o(7184);
  }
  
  public final int bNn()
  {
    AppMethodBeat.i(7212);
    if (this.nMk == null)
    {
      AppMethodBeat.o(7212);
      return -1;
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c localc = this.nMk;
    if (localc == null) {
      d.g.b.k.fOy();
    }
    int i = localc.id;
    AppMethodBeat.o(7212);
    return i;
  }
  
  public final void bNo()
  {
    AppMethodBeat.i(7213);
    if ((this.nMj) || (bMO().getCurrPosSec() <= 0))
    {
      AppMethodBeat.o(7213);
      return;
    }
    float f = bMO().getCurrPosMs() / 1000.0F;
    if ((this.nMd != null) && (this.nMl.b(f, this.nMk)))
    {
      localObject = this.nMk;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).cRT)
      {
        if (com.tencent.mm.sdk.platformtools.h.DEBUG) {
          ac.d(this.TAG, "dot end, wait h5 to close");
        }
        if (System.currentTimeMillis() - this.nMv >= 1000L)
        {
          ac.i(this.TAG, "dot end, time out to close");
          bNd();
        }
        AppMethodBeat.o(7213);
        return;
      }
      ac.i(this.TAG, "destroyDotWebView");
      localObject = bMQ();
      if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
      {
        localObject = this.nMd;
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
        localObject = this.nMd;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        if (((com.tencent.mm.plugin.webview.c.f)localObject).isReady()) {
          break;
        }
      }
      bNd();
      if (this.nMk == null) {
        break label360;
      }
      if (this.nMf)
      {
        localObject = bMQ();
        if (((localObject == null) || (((FrameLayout)localObject).getVisibility() != 0)) && (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.a(f, this.nMk))) {
          bNm();
        }
      }
      AppMethodBeat.o(7213);
      return;
    }
    localObject = this.nMk;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).cRT = true;
    this.nMv = System.currentTimeMillis();
    localObject = this.nMd;
    int i;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
      if (localObject != null)
      {
        i = bNn();
        MMWebViewWithJsApi localMMWebViewWithJsApi = this.nMd;
        if (localMMWebViewWithJsApi == null) {
          d.g.b.k.fOy();
        }
        ((com.tencent.mm.plugin.webview.c.f)localObject).L(i, localMMWebViewWithJsApi.hashCode(), "end");
        AppMethodBeat.o(7213);
        return;
      }
    }
    AppMethodBeat.o(7213);
    return;
    label360:
    this.nMk = this.nMl.aR(f);
    if (this.nMk != null)
    {
      i = bNn();
      localObject = this.nMk;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      aD(i, ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).url);
    }
    AppMethodBeat.o(7213);
  }
  
  public final void bvh()
  {
    AppMethodBeat.i(7156);
    super.bvh();
    if (this.kYt != null) {}
    try
    {
      this.nKE.nLI.nOY = this.kYt.wG(bMi().TC());
      this.nKE.nLI.eb(1, 0);
      Object localObject = this.kYt;
      d.g.b.k.g(localObject, "invoker");
      this.uin = ((e)localObject).eCI();
      this.nKE.nLE = bMX();
      this.nMi = false;
      this.nKE.bMI();
      this.nMn.Uo("5");
      if (!bs.isNullOrNil(bMi().hkX.title))
      {
        localObject = eDE();
        if (localObject != null) {
          ((com.tencent.mm.plugin.webview.ui.tools.b.a)localObject).SO(bMi().hkX.title);
        }
      }
      localObject = eDE();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.webview.ui.tools.b.a)localObject).aDu("1");
        AppMethodBeat.o(7156);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.w(this.TAG, "invoker ex :" + localException.getMessage());
      }
      AppMethodBeat.o(7156);
    }
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(7177);
    if (this.jim)
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
    if (bMi().hkX == null)
    {
      finish();
      ac.w(this.TAG, "onCreate msgInfo.item is null");
      AppMethodBeat.o(7155);
      return;
    }
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("onCreate rawUrl is ");
    Object localObject3 = bMi().hkX;
    if (localObject3 == null) {
      d.g.b.k.fOy();
    }
    ac.i((String)localObject1, ((com.tencent.mm.ah.v)localObject3).url);
    localObject3 = this.nMn;
    localObject1 = bMi().hkX;
    if (localObject1 == null) {
      d.g.b.k.fOy();
    }
    localObject2 = ((com.tencent.mm.ah.v)localObject1).url;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((j.a)localObject3).nOJ = ((String)localObject1);
    this.nMn.nOH = String.valueOf(bMl());
    this.nMn.nOI = String.valueOf(System.currentTimeMillis() / 1000L);
    localObject1 = this.nKE;
    localObject2 = this.jKR;
    d.g.b.k.h(localObject2, "callback");
    ((b)localObject1).jKR = ((IPCRunCgi.a)localObject2);
    localObject1 = this.nKF;
    localObject2 = (TmplShareWebViewToolUI)this;
    localObject3 = bMi();
    Object localObject4 = this.nKE;
    d.g.b.k.h(localObject2, "ui");
    d.g.b.k.h(localObject3, "msgInfo");
    d.g.b.k.h(localObject4, "controller");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o)localObject1).lvU = new WeakReference(localObject2);
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o)localObject1).nLB = ((x)localObject3);
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o)localObject1).nMS = ((b)localObject4);
    this.nKE.nLD = ((Number)this.nKM.a(TmplShareWebViewToolUI.$$delegatedProperties[8])).intValue();
    this.nKE.nLI.nOd = new WeakReference(bMO());
    localObject1 = this.nKE;
    localObject3 = (TmplShareWebViewToolUI)this;
    int i = getScene();
    int j = getSubScene();
    localObject4 = bMi().hkX;
    if (localObject4 == null) {
      d.g.b.k.fOy();
    }
    localObject2 = bMi();
    int k = bMl();
    d.g.b.k.h(localObject3, "ui");
    d.g.b.k.h(localObject4, "readerItem");
    d.g.b.k.h(localObject2, "msgInfo");
    ((b)localObject1).lvU = new WeakReference(localObject3);
    ((b)localObject1).scene = i;
    ((b)localObject1).nLC = j;
    ((b)localObject1).Uk(((com.tencent.mm.ah.v)localObject4).url);
    ((b)localObject1).nBm = ((com.tencent.mm.ah.v)localObject4);
    ((b)localObject1).nLB = ((x)localObject2);
    ((b)localObject1).hgY = ((com.tencent.mm.ah.v)localObject4).type;
    ((b)localObject1).nLA = k;
    ((b)localObject1).ddo = ((x)localObject2).ddo;
    ((b)localObject1).nLu = ((x)localObject2).hkV;
    ((b)localObject1).hhd = ((x)localObject2).hkX.hhd;
    localObject3 = ((b)localObject1).nLw;
    d.g.b.k.h(localObject1, "controller");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.n)localObject3).nMS = ((b)localObject1);
    localObject3 = ((b)localObject1).nLI;
    d.g.b.k.h(localObject1, "controller");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject3).nMS = ((b)localObject1);
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject3).nOZ = true;
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject3).nOX = "";
    try
    {
      localObject2 = Uri.parse(((x)localObject2).hkX.url);
      ((b)localObject1).hlF = bs.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
      ((b)localObject1).idx = bs.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
      ac.i(((b)localObject1).TAG, "init vid=" + ((b)localObject1).hhd);
      localObject3 = this.nKE;
      localObject2 = getIntent().getStringExtra("biz_video_channel_session_id");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      d.g.b.k.h(localObject1, "<set-?>");
      ((b)localObject3).nLF = ((String)localObject1);
      com.tencent.mm.plugin.webview.h.a.Vj(1);
      this.nMl.reset();
      this.CAF.setMMOverScrollOffsetListener((LogoWebViewWrapper.b)new x(this));
      this.CAF.eDx();
      this.CAF.eDy();
      this.nMp = false;
      this.nMq = false;
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ((IntentFilter)localObject1).setPriority(2147483647);
      if (this.nMy == null) {
        this.nMy = ((BroadcastReceiver)new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(7132);
            d.g.b.k.h(paramAnonymousContext, "context");
            if ((paramAnonymousIntent == null) || (bs.isNullOrNil(paramAnonymousIntent.getAction())) || (!this.nMB.nMi) || ((BizVideoDetailUI.k(this.nMB).nLz) && (!BizVideoDetailUI.v(this.nMB))))
            {
              AppMethodBeat.o(7132);
              return;
            }
            boolean bool1 = ax.isNetworkConnected(ai.getContext());
            if ((!BizVideoDetailUI.w(this.nMB)) && (bool1))
            {
              paramAnonymousContext = BizVideoDetailUI.f(this.nMB);
              paramAnonymousIntent = paramAnonymousContext.nRg;
              if (paramAnonymousIntent == null) {
                d.g.b.k.fOy();
              }
              if (paramAnonymousIntent.isPlaying())
              {
                paramAnonymousIntent = paramAnonymousContext.nRg;
                if (paramAnonymousIntent == null) {
                  d.g.b.k.fOy();
                }
                if (paramAnonymousIntent.kWd == null) {
                  break label421;
                }
                paramAnonymousIntent = paramAnonymousIntent.kWd;
                if (paramAnonymousIntent == null) {
                  d.g.b.k.fOy();
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
                paramAnonymousIntent = paramAnonymousContext.nRg;
                if (paramAnonymousIntent == null) {
                  d.g.b.k.fOy();
                }
                if (paramAnonymousIntent.bNV())
                {
                  paramAnonymousIntent = paramAnonymousContext.nRg;
                  if (paramAnonymousIntent == null) {
                    d.g.b.k.fOy();
                  }
                  paramAnonymousContext = paramAnonymousContext.nRg;
                  if (paramAnonymousContext == null) {
                    d.g.b.k.fOy();
                  }
                  paramAnonymousIntent.T(paramAnonymousContext.getCurrPosMs(), true);
                }
              }
              BizVideoDetailUI.c(this.nMB, bool1);
              bool1 = ax.isWifi(ai.getContext());
              i = BizVideoDetailUI.x(this.nMB);
              BizVideoDetailUI.a(this.nMB, BizVideoDetailUI.y(this.nMB));
              boolean bool2 = BizVideoDetailUI.b(this.nMB, BizVideoDetailUI.f(this.nMB).getDuration());
              ac.i(BizVideoDetailUI.m(this.nMB), "net type change simcardTpye=" + BizVideoDetailUI.x(this.nMB) + ", lastSimcardType=" + i + ", is wifi=" + bool1 + ", show=" + bool2);
              if (!bool2) {
                break label441;
              }
              paramAnonymousContext = BizVideoDetailUI.i(this.nMB);
              d.g.b.k.g(paramAnonymousContext, "videoWifiTipsView");
              if (paramAnonymousContext.getVisibility() == 0) {
                break label449;
              }
              if ((!BizVideoDetailUI.f(this.nMB).isPlaying()) || (this.nMB.nMj) || ((BizVideoDetailUI.f(this.nMB).bOc()) && (BizVideoDetailUI.f(this.nMB).bjb()))) {
                break;
              }
              BizVideoDetailUI.b(this.nMB, true);
              AppMethodBeat.o(7132);
              return;
            }
            this.nMB.nMg = true;
            AppMethodBeat.o(7132);
            return;
            label441:
            BizVideoDetailUI.a(this.nMB, 0L);
            label449:
            AppMethodBeat.o(7132);
          }
        });
      }
      getContext().registerReceiver(this.nMy, (IntentFilter)localObject1);
      AppMethodBeat.o(7155);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        ac.w(((b)localObject1).TAG, "init parse url exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.w(((b)localObject1).TAG, "init parse url exp %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void jc(boolean paramBoolean)
  {
    AppMethodBeat.i(7166);
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h localh = this.nLY;
    if (localh != null)
    {
      ac.i("MicroMsg.BizVideoOrientationHelper", "enable :".concat(String.valueOf(paramBoolean)));
      if (localh.auS())
      {
        Object localObject;
        if (paramBoolean)
        {
          localh.nOg.enable();
          if (localh.mSensorManager == null)
          {
            localObject = ai.getContext().getSystemService("sensor");
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
              localh.nOe = ((Sensor)localObject);
              localObject = localh.mSensorManager;
              if (localObject == null) {
                break;
              }
              ((SensorManager)localObject).registerListener((SensorEventListener)localh, localh.nOe, 3);
              AppMethodBeat.o(7166);
              return;
            }
            AppMethodBeat.o(7166);
          }
        }
        else
        {
          localh.nOg.disable();
          localObject = localh.jYQ.get();
          if (localObject == null)
          {
            localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(7166);
            throw ((Throwable)localObject);
          }
          ((MMActivity)localObject).setRequestedOrientation(1);
          localh.hbT = 0;
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
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o localo = this.nKF;
    Object localObject3;
    int i;
    if (paramInt1 == 1) {
      if (paramInt2 == -1)
      {
        localObject2 = (Context)localo.bMK();
        localObject3 = localo.bMK();
        if (localObject3 != null) {
          localObject1 = ((TmplShareWebViewToolUI)localObject3).getString(2131756660);
        }
        com.tencent.mm.ui.base.h.cd((Context)localObject2, (String)localObject1);
        if (localo.nPs)
        {
          i = 11;
          localObject1 = localo.nMS;
          if (localObject1 == null) {
            d.g.b.k.aVY("controller");
          }
          ((b)localObject1).nLw.aE(i, localo.nPu);
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
            localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.g.nOc;
            localObject3 = localo.nLB;
            if (localObject3 == null) {
              d.g.b.k.aVY("msgInfo");
            }
            b localb = localo.nMS;
            if (localb == null) {
              d.g.b.k.aVY("controller");
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.g.a((String)localObject1, (x)localObject3, (String)localObject2, localb, (com.tencent.mm.ipcinvoker.d)new o.a(localo));
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
    if (this.jim)
    {
      bMO().q(false, 0);
      AppMethodBeat.o(7185);
      return;
    }
    com.tencent.mm.plugin.webview.ui.tools.widget.n localn = eDG();
    if ((localn.getSayFooter().eGD()) && (localn.bjw())) {
      localn.getSayFooter().dRi();
    }
    for (;;)
    {
      if (i == 0) {
        super.onBackPressed();
      }
      AppMethodBeat.o(7185);
      return;
      if ((localn.CAP != -3) && (localn.bjw())) {
        localn.hide();
      } else {
        i = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7179);
    this.nMn.Up("21");
    this.nMn.Up("22");
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.nMn.Uo("2"), this.nMn);
    bNb();
    super.onDestroy();
    localObject = this.nLZ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.widget.a)localObject).b(this.nMu);
    }
    bMp();
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.Un(((BizVideoDetailUI)this).toString());
    AppMethodBeat.o(7179);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(7186);
    ac.i(this.TAG, "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.jim))
    {
      bMO().q(false, 0);
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
    Object localObject = bMO();
    ac.i(MPVideoView.TAG, "onUIPause");
    localObject = ((MPVideoView)localObject).nRg;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    ((MPExoVideoWrapper)localObject).nQx = true;
    ((MPExoVideoWrapper)localObject).nQt.YC();
    ((MPExoVideoWrapper)localObject).setKeepScreenOn(false);
    ((MPExoVideoWrapper)localObject).kWm = ((MPExoVideoWrapper)localObject).isPlaying();
    ((MPExoVideoWrapper)localObject).pause();
    ((MPExoVideoWrapper)localObject).kWa = false;
    AppMethodBeat.o(7174);
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(7180);
    bNb();
    bMp();
    super.onReset();
    AppMethodBeat.o(7180);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(7170);
    super.onResume();
    Object localObject = bMO();
    ac.i(MPVideoView.TAG, "onUIResume");
    if (((MPVideoView)localObject).kON)
    {
      ac.i(MPVideoView.TAG, "onUIResume, should skip ui resume");
      ((MPVideoView)localObject).kON = false;
      AppMethodBeat.o(7170);
      return;
    }
    localObject = ((MPVideoView)localObject).nRg;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    ((MPExoVideoWrapper)localObject).nQx = false;
    ((MPExoVideoWrapper)localObject).kWa = true;
    if ((((MPExoVideoWrapper)localObject).nQr != null) && (((MPExoVideoWrapper)localObject).cki) && ((((MPExoVideoWrapper)localObject).kWm) || (((MPExoVideoWrapper)localObject).nQv)))
    {
      ac.i(MPExoVideoWrapper.TAG, "onUIResume, isPlayOnUiPause =" + ((MPExoVideoWrapper)localObject).kWm + ", mPlayingWhenBackground " + ((MPExoVideoWrapper)localObject).nQv);
      ((MPExoVideoWrapper)localObject).start();
    }
    AppMethodBeat.o(7170);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(7171);
    super.onStart();
    if (bMi().hkX == null)
    {
      finish();
      ac.w(this.TAG, "onStart msgInfo.item is null");
      AppMethodBeat.o(7171);
      return;
    }
    ac.i(this.TAG, "alvinluo onStart handleAnimation coverUrl: %s", new Object[] { bMi().hkX.hld });
    bMh().bringToFront();
    bMO().bNR();
    AppMethodBeat.o(7171);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void zh(int paramInt)
  {
    AppMethodBeat.i(175508);
    i locali = this.nMb;
    d.g.a.a locala = (d.g.a.a)new w(this);
    d.g.b.k.h(locala, "onUpdateView");
    boolean bool;
    if ((locali.width <= 0) || (locali.height <= 0))
    {
      ac.w("MicroMsg.BizVideoPosHelper", "onWebViewScrollChanged invalid params x=" + locali.x + ", y=" + locali.y + ", width=" + locali.width + ", height=" + locali.height);
      bool = false;
    }
    while (!bool)
    {
      AppMethodBeat.o(175508);
      return;
      int i = locali.nOu;
      locali.nOu = (locali.y - paramInt);
      if (locali.nOu < i) {
        if (locali.nOu > 0) {
          locali.zp(locali.nOu);
        }
      }
      for (;;)
      {
        bool = true;
        break;
        if ((locali.nOq != 1) && (locali.nOm != locali.kWB))
        {
          ac.d("MicroMsg.BizVideoPosHelper", "onWebViewScrollChanged currentVideoWidth=" + locali.nOm + ", screenWidth=" + locali.kWB);
          locali.nOq = 1;
          locali.b(true, (d.g.a.a)new i.c(locala));
          bool = false;
          break;
        }
        bool = locali.zq(Math.abs(locali.nOu));
        break;
        if (locali.nOu <= i) {
          break label388;
        }
        if (locali.nOu < 0)
        {
          bool = locali.zq(Math.abs(locali.nOu));
          break;
        }
        if ((locali.nOq != 2) && (locali.nOm != locali.width))
        {
          locali.nOq = 2;
          locali.b(false, (d.g.a.a)new i.d(locala));
          bool = false;
          break;
        }
        locali.zp(locali.nOu);
      }
      label388:
      bool = false;
    }
    bMY();
    AppMethodBeat.o(175508);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<FrameLayout>
  {
    a(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class aa
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    aa(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ab
    extends d.g.b.l
    implements d.g.a.a<LinearLayout>
  {
    ab(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ac
    extends d.g.b.l
    implements d.g.a.a<MPVideoErrorView>
  {
    ac(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "invoke"})
  static final class ad
    extends d.g.b.l
    implements d.g.a.a<MPVideoView>
  {
    ad(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
  static final class ae
    extends d.g.b.l
    implements d.g.a.a<FrameLayout>
  {
    ae(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class af
    extends d.g.b.l
    implements d.g.a.a<MPVideoWifiTipsView>
  {
    af(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<ImageView>
  {
    b(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    c(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<FrameLayout>
  {
    d(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class e
    implements IPCRunCgi.a
  {
    e(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(7087);
      BizVideoDetailUI.k(this.nMB).bMJ();
      if (paramb == null)
      {
        AppMethodBeat.o(7087);
        return;
      }
      ac.i(BizVideoDetailUI.m(this.nMB), "onSceneEnd errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString + ", type: " + paramb.getType());
      Object localObject = paramb.aBC();
      if ((((localObject instanceof fa)) && (((fa)localObject).DRm != BizVideoDetailUI.k(this.nMB).nLA)) || (((localObject instanceof ez)) && (((ez)localObject).DRm != BizVideoDetailUI.k(this.nMB).nLA)))
      {
        AppMethodBeat.o(7087);
        return;
      }
      if (paramb.getType() == 1179)
      {
        this.nMB.nMi = true;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          BizVideoDetailUI.s(this.nMB);
          paramString = paramb.aBD();
          if (paramString == null)
          {
            paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgGetResp");
            AppMethodBeat.o(7087);
            throw paramString;
          }
          paramString = (fb)paramString;
          paramb = BizVideoDetailUI.m(this.nMB);
          localObject = new StringBuilder("url_info size is ");
          LinkedList localLinkedList;
          if (paramString.DRV != null)
          {
            localLinkedList = paramString.DRV;
            if (localLinkedList == null) {
              d.g.b.k.fOy();
            }
          }
          for (paramInt1 = localLinkedList.size();; paramInt1 = 0)
          {
            ac.i(paramb, paramInt1);
            if ((paramString.DRW == 0) || (bs.isNullOrNil(paramString.DRX))) {
              break;
            }
            ac.i(BizVideoDetailUI.m(this.nMB), "onSceneEnd redirect %s", new Object[] { paramString.DRX });
            paramb = this.nMB;
            paramString = paramString.DRX;
            d.g.b.k.g(paramString, "resp.redirect_url");
            paramb.Uj(paramString);
            AppMethodBeat.o(7087);
            return;
          }
          this.nMB.a(paramString);
          AppMethodBeat.o(7087);
          return;
        }
        this.nMB.a(null);
        BizVideoDetailUI.q(this.nMB);
        paramb = BizVideoDetailUI.p(this.nMB);
        paramb.nMO.setBackgroundResource(2131231310);
        if (!bs.isNullOrNil(paramString)) {
          paramb.nMN.setText((CharSequence)(paramb.getContext().getString(2131761343) + ' ' + paramString));
        }
        for (;;)
        {
          paramb.fvu.setClickable(true);
          if (paramInt1 != 2) {
            break;
          }
          com.tencent.mm.plugin.webview.h.a.Vj(2);
          AppMethodBeat.o(7087);
          return;
          paramb.nMN.setText((CharSequence)paramb.getContext().getString(2131761343));
        }
        com.tencent.mm.plugin.webview.h.a.Vj(3);
        AppMethodBeat.o(7087);
        return;
      }
      AppMethodBeat.o(7087);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "posInfo", "", "webvieId", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.m<String, Integer, y>
  {
    h(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "view", "Lcom/tencent/xweb/WebView;", "url", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.m<WebView, String, y>
  {
    i(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<FrameLayout>
  {
    j(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "onExitFullscreen", "", "plugin-brandservice_release"})
  public static final class k
    extends com.tencent.mm.plugin.brandservice.ui.widget.b
  {
    public final void Cb()
    {
      AppMethodBeat.i(7099);
      BizVideoDetailUI.a(this.nMB, false);
      if (BizVideoDetailUI.f(this.nMB).getParent() == null) {
        BizVideoDetailUI.e(this.nMB).addView((View)BizVideoDetailUI.f(this.nMB), 0);
      }
      AppMethodBeat.o(7099);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(175501);
      MPVideoWifiTipsView localMPVideoWifiTipsView = BizVideoDetailUI.i(this.nMB);
      d.g.b.k.g(localMPVideoWifiTipsView, "videoWifiTipsView");
      localMPVideoWifiTipsView.setVisibility(8);
      AppMethodBeat.o(175501);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class m
    implements MenuItem.OnMenuItemClickListener
  {
    m(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(7101);
      this.nMB.hideVKB();
      BizVideoDetailUI.a(this.nMB);
      AppMethodBeat.o(7101);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initComment$1$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "onHide", "", "onShow", "plugin-brandservice_release"})
  public static final class n
    implements n.c
  {
    n(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void onHide()
    {
      AppMethodBeat.i(7103);
      BizVideoDetailUI.a(this.nMB, this.nMB.nMb.width, this.nMB.nMb.height);
      AppMethodBeat.o(7103);
    }
    
    public final void onShow()
    {
      AppMethodBeat.i(7104);
      this.nMB.jc(false);
      AppMethodBeat.o(7104);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "enterFullScreen", "", "direction", "", "quitFullScreen", "plugin-brandservice_release"})
  public static final class o
    implements MPVideoView.b
  {
    public final void bha()
    {
      AppMethodBeat.i(7107);
      BizVideoDetailUI.a(this.nMB, "exitFullScreen", "");
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
      localObject = BizVideoDetailUI.d(this.nMB).Uo("18");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((eo)localObject, "FullScreenSwitch", "2");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((eo)localObject, BizVideoDetailUI.d(this.nMB));
      com.tencent.mm.plugin.ball.f.f.bHl();
      BizVideoDetailUI.g(this.nMB).aUJ();
      this.nMB.setRequestedOrientation(1);
      BizVideoDetailUI.k(this.nMB).nLI.eb(6, 0);
      localObject = BizVideoDetailUI.j(this.nMB);
      d.g.b.k.g(localObject, "videoAdTitleBar");
      ((LinearLayout)localObject).setVisibility(8);
      BizVideoDetailUI.l(this.nMB);
      AppMethodBeat.o(7107);
    }
    
    public final boolean isFullScreen()
    {
      AppMethodBeat.i(7105);
      boolean bool = BizVideoDetailUI.c(this.nMB);
      AppMethodBeat.o(7105);
      return bool;
    }
    
    public final void sC(int paramInt)
    {
      AppMethodBeat.i(7106);
      BizVideoDetailUI.a(this.nMB, "enterFullScreen", "");
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
      localObject = BizVideoDetailUI.d(this.nMB).Uo("18");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((eo)localObject, "FullScreenSwitch", "1");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((eo)localObject, BizVideoDetailUI.d(this.nMB));
      com.tencent.mm.plugin.ball.f.f.bHm();
      BizVideoDetailUI.e(this.nMB).removeView((View)BizVideoDetailUI.f(this.nMB));
      this.nMB.nMb.a(-16777216, BizVideoDetailUI.f(this.nMB));
      BizVideoDetailUI.a(this.nMB, true);
      BizVideoDetailUI.g(this.nMB).O((View)BizVideoDetailUI.f(this.nMB), paramInt);
      if ((paramInt == 0) || (paramInt == 180)) {
        BizVideoDetailUI.f(this.nMB).setPageGestureInFullscreen(false);
      }
      for (;;)
      {
        localObject = BizVideoDetailUI.h(this.nMB);
        if ((localObject == null) || (((FrameLayout)localObject).getVisibility() != 0))
        {
          localObject = BizVideoDetailUI.i(this.nMB);
          d.g.b.k.g(localObject, "videoWifiTipsView");
          if (((MPVideoWifiTipsView)localObject).getVisibility() != 0) {}
        }
        else
        {
          localObject = BizVideoDetailUI.j(this.nMB);
          d.g.b.k.g(localObject, "videoAdTitleBar");
          ((LinearLayout)localObject).setVisibility(0);
        }
        BizVideoDetailUI.k(this.nMB).nLI.eb(5, 0);
        BizVideoDetailUI.l(this.nMB);
        AppMethodBeat.o(7106);
        return;
        BizVideoDetailUI.f(this.nMB).setPageGestureInFullscreen(true);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$2", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "bufferResolutionStartTime", "", "getBufferResolutionStartTime", "()J", "setBufferResolutionStartTime", "(J)V", "bufferSeekStartTime", "getBufferSeekStartTime", "setBufferSeekStartTime", "hasBufferingResolution", "", "getHasBufferingResolution", "()Z", "setHasBufferingResolution", "(Z)V", "hasBufferingSeek", "getHasBufferingSeek", "setHasBufferingSeek", "playEnd", "getPlayEnd", "setPlayEnd", "startPlayTime", "getStartPlayTime", "setStartPlayTime", "startWaitTime", "getStartWaitTime", "setStartWaitTime", "onControlbarVisible", "", "visible", "onEndDragProgress", "onGetVideoSize", "width", "", "height", "onHideSwitchResolutionLayout", "onHideSwitchSpeedLayout", "onPlayError", "errorMsg", "", "errorCode", "onSeekPre", "onSeekTo", "time", "onStartDragProgress", "onUpdateProgress", "progressLen", "totalLen", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoPrepare", "firstRenderTime", "onVideoWaiting", "onVideoWaitingEnd", "resolutionBtnClick", "speedBtnClick", "switchResolution", "beforeType", "afterType", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "switchSpeed", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
  public static final class p
    implements MPVideoView.c
  {
    private long hto = -1L;
    private long nME = -1L;
    private boolean nMF;
    private long nMG = -1L;
    private long nMH = -1L;
    private boolean nMI;
    private boolean nMJ;
    
    public final void Ul(String paramString)
    {
      AppMethodBeat.i(7117);
      d.g.b.k.h(paramString, "errorMsg");
      BizVideoDetailUI.k(this.nMB).nLI.nOX = paramString;
      BizVideoDetailUI.k(this.nMB).nLI.eb(11, 0);
      BizVideoDetailUI.p(this.nMB).setPlayError$505cff1c(paramString);
      BizVideoDetailUI.q(this.nMB);
      BizVideoDetailUI.a(this.nMB, "error", paramString);
      if (BizVideoDetailUI.f(this.nMB).getPlayStarted()) {
        com.tencent.mm.plugin.webview.h.a.Vj(25);
      }
      for (;;)
      {
        BizVideoDetailUI.d(this.nMB).Up("21");
        BizVideoDetailUI.d(this.nMB).Up("22");
        Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
        localObject = BizVideoDetailUI.d(this.nMB).Uo("16");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((eo)localObject, "PlayErrReason", paramString);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((eo)localObject, BizVideoDetailUI.d(this.nMB));
        AppMethodBeat.o(7117);
        return;
        com.tencent.mm.plugin.webview.h.a.Vj(24);
      }
    }
    
    public final void a(int paramInt1, int paramInt2, fp paramfp)
    {
      Object localObject2 = null;
      AppMethodBeat.i(175503);
      this.nMB.nMj = true;
      BizVideoDetailUI.k(this.nMB).nLI.nPb = paramInt1;
      BizVideoDetailUI.k(this.nMB).nLI.nPa = paramInt2;
      BizVideoDetailUI.k(this.nMB).nLI.eb(22, 0);
      BizVideoDetailUI.d(this.nMB).Up("21");
      BizVideoDetailUI.d(this.nMB).Up("22");
      Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
      eo localeo = BizVideoDetailUI.d(this.nMB).Uo("4");
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localeo, "DefinitionBefore", String.valueOf(paramInt1));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localeo, "DefinitionAfter", String.valueOf(paramInt2));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localeo, "WidthBefore", String.valueOf(BizVideoDetailUI.k(this.nMB).nLI.width));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localeo, "HeightBefore", String.valueOf(BizVideoDetailUI.k(this.nMB).nLI.height));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
      if (paramfp != null) {}
      for (localObject1 = Integer.valueOf(paramfp.width);; localObject1 = null)
      {
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localeo, "WidthAfter", String.valueOf(localObject1));
        localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
        localObject1 = localObject2;
        if (paramfp != null) {
          localObject1 = Integer.valueOf(paramfp.height);
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localeo, "HeightAfter", String.valueOf(localObject1));
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localeo, BizVideoDetailUI.d(this.nMB));
        com.tencent.mm.plugin.webview.h.a.Vj(81);
        this.nMH = System.currentTimeMillis();
        if (paramfp != null)
        {
          BizVideoDetailUI.k(this.nMB).nLx = paramfp.nLx;
          BizVideoDetailUI.k(this.nMB).nLy = paramfp.DSK;
          BizVideoDetailUI.k(this.nMB).nLI.width = paramfp.width;
          BizVideoDetailUI.k(this.nMB).nLI.height = paramfp.height;
        }
        BizVideoDetailUI.a(this.nMB, "switchVideo", "");
        AppMethodBeat.o(175503);
        return;
      }
    }
    
    public final void a(c.a parama1, c.a parama2)
    {
      AppMethodBeat.i(199152);
      BizVideoDetailUI.d(this.nMB).Up("21");
      BizVideoDetailUI.d(this.nMB).Up("22");
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
      eo localeo = BizVideoDetailUI.d(this.nMB).Uo("19");
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
      if (parama1 != null)
      {
        localObject = String.valueOf(parama1.nRd);
        parama1 = (c.a)localObject;
        if (localObject != null) {}
      }
      else
      {
        parama1 = "";
      }
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localeo, "SpeedBefore", parama1);
      parama1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
      if (parama2 != null)
      {
        parama2 = String.valueOf(parama2.nRd);
        parama1 = parama2;
        if (parama2 != null) {}
      }
      else
      {
        parama1 = "";
      }
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localeo, "SpeedAfter", parama1);
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localeo, BizVideoDetailUI.d(this.nMB));
      AppMethodBeat.o(199152);
    }
    
    public final void anR()
    {
      AppMethodBeat.i(199151);
      BizVideoDetailUI.a(this.nMB, "seekBegin", "");
      BizVideoDetailUI.d(this.nMB).Up("21");
      BizVideoDetailUI.d(this.nMB).Up("22");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(BizVideoDetailUI.d(this.nMB).Uo("20"), BizVideoDetailUI.d(this.nMB));
      AppMethodBeat.o(199151);
    }
    
    public final void bNr()
    {
      AppMethodBeat.i(175502);
      i locali = this.nMB.nMb;
      MPVideoView localMPVideoView = BizVideoDetailUI.f(this.nMB);
      d.g.b.k.h(localMPVideoView, "videoVideo");
      locali.nOr = localMPVideoView;
      if (!localMPVideoView.bjb()) {
        locali.bNC();
      }
      AppMethodBeat.o(175502);
    }
    
    public final void bNs()
    {
      AppMethodBeat.i(7113);
      BizVideoDetailUI.k(this.nMB).nLI.eb(12, 0);
      this.nMG = System.currentTimeMillis();
      BizVideoDetailUI.a(this.nMB, "seekEnd", "");
      AppMethodBeat.o(7113);
    }
    
    public final void bNt()
    {
      AppMethodBeat.i(7114);
      BizVideoDetailUI.k(this.nMB).nLI.eb(13, 0);
      this.nMG = System.currentTimeMillis();
      BizVideoDetailUI.a(this.nMB, "seekEnd", "");
      AppMethodBeat.o(7114);
    }
    
    public final void bNu()
    {
      AppMethodBeat.i(7116);
      String str;
      if (this.nMJ)
      {
        BizVideoDetailUI.k(this.nMB).nLI.eN((int)(System.currentTimeMillis() - this.nME), 31);
        str = "3";
      }
      for (;;)
      {
        Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
        localObject = BizVideoDetailUI.d(this.nMB).Uo("17");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((eo)localObject, "BufferReason", str);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((eo)localObject, BizVideoDetailUI.d(this.nMB), String.valueOf(System.currentTimeMillis() - 500L));
        this.nMH = -1L;
        this.nMG = -1L;
        this.nMJ = false;
        this.nMI = false;
        if (!BizVideoDetailUI.f(this.nMB).isPlaying()) {
          break;
        }
        BizVideoDetailUI.a(this.nMB, "play", "");
        AppMethodBeat.o(7116);
        return;
        if (this.nMI)
        {
          BizVideoDetailUI.k(this.nMB).nLI.eN((int)(System.currentTimeMillis() - this.nME), 30);
          str = "2";
        }
        else
        {
          BizVideoDetailUI.k(this.nMB).nLI.eN((int)(System.currentTimeMillis() - this.nME), 29);
          str = "1";
        }
      }
      BizVideoDetailUI.a(this.nMB, "pause", "");
      AppMethodBeat.o(7116);
    }
    
    public final void bNv()
    {
      AppMethodBeat.i(7119);
      BizVideoDetailUI.s(this.nMB);
      this.nMB.bNo();
      AppMethodBeat.o(7119);
    }
    
    public final void bNw()
    {
      AppMethodBeat.i(7121);
      BizVideoDetailUI.k(this.nMB).nLI.eb(21, 0);
      this.nMB.nMj = true;
      this.nMB.bNd();
      com.tencent.mm.plugin.webview.h.a.Vj(80);
      BizVideoDetailUI.a(this.nMB, 0L);
      AppMethodBeat.o(7121);
    }
    
    public final void bNx()
    {
      boolean bool = true;
      AppMethodBeat.i(175504);
      this.nMB.nMj = false;
      BizVideoDetailUI localBizVideoDetailUI;
      if ((this.nMB.nMg) && (BizVideoDetailUI.f(this.nMB).isPlaying()))
      {
        localBizVideoDetailUI = this.nMB;
        if (BizVideoDetailUI.f(this.nMB).getCurrPosSec() <= 1) {
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
    
    public final void bjl()
    {
      AppMethodBeat.i(199150);
      BizVideoDetailUI.a(this.nMB, "seekBegin", "");
      BizVideoDetailUI.d(this.nMB).Up("21");
      BizVideoDetailUI.d(this.nMB).Up("22");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nOE;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(BizVideoDetailUI.d(this.nMB).Uo("20"), BizVideoDetailUI.d(this.nMB));
      AppMethodBeat.o(199150);
    }
    
    public final void je(boolean paramBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(7118);
      BizVideoDetailUI.r(this.nMB);
      if (paramBoolean)
      {
        BizVideoDetailUI.a(this.nMB, 0L);
        AppMethodBeat.o(7118);
        return;
      }
      BizVideoDetailUI localBizVideoDetailUI;
      if (this.nMB.nMg)
      {
        localBizVideoDetailUI = this.nMB;
        if (BizVideoDetailUI.f(this.nMB).getCurrPosSec() <= 1) {
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
      BizVideoDetailUI.k(this.nMB).nLI.eb(7, 0);
      BizVideoDetailUI.a(this.nMB, "ended", "");
      this.nMB.bNd();
      BizVideoDetailUI.o(this.nMB);
      if (!this.nMF)
      {
        this.nMF = true;
        com.tencent.mm.plugin.webview.h.a.Vj(27);
      }
      AppMethodBeat.o(7112);
    }
    
    public final void onVideoPause()
    {
      AppMethodBeat.i(7111);
      if (BizVideoDetailUI.f(this.nMB).getPlayStatus() == 2) {
        BizVideoDetailUI.k(this.nMB).nLI.eb(8, 0);
      }
      BizVideoDetailUI.a(this.nMB, "pause", "");
      BizVideoDetailUI.d(this.nMB).Up("21");
      BizVideoDetailUI.d(this.nMB).Uo("22");
      AppMethodBeat.o(7111);
    }
    
    public final void onVideoPlay()
    {
      AppMethodBeat.i(7110);
      this.nMB.nMj = false;
      BizVideoDetailUI.k(this.nMB);
      int i = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.zs(BizVideoDetailUI.f(this.nMB).getPlayStatus());
      BizVideoDetailUI.k(this.nMB).nLI.eb(i, 0);
      BizVideoDetailUI.n(this.nMB);
      BizVideoDetailUI.a(this.nMB, "play", "");
      if (this.hto < 0L)
      {
        com.tencent.mm.plugin.webview.h.a.Vj(6);
        if (this.nMB.nMh) {
          com.tencent.mm.plugin.webview.h.a.Vj(19);
        }
        this.hto = System.currentTimeMillis();
      }
      Object localObject1;
      if ((this.nMB.nMg) && (!this.nMB.nMj) && ((!BizVideoDetailUI.f(this.nMB).bOc()) || (!BizVideoDetailUI.f(this.nMB).bjb())))
      {
        localObject1 = this.nMB;
        if (BizVideoDetailUI.f(this.nMB).getCurrPosSec() <= 1) {
          break label430;
        }
      }
      label430:
      for (boolean bool = true;; bool = false)
      {
        BizVideoDetailUI.b((BizVideoDetailUI)localObject1, bool);
        com.tencent.mm.sdk.platformtools.ap.n((Runnable)new a(this), 300L);
        localObject1 = this.nMB.nMb;
        Object localObject2 = (d.g.a.a)new b(this);
        d.g.b.k.h(localObject2, "onUpdateView");
        if ((((i)localObject1).nOo != 0) && (((i)localObject1).nOu <= 0) && (((i)localObject1).nOm == ((i)localObject1).kWB) && (((i)localObject1).nOl <= ((i)localObject1).nOp) && (!((i)localObject1).bNB()))
        {
          Object localObject3 = ((i)localObject1).nOr;
          if ((localObject3 != null) && (((MPVideoView)localObject3).isPlaying() == true))
          {
            ((i)localObject1).nOn = ((i)localObject1).btU;
            localObject3 = ((i)localObject1).nOv;
            if (localObject3 != null) {
              ((ValueAnimator)localObject3).removeAllUpdateListeners();
            }
            ((i)localObject1).nOv = ValueAnimator.ofInt(new int[] { ((i)localObject1).nOl, ((i)localObject1).nOo });
            localObject3 = ((i)localObject1).nOv;
            if (localObject3 != null) {
              ((ValueAnimator)localObject3).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new i.f((i)localObject1, (d.g.a.a)localObject2));
            }
            localObject2 = ((i)localObject1).nOv;
            if (localObject2 != null) {
              ((ValueAnimator)localObject2).setDuration(200L);
            }
            localObject1 = ((i)localObject1).nOv;
            if (localObject1 != null) {
              ((ValueAnimator)localObject1).start();
            }
          }
        }
        BizVideoDetailUI.d(this.nMB).Up("22");
        BizVideoDetailUI.d(this.nMB).Uo("21");
        AppMethodBeat.o(7110);
        return;
      }
    }
    
    public final void onVideoWaiting()
    {
      AppMethodBeat.i(7115);
      if (this.hto > 0L) {
        BizVideoDetailUI.n(this.nMB);
      }
      this.nME = System.currentTimeMillis();
      BizVideoDetailUI.a(this.nMB, "waiting", "");
      if ((this.nMH != -1L) && ((int)(System.currentTimeMillis() - this.nMH) < 1000L)) {
        this.nMJ = true;
      }
      for (;;)
      {
        BizVideoDetailUI.d(this.nMB).Up("21");
        BizVideoDetailUI.d(this.nMB).Up("22");
        BizVideoDetailUI.d(this.nMB).Uo("17");
        AppMethodBeat.o(7115);
        return;
        if ((this.nMG != -1L) && ((int)(System.currentTimeMillis() - this.nMG) < 1000L)) {
          this.nMI = true;
        }
      }
    }
    
    public final void ru(long paramLong)
    {
      AppMethodBeat.i(177795);
      BizVideoDetailUI.k(this.nMB).nLI.eb(32, (int)paramLong);
      ac.v(BizVideoDetailUI.m(this.nMB), "[KEY_TIME] onVideoPrepare firstRenderTime = ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(177795);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BizVideoDetailUI.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7108);
        BizVideoDetailUI.bNq();
        AppMethodBeat.o(7108);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(BizVideoDetailUI.p paramp)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7122);
      BizVideoDetailUI.f(this.nMB).q(false, 0);
      AppMethodBeat.o(7122);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "e", "Landroid/view/MotionEvent;", "onTouch"})
  static final class r
    implements View.OnTouchListener
  {
    r(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(7123);
      paramView = BizVideoDetailUI.f(this.nMB);
      View localView = (View)this.nMB.bMk();
      d.g.b.k.g(paramMotionEvent, "e");
      d.g.b.k.h(localView, "v");
      d.g.b.k.h(paramMotionEvent, "e");
      boolean bool;
      switch (paramMotionEvent.getAction())
      {
      default: 
        bool = paramView.nRt;
      }
      for (;;)
      {
        if (bool)
        {
          BizVideoDetailUI.f(this.nMB).Q(paramMotionEvent);
          if (paramMotionEvent.getAction() == 1) {
            paramMotionEvent.setAction(3);
          }
        }
        AppMethodBeat.o(7123);
        return false;
        if ((!paramView.nRu) && (paramMotionEvent.getY() >= localView.getY()) && (paramMotionEvent.getY() <= localView.getY() + paramView.getHeight()) && (paramMotionEvent.getX() >= localView.getX()) && (paramMotionEvent.getX() <= localView.getX() + paramView.getWidth())) {
          paramView.nRt = true;
        }
        paramView.nRu = true;
        break;
        bool = paramView.nRt;
        paramView.nRt = false;
        paramView.nRu = false;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7124);
      if (BizVideoDetailUI.f(this.nMB).isPlaying())
      {
        BizVideoDetailUI.f(this.nMB).pause();
        paramView = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.nPf;
        m.a.zt(37);
        AppMethodBeat.o(7124);
        return;
      }
      BizVideoDetailUI.f(this.nMB).start();
      paramView = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.nPf;
      m.a.zt(38);
      AppMethodBeat.o(7124);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$onShowAd$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
  public static final class u
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(7126);
      Object localObject = BizVideoDetailUI.h(this.nMB);
      if (localObject != null)
      {
        localObject = ((FrameLayout)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      localObject = this.nMB.Cjc;
      if (localObject != null) {
        ((com.tencent.mm.plugin.webview.c.f)localObject).aBl("appear");
      }
      localObject = this.nMB.nMc;
      if (localObject != null)
      {
        localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.webview.c.f)localObject).aBl("appear");
          AppMethodBeat.o(7126);
          return;
        }
      }
      AppMethodBeat.o(7126);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$onShowDot$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
  public static final class v
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(7127);
      Object localObject = BizVideoDetailUI.u(this.nMB);
      if (localObject != null)
      {
        localObject = ((FrameLayout)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      if (this.nMB.nMd != null)
      {
        ac.i(BizVideoDetailUI.m(this.nMB), "onShowDot appear");
        localObject = this.nMB.Cjc;
        int i;
        MMWebViewWithJsApi localMMWebViewWithJsApi;
        if (localObject != null)
        {
          i = this.nMB.bNn();
          localMMWebViewWithJsApi = this.nMB.nMd;
          if (localMMWebViewWithJsApi == null) {
            d.g.b.k.fOy();
          }
          ((com.tencent.mm.plugin.webview.c.f)localObject).L(i, localMMWebViewWithJsApi.hashCode(), "appear");
        }
        localObject = this.nMB.nMd;
        if (localObject != null)
        {
          localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
          if (localObject != null)
          {
            i = this.nMB.bNn();
            localMMWebViewWithJsApi = this.nMB.nMd;
            if (localMMWebViewWithJsApi == null) {
              d.g.b.k.fOy();
            }
            ((com.tencent.mm.plugin.webview.c.f)localObject).L(i, localMMWebViewWithJsApi.hashCode(), "appear");
            AppMethodBeat.o(7127);
            return;
          }
        }
      }
      AppMethodBeat.o(7127);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class w
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    w(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$setTouchListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/LogoWebViewWrapper$MMOverScrollOffsetListener;", "onMMOverScrollOffset", "", "offset", "", "pointerDown", "", "onMMOverScrollUp", "plugin-brandservice_release"})
  public static final class x
    implements LogoWebViewWrapper.b
  {
    public final void S(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(7129);
      Object localObject1 = this.nMB.bMk();
      Object localObject2 = this.nMB.bMk().getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(7129);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      ((FrameLayout.LayoutParams)localObject2).topMargin = (this.nMB.nMb.y - paramInt);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = BizVideoDetailUI.t(this.nMB);
      d.g.b.k.g(localObject1, "animationLayout");
      if (((View)localObject1).getVisibility() == 0)
      {
        localObject1 = BizVideoDetailUI.t(this.nMB);
        d.g.b.k.g(localObject1, "animationLayout");
        localObject2 = BizVideoDetailUI.t(this.nMB);
        d.g.b.k.g(localObject2, "animationLayout");
        localObject2 = ((View)localObject2).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new d.v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(7129);
          throw ((Throwable)localObject1);
        }
        localObject2 = (FrameLayout.LayoutParams)localObject2;
        ((FrameLayout.LayoutParams)localObject2).topMargin = (this.nMB.nMb.y - paramInt);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      AppMethodBeat.o(7129);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class y
    implements Runnable
  {
    y(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(175506);
      BizVideoDetailUI.a(this.nMB, 300L);
      AppMethodBeat.o(175506);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class z
    implements ValueAnimator.AnimatorUpdateListener
  {
    z(BizVideoDetailUI paramBizVideoDetailUI, v.d paramd) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(7133);
      if (BizVideoDetailUI.u(this.nMB) != null)
      {
        localFrameLayout = BizVideoDetailUI.u(this.nMB);
        if (localFrameLayout == null) {
          d.g.b.k.fOy();
        }
        if (localFrameLayout.getVisibility() != 8) {}
      }
      else
      {
        AppMethodBeat.o(7133);
        return;
      }
      d.g.b.k.g(paramValueAnimator, "valueAnimator");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new d.v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(7133);
        throw paramValueAnimator;
      }
      int i = ((Integer)paramValueAnimator).intValue();
      FrameLayout localFrameLayout = BizVideoDetailUI.u(this.nMB);
      if (localFrameLayout != null)
      {
        paramValueAnimator = BizVideoDetailUI.u(this.nMB);
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
      if (i == this.nMM.KUO) {
        BizVideoDetailUI.l(this.nMB);
      }
      AppMethodBeat.o(7133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI
 * JD-Core Version:    0.7.0.1
 */