package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.video.i;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.a.b.a;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import kotlin.f;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ERROR_CHECK_TIME", "", "getERROR_CHECK_TIME", "()I", "ERROR_TRY_AGAIN_DELAY_TIME", "getERROR_TRY_AGAIN_DELAY_TIME", "ERROR_TRY_MAX_TIME", "getERROR_TRY_MAX_TIME", "abTestVideoPreload", "", "getAbTestVideoPreload", "()Z", "abTestVideoPreload$delegate", "Lkotlin/Lazy;", "bandwidthFraction", "", "bizVideoProfiler", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "getBizVideoProfiler", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "cacheTimeSec", "getCacheTimeSec", "callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getCheckTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "setCheckTimer", "(Lcom/tencent/mm/sdk/platformtools/MTimerHandler;)V", "currPosMs", "getCurrPosMs", "currPosSec", "getCurrPosSec", "downloadPercent", "durationSec", "errorCheckTimer", "getErrorCheckTimer", "setErrorCheckTimer", "errorCount", "getErrorCount", "setErrorCount", "(I)V", "footerView", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoFooter;", "hasExoParam", "inBackGround", "isControllerBarShowing", "setControllerBarShowing", "(Z)V", "isInFullScreen", "isLive", "setLive", "isPlayOnUiPause", "setPlayOnUiPause", "isPlaying", "isSwitchingResolution", "setSwitchingResolution", "isUIAvailable", "setUIAvailable", "lastSeekAutoPlay", "lastSeekTime", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "localIsPlaying", "mAudioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "mCoverIv", "Landroid/widget/ImageView;", "mFirstRenderStartTime", "", "mFooterContainer", "Landroid/widget/LinearLayout;", "mLastUpdateBuffer", "mMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/ExoMediaPlayer;", "mMediaPlayerAvailable", "mPlayingBeforeBuffering", "mPlayingBeforeSeeking", "mPlayingWhenBackground", "mStartSeekPosition", "mStartWhenPrepared", "mStartWhenSeekCompleted", "mSurface", "Landroid/view/Surface;", "mSwitchCoverIv", "mSwitchTitleTextView", "Landroid/widget/TextView;", "mVideoDuration", "mVideoHasEndedPlaying", "mVideoHasPrepared", "mVideoHeight", "mVideoLooping", "mVideoPath", "", "mVideoProxyUrl", "mVideoSource", "getMVideoSource", "setMVideoSource", "mVideoTextureView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoTextureView;", "mVideoWidth", "maxBufferMs", "maxDurForQualityMs", "maxInitialBitrate", "minBufferMs", "minDurForQualityMs", "mute", "needShowSwitchTitleTextView", "getNeedShowSwitchTitleTextView", "setNeedShowSwitchTitleTextView", "pauseByDestroyed", "resolutionStr", "showLoadingRunning", "Ljava/lang/Runnable;", "showLoadingTimer", "getShowLoadingTimer", "setShowLoadingTimer", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setUiHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "videoDurationMs", "getVideoDurationMs", "videoDurationSec", "getVideoDurationSec", "videoHeight", "getVideoHeight", "videoWidth", "getVideoWidth", "adjustObjectFit", "", "applyMediaPlayerParams", "checkExoPlayerParam", "checkVideoUrl", "clearSurface", "createMediaPlayer", "enterFullScreen", "gain", "getCoverIv", "getFirstRenderTime", "hideCover", "hideLoading", "init", "isNeedToPlay", "isShowingLoading", "isSwitchTitleTextViewShowing", "loss", "lossTransient", "lossTransientCanDuck", "onControllerBarVisible", "visible", "onError", "what", "extra", "onMediaPlayerBufferingUpdate", "percent", "onMediaPlayerCompletion", "onMediaPlayerInfo", "onMediaPlayerPrepared", "onMediaPlayerSeekComplete", "onMediaPlayerVideoSizeChanged", "width", "height", "onPlayDoSwitchEnd", "onSeekEnd", "onSetResolution", "onSwitchEnd", "onSwitchEndShowSuccessWording", "onUIDestroy", "onUIPause", "onUIResume", "onVideoLoadedMetaData", "duration", "onVideoPause", "onVideoPlay", "onVideoProgress", "onVideoWaiting", "onVideoWaitingEnd", "pause", "prepareAsync", "quitFullScreen", "releaseMediaPlayer", "releaseSurface", "reset", "resetErrorCount", "resetMediaPlayer", "resetResolutionStatus", "restartVideo", "seekPosition", "play", "retryWhenError", "seekTo", "ms", "afterPlay", "setDataSourceWithCustomKey", "url", "setExoPlayerParam", "setIMMVideoViewCallback", "_callback", "setKeepScreenOn", "keepScreenOn", "setMute", "_mute", "setSwitchSpeedCover", "setVideoFooterView", "_footerView", "setVideoPath", "_isLive", "_url", "_durationSec", "setVideoSource", "videoSource", "setVideoTotalTime", "seconds", "showCover", "showLoading", "showLoadingDelayed", "delayMillis", "start", "startErrorCheckTimer", "startTimer", "stop", "stopErrorCheckTimer", "stopTimer", "tryPreloadVideo", "unKown", "updateUI", "currPlaySec", "updateVideoStatus", "isPlay", "Companion", "plugin-brandservice_release"})
public final class MPExoVideoWrapper
  extends RelativeLayout
  implements d.a
{
  static final String TAG = "MicroMsg.MPExoVideoWrapper";
  private static final int sUx = 500;
  private static final int sUy = 0;
  public static final MPExoVideoWrapper.a sUz;
  boolean bjq;
  private int bnv;
  private float bnz;
  private int bpq;
  private boolean cJH;
  private boolean cJI;
  private boolean cJJ;
  private boolean cJM;
  private boolean cJN;
  private boolean cJO;
  private final boolean cJP;
  private int cJR;
  private int cJS;
  String cJT;
  private boolean cJV;
  MMHandler knk;
  private boolean lhf;
  private Surface mSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  boolean nzN;
  private int pBl;
  private int pBm;
  private int pBn;
  private int pBo;
  private boolean pDI;
  private ProgressBar pDL;
  boolean pDU;
  private int pDo;
  private boolean pDy;
  private MTimerHandler pEb;
  private MTimerHandler pEd;
  private final Runnable pEg;
  private int puP;
  private ImageView puu;
  int pvi;
  private final int sTX;
  private final int sTY;
  private final int sTZ;
  private LinearLayout sUa;
  ImageView sUb;
  TextView sUc;
  private h sUd;
  String sUe;
  MPExoVideoTextureView sUf;
  private com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g sUg;
  private i.b sUh;
  private final d sUi;
  private String sUj;
  private boolean sUk;
  private int sUl;
  private boolean sUm;
  private boolean sUn;
  private int sUo;
  private boolean sUp;
  private long sUq;
  private boolean sUr;
  boolean sUs;
  boolean sUt;
  boolean sUu;
  private MTimerHandler sUv;
  private final f sUw;
  
  static
  {
    AppMethodBeat.i(7467);
    sUz = new MPExoVideoWrapper.a((byte)0);
    TAG = "MicroMsg.MPExoVideoWrapper";
    sUx = 500;
    AppMethodBeat.o(7467);
  }
  
  public MPExoVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7466);
    this.sTX = 5000;
    this.sTY = 200;
    this.sTZ = 5;
    this.knk = new MMHandler(Looper.getMainLooper());
    paramContext = d.bcs();
    p.j(paramContext, "AudioHelperTool.createTool()");
    this.sUi = paramContext;
    this.puP = sUy;
    this.pDI = true;
    this.bnv = 800000;
    this.bnz = 0.75F;
    this.pBl = 10000;
    this.pBm = 25000;
    this.pBn = 15000;
    this.pBo = 30000;
    this.pEb = new MTimerHandler((MTimerHandler.CallBack)new d(this), true);
    LayoutInflater.from(getContext()).inflate(d.f.sus, (ViewGroup)this);
    this.sUf = ((MPExoVideoTextureView)findViewById(d.e.ssd));
    this.pDL = ((ProgressBar)findViewById(d.e.video_loading));
    this.sUa = ((LinearLayout)findViewById(d.e.video_footer_root));
    this.puu = ((ImageView)findViewById(d.e.ssa));
    this.sUb = ((ImageView)findViewById(d.e.ssc));
    this.sUc = ((TextView)findViewById(d.e.stc));
    paramContext = this.sUf;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new n(this));
    this.pEg = ((Runnable)new ab(this));
    this.sUv = new MTimerHandler((MTimerHandler.CallBack)new ac(this), false);
    this.pEd = new MTimerHandler((MTimerHandler.CallBack)new l(this), true);
    this.sUw = kotlin.g.ar((kotlin.g.a.a)MPExoVideoWrapper.b.sUA);
    AppMethodBeat.o(7466);
  }
  
  private final void TW()
  {
    try
    {
      AppMethodBeat.i(7435);
      if (this.sUg != null)
      {
        Log.i(TAG, "releaseMediaPlayer");
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g localg = this.sUg;
        if (localg == null) {
          p.iCn();
        }
        localg.a(null);
        localg = this.sUg;
        if (localg == null) {
          p.iCn();
        }
        localg.a(null);
        localg = this.sUg;
        if (localg == null) {
          p.iCn();
        }
        localg.a(null);
        localg = this.sUg;
        if (localg == null) {
          p.iCn();
        }
        localg.a(null);
        localg = this.sUg;
        if (localg == null) {
          p.iCn();
        }
        localg.a(null);
        localg = this.sUg;
        if (localg == null) {
          p.iCn();
        }
        localg.a(null);
        localg = this.sUg;
        if (localg == null) {
          p.iCn();
        }
        localg.stop();
        localg = this.sUg;
        if (localg == null) {
          p.iCn();
        }
        localg.reset();
        localg = this.sUg;
        if (localg == null) {
          p.iCn();
        }
        localg.release();
      }
      this.sUg = null;
      this.cJO = false;
      AppMethodBeat.o(7435);
      return;
    }
    finally {}
  }
  
  private final void TY()
  {
    AppMethodBeat.i(7438);
    if (this.sUg != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g localg = this.sUg;
      if (localg == null) {
        p.iCn();
      }
      localg.setMute(this.lhf);
      if (this.mSurface != null)
      {
        localg = this.sUg;
        if (localg == null) {
          p.iCn();
        }
        localg.setSurface(this.mSurface);
      }
    }
    AppMethodBeat.o(7438);
  }
  
  private final void cED()
  {
    AppMethodBeat.i(7439);
    if (this.sUg != null)
    {
      AppMethodBeat.o(7439);
      return;
    }
    Log.i(TAG, "createMediaPlayer");
    this.pDo = 0;
    float f;
    if (this.sUr)
    {
      localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g(this.bnv, this.bnz, this.pBl, this.pBm, this.pBn, this.pBo);
      this.sUg = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject1);
      localObject1 = this.sUg;
      if (localObject1 == null) {
        p.iCn();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject1).setLooping(this.cJP);
      localObject1 = this.sUg;
      if (localObject1 == null) {
        p.iCn();
      }
      Object localObject2 = a.sUM;
      localObject2 = a.cEG();
      if (localObject2 == null) {
        break label185;
      }
      f = ((a.a)localObject2).sUT;
      label131:
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject1).aP(f);
      if (this.sUg == null) {
        break label190;
      }
    }
    label185:
    label190:
    for (boolean bool = true;; bool = false)
    {
      this.cJO = bool;
      if (this.cJO) {
        break label195;
      }
      Log.e(TAG, "createMediaPlayer, create media player fail");
      AppMethodBeat.o(7439);
      return;
      localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g();
      break;
      f = 1.0F;
      break label131;
    }
    label195:
    Object localObject1 = this.sUg;
    if (localObject1 == null) {
      p.iCn();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject1).a((e.g)new e(this));
    localObject1 = this.sUg;
    if (localObject1 == null) {
      p.iCn();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject1).a((e.e)new f(this));
    localObject1 = this.sUg;
    if (localObject1 == null) {
      p.iCn();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject1).a((e.h)new g(this));
    localObject1 = this.sUg;
    if (localObject1 == null) {
      p.iCn();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject1).a((e.b)new h(this));
    localObject1 = this.sUg;
    if (localObject1 == null) {
      p.iCn();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject1).a((e.i)new i(this));
    localObject1 = this.sUg;
    if (localObject1 == null) {
      p.iCn();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject1).a((e.j)new j(this));
    localObject1 = this.sUg;
    if (localObject1 == null) {
      p.iCn();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject1).a((e.a)new k(this));
    if (!Util.isNullOrNil(this.cJT))
    {
      if (Util.isNullOrNil(this.sUj))
      {
        localObject1 = i.bVn();
        p.j(localObject1, "VideoCore.getInstance()");
        if (((i)localObject1).bVp())
        {
          localObject1 = i.bVn();
          p.j(localObject1, "VideoCore.getInstance()");
          if (((i)localObject1).bVo()) {
            this.sUj = i.bVn().aQ(this.cJT);
          }
        }
      }
      if (!Util.isNullOrNil(this.sUj))
      {
        setDataSourceWithCustomKey(this.sUj);
        AppMethodBeat.o(7439);
        return;
      }
      setDataSourceWithCustomKey(this.cJT);
    }
    AppMethodBeat.o(7439);
  }
  
  private boolean cEE()
  {
    AppMethodBeat.i(7450);
    if ((this.sUn) || (isPlaying()) || (this.cJI) || (this.cJH))
    {
      AppMethodBeat.o(7450);
      return true;
    }
    AppMethodBeat.o(7450);
    return false;
  }
  
  private final void cEF()
  {
    AppMethodBeat.i(7463);
    this.knk.post((Runnable)new c(this));
    AppMethodBeat.o(7463);
  }
  
  private final void cEx()
  {
    AppMethodBeat.i(7436);
    if ((this.mSurface != null) && (this.cJN))
    {
      MPExoVideoTextureView localMPExoVideoTextureView = this.sUf;
      if (localMPExoVideoTextureView != null)
      {
        localMPExoVideoTextureView.cEx();
        AppMethodBeat.o(7436);
        return;
      }
    }
    AppMethodBeat.o(7436);
  }
  
  private final boolean getAbTestVideoPreload()
  {
    AppMethodBeat.i(262834);
    boolean bool = ((Boolean)this.sUw.getValue()).booleanValue();
    AppMethodBeat.o(262834);
    return bool;
  }
  
  private final b.a getBizVideoProfiler()
  {
    AppMethodBeat.i(262771);
    Object localObject = b.sSS;
    localObject = b.aqB(getContext().toString());
    AppMethodBeat.o(262771);
    return localObject;
  }
  
  private final void iF(final boolean paramBoolean)
  {
    AppMethodBeat.i(7444);
    this.knk.post((Runnable)new af(this, paramBoolean));
    AppMethodBeat.o(7444);
  }
  
  private final void onError(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(7464);
    Object localObject = af.aaBG;
    localObject = String.format("PlayError %s/%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 2));
    p.j(localObject, "java.lang.String.format(format, *args)");
    Log.w(TAG, "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.bpq += 1;
    if (this.bpq > this.sTZ)
    {
      this.knk.post((Runnable)new o(this, (String)localObject, paramInt1, paramInt2));
      AppMethodBeat.o(7464);
      return;
    }
    this.knk.postDelayed((Runnable)new p(this), this.sTY);
    AppMethodBeat.o(7464);
  }
  
  private final void reset()
  {
    this.cJH = false;
    this.cJI = false;
    this.cJJ = false;
  }
  
  private final void setDataSourceWithCustomKey(String paramString)
  {
    AppMethodBeat.i(262836);
    if (getAbTestVideoPreload())
    {
      localObject = i.bVn().aiO(paramString);
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g localg = this.sUg;
      if (localg == null) {
        p.iCn();
      }
      localg.eg(paramString, (String)localObject);
      AppMethodBeat.o(262836);
      return;
    }
    Object localObject = this.sUg;
    if (localObject == null) {
      p.iCn();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject).setDataSource(paramString);
    AppMethodBeat.o(262836);
  }
  
  private final void setVideoTotalTime(final int paramInt)
  {
    AppMethodBeat.i(7445);
    this.knk.post((Runnable)new aa(this, paramInt));
    AppMethodBeat.o(7445);
  }
  
  private final void stopTimer()
  {
    AppMethodBeat.i(7447);
    Log.d(TAG, "stop timer");
    this.pEb.stopTimer();
    AppMethodBeat.o(7447);
  }
  
  protected final void Bg(final int paramInt)
  {
    AppMethodBeat.i(7443);
    this.knk.post((Runnable)new ae(this, paramInt));
    AppMethodBeat.o(7443);
  }
  
  final void Ic(long paramLong)
  {
    AppMethodBeat.i(7452);
    this.sUv.stopTimer();
    this.sUv.startTimer(paramLong);
    AppMethodBeat.o(7452);
  }
  
  public final boolean TV()
  {
    AppMethodBeat.i(7457);
    this.sUn = false;
    stopTimer();
    MPExoVideoTextureView localMPExoVideoTextureView = this.sUf;
    if (localMPExoVideoTextureView != null) {
      localMPExoVideoTextureView.stop();
    }
    this.pDo = 0;
    if (this.sUg != null)
    {
      this.knk.post((Runnable)new ad(this));
      AppMethodBeat.o(7457);
      return true;
    }
    AppMethodBeat.o(7457);
    return false;
  }
  
  public final void aa(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(7429);
    Log.i(TAG, "prepare async");
    cEC();
    prepareAsync();
    ab(paramInt, paramBoolean);
    if (paramBoolean) {
      start();
    }
    AppMethodBeat.o(7429);
  }
  
  public final void ab(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(7448);
    this.sUp = paramBoolean;
    int j = getVideoDurationMs();
    int i = paramInt;
    if (j > 100)
    {
      i = paramInt;
      if (paramInt > j) {
        i = j;
      }
    }
    if ((this.cJN) && (this.sUg != null))
    {
      this.cJI = cEE();
      Log.d(TAG, "seekTo mPlayingBeforeSeeking %b, afterPlay %b, seekTime %d", new Object[] { Boolean.valueOf(this.cJI), Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g localg;
      if (!paramBoolean)
      {
        localg = this.sUg;
        if (localg == null) {
          p.iCn();
        }
        localg.pause();
      }
      for (;;)
      {
        if ((j != i) && (i > 0)) {
          this.cJV = false;
        }
        localg = this.sUg;
        if (localg == null) {
          p.iCn();
        }
        localg.k(i, paramBoolean);
        this.sUo = i;
        Ic(500L);
        Bg(i / 1000);
        AppMethodBeat.o(7448);
        return;
        startTimer();
      }
    }
    this.sUl = i;
    AppMethodBeat.o(7448);
  }
  
  public final void bcu() {}
  
  public final void bcv() {}
  
  public final void bcw() {}
  
  public final void bcx() {}
  
  public final void cEA()
  {
    AppMethodBeat.i(7433);
    Log.d(TAG, "show cover");
    ImageView localImageView = this.puu;
    if (localImageView == null) {
      p.iCn();
    }
    localImageView.setVisibility(0);
    AppMethodBeat.o(7433);
  }
  
  public final void cEB()
  {
    AppMethodBeat.i(7434);
    Log.d(TAG, "hide cover");
    ImageView localImageView = this.puu;
    if (localImageView == null) {
      p.iCn();
    }
    localImageView.setVisibility(8);
    AppMethodBeat.o(7434);
  }
  
  public final void cEC()
  {
    AppMethodBeat.i(7437);
    reset();
    TW();
    cED();
    TY();
    AppMethodBeat.o(7437);
  }
  
  final void cEy()
  {
    AppMethodBeat.i(7431);
    Object localObject = this.sUb;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    if (!this.sUu)
    {
      localObject = this.sUc;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      this.sUs = false;
      AppMethodBeat.o(7431);
      return;
    }
    this.sUs = true;
    AppMethodBeat.o(7431);
  }
  
  final void cEz()
  {
    AppMethodBeat.i(7432);
    if (this.sUe != null)
    {
      localTextView = this.sUc;
      if (localTextView != null) {
        localTextView.setText((CharSequence)getContext().getString(d.i.svn, new Object[] { this.sUe }));
      }
      this.knk.postDelayed((Runnable)new t(this), 1500L);
      AppMethodBeat.o(7432);
      return;
    }
    Log.w(TAG, "resolutionStr is null");
    TextView localTextView = this.sUc;
    if (localTextView != null)
    {
      localTextView.setVisibility(8);
      AppMethodBeat.o(7432);
      return;
    }
    AppMethodBeat.o(7432);
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(179023);
    if (getVideoDurationSec() > 0)
    {
      int i = this.pDo * getVideoDurationSec() / 100;
      AppMethodBeat.o(179023);
      return i;
    }
    AppMethodBeat.o(179023);
    return 0;
  }
  
  protected final MTimerHandler getCheckTimer()
  {
    return this.pEb;
  }
  
  public final ImageView getCoverIv()
  {
    AppMethodBeat.i(7430);
    ImageView localImageView = this.puu;
    if (localImageView == null) {
      p.iCn();
    }
    AppMethodBeat.o(7430);
    return localImageView;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(7424);
    if (this.sUg != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g localg = this.sUg;
      if (localg == null) {
        p.iCn();
      }
      int i = localg.getCurrentPosition();
      AppMethodBeat.o(7424);
      return i;
    }
    AppMethodBeat.o(7424);
    return 0;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(7425);
    if (this.sUg != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g localg = this.sUg;
      if (localg == null) {
        p.iCn();
      }
      int i = localg.getCurrentPosition() / 1000;
      AppMethodBeat.o(7425);
      return i;
    }
    AppMethodBeat.o(7425);
    return 0;
  }
  
  protected final int getERROR_CHECK_TIME()
  {
    return this.sTX;
  }
  
  protected final int getERROR_TRY_AGAIN_DELAY_TIME()
  {
    return this.sTY;
  }
  
  protected final int getERROR_TRY_MAX_TIME()
  {
    return this.sTZ;
  }
  
  protected final MTimerHandler getErrorCheckTimer()
  {
    return this.pEd;
  }
  
  protected final int getErrorCount()
  {
    return this.bpq;
  }
  
  public final long getFirstRenderTime()
  {
    AppMethodBeat.i(177797);
    if (this.sUq != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.sUq;
      AppMethodBeat.o(177797);
      return l1 - l2;
    }
    AppMethodBeat.o(177797);
    return 0L;
  }
  
  protected final ProgressBar getLoading()
  {
    return this.pDL;
  }
  
  protected final int getMVideoSource()
  {
    return this.puP;
  }
  
  public final boolean getNeedShowSwitchTitleTextView()
  {
    return this.sUs;
  }
  
  protected final MTimerHandler getShowLoadingTimer()
  {
    return this.sUv;
  }
  
  protected final MMHandler getUiHandler()
  {
    return this.knk;
  }
  
  public final int getVideoDurationMs()
  {
    AppMethodBeat.i(7423);
    if (this.sUg != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g localg = this.sUg;
      if (localg == null) {
        p.iCn();
      }
      i = localg.getDuration();
      AppMethodBeat.o(7423);
      return i;
    }
    int i = this.pvi;
    AppMethodBeat.o(7423);
    return i * 1000;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(7422);
    if (this.sUg != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g localg = this.sUg;
      if (localg == null) {
        p.iCn();
      }
      i = localg.getDuration() / 1000;
      AppMethodBeat.o(7422);
      return i;
    }
    int i = this.pvi;
    AppMethodBeat.o(7422);
    return i;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(7428);
    if (this.sUg != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g localg = this.sUg;
      if (localg == null) {
        p.iCn();
      }
      int i = localg.getVideoHeight();
      AppMethodBeat.o(7428);
      return i;
    }
    AppMethodBeat.o(7428);
    return 0;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(7427);
    if (this.sUg != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g localg = this.sUg;
      if (localg == null) {
        p.iCn();
      }
      int i = localg.getVideoWidth();
      AppMethodBeat.o(7427);
      return i;
    }
    AppMethodBeat.o(7427);
    return 0;
  }
  
  protected final void hideLoading()
  {
    AppMethodBeat.i(7453);
    Log.d(TAG, "hide loading %s", new Object[] { Util.getStack() });
    this.sUv.stopTimer();
    this.knk.post((Runnable)new m(this));
    AppMethodBeat.o(7453);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(7426);
    if ((this.sUg != null) && (this.cJN))
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g localg = this.sUg;
      if (localg == null) {
        p.iCn();
      }
      boolean bool = localg.isPlaying();
      AppMethodBeat.o(7426);
      return bool;
    }
    AppMethodBeat.o(7426);
    return false;
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(7460);
    Log.d(TAG, "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    this.knk.post((Runnable)new u(this));
    AppMethodBeat.o(7460);
  }
  
  public final void onVideoPlay()
  {
    AppMethodBeat.i(7461);
    this.sUn = true;
    this.pDU = false;
    Log.d(TAG, "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    this.knk.post((Runnable)new v(this));
    AppMethodBeat.o(7461);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(7456);
    this.sUn = false;
    iF(false);
    stopTimer();
    if (this.sUg != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g localg = this.sUg;
      if (localg == null) {
        p.iCn();
      }
      if (!localg.isPlaying())
      {
        Log.i(TAG, "video pause, video is not playing");
        this.cJM = false;
        AppMethodBeat.o(7456);
        return true;
      }
      if (!this.cJN)
      {
        Log.i(TAG, "video pause, video not prepared yet, pause video when prepared");
        this.cJM = false;
        AppMethodBeat.o(7456);
        return true;
      }
      Log.i(TAG, "video pause");
      localg = this.sUg;
      if (localg == null) {
        p.iCn();
      }
      localg.pause();
      onVideoPause();
      AppMethodBeat.o(7456);
      return true;
    }
    AppMethodBeat.o(7456);
    return false;
  }
  
  final void prepareAsync()
  {
    AppMethodBeat.i(7454);
    Object localObject;
    if ((this.sUg != null) && (!Util.isNullOrNil(this.cJT)))
    {
      if (Util.isNullOrNil(this.sUj))
      {
        localObject = i.bVn();
        p.j(localObject, "VideoCore.getInstance()");
        if (((i)localObject).bVp())
        {
          localObject = i.bVn();
          p.j(localObject, "VideoCore.getInstance()");
          if (((i)localObject).bVo()) {
            this.sUj = i.bVn().aQ(this.cJT);
          }
        }
      }
      if (Util.isNullOrNil(this.sUj)) {
        break label192;
      }
      setDataSourceWithCustomKey(this.sUj);
    }
    for (;;)
    {
      Log.i(TAG, "video prepare async");
      Ic(500L);
      this.cJN = false;
      this.sUq = System.currentTimeMillis();
      if (this.sUg != null)
      {
        localObject = getBizVideoProfiler();
        if (localObject != null)
        {
          localObject = ((b.a)localObject).aqC("10");
          if (localObject != null)
          {
            b localb = b.sSS;
            b.a((fb)localObject, getBizVideoProfiler());
          }
        }
        localObject = this.sUg;
        if (localObject == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject).prepareAsync();
      }
      AppMethodBeat.o(7454);
      return;
      label192:
      setDataSourceWithCustomKey(this.cJT);
    }
  }
  
  protected final void setCheckTimer(MTimerHandler paramMTimerHandler)
  {
    AppMethodBeat.i(7421);
    p.k(paramMTimerHandler, "<set-?>");
    this.pEb = paramMTimerHandler;
    AppMethodBeat.o(7421);
  }
  
  public final void setControllerBarShowing(boolean paramBoolean)
  {
    this.sUu = paramBoolean;
  }
  
  protected final void setErrorCheckTimer(MTimerHandler paramMTimerHandler)
  {
    AppMethodBeat.i(7465);
    p.k(paramMTimerHandler, "<set-?>");
    this.pEd = paramMTimerHandler;
    AppMethodBeat.o(7465);
  }
  
  protected final void setErrorCount(int paramInt)
  {
    this.bpq = paramInt;
  }
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(7441);
    p.k(paramb, "_callback");
    this.sUh = paramb;
    AppMethodBeat.o(7441);
  }
  
  public final void setKeepScreenOn(final boolean paramBoolean)
  {
    AppMethodBeat.i(7462);
    Log.d(TAG, "set keep screen on[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knk.post((Runnable)new y(this, paramBoolean));
    AppMethodBeat.o(7462);
  }
  
  public final void setLive(boolean paramBoolean)
  {
    this.bjq = paramBoolean;
  }
  
  protected final void setLoading(ProgressBar paramProgressBar)
  {
    this.pDL = paramProgressBar;
  }
  
  protected final void setMVideoSource(int paramInt)
  {
    this.puP = paramInt;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(7458);
    this.lhf = paramBoolean;
    if (this.sUg != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g localg = this.sUg;
      if (localg == null) {
        p.iCn();
      }
      localg.setMute(this.lhf);
    }
    AppMethodBeat.o(7458);
  }
  
  public final void setNeedShowSwitchTitleTextView(boolean paramBoolean)
  {
    this.sUs = paramBoolean;
  }
  
  protected final void setPlayOnUiPause(boolean paramBoolean)
  {
    this.pDU = paramBoolean;
  }
  
  protected final void setShowLoadingTimer(MTimerHandler paramMTimerHandler)
  {
    AppMethodBeat.i(7451);
    p.k(paramMTimerHandler, "<set-?>");
    this.sUv = paramMTimerHandler;
    AppMethodBeat.o(7451);
  }
  
  public final void setSwitchingResolution(boolean paramBoolean)
  {
    this.sUt = paramBoolean;
  }
  
  protected final void setUIAvailable(boolean paramBoolean)
  {
    this.pDI = paramBoolean;
  }
  
  protected final void setUiHandler(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(7420);
    p.k(paramMMHandler, "<set-?>");
    this.knk = paramMMHandler;
    AppMethodBeat.o(7420);
  }
  
  public final void setVideoFooterView(h paramh)
  {
    AppMethodBeat.i(7442);
    p.k(paramh, "_footerView");
    this.sUd = paramh;
    paramh = this.sUa;
    if (paramh == null) {
      p.iCn();
    }
    paramh.removeAllViews();
    paramh = this.sUa;
    if (paramh == null) {
      p.iCn();
    }
    paramh.addView((View)this.sUd);
    AppMethodBeat.o(7442);
  }
  
  public final void setVideoSource(int paramInt)
  {
    this.puP = paramInt;
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(7455);
    if (!this.pDI)
    {
      Log.w(TAG, "ui on pause now, why u call me to play? [%s]", new Object[] { Util.getStack() });
      AppMethodBeat.o(7455);
      return false;
    }
    if (this.mSurface == null)
    {
      Log.w(TAG, "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.pDy = true;
      this.cJM = true;
      AppMethodBeat.o(7455);
      return false;
    }
    this.sUn = true;
    if (this.sUg == null)
    {
      cEC();
      prepareAsync();
    }
    if (this.sUg != null)
    {
      setKeepScreenOn(true);
      this.sUi.a((d.a)this);
      Object localObject1;
      if (this.cJN)
      {
        localObject1 = this.sUg;
        if (localObject1 == null) {
          p.iCn();
        }
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject1).isPlaying())
        {
          Log.i(TAG, "video play, video is playing");
          onVideoPlay();
          AppMethodBeat.o(7455);
          return true;
        }
      }
      if ((this.sUg != null) && (!this.cJN))
      {
        Log.i(TAG, "video play, video not prepared yet, start until prepared");
        this.cJM = true;
        AppMethodBeat.o(7455);
        return true;
      }
      if (this.sUg != null)
      {
        localObject1 = this.sUg;
        if (localObject1 == null) {
          p.iCn();
        }
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject1).getState() == 5)
        {
          Log.i(TAG, "video play, video has stopped now, try prepare and start when prepared");
          this.cJM = true;
          Log.i(TAG, "video play, media player prepare async");
          prepareAsync();
          AppMethodBeat.o(7455);
          return true;
        }
      }
      Object localObject2;
      if (this.cJV)
      {
        Log.i(TAG, "video play, video has ended playing, clear surface and start again");
        this.cJV = false;
        cEx();
        cEC();
        prepareAsync();
        if (this.sUg != null)
        {
          this.cJM = true;
          localObject1 = TAG;
          localObject2 = this.sUg;
          if (localObject2 == null) {
            p.iCn();
          }
          Log.i((String)localObject1, "video play, media player state:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject2).getState()) });
          prepareAsync();
        }
        AppMethodBeat.o(7455);
        return true;
      }
      if (this.sUg != null)
      {
        localObject1 = this.sUg;
        if (localObject1 == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g)localObject1).start();
        localObject1 = getBizVideoProfiler();
        if (localObject1 != null)
        {
          localObject1 = ((b.a)localObject1).aqC("15");
          if (localObject1 != null)
          {
            localObject2 = b.sSS;
            b.a((fb)localObject1, getBizVideoProfiler());
          }
        }
        onVideoPlay();
      }
      AppMethodBeat.o(7455);
      return true;
    }
    AppMethodBeat.o(7455);
    return false;
  }
  
  protected final void startTimer()
  {
    AppMethodBeat.i(7446);
    Log.d(TAG, "start timer");
    if (!this.pEb.stopped()) {
      stopTimer();
    }
    this.pEb.startTimer(sUx);
    AppMethodBeat.o(7446);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class aa
    implements Runnable
  {
    aa(MPExoVideoWrapper paramMPExoVideoWrapper, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(7414);
      if (MPExoVideoWrapper.w(this.sUB) != null)
      {
        h localh = MPExoVideoWrapper.w(this.sUB);
        if (localh == null) {
          p.iCn();
        }
        if (localh.getVideoTotalTime() != paramInt)
        {
          localh = MPExoVideoWrapper.w(this.sUB);
          if (localh == null) {
            p.iCn();
          }
          localh.setVideoTotalTime(paramInt);
        }
      }
      AppMethodBeat.o(7414);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class ab
    implements Runnable
  {
    ab(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7415);
      if (this.sUB.getLoading() != null)
      {
        Object localObject = this.sUB.getLoading();
        if (localObject == null) {
          p.iCn();
        }
        if (((ProgressBar)localObject).getVisibility() != 0)
        {
          Log.i(MPExoVideoWrapper.access$getTAG$cp(), "show loading");
          localObject = this.sUB.getLoading();
          if (localObject != null) {
            ((ProgressBar)localObject).setVisibility(0);
          }
          localObject = this.sUB;
          ((MPExoVideoWrapper)localObject).knk.post((Runnable)new MPExoVideoWrapper.w((MPExoVideoWrapper)localObject));
        }
      }
      AppMethodBeat.o(7415);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class ac
    implements MTimerHandler.CallBack
  {
    ac(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7416);
      this.sUB.getUiHandler().post(MPExoVideoWrapper.C(this.sUB));
      AppMethodBeat.o(7416);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class ad
    implements Runnable
  {
    ad(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7417);
      Log.i(MPExoVideoWrapper.access$getTAG$cp(), "video stop");
      this.sUB.Bg(0);
      MPExoVideoWrapper.b(this.sUB, false);
      MPExoVideoWrapper.f(this.sUB);
      this.sUB.onVideoPause();
      AppMethodBeat.o(7417);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class ae
    implements Runnable
  {
    ae(MPExoVideoWrapper paramMPExoVideoWrapper, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(7418);
      h localh = MPExoVideoWrapper.w(this.sUB);
      if (localh == null) {
        p.iCn();
      }
      localh.AS(paramInt);
      AppMethodBeat.o(7418);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class af
    implements Runnable
  {
    af(MPExoVideoWrapper paramMPExoVideoWrapper, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(7419);
      h localh = MPExoVideoWrapper.w(this.sUB);
      if (localh == null) {
        p.iCn();
      }
      localh.iF(paramBoolean);
      AppMethodBeat.o(7419);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7387);
      MPExoVideoTextureView localMPExoVideoTextureView = MPExoVideoWrapper.h(this.sUB);
      if (localMPExoVideoTextureView != null) {
        localMPExoVideoTextureView.setVideoSize(MPExoVideoWrapper.y(this.sUB), MPExoVideoWrapper.z(this.sUB));
      }
      localMPExoVideoTextureView = MPExoVideoWrapper.h(this.sUB);
      if (localMPExoVideoTextureView != null) {
        localMPExoVideoTextureView.cEw();
      }
      localMPExoVideoTextureView = MPExoVideoWrapper.h(this.sUB);
      if (localMPExoVideoTextureView != null)
      {
        localMPExoVideoTextureView.setScaleType(i.e.RcG);
        AppMethodBeat.o(7387);
        return;
      }
      AppMethodBeat.o(7387);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class d
    implements MTimerHandler.CallBack
  {
    d(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7388);
      this.sUB.isPlaying();
      if (this.sUB.pDU)
      {
        Log.d(MPExoVideoWrapper.access$getTAG$cp(), "checkTimer onVideoPlay");
        this.sUB.onVideoPlay();
        this.sUB.setPlayOnUiPause(false);
      }
      for (;;)
      {
        AppMethodBeat.o(7388);
        return true;
        this.sUB.Bg(this.sUB.getCurrPosSec());
        MPExoVideoWrapper.b(this.sUB, this.sUB.isPlaying());
        MPExoVideoWrapper.B(this.sUB);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onInfo"})
  static final class e
    implements e.g
  {
    e(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean ct(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(257214);
      boolean bool = MPExoVideoWrapper.a(this.sUB, paramInt1, paramInt2);
      AppMethodBeat.o(257214);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"})
  static final class f
    implements e.e
  {
    f(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean cu(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(261431);
      MPExoVideoWrapper.b(this.sUB, paramInt1, paramInt2);
      AppMethodBeat.o(261431);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class g
    implements e.h
  {
    g(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void a(e parame)
    {
      AppMethodBeat.i(265576);
      MPExoVideoWrapper.r(this.sUB);
      if (MPExoVideoWrapper.s(this.sUB) != null)
      {
        parame = MPExoVideoWrapper.s(this.sUB);
        if (parame == null) {
          p.iCn();
        }
        parame.dS("", "");
      }
      AppMethodBeat.o(265576);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class h
    implements e.b
  {
    h(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void Uh()
    {
      AppMethodBeat.i(265374);
      MPExoVideoWrapper.t(this.sUB);
      AppMethodBeat.o(265374);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class i
    implements e.i
  {
    i(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void b(e parame)
    {
      AppMethodBeat.i(263630);
      MPExoVideoWrapper.u(this.sUB);
      AppMethodBeat.o(263630);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "onVideoSizeChanged"})
  static final class j
    implements e.j
  {
    j(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void a(e parame, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(257822);
      MPExoVideoWrapper.c(this.sUB, paramInt1, paramInt2);
      AppMethodBeat.o(257822);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "percent", "", "onBufferingUpdate"})
  static final class k
    implements e.a
  {
    k(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void jg(int paramInt)
    {
      AppMethodBeat.i(259884);
      MPExoVideoWrapper.b(this.sUB, paramInt);
      AppMethodBeat.o(259884);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class l
    implements MTimerHandler.CallBack
  {
    l(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7396);
      if (this.sUB.getErrorCount() > 0)
      {
        if (this.sUB.isPlaying())
        {
          MPExoVideoWrapper.D(this.sUB);
          AppMethodBeat.o(7396);
          return false;
        }
        AppMethodBeat.o(7396);
        return true;
      }
      AppMethodBeat.o(7396);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7397);
      if (this.sUB.getLoading() != null)
      {
        Object localObject = this.sUB.getLoading();
        if (localObject == null) {
          p.iCn();
        }
        if (((ProgressBar)localObject).getVisibility() != 8)
        {
          Log.i(MPExoVideoWrapper.access$getTAG$cp(), "hide loading");
          localObject = this.sUB.getLoading();
          if (localObject != null) {
            ((ProgressBar)localObject).setVisibility(8);
          }
          localObject = this.sUB;
          ((MPExoVideoWrapper)localObject).knk.postDelayed((Runnable)new MPExoVideoWrapper.x((MPExoVideoWrapper)localObject), 500L);
        }
      }
      AppMethodBeat.o(7397);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-brandservice_release"})
  public static final class n
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7402);
      p.k(paramSurfaceTexture, "surface");
      Log.i(MPExoVideoWrapper.access$getTAG$cp(), "on surface texture available, width %d height %d switching %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.sUB.sUt) });
      Object localObject = MPExoVideoWrapper.g(this.sUB);
      if (localObject != null)
      {
        localObject = ((b.a)localObject).aqC("9");
        if (localObject != null)
        {
          b localb = b.sSS;
          b.a((fb)localObject, "PlayerType", "3");
          if (localObject != null)
          {
            localb = b.sSS;
            b.a((fb)localObject, MPExoVideoWrapper.g(this.sUB));
          }
        }
      }
      this.sUB.startTimer();
      localObject = MPExoVideoWrapper.h(this.sUB);
      if (localObject != null) {
        ((MPExoVideoTextureView)localObject).hKg();
      }
      localObject = MPExoVideoWrapper.h(this.sUB);
      if (localObject != null) {
        ((MPExoVideoTextureView)localObject).j(MPExoVideoWrapper.b(this.sUB));
      }
      MPExoVideoWrapper.a(this.sUB, new Surface(paramSurfaceTexture));
      if ((MPExoVideoWrapper.c(this.sUB) == null) || (!MPExoVideoWrapper.d(this.sUB))) {
        if (this.sUB.sUt) {
          this.sUB.aa(MPExoVideoWrapper.i(this.sUB), MPExoVideoWrapper.j(this.sUB));
        }
      }
      for (;;)
      {
        if ((!MPExoVideoWrapper.l(this.sUB)) && (this.sUB.sUt)) {
          MPExoVideoWrapper.m(this.sUB);
        }
        AppMethodBeat.o(7402);
        return;
        this.sUB.cEC();
        MPExoVideoWrapper.k(this.sUB);
        continue;
        Log.i(MPExoVideoWrapper.access$getTAG$cp(), "init, setSurface");
        paramSurfaceTexture = MPExoVideoWrapper.c(this.sUB);
        if (paramSurfaceTexture == null) {
          p.iCn();
        }
        paramSurfaceTexture.setSurface(MPExoVideoWrapper.b(this.sUB));
        if (MPExoVideoWrapper.e(this.sUB))
        {
          paramSurfaceTexture = MPExoVideoWrapper.g(this.sUB);
          if (paramSurfaceTexture != null)
          {
            paramSurfaceTexture = paramSurfaceTexture.aqC("15");
            if (paramSurfaceTexture != null)
            {
              localObject = b.sSS;
              b.a(paramSurfaceTexture, MPExoVideoWrapper.g(this.sUB));
            }
          }
          paramSurfaceTexture = MPExoVideoWrapper.c(this.sUB);
          if (paramSurfaceTexture == null) {
            p.iCn();
          }
          paramSurfaceTexture.start();
        }
        MPExoVideoWrapper.a(this.sUB, false);
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(7401);
      p.k(paramSurfaceTexture, "surface");
      Log.i(MPExoVideoWrapper.access$getTAG$cp(), "on surface texture destroyed");
      MPExoVideoWrapper.a(this.sUB, null);
      if ((MPExoVideoWrapper.c(this.sUB) != null) && (MPExoVideoWrapper.d(this.sUB))) {
        if (this.sUB.isPlaying())
        {
          MPExoVideoWrapper.a(this.sUB, true);
          paramSurfaceTexture = MPExoVideoWrapper.c(this.sUB);
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.pause();
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(7401);
        return false;
        MPExoVideoWrapper.f(this.sUB);
        MPExoVideoWrapper.a(this.sUB, false);
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7400);
      p.k(paramSurfaceTexture, "surface");
      AppMethodBeat.o(7400);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(7399);
      p.k(paramSurfaceTexture, "surface");
      if (this.sUB.getLoading() != null)
      {
        paramSurfaceTexture = this.sUB.getLoading();
        if (paramSurfaceTexture == null) {
          p.iCn();
        }
        if (paramSurfaceTexture.getVisibility() == 0) {
          this.sUB.hideLoading();
        }
      }
      if (MPExoVideoWrapper.a(this.sUB) != null)
      {
        paramSurfaceTexture = MPExoVideoWrapper.a(this.sUB);
        if (paramSurfaceTexture == null) {
          p.iCn();
        }
        if ((paramSurfaceTexture.getVisibility() == 0) && ((this.sUB.isPlaying()) || (this.sUB.getCurrPosSec() != 0))) {
          this.sUB.getUiHandler().post((Runnable)new a(this));
        }
      }
      AppMethodBeat.o(7399);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPExoVideoWrapper.n paramn) {}
      
      public final void run()
      {
        AppMethodBeat.i(7398);
        Log.d(MPExoVideoWrapper.access$getTAG$cp(), "hide cover onSurfaceTextureUpdated");
        this.sUC.sUB.cEB();
        AppMethodBeat.o(7398);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(MPExoVideoWrapper paramMPExoVideoWrapper, String paramString, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(7403);
      this.sUB.TV();
      this.sUB.hideLoading();
      if (MPExoVideoWrapper.s(this.sUB) != null)
      {
        i.b localb = MPExoVideoWrapper.s(this.sUB);
        if (localb == null) {
          p.iCn();
        }
        localb.c("", "", this.sUD, paramInt1, paramInt2);
      }
      AppMethodBeat.o(7403);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7404);
      this.sUB.Ic(500L);
      this.sUB.Bg(this.sUB.getCurrPosSec());
      MPExoVideoWrapper.A(this.sUB);
      AppMethodBeat.o(7404);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(258870);
      if (this.sUB.sUt) {
        MPExoVideoWrapper.n(this.sUB);
      }
      AppMethodBeat.o(258870);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7405);
      MPExoVideoWrapper.n(this.sUB);
      AppMethodBeat.o(7405);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7406);
      ImageView localImageView = MPExoVideoWrapper.o(this.sUB);
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      MPExoVideoWrapper.p(this.sUB);
      AppMethodBeat.o(7406);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7407);
      TextView localTextView = MPExoVideoWrapper.q(this.sUB);
      if (localTextView != null)
      {
        localTextView.setVisibility(8);
        AppMethodBeat.o(7407);
        return;
      }
      AppMethodBeat.o(7407);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7408);
      this.sUB.setKeepScreenOn(false);
      MPExoVideoWrapper.x(this.sUB).avz();
      if (MPExoVideoWrapper.s(this.sUB) != null)
      {
        i.b localb = MPExoVideoWrapper.s(this.sUB);
        if (localb == null) {
          p.iCn();
        }
        localb.dU("", "");
      }
      AppMethodBeat.o(7408);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class v
    implements Runnable
  {
    v(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7409);
      this.sUB.setKeepScreenOn(true);
      MPExoVideoWrapper.x(this.sUB).a((d.a)this.sUB);
      if (MPExoVideoWrapper.s(this.sUB) != null)
      {
        i.b localb = MPExoVideoWrapper.s(this.sUB);
        if (localb == null) {
          p.iCn();
        }
        localb.dV("", "");
      }
      MPExoVideoWrapper.b(this.sUB, true);
      this.sUB.startTimer();
      AppMethodBeat.o(7409);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class w
    implements Runnable
  {
    w(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7410);
      if (MPExoVideoWrapper.s(this.sUB) != null)
      {
        i.b localb = MPExoVideoWrapper.s(this.sUB);
        if (localb == null) {
          p.iCn();
        }
        localb.dW("", "");
      }
      AppMethodBeat.o(7410);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class x
    implements Runnable
  {
    x(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7411);
      if (MPExoVideoWrapper.s(this.sUB) != null)
      {
        i.b localb = MPExoVideoWrapper.s(this.sUB);
        if (localb == null) {
          p.iCn();
        }
        localb.dX("", "");
      }
      AppMethodBeat.o(7411);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class y
    implements Runnable
  {
    y(MPExoVideoWrapper paramMPExoVideoWrapper, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(7412);
      MPExoVideoWrapper.c(this.sUB, paramBoolean);
      AppMethodBeat.o(7412);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class z
    implements Runnable
  {
    z(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7413);
      MPExoVideoWrapper.v(this.sUB);
      AppMethodBeat.o(7413);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper
 * JD-Core Version:    0.7.0.1
 */