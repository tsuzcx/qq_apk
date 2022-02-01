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
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.n.n;
import d.v;
import java.util.LinkedList;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroudContainerLayout", "Landroid/widget/FrameLayout;", "getBackgroudContainerLayout", "()Landroid/widget/FrameLayout;", "setBackgroudContainerLayout", "(Landroid/widget/FrameLayout;)V", "cacheTimeSec", "getCacheTimeSec", "()I", "currPosMs", "getCurrPosMs", "currPosSec", "getCurrPosSec", "dotContainerLayout", "getDotContainerLayout", "setDotContainerLayout", "duration", "getDuration", "setDuration", "(I)V", "endPlayTime", "getEndPlayTime", "hasDownInTouchEvent", "", "hasRealPlayTime", "isCoverVisible", "()Z", "isInFullScreen", "isLive", "mAdjustContentTv", "Landroid/widget/TextView;", "mAdjustIconIv", "Landroid/widget/ImageView;", "mAdjustInfoLayout", "Landroid/widget/LinearLayout;", "mAdjustPercentIndicator", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/AppBrandDotPercentIndicator;", "mAutoPlay", "mBottomProgressBackBar", "mBottomProgressFrontBar", "mBottomProgressLayout", "mConsumeTouchEvent", "mControlBar", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar;", "mCoverArea", "Landroid/view/View;", "mCoverPlayBtnArea", "mCoverTotalTimeTv", "mCoverUrl", "", "mDirection", "mDuration", "mEnablePlayGesture", "mEnableProgressGesture", "mFullScreenDelegate", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "mGestureController", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController;", "mInitialTime", "mIsAlive", "mIsLoading", "mIsMute", "mIsShowBasicControls", "mLoop", "mMPVideoViewCallBack", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "mPageGesture", "mPageGestureInFullscreen", "mPlayStart", "mPlayStarted", "mProgressTv", "mRealPlayTime", "", "mSetIsShowCoverPlayBtn", "mSetIsShowProgressBar", "mSkipAutoPause", "mStartPlayTime", "mVideoSource", "mVideoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper;", "needHandleTouchEvent", "getNeedHandleTouchEvent", "setNeedHandleTouchEvent", "(Z)V", "playStatus", "getPlayStatus", "setPlayStatus", "playerAdContainerLayout", "getPlayerAdContainerLayout", "setPlayerAdContainerLayout", "realPlayTime", "getRealPlayTime", "()J", "videoHeight", "getVideoHeight", "setVideoHeight", "<set-?>", "videoPath", "getVideoPath", "()Ljava/lang/String;", "videoWidth", "getVideoWidth", "setVideoWidth", "canAdjustBrightnessVolume", "canDragProgress", "clean", "", "doOnTouchEvent", "event", "Landroid/view/MotionEvent;", "downloadVideo", "videoUrl", "enableProgressGesture", "enable", "getAutoPlay", "getPlayStart", "getPlayStarted", "getTimeShowString", "time", "hideCenterPlayBtnIfNeed", "hideCover", "init", "initControlBar", "initGestureController", "initParam", "initVideoViewCallback", "isControlBarShow", "isPlaying", "makeTimeString", "d", "onExitFullScreen", "onTouchEvent", "onUIDestroy", "onUIPause", "onUIResume", "operateFullScreen", "toFullScreen", "direction", "pause", "seekTo", "position", "afterPlay", "setAutoPlay", "autoPlay", "setBizInfo", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "iconUrl", "setConsumeTouchEvent", "value", "setCoverByUrl", "cover", "coverUrl", "width", "height", "setEnablePlayGesture", "enablePlayGesture", "setExoPlayerParam", "maxInitialBitrate", "bandwidthFraction", "", "minDurForQualityMs", "maxDurForQualityMs", "minBufferMs", "maxBufferMs", "setFullScreenDelegate", "delegate", "setFullScreenDirection", "setInitialTime", "initialTime", "setIsShowBasicControls", "isShowBasicControls", "setLoop", "loop", "setMPVideoViewCallBack", "setMute", "isMute", "setObjectFit", "setPageGesture", "pageGesture", "setPageGestureInFullscreen", "pageGestureInFullscreen", "setPlayBtnOnClickListener", "click", "Landroid/view/View$OnClickListener;", "setPlayBtnPosition", "playBtnPosition", "setPreLoadVidePath", "setShowCenterPlayBtn", "showCenterPlayBtn", "setShowControlProgress", "showControlProgress", "setShowFullScreenBtn", "showFullScreenBtn", "setShowMuteBtn", "showMuteBtn", "setShowPlayBtn", "showPlayBtn", "setShowProgress", "showProgress", "setTitle", "title", "setVideoPath", "durationSec", "setVideoSource", "videoSource", "setVideoUrlInfo", "urlInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "currentInfo", "shouldDispatchEventToGestureController", "shouldHandleTouchEvent", "v", "e", "showCenterPlayBtnIfNeed", "showControlBar", "showCover", "start", "startWhenNetWorkConnect", "stop", "updateBottomProgressLayout", "updateControlBarDotPos", "list", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoDotInfo;", "updateLiveUI", "updateRealPlayTime", "updateStartTime", "Companion", "FullScreenDelegate", "MPVideoViewCallBack", "plugin-brandservice_release"})
public final class MPVideoView
  extends RelativeLayout
{
  public static final String TAG = "MicroMsg.MPVideoView";
  private static final int ouc = -1;
  private static final int oud = 8;
  public static final MPVideoView.a oue;
  private int acQ;
  private int atW;
  private boolean csg;
  private int irQ;
  private TextView lkG;
  private View lkJ;
  private View lkK;
  private TextView lkL;
  private LinearLayout lkM;
  private AppBrandDotPercentIndicator lkN;
  private TextView lkO;
  private ImageView lkP;
  private ImageView lkR;
  private ImageView lkS;
  private FrameLayout lkT;
  private boolean lkX;
  private boolean lkZ;
  private boolean lla;
  private com.tencent.mm.plugin.appbrand.jsapi.video.ui.a llb;
  private boolean lld;
  private boolean lle;
  private String llg;
  private boolean llh;
  private boolean lli;
  private boolean llj;
  private boolean lll;
  private int llm;
  private boolean llo;
  private boolean llp;
  public boolean llq;
  private boolean mIsMute;
  public MPExoVideoWrapper otN;
  public MPVideoViewControlBar otO;
  private FrameLayout otP;
  private FrameLayout otQ;
  private FrameLayout otR;
  private boolean otS;
  private boolean otT;
  private b otU;
  private c otV;
  private int otW;
  private long otX;
  private long otY;
  private boolean otZ;
  public boolean oua;
  public boolean oub;
  private int videoHeight;
  private String videoPath;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(7587);
    oue = new MPVideoView.a((byte)0);
    TAG = "MicroMsg.MPVideoView";
    ouc = -1;
    oud = 8;
    AppMethodBeat.o(7587);
  }
  
  public MPVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(7584);
    this.acQ = ouc;
    init(paramContext);
    AppMethodBeat.o(7584);
  }
  
  public MPVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7585);
    this.acQ = ouc;
    init(paramContext);
    AppMethodBeat.o(7585);
  }
  
  public MPVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(7586);
    this.acQ = ouc;
    init(paramContext);
    AppMethodBeat.o(7586);
  }
  
  private final boolean bSB()
  {
    AppMethodBeat.i(175553);
    if (this.llp)
    {
      AppMethodBeat.o(175553);
      return true;
    }
    boolean bool = bmP();
    if (!bmQ())
    {
      AppMethodBeat.o(175553);
      return false;
    }
    AppMethodBeat.o(175553);
    return bool;
  }
  
  private final boolean bhH()
  {
    AppMethodBeat.i(7537);
    Object localObject = TAG;
    boolean bool = this.lld;
    MPExoVideoWrapper localMPExoVideoWrapper = this.otN;
    if (localMPExoVideoWrapper == null) {
      p.gfZ();
    }
    ad.i((String)localObject, "isLive %b %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localMPExoVideoWrapper.bzN) });
    if (!this.lld)
    {
      localObject = this.otN;
      if (localObject == null) {
        p.gfZ();
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
  
  private final void bmL()
  {
    AppMethodBeat.i(7574);
    MPVideoViewControlBar localMPVideoViewControlBar = this.otO;
    if (localMPVideoViewControlBar == null) {
      p.gfZ();
    }
    localMPVideoViewControlBar.bmL();
    AppMethodBeat.o(7574);
  }
  
  private final boolean bmP()
  {
    AppMethodBeat.i(7582);
    if (this.lli)
    {
      MPExoVideoWrapper localMPExoVideoWrapper = this.otN;
      if (localMPExoVideoWrapper == null) {
        p.gfZ();
      }
      if ((!localMPExoVideoWrapper.bzN) && (!bmR()))
      {
        AppMethodBeat.o(7582);
        return true;
      }
    }
    AppMethodBeat.o(7582);
    return false;
  }
  
  private final boolean bmQ()
  {
    AppMethodBeat.i(7583);
    if ((!bmR()) && (((!bmN()) && (this.lkZ)) || ((bmN()) && (this.lla))))
    {
      AppMethodBeat.o(7583);
      return true;
    }
    AppMethodBeat.o(7583);
    return false;
  }
  
  private final boolean bmR()
  {
    AppMethodBeat.i(7538);
    View localView = this.lkJ;
    if (localView == null) {
      p.gfZ();
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
    Object localObject = this.otN;
    if (localObject == null) {
      p.gfZ();
    }
    ((MPExoVideoWrapper)localObject).onUIDestroy();
    localObject = this.otO;
    if (localObject == null) {
      p.gfZ();
    }
    ((MPVideoViewControlBar)localObject).onDestroy();
    AppMethodBeat.o(7555);
  }
  
  private final void init(Context paramContext)
  {
    AppMethodBeat.i(7539);
    LayoutInflater.from(paramContext).inflate(2131494957, (ViewGroup)this);
    this.otN = ((MPExoVideoWrapper)findViewById(2131306410));
    paramContext = findViewById(2131303515);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lkG = ((TextView)paramContext);
    this.lkJ = findViewById(2131298814);
    this.lkK = findViewById(2131298828);
    paramContext = findViewById(2131298832);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lkL = ((TextView)paramContext);
    paramContext = findViewById(2131296505);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lkM = ((LinearLayout)paramContext);
    paramContext = findViewById(2131296506);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lkN = ((AppBrandDotPercentIndicator)paramContext);
    paramContext = findViewById(2131296502);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lkO = ((TextView)paramContext);
    paramContext = findViewById(2131296504);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lkP = ((ImageView)paramContext);
    paramContext = findViewById(2131303297);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lkR = ((ImageView)paramContext);
    paramContext = findViewById(2131303296);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lkS = ((ImageView)paramContext);
    paramContext = findViewById(2131303298);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.lkT = ((FrameLayout)paramContext);
    paramContext = findViewById(2131303293);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.otP = ((FrameLayout)paramContext);
    paramContext = findViewById(2131303299);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.otQ = ((FrameLayout)paramContext);
    paramContext = findViewById(2131303294);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    this.otR = ((FrameLayout)paramContext);
    paramContext = this.lkN;
    if (paramContext == null) {
      p.gfZ();
    }
    paramContext.setDotsNum(oud);
    paramContext = findViewById(2131298827);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(7539);
      throw paramContext;
    }
    ((ImageView)paramContext).setOnClickListener((View.OnClickListener)new MPVideoView.d(this));
    this.llb = new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a(getContext(), (View)this, (a.b)new o(this));
    paramContext = this.otN;
    if (paramContext == null) {
      p.gfZ();
    }
    paramContext.setIMMVideoViewCallback((i.b)new p(this));
    this.otO = new MPVideoViewControlBar(getContext());
    paramContext = this.otN;
    if (paramContext == null) {
      p.gfZ();
    }
    MPVideoViewControlBar localMPVideoViewControlBar = this.otO;
    if (localMPVideoViewControlBar == null) {
      p.gfZ();
    }
    paramContext.setVideoFooterView((h)localMPVideoViewControlBar);
    paramContext = this.otO;
    if (paramContext == null) {
      p.gfZ();
    }
    paramContext.hide();
    paramContext = this.otO;
    if (paramContext == null) {
      p.gfZ();
    }
    paramContext.setFullScreenBtnOnClickListener((View.OnClickListener)new MPVideoView.e(this));
    paramContext = this.otO;
    if (paramContext == null) {
      p.gfZ();
    }
    paramContext.setIplaySeekCallback((e.d)new g(this));
    paramContext = this.otO;
    if (paramContext == null) {
      p.gfZ();
    }
    paramContext.setOnPlayButtonClickListener((View.OnClickListener)new MPVideoView.h(this));
    paramContext = this.otO;
    if (paramContext == null) {
      p.gfZ();
    }
    paramContext.setStatePorter((e.i)new i(this));
    paramContext = this.otO;
    if (paramContext == null) {
      p.gfZ();
    }
    paramContext.setMuteBtnOnClickListener((View.OnClickListener)new MPVideoView.j(this));
    paramContext = this.otO;
    if (paramContext == null) {
      p.gfZ();
    }
    paramContext.setExitFullScreenBtnOnClickListener((View.OnClickListener)new MPVideoView.k(this));
    paramContext = this.otO;
    if (paramContext == null) {
      p.gfZ();
    }
    paramContext.a((e.f)new l(this));
    paramContext = this.otO;
    if (paramContext == null) {
      p.gfZ();
    }
    paramContext.setOnUpdateProgressLenListener((e.e)new m(this));
    paramContext = this.otO;
    if (paramContext == null) {
      p.gfZ();
    }
    paramContext.setSwitchResolutionListener((MPVideoViewControlBar.a)new n(this));
    paramContext = this.otO;
    if (paramContext == null) {
      p.gfZ();
    }
    paramContext.setSwitchSpeedListener((MPVideoViewControlBar.b)new f(this));
    paramContext = this.otN;
    if (paramContext == null) {
      p.gfZ();
    }
    paramContext = paramContext.getCoverIv();
    if (paramContext == null) {
      p.gfZ();
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
    this.lli = true;
    setVideoSource(0);
    setConsumeTouchEvent(false);
    setIsShowBasicControls(true);
    AppMethodBeat.o(7539);
  }
  
  private static String tq(int paramInt)
  {
    AppMethodBeat.i(7580);
    String str = tr(paramInt / 60) + ":" + tr(paramInt % 60);
    AppMethodBeat.o(7580);
    return str;
  }
  
  private static String tr(int paramInt)
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
  
  public final boolean O(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(175552);
    p.h(paramMotionEvent, "event");
    if (bSB())
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.ui.a locala = this.llb;
      if (locala != null) {
        locala.w(paramMotionEvent);
      }
      AppMethodBeat.o(175552);
      return true;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if ((this.lkX) && (!this.lll))
      {
        paramMotionEvent = this.otO;
        if (paramMotionEvent == null) {
          p.gfZ();
        }
        paramMotionEvent.bng();
      }
      paramMotionEvent = this.lkJ;
      if (paramMotionEvent == null) {
        p.gfZ();
      }
      if ((paramMotionEvent.getVisibility() != 0) && (this.llo)) {
        bmL();
      }
    }
    boolean bool = this.llh;
    AppMethodBeat.o(175552);
    return bool;
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(175550);
    MPExoVideoWrapper localMPExoVideoWrapper = this.otN;
    if (localMPExoVideoWrapper == null) {
      p.gfZ();
    }
    localMPExoVideoWrapper.a(paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(175550);
  }
  
  public final void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, x paramx)
  {
    AppMethodBeat.i(7559);
    p.h(paramx, "msgInfo");
    ad.i(TAG, "setCover coverUrl=%s", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7559);
      return;
    }
    this.llg = paramString;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l locall = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.ory;
    if (paramString == null) {
      p.gfZ();
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(paramImageView, paramString, paramInt1, paramInt2, paramx);
    AppMethodBeat.o(7559);
  }
  
  public final void a(LinkedList<fu> paramLinkedList, fu paramfu)
  {
    AppMethodBeat.i(175551);
    p.h(paramLinkedList, "urlInfoList");
    p.h(paramfu, "currentInfo");
    MPVideoViewControlBar localMPVideoViewControlBar = this.otO;
    if (localMPVideoViewControlBar == null) {
      p.gfZ();
    }
    localMPVideoViewControlBar.a(paramLinkedList, paramfu);
    AppMethodBeat.o(175551);
  }
  
  public final void bSA()
  {
    long l1 = 0L;
    AppMethodBeat.i(210147);
    long l2 = System.currentTimeMillis();
    long l3 = this.otX;
    if (this.otY != 0L) {
      l1 = l2 - this.otY;
    }
    this.otX = (l1 + l3);
    this.otY = l2;
    this.otZ = true;
    AppMethodBeat.o(210147);
  }
  
  public final void bSC()
  {
    AppMethodBeat.i(7578);
    MPVideoViewControlBar localMPVideoViewControlBar = this.otO;
    if (localMPVideoViewControlBar != null) {
      localMPVideoViewControlBar.bSH();
    }
    localMPVideoViewControlBar = this.otO;
    if (localMPVideoViewControlBar != null)
    {
      localMPVideoViewControlBar.show();
      AppMethodBeat.o(7578);
      return;
    }
    AppMethodBeat.o(7578);
  }
  
  public final boolean bSD()
  {
    AppMethodBeat.i(7579);
    MPVideoViewControlBar localMPVideoViewControlBar = this.otO;
    if (localMPVideoViewControlBar != null)
    {
      boolean bool = localMPVideoViewControlBar.bni();
      AppMethodBeat.o(7579);
      return bool;
    }
    AppMethodBeat.o(7579);
    return false;
  }
  
  public final void bSr()
  {
    AppMethodBeat.i(7561);
    MPExoVideoWrapper localMPExoVideoWrapper = this.otN;
    if (localMPExoVideoWrapper == null) {
      p.gfZ();
    }
    localMPExoVideoWrapper.bSr();
    AppMethodBeat.o(7561);
  }
  
  public final void bSs()
  {
    AppMethodBeat.i(7562);
    MPExoVideoWrapper localMPExoVideoWrapper = this.otN;
    if (localMPExoVideoWrapper == null) {
      p.gfZ();
    }
    localMPExoVideoWrapper.bSs();
    AppMethodBeat.o(7562);
  }
  
  public final boolean bmN()
  {
    AppMethodBeat.i(7536);
    if (this.otU == null)
    {
      ad.w(TAG, "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(7536);
      return false;
    }
    b localb = this.otU;
    if (localb == null) {
      p.gfZ();
    }
    boolean bool = localb.isFullScreen();
    AppMethodBeat.o(7536);
    return bool;
  }
  
  public final void cD(String paramString, int paramInt)
  {
    AppMethodBeat.i(7556);
    p.h(paramString, "videoPath");
    ad.i(TAG, "setVideoPath path=%s isLive=%s", new Object[] { paramString, Boolean.FALSE });
    if (bt.isNullOrNil(paramString))
    {
      ad.v(TAG, "setVideoPath videoPath empty");
      AppMethodBeat.o(7556);
      return;
    }
    this.videoPath = paramString;
    stop();
    this.lld = false;
    MPExoVideoWrapper localMPExoVideoWrapper = this.otN;
    if (localMPExoVideoWrapper == null) {
      p.gfZ();
    }
    localMPExoVideoWrapper.setVideoSource(this.llm);
    localMPExoVideoWrapper = this.otN;
    if (localMPExoVideoWrapper == null) {
      p.gfZ();
    }
    localMPExoVideoWrapper.cC(paramString, paramInt);
    if (this.otW > 0)
    {
      paramString = this.otN;
      if (paramString == null) {
        p.gfZ();
      }
      paramString.U(this.otW, this.csg);
    }
    if (this.csg)
    {
      ad.i(TAG, "setVideoPath autoPlay");
      start();
    }
    setMute(this.mIsMute);
    AppMethodBeat.o(7556);
  }
  
  public final boolean getAutoPlay()
  {
    return this.csg;
  }
  
  public final FrameLayout getBackgroudContainerLayout()
  {
    return this.otR;
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(7535);
    if (this.otN != null)
    {
      MPExoVideoWrapper localMPExoVideoWrapper = this.otN;
      if (localMPExoVideoWrapper == null) {
        p.gfZ();
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.otN;
    if (localMPExoVideoWrapper == null) {
      p.gfZ();
    }
    int i = localMPExoVideoWrapper.getCurrPosMs();
    AppMethodBeat.o(7534);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(7533);
    MPExoVideoWrapper localMPExoVideoWrapper = this.otN;
    if (localMPExoVideoWrapper == null) {
      p.gfZ();
    }
    int i = localMPExoVideoWrapper.getCurrPosSec();
    AppMethodBeat.o(7533);
    return i;
  }
  
  public final FrameLayout getDotContainerLayout()
  {
    return this.otQ;
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.otN;
    if (localMPExoVideoWrapper == null) {
      p.gfZ();
    }
    int i = localMPExoVideoWrapper.getVideoDurationSec();
    AppMethodBeat.o(7531);
    return i;
  }
  
  public final int getEndPlayTime()
  {
    AppMethodBeat.i(7530);
    if ((getCurrPosMs() == 0) && (this.irQ != 0))
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
    return this.oua;
  }
  
  public final boolean getPlayStart()
  {
    return this.otS;
  }
  
  public final boolean getPlayStarted()
  {
    return this.otT;
  }
  
  public final int getPlayStatus()
  {
    return this.irQ;
  }
  
  public final FrameLayout getPlayerAdContainerLayout()
  {
    return this.otP;
  }
  
  public final long getRealPlayTime()
  {
    AppMethodBeat.i(7529);
    if ((!this.otZ) && (this.otY != 0L) && (isPlaying()))
    {
      l1 = System.currentTimeMillis();
      long l2 = this.otY;
      AppMethodBeat.o(7529);
      return l1 - l2;
    }
    long l1 = this.otX;
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.otN;
    if (localMPExoVideoWrapper == null) {
      p.gfZ();
    }
    boolean bool = localMPExoVideoWrapper.isPlaying();
    AppMethodBeat.o(7550);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(7575);
    p.h(paramMotionEvent, "event");
    if (!bmN())
    {
      AppMethodBeat.o(7575);
      return false;
    }
    boolean bool = O(paramMotionEvent);
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
    if (this.otU == null)
    {
      ad.w(TAG, "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(7576);
      return;
    }
    if (paramBoolean == bmN())
    {
      ad.i(TAG, "operateFullScreen current same");
      AppMethodBeat.o(7576);
      return;
    }
    if (paramInt == ouc) {
      if (this.acQ == ouc)
      {
        paramInt = 90;
        ad.i(TAG, "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject = this.otU;
        if (localObject == null) {
          p.gfZ();
        }
        ((b)localObject).te(paramInt);
        localObject = this.otO;
        if (localObject != null) {
          ((MPVideoViewControlBar)localObject).setDirection(paramInt);
        }
        localObject = this.otO;
        if (localObject != null) {
          ((MPVideoViewControlBar)localObject).bnj();
        }
        localObject = this.otN;
        if (localObject != null)
        {
          ((MPExoVideoWrapper)localObject).jBC = true;
          AppMethodBeat.o(7576);
          return;
          paramInt = this.acQ;
          break;
        }
        AppMethodBeat.o(7576);
        return;
      }
      Object localObject = this.otU;
      if (localObject != null) {
        ((b)localObject).bkF();
      }
      localObject = this.otO;
      if (localObject != null) {
        ((MPVideoViewControlBar)localObject).bkF();
      }
      localObject = this.otN;
      if (localObject != null)
      {
        ((MPExoVideoWrapper)localObject).jBC = false;
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.otN;
    if (localMPExoVideoWrapper == null) {
      p.gfZ();
    }
    if (!localMPExoVideoWrapper.isPlaying())
    {
      AppMethodBeat.o(7552);
      return;
    }
    localMPExoVideoWrapper = this.otN;
    if (localMPExoVideoWrapper == null) {
      p.gfZ();
    }
    localMPExoVideoWrapper.pause();
    AppMethodBeat.o(7552);
  }
  
  public final void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(7547);
    ad.i(TAG, "setAutoPlay =%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.csg = paramBoolean;
    if ((this.csg) && (this.irQ == 0)) {
      this.irQ = 1;
    }
    AppMethodBeat.o(7547);
  }
  
  public final void setBackgroudContainerLayout(FrameLayout paramFrameLayout)
  {
    this.otR = paramFrameLayout;
  }
  
  public final void setConsumeTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(7540);
    ad.i(TAG, "setConsumeTouchEvent value=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.llh = paramBoolean;
    AppMethodBeat.o(7540);
  }
  
  public final void setDotContainerLayout(FrameLayout paramFrameLayout)
  {
    this.otQ = paramFrameLayout;
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
    TextView localTextView = this.lkL;
    if (localTextView == null) {
      p.gfZ();
    }
    localTextView.setText((CharSequence)tq(paramInt));
    this.atW = paramInt;
    AppMethodBeat.o(7532);
  }
  
  public final void setEnablePlayGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(7546);
    ad.i(TAG, "setEnablePlayGesture: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.llp = paramBoolean;
    AppMethodBeat.o(7546);
  }
  
  public final void setFullScreenDelegate(b paramb)
  {
    AppMethodBeat.i(7572);
    p.h(paramb, "delegate");
    this.otU = paramb;
    AppMethodBeat.o(7572);
  }
  
  public final void setFullScreenDirection(int paramInt)
  {
    AppMethodBeat.i(7568);
    ad.i(TAG, "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.acQ = paramInt;
    AppMethodBeat.o(7568);
  }
  
  public final void setInitialTime(int paramInt)
  {
    AppMethodBeat.i(7571);
    ad.i(TAG, "setInitialTime initialTime=%s", new Object[] { Integer.valueOf(paramInt) });
    this.otW = paramInt;
    AppMethodBeat.o(7571);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(7558);
    ad.i(TAG, "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lkX = paramBoolean;
    if (this.otO != null)
    {
      if (this.lkX)
      {
        localMPVideoViewControlBar = this.otO;
        if (localMPVideoViewControlBar == null) {
          p.gfZ();
        }
        localMPVideoViewControlBar.bnh();
        AppMethodBeat.o(7558);
        return;
      }
      MPVideoViewControlBar localMPVideoViewControlBar = this.otO;
      if (localMPVideoViewControlBar == null) {
        p.gfZ();
      }
      localMPVideoViewControlBar.hide();
    }
    AppMethodBeat.o(7558);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(7549);
    ad.i(TAG, "setLoop loop=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lle = paramBoolean;
    AppMethodBeat.o(7549);
  }
  
  public final void setMPVideoViewCallBack(c paramc)
  {
    AppMethodBeat.i(7573);
    p.h(paramc, "delegate");
    this.otV = paramc;
    AppMethodBeat.o(7573);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(7567);
    ad.i(TAG, "setMute isMute=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    Object localObject = this.otN;
    if (localObject == null) {
      p.gfZ();
    }
    ((MPExoVideoWrapper)localObject).setMute(paramBoolean);
    localObject = this.otO;
    if (localObject == null) {
      p.gfZ();
    }
    ((MPVideoViewControlBar)localObject).setMuteBtnState(paramBoolean);
    AppMethodBeat.o(7567);
  }
  
  public final void setNeedHandleTouchEvent(boolean paramBoolean)
  {
    this.oua = paramBoolean;
  }
  
  public final void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(7569);
    ad.i(TAG, "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lkZ = paramBoolean;
    AppMethodBeat.o(7569);
  }
  
  public final void setPageGestureInFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(7570);
    ad.i(TAG, "setPageGestureInFullscreen pageGestureInFullscreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lla = paramBoolean;
    AppMethodBeat.o(7570);
  }
  
  public final void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(7577);
    p.h(paramOnClickListener, "click");
    MPVideoViewControlBar localMPVideoViewControlBar = this.otO;
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
    ad.i(TAG, "setPlayBtnPosition: %s", new Object[] { paramString });
    if ((!bt.isNullOrNil(paramString)) && (n.H(paramString, "center", true)))
    {
      paramString = this.otO;
      if (paramString == null) {
        p.gfZ();
      }
      paramString.setPlayBtnInCenterPosition(true);
      AppMethodBeat.o(7545);
      return;
    }
    paramString = this.otO;
    if (paramString == null) {
      p.gfZ();
    }
    paramString.setPlayBtnInCenterPosition(false);
    AppMethodBeat.o(7545);
  }
  
  public final void setPlayStatus(int paramInt)
  {
    this.irQ = paramInt;
  }
  
  public final void setPlayerAdContainerLayout(FrameLayout paramFrameLayout)
  {
    this.otP = paramFrameLayout;
  }
  
  public final void setShowCenterPlayBtn(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(7566);
    ad.i(TAG, "setPlayBtnInCenterPosition %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lll = paramBoolean;
    Object localObject = this.lkJ;
    if (localObject == null) {
      p.gfZ();
    }
    if (paramBoolean)
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.lkK;
      if (localObject == null) {
        p.gfZ();
      }
      if (!paramBoolean) {
        break label131;
      }
    }
    label131:
    for (int i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      if ((this.lll) && (this.otO != null))
      {
        localObject = this.otO;
        if (localObject == null) {
          p.gfZ();
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
    MPVideoViewControlBar localMPVideoViewControlBar = this.otO;
    if (localMPVideoViewControlBar == null) {
      p.gfZ();
    }
    if ((paramBoolean) && (!bhH())) {}
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
    MPVideoViewControlBar localMPVideoViewControlBar = this.otO;
    if (localMPVideoViewControlBar == null) {
      p.gfZ();
    }
    localMPVideoViewControlBar.setShowFullScreenBtn(paramBoolean);
    AppMethodBeat.o(7564);
  }
  
  public final void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(7541);
    ad.i(TAG, "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.otO;
    if (localMPVideoViewControlBar == null) {
      p.gfZ();
    }
    localMPVideoViewControlBar.setShowMuteBtn(paramBoolean);
    AppMethodBeat.o(7541);
  }
  
  public final void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(7565);
    ad.i(TAG, "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.otO;
    if (localMPVideoViewControlBar == null) {
      p.gfZ();
    }
    localMPVideoViewControlBar.setShowPlayBtn(paramBoolean);
    AppMethodBeat.o(7565);
  }
  
  public final void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(7563);
    ad.i(TAG, "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.llj = paramBoolean;
    MPVideoViewControlBar localMPVideoViewControlBar = this.otO;
    if (localMPVideoViewControlBar == null) {
      p.gfZ();
    }
    if ((paramBoolean) && (!bhH())) {}
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
    MPVideoViewControlBar localMPVideoViewControlBar = this.otO;
    if (localMPVideoViewControlBar == null) {
      p.gfZ();
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
    this.llm = paramInt;
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
    MPExoVideoWrapper localMPExoVideoWrapper = this.otN;
    if (localMPExoVideoWrapper == null) {
      p.gfZ();
    }
    ad.i((String)localObject, localMPExoVideoWrapper.isPlaying());
    localObject = this.otN;
    if (localObject == null) {
      p.gfZ();
    }
    if (((MPExoVideoWrapper)localObject).isPlaying())
    {
      AppMethodBeat.o(7551);
      return;
    }
    this.otS = true;
    if (this.lkX)
    {
      localObject = this.otO;
      if (localObject == null) {
        p.gfZ();
      }
      ((MPVideoViewControlBar)localObject).bnm();
    }
    localObject = this.lkJ;
    if (localObject == null) {
      p.gfZ();
    }
    ((View)localObject).setVisibility(8);
    localObject = this.otN;
    if (localObject == null) {
      p.gfZ();
    }
    ((MPExoVideoWrapper)localObject).start();
    bSs();
    AppMethodBeat.o(7551);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(7553);
    ad.i(TAG, "stop");
    Object localObject = this.otN;
    if (localObject == null) {
      p.gfZ();
    }
    if (!((MPExoVideoWrapper)localObject).isPlaying())
    {
      AppMethodBeat.o(7553);
      return;
    }
    localObject = this.otN;
    if (localObject == null) {
      p.gfZ();
    }
    ((MPExoVideoWrapper)localObject).Gv();
    localObject = this.otO;
    if (localObject == null) {
      p.gfZ();
    }
    ((MPVideoViewControlBar)localObject).bnn();
    bSr();
    AppMethodBeat.o(7553);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "enterFullScreen", "", "direction", "", "quitFullScreen", "plugin-brandservice_release"})
  public static abstract interface b
  {
    public abstract void bkF();
    
    public abstract boolean isFullScreen();
    
    public abstract void te(int paramInt);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "", "onControlbarVisible", "", "visible", "", "onEndDragProgress", "onGetVideoSize", "width", "", "height", "onHideSwitchResolutionLayout", "onHideSwitchSpeedLayout", "onPlayError", "errorMsg", "", "errorCode", "onSeekPre", "onSeekTo", "time", "onStartDragProgress", "onUpdateProgress", "progressLen", "totalLen", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoPrepare", "firstRenderTime", "", "onVideoWaiting", "onVideoWaitingEnd", "resolutionBtnClick", "speedBtnClick", "switchResolution", "beforeType", "afterType", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "switchSpeed", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
  public static abstract interface c
  {
    public abstract void XU(String paramString);
    
    public abstract void a(int paramInt1, int paramInt2, fu paramfu);
    
    public abstract void a(c.a parama1, c.a parama2);
    
    public abstract void aqD();
    
    public abstract void bRR();
    
    public abstract void bRS();
    
    public abstract void bRT();
    
    public abstract void bRU();
    
    public abstract void bRV();
    
    public abstract void bRW();
    
    public abstract void bRX();
    
    public abstract void bmX();
    
    public abstract void jp(boolean paramBoolean);
    
    public abstract void onVideoEnded();
    
    public abstract void onVideoPause();
    
    public abstract void onVideoPlay();
    
    public abstract void onVideoWaiting();
    
    public abstract void tt(long paramLong);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$10", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$SwitchSpeedListener;", "onHideSwitchSpeedLayout", "", "speedBtnClick", "switchSpeed", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "before", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "after", "plugin-brandservice_release"})
  public static final class f
    implements MPVideoViewControlBar.b
  {
    public final void a(fu paramfu, c.a parama1, c.a parama2)
    {
      AppMethodBeat.i(210143);
      Object localObject = MPVideoView.k(this.ouf);
      if (localObject != null) {
        ((MPVideoView.c)localObject).a(parama1, parama2);
      }
      this.ouf.setAutoPlay(this.ouf.isPlaying());
      int j = this.ouf.getCurrPosMs();
      parama2 = MPVideoView.h(this.ouf);
      if (parama2 == null) {
        p.gfZ();
      }
      parama1 = parama2.osX;
      if (parama1 != null)
      {
        parama1 = parama1.getBitmap();
        if ((parama1 == null) || (parama1.isRecycled())) {
          break label261;
        }
        localObject = parama2.osT;
        if (localObject != null) {
          ((ImageView)localObject).setImageBitmap(parama1);
        }
      }
      for (;;)
      {
        parama1 = parama2.osT;
        if (parama1 != null) {
          parama1.setVisibility(0);
        }
        parama2.tx(0L);
        parama1 = MPVideoView.h(this.ouf);
        if (parama1 == null) {
          p.gfZ();
        }
        parama1.bSt();
        parama1 = this.ouf;
        int i = j;
        if (j == 0) {
          i = 1;
        }
        parama1.setInitialTime(i);
        parama1 = this.ouf;
        if (paramfu == null) {
          p.gfZ();
        }
        paramfu = paramfu.url;
        p.g(paramfu, "info!!.url");
        parama1.cD(paramfu, this.ouf.getDuration());
        if (!MPVideoView.E(this.ouf))
        {
          paramfu = MPVideoView.h(this.ouf);
          if (paramfu == null) {
            p.gfZ();
          }
          paramfu.pause();
        }
        paramfu = MPVideoView.c(this.ouf);
        if (paramfu == null) {
          break label279;
        }
        paramfu.hide();
        AppMethodBeat.o(210143);
        return;
        parama1 = null;
        break;
        label261:
        parama1 = parama2.osT;
        if (parama1 != null) {
          parama1.setImageResource(2131233299);
        }
      }
      label279:
      AppMethodBeat.o(210143);
    }
    
    public final void bSF()
    {
      AppMethodBeat.i(179030);
      MPVideoView.k(this.ouf);
      AppMethodBeat.o(179030);
    }
    
    public final void bSG()
    {
      AppMethodBeat.i(179031);
      MPVideoView.k(this.ouf);
      AppMethodBeat.o(179031);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$2", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-brandservice_release"})
  public static final class g
    implements e.d
  {
    public final void aqD()
    {
      AppMethodBeat.i(7488);
      ad.i(MPVideoView.access$getTAG$cp(), "onSeekPre");
      if (this.ouf.isPlaying()) {
        this.ouf.bSA();
      }
      MPVideoView.c localc = MPVideoView.k(this.ouf);
      if (localc != null)
      {
        localc.aqD();
        AppMethodBeat.o(7488);
        return;
      }
      AppMethodBeat.o(7488);
    }
    
    public final void nM(int paramInt)
    {
      AppMethodBeat.i(7489);
      MPVideoView.a(this.ouf, paramInt * 1000);
      MPVideoView.m(this.ouf);
      MPVideoView.c localc = MPVideoView.k(this.ouf);
      if (localc != null)
      {
        localc.bRT();
        AppMethodBeat.o(7489);
        return;
      }
      AppMethodBeat.o(7489);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$4", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$StatePorter;", "getCacheTime", "", "getTotalTime", "plugin-brandservice_release"})
  public static final class i
    implements e.i
  {
    public final int bmT()
    {
      AppMethodBeat.i(7491);
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.ouf);
      if (localMPExoVideoWrapper == null) {
        p.gfZ();
      }
      int i = localMPExoVideoWrapper.getCacheTimeSec();
      AppMethodBeat.o(7491);
      return i;
    }
    
    public final int bmU()
    {
      AppMethodBeat.i(7492);
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.ouf);
      if (localMPExoVideoWrapper == null) {
        p.gfZ();
      }
      int i = localMPExoVideoWrapper.getVideoDurationSec();
      AppMethodBeat.o(7492);
      return i;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "visible", "", "onVisibilityChanged"})
  static final class l
    implements e.f
  {
    l(MPVideoView paramMPVideoView) {}
    
    public final void onVisibilityChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(7495);
      MPVideoView.A(this.ouf);
      Object localObject1 = MPVideoView.k(this.ouf);
      if (localObject1 != null) {
        ((MPVideoView.c)localObject1).jp(paramBoolean);
      }
      localObject1 = MPVideoView.h(this.ouf);
      if (localObject1 != null)
      {
        Object localObject2;
        if (paramBoolean)
        {
          ((MPExoVideoWrapper)localObject1).otm = true;
          localObject2 = ((MPExoVideoWrapper)localObject1).osT;
          if ((localObject2 == null) || (((ImageView)localObject2).getVisibility() != 0))
          {
            localObject2 = ((MPExoVideoWrapper)localObject1).osU;
            if (localObject2 != null) {
              if (((TextView)localObject2).getVisibility() != 0) {
                break label265;
              }
            }
          }
          else
          {
            ad.i(MPExoVideoWrapper.TAG, "hide switchingResolution onControllerBarVisible");
            if (((MPExoVideoWrapper)localObject1).otl)
            {
              localObject2 = ((MPExoVideoWrapper)localObject1).osT;
              if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 0)) {
                ((MPExoVideoWrapper)localObject1).otk = true;
              }
            }
            localObject2 = ((MPExoVideoWrapper)localObject1).osT;
            if (localObject2 != null) {
              ((ImageView)localObject2).setVisibility(8);
            }
            localObject1 = ((MPExoVideoWrapper)localObject1).osU;
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
          ((MPExoVideoWrapper)localObject1).otm = false;
          if (((MPExoVideoWrapper)localObject1).otk)
          {
            ad.i(MPExoVideoWrapper.TAG, "show switchingResolution onControllerBarVisible isSwitchingResolution = " + ((MPExoVideoWrapper)localObject1).otl);
            ((MPExoVideoWrapper)localObject1).otk = false;
            if (((MPExoVideoWrapper)localObject1).otl)
            {
              ((MPExoVideoWrapper)localObject1).bSp();
              AppMethodBeat.o(7495);
              return;
            }
            localObject2 = ((MPExoVideoWrapper)localObject1).osT;
            if (localObject2 != null) {
              ((ImageView)localObject2).setVisibility(8);
            }
            localObject2 = ((MPExoVideoWrapper)localObject1).osU;
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(0);
            }
            ((MPExoVideoWrapper)localObject1).bSq();
          }
        }
        label265:
        AppMethodBeat.o(7495);
        return;
      }
      AppMethodBeat.o(7495);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "progressLen", "", "totalLen", "onProgressChanged"})
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
        Object localObject = MPVideoView.C(this.ouf);
        if (localObject == null) {
          p.gfZ();
        }
        paramInt1 = i * ((ImageView)localObject).getWidth() / paramInt2;
        localObject = MPVideoView.D(this.ouf);
        if (localObject == null) {
          p.gfZ();
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
        ImageView localImageView = MPVideoView.D(this.ouf);
        if (localImageView == null) {
          p.gfZ();
        }
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = MPVideoView.D(this.ouf);
        if (localObject == null) {
          p.gfZ();
        }
        ((ImageView)localObject).requestLayout();
        localObject = MPVideoView.k(this.ouf);
        if (localObject != null)
        {
          ((MPVideoView.c)localObject).bRV();
          AppMethodBeat.o(7496);
          return;
        }
        AppMethodBeat.o(7496);
        return;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$9", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar$SwitchResolutionListener;", "onHideSwitchResolutionLayout", "", "resolutionBtnClick", "switchResolution", "info", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "beforeType", "", "afterType", "plugin-brandservice_release"})
  public static final class n
    implements MPVideoViewControlBar.a
  {
    public final void a(fu paramfu, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7498);
      Object localObject = MPVideoView.k(this.ouf);
      if (localObject != null) {
        ((MPVideoView.c)localObject).a(paramInt1, paramInt2, paramfu);
      }
      this.ouf.setAutoPlay(this.ouf.isPlaying());
      paramInt1 = this.ouf.getCurrPosMs();
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.ouf);
      if (localMPExoVideoWrapper == null) {
        p.gfZ();
      }
      if (paramfu == null) {
        p.gfZ();
      }
      String str = paramfu.Fyc;
      ad.i(MPExoVideoWrapper.TAG, "onSetResolution %b", new Object[] { Boolean.valueOf(localMPExoVideoWrapper.otm) });
      localMPExoVideoWrapper.otl = true;
      localMPExoVideoWrapper.osW = str;
      localObject = localMPExoVideoWrapper.osX;
      if (localObject != null)
      {
        localObject = ((MPExoVideoTextureView)localObject).getBitmap();
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label348;
        }
        ImageView localImageView = localMPExoVideoWrapper.osT;
        if (localImageView != null) {
          localImageView.setImageBitmap((Bitmap)localObject);
        }
        label169:
        localObject = localMPExoVideoWrapper.osU;
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)localMPExoVideoWrapper.getContext().getString(2131761350, new Object[] { str }));
        }
        localMPExoVideoWrapper.bSp();
        localMPExoVideoWrapper.tx(0L);
        localObject = MPVideoView.h(this.ouf);
        if (localObject == null) {
          p.gfZ();
        }
        ((MPExoVideoWrapper)localObject).bSt();
        localObject = this.ouf;
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
        localObject = this.ouf;
        paramfu = paramfu.url;
        p.g(paramfu, "info!!.url");
        ((MPVideoView)localObject).cD(paramfu, this.ouf.getDuration());
        if (!MPVideoView.E(this.ouf))
        {
          paramfu = MPVideoView.h(this.ouf);
          if (paramfu == null) {
            p.gfZ();
          }
          paramfu.pause();
        }
        paramfu = MPVideoView.c(this.ouf);
        if (paramfu == null) {
          break label373;
        }
        paramfu.hide();
        AppMethodBeat.o(7498);
        return;
        localObject = null;
        break;
        localObject = localMPExoVideoWrapper.osT;
        if (localObject == null) {
          break label169;
        }
        ((ImageView)localObject).setImageResource(2131233299);
        break label169;
      }
      label373:
      AppMethodBeat.o(7498);
    }
    
    public final void bRW()
    {
      AppMethodBeat.i(7499);
      MPVideoView.c localc = MPVideoView.k(this.ouf);
      if (localc != null)
      {
        localc.bRW();
        AppMethodBeat.o(7499);
        return;
      }
      AppMethodBeat.o(7499);
    }
    
    public final void bRX()
    {
      AppMethodBeat.i(7497);
      MPVideoView.c localc = MPVideoView.k(this.ouf);
      if (localc != null)
      {
        localc.bRX();
        AppMethodBeat.o(7497);
        return;
      }
      AppMethodBeat.o(7497);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initGestureController$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$GestureOperationHelper;", "canAdjustBrightness", "", "canAdjustProgress", "canAdjustVolume", "getCurrentPosition", "", "onAdjustBrightness", "", "brightness", "", "onAdjustVolume", "volumePercent", "onCanHandleGesture", "onDoubleTap", "onDragProgress", "startDragPos", "distanceX", "onEndAdjustBrightness", "onEndAdjustVolume", "onEndDragProgress", "dragPosition", "totalDistanceX", "onSingleTap", "onStartDragProgress", "plugin-brandservice_release"})
  public static final class o
    implements a.b
  {
    public final void aC(float paramFloat)
    {
      AppMethodBeat.i(7506);
      if (!MPVideoView.r(this.ouf))
      {
        AppMethodBeat.o(7506);
        return;
      }
      ad.d(MPVideoView.access$getTAG$cp(), "onAdjustVolume:".concat(String.valueOf(paramFloat)));
      Object localObject = MPVideoView.n(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      ((AppBrandDotPercentIndicator)localObject).setPercent(paramFloat);
      localObject = MPVideoView.o(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      ((TextView)localObject).setText(2131760999);
      localObject = MPVideoView.p(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      ((ImageView)localObject).setImageResource(2131231041);
      localObject = MPVideoView.q(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      ((LinearLayout)localObject).setVisibility(0);
      MPVideoView.f(this.ouf);
      AppMethodBeat.o(7506);
    }
    
    public final void aD(float paramFloat)
    {
      AppMethodBeat.i(7507);
      if (!MPVideoView.r(this.ouf))
      {
        AppMethodBeat.o(7507);
        return;
      }
      ad.d(MPVideoView.access$getTAG$cp(), "onAdjustBrightness:".concat(String.valueOf(paramFloat)));
      Object localObject = MPVideoView.n(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      ((AppBrandDotPercentIndicator)localObject).setPercent(paramFloat);
      localObject = MPVideoView.o(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      ((TextView)localObject).setText(2131760998);
      localObject = MPVideoView.p(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      ((ImageView)localObject).setImageResource(2131231033);
      localObject = MPVideoView.q(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      ((LinearLayout)localObject).setVisibility(0);
      MPVideoView.f(this.ouf);
      AppMethodBeat.o(7507);
    }
    
    public final void bmV()
    {
      AppMethodBeat.i(7500);
      ad.d(MPVideoView.access$getTAG$cp(), "onSingleTap");
      if ((MPVideoView.a(this.ouf)) && (!MPVideoView.b(this.ouf)))
      {
        localObject = MPVideoView.c(this.ouf);
        if (localObject == null) {
          p.gfZ();
        }
        ((MPVideoViewControlBar)localObject).bng();
      }
      Object localObject = MPVideoView.d(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      if ((((View)localObject).getVisibility() != 0) && (MPVideoView.e(this.ouf))) {
        MPVideoView.f(this.ouf);
      }
      AppMethodBeat.o(7500);
    }
    
    public final void bmW()
    {
      AppMethodBeat.i(7501);
      ad.d(MPVideoView.access$getTAG$cp(), "onDoubleTap");
      if (MPVideoView.g(this.ouf))
      {
        Object localObject = MPVideoView.h(this.ouf);
        if (localObject == null) {
          p.gfZ();
        }
        if (((MPExoVideoWrapper)localObject).isPlaying())
        {
          this.ouf.pause();
          localObject = m.orL;
          m.a.Ac(35);
          AppMethodBeat.o(7501);
          return;
        }
        this.ouf.start();
        localObject = m.orL;
        m.a.Ac(36);
      }
      AppMethodBeat.o(7501);
    }
    
    public final void bmX()
    {
      AppMethodBeat.i(7502);
      if (!MPVideoView.i(this.ouf))
      {
        AppMethodBeat.o(7502);
        return;
      }
      Object localObject = MPVideoView.j(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      ((TextView)localObject).setVisibility(0);
      MPVideoView.f(this.ouf);
      if (this.ouf.isPlaying()) {
        this.ouf.bSA();
      }
      localObject = MPVideoView.k(this.ouf);
      if (localObject != null)
      {
        ((MPVideoView.c)localObject).bmX();
        AppMethodBeat.o(7502);
        return;
      }
      AppMethodBeat.o(7502);
    }
    
    public final void bmY()
    {
      AppMethodBeat.i(7508);
      if (!MPVideoView.r(this.ouf))
      {
        AppMethodBeat.o(7508);
        return;
      }
      Object localObject = MPVideoView.q(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      ((LinearLayout)localObject).setVisibility(8);
      MPVideoView.l(this.ouf);
      localObject = m.orL;
      m.a.Ac(41);
      AppMethodBeat.o(7508);
    }
    
    public final void bmZ()
    {
      AppMethodBeat.i(7509);
      if (!MPVideoView.r(this.ouf))
      {
        AppMethodBeat.o(7509);
        return;
      }
      Object localObject = MPVideoView.q(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      ((LinearLayout)localObject).setVisibility(8);
      MPVideoView.l(this.ouf);
      localObject = m.orL;
      m.a.Ac(39);
      AppMethodBeat.o(7509);
    }
    
    public final boolean bna()
    {
      AppMethodBeat.i(221703);
      boolean bool = MPVideoView.r(this.ouf);
      AppMethodBeat.o(221703);
      return bool;
    }
    
    public final boolean bnb()
    {
      AppMethodBeat.i(221704);
      boolean bool = MPVideoView.r(this.ouf);
      AppMethodBeat.o(221704);
      return bool;
    }
    
    public final boolean bnc()
    {
      AppMethodBeat.i(7512);
      boolean bool = MPVideoView.i(this.ouf);
      AppMethodBeat.o(7512);
      return bool;
    }
    
    public final int getCurrentPosition()
    {
      AppMethodBeat.i(7505);
      MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.ouf);
      if (localMPExoVideoWrapper == null) {
        p.gfZ();
      }
      int i = localMPExoVideoWrapper.getCurrPosSec();
      AppMethodBeat.o(7505);
      return i;
    }
    
    public final int k(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(7503);
      if (!MPVideoView.i(this.ouf))
      {
        AppMethodBeat.o(7503);
        return 0;
      }
      ad.i(MPVideoView.access$getTAG$cp(), "onDragProgress:" + paramInt + '/' + paramFloat);
      Object localObject = MPVideoView.h(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      paramInt = ((MPExoVideoWrapper)localObject).getVideoDurationSec();
      int i = com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a.c(paramFloat, this.ouf.getMeasuredWidth(), getCurrentPosition(), paramInt);
      localObject = com.tencent.mm.plugin.appbrand.jsapi.video.l.sm(paramInt * 1000L);
      TextView localTextView = MPVideoView.j(this.ouf);
      if (localTextView == null) {
        p.gfZ();
      }
      localTextView.setText((CharSequence)(com.tencent.mm.plugin.appbrand.jsapi.video.l.sm(i * 1000L) + "/" + (String)localObject));
      localObject = MPVideoView.c(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      ((MPVideoViewControlBar)localObject).seek(i);
      localObject = MPVideoView.c(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      if (((MPVideoViewControlBar)localObject).bni())
      {
        localObject = MPVideoView.c(this.ouf);
        if (localObject == null) {
          p.gfZ();
        }
        ((MPVideoViewControlBar)localObject).bno();
      }
      AppMethodBeat.o(7503);
      return i;
    }
    
    public final void l(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(7504);
      if (!MPVideoView.i(this.ouf))
      {
        AppMethodBeat.o(7504);
        return;
      }
      Object localObject = MPVideoView.j(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      ((TextView)localObject).setVisibility(8);
      MPVideoView.l(this.ouf);
      localObject = MPVideoView.h(this.ouf);
      if (localObject == null) {
        p.gfZ();
      }
      int i = ((MPExoVideoWrapper)localObject).getCurrPosSec();
      ad.i(MPVideoView.access$getTAG$cp(), "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Float.valueOf(paramFloat) });
      MPVideoView.a(this.ouf, paramInt * 1000);
      MPVideoView.m(this.ouf);
      localObject = MPVideoView.k(this.ouf);
      if (localObject != null)
      {
        ((MPVideoView.c)localObject).bRS();
        AppMethodBeat.o(7504);
        return;
      }
      AppMethodBeat.o(7504);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initVideoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-brandservice_release"})
  public static final class p
    implements i.b
  {
    public final void c(String paramString1, String paramString2, final String paramString3, final int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7521);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      p.h(paramString3, "errorMsg");
      ad.i(MPVideoView.access$getTAG$cp(), "onError errorMsg=%s what=%d extra=%d", new Object[] { paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      aq.f((Runnable)new a(this, paramString3, paramInt1));
      AppMethodBeat.o(7521);
    }
    
    public final void d(String paramString1, String paramString2, final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(7524);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      this.ouf.setVideoWidth(paramInt1);
      this.ouf.setVideoHeight(paramInt2);
      paramString1 = MPVideoView.k(this.ouf);
      if (paramString1 != null) {
        paramString1.bRR();
      }
      aq.f((Runnable)new b(this, paramInt1, paramInt2));
      AppMethodBeat.o(7524);
    }
    
    public final void dq(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7522);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      ad.i(MPVideoView.access$getTAG$cp(), "onPrepared");
      aq.f((Runnable)new c(this));
      AppMethodBeat.o(7522);
    }
    
    public final void dr(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7523);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      ad.i(MPVideoView.access$getTAG$cp(), "onVideoEnded");
      aq.f((Runnable)new d(this));
      AppMethodBeat.o(7523);
    }
    
    public final void ds(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7525);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      ad.i(MPVideoView.access$getTAG$cp(), "onVideoPause");
      this.ouf.bSA();
      paramString1 = MPVideoView.k(this.ouf);
      if (paramString1 != null) {
        paramString1.onVideoPause();
      }
      if (this.ouf.getPlayStatus() != 4) {
        this.ouf.setPlayStatus(3);
      }
      paramString1 = MPVideoView.h(this.ouf);
      if (paramString1 == null) {
        p.gfZ();
      }
      paramString1 = paramString1.osU;
      if (paramString1 == null) {
        p.gfZ();
      }
      if (paramString1.getVisibility() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        aq.o((Runnable)new e(this), 1000L);
        AppMethodBeat.o(7525);
        return;
      }
      this.ouf.bSC();
      AppMethodBeat.o(7525);
    }
    
    public final void dt(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7526);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      aq.f((Runnable)new f(this));
      AppMethodBeat.o(7526);
    }
    
    public final void du(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7527);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      ad.i(MPVideoView.access$getTAG$cp(), "onVideoWaiting");
      aq.f((Runnable)new g(this));
      AppMethodBeat.o(7527);
    }
    
    public final void dv(String paramString1, String paramString2)
    {
      AppMethodBeat.i(7528);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      aq.f((Runnable)new h(this));
      AppMethodBeat.o(7528);
    }
    
    public final void eT(String paramString1, String paramString2)
    {
      AppMethodBeat.i(210146);
      p.h(paramString1, "sessionId");
      p.h(paramString2, "mediaId");
      AppMethodBeat.o(210146);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPVideoView.p paramp, String paramString, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(7513);
        this.oug.ouf.bSA();
        MPVideoView.c localc = MPVideoView.k(this.oug.ouf);
        if (localc != null) {
          localc.XU(paramString3);
        }
        this.oug.ouf.setPlayStatus(4);
        AppMethodBeat.o(7513);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(MPVideoView.p paramp, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(7514);
        int i = MPVideoView.y(this.oug.ouf);
        Object localObject = MPVideoView.oue;
        if (i == MPVideoView.bSE())
        {
          localObject = this.oug.ouf;
          if (paramInt1 >= paramInt2) {
            break label89;
          }
        }
        label89:
        for (i = 0;; i = 90)
        {
          MPVideoView.b((MPVideoView)localObject, i);
          ad.i(MPVideoView.access$getTAG$cp(), "onGetVideoSize adjust direction from AUTO to %s", new Object[] { Integer.valueOf(MPVideoView.y(this.oug.ouf)) });
          AppMethodBeat.o(7514);
          return;
        }
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7515);
        Object localObject = MPVideoView.k(this.oug.ouf);
        MPExoVideoWrapper localMPExoVideoWrapper;
        if (localObject != null)
        {
          localMPExoVideoWrapper = MPVideoView.h(this.oug.ouf);
          if (localMPExoVideoWrapper == null) {
            break label80;
          }
        }
        label80:
        for (long l = localMPExoVideoWrapper.getFirstRenderTime();; l = 0L)
        {
          ((MPVideoView.c)localObject).tt(l);
          localObject = MPVideoView.s(this.oug.ouf);
          if (localObject == null) {
            p.gfZ();
          }
          ((com.tencent.mm.plugin.appbrand.jsapi.video.ui.a)localObject).boJ();
          AppMethodBeat.o(7515);
          return;
        }
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class d
      implements Runnable
    {
      d(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7516);
        this.oug.ouf.bSA();
        Object localObject = MPVideoView.j(this.oug.ouf);
        if (localObject == null) {
          p.gfZ();
        }
        ((TextView)localObject).setVisibility(8);
        if (MPVideoView.b(this.oug.ouf))
        {
          localObject = MPVideoView.d(this.oug.ouf);
          if (localObject == null) {
            p.gfZ();
          }
          ((View)localObject).setVisibility(0);
          localObject = MPVideoView.c(this.oug.ouf);
          if (localObject == null) {
            p.gfZ();
          }
          if (((MPVideoViewControlBar)localObject).bni())
          {
            localObject = MPVideoView.c(this.oug.ouf);
            if (localObject == null) {
              p.gfZ();
            }
            ((MPVideoViewControlBar)localObject).hide();
          }
          localObject = MPVideoView.t(this.oug.ouf);
          if (localObject == null) {
            p.gfZ();
          }
          if (((FrameLayout)localObject).getVisibility() == 0)
          {
            localObject = MPVideoView.t(this.oug.ouf);
            if (localObject == null) {
              p.gfZ();
            }
            ((FrameLayout)localObject).setVisibility(8);
          }
          if ((!MPVideoView.u(this.oug.ouf)) && (MPVideoView.b(this.oug.ouf))) {
            break label318;
          }
          localObject = MPVideoView.v(this.oug.ouf);
          if (localObject == null) {
            p.gfZ();
          }
          ((View)localObject).setVisibility(8);
        }
        for (;;)
        {
          this.oug.ouf.bSr();
          this.oug.ouf.setPlayStatus(4);
          localObject = MPVideoView.k(this.oug.ouf);
          if (localObject == null) {
            break label407;
          }
          ((MPVideoView.c)localObject).onVideoEnded();
          AppMethodBeat.o(7516);
          return;
          localObject = MPVideoView.c(this.oug.ouf);
          if (localObject == null) {
            p.gfZ();
          }
          ((MPVideoViewControlBar)localObject).bSH();
          localObject = MPVideoView.c(this.oug.ouf);
          if (localObject == null) {
            p.gfZ();
          }
          ((MPVideoViewControlBar)localObject).show();
          break;
          label318:
          if (MPVideoView.w(this.oug.ouf) <= 0)
          {
            localObject = MPVideoView.x(this.oug.ouf);
            if (localObject == null) {
              p.gfZ();
            }
            MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.oug.ouf);
            if (localMPExoVideoWrapper == null) {
              p.gfZ();
            }
            ((TextView)localObject).setText((CharSequence)MPVideoView.Ai(localMPExoVideoWrapper.getVideoDurationSec()));
          }
          localObject = MPVideoView.v(this.oug.ouf);
          if (localObject == null) {
            p.gfZ();
          }
          ((View)localObject).setVisibility(0);
        }
        label407:
        AppMethodBeat.o(7516);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class e
      implements Runnable
    {
      e(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7517);
        this.oug.ouf.bSC();
        AppMethodBeat.o(7517);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class f
      implements Runnable
    {
      f(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7518);
        ad.i(MPVideoView.access$getTAG$cp(), "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(MPVideoView.u(this.oug.ouf)) });
        MPVideoView.z(this.oug.ouf);
        this.oug.ouf.bSs();
        Object localObject = MPVideoView.k(this.oug.ouf);
        if (localObject != null) {
          ((MPVideoView.c)localObject).onVideoPlay();
        }
        if ((MPVideoView.w(this.oug.ouf) <= 0) && (!MPVideoView.u(this.oug.ouf)))
        {
          localObject = MPVideoView.x(this.oug.ouf);
          if (localObject == null) {
            p.gfZ();
          }
          MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.oug.ouf);
          if (localMPExoVideoWrapper == null) {
            p.gfZ();
          }
          ((TextView)localObject).setText((CharSequence)MPVideoView.Ai(localMPExoVideoWrapper.getVideoDurationSec()));
        }
        MPVideoView.b(this.oug.ouf, MPVideoView.u(this.oug.ouf));
        if (MPVideoView.a(this.oug.ouf)) {
          MPVideoView.A(this.oug.ouf);
        }
        MPVideoView.m(this.oug.ouf);
        this.oug.ouf.setPlayStatus(2);
        localObject = MPVideoView.c(this.oug.ouf);
        if (localObject == null) {
          p.gfZ();
        }
        if (((MPVideoViewControlBar)localObject).bni())
        {
          localObject = MPVideoView.c(this.oug.ouf);
          if (localObject == null) {
            p.gfZ();
          }
          ((MPVideoViewControlBar)localObject).bno();
        }
        AppMethodBeat.o(7518);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class g
      implements Runnable
    {
      g(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7519);
        MPVideoView.a(this.oug.ouf, true);
        MPVideoView.f(this.oug.ouf);
        MPVideoView.c localc = MPVideoView.k(this.oug.ouf);
        if (localc != null)
        {
          localc.onVideoWaiting();
          AppMethodBeat.o(7519);
          return;
        }
        AppMethodBeat.o(7519);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class h
      implements Runnable
    {
      h(MPVideoView.p paramp) {}
      
      public final void run()
      {
        AppMethodBeat.i(7520);
        MPVideoView.a(this.oug.ouf, false);
        MPVideoView.l(this.oug.ouf);
        MPVideoView.c localc = MPVideoView.k(this.oug.ouf);
        if (localc != null)
        {
          localc.bRU();
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