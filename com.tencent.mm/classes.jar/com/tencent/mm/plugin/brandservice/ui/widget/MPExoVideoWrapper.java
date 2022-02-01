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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ERROR_CHECK_TIME", "", "getERROR_CHECK_TIME", "()I", "ERROR_TRY_AGAIN_DELAY_TIME", "getERROR_TRY_AGAIN_DELAY_TIME", "ERROR_TRY_MAX_TIME", "getERROR_TRY_MAX_TIME", "abTestVideoPreload", "", "getAbTestVideoPreload", "()Z", "abTestVideoPreload$delegate", "Lkotlin/Lazy;", "bandwidthFraction", "", "bizVideoProfiler", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "getBizVideoProfiler", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "cacheTimeSec", "getCacheTimeSec", "callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getCheckTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "setCheckTimer", "(Lcom/tencent/mm/sdk/platformtools/MTimerHandler;)V", "currPosMs", "getCurrPosMs", "currPosSec", "getCurrPosSec", "downloadPercent", "durationSec", "errorCheckTimer", "getErrorCheckTimer", "setErrorCheckTimer", "errorCount", "getErrorCount", "setErrorCount", "(I)V", "footerView", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoFooter;", "hasExoParam", "inBackGround", "isControllerBarShowing", "setControllerBarShowing", "(Z)V", "isInFullScreen", "isLive", "setLive", "isPlayOnUiPause", "setPlayOnUiPause", "isPlaying", "isSwitchingResolution", "setSwitchingResolution", "isUIAvailable", "setUIAvailable", "lastSeekAutoPlay", "lastSeekTime", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "localIsPlaying", "mAudioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "mCoverIv", "Landroid/widget/ImageView;", "mFirstRenderStartTime", "", "mFooterContainer", "Landroid/widget/LinearLayout;", "mLastUpdateBuffer", "mMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/ExoMediaPlayer;", "mMediaPlayerAvailable", "mPlayingBeforeBuffering", "mPlayingBeforeSeeking", "mPlayingWhenBackground", "mStartSeekPosition", "mStartWhenPrepared", "mStartWhenSeekCompleted", "mSurface", "Landroid/view/Surface;", "mSwitchCoverIv", "mSwitchTitleTextView", "Landroid/widget/TextView;", "mVideoDuration", "mVideoHasEndedPlaying", "mVideoHasPrepared", "mVideoHeight", "mVideoLooping", "mVideoPath", "", "mVideoProxyUrl", "mVideoSource", "getMVideoSource", "setMVideoSource", "mVideoTextureView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoTextureView;", "mVideoWidth", "maxBufferMs", "maxDurForQualityMs", "maxInitialBitrate", "minBufferMs", "minDurForQualityMs", "mute", "needShowSwitchTitleTextView", "getNeedShowSwitchTitleTextView", "setNeedShowSwitchTitleTextView", "pauseByDestroyed", "resolutionStr", "showLoadingRunning", "Ljava/lang/Runnable;", "showLoadingTimer", "getShowLoadingTimer", "setShowLoadingTimer", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setUiHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "videoDurationMs", "getVideoDurationMs", "videoDurationSec", "getVideoDurationSec", "videoHeight", "getVideoHeight", "videoWidth", "getVideoWidth", "adjustObjectFit", "", "applyMediaPlayerParams", "checkExoPlayerParam", "checkVideoUrl", "clearSurface", "createMediaPlayer", "enterFullScreen", "gain", "getCoverIv", "getFirstRenderTime", "hideCover", "hideLoading", "init", "isNeedToPlay", "isShowingLoading", "isSwitchTitleTextViewShowing", "loss", "lossTransient", "lossTransientCanDuck", "onControllerBarVisible", "visible", "onError", "what", "extra", "onMediaPlayerBufferingUpdate", "percent", "onMediaPlayerCompletion", "onMediaPlayerInfo", "onMediaPlayerPrepared", "onMediaPlayerSeekComplete", "onMediaPlayerVideoSizeChanged", "width", "height", "onPlayDoSwitchEnd", "onSeekEnd", "onSetResolution", "onSwitchEnd", "onSwitchEndShowSuccessWording", "onUIDestroy", "onUIPause", "onUIResume", "onVideoLoadedMetaData", "duration", "onVideoPause", "onVideoPlay", "onVideoProgress", "onVideoWaiting", "onVideoWaitingEnd", "pause", "prepareAsync", "quitFullScreen", "releaseMediaPlayer", "releaseSurface", "reset", "resetErrorCount", "resetMediaPlayer", "resetResolutionStatus", "restartVideo", "seekPosition", "play", "retryWhenError", "seekTo", "ms", "afterPlay", "setDataSourceWithCustomKey", "url", "setExoPlayerParam", "setIMMVideoViewCallback", "_callback", "setKeepScreenOn", "keepScreenOn", "setMute", "_mute", "setSwitchSpeedCover", "setVideoFooterView", "_footerView", "setVideoPath", "_isLive", "_url", "_durationSec", "setVideoSource", "videoSource", "setVideoTotalTime", "seconds", "showCover", "showLoading", "showLoadingDelayed", "delayMillis", "start", "startErrorCheckTimer", "startTimer", "stop", "stopErrorCheckTimer", "stopTimer", "tryPreloadVideo", "unKown", "updateUI", "currPlaySec", "updateVideoStatus", "isPlay", "Companion", "plugin-brandservice_release"})
public final class MPExoVideoWrapper
  extends RelativeLayout
  implements d.a
{
  public static final String TAG = "MicroMsg.MPExoVideoWrapper";
  private static final int pNA = 0;
  public static final MPExoVideoWrapper.a pNB;
  private static final int pNz = 500;
  private int bDU;
  private float bDY;
  private int bFM;
  boolean bzP;
  private boolean cJd;
  private boolean cJe;
  private boolean cJf;
  private boolean cJi;
  public boolean cJj;
  private boolean cJk;
  private final boolean cJl;
  private int cJn;
  private int cJo;
  private String cJp;
  private boolean cJr;
  MMHandler hAk;
  private boolean isb;
  boolean kGg;
  private int mCn;
  private int mCo;
  private int mCp;
  private int mCq;
  public boolean mEI;
  private MTimerHandler mEP;
  private MTimerHandler mER;
  private final Runnable mEU;
  private int mEd;
  private boolean mEn;
  public boolean mEw;
  public ProgressBar mEz;
  private Surface mSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  private ImageView mvU;
  private int mwI;
  private int mwp;
  private final int pMZ;
  private final int pNa;
  private final int pNb;
  private LinearLayout pNc;
  ImageView pNd;
  TextView pNe;
  private com.tencent.mm.pluginsdk.ui.h pNf;
  String pNg;
  MPExoVideoTextureView pNh;
  public com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f pNi;
  private i.b pNj;
  public final d pNk;
  private String pNl;
  public boolean pNm;
  private int pNn;
  public boolean pNo;
  private boolean pNp;
  private int pNq;
  private boolean pNr;
  private long pNs;
  private boolean pNt;
  boolean pNu;
  boolean pNv;
  boolean pNw;
  private MTimerHandler pNx;
  private final kotlin.f pNy;
  
  static
  {
    AppMethodBeat.i(7467);
    pNB = new MPExoVideoWrapper.a((byte)0);
    TAG = "MicroMsg.MPExoVideoWrapper";
    pNz = 500;
    AppMethodBeat.o(7467);
  }
  
  public MPExoVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7466);
    this.pMZ = 5000;
    this.pNa = 200;
    this.pNb = 5;
    this.hAk = new MMHandler(Looper.getMainLooper());
    paramContext = d.aTu();
    p.g(paramContext, "AudioHelperTool.createTool()");
    this.pNk = paramContext;
    this.mwp = pNA;
    this.mEw = true;
    this.bDU = 800000;
    this.bDY = 0.75F;
    this.mCn = 10000;
    this.mCo = 25000;
    this.mCp = 15000;
    this.mCq = 30000;
    this.mEP = new MTimerHandler((MTimerHandler.CallBack)new d(this), true);
    LayoutInflater.from(getContext()).inflate(2131495699, (ViewGroup)this);
    this.pNh = ((MPExoVideoTextureView)findViewById(2131304940));
    this.mEz = ((ProgressBar)findViewById(2131309778));
    this.pNc = ((LinearLayout)findViewById(2131309767));
    this.mvU = ((ImageView)findViewById(2131304933));
    this.pNd = ((ImageView)findViewById(2131304939));
    this.pNe = ((TextView)findViewById(2131308808));
    paramContext = this.pNh;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new n(this));
    this.mEU = ((Runnable)new ab(this));
    this.pNx = new MTimerHandler((MTimerHandler.CallBack)new ac(this), false);
    this.mER = new MTimerHandler((MTimerHandler.CallBack)new l(this), true);
    this.pNy = g.ah((a)MPExoVideoWrapper.b.pNC);
    AppMethodBeat.o(7466);
  }
  
  private final void Qu()
  {
    try
    {
      AppMethodBeat.i(7435);
      if (this.pNi != null)
      {
        Log.i(TAG, "releaseMediaPlayer");
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f localf = this.pNi;
        if (localf == null) {
          p.hyc();
        }
        localf.a(null);
        localf = this.pNi;
        if (localf == null) {
          p.hyc();
        }
        localf.a(null);
        localf = this.pNi;
        if (localf == null) {
          p.hyc();
        }
        localf.a(null);
        localf = this.pNi;
        if (localf == null) {
          p.hyc();
        }
        localf.a(null);
        localf = this.pNi;
        if (localf == null) {
          p.hyc();
        }
        localf.a(null);
        localf = this.pNi;
        if (localf == null) {
          p.hyc();
        }
        localf.a(null);
        localf = this.pNi;
        if (localf == null) {
          p.hyc();
        }
        localf.stop();
        localf = this.pNi;
        if (localf == null) {
          p.hyc();
        }
        localf.reset();
        localf = this.pNi;
        if (localf == null) {
          p.hyc();
        }
        localf.release();
      }
      this.pNi = null;
      this.cJk = false;
      AppMethodBeat.o(7435);
      return;
    }
    finally {}
  }
  
  private final void Qw()
  {
    AppMethodBeat.i(7438);
    if (this.pNi != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f localf = this.pNi;
      if (localf == null) {
        p.hyc();
      }
      localf.setMute(this.isb);
      if (this.mSurface != null)
      {
        localf = this.pNi;
        if (localf == null) {
          p.hyc();
        }
        localf.setSurface(this.mSurface);
      }
    }
    AppMethodBeat.o(7438);
  }
  
  private final void cro()
  {
    AppMethodBeat.i(7436);
    if ((this.mSurface != null) && (this.cJj))
    {
      MPExoVideoTextureView localMPExoVideoTextureView = this.pNh;
      if (localMPExoVideoTextureView != null)
      {
        localMPExoVideoTextureView.cro();
        AppMethodBeat.o(7436);
        return;
      }
    }
    AppMethodBeat.o(7436);
  }
  
  private final void cru()
  {
    AppMethodBeat.i(7439);
    if (this.pNi != null)
    {
      AppMethodBeat.o(7439);
      return;
    }
    Log.i(TAG, "createMediaPlayer");
    this.mEd = 0;
    float f;
    if (this.pNt)
    {
      localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f(this.bDU, this.bDY, this.mCn, this.mCo, this.mCp, this.mCq);
      this.pNi = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject1);
      localObject1 = this.pNi;
      if (localObject1 == null) {
        p.hyc();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject1).setLooping(this.cJl);
      localObject1 = this.pNi;
      if (localObject1 == null) {
        p.hyc();
      }
      Object localObject2 = c.pNP;
      localObject2 = c.cry();
      if (localObject2 == null) {
        break label185;
      }
      f = ((c.a)localObject2).pNW;
      label131:
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject1).aP(f);
      if (this.pNi == null) {
        break label190;
      }
    }
    label185:
    label190:
    for (boolean bool = true;; bool = false)
    {
      this.cJk = bool;
      if (this.cJk) {
        break label195;
      }
      Log.e(TAG, "createMediaPlayer, create media player fail");
      AppMethodBeat.o(7439);
      return;
      localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f();
      break;
      f = 1.0F;
      break label131;
    }
    label195:
    Object localObject1 = this.pNi;
    if (localObject1 == null) {
      p.hyc();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject1).a((c.f)new e(this));
    localObject1 = this.pNi;
    if (localObject1 == null) {
      p.hyc();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject1).a((c.e)new f(this));
    localObject1 = this.pNi;
    if (localObject1 == null) {
      p.hyc();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject1).a((c.g)new g(this));
    localObject1 = this.pNi;
    if (localObject1 == null) {
      p.hyc();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject1).a((c.b)new h(this));
    localObject1 = this.pNi;
    if (localObject1 == null) {
      p.hyc();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject1).a((c.h)new i(this));
    localObject1 = this.pNi;
    if (localObject1 == null) {
      p.hyc();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject1).a((c.i)new j(this));
    localObject1 = this.pNi;
    if (localObject1 == null) {
      p.hyc();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject1).a((com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a)new k(this));
    if (!Util.isNullOrNil(this.cJp))
    {
      if (Util.isNullOrNil(this.pNl))
      {
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE();
        p.g(localObject1, "VideoCore.getInstance()");
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bJG())
        {
          localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE();
          p.g(localObject1, "VideoCore.getInstance()");
          if (((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bJF()) {
            this.pNl = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().getProxyUrl(this.cJp);
          }
        }
      }
      if (!Util.isNullOrNil(this.pNl))
      {
        setDataSourceWithCustomKey(this.pNl);
        AppMethodBeat.o(7439);
        return;
      }
      setDataSourceWithCustomKey(this.cJp);
    }
    AppMethodBeat.o(7439);
  }
  
  private final void crw()
  {
    AppMethodBeat.i(7463);
    this.hAk.post((Runnable)new c(this));
    AppMethodBeat.o(7463);
  }
  
  private final boolean getAbTestVideoPreload()
  {
    AppMethodBeat.i(196018);
    boolean bool = ((Boolean)this.pNy.getValue()).booleanValue();
    AppMethodBeat.o(196018);
    return bool;
  }
  
  private final j.a getBizVideoProfiler()
  {
    AppMethodBeat.i(196017);
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.aiP(getContext().toString());
    AppMethodBeat.o(196017);
    return localObject;
  }
  
  private final void hP(final boolean paramBoolean)
  {
    AppMethodBeat.i(7444);
    this.hAk.post((Runnable)new af(this, paramBoolean));
    AppMethodBeat.o(7444);
  }
  
  private final void onError(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(7464);
    Object localObject = ae.SYK;
    localObject = String.format("PlayError %s/%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 2));
    p.g(localObject, "java.lang.String.format(format, *args)");
    Log.w(TAG, "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.bFM += 1;
    if (this.bFM > this.pNb)
    {
      this.hAk.post((Runnable)new o(this, (String)localObject, paramInt1, paramInt2));
      AppMethodBeat.o(7464);
      return;
    }
    this.hAk.postDelayed((Runnable)new p(this), this.pNa);
    AppMethodBeat.o(7464);
  }
  
  private final void prepareAsync()
  {
    AppMethodBeat.i(7454);
    Object localObject;
    if ((this.pNi != null) && (!Util.isNullOrNil(this.cJp)))
    {
      if (Util.isNullOrNil(this.pNl))
      {
        localObject = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE();
        p.g(localObject, "VideoCore.getInstance()");
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject).bJG())
        {
          localObject = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE();
          p.g(localObject, "VideoCore.getInstance()");
          if (((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject).bJF()) {
            this.pNl = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().getProxyUrl(this.cJp);
          }
        }
      }
      if (Util.isNullOrNil(this.pNl)) {
        break label192;
      }
      setDataSourceWithCustomKey(this.pNl);
    }
    for (;;)
    {
      Log.i(TAG, "video prepare async");
      BT(500L);
      this.cJj = false;
      this.pNs = System.currentTimeMillis();
      if (this.pNi != null)
      {
        localObject = getBizVideoProfiler();
        if (localObject != null)
        {
          localObject = ((j.a)localObject).aiR("10");
          if (localObject != null)
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((ff)localObject, getBizVideoProfiler());
          }
        }
        localObject = this.pNi;
        if (localObject == null) {
          p.hyc();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject).prepareAsync();
      }
      AppMethodBeat.o(7454);
      return;
      label192:
      setDataSourceWithCustomKey(this.cJp);
    }
  }
  
  private final void reset()
  {
    this.cJd = false;
    this.cJe = false;
    this.cJf = false;
  }
  
  private final void setDataSourceWithCustomKey(String paramString)
  {
    AppMethodBeat.i(196019);
    if (getAbTestVideoPreload())
    {
      localObject = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().aaV(paramString);
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f localf = this.pNi;
      if (localf == null) {
        p.hyc();
      }
      localf.dV(paramString, (String)localObject);
      AppMethodBeat.o(196019);
      return;
    }
    Object localObject = this.pNi;
    if (localObject == null) {
      p.hyc();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject).setDataSource(paramString);
    AppMethodBeat.o(196019);
  }
  
  private final void setVideoTotalTime(final int paramInt)
  {
    AppMethodBeat.i(7445);
    this.hAk.post((Runnable)new aa(this, paramInt));
    AppMethodBeat.o(7445);
  }
  
  private final void stopTimer()
  {
    AppMethodBeat.i(7447);
    Log.d(TAG, "stop timer");
    this.mEP.stopTimer();
    AppMethodBeat.o(7447);
  }
  
  final void BT(long paramLong)
  {
    AppMethodBeat.i(7452);
    this.pNx.stopTimer();
    this.pNx.startTimer(paramLong);
    AppMethodBeat.o(7452);
  }
  
  public final boolean Qt()
  {
    AppMethodBeat.i(7457);
    this.pNp = false;
    stopTimer();
    MPExoVideoTextureView localMPExoVideoTextureView = this.pNh;
    if (localMPExoVideoTextureView != null) {
      localMPExoVideoTextureView.stop();
    }
    this.mEd = 0;
    if (this.pNi != null)
    {
      this.hAk.post((Runnable)new ad(this));
      AppMethodBeat.o(7457);
      return true;
    }
    AppMethodBeat.o(7457);
    return false;
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(175547);
    this.bDU = paramInt1;
    this.bDY = paramFloat;
    this.mCn = paramInt2;
    this.mCo = paramInt3;
    this.mCp = paramInt4;
    this.mCq = paramInt5;
    if ((this.bDU != 0) && (this.bDY != 0.0F) && (this.mCn != 0) && (this.mCo != 0) && (this.mCp != 0) && (this.mCq != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.pNt = bool;
      Log.i(TAG, "setExoPlayerParam checkExoPlayerParam result = " + this.pNt);
      AppMethodBeat.o(175547);
      return;
    }
  }
  
  public final void aTw() {}
  
  public final void aTx() {}
  
  public final void aTy() {}
  
  public final void aTz() {}
  
  public final void ab(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(7429);
    Log.i(TAG, "prepare async");
    crt();
    prepareAsync();
    ac(paramInt, paramBoolean);
    if (paramBoolean) {
      start();
    }
    AppMethodBeat.o(7429);
  }
  
  public final void ac(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(7448);
    this.pNr = paramBoolean;
    int j = getVideoDurationMs();
    int i = paramInt;
    if (j > 100)
    {
      i = paramInt;
      if (paramInt > j) {
        i = j;
      }
    }
    if ((this.cJj) && (this.pNi != null))
    {
      this.cJe = crv();
      Log.d(TAG, "seekTo mPlayingBeforeSeeking %b, afterPlay %b, seekTime %d", new Object[] { Boolean.valueOf(this.cJe), Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f localf;
      if (!paramBoolean)
      {
        localf = this.pNi;
        if (localf == null) {
          p.hyc();
        }
        localf.pause();
      }
      for (;;)
      {
        if ((j != i) && (i > 0)) {
          this.cJr = false;
        }
        localf = this.pNi;
        if (localf == null) {
          p.hyc();
        }
        localf.k(i, paramBoolean);
        this.pNq = i;
        BT(500L);
        xI(i / 1000);
        AppMethodBeat.o(7448);
        return;
        startTimer();
      }
    }
    this.pNn = i;
    AppMethodBeat.o(7448);
  }
  
  public final void cM(String paramString, int paramInt)
  {
    AppMethodBeat.i(7440);
    p.h(paramString, "_url");
    this.cJp = paramString;
    this.mwI = paramInt;
    this.bzP = false;
    Log.i(TAG, "setVideoPath, media player prepare async");
    prepareAsync();
    com.tencent.f.h.RTc.b((Runnable)new z(this), "AppBrandVideo_checkVideoUrl");
    AppMethodBeat.o(7440);
  }
  
  final void crp()
  {
    AppMethodBeat.i(7431);
    Object localObject = this.pNd;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    if (!this.pNw)
    {
      localObject = this.pNe;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      this.pNu = false;
      AppMethodBeat.o(7431);
      return;
    }
    this.pNu = true;
    AppMethodBeat.o(7431);
  }
  
  final void crq()
  {
    AppMethodBeat.i(7432);
    if (this.pNg != null)
    {
      localTextView = this.pNe;
      if (localTextView != null) {
        localTextView.setText((CharSequence)getContext().getString(2131763176, new Object[] { this.pNg }));
      }
      this.hAk.postDelayed((Runnable)new t(this), 1500L);
      AppMethodBeat.o(7432);
      return;
    }
    Log.w(TAG, "resolutionStr is null");
    TextView localTextView = this.pNe;
    if (localTextView != null)
    {
      localTextView.setVisibility(8);
      AppMethodBeat.o(7432);
      return;
    }
    AppMethodBeat.o(7432);
  }
  
  public final void crr()
  {
    AppMethodBeat.i(7433);
    Log.d(TAG, "show cover");
    ImageView localImageView = this.mvU;
    if (localImageView == null) {
      p.hyc();
    }
    localImageView.setVisibility(0);
    AppMethodBeat.o(7433);
  }
  
  public final void crs()
  {
    AppMethodBeat.i(7434);
    Log.d(TAG, "hide cover");
    ImageView localImageView = this.mvU;
    if (localImageView == null) {
      p.hyc();
    }
    localImageView.setVisibility(8);
    AppMethodBeat.o(7434);
  }
  
  public final void crt()
  {
    AppMethodBeat.i(7437);
    reset();
    Qu();
    cru();
    Qw();
    AppMethodBeat.o(7437);
  }
  
  public final boolean crv()
  {
    AppMethodBeat.i(7450);
    if ((this.pNp) || (isPlaying()) || (this.cJe) || (this.cJd))
    {
      AppMethodBeat.o(7450);
      return true;
    }
    AppMethodBeat.o(7450);
    return false;
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(179023);
    if (getVideoDurationSec() > 0)
    {
      int i = this.mEd * getVideoDurationSec() / 100;
      AppMethodBeat.o(179023);
      return i;
    }
    AppMethodBeat.o(179023);
    return 0;
  }
  
  protected final MTimerHandler getCheckTimer()
  {
    return this.mEP;
  }
  
  public final ImageView getCoverIv()
  {
    AppMethodBeat.i(7430);
    ImageView localImageView = this.mvU;
    if (localImageView == null) {
      p.hyc();
    }
    AppMethodBeat.o(7430);
    return localImageView;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(7424);
    if (this.pNi != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f localf = this.pNi;
      if (localf == null) {
        p.hyc();
      }
      int i = localf.getCurrentPosition();
      AppMethodBeat.o(7424);
      return i;
    }
    AppMethodBeat.o(7424);
    return 0;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(7425);
    if (this.pNi != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f localf = this.pNi;
      if (localf == null) {
        p.hyc();
      }
      int i = localf.getCurrentPosition() / 1000;
      AppMethodBeat.o(7425);
      return i;
    }
    AppMethodBeat.o(7425);
    return 0;
  }
  
  protected final int getERROR_CHECK_TIME()
  {
    return this.pMZ;
  }
  
  protected final int getERROR_TRY_AGAIN_DELAY_TIME()
  {
    return this.pNa;
  }
  
  protected final int getERROR_TRY_MAX_TIME()
  {
    return this.pNb;
  }
  
  protected final MTimerHandler getErrorCheckTimer()
  {
    return this.mER;
  }
  
  protected final int getErrorCount()
  {
    return this.bFM;
  }
  
  public final long getFirstRenderTime()
  {
    AppMethodBeat.i(177797);
    if (this.pNs != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.pNs;
      AppMethodBeat.o(177797);
      return l1 - l2;
    }
    AppMethodBeat.o(177797);
    return 0L;
  }
  
  protected final ProgressBar getLoading()
  {
    return this.mEz;
  }
  
  protected final int getMVideoSource()
  {
    return this.mwp;
  }
  
  public final boolean getNeedShowSwitchTitleTextView()
  {
    return this.pNu;
  }
  
  protected final MTimerHandler getShowLoadingTimer()
  {
    return this.pNx;
  }
  
  protected final MMHandler getUiHandler()
  {
    return this.hAk;
  }
  
  public final int getVideoDurationMs()
  {
    AppMethodBeat.i(7423);
    if (this.pNi != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f localf = this.pNi;
      if (localf == null) {
        p.hyc();
      }
      i = localf.getDuration();
      AppMethodBeat.o(7423);
      return i;
    }
    int i = this.mwI;
    AppMethodBeat.o(7423);
    return i * 1000;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(7422);
    if (this.pNi != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f localf = this.pNi;
      if (localf == null) {
        p.hyc();
      }
      i = localf.getDuration() / 1000;
      AppMethodBeat.o(7422);
      return i;
    }
    int i = this.mwI;
    AppMethodBeat.o(7422);
    return i;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(7428);
    if (this.pNi != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f localf = this.pNi;
      if (localf == null) {
        p.hyc();
      }
      int i = localf.getVideoHeight();
      AppMethodBeat.o(7428);
      return i;
    }
    AppMethodBeat.o(7428);
    return 0;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(7427);
    if (this.pNi != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f localf = this.pNi;
      if (localf == null) {
        p.hyc();
      }
      int i = localf.getVideoWidth();
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
    this.pNx.stopTimer();
    this.hAk.post((Runnable)new m(this));
    AppMethodBeat.o(7453);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(7426);
    if ((this.pNi != null) && (this.cJj))
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f localf = this.pNi;
      if (localf == null) {
        p.hyc();
      }
      boolean bool = localf.isPlaying();
      AppMethodBeat.o(7426);
      return bool;
    }
    AppMethodBeat.o(7426);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(7459);
    this.pNk.apm();
    setKeepScreenOn(false);
    Qu();
    pause();
    if (this.mSurface != null)
    {
      Surface localSurface = this.mSurface;
      if (localSurface == null) {
        p.hyc();
      }
      localSurface.release();
      this.mSurface = null;
    }
    stopTimer();
    this.mER.stopTimer();
    this.hAk.removeCallbacksAndMessages(null);
    AppMethodBeat.o(7459);
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(7460);
    Log.d(TAG, "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    this.hAk.post((Runnable)new u(this));
    AppMethodBeat.o(7460);
  }
  
  public final void onVideoPlay()
  {
    AppMethodBeat.i(7461);
    this.pNp = true;
    this.mEI = false;
    Log.d(TAG, "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    this.hAk.post((Runnable)new v(this));
    AppMethodBeat.o(7461);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(7456);
    this.pNp = false;
    hP(false);
    stopTimer();
    if (this.pNi != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f localf = this.pNi;
      if (localf == null) {
        p.hyc();
      }
      if (!localf.isPlaying())
      {
        Log.i(TAG, "video pause, video is not playing");
        this.cJi = false;
        AppMethodBeat.o(7456);
        return true;
      }
      if (!this.cJj)
      {
        Log.i(TAG, "video pause, video not prepared yet, pause video when prepared");
        this.cJi = false;
        AppMethodBeat.o(7456);
        return true;
      }
      Log.i(TAG, "video pause");
      localf = this.pNi;
      if (localf == null) {
        p.hyc();
      }
      localf.pause();
      onVideoPause();
      AppMethodBeat.o(7456);
      return true;
    }
    AppMethodBeat.o(7456);
    return false;
  }
  
  protected final void setCheckTimer(MTimerHandler paramMTimerHandler)
  {
    AppMethodBeat.i(7421);
    p.h(paramMTimerHandler, "<set-?>");
    this.mEP = paramMTimerHandler;
    AppMethodBeat.o(7421);
  }
  
  public final void setControllerBarShowing(boolean paramBoolean)
  {
    this.pNw = paramBoolean;
  }
  
  protected final void setErrorCheckTimer(MTimerHandler paramMTimerHandler)
  {
    AppMethodBeat.i(7465);
    p.h(paramMTimerHandler, "<set-?>");
    this.mER = paramMTimerHandler;
    AppMethodBeat.o(7465);
  }
  
  protected final void setErrorCount(int paramInt)
  {
    this.bFM = paramInt;
  }
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(7441);
    p.h(paramb, "_callback");
    this.pNj = paramb;
    AppMethodBeat.o(7441);
  }
  
  public final void setKeepScreenOn(final boolean paramBoolean)
  {
    AppMethodBeat.i(7462);
    Log.d(TAG, "set keep screen on[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    this.hAk.post((Runnable)new y(this, paramBoolean));
    AppMethodBeat.o(7462);
  }
  
  public final void setLive(boolean paramBoolean)
  {
    this.bzP = paramBoolean;
  }
  
  protected final void setLoading(ProgressBar paramProgressBar)
  {
    this.mEz = paramProgressBar;
  }
  
  protected final void setMVideoSource(int paramInt)
  {
    this.mwp = paramInt;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(7458);
    this.isb = paramBoolean;
    if (this.pNi != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f localf = this.pNi;
      if (localf == null) {
        p.hyc();
      }
      localf.setMute(this.isb);
    }
    AppMethodBeat.o(7458);
  }
  
  public final void setNeedShowSwitchTitleTextView(boolean paramBoolean)
  {
    this.pNu = paramBoolean;
  }
  
  protected final void setPlayOnUiPause(boolean paramBoolean)
  {
    this.mEI = paramBoolean;
  }
  
  protected final void setShowLoadingTimer(MTimerHandler paramMTimerHandler)
  {
    AppMethodBeat.i(7451);
    p.h(paramMTimerHandler, "<set-?>");
    this.pNx = paramMTimerHandler;
    AppMethodBeat.o(7451);
  }
  
  public final void setSwitchingResolution(boolean paramBoolean)
  {
    this.pNv = paramBoolean;
  }
  
  protected final void setUIAvailable(boolean paramBoolean)
  {
    this.mEw = paramBoolean;
  }
  
  protected final void setUiHandler(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(7420);
    p.h(paramMMHandler, "<set-?>");
    this.hAk = paramMMHandler;
    AppMethodBeat.o(7420);
  }
  
  public final void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(7442);
    p.h(paramh, "_footerView");
    this.pNf = paramh;
    paramh = this.pNc;
    if (paramh == null) {
      p.hyc();
    }
    paramh.removeAllViews();
    paramh = this.pNc;
    if (paramh == null) {
      p.hyc();
    }
    paramh.addView((View)this.pNf);
    AppMethodBeat.o(7442);
  }
  
  public final void setVideoSource(int paramInt)
  {
    this.mwp = paramInt;
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(7455);
    if (!this.mEw)
    {
      Log.w(TAG, "ui on pause now, why u call me to play? [%s]", new Object[] { Util.getStack() });
      AppMethodBeat.o(7455);
      return false;
    }
    if (this.mSurface == null)
    {
      Log.w(TAG, "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.mEn = true;
      this.cJi = true;
      AppMethodBeat.o(7455);
      return false;
    }
    this.pNp = true;
    if (this.pNi == null)
    {
      crt();
      prepareAsync();
    }
    if (this.pNi != null)
    {
      setKeepScreenOn(true);
      this.pNk.a((d.a)this);
      Object localObject1;
      if (this.cJj)
      {
        localObject1 = this.pNi;
        if (localObject1 == null) {
          p.hyc();
        }
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject1).isPlaying())
        {
          Log.i(TAG, "video play, video is playing");
          onVideoPlay();
          AppMethodBeat.o(7455);
          return true;
        }
      }
      if ((this.pNi != null) && (!this.cJj))
      {
        Log.i(TAG, "video play, video not prepared yet, start until prepared");
        this.cJi = true;
        AppMethodBeat.o(7455);
        return true;
      }
      if (this.pNi != null)
      {
        localObject1 = this.pNi;
        if (localObject1 == null) {
          p.hyc();
        }
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject1).getState() == 5)
        {
          Log.i(TAG, "video play, video has stopped now, try prepare and start when prepared");
          this.cJi = true;
          Log.i(TAG, "video play, media player prepare async");
          prepareAsync();
          AppMethodBeat.o(7455);
          return true;
        }
      }
      Object localObject2;
      if (this.cJr)
      {
        Log.i(TAG, "video play, video has ended playing, clear surface and start again");
        this.cJr = false;
        cro();
        crt();
        prepareAsync();
        if (this.pNi != null)
        {
          this.cJi = true;
          localObject1 = TAG;
          localObject2 = this.pNi;
          if (localObject2 == null) {
            p.hyc();
          }
          Log.i((String)localObject1, "video play, media player state:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject2).getState()) });
          prepareAsync();
        }
        AppMethodBeat.o(7455);
        return true;
      }
      if (this.pNi != null)
      {
        localObject1 = this.pNi;
        if (localObject1 == null) {
          p.hyc();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)localObject1).start();
        localObject1 = getBizVideoProfiler();
        if (localObject1 != null)
        {
          localObject1 = ((j.a)localObject1).aiR("15");
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((ff)localObject1, getBizVideoProfiler());
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
    if (!this.mEP.stopped()) {
      stopTimer();
    }
    this.mEP.startTimer(pNz);
    AppMethodBeat.o(7446);
  }
  
  protected final void xI(final int paramInt)
  {
    AppMethodBeat.i(7443);
    this.hAk.post((Runnable)new ae(this, paramInt));
    AppMethodBeat.o(7443);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class aa
    implements Runnable
  {
    aa(MPExoVideoWrapper paramMPExoVideoWrapper, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(7414);
      if (MPExoVideoWrapper.w(this.pND) != null)
      {
        com.tencent.mm.pluginsdk.ui.h localh = MPExoVideoWrapper.w(this.pND);
        if (localh == null) {
          p.hyc();
        }
        if (localh.getVideoTotalTime() != paramInt)
        {
          localh = MPExoVideoWrapper.w(this.pND);
          if (localh == null) {
            p.hyc();
          }
          localh.setVideoTotalTime(paramInt);
        }
      }
      AppMethodBeat.o(7414);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class ab
    implements Runnable
  {
    ab(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7415);
      if (this.pND.getLoading() != null)
      {
        Object localObject = this.pND.getLoading();
        if (localObject == null) {
          p.hyc();
        }
        if (((ProgressBar)localObject).getVisibility() != 0)
        {
          Log.i(MPExoVideoWrapper.access$getTAG$cp(), "show loading");
          localObject = this.pND.getLoading();
          if (localObject != null) {
            ((ProgressBar)localObject).setVisibility(0);
          }
          localObject = this.pND;
          ((MPExoVideoWrapper)localObject).hAk.post((Runnable)new MPExoVideoWrapper.w((MPExoVideoWrapper)localObject));
        }
      }
      AppMethodBeat.o(7415);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class ac
    implements MTimerHandler.CallBack
  {
    ac(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7416);
      this.pND.getUiHandler().post(MPExoVideoWrapper.C(this.pND));
      AppMethodBeat.o(7416);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class ad
    implements Runnable
  {
    ad(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7417);
      Log.i(MPExoVideoWrapper.access$getTAG$cp(), "video stop");
      this.pND.xI(0);
      MPExoVideoWrapper.b(this.pND, false);
      MPExoVideoWrapper.f(this.pND);
      this.pND.onVideoPause();
      AppMethodBeat.o(7417);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class ae
    implements Runnable
  {
    ae(MPExoVideoWrapper paramMPExoVideoWrapper, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(7418);
      com.tencent.mm.pluginsdk.ui.h localh = MPExoVideoWrapper.w(this.pND);
      if (localh == null) {
        p.hyc();
      }
      localh.xv(paramInt);
      AppMethodBeat.o(7418);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class af
    implements Runnable
  {
    af(MPExoVideoWrapper paramMPExoVideoWrapper, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(7419);
      com.tencent.mm.pluginsdk.ui.h localh = MPExoVideoWrapper.w(this.pND);
      if (localh == null) {
        p.hyc();
      }
      localh.hP(paramBoolean);
      AppMethodBeat.o(7419);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7387);
      MPExoVideoTextureView localMPExoVideoTextureView = MPExoVideoWrapper.h(this.pND);
      if (localMPExoVideoTextureView != null) {
        localMPExoVideoTextureView.setVideoSize(MPExoVideoWrapper.y(this.pND), MPExoVideoWrapper.z(this.pND));
      }
      localMPExoVideoTextureView = MPExoVideoWrapper.h(this.pND);
      if (localMPExoVideoTextureView != null) {
        localMPExoVideoTextureView.crn();
      }
      localMPExoVideoTextureView = MPExoVideoWrapper.h(this.pND);
      if (localMPExoVideoTextureView != null)
      {
        localMPExoVideoTextureView.setScaleType(i.e.Kcb);
        AppMethodBeat.o(7387);
        return;
      }
      AppMethodBeat.o(7387);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class d
    implements MTimerHandler.CallBack
  {
    d(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7388);
      this.pND.isPlaying();
      if (this.pND.mEI)
      {
        Log.d(MPExoVideoWrapper.access$getTAG$cp(), "checkTimer onVideoPlay");
        this.pND.onVideoPlay();
        this.pND.setPlayOnUiPause(false);
      }
      for (;;)
      {
        AppMethodBeat.o(7388);
        return true;
        this.pND.xI(this.pND.getCurrPosSec());
        MPExoVideoWrapper.b(this.pND, this.pND.isPlaying());
        MPExoVideoWrapper.B(this.pND);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onInfo"})
  static final class e
    implements c.f
  {
    e(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean cb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196009);
      boolean bool = MPExoVideoWrapper.a(this.pND, paramInt1, paramInt2);
      AppMethodBeat.o(196009);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"})
  static final class f
    implements c.e
  {
    f(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean cc(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196010);
      MPExoVideoWrapper.b(this.pND, paramInt1, paramInt2);
      AppMethodBeat.o(196010);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class g
    implements c.g
  {
    g(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramc)
    {
      AppMethodBeat.i(196011);
      MPExoVideoWrapper.r(this.pND);
      if (MPExoVideoWrapper.s(this.pND) != null)
      {
        paramc = MPExoVideoWrapper.s(this.pND);
        if (paramc == null) {
          p.hyc();
        }
        paramc.dH("", "");
      }
      AppMethodBeat.o(196011);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class h
    implements c.b
  {
    h(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void QA()
    {
      AppMethodBeat.i(196012);
      MPExoVideoWrapper.t(this.pND);
      AppMethodBeat.o(196012);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class i
    implements c.h
  {
    i(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramc)
    {
      AppMethodBeat.i(196013);
      MPExoVideoWrapper.u(this.pND);
      AppMethodBeat.o(196013);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "onVideoSizeChanged"})
  static final class j
    implements c.i
  {
    j(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c paramc, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196014);
      MPExoVideoWrapper.c(this.pND, paramInt1, paramInt2);
      AppMethodBeat.o(196014);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "percent", "", "onBufferingUpdate"})
  static final class k
    implements com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a
  {
    k(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void id(int paramInt)
    {
      AppMethodBeat.i(196015);
      MPExoVideoWrapper.b(this.pND, paramInt);
      AppMethodBeat.o(196015);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class l
    implements MTimerHandler.CallBack
  {
    l(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7396);
      if (this.pND.getErrorCount() > 0)
      {
        if (this.pND.isPlaying())
        {
          MPExoVideoWrapper.D(this.pND);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7397);
      if (this.pND.getLoading() != null)
      {
        Object localObject = this.pND.getLoading();
        if (localObject == null) {
          p.hyc();
        }
        if (((ProgressBar)localObject).getVisibility() != 8)
        {
          Log.i(MPExoVideoWrapper.access$getTAG$cp(), "hide loading");
          localObject = this.pND.getLoading();
          if (localObject != null) {
            ((ProgressBar)localObject).setVisibility(8);
          }
          localObject = this.pND;
          ((MPExoVideoWrapper)localObject).hAk.postDelayed((Runnable)new MPExoVideoWrapper.x((MPExoVideoWrapper)localObject), 500L);
        }
      }
      AppMethodBeat.o(7397);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-brandservice_release"})
  public static final class n
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7402);
      p.h(paramSurfaceTexture, "surface");
      Log.i(MPExoVideoWrapper.access$getTAG$cp(), "on surface texture available, width %d height %d switching %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.pND.pNv) });
      Object localObject = MPExoVideoWrapper.g(this.pND);
      if (localObject != null)
      {
        localObject = ((j.a)localObject).aiR("9");
        if (localObject != null)
        {
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((ff)localObject, "PlayerType", "3");
          if (localObject != null)
          {
            localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((ff)localObject, MPExoVideoWrapper.g(this.pND));
          }
        }
      }
      this.pND.startTimer();
      localObject = MPExoVideoWrapper.h(this.pND);
      if (localObject != null) {
        ((MPExoVideoTextureView)localObject).gLi();
      }
      localObject = MPExoVideoWrapper.h(this.pND);
      if (localObject != null) {
        ((MPExoVideoTextureView)localObject).h(MPExoVideoWrapper.b(this.pND));
      }
      MPExoVideoWrapper.a(this.pND, new Surface(paramSurfaceTexture));
      if ((MPExoVideoWrapper.c(this.pND) == null) || (!MPExoVideoWrapper.d(this.pND))) {
        if (this.pND.pNv) {
          this.pND.ab(MPExoVideoWrapper.i(this.pND), MPExoVideoWrapper.j(this.pND));
        }
      }
      for (;;)
      {
        if ((!MPExoVideoWrapper.l(this.pND)) && (this.pND.pNv)) {
          MPExoVideoWrapper.m(this.pND);
        }
        AppMethodBeat.o(7402);
        return;
        this.pND.crt();
        MPExoVideoWrapper.k(this.pND);
        continue;
        Log.i(MPExoVideoWrapper.access$getTAG$cp(), "init, setSurface");
        paramSurfaceTexture = MPExoVideoWrapper.c(this.pND);
        if (paramSurfaceTexture == null) {
          p.hyc();
        }
        paramSurfaceTexture.setSurface(MPExoVideoWrapper.b(this.pND));
        if (MPExoVideoWrapper.e(this.pND))
        {
          paramSurfaceTexture = MPExoVideoWrapper.g(this.pND);
          if (paramSurfaceTexture != null)
          {
            paramSurfaceTexture = paramSurfaceTexture.aiR("15");
            if (paramSurfaceTexture != null)
            {
              localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.pLk;
              com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(paramSurfaceTexture, MPExoVideoWrapper.g(this.pND));
            }
          }
          paramSurfaceTexture = MPExoVideoWrapper.c(this.pND);
          if (paramSurfaceTexture == null) {
            p.hyc();
          }
          paramSurfaceTexture.start();
        }
        MPExoVideoWrapper.a(this.pND, false);
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(7401);
      p.h(paramSurfaceTexture, "surface");
      Log.i(MPExoVideoWrapper.access$getTAG$cp(), "on surface texture destroyed");
      MPExoVideoWrapper.a(this.pND, null);
      if ((MPExoVideoWrapper.c(this.pND) != null) && (MPExoVideoWrapper.d(this.pND))) {
        if (this.pND.isPlaying())
        {
          MPExoVideoWrapper.a(this.pND, true);
          paramSurfaceTexture = MPExoVideoWrapper.c(this.pND);
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.pause();
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(7401);
        return false;
        MPExoVideoWrapper.f(this.pND);
        MPExoVideoWrapper.a(this.pND, false);
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7400);
      p.h(paramSurfaceTexture, "surface");
      AppMethodBeat.o(7400);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(7399);
      p.h(paramSurfaceTexture, "surface");
      if (this.pND.getLoading() != null)
      {
        paramSurfaceTexture = this.pND.getLoading();
        if (paramSurfaceTexture == null) {
          p.hyc();
        }
        if (paramSurfaceTexture.getVisibility() == 0) {
          this.pND.hideLoading();
        }
      }
      if (MPExoVideoWrapper.a(this.pND) != null)
      {
        paramSurfaceTexture = MPExoVideoWrapper.a(this.pND);
        if (paramSurfaceTexture == null) {
          p.hyc();
        }
        if ((paramSurfaceTexture.getVisibility() == 0) && ((this.pND.isPlaying()) || (this.pND.getCurrPosSec() != 0))) {
          this.pND.getUiHandler().post((Runnable)new a(this));
        }
      }
      AppMethodBeat.o(7399);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPExoVideoWrapper.n paramn) {}
      
      public final void run()
      {
        AppMethodBeat.i(7398);
        Log.d(MPExoVideoWrapper.access$getTAG$cp(), "hide cover onSurfaceTextureUpdated");
        this.pNE.pND.crs();
        AppMethodBeat.o(7398);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(MPExoVideoWrapper paramMPExoVideoWrapper, String paramString, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(7403);
      this.pND.Qt();
      this.pND.hideLoading();
      if (MPExoVideoWrapper.s(this.pND) != null)
      {
        i.b localb = MPExoVideoWrapper.s(this.pND);
        if (localb == null) {
          p.hyc();
        }
        localb.c("", "", this.pNF, paramInt1, paramInt2);
      }
      AppMethodBeat.o(7403);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7404);
      this.pND.BT(500L);
      this.pND.xI(this.pND.getCurrPosSec());
      MPExoVideoWrapper.A(this.pND);
      AppMethodBeat.o(7404);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(196016);
      if (this.pND.pNv) {
        MPExoVideoWrapper.n(this.pND);
      }
      AppMethodBeat.o(196016);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7405);
      MPExoVideoWrapper.n(this.pND);
      AppMethodBeat.o(7405);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7406);
      ImageView localImageView = MPExoVideoWrapper.o(this.pND);
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      MPExoVideoWrapper.p(this.pND);
      AppMethodBeat.o(7406);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7407);
      TextView localTextView = MPExoVideoWrapper.q(this.pND);
      if (localTextView != null)
      {
        localTextView.setVisibility(8);
        AppMethodBeat.o(7407);
        return;
      }
      AppMethodBeat.o(7407);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7408);
      this.pND.setKeepScreenOn(false);
      MPExoVideoWrapper.x(this.pND).apm();
      if (MPExoVideoWrapper.s(this.pND) != null)
      {
        i.b localb = MPExoVideoWrapper.s(this.pND);
        if (localb == null) {
          p.hyc();
        }
        localb.dJ("", "");
      }
      AppMethodBeat.o(7408);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class v
    implements Runnable
  {
    v(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7409);
      this.pND.setKeepScreenOn(true);
      MPExoVideoWrapper.x(this.pND).a((d.a)this.pND);
      if (MPExoVideoWrapper.s(this.pND) != null)
      {
        i.b localb = MPExoVideoWrapper.s(this.pND);
        if (localb == null) {
          p.hyc();
        }
        localb.dK("", "");
      }
      MPExoVideoWrapper.b(this.pND, true);
      this.pND.startTimer();
      AppMethodBeat.o(7409);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class w
    implements Runnable
  {
    w(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7410);
      if (MPExoVideoWrapper.s(this.pND) != null)
      {
        i.b localb = MPExoVideoWrapper.s(this.pND);
        if (localb == null) {
          p.hyc();
        }
        localb.dL("", "");
      }
      AppMethodBeat.o(7410);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class x
    implements Runnable
  {
    x(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7411);
      if (MPExoVideoWrapper.s(this.pND) != null)
      {
        i.b localb = MPExoVideoWrapper.s(this.pND);
        if (localb == null) {
          p.hyc();
        }
        localb.dM("", "");
      }
      AppMethodBeat.o(7411);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class y
    implements Runnable
  {
    y(MPExoVideoWrapper paramMPExoVideoWrapper, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(7412);
      MPExoVideoWrapper.c(this.pND, paramBoolean);
      AppMethodBeat.o(7412);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class z
    implements Runnable
  {
    z(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7413);
      MPExoVideoWrapper.v(this.pND);
      AppMethodBeat.o(7413);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper
 * JD-Core Version:    0.7.0.1
 */