package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.a.e;
import com.tencent.mm.plugin.thumbplayer.f.d.a;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
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
import com.tencent.tmediacodec.e.b.a;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.r;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgPrepareStatus", "currSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "currentPlayState", "downloadCallback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "getDownloadCallback", "()Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "setDownloadCallback", "(Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;)V", "enableMediaCodecReuse", "", "fTPPKVReporter", "Lcom/tencent/mm/plugin/finder/video/reporter/FTPPKVReporter;", "getFTPPKVReporter", "()Lcom/tencent/mm/plugin/finder/video/reporter/FTPPKVReporter;", "fTPPKVReporter$delegate", "Lkotlin/Lazy;", "fTPPLog", "Lcom/tencent/mm/plugin/finder/video/log/FTPPLog;", "getFTPPLog", "()Lcom/tencent/mm/plugin/finder/video/log/FTPPLog;", "fTPPLog$delegate", "isBuffering", "isFirstFrameRendered", "isFirstStart", "isFullScreen", "isLongVideo", "isOpenFlowControl", "isPreviewing", "isRealStartDownloader", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isReuseForLongTerm", "isShouldPlayResume", "()Z", "setShouldPlayResume", "(Z)V", "isStartCdn", "setStartCdn", "isStartCdnPreload", "setStartCdnPreload", "isViewFocused", "setViewFocused", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaPreloadCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "getMediaPreloadCore$plugin_finder_release", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "setMediaPreloadCore$plugin_finder_release", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "notifyProgressTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onBufferingStartRunnable", "Ljava/lang/Runnable;", "onMuteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getOnMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setOnMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "onPlayerStopListener", "Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;", "getOnPlayerStopListener", "()Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;", "setOnPlayerStopListener", "(Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;)V", "onStopPlayData", "Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "playSpeedRatio", "", "getPlaySpeedRatio", "()F", "setPlaySpeedRatio", "(F)V", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "playerListener", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$TPPlayerListener;", "resourceLoaderProxy", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "surface", "Landroid/view/Surface;", "textureUpdateTimes", "textureView", "Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "videoPlayTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "videoViewCallback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "getVideoViewCallback", "()Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setVideoViewCallback", "(Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;)V", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrentPlayMs", "", "getCurrentPlaySecond", "getFTPPTag", "", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoDurationMs", "getVideoMediaId", "", "getVideoMediaInfo", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "handleOnBufferingEnd", "handleOnBufferingStart", "mediaId", "init", "initFTPPTag", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "initTextureView", "mediaInfo", "isFullScreenEnjoy", "isPause", "isPlaying", "isPrepared", "isPreparing", "isStartPlay", "currentState", "onRelease", "onUIDestroy", "pause", "pauseWithCancel", "play", "playInfo", "playWithSource", "source", "prepareCacheFile", "filePath", "invokeSource", "prepareForReuseTPView", "originTPView", "prepareOnlineUrl", "url", "prepareToPlay", "prepareVideo", "realPlay", "releaseSurface", "detach", "removeVideoFooterView", "resizeTextureView", "width", "height", "seekTo", "timestamp", "", "afterSeekPlay", "mode", "setBgPrepareStatus", "status", "setFinderVideoPlayTrace", "setFullScreenEnjoy", "isFull", "setIMMVideoViewCallback", "_callback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setLoop", "loop", "setMute", "isMute", "setPlaySpeed", "ratio", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "isLocal", "feedData", "setVideoMuteListener", "muteListener", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "startCdnDownload", "startCdnPreload", "startOrPlay", "startProgressTimer", "info", "stop", "stopCdnDownload", "stopCdnPreload", "stopProgressTimer", "updateIsRealStartDownloader", "isRealStart", "Companion", "ResourceLoaderProxy", "TPPlayerListener", "plugin-finder_release"})
public final class FinderThumbPlayerProxy
  extends FrameLayout
  implements s
{
  private static final HashSet<Integer> AML;
  public static final HashSet<String> AMM;
  public static final FinderThumbPlayerProxy.a AMN;
  public static String TAG;
  private boolean AJP;
  public z ALf;
  boolean ALj;
  private boolean ALk;
  private int AMA;
  public v AMB;
  private com.tencent.mm.plugin.findersdk.f.a AMC;
  private AtomicBoolean AMD;
  private boolean AME;
  public boolean AMF;
  private float AMG;
  public u AMH;
  public y AMI;
  private boolean AMJ;
  private boolean AMK;
  private boolean AMm;
  private com.tencent.mm.plugin.thumbplayer.f.a AMn;
  private c AMo;
  private MMThumbPlayerTextureView AMp;
  private SurfaceTexture AMq;
  private volatile boolean AMr;
  public com.tencent.mm.plugin.finder.preload.c AMs;
  public b AMt;
  private boolean AMu;
  private int AMv;
  private final kotlin.f AMw;
  private final kotlin.f AMx;
  private MTimerHandler AMy;
  private Runnable AMz;
  private boolean aLt;
  private volatile int currentPlayState;
  private boolean isLongVideo;
  private MMHandler knk;
  private Surface surface;
  private boolean wFf;
  private com.tencent.mm.plugin.finder.video.reporter.f xqB;
  public com.tencent.mm.plugin.finder.video.reporter.e xqC;
  public t xqv;
  public i.b zxu;
  
  static
  {
    AppMethodBeat.i(267508);
    AMN = new FinderThumbPlayerProxy.a((byte)0);
    TAG = "Finder.FinderThumbPlayerProxy";
    AML = new HashSet();
    AMM = new HashSet();
    AppMethodBeat.o(267508);
  }
  
  public FinderThumbPlayerProxy(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(267505);
    paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dWv().aSr()).intValue() == 1)
    {
      paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (!com.tencent.mm.plugin.finder.storage.d.dSS()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.AMm = bool;
      this.AMu = true;
      this.AMw = kotlin.g.ar((kotlin.g.a.a)FinderThumbPlayerProxy.d.AMZ);
      this.AMx = kotlin.g.ar((kotlin.g.a.a)FinderThumbPlayerProxy.e.ANa);
      this.knk = new MMHandler(Looper.getMainLooper());
      this.AMD = new AtomicBoolean(true);
      this.xqC = new com.tencent.mm.plugin.finder.video.reporter.e();
      this.AMG = 1.0F;
      init();
      AppMethodBeat.o(267505);
      return;
    }
  }
  
  public FinderThumbPlayerProxy(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(267506);
    paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dWv().aSr()).intValue() == 1)
    {
      paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (!com.tencent.mm.plugin.finder.storage.d.dSS()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.AMm = bool;
      this.AMu = true;
      this.AMw = kotlin.g.ar((kotlin.g.a.a)FinderThumbPlayerProxy.d.AMZ);
      this.AMx = kotlin.g.ar((kotlin.g.a.a)FinderThumbPlayerProxy.e.ANa);
      this.knk = new MMHandler(Looper.getMainLooper());
      this.AMD = new AtomicBoolean(true);
      this.xqC = new com.tencent.mm.plugin.finder.video.reporter.e();
      this.AMG = 1.0F;
      init();
      AppMethodBeat.o(267506);
      return;
    }
  }
  
  public FinderThumbPlayerProxy(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(267507);
    paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dWv().aSr()).intValue() == 1)
    {
      paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (!com.tencent.mm.plugin.finder.storage.d.dSS()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.AMm = bool;
      this.AMu = true;
      this.AMw = kotlin.g.ar((kotlin.g.a.a)FinderThumbPlayerProxy.d.AMZ);
      this.AMx = kotlin.g.ar((kotlin.g.a.a)FinderThumbPlayerProxy.e.ANa);
      this.knk = new MMHandler(Looper.getMainLooper());
      this.AMD = new AtomicBoolean(true);
      this.xqC = new com.tencent.mm.plugin.finder.video.reporter.e();
      this.AMG = 1.0F;
      init();
      AppMethodBeat.o(267507);
      return;
    }
  }
  
  private final boolean Rt(int paramInt)
  {
    com.tencent.mm.plugin.thumbplayer.f.a locala = null;
    AppMethodBeat.i(267469);
    Object localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder("prepareVideo() source:").append(paramInt).append(" isMoovReady:");
    Object localObject1 = this.AMt;
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).zvn;
      if (localObject1 != null)
      {
        localObject1 = Boolean.valueOf(((av)localObject1).field_moovReady);
        localStringBuilder = localStringBuilder.append(localObject1).append(' ').append("isAllCompleted:");
        localObject1 = this.AMt;
        if (localObject1 == null) {
          break label377;
        }
        localObject1 = ((b)localObject1).zvn;
        if (localObject1 == null) {
          break label377;
        }
        localObject1 = Boolean.valueOf(((av)localObject1).dKN());
        label106:
        localStringBuilder = localStringBuilder.append(localObject1).append(' ').append("downloadUrl:");
        localObject1 = this.xqv;
        if (localObject1 == null) {
          break label382;
        }
      }
    }
    label377:
    label382:
    for (localObject1 = ((t)localObject1).downloadUrl;; localObject1 = null)
    {
      Log.i((String)localObject2, (String)localObject1 + ' ' + eha());
      localObject1 = this.AMt;
      if (localObject1 != null) {
        ((b)localObject1).ehh();
      }
      localObject1 = this.AMt;
      if (localObject1 == null) {
        break label387;
      }
      localObject1 = ((b)localObject1).zvn;
      if ((localObject1 == null) || ((!((av)localObject1).field_moovReady) && (!((av)localObject1).dKN()) && (!(this.xqv instanceof com.tencent.mm.plugin.finder.video.source.a)))) {
        break label387;
      }
      localObject1 = this.AMn;
      if (localObject1 == null) {
        p.bGy("player");
      }
      localObject2 = i.AMl;
      ((com.tencent.mm.plugin.thumbplayer.f.a)localObject1).setPlayerOptionalParam(i.egZ());
      localObject1 = this.AMn;
      if (localObject1 == null) {
        p.bGy("player");
      }
      ((com.tencent.mm.plugin.thumbplayer.f.a)localObject1).enableTPAssetResourceLoader((com.tencent.thumbplayer.e.a.a)this.AMt);
      localObject2 = this.surface;
      if (localObject2 != null)
      {
        localObject1 = locala;
        if (((Surface)localObject2).isValid()) {
          localObject1 = localObject2;
        }
        if (localObject1 != null)
        {
          locala = this.AMn;
          if (locala == null) {
            p.bGy("player");
          }
          locala.setSurface((Surface)localObject1);
        }
      }
      localObject1 = this.AMC;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.findersdk.f.a)localObject1).aGV("prepareAsync");
      }
      localObject1 = this.AMn;
      if (localObject1 == null) {
        p.bGy("player");
      }
      ((com.tencent.mm.plugin.thumbplayer.f.a)localObject1).prepareAsync();
      AppMethodBeat.o(267469);
      return true;
      localObject1 = null;
      break;
      localObject1 = null;
      break label106;
    }
    label387:
    AppMethodBeat.o(267469);
    return false;
  }
  
  private static boolean Ru(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private final void S(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(267495);
    if (TextUtils.isEmpty((CharSequence)paramString2))
    {
      Log.w(TAG, "prepareCacheFile(), return for online url:".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(267495);
      return;
    }
    paramString2 = com.tencent.mm.vfs.u.n(paramString2, false);
    Log.i(TAG, "prepareCacheFile(), cache file:" + paramString2 + ", isExists:" + com.tencent.mm.vfs.u.agG(paramString2) + ' ' + eha());
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala == null) {
      p.bGy("player");
    }
    locala.setMediaId(paramString1);
    paramString1 = this.AMn;
    if (paramString1 == null) {
      p.bGy("player");
    }
    paramString1.setDataSource(paramString2);
    Rt(paramInt);
    AppMethodBeat.o(267495);
  }
  
  private final boolean ayN()
  {
    switch (this.currentPlayState)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private final void b(final t paramt)
  {
    AppMethodBeat.i(267503);
    Log.i(TAG, "startProgressTimer " + eha());
    if (this.AMy == null)
    {
      this.AMy = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)new l(this, paramt), true);
      paramt = this.AMy;
      if (paramt != null) {
        paramt.setLogging(false);
      }
    }
    paramt = this.AMy;
    if (paramt != null)
    {
      if (paramt.stopped() == true)
      {
        paramt = this.AMy;
        if (paramt != null)
        {
          paramt.startTimer(0L, 20L);
          AppMethodBeat.o(267503);
        }
      }
    }
    else
    {
      AppMethodBeat.o(267503);
      return;
    }
    AppMethodBeat.o(267503);
  }
  
  private final boolean cmp()
  {
    return this.currentPlayState == 3;
  }
  
  private final String eha()
  {
    AppMethodBeat.i(267450);
    Object localObject1 = new StringBuilder("loader:");
    Object localObject2 = this.AMt;
    int i;
    if (localObject2 != null)
    {
      i = ((b)localObject2).hashCode();
      StringBuilder localStringBuilder = ((StringBuilder)localObject1).append(i).append(" proxy:").append(hashCode()).append(" mediaId: ");
      localObject1 = this.xqv;
      if (localObject1 != null)
      {
        localObject2 = ((t)localObject1).mediaId;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject1 = localStringBuilder.append((String)localObject1).append(" player:");
      localObject2 = this.AMn;
      if (localObject2 == null) {
        p.bGy("player");
      }
      localObject2 = ((StringBuilder)localObject1).append(localObject2.hashCode()).append(" viewFocus:").append(this.ALj).append(" alpha:").append(getAlpha()).append(" surface:");
      localObject1 = this.surface;
      if (localObject1 == null) {
        break label202;
      }
    }
    label202:
    for (localObject1 = Boolean.valueOf(((Surface)localObject1).isValid());; localObject1 = null)
    {
      localObject1 = localObject1 + " currentPlayState:" + this.currentPlayState;
      AppMethodBeat.o(267450);
      return localObject1;
      i = 0;
      break;
    }
  }
  
  private final void ehb()
  {
    AppMethodBeat.i(267468);
    Log.i(TAG, "realPlay() " + eha());
    setBgPrepareStatus(0);
    Object localObject = this.AMC;
    if (localObject != null) {
      ((com.tencent.mm.plugin.findersdk.f.a)localObject).aGV("start");
    }
    localObject = this.AMn;
    if (localObject == null) {
      p.bGy("player");
    }
    ((com.tencent.mm.plugin.thumbplayer.f.a)localObject).start();
    localObject = this.xqv;
    if (localObject != null)
    {
      b((t)localObject);
      AppMethodBeat.o(267468);
      return;
    }
    AppMethodBeat.o(267468);
  }
  
  private final void ehc()
  {
    AppMethodBeat.i(267497);
    Log.i(TAG, "startCdnDownload()");
    if (this.AMJ)
    {
      Log.i(TAG, "startCdnDownload() already start cdn " + eha());
      AppMethodBeat.o(267497);
      return;
    }
    ehe();
    Object localObject1 = aj.AGc;
    Object localObject2 = this.AMt;
    localObject1 = this.AMt;
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).zvn;
      if ((localObject2 == null) || (localObject1 == null)) {
        break label370;
      }
      Log.i(TAG, "startCdnDownload() " + eha());
      com.tencent.mm.plugin.finder.preload.c localc = this.AMs;
      if (localc != null) {
        localc.br(((b)localObject2).mediaId, true);
      }
      if (((av)localObject1).dKN()) {
        break label344;
      }
      if (this.AME)
      {
        localObject1 = this.AMs;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.preload.c)localObject1).aDF(((b)localObject2).mediaId);
        }
      }
      rc(false);
      Log.i(TAG, "startCdnDownload: isLongTermId = " + AMM.contains(((b)localObject2).mediaId) + " isLongTermView = " + this.AMF);
      if ((AMM.contains(((b)localObject2).mediaId)) && (!this.AMF)) {
        break label322;
      }
      ((PluginThumbPlayer)com.tencent.mm.kernel.h.ag(PluginThumbPlayer.class)).getCdnTaskController().a(((b)localObject2).mediaId, (com.tencent.mm.plugin.thumbplayer.b.b)new i((b)localObject2), (com.tencent.mm.plugin.thumbplayer.b.e)new h(this));
    }
    for (;;)
    {
      this.AMJ = true;
      localObject1 = this.xqv;
      if (localObject1 == null) {
        break label337;
      }
      localObject2 = this.AMI;
      if (localObject2 == null) {
        break label330;
      }
      ((y)localObject2).b(((t)localObject1).xqx);
      AppMethodBeat.o(267497);
      return;
      localObject1 = null;
      break;
      label322:
      rc(true);
    }
    label330:
    AppMethodBeat.o(267497);
    return;
    label337:
    AppMethodBeat.o(267497);
    return;
    label344:
    Log.i(TAG, "startCdnDownload() downloadFinish " + eha());
    label370:
    AppMethodBeat.o(267497);
  }
  
  private final void ehe()
  {
    AppMethodBeat.i(267499);
    Log.i(TAG, "stopCdnPreload()");
    if (!this.AMK)
    {
      Log.i(TAG, "stopCdnPreload(), not start preload cdn " + eha());
      AppMethodBeat.o(267499);
      return;
    }
    b localb = this.AMt;
    if (localb != null)
    {
      ((PluginThumbPlayer)com.tencent.mm.kernel.h.ag(PluginThumbPlayer.class)).getCdnTaskController().a(localb.mediaId, (com.tencent.mm.plugin.thumbplayer.b.f)new n(this));
      this.AMK = false;
      AppMethodBeat.o(267499);
      return;
    }
    AppMethodBeat.o(267499);
  }
  
  private final void ehf()
  {
    AppMethodBeat.i(267504);
    Log.i(TAG, "stopProgressTimer :" + this.AMy + ' ' + eha());
    Object localObject = this.xqv;
    if (localObject != null) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new o((t)localObject, getCurrentPlayMs(), getVideoDurationMs(), this));
    }
    localObject = this.AMy;
    if (localObject != null)
    {
      ((MTimerHandler)localObject).stopTimer();
      AppMethodBeat.o(267504);
      return;
    }
    AppMethodBeat.o(267504);
  }
  
  private final com.tencent.mm.plugin.finder.video.reporter.a getFTPPKVReporter()
  {
    AppMethodBeat.i(267444);
    com.tencent.mm.plugin.finder.video.reporter.a locala = (com.tencent.mm.plugin.finder.video.reporter.a)this.AMw.getValue();
    AppMethodBeat.o(267444);
    return locala;
  }
  
  private final com.tencent.mm.plugin.finder.video.log.a getFTPPLog()
  {
    AppMethodBeat.i(267445);
    com.tencent.mm.plugin.finder.video.log.a locala = (com.tencent.mm.plugin.finder.video.log.a)this.AMx.getValue();
    AppMethodBeat.o(267445);
    return locala;
  }
  
  private final void getFTPPTag() {}
  
  private final boolean hx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(267496);
    if (TextUtils.isEmpty((CharSequence)paramString2))
    {
      Log.w(TAG, "prepareOnlineUrl(), return for online url:" + paramString2 + "  " + eha());
      AppMethodBeat.o(267496);
      return false;
    }
    Log.i(TAG, "prepareOnlineUrl(), online url:" + paramString2 + "  " + eha());
    TPVideoInfo.Builder localBuilder = new TPVideoInfo.Builder();
    localBuilder.fileId(paramString1);
    localBuilder.downloadParam(new TPDownloadParamData(11));
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala == null) {
      p.bGy("player");
    }
    locala.setMediaId(paramString1);
    paramString1 = this.AMn;
    if (paramString1 == null) {
      p.bGy("player");
    }
    paramString1.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 1000L));
    paramString1 = this.AMn;
    if (paramString1 == null) {
      p.bGy("player");
    }
    paramString1.setVideoInfo(localBuilder.build());
    paramString1 = this.AMn;
    if (paramString1 == null) {
      p.bGy("player");
    }
    paramString1.setDataSource(paramString2);
    boolean bool = Rt(5);
    AppMethodBeat.o(267496);
    return bool;
  }
  
  private final void init()
  {
    AppMethodBeat.i(267448);
    AML.add(Integer.valueOf(hashCode()));
    Log.i(TAG, "create FinderThumbPlayerProxy " + hashCode() + ' ' + AML);
    Object localObject1 = com.tencent.tmediacodec.e.b.ZPv;
    ((com.tencent.tmediacodec.e.b)localObject1).ZPu = b.a.ZPx;
    Object localObject2 = com.tencent.tmediacodec.a.isT();
    p.j(localObject2, "TCodecManager.getInstance()");
    ((com.tencent.tmediacodec.a)localObject2).a((com.tencent.tmediacodec.e.b)localObject1);
    localObject1 = com.tencent.tmediacodec.a.isT();
    p.j(localObject1, "TCodecManager.getInstance()");
    ((com.tencent.tmediacodec.a)localObject1).isU();
    localObject1 = com.tencent.mm.plugin.thumbplayer.f.d.MTv;
    localObject1 = MMApplicationContext.getContext();
    p.j(localObject1, "MMApplicationContext.getContext()");
    this.AMn = d.a.iz((Context)localObject1);
    this.AMo = new c();
    if (this.AMm) {}
    for (int i = 1;; i = 0)
    {
      this.xqB = new com.tencent.mm.plugin.finder.video.reporter.f(i);
      this.xqC.reset();
      this.AMp = new MMThumbPlayerTextureView(MMApplicationContext.getContext());
      localObject1 = this.AMp;
      if (localObject1 == null) {
        p.bGy("textureView");
      }
      ((MMThumbPlayerTextureView)localObject1).setOpaqueInfo(true);
      localObject1 = this.AMp;
      if (localObject1 == null) {
        p.bGy("textureView");
      }
      localObject2 = this.AMo;
      if (localObject2 == null) {
        p.bGy("playerListener");
      }
      ((MMThumbPlayerTextureView)localObject1).setTextureListenerCallback((TextureView.SurfaceTextureListener)localObject2);
      localObject1 = this.AMn;
      if (localObject1 == null) {
        p.bGy("player");
      }
      localObject2 = this.AMo;
      if (localObject2 == null) {
        p.bGy("playerListener");
      }
      ((com.tencent.mm.plugin.thumbplayer.f.a)localObject1).setOnErrorListener((ITPPlayerListener.IOnErrorListener)localObject2);
      localObject1 = this.AMn;
      if (localObject1 == null) {
        p.bGy("player");
      }
      localObject2 = this.AMo;
      if (localObject2 == null) {
        p.bGy("playerListener");
      }
      ((com.tencent.mm.plugin.thumbplayer.f.a)localObject1).setOnPreparedListener((ITPPlayerListener.IOnPreparedListener)localObject2);
      localObject1 = this.AMn;
      if (localObject1 == null) {
        p.bGy("player");
      }
      localObject2 = this.AMo;
      if (localObject2 == null) {
        p.bGy("playerListener");
      }
      ((com.tencent.mm.plugin.thumbplayer.f.a)localObject1).setOnVideoSizeChangedListener((ITPPlayerListener.IOnVideoSizeChangedListener)localObject2);
      localObject1 = this.AMn;
      if (localObject1 == null) {
        p.bGy("player");
      }
      localObject2 = this.AMo;
      if (localObject2 == null) {
        p.bGy("playerListener");
      }
      ((com.tencent.mm.plugin.thumbplayer.f.a)localObject1).setOnPlayerStateChangeListener((ITPPlayerListener.IOnStateChangeListener)localObject2);
      localObject1 = this.AMn;
      if (localObject1 == null) {
        p.bGy("player");
      }
      localObject2 = this.AMo;
      if (localObject2 == null) {
        p.bGy("playerListener");
      }
      ((com.tencent.mm.plugin.thumbplayer.f.a)localObject1).setOnInfoListener((ITPPlayerListener.IOnInfoListener)localObject2);
      AppMethodBeat.o(267448);
      return;
    }
  }
  
  private final void rb(boolean paramBoolean)
  {
    AppMethodBeat.i(267451);
    Log.i(TAG, "releaseSurface " + eha() + ", isReusing = " + this.AMF + ", detach = " + paramBoolean);
    if ((this.AMF) && (!paramBoolean))
    {
      AppMethodBeat.o(267451);
      return;
    }
    if (this.surface != null)
    {
      Object localObject = this.AMn;
      if (localObject == null) {
        p.bGy("player");
      }
      ((com.tencent.mm.plugin.thumbplayer.f.a)localObject).setSurface(null);
      localObject = this.surface;
      if (localObject != null) {
        ((Surface)localObject).release();
      }
      if (paramBoolean)
      {
        localObject = this.AMp;
        if (localObject == null) {
          p.bGy("textureView");
        }
        ((MMThumbPlayerTextureView)localObject).goX();
      }
      this.surface = null;
      this.AMq = null;
    }
    AppMethodBeat.o(267451);
  }
  
  private final void rc(boolean paramBoolean)
  {
    AppMethodBeat.i(267492);
    Log.i(TAG, "updateIsReaStartDownloader() isReaStartDownloader:".concat(String.valueOf(paramBoolean)));
    this.AMD.set(paramBoolean);
    AppMethodBeat.o(267492);
  }
  
  private final void setBgPrepareStatus(int paramInt)
  {
    AppMethodBeat.i(267502);
    Log.i(TAG, "setBgPrepareStatus " + paramInt + ' ' + eha());
    this.AMv = paramInt;
    AppMethodBeat.o(267502);
  }
  
  public final boolean Rs(int paramInt)
  {
    AppMethodBeat.i(267467);
    Log.i(TAG, "playWithSource() source=" + paramInt + ' ' + eha() + ' ');
    if (!this.ALj)
    {
      Log.i(TAG, "playWithSource() return for isViewFocused:" + this.ALj);
      AppMethodBeat.o(267467);
      return false;
    }
    if (!Ru(this.currentPlayState))
    {
      Log.i(TAG, "playWithSource() return for currentState:" + this.currentPlayState);
      AppMethodBeat.o(267467);
      return false;
    }
    boolean bool = isPlaying();
    if ((bool) && (paramInt != -1))
    {
      Log.i(TAG, "playWithSource() return for isPlaying:".concat(String.valueOf(bool)));
      AppMethodBeat.o(267467);
      return false;
    }
    Object localObject;
    if (ayN())
    {
      localObject = this.surface;
      if (localObject != null)
      {
        if (!((Surface)localObject).isValid()) {
          break label233;
        }
        if (localObject != null) {
          ehb();
        }
      }
    }
    for (;;)
    {
      ehc();
      localObject = this.AMn;
      if (localObject == null) {
        p.bGy("player");
      }
      ((com.tencent.mm.plugin.thumbplayer.f.a)localObject).resumeDownload();
      AppMethodBeat.o(267467);
      return true;
      label233:
      localObject = null;
      break;
      if (!cmp()) {
        Rt(0);
      }
    }
  }
  
  public final void a(ac paramac, boolean paramBoolean, FeedData paramFeedData)
  {
    AppMethodBeat.i(267449);
    p.k(paramac, "video");
    p.k(paramFeedData, "feedData");
    Object localObject = this.AMC;
    if (localObject != null) {
      ((com.tencent.mm.plugin.findersdk.f.a)localObject).aGV("setMediaInfo");
    }
    csg localcsg = paramac.dJw();
    if (paramBoolean)
    {
      String str = localcsg.url;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramac = (t)new com.tencent.mm.plugin.finder.video.source.a("", (String)localObject, paramac.aBv(), localcsg, paramac, paramFeedData);
      this.xqv = paramac;
      paramac = this.AMt;
      if (paramac == null) {
        break label310;
      }
      paramac = paramac.mediaId;
      label117:
      paramFeedData = this.xqv;
      if (paramFeedData == null) {
        p.iCn();
      }
      if (!(p.h(paramac, paramFeedData.mediaId) ^ true)) {
        break label315;
      }
      paramac = this.xqv;
      if (paramac == null) {
        p.iCn();
      }
      paramac = paramac.mediaId;
      paramFeedData = this.xqv;
      if (paramFeedData == null) {
        p.iCn();
      }
      this.AMt = new b(paramac, paramFeedData);
      Log.i(TAG, "setVideoMediaInfo(), init proxy " + this.AMt);
    }
    for (;;)
    {
      paramac = this.xqv;
      if (paramac == null) {
        p.iCn();
      }
      a(paramac);
      this.xqC.reset();
      paramac = this.xqC;
      paramFeedData = this.xqv;
      if (paramFeedData == null) {
        p.iCn();
      }
      paramac.init(paramFeedData.mediaId);
      this.xqC.ehS();
      AppMethodBeat.o(267449);
      return;
      paramac = (t)new com.tencent.mm.plugin.finder.video.source.b(paramac.getUrl(), paramac.getPath(), paramac.aBv(), localcsg, paramac, paramFeedData);
      break;
      label310:
      paramac = null;
      break label117;
      label315:
      Log.w(TAG, "setVideoMediaInfo(), duplicated mediaId " + this.AMt);
    }
  }
  
  public final void a(t paramt)
  {
    AppMethodBeat.i(267494);
    Object localObject1 = this.AMp;
    if (localObject1 == null) {
      p.bGy("textureView");
    }
    if (((MMThumbPlayerTextureView)localObject1).getParent() != null)
    {
      localObject1 = this.AMp;
      if (localObject1 == null) {
        p.bGy("textureView");
      }
      removeView((View)localObject1);
    }
    int i;
    int j;
    Object localObject2;
    float f1;
    if (this.isLongVideo)
    {
      localObject1 = aj.AGc;
      localObject1 = getContext();
      p.j(localObject1, "context");
      localObject1 = aj.a((Context)localObject1, paramt.xqx.dJw().width, paramt.xqx.dJw().height);
      i = ((Number)((r)localObject1).My).intValue();
      j = ((Number)((r)localObject1).aazK).intValue();
      localObject1 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject1).gravity = 17;
      localObject2 = this.AMp;
      if (localObject2 == null) {
        p.bGy("textureView");
      }
      addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      localObject1 = this.AMp;
      if (localObject1 == null) {
        p.bGy("textureView");
      }
      ((MMThumbPlayerTextureView)localObject1).kw(i, j);
      localObject1 = paramt.APg;
      if (localObject1 != null)
      {
        localObject1 = ((csg)localObject1).TAa;
        if (localObject1 != null)
        {
          localObject2 = this.AMp;
          if (localObject2 == null) {
            p.bGy("textureView");
          }
          ((MMThumbPlayerTextureView)localObject2).setCropRect(new Rect((int)((awc)localObject1).left, (int)((awc)localObject1).top, (int)((awc)localObject1).right, (int)((awc)localObject1).bottom));
          localObject1 = this.AMp;
          if (localObject1 == null) {
            p.bGy("textureView");
          }
          if (paramt == null) {
            break label480;
          }
          localObject2 = paramt.APg;
          if (localObject2 == null) {
            break label480;
          }
          f1 = ((csg)localObject2).width;
          label331:
          if (paramt == null) {
            break label485;
          }
          paramt = paramt.APg;
          if (paramt == null) {
            break label485;
          }
        }
      }
    }
    label480:
    label485:
    for (float f2 = paramt.height;; f2 = 0.0F)
    {
      ((MMThumbPlayerTextureView)localObject1).at(f1, f2);
      Log.i(TAG, "initTextureView(), isLongVideo:" + this.isLongVideo + " containerWidth:" + i + " containerHeight:" + j + ' ' + eha());
      AppMethodBeat.o(267494);
      return;
      localObject1 = com.tencent.mm.plugin.finder.storage.data.i.a(paramt.xqx.dJw(), this.AJP);
      localObject2 = aj.AGc;
      localObject2 = getContext();
      p.j(localObject2, "context");
      localObject1 = aj.g((Context)localObject2, ((Size)localObject1).getWidth(), ((Size)localObject1).getHeight());
      break;
      f1 = 0.0F;
      break label331;
    }
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(267479);
    paramBoolean = a(paramDouble, paramBoolean, 1);
    AppMethodBeat.o(267479);
    return paramBoolean;
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(267480);
    if (!Ru(this.currentPlayState))
    {
      AppMethodBeat.o(267480);
      return false;
    }
    if (!ayN())
    {
      AppMethodBeat.o(267480);
      return false;
    }
    Log.i(TAG, "seekTo " + paramDouble + ' ' + paramBoolean);
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala == null) {
      p.bGy("player");
    }
    locala.seekTo(kotlin.h.a.M(1000.0D * paramDouble), paramInt);
    if (paramBoolean) {
      bqo();
    }
    AppMethodBeat.o(267480);
    return true;
  }
  
  public final boolean bqo()
  {
    AppMethodBeat.i(267466);
    Log.i(TAG, "play()");
    boolean bool = Rs(0);
    AppMethodBeat.o(267466);
    return bool;
  }
  
  public final boolean egV()
  {
    AppMethodBeat.i(267472);
    Log.i(TAG, "startOrPlay() " + eha());
    this.xqC.ehS();
    if (!this.ALj)
    {
      Log.i(TAG, "startOrPlay() return for isViewFocused:" + this.ALj);
      AppMethodBeat.o(267472);
      return false;
    }
    Object localObject = this.AMC;
    if (localObject != null) {
      ((com.tencent.mm.plugin.findersdk.f.a)localObject).aGV("startOrPlay");
    }
    if (this.AMu)
    {
      Log.i(TAG, "startOrPlay() first time to play");
      localObject = this.ALf;
      if (localObject != null) {
        ((z)localObject).a(this.xqB);
      }
      localObject = this.ALf;
      if (localObject != null) {
        ((z)localObject).a(this.xqv, this.AMv);
      }
      this.AMu = false;
      com.tencent.mm.plugin.report.service.h.IzE.p(1505L, 252L, 1L);
    }
    if (Ru(this.currentPlayState))
    {
      Log.i(TAG, "startOrPlay() return for currentPlayState:" + this.currentPlayState);
      if (Rs(3)) {
        this.AMA = 0;
      }
      AppMethodBeat.o(267472);
      return false;
    }
    localObject = this.AMt;
    if (localObject != null) {
      ((b)localObject).ehh();
    }
    localObject = aj.AGc;
    t localt = this.xqv;
    b localb = this.AMt;
    localObject = this.AMt;
    boolean bool1;
    boolean bool2;
    if (localObject != null)
    {
      localObject = ((b)localObject).zvn;
      if ((localt == null) || (localb == null) || (localObject == null)) {
        break label444;
      }
      bool1 = ((av)localObject).dKN();
      bool2 = com.tencent.mm.vfs.u.agG(localt.path);
      Log.i(TAG, "startOrPlay() isAllCompleted:" + bool1 + " isExist:" + bool2 + ' ' + eha());
      this.AMA = 0;
      if (!(localt instanceof com.tencent.mm.plugin.finder.video.source.a)) {
        break label387;
      }
      S(localt.mediaId, localt.path, 41);
    }
    for (;;)
    {
      AppMethodBeat.o(267472);
      return true;
      localObject = null;
      break;
      label387:
      if (((localt instanceof com.tencent.mm.plugin.finder.video.source.b)) && (bool1) && (bool2))
      {
        S(localt.mediaId, localt.path, 42);
      }
      else
      {
        ehc();
        hx(localt.mediaId, localt.downloadUrl);
      }
    }
    label444:
    AppMethodBeat.o(267472);
    return false;
  }
  
  public final int egW()
  {
    AppMethodBeat.i(267475);
    Log.i(TAG, "pauseWithCancel " + eha());
    com.tencent.mm.plugin.finder.video.reporter.e locale = this.xqC;
    if ((locale.ASH == 0L) || (locale.ASD > 0L)) {}
    for (;;)
    {
      pause();
      AppMethodBeat.o(267475);
      return 0;
      long l = SystemClock.elapsedRealtime() - locale.ASH;
      if (l >= 0L) {
        locale.ASD += l;
      }
      if (l > locale.ASG) {
        locale.ASG = l;
      }
      Log.i("OnStopPlayData", "onBlur focusTimeMs:" + l + " focusMaxTimeMs:" + locale.ASG + " blurFPS:" + locale.ehT() + ' ' + locale.mediaId);
    }
  }
  
  public final void egX() {}
  
  public final boolean egw()
  {
    AppMethodBeat.i(267473);
    if (this.ALj)
    {
      Log.i(TAG, "prepareToPlay() return for isViewFocused:" + this.ALj);
      AppMethodBeat.o(267473);
      return false;
    }
    Log.i(TAG, "prepareToPlay()  " + eha());
    if (Ru(this.currentPlayState))
    {
      if (this.currentPlayState == 2)
      {
        bool1 = Rt(1);
        AppMethodBeat.o(267473);
        return bool1;
      }
      AppMethodBeat.o(267473);
      return false;
    }
    Object localObject = this.AMt;
    if (localObject != null) {
      ((b)localObject).ehh();
    }
    localObject = aj.AGc;
    t localt = this.xqv;
    b localb = this.AMt;
    localObject = this.AMt;
    boolean bool2;
    if (localObject != null)
    {
      localObject = ((b)localObject).zvn;
      if ((localt == null) || (localb == null) || (localObject == null)) {
        break label324;
      }
      bool1 = ((av)localObject).dKN();
      bool2 = com.tencent.mm.vfs.u.agG(localt.path);
      Log.i(TAG, "prepareToPlay() isAllCompleted:" + bool1 + " isExist:" + bool2 + ' ' + eha());
      if (!(localt instanceof com.tencent.mm.plugin.finder.video.source.a)) {
        break label266;
      }
      S(localt.mediaId, localt.path, 21);
    }
    for (;;)
    {
      AppMethodBeat.o(267473);
      return true;
      localObject = null;
      break;
      label266:
      if ((!(localt instanceof com.tencent.mm.plugin.finder.video.source.b)) || (!bool1) || (!bool2)) {
        break label301;
      }
      S(localt.mediaId, localt.path, 22);
    }
    label301:
    boolean bool1 = hx(localt.mediaId, localt.downloadUrl);
    AppMethodBeat.o(267473);
    return bool1;
    label324:
    AppMethodBeat.o(267473);
    return false;
  }
  
  public final boolean egx()
  {
    return this.wFf;
  }
  
  public final void ehd()
  {
    AppMethodBeat.i(267498);
    Log.i(TAG, "stopCdnDownload()");
    if (!this.AMJ)
    {
      Log.i(TAG, "stopCdnDownload() not start cdn " + eha());
      AppMethodBeat.o(267498);
      return;
    }
    b localb = this.AMt;
    if (localb != null)
    {
      Log.i(TAG, "stopCdnDownload() " + eha());
      com.tencent.mm.plugin.finder.preload.c localc = this.AMs;
      if (localc != null) {
        localc.br(localb.mediaId, false);
      }
      localb.rd(false);
      Log.i(TAG, "stopCdnDownload: isLongTermId = " + AMM.contains(localb.mediaId) + " isLongTermView = " + this.AMF);
      if ((!AMM.contains(localb.mediaId)) || (this.AMF)) {
        ((PluginThumbPlayer)com.tencent.mm.kernel.h.ag(PluginThumbPlayer.class)).getCdnTaskController().a(localb.mediaId, (com.tencent.mm.plugin.thumbplayer.b.g)new m(this));
      }
      this.AMJ = false;
      AppMethodBeat.o(267498);
      return;
    }
    AppMethodBeat.o(267498);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(267452);
    Object localObject = this.AMp;
    if (localObject == null) {
      p.bGy("textureView");
    }
    localObject = ((MMThumbPlayerTextureView)localObject).getBitmap();
    AppMethodBeat.o(267452);
    return localObject;
  }
  
  public final long getCurrentPlayMs()
  {
    AppMethodBeat.i(267454);
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala == null) {
      p.bGy("player");
    }
    long l = locala.getCurrentPositionMs();
    AppMethodBeat.o(267454);
    return l;
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(267453);
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala == null) {
      p.bGy("player");
    }
    int i = (int)(locala.getCurrentPositionMs() / 1000L);
    AppMethodBeat.o(267453);
    return i;
  }
  
  public final y getDownloadCallback()
  {
    return this.AMI;
  }
  
  public final boolean getIsNeverStart()
  {
    AppMethodBeat.i(267460);
    if (!Ru(this.currentPlayState))
    {
      AppMethodBeat.o(267460);
      return true;
    }
    AppMethodBeat.o(267460);
    return false;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.ALk;
  }
  
  public final z getLifecycle()
  {
    return this.ALf;
  }
  
  public final com.tencent.mm.plugin.finder.preload.c getMediaPreloadCore$plugin_finder_release()
  {
    return this.AMs;
  }
  
  public final u getOnMuteListener()
  {
    return this.AMH;
  }
  
  public final v getOnPlayerStopListener()
  {
    return this.AMB;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(267461);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(267461);
    return localViewParent;
  }
  
  public final float getPlaySpeedRatio()
  {
    return this.AMG;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(267455);
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala == null) {
      p.bGy("player");
    }
    int i = (int)(locala.getDurationMs() / 1000L);
    AppMethodBeat.o(267455);
    return i;
  }
  
  public final long getVideoDurationMs()
  {
    AppMethodBeat.i(267457);
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala == null) {
      p.bGy("player");
    }
    long l = locala.getDurationMs();
    AppMethodBeat.o(267457);
    return l;
  }
  
  public final String getVideoMediaId()
  {
    Object localObject = this.xqv;
    if (localObject != null)
    {
      String str = ((t)localObject).mediaId;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final t getVideoMediaInfo()
  {
    return this.xqv;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final i.b getVideoViewCallback()
  {
    return this.zxu;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.ALj;
  }
  
  public final void hg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(267500);
    MMThumbPlayerTextureView localMMThumbPlayerTextureView = this.AMp;
    if (localMMThumbPlayerTextureView == null) {
      p.bGy("textureView");
    }
    localMMThumbPlayerTextureView.getLayoutParams().width = paramInt1;
    localMMThumbPlayerTextureView = this.AMp;
    if (localMMThumbPlayerTextureView == null) {
      p.bGy("textureView");
    }
    localMMThumbPlayerTextureView.getLayoutParams().height = paramInt2;
    localMMThumbPlayerTextureView = this.AMp;
    if (localMMThumbPlayerTextureView == null) {
      p.bGy("textureView");
    }
    localMMThumbPlayerTextureView.kw(paramInt1, paramInt2);
    localMMThumbPlayerTextureView = this.AMp;
    if (localMMThumbPlayerTextureView == null) {
      p.bGy("textureView");
    }
    localMMThumbPlayerTextureView.requestLayout();
    AppMethodBeat.o(267500);
  }
  
  public final boolean isPlaying()
  {
    return this.currentPlayState == 5;
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(267493);
    Log.i(TAG, "release FinderThumbPlayerProxy " + eha());
    this.xqB = null;
    rb(true);
    this.AMI = null;
    com.tencent.mm.ae.d.c(TAG, (kotlin.g.a.a)new FinderThumbPlayerProxy.g(this));
    AML.remove(Integer.valueOf(hashCode()));
    if (this.AMF) {
      AMM.clear();
    }
    this.AMt = null;
    AppMethodBeat.o(267493);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(267478);
    Log.i(TAG, "onUIDestroy " + eha());
    stop();
    AppMethodBeat.o(267478);
  }
  
  public final boolean pause()
  {
    int i = 0;
    AppMethodBeat.i(267474);
    if (!Ru(this.currentPlayState))
    {
      Log.i(TAG, "pause() return for state:" + this.currentPlayState);
      ehd();
      AppMethodBeat.o(267474);
      return false;
    }
    Log.i(TAG, "pause()  " + eha());
    Object localObject1;
    if (isPlaying())
    {
      localObject1 = this.AMn;
      if (localObject1 == null) {
        p.bGy("player");
      }
      ((com.tencent.mm.plugin.thumbplayer.f.a)localObject1).pause();
      localObject1 = this.AMn;
      if (localObject1 == null) {
        p.bGy("player");
      }
      ((com.tencent.mm.plugin.thumbplayer.f.a)localObject1).pauseDownload();
      ehd();
      if (this.ALk)
      {
        Log.i(TAG, "startCdnPreload() " + eha());
        if (!this.AMK) {
          break label309;
        }
        Log.i(TAG, "startCdnPreload(), already start preload cdn " + eha());
      }
    }
    for (;;)
    {
      ehf();
      if (this.xqv != null)
      {
        localObject1 = this.ALf;
        if (localObject1 != null) {
          ((z)localObject1).a(this.xqC.ehR());
        }
      }
      AppMethodBeat.o(267474);
      return true;
      if ((!cmp()) || (this.ALj)) {
        break;
      }
      long l = System.currentTimeMillis();
      stop();
      Log.i(TAG, "pause() preparing stop cost=" + (System.currentTimeMillis() - l) + "ms");
      break;
      label309:
      Object localObject2 = this.AMt;
      if ((localObject2 != null) && (((b)localObject2).zvn.field_cacheSize < ((b)localObject2).AMW) && (((b)localObject2).zvn.field_totalSize > 0L))
      {
        localObject1 = ((PluginThumbPlayer)com.tencent.mm.kernel.h.ag(PluginThumbPlayer.class)).getCdnTaskController();
        String str = ((b)localObject2).mediaId;
        localObject2 = (com.tencent.mm.plugin.thumbplayer.b.b)new k((b)localObject2);
        com.tencent.mm.plugin.thumbplayer.b.d locald = (com.tencent.mm.plugin.thumbplayer.b.d)new j(this);
        p.k(str, "mediaId");
        p.k(localObject2, "createCallback");
        if (((CharSequence)str).length() == 0) {
          i = 1;
        }
        if (i == 0) {
          com.tencent.mm.ae.d.c("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new a.e((com.tencent.mm.plugin.thumbplayer.b.a)localObject1, (com.tencent.mm.plugin.thumbplayer.b.b)localObject2, str, locald));
        }
        this.AMK = true;
      }
    }
  }
  
  public final void setDownloadCallback(y paramy)
  {
    this.AMI = paramy;
  }
  
  public final void setFinderVideoPlayTrace(com.tencent.mm.plugin.findersdk.f.a parama)
  {
    this.AMC = parama;
  }
  
  public final void setFullScreenEnjoy(boolean paramBoolean)
  {
    this.AJP = paramBoolean;
  }
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(267482);
    p.k(paramb, "_callback");
    this.zxu = paramb;
    AppMethodBeat.o(267482);
  }
  
  public final void setIOnlineVideoProxy(com.tencent.mm.modelvideo.f paramf)
  {
    AppMethodBeat.i(267484);
    p.k(paramf, "_proxy");
    AppMethodBeat.o(267484);
  }
  
  public final void setInterceptDetach(boolean paramBoolean)
  {
    AppMethodBeat.i(267465);
    MMThumbPlayerTextureView localMMThumbPlayerTextureView = this.AMp;
    if (localMMThumbPlayerTextureView == null) {
      p.bGy("textureView");
    }
    localMMThumbPlayerTextureView.setInterceptDetach(paramBoolean);
    AppMethodBeat.o(267465);
  }
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    AppMethodBeat.i(267462);
    Log.i(TAG, "setIsShouldPlayResume() " + paramBoolean + ' ' + eha());
    this.ALk = paramBoolean;
    AppMethodBeat.o(267462);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean) {}
  
  public final void setLifecycle(z paramz)
  {
    this.ALf = paramz;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(267486);
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala == null) {
      p.bGy("player");
    }
    locala.setLoopback(paramBoolean);
    AppMethodBeat.o(267486);
  }
  
  public final void setMediaPreloadCore$plugin_finder_release(com.tencent.mm.plugin.finder.preload.c paramc)
  {
    this.AMs = paramc;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(267481);
    com.tencent.mm.plugin.thumbplayer.f.a locala = this.AMn;
    if (locala == null) {
      p.bGy("player");
    }
    locala.setOutputMute(paramBoolean);
    AppMethodBeat.o(267481);
  }
  
  public final void setOnMuteListener(u paramu)
  {
    this.AMH = paramu;
  }
  
  public final void setOnPlayerStopListener(v paramv)
  {
    this.AMB = paramv;
  }
  
  public final void setPlaySpeed(float paramFloat)
  {
    AppMethodBeat.i(267501);
    String str = TAG;
    Object localObject2 = new StringBuilder("setPlaySpeed: ratio = ").append(paramFloat).append(", mediaId = ");
    Object localObject1 = this.xqv;
    if (localObject1 != null)
    {
      localObject1 = ((t)localObject1).mediaId;
      localObject1 = ((StringBuilder)localObject2).append((String)localObject1).append(", feedId = ");
      localObject2 = this.xqv;
      if (localObject2 == null) {
        break label155;
      }
      localObject2 = ((t)localObject2).xzp;
      if (localObject2 == null) {
        break label155;
      }
    }
    label155:
    for (long l = ((FeedData)localObject2).getFeedId();; l = 0L)
    {
      Log.i(str, com.tencent.mm.ae.d.Fw(l));
      localObject1 = this.AMn;
      if (localObject1 == null) {
        p.bGy("player");
      }
      ((com.tencent.mm.plugin.thumbplayer.f.a)localObject1).setPlaySpeedRatio(paramFloat);
      this.AMG = paramFloat;
      AppMethodBeat.o(267501);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void setPlaySpeedRatio(float paramFloat)
  {
    this.AMG = paramFloat;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    this.wFf = paramBoolean;
  }
  
  public final void setScaleType(i.e parame)
  {
    AppMethodBeat.i(267483);
    p.k(parame, "scaleType");
    switch (j.$EnumSwitchMapping$0[parame.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(267483);
      return;
      parame = this.AMp;
      if (parame == null) {
        p.bGy("textureView");
      }
      MMThumbPlayerTextureView.a locala = MMThumbPlayerTextureView.MUw;
      parame.setScaleType(MMThumbPlayerTextureView.goY());
      AppMethodBeat.o(267483);
      return;
      parame = this.AMp;
      if (parame == null) {
        p.bGy("textureView");
      }
      locala = MMThumbPlayerTextureView.MUw;
      parame.setScaleType(MMThumbPlayerTextureView.goZ());
      AppMethodBeat.o(267483);
      return;
      parame = this.AMp;
      if (parame == null) {
        p.bGy("textureView");
      }
      locala = MMThumbPlayerTextureView.MUw;
      parame.setScaleType(MMThumbPlayerTextureView.gpb());
    }
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.ALk = paramBoolean;
  }
  
  public final void setStartCdn(boolean paramBoolean)
  {
    this.AMJ = paramBoolean;
  }
  
  public final void setStartCdnPreload(boolean paramBoolean)
  {
    this.AMK = paramBoolean;
  }
  
  public final void setVideoMuteListener(u paramu)
  {
    AppMethodBeat.i(267490);
    p.k(paramu, "muteListener");
    this.AMH = paramu;
    AppMethodBeat.o(267490);
  }
  
  public final void setVideoPlayLifecycle(z paramz)
  {
    AppMethodBeat.i(267489);
    p.k(paramz, "lifecycle");
    this.ALf = paramz;
    AppMethodBeat.o(267489);
  }
  
  public final void setVideoViewCallback(i.b paramb)
  {
    this.zxu = paramb;
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(267463);
    Log.i(TAG, "setVideoViewFocused " + paramBoolean + ' ' + eha());
    this.ALj = paramBoolean;
    AppMethodBeat.o(267463);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.ALj = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(267476);
    Log.i(TAG, "stop() " + eha());
    if (!Ru(this.currentPlayState))
    {
      Log.i(TAG, "stop() return for isStartPlay onPlayerStopListener:" + this.AMB + ". " + eha());
      localObject = this.AMB;
      if (localObject != null)
      {
        ((v)localObject).ehC();
        AppMethodBeat.o(267476);
        return;
      }
      AppMethodBeat.o(267476);
      return;
    }
    Object localObject = this.ALf;
    if (localObject != null) {
      ((z)localObject).a(this.xqv, this.xqC.ehR());
    }
    localObject = this.AMn;
    if (localObject == null) {
      p.bGy("player");
    }
    ((com.tencent.mm.plugin.thumbplayer.f.a)localObject).stop();
    localObject = this.AMn;
    if (localObject == null) {
      p.bGy("player");
    }
    ((com.tencent.mm.plugin.thumbplayer.f.a)localObject).reset();
    getFTPPLog().reset();
    localObject = this.AMp;
    if (localObject == null) {
      p.bGy("textureView");
    }
    ((MMThumbPlayerTextureView)localObject).reset();
    this.xqC.reset();
    ehf();
    ehd();
    ehe();
    this.AMu = true;
    this.AMr = false;
    setBgPrepareStatus(0);
    Log.i(TAG, "stop() end");
    AppMethodBeat.o(267476);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "Lplatform/android/ThumbPlayerAndroid/src/main/java/com/tencent/thumbplayer/datatransport/resourceloader/AbsTPAssetResourceLoader;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "mediaId", "", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "(Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "MAX_REQUEST_BUFFER", "", "MIN_CHECK_BUFFER", "REQUEST_INTERVAL", "REQUEST_PERIOD_MAX_MS", "REQUEST_PERIOD_MIN_MS", "isRequestingData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastOnReadDataEnd", "getLastOnReadDataEnd", "()J", "setLastOnReadDataEnd", "(J)V", "mediaCache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "getMediaCache", "()Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "setMediaCache", "(Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;)V", "getMediaId", "()Ljava/lang/String;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "requestNumber", "", "callback", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "createVideoPreloadCDNTask", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "getContentType", "fileId", "fileKey", "getDataFilePath", "getDataTotalSize", "notifyDataReady", "requestOffset", "requestLength", "onDataAvailable", "offset", "length", "onFinish", "ret", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "onPreloadCompleted", "onProgress", "total", "onReadData", "onStartReadData", "requestStart", "requestEnd", "onStopReadData", "requestId", "resetMediaCache", "toString", "updateMediaCache", "updateRequestingData", "value", "plugin-finder_release"})
  public final class b
    extends h.a.a.a.a.a.a.a.a.a.a.a
    implements g.a, g.b, h.a
  {
    final t ALh;
    private final long AMO;
    private final long AMP;
    private final long AMQ;
    private final long AMS;
    private final long AMT;
    private int AMU;
    private AtomicBoolean AMV;
    long AMW;
    public final String mediaId;
    av zvn;
    
    public b(t paramt)
    {
      AppMethodBeat.i(239684);
      this.mediaId = paramt;
      this.ALh = localObject;
      this.AMO = 30L;
      this.AMP = 1048576L;
      this.AMQ = 131072L;
      this.AMS = 10L;
      this.AMT = 50L;
      this.AMV = new AtomicBoolean(false);
      this$1 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
      this.zvn = com.tencent.mm.plugin.finder.storage.logic.d.bC(this.mediaId, true);
      boolean bool1 = com.tencent.mm.vfs.u.agG(this.zvn.getFilePath());
      boolean bool2 = com.tencent.mm.vfs.u.agG(this.ALh.path);
      this$1 = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "create ResourceLoaderProxy, cache:" + this.zvn + ' ' + "mediaCache path:" + this.zvn.getFilePath() + ", exists:" + bool1 + "mediaInfo path:" + this.ALh.path + ", exists:" + bool2);
      switch (this.zvn.field_state)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(239684);
        return;
        ehg();
        AppMethodBeat.o(239684);
        return;
        if (!bool2) {
          ehg();
        }
      }
    }
    
    private final void ehg()
    {
      AppMethodBeat.i(239617);
      Object localObject1 = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "resetMediaCache");
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
      String str2 = this.mediaId;
      Object localObject2 = this.ALh.xqx.dJw().mediaId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      String str1 = this.ALh.downloadUrl;
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = "";
      }
      com.tencent.mm.plugin.finder.storage.logic.d.a(str2, (String)localObject1, (String)localObject2, this.ALh.xqx.dJx(), this.ALh.xqx.dIX().detail, 0L, 0L, 1, this.ALh.xqx.dJw().videoDuration, "", "");
      ehh();
      AppMethodBeat.o(239617);
    }
    
    public final void Kj(String paramString)
    {
      AppMethodBeat.i(239619);
      p.k(paramString, "mediaId");
      AppMethodBeat.o(239619);
    }
    
    public final String Rv(int paramInt)
    {
      AppMethodBeat.i(239673);
      String str = com.tencent.mm.vfs.u.n(this.ALh.path, false);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "getDataFilePath(), dataFilePath:" + str + " isExists:" + com.tencent.mm.vfs.u.agG(str) + ' ' + "mediaInfoPath:" + this.ALh.path);
      AppMethodBeat.o(239673);
      return str;
    }
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      int i = 1;
      AppMethodBeat.i(239643);
      p.k(paramString, "mediaId");
      Object localObject = FinderThumbPlayerProxy.AMN;
      String str = FinderThumbPlayerProxy.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("callback() mediaId=").append(paramString).append(" startRet=").append(paramInt).append(" finishedLength=");
      if (paramc != null)
      {
        localObject = Long.valueOf(paramc.field_finishedLength);
        localObject = localStringBuilder.append(localObject).append(" fileFormat=");
        if (paramd == null) {
          break label210;
        }
        paramd = paramd.field_videoFlag;
        label97:
        Log.i(str, paramd + ' ' + this);
        if (paramc != null)
        {
          if ((paramInt != 0) || (paramc.field_finishedLength <= 0L)) {
            break label216;
          }
          paramInt = 1;
          label140:
          if (paramInt == 0) {
            break label221;
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
          paramd = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
          com.tencent.mm.plugin.finder.storage.logic.d.a(paramString, paramc.field_finishedLength, paramc.field_toltalLength, paramInt);
          ehh();
          paramc = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
          com.tencent.mm.plugin.finder.storage.logic.d.aET(paramString);
        }
        AppMethodBeat.o(239643);
        return 0;
        localObject = null;
        break;
        label210:
        paramd = null;
        break label97;
        label216:
        paramInt = 0;
        break label140;
        label221:
        paramc = null;
      }
    }
    
    public final void a(String paramString, final int paramInt, final com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(239638);
      p.k(paramString, "mediaId");
      p.k(paramd, "sceneResult");
      Object localObject = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "onFinish() mediaId=" + paramString + " ret=" + paramInt + " recvedBytes=" + paramd.field_recvedBytes + " fileLength=" + paramd.field_fileLength + "  finderformat:" + paramd.field_videoFormat);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramInt, paramd));
      if (paramInt != 0)
      {
        paramd = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        localObject = this.ALh.xqx.dJw().mediaId;
        paramd = (com.tencent.mm.i.d)localObject;
        if (localObject == null) {
          paramd = "";
        }
        String str = this.ALh.downloadUrl;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        com.tencent.mm.plugin.finder.storage.logic.d.a(paramString, paramd, (String)localObject, this.ALh.xqx.dJx(), this.ALh.xqx.dIX().detail, 0L, 0L, -1, this.ALh.xqx.dJw().videoDuration, "", "");
      }
      for (;;)
      {
        ehh();
        rd(false);
        AppMethodBeat.o(239638);
        return;
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        com.tencent.mm.plugin.finder.storage.logic.d.a(paramString, paramd.field_fileLength, paramd.field_fileLength, 3);
        paramd = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        com.tencent.mm.plugin.finder.storage.logic.d.aET(paramString);
      }
    }
    
    public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(239623);
      p.k(paramString1, "mediaId");
      Object localObject = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "onMoovReady() offset=" + paramLong1 + " length=" + paramLong2 + " svrflag=" + paramString2 + ' ' + this);
      localObject = FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this);
      if (localObject != null) {
        ((com.tencent.mm.plugin.findersdk.f.a)localObject).aGV("onMoovReady");
      }
      if (!this.zvn.field_moovReady) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        localObject = paramString2;
        if (paramString2 == null) {
          localObject = "";
        }
        com.tencent.mm.plugin.finder.storage.logic.d.hl(paramString1, (String)localObject);
        ehh();
        if ((!FinderThumbPlayerProxy.r(FinderThumbPlayerProxy.this)) && (!FinderThumbPlayerProxy.s(FinderThumbPlayerProxy.this)))
        {
          paramString2 = FinderThumbPlayerProxy.AMN;
          Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "onMoovReady() try to prepared");
          FinderThumbPlayerProxy.t(FinderThumbPlayerProxy.this);
        }
        paramString2 = FinderThumbPlayerProxy.this.getDownloadCallback();
        if (paramString2 != null) {
          paramString2.a((int)paramLong1, (int)paramLong2, this.ALh.xqx, bool);
        }
        paramString2 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        com.tencent.mm.plugin.finder.storage.logic.d.aET(paramString1);
        AppMethodBeat.o(239623);
        return;
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(239645);
      p.k(paramString, "mediaId");
      AppMethodBeat.o(239645);
    }
    
    public final void b(String paramString, com.tencent.mm.i.d paramd)
    {
      Object localObject1 = null;
      AppMethodBeat.i(239648);
      p.k(paramString, "mediaId");
      Object localObject2 = FinderThumbPlayerProxy.AMN;
      localObject2 = FinderThumbPlayerProxy.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("[onPreloadCompleted] mediaId=").append(paramString).append(" Ret=");
      if (paramd != null) {}
      for (paramString = Integer.valueOf(paramd.field_retCode);; paramString = null)
      {
        localStringBuilder = localStringBuilder.append(paramString).append(" finishedLength=");
        paramString = localObject1;
        if (paramd != null) {
          paramString = Long.valueOf(paramd.field_recvedBytes);
        }
        Log.i((String)localObject2, paramString + ' ' + this);
        FinderThumbPlayerProxy.u(FinderThumbPlayerProxy.this);
        AppMethodBeat.o(239648);
        return;
      }
    }
    
    public final void ehh()
    {
      AppMethodBeat.i(239651);
      com.tencent.mm.plugin.finder.storage.logic.d locald = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
      this.zvn = com.tencent.mm.plugin.finder.storage.logic.d.aEU(this.mediaId);
      AppMethodBeat.o(239651);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
    
    public final String getContentType(int paramInt, String paramString)
    {
      AppMethodBeat.i(239675);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "getContentType() fileId:" + paramInt + ", fileKey:" + paramString + " contentType:" + "video/mp4");
      AppMethodBeat.o(239675);
      return "video/mp4";
    }
    
    public final long getDataTotalSize(int paramInt, String paramString)
    {
      AppMethodBeat.i(239669);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "getDataTotalSize() fileId:" + paramInt + ", fileKey:" + paramString + " dataTotalSize:" + this.zvn.field_totalSize + ' ');
      long l = this.zvn.field_totalSize;
      AppMethodBeat.o(239669);
      return l;
    }
    
    public final void h(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(239630);
      p.k(paramString, "mediaId");
      Object localObject = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "onProgress() offset=" + paramLong1 + " total=" + paramLong2 + ' ' + this);
      localObject = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
      com.tencent.mm.plugin.finder.storage.logic.d.a(paramString, paramLong1, paramLong2, 1);
      ehh();
      localObject = FinderThumbPlayerProxy.this.getDownloadCallback();
      if (localObject != null) {
        ((y)localObject).a((int)paramLong1, (int)paramLong2, this.ALh.xqx);
      }
      localObject = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
      com.tencent.mm.plugin.finder.storage.logic.d.aET(paramString);
      AppMethodBeat.o(239630);
    }
    
    public final int n(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(239665);
      if (!FinderThumbPlayerProxy.v(FinderThumbPlayerProxy.this).get())
      {
        localObject1 = FinderThumbPlayerProxy.AMN;
        Log.w(FinderThumbPlayerProxy.access$getTAG$cp(), "notifyDataReady, return for downloader never start. requestOffset:" + paramLong1 + " requestLength:" + paramLong2 + ' ' + this);
        FinderThumbPlayerProxy.w(FinderThumbPlayerProxy.this).ehO();
      }
      Object localObject2;
      Object localObject3;
      for (paramLong1 = 0L;; paramLong1 = 0L)
      {
        paramInt = (int)paramLong1;
        AppMethodBeat.o(239665);
        return paramInt;
        if ((!FinderThumbPlayerProxy.x(FinderThumbPlayerProxy.this)) || (paramLong1 <= this.zvn.field_cacheSize)) {
          break;
        }
        localObject1 = FinderThumbPlayerProxy.y(FinderThumbPlayerProxy.this);
        localObject2 = FinderThumbPlayerProxy.AMN;
        localObject2 = FinderThumbPlayerProxy.access$getTAG$cp();
        localObject3 = "notifyDataReady() return for pause state. request[offset:" + paramLong1 + " length:" + paramLong2 + "] cacheSize:" + this.zvn.field_cacheSize + ' ' + this;
        paramLong1 = System.currentTimeMillis();
        if (paramLong1 - ((com.tencent.mm.plugin.finder.video.log.a)localObject1).APY > 5000L)
        {
          Log.w((String)localObject2, (String)localObject3);
          ((com.tencent.mm.plugin.finder.video.log.a)localObject1).APY = paramLong1;
        }
      }
      long l2 = 0L;
      long l1;
      if (this.zvn.dKN())
      {
        l1 = paramLong2;
        label239:
        if (l1 != 0L) {
          break label886;
        }
        if ((!this.zvn.field_moovReady) || (this.AMV.get())) {
          break label758;
        }
        if (paramLong2 >= this.AMP) {
          break label605;
        }
      }
      long l3;
      label605:
      for (l2 = paramLong2;; l2 = this.AMP)
      {
        l3 = l2;
        if (paramLong1 + l2 > this.zvn.field_totalSize)
        {
          l3 = this.zvn.field_totalSize - paramLong1;
          localObject1 = FinderThumbPlayerProxy.AMN;
          Log.w(FinderThumbPlayerProxy.access$getTAG$cp(), "notifyDataReady() requestLength is valid, requestOffset:" + paramLong1 + ", requestLength:" + l3 + ", totalSize:" + this.zvn.field_totalSize + ' ' + this);
        }
        localObject1 = ((PluginThumbPlayer)com.tencent.mm.kernel.h.ag(PluginThumbPlayer.class)).getCdnTaskController();
        localObject2 = this.mediaId;
        p.k(localObject2, "mediaId");
        if (((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).MPj.containsKey(localObject2)) {
          break label614;
        }
        paramLong1 = l1;
        break;
        localObject2 = new long[2];
        paramInt = CdnLogic.queryContinuousSize(this.mediaId, paramLong1, (long[])localObject2);
        if ((paramInt == 0) && (localObject2[0] != -1L))
        {
          if (localObject2[0] > paramLong2) {}
          for (l1 = paramLong2;; l1 = localObject2[0]) {
            break;
          }
        }
        localObject1 = FinderThumbPlayerProxy.y(FinderThumbPlayerProxy.this);
        localObject3 = FinderThumbPlayerProxy.AMN;
        localObject3 = FinderThumbPlayerProxy.access$getTAG$cp();
        localObject2 = "notifyDataReady() queryContinuousSize error, ret:" + paramInt + " requestOffset:" + paramLong1 + " continuousSize:" + localObject2[0] + " totalSize:" + localObject2[1] + ' ' + this;
        l3 = System.currentTimeMillis();
        l1 = l2;
        if (l3 - ((com.tencent.mm.plugin.finder.video.log.a)localObject1).APX <= 500L) {
          break label239;
        }
        Log.w((String)localObject3, (String)localObject2);
        ((com.tencent.mm.plugin.finder.video.log.a)localObject1).APX = l3;
        l1 = l2;
        break label239;
      }
      label614:
      paramInt = ((PluginThumbPlayer)com.tencent.mm.kernel.h.ag(PluginThumbPlayer.class)).getCdnTaskController().a(this.mediaId, (int)paramLong1, (int)l3, (com.tencent.mm.plugin.thumbplayer.b.c)new a(this));
      if (paramInt > 0) {
        rd(true);
      }
      Object localObject1 = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "notifyDataReady() requestVideoData requestOffset:" + paramLong1 + " requestLengthFix:" + l3 + " requestLength:" + paramLong2 + " requestDataRet:" + paramInt + "  cacheSize:" + this.zvn.field_cacheSize + ' ' + this);
      for (;;)
      {
        this.AMW = (paramLong1 + l1);
        paramLong1 = l1;
        break;
        label758:
        localObject1 = FinderThumbPlayerProxy.y(FinderThumbPlayerProxy.this);
        localObject2 = FinderThumbPlayerProxy.AMN;
        localObject2 = FinderThumbPlayerProxy.access$getTAG$cp();
        localObject3 = "notifyDataReady() returnLength:" + l1 + " fixRequest[offset:" + paramLong1 + " length:" + paramLong2 + "],  originRequest[offset:" + paramLong1 + " length:" + paramLong2 + "] " + this;
        paramLong2 = System.currentTimeMillis();
        if (paramLong2 - ((com.tencent.mm.plugin.finder.video.log.a)localObject1).APZ > 200L)
        {
          Log.w((String)localObject2, (String)localObject3);
          ((com.tencent.mm.plugin.finder.video.log.a)localObject1).APZ = paramLong2;
          continue;
          label886:
          localObject1 = FinderThumbPlayerProxy.AMN;
          Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "notifyDataReady() returnLength:" + l1 + " fixRequest[offset:" + paramLong1 + " length:" + paramLong2 + "], originRequest[offset:" + paramLong1 + " length:" + paramLong2 + "] " + this);
        }
      }
    }
    
    public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(239626);
      p.k(paramString, "mediaId");
      rd(false);
      paramString = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "onDataAvailable() offset=" + paramLong1 + " length=" + paramLong2 + ' ' + this + '}');
      AppMethodBeat.o(239626);
    }
    
    public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(239658);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "onStartReadData() fileId:" + paramInt + ", fileKey:" + paramString + ", requestStart:" + paramLong1 + ", requestEnd:" + paramLong2);
      paramString = FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this);
      if (paramString != null) {
        paramString.aGV("onStartRead");
      }
      paramInt = this.AMU;
      this.AMU = (paramInt + 1);
      AppMethodBeat.o(239658);
      return paramInt;
    }
    
    public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(239667);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "onStartReadData() fileId:" + paramInt1 + ", fileKey:" + paramString + ", requestId:" + paramInt2);
      paramInt1 = this.AMU;
      AppMethodBeat.o(239667);
      return paramInt1;
    }
    
    public final void rd(boolean paramBoolean)
    {
      AppMethodBeat.i(239654);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "updateRequestingData " + paramBoolean + ' ' + this);
      this.AMV.set(paramBoolean);
      AppMethodBeat.o(239654);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(239677);
      String str = FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this) + " isMoovReady:" + this.zvn.field_moovReady + " isRequestingData:" + this.AMV.get() + " isFinish:" + this.zvn.dKN() + " total:" + this.zvn.field_totalSize;
      AppMethodBeat.o(239677);
      return str;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy$notifyDataReady$requestDataRet$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "onRequest", "", "ret", "", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.plugin.thumbplayer.b.c
    {
      public final void Rw(int paramInt)
      {
        AppMethodBeat.i(281082);
        if (paramInt != 0)
        {
          FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.AMN;
          Log.w(FinderThumbPlayerProxy.access$getTAG$cp(), "requestedResource() requestVideoData fail, ret:" + paramInt + ' ' + this);
          this.AMY.rd(false);
        }
        AppMethodBeat.o(281082);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(FinderThumbPlayerProxy.b paramb, int paramInt, com.tencent.mm.i.d paramd)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$TPPlayerListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnPreparedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnVideoSizeChangedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnInfoListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnCompletionListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnErrorListener;", "(Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;)V", "onCompletion", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onError", "errorType", "", "errorCode", "arg1", "", "arg2", "onInfo", "what", "extraObject", "", "onPrepared", "onStateChange", "preState", "curState", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "surface", "onVideoSizeChanged", "plugin-finder_release"})
  public final class c
    implements TextureView.SurfaceTextureListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnVideoSizeChangedListener
  {
    public final void onCompletion(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(270804);
      paramITPPlayer = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onCompletion() " + FinderThumbPlayerProxy.a(this.AMX));
      AppMethodBeat.o(270804);
    }
    
    public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(270805);
      p.k(paramITPPlayer, "player");
      Object localObject1 = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onError() " + paramInt1 + ' ' + paramInt2 + " bgPrepareStatus:" + FinderThumbPlayerProxy.l(this.AMX) + ' ' + FinderThumbPlayerProxy.a(this.AMX));
      if (paramInt2 == 11030406)
      {
        t localt = FinderThumbPlayerProxy.k(this.AMX);
        if (localt != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
          String str2 = localt.mediaId;
          Object localObject2 = localt.xqx.dJw().mediaId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          String str1 = localt.downloadUrl;
          localObject2 = str1;
          if (str1 == null) {
            localObject2 = "";
          }
          com.tencent.mm.plugin.finder.storage.logic.d.a(str2, (String)localObject1, (String)localObject2, localt.xqx.dJx(), localt.xqx.dIX().detail, 0L, 0L, 1, localt.xqx.dJw().videoDuration, "", "");
          localObject1 = FinderThumbPlayerProxy.n(this.AMX);
          if (localObject1 != null) {
            ((FinderThumbPlayerProxy.b)localObject1).ehh();
          }
        }
      }
      if (FinderThumbPlayerProxy.l(this.AMX) != 0)
      {
        paramITPPlayer.reset();
        this.AMX.egw();
        AppMethodBeat.o(270805);
        return;
      }
      paramITPPlayer = FinderThumbPlayerProxy.k(this.AMX);
      if (paramITPPlayer != null)
      {
        localObject1 = this.AMX.getVideoViewCallback();
        if (localObject1 != null)
        {
          ((i.b)localObject1).c("", paramITPPlayer.mediaId, "", paramInt2, paramInt1);
          AppMethodBeat.o(270805);
          return;
        }
        AppMethodBeat.o(270805);
        return;
      }
      AppMethodBeat.o(270805);
    }
    
    public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      paramITPPlayer = null;
      Object localObject1 = null;
      StringBuilder localStringBuilder1 = null;
      StringBuilder localStringBuilder2 = null;
      AppMethodBeat.i(270802);
      Object localObject2 = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo() what:" + paramInt + " arg1:" + paramLong1 + " arg2:" + paramLong2 + " extraObject:" + paramObject + ' ' + FinderThumbPlayerProxy.a(this.AMX));
      switch (paramInt)
      {
      default: 
      case 200: 
      case 201: 
      case 150: 
      case 106: 
      case 105: 
      case 1006: 
        do
        {
          AppMethodBeat.o(270802);
          return;
          paramITPPlayer = FinderThumbPlayerProxy.AMN;
          Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo#onBufferingStart() pos:" + this.AMX.getCurrentPlayMs() + ' ' + FinderThumbPlayerProxy.a(this.AMX));
          paramObject = this.AMX;
          localObject1 = FinderThumbPlayerProxy.k(this.AMX);
          paramITPPlayer = localStringBuilder2;
          if (localObject1 != null) {
            paramITPPlayer = ((t)localObject1).mediaId;
          }
          FinderThumbPlayerProxy.a(paramObject, paramITPPlayer);
          AppMethodBeat.o(270802);
          return;
          paramITPPlayer = FinderThumbPlayerProxy.AMN;
          Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo#onBufferingEnd() pos:" + this.AMX.getCurrentPlayMs() + ' ' + FinderThumbPlayerProxy.a(this.AMX));
          FinderThumbPlayerProxy.o(this.AMX);
          AppMethodBeat.o(270802);
          return;
          paramITPPlayer = FinderThumbPlayerProxy.AMN;
          Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo#onReplay() " + FinderThumbPlayerProxy.a(this.AMX));
          paramITPPlayer = this.AMX.getLifecycle();
          if (paramITPPlayer != null)
          {
            FinderThumbPlayerProxy.k(this.AMX);
            paramITPPlayer.dJU();
            AppMethodBeat.o(270802);
            return;
          }
          AppMethodBeat.o(270802);
          return;
          paramObject = FinderThumbPlayerProxy.AMN;
          Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo#firstVideoFrameRendered " + FinderThumbPlayerProxy.a(this.AMX));
          paramObject = FinderThumbPlayerProxy.b(this.AMX);
          if (paramObject != null) {
            paramObject.fp("onRendered");
          }
          paramObject = FinderThumbPlayerProxy.j(this.AMX);
          localObject1 = FinderThumbPlayerProxy.b(this.AMX);
          if (localObject1 != null) {
            paramITPPlayer = ((com.tencent.mm.plugin.findersdk.f.a)localObject1).eoa();
          }
          paramObject.ASS = paramITPPlayer;
          paramITPPlayer = this.AMX.getLifecycle();
          if (paramITPPlayer != null)
          {
            FinderThumbPlayerProxy.k(this.AMX);
            paramITPPlayer.dJW();
            AppMethodBeat.o(270802);
            return;
          }
          AppMethodBeat.o(270802);
          return;
          paramITPPlayer = FinderThumbPlayerProxy.AMN;
          Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo#firstAudioFrameRendered " + FinderThumbPlayerProxy.a(this.AMX));
          AppMethodBeat.o(270802);
          return;
        } while (!(paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo));
        paramITPPlayer = FinderThumbPlayerProxy.AMN;
        Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo#downloadProgressUpdate: " + ((TPPlayerMsg.TPDownLoadProgressInfo)paramObject).playableDurationMS);
        AppMethodBeat.o(270802);
        return;
      case 204: 
        paramITPPlayer = FinderThumbPlayerProxy.AMN;
        paramObject = FinderThumbPlayerProxy.access$getTAG$cp();
        localStringBuilder1 = new StringBuilder("FTPP.onInfo#videoDecodeType:").append(paramLong1).append(' ');
        paramITPPlayer = FinderThumbPlayerProxy.k(this.AMX);
        if (paramITPPlayer != null) {}
        for (paramITPPlayer = paramITPPlayer.mediaId;; paramITPPlayer = null)
        {
          Log.i(paramObject, paramITPPlayer);
          paramObject = FinderThumbPlayerProxy.k(this.AMX);
          paramITPPlayer = (ITPPlayer)localObject1;
          if (paramObject != null)
          {
            paramObject = paramObject.APg;
            paramITPPlayer = (ITPPlayer)localObject1;
            if (paramObject != null) {
              paramITPPlayer = paramObject.TAf;
            }
          }
          if (paramITPPlayer == null)
          {
            paramITPPlayer = FinderThumbPlayerProxy.k(this.AMX);
            if (paramITPPlayer != null)
            {
              paramITPPlayer = paramITPPlayer.APg;
              if (paramITPPlayer != null) {
                paramITPPlayer.TAf = new FinderMediaReportObject();
              }
            }
          }
          paramITPPlayer = FinderThumbPlayerProxy.k(this.AMX);
          if (paramITPPlayer == null) {
            break;
          }
          paramITPPlayer = paramITPPlayer.APg;
          if (paramITPPlayer == null) {
            break;
          }
          paramITPPlayer = paramITPPlayer.TAf;
          if (paramITPPlayer == null) {
            break;
          }
          paramITPPlayer.playDecoderType = ((int)paramLong1);
          AppMethodBeat.o(270802);
          return;
        }
        AppMethodBeat.o(270802);
        return;
      }
      paramITPPlayer = FinderThumbPlayerProxy.AMN;
      localObject1 = FinderThumbPlayerProxy.access$getTAG$cp();
      localStringBuilder2 = new StringBuilder("FTPP.onInfo#mediaCodecInfo:").append(paramLong1).append(' ');
      localObject2 = FinderThumbPlayerProxy.k(this.AMX);
      paramITPPlayer = localStringBuilder1;
      if (localObject2 != null) {
        paramITPPlayer = ((t)localObject2).mediaId;
      }
      Log.i((String)localObject1, paramITPPlayer);
      if (!(paramObject instanceof TPPlayerMsg.TPMediaCodecInfo))
      {
        paramITPPlayer = FinderThumbPlayerProxy.AMN;
        Log.w(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo#mediaCodecInfo return for not codecInfo");
        AppMethodBeat.o(270802);
        return;
      }
      if (((TPPlayerMsg.TPMediaCodecInfo)paramObject).mediaType != TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO)
      {
        paramITPPlayer = FinderThumbPlayerProxy.AMN;
        Log.w(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo#mediaCodecInfo return for not video type");
        AppMethodBeat.o(270802);
        return;
      }
      if (((TPPlayerMsg.TPMediaCodecInfo)paramObject).infoType == TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY) {}
      for (;;)
      {
        try
        {
          paramITPPlayer = new com.tencent.mm.ad.i(((TPPlayerMsg.TPMediaCodecInfo)paramObject).msg);
          paramObject = FinderThumbPlayerProxy.p(this.AMX);
          if (paramObject != null)
          {
            if (!paramITPPlayer.optBoolean("reuseEnable")) {
              continue;
            }
            paramInt = 1;
            paramObject.Ry(paramInt);
          }
          paramObject = FinderThumbPlayerProxy.p(this.AMX);
          if (paramObject != null)
          {
            if (!paramITPPlayer.optBoolean("isReuse")) {
              continue;
            }
            paramInt = 1;
            paramObject.Rz(paramInt);
          }
          paramObject = FinderThumbPlayerProxy.p(this.AMX);
          if (paramObject != null) {
            paramObject.RA(paramITPPlayer.optInt("totalCodec"));
          }
        }
        catch (Throwable paramITPPlayer)
        {
          continue;
        }
        paramITPPlayer = this.AMX.getLifecycle();
        if (paramITPPlayer == null) {
          break;
        }
        FinderThumbPlayerProxy.k(this.AMX);
        paramITPPlayer.a(FinderThumbPlayerProxy.p(this.AMX));
        AppMethodBeat.o(270802);
        return;
        paramInt = -1;
        continue;
        paramInt = -1;
        continue;
        if (((TPPlayerMsg.TPMediaCodecInfo)paramObject).infoType == TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_EXCEPTION) {
          try
          {
            paramITPPlayer = new com.tencent.mm.ad.i(((TPPlayerMsg.TPMediaCodecInfo)paramObject).msg);
            paramObject = FinderThumbPlayerProxy.p(this.AMX);
            if (paramObject != null) {
              paramObject.aGu(paramITPPlayer.optString("errorCodec"));
            }
          }
          catch (Throwable paramITPPlayer) {}
        }
      }
    }
    
    public final void onPrepared(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(270799);
      p.k(paramITPPlayer, "player");
      Object localObject = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.OnPrepared() " + FinderThumbPlayerProxy.a(this.AMX));
      localObject = FinderThumbPlayerProxy.b(this.AMX);
      if (localObject != null) {
        ((com.tencent.mm.plugin.findersdk.f.a)localObject).aGV("onPrepared");
      }
      i.b localb = this.AMX.getVideoViewCallback();
      if (localb != null)
      {
        localObject = FinderThumbPlayerProxy.k(this.AMX);
        if (localObject != null)
        {
          localObject = ((t)localObject).mediaId;
          localb.dS("", (String)localObject);
        }
      }
      else
      {
        if (!this.AMX.ALj) {
          break label215;
        }
        this.AMX.Rs(2);
      }
      for (;;)
      {
        localObject = FinderThumbPlayerProxy.n(this.AMX);
        if (localObject == null) {
          break label239;
        }
        localObject = ((FinderThumbPlayerProxy.b)localObject).zvn;
        if (localObject == null) {
          break label239;
        }
        ((av)localObject).field_audioBitrate = ((int)paramITPPlayer.getPropertyLong(101));
        ((av)localObject).field_videoBitrate = ((int)paramITPPlayer.getPropertyLong(202));
        ((av)localObject).field_frameRate = ((int)paramITPPlayer.getPropertyLong(206));
        paramITPPlayer = FinderThumbPlayerProxy.j(this.AMX);
        if (paramITPPlayer == null) {
          break label232;
        }
        paramITPPlayer.videoFps = ((av)localObject).field_frameRate;
        AppMethodBeat.o(270799);
        return;
        localObject = null;
        break;
        label215:
        FinderThumbPlayerProxy.b(this.AMX, 1);
        paramITPPlayer.pauseDownload();
      }
      label232:
      AppMethodBeat.o(270799);
      return;
      label239:
      AppMethodBeat.o(270799);
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      i.b localb = null;
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(270803);
      Object localObject3 = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onStateChange() preState:" + paramInt1 + " curState:" + paramInt2 + ' ' + FinderThumbPlayerProxy.a(this.AMX));
      FinderThumbPlayerProxy.c(this.AMX, paramInt2);
      FinderThumbPlayerProxy.j(this.AMX).ASE = paramInt2;
      if (FinderThumbPlayerProxy.k(this.AMX) == null)
      {
        localObject1 = FinderThumbPlayerProxy.AMN;
        Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onStateChange() return for null");
        AppMethodBeat.o(270803);
        return;
      }
      switch (paramInt2)
      {
      }
      while ((paramInt2 == 9) || (paramInt2 == 1))
      {
        localObject1 = FinderThumbPlayerProxy.AMN;
        Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onStateChange() player stop or idle " + FinderThumbPlayerProxy.a(this.AMX));
        localObject1 = this.AMX.getOnPlayerStopListener();
        if (localObject1 == null) {
          break;
        }
        ((v)localObject1).ehC();
        AppMethodBeat.o(270803);
        return;
        localb = this.AMX.getVideoViewCallback();
        if (localb != null)
        {
          localObject2 = FinderThumbPlayerProxy.k(this.AMX);
          if (localObject2 != null) {
            localObject1 = ((t)localObject2).mediaId;
          }
          localb.dV("", (String)localObject1);
        }
        localObject1 = this.AMX.getLifecycle();
        if (localObject1 != null)
        {
          FinderThumbPlayerProxy.k(this.AMX);
          ((z)localObject1).dJV();
        }
        localObject1 = FinderThumbPlayerProxy.k(this.AMX);
        if (localObject1 != null)
        {
          FinderThumbPlayerProxy.a(this.AMX, (t)localObject1);
          continue;
          localObject2 = this.AMX.getVideoViewCallback();
          if (localObject2 != null)
          {
            localObject3 = FinderThumbPlayerProxy.k(this.AMX);
            localObject1 = localb;
            if (localObject3 != null) {
              localObject1 = ((t)localObject3).mediaId;
            }
            ((i.b)localObject2).dU("", (String)localObject1);
          }
          localObject1 = this.AMX.getLifecycle();
          if (localObject1 != null)
          {
            FinderThumbPlayerProxy.k(this.AMX);
            ((z)localObject1).a(FinderThumbPlayerProxy.j(this.AMX).ehR());
          }
          FinderThumbPlayerProxy.q(this.AMX);
          continue;
          localb = this.AMX.getVideoViewCallback();
          if (localb != null)
          {
            localObject3 = FinderThumbPlayerProxy.k(this.AMX);
            localObject1 = localObject2;
            if (localObject3 != null) {
              localObject1 = ((t)localObject3).mediaId;
            }
            localb.dT("", (String)localObject1);
          }
        }
      }
      AppMethodBeat.o(270803);
    }
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Object localObject1 = null;
      AppMethodBeat.i(270795);
      p.k(paramSurfaceTexture, "surfaceTexture");
      Object localObject2 = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onSurfaceTextureAvailable() width:" + paramInt1 + " height:" + paramInt2 + " surfaceTexture:" + paramSurfaceTexture.hashCode() + ' ' + FinderThumbPlayerProxy.a(this.AMX));
      localObject2 = FinderThumbPlayerProxy.b(this.AMX);
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.findersdk.f.a)localObject2).aGV("onSurfaceAva");
      }
      if (FinderThumbPlayerProxy.c(this.AMX) != null)
      {
        paramSurfaceTexture = FinderThumbPlayerProxy.AMN;
        localObject2 = FinderThumbPlayerProxy.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("FTPP.onSurfaceTextureAvailable() return for surface:");
        paramSurfaceTexture = FinderThumbPlayerProxy.c(this.AMX);
        if (paramSurfaceTexture != null) {}
        for (paramSurfaceTexture = Integer.valueOf(paramSurfaceTexture.hashCode());; paramSurfaceTexture = null)
        {
          localStringBuilder = localStringBuilder.append(paramSurfaceTexture).append(" valid:");
          Surface localSurface = FinderThumbPlayerProxy.c(this.AMX);
          paramSurfaceTexture = localObject1;
          if (localSurface != null) {
            paramSurfaceTexture = Boolean.valueOf(localSurface.isValid());
          }
          Log.i((String)localObject2, paramSurfaceTexture + " isReusing:" + FinderThumbPlayerProxy.d(this.AMX));
          if (FinderThumbPlayerProxy.d(this.AMX)) {
            FinderThumbPlayerProxy.e(this.AMX).setSurfaceTexture(FinderThumbPlayerProxy.f(this.AMX));
          }
          AppMethodBeat.o(270795);
          return;
        }
      }
      FinderThumbPlayerProxy.a(this.AMX, paramSurfaceTexture);
      FinderThumbPlayerProxy.a(this.AMX, new Surface(paramSurfaceTexture));
      FinderThumbPlayerProxy.g(this.AMX).setSurface(FinderThumbPlayerProxy.c(this.AMX));
      this.AMX.Rs(1);
      AppMethodBeat.o(270795);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(270797);
      Object localObject = FinderThumbPlayerProxy.AMN;
      localObject = FinderThumbPlayerProxy.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("FTPP.onSurfaceTextureDestroyed() surfaceTexture:");
      if (paramSurfaceTexture != null) {}
      for (int i = paramSurfaceTexture.hashCode();; i = 0)
      {
        Log.i((String)localObject, i + ' ' + FinderThumbPlayerProxy.a(this.AMX));
        FinderThumbPlayerProxy.h(this.AMX);
        AppMethodBeat.o(270797);
        return false;
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(270796);
      Object localObject = FinderThumbPlayerProxy.AMN;
      localObject = FinderThumbPlayerProxy.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("FTPP.onSurfaceTextureSizeChanged  surfaceTexture:");
      if (paramSurfaceTexture != null) {}
      for (int i = paramSurfaceTexture.hashCode();; i = 0)
      {
        Log.i((String)localObject, i + ' ' + paramInt1 + ' ' + paramInt2 + ' ' + FinderThumbPlayerProxy.a(this.AMX));
        AppMethodBeat.o(270796);
        return;
      }
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(270798);
      paramSurfaceTexture = this.AMX;
      FinderThumbPlayerProxy.a(paramSurfaceTexture, FinderThumbPlayerProxy.i(paramSurfaceTexture) + 1);
      paramSurfaceTexture = FinderThumbPlayerProxy.j(this.AMX);
      paramSurfaceTexture.ASC += 1;
      if (FinderThumbPlayerProxy.k(this.AMX) == null)
      {
        paramSurfaceTexture = FinderThumbPlayerProxy.AMN;
        Log.w(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onSurfaceTextureUpdated() return for  null.");
        AppMethodBeat.o(270798);
        return;
      }
      z localz;
      if ((FinderThumbPlayerProxy.i(this.AMX) == 1) && (FinderThumbPlayerProxy.l(this.AMX) == 1))
      {
        paramSurfaceTexture = FinderThumbPlayerProxy.AMN;
        Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onSurfaceTextureUpdated() background prepared first frame " + FinderThumbPlayerProxy.a(this.AMX));
        FinderThumbPlayerProxy.b(this.AMX, 2);
        localz = this.AMX.getLifecycle();
        if (localz != null)
        {
          paramSurfaceTexture = FinderThumbPlayerProxy.k(this.AMX);
          if (paramSurfaceTexture == null) {
            break label274;
          }
        }
      }
      label274:
      for (paramSurfaceTexture = paramSurfaceTexture.APg;; paramSurfaceTexture = null)
      {
        localz.a(paramSurfaceTexture);
        if ((FinderThumbPlayerProxy.i(this.AMX) == 1) && (FinderThumbPlayerProxy.l(this.AMX) == 0))
        {
          paramSurfaceTexture = FinderThumbPlayerProxy.AMN;
          Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onSurfaceTextureUpdated() onFirstFrameRendered " + FinderThumbPlayerProxy.a(this.AMX));
          paramSurfaceTexture = this.AMX.getLifecycle();
          if (paramSurfaceTexture != null)
          {
            FinderThumbPlayerProxy.k(this.AMX);
            paramSurfaceTexture.Ma(FinderThumbPlayerProxy.g(this.AMX).goq());
          }
          FinderThumbPlayerProxy.m(this.AMX);
        }
        AppMethodBeat.o(270798);
        return;
      }
    }
    
    public final void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(270800);
      paramITPPlayer = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.OnVideoSizeChanged() width:" + paramLong1 + " height:" + paramLong2 + ' ' + FinderThumbPlayerProxy.a(this.AMX));
      FinderThumbPlayerProxy.e(this.AMX).kw((int)paramLong1, (int)paramLong2);
      AppMethodBeat.o(270800);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderThumbPlayerProxy paramFinderThumbPlayerProxy, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(274216);
      if (this.AMX.ALj)
      {
        FinderThumbPlayerProxy.A(this.AMX);
        i.b localb = this.AMX.getVideoViewCallback();
        if (localb != null)
        {
          localb.dW("", this.uzc);
          AppMethodBeat.o(274216);
          return;
        }
      }
      AppMethodBeat.o(274216);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnDownload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
  public static final class h
    implements com.tencent.mm.plugin.thumbplayer.b.e
  {
    h(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void OT(int paramInt)
    {
      AppMethodBeat.i(277179);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "startCdnDownload()#onStart " + FinderThumbPlayerProxy.a(this.AMX) + ' ' + paramInt);
      FinderThumbPlayerProxy.z(this.AMX);
      AppMethodBeat.o(277179);
    }
    
    public final void a(int paramInt, com.tencent.mm.i.h paramh) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.plugin.thumbplayer.b.b
  {
    i(FinderThumbPlayerProxy.b paramb) {}
    
    public final com.tencent.mm.i.h aGj(String paramString)
    {
      boolean bool = true;
      AppMethodBeat.i(222568);
      p.k(paramString, "id");
      Object localObject4 = this.ANb;
      paramString = aj.AGc;
      String str1 = ((FinderThumbPlayerProxy.b)localObject4).mediaId;
      Object localObject1 = ((FinderThumbPlayerProxy.b)localObject4).ALh.downloadUrl;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      String str2 = ((FinderThumbPlayerProxy.b)localObject4).ALh.path;
      localObject1 = ((FinderThumbPlayerProxy.b)localObject4).ALh;
      int i;
      Object localObject2;
      String str3;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject1 = ((t)localObject1).path;
        i = com.tencent.mm.modelcontrol.e.N(1, (String)localObject1);
        localObject2 = ((FinderThumbPlayerProxy.b)localObject4).zvn.field_fileFormat;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        str3 = ((FinderThumbPlayerProxy.b)localObject4).ALh.xqx.dIZ();
        localObject3 = ((FinderThumbPlayerProxy.b)localObject4).ALh.xqx.dJw().decodeKey;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        if (((FinderThumbPlayerProxy.b)localObject4).ALh.xqx.dJw().hot_flag != 1) {
          break label223;
        }
      }
      for (;;)
      {
        localObject3 = (h.a)localObject4;
        localObject4 = FinderThumbPlayerProxy.AMN;
        paramString = aj.a(str1, paramString, str2, i, (String)localObject1, str3, (String)localObject2, bool, (h.a)localObject3, FinderThumbPlayerProxy.access$getTAG$cp());
        AppMethodBeat.o(222568);
        return paramString;
        localObject1 = null;
        break;
        label223:
        bool = false;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnPreload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.plugin.thumbplayer.b.d
  {
    j(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void OT(int paramInt)
    {
      AppMethodBeat.i(279699);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "startCdnPreload()#onStart(), real start download preload task " + FinderThumbPlayerProxy.a(this.AMX) + ' ' + paramInt);
      if (paramInt == -1) {
        FinderThumbPlayerProxy.u(this.AMX);
      }
      AppMethodBeat.o(279699);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnPreload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-finder_release"})
  public static final class k
    implements com.tencent.mm.plugin.thumbplayer.b.b
  {
    k(FinderThumbPlayerProxy.b paramb) {}
    
    public final com.tencent.mm.i.h aGj(String paramString)
    {
      AppMethodBeat.i(289286);
      p.k(paramString, "id");
      Object localObject4 = this.ANc;
      long l = ((FinderThumbPlayerProxy.b)localObject4).zvn.field_totalSize;
      if (l == 0L)
      {
        AppMethodBeat.o(289286);
        return null;
      }
      paramString = aj.AGc;
      String str1 = ((FinderThumbPlayerProxy.b)localObject4).mediaId;
      Object localObject1 = ((FinderThumbPlayerProxy.b)localObject4).ALh.downloadUrl;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      String str2 = ((FinderThumbPlayerProxy.b)localObject4).ALh.path;
      localObject1 = ((FinderThumbPlayerProxy.b)localObject4).ALh;
      int i;
      Object localObject2;
      String str3;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject1 = ((t)localObject1).path;
        i = com.tencent.mm.modelcontrol.e.N(1, (String)localObject1);
        localObject2 = ((FinderThumbPlayerProxy.b)localObject4).zvn.field_fileFormat;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        str3 = ((FinderThumbPlayerProxy.b)localObject4).ALh.xqx.dIZ();
        localObject3 = ((FinderThumbPlayerProxy.b)localObject4).ALh.xqx.dJw().decodeKey;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        if (((FinderThumbPlayerProxy.b)localObject4).ALh.xqx.dJw().hot_flag != 1) {
          break label282;
        }
      }
      label282:
      for (boolean bool = true;; bool = false)
      {
        localObject3 = (g.a)localObject4;
        g.b localb = (g.b)localObject4;
        int j = (int)(((FinderThumbPlayerProxy.b)localObject4).AMW * 100L / l);
        l = ((FinderThumbPlayerProxy.b)localObject4).AMW;
        localObject4 = FinderThumbPlayerProxy.AMN;
        paramString = aj.a(str1, paramString, str2, i, (String)localObject1, str3, (String)localObject2, bool, (g.a)localObject3, localb, j, l, FinderThumbPlayerProxy.access$getTAG$cp());
        AppMethodBeat.o(289286);
        return paramString;
        localObject1 = null;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startProgressTimer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "lastNotifyMs", "", "getLastNotifyMs", "()J", "setLastNotifyMs", "(J)V", "lastPlayPositionMs", "getLastPlayPositionMs", "setLastPlayPositionMs", "onTimerExpired", "", "plugin-finder_release"})
  public static final class l
    implements MTimerHandler.CallBack
  {
    private long ANd = -1L;
    private long ANe = -1L;
    
    l(t paramt) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(222011);
      long l1 = this.AMX.getCurrentPlayMs();
      long l2 = this.AMX.getVideoDurationMs();
      if (this.ANe != l1)
      {
        localObject = this.AMX.getLifecycle();
        if (localObject != null) {
          ((z)localObject).U(l1, l2);
        }
        if ((this.ANd == -1L) || (l1 - this.ANd > 1000L) || (l1 < this.ANd))
        {
          localObject = this.AMX.getLifecycle();
          if (localObject != null) {
            ((z)localObject).a(paramt.APg, (int)l1 / 1000, (int)l2 / 1000);
          }
          this.ANd = l1;
        }
        this.ANe = l1;
      }
      Object localObject = FinderThumbPlayerProxy.j(this.AMX);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASJ = l2;
        if (l1 - ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASI > 1000L)
        {
          ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASQ.add(Integer.valueOf((int)(l1 / 1000L)));
          int i = ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASC - ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASK;
          ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASR.add(Integer.valueOf(i));
          if ((i < ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASO) || (((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASO == -1)) {
            ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASO = i;
          }
          if ((i > ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASN) || (((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASN == -1)) {
            ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASN = i;
          }
          if (((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASL == -1) {
            ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASL = i;
          }
          ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASM = i;
          if (i < ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).videoFps) {
            ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASP += 1;
          }
          ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASK = ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASC;
          ((com.tencent.mm.plugin.finder.video.reporter.e)localObject).ASI = l1;
        }
      }
      AppMethodBeat.o(222011);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$stopCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "onStop", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-finder_release"})
  public static final class m
    implements com.tencent.mm.plugin.thumbplayer.b.g
  {
    m(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void a(int paramInt, com.tencent.mm.i.h paramh, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(290117);
      t localt = FinderThumbPlayerProxy.k(this.AMX);
      if (localt != null)
      {
        y localy = this.AMX.getDownloadCallback();
        if (localy != null) {
          localy.a(localt.xqx, paramh, paramd);
        }
      }
      paramh = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "stopCdnDownload()#onStop(), real cancel download task " + FinderThumbPlayerProxy.a(this.AMX) + ' ' + paramInt);
      AppMethodBeat.o(290117);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$stopCdnPreload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "onStop", "", "ret", "", "plugin-finder_release"})
  public static final class n
    implements com.tencent.mm.plugin.thumbplayer.b.f
  {
    n(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void OS(int paramInt)
    {
      AppMethodBeat.i(289463);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.AMN;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "stopCdnPreload()#onStop " + FinderThumbPlayerProxy.a(this.AMX) + ' ' + paramInt);
      AppMethodBeat.o(289463);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$stopProgressTimer$1$1"})
  static final class o
    extends q
    implements kotlin.g.a.a<x>
  {
    o(t paramt, long paramLong1, long paramLong2, FinderThumbPlayerProxy paramFinderThumbPlayerProxy)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy
 * JD-Core Version:    0.7.0.1
 */