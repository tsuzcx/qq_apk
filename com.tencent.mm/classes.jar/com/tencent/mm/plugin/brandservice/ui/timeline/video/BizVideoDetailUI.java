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
import com.tencent.mm.ai.x;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.p;
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
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o;
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
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.protobuf.do;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.ey;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import d.g.b.u;
import d.g.b.v.c;
import d.g.b.w;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/preload/api/IBizVideoPage;", "()V", "TAG", "", "adView", "Landroid/widget/FrameLayout;", "getAdView", "()Landroid/widget/FrameLayout;", "adView$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "adWebView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "getAdWebView", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "setAdWebView", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;)V", "adWebViewReady", "", "getAdWebViewReady", "()Z", "setAdWebViewReady", "(Z)V", "animationIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAnimationIv", "()Landroid/widget/ImageView;", "animationIv$delegate", "animationLayout", "Landroid/view/View;", "getAnimationLayout", "()Landroid/view/View;", "animationLayout$delegate", "appMsgGetResp", "Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;", "getAppMsgGetResp", "()Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;", "setAppMsgGetResp", "(Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;)V", "appmsgDone", "getAppmsgDone", "setAppmsgDone", "backgroundContainerView", "getBackgroundContainerView", "backgroundContainerView$delegate", "bizVideoDotHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotHelper;", "bizVideoPosHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "getBizVideoPosHelper", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "setBizVideoPosHelper", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;)V", "bizVideoProfiler", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "cgiCallback", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "commentUrl", "currentDot", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "density", "", "getDensity", "()F", "setDensity", "(F)V", "dotView", "getDotView", "dotView$delegate", "dotWebView", "getDotWebView", "setDotWebView", "dotWebViewReady", "getDotWebViewReady", "setDotWebViewReady", "fullscreenImpl", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenImpl;", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "getAppMsgDone", "getGetAppMsgDone", "setGetAppMsgDone", "hideWifiTipsBarAnim", "Landroid/view/animation/Animation;", "insertVideoDone", "getInsertVideoDone", "setInsertVideoDone", "isInFullScreen", "isNetworkConnected", "needShowWifiTipsView", "getNeedShowWifiTipsView", "setNeedShowWifiTipsView", "networkListener", "Landroid/content/BroadcastReceiver;", "orientationHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper;", "playState", "getPlayState", "()Ljava/lang/String;", "setPlayState", "(Ljava/lang/String;)V", "setFullScreen", "showWifiTipsBarAnim", "showWifiTipsMode", "simcardTpye", "", "switchVideo", "getSwitchVideo", "setSwitchVideo", "switchingResolution", "getSwitchingResolution", "setSwitchingResolution", "titleBarHeight", "uin", "videoAdTitleBack", "getVideoAdTitleBack", "videoAdTitleBack$delegate", "videoAdTitleBar", "Landroid/widget/LinearLayout;", "getVideoAdTitleBar", "()Landroid/widget/LinearLayout;", "videoAdTitleBar$delegate", "videoControlBarHeight", "videoErrView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "getVideoErrView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "videoErrView$delegate", "videoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoView", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "videoView$delegate", "videoViewContainer", "getVideoViewContainer", "videoViewContainer$delegate", "videoWifiTipsView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "getVideoWifiTipsView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "videoWifiTipsView$delegate", "waitToDetroyTime", "", "adWebviewReady", "", "bundle", "Landroid/os/Bundle;", "checkInitOrientationHelper", "w", "h", "closeAdWebview", "closeDotWebview", "createAdWebview", "createDotWebview", "id", "url", "destroyDotWebView", "destroyWebView", "doOnDestroy", "doPlayVideo", "resp", "dotWebviewReady", "enableMinimize", "enableOrientationListener", "enable", "getCurrentDotId", "getCurrentPlayTime", "getForceOrientation", "getFullscreenImpl", "getLastPlayTimeKey", "getMPVideoState", "getMarginValue", "value", "", "fullValue", "getSimCardType", "goneVideoErrorView", "hideCoverLayout", "hideDotWebview", "hideVideoTitleBar", "hideWifiTipsView", "delay", "init", "initActionBar", "initComment", "initControlAreaHeight", "initDensity", "wv", "Lcom/tencent/mm/ui/widget/MMWebView;", "initOrientationHelper", "initReportParams", "initVideoParam", "initVideoView", "initView", "initWebviewSetting", "webview", "insertVideoNativeView", "params", "", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAppMsgGet", "onBackPressed", "onDestroy", "onDestroyReport", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onMPVideoStateChange", "state", "errMsg", "onPageFinished", "view", "Lcom/tencent/xweb/WebView;", "onPageReady", "onPause", "onReset", "onResetAfterCreate", "onResetBeforeCreate", "onResume", "onShowAd", "onShowDot", "onStart", "onWebViewScrollChanged", "scrollY", "opPlayer", "postBinded", "sendMPPageData", "setDotScriptData", "setTouchListener", "shouldShowWifiTips", "duration", "netChange", "showCoverLayout", "showVideoErrorView", "showWifiTipsView", "startMonitorNetWorkChange", "stopMonitorNetWorkChange", "updateDot", "updateDotAttr", "posInfo", "webviewId", "updateDotPos", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotPosInfo;", "updateDotPosIfNeed", "updateVideoPosition", "plugin-brandservice_release"})
public class BizVideoDetailUI
  extends TmplShareWebViewToolUI
  implements com.tencent.mm.plugin.webview.g.a.a
{
  private final String TAG;
  private float density;
  private String eOT;
  private final IPCRunCgi.a jkE;
  private boolean lpO;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.n niU;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.n niV;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.n niW;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.n niX;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.n niY;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.n niZ;
  private Animation njA;
  private com.tencent.mm.plugin.brandservice.ui.widget.b njB;
  private long njC;
  private int njD;
  private int njE;
  private BroadcastReceiver njF;
  private boolean njG;
  private boolean njH;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.n nja;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.n njb;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.n njc;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.n njd;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.n nje;
  private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h njf;
  private com.tencent.mm.plugin.brandservice.ui.widget.a njg;
  private int njh;
  i nji;
  MMWebViewWithJsApi njj;
  MMWebViewWithJsApi njk;
  private boolean njl;
  private boolean njm;
  boolean njn;
  boolean njo;
  boolean njp;
  boolean njq;
  private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c njr;
  private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b njs;
  private boolean njt;
  private final j.a nju;
  private String njv;
  private boolean njw;
  private boolean njx;
  private ez njy;
  private Animation njz;
  private int uin;
  
  static
  {
    AppMethodBeat.i(7140);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(BizVideoDetailUI.class), "animationIv", "getAnimationIv()Landroid/widget/ImageView;")), (d.l.k)w.a(new u(w.bk(BizVideoDetailUI.class), "animationLayout", "getAnimationLayout()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(BizVideoDetailUI.class), "videoView", "getVideoView()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;")), (d.l.k)w.a(new u(w.bk(BizVideoDetailUI.class), "adView", "getAdView()Landroid/widget/FrameLayout;")), (d.l.k)w.a(new u(w.bk(BizVideoDetailUI.class), "dotView", "getDotView()Landroid/widget/FrameLayout;")), (d.l.k)w.a(new u(w.bk(BizVideoDetailUI.class), "backgroundContainerView", "getBackgroundContainerView()Landroid/widget/FrameLayout;")), (d.l.k)w.a(new u(w.bk(BizVideoDetailUI.class), "videoErrView", "getVideoErrView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;")), (d.l.k)w.a(new u(w.bk(BizVideoDetailUI.class), "videoWifiTipsView", "getVideoWifiTipsView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;")), (d.l.k)w.a(new u(w.bk(BizVideoDetailUI.class), "videoAdTitleBar", "getVideoAdTitleBar()Landroid/widget/LinearLayout;")), (d.l.k)w.a(new u(w.bk(BizVideoDetailUI.class), "videoAdTitleBack", "getVideoAdTitleBack()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(BizVideoDetailUI.class), "videoViewContainer", "getVideoViewContainer()Landroid/widget/FrameLayout;")) };
    AppMethodBeat.o(7140);
  }
  
  public BizVideoDetailUI()
  {
    AppMethodBeat.i(7216);
    this.TAG = "MicroMsg.BizVideoDetailUI";
    this.niU = p.a(this.nim, (d.g.a.a)new b(this));
    this.niV = p.a(this.nim, (d.g.a.a)new c(this));
    this.niW = p.a(this.nim, (d.g.a.a)new ad(this));
    this.niX = p.a(this.nim, (d.g.a.a)new a(this));
    this.niY = p.a(this.nim, (d.g.a.a)new j(this));
    this.niZ = p.a(this.nim, (d.g.a.a)new d(this));
    this.nja = p.a(this.nim, (d.g.a.a)new ac(this));
    this.njb = p.a(this.nim, (d.g.a.a)new af(this));
    this.njc = p.a(this.nim, (d.g.a.a)new ab(this));
    this.njd = p.a(this.nim, (d.g.a.a)new aa(this));
    this.nje = p.a(this.nim, (d.g.a.a)new ae(this));
    this.nji = new i();
    this.njs = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b();
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
    this.nju = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.Qa(toString());
    this.njv = "";
    this.eOT = "";
    this.njB = ((com.tencent.mm.plugin.brandservice.ui.widget.b)new k(this));
    this.njD = -1;
    this.njE = -1;
    this.jkE = ((IPCRunCgi.a)new e(this));
    this.njG = true;
    AppMethodBeat.o(7216);
  }
  
  private final boolean R(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(175519);
    if ((com.tencent.mm.sdk.platformtools.h.DEBUG) && (this.njH))
    {
      AppMethodBeat.o(175519);
      return true;
    }
    if (!ay.isNetworkConnected(aj.getContext()))
    {
      AppMethodBeat.o(175519);
      return false;
    }
    if (bFB().getPlayStatus() == 4)
    {
      ad.i(this.TAG, "not show WifiTips, play end!");
      AppMethodBeat.o(175519);
      return false;
    }
    if ((paramInt > 0) && (bFB().getCacheTimeSec() >= paramInt))
    {
      ad.i(this.TAG, "not show WifiTips, video cached! " + bFB().getCacheTimeSec() + '/' + bFB().getDuration());
      AppMethodBeat.o(175519);
      return false;
    }
    if (this.nhL.niG)
    {
      ad.i(this.TAG, "not show WifiTips, has show!");
      AppMethodBeat.o(175519);
      return false;
    }
    if (paramBoolean)
    {
      localObject = MPVideoWifiTipsView.nkx;
      if (!MPVideoWifiTipsView.a.yx(this.nhL.niF))
      {
        AppMethodBeat.o(175519);
        return false;
      }
    }
    else
    {
      localObject = MPVideoWifiTipsView.nkx;
      if (!MPVideoWifiTipsView.a.yv(this.nhL.niF))
      {
        localObject = MPVideoWifiTipsView.nkx;
        if (!MPVideoWifiTipsView.a.yw(this.nhL.niF))
        {
          AppMethodBeat.o(175519);
          return false;
        }
      }
    }
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.nlS;
    if (!com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.x(ay.isWifi(aj.getContext()), this.njh))
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
    Object localObject = this.njr;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    if (!((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).nkM.ggj)
    {
      AppMethodBeat.o(7204);
      return;
    }
    bFY();
    FrameLayout localFrameLayout = bFD();
    if (localFrameLayout != null)
    {
      localObject = bFD();
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
      if (this.lpO)
      {
        i = com.tencent.mm.cd.a.hV((Context)getContext());
        if (!this.lpO) {
          break label485;
        }
        j = com.tencent.mm.cd.a.hW((Context)getContext());
        k = j - this.njE - this.njD;
        j = k;
        if (!this.lpO)
        {
          if (bFB().bGP()) {
            break label496;
          }
          localc = this.njr;
          if (localc == null) {
            d.g.b.k.fvU();
          }
          localc.nkI = false;
          j = k + this.njD;
        }
        label237:
        k = a(paramd.nkT, j);
        if (k < this.njD)
        {
          localc = this.njr;
          if (localc == null) {
            d.g.b.k.fvU();
          }
          localc.nkJ = true;
        }
        ((RelativeLayout.LayoutParams)localObject).leftMargin = a(paramd.nkQ, i);
        ((RelativeLayout.LayoutParams)localObject).topMargin = (a(paramd.nkR, j) + this.njE);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = a(paramd.nkS, i);
        localc = this.njr;
        if (localc == null) {
          d.g.b.k.fvU();
        }
        if ((!localc.nkI) && (!this.lpO)) {
          break label522;
        }
        i = this.njD;
        label358:
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = (i + k);
        if (!paramd.nkW) {
          break label527;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
        label382:
        if (!paramd.nkY) {
          break label537;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
        label397:
        if (!paramd.nkX) {
          break label547;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        label412:
        if (!paramd.nkZ) {
          break label557;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        label427:
        if (!paramd.nkU) {
          break label567;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
        label442:
        if (!paramd.nkV) {
          break label577;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
      }
      for (;;)
      {
        localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(7204);
        return;
        i = this.nji.nlm;
        break;
        label485:
        j = this.nji.nll;
        break label176;
        label496:
        localc = this.njr;
        if (localc == null) {
          d.g.b.k.fvU();
        }
        localc.nkI = true;
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
    com.tencent.xweb.y localy;
    if (paramMMWebViewWithJsApi != null)
    {
      localy = paramMMWebViewWithJsApi.getSettings();
      if (localy != null) {
        localy.frf();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localy = paramMMWebViewWithJsApi.getSettings();
      if (localy != null) {
        localy.setDatabasePath(com.tencent.mm.loader.j.b.ahY() + "databases/");
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localy = paramMMWebViewWithJsApi.getSettings();
      if (localy != null) {
        localy.fri();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localy = paramMMWebViewWithJsApi.getSettings();
      if (localy != null) {
        localy.frg();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localy = paramMMWebViewWithJsApi.getSettings();
      if (localy != null) {
        localy.fre();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localy = paramMMWebViewWithJsApi.getSettings();
      if (localy != null) {
        localy.frd();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      paramMMWebViewWithJsApi.setOnLongClickListener((View.OnLongClickListener)BizVideoDetailUI.t.njS);
      AppMethodBeat.o(7196);
      return;
    }
    AppMethodBeat.o(7196);
  }
  
  private boolean aC(int paramInt, String paramString)
  {
    AppMethodBeat.i(7202);
    d.g.b.k.h(paramString, "url");
    if (isFinishing())
    {
      AppMethodBeat.o(7202);
      return false;
    }
    if (this.njk != null)
    {
      ad.w(this.TAG, "createDotWebview dotWebView existed!");
      AppMethodBeat.o(7202);
      return false;
    }
    com.tencent.mm.plugin.webview.h.a.Tb(57);
    this.njm = false;
    Object localObject = a.nis;
    localObject = MMWebViewWithJsApi.a.gI((Context)getContext());
    d.g.b.k.g(localObject, "MMWebViewWithJsApi.Factory.create(this.context)");
    this.njk = a.a((MMWebViewWithJsApi)localObject, bEV(), (d.g.a.m)new h(this), (d.g.a.m)new i(this), avB(bEU().SI()));
    c((MMWebView)this.njk);
    a(this.njk);
    localObject = bFD();
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = bFE();
    if (localObject != null) {
      ((FrameLayout)localObject).addView((View)this.njk);
    }
    bFY();
    int i = this.nji.height;
    int j = this.njD;
    int k = this.njE;
    paramString = UrlExKt.appendUrlParam(paramString, "dotId", String.valueOf(paramInt));
    localObject = this.njk;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    paramString = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(paramString, "dotWebviewId", String.valueOf(((MMWebViewWithJsApi)localObject).hashCode())), "dotMinShowHeight", String.valueOf(i - j - k));
    ad.i(this.TAG, "createDotWebview dotView dotUrl=".concat(String.valueOf(paramString)));
    localObject = this.njk;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).loadUrl(paramString);
    }
    paramString = this.njk;
    if (paramString != null) {
      paramString.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(7202);
    return true;
  }
  
  private final void b(ez paramez)
  {
    int j = 0;
    AppMethodBeat.i(175514);
    if (paramez == null)
    {
      AppMethodBeat.o(175514);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.brandservice.ui.widget.c.nnW;
    com.tencent.mm.plugin.brandservice.ui.widget.c.bGL();
    this.njy = paramez;
    ad.i(this.TAG, "doPlayVideo getAppMsgDone: " + this.njw + ", insertVideoDone: " + this.njx);
    if ((!this.njw) || (!this.njx))
    {
      AppMethodBeat.o(175514);
      return;
    }
    localObject1 = this.nhL.niP;
    Object localObject2 = paramez.Czz;
    d.g.b.k.g(localObject2, "resp.url_info");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject1).J((LinkedList)localObject2);
    com.tencent.mm.plugin.webview.h.a.Tb(23);
    localObject1 = paramez.Czz;
    d.g.b.k.g(localObject1, "resp.url_info");
    localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.k.I((LinkedList)localObject1);
    if (localObject1 == null)
    {
      AppMethodBeat.o(175514);
      return;
    }
    this.nhL.niP.nma = ((fn)localObject1).CAm;
    this.nhL.niE = ((fn)localObject1).niE;
    this.nhL.niF = ((fn)localObject1).CAo;
    ad.i(this.TAG, "doPlayVideo filesize=" + this.nhL.niE + " wifiTipsFlag=" + this.nhL.niF);
    boolean bool;
    int i;
    if ((paramez.CzD & 0x1) != 0)
    {
      bool = true;
      if ((eoj() == null) || (!eoj().bzs())) {
        break label725;
      }
      localObject2 = eoj();
      d.g.b.k.g(localObject2, "webViewFloatBallHelper");
      i = ((com.tencent.mm.plugin.webview.ui.tools.b.a)localObject2).epv();
      label295:
      bFB().setInitialTime(i * 1000);
      localObject2 = paramez.CzL;
      if (localObject2 != null)
      {
        bFB().a(((do)localObject2).bvE, ((do)localObject2).bvI, ((do)localObject2).Cyi, ((do)localObject2).Cyj, ((do)localObject2).ksP, ((do)localObject2).ksQ);
        ad.i(this.TAG, "maxInitBitrate = " + ((do)localObject2).bvE + ", bandFraction = " + ((do)localObject2).bvI + ", minDur = " + ((do)localObject2).Cyi + ", maxDur = " + ((do)localObject2).Cyj + ", minBuffer = " + ((do)localObject2).ksP + ", maxBuffer = " + ((do)localObject2).ksQ);
      }
      this.njn = false;
      if (!R(((fn)localObject1).CAj / 1000, false)) {
        break label744;
      }
      if (!bool) {
        break label736;
      }
      iB(false);
    }
    for (;;)
    {
      bFB().setAutoPlay(bool);
      if (!bool) {
        bFS();
      }
      this.nhL.niP.width = ((fn)localObject1).width;
      this.nhL.niP.height = ((fn)localObject1).height;
      localObject2 = bFB();
      String str = ((fn)localObject1).url;
      d.g.b.k.g(str, "urlInfo.url");
      ((MPVideoView)localObject2).cv(str, ((fn)localObject1).CAj / 1000);
      localObject2 = bFB();
      i = j;
      if (((fn)localObject1).width > ((fn)localObject1).height) {
        i = 90;
      }
      ((MPVideoView)localObject2).setFullScreenDirection(i);
      eJ(((fn)localObject1).width, ((fn)localObject1).height);
      if ((((fn)localObject1).width > 0) && (((fn)localObject1).height > 0) && (bEU().gKx.videoWidth <= 0) && (bEU().gKx.videoHeight <= 0))
      {
        bEU().gKx.videoWidth = ((fn)localObject1).width;
        bEU().gKx.videoHeight = ((fn)localObject1).height;
      }
      localObject2 = bFB();
      paramez = paramez.Czz;
      d.g.b.k.g(paramez, "resp.url_info");
      ((MPVideoView)localObject2).a(paramez, (fn)localObject1);
      AppMethodBeat.o(175514);
      return;
      bool = false;
      break;
      label725:
      i = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.Qe(bFR());
      break label295;
      label736:
      this.njn = true;
      continue;
      label744:
      nH(0L);
    }
  }
  
  private final View bFA()
  {
    AppMethodBeat.i(7143);
    View localView = (View)this.niV.a($$delegatedProperties[1]);
    AppMethodBeat.o(7143);
    return localView;
  }
  
  private final MPVideoView bFB()
  {
    AppMethodBeat.i(7145);
    MPVideoView localMPVideoView = (MPVideoView)this.niW.a($$delegatedProperties[2]);
    AppMethodBeat.o(7145);
    return localMPVideoView;
  }
  
  private final FrameLayout bFC()
  {
    AppMethodBeat.i(7146);
    FrameLayout localFrameLayout = (FrameLayout)this.niX.a($$delegatedProperties[3]);
    AppMethodBeat.o(7146);
    return localFrameLayout;
  }
  
  private final FrameLayout bFD()
  {
    AppMethodBeat.i(7147);
    FrameLayout localFrameLayout = (FrameLayout)this.niY.a($$delegatedProperties[4]);
    AppMethodBeat.o(7147);
    return localFrameLayout;
  }
  
  private final FrameLayout bFE()
  {
    AppMethodBeat.i(7148);
    FrameLayout localFrameLayout = (FrameLayout)this.niZ.a($$delegatedProperties[5]);
    AppMethodBeat.o(7148);
    return localFrameLayout;
  }
  
  private final MPVideoErrorView bFF()
  {
    AppMethodBeat.i(7149);
    MPVideoErrorView localMPVideoErrorView = (MPVideoErrorView)this.nja.a($$delegatedProperties[6]);
    AppMethodBeat.o(7149);
    return localMPVideoErrorView;
  }
  
  private final MPVideoWifiTipsView bFG()
  {
    AppMethodBeat.i(7150);
    MPVideoWifiTipsView localMPVideoWifiTipsView = (MPVideoWifiTipsView)this.njb.a($$delegatedProperties[7]);
    AppMethodBeat.o(7150);
    return localMPVideoWifiTipsView;
  }
  
  private final LinearLayout bFH()
  {
    AppMethodBeat.i(7151);
    LinearLayout localLinearLayout = (LinearLayout)this.njc.a($$delegatedProperties[8]);
    AppMethodBeat.o(7151);
    return localLinearLayout;
  }
  
  private final FrameLayout bFI()
  {
    AppMethodBeat.i(7152);
    FrameLayout localFrameLayout = (FrameLayout)this.nje.a($$delegatedProperties[10]);
    AppMethodBeat.o(7152);
    return localFrameLayout;
  }
  
  private final int bFK()
  {
    AppMethodBeat.i(175507);
    if (this.kxf == null)
    {
      i = this.njh;
      AppMethodBeat.o(175507);
      return i;
    }
    try
    {
      Bundle localBundle = this.kxf.j(110, new Bundle());
      if (localBundle != null) {
        this.njh = localBundle.getInt("sim_card_type", 0);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.w(this.TAG, "invoker ex :" + localException.getMessage());
      }
    }
    int i = this.njh;
    AppMethodBeat.o(175507);
    return i;
  }
  
  private final void bFL()
  {
    AppMethodBeat.i(175509);
    View localView = bFA();
    d.g.b.k.g(localView, "animationLayout");
    if (localView.getVisibility() == 0)
    {
      localView = bFA();
      d.g.b.k.g(localView, "animationLayout");
      dB(localView);
    }
    dB((View)bEW());
    bFW();
    AppMethodBeat.o(175509);
  }
  
  private void bFO()
  {
    AppMethodBeat.i(193350);
    if (bFB().isPlaying()) {
      bFB().bGM();
    }
    ew("leavePage", "");
    this.nju.report();
    this.nhL.niP.nlV = bFB().getEndPlayTime();
    if (this.nhN != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.lac;
      this.lac = (l1 - this.nhO + l2);
      this.nhL.niP.nlW = ((int)(this.lac / 1000L));
    }
    this.nhL.niP.nlU = ((int)bFB().getRealPlayTime());
    this.nhL.niP.ea(2, 0);
    if (!this.njp)
    {
      com.tencent.mm.plugin.webview.h.a.Tb(22);
      AppMethodBeat.o(193350);
      return;
    }
    if ((bFB().getPlayStart()) && (!bFB().getPlayStarted())) {
      com.tencent.mm.plugin.webview.h.a.Tb(26);
    }
    AppMethodBeat.o(193350);
  }
  
  private void bFP()
  {
    AppMethodBeat.i(7183);
    if (this.njj == null)
    {
      AppMethodBeat.o(7183);
      return;
    }
    Object localObject = this.AQP;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.c.f)localObject).avT("disappear");
    }
    localObject = this.AQP;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.c.f)localObject).avT("destroy");
    }
    localObject = bFC();
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = bFC();
    if (localObject != null) {
      ((FrameLayout)localObject).removeView((View)this.njj);
    }
    localObject = this.njj;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getCurWebviewClient();
      if (!(localObject instanceof com.tencent.mm.plugin.webview.ui.tools.widget.k)) {
        break label162;
      }
      localObject = this.njj;
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
    localObject = this.njj;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).destroy();
    }
    localObject = this.njj;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebChromeClient(null);
    }
    localObject = this.njj;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebViewClient(null);
    }
    localObject = this.njj;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnTouchListener(null);
    }
    localObject = this.njj;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnLongClickListener(null);
    }
    localObject = this.njj;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setVisibility(8);
    }
    localObject = this.njj;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).removeAllViews();
    }
    localObject = this.njj;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).clearView();
    }
    this.njj = null;
    this.njl = false;
    bFV();
    AppMethodBeat.o(7183);
  }
  
  private final String bFR()
  {
    AppMethodBeat.i(7188);
    String str = bEU().SI() + '_' + this.uin + '_' + this.nhL.gGC;
    AppMethodBeat.o(7188);
    return str;
  }
  
  private final void bFS()
  {
    AppMethodBeat.i(175515);
    View localView = bFA();
    d.g.b.k.g(localView, "animationLayout");
    localView.setVisibility(8);
    AppMethodBeat.o(175515);
  }
  
  private final void bFT()
  {
    AppMethodBeat.i(7189);
    MPVideoErrorView localMPVideoErrorView = bFF();
    d.g.b.k.g(localMPVideoErrorView, "videoErrView");
    if (localMPVideoErrorView.getVisibility() == 0)
    {
      localMPVideoErrorView = bFF();
      d.g.b.k.g(localMPVideoErrorView, "videoErrView");
      localMPVideoErrorView.setVisibility(8);
      eJ(this.nji.width, this.nji.height);
    }
    AppMethodBeat.o(7189);
  }
  
  private final void bFU()
  {
    AppMethodBeat.i(7190);
    MPVideoErrorView localMPVideoErrorView = bFF();
    d.g.b.k.g(localMPVideoErrorView, "videoErrView");
    localMPVideoErrorView.setVisibility(0);
    iA(false);
    AppMethodBeat.o(7190);
  }
  
  private final void bFV()
  {
    AppMethodBeat.i(7193);
    Object localObject = bFC();
    if (localObject != null)
    {
      if (((FrameLayout)localObject).getVisibility() == 8)
      {
        localObject = bFG();
        d.g.b.k.g(localObject, "videoWifiTipsView");
        if (((MPVideoWifiTipsView)localObject).getVisibility() == 8)
        {
          localObject = bFH();
          d.g.b.k.g(localObject, "videoAdTitleBar");
          ((LinearLayout)localObject).setVisibility(8);
        }
      }
      AppMethodBeat.o(7193);
      return;
    }
    AppMethodBeat.o(7193);
  }
  
  private final void bFW()
  {
    AppMethodBeat.i(7203);
    if (this.njr != null)
    {
      Object localObject = bFD();
      if (localObject == null) {
        break label56;
      }
      if (((FrameLayout)localObject).getVisibility() == 0)
      {
        localObject = this.njr;
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        a(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).nkM);
      }
    }
    AppMethodBeat.o(7203);
    return;
    label56:
    AppMethodBeat.o(7203);
  }
  
  private final void bFX()
  {
    AppMethodBeat.i(7205);
    Object localObject1;
    if ((bFD() != null) && (this.njr != null))
    {
      localObject1 = this.njr;
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject1).nkJ) {}
    }
    else
    {
      AppMethodBeat.o(7205);
      return;
    }
    ad.i(this.TAG, "updateDotPosIfNeed");
    int i;
    Object localObject2;
    if (!this.lpO)
    {
      localObject1 = bFD();
      if (localObject1 != null) {}
      for (localObject1 = ((FrameLayout)localObject1).getLayoutParams(); localObject1 == null; localObject1 = null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(7205);
        throw ((Throwable)localObject1);
      }
      i = ((RelativeLayout.LayoutParams)localObject1).bottomMargin;
      localObject1 = new v.c();
      ((v.c)localObject1).Jhu = i;
      if (!bFB().bGP()) {
        break label228;
      }
      localObject2 = this.njr;
      if (localObject2 == null) {
        d.g.b.k.fvU();
      }
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nkI) {
        break label228;
      }
    }
    for (((v.c)localObject1).Jhu += this.njD;; ((v.c)localObject1).Jhu -= this.njD)
    {
      localObject2 = ValueAnimator.ofInt(new int[] { i, ((v.c)localObject1).Jhu });
      ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new z(this, (v.c)localObject1));
      d.g.b.k.g(localObject2, "va");
      ((ValueAnimator)localObject2).setDuration(200L);
      ((ValueAnimator)localObject2).start();
      AppMethodBeat.o(7205);
      return;
      label228:
      if (bFB().bGP()) {
        break;
      }
      localObject2 = this.njr;
      if (localObject2 == null) {
        d.g.b.k.fvU();
      }
      if (!((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nkI) {
        break;
      }
    }
    AppMethodBeat.o(7205);
  }
  
  private final void bFY()
  {
    AppMethodBeat.i(7206);
    if (this.njD < 0)
    {
      this.njD = com.tencent.mm.cd.a.ao((Context)getContext(), 2131166589);
      this.njE = ap.dL((Context)getContext());
    }
    AppMethodBeat.o(7206);
  }
  
  private final void bFZ()
  {
    AppMethodBeat.i(7207);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onShowDot ready: ").append(this.njm).append(", hasWebView: ");
    if (this.njk != null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i((String)localObject, bool);
      if ((this.njm) && (this.njk != null)) {
        break;
      }
      AppMethodBeat.o(7207);
      return;
    }
    com.tencent.mm.plugin.webview.h.a.Tb(60);
    localObject = bFD();
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = bFE();
    if (localObject != null) {
      ((FrameLayout)localObject).removeView((View)this.njk);
    }
    localObject = bFD();
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = bFD();
    if (localObject != null) {
      ((FrameLayout)localObject).addView((View)this.njk);
    }
    localObject = bFD();
    if (localObject != null)
    {
      localObject = ((FrameLayout)localObject).getViewTreeObserver();
      if (localObject != null) {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new v(this));
      }
    }
    localObject = this.njr;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).nkH = true;
    }
    localObject = this.njr;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).nkK = true;
    }
    bFX();
    AppMethodBeat.o(7207);
  }
  
  private final void bGc()
  {
    AppMethodBeat.i(175518);
    if (this.njF != null)
    {
      getContext().unregisterReceiver(this.njF);
      this.njF = null;
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
  
  private final void dB(View paramView)
  {
    AppMethodBeat.i(175510);
    this.nji.dB(paramView);
    AppMethodBeat.o(175510);
  }
  
  private final void eJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7167);
    if (paramInt1 > paramInt2)
    {
      Object localObject1;
      if (this.njf != null)
      {
        localObject1 = this.njf;
        if (localObject1 != null)
        {
          Object localObject2 = getContext();
          d.g.b.k.g(localObject2, "context");
          localObject2 = (Context)localObject2;
          MPVideoView localMPVideoView = bFB();
          d.g.b.k.h(localObject2, "ctx");
          d.g.b.k.h(localMPVideoView, "video");
          ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h)localObject1).jyt = new WeakReference(localObject2);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h)localObject1).nld = new WeakReference(localMPVideoView);
        }
      }
      for (;;)
      {
        iA(true);
        AppMethodBeat.o(7167);
        return;
        localObject1 = getContext();
        d.g.b.k.g(localObject1, "context");
        this.njf = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h((Context)localObject1, bFB());
      }
    }
    iA(false);
    AppMethodBeat.o(7167);
  }
  
  private final void ew(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193351);
    if (bt.kU(this.njv, paramString1))
    {
      AppMethodBeat.o(193351);
      return;
    }
    ad.d(this.TAG, "onMPVideoStateChange ".concat(String.valueOf(paramString1)));
    Object localObject = this.AQP;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.c.f)localObject).f(paramString1, this.nhL.gGC, paramString2, String.valueOf(bFB().getCurrPosSec()), String.valueOf(bFB().getRealPlayTime()));
    }
    localObject = this.njj;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
      if (localObject != null) {
        ((com.tencent.mm.plugin.webview.c.f)localObject).f(paramString1, this.nhL.gGC, paramString2, String.valueOf(bFB().getCurrPosSec()), String.valueOf(bFB().getRealPlayTime()));
      }
    }
    this.njv = paramString1;
    AppMethodBeat.o(193351);
  }
  
  private final void iB(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(7191);
    if (!R(bFB().getDuration(), paramBoolean))
    {
      ad.i(this.TAG, "showWifiTipsView should not show now");
      AppMethodBeat.o(7191);
      return;
    }
    ad.i(this.TAG, "showWifiTipsView ".concat(String.valueOf(paramBoolean)));
    com.tencent.mm.plugin.webview.h.a.Tb(16);
    Object localObject;
    int i;
    if (!paramBoolean)
    {
      localObject = MPVideoWifiTipsView.nkx;
      if (MPVideoWifiTipsView.a.yw(this.nhL.niF))
      {
        i = 2;
        this.nhL.niP.nmc = i;
        this.nhL.niP.ea(14, 0);
        localObject = this.nhL;
        if (!paramBoolean) {
          break label264;
        }
      }
    }
    for (;;)
    {
      ((b)localObject).yu(j);
      this.nhL.niG = true;
      this.njn = false;
      bFG().p(this.nhL.niE, i);
      if (this.njz == null)
      {
        this.njz = AnimationUtils.loadAnimation((Context)getContext(), 2130772105);
        localObject = this.njz;
        if (localObject != null) {
          ((Animation)localObject).setDuration(300L);
        }
      }
      bFG().clearAnimation();
      bFG().startAnimation(this.njz);
      localObject = bFG();
      d.g.b.k.g(localObject, "videoWifiTipsView");
      ((MPVideoWifiTipsView)localObject).setVisibility(0);
      aq.n((Runnable)new BizVideoDetailUI.y(this), 3000L);
      AppMethodBeat.o(7191);
      return;
      i = 1;
      break;
      label264:
      j = 1;
    }
  }
  
  private final void nH(long paramLong)
  {
    AppMethodBeat.i(175516);
    Object localObject = bFG();
    d.g.b.k.g(localObject, "videoWifiTipsView");
    if (((MPVideoWifiTipsView)localObject).getVisibility() != 8)
    {
      if (paramLong > 0L)
      {
        if (this.njA == null)
        {
          this.njA = AnimationUtils.loadAnimation((Context)getContext(), 2130772109);
          localObject = this.njA;
          if (localObject != null) {
            ((Animation)localObject).setDuration(paramLong);
          }
        }
        bFG().clearAnimation();
        bFG().startAnimation(this.njA);
      }
      aq.n((Runnable)new l(this), paramLong);
    }
    AppMethodBeat.o(175516);
  }
  
  public final void O(Bundle paramBundle)
  {
    AppMethodBeat.i(7172);
    if (this.lpO) {
      bFB().p(false, 0);
    }
    this.nju.Qd("21");
    this.nju.Qd("22");
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.nju.Qc("3"), this.nju);
    bFP();
    bFQ();
    iA(false);
    super.O(paramBundle);
    com.tencent.mm.plugin.webview.h.a.Tb(18);
    this.njo = true;
    AppMethodBeat.o(7172);
  }
  
  public final boolean P(Bundle paramBundle)
  {
    AppMethodBeat.i(7195);
    if (isFinishing())
    {
      AppMethodBeat.o(7195);
      return false;
    }
    if ((paramBundle == null) || (!paramBundle.containsKey("adUrl")))
    {
      ad.w(this.TAG, "createAdWebview url not found");
      AppMethodBeat.o(7195);
      return false;
    }
    if (this.njj != null)
    {
      ad.w(this.TAG, "createAdWebview adWebView existed!");
      AppMethodBeat.o(7195);
      return false;
    }
    com.tencent.mm.plugin.webview.h.a.Tb(28);
    paramBundle = paramBundle.getString("adUrl");
    ad.i(this.TAG, "createAdWebview adWebView url=".concat(String.valueOf(paramBundle)));
    this.njl = false;
    Object localObject = a.nis;
    localObject = MMWebViewWithJsApi.a.gI((Context)getContext());
    d.g.b.k.g(localObject, "MMWebViewWithJsApi.Factory.create(this.context)");
    this.njj = a.a((MMWebViewWithJsApi)localObject, bEV(), (d.g.a.m)BizVideoDetailUI.f.njJ, (d.g.a.m)BizVideoDetailUI.g.njK, avB(bEU().SI()));
    a(this.njj);
    localObject = this.njj;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).loadUrl(paramBundle);
    }
    paramBundle = bFC();
    if (paramBundle != null) {
      paramBundle.removeAllViews();
    }
    paramBundle = bFE();
    if (paramBundle != null) {
      paramBundle.addView((View)this.njj);
    }
    paramBundle = this.njj;
    if (paramBundle != null) {
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(7195);
    return true;
  }
  
  public final void Q(Bundle paramBundle)
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
    ad.i(this.TAG, "sendMPPageData %s, webviewId = %d", new Object[] { str, Integer.valueOf(j) });
    if (d.g.b.k.g("adWeb", str))
    {
      if (this.njj == null)
      {
        AppMethodBeat.o(7200);
        return;
      }
      paramBundle = this.njj;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getJsapi();
        if (paramBundle != null)
        {
          paramBundle.avS((String)localObject);
          AppMethodBeat.o(7200);
          return;
        }
      }
      AppMethodBeat.o(7200);
      return;
    }
    if (d.g.b.k.g("dot", str))
    {
      if (this.njk == null)
      {
        AppMethodBeat.o(7200);
        return;
      }
      paramBundle = this.njk;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label257;
        }
        paramBundle = this.TAG;
        localObject = this.njk;
        if (localObject == null) {
          break label252;
        }
      }
      label252:
      for (int i = localObject.hashCode();; i = 0)
      {
        ad.i(paramBundle, "sendMPPageData id not match %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(7200);
        return;
        i = 0;
        break;
      }
      label257:
      paramBundle = this.njk;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getJsapi();
        if (paramBundle != null)
        {
          paramBundle.avS((String)localObject);
          AppMethodBeat.o(7200);
          return;
        }
      }
      AppMethodBeat.o(7200);
      return;
    }
    paramBundle = this.AQP;
    if (paramBundle != null)
    {
      paramBundle.avS((String)localObject);
      AppMethodBeat.o(7200);
      return;
    }
    AppMethodBeat.o(7200);
  }
  
  public final void R(Bundle paramBundle)
  {
    AppMethodBeat.i(7208);
    if (this.njk == null)
    {
      AppMethodBeat.o(7208);
      return;
    }
    if (paramBundle == null) {
      d.g.b.k.fvU();
    }
    int j = paramBundle.getInt("webviewId", 0);
    if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.bGm())
    {
      paramBundle = this.njk;
      MMWebViewWithJsApi localMMWebViewWithJsApi;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label125;
        }
        paramBundle = this.TAG;
        localMMWebViewWithJsApi = this.njk;
        if (localMMWebViewWithJsApi == null) {
          break label120;
        }
      }
      label120:
      for (int i = localMMWebViewWithJsApi.hashCode();; i = 0)
      {
        ad.i(paramBundle, "closeDotWebview id not match %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(7208);
        return;
        i = 0;
        break;
      }
    }
    label125:
    ad.i(this.TAG, "closeDotWebview");
    bFQ();
    AppMethodBeat.o(7208);
  }
  
  public final void S(Bundle paramBundle)
  {
    AppMethodBeat.i(7209);
    if (this.njk == null)
    {
      AppMethodBeat.o(7209);
      return;
    }
    if (paramBundle == null) {
      d.g.b.k.fvU();
    }
    int j = paramBundle.getInt("webviewId", 0);
    int i;
    MMWebViewWithJsApi localMMWebViewWithJsApi;
    if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.bGm())
    {
      paramBundle = this.njk;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label125;
        }
        paramBundle = this.TAG;
        localMMWebViewWithJsApi = this.njk;
        if (localMMWebViewWithJsApi == null) {
          break label120;
        }
      }
      label120:
      for (i = localMMWebViewWithJsApi.hashCode();; i = 0)
      {
        ad.i(paramBundle, "hideDotWebview id not match %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(7209);
        return;
        i = 0;
        break;
      }
    }
    label125:
    ad.i(this.TAG, "hideDotWebview");
    paramBundle = bFD();
    if ((paramBundle == null) || (paramBundle.getVisibility() != 0))
    {
      ad.i(this.TAG, "dotView not show");
      AppMethodBeat.o(7209);
      return;
    }
    paramBundle = bFD();
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.AQP;
    if (paramBundle != null)
    {
      i = bGa();
      localMMWebViewWithJsApi = this.njk;
      if (localMMWebViewWithJsApi == null) {
        d.g.b.k.fvU();
      }
      paramBundle.M(i, localMMWebViewWithJsApi.hashCode(), "disappear");
    }
    paramBundle = this.njk;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getJsapi();
      if (paramBundle != null)
      {
        i = bGa();
        localMMWebViewWithJsApi = this.njk;
        if (localMMWebViewWithJsApi == null) {
          d.g.b.k.fvU();
        }
        paramBundle.M(i, localMMWebViewWithJsApi.hashCode(), "disappear");
        AppMethodBeat.o(7209);
        return;
      }
    }
    AppMethodBeat.o(7209);
  }
  
  public final void S(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(175512);
    d.g.b.k.h(paramMap, "params");
    ad.i(this.TAG, "insertVideoNativeView");
    Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.nju.Qc("8"), this.nju);
    Object localObject2 = this.nju;
    localObject1 = this.nip;
    Object localObject3;
    float f1;
    float f2;
    boolean bool;
    label892:
    int i;
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((BaseWebViewController)localObject1).AKV;
      localObject3 = (q)localObject1;
      if (localObject3 != null)
      {
        localObject1 = (d.g.a.b)j.a.a.nlO;
        long l5 = ((q)localObject3).aAw("getA8KeyStart");
        long l6 = ((q)localObject3).aAw("getA8KeyEnd");
        long l3 = ((q)localObject3).aAw("onPageStarted");
        long l2 = ((q)localObject3).aAw("onPageFinished");
        long l4 = ((q)localObject3).aAw("firstScreenTimestamp");
        long l7 = ((q)localObject3).aAw("firstScreenTime");
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
        localObject3 = new em();
        ((em)localObject3).type = 5;
        LinkedList localLinkedList = ((em)localObject3).Cvr;
        ep localep = new ep();
        localep.key = "EventType";
        localep.gPh = "6";
        localLinkedList.add(localep);
        localLinkedList = ((em)localObject3).Cvr;
        localep = new ep();
        localep.key = "StartTime";
        localep.gPh = ((String)((d.g.a.b)localObject1).aA(Long.valueOf(l5)));
        localLinkedList.add(localep);
        localLinkedList = ((em)localObject3).Cvr;
        localep = new ep();
        localep.key = "EndTime";
        localep.gPh = ((String)((d.g.a.b)localObject1).aA(Long.valueOf(l6)));
        localLinkedList.add(localep);
        ((j.a)localObject2).nlN.add(localObject3);
        localObject3 = new em();
        ((em)localObject3).type = 5;
        localLinkedList = ((em)localObject3).Cvr;
        localep = new ep();
        localep.key = "EventType";
        localep.gPh = "7";
        localLinkedList.add(localep);
        localLinkedList = ((em)localObject3).Cvr;
        localep = new ep();
        localep.key = "StartTime";
        localep.gPh = ((String)((d.g.a.b)localObject1).aA(Long.valueOf(l2)));
        localLinkedList.add(localep);
        localLinkedList = ((em)localObject3).Cvr;
        localep = new ep();
        localep.key = "EndTime";
        localep.gPh = ((String)((d.g.a.b)localObject1).aA(Long.valueOf(l1)));
        localLinkedList.add(localep);
        ((j.a)localObject2).nlN.add(localObject3);
      }
      c(this.nhy);
      localObject1 = this.nji;
      localObject2 = getContext();
      d.g.b.k.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      f1 = this.density;
      d.g.b.k.h(localObject2, "context");
      d.g.b.k.h(paramMap, "params");
      ((i)localObject1).x = ((int)(bt.getInt((String)paramMap.get("x"), 0) * f1) - 2);
      ((i)localObject1).y = ((int)(bt.getInt((String)paramMap.get("y"), 0) * f1) - 2);
      ((i)localObject1).width = ((int)(bt.getInt((String)paramMap.get("width"), 0) * f1) + 4);
      ((i)localObject1).height = ((int)(bt.getInt((String)paramMap.get("height"), 0) * f1) + 4);
      ((i)localObject1).nlt = ((String)paramMap.get("reportParams"));
      float f3 = bt.getFloat((String)paramMap.get("playerMinRatioWhenPlaying"), 1.777778F);
      f2 = bt.getFloat((String)paramMap.get("playerMinRatioWhenNotPlaying"), 1.777778F);
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
      ad.w("MicroMsg.BizVideoPosHelper", "init invalid params x=" + ((i)localObject1).x + ", y=" + ((i)localObject1).y + ", width=" + ((i)localObject1).width + ", height=" + ((i)localObject1).height);
      bool = false;
      this.njx = bool;
      this.nhL.niN = bt.getInt((String)paramMap.get("landingType"), 0);
      if (this.njx)
      {
        bEW().addView((View)bFI());
        if ((this.nji.width > 0) && (this.nji.height > 0)) {
          eJ(this.nji.width, this.nji.height);
        }
        bFB().a((ImageView)this.niU.a($$delegatedProperties[0]), bEU().gKx.gKD, this.nji.width, this.nji.nll, bEU());
        localObject1 = bFB();
        localObject2 = bEU().gKx.gKD;
        i = this.nji.width;
        j = this.nji.nll;
        localObject3 = bEU();
        d.g.b.k.h(localObject3, "msgInfo");
        paramMap = ((MPVideoView)localObject1).nog;
        if (paramMap == null) {
          break label1694;
        }
      }
    }
    label1694:
    for (paramMap = paramMap.getCoverIv();; paramMap = null)
    {
      ((MPVideoView)localObject1).a(paramMap, (String)localObject2, i, j, (x)localObject3);
      dB((View)bEW());
      paramMap = bFA();
      d.g.b.k.g(paramMap, "animationLayout");
      dB(paramMap);
      this.nji.a(0, bFB());
      ad.i(this.TAG, "initVideoParam minVideoHeight " + this.nji.nll + " maxVideoHeight " + this.nji.bvW);
      paramMap = bFA();
      d.g.b.k.g(paramMap, "animationLayout");
      paramMap.setVisibility(0);
      bET().bringToFront();
      bFB().setFullScreenDelegate((MPVideoView.b)new o(this));
      bFB().setMPVideoViewCallBack((MPVideoView.c)new p(this));
      ((View)this.njd.a($$delegatedProperties[9])).setOnClickListener((View.OnClickListener)new q(this));
      getWebView().setOnCustomTouchListener((View.OnTouchListener)new r(this));
      bFB().setTitle(bEU().gKx.title);
      bFB().setPlayBtnOnClickListener((View.OnClickListener)new s(this));
      paramMap = bFF();
      localObject1 = this.nhL;
      d.g.b.k.h(localObject1, "controller");
      paramMap.frN.setOnClickListener((View.OnClickListener)new MPVideoErrorView.a(paramMap, (b)localObject1));
      b(this.njy);
      AppMethodBeat.o(175512);
      return;
      localObject1 = null;
      break;
      label1398:
      ((i)localObject1).kvn = com.tencent.mm.cd.a.hV((Context)localObject2);
      if ((((i)localObject1).x <= 0) && (Math.abs(((i)localObject1).kvn - ((i)localObject1).width) < 10))
      {
        ((i)localObject1).x = 0;
        ((i)localObject1).width = ((i)localObject1).kvn;
      }
      ((i)localObject1).nlj = ((i)localObject1).x;
      ((i)localObject1).nlk = ((i)localObject1).y;
      ((i)localObject1).nll = ((i)localObject1).height;
      ((i)localObject1).nlm = ((i)localObject1).width;
      ((i)localObject1).bvW = ((int)(((i)localObject1).kvn * 1.0F / ((i)localObject1).width * ((i)localObject1).height));
      ((i)localObject1).nln = ((i)localObject1).bvW;
      ((i)localObject1).nlo = d.k.h.kL((int)(((i)localObject1).kvn * 1.0F / f1), ((i)localObject1).bvW);
      ((i)localObject1).nlp = d.k.h.kL((int)(((i)localObject1).kvn * 1.0F / f2), ((i)localObject1).bvW);
      ad.i("MicroMsg.BizVideoPosHelper", "init x=" + ((i)localObject1).x + ", y=" + ((i)localObject1).y + ", width=" + ((i)localObject1).width + ", height=" + ((i)localObject1).height + ", screenWidth=" + ((i)localObject1).kvn + ", minVideoHeightWhenPlay = " + ((i)localObject1).nlo + ", minVideoHeightWhenPause = " + ((i)localObject1).nlp);
      bool = true;
      break label892;
    }
  }
  
  public final void T(Bundle paramBundle)
  {
    AppMethodBeat.i(7210);
    if (this.njk == null)
    {
      AppMethodBeat.o(7210);
      return;
    }
    if (paramBundle == null) {
      d.g.b.k.fvU();
    }
    int j = paramBundle.getInt("webviewId", 0);
    if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.bGm())
    {
      paramBundle = this.njk;
      MMWebViewWithJsApi localMMWebViewWithJsApi;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label125;
        }
        paramBundle = this.TAG;
        localMMWebViewWithJsApi = this.njk;
        if (localMMWebViewWithJsApi == null) {
          break label120;
        }
      }
      label120:
      for (int i = localMMWebViewWithJsApi.hashCode();; i = 0)
      {
        ad.i(paramBundle, "dotWebviewReady id not match %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(7210);
        return;
        i = 0;
        break;
      }
    }
    label125:
    ad.i(this.TAG, "dotWebViewReady %d", new Object[] { Integer.valueOf(j) });
    this.njm = true;
    com.tencent.mm.plugin.webview.h.a.Tb(59);
    AppMethodBeat.o(7210);
  }
  
  public final void U(Bundle paramBundle)
  {
    AppMethodBeat.i(7211);
    Object localObject1 = this.njs;
    int k = bFB().getDuration();
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {
      ad.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData data invalid");
    }
    Object localObject2;
    int m;
    int i;
    for (;;)
    {
      bGb();
      localObject1 = bFB();
      paramBundle = new LinkedList((Collection)this.njs.nkF);
      d.g.b.k.h(paramBundle, "list");
      localObject1 = ((MPVideoView)localObject1).noh;
      if (localObject1 != null) {
        ((MPVideoViewControlBar)localObject1).L(paramBundle);
      }
      bFW();
      AppMethodBeat.o(7211);
      return;
      try
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).nkF.clear();
        localObject2 = d.y.JfV;
        paramBundle = paramBundle.getString("data", "");
        ad.d(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData data=".concat(String.valueOf(paramBundle)));
        try
        {
          paramBundle = new JSONObject(paramBundle).optJSONArray("items");
          if (paramBundle == null) {
            ad.w(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "itemList null");
          }
        }
        catch (Exception paramBundle)
        {
          ad.e(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData ex %s", new Object[] { paramBundle.getMessage() });
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
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nkH = bool;
      if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nkN < ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nkO) && (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nkN >= 0.0D) && (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nkO <= k)) {
        break label576;
      }
      ad.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "dotInfo invalid, startTime = " + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nkN + ", endTime=" + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).nkO + ", duration=" + k);
    }
    label561:
    label570:
    label576:
    for (int j = 0;; j = 1)
    {
      if (j == 0)
      {
        ad.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "dotInfo invalid");
      }
      else
      {
        try
        {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).nkF.add(localObject2);
          break label561;
        }
        finally
        {
          paramBundle = finally;
          AppMethodBeat.o(7211);
          throw paramBundle;
        }
        ad.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData end %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).nkF.size()) });
        break;
      }
      i += 1;
      break label238;
      bool = false;
      break label378;
    }
  }
  
  public final void V(Bundle paramBundle)
  {
    AppMethodBeat.i(7201);
    if ((paramBundle == null) || (!paramBundle.containsKey("opType")))
    {
      AppMethodBeat.o(7201);
      return;
    }
    paramBundle = paramBundle.getString("opType");
    ad.i(this.TAG, "opPlayer opType= ".concat(String.valueOf(paramBundle)));
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
          bFB().start();
          AppMethodBeat.o(7201);
          return;
          if (paramBundle.equals("stop")) {
            bFB().stop();
          }
        }
      }
    } while (!paramBundle.equals("pause"));
    bFB().pause();
    AppMethodBeat.o(7201);
  }
  
  /* Error */
  public final void a(ez paramez)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: sipush 7187
    //   9: invokestatic 386	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_1
    //   13: ifnonnull +47 -> 60
    //   16: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nlE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nju	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   24: ldc_w 2176
    //   27: invokevirtual 1712	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:Qc	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/em;
    //   30: astore_1
    //   31: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nlE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   34: astore_3
    //   35: aload_1
    //   36: ldc_w 2178
    //   39: ldc_w 2180
    //   42: invokestatic 2183	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/em;Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nju	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   50: invokestatic 1715	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/em;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;)V
    //   53: sipush 7187
    //   56: invokestatic 442	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: aload_1
    //   61: getfield 2186	com/tencent/mm/protocal/protobuf/ez:CzE	I
    //   64: istore_2
    //   65: aload_0
    //   66: getfield 604	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:nhL	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   69: astore 6
    //   71: aload 6
    //   73: iload_2
    //   74: putfield 2189	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:gGB	I
    //   77: aload 6
    //   79: invokevirtual 2192	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:bFy	()Z
    //   82: ifeq +48 -> 130
    //   85: aload 6
    //   87: getfield 2196	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:niI	Lcom/tencent/mm/ai/x;
    //   90: astore_3
    //   91: aload_3
    //   92: ifnonnull +9 -> 101
    //   95: ldc_w 1935
    //   98: invokestatic 2199	d/g/b/k:aPZ	(Ljava/lang/String;)V
    //   101: aload 6
    //   103: getfield 2196	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:niI	Lcom/tencent/mm/ai/x;
    //   106: astore 6
    //   108: aload 6
    //   110: ifnonnull +9 -> 119
    //   113: ldc_w 1935
    //   116: invokestatic 2199	d/g/b/k:aPZ	(Ljava/lang/String;)V
    //   119: aload_3
    //   120: aload 6
    //   122: getfield 2200	com/tencent/mm/ai/x:gGB	I
    //   125: iconst_1
    //   126: ior
    //   127: putfield 2200	com/tencent/mm/ai/x:gGB	I
    //   130: aload_0
    //   131: getfield 2204	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:nhM	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/o;
    //   134: invokevirtual 2209	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/o:VV	()V
    //   137: aload_0
    //   138: getfield 2210	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:AQP	Lcom/tencent/mm/plugin/webview/c/f;
    //   141: astore_3
    //   142: aload_3
    //   143: ifnull +15 -> 158
    //   146: aload_3
    //   147: ldc_w 2212
    //   150: aload_0
    //   151: iload_2
    //   152: invokespecial 2215	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:yr	(I)I
    //   155: invokevirtual 2218	com/tencent/mm/plugin/webview/c/f:eV	(Ljava/lang/String;I)V
    //   158: aload_1
    //   159: getfield 2222	com/tencent/mm/protocal/protobuf/ez:CzI	Lcom/tencent/mm/protocal/protobuf/bol;
    //   162: ifnull +24 -> 186
    //   165: aload_0
    //   166: getfield 604	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:nhL	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   169: invokevirtual 2192	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:bFy	()Z
    //   172: ifeq +14 -> 186
    //   175: aload_0
    //   176: getfield 604	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:nhL	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   179: aload_1
    //   180: getfield 2222	com/tencent/mm/protocal/protobuf/ez:CzI	Lcom/tencent/mm/protocal/protobuf/bol;
    //   183: putfield 2225	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:niO	Lcom/tencent/mm/protocal/protobuf/bol;
    //   186: aload_0
    //   187: getfield 604	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:nhL	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   190: aload_1
    //   191: getfield 2226	com/tencent/mm/protocal/protobuf/ez:gGC	Ljava/lang/String;
    //   194: putfield 1414	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:gGC	Ljava/lang/String;
    //   197: aload_0
    //   198: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nju	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   201: astore 7
    //   203: aload_1
    //   204: getfield 2226	com/tencent/mm/protocal/protobuf/ez:gGC	Ljava/lang/String;
    //   207: astore 6
    //   209: aload 6
    //   211: astore_3
    //   212: aload 6
    //   214: ifnonnull +7 -> 221
    //   217: ldc_w 523
    //   220: astore_3
    //   221: aload 7
    //   223: aload_3
    //   224: putfield 2229	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:nlK	Ljava/lang/String;
    //   227: aload_0
    //   228: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nju	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   231: aload_0
    //   232: invokevirtual 2232	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:getScene	()I
    //   235: invokestatic 1030	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   238: putfield 2235	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:nlL	Ljava/lang/String;
    //   241: aload_0
    //   242: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nju	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   245: aload_0
    //   246: invokevirtual 2238	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:getSubScene	()I
    //   249: invokestatic 1030	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   252: putfield 2241	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:nlM	Ljava/lang/String;
    //   255: aload_1
    //   256: getfield 2244	com/tencent/mm/protocal/protobuf/ez:CzH	Ljava/lang/String;
    //   259: astore_3
    //   260: aload_3
    //   261: ifnull +11 -> 272
    //   264: aload_0
    //   265: getfield 604	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:nhL	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   268: aload_3
    //   269: putfield 2247	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:niC	Ljava/lang/String;
    //   272: aload_0
    //   273: getfield 604	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:nhL	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   276: aload_1
    //   277: getfield 2248	com/tencent/mm/protocal/protobuf/ez:url	Ljava/lang/String;
    //   280: invokevirtual 2251	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:PY	(Ljava/lang/String;)V
    //   283: aload_1
    //   284: getfield 2248	com/tencent/mm/protocal/protobuf/ez:url	Ljava/lang/String;
    //   287: astore_3
    //   288: aload_3
    //   289: ifnull +8 -> 297
    //   292: aload_0
    //   293: aload_3
    //   294: putfield 527	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:eOT	Ljava/lang/String;
    //   297: aload_1
    //   298: getfield 2255	com/tencent/mm/protocal/protobuf/ez:CzG	Lcom/tencent/mm/protocal/protobuf/dkm;
    //   301: ifnull +126 -> 427
    //   304: aload_1
    //   305: getfield 2255	com/tencent/mm/protocal/protobuf/ez:CzG	Lcom/tencent/mm/protocal/protobuf/dkm;
    //   308: getfield 2260	com/tencent/mm/protocal/protobuf/dkm:dmD	I
    //   311: ifeq +116 -> 427
    //   314: aload_0
    //   315: getfield 449	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:TAG	Ljava/lang/String;
    //   318: new 585	java/lang/StringBuilder
    //   321: dup
    //   322: ldc_w 2262
    //   325: invokespecial 589	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   328: aload_1
    //   329: getfield 2255	com/tencent/mm/protocal/protobuf/ez:CzG	Lcom/tencent/mm/protocal/protobuf/dkm;
    //   332: getfield 2265	com/tencent/mm/protocal/protobuf/dkm:dmE	Ljava/lang/String;
    //   335: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: ldc_w 2267
    //   341: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload_1
    //   345: getfield 2255	com/tencent/mm/protocal/protobuf/ez:CzG	Lcom/tencent/mm/protocal/protobuf/dkm;
    //   348: getfield 2260	com/tencent/mm/protocal/protobuf/dkm:dmD	I
    //   351: invokevirtual 593	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: invokevirtual 600	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 580	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload_0
    //   361: invokespecial 1419	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bFF	()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;
    //   364: aload_1
    //   365: getfield 2255	com/tencent/mm/protocal/protobuf/ez:CzG	Lcom/tencent/mm/protocal/protobuf/dkm;
    //   368: getfield 2265	com/tencent/mm/protocal/protobuf/dkm:dmE	Ljava/lang/String;
    //   371: invokevirtual 2270	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView:setPlayError$505cff1c	(Ljava/lang/String;)V
    //   374: aload_0
    //   375: invokespecial 1677	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bFU	()V
    //   378: bipush 32
    //   380: invokestatic 962	com/tencent/mm/plugin/webview/h/a:Tb	(I)V
    //   383: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nlE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   386: astore_1
    //   387: aload_0
    //   388: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nju	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   391: ldc_w 2176
    //   394: invokevirtual 1712	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:Qc	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/em;
    //   397: astore_1
    //   398: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nlE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   401: astore_3
    //   402: aload_1
    //   403: ldc_w 2178
    //   406: ldc_w 2180
    //   409: invokestatic 2183	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/em;Ljava/lang/String;Ljava/lang/String;)V
    //   412: aload_1
    //   413: aload_0
    //   414: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nju	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   417: invokestatic 1715	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/em;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;)V
    //   420: sipush 7187
    //   423: invokestatic 442	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   426: return
    //   427: aload_0
    //   428: invokespecial 1681	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bFT	()V
    //   431: aload_1
    //   432: getfield 2273	com/tencent/mm/protocal/protobuf/ez:CzM	Ljava/util/LinkedList;
    //   435: astore_3
    //   436: aload_3
    //   437: ifnull +345 -> 782
    //   440: aload_3
    //   441: checkcast 2275	java/lang/Iterable
    //   444: astore_3
    //   445: new 2277	java/util/ArrayList
    //   448: dup
    //   449: aload_3
    //   450: bipush 10
    //   452: invokestatic 2282	d/a/j:a	(Ljava/lang/Iterable;I)I
    //   455: invokespecial 2284	java/util/ArrayList:<init>	(I)V
    //   458: checkcast 2066	java/util/Collection
    //   461: astore 7
    //   463: aload_3
    //   464: invokeinterface 2288 1 0
    //   469: astore 8
    //   471: aload 8
    //   473: invokeinterface 2293 1 0
    //   478: ifeq +304 -> 782
    //   481: aload 8
    //   483: invokeinterface 2297 1 0
    //   488: checkcast 2299	com/tencent/mm/protocal/protobuf/bmy
    //   491: astore 6
    //   493: getstatic 2305	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:nkE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/a;
    //   496: astore_3
    //   497: aload 6
    //   499: getfield 2306	com/tencent/mm/protocal/protobuf/bmy:url	Ljava/lang/String;
    //   502: astore_3
    //   503: aload 6
    //   505: getfield 2309	com/tencent/mm/protocal/protobuf/bmy:DKs	Ljava/lang/String;
    //   508: astore 9
    //   510: aload_3
    //   511: invokestatic 702	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   514: ifne +11 -> 525
    //   517: aload 9
    //   519: invokestatic 702	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   522: ifeq +26 -> 548
    //   525: getstatic 2310	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:TAG	Ljava/lang/String;
    //   528: ldc_w 2312
    //   531: invokestatic 2314	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: aload 7
    //   536: getstatic 2089	d/y:JfV	Ld/y;
    //   539: invokeinterface 2315 2 0
    //   544: pop
    //   545: goto -74 -> 471
    //   548: invokestatic 2318	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:bGl	()Z
    //   551: ifne +15 -> 566
    //   554: getstatic 2310	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:TAG	Ljava/lang/String;
    //   557: ldc_w 2320
    //   560: invokestatic 2314	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   563: goto -29 -> 534
    //   566: new 585	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 910	java/lang/StringBuilder:<init>	()V
    //   573: getstatic 2324	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:nkD	Lcom/tencent/mm/sdk/platformtools/ao;
    //   576: invokevirtual 2329	com/tencent/mm/sdk/platformtools/ao:eEX	()Ljava/lang/Object;
    //   579: checkcast 2331	com/tencent/mm/vfs/e
    //   582: invokevirtual 2334	com/tencent/mm/vfs/e:getPath	()Ljava/lang/String;
    //   585: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: bipush 47
    //   590: invokevirtual 596	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   593: astore 6
    //   595: aload_3
    //   596: invokestatic 2340	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   599: astore_3
    //   600: aload_3
    //   601: ldc_w 2342
    //   604: invokestatic 981	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   607: new 2331	com/tencent/mm/vfs/e
    //   610: dup
    //   611: aload 6
    //   613: aload_3
    //   614: invokevirtual 2345	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   617: invokevirtual 918	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: invokevirtual 600	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: invokespecial 2346	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   626: astore_3
    //   627: aload_3
    //   628: invokevirtual 2349	com/tencent/mm/vfs/e:exists	()Z
    //   631: ifne +23 -> 654
    //   634: new 2331	com/tencent/mm/vfs/e
    //   637: dup
    //   638: aload_3
    //   639: invokevirtual 2352	com/tencent/mm/vfs/e:getParent	()Ljava/lang/String;
    //   642: invokespecial 2346	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   645: invokevirtual 2355	com/tencent/mm/vfs/e:mkdirs	()Z
    //   648: pop
    //   649: aload_3
    //   650: invokevirtual 2358	com/tencent/mm/vfs/e:createNewFile	()Z
    //   653: pop
    //   654: aload_3
    //   655: invokestatic 2364	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   658: checkcast 2366	java/io/Closeable
    //   661: astore 6
    //   663: aload 6
    //   665: checkcast 2368	java/io/OutputStream
    //   668: astore 10
    //   670: aload 9
    //   672: ifnull +105 -> 777
    //   675: getstatic 2374	d/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   678: astore_3
    //   679: aload 9
    //   681: ifnonnull +46 -> 727
    //   684: new 835	d/v
    //   687: dup
    //   688: ldc_w 2376
    //   691: invokespecial 838	d/v:<init>	(Ljava/lang/String;)V
    //   694: astore_1
    //   695: sipush 7187
    //   698: invokestatic 442	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   701: aload_1
    //   702: athrow
    //   703: astore_3
    //   704: sipush 7187
    //   707: invokestatic 442	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   710: aload_3
    //   711: athrow
    //   712: astore_1
    //   713: aload 6
    //   715: aload_3
    //   716: invokestatic 2381	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   719: sipush 7187
    //   722: invokestatic 442	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   725: aload_1
    //   726: athrow
    //   727: aload 9
    //   729: aload_3
    //   730: invokevirtual 2385	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   733: astore_3
    //   734: aload_3
    //   735: ldc_w 2387
    //   738: invokestatic 981	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   741: aload 10
    //   743: aload_3
    //   744: invokevirtual 2391	java/io/OutputStream:write	([B)V
    //   747: getstatic 2310	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:TAG	Ljava/lang/String;
    //   750: ldc_w 2393
    //   753: aload 9
    //   755: invokestatic 692	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   758: invokevirtual 696	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   761: invokestatic 2314	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: getstatic 2089	d/y:JfV	Ld/y;
    //   767: astore_3
    //   768: aload 6
    //   770: aconst_null
    //   771: invokestatic 2381	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   774: goto -240 -> 534
    //   777: aconst_null
    //   778: astore_3
    //   779: goto -38 -> 741
    //   782: aload_1
    //   783: getfield 1092	com/tencent/mm/protocal/protobuf/ez:Czz	Ljava/util/LinkedList;
    //   786: checkcast 2395	java/util/List
    //   789: invokestatic 2399	com/tencent/mm/sdk/platformtools/bt:gL	(Ljava/util/List;)Z
    //   792: ifeq +24 -> 816
    //   795: aload_0
    //   796: getfield 449	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:TAG	Ljava/lang/String;
    //   799: ldc_w 2401
    //   802: invokestatic 957	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   805: iconst_4
    //   806: invokestatic 962	com/tencent/mm/plugin/webview/h/a:Tb	(I)V
    //   809: sipush 7187
    //   812: invokestatic 442	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   815: return
    //   816: aload_0
    //   817: invokespecial 567	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bFB	()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;
    //   820: astore 7
    //   822: aload_0
    //   823: invokevirtual 992	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bEU	()Lcom/tencent/mm/ai/x;
    //   826: astore 6
    //   828: aload_1
    //   829: getfield 2404	com/tencent/mm/protocal/protobuf/ez:CzN	Ljava/lang/String;
    //   832: astore 5
    //   834: aload 5
    //   836: astore_3
    //   837: aload 5
    //   839: ifnonnull +7 -> 846
    //   842: ldc_w 523
    //   845: astore_3
    //   846: aload 6
    //   848: ldc_w 1935
    //   851: invokestatic 708	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   854: aload_3
    //   855: ldc_w 2406
    //   858: invokestatic 708	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   861: aload 7
    //   863: getfield 2075	com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView:noh	Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar;
    //   866: astore 5
    //   868: aload 5
    //   870: ifnonnull +6 -> 876
    //   873: invokestatic 679	d/g/b/k:fvU	()V
    //   876: aload 5
    //   878: aload 6
    //   880: getfield 2409	com/tencent/mm/ai/x:gKv	Ljava/lang/String;
    //   883: aload 6
    //   885: invokevirtual 997	com/tencent/mm/ai/x:SI	()Ljava/lang/String;
    //   888: aload_3
    //   889: invokevirtual 2412	com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar:M	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   892: aload_0
    //   893: iconst_1
    //   894: putfield 1075	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:njw	Z
    //   897: aload_1
    //   898: getfield 1092	com/tencent/mm/protocal/protobuf/ez:Czz	Ljava/util/LinkedList;
    //   901: astore_3
    //   902: aload_3
    //   903: ldc_w 1094
    //   906: invokestatic 981	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   909: aload_3
    //   910: invokestatic 1104	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/k:I	(Ljava/util/LinkedList;)Lcom/tencent/mm/protocal/protobuf/fn;
    //   913: astore 6
    //   915: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nlE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   918: astore_3
    //   919: aload_0
    //   920: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nju	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   923: ldc_w 2176
    //   926: invokevirtual 1712	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:Qc	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/em;
    //   929: astore 5
    //   931: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nlE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   934: astore_3
    //   935: aload 5
    //   937: ldc_w 2414
    //   940: ldc_w 2416
    //   943: invokestatic 2183	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/em;Ljava/lang/String;Ljava/lang/String;)V
    //   946: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nlE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   949: astore_3
    //   950: aload 5
    //   952: ldc_w 2418
    //   955: ldc_w 2416
    //   958: invokestatic 2183	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/em;Ljava/lang/String;Ljava/lang/String;)V
    //   961: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nlE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   964: astore_3
    //   965: aload 6
    //   967: ifnull +123 -> 1090
    //   970: aload 6
    //   972: getfield 1109	com/tencent/mm/protocal/protobuf/fn:CAm	I
    //   975: invokestatic 1665	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   978: astore_3
    //   979: aload 5
    //   981: ldc_w 2420
    //   984: aload_3
    //   985: invokestatic 692	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   988: invokestatic 2183	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/em;Ljava/lang/String;Ljava/lang/String;)V
    //   991: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nlE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   994: astore_3
    //   995: aload 6
    //   997: ifnull +98 -> 1095
    //   1000: aload 6
    //   1002: getfield 1202	com/tencent/mm/protocal/protobuf/fn:width	I
    //   1005: invokestatic 1665	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1008: astore_3
    //   1009: aload 5
    //   1011: ldc_w 2422
    //   1014: aload_3
    //   1015: invokestatic 692	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1018: invokestatic 2183	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/em;Ljava/lang/String;Ljava/lang/String;)V
    //   1021: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nlE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1024: astore_3
    //   1025: aload 4
    //   1027: astore_3
    //   1028: aload 6
    //   1030: ifnull +12 -> 1042
    //   1033: aload 6
    //   1035: getfield 1204	com/tencent/mm/protocal/protobuf/fn:height	I
    //   1038: invokestatic 1665	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1041: astore_3
    //   1042: aload 5
    //   1044: ldc_w 2424
    //   1047: aload_3
    //   1048: invokestatic 692	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1051: invokestatic 2183	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/em;Ljava/lang/String;Ljava/lang/String;)V
    //   1054: getstatic 513	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:nlE	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1057: astore_3
    //   1058: aload 5
    //   1060: ldc_w 2178
    //   1063: ldc_w 2416
    //   1066: invokestatic 2183	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/em;Ljava/lang/String;Ljava/lang/String;)V
    //   1069: aload 5
    //   1071: aload_0
    //   1072: getfield 522	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:nju	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   1075: invokestatic 1715	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/em;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;)V
    //   1078: aload_0
    //   1079: aload_1
    //   1080: invokespecial 2010	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/ez;)V
    //   1083: sipush 7187
    //   1086: invokestatic 442	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	1107	1	paramez	ez
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
  
  public final boolean bEZ()
  {
    return true;
  }
  
  public final void bFJ()
  {
    AppMethodBeat.i(7153);
    this.nju.bGq();
    super.bFJ();
    if (!this.njt)
    {
      this.njt = true;
      com.tencent.mm.pluginsdk.g.o((MMActivity)this);
      com.tencent.mm.plugin.webview.h.a.Tb(0);
    }
    getIntent().putExtra("vertical_scroll", false);
    AppMethodBeat.o(7153);
  }
  
  public final void bFM()
  {
    AppMethodBeat.i(7169);
    com.tencent.mm.plugin.webview.ui.tools.widget.n localn = eol();
    localn.setMinHeaderHeight(this.nji.height);
    localn.setUrl(this.eOT);
    localn.erl();
    localn.a(this.nhL.scene, this.nhL.niJ, this.nhL.gGx, this.nhL.niH, this.nhL.url, bEU().gKx.title);
    localn.setCallback((n.c)new n(this));
    localn.setTimeLineSessionId(localn.getTimeLineSessionId());
    AppMethodBeat.o(7169);
  }
  
  public final int bFN()
  {
    AppMethodBeat.i(7181);
    Object localObject = bFB();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((MPVideoView)localObject).getCurrPosSec());; localObject = null)
    {
      int j = ((Integer)localObject).intValue();
      localObject = bFB();
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
  
  public final void bFQ()
  {
    AppMethodBeat.i(7184);
    if (this.njk == null)
    {
      AppMethodBeat.o(7184);
      return;
    }
    com.tencent.mm.plugin.webview.h.a.Tb(61);
    if (!this.njm) {
      com.tencent.mm.plugin.webview.h.a.Tb(62);
    }
    Object localObject = this.AQP;
    int i;
    MMWebViewWithJsApi localMMWebViewWithJsApi;
    if (localObject != null)
    {
      i = bGa();
      localMMWebViewWithJsApi = this.njk;
      if (localMMWebViewWithJsApi == null) {
        d.g.b.k.fvU();
      }
      ((com.tencent.mm.plugin.webview.c.f)localObject).M(i, localMMWebViewWithJsApi.hashCode(), "disappear");
    }
    localObject = this.AQP;
    if (localObject != null)
    {
      i = bGa();
      localMMWebViewWithJsApi = this.njk;
      if (localMMWebViewWithJsApi == null) {
        d.g.b.k.fvU();
      }
      ((com.tencent.mm.plugin.webview.c.f)localObject).M(i, localMMWebViewWithJsApi.hashCode(), "destroy");
    }
    localObject = bFD();
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = bFD();
    if (localObject != null) {
      ((FrameLayout)localObject).removeView((View)this.njk);
    }
    localObject = this.njk;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getCurWebviewClient();
      if (!(localObject instanceof com.tencent.mm.plugin.webview.ui.tools.widget.k)) {
        break label223;
      }
      localObject = this.njk;
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
    localObject = this.njk;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).destroy();
    }
    localObject = this.njk;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebChromeClient(null);
    }
    localObject = this.njk;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebViewClient(null);
    }
    localObject = this.njk;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnTouchListener(null);
    }
    localObject = this.njk;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnLongClickListener(null);
    }
    localObject = this.njk;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setVisibility(8);
    }
    localObject = this.njk;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).removeAllViews();
    }
    localObject = this.njk;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).clearView();
    }
    this.njk = null;
    this.njm = false;
    localObject = this.njr;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).cUw = false;
    }
    localObject = this.njr;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).nkK = false;
    }
    this.njr = null;
    AppMethodBeat.o(7184);
  }
  
  public final void bFa()
  {
    AppMethodBeat.i(7154);
    super.bFa();
    setBackBtn((MenuItem.OnMenuItemClickListener)new BizVideoDetailUI.m(this), 2131689492);
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
    em localem = this.nju.Qc("1");
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
    localObject = this.nip;
    boolean bool;
    if (localObject != null)
    {
      bool = ((MpWebViewController)localObject).bEH();
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (localObject = "1";; localObject = "0")
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localem, "MiaoKai", (String)localObject);
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localem, this.nju);
      AppMethodBeat.o(7154);
      return;
      bool = false;
      break;
    }
  }
  
  public final void bFb()
  {
    AppMethodBeat.i(175513);
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h localh = this.njf;
    if (localh != null) {
      localh.release();
    }
    bGc();
    this.njs.reset();
    eon();
    this.nhM.onDestroy();
    int i = bFN();
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.ct(bFR(), i);
    this.nhL.onDestroy();
    bFP();
    bFQ();
    bFB().onUIDestroy();
    AppMethodBeat.o(175513);
  }
  
  public final void bFh()
  {
    AppMethodBeat.i(7197);
    bFP();
    AppMethodBeat.o(7197);
  }
  
  public final void bFi()
  {
    AppMethodBeat.i(7198);
    ad.i(this.TAG, "adWebviewReady");
    this.njl = true;
    AppMethodBeat.o(7198);
  }
  
  public final Bundle bFj()
  {
    AppMethodBeat.i(7199);
    Bundle localBundle = new Bundle();
    localBundle.putInt("currentTime", bFB().getCurrPosSec());
    localBundle.putInt("duration", bFB().getDuration());
    localBundle.putString("state", this.njv);
    localBundle.putLong("playedTotalTime", bFB().getRealPlayTime());
    localBundle.putString("vid", this.nhL.gGC);
    AppMethodBeat.o(7199);
    return localBundle;
  }
  
  public final int bGa()
  {
    AppMethodBeat.i(7212);
    if (this.njr == null)
    {
      AppMethodBeat.o(7212);
      return -1;
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c localc = this.njr;
    if (localc == null) {
      d.g.b.k.fvU();
    }
    int i = localc.id;
    AppMethodBeat.o(7212);
    return i;
  }
  
  public final void bGb()
  {
    AppMethodBeat.i(7213);
    if ((this.njq) || (bFB().getCurrPosSec() <= 0))
    {
      AppMethodBeat.o(7213);
      return;
    }
    float f = bFB().getCurrPosMs() / 1000.0F;
    if ((this.njk != null) && (this.njs.b(f, this.njr)))
    {
      localObject = this.njr;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).cUw)
      {
        if (com.tencent.mm.sdk.platformtools.h.DEBUG) {
          ad.d(this.TAG, "dot end, wait h5 to close");
        }
        if (System.currentTimeMillis() - this.njC >= 1000L)
        {
          ad.i(this.TAG, "dot end, time out to close");
          bFQ();
        }
        AppMethodBeat.o(7213);
        return;
      }
      ad.i(this.TAG, "destroyDotWebView");
      localObject = bFD();
      if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
      {
        localObject = this.njk;
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
        localObject = this.njk;
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        if (((com.tencent.mm.plugin.webview.c.f)localObject).isReady()) {
          break;
        }
      }
      bFQ();
      if (this.njr == null) {
        break label360;
      }
      if (this.njm)
      {
        localObject = bFD();
        if (((localObject == null) || (((FrameLayout)localObject).getVisibility() != 0)) && (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.a(f, this.njr))) {
          bFZ();
        }
      }
      AppMethodBeat.o(7213);
      return;
    }
    localObject = this.njr;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).cUw = true;
    this.njC = System.currentTimeMillis();
    localObject = this.njk;
    int i;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
      if (localObject != null)
      {
        i = bGa();
        MMWebViewWithJsApi localMMWebViewWithJsApi = this.njk;
        if (localMMWebViewWithJsApi == null) {
          d.g.b.k.fvU();
        }
        ((com.tencent.mm.plugin.webview.c.f)localObject).M(i, localMMWebViewWithJsApi.hashCode(), "end");
        AppMethodBeat.o(7213);
        return;
      }
    }
    AppMethodBeat.o(7213);
    return;
    label360:
    this.njr = this.njs.aN(f);
    if (this.njr != null)
    {
      i = bGa();
      localObject = this.njr;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      aC(i, ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).url);
    }
    AppMethodBeat.o(7213);
  }
  
  public final void bol()
  {
    AppMethodBeat.i(7156);
    super.bol();
    if (this.kxf != null) {}
    try
    {
      this.nhL.niP.nlY = this.kxf.sD(bEU().SI());
      this.nhL.niP.ea(1, 0);
      Object localObject = this.kxf;
      d.g.b.k.g(localObject, "invoker");
      this.uin = ((e)localObject).enp();
      this.nhL.niL = bFK();
      this.njp = false;
      this.nhL.bFv();
      this.nju.Qc("5");
      if (!bt.isNullOrNil(bEU().gKx.title))
      {
        localObject = eoj();
        if (localObject != null) {
          ((com.tencent.mm.plugin.webview.ui.tools.b.a)localObject).OE(bEU().gKx.title);
        }
      }
      localObject = eoj();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.webview.ui.tools.b.a)localObject).ayd("1");
        AppMethodBeat.o(7156);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.w(this.TAG, "invoker ex :" + localException.getMessage());
      }
      AppMethodBeat.o(7156);
    }
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(7177);
    if (this.lpO)
    {
      int i = getRequestedOrientation();
      AppMethodBeat.o(7177);
      return i;
    }
    AppMethodBeat.o(7177);
    return 1;
  }
  
  public final void iA(boolean paramBoolean)
  {
    AppMethodBeat.i(7166);
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h localh = this.njf;
    if (localh != null)
    {
      ad.i("MicroMsg.BizVideoOrientationHelper", "enable :".concat(String.valueOf(paramBoolean)));
      if (localh.aob())
      {
        Object localObject;
        if (paramBoolean)
        {
          localh.nlg.enable();
          if (localh.mSensorManager == null)
          {
            localObject = aj.getContext().getSystemService("sensor");
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
              localh.nle = ((Sensor)localObject);
              localObject = localh.mSensorManager;
              if (localObject == null) {
                break;
              }
              ((SensorManager)localObject).registerListener((SensorEventListener)localh, localh.nle, 3);
              AppMethodBeat.o(7166);
              return;
            }
            AppMethodBeat.o(7166);
          }
        }
        else
        {
          localh.nlg.disable();
          localObject = localh.jyt.get();
          if (localObject == null)
          {
            localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(7166);
            throw ((Throwable)localObject);
          }
          ((MMActivity)localObject).setRequestedOrientation(1);
          localh.gBw = 0;
        }
      }
      AppMethodBeat.o(7166);
      return;
    }
    AppMethodBeat.o(7166);
  }
  
  public void initView()
  {
    AppMethodBeat.i(7155);
    super.initView();
    if (bEU().gKx == null)
    {
      finish();
      ad.w(this.TAG, "onCreate msgInfo.item is null");
      AppMethodBeat.o(7155);
      return;
    }
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("onCreate rawUrl is ");
    Object localObject3 = bEU().gKx;
    if (localObject3 == null) {
      d.g.b.k.fvU();
    }
    ad.i((String)localObject1, ((com.tencent.mm.ai.v)localObject3).url);
    localObject3 = this.nju;
    localObject1 = bEU().gKx;
    if (localObject1 == null) {
      d.g.b.k.fvU();
    }
    localObject2 = ((com.tencent.mm.ai.v)localObject1).url;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((j.a)localObject3).nlJ = ((String)localObject1);
    this.nju.nlH = String.valueOf(bEX());
    this.nju.nlI = String.valueOf(System.currentTimeMillis() / 1000L);
    localObject1 = this.nhL;
    localObject2 = this.jkE;
    d.g.b.k.h(localObject2, "callback");
    ((b)localObject1).jkE = ((IPCRunCgi.a)localObject2);
    localObject1 = this.nhM;
    localObject2 = (TmplShareWebViewToolUI)this;
    localObject3 = bEU();
    Object localObject4 = this.nhL;
    d.g.b.k.h(localObject2, "ui");
    d.g.b.k.h(localObject3, "msgInfo");
    d.g.b.k.h(localObject4, "controller");
    ((o)localObject1).kUk = new WeakReference(localObject2);
    ((o)localObject1).niI = ((x)localObject3);
    ((o)localObject1).njZ = ((b)localObject4);
    this.nhL.niK = ((Number)this.nhT.a(TmplShareWebViewToolUI.$$delegatedProperties[8])).intValue();
    this.nhL.niP.nld = new WeakReference(bFB());
    localObject1 = this.nhL;
    localObject3 = (TmplShareWebViewToolUI)this;
    int i = getScene();
    int j = getSubScene();
    localObject4 = bEU().gKx;
    if (localObject4 == null) {
      d.g.b.k.fvU();
    }
    localObject2 = bEU();
    int k = bEX();
    d.g.b.k.h(localObject3, "ui");
    d.g.b.k.h(localObject4, "readerItem");
    d.g.b.k.h(localObject2, "msgInfo");
    ((b)localObject1).kUk = new WeakReference(localObject3);
    ((b)localObject1).scene = i;
    ((b)localObject1).niJ = j;
    ((b)localObject1).PY(((com.tencent.mm.ai.v)localObject4).url);
    ((b)localObject1).mYN = ((com.tencent.mm.ai.v)localObject4);
    ((b)localObject1).niI = ((x)localObject2);
    ((b)localObject1).gGx = ((com.tencent.mm.ai.v)localObject4).type;
    ((b)localObject1).niH = k;
    ((b)localObject1).dfT = ((x)localObject2).dfT;
    ((b)localObject1).niB = ((x)localObject2).gKv;
    ((b)localObject1).gGC = ((x)localObject2).gKx.gGC;
    localObject3 = ((b)localObject1).niD;
    d.g.b.k.h(localObject1, "controller");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.n)localObject3).njZ = ((b)localObject1);
    localObject3 = ((b)localObject1).niP;
    d.g.b.k.h(localObject1, "controller");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject3).njZ = ((b)localObject1);
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject3).nlZ = true;
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject3).nlX = "";
    try
    {
      localObject2 = Uri.parse(((x)localObject2).gKx.url);
      ((b)localObject1).gLf = bt.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
      ((b)localObject1).idx = bt.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
      ad.i(((b)localObject1).TAG, "init vid=" + ((b)localObject1).gGC);
      localObject3 = this.nhL;
      localObject2 = getIntent().getStringExtra("biz_video_channel_session_id");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      d.g.b.k.h(localObject1, "<set-?>");
      ((b)localObject3).niM = ((String)localObject1);
      com.tencent.mm.plugin.webview.h.a.Tb(1);
      this.njs.reset();
      this.Bis.setMMOverScrollOffsetListener((LogoWebViewWrapper.b)new x(this));
      this.Bis.eod();
      this.Bis.eoe();
      this.njw = false;
      this.njx = false;
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ((IntentFilter)localObject1).setPriority(2147483647);
      if (this.njF == null) {
        this.njF = ((BroadcastReceiver)new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(7132);
            d.g.b.k.h(paramAnonymousContext, "context");
            if ((paramAnonymousIntent == null) || (bt.isNullOrNil(paramAnonymousIntent.getAction())) || (!this.njI.njp) || ((BizVideoDetailUI.k(this.njI).niG) && (!BizVideoDetailUI.v(this.njI))))
            {
              AppMethodBeat.o(7132);
              return;
            }
            boolean bool1 = ay.isNetworkConnected(aj.getContext());
            if ((!BizVideoDetailUI.w(this.njI)) && (bool1))
            {
              paramAnonymousContext = BizVideoDetailUI.f(this.njI);
              paramAnonymousIntent = paramAnonymousContext.nog;
              if (paramAnonymousIntent == null) {
                d.g.b.k.fvU();
              }
              if (paramAnonymousIntent.isPlaying())
              {
                paramAnonymousIntent = paramAnonymousContext.nog;
                if (paramAnonymousIntent == null) {
                  d.g.b.k.fvU();
                }
                if (paramAnonymousIntent.kuP == null) {
                  break label421;
                }
                paramAnonymousIntent = paramAnonymousIntent.kuP;
                if (paramAnonymousIntent == null) {
                  d.g.b.k.fvU();
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
                paramAnonymousIntent = paramAnonymousContext.nog;
                if (paramAnonymousIntent == null) {
                  d.g.b.k.fvU();
                }
                if (paramAnonymousIntent.bGI())
                {
                  paramAnonymousIntent = paramAnonymousContext.nog;
                  if (paramAnonymousIntent == null) {
                    d.g.b.k.fvU();
                  }
                  paramAnonymousContext = paramAnonymousContext.nog;
                  if (paramAnonymousContext == null) {
                    d.g.b.k.fvU();
                  }
                  paramAnonymousIntent.T(paramAnonymousContext.getCurrPosMs(), true);
                }
              }
              BizVideoDetailUI.c(this.njI, bool1);
              bool1 = ay.isWifi(aj.getContext());
              i = BizVideoDetailUI.x(this.njI);
              BizVideoDetailUI.a(this.njI, BizVideoDetailUI.y(this.njI));
              boolean bool2 = BizVideoDetailUI.b(this.njI, BizVideoDetailUI.f(this.njI).getDuration());
              ad.i(BizVideoDetailUI.m(this.njI), "net type change simcardTpye=" + BizVideoDetailUI.x(this.njI) + ", lastSimcardType=" + i + ", is wifi=" + bool1 + ", show=" + bool2);
              if (!bool2) {
                break label441;
              }
              paramAnonymousContext = BizVideoDetailUI.i(this.njI);
              d.g.b.k.g(paramAnonymousContext, "videoWifiTipsView");
              if (paramAnonymousContext.getVisibility() == 0) {
                break label449;
              }
              if ((!BizVideoDetailUI.f(this.njI).isPlaying()) || (this.njI.njq) || ((BizVideoDetailUI.f(this.njI).bGP()) && (BizVideoDetailUI.f(this.njI).bcg()))) {
                break;
              }
              BizVideoDetailUI.b(this.njI, true);
              AppMethodBeat.o(7132);
              return;
            }
            this.njI.njn = true;
            AppMethodBeat.o(7132);
            return;
            label441:
            BizVideoDetailUI.a(this.njI, 0L);
            label449:
            AppMethodBeat.o(7132);
          }
        });
      }
      getContext().registerReceiver(this.njF, (IntentFilter)localObject1);
      AppMethodBeat.o(7155);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        ad.w(((b)localObject1).TAG, "init parse url exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.w(((b)localObject1).TAG, "init parse url exp %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(7194);
    o localo = this.nhM;
    Object localObject3;
    int i;
    if (paramInt1 == 1) {
      if (paramInt2 == -1)
      {
        localObject2 = (Context)localo.bFx();
        localObject3 = localo.bFx();
        if (localObject3 != null) {
          localObject1 = ((TmplShareWebViewToolUI)localObject3).getString(2131756660);
        }
        com.tencent.mm.ui.base.h.cc((Context)localObject2, (String)localObject1);
        if (localo.nms)
        {
          i = 11;
          localObject1 = localo.njZ;
          if (localObject1 == null) {
            d.g.b.k.aPZ("controller");
          }
          ((b)localObject1).niD.yD(i);
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
        break label252;
      }
      AppMethodBeat.o(7194);
      return;
      i = 2;
      break;
      if (paramInt1 == 2)
      {
        if (paramInt2 == -1) {
          if (paramIntent == null) {
            break label240;
          }
        }
        label240:
        for (localObject1 = paramIntent.getStringExtra("Select_Conv_User");; localObject1 = null)
        {
          if (paramIntent != null) {
            localObject2 = paramIntent.getStringExtra("custom_send_text");
          }
          if (localObject1 != null)
          {
            localObject3 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.g.nlc;
            localObject3 = localo.niI;
            if (localObject3 == null) {
              d.g.b.k.aPZ("msgInfo");
            }
            b localb = localo.njZ;
            if (localb == null) {
              d.g.b.k.aPZ("controller");
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.g.a((String)localObject1, (x)localObject3, (String)localObject2, localb, (com.tencent.mm.ipcinvoker.d)new o.a(localo));
          }
          i = 1;
          break;
        }
      }
      i = 0;
    }
    label252:
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(7194);
  }
  
  public void onBackPressed()
  {
    int i = 1;
    AppMethodBeat.i(7185);
    if (this.lpO)
    {
      bFB().p(false, 0);
      AppMethodBeat.o(7185);
      return;
    }
    com.tencent.mm.plugin.webview.ui.tools.widget.n localn = eol();
    if ((localn.getSayFooter().erj()) && (localn.bcB())) {
      localn.getSayFooter().dCL();
    }
    for (;;)
    {
      if (i == 0) {
        super.onBackPressed();
      }
      AppMethodBeat.o(7185);
      return;
      if ((localn.BiC != -3) && (localn.bcB())) {
        localn.hide();
      } else {
        i = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7179);
    this.nju.Qd("21");
    this.nju.Qd("22");
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.nju.Qc("2"), this.nju);
    bFO();
    super.onDestroy();
    localObject = this.njg;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.widget.a)localObject).b(this.njB);
    }
    bFb();
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.Qb(((BizVideoDetailUI)this).toString());
    AppMethodBeat.o(7179);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(7186);
    ad.i(this.TAG, "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.lpO))
    {
      bFB().p(false, 0);
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
    Object localObject = bFB();
    ad.i(MPVideoView.TAG, "onUIPause");
    localObject = ((MPVideoView)localObject).nog;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    ((MPExoVideoWrapper)localObject).nnx = true;
    ((MPExoVideoWrapper)localObject).nnt.XF();
    ((MPExoVideoWrapper)localObject).setKeepScreenOn(false);
    ((MPExoVideoWrapper)localObject).kuY = ((MPExoVideoWrapper)localObject).isPlaying();
    ((MPExoVideoWrapper)localObject).pause();
    ((MPExoVideoWrapper)localObject).kuL = false;
    AppMethodBeat.o(7174);
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(7180);
    bFO();
    bFb();
    super.onReset();
    AppMethodBeat.o(7180);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(7170);
    super.onResume();
    Object localObject = bFB();
    ad.i(MPVideoView.TAG, "onUIResume");
    if (((MPVideoView)localObject).knv)
    {
      ad.i(MPVideoView.TAG, "onUIResume, should skip ui resume");
      ((MPVideoView)localObject).knv = false;
      AppMethodBeat.o(7170);
      return;
    }
    localObject = ((MPVideoView)localObject).nog;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    ((MPExoVideoWrapper)localObject).nnx = false;
    ((MPExoVideoWrapper)localObject).kuL = true;
    if ((((MPExoVideoWrapper)localObject).nnr != null) && (((MPExoVideoWrapper)localObject).cng) && ((((MPExoVideoWrapper)localObject).kuY) || (((MPExoVideoWrapper)localObject).nnv)))
    {
      ad.i(MPExoVideoWrapper.TAG, "onUIResume, isPlayOnUiPause =" + ((MPExoVideoWrapper)localObject).kuY + ", mPlayingWhenBackground " + ((MPExoVideoWrapper)localObject).nnv);
      ((MPExoVideoWrapper)localObject).start();
    }
    AppMethodBeat.o(7170);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(7171);
    super.onStart();
    if (bEU().gKx == null)
    {
      finish();
      ad.w(this.TAG, "onStart msgInfo.item is null");
      AppMethodBeat.o(7171);
      return;
    }
    ad.i(this.TAG, "alvinluo onStart handleAnimation coverUrl: %s", new Object[] { bEU().gKx.gKD });
    bET().bringToFront();
    bFB().bGE();
    AppMethodBeat.o(7171);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void yq(int paramInt)
  {
    AppMethodBeat.i(175508);
    i locali = this.nji;
    d.g.a.a locala = (d.g.a.a)new w(this);
    d.g.b.k.h(locala, "onUpdateView");
    boolean bool;
    if ((locali.width <= 0) || (locali.height <= 0))
    {
      ad.w("MicroMsg.BizVideoPosHelper", "onWebViewScrollChanged invalid params x=" + locali.x + ", y=" + locali.y + ", width=" + locali.width + ", height=" + locali.height);
      bool = false;
    }
    while (!bool)
    {
      AppMethodBeat.o(175508);
      return;
      int i = locali.nlu;
      locali.nlu = (locali.y - paramInt);
      if (locali.nlu < i) {
        if (locali.nlu > 0) {
          locali.yy(locali.nlu);
        }
      }
      for (;;)
      {
        bool = true;
        break;
        if ((locali.nlq != 1) && (locali.nlm != locali.kvn))
        {
          ad.d("MicroMsg.BizVideoPosHelper", "onWebViewScrollChanged currentVideoWidth=" + locali.nlm + ", screenWidth=" + locali.kvn);
          locali.nlq = 1;
          locali.b(true, (d.g.a.a)new i.c(locala));
          bool = false;
          break;
        }
        locali.nlk = 0;
        bool = locali.yz(Math.abs(locali.nlu));
        break;
        if (locali.nlu <= i) {
          break label400;
        }
        if (locali.nlu < 0)
        {
          locali.nlk = 0;
          bool = locali.yz(Math.abs(locali.nlu));
          break;
        }
        if ((locali.nlq != 2) && (locali.nlm != locali.width))
        {
          locali.nlq = 2;
          locali.b(false, (d.g.a.a)new i.d(locala));
          bool = false;
          break;
        }
        locali.yy(locali.nlu);
      }
      label400:
      bool = false;
    }
    bFL();
    AppMethodBeat.o(175508);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<FrameLayout>
  {
    a(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class aa
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    aa(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ab
    extends d.g.b.l
    implements d.g.a.a<LinearLayout>
  {
    ab(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ac
    extends d.g.b.l
    implements d.g.a.a<MPVideoErrorView>
  {
    ac(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "invoke"})
  static final class ad
    extends d.g.b.l
    implements d.g.a.a<MPVideoView>
  {
    ad(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
  static final class ae
    extends d.g.b.l
    implements d.g.a.a<FrameLayout>
  {
    ae(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class af
    extends d.g.b.l
    implements d.g.a.a<MPVideoWifiTipsView>
  {
    af(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<ImageView>
  {
    b(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    c(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<FrameLayout>
  {
    d(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class e
    implements IPCRunCgi.a
  {
    e(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(7087);
      BizVideoDetailUI.k(this.njI).bFw();
      if (paramb == null)
      {
        AppMethodBeat.o(7087);
        return;
      }
      ad.i(BizVideoDetailUI.m(this.njI), "onSceneEnd errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString + ", type: " + paramb.getType());
      Object localObject = paramb.auL();
      if ((((localObject instanceof ey)) && (((ey)localObject).CyQ != BizVideoDetailUI.k(this.njI).niH)) || (((localObject instanceof ex)) && (((ex)localObject).CyQ != BizVideoDetailUI.k(this.njI).niH)))
      {
        AppMethodBeat.o(7087);
        return;
      }
      if (paramb.getType() == 1179)
      {
        this.njI.njp = true;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          BizVideoDetailUI.s(this.njI);
          paramString = paramb.auM();
          if (paramString == null)
          {
            paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgGetResp");
            AppMethodBeat.o(7087);
            throw paramString;
          }
          paramString = (ez)paramString;
          paramb = BizVideoDetailUI.m(this.njI);
          localObject = new StringBuilder("url_info size is ");
          LinkedList localLinkedList;
          if (paramString.Czz != null)
          {
            localLinkedList = paramString.Czz;
            if (localLinkedList == null) {
              d.g.b.k.fvU();
            }
          }
          for (paramInt1 = localLinkedList.size();; paramInt1 = 0)
          {
            ad.i(paramb, paramInt1);
            if ((paramString.CzA == 0) || (bt.isNullOrNil(paramString.CzB))) {
              break;
            }
            ad.i(BizVideoDetailUI.m(this.njI), "onSceneEnd redirect %s", new Object[] { paramString.CzB });
            paramb = this.njI;
            paramString = paramString.CzB;
            d.g.b.k.g(paramString, "resp.redirect_url");
            paramb.PX(paramString);
            AppMethodBeat.o(7087);
            return;
          }
          this.njI.a(paramString);
          AppMethodBeat.o(7087);
          return;
        }
        this.njI.a(null);
        BizVideoDetailUI.q(this.njI);
        paramb = BizVideoDetailUI.p(this.njI);
        paramb.njV.setBackgroundResource(2131231310);
        if (!bt.isNullOrNil(paramString)) {
          paramb.njU.setText((CharSequence)(paramb.getContext().getString(2131761343) + ' ' + paramString));
        }
        for (;;)
        {
          paramb.frN.setClickable(true);
          if (paramInt1 != 2) {
            break;
          }
          com.tencent.mm.plugin.webview.h.a.Tb(2);
          AppMethodBeat.o(7087);
          return;
          paramb.njU.setText((CharSequence)paramb.getContext().getString(2131761343));
        }
        com.tencent.mm.plugin.webview.h.a.Tb(3);
        AppMethodBeat.o(7087);
        return;
      }
      AppMethodBeat.o(7087);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "posInfo", "", "webvieId", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.m<String, Integer, d.y>
  {
    h(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "view", "Lcom/tencent/xweb/WebView;", "url", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.m<WebView, String, d.y>
  {
    i(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<FrameLayout>
  {
    j(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "onExitFullscreen", "", "plugin-brandservice_release"})
  public static final class k
    extends com.tencent.mm.plugin.brandservice.ui.widget.b
  {
    public final void Cx()
    {
      AppMethodBeat.i(7099);
      BizVideoDetailUI.a(this.njI, false);
      if (BizVideoDetailUI.f(this.njI).getParent() == null) {
        BizVideoDetailUI.e(this.njI).addView((View)BizVideoDetailUI.f(this.njI), 0);
      }
      AppMethodBeat.o(7099);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(175501);
      MPVideoWifiTipsView localMPVideoWifiTipsView = BizVideoDetailUI.i(this.njI);
      d.g.b.k.g(localMPVideoWifiTipsView, "videoWifiTipsView");
      localMPVideoWifiTipsView.setVisibility(8);
      AppMethodBeat.o(175501);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initComment$1$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "onHide", "", "onShow", "plugin-brandservice_release"})
  public static final class n
    implements n.c
  {
    n(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void onHide()
    {
      AppMethodBeat.i(7103);
      BizVideoDetailUI.a(this.njI, this.njI.nji.width, this.njI.nji.height);
      AppMethodBeat.o(7103);
    }
    
    public final void onShow()
    {
      AppMethodBeat.i(7104);
      this.njI.iA(false);
      AppMethodBeat.o(7104);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "enterFullScreen", "", "direction", "", "quitFullScreen", "plugin-brandservice_release"})
  public static final class o
    implements MPVideoView.b
  {
    public final void bah()
    {
      AppMethodBeat.i(7107);
      BizVideoDetailUI.a(this.njI, "exitFullScreen", "");
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
      localObject = BizVideoDetailUI.d(this.njI).Qc("18");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((em)localObject, "FullScreenSwitch", "2");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((em)localObject, BizVideoDetailUI.d(this.njI));
      com.tencent.mm.plugin.ball.f.f.bAp();
      BizVideoDetailUI.g(this.njI).aNT();
      this.njI.setRequestedOrientation(1);
      BizVideoDetailUI.k(this.njI).niP.ea(6, 0);
      localObject = BizVideoDetailUI.j(this.njI);
      d.g.b.k.g(localObject, "videoAdTitleBar");
      ((LinearLayout)localObject).setVisibility(8);
      BizVideoDetailUI.l(this.njI);
      AppMethodBeat.o(7107);
    }
    
    public final boolean isFullScreen()
    {
      AppMethodBeat.i(7105);
      boolean bool = BizVideoDetailUI.c(this.njI);
      AppMethodBeat.o(7105);
      return bool;
    }
    
    public final void rM(int paramInt)
    {
      AppMethodBeat.i(7106);
      BizVideoDetailUI.a(this.njI, "enterFullScreen", "");
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
      localObject = BizVideoDetailUI.d(this.njI).Qc("18");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((em)localObject, "FullScreenSwitch", "1");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((em)localObject, BizVideoDetailUI.d(this.njI));
      com.tencent.mm.plugin.ball.f.f.bAq();
      BizVideoDetailUI.e(this.njI).removeView((View)BizVideoDetailUI.f(this.njI));
      this.njI.nji.a(-16777216, BizVideoDetailUI.f(this.njI));
      BizVideoDetailUI.a(this.njI, true);
      BizVideoDetailUI.g(this.njI).O((View)BizVideoDetailUI.f(this.njI), paramInt);
      if ((paramInt == 0) || (paramInt == 180)) {
        BizVideoDetailUI.f(this.njI).setPageGestureInFullscreen(false);
      }
      for (;;)
      {
        localObject = BizVideoDetailUI.h(this.njI);
        if ((localObject == null) || (((FrameLayout)localObject).getVisibility() != 0))
        {
          localObject = BizVideoDetailUI.i(this.njI);
          d.g.b.k.g(localObject, "videoWifiTipsView");
          if (((MPVideoWifiTipsView)localObject).getVisibility() != 0) {}
        }
        else
        {
          localObject = BizVideoDetailUI.j(this.njI);
          d.g.b.k.g(localObject, "videoAdTitleBar");
          ((LinearLayout)localObject).setVisibility(0);
        }
        BizVideoDetailUI.k(this.njI).niP.ea(5, 0);
        BizVideoDetailUI.l(this.njI);
        AppMethodBeat.o(7106);
        return;
        BizVideoDetailUI.f(this.njI).setPageGestureInFullscreen(true);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$2", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "bufferResolutionStartTime", "", "getBufferResolutionStartTime", "()J", "setBufferResolutionStartTime", "(J)V", "bufferSeekStartTime", "getBufferSeekStartTime", "setBufferSeekStartTime", "hasBufferingResolution", "", "getHasBufferingResolution", "()Z", "setHasBufferingResolution", "(Z)V", "hasBufferingSeek", "getHasBufferingSeek", "setHasBufferingSeek", "playEnd", "getPlayEnd", "setPlayEnd", "startPlayTime", "getStartPlayTime", "setStartPlayTime", "startWaitTime", "getStartWaitTime", "setStartWaitTime", "onControlbarVisible", "", "visible", "onEndDragProgress", "onGetVideoSize", "width", "", "height", "onHideSwitchResolutionLayout", "onHideSwitchSpeedLayout", "onPlayError", "errorMsg", "", "errorCode", "onSeekPre", "onSeekTo", "time", "onStartDragProgress", "onUpdateProgress", "progressLen", "totalLen", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoPrepare", "firstRenderTime", "onVideoWaiting", "onVideoWaitingEnd", "resolutionBtnClick", "speedBtnClick", "switchResolution", "beforeType", "afterType", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "switchSpeed", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
  public static final class p
    implements MPVideoView.c
  {
    private long gSP = -1L;
    private long njL = -1L;
    private boolean njM;
    private long njN = -1L;
    private long njO = -1L;
    private boolean njP;
    private boolean njQ;
    
    public final void PZ(String paramString)
    {
      AppMethodBeat.i(7117);
      d.g.b.k.h(paramString, "errorMsg");
      BizVideoDetailUI.k(this.njI).niP.nlX = paramString;
      BizVideoDetailUI.k(this.njI).niP.ea(11, 0);
      BizVideoDetailUI.p(this.njI).setPlayError$505cff1c(paramString);
      BizVideoDetailUI.q(this.njI);
      BizVideoDetailUI.a(this.njI, "error", paramString);
      if (BizVideoDetailUI.f(this.njI).getPlayStarted()) {
        com.tencent.mm.plugin.webview.h.a.Tb(25);
      }
      for (;;)
      {
        BizVideoDetailUI.d(this.njI).Qd("21");
        BizVideoDetailUI.d(this.njI).Qd("22");
        Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
        localObject = BizVideoDetailUI.d(this.njI).Qc("16");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((em)localObject, "PlayErrReason", paramString);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((em)localObject, BizVideoDetailUI.d(this.njI));
        AppMethodBeat.o(7117);
        return;
        com.tencent.mm.plugin.webview.h.a.Tb(24);
      }
    }
    
    public final void a(int paramInt1, int paramInt2, fn paramfn)
    {
      Object localObject2 = null;
      AppMethodBeat.i(175503);
      this.njI.njq = true;
      BizVideoDetailUI.k(this.njI).niP.nmb = paramInt1;
      BizVideoDetailUI.k(this.njI).niP.nma = paramInt2;
      BizVideoDetailUI.k(this.njI).niP.ea(22, 0);
      BizVideoDetailUI.d(this.njI).Qd("21");
      BizVideoDetailUI.d(this.njI).Qd("22");
      Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
      em localem = BizVideoDetailUI.d(this.njI).Qc("4");
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localem, "DefinitionBefore", String.valueOf(paramInt1));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localem, "DefinitionAfter", String.valueOf(paramInt2));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localem, "WidthBefore", String.valueOf(BizVideoDetailUI.k(this.njI).niP.width));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localem, "HeightBefore", String.valueOf(BizVideoDetailUI.k(this.njI).niP.height));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
      if (paramfn != null) {}
      for (localObject1 = Integer.valueOf(paramfn.width);; localObject1 = null)
      {
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localem, "WidthAfter", String.valueOf(localObject1));
        localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
        localObject1 = localObject2;
        if (paramfn != null) {
          localObject1 = Integer.valueOf(paramfn.height);
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localem, "HeightAfter", String.valueOf(localObject1));
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localem, BizVideoDetailUI.d(this.njI));
        com.tencent.mm.plugin.webview.h.a.Tb(81);
        this.njO = System.currentTimeMillis();
        if (paramfn != null)
        {
          BizVideoDetailUI.k(this.njI).niE = paramfn.niE;
          BizVideoDetailUI.k(this.njI).niF = paramfn.CAo;
          BizVideoDetailUI.k(this.njI).niP.width = paramfn.width;
          BizVideoDetailUI.k(this.njI).niP.height = paramfn.height;
        }
        BizVideoDetailUI.a(this.njI, "switchVideo", "");
        AppMethodBeat.o(175503);
        return;
      }
    }
    
    public final void a(c.a parama1, c.a parama2)
    {
      AppMethodBeat.i(193349);
      BizVideoDetailUI.d(this.njI).Qd("21");
      BizVideoDetailUI.d(this.njI).Qd("22");
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
      em localem = BizVideoDetailUI.d(this.njI).Qc("19");
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
      if (parama1 != null)
      {
        localObject = String.valueOf(parama1.nod);
        parama1 = (c.a)localObject;
        if (localObject != null) {}
      }
      else
      {
        parama1 = "";
      }
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localem, "SpeedBefore", parama1);
      parama1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
      if (parama2 != null)
      {
        parama2 = String.valueOf(parama2.nod);
        parama1 = parama2;
        if (parama2 != null) {}
      }
      else
      {
        parama1 = "";
      }
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localem, "SpeedAfter", parama1);
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localem, BizVideoDetailUI.d(this.njI));
      AppMethodBeat.o(193349);
    }
    
    public final void bGe()
    {
      AppMethodBeat.i(175502);
      i locali = this.njI.nji;
      MPVideoView localMPVideoView = BizVideoDetailUI.f(this.njI);
      d.g.b.k.h(localMPVideoView, "videoVideo");
      locali.nlr = localMPVideoView;
      if (!localMPVideoView.bcg()) {
        locali.bGp();
      }
      AppMethodBeat.o(175502);
    }
    
    public final void bGf()
    {
      AppMethodBeat.i(7113);
      BizVideoDetailUI.k(this.njI).niP.ea(12, 0);
      this.njN = System.currentTimeMillis();
      BizVideoDetailUI.a(this.njI, "seekEnd", "");
      AppMethodBeat.o(7113);
    }
    
    public final void bGg()
    {
      AppMethodBeat.i(7114);
      BizVideoDetailUI.k(this.njI).niP.ea(13, 0);
      this.njN = System.currentTimeMillis();
      BizVideoDetailUI.a(this.njI, "seekEnd", "");
      AppMethodBeat.o(7114);
    }
    
    public final void bGh()
    {
      AppMethodBeat.i(7116);
      String str;
      if (this.njQ)
      {
        BizVideoDetailUI.k(this.njI).niP.eK((int)(System.currentTimeMillis() - this.njL), 31);
        str = "3";
      }
      for (;;)
      {
        Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
        localObject = BizVideoDetailUI.d(this.njI).Qc("17");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((em)localObject, "BufferReason", str);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((em)localObject, BizVideoDetailUI.d(this.njI), String.valueOf(System.currentTimeMillis() - 500L));
        this.njO = -1L;
        this.njN = -1L;
        this.njQ = false;
        this.njP = false;
        if (!BizVideoDetailUI.f(this.njI).isPlaying()) {
          break;
        }
        BizVideoDetailUI.a(this.njI, "play", "");
        AppMethodBeat.o(7116);
        return;
        if (this.njP)
        {
          BizVideoDetailUI.k(this.njI).niP.eK((int)(System.currentTimeMillis() - this.njL), 30);
          str = "2";
        }
        else
        {
          BizVideoDetailUI.k(this.njI).niP.eK((int)(System.currentTimeMillis() - this.njL), 29);
          str = "1";
        }
      }
      BizVideoDetailUI.a(this.njI, "pause", "");
      AppMethodBeat.o(7116);
    }
    
    public final void bGi()
    {
      AppMethodBeat.i(7119);
      BizVideoDetailUI.s(this.njI);
      this.njI.bGb();
      AppMethodBeat.o(7119);
    }
    
    public final void bGj()
    {
      AppMethodBeat.i(7121);
      BizVideoDetailUI.k(this.njI).niP.ea(21, 0);
      this.njI.njq = true;
      this.njI.bFQ();
      com.tencent.mm.plugin.webview.h.a.Tb(80);
      BizVideoDetailUI.a(this.njI, 0L);
      AppMethodBeat.o(7121);
    }
    
    public final void bGk()
    {
      boolean bool = true;
      AppMethodBeat.i(175504);
      this.njI.njq = false;
      BizVideoDetailUI localBizVideoDetailUI;
      if ((this.njI.njn) && (BizVideoDetailUI.f(this.njI).isPlaying()))
      {
        localBizVideoDetailUI = this.njI;
        if (BizVideoDetailUI.f(this.njI).getCurrPosSec() <= 1) {
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
    
    public final void bcp()
    {
      AppMethodBeat.i(193347);
      BizVideoDetailUI.a(this.njI, "seekBegin", "");
      BizVideoDetailUI.d(this.njI).Qd("21");
      BizVideoDetailUI.d(this.njI).Qd("22");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(BizVideoDetailUI.d(this.njI).Qc("20"), BizVideoDetailUI.d(this.njI));
      AppMethodBeat.o(193347);
    }
    
    public final void bcv()
    {
      AppMethodBeat.i(193348);
      BizVideoDetailUI.a(this.njI, "seekBegin", "");
      BizVideoDetailUI.d(this.njI).Qd("21");
      BizVideoDetailUI.d(this.njI).Qd("22");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(BizVideoDetailUI.d(this.njI).Qc("20"), BizVideoDetailUI.d(this.njI));
      AppMethodBeat.o(193348);
    }
    
    public final void iC(boolean paramBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(7118);
      BizVideoDetailUI.r(this.njI);
      if (paramBoolean)
      {
        BizVideoDetailUI.a(this.njI, 0L);
        AppMethodBeat.o(7118);
        return;
      }
      BizVideoDetailUI localBizVideoDetailUI;
      if (this.njI.njn)
      {
        localBizVideoDetailUI = this.njI;
        if (BizVideoDetailUI.f(this.njI).getCurrPosSec() <= 1) {
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
    
    public final void nI(long paramLong)
    {
      AppMethodBeat.i(177795);
      BizVideoDetailUI.k(this.njI).niP.ea(32, (int)paramLong);
      ad.v(BizVideoDetailUI.m(this.njI), "[KEY_TIME] onVideoPrepare firstRenderTime = ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(177795);
    }
    
    public final void onVideoEnded()
    {
      AppMethodBeat.i(7112);
      BizVideoDetailUI.k(this.njI).niP.ea(7, 0);
      BizVideoDetailUI.a(this.njI, "ended", "");
      this.njI.bFQ();
      BizVideoDetailUI.o(this.njI);
      if (!this.njM)
      {
        this.njM = true;
        com.tencent.mm.plugin.webview.h.a.Tb(27);
      }
      AppMethodBeat.o(7112);
    }
    
    public final void onVideoPause()
    {
      AppMethodBeat.i(7111);
      if (BizVideoDetailUI.f(this.njI).getPlayStatus() == 2) {
        BizVideoDetailUI.k(this.njI).niP.ea(8, 0);
      }
      BizVideoDetailUI.a(this.njI, "pause", "");
      BizVideoDetailUI.d(this.njI).Qd("21");
      BizVideoDetailUI.d(this.njI).Qc("22");
      AppMethodBeat.o(7111);
    }
    
    public final void onVideoPlay()
    {
      AppMethodBeat.i(7110);
      this.njI.njq = false;
      BizVideoDetailUI.k(this.njI);
      int i = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.yB(BizVideoDetailUI.f(this.njI).getPlayStatus());
      BizVideoDetailUI.k(this.njI).niP.ea(i, 0);
      BizVideoDetailUI.n(this.njI);
      BizVideoDetailUI.a(this.njI, "play", "");
      if (this.gSP < 0L)
      {
        com.tencent.mm.plugin.webview.h.a.Tb(6);
        if (this.njI.njo) {
          com.tencent.mm.plugin.webview.h.a.Tb(19);
        }
        this.gSP = System.currentTimeMillis();
      }
      Object localObject1;
      if ((this.njI.njn) && (!this.njI.njq) && ((!BizVideoDetailUI.f(this.njI).bGP()) || (!BizVideoDetailUI.f(this.njI).bcg())))
      {
        localObject1 = this.njI;
        if (BizVideoDetailUI.f(this.njI).getCurrPosSec() <= 1) {
          break label430;
        }
      }
      label430:
      for (boolean bool = true;; bool = false)
      {
        BizVideoDetailUI.b((BizVideoDetailUI)localObject1, bool);
        aq.n((Runnable)new a(this), 300L);
        localObject1 = this.njI.nji;
        Object localObject2 = (d.g.a.a)new b(this);
        d.g.b.k.h(localObject2, "onUpdateView");
        if ((((i)localObject1).nlo != 0) && (((i)localObject1).nlu <= 0) && (((i)localObject1).nlm == ((i)localObject1).kvn) && (((i)localObject1).nll <= ((i)localObject1).nlp) && (!((i)localObject1).bGo()))
        {
          Object localObject3 = ((i)localObject1).nlr;
          if ((localObject3 != null) && (((MPVideoView)localObject3).isPlaying() == true))
          {
            ((i)localObject1).nln = ((i)localObject1).bvW;
            localObject3 = ((i)localObject1).nlv;
            if (localObject3 != null) {
              ((ValueAnimator)localObject3).removeAllUpdateListeners();
            }
            ((i)localObject1).nlv = ValueAnimator.ofInt(new int[] { ((i)localObject1).nll, ((i)localObject1).nlo });
            localObject3 = ((i)localObject1).nlv;
            if (localObject3 != null) {
              ((ValueAnimator)localObject3).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new i.f((i)localObject1, (d.g.a.a)localObject2));
            }
            localObject2 = ((i)localObject1).nlv;
            if (localObject2 != null) {
              ((ValueAnimator)localObject2).setDuration(200L);
            }
            localObject1 = ((i)localObject1).nlv;
            if (localObject1 != null) {
              ((ValueAnimator)localObject1).start();
            }
          }
        }
        BizVideoDetailUI.d(this.njI).Qd("22");
        BizVideoDetailUI.d(this.njI).Qc("21");
        AppMethodBeat.o(7110);
        return;
      }
    }
    
    public final void onVideoWaiting()
    {
      AppMethodBeat.i(7115);
      if (this.gSP > 0L) {
        BizVideoDetailUI.n(this.njI);
      }
      this.njL = System.currentTimeMillis();
      BizVideoDetailUI.a(this.njI, "waiting", "");
      if ((this.njO != -1L) && ((int)(System.currentTimeMillis() - this.njO) < 1000L)) {
        this.njQ = true;
      }
      for (;;)
      {
        BizVideoDetailUI.d(this.njI).Qd("21");
        BizVideoDetailUI.d(this.njI).Qd("22");
        BizVideoDetailUI.d(this.njI).Qc("17");
        AppMethodBeat.o(7115);
        return;
        if ((this.njN != -1L) && ((int)(System.currentTimeMillis() - this.njN) < 1000L)) {
          this.njP = true;
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BizVideoDetailUI.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7108);
        BizVideoDetailUI.bGd();
        AppMethodBeat.o(7108);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<d.y>
    {
      b(BizVideoDetailUI.p paramp)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7122);
      BizVideoDetailUI.f(this.njI).p(false, 0);
      AppMethodBeat.o(7122);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "e", "Landroid/view/MotionEvent;", "onTouch"})
  static final class r
    implements View.OnTouchListener
  {
    r(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(7123);
      paramView = BizVideoDetailUI.f(this.njI);
      View localView = (View)this.njI.bEW();
      d.g.b.k.g(paramMotionEvent, "e");
      d.g.b.k.h(localView, "v");
      d.g.b.k.h(paramMotionEvent, "e");
      boolean bool;
      switch (paramMotionEvent.getAction())
      {
      default: 
        bool = paramView.not;
      }
      for (;;)
      {
        if (bool)
        {
          BizVideoDetailUI.f(this.njI).S(paramMotionEvent);
          if (paramMotionEvent.getAction() == 1) {
            paramMotionEvent.setAction(3);
          }
        }
        AppMethodBeat.o(7123);
        return false;
        if ((!paramView.nou) && (paramMotionEvent.getY() >= localView.getY()) && (paramMotionEvent.getY() <= localView.getY() + paramView.getHeight()) && (paramMotionEvent.getX() >= localView.getX()) && (paramMotionEvent.getX() <= localView.getX() + paramView.getWidth())) {
          paramView.not = true;
        }
        paramView.nou = true;
        break;
        bool = paramView.not;
        paramView.not = false;
        paramView.nou = false;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7124);
      if (BizVideoDetailUI.f(this.njI).isPlaying())
      {
        BizVideoDetailUI.f(this.njI).pause();
        paramView = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.nmf;
        m.a.yC(37);
        AppMethodBeat.o(7124);
        return;
      }
      BizVideoDetailUI.f(this.njI).start();
      paramView = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.nmf;
      m.a.yC(38);
      AppMethodBeat.o(7124);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$onShowAd$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
  public static final class u
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(7126);
      Object localObject = BizVideoDetailUI.h(this.njI);
      if (localObject != null)
      {
        localObject = ((FrameLayout)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      localObject = this.njI.AQP;
      if (localObject != null) {
        ((com.tencent.mm.plugin.webview.c.f)localObject).avT("appear");
      }
      localObject = this.njI.njj;
      if (localObject != null)
      {
        localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.webview.c.f)localObject).avT("appear");
          AppMethodBeat.o(7126);
          return;
        }
      }
      AppMethodBeat.o(7126);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$onShowDot$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
  public static final class v
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(7127);
      Object localObject = BizVideoDetailUI.u(this.njI);
      if (localObject != null)
      {
        localObject = ((FrameLayout)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      if (this.njI.njk != null)
      {
        ad.i(BizVideoDetailUI.m(this.njI), "onShowDot appear");
        localObject = this.njI.AQP;
        int i;
        MMWebViewWithJsApi localMMWebViewWithJsApi;
        if (localObject != null)
        {
          i = this.njI.bGa();
          localMMWebViewWithJsApi = this.njI.njk;
          if (localMMWebViewWithJsApi == null) {
            d.g.b.k.fvU();
          }
          ((com.tencent.mm.plugin.webview.c.f)localObject).M(i, localMMWebViewWithJsApi.hashCode(), "appear");
        }
        localObject = this.njI.njk;
        if (localObject != null)
        {
          localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
          if (localObject != null)
          {
            i = this.njI.bGa();
            localMMWebViewWithJsApi = this.njI.njk;
            if (localMMWebViewWithJsApi == null) {
              d.g.b.k.fvU();
            }
            ((com.tencent.mm.plugin.webview.c.f)localObject).M(i, localMMWebViewWithJsApi.hashCode(), "appear");
            AppMethodBeat.o(7127);
            return;
          }
        }
      }
      AppMethodBeat.o(7127);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class w
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    w(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$setTouchListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/LogoWebViewWrapper$MMOverScrollOffsetListener;", "onMMOverScrollOffset", "", "offset", "", "pointerDown", "", "onMMOverScrollUp", "plugin-brandservice_release"})
  public static final class x
    implements LogoWebViewWrapper.b
  {
    public final void S(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(7129);
      Object localObject1 = this.njI.bEW();
      Object localObject2 = this.njI.bEW().getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(7129);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      ((FrameLayout.LayoutParams)localObject2).topMargin = (this.njI.nji.y - paramInt);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = BizVideoDetailUI.t(this.njI);
      d.g.b.k.g(localObject1, "animationLayout");
      if (((View)localObject1).getVisibility() == 0)
      {
        localObject1 = BizVideoDetailUI.t(this.njI);
        d.g.b.k.g(localObject1, "animationLayout");
        localObject2 = BizVideoDetailUI.t(this.njI);
        d.g.b.k.g(localObject2, "animationLayout");
        localObject2 = ((View)localObject2).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new d.v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(7129);
          throw ((Throwable)localObject1);
        }
        localObject2 = (FrameLayout.LayoutParams)localObject2;
        ((FrameLayout.LayoutParams)localObject2).topMargin = (this.njI.nji.y - paramInt);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      AppMethodBeat.o(7129);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class z
    implements ValueAnimator.AnimatorUpdateListener
  {
    z(BizVideoDetailUI paramBizVideoDetailUI, v.c paramc) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(7133);
      if (BizVideoDetailUI.u(this.njI) != null)
      {
        localFrameLayout = BizVideoDetailUI.u(this.njI);
        if (localFrameLayout == null) {
          d.g.b.k.fvU();
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
      FrameLayout localFrameLayout = BizVideoDetailUI.u(this.njI);
      if (localFrameLayout != null)
      {
        paramValueAnimator = BizVideoDetailUI.u(this.njI);
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
      if (i == this.njT.Jhu) {
        BizVideoDetailUI.l(this.njI);
      }
      AppMethodBeat.o(7133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI
 * JD-Core Version:    0.7.0.1
 */