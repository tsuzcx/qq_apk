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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ERROR_CHECK_TIME", "", "getERROR_CHECK_TIME", "()I", "ERROR_TRY_AGAIN_DELAY_TIME", "getERROR_TRY_AGAIN_DELAY_TIME", "ERROR_TRY_MAX_TIME", "getERROR_TRY_MAX_TIME", "bandwidthFraction", "", "bizVideoProfiler", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "getBizVideoProfiler", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "cacheTimeSec", "getCacheTimeSec", "callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getCheckTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "setCheckTimer", "(Lcom/tencent/mm/sdk/platformtools/MTimerHandler;)V", "currPosMs", "getCurrPosMs", "currPosSec", "getCurrPosSec", "downloadPercent", "durationSec", "errorCheckTimer", "getErrorCheckTimer", "setErrorCheckTimer", "errorCount", "getErrorCount", "setErrorCount", "(I)V", "footerView", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoFooter;", "hasExoParam", "", "inBackGround", "isControllerBarShowing", "()Z", "setControllerBarShowing", "(Z)V", "isInFullScreen", "isLive", "setLive", "isPlayOnUiPause", "setPlayOnUiPause", "isPlaying", "isSwitchingResolution", "setSwitchingResolution", "isUIAvailable", "setUIAvailable", "lastSeekAutoPlay", "lastSeekTime", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "localIsPlaying", "mAudioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "mCoverIv", "Landroid/widget/ImageView;", "mFirstRenderStartTime", "", "mFooterContainer", "Landroid/widget/LinearLayout;", "mLastUpdateBuffer", "mMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/ExoMediaPlayer;", "mMediaPlayerAvailable", "mPlayingBeforeBuffering", "mPlayingBeforeSeeking", "mPlayingWhenBackground", "mStartSeekPosition", "mStartWhenPrepared", "mStartWhenSeekCompleted", "mSurface", "Landroid/view/Surface;", "mSwitchCoverIv", "mSwitchTitleTextView", "Landroid/widget/TextView;", "mVideoDuration", "mVideoHasEndedPlaying", "mVideoHasPrepared", "mVideoHeight", "mVideoLooping", "mVideoPath", "", "mVideoProxyUrl", "mVideoSource", "getMVideoSource", "setMVideoSource", "mVideoTextureView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoTextureView;", "mVideoWidth", "maxBufferMs", "maxDurForQualityMs", "maxInitialBitrate", "minBufferMs", "minDurForQualityMs", "mute", "needShowSwitchTitleTextView", "getNeedShowSwitchTitleTextView", "setNeedShowSwitchTitleTextView", "pauseByDestroyed", "resolutionStr", "showLoadingRunning", "Ljava/lang/Runnable;", "showLoadingTimer", "getShowLoadingTimer", "setShowLoadingTimer", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setUiHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "videoDurationMs", "getVideoDurationMs", "videoDurationSec", "getVideoDurationSec", "videoHeight", "getVideoHeight", "videoWidth", "getVideoWidth", "adjustObjectFit", "", "applyMediaPlayerParams", "checkExoPlayerParam", "checkVideoUrl", "clearSurface", "createMediaPlayer", "enterFullScreen", "gain", "getCoverIv", "getFirstRenderTime", "hideCover", "hideLoading", "init", "isNeedToPlay", "isShowingLoading", "isSwitchTitleTextViewShowing", "loss", "lossTransient", "lossTransientCanDuck", "onControllerBarVisible", "visible", "onError", "what", "extra", "onMediaPlayerBufferingUpdate", "percent", "onMediaPlayerCompletion", "onMediaPlayerInfo", "onMediaPlayerPrepared", "onMediaPlayerSeekComplete", "onMediaPlayerVideoSizeChanged", "width", "height", "onPlayDoSwitchEnd", "onSeekEnd", "onSetResolution", "onSwitchEnd", "onSwitchEndShowSuccessWording", "onUIDestroy", "onUIPause", "onUIResume", "onVideoLoadedMetaData", "duration", "onVideoPause", "onVideoPlay", "onVideoProgress", "onVideoWaiting", "onVideoWaitingEnd", "pause", "prepareAsync", "quitFullScreen", "releaseMediaPlayer", "releaseSurface", "reset", "resetErrorCount", "resetMediaPlayer", "resetResolutionStatus", "restartVideo", "seekPosition", "play", "retryWhenError", "seekTo", "ms", "afterPlay", "setExoPlayerParam", "setIMMVideoViewCallback", "_callback", "setKeepScreenOn", "keepScreenOn", "setMute", "_mute", "setSwitchSpeedCover", "setVideoFooterView", "_footerView", "setVideoPath", "_isLive", "_url", "_durationSec", "setVideoSource", "videoSource", "setVideoTotalTime", "seconds", "showCover", "showLoading", "showLoadingDelayed", "delayMillis", "start", "startErrorCheckTimer", "startTimer", "stop", "stopErrorCheckTimer", "stopTimer", "tryPreloadVideo", "unKown", "updateUI", "currPlaySec", "updateVideoStatus", "isPlay", "Companion", "plugin-brandservice_release"})
public final class MPExoVideoWrapper
  extends RelativeLayout
  implements d.a
{
  public static final String TAG = "MicroMsg.MPExoVideoWrapper";
  private static final int oto = 500;
  private static final int otp = 0;
  public static final MPExoVideoWrapper.a otq;
  private int bDT;
  private float bDX;
  private int bFv;
  boolean bzN;
  private boolean cuC;
  private boolean cuD;
  private boolean cuE;
  private boolean cuH;
  public boolean cuI;
  private boolean cuJ;
  private final boolean cuK;
  private int cuM;
  private int cuN;
  private String cuO;
  private boolean cuQ;
  ap gIf;
  private boolean hvp;
  boolean jBC;
  private ImageView lkQ;
  private int llD;
  private int llm;
  private int lra;
  private int lrb;
  private int lrc;
  private int lrd;
  private int lsH;
  private boolean lsR;
  public boolean lsZ;
  public ProgressBar ltc;
  public boolean ltl;
  private av lts;
  private av ltu;
  private final Runnable ltx;
  private Surface mSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  private final int osP;
  private final int osQ;
  private final int osR;
  private LinearLayout osS;
  ImageView osT;
  TextView osU;
  private com.tencent.mm.pluginsdk.ui.h osV;
  String osW;
  MPExoVideoTextureView osX;
  public com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c osY;
  private i.b osZ;
  public final d ota;
  private String otb;
  public boolean otc;
  private int otd;
  public boolean ote;
  private boolean otf;
  private int otg;
  private boolean oth;
  private long oti;
  private boolean otj;
  boolean otk;
  boolean otl;
  boolean otm;
  private av otn;
  
  static
  {
    AppMethodBeat.i(7467);
    otq = new MPExoVideoWrapper.a((byte)0);
    TAG = "MicroMsg.MPExoVideoWrapper";
    oto = 500;
    AppMethodBeat.o(7467);
  }
  
  public MPExoVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7466);
    this.osP = 5000;
    this.osQ = 200;
    this.osR = 5;
    this.gIf = new ap(Looper.getMainLooper());
    paramContext = d.azW();
    p.g(paramContext, "AudioHelperTool.createTool()");
    this.ota = paramContext;
    this.llm = otp;
    this.lsZ = true;
    this.bDT = 800000;
    this.bDX = 0.75F;
    this.lra = 10000;
    this.lrb = 25000;
    this.lrc = 15000;
    this.lrd = 30000;
    this.lts = new av((av.a)new c(this), true);
    LayoutInflater.from(getContext()).inflate(2131494956, (ViewGroup)this);
    this.osX = ((MPExoVideoTextureView)findViewById(2131302512));
    this.ltc = ((ProgressBar)findViewById(2131306352));
    this.osS = ((LinearLayout)findViewById(2131306342));
    this.lkQ = ((ImageView)findViewById(2131302505));
    this.osT = ((ImageView)findViewById(2131302511));
    this.osU = ((TextView)findViewById(2131305584));
    paramContext = this.osX;
    if (paramContext == null) {
      p.gfZ();
    }
    paramContext.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new m(this));
    this.ltx = ((Runnable)new aa(this));
    this.otn = new av((av.a)new ab(this), false);
    this.ltu = new av((av.a)new k(this), true);
    AppMethodBeat.o(7466);
  }
  
  private final void Gw()
  {
    try
    {
      AppMethodBeat.i(7435);
      if (this.osY != null)
      {
        com.tencent.mm.sdk.platformtools.ad.i(TAG, "releaseMediaPlayer");
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.osY;
        if (localc == null) {
          p.gfZ();
        }
        localc.a(null);
        localc = this.osY;
        if (localc == null) {
          p.gfZ();
        }
        localc.a(null);
        localc = this.osY;
        if (localc == null) {
          p.gfZ();
        }
        localc.a(null);
        localc = this.osY;
        if (localc == null) {
          p.gfZ();
        }
        localc.a(null);
        localc = this.osY;
        if (localc == null) {
          p.gfZ();
        }
        localc.a(null);
        localc = this.osY;
        if (localc == null) {
          p.gfZ();
        }
        localc.a(null);
        localc = this.osY;
        if (localc == null) {
          p.gfZ();
        }
        localc.stop();
        localc = this.osY;
        if (localc == null) {
          p.gfZ();
        }
        localc.reset();
        localc = this.osY;
        if (localc == null) {
          p.gfZ();
        }
        localc.release();
      }
      this.osY = null;
      this.cuJ = false;
      AppMethodBeat.o(7435);
      return;
    }
    finally {}
  }
  
  private final void Gx()
  {
    AppMethodBeat.i(7438);
    if (this.osY != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.osY;
      if (localc == null) {
        p.gfZ();
      }
      localc.setMute(this.hvp);
      if (this.mSurface != null)
      {
        localc = this.osY;
        if (localc == null) {
          p.gfZ();
        }
        localc.setSurface(this.mSurface);
      }
    }
    AppMethodBeat.o(7438);
  }
  
  private final void bSo()
  {
    AppMethodBeat.i(7436);
    if ((this.mSurface != null) && (this.cuI))
    {
      MPExoVideoTextureView localMPExoVideoTextureView = this.osX;
      if (localMPExoVideoTextureView != null)
      {
        localMPExoVideoTextureView.bSo();
        AppMethodBeat.o(7436);
        return;
      }
    }
    AppMethodBeat.o(7436);
  }
  
  private final void bSu()
  {
    AppMethodBeat.i(7439);
    if (this.osY != null)
    {
      AppMethodBeat.o(7439);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "createMediaPlayer");
    this.lsH = 0;
    float f;
    if (this.otj)
    {
      localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c(this.bDT, this.bDX, this.lra, this.lrb, this.lrc, this.lrd);
      this.osY = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1);
      localObject1 = this.osY;
      if (localObject1 == null) {
        p.gfZ();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).setLooping(this.cuK);
      localObject1 = this.osY;
      if (localObject1 == null) {
        p.gfZ();
      }
      Object localObject2 = c.otD;
      localObject2 = c.bSy();
      if (localObject2 == null) {
        break label185;
      }
      f = ((c.a)localObject2).otK;
      label131:
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).aF(f);
      if (this.osY == null) {
        break label190;
      }
    }
    label185:
    label190:
    for (boolean bool = true;; bool = false)
    {
      this.cuJ = bool;
      if (this.cuJ) {
        break label195;
      }
      com.tencent.mm.sdk.platformtools.ad.e(TAG, "createMediaPlayer, create media player fail");
      AppMethodBeat.o(7439);
      return;
      localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c();
      break;
      f = 1.0F;
      break label131;
    }
    label195:
    Object localObject1 = this.osY;
    if (localObject1 == null) {
      p.gfZ();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).a((b.e)new d(this));
    localObject1 = this.osY;
    if (localObject1 == null) {
      p.gfZ();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).a((b.d)new e(this));
    localObject1 = this.osY;
    if (localObject1 == null) {
      p.gfZ();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).a((b.f)new f(this));
    localObject1 = this.osY;
    if (localObject1 == null) {
      p.gfZ();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).a((b.b)new g(this));
    localObject1 = this.osY;
    if (localObject1 == null) {
      p.gfZ();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).a((b.g)new h(this));
    localObject1 = this.osY;
    if (localObject1 == null) {
      p.gfZ();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).a((b.h)new i(this));
    localObject1 = this.osY;
    if (localObject1 == null) {
      p.gfZ();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).a((b.a)new j(this));
    if (!bt.isNullOrNil(this.cuO))
    {
      if (bt.isNullOrNil(this.otb))
      {
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr();
        p.g(localObject1, "VideoCore.getInstance()");
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bnt())
        {
          localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr();
          p.g(localObject1, "VideoCore.getInstance()");
          if (((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bns()) {
            this.otb = com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr().getProxyUrl(this.cuO);
          }
        }
      }
      if (!bt.isNullOrNil(this.otb))
      {
        localObject1 = this.osY;
        if (localObject1 == null) {
          p.gfZ();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).setDataSource(this.otb);
        AppMethodBeat.o(7439);
        return;
      }
      localObject1 = this.osY;
      if (localObject1 == null) {
        p.gfZ();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).setDataSource(this.cuO);
    }
    AppMethodBeat.o(7439);
  }
  
  private final void bSw()
  {
    AppMethodBeat.i(7463);
    this.gIf.post((Runnable)new MPExoVideoWrapper.b(this));
    AppMethodBeat.o(7463);
  }
  
  private final void gS(final boolean paramBoolean)
  {
    AppMethodBeat.i(7444);
    this.gIf.post((Runnable)new ae(this, paramBoolean));
    AppMethodBeat.o(7444);
  }
  
  private final j.a getBizVideoProfiler()
  {
    AppMethodBeat.i(210140);
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.XV(getContext().toString());
    AppMethodBeat.o(210140);
    return localObject;
  }
  
  private final void onError(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(7464);
    Object localObject = d.g.b.ad.MLZ;
    localObject = String.format("PlayError %s/%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 2));
    p.g(localObject, "java.lang.String.format(format, *args)");
    com.tencent.mm.sdk.platformtools.ad.w(TAG, "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.bFv += 1;
    if (this.bFv > this.osR)
    {
      this.gIf.post((Runnable)new n(this, (String)localObject, paramInt1, paramInt2));
      AppMethodBeat.o(7464);
      return;
    }
    this.gIf.postDelayed((Runnable)new o(this), this.osQ);
    AppMethodBeat.o(7464);
  }
  
  private final void prepareAsync()
  {
    AppMethodBeat.i(7454);
    Object localObject;
    if ((this.osY != null) && (!bt.isNullOrNil(this.cuO)))
    {
      if (bt.isNullOrNil(this.otb))
      {
        localObject = com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr();
        p.g(localObject, "VideoCore.getInstance()");
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject).bnt())
        {
          localObject = com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr();
          p.g(localObject, "VideoCore.getInstance()");
          if (((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject).bns()) {
            this.otb = com.tencent.mm.plugin.appbrand.jsapi.video.j.bnr().getProxyUrl(this.cuO);
          }
        }
      }
      if (bt.isNullOrNil(this.otb)) {
        break label204;
      }
      localObject = this.osY;
      if (localObject == null) {
        p.gfZ();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject).setDataSource(this.otb);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "video prepare async");
      tx(500L);
      this.cuI = false;
      this.oti = System.currentTimeMillis();
      if (this.osY != null)
      {
        localObject = getBizVideoProfiler();
        if (localObject != null)
        {
          localObject = ((j.a)localObject).XX("10");
          if (localObject != null)
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, getBizVideoProfiler());
          }
        }
        localObject = this.osY;
        if (localObject == null) {
          p.gfZ();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject).prepareAsync();
      }
      AppMethodBeat.o(7454);
      return;
      label204:
      localObject = this.osY;
      if (localObject == null) {
        p.gfZ();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject).setDataSource(this.cuO);
    }
  }
  
  private final void reset()
  {
    this.cuC = false;
    this.cuD = false;
    this.cuE = false;
  }
  
  private final void setVideoTotalTime(final int paramInt)
  {
    AppMethodBeat.i(7445);
    this.gIf.post((Runnable)new z(this, paramInt));
    AppMethodBeat.o(7445);
  }
  
  private final void stopTimer()
  {
    AppMethodBeat.i(7447);
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "stop timer");
    this.lts.stopTimer();
    AppMethodBeat.o(7447);
  }
  
  public final boolean Gv()
  {
    AppMethodBeat.i(7457);
    this.otf = false;
    stopTimer();
    MPExoVideoTextureView localMPExoVideoTextureView = this.osX;
    if (localMPExoVideoTextureView != null) {
      localMPExoVideoTextureView.stop();
    }
    this.lsH = 0;
    if (this.osY != null)
    {
      this.gIf.post((Runnable)new ac(this));
      AppMethodBeat.o(7457);
      return true;
    }
    AppMethodBeat.o(7457);
    return false;
  }
  
  public final void T(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(7429);
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "prepare async");
    bSt();
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
    this.oth = paramBoolean;
    int j = getVideoDurationMs();
    int i = paramInt;
    if (j > 100)
    {
      i = paramInt;
      if (paramInt > j) {
        i = j;
      }
    }
    if ((this.cuI) && (this.osY != null))
    {
      this.cuD = bSv();
      com.tencent.mm.sdk.platformtools.ad.d(TAG, "seekTo mPlayingBeforeSeeking %b, afterPlay %b, seekTime %d", new Object[] { Boolean.valueOf(this.cuD), Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc;
      if (!paramBoolean)
      {
        localc = this.osY;
        if (localc == null) {
          p.gfZ();
        }
        localc.pause();
      }
      for (;;)
      {
        if ((j != i) && (i > 0)) {
          this.cuQ = false;
        }
        localc = this.osY;
        if (localc == null) {
          p.gfZ();
        }
        localc.k(i, paramBoolean);
        this.otg = i;
        tx(500L);
        tF(i / 1000);
        AppMethodBeat.o(7448);
        return;
        startTimer();
      }
    }
    this.otd = i;
    AppMethodBeat.o(7448);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(175547);
    this.bDT = paramInt1;
    this.bDX = paramFloat;
    this.lra = paramInt2;
    this.lrb = paramInt3;
    this.lrc = paramInt4;
    this.lrd = paramInt5;
    if ((this.bDT != 0) && (this.bDX != 0.0F) && (this.lra != 0) && (this.lrb != 0) && (this.lrc != 0) && (this.lrd != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.otj = bool;
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "setExoPlayerParam checkExoPlayerParam result = " + this.otj);
      AppMethodBeat.o(175547);
      return;
    }
  }
  
  public final void aAa() {}
  
  public final void aAb() {}
  
  public final void azY() {}
  
  public final void azZ() {}
  
  final void bSp()
  {
    AppMethodBeat.i(7431);
    Object localObject = this.osT;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    if (!this.otm)
    {
      localObject = this.osU;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      this.otk = false;
      AppMethodBeat.o(7431);
      return;
    }
    this.otk = true;
    AppMethodBeat.o(7431);
  }
  
  final void bSq()
  {
    AppMethodBeat.i(7432);
    if (this.osW != null)
    {
      localTextView = this.osU;
      if (localTextView != null) {
        localTextView.setText((CharSequence)getContext().getString(2131761349, new Object[] { this.osW }));
      }
      this.gIf.postDelayed((Runnable)new s(this), 1500L);
      AppMethodBeat.o(7432);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.w(TAG, "resolutionStr is null");
    TextView localTextView = this.osU;
    if (localTextView != null)
    {
      localTextView.setVisibility(8);
      AppMethodBeat.o(7432);
      return;
    }
    AppMethodBeat.o(7432);
  }
  
  public final void bSr()
  {
    AppMethodBeat.i(7433);
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "show cover");
    ImageView localImageView = this.lkQ;
    if (localImageView == null) {
      p.gfZ();
    }
    localImageView.setVisibility(0);
    AppMethodBeat.o(7433);
  }
  
  public final void bSs()
  {
    AppMethodBeat.i(7434);
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "hide cover");
    ImageView localImageView = this.lkQ;
    if (localImageView == null) {
      p.gfZ();
    }
    localImageView.setVisibility(8);
    AppMethodBeat.o(7434);
  }
  
  public final void bSt()
  {
    AppMethodBeat.i(7437);
    reset();
    Gw();
    bSu();
    Gx();
    AppMethodBeat.o(7437);
  }
  
  public final boolean bSv()
  {
    AppMethodBeat.i(7450);
    if ((this.otf) || (isPlaying()) || (this.cuD) || (this.cuC))
    {
      AppMethodBeat.o(7450);
      return true;
    }
    AppMethodBeat.o(7450);
    return false;
  }
  
  public final void cC(String paramString, int paramInt)
  {
    AppMethodBeat.i(7440);
    p.h(paramString, "_url");
    this.cuO = paramString;
    this.llD = paramInt;
    this.bzN = false;
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "setVideoPath, media player prepare async");
    prepareAsync();
    com.tencent.e.h.LTJ.f((Runnable)new y(this), "AppBrandVideo_checkVideoUrl");
    AppMethodBeat.o(7440);
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(179023);
    if (getVideoDurationSec() > 0)
    {
      int i = this.lsH * getVideoDurationSec() / 100;
      AppMethodBeat.o(179023);
      return i;
    }
    AppMethodBeat.o(179023);
    return 0;
  }
  
  protected final av getCheckTimer()
  {
    return this.lts;
  }
  
  public final ImageView getCoverIv()
  {
    AppMethodBeat.i(7430);
    ImageView localImageView = this.lkQ;
    if (localImageView == null) {
      p.gfZ();
    }
    AppMethodBeat.o(7430);
    return localImageView;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(7424);
    if (this.osY != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.osY;
      if (localc == null) {
        p.gfZ();
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
    if (this.osY != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.osY;
      if (localc == null) {
        p.gfZ();
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
    return this.osP;
  }
  
  protected final int getERROR_TRY_AGAIN_DELAY_TIME()
  {
    return this.osQ;
  }
  
  protected final int getERROR_TRY_MAX_TIME()
  {
    return this.osR;
  }
  
  protected final av getErrorCheckTimer()
  {
    return this.ltu;
  }
  
  protected final int getErrorCount()
  {
    return this.bFv;
  }
  
  public final long getFirstRenderTime()
  {
    AppMethodBeat.i(177797);
    if (this.oti != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.oti;
      AppMethodBeat.o(177797);
      return l1 - l2;
    }
    AppMethodBeat.o(177797);
    return 0L;
  }
  
  protected final ProgressBar getLoading()
  {
    return this.ltc;
  }
  
  protected final int getMVideoSource()
  {
    return this.llm;
  }
  
  public final boolean getNeedShowSwitchTitleTextView()
  {
    return this.otk;
  }
  
  protected final av getShowLoadingTimer()
  {
    return this.otn;
  }
  
  protected final ap getUiHandler()
  {
    return this.gIf;
  }
  
  public final int getVideoDurationMs()
  {
    AppMethodBeat.i(7423);
    if (this.osY != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.osY;
      if (localc == null) {
        p.gfZ();
      }
      i = localc.getDuration();
      AppMethodBeat.o(7423);
      return i;
    }
    int i = this.llD;
    AppMethodBeat.o(7423);
    return i * 1000;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(7422);
    if (this.osY != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.osY;
      if (localc == null) {
        p.gfZ();
      }
      i = localc.getDuration() / 1000;
      AppMethodBeat.o(7422);
      return i;
    }
    int i = this.llD;
    AppMethodBeat.o(7422);
    return i;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(7428);
    if (this.osY != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.osY;
      if (localc == null) {
        p.gfZ();
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
    if (this.osY != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.osY;
      if (localc == null) {
        p.gfZ();
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
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "hide loading %s", new Object[] { bt.flS() });
    this.otn.stopTimer();
    this.gIf.post((Runnable)new l(this));
    AppMethodBeat.o(7453);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(7426);
    if ((this.osY != null) && (this.cuI))
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.osY;
      if (localc == null) {
        p.gfZ();
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
    this.ota.abe();
    setKeepScreenOn(false);
    Gw();
    pause();
    if (this.mSurface != null)
    {
      Surface localSurface = this.mSurface;
      if (localSurface == null) {
        p.gfZ();
      }
      localSurface.release();
      this.mSurface = null;
    }
    stopTimer();
    this.ltu.stopTimer();
    this.gIf.removeCallbacksAndMessages(null);
    AppMethodBeat.o(7459);
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(7460);
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    this.gIf.post((Runnable)new t(this));
    AppMethodBeat.o(7460);
  }
  
  public final void onVideoPlay()
  {
    AppMethodBeat.i(7461);
    this.otf = true;
    this.ltl = false;
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    this.gIf.post((Runnable)new u(this));
    AppMethodBeat.o(7461);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(7456);
    this.otf = false;
    gS(false);
    stopTimer();
    if (this.osY != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.osY;
      if (localc == null) {
        p.gfZ();
      }
      if (!localc.isPlaying())
      {
        com.tencent.mm.sdk.platformtools.ad.i(TAG, "video pause, video is not playing");
        this.cuH = false;
        AppMethodBeat.o(7456);
        return true;
      }
      if (!this.cuI)
      {
        com.tencent.mm.sdk.platformtools.ad.i(TAG, "video pause, video not prepared yet, pause video when prepared");
        this.cuH = false;
        AppMethodBeat.o(7456);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "video pause");
      localc = this.osY;
      if (localc == null) {
        p.gfZ();
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
    p.h(paramav, "<set-?>");
    this.lts = paramav;
    AppMethodBeat.o(7421);
  }
  
  public final void setControllerBarShowing(boolean paramBoolean)
  {
    this.otm = paramBoolean;
  }
  
  protected final void setErrorCheckTimer(av paramav)
  {
    AppMethodBeat.i(7465);
    p.h(paramav, "<set-?>");
    this.ltu = paramav;
    AppMethodBeat.o(7465);
  }
  
  protected final void setErrorCount(int paramInt)
  {
    this.bFv = paramInt;
  }
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(7441);
    p.h(paramb, "_callback");
    this.osZ = paramb;
    AppMethodBeat.o(7441);
  }
  
  public final void setKeepScreenOn(final boolean paramBoolean)
  {
    AppMethodBeat.i(7462);
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "set keep screen on[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gIf.post((Runnable)new x(this, paramBoolean));
    AppMethodBeat.o(7462);
  }
  
  public final void setLive(boolean paramBoolean)
  {
    this.bzN = paramBoolean;
  }
  
  protected final void setLoading(ProgressBar paramProgressBar)
  {
    this.ltc = paramProgressBar;
  }
  
  protected final void setMVideoSource(int paramInt)
  {
    this.llm = paramInt;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(7458);
    this.hvp = paramBoolean;
    if (this.osY != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.osY;
      if (localc == null) {
        p.gfZ();
      }
      localc.setMute(this.hvp);
    }
    AppMethodBeat.o(7458);
  }
  
  public final void setNeedShowSwitchTitleTextView(boolean paramBoolean)
  {
    this.otk = paramBoolean;
  }
  
  protected final void setPlayOnUiPause(boolean paramBoolean)
  {
    this.ltl = paramBoolean;
  }
  
  protected final void setShowLoadingTimer(av paramav)
  {
    AppMethodBeat.i(7451);
    p.h(paramav, "<set-?>");
    this.otn = paramav;
    AppMethodBeat.o(7451);
  }
  
  public final void setSwitchingResolution(boolean paramBoolean)
  {
    this.otl = paramBoolean;
  }
  
  protected final void setUIAvailable(boolean paramBoolean)
  {
    this.lsZ = paramBoolean;
  }
  
  protected final void setUiHandler(ap paramap)
  {
    AppMethodBeat.i(7420);
    p.h(paramap, "<set-?>");
    this.gIf = paramap;
    AppMethodBeat.o(7420);
  }
  
  public final void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(7442);
    p.h(paramh, "_footerView");
    this.osV = paramh;
    paramh = this.osS;
    if (paramh == null) {
      p.gfZ();
    }
    paramh.removeAllViews();
    paramh = this.osS;
    if (paramh == null) {
      p.gfZ();
    }
    paramh.addView((View)this.osV);
    AppMethodBeat.o(7442);
  }
  
  public final void setVideoSource(int paramInt)
  {
    this.llm = paramInt;
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(7455);
    if (!this.lsZ)
    {
      com.tencent.mm.sdk.platformtools.ad.w(TAG, "ui on pause now, why u call me to play? [%s]", new Object[] { bt.flS() });
      AppMethodBeat.o(7455);
      return false;
    }
    if (this.mSurface == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w(TAG, "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.lsR = true;
      this.cuH = true;
      AppMethodBeat.o(7455);
      return false;
    }
    this.otf = true;
    if (this.osY == null)
    {
      bSt();
      prepareAsync();
    }
    if (this.osY != null)
    {
      setKeepScreenOn(true);
      this.ota.a((d.a)this);
      Object localObject1;
      if (this.cuI)
      {
        localObject1 = this.osY;
        if (localObject1 == null) {
          p.gfZ();
        }
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).isPlaying())
        {
          com.tencent.mm.sdk.platformtools.ad.i(TAG, "video play, video is playing");
          onVideoPlay();
          AppMethodBeat.o(7455);
          return true;
        }
      }
      if ((this.osY != null) && (!this.cuI))
      {
        com.tencent.mm.sdk.platformtools.ad.i(TAG, "video play, video not prepared yet, start until prepared");
        this.cuH = true;
        AppMethodBeat.o(7455);
        return true;
      }
      if (this.osY != null)
      {
        localObject1 = this.osY;
        if (localObject1 == null) {
          p.gfZ();
        }
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).getState() == 5)
        {
          com.tencent.mm.sdk.platformtools.ad.i(TAG, "video play, video has stopped now, try prepare and start when prepared");
          this.cuH = true;
          com.tencent.mm.sdk.platformtools.ad.i(TAG, "video play, media player prepare async");
          prepareAsync();
          AppMethodBeat.o(7455);
          return true;
        }
      }
      Object localObject2;
      if (this.cuQ)
      {
        com.tencent.mm.sdk.platformtools.ad.i(TAG, "video play, video has ended playing, clear surface and start again");
        this.cuQ = false;
        bSo();
        bSt();
        prepareAsync();
        if (this.osY != null)
        {
          this.cuH = true;
          localObject1 = TAG;
          localObject2 = this.osY;
          if (localObject2 == null) {
            p.gfZ();
          }
          com.tencent.mm.sdk.platformtools.ad.i((String)localObject1, "video play, media player state:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject2).getState()) });
          prepareAsync();
        }
        AppMethodBeat.o(7455);
        return true;
      }
      if (this.osY != null)
      {
        localObject1 = this.osY;
        if (localObject1 == null) {
          p.gfZ();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).start();
        localObject1 = getBizVideoProfiler();
        if (localObject1 != null)
        {
          localObject1 = ((j.a)localObject1).XX("15");
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject1, getBizVideoProfiler());
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
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "start timer");
    if (!this.lts.fkZ()) {
      stopTimer();
    }
    this.lts.CX(oto);
    AppMethodBeat.o(7446);
  }
  
  protected final void tF(final int paramInt)
  {
    AppMethodBeat.i(7443);
    this.gIf.post((Runnable)new ad(this, paramInt));
    AppMethodBeat.o(7443);
  }
  
  final void tx(long paramLong)
  {
    AppMethodBeat.i(7452);
    this.otn.stopTimer();
    this.otn.CX(paramLong);
    AppMethodBeat.o(7452);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class aa
    implements Runnable
  {
    aa(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7415);
      if (this.otr.getLoading() != null)
      {
        Object localObject = this.otr.getLoading();
        if (localObject == null) {
          p.gfZ();
        }
        if (((ProgressBar)localObject).getVisibility() != 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i(MPExoVideoWrapper.access$getTAG$cp(), "show loading");
          localObject = this.otr.getLoading();
          if (localObject != null) {
            ((ProgressBar)localObject).setVisibility(0);
          }
          localObject = this.otr;
          ((MPExoVideoWrapper)localObject).gIf.post((Runnable)new MPExoVideoWrapper.v((MPExoVideoWrapper)localObject));
        }
      }
      AppMethodBeat.o(7415);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTimerExpired"})
  static final class ab
    implements av.a
  {
    ab(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7416);
      this.otr.getUiHandler().post(MPExoVideoWrapper.C(this.otr));
      AppMethodBeat.o(7416);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class ac
    implements Runnable
  {
    ac(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7417);
      com.tencent.mm.sdk.platformtools.ad.i(MPExoVideoWrapper.access$getTAG$cp(), "video stop");
      this.otr.tF(0);
      MPExoVideoWrapper.b(this.otr, false);
      MPExoVideoWrapper.f(this.otr);
      this.otr.onVideoPause();
      AppMethodBeat.o(7417);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class ad
    implements Runnable
  {
    ad(MPExoVideoWrapper paramMPExoVideoWrapper, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(7418);
      com.tencent.mm.pluginsdk.ui.h localh = MPExoVideoWrapper.w(this.otr);
      if (localh == null) {
        p.gfZ();
      }
      localh.tt(paramInt);
      AppMethodBeat.o(7418);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class ae
    implements Runnable
  {
    ae(MPExoVideoWrapper paramMPExoVideoWrapper, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(7419);
      com.tencent.mm.pluginsdk.ui.h localh = MPExoVideoWrapper.w(this.otr);
      if (localh == null) {
        p.gfZ();
      }
      localh.gS(paramBoolean);
      AppMethodBeat.o(7419);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTimerExpired"})
  static final class c
    implements av.a
  {
    c(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7388);
      this.otr.isPlaying();
      if (this.otr.ltl)
      {
        com.tencent.mm.sdk.platformtools.ad.d(MPExoVideoWrapper.access$getTAG$cp(), "checkTimer onVideoPlay");
        this.otr.onVideoPlay();
        this.otr.setPlayOnUiPause(false);
      }
      for (;;)
      {
        AppMethodBeat.o(7388);
        return true;
        this.otr.tF(this.otr.getCurrPosSec());
        MPExoVideoWrapper.b(this.otr, this.otr.isPlaying());
        MPExoVideoWrapper.B(this.otr);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onInfo"})
  static final class d
    implements b.e
  {
    d(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean ca(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210132);
      boolean bool = MPExoVideoWrapper.a(this.otr, paramInt1, paramInt2);
      AppMethodBeat.o(210132);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"})
  static final class e
    implements b.d
  {
    e(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean cb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210133);
      MPExoVideoWrapper.b(this.otr, paramInt1, paramInt2);
      AppMethodBeat.o(210133);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class f
    implements b.f
  {
    f(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(210134);
      MPExoVideoWrapper.r(this.otr);
      if (MPExoVideoWrapper.s(this.otr) != null)
      {
        paramb = MPExoVideoWrapper.s(this.otr);
        if (paramb == null) {
          p.gfZ();
        }
        paramb.dq("", "");
      }
      AppMethodBeat.o(210134);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class g
    implements b.b
  {
    g(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void GB()
    {
      AppMethodBeat.i(210135);
      MPExoVideoWrapper.t(this.otr);
      AppMethodBeat.o(210135);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class h
    implements b.g
  {
    h(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void b(b paramb)
    {
      AppMethodBeat.i(210136);
      MPExoVideoWrapper.u(this.otr);
      AppMethodBeat.o(210136);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "onVideoSizeChanged"})
  static final class i
    implements b.h
  {
    i(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void a(b paramb, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210137);
      MPExoVideoWrapper.c(this.otr, paramInt1, paramInt2);
      AppMethodBeat.o(210137);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "percent", "", "onBufferingUpdate"})
  static final class j
    implements b.a
  {
    j(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void gM(int paramInt)
    {
      AppMethodBeat.i(210138);
      MPExoVideoWrapper.b(this.otr, paramInt);
      AppMethodBeat.o(210138);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTimerExpired"})
  static final class k
    implements av.a
  {
    k(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7396);
      if (this.otr.getErrorCount() > 0)
      {
        if (this.otr.isPlaying())
        {
          MPExoVideoWrapper.D(this.otr);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7397);
      if (this.otr.getLoading() != null)
      {
        Object localObject = this.otr.getLoading();
        if (localObject == null) {
          p.gfZ();
        }
        if (((ProgressBar)localObject).getVisibility() != 8)
        {
          com.tencent.mm.sdk.platformtools.ad.i(MPExoVideoWrapper.access$getTAG$cp(), "hide loading");
          localObject = this.otr.getLoading();
          if (localObject != null) {
            ((ProgressBar)localObject).setVisibility(8);
          }
          localObject = this.otr;
          ((MPExoVideoWrapper)localObject).gIf.postDelayed((Runnable)new MPExoVideoWrapper.w((MPExoVideoWrapper)localObject), 500L);
        }
      }
      AppMethodBeat.o(7397);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-brandservice_release"})
  public static final class m
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7402);
      p.h(paramSurfaceTexture, "surface");
      com.tencent.mm.sdk.platformtools.ad.i(MPExoVideoWrapper.access$getTAG$cp(), "on surface texture available, width %d height %d switching %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.otr.otl) });
      Object localObject = MPExoVideoWrapper.g(this.otr);
      if (localObject != null)
      {
        localObject = ((j.a)localObject).XX("9");
        if (localObject != null)
        {
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, "PlayerType", "3");
          if (localObject != null)
          {
            localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, MPExoVideoWrapper.g(this.otr));
          }
        }
      }
      this.otr.startTimer();
      localObject = MPExoVideoWrapper.h(this.otr);
      if (localObject != null) {
        ((MPExoVideoTextureView)localObject).fzf();
      }
      localObject = MPExoVideoWrapper.h(this.otr);
      if (localObject != null) {
        ((MPExoVideoTextureView)localObject).h(MPExoVideoWrapper.b(this.otr));
      }
      MPExoVideoWrapper.a(this.otr, new Surface(paramSurfaceTexture));
      if ((MPExoVideoWrapper.c(this.otr) == null) || (!MPExoVideoWrapper.d(this.otr))) {
        if (this.otr.otl) {
          this.otr.T(MPExoVideoWrapper.i(this.otr), MPExoVideoWrapper.j(this.otr));
        }
      }
      for (;;)
      {
        if ((!MPExoVideoWrapper.l(this.otr)) && (this.otr.otl)) {
          MPExoVideoWrapper.m(this.otr);
        }
        AppMethodBeat.o(7402);
        return;
        this.otr.bSt();
        MPExoVideoWrapper.k(this.otr);
        continue;
        com.tencent.mm.sdk.platformtools.ad.i(MPExoVideoWrapper.access$getTAG$cp(), "init, setSurface");
        paramSurfaceTexture = MPExoVideoWrapper.c(this.otr);
        if (paramSurfaceTexture == null) {
          p.gfZ();
        }
        paramSurfaceTexture.setSurface(MPExoVideoWrapper.b(this.otr));
        if (MPExoVideoWrapper.e(this.otr))
        {
          paramSurfaceTexture = MPExoVideoWrapper.g(this.otr);
          if (paramSurfaceTexture != null)
          {
            paramSurfaceTexture = paramSurfaceTexture.XX("15");
            if (paramSurfaceTexture != null)
            {
              localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.ork;
              com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(paramSurfaceTexture, MPExoVideoWrapper.g(this.otr));
            }
          }
          paramSurfaceTexture = MPExoVideoWrapper.c(this.otr);
          if (paramSurfaceTexture == null) {
            p.gfZ();
          }
          paramSurfaceTexture.start();
        }
        MPExoVideoWrapper.a(this.otr, false);
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(7401);
      p.h(paramSurfaceTexture, "surface");
      com.tencent.mm.sdk.platformtools.ad.i(MPExoVideoWrapper.access$getTAG$cp(), "on surface texture destroyed");
      MPExoVideoWrapper.a(this.otr, null);
      if ((MPExoVideoWrapper.c(this.otr) != null) && (MPExoVideoWrapper.d(this.otr))) {
        if (this.otr.isPlaying())
        {
          MPExoVideoWrapper.a(this.otr, true);
          paramSurfaceTexture = MPExoVideoWrapper.c(this.otr);
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.pause();
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(7401);
        return false;
        MPExoVideoWrapper.f(this.otr);
        MPExoVideoWrapper.a(this.otr, false);
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
      if (this.otr.getLoading() != null)
      {
        paramSurfaceTexture = this.otr.getLoading();
        if (paramSurfaceTexture == null) {
          p.gfZ();
        }
        if (paramSurfaceTexture.getVisibility() == 0) {
          this.otr.hideLoading();
        }
      }
      if (MPExoVideoWrapper.a(this.otr) != null)
      {
        paramSurfaceTexture = MPExoVideoWrapper.a(this.otr);
        if (paramSurfaceTexture == null) {
          p.gfZ();
        }
        if ((paramSurfaceTexture.getVisibility() == 0) && ((this.otr.isPlaying()) || (this.otr.getCurrPosSec() != 0))) {
          this.otr.getUiHandler().post((Runnable)new a(this));
        }
      }
      AppMethodBeat.o(7399);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPExoVideoWrapper.m paramm) {}
      
      public final void run()
      {
        AppMethodBeat.i(7398);
        com.tencent.mm.sdk.platformtools.ad.d(MPExoVideoWrapper.access$getTAG$cp(), "hide cover onSurfaceTextureUpdated");
        this.ots.otr.bSs();
        AppMethodBeat.o(7398);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(MPExoVideoWrapper paramMPExoVideoWrapper, String paramString, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(7403);
      this.otr.Gv();
      this.otr.hideLoading();
      if (MPExoVideoWrapper.s(this.otr) != null)
      {
        i.b localb = MPExoVideoWrapper.s(this.otr);
        if (localb == null) {
          p.gfZ();
        }
        localb.c("", "", this.ott, paramInt1, paramInt2);
      }
      AppMethodBeat.o(7403);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7404);
      this.otr.tx(500L);
      this.otr.tF(this.otr.getCurrPosSec());
      MPExoVideoWrapper.A(this.otr);
      AppMethodBeat.o(7404);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(210139);
      if (this.otr.otl) {
        MPExoVideoWrapper.n(this.otr);
      }
      AppMethodBeat.o(210139);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7405);
      MPExoVideoWrapper.n(this.otr);
      AppMethodBeat.o(7405);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7406);
      ImageView localImageView = MPExoVideoWrapper.o(this.otr);
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      MPExoVideoWrapper.p(this.otr);
      AppMethodBeat.o(7406);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7407);
      TextView localTextView = MPExoVideoWrapper.q(this.otr);
      if (localTextView != null)
      {
        localTextView.setVisibility(8);
        AppMethodBeat.o(7407);
        return;
      }
      AppMethodBeat.o(7407);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7408);
      this.otr.setKeepScreenOn(false);
      MPExoVideoWrapper.x(this.otr).abe();
      if (MPExoVideoWrapper.s(this.otr) != null)
      {
        i.b localb = MPExoVideoWrapper.s(this.otr);
        if (localb == null) {
          p.gfZ();
        }
        localb.ds("", "");
      }
      AppMethodBeat.o(7408);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7409);
      this.otr.setKeepScreenOn(true);
      MPExoVideoWrapper.x(this.otr).a((d.a)this.otr);
      if (MPExoVideoWrapper.s(this.otr) != null)
      {
        i.b localb = MPExoVideoWrapper.s(this.otr);
        if (localb == null) {
          p.gfZ();
        }
        localb.dt("", "");
      }
      MPExoVideoWrapper.b(this.otr, true);
      this.otr.startTimer();
      AppMethodBeat.o(7409);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class v
    implements Runnable
  {
    v(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7410);
      if (MPExoVideoWrapper.s(this.otr) != null)
      {
        i.b localb = MPExoVideoWrapper.s(this.otr);
        if (localb == null) {
          p.gfZ();
        }
        localb.du("", "");
      }
      AppMethodBeat.o(7410);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class w
    implements Runnable
  {
    w(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7411);
      if (MPExoVideoWrapper.s(this.otr) != null)
      {
        i.b localb = MPExoVideoWrapper.s(this.otr);
        if (localb == null) {
          p.gfZ();
        }
        localb.dv("", "");
      }
      AppMethodBeat.o(7411);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class x
    implements Runnable
  {
    x(MPExoVideoWrapper paramMPExoVideoWrapper, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(7412);
      MPExoVideoWrapper.c(this.otr, paramBoolean);
      AppMethodBeat.o(7412);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class y
    implements Runnable
  {
    y(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7413);
      MPExoVideoWrapper.v(this.otr);
      AppMethodBeat.o(7413);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class z
    implements Runnable
  {
    z(MPExoVideoWrapper paramMPExoVideoWrapper, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(7414);
      if (MPExoVideoWrapper.w(this.otr) != null)
      {
        com.tencent.mm.pluginsdk.ui.h localh = MPExoVideoWrapper.w(this.otr);
        if (localh == null) {
          p.gfZ();
        }
        if (localh.getVideoTotalTime() != paramInt)
        {
          localh = MPExoVideoWrapper.w(this.otr);
          if (localh == null) {
            p.gfZ();
          }
          localh.setVideoTotalTime(paramInt);
        }
      }
      AppMethodBeat.o(7414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper
 * JD-Core Version:    0.7.0.1
 */