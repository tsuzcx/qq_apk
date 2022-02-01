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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ERROR_CHECK_TIME", "", "getERROR_CHECK_TIME", "()I", "ERROR_TRY_AGAIN_DELAY_TIME", "getERROR_TRY_AGAIN_DELAY_TIME", "ERROR_TRY_MAX_TIME", "getERROR_TRY_MAX_TIME", "bandwidthFraction", "", "bizVideoProfiler", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "getBizVideoProfiler", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "cacheTimeSec", "getCacheTimeSec", "callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getCheckTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "setCheckTimer", "(Lcom/tencent/mm/sdk/platformtools/MTimerHandler;)V", "currPosMs", "getCurrPosMs", "currPosSec", "getCurrPosSec", "downloadPercent", "durationSec", "errorCheckTimer", "getErrorCheckTimer", "setErrorCheckTimer", "errorCount", "getErrorCount", "setErrorCount", "(I)V", "footerView", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoFooter;", "hasExoParam", "", "inBackGround", "isControllerBarShowing", "()Z", "setControllerBarShowing", "(Z)V", "isInFullScreen", "isLive", "setLive", "isPlayOnUiPause", "setPlayOnUiPause", "isPlaying", "isSwitchingResolution", "setSwitchingResolution", "isUIAvailable", "setUIAvailable", "lastSeekAutoPlay", "lastSeekTime", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "localIsPlaying", "mAudioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "mCoverIv", "Landroid/widget/ImageView;", "mFirstRenderStartTime", "", "mFooterContainer", "Landroid/widget/LinearLayout;", "mLastUpdateBuffer", "mMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/ExoMediaPlayer;", "mMediaPlayerAvailable", "mPlayingBeforeBuffering", "mPlayingBeforeSeeking", "mPlayingWhenBackground", "mStartSeekPosition", "mStartWhenPrepared", "mStartWhenSeekCompleted", "mSurface", "Landroid/view/Surface;", "mSwitchCoverIv", "mSwitchTitleTextView", "Landroid/widget/TextView;", "mVideoDuration", "mVideoHasEndedPlaying", "mVideoHasPrepared", "mVideoHeight", "mVideoLooping", "mVideoPath", "", "mVideoProxyUrl", "mVideoSource", "getMVideoSource", "setMVideoSource", "mVideoTextureView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoTextureView;", "mVideoWidth", "maxBufferMs", "maxDurForQualityMs", "maxInitialBitrate", "minBufferMs", "minDurForQualityMs", "mute", "needShowSwitchTitleTextView", "getNeedShowSwitchTitleTextView", "setNeedShowSwitchTitleTextView", "pauseByDestroyed", "resolutionStr", "showLoadingRunning", "Ljava/lang/Runnable;", "showLoadingTimer", "getShowLoadingTimer", "setShowLoadingTimer", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setUiHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "videoDurationMs", "getVideoDurationMs", "videoDurationSec", "getVideoDurationSec", "videoHeight", "getVideoHeight", "videoWidth", "getVideoWidth", "adjustObjectFit", "", "applyMediaPlayerParams", "checkExoPlayerParam", "checkVideoUrl", "clearSurface", "createMediaPlayer", "enterFullScreen", "gain", "getCoverIv", "getFirstRenderTime", "hideCover", "hideLoading", "init", "isNeedToPlay", "isShowingLoading", "isSwitchTitleTextViewShowing", "loss", "lossTransient", "lossTransientCanDuck", "onControllerBarVisible", "visible", "onError", "what", "extra", "onMediaPlayerBufferingUpdate", "percent", "onMediaPlayerCompletion", "onMediaPlayerInfo", "onMediaPlayerPrepared", "onMediaPlayerSeekComplete", "onMediaPlayerVideoSizeChanged", "width", "height", "onPlayDoSwitchEnd", "onSeekEnd", "onSetResolution", "onSwitchEnd", "onSwitchEndShowSuccessWording", "onUIDestroy", "onUIPause", "onUIResume", "onVideoLoadedMetaData", "duration", "onVideoPause", "onVideoPlay", "onVideoProgress", "onVideoWaiting", "onVideoWaitingEnd", "pause", "prepareAsync", "quitFullScreen", "releaseMediaPlayer", "releaseSurface", "reset", "resetErrorCount", "resetMediaPlayer", "resetResolutionStatus", "restartVideo", "seekPosition", "play", "retryWhenError", "seekTo", "ms", "afterPlay", "setExoPlayerParam", "setIMMVideoViewCallback", "_callback", "setKeepScreenOn", "keepScreenOn", "setMute", "_mute", "setSwitchSpeedCover", "setVideoFooterView", "_footerView", "setVideoPath", "_isLive", "_url", "_durationSec", "setVideoSource", "videoSource", "setVideoTotalTime", "seconds", "showCover", "showLoading", "showLoadingDelayed", "delayMillis", "start", "startErrorCheckTimer", "startTimer", "stop", "stopErrorCheckTimer", "stopTimer", "tryPreloadVideo", "unKown", "updateUI", "currPlaySec", "updateVideoStatus", "isPlay", "Companion", "plugin-brandservice_release"})
public final class MPExoVideoWrapper
  extends RelativeLayout
  implements d.a
{
  public static final String TAG = "MicroMsg.MPExoVideoWrapper";
  private static final int ozP = 500;
  private static final int ozQ = 0;
  public static final MPExoVideoWrapper.a ozR;
  private int bDT;
  private float bDX;
  private int bFv;
  boolean bzN;
  private boolean cvf;
  private boolean cvg;
  private boolean cvh;
  private boolean cvk;
  public boolean cvl;
  private boolean cvm;
  private final boolean cvn;
  private int cvp;
  private int cvq;
  private String cvr;
  private boolean cvt;
  aq gKO;
  private boolean hyd;
  boolean jEw;
  private int lpK;
  private ImageView lpo;
  private int lqc;
  private int lvA;
  private int lvB;
  private int lvC;
  private int lvz;
  public ProgressBar lxB;
  public boolean lxK;
  private aw lxR;
  private aw lxT;
  private final Runnable lxW;
  private int lxg;
  private boolean lxq;
  public boolean lxy;
  private Surface mSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  private i.b ozA;
  public final d ozB;
  private String ozC;
  public boolean ozD;
  private int ozE;
  public boolean ozF;
  private boolean ozG;
  private int ozH;
  private boolean ozI;
  private long ozJ;
  private boolean ozK;
  boolean ozL;
  boolean ozM;
  boolean ozN;
  private aw ozO;
  private final int ozq;
  private final int ozr;
  private final int ozs;
  private LinearLayout ozt;
  ImageView ozu;
  TextView ozv;
  private com.tencent.mm.pluginsdk.ui.h ozw;
  String ozx;
  MPExoVideoTextureView ozy;
  public com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c ozz;
  
  static
  {
    AppMethodBeat.i(7467);
    ozR = new MPExoVideoWrapper.a((byte)0);
    TAG = "MicroMsg.MPExoVideoWrapper";
    ozP = 500;
    AppMethodBeat.o(7467);
  }
  
  public MPExoVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7466);
    this.ozq = 5000;
    this.ozr = 200;
    this.ozs = 5;
    this.gKO = new aq(Looper.getMainLooper());
    paramContext = d.aAm();
    p.g(paramContext, "AudioHelperTool.createTool()");
    this.ozB = paramContext;
    this.lpK = ozQ;
    this.lxy = true;
    this.bDT = 800000;
    this.bDX = 0.75F;
    this.lvz = 10000;
    this.lvA = 25000;
    this.lvB = 15000;
    this.lvC = 30000;
    this.lxR = new aw((aw.a)new c(this), true);
    LayoutInflater.from(getContext()).inflate(2131494956, (ViewGroup)this);
    this.ozy = ((MPExoVideoTextureView)findViewById(2131302512));
    this.lxB = ((ProgressBar)findViewById(2131306352));
    this.ozt = ((LinearLayout)findViewById(2131306342));
    this.lpo = ((ImageView)findViewById(2131302505));
    this.ozu = ((ImageView)findViewById(2131302511));
    this.ozv = ((TextView)findViewById(2131305584));
    paramContext = this.ozy;
    if (paramContext == null) {
      p.gkB();
    }
    paramContext.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new m(this));
    this.lxW = ((Runnable)new MPExoVideoWrapper.aa(this));
    this.ozO = new aw((aw.a)new ab(this), false);
    this.lxT = new aw((aw.a)new k(this), true);
    AppMethodBeat.o(7466);
  }
  
  private final void GC()
  {
    try
    {
      AppMethodBeat.i(7435);
      if (this.ozz != null)
      {
        ae.i(TAG, "releaseMediaPlayer");
        com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.ozz;
        if (localc == null) {
          p.gkB();
        }
        localc.a(null);
        localc = this.ozz;
        if (localc == null) {
          p.gkB();
        }
        localc.a(null);
        localc = this.ozz;
        if (localc == null) {
          p.gkB();
        }
        localc.a(null);
        localc = this.ozz;
        if (localc == null) {
          p.gkB();
        }
        localc.a(null);
        localc = this.ozz;
        if (localc == null) {
          p.gkB();
        }
        localc.a(null);
        localc = this.ozz;
        if (localc == null) {
          p.gkB();
        }
        localc.a(null);
        localc = this.ozz;
        if (localc == null) {
          p.gkB();
        }
        localc.stop();
        localc = this.ozz;
        if (localc == null) {
          p.gkB();
        }
        localc.reset();
        localc = this.ozz;
        if (localc == null) {
          p.gkB();
        }
        localc.release();
      }
      this.ozz = null;
      this.cvm = false;
      AppMethodBeat.o(7435);
      return;
    }
    finally {}
  }
  
  private final void GD()
  {
    AppMethodBeat.i(7438);
    if (this.ozz != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.ozz;
      if (localc == null) {
        p.gkB();
      }
      localc.setMute(this.hyd);
      if (this.mSurface != null)
      {
        localc = this.ozz;
        if (localc == null) {
          p.gkB();
        }
        localc.setSurface(this.mSurface);
      }
    }
    AppMethodBeat.o(7438);
  }
  
  private final void bTB()
  {
    AppMethodBeat.i(7436);
    if ((this.mSurface != null) && (this.cvl))
    {
      MPExoVideoTextureView localMPExoVideoTextureView = this.ozy;
      if (localMPExoVideoTextureView != null)
      {
        localMPExoVideoTextureView.bTB();
        AppMethodBeat.o(7436);
        return;
      }
    }
    AppMethodBeat.o(7436);
  }
  
  private final void bTH()
  {
    AppMethodBeat.i(7439);
    if (this.ozz != null)
    {
      AppMethodBeat.o(7439);
      return;
    }
    ae.i(TAG, "createMediaPlayer");
    this.lxg = 0;
    float f;
    if (this.ozK)
    {
      localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c(this.bDT, this.bDX, this.lvz, this.lvA, this.lvB, this.lvC);
      this.ozz = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1);
      localObject1 = this.ozz;
      if (localObject1 == null) {
        p.gkB();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).setLooping(this.cvn);
      localObject1 = this.ozz;
      if (localObject1 == null) {
        p.gkB();
      }
      Object localObject2 = c.oAe;
      localObject2 = c.bTL();
      if (localObject2 == null) {
        break label185;
      }
      f = ((c.a)localObject2).oAl;
      label131:
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).aF(f);
      if (this.ozz == null) {
        break label190;
      }
    }
    label185:
    label190:
    for (boolean bool = true;; bool = false)
    {
      this.cvm = bool;
      if (this.cvm) {
        break label195;
      }
      ae.e(TAG, "createMediaPlayer, create media player fail");
      AppMethodBeat.o(7439);
      return;
      localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c();
      break;
      f = 1.0F;
      break label131;
    }
    label195:
    Object localObject1 = this.ozz;
    if (localObject1 == null) {
      p.gkB();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).a((b.e)new d(this));
    localObject1 = this.ozz;
    if (localObject1 == null) {
      p.gkB();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).a((b.d)new e(this));
    localObject1 = this.ozz;
    if (localObject1 == null) {
      p.gkB();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).a((b.f)new f(this));
    localObject1 = this.ozz;
    if (localObject1 == null) {
      p.gkB();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).a((b.b)new g(this));
    localObject1 = this.ozz;
    if (localObject1 == null) {
      p.gkB();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).a((b.g)new h(this));
    localObject1 = this.ozz;
    if (localObject1 == null) {
      p.gkB();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).a((b.h)new i(this));
    localObject1 = this.ozz;
    if (localObject1 == null) {
      p.gkB();
    }
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).a((b.a)new j(this));
    if (!bu.isNullOrNil(this.cvr))
    {
      if (bu.isNullOrNil(this.ozC))
      {
        localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bob();
        p.g(localObject1, "VideoCore.getInstance()");
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).bod())
        {
          localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bob();
          p.g(localObject1, "VideoCore.getInstance()");
          if (((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject1).boc()) {
            this.ozC = com.tencent.mm.plugin.appbrand.jsapi.video.j.bob().getProxyUrl(this.cvr);
          }
        }
      }
      if (!bu.isNullOrNil(this.ozC))
      {
        localObject1 = this.ozz;
        if (localObject1 == null) {
          p.gkB();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).setDataSource(this.ozC);
        AppMethodBeat.o(7439);
        return;
      }
      localObject1 = this.ozz;
      if (localObject1 == null) {
        p.gkB();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).setDataSource(this.cvr);
    }
    AppMethodBeat.o(7439);
  }
  
  private final void bTJ()
  {
    AppMethodBeat.i(7463);
    this.gKO.post((Runnable)new MPExoVideoWrapper.b(this));
    AppMethodBeat.o(7463);
  }
  
  private final void gS(boolean paramBoolean)
  {
    AppMethodBeat.i(7444);
    this.gKO.post((Runnable)new MPExoVideoWrapper.ae(this, paramBoolean));
    AppMethodBeat.o(7444);
  }
  
  private final j.a getBizVideoProfiler()
  {
    AppMethodBeat.i(209177);
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.YJ(getContext().toString());
    AppMethodBeat.o(209177);
    return localObject;
  }
  
  private final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7464);
    Object localObject = ad.Njc;
    localObject = String.format("PlayError %s/%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 2));
    p.g(localObject, "java.lang.String.format(format, *args)");
    ae.w(TAG, "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.bFv += 1;
    if (this.bFv > this.ozs)
    {
      this.gKO.post((Runnable)new MPExoVideoWrapper.n(this, (String)localObject, paramInt1, paramInt2));
      AppMethodBeat.o(7464);
      return;
    }
    this.gKO.postDelayed((Runnable)new o(this), this.ozr);
    AppMethodBeat.o(7464);
  }
  
  private final void prepareAsync()
  {
    AppMethodBeat.i(7454);
    Object localObject;
    if ((this.ozz != null) && (!bu.isNullOrNil(this.cvr)))
    {
      if (bu.isNullOrNil(this.ozC))
      {
        localObject = com.tencent.mm.plugin.appbrand.jsapi.video.j.bob();
        p.g(localObject, "VideoCore.getInstance()");
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject).bod())
        {
          localObject = com.tencent.mm.plugin.appbrand.jsapi.video.j.bob();
          p.g(localObject, "VideoCore.getInstance()");
          if (((com.tencent.mm.plugin.appbrand.jsapi.video.j)localObject).boc()) {
            this.ozC = com.tencent.mm.plugin.appbrand.jsapi.video.j.bob().getProxyUrl(this.cvr);
          }
        }
      }
      if (bu.isNullOrNil(this.ozC)) {
        break label204;
      }
      localObject = this.ozz;
      if (localObject == null) {
        p.gkB();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject).setDataSource(this.ozC);
    }
    for (;;)
    {
      ae.i(TAG, "video prepare async");
      tO(500L);
      this.cvl = false;
      this.ozJ = System.currentTimeMillis();
      if (this.ozz != null)
      {
        localObject = getBizVideoProfiler();
        if (localObject != null)
        {
          localObject = ((j.a)localObject).YL("10");
          if (localObject != null)
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, getBizVideoProfiler());
          }
        }
        localObject = this.ozz;
        if (localObject == null) {
          p.gkB();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject).prepareAsync();
      }
      AppMethodBeat.o(7454);
      return;
      label204:
      localObject = this.ozz;
      if (localObject == null) {
        p.gkB();
      }
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject).setDataSource(this.cvr);
    }
  }
  
  private final void reset()
  {
    this.cvf = false;
    this.cvg = false;
    this.cvh = false;
  }
  
  private final void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(7445);
    this.gKO.post((Runnable)new MPExoVideoWrapper.z(this, paramInt));
    AppMethodBeat.o(7445);
  }
  
  private final void stopTimer()
  {
    AppMethodBeat.i(7447);
    ae.d(TAG, "stop timer");
    this.lxR.stopTimer();
    AppMethodBeat.o(7447);
  }
  
  public final boolean GB()
  {
    AppMethodBeat.i(7457);
    this.ozG = false;
    stopTimer();
    MPExoVideoTextureView localMPExoVideoTextureView = this.ozy;
    if (localMPExoVideoTextureView != null) {
      localMPExoVideoTextureView.stop();
    }
    this.lxg = 0;
    if (this.ozz != null)
    {
      this.gKO.post((Runnable)new MPExoVideoWrapper.ac(this));
      AppMethodBeat.o(7457);
      return true;
    }
    AppMethodBeat.o(7457);
    return false;
  }
  
  public final void V(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(7429);
    ae.i(TAG, "prepare async");
    bTG();
    prepareAsync();
    W(paramInt, paramBoolean);
    if (paramBoolean) {
      start();
    }
    AppMethodBeat.o(7429);
  }
  
  public final void W(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(7448);
    this.ozI = paramBoolean;
    int j = getVideoDurationMs();
    int i = paramInt;
    if (j > 100)
    {
      i = paramInt;
      if (paramInt > j) {
        i = j;
      }
    }
    if ((this.cvl) && (this.ozz != null))
    {
      this.cvg = bTI();
      ae.d(TAG, "seekTo mPlayingBeforeSeeking %b, afterPlay %b, seekTime %d", new Object[] { Boolean.valueOf(this.cvg), Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc;
      if (!paramBoolean)
      {
        localc = this.ozz;
        if (localc == null) {
          p.gkB();
        }
        localc.pause();
      }
      for (;;)
      {
        if ((j != i) && (i > 0)) {
          this.cvt = false;
        }
        localc = this.ozz;
        if (localc == null) {
          p.gkB();
        }
        localc.k(i, paramBoolean);
        this.ozH = i;
        tO(500L);
        tK(i / 1000);
        AppMethodBeat.o(7448);
        return;
        startTimer();
      }
    }
    this.ozE = i;
    AppMethodBeat.o(7448);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(175547);
    this.bDT = paramInt1;
    this.bDX = paramFloat;
    this.lvz = paramInt2;
    this.lvA = paramInt3;
    this.lvB = paramInt4;
    this.lvC = paramInt5;
    if ((this.bDT != 0) && (this.bDX != 0.0F) && (this.lvz != 0) && (this.lvA != 0) && (this.lvB != 0) && (this.lvC != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.ozK = bool;
      ae.i(TAG, "setExoPlayerParam checkExoPlayerParam result = " + this.ozK);
      AppMethodBeat.o(175547);
      return;
    }
  }
  
  public final void aAo() {}
  
  public final void aAp() {}
  
  public final void aAq() {}
  
  public final void aAr() {}
  
  final void bTC()
  {
    AppMethodBeat.i(7431);
    Object localObject = this.ozu;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    if (!this.ozN)
    {
      localObject = this.ozv;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      this.ozL = false;
      AppMethodBeat.o(7431);
      return;
    }
    this.ozL = true;
    AppMethodBeat.o(7431);
  }
  
  final void bTD()
  {
    AppMethodBeat.i(7432);
    if (this.ozx != null)
    {
      localTextView = this.ozv;
      if (localTextView != null) {
        localTextView.setText((CharSequence)getContext().getString(2131761349, new Object[] { this.ozx }));
      }
      this.gKO.postDelayed((Runnable)new s(this), 1500L);
      AppMethodBeat.o(7432);
      return;
    }
    ae.w(TAG, "resolutionStr is null");
    TextView localTextView = this.ozv;
    if (localTextView != null)
    {
      localTextView.setVisibility(8);
      AppMethodBeat.o(7432);
      return;
    }
    AppMethodBeat.o(7432);
  }
  
  public final void bTE()
  {
    AppMethodBeat.i(7433);
    ae.d(TAG, "show cover");
    ImageView localImageView = this.lpo;
    if (localImageView == null) {
      p.gkB();
    }
    localImageView.setVisibility(0);
    AppMethodBeat.o(7433);
  }
  
  public final void bTF()
  {
    AppMethodBeat.i(7434);
    ae.d(TAG, "hide cover");
    ImageView localImageView = this.lpo;
    if (localImageView == null) {
      p.gkB();
    }
    localImageView.setVisibility(8);
    AppMethodBeat.o(7434);
  }
  
  public final void bTG()
  {
    AppMethodBeat.i(7437);
    reset();
    GC();
    bTH();
    GD();
    AppMethodBeat.o(7437);
  }
  
  public final boolean bTI()
  {
    AppMethodBeat.i(7450);
    if ((this.ozG) || (isPlaying()) || (this.cvg) || (this.cvf))
    {
      AppMethodBeat.o(7450);
      return true;
    }
    AppMethodBeat.o(7450);
    return false;
  }
  
  public final void cG(String paramString, int paramInt)
  {
    AppMethodBeat.i(7440);
    p.h(paramString, "_url");
    this.cvr = paramString;
    this.lqc = paramInt;
    this.bzN = false;
    ae.i(TAG, "setVideoPath, media player prepare async");
    prepareAsync();
    com.tencent.e.h.MqF.f((Runnable)new y(this), "AppBrandVideo_checkVideoUrl");
    AppMethodBeat.o(7440);
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(179023);
    if (getVideoDurationSec() > 0)
    {
      int i = this.lxg * getVideoDurationSec() / 100;
      AppMethodBeat.o(179023);
      return i;
    }
    AppMethodBeat.o(179023);
    return 0;
  }
  
  protected final aw getCheckTimer()
  {
    return this.lxR;
  }
  
  public final ImageView getCoverIv()
  {
    AppMethodBeat.i(7430);
    ImageView localImageView = this.lpo;
    if (localImageView == null) {
      p.gkB();
    }
    AppMethodBeat.o(7430);
    return localImageView;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(7424);
    if (this.ozz != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.ozz;
      if (localc == null) {
        p.gkB();
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
    if (this.ozz != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.ozz;
      if (localc == null) {
        p.gkB();
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
    return this.ozq;
  }
  
  protected final int getERROR_TRY_AGAIN_DELAY_TIME()
  {
    return this.ozr;
  }
  
  protected final int getERROR_TRY_MAX_TIME()
  {
    return this.ozs;
  }
  
  protected final aw getErrorCheckTimer()
  {
    return this.lxT;
  }
  
  protected final int getErrorCount()
  {
    return this.bFv;
  }
  
  public final long getFirstRenderTime()
  {
    AppMethodBeat.i(177797);
    if (this.ozJ != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.ozJ;
      AppMethodBeat.o(177797);
      return l1 - l2;
    }
    AppMethodBeat.o(177797);
    return 0L;
  }
  
  protected final ProgressBar getLoading()
  {
    return this.lxB;
  }
  
  protected final int getMVideoSource()
  {
    return this.lpK;
  }
  
  public final boolean getNeedShowSwitchTitleTextView()
  {
    return this.ozL;
  }
  
  protected final aw getShowLoadingTimer()
  {
    return this.ozO;
  }
  
  protected final aq getUiHandler()
  {
    return this.gKO;
  }
  
  public final int getVideoDurationMs()
  {
    AppMethodBeat.i(7423);
    if (this.ozz != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.ozz;
      if (localc == null) {
        p.gkB();
      }
      i = localc.getDuration();
      AppMethodBeat.o(7423);
      return i;
    }
    int i = this.lqc;
    AppMethodBeat.o(7423);
    return i * 1000;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(7422);
    if (this.ozz != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.ozz;
      if (localc == null) {
        p.gkB();
      }
      i = localc.getDuration() / 1000;
      AppMethodBeat.o(7422);
      return i;
    }
    int i = this.lqc;
    AppMethodBeat.o(7422);
    return i;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(7428);
    if (this.ozz != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.ozz;
      if (localc == null) {
        p.gkB();
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
    if (this.ozz != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.ozz;
      if (localc == null) {
        p.gkB();
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
    ae.d(TAG, "hide loading %s", new Object[] { bu.fpN() });
    this.ozO.stopTimer();
    this.gKO.post((Runnable)new MPExoVideoWrapper.l(this));
    AppMethodBeat.o(7453);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(7426);
    if ((this.ozz != null) && (this.cvl))
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.ozz;
      if (localc == null) {
        p.gkB();
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
    this.ozB.abn();
    setKeepScreenOn(false);
    GC();
    pause();
    if (this.mSurface != null)
    {
      Surface localSurface = this.mSurface;
      if (localSurface == null) {
        p.gkB();
      }
      localSurface.release();
      this.mSurface = null;
    }
    stopTimer();
    this.lxT.stopTimer();
    this.gKO.removeCallbacksAndMessages(null);
    AppMethodBeat.o(7459);
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(7460);
    ae.d(TAG, "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    this.gKO.post((Runnable)new MPExoVideoWrapper.t(this));
    AppMethodBeat.o(7460);
  }
  
  public final void onVideoPlay()
  {
    AppMethodBeat.i(7461);
    this.ozG = true;
    this.lxK = false;
    ae.d(TAG, "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    this.gKO.post((Runnable)new MPExoVideoWrapper.u(this));
    AppMethodBeat.o(7461);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(7456);
    this.ozG = false;
    gS(false);
    stopTimer();
    if (this.ozz != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.ozz;
      if (localc == null) {
        p.gkB();
      }
      if (!localc.isPlaying())
      {
        ae.i(TAG, "video pause, video is not playing");
        this.cvk = false;
        AppMethodBeat.o(7456);
        return true;
      }
      if (!this.cvl)
      {
        ae.i(TAG, "video pause, video not prepared yet, pause video when prepared");
        this.cvk = false;
        AppMethodBeat.o(7456);
        return true;
      }
      ae.i(TAG, "video pause");
      localc = this.ozz;
      if (localc == null) {
        p.gkB();
      }
      localc.pause();
      onVideoPause();
      AppMethodBeat.o(7456);
      return true;
    }
    AppMethodBeat.o(7456);
    return false;
  }
  
  protected final void setCheckTimer(aw paramaw)
  {
    AppMethodBeat.i(7421);
    p.h(paramaw, "<set-?>");
    this.lxR = paramaw;
    AppMethodBeat.o(7421);
  }
  
  public final void setControllerBarShowing(boolean paramBoolean)
  {
    this.ozN = paramBoolean;
  }
  
  protected final void setErrorCheckTimer(aw paramaw)
  {
    AppMethodBeat.i(7465);
    p.h(paramaw, "<set-?>");
    this.lxT = paramaw;
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
    this.ozA = paramb;
    AppMethodBeat.o(7441);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(7462);
    ae.d(TAG, "set keep screen on[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    this.gKO.post((Runnable)new MPExoVideoWrapper.x(this, paramBoolean));
    AppMethodBeat.o(7462);
  }
  
  public final void setLive(boolean paramBoolean)
  {
    this.bzN = paramBoolean;
  }
  
  protected final void setLoading(ProgressBar paramProgressBar)
  {
    this.lxB = paramProgressBar;
  }
  
  protected final void setMVideoSource(int paramInt)
  {
    this.lpK = paramInt;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(7458);
    this.hyd = paramBoolean;
    if (this.ozz != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c localc = this.ozz;
      if (localc == null) {
        p.gkB();
      }
      localc.setMute(this.hyd);
    }
    AppMethodBeat.o(7458);
  }
  
  public final void setNeedShowSwitchTitleTextView(boolean paramBoolean)
  {
    this.ozL = paramBoolean;
  }
  
  protected final void setPlayOnUiPause(boolean paramBoolean)
  {
    this.lxK = paramBoolean;
  }
  
  protected final void setShowLoadingTimer(aw paramaw)
  {
    AppMethodBeat.i(7451);
    p.h(paramaw, "<set-?>");
    this.ozO = paramaw;
    AppMethodBeat.o(7451);
  }
  
  public final void setSwitchingResolution(boolean paramBoolean)
  {
    this.ozM = paramBoolean;
  }
  
  protected final void setUIAvailable(boolean paramBoolean)
  {
    this.lxy = paramBoolean;
  }
  
  protected final void setUiHandler(aq paramaq)
  {
    AppMethodBeat.i(7420);
    p.h(paramaq, "<set-?>");
    this.gKO = paramaq;
    AppMethodBeat.o(7420);
  }
  
  public final void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(7442);
    p.h(paramh, "_footerView");
    this.ozw = paramh;
    paramh = this.ozt;
    if (paramh == null) {
      p.gkB();
    }
    paramh.removeAllViews();
    paramh = this.ozt;
    if (paramh == null) {
      p.gkB();
    }
    paramh.addView((View)this.ozw);
    AppMethodBeat.o(7442);
  }
  
  public final void setVideoSource(int paramInt)
  {
    this.lpK = paramInt;
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(7455);
    if (!this.lxy)
    {
      ae.w(TAG, "ui on pause now, why u call me to play? [%s]", new Object[] { bu.fpN() });
      AppMethodBeat.o(7455);
      return false;
    }
    if (this.mSurface == null)
    {
      ae.w(TAG, "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.lxq = true;
      this.cvk = true;
      AppMethodBeat.o(7455);
      return false;
    }
    this.ozG = true;
    if (this.ozz == null)
    {
      bTG();
      prepareAsync();
    }
    if (this.ozz != null)
    {
      setKeepScreenOn(true);
      this.ozB.a((d.a)this);
      Object localObject1;
      if (this.cvl)
      {
        localObject1 = this.ozz;
        if (localObject1 == null) {
          p.gkB();
        }
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).isPlaying())
        {
          ae.i(TAG, "video play, video is playing");
          onVideoPlay();
          AppMethodBeat.o(7455);
          return true;
        }
      }
      if ((this.ozz != null) && (!this.cvl))
      {
        ae.i(TAG, "video play, video not prepared yet, start until prepared");
        this.cvk = true;
        AppMethodBeat.o(7455);
        return true;
      }
      if (this.ozz != null)
      {
        localObject1 = this.ozz;
        if (localObject1 == null) {
          p.gkB();
        }
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).getState() == 5)
        {
          ae.i(TAG, "video play, video has stopped now, try prepare and start when prepared");
          this.cvk = true;
          ae.i(TAG, "video play, media player prepare async");
          prepareAsync();
          AppMethodBeat.o(7455);
          return true;
        }
      }
      Object localObject2;
      if (this.cvt)
      {
        ae.i(TAG, "video play, video has ended playing, clear surface and start again");
        this.cvt = false;
        bTB();
        bTG();
        prepareAsync();
        if (this.ozz != null)
        {
          this.cvk = true;
          localObject1 = TAG;
          localObject2 = this.ozz;
          if (localObject2 == null) {
            p.gkB();
          }
          ae.i((String)localObject1, "video play, media player state:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject2).getState()) });
          prepareAsync();
        }
        AppMethodBeat.o(7455);
        return true;
      }
      if (this.ozz != null)
      {
        localObject1 = this.ozz;
        if (localObject1 == null) {
          p.gkB();
        }
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.c)localObject1).start();
        localObject1 = getBizVideoProfiler();
        if (localObject1 != null)
        {
          localObject1 = ((j.a)localObject1).YL("15");
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
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
    ae.d(TAG, "start timer");
    if (!this.lxR.foU()) {
      stopTimer();
    }
    this.lxR.Dv(ozP);
    AppMethodBeat.o(7446);
  }
  
  protected final void tK(int paramInt)
  {
    AppMethodBeat.i(7443);
    this.gKO.post((Runnable)new MPExoVideoWrapper.ad(this, paramInt));
    AppMethodBeat.o(7443);
  }
  
  final void tO(long paramLong)
  {
    AppMethodBeat.i(7452);
    this.ozO.stopTimer();
    this.ozO.Dv(paramLong);
    AppMethodBeat.o(7452);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class ab
    implements aw.a
  {
    ab(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7416);
      this.ozS.getUiHandler().post(MPExoVideoWrapper.C(this.ozS));
      AppMethodBeat.o(7416);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class c
    implements aw.a
  {
    c(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7388);
      this.ozS.isPlaying();
      if (this.ozS.lxK)
      {
        ae.d(MPExoVideoWrapper.access$getTAG$cp(), "checkTimer onVideoPlay");
        this.ozS.onVideoPlay();
        this.ozS.setPlayOnUiPause(false);
      }
      for (;;)
      {
        AppMethodBeat.o(7388);
        return true;
        this.ozS.tK(this.ozS.getCurrPosSec());
        MPExoVideoWrapper.b(this.ozS, this.ozS.isPlaying());
        MPExoVideoWrapper.B(this.ozS);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onInfo"})
  static final class d
    implements b.e
  {
    d(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean cb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(209169);
      boolean bool = MPExoVideoWrapper.a(this.ozS, paramInt1, paramInt2);
      AppMethodBeat.o(209169);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"})
  static final class e
    implements b.d
  {
    e(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean cc(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(209170);
      MPExoVideoWrapper.b(this.ozS, paramInt1, paramInt2);
      AppMethodBeat.o(209170);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class f
    implements b.f
  {
    f(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(209171);
      MPExoVideoWrapper.r(this.ozS);
      if (MPExoVideoWrapper.s(this.ozS) != null)
      {
        paramb = MPExoVideoWrapper.s(this.ozS);
        if (paramb == null) {
          p.gkB();
        }
        paramb.ds("", "");
      }
      AppMethodBeat.o(209171);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class g
    implements b.b
  {
    g(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void GH()
    {
      AppMethodBeat.i(209172);
      MPExoVideoWrapper.t(this.ozS);
      AppMethodBeat.o(209172);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class h
    implements b.g
  {
    h(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void b(b paramb)
    {
      AppMethodBeat.i(209173);
      MPExoVideoWrapper.u(this.ozS);
      AppMethodBeat.o(209173);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "onVideoSizeChanged"})
  static final class i
    implements b.h
  {
    i(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void a(b paramb, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(209174);
      MPExoVideoWrapper.c(this.ozS, paramInt1, paramInt2);
      AppMethodBeat.o(209174);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "mp", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "kotlin.jvm.PlatformType", "percent", "", "onBufferingUpdate"})
  static final class j
    implements b.a
  {
    j(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void gN(int paramInt)
    {
      AppMethodBeat.i(209175);
      MPExoVideoWrapper.b(this.ozS, paramInt);
      AppMethodBeat.o(209175);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class k
    implements aw.a
  {
    k(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(7396);
      if (this.ozS.getErrorCount() > 0)
      {
        if (this.ozS.isPlaying())
        {
          MPExoVideoWrapper.D(this.ozS);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-brandservice_release"})
  public static final class m
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7402);
      p.h(paramSurfaceTexture, "surface");
      ae.i(MPExoVideoWrapper.access$getTAG$cp(), "on surface texture available, width %d height %d switching %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.ozS.ozM) });
      Object localObject = MPExoVideoWrapper.g(this.ozS);
      if (localObject != null)
      {
        localObject = ((j.a)localObject).YL("9");
        if (localObject != null)
        {
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, "PlayerType", "3");
          if (localObject != null)
          {
            localj = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a((es)localObject, MPExoVideoWrapper.g(this.ozS));
          }
        }
      }
      this.ozS.startTimer();
      localObject = MPExoVideoWrapper.h(this.ozS);
      if (localObject != null) {
        ((MPExoVideoTextureView)localObject).fDh();
      }
      localObject = MPExoVideoWrapper.h(this.ozS);
      if (localObject != null) {
        ((MPExoVideoTextureView)localObject).h(MPExoVideoWrapper.b(this.ozS));
      }
      MPExoVideoWrapper.a(this.ozS, new Surface(paramSurfaceTexture));
      if ((MPExoVideoWrapper.c(this.ozS) == null) || (!MPExoVideoWrapper.d(this.ozS))) {
        if (this.ozS.ozM) {
          this.ozS.V(MPExoVideoWrapper.i(this.ozS), MPExoVideoWrapper.j(this.ozS));
        }
      }
      for (;;)
      {
        if ((!MPExoVideoWrapper.l(this.ozS)) && (this.ozS.ozM)) {
          MPExoVideoWrapper.m(this.ozS);
        }
        AppMethodBeat.o(7402);
        return;
        this.ozS.bTG();
        MPExoVideoWrapper.k(this.ozS);
        continue;
        ae.i(MPExoVideoWrapper.access$getTAG$cp(), "init, setSurface");
        paramSurfaceTexture = MPExoVideoWrapper.c(this.ozS);
        if (paramSurfaceTexture == null) {
          p.gkB();
        }
        paramSurfaceTexture.setSurface(MPExoVideoWrapper.b(this.ozS));
        if (MPExoVideoWrapper.e(this.ozS))
        {
          paramSurfaceTexture = MPExoVideoWrapper.g(this.ozS);
          if (paramSurfaceTexture != null)
          {
            paramSurfaceTexture = paramSurfaceTexture.YL("15");
            if (paramSurfaceTexture != null)
            {
              localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.oxG;
              com.tencent.mm.plugin.brandservice.ui.timeline.video.util.j.a(paramSurfaceTexture, MPExoVideoWrapper.g(this.ozS));
            }
          }
          paramSurfaceTexture = MPExoVideoWrapper.c(this.ozS);
          if (paramSurfaceTexture == null) {
            p.gkB();
          }
          paramSurfaceTexture.start();
        }
        MPExoVideoWrapper.a(this.ozS, false);
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(7401);
      p.h(paramSurfaceTexture, "surface");
      ae.i(MPExoVideoWrapper.access$getTAG$cp(), "on surface texture destroyed");
      MPExoVideoWrapper.a(this.ozS, null);
      if ((MPExoVideoWrapper.c(this.ozS) != null) && (MPExoVideoWrapper.d(this.ozS))) {
        if (this.ozS.isPlaying())
        {
          MPExoVideoWrapper.a(this.ozS, true);
          paramSurfaceTexture = MPExoVideoWrapper.c(this.ozS);
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.pause();
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(7401);
        return false;
        MPExoVideoWrapper.f(this.ozS);
        MPExoVideoWrapper.a(this.ozS, false);
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
      if (this.ozS.getLoading() != null)
      {
        paramSurfaceTexture = this.ozS.getLoading();
        if (paramSurfaceTexture == null) {
          p.gkB();
        }
        if (paramSurfaceTexture.getVisibility() == 0) {
          this.ozS.hideLoading();
        }
      }
      if (MPExoVideoWrapper.a(this.ozS) != null)
      {
        paramSurfaceTexture = MPExoVideoWrapper.a(this.ozS);
        if (paramSurfaceTexture == null) {
          p.gkB();
        }
        if ((paramSurfaceTexture.getVisibility() == 0) && ((this.ozS.isPlaying()) || (this.ozS.getCurrPosSec() != 0))) {
          this.ozS.getUiHandler().post((Runnable)new a(this));
        }
      }
      AppMethodBeat.o(7399);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MPExoVideoWrapper.m paramm) {}
      
      public final void run()
      {
        AppMethodBeat.i(7398);
        ae.d(MPExoVideoWrapper.access$getTAG$cp(), "hide cover onSurfaceTextureUpdated");
        this.ozT.ozS.bTF();
        AppMethodBeat.o(7398);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7404);
      this.ozS.tO(500L);
      this.ozS.tK(this.ozS.getCurrPosSec());
      MPExoVideoWrapper.A(this.ozS);
      AppMethodBeat.o(7404);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(209176);
      if (this.ozS.ozM) {
        MPExoVideoWrapper.n(this.ozS);
      }
      AppMethodBeat.o(209176);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7405);
      MPExoVideoWrapper.n(this.ozS);
      AppMethodBeat.o(7405);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7406);
      ImageView localImageView = MPExoVideoWrapper.o(this.ozS);
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      MPExoVideoWrapper.p(this.ozS);
      AppMethodBeat.o(7406);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7407);
      TextView localTextView = MPExoVideoWrapper.q(this.ozS);
      if (localTextView != null)
      {
        localTextView.setVisibility(8);
        AppMethodBeat.o(7407);
        return;
      }
      AppMethodBeat.o(7407);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class y
    implements Runnable
  {
    y(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    public final void run()
    {
      AppMethodBeat.i(7413);
      MPExoVideoWrapper.v(this.ozS);
      AppMethodBeat.o(7413);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper
 * JD-Core Version:    0.7.0.1
 */