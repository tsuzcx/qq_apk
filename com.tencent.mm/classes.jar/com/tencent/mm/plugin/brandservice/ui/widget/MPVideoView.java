package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroudContainerLayout", "Landroid/widget/FrameLayout;", "getBackgroudContainerLayout", "()Landroid/widget/FrameLayout;", "setBackgroudContainerLayout", "(Landroid/widget/FrameLayout;)V", "cacheTimeSec", "getCacheTimeSec", "()I", "currPosMs", "getCurrPosMs", "currPosSec", "getCurrPosSec", "dotContainerLayout", "getDotContainerLayout", "setDotContainerLayout", "duration", "getDuration", "setDuration", "(I)V", "endPlayTime", "getEndPlayTime", "hasDownInTouchEvent", "", "hasRealPlayTime", "isCoverVisible", "()Z", "isInFullScreen", "isLive", "mAdjustContentTv", "Landroid/widget/TextView;", "mAdjustIconIv", "Landroid/widget/ImageView;", "mAdjustInfoLayout", "Landroid/widget/LinearLayout;", "mAdjustPercentIndicator", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/AppBrandDotPercentIndicator;", "mAutoPlay", "mBottomProgressBackBar", "mBottomProgressFrontBar", "mBottomProgressLayout", "mConsumeTouchEvent", "mControlBar", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar;", "mCoverArea", "Landroid/view/View;", "mCoverPlayBtnArea", "mCoverTotalTimeTv", "mCoverUrl", "", "mDirection", "mDuration", "mEnablePlayGesture", "mEnableProgressGesture", "mFullScreenDelegate", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "mGestureController", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController;", "mInitialTime", "mIsAlive", "mIsLoading", "mIsMute", "mIsShowBasicControls", "mLoop", "mMPVideoViewCallBack", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "mPageGesture", "mPageGestureInFullscreen", "mPlayStart", "mPlayStarted", "mProgressTv", "mRealPlayTime", "", "mSetIsShowCoverPlayBtn", "mSetIsShowProgressBar", "mSkipAutoPause", "mStartPlayTime", "mVideoSource", "mVideoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper;", "needHandleTouchEvent", "getNeedHandleTouchEvent", "setNeedHandleTouchEvent", "(Z)V", "playStatus", "getPlayStatus", "setPlayStatus", "playerAdContainerLayout", "getPlayerAdContainerLayout", "setPlayerAdContainerLayout", "realPlayTime", "getRealPlayTime", "()J", "videoHeight", "getVideoHeight", "setVideoHeight", "<set-?>", "videoPath", "getVideoPath", "()Ljava/lang/String;", "videoWidth", "getVideoWidth", "setVideoWidth", "canAdjustBrightnessVolume", "canDragProgress", "clean", "", "doOnTouchEvent", "event", "Landroid/view/MotionEvent;", "downloadVideo", "videoUrl", "enableProgressGesture", "enable", "getAutoPlay", "getPlayStart", "getPlayStarted", "getTimeShowString", "time", "hideCenterPlayBtnIfNeed", "hideCover", "init", "initControlBar", "initGestureController", "initParam", "initVideoViewCallback", "isControlBarShow", "isPlaying", "makeTimeString", "d", "onExitFullScreen", "onTouchEvent", "onUIDestroy", "onUIPause", "onUIResume", "operateFullScreen", "toFullScreen", "direction", "pause", "seekTo", "position", "afterPlay", "setAutoPlay", "autoPlay", "setBizInfo", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "iconUrl", "setConsumeTouchEvent", "value", "setCoverByUrl", "cover", "coverUrl", "width", "height", "setEnablePlayGesture", "enablePlayGesture", "setExoPlayerParam", "maxInitialBitrate", "bandwidthFraction", "", "minDurForQualityMs", "maxDurForQualityMs", "minBufferMs", "maxBufferMs", "setFullScreenDelegate", "delegate", "setFullScreenDirection", "setInitialTime", "initialTime", "setIsShowBasicControls", "isShowBasicControls", "setLoop", "loop", "setMPVideoViewCallBack", "setMute", "isMute", "setObjectFit", "setPageGesture", "pageGesture", "setPageGestureInFullscreen", "pageGestureInFullscreen", "setPlayBtnOnClickListener", "click", "Landroid/view/View$OnClickListener;", "setPlayBtnPosition", "playBtnPosition", "setPreLoadVidePath", "setShowCenterPlayBtn", "showCenterPlayBtn", "setShowControlProgress", "showControlProgress", "setShowFullScreenBtn", "showFullScreenBtn", "setShowMuteBtn", "showMuteBtn", "setShowPlayBtn", "showPlayBtn", "setShowProgress", "showProgress", "setTitle", "title", "setVideoPath", "durationSec", "setVideoSource", "videoSource", "setVideoUrlInfo", "urlInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "currentInfo", "shouldDispatchEventToGestureController", "shouldHandleTouchEvent", "v", "e", "showCenterPlayBtnIfNeed", "showControlBar", "showCover", "start", "startWhenNetWorkConnect", "stop", "updateBottomProgressLayout", "updateControlBarDotPos", "list", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "updateLiveUI", "updateRealPlayTime", "updateStartTime", "Companion", "FullScreenDelegate", "MPVideoViewCallBack", "plugin-brandservice_release"})
public final class MPVideoView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.MPVideoView";
  private static final int sVk = -1;
  private static final int sVl = 8;
  public static final MPVideoView.a sVm;
  private int alM;
  private boolean cFF;
  private boolean mIsMute;
  private boolean mLoop;
  private int mfx;
  private boolean puB;
  private boolean puD;
  private boolean puE;
  private com.tencent.mm.plugin.appbrand.jsapi.video.ui.a puF;
  private boolean puH;
  private boolean puK;
  private boolean puL;
  private boolean puM;
  private boolean puO;
  private int puP;
  private boolean puR;
  private boolean puS;
  private int puh;
  private TextView puk;
  private View pun;
  private View puo;
  private TextView pup;
  private LinearLayout puq;
  private AppBrandDotPercentIndicator pur;
  private TextView pus;
  private ImageView put;
  private ImageView puv;
  private ImageView puw;
  private FrameLayout pux;
  private MPExoVideoWrapper sUW;
  private MPVideoViewControlBar sUX;
  private FrameLayout sUY;
  private FrameLayout sUZ;
  private FrameLayout sVa;
  private boolean sVb;
  private boolean sVc;
  private MPVideoView.b sVd;
  private MPVideoView.c sVe;
  private int sVf;
  private long sVg;
  private long sVh;
  private boolean sVi;
  private boolean sVj;
  private int videoHeight;
  private String videoPath;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(7587);
    sVm = new MPVideoView.a((byte)0);
    TAG = "MicroMsg.MPVideoView";
    sVk = -1;
    sVl = 8;
    AppMethodBeat.o(7587);
  }
  
  public MPVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7585);
    this.puh = sVk;
    init(paramContext);
    AppMethodBeat.o(7585);
  }
  
  public MPVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(7586);
    this.puh = sVk;
    init(paramContext);
    AppMethodBeat.o(7586);
  }
  
  private static String AP(int paramInt)
  {
    AppMethodBeat.i(7580);
    String str = AQ(paramInt / 60) + ":" + AQ(paramInt % 60);
    AppMethodBeat.o(7580);
    return str;
  }
  
  private static String AQ(int paramInt)
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
  
  private final void bUI()
  {
    AppMethodBeat.i(7574);
    MPVideoViewControlBar localMPVideoViewControlBar = this.sUX;
    if (localMPVideoViewControlBar == null) {
      p.iCn();
    }
    localMPVideoViewControlBar.bUI();
    AppMethodBeat.o(7574);
  }
  
  private final boolean bUM()
  {
    AppMethodBeat.i(7582);
    if (this.puL)
    {
      MPExoVideoWrapper localMPExoVideoWrapper = this.sUW;
      if (localMPExoVideoWrapper == null) {
        p.iCn();
      }
      if ((!localMPExoVideoWrapper.bjq) && (!bUO()))
      {
        AppMethodBeat.o(7582);
        return true;
      }
    }
    AppMethodBeat.o(7582);
    return false;
  }
  
  private final boolean bUN()
  {
    AppMethodBeat.i(7583);
    if ((!bUO()) && (((!bUK()) && (this.puD)) || ((bUK()) && (this.puE))))
    {
      AppMethodBeat.o(7583);
      return true;
    }
    AppMethodBeat.o(7583);
    return false;
  }
  
  private final boolean bUO()
  {
    AppMethodBeat.i(7538);
    View localView = this.pun;
    if (localView == null) {
      p.iCn();
    }
    if (localView.getVisibility() == 0)
    {
      AppMethodBeat.o(7538);
      return true;
    }
    AppMethodBeat.o(7538);
    return false;
  }
  
  private final void init(Context paramContext)
  {
    AppMethodBeat.i(7539);
    LayoutInflater.from(paramContext).inflate(com.tencent.mm.plugin.brandservice.d.f.sut, (ViewGroup)this);
    this.sUW = ((MPExoVideoWrapper)findViewById(com.tencent.mm.plugin.brandservice.d.e.video_view));
    paramContext = findViewById(com.tencent.mm.plugin.brandservice.d.e.progress);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.puk = ((TextView)paramContext);
    this.pun = findViewById(com.tencent.mm.plugin.brandservice.d.e.cover_area);
    this.puo = findViewById(com.tencent.mm.plugin.brandservice.d.e.cover_play_btn_area);
    paramContext = findViewById(com.tencent.mm.plugin.brandservice.d.e.cover_total_time);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.pup = ((TextView)paramContext);
    paramContext = findViewById(com.tencent.mm.plugin.brandservice.d.e.adjust_info_layout);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.puq = ((LinearLayout)paramContext);
    paramContext = findViewById(com.tencent.mm.plugin.brandservice.d.e.adjust_percent_indicator);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.pur = ((AppBrandDotPercentIndicator)paramContext);
    paramContext = findViewById(com.tencent.mm.plugin.brandservice.d.e.adjust_content);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.pus = ((TextView)paramContext);
    paramContext = findViewById(com.tencent.mm.plugin.brandservice.d.e.adjust_icon);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.put = ((ImageView)paramContext);
    paramContext = findViewById(com.tencent.mm.plugin.brandservice.d.e.player_bottom_progress_bar_front);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.puv = ((ImageView)paramContext);
    paramContext = findViewById(com.tencent.mm.plugin.brandservice.d.e.player_bottom_progress_bar_background);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.puw = ((ImageView)paramContext);
    paramContext = findViewById(com.tencent.mm.plugin.brandservice.d.e.player_bottom_progress_root);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.pux = ((FrameLayout)paramContext);
    paramContext = findViewById(com.tencent.mm.plugin.brandservice.d.e.sst);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.sUY = ((FrameLayout)paramContext);
    paramContext = findViewById(com.tencent.mm.plugin.brandservice.d.e.ssw);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.sUZ = ((FrameLayout)paramContext);
    paramContext = findViewById(com.tencent.mm.plugin.brandservice.d.e.ssu);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.sVa = ((FrameLayout)paramContext);
    paramContext = this.pur;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setDotsNum(sVl);
    paramContext = findViewById(com.tencent.mm.plugin.brandservice.d.e.cover_play_btn);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    ((ImageView)paramContext).setOnClickListener((View.OnClickListener)new d(this));
    this.puF = new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a(getContext(), (View)this, (a.b)new MPVideoView.o(this));
    paramContext = this.sUW;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setIMMVideoViewCallback((i.b)new MPVideoView.p(this));
    this.sUX = new MPVideoViewControlBar(getContext());
    paramContext = this.sUW;
    if (paramContext == null) {
      p.iCn();
    }
    MPVideoViewControlBar localMPVideoViewControlBar = this.sUX;
    if (localMPVideoViewControlBar == null) {
      p.iCn();
    }
    paramContext.setVideoFooterView((com.tencent.mm.pluginsdk.ui.h)localMPVideoViewControlBar);
    paramContext = this.sUX;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.hide();
    paramContext = this.sUX;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setFullScreenBtnOnClickListener((View.OnClickListener)new e(this));
    paramContext = this.sUX;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setIplaySeekCallback((d.d)new MPVideoView.g(this));
    paramContext = this.sUX;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setOnPlayButtonClickListener((View.OnClickListener)new MPVideoView.h(this));
    paramContext = this.sUX;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setStatePorter((d.i)new MPVideoView.i(this));
    paramContext = this.sUX;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setMuteBtnOnClickListener((View.OnClickListener)new j(this));
    paramContext = this.sUX;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setExitFullScreenBtnOnClickListener((View.OnClickListener)new k(this));
    paramContext = this.sUX;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.a((com.tencent.mm.plugin.appbrand.jsapi.video.d.f)new MPVideoView.l(this));
    paramContext = this.sUX;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setOnUpdateProgressLenListener((com.tencent.mm.plugin.appbrand.jsapi.video.d.e)new MPVideoView.m(this));
    paramContext = this.sUX;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setSwitchResolutionListener((MPVideoViewControlBar.a)new MPVideoView.n(this));
    paramContext = this.sUX;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setSwitchSpeedListener((MPVideoViewControlBar.b)new MPVideoView.f(this));
    paramContext = this.sUW;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext = paramContext.getCoverIv();
    if (paramContext == null) {
      p.iCn();
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
    Log.i(TAG, "enableProgressGesture %b", new Object[] { Boolean.TRUE });
    this.puL = true;
    setVideoSource(0);
    setConsumeTouchEvent(false);
    setIsShowBasicControls(true);
    AppMethodBeat.o(7539);
  }
  
  private final boolean isLive()
  {
    AppMethodBeat.i(7537);
    Object localObject = TAG;
    boolean bool = this.puH;
    MPExoVideoWrapper localMPExoVideoWrapper = this.sUW;
    if (localMPExoVideoWrapper == null) {
      p.iCn();
    }
    Log.i((String)localObject, "isLive %b %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localMPExoVideoWrapper.bjq) });
    if (!this.puH)
    {
      localObject = this.sUW;
      if (localObject == null) {
        p.iCn();
      }
      if (!((MPExoVideoWrapper)localObject).bjq) {}
    }
    else
    {
      AppMethodBeat.o(7537);
      return true;
    }
    AppMethodBeat.o(7537);
    return false;
  }
  
  public final boolean bUK()
  {
    AppMethodBeat.i(7536);
    if (this.sVd == null)
    {
      Log.w(TAG, "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(7536);
      return false;
    }
    MPVideoView.b localb = this.sVd;
    if (localb == null) {
      p.iCn();
    }
    boolean bool = localb.QT();
    AppMethodBeat.o(7536);
    return bool;
  }
  
  public final void cEA()
  {
    AppMethodBeat.i(7561);
    MPExoVideoWrapper localMPExoVideoWrapper = this.sUW;
    if (localMPExoVideoWrapper == null) {
      p.iCn();
    }
    localMPExoVideoWrapper.cEA();
    AppMethodBeat.o(7561);
  }
  
  public final void cEB()
  {
    AppMethodBeat.i(7562);
    MPExoVideoWrapper localMPExoVideoWrapper = this.sUW;
    if (localMPExoVideoWrapper == null) {
      p.iCn();
    }
    localMPExoVideoWrapper.cEB();
    AppMethodBeat.o(7562);
  }
  
  public final void cEH()
  {
    long l1 = 0L;
    AppMethodBeat.i(258090);
    long l2 = System.currentTimeMillis();
    long l3 = this.sVg;
    if (this.sVh != 0L) {
      l1 = l2 - this.sVh;
    }
    this.sVg = (l1 + l3);
    this.sVh = l2;
    this.sVi = true;
    AppMethodBeat.o(258090);
  }
  
  public final void cEI()
  {
    AppMethodBeat.i(7578);
    MPVideoViewControlBar localMPVideoViewControlBar = this.sUX;
    if (localMPVideoViewControlBar != null) {
      localMPVideoViewControlBar.cEO();
    }
    localMPVideoViewControlBar = this.sUX;
    if (localMPVideoViewControlBar != null)
    {
      localMPVideoViewControlBar.show();
      AppMethodBeat.o(7578);
      return;
    }
    AppMethodBeat.o(7578);
  }
  
  public final void dh(String paramString, int paramInt)
  {
    AppMethodBeat.i(7556);
    p.k(paramString, "videoPath");
    Log.i(TAG, "setVideoPath path=%s isLive=%s", new Object[] { paramString, Boolean.FALSE });
    if (Util.isNullOrNil(paramString))
    {
      Log.v(TAG, "setVideoPath videoPath empty");
      AppMethodBeat.o(7556);
      return;
    }
    this.videoPath = paramString;
    Log.i(TAG, "stop");
    Object localObject = this.sUW;
    if (localObject == null) {
      p.iCn();
    }
    if (((MPExoVideoWrapper)localObject).isPlaying())
    {
      localObject = this.sUW;
      if (localObject == null) {
        p.iCn();
      }
      ((MPExoVideoWrapper)localObject).TV();
      localObject = this.sUX;
      if (localObject == null) {
        p.iCn();
      }
      ((MPVideoViewControlBar)localObject).bVh();
      cEA();
    }
    this.puH = false;
    localObject = this.sUW;
    if (localObject == null) {
      p.iCn();
    }
    ((MPExoVideoWrapper)localObject).setVideoSource(this.puP);
    localObject = this.sUW;
    if (localObject == null) {
      p.iCn();
    }
    p.k(paramString, "_url");
    ((MPExoVideoWrapper)localObject).cJT = paramString;
    ((MPExoVideoWrapper)localObject).pvi = paramInt;
    ((MPExoVideoWrapper)localObject).bjq = false;
    Log.i(MPExoVideoWrapper.TAG, "setVideoPath, media player prepare async");
    ((MPExoVideoWrapper)localObject).prepareAsync();
    com.tencent.e.h.ZvG.d((Runnable)new MPExoVideoWrapper.z((MPExoVideoWrapper)localObject), "AppBrandVideo_checkVideoUrl");
    if (this.sVf > 0)
    {
      paramString = this.sUW;
      if (paramString == null) {
        p.iCn();
      }
      paramString.ab(this.sVf, this.cFF);
    }
    if (this.cFF)
    {
      Log.i(TAG, "setVideoPath autoPlay");
      start();
    }
    setMute(this.mIsMute);
    AppMethodBeat.o(7556);
  }
  
  public final boolean getAutoPlay()
  {
    return this.cFF;
  }
  
  public final FrameLayout getBackgroudContainerLayout()
  {
    return this.sVa;
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(7535);
    if (this.sUW != null)
    {
      MPExoVideoWrapper localMPExoVideoWrapper = this.sUW;
      if (localMPExoVideoWrapper == null) {
        p.iCn();
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.sUW;
    if (localMPExoVideoWrapper == null) {
      p.iCn();
    }
    int i = localMPExoVideoWrapper.getCurrPosMs();
    AppMethodBeat.o(7534);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(7533);
    MPExoVideoWrapper localMPExoVideoWrapper = this.sUW;
    if (localMPExoVideoWrapper == null) {
      p.iCn();
    }
    int i = localMPExoVideoWrapper.getCurrPosSec();
    AppMethodBeat.o(7533);
    return i;
  }
  
  public final FrameLayout getDotContainerLayout()
  {
    return this.sUZ;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(7531);
    if (this.alM > 0)
    {
      i = this.alM;
      AppMethodBeat.o(7531);
      return i;
    }
    MPExoVideoWrapper localMPExoVideoWrapper = this.sUW;
    if (localMPExoVideoWrapper == null) {
      p.iCn();
    }
    int i = localMPExoVideoWrapper.getVideoDurationSec();
    AppMethodBeat.o(7531);
    return i;
  }
  
  public final int getEndPlayTime()
  {
    AppMethodBeat.i(7530);
    if ((getCurrPosMs() == 0) && (this.mfx != 0))
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
    return this.sVj;
  }
  
  public final boolean getPlayStart()
  {
    return this.sVb;
  }
  
  public final boolean getPlayStarted()
  {
    return this.sVc;
  }
  
  public final int getPlayStatus()
  {
    return this.mfx;
  }
  
  public final FrameLayout getPlayerAdContainerLayout()
  {
    return this.sUY;
  }
  
  public final long getRealPlayTime()
  {
    AppMethodBeat.i(7529);
    if ((!this.sVi) && (this.sVh != 0L) && (isPlaying()))
    {
      l1 = System.currentTimeMillis();
      long l2 = this.sVh;
      AppMethodBeat.o(7529);
      return l1 - l2;
    }
    long l1 = this.sVg;
    AppMethodBeat.o(7529);
    return l1;
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.sUW;
    if (localMPExoVideoWrapper == null) {
      p.iCn();
    }
    boolean bool = localMPExoVideoWrapper.isPlaying();
    AppMethodBeat.o(7550);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    AppMethodBeat.i(7575);
    p.k(paramMotionEvent, "event");
    if (!bUK())
    {
      AppMethodBeat.o(7575);
      return false;
    }
    p.k(paramMotionEvent, "event");
    if (this.puS) {
      bool1 = true;
    }
    while (bool1)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.ui.a locala = this.puF;
      if (locala != null) {
        locala.C(paramMotionEvent);
      }
      AppMethodBeat.o(7575);
      return true;
      boolean bool2 = bUM();
      if (bUN()) {
        bool1 = bool2;
      }
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if ((this.puB) && (!this.puO))
      {
        paramMotionEvent = this.sUX;
        if (paramMotionEvent == null) {
          p.iCn();
        }
        paramMotionEvent.bVb();
      }
      paramMotionEvent = this.pun;
      if (paramMotionEvent == null) {
        p.iCn();
      }
      if ((paramMotionEvent.getVisibility() != 0) && (this.puR)) {
        bUI();
      }
    }
    bool1 = this.puK;
    AppMethodBeat.o(7575);
    return bool1;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(7552);
    Log.i(TAG, "pause");
    MPExoVideoWrapper localMPExoVideoWrapper = this.sUW;
    if (localMPExoVideoWrapper == null) {
      p.iCn();
    }
    if (!localMPExoVideoWrapper.isPlaying())
    {
      AppMethodBeat.o(7552);
      return;
    }
    localMPExoVideoWrapper = this.sUW;
    if (localMPExoVideoWrapper == null) {
      p.iCn();
    }
    localMPExoVideoWrapper.pause();
    AppMethodBeat.o(7552);
  }
  
  public final void s(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(7576);
    Log.i(TAG, "operateFullScreen toFullScreen:%b direction:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.sVd == null)
    {
      Log.w(TAG, "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(7576);
      return;
    }
    if (paramBoolean == bUK())
    {
      Log.i(TAG, "operateFullScreen current same");
      AppMethodBeat.o(7576);
      return;
    }
    if (paramInt == sVk) {
      if (this.puh == sVk)
      {
        paramInt = 90;
        Log.i(TAG, "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (this.sVd == null) {
          p.iCn();
        }
        localObject = this.sUX;
        if (localObject != null) {
          ((MPVideoViewControlBar)localObject).setDirection(paramInt);
        }
        localObject = this.sUX;
        if (localObject != null) {
          ((MPVideoViewControlBar)localObject).Nq();
        }
        localObject = this.sUW;
        if (localObject != null)
        {
          ((MPExoVideoWrapper)localObject).nzN = true;
          AppMethodBeat.o(7576);
          return;
          paramInt = this.puh;
          break;
        }
        AppMethodBeat.o(7576);
        return;
      }
      Object localObject = this.sUX;
      if (localObject != null) {
        ((MPVideoViewControlBar)localObject).bSs();
      }
      localObject = this.sUW;
      if (localObject != null)
      {
        ((MPExoVideoWrapper)localObject).nzN = false;
        AppMethodBeat.o(7576);
        return;
      }
      AppMethodBeat.o(7576);
      return;
    }
  }
  
  public final void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(7547);
    Log.i(TAG, "setAutoPlay =%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.cFF = paramBoolean;
    if ((this.cFF) && (this.mfx == 0)) {
      this.mfx = 1;
    }
    AppMethodBeat.o(7547);
  }
  
  public final void setBackgroudContainerLayout(FrameLayout paramFrameLayout)
  {
    this.sVa = paramFrameLayout;
  }
  
  public final void setConsumeTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(7540);
    Log.i(TAG, "setConsumeTouchEvent value=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puK = paramBoolean;
    AppMethodBeat.o(7540);
  }
  
  public final void setDotContainerLayout(FrameLayout paramFrameLayout)
  {
    this.sUZ = paramFrameLayout;
  }
  
  public final void setDuration(int paramInt)
  {
    AppMethodBeat.i(7532);
    if (paramInt <= 0)
    {
      Log.i(TAG, "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(7532);
      return;
    }
    TextView localTextView = this.pup;
    if (localTextView == null) {
      p.iCn();
    }
    localTextView.setText((CharSequence)AP(paramInt));
    this.alM = paramInt;
    AppMethodBeat.o(7532);
  }
  
  public final void setEnablePlayGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(7546);
    Log.i(TAG, "setEnablePlayGesture: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puS = paramBoolean;
    AppMethodBeat.o(7546);
  }
  
  public final void setFullScreenDelegate(MPVideoView.b paramb)
  {
    AppMethodBeat.i(7572);
    p.k(paramb, "delegate");
    this.sVd = paramb;
    AppMethodBeat.o(7572);
  }
  
  public final void setFullScreenDirection(int paramInt)
  {
    AppMethodBeat.i(7568);
    Log.i(TAG, "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.puh = paramInt;
    AppMethodBeat.o(7568);
  }
  
  public final void setInitialTime(int paramInt)
  {
    AppMethodBeat.i(7571);
    Log.i(TAG, "setInitialTime initialTime=%s", new Object[] { Integer.valueOf(paramInt) });
    this.sVf = paramInt;
    AppMethodBeat.o(7571);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(7558);
    Log.i(TAG, "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puB = paramBoolean;
    if (this.sUX != null)
    {
      if (this.puB)
      {
        localMPVideoViewControlBar = this.sUX;
        if (localMPVideoViewControlBar == null) {
          p.iCn();
        }
        localMPVideoViewControlBar.bVc();
        AppMethodBeat.o(7558);
        return;
      }
      MPVideoViewControlBar localMPVideoViewControlBar = this.sUX;
      if (localMPVideoViewControlBar == null) {
        p.iCn();
      }
      localMPVideoViewControlBar.hide();
    }
    AppMethodBeat.o(7558);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(7549);
    Log.i(TAG, "setLoop loop=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mLoop = paramBoolean;
    AppMethodBeat.o(7549);
  }
  
  public final void setMPVideoViewCallBack(MPVideoView.c paramc)
  {
    AppMethodBeat.i(7573);
    p.k(paramc, "delegate");
    this.sVe = paramc;
    AppMethodBeat.o(7573);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(7567);
    Log.i(TAG, "setMute isMute=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    Object localObject = this.sUW;
    if (localObject == null) {
      p.iCn();
    }
    ((MPExoVideoWrapper)localObject).setMute(paramBoolean);
    localObject = this.sUX;
    if (localObject == null) {
      p.iCn();
    }
    ((MPVideoViewControlBar)localObject).setMuteBtnState(paramBoolean);
    AppMethodBeat.o(7567);
  }
  
  public final void setNeedHandleTouchEvent(boolean paramBoolean)
  {
    this.sVj = paramBoolean;
  }
  
  public final void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(7569);
    Log.i(TAG, "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puD = paramBoolean;
    AppMethodBeat.o(7569);
  }
  
  public final void setPageGestureInFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(7570);
    Log.i(TAG, "setPageGestureInFullscreen pageGestureInFullscreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puE = paramBoolean;
    AppMethodBeat.o(7570);
  }
  
  public final void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(7577);
    p.k(paramOnClickListener, "click");
    MPVideoViewControlBar localMPVideoViewControlBar = this.sUX;
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
    p.k(paramString, "playBtnPosition");
    Log.i(TAG, "setPlayBtnPosition: %s", new Object[] { paramString });
    if ((!Util.isNullOrNil(paramString)) && (n.L(paramString, "center", true)))
    {
      paramString = this.sUX;
      if (paramString == null) {
        p.iCn();
      }
      paramString.setPlayBtnInCenterPosition(true);
      AppMethodBeat.o(7545);
      return;
    }
    paramString = this.sUX;
    if (paramString == null) {
      p.iCn();
    }
    paramString.setPlayBtnInCenterPosition(false);
    AppMethodBeat.o(7545);
  }
  
  public final void setPlayStatus(int paramInt)
  {
    this.mfx = paramInt;
  }
  
  public final void setPlayerAdContainerLayout(FrameLayout paramFrameLayout)
  {
    this.sUY = paramFrameLayout;
  }
  
  public final void setShowCenterPlayBtn(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(7566);
    Log.i(TAG, "setPlayBtnInCenterPosition %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puO = paramBoolean;
    Object localObject = this.pun;
    if (localObject == null) {
      p.iCn();
    }
    if (paramBoolean)
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.puo;
      if (localObject == null) {
        p.iCn();
      }
      if (!paramBoolean) {
        break label131;
      }
    }
    label131:
    for (int i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      if ((this.puO) && (this.sUX != null))
      {
        localObject = this.sUX;
        if (localObject == null) {
          p.iCn();
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
    Log.i(TAG, "setShowControlProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.sUX;
    if (localMPVideoViewControlBar == null) {
      p.iCn();
    }
    if ((paramBoolean) && (!isLive())) {}
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
    Log.i(TAG, "setShowFullScreenBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.sUX;
    if (localMPVideoViewControlBar == null) {
      p.iCn();
    }
    localMPVideoViewControlBar.setShowFullScreenBtn(paramBoolean);
    AppMethodBeat.o(7564);
  }
  
  public final void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(7541);
    Log.i(TAG, "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.sUX;
    if (localMPVideoViewControlBar == null) {
      p.iCn();
    }
    localMPVideoViewControlBar.setShowMuteBtn(paramBoolean);
    AppMethodBeat.o(7541);
  }
  
  public final void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(7565);
    Log.i(TAG, "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.sUX;
    if (localMPVideoViewControlBar == null) {
      p.iCn();
    }
    localMPVideoViewControlBar.setShowPlayBtn(paramBoolean);
    AppMethodBeat.o(7565);
  }
  
  public final void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(7563);
    Log.i(TAG, "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puM = paramBoolean;
    MPVideoViewControlBar localMPVideoViewControlBar = this.sUX;
    if (localMPVideoViewControlBar == null) {
      p.iCn();
    }
    if ((paramBoolean) && (!isLive())) {}
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
    Log.i(TAG, "setTitle %s", new Object[] { paramString });
    MPVideoViewControlBar localMPVideoViewControlBar = this.sUX;
    if (localMPVideoViewControlBar == null) {
      p.iCn();
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
    Log.i(TAG, "setVideoSource =%d", new Object[] { Integer.valueOf(paramInt) });
    this.puP = paramInt;
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.sUW;
    if (localMPExoVideoWrapper == null) {
      p.iCn();
    }
    Log.i((String)localObject, localMPExoVideoWrapper.isPlaying());
    localObject = this.sUW;
    if (localObject == null) {
      p.iCn();
    }
    if (((MPExoVideoWrapper)localObject).isPlaying())
    {
      AppMethodBeat.o(7551);
      return;
    }
    this.sVb = true;
    if (this.puB)
    {
      localObject = this.sUX;
      if (localObject == null) {
        p.iCn();
      }
      ((MPVideoViewControlBar)localObject).bVg();
    }
    localObject = this.pun;
    if (localObject == null) {
      p.iCn();
    }
    ((View)localObject).setVisibility(8);
    localObject = this.sUW;
    if (localObject == null) {
      p.iCn();
    }
    ((MPExoVideoWrapper)localObject).start();
    cEB();
    AppMethodBeat.o(7551);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(MPVideoView paramMPVideoView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7486);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.sVn.start();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(7486);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(MPVideoView paramMPVideoView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7487);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (!this.sVn.bUK()) {}
      for (boolean bool = true;; bool = false)
      {
        paramView = this.sVn;
        paramView.s(bool, MPVideoView.y(paramView));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7487);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(MPVideoView paramMPVideoView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7493);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.sVn;
      if (!MPVideoView.B(this.sVn)) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.setMute(bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7493);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(MPVideoView paramMPVideoView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7494);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.sVn.s(false, MPVideoView.y(this.sVn));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(7494);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView
 * JD-Core Version:    0.7.0.1
 */