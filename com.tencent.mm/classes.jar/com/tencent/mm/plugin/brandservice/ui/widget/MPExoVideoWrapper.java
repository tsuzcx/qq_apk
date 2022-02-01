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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.util.Arrays;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ERROR_CHECK_TIME", "", "getERROR_CHECK_TIME", "()I", "ERROR_TRY_AGAIN_DELAY_TIME", "getERROR_TRY_AGAIN_DELAY_TIME", "ERROR_TRY_MAX_TIME", "getERROR_TRY_MAX_TIME", "bandwidthFraction", "", "bizVideoProfiler", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "getBizVideoProfiler", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "cacheTimeSec", "getCacheTimeSec", "callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getCheckTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "setCheckTimer", "(Lcom/tencent/mm/sdk/platformtools/MTimerHandler;)V", "currPosMs", "getCurrPosMs", "currPosSec", "getCurrPosSec", "downloadPercent", "durationSec", "errorCheckTimer", "getErrorCheckTimer", "setErrorCheckTimer", "errorCount", "getErrorCount", "setErrorCount", "(I)V", "footerView", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoFooter;", "hasExoParam", "", "inBackGround", "isControllerBarShowing", "()Z", "setControllerBarShowing", "(Z)V", "isInFullScreen", "isLive", "setLive", "isPlayOnUiPause", "setPlayOnUiPause", "isPlaying", "isSwitchingResolution", "setSwitchingResolution", "isUIAvailable", "setUIAvailable", "lastSeekAutoPlay", "lastSeekTime", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "localIsPlaying", "mAudioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "mCoverIv", "Landroid/widget/ImageView;", "mFirstRenderStartTime", "", "mFooterContainer", "Landroid/widget/LinearLayout;", "mLastUpdateBuffer", "mMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/ExoMediaPlayer;", "mMediaPlayerAvailable", "mPlayingBeforeBuffering", "mPlayingBeforeSeeking", "mPlayingWhenBackground", "mStartSeekPosition", "mStartWhenPrepared", "mStartWhenSeekCompleted", "mSurface", "Landroid/view/Surface;", "mSwitchCoverIv", "mSwitchTitleTextView", "Landroid/widget/TextView;", "mVideoDuration", "mVideoHasEndedPlaying", "mVideoHasPrepared", "mVideoHeight", "mVideoLooping", "mVideoPath", "", "mVideoProxyUrl", "mVideoSource", "getMVideoSource", "setMVideoSource", "mVideoTextureView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoTextureView;", "mVideoWidth", "maxBufferMs", "maxDurForQualityMs", "maxInitialBitrate", "minBufferMs", "minDurForQualityMs", "mute", "needShowSwitchTitleTextView", "getNeedShowSwitchTitleTextView", "setNeedShowSwitchTitleTextView", "pauseByDestroyed", "resolutionStr", "showLoadingRunning", "Ljava/lang/Runnable;", "showLoadingTimer", "getShowLoadingTimer", "setShowLoadingTimer", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setUiHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "videoDurationMs", "getVideoDurationMs", "videoDurationSec", "getVideoDurationSec", "videoHeight", "getVideoHeight", "videoWidth", "getVideoWidth", "adjustObjectFit", "", "applyMediaPlayerParams", "checkExoPlayerParam", "checkVideoUrl", "clearSurface", "createMediaPlayer", "enterFullScreen", "gain", "getCoverIv", "getFirstRenderTime", "hideCover", "hideLoading", "init", "isNeedToPlay", "isShowingLoading", "isSwitchTitleTextViewShowing", "loss", "lossTransient", "lossTransientCanDuck", "onControllerBarVisible", "visible", "onError", "what", "extra", "onMediaPlayerBufferingUpdate", "percent", "onMediaPlayerCompletion", "onMediaPlayerInfo", "onMediaPlayerPrepared", "onMediaPlayerSeekComplete", "onMediaPlayerVideoSizeChanged", "width", "height", "onSeekEnd", "onSetResolution", "onSwitchEnd", "onSwitchEndShowSuccessWording", "onUIDestroy", "onUIPause", "onUIResume", "onVideoLoadedMetaData", "duration", "onVideoPause", "onVideoPlay", "onVideoProgress", "onVideoWaiting", "onVideoWaitingEnd", "pause", "prepareAsync", "quitFullScreen", "releaseMediaPlayer", "releaseSurface", "reset", "resetErrorCount", "resetMediaPlayer", "resetResolutionStatus", "restartVideo", "seekPosition", "play", "retryWhenError", "seekTo", "ms", "afterPlay", "setExoPlayerParam", "setIMMVideoViewCallback", "_callback", "setKeepScreenOn", "keepScreenOn", "setMute", "_mute", "setSwitchSpeedCover", "setVideoFooterView", "_footerView", "setVideoPath", "_isLive", "_url", "_durationSec", "setVideoSource", "videoSource", "setVideoTotalTime", "seconds", "showCover", "showLoading", "showLoadingDelayed", "delayMillis", "start", "startErrorCheckTimer", "startTimer", "stop", "stopErrorCheckTimer", "stopTimer", "tryPreloadVideo", "unKown", "updateUI", "currPlaySec", "updateVideoStatus", "isPlay", "Companion", "plugin-brandservice_release"})
public final class MPExoVideoWrapper
  extends RelativeLayout
  implements d.a
{
  public static final String TAG = "MicroMsg.MPExoVideoWrapper";
  private static final int nnH = 500;
  private static final int nnI = 0;
  public static final MPExoVideoWrapper.a nnJ;
  boolean bqS;
  private int bvE;
  private float bvI;
  private int bxy;
  private boolean cna;
  private boolean cnb;
  private boolean cnc;
  private boolean cnf;
  public boolean cng;
  private boolean cnh;
  private final boolean cni;
  private int cnk;
  private int cnl;
  private String cnm;
  private boolean cno;
  ap gAC;
  private boolean gCJ;
  private ImageView kmV;
  private int knG;
  private int knr;
  private int ksN;
  private int ksO;
  private int ksP;
  private int ksQ;
  private boolean kuD;
  public boolean kuL;
  public ProgressBar kuP;
  public boolean kuY;
  private int kut;
  private av kvf;
  private av kvh;
  private final Runnable kvk;
  boolean lpO;
  private Surface mSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  private boolean nnA;
  private long nnB;
  private boolean nnC;
  boolean nnD;
  boolean nnE;
  boolean nnF;
  private av nnG;
  private final int nni;
  private final int nnj;
  private final int nnk;
  private LinearLayout nnl;
  ImageView nnm;
  TextView nnn;
  private g nno;
  String nnp;
  MPExoVideoTextureView nnq;
  public com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c nnr;
  private h.b nns;
  public final d nnt;
  private String nnu;
  public boolean nnv;
  private int nnw;
  public boolean nnx;
  private boolean nny;
  private int nnz;
  
  static
  {
    AppMethodBeat.i(7467);
    nnJ = new MPExoVideoWrapper.a((byte)0);
    TAG = "MicroMsg.MPExoVideoWrapper";
    nnH = 500;
    AppMethodBeat.o(7467);
  }
  
  public MPExoVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7466);
    this.nni = 5000;
    this.nnj = 200;
    this.nnk = 5;
    this.gAC = new ap(Looper.getMainLooper());
    paramContext = d.aqs();
    k.g(paramContext, "AudioHelperTool.createTool()");
    this.nnt = paramContext;
    this.knr = nnI;
    this.kuL = true;
    this.bvE = 800000;
    this.bvI = 0.75F;
    this.ksN = 10000;
    this.ksO = 25000;
    this.ksP = 15000;
    this.ksQ = 30000;
    this.kvf = new av((av.a)new c(this), true);
    LayoutInflater.from(getContext()).inflate(2131494956, (ViewGroup)this);
    this.nnq = ((MPExoVideoTextureView)findViewById(2131302512));
    this.kuP = ((ProgressBar)findViewById(2131306352));
    this.nnl = ((LinearLayout)findViewById(2131306342));
    this.kmV = ((ImageView)findViewById(2131302505));
    this.nnm = ((ImageView)findViewById(2131302511));
    this.nnn = ((TextView)findViewById(2131305584));
    paramContext = this.nnq;
    if (paramContext == null) {
      k.fvU();
    }
    paramContext.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new m(this));
    this.kvk = ((Runnable)new z(this));
    this.nnG = new av((av.a)new aa(this), false);
    this.kvh = new av((av.a)new k(this), true);
    AppMethodBeat.o(7466);
  }
  
  private final void Fr()
  {
    AppMethodBeat.i(7463);
    this.gAC.post((Runnable)new b(this));
    AppMethodBeat.o(7463);
  }
  
  private final void Fu()
  {
    try
    {
      AppMethodBeat.i(7435);
      if (this.nnr != null)
      {
        ad.i(TAG, "releaseMediaPlayer");
        com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nnr;
        if (localc == null) {
          k.fvU();
        }
        localc.a(null);
        localc = this.nnr;
        if (localc == null) {
          k.fvU();
        }
        localc.a(null);
        localc = this.nnr;
        if (localc == null) {
          k.fvU();
        }
        localc.a(null);
        localc = this.nnr;
        if (localc == null) {
          k.fvU();
        }
        localc.a(null);
        localc = this.nnr;
        if (localc == null) {
          k.fvU();
        }
        localc.a(null);
        localc = this.nnr;
        if (localc == null) {
          k.fvU();
        }
        localc.a(null);
        localc = this.nnr;
        if (localc == null) {
          k.fvU();
        }
        localc.stop();
        localc = this.nnr;
        if (localc == null) {
          k.fvU();
        }
        localc.reset();
        localc = this.nnr;
        if (localc == null) {
          k.fvU();
        }
        localc.release();
      }
      this.nnr = null;
      this.cnh = false;
      AppMethodBeat.o(7435);
      return;
    }
    finally {}
  }
  
  private final void Fv()
  {
    AppMethodBeat.i(7438);
    if (this.nnr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nnr;
      if (localc == null) {
        k.fvU();
      }
      localc.setMute(this.gCJ);
      if (this.mSurface != null)
      {
        localc = this.nnr;
        if (localc == null) {
          k.fvU();
        }
        localc.setSurface(this.mSurface);
      }
    }
    AppMethodBeat.o(7438);
  }
  
  private final void bGB()
  {
    AppMethodBeat.i(7436);
    if ((this.mSurface != null) && (this.cng))
    {
      MPExoVideoTextureView localMPExoVideoTextureView = this.nnq;
      if (localMPExoVideoTextureView != null)
      {
        localMPExoVideoTextureView.bGB();
        AppMethodBeat.o(7436);
        return;
      }
    }
    AppMethodBeat.o(7436);
  }
  
  private final void bGH()
  {
    AppMethodBeat.i(7439);
    if (this.nnr != null)
    {
      AppMethodBeat.o(7439);
      return;
    }
    ad.i(TAG, "createMediaPlayer");
    this.kut = 0;
    float f;
    if (this.nnC)
    {
      localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c(this.bvE, this.bvI, this.ksN, this.ksO, this.ksP, this.ksQ);
      this.nnr = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1);
      localObject1 = this.nnr;
      if (localObject1 == null) {
        k.fvU();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).setLooping(this.cni);
      localObject1 = this.nnr;
      if (localObject1 == null) {
        k.fvU();
      }
      Object localObject2 = c.nnW;
      localObject2 = c.bGK();
      if (localObject2 == null) {
        break label185;
      }
      f = ((c.a)localObject2).nod;
      label131:
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).ay(f);
      if (this.nnr == null) {
        break label190;
      }
    }
    label185:
    label190:
    for (boolean bool = true;; bool = false)
    {
      this.cnh = bool;
      if (this.cnh) {
        break label195;
      }
      ad.e(TAG, "createMediaPlayer, create media player fail");
      AppMethodBeat.o(7439);
      return;
      localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c();
      break;
      f = 1.0F;
      break label131;
    }
    label195:
    Object localObject1 = this.nnr;
    if (localObject1 == null) {
      k.fvU();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).a((b.d)new d(this));
    localObject1 = this.nnr;
    if (localObject1 == null) {
      k.fvU();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).a((b.c)new e(this));
    localObject1 = this.nnr;
    if (localObject1 == null) {
      k.fvU();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).a((b.e)new f(this));
    localObject1 = this.nnr;
    if (localObject1 == null) {
      k.fvU();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).a((b.b)new g(this));
    localObject1 = this.nnr;
    if (localObject1 == null) {
      k.fvU();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).a((b.f)new h(this));
    localObject1 = this.nnr;
    if (localObject1 == null) {
      k.fvU();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).a((b.g)new i(this));
    localObject1 = this.nnr;
    if (localObject1 == null) {
      k.fvU();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).a((b.a)new j(this));
    if (!bt.isNullOrNil(this.cnm))
    {
      if (bt.isNullOrNil(this.nnu))
      {
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bcK();
        k.g(localObject1, "VideoCore.getInstance()");
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bcM())
        {
          localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bcK();
          k.g(localObject1, "VideoCore.getInstance()");
          if (((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bcL()) {
            this.nnu = com.tencent.mm.plugin.appbrand.jsapi.video.j.bcK().getProxyUrl(this.cnm);
          }
        }
      }
      if (!bt.isNullOrNil(this.nnu))
      {
        localObject1 = this.nnr;
        if (localObject1 == null) {
          k.fvU();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).setDataSource(this.nnu);
        AppMethodBeat.o(7439);
        return;
      }
      localObject1 = this.nnr;
      if (localObject1 == null) {
        k.fvU();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).setDataSource(this.cnm);
    }
    AppMethodBeat.o(7439);
  }
  
  private final j.a getBizVideoProfiler()
  {
    AppMethodBeat.i(193377);
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.Qa(getContext().toString());
    AppMethodBeat.o(193377);
    return localObject;
  }
  
  private final void gp(final boolean paramBoolean)
  {
    AppMethodBeat.i(7444);
    this.gAC.post((Runnable)new ad(this, paramBoolean));
    AppMethodBeat.o(7444);
  }
  
  private final void onError(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(7464);
    Object localObject = z.Jhz;
    localObject = String.format("PlayError %s/%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 2));
    k.g(localObject, "java.lang.String.format(format, *args)");
    ad.w(TAG, "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.bxy += 1;
    if (this.bxy > this.nnk)
    {
      this.gAC.post((Runnable)new n(this, (String)localObject, paramInt1, paramInt2));
      AppMethodBeat.o(7464);
      return;
    }
    this.gAC.postDelayed((Runnable)new o(this), this.nnj);
    AppMethodBeat.o(7464);
  }
  
  private final void prepareAsync()
  {
    AppMethodBeat.i(7454);
    Object localObject;
    if ((this.nnr != null) && (!bt.isNullOrNil(this.cnm)))
    {
      if (bt.isNullOrNil(this.nnu))
      {
        localObject = com.tencent.mm.plugin.appbrand.jsapi.video.j.bcK();
        k.g(localObject, "VideoCore.getInstance()");
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject).bcM())
        {
          localObject = com.tencent.mm.plugin.appbrand.jsapi.video.j.bcK();
          k.g(localObject, "VideoCore.getInstance()");
          if (((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject).bcL()) {
            this.nnu = com.tencent.mm.plugin.appbrand.jsapi.video.j.bcK().getProxyUrl(this.cnm);
          }
        }
      }
      if (bt.isNullOrNil(this.nnu)) {
        break label204;
      }
      localObject = this.nnr;
      if (localObject == null) {
        k.fvU();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject).setDataSource(this.nnu);
    }
    for (;;)
    {
      ad.i(TAG, "video prepare async");
      nM(500L);
      this.cng = false;
      this.nnB = System.currentTimeMillis();
      if (this.nnr != null)
      {
        localObject = getBizVideoProfiler();
        if (localObject != null)
        {
          localObject = ((j.a)localObject).Qc("10");
          if (localObject != null)
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((em)localObject, getBizVideoProfiler());
          }
        }
        localObject = this.nnr;
        if (localObject == null) {
          k.fvU();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject).prepareAsync();
      }
      AppMethodBeat.o(7454);
      return;
      label204:
      localObject = this.nnr;
      if (localObject == null) {
        k.fvU();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject).setDataSource(this.cnm);
    }
  }
  
  private final void reset()
  {
    this.cna = false;
    this.cnb = false;
    this.cnc = false;
  }
  
  private final void setVideoTotalTime(final int paramInt)
  {
    AppMethodBeat.i(7445);
    this.gAC.post((Runnable)new y(this, paramInt));
    AppMethodBeat.o(7445);
  }
  
  private final void stopTimer()
  {
    AppMethodBeat.i(7447);
    ad.d(TAG, "stop timer");
    this.kvf.stopTimer();
    AppMethodBeat.o(7447);
  }
  
  public final boolean Ft()
  {
    AppMethodBeat.i(7457);
    this.nny = false;
    stopTimer();
    MPExoVideoTextureView localMPExoVideoTextureView = this.nnq;
    if (localMPExoVideoTextureView != null) {
      localMPExoVideoTextureView.stop();
    }
    this.kut = 0;
    if (this.nnr != null)
    {
      this.gAC.post((Runnable)new ab(this));
      AppMethodBeat.o(7457);
      return true;
    }
    AppMethodBeat.o(7457);
    return false;
  }
  
  public final void T(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(7429);
    ad.i(TAG, "prepare async");
    bGG();
    prepareAsync();
    U(paramInt, paramBoolean);
    if (paramBoolean) {
      start();
    }
    AppMethodBeat.o(7429);
  }
  
  public final void U(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(7448);
    this.nnA = paramBoolean;
    int j = getVideoDurationMs();
    int i = paramInt;
    if (j > 100)
    {
      i = paramInt;
      if (paramInt > j) {
        i = j;
      }
    }
    if ((this.cng) && (this.nnr != null))
    {
      this.cnb = bGI();
      ad.d(TAG, "seekTo mPlayingBeforeSeeking %b, afterPlay %b, seekTime %d", new Object[] { Boolean.valueOf(this.cnb), Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc;
      if (!paramBoolean)
      {
        localc = this.nnr;
        if (localc == null) {
          k.fvU();
        }
        localc.pause();
      }
      for (;;)
      {
        if ((j != i) && (i > 0)) {
          this.cno = false;
        }
        localc = this.nnr;
        if (localc == null) {
          k.fvU();
        }
        localc.j(i, paramBoolean);
        this.nnz = i;
        nM(500L);
        sm(i / 1000);
        AppMethodBeat.o(7448);
        return;
        startTimer();
      }
    }
    this.nnw = i;
    AppMethodBeat.o(7448);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(175547);
    this.bvE = paramInt1;
    this.bvI = paramFloat;
    this.ksN = paramInt2;
    this.ksO = paramInt3;
    this.ksP = paramInt4;
    this.ksQ = paramInt5;
    if ((this.bvE != 0) && (this.bvI != 0.0F) && (this.ksN != 0) && (this.ksO != 0) && (this.ksP != 0) && (this.ksQ != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.nnC = bool;
      ad.i(TAG, "setExoPlayerParam checkExoPlayerParam result = " + this.nnC);
      AppMethodBeat.o(175547);
      return;
    }
  }
  
  public final void aqt() {}
  
  public final void aqu() {}
  
  public final void aqv() {}
  
  public final void aqw() {}
  
  final void bGC()
  {
    AppMethodBeat.i(7431);
    Object localObject = this.nnm;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    if (!this.nnF)
    {
      localObject = this.nnn;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      this.nnD = false;
      AppMethodBeat.o(7431);
      return;
    }
    this.nnD = true;
    AppMethodBeat.o(7431);
  }
  
  final void bGD()
  {
    AppMethodBeat.i(7432);
    if (this.nnp != null)
    {
      localTextView = this.nnn;
      if (localTextView != null) {
        localTextView.setText((CharSequence)getContext().getString(2131761349, new Object[] { this.nnp }));
      }
      this.gAC.postDelayed((Runnable)new r(this), 1500L);
      AppMethodBeat.o(7432);
      return;
    }
    ad.w(TAG, "resolutionStr is null");
    TextView localTextView = this.nnn;
    if (localTextView != null)
    {
      localTextView.setVisibility(8);
      AppMethodBeat.o(7432);
      return;
    }
    AppMethodBeat.o(7432);
  }
  
  public final void bGE()
  {
    AppMethodBeat.i(7433);
    ad.d(TAG, "show cover");
    ImageView localImageView = this.kmV;
    if (localImageView == null) {
      k.fvU();
    }
    localImageView.setVisibility(0);
    AppMethodBeat.o(7433);
  }
  
  public final void bGF()
  {
    AppMethodBeat.i(7434);
    ad.d(TAG, "hide cover");
    ImageView localImageView = this.kmV;
    if (localImageView == null) {
      k.fvU();
    }
    localImageView.setVisibility(8);
    AppMethodBeat.o(7434);
  }
  
  public final void bGG()
  {
    AppMethodBeat.i(7437);
    reset();
    Fu();
    bGH();
    Fv();
    AppMethodBeat.o(7437);
  }
  
  public final boolean bGI()
  {
    AppMethodBeat.i(7450);
    if ((this.nny) || (isPlaying()) || (this.cnb) || (this.cna))
    {
      AppMethodBeat.o(7450);
      return true;
    }
    AppMethodBeat.o(7450);
    return false;
  }
  
  public final void cu(String paramString, int paramInt)
  {
    AppMethodBeat.i(7440);
    k.h(paramString, "_url");
    this.cnm = paramString;
    this.knG = paramInt;
    this.bqS = false;
    ad.i(TAG, "setVideoPath, media player prepare async");
    prepareAsync();
    h.Iye.f((Runnable)new x(this), "AppBrandVideo_checkVideoUrl");
    AppMethodBeat.o(7440);
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(179023);
    if (getVideoDurationSec() > 0)
    {
      int i = this.kut * getVideoDurationSec() / 100;
      AppMethodBeat.o(179023);
      return i;
    }
    AppMethodBeat.o(179023);
    return 0;
  }
  
  protected final av getCheckTimer()
  {
    return this.kvf;
  }
  
  public final ImageView getCoverIv()
  {
    AppMethodBeat.i(7430);
    ImageView localImageView = this.kmV;
    if (localImageView == null) {
      k.fvU();
    }
    AppMethodBeat.o(7430);
    return localImageView;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(7424);
    if (this.nnr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nnr;
      if (localc == null) {
        k.fvU();
      }
      int i = localc.getCurrentPosition();
      AppMethodBeat.o(7424);
      return i;
    }
    AppMethodBeat.o(7424);
    return 0;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(7425);
    if (this.nnr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nnr;
      if (localc == null) {
        k.fvU();
      }
      int i = localc.getCurrentPosition() / 1000;
      AppMethodBeat.o(7425);
      return i;
    }
    AppMethodBeat.o(7425);
    return 0;
  }
  
  protected final int getERROR_CHECK_TIME()
  {
    return this.nni;
  }
  
  protected final int getERROR_TRY_AGAIN_DELAY_TIME()
  {
    return this.nnj;
  }
  
  protected final int getERROR_TRY_MAX_TIME()
  {
    return this.nnk;
  }
  
  protected final av getErrorCheckTimer()
  {
    return this.kvh;
  }
  
  protected final int getErrorCount()
  {
    return this.bxy;
  }
  
  public final long getFirstRenderTime()
  {
    AppMethodBeat.i(177797);
    if (this.nnB != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.nnB;
      AppMethodBeat.o(177797);
      return l1 - l2;
    }
    AppMethodBeat.o(177797);
    return 0L;
  }
  
  protected final ProgressBar getLoading()
  {
    return this.kuP;
  }
  
  protected final int getMVideoSource()
  {
    return this.knr;
  }
  
  public final boolean getNeedShowSwitchTitleTextView()
  {
    return this.nnD;
  }
  
  protected final av getShowLoadingTimer()
  {
    return this.nnG;
  }
  
  protected final ap getUiHandler()
  {
    return this.gAC;
  }
  
  public final int getVideoDurationMs()
  {
    AppMethodBeat.i(7423);
    if (this.nnr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nnr;
      if (localc == null) {
        k.fvU();
      }
      i = localc.getDuration();
      AppMethodBeat.o(7423);
      return i;
    }
    int i = this.knG;
    AppMethodBeat.o(7423);
    return i * 1000;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(7422);
    if (this.nnr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nnr;
      if (localc == null) {
        k.fvU();
      }
      i = localc.getDuration() / 1000;
      AppMethodBeat.o(7422);
      return i;
    }
    int i = this.knG;
    AppMethodBeat.o(7422);
    return i;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(7428);
    if (this.nnr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nnr;
      if (localc == null) {
        k.fvU();
      }
      int i = localc.getVideoHeight();
      AppMethodBeat.o(7428);
      return i;
    }
    AppMethodBeat.o(7428);
    return 0;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(7427);
    if (this.nnr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nnr;
      if (localc == null) {
        k.fvU();
      }
      int i = localc.getVideoWidth();
      AppMethodBeat.o(7427);
      return i;
    }
    AppMethodBeat.o(7427);
    return 0;
  }
  
  protected final void hideLoading()
  {
    AppMethodBeat.i(7453);
    ad.d(TAG, "hide loading %s", new Object[] { bt.eGN() });
    this.nnG.stopTimer();
    this.gAC.post((Runnable)new l(this));
    AppMethodBeat.o(7453);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(7426);
    if ((this.nnr != null) && (this.cng))
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nnr;
      if (localc == null) {
        k.fvU();
      }
      boolean bool = localc.isPlaying();
      AppMethodBeat.o(7426);
      return bool;
    }
    AppMethodBeat.o(7426);
    return false;
  }
  
  final void nM(long paramLong)
  {
    AppMethodBeat.i(7452);
    this.nnG.stopTimer();
    this.nnG.vE(paramLong);
    AppMethodBeat.o(7452);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(7459);
    this.nnt.XF();
    setKeepScreenOn(false);
    Fu();
    pause();
    if (this.mSurface != null)
    {
      Surface localSurface = this.mSurface;
      if (localSurface == null) {
        k.fvU();
      }
      localSurface.release();
      this.mSurface = null;
    }
    stopTimer();
    this.kvh.stopTimer();
    this.gAC.removeCallbacksAndMessages(null);
    AppMethodBeat.o(7459);
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(7460);
    ad.d(TAG, "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    this.gAC.post((Runnable)new s(this));
    AppMethodBeat.o(7460);
  }
  
  public final void onVideoPlay()
  {
    AppMethodBeat.i(7461);
    this.nny = true;
    this.kuY = false;
    ad.d(TAG, "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    this.gAC.post((Runnable)new t(this));
    AppMethodBeat.o(7461);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(7456);
    this.nny = false;
    gp(false);
    stopTimer();
    if (this.nnr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nnr;
      if (localc == null) {
        k.fvU();
      }
      if (!localc.isPlaying())
      {
        ad.i(TAG, "video pause, video is not playing");
        this.cnf = false;
        AppMethodBeat.o(7456);
        return true;
      }
      if (!this.cng)
      {
        ad.i(TAG, "video pause, video not prepared yet, pause video when prepared");
        this.cnf = false;
        AppMethodBeat.o(7456);
        return true;
      }
      ad.i(TAG, "video pause");
      localc = this.nnr;
      if (localc == null) {
        k.fvU();
      }
      localc.pause();
      onVideoPause();
      AppMethodBeat.o(7456);
      return true;
    }
    AppMethodBeat.o(7456);
    return false;
  }
  
  protected final void setCheckTimer(av paramav)
  {
    AppMethodBeat.i(7421);
    k.h(paramav, "<set-?>");
    this.kvf = paramav;
    AppMethodBeat.o(7421);
  }
  
  public final void setControllerBarShowing(boolean paramBoolean)
  {
    this.nnF = paramBoolean;
  }
  
  protected final void setErrorCheckTimer(av paramav)
  {
    AppMethodBeat.i(7465);
    k.h(paramav, "<set-?>");
    this.kvh = paramav;
    AppMethodBeat.o(7465);
  }
  
  protected final void setErrorCount(int paramInt)
  {
    this.bxy = paramInt;
  }
  
  public final void setIMMVideoViewCallback(h.b paramb)
  {
    AppMethodBeat.i(7441);
    k.h(paramb, "_callback");
    this.nns = paramb;
    AppMethodBeat.o(7441);
  }
  
  public final void setKeepScreenOn(final boolean paramBoolean)
  {
    AppMethodBeat.i(7462);
    ad.d(TAG, "set keep screen on[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gAC.post((Runnable)new w(this, paramBoolean));
    AppMethodBeat.o(7462);
  }
  
  public final void setLive(boolean paramBoolean)
  {
    this.bqS = paramBoolean;
  }
  
  protected final void setLoading(ProgressBar paramProgressBar)
  {
    this.kuP = paramProgressBar;
  }
  
  protected final void setMVideoSource(int paramInt)
  {
    this.knr = paramInt;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(7458);
    this.gCJ = paramBoolean;
    if (this.nnr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nnr;
      if (localc == null) {
        k.fvU();
      }
      localc.setMute(this.gCJ);
    }
    AppMethodBeat.o(7458);
  }
  
  public final void setNeedShowSwitchTitleTextView(boolean paramBoolean)
  {
    this.nnD = paramBoolean;
  }
  
  protected final void setPlayOnUiPause(boolean paramBoolean)
  {
    this.kuY = paramBoolean;
  }
  
  protected final void setShowLoadingTimer(av paramav)
  {
    AppMethodBeat.i(7451);
    k.h(paramav, "<set-?>");
    this.nnG = paramav;
    AppMethodBeat.o(7451);
  }
  
  public final void setSwitchingResolution(boolean paramBoolean)
  {
    this.nnE = paramBoolean;
  }
  
  protected final void setUIAvailable(boolean paramBoolean)
  {
    this.kuL = paramBoolean;
  }
  
  protected final void setUiHandler(ap paramap)
  {
    AppMethodBeat.i(7420);
    k.h(paramap, "<set-?>");
    this.gAC = paramap;
    AppMethodBeat.o(7420);
  }
  
  public final void setVideoFooterView(g paramg)
  {
    AppMethodBeat.i(7442);
    k.h(paramg, "_footerView");
    this.nno = paramg;
    paramg = this.nnl;
    if (paramg == null) {
      k.fvU();
    }
    paramg.removeAllViews();
    paramg = this.nnl;
    if (paramg == null) {
      k.fvU();
    }
    paramg.addView((View)this.nno);
    AppMethodBeat.o(7442);
  }
  
  public final void setVideoSource(int paramInt)
  {
    this.knr = paramInt;
  }
  
  protected final void sm(final int paramInt)
  {
    AppMethodBeat.i(7443);
    this.gAC.post((Runnable)new ac(this, paramInt));
    AppMethodBeat.o(7443);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(7455);
    if (!this.kuL)
    {
      ad.w(TAG, "ui on pause now, why u call me to play? [%s]", new Object[] { bt.eGN() });
      AppMethodBeat.o(7455);
      return false;
    }
    if (this.mSurface == null)
    {
      ad.w(TAG, "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.kuD = true;
      this.cnf = true;
      AppMethodBeat.o(7455);
      return false;
    }
    this.nny = true;
    if (this.nnr == null)
    {
      bGG();
      prepareAsync();
    }
    if (this.nnr != null)
    {
      setKeepScreenOn(true);
      this.nnt.a((d.a)this);
      Object localObject1;
      if (this.cng)
      {
        localObject1 = this.nnr;
        if (localObject1 == null) {
          k.fvU();
        }
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).isPlaying())
        {
          ad.i(TAG, "video play, video is playing");
          onVideoPlay();
          AppMethodBeat.o(7455);
          return true;
        }
      }
      if ((this.nnr != null) && (!this.cng))
      {
        ad.i(TAG, "video play, video not prepared yet, start until prepared");
        this.cnf = true;
        AppMethodBeat.o(7455);
        return true;
      }
      if (this.nnr != null)
      {
        localObject1 = this.nnr;
        if (localObject1 == null) {
          k.fvU();
        }
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).getState() == 5)
        {
          ad.i(TAG, "video play, video has stopped now, try prepare and start when prepared");
          this.cnf = true;
          ad.i(TAG, "video play, media player prepare async");
          prepareAsync();
          AppMethodBeat.o(7455);
          return true;
        }
      }
      Object localObject2;
      if (this.cno)
      {
        ad.i(TAG, "video play, video has ended playing, clear surface and start again");
        this.cno = false;
        bGB();
        bGG();
        prepareAsync();
        if (this.nnr != null)
        {
          this.cnf = true;
          localObject1 = TAG;
          localObject2 = this.nnr;
          if (localObject2 == null) {
            k.fvU();
          }
          ad.i((String)localObject1, "video play, media player state:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject2).getState()) });
          prepareAsync();
        }
        AppMethodBeat.o(7455);
        return true;
      }
      if (this.nnr != null)
      {
        localObject1 = this.nnr;
        if (localObject1 == null) {
          k.fvU();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).start();
        localObject1 = getBizVideoProfiler();
        if (localObject1 != null)
        {
          localObject1 = ((j.a)localObject1).Qc("15");
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((em)localObject1, getBizVideoProfiler());
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
    ad.d(TAG, "start timer");
    if (!this.kvf.eFX()) {
      stopTimer();
    }
    this.kvf.vE(nnH);
    AppMethodBeat.o(7446);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
  static final class aa
    implements av.a
  {
    aa(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7416);
      this.nnK.getUiHandler().post(MPExoVideoWrapper.B(this.nnK));
      AppMethodBeat.o(7416);
      return false;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class ab
    implements Runnable
  {
    ab(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7417);
      ad.i(MPExoVideoWrapper.access$getTAG$cp(), "video stop");
      this.nnK.sm(0);
      MPExoVideoWrapper.b(this.nnK, false);
      MPExoVideoWrapper.f(this.nnK);
      this.nnK.onVideoPause();
      AppMethodBeat.o(7417);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class ac
    implements Runnable
  {
    ac(MPExoVideoWrapper paramMPExoVideoWrapper, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(7418);
      g localg = MPExoVideoWrapper.w(this.nnK);
      if (localg == null) {
        k.fvU();
      }
      localg.sa(paramInt);
      AppMethodBeat.o(7418);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class ad
    implements Runnable
  {
    ad(MPExoVideoWrapper paramMPExoVideoWrapper, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(7419);
      g localg = MPExoVideoWrapper.w(this.nnK);
      if (localg == null) {
        k.fvU();
      }
      localg.gp(paramBoolean);
      AppMethodBeat.o(7419);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7387);
      MPExoVideoTextureView localMPExoVideoTextureView = MPExoVideoWrapper.h(this.nnK);
      if (localMPExoVideoTextureView != null) {
        localMPExoVideoTextureView.setVideoSize(MPExoVideoWrapper.y(this.nnK), MPExoVideoWrapper.z(this.nnK));
      }
      localMPExoVideoTextureView = MPExoVideoWrapper.h(this.nnK);
      if (localMPExoVideoTextureView != null) {
        localMPExoVideoTextureView.bGA();
      }
      localMPExoVideoTextureView = MPExoVideoWrapper.h(this.nnK);
      if (localMPExoVideoTextureView != null)
      {
        localMPExoVideoTextureView.setScaleType(h.e.BVs);
        AppMethodBeat.o(7387);
        return;
      }
      AppMethodBeat.o(7387);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
  static final class c
    implements av.a
  {
    c(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7388);
      this.nnK.isPlaying();
      if (this.nnK.kuY)
      {
        ad.d(MPExoVideoWrapper.access$getTAG$cp(), "checkTimer onVideoPlay");
        this.nnK.onVideoPlay();
        this.nnK.setPlayOnUiPause(false);
      }
      for (;;)
      {
        AppMethodBeat.o(7388);
        return true;
        this.nnK.sm(this.nnK.getCurrPosSec());
        MPExoVideoWrapper.b(this.nnK, this.nnK.isPlaying());
        if (this.nnK.nnE) {
          MPExoVideoWrapper.n(this.nnK);
        }
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onInfo"})
  static final class d
    implements b.d
  {
    d(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean cb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(193370);
      boolean bool = MPExoVideoWrapper.a(this.nnK, paramInt1, paramInt2);
      AppMethodBeat.o(193370);
      return bool;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"})
  static final class e
    implements b.c
  {
    e(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean cc(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(193371);
      MPExoVideoWrapper.b(this.nnK, paramInt1, paramInt2);
      AppMethodBeat.o(193371);
      return false;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class f
    implements b.e
  {
    f(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(193372);
      MPExoVideoWrapper.r(this.nnK);
      if (MPExoVideoWrapper.s(this.nnK) != null)
      {
        paramb = MPExoVideoWrapper.s(this.nnK);
        if (paramb == null) {
          k.fvU();
        }
        paramb.db("", "");
      }
      AppMethodBeat.o(193372);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class g
    implements b.b
  {
    g(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void Fz()
    {
      AppMethodBeat.i(193373);
      MPExoVideoWrapper.t(this.nnK);
      AppMethodBeat.o(193373);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class h
    implements b.f
  {
    h(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void b(b paramb)
    {
      AppMethodBeat.i(193374);
      MPExoVideoWrapper.u(this.nnK);
      AppMethodBeat.o(193374);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "onVideoSizeChanged"})
  static final class i
    implements b.g
  {
    i(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void a(b paramb, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(193375);
      MPExoVideoWrapper.c(this.nnK, paramInt1, paramInt2);
      AppMethodBeat.o(193375);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "percent", "", "onBufferingUpdate"})
  static final class j
    implements b.a
  {
    j(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void gX(int paramInt)
    {
      AppMethodBeat.i(193376);
      MPExoVideoWrapper.b(this.nnK, paramInt);
      AppMethodBeat.o(193376);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
  static final class k
    implements av.a
  {
    k(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7396);
      if (this.nnK.getErrorCount() > 0)
      {
        if (this.nnK.isPlaying())
        {
          MPExoVideoWrapper.C(this.nnK);
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7397);
      if (this.nnK.getLoading() != null)
      {
        Object localObject = this.nnK.getLoading();
        if (localObject == null) {
          k.fvU();
        }
        if (((ProgressBar)localObject).getVisibility() != 8)
        {
          ad.i(MPExoVideoWrapper.access$getTAG$cp(), "hide loading");
          localObject = this.nnK.getLoading();
          if (localObject != null) {
            ((ProgressBar)localObject).setVisibility(8);
          }
          localObject = this.nnK;
          ((MPExoVideoWrapper)localObject).gAC.postDelayed((Runnable)new MPExoVideoWrapper.v((MPExoVideoWrapper)localObject), 500L);
        }
      }
      AppMethodBeat.o(7397);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-brandservice_release"})
  public static final class m
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7402);
      k.h(paramSurfaceTexture, "surface");
      ad.i(MPExoVideoWrapper.access$getTAG$cp(), "on surface texture available, width %d height %d switching %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.nnK.nnE) });
      Object localObject = MPExoVideoWrapper.g(this.nnK);
      if (localObject != null)
      {
        localObject = ((j.a)localObject).Qc("9");
        if (localObject != null)
        {
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((em)localObject, "PlayerType", "3");
          if (localObject != null)
          {
            localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((em)localObject, MPExoVideoWrapper.g(this.nnK));
          }
        }
      }
      this.nnK.startTimer();
      localObject = MPExoVideoWrapper.h(this.nnK);
      if (localObject != null) {
        ((MPExoVideoTextureView)localObject).eTg();
      }
      localObject = MPExoVideoWrapper.h(this.nnK);
      if (localObject != null) {
        ((MPExoVideoTextureView)localObject).i(MPExoVideoWrapper.b(this.nnK));
      }
      MPExoVideoWrapper.a(this.nnK, new Surface(paramSurfaceTexture));
      if ((MPExoVideoWrapper.c(this.nnK) == null) || (!MPExoVideoWrapper.d(this.nnK))) {
        if (this.nnK.nnE) {
          this.nnK.T(MPExoVideoWrapper.i(this.nnK), MPExoVideoWrapper.j(this.nnK));
        }
      }
      for (;;)
      {
        if ((!MPExoVideoWrapper.l(this.nnK)) && (this.nnK.nnE)) {
          MPExoVideoWrapper.m(this.nnK);
        }
        AppMethodBeat.o(7402);
        return;
        this.nnK.bGG();
        MPExoVideoWrapper.k(this.nnK);
        continue;
        ad.i(MPExoVideoWrapper.access$getTAG$cp(), "init, setSurface");
        paramSurfaceTexture = MPExoVideoWrapper.c(this.nnK);
        if (paramSurfaceTexture == null) {
          k.fvU();
        }
        paramSurfaceTexture.setSurface(MPExoVideoWrapper.b(this.nnK));
        if (MPExoVideoWrapper.e(this.nnK))
        {
          paramSurfaceTexture = MPExoVideoWrapper.g(this.nnK);
          if (paramSurfaceTexture != null)
          {
            paramSurfaceTexture = paramSurfaceTexture.Qc("15");
            if (paramSurfaceTexture != null)
            {
              localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.nlE;
              com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(paramSurfaceTexture, MPExoVideoWrapper.g(this.nnK));
            }
          }
          paramSurfaceTexture = MPExoVideoWrapper.c(this.nnK);
          if (paramSurfaceTexture == null) {
            k.fvU();
          }
          paramSurfaceTexture.start();
        }
        MPExoVideoWrapper.a(this.nnK, false);
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(7401);
      k.h(paramSurfaceTexture, "surface");
      ad.i(MPExoVideoWrapper.access$getTAG$cp(), "on surface texture destroyed");
      MPExoVideoWrapper.a(this.nnK, null);
      if ((MPExoVideoWrapper.c(this.nnK) != null) && (MPExoVideoWrapper.d(this.nnK))) {
        if (this.nnK.isPlaying())
        {
          MPExoVideoWrapper.a(this.nnK, true);
          paramSurfaceTexture = MPExoVideoWrapper.c(this.nnK);
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.pause();
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(7401);
        return false;
        MPExoVideoWrapper.f(this.nnK);
        MPExoVideoWrapper.a(this.nnK, false);
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7400);
      k.h(paramSurfaceTexture, "surface");
      AppMethodBeat.o(7400);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(7399);
      k.h(paramSurfaceTexture, "surface");
      if (this.nnK.getLoading() != null)
      {
        paramSurfaceTexture = this.nnK.getLoading();
        if (paramSurfaceTexture == null) {
          k.fvU();
        }
        if (paramSurfaceTexture.getVisibility() == 0) {
          this.nnK.hideLoading();
        }
      }
      if (MPExoVideoWrapper.a(this.nnK) != null)
      {
        paramSurfaceTexture = MPExoVideoWrapper.a(this.nnK);
        if (paramSurfaceTexture == null) {
          k.fvU();
        }
        if ((paramSurfaceTexture.getVisibility() == 0) && ((this.nnK.isPlaying()) || (this.nnK.getCurrPosSec() != 0))) {
          this.nnK.getUiHandler().post((Runnable)new a(this));
        }
      }
      AppMethodBeat.o(7399);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPExoVideoWrapper.m paramm) {}
      
      public final void run()
      {
        AppMethodBeat.i(7398);
        ad.d(MPExoVideoWrapper.access$getTAG$cp(), "hide cover onSurfaceTextureUpdated");
        this.nnL.nnK.bGF();
        AppMethodBeat.o(7398);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(MPExoVideoWrapper paramMPExoVideoWrapper, String paramString, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(7403);
      this.nnK.Ft();
      this.nnK.hideLoading();
      if (MPExoVideoWrapper.s(this.nnK) != null)
      {
        h.b localb = MPExoVideoWrapper.s(this.nnK);
        if (localb == null) {
          k.fvU();
        }
        localb.c("", "", this.nnM, paramInt1, paramInt2);
      }
      AppMethodBeat.o(7403);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7404);
      this.nnK.nM(500L);
      this.nnK.sm(this.nnK.getCurrPosSec());
      MPExoVideoWrapper.A(this.nnK);
      AppMethodBeat.o(7404);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7405);
      MPExoVideoWrapper.n(this.nnK);
      AppMethodBeat.o(7405);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7406);
      ImageView localImageView = MPExoVideoWrapper.o(this.nnK);
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      MPExoVideoWrapper.p(this.nnK);
      AppMethodBeat.o(7406);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7407);
      TextView localTextView = MPExoVideoWrapper.q(this.nnK);
      if (localTextView != null)
      {
        localTextView.setVisibility(8);
        AppMethodBeat.o(7407);
        return;
      }
      AppMethodBeat.o(7407);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7408);
      this.nnK.setKeepScreenOn(false);
      MPExoVideoWrapper.x(this.nnK).XF();
      if (MPExoVideoWrapper.s(this.nnK) != null)
      {
        h.b localb = MPExoVideoWrapper.s(this.nnK);
        if (localb == null) {
          k.fvU();
        }
        localb.dd("", "");
      }
      AppMethodBeat.o(7408);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7409);
      this.nnK.setKeepScreenOn(true);
      MPExoVideoWrapper.x(this.nnK).a((d.a)this.nnK);
      if (MPExoVideoWrapper.s(this.nnK) != null)
      {
        h.b localb = MPExoVideoWrapper.s(this.nnK);
        if (localb == null) {
          k.fvU();
        }
        localb.de("", "");
      }
      MPExoVideoWrapper.b(this.nnK, true);
      this.nnK.startTimer();
      AppMethodBeat.o(7409);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7410);
      if (MPExoVideoWrapper.s(this.nnK) != null)
      {
        h.b localb = MPExoVideoWrapper.s(this.nnK);
        if (localb == null) {
          k.fvU();
        }
        localb.dg("", "");
      }
      AppMethodBeat.o(7410);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class v
    implements Runnable
  {
    v(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7411);
      if (MPExoVideoWrapper.s(this.nnK) != null)
      {
        h.b localb = MPExoVideoWrapper.s(this.nnK);
        if (localb == null) {
          k.fvU();
        }
        localb.dh("", "");
      }
      AppMethodBeat.o(7411);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class w
    implements Runnable
  {
    w(MPExoVideoWrapper paramMPExoVideoWrapper, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(7412);
      MPExoVideoWrapper.c(this.nnK, paramBoolean);
      AppMethodBeat.o(7412);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class x
    implements Runnable
  {
    x(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7413);
      MPExoVideoWrapper.v(this.nnK);
      AppMethodBeat.o(7413);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class y
    implements Runnable
  {
    y(MPExoVideoWrapper paramMPExoVideoWrapper, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(7414);
      if (MPExoVideoWrapper.w(this.nnK) != null)
      {
        g localg = MPExoVideoWrapper.w(this.nnK);
        if (localg == null) {
          k.fvU();
        }
        if (localg.getVideoTotalTime() != paramInt)
        {
          localg = MPExoVideoWrapper.w(this.nnK);
          if (localg == null) {
            k.fvU();
          }
          localg.setVideoTotalTime(paramInt);
        }
      }
      AppMethodBeat.o(7414);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class z
    implements Runnable
  {
    z(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7415);
      if (this.nnK.getLoading() != null)
      {
        Object localObject = this.nnK.getLoading();
        if (localObject == null) {
          k.fvU();
        }
        if (((ProgressBar)localObject).getVisibility() != 0)
        {
          ad.i(MPExoVideoWrapper.access$getTAG$cp(), "show loading");
          localObject = this.nnK.getLoading();
          if (localObject != null) {
            ((ProgressBar)localObject).setVisibility(0);
          }
          localObject = this.nnK;
          ((MPExoVideoWrapper)localObject).gAC.post((Runnable)new MPExoVideoWrapper.u((MPExoVideoWrapper)localObject));
        }
      }
      AppMethodBeat.o(7415);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper
 * JD-Core Version:    0.7.0.1
 */