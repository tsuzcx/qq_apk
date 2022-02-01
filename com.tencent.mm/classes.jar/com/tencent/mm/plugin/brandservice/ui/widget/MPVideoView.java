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
import com.tencent.mm.ag.x;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.a;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroudContainerLayout", "Landroid/widget/FrameLayout;", "getBackgroudContainerLayout", "()Landroid/widget/FrameLayout;", "setBackgroudContainerLayout", "(Landroid/widget/FrameLayout;)V", "cacheTimeSec", "getCacheTimeSec", "()I", "currPosMs", "getCurrPosMs", "currPosSec", "getCurrPosSec", "dotContainerLayout", "getDotContainerLayout", "setDotContainerLayout", "duration", "getDuration", "setDuration", "(I)V", "endPlayTime", "getEndPlayTime", "hasDownInTouchEvent", "", "hasRealPlayTime", "isCoverVisible", "()Z", "isInFullScreen", "isLive", "mAdjustContentTv", "Landroid/widget/TextView;", "mAdjustIconIv", "Landroid/widget/ImageView;", "mAdjustInfoLayout", "Landroid/widget/LinearLayout;", "mAdjustPercentIndicator", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/AppBrandDotPercentIndicator;", "mAutoPlay", "mBottomProgressBackBar", "mBottomProgressFrontBar", "mBottomProgressLayout", "mConsumeTouchEvent", "mControlBar", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar;", "mCoverArea", "Landroid/view/View;", "mCoverPlayBtnArea", "mCoverTotalTimeTv", "mCoverUrl", "", "mDirection", "mDuration", "mEnablePlayGesture", "mEnableProgressGesture", "mFullScreenDelegate", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "mGestureController", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController;", "mInitialTime", "mIsAlive", "mIsLoading", "mIsMute", "mIsShowBasicControls", "mLoop", "mMPVideoViewCallBack", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "mPageGesture", "mPageGestureInFullscreen", "mPlayStart", "mPlayStarted", "mProgressTv", "mRealPlayTime", "", "mSetIsShowCoverPlayBtn", "mSetIsShowProgressBar", "mSkipAutoPause", "mStartPlayTime", "mVideoSource", "mVideoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper;", "needHandleTouchEvent", "getNeedHandleTouchEvent", "setNeedHandleTouchEvent", "(Z)V", "playStatus", "getPlayStatus", "setPlayStatus", "playerAdContainerLayout", "getPlayerAdContainerLayout", "setPlayerAdContainerLayout", "realPlayTime", "getRealPlayTime", "()J", "videoHeight", "getVideoHeight", "setVideoHeight", "<set-?>", "videoPath", "getVideoPath", "()Ljava/lang/String;", "videoWidth", "getVideoWidth", "setVideoWidth", "canAdjustBrightnessVolume", "canDragProgress", "clean", "", "doOnTouchEvent", "event", "Landroid/view/MotionEvent;", "downloadVideo", "videoUrl", "enableProgressGesture", "enable", "getAutoPlay", "getPlayStart", "getPlayStarted", "getTimeShowString", "time", "hideCenterPlayBtnIfNeed", "hideCover", "init", "initControlBar", "initGestureController", "initParam", "initVideoViewCallback", "isControlBarShow", "isPlaying", "makeTimeString", "d", "onExitFullScreen", "onTouchEvent", "onUIDestroy", "onUIPause", "onUIResume", "operateFullScreen", "toFullScreen", "direction", "pause", "seekTo", "position", "afterPlay", "setAutoPlay", "autoPlay", "setBizInfo", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "iconUrl", "setConsumeTouchEvent", "value", "setCoverByUrl", "cover", "coverUrl", "width", "height", "setEnablePlayGesture", "enablePlayGesture", "setExoPlayerParam", "maxInitialBitrate", "bandwidthFraction", "", "minDurForQualityMs", "maxDurForQualityMs", "minBufferMs", "maxBufferMs", "setFullScreenDelegate", "delegate", "setFullScreenDirection", "setInitialTime", "initialTime", "setIsShowBasicControls", "isShowBasicControls", "setLoop", "loop", "setMPVideoViewCallBack", "setMute", "isMute", "setObjectFit", "setPageGesture", "pageGesture", "setPageGestureInFullscreen", "pageGestureInFullscreen", "setPlayBtnOnClickListener", "click", "Landroid/view/View$OnClickListener;", "setPlayBtnPosition", "playBtnPosition", "setPreLoadVidePath", "setShowCenterPlayBtn", "showCenterPlayBtn", "setShowControlProgress", "showControlProgress", "setShowFullScreenBtn", "showFullScreenBtn", "setShowMuteBtn", "showMuteBtn", "setShowPlayBtn", "showPlayBtn", "setShowProgress", "showProgress", "setTitle", "title", "setVideoPath", "durationSec", "setVideoSource", "videoSource", "setVideoUrlInfo", "urlInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "currentInfo", "shouldDispatchEventToGestureController", "shouldHandleTouchEvent", "v", "e", "showCenterPlayBtnIfNeed", "showControlBar", "showCover", "start", "startWhenNetWorkConnect", "stop", "updateBottomProgressLayout", "updateControlBarDotPos", "list", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "updateLiveUI", "updateRealPlayTime", "updateStartTime", "Companion", "FullScreenDelegate", "MPVideoViewCallBack", "plugin-brandservice_release"})
public final class MPVideoView
  extends RelativeLayout
{
  public static final String TAG = "MicroMsg.MPVideoView";
  private static final int pOo = -1;
  private static final int pOp = 8;
  public static final MPVideoView.a pOq;
  private int add;
  private int atU;
  private boolean cEZ;
  private int jpW;
  private boolean mIsMute;
  private boolean mLoop;
  private TextView mvK;
  private View mvN;
  private View mvO;
  private TextView mvP;
  private LinearLayout mvQ;
  private AppBrandDotPercentIndicator mvR;
  private TextView mvS;
  private ImageView mvT;
  private ImageView mvV;
  private ImageView mvW;
  private FrameLayout mvX;
  private boolean mwb;
  private boolean mwd;
  private boolean mwe;
  private com.tencent.mm.plugin.appbrand.jsapi.video.ui.a mwf;
  private boolean mwh;
  private String mwj;
  private boolean mwk;
  private boolean mwl;
  private boolean mwm;
  private boolean mwo;
  private int mwp;
  private boolean mwr;
  private boolean mws;
  public boolean mwt;
  public MPExoVideoWrapper pNZ;
  public MPVideoViewControlBar pOa;
  private FrameLayout pOb;
  private FrameLayout pOc;
  private FrameLayout pOd;
  private boolean pOe;
  private boolean pOf;
  private b pOg;
  private c pOh;
  private int pOi;
  private long pOj;
  private long pOk;
  private boolean pOl;
  public boolean pOm;
  public boolean pOn;
  private int videoHeight;
  private String videoPath;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(7587);
    pOq = new MPVideoView.a((byte)0);
    TAG = "MicroMsg.MPVideoView";
    pOo = -1;
    pOp = 8;
    AppMethodBeat.o(7587);
  }
  
  public MPVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(7584);
    this.add = pOo;
    init(paramContext);
    AppMethodBeat.o(7584);
  }
  
  public MPVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7585);
    this.add = pOo;
    init(paramContext);
    AppMethodBeat.o(7585);
  }
  
  public MPVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(7586);
    this.add = pOo;
    init(paramContext);
    AppMethodBeat.o(7586);
  }
  
  private final void bIZ()
  {
    AppMethodBeat.i(7574);
    MPVideoViewControlBar localMPVideoViewControlBar = this.pOa;
    if (localMPVideoViewControlBar == null) {
      p.hyc();
    }
    localMPVideoViewControlBar.bIZ();
    AppMethodBeat.o(7574);
  }
  
  private final boolean bJd()
  {
    AppMethodBeat.i(7582);
    if (this.mwl)
    {
      MPExoVideoWrapper localMPExoVideoWrapper = this.pNZ;
      if (localMPExoVideoWrapper == null) {
        p.hyc();
      }
      if ((!localMPExoVideoWrapper.bzP) && (!bJf()))
      {
        AppMethodBeat.o(7582);
        return true;
      }
    }
    AppMethodBeat.o(7582);
    return false;
  }
  
  private final boolean bJe()
  {
    AppMethodBeat.i(7583);
    if ((!bJf()) && (((!bJb()) && (this.mwd)) || ((bJb()) && (this.mwe))))
    {
      AppMethodBeat.o(7583);
      return true;
    }
    AppMethodBeat.o(7583);
    return false;
  }
  
  private final boolean bJf()
  {
    AppMethodBeat.i(7538);
    View localView = this.mvN;
    if (localView == null) {
      p.hyc();
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
    Log.i(TAG, "clean");
    stop();
    Object localObject = this.pNZ;
    if (localObject == null) {
      p.hyc();
    }
    ((MPExoVideoWrapper)localObject).onUIDestroy();
    localObject = this.pOa;
    if (localObject == null) {
      p.hyc();
    }
    ((MPVideoViewControlBar)localObject).onDestroy();
    AppMethodBeat.o(7555);
  }
  
  private final boolean crB()
  {
    AppMethodBeat.i(175553);
    if (this.mws)
    {
      AppMethodBeat.o(175553);
      return true;
    }
    boolean bool = bJd();
    if (!bJe())
    {
      AppMethodBeat.o(175553);
      return false;
    }
    AppMethodBeat.o(175553);
    return bool;
  }
  
  private final void init(Context paramContext)
  {
    AppMethodBeat.i(7539);
    LayoutInflater.from(paramContext).inflate(2131495700, (ViewGroup)this);
    this.pNZ = ((MPExoVideoWrapper)findViewById(2131309841));
    paramContext = findViewById(2131306281);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.mvK = ((TextView)paramContext);
    this.mvN = findViewById(2131299279);
    this.mvO = findViewById(2131299293);
    paramContext = findViewById(2131299297);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.mvP = ((TextView)paramContext);
    paramContext = findViewById(2131296579);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.mvQ = ((LinearLayout)paramContext);
    paramContext = findViewById(2131296580);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.mvR = ((AppBrandDotPercentIndicator)paramContext);
    paramContext = findViewById(2131296576);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.mvS = ((TextView)paramContext);
    paramContext = findViewById(2131296578);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.mvT = ((ImageView)paramContext);
    paramContext = findViewById(2131305970);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.mvV = ((ImageView)paramContext);
    paramContext = findViewById(2131305969);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.mvW = ((ImageView)paramContext);
    paramContext = findViewById(2131305971);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.mvX = ((FrameLayout)paramContext);
    paramContext = findViewById(2131305966);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.pOb = ((FrameLayout)paramContext);
    paramContext = findViewById(2131305972);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.pOc = ((FrameLayout)paramContext);
    paramContext = findViewById(2131305967);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.pOd = ((FrameLayout)paramContext);
    paramContext = this.mvR;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.setDotsNum(pOp);
    paramContext = findViewById(2131299292);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    ((ImageView)paramContext).setOnClickListener((View.OnClickListener)new MPVideoView.d(this));
    this.mwf = new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a(getContext(), (View)this, (a.b)new o(this));
    paramContext = this.pNZ;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.setIMMVideoViewCallback((i.b)new p(this));
    this.pOa = new MPVideoViewControlBar(getContext());
    paramContext = this.pNZ;
    if (paramContext == null) {
      p.hyc();
    }
    MPVideoViewControlBar localMPVideoViewControlBar = this.pOa;
    if (localMPVideoViewControlBar == null) {
      p.hyc();
    }
    paramContext.setVideoFooterView((h)localMPVideoViewControlBar);
    paramContext = this.pOa;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.hide();
    paramContext = this.pOa;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.setFullScreenBtnOnClickListener((View.OnClickListener)new MPVideoView.e(this));
    paramContext = this.pOa;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.setIplaySeekCallback((e.d)new g(this));
    paramContext = this.pOa;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.setOnPlayButtonClickListener((View.OnClickListener)new h(this));
    paramContext = this.pOa;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.setStatePorter((e.i)new i(this));
    paramContext = this.pOa;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.setMuteBtnOnClickListener((View.OnClickListener)new j(this));
    paramContext = this.pOa;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.setExitFullScreenBtnOnClickListener((View.OnClickListener)new MPVideoView.k(this));
    paramContext = this.pOa;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.a((e.f)new l(this));
    paramContext = this.pOa;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.setOnUpdateProgressLenListener((e.e)new m(this));
    paramContext = this.pOa;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.setSwitchResolutionListener((MPVideoViewControlBar.a)new n(this));
    paramContext = this.pOa;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.setSwitchSpeedListener((MPVideoViewControlBar.b)new f(this));
    paramContext = this.pNZ;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext = paramContext.getCoverIv();
    if (paramContext == null) {
      p.hyc();
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
    this.mwl = true;
    setVideoSource(0);
    setConsumeTouchEvent(false);
    setIsShowBasicControls(true);
    AppMethodBeat.o(7539);
  }
  
  private final boolean isLive()
  {
    AppMethodBeat.i(7537);
    Object localObject = TAG;
    boolean bool = this.mwh;
    MPExoVideoWrapper localMPExoVideoWrapper = this.pNZ;
    if (localMPExoVideoWrapper == null) {
      p.hyc();
    }
    Log.i((String)localObject, "isLive %b %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localMPExoVideoWrapper.bzP) });
    if (!this.mwh)
    {
      localObject = this.pNZ;
      if (localObject == null) {
        p.hyc();
      }
      if (!((MPExoVideoWrapper)localObject).bzP) {}
    }
    else
    {
      AppMethodBeat.o(7537);
      return true;
    }
    AppMethodBeat.o(7537);
    return false;
  }
  
  private static String xs(int paramInt)
  {
    AppMethodBeat.i(7580);
    String str = xt(paramInt / 60) + ":" + xt(paramInt % 60);
    AppMethodBeat.o(7580);
    return str;
  }
  
  private static String xt(int paramInt)
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
  
  public final boolean Q(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(175552);
    p.h(paramMotionEvent, "event");
    if (crB())
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.ui.a locala = this.mwf;
      if (locala != null) {
        locala.A(paramMotionEvent);
      }
      AppMethodBeat.o(175552);
      return true;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if ((this.mwb) && (!this.mwo))
      {
        paramMotionEvent = this.pOa;
        if (paramMotionEvent == null) {
          p.hyc();
        }
        paramMotionEvent.bJu();
      }
      paramMotionEvent = this.mvN;
      if (paramMotionEvent == null) {
        p.hyc();
      }
      if ((paramMotionEvent.getVisibility() != 0) && (this.mwr)) {
        bIZ();
      }
    }
    boolean bool = this.mwk;
    AppMethodBeat.o(175552);
    return bool;
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(175550);
    MPExoVideoWrapper localMPExoVideoWrapper = this.pNZ;
    if (localMPExoVideoWrapper == null) {
      p.hyc();
    }
    localMPExoVideoWrapper.a(paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(175550);
  }
  
  public final void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, x paramx)
  {
    AppMethodBeat.i(7559);
    p.h(paramx, "msgInfo");
    Log.i(TAG, "setCover coverUrl=%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7559);
      return;
    }
    this.mwj = paramString;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l locall = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.pLy;
    if (paramString == null) {
      p.hyc();
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(paramImageView, paramString, paramInt1, paramInt2, paramx);
    AppMethodBeat.o(7559);
  }
  
  public final void a(LinkedList<gh> paramLinkedList, gh paramgh)
  {
    AppMethodBeat.i(175551);
    p.h(paramLinkedList, "urlInfoList");
    p.h(paramgh, "currentInfo");
    MPVideoViewControlBar localMPVideoViewControlBar = this.pOa;
    if (localMPVideoViewControlBar == null) {
      p.hyc();
    }
    localMPVideoViewControlBar.a(paramLinkedList, paramgh);
    AppMethodBeat.o(175551);
  }
  
  public final boolean bJb()
  {
    AppMethodBeat.i(7536);
    if (this.pOg == null)
    {
      Log.w(TAG, "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(7536);
      return false;
    }
    b localb = this.pOg;
    if (localb == null) {
      p.hyc();
    }
    boolean bool = localb.isFullScreen();
    AppMethodBeat.o(7536);
    return bool;
  }
  
  public final void cN(String paramString, int paramInt)
  {
    AppMethodBeat.i(7556);
    p.h(paramString, "videoPath");
    Log.i(TAG, "setVideoPath path=%s isLive=%s", new Object[] { paramString, Boolean.FALSE });
    if (Util.isNullOrNil(paramString))
    {
      Log.v(TAG, "setVideoPath videoPath empty");
      AppMethodBeat.o(7556);
      return;
    }
    this.videoPath = paramString;
    stop();
    this.mwh = false;
    MPExoVideoWrapper localMPExoVideoWrapper = this.pNZ;
    if (localMPExoVideoWrapper == null) {
      p.hyc();
    }
    localMPExoVideoWrapper.setVideoSource(this.mwp);
    localMPExoVideoWrapper = this.pNZ;
    if (localMPExoVideoWrapper == null) {
      p.hyc();
    }
    localMPExoVideoWrapper.cM(paramString, paramInt);
    if (this.pOi > 0)
    {
      paramString = this.pNZ;
      if (paramString == null) {
        p.hyc();
      }
      paramString.ac(this.pOi, this.cEZ);
    }
    if (this.cEZ)
    {
      Log.i(TAG, "setVideoPath autoPlay");
      start();
    }
    setMute(this.mIsMute);
    AppMethodBeat.o(7556);
  }
  
  public final void crA()
  {
    long l1 = 0L;
    AppMethodBeat.i(196026);
    long l2 = System.currentTimeMillis();
    long l3 = this.pOj;
    if (this.pOk != 0L) {
      l1 = l2 - this.pOk;
    }
    this.pOj = (l1 + l3);
    this.pOk = l2;
    this.pOl = true;
    AppMethodBeat.o(196026);
  }
  
  public final void crC()
  {
    AppMethodBeat.i(7578);
    MPVideoViewControlBar localMPVideoViewControlBar = this.pOa;
    if (localMPVideoViewControlBar != null) {
      localMPVideoViewControlBar.crH();
    }
    localMPVideoViewControlBar = this.pOa;
    if (localMPVideoViewControlBar != null)
    {
      localMPVideoViewControlBar.show();
      AppMethodBeat.o(7578);
      return;
    }
    AppMethodBeat.o(7578);
  }
  
  public final boolean crD()
  {
    AppMethodBeat.i(7579);
    MPVideoViewControlBar localMPVideoViewControlBar = this.pOa;
    if (localMPVideoViewControlBar != null)
    {
      boolean bool = localMPVideoViewControlBar.bJw();
      AppMethodBeat.o(7579);
      return bool;
    }
    AppMethodBeat.o(7579);
    return false;
  }
  
  public final void crr()
  {
    AppMethodBeat.i(7561);
    MPExoVideoWrapper localMPExoVideoWrapper = this.pNZ;
    if (localMPExoVideoWrapper == null) {
      p.hyc();
    }
    localMPExoVideoWrapper.crr();
    AppMethodBeat.o(7561);
  }
  
  public final void crs()
  {
    AppMethodBeat.i(7562);
    MPExoVideoWrapper localMPExoVideoWrapper = this.pNZ;
    if (localMPExoVideoWrapper == null) {
      p.hyc();
    }
    localMPExoVideoWrapper.crs();
    AppMethodBeat.o(7562);
  }
  
  public final boolean getAutoPlay()
  {
    return this.cEZ;
  }
  
  public final FrameLayout getBackgroudContainerLayout()
  {
    return this.pOd;
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(7535);
    if (this.pNZ != null)
    {
      MPExoVideoWrapper localMPExoVideoWrapper = this.pNZ;
      if (localMPExoVideoWrapper == null) {
        p.hyc();
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.pNZ;
    if (localMPExoVideoWrapper == null) {
      p.hyc();
    }
    int i = localMPExoVideoWrapper.getCurrPosMs();
    AppMethodBeat.o(7534);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(7533);
    MPExoVideoWrapper localMPExoVideoWrapper = this.pNZ;
    if (localMPExoVideoWrapper == null) {
      p.hyc();
    }
    int i = localMPExoVideoWrapper.getCurrPosSec();
    AppMethodBeat.o(7533);
    return i;
  }
  
  public final FrameLayout getDotContainerLayout()
  {
    return this.pOc;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(7531);
    if (this.atU > 0)
    {
      i = this.atU;
      AppMethodBeat.o(7531);
      return i;
    }
    MPExoVideoWrapper localMPExoVideoWrapper = this.pNZ;
    if (localMPExoVideoWrapper == null) {
      p.hyc();
    }
    int i = localMPExoVideoWrapper.getVideoDurationSec();
    AppMethodBeat.o(7531);
    return i;
  }
  
  public final int getEndPlayTime()
  {
    AppMethodBeat.i(7530);
    if ((getCurrPosMs() == 0) && (this.jpW != 0))
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
    return this.pOm;
  }
  
  public final boolean getPlayStart()
  {
    return this.pOe;
  }
  
  public final boolean getPlayStarted()
  {
    return this.pOf;
  }
  
  public final int getPlayStatus()
  {
    return this.jpW;
  }
  
  public final FrameLayout getPlayerAdContainerLayout()
  {
    return this.pOb;
  }
  
  public final long getRealPlayTime()
  {
    AppMethodBeat.i(7529);
    if ((!this.pOl) && (this.pOk != 0L) && (isPlaying()))
    {
      l1 = System.currentTimeMillis();
      long l2 = this.pOk;
      AppMethodBeat.o(7529);
      return l1 - l2;
    }
    long l1 = this.pOj;
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.pNZ;
    if (localMPExoVideoWrapper == null) {
      p.hyc();
    }
    boolean bool = localMPExoVideoWrapper.isPlaying();
    AppMethodBeat.o(7550);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(7575);
    p.h(paramMotionEvent, "event");
    if (!bJb())
    {
      AppMethodBeat.o(7575);
      return false;
    }
    boolean bool = Q(paramMotionEvent);
    AppMethodBeat.o(7575);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(7554);
    Log.i(TAG, "onUIDestroy");
    clean();
    AppMethodBeat.o(7554);
  }
  
  public final void p(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(7576);
    Log.i(TAG, "operateFullScreen toFullScreen:%b direction:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.pOg == null)
    {
      Log.w(TAG, "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(7576);
      return;
    }
    if (paramBoolean == bJb())
    {
      Log.i(TAG, "operateFullScreen current same");
      AppMethodBeat.o(7576);
      return;
    }
    if (paramInt == pOo) {
      if (this.add == pOo)
      {
        paramInt = 90;
        Log.i(TAG, "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject = this.pOg;
        if (localObject == null) {
          p.hyc();
        }
        ((b)localObject).xd(paramInt);
        localObject = this.pOa;
        if (localObject != null) {
          ((MPVideoViewControlBar)localObject).setDirection(paramInt);
        }
        localObject = this.pOa;
        if (localObject != null) {
          ((MPVideoViewControlBar)localObject).KD();
        }
        localObject = this.pNZ;
        if (localObject != null)
        {
          ((MPExoVideoWrapper)localObject).kGg = true;
          AppMethodBeat.o(7576);
          return;
          paramInt = this.add;
          break;
        }
        AppMethodBeat.o(7576);
        return;
      }
      Object localObject = this.pOg;
      if (localObject != null) {
        ((b)localObject).bGL();
      }
      localObject = this.pOa;
      if (localObject != null) {
        ((MPVideoViewControlBar)localObject).bGL();
      }
      localObject = this.pNZ;
      if (localObject != null)
      {
        ((MPExoVideoWrapper)localObject).kGg = false;
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
    Log.i(TAG, "pause");
    MPExoVideoWrapper localMPExoVideoWrapper = this.pNZ;
    if (localMPExoVideoWrapper == null) {
      p.hyc();
    }
    if (!localMPExoVideoWrapper.isPlaying())
    {
      AppMethodBeat.o(7552);
      return;
    }
    localMPExoVideoWrapper = this.pNZ;
    if (localMPExoVideoWrapper == null) {
      p.hyc();
    }
    localMPExoVideoWrapper.pause();
    AppMethodBeat.o(7552);
  }
  
  public final void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(7547);
    Log.i(TAG, "setAutoPlay =%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.cEZ = paramBoolean;
    if ((this.cEZ) && (this.jpW == 0)) {
      this.jpW = 1;
    }
    AppMethodBeat.o(7547);
  }
  
  public final void setBackgroudContainerLayout(FrameLayout paramFrameLayout)
  {
    this.pOd = paramFrameLayout;
  }
  
  public final void setConsumeTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(7540);
    Log.i(TAG, "setConsumeTouchEvent value=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mwk = paramBoolean;
    AppMethodBeat.o(7540);
  }
  
  public final void setDotContainerLayout(FrameLayout paramFrameLayout)
  {
    this.pOc = paramFrameLayout;
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
    TextView localTextView = this.mvP;
    if (localTextView == null) {
      p.hyc();
    }
    localTextView.setText((CharSequence)xs(paramInt));
    this.atU = paramInt;
    AppMethodBeat.o(7532);
  }
  
  public final void setEnablePlayGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(7546);
    Log.i(TAG, "setEnablePlayGesture: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mws = paramBoolean;
    AppMethodBeat.o(7546);
  }
  
  public final void setFullScreenDelegate(b paramb)
  {
    AppMethodBeat.i(7572);
    p.h(paramb, "delegate");
    this.pOg = paramb;
    AppMethodBeat.o(7572);
  }
  
  public final void setFullScreenDirection(int paramInt)
  {
    AppMethodBeat.i(7568);
    Log.i(TAG, "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.add = paramInt;
    AppMethodBeat.o(7568);
  }
  
  public final void setInitialTime(int paramInt)
  {
    AppMethodBeat.i(7571);
    Log.i(TAG, "setInitialTime initialTime=%s", new Object[] { Integer.valueOf(paramInt) });
    this.pOi = paramInt;
    AppMethodBeat.o(7571);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(7558);
    Log.i(TAG, "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mwb = paramBoolean;
    if (this.pOa != null)
    {
      if (this.mwb)
      {
        localMPVideoViewControlBar = this.pOa;
        if (localMPVideoViewControlBar == null) {
          p.hyc();
        }
        localMPVideoViewControlBar.bJv();
        AppMethodBeat.o(7558);
        return;
      }
      MPVideoViewControlBar localMPVideoViewControlBar = this.pOa;
      if (localMPVideoViewControlBar == null) {
        p.hyc();
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
  
  public final void setMPVideoViewCallBack(c paramc)
  {
    AppMethodBeat.i(7573);
    p.h(paramc, "delegate");
    this.pOh = paramc;
    AppMethodBeat.o(7573);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(7567);
    Log.i(TAG, "setMute isMute=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    Object localObject = this.pNZ;
    if (localObject == null) {
      p.hyc();
    }
    ((MPExoVideoWrapper)localObject).setMute(paramBoolean);
    localObject = this.pOa;
    if (localObject == null) {
      p.hyc();
    }
    ((MPVideoViewControlBar)localObject).setMuteBtnState(paramBoolean);
    AppMethodBeat.o(7567);
  }
  
  public final void setNeedHandleTouchEvent(boolean paramBoolean)
  {
    this.pOm = paramBoolean;
  }
  
  public final void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(7569);
    Log.i(TAG, "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mwd = paramBoolean;
    AppMethodBeat.o(7569);
  }
  
  public final void setPageGestureInFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(7570);
    Log.i(TAG, "setPageGestureInFullscreen pageGestureInFullscreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mwe = paramBoolean;
    AppMethodBeat.o(7570);
  }
  
  public final void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(7577);
    p.h(paramOnClickListener, "click");
    MPVideoViewControlBar localMPVideoViewControlBar = this.pOa;
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
    p.h(paramString, "playBtnPosition");
    Log.i(TAG, "setPlayBtnPosition: %s", new Object[] { paramString });
    if ((!Util.isNullOrNil(paramString)) && (n.I(paramString, "center", true)))
    {
      paramString = this.pOa;
      if (paramString == null) {
        p.hyc();
      }
      paramString.setPlayBtnInCenterPosition(true);
      AppMethodBeat.o(7545);
      return;
    }
    paramString = this.pOa;
    if (paramString == null) {
      p.hyc();
    }
    paramString.setPlayBtnInCenterPosition(false);
    AppMethodBeat.o(7545);
  }
  
  public final void setPlayStatus(int paramInt)
  {
    this.jpW = paramInt;
  }
  
  public final void setPlayerAdContainerLayout(FrameLayout paramFrameLayout)
  {
    this.pOb = paramFrameLayout;
  }
  
  public final void setShowCenterPlayBtn(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(7566);
    Log.i(TAG, "setPlayBtnInCenterPosition %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mwo = paramBoolean;
    Object localObject = this.mvN;
    if (localObject == null) {
      p.hyc();
    }
    if (paramBoolean)
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.mvO;
      if (localObject == null) {
        p.hyc();
      }
      if (!paramBoolean) {
        break label131;
      }
    }
    label131:
    for (int i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      if ((this.mwo) && (this.pOa != null))
      {
        localObject = this.pOa;
        if (localObject == null) {
          p.hyc();
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
    MPVideoViewControlBar localMPVideoViewControlBar = this.pOa;
    if (localMPVideoViewControlBar == null) {
      p.hyc();
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
    MPVideoViewControlBar localMPVideoViewControlBar = this.pOa;
    if (localMPVideoViewControlBar == null) {
      p.hyc();
    }
    localMPVideoViewControlBar.setShowFullScreenBtn(paramBoolean);
    AppMethodBeat.o(7564);
  }
  
  public final void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(7541);
    Log.i(TAG, "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.pOa;
    if (localMPVideoViewControlBar == null) {
      p.hyc();
    }
    localMPVideoViewControlBar.setShowMuteBtn(paramBoolean);
    AppMethodBeat.o(7541);
  }
  
  public final void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(7565);
    Log.i(TAG, "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.pOa;
    if (localMPVideoViewControlBar == null) {
      p.hyc();
    }
    localMPVideoViewControlBar.setShowPlayBtn(paramBoolean);
    AppMethodBeat.o(7565);
  }
  
  public final void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(7563);
    Log.i(TAG, "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mwm = paramBoolean;
    MPVideoViewControlBar localMPVideoViewControlBar = this.pOa;
    if (localMPVideoViewControlBar == null) {
      p.hyc();
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
    MPVideoViewControlBar localMPVideoViewControlBar = this.pOa;
    if (localMPVideoViewControlBar == null) {
      p.hyc();
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
    this.mwp = paramInt;
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.pNZ;
    if (localMPExoVideoWrapper == null) {
      p.hyc();
    }
    Log.i((String)localObject, localMPExoVideoWrapper.isPlaying());
    localObject = this.pNZ;
    if (localObject == null) {
      p.hyc();
    }
    if (((MPExoVideoWrapper)localObject).isPlaying())
    {
      AppMethodBeat.o(7551);
      return;
    }
    this.pOe = true;
    if (this.mwb)
    {
      localObject = this.pOa;
      if (localObject == null) {
        p.hyc();
      }
      ((MPVideoViewControlBar)localObject).bJz();
    }
    localObject = this.mvN;
    if (localObject == null) {
      p.hyc();
    }
    ((View)localObject).setVisibility(8);
    localObject = this.pNZ;
    if (localObject == null) {
      p.hyc();
    }
    ((MPExoVideoWrapper)localObject).start();
    crs();
    AppMethodBeat.o(7551);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(7553);
    Log.i(TAG, "stop");
    Object localObject = this.pNZ;
    if (localObject == null) {
      p.hyc();
    }
    if (!((MPExoVideoWrapper)localObject).isPlaying())
    {
      AppMethodBeat.o(7553);
      return;
    }
    localObject = this.pNZ;
    if (localObject == null) {
      p.hyc();
    }
    ((MPExoVideoWrapper)localObject).Qt();
    localObject = this.pOa;
    if (localObject == null) {
      p.hyc();
    }
    ((MPVideoViewControlBar)localObject).bJA();
    crr();
    AppMethodBeat.o(7553);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "enterFullScreen", "", "direction", "", "quitFullScreen", "plugin-brandservice_release"})
  public static abstract interface b
  {
    public abstract void bGL();
    
    public abstract boolean isFullScreen();
    
    public abstract void xd(int paramInt);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "", "onControlbarVisible", "", "visible", "", "onEndDragProgress", "onGetVideoSize", "width", "", "height", "onHideSwitchResolutionLayout", "onHideSwitchSpeedLayout", "onPlayError", "errorMsg", "", "errorCode", "onSeekPre", "onSeekTo", "time", "onStartDragProgress", "onUpdateProgress", "progressLen", "totalLen", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoPrepare", "firstRenderTime", "", "onVideoWaiting", "onVideoWaitingEnd", "resolutionBtnClick", "speedBtnClick", "switchResolution", "beforeType", "afterType", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "switchSpeed", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
  public static abstract interface c
  {
    public abstract void BL(long paramLong);
    
    public abstract void a(int paramInt1, int paramInt2, gh paramgh);
    
    public abstract void a(c.a parama1, c.a parama2);
    
    public abstract void aJq();
    
    public abstract void aiG(String paramString);
    
    public abstract void bJl();
    
    public abstract void cqC();
    
    public abstract void cqD();
    
    public abstract void cqE();
    
    public abstract void cqF();
    
    public abstract void cqG();
    
    public abstract void cqH();
    
    public abstract void cqI();
    
    public abstract void kq(boolean paramBoolean);
    
    public abstract void onVideoEnded();
    
    public abstract void onVideoPause();
    
    public abstract void onVideoPlay();
    
    public abstract void onVideoWaiting();
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$10", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$SwitchSpeedListener;", "onHideSwitchSpeedLayout", "", "speedBtnClick", "switchSpeed", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
  public static final class f
    implements MPVideoViewControlBar.b
  {
    public final void a(gh paramgh, c.a parama1, c.a parama2)
    {
      AppMethodBeat.i(196022);
      Object localObject = MPVideoView.k(this.pOr);
      if (localObject != null) {
        ((MPVideoView.c)localObject).a(parama1, parama2);
      }
      this.pOr.setAutoPlay(this.pOr.isPlaying());
      int j = this.pOr.getCurrPosMs();
      parama2 = MPVideoView.h(this.pOr);
      if (parama2 == null) {
        p.hyc();
      }
      parama1 = parama2.pNh;
      if (parama1 != null)
      {
        parama1 = parama1.getBitmap();
        if ((parama1 == null) || (parama1.isRecycled())) {
          break label261;
        }
        localObject = parama2.pNd;
        if (localObject != null) {
          ((ImageView)localObject).setImageBitmap(parama1);
        }
      }
      for (;;)
      {
        parama1 = parama2.pNd;
        if (parama1 != null) {
          parama1.setVisibility(0);
        }
        parama2.BT(0L);
        parama1 = MPVideoView.h(this.pOr);
        if (parama1 == null) {
          p.hyc();
        }
        parama1.crt();
        parama1 = this.pOr;
        int i = j;
        if (j == 0) {
          i = 1;
        }
        parama1.setInitialTime(i);
        parama1 = this.pOr;
        if (paramgh == null) {
          p.hyc();
        }
        paramgh = paramgh.url;
        p.g(paramgh, "info!!.url");
        parama1.cN(paramgh, this.pOr.getDuration());
        if (!MPVideoView.E(this.pOr))
        {
          paramgh = MPVideoView.h(this.pOr);
          if (paramgh == null) {
            p.hyc();
          }
          paramgh.pause();
        }
        paramgh = MPVideoView.c(this.pOr);
        if (paramgh == null) {
          break label279;
        }
        paramgh.hide();
        AppMethodBeat.o(196022);
        return;
        parama1 = null;
        break;
        label261:
        parama1 = parama2.pNd;
        if (parama1 != null) {
          parama1.setImageResource(2131233974);
        }
      }
      label279:
      AppMethodBeat.o(196022);
    }
    
    public final void crF()
    {
      AppMethodBeat.i(179030);
      MPVideoView.k(this.pOr);
      AppMethodBeat.o(179030);
    }
    
    public final void crG()
    {
      AppMethodBeat.i(179031);
      MPVideoView.k(this.pOr);
      AppMethodBeat.o(179031);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$2", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-brandservice_release"})
  public static final class g
    implements e.d
  {
    public final void aJq()
    {
      AppMethodBeat.i(7488);
      Log.i(MPVideoView.access$getTAG$cp(), "onSeekPre");
      if (this.pOr.isPlaying()) {
        this.pOr.crA();
      }
      MPVideoView.c localc = MPVideoView.k(this.pOr);
      if (localc != null)
      {
        localc.aJq();
        AppMethodBeat.o(7488);
        return;
      }
      AppMethodBeat.o(7488);
    }
    
    public final void rk(int paramInt)
    {
      AppMethodBeat.i(7489);
      MPVideoView.a(this.pOr, paramInt * 1000);
      MPVideoView.m(this.pOr);
      MPVideoView.c localc = MPVideoView.k(this.pOr);
      if (localc != null)
      {
        localc.cqE();
        AppMethodBeat.o(7489);
        return;
      }
      AppMethodBeat.o(7489);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(MPVideoView paramMPVideoView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7490);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = MPVideoView.h(this.pOr);
      if (paramView == null) {
        p.hyc();
      }
      if (paramView.isPlaying()) {
        this.pOr.pause();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7490);
        return;
        this.pOr.start();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$4", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$StatePorter;", "getCacheTime", "", "getTotalTime", "plugin-brandservice_release"})
  public static final class i
    implements e.i
  {
    public final int bJh()
    {
      AppMethodBeat.i(7491);
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.pOr);
      if (localMPExoVideoWrapper == null) {
        p.hyc();
      }
      int i = localMPExoVideoWrapper.getCacheTimeSec();
      AppMethodBeat.o(7491);
      return i;
    }
    
    public final int bJi()
    {
      AppMethodBeat.i(7492);
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.pOr);
      if (localMPExoVideoWrapper == null) {
        p.hyc();
      }
      int i = localMPExoVideoWrapper.getVideoDurationSec();
      AppMethodBeat.o(7492);
      return i;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(MPVideoView paramMPVideoView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7493);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.pOr;
      if (!MPVideoView.B(this.pOr)) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.setMute(bool);
        paramView = m.pLL;
        m.a.DR(34);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7493);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "visible", "", "onVisibilityChanged"})
  static final class l
    implements e.f
  {
    l(MPVideoView paramMPVideoView) {}
    
    public final void onVisibilityChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(7495);
      MPVideoView.A(this.pOr);
      Object localObject1 = MPVideoView.k(this.pOr);
      if (localObject1 != null) {
        ((MPVideoView.c)localObject1).kq(paramBoolean);
      }
      localObject1 = MPVideoView.h(this.pOr);
      if (localObject1 != null)
      {
        Object localObject2;
        if (paramBoolean)
        {
          ((MPExoVideoWrapper)localObject1).pNw = true;
          localObject2 = ((MPExoVideoWrapper)localObject1).pNd;
          if ((localObject2 == null) || (((ImageView)localObject2).getVisibility() != 0))
          {
            localObject2 = ((MPExoVideoWrapper)localObject1).pNe;
            if (localObject2 != null) {
              if (((TextView)localObject2).getVisibility() != 0) {
                break label265;
              }
            }
          }
          else
          {
            Log.i(MPExoVideoWrapper.TAG, "hide switchingResolution onControllerBarVisible");
            if (((MPExoVideoWrapper)localObject1).pNv)
            {
              localObject2 = ((MPExoVideoWrapper)localObject1).pNd;
              if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 0)) {
                ((MPExoVideoWrapper)localObject1).pNu = true;
              }
            }
            localObject2 = ((MPExoVideoWrapper)localObject1).pNd;
            if (localObject2 != null) {
              ((ImageView)localObject2).setVisibility(8);
            }
            localObject1 = ((MPExoVideoWrapper)localObject1).pNe;
            if (localObject1 == null) {
              break label165;
            }
            ((TextView)localObject1).setVisibility(8);
            AppMethodBeat.o(7495);
            return;
          }
          AppMethodBeat.o(7495);
          return;
          label165:
          AppMethodBeat.o(7495);
        }
        else
        {
          ((MPExoVideoWrapper)localObject1).pNw = false;
          if (((MPExoVideoWrapper)localObject1).pNu)
          {
            Log.i(MPExoVideoWrapper.TAG, "show switchingResolution onControllerBarVisible isSwitchingResolution = " + ((MPExoVideoWrapper)localObject1).pNv);
            ((MPExoVideoWrapper)localObject1).pNu = false;
            if (((MPExoVideoWrapper)localObject1).pNv)
            {
              ((MPExoVideoWrapper)localObject1).crp();
              AppMethodBeat.o(7495);
              return;
            }
            localObject2 = ((MPExoVideoWrapper)localObject1).pNd;
            if (localObject2 != null) {
              ((ImageView)localObject2).setVisibility(8);
            }
            localObject2 = ((MPExoVideoWrapper)localObject1).pNe;
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(0);
            }
            ((MPExoVideoWrapper)localObject1).crq();
          }
        }
        label265:
        AppMethodBeat.o(7495);
        return;
      }
      AppMethodBeat.o(7495);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "progressLen", "", "totalLen", "onProgressChanged"})
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
        Object localObject = MPVideoView.C(this.pOr);
        if (localObject == null) {
          p.hyc();
        }
        paramInt1 = i * ((ImageView)localObject).getWidth() / paramInt2;
        localObject = MPVideoView.D(this.pOr);
        if (localObject == null) {
          p.hyc();
        }
        localObject = ((ImageView)localObject).getLayoutParams();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(7496);
          throw ((Throwable)localObject);
        }
        localObject = (FrameLayout.LayoutParams)localObject;
        ((FrameLayout.LayoutParams)localObject).width = paramInt1;
        ImageView localImageView = MPVideoView.D(this.pOr);
        if (localImageView == null) {
          p.hyc();
        }
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = MPVideoView.D(this.pOr);
        if (localObject == null) {
          p.hyc();
        }
        ((ImageView)localObject).requestLayout();
        localObject = MPVideoView.k(this.pOr);
        if (localObject != null)
        {
          ((MPVideoView.c)localObject).cqG();
          AppMethodBeat.o(7496);
          return;
        }
        AppMethodBeat.o(7496);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$9", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$SwitchResolutionListener;", "onHideSwitchResolutionLayout", "", "resolutionBtnClick", "switchResolution", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "beforeType", "", "afterType", "plugin-brandservice_release"})
  public static final class n
    implements MPVideoViewControlBar.a
  {
    public final void a(gh paramgh, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7498);
      Object localObject = MPVideoView.k(this.pOr);
      if (localObject != null) {
        ((MPVideoView.c)localObject).a(paramInt1, paramInt2, paramgh);
      }
      this.pOr.setAutoPlay(this.pOr.isPlaying());
      paramInt1 = this.pOr.getCurrPosMs();
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.pOr);
      if (localMPExoVideoWrapper == null) {
        p.hyc();
      }
      if (paramgh == null) {
        p.hyc();
      }
      String str = paramgh.KKh;
      Log.i(MPExoVideoWrapper.TAG, "onSetResolution %b", new Object[] { Boolean.valueOf(localMPExoVideoWrapper.pNw) });
      localMPExoVideoWrapper.pNv = true;
      localMPExoVideoWrapper.pNg = str;
      localObject = localMPExoVideoWrapper.pNh;
      if (localObject != null)
      {
        localObject = ((MPExoVideoTextureView)localObject).getBitmap();
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label348;
        }
        ImageView localImageView = localMPExoVideoWrapper.pNd;
        if (localImageView != null) {
          localImageView.setImageBitmap((Bitmap)localObject);
        }
        label169:
        localObject = localMPExoVideoWrapper.pNe;
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)localMPExoVideoWrapper.getContext().getString(2131763177, new Object[] { str }));
        }
        localMPExoVideoWrapper.crp();
        localMPExoVideoWrapper.BT(0L);
        localObject = MPVideoView.h(this.pOr);
        if (localObject == null) {
          p.hyc();
        }
        ((MPExoVideoWrapper)localObject).crt();
        localObject = this.pOr;
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
        localObject = this.pOr;
        paramgh = paramgh.url;
        p.g(paramgh, "info!!.url");
        ((MPVideoView)localObject).cN(paramgh, this.pOr.getDuration());
        if (!MPVideoView.E(this.pOr))
        {
          paramgh = MPVideoView.h(this.pOr);
          if (paramgh == null) {
            p.hyc();
          }
          paramgh.pause();
        }
        paramgh = MPVideoView.c(this.pOr);
        if (paramgh == null) {
          break label373;
        }
        paramgh.hide();
        AppMethodBeat.o(7498);
        return;
        localObject = null;
        break;
        localObject = localMPExoVideoWrapper.pNd;
        if (localObject == null) {
          break label169;
        }
        ((ImageView)localObject).setImageResource(2131233974);
        break label169;
      }
      label373:
      AppMethodBeat.o(7498);
    }
    
    public final void cqH()
    {
      AppMethodBeat.i(7499);
      MPVideoView.c localc = MPVideoView.k(this.pOr);
      if (localc != null)
      {
        localc.cqH();
        AppMethodBeat.o(7499);
        return;
      }
      AppMethodBeat.o(7499);
    }
    
    public final void cqI()
    {
      AppMethodBeat.i(7497);
      MPVideoView.c localc = MPVideoView.k(this.pOr);
      if (localc != null)
      {
        localc.cqI();
        AppMethodBeat.o(7497);
        return;
      }
      AppMethodBeat.o(7497);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initGestureController$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$GestureOperationHelper;", "canAdjustBrightness", "", "canAdjustProgress", "canAdjustVolume", "getCurrentPosition", "", "onAdjustBrightness", "", "brightness", "", "onAdjustVolume", "volumePercent", "onCanHandleGesture", "onDoubleTap", "onDragProgress", "startDragPos", "distanceX", "onEndAdjustBrightness", "onEndAdjustVolume", "onEndDragProgress", "dragPosition", "totalDistanceX", "onSingleTap", "onStartDragProgress", "plugin-brandservice_release"})
  public static final class o
    implements a.b
  {
    public final void aM(float paramFloat)
    {
      AppMethodBeat.i(7506);
      if (!MPVideoView.r(this.pOr))
      {
        AppMethodBeat.o(7506);
        return;
      }
      Log.d(MPVideoView.access$getTAG$cp(), "onAdjustVolume:".concat(String.valueOf(paramFloat)));
      Object localObject = MPVideoView.n(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      ((AppBrandDotPercentIndicator)localObject).setPercent(paramFloat);
      localObject = MPVideoView.o(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      ((TextView)localObject).setText(2131762775);
      localObject = MPVideoView.p(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      ((ImageView)localObject).setImageResource(2131231074);
      localObject = MPVideoView.q(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      ((LinearLayout)localObject).setVisibility(0);
      MPVideoView.f(this.pOr);
      AppMethodBeat.o(7506);
    }
    
    public final void aN(float paramFloat)
    {
      AppMethodBeat.i(7507);
      if (!MPVideoView.r(this.pOr))
      {
        AppMethodBeat.o(7507);
        return;
      }
      Log.d(MPVideoView.access$getTAG$cp(), "onAdjustBrightness:".concat(String.valueOf(paramFloat)));
      Object localObject = MPVideoView.n(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      ((AppBrandDotPercentIndicator)localObject).setPercent(paramFloat);
      localObject = MPVideoView.o(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      ((TextView)localObject).setText(2131762774);
      localObject = MPVideoView.p(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      ((ImageView)localObject).setImageResource(2131231066);
      localObject = MPVideoView.q(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      ((LinearLayout)localObject).setVisibility(0);
      MPVideoView.f(this.pOr);
      AppMethodBeat.o(7507);
    }
    
    public final void bJj()
    {
      AppMethodBeat.i(7500);
      Log.d(MPVideoView.access$getTAG$cp(), "onSingleTap");
      if ((MPVideoView.a(this.pOr)) && (!MPVideoView.b(this.pOr)))
      {
        localObject = MPVideoView.c(this.pOr);
        if (localObject == null) {
          p.hyc();
        }
        ((MPVideoViewControlBar)localObject).bJu();
      }
      Object localObject = MPVideoView.d(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      if ((((View)localObject).getVisibility() != 0) && (MPVideoView.e(this.pOr))) {
        MPVideoView.f(this.pOr);
      }
      AppMethodBeat.o(7500);
    }
    
    public final void bJk()
    {
      AppMethodBeat.i(7501);
      Log.d(MPVideoView.access$getTAG$cp(), "onDoubleTap");
      if (MPVideoView.g(this.pOr))
      {
        Object localObject = MPVideoView.h(this.pOr);
        if (localObject == null) {
          p.hyc();
        }
        if (((MPExoVideoWrapper)localObject).isPlaying())
        {
          this.pOr.pause();
          localObject = m.pLL;
          m.a.DR(35);
          AppMethodBeat.o(7501);
          return;
        }
        this.pOr.start();
        localObject = m.pLL;
        m.a.DR(36);
      }
      AppMethodBeat.o(7501);
    }
    
    public final void bJl()
    {
      AppMethodBeat.i(7502);
      if (!MPVideoView.i(this.pOr))
      {
        AppMethodBeat.o(7502);
        return;
      }
      Object localObject = MPVideoView.j(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      ((TextView)localObject).setVisibility(0);
      MPVideoView.f(this.pOr);
      if (this.pOr.isPlaying()) {
        this.pOr.crA();
      }
      localObject = MPVideoView.k(this.pOr);
      if (localObject != null)
      {
        ((MPVideoView.c)localObject).bJl();
        AppMethodBeat.o(7502);
        return;
      }
      AppMethodBeat.o(7502);
    }
    
    public final void bJm()
    {
      AppMethodBeat.i(7508);
      if (!MPVideoView.r(this.pOr))
      {
        AppMethodBeat.o(7508);
        return;
      }
      Object localObject = MPVideoView.q(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      ((LinearLayout)localObject).setVisibility(8);
      MPVideoView.l(this.pOr);
      localObject = m.pLL;
      m.a.DR(41);
      AppMethodBeat.o(7508);
    }
    
    public final void bJn()
    {
      AppMethodBeat.i(7509);
      if (!MPVideoView.r(this.pOr))
      {
        AppMethodBeat.o(7509);
        return;
      }
      Object localObject = MPVideoView.q(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      ((LinearLayout)localObject).setVisibility(8);
      MPVideoView.l(this.pOr);
      localObject = m.pLL;
      m.a.DR(39);
      AppMethodBeat.o(7509);
    }
    
    public final boolean bJo()
    {
      AppMethodBeat.i(258335);
      boolean bool = MPVideoView.r(this.pOr);
      AppMethodBeat.o(258335);
      return bool;
    }
    
    public final boolean bJp()
    {
      AppMethodBeat.i(258336);
      boolean bool = MPVideoView.r(this.pOr);
      AppMethodBeat.o(258336);
      return bool;
    }
    
    public final boolean bJq()
    {
      AppMethodBeat.i(7512);
      boolean bool = MPVideoView.i(this.pOr);
      AppMethodBeat.o(7512);
      return bool;
    }
    
    public final int getCurrentPosition()
    {
      AppMethodBeat.i(7505);
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.pOr);
      if (localMPExoVideoWrapper == null) {
        p.hyc();
      }
      int i = localMPExoVideoWrapper.getCurrPosSec();
      AppMethodBeat.o(7505);
      return i;
    }
    
    public final int k(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(7503);
      if (!MPVideoView.i(this.pOr))
      {
        AppMethodBeat.o(7503);
        return 0;
      }
      Log.i(MPVideoView.access$getTAG$cp(), "onDragProgress:" + paramInt + '/' + paramFloat);
      Object localObject = MPVideoView.h(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      paramInt = ((MPExoVideoWrapper)localObject).getVideoDurationSec();
      int i = com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a.c(paramFloat, this.pOr.getMeasuredWidth(), getCurrentPosition(), paramInt);
      localObject = com.tencent.mm.plugin.appbrand.jsapi.video.l.AF(paramInt * 1000L);
      TextView localTextView = MPVideoView.j(this.pOr);
      if (localTextView == null) {
        p.hyc();
      }
      localTextView.setText((CharSequence)(com.tencent.mm.plugin.appbrand.jsapi.video.l.AF(i * 1000L) + "/" + (String)localObject));
      localObject = MPVideoView.c(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      ((MPVideoViewControlBar)localObject).seek(i);
      localObject = MPVideoView.c(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      if (((MPVideoViewControlBar)localObject).bJw())
      {
        localObject = MPVideoView.c(this.pOr);
        if (localObject == null) {
          p.hyc();
        }
        ((MPVideoViewControlBar)localObject).bJB();
      }
      AppMethodBeat.o(7503);
      return i;
    }
    
    public final void l(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(7504);
      if (!MPVideoView.i(this.pOr))
      {
        AppMethodBeat.o(7504);
        return;
      }
      Object localObject = MPVideoView.j(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      ((TextView)localObject).setVisibility(8);
      MPVideoView.l(this.pOr);
      localObject = MPVideoView.h(this.pOr);
      if (localObject == null) {
        p.hyc();
      }
      int i = ((MPExoVideoWrapper)localObject).getCurrPosSec();
      Log.i(MPVideoView.access$getTAG$cp(), "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Float.valueOf(paramFloat) });
      MPVideoView.a(this.pOr, paramInt * 1000);
      MPVideoView.m(this.pOr);
      localObject = MPVideoView.k(this.pOr);
      if (localObject != null)
      {
        ((MPVideoView.c)localObject).cqD();
        AppMethodBeat.o(7504);
        return;
      }
      AppMethodBeat.o(7504);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initVideoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-brandservice_release"})
  public static final class p
    implements i.b
  {
    public final void c(String paramString1, String paramString2, final String paramString3, final int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7521);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      p.h(paramString3, "errorMsg");
      Log.i(MPVideoView.access$getTAG$cp(), "onError errorMsg=%s what=%d extra=%d", new Object[] { paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      MMHandlerThread.postToMainThread((Runnable)new a(this, paramString3, paramInt1));
      AppMethodBeat.o(7521);
    }
    
    public final void d(String paramString1, String paramString2, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(7524);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      this.pOr.setVideoWidth(paramInt1);
      this.pOr.setVideoHeight(paramInt2);
      paramString1 = MPVideoView.k(this.pOr);
      if (paramString1 != null) {
        paramString1.cqC();
      }
      MMHandlerThread.postToMainThread((Runnable)new b(this, paramInt1, paramInt2));
      AppMethodBeat.o(7524);
    }
    
    public final void dH(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7522);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      Log.i(MPVideoView.access$getTAG$cp(), "onPrepared");
      MMHandlerThread.postToMainThread((Runnable)new c(this));
      AppMethodBeat.o(7522);
    }
    
    public final void dI(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7523);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      Log.i(MPVideoView.access$getTAG$cp(), "onVideoEnded");
      MMHandlerThread.postToMainThread((Runnable)new d(this));
      AppMethodBeat.o(7523);
    }
    
    public final void dJ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7525);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      Log.i(MPVideoView.access$getTAG$cp(), "onVideoPause");
      this.pOr.crA();
      paramString1 = MPVideoView.k(this.pOr);
      if (paramString1 != null) {
        paramString1.onVideoPause();
      }
      if (this.pOr.getPlayStatus() != 4) {
        this.pOr.setPlayStatus(3);
      }
      paramString1 = MPVideoView.h(this.pOr);
      if (paramString1 == null) {
        p.hyc();
      }
      paramString1 = paramString1.pNe;
      if (paramString1 == null) {
        p.hyc();
      }
      if (paramString1.getVisibility() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        MMHandlerThread.postToMainThreadDelayed((Runnable)new e(this), 1000L);
        AppMethodBeat.o(7525);
        return;
      }
      this.pOr.crC();
      AppMethodBeat.o(7525);
    }
    
    public final void dK(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7526);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      MMHandlerThread.postToMainThread((Runnable)new f(this));
      AppMethodBeat.o(7526);
    }
    
    public final void dL(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7527);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      Log.i(MPVideoView.access$getTAG$cp(), "onVideoWaiting");
      MMHandlerThread.postToMainThread((Runnable)new g(this));
      AppMethodBeat.o(7527);
    }
    
    public final void dM(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7528);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      MMHandlerThread.postToMainThread((Runnable)new h(this));
      AppMethodBeat.o(7528);
    }
    
    public final void fo(String paramString1, String paramString2)
    {
      AppMethodBeat.i(196025);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      AppMethodBeat.o(196025);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoView.p paramp, String paramString, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(7513);
        this.pOs.pOr.crA();
        MPVideoView.c localc = MPVideoView.k(this.pOs.pOr);
        if (localc != null) {
          localc.aiG(paramString3);
        }
        this.pOs.pOr.setPlayStatus(4);
        AppMethodBeat.o(7513);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(MPVideoView.p paramp, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(7514);
        int i = MPVideoView.y(this.pOs.pOr);
        Object localObject = MPVideoView.pOq;
        if (i == MPVideoView.crE())
        {
          localObject = this.pOs.pOr;
          if (paramInt1 >= paramInt2) {
            break label89;
          }
        }
        label89:
        for (i = 0;; i = 90)
        {
          MPVideoView.b((MPVideoView)localObject, i);
          Log.i(MPVideoView.access$getTAG$cp(), "onGetVideoSize adjust direction from AUTO to %s", new Object[] { Integer.valueOf(MPVideoView.y(this.pOs.pOr)) });
          AppMethodBeat.o(7514);
          return;
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7515);
        Object localObject = MPVideoView.k(this.pOs.pOr);
        MPExoVideoWrapper localMPExoVideoWrapper;
        if (localObject != null)
        {
          localMPExoVideoWrapper = MPVideoView.h(this.pOs.pOr);
          if (localMPExoVideoWrapper == null) {
            break label80;
          }
        }
        label80:
        for (long l = localMPExoVideoWrapper.getFirstRenderTime();; l = 0L)
        {
          ((MPVideoView.c)localObject).BL(l);
          localObject = MPVideoView.s(this.pOs.pOr);
          if (localObject == null) {
            p.hyc();
          }
          ((com.tencent.mm.plugin.appbrand.jsapi.video.ui.a)localObject).bKZ();
          AppMethodBeat.o(7515);
          return;
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class d
      implements Runnable
    {
      d(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7516);
        this.pOs.pOr.crA();
        Object localObject = MPVideoView.j(this.pOs.pOr);
        if (localObject == null) {
          p.hyc();
        }
        ((TextView)localObject).setVisibility(8);
        if (MPVideoView.b(this.pOs.pOr))
        {
          localObject = MPVideoView.d(this.pOs.pOr);
          if (localObject == null) {
            p.hyc();
          }
          ((View)localObject).setVisibility(0);
          localObject = MPVideoView.c(this.pOs.pOr);
          if (localObject == null) {
            p.hyc();
          }
          if (((MPVideoViewControlBar)localObject).bJw())
          {
            localObject = MPVideoView.c(this.pOs.pOr);
            if (localObject == null) {
              p.hyc();
            }
            ((MPVideoViewControlBar)localObject).hide();
          }
          localObject = MPVideoView.t(this.pOs.pOr);
          if (localObject == null) {
            p.hyc();
          }
          if (((FrameLayout)localObject).getVisibility() == 0)
          {
            localObject = MPVideoView.t(this.pOs.pOr);
            if (localObject == null) {
              p.hyc();
            }
            ((FrameLayout)localObject).setVisibility(8);
          }
          if ((!MPVideoView.u(this.pOs.pOr)) && (MPVideoView.b(this.pOs.pOr))) {
            break label318;
          }
          localObject = MPVideoView.v(this.pOs.pOr);
          if (localObject == null) {
            p.hyc();
          }
          ((View)localObject).setVisibility(8);
        }
        for (;;)
        {
          this.pOs.pOr.crr();
          this.pOs.pOr.setPlayStatus(4);
          localObject = MPVideoView.k(this.pOs.pOr);
          if (localObject == null) {
            break label407;
          }
          ((MPVideoView.c)localObject).onVideoEnded();
          AppMethodBeat.o(7516);
          return;
          localObject = MPVideoView.c(this.pOs.pOr);
          if (localObject == null) {
            p.hyc();
          }
          ((MPVideoViewControlBar)localObject).crH();
          localObject = MPVideoView.c(this.pOs.pOr);
          if (localObject == null) {
            p.hyc();
          }
          ((MPVideoViewControlBar)localObject).show();
          break;
          label318:
          if (MPVideoView.w(this.pOs.pOr) <= 0)
          {
            localObject = MPVideoView.x(this.pOs.pOr);
            if (localObject == null) {
              p.hyc();
            }
            MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.pOs.pOr);
            if (localMPExoVideoWrapper == null) {
              p.hyc();
            }
            ((TextView)localObject).setText((CharSequence)MPVideoView.DZ(localMPExoVideoWrapper.getVideoDurationSec()));
          }
          localObject = MPVideoView.v(this.pOs.pOr);
          if (localObject == null) {
            p.hyc();
          }
          ((View)localObject).setVisibility(0);
        }
        label407:
        AppMethodBeat.o(7516);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class e
      implements Runnable
    {
      e(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7517);
        this.pOs.pOr.crC();
        AppMethodBeat.o(7517);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class f
      implements Runnable
    {
      f(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7518);
        Log.i(MPVideoView.access$getTAG$cp(), "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(MPVideoView.u(this.pOs.pOr)) });
        MPVideoView.z(this.pOs.pOr);
        this.pOs.pOr.crs();
        Object localObject = MPVideoView.k(this.pOs.pOr);
        if (localObject != null) {
          ((MPVideoView.c)localObject).onVideoPlay();
        }
        if ((MPVideoView.w(this.pOs.pOr) <= 0) && (!MPVideoView.u(this.pOs.pOr)))
        {
          localObject = MPVideoView.x(this.pOs.pOr);
          if (localObject == null) {
            p.hyc();
          }
          MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.pOs.pOr);
          if (localMPExoVideoWrapper == null) {
            p.hyc();
          }
          ((TextView)localObject).setText((CharSequence)MPVideoView.DZ(localMPExoVideoWrapper.getVideoDurationSec()));
        }
        MPVideoView.b(this.pOs.pOr, MPVideoView.u(this.pOs.pOr));
        if (MPVideoView.a(this.pOs.pOr)) {
          MPVideoView.A(this.pOs.pOr);
        }
        MPVideoView.m(this.pOs.pOr);
        this.pOs.pOr.setPlayStatus(2);
        localObject = MPVideoView.c(this.pOs.pOr);
        if (localObject == null) {
          p.hyc();
        }
        if (((MPVideoViewControlBar)localObject).bJw())
        {
          localObject = MPVideoView.c(this.pOs.pOr);
          if (localObject == null) {
            p.hyc();
          }
          ((MPVideoViewControlBar)localObject).bJB();
        }
        AppMethodBeat.o(7518);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class g
      implements Runnable
    {
      g(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7519);
        MPVideoView.a(this.pOs.pOr, true);
        MPVideoView.f(this.pOs.pOr);
        MPVideoView.c localc = MPVideoView.k(this.pOs.pOr);
        if (localc != null)
        {
          localc.onVideoWaiting();
          AppMethodBeat.o(7519);
          return;
        }
        AppMethodBeat.o(7519);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class h
      implements Runnable
    {
      h(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7520);
        MPVideoView.a(this.pOs.pOr, false);
        MPVideoView.l(this.pOs.pOr);
        MPVideoView.c localc = MPVideoView.k(this.pOs.pOr);
        if (localc != null)
        {
          localc.cqF();
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