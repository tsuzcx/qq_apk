package com.tencent.mm.plugin.finder.replay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.finder.video.ab;
import com.tencent.mm.plugin.finder.video.j;
import com.tencent.mm.plugin.finder.video.reporter.e;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.plugin.finder.video.v;
import com.tencent.mm.plugin.finder.video.w;
import com.tencent.mm.plugin.thumbplayer.e.d.a;
import com.tencent.mm.plugin.thumbplayer.view.MMTextureView;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dji;
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
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPVideoSeiInfo;
import com.tencent.tmediacodec.e.b.a;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveThumbPlayerProxy;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgPrepareStatus", "contextTag", "currSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "currentPlayState", "enableMediaCodecReuse", "", "enableRendererSharpen", "ftppTag", "", "isBuffering", "isFirstFrameRendered", "isFirstStart", "isFullScreen", "isLongVideo", "isPreviewing", "isRealStartDownloader", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isReuseForMiniWindow", "isShouldPlayResume", "()Z", "setShouldPlayResume", "(Z)V", "isStartCdn", "setStartCdn", "isStartCdnPreload", "setStartCdnPreload", "isViewFocused", "setViewFocused", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "notifyProgressTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onBufferingStartRunnable", "Ljava/lang/Runnable;", "onMuteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getOnMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setOnMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "onPlayerStopListener", "Lcom/tencent/mm/plugin/finder/replay/OnPlayerRecycleListener;", "getOnPlayerStopListener", "()Lcom/tencent/mm/plugin/finder/replay/OnPlayerRecycleListener;", "setOnPlayerStopListener", "(Lcom/tencent/mm/plugin/finder/replay/OnPlayerRecycleListener;)V", "onStopPlayData", "Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "playSpeedRatio", "", "getPlaySpeedRatio", "()F", "setPlaySpeedRatio", "(F)V", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "playerListener", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveThumbPlayerProxy$TPPlayerListener;", "prepareForFirstFrame", "seiInfoCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "seiType", "Lcom/tencent/thumbplayer/api/TPPlayerMsg$TPVideoSeiInfo;", "sei", "", "getSeiInfoCallback", "()Lkotlin/jvm/functions/Function2;", "setSeiInfoCallback", "(Lkotlin/jvm/functions/Function2;)V", "surface", "Landroid/view/Surface;", "textureUpdateTimes", "textureView", "Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "videoPlayTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "videoViewCallback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "getVideoViewCallback", "()Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setVideoViewCallback", "(Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;)V", "changePlayerState", "toState", "checkRendererSharpenLocalConfig", "getBitmap", "Landroid/graphics/Bitmap;", "getContextTag", "getCurrentPlayMs", "", "getCurrentPlaySecond", "getFTPPTag", "getFinderFluentSwitchParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "feedId", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getPlayer", "", "getProxyState", "getScaleType", "getVideoDuration", "getVideoDurationMs", "getVideoMediaId", "getVideoMediaInfo", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "handleOnBufferingEnd", "handleOnBufferingStart", "mediaId", "handleOnFirstFrameRendered", "invokeSource", "handlePlayerStateChange", "state", "init", "initFTPPTag", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "initTextureView", "mediaInfo", "isEnableFluentSwitchExit", "isFullScreenEnjoy", "isPause", "isPlaying", "isPrepared", "isPreparing", "isStartPlay", "currentState", "onRelease", "onUIDestroy", "pause", "pauseWithCancel", "play", "playInfo", "playWithSource", "source", "prepareCacheFile", "filePath", "prepareForReuseTPView2", "prepareHls", "url", "offsetSec", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)V", "prepareOnlineUrl", "prepareToFirstFrame", "prepareToPlay", "prepareVideo", "prepareforReuse", "releaseSurface", "detach", "removeVideoFooterView", "resizeTextureView", "width", "height", "seekTo", "timestamp", "", "afterSeekPlay", "mode", "setBgPrepareStatus", "status", "setContextTag", "tag", "setFinderVideoPlayTrace", "setFullScreenEnjoy", "isFull", "setIMMVideoViewCallback", "_callback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setLivePlayer", "txPlayer", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "setLoop", "loop", "setMute", "isMute", "setPlaySpeed", "ratio", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "isLocal", "feedData", "setVideoMuteListener", "muteListener", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "startInternal", "startOrPlay", "offset", "(Ljava/lang/Integer;)Z", "startProgressTimer", "info", "stop", "stopProgressTimer", "toString", "updateIsRealStartDownloader", "isRealStart", "Companion", "TPPlayerListener", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveThumbPlayerProxy
  extends FrameLayout
  implements t
{
  public static final FinderLiveThumbPlayerProxy.a FkX;
  private static final HashSet<Integer> Fly;
  private static String TAG;
  private v ANI;
  private e ANO;
  private com.tencent.mm.plugin.finder.video.reporter.d ANP;
  private i.b EAt;
  private volatile boolean ELh;
  private String FkY;
  private boolean FkZ;
  private int Fla;
  private com.tencent.mm.plugin.thumbplayer.e.a Flb;
  private b Flc;
  private MMThumbPlayerTextureView Fld;
  private SurfaceTexture Fle;
  private boolean Flf;
  private int Flg;
  private MTimerHandler Flh;
  private Runnable Fli;
  private int Flj;
  private q Flk;
  private com.tencent.mm.plugin.findersdk.f.a Fll;
  private AtomicBoolean Flm;
  public boolean Fln;
  private boolean Flo;
  private float Flp;
  private boolean Flq;
  boolean Flr;
  private boolean Fls;
  private m<? super Integer, ? super TPPlayerMsg.TPVideoSeiInfo, ah> Flt;
  private ab Flu;
  private w Flv;
  private boolean Flw;
  private boolean Flx;
  private boolean cFq;
  private int contextTag;
  private volatile int currentPlayState;
  private boolean isLongVideo;
  private MMHandler mRi;
  private boolean nvB;
  private Surface surface;
  
  static
  {
    AppMethodBeat.i(333030);
    FkX = new FinderLiveThumbPlayerProxy.a((byte)0);
    TAG = "FTPP.FinderThumbPlayerProxy";
    Fly = new HashSet();
    AppMethodBeat.o(333030);
  }
  
  public FinderLiveThumbPlayerProxy(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(332736);
    this.FkY = TAG;
    paramContext = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eVg().bmg()).intValue() == 1)
    {
      paramContext = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!com.tencent.mm.plugin.finder.storage.d.eRd()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.FkZ = bool;
      this.Flf = true;
      this.mRi = new MMHandler(Looper.getMainLooper());
      this.contextTag = -1;
      this.Flm = new AtomicBoolean(true);
      this.ANP = new com.tencent.mm.plugin.finder.video.reporter.d();
      this.Flp = 1.0F;
      init();
      AppMethodBeat.o(332736);
      return;
    }
  }
  
  public FinderLiveThumbPlayerProxy(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(332746);
    this.FkY = TAG;
    paramContext = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eVg().bmg()).intValue() == 1)
    {
      paramContext = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!com.tencent.mm.plugin.finder.storage.d.eRd()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.FkZ = bool;
      this.Flf = true;
      this.mRi = new MMHandler(Looper.getMainLooper());
      this.contextTag = -1;
      this.Flm = new AtomicBoolean(true);
      this.ANP = new com.tencent.mm.plugin.finder.video.reporter.d();
      this.Flp = 1.0F;
      init();
      AppMethodBeat.o(332746);
      return;
    }
  }
  
  public FinderLiveThumbPlayerProxy(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(332758);
    this.FkY = TAG;
    paramContext = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eVg().bmg()).intValue() == 1)
    {
      paramContext = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!com.tencent.mm.plugin.finder.storage.d.eRd()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.FkZ = bool;
      this.Flf = true;
      this.mRi = new MMHandler(Looper.getMainLooper());
      this.contextTag = -1;
      this.Flm = new AtomicBoolean(true);
      this.ANP = new com.tencent.mm.plugin.finder.video.reporter.d();
      this.Flp = 1.0F;
      init();
      AppMethodBeat.o(332758);
      return;
    }
  }
  
  private final boolean RQ(int paramInt)
  {
    Object localObject3 = null;
    AppMethodBeat.i(332787);
    Log.i(getFTPPTag(), s.X("replay_step3-3:prepareVideo(),source:", Integer.valueOf(paramInt)));
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
    Object localObject2 = this.Flb;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("player");
      localObject1 = null;
    }
    localObject2 = j.GoW;
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setPlayerOptionalParam(j.fje());
    localObject1 = this.surface;
    if (localObject1 != null)
    {
      if (!((Surface)localObject1).isValid()) {
        break label250;
      }
      if (localObject1 != null)
      {
        com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
        localObject2 = locala;
        if (locala == null)
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
    if (localObject1 == null)
    {
      s.bIx("player");
      localObject1 = localObject3;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).prepareAsync();
      RS(3);
      AppMethodBeat.o(332787);
      return true;
      label250:
      localObject1 = null;
      break;
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
    AppMethodBeat.i(332896);
    Log.i(getFTPPTag(), "changePlayerState from:" + this.currentPlayState + " to:" + paramInt);
    if ((paramInt == 4) && (this.currentPlayState != 3))
    {
      Log.w(getFTPPTag(), "changePlayerState from:" + this.currentPlayState + " to:" + paramInt + " return for error state.");
      AppMethodBeat.o(332896);
      return;
    }
    this.currentPlayState = paramInt;
    RT(this.currentPlayState);
    AppMethodBeat.o(332896);
  }
  
  private final void RT(int paramInt)
  {
    i.b localb = null;
    Object localObject1 = null;
    AppMethodBeat.i(332905);
    this.ANP.GuE = paramInt;
    if (this.ANI == null)
    {
      Log.i(getFTPPTag(), "FTPP.handlePlayerStateChange() return for null");
      AppMethodBeat.o(332905);
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
      AppMethodBeat.o(332905);
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
    }
  }
  
  private static final void a(FinderLiveThumbPlayerProxy paramFinderLiveThumbPlayerProxy, String paramString)
  {
    AppMethodBeat.i(332911);
    s.u(paramFinderLiveThumbPlayerProxy, "this$0");
    if (paramFinderLiveThumbPlayerProxy.Flr)
    {
      paramFinderLiveThumbPlayerProxy.cFq = true;
      paramFinderLiveThumbPlayerProxy = paramFinderLiveThumbPlayerProxy.getVideoViewCallback();
      if (paramFinderLiveThumbPlayerProxy != null) {
        paramFinderLiveThumbPlayerProxy.ep("", paramString);
      }
    }
    AppMethodBeat.o(332911);
  }
  
  private final void a(v paramv)
  {
    dji localdji = null;
    AppMethodBeat.i(332827);
    Object localObject2 = this.Fld;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("textureView");
      localObject1 = null;
    }
    if (((MMThumbPlayerTextureView)localObject1).getParent() != null)
    {
      localObject2 = this.Fld;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("textureView");
        localObject1 = null;
      }
      removeView((View)localObject1);
    }
    int i;
    int j;
    label352:
    float f1;
    label358:
    float f2;
    if (this.isLongVideo)
    {
      localObject1 = aw.Gjk;
      localObject1 = getContext();
      s.s(localObject1, "context");
      localObject1 = aw.a((Context)localObject1, paramv.ANK.eCF().width, paramv.ANK.eCF().height);
      i = ((Number)((kotlin.u)localObject1).bsD).intValue();
      j = ((Number)((kotlin.u)localObject1).aiuN).intValue();
      Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject3).gravity = 17;
      localObject2 = this.Fld;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("textureView");
        localObject1 = null;
      }
      addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localObject2 = this.Fld;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("textureView");
        localObject1 = null;
      }
      ((MMThumbPlayerTextureView)localObject1).mj(i, j);
      localObject1 = paramv.Grz;
      if (localObject1 != null)
      {
        localObject3 = ((dji)localObject1).aaPl;
        if (localObject3 != null)
        {
          localObject2 = this.Fld;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("textureView");
            localObject1 = null;
          }
          ((MMThumbPlayerTextureView)localObject1).setCropRect(new Rect((int)((bbn)localObject3).left, (int)((bbn)localObject3).top, (int)((bbn)localObject3).right, (int)((bbn)localObject3).bottom));
          localObject1 = this.Fld;
          if (localObject1 != null) {
            break label496;
          }
          s.bIx("textureView");
          localObject1 = localdji;
          if (paramv != null) {
            break label499;
          }
          f1 = 0.0F;
          if (paramv != null) {
            break label524;
          }
          f2 = 0.0F;
        }
      }
    }
    for (;;)
    {
      ((MMThumbPlayerTextureView)localObject1).aZ(f1, f2);
      Log.i(getFTPPTag(), "initTextureView(), isLongVideo:" + this.isLongVideo + " containerWidth:" + i + " containerHeight:" + j + ' ' + getProxyState());
      AppMethodBeat.o(332827);
      return;
      localObject1 = com.tencent.mm.plugin.finder.storage.data.i.a(paramv.ANK.eCF(), this.Flq);
      localObject2 = aw.Gjk;
      localObject2 = getContext();
      s.s(localObject2, "context");
      localObject1 = aw.i((Context)localObject2, ((Size)localObject1).getWidth(), ((Size)localObject1).getHeight());
      break;
      label496:
      break label352;
      label499:
      localdji = paramv.Grz;
      if (localdji == null)
      {
        f1 = 0.0F;
        break label358;
      }
      f1 = localdji.width;
      break label358;
      label524:
      paramv = paramv.Grz;
      if (paramv == null) {
        f2 = 0.0F;
      } else {
        f2 = paramv.height;
      }
    }
  }
  
  private final void a(String paramString, FeedData paramFeedData)
  {
    AppMethodBeat.i(332804);
    String str1 = String.valueOf(hashCode());
    Object localObject2 = this.Flb;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("player");
      localObject1 = null;
    }
    int i = localObject1.hashCode();
    boolean bool = this.Flr;
    float f = getAlpha();
    localObject1 = this.surface;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = Boolean.valueOf(((Surface)localObject1).isValid()))
    {
      int j = this.currentPlayState;
      int k = paramFeedData.getPosition();
      localObject2 = com.tencent.mm.ae.d.hF(paramFeedData.getFeedId());
      String str2 = paramFeedData.getDescription();
      paramFeedData = paramFeedData.getNickName();
      this.FkY = ("FTPP." + k + '.' + o.aBv(str2) + '.' + o.aBv(str1));
      String str3 = this.FkY;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initFTPPTag pos:").append(k).append(" mediaId:").append(paramString).append(" feedId:").append((String)localObject2).append(" nickName:").append(paramFeedData).append(" description:").append(str2).append(" viewFocus:").append(bool).append("finderThumbPlayerProxyHashCode:").append(str1).append(" playerHashCode:").append(i).append(" viewFocus:").append(this.Flr).append(" viewAlpha:").append(f).append(" surfaceIsValid:").append(localObject1).append(" playerState:");
      localStringBuilder.append(j);
      Log.i(str3, localStringBuilder.toString());
      AppMethodBeat.o(332804);
      return;
    }
  }
  
  private final void a(String paramString1, String paramString2, Integer paramInteger, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(332833);
    if (TextUtils.isEmpty((CharSequence)paramString2))
    {
      Log.w(getFTPPTag(), s.X("replay_step3-1-1:prepareHls(), return for online url:", paramString2));
      AppMethodBeat.o(332833);
      return;
    }
    Log.i(getFTPPTag(), "replay_step3-2:prepareHls(),offsetSec:" + paramInteger + ", " + getProxyState());
    com.tencent.mm.plugin.thumbplayer.e.a locala2 = this.Flb;
    com.tencent.mm.plugin.thumbplayer.e.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("player");
      locala1 = null;
    }
    locala1.setMediaId(paramString1);
    if (paramInteger != null)
    {
      int i = ((Number)paramInteger).intValue();
      paramInteger = this.Flb;
      paramString1 = paramInteger;
      if (paramInteger == null)
      {
        s.bIx("player");
        paramString1 = null;
      }
      paramString1.setPlayerOptionalParam(new TPOptionalParam().buildLong(100, i * 1000));
    }
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
      RQ(paramInt);
      AppMethodBeat.o(332833);
      return;
    }
  }
  
  private final void azE(String paramString)
  {
    ab localab2 = null;
    Object localObject = null;
    ab localab1 = null;
    AppMethodBeat.i(332869);
    if (this.ELh)
    {
      AppMethodBeat.o(332869);
      return;
    }
    if (s.p(paramString, "startInternal"))
    {
      if (this.Flg == 2)
      {
        Log.i(getFTPPTag(), s.X("FTPP.handleOnFirstFrameRendered rendered for ", Integer.valueOf(this.Flg)));
        localab2 = this.Flu;
        if (localab2 != null)
        {
          paramString = this.Flb;
          if (paramString != null) {
            break label115;
          }
          s.bIx("player");
          paramString = localab1;
        }
        label115:
        for (;;)
        {
          localab2.ph(paramString.hLd());
          this.ELh = true;
          AppMethodBeat.o(332869);
          return;
        }
      }
      Log.w(getFTPPTag(), "FTPP.handleOnFirstFrameRendered " + paramString + " return for " + this.Flg);
      AppMethodBeat.o(332869);
      return;
    }
    if (s.p(paramString, "onFirstFrameRendered")) {
      switch (this.Flg)
      {
      default: 
        Log.w(getFTPPTag(), "FTPP.handleOnFirstFrameRendered " + paramString + " return for " + this.Flg);
        AppMethodBeat.o(332869);
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
          AppMethodBeat.o(332869);
          return;
        }
      case 0: 
        Log.i(getFTPPTag(), s.X("FTPP.handleOnFirstFrameRendered onFirstFrameRendered ", getProxyState()));
        localab1 = this.Flu;
        if (localab1 != null)
        {
          paramString = this.Flb;
          if (paramString != null) {
            break label376;
          }
          s.bIx("player");
          paramString = localObject;
        }
        label376:
        for (;;)
        {
          localab1.ph(paramString.hLd());
          this.ELh = true;
          AppMethodBeat.o(332869);
          return;
        }
      }
    } else {
      Log.w(getFTPPTag(), "FTPP.handleOnFirstFrameRendered " + paramString + " return for " + this.Flg);
    }
    AppMethodBeat.o(332869);
  }
  
  private final void b(final v paramv)
  {
    AppMethodBeat.i(332880);
    Log.i(getFTPPTag(), s.X("startProgressTimer ", getProxyState()));
    if (this.Flh == null)
    {
      this.Flh = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)new e(this, paramv), true);
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
      AppMethodBeat.o(332880);
      return;
    }
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
  
  private final void eLO()
  {
    AppMethodBeat.i(332887);
    Log.i(getFTPPTag(), "stopProgressTimer :" + this.Flh + ' ' + getProxyState());
    Object localObject = this.ANI;
    if (localObject != null) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this, (v)localObject, getCurrentPlayMs(), getVideoDurationMs()));
    }
    localObject = this.Flh;
    if (localObject != null) {
      ((MTimerHandler)localObject).stopTimer();
    }
    AppMethodBeat.o(332887);
  }
  
  private final String getProxyState()
  {
    AppMethodBeat.i(332815);
    boolean bool = this.Flr;
    float f = getAlpha();
    Object localObject = this.surface;
    if (localObject == null) {}
    for (localObject = null;; localObject = Boolean.valueOf(((Surface)localObject).isValid()))
    {
      int i = this.currentPlayState;
      localObject = bool + '-' + f + '-' + localObject + '-' + i;
      AppMethodBeat.o(332815);
      return localObject;
    }
  }
  
  private final void init()
  {
    AppMethodBeat.i(332772);
    Fly.add(Integer.valueOf(hashCode()));
    Log.i(TAG, "create FinderThumbPlayerProxy " + hashCode() + ' ' + Fly);
    Object localObject1 = com.tencent.tmediacodec.e.b.ahUw;
    ((com.tencent.tmediacodec.e.b)localObject1).ahUv = b.a.ahUy;
    com.tencent.tmediacodec.a.kcn().ahSN = ((com.tencent.tmediacodec.e.b)localObject1);
    com.tencent.tmediacodec.a.kcn().OE(true);
    localObject1 = com.tencent.mm.plugin.thumbplayer.e.d.TFK;
    localObject1 = MMApplicationContext.getContext();
    s.s(localObject1, "getContext()");
    this.Flb = d.a.kr((Context)localObject1);
    this.Flc = new b();
    int i;
    Object localObject2;
    label200:
    b localb;
    if (this.FkZ)
    {
      i = 1;
      this.ANO = new e(i);
      this.ANP.reset();
      this.Fld = new MMThumbPlayerTextureView(MMApplicationContext.getContext());
      localObject2 = this.Fld;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("textureView");
        localObject1 = null;
      }
      ((MMThumbPlayerTextureView)localObject1).setOpaqueInfo(true);
      localObject1 = this.Fld;
      if (localObject1 != null) {
        break label590;
      }
      s.bIx("textureView");
      localObject1 = null;
      localb = this.Flc;
      localObject2 = localb;
      if (localb == null)
      {
        s.bIx("playerListener");
        localObject2 = null;
      }
      ((MMThumbPlayerTextureView)localObject1).setTextureListenerCallback((TextureView.SurfaceTextureListener)localObject2);
      localObject1 = this.Flb;
      if (localObject1 != null) {
        break label593;
      }
      s.bIx("player");
      localObject1 = null;
      label247:
      localb = this.Flc;
      localObject2 = localb;
      if (localb == null)
      {
        s.bIx("playerListener");
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnErrorListener((ITPPlayerListener.IOnErrorListener)localObject2);
      localObject1 = this.Flb;
      if (localObject1 != null) {
        break label596;
      }
      s.bIx("player");
      localObject1 = null;
      label296:
      localb = this.Flc;
      localObject2 = localb;
      if (localb == null)
      {
        s.bIx("playerListener");
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnPreparedListener((ITPPlayerListener.IOnPreparedListener)localObject2);
      localObject1 = this.Flb;
      if (localObject1 != null) {
        break label599;
      }
      s.bIx("player");
      localObject1 = null;
      label345:
      localb = this.Flc;
      localObject2 = localb;
      if (localb == null)
      {
        s.bIx("playerListener");
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnVideoSizeChangedListener((ITPPlayerListener.IOnVideoSizeChangedListener)localObject2);
      localObject1 = this.Flb;
      if (localObject1 != null) {
        break label602;
      }
      s.bIx("player");
      localObject1 = null;
      label394:
      localb = this.Flc;
      localObject2 = localb;
      if (localb == null)
      {
        s.bIx("playerListener");
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnPlayerStateChangeListener((ITPPlayerListener.IOnStateChangeListener)localObject2);
      localObject1 = this.Flb;
      if (localObject1 != null) {
        break label605;
      }
      s.bIx("player");
      localObject1 = null;
      label443:
      localb = this.Flc;
      localObject2 = localb;
      if (localb == null)
      {
        s.bIx("playerListener");
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnInfoListener((ITPPlayerListener.IOnInfoListener)localObject2);
      localObject1 = this.Flb;
      if (localObject1 != null) {
        break label608;
      }
      s.bIx("player");
      localObject1 = null;
      label492:
      localb = this.Flc;
      localObject2 = localb;
      if (localb == null)
      {
        s.bIx("playerListener");
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnCompletionListener((ITPPlayerListener.IOnCompletionListener)localObject2);
      localObject1 = this.Flb;
      if (localObject1 != null) {
        break label611;
      }
      s.bIx("player");
      localObject1 = null;
    }
    label590:
    label593:
    label596:
    label599:
    label602:
    label605:
    label608:
    label611:
    for (;;)
    {
      localb = this.Flc;
      localObject2 = localb;
      if (localb == null)
      {
        s.bIx("playerListener");
        localObject2 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setOnSeekCompleteListener((ITPPlayerListener.IOnSeekCompleteListener)localObject2);
      RS(1);
      AppMethodBeat.o(332772);
      return;
      i = 0;
      break;
      break label200;
      break label247;
      break label296;
      break label345;
      break label394;
      break label443;
      break label492;
    }
  }
  
  private final void setBgPrepareStatus(int paramInt)
  {
    AppMethodBeat.i(332858);
    Log.i(getFTPPTag(), "setBgPrepareStatus " + paramInt + ' ' + getProxyState());
    this.Flg = paramInt;
    AppMethodBeat.o(332858);
  }
  
  private final void startInternal()
  {
    AppMethodBeat.i(332778);
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
    AppMethodBeat.o(332778);
  }
  
  public final boolean RP(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(333207);
    Log.i(getFTPPTag(), "playWithSource() source=" + paramInt + ' ' + getProxyState() + ' ');
    if (!this.Flr)
    {
      Log.i(getFTPPTag(), s.X("playWithSource() return for isViewFocused:", Boolean.valueOf(this.Flr)));
      AppMethodBeat.o(333207);
      return false;
    }
    if (!RR(this.currentPlayState))
    {
      Log.i(getFTPPTag(), s.X("playWithSource() return for currentState:", Integer.valueOf(this.currentPlayState)));
      AppMethodBeat.o(333207);
      return false;
    }
    boolean bool = isPlaying();
    if ((bool) && (paramInt != -1))
    {
      Log.i(getFTPPTag(), s.X("playWithSource() return for isPlaying:", Boolean.valueOf(bool)));
      AppMethodBeat.o(333207);
      return false;
    }
    Object localObject1;
    if (cxs())
    {
      localObject1 = this.surface;
      if (localObject1 != null)
      {
        if (!((Surface)localObject1).isValid()) {
          break label225;
        }
        if (localObject1 != null) {
          startInternal();
        }
      }
      label193:
      localObject1 = this.Flb;
      if (localObject1 != null) {
        break label246;
      }
      s.bIx("player");
      localObject1 = localObject2;
    }
    label225:
    label246:
    for (;;)
    {
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).resumeDownload();
      AppMethodBeat.o(333207);
      return true;
      localObject1 = null;
      break;
      if (cNW()) {
        break label193;
      }
      RQ(0);
      break label193;
    }
  }
  
  public final void a(com.tencent.mm.live.core.core.c.b paramb, long paramLong)
  {
    AppMethodBeat.i(333087);
    s.u(paramb, "txPlayer");
    AppMethodBeat.o(333087);
  }
  
  public final void a(x paramx, boolean paramBoolean, FeedData paramFeedData)
  {
    AppMethodBeat.i(333057);
    s.u(paramx, "video");
    s.u(paramFeedData, "feedData");
    Object localObject = this.Fll;
    if (localObject != null) {
      ((com.tencent.mm.plugin.findersdk.f.a)localObject).aDn("setMediaInfo");
    }
    dji localdji = paramx.eCF();
    String str = localdji.url;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.ANI = new v("", (String)localObject, paramx.aUt(), localdji, paramx, paramFeedData);
    localObject = localdji.mediaId;
    paramx = (x)localObject;
    if (localObject == null) {
      paramx = "";
    }
    a(paramx, paramFeedData);
    paramx = this.ANI;
    s.checkNotNull(paramx);
    a(paramx);
    this.ANP.reset();
    paramx = this.ANP;
    paramFeedData = this.ANI;
    s.checkNotNull(paramFeedData);
    paramx.init(paramFeedData.mediaId);
    this.ANP.fjU();
    AppMethodBeat.o(333057);
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(333293);
    if (!RR(this.currentPlayState))
    {
      AppMethodBeat.o(333293);
      return false;
    }
    if (!cxs())
    {
      AppMethodBeat.o(333293);
      return false;
    }
    Log.i(getFTPPTag(), "seekTo " + paramDouble + ' ' + paramBoolean);
    com.tencent.mm.plugin.thumbplayer.e.a locala2 = this.Flb;
    com.tencent.mm.plugin.thumbplayer.e.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("player");
      locala1 = null;
    }
    locala1.seekTo(kotlin.h.a.ah(1000.0D * paramDouble), paramInt);
    if (paramBoolean) {
      bNU();
    }
    AppMethodBeat.o(333293);
    return true;
  }
  
  public final boolean b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(333286);
    paramBoolean = a(paramDouble, paramBoolean, 3);
    AppMethodBeat.o(333286);
    return paramBoolean;
  }
  
  public final boolean bNU()
  {
    AppMethodBeat.i(333197);
    Log.i(getFTPPTag(), "play()");
    boolean bool = RP(0);
    AppMethodBeat.o(333197);
    return bool;
  }
  
  public final boolean boa()
  {
    return this.nvB;
  }
  
  public final boolean eLI()
  {
    AppMethodBeat.i(333226);
    Log.i(getFTPPTag(), s.X("prepareToPlay()  ", getProxyState()));
    if (RR(this.currentPlayState))
    {
      if (this.currentPlayState == 2)
      {
        boolean bool = RQ(1);
        AppMethodBeat.o(333226);
        return bool;
      }
      AppMethodBeat.o(333226);
      return false;
    }
    v localv = this.ANI;
    if (localv != null)
    {
      a(localv.mediaId, localv.path, null, 102);
      AppMethodBeat.o(333226);
      return true;
    }
    AppMethodBeat.o(333226);
    return false;
  }
  
  public final boolean eLJ()
  {
    AppMethodBeat.i(333234);
    Log.i(getFTPPTag(), s.X("prepareToPlay()  ", getProxyState()));
    this.Flo = true;
    boolean bool = eLI();
    AppMethodBeat.o(333234);
    return bool;
  }
  
  public final int eLK()
  {
    AppMethodBeat.i(333254);
    Log.i(getFTPPTag(), s.X("pauseWithCancel ", getProxyState()));
    this.ANP.fjV();
    pause();
    AppMethodBeat.o(333254);
    return 0;
  }
  
  public final void eLL() {}
  
  public final void eLM() {}
  
  public final boolean eLN()
  {
    return false;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(333074);
    MMThumbPlayerTextureView localMMThumbPlayerTextureView = this.Fld;
    Object localObject = localMMThumbPlayerTextureView;
    if (localMMThumbPlayerTextureView == null)
    {
      s.bIx("textureView");
      localObject = null;
    }
    localObject = ((MMThumbPlayerTextureView)localObject).getBitmap();
    AppMethodBeat.o(333074);
    return localObject;
  }
  
  public final int getContextTag()
  {
    return this.contextTag;
  }
  
  public final long getCurrentPlayMs()
  {
    AppMethodBeat.i(333108);
    com.tencent.mm.plugin.thumbplayer.e.a locala2 = this.Flb;
    com.tencent.mm.plugin.thumbplayer.e.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("player");
      locala1 = null;
    }
    long l = locala1.getCurrentPositionMs();
    AppMethodBeat.o(333108);
    return l;
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(333104);
    com.tencent.mm.plugin.thumbplayer.e.a locala2 = this.Flb;
    com.tencent.mm.plugin.thumbplayer.e.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("player");
      locala1 = null;
    }
    int i = (int)(locala1.getCurrentPositionMs() / 1000L);
    AppMethodBeat.o(333104);
    return i;
  }
  
  public final String getFTPPTag()
  {
    AppMethodBeat.i(333453);
    String str = this.FkY + '.' + this.Flr;
    AppMethodBeat.o(333453);
    return str;
  }
  
  public final boolean getIsNeverStart()
  {
    AppMethodBeat.i(333147);
    if (!RR(this.currentPlayState))
    {
      AppMethodBeat.o(333147);
      return true;
    }
    AppMethodBeat.o(333147);
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
  
  public final w getOnMuteListener()
  {
    return this.Flv;
  }
  
  public final q getOnPlayerStopListener()
  {
    return this.Flk;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(333154);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(333154);
    return localViewParent;
  }
  
  public final float getPlaySpeedRatio()
  {
    return this.Flp;
  }
  
  public final Object getPlayer()
  {
    AppMethodBeat.i(333432);
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
    if (locala == null)
    {
      s.bIx("player");
      AppMethodBeat.o(333432);
      return null;
    }
    AppMethodBeat.o(333432);
    return locala;
  }
  
  public final int getScaleType()
  {
    AppMethodBeat.i(333356);
    MMThumbPlayerTextureView localMMThumbPlayerTextureView2 = this.Fld;
    MMThumbPlayerTextureView localMMThumbPlayerTextureView1 = localMMThumbPlayerTextureView2;
    if (localMMThumbPlayerTextureView2 == null)
    {
      s.bIx("textureView");
      localMMThumbPlayerTextureView1 = null;
    }
    int i = localMMThumbPlayerTextureView1.getScaleType();
    AppMethodBeat.o(333356);
    return i;
  }
  
  public final m<Integer, TPPlayerMsg.TPVideoSeiInfo, ah> getSeiInfoCallback()
  {
    return this.Flt;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(333113);
    com.tencent.mm.plugin.thumbplayer.e.a locala2 = this.Flb;
    com.tencent.mm.plugin.thumbplayer.e.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("player");
      locala1 = null;
    }
    int i = (int)(locala1.getDurationMs() / 1000L);
    AppMethodBeat.o(333113);
    return i;
  }
  
  public final long getVideoDurationMs()
  {
    AppMethodBeat.i(333117);
    com.tencent.mm.plugin.thumbplayer.e.a locala2 = this.Flb;
    com.tencent.mm.plugin.thumbplayer.e.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("player");
      locala1 = null;
    }
    long l = locala1.getDurationMs();
    AppMethodBeat.o(333117);
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
    Object localObject2 = null;
    AppMethodBeat.i(333467);
    MMThumbPlayerTextureView localMMThumbPlayerTextureView = this.Fld;
    Object localObject1 = localMMThumbPlayerTextureView;
    if (localMMThumbPlayerTextureView == null)
    {
      s.bIx("textureView");
      localObject1 = null;
    }
    ((MMThumbPlayerTextureView)localObject1).getLayoutParams().width = paramInt1;
    localMMThumbPlayerTextureView = this.Fld;
    localObject1 = localMMThumbPlayerTextureView;
    if (localMMThumbPlayerTextureView == null)
    {
      s.bIx("textureView");
      localObject1 = null;
    }
    ((MMThumbPlayerTextureView)localObject1).getLayoutParams().height = paramInt2;
    localMMThumbPlayerTextureView = this.Fld;
    localObject1 = localMMThumbPlayerTextureView;
    if (localMMThumbPlayerTextureView == null)
    {
      s.bIx("textureView");
      localObject1 = null;
    }
    ((MMThumbPlayerTextureView)localObject1).mj(paramInt1, paramInt2);
    localObject1 = this.Fld;
    if (localObject1 == null)
    {
      s.bIx("textureView");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((MMThumbPlayerTextureView)localObject1).requestLayout();
      AppMethodBeat.o(333467);
      return;
    }
  }
  
  public final boolean isPlaying()
  {
    return this.currentPlayState == 5;
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(333440);
    Log.i(getFTPPTag(), "release FinderThumbPlayerProxy " + hashCode() + ' ' + getProxyState());
    this.ANO = null;
    Log.i(getFTPPTag(), "releaseSurface " + getProxyState() + ", isReusing = " + this.Fln + ", detach = true");
    Object localObject2;
    Object localObject1;
    if (this.surface != null)
    {
      localObject2 = this.Flb;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("player");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).setSurface(null);
      localObject1 = this.surface;
      if (localObject1 != null) {
        ((Surface)localObject1).release();
      }
      localObject2 = this.Fld;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("textureView");
        localObject1 = null;
      }
    }
    try
    {
      ((MMTextureView)localObject1).setInterceptDetach(false);
      ((MMTextureView)localObject1).fjo();
      localObject2 = TextureView.class.getMethod("destroyHardwareLayer", new Class[0]);
      ((Method)localObject2).setAccessible(true);
      ((Method)localObject2).invoke(localObject1, new Object[0]);
      localObject2 = TextureView.class.getMethod("releaseSurfaceTexture", new Class[0]);
      ((Method)localObject2).setAccessible(true);
      ((Method)localObject2).invoke(localObject1, new Object[0]);
      label228:
      this.surface = null;
      this.Fle = null;
      com.tencent.mm.ae.d.e(TAG, (kotlin.g.a.a)new d(this));
      Fly.remove(Integer.valueOf(hashCode()));
      this.Flv = null;
      AppMethodBeat.o(333440);
      return;
    }
    catch (Exception localException)
    {
      break label228;
    }
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(333276);
    Log.i(getFTPPTag(), "onUIDestroy " + getProxyState() + " isReUser:" + this.Fln);
    stop();
    this.EAt = null;
    this.Flt = null;
    this.Flo = false;
    AppMethodBeat.o(333276);
  }
  
  public final boolean pause()
  {
    Object localObject2 = null;
    AppMethodBeat.i(333246);
    if (!RR(this.currentPlayState))
    {
      Log.i(getFTPPTag(), s.X("pause() return for state:", Integer.valueOf(this.currentPlayState)));
      AppMethodBeat.o(333246);
      return false;
    }
    Log.i(getFTPPTag(), s.X("pause()  ", getProxyState()));
    Object localObject1;
    if (isPlaying())
    {
      com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
      localObject1 = locala;
      if (locala == null)
      {
        s.bIx("player");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).pause();
      localObject1 = this.Flb;
      if (localObject1 == null)
      {
        s.bIx("player");
        localObject1 = localObject2;
        ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).pauseDownload();
        RS(6);
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
      AppMethodBeat.o(333246);
      return true;
      break;
      if ((cNW()) && (!this.Flr))
      {
        long l = System.currentTimeMillis();
        stop();
        Log.i(getFTPPTag(), "pause() preparing stop cost=" + (System.currentTimeMillis() - l) + "ms");
      }
    }
  }
  
  public final com.tencent.mm.plugin.finder.live.fluent.h pu(long paramLong)
  {
    return null;
  }
  
  public final boolean r(Integer paramInteger)
  {
    AppMethodBeat.i(333219);
    Log.i(getFTPPTag(), s.X("replay_step3-1:startOrPlay() ", getProxyState()));
    this.ANP.fjU();
    if (!this.Flr)
    {
      Log.i(getFTPPTag(), s.X("replay_step3-1-1:startOrPlay() return for isViewFocused:", Boolean.valueOf(this.Flr)));
      AppMethodBeat.o(333219);
      return false;
    }
    Object localObject = this.Fll;
    if (localObject != null) {
      ((com.tencent.mm.plugin.findersdk.f.a)localObject).aDn("startOrPlay");
    }
    if (this.Flf)
    {
      Log.i(getFTPPTag(), "replay_step3-1-1:startOrPlay() first time to play");
      localObject = this.Flu;
      if (localObject != null) {
        ((ab)localObject).a(this.ANO);
      }
      localObject = this.Flu;
      if (localObject != null) {
        ((ab)localObject).a(this.ANI, this.Flg);
      }
      this.Flf = false;
      com.tencent.mm.plugin.report.service.h.OAn.p(1505L, 252L, 1L);
    }
    if (RR(this.currentPlayState))
    {
      Log.i(getFTPPTag(), s.X("replay_step3-1-1:startOrPlay() return for currentPlayState:", Integer.valueOf(this.currentPlayState)));
      if (RP(3)) {
        this.Flj = 0;
      }
      AppMethodBeat.o(333219);
      return false;
    }
    localObject = this.ANI;
    if (localObject != null)
    {
      a(((v)localObject).mediaId, ((v)localObject).path, paramInteger, 101);
      AppMethodBeat.o(333219);
      return true;
    }
    AppMethodBeat.o(333219);
    return false;
  }
  
  public final void setContextTag(int paramInt)
  {
    this.contextTag = paramInt;
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
    AppMethodBeat.i(333327);
    s.u(paramb, "_callback");
    this.EAt = paramb;
    AppMethodBeat.o(333327);
  }
  
  public final void setIOnlineVideoProxy(f paramf)
  {
    AppMethodBeat.i(333363);
    s.u(paramf, "_proxy");
    AppMethodBeat.o(333363);
  }
  
  public final void setInterceptDetach(boolean paramBoolean)
  {
    AppMethodBeat.i(333188);
    MMThumbPlayerTextureView localMMThumbPlayerTextureView2 = this.Fld;
    MMThumbPlayerTextureView localMMThumbPlayerTextureView1 = localMMThumbPlayerTextureView2;
    if (localMMThumbPlayerTextureView2 == null)
    {
      s.bIx("textureView");
      localMMThumbPlayerTextureView1 = null;
    }
    localMMThumbPlayerTextureView1.setInterceptDetach(paramBoolean);
    AppMethodBeat.o(333188);
  }
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    AppMethodBeat.i(333162);
    Log.i(getFTPPTag(), "setIsShouldPlayResume() " + paramBoolean + ' ' + getProxyState());
    this.Fls = paramBoolean;
    AppMethodBeat.o(333162);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean) {}
  
  public final void setLifecycle(ab paramab)
  {
    this.Flu = paramab;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(333378);
    com.tencent.mm.plugin.thumbplayer.e.a locala2 = this.Flb;
    com.tencent.mm.plugin.thumbplayer.e.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("player");
      locala1 = null;
    }
    locala1.setLoopback(paramBoolean);
    AppMethodBeat.o(333378);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(333307);
    com.tencent.mm.plugin.thumbplayer.e.a locala2 = this.Flb;
    com.tencent.mm.plugin.thumbplayer.e.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("player");
      locala1 = null;
    }
    locala1.setOutputMute(paramBoolean);
    AppMethodBeat.o(333307);
  }
  
  public final void setOnMuteListener(w paramw)
  {
    this.Flv = paramw;
  }
  
  public final void setOnPlayerStopListener(q paramq)
  {
    this.Flk = paramq;
  }
  
  public final void setPlaySpeed(float paramFloat)
  {
    long l = 0L;
    Object localObject2 = null;
    AppMethodBeat.i(333477);
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
      AppMethodBeat.o(333477);
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
  
  public final void setScaleType(i.e parame)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    AppMethodBeat.i(333348);
    s.u(parame, "scaleType");
    switch (c.$EnumSwitchMapping$0[parame.ordinal()])
    {
    default: 
      AppMethodBeat.o(333348);
      return;
    case 1: 
      parame = this.Fld;
      if (parame == null)
      {
        s.bIx("textureView");
        parame = localObject1;
      }
      for (;;)
      {
        parame.setScaleType(0);
        AppMethodBeat.o(333348);
        return;
      }
    case 2: 
      parame = this.Fld;
      if (parame == null)
      {
        s.bIx("textureView");
        parame = localObject2;
      }
      for (;;)
      {
        parame.setScaleType(1);
        AppMethodBeat.o(333348);
        return;
      }
    }
    parame = this.Fld;
    if (parame == null)
    {
      s.bIx("textureView");
      parame = localObject3;
    }
    for (;;)
    {
      parame.setScaleType(3);
      break;
    }
  }
  
  public final void setSeiInfoCallback(m<? super Integer, ? super TPPlayerMsg.TPVideoSeiInfo, ah> paramm)
  {
    this.Flt = paramm;
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
    AppMethodBeat.i(333418);
    s.u(paramw, "muteListener");
    this.Flv = paramw;
    AppMethodBeat.o(333418);
  }
  
  public final void setVideoPlayLifecycle(ab paramab)
  {
    AppMethodBeat.i(333400);
    s.u(paramab, "lifecycle");
    this.Flu = paramab;
    AppMethodBeat.o(333400);
  }
  
  public final void setVideoViewCallback(i.b paramb)
  {
    this.EAt = paramb;
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(333170);
    Log.i(getFTPPTag(), "setVideoViewFocused " + paramBoolean + ' ' + getProxyState());
    this.Flr = paramBoolean;
    AppMethodBeat.o(333170);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.Flr = paramBoolean;
  }
  
  public final void stop()
  {
    Object localObject2 = null;
    AppMethodBeat.i(333267);
    long l = SystemClock.elapsedRealtime();
    Log.i(getFTPPTag(), s.X("stop ", getProxyState()));
    if (!RR(this.currentPlayState)) {
      Log.i(getFTPPTag(), "stop return for isStartPlay onPlayerStopListener:" + this.Flk + ". " + getProxyState());
    }
    Object localObject1 = this.Flu;
    if (localObject1 != null) {
      ((ab)localObject1).a(this.ANI, this.ANP.fjS());
    }
    RS(8);
    com.tencent.mm.plugin.thumbplayer.e.a locala = this.Flb;
    localObject1 = locala;
    if (locala == null)
    {
      s.bIx("player");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).stop();
    RS(9);
    locala = this.Flb;
    localObject1 = locala;
    if (locala == null)
    {
      s.bIx("player");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.thumbplayer.e.a)localObject1).reset();
    RS(1);
    localObject1 = this.Fld;
    if (localObject1 == null)
    {
      s.bIx("textureView");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((MMThumbPlayerTextureView)localObject1).reset();
      this.ANP.reset();
      eLO();
      this.Flf = true;
      this.ELh = false;
      setBgPrepareStatus(0);
      Log.i(getFTPPTag(), s.X("stop end time:", Long.valueOf(SystemClock.elapsedRealtime() - l)));
      AppMethodBeat.o(333267);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(333479);
    String str = getFTPPTag();
    AppMethodBeat.o(333479);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveThumbPlayerProxy$TPPlayerListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnPreparedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnVideoSizeChangedListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnInfoListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnCompletionListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnErrorListener;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnSeekCompleteListener;", "(Lcom/tencent/mm/plugin/finder/replay/FinderLiveThumbPlayerProxy;)V", "onCompletion", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onError", "errorType", "", "errorCode", "arg1", "", "arg2", "onInfo", "what", "extraObject", "", "onPrepared", "onSeekComplete", "onStateChange", "preState", "curState", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "surface", "onVideoSizeChanged", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements TextureView.SurfaceTextureListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnVideoSizeChangedListener
  {
    public b()
    {
      AppMethodBeat.i(332575);
      AppMethodBeat.o(332575);
    }
    
    public final void onCompletion(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(332642);
      FinderLiveThumbPlayerProxy.a(this.Flz, 7);
      Log.i(this.Flz.getFTPPTag(), s.X("FTPP.onCompletion() ", FinderLiveThumbPlayerProxy.b(this.Flz)));
      i.b localb = this.Flz.getVideoViewCallback();
      if (localb != null)
      {
        paramITPPlayer = FinderLiveThumbPlayerProxy.j(this.Flz);
        if (paramITPPlayer != null) {
          break label77;
        }
      }
      label77:
      for (paramITPPlayer = null;; paramITPPlayer = paramITPPlayer.mediaId)
      {
        localb.em("", paramITPPlayer);
        AppMethodBeat.o(332642);
        return;
      }
    }
    
    public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(332648);
      s.u(paramITPPlayer, "player");
      Log.i(this.Flz.getFTPPTag(), "FTPP.onError() " + paramInt1 + ' ' + paramInt2 + " bgPrepareStatus:" + FinderLiveThumbPlayerProxy.p(this.Flz) + ' ' + FinderLiveThumbPlayerProxy.b(this.Flz));
      if (FinderLiveThumbPlayerProxy.p(this.Flz) != 0)
      {
        paramITPPlayer.reset();
        this.Flz.eLI();
        AppMethodBeat.o(332648);
        return;
      }
      paramITPPlayer = FinderLiveThumbPlayerProxy.j(this.Flz);
      if (paramITPPlayer != null)
      {
        i.b localb = this.Flz.getVideoViewCallback();
        if (localb != null) {
          localb.d("", paramITPPlayer.mediaId, "", paramInt2, paramInt1);
        }
      }
      AppMethodBeat.o(332648);
    }
    
    public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      paramITPPlayer = null;
      Object localObject1 = null;
      StringBuilder localStringBuilder1 = null;
      Object localObject2 = null;
      StringBuilder localStringBuilder2 = null;
      AppMethodBeat.i(332630);
      Log.i(this.Flz.getFTPPTag(), "FTPP.onInfo() what:" + paramInt + " arg1:" + paramLong1 + " arg2:" + paramLong2 + " extraObject:" + paramObject + ' ' + FinderLiveThumbPlayerProxy.b(this.Flz));
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(332630);
        return;
        Log.i(this.Flz.getFTPPTag(), "FTPP.onInfo#onBufferingStart() pos:" + this.Flz.getCurrentPlayMs() + ' ' + FinderLiveThumbPlayerProxy.b(this.Flz));
        paramObject = this.Flz;
        paramITPPlayer = FinderLiveThumbPlayerProxy.j(this.Flz);
        if (paramITPPlayer == null) {}
        for (paramITPPlayer = localStringBuilder2;; paramITPPlayer = paramITPPlayer.mediaId)
        {
          FinderLiveThumbPlayerProxy.b(paramObject, paramITPPlayer);
          AppMethodBeat.o(332630);
          return;
        }
        Log.i(this.Flz.getFTPPTag(), "FTPP.onInfo#onBufferingEnd() pos:" + this.Flz.getCurrentPlayMs() + ' ' + FinderLiveThumbPlayerProxy.b(this.Flz));
        FinderLiveThumbPlayerProxy.n(this.Flz);
        AppMethodBeat.o(332630);
        return;
        Log.i(this.Flz.getFTPPTag(), s.X("FTPP.onInfo#onReplay() ", FinderLiveThumbPlayerProxy.b(this.Flz)));
        paramITPPlayer = this.Flz.getLifecycle();
        if (paramITPPlayer != null)
        {
          FinderLiveThumbPlayerProxy.j(this.Flz);
          paramITPPlayer.eCP();
          AppMethodBeat.o(332630);
          return;
          Log.i(this.Flz.getFTPPTag(), s.X("FTPP.onInfo#firstVideoFrameRendered ", FinderLiveThumbPlayerProxy.b(this.Flz)));
          FinderLiveThumbPlayerProxy.c(this.Flz, "onFirstFrameRendered");
          paramObject = FinderLiveThumbPlayerProxy.d(this.Flz);
          if (paramObject != null) {
            paramObject.gG("onRendered");
          }
          paramObject = FinderLiveThumbPlayerProxy.c(this.Flz);
          localObject1 = FinderLiveThumbPlayerProxy.d(this.Flz);
          if (localObject1 == null) {}
          for (;;)
          {
            paramObject.GuS = paramITPPlayer;
            paramITPPlayer = this.Flz.getLifecycle();
            if (paramITPPlayer == null) {
              break;
            }
            FinderLiveThumbPlayerProxy.j(this.Flz);
            paramITPPlayer.a(FinderLiveThumbPlayerProxy.d(this.Flz));
            AppMethodBeat.o(332630);
            return;
            paramITPPlayer = ((com.tencent.mm.plugin.findersdk.f.a)localObject1).ftd();
          }
          Log.i(this.Flz.getFTPPTag(), s.X("FTPP.onInfo#firstAudioFrameRendered ", FinderLiveThumbPlayerProxy.b(this.Flz)));
          AppMethodBeat.o(332630);
          return;
          if ((paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo))
          {
            Log.i(this.Flz.getFTPPTag(), s.X("FTPP.onInfo#downloadProgressUpdate: ", Long.valueOf(((TPPlayerMsg.TPDownLoadProgressInfo)paramObject).playableDurationMS)));
            AppMethodBeat.o(332630);
            return;
            paramObject = this.Flz.getFTPPTag();
            localStringBuilder1 = new StringBuilder("FTPP.onInfo#videoDecodeType:").append(paramLong1).append(' ');
            paramITPPlayer = FinderLiveThumbPlayerProxy.j(this.Flz);
            if (paramITPPlayer == null)
            {
              paramITPPlayer = null;
              label623:
              Log.i(paramObject, paramITPPlayer);
              paramITPPlayer = FinderLiveThumbPlayerProxy.j(this.Flz);
              if (paramITPPlayer != null) {
                break label723;
              }
              paramITPPlayer = null;
              label651:
              if (paramITPPlayer == null)
              {
                paramITPPlayer = FinderLiveThumbPlayerProxy.j(this.Flz);
                if (paramITPPlayer != null) {
                  break label745;
                }
                paramITPPlayer = null;
                label669:
                if (paramITPPlayer != null) {
                  paramITPPlayer.aaPt = new FinderMediaReportObject();
                }
              }
              paramITPPlayer = FinderLiveThumbPlayerProxy.j(this.Flz);
              if (paramITPPlayer != null) {
                break label753;
              }
              paramITPPlayer = (ITPPlayer)localObject1;
            }
            while (paramITPPlayer != null)
            {
              paramITPPlayer.playDecoderType = ((int)paramLong1);
              AppMethodBeat.o(332630);
              return;
              paramITPPlayer = paramITPPlayer.mediaId;
              break label623;
              label723:
              paramITPPlayer = paramITPPlayer.Grz;
              if (paramITPPlayer == null)
              {
                paramITPPlayer = null;
                break label651;
              }
              paramITPPlayer = paramITPPlayer.aaPt;
              break label651;
              label745:
              paramITPPlayer = paramITPPlayer.Grz;
              break label669;
              label753:
              paramObject = paramITPPlayer.Grz;
              paramITPPlayer = (ITPPlayer)localObject1;
              if (paramObject != null) {
                paramITPPlayer = paramObject.aaPt;
              }
            }
            localObject1 = this.Flz.getFTPPTag();
            localStringBuilder2 = new StringBuilder("FTPP.onInfo#mediaCodecInfo:").append(paramLong1).append(' ');
            paramITPPlayer = FinderLiveThumbPlayerProxy.j(this.Flz);
            if (paramITPPlayer == null) {}
            for (paramITPPlayer = localStringBuilder1;; paramITPPlayer = paramITPPlayer.mediaId)
            {
              Log.i((String)localObject1, paramITPPlayer);
              if ((paramObject instanceof TPPlayerMsg.TPMediaCodecInfo)) {
                break;
              }
              Log.w(this.Flz.getFTPPTag(), "FTPP.onInfo#mediaCodecInfo return for not codecInfo");
              AppMethodBeat.o(332630);
              return;
            }
            if (((TPPlayerMsg.TPMediaCodecInfo)paramObject).mediaType != TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO)
            {
              Log.w(this.Flz.getFTPPTag(), "FTPP.onInfo#mediaCodecInfo return for not video type");
              AppMethodBeat.o(332630);
              return;
            }
            if (((TPPlayerMsg.TPMediaCodecInfo)paramObject).infoType == TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY) {}
            for (;;)
            {
              try
              {
                paramITPPlayer = new com.tencent.mm.ad.i(((TPPlayerMsg.TPMediaCodecInfo)paramObject).msg);
                paramObject = FinderLiveThumbPlayerProxy.o(this.Flz);
                if (paramObject != null)
                {
                  if (!paramITPPlayer.optBoolean("reuseEnable")) {
                    continue;
                  }
                  paramInt = 1;
                  paramObject.Guq = paramInt;
                }
                paramObject = FinderLiveThumbPlayerProxy.o(this.Flz);
                if (paramObject != null)
                {
                  if (!paramITPPlayer.optBoolean("isReuse")) {
                    continue;
                  }
                  paramInt = 1;
                  paramObject.Gur = paramInt;
                }
                paramObject = FinderLiveThumbPlayerProxy.o(this.Flz);
                if (paramObject != null) {
                  paramObject.Gut = paramITPPlayer.optInt("totalCodec");
                }
              }
              finally
              {
                continue;
              }
              paramITPPlayer = this.Flz.getLifecycle();
              if (paramITPPlayer == null) {
                break;
              }
              FinderLiveThumbPlayerProxy.j(this.Flz);
              paramITPPlayer.a(FinderLiveThumbPlayerProxy.o(this.Flz));
              AppMethodBeat.o(332630);
              return;
              paramInt = -1;
              continue;
              paramInt = -1;
              continue;
              if (((TPPlayerMsg.TPMediaCodecInfo)paramObject).infoType == TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_EXCEPTION) {
                try
                {
                  paramITPPlayer = new com.tencent.mm.ad.i(((TPPlayerMsg.TPMediaCodecInfo)paramObject).msg);
                  paramObject = FinderLiveThumbPlayerProxy.o(this.Flz);
                  if (paramObject != null) {
                    paramObject.Gus = paramITPPlayer.optString("errorCodec");
                  }
                }
                finally {}
              }
            }
            paramITPPlayer = localObject2;
            if ((paramObject instanceof TPPlayerMsg.TPVideoSeiInfo)) {
              paramITPPlayer = (TPPlayerMsg.TPVideoSeiInfo)paramObject;
            }
            if (paramITPPlayer != null)
            {
              localObject1 = this.Flz.getSeiInfoCallback();
              if (localObject1 != null) {
                ((m)localObject1).invoke(Integer.valueOf(paramITPPlayer.videoSeiType), paramObject);
              }
            }
          }
        }
      }
    }
    
    public final void onPrepared(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(332607);
      s.u(paramITPPlayer, "player");
      Log.i(this.Flz.getFTPPTag(), s.X("FTPP.OnPrepared() ", FinderLiveThumbPlayerProxy.b(this.Flz)));
      Object localObject = FinderLiveThumbPlayerProxy.d(this.Flz);
      if (localObject != null) {
        ((com.tencent.mm.plugin.findersdk.f.a)localObject).aDn("onPrepared");
      }
      FinderLiveThumbPlayerProxy.a(this.Flz, 4);
      i.b localb = this.Flz.getVideoViewCallback();
      if (localb != null)
      {
        localObject = FinderLiveThumbPlayerProxy.j(this.Flz);
        if (localObject == null)
        {
          localObject = null;
          localb.el("", (String)localObject);
        }
      }
      else
      {
        if ((!this.Flz.Flr) || (FinderLiveThumbPlayerProxy.k(this.Flz))) {
          break label148;
        }
        this.Flz.RP(2);
      }
      for (;;)
      {
        FinderLiveThumbPlayerProxy.m(this.Flz);
        AppMethodBeat.o(332607);
        return;
        localObject = ((v)localObject).mediaId;
        break;
        label148:
        FinderLiveThumbPlayerProxy.l(this.Flz);
        paramITPPlayer.pauseDownload();
      }
    }
    
    public final void onSeekComplete(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(332656);
      i.b localb = this.Flz.getVideoViewCallback();
      if (localb != null) {
        localb.onSeekComplete(paramITPPlayer);
      }
      AppMethodBeat.o(332656);
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(332636);
      Log.i(this.Flz.getFTPPTag(), "FTPP.onStateChange() preState:" + paramInt1 + " curState:" + paramInt2 + ' ' + FinderLiveThumbPlayerProxy.b(this.Flz));
      AppMethodBeat.o(332636);
    }
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Object localObject1 = null;
      Object localObject2 = null;
      AppMethodBeat.i(332584);
      s.u(paramSurfaceTexture, "surfaceTexture");
      Log.i(this.Flz.getFTPPTag(), "FTPP.onSurfaceTextureAvailable() width:" + paramInt1 + " height:" + paramInt2 + " surfaceTexture:" + paramSurfaceTexture.hashCode() + ' ' + FinderLiveThumbPlayerProxy.b(this.Flz));
      Object localObject3 = FinderLiveThumbPlayerProxy.d(this.Flz);
      if (localObject3 != null) {
        ((com.tencent.mm.plugin.findersdk.f.a)localObject3).aDn("onSurfaceAva");
      }
      if (FinderLiveThumbPlayerProxy.e(this.Flz) != null)
      {
        if (Build.VERSION.SDK_INT < 26)
        {
          paramSurfaceTexture = Boolean.FALSE;
          localObject3 = this.Flz.getFTPPTag();
          StringBuilder localStringBuilder = new StringBuilder("FTPP.onSurfaceTextureAvailable() return for surface:");
          localObject1 = FinderLiveThumbPlayerProxy.e(this.Flz);
          if (localObject1 != null) {
            break label315;
          }
          localObject1 = null;
          label166:
          localStringBuilder = localStringBuilder.append(localObject1).append(" valid:");
          localObject1 = FinderLiveThumbPlayerProxy.e(this.Flz);
          if (localObject1 != null) {
            break label328;
          }
          localObject1 = null;
          label198:
          Log.i((String)localObject3, localObject1 + " released:" + paramSurfaceTexture + " isReusing:" + FinderLiveThumbPlayerProxy.g(this.Flz));
          paramSurfaceTexture = FinderLiveThumbPlayerProxy.h(this.Flz);
          if (paramSurfaceTexture != null) {
            break label341;
          }
          s.bIx("textureView");
          paramSurfaceTexture = localObject2;
        }
        label315:
        label328:
        label341:
        for (;;)
        {
          localObject1 = FinderLiveThumbPlayerProxy.f(this.Flz);
          s.checkNotNull(localObject1);
          paramSurfaceTexture.setSurfaceTexture((SurfaceTexture)localObject1);
          AppMethodBeat.o(332584);
          return;
          paramSurfaceTexture = FinderLiveThumbPlayerProxy.f(this.Flz);
          if (paramSurfaceTexture == null)
          {
            paramSurfaceTexture = null;
            break;
          }
          paramSurfaceTexture = Boolean.valueOf(paramSurfaceTexture.isReleased());
          break;
          localObject1 = Integer.valueOf(((Surface)localObject1).hashCode());
          break label166;
          localObject1 = Boolean.valueOf(((Surface)localObject1).isValid());
          break label198;
        }
      }
      FinderLiveThumbPlayerProxy.a(this.Flz, paramSurfaceTexture);
      FinderLiveThumbPlayerProxy.a(this.Flz, new Surface(paramSurfaceTexture));
      paramSurfaceTexture = FinderLiveThumbPlayerProxy.a(this.Flz);
      if (paramSurfaceTexture == null)
      {
        s.bIx("player");
        paramSurfaceTexture = (SurfaceTexture)localObject1;
      }
      for (;;)
      {
        paramSurfaceTexture.setSurface(FinderLiveThumbPlayerProxy.e(this.Flz));
        this.Flz.RP(1);
        AppMethodBeat.o(332584);
        return;
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(332597);
      s.u(paramSurfaceTexture, "surfaceTexture");
      Log.i(this.Flz.getFTPPTag(), "FTPP.onSurfaceTextureDestroyed() surfaceTexture:" + paramSurfaceTexture.hashCode() + ' ' + FinderLiveThumbPlayerProxy.b(this.Flz));
      AppMethodBeat.o(332597);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(332590);
      s.u(paramSurfaceTexture, "surfaceTexture");
      Log.i(this.Flz.getFTPPTag(), "FTPP.onSurfaceTextureSizeChanged  surfaceTexture:" + paramSurfaceTexture.hashCode() + ' ' + paramInt1 + ' ' + paramInt2 + ' ' + FinderLiveThumbPlayerProxy.b(this.Flz));
      AppMethodBeat.o(332590);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(332601);
      s.u(paramSurfaceTexture, "surface");
      paramSurfaceTexture = this.Flz;
      FinderLiveThumbPlayerProxy.b(paramSurfaceTexture, FinderLiveThumbPlayerProxy.i(paramSurfaceTexture) + 1);
      FinderLiveThumbPlayerProxy.c(this.Flz).fjT();
      AppMethodBeat.o(332601);
    }
    
    public final void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(332614);
      Log.i(this.Flz.getFTPPTag(), "FTPP.OnVideoSizeChanged() width:" + paramLong1 + " height:" + paramLong2 + ' ' + FinderLiveThumbPlayerProxy.b(this.Flz));
      if ((paramLong1 > 0L) && (paramLong2 > 0L))
      {
        paramITPPlayer = FinderLiveThumbPlayerProxy.j(this.Flz);
        if (paramITPPlayer != null)
        {
          paramITPPlayer = paramITPPlayer.ANK;
          if (paramITPPlayer != null)
          {
            paramITPPlayer = paramITPPlayer.eCF();
            if (paramITPPlayer != null)
            {
              paramITPPlayer.width = ((float)paramLong1);
              paramITPPlayer.height = ((float)paramLong2);
            }
          }
        }
      }
      i.b localb = this.Flz.getVideoViewCallback();
      if (localb != null)
      {
        paramITPPlayer = FinderLiveThumbPlayerProxy.j(this.Flz);
        if (paramITPPlayer != null) {
          break label202;
        }
        paramITPPlayer = "";
      }
      for (;;)
      {
        localb.e("", paramITPPlayer, (int)paramLong1, (int)paramLong2);
        Object localObject = FinderLiveThumbPlayerProxy.h(this.Flz);
        paramITPPlayer = (ITPPlayer)localObject;
        if (localObject == null)
        {
          s.bIx("textureView");
          paramITPPlayer = null;
        }
        paramITPPlayer.mj((int)paramLong1, (int)paramLong2);
        AppMethodBeat.o(332614);
        return;
        label202:
        localObject = paramITPPlayer.mediaId;
        paramITPPlayer = (ITPPlayer)localObject;
        if (localObject == null) {
          paramITPPlayer = "";
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    d(FinderLiveThumbPlayerProxy paramFinderLiveThumbPlayerProxy)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/replay/FinderLiveThumbPlayerProxy$startProgressTimer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "lastNotifyMs", "", "getLastNotifyMs", "()J", "setLastNotifyMs", "(J)V", "lastPlayPositionMs", "getLastPlayPositionMs", "setLastPlayPositionMs", "onTimerExpired", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements MTimerHandler.CallBack
  {
    private long FlA = -1L;
    private long FlB = -1L;
    
    e(FinderLiveThumbPlayerProxy paramFinderLiveThumbPlayerProxy, v paramv) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(332545);
      long l1 = this.Flz.getCurrentPlayMs();
      long l2 = this.Flz.getVideoDurationMs();
      if (this.FlB != l1)
      {
        localObject = this.Flz.getLifecycle();
        if (localObject != null) {
          ((ab)localObject).ar(l1, l2);
        }
        if ((this.FlA == -1L) || (l1 - this.FlA > 1000L) || (l1 < this.FlA))
        {
          localObject = this.Flz.getLifecycle();
          if (localObject != null) {
            ((ab)localObject).a(paramv.Grz, (int)l1 / 1000, (int)l2 / 1000);
          }
          Log.i(this.Flz.getFTPPTag(), l1 + '/' + l2);
          this.FlA = l1;
        }
        this.FlB = l1;
      }
      Object localObject = FinderLiveThumbPlayerProxy.c(this.Flz);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.video.reporter.d)localObject).aB(l1, l2);
      }
      AppMethodBeat.o(332545);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    f(FinderLiveThumbPlayerProxy paramFinderLiveThumbPlayerProxy, v paramv, long paramLong1, long paramLong2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.FinderLiveThumbPlayerProxy
 * JD-Core Version:    0.7.0.1
 */