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
import com.tencent.mm.plugin.appbrand.jsapi.video.n;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.util.Arrays;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ERROR_CHECK_TIME", "", "getERROR_CHECK_TIME", "()I", "ERROR_TRY_AGAIN_DELAY_TIME", "getERROR_TRY_AGAIN_DELAY_TIME", "ERROR_TRY_MAX_TIME", "getERROR_TRY_MAX_TIME", "bandwidthFraction", "", "bizVideoProfiler", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "getBizVideoProfiler", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "cacheTimeSec", "getCacheTimeSec", "callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getCheckTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "setCheckTimer", "(Lcom/tencent/mm/sdk/platformtools/MTimerHandler;)V", "currPosMs", "getCurrPosMs", "currPosSec", "getCurrPosSec", "downloadPercent", "durationSec", "errorCheckTimer", "getErrorCheckTimer", "setErrorCheckTimer", "errorCount", "getErrorCount", "setErrorCount", "(I)V", "footerView", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoFooter;", "hasExoParam", "", "inBackGround", "isControllerBarShowing", "()Z", "setControllerBarShowing", "(Z)V", "isInFullScreen", "isLive", "setLive", "isPlayOnUiPause", "setPlayOnUiPause", "isPlaying", "isSwitchingResolution", "setSwitchingResolution", "isUIAvailable", "setUIAvailable", "lastSeekAutoPlay", "lastSeekTime", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "localIsPlaying", "mAudioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "mCoverIv", "Landroid/widget/ImageView;", "mFirstRenderStartTime", "", "mFooterContainer", "Landroid/widget/LinearLayout;", "mLastUpdateBuffer", "mMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/ExoMediaPlayer;", "mMediaPlayerAvailable", "mPlayingBeforeBuffering", "mPlayingBeforeSeeking", "mPlayingWhenBackground", "mStartSeekPosition", "mStartWhenPrepared", "mStartWhenSeekCompleted", "mSurface", "Landroid/view/Surface;", "mSwitchCoverIv", "mSwitchTitleTextView", "Landroid/widget/TextView;", "mVideoDuration", "mVideoHasEndedPlaying", "mVideoHasPrepared", "mVideoHeight", "mVideoLooping", "mVideoPath", "", "mVideoProxyUrl", "mVideoSource", "getMVideoSource", "setMVideoSource", "mVideoTextureView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoTextureView;", "mVideoWidth", "maxBufferMs", "maxDurForQualityMs", "maxInitialBitrate", "minBufferMs", "minDurForQualityMs", "mute", "needShowSwitchTitleTextView", "getNeedShowSwitchTitleTextView", "setNeedShowSwitchTitleTextView", "pauseByDestroyed", "resolutionStr", "showLoadingRunning", "Ljava/lang/Runnable;", "showLoadingTimer", "getShowLoadingTimer", "setShowLoadingTimer", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setUiHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "videoDurationMs", "getVideoDurationMs", "videoDurationSec", "getVideoDurationSec", "videoHeight", "getVideoHeight", "videoWidth", "getVideoWidth", "adjustObjectFit", "", "applyMediaPlayerParams", "checkExoPlayerParam", "checkVideoUrl", "clearSurface", "createMediaPlayer", "enterFullScreen", "gain", "getCoverIv", "getFirstRenderTime", "hideCover", "hideLoading", "init", "isNeedToPlay", "isShowingLoading", "isSwitchTitleTextViewShowing", "loss", "lossTransient", "lossTransientCanDuck", "onControllerBarVisible", "visible", "onError", "what", "extra", "onMediaPlayerBufferingUpdate", "percent", "onMediaPlayerCompletion", "onMediaPlayerInfo", "onMediaPlayerPrepared", "onMediaPlayerSeekComplete", "onMediaPlayerVideoSizeChanged", "width", "height", "onPlayDoSwitchEnd", "onSeekEnd", "onSetResolution", "onSwitchEnd", "onSwitchEndShowSuccessWording", "onUIDestroy", "onUIPause", "onUIResume", "onVideoLoadedMetaData", "duration", "onVideoPause", "onVideoPlay", "onVideoProgress", "onVideoWaiting", "onVideoWaitingEnd", "pause", "prepareAsync", "quitFullScreen", "releaseMediaPlayer", "releaseSurface", "reset", "resetErrorCount", "resetMediaPlayer", "resetResolutionStatus", "restartVideo", "seekPosition", "play", "retryWhenError", "seekTo", "ms", "afterPlay", "setExoPlayerParam", "setIMMVideoViewCallback", "_callback", "setKeepScreenOn", "keepScreenOn", "setMute", "_mute", "setSwitchSpeedCover", "setVideoFooterView", "_footerView", "setVideoPath", "_isLive", "_url", "_durationSec", "setVideoSource", "videoSource", "setVideoTotalTime", "seconds", "showCover", "showLoading", "showLoadingDelayed", "delayMillis", "start", "startErrorCheckTimer", "startTimer", "stop", "stopErrorCheckTimer", "stopTimer", "tryPreloadVideo", "unKown", "updateUI", "currPlaySec", "updateVideoStatus", "isPlay", "Companion", "plugin-brandservice_release"})
public final class MPExoVideoWrapper
  extends RelativeLayout
  implements d.a
{
  public static final String TAG = "MicroMsg.MPExoVideoWrapper";
  private static final int nQH = 500;
  private static final int nQI = 0;
  public static final MPExoVideoWrapper.a nQJ;
  boolean bps;
  private int btD;
  private float btH;
  private int bvh;
  private boolean ckc;
  private boolean ckd;
  private boolean cke;
  private boolean ckh;
  public boolean cki;
  private boolean ckj;
  private final boolean ckk;
  private int ckm;
  private int ckn;
  private String cko;
  private boolean ckq;
  ao gox;
  private boolean hdh;
  boolean jim;
  private int kOJ;
  private ImageView kOn;
  private int kPa;
  private int kUd;
  private int kUe;
  private int kUf;
  private int kUg;
  private int kVI;
  private boolean kVS;
  public boolean kWa;
  public ProgressBar kWd;
  public boolean kWm;
  private au kWt;
  private au kWv;
  private final Runnable kWy;
  private Surface mSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  private boolean nQA;
  private long nQB;
  private boolean nQC;
  boolean nQD;
  boolean nQE;
  boolean nQF;
  private au nQG;
  private final int nQi;
  private final int nQj;
  private final int nQk;
  private LinearLayout nQl;
  ImageView nQm;
  TextView nQn;
  private g nQo;
  String nQp;
  MPExoVideoTextureView nQq;
  public com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c nQr;
  private h.b nQs;
  public final d nQt;
  private String nQu;
  public boolean nQv;
  private int nQw;
  public boolean nQx;
  private boolean nQy;
  private int nQz;
  
  static
  {
    AppMethodBeat.i(7467);
    nQJ = new MPExoVideoWrapper.a((byte)0);
    TAG = "MicroMsg.MPExoVideoWrapper";
    nQH = 500;
    AppMethodBeat.o(7467);
  }
  
  public MPExoVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7466);
    this.nQi = 5000;
    this.nQj = 200;
    this.nQk = 5;
    this.gox = new ao(Looper.getMainLooper());
    paramContext = d.axh();
    k.g(paramContext, "AudioHelperTool.createTool()");
    this.nQt = paramContext;
    this.kOJ = nQI;
    this.kWa = true;
    this.btD = 800000;
    this.btH = 0.75F;
    this.kUd = 10000;
    this.kUe = 25000;
    this.kUf = 15000;
    this.kUg = 30000;
    this.kWt = new au((au.a)new c(this), true);
    LayoutInflater.from(getContext()).inflate(2131494956, (ViewGroup)this);
    this.nQq = ((MPExoVideoTextureView)findViewById(2131302512));
    this.kWd = ((ProgressBar)findViewById(2131306352));
    this.nQl = ((LinearLayout)findViewById(2131306342));
    this.kOn = ((ImageView)findViewById(2131302505));
    this.nQm = ((ImageView)findViewById(2131302511));
    this.nQn = ((TextView)findViewById(2131305584));
    paramContext = this.nQq;
    if (paramContext == null) {
      k.fOy();
    }
    paramContext.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new m(this));
    this.kWy = ((Runnable)new z(this));
    this.nQG = new au((au.a)new aa(this), false);
    this.kWv = new au((au.a)new k(this), true);
    AppMethodBeat.o(7466);
  }
  
  private final void EZ()
  {
    AppMethodBeat.i(7463);
    this.gox.post((Runnable)new MPExoVideoWrapper.b(this));
    AppMethodBeat.o(7463);
  }
  
  private final void Fc()
  {
    try
    {
      AppMethodBeat.i(7435);
      if (this.nQr != null)
      {
        ac.i(TAG, "releaseMediaPlayer");
        com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nQr;
        if (localc == null) {
          k.fOy();
        }
        localc.a(null);
        localc = this.nQr;
        if (localc == null) {
          k.fOy();
        }
        localc.a(null);
        localc = this.nQr;
        if (localc == null) {
          k.fOy();
        }
        localc.a(null);
        localc = this.nQr;
        if (localc == null) {
          k.fOy();
        }
        localc.a(null);
        localc = this.nQr;
        if (localc == null) {
          k.fOy();
        }
        localc.a(null);
        localc = this.nQr;
        if (localc == null) {
          k.fOy();
        }
        localc.a(null);
        localc = this.nQr;
        if (localc == null) {
          k.fOy();
        }
        localc.stop();
        localc = this.nQr;
        if (localc == null) {
          k.fOy();
        }
        localc.reset();
        localc = this.nQr;
        if (localc == null) {
          k.fOy();
        }
        localc.release();
      }
      this.nQr = null;
      this.ckj = false;
      AppMethodBeat.o(7435);
      return;
    }
    finally {}
  }
  
  private final void Fd()
  {
    AppMethodBeat.i(7438);
    if (this.nQr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nQr;
      if (localc == null) {
        k.fOy();
      }
      localc.setMute(this.hdh);
      if (this.mSurface != null)
      {
        localc = this.nQr;
        if (localc == null) {
          k.fOy();
        }
        localc.setSurface(this.mSurface);
      }
    }
    AppMethodBeat.o(7438);
  }
  
  private final void bNO()
  {
    AppMethodBeat.i(7436);
    if ((this.mSurface != null) && (this.cki))
    {
      MPExoVideoTextureView localMPExoVideoTextureView = this.nQq;
      if (localMPExoVideoTextureView != null)
      {
        localMPExoVideoTextureView.bNO();
        AppMethodBeat.o(7436);
        return;
      }
    }
    AppMethodBeat.o(7436);
  }
  
  private final void bNU()
  {
    AppMethodBeat.i(7439);
    if (this.nQr != null)
    {
      AppMethodBeat.o(7439);
      return;
    }
    ac.i(TAG, "createMediaPlayer");
    this.kVI = 0;
    float f;
    if (this.nQC)
    {
      localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c(this.btD, this.btH, this.kUd, this.kUe, this.kUf, this.kUg);
      this.nQr = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1);
      localObject1 = this.nQr;
      if (localObject1 == null) {
        k.fOy();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).setLooping(this.ckk);
      localObject1 = this.nQr;
      if (localObject1 == null) {
        k.fOy();
      }
      Object localObject2 = c.nQW;
      localObject2 = c.bNX();
      if (localObject2 == null) {
        break label185;
      }
      f = ((c.a)localObject2).nRd;
      label131:
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).aC(f);
      if (this.nQr == null) {
        break label190;
      }
    }
    label185:
    label190:
    for (boolean bool = true;; bool = false)
    {
      this.ckj = bool;
      if (this.ckj) {
        break label195;
      }
      ac.e(TAG, "createMediaPlayer, create media player fail");
      AppMethodBeat.o(7439);
      return;
      localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c();
      break;
      f = 1.0F;
      break label131;
    }
    label195:
    Object localObject1 = this.nQr;
    if (localObject1 == null) {
      k.fOy();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).a((b.d)new d(this));
    localObject1 = this.nQr;
    if (localObject1 == null) {
      k.fOy();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).a((b.c)new e(this));
    localObject1 = this.nQr;
    if (localObject1 == null) {
      k.fOy();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).a((b.e)new f(this));
    localObject1 = this.nQr;
    if (localObject1 == null) {
      k.fOy();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).a((b.b)new g(this));
    localObject1 = this.nQr;
    if (localObject1 == null) {
      k.fOy();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).a((b.f)new h(this));
    localObject1 = this.nQr;
    if (localObject1 == null) {
      k.fOy();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).a((b.g)new i(this));
    localObject1 = this.nQr;
    if (localObject1 == null) {
      k.fOy();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).a((b.a)new j(this));
    if (!bs.isNullOrNil(this.cko))
    {
      if (bs.isNullOrNil(this.nQu))
      {
        localObject1 = n.bjG();
        k.g(localObject1, "VideoCore.getInstance()");
        if (((n)localObject1).bjI())
        {
          localObject1 = n.bjG();
          k.g(localObject1, "VideoCore.getInstance()");
          if (((n)localObject1).bjH()) {
            this.nQu = n.bjG().getProxyUrl(this.cko);
          }
        }
      }
      if (!bs.isNullOrNil(this.nQu))
      {
        localObject1 = this.nQr;
        if (localObject1 == null) {
          k.fOy();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).setDataSource(this.nQu);
        AppMethodBeat.o(7439);
        return;
      }
      localObject1 = this.nQr;
      if (localObject1 == null) {
        k.fOy();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).setDataSource(this.cko);
    }
    AppMethodBeat.o(7439);
  }
  
  private final void gL(final boolean paramBoolean)
  {
    AppMethodBeat.i(7444);
    this.gox.post((Runnable)new ad(this, paramBoolean));
    AppMethodBeat.o(7444);
  }
  
  private final j.a getBizVideoProfiler()
  {
    AppMethodBeat.i(199190);
    Object localObject = j.nOE;
    localObject = j.Um(getContext().toString());
    AppMethodBeat.o(199190);
    return localObject;
  }
  
  private final void onError(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(7464);
    Object localObject = z.KUT;
    localObject = String.format("PlayError %s/%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 2));
    k.g(localObject, "java.lang.String.format(format, *args)");
    ac.w(TAG, "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.bvh += 1;
    if (this.bvh > this.nQk)
    {
      this.gox.post((Runnable)new n(this, (String)localObject, paramInt1, paramInt2));
      AppMethodBeat.o(7464);
      return;
    }
    this.gox.postDelayed((Runnable)new o(this), this.nQj);
    AppMethodBeat.o(7464);
  }
  
  private final void prepareAsync()
  {
    AppMethodBeat.i(7454);
    Object localObject;
    if ((this.nQr != null) && (!bs.isNullOrNil(this.cko)))
    {
      if (bs.isNullOrNil(this.nQu))
      {
        localObject = n.bjG();
        k.g(localObject, "VideoCore.getInstance()");
        if (((n)localObject).bjI())
        {
          localObject = n.bjG();
          k.g(localObject, "VideoCore.getInstance()");
          if (((n)localObject).bjH()) {
            this.nQu = n.bjG().getProxyUrl(this.cko);
          }
        }
      }
      if (bs.isNullOrNil(this.nQu)) {
        break label204;
      }
      localObject = this.nQr;
      if (localObject == null) {
        k.fOy();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject).setDataSource(this.nQu);
    }
    for (;;)
    {
      ac.i(TAG, "video prepare async");
      ry(500L);
      this.cki = false;
      this.nQB = System.currentTimeMillis();
      if (this.nQr != null)
      {
        localObject = getBizVideoProfiler();
        if (localObject != null)
        {
          localObject = ((j.a)localObject).Uo("10");
          if (localObject != null)
          {
            j localj = j.nOE;
            j.a((eo)localObject, getBizVideoProfiler());
          }
        }
        localObject = this.nQr;
        if (localObject == null) {
          k.fOy();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject).prepareAsync();
      }
      AppMethodBeat.o(7454);
      return;
      label204:
      localObject = this.nQr;
      if (localObject == null) {
        k.fOy();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject).setDataSource(this.cko);
    }
  }
  
  private final void reset()
  {
    this.ckc = false;
    this.ckd = false;
    this.cke = false;
  }
  
  private final void setVideoTotalTime(final int paramInt)
  {
    AppMethodBeat.i(7445);
    this.gox.post((Runnable)new y(this, paramInt));
    AppMethodBeat.o(7445);
  }
  
  private final void stopTimer()
  {
    AppMethodBeat.i(7447);
    ac.d(TAG, "stop timer");
    this.kWt.stopTimer();
    AppMethodBeat.o(7447);
  }
  
  public final boolean Fb()
  {
    AppMethodBeat.i(7457);
    this.nQy = false;
    stopTimer();
    MPExoVideoTextureView localMPExoVideoTextureView = this.nQq;
    if (localMPExoVideoTextureView != null) {
      localMPExoVideoTextureView.stop();
    }
    this.kVI = 0;
    if (this.nQr != null)
    {
      this.gox.post((Runnable)new ab(this));
      AppMethodBeat.o(7457);
      return true;
    }
    AppMethodBeat.o(7457);
    return false;
  }
  
  public final void T(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(7429);
    ac.i(TAG, "prepare async");
    bNT();
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
    this.nQA = paramBoolean;
    int j = getVideoDurationMs();
    int i = paramInt;
    if (j > 100)
    {
      i = paramInt;
      if (paramInt > j) {
        i = j;
      }
    }
    if ((this.cki) && (this.nQr != null))
    {
      this.ckd = bNV();
      ac.d(TAG, "seekTo mPlayingBeforeSeeking %b, afterPlay %b, seekTime %d", new Object[] { Boolean.valueOf(this.ckd), Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc;
      if (!paramBoolean)
      {
        localc = this.nQr;
        if (localc == null) {
          k.fOy();
        }
        localc.pause();
      }
      for (;;)
      {
        if ((j != i) && (i > 0)) {
          this.ckq = false;
        }
        localc = this.nQr;
        if (localc == null) {
          k.fOy();
        }
        localc.k(i, paramBoolean);
        this.nQz = i;
        ry(500L);
        tc(i / 1000);
        AppMethodBeat.o(7448);
        return;
        startTimer();
      }
    }
    this.nQw = i;
    AppMethodBeat.o(7448);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(175547);
    this.btD = paramInt1;
    this.btH = paramFloat;
    this.kUd = paramInt2;
    this.kUe = paramInt3;
    this.kUf = paramInt4;
    this.kUg = paramInt5;
    if ((this.btD != 0) && (this.btH != 0.0F) && (this.kUd != 0) && (this.kUe != 0) && (this.kUf != 0) && (this.kUg != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.nQC = bool;
      ac.i(TAG, "setExoPlayerParam checkExoPlayerParam result = " + this.nQC);
      AppMethodBeat.o(175547);
      return;
    }
  }
  
  public final void axj() {}
  
  public final void axk() {}
  
  public final void axl() {}
  
  public final void axm() {}
  
  final void bNP()
  {
    AppMethodBeat.i(7431);
    Object localObject = this.nQm;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    if (!this.nQF)
    {
      localObject = this.nQn;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      this.nQD = false;
      AppMethodBeat.o(7431);
      return;
    }
    this.nQD = true;
    AppMethodBeat.o(7431);
  }
  
  final void bNQ()
  {
    AppMethodBeat.i(7432);
    if (this.nQp != null)
    {
      localTextView = this.nQn;
      if (localTextView != null) {
        localTextView.setText((CharSequence)getContext().getString(2131761349, new Object[] { this.nQp }));
      }
      this.gox.postDelayed((Runnable)new r(this), 1500L);
      AppMethodBeat.o(7432);
      return;
    }
    ac.w(TAG, "resolutionStr is null");
    TextView localTextView = this.nQn;
    if (localTextView != null)
    {
      localTextView.setVisibility(8);
      AppMethodBeat.o(7432);
      return;
    }
    AppMethodBeat.o(7432);
  }
  
  public final void bNR()
  {
    AppMethodBeat.i(7433);
    ac.d(TAG, "show cover");
    ImageView localImageView = this.kOn;
    if (localImageView == null) {
      k.fOy();
    }
    localImageView.setVisibility(0);
    AppMethodBeat.o(7433);
  }
  
  public final void bNS()
  {
    AppMethodBeat.i(7434);
    ac.d(TAG, "hide cover");
    ImageView localImageView = this.kOn;
    if (localImageView == null) {
      k.fOy();
    }
    localImageView.setVisibility(8);
    AppMethodBeat.o(7434);
  }
  
  public final void bNT()
  {
    AppMethodBeat.i(7437);
    reset();
    Fc();
    bNU();
    Fd();
    AppMethodBeat.o(7437);
  }
  
  public final boolean bNV()
  {
    AppMethodBeat.i(7450);
    if ((this.nQy) || (isPlaying()) || (this.ckd) || (this.ckc))
    {
      AppMethodBeat.o(7450);
      return true;
    }
    AppMethodBeat.o(7450);
    return false;
  }
  
  public final void cz(String paramString, int paramInt)
  {
    AppMethodBeat.i(7440);
    k.h(paramString, "_url");
    this.cko = paramString;
    this.kPa = paramInt;
    this.bps = false;
    ac.i(TAG, "setVideoPath, media player prepare async");
    prepareAsync();
    h.JZN.f((Runnable)new x(this), "AppBrandVideo_checkVideoUrl");
    AppMethodBeat.o(7440);
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(179023);
    if (getVideoDurationSec() > 0)
    {
      int i = this.kVI * getVideoDurationSec() / 100;
      AppMethodBeat.o(179023);
      return i;
    }
    AppMethodBeat.o(179023);
    return 0;
  }
  
  protected final au getCheckTimer()
  {
    return this.kWt;
  }
  
  public final ImageView getCoverIv()
  {
    AppMethodBeat.i(7430);
    ImageView localImageView = this.kOn;
    if (localImageView == null) {
      k.fOy();
    }
    AppMethodBeat.o(7430);
    return localImageView;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(7424);
    if (this.nQr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nQr;
      if (localc == null) {
        k.fOy();
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
    if (this.nQr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nQr;
      if (localc == null) {
        k.fOy();
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
    return this.nQi;
  }
  
  protected final int getERROR_TRY_AGAIN_DELAY_TIME()
  {
    return this.nQj;
  }
  
  protected final int getERROR_TRY_MAX_TIME()
  {
    return this.nQk;
  }
  
  protected final au getErrorCheckTimer()
  {
    return this.kWv;
  }
  
  protected final int getErrorCount()
  {
    return this.bvh;
  }
  
  public final long getFirstRenderTime()
  {
    AppMethodBeat.i(177797);
    if (this.nQB != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.nQB;
      AppMethodBeat.o(177797);
      return l1 - l2;
    }
    AppMethodBeat.o(177797);
    return 0L;
  }
  
  protected final ProgressBar getLoading()
  {
    return this.kWd;
  }
  
  protected final int getMVideoSource()
  {
    return this.kOJ;
  }
  
  public final boolean getNeedShowSwitchTitleTextView()
  {
    return this.nQD;
  }
  
  protected final au getShowLoadingTimer()
  {
    return this.nQG;
  }
  
  protected final ao getUiHandler()
  {
    return this.gox;
  }
  
  public final int getVideoDurationMs()
  {
    AppMethodBeat.i(7423);
    if (this.nQr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nQr;
      if (localc == null) {
        k.fOy();
      }
      i = localc.getDuration();
      AppMethodBeat.o(7423);
      return i;
    }
    int i = this.kPa;
    AppMethodBeat.o(7423);
    return i * 1000;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(7422);
    if (this.nQr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nQr;
      if (localc == null) {
        k.fOy();
      }
      i = localc.getDuration() / 1000;
      AppMethodBeat.o(7422);
      return i;
    }
    int i = this.kPa;
    AppMethodBeat.o(7422);
    return i;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(7428);
    if (this.nQr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nQr;
      if (localc == null) {
        k.fOy();
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
    if (this.nQr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nQr;
      if (localc == null) {
        k.fOy();
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
    ac.d(TAG, "hide loading %s", new Object[] { bs.eWi() });
    this.nQG.stopTimer();
    this.gox.post((Runnable)new l(this));
    AppMethodBeat.o(7453);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(7426);
    if ((this.nQr != null) && (this.cki))
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nQr;
      if (localc == null) {
        k.fOy();
      }
      boolean bool = localc.isPlaying();
      AppMethodBeat.o(7426);
      return bool;
    }
    AppMethodBeat.o(7426);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(7459);
    this.nQt.YC();
    setKeepScreenOn(false);
    Fc();
    pause();
    if (this.mSurface != null)
    {
      Surface localSurface = this.mSurface;
      if (localSurface == null) {
        k.fOy();
      }
      localSurface.release();
      this.mSurface = null;
    }
    stopTimer();
    this.kWv.stopTimer();
    this.gox.removeCallbacksAndMessages(null);
    AppMethodBeat.o(7459);
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(7460);
    ac.d(TAG, "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    this.gox.post((Runnable)new s(this));
    AppMethodBeat.o(7460);
  }
  
  public final void onVideoPlay()
  {
    AppMethodBeat.i(7461);
    this.nQy = true;
    this.kWm = false;
    ac.d(TAG, "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    this.gox.post((Runnable)new t(this));
    AppMethodBeat.o(7461);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(7456);
    this.nQy = false;
    gL(false);
    stopTimer();
    if (this.nQr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nQr;
      if (localc == null) {
        k.fOy();
      }
      if (!localc.isPlaying())
      {
        ac.i(TAG, "video pause, video is not playing");
        this.ckh = false;
        AppMethodBeat.o(7456);
        return true;
      }
      if (!this.cki)
      {
        ac.i(TAG, "video pause, video not prepared yet, pause video when prepared");
        this.ckh = false;
        AppMethodBeat.o(7456);
        return true;
      }
      ac.i(TAG, "video pause");
      localc = this.nQr;
      if (localc == null) {
        k.fOy();
      }
      localc.pause();
      onVideoPause();
      AppMethodBeat.o(7456);
      return true;
    }
    AppMethodBeat.o(7456);
    return false;
  }
  
  final void ry(long paramLong)
  {
    AppMethodBeat.i(7452);
    this.nQG.stopTimer();
    this.nQG.Ah(paramLong);
    AppMethodBeat.o(7452);
  }
  
  protected final void setCheckTimer(au paramau)
  {
    AppMethodBeat.i(7421);
    k.h(paramau, "<set-?>");
    this.kWt = paramau;
    AppMethodBeat.o(7421);
  }
  
  public final void setControllerBarShowing(boolean paramBoolean)
  {
    this.nQF = paramBoolean;
  }
  
  protected final void setErrorCheckTimer(au paramau)
  {
    AppMethodBeat.i(7465);
    k.h(paramau, "<set-?>");
    this.kWv = paramau;
    AppMethodBeat.o(7465);
  }
  
  protected final void setErrorCount(int paramInt)
  {
    this.bvh = paramInt;
  }
  
  public final void setIMMVideoViewCallback(h.b paramb)
  {
    AppMethodBeat.i(7441);
    k.h(paramb, "_callback");
    this.nQs = paramb;
    AppMethodBeat.o(7441);
  }
  
  public final void setKeepScreenOn(final boolean paramBoolean)
  {
    AppMethodBeat.i(7462);
    ac.d(TAG, "set keep screen on[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gox.post((Runnable)new w(this, paramBoolean));
    AppMethodBeat.o(7462);
  }
  
  public final void setLive(boolean paramBoolean)
  {
    this.bps = paramBoolean;
  }
  
  protected final void setLoading(ProgressBar paramProgressBar)
  {
    this.kWd = paramProgressBar;
  }
  
  protected final void setMVideoSource(int paramInt)
  {
    this.kOJ = paramInt;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(7458);
    this.hdh = paramBoolean;
    if (this.nQr != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c localc = this.nQr;
      if (localc == null) {
        k.fOy();
      }
      localc.setMute(this.hdh);
    }
    AppMethodBeat.o(7458);
  }
  
  public final void setNeedShowSwitchTitleTextView(boolean paramBoolean)
  {
    this.nQD = paramBoolean;
  }
  
  protected final void setPlayOnUiPause(boolean paramBoolean)
  {
    this.kWm = paramBoolean;
  }
  
  protected final void setShowLoadingTimer(au paramau)
  {
    AppMethodBeat.i(7451);
    k.h(paramau, "<set-?>");
    this.nQG = paramau;
    AppMethodBeat.o(7451);
  }
  
  public final void setSwitchingResolution(boolean paramBoolean)
  {
    this.nQE = paramBoolean;
  }
  
  protected final void setUIAvailable(boolean paramBoolean)
  {
    this.kWa = paramBoolean;
  }
  
  protected final void setUiHandler(ao paramao)
  {
    AppMethodBeat.i(7420);
    k.h(paramao, "<set-?>");
    this.gox = paramao;
    AppMethodBeat.o(7420);
  }
  
  public final void setVideoFooterView(g paramg)
  {
    AppMethodBeat.i(7442);
    k.h(paramg, "_footerView");
    this.nQo = paramg;
    paramg = this.nQl;
    if (paramg == null) {
      k.fOy();
    }
    paramg.removeAllViews();
    paramg = this.nQl;
    if (paramg == null) {
      k.fOy();
    }
    paramg.addView((View)this.nQo);
    AppMethodBeat.o(7442);
  }
  
  public final void setVideoSource(int paramInt)
  {
    this.kOJ = paramInt;
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(7455);
    if (!this.kWa)
    {
      ac.w(TAG, "ui on pause now, why u call me to play? [%s]", new Object[] { bs.eWi() });
      AppMethodBeat.o(7455);
      return false;
    }
    if (this.mSurface == null)
    {
      ac.w(TAG, "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.kVS = true;
      this.ckh = true;
      AppMethodBeat.o(7455);
      return false;
    }
    this.nQy = true;
    if (this.nQr == null)
    {
      bNT();
      prepareAsync();
    }
    if (this.nQr != null)
    {
      setKeepScreenOn(true);
      this.nQt.a((d.a)this);
      Object localObject1;
      if (this.cki)
      {
        localObject1 = this.nQr;
        if (localObject1 == null) {
          k.fOy();
        }
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).isPlaying())
        {
          ac.i(TAG, "video play, video is playing");
          onVideoPlay();
          AppMethodBeat.o(7455);
          return true;
        }
      }
      if ((this.nQr != null) && (!this.cki))
      {
        ac.i(TAG, "video play, video not prepared yet, start until prepared");
        this.ckh = true;
        AppMethodBeat.o(7455);
        return true;
      }
      if (this.nQr != null)
      {
        localObject1 = this.nQr;
        if (localObject1 == null) {
          k.fOy();
        }
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).getState() == 5)
        {
          ac.i(TAG, "video play, video has stopped now, try prepare and start when prepared");
          this.ckh = true;
          ac.i(TAG, "video play, media player prepare async");
          prepareAsync();
          AppMethodBeat.o(7455);
          return true;
        }
      }
      Object localObject2;
      if (this.ckq)
      {
        ac.i(TAG, "video play, video has ended playing, clear surface and start again");
        this.ckq = false;
        bNO();
        bNT();
        prepareAsync();
        if (this.nQr != null)
        {
          this.ckh = true;
          localObject1 = TAG;
          localObject2 = this.nQr;
          if (localObject2 == null) {
            k.fOy();
          }
          ac.i((String)localObject1, "video play, media player state:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject2).getState()) });
          prepareAsync();
        }
        AppMethodBeat.o(7455);
        return true;
      }
      if (this.nQr != null)
      {
        localObject1 = this.nQr;
        if (localObject1 == null) {
          k.fOy();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.a.c)localObject1).start();
        localObject1 = getBizVideoProfiler();
        if (localObject1 != null)
        {
          localObject1 = ((j.a)localObject1).Uo("15");
          if (localObject1 != null)
          {
            localObject2 = j.nOE;
            j.a((eo)localObject1, getBizVideoProfiler());
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
    ac.d(TAG, "start timer");
    if (!this.kWt.eVs()) {
      stopTimer();
    }
    this.kWt.Ah(nQH);
    AppMethodBeat.o(7446);
  }
  
  protected final void tc(final int paramInt)
  {
    AppMethodBeat.i(7443);
    this.gox.post((Runnable)new ac(this, paramInt));
    AppMethodBeat.o(7443);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class aa
    implements au.a
  {
    aa(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7416);
      this.nQK.getUiHandler().post(MPExoVideoWrapper.B(this.nQK));
      AppMethodBeat.o(7416);
      return false;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class ab
    implements Runnable
  {
    ab(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7417);
      ac.i(MPExoVideoWrapper.access$getTAG$cp(), "video stop");
      this.nQK.tc(0);
      MPExoVideoWrapper.b(this.nQK, false);
      MPExoVideoWrapper.f(this.nQK);
      this.nQK.onVideoPause();
      AppMethodBeat.o(7417);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class ac
    implements Runnable
  {
    ac(MPExoVideoWrapper paramMPExoVideoWrapper, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(7418);
      g localg = MPExoVideoWrapper.w(this.nQK);
      if (localg == null) {
        k.fOy();
      }
      localg.sQ(paramInt);
      AppMethodBeat.o(7418);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class ad
    implements Runnable
  {
    ad(MPExoVideoWrapper paramMPExoVideoWrapper, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(7419);
      g localg = MPExoVideoWrapper.w(this.nQK);
      if (localg == null) {
        k.fOy();
      }
      localg.gL(paramBoolean);
      AppMethodBeat.o(7419);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class ae
    implements Runnable
  {
    ae(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(210008);
      if (this.nQK.nQE) {
        MPExoVideoWrapper.n(this.nQK);
      }
      AppMethodBeat.o(210008);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class c
    implements au.a
  {
    c(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7388);
      this.nQK.isPlaying();
      if (this.nQK.kWm)
      {
        ac.d(MPExoVideoWrapper.access$getTAG$cp(), "checkTimer onVideoPlay");
        this.nQK.onVideoPlay();
        this.nQK.setPlayOnUiPause(false);
      }
      for (;;)
      {
        AppMethodBeat.o(7388);
        return true;
        this.nQK.tc(this.nQK.getCurrPosSec());
        MPExoVideoWrapper.b(this.nQK, this.nQK.isPlaying());
        MPExoVideoWrapper.D(this.nQK);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onInfo"})
  static final class d
    implements b.d
  {
    d(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean bY(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199183);
      boolean bool = MPExoVideoWrapper.a(this.nQK, paramInt1, paramInt2);
      AppMethodBeat.o(199183);
      return bool;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"})
  static final class e
    implements b.c
  {
    e(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean bZ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199184);
      MPExoVideoWrapper.b(this.nQK, paramInt1, paramInt2);
      AppMethodBeat.o(199184);
      return false;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class f
    implements b.e
  {
    f(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(199185);
      MPExoVideoWrapper.r(this.nQK);
      if (MPExoVideoWrapper.s(this.nQK) != null)
      {
        paramb = MPExoVideoWrapper.s(this.nQK);
        if (paramb == null) {
          k.fOy();
        }
        paramb.jdMethod_do("", "");
      }
      AppMethodBeat.o(199185);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class g
    implements b.b
  {
    g(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void Fh()
    {
      AppMethodBeat.i(199186);
      MPExoVideoWrapper.t(this.nQK);
      AppMethodBeat.o(199186);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class h
    implements b.f
  {
    h(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void b(b paramb)
    {
      AppMethodBeat.i(199187);
      MPExoVideoWrapper.u(this.nQK);
      AppMethodBeat.o(199187);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "onVideoSizeChanged"})
  static final class i
    implements b.g
  {
    i(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void a(b paramb, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199188);
      MPExoVideoWrapper.c(this.nQK, paramInt1, paramInt2);
      AppMethodBeat.o(199188);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "percent", "", "onBufferingUpdate"})
  static final class j
    implements b.a
  {
    j(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void gH(int paramInt)
    {
      AppMethodBeat.i(199189);
      MPExoVideoWrapper.b(this.nQK, paramInt);
      AppMethodBeat.o(199189);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class k
    implements au.a
  {
    k(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7396);
      if (this.nQK.getErrorCount() > 0)
      {
        if (this.nQK.isPlaying())
        {
          MPExoVideoWrapper.C(this.nQK);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7397);
      if (this.nQK.getLoading() != null)
      {
        Object localObject = this.nQK.getLoading();
        if (localObject == null) {
          k.fOy();
        }
        if (((ProgressBar)localObject).getVisibility() != 8)
        {
          ac.i(MPExoVideoWrapper.access$getTAG$cp(), "hide loading");
          localObject = this.nQK.getLoading();
          if (localObject != null) {
            ((ProgressBar)localObject).setVisibility(8);
          }
          localObject = this.nQK;
          ((MPExoVideoWrapper)localObject).gox.postDelayed((Runnable)new MPExoVideoWrapper.v((MPExoVideoWrapper)localObject), 500L);
        }
      }
      AppMethodBeat.o(7397);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-brandservice_release"})
  public static final class m
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7402);
      k.h(paramSurfaceTexture, "surface");
      ac.i(MPExoVideoWrapper.access$getTAG$cp(), "on surface texture available, width %d height %d switching %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.nQK.nQE) });
      Object localObject = MPExoVideoWrapper.g(this.nQK);
      if (localObject != null)
      {
        localObject = ((j.a)localObject).Uo("9");
        if (localObject != null)
        {
          j localj = j.nOE;
          j.a((eo)localObject, "PlayerType", "3");
          if (localObject != null)
          {
            localj = j.nOE;
            j.a((eo)localObject, MPExoVideoWrapper.g(this.nQK));
          }
        }
      }
      this.nQK.startTimer();
      localObject = MPExoVideoWrapper.h(this.nQK);
      if (localObject != null) {
        ((MPExoVideoTextureView)localObject).fiQ();
      }
      localObject = MPExoVideoWrapper.h(this.nQK);
      if (localObject != null) {
        ((MPExoVideoTextureView)localObject).h(MPExoVideoWrapper.b(this.nQK));
      }
      MPExoVideoWrapper.a(this.nQK, new Surface(paramSurfaceTexture));
      if ((MPExoVideoWrapper.c(this.nQK) == null) || (!MPExoVideoWrapper.d(this.nQK))) {
        if (this.nQK.nQE) {
          this.nQK.T(MPExoVideoWrapper.i(this.nQK), MPExoVideoWrapper.j(this.nQK));
        }
      }
      for (;;)
      {
        if ((!MPExoVideoWrapper.l(this.nQK)) && (this.nQK.nQE)) {
          MPExoVideoWrapper.m(this.nQK);
        }
        AppMethodBeat.o(7402);
        return;
        this.nQK.bNT();
        MPExoVideoWrapper.k(this.nQK);
        continue;
        ac.i(MPExoVideoWrapper.access$getTAG$cp(), "init, setSurface");
        paramSurfaceTexture = MPExoVideoWrapper.c(this.nQK);
        if (paramSurfaceTexture == null) {
          k.fOy();
        }
        paramSurfaceTexture.setSurface(MPExoVideoWrapper.b(this.nQK));
        if (MPExoVideoWrapper.e(this.nQK))
        {
          paramSurfaceTexture = MPExoVideoWrapper.g(this.nQK);
          if (paramSurfaceTexture != null)
          {
            paramSurfaceTexture = paramSurfaceTexture.Uo("15");
            if (paramSurfaceTexture != null)
            {
              localObject = j.nOE;
              j.a(paramSurfaceTexture, MPExoVideoWrapper.g(this.nQK));
            }
          }
          paramSurfaceTexture = MPExoVideoWrapper.c(this.nQK);
          if (paramSurfaceTexture == null) {
            k.fOy();
          }
          paramSurfaceTexture.start();
        }
        MPExoVideoWrapper.a(this.nQK, false);
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(7401);
      k.h(paramSurfaceTexture, "surface");
      ac.i(MPExoVideoWrapper.access$getTAG$cp(), "on surface texture destroyed");
      MPExoVideoWrapper.a(this.nQK, null);
      if ((MPExoVideoWrapper.c(this.nQK) != null) && (MPExoVideoWrapper.d(this.nQK))) {
        if (this.nQK.isPlaying())
        {
          MPExoVideoWrapper.a(this.nQK, true);
          paramSurfaceTexture = MPExoVideoWrapper.c(this.nQK);
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.pause();
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(7401);
        return false;
        MPExoVideoWrapper.f(this.nQK);
        MPExoVideoWrapper.a(this.nQK, false);
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
      if (this.nQK.getLoading() != null)
      {
        paramSurfaceTexture = this.nQK.getLoading();
        if (paramSurfaceTexture == null) {
          k.fOy();
        }
        if (paramSurfaceTexture.getVisibility() == 0) {
          this.nQK.hideLoading();
        }
      }
      if (MPExoVideoWrapper.a(this.nQK) != null)
      {
        paramSurfaceTexture = MPExoVideoWrapper.a(this.nQK);
        if (paramSurfaceTexture == null) {
          k.fOy();
        }
        if ((paramSurfaceTexture.getVisibility() == 0) && ((this.nQK.isPlaying()) || (this.nQK.getCurrPosSec() != 0))) {
          this.nQK.getUiHandler().post((Runnable)new a(this));
        }
      }
      AppMethodBeat.o(7399);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPExoVideoWrapper.m paramm) {}
      
      public final void run()
      {
        AppMethodBeat.i(7398);
        ac.d(MPExoVideoWrapper.access$getTAG$cp(), "hide cover onSurfaceTextureUpdated");
        this.nQL.nQK.bNS();
        AppMethodBeat.o(7398);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(MPExoVideoWrapper paramMPExoVideoWrapper, String paramString, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(7403);
      this.nQK.Fb();
      this.nQK.hideLoading();
      if (MPExoVideoWrapper.s(this.nQK) != null)
      {
        h.b localb = MPExoVideoWrapper.s(this.nQK);
        if (localb == null) {
          k.fOy();
        }
        localb.c("", "", this.nQM, paramInt1, paramInt2);
      }
      AppMethodBeat.o(7403);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7404);
      this.nQK.ry(500L);
      this.nQK.tc(this.nQK.getCurrPosSec());
      MPExoVideoWrapper.A(this.nQK);
      AppMethodBeat.o(7404);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7406);
      ImageView localImageView = MPExoVideoWrapper.o(this.nQK);
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      MPExoVideoWrapper.p(this.nQK);
      AppMethodBeat.o(7406);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7407);
      TextView localTextView = MPExoVideoWrapper.q(this.nQK);
      if (localTextView != null)
      {
        localTextView.setVisibility(8);
        AppMethodBeat.o(7407);
        return;
      }
      AppMethodBeat.o(7407);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7408);
      this.nQK.setKeepScreenOn(false);
      MPExoVideoWrapper.x(this.nQK).YC();
      if (MPExoVideoWrapper.s(this.nQK) != null)
      {
        h.b localb = MPExoVideoWrapper.s(this.nQK);
        if (localb == null) {
          k.fOy();
        }
        localb.dq("", "");
      }
      AppMethodBeat.o(7408);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7409);
      this.nQK.setKeepScreenOn(true);
      MPExoVideoWrapper.x(this.nQK).a((d.a)this.nQK);
      if (MPExoVideoWrapper.s(this.nQK) != null)
      {
        h.b localb = MPExoVideoWrapper.s(this.nQK);
        if (localb == null) {
          k.fOy();
        }
        localb.dr("", "");
      }
      MPExoVideoWrapper.b(this.nQK, true);
      this.nQK.startTimer();
      AppMethodBeat.o(7409);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7410);
      if (MPExoVideoWrapper.s(this.nQK) != null)
      {
        h.b localb = MPExoVideoWrapper.s(this.nQK);
        if (localb == null) {
          k.fOy();
        }
        localb.ds("", "");
      }
      AppMethodBeat.o(7410);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class v
    implements Runnable
  {
    v(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7411);
      if (MPExoVideoWrapper.s(this.nQK) != null)
      {
        h.b localb = MPExoVideoWrapper.s(this.nQK);
        if (localb == null) {
          k.fOy();
        }
        localb.dt("", "");
      }
      AppMethodBeat.o(7411);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class w
    implements Runnable
  {
    w(MPExoVideoWrapper paramMPExoVideoWrapper, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(7412);
      MPExoVideoWrapper.c(this.nQK, paramBoolean);
      AppMethodBeat.o(7412);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class x
    implements Runnable
  {
    x(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7413);
      MPExoVideoWrapper.v(this.nQK);
      AppMethodBeat.o(7413);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class y
    implements Runnable
  {
    y(MPExoVideoWrapper paramMPExoVideoWrapper, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(7414);
      if (MPExoVideoWrapper.w(this.nQK) != null)
      {
        g localg = MPExoVideoWrapper.w(this.nQK);
        if (localg == null) {
          k.fOy();
        }
        if (localg.getVideoTotalTime() != paramInt)
        {
          localg = MPExoVideoWrapper.w(this.nQK);
          if (localg == null) {
            k.fOy();
          }
          localg.setVideoTotalTime(paramInt);
        }
      }
      AppMethodBeat.o(7414);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class z
    implements Runnable
  {
    z(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7415);
      if (this.nQK.getLoading() != null)
      {
        Object localObject = this.nQK.getLoading();
        if (localObject == null) {
          k.fOy();
        }
        if (((ProgressBar)localObject).getVisibility() != 0)
        {
          ac.i(MPExoVideoWrapper.access$getTAG$cp(), "show loading");
          localObject = this.nQK.getLoading();
          if (localObject != null) {
            ((ProgressBar)localObject).setVisibility(0);
          }
          localObject = this.nQK;
          ((MPExoVideoWrapper)localObject).gox.post((Runnable)new MPExoVideoWrapper.u((MPExoVideoWrapper)localObject));
        }
      }
      AppMethodBeat.o(7415);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper
 * JD-Core Version:    0.7.0.1
 */