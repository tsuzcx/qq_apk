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
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.mm.ag.v;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.s;
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
import com.tencent.mm.protocal.protobuf.eb;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.protocal.protobuf.fs;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.z;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.aa;
import kotlin.g.b.y;
import kotlin.g.b.z.d;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/preload/api/IBizVideoPage;", "()V", "TAG", "", "adView", "Landroid/widget/FrameLayout;", "getAdView", "()Landroid/widget/FrameLayout;", "adView$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "adWebView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "getAdWebView", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "setAdWebView", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;)V", "adWebViewReady", "", "getAdWebViewReady", "()Z", "setAdWebViewReady", "(Z)V", "animationIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAnimationIv", "()Landroid/widget/ImageView;", "animationIv$delegate", "animationLayout", "Landroid/view/View;", "getAnimationLayout", "()Landroid/view/View;", "animationLayout$delegate", "appMsgGetResp", "Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;", "getAppMsgGetResp", "()Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;", "setAppMsgGetResp", "(Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;)V", "appmsgDone", "getAppmsgDone", "setAppmsgDone", "backgroundContainerView", "getBackgroundContainerView", "backgroundContainerView$delegate", "bizVideoDotHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotHelper;", "bizVideoPosHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "getBizVideoPosHelper", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "setBizVideoPosHelper", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;)V", "bizVideoProfiler", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "cgiCallback", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "commentUrl", "currentDot", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "density", "", "getDensity", "()F", "setDensity", "(F)V", "dotView", "getDotView", "dotView$delegate", "dotWebView", "getDotWebView", "setDotWebView", "dotWebViewReady", "getDotWebViewReady", "setDotWebViewReady", "fullscreenImpl", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenImpl;", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "getAppMsgDone", "getGetAppMsgDone", "setGetAppMsgDone", "hideWifiTipsBarAnim", "Landroid/view/animation/Animation;", "insertVideoDone", "getInsertVideoDone", "setInsertVideoDone", "isInFullScreen", "isNetworkConnected", "needShowWifiTipsView", "getNeedShowWifiTipsView", "setNeedShowWifiTipsView", "networkListener", "Landroid/content/BroadcastReceiver;", "orientationHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper;", "playState", "getPlayState", "()Ljava/lang/String;", "setPlayState", "(Ljava/lang/String;)V", "setFullScreen", "showWifiTipsBarAnim", "showWifiTipsMode", "simcardTpye", "", "switchVideo", "getSwitchVideo", "setSwitchVideo", "switchingResolution", "getSwitchingResolution", "setSwitchingResolution", "titleBarHeight", "uin", "videoAdTitleBack", "getVideoAdTitleBack", "videoAdTitleBack$delegate", "videoAdTitleBar", "Landroid/widget/LinearLayout;", "getVideoAdTitleBar", "()Landroid/widget/LinearLayout;", "videoAdTitleBar$delegate", "videoControlBarHeight", "videoErrView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "getVideoErrView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "videoErrView$delegate", "videoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoView", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "videoView$delegate", "videoViewContainer", "getVideoViewContainer", "videoViewContainer$delegate", "videoWifiTipsView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "getVideoWifiTipsView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "videoWifiTipsView$delegate", "waitToDetroyTime", "", "adWebviewReady", "", "bundle", "Landroid/os/Bundle;", "checkInitOrientationHelper", "w", "h", "closeAdWebview", "closeDotWebview", "createAdWebview", "createDotWebview", "id", "url", "destroyDotWebView", "destroyWebView", "doOnDestroy", "doPlayVideo", "resp", "dotWebviewReady", "enableMinimize", "enableOrientationListener", "enable", "getCurrentDotId", "getCurrentPlayTime", "getForceOrientation", "getFullscreenImpl", "getLastPlayTimeKey", "getMPVideoState", "getMarginValue", "value", "", "fullValue", "getSimCardType", "goneVideoErrorView", "hideCoverLayout", "hideDotWebview", "hideVideoTitleBar", "hideWifiTipsView", "delay", "init", "initActionBar", "initComment", "initControlAreaHeight", "initDensity", "wv", "Lcom/tencent/mm/ui/widget/MMWebView;", "initOrientationHelper", "initReportParams", "initVideoParam", "initVideoView", "initView", "initWebviewSetting", "webview", "insertVideoNativeView", "params", "", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAppMsgGet", "onBackPressed", "onDestroy", "onDestroyReport", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onMPVideoStateChange", "state", "errMsg", "onPageFinished", "view", "Lcom/tencent/xweb/WebView;", "onPageReady", "onPause", "onReset", "onResetAfterCreate", "onResetBeforeCreate", "onResume", "onShowAd", "onShowDot", "onStart", "onWebViewScrollChanged", "scrollY", "opPlayer", "postBinded", "sendMPPageData", "setDotScriptData", "setTouchListener", "shouldShowWifiTips", "duration", "netChange", "showCoverLayout", "showVideoErrorView", "showWifiTipsView", "startMonitorNetWorkChange", "stopMonitorNetWorkChange", "updateDot", "updateDotAttr", "posInfo", "webviewId", "updateDotPos", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotPosInfo;", "updateDotPosIfNeed", "updateVideoPosition", "plugin-brandservice_release"})
public class BizVideoDetailUI
  extends TmplShareWebViewToolUI
  implements com.tencent.mm.plugin.webview.h.a.a
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private float density;
  private String fQR;
  private boolean kGg;
  private final IPCRunCgi.a lma;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHG;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHH;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHI;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHJ;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHK;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHL;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHM;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHN;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHO;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHP;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHQ;
  private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h pHR;
  private com.tencent.mm.plugin.brandservice.ui.widget.a pHS;
  private int pHT;
  i pHU;
  MMWebViewWithJsApi pHV;
  MMWebViewWithJsApi pHW;
  private boolean pHX;
  private boolean pHY;
  boolean pHZ;
  boolean pIa;
  boolean pIb;
  boolean pIc;
  private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c pId;
  private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b pIe;
  private boolean pIf;
  private final j.a pIg;
  private String pIh;
  private boolean pIi;
  private boolean pIj;
  private ft pIk;
  private Animation pIl;
  private Animation pIm;
  private com.tencent.mm.plugin.brandservice.ui.widget.b pIn;
  private long pIo;
  private int pIp;
  private int pIq;
  private BroadcastReceiver pIr;
  private boolean pIs;
  private boolean pIt;
  private int uin;
  
  static
  {
    AppMethodBeat.i(7140);
    cLI = new kotlin.l.k[] { (kotlin.l.k)aa.a(new y(aa.bp(BizVideoDetailUI.class), "animationIv", "getAnimationIv()Landroid/widget/ImageView;")), (kotlin.l.k)aa.a(new y(aa.bp(BizVideoDetailUI.class), "animationLayout", "getAnimationLayout()Landroid/view/View;")), (kotlin.l.k)aa.a(new y(aa.bp(BizVideoDetailUI.class), "videoView", "getVideoView()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;")), (kotlin.l.k)aa.a(new y(aa.bp(BizVideoDetailUI.class), "adView", "getAdView()Landroid/widget/FrameLayout;")), (kotlin.l.k)aa.a(new y(aa.bp(BizVideoDetailUI.class), "dotView", "getDotView()Landroid/widget/FrameLayout;")), (kotlin.l.k)aa.a(new y(aa.bp(BizVideoDetailUI.class), "backgroundContainerView", "getBackgroundContainerView()Landroid/widget/FrameLayout;")), (kotlin.l.k)aa.a(new y(aa.bp(BizVideoDetailUI.class), "videoErrView", "getVideoErrView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;")), (kotlin.l.k)aa.a(new y(aa.bp(BizVideoDetailUI.class), "videoWifiTipsView", "getVideoWifiTipsView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;")), (kotlin.l.k)aa.a(new y(aa.bp(BizVideoDetailUI.class), "videoAdTitleBar", "getVideoAdTitleBar()Landroid/widget/LinearLayout;")), (kotlin.l.k)aa.a(new y(aa.bp(BizVideoDetailUI.class), "videoAdTitleBack", "getVideoAdTitleBack()Landroid/view/View;")), (kotlin.l.k)aa.a(new y(aa.bp(BizVideoDetailUI.class), "videoViewContainer", "getVideoViewContainer()Landroid/widget/FrameLayout;")) };
    AppMethodBeat.o(7140);
  }
  
  public BizVideoDetailUI()
  {
    AppMethodBeat.i(7216);
    this.TAG = "MicroMsg.BizVideoDetailUI";
    this.pHG = s.a(this.pGZ, (kotlin.g.a.a)new BizVideoDetailUI.b(this));
    this.pHH = s.a(this.pGZ, (kotlin.g.a.a)new BizVideoDetailUI.c(this));
    this.pHI = s.a(this.pGZ, (kotlin.g.a.a)new BizVideoDetailUI.ad(this));
    this.pHJ = s.a(this.pGZ, (kotlin.g.a.a)new BizVideoDetailUI.a(this));
    this.pHK = s.a(this.pGZ, (kotlin.g.a.a)new BizVideoDetailUI.j(this));
    this.pHL = s.a(this.pGZ, (kotlin.g.a.a)new BizVideoDetailUI.d(this));
    this.pHM = s.a(this.pGZ, (kotlin.g.a.a)new BizVideoDetailUI.ac(this));
    this.pHN = s.a(this.pGZ, (kotlin.g.a.a)new BizVideoDetailUI.af(this));
    this.pHO = s.a(this.pGZ, (kotlin.g.a.a)new BizVideoDetailUI.ab(this));
    this.pHP = s.a(this.pGZ, (kotlin.g.a.a)new BizVideoDetailUI.aa(this));
    this.pHQ = s.a(this.pGZ, (kotlin.g.a.a)new BizVideoDetailUI.ae(this));
    this.pHU = new i();
    this.pIe = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b();
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
    this.pIg = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.aiP(toString());
    this.pIh = "";
    this.fQR = "";
    this.pIn = ((com.tencent.mm.plugin.brandservice.ui.widget.b)new BizVideoDetailUI.k(this));
    this.pIp = -1;
    this.pIq = -1;
    this.lma = ((IPCRunCgi.a)new e(this));
    this.pIs = true;
    AppMethodBeat.o(7216);
  }
  
  private final void BK(long paramLong)
  {
    AppMethodBeat.i(175516);
    Object localObject = cqe();
    kotlin.g.b.p.g(localObject, "videoWifiTipsView");
    if (((MPVideoWifiTipsView)localObject).getVisibility() != 8)
    {
      if (paramLong > 0L)
      {
        if (this.pIm == null)
        {
          this.pIm = AnimationUtils.loadAnimation((Context)getContext(), 2130772133);
          localObject = this.pIm;
          if (localObject != null) {
            ((Animation)localObject).setDuration(paramLong);
          }
        }
        cqe().clearAnimation();
        cqe().startAnimation(this.pIm);
      }
      MMHandlerThread.postToMainThreadDelayed((Runnable)new l(this), paramLong);
    }
    AppMethodBeat.o(175516);
  }
  
  private final boolean Z(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(175519);
    if ((BuildInfo.DEBUG) && (this.pIt))
    {
      AppMethodBeat.o(175519);
      return true;
    }
    if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(175519);
      return false;
    }
    if (cpZ().getPlayStatus() == 4)
    {
      Log.i(this.TAG, "not show WifiTips, play end!");
      AppMethodBeat.o(175519);
      return false;
    }
    if ((paramInt > 0) && (cpZ().getCacheTimeSec() >= paramInt))
    {
      Log.i(this.TAG, "not show WifiTips, video cached! " + cpZ().getCacheTimeSec() + '/' + cpZ().getDuration());
      AppMethodBeat.o(175519);
      return false;
    }
    if (this.pGx.pHt)
    {
      Log.i(this.TAG, "not show WifiTips, has show!");
      AppMethodBeat.o(175519);
      return false;
    }
    if (paramBoolean)
    {
      localObject = MPVideoWifiTipsView.pJW;
      if (!MPVideoWifiTipsView.a.DM(this.pGx.pHs))
      {
        AppMethodBeat.o(175519);
        return false;
      }
    }
    else
    {
      localObject = MPVideoWifiTipsView.pJW;
      if (!MPVideoWifiTipsView.a.DK(this.pGx.pHs))
      {
        localObject = MPVideoWifiTipsView.pJW;
        if (!MPVideoWifiTipsView.a.DL(this.pGx.pHs))
        {
          AppMethodBeat.o(175519);
          return false;
        }
      }
    }
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.pLy;
    if (!com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.A(NetStatusUtil.isWifi(MMApplicationContext.getContext()), this.pHT))
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
    Object localObject = this.pId;
    if (localObject == null) {
      kotlin.g.b.p.hyc();
    }
    if (!((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).pKs.htU)
    {
      AppMethodBeat.o(7204);
      return;
    }
    cqw();
    FrameLayout localFrameLayout = cqb();
    if (localFrameLayout != null)
    {
      localObject = cqb();
      if (localObject != null) {}
      for (localObject = ((FrameLayout)localObject).getLayoutParams(); localObject == null; localObject = null)
      {
        paramd = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
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
      if (this.kGg)
      {
        i = com.tencent.mm.cb.a.jn((Context)getContext());
        if (!this.kGg) {
          break label485;
        }
        j = com.tencent.mm.cb.a.jo((Context)getContext());
        k = j - this.pIq - this.pIp;
        j = k;
        if (!this.kGg)
        {
          if (cpZ().crD()) {
            break label496;
          }
          localc = this.pId;
          if (localc == null) {
            kotlin.g.b.p.hyc();
          }
          localc.pKo = false;
          j = k + this.pIp;
        }
        label237:
        k = a(paramd.pKz, j);
        if (k < this.pIp)
        {
          localc = this.pId;
          if (localc == null) {
            kotlin.g.b.p.hyc();
          }
          localc.pKp = true;
        }
        ((RelativeLayout.LayoutParams)localObject).leftMargin = a(paramd.pKw, i);
        ((RelativeLayout.LayoutParams)localObject).topMargin = (a(paramd.pKx, j) + this.pIq);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = a(paramd.pKy, i);
        localc = this.pId;
        if (localc == null) {
          kotlin.g.b.p.hyc();
        }
        if ((!localc.pKo) && (!this.kGg)) {
          break label522;
        }
        i = this.pIp;
        label358:
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = (i + k);
        if (!paramd.pKC) {
          break label527;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
        label382:
        if (!paramd.pKE) {
          break label537;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
        label397:
        if (!paramd.pKD) {
          break label547;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        label412:
        if (!paramd.pKF) {
          break label557;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        label427:
        if (!paramd.pKA) {
          break label567;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
        label442:
        if (!paramd.pKB) {
          break label577;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
      }
      for (;;)
      {
        localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(7204);
        return;
        i = this.pHU.pKS;
        break;
        label485:
        j = this.pHU.pKR;
        break label176;
        label496:
        localc = this.pId;
        if (localc == null) {
          kotlin.g.b.p.hyc();
        }
        localc.pKo = true;
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
        localz.hsT();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.setDatabasePath(com.tencent.mm.loader.j.b.aKA() + "databases/");
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.hsW();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.hsU();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.hsS();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.hsR();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      paramMMWebViewWithJsApi.setOnLongClickListener((View.OnLongClickListener)BizVideoDetailUI.t.pIE);
      AppMethodBeat.o(7196);
      return;
    }
    AppMethodBeat.o(7196);
  }
  
  private boolean aK(int paramInt, String paramString)
  {
    AppMethodBeat.i(7202);
    kotlin.g.b.p.h(paramString, "url");
    if (isFinishing())
    {
      AppMethodBeat.o(7202);
      return false;
    }
    if (this.pHW != null)
    {
      Log.w(this.TAG, "createDotWebview dotWebView existed!");
      AppMethodBeat.o(7202);
      return false;
    }
    com.tencent.mm.plugin.webview.i.a.agn(57);
    this.pHY = false;
    Object localObject = a.pHf;
    localObject = MMWebViewWithJsApi.a.hY((Context)getContext());
    kotlin.g.b.p.g(localObject, "MMWebViewWithJsApi.Factory.create(this.context)");
    this.pHW = a.a((MMWebViewWithJsApi)localObject, cpv(), (kotlin.g.a.m)new BizVideoDetailUI.h(this), (kotlin.g.a.m)new i(this), aXI(cpu().ajO()));
    d((MMWebView)this.pHW);
    a(this.pHW);
    localObject = cqb();
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = cqc();
    if (localObject != null) {
      ((FrameLayout)localObject).addView((View)this.pHW);
    }
    cqw();
    int i = this.pHU.height;
    int j = this.pIp;
    int k = this.pIq;
    paramString = UrlExKt.appendUrlParam(paramString, "dotId", String.valueOf(paramInt));
    localObject = this.pHW;
    if (localObject == null) {
      kotlin.g.b.p.hyc();
    }
    paramString = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(paramString, "dotWebviewId", String.valueOf(((MMWebViewWithJsApi)localObject).hashCode())), "dotMinShowHeight", String.valueOf(i - j - k));
    Log.i(this.TAG, "createDotWebview dotView dotUrl=".concat(String.valueOf(paramString)));
    localObject = this.pHW;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).loadUrl(paramString);
    }
    paramString = this.pHW;
    if (paramString != null) {
      paramString.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(7202);
    return true;
  }
  
  private final void b(ft paramft)
  {
    int j = 0;
    AppMethodBeat.i(175514);
    if (paramft == null)
    {
      AppMethodBeat.o(175514);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.brandservice.ui.widget.c.pNP;
    com.tencent.mm.plugin.brandservice.ui.widget.c.crz();
    this.pIk = paramft;
    Log.i(this.TAG, "doPlayVideo getAppMsgDone: " + this.pIi + ", insertVideoDone: " + this.pIj);
    if ((!this.pIi) || (!this.pIj))
    {
      AppMethodBeat.o(175514);
      return;
    }
    localObject1 = this.pGx.pHC;
    Object localObject2 = paramft.KJu;
    kotlin.g.b.p.g(localObject2, "resp.url_info");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject1).L((LinkedList)localObject2);
    com.tencent.mm.plugin.webview.i.a.agn(23);
    localObject1 = paramft.KJu;
    kotlin.g.b.p.g(localObject1, "resp.url_info");
    localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.k.K((LinkedList)localObject1);
    if (localObject1 == null)
    {
      AppMethodBeat.o(175514);
      return;
    }
    this.pGx.pHC.pLG = ((gh)localObject1).KKg;
    this.pGx.pHr = ((gh)localObject1).pHr;
    this.pGx.pHs = ((gh)localObject1).KKi;
    Log.i(this.TAG, "doPlayVideo filesize=" + this.pGx.pHr + " wifiTipsFlag=" + this.pGx.pHs);
    boolean bool;
    int i;
    if ((paramft.KJy & 0x1) != 0)
    {
      bool = true;
      if ((gff() == null) || (!gff().eqW())) {
        break label725;
      }
      localObject2 = gff();
      kotlin.g.b.p.g(localObject2, "webMultiTaskHelper");
      i = ((com.tencent.mm.plugin.webview.ui.tools.multitask.a)localObject2).ghY();
      label295:
      cpZ().setInitialTime(i * 1000);
      localObject2 = paramft.KJG;
      if (localObject2 != null)
      {
        cpZ().a(((eb)localObject2).bDU, ((eb)localObject2).bDY, ((eb)localObject2).KHY, ((eb)localObject2).KHZ, ((eb)localObject2).mCp, ((eb)localObject2).mCq);
        Log.i(this.TAG, "maxInitBitrate = " + ((eb)localObject2).bDU + ", bandFraction = " + ((eb)localObject2).bDY + ", minDur = " + ((eb)localObject2).KHY + ", maxDur = " + ((eb)localObject2).KHZ + ", minBuffer = " + ((eb)localObject2).mCp + ", maxBuffer = " + ((eb)localObject2).mCq);
      }
      this.pHZ = false;
      if (!Z(((gh)localObject1).KKd / 1000, false)) {
        break label744;
      }
      if (!bool) {
        break label736;
      }
      kp(false);
    }
    for (;;)
    {
      cpZ().setAutoPlay(bool);
      if (!bool) {
        cqq();
      }
      this.pGx.pHC.width = ((gh)localObject1).width;
      this.pGx.pHC.height = ((gh)localObject1).height;
      localObject2 = cpZ();
      String str = ((gh)localObject1).url;
      kotlin.g.b.p.g(str, "urlInfo.url");
      ((MPVideoView)localObject2).cN(str, ((gh)localObject1).KKd / 1000);
      localObject2 = cpZ();
      i = j;
      if (((gh)localObject1).width > ((gh)localObject1).height) {
        i = 90;
      }
      ((MPVideoView)localObject2).setFullScreenDirection(i);
      fe(((gh)localObject1).width, ((gh)localObject1).height);
      if ((((gh)localObject1).width > 0) && (((gh)localObject1).height > 0) && (cpu().iAi.videoWidth <= 0) && (cpu().iAi.videoHeight <= 0))
      {
        cpu().iAi.videoWidth = ((gh)localObject1).width;
        cpu().iAi.videoHeight = ((gh)localObject1).height;
      }
      localObject2 = cpZ();
      paramft = paramft.KJu;
      kotlin.g.b.p.g(paramft, "resp.url_info");
      ((MPVideoView)localObject2).a(paramft, (gh)localObject1);
      AppMethodBeat.o(175514);
      return;
      bool = false;
      break;
      label725:
      i = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.aiT(cqp());
      break label295;
      label736:
      this.pHZ = true;
      continue;
      label744:
      BK(0L);
    }
  }
  
  private final View cpY()
  {
    AppMethodBeat.i(7143);
    View localView = (View)this.pHH.a(cLI[1]);
    AppMethodBeat.o(7143);
    return localView;
  }
  
  private final MPVideoView cpZ()
  {
    AppMethodBeat.i(7145);
    MPVideoView localMPVideoView = (MPVideoView)this.pHI.a(cLI[2]);
    AppMethodBeat.o(7145);
    return localMPVideoView;
  }
  
  private final void cqA()
  {
    AppMethodBeat.i(175518);
    if (this.pIr != null)
    {
      getContext().unregisterReceiver(this.pIr);
      this.pIr = null;
    }
    AppMethodBeat.o(175518);
  }
  
  private final FrameLayout cqa()
  {
    AppMethodBeat.i(7146);
    FrameLayout localFrameLayout = (FrameLayout)this.pHJ.a(cLI[3]);
    AppMethodBeat.o(7146);
    return localFrameLayout;
  }
  
  private final FrameLayout cqb()
  {
    AppMethodBeat.i(7147);
    FrameLayout localFrameLayout = (FrameLayout)this.pHK.a(cLI[4]);
    AppMethodBeat.o(7147);
    return localFrameLayout;
  }
  
  private final FrameLayout cqc()
  {
    AppMethodBeat.i(7148);
    FrameLayout localFrameLayout = (FrameLayout)this.pHL.a(cLI[5]);
    AppMethodBeat.o(7148);
    return localFrameLayout;
  }
  
  private final MPVideoErrorView cqd()
  {
    AppMethodBeat.i(7149);
    MPVideoErrorView localMPVideoErrorView = (MPVideoErrorView)this.pHM.a(cLI[6]);
    AppMethodBeat.o(7149);
    return localMPVideoErrorView;
  }
  
  private final MPVideoWifiTipsView cqe()
  {
    AppMethodBeat.i(7150);
    MPVideoWifiTipsView localMPVideoWifiTipsView = (MPVideoWifiTipsView)this.pHN.a(cLI[7]);
    AppMethodBeat.o(7150);
    return localMPVideoWifiTipsView;
  }
  
  private final LinearLayout cqf()
  {
    AppMethodBeat.i(7151);
    LinearLayout localLinearLayout = (LinearLayout)this.pHO.a(cLI[8]);
    AppMethodBeat.o(7151);
    return localLinearLayout;
  }
  
  private final FrameLayout cqg()
  {
    AppMethodBeat.i(7152);
    FrameLayout localFrameLayout = (FrameLayout)this.pHQ.a(cLI[10]);
    AppMethodBeat.o(7152);
    return localFrameLayout;
  }
  
  private final int cqi()
  {
    AppMethodBeat.i(175507);
    if (this.mHh == null)
    {
      i = this.pHT;
      AppMethodBeat.o(175507);
      return i;
    }
    try
    {
      Bundle localBundle = this.mHh.j(110, new Bundle());
      if (localBundle != null) {
        this.pHT = localBundle.getInt("sim_card_type", 0);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w(this.TAG, "invoker ex :" + localException.getMessage());
      }
    }
    int i = this.pHT;
    AppMethodBeat.o(175507);
    return i;
  }
  
  private final void cqj()
  {
    AppMethodBeat.i(175509);
    View localView = cpY();
    kotlin.g.b.p.g(localView, "animationLayout");
    if (localView.getVisibility() == 0)
    {
      localView = cpY();
      kotlin.g.b.p.g(localView, "animationLayout");
      dy(localView);
    }
    dy((View)cpw());
    cqu();
    AppMethodBeat.o(175509);
  }
  
  private void cqm()
  {
    AppMethodBeat.i(195892);
    if (cpZ().isPlaying()) {
      cpZ().crA();
    }
    fm("leavePage", "");
    this.pIg.report();
    this.pGx.pHC.pLB = cpZ().getEndPlayTime();
    if (this.pGz != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.nqe;
      this.nqe = (l1 - this.pGA + l2);
      this.pGx.pHC.pLC = ((int)(this.nqe / 1000L));
    }
    this.pGx.pHC.pLA = ((int)cpZ().getRealPlayTime());
    this.pGx.pHC.er(2, 0);
    if (!this.pIb)
    {
      com.tencent.mm.plugin.webview.i.a.agn(22);
      AppMethodBeat.o(195892);
      return;
    }
    if ((cpZ().getPlayStart()) && (!cpZ().getPlayStarted())) {
      com.tencent.mm.plugin.webview.i.a.agn(26);
    }
    AppMethodBeat.o(195892);
  }
  
  private void cqn()
  {
    AppMethodBeat.i(7183);
    if (this.pHV == null)
    {
      AppMethodBeat.o(7183);
      return;
    }
    Object localObject = this.IBw;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.d.h)localObject).aYd("disappear");
    }
    localObject = this.IBw;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.d.h)localObject).aYd("destroy");
    }
    localObject = cqa();
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = cqa();
    if (localObject != null) {
      ((FrameLayout)localObject).removeView((View)this.pHV);
    }
    localObject = this.pHV;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getCurWebviewClient();
      if (!(localObject instanceof com.tencent.mm.plugin.webview.ui.tools.widget.k)) {
        break label162;
      }
      localObject = this.pHV;
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
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewClient");
      AppMethodBeat.o(7183);
      throw ((Throwable)localObject);
      localObject = null;
      break;
    }
    label155:
    ((com.tencent.mm.plugin.webview.ui.tools.widget.k)localObject).cleanup();
    label162:
    localObject = this.pHV;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).destroy();
    }
    localObject = this.pHV;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebChromeClient(null);
    }
    localObject = this.pHV;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebViewClient(null);
    }
    localObject = this.pHV;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnTouchListener(null);
    }
    localObject = this.pHV;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnLongClickListener(null);
    }
    localObject = this.pHV;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setVisibility(8);
    }
    localObject = this.pHV;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).removeAllViews();
    }
    localObject = this.pHV;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).clearView();
    }
    this.pHV = null;
    this.pHX = false;
    cqt();
    AppMethodBeat.o(7183);
  }
  
  private final String cqp()
  {
    AppMethodBeat.i(7188);
    String str = cpu().ajO() + '_' + this.uin + '_' + this.pGx.vid;
    AppMethodBeat.o(7188);
    return str;
  }
  
  private final void cqq()
  {
    AppMethodBeat.i(175515);
    View localView = cpY();
    kotlin.g.b.p.g(localView, "animationLayout");
    localView.setVisibility(8);
    AppMethodBeat.o(175515);
  }
  
  private final void cqr()
  {
    AppMethodBeat.i(7189);
    MPVideoErrorView localMPVideoErrorView = cqd();
    kotlin.g.b.p.g(localMPVideoErrorView, "videoErrView");
    if (localMPVideoErrorView.getVisibility() == 0)
    {
      localMPVideoErrorView = cqd();
      kotlin.g.b.p.g(localMPVideoErrorView, "videoErrView");
      localMPVideoErrorView.setVisibility(8);
      fe(this.pHU.width, this.pHU.height);
    }
    AppMethodBeat.o(7189);
  }
  
  private final void cqs()
  {
    AppMethodBeat.i(7190);
    MPVideoErrorView localMPVideoErrorView = cqd();
    kotlin.g.b.p.g(localMPVideoErrorView, "videoErrView");
    localMPVideoErrorView.setVisibility(0);
    ko(false);
    AppMethodBeat.o(7190);
  }
  
  private final void cqt()
  {
    AppMethodBeat.i(7193);
    Object localObject = cqa();
    if (localObject != null)
    {
      if (((FrameLayout)localObject).getVisibility() == 8)
      {
        localObject = cqe();
        kotlin.g.b.p.g(localObject, "videoWifiTipsView");
        if (((MPVideoWifiTipsView)localObject).getVisibility() == 8)
        {
          localObject = cqf();
          kotlin.g.b.p.g(localObject, "videoAdTitleBar");
          ((LinearLayout)localObject).setVisibility(8);
        }
      }
      AppMethodBeat.o(7193);
      return;
    }
    AppMethodBeat.o(7193);
  }
  
  private final void cqu()
  {
    AppMethodBeat.i(7203);
    if (this.pId != null)
    {
      Object localObject = cqb();
      if (localObject == null) {
        break label56;
      }
      if (((FrameLayout)localObject).getVisibility() == 0)
      {
        localObject = this.pId;
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        a(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).pKs);
      }
    }
    AppMethodBeat.o(7203);
    return;
    label56:
    AppMethodBeat.o(7203);
  }
  
  private final void cqv()
  {
    AppMethodBeat.i(7205);
    Object localObject1;
    if ((cqb() != null) && (this.pId != null))
    {
      localObject1 = this.pId;
      if (localObject1 == null) {
        kotlin.g.b.p.hyc();
      }
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject1).pKp) {}
    }
    else
    {
      AppMethodBeat.o(7205);
      return;
    }
    Log.i(this.TAG, "updateDotPosIfNeed");
    int i;
    Object localObject2;
    if (!this.kGg)
    {
      localObject1 = cqb();
      if (localObject1 != null) {}
      for (localObject1 = ((FrameLayout)localObject1).getLayoutParams(); localObject1 == null; localObject1 = null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(7205);
        throw ((Throwable)localObject1);
      }
      i = ((RelativeLayout.LayoutParams)localObject1).bottomMargin;
      localObject1 = new z.d();
      ((z.d)localObject1).SYE = i;
      if (!cpZ().crD()) {
        break label228;
      }
      localObject2 = this.pId;
      if (localObject2 == null) {
        kotlin.g.b.p.hyc();
      }
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).pKo) {
        break label228;
      }
    }
    for (((z.d)localObject1).SYE += this.pIp;; ((z.d)localObject1).SYE -= this.pIp)
    {
      localObject2 = ValueAnimator.ofInt(new int[] { i, ((z.d)localObject1).SYE });
      ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new z(this, (z.d)localObject1));
      kotlin.g.b.p.g(localObject2, "va");
      ((ValueAnimator)localObject2).setDuration(200L);
      ((ValueAnimator)localObject2).start();
      AppMethodBeat.o(7205);
      return;
      label228:
      if (cpZ().crD()) {
        break;
      }
      localObject2 = this.pId;
      if (localObject2 == null) {
        kotlin.g.b.p.hyc();
      }
      if (!((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).pKo) {
        break;
      }
    }
    AppMethodBeat.o(7205);
  }
  
  private final void cqw()
  {
    AppMethodBeat.i(7206);
    if (this.pIp < 0)
    {
      this.pIp = com.tencent.mm.cb.a.aG((Context)getContext(), 2131166705);
      this.pIq = au.eu((Context)getContext());
    }
    AppMethodBeat.o(7206);
  }
  
  private final void cqx()
  {
    AppMethodBeat.i(7207);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onShowDot ready: ").append(this.pHY).append(", hasWebView: ");
    if (this.pHW != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject, bool);
      if ((this.pHY) && (this.pHW != null)) {
        break;
      }
      AppMethodBeat.o(7207);
      return;
    }
    com.tencent.mm.plugin.webview.i.a.agn(60);
    localObject = cqb();
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = cqc();
    if (localObject != null) {
      ((FrameLayout)localObject).removeView((View)this.pHW);
    }
    localObject = cqb();
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = cqb();
    if (localObject != null) {
      ((FrameLayout)localObject).addView((View)this.pHW);
    }
    localObject = cqb();
    if (localObject != null)
    {
      localObject = ((FrameLayout)localObject).getViewTreeObserver();
      if (localObject != null) {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new v(this));
      }
    }
    localObject = this.pId;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).pKn = true;
    }
    localObject = this.pId;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).pKq = true;
    }
    cqv();
    AppMethodBeat.o(7207);
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
  
  private final void dy(View paramView)
  {
    AppMethodBeat.i(175510);
    this.pHU.dy(paramView);
    AppMethodBeat.o(175510);
  }
  
  private final void fe(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7167);
    if (paramInt1 > paramInt2)
    {
      Object localObject1;
      if (this.pHR != null)
      {
        localObject1 = this.pHR;
        if (localObject1 != null)
        {
          Object localObject2 = getContext();
          kotlin.g.b.p.g(localObject2, "context");
          localObject2 = (Context)localObject2;
          MPVideoView localMPVideoView = cpZ();
          kotlin.g.b.p.h(localObject2, "ctx");
          kotlin.g.b.p.h(localMPVideoView, "video");
          ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h)localObject1).lAM = new WeakReference(localObject2);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h)localObject1).pKJ = new WeakReference(localMPVideoView);
        }
      }
      for (;;)
      {
        ko(true);
        AppMethodBeat.o(7167);
        return;
        localObject1 = getContext();
        kotlin.g.b.p.g(localObject1, "context");
        this.pHR = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h((Context)localObject1, cpZ());
      }
    }
    ko(false);
    AppMethodBeat.o(7167);
  }
  
  private final void fm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195893);
    if (Util.isEqual(this.pIh, paramString1))
    {
      AppMethodBeat.o(195893);
      return;
    }
    Log.d(this.TAG, "onMPVideoStateChange ".concat(String.valueOf(paramString1)));
    Object localObject = this.IBw;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.d.h)localObject).j(paramString1, this.pGx.vid, paramString2, String.valueOf(cpZ().getCurrPosSec()), String.valueOf(cpZ().getRealPlayTime() / 1000L));
    }
    localObject = this.pHV;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
      if (localObject != null) {
        ((com.tencent.mm.plugin.webview.d.h)localObject).j(paramString1, this.pGx.vid, paramString2, String.valueOf(cpZ().getCurrPosSec()), String.valueOf(cpZ().getRealPlayTime() / 1000L));
      }
    }
    this.pIh = paramString1;
    AppMethodBeat.o(195893);
  }
  
  private final void kp(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(7191);
    if (!Z(cpZ().getDuration(), paramBoolean))
    {
      Log.i(this.TAG, "showWifiTipsView should not show now");
      AppMethodBeat.o(7191);
      return;
    }
    Log.i(this.TAG, "showWifiTipsView ".concat(String.valueOf(paramBoolean)));
    com.tencent.mm.plugin.webview.i.a.agn(16);
    Object localObject;
    int i;
    if (!paramBoolean)
    {
      localObject = MPVideoWifiTipsView.pJW;
      if (MPVideoWifiTipsView.a.DL(this.pGx.pHs))
      {
        i = 2;
        this.pGx.pHC.pLI = i;
        this.pGx.pHC.er(14, 0);
        localObject = this.pGx;
        if (!paramBoolean) {
          break label264;
        }
      }
    }
    for (;;)
    {
      ((b)localObject).DJ(j);
      this.pGx.pHt = true;
      this.pHZ = false;
      cqe().n(this.pGx.pHr, i);
      if (this.pIl == null)
      {
        this.pIl = AnimationUtils.loadAnimation((Context)getContext(), 2130772129);
        localObject = this.pIl;
        if (localObject != null) {
          ((Animation)localObject).setDuration(300L);
        }
      }
      cqe().clearAnimation();
      cqe().startAnimation(this.pIl);
      localObject = cqe();
      kotlin.g.b.p.g(localObject, "videoWifiTipsView");
      ((MPVideoWifiTipsView)localObject).setVisibility(0);
      MMHandlerThread.postToMainThreadDelayed((Runnable)new y(this), 3000L);
      AppMethodBeat.o(7191);
      return;
      i = 1;
      break;
      label264:
      j = 1;
    }
  }
  
  public final void DG(int paramInt)
  {
    AppMethodBeat.i(175508);
    i locali = this.pHU;
    kotlin.g.a.a locala = (kotlin.g.a.a)new BizVideoDetailUI.w(this);
    kotlin.g.b.p.h(locala, "onUpdateView");
    boolean bool;
    if ((locali.width <= 0) || (locali.height <= 0))
    {
      Log.w("MicroMsg.BizVideoPosHelper", "onWebViewScrollChanged invalid params x=" + locali.x + ", y=" + locali.y + ", width=" + locali.width + ", height=" + locali.height);
      bool = false;
    }
    while (!bool)
    {
      AppMethodBeat.o(175508);
      return;
      int i = locali.pLa;
      locali.pLa = (locali.y - paramInt);
      if (locali.pLa < i) {
        if (locali.pLa > 0) {
          locali.DN(locali.pLa);
        }
      }
      for (;;)
      {
        bool = true;
        break;
        if ((locali.pKW != 1) && (locali.pKS != locali.mEX))
        {
          Log.d("MicroMsg.BizVideoPosHelper", "onWebViewScrollChanged currentVideoWidth=" + locali.pKS + ", screenWidth=" + locali.mEX);
          locali.pKW = 1;
          locali.b(true, (kotlin.g.a.a)new i.c(locala));
          bool = false;
          break;
        }
        bool = locali.DO(Math.abs(locali.pLa));
        break;
        if (locali.pLa <= i) {
          break label388;
        }
        if (locali.pLa < 0)
        {
          bool = locali.DO(Math.abs(locali.pLa));
          break;
        }
        if ((locali.pKW != 2) && (locali.pKS != locali.width))
        {
          locali.pKW = 2;
          locali.b(false, (kotlin.g.a.a)new i.d(locala));
          bool = false;
          break;
        }
        locali.DN(locali.pLa);
      }
      label388:
      bool = false;
    }
    cqj();
    AppMethodBeat.o(175508);
  }
  
  public final void Y(Bundle paramBundle)
  {
    AppMethodBeat.i(7172);
    if (this.kGg) {
      cpZ().p(false, 0);
    }
    this.pIg.aiS("21");
    this.pIg.aiS("22");
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.pIg.aiR("3"), this.pIg);
    cqn();
    cqo();
    ko(false);
    super.Y(paramBundle);
    com.tencent.mm.plugin.webview.i.a.agn(18);
    this.pIa = true;
    AppMethodBeat.o(7172);
  }
  
  public final boolean Z(Bundle paramBundle)
  {
    AppMethodBeat.i(7195);
    if (isFinishing())
    {
      AppMethodBeat.o(7195);
      return false;
    }
    if ((paramBundle == null) || (!paramBundle.containsKey("adUrl")))
    {
      Log.w(this.TAG, "createAdWebview url not found");
      AppMethodBeat.o(7195);
      return false;
    }
    if (this.pHV != null)
    {
      Log.w(this.TAG, "createAdWebview adWebView existed!");
      AppMethodBeat.o(7195);
      return false;
    }
    com.tencent.mm.plugin.webview.i.a.agn(28);
    paramBundle = paramBundle.getString("adUrl");
    Log.i(this.TAG, "createAdWebview adWebView url=".concat(String.valueOf(paramBundle)));
    this.pHX = false;
    Object localObject = a.pHf;
    localObject = MMWebViewWithJsApi.a.hY((Context)getContext());
    kotlin.g.b.p.g(localObject, "MMWebViewWithJsApi.Factory.create(this.context)");
    this.pHV = a.a((MMWebViewWithJsApi)localObject, cpv(), (kotlin.g.a.m)BizVideoDetailUI.f.pIv, (kotlin.g.a.m)BizVideoDetailUI.g.pIw, aXI(cpu().ajO()));
    a(this.pHV);
    localObject = this.pHV;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).loadUrl(paramBundle);
    }
    paramBundle = cqa();
    if (paramBundle != null) {
      paramBundle.removeAllViews();
    }
    paramBundle = cqc();
    if (paramBundle != null) {
      paramBundle.addView((View)this.pHV);
    }
    paramBundle = this.pHV;
    if (paramBundle != null) {
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(7195);
    return true;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(195896);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(195896);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(195895);
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
    AppMethodBeat.o(195895);
    return localView1;
  }
  
  /* Error */
  public final void a(ft paramft)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 7
    //   8: sipush 7187
    //   11: invokestatic 354	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_1
    //   15: ifnonnull +48 -> 63
    //   18: getstatic 503	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:pLk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   21: astore_1
    //   22: aload_0
    //   23: getfield 512	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:pIg	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   26: ldc_w 1833
    //   29: invokevirtual 1764	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:aiR	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/ff;
    //   32: astore_1
    //   33: getstatic 503	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:pLk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   36: astore 5
    //   38: aload_1
    //   39: ldc_w 1835
    //   42: ldc_w 1837
    //   45: invokestatic 1840	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/ff;Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload_1
    //   49: aload_0
    //   50: getfield 512	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:pIg	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   53: invokestatic 1767	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/ff;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;)V
    //   56: sipush 7187
    //   59: invokestatic 410	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: return
    //   63: aload_1
    //   64: getfield 1843	com/tencent/mm/protocal/protobuf/ft:KJz	I
    //   67: istore 4
    //   69: aload_0
    //   70: getfield 647	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:pGx	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   73: astore 8
    //   75: aload 8
    //   77: iload 4
    //   79: putfield 1846	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:iwg	I
    //   82: aload 8
    //   84: invokevirtual 1849	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:cpW	()Z
    //   87: ifeq +51 -> 138
    //   90: aload 8
    //   92: getfield 1853	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:pHv	Lcom/tencent/mm/ag/x;
    //   95: astore 5
    //   97: aload 5
    //   99: ifnonnull +9 -> 108
    //   102: ldc_w 1855
    //   105: invokestatic 1858	kotlin/g/b/p:btv	(Ljava/lang/String;)V
    //   108: aload 8
    //   110: getfield 1853	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:pHv	Lcom/tencent/mm/ag/x;
    //   113: astore 8
    //   115: aload 8
    //   117: ifnonnull +9 -> 126
    //   120: ldc_w 1855
    //   123: invokestatic 1858	kotlin/g/b/p:btv	(Ljava/lang/String;)V
    //   126: aload 5
    //   128: aload 8
    //   130: getfield 1859	com/tencent/mm/ag/x:iwg	I
    //   133: iconst_1
    //   134: ior
    //   135: putfield 1859	com/tencent/mm/ag/x:iwg	I
    //   138: aload_0
    //   139: getfield 1863	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:pGy	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/p;
    //   142: invokevirtual 1868	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/p:ani	()V
    //   145: aload_0
    //   146: getfield 1869	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:IBw	Lcom/tencent/mm/plugin/webview/d/h;
    //   149: astore 5
    //   151: aload 5
    //   153: ifnull +18 -> 171
    //   156: iload 4
    //   158: iconst_m1
    //   159: if_icmpne +291 -> 450
    //   162: aload 5
    //   164: ldc_w 1871
    //   167: iload_3
    //   168: invokevirtual 1874	com/tencent/mm/plugin/webview/d/h:gi	(Ljava/lang/String;I)V
    //   171: aload_1
    //   172: getfield 1878	com/tencent/mm/protocal/protobuf/ft:KJD	Lcom/tencent/mm/protocal/protobuf/cmb;
    //   175: ifnull +24 -> 199
    //   178: aload_0
    //   179: getfield 647	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:pGx	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   182: invokevirtual 1849	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:cpW	()Z
    //   185: ifeq +14 -> 199
    //   188: aload_0
    //   189: getfield 647	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:pGx	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   192: aload_1
    //   193: getfield 1878	com/tencent/mm/protocal/protobuf/ft:KJD	Lcom/tencent/mm/protocal/protobuf/cmb;
    //   196: putfield 1881	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:pHB	Lcom/tencent/mm/protocal/protobuf/cmb;
    //   199: aload_0
    //   200: getfield 647	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:pGx	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   203: aload_1
    //   204: getfield 1882	com/tencent/mm/protocal/protobuf/ft:vid	Ljava/lang/String;
    //   207: putfield 1455	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:vid	Ljava/lang/String;
    //   210: aload_0
    //   211: getfield 512	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:pIg	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   214: astore 9
    //   216: aload_1
    //   217: getfield 1882	com/tencent/mm/protocal/protobuf/ft:vid	Ljava/lang/String;
    //   220: astore 8
    //   222: aload 8
    //   224: astore 5
    //   226: aload 8
    //   228: ifnonnull +8 -> 236
    //   231: ldc_w 513
    //   234: astore 5
    //   236: aload 9
    //   238: aload 5
    //   240: putfield 1885	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:pLq	Ljava/lang/String;
    //   243: aload_0
    //   244: getfield 512	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:pIg	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   247: aload_0
    //   248: invokevirtual 1888	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:getScene	()I
    //   251: invokestatic 1059	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   254: putfield 1891	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:pLr	Ljava/lang/String;
    //   257: aload_0
    //   258: getfield 512	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:pIg	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   261: aload_0
    //   262: invokevirtual 1894	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:getSubScene	()I
    //   265: invokestatic 1059	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   268: putfield 1897	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:pLs	Ljava/lang/String;
    //   271: aload_1
    //   272: getfield 1900	com/tencent/mm/protocal/protobuf/ft:KJC	Ljava/lang/String;
    //   275: astore 5
    //   277: aload 5
    //   279: ifnull +12 -> 291
    //   282: aload_0
    //   283: getfield 647	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:pGx	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   286: aload 5
    //   288: putfield 1903	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:pHp	Ljava/lang/String;
    //   291: aload_0
    //   292: getfield 647	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:pGx	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   295: aload_1
    //   296: getfield 1904	com/tencent/mm/protocal/protobuf/ft:url	Ljava/lang/String;
    //   299: invokevirtual 1907	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:aiF	(Ljava/lang/String;)V
    //   302: aload_1
    //   303: getfield 1904	com/tencent/mm/protocal/protobuf/ft:url	Ljava/lang/String;
    //   306: astore 5
    //   308: aload 5
    //   310: ifnull +9 -> 319
    //   313: aload_0
    //   314: aload 5
    //   316: putfield 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:fQR	Ljava/lang/String;
    //   319: aload_1
    //   320: getfield 1911	com/tencent/mm/protocal/protobuf/ft:KJB	Lcom/tencent/mm/protocal/protobuf/eqw;
    //   323: ifnull +200 -> 523
    //   326: aload_1
    //   327: getfield 1911	com/tencent/mm/protocal/protobuf/ft:KJB	Lcom/tencent/mm/protocal/protobuf/eqw;
    //   330: getfield 1916	com/tencent/mm/protocal/protobuf/eqw:dOK	I
    //   333: ifeq +190 -> 523
    //   336: aload_0
    //   337: getfield 417	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:TAG	Ljava/lang/String;
    //   340: new 628	java/lang/StringBuilder
    //   343: dup
    //   344: ldc_w 1918
    //   347: invokespecial 632	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   350: aload_1
    //   351: getfield 1911	com/tencent/mm/protocal/protobuf/ft:KJB	Lcom/tencent/mm/protocal/protobuf/eqw;
    //   354: getfield 1921	com/tencent/mm/protocal/protobuf/eqw:dOL	Ljava/lang/String;
    //   357: invokevirtual 948	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: ldc_w 1923
    //   363: invokevirtual 948	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_1
    //   367: getfield 1911	com/tencent/mm/protocal/protobuf/ft:KJB	Lcom/tencent/mm/protocal/protobuf/eqw;
    //   370: getfield 1916	com/tencent/mm/protocal/protobuf/eqw:dOK	I
    //   373: invokevirtual 636	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: invokevirtual 643	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 623	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   382: aload_0
    //   383: invokespecial 1460	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:cqd	()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;
    //   386: aload_1
    //   387: getfield 1911	com/tencent/mm/protocal/protobuf/ft:KJB	Lcom/tencent/mm/protocal/protobuf/eqw;
    //   390: getfield 1921	com/tencent/mm/protocal/protobuf/eqw:dOL	Ljava/lang/String;
    //   393: invokevirtual 1926	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView:setPlayError$505cff1c	(Ljava/lang/String;)V
    //   396: aload_0
    //   397: invokespecial 1671	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:cqs	()V
    //   400: bipush 32
    //   402: invokestatic 992	com/tencent/mm/plugin/webview/i/a:agn	(I)V
    //   405: getstatic 503	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:pLk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   408: astore_1
    //   409: aload_0
    //   410: getfield 512	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:pIg	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   413: ldc_w 1833
    //   416: invokevirtual 1764	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:aiR	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/ff;
    //   419: astore_1
    //   420: getstatic 503	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:pLk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   423: astore 5
    //   425: aload_1
    //   426: ldc_w 1835
    //   429: ldc_w 1837
    //   432: invokestatic 1840	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/ff;Ljava/lang/String;Ljava/lang/String;)V
    //   435: aload_1
    //   436: aload_0
    //   437: getfield 512	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:pIg	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   440: invokestatic 1767	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/ff;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;)V
    //   443: sipush 7187
    //   446: invokestatic 410	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   472: ifeq +795 -> 1267
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
    //   489: getfield 1927	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:TAG	Ljava/lang/String;
    //   492: ldc_w 1929
    //   495: iconst_1
    //   496: anewarray 843	java/lang/Object
    //   499: dup
    //   500: iconst_0
    //   501: iload_3
    //   502: invokestatic 1658	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   505: aastore
    //   506: invokestatic 1665	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   509: goto -347 -> 162
    //   512: iconst_0
    //   513: istore_2
    //   514: goto -54 -> 460
    //   517: iconst_0
    //   518: istore 4
    //   520: goto -49 -> 471
    //   523: aload_0
    //   524: invokespecial 1675	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:cqr	()V
    //   527: aload_1
    //   528: getfield 1932	com/tencent/mm/protocal/protobuf/ft:KJH	Ljava/util/LinkedList;
    //   531: astore 5
    //   533: aload 5
    //   535: ifnull +383 -> 918
    //   538: aload 5
    //   540: checkcast 1934	java/lang/Iterable
    //   543: astore 5
    //   545: new 1936	java/util/ArrayList
    //   548: dup
    //   549: aload 5
    //   551: bipush 10
    //   553: invokestatic 1941	kotlin/a/j:a	(Ljava/lang/Iterable;I)I
    //   556: invokespecial 1943	java/util/ArrayList:<init>	(I)V
    //   559: checkcast 1945	java/util/Collection
    //   562: astore 8
    //   564: aload 5
    //   566: invokeinterface 1949 1 0
    //   571: astore 10
    //   573: aload 10
    //   575: invokeinterface 1954 1 0
    //   580: ifeq +338 -> 918
    //   583: aload 10
    //   585: invokeinterface 1958 1 0
    //   590: checkcast 1960	com/tencent/mm/protocal/protobuf/ckn
    //   593: astore 9
    //   595: getstatic 1966	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:pKk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/a;
    //   598: astore 5
    //   600: aload 9
    //   602: getfield 1967	com/tencent/mm/protocal/protobuf/ckn:url	Ljava/lang/String;
    //   605: astore 5
    //   607: aload 9
    //   609: getfield 1970	com/tencent/mm/protocal/protobuf/ckn:MpY	Ljava/lang/String;
    //   612: astore 11
    //   614: aload 5
    //   616: invokestatic 739	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   619: ifne +11 -> 630
    //   622: aload 11
    //   624: invokestatic 739	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   627: ifeq +26 -> 653
    //   630: getstatic 1971	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:TAG	Ljava/lang/String;
    //   633: ldc_w 1973
    //   636: invokestatic 1975	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: aload 8
    //   641: getstatic 1981	kotlin/x:SXb	Lkotlin/x;
    //   644: invokeinterface 1985 2 0
    //   649: pop
    //   650: goto -77 -> 573
    //   653: invokestatic 1988	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:cqV	()Z
    //   656: ifne +15 -> 671
    //   659: getstatic 1971	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:TAG	Ljava/lang/String;
    //   662: ldc_w 1990
    //   665: invokestatic 1975	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   668: goto -29 -> 639
    //   671: new 628	java/lang/StringBuilder
    //   674: dup
    //   675: invokespecial 940	java/lang/StringBuilder:<init>	()V
    //   678: getstatic 1994	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:pKj	Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;
    //   681: invokevirtual 1999	com/tencent/mm/sdk/platformtools/MMFileSlotManager:getSlot	()Ljava/lang/Object;
    //   684: checkcast 2001	com/tencent/mm/vfs/o
    //   687: invokevirtual 2004	com/tencent/mm/vfs/o:getPath	()Ljava/lang/String;
    //   690: invokevirtual 948	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: bipush 47
    //   695: invokevirtual 639	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   698: astore 9
    //   700: aload 5
    //   702: invokestatic 2010	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   705: astore 5
    //   707: aload 5
    //   709: ldc_w 2012
    //   712: invokestatic 547	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   715: new 2001	com/tencent/mm/vfs/o
    //   718: dup
    //   719: aload 9
    //   721: aload 5
    //   723: invokevirtual 2015	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   726: invokevirtual 948	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: invokevirtual 643	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: invokespecial 2016	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   735: astore 5
    //   737: aload 5
    //   739: invokevirtual 2019	com/tencent/mm/vfs/o:exists	()Z
    //   742: ifne +37 -> 779
    //   745: aload 5
    //   747: invokevirtual 2022	com/tencent/mm/vfs/o:getParent	()Ljava/lang/String;
    //   750: astore 9
    //   752: aload 9
    //   754: ifnonnull +6 -> 760
    //   757: invokestatic 716	kotlin/g/b/p:hyc	()V
    //   760: new 2001	com/tencent/mm/vfs/o
    //   763: dup
    //   764: aload 9
    //   766: invokespecial 2016	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   769: invokevirtual 2025	com/tencent/mm/vfs/o:mkdirs	()Z
    //   772: pop
    //   773: aload 5
    //   775: invokevirtual 2028	com/tencent/mm/vfs/o:createNewFile	()Z
    //   778: pop
    //   779: aload 5
    //   781: invokestatic 2034	com/tencent/mm/vfs/s:ap	(Lcom/tencent/mm/vfs/o;)Ljava/io/OutputStream;
    //   784: checkcast 2036	java/io/Closeable
    //   787: astore 9
    //   789: aload 9
    //   791: checkcast 2038	java/io/OutputStream
    //   794: astore 12
    //   796: aload 11
    //   798: ifnull +114 -> 912
    //   801: getstatic 2044	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   804: astore 5
    //   806: aload 11
    //   808: ifnonnull +49 -> 857
    //   811: new 870	kotlin/t
    //   814: dup
    //   815: ldc_w 2046
    //   818: invokespecial 873	kotlin/t:<init>	(Ljava/lang/String;)V
    //   821: astore_1
    //   822: sipush 7187
    //   825: invokestatic 410	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   828: aload_1
    //   829: athrow
    //   830: astore 5
    //   832: sipush 7187
    //   835: invokestatic 410	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   838: aload 5
    //   840: athrow
    //   841: astore_1
    //   842: aload 9
    //   844: aload 5
    //   846: invokestatic 2051	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   849: sipush 7187
    //   852: invokestatic 410	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   855: aload_1
    //   856: athrow
    //   857: aload 11
    //   859: aload 5
    //   861: invokevirtual 2055	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   864: astore 5
    //   866: aload 5
    //   868: ldc_w 2057
    //   871: invokestatic 547	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   874: aload 12
    //   876: aload 5
    //   878: invokevirtual 2061	java/io/OutputStream:write	([B)V
    //   881: getstatic 1971	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:TAG	Ljava/lang/String;
    //   884: ldc_w 2063
    //   887: aload 11
    //   889: invokestatic 729	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   892: invokevirtual 733	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   895: invokestatic 1975	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   898: getstatic 1981	kotlin/x:SXb	Lkotlin/x;
    //   901: astore 5
    //   903: aload 9
    //   905: aconst_null
    //   906: invokestatic 2051	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   909: goto -270 -> 639
    //   912: aconst_null
    //   913: astore 5
    //   915: goto -41 -> 874
    //   918: aload_1
    //   919: getfield 1121	com/tencent/mm/protocal/protobuf/ft:KJu	Ljava/util/LinkedList;
    //   922: checkcast 2065	java/util/List
    //   925: invokestatic 2068	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   928: ifeq +24 -> 952
    //   931: aload_0
    //   932: getfield 417	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:TAG	Ljava/lang/String;
    //   935: ldc_w 2070
    //   938: invokestatic 987	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   941: iconst_4
    //   942: invokestatic 992	com/tencent/mm/plugin/webview/i/a:agn	(I)V
    //   945: sipush 7187
    //   948: invokestatic 410	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   951: return
    //   952: aload_0
    //   953: invokespecial 611	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:cpZ	()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;
    //   956: astore 9
    //   958: aload_0
    //   959: invokevirtual 1021	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:cpu	()Lcom/tencent/mm/ag/x;
    //   962: astore 8
    //   964: aload_1
    //   965: getfield 2073	com/tencent/mm/protocal/protobuf/ft:KJI	Ljava/lang/String;
    //   968: astore 7
    //   970: aload 7
    //   972: astore 5
    //   974: aload 7
    //   976: ifnonnull +8 -> 984
    //   979: ldc_w 513
    //   982: astore 5
    //   984: aload 8
    //   986: ldc_w 1855
    //   989: invokestatic 744	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   992: aload 5
    //   994: ldc_w 2075
    //   997: invokestatic 744	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1000: aload 9
    //   1002: getfield 2079	com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView:pOa	Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar;
    //   1005: astore 7
    //   1007: aload 7
    //   1009: ifnonnull +6 -> 1015
    //   1012: invokestatic 716	kotlin/g/b/p:hyc	()V
    //   1015: aload 7
    //   1017: aload 8
    //   1019: getfield 2082	com/tencent/mm/ag/x:iAg	Ljava/lang/String;
    //   1022: aload 8
    //   1024: invokevirtual 1026	com/tencent/mm/ag/x:ajO	()Ljava/lang/String;
    //   1027: aload 5
    //   1029: invokevirtual 2088	com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar:T	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1032: aload_0
    //   1033: iconst_1
    //   1034: putfield 1104	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:pIi	Z
    //   1037: aload_1
    //   1038: getfield 1121	com/tencent/mm/protocal/protobuf/ft:KJu	Ljava/util/LinkedList;
    //   1041: astore 5
    //   1043: aload 5
    //   1045: ldc_w 1123
    //   1048: invokestatic 547	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1051: aload 5
    //   1053: invokestatic 1135	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/k:K	(Ljava/util/LinkedList;)Lcom/tencent/mm/protocal/protobuf/gh;
    //   1056: astore 8
    //   1058: getstatic 503	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:pLk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1061: astore 5
    //   1063: aload_0
    //   1064: getfield 512	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:pIg	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   1067: ldc_w 1833
    //   1070: invokevirtual 1764	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:aiR	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/ff;
    //   1073: astore 7
    //   1075: getstatic 503	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:pLk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1078: astore 5
    //   1080: aload 7
    //   1082: ldc_w 2090
    //   1085: ldc_w 2092
    //   1088: invokestatic 1840	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/ff;Ljava/lang/String;Ljava/lang/String;)V
    //   1091: getstatic 503	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:pLk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1094: astore 5
    //   1096: aload 7
    //   1098: ldc_w 2094
    //   1101: ldc_w 2092
    //   1104: invokestatic 1840	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/ff;Ljava/lang/String;Ljava/lang/String;)V
    //   1107: getstatic 503	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:pLk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1110: astore 5
    //   1112: aload 8
    //   1114: ifnull +133 -> 1247
    //   1117: aload 8
    //   1119: getfield 1140	com/tencent/mm/protocal/protobuf/gh:KKg	I
    //   1122: invokestatic 1658	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1125: astore 5
    //   1127: aload 7
    //   1129: ldc_w 2096
    //   1132: aload 5
    //   1134: invokestatic 729	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1137: invokestatic 1840	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/ff;Ljava/lang/String;Ljava/lang/String;)V
    //   1140: getstatic 503	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:pLk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1143: astore 5
    //   1145: aload 8
    //   1147: ifnull +106 -> 1253
    //   1150: aload 8
    //   1152: getfield 1233	com/tencent/mm/protocal/protobuf/gh:width	I
    //   1155: invokestatic 1658	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1158: astore 5
    //   1160: aload 7
    //   1162: ldc_w 2098
    //   1165: aload 5
    //   1167: invokestatic 729	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1170: invokestatic 1840	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/ff;Ljava/lang/String;Ljava/lang/String;)V
    //   1173: getstatic 503	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:pLk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1176: astore 5
    //   1178: aload 6
    //   1180: astore 5
    //   1182: aload 8
    //   1184: ifnull +13 -> 1197
    //   1187: aload 8
    //   1189: getfield 1235	com/tencent/mm/protocal/protobuf/gh:height	I
    //   1192: invokestatic 1658	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1195: astore 5
    //   1197: aload 7
    //   1199: ldc_w 2100
    //   1202: aload 5
    //   1204: invokestatic 729	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1207: invokestatic 1840	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/ff;Ljava/lang/String;Ljava/lang/String;)V
    //   1210: getstatic 503	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:pLk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1213: astore 5
    //   1215: aload 7
    //   1217: ldc_w 1835
    //   1220: ldc_w 2092
    //   1223: invokestatic 1840	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/ff;Ljava/lang/String;Ljava/lang/String;)V
    //   1226: aload 7
    //   1228: aload_0
    //   1229: getfield 512	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:pIg	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   1232: invokestatic 1767	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/ff;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;)V
    //   1235: aload_0
    //   1236: aload_1
    //   1237: invokespecial 2102	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/ft;)V
    //   1240: sipush 7187
    //   1243: invokestatic 410	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1246: return
    //   1247: aconst_null
    //   1248: astore 5
    //   1250: goto -123 -> 1127
    //   1253: aconst_null
    //   1254: astore 5
    //   1256: goto -96 -> 1160
    //   1259: astore_1
    //   1260: aload 7
    //   1262: astore 5
    //   1264: goto -422 -> 842
    //   1267: iconst_0
    //   1268: istore_2
    //   1269: goto -792 -> 477
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1272	0	this	BizVideoDetailUI
    //   0	1272	1	paramft	ft
    //   459	810	2	i	int
    //   1	501	3	j	int
    //   67	452	4	k	int
    //   36	769	5	localObject1	Object
    //   830	30	5	localThrowable	Throwable
    //   864	399	5	localObject2	Object
    //   3	1176	6	localObject3	Object
    //   6	1255	7	localObject4	Object
    //   73	1115	8	localObject5	Object
    //   214	787	9	localObject6	Object
    //   571	13	10	localIterator	java.util.Iterator
    //   612	276	11	str	String
    //   794	81	12	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   789	796	830	java/lang/Throwable
    //   801	806	830	java/lang/Throwable
    //   811	830	830	java/lang/Throwable
    //   857	874	830	java/lang/Throwable
    //   874	903	830	java/lang/Throwable
    //   832	841	841	finally
    //   789	796	1259	finally
    //   801	806	1259	finally
    //   811	830	1259	finally
    //   857	874	1259	finally
    //   874	903	1259	finally
  }
  
  public final void aa(Bundle paramBundle)
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
    Log.i(this.TAG, "sendMPPageData %s, webviewId = %d", new Object[] { str, Integer.valueOf(j) });
    if (kotlin.g.b.p.j("adWeb", str))
    {
      if (this.pHV == null)
      {
        AppMethodBeat.o(7200);
        return;
      }
      paramBundle = this.pHV;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getJsapi();
        if (paramBundle != null)
        {
          paramBundle.aYc((String)localObject);
          AppMethodBeat.o(7200);
          return;
        }
      }
      AppMethodBeat.o(7200);
      return;
    }
    if (kotlin.g.b.p.j("dot", str))
    {
      if (this.pHW == null)
      {
        AppMethodBeat.o(7200);
        return;
      }
      paramBundle = this.pHW;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label257;
        }
        paramBundle = this.TAG;
        localObject = this.pHW;
        if (localObject == null) {
          break label252;
        }
      }
      label252:
      for (int i = localObject.hashCode();; i = 0)
      {
        Log.i(paramBundle, "sendMPPageData id not match %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(7200);
        return;
        i = 0;
        break;
      }
      label257:
      paramBundle = this.pHW;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getJsapi();
        if (paramBundle != null)
        {
          paramBundle.aYc((String)localObject);
          AppMethodBeat.o(7200);
          return;
        }
      }
      AppMethodBeat.o(7200);
      return;
    }
    paramBundle = this.IBw;
    if (paramBundle != null)
    {
      paramBundle.aYc((String)localObject);
      AppMethodBeat.o(7200);
      return;
    }
    AppMethodBeat.o(7200);
  }
  
  public final void ab(Bundle paramBundle)
  {
    AppMethodBeat.i(7208);
    if (this.pHW == null)
    {
      AppMethodBeat.o(7208);
      return;
    }
    if (paramBundle == null) {
      kotlin.g.b.p.hyc();
    }
    int j = paramBundle.getInt("webviewId", 0);
    if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.cqW())
    {
      paramBundle = this.pHW;
      MMWebViewWithJsApi localMMWebViewWithJsApi;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label125;
        }
        paramBundle = this.TAG;
        localMMWebViewWithJsApi = this.pHW;
        if (localMMWebViewWithJsApi == null) {
          break label120;
        }
      }
      label120:
      for (int i = localMMWebViewWithJsApi.hashCode();; i = 0)
      {
        Log.i(paramBundle, "closeDotWebview id not match %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(7208);
        return;
        i = 0;
        break;
      }
    }
    label125:
    Log.i(this.TAG, "closeDotWebview");
    cqo();
    AppMethodBeat.o(7208);
  }
  
  public final void ac(Bundle paramBundle)
  {
    AppMethodBeat.i(7209);
    if (this.pHW == null)
    {
      AppMethodBeat.o(7209);
      return;
    }
    if (paramBundle == null) {
      kotlin.g.b.p.hyc();
    }
    int j = paramBundle.getInt("webviewId", 0);
    int i;
    MMWebViewWithJsApi localMMWebViewWithJsApi;
    if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.cqW())
    {
      paramBundle = this.pHW;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label125;
        }
        paramBundle = this.TAG;
        localMMWebViewWithJsApi = this.pHW;
        if (localMMWebViewWithJsApi == null) {
          break label120;
        }
      }
      label120:
      for (i = localMMWebViewWithJsApi.hashCode();; i = 0)
      {
        Log.i(paramBundle, "hideDotWebview id not match %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(7209);
        return;
        i = 0;
        break;
      }
    }
    label125:
    Log.i(this.TAG, "hideDotWebview");
    paramBundle = cqb();
    if ((paramBundle == null) || (paramBundle.getVisibility() != 0))
    {
      Log.i(this.TAG, "dotView not show");
      AppMethodBeat.o(7209);
      return;
    }
    paramBundle = cqb();
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.IBw;
    if (paramBundle != null)
    {
      i = cqy();
      localMMWebViewWithJsApi = this.pHW;
      if (localMMWebViewWithJsApi == null) {
        kotlin.g.b.p.hyc();
      }
      paramBundle.P(i, localMMWebViewWithJsApi.hashCode(), "disappear");
    }
    paramBundle = this.pHW;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getJsapi();
      if (paramBundle != null)
      {
        i = cqy();
        localMMWebViewWithJsApi = this.pHW;
        if (localMMWebViewWithJsApi == null) {
          kotlin.g.b.p.hyc();
        }
        paramBundle.P(i, localMMWebViewWithJsApi.hashCode(), "disappear");
        AppMethodBeat.o(7209);
        return;
      }
    }
    AppMethodBeat.o(7209);
  }
  
  public final void ac(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(175512);
    kotlin.g.b.p.h(paramMap, "params");
    Log.i(this.TAG, "insertVideoNativeView");
    Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.pIg.aiR("8"), this.pIg);
    Object localObject2 = this.pIg;
    localObject1 = this.pHc;
    Object localObject3;
    float f1;
    float f2;
    boolean bool;
    label892:
    int i;
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((BaseWebViewController)localObject1).IKa;
      localObject3 = (r)localObject1;
      if (localObject3 != null)
      {
        localObject1 = (kotlin.g.a.b)j.a.a.pLu;
        long l5 = ((r)localObject3).bdg("getA8KeyStart");
        long l6 = ((r)localObject3).bdg("getA8KeyEnd");
        long l3 = ((r)localObject3).bdg("onPageStarted");
        long l2 = ((r)localObject3).bdg("onPageFinished");
        long l4 = ((r)localObject3).bdg("firstScreenTimestamp");
        long l7 = ((r)localObject3).bdg("firstScreenTime");
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
        localObject3 = new ff();
        ((ff)localObject3).type = 5;
        LinkedList localLinkedList = ((ff)localObject3).KEQ;
        fi localfi = new fi();
        localfi.key = "EventType";
        localfi.iFF = "6";
        localLinkedList.add(localfi);
        localLinkedList = ((ff)localObject3).KEQ;
        localfi = new fi();
        localfi.key = "StartTime";
        localfi.iFF = ((String)((kotlin.g.a.b)localObject1).invoke(Long.valueOf(l5)));
        localLinkedList.add(localfi);
        localLinkedList = ((ff)localObject3).KEQ;
        localfi = new fi();
        localfi.key = "EndTime";
        localfi.iFF = ((String)((kotlin.g.a.b)localObject1).invoke(Long.valueOf(l6)));
        localLinkedList.add(localfi);
        ((j.a)localObject2).pLt.add(localObject3);
        localObject3 = new ff();
        ((ff)localObject3).type = 5;
        localLinkedList = ((ff)localObject3).KEQ;
        localfi = new fi();
        localfi.key = "EventType";
        localfi.iFF = "7";
        localLinkedList.add(localfi);
        localLinkedList = ((ff)localObject3).KEQ;
        localfi = new fi();
        localfi.key = "StartTime";
        localfi.iFF = ((String)((kotlin.g.a.b)localObject1).invoke(Long.valueOf(l2)));
        localLinkedList.add(localfi);
        localLinkedList = ((ff)localObject3).KEQ;
        localfi = new fi();
        localfi.key = "EndTime";
        localfi.iFF = ((String)((kotlin.g.a.b)localObject1).invoke(Long.valueOf(l1)));
        localLinkedList.add(localfi);
        ((j.a)localObject2).pLt.add(localObject3);
      }
      d(this.pGj);
      localObject1 = this.pHU;
      localObject2 = getContext();
      kotlin.g.b.p.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      f1 = this.density;
      kotlin.g.b.p.h(localObject2, "context");
      kotlin.g.b.p.h(paramMap, "params");
      ((i)localObject1).x = ((int)(Util.getInt((String)paramMap.get("x"), 0) * f1) - 2);
      ((i)localObject1).y = ((int)(Util.getInt((String)paramMap.get("y"), 0) * f1) - 2);
      ((i)localObject1).width = ((int)(Util.getInt((String)paramMap.get("width"), 0) * f1) + 4);
      ((i)localObject1).height = ((int)(Util.getInt((String)paramMap.get("height"), 0) * f1) + 4);
      ((i)localObject1).pKZ = ((String)paramMap.get("reportParams"));
      float f3 = Util.getFloat((String)paramMap.get("playerMinRatioWhenPlaying"), 1.777778F);
      f2 = Util.getFloat((String)paramMap.get("playerMinRatioWhenNotPlaying"), 1.777778F);
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
      Log.w("MicroMsg.BizVideoPosHelper", "init invalid params x=" + ((i)localObject1).x + ", y=" + ((i)localObject1).y + ", width=" + ((i)localObject1).width + ", height=" + ((i)localObject1).height);
      bool = false;
      this.pIj = bool;
      this.pGx.pHA = Util.getInt((String)paramMap.get("landingType"), 0);
      if (this.pIj)
      {
        cpw().addView((View)cqg());
        if ((this.pHU.width > 0) && (this.pHU.height > 0)) {
          fe(this.pHU.width, this.pHU.height);
        }
        cpZ().a((ImageView)this.pHG.a(cLI[0]), cpu().iAi.iAo, this.pHU.width, this.pHU.pKR, cpu());
        localObject1 = cpZ();
        localObject2 = cpu().iAi.iAo;
        i = this.pHU.width;
        j = this.pHU.pKR;
        localObject3 = cpu();
        kotlin.g.b.p.h(localObject3, "msgInfo");
        paramMap = ((MPVideoView)localObject1).pNZ;
        if (paramMap == null) {
          break label1746;
        }
      }
    }
    label1746:
    for (paramMap = paramMap.getCoverIv();; paramMap = null)
    {
      ((MPVideoView)localObject1).a(paramMap, (String)localObject2, i, j, (com.tencent.mm.ag.x)localObject3);
      dy((View)cpw());
      paramMap = cpY();
      kotlin.g.b.p.g(paramMap, "animationLayout");
      dy(paramMap);
      this.pHU.a(0, cpZ());
      Log.i(this.TAG, "initVideoParam minVideoHeight " + this.pHU.pKR + " maxVideoHeight " + this.pHU.bEm);
      paramMap = cpY();
      kotlin.g.b.p.g(paramMap, "animationLayout");
      paramMap.setVisibility(0);
      cpt().bringToFront();
      cpZ().setFullScreenDelegate((MPVideoView.b)new o(this));
      cpZ().setMPVideoViewCallBack((MPVideoView.c)new p(this));
      ((View)this.pHP.a(cLI[9])).setOnClickListener((View.OnClickListener)new BizVideoDetailUI.q(this));
      getWebView().setOnCustomTouchListener((View.OnTouchListener)new BizVideoDetailUI.r(this));
      cpZ().setTitle(cpu().iAi.title);
      cpZ().setPlayBtnOnClickListener((View.OnClickListener)new s(this));
      paramMap = cqd();
      localObject1 = this.pGx;
      kotlin.g.b.p.h(localObject1, "controller");
      paramMap.gvQ.setOnClickListener((View.OnClickListener)new MPVideoErrorView.a(paramMap, (b)localObject1));
      b(this.pIk);
      AppMethodBeat.o(175512);
      return;
      localObject1 = null;
      break;
      label1398:
      ((i)localObject1).mEX = com.tencent.mm.cb.a.jn((Context)localObject2);
      if ((((i)localObject1).x <= 0) && (Math.abs(((i)localObject1).mEX - ((i)localObject1).width) < 10))
      {
        ((i)localObject1).x = 0;
        ((i)localObject1).width = ((i)localObject1).mEX;
      }
      ((i)localObject1).pKP = ((i)localObject1).x;
      ((i)localObject1).pKQ = ((i)localObject1).y;
      ((i)localObject1).pKR = ((i)localObject1).height;
      ((i)localObject1).pKS = ((i)localObject1).width;
      ((i)localObject1).bEm = ((int)(((i)localObject1).mEX * 1.0F / ((i)localObject1).width * ((i)localObject1).height));
      ((i)localObject1).pKT = ((i)localObject1).bEm;
      ((i)localObject1).pKU = kotlin.k.j.na((int)(((i)localObject1).mEX * 1.0F / f1), ((i)localObject1).bEm);
      ((i)localObject1).pKV = kotlin.k.j.na((int)(((i)localObject1).mEX * 1.0F / f2), ((i)localObject1).bEm);
      if ((((i)localObject1).pKU == ((i)localObject1).pKV) && (Math.abs(((i)localObject1).pKV - ((i)localObject1).bEm) < 10))
      {
        ((i)localObject1).pKU = ((i)localObject1).bEm;
        ((i)localObject1).pKV = ((i)localObject1).bEm;
      }
      Log.i("MicroMsg.BizVideoPosHelper", "init x=" + ((i)localObject1).x + ", y=" + ((i)localObject1).y + ", width=" + ((i)localObject1).width + ", height=" + ((i)localObject1).height + ", screenWidth=" + ((i)localObject1).mEX + ", minVideoHeightWhenPlay = " + ((i)localObject1).pKU + ", minVideoHeightWhenPause = " + ((i)localObject1).pKV);
      bool = true;
      break label892;
    }
  }
  
  public final void ad(Bundle paramBundle)
  {
    AppMethodBeat.i(7210);
    if (this.pHW == null)
    {
      AppMethodBeat.o(7210);
      return;
    }
    if (paramBundle == null) {
      kotlin.g.b.p.hyc();
    }
    int j = paramBundle.getInt("webviewId", 0);
    if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.cqW())
    {
      paramBundle = this.pHW;
      MMWebViewWithJsApi localMMWebViewWithJsApi;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label125;
        }
        paramBundle = this.TAG;
        localMMWebViewWithJsApi = this.pHW;
        if (localMMWebViewWithJsApi == null) {
          break label120;
        }
      }
      label120:
      for (int i = localMMWebViewWithJsApi.hashCode();; i = 0)
      {
        Log.i(paramBundle, "dotWebviewReady id not match %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(7210);
        return;
        i = 0;
        break;
      }
    }
    label125:
    Log.i(this.TAG, "dotWebViewReady %d", new Object[] { Integer.valueOf(j) });
    this.pHY = true;
    com.tencent.mm.plugin.webview.i.a.agn(59);
    AppMethodBeat.o(7210);
  }
  
  public final void ae(Bundle paramBundle)
  {
    AppMethodBeat.i(7211);
    Object localObject1 = this.pIe;
    int k = cpZ().getDuration();
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {
      Log.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData data invalid");
    }
    Object localObject2;
    int m;
    int i;
    for (;;)
    {
      cqz();
      localObject1 = cpZ();
      paramBundle = new LinkedList((Collection)this.pIe.pKl);
      kotlin.g.b.p.h(paramBundle, "list");
      localObject1 = ((MPVideoView)localObject1).pOa;
      if (localObject1 != null) {
        ((MPVideoViewControlBar)localObject1).N(paramBundle);
      }
      cqu();
      AppMethodBeat.o(7211);
      return;
      try
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).pKl.clear();
        localObject2 = kotlin.x.SXb;
        paramBundle = paramBundle.getString("data", "");
        Log.d(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData data=".concat(String.valueOf(paramBundle)));
        try
        {
          paramBundle = new JSONObject(paramBundle).optJSONArray("items");
          if (paramBundle == null) {
            Log.w(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "itemList null");
          }
        }
        catch (Exception paramBundle)
        {
          Log.e(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData ex %s", new Object[] { paramBundle.getMessage() });
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
        paramBundle = new t("null cannot be cast to non-null type org.json.JSONObject");
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
      kotlin.g.b.p.g(str, "url");
      localObject2 = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c(j, d1, d2, d3, str);
      if (n != 1) {
        break label570;
      }
      bool = true;
      label378:
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).pKn = bool;
      if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).pKt < ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).pKu) && (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).pKt >= 0.0D) && (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).pKu <= k)) {
        break label576;
      }
      Log.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "dotInfo invalid, startTime = " + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).pKt + ", endTime=" + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).pKu + ", duration=" + k);
    }
    label561:
    label570:
    label576:
    for (int j = 0;; j = 1)
    {
      if (j == 0)
      {
        Log.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "dotInfo invalid");
      }
      else
      {
        try
        {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).pKl.add(localObject2);
          break label561;
        }
        finally
        {
          paramBundle = finally;
          AppMethodBeat.o(7211);
          throw paramBundle;
        }
        Log.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData end %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).pKl.size()) });
        break;
      }
      i += 1;
      break label238;
      bool = false;
      break label378;
    }
  }
  
  public final void af(Bundle paramBundle)
  {
    AppMethodBeat.i(7201);
    if ((paramBundle == null) || (!paramBundle.containsKey("opType")))
    {
      AppMethodBeat.o(7201);
      return;
    }
    paramBundle = paramBundle.getString("opType");
    Log.i(this.TAG, "opPlayer opType= ".concat(String.valueOf(paramBundle)));
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
          cpZ().start();
          AppMethodBeat.o(7201);
          return;
          if (paramBundle.equals("stop")) {
            cpZ().stop();
          }
        }
      }
    } while (!paramBundle.equals("pause"));
    cpZ().pause();
    AppMethodBeat.o(7201);
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(7173);
    super.b(paramWebView, paramString);
    AppMethodBeat.o(7173);
  }
  
  public final void bXg()
  {
    AppMethodBeat.i(7156);
    super.bXg();
    if (this.mHh != null) {}
    try
    {
      this.pGx.pHC.pLE = this.mHh.IS(cpu().ajO());
      this.pGx.pHC.er(1, 0);
      Object localObject = this.mHh;
      kotlin.g.b.p.g(localObject, "invoker");
      this.uin = ((e)localObject).gec();
      this.pGx.pHy = cqi();
      this.pIb = false;
      this.pGx.cpT();
      this.pIg.aiR("5");
      if (!Util.isNullOrNil(cpu().iAi.title))
      {
        localObject = gff();
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.webview.ui.tools.multitask.a)localObject).aCM(cpu().iAi.title);
          AppMethodBeat.o(7156);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w(this.TAG, "invoker ex :" + localException.getMessage());
      }
      AppMethodBeat.o(7156);
    }
  }
  
  public final void cpA()
  {
    AppMethodBeat.i(7154);
    super.cpA();
    setBackBtn((MenuItem.OnMenuItemClickListener)new BizVideoDetailUI.m(this), 2131689494);
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
    ff localff = this.pIg.aiR("1");
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
    localObject = this.pHc;
    boolean bool;
    if (localObject != null)
    {
      bool = ((MpWebViewController)localObject).cph();
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (localObject = "1";; localObject = "0")
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localff, "MiaoKai", (String)localObject);
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localff, this.pIg);
      AppMethodBeat.o(7154);
      return;
      bool = false;
      break;
    }
  }
  
  public final void cpB()
  {
    AppMethodBeat.i(175513);
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h localh = this.pHR;
    if (localh != null) {
      localh.release();
    }
    cqA();
    this.pIe.reset();
    gfj();
    this.pGy.onDestroy();
    int i = cql();
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.cL(cqp(), i);
    this.pGx.onDestroy();
    cqn();
    cqo();
    cpZ().onUIDestroy();
    AppMethodBeat.o(175513);
  }
  
  public final void cpF()
  {
    AppMethodBeat.i(7197);
    cqn();
    AppMethodBeat.o(7197);
  }
  
  public final void cpG()
  {
    AppMethodBeat.i(7198);
    Log.i(this.TAG, "adWebviewReady");
    this.pHX = true;
    AppMethodBeat.o(7198);
  }
  
  public final Bundle cpH()
  {
    AppMethodBeat.i(7199);
    Bundle localBundle = new Bundle();
    localBundle.putInt("currentTime", cpZ().getCurrPosSec());
    localBundle.putInt("duration", cpZ().getDuration());
    localBundle.putString("state", this.pIh);
    localBundle.putLong("playedTotalTime", cpZ().getRealPlayTime() / 1000L);
    localBundle.putString("vid", this.pGx.vid);
    AppMethodBeat.o(7199);
    return localBundle;
  }
  
  public final boolean cpz()
  {
    return true;
  }
  
  public final void cqh()
  {
    AppMethodBeat.i(7153);
    this.pIg.cra();
    super.cqh();
    if (!this.pIf)
    {
      this.pIf = true;
      com.tencent.mm.pluginsdk.h.q((MMActivity)this);
      com.tencent.mm.plugin.webview.i.a.agn(0);
    }
    getIntent().putExtra("vertical_scroll", false);
    AppMethodBeat.o(7153);
  }
  
  public final void cqk()
  {
    AppMethodBeat.i(7169);
    com.tencent.mm.plugin.webview.ui.tools.widget.n localn = gfh();
    localn.setMinHeaderHeight(this.pHU.height);
    localn.setUrl(this.fQR);
    localn.giy();
    localn.a(this.pGx.scene, this.pGx.pHw, this.pGx.iwc, this.pGx.pHu, this.pGx.url, cpu().iAi.title);
    localn.setCallback((n.c)new n(this));
    localn.setTimeLineSessionId(localn.getTimeLineSessionId());
    AppMethodBeat.o(7169);
  }
  
  public final int cql()
  {
    AppMethodBeat.i(7181);
    Object localObject = cpZ();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((MPVideoView)localObject).getCurrPosSec());; localObject = null)
    {
      int j = ((Integer)localObject).intValue();
      localObject = cpZ();
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
  
  public final void cqo()
  {
    AppMethodBeat.i(7184);
    if (this.pHW == null)
    {
      AppMethodBeat.o(7184);
      return;
    }
    com.tencent.mm.plugin.webview.i.a.agn(61);
    if (!this.pHY) {
      com.tencent.mm.plugin.webview.i.a.agn(62);
    }
    Object localObject = this.IBw;
    int i;
    MMWebViewWithJsApi localMMWebViewWithJsApi;
    if (localObject != null)
    {
      i = cqy();
      localMMWebViewWithJsApi = this.pHW;
      if (localMMWebViewWithJsApi == null) {
        kotlin.g.b.p.hyc();
      }
      ((com.tencent.mm.plugin.webview.d.h)localObject).P(i, localMMWebViewWithJsApi.hashCode(), "disappear");
    }
    localObject = this.IBw;
    if (localObject != null)
    {
      i = cqy();
      localMMWebViewWithJsApi = this.pHW;
      if (localMMWebViewWithJsApi == null) {
        kotlin.g.b.p.hyc();
      }
      ((com.tencent.mm.plugin.webview.d.h)localObject).P(i, localMMWebViewWithJsApi.hashCode(), "destroy");
    }
    localObject = cqb();
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = cqb();
    if (localObject != null) {
      ((FrameLayout)localObject).removeView((View)this.pHW);
    }
    localObject = this.pHW;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getCurWebviewClient();
      if (!(localObject instanceof com.tencent.mm.plugin.webview.ui.tools.widget.k)) {
        break label223;
      }
      localObject = this.pHW;
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
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewClient");
      AppMethodBeat.o(7184);
      throw ((Throwable)localObject);
      localObject = null;
      break;
    }
    label216:
    ((com.tencent.mm.plugin.webview.ui.tools.widget.k)localObject).cleanup();
    label223:
    localObject = this.pHW;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).destroy();
    }
    localObject = this.pHW;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebChromeClient(null);
    }
    localObject = this.pHW;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebViewClient(null);
    }
    localObject = this.pHW;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnTouchListener(null);
    }
    localObject = this.pHW;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnLongClickListener(null);
    }
    localObject = this.pHW;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setVisibility(8);
    }
    localObject = this.pHW;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).removeAllViews();
    }
    localObject = this.pHW;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).clearView();
    }
    this.pHW = null;
    this.pHY = false;
    localObject = this.pId;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).dvh = false;
    }
    localObject = this.pId;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).pKq = false;
    }
    this.pId = null;
    AppMethodBeat.o(7184);
  }
  
  public final int cqy()
  {
    AppMethodBeat.i(7212);
    if (this.pId == null)
    {
      AppMethodBeat.o(7212);
      return -1;
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c localc = this.pId;
    if (localc == null) {
      kotlin.g.b.p.hyc();
    }
    int i = localc.id;
    AppMethodBeat.o(7212);
    return i;
  }
  
  public final void cqz()
  {
    AppMethodBeat.i(7213);
    if ((this.pIc) || (cpZ().getCurrPosSec() <= 0))
    {
      AppMethodBeat.o(7213);
      return;
    }
    float f = cpZ().getCurrPosMs() / 1000.0F;
    if ((this.pHW != null) && (this.pIe.b(f, this.pId)))
    {
      localObject = this.pId;
      if (localObject == null) {
        kotlin.g.b.p.hyc();
      }
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).dvh)
      {
        if (BuildInfo.DEBUG) {
          Log.d(this.TAG, "dot end, wait h5 to close");
        }
        if (System.currentTimeMillis() - this.pIo >= 1000L)
        {
          Log.i(this.TAG, "dot end, time out to close");
          cqo();
        }
        AppMethodBeat.o(7213);
        return;
      }
      Log.i(this.TAG, "destroyDotWebView");
      localObject = cqb();
      if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
      {
        localObject = this.pHW;
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
        localObject = this.pHW;
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        if (((com.tencent.mm.plugin.webview.d.h)localObject).isReady()) {
          break;
        }
      }
      cqo();
      if (this.pId == null) {
        break label360;
      }
      if (this.pHY)
      {
        localObject = cqb();
        if (((localObject == null) || (((FrameLayout)localObject).getVisibility() != 0)) && (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.a(f, this.pId))) {
          cqx();
        }
      }
      AppMethodBeat.o(7213);
      return;
    }
    localObject = this.pId;
    if (localObject == null) {
      kotlin.g.b.p.hyc();
    }
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).dvh = true;
    this.pIo = System.currentTimeMillis();
    localObject = this.pHW;
    int i;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
      if (localObject != null)
      {
        i = cqy();
        MMWebViewWithJsApi localMMWebViewWithJsApi = this.pHW;
        if (localMMWebViewWithJsApi == null) {
          kotlin.g.b.p.hyc();
        }
        ((com.tencent.mm.plugin.webview.d.h)localObject).P(i, localMMWebViewWithJsApi.hashCode(), "end");
        AppMethodBeat.o(7213);
        return;
      }
    }
    AppMethodBeat.o(7213);
    return;
    label360:
    this.pId = this.pIe.bb(f);
    if (this.pId != null)
    {
      i = cqy();
      localObject = this.pId;
      if (localObject == null) {
        kotlin.g.b.p.hyc();
      }
      aK(i, ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).url);
    }
    AppMethodBeat.o(7213);
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(7177);
    if (this.kGg)
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
    if (cpu().iAi == null)
    {
      finish();
      Log.w(this.TAG, "onCreate msgInfo.item is null");
      AppMethodBeat.o(7155);
      return;
    }
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("onCreate rawUrl is ");
    Object localObject3 = cpu().iAi;
    if (localObject3 == null) {
      kotlin.g.b.p.hyc();
    }
    Log.i((String)localObject1, ((v)localObject3).url);
    localObject3 = this.pIg;
    localObject1 = cpu().iAi;
    if (localObject1 == null) {
      kotlin.g.b.p.hyc();
    }
    localObject2 = ((v)localObject1).url;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((j.a)localObject3).pLp = ((String)localObject1);
    this.pIg.pLn = String.valueOf(cpx());
    this.pIg.pLo = String.valueOf(System.currentTimeMillis() / 1000L);
    localObject1 = this.pGx;
    localObject2 = this.lma;
    kotlin.g.b.p.h(localObject2, "callback");
    ((b)localObject1).lma = ((IPCRunCgi.a)localObject2);
    localObject1 = this.pGy;
    localObject2 = (TmplShareWebViewToolUI)this;
    localObject3 = cpu();
    Object localObject4 = this.pGx;
    kotlin.g.b.p.h(localObject2, "ui");
    kotlin.g.b.p.h(localObject3, "msgInfo");
    kotlin.g.b.p.h(localObject4, "controller");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p)localObject1).nhy = new WeakReference(localObject2);
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p)localObject1).pHv = ((com.tencent.mm.ag.x)localObject3);
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p)localObject1).pIL = ((b)localObject4);
    this.pGx.pHx = ((Number)this.pGF.a(TmplShareWebViewToolUI.cLI[8])).intValue();
    this.pGx.pHC.pKJ = new WeakReference(cpZ());
    localObject1 = this.pGx;
    localObject3 = (TmplShareWebViewToolUI)this;
    int i = getScene();
    int j = getSubScene();
    localObject4 = cpu().iAi;
    if (localObject4 == null) {
      kotlin.g.b.p.hyc();
    }
    localObject2 = cpu();
    int k = cpx();
    kotlin.g.b.p.h(localObject3, "ui");
    kotlin.g.b.p.h(localObject4, "readerItem");
    kotlin.g.b.p.h(localObject2, "msgInfo");
    ((b)localObject1).nhy = new WeakReference(localObject3);
    ((b)localObject1).scene = i;
    ((b)localObject1).pHw = j;
    ((b)localObject1).aiF(((v)localObject4).url);
    ((b)localObject1).ptH = ((v)localObject4);
    ((b)localObject1).pHv = ((com.tencent.mm.ag.x)localObject2);
    ((b)localObject1).iwc = ((v)localObject4).type;
    ((b)localObject1).pHu = k;
    ((b)localObject1).dHc = ((com.tencent.mm.ag.x)localObject2).dHc;
    ((b)localObject1).pHo = ((com.tencent.mm.ag.x)localObject2).iAg;
    ((b)localObject1).vid = ((com.tencent.mm.ag.x)localObject2).iAi.vid;
    localObject3 = ((b)localObject1).pHq;
    kotlin.g.b.p.h(localObject1, "controller");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.n)localObject3).pIL = ((b)localObject1);
    localObject3 = ((b)localObject1).pHC;
    kotlin.g.b.p.h(localObject1, "controller");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject3).pIL = ((b)localObject1);
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject3).pLF = true;
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject3).pLD = "";
    try
    {
      localObject2 = Uri.parse(((com.tencent.mm.ag.x)localObject2).iAi.url);
      ((b)localObject1).iAQ = Util.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
      ((b)localObject1).idx = Util.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
      Log.i(((b)localObject1).TAG, "init vid=" + ((b)localObject1).vid);
      localObject3 = this.pGx;
      localObject2 = getIntent().getStringExtra("biz_video_channel_session_id");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      kotlin.g.b.p.h(localObject1, "<set-?>");
      ((b)localObject3).pHz = ((String)localObject1);
      com.tencent.mm.plugin.webview.i.a.agn(1);
      this.pIe.reset();
      this.JjI.setMMOverScrollOffsetListener((LogoWebViewWrapper.b)new x(this));
      this.JjI.geV();
      this.JjI.geW();
      this.pIi = false;
      this.pIj = false;
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ((IntentFilter)localObject1).setPriority(2147483647);
      if (this.pIr == null) {
        this.pIr = ((BroadcastReceiver)new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(7132);
            kotlin.g.b.p.h(paramAnonymousContext, "context");
            if ((paramAnonymousIntent == null) || (Util.isNullOrNil(paramAnonymousIntent.getAction())) || (!this.pIu.pIb) || ((BizVideoDetailUI.k(this.pIu).pHt) && (!BizVideoDetailUI.v(this.pIu))))
            {
              AppMethodBeat.o(7132);
              return;
            }
            boolean bool1 = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
            if ((!BizVideoDetailUI.w(this.pIu)) && (bool1))
            {
              paramAnonymousContext = BizVideoDetailUI.f(this.pIu);
              paramAnonymousIntent = paramAnonymousContext.pNZ;
              if (paramAnonymousIntent == null) {
                kotlin.g.b.p.hyc();
              }
              if (paramAnonymousIntent.isPlaying())
              {
                paramAnonymousIntent = paramAnonymousContext.pNZ;
                if (paramAnonymousIntent == null) {
                  kotlin.g.b.p.hyc();
                }
                if (paramAnonymousIntent.mEz == null) {
                  break label421;
                }
                paramAnonymousIntent = paramAnonymousIntent.mEz;
                if (paramAnonymousIntent == null) {
                  kotlin.g.b.p.hyc();
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
                paramAnonymousIntent = paramAnonymousContext.pNZ;
                if (paramAnonymousIntent == null) {
                  kotlin.g.b.p.hyc();
                }
                if (paramAnonymousIntent.crv())
                {
                  paramAnonymousIntent = paramAnonymousContext.pNZ;
                  if (paramAnonymousIntent == null) {
                    kotlin.g.b.p.hyc();
                  }
                  paramAnonymousContext = paramAnonymousContext.pNZ;
                  if (paramAnonymousContext == null) {
                    kotlin.g.b.p.hyc();
                  }
                  paramAnonymousIntent.ab(paramAnonymousContext.getCurrPosMs(), true);
                }
              }
              BizVideoDetailUI.c(this.pIu, bool1);
              bool1 = NetStatusUtil.isWifi(MMApplicationContext.getContext());
              i = BizVideoDetailUI.x(this.pIu);
              BizVideoDetailUI.a(this.pIu, BizVideoDetailUI.y(this.pIu));
              boolean bool2 = BizVideoDetailUI.b(this.pIu, BizVideoDetailUI.f(this.pIu).getDuration());
              Log.i(BizVideoDetailUI.m(this.pIu), "net type change simcardTpye=" + BizVideoDetailUI.x(this.pIu) + ", lastSimcardType=" + i + ", is wifi=" + bool1 + ", show=" + bool2);
              if (!bool2) {
                break label441;
              }
              paramAnonymousContext = BizVideoDetailUI.i(this.pIu);
              kotlin.g.b.p.g(paramAnonymousContext, "videoWifiTipsView");
              if (paramAnonymousContext.getVisibility() == 0) {
                break label449;
              }
              if ((!BizVideoDetailUI.f(this.pIu).isPlaying()) || (this.pIu.pIc) || ((BizVideoDetailUI.f(this.pIu).crD()) && (BizVideoDetailUI.f(this.pIu).bJb()))) {
                break;
              }
              BizVideoDetailUI.b(this.pIu, true);
              AppMethodBeat.o(7132);
              return;
            }
            this.pIu.pHZ = true;
            AppMethodBeat.o(7132);
            return;
            label441:
            BizVideoDetailUI.a(this.pIu, 0L);
            label449:
            AppMethodBeat.o(7132);
          }
        });
      }
      getContext().registerReceiver(this.pIr, (IntentFilter)localObject1);
      AppMethodBeat.o(7155);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        Log.w(((b)localObject1).TAG, "init parse url exp %s", new Object[] { localUnsupportedOperationException.getMessage() });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w(((b)localObject1).TAG, "init parse url exp %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void ko(boolean paramBoolean)
  {
    AppMethodBeat.i(7166);
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h localh = this.pHR;
    if (localh != null)
    {
      Log.i("MicroMsg.BizVideoOrientationHelper", "enable :".concat(String.valueOf(paramBoolean)));
      if (localh.aQs())
      {
        Object localObject;
        if (paramBoolean)
        {
          localh.pKM.enable();
          if (localh.mSensorManager == null)
          {
            localObject = MMApplicationContext.getContext().getSystemService("sensor");
            if (localObject == null)
            {
              localObject = new t("null cannot be cast to non-null type android.hardware.SensorManager");
              AppMethodBeat.o(7166);
              throw ((Throwable)localObject);
            }
            localh.mSensorManager = ((SensorManager)localObject);
            localObject = localh.mSensorManager;
            if (localObject != null) {}
            for (localObject = ((SensorManager)localObject).getDefaultSensor(1);; localObject = null)
            {
              localh.pKK = ((Sensor)localObject);
              localObject = localh.mSensorManager;
              if (localObject == null) {
                break;
              }
              ((SensorManager)localObject).registerListener((SensorEventListener)localh, localh.pKK, 3);
              AppMethodBeat.o(7166);
              return;
            }
            AppMethodBeat.o(7166);
          }
        }
        else
        {
          localh.pKM.disable();
          localObject = localh.lAM.get();
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(7166);
            throw ((Throwable)localObject);
          }
          ((MMActivity)localObject).setRequestedOrientation(1);
          localh.iqr = 0;
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
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p localp = this.pGy;
    Object localObject3;
    int i;
    if (paramInt1 == 1) {
      if (paramInt2 == -1)
      {
        localObject2 = (Context)localp.cpV();
        localObject3 = localp.cpV();
        if (localObject3 != null) {
          localObject1 = ((TmplShareWebViewToolUI)localObject3).getString(2131756815);
        }
        com.tencent.mm.ui.base.h.cA((Context)localObject2, (String)localObject1);
        if (localp.pMd)
        {
          i = 11;
          localObject1 = localp.pIL;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("controller");
          }
          ((b)localObject1).pHq.aL(i, localp.pMf);
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
            localObject3 = g.pKI;
            localObject3 = localp.pHv;
            if (localObject3 == null) {
              kotlin.g.b.p.btv("msgInfo");
            }
            b localb = localp.pIL;
            if (localb == null) {
              kotlin.g.b.p.btv("controller");
            }
            g.a((String)localObject1, (com.tencent.mm.ag.x)localObject3, (String)localObject2, localb, (com.tencent.mm.ipcinvoker.d)new p.a(localp));
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
    if (this.kGg)
    {
      cpZ().p(false, 0);
      AppMethodBeat.o(7185);
      return;
    }
    com.tencent.mm.plugin.webview.ui.tools.widget.n localn = gfh();
    if ((localn.getSayFooter().giw()) && (localn.bJw())) {
      localn.getSayFooter().fjJ();
    }
    for (;;)
    {
      if (i == 0) {
        super.onBackPressed();
      }
      AppMethodBeat.o(7185);
      return;
      if ((localn.JjT != -3) && (localn.bJw())) {
        localn.hide();
      } else {
        i = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7179);
    this.pIg.aiS("21");
    this.pIg.aiS("22");
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.pIg.aiR("2"), this.pIg);
    cqm();
    super.onDestroy();
    localObject = this.pHS;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.widget.a)localObject).b(this.pIn);
    }
    cpB();
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.aiQ(((BizVideoDetailUI)this).toString());
    AppMethodBeat.o(7179);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(7186);
    kotlin.g.b.p.h(paramKeyEvent, "event");
    Log.i(this.TAG, "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.kGg))
    {
      cpZ().p(false, 0);
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
    Object localObject = cpZ();
    Log.i(MPVideoView.TAG, "onUIPause");
    localObject = ((MPVideoView)localObject).pNZ;
    if (localObject == null) {
      kotlin.g.b.p.hyc();
    }
    ((MPExoVideoWrapper)localObject).pNo = true;
    ((MPExoVideoWrapper)localObject).pNk.apm();
    ((MPExoVideoWrapper)localObject).setKeepScreenOn(false);
    ((MPExoVideoWrapper)localObject).mEI = ((MPExoVideoWrapper)localObject).isPlaying();
    ((MPExoVideoWrapper)localObject).pause();
    ((MPExoVideoWrapper)localObject).mEw = false;
    AppMethodBeat.o(7174);
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(7180);
    cqm();
    cpB();
    super.onReset();
    AppMethodBeat.o(7180);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(7170);
    super.onResume();
    Object localObject = cpZ();
    Log.i(MPVideoView.TAG, "onUIResume");
    if (((MPVideoView)localObject).mwt)
    {
      Log.i(MPVideoView.TAG, "onUIResume, should skip ui resume");
      ((MPVideoView)localObject).mwt = false;
      AppMethodBeat.o(7170);
      return;
    }
    localObject = ((MPVideoView)localObject).pNZ;
    if (localObject == null) {
      kotlin.g.b.p.hyc();
    }
    ((MPExoVideoWrapper)localObject).pNo = false;
    ((MPExoVideoWrapper)localObject).mEw = true;
    if ((((MPExoVideoWrapper)localObject).pNi != null) && (((MPExoVideoWrapper)localObject).cJj) && ((((MPExoVideoWrapper)localObject).mEI) || (((MPExoVideoWrapper)localObject).pNm)))
    {
      Log.i(MPExoVideoWrapper.TAG, "onUIResume, isPlayOnUiPause =" + ((MPExoVideoWrapper)localObject).mEI + ", mPlayingWhenBackground " + ((MPExoVideoWrapper)localObject).pNm);
      ((MPExoVideoWrapper)localObject).start();
    }
    AppMethodBeat.o(7170);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(7171);
    super.onStart();
    if (cpu().iAi == null)
    {
      finish();
      Log.w(this.TAG, "onStart msgInfo.item is null");
      AppMethodBeat.o(7171);
      return;
    }
    Log.i(this.TAG, "alvinluo onStart handleAnimation coverUrl: %s", new Object[] { cpu().iAi.iAo });
    cpt().bringToFront();
    cpZ().crr();
    AppMethodBeat.o(7171);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class e
    implements IPCRunCgi.a
  {
    e(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd)
    {
      AppMethodBeat.i(7087);
      BizVideoDetailUI.k(this.pIu).cpU();
      if (paramd == null)
      {
        AppMethodBeat.o(7087);
        return;
      }
      Log.i(BizVideoDetailUI.m(this.pIu), "onSceneEnd errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString + ", type: " + paramd.getType());
      Object localObject = paramd.aYJ();
      if ((((localObject instanceof fs)) && (((fs)localObject).KIK != BizVideoDetailUI.k(this.pIu).pHu)) || (((localObject instanceof fr)) && (((fr)localObject).KIK != BizVideoDetailUI.k(this.pIu).pHu)))
      {
        AppMethodBeat.o(7087);
        return;
      }
      if (paramd.getType() == 1179)
      {
        this.pIu.pIb = true;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          BizVideoDetailUI.s(this.pIu);
          paramString = paramd.aYK();
          if (paramString == null)
          {
            paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgGetResp");
            AppMethodBeat.o(7087);
            throw paramString;
          }
          paramString = (ft)paramString;
          paramd = BizVideoDetailUI.m(this.pIu);
          localObject = new StringBuilder("url_info size is ");
          LinkedList localLinkedList;
          if (paramString.KJu != null)
          {
            localLinkedList = paramString.KJu;
            if (localLinkedList == null) {
              kotlin.g.b.p.hyc();
            }
          }
          for (paramInt1 = localLinkedList.size();; paramInt1 = 0)
          {
            Log.i(paramd, paramInt1);
            if ((paramString.KJv == 0) || (Util.isNullOrNil(paramString.KJw))) {
              break;
            }
            Log.i(BizVideoDetailUI.m(this.pIu), "onSceneEnd redirect %s", new Object[] { paramString.KJw });
            paramd = this.pIu;
            paramString = paramString.KJw;
            kotlin.g.b.p.g(paramString, "resp.redirect_url");
            paramd.aiE(paramString);
            AppMethodBeat.o(7087);
            return;
          }
          this.pIu.a(paramString);
          AppMethodBeat.o(7087);
          return;
        }
        this.pIu.a(null);
        BizVideoDetailUI.q(this.pIu);
        paramd = BizVideoDetailUI.p(this.pIu);
        paramd.pIH.setBackgroundResource(2131231373);
        if (!Util.isNullOrNil(paramString)) {
          paramd.pIG.setText((CharSequence)(paramd.getContext().getString(2131763170) + ' ' + paramString));
        }
        for (;;)
        {
          paramd.gvQ.setClickable(true);
          if (paramInt1 != 2) {
            break;
          }
          com.tencent.mm.plugin.webview.i.a.agn(2);
          AppMethodBeat.o(7087);
          return;
          paramd.pIG.setText((CharSequence)paramd.getContext().getString(2131763170));
        }
        com.tencent.mm.plugin.webview.i.a.agn(3);
        AppMethodBeat.o(7087);
        return;
      }
      AppMethodBeat.o(7087);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Lcom/tencent/xweb/WebView;", "url", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.m<WebView, String, kotlin.x>
  {
    i(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(175501);
      MPVideoWifiTipsView localMPVideoWifiTipsView = BizVideoDetailUI.i(this.pIu);
      kotlin.g.b.p.g(localMPVideoWifiTipsView, "videoWifiTipsView");
      localMPVideoWifiTipsView.setVisibility(8);
      AppMethodBeat.o(175501);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initComment$1$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "onHide", "", "onShow", "plugin-brandservice_release"})
  public static final class n
    implements n.c
  {
    n(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void onHide()
    {
      AppMethodBeat.i(7103);
      BizVideoDetailUI.a(this.pIu, this.pIu.pHU.width, this.pIu.pHU.height);
      AppMethodBeat.o(7103);
    }
    
    public final void onShow()
    {
      AppMethodBeat.i(7104);
      this.pIu.ko(false);
      AppMethodBeat.o(7104);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "enterFullScreen", "", "direction", "", "quitFullScreen", "plugin-brandservice_release"})
  public static final class o
    implements MPVideoView.b
  {
    public final void bGL()
    {
      AppMethodBeat.i(7107);
      BizVideoDetailUI.a(this.pIu, "exitFullScreen", "");
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
      localObject = BizVideoDetailUI.d(this.pIu).aiR("18");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((ff)localObject, "FullScreenSwitch", "2");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((ff)localObject, BizVideoDetailUI.d(this.pIu));
      f.cji();
      BizVideoDetailUI.g(this.pIu).btC();
      this.pIu.setRequestedOrientation(1);
      BizVideoDetailUI.k(this.pIu).pHC.er(6, 0);
      localObject = BizVideoDetailUI.j(this.pIu);
      kotlin.g.b.p.g(localObject, "videoAdTitleBar");
      ((LinearLayout)localObject).setVisibility(8);
      BizVideoDetailUI.l(this.pIu);
      AppMethodBeat.o(7107);
    }
    
    public final boolean isFullScreen()
    {
      AppMethodBeat.i(7105);
      boolean bool = BizVideoDetailUI.c(this.pIu);
      AppMethodBeat.o(7105);
      return bool;
    }
    
    public final void xd(int paramInt)
    {
      AppMethodBeat.i(7106);
      BizVideoDetailUI.a(this.pIu, "enterFullScreen", "");
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
      localObject = BizVideoDetailUI.d(this.pIu).aiR("18");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((ff)localObject, "FullScreenSwitch", "1");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((ff)localObject, BizVideoDetailUI.d(this.pIu));
      f.cjj();
      BizVideoDetailUI.e(this.pIu).removeView((View)BizVideoDetailUI.f(this.pIu));
      this.pIu.pHU.a(-16777216, BizVideoDetailUI.f(this.pIu));
      BizVideoDetailUI.a(this.pIu, true);
      BizVideoDetailUI.g(this.pIu).N((View)BizVideoDetailUI.f(this.pIu), paramInt);
      if ((paramInt == 0) || (paramInt == 180)) {
        BizVideoDetailUI.f(this.pIu).setPageGestureInFullscreen(false);
      }
      for (;;)
      {
        localObject = BizVideoDetailUI.h(this.pIu);
        if ((localObject == null) || (((FrameLayout)localObject).getVisibility() != 0))
        {
          localObject = BizVideoDetailUI.i(this.pIu);
          kotlin.g.b.p.g(localObject, "videoWifiTipsView");
          if (((MPVideoWifiTipsView)localObject).getVisibility() != 0) {}
        }
        else
        {
          localObject = BizVideoDetailUI.j(this.pIu);
          kotlin.g.b.p.g(localObject, "videoAdTitleBar");
          ((LinearLayout)localObject).setVisibility(0);
        }
        BizVideoDetailUI.k(this.pIu).pHC.er(5, 0);
        BizVideoDetailUI.l(this.pIu);
        AppMethodBeat.o(7106);
        return;
        BizVideoDetailUI.f(this.pIu).setPageGestureInFullscreen(true);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$2", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "bufferResolutionStartTime", "", "getBufferResolutionStartTime", "()J", "setBufferResolutionStartTime", "(J)V", "bufferSeekStartTime", "getBufferSeekStartTime", "setBufferSeekStartTime", "hasBufferingResolution", "", "getHasBufferingResolution", "()Z", "setHasBufferingResolution", "(Z)V", "hasBufferingSeek", "getHasBufferingSeek", "setHasBufferingSeek", "playEnd", "getPlayEnd", "setPlayEnd", "startPlayTime", "getStartPlayTime", "setStartPlayTime", "startWaitTime", "getStartWaitTime", "setStartWaitTime", "onControlbarVisible", "", "visible", "onEndDragProgress", "onGetVideoSize", "width", "", "height", "onHideSwitchResolutionLayout", "onHideSwitchSpeedLayout", "onPlayError", "errorMsg", "", "errorCode", "onSeekPre", "onSeekTo", "time", "onStartDragProgress", "onUpdateProgress", "progressLen", "totalLen", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoPrepare", "firstRenderTime", "onVideoWaiting", "onVideoWaitingEnd", "resolutionBtnClick", "speedBtnClick", "switchResolution", "beforeType", "afterType", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "switchSpeed", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
  public static final class p
    implements MPVideoView.c
  {
    private long iJF = -1L;
    private long pIA = -1L;
    private boolean pIB;
    private boolean pIC;
    private long pIx = -1L;
    private boolean pIy;
    private long pIz = -1L;
    
    public final void BL(long paramLong)
    {
      AppMethodBeat.i(177795);
      BizVideoDetailUI.k(this.pIu).pHC.er(32, (int)paramLong);
      Log.v(BizVideoDetailUI.m(this.pIu), "[KEY_TIME] onVideoPrepare firstRenderTime = ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(177795);
    }
    
    public final void a(int paramInt1, int paramInt2, gh paramgh)
    {
      Object localObject2 = null;
      AppMethodBeat.i(175503);
      this.pIu.pIc = true;
      BizVideoDetailUI.k(this.pIu).pHC.pLH = paramInt1;
      BizVideoDetailUI.k(this.pIu).pHC.pLG = paramInt2;
      BizVideoDetailUI.k(this.pIu).pHC.er(22, 0);
      BizVideoDetailUI.d(this.pIu).aiS("21");
      BizVideoDetailUI.d(this.pIu).aiS("22");
      Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
      ff localff = BizVideoDetailUI.d(this.pIu).aiR("4");
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localff, "DefinitionBefore", String.valueOf(paramInt1));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localff, "DefinitionAfter", String.valueOf(paramInt2));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localff, "WidthBefore", String.valueOf(BizVideoDetailUI.k(this.pIu).pHC.width));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localff, "HeightBefore", String.valueOf(BizVideoDetailUI.k(this.pIu).pHC.height));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
      if (paramgh != null) {}
      for (localObject1 = Integer.valueOf(paramgh.width);; localObject1 = null)
      {
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localff, "WidthAfter", String.valueOf(localObject1));
        localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
        localObject1 = localObject2;
        if (paramgh != null) {
          localObject1 = Integer.valueOf(paramgh.height);
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localff, "HeightAfter", String.valueOf(localObject1));
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localff, BizVideoDetailUI.d(this.pIu));
        com.tencent.mm.plugin.webview.i.a.agn(81);
        this.pIA = System.currentTimeMillis();
        if (paramgh != null)
        {
          BizVideoDetailUI.k(this.pIu).pHr = paramgh.pHr;
          BizVideoDetailUI.k(this.pIu).pHs = paramgh.KKi;
          BizVideoDetailUI.k(this.pIu).pHC.width = paramgh.width;
          BizVideoDetailUI.k(this.pIu).pHC.height = paramgh.height;
        }
        BizVideoDetailUI.a(this.pIu, "switchVideo", "");
        AppMethodBeat.o(175503);
        return;
      }
    }
    
    public final void a(c.a parama1, c.a parama2)
    {
      AppMethodBeat.i(195890);
      BizVideoDetailUI.d(this.pIu).aiS("21");
      BizVideoDetailUI.d(this.pIu).aiS("22");
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
      ff localff = BizVideoDetailUI.d(this.pIu).aiR("19");
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
      if (parama1 != null)
      {
        localObject = String.valueOf(parama1.pNW);
        parama1 = (c.a)localObject;
        if (localObject != null) {}
      }
      else
      {
        parama1 = "";
      }
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localff, "SpeedBefore", parama1);
      parama1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
      if (parama2 != null)
      {
        parama2 = String.valueOf(parama2.pNW);
        parama1 = parama2;
        if (parama2 != null) {}
      }
      else
      {
        parama1 = "";
      }
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localff, "SpeedAfter", parama1);
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(localff, BizVideoDetailUI.d(this.pIu));
      AppMethodBeat.o(195890);
    }
    
    public final void aJq()
    {
      AppMethodBeat.i(195889);
      BizVideoDetailUI.a(this.pIu, "seekBegin", "");
      BizVideoDetailUI.d(this.pIu).aiS("21");
      BizVideoDetailUI.d(this.pIu).aiS("22");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(BizVideoDetailUI.d(this.pIu).aiR("20"), BizVideoDetailUI.d(this.pIu));
      AppMethodBeat.o(195889);
    }
    
    public final void aiG(String paramString)
    {
      AppMethodBeat.i(7117);
      kotlin.g.b.p.h(paramString, "errorMsg");
      BizVideoDetailUI.k(this.pIu).pHC.pLD = paramString;
      BizVideoDetailUI.k(this.pIu).pHC.er(11, 0);
      BizVideoDetailUI.p(this.pIu).setPlayError$505cff1c(paramString);
      BizVideoDetailUI.q(this.pIu);
      BizVideoDetailUI.a(this.pIu, "error", paramString);
      if (BizVideoDetailUI.f(this.pIu).getPlayStarted()) {
        com.tencent.mm.plugin.webview.i.a.agn(25);
      }
      for (;;)
      {
        BizVideoDetailUI.d(this.pIu).aiS("21");
        BizVideoDetailUI.d(this.pIu).aiS("22");
        Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
        localObject = BizVideoDetailUI.d(this.pIu).aiR("16");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((ff)localObject, "PlayErrReason", paramString);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((ff)localObject, BizVideoDetailUI.d(this.pIu));
        AppMethodBeat.o(7117);
        return;
        com.tencent.mm.plugin.webview.i.a.agn(24);
      }
    }
    
    public final void bJl()
    {
      AppMethodBeat.i(195888);
      BizVideoDetailUI.a(this.pIu, "seekBegin", "");
      BizVideoDetailUI.d(this.pIu).aiS("21");
      BizVideoDetailUI.d(this.pIu).aiS("22");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(BizVideoDetailUI.d(this.pIu).aiR("20"), BizVideoDetailUI.d(this.pIu));
      AppMethodBeat.o(195888);
    }
    
    public final void cqC()
    {
      AppMethodBeat.i(175502);
      i locali = this.pIu.pHU;
      MPVideoView localMPVideoView = BizVideoDetailUI.f(this.pIu);
      kotlin.g.b.p.h(localMPVideoView, "videoVideo");
      locali.pKX = localMPVideoView;
      if (!localMPVideoView.bJb()) {
        locali.cqZ();
      }
      AppMethodBeat.o(175502);
    }
    
    public final void cqD()
    {
      AppMethodBeat.i(7113);
      BizVideoDetailUI.k(this.pIu).pHC.er(12, 0);
      this.pIz = System.currentTimeMillis();
      BizVideoDetailUI.a(this.pIu, "seekEnd", "");
      AppMethodBeat.o(7113);
    }
    
    public final void cqE()
    {
      AppMethodBeat.i(7114);
      BizVideoDetailUI.k(this.pIu).pHC.er(13, 0);
      this.pIz = System.currentTimeMillis();
      BizVideoDetailUI.a(this.pIu, "seekEnd", "");
      AppMethodBeat.o(7114);
    }
    
    public final void cqF()
    {
      AppMethodBeat.i(7116);
      String str;
      if (this.pIC)
      {
        BizVideoDetailUI.k(this.pIu).pHC.ff((int)(System.currentTimeMillis() - this.pIx), 31);
        str = "3";
      }
      for (;;)
      {
        Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
        localObject = BizVideoDetailUI.d(this.pIu).aiR("17");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((ff)localObject, "BufferReason", str);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((ff)localObject, BizVideoDetailUI.d(this.pIu), String.valueOf(System.currentTimeMillis() - 500L));
        this.pIA = -1L;
        this.pIz = -1L;
        this.pIC = false;
        this.pIB = false;
        if (!BizVideoDetailUI.f(this.pIu).isPlaying()) {
          break;
        }
        BizVideoDetailUI.a(this.pIu, "play", "");
        AppMethodBeat.o(7116);
        return;
        if (this.pIB)
        {
          BizVideoDetailUI.k(this.pIu).pHC.ff((int)(System.currentTimeMillis() - this.pIx), 30);
          str = "2";
        }
        else
        {
          BizVideoDetailUI.k(this.pIu).pHC.ff((int)(System.currentTimeMillis() - this.pIx), 29);
          str = "1";
        }
      }
      BizVideoDetailUI.a(this.pIu, "pause", "");
      AppMethodBeat.o(7116);
    }
    
    public final void cqG()
    {
      AppMethodBeat.i(7119);
      BizVideoDetailUI.s(this.pIu);
      this.pIu.cqz();
      AppMethodBeat.o(7119);
    }
    
    public final void cqH()
    {
      AppMethodBeat.i(7121);
      BizVideoDetailUI.k(this.pIu).pHC.er(21, 0);
      this.pIu.pIc = true;
      this.pIu.cqo();
      com.tencent.mm.plugin.webview.i.a.agn(80);
      BizVideoDetailUI.a(this.pIu, 0L);
      AppMethodBeat.o(7121);
    }
    
    public final void cqI()
    {
      boolean bool = true;
      AppMethodBeat.i(175504);
      this.pIu.pIc = false;
      BizVideoDetailUI localBizVideoDetailUI;
      if ((this.pIu.pHZ) && (BizVideoDetailUI.f(this.pIu).isPlaying()))
      {
        localBizVideoDetailUI = this.pIu;
        if (BizVideoDetailUI.f(this.pIu).getCurrPosSec() <= 1) {
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
    
    public final void kq(boolean paramBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(7118);
      BizVideoDetailUI.r(this.pIu);
      if (paramBoolean)
      {
        BizVideoDetailUI.a(this.pIu, 0L);
        AppMethodBeat.o(7118);
        return;
      }
      BizVideoDetailUI localBizVideoDetailUI;
      if (this.pIu.pHZ)
      {
        localBizVideoDetailUI = this.pIu;
        if (BizVideoDetailUI.f(this.pIu).getCurrPosSec() <= 1) {
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
      BizVideoDetailUI.k(this.pIu).pHC.er(7, 0);
      BizVideoDetailUI.a(this.pIu, "ended", "");
      this.pIu.cqo();
      BizVideoDetailUI.o(this.pIu);
      if (!this.pIy)
      {
        this.pIy = true;
        com.tencent.mm.plugin.webview.i.a.agn(27);
      }
      AppMethodBeat.o(7112);
    }
    
    public final void onVideoPause()
    {
      AppMethodBeat.i(7111);
      if (BizVideoDetailUI.f(this.pIu).getPlayStatus() == 2) {
        BizVideoDetailUI.k(this.pIu).pHC.er(8, 0);
      }
      BizVideoDetailUI.a(this.pIu, "pause", "");
      BizVideoDetailUI.d(this.pIu).aiS("21");
      BizVideoDetailUI.d(this.pIu).aiR("22");
      AppMethodBeat.o(7111);
    }
    
    public final void onVideoPlay()
    {
      AppMethodBeat.i(7110);
      this.pIu.pIc = false;
      BizVideoDetailUI.k(this.pIu);
      int i = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.DQ(BizVideoDetailUI.f(this.pIu).getPlayStatus());
      BizVideoDetailUI.k(this.pIu).pHC.er(i, 0);
      BizVideoDetailUI.n(this.pIu);
      BizVideoDetailUI.a(this.pIu, "play", "");
      if (this.iJF < 0L)
      {
        com.tencent.mm.plugin.webview.i.a.agn(6);
        if (this.pIu.pIa) {
          com.tencent.mm.plugin.webview.i.a.agn(19);
        }
        this.iJF = System.currentTimeMillis();
      }
      Object localObject1;
      if ((this.pIu.pHZ) && (!this.pIu.pIc) && ((!BizVideoDetailUI.f(this.pIu).crD()) || (!BizVideoDetailUI.f(this.pIu).bJb())))
      {
        localObject1 = this.pIu;
        if (BizVideoDetailUI.f(this.pIu).getCurrPosSec() <= 1) {
          break label430;
        }
      }
      label430:
      for (boolean bool = true;; bool = false)
      {
        BizVideoDetailUI.b((BizVideoDetailUI)localObject1, bool);
        MMHandlerThread.postToMainThreadDelayed((Runnable)new BizVideoDetailUI.p.a(this), 300L);
        localObject1 = this.pIu.pHU;
        Object localObject2 = (kotlin.g.a.a)new BizVideoDetailUI.p.b(this);
        kotlin.g.b.p.h(localObject2, "onUpdateView");
        if ((((i)localObject1).pKU != 0) && (((i)localObject1).pLa <= 0) && (((i)localObject1).pKS == ((i)localObject1).mEX) && (((i)localObject1).pKR <= ((i)localObject1).pKV) && (!((i)localObject1).cqY()))
        {
          Object localObject3 = ((i)localObject1).pKX;
          if ((localObject3 != null) && (((MPVideoView)localObject3).isPlaying() == true))
          {
            ((i)localObject1).pKT = ((i)localObject1).bEm;
            localObject3 = ((i)localObject1).pLb;
            if (localObject3 != null) {
              ((ValueAnimator)localObject3).removeAllUpdateListeners();
            }
            ((i)localObject1).pLb = ValueAnimator.ofInt(new int[] { ((i)localObject1).pKR, ((i)localObject1).pKU });
            localObject3 = ((i)localObject1).pLb;
            if (localObject3 != null) {
              ((ValueAnimator)localObject3).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new i.f((i)localObject1, (kotlin.g.a.a)localObject2));
            }
            localObject2 = ((i)localObject1).pLb;
            if (localObject2 != null) {
              ((ValueAnimator)localObject2).setDuration(200L);
            }
            localObject1 = ((i)localObject1).pLb;
            if (localObject1 != null) {
              ((ValueAnimator)localObject1).start();
            }
          }
        }
        BizVideoDetailUI.d(this.pIu).aiS("22");
        BizVideoDetailUI.d(this.pIu).aiR("21");
        AppMethodBeat.o(7110);
        return;
      }
    }
    
    public final void onVideoWaiting()
    {
      AppMethodBeat.i(7115);
      if (this.iJF > 0L) {
        BizVideoDetailUI.n(this.pIu);
      }
      this.pIx = System.currentTimeMillis();
      BizVideoDetailUI.a(this.pIu, "waiting", "");
      if ((this.pIA != -1L) && ((int)(System.currentTimeMillis() - this.pIA) < 1000L)) {
        this.pIC = true;
      }
      for (;;)
      {
        BizVideoDetailUI.d(this.pIu).aiS("21");
        BizVideoDetailUI.d(this.pIu).aiS("22");
        BizVideoDetailUI.d(this.pIu).aiR("17");
        AppMethodBeat.o(7115);
        return;
        if ((this.pIz != -1L) && ((int)(System.currentTimeMillis() - this.pIz) < 1000L)) {
          this.pIB = true;
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7124);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (BizVideoDetailUI.f(this.pIu).isPlaying())
      {
        BizVideoDetailUI.f(this.pIu).pause();
        paramView = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.pLL;
        m.a.DR(37);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7124);
        return;
        BizVideoDetailUI.f(this.pIu).start();
        paramView = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.pLL;
        m.a.DR(38);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$onShowAd$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
  public static final class u
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(7126);
      Object localObject = BizVideoDetailUI.h(this.pIu);
      if (localObject != null)
      {
        localObject = ((FrameLayout)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      localObject = this.pIu.IBw;
      if (localObject != null) {
        ((com.tencent.mm.plugin.webview.d.h)localObject).aYd("appear");
      }
      localObject = this.pIu.pHV;
      if (localObject != null)
      {
        localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.webview.d.h)localObject).aYd("appear");
          AppMethodBeat.o(7126);
          return;
        }
      }
      AppMethodBeat.o(7126);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$onShowDot$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
  public static final class v
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(7127);
      Object localObject = BizVideoDetailUI.u(this.pIu);
      if (localObject != null)
      {
        localObject = ((FrameLayout)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      if (this.pIu.pHW != null)
      {
        Log.i(BizVideoDetailUI.m(this.pIu), "onShowDot appear");
        localObject = this.pIu.IBw;
        int i;
        MMWebViewWithJsApi localMMWebViewWithJsApi;
        if (localObject != null)
        {
          i = this.pIu.cqy();
          localMMWebViewWithJsApi = this.pIu.pHW;
          if (localMMWebViewWithJsApi == null) {
            kotlin.g.b.p.hyc();
          }
          ((com.tencent.mm.plugin.webview.d.h)localObject).P(i, localMMWebViewWithJsApi.hashCode(), "appear");
        }
        localObject = this.pIu.pHW;
        if (localObject != null)
        {
          localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
          if (localObject != null)
          {
            i = this.pIu.cqy();
            localMMWebViewWithJsApi = this.pIu.pHW;
            if (localMMWebViewWithJsApi == null) {
              kotlin.g.b.p.hyc();
            }
            ((com.tencent.mm.plugin.webview.d.h)localObject).P(i, localMMWebViewWithJsApi.hashCode(), "appear");
            AppMethodBeat.o(7127);
            return;
          }
        }
      }
      AppMethodBeat.o(7127);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$setTouchListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/LogoWebViewWrapper$MMOverScrollOffsetListener;", "onMMOverScrollOffset", "", "offset", "", "pointerDown", "", "onMMOverScrollUp", "plugin-brandservice_release"})
  public static final class x
    implements LogoWebViewWrapper.b
  {
    public final void aa(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(7129);
      Object localObject1 = this.pIu.cpw();
      Object localObject2 = this.pIu.cpw().getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(7129);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      ((FrameLayout.LayoutParams)localObject2).topMargin = (this.pIu.pHU.y - paramInt);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = BizVideoDetailUI.t(this.pIu);
      kotlin.g.b.p.g(localObject1, "animationLayout");
      if (((View)localObject1).getVisibility() == 0)
      {
        localObject1 = BizVideoDetailUI.t(this.pIu);
        kotlin.g.b.p.g(localObject1, "animationLayout");
        localObject2 = BizVideoDetailUI.t(this.pIu);
        kotlin.g.b.p.g(localObject2, "animationLayout");
        localObject2 = ((View)localObject2).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(7129);
          throw ((Throwable)localObject1);
        }
        localObject2 = (FrameLayout.LayoutParams)localObject2;
        ((FrameLayout.LayoutParams)localObject2).topMargin = (this.pIu.pHU.y - paramInt);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      AppMethodBeat.o(7129);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class y
    implements Runnable
  {
    y(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(175506);
      BizVideoDetailUI.a(this.pIu, 300L);
      AppMethodBeat.o(175506);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class z
    implements ValueAnimator.AnimatorUpdateListener
  {
    z(BizVideoDetailUI paramBizVideoDetailUI, z.d paramd) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(7133);
      if (BizVideoDetailUI.u(this.pIu) != null)
      {
        localFrameLayout = BizVideoDetailUI.u(this.pIu);
        if (localFrameLayout == null) {
          kotlin.g.b.p.hyc();
        }
        if (localFrameLayout.getVisibility() != 8) {}
      }
      else
      {
        AppMethodBeat.o(7133);
        return;
      }
      kotlin.g.b.p.g(paramValueAnimator, "valueAnimator");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(7133);
        throw paramValueAnimator;
      }
      int i = ((Integer)paramValueAnimator).intValue();
      FrameLayout localFrameLayout = BizVideoDetailUI.u(this.pIu);
      if (localFrameLayout != null)
      {
        paramValueAnimator = BizVideoDetailUI.u(this.pIu);
        if (paramValueAnimator != null) {}
        for (paramValueAnimator = paramValueAnimator.getLayoutParams(); paramValueAnimator == null; paramValueAnimator = null)
        {
          paramValueAnimator = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(7133);
          throw paramValueAnimator;
        }
        paramValueAnimator = (RelativeLayout.LayoutParams)paramValueAnimator;
        paramValueAnimator.bottomMargin = i;
        localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)paramValueAnimator);
      }
      if (i == this.pIF.SYE) {
        BizVideoDetailUI.l(this.pIu);
      }
      AppMethodBeat.o(7133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI
 * JD-Core Version:    0.7.0.1
 */