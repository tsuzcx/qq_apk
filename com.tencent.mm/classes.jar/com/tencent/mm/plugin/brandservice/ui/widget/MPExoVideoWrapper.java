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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.fv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ERROR_CHECK_TIME", "", "getERROR_CHECK_TIME", "()I", "ERROR_TRY_AGAIN_DELAY_TIME", "getERROR_TRY_AGAIN_DELAY_TIME", "ERROR_TRY_MAX_TIME", "getERROR_TRY_MAX_TIME", "abTestVideoPreload", "", "getAbTestVideoPreload", "()Z", "abTestVideoPreload$delegate", "Lkotlin/Lazy;", "bandwidthFraction", "", "bizVideoProfiler", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "getBizVideoProfiler", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoProfiler$Instance;", "cacheTimeSec", "getCacheTimeSec", "callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getCheckTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "setCheckTimer", "(Lcom/tencent/mm/sdk/platformtools/MTimerHandler;)V", "currPosMs", "getCurrPosMs", "currPosSec", "getCurrPosSec", "downloadPercent", "durationSec", "errorCheckTimer", "getErrorCheckTimer", "setErrorCheckTimer", "errorCount", "getErrorCount", "setErrorCount", "(I)V", "footerView", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoFooter;", "hasExoParam", "inBackGround", "isControllerBarShowing", "setControllerBarShowing", "(Z)V", "isInFullScreen", "isLive", "setLive", "isPlayOnUiPause", "setPlayOnUiPause", "isPlaying", "isSwitchingResolution", "setSwitchingResolution", "isUIAvailable", "setUIAvailable", "lastSeekAutoPlay", "lastSeekTime", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "localIsPlaying", "mAudioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "mCoverIv", "Landroid/widget/ImageView;", "mFirstRenderStartTime", "", "mFooterContainer", "Landroid/widget/LinearLayout;", "mLastUpdateBuffer", "mMediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/ExoMediaPlayer;", "mMediaPlayerAvailable", "mPlayingBeforeBuffering", "mPlayingBeforeSeeking", "mPlayingWhenBackground", "mStartSeekPosition", "mStartWhenPrepared", "mStartWhenSeekCompleted", "mSurface", "Landroid/view/Surface;", "mSwitchCoverIv", "mSwitchTitleTextView", "Landroid/widget/TextView;", "mVideoDuration", "mVideoHasEndedPlaying", "mVideoHasPrepared", "mVideoHeight", "mVideoLooping", "mVideoPath", "", "mVideoProxyUrl", "mVideoSource", "getMVideoSource", "setMVideoSource", "mVideoTextureView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoTextureView;", "mVideoWidth", "maxBufferMs", "maxDurForQualityMs", "maxInitialBitrate", "minBufferMs", "minDurForQualityMs", "mute", "needShowSwitchTitleTextView", "getNeedShowSwitchTitleTextView", "setNeedShowSwitchTitleTextView", "pauseByDestroyed", "resolutionStr", "showLoadingRunning", "Ljava/lang/Runnable;", "showLoadingTimer", "getShowLoadingTimer", "setShowLoadingTimer", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getUiHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setUiHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "videoDurationMs", "getVideoDurationMs", "videoDurationSec", "getVideoDurationSec", "videoHeight", "getVideoHeight", "videoWidth", "getVideoWidth", "adjustObjectFit", "", "applyMediaPlayerParams", "checkExoPlayerParam", "checkVideoUrl", "clearSurface", "createMediaPlayer", "enterFullScreen", "gain", "getCoverIv", "getFirstRenderTime", "hideCover", "hideLoading", "init", "isNeedToPlay", "isShowingLoading", "isSwitchTitleTextViewShowing", "loss", "lossTransient", "lossTransientCanDuck", "onControllerBarVisible", "visible", "onError", "what", "extra", "onMediaPlayerBufferingUpdate", "percent", "onMediaPlayerCompletion", "onMediaPlayerInfo", "onMediaPlayerPrepared", "onMediaPlayerSeekComplete", "onMediaPlayerVideoSizeChanged", "width", "height", "onPlayDoSwitchEnd", "onSeekEnd", "onSetResolution", "onSwitchEnd", "onSwitchEndShowSuccessWording", "onUIDestroy", "onUIPause", "onUIResume", "onVideoLoadedMetaData", "duration", "onVideoPause", "onVideoPlay", "onVideoProgress", "onVideoWaiting", "onVideoWaitingEnd", "pause", "prepareAsync", "quitFullScreen", "releaseMediaPlayer", "releaseSurface", "reset", "resetErrorCount", "resetMediaPlayer", "resetResolutionStatus", "restartVideo", "seekPosition", "play", "retryWhenError", "seekTo", "ms", "afterPlay", "setDataSourceWithCustomKey", "url", "setExoPlayerParam", "setIMMVideoViewCallback", "_callback", "setKeepScreenOn", "keepScreenOn", "setMute", "_mute", "setSwitchSpeedCover", "setVideoFooterView", "_footerView", "setVideoPath", "_isLive", "_url", "_durationSec", "setVideoSource", "videoSource", "setVideoTotalTime", "seconds", "showCover", "showLoading", "showLoadingDelayed", "delayMillis", "start", "startErrorCheckTimer", "startTimer", "stop", "stopErrorCheckTimer", "stopTimer", "tryPreloadVideo", "unKown", "updateUI", "currPlaySec", "updateVideoStatus", "isPlay", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MPExoVideoWrapper
  extends RelativeLayout
  implements d.a
{
  static final String TAG;
  private static final int vZL;
  private static final int vZM = 0;
  public static final MPExoVideoWrapper.a vZk;
  private boolean ddk;
  private int dhq;
  private float dhu;
  private int diT;
  private int eDA;
  private int eDB;
  private String eDC;
  private boolean eDE;
  private boolean eDq;
  private boolean eDr;
  private boolean eDs;
  private boolean eDv;
  private boolean eDw;
  private boolean eDx;
  private final boolean eDy;
  private MMHandler mRi;
  private Surface mSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  private boolean nLP;
  private boolean qyS;
  private int sAo;
  private int sGk;
  private int sGl;
  private int sGm;
  private int sGn;
  private int sIA;
  private boolean sIK;
  private boolean sIU;
  private ProgressBar sIX;
  private boolean sJg;
  private MTimerHandler sJn;
  private MTimerHandler sJp;
  private final Runnable sJs;
  ImageView szA;
  private int szV;
  private boolean vZA;
  private boolean vZB;
  private int vZC;
  private boolean vZD;
  private long vZE;
  private boolean vZF;
  private boolean vZG;
  boolean vZH;
  private boolean vZI;
  private MTimerHandler vZJ;
  private final kotlin.j vZK;
  private final int vZl;
  private final int vZm;
  private final int vZn;
  private LinearLayout vZo;
  private ImageView vZp;
  private TextView vZq;
  private com.tencent.mm.pluginsdk.ui.h vZr;
  private String vZs;
  private MPExoVideoTextureView vZt;
  private com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j vZu;
  private i.b vZv;
  private final d vZw;
  private String vZx;
  private boolean vZy;
  private int vZz;
  
  static
  {
    AppMethodBeat.i(7467);
    vZk = new MPExoVideoWrapper.a((byte)0);
    TAG = "MicroMsg.MPExoVideoWrapper";
    vZL = 500;
    AppMethodBeat.o(7467);
  }
  
  public MPExoVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(7466);
    this.vZl = 5000;
    this.vZm = 200;
    this.vZn = 5;
    this.mRi = new MMHandler(Looper.getMainLooper());
    paramContext = new d();
    s.s(paramContext, "createTool()");
    this.vZw = paramContext;
    this.szV = vZM;
    this.sIU = true;
    this.dhq = 800000;
    this.dhu = 0.75F;
    this.sGk = 10000;
    this.sGl = 25000;
    this.sGm = 15000;
    this.sGn = 30000;
    this.sJn = new MTimerHandler(new MPExoVideoWrapper..ExternalSyntheticLambda7(this), true);
    LayoutInflater.from(getContext()).inflate(d.f.mp_video_view, (ViewGroup)this);
    this.vZt = ((MPExoVideoTextureView)findViewById(d.e.mp_video_textureView));
    this.sIX = ((ProgressBar)findViewById(d.e.video_loading));
    this.vZo = ((LinearLayout)findViewById(d.e.video_footer_root));
    this.szA = ((ImageView)findViewById(d.e.mp_video_cover_iv));
    this.vZp = ((ImageView)findViewById(d.e.mp_video_switch_cover_iv));
    this.vZq = ((TextView)findViewById(d.e.switch_resolution_title));
    paramContext = this.vZt;
    s.checkNotNull(paramContext);
    paramContext.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new c(this));
    this.sJs = new MPExoVideoWrapper..ExternalSyntheticLambda12(this);
    this.vZJ = new MTimerHandler(new MPExoVideoWrapper..ExternalSyntheticLambda9(this), false);
    this.sJp = new MTimerHandler(new MPExoVideoWrapper..ExternalSyntheticLambda8(this), true);
    this.vZK = k.cm((kotlin.g.a.a)MPExoVideoWrapper.b.vZN);
    AppMethodBeat.o(7466);
  }
  
  private void Bt(int paramInt)
  {
    AppMethodBeat.i(7443);
    this.mRi.post(new MPExoVideoWrapper..ExternalSyntheticLambda23(this, paramInt));
    AppMethodBeat.o(7443);
  }
  
  private static final void a(MPExoVideoWrapper paramMPExoVideoWrapper, int paramInt)
  {
    AppMethodBeat.i(301852);
    s.u(paramMPExoVideoWrapper, "this$0");
    paramMPExoVideoWrapper = paramMPExoVideoWrapper.vZr;
    s.checkNotNull(paramMPExoVideoWrapper);
    paramMPExoVideoWrapper.Bh(paramInt);
    AppMethodBeat.o(301852);
  }
  
  private static final void a(MPExoVideoWrapper paramMPExoVideoWrapper, g paramg)
  {
    AppMethodBeat.i(301821);
    s.u(paramMPExoVideoWrapper, "this$0");
    if (!paramMPExoVideoWrapper.eDx) {
      Log.i(TAG, "onMediaPlayerPrepared, mp released");
    }
    for (;;)
    {
      if (paramMPExoVideoWrapper.vZv != null)
      {
        paramMPExoVideoWrapper = paramMPExoVideoWrapper.vZv;
        s.checkNotNull(paramMPExoVideoWrapper);
        paramMPExoVideoWrapper.el("", "");
      }
      AppMethodBeat.o(301821);
      return;
      if (paramMPExoVideoWrapper.diT > 0)
      {
        Log.d(TAG, "start error check timer");
        paramMPExoVideoWrapper.sJp.startTimer(paramMPExoVideoWrapper.vZl);
      }
      Log.i(TAG, "onPrepared");
      paramMPExoVideoWrapper.eDw = true;
      paramMPExoVideoWrapper.dif();
      paramMPExoVideoWrapper.setVideoTotalTime(paramMPExoVideoWrapper.getVideoDurationSec());
      paramMPExoVideoWrapper.hideLoading();
      if (paramMPExoVideoWrapper.vZE != 0L) {
        Log.i(TAG, "onPrepared, costTime:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - paramMPExoVideoWrapper.vZE) });
      }
      paramg = paramMPExoVideoWrapper.getBizVideoProfiler();
      if (paramg != null)
      {
        paramg = paramg.akb("14");
        if (paramg != null)
        {
          com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.vYg;
          com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.a(paramg, paramMPExoVideoWrapper.getBizVideoProfiler());
        }
      }
      int i = paramMPExoVideoWrapper.vZz;
      if (i > 0)
      {
        Log.i(TAG, s.X("onPrepared, seekToPosition ", Integer.valueOf(i)));
        paramMPExoVideoWrapper.as(i, paramMPExoVideoWrapper.vZD);
        paramMPExoVideoWrapper.vZz = 0;
      }
      if (!paramMPExoVideoWrapper.vZA)
      {
        if (paramMPExoVideoWrapper.eDv)
        {
          Log.i(TAG, "onPrepared, start play when prepared");
          paramMPExoVideoWrapper.start();
        }
        else
        {
          Log.i(TAG, "onPrepared, not set start play when prepared");
        }
      }
      else
      {
        Log.i(TAG, "onPrepared, stop video auto play when webview in background");
        paramMPExoVideoWrapper.vZy = paramMPExoVideoWrapper.eDv;
      }
    }
  }
  
  private static final void a(MPExoVideoWrapper paramMPExoVideoWrapper, g paramg, int paramInt)
  {
    AppMethodBeat.i(301839);
    s.u(paramMPExoVideoWrapper, "this$0");
    if (!paramMPExoVideoWrapper.eDx)
    {
      Log.i(TAG, "onMediaPlayerBufferingUpdate, mp released");
      AppMethodBeat.o(301839);
      return;
    }
    if (paramInt != paramMPExoVideoWrapper.eDB)
    {
      paramMPExoVideoWrapper.eDB = paramInt;
      Log.i(TAG, "onBufferingUpdate, percent:%s", new Object[] { Integer.valueOf(paramInt) });
    }
    if (paramMPExoVideoWrapper.eDw) {
      paramMPExoVideoWrapper.sIA = paramInt;
    }
    AppMethodBeat.o(301839);
  }
  
  private static final void a(MPExoVideoWrapper paramMPExoVideoWrapper, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(301918);
    s.u(paramMPExoVideoWrapper, "this$0");
    s.u(paramString, "$errorTips");
    paramMPExoVideoWrapper.stop();
    paramMPExoVideoWrapper.hideLoading();
    if (paramMPExoVideoWrapper.vZv != null)
    {
      paramMPExoVideoWrapper = paramMPExoVideoWrapper.vZv;
      s.checkNotNull(paramMPExoVideoWrapper);
      paramMPExoVideoWrapper.d("", "", paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(301918);
  }
  
  private static final void a(MPExoVideoWrapper paramMPExoVideoWrapper, boolean paramBoolean)
  {
    AppMethodBeat.i(301856);
    s.u(paramMPExoVideoWrapper, "this$0");
    paramMPExoVideoWrapper = paramMPExoVideoWrapper.vZr;
    s.checkNotNull(paramMPExoVideoWrapper);
    paramMPExoVideoWrapper.jJ(paramBoolean);
    AppMethodBeat.o(301856);
  }
  
  private static final boolean a(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    AppMethodBeat.i(301794);
    s.u(paramMPExoVideoWrapper, "this$0");
    paramMPExoVideoWrapper.isPlaying();
    if (paramMPExoVideoWrapper.sJg)
    {
      Log.d(TAG, "checkTimer onVideoPlay");
      paramMPExoVideoWrapper.onVideoPlay();
      paramMPExoVideoWrapper.setPlayOnUiPause(false);
    }
    for (;;)
    {
      AppMethodBeat.o(301794);
      return true;
      paramMPExoVideoWrapper.Bt(paramMPExoVideoWrapper.getCurrPosSec());
      paramMPExoVideoWrapper.jJ(paramMPExoVideoWrapper.isPlaying());
      if (paramMPExoVideoWrapper.vZH) {
        paramMPExoVideoWrapper.mRi.postDelayed(new MPExoVideoWrapper..ExternalSyntheticLambda14(paramMPExoVideoWrapper), 3000L);
      }
    }
  }
  
  private static final boolean a(MPExoVideoWrapper paramMPExoVideoWrapper, g paramg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(301810);
    s.u(paramMPExoVideoWrapper, "this$0");
    if (!paramMPExoVideoWrapper.eDx) {
      Log.i(TAG, "onMediaPlayerInfo, mp released");
    }
    for (;;)
    {
      AppMethodBeat.o(301810);
      return false;
      Log.i(TAG, "onInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 == 701)
      {
        paramg = paramMPExoVideoWrapper.vZu;
        if (paramg != null) {
          paramMPExoVideoWrapper.eDs = paramg.isPlaying();
        }
        Log.i(TAG, "onInfo, buffering start, isPlayingBeforeBuffering:%b", new Object[] { Boolean.valueOf(paramMPExoVideoWrapper.eDs) });
        paramMPExoVideoWrapper.die();
      }
      else
      {
        if (paramInt1 == 702)
        {
          boolean bool;
          if (paramMPExoVideoWrapper.vZu != null)
          {
            paramg = paramMPExoVideoWrapper.vZu;
            s.checkNotNull(paramg);
            bool = paramg.isPlaying();
            label147:
            Log.i(TAG, "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying", new Object[] { Boolean.valueOf(paramMPExoVideoWrapper.eDs), Boolean.valueOf(bool) });
            if (!paramMPExoVideoWrapper.eDs) {
              break label221;
            }
            paramMPExoVideoWrapper.eDs = false;
            if (bool)
            {
              Log.i(TAG, "onInfo, buffering end, notify video play");
              paramMPExoVideoWrapper.onVideoPlay();
            }
          }
          for (;;)
          {
            paramMPExoVideoWrapper.hideLoading();
            break;
            bool = false;
            break label147;
            label221:
            if (!bool)
            {
              Log.i(TAG, "onInfo, buffering end, notify video pause");
              paramMPExoVideoWrapper.onVideoPause();
            }
          }
        }
        if (paramInt2 == -1004)
        {
          Log.i(TAG, "onInfo, special error, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          paramMPExoVideoWrapper.onError(paramInt1, paramInt2);
        }
      }
    }
  }
  
  private void as(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(7448);
    this.vZD = paramBoolean;
    int j = getVideoDurationMs();
    int i = paramInt;
    if (j > 100)
    {
      i = paramInt;
      if (paramInt > j) {
        i = j;
      }
    }
    if ((this.eDw) && (this.vZu != null))
    {
      this.eDr = did();
      Log.d(TAG, "seekTo mPlayingBeforeSeeking %b, afterPlay %b, seekTime %d", new Object[] { Boolean.valueOf(this.eDr), Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j localj;
      if (!paramBoolean)
      {
        localj = this.vZu;
        s.checkNotNull(localj);
        localj.pause();
      }
      for (;;)
      {
        if ((j != i) && (i > 0)) {
          this.eDE = false;
        }
        localj = this.vZu;
        s.checkNotNull(localj);
        localj.q(i, paramBoolean);
        this.vZC = i;
        die();
        Bt(i / 1000);
        AppMethodBeat.o(7448);
        return;
        startTimer();
      }
    }
    this.vZz = i;
    AppMethodBeat.o(7448);
  }
  
  private final void auC()
  {
    try
    {
      AppMethodBeat.i(7435);
      if (this.vZu != null)
      {
        Log.i(TAG, "releaseMediaPlayer");
        com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j localj = this.vZu;
        s.checkNotNull(localj);
        localj.a(null);
        localj = this.vZu;
        s.checkNotNull(localj);
        localj.a(null);
        localj = this.vZu;
        s.checkNotNull(localj);
        localj.a(null);
        localj = this.vZu;
        s.checkNotNull(localj);
        localj.a(null);
        localj = this.vZu;
        s.checkNotNull(localj);
        localj.a(null);
        localj = this.vZu;
        s.checkNotNull(localj);
        localj.a(null);
        localj = this.vZu;
        s.checkNotNull(localj);
        localj.stop();
        localj = this.vZu;
        s.checkNotNull(localj);
        localj.reset();
        localj = this.vZu;
        s.checkNotNull(localj);
        localj.release();
      }
      this.vZu = null;
      this.eDx = false;
      AppMethodBeat.o(7435);
      return;
    }
    finally {}
  }
  
  private final void auE()
  {
    AppMethodBeat.i(7438);
    if (this.vZu != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j localj = this.vZu;
      s.checkNotNull(localj);
      localj.setMute(this.nLP);
      if (this.mSurface != null)
      {
        localj = this.vZu;
        s.checkNotNull(localj);
        localj.setSurface(this.mSurface);
      }
    }
    AppMethodBeat.o(7438);
  }
  
  private static final void b(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    AppMethodBeat.i(301798);
    s.u(paramMPExoVideoWrapper, "this$0");
    paramMPExoVideoWrapper.dia();
    AppMethodBeat.o(301798);
  }
  
  private static final void b(MPExoVideoWrapper paramMPExoVideoWrapper, int paramInt)
  {
    AppMethodBeat.i(301861);
    s.u(paramMPExoVideoWrapper, "this$0");
    if (paramMPExoVideoWrapper.vZr != null)
    {
      com.tencent.mm.pluginsdk.ui.h localh = paramMPExoVideoWrapper.vZr;
      s.checkNotNull(localh);
      if (localh.getVideoTotalTime() != paramInt)
      {
        paramMPExoVideoWrapper = paramMPExoVideoWrapper.vZr;
        s.checkNotNull(paramMPExoVideoWrapper);
        paramMPExoVideoWrapper.setVideoTotalTime(paramInt);
      }
    }
    AppMethodBeat.o(301861);
  }
  
  private static final void b(MPExoVideoWrapper paramMPExoVideoWrapper, g paramg)
  {
    AppMethodBeat.i(301824);
    s.u(paramMPExoVideoWrapper, "this$0");
    if (!paramMPExoVideoWrapper.eDx)
    {
      Log.i(TAG, "onMediaPlayerCompletion, mp released");
      AppMethodBeat.o(301824);
      return;
    }
    Log.i(TAG, "onCompletion");
    if (paramMPExoVideoWrapper.vZv != null)
    {
      paramg = paramMPExoVideoWrapper.vZv;
      s.checkNotNull(paramg);
      paramg.em("", "");
    }
    if (paramMPExoVideoWrapper.eDy)
    {
      Log.i(TAG, "onCompletion, video loop playing");
      paramMPExoVideoWrapper.eDq = true;
      paramMPExoVideoWrapper.as(0, true);
      AppMethodBeat.o(301824);
      return;
    }
    Log.i(TAG, "onCompletion, video end playing");
    paramMPExoVideoWrapper.vZB = false;
    paramMPExoVideoWrapper.eDE = true;
    paramMPExoVideoWrapper.jJ(false);
    paramMPExoVideoWrapper.stopTimer();
    paramMPExoVideoWrapper.as(0, false);
    AppMethodBeat.o(301824);
  }
  
  private static final void b(MPExoVideoWrapper paramMPExoVideoWrapper, boolean paramBoolean)
  {
    AppMethodBeat.i(301903);
    s.u(paramMPExoVideoWrapper, "this$0");
    paramMPExoVideoWrapper.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(301903);
  }
  
  private static final boolean b(MPExoVideoWrapper paramMPExoVideoWrapper, g paramg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(301817);
    s.u(paramMPExoVideoWrapper, "this$0");
    paramMPExoVideoWrapper.onError(paramInt1, paramInt2);
    AppMethodBeat.o(301817);
    return false;
  }
  
  private static final void c(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    AppMethodBeat.i(301801);
    s.u(paramMPExoVideoWrapper, "this$0");
    if (paramMPExoVideoWrapper.vZH) {
      paramMPExoVideoWrapper.dia();
    }
    AppMethodBeat.o(301801);
  }
  
  private static final void c(MPExoVideoWrapper paramMPExoVideoWrapper, g paramg)
  {
    AppMethodBeat.i(301830);
    s.u(paramMPExoVideoWrapper, "this$0");
    paramMPExoVideoWrapper.mRi.post(new MPExoVideoWrapper..ExternalSyntheticLambda20(paramMPExoVideoWrapper));
    if (!paramMPExoVideoWrapper.eDx)
    {
      Log.i(TAG, "onMediaPlayerSeekComplete, mp released");
      AppMethodBeat.o(301830);
      return;
    }
    Log.i(TAG, "onSeekComplete");
    paramMPExoVideoWrapper.hideLoading();
    if ((paramMPExoVideoWrapper.eDq) || (paramMPExoVideoWrapper.eDr)) {}
    for (boolean bool = true;; bool = false)
    {
      paramMPExoVideoWrapper.jJ(bool);
      paramMPExoVideoWrapper.Bt(paramMPExoVideoWrapper.getCurrPosSec());
      if (!paramMPExoVideoWrapper.eDq) {
        break;
      }
      Log.i(TAG, "onSeekComplete, start when seek complete");
      paramMPExoVideoWrapper.eDq = false;
      paramMPExoVideoWrapper.startTimer();
      paramMPExoVideoWrapper.start();
      AppMethodBeat.o(301830);
      return;
    }
    paramg = paramMPExoVideoWrapper.vZu;
    s.checkNotNull(paramg);
    bool = paramg.isPlaying();
    if (paramMPExoVideoWrapper.eDr)
    {
      paramg = TAG;
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j localj = paramMPExoVideoWrapper.vZu;
      s.checkNotNull(localj);
      int i = localj.getCurrentPosition();
      localj = paramMPExoVideoWrapper.vZu;
      s.checkNotNull(localj);
      Log.i(paramg, "onSeekComplete, video playing before seeking, isCurrentPlaying:%b, position:%s, duration:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(localj.getDuration()) });
      paramMPExoVideoWrapper.eDr = false;
      paramg = paramMPExoVideoWrapper.vZu;
      s.checkNotNull(paramg);
      i = paramg.getCurrentPosition() / 1000;
      paramg = paramMPExoVideoWrapper.vZu;
      s.checkNotNull(paramg);
      if (i < paramg.getDuration() / 1000)
      {
        Log.i(TAG, "onSeekComplete, video not end");
        if (bool)
        {
          Log.i(TAG, "onSeekComplete, dispatch play again");
          paramMPExoVideoWrapper.onVideoPlay();
          AppMethodBeat.o(301830);
          return;
        }
        paramMPExoVideoWrapper = paramMPExoVideoWrapper.vZu;
        s.checkNotNull(paramMPExoVideoWrapper);
        paramMPExoVideoWrapper.start();
        AppMethodBeat.o(301830);
        return;
      }
      Log.i(TAG, "onSeekComplete, video ends");
      paramg = paramMPExoVideoWrapper.vZu;
      s.checkNotNull(paramg);
      paramg.pause();
      paramMPExoVideoWrapper = paramMPExoVideoWrapper.vZu;
      s.checkNotNull(paramMPExoVideoWrapper);
      paramMPExoVideoWrapper.start();
      AppMethodBeat.o(301830);
      return;
    }
    Log.i(TAG, "onSeekComplete, video not playing before seeking, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      Log.i(TAG, "onSeekComplete, dispatch pause again");
      paramMPExoVideoWrapper.onVideoPause();
    }
    AppMethodBeat.o(301830);
  }
  
  private static final void c(MPExoVideoWrapper paramMPExoVideoWrapper, g paramg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(301836);
    s.u(paramMPExoVideoWrapper, "this$0");
    if (!paramMPExoVideoWrapper.eDx)
    {
      Log.i(TAG, "onMediaPlayerVideoSizeChanged, mp released");
      AppMethodBeat.o(301836);
      return;
    }
    Log.i(TAG, "onVideoSizeChanged, width:%d, height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    int i = paramMPExoVideoWrapper.getVideoDurationSec();
    paramg = paramMPExoVideoWrapper.vZv;
    if (paramg != null) {
      paramg.e("", "", paramInt1, paramInt2);
    }
    paramMPExoVideoWrapper.mVideoWidth = paramInt1;
    paramMPExoVideoWrapper.mVideoHeight = paramInt2;
    paramMPExoVideoWrapper.eDA = i;
    paramMPExoVideoWrapper.dif();
    AppMethodBeat.o(301836);
  }
  
  private static final void d(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    AppMethodBeat.i(301807);
    s.u(paramMPExoVideoWrapper, "this$0");
    Object localObject = paramMPExoVideoWrapper.vZp;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    if (paramMPExoVideoWrapper.vZs != null)
    {
      localObject = paramMPExoVideoWrapper.vZq;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)paramMPExoVideoWrapper.getContext().getString(d.i.mp_video_switch_finish, new Object[] { paramMPExoVideoWrapper.vZs }));
      }
      paramMPExoVideoWrapper.mRi.postDelayed(new MPExoVideoWrapper..ExternalSyntheticLambda17(paramMPExoVideoWrapper), 1500L);
      AppMethodBeat.o(301807);
      return;
    }
    Log.w(TAG, "resolutionStr is null");
    paramMPExoVideoWrapper = paramMPExoVideoWrapper.vZq;
    if (paramMPExoVideoWrapper != null) {
      paramMPExoVideoWrapper.setVisibility(8);
    }
    AppMethodBeat.o(301807);
  }
  
  private final void dhZ()
  {
    AppMethodBeat.i(7436);
    if ((this.mSurface != null) && (this.eDw))
    {
      MPExoVideoTextureView localMPExoVideoTextureView = this.vZt;
      if (localMPExoVideoTextureView != null) {
        localMPExoVideoTextureView.dhZ();
      }
    }
    AppMethodBeat.o(7436);
  }
  
  private final void dia()
  {
    int j = 0;
    AppMethodBeat.i(301712);
    this.vZH = false;
    ImageView localImageView = this.vZp;
    int i = j;
    if (localImageView != null)
    {
      i = j;
      if (localImageView.getVisibility() == 0) {
        i = 1;
      }
    }
    if (i != 0) {
      this.mRi.post(new MPExoVideoWrapper..ExternalSyntheticLambda19(this));
    }
    AppMethodBeat.o(301712);
  }
  
  private final void dic()
  {
    AppMethodBeat.i(7439);
    if (this.vZu != null)
    {
      AppMethodBeat.o(7439);
      return;
    }
    Log.i(TAG, "createMediaPlayer");
    this.sIA = 0;
    Object localObject;
    float f;
    if (this.vZF)
    {
      localj = new com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j(this.dhq, this.dhu, this.sGk, this.sGl, this.sGm, this.sGn);
      this.vZu = localj;
      localj = this.vZu;
      s.checkNotNull(localj);
      localj.mIsLooping = this.eDy;
      localj = this.vZu;
      s.checkNotNull(localj);
      localObject = a.vZP;
      localObject = a.dig();
      if (localObject != null) {
        break label175;
      }
      f = 1.0F;
      label121:
      localj.bN(f);
      if (this.vZu == null) {
        break label184;
      }
    }
    label175:
    label184:
    for (boolean bool = true;; bool = false)
    {
      this.eDx = bool;
      if (this.eDx) {
        break label189;
      }
      Log.e(TAG, "createMediaPlayer, create media player fail");
      AppMethodBeat.o(7439);
      return;
      localj = new com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j();
      break;
      f = ((a.a)localObject).vZS;
      break label121;
    }
    label189:
    com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j localj = this.vZu;
    s.checkNotNull(localj);
    localj.a(new MPExoVideoWrapper..ExternalSyntheticLambda3(this));
    localj = this.vZu;
    s.checkNotNull(localj);
    localj.a(new MPExoVideoWrapper..ExternalSyntheticLambda2(this));
    localj = this.vZu;
    s.checkNotNull(localj);
    localj.a(new MPExoVideoWrapper..ExternalSyntheticLambda4(this));
    localj = this.vZu;
    s.checkNotNull(localj);
    localj.a(new MPExoVideoWrapper..ExternalSyntheticLambda1(this));
    localj = this.vZu;
    s.checkNotNull(localj);
    localj.a(new MPExoVideoWrapper..ExternalSyntheticLambda5(this));
    localj = this.vZu;
    s.checkNotNull(localj);
    localj.a(new MPExoVideoWrapper..ExternalSyntheticLambda6(this));
    localj = this.vZu;
    s.checkNotNull(localj);
    localj.a(new MPExoVideoWrapper..ExternalSyntheticLambda0(this));
    if (!Util.isNullOrNil(this.eDC))
    {
      if ((Util.isNullOrNil(this.vZx)) && (com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().sAx) && (com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().sAy)) {
        this.vZx = com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().cd(this.eDC);
      }
      if (!Util.isNullOrNil(this.vZx))
      {
        setDataSourceWithCustomKey(this.vZx);
        AppMethodBeat.o(7439);
        return;
      }
      setDataSourceWithCustomKey(this.eDC);
    }
    AppMethodBeat.o(7439);
  }
  
  private boolean did()
  {
    AppMethodBeat.i(7450);
    if ((this.vZB) || (isPlaying()) || (this.eDr) || (this.eDq))
    {
      AppMethodBeat.o(7450);
      return true;
    }
    AppMethodBeat.o(7450);
    return false;
  }
  
  private void die()
  {
    AppMethodBeat.i(301746);
    this.vZJ.stopTimer();
    this.vZJ.startTimer(500L);
    AppMethodBeat.o(301746);
  }
  
  private final void dif()
  {
    AppMethodBeat.i(7463);
    this.mRi.post(new MPExoVideoWrapper..ExternalSyntheticLambda22(this));
    AppMethodBeat.o(7463);
  }
  
  private static final void e(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    AppMethodBeat.i(301808);
    s.u(paramMPExoVideoWrapper, "this$0");
    paramMPExoVideoWrapper = paramMPExoVideoWrapper.vZq;
    if (paramMPExoVideoWrapper != null) {
      paramMPExoVideoWrapper.setVisibility(8);
    }
    AppMethodBeat.o(301808);
  }
  
  private static final void f(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    AppMethodBeat.i(301867);
    s.u(paramMPExoVideoWrapper, "this$0");
    if (paramMPExoVideoWrapper.getLoading() != null)
    {
      ProgressBar localProgressBar = paramMPExoVideoWrapper.getLoading();
      s.checkNotNull(localProgressBar);
      if (localProgressBar.getVisibility() != 0)
      {
        Log.i(TAG, "show loading");
        localProgressBar = paramMPExoVideoWrapper.getLoading();
        if (localProgressBar != null) {
          localProgressBar.setVisibility(0);
        }
        paramMPExoVideoWrapper.mRi.post(new MPExoVideoWrapper..ExternalSyntheticLambda16(paramMPExoVideoWrapper));
      }
    }
    AppMethodBeat.o(301867);
  }
  
  private static final boolean g(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    AppMethodBeat.i(301869);
    s.u(paramMPExoVideoWrapper, "this$0");
    paramMPExoVideoWrapper.getUiHandler().post(paramMPExoVideoWrapper.sJs);
    AppMethodBeat.o(301869);
    return false;
  }
  
  private final boolean getAbTestVideoPreload()
  {
    AppMethodBeat.i(301782);
    boolean bool = ((Boolean)this.vZK.getValue()).booleanValue();
    AppMethodBeat.o(301782);
    return bool;
  }
  
  private final com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.a getBizVideoProfiler()
  {
    AppMethodBeat.i(301710);
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.vYg;
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.aka(getContext().toString());
    AppMethodBeat.o(301710);
    return localObject;
  }
  
  private static final void h(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    AppMethodBeat.i(301874);
    s.u(paramMPExoVideoWrapper, "this$0");
    if (paramMPExoVideoWrapper.getLoading() != null)
    {
      ProgressBar localProgressBar = paramMPExoVideoWrapper.getLoading();
      s.checkNotNull(localProgressBar);
      if (localProgressBar.getVisibility() != 8)
      {
        Log.i(TAG, "hide loading");
        localProgressBar = paramMPExoVideoWrapper.getLoading();
        if (localProgressBar != null) {
          localProgressBar.setVisibility(8);
        }
        paramMPExoVideoWrapper.mRi.postDelayed(new MPExoVideoWrapper..ExternalSyntheticLambda10(paramMPExoVideoWrapper), 500L);
      }
    }
    AppMethodBeat.o(301874);
  }
  
  private static final void i(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    AppMethodBeat.i(301877);
    s.u(paramMPExoVideoWrapper, "this$0");
    Log.i(TAG, "video stop");
    paramMPExoVideoWrapper.Bt(0);
    paramMPExoVideoWrapper.jJ(false);
    paramMPExoVideoWrapper.auC();
    paramMPExoVideoWrapper.onVideoPause();
    AppMethodBeat.o(301877);
  }
  
  private static final void j(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    AppMethodBeat.i(301882);
    s.u(paramMPExoVideoWrapper, "this$0");
    paramMPExoVideoWrapper.setKeepScreenOn(false);
    paramMPExoVideoWrapper.vZw.gR(false);
    if (paramMPExoVideoWrapper.vZv != null)
    {
      paramMPExoVideoWrapper = paramMPExoVideoWrapper.vZv;
      s.checkNotNull(paramMPExoVideoWrapper);
      paramMPExoVideoWrapper.en("", "");
    }
    AppMethodBeat.o(301882);
  }
  
  private final void jJ(boolean paramBoolean)
  {
    AppMethodBeat.i(7444);
    this.mRi.post(new MPExoVideoWrapper..ExternalSyntheticLambda26(this, paramBoolean));
    AppMethodBeat.o(7444);
  }
  
  private static final void k(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    AppMethodBeat.i(301888);
    s.u(paramMPExoVideoWrapper, "this$0");
    paramMPExoVideoWrapper.setKeepScreenOn(true);
    paramMPExoVideoWrapper.vZw.a((d.a)paramMPExoVideoWrapper);
    if (paramMPExoVideoWrapper.vZv != null)
    {
      i.b localb = paramMPExoVideoWrapper.vZv;
      s.checkNotNull(localb);
      localb.eo("", "");
    }
    paramMPExoVideoWrapper.jJ(true);
    paramMPExoVideoWrapper.startTimer();
    AppMethodBeat.o(301888);
  }
  
  private static final void l(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    AppMethodBeat.i(301894);
    s.u(paramMPExoVideoWrapper, "this$0");
    if (paramMPExoVideoWrapper.vZv != null)
    {
      paramMPExoVideoWrapper = paramMPExoVideoWrapper.vZv;
      s.checkNotNull(paramMPExoVideoWrapper);
      paramMPExoVideoWrapper.ep("", "");
    }
    AppMethodBeat.o(301894);
  }
  
  private static final void m(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    AppMethodBeat.i(301900);
    s.u(paramMPExoVideoWrapper, "this$0");
    if (paramMPExoVideoWrapper.vZv != null)
    {
      paramMPExoVideoWrapper = paramMPExoVideoWrapper.vZv;
      s.checkNotNull(paramMPExoVideoWrapper);
      paramMPExoVideoWrapper.eq("", "");
    }
    AppMethodBeat.o(301900);
  }
  
  private static final void n(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    AppMethodBeat.i(301911);
    s.u(paramMPExoVideoWrapper, "this$0");
    MPExoVideoTextureView localMPExoVideoTextureView = paramMPExoVideoWrapper.vZt;
    if (localMPExoVideoTextureView != null)
    {
      int i = paramMPExoVideoWrapper.mVideoWidth;
      int j = paramMPExoVideoWrapper.mVideoHeight;
      localMPExoVideoTextureView.mVideoWidth = i;
      localMPExoVideoTextureView.mVideoHeight = j;
    }
    localMPExoVideoTextureView = paramMPExoVideoWrapper.vZt;
    if (localMPExoVideoTextureView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localMPExoVideoTextureView.getLayoutParams();
      localLayoutParams.addRule(13);
      localMPExoVideoTextureView.setLayoutParams(localLayoutParams);
    }
    paramMPExoVideoWrapper = paramMPExoVideoWrapper.vZt;
    if (paramMPExoVideoWrapper != null) {
      paramMPExoVideoWrapper.setScaleType(i.e.XYM);
    }
    AppMethodBeat.o(301911);
  }
  
  private static final void o(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    AppMethodBeat.i(301927);
    s.u(paramMPExoVideoWrapper, "this$0");
    paramMPExoVideoWrapper.die();
    paramMPExoVideoWrapper.Bt(paramMPExoVideoWrapper.getCurrPosSec());
    if (paramMPExoVideoWrapper.vZu != null)
    {
      if (paramMPExoVideoWrapper.eDw)
      {
        int i = paramMPExoVideoWrapper.getCurrPosMs();
        Log.i(TAG, "retry when error, video has prepared currentPosition=" + i + " isPlaying:" + paramMPExoVideoWrapper.isPlaying());
        paramMPExoVideoWrapper.vZB = false;
        paramMPExoVideoWrapper.jJ(false);
        paramMPExoVideoWrapper.stopTimer();
        com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j localj;
        if (paramMPExoVideoWrapper.vZu != null)
        {
          localj = paramMPExoVideoWrapper.vZu;
          s.checkNotNull(localj);
          if (localj.isPlaying()) {
            break label149;
          }
          Log.i(TAG, "video pause, video is not playing");
          paramMPExoVideoWrapper.eDv = false;
        }
        for (;;)
        {
          paramMPExoVideoWrapper.eDq = true;
          paramMPExoVideoWrapper.as(i, true);
          AppMethodBeat.o(301927);
          return;
          label149:
          if (!paramMPExoVideoWrapper.eDw)
          {
            Log.i(TAG, "video pause, video not prepared yet, pause video when prepared");
            paramMPExoVideoWrapper.eDv = false;
          }
          else
          {
            Log.i(TAG, "video pause");
            localj = paramMPExoVideoWrapper.vZu;
            s.checkNotNull(localj);
            localj.pause();
            paramMPExoVideoWrapper.onVideoPause();
          }
        }
      }
      Log.i(TAG, "retry when error, video has not prepared");
      paramMPExoVideoWrapper.prepareAsync();
    }
    AppMethodBeat.o(301927);
  }
  
  private final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7464);
    Object localObject = am.aixg;
    localObject = String.format("PlayError %s/%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 2));
    s.s(localObject, "java.lang.String.format(format, *args)");
    Log.w(TAG, "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), localObject, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.diT += 1;
    if (this.diT > this.vZn)
    {
      this.mRi.post(new MPExoVideoWrapper..ExternalSyntheticLambda25(this, (String)localObject, paramInt1, paramInt2));
      AppMethodBeat.o(7464);
      return;
    }
    this.mRi.postDelayed(new MPExoVideoWrapper..ExternalSyntheticLambda15(this), this.vZm);
    AppMethodBeat.o(7464);
  }
  
  private void onVideoPause()
  {
    AppMethodBeat.i(7460);
    Log.d(TAG, "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    this.mRi.post(new MPExoVideoWrapper..ExternalSyntheticLambda18(this));
    AppMethodBeat.o(7460);
  }
  
  private void onVideoPlay()
  {
    AppMethodBeat.i(7461);
    this.vZB = true;
    this.sJg = false;
    Log.d(TAG, "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    this.mRi.post(new MPExoVideoWrapper..ExternalSyntheticLambda21(this));
    AppMethodBeat.o(7461);
  }
  
  private static final boolean p(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    AppMethodBeat.i(301929);
    s.u(paramMPExoVideoWrapper, "this$0");
    if (paramMPExoVideoWrapper.getErrorCount() > 0)
    {
      if (paramMPExoVideoWrapper.isPlaying())
      {
        Log.i(TAG, "reset error count ");
        paramMPExoVideoWrapper.diT = 0;
        AppMethodBeat.o(301929);
        return false;
      }
      AppMethodBeat.o(301929);
      return true;
    }
    AppMethodBeat.o(301929);
    return false;
  }
  
  private final void prepareAsync()
  {
    AppMethodBeat.i(7454);
    if ((this.vZu != null) && (!Util.isNullOrNil(this.eDC)))
    {
      if ((Util.isNullOrNil(this.vZx)) && (com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().sAx) && (com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().sAy)) {
        this.vZx = com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD().cd(this.eDC);
      }
      if (Util.isNullOrNil(this.vZx)) {
        break label168;
      }
      setDataSourceWithCustomKey(this.vZx);
    }
    for (;;)
    {
      Log.i(TAG, "video prepare async");
      die();
      this.eDw = false;
      this.vZE = System.currentTimeMillis();
      if (this.vZu != null)
      {
        Object localObject = getBizVideoProfiler();
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.a)localObject).akb("10");
          if (localObject != null)
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.vYg;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.a((fv)localObject, getBizVideoProfiler());
          }
        }
        localObject = this.vZu;
        s.checkNotNull(localObject);
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j)localObject).prepareAsync();
      }
      AppMethodBeat.o(7454);
      return;
      label168:
      setDataSourceWithCustomKey(this.eDC);
    }
  }
  
  private final void reset()
  {
    this.eDq = false;
    this.eDr = false;
    this.eDs = false;
  }
  
  private final void setDataSourceWithCustomKey(String paramString)
  {
    AppMethodBeat.i(301788);
    if (getAbTestVideoPreload())
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.i.cvD();
      localObject = com.tencent.mm.plugin.appbrand.jsapi.video.i.abO(paramString);
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j localj = this.vZu;
      s.checkNotNull(localj);
      localj.ez(paramString, (String)localObject);
      AppMethodBeat.o(301788);
      return;
    }
    Object localObject = this.vZu;
    s.checkNotNull(localObject);
    ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j)localObject).setDataSource(paramString);
    AppMethodBeat.o(301788);
  }
  
  /* Error */
  private static final void setVideoPath$lambda-14(MPExoVideoWrapper paramMPExoVideoWrapper)
  {
    // Byte code:
    //   0: ldc_w 1384
    //   3: invokestatic 345	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 710
    //   10: invokestatic 501	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 1146	com/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper:eDC	Ljava/lang/String;
    //   17: invokestatic 1152	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   20: ifne +177 -> 197
    //   23: aload_0
    //   24: getfield 1146	com/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper:eDC	Ljava/lang/String;
    //   27: astore_2
    //   28: aload_2
    //   29: invokestatic 635	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   32: aload_2
    //   33: ldc_w 1386
    //   36: iconst_0
    //   37: invokestatic 1392	kotlin/n/n:U	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   40: ifeq +157 -> 197
    //   43: aload_0
    //   44: getfield 1146	com/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper:eDC	Ljava/lang/String;
    //   47: aconst_null
    //   48: invokestatic 1397	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/y;
    //   51: astore_2
    //   52: aload_2
    //   53: invokestatic 635	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   56: aload_2
    //   57: invokevirtual 1402	com/tencent/mm/network/y:connect	()V
    //   60: aload_2
    //   61: invokevirtual 1405	com/tencent/mm/network/y:getResponseCode	()I
    //   64: istore_1
    //   65: getstatic 492	com/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper:TAG	Ljava/lang/String;
    //   68: ldc_w 1407
    //   71: iconst_1
    //   72: anewarray 761	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: iload_1
    //   78: invokestatic 805	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: invokestatic 776	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: iload_1
    //   86: sipush 400
    //   89: if_icmplt +36 -> 125
    //   92: aload_0
    //   93: getfield 729	com/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper:vZv	Lcom/tencent/mm/pluginsdk/ui/i$b;
    //   96: ifnull +29 -> 125
    //   99: aload_0
    //   100: getfield 729	com/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper:vZv	Lcom/tencent/mm/pluginsdk/ui/i$b;
    //   103: astore_0
    //   104: aload_0
    //   105: invokestatic 635	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   108: aload_0
    //   109: ldc_w 730
    //   112: ldc_w 730
    //   115: ldc_w 1409
    //   118: iconst_m1
    //   119: iload_1
    //   120: invokeinterface 846 6 0
    //   125: aload_2
    //   126: invokevirtual 1412	com/tencent/mm/network/y:disconnect	()V
    //   129: ldc_w 1384
    //   132: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: return
    //   136: astore_2
    //   137: aconst_null
    //   138: astore_0
    //   139: getstatic 492	com/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper:TAG	Ljava/lang/String;
    //   142: aload_2
    //   143: checkcast 1414	java/lang/Throwable
    //   146: ldc_w 1416
    //   149: iconst_1
    //   150: anewarray 761	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: aload_2
    //   156: invokevirtual 1419	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   159: aastore
    //   160: invokestatic 1423	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: aload_0
    //   164: ifnull +7 -> 171
    //   167: aload_0
    //   168: invokevirtual 1412	com/tencent/mm/network/y:disconnect	()V
    //   171: ldc_w 1384
    //   174: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: return
    //   178: astore_0
    //   179: aconst_null
    //   180: astore_2
    //   181: aload_2
    //   182: ifnull +7 -> 189
    //   185: aload_2
    //   186: invokevirtual 1412	com/tencent/mm/network/y:disconnect	()V
    //   189: ldc_w 1384
    //   192: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: aload_0
    //   196: athrow
    //   197: ldc_w 1384
    //   200: invokestatic 351	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: return
    //   204: astore_0
    //   205: goto -24 -> 181
    //   208: astore_2
    //   209: aload_0
    //   210: astore_3
    //   211: aload_2
    //   212: astore_0
    //   213: aload_3
    //   214: astore_2
    //   215: goto -34 -> 181
    //   218: astore_3
    //   219: aload_2
    //   220: astore_0
    //   221: aload_3
    //   222: astore_2
    //   223: goto -84 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramMPExoVideoWrapper	MPExoVideoWrapper
    //   64	56	1	i	int
    //   27	99	2	localObject1	Object
    //   136	20	2	localException1	java.lang.Exception
    //   180	6	2	localObject2	Object
    //   208	4	2	localObject3	Object
    //   214	9	2	localObject4	Object
    //   210	4	3	localMPExoVideoWrapper	MPExoVideoWrapper
    //   218	4	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   43	52	136	java/lang/Exception
    //   43	52	178	finally
    //   52	85	204	finally
    //   92	125	204	finally
    //   139	163	208	finally
    //   52	85	218	java/lang/Exception
    //   92	125	218	java/lang/Exception
  }
  
  private final void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(7445);
    this.mRi.post(new MPExoVideoWrapper..ExternalSyntheticLambda24(this, paramInt));
    AppMethodBeat.o(7445);
  }
  
  private boolean start()
  {
    AppMethodBeat.i(7455);
    if (!this.sIU)
    {
      Log.w(TAG, "ui on pause now, why u call me to play? [%s]", new Object[] { Util.getStack() });
      AppMethodBeat.o(7455);
      return false;
    }
    if (this.mSurface == null)
    {
      Log.w(TAG, "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.sIK = true;
      this.eDv = true;
      AppMethodBeat.o(7455);
      return false;
    }
    this.vZB = true;
    if (this.vZu == null)
    {
      dib();
      prepareAsync();
    }
    if (this.vZu != null)
    {
      setKeepScreenOn(true);
      this.vZw.a((d.a)this);
      Object localObject1;
      if (this.eDw)
      {
        localObject1 = this.vZu;
        s.checkNotNull(localObject1);
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j)localObject1).isPlaying())
        {
          Log.i(TAG, "video play, video is playing");
          onVideoPlay();
          AppMethodBeat.o(7455);
          return true;
        }
      }
      if ((this.vZu != null) && (!this.eDw))
      {
        Log.i(TAG, "video play, video not prepared yet, start until prepared");
        this.eDv = true;
        AppMethodBeat.o(7455);
        return true;
      }
      if (this.vZu != null)
      {
        localObject1 = this.vZu;
        s.checkNotNull(localObject1);
        if (((com.tencent.mm.plugin.appbrand.jsapi.video.e.a)localObject1).sEu == 5)
        {
          Log.i(TAG, "video play, video has stopped now, try prepare and start when prepared");
          this.eDv = true;
          Log.i(TAG, "video play, media player prepare async");
          prepareAsync();
          AppMethodBeat.o(7455);
          return true;
        }
      }
      Object localObject2;
      if (this.eDE)
      {
        Log.i(TAG, "video play, video has ended playing, clear surface and start again");
        this.eDE = false;
        dhZ();
        dib();
        prepareAsync();
        if (this.vZu != null)
        {
          this.eDv = true;
          localObject1 = TAG;
          localObject2 = this.vZu;
          s.checkNotNull(localObject2);
          Log.i((String)localObject1, "video play, media player state:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.jsapi.video.e.a)localObject2).sEu) });
          prepareAsync();
        }
        AppMethodBeat.o(7455);
        return true;
      }
      if (this.vZu != null)
      {
        localObject1 = this.vZu;
        s.checkNotNull(localObject1);
        ((com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j)localObject1).start();
        localObject1 = getBizVideoProfiler();
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.a)localObject1).akb("15");
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.vYg;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.a((fv)localObject1, getBizVideoProfiler());
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
  
  private boolean stop()
  {
    AppMethodBeat.i(7457);
    this.vZB = false;
    stopTimer();
    MPExoVideoTextureView localMPExoVideoTextureView = this.vZt;
    if (localMPExoVideoTextureView != null)
    {
      localMPExoVideoTextureView.dhZ();
      localMPExoVideoTextureView.vZi.reset();
    }
    this.sIA = 0;
    if (this.vZu != null)
    {
      this.mRi.post(new MPExoVideoWrapper..ExternalSyntheticLambda11(this));
      AppMethodBeat.o(7457);
      return true;
    }
    AppMethodBeat.o(7457);
    return false;
  }
  
  private final void stopTimer()
  {
    AppMethodBeat.i(7447);
    Log.d(TAG, "stop timer");
    this.sJn.stopTimer();
    AppMethodBeat.o(7447);
  }
  
  public final void ar(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(7429);
    Log.i(TAG, "prepare async");
    dib();
    prepareAsync();
    as(paramInt, paramBoolean);
    if (paramBoolean) {
      start();
    }
    AppMethodBeat.o(7429);
  }
  
  public final void bAi() {}
  
  public final void bAj() {}
  
  public final void bAk() {}
  
  public final void bAl() {}
  
  public final void dib()
  {
    AppMethodBeat.i(7437);
    reset();
    auC();
    dic();
    auE();
    AppMethodBeat.o(7437);
  }
  
  public final int getCacheTimeSec()
  {
    AppMethodBeat.i(179023);
    if (getVideoDurationSec() > 0)
    {
      int i = this.sIA * getVideoDurationSec() / 100;
      AppMethodBeat.o(179023);
      return i;
    }
    AppMethodBeat.o(179023);
    return 0;
  }
  
  protected final MTimerHandler getCheckTimer()
  {
    return this.sJn;
  }
  
  public final ImageView getCoverIv()
  {
    AppMethodBeat.i(7430);
    ImageView localImageView = this.szA;
    s.checkNotNull(localImageView);
    AppMethodBeat.o(7430);
    return localImageView;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(7424);
    if (this.vZu != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j localj = this.vZu;
      s.checkNotNull(localj);
      int i = localj.getCurrentPosition();
      AppMethodBeat.o(7424);
      return i;
    }
    AppMethodBeat.o(7424);
    return 0;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(7425);
    if (this.vZu != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j localj = this.vZu;
      s.checkNotNull(localj);
      int i = localj.getCurrentPosition() / 1000;
      AppMethodBeat.o(7425);
      return i;
    }
    AppMethodBeat.o(7425);
    return 0;
  }
  
  protected final int getERROR_CHECK_TIME()
  {
    return this.vZl;
  }
  
  protected final int getERROR_TRY_AGAIN_DELAY_TIME()
  {
    return this.vZm;
  }
  
  protected final int getERROR_TRY_MAX_TIME()
  {
    return this.vZn;
  }
  
  protected final MTimerHandler getErrorCheckTimer()
  {
    return this.sJp;
  }
  
  protected final int getErrorCount()
  {
    return this.diT;
  }
  
  public final long getFirstRenderTime()
  {
    AppMethodBeat.i(177797);
    if (this.vZE != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.vZE;
      AppMethodBeat.o(177797);
      return l1 - l2;
    }
    AppMethodBeat.o(177797);
    return 0L;
  }
  
  protected final ProgressBar getLoading()
  {
    return this.sIX;
  }
  
  protected final int getMVideoSource()
  {
    return this.szV;
  }
  
  public final boolean getNeedShowSwitchTitleTextView()
  {
    return this.vZG;
  }
  
  protected final MTimerHandler getShowLoadingTimer()
  {
    return this.vZJ;
  }
  
  protected final MMHandler getUiHandler()
  {
    return this.mRi;
  }
  
  public final int getVideoDurationMs()
  {
    AppMethodBeat.i(7423);
    if (this.vZu != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j localj = this.vZu;
      s.checkNotNull(localj);
      i = localj.getDuration();
      AppMethodBeat.o(7423);
      return i;
    }
    int i = this.sAo;
    AppMethodBeat.o(7423);
    return i * 1000;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(7422);
    if (this.vZu != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j localj = this.vZu;
      s.checkNotNull(localj);
      i = localj.getDuration() / 1000;
      AppMethodBeat.o(7422);
      return i;
    }
    int i = this.sAo;
    AppMethodBeat.o(7422);
    return i;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(7428);
    if (this.vZu != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j localj = this.vZu;
      s.checkNotNull(localj);
      int i = localj.getVideoHeight();
      AppMethodBeat.o(7428);
      return i;
    }
    AppMethodBeat.o(7428);
    return 0;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(7427);
    if (this.vZu != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j localj = this.vZu;
      s.checkNotNull(localj);
      int i = localj.getVideoWidth();
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
    this.vZJ.stopTimer();
    this.mRi.post(new MPExoVideoWrapper..ExternalSyntheticLambda13(this));
    AppMethodBeat.o(7453);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(7426);
    if ((this.vZu != null) && (this.eDw))
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j localj = this.vZu;
      s.checkNotNull(localj);
      boolean bool = localj.isPlaying();
      AppMethodBeat.o(7426);
      return bool;
    }
    AppMethodBeat.o(7426);
    return false;
  }
  
  protected final void setCheckTimer(MTimerHandler paramMTimerHandler)
  {
    AppMethodBeat.i(7421);
    s.u(paramMTimerHandler, "<set-?>");
    this.sJn = paramMTimerHandler;
    AppMethodBeat.o(7421);
  }
  
  public final void setControllerBarShowing(boolean paramBoolean)
  {
    this.vZI = paramBoolean;
  }
  
  protected final void setErrorCheckTimer(MTimerHandler paramMTimerHandler)
  {
    AppMethodBeat.i(7465);
    s.u(paramMTimerHandler, "<set-?>");
    this.sJp = paramMTimerHandler;
    AppMethodBeat.o(7465);
  }
  
  protected final void setErrorCount(int paramInt)
  {
    this.diT = paramInt;
  }
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(7441);
    s.u(paramb, "_callback");
    this.vZv = paramb;
    AppMethodBeat.o(7441);
  }
  
  public final void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(7462);
    Log.d(TAG, "set keep screen on[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mRi.post(new MPExoVideoWrapper..ExternalSyntheticLambda27(this, paramBoolean));
    AppMethodBeat.o(7462);
  }
  
  public final void setLive(boolean paramBoolean)
  {
    this.ddk = paramBoolean;
  }
  
  protected final void setLoading(ProgressBar paramProgressBar)
  {
    this.sIX = paramProgressBar;
  }
  
  protected final void setMVideoSource(int paramInt)
  {
    this.szV = paramInt;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(7458);
    this.nLP = paramBoolean;
    if (this.vZu != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.c.j localj = this.vZu;
      s.checkNotNull(localj);
      localj.setMute(this.nLP);
    }
    AppMethodBeat.o(7458);
  }
  
  public final void setNeedShowSwitchTitleTextView(boolean paramBoolean)
  {
    this.vZG = paramBoolean;
  }
  
  protected final void setPlayOnUiPause(boolean paramBoolean)
  {
    this.sJg = paramBoolean;
  }
  
  protected final void setShowLoadingTimer(MTimerHandler paramMTimerHandler)
  {
    AppMethodBeat.i(7451);
    s.u(paramMTimerHandler, "<set-?>");
    this.vZJ = paramMTimerHandler;
    AppMethodBeat.o(7451);
  }
  
  public final void setSwitchingResolution(boolean paramBoolean)
  {
    this.vZH = paramBoolean;
  }
  
  protected final void setUIAvailable(boolean paramBoolean)
  {
    this.sIU = paramBoolean;
  }
  
  protected final void setUiHandler(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(7420);
    s.u(paramMMHandler, "<set-?>");
    this.mRi = paramMMHandler;
    AppMethodBeat.o(7420);
  }
  
  public final void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(7442);
    s.u(paramh, "_footerView");
    this.vZr = paramh;
    paramh = this.vZo;
    s.checkNotNull(paramh);
    paramh.removeAllViews();
    paramh = this.vZo;
    s.checkNotNull(paramh);
    paramh.addView((View)this.vZr);
    AppMethodBeat.o(7442);
  }
  
  public final void setVideoSource(int paramInt)
  {
    this.szV = paramInt;
  }
  
  protected final void startTimer()
  {
    AppMethodBeat.i(7446);
    Log.d(TAG, "start timer");
    if (!this.sJn.stopped()) {
      stopTimer();
    }
    this.sJn.startTimer(vZL);
    AppMethodBeat.o(7446);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/widget/MPExoVideoWrapper$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements TextureView.SurfaceTextureListener
  {
    c(MPExoVideoWrapper paramMPExoVideoWrapper) {}
    
    private static final void D(MPExoVideoWrapper paramMPExoVideoWrapper)
    {
      AppMethodBeat.i(301693);
      s.u(paramMPExoVideoWrapper, "this$0");
      Log.d(MPExoVideoWrapper.access$getTAG$cp(), "hide cover onSurfaceTextureUpdated");
      Log.d(MPExoVideoWrapper.TAG, "hide cover");
      paramMPExoVideoWrapper = paramMPExoVideoWrapper.szA;
      s.checkNotNull(paramMPExoVideoWrapper);
      paramMPExoVideoWrapper.setVisibility(8);
      AppMethodBeat.o(301693);
    }
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7402);
      s.u(paramSurfaceTexture, "surface");
      Log.i(MPExoVideoWrapper.access$getTAG$cp(), "on surface texture available, width %d height %d switching %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.vZO.vZH) });
      Object localObject1 = MPExoVideoWrapper.u(this.vZO);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.a)localObject1).akb("9");
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.vYg;
          com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.a((fv)localObject1, "PlayerType", "3");
          localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.vYg;
          com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.a((fv)localObject1, MPExoVideoWrapper.u(this.vZO));
        }
      }
      this.vZO.startTimer();
      localObject1 = MPExoVideoWrapper.v(this.vZO);
      if (localObject1 != null) {
        ((MPExoVideoTextureView)localObject1).jmM();
      }
      localObject1 = MPExoVideoWrapper.v(this.vZO);
      if (localObject1 != null)
      {
        localObject2 = MPExoVideoWrapper.w(this.vZO);
        com.tencent.threadpool.h.ahAA.bm(new MPExoVideoTextureView.1((MPExoVideoTextureView)localObject1, (Surface)localObject2));
      }
      MPExoVideoWrapper.a(this.vZO, new Surface(paramSurfaceTexture));
      if ((MPExoVideoWrapper.r(this.vZO) == null) || (!MPExoVideoWrapper.s(this.vZO))) {
        if (this.vZO.vZH) {
          this.vZO.ar(MPExoVideoWrapper.x(this.vZO), MPExoVideoWrapper.y(this.vZO));
        }
      }
      for (;;)
      {
        if ((!MPExoVideoWrapper.B(this.vZO)) && (this.vZO.vZH)) {
          MPExoVideoWrapper.C(this.vZO);
        }
        AppMethodBeat.o(7402);
        return;
        this.vZO.dib();
        MPExoVideoWrapper.z(this.vZO);
        continue;
        Log.i(MPExoVideoWrapper.access$getTAG$cp(), "init, setSurface");
        paramSurfaceTexture = MPExoVideoWrapper.r(this.vZO);
        s.checkNotNull(paramSurfaceTexture);
        paramSurfaceTexture.setSurface(MPExoVideoWrapper.w(this.vZO));
        if (MPExoVideoWrapper.A(this.vZO))
        {
          paramSurfaceTexture = MPExoVideoWrapper.u(this.vZO);
          if (paramSurfaceTexture != null)
          {
            paramSurfaceTexture = paramSurfaceTexture.akb("15");
            if (paramSurfaceTexture != null)
            {
              localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.vYg;
              com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.a(paramSurfaceTexture, MPExoVideoWrapper.u(this.vZO));
            }
          }
          paramSurfaceTexture = MPExoVideoWrapper.r(this.vZO);
          s.checkNotNull(paramSurfaceTexture);
          paramSurfaceTexture.start();
        }
        MPExoVideoWrapper.c(this.vZO, false);
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(7401);
      s.u(paramSurfaceTexture, "surface");
      Log.i(MPExoVideoWrapper.access$getTAG$cp(), "on surface texture destroyed");
      MPExoVideoWrapper.a(this.vZO, null);
      if ((MPExoVideoWrapper.r(this.vZO) != null) && (MPExoVideoWrapper.s(this.vZO))) {
        if (this.vZO.isPlaying())
        {
          MPExoVideoWrapper.c(this.vZO, true);
          paramSurfaceTexture = MPExoVideoWrapper.r(this.vZO);
          if (paramSurfaceTexture != null) {
            paramSurfaceTexture.pause();
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(7401);
        return false;
        MPExoVideoWrapper.t(this.vZO);
        MPExoVideoWrapper.c(this.vZO, false);
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(7400);
      s.u(paramSurfaceTexture, "surface");
      AppMethodBeat.o(7400);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(7399);
      s.u(paramSurfaceTexture, "surface");
      if (this.vZO.getLoading() != null)
      {
        paramSurfaceTexture = this.vZO.getLoading();
        s.checkNotNull(paramSurfaceTexture);
        if (paramSurfaceTexture.getVisibility() == 0) {
          this.vZO.hideLoading();
        }
      }
      if (MPExoVideoWrapper.q(this.vZO) != null)
      {
        paramSurfaceTexture = MPExoVideoWrapper.q(this.vZO);
        s.checkNotNull(paramSurfaceTexture);
        if ((paramSurfaceTexture.getVisibility() == 0) && ((this.vZO.isPlaying()) || (this.vZO.getCurrPosSec() != 0))) {
          this.vZO.getUiHandler().post(new MPExoVideoWrapper.c..ExternalSyntheticLambda0(this.vZO));
        }
      }
      AppMethodBeat.o(7399);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPExoVideoWrapper
 * JD-Core Version:    0.7.0.1
 */