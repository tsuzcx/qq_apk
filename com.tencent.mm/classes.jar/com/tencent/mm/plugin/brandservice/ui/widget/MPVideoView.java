package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.a;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.n.n;
import d.v;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroudContainerLayout", "Landroid/widget/FrameLayout;", "getBackgroudContainerLayout", "()Landroid/widget/FrameLayout;", "setBackgroudContainerLayout", "(Landroid/widget/FrameLayout;)V", "cacheTimeSec", "getCacheTimeSec", "()I", "currPosMs", "getCurrPosMs", "currPosSec", "getCurrPosSec", "dotContainerLayout", "getDotContainerLayout", "setDotContainerLayout", "duration", "getDuration", "setDuration", "(I)V", "endPlayTime", "getEndPlayTime", "hasDownInTouchEvent", "", "hasRealPlayTime", "isCoverVisible", "()Z", "isInFullScreen", "isLive", "mAdjustContentTv", "Landroid/widget/TextView;", "mAdjustIconIv", "Landroid/widget/ImageView;", "mAdjustInfoLayout", "Landroid/widget/LinearLayout;", "mAdjustPercentIndicator", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/AppBrandDotPercentIndicator;", "mAutoPlay", "mBottomProgressBackBar", "mBottomProgressFrontBar", "mBottomProgressLayout", "mConsumeTouchEvent", "mControlBar", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar;", "mCoverArea", "Landroid/view/View;", "mCoverPlayBtnArea", "mCoverTotalTimeTv", "mCoverUrl", "", "mDirection", "mDuration", "mEnablePlayGesture", "mEnableProgressGesture", "mFullScreenDelegate", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "mGestureController", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController;", "mInitialTime", "mIsAlive", "mIsLoading", "mIsMute", "mIsShowBasicControls", "mLoop", "mMPVideoViewCallBack", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "mPageGesture", "mPageGestureInFullscreen", "mPlayStart", "mPlayStarted", "mProgressTv", "mRealPlayTime", "", "mSetIsShowCoverPlayBtn", "mSetIsShowProgressBar", "mSkipAutoPause", "mStartPlayTime", "mVideoSource", "mVideoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper;", "needHandleTouchEvent", "getNeedHandleTouchEvent", "setNeedHandleTouchEvent", "(Z)V", "playStatus", "getPlayStatus", "setPlayStatus", "playerAdContainerLayout", "getPlayerAdContainerLayout", "setPlayerAdContainerLayout", "realPlayTime", "getRealPlayTime", "()J", "videoHeight", "getVideoHeight", "setVideoHeight", "<set-?>", "videoPath", "getVideoPath", "()Ljava/lang/String;", "videoWidth", "getVideoWidth", "setVideoWidth", "canAdjustBrightnessVolume", "canDragProgress", "clean", "", "doOnTouchEvent", "event", "Landroid/view/MotionEvent;", "downloadVideo", "videoUrl", "enableProgressGesture", "enable", "getAutoPlay", "getPlayStart", "getPlayStarted", "getTimeShowString", "time", "hideCenterPlayBtnIfNeed", "hideCover", "init", "initControlBar", "initGestureController", "initParam", "initVideoViewCallback", "isControlBarShow", "isPlaying", "makeTimeString", "d", "onExitFullScreen", "onTouchEvent", "onUIDestroy", "onUIPause", "onUIResume", "operateFullScreen", "toFullScreen", "direction", "pause", "seekTo", "position", "afterPlay", "setAutoPlay", "autoPlay", "setBizInfo", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "iconUrl", "setConsumeTouchEvent", "value", "setCoverByUrl", "cover", "coverUrl", "width", "height", "setEnablePlayGesture", "enablePlayGesture", "setExoPlayerParam", "maxInitialBitrate", "bandwidthFraction", "", "minDurForQualityMs", "maxDurForQualityMs", "minBufferMs", "maxBufferMs", "setFullScreenDelegate", "delegate", "setFullScreenDirection", "setInitialTime", "initialTime", "setIsShowBasicControls", "isShowBasicControls", "setLoop", "loop", "setMPVideoViewCallBack", "setMute", "isMute", "setObjectFit", "setPageGesture", "pageGesture", "setPageGestureInFullscreen", "pageGestureInFullscreen", "setPlayBtnOnClickListener", "click", "Landroid/view/View$OnClickListener;", "setPlayBtnPosition", "playBtnPosition", "setPreLoadVidePath", "setShowCenterPlayBtn", "showCenterPlayBtn", "setShowControlProgress", "showControlProgress", "setShowFullScreenBtn", "showFullScreenBtn", "setShowMuteBtn", "showMuteBtn", "setShowPlayBtn", "showPlayBtn", "setShowProgress", "showProgress", "setTitle", "title", "setVideoPath", "durationSec", "setVideoSource", "videoSource", "setVideoUrlInfo", "urlInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "currentInfo", "shouldDispatchEventToGestureController", "shouldHandleTouchEvent", "v", "e", "showCenterPlayBtnIfNeed", "showControlBar", "showCover", "start", "startWhenNetWorkConnect", "stop", "updateBottomProgressLayout", "updateControlBarDotPos", "list", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "updateLiveUI", "updateRealPlayTime", "updateStartTime", "Companion", "FullScreenDelegate", "MPVideoViewCallBack", "plugin-brandservice_release"})
public final class MPVideoView
  extends RelativeLayout
{
  public static final String TAG = "MicroMsg.MPVideoView";
  private static final int nov = -1;
  private static final int now = 8;
  public static final MPVideoView.a nox;
  private int aag;
  private int ark;
  private boolean ckP;
  private int hxT;
  private TextView kmL;
  private View kmO;
  private View kmP;
  private TextView kmQ;
  private LinearLayout kmR;
  private AppBrandDotPercentIndicator kmS;
  private TextView kmT;
  private ImageView kmU;
  private ImageView kmW;
  private ImageView kmX;
  private FrameLayout kmY;
  private boolean knc;
  private boolean kne;
  private boolean knf;
  private com.tencent.mm.plugin.appbrand.jsapi.video.ui.a kng;
  private boolean kni;
  private boolean knj;
  private String knl;
  private boolean knm;
  private boolean knn;
  private boolean kno;
  private boolean knq;
  private int knr;
  private boolean knt;
  private boolean knu;
  public boolean knv;
  private boolean mIsMute;
  public MPExoVideoWrapper nog;
  public MPVideoViewControlBar noh;
  private FrameLayout noi;
  private FrameLayout noj;
  private FrameLayout nok;
  private boolean nol;
  private boolean nom;
  private b non;
  private c noo;
  private int nop;
  private long noq;
  private long nor;
  private boolean nos;
  public boolean not;
  public boolean nou;
  private int videoHeight;
  private String videoPath;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(7587);
    nox = new MPVideoView.a((byte)0);
    TAG = "MicroMsg.MPVideoView";
    nov = -1;
    now = 8;
    AppMethodBeat.o(7587);
  }
  
  public MPVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(7584);
    this.aag = nov;
    init(paramContext);
    AppMethodBeat.o(7584);
  }
  
  public MPVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7585);
    this.aag = nov;
    init(paramContext);
    AppMethodBeat.o(7585);
  }
  
  public MPVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(7586);
    this.aag = nov;
    init(paramContext);
    AppMethodBeat.o(7586);
  }
  
  private final boolean aXf()
  {
    AppMethodBeat.i(7537);
    Object localObject = TAG;
    boolean bool = this.kni;
    MPExoVideoWrapper localMPExoVideoWrapper = this.nog;
    if (localMPExoVideoWrapper == null) {
      k.fvU();
    }
    ad.i((String)localObject, "isLive %b %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localMPExoVideoWrapper.bqS) });
    if (!this.kni)
    {
      localObject = this.nog;
      if (localObject == null) {
        k.fvU();
      }
      if (!((MPExoVideoWrapper)localObject).bqS) {}
    }
    else
    {
      AppMethodBeat.o(7537);
      return true;
    }
    AppMethodBeat.o(7537);
    return false;
  }
  
  private final boolean bGN()
  {
    AppMethodBeat.i(175553);
    if (this.knu)
    {
      AppMethodBeat.o(175553);
      return true;
    }
    boolean bool = bci();
    if (!bcj())
    {
      AppMethodBeat.o(175553);
      return false;
    }
    AppMethodBeat.o(175553);
    return bool;
  }
  
  private final void bce()
  {
    AppMethodBeat.i(7574);
    MPVideoViewControlBar localMPVideoViewControlBar = this.noh;
    if (localMPVideoViewControlBar == null) {
      k.fvU();
    }
    localMPVideoViewControlBar.bce();
    AppMethodBeat.o(7574);
  }
  
  private final boolean bci()
  {
    AppMethodBeat.i(7582);
    if (this.knn)
    {
      MPExoVideoWrapper localMPExoVideoWrapper = this.nog;
      if (localMPExoVideoWrapper == null) {
        k.fvU();
      }
      if ((!localMPExoVideoWrapper.bqS) && (!bck()))
      {
        AppMethodBeat.o(7582);
        return true;
      }
    }
    AppMethodBeat.o(7582);
    return false;
  }
  
  private final boolean bcj()
  {
    AppMethodBeat.i(7583);
    if ((!bck()) && (((!bcg()) && (this.kne)) || ((bcg()) && (this.knf))))
    {
      AppMethodBeat.o(7583);
      return true;
    }
    AppMethodBeat.o(7583);
    return false;
  }
  
  private final boolean bck()
  {
    AppMethodBeat.i(7538);
    View localView = this.kmO;
    if (localView == null) {
      k.fvU();
    }
    if (localView.getVisibility() == 0)
    {
      AppMethodBeat.o(7538);
      return true;
    }
    AppMethodBeat.o(7538);
    return false;
  }
  
  private void clean()
  {
    AppMethodBeat.i(7555);
    ad.i(TAG, "clean");
    stop();
    Object localObject = this.nog;
    if (localObject == null) {
      k.fvU();
    }
    ((MPExoVideoWrapper)localObject).onUIDestroy();
    localObject = this.noh;
    if (localObject == null) {
      k.fvU();
    }
    ((MPVideoViewControlBar)localObject).onDestroy();
    AppMethodBeat.o(7555);
  }
  
  private final void init(Context paramContext)
  {
    AppMethodBeat.i(7539);
    LayoutInflater.from(paramContext).inflate(2131494957, (ViewGroup)this);
    this.nog = ((MPExoVideoWrapper)findViewById(2131306410));
    paramContext = findViewById(2131303515);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kmL = ((TextView)paramContext);
    this.kmO = findViewById(2131298814);
    this.kmP = findViewById(2131298828);
    paramContext = findViewById(2131298832);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kmQ = ((TextView)paramContext);
    paramContext = findViewById(2131296505);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kmR = ((LinearLayout)paramContext);
    paramContext = findViewById(2131296506);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kmS = ((AppBrandDotPercentIndicator)paramContext);
    paramContext = findViewById(2131296502);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kmT = ((TextView)paramContext);
    paramContext = findViewById(2131296504);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kmU = ((ImageView)paramContext);
    paramContext = findViewById(2131303297);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kmW = ((ImageView)paramContext);
    paramContext = findViewById(2131303296);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kmX = ((ImageView)paramContext);
    paramContext = findViewById(2131303298);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kmY = ((FrameLayout)paramContext);
    paramContext = findViewById(2131303293);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.noi = ((FrameLayout)paramContext);
    paramContext = findViewById(2131303299);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.noj = ((FrameLayout)paramContext);
    paramContext = findViewById(2131303294);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.nok = ((FrameLayout)paramContext);
    paramContext = this.kmS;
    if (paramContext == null) {
      k.fvU();
    }
    paramContext.setDotsNum(now);
    paramContext = findViewById(2131298827);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    ((ImageView)paramContext).setOnClickListener((View.OnClickListener)new MPVideoView.d(this));
    this.kng = new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a(getContext(), (View)this, (a.b)new o(this));
    paramContext = this.nog;
    if (paramContext == null) {
      k.fvU();
    }
    paramContext.setIMMVideoViewCallback((h.b)new p(this));
    this.noh = new MPVideoViewControlBar(getContext());
    paramContext = this.nog;
    if (paramContext == null) {
      k.fvU();
    }
    MPVideoViewControlBar localMPVideoViewControlBar = this.noh;
    if (localMPVideoViewControlBar == null) {
      k.fvU();
    }
    paramContext.setVideoFooterView((g)localMPVideoViewControlBar);
    paramContext = this.noh;
    if (paramContext == null) {
      k.fvU();
    }
    paramContext.hide();
    paramContext = this.noh;
    if (paramContext == null) {
      k.fvU();
    }
    paramContext.setFullScreenBtnOnClickListener((View.OnClickListener)new MPVideoView.e(this));
    paramContext = this.noh;
    if (paramContext == null) {
      k.fvU();
    }
    paramContext.setIplaySeekCallback((e.d)new g(this));
    paramContext = this.noh;
    if (paramContext == null) {
      k.fvU();
    }
    paramContext.setOnPlayButtonClickListener((View.OnClickListener)new MPVideoView.h(this));
    paramContext = this.noh;
    if (paramContext == null) {
      k.fvU();
    }
    paramContext.setStatePorter((e.i)new MPVideoView.i(this));
    paramContext = this.noh;
    if (paramContext == null) {
      k.fvU();
    }
    paramContext.setMuteBtnOnClickListener((View.OnClickListener)new MPVideoView.j(this));
    paramContext = this.noh;
    if (paramContext == null) {
      k.fvU();
    }
    paramContext.setExitFullScreenBtnOnClickListener((View.OnClickListener)new MPVideoView.k(this));
    paramContext = this.noh;
    if (paramContext == null) {
      k.fvU();
    }
    paramContext.a((e.f)new MPVideoView.l(this));
    paramContext = this.noh;
    if (paramContext == null) {
      k.fvU();
    }
    paramContext.setOnUpdateProgressLenListener((e.e)new m(this));
    paramContext = this.noh;
    if (paramContext == null) {
      k.fvU();
    }
    paramContext.setSwitchResolutionListener((MPVideoViewControlBar.a)new n(this));
    paramContext = this.noh;
    if (paramContext == null) {
      k.fvU();
    }
    paramContext.setSwitchSpeedListener((MPVideoViewControlBar.b)new f(this));
    paramContext = this.nog;
    if (paramContext == null) {
      k.fvU();
    }
    paramContext = paramContext.getCoverIv();
    if (paramContext == null) {
      k.fvU();
    }
    paramContext.setScaleType(ImageView.ScaleType.FIT_CENTER);
    setShowProgress(true);
    setShowControlProgress(true);
    setPageGesture(false);
    setPageGestureInFullscreen(true);
    setEnablePlayGesture(true);
    setShowMuteBtn(true);
    setShowFullScreenBtn(true);
    setShowPlayBtn(true);
    setShowCenterPlayBtn(false);
    ad.i(TAG, "enableProgressGesture %b", new Object[] { Boolean.TRUE });
    this.knn = true;
    setVideoSource(0);
    setConsumeTouchEvent(false);
    setIsShowBasicControls(true);
    AppMethodBeat.o(7539);
  }
  
  private static String rW(int paramInt)
  {
    AppMethodBeat.i(7580);
    String str = rX(paramInt / 60) + ":" + rX(paramInt % 60);
    AppMethodBeat.o(7580);
    return str;
  }
  
  private static String rX(int paramInt)
  {
    AppMethodBeat.i(7581);
    if (paramInt < 10)
    {
      str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(7581);
      return str;
    }
    String str = String.valueOf(paramInt);
    AppMethodBeat.o(7581);
    return str;
  }
  
  public final boolean S(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(175552);
    k.h(paramMotionEvent, "event");
    if (bGN())
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.ui.a locala = this.kng;
      if (locala != null) {
        locala.A(paramMotionEvent);
      }
      AppMethodBeat.o(175552);
      return true;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if ((this.knc) && (!this.knq))
      {
        paramMotionEvent = this.noh;
        if (paramMotionEvent == null) {
          k.fvU();
        }
        paramMotionEvent.bcz();
      }
      paramMotionEvent = this.kmO;
      if (paramMotionEvent == null) {
        k.fvU();
      }
      if ((paramMotionEvent.getVisibility() != 0) && (this.knt)) {
        bce();
      }
    }
    boolean bool = this.knm;
    AppMethodBeat.o(175552);
    return bool;
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(175550);
    MPExoVideoWrapper localMPExoVideoWrapper = this.nog;
    if (localMPExoVideoWrapper == null) {
      k.fvU();
    }
    localMPExoVideoWrapper.a(paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(175550);
  }
  
  public final void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, x paramx)
  {
    AppMethodBeat.i(7559);
    k.h(paramx, "msgInfo");
    ad.i(TAG, "setCover coverUrl=%s", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7559);
      return;
    }
    this.knl = paramString;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l locall = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.nlS;
    if (paramString == null) {
      k.fvU();
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(paramImageView, paramString, paramInt1, paramInt2, paramx);
    AppMethodBeat.o(7559);
  }
  
  public final void a(LinkedList<fn> paramLinkedList, fn paramfn)
  {
    AppMethodBeat.i(175551);
    k.h(paramLinkedList, "urlInfoList");
    k.h(paramfn, "currentInfo");
    MPVideoViewControlBar localMPVideoViewControlBar = this.noh;
    if (localMPVideoViewControlBar == null) {
      k.fvU();
    }
    localMPVideoViewControlBar.a(paramLinkedList, paramfn);
    AppMethodBeat.o(175551);
  }
  
  public final void bGE()
  {
    AppMethodBeat.i(7561);
    MPExoVideoWrapper localMPExoVideoWrapper = this.nog;
    if (localMPExoVideoWrapper == null) {
      k.fvU();
    }
    localMPExoVideoWrapper.bGE();
    AppMethodBeat.o(7561);
  }
  
  public final void bGF()
  {
    AppMethodBeat.i(7562);
    MPExoVideoWrapper localMPExoVideoWrapper = this.nog;
    if (localMPExoVideoWrapper == null) {
      k.fvU();
    }
    localMPExoVideoWrapper.bGF();
    AppMethodBeat.o(7562);
  }
  
  public final void bGM()
  {
    long l1 = 0L;
    AppMethodBeat.i(193382);
    long l2 = System.currentTimeMillis();
    long l3 = this.noq;
    if (this.nor != 0L) {
      l1 = l2 - this.nor;
    }
    this.noq = (l1 + l3);
    this.nor = l2;
    this.nos = true;
    AppMethodBeat.o(193382);
  }
  
  public final void bGO()
  {
    AppMethodBeat.i(7578);
    MPVideoViewControlBar localMPVideoViewControlBar = this.noh;
    if (localMPVideoViewControlBar != null) {
      localMPVideoViewControlBar.bGT();
    }
    localMPVideoViewControlBar = this.noh;
    if (localMPVideoViewControlBar != null)
    {
      localMPVideoViewControlBar.show();
      AppMethodBeat.o(7578);
      return;
    }
    AppMethodBeat.o(7578);
  }
  
  public final boolean bGP()
  {
    AppMethodBeat.i(7579);
    MPVideoViewControlBar localMPVideoViewControlBar = this.noh;
    if (localMPVideoViewControlBar != null)
    {
      boolean bool = localMPVideoViewControlBar.bcB();
      AppMethodBeat.o(7579);
      return bool;
    }
    AppMethodBeat.o(7579);
    return false;
  }
  
  public final boolean bcg()
  {
    AppMethodBeat.i(7536);
    if (this.non == null)
    {
      ad.w(TAG, "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(7536);
      return false;
    }
    b localb = this.non;
    if (localb == null) {
      k.fvU();
    }
    boolean bool = localb.isFullScreen();
    AppMethodBeat.o(7536);
    return bool;
  }
  
  public final void cv(String paramString, int paramInt)
  {
    AppMethodBeat.i(7556);
    k.h(paramString, "videoPath");
    ad.i(TAG, "setVideoPath path=%s isLive=%s", new Object[] { paramString, Boolean.FALSE });
    if (bt.isNullOrNil(paramString))
    {
      ad.v(TAG, "setVideoPath videoPath empty");
      AppMethodBeat.o(7556);
      return;
    }
    this.videoPath = paramString;
    stop();
    this.kni = false;
    MPExoVideoWrapper localMPExoVideoWrapper = this.nog;
    if (localMPExoVideoWrapper == null) {
      k.fvU();
    }
    localMPExoVideoWrapper.setVideoSource(this.knr);
    localMPExoVideoWrapper = this.nog;
    if (localMPExoVideoWrapper == null) {
      k.fvU();
    }
    localMPExoVideoWrapper.cu(paramString, paramInt);
    if (this.nop > 0)
    {
      paramString = this.nog;
      if (paramString == null) {
        k.fvU();
      }
      paramString.U(this.nop, this.ckP);
    }
    if (this.ckP)
    {
      ad.i(TAG, "setVideoPath autoPlay");
      start();
    }
    setMute(this.mIsMute);
    AppMethodBeat.o(7556);
  }
  
  public final boolean getAutoPlay()
  {
    return this.ckP;
  }
  
  public final FrameLayout getBackgroudContainerLayout()
  {
    return this.nok;
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(7535);
    if (this.nog != null)
    {
      MPExoVideoWrapper localMPExoVideoWrapper = this.nog;
      if (localMPExoVideoWrapper == null) {
        k.fvU();
      }
      int i = localMPExoVideoWrapper.getCacheTimeSec();
      AppMethodBeat.o(7535);
      return i;
    }
    AppMethodBeat.o(7535);
    return 0;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(7534);
    MPExoVideoWrapper localMPExoVideoWrapper = this.nog;
    if (localMPExoVideoWrapper == null) {
      k.fvU();
    }
    int i = localMPExoVideoWrapper.getCurrPosMs();
    AppMethodBeat.o(7534);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(7533);
    MPExoVideoWrapper localMPExoVideoWrapper = this.nog;
    if (localMPExoVideoWrapper == null) {
      k.fvU();
    }
    int i = localMPExoVideoWrapper.getCurrPosSec();
    AppMethodBeat.o(7533);
    return i;
  }
  
  public final FrameLayout getDotContainerLayout()
  {
    return this.noj;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(7531);
    if (this.ark > 0)
    {
      i = this.ark;
      AppMethodBeat.o(7531);
      return i;
    }
    MPExoVideoWrapper localMPExoVideoWrapper = this.nog;
    if (localMPExoVideoWrapper == null) {
      k.fvU();
    }
    int i = localMPExoVideoWrapper.getVideoDurationSec();
    AppMethodBeat.o(7531);
    return i;
  }
  
  public final int getEndPlayTime()
  {
    AppMethodBeat.i(7530);
    if ((getCurrPosMs() == 0) && (this.hxT != 0))
    {
      i = getDuration();
      AppMethodBeat.o(7530);
      return i * 1000;
    }
    int i = getCurrPosMs();
    AppMethodBeat.o(7530);
    return i;
  }
  
  public final boolean getNeedHandleTouchEvent()
  {
    return this.not;
  }
  
  public final boolean getPlayStart()
  {
    return this.nol;
  }
  
  public final boolean getPlayStarted()
  {
    return this.nom;
  }
  
  public final int getPlayStatus()
  {
    return this.hxT;
  }
  
  public final FrameLayout getPlayerAdContainerLayout()
  {
    return this.noi;
  }
  
  public final long getRealPlayTime()
  {
    AppMethodBeat.i(7529);
    if ((!this.nos) && (this.nor != 0L) && (isPlaying()))
    {
      l = (System.currentTimeMillis() - this.nor) / 1000L;
      AppMethodBeat.o(7529);
      return l;
    }
    long l = this.noq / 1000L;
    AppMethodBeat.o(7529);
    return l;
  }
  
  public final int getVideoHeight()
  {
    return this.videoHeight;
  }
  
  public final String getVideoPath()
  {
    return this.videoPath;
  }
  
  public final int getVideoWidth()
  {
    return this.videoWidth;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(7550);
    MPExoVideoWrapper localMPExoVideoWrapper = this.nog;
    if (localMPExoVideoWrapper == null) {
      k.fvU();
    }
    boolean bool = localMPExoVideoWrapper.isPlaying();
    AppMethodBeat.o(7550);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(7575);
    k.h(paramMotionEvent, "event");
    if (!bcg())
    {
      AppMethodBeat.o(7575);
      return false;
    }
    boolean bool = S(paramMotionEvent);
    AppMethodBeat.o(7575);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(7554);
    ad.i(TAG, "onUIDestroy");
    clean();
    AppMethodBeat.o(7554);
  }
  
  public final void p(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(7576);
    ad.i(TAG, "operateFullScreen toFullScreen:%b direction:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.non == null)
    {
      ad.w(TAG, "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(7576);
      return;
    }
    if (paramBoolean == bcg())
    {
      ad.i(TAG, "operateFullScreen current same");
      AppMethodBeat.o(7576);
      return;
    }
    if (paramInt == nov) {
      if (this.aag == nov)
      {
        paramInt = 90;
        ad.i(TAG, "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject = this.non;
        if (localObject == null) {
          k.fvU();
        }
        ((b)localObject).rM(paramInt);
        localObject = this.noh;
        if (localObject != null) {
          ((MPVideoViewControlBar)localObject).setDirection(paramInt);
        }
        localObject = this.noh;
        if (localObject != null) {
          ((MPVideoViewControlBar)localObject).bcC();
        }
        localObject = this.nog;
        if (localObject != null)
        {
          ((MPExoVideoWrapper)localObject).lpO = true;
          AppMethodBeat.o(7576);
          return;
          paramInt = this.aag;
          break;
        }
        AppMethodBeat.o(7576);
        return;
      }
      Object localObject = this.non;
      if (localObject != null) {
        ((b)localObject).bah();
      }
      localObject = this.noh;
      if (localObject != null) {
        ((MPVideoViewControlBar)localObject).bah();
      }
      localObject = this.nog;
      if (localObject != null)
      {
        ((MPExoVideoWrapper)localObject).lpO = false;
        AppMethodBeat.o(7576);
        return;
      }
      AppMethodBeat.o(7576);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(7552);
    ad.i(TAG, "pause");
    MPExoVideoWrapper localMPExoVideoWrapper = this.nog;
    if (localMPExoVideoWrapper == null) {
      k.fvU();
    }
    if (!localMPExoVideoWrapper.isPlaying())
    {
      AppMethodBeat.o(7552);
      return;
    }
    localMPExoVideoWrapper = this.nog;
    if (localMPExoVideoWrapper == null) {
      k.fvU();
    }
    localMPExoVideoWrapper.pause();
    AppMethodBeat.o(7552);
  }
  
  public final void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(7547);
    ad.i(TAG, "setAutoPlay =%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ckP = paramBoolean;
    if ((this.ckP) && (this.hxT == 0)) {
      this.hxT = 1;
    }
    AppMethodBeat.o(7547);
  }
  
  public final void setBackgroudContainerLayout(FrameLayout paramFrameLayout)
  {
    this.nok = paramFrameLayout;
  }
  
  public final void setConsumeTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(7540);
    ad.i(TAG, "setConsumeTouchEvent value=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knm = paramBoolean;
    AppMethodBeat.o(7540);
  }
  
  public final void setDotContainerLayout(FrameLayout paramFrameLayout)
  {
    this.noj = paramFrameLayout;
  }
  
  public final void setDuration(int paramInt)
  {
    AppMethodBeat.i(7532);
    if (paramInt <= 0)
    {
      ad.i(TAG, "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(7532);
      return;
    }
    TextView localTextView = this.kmQ;
    if (localTextView == null) {
      k.fvU();
    }
    localTextView.setText((CharSequence)rW(paramInt));
    this.ark = paramInt;
    AppMethodBeat.o(7532);
  }
  
  public final void setEnablePlayGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(7546);
    ad.i(TAG, "setEnablePlayGesture: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knu = paramBoolean;
    AppMethodBeat.o(7546);
  }
  
  public final void setFullScreenDelegate(b paramb)
  {
    AppMethodBeat.i(7572);
    k.h(paramb, "delegate");
    this.non = paramb;
    AppMethodBeat.o(7572);
  }
  
  public final void setFullScreenDirection(int paramInt)
  {
    AppMethodBeat.i(7568);
    ad.i(TAG, "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.aag = paramInt;
    AppMethodBeat.o(7568);
  }
  
  public final void setInitialTime(int paramInt)
  {
    AppMethodBeat.i(7571);
    ad.i(TAG, "setInitialTime initialTime=%s", new Object[] { Integer.valueOf(paramInt) });
    this.nop = paramInt;
    AppMethodBeat.o(7571);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(7558);
    ad.i(TAG, "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knc = paramBoolean;
    if (this.noh != null)
    {
      if (this.knc)
      {
        localMPVideoViewControlBar = this.noh;
        if (localMPVideoViewControlBar == null) {
          k.fvU();
        }
        localMPVideoViewControlBar.bcA();
        AppMethodBeat.o(7558);
        return;
      }
      MPVideoViewControlBar localMPVideoViewControlBar = this.noh;
      if (localMPVideoViewControlBar == null) {
        k.fvU();
      }
      localMPVideoViewControlBar.hide();
    }
    AppMethodBeat.o(7558);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(7549);
    ad.i(TAG, "setLoop loop=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knj = paramBoolean;
    AppMethodBeat.o(7549);
  }
  
  public final void setMPVideoViewCallBack(c paramc)
  {
    AppMethodBeat.i(7573);
    k.h(paramc, "delegate");
    this.noo = paramc;
    AppMethodBeat.o(7573);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(7567);
    ad.i(TAG, "setMute isMute=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    Object localObject = this.nog;
    if (localObject == null) {
      k.fvU();
    }
    ((MPExoVideoWrapper)localObject).setMute(paramBoolean);
    localObject = this.noh;
    if (localObject == null) {
      k.fvU();
    }
    ((MPVideoViewControlBar)localObject).setMuteBtnState(paramBoolean);
    AppMethodBeat.o(7567);
  }
  
  public final void setNeedHandleTouchEvent(boolean paramBoolean)
  {
    this.not = paramBoolean;
  }
  
  public final void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(7569);
    ad.i(TAG, "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kne = paramBoolean;
    AppMethodBeat.o(7569);
  }
  
  public final void setPageGestureInFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(7570);
    ad.i(TAG, "setPageGestureInFullscreen pageGestureInFullscreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knf = paramBoolean;
    AppMethodBeat.o(7570);
  }
  
  public final void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(7577);
    k.h(paramOnClickListener, "click");
    MPVideoViewControlBar localMPVideoViewControlBar = this.noh;
    if (localMPVideoViewControlBar != null)
    {
      localMPVideoViewControlBar.setPlayBtnOnClickListener(paramOnClickListener);
      AppMethodBeat.o(7577);
      return;
    }
    AppMethodBeat.o(7577);
  }
  
  public final void setPlayBtnPosition(String paramString)
  {
    AppMethodBeat.i(7545);
    k.h(paramString, "playBtnPosition");
    ad.i(TAG, "setPlayBtnPosition: %s", new Object[] { paramString });
    if ((!bt.isNullOrNil(paramString)) && (n.I(paramString, "center", true)))
    {
      paramString = this.noh;
      if (paramString == null) {
        k.fvU();
      }
      paramString.setPlayBtnInCenterPosition(true);
      AppMethodBeat.o(7545);
      return;
    }
    paramString = this.noh;
    if (paramString == null) {
      k.fvU();
    }
    paramString.setPlayBtnInCenterPosition(false);
    AppMethodBeat.o(7545);
  }
  
  public final void setPlayStatus(int paramInt)
  {
    this.hxT = paramInt;
  }
  
  public final void setPlayerAdContainerLayout(FrameLayout paramFrameLayout)
  {
    this.noi = paramFrameLayout;
  }
  
  public final void setShowCenterPlayBtn(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(7566);
    ad.i(TAG, "setPlayBtnInCenterPosition %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knq = paramBoolean;
    Object localObject = this.kmO;
    if (localObject == null) {
      k.fvU();
    }
    if (paramBoolean)
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.kmP;
      if (localObject == null) {
        k.fvU();
      }
      if (!paramBoolean) {
        break label131;
      }
    }
    label131:
    for (int i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      if ((this.knq) && (this.noh != null))
      {
        localObject = this.noh;
        if (localObject == null) {
          k.fvU();
        }
        ((MPVideoViewControlBar)localObject).hide();
      }
      AppMethodBeat.o(7566);
      return;
      i = 8;
      break;
    }
  }
  
  public final void setShowControlProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(7543);
    ad.i(TAG, "setShowControlProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.noh;
    if (localMPVideoViewControlBar == null) {
      k.fvU();
    }
    if ((paramBoolean) && (!aXf())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localMPVideoViewControlBar.setShowControlProgress(paramBoolean);
      AppMethodBeat.o(7543);
      return;
    }
  }
  
  public final void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(7564);
    ad.i(TAG, "setShowFullScreenBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.noh;
    if (localMPVideoViewControlBar == null) {
      k.fvU();
    }
    localMPVideoViewControlBar.setShowFullScreenBtn(paramBoolean);
    AppMethodBeat.o(7564);
  }
  
  public final void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(7541);
    ad.i(TAG, "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.noh;
    if (localMPVideoViewControlBar == null) {
      k.fvU();
    }
    localMPVideoViewControlBar.setShowMuteBtn(paramBoolean);
    AppMethodBeat.o(7541);
  }
  
  public final void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(7565);
    ad.i(TAG, "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.noh;
    if (localMPVideoViewControlBar == null) {
      k.fvU();
    }
    localMPVideoViewControlBar.setShowPlayBtn(paramBoolean);
    AppMethodBeat.o(7565);
  }
  
  public final void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(7563);
    ad.i(TAG, "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kno = paramBoolean;
    MPVideoViewControlBar localMPVideoViewControlBar = this.noh;
    if (localMPVideoViewControlBar == null) {
      k.fvU();
    }
    if ((paramBoolean) && (!aXf())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localMPVideoViewControlBar.setShowProgress(paramBoolean);
      AppMethodBeat.o(7563);
      return;
    }
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(7542);
    ad.i(TAG, "setTitle %s", new Object[] { paramString });
    MPVideoViewControlBar localMPVideoViewControlBar = this.noh;
    if (localMPVideoViewControlBar == null) {
      k.fvU();
    }
    localMPVideoViewControlBar.setTitle(paramString);
    AppMethodBeat.o(7542);
  }
  
  public final void setVideoHeight(int paramInt)
  {
    this.videoHeight = paramInt;
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(7548);
    ad.i(TAG, "setVideoSource =%d", new Object[] { Integer.valueOf(paramInt) });
    this.knr = paramInt;
    AppMethodBeat.o(7548);
  }
  
  public final void setVideoWidth(int paramInt)
  {
    this.videoWidth = paramInt;
  }
  
  public final void start()
  {
    AppMethodBeat.i(7551);
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder("start isPlaying=");
    MPExoVideoWrapper localMPExoVideoWrapper = this.nog;
    if (localMPExoVideoWrapper == null) {
      k.fvU();
    }
    ad.i((String)localObject, localMPExoVideoWrapper.isPlaying());
    localObject = this.nog;
    if (localObject == null) {
      k.fvU();
    }
    if (((MPExoVideoWrapper)localObject).isPlaying())
    {
      AppMethodBeat.o(7551);
      return;
    }
    this.nol = true;
    if (this.knc)
    {
      localObject = this.noh;
      if (localObject == null) {
        k.fvU();
      }
      ((MPVideoViewControlBar)localObject).bcF();
    }
    localObject = this.kmO;
    if (localObject == null) {
      k.fvU();
    }
    ((View)localObject).setVisibility(8);
    localObject = this.nog;
    if (localObject == null) {
      k.fvU();
    }
    ((MPExoVideoWrapper)localObject).start();
    bGF();
    AppMethodBeat.o(7551);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(7553);
    ad.i(TAG, "stop");
    Object localObject = this.nog;
    if (localObject == null) {
      k.fvU();
    }
    if (!((MPExoVideoWrapper)localObject).isPlaying())
    {
      AppMethodBeat.o(7553);
      return;
    }
    localObject = this.nog;
    if (localObject == null) {
      k.fvU();
    }
    ((MPExoVideoWrapper)localObject).Ft();
    localObject = this.noh;
    if (localObject == null) {
      k.fvU();
    }
    ((MPVideoViewControlBar)localObject).bcG();
    bGE();
    AppMethodBeat.o(7553);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "enterFullScreen", "", "direction", "", "quitFullScreen", "plugin-brandservice_release"})
  public static abstract interface b
  {
    public abstract void bah();
    
    public abstract boolean isFullScreen();
    
    public abstract void rM(int paramInt);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "", "onControlbarVisible", "", "visible", "", "onEndDragProgress", "onGetVideoSize", "width", "", "height", "onHideSwitchResolutionLayout", "onHideSwitchSpeedLayout", "onPlayError", "errorMsg", "", "errorCode", "onSeekPre", "onSeekTo", "time", "onStartDragProgress", "onUpdateProgress", "progressLen", "totalLen", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoPrepare", "firstRenderTime", "", "onVideoWaiting", "onVideoWaitingEnd", "resolutionBtnClick", "speedBtnClick", "switchResolution", "beforeType", "afterType", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "switchSpeed", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
  public static abstract interface c
  {
    public abstract void PZ(String paramString);
    
    public abstract void a(int paramInt1, int paramInt2, fn paramfn);
    
    public abstract void a(c.a parama1, c.a parama2);
    
    public abstract void bGe();
    
    public abstract void bGf();
    
    public abstract void bGg();
    
    public abstract void bGh();
    
    public abstract void bGi();
    
    public abstract void bGj();
    
    public abstract void bGk();
    
    public abstract void bcp();
    
    public abstract void bcv();
    
    public abstract void iC(boolean paramBoolean);
    
    public abstract void nI(long paramLong);
    
    public abstract void onVideoEnded();
    
    public abstract void onVideoPause();
    
    public abstract void onVideoPlay();
    
    public abstract void onVideoWaiting();
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$10", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$SwitchSpeedListener;", "onHideSwitchSpeedLayout", "", "speedBtnClick", "switchSpeed", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
  public static final class f
    implements MPVideoViewControlBar.b
  {
    public final void a(fn paramfn, c.a parama1, c.a parama2)
    {
      AppMethodBeat.i(193379);
      Object localObject = MPVideoView.k(this.noy);
      if (localObject != null) {
        ((MPVideoView.c)localObject).a(parama1, parama2);
      }
      this.noy.setAutoPlay(this.noy.isPlaying());
      int j = this.noy.getCurrPosMs();
      parama2 = MPVideoView.h(this.noy);
      if (parama2 == null) {
        k.fvU();
      }
      parama1 = parama2.nnq;
      if (parama1 != null)
      {
        parama1 = parama1.getBitmap();
        if ((parama1 == null) || (parama1.isRecycled())) {
          break label261;
        }
        localObject = parama2.nnm;
        if (localObject != null) {
          ((ImageView)localObject).setImageBitmap(parama1);
        }
      }
      for (;;)
      {
        parama1 = parama2.nnm;
        if (parama1 != null) {
          parama1.setVisibility(0);
        }
        parama2.nM(0L);
        parama1 = MPVideoView.h(this.noy);
        if (parama1 == null) {
          k.fvU();
        }
        parama1.bGG();
        parama1 = this.noy;
        int i = j;
        if (j == 0) {
          i = 1;
        }
        parama1.setInitialTime(i);
        parama1 = this.noy;
        if (paramfn == null) {
          k.fvU();
        }
        paramfn = paramfn.url;
        k.g(paramfn, "info!!.url");
        parama1.cv(paramfn, this.noy.getDuration());
        if (!MPVideoView.E(this.noy))
        {
          paramfn = MPVideoView.h(this.noy);
          if (paramfn == null) {
            k.fvU();
          }
          paramfn.pause();
        }
        paramfn = MPVideoView.c(this.noy);
        if (paramfn == null) {
          break label279;
        }
        paramfn.hide();
        AppMethodBeat.o(193379);
        return;
        parama1 = null;
        break;
        label261:
        parama1 = parama2.nnm;
        if (parama1 != null) {
          parama1.setImageResource(2131233299);
        }
      }
      label279:
      AppMethodBeat.o(193379);
    }
    
    public final void bGR()
    {
      AppMethodBeat.i(179030);
      MPVideoView.k(this.noy);
      AppMethodBeat.o(179030);
    }
    
    public final void bGS()
    {
      AppMethodBeat.i(179031);
      MPVideoView.k(this.noy);
      AppMethodBeat.o(179031);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$2", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-brandservice_release"})
  public static final class g
    implements e.d
  {
    public final void bcv()
    {
      AppMethodBeat.i(7488);
      ad.i(MPVideoView.access$getTAG$cp(), "onSeekPre");
      if (this.noy.isPlaying()) {
        this.noy.bGM();
      }
      MPVideoView.c localc = MPVideoView.k(this.noy);
      if (localc != null)
      {
        localc.bcv();
        AppMethodBeat.o(7488);
        return;
      }
      AppMethodBeat.o(7488);
    }
    
    public final void rZ(int paramInt)
    {
      AppMethodBeat.i(7489);
      MPVideoView.a(this.noy, paramInt * 1000);
      MPVideoView.m(this.noy);
      MPVideoView.c localc = MPVideoView.k(this.noy);
      if (localc != null)
      {
        localc.bGg();
        AppMethodBeat.o(7489);
        return;
      }
      AppMethodBeat.o(7489);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "progressLen", "", "totalLen", "onProgressChanged"})
  static final class m
    implements e.e
  {
    m(MPVideoView paramMPVideoView) {}
    
    public final void onProgressChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7496);
      if (paramInt2 <= 0)
      {
        AppMethodBeat.o(7496);
        return;
      }
      if (paramInt1 < 0) {
        paramInt1 = 0;
      }
      for (;;)
      {
        int i = paramInt1;
        if (paramInt1 > paramInt2) {
          i = paramInt2;
        }
        Object localObject = MPVideoView.C(this.noy);
        if (localObject == null) {
          k.fvU();
        }
        paramInt1 = i * ((ImageView)localObject).getWidth() / paramInt2;
        localObject = MPVideoView.D(this.noy);
        if (localObject == null) {
          k.fvU();
        }
        localObject = ((ImageView)localObject).getLayoutParams();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(7496);
          throw ((Throwable)localObject);
        }
        localObject = (FrameLayout.LayoutParams)localObject;
        ((FrameLayout.LayoutParams)localObject).width = paramInt1;
        ImageView localImageView = MPVideoView.D(this.noy);
        if (localImageView == null) {
          k.fvU();
        }
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = MPVideoView.D(this.noy);
        if (localObject == null) {
          k.fvU();
        }
        ((ImageView)localObject).requestLayout();
        localObject = MPVideoView.k(this.noy);
        if (localObject != null)
        {
          ((MPVideoView.c)localObject).bGi();
          AppMethodBeat.o(7496);
          return;
        }
        AppMethodBeat.o(7496);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$9", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$SwitchResolutionListener;", "onHideSwitchResolutionLayout", "", "resolutionBtnClick", "switchResolution", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "beforeType", "", "afterType", "plugin-brandservice_release"})
  public static final class n
    implements MPVideoViewControlBar.a
  {
    public final void a(fn paramfn, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7498);
      Object localObject = MPVideoView.k(this.noy);
      if (localObject != null) {
        ((MPVideoView.c)localObject).a(paramInt1, paramInt2, paramfn);
      }
      this.noy.setAutoPlay(this.noy.isPlaying());
      paramInt1 = this.noy.getCurrPosMs();
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.noy);
      if (localMPExoVideoWrapper == null) {
        k.fvU();
      }
      if (paramfn == null) {
        k.fvU();
      }
      String str = paramfn.CAn;
      ad.i(MPExoVideoWrapper.TAG, "onSetResolution %b", new Object[] { Boolean.valueOf(localMPExoVideoWrapper.nnF) });
      localMPExoVideoWrapper.nnE = true;
      localMPExoVideoWrapper.nnp = str;
      localObject = localMPExoVideoWrapper.nnq;
      if (localObject != null)
      {
        localObject = ((MPExoVideoTextureView)localObject).getBitmap();
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label348;
        }
        ImageView localImageView = localMPExoVideoWrapper.nnm;
        if (localImageView != null) {
          localImageView.setImageBitmap((Bitmap)localObject);
        }
        label169:
        localObject = localMPExoVideoWrapper.nnn;
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)localMPExoVideoWrapper.getContext().getString(2131761350, new Object[] { str }));
        }
        localMPExoVideoWrapper.bGC();
        localMPExoVideoWrapper.nM(0L);
        localObject = MPVideoView.h(this.noy);
        if (localObject == null) {
          k.fvU();
        }
        ((MPExoVideoWrapper)localObject).bGG();
        localObject = this.noy;
        if (paramInt1 != 0) {
          break label370;
        }
        paramInt1 = 1;
      }
      label348:
      label370:
      for (;;)
      {
        ((MPVideoView)localObject).setInitialTime(paramInt1);
        localObject = this.noy;
        paramfn = paramfn.url;
        k.g(paramfn, "info!!.url");
        ((MPVideoView)localObject).cv(paramfn, this.noy.getDuration());
        if (!MPVideoView.E(this.noy))
        {
          paramfn = MPVideoView.h(this.noy);
          if (paramfn == null) {
            k.fvU();
          }
          paramfn.pause();
        }
        paramfn = MPVideoView.c(this.noy);
        if (paramfn == null) {
          break label373;
        }
        paramfn.hide();
        AppMethodBeat.o(7498);
        return;
        localObject = null;
        break;
        localObject = localMPExoVideoWrapper.nnm;
        if (localObject == null) {
          break label169;
        }
        ((ImageView)localObject).setImageResource(2131233299);
        break label169;
      }
      label373:
      AppMethodBeat.o(7498);
    }
    
    public final void bGj()
    {
      AppMethodBeat.i(7499);
      MPVideoView.c localc = MPVideoView.k(this.noy);
      if (localc != null)
      {
        localc.bGj();
        AppMethodBeat.o(7499);
        return;
      }
      AppMethodBeat.o(7499);
    }
    
    public final void bGk()
    {
      AppMethodBeat.i(7497);
      MPVideoView.c localc = MPVideoView.k(this.noy);
      if (localc != null)
      {
        localc.bGk();
        AppMethodBeat.o(7497);
        return;
      }
      AppMethodBeat.o(7497);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initGestureController$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$GestureOperationHelper;", "canAdjustBrightness", "", "canAdjustProgress", "canAdjustVolume", "getCurrentPosition", "", "onAdjustBrightness", "", "brightness", "", "onAdjustVolume", "volumePercent", "onCanHandleGesture", "onDoubleTap", "onDragProgress", "startDragPos", "distanceX", "onEndAdjustBrightness", "onEndAdjustVolume", "onEndDragProgress", "dragPosition", "totalDistanceX", "onSingleTap", "onStartDragProgress", "plugin-brandservice_release"})
  public static final class o
    implements a.b
  {
    public final void av(float paramFloat)
    {
      AppMethodBeat.i(7506);
      if (!MPVideoView.r(this.noy))
      {
        AppMethodBeat.o(7506);
        return;
      }
      ad.d(MPVideoView.access$getTAG$cp(), "onAdjustVolume:".concat(String.valueOf(paramFloat)));
      Object localObject = MPVideoView.n(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      ((AppBrandDotPercentIndicator)localObject).setPercent(paramFloat);
      localObject = MPVideoView.o(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      ((TextView)localObject).setText(2131760999);
      localObject = MPVideoView.p(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      ((ImageView)localObject).setImageResource(2131231041);
      localObject = MPVideoView.q(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      ((LinearLayout)localObject).setVisibility(0);
      MPVideoView.f(this.noy);
      AppMethodBeat.o(7506);
    }
    
    public final void aw(float paramFloat)
    {
      AppMethodBeat.i(7507);
      if (!MPVideoView.r(this.noy))
      {
        AppMethodBeat.o(7507);
        return;
      }
      ad.d(MPVideoView.access$getTAG$cp(), "onAdjustBrightness:".concat(String.valueOf(paramFloat)));
      Object localObject = MPVideoView.n(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      ((AppBrandDotPercentIndicator)localObject).setPercent(paramFloat);
      localObject = MPVideoView.o(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      ((TextView)localObject).setText(2131760998);
      localObject = MPVideoView.p(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      ((ImageView)localObject).setImageResource(2131231033);
      localObject = MPVideoView.q(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      ((LinearLayout)localObject).setVisibility(0);
      MPVideoView.f(this.noy);
      AppMethodBeat.o(7507);
    }
    
    public final void bcn()
    {
      AppMethodBeat.i(7500);
      ad.d(MPVideoView.access$getTAG$cp(), "onSingleTap");
      if ((MPVideoView.a(this.noy)) && (!MPVideoView.b(this.noy)))
      {
        localObject = MPVideoView.c(this.noy);
        if (localObject == null) {
          k.fvU();
        }
        ((MPVideoViewControlBar)localObject).bcz();
      }
      Object localObject = MPVideoView.d(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      if ((((View)localObject).getVisibility() != 0) && (MPVideoView.e(this.noy))) {
        MPVideoView.f(this.noy);
      }
      AppMethodBeat.o(7500);
    }
    
    public final void bco()
    {
      AppMethodBeat.i(7501);
      ad.d(MPVideoView.access$getTAG$cp(), "onDoubleTap");
      if (MPVideoView.g(this.noy))
      {
        Object localObject = MPVideoView.h(this.noy);
        if (localObject == null) {
          k.fvU();
        }
        if (((MPExoVideoWrapper)localObject).isPlaying())
        {
          this.noy.pause();
          localObject = m.nmf;
          m.a.yC(35);
          AppMethodBeat.o(7501);
          return;
        }
        this.noy.start();
        localObject = m.nmf;
        m.a.yC(36);
      }
      AppMethodBeat.o(7501);
    }
    
    public final void bcp()
    {
      AppMethodBeat.i(7502);
      if (!MPVideoView.i(this.noy))
      {
        AppMethodBeat.o(7502);
        return;
      }
      Object localObject = MPVideoView.j(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      ((TextView)localObject).setVisibility(0);
      MPVideoView.f(this.noy);
      if (this.noy.isPlaying()) {
        this.noy.bGM();
      }
      localObject = MPVideoView.k(this.noy);
      if (localObject != null)
      {
        ((MPVideoView.c)localObject).bcp();
        AppMethodBeat.o(7502);
        return;
      }
      AppMethodBeat.o(7502);
    }
    
    public final void bcq()
    {
      AppMethodBeat.i(7508);
      if (!MPVideoView.r(this.noy))
      {
        AppMethodBeat.o(7508);
        return;
      }
      Object localObject = MPVideoView.q(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      ((LinearLayout)localObject).setVisibility(8);
      MPVideoView.l(this.noy);
      localObject = m.nmf;
      m.a.yC(41);
      AppMethodBeat.o(7508);
    }
    
    public final void bcr()
    {
      AppMethodBeat.i(7509);
      if (!MPVideoView.r(this.noy))
      {
        AppMethodBeat.o(7509);
        return;
      }
      Object localObject = MPVideoView.q(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      ((LinearLayout)localObject).setVisibility(8);
      MPVideoView.l(this.noy);
      localObject = m.nmf;
      m.a.yC(39);
      AppMethodBeat.o(7509);
    }
    
    public final boolean bcs()
    {
      AppMethodBeat.i(205026);
      boolean bool = MPVideoView.r(this.noy);
      AppMethodBeat.o(205026);
      return bool;
    }
    
    public final boolean bct()
    {
      AppMethodBeat.i(205027);
      boolean bool = MPVideoView.r(this.noy);
      AppMethodBeat.o(205027);
      return bool;
    }
    
    public final boolean bcu()
    {
      AppMethodBeat.i(7512);
      boolean bool = MPVideoView.i(this.noy);
      AppMethodBeat.o(7512);
      return bool;
    }
    
    public final int getCurrentPosition()
    {
      AppMethodBeat.i(7505);
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.noy);
      if (localMPExoVideoWrapper == null) {
        k.fvU();
      }
      int i = localMPExoVideoWrapper.getCurrPosSec();
      AppMethodBeat.o(7505);
      return i;
    }
    
    public final int j(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(7503);
      if (!MPVideoView.i(this.noy))
      {
        AppMethodBeat.o(7503);
        return 0;
      }
      ad.i(MPVideoView.access$getTAG$cp(), "onDragProgress:" + paramInt + '/' + paramFloat);
      Object localObject = MPVideoView.h(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      paramInt = ((MPExoVideoWrapper)localObject).getVideoDurationSec();
      int i = com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a.c(paramFloat, this.noy.getMeasuredWidth(), getCurrentPosition(), paramInt);
      localObject = com.tencent.mm.plugin.appbrand.jsapi.video.l.mz(paramInt * 1000L);
      TextView localTextView = MPVideoView.j(this.noy);
      if (localTextView == null) {
        k.fvU();
      }
      localTextView.setText((CharSequence)(com.tencent.mm.plugin.appbrand.jsapi.video.l.mz(i * 1000L) + "/" + (String)localObject));
      localObject = MPVideoView.c(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      ((MPVideoViewControlBar)localObject).seek(i);
      localObject = MPVideoView.c(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      if (((MPVideoViewControlBar)localObject).bcB())
      {
        localObject = MPVideoView.c(this.noy);
        if (localObject == null) {
          k.fvU();
        }
        ((MPVideoViewControlBar)localObject).bcH();
      }
      AppMethodBeat.o(7503);
      return i;
    }
    
    public final void k(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(7504);
      if (!MPVideoView.i(this.noy))
      {
        AppMethodBeat.o(7504);
        return;
      }
      Object localObject = MPVideoView.j(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      ((TextView)localObject).setVisibility(8);
      MPVideoView.l(this.noy);
      localObject = MPVideoView.h(this.noy);
      if (localObject == null) {
        k.fvU();
      }
      int i = ((MPExoVideoWrapper)localObject).getCurrPosSec();
      ad.i(MPVideoView.access$getTAG$cp(), "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Float.valueOf(paramFloat) });
      MPVideoView.a(this.noy, paramInt * 1000);
      MPVideoView.m(this.noy);
      localObject = MPVideoView.k(this.noy);
      if (localObject != null)
      {
        ((MPVideoView.c)localObject).bGf();
        AppMethodBeat.o(7504);
        return;
      }
      AppMethodBeat.o(7504);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initVideoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-brandservice_release"})
  public static final class p
    implements h.b
  {
    public final void c(String paramString1, String paramString2, final String paramString3, final int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7521);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      k.h(paramString3, "errorMsg");
      ad.i(MPVideoView.access$getTAG$cp(), "onError errorMsg=%s what=%d extra=%d", new Object[] { paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      aq.f((Runnable)new a(this, paramString3, paramInt1));
      AppMethodBeat.o(7521);
    }
    
    public final void d(String paramString1, String paramString2, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(7524);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      this.noy.setVideoWidth(paramInt1);
      this.noy.setVideoHeight(paramInt2);
      paramString1 = MPVideoView.k(this.noy);
      if (paramString1 != null) {
        paramString1.bGe();
      }
      aq.f((Runnable)new b(this, paramInt1, paramInt2));
      AppMethodBeat.o(7524);
    }
    
    public final void db(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7522);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      ad.i(MPVideoView.access$getTAG$cp(), "onPrepared");
      aq.f((Runnable)new c(this));
      AppMethodBeat.o(7522);
    }
    
    public final void dc(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7523);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      ad.i(MPVideoView.access$getTAG$cp(), "onVideoEnded");
      aq.f((Runnable)new d(this));
      AppMethodBeat.o(7523);
    }
    
    public final void dd(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7525);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      ad.i(MPVideoView.access$getTAG$cp(), "onVideoPause");
      this.noy.bGM();
      paramString1 = MPVideoView.k(this.noy);
      if (paramString1 != null) {
        paramString1.onVideoPause();
      }
      if (this.noy.getPlayStatus() != 4) {
        this.noy.setPlayStatus(3);
      }
      paramString1 = MPVideoView.h(this.noy);
      if (paramString1 == null) {
        k.fvU();
      }
      paramString1 = paramString1.nnn;
      if (paramString1 == null) {
        k.fvU();
      }
      if (paramString1.getVisibility() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        aq.n((Runnable)new e(this), 1000L);
        AppMethodBeat.o(7525);
        return;
      }
      this.noy.bGO();
      AppMethodBeat.o(7525);
    }
    
    public final void de(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7526);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      aq.f((Runnable)new f(this));
      AppMethodBeat.o(7526);
    }
    
    public final void dg(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7527);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      ad.i(MPVideoView.access$getTAG$cp(), "onVideoWaiting");
      aq.f((Runnable)new g(this));
      AppMethodBeat.o(7527);
    }
    
    public final void dh(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7528);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      aq.f((Runnable)new h(this));
      AppMethodBeat.o(7528);
    }
    
    public final void jw(String paramString1, String paramString2)
    {
      AppMethodBeat.i(205028);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      AppMethodBeat.o(205028);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoView.p paramp, String paramString, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(7513);
        this.noz.noy.bGM();
        MPVideoView.c localc = MPVideoView.k(this.noz.noy);
        if (localc != null) {
          localc.PZ(paramString3);
        }
        this.noz.noy.setPlayStatus(4);
        AppMethodBeat.o(7513);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(MPVideoView.p paramp, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(7514);
        int i = MPVideoView.y(this.noz.noy);
        Object localObject = MPVideoView.nox;
        if (i == MPVideoView.bGQ())
        {
          localObject = this.noz.noy;
          if (paramInt1 >= paramInt2) {
            break label89;
          }
        }
        label89:
        for (i = 0;; i = 90)
        {
          MPVideoView.b((MPVideoView)localObject, i);
          ad.i(MPVideoView.access$getTAG$cp(), "onGetVideoSize adjust direction from AUTO to %s", new Object[] { Integer.valueOf(MPVideoView.y(this.noz.noy)) });
          AppMethodBeat.o(7514);
          return;
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7515);
        Object localObject = MPVideoView.k(this.noz.noy);
        MPExoVideoWrapper localMPExoVideoWrapper;
        if (localObject != null)
        {
          localMPExoVideoWrapper = MPVideoView.h(this.noz.noy);
          if (localMPExoVideoWrapper == null) {
            break label80;
          }
        }
        label80:
        for (long l = localMPExoVideoWrapper.getFirstRenderTime();; l = 0L)
        {
          ((MPVideoView.c)localObject).nI(l);
          localObject = MPVideoView.s(this.noz.noy);
          if (localObject == null) {
            k.fvU();
          }
          ((com.tencent.mm.plugin.appbrand.jsapi.video.ui.a)localObject).bee();
          AppMethodBeat.o(7515);
          return;
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class d
      implements Runnable
    {
      d(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7516);
        this.noz.noy.bGM();
        Object localObject = MPVideoView.j(this.noz.noy);
        if (localObject == null) {
          k.fvU();
        }
        ((TextView)localObject).setVisibility(8);
        if (MPVideoView.b(this.noz.noy))
        {
          localObject = MPVideoView.d(this.noz.noy);
          if (localObject == null) {
            k.fvU();
          }
          ((View)localObject).setVisibility(0);
          localObject = MPVideoView.c(this.noz.noy);
          if (localObject == null) {
            k.fvU();
          }
          if (((MPVideoViewControlBar)localObject).bcB())
          {
            localObject = MPVideoView.c(this.noz.noy);
            if (localObject == null) {
              k.fvU();
            }
            ((MPVideoViewControlBar)localObject).hide();
          }
          localObject = MPVideoView.t(this.noz.noy);
          if (localObject == null) {
            k.fvU();
          }
          if (((FrameLayout)localObject).getVisibility() == 0)
          {
            localObject = MPVideoView.t(this.noz.noy);
            if (localObject == null) {
              k.fvU();
            }
            ((FrameLayout)localObject).setVisibility(8);
          }
          if ((!MPVideoView.u(this.noz.noy)) && (MPVideoView.b(this.noz.noy))) {
            break label318;
          }
          localObject = MPVideoView.v(this.noz.noy);
          if (localObject == null) {
            k.fvU();
          }
          ((View)localObject).setVisibility(8);
        }
        for (;;)
        {
          this.noz.noy.bGE();
          this.noz.noy.setPlayStatus(4);
          localObject = MPVideoView.k(this.noz.noy);
          if (localObject == null) {
            break label407;
          }
          ((MPVideoView.c)localObject).onVideoEnded();
          AppMethodBeat.o(7516);
          return;
          localObject = MPVideoView.c(this.noz.noy);
          if (localObject == null) {
            k.fvU();
          }
          ((MPVideoViewControlBar)localObject).bGT();
          localObject = MPVideoView.c(this.noz.noy);
          if (localObject == null) {
            k.fvU();
          }
          ((MPVideoViewControlBar)localObject).show();
          break;
          label318:
          if (MPVideoView.w(this.noz.noy) <= 0)
          {
            localObject = MPVideoView.x(this.noz.noy);
            if (localObject == null) {
              k.fvU();
            }
            MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.noz.noy);
            if (localMPExoVideoWrapper == null) {
              k.fvU();
            }
            ((TextView)localObject).setText((CharSequence)MPVideoView.yJ(localMPExoVideoWrapper.getVideoDurationSec()));
          }
          localObject = MPVideoView.v(this.noz.noy);
          if (localObject == null) {
            k.fvU();
          }
          ((View)localObject).setVisibility(0);
        }
        label407:
        AppMethodBeat.o(7516);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class e
      implements Runnable
    {
      e(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7517);
        this.noz.noy.bGO();
        AppMethodBeat.o(7517);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class f
      implements Runnable
    {
      f(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7518);
        ad.i(MPVideoView.access$getTAG$cp(), "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(MPVideoView.u(this.noz.noy)) });
        MPVideoView.z(this.noz.noy);
        this.noz.noy.bGF();
        Object localObject = MPVideoView.k(this.noz.noy);
        if (localObject != null) {
          ((MPVideoView.c)localObject).onVideoPlay();
        }
        if ((MPVideoView.w(this.noz.noy) <= 0) && (!MPVideoView.u(this.noz.noy)))
        {
          localObject = MPVideoView.x(this.noz.noy);
          if (localObject == null) {
            k.fvU();
          }
          MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.noz.noy);
          if (localMPExoVideoWrapper == null) {
            k.fvU();
          }
          ((TextView)localObject).setText((CharSequence)MPVideoView.yJ(localMPExoVideoWrapper.getVideoDurationSec()));
        }
        MPVideoView.b(this.noz.noy, MPVideoView.u(this.noz.noy));
        if (MPVideoView.a(this.noz.noy)) {
          MPVideoView.A(this.noz.noy);
        }
        MPVideoView.m(this.noz.noy);
        this.noz.noy.setPlayStatus(2);
        localObject = MPVideoView.c(this.noz.noy);
        if (localObject == null) {
          k.fvU();
        }
        if (((MPVideoViewControlBar)localObject).bcB())
        {
          localObject = MPVideoView.c(this.noz.noy);
          if (localObject == null) {
            k.fvU();
          }
          ((MPVideoViewControlBar)localObject).bcH();
        }
        AppMethodBeat.o(7518);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class g
      implements Runnable
    {
      g(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7519);
        MPVideoView.a(this.noz.noy, true);
        MPVideoView.f(this.noz.noy);
        MPVideoView.c localc = MPVideoView.k(this.noz.noy);
        if (localc != null)
        {
          localc.onVideoWaiting();
          AppMethodBeat.o(7519);
          return;
        }
        AppMethodBeat.o(7519);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class h
      implements Runnable
    {
      h(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7520);
        MPVideoView.a(this.noz.noy, false);
        MPVideoView.l(this.noz.noy);
        MPVideoView.c localc = MPVideoView.k(this.noz.noy);
        if (localc != null)
        {
          localc.bGh();
          AppMethodBeat.o(7520);
          return;
        }
        AppMethodBeat.o(7520);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView
 * JD-Core Version:    0.7.0.1
 */