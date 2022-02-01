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
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.n.n;
import d.v;
import java.util.LinkedList;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroudContainerLayout", "Landroid/widget/FrameLayout;", "getBackgroudContainerLayout", "()Landroid/widget/FrameLayout;", "setBackgroudContainerLayout", "(Landroid/widget/FrameLayout;)V", "cacheTimeSec", "getCacheTimeSec", "()I", "currPosMs", "getCurrPosMs", "currPosSec", "getCurrPosSec", "dotContainerLayout", "getDotContainerLayout", "setDotContainerLayout", "duration", "getDuration", "setDuration", "(I)V", "endPlayTime", "getEndPlayTime", "hasDownInTouchEvent", "", "hasRealPlayTime", "isCoverVisible", "()Z", "isInFullScreen", "isLive", "mAdjustContentTv", "Landroid/widget/TextView;", "mAdjustIconIv", "Landroid/widget/ImageView;", "mAdjustInfoLayout", "Landroid/widget/LinearLayout;", "mAdjustPercentIndicator", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/AppBrandDotPercentIndicator;", "mAutoPlay", "mBottomProgressBackBar", "mBottomProgressFrontBar", "mBottomProgressLayout", "mConsumeTouchEvent", "mControlBar", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar;", "mCoverArea", "Landroid/view/View;", "mCoverPlayBtnArea", "mCoverTotalTimeTv", "mCoverUrl", "", "mDirection", "mDuration", "mEnablePlayGesture", "mEnableProgressGesture", "mFullScreenDelegate", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "mGestureController", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController;", "mInitialTime", "mIsAlive", "mIsLoading", "mIsMute", "mIsShowBasicControls", "mLoop", "mMPVideoViewCallBack", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "mPageGesture", "mPageGestureInFullscreen", "mPlayStart", "mPlayStarted", "mProgressTv", "mRealPlayTime", "", "mSetIsShowCoverPlayBtn", "mSetIsShowProgressBar", "mSkipAutoPause", "mStartPlayTime", "mVideoSource", "mVideoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper;", "needHandleTouchEvent", "getNeedHandleTouchEvent", "setNeedHandleTouchEvent", "(Z)V", "playStatus", "getPlayStatus", "setPlayStatus", "playerAdContainerLayout", "getPlayerAdContainerLayout", "setPlayerAdContainerLayout", "realPlayTime", "getRealPlayTime", "()J", "videoHeight", "getVideoHeight", "setVideoHeight", "<set-?>", "videoPath", "getVideoPath", "()Ljava/lang/String;", "videoWidth", "getVideoWidth", "setVideoWidth", "canAdjustBrightnessVolume", "canDragProgress", "clean", "", "doOnTouchEvent", "event", "Landroid/view/MotionEvent;", "downloadVideo", "videoUrl", "enableProgressGesture", "enable", "getAutoPlay", "getPlayStart", "getPlayStarted", "getTimeShowString", "time", "hideCenterPlayBtnIfNeed", "hideCover", "init", "initControlBar", "initGestureController", "initParam", "initVideoViewCallback", "isControlBarShow", "isPlaying", "makeTimeString", "d", "onExitFullScreen", "onTouchEvent", "onUIDestroy", "onUIPause", "onUIResume", "operateFullScreen", "toFullScreen", "direction", "pause", "seekTo", "position", "afterPlay", "setAutoPlay", "autoPlay", "setBizInfo", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "iconUrl", "setConsumeTouchEvent", "value", "setCoverByUrl", "cover", "coverUrl", "width", "height", "setEnablePlayGesture", "enablePlayGesture", "setExoPlayerParam", "maxInitialBitrate", "bandwidthFraction", "", "minDurForQualityMs", "maxDurForQualityMs", "minBufferMs", "maxBufferMs", "setFullScreenDelegate", "delegate", "setFullScreenDirection", "setInitialTime", "initialTime", "setIsShowBasicControls", "isShowBasicControls", "setLoop", "loop", "setMPVideoViewCallBack", "setMute", "isMute", "setObjectFit", "setPageGesture", "pageGesture", "setPageGestureInFullscreen", "pageGestureInFullscreen", "setPlayBtnOnClickListener", "click", "Landroid/view/View$OnClickListener;", "setPlayBtnPosition", "playBtnPosition", "setPreLoadVidePath", "setShowCenterPlayBtn", "showCenterPlayBtn", "setShowControlProgress", "showControlProgress", "setShowFullScreenBtn", "showFullScreenBtn", "setShowMuteBtn", "showMuteBtn", "setShowPlayBtn", "showPlayBtn", "setShowProgress", "showProgress", "setTitle", "title", "setVideoPath", "durationSec", "setVideoSource", "videoSource", "setVideoUrlInfo", "urlInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "currentInfo", "shouldDispatchEventToGestureController", "shouldHandleTouchEvent", "v", "e", "showCenterPlayBtnIfNeed", "showControlBar", "showCover", "start", "startWhenNetWorkConnect", "stop", "updateBottomProgressLayout", "updateControlBarDotPos", "list", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "updateLiveUI", "updateRealPlayTime", "updateStartTime", "Companion", "FullScreenDelegate", "MPVideoViewCallBack", "plugin-brandservice_release"})
public final class MPVideoView
  extends RelativeLayout
{
  public static final String TAG = "MicroMsg.MPVideoView";
  private static final int oAD = -1;
  private static final int oAE = 8;
  public static final MPVideoView.a oAF;
  private int acQ;
  private int atW;
  private boolean csJ;
  private int iuK;
  private boolean lpB;
  private boolean lpC;
  private String lpE;
  private boolean lpF;
  private boolean lpG;
  private boolean lpH;
  private boolean lpJ;
  private int lpK;
  private boolean lpM;
  private boolean lpN;
  public boolean lpO;
  private TextView lpe;
  private View lph;
  private View lpi;
  private TextView lpj;
  private LinearLayout lpk;
  private AppBrandDotPercentIndicator lpl;
  private TextView lpm;
  private ImageView lpn;
  private ImageView lpp;
  private ImageView lpq;
  private FrameLayout lpr;
  private boolean lpv;
  private boolean lpx;
  private boolean lpy;
  private com.tencent.mm.plugin.appbrand.jsapi.video.ui.a lpz;
  private boolean mIsMute;
  private boolean oAA;
  public boolean oAB;
  public boolean oAC;
  public MPExoVideoWrapper oAo;
  public MPVideoViewControlBar oAp;
  private FrameLayout oAq;
  private FrameLayout oAr;
  private FrameLayout oAs;
  private boolean oAt;
  private boolean oAu;
  private b oAv;
  private c oAw;
  private int oAx;
  private long oAy;
  private long oAz;
  private int videoHeight;
  private String videoPath;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(7587);
    oAF = new MPVideoView.a((byte)0);
    TAG = "MicroMsg.MPVideoView";
    oAD = -1;
    oAE = 8;
    AppMethodBeat.o(7587);
  }
  
  public MPVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(7584);
    this.acQ = oAD;
    init(paramContext);
    AppMethodBeat.o(7584);
  }
  
  public MPVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7585);
    this.acQ = oAD;
    init(paramContext);
    AppMethodBeat.o(7585);
  }
  
  public MPVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(7586);
    this.acQ = oAD;
    init(paramContext);
    AppMethodBeat.o(7586);
  }
  
  private final boolean bTO()
  {
    AppMethodBeat.i(175553);
    if (this.lpN)
    {
      AppMethodBeat.o(175553);
      return true;
    }
    boolean bool = bnz();
    if (!bnA())
    {
      AppMethodBeat.o(175553);
      return false;
    }
    AppMethodBeat.o(175553);
    return bool;
  }
  
  private final boolean bip()
  {
    AppMethodBeat.i(7537);
    Object localObject = TAG;
    boolean bool = this.lpB;
    MPExoVideoWrapper localMPExoVideoWrapper = this.oAo;
    if (localMPExoVideoWrapper == null) {
      p.gkB();
    }
    ae.i((String)localObject, "isLive %b %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localMPExoVideoWrapper.bzN) });
    if (!this.lpB)
    {
      localObject = this.oAo;
      if (localObject == null) {
        p.gkB();
      }
      if (!((MPExoVideoWrapper)localObject).bzN) {}
    }
    else
    {
      AppMethodBeat.o(7537);
      return true;
    }
    AppMethodBeat.o(7537);
    return false;
  }
  
  private final boolean bnA()
  {
    AppMethodBeat.i(7583);
    if ((!bnB()) && (((!bnx()) && (this.lpx)) || ((bnx()) && (this.lpy))))
    {
      AppMethodBeat.o(7583);
      return true;
    }
    AppMethodBeat.o(7583);
    return false;
  }
  
  private final boolean bnB()
  {
    AppMethodBeat.i(7538);
    View localView = this.lph;
    if (localView == null) {
      p.gkB();
    }
    if (localView.getVisibility() == 0)
    {
      AppMethodBeat.o(7538);
      return true;
    }
    AppMethodBeat.o(7538);
    return false;
  }
  
  private final void bnv()
  {
    AppMethodBeat.i(7574);
    MPVideoViewControlBar localMPVideoViewControlBar = this.oAp;
    if (localMPVideoViewControlBar == null) {
      p.gkB();
    }
    localMPVideoViewControlBar.bnv();
    AppMethodBeat.o(7574);
  }
  
  private final boolean bnz()
  {
    AppMethodBeat.i(7582);
    if (this.lpG)
    {
      MPExoVideoWrapper localMPExoVideoWrapper = this.oAo;
      if (localMPExoVideoWrapper == null) {
        p.gkB();
      }
      if ((!localMPExoVideoWrapper.bzN) && (!bnB()))
      {
        AppMethodBeat.o(7582);
        return true;
      }
    }
    AppMethodBeat.o(7582);
    return false;
  }
  
  private void clean()
  {
    AppMethodBeat.i(7555);
    ae.i(TAG, "clean");
    stop();
    Object localObject = this.oAo;
    if (localObject == null) {
      p.gkB();
    }
    ((MPExoVideoWrapper)localObject).onUIDestroy();
    localObject = this.oAp;
    if (localObject == null) {
      p.gkB();
    }
    ((MPVideoViewControlBar)localObject).onDestroy();
    AppMethodBeat.o(7555);
  }
  
  private final void init(Context paramContext)
  {
    AppMethodBeat.i(7539);
    LayoutInflater.from(paramContext).inflate(2131494957, (ViewGroup)this);
    this.oAo = ((MPExoVideoWrapper)findViewById(2131306410));
    paramContext = findViewById(2131303515);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lpe = ((TextView)paramContext);
    this.lph = findViewById(2131298814);
    this.lpi = findViewById(2131298828);
    paramContext = findViewById(2131298832);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lpj = ((TextView)paramContext);
    paramContext = findViewById(2131296505);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lpk = ((LinearLayout)paramContext);
    paramContext = findViewById(2131296506);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lpl = ((AppBrandDotPercentIndicator)paramContext);
    paramContext = findViewById(2131296502);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lpm = ((TextView)paramContext);
    paramContext = findViewById(2131296504);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lpn = ((ImageView)paramContext);
    paramContext = findViewById(2131303297);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lpp = ((ImageView)paramContext);
    paramContext = findViewById(2131303296);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lpq = ((ImageView)paramContext);
    paramContext = findViewById(2131303298);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lpr = ((FrameLayout)paramContext);
    paramContext = findViewById(2131303293);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.oAq = ((FrameLayout)paramContext);
    paramContext = findViewById(2131303299);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.oAr = ((FrameLayout)paramContext);
    paramContext = findViewById(2131303294);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.oAs = ((FrameLayout)paramContext);
    paramContext = this.lpl;
    if (paramContext == null) {
      p.gkB();
    }
    paramContext.setDotsNum(oAE);
    paramContext = findViewById(2131298827);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    ((ImageView)paramContext).setOnClickListener((View.OnClickListener)new MPVideoView.d(this));
    this.lpz = new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a(getContext(), (View)this, (a.b)new o(this));
    paramContext = this.oAo;
    if (paramContext == null) {
      p.gkB();
    }
    paramContext.setIMMVideoViewCallback((i.b)new p(this));
    this.oAp = new MPVideoViewControlBar(getContext());
    paramContext = this.oAo;
    if (paramContext == null) {
      p.gkB();
    }
    MPVideoViewControlBar localMPVideoViewControlBar = this.oAp;
    if (localMPVideoViewControlBar == null) {
      p.gkB();
    }
    paramContext.setVideoFooterView((h)localMPVideoViewControlBar);
    paramContext = this.oAp;
    if (paramContext == null) {
      p.gkB();
    }
    paramContext.hide();
    paramContext = this.oAp;
    if (paramContext == null) {
      p.gkB();
    }
    paramContext.setFullScreenBtnOnClickListener((View.OnClickListener)new MPVideoView.e(this));
    paramContext = this.oAp;
    if (paramContext == null) {
      p.gkB();
    }
    paramContext.setIplaySeekCallback((e.d)new g(this));
    paramContext = this.oAp;
    if (paramContext == null) {
      p.gkB();
    }
    paramContext.setOnPlayButtonClickListener((View.OnClickListener)new h(this));
    paramContext = this.oAp;
    if (paramContext == null) {
      p.gkB();
    }
    paramContext.setStatePorter((e.i)new i(this));
    paramContext = this.oAp;
    if (paramContext == null) {
      p.gkB();
    }
    paramContext.setMuteBtnOnClickListener((View.OnClickListener)new j(this));
    paramContext = this.oAp;
    if (paramContext == null) {
      p.gkB();
    }
    paramContext.setExitFullScreenBtnOnClickListener((View.OnClickListener)new MPVideoView.k(this));
    paramContext = this.oAp;
    if (paramContext == null) {
      p.gkB();
    }
    paramContext.a((e.f)new l(this));
    paramContext = this.oAp;
    if (paramContext == null) {
      p.gkB();
    }
    paramContext.setOnUpdateProgressLenListener((e.e)new m(this));
    paramContext = this.oAp;
    if (paramContext == null) {
      p.gkB();
    }
    paramContext.setSwitchResolutionListener((MPVideoViewControlBar.a)new n(this));
    paramContext = this.oAp;
    if (paramContext == null) {
      p.gkB();
    }
    paramContext.setSwitchSpeedListener((MPVideoViewControlBar.b)new f(this));
    paramContext = this.oAo;
    if (paramContext == null) {
      p.gkB();
    }
    paramContext = paramContext.getCoverIv();
    if (paramContext == null) {
      p.gkB();
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
    ae.i(TAG, "enableProgressGesture %b", new Object[] { Boolean.TRUE });
    this.lpG = true;
    setVideoSource(0);
    setConsumeTouchEvent(false);
    setIsShowBasicControls(true);
    AppMethodBeat.o(7539);
  }
  
  private static String tu(int paramInt)
  {
    AppMethodBeat.i(7580);
    String str = tv(paramInt / 60) + ":" + tv(paramInt % 60);
    AppMethodBeat.o(7580);
    return str;
  }
  
  private static String tv(int paramInt)
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
  
  public final boolean M(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(175552);
    p.h(paramMotionEvent, "event");
    if (bTO())
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.ui.a locala = this.lpz;
      if (locala != null) {
        locala.w(paramMotionEvent);
      }
      AppMethodBeat.o(175552);
      return true;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if ((this.lpv) && (!this.lpJ))
      {
        paramMotionEvent = this.oAp;
        if (paramMotionEvent == null) {
          p.gkB();
        }
        paramMotionEvent.bnQ();
      }
      paramMotionEvent = this.lph;
      if (paramMotionEvent == null) {
        p.gkB();
      }
      if ((paramMotionEvent.getVisibility() != 0) && (this.lpM)) {
        bnv();
      }
    }
    boolean bool = this.lpF;
    AppMethodBeat.o(175552);
    return bool;
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(175550);
    MPExoVideoWrapper localMPExoVideoWrapper = this.oAo;
    if (localMPExoVideoWrapper == null) {
      p.gkB();
    }
    localMPExoVideoWrapper.a(paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(175550);
  }
  
  public final void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, x paramx)
  {
    AppMethodBeat.i(7559);
    p.h(paramx, "msgInfo");
    ae.i(TAG, "setCover coverUrl=%s", new Object[] { paramString });
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7559);
      return;
    }
    this.lpE = paramString;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l locall = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.oxU;
    if (paramString == null) {
      p.gkB();
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(paramImageView, paramString, paramInt1, paramInt2, paramx);
    AppMethodBeat.o(7559);
  }
  
  public final void a(LinkedList<fu> paramLinkedList, fu paramfu)
  {
    AppMethodBeat.i(175551);
    p.h(paramLinkedList, "urlInfoList");
    p.h(paramfu, "currentInfo");
    MPVideoViewControlBar localMPVideoViewControlBar = this.oAp;
    if (localMPVideoViewControlBar == null) {
      p.gkB();
    }
    localMPVideoViewControlBar.a(paramLinkedList, paramfu);
    AppMethodBeat.o(175551);
  }
  
  public final void bTE()
  {
    AppMethodBeat.i(7561);
    MPExoVideoWrapper localMPExoVideoWrapper = this.oAo;
    if (localMPExoVideoWrapper == null) {
      p.gkB();
    }
    localMPExoVideoWrapper.bTE();
    AppMethodBeat.o(7561);
  }
  
  public final void bTF()
  {
    AppMethodBeat.i(7562);
    MPExoVideoWrapper localMPExoVideoWrapper = this.oAo;
    if (localMPExoVideoWrapper == null) {
      p.gkB();
    }
    localMPExoVideoWrapper.bTF();
    AppMethodBeat.o(7562);
  }
  
  public final void bTN()
  {
    long l1 = 0L;
    AppMethodBeat.i(209184);
    long l2 = System.currentTimeMillis();
    long l3 = this.oAy;
    if (this.oAz != 0L) {
      l1 = l2 - this.oAz;
    }
    this.oAy = (l1 + l3);
    this.oAz = l2;
    this.oAA = true;
    AppMethodBeat.o(209184);
  }
  
  public final void bTP()
  {
    AppMethodBeat.i(7578);
    MPVideoViewControlBar localMPVideoViewControlBar = this.oAp;
    if (localMPVideoViewControlBar != null) {
      localMPVideoViewControlBar.bTU();
    }
    localMPVideoViewControlBar = this.oAp;
    if (localMPVideoViewControlBar != null)
    {
      localMPVideoViewControlBar.show();
      AppMethodBeat.o(7578);
      return;
    }
    AppMethodBeat.o(7578);
  }
  
  public final boolean bTQ()
  {
    AppMethodBeat.i(7579);
    MPVideoViewControlBar localMPVideoViewControlBar = this.oAp;
    if (localMPVideoViewControlBar != null)
    {
      boolean bool = localMPVideoViewControlBar.bnS();
      AppMethodBeat.o(7579);
      return bool;
    }
    AppMethodBeat.o(7579);
    return false;
  }
  
  public final boolean bnx()
  {
    AppMethodBeat.i(7536);
    if (this.oAv == null)
    {
      ae.w(TAG, "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(7536);
      return false;
    }
    b localb = this.oAv;
    if (localb == null) {
      p.gkB();
    }
    boolean bool = localb.isFullScreen();
    AppMethodBeat.o(7536);
    return bool;
  }
  
  public final void cH(String paramString, int paramInt)
  {
    AppMethodBeat.i(7556);
    p.h(paramString, "videoPath");
    ae.i(TAG, "setVideoPath path=%s isLive=%s", new Object[] { paramString, Boolean.FALSE });
    if (bu.isNullOrNil(paramString))
    {
      ae.v(TAG, "setVideoPath videoPath empty");
      AppMethodBeat.o(7556);
      return;
    }
    this.videoPath = paramString;
    stop();
    this.lpB = false;
    MPExoVideoWrapper localMPExoVideoWrapper = this.oAo;
    if (localMPExoVideoWrapper == null) {
      p.gkB();
    }
    localMPExoVideoWrapper.setVideoSource(this.lpK);
    localMPExoVideoWrapper = this.oAo;
    if (localMPExoVideoWrapper == null) {
      p.gkB();
    }
    localMPExoVideoWrapper.cG(paramString, paramInt);
    if (this.oAx > 0)
    {
      paramString = this.oAo;
      if (paramString == null) {
        p.gkB();
      }
      paramString.W(this.oAx, this.csJ);
    }
    if (this.csJ)
    {
      ae.i(TAG, "setVideoPath autoPlay");
      start();
    }
    setMute(this.mIsMute);
    AppMethodBeat.o(7556);
  }
  
  public final boolean getAutoPlay()
  {
    return this.csJ;
  }
  
  public final FrameLayout getBackgroudContainerLayout()
  {
    return this.oAs;
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(7535);
    if (this.oAo != null)
    {
      MPExoVideoWrapper localMPExoVideoWrapper = this.oAo;
      if (localMPExoVideoWrapper == null) {
        p.gkB();
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.oAo;
    if (localMPExoVideoWrapper == null) {
      p.gkB();
    }
    int i = localMPExoVideoWrapper.getCurrPosMs();
    AppMethodBeat.o(7534);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(7533);
    MPExoVideoWrapper localMPExoVideoWrapper = this.oAo;
    if (localMPExoVideoWrapper == null) {
      p.gkB();
    }
    int i = localMPExoVideoWrapper.getCurrPosSec();
    AppMethodBeat.o(7533);
    return i;
  }
  
  public final FrameLayout getDotContainerLayout()
  {
    return this.oAr;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(7531);
    if (this.atW > 0)
    {
      i = this.atW;
      AppMethodBeat.o(7531);
      return i;
    }
    MPExoVideoWrapper localMPExoVideoWrapper = this.oAo;
    if (localMPExoVideoWrapper == null) {
      p.gkB();
    }
    int i = localMPExoVideoWrapper.getVideoDurationSec();
    AppMethodBeat.o(7531);
    return i;
  }
  
  public final int getEndPlayTime()
  {
    AppMethodBeat.i(7530);
    if ((getCurrPosMs() == 0) && (this.iuK != 0))
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
    return this.oAB;
  }
  
  public final boolean getPlayStart()
  {
    return this.oAt;
  }
  
  public final boolean getPlayStarted()
  {
    return this.oAu;
  }
  
  public final int getPlayStatus()
  {
    return this.iuK;
  }
  
  public final FrameLayout getPlayerAdContainerLayout()
  {
    return this.oAq;
  }
  
  public final long getRealPlayTime()
  {
    AppMethodBeat.i(7529);
    if ((!this.oAA) && (this.oAz != 0L) && (isPlaying()))
    {
      l1 = System.currentTimeMillis();
      long l2 = this.oAz;
      AppMethodBeat.o(7529);
      return l1 - l2;
    }
    long l1 = this.oAy;
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.oAo;
    if (localMPExoVideoWrapper == null) {
      p.gkB();
    }
    boolean bool = localMPExoVideoWrapper.isPlaying();
    AppMethodBeat.o(7550);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(7575);
    p.h(paramMotionEvent, "event");
    if (!bnx())
    {
      AppMethodBeat.o(7575);
      return false;
    }
    boolean bool = M(paramMotionEvent);
    AppMethodBeat.o(7575);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(7554);
    ae.i(TAG, "onUIDestroy");
    clean();
    AppMethodBeat.o(7554);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(7552);
    ae.i(TAG, "pause");
    MPExoVideoWrapper localMPExoVideoWrapper = this.oAo;
    if (localMPExoVideoWrapper == null) {
      p.gkB();
    }
    if (!localMPExoVideoWrapper.isPlaying())
    {
      AppMethodBeat.o(7552);
      return;
    }
    localMPExoVideoWrapper = this.oAo;
    if (localMPExoVideoWrapper == null) {
      p.gkB();
    }
    localMPExoVideoWrapper.pause();
    AppMethodBeat.o(7552);
  }
  
  public final void q(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(7576);
    ae.i(TAG, "operateFullScreen toFullScreen:%b direction:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.oAv == null)
    {
      ae.w(TAG, "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(7576);
      return;
    }
    if (paramBoolean == bnx())
    {
      ae.i(TAG, "operateFullScreen current same");
      AppMethodBeat.o(7576);
      return;
    }
    if (paramInt == oAD) {
      if (this.acQ == oAD)
      {
        paramInt = 90;
        ae.i(TAG, "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject = this.oAv;
        if (localObject == null) {
          p.gkB();
        }
        ((b)localObject).th(paramInt);
        localObject = this.oAp;
        if (localObject != null) {
          ((MPVideoViewControlBar)localObject).setDirection(paramInt);
        }
        localObject = this.oAp;
        if (localObject != null) {
          ((MPVideoViewControlBar)localObject).bnT();
        }
        localObject = this.oAo;
        if (localObject != null)
        {
          ((MPExoVideoWrapper)localObject).jEw = true;
          AppMethodBeat.o(7576);
          return;
          paramInt = this.acQ;
          break;
        }
        AppMethodBeat.o(7576);
        return;
      }
      Object localObject = this.oAv;
      if (localObject != null) {
        ((b)localObject).blp();
      }
      localObject = this.oAp;
      if (localObject != null) {
        ((MPVideoViewControlBar)localObject).blp();
      }
      localObject = this.oAo;
      if (localObject != null)
      {
        ((MPExoVideoWrapper)localObject).jEw = false;
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
    ae.i(TAG, "setAutoPlay =%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.csJ = paramBoolean;
    if ((this.csJ) && (this.iuK == 0)) {
      this.iuK = 1;
    }
    AppMethodBeat.o(7547);
  }
  
  public final void setBackgroudContainerLayout(FrameLayout paramFrameLayout)
  {
    this.oAs = paramFrameLayout;
  }
  
  public final void setConsumeTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(7540);
    ae.i(TAG, "setConsumeTouchEvent value=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpF = paramBoolean;
    AppMethodBeat.o(7540);
  }
  
  public final void setDotContainerLayout(FrameLayout paramFrameLayout)
  {
    this.oAr = paramFrameLayout;
  }
  
  public final void setDuration(int paramInt)
  {
    AppMethodBeat.i(7532);
    if (paramInt <= 0)
    {
      ae.i(TAG, "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(7532);
      return;
    }
    TextView localTextView = this.lpj;
    if (localTextView == null) {
      p.gkB();
    }
    localTextView.setText((CharSequence)tu(paramInt));
    this.atW = paramInt;
    AppMethodBeat.o(7532);
  }
  
  public final void setEnablePlayGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(7546);
    ae.i(TAG, "setEnablePlayGesture: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpN = paramBoolean;
    AppMethodBeat.o(7546);
  }
  
  public final void setFullScreenDelegate(b paramb)
  {
    AppMethodBeat.i(7572);
    p.h(paramb, "delegate");
    this.oAv = paramb;
    AppMethodBeat.o(7572);
  }
  
  public final void setFullScreenDirection(int paramInt)
  {
    AppMethodBeat.i(7568);
    ae.i(TAG, "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.acQ = paramInt;
    AppMethodBeat.o(7568);
  }
  
  public final void setInitialTime(int paramInt)
  {
    AppMethodBeat.i(7571);
    ae.i(TAG, "setInitialTime initialTime=%s", new Object[] { Integer.valueOf(paramInt) });
    this.oAx = paramInt;
    AppMethodBeat.o(7571);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(7558);
    ae.i(TAG, "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpv = paramBoolean;
    if (this.oAp != null)
    {
      if (this.lpv)
      {
        localMPVideoViewControlBar = this.oAp;
        if (localMPVideoViewControlBar == null) {
          p.gkB();
        }
        localMPVideoViewControlBar.bnR();
        AppMethodBeat.o(7558);
        return;
      }
      MPVideoViewControlBar localMPVideoViewControlBar = this.oAp;
      if (localMPVideoViewControlBar == null) {
        p.gkB();
      }
      localMPVideoViewControlBar.hide();
    }
    AppMethodBeat.o(7558);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(7549);
    ae.i(TAG, "setLoop loop=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpC = paramBoolean;
    AppMethodBeat.o(7549);
  }
  
  public final void setMPVideoViewCallBack(c paramc)
  {
    AppMethodBeat.i(7573);
    p.h(paramc, "delegate");
    this.oAw = paramc;
    AppMethodBeat.o(7573);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(7567);
    ae.i(TAG, "setMute isMute=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    Object localObject = this.oAo;
    if (localObject == null) {
      p.gkB();
    }
    ((MPExoVideoWrapper)localObject).setMute(paramBoolean);
    localObject = this.oAp;
    if (localObject == null) {
      p.gkB();
    }
    ((MPVideoViewControlBar)localObject).setMuteBtnState(paramBoolean);
    AppMethodBeat.o(7567);
  }
  
  public final void setNeedHandleTouchEvent(boolean paramBoolean)
  {
    this.oAB = paramBoolean;
  }
  
  public final void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(7569);
    ae.i(TAG, "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpx = paramBoolean;
    AppMethodBeat.o(7569);
  }
  
  public final void setPageGestureInFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(7570);
    ae.i(TAG, "setPageGestureInFullscreen pageGestureInFullscreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpy = paramBoolean;
    AppMethodBeat.o(7570);
  }
  
  public final void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(7577);
    p.h(paramOnClickListener, "click");
    MPVideoViewControlBar localMPVideoViewControlBar = this.oAp;
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
    ae.i(TAG, "setPlayBtnPosition: %s", new Object[] { paramString });
    if ((!bu.isNullOrNil(paramString)) && (n.H(paramString, "center", true)))
    {
      paramString = this.oAp;
      if (paramString == null) {
        p.gkB();
      }
      paramString.setPlayBtnInCenterPosition(true);
      AppMethodBeat.o(7545);
      return;
    }
    paramString = this.oAp;
    if (paramString == null) {
      p.gkB();
    }
    paramString.setPlayBtnInCenterPosition(false);
    AppMethodBeat.o(7545);
  }
  
  public final void setPlayStatus(int paramInt)
  {
    this.iuK = paramInt;
  }
  
  public final void setPlayerAdContainerLayout(FrameLayout paramFrameLayout)
  {
    this.oAq = paramFrameLayout;
  }
  
  public final void setShowCenterPlayBtn(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(7566);
    ae.i(TAG, "setPlayBtnInCenterPosition %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpJ = paramBoolean;
    Object localObject = this.lph;
    if (localObject == null) {
      p.gkB();
    }
    if (paramBoolean)
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.lpi;
      if (localObject == null) {
        p.gkB();
      }
      if (!paramBoolean) {
        break label131;
      }
    }
    label131:
    for (int i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      if ((this.lpJ) && (this.oAp != null))
      {
        localObject = this.oAp;
        if (localObject == null) {
          p.gkB();
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
    ae.i(TAG, "setShowControlProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.oAp;
    if (localMPVideoViewControlBar == null) {
      p.gkB();
    }
    if ((paramBoolean) && (!bip())) {}
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
    ae.i(TAG, "setShowFullScreenBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.oAp;
    if (localMPVideoViewControlBar == null) {
      p.gkB();
    }
    localMPVideoViewControlBar.setShowFullScreenBtn(paramBoolean);
    AppMethodBeat.o(7564);
  }
  
  public final void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(7541);
    ae.i(TAG, "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.oAp;
    if (localMPVideoViewControlBar == null) {
      p.gkB();
    }
    localMPVideoViewControlBar.setShowMuteBtn(paramBoolean);
    AppMethodBeat.o(7541);
  }
  
  public final void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(7565);
    ae.i(TAG, "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.oAp;
    if (localMPVideoViewControlBar == null) {
      p.gkB();
    }
    localMPVideoViewControlBar.setShowPlayBtn(paramBoolean);
    AppMethodBeat.o(7565);
  }
  
  public final void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(7563);
    ae.i(TAG, "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpH = paramBoolean;
    MPVideoViewControlBar localMPVideoViewControlBar = this.oAp;
    if (localMPVideoViewControlBar == null) {
      p.gkB();
    }
    if ((paramBoolean) && (!bip())) {}
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
    ae.i(TAG, "setTitle %s", new Object[] { paramString });
    MPVideoViewControlBar localMPVideoViewControlBar = this.oAp;
    if (localMPVideoViewControlBar == null) {
      p.gkB();
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
    ae.i(TAG, "setVideoSource =%d", new Object[] { Integer.valueOf(paramInt) });
    this.lpK = paramInt;
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.oAo;
    if (localMPExoVideoWrapper == null) {
      p.gkB();
    }
    ae.i((String)localObject, localMPExoVideoWrapper.isPlaying());
    localObject = this.oAo;
    if (localObject == null) {
      p.gkB();
    }
    if (((MPExoVideoWrapper)localObject).isPlaying())
    {
      AppMethodBeat.o(7551);
      return;
    }
    this.oAt = true;
    if (this.lpv)
    {
      localObject = this.oAp;
      if (localObject == null) {
        p.gkB();
      }
      ((MPVideoViewControlBar)localObject).bnW();
    }
    localObject = this.lph;
    if (localObject == null) {
      p.gkB();
    }
    ((View)localObject).setVisibility(8);
    localObject = this.oAo;
    if (localObject == null) {
      p.gkB();
    }
    ((MPExoVideoWrapper)localObject).start();
    bTF();
    AppMethodBeat.o(7551);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(7553);
    ae.i(TAG, "stop");
    Object localObject = this.oAo;
    if (localObject == null) {
      p.gkB();
    }
    if (!((MPExoVideoWrapper)localObject).isPlaying())
    {
      AppMethodBeat.o(7553);
      return;
    }
    localObject = this.oAo;
    if (localObject == null) {
      p.gkB();
    }
    ((MPExoVideoWrapper)localObject).GB();
    localObject = this.oAp;
    if (localObject == null) {
      p.gkB();
    }
    ((MPVideoViewControlBar)localObject).bnX();
    bTE();
    AppMethodBeat.o(7553);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "enterFullScreen", "", "direction", "", "quitFullScreen", "plugin-brandservice_release"})
  public static abstract interface b
  {
    public abstract void blp();
    
    public abstract boolean isFullScreen();
    
    public abstract void th(int paramInt);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "", "onControlbarVisible", "", "visible", "", "onEndDragProgress", "onGetVideoSize", "width", "", "height", "onHideSwitchResolutionLayout", "onHideSwitchSpeedLayout", "onPlayError", "errorMsg", "", "errorCode", "onSeekPre", "onSeekTo", "time", "onStartDragProgress", "onUpdateProgress", "progressLen", "totalLen", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoPrepare", "firstRenderTime", "", "onVideoWaiting", "onVideoWaitingEnd", "resolutionBtnClick", "speedBtnClick", "switchResolution", "beforeType", "afterType", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "switchSpeed", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
  public static abstract interface c
  {
    public abstract void YH(String paramString);
    
    public abstract void a(int paramInt1, int paramInt2, fu paramfu);
    
    public abstract void a(c.a parama1, c.a parama2);
    
    public abstract void aqS();
    
    public abstract void bSS();
    
    public abstract void bST();
    
    public abstract void bSU();
    
    public abstract void bSV();
    
    public abstract void bSW();
    
    public abstract void bSX();
    
    public abstract void bSY();
    
    public abstract void bnH();
    
    public abstract void jo(boolean paramBoolean);
    
    public abstract void onVideoEnded();
    
    public abstract void onVideoPause();
    
    public abstract void onVideoPlay();
    
    public abstract void onVideoWaiting();
    
    public abstract void tH(long paramLong);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$10", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$SwitchSpeedListener;", "onHideSwitchSpeedLayout", "", "speedBtnClick", "switchSpeed", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
  public static final class f
    implements MPVideoViewControlBar.b
  {
    public final void a(fu paramfu, c.a parama1, c.a parama2)
    {
      AppMethodBeat.i(209180);
      Object localObject = MPVideoView.k(this.oAG);
      if (localObject != null) {
        ((MPVideoView.c)localObject).a(parama1, parama2);
      }
      this.oAG.setAutoPlay(this.oAG.isPlaying());
      int j = this.oAG.getCurrPosMs();
      parama2 = MPVideoView.h(this.oAG);
      if (parama2 == null) {
        p.gkB();
      }
      parama1 = parama2.ozy;
      if (parama1 != null)
      {
        parama1 = parama1.getBitmap();
        if ((parama1 == null) || (parama1.isRecycled())) {
          break label261;
        }
        localObject = parama2.ozu;
        if (localObject != null) {
          ((ImageView)localObject).setImageBitmap(parama1);
        }
      }
      for (;;)
      {
        parama1 = parama2.ozu;
        if (parama1 != null) {
          parama1.setVisibility(0);
        }
        parama2.tO(0L);
        parama1 = MPVideoView.h(this.oAG);
        if (parama1 == null) {
          p.gkB();
        }
        parama1.bTG();
        parama1 = this.oAG;
        int i = j;
        if (j == 0) {
          i = 1;
        }
        parama1.setInitialTime(i);
        parama1 = this.oAG;
        if (paramfu == null) {
          p.gkB();
        }
        paramfu = paramfu.url;
        p.g(paramfu, "info!!.url");
        parama1.cH(paramfu, this.oAG.getDuration());
        if (!MPVideoView.E(this.oAG))
        {
          paramfu = MPVideoView.h(this.oAG);
          if (paramfu == null) {
            p.gkB();
          }
          paramfu.pause();
        }
        paramfu = MPVideoView.c(this.oAG);
        if (paramfu == null) {
          break label279;
        }
        paramfu.hide();
        AppMethodBeat.o(209180);
        return;
        parama1 = null;
        break;
        label261:
        parama1 = parama2.ozu;
        if (parama1 != null) {
          parama1.setImageResource(2131233299);
        }
      }
      label279:
      AppMethodBeat.o(209180);
    }
    
    public final void bTS()
    {
      AppMethodBeat.i(179030);
      MPVideoView.k(this.oAG);
      AppMethodBeat.o(179030);
    }
    
    public final void bTT()
    {
      AppMethodBeat.i(179031);
      MPVideoView.k(this.oAG);
      AppMethodBeat.o(179031);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$2", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-brandservice_release"})
  public static final class g
    implements e.d
  {
    public final void aqS()
    {
      AppMethodBeat.i(7488);
      ae.i(MPVideoView.access$getTAG$cp(), "onSeekPre");
      if (this.oAG.isPlaying()) {
        this.oAG.bTN();
      }
      MPVideoView.c localc = MPVideoView.k(this.oAG);
      if (localc != null)
      {
        localc.aqS();
        AppMethodBeat.o(7488);
        return;
      }
      AppMethodBeat.o(7488);
    }
    
    public final void nP(int paramInt)
    {
      AppMethodBeat.i(7489);
      MPVideoView.a(this.oAG, paramInt * 1000);
      MPVideoView.m(this.oAG);
      MPVideoView.c localc = MPVideoView.k(this.oAG);
      if (localc != null)
      {
        localc.bSU();
        AppMethodBeat.o(7489);
        return;
      }
      AppMethodBeat.o(7489);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(MPVideoView paramMPVideoView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7490);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = MPVideoView.h(this.oAG);
      if (paramView == null) {
        p.gkB();
      }
      if (paramView.isPlaying()) {
        this.oAG.pause();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7490);
        return;
        this.oAG.start();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$4", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$StatePorter;", "getCacheTime", "", "getTotalTime", "plugin-brandservice_release"})
  public static final class i
    implements e.i
  {
    public final int bnD()
    {
      AppMethodBeat.i(7491);
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.oAG);
      if (localMPExoVideoWrapper == null) {
        p.gkB();
      }
      int i = localMPExoVideoWrapper.getCacheTimeSec();
      AppMethodBeat.o(7491);
      return i;
    }
    
    public final int bnE()
    {
      AppMethodBeat.i(7492);
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.oAG);
      if (localMPExoVideoWrapper == null) {
        p.gkB();
      }
      int i = localMPExoVideoWrapper.getVideoDurationSec();
      AppMethodBeat.o(7492);
      return i;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(MPVideoView paramMPVideoView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(7493);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.oAG;
      if (!MPVideoView.B(this.oAG)) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.setMute(bool);
        paramView = m.oyh;
        m.a.Am(34);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(7493);
        return;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "visible", "", "onVisibilityChanged"})
  static final class l
    implements e.f
  {
    l(MPVideoView paramMPVideoView) {}
    
    public final void onVisibilityChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(7495);
      MPVideoView.A(this.oAG);
      Object localObject1 = MPVideoView.k(this.oAG);
      if (localObject1 != null) {
        ((MPVideoView.c)localObject1).jo(paramBoolean);
      }
      localObject1 = MPVideoView.h(this.oAG);
      if (localObject1 != null)
      {
        Object localObject2;
        if (paramBoolean)
        {
          ((MPExoVideoWrapper)localObject1).ozN = true;
          localObject2 = ((MPExoVideoWrapper)localObject1).ozu;
          if ((localObject2 == null) || (((ImageView)localObject2).getVisibility() != 0))
          {
            localObject2 = ((MPExoVideoWrapper)localObject1).ozv;
            if (localObject2 != null) {
              if (((TextView)localObject2).getVisibility() != 0) {
                break label265;
              }
            }
          }
          else
          {
            ae.i(MPExoVideoWrapper.TAG, "hide switchingResolution onControllerBarVisible");
            if (((MPExoVideoWrapper)localObject1).ozM)
            {
              localObject2 = ((MPExoVideoWrapper)localObject1).ozu;
              if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 0)) {
                ((MPExoVideoWrapper)localObject1).ozL = true;
              }
            }
            localObject2 = ((MPExoVideoWrapper)localObject1).ozu;
            if (localObject2 != null) {
              ((ImageView)localObject2).setVisibility(8);
            }
            localObject1 = ((MPExoVideoWrapper)localObject1).ozv;
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
          ((MPExoVideoWrapper)localObject1).ozN = false;
          if (((MPExoVideoWrapper)localObject1).ozL)
          {
            ae.i(MPExoVideoWrapper.TAG, "show switchingResolution onControllerBarVisible isSwitchingResolution = " + ((MPExoVideoWrapper)localObject1).ozM);
            ((MPExoVideoWrapper)localObject1).ozL = false;
            if (((MPExoVideoWrapper)localObject1).ozM)
            {
              ((MPExoVideoWrapper)localObject1).bTC();
              AppMethodBeat.o(7495);
              return;
            }
            localObject2 = ((MPExoVideoWrapper)localObject1).ozu;
            if (localObject2 != null) {
              ((ImageView)localObject2).setVisibility(8);
            }
            localObject2 = ((MPExoVideoWrapper)localObject1).ozv;
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(0);
            }
            ((MPExoVideoWrapper)localObject1).bTD();
          }
        }
        label265:
        AppMethodBeat.o(7495);
        return;
      }
      AppMethodBeat.o(7495);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "progressLen", "", "totalLen", "onProgressChanged"})
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
        Object localObject = MPVideoView.C(this.oAG);
        if (localObject == null) {
          p.gkB();
        }
        paramInt1 = i * ((ImageView)localObject).getWidth() / paramInt2;
        localObject = MPVideoView.D(this.oAG);
        if (localObject == null) {
          p.gkB();
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
        ImageView localImageView = MPVideoView.D(this.oAG);
        if (localImageView == null) {
          p.gkB();
        }
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = MPVideoView.D(this.oAG);
        if (localObject == null) {
          p.gkB();
        }
        ((ImageView)localObject).requestLayout();
        localObject = MPVideoView.k(this.oAG);
        if (localObject != null)
        {
          ((MPVideoView.c)localObject).bSW();
          AppMethodBeat.o(7496);
          return;
        }
        AppMethodBeat.o(7496);
        return;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$9", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$SwitchResolutionListener;", "onHideSwitchResolutionLayout", "", "resolutionBtnClick", "switchResolution", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "beforeType", "", "afterType", "plugin-brandservice_release"})
  public static final class n
    implements MPVideoViewControlBar.a
  {
    public final void a(fu paramfu, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7498);
      Object localObject = MPVideoView.k(this.oAG);
      if (localObject != null) {
        ((MPVideoView.c)localObject).a(paramInt1, paramInt2, paramfu);
      }
      this.oAG.setAutoPlay(this.oAG.isPlaying());
      paramInt1 = this.oAG.getCurrPosMs();
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.oAG);
      if (localMPExoVideoWrapper == null) {
        p.gkB();
      }
      if (paramfu == null) {
        p.gkB();
      }
      String str = paramfu.FQA;
      ae.i(MPExoVideoWrapper.TAG, "onSetResolution %b", new Object[] { Boolean.valueOf(localMPExoVideoWrapper.ozN) });
      localMPExoVideoWrapper.ozM = true;
      localMPExoVideoWrapper.ozx = str;
      localObject = localMPExoVideoWrapper.ozy;
      if (localObject != null)
      {
        localObject = ((MPExoVideoTextureView)localObject).getBitmap();
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label348;
        }
        ImageView localImageView = localMPExoVideoWrapper.ozu;
        if (localImageView != null) {
          localImageView.setImageBitmap((Bitmap)localObject);
        }
        label169:
        localObject = localMPExoVideoWrapper.ozv;
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)localMPExoVideoWrapper.getContext().getString(2131761350, new Object[] { str }));
        }
        localMPExoVideoWrapper.bTC();
        localMPExoVideoWrapper.tO(0L);
        localObject = MPVideoView.h(this.oAG);
        if (localObject == null) {
          p.gkB();
        }
        ((MPExoVideoWrapper)localObject).bTG();
        localObject = this.oAG;
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
        localObject = this.oAG;
        paramfu = paramfu.url;
        p.g(paramfu, "info!!.url");
        ((MPVideoView)localObject).cH(paramfu, this.oAG.getDuration());
        if (!MPVideoView.E(this.oAG))
        {
          paramfu = MPVideoView.h(this.oAG);
          if (paramfu == null) {
            p.gkB();
          }
          paramfu.pause();
        }
        paramfu = MPVideoView.c(this.oAG);
        if (paramfu == null) {
          break label373;
        }
        paramfu.hide();
        AppMethodBeat.o(7498);
        return;
        localObject = null;
        break;
        localObject = localMPExoVideoWrapper.ozu;
        if (localObject == null) {
          break label169;
        }
        ((ImageView)localObject).setImageResource(2131233299);
        break label169;
      }
      label373:
      AppMethodBeat.o(7498);
    }
    
    public final void bSX()
    {
      AppMethodBeat.i(7499);
      MPVideoView.c localc = MPVideoView.k(this.oAG);
      if (localc != null)
      {
        localc.bSX();
        AppMethodBeat.o(7499);
        return;
      }
      AppMethodBeat.o(7499);
    }
    
    public final void bSY()
    {
      AppMethodBeat.i(7497);
      MPVideoView.c localc = MPVideoView.k(this.oAG);
      if (localc != null)
      {
        localc.bSY();
        AppMethodBeat.o(7497);
        return;
      }
      AppMethodBeat.o(7497);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initGestureController$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$GestureOperationHelper;", "canAdjustBrightness", "", "canAdjustProgress", "canAdjustVolume", "getCurrentPosition", "", "onAdjustBrightness", "", "brightness", "", "onAdjustVolume", "volumePercent", "onCanHandleGesture", "onDoubleTap", "onDragProgress", "startDragPos", "distanceX", "onEndAdjustBrightness", "onEndAdjustVolume", "onEndDragProgress", "dragPosition", "totalDistanceX", "onSingleTap", "onStartDragProgress", "plugin-brandservice_release"})
  public static final class o
    implements a.b
  {
    public final void aC(float paramFloat)
    {
      AppMethodBeat.i(7506);
      if (!MPVideoView.r(this.oAG))
      {
        AppMethodBeat.o(7506);
        return;
      }
      ae.d(MPVideoView.access$getTAG$cp(), "onAdjustVolume:".concat(String.valueOf(paramFloat)));
      Object localObject = MPVideoView.n(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      ((AppBrandDotPercentIndicator)localObject).setPercent(paramFloat);
      localObject = MPVideoView.o(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      ((TextView)localObject).setText(2131760999);
      localObject = MPVideoView.p(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      ((ImageView)localObject).setImageResource(2131231041);
      localObject = MPVideoView.q(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      ((LinearLayout)localObject).setVisibility(0);
      MPVideoView.f(this.oAG);
      AppMethodBeat.o(7506);
    }
    
    public final void aD(float paramFloat)
    {
      AppMethodBeat.i(7507);
      if (!MPVideoView.r(this.oAG))
      {
        AppMethodBeat.o(7507);
        return;
      }
      ae.d(MPVideoView.access$getTAG$cp(), "onAdjustBrightness:".concat(String.valueOf(paramFloat)));
      Object localObject = MPVideoView.n(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      ((AppBrandDotPercentIndicator)localObject).setPercent(paramFloat);
      localObject = MPVideoView.o(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      ((TextView)localObject).setText(2131760998);
      localObject = MPVideoView.p(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      ((ImageView)localObject).setImageResource(2131231033);
      localObject = MPVideoView.q(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      ((LinearLayout)localObject).setVisibility(0);
      MPVideoView.f(this.oAG);
      AppMethodBeat.o(7507);
    }
    
    public final void bnF()
    {
      AppMethodBeat.i(7500);
      ae.d(MPVideoView.access$getTAG$cp(), "onSingleTap");
      if ((MPVideoView.a(this.oAG)) && (!MPVideoView.b(this.oAG)))
      {
        localObject = MPVideoView.c(this.oAG);
        if (localObject == null) {
          p.gkB();
        }
        ((MPVideoViewControlBar)localObject).bnQ();
      }
      Object localObject = MPVideoView.d(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      if ((((View)localObject).getVisibility() != 0) && (MPVideoView.e(this.oAG))) {
        MPVideoView.f(this.oAG);
      }
      AppMethodBeat.o(7500);
    }
    
    public final void bnG()
    {
      AppMethodBeat.i(7501);
      ae.d(MPVideoView.access$getTAG$cp(), "onDoubleTap");
      if (MPVideoView.g(this.oAG))
      {
        Object localObject = MPVideoView.h(this.oAG);
        if (localObject == null) {
          p.gkB();
        }
        if (((MPExoVideoWrapper)localObject).isPlaying())
        {
          this.oAG.pause();
          localObject = m.oyh;
          m.a.Am(35);
          AppMethodBeat.o(7501);
          return;
        }
        this.oAG.start();
        localObject = m.oyh;
        m.a.Am(36);
      }
      AppMethodBeat.o(7501);
    }
    
    public final void bnH()
    {
      AppMethodBeat.i(7502);
      if (!MPVideoView.i(this.oAG))
      {
        AppMethodBeat.o(7502);
        return;
      }
      Object localObject = MPVideoView.j(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      ((TextView)localObject).setVisibility(0);
      MPVideoView.f(this.oAG);
      if (this.oAG.isPlaying()) {
        this.oAG.bTN();
      }
      localObject = MPVideoView.k(this.oAG);
      if (localObject != null)
      {
        ((MPVideoView.c)localObject).bnH();
        AppMethodBeat.o(7502);
        return;
      }
      AppMethodBeat.o(7502);
    }
    
    public final void bnI()
    {
      AppMethodBeat.i(7508);
      if (!MPVideoView.r(this.oAG))
      {
        AppMethodBeat.o(7508);
        return;
      }
      Object localObject = MPVideoView.q(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      ((LinearLayout)localObject).setVisibility(8);
      MPVideoView.l(this.oAG);
      localObject = m.oyh;
      m.a.Am(41);
      AppMethodBeat.o(7508);
    }
    
    public final void bnJ()
    {
      AppMethodBeat.i(7509);
      if (!MPVideoView.r(this.oAG))
      {
        AppMethodBeat.o(7509);
        return;
      }
      Object localObject = MPVideoView.q(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      ((LinearLayout)localObject).setVisibility(8);
      MPVideoView.l(this.oAG);
      localObject = m.oyh;
      m.a.Am(39);
      AppMethodBeat.o(7509);
    }
    
    public final boolean bnK()
    {
      AppMethodBeat.i(224161);
      boolean bool = MPVideoView.r(this.oAG);
      AppMethodBeat.o(224161);
      return bool;
    }
    
    public final boolean bnL()
    {
      AppMethodBeat.i(224162);
      boolean bool = MPVideoView.r(this.oAG);
      AppMethodBeat.o(224162);
      return bool;
    }
    
    public final boolean bnM()
    {
      AppMethodBeat.i(7512);
      boolean bool = MPVideoView.i(this.oAG);
      AppMethodBeat.o(7512);
      return bool;
    }
    
    public final int getCurrentPosition()
    {
      AppMethodBeat.i(7505);
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.oAG);
      if (localMPExoVideoWrapper == null) {
        p.gkB();
      }
      int i = localMPExoVideoWrapper.getCurrPosSec();
      AppMethodBeat.o(7505);
      return i;
    }
    
    public final int k(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(7503);
      if (!MPVideoView.i(this.oAG))
      {
        AppMethodBeat.o(7503);
        return 0;
      }
      ae.i(MPVideoView.access$getTAG$cp(), "onDragProgress:" + paramInt + '/' + paramFloat);
      Object localObject = MPVideoView.h(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      paramInt = ((MPExoVideoWrapper)localObject).getVideoDurationSec();
      int i = com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a.c(paramFloat, this.oAG.getMeasuredWidth(), getCurrentPosition(), paramInt);
      localObject = com.tencent.mm.plugin.appbrand.jsapi.video.l.sz(paramInt * 1000L);
      TextView localTextView = MPVideoView.j(this.oAG);
      if (localTextView == null) {
        p.gkB();
      }
      localTextView.setText((CharSequence)(com.tencent.mm.plugin.appbrand.jsapi.video.l.sz(i * 1000L) + "/" + (String)localObject));
      localObject = MPVideoView.c(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      ((MPVideoViewControlBar)localObject).seek(i);
      localObject = MPVideoView.c(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      if (((MPVideoViewControlBar)localObject).bnS())
      {
        localObject = MPVideoView.c(this.oAG);
        if (localObject == null) {
          p.gkB();
        }
        ((MPVideoViewControlBar)localObject).bnY();
      }
      AppMethodBeat.o(7503);
      return i;
    }
    
    public final void l(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(7504);
      if (!MPVideoView.i(this.oAG))
      {
        AppMethodBeat.o(7504);
        return;
      }
      Object localObject = MPVideoView.j(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      ((TextView)localObject).setVisibility(8);
      MPVideoView.l(this.oAG);
      localObject = MPVideoView.h(this.oAG);
      if (localObject == null) {
        p.gkB();
      }
      int i = ((MPExoVideoWrapper)localObject).getCurrPosSec();
      ae.i(MPVideoView.access$getTAG$cp(), "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Float.valueOf(paramFloat) });
      MPVideoView.a(this.oAG, paramInt * 1000);
      MPVideoView.m(this.oAG);
      localObject = MPVideoView.k(this.oAG);
      if (localObject != null)
      {
        ((MPVideoView.c)localObject).bST();
        AppMethodBeat.o(7504);
        return;
      }
      AppMethodBeat.o(7504);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initVideoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-brandservice_release"})
  public static final class p
    implements i.b
  {
    public final void c(String paramString1, String paramString2, final String paramString3, final int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7521);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      p.h(paramString3, "errorMsg");
      ae.i(MPVideoView.access$getTAG$cp(), "onError errorMsg=%s what=%d extra=%d", new Object[] { paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      ar.f((Runnable)new a(this, paramString3, paramInt1));
      AppMethodBeat.o(7521);
    }
    
    public final void d(String paramString1, String paramString2, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(7524);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      this.oAG.setVideoWidth(paramInt1);
      this.oAG.setVideoHeight(paramInt2);
      paramString1 = MPVideoView.k(this.oAG);
      if (paramString1 != null) {
        paramString1.bSS();
      }
      ar.f((Runnable)new b(this, paramInt1, paramInt2));
      AppMethodBeat.o(7524);
    }
    
    public final void ds(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7522);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      ae.i(MPVideoView.access$getTAG$cp(), "onPrepared");
      ar.f((Runnable)new c(this));
      AppMethodBeat.o(7522);
    }
    
    public final void dt(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7523);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      ae.i(MPVideoView.access$getTAG$cp(), "onVideoEnded");
      ar.f((Runnable)new d(this));
      AppMethodBeat.o(7523);
    }
    
    public final void du(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7525);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      ae.i(MPVideoView.access$getTAG$cp(), "onVideoPause");
      this.oAG.bTN();
      paramString1 = MPVideoView.k(this.oAG);
      if (paramString1 != null) {
        paramString1.onVideoPause();
      }
      if (this.oAG.getPlayStatus() != 4) {
        this.oAG.setPlayStatus(3);
      }
      paramString1 = MPVideoView.h(this.oAG);
      if (paramString1 == null) {
        p.gkB();
      }
      paramString1 = paramString1.ozv;
      if (paramString1 == null) {
        p.gkB();
      }
      if (paramString1.getVisibility() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        ar.o((Runnable)new e(this), 1000L);
        AppMethodBeat.o(7525);
        return;
      }
      this.oAG.bTP();
      AppMethodBeat.o(7525);
    }
    
    public final void dv(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7526);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      ar.f((Runnable)new f(this));
      AppMethodBeat.o(7526);
    }
    
    public final void dw(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7527);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      ae.i(MPVideoView.access$getTAG$cp(), "onVideoWaiting");
      ar.f((Runnable)new g(this));
      AppMethodBeat.o(7527);
    }
    
    public final void dx(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7528);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      ar.f((Runnable)new h(this));
      AppMethodBeat.o(7528);
    }
    
    public final void eX(String paramString1, String paramString2)
    {
      AppMethodBeat.i(209183);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      AppMethodBeat.o(209183);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoView.p paramp, String paramString, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(7513);
        this.oAH.oAG.bTN();
        MPVideoView.c localc = MPVideoView.k(this.oAH.oAG);
        if (localc != null) {
          localc.YH(paramString3);
        }
        this.oAH.oAG.setPlayStatus(4);
        AppMethodBeat.o(7513);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(MPVideoView.p paramp, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(7514);
        int i = MPVideoView.y(this.oAH.oAG);
        Object localObject = MPVideoView.oAF;
        if (i == MPVideoView.bTR())
        {
          localObject = this.oAH.oAG;
          if (paramInt1 >= paramInt2) {
            break label89;
          }
        }
        label89:
        for (i = 0;; i = 90)
        {
          MPVideoView.b((MPVideoView)localObject, i);
          ae.i(MPVideoView.access$getTAG$cp(), "onGetVideoSize adjust direction from AUTO to %s", new Object[] { Integer.valueOf(MPVideoView.y(this.oAH.oAG)) });
          AppMethodBeat.o(7514);
          return;
        }
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7515);
        Object localObject = MPVideoView.k(this.oAH.oAG);
        MPExoVideoWrapper localMPExoVideoWrapper;
        if (localObject != null)
        {
          localMPExoVideoWrapper = MPVideoView.h(this.oAH.oAG);
          if (localMPExoVideoWrapper == null) {
            break label80;
          }
        }
        label80:
        for (long l = localMPExoVideoWrapper.getFirstRenderTime();; l = 0L)
        {
          ((MPVideoView.c)localObject).tH(l);
          localObject = MPVideoView.s(this.oAH.oAG);
          if (localObject == null) {
            p.gkB();
          }
          ((com.tencent.mm.plugin.appbrand.jsapi.video.ui.a)localObject).bpt();
          AppMethodBeat.o(7515);
          return;
        }
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class d
      implements Runnable
    {
      d(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7516);
        this.oAH.oAG.bTN();
        Object localObject = MPVideoView.j(this.oAH.oAG);
        if (localObject == null) {
          p.gkB();
        }
        ((TextView)localObject).setVisibility(8);
        if (MPVideoView.b(this.oAH.oAG))
        {
          localObject = MPVideoView.d(this.oAH.oAG);
          if (localObject == null) {
            p.gkB();
          }
          ((View)localObject).setVisibility(0);
          localObject = MPVideoView.c(this.oAH.oAG);
          if (localObject == null) {
            p.gkB();
          }
          if (((MPVideoViewControlBar)localObject).bnS())
          {
            localObject = MPVideoView.c(this.oAH.oAG);
            if (localObject == null) {
              p.gkB();
            }
            ((MPVideoViewControlBar)localObject).hide();
          }
          localObject = MPVideoView.t(this.oAH.oAG);
          if (localObject == null) {
            p.gkB();
          }
          if (((FrameLayout)localObject).getVisibility() == 0)
          {
            localObject = MPVideoView.t(this.oAH.oAG);
            if (localObject == null) {
              p.gkB();
            }
            ((FrameLayout)localObject).setVisibility(8);
          }
          if ((!MPVideoView.u(this.oAH.oAG)) && (MPVideoView.b(this.oAH.oAG))) {
            break label318;
          }
          localObject = MPVideoView.v(this.oAH.oAG);
          if (localObject == null) {
            p.gkB();
          }
          ((View)localObject).setVisibility(8);
        }
        for (;;)
        {
          this.oAH.oAG.bTE();
          this.oAH.oAG.setPlayStatus(4);
          localObject = MPVideoView.k(this.oAH.oAG);
          if (localObject == null) {
            break label407;
          }
          ((MPVideoView.c)localObject).onVideoEnded();
          AppMethodBeat.o(7516);
          return;
          localObject = MPVideoView.c(this.oAH.oAG);
          if (localObject == null) {
            p.gkB();
          }
          ((MPVideoViewControlBar)localObject).bTU();
          localObject = MPVideoView.c(this.oAH.oAG);
          if (localObject == null) {
            p.gkB();
          }
          ((MPVideoViewControlBar)localObject).show();
          break;
          label318:
          if (MPVideoView.w(this.oAH.oAG) <= 0)
          {
            localObject = MPVideoView.x(this.oAH.oAG);
            if (localObject == null) {
              p.gkB();
            }
            MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.oAH.oAG);
            if (localMPExoVideoWrapper == null) {
              p.gkB();
            }
            ((TextView)localObject).setText((CharSequence)MPVideoView.Au(localMPExoVideoWrapper.getVideoDurationSec()));
          }
          localObject = MPVideoView.v(this.oAH.oAG);
          if (localObject == null) {
            p.gkB();
          }
          ((View)localObject).setVisibility(0);
        }
        label407:
        AppMethodBeat.o(7516);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class e
      implements Runnable
    {
      e(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7517);
        this.oAH.oAG.bTP();
        AppMethodBeat.o(7517);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class f
      implements Runnable
    {
      f(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7518);
        ae.i(MPVideoView.access$getTAG$cp(), "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(MPVideoView.u(this.oAH.oAG)) });
        MPVideoView.z(this.oAH.oAG);
        this.oAH.oAG.bTF();
        Object localObject = MPVideoView.k(this.oAH.oAG);
        if (localObject != null) {
          ((MPVideoView.c)localObject).onVideoPlay();
        }
        if ((MPVideoView.w(this.oAH.oAG) <= 0) && (!MPVideoView.u(this.oAH.oAG)))
        {
          localObject = MPVideoView.x(this.oAH.oAG);
          if (localObject == null) {
            p.gkB();
          }
          MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.oAH.oAG);
          if (localMPExoVideoWrapper == null) {
            p.gkB();
          }
          ((TextView)localObject).setText((CharSequence)MPVideoView.Au(localMPExoVideoWrapper.getVideoDurationSec()));
        }
        MPVideoView.b(this.oAH.oAG, MPVideoView.u(this.oAH.oAG));
        if (MPVideoView.a(this.oAH.oAG)) {
          MPVideoView.A(this.oAH.oAG);
        }
        MPVideoView.m(this.oAH.oAG);
        this.oAH.oAG.setPlayStatus(2);
        localObject = MPVideoView.c(this.oAH.oAG);
        if (localObject == null) {
          p.gkB();
        }
        if (((MPVideoViewControlBar)localObject).bnS())
        {
          localObject = MPVideoView.c(this.oAH.oAG);
          if (localObject == null) {
            p.gkB();
          }
          ((MPVideoViewControlBar)localObject).bnY();
        }
        AppMethodBeat.o(7518);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class g
      implements Runnable
    {
      g(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7519);
        MPVideoView.a(this.oAH.oAG, true);
        MPVideoView.f(this.oAH.oAG);
        MPVideoView.c localc = MPVideoView.k(this.oAH.oAG);
        if (localc != null)
        {
          localc.onVideoWaiting();
          AppMethodBeat.o(7519);
          return;
        }
        AppMethodBeat.o(7519);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class h
      implements Runnable
    {
      h(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7520);
        MPVideoView.a(this.oAH.oAG, false);
        MPVideoView.l(this.oAH.oAG);
        MPVideoView.c localc = MPVideoView.k(this.oAH.oAG);
        if (localc != null)
        {
          localc.bSV();
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