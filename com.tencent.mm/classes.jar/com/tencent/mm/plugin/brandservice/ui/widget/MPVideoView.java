package com.tencent.mm.plugin.brandservice.ui.widget;

import a.f.b.j;
import a.l.m;
import a.v;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.s;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.l.b;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroudContainerLayout", "Landroid/widget/FrameLayout;", "getBackgroudContainerLayout", "()Landroid/widget/FrameLayout;", "setBackgroudContainerLayout", "(Landroid/widget/FrameLayout;)V", "cacheTimeSec", "getCacheTimeSec", "()I", "currPosMs", "getCurrPosMs", "currPosSec", "getCurrPosSec", "duration", "getDuration", "setDuration", "(I)V", "endPlayTime", "getEndPlayTime", "isCoverVisible", "", "()Z", "isInFullScreen", "isLive", "mAdjustContentTv", "Landroid/widget/TextView;", "mAdjustIconIv", "Landroid/widget/ImageView;", "mAdjustInfoLayout", "Landroid/widget/LinearLayout;", "mAdjustPercentIndicator", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandDotPercentIndicator;", "mAutoPlay", "mBottomProgressBackBar", "mBottomProgressFrontBar", "mBottomProgressLayout", "mConsumeTouchEvent", "mControlBar", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoViewControlBar;", "mCoverArea", "Landroid/view/View;", "mCoverIv", "mCoverPlayBtnArea", "mCoverTotalTimeTv", "mCoverUrl", "", "mDirection", "mDuration", "mEnablePlayGesture", "mEnableProgressGesture", "mFullScreenDelegate", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "mGestureController", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/VideoPlayerGestureController;", "mInitialTime", "", "mIsAlive", "mIsLoading", "mIsMute", "mIsShowBasicControls", "mLoop", "mMPVideoViewCallBack", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "mOnTouchListener", "Landroid/view/View$OnTouchListener;", "mPageGesture", "mPageGestureInFullscreen", "mPlayStart", "mPlayStarted", "mProgressTv", "mRealPlayTime", "", "mSetIsShowCoverPlayBtn", "mSetIsShowProgressBar", "mSkipAutoPause", "mStartPlayTime", "mVideoSource", "mVideoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoWrapper;", "playStatus", "getPlayStatus", "setPlayStatus", "playerAdContainerLayout", "getPlayerAdContainerLayout", "setPlayerAdContainerLayout", "realPlayTime", "getRealPlayTime", "()J", "<set-?>", "videoPath", "getVideoPath", "()Ljava/lang/String;", "setVideoPath", "(Ljava/lang/String;)V", "canAdjustBrightnessVolume", "canDragProgress", "clean", "", "doPlayReport", "doStopReport", "downloadVideo", "videoUrl", "enableProgressGesture", "enable", "getAutoPlay", "getPlayStart", "getPlayStarted", "getTimeShowString", "time", "hideCenterPlayBtnIfNeed", "hideControlBarCover", "init", "initControlBar", "initGestureController", "initParam", "initVideoViewCallback", "isPlaying", "makeTimeString", "d", "onExitFullScreen", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onUIDestroy", "onUIPause", "onUIResume", "operateFullScreen", "toFullScreen", "direction", "pause", "seekTo", "position", "afterPlay", "setAutoPlay", "autoPlay", "setConsumeTouchEvent", "value", "setCover", "setCoverByUrl", "cover", "coverUrl", "width", "height", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "setCustomOnTouchListener", "l", "setEnablePlayGesture", "enablePlayGesture", "setFullScreenDelegate", "delegate", "setFullScreenDirection", "setInitialTime", "initialTime", "setIsShowBasicControls", "isShowBasicControls", "setLoop", "loop", "setMPVideoViewCallBack", "setMute", "isMute", "setObjectFit", "setPageGesture", "pageGesture", "setPageGestureInFullscreen", "pageGestureInFullscreen", "setPlayBtnOnClickListener", "click", "Landroid/view/View$OnClickListener;", "setPlayBtnPosition", "playBtnPosition", "setPlaybackRate", "rate", "", "setPreLoadVidePath", "setShowCenterPlayBtn", "showCenterPlayBtn", "setShowControlProgress", "showControlProgress", "setShowFullScreenBtn", "showFullScreenBtn", "setShowMuteBtn", "showMuteBtn", "setShowPlayBtn", "showPlayBtn", "setShowProgress", "showProgress", "setTitle", "title", "durationSec", "setVideoSource", "videoSource", "shouldDispatchEventToGestureController", "showCenterPlayBtnIfNeed", "showControlBar", "showControlBarCover", "start", "stop", "updateBottomProgressLayout", "updateLiveUI", "Companion", "FullScreenDelegate", "MPVideoViewCallBack", "plugin-brandservice_release"})
public final class MPVideoView
  extends RelativeLayout
{
  public static final String TAG = "MicroMsg.MPVideoView";
  private static final int kjO = -1;
  private static final int kjP = 8;
  public static final MPVideoView.a kjQ;
  private int Td;
  private int fVj;
  private boolean icD;
  private boolean icF;
  private boolean icG;
  private com.tencent.mm.plugin.appbrand.jsapi.video.l icH;
  public boolean icJ;
  private boolean icK;
  public double icL;
  private String icM;
  private boolean icN;
  private boolean icO;
  private boolean icP;
  private boolean icQ;
  public int icR;
  private boolean icT;
  private boolean icU;
  public boolean icV;
  private TextView icm;
  private View icp;
  private View icq;
  private TextView icr;
  private LinearLayout ics;
  private AppBrandDotPercentIndicator ict;
  private TextView icu;
  private ImageView icv;
  private ImageView icw;
  private ImageView icx;
  private ImageView icy;
  private FrameLayout icz;
  public MPVideoWrapper kjD;
  public MPVideoViewControlBar kjE;
  private FrameLayout kjF;
  private FrameLayout kjG;
  private boolean kjH;
  private boolean kjI;
  private MPVideoView.b kjJ;
  private c kjK;
  private View.OnTouchListener kjL;
  private long kjM;
  private long kjN;
  public boolean mAutoPlay;
  private int mDuration;
  public boolean mIsMute;
  public String videoPath;
  
  static
  {
    AppMethodBeat.i(153053);
    kjQ = new MPVideoView.a((byte)0);
    TAG = "MicroMsg.MPVideoView";
    kjO = -1;
    kjP = 8;
    AppMethodBeat.o(153053);
  }
  
  public MPVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(153052);
    this.Td = kjO;
    init(paramContext);
    AppMethodBeat.o(153052);
  }
  
  public MPVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(14520);
    this.Td = kjO;
    init(paramContext);
    AppMethodBeat.o(14520);
  }
  
  public MPVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(14521);
    this.Td = kjO;
    init(paramContext);
    AppMethodBeat.o(14521);
  }
  
  private final void aEO()
  {
    AppMethodBeat.i(153050);
    MPVideoViewControlBar localMPVideoViewControlBar = this.kjE;
    if (localMPVideoViewControlBar == null) {
      j.ebi();
    }
    localMPVideoViewControlBar.aEO();
    AppMethodBeat.o(153050);
  }
  
  private final boolean aES()
  {
    AppMethodBeat.i(14572);
    if (this.icO)
    {
      MPVideoWrapper localMPVideoWrapper = this.kjD;
      if (localMPVideoWrapper == null) {
        j.ebi();
      }
      if ((!localMPVideoWrapper.isLive()) && (!aEU()))
      {
        AppMethodBeat.o(14572);
        return true;
      }
    }
    AppMethodBeat.o(14572);
    return false;
  }
  
  private final boolean aET()
  {
    AppMethodBeat.i(14573);
    if ((!aEU()) && (((!aEQ()) && (this.icF)) || ((aEQ()) && (this.icG))))
    {
      AppMethodBeat.o(14573);
      return true;
    }
    AppMethodBeat.o(14573);
    return false;
  }
  
  private final boolean aEU()
  {
    AppMethodBeat.i(14574);
    View localView = this.icp;
    if (localView == null) {
      j.ebi();
    }
    if (localView.getVisibility() == 0)
    {
      AppMethodBeat.o(14574);
      return true;
    }
    AppMethodBeat.o(14574);
    return false;
  }
  
  private final void init(Context paramContext)
  {
    AppMethodBeat.i(14522);
    LayoutInflater.from(paramContext).inflate(2130970311, (ViewGroup)this);
    this.kjD = ((MPVideoWrapper)findViewById(2131821436));
    paramContext = findViewById(2131821404);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(14522);
      throw paramContext;
    }
    this.icm = ((TextView)paramContext);
    this.icp = findViewById(2131821437);
    this.icq = findViewById(2131821439);
    paramContext = findViewById(2131821441);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(14522);
      throw paramContext;
    }
    this.icr = ((TextView)paramContext);
    paramContext = findViewById(2131821443);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(14522);
      throw paramContext;
    }
    this.ics = ((LinearLayout)paramContext);
    paramContext = findViewById(2131821446);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandDotPercentIndicator");
      AppMethodBeat.o(14522);
      throw paramContext;
    }
    this.ict = ((AppBrandDotPercentIndicator)paramContext);
    paramContext = findViewById(2131821445);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(14522);
      throw paramContext;
    }
    this.icu = ((TextView)paramContext);
    paramContext = findViewById(2131821444);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(14522);
      throw paramContext;
    }
    this.icv = ((ImageView)paramContext);
    paramContext = findViewById(2131821438);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(14522);
      throw paramContext;
    }
    this.icw = ((ImageView)paramContext);
    paramContext = findViewById(2131821449);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(14522);
      throw paramContext;
    }
    this.icx = ((ImageView)paramContext);
    paramContext = findViewById(2131821448);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(14522);
      throw paramContext;
    }
    this.icy = ((ImageView)paramContext);
    paramContext = findViewById(2131821447);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(14522);
      throw paramContext;
    }
    this.icz = ((FrameLayout)paramContext);
    paramContext = findViewById(2131826381);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(14522);
      throw paramContext;
    }
    this.kjF = ((FrameLayout)paramContext);
    paramContext = findViewById(2131826378);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(14522);
      throw paramContext;
    }
    this.kjG = ((FrameLayout)paramContext);
    paramContext = this.ict;
    if (paramContext == null) {
      j.ebi();
    }
    paramContext.setDotsNum(kjP);
    paramContext = findViewById(2131821440);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(14522);
      throw paramContext;
    }
    ((ImageView)paramContext).setOnClickListener((View.OnClickListener)new MPVideoView.d(this));
    this.icH = new com.tencent.mm.plugin.appbrand.jsapi.video.l(getContext(), (View)this, (l.b)new MPVideoView.m(this));
    paramContext = this.kjD;
    if (paramContext == null) {
      j.ebi();
    }
    paramContext.setIMMVideoViewCallback((d.b)new MPVideoView.n(this));
    this.kjE = new MPVideoViewControlBar(getContext());
    paramContext = this.kjD;
    if (paramContext == null) {
      j.ebi();
    }
    paramContext.setVideoFooterView((g)this.kjE);
    paramContext = this.kjE;
    if (paramContext == null) {
      j.ebi();
    }
    paramContext.hide();
    paramContext = this.kjE;
    if (paramContext == null) {
      j.ebi();
    }
    paramContext.setFullScreenBtnOnClickListener((View.OnClickListener)new MPVideoView.e(this));
    paramContext = this.kjE;
    if (paramContext == null) {
      j.ebi();
    }
    paramContext.setIplaySeekCallback((d.c)new MPVideoView.f(this));
    paramContext = this.kjE;
    if (paramContext == null) {
      j.ebi();
    }
    paramContext.setOnPlayButtonClickListener((View.OnClickListener)new MPVideoView.g(this));
    paramContext = this.kjE;
    if (paramContext == null) {
      j.ebi();
    }
    paramContext.setStatePorter((d.h)new MPVideoView.h(this));
    paramContext = this.kjE;
    if (paramContext == null) {
      j.ebi();
    }
    paramContext.setMuteBtnOnClickListener((View.OnClickListener)new MPVideoView.i(this));
    paramContext = this.kjE;
    if (paramContext == null) {
      j.ebi();
    }
    paramContext.setExitFullScreenBtnOnClickListener((View.OnClickListener)new MPVideoView.j(this));
    paramContext = this.kjE;
    if (paramContext == null) {
      j.ebi();
    }
    paramContext.a((d.e)new MPVideoView.k(this));
    paramContext = this.kjE;
    if (paramContext == null) {
      j.ebi();
    }
    paramContext.setOnUpdateProgressLenListener((d.d)new MPVideoView.l(this));
    paramContext = this.kjD;
    if (paramContext == null) {
      j.ebi();
    }
    paramContext.setControlBar((d.a)this.kjE);
    paramContext = this.kjD;
    if (paramContext == null) {
      j.ebi();
    }
    paramContext.setScaleType(d.g.idJ);
    paramContext = this.icw;
    if (paramContext == null) {
      j.ebi();
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
    ab.i(TAG, "enableProgressGesture %b", new Object[] { Boolean.TRUE });
    this.icO = true;
    setVideoSource(0);
    setConsumeTouchEvent(false);
    setIsShowBasicControls(true);
    AppMethodBeat.o(14522);
  }
  
  private final boolean isLive()
  {
    AppMethodBeat.i(14571);
    Object localObject = TAG;
    boolean bool = this.icJ;
    MPVideoWrapper localMPVideoWrapper = this.kjD;
    if (localMPVideoWrapper == null) {
      j.ebi();
    }
    ab.i((String)localObject, "isLive %b %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localMPVideoWrapper.isLive()) });
    if (!this.icJ)
    {
      localObject = this.kjD;
      if (localObject == null) {
        j.ebi();
      }
      if (!((MPVideoWrapper)localObject).isLive()) {}
    }
    else
    {
      AppMethodBeat.o(14571);
      return true;
    }
    AppMethodBeat.o(14571);
    return false;
  }
  
  private static String ok(int paramInt)
  {
    AppMethodBeat.i(14569);
    String str = ol(paramInt / 60) + ":" + ol(paramInt % 60);
    AppMethodBeat.o(14569);
    return str;
  }
  
  private static String ol(int paramInt)
  {
    AppMethodBeat.i(14570);
    if (paramInt < 10)
    {
      str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(14570);
      return str;
    }
    String str = String.valueOf(paramInt);
    AppMethodBeat.o(14570);
    return str;
  }
  
  private final void setVideoPath(String paramString)
  {
    this.videoPath = paramString;
  }
  
  public final void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, s params)
  {
    AppMethodBeat.i(14547);
    j.q(params, "msgInfo");
    ab.i(TAG, "setCover coverUrl=%s", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(14547);
      return;
    }
    this.icM = paramString;
    e locale = e.kif;
    if (paramString == null) {
      j.ebi();
    }
    e.a(paramImageView, paramString, paramInt1, paramInt2, params);
    AppMethodBeat.o(14547);
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, s params)
  {
    AppMethodBeat.i(153046);
    j.q(params, "msgInfo");
    Object localObject = this.kjE;
    if (localObject != null) {}
    for (localObject = ((MPVideoViewControlBar)localObject).getCoverIv();; localObject = null)
    {
      a((ImageView)localObject, paramString, paramInt1, paramInt2, params);
      paramString = this.kjE;
      if (paramString == null) {
        j.ebi();
      }
      paramString = paramString.getCoverIv();
      j.p(paramString, "mControlBar!!.coverIv");
      paramString.setVisibility(0);
      AppMethodBeat.o(153046);
      return;
    }
  }
  
  public final boolean aEQ()
  {
    AppMethodBeat.i(14567);
    if (this.kjJ == null)
    {
      ab.w(TAG, "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(14567);
      return false;
    }
    MPVideoView.b localb = this.kjJ;
    if (localb == null) {
      j.ebi();
    }
    boolean bool = localb.isFullScreen();
    AppMethodBeat.o(14567);
    return bool;
  }
  
  public final void bah()
  {
    AppMethodBeat.i(153047);
    Object localObject = this.kjE;
    if (localObject == null) {
      j.ebi();
    }
    localObject = ((MPVideoViewControlBar)localObject).getCoverIv();
    j.p(localObject, "mControlBar!!.coverIv");
    ((ImageView)localObject).setVisibility(8);
    AppMethodBeat.o(153047);
  }
  
  public final void e(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(14544);
    Object localObject = this.kjD;
    if (localObject == null) {
      j.ebi();
    }
    int i = ((MPVideoWrapper)localObject).getCurrPosSec();
    ab.i(TAG, "seek to position=%s current=%d isLive=%b", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(i), Boolean.valueOf(this.icJ) });
    if (isLive())
    {
      AppMethodBeat.o(14544);
      return;
    }
    localObject = this.icp;
    if (localObject == null) {
      j.ebi();
    }
    ((View)localObject).setVisibility(8);
    if (paramBoolean)
    {
      localObject = this.kjD;
      if (localObject == null) {
        j.ebi();
      }
      ((MPVideoWrapper)localObject).d(paramDouble, paramBoolean);
      AppMethodBeat.o(14544);
      return;
    }
    localObject = this.kjD;
    if (localObject == null) {
      j.ebi();
    }
    ((MPVideoWrapper)localObject).r(paramDouble);
    AppMethodBeat.o(14544);
  }
  
  public final boolean getAutoPlay()
  {
    return this.mAutoPlay;
  }
  
  public final FrameLayout getBackgroudContainerLayout()
  {
    return this.kjG;
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(14558);
    if (this.kjD != null)
    {
      MPVideoWrapper localMPVideoWrapper = this.kjD;
      if (localMPVideoWrapper == null) {
        j.ebi();
      }
      int i = localMPVideoWrapper.getCacheTimeSec();
      AppMethodBeat.o(14558);
      return i;
    }
    AppMethodBeat.o(14558);
    return 0;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(14557);
    MPVideoWrapper localMPVideoWrapper = this.kjD;
    if (localMPVideoWrapper == null) {
      j.ebi();
    }
    int i = localMPVideoWrapper.getCurrPosMs();
    AppMethodBeat.o(14557);
    return i;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(14556);
    MPVideoWrapper localMPVideoWrapper = this.kjD;
    if (localMPVideoWrapper == null) {
      j.ebi();
    }
    int i = localMPVideoWrapper.getCurrPosSec();
    AppMethodBeat.o(14556);
    return i;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(14535);
    if (this.mDuration > 0)
    {
      i = this.mDuration;
      AppMethodBeat.o(14535);
      return i;
    }
    MPVideoWrapper localMPVideoWrapper = this.kjD;
    if (localMPVideoWrapper == null) {
      j.ebi();
    }
    int i = localMPVideoWrapper.getVideoDurationSec();
    AppMethodBeat.o(14535);
    return i;
  }
  
  public final int getEndPlayTime()
  {
    AppMethodBeat.i(14529);
    if ((getCurrPosMs() == 0) && (this.fVj != 0))
    {
      i = getDuration();
      AppMethodBeat.o(14529);
      return i * 1000;
    }
    int i = getCurrPosMs();
    AppMethodBeat.o(14529);
    return i;
  }
  
  public final boolean getPlayStart()
  {
    return this.kjH;
  }
  
  public final boolean getPlayStarted()
  {
    return this.kjI;
  }
  
  public final int getPlayStatus()
  {
    return this.fVj;
  }
  
  public final FrameLayout getPlayerAdContainerLayout()
  {
    return this.kjF;
  }
  
  public final long getRealPlayTime()
  {
    AppMethodBeat.i(14528);
    if ((this.kjM == 0L) && (this.kjN != 0L) && (this.fVj != 0)) {
      this.kjM = (System.currentTimeMillis() - this.kjN);
    }
    long l = this.kjM;
    AppMethodBeat.o(14528);
    return l;
  }
  
  public final String getVideoPath()
  {
    return this.videoPath;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(153044);
    MPVideoWrapper localMPVideoWrapper = this.kjD;
    if (localMPVideoWrapper == null) {
      j.ebi();
    }
    boolean bool = localMPVideoWrapper.isPlaying();
    AppMethodBeat.o(153044);
    return bool;
  }
  
  public final void l(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(14566);
    ab.i(TAG, "operateFullScreen toFullScreen:%b direction:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.kjJ == null)
    {
      ab.w(TAG, "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(14566);
      return;
    }
    if (paramBoolean == aEQ())
    {
      ab.i(TAG, "operateFullScreen current same");
      AppMethodBeat.o(14566);
      return;
    }
    if (paramInt == kjO) {
      if (this.Td == kjO)
      {
        paramInt = 90;
        ab.i(TAG, "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject = this.kjJ;
        if (localObject == null) {
          j.ebi();
        }
        ((MPVideoView.b)localObject).oc(paramInt);
        localObject = this.kjE;
        if (localObject == null) {
          j.ebi();
        }
        ((MPVideoViewControlBar)localObject).aFp();
        AppMethodBeat.o(14566);
        return;
        paramInt = this.Td;
        break;
      }
      Object localObject = this.kjJ;
      if (localObject == null) {
        j.ebi();
      }
      ((MPVideoView.b)localObject).aDh();
      localObject = this.kjE;
      if (localObject == null) {
        j.ebi();
      }
      ((MPVideoViewControlBar)localObject).aDh();
      AppMethodBeat.o(14566);
      return;
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(14565);
    j.q(paramMotionEvent, "event");
    Object localObject;
    if (this.kjL != null)
    {
      localObject = this.kjL;
      if (localObject == null) {
        j.ebi();
      }
      ((View.OnTouchListener)localObject).onTouch((View)this, paramMotionEvent);
    }
    if (this.icU) {
      bool = true;
    }
    while (bool)
    {
      if (this.icH != null)
      {
        localObject = this.icH;
        if (localObject == null) {
          j.ebi();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.l)localObject).z(paramMotionEvent);
      }
      AppMethodBeat.o(14565);
      return true;
      bool = aES();
      if (!aET()) {
        bool = false;
      }
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if ((this.icD) && (!this.icQ))
      {
        localObject = this.kjE;
        if (localObject == null) {
          j.ebi();
        }
        ((MPVideoViewControlBar)localObject).aFo();
      }
      localObject = this.icp;
      if (localObject == null) {
        j.ebi();
      }
      if ((((View)localObject).getVisibility() != 0) && (this.icT)) {
        aEO();
      }
    }
    if (this.icN)
    {
      AppMethodBeat.o(14565);
      return true;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(14565);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(14538);
    ab.i(TAG, "pause");
    MPVideoWrapper localMPVideoWrapper = this.kjD;
    if (localMPVideoWrapper == null) {
      j.ebi();
    }
    if (!localMPVideoWrapper.isPlaying())
    {
      AppMethodBeat.o(14538);
      return;
    }
    localMPVideoWrapper = this.kjD;
    if (localMPVideoWrapper == null) {
      j.ebi();
    }
    localMPVideoWrapper.pause();
    AppMethodBeat.o(14538);
  }
  
  public final void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(14532);
    ab.i(TAG, "setAutoPlay =%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mAutoPlay = paramBoolean;
    if (this.fVj == 0) {
      this.fVj = 1;
    }
    AppMethodBeat.o(14532);
  }
  
  public final void setBackgroudContainerLayout(FrameLayout paramFrameLayout)
  {
    this.kjG = paramFrameLayout;
  }
  
  public final void setConsumeTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(14524);
    ab.i(TAG, "setConsumeTouchEvent value=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icN = paramBoolean;
    AppMethodBeat.o(14524);
  }
  
  public final void setCover(String paramString)
  {
    AppMethodBeat.i(14548);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(14548);
      return;
    }
    if (!bo.isNullOrNil(this.icM))
    {
      ab.i(TAG, "setCover mCoverUrl not null");
      AppMethodBeat.o(14548);
      return;
    }
    b.O((Runnable)new MPVideoView.o(this, paramString));
    AppMethodBeat.o(14548);
  }
  
  public final void setCustomOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(153043);
    j.q(paramOnTouchListener, "l");
    this.kjL = paramOnTouchListener;
    AppMethodBeat.o(153043);
  }
  
  public final void setDuration(int paramInt)
  {
    AppMethodBeat.i(14534);
    if (paramInt <= 0)
    {
      ab.i(TAG, "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(14534);
      return;
    }
    TextView localTextView = this.icr;
    if (localTextView == null) {
      j.ebi();
    }
    localTextView.setText((CharSequence)ok(paramInt));
    this.mDuration = paramInt;
    AppMethodBeat.o(14534);
  }
  
  public final void setEnablePlayGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(14531);
    ab.i(TAG, "setEnablePlayGesture: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icU = paramBoolean;
    AppMethodBeat.o(14531);
  }
  
  public final void setFullScreenDelegate(MPVideoView.b paramb)
  {
    AppMethodBeat.i(153048);
    j.q(paramb, "delegate");
    this.kjJ = paramb;
    AppMethodBeat.o(153048);
  }
  
  public final void setFullScreenDirection(int paramInt)
  {
    AppMethodBeat.i(14559);
    ab.i(TAG, "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.Td = paramInt;
    AppMethodBeat.o(14559);
  }
  
  public final void setInitialTime(double paramDouble)
  {
    AppMethodBeat.i(14562);
    ab.i(TAG, "setInitialTime initialTime=%s", new Object[] { Double.valueOf(paramDouble) });
    this.icL = paramDouble;
    AppMethodBeat.o(14562);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(14545);
    ab.i(TAG, "setIsShowBasicControls isShowBasicControls=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icD = paramBoolean;
    if (this.kjE != null)
    {
      if (this.icD)
      {
        localMPVideoViewControlBar = this.kjE;
        if (localMPVideoViewControlBar == null) {
          j.ebi();
        }
        localMPVideoViewControlBar.aFm();
        AppMethodBeat.o(14545);
        return;
      }
      MPVideoViewControlBar localMPVideoViewControlBar = this.kjE;
      if (localMPVideoViewControlBar == null) {
        j.ebi();
      }
      localMPVideoViewControlBar.hide();
    }
    AppMethodBeat.o(14545);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(14536);
    ab.i(TAG, "setLoop loop=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icK = paramBoolean;
    AppMethodBeat.o(14536);
  }
  
  public final void setMPVideoViewCallBack(c paramc)
  {
    AppMethodBeat.i(153049);
    j.q(paramc, "delegate");
    this.kjK = paramc;
    AppMethodBeat.o(153049);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(14555);
    ab.i(TAG, "setMute isMute=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    Object localObject = this.kjD;
    if (localObject == null) {
      j.ebi();
    }
    ((MPVideoWrapper)localObject).setMute(paramBoolean);
    localObject = this.kjE;
    if (localObject == null) {
      j.ebi();
    }
    ((MPVideoViewControlBar)localObject).setMuteBtnState(paramBoolean);
    AppMethodBeat.o(14555);
  }
  
  public final void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(14560);
    ab.i(TAG, "setPageGesture pageGesture=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icF = paramBoolean;
    AppMethodBeat.o(14560);
  }
  
  public final void setPageGestureInFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(14561);
    ab.i(TAG, "setPageGestureInFullscreen pageGestureInFullscreen=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icG = paramBoolean;
    AppMethodBeat.o(14561);
  }
  
  public final void setPlayBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(153051);
    j.q(paramOnClickListener, "click");
    MPVideoViewControlBar localMPVideoViewControlBar = this.kjE;
    if (localMPVideoViewControlBar != null)
    {
      localMPVideoViewControlBar.setPlayBtnOnClickListener(paramOnClickListener);
      AppMethodBeat.o(153051);
      return;
    }
    AppMethodBeat.o(153051);
  }
  
  public final void setPlayBtnPosition(String paramString)
  {
    AppMethodBeat.i(14530);
    j.q(paramString, "playBtnPosition");
    ab.i(TAG, "setPlayBtnPosition: %s", new Object[] { paramString });
    if ((!bo.isNullOrNil(paramString)) && (m.I(paramString, "center", true)))
    {
      paramString = this.kjE;
      if (paramString == null) {
        j.ebi();
      }
      paramString.setPlayBtnInCenterPosition(true);
      AppMethodBeat.o(14530);
      return;
    }
    paramString = this.kjE;
    if (paramString == null) {
      j.ebi();
    }
    paramString.setPlayBtnInCenterPosition(false);
    AppMethodBeat.o(14530);
  }
  
  public final void setPlayStatus(int paramInt)
  {
    this.fVj = paramInt;
  }
  
  public final void setPlayerAdContainerLayout(FrameLayout paramFrameLayout)
  {
    this.kjF = paramFrameLayout;
  }
  
  public final void setShowCenterPlayBtn(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(14553);
    ab.i(TAG, "setPlayBtnInCenterPosition %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icQ = paramBoolean;
    Object localObject = this.icp;
    if (localObject == null) {
      j.ebi();
    }
    if (paramBoolean)
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = this.icq;
      if (localObject == null) {
        j.ebi();
      }
      if (!paramBoolean) {
        break label131;
      }
    }
    label131:
    for (int i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      if ((this.icQ) && (this.kjE != null))
      {
        localObject = this.kjE;
        if (localObject == null) {
          j.ebi();
        }
        ((MPVideoViewControlBar)localObject).hide();
      }
      AppMethodBeat.o(14553);
      return;
      i = 8;
      break;
    }
  }
  
  public final void setShowControlProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(14527);
    ab.i(TAG, "setShowControlProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.kjE;
    if (localMPVideoViewControlBar == null) {
      j.ebi();
    }
    if ((paramBoolean) && (!isLive())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localMPVideoViewControlBar.setShowControlProgress(paramBoolean);
      AppMethodBeat.o(14527);
      return;
    }
  }
  
  public final void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(14550);
    ab.i(TAG, "setShowFullScreenBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.kjE;
    if (localMPVideoViewControlBar == null) {
      j.ebi();
    }
    localMPVideoViewControlBar.setShowFullScreenBtn(paramBoolean);
    AppMethodBeat.o(14550);
  }
  
  public final void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(14525);
    ab.i(TAG, "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.kjE;
    if (localMPVideoViewControlBar == null) {
      j.ebi();
    }
    localMPVideoViewControlBar.setShowMuteBtn(paramBoolean);
    AppMethodBeat.o(14525);
  }
  
  public final void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(14551);
    ab.i(TAG, "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MPVideoViewControlBar localMPVideoViewControlBar = this.kjE;
    if (localMPVideoViewControlBar == null) {
      j.ebi();
    }
    localMPVideoViewControlBar.setShowPlayBtn(paramBoolean);
    AppMethodBeat.o(14551);
  }
  
  public final void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(14549);
    ab.i(TAG, "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.icP = paramBoolean;
    MPVideoViewControlBar localMPVideoViewControlBar = this.kjE;
    if (localMPVideoViewControlBar == null) {
      j.ebi();
    }
    if ((paramBoolean) && (!isLive())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localMPVideoViewControlBar.setShowProgress(paramBoolean);
      AppMethodBeat.o(14549);
      return;
    }
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(14526);
    ab.i(TAG, "setTitle %s", new Object[] { paramString });
    MPVideoViewControlBar localMPVideoViewControlBar = this.kjE;
    if (localMPVideoViewControlBar == null) {
      j.ebi();
    }
    localMPVideoViewControlBar.setTitle(paramString);
    AppMethodBeat.o(14526);
  }
  
  public final void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(14533);
    ab.i(TAG, "setVideoSource =%d", new Object[] { Integer.valueOf(paramInt) });
    this.icR = paramInt;
    AppMethodBeat.o(14533);
  }
  
  public final void start()
  {
    AppMethodBeat.i(14537);
    ab.i(TAG, "start");
    Object localObject = this.kjD;
    if (localObject == null) {
      j.ebi();
    }
    if (((MPVideoWrapper)localObject).isPlaying())
    {
      AppMethodBeat.o(14537);
      return;
    }
    this.kjH = true;
    if (this.icD)
    {
      localObject = this.kjE;
      if (localObject == null) {
        j.ebi();
      }
      ((MPVideoViewControlBar)localObject).aFv();
    }
    localObject = this.icp;
    if (localObject == null) {
      j.ebi();
    }
    ((View)localObject).setVisibility(8);
    localObject = this.kjD;
    if (localObject == null) {
      j.ebi();
    }
    ((MPVideoWrapper)localObject).start();
    bah();
    AppMethodBeat.o(14537);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(14539);
    ab.i(TAG, "stop");
    Object localObject = this.kjD;
    if (localObject == null) {
      j.ebi();
    }
    if (!((MPVideoWrapper)localObject).isPlaying())
    {
      AppMethodBeat.o(14539);
      return;
    }
    localObject = this.kjD;
    if (localObject == null) {
      j.ebi();
    }
    ((MPVideoWrapper)localObject).stop();
    localObject = this.kjE;
    if (localObject == null) {
      j.ebi();
    }
    ((MPVideoViewControlBar)localObject).aFw();
    AppMethodBeat.o(14539);
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "", "onControlbarVisible", "", "visible", "", "onEndDragProgress", "onPlayError", "errorMsg", "", "errorCode", "", "onSeekTo", "time", "onUpdateProgress", "progressLen", "totalLen", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-brandservice_release"})
  public static abstract interface c
  {
    public abstract void Hs(String paramString);
    
    public abstract void aZD();
    
    public abstract void aZE();
    
    public abstract void aZF();
    
    public abstract void aZG();
    
    public abstract void fP(boolean paramBoolean);
    
    public abstract void onVideoPause();
    
    public abstract void onVideoPlay();
    
    public abstract void onVideoWaiting();
    
    public abstract void xT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView
 * JD-Core Version:    0.7.0.1
 */