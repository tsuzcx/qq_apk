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
import com.tencent.mm.ah.x;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.r;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.a;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.protocal.protobuf.fp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.n.n;
import d.v;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroudContainerLayout", "Landroid/widget/FrameLayout;", "getBackgroudContainerLayout", "()Landroid/widget/FrameLayout;", "setBackgroudContainerLayout", "(Landroid/widget/FrameLayout;)V", "cacheTimeSec", "getCacheTimeSec", "()I", "currPosMs", "getCurrPosMs", "currPosSec", "getCurrPosSec", "dotContainerLayout", "getDotContainerLayout", "setDotContainerLayout", "duration", "getDuration", "setDuration", "(I)V", "endPlayTime", "getEndPlayTime", "hasDownInTouchEvent", "", "hasRealPlayTime", "isCoverVisible", "()Z", "isInFullScreen", "isLive", "mAdjustContentTv", "Landroid/widget/TextView;", "mAdjustIconIv", "Landroid/widget/ImageView;", "mAdjustInfoLayout", "Landroid/widget/LinearLayout;", "mAdjustPercentIndicator", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/AppBrandDotPercentIndicator;", "mAutoPlay", "mBottomProgressBackBar", "mBottomProgressFrontBar", "mBottomProgressLayout", "mConsumeTouchEvent", "mControlBar", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar;", "mCoverArea", "Landroid/view/View;", "mCoverPlayBtnArea", "mCoverTotalTimeTv", "mCoverUrl", "", "mDirection", "mDuration", "mEnablePlayGesture", "mEnableProgressGesture", "mFullScreenDelegate", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "mGestureController", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController;", "mInitialTime", "mIsAlive", "mIsLoading", "mIsMute", "mIsShowBasicControls", "mLoop", "mMPVideoViewCallBack", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "mPageGesture", "mPageGestureInFullscreen", "mPlayStart", "mPlayStarted", "mProgressTv", "mRealPlayTime", "", "mSetIsShowCoverPlayBtn", "mSetIsShowProgressBar", "mSkipAutoPause", "mStartPlayTime", "mVideoSource", "mVideoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper;", "needHandleTouchEvent", "getNeedHandleTouchEvent", "setNeedHandleTouchEvent", "(Z)V", "playStatus", "getPlayStatus", "setPlayStatus", "playerAdContainerLayout", "getPlayerAdContainerLayout", "setPlayerAdContainerLayout", "realPlayTime", "getRealPlayTime", "()J", "videoHeight", "getVideoHeight", "setVideoHeight", "<set-?>", "videoPath", "getVideoPath", "()Ljava/lang/String;", "videoWidth", "getVideoWidth", "setVideoWidth", "canAdjustBrightnessVolume", "canDragProgress", "clean", "", "doOnTouchEvent", "event", "Landroid/view/MotionEvent;", "downloadVideo", "videoUrl", "enableProgressGesture", "enable", "getAutoPlay", "getPlayStart", "getPlayStarted", "getTimeShowString", "time", "hideCenterPlayBtnIfNeed", "hideCover", "init", "initControlBar", "initGestureController", "initParam", "initVideoViewCallback", "isControlBarShow", "isPlaying", "makeTimeString", "d", "onExitFullScreen", "onTouchEvent", "onUIDestroy", "onUIPause", "onUIResume", "operateFullScreen", "toFullScreen", "direction", "pause", "seekTo", "position", "afterPlay", "setAutoPlay", "autoPlay", "setBizInfo", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "iconUrl", "setConsumeTouchEvent", "value", "setCoverByUrl", "cover", "coverUrl", "width", "height", "setEnablePlayGesture", "enablePlayGesture", "setExoPlayerParam", "maxInitialBitrate", "bandwidthFraction", "", "minDurForQualityMs", "maxDurForQualityMs", "minBufferMs", "maxBufferMs", "setFullScreenDelegate", "delegate", "setFullScreenDirection", "setInitialTime", "initialTime", "setIsShowBasicControls", "isShowBasicControls", "setLoop", "loop", "setMPVideoViewCallBack", "setMute", "isMute", "setObjectFit", "setPageGesture", "pageGesture", "setPageGestureInFullscreen", "pageGestureInFullscreen", "setPlayBtnOnClickListener", "click", "Landroid/view/View$OnClickListener;", "setPlayBtnPosition", "playBtnPosition", "setPreLoadVidePath", "setShowCenterPlayBtn", "showCenterPlayBtn", "setShowControlProgress", "showControlProgress", "setShowFullScreenBtn", "showFullScreenBtn", "setShowMuteBtn", "showMuteBtn", "setShowPlayBtn", "showPlayBtn", "setShowProgress", "showProgress", "setTitle", "title", "setVideoPath", "durationSec", "setVideoSource", "videoSource", "setVideoUrlInfo", "urlInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "currentInfo", "shouldDispatchEventToGestureController", "shouldHandleTouchEvent", "v", "e", "showCenterPlayBtnIfNeed", "showControlBar", "showCover", "start", "startWhenNetWorkConnect", "stop", "updateBottomProgressLayout", "updateControlBarDotPos", "list", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "updateLiveUI", "updateRealPlayTime", "updateStartTime", "Companion", "FullScreenDelegate", "MPVideoViewCallBack", "plugin-brandservice_release"})
public final class MPVideoView
  extends RelativeLayout
{
  public static final String TAG = "MicroMsg.MPVideoView";
  private static final int nRv = -1;
  private static final int nRw = 8;
  public static final MPVideoView.a nRx;
  private int abb;
  private int asf;
  private boolean chR;
  private int hYu;
  private boolean kOA;
  private boolean kOB;
  private String kOD;
  private boolean kOE;
  private boolean kOF;
  private boolean kOG;
  private boolean kOI;
  private int kOJ;
  private boolean kOL;
  private boolean kOM;
  public boolean kON;
  private TextView kOd;
  private View kOg;
  private View kOh;
  private TextView kOi;
  private LinearLayout kOj;
  private AppBrandDotPercentIndicator kOk;
  private TextView kOl;
  private ImageView kOm;
  private ImageView kOo;
  private ImageView kOp;
  private FrameLayout kOq;
  private boolean kOu;
  private boolean kOw;
  private boolean kOx;
  private com.tencent.mm.plugin.appbrand.jsapi.video.ui.a kOy;
  private boolean mIsMute;
  public MPExoVideoWrapper nRg;
  public MPVideoViewControlBar nRh;
  private FrameLayout nRi;
  private FrameLayout nRj;
  private FrameLayout nRk;
  private boolean nRl;
  private boolean nRm;
  private b nRn;
  private c nRo;
  private int nRp;
  private long nRq;
  private long nRr;
  private boolean nRs;
  public boolean nRt;
  public boolean nRu;
  private int videoHeight;
  private String videoPath;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(7587);
    nRx = new MPVideoView.a((byte)0);
    TAG = "MicroMsg.MPVideoView";
    nRv = -1;
    nRw = 8;
    AppMethodBeat.o(7587);
  }
  
  public MPVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(7584);
    this.abb = nRv;
    init(paramContext);
    AppMethodBeat.o(7584);
  }
  
  public MPVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7585);
    this.abb = nRv;
    init(paramContext);
    AppMethodBeat.o(7585);
  }
  
  public MPVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(7586);
    this.abb = nRv;
    init(paramContext);
    AppMethodBeat.o(7586);
  }
  
  private final boolean bOa()
  {
    AppMethodBeat.i(175553);
    if (this.kOM)
    {
      AppMethodBeat.o(175553);
      return true;
    }
    boolean bool = bjd();
    if (!bje())
    {
      AppMethodBeat.o(175553);
      return false;
    }
    AppMethodBeat.o(175553);
    return bool;
  }
  
  private final boolean bed()
  {
    AppMethodBeat.i(7537);
    Object localObject = TAG;
    boolean bool = this.kOA;
    MPExoVideoWrapper localMPExoVideoWrapper = this.nRg;
    if (localMPExoVideoWrapper == null) {
      k.fOy();
    }
    ac.i((String)localObject, "isLive %b %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localMPExoVideoWrapper.bps) });
    if (!this.kOA)
    {
      localObject = this.nRg;
      if (localObject == null) {
        k.fOy();
      }
      if (!((MPExoVideoWrapper)localObject).bps) {}
    }
    else
    {
      AppMethodBeat.o(7537);
      return true;
    }
    AppMethodBeat.o(7537);
    return false;
  }
  
  private final void biZ()
  {
    AppMethodBeat.i(7574);
    MPVideoViewControlBar localMPVideoViewControlBar = this.nRh;
    if (localMPVideoViewControlBar == null) {
      k.fOy();
    }
    localMPVideoViewControlBar.biZ();
    AppMethodBeat.o(7574);
  }
  
  private final boolean bjd()
  {
    AppMethodBeat.i(7582);
    if (this.kOF)
    {
      MPExoVideoWrapper localMPExoVideoWrapper = this.nRg;
      if (localMPExoVideoWrapper == null) {
        k.fOy();
      }
      if ((!localMPExoVideoWrapper.bps) && (!bjf()))
      {
        AppMethodBeat.o(7582);
        return true;
      }
    }
    AppMethodBeat.o(7582);
    return false;
  }
  
  private final boolean bje()
  {
    AppMethodBeat.i(7583);
    if ((!bjf()) && (((!bjb()) && (this.kOw)) || ((bjb()) && (this.kOx))))
    {
      AppMethodBeat.o(7583);
      return true;
    }
    AppMethodBeat.o(7583);
    return false;
  }
  
  private final boolean bjf()
  {
    AppMethodBeat.i(7538);
    View localView = this.kOg;
    if (localView == null) {
      k.fOy();
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
    ac.i(TAG, "clean");
    stop();
    Object localObject = this.nRg;
    if (localObject == null) {
      k.fOy();
    }
    ((MPExoVideoWrapper)localObject).onUIDestroy();
    localObject = this.nRh;
    if (localObject == null) {
      k.fOy();
    }
    ((MPVideoViewControlBar)localObject).onDestroy();
    AppMethodBeat.o(7555);
  }
  
  private final void init(Context paramContext)
  {
    AppMethodBeat.i(7539);
    LayoutInflater.from(paramContext).inflate(2131494957, (ViewGroup)this);
    this.nRg = ((MPExoVideoWrapper)findViewById(2131306410));
    paramContext = findViewById(2131303515);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kOd = ((TextView)paramContext);
    this.kOg = findViewById(2131298814);
    this.kOh = findViewById(2131298828);
    paramContext = findViewById(2131298832);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kOi = ((TextView)paramContext);
    paramContext = findViewById(2131296505);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kOj = ((LinearLayout)paramContext);
    paramContext = findViewById(2131296506);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kOk = ((AppBrandDotPercentIndicator)paramContext);
    paramContext = findViewById(2131296502);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kOl = ((TextView)paramContext);
    paramContext = findViewById(2131296504);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kOm = ((ImageView)paramContext);
    paramContext = findViewById(2131303297);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kOo = ((ImageView)paramContext);
    paramContext = findViewById(2131303296);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kOp = ((ImageView)paramContext);
    paramContext = findViewById(2131303298);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.kOq = ((FrameLayout)paramContext);
    paramContext = findViewById(2131303293);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.nRi = ((FrameLayout)paramContext);
    paramContext = findViewById(2131303299);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.nRj = ((FrameLayout)paramContext);
    paramContext = findViewById(2131303294);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.nRk = ((FrameLayout)paramContext);
    paramContext = this.kOk;
    if (paramContext == null) {
      k.fOy();
    }
    paramContext.setDotsNum(nRw);
    paramContext = findViewById(2131298827);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    ((ImageView)paramContext).setOnClickListener((View.OnClickListener)new MPVideoView.d(this));
    this.kOy = new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a(getContext(), (View)this, (a.b)new o(this));
    paramContext = this.nRg;
    if (paramContext == null) {
      k.fOy();
    }
    paramContext.setIMMVideoViewCallback((h.b)new p(this));
    this.nRh = new MPVideoViewControlBar(getContext());
    paramContext = this.nRg;
    if (paramContext == null) {
      k.fOy();
    }
    MPVideoViewControlBar localMPVideoViewControlBar = this.nRh;
    if (localMPVideoViewControlBar == null) {
      k.fOy();
    }
    paramContext.setVideoFooterView((g)localMPVideoViewControlBar);
    paramContext = this.nRh;
    if (paramContext == null) {
      k.fOy();
    }
    paramContext.hide();
    paramContext = this.nRh;
    if (paramContext == null) {
      k.fOy();
    }
    paramContext.setFullScreenBtnOnClickListener((View.OnClickListener)new MPVideoView.e(this));
    paramContext = this.nRh;
    if (paramContext == null) {
      k.fOy();
    }
    paramContext.setIplaySeekCallback((e.d)new g(this));
    paramContext = this.nRh;
    if (paramContext == null) {
      k.fOy();
    }
    paramContext.setOnPlayButtonClickListener((View.OnClickListener)new MPVideoView.h(this));
    paramContext = this.nRh;
    if (paramContext == null) {
      k.fOy();
    }
    paramContext.setStatePorter((e.i)new i(this));
    paramContext = this.nRh;
    if (paramContext == null) {
      k.fOy();
    }
    paramContext.setMuteBtnOnClickListener((View.OnClickListener)new MPVideoView.j(this));
    paramContext = this.nRh;
    if (paramContext == null) {
      k.fOy();
    }
    paramContext.setExitFullScreenBtnOnClickListener((View.OnClickListener)new MPVideoView.k(this));
    paramContext = this.nRh;
    if (paramContext == null) {
      k.fOy();
    }
    paramContext.a((e.f)new l(this));
    paramContext = this.nRh;
    if (paramContext == null) {
      k.fOy();
    }
    paramContext.setOnUpdateProgressLenListener((e.e)new m(this));
    paramContext = this.nRh;
    if (paramContext == null) {
      k.fOy();
    }
    paramContext.setSwitchResolutionListener((MPVideoViewControlBar.a)new n(this));
    paramContext = this.nRh;
    if (paramContext == null) {
      k.fOy();
    }
    paramContext.setSwitchSpeedListener((MPVideoViewControlBar.b)new f(this));
    paramContext = this.nRg;
    if (paramContext == null) {
      k.fOy();
    }
    paramContext = paramContext.getCoverIv();
    if (paramContext == null) {
      k.fOy();
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
    ac.i(TAG, "enableProgressGesture %b", new Object[] { Boolean.TRUE });
    this.kOF = true;
    setVideoSource(0);
    setConsumeTouchEvent(false);
    setIsShowBasicControls(true);
    AppMethodBeat.o(7539);
  }
  
  private static String sN(int paramInt)
  {
    AppMethodBeat.i(7580);
    String str = sO(paramInt / 60) + ":" + sO(paramInt % 60);
    AppMethodBeat.o(7580);
    return str;
  }
  
  private static String sO(int paramInt)
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
    k.h(paramMotionEvent, "event");
    if (bOa())
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.ui.a locala = this.kOy;
      if (locala != null) {
        locala.y(paramMotionEvent);
      }
      AppMethodBeat.o(175552);
      return true;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if ((this.kOu) && (!this.kOI))
      {
        paramMotionEvent = this.nRh;
        if (paramMotionEvent == null) {
          k.fOy();
        }
        paramMotionEvent.bju();
      }
      paramMotionEvent = this.kOg;
      if (paramMotionEvent == null) {
        k.fOy();
      }
      if ((paramMotionEvent.getVisibility() != 0) && (this.kOL)) {
        biZ();
      }
    }
    boolean bool = this.kOE;
    AppMethodBeat.o(175552);
    return bool;
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(175550);
    MPExoVideoWrapper localMPExoVideoWrapper = this.nRg;
    if (localMPExoVideoWrapper == null) {
      k.fOy();
    }
    localMPExoVideoWrapper.a(paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(175550);
  }
  
  public final void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, x paramx)
  {
    AppMethodBeat.i(7559);
    k.h(paramx, "msgInfo");
    ac.i(TAG, "setCover coverUrl=%s", new Object[] { paramString });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7559);
      return;
    }
    this.kOD = paramString;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l locall = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.nOS;
    if (paramString == null) {
      k.fOy();
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(paramImageView, paramString, paramInt1, paramInt2, paramx);
    AppMethodBeat.o(7559);
  }
  
  public final void a(LinkedList<fp> paramLinkedList, fp paramfp)
  {
    AppMethodBeat.i(175551);
    k.h(paramLinkedList, "urlInfoList");
    k.h(paramfp, "currentInfo");
    MPVideoViewControlBar localMPVideoViewControlBar = this.nRh;
    if (localMPVideoViewControlBar == null) {
      k.fOy();
    }
    localMPVideoViewControlBar.a(paramLinkedList, paramfp);
    AppMethodBeat.o(175551);
  }
  
  public final void bNR()
  {
    AppMethodBeat.i(7561);
    MPExoVideoWrapper localMPExoVideoWrapper = this.nRg;
    if (localMPExoVideoWrapper == null) {
      k.fOy();
    }
    localMPExoVideoWrapper.bNR();
    AppMethodBeat.o(7561);
  }
  
  public final void bNS()
  {
    AppMethodBeat.i(7562);
    MPExoVideoWrapper localMPExoVideoWrapper = this.nRg;
    if (localMPExoVideoWrapper == null) {
      k.fOy();
    }
    localMPExoVideoWrapper.bNS();
    AppMethodBeat.o(7562);
  }
  
  public final void bNZ()
  {
    long l1 = 0L;
    AppMethodBeat.i(199196);
    long l2 = System.currentTimeMillis();
    long l3 = this.nRq;
    if (this.nRr != 0L) {
      l1 = l2 - this.nRr;
    }
    this.nRq = (l1 + l3);
    this.nRr = l2;
    this.nRs = true;
    AppMethodBeat.o(199196);
  }
  
  public final void bOb()
  {
    AppMethodBeat.i(7578);
    MPVideoViewControlBar localMPVideoViewControlBar = this.nRh;
    if (localMPVideoViewControlBar != null) {
      localMPVideoViewControlBar.bOg();
    }
    localMPVideoViewControlBar = this.nRh;
    if (localMPVideoViewControlBar != null)
    {
      localMPVideoViewControlBar.show();
      AppMethodBeat.o(7578);
      return;
    }
    AppMethodBeat.o(7578);
  }
  
  public final boolean bOc()
  {
    AppMethodBeat.i(7579);
    MPVideoViewControlBar localMPVideoViewControlBar = this.nRh;
    if (localMPVideoViewControlBar != null)
    {
      boolean bool = localMPVideoViewControlBar.bjw();
      AppMethodBeat.o(7579);
      return bool;
    }
    AppMethodBeat.o(7579);
    return false;
  }
  
  public final boolean bjb()
  {
    AppMethodBeat.i(7536);
    if (this.nRn == null)
    {
      ac.w(TAG, "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(7536);
      return false;
    }
    b localb = this.nRn;
    if (localb == null) {
      k.fOy();
    }
    boolean bool = localb.isFullScreen();
    AppMethodBeat.o(7536);
    return bool;
  }
  
  public final void cA(String paramString, int paramInt)
  {
    AppMethodBeat.i(7556);
    k.h(paramString, "videoPath");
    ac.i(TAG, "setVideoPath path=%s isLive=%s", new Object[] { paramString, Boolean.FALSE });
    if (bs.isNullOrNil(paramString))
    {
      ac.v(TAG, "setVideoPath videoPath empty");
      AppMethodBeat.o(7556);
      return;
    }
    this.videoPath = paramString;
    stop();
    this.kOA = false;
    MPExoVideoWrapper localMPExoVideoWrapper = this.nRg;
    if (localMPExoVideoWrapper == null) {
      k.fOy();
    }
    localMPExoVideoWrapper.setVideoSource(this.kOJ);
    localMPExoVideoWrapper = this.nRg;
    if (localMPExoVideoWrapper == null) {
      k.fOy();
    }
    localMPExoVideoWrapper.cz(paramString, paramInt);
    if (this.nRp > 0)
    {
      paramString = this.nRg;
      if (paramString == null) {
        k.fOy();
      }
      paramString.U(this.nRp, this.chR);
    }
    if (this.chR)
    {
      ac.i(TAG, "setVideoPath autoPlay");
      start();
    }
    setMute(this.mIsMute);
    AppMethodBeat.o(7556);
  }
  
  public final boolean getAutoPlay()
  {
    return this.chR;
  }
  
  public final FrameLayout getBackgroudContainerLayout()
  {
    return this.nRk;
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(7535);
    if (this.nRg != null)
    {
      MPExoVideoWrapper localMPExoVideoWrapper = this.nRg;
      if (localMPExoVideoWrapper == null) {
        k.fOy();
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.nRg;
    if (localMPExoVideoWrapper == null) {
      k.fOy();
    }
    int i = localMPExoVideoWrapper.getCurrPosMs();
    AppMethodBeat.o(7534);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(7533);
    MPExoVideoWrapper localMPExoVideoWrapper = this.nRg;
    if (localMPExoVideoWrapper == null) {
      k.fOy();
    }
    int i = localMPExoVideoWrapper.getCurrPosSec();
    AppMethodBeat.o(7533);
    return i;
  }
  
  public final FrameLayout getDotContainerLayout()
  {
    return this.nRj;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(7531);
    if (this.asf > 0)
    {
      i = this.asf;
      AppMethodBeat.o(7531);
      return i;
    }
    MPExoVideoWrapper localMPExoVideoWrapper = this.nRg;
    if (localMPExoVideoWrapper == null) {
      k.fOy();
    }
    int i = localMPExoVideoWrapper.getVideoDurationSec();
    AppMethodBeat.o(7531);
    return i;
  }
  
  public final int getEndPlayTime()
  {
    AppMethodBeat.i(7530);
    if ((getCurrPosMs() == 0) && (this.hYu != 0))
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
    return this.nRt;
  }
  
  public final boolean getPlayStart()
  {
    return this.nRl;
  }
  
  public final boolean getPlayStarted()
  {
    return this.nRm;
  }
  
  public final int getPlayStatus()
  {
    return this.hYu;
  }
  
  public final FrameLayout getPlayerAdContainerLayout()
  {
    return this.nRi;
  }
  
  public final long getRealPlayTime()
  {
    AppMethodBeat.i(7529);
    if ((!this.nRs) && (this.nRr != 0L) && (isPlaying()))
    {
      l1 = System.currentTimeMillis();
      long l2 = this.nRr;
      AppMethodBeat.o(7529);
      return l1 - l2;
    }
    long l1 = this.nRq;
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.nRg;
    if (localMPExoVideoWrapper == null) {
      k.fOy();
    }
    boolean bool = localMPExoVideoWrapper.isPlaying();
    AppMethodBeat.o(7550);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(7575);
    k.h(paramMotionEvent, "event");
    if (!bjb())
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
    ac.i(TAG, "onUIDestroy");
    clean();
    AppMethodBeat.o(7554);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(7552);
    ac.i(TAG, "pause");
    MPExoVideoWrapper localMPExoVideoWrapper = this.nRg;
    if (localMPExoVideoWrapper == null) {
      k.fOy();
    }
    if (!localMPExoVideoWrapper.isPlaying())
    {
      AppMethodBeat.o(7552);
      return;
    }
    localMPExoVideoWrapper = this.nRg;
    if (localMPExoVideoWrapper == null) {
      k.fOy();
    }
    localMPExoVideoWrapper.pause();
    AppMethodBeat.o(7552);
  }
  
  public final void q(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(7576);
    ac.i(TAG, "operateFullScreen toFullScreen:%b direction:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.nRn == null)
    {
      ac.w(TAG, "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(7576);
      return;
    }
    if (paramBoolean == bjb())
    {
      ac.i(TAG, "operateFullScreen current same");
      AppMethodBeat.o(7576);
      return;
    }
    if (paramInt == nRv) {
      if (this.abb == nRv)
      {
        paramInt = 90;
        ac.i(TAG, "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject = this.nRn;
        if (localObject == null) {
          k.fOy();
        }
        ((b)localObject).sC(paramInt);
        localObject = this.nRh;
        if (localObject != null) {
          ((MPVideoViewControlBar)localObject).setDirection(paramInt);
        }
        localObject = this.nRh;
        if (localObject != null) {
          ((MPVideoViewControlBar)localObject).bjx();
        }
        localObject = this.nRg;
        if (localObject != null)
        {
          ((MPExoVideoWrapper)localObject).jim = true;
          AppMethodBeat.o(7576);
          return;
          paramInt = this.abb;
          break;
        }
        AppMethodBeat.o(7576);
        return;
      }
      Object localObject = this.nRn;
      if (localObject != null) {
        ((b)localObject).bha();
      }
      localObject = this.nRh;
      if (localObject != null) {
        ((MPVideoViewControlBar)localObject).bha();
      }
      localObject = this.nRg;
      if (localObject != null)
      {
        ((MPExoVideoWrapper)localObject).jim = false;
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
    ac.i(TAG, "setAutoPlay =%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.chR = paramBoolean;
    if ((this.chR) && (this.hYu == 0)) {
      this.hYu = 1;
    }
    AppMethodBeat.o(7547);
  }
  
  public final void setBackgroudContainerLayout(FrameLayout paramFrameLayout)
  {
    this.nRk = paramFrameLayout;
  }
  
  public final void setConsumeTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(7540);
    ac.i(TAG, "setConsumeTouchEvent value=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOE = paramBoolean;
    AppMethodBeat.o(7540);
  }
  
  public final void setDotContainerLayout(FrameLayout paramFrameLayout)
  {
    this.nRj = paramFrameLayout;
  }
  
  public final void setDuration(int paramInt)
  {
    AppMethodBeat.i(7532);
    if (paramInt <= 0)
    {
      ac.i(TAG, "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(7532);
      return;
    }
    TextView localTextView = this.kOi;
    if (localTextView == null) {
      k.fOy();
    }
    localTextView.setText((CharSequence)sN(paramInt));
    this.asf = paramInt;
    AppMethodBeat.o(7532);
  }
  
  public final void setEnablePlayGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(7546);
    ac.i(TAG, "setEnablePlayGesture: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOM = paramBoolean;
    AppMethodBeat.o(7546);
  }
  
  public final void setFullScreenDelegate(b paramb)
  {
    AppMethodBeat.i(7572);
    k.h(paramb, "delegate");
    this.nRn = paramb;
    AppMethodBeat.o(7572);
  }
  
  public final void setFullScreenDirection(int paramInt)
  {
    AppMethodBeat.i(7568);
    ac.i(TAG, "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.abb = paramInt;
    AppMethodBeat.o(7568);
  }
  
  public final void setInitialTime(int paramInt)
  {
    AppMethodBeat.i(7571);
    ac.i(TAG, "setInitialTime initialTime=%s", new Object[] { Integer.valueOf(paramInt) });
    this.nRp = paramInt;
    AppMethodBeat.o(7571);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(7558);
    ac.i(TAG, "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOu = paramBoolean;
    if (this.nRh != null)
    {
      if (this.kOu)
      {
        localMPVideoViewControlBar = this.nRh;
        if (localMPVideoViewControlBar == null) {
          k.fOy();
        }
        localMPVideoViewControlBar.bjv();
        AppMethodBeat.o(7558);
        return;
      }
      MPVideoViewControlBar localMPVideoViewControlBar = this.nRh;
      if (localMPVideoViewControlBar == null) {
        k.fOy();
      }
      localMPVideoViewControlBar.hide();
    }
    AppMethodBeat.o(7558);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(7549);
    ac.i(TAG, "setLoop loop=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOB = paramBoolean;
    AppMethodBeat.o(7549);
  }
  
  public final void setMPVideoViewCallBack(c paramc)
  {
    AppMethodBeat.i(7573);
    k.h(paramc, "delegate");
    this.nRo = paramc;
    AppMethodBeat.o(7573);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(7567);
    ac.i(TAG, "setMute isMute=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    Object localObject = this.nRg;
    if (localObject == null) {
      k.fOy();
    }
    ((MPExoVideoWrapper)localObject).setMute(paramBoolean);
    localObject = this.nRh;
    if (localObject == null) {
      k.fOy();
    }
    ((MPVideoViewControlBar)localObject).setMuteBtnState(paramBoolean);
    AppMethodBeat.o(7567);
  }
  
  public final void setNeedHandleTouchEvent(boolean paramBoolean)
  {
    this.nRt = paramBoolean;
  }
  
  public final void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(7569);
    ac.i(TAG, "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOw = paramBoolean;
    AppMethodBeat.o(7569);
  }
  
  public final void setPageGestureInFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(7570);
    ac.i(TAG, "setPageGestureInFullscreen pageGestureInFullscreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOx = paramBoolean;
    AppMethodBeat.o(7570);
  }
  
  public final void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(7577);
    k.h(paramOnClickListener, "click");
    MPVideoViewControlBar localMPVideoViewControlBar = this.nRh;
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
    ac.i(TAG, "setPlayBtnPosition: %s", new Object[] { paramString });
    if ((!bs.isNullOrNil(paramString)) && (n.I(paramString, "center", true)))
    {
      paramString = this.nRh;
      if (paramString == null) {
        k.fOy();
      }
      paramString.setPlayBtnInCenterPosition(true);
      AppMethodBeat.o(7545);
      return;
    }
    paramString = this.nRh;
    if (paramString == null) {
      k.fOy();
    }
    paramString.setPlayBtnInCenterPosition(false);
    AppMethodBeat.o(7545);
  }
  
  public final void setPlayStatus(int paramInt)
  {
    this.hYu = paramInt;
  }
  
  public final void setPlayerAdContainerLayout(FrameLayout paramFrameLayout)
  {
    this.nRi = paramFrameLayout;
  }
  
  public final void setShowCenterPlayBtn(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(7566);
    ac.i(TAG, "setPlayBtnInCenterPosition %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOI = paramBoolean;
    Object localObject = this.kOg;
    if (localObject == null) {
      k.fOy();
    }
    if (paramBoolean)
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.kOh;
      if (localObject == null) {
        k.fOy();
      }
      if (!paramBoolean) {
        break label131;
      }
    }
    label131:
    for (int i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      if ((this.kOI) && (this.nRh != null))
      {
        localObject = this.nRh;
        if (localObject == null) {
          k.fOy();
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
    ac.i(TAG, "setShowControlProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.nRh;
    if (localMPVideoViewControlBar == null) {
      k.fOy();
    }
    if ((paramBoolean) && (!bed())) {}
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
    ac.i(TAG, "setShowFullScreenBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.nRh;
    if (localMPVideoViewControlBar == null) {
      k.fOy();
    }
    localMPVideoViewControlBar.setShowFullScreenBtn(paramBoolean);
    AppMethodBeat.o(7564);
  }
  
  public final void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(7541);
    ac.i(TAG, "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.nRh;
    if (localMPVideoViewControlBar == null) {
      k.fOy();
    }
    localMPVideoViewControlBar.setShowMuteBtn(paramBoolean);
    AppMethodBeat.o(7541);
  }
  
  public final void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(7565);
    ac.i(TAG, "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.nRh;
    if (localMPVideoViewControlBar == null) {
      k.fOy();
    }
    localMPVideoViewControlBar.setShowPlayBtn(paramBoolean);
    AppMethodBeat.o(7565);
  }
  
  public final void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(7563);
    ac.i(TAG, "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOG = paramBoolean;
    MPVideoViewControlBar localMPVideoViewControlBar = this.nRh;
    if (localMPVideoViewControlBar == null) {
      k.fOy();
    }
    if ((paramBoolean) && (!bed())) {}
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
    ac.i(TAG, "setTitle %s", new Object[] { paramString });
    MPVideoViewControlBar localMPVideoViewControlBar = this.nRh;
    if (localMPVideoViewControlBar == null) {
      k.fOy();
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
    ac.i(TAG, "setVideoSource =%d", new Object[] { Integer.valueOf(paramInt) });
    this.kOJ = paramInt;
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.nRg;
    if (localMPExoVideoWrapper == null) {
      k.fOy();
    }
    ac.i((String)localObject, localMPExoVideoWrapper.isPlaying());
    localObject = this.nRg;
    if (localObject == null) {
      k.fOy();
    }
    if (((MPExoVideoWrapper)localObject).isPlaying())
    {
      AppMethodBeat.o(7551);
      return;
    }
    this.nRl = true;
    if (this.kOu)
    {
      localObject = this.nRh;
      if (localObject == null) {
        k.fOy();
      }
      ((MPVideoViewControlBar)localObject).bjA();
    }
    localObject = this.kOg;
    if (localObject == null) {
      k.fOy();
    }
    ((View)localObject).setVisibility(8);
    localObject = this.nRg;
    if (localObject == null) {
      k.fOy();
    }
    ((MPExoVideoWrapper)localObject).start();
    bNS();
    AppMethodBeat.o(7551);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(7553);
    ac.i(TAG, "stop");
    Object localObject = this.nRg;
    if (localObject == null) {
      k.fOy();
    }
    if (!((MPExoVideoWrapper)localObject).isPlaying())
    {
      AppMethodBeat.o(7553);
      return;
    }
    localObject = this.nRg;
    if (localObject == null) {
      k.fOy();
    }
    ((MPExoVideoWrapper)localObject).Fb();
    localObject = this.nRh;
    if (localObject == null) {
      k.fOy();
    }
    ((MPVideoViewControlBar)localObject).bjB();
    bNR();
    AppMethodBeat.o(7553);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "enterFullScreen", "", "direction", "", "quitFullScreen", "plugin-brandservice_release"})
  public static abstract interface b
  {
    public abstract void bha();
    
    public abstract boolean isFullScreen();
    
    public abstract void sC(int paramInt);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "", "onControlbarVisible", "", "visible", "", "onEndDragProgress", "onGetVideoSize", "width", "", "height", "onHideSwitchResolutionLayout", "onHideSwitchSpeedLayout", "onPlayError", "errorMsg", "", "errorCode", "onSeekPre", "onSeekTo", "time", "onStartDragProgress", "onUpdateProgress", "progressLen", "totalLen", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoPrepare", "firstRenderTime", "", "onVideoWaiting", "onVideoWaitingEnd", "resolutionBtnClick", "speedBtnClick", "switchResolution", "beforeType", "afterType", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "switchSpeed", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
  public static abstract interface c
  {
    public abstract void Ul(String paramString);
    
    public abstract void a(int paramInt1, int paramInt2, fp paramfp);
    
    public abstract void a(c.a parama1, c.a parama2);
    
    public abstract void anR();
    
    public abstract void bNr();
    
    public abstract void bNs();
    
    public abstract void bNt();
    
    public abstract void bNu();
    
    public abstract void bNv();
    
    public abstract void bNw();
    
    public abstract void bNx();
    
    public abstract void bjl();
    
    public abstract void je(boolean paramBoolean);
    
    public abstract void onVideoEnded();
    
    public abstract void onVideoPause();
    
    public abstract void onVideoPlay();
    
    public abstract void onVideoWaiting();
    
    public abstract void ru(long paramLong);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$10", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$SwitchSpeedListener;", "onHideSwitchSpeedLayout", "", "speedBtnClick", "switchSpeed", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
  public static final class f
    implements MPVideoViewControlBar.b
  {
    public final void a(fp paramfp, c.a parama1, c.a parama2)
    {
      AppMethodBeat.i(199192);
      Object localObject = MPVideoView.k(this.nRy);
      if (localObject != null) {
        ((MPVideoView.c)localObject).a(parama1, parama2);
      }
      this.nRy.setAutoPlay(this.nRy.isPlaying());
      int j = this.nRy.getCurrPosMs();
      parama2 = MPVideoView.h(this.nRy);
      if (parama2 == null) {
        k.fOy();
      }
      parama1 = parama2.nQq;
      if (parama1 != null)
      {
        parama1 = parama1.getBitmap();
        if ((parama1 == null) || (parama1.isRecycled())) {
          break label261;
        }
        localObject = parama2.nQm;
        if (localObject != null) {
          ((ImageView)localObject).setImageBitmap(parama1);
        }
      }
      for (;;)
      {
        parama1 = parama2.nQm;
        if (parama1 != null) {
          parama1.setVisibility(0);
        }
        parama2.ry(0L);
        parama1 = MPVideoView.h(this.nRy);
        if (parama1 == null) {
          k.fOy();
        }
        parama1.bNT();
        parama1 = this.nRy;
        int i = j;
        if (j == 0) {
          i = 1;
        }
        parama1.setInitialTime(i);
        parama1 = this.nRy;
        if (paramfp == null) {
          k.fOy();
        }
        paramfp = paramfp.url;
        k.g(paramfp, "info!!.url");
        parama1.cA(paramfp, this.nRy.getDuration());
        if (!MPVideoView.E(this.nRy))
        {
          paramfp = MPVideoView.h(this.nRy);
          if (paramfp == null) {
            k.fOy();
          }
          paramfp.pause();
        }
        paramfp = MPVideoView.c(this.nRy);
        if (paramfp == null) {
          break label279;
        }
        paramfp.hide();
        AppMethodBeat.o(199192);
        return;
        parama1 = null;
        break;
        label261:
        parama1 = parama2.nQm;
        if (parama1 != null) {
          parama1.setImageResource(2131233299);
        }
      }
      label279:
      AppMethodBeat.o(199192);
    }
    
    public final void bOe()
    {
      AppMethodBeat.i(179030);
      MPVideoView.k(this.nRy);
      AppMethodBeat.o(179030);
    }
    
    public final void bOf()
    {
      AppMethodBeat.i(179031);
      MPVideoView.k(this.nRy);
      AppMethodBeat.o(179031);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$2", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-brandservice_release"})
  public static final class g
    implements e.d
  {
    public final void anR()
    {
      AppMethodBeat.i(7488);
      ac.i(MPVideoView.access$getTAG$cp(), "onSeekPre");
      if (this.nRy.isPlaying()) {
        this.nRy.bNZ();
      }
      MPVideoView.c localc = MPVideoView.k(this.nRy);
      if (localc != null)
      {
        localc.anR();
        AppMethodBeat.o(7488);
        return;
      }
      AppMethodBeat.o(7488);
    }
    
    public final void nn(int paramInt)
    {
      AppMethodBeat.i(7489);
      MPVideoView.a(this.nRy, paramInt * 1000);
      MPVideoView.m(this.nRy);
      MPVideoView.c localc = MPVideoView.k(this.nRy);
      if (localc != null)
      {
        localc.bNt();
        AppMethodBeat.o(7489);
        return;
      }
      AppMethodBeat.o(7489);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$4", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$StatePorter;", "getCacheTime", "", "getTotalTime", "plugin-brandservice_release"})
  public static final class i
    implements e.i
  {
    public final int bjh()
    {
      AppMethodBeat.i(7491);
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.nRy);
      if (localMPExoVideoWrapper == null) {
        k.fOy();
      }
      int i = localMPExoVideoWrapper.getCacheTimeSec();
      AppMethodBeat.o(7491);
      return i;
    }
    
    public final int bji()
    {
      AppMethodBeat.i(7492);
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.nRy);
      if (localMPExoVideoWrapper == null) {
        k.fOy();
      }
      int i = localMPExoVideoWrapper.getVideoDurationSec();
      AppMethodBeat.o(7492);
      return i;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "visible", "", "onVisibilityChanged"})
  static final class l
    implements e.f
  {
    l(MPVideoView paramMPVideoView) {}
    
    public final void onVisibilityChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(7495);
      MPVideoView.A(this.nRy);
      Object localObject1 = MPVideoView.k(this.nRy);
      if (localObject1 != null) {
        ((MPVideoView.c)localObject1).je(paramBoolean);
      }
      localObject1 = MPVideoView.h(this.nRy);
      if (localObject1 != null)
      {
        Object localObject2;
        if (paramBoolean)
        {
          ((MPExoVideoWrapper)localObject1).nQF = true;
          localObject2 = ((MPExoVideoWrapper)localObject1).nQm;
          if ((localObject2 == null) || (((ImageView)localObject2).getVisibility() != 0))
          {
            localObject2 = ((MPExoVideoWrapper)localObject1).nQn;
            if (localObject2 != null) {
              if (((TextView)localObject2).getVisibility() != 0) {
                break label265;
              }
            }
          }
          else
          {
            ac.i(MPExoVideoWrapper.TAG, "hide switchingResolution onControllerBarVisible");
            if (((MPExoVideoWrapper)localObject1).nQE)
            {
              localObject2 = ((MPExoVideoWrapper)localObject1).nQm;
              if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 0)) {
                ((MPExoVideoWrapper)localObject1).nQD = true;
              }
            }
            localObject2 = ((MPExoVideoWrapper)localObject1).nQm;
            if (localObject2 != null) {
              ((ImageView)localObject2).setVisibility(8);
            }
            localObject1 = ((MPExoVideoWrapper)localObject1).nQn;
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
          ((MPExoVideoWrapper)localObject1).nQF = false;
          if (((MPExoVideoWrapper)localObject1).nQD)
          {
            ac.i(MPExoVideoWrapper.TAG, "show switchingResolution onControllerBarVisible isSwitchingResolution = " + ((MPExoVideoWrapper)localObject1).nQE);
            ((MPExoVideoWrapper)localObject1).nQD = false;
            if (((MPExoVideoWrapper)localObject1).nQE)
            {
              ((MPExoVideoWrapper)localObject1).bNP();
              AppMethodBeat.o(7495);
              return;
            }
            localObject2 = ((MPExoVideoWrapper)localObject1).nQm;
            if (localObject2 != null) {
              ((ImageView)localObject2).setVisibility(8);
            }
            localObject2 = ((MPExoVideoWrapper)localObject1).nQn;
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(0);
            }
            ((MPExoVideoWrapper)localObject1).bNQ();
          }
        }
        label265:
        AppMethodBeat.o(7495);
        return;
      }
      AppMethodBeat.o(7495);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "progressLen", "", "totalLen", "onProgressChanged"})
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
        Object localObject = MPVideoView.C(this.nRy);
        if (localObject == null) {
          k.fOy();
        }
        paramInt1 = i * ((ImageView)localObject).getWidth() / paramInt2;
        localObject = MPVideoView.D(this.nRy);
        if (localObject == null) {
          k.fOy();
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
        ImageView localImageView = MPVideoView.D(this.nRy);
        if (localImageView == null) {
          k.fOy();
        }
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = MPVideoView.D(this.nRy);
        if (localObject == null) {
          k.fOy();
        }
        ((ImageView)localObject).requestLayout();
        localObject = MPVideoView.k(this.nRy);
        if (localObject != null)
        {
          ((MPVideoView.c)localObject).bNv();
          AppMethodBeat.o(7496);
          return;
        }
        AppMethodBeat.o(7496);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$9", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$SwitchResolutionListener;", "onHideSwitchResolutionLayout", "", "resolutionBtnClick", "switchResolution", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "beforeType", "", "afterType", "plugin-brandservice_release"})
  public static final class n
    implements MPVideoViewControlBar.a
  {
    public final void a(fp paramfp, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7498);
      Object localObject = MPVideoView.k(this.nRy);
      if (localObject != null) {
        ((MPVideoView.c)localObject).a(paramInt1, paramInt2, paramfp);
      }
      this.nRy.setAutoPlay(this.nRy.isPlaying());
      paramInt1 = this.nRy.getCurrPosMs();
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.nRy);
      if (localMPExoVideoWrapper == null) {
        k.fOy();
      }
      if (paramfp == null) {
        k.fOy();
      }
      String str = paramfp.DSJ;
      ac.i(MPExoVideoWrapper.TAG, "onSetResolution %b", new Object[] { Boolean.valueOf(localMPExoVideoWrapper.nQF) });
      localMPExoVideoWrapper.nQE = true;
      localMPExoVideoWrapper.nQp = str;
      localObject = localMPExoVideoWrapper.nQq;
      if (localObject != null)
      {
        localObject = ((MPExoVideoTextureView)localObject).getBitmap();
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label348;
        }
        ImageView localImageView = localMPExoVideoWrapper.nQm;
        if (localImageView != null) {
          localImageView.setImageBitmap((Bitmap)localObject);
        }
        label169:
        localObject = localMPExoVideoWrapper.nQn;
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)localMPExoVideoWrapper.getContext().getString(2131761350, new Object[] { str }));
        }
        localMPExoVideoWrapper.bNP();
        localMPExoVideoWrapper.ry(0L);
        localObject = MPVideoView.h(this.nRy);
        if (localObject == null) {
          k.fOy();
        }
        ((MPExoVideoWrapper)localObject).bNT();
        localObject = this.nRy;
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
        localObject = this.nRy;
        paramfp = paramfp.url;
        k.g(paramfp, "info!!.url");
        ((MPVideoView)localObject).cA(paramfp, this.nRy.getDuration());
        if (!MPVideoView.E(this.nRy))
        {
          paramfp = MPVideoView.h(this.nRy);
          if (paramfp == null) {
            k.fOy();
          }
          paramfp.pause();
        }
        paramfp = MPVideoView.c(this.nRy);
        if (paramfp == null) {
          break label373;
        }
        paramfp.hide();
        AppMethodBeat.o(7498);
        return;
        localObject = null;
        break;
        localObject = localMPExoVideoWrapper.nQm;
        if (localObject == null) {
          break label169;
        }
        ((ImageView)localObject).setImageResource(2131233299);
        break label169;
      }
      label373:
      AppMethodBeat.o(7498);
    }
    
    public final void bNw()
    {
      AppMethodBeat.i(7499);
      MPVideoView.c localc = MPVideoView.k(this.nRy);
      if (localc != null)
      {
        localc.bNw();
        AppMethodBeat.o(7499);
        return;
      }
      AppMethodBeat.o(7499);
    }
    
    public final void bNx()
    {
      AppMethodBeat.i(7497);
      MPVideoView.c localc = MPVideoView.k(this.nRy);
      if (localc != null)
      {
        localc.bNx();
        AppMethodBeat.o(7497);
        return;
      }
      AppMethodBeat.o(7497);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initGestureController$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$GestureOperationHelper;", "canAdjustBrightness", "", "canAdjustProgress", "canAdjustVolume", "getCurrentPosition", "", "onAdjustBrightness", "", "brightness", "", "onAdjustVolume", "volumePercent", "onCanHandleGesture", "onDoubleTap", "onDragProgress", "startDragPos", "distanceX", "onEndAdjustBrightness", "onEndAdjustVolume", "onEndDragProgress", "dragPosition", "totalDistanceX", "onSingleTap", "onStartDragProgress", "plugin-brandservice_release"})
  public static final class o
    implements a.b
  {
    public final void aA(float paramFloat)
    {
      AppMethodBeat.i(7507);
      if (!MPVideoView.r(this.nRy))
      {
        AppMethodBeat.o(7507);
        return;
      }
      ac.d(MPVideoView.access$getTAG$cp(), "onAdjustBrightness:".concat(String.valueOf(paramFloat)));
      Object localObject = MPVideoView.n(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      ((AppBrandDotPercentIndicator)localObject).setPercent(paramFloat);
      localObject = MPVideoView.o(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      ((TextView)localObject).setText(2131760998);
      localObject = MPVideoView.p(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      ((ImageView)localObject).setImageResource(2131231033);
      localObject = MPVideoView.q(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      ((LinearLayout)localObject).setVisibility(0);
      MPVideoView.f(this.nRy);
      AppMethodBeat.o(7507);
    }
    
    public final void az(float paramFloat)
    {
      AppMethodBeat.i(7506);
      if (!MPVideoView.r(this.nRy))
      {
        AppMethodBeat.o(7506);
        return;
      }
      ac.d(MPVideoView.access$getTAG$cp(), "onAdjustVolume:".concat(String.valueOf(paramFloat)));
      Object localObject = MPVideoView.n(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      ((AppBrandDotPercentIndicator)localObject).setPercent(paramFloat);
      localObject = MPVideoView.o(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      ((TextView)localObject).setText(2131760999);
      localObject = MPVideoView.p(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      ((ImageView)localObject).setImageResource(2131231041);
      localObject = MPVideoView.q(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      ((LinearLayout)localObject).setVisibility(0);
      MPVideoView.f(this.nRy);
      AppMethodBeat.o(7506);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(7500);
      ac.d(MPVideoView.access$getTAG$cp(), "onSingleTap");
      if ((MPVideoView.a(this.nRy)) && (!MPVideoView.b(this.nRy)))
      {
        localObject = MPVideoView.c(this.nRy);
        if (localObject == null) {
          k.fOy();
        }
        ((MPVideoViewControlBar)localObject).bju();
      }
      Object localObject = MPVideoView.d(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      if ((((View)localObject).getVisibility() != 0) && (MPVideoView.e(this.nRy))) {
        MPVideoView.f(this.nRy);
      }
      AppMethodBeat.o(7500);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(7501);
      ac.d(MPVideoView.access$getTAG$cp(), "onDoubleTap");
      if (MPVideoView.g(this.nRy))
      {
        Object localObject = MPVideoView.h(this.nRy);
        if (localObject == null) {
          k.fOy();
        }
        if (((MPExoVideoWrapper)localObject).isPlaying())
        {
          this.nRy.pause();
          localObject = m.nPf;
          m.a.zt(35);
          AppMethodBeat.o(7501);
          return;
        }
        this.nRy.start();
        localObject = m.nPf;
        m.a.zt(36);
      }
      AppMethodBeat.o(7501);
    }
    
    public final void bjl()
    {
      AppMethodBeat.i(7502);
      if (!MPVideoView.i(this.nRy))
      {
        AppMethodBeat.o(7502);
        return;
      }
      Object localObject = MPVideoView.j(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      ((TextView)localObject).setVisibility(0);
      MPVideoView.f(this.nRy);
      if (this.nRy.isPlaying()) {
        this.nRy.bNZ();
      }
      localObject = MPVideoView.k(this.nRy);
      if (localObject != null)
      {
        ((MPVideoView.c)localObject).bjl();
        AppMethodBeat.o(7502);
        return;
      }
      AppMethodBeat.o(7502);
    }
    
    public final void bjm()
    {
      AppMethodBeat.i(7508);
      if (!MPVideoView.r(this.nRy))
      {
        AppMethodBeat.o(7508);
        return;
      }
      Object localObject = MPVideoView.q(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      ((LinearLayout)localObject).setVisibility(8);
      MPVideoView.l(this.nRy);
      localObject = m.nPf;
      m.a.zt(41);
      AppMethodBeat.o(7508);
    }
    
    public final void bjn()
    {
      AppMethodBeat.i(7509);
      if (!MPVideoView.r(this.nRy))
      {
        AppMethodBeat.o(7509);
        return;
      }
      Object localObject = MPVideoView.q(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      ((LinearLayout)localObject).setVisibility(8);
      MPVideoView.l(this.nRy);
      localObject = m.nPf;
      m.a.zt(39);
      AppMethodBeat.o(7509);
    }
    
    public final boolean bjo()
    {
      AppMethodBeat.i(210010);
      boolean bool = MPVideoView.r(this.nRy);
      AppMethodBeat.o(210010);
      return bool;
    }
    
    public final boolean bjp()
    {
      AppMethodBeat.i(210011);
      boolean bool = MPVideoView.r(this.nRy);
      AppMethodBeat.o(210011);
      return bool;
    }
    
    public final boolean bjq()
    {
      AppMethodBeat.i(7512);
      boolean bool = MPVideoView.i(this.nRy);
      AppMethodBeat.o(7512);
      return bool;
    }
    
    public final int getCurrentPosition()
    {
      AppMethodBeat.i(7505);
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.nRy);
      if (localMPExoVideoWrapper == null) {
        k.fOy();
      }
      int i = localMPExoVideoWrapper.getCurrPosSec();
      AppMethodBeat.o(7505);
      return i;
    }
    
    public final int j(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(7503);
      if (!MPVideoView.i(this.nRy))
      {
        AppMethodBeat.o(7503);
        return 0;
      }
      ac.i(MPVideoView.access$getTAG$cp(), "onDragProgress:" + paramInt + '/' + paramFloat);
      Object localObject = MPVideoView.h(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      paramInt = ((MPExoVideoWrapper)localObject).getVideoDurationSec();
      int i = com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a.c(paramFloat, this.nRy.getMeasuredWidth(), getCurrentPosition(), paramInt);
      localObject = r.qn(paramInt * 1000L);
      TextView localTextView = MPVideoView.j(this.nRy);
      if (localTextView == null) {
        k.fOy();
      }
      localTextView.setText((CharSequence)(r.qn(i * 1000L) + "/" + (String)localObject));
      localObject = MPVideoView.c(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      ((MPVideoViewControlBar)localObject).seek(i);
      localObject = MPVideoView.c(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      if (((MPVideoViewControlBar)localObject).bjw())
      {
        localObject = MPVideoView.c(this.nRy);
        if (localObject == null) {
          k.fOy();
        }
        ((MPVideoViewControlBar)localObject).bjC();
      }
      AppMethodBeat.o(7503);
      return i;
    }
    
    public final void k(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(7504);
      if (!MPVideoView.i(this.nRy))
      {
        AppMethodBeat.o(7504);
        return;
      }
      Object localObject = MPVideoView.j(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      ((TextView)localObject).setVisibility(8);
      MPVideoView.l(this.nRy);
      localObject = MPVideoView.h(this.nRy);
      if (localObject == null) {
        k.fOy();
      }
      int i = ((MPExoVideoWrapper)localObject).getCurrPosSec();
      ac.i(MPVideoView.access$getTAG$cp(), "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Float.valueOf(paramFloat) });
      MPVideoView.a(this.nRy, paramInt * 1000);
      MPVideoView.m(this.nRy);
      localObject = MPVideoView.k(this.nRy);
      if (localObject != null)
      {
        ((MPVideoView.c)localObject).bNs();
        AppMethodBeat.o(7504);
        return;
      }
      AppMethodBeat.o(7504);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initVideoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-brandservice_release"})
  public static final class p
    implements h.b
  {
    public final void c(String paramString1, String paramString2, final String paramString3, final int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7521);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      k.h(paramString3, "errorMsg");
      ac.i(MPVideoView.access$getTAG$cp(), "onError errorMsg=%s what=%d extra=%d", new Object[] { paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      ap.f((Runnable)new a(this, paramString3, paramInt1));
      AppMethodBeat.o(7521);
    }
    
    public final void d(String paramString1, String paramString2, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(7524);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      this.nRy.setVideoWidth(paramInt1);
      this.nRy.setVideoHeight(paramInt2);
      paramString1 = MPVideoView.k(this.nRy);
      if (paramString1 != null) {
        paramString1.bNr();
      }
      ap.f((Runnable)new b(this, paramInt1, paramInt2));
      AppMethodBeat.o(7524);
    }
    
    public final void jdMethod_do(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7522);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      ac.i(MPVideoView.access$getTAG$cp(), "onPrepared");
      ap.f((Runnable)new c(this));
      AppMethodBeat.o(7522);
    }
    
    public final void dp(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7523);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      ac.i(MPVideoView.access$getTAG$cp(), "onVideoEnded");
      ap.f((Runnable)new d(this));
      AppMethodBeat.o(7523);
    }
    
    public final void dq(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7525);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      ac.i(MPVideoView.access$getTAG$cp(), "onVideoPause");
      this.nRy.bNZ();
      paramString1 = MPVideoView.k(this.nRy);
      if (paramString1 != null) {
        paramString1.onVideoPause();
      }
      if (this.nRy.getPlayStatus() != 4) {
        this.nRy.setPlayStatus(3);
      }
      paramString1 = MPVideoView.h(this.nRy);
      if (paramString1 == null) {
        k.fOy();
      }
      paramString1 = paramString1.nQn;
      if (paramString1 == null) {
        k.fOy();
      }
      if (paramString1.getVisibility() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        ap.n((Runnable)new e(this), 1000L);
        AppMethodBeat.o(7525);
        return;
      }
      this.nRy.bOb();
      AppMethodBeat.o(7525);
    }
    
    public final void dr(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7526);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      ap.f((Runnable)new f(this));
      AppMethodBeat.o(7526);
    }
    
    public final void ds(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7527);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      ac.i(MPVideoView.access$getTAG$cp(), "onVideoWaiting");
      ap.f((Runnable)new g(this));
      AppMethodBeat.o(7527);
    }
    
    public final void dt(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7528);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      ap.f((Runnable)new h(this));
      AppMethodBeat.o(7528);
    }
    
    public final void eJ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(199195);
      k.h(paramString1, "sessionId");
      k.h(paramString2, "mediaId");
      AppMethodBeat.o(199195);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoView.p paramp, String paramString, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(7513);
        this.nRz.nRy.bNZ();
        MPVideoView.c localc = MPVideoView.k(this.nRz.nRy);
        if (localc != null) {
          localc.Ul(paramString3);
        }
        this.nRz.nRy.setPlayStatus(4);
        AppMethodBeat.o(7513);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(MPVideoView.p paramp, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(7514);
        int i = MPVideoView.y(this.nRz.nRy);
        Object localObject = MPVideoView.nRx;
        if (i == MPVideoView.bOd())
        {
          localObject = this.nRz.nRy;
          if (paramInt1 >= paramInt2) {
            break label89;
          }
        }
        label89:
        for (i = 0;; i = 90)
        {
          MPVideoView.b((MPVideoView)localObject, i);
          ac.i(MPVideoView.access$getTAG$cp(), "onGetVideoSize adjust direction from AUTO to %s", new Object[] { Integer.valueOf(MPVideoView.y(this.nRz.nRy)) });
          AppMethodBeat.o(7514);
          return;
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7515);
        Object localObject = MPVideoView.k(this.nRz.nRy);
        MPExoVideoWrapper localMPExoVideoWrapper;
        if (localObject != null)
        {
          localMPExoVideoWrapper = MPVideoView.h(this.nRz.nRy);
          if (localMPExoVideoWrapper == null) {
            break label80;
          }
        }
        label80:
        for (long l = localMPExoVideoWrapper.getFirstRenderTime();; l = 0L)
        {
          ((MPVideoView.c)localObject).ru(l);
          localObject = MPVideoView.s(this.nRz.nRy);
          if (localObject == null) {
            k.fOy();
          }
          ((com.tencent.mm.plugin.appbrand.jsapi.video.ui.a)localObject).bkY();
          AppMethodBeat.o(7515);
          return;
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class d
      implements Runnable
    {
      d(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7516);
        this.nRz.nRy.bNZ();
        Object localObject = MPVideoView.j(this.nRz.nRy);
        if (localObject == null) {
          k.fOy();
        }
        ((TextView)localObject).setVisibility(8);
        if (MPVideoView.b(this.nRz.nRy))
        {
          localObject = MPVideoView.d(this.nRz.nRy);
          if (localObject == null) {
            k.fOy();
          }
          ((View)localObject).setVisibility(0);
          localObject = MPVideoView.c(this.nRz.nRy);
          if (localObject == null) {
            k.fOy();
          }
          if (((MPVideoViewControlBar)localObject).bjw())
          {
            localObject = MPVideoView.c(this.nRz.nRy);
            if (localObject == null) {
              k.fOy();
            }
            ((MPVideoViewControlBar)localObject).hide();
          }
          localObject = MPVideoView.t(this.nRz.nRy);
          if (localObject == null) {
            k.fOy();
          }
          if (((FrameLayout)localObject).getVisibility() == 0)
          {
            localObject = MPVideoView.t(this.nRz.nRy);
            if (localObject == null) {
              k.fOy();
            }
            ((FrameLayout)localObject).setVisibility(8);
          }
          if ((!MPVideoView.u(this.nRz.nRy)) && (MPVideoView.b(this.nRz.nRy))) {
            break label318;
          }
          localObject = MPVideoView.v(this.nRz.nRy);
          if (localObject == null) {
            k.fOy();
          }
          ((View)localObject).setVisibility(8);
        }
        for (;;)
        {
          this.nRz.nRy.bNR();
          this.nRz.nRy.setPlayStatus(4);
          localObject = MPVideoView.k(this.nRz.nRy);
          if (localObject == null) {
            break label407;
          }
          ((MPVideoView.c)localObject).onVideoEnded();
          AppMethodBeat.o(7516);
          return;
          localObject = MPVideoView.c(this.nRz.nRy);
          if (localObject == null) {
            k.fOy();
          }
          ((MPVideoViewControlBar)localObject).bOg();
          localObject = MPVideoView.c(this.nRz.nRy);
          if (localObject == null) {
            k.fOy();
          }
          ((MPVideoViewControlBar)localObject).show();
          break;
          label318:
          if (MPVideoView.w(this.nRz.nRy) <= 0)
          {
            localObject = MPVideoView.x(this.nRz.nRy);
            if (localObject == null) {
              k.fOy();
            }
            MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.nRz.nRy);
            if (localMPExoVideoWrapper == null) {
              k.fOy();
            }
            ((TextView)localObject).setText((CharSequence)MPVideoView.zz(localMPExoVideoWrapper.getVideoDurationSec()));
          }
          localObject = MPVideoView.v(this.nRz.nRy);
          if (localObject == null) {
            k.fOy();
          }
          ((View)localObject).setVisibility(0);
        }
        label407:
        AppMethodBeat.o(7516);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class e
      implements Runnable
    {
      e(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7517);
        this.nRz.nRy.bOb();
        AppMethodBeat.o(7517);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class f
      implements Runnable
    {
      f(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7518);
        ac.i(MPVideoView.access$getTAG$cp(), "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(MPVideoView.u(this.nRz.nRy)) });
        MPVideoView.z(this.nRz.nRy);
        this.nRz.nRy.bNS();
        Object localObject = MPVideoView.k(this.nRz.nRy);
        if (localObject != null) {
          ((MPVideoView.c)localObject).onVideoPlay();
        }
        if ((MPVideoView.w(this.nRz.nRy) <= 0) && (!MPVideoView.u(this.nRz.nRy)))
        {
          localObject = MPVideoView.x(this.nRz.nRy);
          if (localObject == null) {
            k.fOy();
          }
          MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.nRz.nRy);
          if (localMPExoVideoWrapper == null) {
            k.fOy();
          }
          ((TextView)localObject).setText((CharSequence)MPVideoView.zz(localMPExoVideoWrapper.getVideoDurationSec()));
        }
        MPVideoView.b(this.nRz.nRy, MPVideoView.u(this.nRz.nRy));
        if (MPVideoView.a(this.nRz.nRy)) {
          MPVideoView.A(this.nRz.nRy);
        }
        MPVideoView.m(this.nRz.nRy);
        this.nRz.nRy.setPlayStatus(2);
        localObject = MPVideoView.c(this.nRz.nRy);
        if (localObject == null) {
          k.fOy();
        }
        if (((MPVideoViewControlBar)localObject).bjw())
        {
          localObject = MPVideoView.c(this.nRz.nRy);
          if (localObject == null) {
            k.fOy();
          }
          ((MPVideoViewControlBar)localObject).bjC();
        }
        AppMethodBeat.o(7518);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class g
      implements Runnable
    {
      g(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7519);
        MPVideoView.a(this.nRz.nRy, true);
        MPVideoView.f(this.nRz.nRy);
        MPVideoView.c localc = MPVideoView.k(this.nRz.nRy);
        if (localc != null)
        {
          localc.onVideoWaiting();
          AppMethodBeat.o(7519);
          return;
        }
        AppMethodBeat.o(7519);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class h
      implements Runnable
    {
      h(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7520);
        MPVideoView.a(this.nRz.nRy, false);
        MPVideoView.l(this.nRz.nRy);
        MPVideoView.c localc = MPVideoView.k(this.nRz.nRy);
        if (localc != null)
        {
          localc.bNu();
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