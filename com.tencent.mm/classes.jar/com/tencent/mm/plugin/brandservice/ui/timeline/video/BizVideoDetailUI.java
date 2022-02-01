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
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h.b;
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
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.protobuf.dr;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.protocal.protobuf.ev;
import com.tencent.mm.protocal.protobuf.fe;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import d.g.b.p;
import d.g.b.y.d;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/preload/api/IBizVideoPage;", "()V", "TAG", "", "adView", "Landroid/widget/FrameLayout;", "getAdView", "()Landroid/widget/FrameLayout;", "adView$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "adWebView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "getAdWebView", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "setAdWebView", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;)V", "adWebViewReady", "", "getAdWebViewReady", "()Z", "setAdWebViewReady", "(Z)V", "animationIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAnimationIv", "()Landroid/widget/ImageView;", "animationIv$delegate", "animationLayout", "Landroid/view/View;", "getAnimationLayout", "()Landroid/view/View;", "animationLayout$delegate", "appMsgGetResp", "Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;", "getAppMsgGetResp", "()Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;", "setAppMsgGetResp", "(Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;)V", "appmsgDone", "getAppmsgDone", "setAppmsgDone", "backgroundContainerView", "getBackgroundContainerView", "backgroundContainerView$delegate", "bizVideoDotHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotHelper;", "bizVideoPosHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "getBizVideoPosHelper", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "setBizVideoPosHelper", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;)V", "bizVideoProfiler", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "cgiCallback", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "commentUrl", "currentDot", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "density", "", "getDensity", "()F", "setDensity", "(F)V", "dotView", "getDotView", "dotView$delegate", "dotWebView", "getDotWebView", "setDotWebView", "dotWebViewReady", "getDotWebViewReady", "setDotWebViewReady", "fullscreenImpl", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenImpl;", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "getAppMsgDone", "getGetAppMsgDone", "setGetAppMsgDone", "hideWifiTipsBarAnim", "Landroid/view/animation/Animation;", "insertVideoDone", "getInsertVideoDone", "setInsertVideoDone", "isInFullScreen", "isNetworkConnected", "needShowWifiTipsView", "getNeedShowWifiTipsView", "setNeedShowWifiTipsView", "networkListener", "Landroid/content/BroadcastReceiver;", "orientationHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper;", "playState", "getPlayState", "()Ljava/lang/String;", "setPlayState", "(Ljava/lang/String;)V", "setFullScreen", "showWifiTipsBarAnim", "showWifiTipsMode", "simcardTpye", "", "switchVideo", "getSwitchVideo", "setSwitchVideo", "switchingResolution", "getSwitchingResolution", "setSwitchingResolution", "titleBarHeight", "uin", "videoAdTitleBack", "getVideoAdTitleBack", "videoAdTitleBack$delegate", "videoAdTitleBar", "Landroid/widget/LinearLayout;", "getVideoAdTitleBar", "()Landroid/widget/LinearLayout;", "videoAdTitleBar$delegate", "videoControlBarHeight", "videoErrView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "getVideoErrView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "videoErrView$delegate", "videoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoView", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "videoView$delegate", "videoViewContainer", "getVideoViewContainer", "videoViewContainer$delegate", "videoWifiTipsView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "getVideoWifiTipsView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "videoWifiTipsView$delegate", "waitToDetroyTime", "", "adWebviewReady", "", "bundle", "Landroid/os/Bundle;", "checkInitOrientationHelper", "w", "h", "closeAdWebview", "closeDotWebview", "createAdWebview", "createDotWebview", "id", "url", "destroyDotWebView", "destroyWebView", "doOnDestroy", "doPlayVideo", "resp", "dotWebviewReady", "enableMinimize", "enableOrientationListener", "enable", "getCurrentDotId", "getCurrentPlayTime", "getForceOrientation", "getFullscreenImpl", "getLastPlayTimeKey", "getMPVideoState", "getMarginValue", "value", "", "fullValue", "getSimCardType", "goneVideoErrorView", "hideCoverLayout", "hideDotWebview", "hideVideoTitleBar", "hideWifiTipsView", "delay", "init", "initActionBar", "initComment", "initControlAreaHeight", "initDensity", "wv", "Lcom/tencent/mm/ui/widget/MMWebView;", "initOrientationHelper", "initReportParams", "initVideoParam", "initVideoView", "initView", "initWebviewSetting", "webview", "insertVideoNativeView", "params", "", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAppMsgGet", "onBackPressed", "onDestroy", "onDestroyReport", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onMPVideoStateChange", "state", "errMsg", "onPageFinished", "view", "Lcom/tencent/xweb/WebView;", "onPageReady", "onPause", "onReset", "onResetAfterCreate", "onResetBeforeCreate", "onResume", "onShowAd", "onShowDot", "onStart", "onWebViewScrollChanged", "scrollY", "opPlayer", "postBinded", "sendMPPageData", "setDotScriptData", "setTouchListener", "shouldShowWifiTips", "duration", "netChange", "showCoverLayout", "showVideoErrorView", "showWifiTipsView", "startMonitorNetWorkChange", "stopMonitorNetWorkChange", "updateDot", "updateDotAttr", "posInfo", "webviewId", "updateDotPos", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotPosInfo;", "updateDotPosIfNeed", "updateVideoPosition", "plugin-brandservice_release"})
public class BizVideoDetailUI
  extends TmplShareWebViewToolUI
  implements com.tencent.mm.plugin.webview.g.a.a
{
  private final String TAG;
  private float density;
  private String fkq;
  private boolean jBC;
  private final IPCRunCgi.a kfc;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o ooA;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o ooB;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o ooC;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o ooD;
  private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h ooE;
  private com.tencent.mm.plugin.brandservice.ui.widget.a ooF;
  private int ooG;
  com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i ooH;
  MMWebViewWithJsApi ooI;
  MMWebViewWithJsApi ooJ;
  private boolean ooK;
  private boolean ooL;
  boolean ooM;
  boolean ooN;
  boolean ooO;
  boolean ooP;
  private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c ooQ;
  private com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b ooR;
  private boolean ooS;
  private final j.a ooT;
  private String ooU;
  private boolean ooV;
  private boolean ooW;
  private fg ooX;
  private Animation ooY;
  private Animation ooZ;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o oot;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o oou;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o oov;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o oow;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o oox;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o ooy;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.o ooz;
  private com.tencent.mm.plugin.brandservice.ui.widget.b opa;
  private long opb;
  private int opc;
  private int opd;
  private BroadcastReceiver ope;
  private boolean opf;
  private boolean opg;
  private int uin;
  
  static
  {
    AppMethodBeat.i(7140);
    cwV = new d.l.k[] { (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "animationIv", "getAnimationIv()Landroid/widget/ImageView;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "animationLayout", "getAnimationLayout()Landroid/view/View;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "videoView", "getVideoView()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "adView", "getAdView()Landroid/widget/FrameLayout;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "dotView", "getDotView()Landroid/widget/FrameLayout;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "backgroundContainerView", "getBackgroundContainerView()Landroid/widget/FrameLayout;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "videoErrView", "getVideoErrView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "videoWifiTipsView", "getVideoWifiTipsView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "videoAdTitleBar", "getVideoAdTitleBar()Landroid/widget/LinearLayout;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "videoAdTitleBack", "getVideoAdTitleBack()Landroid/view/View;")), (d.l.k)d.g.b.z.a(new d.g.b.x(d.g.b.z.bp(BizVideoDetailUI.class), "videoViewContainer", "getVideoViewContainer()Landroid/widget/FrameLayout;")) };
    AppMethodBeat.o(7140);
  }
  
  public BizVideoDetailUI()
  {
    AppMethodBeat.i(7216);
    this.TAG = "MicroMsg.BizVideoDetailUI";
    this.oot = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new b(this));
    this.oou = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new c(this));
    this.oov = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new ad(this));
    this.oow = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new a(this));
    this.oox = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new j(this));
    this.ooy = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new d(this));
    this.ooz = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new ac(this));
    this.ooA = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new af(this));
    this.ooB = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new ab(this));
    this.ooC = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new aa(this));
    this.ooD = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new ae(this));
    this.ooH = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i();
    this.ooR = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b();
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
    this.ooT = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.XV(toString());
    this.ooU = "";
    this.fkq = "";
    this.opa = ((com.tencent.mm.plugin.brandservice.ui.widget.b)new k(this));
    this.opc = -1;
    this.opd = -1;
    this.kfc = ((IPCRunCgi.a)new e(this));
    this.opf = true;
    AppMethodBeat.o(7216);
  }
  
  private final boolean R(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(175519);
    if ((com.tencent.mm.sdk.platformtools.i.DEBUG) && (this.opg))
    {
      AppMethodBeat.o(175519);
      return true;
    }
    if (!ay.isNetworkConnected(aj.getContext()))
    {
      AppMethodBeat.o(175519);
      return false;
    }
    if (bRo().getPlayStatus() == 4)
    {
      ad.i(this.TAG, "not show WifiTips, play end!");
      AppMethodBeat.o(175519);
      return false;
    }
    if ((paramInt > 0) && (bRo().getCacheTimeSec() >= paramInt))
    {
      ad.i(this.TAG, "not show WifiTips, video cached! " + bRo().getCacheTimeSec() + '/' + bRo().getDuration());
      AppMethodBeat.o(175519);
      return false;
    }
    if (this.onk.oof)
    {
      ad.i(this.TAG, "not show WifiTips, has show!");
      AppMethodBeat.o(175519);
      return false;
    }
    if (paramBoolean)
    {
      localObject = MPVideoWifiTipsView.opW;
      if (!MPVideoWifiTipsView.a.zX(this.onk.ooe))
      {
        AppMethodBeat.o(175519);
        return false;
      }
    }
    else
    {
      localObject = MPVideoWifiTipsView.opW;
      if (!MPVideoWifiTipsView.a.zV(this.onk.ooe))
      {
        localObject = MPVideoWifiTipsView.opW;
        if (!MPVideoWifiTipsView.a.zW(this.onk.ooe))
        {
          AppMethodBeat.o(175519);
          return false;
        }
      }
    }
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.ory;
    if (!com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.y(ay.isWifi(aj.getContext()), this.ooG))
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
    Object localObject = this.ooQ;
    if (localObject == null) {
      p.gfZ();
    }
    if (!((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).oqs.gEz)
    {
      AppMethodBeat.o(7204);
      return;
    }
    bRL();
    FrameLayout localFrameLayout = bRq();
    if (localFrameLayout != null)
    {
      localObject = bRq();
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
      if (this.jBC)
      {
        i = com.tencent.mm.cc.a.ip((Context)getContext());
        if (!this.jBC) {
          break label485;
        }
        j = com.tencent.mm.cc.a.iq((Context)getContext());
        k = j - this.opd - this.opc;
        j = k;
        if (!this.jBC)
        {
          if (bRo().bSD()) {
            break label496;
          }
          localc = this.ooQ;
          if (localc == null) {
            p.gfZ();
          }
          localc.oqo = false;
          j = k + this.opc;
        }
        label237:
        k = a(paramd.oqz, j);
        if (k < this.opc)
        {
          localc = this.ooQ;
          if (localc == null) {
            p.gfZ();
          }
          localc.oqp = true;
        }
        ((RelativeLayout.LayoutParams)localObject).leftMargin = a(paramd.oqw, i);
        ((RelativeLayout.LayoutParams)localObject).topMargin = (a(paramd.oqx, j) + this.opd);
        ((RelativeLayout.LayoutParams)localObject).rightMargin = a(paramd.oqy, i);
        localc = this.ooQ;
        if (localc == null) {
          p.gfZ();
        }
        if ((!localc.oqo) && (!this.jBC)) {
          break label522;
        }
        i = this.opc;
        label358:
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = (i + k);
        if (!paramd.oqC) {
          break label527;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
        label382:
        if (!paramd.oqE) {
          break label537;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
        label397:
        if (!paramd.oqD) {
          break label547;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        label412:
        if (!paramd.oqF) {
          break label557;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        label427:
        if (!paramd.oqA) {
          break label567;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
        label442:
        if (!paramd.oqB) {
          break label577;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(14, -1);
      }
      for (;;)
      {
        localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(7204);
        return;
        i = this.ooH.oqS;
        break;
        label485:
        j = this.ooH.oqR;
        break label176;
        label496:
        localc = this.ooQ;
        if (localc == null) {
          p.gfZ();
        }
        localc.oqo = true;
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
        localz.gba();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.setDatabasePath(com.tencent.mm.loader.j.b.arL() + "databases/");
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.gbd();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.gbb();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.gaZ();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      localz = paramMMWebViewWithJsApi.getSettings();
      if (localz != null) {
        localz.gaY();
      }
    }
    if (paramMMWebViewWithJsApi != null)
    {
      paramMMWebViewWithJsApi.setOnLongClickListener((View.OnLongClickListener)BizVideoDetailUI.t.opr);
      AppMethodBeat.o(7196);
      return;
    }
    AppMethodBeat.o(7196);
  }
  
  private boolean aG(int paramInt, String paramString)
  {
    AppMethodBeat.i(7202);
    p.h(paramString, "url");
    if (isFinishing())
    {
      AppMethodBeat.o(7202);
      return false;
    }
    if (this.ooJ != null)
    {
      ad.w(this.TAG, "createDotWebview dotWebView existed!");
      AppMethodBeat.o(7202);
      return false;
    }
    com.tencent.mm.plugin.webview.h.a.WZ(57);
    this.ooL = false;
    Object localObject = a.onR;
    localObject = MMWebViewWithJsApi.a.gY((Context)getContext());
    p.g(localObject, "MMWebViewWithJsApi.Factory.create(this.context)");
    this.ooJ = a.a((MMWebViewWithJsApi)localObject, bQK(), (d.g.a.m)new h(this), (d.g.a.m)new i(this), aGo(bQJ().VS()));
    d((MMWebView)this.ooJ);
    a(this.ooJ);
    localObject = bRq();
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = bRr();
    if (localObject != null) {
      ((FrameLayout)localObject).addView((View)this.ooJ);
    }
    bRL();
    int i = this.ooH.height;
    int j = this.opc;
    int k = this.opd;
    paramString = UrlExKt.appendUrlParam(paramString, "dotId", String.valueOf(paramInt));
    localObject = this.ooJ;
    if (localObject == null) {
      p.gfZ();
    }
    paramString = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(paramString, "dotWebviewId", String.valueOf(((MMWebViewWithJsApi)localObject).hashCode())), "dotMinShowHeight", String.valueOf(i - j - k));
    ad.i(this.TAG, "createDotWebview dotView dotUrl=".concat(String.valueOf(paramString)));
    localObject = this.ooJ;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).loadUrl(paramString);
    }
    paramString = this.ooJ;
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
    Object localObject1 = com.tencent.mm.plugin.brandservice.ui.widget.c.otD;
    com.tencent.mm.plugin.brandservice.ui.widget.c.bSz();
    this.ooX = paramfg;
    ad.i(this.TAG, "doPlayVideo getAppMsgDone: " + this.ooV + ", insertVideoDone: " + this.ooW);
    if ((!this.ooV) || (!this.ooW))
    {
      AppMethodBeat.o(175514);
      return;
    }
    localObject1 = this.onk.ooo;
    Object localObject2 = paramfg.Fxo;
    p.g(localObject2, "resp.url_info");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject1).J((LinkedList)localObject2);
    com.tencent.mm.plugin.webview.h.a.WZ(23);
    localObject1 = paramfg.Fxo;
    p.g(localObject1, "resp.url_info");
    localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.k.I((LinkedList)localObject1);
    if (localObject1 == null)
    {
      AppMethodBeat.o(175514);
      return;
    }
    this.onk.ooo.orG = ((fu)localObject1).Fyb;
    this.onk.ood = ((fu)localObject1).ood;
    this.onk.ooe = ((fu)localObject1).Fyd;
    ad.i(this.TAG, "doPlayVideo filesize=" + this.onk.ood + " wifiTipsFlag=" + this.onk.ooe);
    boolean bool;
    int i;
    if ((paramfg.Fxs & 0x1) != 0)
    {
      bool = true;
      if ((eSw() == null) || (!eSw().bKz())) {
        break label725;
      }
      localObject2 = eSw();
      p.g(localObject2, "webViewFloatBallHelper");
      i = ((com.tencent.mm.plugin.webview.ui.tools.floatball.a)localObject2).eTI();
      label295:
      bRo().setInitialTime(i * 1000);
      localObject2 = paramfg.FxA;
      if (localObject2 != null)
      {
        bRo().a(((dr)localObject2).bDT, ((dr)localObject2).bDX, ((dr)localObject2).FvT, ((dr)localObject2).FvU, ((dr)localObject2).lrc, ((dr)localObject2).lrd);
        ad.i(this.TAG, "maxInitBitrate = " + ((dr)localObject2).bDT + ", bandFraction = " + ((dr)localObject2).bDX + ", minDur = " + ((dr)localObject2).FvT + ", maxDur = " + ((dr)localObject2).FvU + ", minBuffer = " + ((dr)localObject2).lrc + ", maxBuffer = " + ((dr)localObject2).lrd);
      }
      this.ooM = false;
      if (!R(((fu)localObject1).FxY / 1000, false)) {
        break label744;
      }
      if (!bool) {
        break label736;
      }
      jo(false);
    }
    for (;;)
    {
      bRo().setAutoPlay(bool);
      if (!bool) {
        bRF();
      }
      this.onk.ooo.width = ((fu)localObject1).width;
      this.onk.ooo.height = ((fu)localObject1).height;
      localObject2 = bRo();
      String str = ((fu)localObject1).url;
      p.g(str, "urlInfo.url");
      ((MPVideoView)localObject2).cD(str, ((fu)localObject1).FxY / 1000);
      localObject2 = bRo();
      i = j;
      if (((fu)localObject1).width > ((fu)localObject1).height) {
        i = 90;
      }
      ((MPVideoView)localObject2).setFullScreenDirection(i);
      eQ(((fu)localObject1).width, ((fu)localObject1).height);
      if ((((fu)localObject1).width > 0) && (((fu)localObject1).height > 0) && (bQJ().hDg.videoWidth <= 0) && (bQJ().hDg.videoHeight <= 0))
      {
        bQJ().hDg.videoWidth = ((fu)localObject1).width;
        bQJ().hDg.videoHeight = ((fu)localObject1).height;
      }
      localObject2 = bRo();
      paramfg = paramfg.Fxo;
      p.g(paramfg, "resp.url_info");
      ((MPVideoView)localObject2).a(paramfg, (fu)localObject1);
      AppMethodBeat.o(175514);
      return;
      bool = false;
      break;
      label725:
      i = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.XZ(bRE());
      break label295;
      label736:
      this.ooM = true;
      continue;
      label744:
      ts(0L);
    }
  }
  
  private void bRB()
  {
    AppMethodBeat.i(210102);
    if (bRo().isPlaying()) {
      bRo().bSA();
    }
    eS("leavePage", "");
    this.ooT.report();
    this.onk.ooo.orB = bRo().getEndPlayTime();
    if (this.onm != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.mbn;
      this.mbn = (l1 - this.onn + l2);
      this.onk.ooo.orC = ((int)(this.mbn / 1000L));
    }
    this.onk.ooo.orA = ((int)bRo().getRealPlayTime());
    this.onk.ooo.ed(2, 0);
    if (!this.ooO)
    {
      com.tencent.mm.plugin.webview.h.a.WZ(22);
      AppMethodBeat.o(210102);
      return;
    }
    if ((bRo().getPlayStart()) && (!bRo().getPlayStarted())) {
      com.tencent.mm.plugin.webview.h.a.WZ(26);
    }
    AppMethodBeat.o(210102);
  }
  
  private void bRC()
  {
    AppMethodBeat.i(7183);
    if (this.ooI == null)
    {
      AppMethodBeat.o(7183);
      return;
    }
    Object localObject = this.DzP;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.c.f)localObject).aGH("disappear");
    }
    localObject = this.DzP;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.c.f)localObject).aGH("destroy");
    }
    localObject = bRp();
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = bRp();
    if (localObject != null) {
      ((FrameLayout)localObject).removeView((View)this.ooI);
    }
    localObject = this.ooI;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getCurWebviewClient();
      if (!(localObject instanceof com.tencent.mm.plugin.webview.ui.tools.widget.k)) {
        break label162;
      }
      localObject = this.ooI;
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
    localObject = this.ooI;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).destroy();
    }
    localObject = this.ooI;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebChromeClient(null);
    }
    localObject = this.ooI;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebViewClient(null);
    }
    localObject = this.ooI;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnTouchListener(null);
    }
    localObject = this.ooI;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnLongClickListener(null);
    }
    localObject = this.ooI;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setVisibility(8);
    }
    localObject = this.ooI;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).removeAllViews();
    }
    localObject = this.ooI;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).clearView();
    }
    this.ooI = null;
    this.ooK = false;
    bRI();
    AppMethodBeat.o(7183);
  }
  
  private final String bRE()
  {
    AppMethodBeat.i(7188);
    String str = bQJ().VS() + '_' + this.uin + '_' + this.onk.hzm;
    AppMethodBeat.o(7188);
    return str;
  }
  
  private final void bRF()
  {
    AppMethodBeat.i(175515);
    View localView = bRn();
    p.g(localView, "animationLayout");
    localView.setVisibility(8);
    AppMethodBeat.o(175515);
  }
  
  private final void bRG()
  {
    AppMethodBeat.i(7189);
    MPVideoErrorView localMPVideoErrorView = bRs();
    p.g(localMPVideoErrorView, "videoErrView");
    if (localMPVideoErrorView.getVisibility() == 0)
    {
      localMPVideoErrorView = bRs();
      p.g(localMPVideoErrorView, "videoErrView");
      localMPVideoErrorView.setVisibility(8);
      eQ(this.ooH.width, this.ooH.height);
    }
    AppMethodBeat.o(7189);
  }
  
  private final void bRH()
  {
    AppMethodBeat.i(7190);
    MPVideoErrorView localMPVideoErrorView = bRs();
    p.g(localMPVideoErrorView, "videoErrView");
    localMPVideoErrorView.setVisibility(0);
    jn(false);
    AppMethodBeat.o(7190);
  }
  
  private final void bRI()
  {
    AppMethodBeat.i(7193);
    Object localObject = bRp();
    if (localObject != null)
    {
      if (((FrameLayout)localObject).getVisibility() == 8)
      {
        localObject = bRt();
        p.g(localObject, "videoWifiTipsView");
        if (((MPVideoWifiTipsView)localObject).getVisibility() == 8)
        {
          localObject = bRu();
          p.g(localObject, "videoAdTitleBar");
          ((LinearLayout)localObject).setVisibility(8);
        }
      }
      AppMethodBeat.o(7193);
      return;
    }
    AppMethodBeat.o(7193);
  }
  
  private final void bRJ()
  {
    AppMethodBeat.i(7203);
    if (this.ooQ != null)
    {
      Object localObject = bRq();
      if (localObject == null) {
        break label56;
      }
      if (((FrameLayout)localObject).getVisibility() == 0)
      {
        localObject = this.ooQ;
        if (localObject == null) {
          p.gfZ();
        }
        a(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).oqs);
      }
    }
    AppMethodBeat.o(7203);
    return;
    label56:
    AppMethodBeat.o(7203);
  }
  
  private final void bRK()
  {
    AppMethodBeat.i(7205);
    Object localObject1;
    if ((bRq() != null) && (this.ooQ != null))
    {
      localObject1 = this.ooQ;
      if (localObject1 == null) {
        p.gfZ();
      }
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject1).oqp) {}
    }
    else
    {
      AppMethodBeat.o(7205);
      return;
    }
    ad.i(this.TAG, "updateDotPosIfNeed");
    int i;
    Object localObject2;
    if (!this.jBC)
    {
      localObject1 = bRq();
      if (localObject1 != null) {}
      for (localObject1 = ((FrameLayout)localObject1).getLayoutParams(); localObject1 == null; localObject1 = null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(7205);
        throw ((Throwable)localObject1);
      }
      i = ((RelativeLayout.LayoutParams)localObject1).bottomMargin;
      localObject1 = new y.d();
      ((y.d)localObject1).MLT = i;
      if (!bRo().bSD()) {
        break label228;
      }
      localObject2 = this.ooQ;
      if (localObject2 == null) {
        p.gfZ();
      }
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).oqo) {
        break label228;
      }
    }
    for (((y.d)localObject1).MLT += this.opc;; ((y.d)localObject1).MLT -= this.opc)
    {
      localObject2 = ValueAnimator.ofInt(new int[] { i, ((y.d)localObject1).MLT });
      ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new z(this, (y.d)localObject1));
      p.g(localObject2, "va");
      ((ValueAnimator)localObject2).setDuration(200L);
      ((ValueAnimator)localObject2).start();
      AppMethodBeat.o(7205);
      return;
      label228:
      if (bRo().bSD()) {
        break;
      }
      localObject2 = this.ooQ;
      if (localObject2 == null) {
        p.gfZ();
      }
      if (!((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).oqo) {
        break;
      }
    }
    AppMethodBeat.o(7205);
  }
  
  private final void bRL()
  {
    AppMethodBeat.i(7206);
    if (this.opc < 0)
    {
      this.opc = com.tencent.mm.cc.a.ax((Context)getContext(), 2131166589);
      this.opd = ar.dT((Context)getContext());
    }
    AppMethodBeat.o(7206);
  }
  
  private final void bRM()
  {
    AppMethodBeat.i(7207);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onShowDot ready: ").append(this.ooL).append(", hasWebView: ");
    if (this.ooJ != null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i((String)localObject, bool);
      if ((this.ooL) && (this.ooJ != null)) {
        break;
      }
      AppMethodBeat.o(7207);
      return;
    }
    com.tencent.mm.plugin.webview.h.a.WZ(60);
    localObject = bRq();
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = bRr();
    if (localObject != null) {
      ((FrameLayout)localObject).removeView((View)this.ooJ);
    }
    localObject = bRq();
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = bRq();
    if (localObject != null) {
      ((FrameLayout)localObject).addView((View)this.ooJ);
    }
    localObject = bRq();
    if (localObject != null)
    {
      localObject = ((FrameLayout)localObject).getViewTreeObserver();
      if (localObject != null) {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new v(this));
      }
    }
    localObject = this.ooQ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).oqn = true;
    }
    localObject = this.ooQ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).oqq = true;
    }
    bRK();
    AppMethodBeat.o(7207);
  }
  
  private final void bRP()
  {
    AppMethodBeat.i(175518);
    if (this.ope != null)
    {
      getContext().unregisterReceiver(this.ope);
      this.ope = null;
    }
    AppMethodBeat.o(175518);
  }
  
  private final View bRn()
  {
    AppMethodBeat.i(7143);
    View localView = (View)this.oou.a(cwV[1]);
    AppMethodBeat.o(7143);
    return localView;
  }
  
  private final MPVideoView bRo()
  {
    AppMethodBeat.i(7145);
    MPVideoView localMPVideoView = (MPVideoView)this.oov.a(cwV[2]);
    AppMethodBeat.o(7145);
    return localMPVideoView;
  }
  
  private final FrameLayout bRp()
  {
    AppMethodBeat.i(7146);
    FrameLayout localFrameLayout = (FrameLayout)this.oow.a(cwV[3]);
    AppMethodBeat.o(7146);
    return localFrameLayout;
  }
  
  private final FrameLayout bRq()
  {
    AppMethodBeat.i(7147);
    FrameLayout localFrameLayout = (FrameLayout)this.oox.a(cwV[4]);
    AppMethodBeat.o(7147);
    return localFrameLayout;
  }
  
  private final FrameLayout bRr()
  {
    AppMethodBeat.i(7148);
    FrameLayout localFrameLayout = (FrameLayout)this.ooy.a(cwV[5]);
    AppMethodBeat.o(7148);
    return localFrameLayout;
  }
  
  private final MPVideoErrorView bRs()
  {
    AppMethodBeat.i(7149);
    MPVideoErrorView localMPVideoErrorView = (MPVideoErrorView)this.ooz.a(cwV[6]);
    AppMethodBeat.o(7149);
    return localMPVideoErrorView;
  }
  
  private final MPVideoWifiTipsView bRt()
  {
    AppMethodBeat.i(7150);
    MPVideoWifiTipsView localMPVideoWifiTipsView = (MPVideoWifiTipsView)this.ooA.a(cwV[7]);
    AppMethodBeat.o(7150);
    return localMPVideoWifiTipsView;
  }
  
  private final LinearLayout bRu()
  {
    AppMethodBeat.i(7151);
    LinearLayout localLinearLayout = (LinearLayout)this.ooB.a(cwV[8]);
    AppMethodBeat.o(7151);
    return localLinearLayout;
  }
  
  private final FrameLayout bRv()
  {
    AppMethodBeat.i(7152);
    FrameLayout localFrameLayout = (FrameLayout)this.ooD.a(cwV[10]);
    AppMethodBeat.o(7152);
    return localFrameLayout;
  }
  
  private final int bRx()
  {
    AppMethodBeat.i(175507);
    if (this.lvv == null)
    {
      i = this.ooG;
      AppMethodBeat.o(175507);
      return i;
    }
    try
    {
      Bundle localBundle = this.lvv.k(110, new Bundle());
      if (localBundle != null) {
        this.ooG = localBundle.getInt("sim_card_type", 0);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.w(this.TAG, "invoker ex :" + localException.getMessage());
      }
    }
    int i = this.ooG;
    AppMethodBeat.o(175507);
    return i;
  }
  
  private final void bRy()
  {
    AppMethodBeat.i(175509);
    View localView = bRn();
    p.g(localView, "animationLayout");
    if (localView.getVisibility() == 0)
    {
      localView = bRn();
      p.g(localView, "animationLayout");
      dG(localView);
    }
    dG((View)bQL());
    bRJ();
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
    this.ooH.dG(paramView);
    AppMethodBeat.o(175510);
  }
  
  private final void eQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7167);
    if (paramInt1 > paramInt2)
    {
      Object localObject1;
      if (this.ooE != null)
      {
        localObject1 = this.ooE;
        if (localObject1 != null)
        {
          Object localObject2 = getContext();
          p.g(localObject2, "context");
          localObject2 = (Context)localObject2;
          MPVideoView localMPVideoView = bRo();
          p.h(localObject2, "ctx");
          p.h(localMPVideoView, "video");
          ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h)localObject1).ktm = new WeakReference(localObject2);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h)localObject1).oqJ = new WeakReference(localMPVideoView);
        }
      }
      for (;;)
      {
        jn(true);
        AppMethodBeat.o(7167);
        return;
        localObject1 = getContext();
        p.g(localObject1, "context");
        this.ooE = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h((Context)localObject1, bRo());
      }
    }
    jn(false);
    AppMethodBeat.o(7167);
  }
  
  private final void eS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210103);
    if (bt.lQ(this.ooU, paramString1))
    {
      AppMethodBeat.o(210103);
      return;
    }
    ad.d(this.TAG, "onMPVideoStateChange ".concat(String.valueOf(paramString1)));
    Object localObject = this.DzP;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.c.f)localObject).f(paramString1, this.onk.hzm, paramString2, String.valueOf(bRo().getCurrPosSec()), String.valueOf(bRo().getRealPlayTime() / 1000L));
    }
    localObject = this.ooI;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
      if (localObject != null) {
        ((com.tencent.mm.plugin.webview.c.f)localObject).f(paramString1, this.onk.hzm, paramString2, String.valueOf(bRo().getCurrPosSec()), String.valueOf(bRo().getRealPlayTime() / 1000L));
      }
    }
    this.ooU = paramString1;
    AppMethodBeat.o(210103);
  }
  
  private final void jo(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(7191);
    if (!R(bRo().getDuration(), paramBoolean))
    {
      ad.i(this.TAG, "showWifiTipsView should not show now");
      AppMethodBeat.o(7191);
      return;
    }
    ad.i(this.TAG, "showWifiTipsView ".concat(String.valueOf(paramBoolean)));
    com.tencent.mm.plugin.webview.h.a.WZ(16);
    Object localObject;
    int i;
    if (!paramBoolean)
    {
      localObject = MPVideoWifiTipsView.opW;
      if (MPVideoWifiTipsView.a.zW(this.onk.ooe))
      {
        i = 2;
        this.onk.ooo.orI = i;
        this.onk.ooo.ed(14, 0);
        localObject = this.onk;
        if (!paramBoolean) {
          break label264;
        }
      }
    }
    for (;;)
    {
      ((b)localObject).zU(j);
      this.onk.oof = true;
      this.ooM = false;
      bRt().q(this.onk.ood, i);
      if (this.ooY == null)
      {
        this.ooY = AnimationUtils.loadAnimation((Context)getContext(), 2130772105);
        localObject = this.ooY;
        if (localObject != null) {
          ((Animation)localObject).setDuration(300L);
        }
      }
      bRt().clearAnimation();
      bRt().startAnimation(this.ooY);
      localObject = bRt();
      p.g(localObject, "videoWifiTipsView");
      ((MPVideoWifiTipsView)localObject).setVisibility(0);
      aq.o((Runnable)new y(this), 3000L);
      AppMethodBeat.o(7191);
      return;
      i = 1;
      break;
      label264:
      j = 1;
    }
  }
  
  private final void ts(long paramLong)
  {
    AppMethodBeat.i(175516);
    Object localObject = bRt();
    p.g(localObject, "videoWifiTipsView");
    if (((MPVideoWifiTipsView)localObject).getVisibility() != 8)
    {
      if (paramLong > 0L)
      {
        if (this.ooZ == null)
        {
          this.ooZ = AnimationUtils.loadAnimation((Context)getContext(), 2130772109);
          localObject = this.ooZ;
          if (localObject != null) {
            ((Animation)localObject).setDuration(paramLong);
          }
        }
        bRt().clearAnimation();
        bRt().startAnimation(this.ooZ);
      }
      aq.o((Runnable)new l(this), paramLong);
    }
    AppMethodBeat.o(175516);
  }
  
  public final void R(Bundle paramBundle)
  {
    AppMethodBeat.i(7172);
    if (this.jBC) {
      bRo().p(false, 0);
    }
    this.ooT.XY("21");
    this.ooT.XY("22");
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.ooT.XX("3"), this.ooT);
    bRC();
    bRD();
    jn(false);
    super.R(paramBundle);
    com.tencent.mm.plugin.webview.h.a.WZ(18);
    this.ooN = true;
    AppMethodBeat.o(7172);
  }
  
  public final void S(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(175512);
    p.h(paramMap, "params");
    ad.i(this.TAG, "insertVideoNativeView");
    Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.ooT.XX("8"), this.ooT);
    Object localObject2 = this.ooT;
    localObject1 = this.onO;
    Object localObject3;
    float f1;
    float f2;
    boolean bool;
    label892:
    int i;
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((BaseWebViewController)localObject1).DGl;
      localObject3 = (r)localObject1;
      if (localObject3 != null)
      {
        localObject1 = (d.g.a.b)j.a.a.oru;
        long l5 = ((r)localObject3).aLo("getA8KeyStart");
        long l6 = ((r)localObject3).aLo("getA8KeyEnd");
        long l3 = ((r)localObject3).aLo("onPageStarted");
        long l2 = ((r)localObject3).aLo("onPageFinished");
        long l4 = ((r)localObject3).aLo("firstScreenTimestamp");
        long l7 = ((r)localObject3).aLo("firstScreenTime");
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
        LinkedList localLinkedList = ((es)localObject3).FsS;
        ev localev = new ev();
        localev.key = "EventType";
        localev.hHZ = "6";
        localLinkedList.add(localev);
        localLinkedList = ((es)localObject3).FsS;
        localev = new ev();
        localev.key = "StartTime";
        localev.hHZ = ((String)((d.g.a.b)localObject1).invoke(Long.valueOf(l5)));
        localLinkedList.add(localev);
        localLinkedList = ((es)localObject3).FsS;
        localev = new ev();
        localev.key = "EndTime";
        localev.hHZ = ((String)((d.g.a.b)localObject1).invoke(Long.valueOf(l6)));
        localLinkedList.add(localev);
        ((j.a)localObject2).ort.add(localObject3);
        localObject3 = new es();
        ((es)localObject3).type = 5;
        localLinkedList = ((es)localObject3).FsS;
        localev = new ev();
        localev.key = "EventType";
        localev.hHZ = "7";
        localLinkedList.add(localev);
        localLinkedList = ((es)localObject3).FsS;
        localev = new ev();
        localev.key = "StartTime";
        localev.hHZ = ((String)((d.g.a.b)localObject1).invoke(Long.valueOf(l2)));
        localLinkedList.add(localev);
        localLinkedList = ((es)localObject3).FsS;
        localev = new ev();
        localev.key = "EndTime";
        localev.hHZ = ((String)((d.g.a.b)localObject1).invoke(Long.valueOf(l1)));
        localLinkedList.add(localev);
        ((j.a)localObject2).ort.add(localObject3);
      }
      d(this.omW);
      localObject1 = this.ooH;
      localObject2 = getContext();
      p.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      f1 = this.density;
      p.h(localObject2, "context");
      p.h(paramMap, "params");
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).x = ((int)(bt.getInt((String)paramMap.get("x"), 0) * f1) - 2);
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).y = ((int)(bt.getInt((String)paramMap.get("y"), 0) * f1) - 2);
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).width = ((int)(bt.getInt((String)paramMap.get("width"), 0) * f1) + 4);
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).height = ((int)(bt.getInt((String)paramMap.get("height"), 0) * f1) + 4);
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqZ = ((String)paramMap.get("reportParams"));
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
      if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).width > 0) && (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).height > 0)) {
        break label1398;
      }
      ad.w("MicroMsg.BizVideoPosHelper", "init invalid params x=" + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).x + ", y=" + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).y + ", width=" + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).width + ", height=" + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).height);
      bool = false;
      this.ooW = bool;
      this.onk.oom = bt.getInt((String)paramMap.get("landingType"), 0);
      if (this.ooW)
      {
        bQL().addView((View)bRv());
        if ((this.ooH.width > 0) && (this.ooH.height > 0)) {
          eQ(this.ooH.width, this.ooH.height);
        }
        bRo().a((ImageView)this.oot.a(cwV[0]), bQJ().hDg.hDm, this.ooH.width, this.ooH.oqR, bQJ());
        localObject1 = bRo();
        localObject2 = bQJ().hDg.hDm;
        i = this.ooH.width;
        j = this.ooH.oqR;
        localObject3 = bQJ();
        p.h(localObject3, "msgInfo");
        paramMap = ((MPVideoView)localObject1).otN;
        if (paramMap == null) {
          break label1746;
        }
      }
    }
    label1746:
    for (paramMap = paramMap.getCoverIv();; paramMap = null)
    {
      ((MPVideoView)localObject1).a(paramMap, (String)localObject2, i, j, (com.tencent.mm.ai.x)localObject3);
      dG((View)bQL());
      paramMap = bRn();
      p.g(paramMap, "animationLayout");
      dG(paramMap);
      this.ooH.a(0, bRo());
      ad.i(this.TAG, "initVideoParam minVideoHeight " + this.ooH.oqR + " maxVideoHeight " + this.ooH.bEk);
      paramMap = bRn();
      p.g(paramMap, "animationLayout");
      paramMap.setVisibility(0);
      bQI().bringToFront();
      bRo().setFullScreenDelegate((MPVideoView.b)new o(this));
      bRo().setMPVideoViewCallBack((MPVideoView.c)new p(this));
      ((View)this.ooC.a(cwV[9])).setOnClickListener((View.OnClickListener)new q(this));
      getWebView().setOnCustomTouchListener((View.OnTouchListener)new r(this));
      bRo().setTitle(bQJ().hDg.title);
      bRo().setPlayBtnOnClickListener((View.OnClickListener)new s(this));
      paramMap = bRs();
      localObject1 = this.onk;
      p.h(localObject1, "controller");
      paramMap.fOB.setOnClickListener((View.OnClickListener)new MPVideoErrorView.a(paramMap, (b)localObject1));
      b(this.ooX);
      AppMethodBeat.o(175512);
      return;
      localObject1 = null;
      break;
      label1398:
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).ltA = com.tencent.mm.cc.a.ip((Context)localObject2);
      if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).x <= 0) && (Math.abs(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).ltA - ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).width) < 10))
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).x = 0;
        ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).width = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).ltA;
      }
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqP = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).x;
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqQ = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).y;
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqR = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).height;
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqS = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).width;
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).bEk = ((int)(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).ltA * 1.0F / ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).width * ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).height));
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqT = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).bEk;
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqU = d.k.h.lq((int)(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).ltA * 1.0F / f1), ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).bEk);
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqV = d.k.h.lq((int)(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).ltA * 1.0F / f2), ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).bEk);
      if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqU == ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqV) && (Math.abs(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqV - ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).bEk) < 10))
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqU = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).bEk;
        ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqV = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).bEk;
      }
      ad.i("MicroMsg.BizVideoPosHelper", "init x=" + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).x + ", y=" + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).y + ", width=" + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).width + ", height=" + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).height + ", screenWidth=" + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).ltA + ", minVideoHeightWhenPlay = " + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqU + ", minVideoHeightWhenPause = " + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqV);
      bool = true;
      break label892;
    }
  }
  
  public final boolean S(Bundle paramBundle)
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
    if (this.ooI != null)
    {
      ad.w(this.TAG, "createAdWebview adWebView existed!");
      AppMethodBeat.o(7195);
      return false;
    }
    com.tencent.mm.plugin.webview.h.a.WZ(28);
    paramBundle = paramBundle.getString("adUrl");
    ad.i(this.TAG, "createAdWebview adWebView url=".concat(String.valueOf(paramBundle)));
    this.ooK = false;
    Object localObject = a.onR;
    localObject = MMWebViewWithJsApi.a.gY((Context)getContext());
    p.g(localObject, "MMWebViewWithJsApi.Factory.create(this.context)");
    this.ooI = a.a((MMWebViewWithJsApi)localObject, bQK(), (d.g.a.m)BizVideoDetailUI.f.opi, (d.g.a.m)BizVideoDetailUI.g.opj, aGo(bQJ().VS()));
    a(this.ooI);
    localObject = this.ooI;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).loadUrl(paramBundle);
    }
    paramBundle = bRp();
    if (paramBundle != null) {
      paramBundle.removeAllViews();
    }
    paramBundle = bRr();
    if (paramBundle != null) {
      paramBundle.addView((View)this.ooI);
    }
    paramBundle = this.ooI;
    if (paramBundle != null) {
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(7195);
    return true;
  }
  
  public final void T(Bundle paramBundle)
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
    if (p.i("adWeb", str))
    {
      if (this.ooI == null)
      {
        AppMethodBeat.o(7200);
        return;
      }
      paramBundle = this.ooI;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getJsapi();
        if (paramBundle != null)
        {
          paramBundle.aGG((String)localObject);
          AppMethodBeat.o(7200);
          return;
        }
      }
      AppMethodBeat.o(7200);
      return;
    }
    if (p.i("dot", str))
    {
      if (this.ooJ == null)
      {
        AppMethodBeat.o(7200);
        return;
      }
      paramBundle = this.ooJ;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label257;
        }
        paramBundle = this.TAG;
        localObject = this.ooJ;
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
      paramBundle = this.ooJ;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getJsapi();
        if (paramBundle != null)
        {
          paramBundle.aGG((String)localObject);
          AppMethodBeat.o(7200);
          return;
        }
      }
      AppMethodBeat.o(7200);
      return;
    }
    paramBundle = this.DzP;
    if (paramBundle != null)
    {
      paramBundle.aGG((String)localObject);
      AppMethodBeat.o(7200);
      return;
    }
    AppMethodBeat.o(7200);
  }
  
  public final void U(Bundle paramBundle)
  {
    AppMethodBeat.i(7208);
    if (this.ooJ == null)
    {
      AppMethodBeat.o(7208);
      return;
    }
    if (paramBundle == null) {
      p.gfZ();
    }
    int j = paramBundle.getInt("webviewId", 0);
    if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.bRZ())
    {
      paramBundle = this.ooJ;
      MMWebViewWithJsApi localMMWebViewWithJsApi;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label125;
        }
        paramBundle = this.TAG;
        localMMWebViewWithJsApi = this.ooJ;
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
    bRD();
    AppMethodBeat.o(7208);
  }
  
  public final void V(Bundle paramBundle)
  {
    AppMethodBeat.i(7209);
    if (this.ooJ == null)
    {
      AppMethodBeat.o(7209);
      return;
    }
    if (paramBundle == null) {
      p.gfZ();
    }
    int j = paramBundle.getInt("webviewId", 0);
    int i;
    MMWebViewWithJsApi localMMWebViewWithJsApi;
    if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.bRZ())
    {
      paramBundle = this.ooJ;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label125;
        }
        paramBundle = this.TAG;
        localMMWebViewWithJsApi = this.ooJ;
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
    paramBundle = bRq();
    if ((paramBundle == null) || (paramBundle.getVisibility() != 0))
    {
      ad.i(this.TAG, "dotView not show");
      AppMethodBeat.o(7209);
      return;
    }
    paramBundle = bRq();
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.DzP;
    if (paramBundle != null)
    {
      i = bRN();
      localMMWebViewWithJsApi = this.ooJ;
      if (localMMWebViewWithJsApi == null) {
        p.gfZ();
      }
      paramBundle.N(i, localMMWebViewWithJsApi.hashCode(), "disappear");
    }
    paramBundle = this.ooJ;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getJsapi();
      if (paramBundle != null)
      {
        i = bRN();
        localMMWebViewWithJsApi = this.ooJ;
        if (localMMWebViewWithJsApi == null) {
          p.gfZ();
        }
        paramBundle.N(i, localMMWebViewWithJsApi.hashCode(), "disappear");
        AppMethodBeat.o(7209);
        return;
      }
    }
    AppMethodBeat.o(7209);
  }
  
  public final void W(Bundle paramBundle)
  {
    AppMethodBeat.i(7210);
    if (this.ooJ == null)
    {
      AppMethodBeat.o(7210);
      return;
    }
    if (paramBundle == null) {
      p.gfZ();
    }
    int j = paramBundle.getInt("webviewId", 0);
    if (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.bRZ())
    {
      paramBundle = this.ooJ;
      MMWebViewWithJsApi localMMWebViewWithJsApi;
      if (paramBundle != null)
      {
        i = paramBundle.hashCode();
        if (j == i) {
          break label125;
        }
        paramBundle = this.TAG;
        localMMWebViewWithJsApi = this.ooJ;
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
    this.ooL = true;
    com.tencent.mm.plugin.webview.h.a.WZ(59);
    AppMethodBeat.o(7210);
  }
  
  public final void X(Bundle paramBundle)
  {
    AppMethodBeat.i(7211);
    Object localObject1 = this.ooR;
    int k = bRo().getDuration();
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {
      ad.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData data invalid");
    }
    Object localObject2;
    int m;
    int i;
    for (;;)
    {
      bRO();
      localObject1 = bRo();
      paramBundle = new LinkedList((Collection)this.ooR.oql);
      p.h(paramBundle, "list");
      localObject1 = ((MPVideoView)localObject1).otO;
      if (localObject1 != null) {
        ((MPVideoViewControlBar)localObject1).L(paramBundle);
      }
      bRJ();
      AppMethodBeat.o(7211);
      return;
      try
      {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).oql.clear();
        localObject2 = d.z.MKo;
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
      p.g(str, "url");
      localObject2 = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c(j, d1, d2, d3, str);
      if (n != 1) {
        break label570;
      }
      bool = true;
      label378:
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).oqn = bool;
      if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).oqt < ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).oqu) && (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).oqt >= 0.0D) && (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).oqu <= k)) {
        break label576;
      }
      ad.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "dotInfo invalid, startTime = " + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).oqt + ", endTime=" + ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject2).oqu + ", duration=" + k);
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
          ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).oql.add(localObject2);
          break label561;
        }
        finally
        {
          paramBundle = finally;
          AppMethodBeat.o(7211);
          throw paramBundle;
        }
        ad.i(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).TAG, "setDotScriptData end %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b)localObject1).oql.size()) });
        break;
      }
      i += 1;
      break label238;
      bool = false;
      break label378;
    }
  }
  
  public final void Y(Bundle paramBundle)
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
          bRo().start();
          AppMethodBeat.o(7201);
          return;
          if (paramBundle.equals("stop")) {
            bRo().stop();
          }
        }
      }
    } while (!paramBundle.equals("pause"));
    bRo().pause();
    AppMethodBeat.o(7201);
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
    //   11: invokestatic 390	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_1
    //   15: ifnonnull +48 -> 63
    //   18: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:ork	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   21: astore_1
    //   22: aload_0
    //   23: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ooT	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   26: ldc_w 2178
    //   29: invokevirtual 1713	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:XX	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/es;
    //   32: astore_1
    //   33: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:ork	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   36: astore 5
    //   38: aload_1
    //   39: ldc_w 2180
    //   42: ldc_w 2182
    //   45: invokestatic 2185	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload_1
    //   49: aload_0
    //   50: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ooT	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   53: invokestatic 1716	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;)V
    //   56: sipush 7187
    //   59: invokestatic 446	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: return
    //   63: aload_1
    //   64: getfield 2188	com/tencent/mm/protocal/protobuf/fg:Fxt	I
    //   67: istore 4
    //   69: aload_0
    //   70: getfield 608	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:onk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   73: astore 8
    //   75: aload 8
    //   77: iload 4
    //   79: putfield 2191	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:hzl	I
    //   82: aload 8
    //   84: invokevirtual 2194	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:bRl	()Z
    //   87: ifeq +51 -> 138
    //   90: aload 8
    //   92: getfield 2198	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:ooh	Lcom/tencent/mm/ai/x;
    //   95: astore 5
    //   97: aload 5
    //   99: ifnonnull +9 -> 108
    //   102: ldc_w 1871
    //   105: invokestatic 2201	d/g/b/p:bcb	(Ljava/lang/String;)V
    //   108: aload 8
    //   110: getfield 2198	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:ooh	Lcom/tencent/mm/ai/x;
    //   113: astore 8
    //   115: aload 8
    //   117: ifnonnull +9 -> 126
    //   120: ldc_w 1871
    //   123: invokestatic 2201	d/g/b/p:bcb	(Ljava/lang/String;)V
    //   126: aload 5
    //   128: aload 8
    //   130: getfield 2202	com/tencent/mm/ai/x:hzl	I
    //   133: iconst_1
    //   134: ior
    //   135: putfield 2202	com/tencent/mm/ai/x:hzl	I
    //   138: aload_0
    //   139: getfield 2206	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:onl	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/o;
    //   142: invokevirtual 2211	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/o:Zm	()V
    //   145: aload_0
    //   146: getfield 2212	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:DzP	Lcom/tencent/mm/plugin/webview/c/f;
    //   149: astore 5
    //   151: aload 5
    //   153: ifnull +18 -> 171
    //   156: iload 4
    //   158: iconst_m1
    //   159: if_icmpne +291 -> 450
    //   162: aload 5
    //   164: ldc_w 2214
    //   167: iload_3
    //   168: invokevirtual 2217	com/tencent/mm/plugin/webview/c/f:fA	(Ljava/lang/String;I)V
    //   171: aload_1
    //   172: getfield 2221	com/tencent/mm/protocal/protobuf/fg:Fxx	Lcom/tencent/mm/protocal/protobuf/bxp;
    //   175: ifnull +24 -> 199
    //   178: aload_0
    //   179: getfield 608	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:onk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   182: invokevirtual 2194	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:bRl	()Z
    //   185: ifeq +14 -> 199
    //   188: aload_0
    //   189: getfield 608	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:onk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   192: aload_1
    //   193: getfield 2221	com/tencent/mm/protocal/protobuf/fg:Fxx	Lcom/tencent/mm/protocal/protobuf/bxp;
    //   196: putfield 2224	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:oon	Lcom/tencent/mm/protocal/protobuf/bxp;
    //   199: aload_0
    //   200: getfield 608	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:onk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   203: aload_1
    //   204: getfield 2225	com/tencent/mm/protocal/protobuf/fg:hzm	Ljava/lang/String;
    //   207: putfield 1365	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:hzm	Ljava/lang/String;
    //   210: aload_0
    //   211: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ooT	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   214: astore 9
    //   216: aload_1
    //   217: getfield 2225	com/tencent/mm/protocal/protobuf/fg:hzm	Ljava/lang/String;
    //   220: astore 8
    //   222: aload 8
    //   224: astore 5
    //   226: aload 8
    //   228: ifnonnull +8 -> 236
    //   231: ldc_w 527
    //   234: astore 5
    //   236: aload 9
    //   238: aload 5
    //   240: putfield 2228	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:orq	Ljava/lang/String;
    //   243: aload_0
    //   244: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ooT	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   247: aload_0
    //   248: invokevirtual 2231	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:getScene	()I
    //   251: invokestatic 1033	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   254: putfield 2234	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:orr	Ljava/lang/String;
    //   257: aload_0
    //   258: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ooT	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   261: aload_0
    //   262: invokevirtual 2237	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:getSubScene	()I
    //   265: invokestatic 1033	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   268: putfield 2240	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:ors	Ljava/lang/String;
    //   271: aload_1
    //   272: getfield 2243	com/tencent/mm/protocal/protobuf/fg:Fxw	Ljava/lang/String;
    //   275: astore 5
    //   277: aload 5
    //   279: ifnull +12 -> 291
    //   282: aload_0
    //   283: getfield 608	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:onk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   286: aload 5
    //   288: putfield 2246	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:oob	Ljava/lang/String;
    //   291: aload_0
    //   292: getfield 608	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:onk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/b;
    //   295: aload_1
    //   296: getfield 2247	com/tencent/mm/protocal/protobuf/fg:url	Ljava/lang/String;
    //   299: invokevirtual 2250	com/tencent/mm/plugin/brandservice/ui/timeline/video/b:XT	(Ljava/lang/String;)V
    //   302: aload_1
    //   303: getfield 2247	com/tencent/mm/protocal/protobuf/fg:url	Ljava/lang/String;
    //   306: astore 5
    //   308: aload 5
    //   310: ifnull +9 -> 319
    //   313: aload_0
    //   314: aload 5
    //   316: putfield 531	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:fkq	Ljava/lang/String;
    //   319: aload_1
    //   320: getfield 2254	com/tencent/mm/protocal/protobuf/fg:Fxv	Lcom/tencent/mm/protocal/protobuf/dvu;
    //   323: ifnull +200 -> 523
    //   326: aload_1
    //   327: getfield 2254	com/tencent/mm/protocal/protobuf/fg:Fxv	Lcom/tencent/mm/protocal/protobuf/dvu;
    //   330: getfield 2259	com/tencent/mm/protocal/protobuf/dvu:dvY	I
    //   333: ifeq +190 -> 523
    //   336: aload_0
    //   337: getfield 453	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:TAG	Ljava/lang/String;
    //   340: new 589	java/lang/StringBuilder
    //   343: dup
    //   344: ldc_w 2261
    //   347: invokespecial 593	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   350: aload_1
    //   351: getfield 2254	com/tencent/mm/protocal/protobuf/fg:Fxv	Lcom/tencent/mm/protocal/protobuf/dvu;
    //   354: getfield 2264	com/tencent/mm/protocal/protobuf/dvu:dvZ	Ljava/lang/String;
    //   357: invokevirtual 921	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: ldc_w 2266
    //   363: invokevirtual 921	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_1
    //   367: getfield 2254	com/tencent/mm/protocal/protobuf/fg:Fxv	Lcom/tencent/mm/protocal/protobuf/dvu;
    //   370: getfield 2259	com/tencent/mm/protocal/protobuf/dvu:dvY	I
    //   373: invokevirtual 597	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: invokevirtual 604	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 584	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   382: aload_0
    //   383: invokespecial 1374	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bRs	()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;
    //   386: aload_1
    //   387: getfield 2254	com/tencent/mm/protocal/protobuf/fg:Fxv	Lcom/tencent/mm/protocal/protobuf/dvu;
    //   390: getfield 2264	com/tencent/mm/protocal/protobuf/dvu:dvZ	Ljava/lang/String;
    //   393: invokevirtual 2269	com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView:setPlayError$505cff1c	(Ljava/lang/String;)V
    //   396: aload_0
    //   397: invokespecial 1674	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bRH	()V
    //   400: bipush 32
    //   402: invokestatic 965	com/tencent/mm/plugin/webview/h/a:WZ	(I)V
    //   405: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:ork	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   408: astore_1
    //   409: aload_0
    //   410: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ooT	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   413: ldc_w 2178
    //   416: invokevirtual 1713	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:XX	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/es;
    //   419: astore_1
    //   420: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:ork	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   423: astore 5
    //   425: aload_1
    //   426: ldc_w 2180
    //   429: ldc_w 2182
    //   432: invokestatic 2185	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Ljava/lang/String;Ljava/lang/String;)V
    //   435: aload_1
    //   436: aload_0
    //   437: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ooT	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   440: invokestatic 1716	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;)V
    //   443: sipush 7187
    //   446: invokestatic 446	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   489: getfield 2270	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI:TAG	Ljava/lang/String;
    //   492: ldc_w 2272
    //   495: iconst_1
    //   496: anewarray 811	java/lang/Object
    //   499: dup
    //   500: iconst_0
    //   501: iload_3
    //   502: invokestatic 1662	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   505: aastore
    //   506: invokestatic 1669	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   509: goto -347 -> 162
    //   512: iconst_0
    //   513: istore_2
    //   514: goto -54 -> 460
    //   517: iconst_0
    //   518: istore 4
    //   520: goto -49 -> 471
    //   523: aload_0
    //   524: invokespecial 1678	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bRG	()V
    //   527: aload_1
    //   528: getfield 2275	com/tencent/mm/protocal/protobuf/fg:FxB	Ljava/util/LinkedList;
    //   531: astore 5
    //   533: aload 5
    //   535: ifnull +371 -> 906
    //   538: aload 5
    //   540: checkcast 2277	java/lang/Iterable
    //   543: astore 5
    //   545: new 2279	java/util/ArrayList
    //   548: dup
    //   549: aload 5
    //   551: bipush 10
    //   553: invokestatic 2284	d/a/j:a	(Ljava/lang/Iterable;I)I
    //   556: invokespecial 2286	java/util/ArrayList:<init>	(I)V
    //   559: checkcast 2068	java/util/Collection
    //   562: astore 9
    //   564: aload 5
    //   566: invokeinterface 2290 1 0
    //   571: astore 10
    //   573: aload 10
    //   575: invokeinterface 2295 1 0
    //   580: ifeq +326 -> 906
    //   583: aload 10
    //   585: invokeinterface 2299 1 0
    //   590: checkcast 2301	com/tencent/mm/protocal/protobuf/bwb
    //   593: astore 8
    //   595: getstatic 2307	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:oqk	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/a;
    //   598: astore 5
    //   600: aload 8
    //   602: getfield 2308	com/tencent/mm/protocal/protobuf/bwb:url	Ljava/lang/String;
    //   605: astore 5
    //   607: aload 8
    //   609: getfield 2311	com/tencent/mm/protocal/protobuf/bwb:GQj	Ljava/lang/String;
    //   612: astore 11
    //   614: aload 5
    //   616: invokestatic 706	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   619: ifne +11 -> 630
    //   622: aload 11
    //   624: invokestatic 706	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   627: ifeq +26 -> 653
    //   630: getstatic 2312	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:TAG	Ljava/lang/String;
    //   633: ldc_w 2314
    //   636: invokestatic 2316	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: aload 9
    //   641: getstatic 2091	d/z:MKo	Ld/z;
    //   644: invokeinterface 2317 2 0
    //   649: pop
    //   650: goto -77 -> 573
    //   653: invokestatic 2320	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:bRY	()Z
    //   656: ifne +15 -> 671
    //   659: getstatic 2312	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:TAG	Ljava/lang/String;
    //   662: ldc_w 2322
    //   665: invokestatic 2316	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   668: goto -29 -> 639
    //   671: new 589	java/lang/StringBuilder
    //   674: dup
    //   675: invokespecial 913	java/lang/StringBuilder:<init>	()V
    //   678: getstatic 2326	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:oqj	Lcom/tencent/mm/sdk/platformtools/ao;
    //   681: invokevirtual 2331	com/tencent/mm/sdk/platformtools/ao:fjV	()Ljava/lang/Object;
    //   684: checkcast 2333	com/tencent/mm/vfs/e
    //   687: invokevirtual 2336	com/tencent/mm/vfs/e:getPath	()Ljava/lang/String;
    //   690: invokevirtual 921	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: bipush 47
    //   695: invokevirtual 600	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   698: astore 8
    //   700: aload 5
    //   702: invokestatic 2342	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   705: astore 5
    //   707: aload 5
    //   709: ldc_w 2344
    //   712: invokestatic 984	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   715: new 2333	com/tencent/mm/vfs/e
    //   718: dup
    //   719: aload 8
    //   721: aload 5
    //   723: invokevirtual 2347	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   726: invokevirtual 921	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: invokevirtual 604	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: invokespecial 2348	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   735: astore 5
    //   737: aload 5
    //   739: invokevirtual 2351	com/tencent/mm/vfs/e:exists	()Z
    //   742: ifne +25 -> 767
    //   745: new 2333	com/tencent/mm/vfs/e
    //   748: dup
    //   749: aload 5
    //   751: invokevirtual 2354	com/tencent/mm/vfs/e:getParent	()Ljava/lang/String;
    //   754: invokespecial 2348	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   757: invokevirtual 2357	com/tencent/mm/vfs/e:mkdirs	()Z
    //   760: pop
    //   761: aload 5
    //   763: invokevirtual 2360	com/tencent/mm/vfs/e:createNewFile	()Z
    //   766: pop
    //   767: aload 5
    //   769: invokestatic 2366	com/tencent/mm/vfs/i:aj	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   772: checkcast 2368	java/io/Closeable
    //   775: astore 8
    //   777: aload 8
    //   779: checkcast 2370	java/io/OutputStream
    //   782: astore 12
    //   784: aload 11
    //   786: ifnull +114 -> 900
    //   789: getstatic 2376	d/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   792: astore 5
    //   794: aload 11
    //   796: ifnonnull +49 -> 845
    //   799: new 838	d/v
    //   802: dup
    //   803: ldc_w 2378
    //   806: invokespecial 841	d/v:<init>	(Ljava/lang/String;)V
    //   809: astore_1
    //   810: sipush 7187
    //   813: invokestatic 446	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   816: aload_1
    //   817: athrow
    //   818: astore 5
    //   820: sipush 7187
    //   823: invokestatic 446	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   826: aload 5
    //   828: athrow
    //   829: astore_1
    //   830: aload 8
    //   832: aload 5
    //   834: invokestatic 2383	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   837: sipush 7187
    //   840: invokestatic 446	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   843: aload_1
    //   844: athrow
    //   845: aload 11
    //   847: aload 5
    //   849: invokevirtual 2387	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   852: astore 5
    //   854: aload 5
    //   856: ldc_w 2389
    //   859: invokestatic 984	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   862: aload 12
    //   864: aload 5
    //   866: invokevirtual 2393	java/io/OutputStream:write	([B)V
    //   869: getstatic 2312	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/a:TAG	Ljava/lang/String;
    //   872: ldc_w 2395
    //   875: aload 11
    //   877: invokestatic 696	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   880: invokevirtual 700	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   883: invokestatic 2316	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   886: getstatic 2091	d/z:MKo	Ld/z;
    //   889: astore 5
    //   891: aload 8
    //   893: aconst_null
    //   894: invokestatic 2383	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   897: goto -258 -> 639
    //   900: aconst_null
    //   901: astore 5
    //   903: goto -41 -> 862
    //   906: aload_1
    //   907: getfield 1095	com/tencent/mm/protocal/protobuf/fg:Fxo	Ljava/util/LinkedList;
    //   910: checkcast 2397	java/util/List
    //   913: invokestatic 2401	com/tencent/mm/sdk/platformtools/bt:hj	(Ljava/util/List;)Z
    //   916: ifeq +24 -> 940
    //   919: aload_0
    //   920: getfield 453	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:TAG	Ljava/lang/String;
    //   923: ldc_w 2403
    //   926: invokestatic 960	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   929: iconst_4
    //   930: invokestatic 965	com/tencent/mm/plugin/webview/h/a:WZ	(I)V
    //   933: sipush 7187
    //   936: invokestatic 446	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   939: return
    //   940: aload_0
    //   941: invokespecial 571	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bRo	()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;
    //   944: astore 9
    //   946: aload_0
    //   947: invokevirtual 995	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:bQJ	()Lcom/tencent/mm/ai/x;
    //   950: astore 8
    //   952: aload_1
    //   953: getfield 2406	com/tencent/mm/protocal/protobuf/fg:FxC	Ljava/lang/String;
    //   956: astore 7
    //   958: aload 7
    //   960: astore 5
    //   962: aload 7
    //   964: ifnonnull +8 -> 972
    //   967: ldc_w 527
    //   970: astore 5
    //   972: aload 8
    //   974: ldc_w 1871
    //   977: invokestatic 712	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   980: aload 5
    //   982: ldc_w 2408
    //   985: invokestatic 712	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   988: aload 9
    //   990: getfield 2077	com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView:otO	Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar;
    //   993: astore 7
    //   995: aload 7
    //   997: ifnonnull +6 -> 1003
    //   1000: invokestatic 683	d/g/b/p:gfZ	()V
    //   1003: aload 7
    //   1005: aload 8
    //   1007: getfield 2411	com/tencent/mm/ai/x:hDe	Ljava/lang/String;
    //   1010: aload 8
    //   1012: invokevirtual 1000	com/tencent/mm/ai/x:VS	()Ljava/lang/String;
    //   1015: aload 5
    //   1017: invokevirtual 2414	com/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar:N	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1020: aload_0
    //   1021: iconst_1
    //   1022: putfield 1078	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ooV	Z
    //   1025: aload_1
    //   1026: getfield 1095	com/tencent/mm/protocal/protobuf/fg:Fxo	Ljava/util/LinkedList;
    //   1029: astore 5
    //   1031: aload 5
    //   1033: ldc_w 1097
    //   1036: invokestatic 984	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1039: aload 5
    //   1041: invokestatic 1107	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/k:I	(Ljava/util/LinkedList;)Lcom/tencent/mm/protocal/protobuf/fu;
    //   1044: astore 8
    //   1046: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:ork	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1049: astore 5
    //   1051: aload_0
    //   1052: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ooT	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   1055: ldc_w 2178
    //   1058: invokevirtual 1713	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a:XX	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/es;
    //   1061: astore 7
    //   1063: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:ork	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1066: astore 5
    //   1068: aload 7
    //   1070: ldc_w 2416
    //   1073: ldc_w 2418
    //   1076: invokestatic 2185	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Ljava/lang/String;Ljava/lang/String;)V
    //   1079: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:ork	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1082: astore 5
    //   1084: aload 7
    //   1086: ldc_w 2420
    //   1089: ldc_w 2418
    //   1092: invokestatic 2185	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Ljava/lang/String;Ljava/lang/String;)V
    //   1095: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:ork	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1098: astore 5
    //   1100: aload 8
    //   1102: ifnull +133 -> 1235
    //   1105: aload 8
    //   1107: getfield 1112	com/tencent/mm/protocal/protobuf/fu:Fyb	I
    //   1110: invokestatic 1662	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1113: astore 5
    //   1115: aload 7
    //   1117: ldc_w 2422
    //   1120: aload 5
    //   1122: invokestatic 696	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1125: invokestatic 2185	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Ljava/lang/String;Ljava/lang/String;)V
    //   1128: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:ork	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1131: astore 5
    //   1133: aload 8
    //   1135: ifnull +106 -> 1241
    //   1138: aload 8
    //   1140: getfield 1205	com/tencent/mm/protocal/protobuf/fu:width	I
    //   1143: invokestatic 1662	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1146: astore 5
    //   1148: aload 7
    //   1150: ldc_w 2424
    //   1153: aload 5
    //   1155: invokestatic 696	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1158: invokestatic 2185	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Ljava/lang/String;Ljava/lang/String;)V
    //   1161: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:ork	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1164: astore 5
    //   1166: aload 6
    //   1168: astore 5
    //   1170: aload 8
    //   1172: ifnull +13 -> 1185
    //   1175: aload 8
    //   1177: getfield 1207	com/tencent/mm/protocal/protobuf/fu:height	I
    //   1180: invokestatic 1662	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1183: astore 5
    //   1185: aload 7
    //   1187: ldc_w 2426
    //   1190: aload 5
    //   1192: invokestatic 696	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1195: invokestatic 2185	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Ljava/lang/String;Ljava/lang/String;)V
    //   1198: getstatic 517	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:ork	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j;
    //   1201: astore 5
    //   1203: aload 7
    //   1205: ldc_w 2180
    //   1208: ldc_w 2418
    //   1211: invokestatic 2185	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Ljava/lang/String;Ljava/lang/String;)V
    //   1214: aload 7
    //   1216: aload_0
    //   1217: getfield 526	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:ooT	Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;
    //   1220: invokestatic 1716	com/tencent/mm/plugin/brandservice/ui/timeline/video/util/j:a	(Lcom/tencent/mm/protocal/protobuf/es;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/j$a;)V
    //   1223: aload_0
    //   1224: aload_1
    //   1225: invokespecial 1946	com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI:b	(Lcom/tencent/mm/protocal/protobuf/fg;)V
    //   1228: sipush 7187
    //   1231: invokestatic 446	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final boolean bQO()
  {
    return true;
  }
  
  public final void bQP()
  {
    AppMethodBeat.i(7154);
    super.bQP();
    setBackBtn((MenuItem.OnMenuItemClickListener)new m(this), 2131689492);
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
    es locales = this.ooT.XX("1");
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
    localObject = this.onO;
    boolean bool;
    if (localObject != null)
    {
      bool = ((MpWebViewController)localObject).bQw();
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (localObject = "1";; localObject = "0")
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "MiaoKai", (String)localObject);
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, this.ooT);
      AppMethodBeat.o(7154);
      return;
      bool = false;
      break;
    }
  }
  
  public final void bQQ()
  {
    AppMethodBeat.i(175513);
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h localh = this.ooE;
    if (localh != null) {
      localh.release();
    }
    bRP();
    this.ooR.reset();
    eSA();
    this.onl.onDestroy();
    int i = bRA();
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.cB(bRE(), i);
    this.onk.onDestroy();
    bRC();
    bRD();
    bRo().onUIDestroy();
    AppMethodBeat.o(175513);
  }
  
  public final void bQU()
  {
    AppMethodBeat.i(7197);
    bRC();
    AppMethodBeat.o(7197);
  }
  
  public final void bQV()
  {
    AppMethodBeat.i(7198);
    ad.i(this.TAG, "adWebviewReady");
    this.ooK = true;
    AppMethodBeat.o(7198);
  }
  
  public final Bundle bQW()
  {
    AppMethodBeat.i(7199);
    Bundle localBundle = new Bundle();
    localBundle.putInt("currentTime", bRo().getCurrPosSec());
    localBundle.putInt("duration", bRo().getDuration());
    localBundle.putString("state", this.ooU);
    localBundle.putLong("playedTotalTime", bRo().getRealPlayTime() / 1000L);
    localBundle.putString("vid", this.onk.hzm);
    AppMethodBeat.o(7199);
    return localBundle;
  }
  
  public final int bRA()
  {
    AppMethodBeat.i(7181);
    Object localObject = bRo();
    if (localObject != null) {}
    for (localObject = Integer.valueOf(((MPVideoView)localObject).getCurrPosSec());; localObject = null)
    {
      int j = ((Integer)localObject).intValue();
      localObject = bRo();
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
  
  public final void bRD()
  {
    AppMethodBeat.i(7184);
    if (this.ooJ == null)
    {
      AppMethodBeat.o(7184);
      return;
    }
    com.tencent.mm.plugin.webview.h.a.WZ(61);
    if (!this.ooL) {
      com.tencent.mm.plugin.webview.h.a.WZ(62);
    }
    Object localObject = this.DzP;
    int i;
    MMWebViewWithJsApi localMMWebViewWithJsApi;
    if (localObject != null)
    {
      i = bRN();
      localMMWebViewWithJsApi = this.ooJ;
      if (localMMWebViewWithJsApi == null) {
        p.gfZ();
      }
      ((com.tencent.mm.plugin.webview.c.f)localObject).N(i, localMMWebViewWithJsApi.hashCode(), "disappear");
    }
    localObject = this.DzP;
    if (localObject != null)
    {
      i = bRN();
      localMMWebViewWithJsApi = this.ooJ;
      if (localMMWebViewWithJsApi == null) {
        p.gfZ();
      }
      ((com.tencent.mm.plugin.webview.c.f)localObject).N(i, localMMWebViewWithJsApi.hashCode(), "destroy");
    }
    localObject = bRq();
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = bRq();
    if (localObject != null) {
      ((FrameLayout)localObject).removeView((View)this.ooJ);
    }
    localObject = this.ooJ;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getCurWebviewClient();
      if (!(localObject instanceof com.tencent.mm.plugin.webview.ui.tools.widget.k)) {
        break label223;
      }
      localObject = this.ooJ;
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
    localObject = this.ooJ;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).destroy();
    }
    localObject = this.ooJ;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebChromeClient(null);
    }
    localObject = this.ooJ;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setWebViewClient(null);
    }
    localObject = this.ooJ;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnTouchListener(null);
    }
    localObject = this.ooJ;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setOnLongClickListener(null);
    }
    localObject = this.ooJ;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).setVisibility(8);
    }
    localObject = this.ooJ;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).removeAllViews();
    }
    localObject = this.ooJ;
    if (localObject != null) {
      ((MMWebViewWithJsApi)localObject).clearView();
    }
    this.ooJ = null;
    this.ooL = false;
    localObject = this.ooQ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).ddj = false;
    }
    localObject = this.ooQ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).oqq = false;
    }
    this.ooQ = null;
    AppMethodBeat.o(7184);
  }
  
  public final int bRN()
  {
    AppMethodBeat.i(7212);
    if (this.ooQ == null)
    {
      AppMethodBeat.o(7212);
      return -1;
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c localc = this.ooQ;
    if (localc == null) {
      p.gfZ();
    }
    int i = localc.id;
    AppMethodBeat.o(7212);
    return i;
  }
  
  public final void bRO()
  {
    AppMethodBeat.i(7213);
    if ((this.ooP) || (bRo().getCurrPosSec() <= 0))
    {
      AppMethodBeat.o(7213);
      return;
    }
    float f = bRo().getCurrPosMs() / 1000.0F;
    if ((this.ooJ != null) && (this.ooR.b(f, this.ooQ)))
    {
      localObject = this.ooQ;
      if (localObject == null) {
        p.gfZ();
      }
      if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).ddj)
      {
        if (com.tencent.mm.sdk.platformtools.i.DEBUG) {
          ad.d(this.TAG, "dot end, wait h5 to close");
        }
        if (System.currentTimeMillis() - this.opb >= 1000L)
        {
          ad.i(this.TAG, "dot end, time out to close");
          bRD();
        }
        AppMethodBeat.o(7213);
        return;
      }
      ad.i(this.TAG, "destroyDotWebView");
      localObject = bRq();
      if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
      {
        localObject = this.ooJ;
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
        localObject = this.ooJ;
        if (localObject == null) {
          p.gfZ();
        }
        localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
        if (localObject == null) {
          p.gfZ();
        }
        if (((com.tencent.mm.plugin.webview.c.f)localObject).isReady()) {
          break;
        }
      }
      bRD();
      if (this.ooQ == null) {
        break label360;
      }
      if (this.ooL)
      {
        localObject = bRq();
        if (((localObject == null) || (((FrameLayout)localObject).getVisibility() != 0)) && (com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b.a(f, this.ooQ))) {
          bRM();
        }
      }
      AppMethodBeat.o(7213);
      return;
    }
    localObject = this.ooQ;
    if (localObject == null) {
      p.gfZ();
    }
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).ddj = true;
    this.opb = System.currentTimeMillis();
    localObject = this.ooJ;
    int i;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
      if (localObject != null)
      {
        i = bRN();
        MMWebViewWithJsApi localMMWebViewWithJsApi = this.ooJ;
        if (localMMWebViewWithJsApi == null) {
          p.gfZ();
        }
        ((com.tencent.mm.plugin.webview.c.f)localObject).N(i, localMMWebViewWithJsApi.hashCode(), "end");
        AppMethodBeat.o(7213);
        return;
      }
    }
    AppMethodBeat.o(7213);
    return;
    label360:
    this.ooQ = this.ooR.aU(f);
    if (this.ooQ != null)
    {
      i = bRN();
      localObject = this.ooQ;
      if (localObject == null) {
        p.gfZ();
      }
      aG(i, ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c)localObject).url);
    }
    AppMethodBeat.o(7213);
  }
  
  public final void bRw()
  {
    AppMethodBeat.i(7153);
    this.ooT.bSd();
    super.bRw();
    if (!this.ooS)
    {
      this.ooS = true;
      com.tencent.mm.pluginsdk.h.q((MMActivity)this);
      com.tencent.mm.plugin.webview.h.a.WZ(0);
    }
    getIntent().putExtra("vertical_scroll", false);
    AppMethodBeat.o(7153);
  }
  
  public final void bRz()
  {
    AppMethodBeat.i(7169);
    com.tencent.mm.plugin.webview.ui.tools.widget.n localn = eSy();
    localn.setMinHeaderHeight(this.ooH.height);
    localn.setUrl(this.fkq);
    localn.eVF();
    localn.a(this.onk.scene, this.onk.ooi, this.onk.hzh, this.onk.oog, this.onk.url, bQJ().hDg.title);
    localn.setCallback((n.c)new n(this));
    localn.setTimeLineSessionId(localn.getTimeLineSessionId());
    AppMethodBeat.o(7169);
  }
  
  public final void bzn()
  {
    AppMethodBeat.i(7156);
    super.bzn();
    if (this.lvv != null) {}
    try
    {
      this.onk.ooo.orE = this.lvv.zD(bQJ().VS());
      this.onk.ooo.ed(1, 0);
      Object localObject = this.lvv;
      p.g(localObject, "invoker");
      this.uin = ((e)localObject).eRz();
      this.onk.ook = bRx();
      this.ooO = false;
      this.onk.bRi();
      this.ooT.XX("5");
      if (!bt.isNullOrNil(bQJ().hDg.title))
      {
        localObject = eSw();
        if (localObject != null) {
          ((com.tencent.mm.plugin.webview.ui.tools.floatball.a)localObject).Wm(bQJ().hDg.title);
        }
      }
      localObject = eSw();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.webview.ui.tools.floatball.a)localObject).aIV("1");
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
    if (this.jBC)
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
    if (bQJ().hDg == null)
    {
      finish();
      ad.w(this.TAG, "onCreate msgInfo.item is null");
      AppMethodBeat.o(7155);
      return;
    }
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("onCreate rawUrl is ");
    Object localObject3 = bQJ().hDg;
    if (localObject3 == null) {
      p.gfZ();
    }
    ad.i((String)localObject1, ((com.tencent.mm.ai.v)localObject3).url);
    localObject3 = this.ooT;
    localObject1 = bQJ().hDg;
    if (localObject1 == null) {
      p.gfZ();
    }
    localObject2 = ((com.tencent.mm.ai.v)localObject1).url;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((j.a)localObject3).orp = ((String)localObject1);
    this.ooT.orn = String.valueOf(bQM());
    this.ooT.oro = String.valueOf(System.currentTimeMillis() / 1000L);
    localObject1 = this.onk;
    localObject2 = this.kfc;
    p.h(localObject2, "callback");
    ((b)localObject1).kfc = ((IPCRunCgi.a)localObject2);
    localObject1 = this.onl;
    localObject2 = (TmplShareWebViewToolUI)this;
    localObject3 = bQJ();
    Object localObject4 = this.onk;
    p.h(localObject2, "ui");
    p.h(localObject3, "msgInfo");
    p.h(localObject4, "controller");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o)localObject1).lVh = new WeakReference(localObject2);
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o)localObject1).ooh = ((com.tencent.mm.ai.x)localObject3);
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o)localObject1).opy = ((b)localObject4);
    this.onk.ooj = ((Number)this.ons.a(TmplShareWebViewToolUI.cwV[8])).intValue();
    this.onk.ooo.oqJ = new WeakReference(bRo());
    localObject1 = this.onk;
    localObject3 = (TmplShareWebViewToolUI)this;
    int i = getScene();
    int j = getSubScene();
    localObject4 = bQJ().hDg;
    if (localObject4 == null) {
      p.gfZ();
    }
    localObject2 = bQJ();
    int k = bQM();
    p.h(localObject3, "ui");
    p.h(localObject4, "readerItem");
    p.h(localObject2, "msgInfo");
    ((b)localObject1).lVh = new WeakReference(localObject3);
    ((b)localObject1).scene = i;
    ((b)localObject1).ooi = j;
    ((b)localObject1).XT(((com.tencent.mm.ai.v)localObject4).url);
    ((b)localObject1).ocq = ((com.tencent.mm.ai.v)localObject4);
    ((b)localObject1).ooh = ((com.tencent.mm.ai.x)localObject2);
    ((b)localObject1).hzh = ((com.tencent.mm.ai.v)localObject4).type;
    ((b)localObject1).oog = k;
    ((b)localObject1).doK = ((com.tencent.mm.ai.x)localObject2).doK;
    ((b)localObject1).ooa = ((com.tencent.mm.ai.x)localObject2).hDe;
    ((b)localObject1).hzm = ((com.tencent.mm.ai.x)localObject2).hDg.hzm;
    localObject3 = ((b)localObject1).ooc;
    p.h(localObject1, "controller");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.n)localObject3).opy = ((b)localObject1);
    localObject3 = ((b)localObject1).ooo;
    p.h(localObject1, "controller");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject3).opy = ((b)localObject1);
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject3).orF = true;
    ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m)localObject3).orD = "";
    try
    {
      localObject2 = Uri.parse(((com.tencent.mm.ai.x)localObject2).hDg.url);
      ((b)localObject1).hDP = bt.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
      ((b)localObject1).idx = bt.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
      ad.i(((b)localObject1).TAG, "init vid=" + ((b)localObject1).hzm);
      localObject3 = this.onk;
      localObject2 = getIntent().getStringExtra("biz_video_channel_session_id");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      p.h(localObject1, "<set-?>");
      ((b)localObject3).ool = ((String)localObject1);
      com.tencent.mm.plugin.webview.h.a.WZ(1);
      this.ooR.reset();
      this.Een.setMMOverScrollOffsetListener((LogoWebViewWrapper.b)new x(this));
      this.Een.eSo();
      this.Een.eSp();
      this.ooV = false;
      this.ooW = false;
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ((IntentFilter)localObject1).setPriority(2147483647);
      if (this.ope == null) {
        this.ope = ((BroadcastReceiver)new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(7132);
            p.h(paramAnonymousContext, "context");
            if ((paramAnonymousIntent == null) || (bt.isNullOrNil(paramAnonymousIntent.getAction())) || (!this.oph.ooO) || ((BizVideoDetailUI.k(this.oph).oof) && (!BizVideoDetailUI.v(this.oph))))
            {
              AppMethodBeat.o(7132);
              return;
            }
            boolean bool1 = ay.isNetworkConnected(aj.getContext());
            if ((!BizVideoDetailUI.w(this.oph)) && (bool1))
            {
              paramAnonymousContext = BizVideoDetailUI.f(this.oph);
              paramAnonymousIntent = paramAnonymousContext.otN;
              if (paramAnonymousIntent == null) {
                p.gfZ();
              }
              if (paramAnonymousIntent.isPlaying())
              {
                paramAnonymousIntent = paramAnonymousContext.otN;
                if (paramAnonymousIntent == null) {
                  p.gfZ();
                }
                if (paramAnonymousIntent.ltc == null) {
                  break label421;
                }
                paramAnonymousIntent = paramAnonymousIntent.ltc;
                if (paramAnonymousIntent == null) {
                  p.gfZ();
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
                paramAnonymousIntent = paramAnonymousContext.otN;
                if (paramAnonymousIntent == null) {
                  p.gfZ();
                }
                if (paramAnonymousIntent.bSv())
                {
                  paramAnonymousIntent = paramAnonymousContext.otN;
                  if (paramAnonymousIntent == null) {
                    p.gfZ();
                  }
                  paramAnonymousContext = paramAnonymousContext.otN;
                  if (paramAnonymousContext == null) {
                    p.gfZ();
                  }
                  paramAnonymousIntent.T(paramAnonymousContext.getCurrPosMs(), true);
                }
              }
              BizVideoDetailUI.c(this.oph, bool1);
              bool1 = ay.isWifi(aj.getContext());
              i = BizVideoDetailUI.x(this.oph);
              BizVideoDetailUI.a(this.oph, BizVideoDetailUI.y(this.oph));
              boolean bool2 = BizVideoDetailUI.b(this.oph, BizVideoDetailUI.f(this.oph).getDuration());
              ad.i(BizVideoDetailUI.m(this.oph), "net type change simcardTpye=" + BizVideoDetailUI.x(this.oph) + ", lastSimcardType=" + i + ", is wifi=" + bool1 + ", show=" + bool2);
              if (!bool2) {
                break label441;
              }
              paramAnonymousContext = BizVideoDetailUI.i(this.oph);
              p.g(paramAnonymousContext, "videoWifiTipsView");
              if (paramAnonymousContext.getVisibility() == 0) {
                break label449;
              }
              if ((!BizVideoDetailUI.f(this.oph).isPlaying()) || (this.oph.ooP) || ((BizVideoDetailUI.f(this.oph).bSD()) && (BizVideoDetailUI.f(this.oph).bmN()))) {
                break;
              }
              BizVideoDetailUI.b(this.oph, true);
              AppMethodBeat.o(7132);
              return;
            }
            this.oph.ooM = true;
            AppMethodBeat.o(7132);
            return;
            label441:
            BizVideoDetailUI.a(this.oph, 0L);
            label449:
            AppMethodBeat.o(7132);
          }
        });
      }
      getContext().registerReceiver(this.ope, (IntentFilter)localObject1);
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
  
  public final void jn(boolean paramBoolean)
  {
    AppMethodBeat.i(7166);
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h localh = this.ooE;
    if (localh != null)
    {
      ad.i("MicroMsg.BizVideoOrientationHelper", "enable :".concat(String.valueOf(paramBoolean)));
      if (localh.axF())
      {
        Object localObject;
        if (paramBoolean)
        {
          localh.oqM.enable();
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
              localh.oqK = ((Sensor)localObject);
              localObject = localh.mSensorManager;
              if (localObject == null) {
                break;
              }
              ((SensorManager)localObject).registerListener((SensorEventListener)localh, localh.oqK, 3);
              AppMethodBeat.o(7166);
              return;
            }
            AppMethodBeat.o(7166);
          }
        }
        else
        {
          localh.oqM.disable();
          localObject = localh.ktm.get();
          if (localObject == null)
          {
            localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(7166);
            throw ((Throwable)localObject);
          }
          ((MMActivity)localObject).setRequestedOrientation(1);
          localh.hub = 0;
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
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o localo = this.onl;
    Object localObject3;
    int i;
    if (paramInt1 == 1) {
      if (paramInt2 == -1)
      {
        localObject2 = (Context)localo.bRk();
        localObject3 = localo.bRk();
        if (localObject3 != null) {
          localObject1 = ((TmplShareWebViewToolUI)localObject3).getString(2131756660);
        }
        com.tencent.mm.ui.base.h.ci((Context)localObject2, (String)localObject1);
        if (localo.orY)
        {
          i = 11;
          localObject1 = localo.opy;
          if (localObject1 == null) {
            p.bcb("controller");
          }
          ((b)localObject1).ooc.aH(i, localo.osa);
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
            localObject3 = g.oqI;
            localObject3 = localo.ooh;
            if (localObject3 == null) {
              p.bcb("msgInfo");
            }
            b localb = localo.opy;
            if (localb == null) {
              p.bcb("controller");
            }
            g.a((String)localObject1, (com.tencent.mm.ai.x)localObject3, (String)localObject2, localb, (com.tencent.mm.ipcinvoker.d)new o.a(localo));
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
    if (this.jBC)
    {
      bRo().p(false, 0);
      AppMethodBeat.o(7185);
      return;
    }
    com.tencent.mm.plugin.webview.ui.tools.widget.n localn = eSy();
    if ((localn.getSayFooter().eVD()) && (localn.bni())) {
      localn.getSayFooter().edA();
    }
    for (;;)
    {
      if (i == 0) {
        super.onBackPressed();
      }
      AppMethodBeat.o(7185);
      return;
      if ((localn.Eex != -3) && (localn.bni())) {
        localn.hide();
      } else {
        i = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7179);
    this.ooT.XY("21");
    this.ooT.XY("22");
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(this.ooT.XX("2"), this.ooT);
    bRB();
    super.onDestroy();
    localObject = this.ooF;
    if (localObject != null) {
      ((com.tencent.mm.plugin.brandservice.ui.widget.a)localObject).b(this.opa);
    }
    bQQ();
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.XW(((BizVideoDetailUI)this).toString());
    AppMethodBeat.o(7179);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(7186);
    ad.i(this.TAG, "onKeyDown keyCode %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 4) && (this.jBC))
    {
      bRo().p(false, 0);
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
    Object localObject = bRo();
    ad.i(MPVideoView.TAG, "onUIPause");
    localObject = ((MPVideoView)localObject).otN;
    if (localObject == null) {
      p.gfZ();
    }
    ((MPExoVideoWrapper)localObject).ote = true;
    ((MPExoVideoWrapper)localObject).ota.abe();
    ((MPExoVideoWrapper)localObject).setKeepScreenOn(false);
    ((MPExoVideoWrapper)localObject).ltl = ((MPExoVideoWrapper)localObject).isPlaying();
    ((MPExoVideoWrapper)localObject).pause();
    ((MPExoVideoWrapper)localObject).lsZ = false;
    AppMethodBeat.o(7174);
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(7180);
    bRB();
    bQQ();
    super.onReset();
    AppMethodBeat.o(7180);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(7170);
    super.onResume();
    Object localObject = bRo();
    ad.i(MPVideoView.TAG, "onUIResume");
    if (((MPVideoView)localObject).llq)
    {
      ad.i(MPVideoView.TAG, "onUIResume, should skip ui resume");
      ((MPVideoView)localObject).llq = false;
      AppMethodBeat.o(7170);
      return;
    }
    localObject = ((MPVideoView)localObject).otN;
    if (localObject == null) {
      p.gfZ();
    }
    ((MPExoVideoWrapper)localObject).ote = false;
    ((MPExoVideoWrapper)localObject).lsZ = true;
    if ((((MPExoVideoWrapper)localObject).osY != null) && (((MPExoVideoWrapper)localObject).cuI) && ((((MPExoVideoWrapper)localObject).ltl) || (((MPExoVideoWrapper)localObject).otc)))
    {
      ad.i(MPExoVideoWrapper.TAG, "onUIResume, isPlayOnUiPause =" + ((MPExoVideoWrapper)localObject).ltl + ", mPlayingWhenBackground " + ((MPExoVideoWrapper)localObject).otc);
      ((MPExoVideoWrapper)localObject).start();
    }
    AppMethodBeat.o(7170);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(7171);
    super.onStart();
    if (bQJ().hDg == null)
    {
      finish();
      ad.w(this.TAG, "onStart msgInfo.item is null");
      AppMethodBeat.o(7171);
      return;
    }
    ad.i(this.TAG, "alvinluo onStart handleAnimation coverUrl: %s", new Object[] { bQJ().hDg.hDm });
    bQI().bringToFront();
    bRo().bSr();
    AppMethodBeat.o(7171);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void zR(int paramInt)
  {
    AppMethodBeat.i(175508);
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i locali = this.ooH;
    d.g.a.a locala = (d.g.a.a)new w(this);
    p.h(locala, "onUpdateView");
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
      int i = locali.ora;
      locali.ora = (locali.y - paramInt);
      if (locali.ora < i) {
        if (locali.ora > 0) {
          locali.zY(locali.ora);
        }
      }
      for (;;)
      {
        bool = true;
        break;
        if ((locali.oqW != 1) && (locali.oqS != locali.ltA))
        {
          ad.d("MicroMsg.BizVideoPosHelper", "onWebViewScrollChanged currentVideoWidth=" + locali.oqS + ", screenWidth=" + locali.ltA);
          locali.oqW = 1;
          locali.b(true, (d.g.a.a)new i.c(locala));
          bool = false;
          break;
        }
        bool = locali.zZ(Math.abs(locali.ora));
        break;
        if (locali.ora <= i) {
          break label388;
        }
        if (locali.ora < 0)
        {
          bool = locali.zZ(Math.abs(locali.ora));
          break;
        }
        if ((locali.oqW != 2) && (locali.oqS != locali.width))
        {
          locali.oqW = 2;
          locali.b(false, (d.g.a.a)new i.d(locala));
          bool = false;
          break;
        }
        locali.zY(locali.ora);
      }
      label388:
      bool = false;
    }
    bRy();
    AppMethodBeat.o(175508);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<FrameLayout>
  {
    a(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class aa
    extends d.g.b.q
    implements d.g.a.a<View>
  {
    aa(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ab
    extends d.g.b.q
    implements d.g.a.a<LinearLayout>
  {
    ab(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ac
    extends d.g.b.q
    implements d.g.a.a<MPVideoErrorView>
  {
    ac(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "invoke"})
  static final class ad
    extends d.g.b.q
    implements d.g.a.a<MPVideoView>
  {
    ad(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
  static final class ae
    extends d.g.b.q
    implements d.g.a.a<FrameLayout>
  {
    ae(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWifiTipsView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class af
    extends d.g.b.q
    implements d.g.a.a<MPVideoWifiTipsView>
  {
    af(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<ImageView>
  {
    b(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<View>
  {
    c(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<FrameLayout>
  {
    d(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class e
    implements IPCRunCgi.a
  {
    e(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(7087);
      BizVideoDetailUI.k(this.oph).bRj();
      if (paramb == null)
      {
        AppMethodBeat.o(7087);
        return;
      }
      ad.i(BizVideoDetailUI.m(this.oph), "onSceneEnd errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString + ", type: " + paramb.getType());
      Object localObject = paramb.aEE();
      if ((((localObject instanceof ff)) && (((ff)localObject).FwE != BizVideoDetailUI.k(this.oph).oog)) || (((localObject instanceof fe)) && (((fe)localObject).FwE != BizVideoDetailUI.k(this.oph).oog)))
      {
        AppMethodBeat.o(7087);
        return;
      }
      if (paramb.getType() == 1179)
      {
        this.oph.ooO = true;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          BizVideoDetailUI.s(this.oph);
          paramString = paramb.aEF();
          if (paramString == null)
          {
            paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgGetResp");
            AppMethodBeat.o(7087);
            throw paramString;
          }
          paramString = (fg)paramString;
          paramb = BizVideoDetailUI.m(this.oph);
          localObject = new StringBuilder("url_info size is ");
          LinkedList localLinkedList;
          if (paramString.Fxo != null)
          {
            localLinkedList = paramString.Fxo;
            if (localLinkedList == null) {
              p.gfZ();
            }
          }
          for (paramInt1 = localLinkedList.size();; paramInt1 = 0)
          {
            ad.i(paramb, paramInt1);
            if ((paramString.Fxp == 0) || (bt.isNullOrNil(paramString.Fxq))) {
              break;
            }
            ad.i(BizVideoDetailUI.m(this.oph), "onSceneEnd redirect %s", new Object[] { paramString.Fxq });
            paramb = this.oph;
            paramString = paramString.Fxq;
            p.g(paramString, "resp.redirect_url");
            paramb.XS(paramString);
            AppMethodBeat.o(7087);
            return;
          }
          this.oph.a(paramString);
          AppMethodBeat.o(7087);
          return;
        }
        this.oph.a(null);
        BizVideoDetailUI.q(this.oph);
        paramb = BizVideoDetailUI.p(this.oph);
        paramb.opu.setBackgroundResource(2131231310);
        if (!bt.isNullOrNil(paramString)) {
          paramb.opt.setText((CharSequence)(paramb.getContext().getString(2131761343) + ' ' + paramString));
        }
        for (;;)
        {
          paramb.fOB.setClickable(true);
          if (paramInt1 != 2) {
            break;
          }
          com.tencent.mm.plugin.webview.h.a.WZ(2);
          AppMethodBeat.o(7087);
          return;
          paramb.opt.setText((CharSequence)paramb.getContext().getString(2131761343));
        }
        com.tencent.mm.plugin.webview.h.a.WZ(3);
        AppMethodBeat.o(7087);
        return;
      }
      AppMethodBeat.o(7087);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "posInfo", "", "webvieId", "", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.m<String, Integer, d.z>
  {
    h(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "view", "Lcom/tencent/xweb/WebView;", "url", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.m<WebView, String, d.z>
  {
    i(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.a<FrameLayout>
  {
    j(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "onExitFullscreen", "", "plugin-brandservice_release"})
  public static final class k
    extends com.tencent.mm.plugin.brandservice.ui.widget.b
  {
    public final void DA()
    {
      AppMethodBeat.i(7099);
      BizVideoDetailUI.a(this.oph, false);
      if (BizVideoDetailUI.f(this.oph).getParent() == null) {
        BizVideoDetailUI.e(this.oph).addView((View)BizVideoDetailUI.f(this.oph), 0);
      }
      AppMethodBeat.o(7099);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(175501);
      MPVideoWifiTipsView localMPVideoWifiTipsView = BizVideoDetailUI.i(this.oph);
      p.g(localMPVideoWifiTipsView, "videoWifiTipsView");
      localMPVideoWifiTipsView.setVisibility(8);
      AppMethodBeat.o(175501);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class m
    implements MenuItem.OnMenuItemClickListener
  {
    m(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(7101);
      this.oph.hideVKB();
      BizVideoDetailUI.a(this.oph);
      AppMethodBeat.o(7101);
      return true;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initComment$1$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MPWriteCommentLayout$MPWriteCommentLayoutCallback;", "onHide", "", "onShow", "plugin-brandservice_release"})
  public static final class n
    implements n.c
  {
    n(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void onHide()
    {
      AppMethodBeat.i(7103);
      BizVideoDetailUI.a(this.oph, this.oph.ooH.width, this.oph.ooH.height);
      AppMethodBeat.o(7103);
    }
    
    public final void onShow()
    {
      AppMethodBeat.i(7104);
      this.oph.jn(false);
      AppMethodBeat.o(7104);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "enterFullScreen", "", "direction", "", "quitFullScreen", "plugin-brandservice_release"})
  public static final class o
    implements MPVideoView.b
  {
    public final void bkF()
    {
      AppMethodBeat.i(7107);
      BizVideoDetailUI.a(this.oph, "exitFullScreen", "");
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
      localObject = BizVideoDetailUI.d(this.oph).XX("18");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, "FullScreenSwitch", "2");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, BizVideoDetailUI.d(this.oph));
      com.tencent.mm.plugin.ball.f.f.bLv();
      BizVideoDetailUI.g(this.oph).aXV();
      this.oph.setRequestedOrientation(1);
      BizVideoDetailUI.k(this.oph).ooo.ed(6, 0);
      localObject = BizVideoDetailUI.j(this.oph);
      p.g(localObject, "videoAdTitleBar");
      ((LinearLayout)localObject).setVisibility(8);
      BizVideoDetailUI.l(this.oph);
      AppMethodBeat.o(7107);
    }
    
    public final boolean isFullScreen()
    {
      AppMethodBeat.i(7105);
      boolean bool = BizVideoDetailUI.c(this.oph);
      AppMethodBeat.o(7105);
      return bool;
    }
    
    public final void te(int paramInt)
    {
      AppMethodBeat.i(7106);
      BizVideoDetailUI.a(this.oph, "enterFullScreen", "");
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
      localObject = BizVideoDetailUI.d(this.oph).XX("18");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, "FullScreenSwitch", "1");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, BizVideoDetailUI.d(this.oph));
      com.tencent.mm.plugin.ball.f.f.bLw();
      BizVideoDetailUI.e(this.oph).removeView((View)BizVideoDetailUI.f(this.oph));
      this.oph.ooH.a(-16777216, BizVideoDetailUI.f(this.oph));
      BizVideoDetailUI.a(this.oph, true);
      BizVideoDetailUI.g(this.oph).O((View)BizVideoDetailUI.f(this.oph), paramInt);
      if ((paramInt == 0) || (paramInt == 180)) {
        BizVideoDetailUI.f(this.oph).setPageGestureInFullscreen(false);
      }
      for (;;)
      {
        localObject = BizVideoDetailUI.h(this.oph);
        if ((localObject == null) || (((FrameLayout)localObject).getVisibility() != 0))
        {
          localObject = BizVideoDetailUI.i(this.oph);
          p.g(localObject, "videoWifiTipsView");
          if (((MPVideoWifiTipsView)localObject).getVisibility() != 0) {}
        }
        else
        {
          localObject = BizVideoDetailUI.j(this.oph);
          p.g(localObject, "videoAdTitleBar");
          ((LinearLayout)localObject).setVisibility(0);
        }
        BizVideoDetailUI.k(this.oph).ooo.ed(5, 0);
        BizVideoDetailUI.l(this.oph);
        AppMethodBeat.o(7106);
        return;
        BizVideoDetailUI.f(this.oph).setPageGestureInFullscreen(true);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$2", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "bufferResolutionStartTime", "", "getBufferResolutionStartTime", "()J", "setBufferResolutionStartTime", "(J)V", "bufferSeekStartTime", "getBufferSeekStartTime", "setBufferSeekStartTime", "hasBufferingResolution", "", "getHasBufferingResolution", "()Z", "setHasBufferingResolution", "(Z)V", "hasBufferingSeek", "getHasBufferingSeek", "setHasBufferingSeek", "playEnd", "getPlayEnd", "setPlayEnd", "startPlayTime", "getStartPlayTime", "setStartPlayTime", "startWaitTime", "getStartWaitTime", "setStartWaitTime", "onControlbarVisible", "", "visible", "onEndDragProgress", "onGetVideoSize", "width", "", "height", "onHideSwitchResolutionLayout", "onHideSwitchSpeedLayout", "onPlayError", "errorMsg", "", "errorCode", "onSeekPre", "onSeekTo", "time", "onStartDragProgress", "onUpdateProgress", "progressLen", "totalLen", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoPrepare", "firstRenderTime", "onVideoWaiting", "onVideoWaitingEnd", "resolutionBtnClick", "speedBtnClick", "switchResolution", "beforeType", "afterType", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "switchSpeed", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
  public static final class p
    implements MPVideoView.c
  {
    private long hLG = -1L;
    private long opk = -1L;
    private boolean opl;
    private long opm = -1L;
    private long opn = -1L;
    private boolean opo;
    private boolean opp;
    
    public final void XU(String paramString)
    {
      AppMethodBeat.i(7117);
      p.h(paramString, "errorMsg");
      BizVideoDetailUI.k(this.oph).ooo.orD = paramString;
      BizVideoDetailUI.k(this.oph).ooo.ed(11, 0);
      BizVideoDetailUI.p(this.oph).setPlayError$505cff1c(paramString);
      BizVideoDetailUI.q(this.oph);
      BizVideoDetailUI.a(this.oph, "error", paramString);
      if (BizVideoDetailUI.f(this.oph).getPlayStarted()) {
        com.tencent.mm.plugin.webview.h.a.WZ(25);
      }
      for (;;)
      {
        BizVideoDetailUI.d(this.oph).XY("21");
        BizVideoDetailUI.d(this.oph).XY("22");
        Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
        localObject = BizVideoDetailUI.d(this.oph).XX("16");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, "PlayErrReason", paramString);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, BizVideoDetailUI.d(this.oph));
        AppMethodBeat.o(7117);
        return;
        com.tencent.mm.plugin.webview.h.a.WZ(24);
      }
    }
    
    public final void a(int paramInt1, int paramInt2, fu paramfu)
    {
      Object localObject2 = null;
      AppMethodBeat.i(175503);
      this.oph.ooP = true;
      BizVideoDetailUI.k(this.oph).ooo.orH = paramInt1;
      BizVideoDetailUI.k(this.oph).ooo.orG = paramInt2;
      BizVideoDetailUI.k(this.oph).ooo.ed(22, 0);
      BizVideoDetailUI.d(this.oph).XY("21");
      BizVideoDetailUI.d(this.oph).XY("22");
      Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
      es locales = BizVideoDetailUI.d(this.oph).XX("4");
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "DefinitionBefore", String.valueOf(paramInt1));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "DefinitionAfter", String.valueOf(paramInt2));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "WidthBefore", String.valueOf(BizVideoDetailUI.k(this.oph).ooo.width));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "HeightBefore", String.valueOf(BizVideoDetailUI.k(this.oph).ooo.height));
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
      if (paramfu != null) {}
      for (localObject1 = Integer.valueOf(paramfu.width);; localObject1 = null)
      {
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "WidthAfter", String.valueOf(localObject1));
        localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
        localObject1 = localObject2;
        if (paramfu != null) {
          localObject1 = Integer.valueOf(paramfu.height);
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "HeightAfter", String.valueOf(localObject1));
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, BizVideoDetailUI.d(this.oph));
        com.tencent.mm.plugin.webview.h.a.WZ(81);
        this.opn = System.currentTimeMillis();
        if (paramfu != null)
        {
          BizVideoDetailUI.k(this.oph).ood = paramfu.ood;
          BizVideoDetailUI.k(this.oph).ooe = paramfu.Fyd;
          BizVideoDetailUI.k(this.oph).ooo.width = paramfu.width;
          BizVideoDetailUI.k(this.oph).ooo.height = paramfu.height;
        }
        BizVideoDetailUI.a(this.oph, "switchVideo", "");
        AppMethodBeat.o(175503);
        return;
      }
    }
    
    public final void a(c.a parama1, c.a parama2)
    {
      AppMethodBeat.i(210100);
      BizVideoDetailUI.d(this.oph).XY("21");
      BizVideoDetailUI.d(this.oph).XY("22");
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
      es locales = BizVideoDetailUI.d(this.oph).XX("19");
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
      if (parama1 != null)
      {
        localObject = String.valueOf(parama1.otK);
        parama1 = (c.a)localObject;
        if (localObject != null) {}
      }
      else
      {
        parama1 = "";
      }
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "SpeedBefore", parama1);
      parama1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
      if (parama2 != null)
      {
        parama2 = String.valueOf(parama2.otK);
        parama1 = parama2;
        if (parama2 != null) {}
      }
      else
      {
        parama1 = "";
      }
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, "SpeedAfter", parama1);
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(locales, BizVideoDetailUI.d(this.oph));
      AppMethodBeat.o(210100);
    }
    
    public final void aqD()
    {
      AppMethodBeat.i(210099);
      BizVideoDetailUI.a(this.oph, "seekBegin", "");
      BizVideoDetailUI.d(this.oph).XY("21");
      BizVideoDetailUI.d(this.oph).XY("22");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(BizVideoDetailUI.d(this.oph).XX("20"), BizVideoDetailUI.d(this.oph));
      AppMethodBeat.o(210099);
    }
    
    public final void bRR()
    {
      AppMethodBeat.i(175502);
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i locali = this.oph.ooH;
      MPVideoView localMPVideoView = BizVideoDetailUI.f(this.oph);
      p.h(localMPVideoView, "videoVideo");
      locali.oqX = localMPVideoView;
      if (!localMPVideoView.bmN()) {
        locali.bSc();
      }
      AppMethodBeat.o(175502);
    }
    
    public final void bRS()
    {
      AppMethodBeat.i(7113);
      BizVideoDetailUI.k(this.oph).ooo.ed(12, 0);
      this.opm = System.currentTimeMillis();
      BizVideoDetailUI.a(this.oph, "seekEnd", "");
      AppMethodBeat.o(7113);
    }
    
    public final void bRT()
    {
      AppMethodBeat.i(7114);
      BizVideoDetailUI.k(this.oph).ooo.ed(13, 0);
      this.opm = System.currentTimeMillis();
      BizVideoDetailUI.a(this.oph, "seekEnd", "");
      AppMethodBeat.o(7114);
    }
    
    public final void bRU()
    {
      AppMethodBeat.i(7116);
      String str;
      if (this.opp)
      {
        BizVideoDetailUI.k(this.oph).ooo.eR((int)(System.currentTimeMillis() - this.opk), 31);
        str = "3";
      }
      for (;;)
      {
        Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
        localObject = BizVideoDetailUI.d(this.oph).XX("17");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, "BufferReason", str);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, BizVideoDetailUI.d(this.oph), String.valueOf(System.currentTimeMillis() - 500L));
        this.opn = -1L;
        this.opm = -1L;
        this.opp = false;
        this.opo = false;
        if (!BizVideoDetailUI.f(this.oph).isPlaying()) {
          break;
        }
        BizVideoDetailUI.a(this.oph, "play", "");
        AppMethodBeat.o(7116);
        return;
        if (this.opo)
        {
          BizVideoDetailUI.k(this.oph).ooo.eR((int)(System.currentTimeMillis() - this.opk), 30);
          str = "2";
        }
        else
        {
          BizVideoDetailUI.k(this.oph).ooo.eR((int)(System.currentTimeMillis() - this.opk), 29);
          str = "1";
        }
      }
      BizVideoDetailUI.a(this.oph, "pause", "");
      AppMethodBeat.o(7116);
    }
    
    public final void bRV()
    {
      AppMethodBeat.i(7119);
      BizVideoDetailUI.s(this.oph);
      this.oph.bRO();
      AppMethodBeat.o(7119);
    }
    
    public final void bRW()
    {
      AppMethodBeat.i(7121);
      BizVideoDetailUI.k(this.oph).ooo.ed(21, 0);
      this.oph.ooP = true;
      this.oph.bRD();
      com.tencent.mm.plugin.webview.h.a.WZ(80);
      BizVideoDetailUI.a(this.oph, 0L);
      AppMethodBeat.o(7121);
    }
    
    public final void bRX()
    {
      boolean bool = true;
      AppMethodBeat.i(175504);
      this.oph.ooP = false;
      BizVideoDetailUI localBizVideoDetailUI;
      if ((this.oph.ooM) && (BizVideoDetailUI.f(this.oph).isPlaying()))
      {
        localBizVideoDetailUI = this.oph;
        if (BizVideoDetailUI.f(this.oph).getCurrPosSec() <= 1) {
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
    
    public final void bmX()
    {
      AppMethodBeat.i(210098);
      BizVideoDetailUI.a(this.oph, "seekBegin", "");
      BizVideoDetailUI.d(this.oph).XY("21");
      BizVideoDetailUI.d(this.oph).XY("22");
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(BizVideoDetailUI.d(this.oph).XX("20"), BizVideoDetailUI.d(this.oph));
      AppMethodBeat.o(210098);
    }
    
    public final void jp(boolean paramBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(7118);
      BizVideoDetailUI.r(this.oph);
      if (paramBoolean)
      {
        BizVideoDetailUI.a(this.oph, 0L);
        AppMethodBeat.o(7118);
        return;
      }
      BizVideoDetailUI localBizVideoDetailUI;
      if (this.oph.ooM)
      {
        localBizVideoDetailUI = this.oph;
        if (BizVideoDetailUI.f(this.oph).getCurrPosSec() <= 1) {
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
      BizVideoDetailUI.k(this.oph).ooo.ed(7, 0);
      BizVideoDetailUI.a(this.oph, "ended", "");
      this.oph.bRD();
      BizVideoDetailUI.o(this.oph);
      if (!this.opl)
      {
        this.opl = true;
        com.tencent.mm.plugin.webview.h.a.WZ(27);
      }
      AppMethodBeat.o(7112);
    }
    
    public final void onVideoPause()
    {
      AppMethodBeat.i(7111);
      if (BizVideoDetailUI.f(this.oph).getPlayStatus() == 2) {
        BizVideoDetailUI.k(this.oph).ooo.ed(8, 0);
      }
      BizVideoDetailUI.a(this.oph, "pause", "");
      BizVideoDetailUI.d(this.oph).XY("21");
      BizVideoDetailUI.d(this.oph).XX("22");
      AppMethodBeat.o(7111);
    }
    
    public final void onVideoPlay()
    {
      AppMethodBeat.i(7110);
      this.oph.ooP = false;
      BizVideoDetailUI.k(this.oph);
      int i = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.Ab(BizVideoDetailUI.f(this.oph).getPlayStatus());
      BizVideoDetailUI.k(this.oph).ooo.ed(i, 0);
      BizVideoDetailUI.n(this.oph);
      BizVideoDetailUI.a(this.oph, "play", "");
      if (this.hLG < 0L)
      {
        com.tencent.mm.plugin.webview.h.a.WZ(6);
        if (this.oph.ooN) {
          com.tencent.mm.plugin.webview.h.a.WZ(19);
        }
        this.hLG = System.currentTimeMillis();
      }
      Object localObject1;
      if ((this.oph.ooM) && (!this.oph.ooP) && ((!BizVideoDetailUI.f(this.oph).bSD()) || (!BizVideoDetailUI.f(this.oph).bmN())))
      {
        localObject1 = this.oph;
        if (BizVideoDetailUI.f(this.oph).getCurrPosSec() <= 1) {
          break label430;
        }
      }
      label430:
      for (boolean bool = true;; bool = false)
      {
        BizVideoDetailUI.b((BizVideoDetailUI)localObject1, bool);
        aq.o((Runnable)new a(this), 300L);
        localObject1 = this.oph.ooH;
        Object localObject2 = (d.g.a.a)new b(this);
        p.h(localObject2, "onUpdateView");
        if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqU != 0) && (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).ora <= 0) && (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqS == ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).ltA) && (((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqR <= ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqV) && (!((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).bSb()))
        {
          Object localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqX;
          if ((localObject3 != null) && (((MPVideoView)localObject3).isPlaying() == true))
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqT = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).bEk;
            localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).orb;
            if (localObject3 != null) {
              ((ValueAnimator)localObject3).removeAllUpdateListeners();
            }
            ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).orb = ValueAnimator.ofInt(new int[] { ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqR, ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).oqU });
            localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).orb;
            if (localObject3 != null) {
              ((ValueAnimator)localObject3).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new i.f((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1, (d.g.a.a)localObject2));
            }
            localObject2 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).orb;
            if (localObject2 != null) {
              ((ValueAnimator)localObject2).setDuration(200L);
            }
            localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i)localObject1).orb;
            if (localObject1 != null) {
              ((ValueAnimator)localObject1).start();
            }
          }
        }
        BizVideoDetailUI.d(this.oph).XY("22");
        BizVideoDetailUI.d(this.oph).XX("21");
        AppMethodBeat.o(7110);
        return;
      }
    }
    
    public final void onVideoWaiting()
    {
      AppMethodBeat.i(7115);
      if (this.hLG > 0L) {
        BizVideoDetailUI.n(this.oph);
      }
      this.opk = System.currentTimeMillis();
      BizVideoDetailUI.a(this.oph, "waiting", "");
      if ((this.opn != -1L) && ((int)(System.currentTimeMillis() - this.opn) < 1000L)) {
        this.opp = true;
      }
      for (;;)
      {
        BizVideoDetailUI.d(this.oph).XY("21");
        BizVideoDetailUI.d(this.oph).XY("22");
        BizVideoDetailUI.d(this.oph).XX("17");
        AppMethodBeat.o(7115);
        return;
        if ((this.opm != -1L) && ((int)(System.currentTimeMillis() - this.opm) < 1000L)) {
          this.opo = true;
        }
      }
    }
    
    public final void tt(long paramLong)
    {
      AppMethodBeat.i(177795);
      BizVideoDetailUI.k(this.oph).ooo.ed(32, (int)paramLong);
      ad.v(BizVideoDetailUI.m(this.oph), "[KEY_TIME] onVideoPrepare firstRenderTime = ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(177795);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BizVideoDetailUI.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7108);
        BizVideoDetailUI.bRQ();
        AppMethodBeat.o(7108);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7122);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      BizVideoDetailUI.f(this.oph).p(false, 0);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(7122);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "e", "Landroid/view/MotionEvent;", "onTouch"})
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
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = BizVideoDetailUI.f(this.oph);
      localObject = (View)this.oph.bQL();
      p.g(paramMotionEvent, "e");
      p.h(localObject, "v");
      p.h(paramMotionEvent, "e");
      boolean bool;
      switch (paramMotionEvent.getAction())
      {
      default: 
        bool = paramView.oua;
      }
      for (;;)
      {
        if (bool)
        {
          BizVideoDetailUI.f(this.oph).O(paramMotionEvent);
          if (paramMotionEvent.getAction() == 1) {
            paramMotionEvent.setAction(3);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(7123);
        return false;
        if ((!paramView.oub) && (paramMotionEvent.getY() >= ((View)localObject).getY()) && (paramMotionEvent.getY() <= ((View)localObject).getY() + paramView.getHeight()) && (paramMotionEvent.getX() >= ((View)localObject).getX()) && (paramMotionEvent.getX() <= ((View)localObject).getX() + paramView.getWidth())) {
          paramView.oua = true;
        }
        paramView.oub = true;
        break;
        bool = paramView.oua;
        paramView.oua = false;
        paramView.oub = false;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class s
    implements View.OnClickListener
  {
    s(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7124);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if (BizVideoDetailUI.f(this.oph).isPlaying())
      {
        BizVideoDetailUI.f(this.oph).pause();
        paramView = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.orL;
        m.a.Ac(37);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7124);
        return;
        BizVideoDetailUI.f(this.oph).start();
        paramView = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.orL;
        m.a.Ac(38);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$onShowAd$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
  public static final class u
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(7126);
      Object localObject = BizVideoDetailUI.h(this.oph);
      if (localObject != null)
      {
        localObject = ((FrameLayout)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      localObject = this.oph.DzP;
      if (localObject != null) {
        ((com.tencent.mm.plugin.webview.c.f)localObject).aGH("appear");
      }
      localObject = this.oph.ooI;
      if (localObject != null)
      {
        localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.webview.c.f)localObject).aGH("appear");
          AppMethodBeat.o(7126);
          return;
        }
      }
      AppMethodBeat.o(7126);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$onShowDot$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
  public static final class v
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(7127);
      Object localObject = BizVideoDetailUI.u(this.oph);
      if (localObject != null)
      {
        localObject = ((FrameLayout)localObject).getViewTreeObserver();
        if (localObject != null) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      if (this.oph.ooJ != null)
      {
        ad.i(BizVideoDetailUI.m(this.oph), "onShowDot appear");
        localObject = this.oph.DzP;
        int i;
        MMWebViewWithJsApi localMMWebViewWithJsApi;
        if (localObject != null)
        {
          i = this.oph.bRN();
          localMMWebViewWithJsApi = this.oph.ooJ;
          if (localMMWebViewWithJsApi == null) {
            p.gfZ();
          }
          ((com.tencent.mm.plugin.webview.c.f)localObject).N(i, localMMWebViewWithJsApi.hashCode(), "appear");
        }
        localObject = this.oph.ooJ;
        if (localObject != null)
        {
          localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
          if (localObject != null)
          {
            i = this.oph.bRN();
            localMMWebViewWithJsApi = this.oph.ooJ;
            if (localMMWebViewWithJsApi == null) {
              p.gfZ();
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class w
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    w(BizVideoDetailUI paramBizVideoDetailUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$setTouchListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/LogoWebViewWrapper$MMOverScrollOffsetListener;", "onMMOverScrollOffset", "", "offset", "", "pointerDown", "", "onMMOverScrollUp", "plugin-brandservice_release"})
  public static final class x
    implements LogoWebViewWrapper.b
  {
    public final void S(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(7129);
      Object localObject1 = this.oph.bQL();
      Object localObject2 = this.oph.bQL().getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(7129);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      ((FrameLayout.LayoutParams)localObject2).topMargin = (this.oph.ooH.y - paramInt);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = BizVideoDetailUI.t(this.oph);
      p.g(localObject1, "animationLayout");
      if (((View)localObject1).getVisibility() == 0)
      {
        localObject1 = BizVideoDetailUI.t(this.oph);
        p.g(localObject1, "animationLayout");
        localObject2 = BizVideoDetailUI.t(this.oph);
        p.g(localObject2, "animationLayout");
        localObject2 = ((View)localObject2).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new d.v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(7129);
          throw ((Throwable)localObject1);
        }
        localObject2 = (FrameLayout.LayoutParams)localObject2;
        ((FrameLayout.LayoutParams)localObject2).topMargin = (this.oph.ooH.y - paramInt);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      AppMethodBeat.o(7129);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class y
    implements Runnable
  {
    y(BizVideoDetailUI paramBizVideoDetailUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(175506);
      BizVideoDetailUI.a(this.oph, 300L);
      AppMethodBeat.o(175506);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class z
    implements ValueAnimator.AnimatorUpdateListener
  {
    z(BizVideoDetailUI paramBizVideoDetailUI, y.d paramd) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(7133);
      if (BizVideoDetailUI.u(this.oph) != null)
      {
        localFrameLayout = BizVideoDetailUI.u(this.oph);
        if (localFrameLayout == null) {
          p.gfZ();
        }
        if (localFrameLayout.getVisibility() != 8) {}
      }
      else
      {
        AppMethodBeat.o(7133);
        return;
      }
      p.g(paramValueAnimator, "valueAnimator");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new d.v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(7133);
        throw paramValueAnimator;
      }
      int i = ((Integer)paramValueAnimator).intValue();
      FrameLayout localFrameLayout = BizVideoDetailUI.u(this.oph);
      if (localFrameLayout != null)
      {
        paramValueAnimator = BizVideoDetailUI.u(this.oph);
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
      if (i == this.ops.MLT) {
        BizVideoDetailUI.l(this.oph);
      }
      AppMethodBeat.o(7133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI
 * JD-Core Version:    0.7.0.1
 */