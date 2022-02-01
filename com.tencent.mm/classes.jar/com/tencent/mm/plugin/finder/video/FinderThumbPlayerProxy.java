package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acc;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.g.g.a;
import com.tencent.mm.g.g.b;
import com.tencent.mm.g.h.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.finder.viewmodel.component.be;
import com.tencent.mm.plugin.finder.viewmodel.component.be.h;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.a.e;
import com.tencent.mm.plugin.thumbplayer.b.g;
import com.tencent.mm.plugin.thumbplayer.render.MMSurfaceViewRender;
import com.tencent.mm.plugin.thumbplayer.render.MMTextureViewRender;
import com.tencent.mm.plugin.thumbplayer.render.a.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vfs.y;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.thumbplayer.api.TPVideoInfo.Builder;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgPrepareStatus", "contextTag", "coverBitmap", "Landroid/graphics/Bitmap;", "currSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "currentPlayState", "getCurrentPlayState", "()I", "setCurrentPlayState", "(I)V", "debugInfoData", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$DebugInfoData;", "downloadCallback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "getDownloadCallback", "()Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "setDownloadCallback", "(Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;)V", "enableMediaCodecReuse", "", "enableRendererSharpen", "fTPPKVReporter", "Lcom/tencent/mm/plugin/finder/video/reporter/FTPPKVReporter;", "getFTPPKVReporter", "()Lcom/tencent/mm/plugin/finder/video/reporter/FTPPKVReporter;", "fTPPKVReporter$delegate", "Lkotlin/Lazy;", "fTPPLog", "Lcom/tencent/mm/plugin/finder/video/log/FTPPLog;", "getFTPPLog", "()Lcom/tencent/mm/plugin/finder/video/log/FTPPLog;", "fTPPLog$delegate", "ftppTag", "", "ignoreLongTerm", "getIgnoreLongTerm", "()Z", "setIgnoreLongTerm", "(Z)V", "isBuffering", "isFirstFrameRendered", "isFirstStart", "isFullScreen", "isLongVideo", "isOnlyAudio", "setOnlyAudio", "isOpenFlowControl", "isPreviewing", "isRealStartDownloader", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isReuseForLongTerm", "isShouldPlayResume", "setShouldPlayResume", "isStartCdn", "setStartCdn", "isStartCdnPreload", "setStartCdnPreload", "isViewFocused", "setViewFocused", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaPreloadCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "getMediaPreloadCore$plugin_finder_release", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "setMediaPreloadCore$plugin_finder_release", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "notifyProgressTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onBufferingStartRunnable", "Ljava/lang/Runnable;", "onMuteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getOnMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setOnMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "onPlayerStopListener", "Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;", "getOnPlayerStopListener", "()Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;", "setOnPlayerStopListener", "(Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;)V", "onStopPlayData", "Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "playSpeedRatio", "", "getPlaySpeedRatio", "()F", "setPlaySpeedRatio", "(F)V", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "playerListener", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$TPPlayerListener;", "renderView", "Lcom/tencent/mm/plugin/thumbplayer/render/IMMRenderView;", "getRenderView", "()Lcom/tencent/mm/plugin/thumbplayer/render/IMMRenderView;", "setRenderView", "(Lcom/tencent/mm/plugin/thumbplayer/render/IMMRenderView;)V", "resourceLoaderProxy", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "surface", "Landroid/view/Surface;", "surfaceViewSwitchHelper", "Lcom/tencent/mm/plugin/thumbplayer/render/MMSurfaceViewSwitchHelper;", "textureUpdateTimes", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "videoPlayTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "videoViewCallback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "getVideoViewCallback", "()Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setVideoViewCallback", "(Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;)V", "captureFrame", "", "changePlayerState", "toState", "checkRendererSharpenLocalConfig", "debugInfo", "getBitmap", "getContextTag", "getCoverBitmap", "getCurrentPlayMs", "", "getCurrentPlaySecond", "getFTPPTag", "getFinderFluentSwitchParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "feedId", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getPlayer", "", "getProxyState", "isTextureView", "invokeSource", "getVideoDuration", "getVideoDurationMs", "getVideoMediaId", "getVideoMediaInfo", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "handleOnBufferingEnd", "handleOnBufferingStart", "mediaId", "handleOnFirstFrameRendered", "handleOnFirstFrameRenderedAfterSurfaceChange", "handleOnSurfaceAvailable", "surfaceTexture", "handleOnSurfaceHolderAvailable", "surfaceHolder", "Landroid/view/SurfaceHolder;", "handleOnSurfaceUpdate", "handlePlayerStateChange", "state", "init", "initFTPPTag", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "initRenderView", "mediaInfo", "forceTextureView", "isEnableFluentSwitchExit", "isFullScreenEnjoy", "isPause", "isPlaying", "isPrepared", "isPreparing", "isStartPlay", "currentState", "onRelease", "onUIDestroy", "pause", "pauseWithCancel", "play", "playInfo", "playWithSource", "source", "prepareCacheFile", "filePath", "prepareForReuseTPView", "prepareOnlineUrl", "url", "prepareToPlay", "prepareVideo", "prepareforReuse", "releaseSurface", "removeVideoFooterView", "resizeTextureView", "width", "height", "seekTo", "timestamp", "", "afterSeekPlay", "mode", "seekToMs", "timeMs", "setBgPrepareStatus", "status", "setContextTag", "tag", "setFinderVideoPlayTrace", "setFullScreenEnjoy", "isFull", "setIMMVideoViewCallback", "_callback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setLivePlayer", "txPlayer", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "setLoop", "loop", "setMute", "isMute", "setPlaySpeed", "ratio", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "isLocal", "feedData", "setVideoMuteListener", "muteListener", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "startCdnDownload", "startCdnPreload", "startInternal", "startOrPlay", "offset", "(Ljava/lang/Integer;)Z", "startProgressTimer", "info", "stop", "stopCdnDownload", "stopCdnPreload", "stopProgressTimer", "toString", "updateIsRealStartDownloader", "isRealStart", "Companion", "DebugInfoData", "ResourceLoaderProxy", "TPPlayerListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderThumbPlayerProxy
  extends FrameLayout
  implements t
{
  private static final HashSet<Integer> Fly;
  public static final FinderThumbPlayerProxy.a GoX;
  private static final HashSet<String> Gpm;
  private static String TAG;
  private v ANI;
  private com.tencent.mm.plugin.finder.video.reporter.e ANO;
  private com.tencent.mm.plugin.finder.video.reporter.d ANP;
  private i.b EAt;
  private volatile boolean ELh;
  private String FkY;
  private boolean FkZ;
  private int Fla;
  private com.tencent.mm.plugin.thumbplayer.e.a Flb;
  private SurfaceTexture Fle;
  private boolean Flf;
  private int Flg;
  private MTimerHandler Flh;
  private Runnable Fli;
  private int Flj;
  private com.tencent.mm.plugin.findersdk.f.a Fll;
  private AtomicBoolean Flm;
  private float Flp;
  private boolean Flq;
  boolean Flr;
  private boolean Fls;
  private ab Flu;
  private w Flv;
  private boolean Flw;
  private boolean Flx;
  private d GoY;
  public com.tencent.mm.plugin.thumbplayer.render.a GoZ;
  private com.tencent.mm.plugin.finder.preload.f Gpa;
  private c Gpb;
  private final kotlin.j Gpc;
  private final kotlin.j Gpd;
  private x Gpe;
  public final b Gpf;
  private boolean Gpg;
  private boolean Gph;
  private boolean Gpi;
  private final com.tencent.mm.plugin.thumbplayer.render.b Gpj;
  private aa Gpk;
  private Bitmap Gpl;
  private boolean cFq;
  private int contextTag;
  private volatile int currentPlayState;
  private boolean ignoreLongTerm;
  private boolean isLongVideo;
  private MMHandler mRi;
  private boolean nvB;
  private Surface surface;
  
  static
  {
    AppMethodBeat.i(335661);
    GoX = new FinderThumbPlayerProxy.a((byte)0);
    TAG = "FTPP.FinderThumbPlayerProxy";
    Fly = new HashSet();
    Gpm = new HashSet();
    AppMethodBeat.o(335661);
  }
  
  public FinderThumbPlayerProxy(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(334961);
    this.FkY = TAG;
    this.Flf = true;
    this.Gpc = kotlin.k.cm((kotlin.g.a.a)f.GpD);
    this.Gpd = kotlin.k.cm((kotlin.g.a.a)g.GpE);
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.contextTag = -1;
    this.Gpf = new b("", "", "", "", "");
    this.Flm = new AtomicBoolean(true);
    this.ANP = new com.tencent.mm.plugin.finder.video.reporter.d();
    this.Flp = 1.0F;
    this.Gpj = new com.tencent.mm.plugin.thumbplayer.render.b((FrameLayout)this);
    init();
    AppMethodBeat.o(334961);
  }
  
  public FinderThumbPlayerProxy(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(334970);
    this.FkY = TAG;
    this.Flf = true;
    this.Gpc = kotlin.k.cm((kotlin.g.a.a)f.GpD);
    this.Gpd = kotlin.k.cm((kotlin.g.a.a)g.GpE);
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.contextTag = -1;
    this.Gpf = new b("", "", "", "", "");
    this.Flm = new AtomicBoolean(true);
    this.ANP = new com.tencent.mm.plugin.finder.video.reporter.d();
    this.Flp = 1.0F;
    this.Gpj = new com.tencent.mm.plugin.thumbplayer.render.b((FrameLayout)this);
    init();
    AppMethodBeat.o(334970);
  }
  
  public FinderThumbPlayerProxy(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(334976);
    this.FkY = TAG;
    this.Flf = true;
    this.Gpc = kotlin.k.cm((kotlin.g.a.a)f.GpD);
    this.Gpd = kotlin.k.cm((kotlin.g.a.a)g.GpE);
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.contextTag = -1;
    this.Gpf = new b("", "", "", "", "");
    this.Flm = new AtomicBoolean(true);
    this.ANP = new com.tencent.mm.plugin.finder.video.reporter.d();
    this.Flp = 1.0F;
    this.Gpj = new com.tencent.mm.plugin.thumbplayer.render.b((FrameLayout)this);
    init();
    AppMethodBeat.o(334976);
  }
  
  private final boolean RQ(int paramInt)
  {
    Object localObject3 = null;
    AppMethodBeat.i(335056);
    Object localObject2 = getFTPPTag();
    Object localObject4 = new StringBuilder("prepareVideo() source:").append(paramInt).append(" isMoovReady:");
    Object localObject1 = this.Gpb;
    label80:
    label109:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject4 = ((StringBuilder)localObject4).append(localObject1).append(" isAllCompleted:");
      localObject1 = this.Gpb;
      if (localObject1 != null) {
        break label683;
      }
      localObject1 = null;
      localObject4 = ((StringBuilder)localObject4).append(localObject1).append(" downloadUrl:");
      localObject1 = this.ANI;
      if (localObject1 != null) {
        break label699;
      }
      localObject1 = null;
      Log.i((String)localObject2, localObject1 + ' ' + getProxyState());
      localObject1 = this.Gpb;
      if (localObject1 != null) {
        ((c)localObject1).fjl();
      }
      localObject1 = this.Gpb;
      if (localObject1 == null) {
        break label906;
      }
      localObject1 = ((c)localObject1).Ezi;
      localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eVj().bmg()).intValue() != 1) {
        break label919;
      }
      if ((!s.p(((az)localObject1).field_fileFormat, "xV2")) && (!s.p(((az)localObject1).field_fileFormat, "xV4")) && (!s.p(((az)localObject1).field_fileFormat, "xV6")) && (!s.p(((az)localObject1).field_fileFormat, "xV8"))) {
        break label914;
      }
      i = 1;
    }
    for (;;)
    {
      if ((af.lXY.lTG != 1) && (fjf()) && (i != 0))
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
        this.Fla = ((Number)com.tencent.mm.plugin.finder.storage.d.eVh().bmg()).intValue();
        label290:
        localObject1 = this.ANO;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.video.reporter.e)localObject1).Fla = this.Fla;
        }
        Log.i(TAG, "player enableRendererSharpen: %d", new Object[] { Integer.valueOf(this.Fla) });
        if (this.Fla > 0)
        {
          localObject2 = this.Flb;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("player");
            localObject1 = null;
          }
          ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setPlayerOptionalParam(new TPOptionalParam().buildInt(451, this.Fla));
          localObject2 = this.Flb;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("player");
            localObject1 = null;
          }
          ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setPlayerOptionalParam(new TPOptionalParam().buildString(452, "assets/shaders"));
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eYx().bmg()).intValue() != 0) {
          break label717;
        }
        Log.w(TAG, "prepareVideo disable set buffer size.");
        label464:
        localObject2 = this.Flb;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("player");
          localObject1 = null;
        }
        localObject2 = j.GoW;
        ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setPlayerOptionalParam(j.fje());
        localObject1 = this.Flb;
        if (localObject1 != null) {
          break label894;
        }
        s.bIx("player");
        localObject1 = null;
        label523:
        ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).enableTPAssetResourceLoader((com.tencent.thumbplayer.e.a.a)this.Gpb);
        this.surface = getRenderView().getSurface();
        localObject1 = this.surface;
        if (localObject1 != null)
        {
          if (!((Surface)localObject1).isValid()) {
            break label897;
          }
          label569:
          if (localObject1 != null)
          {
            localObject4 = this.Flb;
            localObject2 = localObject4;
            if (localObject4 == null)
            {
              s.bIx("player");
              localObject2 = null;
            }
            ((com.tencent.mm.plugin.thumbplayer.e.a)localObject2).setSurface((Surface)localObject1);
          }
        }
        localObject1 = this.Fll;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.findersdk.f.a)localObject1).aDn("prepareAsync");
        }
        localObject1 = this.Flb;
        if (localObject1 != null) {
          break label903;
        }
        s.bIx("player");
        localObject1 = localObject3;
      }
      label897:
      label903:
      for (;;)
      {
        ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).prepareAsync();
        RS(3);
        AppMethodBeat.o(335056);
        return true;
        localObject1 = Boolean.valueOf(((c)localObject1).Ezi.field_moovReady);
        break;
        label683:
        localObject1 = Boolean.valueOf(((c)localObject1).Ezi.eDw());
        break label80;
        label699:
        localObject1 = ((v)localObject1).downloadUrl;
        break label109;
        this.Fla = 0;
        break label290;
        label717:
        i = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel().EVC;
        int j = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel().EVD;
        Log.i(getFTPPTag(), "prepareVideo() source:" + paramInt + " minBufferDuration:" + i + " maxBufferDuration:" + j);
        if (i > 0)
        {
          localObject2 = this.Flb;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("player");
            localObject1 = null;
          }
          ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setPlayerOptionalParam(new TPOptionalParam().buildLong(102, i));
        }
        if (j <= 0) {
          break label464;
        }
        localObject2 = this.Flb;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("player");
          localObject1 = null;
        }
        ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setPlayerOptionalParam(new TPOptionalParam().buildLong(117, j));
        break label464;
        label894:
        break label523;
        localObject1 = null;
        break label569;
      }
      label906:
      AppMethodBeat.o(335056);
      return false;
      label914:
      i = 0;
      continue;
      label919:
      i = 1;
    }
  }
  
  private static boolean RR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private final void RS(int paramInt)
  {
    AppMethodBeat.i(335264);
    Log.i(getFTPPTag(), "changePlayerState from:" + this.currentPlayState + " to:" + paramInt);
    if ((paramInt == 4) && (this.currentPlayState != 3))
    {
      Log.w(getFTPPTag(), "changePlayerState from:" + this.currentPlayState + " to:" + paramInt + " return for error state.");
      AppMethodBeat.o(335264);
      return;
    }
    this.currentPlayState = paramInt;
    RT(this.currentPlayState);
    AppMethodBeat.o(335264);
  }
  
  private final void RT(int paramInt)
  {
    i.b localb = null;
    Object localObject1 = null;
    AppMethodBeat.i(335277);
    this.ANP.GuE = paramInt;
    if (this.ANI == null)
    {
      Log.i(getFTPPTag(), "FTPP.handlePlayerStateChange() return for null");
      AppMethodBeat.o(335277);
      return;
    }
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(335277);
      return;
      localb = this.EAt;
      if (localb != null)
      {
        localObject2 = this.ANI;
        if (localObject2 != null) {
          break label161;
        }
      }
      for (;;)
      {
        localb.eo("", (String)localObject1);
        localObject1 = this.Flu;
        if (localObject1 != null) {
          ((ab)localObject1).egu();
        }
        localObject1 = this.ANI;
        if (localObject1 == null) {
          break;
        }
        b((v)localObject1);
        break;
        label161:
        localObject1 = ((v)localObject2).mediaId;
      }
      Object localObject2 = this.EAt;
      if (localObject2 != null)
      {
        localObject1 = this.ANI;
        if (localObject1 != null) {
          break label232;
        }
      }
      label232:
      for (localObject1 = localb;; localObject1 = ((v)localObject1).mediaId)
      {
        ((i.b)localObject2).en("", (String)localObject1);
        localObject1 = this.Flu;
        if (localObject1 != null) {
          ((ab)localObject1).a(this.ANP.fjS());
        }
        eLO();
        break;
      }
      Log.i(getFTPPTag(), s.X("FTPP.handlePlayerStateChange() player stop or idle ", getProxyState()));
      localObject1 = this.Gpe;
      if (localObject1 != null) {
        ((x)localObject1).enr();
      }
    }
  }
  
  private static final void a(FinderThumbPlayerProxy paramFinderThumbPlayerProxy, String paramString)
  {
    AppMethodBeat.i(335297);
    s.u(paramFinderThumbPlayerProxy, "this$0");
    if (paramFinderThumbPlayerProxy.Flr)
    {
      paramFinderThumbPlayerProxy.cFq = true;
      paramFinderThumbPlayerProxy = paramFinderThumbPlayerProxy.getVideoViewCallback();
      if (paramFinderThumbPlayerProxy != null) {
        paramFinderThumbPlayerProxy.ep("", paramString);
      }
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel().EVh.aXc();
    }
    AppMethodBeat.o(335297);
  }
  
  private final void a(String paramString, FeedData paramFeedData)
  {
    AppMethodBeat.i(370244);
    Object localObject1 = this.Gpb;
    String str1;
    Object localObject3;
    int i;
    boolean bool;
    float f;
    if (localObject1 == null)
    {
      localObject1 = null;
      str1 = String.valueOf(hashCode());
      localObject3 = this.Flb;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("player");
        localObject2 = null;
      }
      i = localObject2.hashCode();
      bool = this.Flr;
      f = getAlpha();
      localObject2 = this.surface;
      if (localObject2 != null) {
        break label399;
      }
    }
    label399:
    for (Object localObject2 = null;; localObject2 = Boolean.valueOf(((Surface)localObject2).isValid()))
    {
      int j = this.currentPlayState;
      int k = paramFeedData.getPosition();
      localObject3 = com.tencent.mm.ae.d.hF(paramFeedData.getFeedId());
      String str2 = paramFeedData.getDescription();
      paramFeedData = paramFeedData.getNickName();
      this.Gpj.apR(this.FkY);
      this.FkY = ("FTPP." + k + '.' + o.aBv(str2) + '.' + o.aBv(str1));
      getRenderView().setTagPrefix(this.FkY);
      this.Gpf.setMediaId(paramString);
      this.Gpf.position = k;
      String str3 = this.FkY;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initFTPPTag pos:").append(k).append(" mediaId:").append(paramString).append(" feedId:").append((String)localObject3).append(" nickName:").append(paramFeedData).append(" description:").append(str2).append(" viewFocus:").append(bool).append("loaderProxyHashCode:").append(localObject1).append(" finderThumbPlayerProxyHashCode:").append(str1).append(" playerHashCode:").append(i).append(" viewFocus:").append(this.Flr).append(" viewAlpha:").append(f).append(" surfaceIsValid:");
      localStringBuilder.append(localObject2).append(" playerState:").append(j);
      Log.i(str3, localStringBuilder.toString());
      AppMethodBeat.o(370244);
      return;
      localObject1 = Integer.valueOf(((c)localObject1).hashCode());
      break;
    }
  }
  
  private final void ab(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(335118);
    if (TextUtils.isEmpty((CharSequence)paramString2))
    {
      Log.w(getFTPPTag(), s.X("prepareCacheFile(), return for online url:", paramString2));
      AppMethodBeat.o(335118);
      return;
    }
    this.Gpf.aCn("预加载完成");
    String str = y.n(paramString2, false);
    Log.i(getFTPPTag(), "prepareCacheFile(), cache file:" + str + ", isExists:" + y.ZC(str) + ' ' + getProxyState());
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
    paramString2 = locala;
    if (locala == null)
    {
      s.bIx("player");
      paramString2 = null;
    }
    paramString2.setMediaId(paramString1);
    paramString1 = this.Flb;
    if (paramString1 == null)
    {
      s.bIx("player");
      paramString1 = localObject;
    }
    for (;;)
    {
      paramString1.setDataSource(str);
      RS(2);
      RQ(paramInt);
      AppMethodBeat.o(335118);
      return;
    }
  }
  
  private final com.tencent.mm.plugin.thumbplayer.render.a af(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(335027);
    dhZ();
    Object localObject;
    if ((!paramBoolean) && (Build.VERSION.SDK_INT >= 24))
    {
      localObject = MMApplicationContext.getContext();
      s.s(localObject, "getContext()");
      localObject = new MMSurfaceViewRender((Context)localObject);
      ((MMSurfaceViewRender)localObject).setSurfaceViewSwitchHelper(this.Gpj);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.thumbplayer.render.a)localObject).setTagPrefix(TAG);
      ((com.tencent.mm.plugin.thumbplayer.render.a)localObject).setOpaqueInfo(true);
      com.tencent.mm.plugin.thumbplayer.render.a locala = (com.tencent.mm.plugin.thumbplayer.render.a)localObject;
      d locald2 = this.GoY;
      d locald1 = locald2;
      if (locald2 == null)
      {
        s.bIx("playerListener");
        locald1 = null;
      }
      locala.setSurfaceListener((a.a)locald1);
      Log.i(TAG, "getRenderView " + paramString + " renderView:" + localObject + " version:" + Build.VERSION.SDK_INT);
      paramString = (com.tencent.mm.plugin.thumbplayer.render.a)localObject;
      AppMethodBeat.o(335027);
      return paramString;
      localObject = MMApplicationContext.getContext();
      s.s(localObject, "getContext()");
      localObject = new MMTextureViewRender((Context)localObject);
    }
  }
  
  private final void azE(String paramString)
  {
    ab localab2 = null;
    Object localObject = null;
    ab localab1 = null;
    AppMethodBeat.i(335230);
    if (this.ELh)
    {
      AppMethodBeat.o(335230);
      return;
    }
    if (s.p(paramString, "startInternal"))
    {
      if (this.Flg == 2)
      {
        this.Gpf.aCn("预渲染");
        Log.i(getFTPPTag(), s.X("FTPP.handleOnFirstFrameRendered rendered for ", Integer.valueOf(this.Flg)));
        this.Gpf.Fqp = (SystemClock.elapsedRealtime() - this.Gpf.Fqp);
        localab2 = this.Flu;
        if (localab2 != null)
        {
          paramString = this.Flb;
          if (paramString != null) {
            break label143;
          }
          s.bIx("player");
          paramString = localab1;
        }
        label143:
        for (;;)
        {
          localab2.ph(paramString.hLd());
          this.ELh = true;
          AppMethodBeat.o(335230);
          return;
        }
      }
      Log.w(getFTPPTag(), "FTPP.handleOnFirstFrameRendered " + paramString + " return for " + this.Flg);
      AppMethodBeat.o(335230);
      return;
    }
    if (s.p(paramString, "onFirstFrameRendered")) {
      switch (this.Flg)
      {
      default: 
        Log.w(getFTPPTag(), "FTPP.handleOnFirstFrameRendered " + paramString + " return for " + this.Flg);
        AppMethodBeat.o(335230);
        return;
      case 1: 
        Log.i(getFTPPTag(), s.X("FTPP.handleOnFirstFrameRendered background prepared first frame ", getProxyState()));
        setBgPrepareStatus(2);
        localab1 = this.Flu;
        if (localab1 == null) {
          break;
        }
        paramString = this.ANI;
        if (paramString == null) {}
        for (paramString = localab2;; paramString = paramString.Grz)
        {
          localab1.a(paramString);
          AppMethodBeat.o(335230);
          return;
        }
      case 0: 
        Log.i(getFTPPTag(), s.X("FTPP.handleOnFirstFrameRendered onFirstFrameRendered ", getProxyState()));
        this.Gpf.Fqp = (SystemClock.elapsedRealtime() - this.Gpf.Fqp);
        localab1 = this.Flu;
        if (localab1 != null)
        {
          paramString = this.Flb;
          if (paramString != null) {
            break label422;
          }
          s.bIx("player");
          paramString = localObject;
        }
        label422:
        for (;;)
        {
          localab1.ph(paramString.hLd());
          this.ELh = true;
          AppMethodBeat.o(335230);
          return;
        }
      }
    } else {
      Log.w(getFTPPTag(), "FTPP.handleOnFirstFrameRendered " + paramString + " return for " + this.Flg);
    }
    AppMethodBeat.o(335230);
  }
  
  private final void b(final v paramv)
  {
    AppMethodBeat.i(335241);
    Log.i(getFTPPTag(), s.X("startProgressTimer ", getProxyState()));
    if (this.Flh == null)
    {
      this.Flh = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)new m(this, paramv), true);
      paramv = this.Flh;
      if (paramv != null) {
        paramv.setLogging(false);
      }
    }
    paramv = this.Flh;
    if ((paramv != null) && (paramv.stopped() == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramv = this.Flh;
        if (paramv != null) {
          paramv.startTimer(0L, 20L);
        }
      }
      AppMethodBeat.o(335241);
      return;
    }
  }
  
  private final void b(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(335103);
    if (((getRenderView() instanceof View)) && (((View)getRenderView()).getParent() != null)) {
      removeView((View)getRenderView());
    }
    Object localObject;
    label66:
    label86:
    int i;
    label161:
    int j;
    if (paramBoolean) {
      if ((getRenderView() instanceof MMTextureViewRender))
      {
        localObject = getRenderView();
        setRenderView((com.tencent.mm.plugin.thumbplayer.render.a)localObject);
        if (!(getRenderView() instanceof MMSurfaceViewRender)) {
          break label460;
        }
        this.Gpf.aCo("SurfaceView");
        this.Gpf.aCp(paramv.ANK.eCd().detail);
        if (!this.isLongVideo) {
          break label473;
        }
        localObject = aw.Gjk;
        localObject = getContext();
        s.s(localObject, "context");
        paramv = aw.a((Context)localObject, paramv.ANK.eCF().width, paramv.ANK.eCF().height);
        i = ((Number)paramv.bsD).intValue();
        j = ((Number)paramv.aiuN).intValue();
        paramv = new FrameLayout.LayoutParams(-2, -2);
        paramv.gravity = 17;
        addView((View)getRenderView(), (ViewGroup.LayoutParams)paramv);
        paramv = getRenderView();
        if (!(paramv instanceof MMSurfaceViewRender)) {
          break label526;
        }
      }
    }
    label526:
    for (paramv = (MMSurfaceViewRender)paramv;; paramv = null)
    {
      if (paramv != null) {
        ((MMSurfaceViewRender)getRenderView()).setZOrderMediaOverlay(true);
      }
      getRenderView().mj(i, j);
      Log.i(getFTPPTag(), "initRenderView renderView:" + getRenderView() + " isLongVideo:" + this.isLongVideo + " containerWidth:" + i + " containerHeight:" + j + ' ' + getProxyState());
      AppMethodBeat.o(335103);
      return;
      localObject = af(true, "initRenderView#TextureView");
      break;
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eYl().bmg()).intValue() != 2) {
        break label66;
      }
      if (com.tencent.mm.plugin.finder.storage.w.a(paramv.ANK.eCd())) {
        if ((getRenderView() instanceof MMTextureViewRender)) {
          localObject = af(false, "initRenderView#SurfaceView");
        }
      }
      for (;;)
      {
        setRenderView((com.tencent.mm.plugin.thumbplayer.render.a)localObject);
        break;
        localObject = getRenderView();
        continue;
        if ((getRenderView() instanceof MMTextureViewRender)) {
          localObject = getRenderView();
        } else {
          localObject = af(true, "initRenderView#TextureView");
        }
      }
      label460:
      this.Gpf.aCo("TextureView");
      break label86;
      label473:
      paramv = com.tencent.mm.plugin.finder.storage.data.i.a(paramv.ANK.eCF(), this.Flq);
      localObject = aw.Gjk;
      localObject = getContext();
      s.s(localObject, "context");
      paramv = aw.i((Context)localObject, paramv.getWidth(), paramv.getHeight());
      break label161;
    }
  }
  
  private static final void c(FinderThumbPlayerProxy paramFinderThumbPlayerProxy)
  {
    AppMethodBeat.i(335285);
    s.u(paramFinderThumbPlayerProxy, "this$0");
    paramFinderThumbPlayerProxy.Gpj.hLq();
    AppMethodBeat.o(335285);
  }
  
  private final boolean cNW()
  {
    return this.currentPlayState == 3;
  }
  
  private final boolean cxs()
  {
    switch (this.currentPlayState)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private final void dhZ()
  {
    AppMethodBeat.i(335006);
    Log.i(getFTPPTag(), "releaseSurface " + getProxyState() + ", isReusing = " + this.Gph);
    if (this.surface != null)
    {
      com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
      Object localObject = locala;
      if (locala == null)
      {
        s.bIx("player");
        localObject = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setSurface(null);
      localObject = this.surface;
      if (localObject != null) {
        ((Surface)localObject).release();
      }
      this.surface = null;
      this.Fle = null;
    }
    AppMethodBeat.o(335006);
  }
  
  private final void eLO()
  {
    AppMethodBeat.i(335252);
    Log.i(getFTPPTag(), "stopProgressTimer :" + this.Flh + ' ' + getProxyState());
    Object localObject = this.ANI;
    if (localObject != null) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new p(this, (v)localObject, getCurrentPlayMs(), getVideoDurationMs()));
    }
    localObject = this.Flh;
    if (localObject != null) {
      ((MTimerHandler)localObject).stopTimer();
    }
    AppMethodBeat.o(335252);
  }
  
  private static boolean fjf()
  {
    AppMethodBeat.i(335036);
    int i = m.aOK();
    int j = i >> 12 & 0xF;
    int k = i & 0xFF;
    int m = Build.VERSION.SDK_INT;
    int n = com.tencent.mm.media.util.d.nFC.bqn();
    long l = com.tencent.matrix.e.a.aG(MMApplicationContext.getContext()) / 1024L / 1024L;
    boolean bool1;
    boolean bool2;
    label69:
    boolean bool3;
    label78:
    boolean bool4;
    if (j >= 4)
    {
      bool1 = true;
      if (k < 71) {
        break label257;
      }
      bool2 = true;
      if (m < 23) {
        break label263;
      }
      bool3 = true;
      if (l < 4096L) {
        break label269;
      }
      bool4 = true;
      label90:
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (n < ((Number)com.tencent.mm.plugin.finder.storage.d.eVi().bmg()).intValue()) {
        break label275;
      }
    }
    label257:
    label263:
    label269:
    label275:
    for (boolean bool5 = true;; bool5 = false)
    {
      Log.i(TAG, "checkRendererSharpenLocalConfig, cpuFlags:%s, nCores:%s,gpuScore %s nFreq:%s, sdkInt:%s, totalMemMB:%s, coreNumCheck:%s, freqCheck:%s, sdkIntCheck:%s, totalMemMBCheck:%s gpuCheck:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5) });
      if ((!bool1) || (!bool2) || (!bool3) || (!bool4) || (!bool5)) {
        break label281;
      }
      AppMethodBeat.o(335036);
      return true;
      bool1 = false;
      break;
      bool2 = false;
      break label69;
      bool3 = false;
      break label78;
      bool4 = false;
      break label90;
    }
    label281:
    AppMethodBeat.o(335036);
    return false;
  }
  
  private final void fjg()
  {
    AppMethodBeat.i(335153);
    Log.i(getFTPPTag(), "startCdnDownload()");
    if (this.Flw)
    {
      Log.i(getFTPPTag(), s.X("startCdnDownload() already start cdn ", getProxyState()));
      AppMethodBeat.o(335153);
      return;
    }
    fji();
    Object localObject1 = av.GiL;
    Object localObject2 = this.Gpb;
    localObject1 = this.Gpb;
    if (localObject1 == null)
    {
      localObject1 = null;
      Object localObject3 = aw.Gjk;
      if ((localObject2 == null) || (localObject1 == null)) {
        break label355;
      }
      Log.i(getFTPPTag(), s.X("startCdnDownload() ", getProxyState()));
      localObject3 = getMediaPreloadCore$plugin_finder_release();
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.finder.preload.f)localObject3).bI(((c)localObject2).mediaId, true);
      }
      if (((az)localObject1).eDw()) {
        break label338;
      }
      if (this.Gpg)
      {
        localObject1 = getMediaPreloadCore$plugin_finder_release();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.preload.f)localObject1).azi(((c)localObject2).mediaId);
        }
      }
      uD(false);
      Log.i(getFTPPTag(), "startCdnDownload: isLongTermId = " + Gpm.contains(((c)localObject2).mediaId) + " isLongTermView = " + this.Gph + " ignoreLongTerm = " + getIgnoreLongTerm());
      if ((Gpm.contains(((c)localObject2).mediaId)) && (!this.Gph) && (!getIgnoreLongTerm())) {
        break label330;
      }
      ((PluginThumbPlayer)com.tencent.mm.kernel.h.az(PluginThumbPlayer.class)).getCdnTaskController().a(((c)localObject2).mediaId, (com.tencent.mm.plugin.thumbplayer.b.b)new i((c)localObject2), (com.tencent.mm.plugin.thumbplayer.b.e)new j(this));
    }
    for (;;)
    {
      setStartCdn(true);
      localObject1 = this.ANI;
      if (localObject1 == null) {
        break label355;
      }
      localObject2 = getDownloadCallback();
      if (localObject2 != null) {
        ((aa)localObject2).b(((v)localObject1).ANK);
      }
      AppMethodBeat.o(335153);
      return;
      localObject1 = ((c)localObject1).Ezi;
      break;
      label330:
      uD(true);
    }
    label338:
    Log.i(getFTPPTag(), s.X("startCdnDownload() downloadFinish ", getProxyState()));
    label355:
    AppMethodBeat.o(335153);
  }
  
  private final void fji()
  {
    AppMethodBeat.i(335165);
    Log.i(getFTPPTag(), "stopCdnPreload()");
    if (!this.Flx)
    {
      Log.i(getFTPPTag(), s.X("stopCdnPreload(), not start preload cdn ", getProxyState()));
      AppMethodBeat.o(335165);
      return;
    }
    c localc = this.Gpb;
    if (localc != null)
    {
      ((PluginThumbPlayer)com.tencent.mm.kernel.h.az(PluginThumbPlayer.class)).getCdnTaskController().a(localc.mediaId, (com.tencent.mm.plugin.thumbplayer.b.f)new o(this));
      setStartCdnPreload(false);
    }
    AppMethodBeat.o(335165);
  }
  
  private final Bitmap getCoverBitmap()
  {
    AppMethodBeat.i(335183);
    if (this.Gpl != null) {
      Log.i(TAG, s.X("getCoverBitmap return cache coverBitmap:", this.Gpl));
    }
    for (;;)
    {
      Object localObject1 = this.Gpl;
      AppMethodBeat.o(335183);
      return localObject1;
      try
      {
        localObject1 = getParent();
        if (localObject1 != null) {
          break;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(335183);
        throw ((Throwable)localObject1);
      }
      finally
      {
        Log.w(TAG, s.X("getCoverBitmap return e:", localObject2));
      }
    }
    Object localObject3 = (ImageView)((ViewGroup)localObject2).findViewById(e.e.thumb_video);
    if (localObject3 == null) {}
    for (localObject3 = null;; localObject3 = ((ImageView)localObject3).getDrawable())
    {
      if (!(localObject3 instanceof BitmapDrawable)) {
        break label216;
      }
      localObject3 = (BitmapDrawable)localObject3;
      break label207;
      label122:
      if (localObject3 == null) {
        break label214;
      }
      if (((Bitmap)localObject3).isRecycled()) {
        break label185;
      }
      this.Gpl = Bitmap.createScaledBitmap((Bitmap)localObject3, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight(), true);
      Log.i(TAG, s.X("getCoverBitmap return new coverBitmap:", this.Gpl));
      break;
    }
    label185:
    label207:
    label214:
    label216:
    label219:
    for (;;)
    {
      localObject3 = ((BitmapDrawable)localObject3).getBitmap();
      break label122;
      Log.i(TAG, s.X("getCoverBitmap return isRecycled", Boolean.valueOf(((Bitmap)localObject3).isRecycled())));
      break;
      for (;;)
      {
        if (localObject3 != null) {
          break label219;
        }
        localObject3 = null;
        break label122;
        break;
        localObject3 = null;
      }
    }
  }
  
  private final com.tencent.mm.plugin.finder.video.reporter.a getFTPPKVReporter()
  {
    AppMethodBeat.i(334946);
    com.tencent.mm.plugin.finder.video.reporter.a locala = (com.tencent.mm.plugin.finder.video.reporter.a)this.Gpc.getValue();
    AppMethodBeat.o(334946);
    return locala;
  }
  
  private final com.tencent.mm.plugin.finder.video.log.a getFTPPLog()
  {
    AppMethodBeat.i(334953);
    com.tencent.mm.plugin.finder.video.log.a locala = (com.tencent.mm.plugin.finder.video.log.a)this.Gpd.getValue();
    AppMethodBeat.o(334953);
    return locala;
  }
  
  private final String getProxyState()
  {
    AppMethodBeat.i(335070);
    boolean bool = this.Flr;
    float f = getAlpha();
    Object localObject = this.surface;
    if (localObject == null) {}
    for (localObject = null;; localObject = Boolean.valueOf(((Surface)localObject).isValid()))
    {
      int i = this.currentPlayState;
      localObject = bool + '-' + f + '-' + localObject + '-' + i;
      AppMethodBeat.o(335070);
      return localObject;
    }
  }
  
  private final void init()
  {
    AppMethodBeat.i(334990);
    Fly.add(Integer.valueOf(hashCode()));
    Log.i(TAG, "create FinderThumbPlayerProxy " + hashCode() + " enableMediaCodecReuse:" + this.FkZ + ' ' + Fly);
    com.tencent.tmediacodec.a.kcn().OE(this.FkZ);
    Object localObject1 = com.tencent.mm.plugin.thumbplayer.e.d.TFK;
    localObject1 = MMApplicationContext.getContext();
    s.s(localObject1, "getContext()");
    this.Flb = com.tencent.mm.plugin.thumbplayer.e.d.a.kr((Context)localObject1);
    this.GoY = new d();
    int i;
    label172:
    Object localObject3;
    Object localObject2;
    if (this.FkZ)
    {
      i = 1;
      this.ANO = new com.tencent.mm.plugin.finder.video.reporter.e(i);
      this.ANP.reset();
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eYl().bmg()).intValue() != 1) {
        break label546;
      }
      localObject1 = af(false, "init#SurfaceView");
      setRenderView((com.tencent.mm.plugin.thumbplayer.render.a)localObject1);
      getRenderView().setTagPrefix(TAG);
      getRenderView().setOpaqueInfo(true);
      localObject3 = getRenderView();
      localObject2 = this.GoY;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("playerListener");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.render.a)localObject3).setSurfaceListener((a.a)localObject1);
      localObject1 = this.Flb;
      if (localObject1 != null) {
        break label558;
      }
      s.bIx("player");
      localObject1 = null;
      label252:
      localObject3 = this.GoY;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("playerListener");
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnErrorListener((ITPPlayerListener.IOnErrorListener)localObject2);
      localObject1 = this.Flb;
      if (localObject1 != null) {
        break label561;
      }
      s.bIx("player");
      localObject1 = null;
      label301:
      localObject3 = this.GoY;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("playerListener");
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnPreparedListener((ITPPlayerListener.IOnPreparedListener)localObject2);
      localObject1 = this.Flb;
      if (localObject1 != null) {
        break label564;
      }
      s.bIx("player");
      localObject1 = null;
      label350:
      localObject3 = this.GoY;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("playerListener");
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnVideoSizeChangedListener((ITPPlayerListener.IOnVideoSizeChangedListener)localObject2);
      localObject1 = this.Flb;
      if (localObject1 != null) {
        break label567;
      }
      s.bIx("player");
      localObject1 = null;
      label399:
      localObject3 = this.GoY;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("playerListener");
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnPlayerStateChangeListener((ITPPlayerListener.IOnStateChangeListener)localObject2);
      localObject1 = this.Flb;
      if (localObject1 != null) {
        break label570;
      }
      s.bIx("player");
      localObject1 = null;
      label448:
      localObject3 = this.GoY;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("playerListener");
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnInfoListener((ITPPlayerListener.IOnInfoListener)localObject2);
      localObject1 = this.Flb;
      if (localObject1 != null) {
        break label573;
      }
      s.bIx("player");
      localObject1 = null;
    }
    label546:
    label558:
    label561:
    label564:
    label567:
    label570:
    label573:
    for (;;)
    {
      localObject3 = this.GoY;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("playerListener");
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnCompletionListener((ITPPlayerListener.IOnCompletionListener)localObject2);
      RS(1);
      AppMethodBeat.o(334990);
      return;
      i = 0;
      break;
      localObject1 = af(true, "init#TextureView");
      break label172;
      break label252;
      break label301;
      break label350;
      break label399;
      break label448;
    }
  }
  
  private final boolean iu(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(335132);
    if (TextUtils.isEmpty((CharSequence)paramString2))
    {
      Log.w(getFTPPTag(), "prepareOnlineUrl(), return for online url:" + paramString2 + "  " + getProxyState());
      AppMethodBeat.o(335132);
      return false;
    }
    Log.i(getFTPPTag(), "prepareOnlineUrl(), online url:" + paramString2 + "  " + getProxyState());
    TPVideoInfo.Builder localBuilder = new TPVideoInfo.Builder();
    localBuilder.fileId(paramString1);
    localBuilder.downloadParam(new TPDownloadParamData(11));
    com.tencent.mm.plugin.thumbplayer.e.a locala2 = this.Flb;
    com.tencent.mm.plugin.thumbplayer.e.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("player");
      locala1 = null;
    }
    locala1.setMediaId(paramString1);
    locala1 = this.Flb;
    paramString1 = locala1;
    if (locala1 == null)
    {
      s.bIx("player");
      paramString1 = null;
    }
    paramString1.setVideoInfo(localBuilder.build());
    paramString1 = this.Flb;
    if (paramString1 == null)
    {
      s.bIx("player");
      paramString1 = localObject;
    }
    for (;;)
    {
      paramString1.setDataSource(paramString2);
      RS(2);
      boolean bool = RQ(5);
      AppMethodBeat.o(335132);
      return bool;
    }
  }
  
  private final void setBgPrepareStatus(int paramInt)
  {
    AppMethodBeat.i(335212);
    Log.i(getFTPPTag(), "setBgPrepareStatus " + paramInt + ' ' + getProxyState());
    this.Flg = paramInt;
    AppMethodBeat.o(335212);
  }
  
  private final void startInternal()
  {
    AppMethodBeat.i(335016);
    Log.i(getFTPPTag(), s.X("startInternal() ", getProxyState()));
    azE("startInternal");
    setBgPrepareStatus(0);
    Object localObject = this.Fll;
    if (localObject != null) {
      ((com.tencent.mm.plugin.findersdk.f.a)localObject).aDn("start");
    }
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
    localObject = locala;
    if (locala == null)
    {
      s.bIx("player");
      localObject = null;
    }
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).start();
    RS(5);
    localObject = this.ANI;
    if (localObject != null) {
      b((v)localObject);
    }
    AppMethodBeat.o(335016);
  }
  
  private final void uD(boolean paramBoolean)
  {
    AppMethodBeat.i(335061);
    Log.i(getFTPPTag(), s.X("updateIsReaStartDownloader() isReaStartDownloader:", Boolean.valueOf(paramBoolean)));
    this.Flm.set(paramBoolean);
    AppMethodBeat.o(335061);
  }
  
  public final boolean RP(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(336110);
    Log.i(getFTPPTag(), "playWithSource() source=" + paramInt + ' ' + getProxyState() + ' ');
    if (!this.Flr)
    {
      Log.i(getFTPPTag(), s.X("playWithSource() return for isViewFocused:", Boolean.valueOf(this.Flr)));
      AppMethodBeat.o(336110);
      return false;
    }
    if (!RR(this.currentPlayState))
    {
      Log.i(getFTPPTag(), s.X("playWithSource() return for currentState:", Integer.valueOf(this.currentPlayState)));
      AppMethodBeat.o(336110);
      return false;
    }
    boolean bool = isPlaying();
    if ((bool) && (paramInt != -1))
    {
      Log.i(getFTPPTag(), s.X("playWithSource() return for isPlaying:", Boolean.valueOf(bool)));
      AppMethodBeat.o(336110);
      return false;
    }
    Object localObject1;
    if (cxs()) {
      if (this.Gpi)
      {
        startInternal();
        fjg();
        localObject1 = this.Flb;
        if (localObject1 != null) {
          break label264;
        }
        s.bIx("player");
        localObject1 = localObject2;
      }
    }
    label264:
    for (;;)
    {
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).resumeDownload();
      AppMethodBeat.o(336110);
      return true;
      localObject1 = this.surface;
      if (localObject1 == null) {
        break;
      }
      if (((Surface)localObject1).isValid()) {}
      for (;;)
      {
        if (localObject1 == null) {
          break label246;
        }
        startInternal();
        break;
        localObject1 = null;
      }
      label246:
      break;
      if (cNW()) {
        break;
      }
      RQ(0);
      break;
    }
  }
  
  public final void a(com.tencent.mm.live.core.core.c.b paramb, long paramLong)
  {
    AppMethodBeat.i(335898);
    s.u(paramb, "txPlayer");
    AppMethodBeat.o(335898);
  }
  
  public final void a(com.tencent.mm.plugin.finder.loader.x paramx, boolean paramBoolean, FeedData paramFeedData)
  {
    AppMethodBeat.i(335838);
    s.u(paramx, "video");
    s.u(paramFeedData, "feedData");
    Object localObject = this.Fll;
    if (localObject != null) {
      ((com.tencent.mm.plugin.findersdk.f.a)localObject).aDn("setMediaInfo");
    }
    dji localdji = paramx.eCF();
    String str = paramx.aUt();
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    a((String)localObject, paramFeedData);
    if (paramBoolean)
    {
      str = localdji.url;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramx = (v)new com.tencent.mm.plugin.finder.video.source.a("", (String)localObject, paramx.aUt(), localdji, paramx, paramFeedData);
      this.ANI = paramx;
      paramx = this.Gpb;
      if (paramx != null) {
        break label311;
      }
      paramx = null;
      label143:
      paramFeedData = this.ANI;
      s.checkNotNull(paramFeedData);
      if (s.p(paramx, paramFeedData.mediaId)) {
        break label319;
      }
      paramx = this.ANI;
      s.checkNotNull(paramx);
      paramx = paramx.mediaId;
      paramFeedData = this.ANI;
      s.checkNotNull(paramFeedData);
      this.Gpb = new c(paramx, paramFeedData);
      Log.i(getFTPPTag(), s.X("setVideoMediaInfo(), init proxy ", this.Gpb));
    }
    for (;;)
    {
      paramx = this.ANI;
      s.checkNotNull(paramx);
      b(paramx, false);
      this.ANP.reset();
      paramx = this.ANP;
      paramFeedData = this.ANI;
      s.checkNotNull(paramFeedData);
      paramx.init(paramFeedData.mediaId);
      this.ANP.fjU();
      AppMethodBeat.o(335838);
      return;
      paramx = (v)new com.tencent.mm.plugin.finder.video.source.b(paramx.getUrl(), paramx.getPath(), paramx.aUt(), localdji, paramx, paramFeedData);
      break;
      label311:
      paramx = paramx.mediaId;
      break label143;
      label319:
      Log.w(getFTPPTag(), s.X("setVideoMediaInfo(), duplicated mediaId ", this.Gpb));
    }
  }
  
  public final void a(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(335866);
    this.Gph = true;
    this.Gpe = null;
    this.Gpk = null;
    this.Flu = null;
    this.Flv = null;
    this.Gpa = null;
    this.EAt = null;
    animate().cancel();
    animate().setListener(null);
    Object localObject1;
    label118:
    Object localObject2;
    if (paramv != null)
    {
      if (!(paramv instanceof com.tencent.mm.plugin.finder.video.source.a)) {
        break label318;
      }
      localObject1 = (v)new com.tencent.mm.plugin.finder.video.source.a("", paramv.path, paramv.mediaId, paramv.Grz, paramv.ANK, paramv.AWA);
      this.ANI = ((v)localObject1);
      localObject1 = this.Gpb;
      if (localObject1 != null) {
        break label356;
      }
      localObject1 = null;
      localObject2 = this.ANI;
      s.checkNotNull(localObject2);
      if (s.p(localObject1, ((v)localObject2).mediaId)) {
        break label364;
      }
      localObject1 = this.ANI;
      s.checkNotNull(localObject1);
      localObject1 = ((v)localObject1).mediaId;
      localObject2 = this.ANI;
      s.checkNotNull(localObject2);
      this.Gpb = new c((String)localObject1, (v)localObject2);
      Log.i(getFTPPTag(), s.X("setVideoMediaInfo(), init proxy ", this.Gpb));
    }
    for (;;)
    {
      localObject2 = paramv.ANK.aUt();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      a((String)localObject1, paramv.AWA);
      paramv = this.ANI;
      s.checkNotNull(paramv);
      b(paramv, paramBoolean);
      this.ANP.reset();
      paramv = this.ANP;
      localObject1 = this.ANI;
      s.checkNotNull(localObject1);
      paramv.init(((v)localObject1).mediaId);
      this.ANP.fjU();
      Log.i(getFTPPTag(), "prepareForReuseTPView");
      paramv = this.Gpb;
      if (paramv != null) {
        Gpm.add(paramv.mediaId);
      }
      AppMethodBeat.o(335866);
      return;
      label318:
      localObject1 = (v)new com.tencent.mm.plugin.finder.video.source.b(paramv.downloadUrl, paramv.path, paramv.mediaId, paramv.Grz, paramv.ANK, paramv.AWA);
      break;
      label356:
      localObject1 = ((c)localObject1).mediaId;
      break label118;
      label364:
      Log.w(getFTPPTag(), s.X("setVideoMediaInfo(), duplicated mediaId ", this.Gpb));
    }
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(336211);
    paramBoolean = b(kotlin.h.a.ai(1000.0D * paramDouble), paramBoolean, paramInt);
    AppMethodBeat.o(336211);
    return paramBoolean;
  }
  
  public final boolean b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(336199);
    paramBoolean = a(paramDouble, paramBoolean, 1);
    AppMethodBeat.o(336199);
    return paramBoolean;
  }
  
  public final boolean b(long paramLong, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(336222);
    if (!RR(this.currentPlayState))
    {
      AppMethodBeat.o(336222);
      return false;
    }
    if (!cxs())
    {
      AppMethodBeat.o(336222);
      return false;
    }
    Log.i(getFTPPTag(), "seekToMs " + paramLong + ' ' + paramBoolean);
    com.tencent.mm.plugin.thumbplayer.e.a locala2 = this.Flb;
    com.tencent.mm.plugin.thumbplayer.e.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("player");
      locala1 = null;
    }
    locala1.seekTo((int)paramLong, paramInt);
    if (paramBoolean) {
      bNU();
    }
    AppMethodBeat.o(336222);
    return true;
  }
  
  public final boolean bNU()
  {
    AppMethodBeat.i(336090);
    Log.i(getFTPPTag(), "play()");
    boolean bool = RP(0);
    AppMethodBeat.o(336090);
    return bool;
  }
  
  public final boolean boa()
  {
    return this.nvB;
  }
  
  public final boolean eLI()
  {
    AppMethodBeat.i(336143);
    if (this.Flr)
    {
      Log.i(getFTPPTag(), s.X("prepareToPlay() return for isViewFocused:", Boolean.valueOf(this.Flr)));
      AppMethodBeat.o(336143);
      return false;
    }
    if ((getRenderView() instanceof MMSurfaceViewRender))
    {
      Log.i(getFTPPTag(), s.X("prepareToPlay() return for renderview:", getRenderView()));
      AppMethodBeat.o(336143);
      return false;
    }
    Log.i(getFTPPTag(), s.X("prepareToPlay()  ", getProxyState()));
    if (RR(this.currentPlayState))
    {
      if (this.currentPlayState == 2)
      {
        bool1 = RQ(1);
        AppMethodBeat.o(336143);
        return bool1;
      }
      AppMethodBeat.o(336143);
      return false;
    }
    Object localObject = this.Gpb;
    if (localObject != null) {
      ((c)localObject).fjl();
    }
    localObject = av.GiL;
    v localv = this.ANI;
    c localc = this.Gpb;
    localObject = this.Gpb;
    boolean bool2;
    if (localObject == null)
    {
      localObject = null;
      aw localaw = aw.Gjk;
      if ((localv == null) || (localc == null) || (localObject == null)) {
        break label354;
      }
      bool1 = ((az)localObject).eDw();
      bool2 = y.ZC(localv.path);
      Log.i(getFTPPTag(), "prepareToPlay() isAllCompleted:" + bool1 + " isExist:" + bool2 + ' ' + getProxyState());
      if (!(localv instanceof com.tencent.mm.plugin.finder.video.source.a)) {
        break label292;
      }
      ab(localv.mediaId, localv.path, 21);
    }
    for (;;)
    {
      AppMethodBeat.o(336143);
      return true;
      localObject = ((c)localObject).Ezi;
      break;
      label292:
      if ((!(localv instanceof com.tencent.mm.plugin.finder.video.source.b)) || (!bool1) || (!bool2)) {
        break label327;
      }
      ab(localv.mediaId, localv.path, 22);
    }
    label327:
    fjg();
    boolean bool1 = iu(localv.mediaId, localv.downloadUrl);
    AppMethodBeat.o(336143);
    return bool1;
    label354:
    AppMethodBeat.o(336143);
    return false;
  }
  
  public final int eLK()
  {
    AppMethodBeat.i(336167);
    Log.i(getFTPPTag(), s.X("pauseWithCancel ", getProxyState()));
    this.ANP.fjV();
    pause();
    AppMethodBeat.o(336167);
    return 0;
  }
  
  public final void eLL()
  {
    AppMethodBeat.i(336243);
    a(null, false);
    AppMethodBeat.o(336243);
  }
  
  public final void eLM() {}
  
  public final boolean eLN()
  {
    return false;
  }
  
  public final void fjh()
  {
    AppMethodBeat.i(336492);
    Log.i(getFTPPTag(), "stopCdnDownload()");
    if (!this.Flw)
    {
      Log.i(getFTPPTag(), s.X("stopCdnDownload() not start cdn ", getProxyState()));
      AppMethodBeat.o(336492);
      return;
    }
    c localc = this.Gpb;
    if (localc != null)
    {
      Log.i(getFTPPTag(), s.X("stopCdnDownload() ", getProxyState()));
      com.tencent.mm.plugin.finder.preload.f localf = getMediaPreloadCore$plugin_finder_release();
      if (localf != null) {
        localf.bI(localc.mediaId, false);
      }
      localc.uE(false);
      Log.i(getFTPPTag(), "stopCdnDownload: isLongTermId = " + Gpm.contains(localc.mediaId) + " isLongTermView = " + this.Gph + " ignoreLongTerm = " + getIgnoreLongTerm());
      if ((!Gpm.contains(localc.mediaId)) || (this.Gph) || (getIgnoreLongTerm()))
      {
        ((PluginThumbPlayer)com.tencent.mm.kernel.h.az(PluginThumbPlayer.class)).getCdnTaskController().a(localc.mediaId, (g)new n(this));
        setStartCdn(false);
      }
    }
    AppMethodBeat.o(336492);
  }
  
  public final void fjj()
  {
    AppMethodBeat.i(336514);
    if ((getRenderView() instanceof MMSurfaceViewRender)) {
      this.Gpj.a((SurfaceView)getRenderView(), this.surface, getCoverBitmap());
    }
    AppMethodBeat.o(336514);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(335877);
    Bitmap localBitmap = getRenderView().getBitmap();
    AppMethodBeat.o(335877);
    return localBitmap;
  }
  
  public final int getContextTag()
  {
    return this.contextTag;
  }
  
  public final long getCurrentPlayMs()
  {
    AppMethodBeat.i(335938);
    com.tencent.mm.plugin.thumbplayer.e.a locala2 = this.Flb;
    com.tencent.mm.plugin.thumbplayer.e.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("player");
      locala1 = null;
    }
    long l = locala1.getCurrentPositionMs();
    AppMethodBeat.o(335938);
    return l;
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(335927);
    com.tencent.mm.plugin.thumbplayer.e.a locala2 = this.Flb;
    com.tencent.mm.plugin.thumbplayer.e.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("player");
      locala1 = null;
    }
    int i = (int)(locala1.getCurrentPositionMs() / 1000L);
    AppMethodBeat.o(335927);
    return i;
  }
  
  public final int getCurrentPlayState()
  {
    return this.currentPlayState;
  }
  
  public final aa getDownloadCallback()
  {
    return this.Gpk;
  }
  
  public final String getFTPPTag()
  {
    AppMethodBeat.i(336473);
    String str = this.FkY + '.' + this.Flr;
    AppMethodBeat.o(336473);
    return str;
  }
  
  public final boolean getIgnoreLongTerm()
  {
    return this.ignoreLongTerm;
  }
  
  public final boolean getIsNeverStart()
  {
    AppMethodBeat.i(336005);
    if (!RR(this.currentPlayState))
    {
      AppMethodBeat.o(336005);
      return true;
    }
    AppMethodBeat.o(336005);
    return false;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.Fls;
  }
  
  public final ab getLifecycle()
  {
    return this.Flu;
  }
  
  public final com.tencent.mm.plugin.finder.preload.f getMediaPreloadCore$plugin_finder_release()
  {
    return this.Gpa;
  }
  
  public final w getOnMuteListener()
  {
    return this.Flv;
  }
  
  public final x getOnPlayerStopListener()
  {
    return this.Gpe;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(336014);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(336014);
    return localViewParent;
  }
  
  public final float getPlaySpeedRatio()
  {
    return this.Flp;
  }
  
  public final Object getPlayer()
  {
    AppMethodBeat.i(336423);
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
    if (locala == null)
    {
      s.bIx("player");
      AppMethodBeat.o(336423);
      return null;
    }
    AppMethodBeat.o(336423);
    return locala;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.render.a getRenderView()
  {
    AppMethodBeat.i(335697);
    com.tencent.mm.plugin.thumbplayer.render.a locala = this.GoZ;
    if (locala != null)
    {
      AppMethodBeat.o(335697);
      return locala;
    }
    s.bIx("renderView");
    AppMethodBeat.o(335697);
    return null;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(335948);
    com.tencent.mm.plugin.thumbplayer.e.a locala2 = this.Flb;
    com.tencent.mm.plugin.thumbplayer.e.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("player");
      locala1 = null;
    }
    int i = (int)(locala1.getDurationMs() / 1000L);
    AppMethodBeat.o(335948);
    return i;
  }
  
  public final long getVideoDurationMs()
  {
    AppMethodBeat.i(335964);
    com.tencent.mm.plugin.thumbplayer.e.a locala2 = this.Flb;
    com.tencent.mm.plugin.thumbplayer.e.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("player");
      locala1 = null;
    }
    long l = locala1.getDurationMs();
    AppMethodBeat.o(335964);
    return l;
  }
  
  public final String getVideoMediaId()
  {
    Object localObject = this.ANI;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((v)localObject).mediaId;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final v getVideoMediaInfo()
  {
    return this.ANI;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final i.b getVideoViewCallback()
  {
    return this.EAt;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.Flr;
  }
  
  public final void ib(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(336507);
    ((View)getRenderView()).getLayoutParams().width = paramInt1;
    ((View)getRenderView()).getLayoutParams().height = paramInt2;
    getRenderView().mj(paramInt1, paramInt2);
    ((View)getRenderView()).requestLayout();
    AppMethodBeat.o(336507);
  }
  
  public final boolean isPlaying()
  {
    return this.currentPlayState == 5;
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(336454);
    Log.i(getFTPPTag(), "release FinderThumbPlayerProxy " + hashCode() + ' ' + getProxyState());
    this.ANO = null;
    dhZ();
    this.Gpk = null;
    com.tencent.mm.ae.d.e(TAG, (kotlin.g.a.a)new h(this));
    Fly.remove(Integer.valueOf(hashCode()));
    if (this.Gph) {
      Gpm.clear();
    }
    this.Gpb = null;
    this.Flv = null;
    AppMethodBeat.o(336454);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(336190);
    Log.i(getFTPPTag(), s.X("onUIDestroy ", getProxyState()));
    stop();
    this.EAt = null;
    AppMethodBeat.o(336190);
  }
  
  public final boolean pause()
  {
    String str = null;
    int i = 0;
    AppMethodBeat.i(336164);
    if (!RR(this.currentPlayState))
    {
      Log.i(getFTPPTag(), s.X("pause() return for state:", Integer.valueOf(this.currentPlayState)));
      AppMethodBeat.o(336164);
      return false;
    }
    Log.i(getFTPPTag(), s.X("pause()  ", getProxyState()));
    Object localObject2;
    Object localObject1;
    if (isPlaying())
    {
      fjj();
      localObject2 = this.Flb;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("player");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).pause();
      localObject1 = this.Flb;
      if (localObject1 == null)
      {
        s.bIx("player");
        localObject1 = str;
        ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).pauseDownload();
        RS(6);
        label142:
        fjh();
        if (this.Fls)
        {
          Log.i(getFTPPTag(), s.X("startCdnPreload() ", getProxyState()));
          if (!this.Flx) {
            break label300;
          }
          Log.i(getFTPPTag(), s.X("startCdnPreload(), already start preload cdn ", getProxyState()));
        }
      }
    }
    for (;;)
    {
      eLO();
      if (this.ANI != null)
      {
        localObject1 = getLifecycle();
        if (localObject1 != null) {
          ((ab)localObject1).a(this.ANP.fjS());
        }
      }
      AppMethodBeat.o(336164);
      return true;
      break;
      if ((!cNW()) || (this.Flr)) {
        break label142;
      }
      long l = System.currentTimeMillis();
      stop();
      Log.i(getFTPPTag(), "pause() preparing stop cost=" + (System.currentTimeMillis() - l) + "ms");
      break label142;
      label300:
      localObject2 = this.Gpb;
      if ((localObject2 != null) && (((c)localObject2).Ezi.field_cacheSize < ((c)localObject2).Gpz) && (((c)localObject2).Ezi.field_totalSize > 0L))
      {
        localObject1 = ((PluginThumbPlayer)com.tencent.mm.kernel.h.az(PluginThumbPlayer.class)).getCdnTaskController();
        str = ((c)localObject2).mediaId;
        localObject2 = (com.tencent.mm.plugin.thumbplayer.b.b)new k((c)localObject2);
        com.tencent.mm.plugin.thumbplayer.b.d locald = (com.tencent.mm.plugin.thumbplayer.b.d)new l(this);
        s.u(str, "mediaId");
        s.u(localObject2, "createCallback");
        if (((CharSequence)str).length() == 0) {
          i = 1;
        }
        if (i == 0) {
          com.tencent.mm.ae.d.e("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new a.e((com.tencent.mm.plugin.thumbplayer.b.b)localObject2, str, (com.tencent.mm.plugin.thumbplayer.b.a)localObject1, locald));
        }
        setStartCdnPreload(true);
      }
    }
  }
  
  public final com.tencent.mm.plugin.finder.live.fluent.h pu(long paramLong)
  {
    return null;
  }
  
  public final boolean r(Integer paramInteger)
  {
    AppMethodBeat.i(336131);
    Log.i(getFTPPTag(), s.X("startOrPlay() ", getProxyState()));
    this.ANP.fjU();
    if (!this.Flr)
    {
      Log.i(getFTPPTag(), s.X("startOrPlay() return for isViewFocused:", Boolean.valueOf(this.Flr)));
      AppMethodBeat.o(336131);
      return false;
    }
    paramInteger = this.Fll;
    if (paramInteger != null) {
      paramInteger.aDn("startOrPlay");
    }
    if (this.Flf)
    {
      Log.i(getFTPPTag(), "startOrPlay() first time to play");
      paramInteger = this.Flu;
      if (paramInteger != null) {
        paramInteger.a(this.ANO);
      }
      paramInteger = this.Flu;
      if (paramInteger != null) {
        paramInteger.a(this.ANI, this.Flg);
      }
      this.Flf = false;
      this.Gpf.Fqp = SystemClock.elapsedRealtime();
      com.tencent.mm.plugin.report.service.h.OAn.p(1505L, 252L, 1L);
    }
    if (RR(this.currentPlayState))
    {
      Log.i(getFTPPTag(), s.X("startOrPlay() return for currentPlayState:", Integer.valueOf(this.currentPlayState)));
      if (RP(3)) {
        this.Flj = 0;
      }
      AppMethodBeat.o(336131);
      return false;
    }
    paramInteger = this.Gpb;
    if (paramInteger != null) {
      paramInteger.fjl();
    }
    paramInteger = av.GiL;
    v localv = this.ANI;
    c localc = this.Gpb;
    paramInteger = this.Gpb;
    boolean bool1;
    boolean bool2;
    if (paramInteger == null)
    {
      paramInteger = null;
      aw localaw = aw.Gjk;
      if ((localv == null) || (localc == null) || (paramInteger == null)) {
        break label440;
      }
      bool1 = paramInteger.eDw();
      bool2 = y.ZC(localv.path);
      Log.i(getFTPPTag(), "startOrPlay() isAllCompleted:" + bool1 + " isExist:" + bool2 + ' ' + getProxyState());
      this.Flj = 0;
      if (!(localv instanceof com.tencent.mm.plugin.finder.video.source.a)) {
        break label383;
      }
      ab(localv.mediaId, localv.path, 41);
    }
    for (;;)
    {
      AppMethodBeat.o(336131);
      return true;
      paramInteger = paramInteger.Ezi;
      break;
      label383:
      if (((localv instanceof com.tencent.mm.plugin.finder.video.source.b)) && (bool1) && (bool2))
      {
        ab(localv.mediaId, localv.path, 42);
      }
      else
      {
        fjg();
        iu(localv.mediaId, localv.downloadUrl);
      }
    }
    label440:
    AppMethodBeat.o(336131);
    return false;
  }
  
  public final void setContextTag(int paramInt)
  {
    this.contextTag = paramInt;
  }
  
  public final void setCurrentPlayState(int paramInt)
  {
    this.currentPlayState = paramInt;
  }
  
  public final void setDownloadCallback(aa paramaa)
  {
    this.Gpk = paramaa;
  }
  
  public final void setFinderVideoPlayTrace(com.tencent.mm.plugin.findersdk.f.a parama)
  {
    this.Fll = parama;
  }
  
  public final void setFullScreenEnjoy(boolean paramBoolean)
  {
    this.Flq = paramBoolean;
  }
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(336274);
    s.u(paramb, "_callback");
    this.EAt = paramb;
    AppMethodBeat.o(336274);
  }
  
  public final void setIOnlineVideoProxy(com.tencent.mm.modelvideo.f paramf)
  {
    AppMethodBeat.i(336300);
    s.u(paramf, "_proxy");
    AppMethodBeat.o(336300);
  }
  
  public final void setIgnoreLongTerm(boolean paramBoolean)
  {
    this.ignoreLongTerm = paramBoolean;
  }
  
  public final void setInterceptDetach(boolean paramBoolean) {}
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    AppMethodBeat.i(336025);
    Log.i(getFTPPTag(), "setIsShouldPlayResume() " + paramBoolean + ' ' + getProxyState());
    this.Fls = paramBoolean;
    AppMethodBeat.o(336025);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean) {}
  
  public final void setLifecycle(ab paramab)
  {
    this.Flu = paramab;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(336326);
    com.tencent.mm.plugin.thumbplayer.e.a locala2 = this.Flb;
    com.tencent.mm.plugin.thumbplayer.e.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("player");
      locala1 = null;
    }
    locala1.setLoopback(paramBoolean);
    AppMethodBeat.o(336326);
  }
  
  public final void setMediaPreloadCore$plugin_finder_release(com.tencent.mm.plugin.finder.preload.f paramf)
  {
    this.Gpa = paramf;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(336230);
    com.tencent.mm.plugin.thumbplayer.e.a locala2 = this.Flb;
    com.tencent.mm.plugin.thumbplayer.e.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("player");
      locala1 = null;
    }
    locala1.setOutputMute(paramBoolean);
    AppMethodBeat.o(336230);
  }
  
  public final void setOnMuteListener(w paramw)
  {
    this.Flv = paramw;
  }
  
  public final void setOnPlayerStopListener(x paramx)
  {
    this.Gpe = paramx;
  }
  
  public final void setOnlyAudio(boolean paramBoolean)
  {
    this.Gpi = paramBoolean;
  }
  
  public final void setPlaySpeed(float paramFloat)
  {
    long l = 0L;
    Object localObject2 = null;
    AppMethodBeat.i(336513);
    String str = getFTPPTag();
    Object localObject3 = new StringBuilder("setPlaySpeed: ratio = ").append(paramFloat).append(", mediaId = ");
    Object localObject1 = this.ANI;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(", feedId = ");
      localObject3 = this.ANI;
      if (localObject3 != null) {
        break label147;
      }
      label79:
      Log.i(str, com.tencent.mm.ae.d.hF(l));
      localObject1 = this.Flb;
      if (localObject1 != null) {
        break label168;
      }
      s.bIx("player");
      localObject1 = localObject2;
    }
    label147:
    label168:
    for (;;)
    {
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setPlaySpeedRatio(paramFloat);
      this.Flp = paramFloat;
      AppMethodBeat.o(336513);
      return;
      localObject1 = ((v)localObject1).mediaId;
      break;
      localObject3 = ((v)localObject3).AWA;
      if (localObject3 == null) {
        break label79;
      }
      l = ((FeedData)localObject3).getFeedId();
      break label79;
    }
  }
  
  public final void setPlaySpeedRatio(float paramFloat)
  {
    this.Flp = paramFloat;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    this.nvB = paramBoolean;
  }
  
  public final void setRenderView(com.tencent.mm.plugin.thumbplayer.render.a parama)
  {
    AppMethodBeat.i(335709);
    s.u(parama, "<set-?>");
    this.GoZ = parama;
    AppMethodBeat.o(335709);
  }
  
  public final void setScaleType(i.e parame)
  {
    AppMethodBeat.i(336288);
    s.u(parame, "scaleType");
    if (((parame == i.e.XYN) || (parame == i.e.XYO)) && (((getContext() instanceof FinderHomeAffinityUI)) || ((getContext() instanceof FinderHomeUI))))
    {
      Object localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = (be)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(be.class);
      ah.d locald = new ah.d();
      ((be)localObject).av((kotlin.g.a.b)new be.h(FinderThumbPlayerProxy.class, MMSurfaceViewRender.class, locald));
      int i = locald.aixb;
      if (i > 0)
      {
        Log.w(getFTPPTag(), "setScaleType fix to SCALE_TYPE_CENTER_INSIDE context:" + getContext() + " count:" + i);
        getRenderView().setScaleType(1);
        AppMethodBeat.o(336288);
        return;
      }
    }
    switch (e.$EnumSwitchMapping$0[parame.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(336288);
      return;
      getRenderView().setScaleType(0);
      AppMethodBeat.o(336288);
      return;
      getRenderView().setScaleType(1);
      AppMethodBeat.o(336288);
      return;
      getRenderView().setScaleType(3);
    }
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.Fls = paramBoolean;
  }
  
  public final void setStartCdn(boolean paramBoolean)
  {
    this.Flw = paramBoolean;
  }
  
  public final void setStartCdnPreload(boolean paramBoolean)
  {
    this.Flx = paramBoolean;
  }
  
  public final void setVideoMuteListener(w paramw)
  {
    AppMethodBeat.i(336386);
    s.u(paramw, "muteListener");
    this.Flv = paramw;
    AppMethodBeat.o(336386);
  }
  
  public final void setVideoPlayLifecycle(ab paramab)
  {
    AppMethodBeat.i(336357);
    s.u(paramab, "lifecycle");
    this.Flu = paramab;
    AppMethodBeat.o(336357);
  }
  
  public final void setVideoViewCallback(i.b paramb)
  {
    this.EAt = paramb;
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(336040);
    Log.i(getFTPPTag(), "setVideoViewFocused " + paramBoolean + ' ' + getProxyState());
    this.Flr = paramBoolean;
    AppMethodBeat.o(336040);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.Flr = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(336181);
    long l = SystemClock.elapsedRealtime();
    Log.i(getFTPPTag(), s.X("stop ", getProxyState()));
    if (!RR(this.currentPlayState))
    {
      Log.i(getFTPPTag(), "stop return for isStartPlay onPlayerStopListener:" + this.Gpe + ". " + getProxyState());
      localObject = this.Gpe;
      if (localObject != null) {
        ((x)localObject).enr();
      }
    }
    Object localObject = this.Flu;
    if (localObject != null) {
      ((ab)localObject).a(this.ANI, this.ANP.fjS());
    }
    RS(8);
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
    localObject = locala;
    if (locala == null)
    {
      s.bIx("player");
      localObject = null;
    }
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).stop();
    RS(9);
    locala = this.Flb;
    localObject = locala;
    if (locala == null)
    {
      s.bIx("player");
      localObject = null;
    }
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).reset();
    RS(1);
    getFTPPLog().reset();
    getRenderView().reset();
    this.ANP.reset();
    this.Gpl = null;
    this.Gpj.detach();
    eLO();
    fjh();
    fji();
    this.Flf = true;
    this.ELh = false;
    setBgPrepareStatus(0);
    Log.i(getFTPPTag(), s.X("stop end time:", Long.valueOf(SystemClock.elapsedRealtime() - l)));
    AppMethodBeat.o(336181);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(336515);
    String str = getFTPPTag();
    AppMethodBeat.o(336515);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$DebugInfoData;", "", "mediaId", "", "position", "", "decodeType", "preloadType", "firstFrameTime", "", "bufferingCount", "viewType", "specType", "videoBitRate", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;J)V", "getBufferingCount", "()I", "setBufferingCount", "(I)V", "getDecodeType", "()Ljava/lang/String;", "setDecodeType", "(Ljava/lang/String;)V", "getFirstFrameTime", "()J", "setFirstFrameTime", "(J)V", "getMediaId", "setMediaId", "getPosition", "setPosition", "getPreloadType", "setPreloadType", "getSpecType", "setSpecType", "getVideoBitRate", "setVideoBitRate", "getViewType", "setViewType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public long Fqp;
    public String Gpn;
    public String Gpo;
    private int Gpp;
    public String Gpq;
    public long Gpr;
    public String mediaId;
    public int position;
    public String viewType;
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(334870);
      this.mediaId = paramString1;
      this.position = 0;
      this.Gpn = paramString2;
      this.Gpo = paramString3;
      this.Fqp = 0L;
      this.Gpp = 0;
      this.viewType = paramString4;
      this.Gpq = paramString5;
      this.Gpr = 0L;
      AppMethodBeat.o(334870);
    }
    
    public final void aCm(String paramString)
    {
      AppMethodBeat.i(334877);
      s.u(paramString, "<set-?>");
      this.Gpn = paramString;
      AppMethodBeat.o(334877);
    }
    
    public final void aCn(String paramString)
    {
      AppMethodBeat.i(334882);
      s.u(paramString, "<set-?>");
      this.Gpo = paramString;
      AppMethodBeat.o(334882);
    }
    
    public final void aCo(String paramString)
    {
      AppMethodBeat.i(334887);
      s.u(paramString, "<set-?>");
      this.viewType = paramString;
      AppMethodBeat.o(334887);
    }
    
    public final void aCp(String paramString)
    {
      AppMethodBeat.i(334895);
      s.u(paramString, "<set-?>");
      this.Gpq = paramString;
      AppMethodBeat.o(334895);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(334917);
      if (this == paramObject)
      {
        AppMethodBeat.o(334917);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(334917);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.mediaId, paramObject.mediaId))
      {
        AppMethodBeat.o(334917);
        return false;
      }
      if (this.position != paramObject.position)
      {
        AppMethodBeat.o(334917);
        return false;
      }
      if (!s.p(this.Gpn, paramObject.Gpn))
      {
        AppMethodBeat.o(334917);
        return false;
      }
      if (!s.p(this.Gpo, paramObject.Gpo))
      {
        AppMethodBeat.o(334917);
        return false;
      }
      if (this.Fqp != paramObject.Fqp)
      {
        AppMethodBeat.o(334917);
        return false;
      }
      if (this.Gpp != paramObject.Gpp)
      {
        AppMethodBeat.o(334917);
        return false;
      }
      if (!s.p(this.viewType, paramObject.viewType))
      {
        AppMethodBeat.o(334917);
        return false;
      }
      if (!s.p(this.Gpq, paramObject.Gpq))
      {
        AppMethodBeat.o(334917);
        return false;
      }
      if (this.Gpr != paramObject.Gpr)
      {
        AppMethodBeat.o(334917);
        return false;
      }
      AppMethodBeat.o(334917);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(334914);
      int i = this.mediaId.hashCode();
      int j = this.position;
      int k = this.Gpn.hashCode();
      int m = this.Gpo.hashCode();
      int n = q.a..ExternalSyntheticBackport0.m(this.Fqp);
      int i1 = this.Gpp;
      int i2 = this.viewType.hashCode();
      int i3 = this.Gpq.hashCode();
      int i4 = q.a..ExternalSyntheticBackport0.m(this.Gpr);
      AppMethodBeat.o(334914);
      return (((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4;
    }
    
    public final void setMediaId(String paramString)
    {
      AppMethodBeat.i(370243);
      s.u(paramString, "<set-?>");
      this.mediaId = paramString;
      AppMethodBeat.o(370243);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(334906);
      String str = "DebugInfoData(mediaId=" + this.mediaId + ", position=" + this.position + ", decodeType=" + this.Gpn + ", preloadType=" + this.Gpo + ", firstFrameTime=" + this.Fqp + ", bufferingCount=" + this.Gpp + ", viewType=" + this.viewType + ", specType=" + this.Gpq + ", videoBitRate=" + this.Gpr + ')';
      AppMethodBeat.o(334906);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "Lplatform/android/ThumbPlayerAndroid/src/main/java/com/tencent/thumbplayer/datatransport/resourceloader/AbsTPAssetResourceLoader;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "mediaId", "", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "(Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "MAX_REQUEST_BUFFER", "", "MIN_CHECK_BUFFER", "REQUEST_INTERVAL", "REQUEST_PERIOD_MAX_MS", "REQUEST_PERIOD_MIN_MS", "isRequestingData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastOnReadDataEnd", "getLastOnReadDataEnd", "()J", "setLastOnReadDataEnd", "(J)V", "mediaCache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "getMediaCache", "()Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "setMediaCache", "(Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;)V", "getMediaId", "()Ljava/lang/String;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "requestNumber", "", "callback", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "createVideoPreloadCDNTask", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "getContentType", "fileId", "fileKey", "getDataFilePath", "getDataTotalSize", "notifyDataReady", "requestOffset", "requestLength", "notifyProgressUpdate", "offset", "total", "onDataAvailable", "length", "onFinish", "ret", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "onPreloadCompleted", "onProgress", "onReadData", "onStartReadData", "requestStart", "requestEnd", "onStopReadData", "requestId", "resetMediaCache", "toString", "updateMediaCache", "updateRequestingData", "value", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends k.a.a.a.a.a.a.a.a.a.a.a
    implements g.a, g.b, h.a
  {
    final v BtQ;
    az Ezi;
    private final long Gps;
    private final long Gpt;
    private final long Gpu;
    private final long Gpv;
    private final long Gpw;
    private int Gpx;
    private AtomicBoolean Gpy;
    long Gpz;
    final String mediaId;
    
    public c(v paramv)
    {
      AppMethodBeat.i(334897);
      this.mediaId = paramv;
      this.BtQ = localObject;
      this.Gps = 30L;
      this.Gpt = 1048576L;
      this.Gpu = 131072L;
      this.Gpv = 10L;
      this.Gpw = 50L;
      this.Gpy = new AtomicBoolean(false);
      this$1 = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
      this.Ezi = com.tencent.mm.plugin.finder.storage.logic.e.bS(this.mediaId, true);
      boolean bool1 = y.ZC(this.Ezi.getFilePath());
      boolean bool2 = y.ZC(this.BtQ.path);
      Log.i(FinderThumbPlayerProxy.this.getFTPPTag(), "create ResourceLoaderProxy, cache:" + this.Ezi + " mediaCache path:" + this.Ezi.getFilePath() + ", exists:" + bool1 + " mediaInfo path:" + this.BtQ.path + ", exists:" + bool2);
      switch (this.Ezi.field_state)
      {
      case 1: 
      case 2: 
      default: 
        int i = this.Ezi.eDy();
        if (i > 0)
        {
          FinderThumbPlayerProxy.n(FinderThumbPlayerProxy.this).aCn("预加载" + i + '%');
          AppMethodBeat.o(334897);
          return;
        }
        break;
      case -2: 
      case -1: 
      case 0: 
        FinderThumbPlayerProxy.n(FinderThumbPlayerProxy.this).aCn("未命中预加载");
        fjk();
        AppMethodBeat.o(334897);
        return;
      case 3: 
        if (bool2) {
          break label350;
        }
        fjk();
      }
      FinderThumbPlayerProxy.n(FinderThumbPlayerProxy.this).aCn("未命中预加载");
      label350:
      AppMethodBeat.o(334897);
    }
    
    private final long aA(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(334928);
      if (!FinderThumbPlayerProxy.v(FinderThumbPlayerProxy.this).get())
      {
        Log.w(FinderThumbPlayerProxy.this.getFTPPTag(), "notifyDataReady, return for downloader never start. requestOffset:" + paramLong1 + " requestLength:" + paramLong2 + ' ' + this);
        localObject1 = FinderThumbPlayerProxy.w(FinderThumbPlayerProxy.this);
        if (!((com.tencent.mm.plugin.finder.video.reporter.a)localObject1).Gtv)
        {
          com.tencent.mm.plugin.report.service.h.OAn.p(1505L, 249L, 1L);
          ((com.tencent.mm.plugin.finder.video.reporter.a)localObject1).Gtv = true;
        }
        AppMethodBeat.o(334928);
        return 0L;
      }
      String str;
      Object localObject3;
      if ((FinderThumbPlayerProxy.x(FinderThumbPlayerProxy.this)) && (paramLong1 > this.Ezi.field_cacheSize))
      {
        localObject1 = FinderThumbPlayerProxy.y(FinderThumbPlayerProxy.this);
        str = FinderThumbPlayerProxy.this.getFTPPTag();
        localObject3 = "notifyDataReady() return for pause state. request[offset:" + paramLong1 + " length:" + paramLong2 + "] cacheSize:" + this.Ezi.field_cacheSize + ' ' + this;
        paramLong1 = System.currentTimeMillis();
        if (paramLong1 - ((com.tencent.mm.plugin.finder.video.log.a)localObject1).Gsl > 5000L)
        {
          Log.w(str, (String)localObject3);
          ((com.tencent.mm.plugin.finder.video.log.a)localObject1).Gsl = paramLong1;
        }
        AppMethodBeat.o(334928);
        return 0L;
      }
      long l2 = 0L;
      long l1;
      if (this.Ezi.eDw())
      {
        l1 = paramLong2;
        if (l1 != 0L) {
          break label994;
        }
        if ((!this.Ezi.field_moovReady) || (this.Gpy.get())) {
          break label872;
        }
        if (paramLong2 >= this.Gpt) {
          break label644;
        }
      }
      long l3;
      label644:
      for (l2 = paramLong2;; l2 = this.Gpt)
      {
        l3 = l2;
        if (paramLong1 + l2 > this.Ezi.field_totalSize)
        {
          l3 = this.Ezi.field_totalSize - paramLong1;
          Log.w(FinderThumbPlayerProxy.this.getFTPPTag(), "notifyDataReady() requestLength is valid, requestOffset:" + paramLong1 + ", requestLength:" + l3 + ", totalSize:" + this.Ezi.field_totalSize + ' ' + this);
        }
        localObject1 = ((PluginThumbPlayer)com.tencent.mm.kernel.h.az(PluginThumbPlayer.class)).getCdnTaskController();
        str = this.mediaId;
        s.u(str, "mediaId");
        if (((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).TBQ.containsKey(str)) {
          break label653;
        }
        Log.i(FinderThumbPlayerProxy.this.getFTPPTag(), s.X("notifyDataReady() isMediaInRunningStreamTaskMap mediaId:", this.mediaId));
        AppMethodBeat.o(334928);
        return l1;
        localObject3 = new long[2];
        i = CdnLogic.queryContinuousSize(this.mediaId, paramLong1, (long[])localObject3);
        if ((i == 0) && (localObject3[0] != -1L))
        {
          if (localObject3[0] > paramLong2) {}
          for (l1 = paramLong2;; l1 = localObject3[0]) {
            break;
          }
        }
        localObject1 = FinderThumbPlayerProxy.y(FinderThumbPlayerProxy.this);
        str = FinderThumbPlayerProxy.this.getFTPPTag();
        localObject3 = "notifyDataReady() queryContinuousSize error, ret:" + i + " requestOffset:" + paramLong1 + " continuousSize:" + localObject3[0] + " totalSize:" + localObject3[1] + ' ' + this;
        l3 = System.currentTimeMillis();
        l1 = l2;
        if (l3 - ((com.tencent.mm.plugin.finder.video.log.a)localObject1).Gsk <= 1000L) {
          break;
        }
        Log.w(str, (String)localObject3);
        ((com.tencent.mm.plugin.finder.video.log.a)localObject1).Gsk = l3;
        l1 = l2;
        break;
      }
      label653:
      Object localObject1 = new CountDownLatch(1);
      int i = ((PluginThumbPlayer)com.tencent.mm.kernel.h.az(PluginThumbPlayer.class)).getCdnTaskController().a(this.mediaId, (int)paramLong1, (int)l3, (com.tencent.mm.plugin.thumbplayer.b.c)new a(FinderThumbPlayerProxy.this, this, (CountDownLatch)localObject1));
      if (i == 0)
      {
        Log.i(FinderThumbPlayerProxy.this.getFTPPTag(), s.X("notifyDataReady() requestVideoData not in running id mediaId:", this.mediaId));
        uE(false);
        ((CountDownLatch)localObject1).countDown();
      }
      for (;;)
      {
        try
        {
          ((CountDownLatch)localObject1).await(5L, TimeUnit.SECONDS);
          Log.i(FinderThumbPlayerProxy.this.getFTPPTag(), "notifyDataReady() requestVideoData requestOffset:" + paramLong1 + " requestLengthFix:" + l3 + " requestLength:" + paramLong2 + " requestDataRet:" + i + "  cacheSize:" + this.Ezi.field_cacheSize + ' ' + this);
          this.Gpz = (paramLong1 + l1);
          AppMethodBeat.o(334928);
          return l1;
        }
        finally
        {
          Log.w(FinderThumbPlayerProxy.this.getFTPPTag(), "notifyDataReady() countdown timeout exception.");
          continue;
        }
        label872:
        com.tencent.mm.plugin.finder.video.log.a locala = FinderThumbPlayerProxy.y(FinderThumbPlayerProxy.this);
        str = FinderThumbPlayerProxy.this.getFTPPTag();
        localObject3 = "notifyDataReady() returnLength:" + l1 + " fixRequest[offset:" + paramLong1 + " length:" + paramLong2 + "],  originRequest[offset:" + paramLong1 + " length:" + paramLong2 + "] " + this;
        paramLong2 = System.currentTimeMillis();
        if (paramLong2 - locala.Gsm > 200L)
        {
          Log.w(str, (String)localObject3);
          locala.Gsm = paramLong2;
          continue;
          label994:
          Log.i(FinderThumbPlayerProxy.this.getFTPPTag(), "notifyDataReady() returnLength:" + l1 + " fixRequest[offset:" + paramLong1 + " length:" + paramLong2 + "], originRequest[offset:" + paramLong1 + " length:" + paramLong2 + "] " + this);
        }
      }
    }
    
    private final void fjk()
    {
      AppMethodBeat.i(334911);
      Log.i(FinderThumbPlayerProxy.this.getFTPPTag(), "resetMediaCache");
      Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
      String str2 = this.mediaId;
      Object localObject2 = this.BtQ.ANK.eCF().mediaId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      String str1 = this.BtQ.downloadUrl;
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "";
      }
      com.tencent.mm.plugin.finder.storage.logic.e.a(str2, (String)localObject1, (String)localObject2, this.BtQ.ANK.eCG(), this.BtQ.ANK.eCd().detail, 0L, 0L, 1, this.BtQ.ANK.eCF().videoDuration, "", "");
      fjl();
      AppMethodBeat.o(334911);
    }
    
    public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      int i = 1;
      AppMethodBeat.i(334979);
      s.u(paramString, "mediaId");
      String str = FinderThumbPlayerProxy.this.getFTPPTag();
      StringBuilder localStringBuilder = new StringBuilder("callback() mediaId=").append(paramString).append(" startRet=").append(paramInt).append(" finishedLength=");
      Object localObject;
      if (paramc == null)
      {
        localObject = null;
        localObject = localStringBuilder.append(localObject).append(" fileFormat=");
        if (paramd != null) {
          break label205;
        }
        paramd = null;
        label86:
        Log.i(str, paramd + ' ' + this);
        if (paramc != null)
        {
          if ((paramInt != 0) || (paramc.field_finishedLength <= 0L)) {
            break label215;
          }
          paramInt = 1;
          label129:
          if (paramInt == 0) {
            break label220;
          }
        }
      }
      for (;;)
      {
        if (paramc != null)
        {
          paramInt = i;
          if (paramc.field_finishedLength >= paramc.field_toltalLength) {
            paramInt = 3;
          }
          paramd = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
          com.tencent.mm.plugin.finder.storage.logic.e.a(paramString, paramc.field_finishedLength, paramc.field_toltalLength, paramInt);
          fjl();
          paramc = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
          com.tencent.mm.plugin.finder.storage.logic.e.aAM(paramString);
        }
        AppMethodBeat.o(334979);
        return 0;
        localObject = Long.valueOf(paramc.field_finishedLength);
        break;
        label205:
        paramd = paramd.field_videoFlag;
        break label86;
        label215:
        paramInt = 0;
        break label129;
        label220:
        paramc = null;
      }
    }
    
    public final void a(String paramString, final int paramInt, final com.tencent.mm.g.d paramd)
    {
      AppMethodBeat.i(334972);
      s.u(paramString, "mediaId");
      s.u(paramd, "sceneResult");
      Log.i(FinderThumbPlayerProxy.this.getFTPPTag(), "onFinish() mediaId=" + paramString + " ret=" + paramInt + " recvedBytes=" + paramd.field_recvedBytes + " fileLength=" + paramd.field_fileLength + "  finderformat:" + Integer.valueOf(paramd.field_videoFormat));
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(FinderThumbPlayerProxy.this, paramInt, this, paramd));
      Object localObject;
      if (paramInt != 0)
      {
        paramd = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
        localObject = this.BtQ.ANK.eCF().mediaId;
        paramd = (com.tencent.mm.g.d)localObject;
        if (localObject == null) {
          paramd = "";
        }
        String str = this.BtQ.downloadUrl;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        com.tencent.mm.plugin.finder.storage.logic.e.a(paramString, paramd, (String)localObject, this.BtQ.ANK.eCG(), this.BtQ.ANK.eCd().detail, 0L, 0L, -1, this.BtQ.ANK.eCF().videoDuration, "", "");
      }
      for (;;)
      {
        fjl();
        uE(false);
        AppMethodBeat.o(334972);
        return;
        localObject = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
        com.tencent.mm.plugin.finder.storage.logic.e.a(paramString, paramd.field_fileLength, paramd.field_fileLength, 3);
        paramd = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
        com.tencent.mm.plugin.finder.storage.logic.e.aAM(paramString);
      }
    }
    
    public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(334943);
      s.u(paramString1, "mediaId");
      Log.i(FinderThumbPlayerProxy.this.getFTPPTag(), "onMoovReady() offset=" + paramLong1 + " length=" + paramLong2 + " svrflag=" + paramString2 + ' ' + this);
      Object localObject = FinderThumbPlayerProxy.h(FinderThumbPlayerProxy.this);
      if (localObject != null) {
        ((com.tencent.mm.plugin.findersdk.f.a)localObject).aDn("onMoovReady");
      }
      if (!this.Ezi.field_moovReady) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
        localObject = paramString2;
        if (paramString2 == null) {
          localObject = "";
        }
        com.tencent.mm.plugin.finder.storage.logic.e.ig(paramString1, (String)localObject);
        fjl();
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(FinderThumbPlayerProxy.this));
        paramString2 = FinderThumbPlayerProxy.this.getDownloadCallback();
        if (paramString2 != null) {
          paramString2.a((int)paramLong1, (int)paramLong2, this.BtQ.ANK, bool);
        }
        paramString2 = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
        com.tencent.mm.plugin.finder.storage.logic.e.aAM(paramString1);
        AppMethodBeat.o(334943);
        return;
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(334984);
      s.u(paramString, "mediaId");
      AppMethodBeat.o(334984);
    }
    
    public final void b(String paramString, com.tencent.mm.g.d paramd)
    {
      Object localObject = null;
      AppMethodBeat.i(334994);
      s.u(paramString, "mediaId");
      String str = FinderThumbPlayerProxy.this.getFTPPTag();
      StringBuilder localStringBuilder = new StringBuilder("[onPreloadCompleted] mediaId=").append(paramString).append(" Ret=");
      if (paramd == null)
      {
        paramString = null;
        localStringBuilder = localStringBuilder.append(paramString).append(" finishedLength=");
        if (paramd != null) {
          break label119;
        }
      }
      label119:
      for (paramString = localObject;; paramString = Long.valueOf(paramd.field_recvedBytes))
      {
        Log.i(str, paramString + ' ' + this);
        FinderThumbPlayerProxy.u(FinderThumbPlayerProxy.this);
        AppMethodBeat.o(334994);
        return;
        paramString = Integer.valueOf(paramd.field_retCode);
        break;
      }
    }
    
    public final void fjl()
    {
      AppMethodBeat.i(335001);
      com.tencent.mm.plugin.finder.storage.logic.e locale = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
      this.Ezi = com.tencent.mm.plugin.finder.storage.logic.e.aAN(this.mediaId);
      AppMethodBeat.o(335001);
    }
    
    public final String getContentType(int paramInt, String paramString)
    {
      AppMethodBeat.i(335040);
      Log.i(FinderThumbPlayerProxy.this.getFTPPTag(), "getContentType() fileId:" + paramInt + ", fileKey:" + paramString + " contentType:" + "video/mp4");
      AppMethodBeat.o(335040);
      return "video/mp4";
    }
    
    public final String getDataFilePath(int paramInt, String paramString)
    {
      AppMethodBeat.i(335035);
      paramString = y.n(this.BtQ.path, false);
      Log.i(FinderThumbPlayerProxy.this.getFTPPTag(), "getDataFilePath(), dataFilePath:" + paramString + " isExists:" + y.ZC(paramString) + " mediaInfoPath:" + this.BtQ.path);
      AppMethodBeat.o(335035);
      return paramString;
    }
    
    public final long getDataTotalSize(int paramInt, String paramString)
    {
      AppMethodBeat.i(335029);
      Log.i(FinderThumbPlayerProxy.this.getFTPPTag(), "getDataTotalSize() fileId:" + paramInt + ", fileKey:" + paramString + " dataTotalSize:" + this.Ezi.field_totalSize + ' ');
      long l = this.Ezi.field_totalSize;
      AppMethodBeat.o(335029);
      return l;
    }
    
    public final void h(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(334960);
      s.u(paramString, "mediaId");
      Log.i(FinderThumbPlayerProxy.this.getFTPPTag(), "onProgress() offset=" + paramLong1 + " total=" + paramLong2 + ' ' + this);
      Object localObject = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
      com.tencent.mm.plugin.finder.storage.logic.e.a(paramString, paramLong1, paramLong2, 1);
      fjl();
      if (FinderThumbPlayerProxy.this.Flr)
      {
        int i = this.Ezi.field_videoBitrate + this.Ezi.field_audioBitrate;
        if (i > 0)
        {
          int j = FinderThumbPlayerProxy.this.getCurrentPlaySecond();
          localObject = new acc();
          ((acc)localObject).ifC.mediaId = paramString;
          ((acc)localObject).ifC.offset = paramLong1;
          ((acc)localObject).ifC.total = paramLong2;
          ((acc)localObject).ifC.ifD = i;
          ((acc)localObject).ifC.hKr = j;
          ((acc)localObject).publish();
        }
      }
      localObject = FinderThumbPlayerProxy.this.getDownloadCallback();
      if (localObject != null) {
        ((aa)localObject).a((int)paramLong1, (int)paramLong2, this.BtQ.ANK);
      }
      localObject = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
      com.tencent.mm.plugin.finder.storage.logic.e.aAM(paramString);
      AppMethodBeat.o(334960);
    }
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
    
    public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(334950);
      s.u(paramString, "mediaId");
      uE(false);
      Log.i(FinderThumbPlayerProxy.this.getFTPPTag(), "onDataAvailable() offset=" + paramLong1 + " length=" + paramLong2 + ' ' + this + '}');
      AppMethodBeat.o(334950);
    }
    
    public final void onM3U8Ready(String paramString1, String paramString2)
    {
      AppMethodBeat.i(334935);
      s.u(paramString1, "mediaId");
      AppMethodBeat.o(334935);
    }
    
    public final int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(335018);
      paramInt = (int)aA(paramLong1, paramLong2);
      AppMethodBeat.o(335018);
      return paramInt;
    }
    
    public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(335014);
      Log.i(FinderThumbPlayerProxy.this.getFTPPTag(), "onStartReadData() fileId:" + paramInt + ", fileKey:" + paramString + ", requestStart:" + paramLong1 + ", requestEnd:" + paramLong2);
      paramString = FinderThumbPlayerProxy.h(FinderThumbPlayerProxy.this);
      if (paramString != null) {
        paramString.aDn("onStartRead");
      }
      paramInt = this.Gpx;
      this.Gpx = (paramInt + 1);
      AppMethodBeat.o(335014);
      return paramInt;
    }
    
    public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(335024);
      Log.i(FinderThumbPlayerProxy.this.getFTPPTag(), "onStartReadData() fileId:" + paramInt1 + ", fileKey:" + paramString + ", requestId:" + paramInt2);
      paramInt1 = this.Gpx;
      AppMethodBeat.o(335024);
      return paramInt1;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(335046);
      String str = FinderThumbPlayerProxy.e(FinderThumbPlayerProxy.this) + " isMoovReady:" + this.Ezi.field_moovReady + " isRequestingData:" + this.Gpy.get() + " isFinish:" + this.Ezi.eDw() + " total:" + this.Ezi.field_totalSize + " mediacache:" + this.Ezi.hashCode();
      AppMethodBeat.o(335046);
      return str;
    }
    
    public final void uE(boolean paramBoolean)
    {
      AppMethodBeat.i(335008);
      Log.i(FinderThumbPlayerProxy.this.getFTPPTag(), "updateRequestingData " + paramBoolean + ' ' + this);
      this.Gpy.set(paramBoolean);
      AppMethodBeat.o(335008);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy$notifyDataReady$requestDataRet$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "onRequest", "", "ret", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.plugin.thumbplayer.b.c
    {
      a(FinderThumbPlayerProxy paramFinderThumbPlayerProxy, FinderThumbPlayerProxy.c paramc, CountDownLatch paramCountDownLatch) {}
      
      public final void UA(int paramInt)
      {
        AppMethodBeat.i(335334);
        if (paramInt != 0)
        {
          Log.w(this.GpA.getFTPPTag(), "requestedResource() requestVideoData fail, ret:" + paramInt + ' ' + this);
          jdField_this.uE(false);
        }
        for (;;)
        {
          this.GpC.countDown();
          AppMethodBeat.o(335334);
          return;
          Log.w(this.GpA.getFTPPTag(), "requestedResource() requestVideoData success, ret:" + paramInt + ' ' + this);
          jdField_this.uE(true);
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      b(FinderThumbPlayerProxy paramFinderThumbPlayerProxy, int paramInt, FinderThumbPlayerProxy.c paramc, com.tencent.mm.g.d paramd)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      c(FinderThumbPlayerProxy paramFinderThumbPlayerProxy)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$TPPlayerListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/mm/plugin/thumbplayer/render/IMMRenderView$IOnSurfaceListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnPreparedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnVideoSizeChangedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnInfoListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnCompletionListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnErrorListener;", "(Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;)V", "onCompletion", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onError", "errorType", "", "errorCode", "arg1", "", "arg2", "onInfo", "what", "extraObject", "", "onPrepared", "onStateChange", "preState", "curState", "onSurfaceAvailable", "surface", "onSurfaceChange", "width", "height", "onSurfaceDestroy", "", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "onSurfaceUpdate", "onVideoSizeChanged", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    implements TextureView.SurfaceTextureListener, a.a, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnVideoSizeChangedListener
  {
    public d()
    {
      AppMethodBeat.i(334880);
      AppMethodBeat.o(334880);
    }
    
    public final void fE(Object paramObject)
    {
      AppMethodBeat.i(334980);
      s.u(paramObject, "surface");
      if ((paramObject instanceof SurfaceTexture))
      {
        FinderThumbPlayerProxy.a(this.GpA, (SurfaceTexture)paramObject);
        AppMethodBeat.o(334980);
        return;
      }
      if ((paramObject instanceof SurfaceHolder))
      {
        FinderThumbPlayerProxy.a(this.GpA, (SurfaceHolder)paramObject);
        AppMethodBeat.o(334980);
        return;
      }
      Log.w(this.GpA.getFTPPTag(), "FTPP.onSurfaceAvailable() width:" + this.GpA.getWidth() + " height:" + this.GpA.getHeight() + " surface:" + paramObject + ' ' + FinderThumbPlayerProxy.e(this.GpA));
      AppMethodBeat.o(334980);
    }
    
    public final void fF(Object paramObject)
    {
      AppMethodBeat.i(334991);
      s.u(paramObject, "surface");
      AppMethodBeat.o(334991);
    }
    
    public final boolean fG(Object paramObject)
    {
      Bitmap localBitmap = null;
      AppMethodBeat.i(335002);
      s.u(paramObject, "surface");
      Object localObject;
      SurfaceView localSurfaceView;
      if (!(paramObject instanceof SurfaceTexture))
      {
        if (!(paramObject instanceof SurfaceHolder)) {
          break label209;
        }
        localObject = FinderThumbPlayerProxy.d(this.GpA);
        paramObject = localObject;
        if (localObject == null)
        {
          s.bIx("player");
          paramObject = null;
        }
        paramObject.setSurface(null);
        if ((this.GpA.getRenderView() instanceof MMSurfaceViewRender))
        {
          localObject = FinderThumbPlayerProxy.q(this.GpA);
          localSurfaceView = (SurfaceView)this.GpA.getRenderView();
          s.u(localSurfaceView, "surfaceView");
          if (((com.tencent.mm.plugin.thumbplayer.render.b)localObject).container.findViewWithTag("MMSurfaceViewSwitchHelper.COVER_VIEW") != null) {
            break label162;
          }
          paramObject = null;
          label147:
          if (paramObject == null)
          {
            paramObject = ((com.tencent.mm.plugin.thumbplayer.render.b)localObject).TFT;
            if (paramObject != null) {
              break label178;
            }
            paramObject = localBitmap;
            label127:
            if (paramObject == null)
            {
              localBitmap = ((com.tencent.mm.plugin.thumbplayer.render.b)localObject).hfN;
              if (Build.VERSION.SDK_INT < 24) {
                break label194;
              }
              paramObject = "captureFrame fail.";
              ((com.tencent.mm.plugin.thumbplayer.render.b)localObject).a(localSurfaceView, localBitmap, paramObject);
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(335002);
        return false;
        label162:
        Log.w(((com.tencent.mm.plugin.thumbplayer.render.b)localObject).getLogTag(), "showCoverBitmap return for duplicated.");
        paramObject = ah.aiuX;
        break;
        label178:
        ((com.tencent.mm.plugin.thumbplayer.render.b)localObject).a(localSurfaceView, paramObject, " captureFrame success.");
        paramObject = ah.aiuX;
        break label127;
        label194:
        paramObject = s.X("version:", Integer.valueOf(Build.VERSION.SDK_INT));
        break label147;
        label209:
        Log.w(this.GpA.getFTPPTag(), "FTPP.onSurfaceDestroy() surface:" + paramObject + ' ' + FinderThumbPlayerProxy.e(this.GpA));
      }
    }
    
    public final void h(Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(334985);
      s.u(paramObject, "surface");
      Log.i(this.GpA.getFTPPTag(), "FTPP.onSurfaceChange  surface:" + paramObject.hashCode() + ' ' + paramInt1 + ' ' + paramInt2 + ' ' + FinderThumbPlayerProxy.e(this.GpA));
      AppMethodBeat.o(334985);
    }
    
    public final void onCompletion(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(334964);
      FinderThumbPlayerProxy.b(this.GpA, 7);
      Log.i(this.GpA.getFTPPTag(), s.X("FTPP.onCompletion() ", FinderThumbPlayerProxy.e(this.GpA)));
      i.b localb = this.GpA.getVideoViewCallback();
      if (localb != null)
      {
        paramITPPlayer = FinderThumbPlayerProxy.i(this.GpA);
        if (paramITPPlayer != null) {
          break label81;
        }
      }
      label81:
      for (paramITPPlayer = null;; paramITPPlayer = paramITPPlayer.mediaId)
      {
        localb.em("", paramITPPlayer);
        AppMethodBeat.o(334964);
        return;
      }
    }
    
    public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(334973);
      s.u(paramITPPlayer, "player");
      Log.i(this.GpA.getFTPPTag(), "FTPP.onError() " + paramInt1 + ' ' + paramInt2 + " bgPrepareStatus:" + FinderThumbPlayerProxy.p(this.GpA) + ' ' + FinderThumbPlayerProxy.e(this.GpA));
      Object localObject1;
      if (paramInt2 == 11030406)
      {
        v localv = FinderThumbPlayerProxy.i(this.GpA);
        if (localv != null)
        {
          FinderThumbPlayerProxy localFinderThumbPlayerProxy = this.GpA;
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
          String str2 = localv.mediaId;
          Object localObject2 = localv.ANK.eCF().mediaId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          String str1 = localv.downloadUrl;
          localObject2 = str1;
          if (str1 == null) {
            localObject2 = "";
          }
          com.tencent.mm.plugin.finder.storage.logic.e.a(str2, (String)localObject1, (String)localObject2, localv.ANK.eCG(), localv.ANK.eCd().detail, 0L, 0L, 1, localv.ANK.eCF().videoDuration, "", "");
          localObject1 = FinderThumbPlayerProxy.k(localFinderThumbPlayerProxy);
          if (localObject1 != null) {
            ((FinderThumbPlayerProxy.c)localObject1).fjl();
          }
        }
      }
      if (FinderThumbPlayerProxy.p(this.GpA) != 0)
      {
        paramITPPlayer.reset();
        this.GpA.eLI();
        AppMethodBeat.o(334973);
        return;
      }
      paramITPPlayer = FinderThumbPlayerProxy.i(this.GpA);
      if (paramITPPlayer != null)
      {
        localObject1 = this.GpA.getVideoViewCallback();
        if (localObject1 != null) {
          ((i.b)localObject1).d("", paramITPPlayer.mediaId, "", paramInt2, paramInt1);
        }
      }
      AppMethodBeat.o(334973);
    }
    
    public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      paramITPPlayer = null;
      Object localObject = null;
      StringBuilder localStringBuilder1 = null;
      StringBuilder localStringBuilder2 = null;
      AppMethodBeat.i(334948);
      Log.i(this.GpA.getFTPPTag(), "FTPP.onInfo() what:" + paramInt + " arg1:" + paramLong1 + " arg2:" + paramLong2 + " extraObject:" + paramObject + ' ' + FinderThumbPlayerProxy.e(this.GpA));
      switch (paramInt)
      {
      default: 
      case 200: 
      case 201: 
      case 150: 
      case 106: 
      case 108: 
      case 105: 
      case 1006: 
        do
        {
          AppMethodBeat.o(334948);
          return;
          Log.i(this.GpA.getFTPPTag(), "FTPP.onInfo#onBufferingStart() pos:" + this.GpA.getCurrentPlayMs() + ' ' + FinderThumbPlayerProxy.e(this.GpA));
          paramObject = this.GpA;
          paramITPPlayer = FinderThumbPlayerProxy.i(this.GpA);
          if (paramITPPlayer == null) {}
          for (paramITPPlayer = localStringBuilder2;; paramITPPlayer = paramITPPlayer.mediaId)
          {
            FinderThumbPlayerProxy.b(paramObject, paramITPPlayer);
            AppMethodBeat.o(334948);
            return;
          }
          Log.i(this.GpA.getFTPPTag(), "FTPP.onInfo#onBufferingEnd() pos:" + this.GpA.getCurrentPlayMs() + ' ' + FinderThumbPlayerProxy.e(this.GpA));
          FinderThumbPlayerProxy.l(this.GpA);
          AppMethodBeat.o(334948);
          return;
          Log.i(this.GpA.getFTPPTag(), s.X("FTPP.onInfo#onReplay() ", FinderThumbPlayerProxy.e(this.GpA)));
          paramITPPlayer = this.GpA.getLifecycle();
          if (paramITPPlayer != null)
          {
            FinderThumbPlayerProxy.i(this.GpA);
            paramITPPlayer.eCP();
          }
          ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel().EVh.aXc();
          AppMethodBeat.o(334948);
          return;
          Log.i(this.GpA.getFTPPTag(), s.X("FTPP.onInfo#firstVideoFrameRendered ", FinderThumbPlayerProxy.e(this.GpA)));
          FinderThumbPlayerProxy.c(this.GpA, "onFirstFrameRendered");
          paramObject = FinderThumbPlayerProxy.h(this.GpA);
          if (paramObject != null) {
            paramObject.gG("onRendered");
          }
          paramObject = FinderThumbPlayerProxy.f(this.GpA);
          localObject = FinderThumbPlayerProxy.h(this.GpA);
          if (localObject == null) {}
          for (;;)
          {
            paramObject.GuS = paramITPPlayer;
            paramITPPlayer = this.GpA.getLifecycle();
            if (paramITPPlayer == null) {
              break;
            }
            FinderThumbPlayerProxy.i(this.GpA);
            paramITPPlayer.a(FinderThumbPlayerProxy.h(this.GpA));
            AppMethodBeat.o(334948);
            return;
            paramITPPlayer = ((com.tencent.mm.plugin.findersdk.f.a)localObject).ftd();
          }
          Log.i(this.GpA.getFTPPTag(), s.X("FTPP.onInfo#firstVideoFrameRenderedAfterSurfaceChange ", FinderThumbPlayerProxy.e(this.GpA)));
          FinderThumbPlayerProxy.m(this.GpA);
          AppMethodBeat.o(334948);
          return;
          Log.i(this.GpA.getFTPPTag(), s.X("FTPP.onInfo#firstAudioFrameRendered ", FinderThumbPlayerProxy.e(this.GpA)));
          AppMethodBeat.o(334948);
          return;
        } while (!(paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo));
        Log.i(this.GpA.getFTPPTag(), s.X("FTPP.onInfo#downloadProgressUpdate: ", Long.valueOf(((TPPlayerMsg.TPDownLoadProgressInfo)paramObject).playableDurationMS)));
        AppMethodBeat.o(334948);
        return;
      case 204: 
        paramObject = this.GpA.getFTPPTag();
        localStringBuilder1 = new StringBuilder("FTPP.onInfo#videoDecodeType:").append(paramLong1).append(' ');
        paramITPPlayer = FinderThumbPlayerProxy.i(this.GpA);
        if (paramITPPlayer == null)
        {
          paramITPPlayer = null;
          label695:
          Log.i(paramObject, paramITPPlayer);
          paramITPPlayer = FinderThumbPlayerProxy.i(this.GpA);
          if (paramITPPlayer != null) {
            break label816;
          }
          paramITPPlayer = null;
          label723:
          if (paramITPPlayer == null)
          {
            paramITPPlayer = FinderThumbPlayerProxy.i(this.GpA);
            if (paramITPPlayer != null) {
              break label838;
            }
            paramITPPlayer = null;
            label741:
            if (paramITPPlayer != null) {
              paramITPPlayer.aaPt = new FinderMediaReportObject();
            }
          }
          if ((int)paramLong1 != 102) {
            break label846;
          }
          FinderThumbPlayerProxy.n(this.GpA).aCm("MediaCodec");
          label776:
          paramITPPlayer = FinderThumbPlayerProxy.i(this.GpA);
          if (paramITPPlayer != null) {
            break label862;
          }
          paramITPPlayer = (ITPPlayer)localObject;
        }
        while (paramITPPlayer != null)
        {
          paramITPPlayer.playDecoderType = ((int)paramLong1);
          AppMethodBeat.o(334948);
          return;
          paramITPPlayer = paramITPPlayer.mediaId;
          break label695;
          label816:
          paramITPPlayer = paramITPPlayer.Grz;
          if (paramITPPlayer == null)
          {
            paramITPPlayer = null;
            break label723;
          }
          paramITPPlayer = paramITPPlayer.aaPt;
          break label723;
          label838:
          paramITPPlayer = paramITPPlayer.Grz;
          break label741;
          label846:
          FinderThumbPlayerProxy.n(this.GpA).aCm("FFmpeg");
          break label776;
          label862:
          paramObject = paramITPPlayer.Grz;
          paramITPPlayer = (ITPPlayer)localObject;
          if (paramObject != null) {
            paramITPPlayer = paramObject.aaPt;
          }
        }
      }
      localObject = this.GpA.getFTPPTag();
      localStringBuilder2 = new StringBuilder("FTPP.onInfo#mediaCodecInfo:").append(paramLong1).append(' ');
      paramITPPlayer = FinderThumbPlayerProxy.i(this.GpA);
      if (paramITPPlayer == null) {}
      for (paramITPPlayer = localStringBuilder1;; paramITPPlayer = paramITPPlayer.mediaId)
      {
        Log.i((String)localObject, paramITPPlayer);
        if ((paramObject instanceof TPPlayerMsg.TPMediaCodecInfo)) {
          break;
        }
        Log.w(this.GpA.getFTPPTag(), "FTPP.onInfo#mediaCodecInfo return for not codecInfo");
        AppMethodBeat.o(334948);
        return;
      }
      if (((TPPlayerMsg.TPMediaCodecInfo)paramObject).mediaType != TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO)
      {
        Log.w(this.GpA.getFTPPTag(), "FTPP.onInfo#mediaCodecInfo return for not video type");
        AppMethodBeat.o(334948);
        return;
      }
      if (((TPPlayerMsg.TPMediaCodecInfo)paramObject).infoType == TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY) {}
      for (;;)
      {
        try
        {
          paramITPPlayer = new com.tencent.mm.ad.i(((TPPlayerMsg.TPMediaCodecInfo)paramObject).msg);
          paramObject = FinderThumbPlayerProxy.o(this.GpA);
          if (paramObject != null)
          {
            if (!paramITPPlayer.optBoolean("reuseEnable")) {
              continue;
            }
            paramInt = 1;
            paramObject.Guq = paramInt;
          }
          paramObject = FinderThumbPlayerProxy.o(this.GpA);
          if (paramObject != null)
          {
            if (!paramITPPlayer.optBoolean("isReuse")) {
              continue;
            }
            paramInt = 1;
            paramObject.Gur = paramInt;
          }
          paramObject = FinderThumbPlayerProxy.o(this.GpA);
          if (paramObject != null) {
            paramObject.Gut = paramITPPlayer.optInt("totalCodec");
          }
        }
        finally
        {
          continue;
        }
        paramITPPlayer = this.GpA.getLifecycle();
        if (paramITPPlayer == null) {
          break;
        }
        FinderThumbPlayerProxy.i(this.GpA);
        paramITPPlayer.a(FinderThumbPlayerProxy.o(this.GpA));
        break;
        paramInt = -1;
        continue;
        paramInt = -1;
        continue;
        if (((TPPlayerMsg.TPMediaCodecInfo)paramObject).infoType == TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_EXCEPTION) {
          try
          {
            paramITPPlayer = new com.tencent.mm.ad.i(((TPPlayerMsg.TPMediaCodecInfo)paramObject).msg);
            paramObject = FinderThumbPlayerProxy.o(this.GpA);
            if (paramObject != null) {
              paramObject.Gus = paramITPPlayer.optString("errorCodec");
            }
          }
          finally {}
        }
      }
    }
    
    public final void onPrepared(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(334919);
      s.u(paramITPPlayer, "player");
      Log.i(this.GpA.getFTPPTag(), s.X("FTPP.OnPrepared() ", FinderThumbPlayerProxy.e(this.GpA)));
      Object localObject1 = FinderThumbPlayerProxy.h(this.GpA);
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.findersdk.f.a)localObject1).aDn("onPrepared");
      }
      FinderThumbPlayerProxy.b(this.GpA, 4);
      Object localObject2 = this.GpA.getVideoViewCallback();
      if (localObject2 != null)
      {
        localObject1 = FinderThumbPlayerProxy.i(this.GpA);
        if (localObject1 == null)
        {
          localObject1 = null;
          ((i.b)localObject2).el("", (String)localObject1);
        }
      }
      else
      {
        if (!this.GpA.Flr) {
          break label223;
        }
        this.GpA.RP(2);
      }
      for (;;)
      {
        localObject1 = FinderThumbPlayerProxy.k(this.GpA);
        if (localObject1 != null)
        {
          localObject1 = ((FinderThumbPlayerProxy.c)localObject1).Ezi;
          localObject2 = this.GpA;
          ((az)localObject1).field_audioBitrate = ((int)paramITPPlayer.getPropertyLong(101));
          ((az)localObject1).field_videoBitrate = ((int)paramITPPlayer.getPropertyLong(202));
          ((az)localObject1).field_frameRate = ((int)paramITPPlayer.getPropertyLong(206));
          FinderThumbPlayerProxy.n((FinderThumbPlayerProxy)localObject2).Gpr = (((az)localObject1).field_audioBitrate + ((az)localObject1).field_videoBitrate);
          FinderThumbPlayerProxy.f((FinderThumbPlayerProxy)localObject2).videoFps = ((az)localObject1).field_frameRate;
        }
        AppMethodBeat.o(334919);
        return;
        localObject1 = ((v)localObject1).mediaId;
        break;
        label223:
        FinderThumbPlayerProxy.j(this.GpA);
        paramITPPlayer.pauseDownload();
      }
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(334957);
      Log.i(this.GpA.getFTPPTag(), "FTPP.onStateChange() preState:" + paramInt1 + " curState:" + paramInt2 + ' ' + FinderThumbPlayerProxy.e(this.GpA));
      AppMethodBeat.o(334957);
    }
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(334888);
      s.u(paramSurfaceTexture, "surfaceTexture");
      FinderThumbPlayerProxy.a(this.GpA, paramSurfaceTexture);
      AppMethodBeat.o(334888);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(334907);
      s.u(paramSurfaceTexture, "surfaceTexture");
      Log.i(this.GpA.getFTPPTag(), "FTPP.onSurfaceTextureDestroyed() surfaceTexture:" + paramSurfaceTexture.hashCode() + ' ' + FinderThumbPlayerProxy.e(this.GpA));
      AppMethodBeat.o(334907);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(334898);
      s.u(paramSurfaceTexture, "surfaceTexture");
      Log.i(this.GpA.getFTPPTag(), "FTPP.onSurfaceTextureSizeChanged  surfaceTexture:" + paramSurfaceTexture.hashCode() + ' ' + paramInt1 + ' ' + paramInt2 + ' ' + FinderThumbPlayerProxy.e(this.GpA));
      AppMethodBeat.o(334898);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(334912);
      s.u(paramSurfaceTexture, "surface");
      FinderThumbPlayerProxy.g(this.GpA);
      AppMethodBeat.o(334912);
    }
    
    public final void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(334926);
      Log.i(this.GpA.getFTPPTag(), "FTPP.OnVideoSizeChanged() width:" + paramLong1 + " height:" + paramLong2 + ' ' + FinderThumbPlayerProxy.e(this.GpA));
      this.GpA.getRenderView().mj((int)paramLong1, (int)paramLong2);
      AppMethodBeat.o(334926);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/video/reporter/FTPPKVReporter;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.video.reporter.a>
  {
    public static final f GpD;
    
    static
    {
      AppMethodBeat.i(334893);
      GpD = new f();
      AppMethodBeat.o(334893);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/video/log/FTPPLog;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.video.log.a>
  {
    public static final g GpE;
    
    static
    {
      AppMethodBeat.i(334850);
      GpE = new g();
      AppMethodBeat.o(334850);
    }
    
    g()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    h(FinderThumbPlayerProxy paramFinderThumbPlayerProxy)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements com.tencent.mm.plugin.thumbplayer.b.b
  {
    i(FinderThumbPlayerProxy.c paramc) {}
    
    public final com.tencent.mm.g.h aCq(String paramString)
    {
      boolean bool = true;
      AppMethodBeat.i(334862);
      s.u(paramString, "id");
      FinderThumbPlayerProxy.c localc = this.GpF;
      paramString = av.GiL;
      String str2 = localc.mediaId;
      Object localObject1 = localc.BtQ.downloadUrl;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      String str3 = localc.BtQ.path;
      localObject1 = localc.BtQ;
      int i;
      Object localObject2;
      String str4;
      if (localObject1 == null)
      {
        localObject1 = null;
        i = com.tencent.mm.modelcontrol.e.S(1, (String)localObject1);
        localObject2 = localc.Ezi.field_fileFormat;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        str4 = localc.BtQ.ANK.eCf();
        String str1 = localc.BtQ.ANK.eCF().decodeKey;
        localObject2 = str1;
        if (str1 == null) {
          localObject2 = "";
        }
        if (localc.BtQ.ANK.eCF().hot_flag != 1) {
          break label219;
        }
      }
      for (;;)
      {
        paramString = av.a(str2, paramString, str3, i, (String)localObject1, str4, (String)localObject2, bool, (h.a)localc, localc.GpA.getFTPPTag());
        AppMethodBeat.o(334862);
        return paramString;
        localObject1 = ((v)localObject1).path;
        break;
        label219:
        bool = false;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnDownload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements com.tencent.mm.plugin.thumbplayer.b.e
  {
    j(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void Rv(int paramInt)
    {
      AppMethodBeat.i(334867);
      Log.i(this.GpA.getFTPPTag(), "startCdnDownload()#onStart " + FinderThumbPlayerProxy.e(this.GpA) + ' ' + paramInt);
      FinderThumbPlayerProxy.z(this.GpA);
      AppMethodBeat.o(334867);
    }
    
    public final void a(int paramInt, com.tencent.mm.g.h paramh)
    {
      AppMethodBeat.i(334875);
      s.u(this, "this");
      AppMethodBeat.o(334875);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnPreload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements com.tencent.mm.plugin.thumbplayer.b.b
  {
    k(FinderThumbPlayerProxy.c paramc) {}
    
    public final com.tencent.mm.g.h aCq(String paramString)
    {
      AppMethodBeat.i(334924);
      s.u(paramString, "id");
      FinderThumbPlayerProxy.c localc = this.GpG;
      long l = localc.Ezi.field_totalSize;
      if (l == 0L)
      {
        AppMethodBeat.o(334924);
        return null;
      }
      paramString = av.GiL;
      String str2 = localc.mediaId;
      Object localObject1 = localc.BtQ.downloadUrl;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      String str3 = localc.BtQ.path;
      localObject1 = localc.BtQ;
      int i;
      Object localObject2;
      String str4;
      if (localObject1 == null)
      {
        localObject1 = null;
        i = com.tencent.mm.modelcontrol.e.S(1, (String)localObject1);
        localObject2 = localc.Ezi.field_fileFormat;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        str4 = localc.BtQ.ANK.eCf();
        String str1 = localc.BtQ.ANK.eCF().decodeKey;
        localObject2 = str1;
        if (str1 == null) {
          localObject2 = "";
        }
        if (localc.BtQ.ANK.eCF().hot_flag != 1) {
          break label265;
        }
      }
      label265:
      for (boolean bool = true;; bool = false)
      {
        paramString = av.a(str2, paramString, str3, i, (String)localObject1, str4, (String)localObject2, bool, (g.a)localc, (g.b)localc, (int)(localc.Gpz * 100L / l), localc.Gpz, localc.GpA.getFTPPTag());
        AppMethodBeat.o(334924);
        return paramString;
        localObject1 = ((v)localObject1).path;
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnPreload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements com.tencent.mm.plugin.thumbplayer.b.d
  {
    l(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void Rv(int paramInt)
    {
      AppMethodBeat.i(334930);
      Log.i(this.GpA.getFTPPTag(), "startCdnPreload()#onStart(), real start download preload task " + FinderThumbPlayerProxy.e(this.GpA) + ' ' + paramInt);
      if (paramInt == -1) {
        FinderThumbPlayerProxy.u(this.GpA);
      }
      AppMethodBeat.o(334930);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startProgressTimer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "lastNotifyMs", "", "getLastNotifyMs", "()J", "setLastNotifyMs", "(J)V", "lastPlayPositionMs", "getLastPlayPositionMs", "setLastPlayPositionMs", "onTimerExpired", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements MTimerHandler.CallBack
  {
    private long FlA = -1L;
    private long FlB = -1L;
    
    m(FinderThumbPlayerProxy paramFinderThumbPlayerProxy, v paramv) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(334945);
      long l1 = this.GpA.getCurrentPlayMs();
      long l2 = this.GpA.getVideoDurationMs();
      if (this.FlB != l1)
      {
        localObject = this.GpA.getLifecycle();
        if (localObject != null) {
          ((ab)localObject).ar(l1, l2);
        }
        if ((this.FlA == -1L) || (l1 - this.FlA > 1000L) || (l1 < this.FlA))
        {
          localObject = this.GpA.getLifecycle();
          if (localObject != null) {
            ((ab)localObject).a(paramv.Grz, (int)l1 / 1000, (int)l2 / 1000);
          }
          Log.i(this.GpA.getFTPPTag(), l1 + '/' + l2);
          this.FlA = l1;
        }
        this.FlB = l1;
      }
      Object localObject = FinderThumbPlayerProxy.f(this.GpA);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.video.reporter.d)localObject).aB(l1, l2);
      }
      AppMethodBeat.o(334945);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$stopCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "onStop", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    implements g
  {
    n(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void a(int paramInt, com.tencent.mm.g.h paramh, com.tencent.mm.g.d paramd)
    {
      AppMethodBeat.i(334962);
      v localv = FinderThumbPlayerProxy.i(this.GpA);
      if (localv != null)
      {
        aa localaa = this.GpA.getDownloadCallback();
        if (localaa != null) {
          localaa.a(localv.ANK, paramh, paramd);
        }
      }
      Log.i(this.GpA.getFTPPTag(), "stopCdnDownload()#onStop(), real cancel download task " + FinderThumbPlayerProxy.e(this.GpA) + ' ' + paramInt);
      AppMethodBeat.o(334962);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$stopCdnPreload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "onStop", "", "ret", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    implements com.tencent.mm.plugin.thumbplayer.b.f
  {
    o(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void Ru(int paramInt)
    {
      AppMethodBeat.i(334901);
      Log.i(this.GpA.getFTPPTag(), "stopCdnPreload()#onStop " + FinderThumbPlayerProxy.e(this.GpA) + ' ' + paramInt);
      AppMethodBeat.o(334901);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    p(FinderThumbPlayerProxy paramFinderThumbPlayerProxy, v paramv, long paramLong1, long paramLong2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy
 * JD-Core Version:    0.7.0.1
 */