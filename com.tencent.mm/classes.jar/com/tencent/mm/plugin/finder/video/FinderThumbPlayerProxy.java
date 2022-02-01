package com.tencent.mm.plugin.finder.video;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Looper;
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
import com.tencent.mm.ab.i;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.data.j;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.a.e;
import com.tencent.mm.plugin.thumbplayer.e.d.a;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
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
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgPrepareStatus", "currentPlayState", "downloadCallback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "getDownloadCallback", "()Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "setDownloadCallback", "(Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;)V", "enableMediaCodecReuse", "", "fTPPKVReporter", "Lcom/tencent/mm/plugin/finder/video/reporter/FTPPKVReporter;", "getFTPPKVReporter", "()Lcom/tencent/mm/plugin/finder/video/reporter/FTPPKVReporter;", "fTPPKVReporter$delegate", "Lkotlin/Lazy;", "fTPPLog", "Lcom/tencent/mm/plugin/finder/video/log/FTPPLog;", "getFTPPLog", "()Lcom/tencent/mm/plugin/finder/video/log/FTPPLog;", "fTPPLog$delegate", "isBuffering", "isFirstFrameRendered", "isFirstStart", "isFullScreen", "()Z", "setFullScreen", "(Z)V", "isLongVideo", "isOpenFlowControl", "isPreviewing", "isRealStartDownloader", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isShouldPlayResume", "setShouldPlayResume", "isStartCdn", "setStartCdn", "isStartCdnPreload", "setStartCdnPreload", "isViewFocused", "setViewFocused", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaPreloadCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "getMediaPreloadCore$plugin_finder_release", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "setMediaPreloadCore$plugin_finder_release", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "notifyProgressTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onBufferingStartRunnable", "Ljava/lang/Runnable;", "onMuteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getOnMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setOnMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "onPlayerStopListener", "Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;", "getOnPlayerStopListener", "()Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;", "setOnPlayerStopListener", "(Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;)V", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "playerListener", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$TPPlayerListener;", "resourceLoaderProxy", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "surface", "Landroid/view/Surface;", "textureUpdateTimes", "textureView", "Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "videoViewCallback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "getVideoViewCallback", "()Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setVideoViewCallback", "(Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;)V", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrentPlayMs", "", "getCurrentPlaySecond", "getFTPPTag", "", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoDurationMs", "getVideoMediaId", "", "getVideoMediaInfo", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "handleOnBufferingEnd", "handleOnBufferingStart", "mediaId", "init", "initFTPPTag", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "initTextureView", "mediaInfo", "isPause", "isPlaying", "isPrepared", "isPreparing", "isStartPlay", "currentState", "onRelease", "onUIDestroy", "pause", "pauseWithCancel", "play", "playInfo", "playWithSource", "source", "prepareCacheFile", "filePath", "invokeSource", "prepareOnlineUrl", "url", "prepareToPlay", "prepareVideo", "realPlay", "releaseSurface", "detach", "removeVideoFooterView", "resizeTextureView", "width", "height", "seekTo", "timestamp", "", "afterSeekPlay", "setBgPrepareStatus", "status", "setFinderVideoCore", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setIMMVideoViewCallback", "_callback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setLoop", "loop", "setMute", "isMute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocal", "feedData", "setVideoMuteListener", "muteListener", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "startCdnDownload", "startCdnPreload", "startOrPlay", "startProgressTimer", "info", "stop", "stopCdnDownload", "stopCdnPreload", "stopProgressTimer", "updateIsRealStartDownloader", "isRealStart", "Companion", "ResourceLoaderProxy", "TPPlayerListener", "plugin-finder_release"})
public final class FinderThumbPlayerProxy
  extends FrameLayout
  implements r
{
  private static String TAG;
  private static final HashSet<Integer> wdW;
  public static final a wdX;
  private boolean bbU;
  private volatile int currentPlayState;
  private MMHandler hAk;
  private boolean isLongVideo;
  private boolean onr;
  private boolean sZd;
  private Surface surface;
  private s tHL;
  private com.tencent.mm.plugin.finder.video.reporter.c tHS;
  boolean wcA;
  private boolean wcB;
  private i.b wcv;
  private y wcw;
  private boolean wdB;
  private com.tencent.mm.plugin.thumbplayer.e.a wdC;
  private c wdD;
  public MMThumbPlayerTextureView wdE;
  private volatile boolean wdF;
  private MediaPreloadCore wdG;
  private b wdH;
  private boolean wdI;
  private int wdJ;
  private final kotlin.f wdK;
  private final kotlin.f wdL;
  private MTimerHandler wdM;
  private Runnable wdN;
  private int wdO;
  private u wdP;
  private AtomicBoolean wdQ;
  private boolean wdR;
  private t wdS;
  private x wdT;
  private boolean wdU;
  private boolean wdV;
  
  static
  {
    AppMethodBeat.i(254193);
    wdX = new a((byte)0);
    TAG = "Finder.FinderThumbPlayerProxy";
    wdW = new HashSet();
    AppMethodBeat.o(254193);
  }
  
  public FinderThumbPlayerProxy(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(254190);
    paramContext = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dvT().value()).intValue() == 1)
    {
      paramContext = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (!com.tencent.mm.plugin.finder.storage.c.drB()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.wdB = bool;
      this.wdI = true;
      this.wdK = kotlin.g.ah((kotlin.g.a.a)d.wei);
      this.wdL = kotlin.g.ah((kotlin.g.a.a)e.wej);
      this.hAk = new MMHandler(Looper.getMainLooper());
      this.wdQ = new AtomicBoolean(true);
      init();
      AppMethodBeat.o(254190);
      return;
    }
  }
  
  public FinderThumbPlayerProxy(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254191);
    paramContext = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dvT().value()).intValue() == 1)
    {
      paramContext = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (!com.tencent.mm.plugin.finder.storage.c.drB()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.wdB = bool;
      this.wdI = true;
      this.wdK = kotlin.g.ah((kotlin.g.a.a)d.wei);
      this.wdL = kotlin.g.ah((kotlin.g.a.a)e.wej);
      this.hAk = new MMHandler(Looper.getMainLooper());
      this.wdQ = new AtomicBoolean(true);
      init();
      AppMethodBeat.o(254191);
      return;
    }
  }
  
  public FinderThumbPlayerProxy(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254192);
    paramContext = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dvT().value()).intValue() == 1)
    {
      paramContext = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (!com.tencent.mm.plugin.finder.storage.c.drB()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.wdB = bool;
      this.wdI = true;
      this.wdK = kotlin.g.ah((kotlin.g.a.a)d.wei);
      this.wdL = kotlin.g.ah((kotlin.g.a.a)e.wej);
      this.hAk = new MMHandler(Looper.getMainLooper());
      this.wdQ = new AtomicBoolean(true);
      init();
      AppMethodBeat.o(254192);
      return;
    }
  }
  
  private final boolean Md(int paramInt)
  {
    com.tencent.mm.plugin.thumbplayer.e.a locala = null;
    AppMethodBeat.i(254165);
    Object localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder("prepareVideo() source:").append(paramInt).append(" isMoovReady:");
    Object localObject1 = this.wdH;
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).uJG;
      if (localObject1 != null)
      {
        localObject1 = Boolean.valueOf(((at)localObject1).field_moovReady);
        localStringBuilder = localStringBuilder.append(localObject1).append(' ').append("isAllCompleted:");
        localObject1 = this.wdH;
        if (localObject1 == null) {
          break label369;
        }
        localObject1 = ((b)localObject1).uJG;
        if (localObject1 == null) {
          break label369;
        }
        localObject1 = Boolean.valueOf(((at)localObject1).dkN());
        label106:
        localStringBuilder = localStringBuilder.append(localObject1).append(' ').append("downloadUrl:");
        localObject1 = this.tHL;
        if (localObject1 == null) {
          break label374;
        }
      }
    }
    label369:
    label374:
    for (localObject1 = ((s)localObject1).downloadUrl;; localObject1 = null)
    {
      Log.i((String)localObject2, (String)localObject1 + ' ' + dFm());
      localObject1 = this.wdH;
      if (localObject1 != null) {
        ((b)localObject1).dFt();
      }
      localObject1 = this.wdH;
      if (localObject1 == null) {
        break label379;
      }
      localObject1 = ((b)localObject1).uJG;
      if ((localObject1 == null) || ((!((at)localObject1).field_moovReady) && (!((at)localObject1).dkN()) && (!(this.tHL instanceof com.tencent.mm.plugin.finder.video.source.a)))) {
        break label379;
      }
      localObject1 = this.wdC;
      if (localObject1 == null) {
        p.btv("player");
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setPlayerOptionalParam(new TPOptionalParam().buildBoolean(123, this.wdB));
      localObject1 = this.wdC;
      if (localObject1 == null) {
        p.btv("player");
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).enableTPAssetResourceLoader((com.tencent.thumbplayer.e.a.a)this.wdH);
      localObject2 = this.surface;
      if (localObject2 != null)
      {
        localObject1 = locala;
        if (((Surface)localObject2).isValid()) {
          localObject1 = localObject2;
        }
        if (localObject1 != null)
        {
          locala = this.wdC;
          if (locala == null) {
            p.btv("player");
          }
          locala.setSurface((Surface)localObject1);
        }
      }
      localObject1 = this.wdC;
      if (localObject1 == null) {
        p.btv("player");
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).prepareAsync();
      AppMethodBeat.o(254165);
      return true;
      localObject1 = null;
      break;
      localObject1 = null;
      break label106;
    }
    label379:
    AppMethodBeat.o(254165);
    return false;
  }
  
  private static boolean Me(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private final void O(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(254182);
    if (TextUtils.isEmpty((CharSequence)paramString2))
    {
      Log.w(TAG, "prepareCacheFile(), return for online url:".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(254182);
      return;
    }
    paramString2 = com.tencent.mm.vfs.s.k(paramString2, false);
    Log.i(TAG, "prepareCacheFile(), cache file:" + paramString2 + ", isExists:" + com.tencent.mm.vfs.s.YS(paramString2) + ' ' + dFm());
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.wdC;
    if (locala == null) {
      p.btv("player");
    }
    locala.setMediaId(paramString1);
    paramString1 = this.wdC;
    if (paramString1 == null) {
      p.btv("player");
    }
    paramString1.setDataSource(paramString2);
    Md(paramInt);
    AppMethodBeat.o(254182);
  }
  
  private final void a(final s params)
  {
    AppMethodBeat.i(254188);
    Log.i(TAG, "startProgressTimer " + dFm());
    if (this.wdM != null)
    {
      Log.w(TAG, "startProgressTimer return for :" + this.wdM);
      AppMethodBeat.o(254188);
      return;
    }
    this.wdM = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)new l(this, params), true);
    params = this.wdM;
    if (params != null) {
      params.setLogging(false);
    }
    params = this.wdM;
    if (params != null)
    {
      params.startTimer(0L, 16L);
      AppMethodBeat.o(254188);
      return;
    }
    AppMethodBeat.o(254188);
  }
  
  private final boolean asa()
  {
    switch (this.currentPlayState)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private final String dFm()
  {
    AppMethodBeat.i(254150);
    Object localObject1 = new StringBuilder("loader:");
    Object localObject2 = this.wdH;
    int i;
    if (localObject2 != null)
    {
      i = ((b)localObject2).hashCode();
      StringBuilder localStringBuilder = ((StringBuilder)localObject1).append(i).append(" proxy:").append(hashCode()).append(" mediaId: ");
      localObject1 = this.tHL;
      if (localObject1 != null)
      {
        localObject2 = ((s)localObject1).mediaId;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject1 = localStringBuilder.append((String)localObject1).append(" player:");
      localObject2 = this.wdC;
      if (localObject2 == null) {
        p.btv("player");
      }
      localObject2 = ((StringBuilder)localObject1).append(localObject2.hashCode()).append(" viewFocus:").append(this.wcA).append(" alpha:").append(getAlpha()).append(" surface:");
      localObject1 = this.surface;
      if (localObject1 == null) {
        break label202;
      }
    }
    label202:
    for (localObject1 = Boolean.valueOf(((Surface)localObject1).isValid());; localObject1 = null)
    {
      localObject1 = localObject1 + " currentPlayState:" + this.currentPlayState;
      AppMethodBeat.o(254150);
      return localObject1;
      i = 0;
      break;
    }
  }
  
  private final void dFn()
  {
    AppMethodBeat.i(254164);
    Log.i(TAG, "realPlay() " + dFm());
    Object localObject = this.wdE;
    if (localObject == null) {
      p.btv("textureView");
    }
    ((MMThumbPlayerTextureView)localObject).setInterceptDetach(false);
    setBgPrepareStatus(0);
    localObject = this.wdC;
    if (localObject == null) {
      p.btv("player");
    }
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).start();
    localObject = this.tHL;
    if (localObject != null)
    {
      a((s)localObject);
      AppMethodBeat.o(254164);
      return;
    }
    AppMethodBeat.o(254164);
  }
  
  private final void dFo()
  {
    AppMethodBeat.i(254184);
    Log.i(TAG, "startCdnDownload()");
    if (this.wdU)
    {
      Log.i(TAG, "startCdnDownload() already start cdn " + dFm());
      AppMethodBeat.o(254184);
      return;
    }
    dFq();
    Object localObject1 = com.tencent.mm.plugin.finder.utils.y.vXH;
    Object localObject2 = this.wdH;
    localObject1 = this.wdH;
    if (localObject1 != null) {
      localObject1 = ((b)localObject1).uJG;
    }
    while ((localObject2 != null) && (localObject1 != null))
    {
      Log.i(TAG, "startCdnDownload() " + dFm());
      MediaPreloadCore localMediaPreloadCore = this.wdG;
      if (localMediaPreloadCore != null) {
        localMediaPreloadCore.bm(((b)localObject2).mediaId, true);
      }
      if (!((at)localObject1).dkN())
      {
        if (this.wdR)
        {
          localObject1 = this.wdG;
          if (localObject1 != null) {
            ((MediaPreloadCore)localObject1).aup(((b)localObject2).mediaId);
          }
        }
        oN(false);
        ((PluginThumbPlayer)com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController().a(((b)localObject2).mediaId, (com.tencent.mm.plugin.thumbplayer.b.b)new i((b)localObject2), (com.tencent.mm.plugin.thumbplayer.b.e)new h(this));
        this.wdU = true;
        localObject1 = this.tHL;
        if (localObject1 != null)
        {
          localObject2 = this.wdT;
          if (localObject2 != null)
          {
            ((x)localObject2).b(((s)localObject1).tHN);
            AppMethodBeat.o(254184);
            return;
            localObject1 = null;
          }
          else
          {
            AppMethodBeat.o(254184);
          }
        }
        else
        {
          AppMethodBeat.o(254184);
        }
      }
      else
      {
        Log.i(TAG, "startCdnDownload() downloadFinish " + dFm());
      }
    }
    AppMethodBeat.o(254184);
  }
  
  private final void dFp()
  {
    AppMethodBeat.i(254185);
    Log.i(TAG, "stopCdnDownload()");
    if (!this.wdU)
    {
      Log.i(TAG, "stopCdnDownload() not start cdn " + dFm());
      AppMethodBeat.o(254185);
      return;
    }
    b localb = this.wdH;
    if (localb != null)
    {
      Log.i(TAG, "stopCdnDownload() " + dFm());
      MediaPreloadCore localMediaPreloadCore = this.wdG;
      if (localMediaPreloadCore != null) {
        localMediaPreloadCore.bm(localb.mediaId, false);
      }
      localb.oO(false);
      ((PluginThumbPlayer)com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController().a(localb.mediaId, (com.tencent.mm.plugin.thumbplayer.b.g)new m(this));
      this.wdU = false;
      AppMethodBeat.o(254185);
      return;
    }
    AppMethodBeat.o(254185);
  }
  
  private final void dFq()
  {
    AppMethodBeat.i(254186);
    Log.i(TAG, "stopCdnPreload()");
    if (!this.wdV)
    {
      Log.i(TAG, "stopCdnPreload(), not start preload cdn " + dFm());
      AppMethodBeat.o(254186);
      return;
    }
    b localb = this.wdH;
    if (localb != null)
    {
      ((PluginThumbPlayer)com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController().a(localb.mediaId, (com.tencent.mm.plugin.thumbplayer.b.f)new n(this));
      this.wdV = false;
      AppMethodBeat.o(254186);
      return;
    }
    AppMethodBeat.o(254186);
  }
  
  private final boolean dFr()
  {
    return this.currentPlayState == 3;
  }
  
  private final void dFs()
  {
    AppMethodBeat.i(254189);
    Log.i(TAG, "stopProgressTimer :" + this.wdM + ' ' + dFm());
    MTimerHandler localMTimerHandler = this.wdM;
    if (localMTimerHandler != null) {
      localMTimerHandler.stopTimer();
    }
    this.wdM = null;
    AppMethodBeat.o(254189);
  }
  
  private final com.tencent.mm.plugin.finder.video.reporter.a getFTPPKVReporter()
  {
    AppMethodBeat.i(254146);
    com.tencent.mm.plugin.finder.video.reporter.a locala = (com.tencent.mm.plugin.finder.video.reporter.a)this.wdK.getValue();
    AppMethodBeat.o(254146);
    return locala;
  }
  
  private final com.tencent.mm.plugin.finder.video.log.a getFTPPLog()
  {
    AppMethodBeat.i(254147);
    com.tencent.mm.plugin.finder.video.log.a locala = (com.tencent.mm.plugin.finder.video.log.a)this.wdL.getValue();
    AppMethodBeat.o(254147);
    return locala;
  }
  
  private final void getFTPPTag() {}
  
  private final boolean hj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(254183);
    if (TextUtils.isEmpty((CharSequence)paramString2))
    {
      Log.w(TAG, "prepareOnlineUrl(), return for online url:" + paramString2 + "  " + dFm());
      AppMethodBeat.o(254183);
      return false;
    }
    Log.i(TAG, "prepareOnlineUrl(), online url:" + paramString2 + "  " + dFm());
    TPVideoInfo.Builder localBuilder = new TPVideoInfo.Builder();
    localBuilder.fileId(paramString1);
    localBuilder.downloadParam(new TPDownloadParamData(11));
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.wdC;
    if (locala == null) {
      p.btv("player");
    }
    locala.setMediaId(paramString1);
    paramString1 = this.wdC;
    if (paramString1 == null) {
      p.btv("player");
    }
    paramString1.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 1000L));
    paramString1 = this.wdC;
    if (paramString1 == null) {
      p.btv("player");
    }
    paramString1.setVideoInfo(localBuilder.build());
    paramString1 = this.wdC;
    if (paramString1 == null) {
      p.btv("player");
    }
    paramString1.setDataSource(paramString2);
    boolean bool = Md(5);
    AppMethodBeat.o(254183);
    return bool;
  }
  
  private final void init()
  {
    AppMethodBeat.i(254148);
    wdW.add(Integer.valueOf(hashCode()));
    Log.i(TAG, "create FinderThumbPlayerProxy " + hashCode() + ' ' + wdW);
    Object localObject1 = com.tencent.tmediacodec.e.b.SmK;
    ((com.tencent.tmediacodec.e.b)localObject1).SmJ = b.a.SmM;
    Object localObject2 = com.tencent.tmediacodec.a.hpn();
    p.g(localObject2, "TCodecManager.getInstance()");
    ((com.tencent.tmediacodec.a)localObject2).a((com.tencent.tmediacodec.e.b)localObject1);
    localObject1 = com.tencent.tmediacodec.a.hpn();
    p.g(localObject1, "TCodecManager.getInstance()");
    ((com.tencent.tmediacodec.a)localObject1).hpo();
    localObject1 = com.tencent.mm.plugin.thumbplayer.e.d.GhZ;
    localObject1 = getContext();
    p.g(localObject1, "context");
    localObject1 = ((Context)localObject1).getApplicationContext();
    p.g(localObject1, "context.applicationContext");
    this.wdC = d.a.ht((Context)localObject1);
    this.wdD = new c();
    if (this.wdB) {}
    for (int i = 1;; i = 0)
    {
      this.tHS = new com.tencent.mm.plugin.finder.video.reporter.c(i);
      localObject1 = getContext();
      p.g(localObject1, "context");
      this.wdE = new MMThumbPlayerTextureView(((Context)localObject1).getApplicationContext());
      localObject1 = this.wdE;
      if (localObject1 == null) {
        p.btv("textureView");
      }
      ((MMThumbPlayerTextureView)localObject1).setOpaqueInfo(true);
      localObject1 = this.wdE;
      if (localObject1 == null) {
        p.btv("textureView");
      }
      localObject2 = this.wdD;
      if (localObject2 == null) {
        p.btv("playerListener");
      }
      ((MMThumbPlayerTextureView)localObject1).setTextureListenerCallback((TextureView.SurfaceTextureListener)localObject2);
      localObject1 = this.wdC;
      if (localObject1 == null) {
        p.btv("player");
      }
      localObject2 = this.wdD;
      if (localObject2 == null) {
        p.btv("playerListener");
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnErrorListener((ITPPlayerListener.IOnErrorListener)localObject2);
      localObject1 = this.wdC;
      if (localObject1 == null) {
        p.btv("player");
      }
      localObject2 = this.wdD;
      if (localObject2 == null) {
        p.btv("playerListener");
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnPreparedListener((ITPPlayerListener.IOnPreparedListener)localObject2);
      localObject1 = this.wdC;
      if (localObject1 == null) {
        p.btv("player");
      }
      localObject2 = this.wdD;
      if (localObject2 == null) {
        p.btv("playerListener");
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnVideoSizeChangedListener((ITPPlayerListener.IOnVideoSizeChangedListener)localObject2);
      localObject1 = this.wdC;
      if (localObject1 == null) {
        p.btv("player");
      }
      localObject2 = this.wdD;
      if (localObject2 == null) {
        p.btv("playerListener");
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnPlayerStateChangeListener((ITPPlayerListener.IOnStateChangeListener)localObject2);
      localObject1 = this.wdC;
      if (localObject1 == null) {
        p.btv("player");
      }
      localObject2 = this.wdD;
      if (localObject2 == null) {
        p.btv("playerListener");
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnInfoListener((ITPPlayerListener.IOnInfoListener)localObject2);
      AppMethodBeat.o(254148);
      return;
    }
  }
  
  private final void oM(boolean paramBoolean)
  {
    AppMethodBeat.i(254151);
    Log.i(TAG, "releaseSurface " + dFm());
    Object localObject = this.wdC;
    if (localObject == null) {
      p.btv("player");
    }
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).setSurface(null);
    localObject = this.surface;
    if (localObject != null) {
      ((Surface)localObject).release();
    }
    this.surface = null;
    if (paramBoolean)
    {
      localObject = this.wdE;
      if (localObject == null) {
        p.btv("textureView");
      }
      ((MMThumbPlayerTextureView)localObject).fxg();
    }
    AppMethodBeat.o(254151);
  }
  
  private final void oN(boolean paramBoolean)
  {
    AppMethodBeat.i(254180);
    Log.i(TAG, "updateIsReaStartDownloader() isReaStartDownloader:".concat(String.valueOf(paramBoolean)));
    this.wdQ.set(paramBoolean);
    AppMethodBeat.o(254180);
  }
  
  private final void setBgPrepareStatus(int paramInt)
  {
    AppMethodBeat.i(254187);
    Log.i(TAG, "setBgPrepareStatus " + paramInt + ' ' + dFm());
    this.wdJ = paramInt;
    AppMethodBeat.o(254187);
  }
  
  public final boolean Mc(int paramInt)
  {
    AppMethodBeat.i(254163);
    Log.i(TAG, "playWithSource() source=" + paramInt + ' ' + dFm() + ' ');
    if (!this.wcA)
    {
      Log.i(TAG, "playWithSource() return for isViewFocused:" + this.wcA);
      AppMethodBeat.o(254163);
      return false;
    }
    if (!Me(this.currentPlayState))
    {
      Log.i(TAG, "playWithSource() return for currentState:" + this.currentPlayState);
      AppMethodBeat.o(254163);
      return false;
    }
    boolean bool = isPlaying();
    if (bool)
    {
      Log.i(TAG, "playWithSource() return for isPlaying:".concat(String.valueOf(bool)));
      AppMethodBeat.o(254163);
      return false;
    }
    Object localObject;
    if (asa())
    {
      localObject = this.surface;
      if (localObject != null)
      {
        if (!((Surface)localObject).isValid()) {
          break label228;
        }
        if (localObject != null) {
          dFn();
        }
      }
    }
    for (;;)
    {
      dFo();
      localObject = this.wdC;
      if (localObject == null) {
        p.btv("player");
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).resumeDownload();
      AppMethodBeat.o(254163);
      return true;
      label228:
      localObject = null;
      break;
      if (!dFr()) {
        Md(0);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.loader.s params, boolean paramBoolean, FeedData paramFeedData)
  {
    AppMethodBeat.i(254149);
    p.h(params, "video");
    p.h(paramFeedData, "feedData");
    Object localObject;
    if (paramBoolean)
    {
      String str = params.uIw.url;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      params = (s)new com.tencent.mm.plugin.finder.video.source.a("", (String)localObject, params.auA(), params.uIw, params, paramFeedData);
      this.tHL = params;
      params = this.wdH;
      if (params == null) {
        break label314;
      }
      params = params.mediaId;
      label92:
      paramFeedData = this.tHL;
      if (paramFeedData == null) {
        p.hyc();
      }
      if (!(p.j(params, paramFeedData.mediaId) ^ true)) {
        break label319;
      }
      params = this.tHL;
      if (params == null) {
        p.hyc();
      }
      params = params.mediaId;
      paramFeedData = this.tHL;
      if (paramFeedData == null) {
        p.hyc();
      }
      this.wdH = new b(params, paramFeedData);
      Log.i(TAG, "setVideoMediaInfo(), init proxy " + this.wdH);
    }
    for (;;)
    {
      paramFeedData = this.tHL;
      if (paramFeedData == null) {
        p.hyc();
      }
      params = this.wdE;
      if (params == null) {
        p.btv("textureView");
      }
      if (params.getParent() != null)
      {
        params = this.wdE;
        if (params == null) {
          p.btv("textureView");
        }
        removeView((View)params);
      }
      if (!this.isLongVideo) {
        break label650;
      }
      params = com.tencent.mm.plugin.finder.utils.y.vXH;
      params = getContext();
      if (params != null) {
        break label348;
      }
      params = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(254149);
      throw params;
      params = (s)new com.tencent.mm.plugin.finder.video.source.b(params.getUrl(), params.getPath(), params.auA(), params.uIw, params, paramFeedData);
      break;
      label314:
      params = null;
      break label92;
      label319:
      Log.w(TAG, "setVideoMediaInfo(), duplicated mediaId " + this.wdH);
    }
    label348:
    for (params = com.tencent.mm.plugin.finder.utils.y.a((Activity)params, paramFeedData.tHN.uIw.width, paramFeedData.tHN.uIw.height);; params = com.tencent.mm.plugin.finder.utils.y.g((Context)localObject, params.getWidth(), params.getHeight()))
    {
      int i = ((Number)params.second).intValue();
      int j = ((Number)params.SWY).intValue();
      params = new FrameLayout.LayoutParams(-2, -2);
      params.gravity = 17;
      localObject = this.wdE;
      if (localObject == null) {
        p.btv("textureView");
      }
      addView((View)localObject, (ViewGroup.LayoutParams)params);
      params = this.wdE;
      if (params == null) {
        p.btv("textureView");
      }
      params.jk(i, j);
      params = paramFeedData.wgl;
      if (params != null)
      {
        params = params.MoU;
        if (params != null)
        {
          localObject = this.wdE;
          if (localObject == null) {
            p.btv("textureView");
          }
          ((MMThumbPlayerTextureView)localObject).setCropRect(new Rect((int)params.left, (int)params.top, (int)params.right, (int)params.bottom));
          params = this.wdE;
          if (params == null) {
            p.btv("textureView");
          }
          float f1 = paramFeedData.wgl.width;
          float f2 = paramFeedData.wgl.height;
          params.Giu = f1;
          params.Giv = f2;
        }
      }
      Log.i(TAG, "initTextureView(), isLongVideo:" + this.isLongVideo + " containerWidth:" + i + " containerHeight:" + j + ' ' + dFm());
      AppMethodBeat.o(254149);
      return;
      params = j.a(paramFeedData.tHN.uIw, this.onr);
      localObject = com.tencent.mm.plugin.finder.utils.y.vXH;
      localObject = getContext();
      if (localObject == null)
      {
        params = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(254149);
        throw params;
      }
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(254172);
    if (!Me(this.currentPlayState))
    {
      AppMethodBeat.o(254172);
      return false;
    }
    if (!asa())
    {
      AppMethodBeat.o(254172);
      return false;
    }
    Log.i(TAG, "seekTo " + paramDouble + ' ' + paramBoolean);
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.wdC;
    if (locala == null) {
      p.btv("player");
    }
    locala.seekTo(kotlin.h.a.K(1000.0D * paramDouble), 1);
    if (paramBoolean) {
      play();
    }
    AppMethodBeat.o(254172);
    return true;
  }
  
  public final boolean dEN()
  {
    AppMethodBeat.i(254167);
    if (this.wcA)
    {
      Log.i(TAG, "prepareToPlay() return for isViewFocused:" + this.wcA);
      AppMethodBeat.o(254167);
      return false;
    }
    Log.i(TAG, "prepareToPlay()  " + dFm());
    if (Me(this.currentPlayState))
    {
      if (this.currentPlayState == 2)
      {
        bool1 = Md(1);
        AppMethodBeat.o(254167);
        return bool1;
      }
      AppMethodBeat.o(254167);
      return false;
    }
    Object localObject = this.wdH;
    if (localObject != null) {
      ((b)localObject).dFt();
    }
    localObject = com.tencent.mm.plugin.finder.utils.y.vXH;
    s locals = this.tHL;
    b localb = this.wdH;
    localObject = this.wdH;
    boolean bool2;
    if (localObject != null)
    {
      localObject = ((b)localObject).uJG;
      if ((locals == null) || (localb == null) || (localObject == null)) {
        break label324;
      }
      bool1 = ((at)localObject).dkN();
      bool2 = com.tencent.mm.vfs.s.YS(locals.path);
      Log.i(TAG, "prepareToPlay() isAllCompleted:" + bool1 + " isExist:" + bool2 + ' ' + dFm());
      if (!(locals instanceof com.tencent.mm.plugin.finder.video.source.a)) {
        break label266;
      }
      O(locals.mediaId, locals.path, 21);
    }
    for (;;)
    {
      AppMethodBeat.o(254167);
      return true;
      localObject = null;
      break;
      label266:
      if ((!(locals instanceof com.tencent.mm.plugin.finder.video.source.b)) || (!bool1) || (!bool2)) {
        break label301;
      }
      O(locals.mediaId, locals.path, 22);
    }
    label301:
    boolean bool1 = hj(locals.mediaId, locals.downloadUrl);
    AppMethodBeat.o(254167);
    return bool1;
    label324:
    AppMethodBeat.o(254167);
    return false;
  }
  
  public final boolean dEO()
  {
    return this.sZd;
  }
  
  public final boolean dFj()
  {
    AppMethodBeat.i(254166);
    Object localObject2 = TAG;
    Object localObject3 = new StringBuilder("startOrPlay() ").append(dFm()).append(' ');
    if (BuildInfo.DEBUG) {}
    for (Object localObject1 = Util.getStack().toString();; localObject1 = "")
    {
      Log.i((String)localObject2, (String)localObject1);
      if (this.wcA) {
        break;
      }
      Log.i(TAG, "startOrPlay() return for isViewFocused:" + this.wcA);
      AppMethodBeat.o(254166);
      return false;
    }
    if (this.wdI)
    {
      Log.i(TAG, "startOrPlay() first time to play");
      localObject1 = this.wcw;
      if (localObject1 != null) {
        ((y)localObject1).a(this.tHS);
      }
      localObject1 = this.wcw;
      if (localObject1 != null) {
        ((y)localObject1).a(this.tHL, this.wdJ);
      }
      this.wdI = false;
      com.tencent.mm.plugin.report.service.h.CyF.n(1505L, 252L, 1L);
    }
    if (Me(this.currentPlayState))
    {
      Log.i(TAG, "startOrPlay() return for currentPlayState:" + this.currentPlayState);
      if (Mc(3)) {
        this.wdO = 0;
      }
      AppMethodBeat.o(254166);
      return false;
    }
    localObject1 = this.wdH;
    if (localObject1 != null) {
      ((b)localObject1).dFt();
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.y.vXH;
    localObject2 = this.tHL;
    localObject3 = this.wdH;
    localObject1 = this.wdH;
    boolean bool1;
    boolean bool2;
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).uJG;
      if ((localObject2 == null) || (localObject3 == null) || (localObject1 == null)) {
        break label458;
      }
      bool1 = ((at)localObject1).dkN();
      bool2 = com.tencent.mm.vfs.s.YS(((s)localObject2).path);
      Log.i(TAG, "startOrPlay() isAllCompleted:" + bool1 + " isExist:" + bool2 + ' ' + dFm());
      this.wdO = 0;
      if (!(localObject2 instanceof com.tencent.mm.plugin.finder.video.source.a)) {
        break label401;
      }
      O(((s)localObject2).mediaId, ((s)localObject2).path, 41);
    }
    for (;;)
    {
      AppMethodBeat.o(254166);
      return true;
      localObject1 = null;
      break;
      label401:
      if (((localObject2 instanceof com.tencent.mm.plugin.finder.video.source.b)) && (bool1) && (bool2))
      {
        O(((s)localObject2).mediaId, ((s)localObject2).path, 42);
      }
      else
      {
        dFo();
        hj(((s)localObject2).mediaId, ((s)localObject2).downloadUrl);
      }
    }
    label458:
    AppMethodBeat.o(254166);
    return false;
  }
  
  public final int dFk()
  {
    AppMethodBeat.i(254169);
    Log.i(TAG, "pauseWithCancel " + dFm());
    pause();
    AppMethodBeat.o(254169);
    return 0;
  }
  
  public final void dFl() {}
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(254152);
    Object localObject = this.wdE;
    if (localObject == null) {
      p.btv("textureView");
    }
    localObject = ((MMThumbPlayerTextureView)localObject).getBitmap();
    AppMethodBeat.o(254152);
    return localObject;
  }
  
  public final long getCurrentPlayMs()
  {
    AppMethodBeat.i(254154);
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.wdC;
    if (locala == null) {
      p.btv("player");
    }
    long l = locala.getCurrentPositionMs();
    AppMethodBeat.o(254154);
    return l;
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(254153);
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.wdC;
    if (locala == null) {
      p.btv("player");
    }
    int i = (int)(locala.getCurrentPositionMs() / 1000L);
    AppMethodBeat.o(254153);
    return i;
  }
  
  public final x getDownloadCallback()
  {
    return this.wdT;
  }
  
  public final boolean getIsNeverStart()
  {
    AppMethodBeat.i(254157);
    if (!Me(this.currentPlayState))
    {
      AppMethodBeat.o(254157);
      return true;
    }
    AppMethodBeat.o(254157);
    return false;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.wcB;
  }
  
  public final y getLifecycle()
  {
    return this.wcw;
  }
  
  public final MediaPreloadCore getMediaPreloadCore$plugin_finder_release()
  {
    return this.wdG;
  }
  
  public final t getOnMuteListener()
  {
    return this.wdS;
  }
  
  public final u getOnPlayerStopListener()
  {
    return this.wdP;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(254158);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(254158);
    return localViewParent;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(254155);
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.wdC;
    if (locala == null) {
      p.btv("player");
    }
    int i = (int)(locala.getDurationMs() / 1000L);
    AppMethodBeat.o(254155);
    return i;
  }
  
  public final long getVideoDurationMs()
  {
    AppMethodBeat.i(254156);
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.wdC;
    if (locala == null) {
      p.btv("player");
    }
    long l = locala.getDurationMs();
    AppMethodBeat.o(254156);
    return l;
  }
  
  public final String getVideoMediaId()
  {
    Object localObject = this.tHL;
    if (localObject != null)
    {
      String str = ((s)localObject).mediaId;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final s getVideoMediaInfo()
  {
    return this.tHL;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final i.b getVideoViewCallback()
  {
    return this.wcv;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.wcA;
  }
  
  public final boolean isPlaying()
  {
    return this.currentPlayState == 5;
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(254181);
    Log.i(TAG, "release " + dFm());
    oM(true);
    this.wdT = null;
    this.wdH = null;
    com.tencent.mm.ac.d.c(TAG, (kotlin.g.a.a)new g(this));
    wdW.remove(Integer.valueOf(hashCode()));
    AppMethodBeat.o(254181);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(254171);
    Log.i(TAG, "onUIDestroy " + dFm());
    stop();
    AppMethodBeat.o(254171);
  }
  
  public final boolean pause()
  {
    int i = 0;
    AppMethodBeat.i(254168);
    if (!Me(this.currentPlayState))
    {
      Log.i(TAG, "pause() return for state:" + this.currentPlayState);
      AppMethodBeat.o(254168);
      return false;
    }
    Log.i(TAG, "pause()  " + dFm());
    Object localObject1;
    if (isPlaying())
    {
      localObject1 = this.wdC;
      if (localObject1 == null) {
        p.btv("player");
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).pause();
      localObject1 = this.wdC;
      if (localObject1 == null) {
        p.btv("player");
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).pauseDownload();
      localObject1 = this.wdE;
      if (localObject1 == null) {
        p.btv("textureView");
      }
      ((MMThumbPlayerTextureView)localObject1).setInterceptDetach(true);
      dFp();
      if (this.wcB)
      {
        Log.i(TAG, "startCdnPreload() " + dFm());
        if (!this.wdV) {
          break label321;
        }
        Log.i(TAG, "startCdnPreload(), already start preload cdn " + dFm());
      }
    }
    for (;;)
    {
      dFs();
      if (this.tHL != null)
      {
        localObject1 = this.wcw;
        if (localObject1 != null) {
          ((y)localObject1).dFL();
        }
      }
      AppMethodBeat.o(254168);
      return true;
      if ((!dFr()) || (this.wcA)) {
        break;
      }
      long l = System.currentTimeMillis();
      stop();
      Log.i(TAG, "pause() preparing stop cost=" + (System.currentTimeMillis() - l) + "ms");
      break;
      label321:
      Object localObject2 = this.wdH;
      if ((localObject2 != null) && (((b)localObject2).uJG.field_cacheSize < ((b)localObject2).wef) && (((b)localObject2).uJG.field_totalSize > 0L))
      {
        localObject1 = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController();
        String str = ((b)localObject2).mediaId;
        localObject2 = (com.tencent.mm.plugin.thumbplayer.b.b)new k((b)localObject2);
        com.tencent.mm.plugin.thumbplayer.b.d locald = (com.tencent.mm.plugin.thumbplayer.b.d)new j(this);
        p.h(str, "mediaId");
        p.h(localObject2, "createCallback");
        if (((CharSequence)str).length() == 0) {
          i = 1;
        }
        if (i == 0) {
          com.tencent.mm.ac.d.c("MicroMsg.Cdn.ThreadName", (kotlin.g.a.a)new a.e((com.tencent.mm.plugin.thumbplayer.b.a)localObject1, (com.tencent.mm.plugin.thumbplayer.b.b)localObject2, str, locald));
        }
        this.wdV = true;
      }
    }
  }
  
  public final boolean play()
  {
    AppMethodBeat.i(254162);
    Log.i(TAG, "play()");
    boolean bool = Mc(0);
    AppMethodBeat.o(254162);
    return bool;
  }
  
  public final void setDownloadCallback(x paramx)
  {
    this.wdT = paramx;
  }
  
  public final void setFinderVideoCore(k paramk) {}
  
  public final void setFullScreen(boolean paramBoolean)
  {
    this.onr = paramBoolean;
  }
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(254174);
    p.h(paramb, "_callback");
    this.wcv = paramb;
    AppMethodBeat.o(254174);
  }
  
  public final void setIOnlineVideoProxy(com.tencent.mm.modelvideo.b paramb)
  {
    AppMethodBeat.i(254176);
    p.h(paramb, "_proxy");
    AppMethodBeat.o(254176);
  }
  
  public final void setInterceptDetach(boolean paramBoolean)
  {
    AppMethodBeat.i(254161);
    MMThumbPlayerTextureView localMMThumbPlayerTextureView = this.wdE;
    if (localMMThumbPlayerTextureView == null) {
      p.btv("textureView");
    }
    localMMThumbPlayerTextureView.setInterceptDetach(paramBoolean);
    AppMethodBeat.o(254161);
  }
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    AppMethodBeat.i(254159);
    Log.i(TAG, "setIsShouldPlayResume() " + paramBoolean + ' ' + dFm());
    this.wcB = paramBoolean;
    AppMethodBeat.o(254159);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean) {}
  
  public final void setLifecycle(y paramy)
  {
    this.wcw = paramy;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(254177);
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.wdC;
    if (locala == null) {
      p.btv("player");
    }
    locala.setLoopback(paramBoolean);
    AppMethodBeat.o(254177);
  }
  
  public final void setMediaPreloadCore$plugin_finder_release(MediaPreloadCore paramMediaPreloadCore)
  {
    this.wdG = paramMediaPreloadCore;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(254173);
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.wdC;
    if (locala == null) {
      p.btv("player");
    }
    locala.setOutputMute(paramBoolean);
    AppMethodBeat.o(254173);
  }
  
  public final void setOnMuteListener(t paramt)
  {
    this.wdS = paramt;
  }
  
  public final void setOnPlayerStopListener(u paramu)
  {
    this.wdP = paramu;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    this.sZd = paramBoolean;
  }
  
  public final void setScaleType(i.e parame)
  {
    AppMethodBeat.i(254175);
    p.h(parame, "scaleType");
    switch (i.$EnumSwitchMapping$0[parame.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(254175);
      return;
      parame = this.wdE;
      if (parame == null) {
        p.btv("textureView");
      }
      MMThumbPlayerTextureView.a locala = MMThumbPlayerTextureView.GiC;
      parame.setScaleType(MMThumbPlayerTextureView.fxh());
      AppMethodBeat.o(254175);
      return;
      parame = this.wdE;
      if (parame == null) {
        p.btv("textureView");
      }
      locala = MMThumbPlayerTextureView.GiC;
      parame.setScaleType(MMThumbPlayerTextureView.fxi());
      AppMethodBeat.o(254175);
      return;
      parame = this.wdE;
      if (parame == null) {
        p.btv("textureView");
      }
      locala = MMThumbPlayerTextureView.GiC;
      parame.setScaleType(MMThumbPlayerTextureView.fxk());
    }
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.wcB = paramBoolean;
  }
  
  public final void setStartCdn(boolean paramBoolean)
  {
    this.wdU = paramBoolean;
  }
  
  public final void setStartCdnPreload(boolean paramBoolean)
  {
    this.wdV = paramBoolean;
  }
  
  public final void setVideoMuteListener(t paramt)
  {
    AppMethodBeat.i(254179);
    p.h(paramt, "muteListener");
    this.wdS = paramt;
    AppMethodBeat.o(254179);
  }
  
  public final void setVideoPlayLifecycle(y paramy)
  {
    AppMethodBeat.i(254178);
    p.h(paramy, "lifecycle");
    this.wcw = paramy;
    AppMethodBeat.o(254178);
  }
  
  public final void setVideoViewCallback(i.b paramb)
  {
    this.wcv = paramb;
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(254160);
    Log.i(TAG, "setVideoViewFocused " + paramBoolean + ' ' + dFm());
    this.wcA = paramBoolean;
    AppMethodBeat.o(254160);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.wcA = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(254170);
    Log.i(TAG, "stop() " + dFm());
    if (!Me(this.currentPlayState))
    {
      Log.i(TAG, "stop() return for isStartPlay.");
      localObject = this.wdP;
      if (localObject != null)
      {
        ((u)localObject).dFR();
        AppMethodBeat.o(254170);
        return;
      }
      AppMethodBeat.o(254170);
      return;
    }
    Object localObject = this.wcw;
    if (localObject != null) {
      ((y)localObject).b(this.tHL);
    }
    localObject = this.wdC;
    if (localObject == null) {
      p.btv("player");
    }
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).stop();
    localObject = this.wdC;
    if (localObject == null) {
      p.btv("player");
    }
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject).reset();
    getFTPPLog().reset();
    dFs();
    dFp();
    dFq();
    this.wdI = true;
    this.wdF = false;
    this.tHS = null;
    setBgPrepareStatus(0);
    Log.i(TAG, "stop() end");
    AppMethodBeat.o(254170);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$Companion;", "", "()V", "NOTIFY_BUFFERING_START_DELAY_MS", "", "NOTIFY_PROGRESS_INTERVAL_MS", "NOTIFY_PROGRESS_TIMER_TAG", "", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "currentKeepProxySet", "Ljava/util/HashSet;", "", "getCurrentKeepProxySet", "()Ljava/util/HashSet;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "Lplatform/android/ThumbPlayerAndroid/src/main/java/com/tencent/thumbplayer/datatransport/resourceloader/AbsTPAssetResourceLoader;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "mediaId", "", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "(Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "MAX_REQUEST_BUFFER", "", "MIN_CHECK_BUFFER", "REQUEST_INTERVAL", "REQUEST_PERIOD_MAX_MS", "REQUEST_PERIOD_MIN_MS", "isRequestingData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastOnReadDataEnd", "getLastOnReadDataEnd", "()J", "setLastOnReadDataEnd", "(J)V", "mediaCache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "getMediaCache", "()Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "setMediaCache", "(Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;)V", "getMediaId", "()Ljava/lang/String;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "requestNumber", "", "callback", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "createVideoPreloadCDNTask", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "getContentType", "fileId", "fileKey", "getDataFilePath", "getDataTotalSize", "notifyDataReady", "requestOffset", "requestLength", "onDataAvailable", "offset", "length", "onFinish", "ret", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "onPreloadCompleted", "onProgress", "total", "onReadData", "onStartReadData", "requestStart", "requestEnd", "onStopReadData", "requestId", "toString", "updateMediaCache", "updateRequestingData", "value", "plugin-finder_release"})
  public final class b
    extends h.a.a.a.a.a.a.a.a.a.a.a
    implements g.a, g.b, h.a
  {
    final String mediaId;
    at uJG;
    final s wcy;
    private final long wdY;
    private final long wdZ;
    private final long wea;
    private final long web;
    private final long wec;
    private int wed;
    private AtomicBoolean wee;
    long wef;
    
    public b(s params)
    {
      AppMethodBeat.i(254121);
      this.mediaId = params;
      this.wcy = ((s)localObject);
      this.wdY = 30L;
      this.wdZ = 1048576L;
      this.wea = 131072L;
      this.web = 10L;
      this.wec = 50L;
      this.wee = new AtomicBoolean(false);
      this$1 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
      this.uJG = com.tencent.mm.plugin.finder.storage.logic.d.bv(this.mediaId, true);
      this$1 = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "create ResourceLoaderProxy, state:" + this.uJG.field_state + ' ' + "path:" + this.uJG.getFilePath() + ", mediaInfo path:" + this.wcy.path);
      switch (this.uJG.field_state)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(254121);
        return;
        this$1 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
        String str = this.mediaId;
        params = this.wcy.tHN.uIw.mediaId;
        this$1 = params;
        if (params == null) {
          this$1 = "";
        }
        localObject = this.wcy.downloadUrl;
        params = (s)localObject;
        if (localObject == null) {
          params = "";
        }
        com.tencent.mm.plugin.finder.storage.logic.d.a(str, FinderThumbPlayerProxy.this, params, this.wcy.tHN.uJN, this.wcy.tHN.uIx.detail, 0L, 0L, 1, this.wcy.tHN.uIw.videoDuration, "", "");
        dFt();
      }
    }
    
    public final void Ds(String paramString)
    {
      AppMethodBeat.i(254104);
      p.h(paramString, "mediaId");
      AppMethodBeat.o(254104);
    }
    
    public final String Mf(int paramInt)
    {
      AppMethodBeat.i(254118);
      String str = com.tencent.mm.vfs.s.k(this.wcy.path, false);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "getDataFilePath(), dataFilePath:" + str + " isExists:" + com.tencent.mm.vfs.s.YS(str) + ' ' + "mediaInfoPath:" + this.wcy.path);
      AppMethodBeat.o(254118);
      return str;
    }
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      int i = 1;
      AppMethodBeat.i(254109);
      p.h(paramString, "mediaId");
      Object localObject = FinderThumbPlayerProxy.wdX;
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
          paramd = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
          com.tencent.mm.plugin.finder.storage.logic.d.a(paramString, paramc.field_finishedLength, paramc.field_toltalLength, paramInt);
          dFt();
          paramc = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
          com.tencent.mm.plugin.finder.storage.logic.d.avG(paramString);
        }
        AppMethodBeat.o(254109);
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
      AppMethodBeat.i(254108);
      p.h(paramString, "mediaId");
      p.h(paramd, "sceneResult");
      Object localObject = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "onFinish() mediaId=" + paramString + " ret=" + paramInt + " recvedBytes=" + paramd.field_recvedBytes + " fileLength=" + paramd.field_fileLength + "  finderformat:" + paramd.field_videoFormat);
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(this, paramInt, paramd));
      if (paramInt != 0)
      {
        paramd = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
        localObject = this.wcy.tHN.uIw.mediaId;
        paramd = (com.tencent.mm.i.d)localObject;
        if (localObject == null) {
          paramd = "";
        }
        String str = this.wcy.downloadUrl;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        com.tencent.mm.plugin.finder.storage.logic.d.a(paramString, paramd, (String)localObject, this.wcy.tHN.uJN, this.wcy.tHN.uIx.detail, 0L, 0L, -1, this.wcy.tHN.uIw.videoDuration, "", "");
      }
      for (;;)
      {
        dFt();
        oO(false);
        AppMethodBeat.o(254108);
        return;
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
        com.tencent.mm.plugin.finder.storage.logic.d.a(paramString, paramd.field_fileLength, paramd.field_fileLength, 3);
        paramd = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
        com.tencent.mm.plugin.finder.storage.logic.d.avG(paramString);
      }
    }
    
    public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(254105);
      p.h(paramString1, "mediaId");
      Object localObject = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "onMoovReady() offset=" + paramLong1 + " length=" + paramLong2 + " svrflag=" + paramString2 + ' ' + this);
      if (!this.uJG.field_moovReady) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
        localObject = paramString2;
        if (paramString2 == null) {
          localObject = "";
        }
        com.tencent.mm.plugin.finder.storage.logic.d.gU(paramString1, (String)localObject);
        dFt();
        if ((!FinderThumbPlayerProxy.m(FinderThumbPlayerProxy.this)) && (!FinderThumbPlayerProxy.n(FinderThumbPlayerProxy.this)))
        {
          paramString2 = FinderThumbPlayerProxy.wdX;
          Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "onMoovReady() try to prepared");
          FinderThumbPlayerProxy.o(FinderThumbPlayerProxy.this);
        }
        paramString2 = FinderThumbPlayerProxy.this.getDownloadCallback();
        if (paramString2 != null) {
          paramString2.a((int)paramLong1, (int)paramLong2, this.wcy.tHN, bool);
        }
        paramString2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
        com.tencent.mm.plugin.finder.storage.logic.d.avG(paramString1);
        AppMethodBeat.o(254105);
        return;
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(254110);
      p.h(paramString, "mediaId");
      AppMethodBeat.o(254110);
    }
    
    public final void b(String paramString, com.tencent.mm.i.d paramd)
    {
      Object localObject1 = null;
      AppMethodBeat.i(254111);
      p.h(paramString, "mediaId");
      Object localObject2 = FinderThumbPlayerProxy.wdX;
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
        FinderThumbPlayerProxy.p(FinderThumbPlayerProxy.this);
        AppMethodBeat.o(254111);
        return;
      }
    }
    
    public final void dFt()
    {
      AppMethodBeat.i(254112);
      com.tencent.mm.plugin.finder.storage.logic.d locald = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
      this.uJG = com.tencent.mm.plugin.finder.storage.logic.d.avH(this.mediaId);
      AppMethodBeat.o(254112);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
    
    public final String getContentType(int paramInt, String paramString)
    {
      AppMethodBeat.i(254119);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "getContentType() fileId:" + paramInt + ", fileKey:" + paramString + " contentType:" + "video/mp4");
      AppMethodBeat.o(254119);
      return "video/mp4";
    }
    
    public final long getDataTotalSize(int paramInt, String paramString)
    {
      AppMethodBeat.i(254117);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "getDataTotalSize() fileId:" + paramInt + ", fileKey:" + paramString + " dataTotalSize:" + this.uJG.field_totalSize + ' ');
      long l = this.uJG.field_totalSize;
      AppMethodBeat.o(254117);
      return l;
    }
    
    public final void i(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(254107);
      p.h(paramString, "mediaId");
      Object localObject = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "onProgress() offset=" + paramLong1 + " total=" + paramLong2 + ' ' + this);
      localObject = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
      com.tencent.mm.plugin.finder.storage.logic.d.a(paramString, paramLong1, paramLong2, 1);
      dFt();
      localObject = FinderThumbPlayerProxy.this.getDownloadCallback();
      if (localObject != null) {
        ((x)localObject).a((int)paramLong1, (int)paramLong2, this.wcy.tHN);
      }
      localObject = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
      com.tencent.mm.plugin.finder.storage.logic.d.avG(paramString);
      AppMethodBeat.o(254107);
    }
    
    public final int k(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(254115);
      if (!FinderThumbPlayerProxy.q(FinderThumbPlayerProxy.this).get())
      {
        localObject1 = FinderThumbPlayerProxy.wdX;
        Log.w(FinderThumbPlayerProxy.access$getTAG$cp(), "notifyDataReady, return for downloader never start. requestOffset:" + paramLong1 + " requestLength:" + paramLong2 + ' ' + this);
        FinderThumbPlayerProxy.r(FinderThumbPlayerProxy.this).dFX();
      }
      Object localObject2;
      Object localObject3;
      for (paramLong1 = 0L;; paramLong1 = 0L)
      {
        paramInt = (int)paramLong1;
        AppMethodBeat.o(254115);
        return paramInt;
        if ((!FinderThumbPlayerProxy.s(FinderThumbPlayerProxy.this)) || (paramLong1 <= this.uJG.field_cacheSize)) {
          break;
        }
        localObject1 = FinderThumbPlayerProxy.t(FinderThumbPlayerProxy.this);
        localObject2 = FinderThumbPlayerProxy.wdX;
        localObject2 = FinderThumbPlayerProxy.access$getTAG$cp();
        localObject3 = "notifyDataReady() return for pause state. request[offset:" + paramLong1 + " length:" + paramLong2 + "] cacheSize:" + this.uJG.field_cacheSize + ' ' + this;
        paramLong1 = System.currentTimeMillis();
        if (paramLong1 - ((com.tencent.mm.plugin.finder.video.log.a)localObject1).wgD > 5000L)
        {
          Log.w((String)localObject2, (String)localObject3);
          ((com.tencent.mm.plugin.finder.video.log.a)localObject1).wgD = paramLong1;
        }
      }
      long l2 = 0L;
      long l1;
      if (this.uJG.dkN())
      {
        l1 = paramLong2;
        label239:
        if (l1 != 0L) {
          break label871;
        }
        if ((!this.uJG.field_moovReady) || (this.wee.get())) {
          break label743;
        }
        if (paramLong2 >= this.wdZ) {
          break label601;
        }
      }
      for (;;)
      {
        l2 = paramLong2;
        if (paramLong1 + paramLong2 > this.uJG.field_totalSize)
        {
          l2 = this.uJG.field_totalSize - paramLong1;
          localObject1 = FinderThumbPlayerProxy.wdX;
          Log.w(FinderThumbPlayerProxy.access$getTAG$cp(), "notifyDataReady() requestLength is valid, requestOffset:" + paramLong1 + ", requestLength:" + l2 + ", totalSize:" + this.uJG.field_totalSize + ' ' + this);
        }
        localObject1 = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController();
        localObject2 = this.mediaId;
        p.h(localObject2, "mediaId");
        if (((com.tencent.mm.plugin.thumbplayer.b.a)localObject1).Ggu.containsKey(localObject2)) {
          break label610;
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
        localObject1 = FinderThumbPlayerProxy.t(FinderThumbPlayerProxy.this);
        localObject3 = FinderThumbPlayerProxy.wdX;
        localObject3 = FinderThumbPlayerProxy.access$getTAG$cp();
        localObject2 = "notifyDataReady() queryContinuousSize error, ret:" + paramInt + " requestOffset:" + paramLong1 + " continuousSize:" + localObject2[0] + " totalSize:" + localObject2[1] + ' ' + this;
        long l3 = System.currentTimeMillis();
        l1 = l2;
        if (l3 - ((com.tencent.mm.plugin.finder.video.log.a)localObject1).wgC <= 500L) {
          break label239;
        }
        Log.w((String)localObject3, (String)localObject2);
        ((com.tencent.mm.plugin.finder.video.log.a)localObject1).wgC = l3;
        l1 = l2;
        break label239;
        label601:
        paramLong2 = this.wdZ;
      }
      label610:
      paramInt = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController().a(this.mediaId, (int)paramLong1, (int)l2, (com.tencent.mm.plugin.thumbplayer.b.c)new a(this));
      if (paramInt > 0) {
        oO(true);
      }
      Object localObject1 = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "notifyDataReady() requestVideoData requestOffset:" + paramLong1 + " requestLengthFix:" + l2 + " requestDataRet:" + paramInt + "  cacheSize:" + this.uJG.field_cacheSize + ' ' + this);
      for (;;)
      {
        this.wef = (paramLong1 + l1);
        paramLong1 = l1;
        break;
        label743:
        localObject1 = FinderThumbPlayerProxy.t(FinderThumbPlayerProxy.this);
        localObject2 = FinderThumbPlayerProxy.wdX;
        localObject2 = FinderThumbPlayerProxy.access$getTAG$cp();
        localObject3 = "notifyDataReady() returnLength:" + l1 + " fixRequest[offset:" + paramLong1 + " length:" + paramLong2 + "],  originRequest[offset:" + paramLong1 + " length:" + paramLong2 + "] " + this;
        paramLong2 = System.currentTimeMillis();
        if (paramLong2 - ((com.tencent.mm.plugin.finder.video.log.a)localObject1).wgE > 200L)
        {
          Log.w((String)localObject2, (String)localObject3);
          ((com.tencent.mm.plugin.finder.video.log.a)localObject1).wgE = paramLong2;
          continue;
          label871:
          localObject1 = FinderThumbPlayerProxy.wdX;
          Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "notifyDataReady() returnLength:" + l1 + " fixRequest[offset:" + paramLong1 + " length:" + paramLong2 + "], originRequest[offset:" + paramLong1 + " length:" + paramLong2 + "] " + this);
        }
      }
    }
    
    public final void oO(boolean paramBoolean)
    {
      AppMethodBeat.i(254113);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "updateRequestingData " + paramBoolean + ' ' + this);
      this.wee.set(paramBoolean);
      AppMethodBeat.o(254113);
    }
    
    public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(254106);
      p.h(paramString, "mediaId");
      oO(false);
      paramString = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "onDataAvailable() offset=" + paramLong1 + " length=" + paramLong2 + ' ' + this + '}');
      AppMethodBeat.o(254106);
    }
    
    public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(254114);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "onStartReadData() fileId:" + paramInt + ", fileKey:" + paramString + ", requestStart:" + paramLong1 + ", requestEnd:" + paramLong2);
      paramInt = this.wed;
      this.wed = (paramInt + 1);
      AppMethodBeat.o(254114);
      return paramInt;
    }
    
    public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(254116);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "onStartReadData() fileId:" + paramInt1 + ", fileKey:" + paramString + ", requestId:" + paramInt2);
      paramInt1 = this.wed;
      AppMethodBeat.o(254116);
      return paramInt1;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(254120);
      String str = FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this) + " isMoovReady:" + this.uJG.field_moovReady + " isRequestingData:" + this.wee.get() + " isFinish:" + this.uJG.dkN() + " total:" + this.uJG.field_totalSize;
      AppMethodBeat.o(254120);
      return str;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy$notifyDataReady$requestDataRet$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "onRequest", "", "ret", "", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.plugin.thumbplayer.b.c
    {
      public final void Mg(int paramInt)
      {
        AppMethodBeat.i(254102);
        if (paramInt != 0)
        {
          FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.wdX;
          Log.w(FinderThumbPlayerProxy.access$getTAG$cp(), "requestedResource() requestVideoData fail, ret:" + paramInt + ' ' + this);
          this.weh.oO(false);
        }
        AppMethodBeat.o(254102);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      b(FinderThumbPlayerProxy.b paramb, int paramInt, com.tencent.mm.i.d paramd)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$TPPlayerListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnPreparedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnVideoSizeChangedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnInfoListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnCompletionListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnErrorListener;", "(Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;)V", "onCompletion", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onError", "errorType", "", "errorCode", "arg1", "", "arg2", "onInfo", "what", "extraObject", "", "onPrepared", "onStateChange", "preState", "curState", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "surface", "onVideoSizeChanged", "plugin-finder_release"})
  public final class c
    implements TextureView.SurfaceTextureListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnVideoSizeChangedListener
  {
    public final void onCompletion(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(254130);
      paramITPPlayer = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onCompletion() " + FinderThumbPlayerProxy.a(this.weg));
      AppMethodBeat.o(254130);
    }
    
    public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(254131);
      p.h(paramITPPlayer, "player");
      Object localObject1 = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onError() " + paramInt1 + ' ' + paramInt2 + " bgPrepareStatus:" + FinderThumbPlayerProxy.g(this.weg) + ' ' + FinderThumbPlayerProxy.a(this.weg));
      if (paramInt2 == 11030406)
      {
        s locals = FinderThumbPlayerProxy.f(this.weg);
        if (locals != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
          String str2 = locals.mediaId;
          Object localObject2 = locals.tHN.uIw.mediaId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          String str1 = locals.downloadUrl;
          localObject2 = str1;
          if (str1 == null) {
            localObject2 = "";
          }
          com.tencent.mm.plugin.finder.storage.logic.d.a(str2, (String)localObject1, (String)localObject2, locals.tHN.uJN, locals.tHN.uIx.detail, 0L, 0L, 1, locals.tHN.uIw.videoDuration, "", "");
          localObject1 = FinderThumbPlayerProxy.j(this.weg);
          if (localObject1 != null) {
            ((FinderThumbPlayerProxy.b)localObject1).dFt();
          }
        }
      }
      if (FinderThumbPlayerProxy.g(this.weg) != 0)
      {
        paramITPPlayer.reset();
        this.weg.dEN();
        AppMethodBeat.o(254131);
        return;
      }
      paramITPPlayer = FinderThumbPlayerProxy.f(this.weg);
      if (paramITPPlayer != null)
      {
        localObject1 = this.weg.getVideoViewCallback();
        if (localObject1 != null)
        {
          ((i.b)localObject1).c("", paramITPPlayer.mediaId, "", paramInt2, paramInt1);
          AppMethodBeat.o(254131);
          return;
        }
        AppMethodBeat.o(254131);
        return;
      }
      AppMethodBeat.o(254131);
    }
    
    public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      Object localObject1 = null;
      paramITPPlayer = null;
      StringBuilder localStringBuilder = null;
      AppMethodBeat.i(254128);
      Object localObject2 = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo() what:" + paramInt + " arg1:" + paramLong1 + " arg2:" + paramLong2 + " extraObject:" + paramObject + ' ' + FinderThumbPlayerProxy.a(this.weg));
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
          AppMethodBeat.o(254128);
          return;
          paramITPPlayer = FinderThumbPlayerProxy.wdX;
          Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo#onBufferingStart() pos:" + this.weg.getCurrentPlayMs() + ' ' + FinderThumbPlayerProxy.a(this.weg));
          paramObject = this.weg;
          localObject1 = FinderThumbPlayerProxy.f(this.weg);
          paramITPPlayer = localStringBuilder;
          if (localObject1 != null) {
            paramITPPlayer = ((s)localObject1).mediaId;
          }
          FinderThumbPlayerProxy.a(paramObject, paramITPPlayer);
          AppMethodBeat.o(254128);
          return;
          paramITPPlayer = FinderThumbPlayerProxy.wdX;
          Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo#onBufferingEnd() pos:" + this.weg.getCurrentPlayMs() + ' ' + FinderThumbPlayerProxy.a(this.weg));
          FinderThumbPlayerProxy.k(this.weg);
          AppMethodBeat.o(254128);
          return;
          paramITPPlayer = FinderThumbPlayerProxy.wdX;
          Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo#onReplay() " + FinderThumbPlayerProxy.a(this.weg));
          paramITPPlayer = this.weg.getLifecycle();
          if (paramITPPlayer != null)
          {
            FinderThumbPlayerProxy.f(this.weg);
            paramITPPlayer.dFM();
            AppMethodBeat.o(254128);
            return;
          }
          AppMethodBeat.o(254128);
          return;
          paramITPPlayer = FinderThumbPlayerProxy.wdX;
          Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo#firstVideoFrameRendered " + FinderThumbPlayerProxy.a(this.weg));
          paramITPPlayer = this.weg.getLifecycle();
          if (paramITPPlayer != null)
          {
            FinderThumbPlayerProxy.f(this.weg);
            paramITPPlayer.dFK();
            AppMethodBeat.o(254128);
            return;
          }
          AppMethodBeat.o(254128);
          return;
          paramITPPlayer = FinderThumbPlayerProxy.wdX;
          Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo#firstAudioFrameRendered " + FinderThumbPlayerProxy.a(this.weg));
          AppMethodBeat.o(254128);
          return;
        } while (!(paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo));
        paramITPPlayer = FinderThumbPlayerProxy.wdX;
        Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo#downloadProgressUpdate: " + ((TPPlayerMsg.TPDownLoadProgressInfo)paramObject).playableDurationMS);
        AppMethodBeat.o(254128);
        return;
      case 204: 
        paramITPPlayer = FinderThumbPlayerProxy.wdX;
        paramObject = FinderThumbPlayerProxy.access$getTAG$cp();
        localStringBuilder = new StringBuilder("FTPP.onInfo#videoDecodeType:").append(paramLong1).append(' ');
        paramITPPlayer = FinderThumbPlayerProxy.f(this.weg);
        if (paramITPPlayer != null) {}
        for (paramITPPlayer = paramITPPlayer.mediaId;; paramITPPlayer = null)
        {
          Log.i(paramObject, paramITPPlayer);
          paramObject = FinderThumbPlayerProxy.f(this.weg);
          paramITPPlayer = (ITPPlayer)localObject1;
          if (paramObject != null)
          {
            paramObject = paramObject.wgl;
            paramITPPlayer = (ITPPlayer)localObject1;
            if (paramObject != null) {
              paramITPPlayer = paramObject.MoZ;
            }
          }
          if (paramITPPlayer == null)
          {
            paramITPPlayer = FinderThumbPlayerProxy.f(this.weg);
            if (paramITPPlayer != null)
            {
              paramITPPlayer = paramITPPlayer.wgl;
              if (paramITPPlayer != null) {
                paramITPPlayer.MoZ = new FinderMediaReportObject();
              }
            }
          }
          paramITPPlayer = FinderThumbPlayerProxy.f(this.weg);
          if (paramITPPlayer == null) {
            break;
          }
          paramITPPlayer = paramITPPlayer.wgl;
          if (paramITPPlayer == null) {
            break;
          }
          paramITPPlayer = paramITPPlayer.MoZ;
          if (paramITPPlayer == null) {
            break;
          }
          paramITPPlayer.playDecoderType = ((int)paramLong1);
          AppMethodBeat.o(254128);
          return;
        }
        AppMethodBeat.o(254128);
        return;
      }
      localObject1 = FinderThumbPlayerProxy.wdX;
      localObject1 = FinderThumbPlayerProxy.access$getTAG$cp();
      localStringBuilder = new StringBuilder("FTPP.onInfo#mediaCodecInfo:").append(paramLong1).append(' ');
      localObject2 = FinderThumbPlayerProxy.f(this.weg);
      if (localObject2 != null) {
        paramITPPlayer = ((s)localObject2).mediaId;
      }
      Log.i((String)localObject1, paramITPPlayer);
      if (!(paramObject instanceof TPPlayerMsg.TPMediaCodecInfo))
      {
        paramITPPlayer = FinderThumbPlayerProxy.wdX;
        Log.w(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo#mediaCodecInfo return for not codecInfo");
        AppMethodBeat.o(254128);
        return;
      }
      if (((TPPlayerMsg.TPMediaCodecInfo)paramObject).mediaType != TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO)
      {
        paramITPPlayer = FinderThumbPlayerProxy.wdX;
        Log.w(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onInfo#mediaCodecInfo return for not video type");
        AppMethodBeat.o(254128);
        return;
      }
      if (((TPPlayerMsg.TPMediaCodecInfo)paramObject).infoType == TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY) {}
      for (;;)
      {
        try
        {
          paramITPPlayer = new i(((TPPlayerMsg.TPMediaCodecInfo)paramObject).msg);
          paramObject = FinderThumbPlayerProxy.l(this.weg);
          if (paramObject != null)
          {
            if (!paramITPPlayer.optBoolean("reuseEnable")) {
              continue;
            }
            paramInt = 1;
            paramObject.Mi(paramInt);
          }
          paramObject = FinderThumbPlayerProxy.l(this.weg);
          if (paramObject != null)
          {
            if (!paramITPPlayer.optBoolean("isReuse")) {
              continue;
            }
            paramInt = 1;
            paramObject.Mj(paramInt);
          }
          paramObject = FinderThumbPlayerProxy.l(this.weg);
          if (paramObject != null) {
            paramObject.Mk(paramITPPlayer.optInt("totalCodec"));
          }
        }
        catch (Throwable paramITPPlayer)
        {
          continue;
        }
        paramITPPlayer = this.weg.getLifecycle();
        if (paramITPPlayer == null) {
          break;
        }
        FinderThumbPlayerProxy.f(this.weg);
        paramITPPlayer.a(FinderThumbPlayerProxy.l(this.weg));
        AppMethodBeat.o(254128);
        return;
        paramInt = -1;
        continue;
        paramInt = -1;
        continue;
        if (((TPPlayerMsg.TPMediaCodecInfo)paramObject).infoType == TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_EXCEPTION) {
          try
          {
            paramITPPlayer = new i(((TPPlayerMsg.TPMediaCodecInfo)paramObject).msg);
            paramObject = FinderThumbPlayerProxy.l(this.weg);
            if (paramObject != null) {
              paramObject.awO(paramITPPlayer.optString("errorCodec"));
            }
          }
          catch (Throwable paramITPPlayer) {}
        }
      }
    }
    
    public final void onPrepared(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(254126);
      p.h(paramITPPlayer, "player");
      Object localObject = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.OnPrepared() " + FinderThumbPlayerProxy.a(this.weg));
      i.b localb = this.weg.getVideoViewCallback();
      if (localb != null)
      {
        localObject = FinderThumbPlayerProxy.f(this.weg);
        if (localObject != null)
        {
          localObject = ((s)localObject).mediaId;
          localb.dH("", (String)localObject);
        }
      }
      else
      {
        if (!this.weg.wcA) {
          break label176;
        }
        this.weg.Mc(2);
      }
      for (;;)
      {
        localObject = FinderThumbPlayerProxy.j(this.weg);
        if (localObject == null) {
          break label193;
        }
        localObject = ((FinderThumbPlayerProxy.b)localObject).uJG;
        if (localObject == null) {
          break label193;
        }
        ((at)localObject).field_audioBitrate = ((int)paramITPPlayer.getPropertyLong(101));
        ((at)localObject).field_videoBitrate = ((int)paramITPPlayer.getPropertyLong(202));
        ((at)localObject).field_frameRate = ((int)paramITPPlayer.getPropertyLong(206));
        AppMethodBeat.o(254126);
        return;
        localObject = null;
        break;
        label176:
        FinderThumbPlayerProxy.b(this.weg, 1);
        paramITPPlayer.pauseDownload();
      }
      label193:
      AppMethodBeat.o(254126);
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      i.b localb = null;
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(254129);
      Object localObject3 = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onStateChange() preState:" + paramInt1 + " curState:" + paramInt2 + ' ' + FinderThumbPlayerProxy.a(this.weg));
      FinderThumbPlayerProxy.c(this.weg, paramInt2);
      if (FinderThumbPlayerProxy.f(this.weg) == null)
      {
        localObject1 = FinderThumbPlayerProxy.wdX;
        Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onStateChange() return for null");
        AppMethodBeat.o(254129);
        return;
      }
      switch (paramInt2)
      {
      }
      while ((paramInt2 == 9) || (paramInt2 == 1))
      {
        localObject1 = FinderThumbPlayerProxy.wdX;
        Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onStateChange() player stop or idle " + FinderThumbPlayerProxy.a(this.weg));
        localObject1 = this.weg.getOnPlayerStopListener();
        if (localObject1 == null) {
          break;
        }
        ((u)localObject1).dFR();
        AppMethodBeat.o(254129);
        return;
        localb = this.weg.getVideoViewCallback();
        if (localb != null)
        {
          localObject2 = FinderThumbPlayerProxy.f(this.weg);
          if (localObject2 != null) {
            localObject1 = ((s)localObject2).mediaId;
          }
          localb.dK("", (String)localObject1);
        }
        localObject1 = this.weg.getLifecycle();
        if (localObject1 != null)
        {
          FinderThumbPlayerProxy.f(this.weg);
          ((y)localObject1).dFN();
          continue;
          localObject2 = this.weg.getVideoViewCallback();
          if (localObject2 != null)
          {
            localObject3 = FinderThumbPlayerProxy.f(this.weg);
            localObject1 = localb;
            if (localObject3 != null) {
              localObject1 = ((s)localObject3).mediaId;
            }
            ((i.b)localObject2).dJ("", (String)localObject1);
          }
          localObject1 = this.weg.getLifecycle();
          if (localObject1 != null)
          {
            FinderThumbPlayerProxy.f(this.weg);
            ((y)localObject1).dFL();
            continue;
            localb = this.weg.getVideoViewCallback();
            if (localb != null)
            {
              localObject3 = FinderThumbPlayerProxy.f(this.weg);
              localObject1 = localObject2;
              if (localObject3 != null) {
                localObject1 = ((s)localObject3).mediaId;
              }
              localb.dI("", (String)localObject1);
            }
          }
        }
      }
      AppMethodBeat.o(254129);
    }
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Object localObject1 = null;
      AppMethodBeat.i(254122);
      p.h(paramSurfaceTexture, "surfaceTexture");
      Object localObject2 = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onSurfaceTextureAvailable() width:" + paramInt1 + " height:" + paramInt2 + " surfaceTexture:" + paramSurfaceTexture.hashCode() + ' ' + FinderThumbPlayerProxy.a(this.weg));
      if (FinderThumbPlayerProxy.b(this.weg) != null)
      {
        paramSurfaceTexture = FinderThumbPlayerProxy.wdX;
        localObject2 = FinderThumbPlayerProxy.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("FTPP.onSurfaceTextureAvailable() return for surface:");
        paramSurfaceTexture = FinderThumbPlayerProxy.b(this.weg);
        if (paramSurfaceTexture != null) {}
        for (paramSurfaceTexture = Integer.valueOf(paramSurfaceTexture.hashCode());; paramSurfaceTexture = null)
        {
          localStringBuilder = localStringBuilder.append(paramSurfaceTexture).append(" valid:");
          Surface localSurface = FinderThumbPlayerProxy.b(this.weg);
          paramSurfaceTexture = localObject1;
          if (localSurface != null) {
            paramSurfaceTexture = Boolean.valueOf(localSurface.isValid());
          }
          Log.i((String)localObject2, paramSurfaceTexture);
          AppMethodBeat.o(254122);
          return;
        }
      }
      FinderThumbPlayerProxy.a(this.weg, new Surface(paramSurfaceTexture));
      FinderThumbPlayerProxy.c(this.weg).setSurface(FinderThumbPlayerProxy.b(this.weg));
      this.weg.Mc(1);
      AppMethodBeat.o(254122);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(254124);
      Object localObject = FinderThumbPlayerProxy.wdX;
      localObject = FinderThumbPlayerProxy.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("FTPP.onSurfaceTextureDestroyed() surfaceTexture:");
      if (paramSurfaceTexture != null) {}
      for (int i = paramSurfaceTexture.hashCode();; i = 0)
      {
        Log.i((String)localObject, i + ' ' + FinderThumbPlayerProxy.a(this.weg));
        FinderThumbPlayerProxy.d(this.weg);
        AppMethodBeat.o(254124);
        return false;
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(254123);
      Object localObject = FinderThumbPlayerProxy.wdX;
      localObject = FinderThumbPlayerProxy.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("FTPP.onSurfaceTextureSizeChanged  surfaceTexture:");
      if (paramSurfaceTexture != null) {}
      for (int i = paramSurfaceTexture.hashCode();; i = 0)
      {
        Log.i((String)localObject, i + ' ' + paramInt1 + ' ' + paramInt2 + ' ' + FinderThumbPlayerProxy.a(this.weg));
        AppMethodBeat.o(254123);
        return;
      }
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(254125);
      paramSurfaceTexture = this.weg;
      FinderThumbPlayerProxy.a(paramSurfaceTexture, FinderThumbPlayerProxy.e(paramSurfaceTexture) + 1);
      if (FinderThumbPlayerProxy.f(this.weg) == null)
      {
        paramSurfaceTexture = FinderThumbPlayerProxy.wdX;
        Log.w(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onSurfaceTextureUpdated() return for  null.");
        AppMethodBeat.o(254125);
        return;
      }
      y localy;
      if ((FinderThumbPlayerProxy.e(this.weg) == 1) && (FinderThumbPlayerProxy.g(this.weg) == 1))
      {
        paramSurfaceTexture = FinderThumbPlayerProxy.wdX;
        Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onSurfaceTextureUpdated() background prepared first frame " + FinderThumbPlayerProxy.a(this.weg));
        FinderThumbPlayerProxy.b(this.weg, 2);
        localy = this.weg.getLifecycle();
        if (localy != null)
        {
          paramSurfaceTexture = FinderThumbPlayerProxy.f(this.weg);
          if (paramSurfaceTexture == null) {
            break label267;
          }
        }
      }
      label267:
      for (paramSurfaceTexture = paramSurfaceTexture.wgl;; paramSurfaceTexture = null)
      {
        localy.l(paramSurfaceTexture);
        FinderThumbPlayerProxy.h(this.weg).setInterceptDetach(true);
        if ((FinderThumbPlayerProxy.e(this.weg) == 1) && (FinderThumbPlayerProxy.g(this.weg) == 0))
        {
          paramSurfaceTexture = FinderThumbPlayerProxy.wdX;
          Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.onSurfaceTextureUpdated() onFirstFrameRendered " + FinderThumbPlayerProxy.a(this.weg));
          paramSurfaceTexture = this.weg.getLifecycle();
          if (paramSurfaceTexture != null)
          {
            FinderThumbPlayerProxy.f(this.weg);
            paramSurfaceTexture.Gr(FinderThumbPlayerProxy.c(this.weg).fwS());
          }
          FinderThumbPlayerProxy.i(this.weg);
        }
        AppMethodBeat.o(254125);
        return;
      }
    }
    
    public final void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(254127);
      paramITPPlayer = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "FTPP.OnVideoSizeChanged() width:" + paramLong1 + " height:" + paramLong2 + ' ' + FinderThumbPlayerProxy.a(this.weg));
      FinderThumbPlayerProxy.h(this.weg).jk((int)paramLong1, (int)paramLong2);
      AppMethodBeat.o(254127);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/video/reporter/FTPPKVReporter;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.video.reporter.a>
  {
    public static final d wei;
    
    static
    {
      AppMethodBeat.i(254134);
      wei = new d();
      AppMethodBeat.o(254134);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/video/log/FTPPLog;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.video.log.a>
  {
    public static final e wej;
    
    static
    {
      AppMethodBeat.i(254136);
      wej = new e();
      AppMethodBeat.o(254136);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(FinderThumbPlayerProxy paramFinderThumbPlayerProxy, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(254137);
      if (this.weg.wcA)
      {
        FinderThumbPlayerProxy.v(this.weg);
        i.b localb = this.weg.getVideoViewCallback();
        if (localb != null)
        {
          localb.dL("", this.qWs);
          AppMethodBeat.o(254137);
          return;
        }
      }
      AppMethodBeat.o(254137);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    g(FinderThumbPlayerProxy paramFinderThumbPlayerProxy)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnDownload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
  public static final class h
    implements com.tencent.mm.plugin.thumbplayer.b.e
  {
    h(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void JS(int paramInt)
    {
      AppMethodBeat.i(254139);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "startCdnDownload()#onStart " + FinderThumbPlayerProxy.a(this.weg) + ' ' + paramInt);
      FinderThumbPlayerProxy.u(this.weg);
      AppMethodBeat.o(254139);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.plugin.thumbplayer.b.b
  {
    i(FinderThumbPlayerProxy.b paramb) {}
    
    public final com.tencent.mm.i.h awH(String paramString)
    {
      boolean bool = true;
      AppMethodBeat.i(254140);
      p.h(paramString, "id");
      Object localObject4 = this.wek;
      paramString = com.tencent.mm.plugin.finder.utils.y.vXH;
      String str1 = ((FinderThumbPlayerProxy.b)localObject4).mediaId;
      Object localObject1 = ((FinderThumbPlayerProxy.b)localObject4).wcy.downloadUrl;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      String str2 = ((FinderThumbPlayerProxy.b)localObject4).wcy.path;
      localObject1 = ((FinderThumbPlayerProxy.b)localObject4).wcy;
      int i;
      Object localObject2;
      String str3;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject1 = ((s)localObject1).path;
        i = com.tencent.mm.modelcontrol.e.L(1, (String)localObject1);
        localObject2 = ((FinderThumbPlayerProxy.b)localObject4).uJG.field_fileFormat;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        str3 = ((FinderThumbPlayerProxy.b)localObject4).wcy.tHN.djW();
        localObject3 = ((FinderThumbPlayerProxy.b)localObject4).wcy.tHN.uIw.decodeKey;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        if (((FinderThumbPlayerProxy.b)localObject4).wcy.tHN.uIw.hot_flag != 1) {
          break label217;
        }
      }
      for (;;)
      {
        localObject3 = (h.a)localObject4;
        localObject4 = FinderThumbPlayerProxy.wdX;
        paramString = com.tencent.mm.plugin.finder.utils.y.a(str1, paramString, str2, i, (String)localObject1, str3, (String)localObject2, bool, (h.a)localObject3, FinderThumbPlayerProxy.access$getTAG$cp());
        AppMethodBeat.o(254140);
        return paramString;
        localObject1 = null;
        break;
        label217:
        bool = false;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnPreload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.plugin.thumbplayer.b.d
  {
    j(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void JS(int paramInt)
    {
      AppMethodBeat.i(254141);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "startCdnPreload()#onStart(), real start download preload task " + FinderThumbPlayerProxy.a(this.weg) + ' ' + paramInt);
      if (paramInt == -1) {
        FinderThumbPlayerProxy.p(this.weg);
      }
      AppMethodBeat.o(254141);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnPreload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-finder_release"})
  public static final class k
    implements com.tencent.mm.plugin.thumbplayer.b.b
  {
    k(FinderThumbPlayerProxy.b paramb) {}
    
    public final com.tencent.mm.i.h awH(String paramString)
    {
      AppMethodBeat.i(254142);
      p.h(paramString, "id");
      Object localObject4 = this.wel;
      long l = ((FinderThumbPlayerProxy.b)localObject4).uJG.field_totalSize;
      if (l == 0L)
      {
        AppMethodBeat.o(254142);
        return null;
      }
      paramString = com.tencent.mm.plugin.finder.utils.y.vXH;
      String str1 = ((FinderThumbPlayerProxy.b)localObject4).mediaId;
      Object localObject1 = ((FinderThumbPlayerProxy.b)localObject4).wcy.downloadUrl;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      String str2 = ((FinderThumbPlayerProxy.b)localObject4).wcy.path;
      localObject1 = ((FinderThumbPlayerProxy.b)localObject4).wcy;
      int i;
      Object localObject2;
      String str3;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject1 = ((s)localObject1).path;
        i = com.tencent.mm.modelcontrol.e.L(1, (String)localObject1);
        localObject2 = ((FinderThumbPlayerProxy.b)localObject4).uJG.field_fileFormat;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        str3 = ((FinderThumbPlayerProxy.b)localObject4).wcy.tHN.djW();
        localObject3 = ((FinderThumbPlayerProxy.b)localObject4).wcy.tHN.uIw.decodeKey;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        if (((FinderThumbPlayerProxy.b)localObject4).wcy.tHN.uIw.hot_flag != 1) {
          break label276;
        }
      }
      label276:
      for (boolean bool = true;; bool = false)
      {
        localObject3 = (g.a)localObject4;
        g.b localb = (g.b)localObject4;
        int j = (int)(((FinderThumbPlayerProxy.b)localObject4).wef * 100L / l);
        l = ((FinderThumbPlayerProxy.b)localObject4).wef;
        localObject4 = FinderThumbPlayerProxy.wdX;
        paramString = com.tencent.mm.plugin.finder.utils.y.a(str1, paramString, str2, i, (String)localObject1, str3, (String)localObject2, bool, (g.a)localObject3, localb, j, l, FinderThumbPlayerProxy.access$getTAG$cp());
        AppMethodBeat.o(254142);
        return paramString;
        localObject1 = null;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startProgressTimer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "lastNotifyMs", "", "getLastNotifyMs", "()J", "setLastNotifyMs", "(J)V", "onTimerExpired", "", "plugin-finder_release"})
  public static final class l
    implements MTimerHandler.CallBack
  {
    private long wem = -1L;
    
    l(s params) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(254143);
      long l1 = this.weg.getCurrentPlayMs();
      long l2 = this.weg.getVideoDurationMs();
      y localy = this.weg.getLifecycle();
      if (localy != null) {
        localy.dFO();
      }
      if ((this.wem == -1L) || (l1 - this.wem > 1000L))
      {
        localy = this.weg.getLifecycle();
        if (localy != null) {
          localy.a(params.wgl, (int)l1 / 1000, (int)l2 / 1000);
        }
        this.wem = l1;
      }
      AppMethodBeat.o(254143);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$stopCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "onStop", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-finder_release"})
  public static final class m
    implements com.tencent.mm.plugin.thumbplayer.b.g
  {
    m(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void a(int paramInt, com.tencent.mm.i.h paramh, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(254144);
      s locals = FinderThumbPlayerProxy.f(this.weg);
      if (locals != null)
      {
        x localx = this.weg.getDownloadCallback();
        if (localx != null) {
          localx.a(locals.tHN, paramh, paramd);
        }
      }
      paramh = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "stopCdnDownload()#onStop(), real cancel download task " + FinderThumbPlayerProxy.a(this.weg) + ' ' + paramInt);
      AppMethodBeat.o(254144);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$stopCdnPreload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "onStop", "", "ret", "", "plugin-finder_release"})
  public static final class n
    implements com.tencent.mm.plugin.thumbplayer.b.f
  {
    n(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void JR(int paramInt)
    {
      AppMethodBeat.i(254145);
      FinderThumbPlayerProxy.a locala = FinderThumbPlayerProxy.wdX;
      Log.i(FinderThumbPlayerProxy.access$getTAG$cp(), "stopCdnPreload()#onStop " + FinderThumbPlayerProxy.a(this.weg) + ' ' + paramInt);
      AppMethodBeat.o(254145);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy
 * JD-Core Version:    0.7.0.1
 */