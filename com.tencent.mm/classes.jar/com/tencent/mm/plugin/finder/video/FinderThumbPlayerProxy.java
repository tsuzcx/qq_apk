package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
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
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.a.e;
import com.tencent.mm.plugin.thumbplayer.b.e;
import com.tencent.mm.plugin.thumbplayer.texture.MMThumbPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.thumbplayer.b.b.c;
import com.tencent.thumbplayer.b.b.d;
import com.tencent.thumbplayer.b.b.f;
import com.tencent.thumbplayer.b.b.h;
import com.tencent.thumbplayer.b.i.c;
import com.tencent.thumbplayer.b.j;
import com.tencent.thumbplayer.b.p.a;
import d.z;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "bgPrepareStatus", "downloadCallback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "getDownloadCallback", "()Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "setDownloadCallback", "(Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;)V", "firstStart", "", "getFirstStart", "()Z", "setFirstStart", "(Z)V", "isOpenFlowControl", "isPreviewing", "isShouldPlayResume", "setShouldPlayResume", "isStartCdn", "setStartCdn", "isStartCdnPreload", "setStartCdnPreload", "isStartProgressTimer", "setStartProgressTimer", "isViewFocused", "setViewFocused", "isWaiting", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "mediaPreloadCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "getMediaPreloadCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "setMediaPreloadCore", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "onMuteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getOnMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setOnMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "onPlayerStopListener", "Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;", "getOnPlayerStopListener", "()Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;", "setOnPlayerStopListener", "(Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;)V", "progressTimer", "Ljava/util/Timer;", "getProgressTimer", "()Ljava/util/Timer;", "setProgressTimer", "(Ljava/util/Timer;)V", "resourceLoaderProxy", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "getResourceLoaderProxy", "()Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "setResourceLoaderProxy", "(Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;)V", "surface", "Landroid/view/Surface;", "textureUpdateTimes", "textureView", "Lcom/tencent/mm/plugin/thumbplayer/texture/MMThumbPlayerTextureView;", "tpPlayer", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "videoViewCallback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "getVideoViewCallback", "()Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setVideoViewCallback", "(Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;)V", "waitingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "basePlayInfo", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrentPlaySecond", "getCurrentPlayerState", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoMediaId", "getVideoMediaInfo", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "init", "", "initTextureView", "isPause", "isPlaying", "isPrepared", "isPreparing", "isStartPlay", "onRelease", "onUIDestroy", "pause", "pauseWithCancel", "play", "playWithSource", "source", "prepareToPlay", "prepareVideo", "realPlay", "releaseSurface", "detach", "removeVideoFooterView", "seekTo", "timestamp", "", "afterSeekPlay", "setBgPrepareStatus", "status", "setFinderVideoCore", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setIMMVideoViewCallback", "_callback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setLoop", "loop", "setMute", "isMute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isLocal", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setVideoMuteListener", "muteListener", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "showErrToast", "stage", "ret", "startCdnDownload", "startCdnPreload", "startOrPlay", "startProgressTimer", "info", "stop", "stopCdnDownload", "stopCdnPreload", "stopProgressTimer", "Companion", "ResourceLoaderProxy", "plugin-finder_release"})
public final class FinderThumbPlayerProxy
  extends FrameLayout
  implements o
{
  private static final HashSet<Integer> sOp;
  public static final a sOq;
  private final String TAG;
  private boolean isWaiting;
  private boolean rqM;
  private com.tencent.mm.plugin.thumbplayer.c.a sNU;
  private MMThumbPlayerTextureView sNV;
  private int sNW;
  private boolean sNX;
  private int sNY;
  private Timer sNZ;
  private r sOa;
  boolean sOb;
  private boolean sOc;
  private boolean sOd;
  private boolean sOe;
  private boolean sOf;
  private boolean sOg;
  private p sOh;
  private b sOi;
  private i.b sOj;
  private u sOk;
  private q sOl;
  private t sOm;
  private MediaPreloadCore sOn;
  private ap sOo;
  private Surface surface;
  
  static
  {
    AppMethodBeat.i(204727);
    sOq = new a((byte)0);
    sOp = new HashSet();
    AppMethodBeat.o(204727);
  }
  
  public FinderThumbPlayerProxy(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(204724);
    this.TAG = "Finder.FinderThumbPlayerProxy";
    paramContext = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
    d.g.b.p.g(paramContext, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
    this.sNX = ((com.tencent.mm.plugin.thumbplayer.a.a)paramContext).isOpenTPFlowControl();
    this.sOe = true;
    this.sOo = new ap(Looper.getMainLooper(), (ap.a)new q(this));
    init();
    AppMethodBeat.o(204724);
  }
  
  public FinderThumbPlayerProxy(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204725);
    this.TAG = "Finder.FinderThumbPlayerProxy";
    paramContext = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
    d.g.b.p.g(paramContext, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
    this.sNX = ((com.tencent.mm.plugin.thumbplayer.a.a)paramContext).isOpenTPFlowControl();
    this.sOe = true;
    this.sOo = new ap(Looper.getMainLooper(), (ap.a)new q(this));
    init();
    AppMethodBeat.o(204725);
  }
  
  public FinderThumbPlayerProxy(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204726);
    this.TAG = "Finder.FinderThumbPlayerProxy";
    paramContext = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
    d.g.b.p.g(paramContext, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
    this.sNX = ((com.tencent.mm.plugin.thumbplayer.a.a)paramContext).isOpenTPFlowControl();
    this.sOe = true;
    this.sOo = new ap(Looper.getMainLooper(), (ap.a)new q(this));
    init();
    AppMethodBeat.o(204726);
  }
  
  private final boolean FY(int paramInt)
  {
    com.tencent.mm.plugin.thumbplayer.c.a locala = null;
    AppMethodBeat.i(204696);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("prepareVideo source:").append(paramInt).append(" isAllCompleted:");
    Object localObject1 = this.sOi;
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).sjE;
      if (localObject1 != null)
      {
        localObject1 = Boolean.valueOf(((y)localObject1).cCW());
        localStringBuilder = localStringBuilder.append(localObject1).append(" isMoovReady:");
        localObject1 = this.sOi;
        if (localObject1 == null) {
          break label257;
        }
        localObject1 = ((b)localObject1).sjE;
        if (localObject1 == null) {
          break label257;
        }
      }
    }
    label257:
    for (localObject1 = Boolean.valueOf(((y)localObject1).field_moovReady);; localObject1 = null)
    {
      ad.i((String)localObject2, localObject1 + ' ' + cMc());
      localObject2 = this.surface;
      if (localObject2 != null)
      {
        localObject1 = locala;
        if (((Surface)localObject2).isValid()) {
          localObject1 = localObject2;
        }
        if (localObject1 != null)
        {
          locala = this.sNU;
          if (locala == null) {
            d.g.b.p.bcb("tpPlayer");
          }
          locala.setSurface((Surface)localObject1);
        }
      }
      localObject1 = this.sOi;
      if (localObject1 != null) {
        ((b)localObject1).cMn();
      }
      localObject1 = this.sOi;
      if (localObject1 == null) {
        break label262;
      }
      localObject1 = ((b)localObject1).sjE;
      if ((localObject1 == null) || ((!((y)localObject1).field_moovReady) && (!((y)localObject1).cCW()))) {
        break label262;
      }
      localObject1 = this.sNU;
      if (localObject1 == null) {
        d.g.b.p.bcb("tpPlayer");
      }
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).prepareAsync();
      AppMethodBeat.o(204696);
      return true;
      localObject1 = null;
      break;
    }
    label262:
    AppMethodBeat.o(204696);
    return false;
  }
  
  private final void a(final p paramp)
  {
    AppMethodBeat.i(204697);
    if (!this.sOd)
    {
      ad.i(this.TAG, "startProgressTimer " + cMc());
      this.sNZ = new Timer();
      Timer localTimer = this.sNZ;
      if (localTimer != null) {
        localTimer.scheduleAtFixedRate((TimerTask)new n(this, paramp), 0L, 1000L);
      }
      this.sOd = true;
    }
    AppMethodBeat.o(204697);
  }
  
  private final boolean boS()
  {
    AppMethodBeat.i(204721);
    switch (getCurrentPlayerState())
    {
    default: 
      AppMethodBeat.o(204721);
      return false;
    }
    AppMethodBeat.o(204721);
    return true;
  }
  
  private final String cMc()
  {
    AppMethodBeat.i(204684);
    Object localObject1 = new StringBuilder("loader:");
    Object localObject2 = this.sOi;
    int i;
    if (localObject2 != null)
    {
      i = ((b)localObject2).hashCode();
      StringBuilder localStringBuilder = ((StringBuilder)localObject1).append(i).append(" proxy:").append(hashCode()).append(" mediaId: ");
      localObject1 = this.sOh;
      if (localObject1 != null)
      {
        localObject2 = ((p)localObject1).mediaId;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localObject1 = localStringBuilder.append((String)localObject1).append(" player:");
      localObject2 = this.sNU;
      if (localObject2 == null) {
        d.g.b.p.bcb("tpPlayer");
      }
      localObject2 = ((StringBuilder)localObject1).append(localObject2.hashCode()).append(" currentStat:").append(getCurrentPlayerState()).append(" viewFocus:").append(this.sOb).append(" alpha:").append(getAlpha()).append(" surface:");
      localObject1 = this.surface;
      if (localObject1 == null) {
        break label202;
      }
    }
    label202:
    for (localObject1 = Boolean.valueOf(((Surface)localObject1).isValid());; localObject1 = null)
    {
      localObject1 = localObject1;
      AppMethodBeat.o(204684);
      return localObject1;
      i = 0;
      break;
    }
  }
  
  private final void cMd()
  {
    AppMethodBeat.i(204695);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("real play ").append(cMc()).append(" surface:");
    Object localObject1 = this.surface;
    if (localObject1 != null) {}
    for (localObject1 = Boolean.valueOf(((Surface)localObject1).isValid());; localObject1 = null)
    {
      ad.i((String)localObject2, localObject1);
      localObject1 = this.sNV;
      if (localObject1 == null) {
        d.g.b.p.bcb("textureView");
      }
      ((MMThumbPlayerTextureView)localObject1).setInterceptDetach(false);
      setBgPrepareStatus(0);
      localObject1 = this.sNU;
      if (localObject1 == null) {
        d.g.b.p.bcb("tpPlayer");
      }
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).start();
      localObject1 = this.sOh;
      if (localObject1 != null)
      {
        localObject2 = this.sOk;
        if (localObject2 != null) {
          ((u)localObject2).cME();
        }
        a((p)localObject1);
      }
      com.tencent.mm.ad.c.c(this.TAG, (d.g.a.a)new h(this));
      AppMethodBeat.o(204695);
      return;
    }
  }
  
  private final void cMe()
  {
    AppMethodBeat.i(204698);
    if (this.sOd)
    {
      ad.i(this.TAG, "stopProgressTimer " + cMc());
      Timer localTimer = this.sNZ;
      if (localTimer != null) {
        localTimer.cancel();
      }
      this.sNZ = null;
      this.sOd = false;
    }
    AppMethodBeat.o(204698);
  }
  
  private final void cMh()
  {
    AppMethodBeat.i(204705);
    if (this.sOf)
    {
      ad.i(this.TAG, "already start cdn " + cMc());
      AppMethodBeat.o(204705);
      return;
    }
    cMj();
    Object localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
    Object localObject2 = this.sOi;
    localObject1 = this.sOi;
    if (localObject1 != null) {
      localObject1 = ((b)localObject1).sjE;
    }
    while ((localObject2 != null) && (localObject1 != null))
    {
      ad.i(this.TAG, "startCdnDownload " + cMc());
      MediaPreloadCore localMediaPreloadCore = this.sOn;
      if (localMediaPreloadCore != null) {
        localMediaPreloadCore.bb(((b)localObject2).mediaId, true);
      }
      if (!((y)localObject1).cCW())
      {
        if (this.sNX)
        {
          localObject1 = this.sOn;
          if (localObject1 != null) {
            ((MediaPreloadCore)localObject1).ahC(((b)localObject2).mediaId);
          }
        }
        ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().a(((b)localObject2).mediaId, (com.tencent.mm.plugin.thumbplayer.b.b)new k((b)localObject2), (e)new j(this));
        this.sOf = true;
        localObject1 = this.sOh;
        if (localObject1 != null)
        {
          localObject2 = this.sOm;
          if (localObject2 != null)
          {
            ((t)localObject2).b(((p)localObject1).rQu);
            AppMethodBeat.o(204705);
            return;
            localObject1 = null;
          }
          else
          {
            AppMethodBeat.o(204705);
          }
        }
        else
        {
          AppMethodBeat.o(204705);
        }
      }
      else
      {
        ad.i(this.TAG, "downloadFinish " + cMc());
      }
    }
    AppMethodBeat.o(204705);
  }
  
  private final void cMi()
  {
    AppMethodBeat.i(204706);
    if (!this.sOf)
    {
      ad.i(this.TAG, "not start cdn " + cMc());
      AppMethodBeat.o(204706);
      return;
    }
    b localb = this.sOi;
    if (localb != null)
    {
      ad.i(this.TAG, "stopCdnDownload " + cMc());
      MediaPreloadCore localMediaPreloadCore = this.sOn;
      if (localMediaPreloadCore != null) {
        localMediaPreloadCore.bb(localb.mediaId, false);
      }
      localb.mh(false);
      ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().a(localb.mediaId, (com.tencent.mm.plugin.thumbplayer.b.g)new o(this));
      this.sOf = false;
      AppMethodBeat.o(204706);
      return;
    }
    AppMethodBeat.o(204706);
  }
  
  private final void cMj()
  {
    AppMethodBeat.i(204707);
    if (!this.sOg)
    {
      ad.i(this.TAG, "not start preload cdn " + cMc());
      AppMethodBeat.o(204707);
      return;
    }
    b localb = this.sOi;
    if (localb != null)
    {
      ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().a(localb.mediaId, (com.tencent.mm.plugin.thumbplayer.b.f)new p(this));
      this.sOg = false;
      AppMethodBeat.o(204707);
      return;
    }
    AppMethodBeat.o(204707);
  }
  
  private final boolean cMl()
  {
    AppMethodBeat.i(204719);
    switch (getCurrentPlayerState())
    {
    default: 
      AppMethodBeat.o(204719);
      return false;
    }
    AppMethodBeat.o(204719);
    return true;
  }
  
  private final boolean cMm()
  {
    AppMethodBeat.i(204722);
    if (getCurrentPlayerState() == 3)
    {
      AppMethodBeat.o(204722);
      return true;
    }
    AppMethodBeat.o(204722);
    return false;
  }
  
  private final int getCurrentPlayerState()
  {
    AppMethodBeat.i(204718);
    com.tencent.mm.plugin.thumbplayer.c.a locala = this.sNU;
    if (locala == null) {
      d.g.b.p.bcb("tpPlayer");
    }
    int i = locala.fWb().fWx();
    AppMethodBeat.o(204718);
    return i;
  }
  
  private void init()
  {
    AppMethodBeat.i(204683);
    sOp.add(Integer.valueOf(hashCode()));
    ad.i(this.TAG, "create FinderThumbPlayerProxy " + hashCode() + ' ' + sOp);
    Object localObject = com.tencent.mm.plugin.thumbplayer.c.c.Bqk;
    localObject = getContext();
    d.g.b.p.g(localObject, "context");
    localObject = ((Context)localObject).getApplicationContext();
    d.g.b.p.g(localObject, "context.applicationContext");
    d.g.b.p.h(localObject, "context");
    this.sNU = ((com.tencent.mm.plugin.thumbplayer.c.a)new com.tencent.mm.plugin.thumbplayer.c.b((Context)localObject));
    localObject = getContext();
    d.g.b.p.g(localObject, "context");
    this.sNV = new MMThumbPlayerTextureView(((Context)localObject).getApplicationContext());
    localObject = this.sNV;
    if (localObject == null) {
      d.g.b.p.bcb("textureView");
    }
    ((MMThumbPlayerTextureView)localObject).setTextureListenerCallback((TextureView.SurfaceTextureListener)new c(this));
    localObject = this.sNV;
    if (localObject == null) {
      d.g.b.p.bcb("textureView");
    }
    ((MMThumbPlayerTextureView)localObject).setOpaqueInfo(true);
    localObject = this.sNU;
    if (localObject == null) {
      d.g.b.p.bcb("tpPlayer");
    }
    ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).a((b.c)new d(this));
    localObject = this.sNU;
    if (localObject == null) {
      d.g.b.p.bcb("tpPlayer");
    }
    ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).a((b.h)new e(this));
    localObject = this.sNU;
    if (localObject == null) {
      d.g.b.p.bcb("tpPlayer");
    }
    ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).a((b.d)new f(this));
    AppMethodBeat.o(204683);
  }
  
  private final void mg(boolean paramBoolean)
  {
    AppMethodBeat.i(204685);
    ad.i(this.TAG, "releaseSurface " + cMc());
    Object localObject = this.sNU;
    if (localObject == null) {
      d.g.b.p.bcb("tpPlayer");
    }
    ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).setSurface(null);
    localObject = this.surface;
    if (localObject != null) {
      ((Surface)localObject).release();
    }
    this.surface = null;
    if (paramBoolean)
    {
      localObject = this.sNV;
      if (localObject == null) {
        d.g.b.p.bcb("textureView");
      }
      ((MMThumbPlayerTextureView)localObject).fzi();
    }
    AppMethodBeat.o(204685);
  }
  
  private final void setBgPrepareStatus(int paramInt)
  {
    AppMethodBeat.i(204723);
    ad.i(this.TAG, "setBgPrepareStatus " + paramInt + ' ' + cMc());
    this.sNW = paramInt;
    AppMethodBeat.o(204723);
  }
  
  public final boolean FX(int paramInt)
  {
    AppMethodBeat.i(204694);
    ad.i(this.TAG, "play " + cMc() + " source=" + paramInt);
    if (!this.sOb)
    {
      AppMethodBeat.o(204694);
      return false;
    }
    if (!cMl())
    {
      AppMethodBeat.o(204694);
      return false;
    }
    if (isPlaying())
    {
      AppMethodBeat.o(204694);
      return false;
    }
    Object localObject;
    if (boS())
    {
      localObject = this.surface;
      if (localObject != null)
      {
        if (!((Surface)localObject).isValid()) {
          break label152;
        }
        if (localObject != null) {
          cMd();
        }
      }
    }
    for (;;)
    {
      cMh();
      localObject = this.sNU;
      if (localObject == null) {
        d.g.b.p.bcb("tpPlayer");
      }
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).fWu();
      AppMethodBeat.o(204694);
      return true;
      label152:
      localObject = null;
      break;
      if (!cMm()) {
        FY(0);
      }
    }
  }
  
  public final void a(m paramm, boolean paramBoolean, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(204710);
    d.g.b.p.h(paramm, "video");
    d.g.b.p.h(paramFinderItem, "finderItem");
    if (paramBoolean)
    {
      localObject = paramm.siC.url;
      d.g.b.p.g(localObject, "video.mediaObj.url");
    }
    for (paramm = new p("", (String)localObject, paramm.aeA(), paramm.siC, paramm, paramFinderItem);; paramm = new p(paramm.getUrl(), paramm.getPath(), paramm.aeA(), paramm.siC, paramm, paramFinderItem))
    {
      this.sOh = paramm;
      paramm = this.sOh;
      if (paramm != null)
      {
        this.sOi = new b(paramm.mediaId, paramm);
        localObject = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder("init proxy ");
        paramm = this.sOi;
        if (paramm != null)
        {
          paramFinderItem = paramm.cMo();
          paramm = paramFinderItem;
          if (paramFinderItem != null) {}
        }
        else
        {
          paramm = cMc();
        }
        ad.i((String)localObject, paramm);
      }
      paramm = this.sNV;
      if (paramm == null) {
        d.g.b.p.bcb("textureView");
      }
      if (paramm.getParent() != null)
      {
        paramm = this.sNV;
        if (paramm == null) {
          d.g.b.p.bcb("textureView");
        }
        removeView((View)paramm);
      }
      paramm = this.sOh;
      if (paramm == null) {
        break;
      }
      paramFinderItem = com.tencent.mm.plugin.finder.utils.p.sMo;
      paramm = com.tencent.mm.plugin.finder.utils.p.fS((int)paramm.rQu.siC.width, (int)paramm.rQu.siC.height);
      int i = paramm.getInt("media_layout_width", 0);
      int j = paramm.getInt("media_layout_height", 0);
      paramm = new FrameLayout.LayoutParams(i, j);
      paramFinderItem = this.sNV;
      if (paramFinderItem == null) {
        d.g.b.p.bcb("textureView");
      }
      addView((View)paramFinderItem, (ViewGroup.LayoutParams)paramm);
      paramm = this.sNV;
      if (paramm == null) {
        d.g.b.p.bcb("textureView");
      }
      paramm.videoWidth = i;
      paramm.videoHeight = j;
      ad.i(this.TAG, "initTextureView videoWidth:" + i + " videoHeight:" + j + ' ' + cMc());
      AppMethodBeat.o(204710);
      return;
    }
    paramm = (FinderThumbPlayerProxy)this;
    paramFinderItem = new FrameLayout.LayoutParams(-1, -1);
    Object localObject = paramm.sNV;
    if (localObject == null) {
      d.g.b.p.bcb("textureView");
    }
    paramm.addView((View)localObject, (ViewGroup.LayoutParams)paramFinderItem);
    AppMethodBeat.o(204710);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(204708);
    if (!cMl())
    {
      AppMethodBeat.o(204708);
      return false;
    }
    if (!boS())
    {
      AppMethodBeat.o(204708);
      return false;
    }
    ad.i(this.TAG, "seekTo " + paramDouble + ' ' + paramBoolean);
    Object localObject = this.sNU;
    if (localObject == null) {
      d.g.b.p.bcb("tpPlayer");
    }
    paramDouble = 1000.0D * paramDouble;
    if (Double.isNaN(paramDouble))
    {
      localObject = (Throwable)new IllegalArgumentException("Cannot round NaN value.");
      AppMethodBeat.o(204708);
      throw ((Throwable)localObject);
    }
    int i;
    if (paramDouble > 2147483647.0D) {
      i = 2147483647;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).seekTo(i);
      if (paramBoolean) {
        FX(0);
      }
      AppMethodBeat.o(204708);
      return true;
      if (paramDouble < -2147483648.0D) {
        i = -2147483648;
      } else {
        i = (int)Math.round(paramDouble);
      }
    }
  }
  
  public final boolean cLS()
  {
    AppMethodBeat.i(204700);
    if (this.sOb)
    {
      AppMethodBeat.o(204700);
      return false;
    }
    if (cMl())
    {
      if ((getCurrentPlayerState() == 2) && (FY(1)))
      {
        AppMethodBeat.o(204700);
        return true;
      }
      AppMethodBeat.o(204700);
      return false;
    }
    Object localObject1 = this.sOi;
    if (localObject1 != null) {
      ((b)localObject1).cMn();
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
    p localp = this.sOh;
    Object localObject2 = this.sOi;
    localObject1 = this.sOi;
    if (localObject1 != null) {
      localObject1 = ((b)localObject1).sjE;
    }
    while ((localp != null) && (localObject2 != null) && (localObject1 != null))
    {
      ad.i(this.TAG, "prepare to play isAllCompleted:" + ((y)localObject1).cCW() + " isMoovReady:" + ((y)localObject1).field_moovReady + ' ' + cMc());
      com.tencent.mm.plugin.thumbplayer.c.a locala = this.sNU;
      if (locala == null) {
        d.g.b.p.bcb("tpPlayer");
      }
      locala.aCK(localp.mediaId);
      if ((((y)localObject1).cCW()) || (bt.isNullOrNil(localp.downloadUrl)))
      {
        localObject1 = com.tencent.mm.vfs.i.k(localp.path, false);
        localObject2 = this.sNU;
        if (localObject2 == null) {
          d.g.b.p.bcb("tpPlayer");
        }
        ((com.tencent.mm.plugin.thumbplayer.c.a)localObject2).setDataSource((String)localObject1);
        FY(2);
        AppMethodBeat.o(204700);
        return true;
        localObject1 = null;
      }
      else
      {
        localObject1 = new p.a();
        ((p.a)localObject1).aZJ(localp.mediaId);
        ((p.a)localObject1).a(new com.tencent.thumbplayer.b.b.b((byte)0));
        locala = this.sNU;
        if (locala == null) {
          d.g.b.p.bcb("tpPlayer");
        }
        locala.b(new com.tencent.thumbplayer.b.f().aU(102, 1000L));
        locala = this.sNU;
        if (locala == null) {
          d.g.b.p.bcb("tpPlayer");
        }
        locala.a(((p.a)localObject1).fWy());
        localObject1 = this.sNU;
        if (localObject1 == null) {
          d.g.b.p.bcb("tpPlayer");
        }
        ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).setDataSource(localp.downloadUrl);
        localObject1 = this.sNU;
        if (localObject1 == null) {
          d.g.b.p.bcb("tpPlayer");
        }
        ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).a((b.f)localObject2);
        if (FY(3))
        {
          AppMethodBeat.o(204700);
          return true;
        }
      }
    }
    AppMethodBeat.o(204700);
    return false;
  }
  
  public final boolean cLT()
  {
    return this.rqM;
  }
  
  public final boolean cMf()
  {
    AppMethodBeat.i(204699);
    if (!this.sOb)
    {
      AppMethodBeat.o(204699);
      return false;
    }
    if (this.sOe)
    {
      ad.i(this.TAG, "first time to play " + cMc());
      localObject1 = this.sOk;
      if (localObject1 != null) {
        ((u)localObject1).Ga(this.sNW);
      }
      this.sOe = false;
    }
    if (cMl())
    {
      if (FX(3)) {
        this.sNY = 0;
      }
      AppMethodBeat.o(204699);
      return false;
    }
    Object localObject1 = this.sOi;
    if (localObject1 != null) {
      ((b)localObject1).cMn();
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
    p localp = this.sOh;
    Object localObject2 = this.sOi;
    localObject1 = this.sOi;
    com.tencent.mm.plugin.thumbplayer.c.a locala;
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).sjE;
      if ((localp == null) || (localObject2 == null) || (localObject1 == null)) {
        break label472;
      }
      ad.i(this.TAG, "start or play isAllCompleted:" + ((y)localObject1).cCW() + " isMoovReady:" + ((y)localObject1).field_moovReady + ' ' + cMc());
      this.sNY = 0;
      locala = this.sNU;
      if (locala == null) {
        d.g.b.p.bcb("tpPlayer");
      }
      locala.aCK(localp.mediaId);
      if ((!((y)localObject1).cCW()) && (!bt.isNullOrNil(localp.downloadUrl))) {
        break label312;
      }
      localObject1 = com.tencent.mm.vfs.i.k(localp.path, false);
      localObject2 = this.sNU;
      if (localObject2 == null) {
        d.g.b.p.bcb("tpPlayer");
      }
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject2).setDataSource((String)localObject1);
      FY(4);
    }
    for (;;)
    {
      AppMethodBeat.o(204699);
      return true;
      localObject1 = null;
      break;
      label312:
      localObject1 = new p.a();
      ((p.a)localObject1).aZJ(localp.mediaId);
      ((p.a)localObject1).a(new com.tencent.thumbplayer.b.b.b((byte)0));
      locala = this.sNU;
      if (locala == null) {
        d.g.b.p.bcb("tpPlayer");
      }
      locala.b(new com.tencent.thumbplayer.b.f().aU(102, 1000L));
      locala = this.sNU;
      if (locala == null) {
        d.g.b.p.bcb("tpPlayer");
      }
      locala.a(((p.a)localObject1).fWy());
      localObject1 = this.sNU;
      if (localObject1 == null) {
        d.g.b.p.bcb("tpPlayer");
      }
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).setDataSource(localp.downloadUrl);
      localObject1 = this.sNU;
      if (localObject1 == null) {
        d.g.b.p.bcb("tpPlayer");
      }
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).a((b.f)localObject2);
      FY(5);
      cMh();
    }
    label472:
    AppMethodBeat.o(204699);
    return false;
  }
  
  public final int cMg()
  {
    AppMethodBeat.i(204702);
    ad.i(this.TAG, "pauseWithCancel " + cMc());
    pause();
    AppMethodBeat.o(204702);
    return 0;
  }
  
  public final void cMk() {}
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(204686);
    Object localObject = this.sNV;
    if (localObject == null) {
      d.g.b.p.bcb("textureView");
    }
    localObject = ((MMThumbPlayerTextureView)localObject).getBitmap();
    AppMethodBeat.o(204686);
    return localObject;
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(204687);
    com.tencent.mm.plugin.thumbplayer.c.a locala = this.sNU;
    if (locala == null) {
      d.g.b.p.bcb("tpPlayer");
    }
    int i = (int)(locala.getCurrentPositionMs() / 1000L);
    AppMethodBeat.o(204687);
    return i;
  }
  
  public final t getDownloadCallback()
  {
    return this.sOm;
  }
  
  public final boolean getFirstStart()
  {
    return this.sOe;
  }
  
  public final boolean getIsNeverStart()
  {
    AppMethodBeat.i(204689);
    if (!cMl())
    {
      AppMethodBeat.o(204689);
      return true;
    }
    AppMethodBeat.o(204689);
    return false;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.sOc;
  }
  
  public final u getLifecycle()
  {
    return this.sOk;
  }
  
  public final p getMediaInfo()
  {
    return this.sOh;
  }
  
  public final MediaPreloadCore getMediaPreloadCore()
  {
    return this.sOn;
  }
  
  public final q getOnMuteListener()
  {
    return this.sOl;
  }
  
  public final r getOnPlayerStopListener()
  {
    return this.sOa;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(204690);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(204690);
    return localViewParent;
  }
  
  public final Timer getProgressTimer()
  {
    return this.sNZ;
  }
  
  public final b getResourceLoaderProxy()
  {
    return this.sOi;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(204688);
    com.tencent.mm.plugin.thumbplayer.c.a locala = this.sNU;
    if (locala == null) {
      d.g.b.p.bcb("tpPlayer");
    }
    int i = (int)(locala.getDurationMs() / 1000L);
    AppMethodBeat.o(204688);
    return i;
  }
  
  public final String getVideoMediaId()
  {
    Object localObject = this.sOh;
    if (localObject != null)
    {
      String str = ((p)localObject).mediaId;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final p getVideoMediaInfo()
  {
    return this.sOh;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final i.b getVideoViewCallback()
  {
    return this.sOj;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.sOb;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(204720);
    if (getCurrentPlayerState() == 5)
    {
      AppMethodBeat.o(204720);
      return true;
    }
    AppMethodBeat.o(204720);
    return false;
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(204717);
    ad.i(this.TAG, "release " + cMc());
    mg(true);
    this.sOm = null;
    this.sOi = null;
    com.tencent.mm.ad.c.c(this.TAG, (d.g.a.a)new g(this));
    sOp.remove(Integer.valueOf(hashCode()));
    AppMethodBeat.o(204717);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(204704);
    ad.i(this.TAG, "onUIDestroy " + cMc());
    stop();
    AppMethodBeat.o(204704);
  }
  
  public final boolean pause()
  {
    Object localObject3 = null;
    int i = 0;
    AppMethodBeat.i(204701);
    ad.i(this.TAG, "pause  " + cMc());
    if (!cMl())
    {
      AppMethodBeat.o(204701);
      return false;
    }
    Object localObject1;
    if (isPlaying())
    {
      localObject1 = this.sNU;
      if (localObject1 == null) {
        d.g.b.p.bcb("tpPlayer");
      }
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).pause();
      localObject1 = this.sNU;
      if (localObject1 == null) {
        d.g.b.p.bcb("tpPlayer");
      }
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).pauseDownload();
      localObject1 = this.sNV;
      if (localObject1 == null) {
        d.g.b.p.bcb("textureView");
      }
      ((MMThumbPlayerTextureView)localObject1).setInterceptDetach(true);
      cMi();
      if (this.sOc)
      {
        if (!this.sOg) {
          break label396;
        }
        ad.i(this.TAG, "already start preload cdn " + cMc());
      }
    }
    for (;;)
    {
      cMe();
      if (this.sOh != null)
      {
        localObject1 = this.sOk;
        if (localObject1 != null) {
          ((u)localObject1).cMC();
        }
      }
      AppMethodBeat.o(204701);
      return true;
      if (!cMm()) {
        break;
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      Object localObject4 = this.sOi;
      localObject1 = this.sOi;
      label232:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((b)localObject1).sjE;
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject2 = localObject3;
          if (localObject1 != null)
          {
            if (((y)localObject1).field_moovReady) {
              break label383;
            }
            ad.i(this.TAG, "preparing, but moov not ready, try stop");
            localObject1 = this.sNU;
            if (localObject1 == null) {
              d.g.b.p.bcb("tpPlayer");
            }
            ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).stop();
            localObject1 = this.sNU;
            if (localObject1 == null) {
              d.g.b.p.bcb("tpPlayer");
            }
            ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).reset();
          }
        }
      }
      for (;;)
      {
        localObject2 = z.MKo;
        if (localObject2 != null) {
          break;
        }
        localObject1 = (FinderThumbPlayerProxy)this;
        ad.w(((FinderThumbPlayerProxy)localObject1).TAG, "occur error, stop and reset");
        localObject2 = ((FinderThumbPlayerProxy)localObject1).sNU;
        if (localObject2 == null) {
          d.g.b.p.bcb("tpPlayer");
        }
        ((com.tencent.mm.plugin.thumbplayer.c.a)localObject2).stop();
        localObject1 = ((FinderThumbPlayerProxy)localObject1).sNU;
        if (localObject1 == null) {
          d.g.b.p.bcb("tpPlayer");
        }
        ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).reset();
        localObject1 = z.MKo;
        break;
        localObject1 = null;
        break label232;
        label383:
        ad.i(this.TAG, "preparing, but moov ready, wait for prepared");
      }
      label396:
      localObject3 = this.sOi;
      if ((localObject3 != null) && (((b)localObject3).sjE.field_cacheSize < ((b)localObject3).sOv) && (((b)localObject3).sjE.field_totalSize > 0L))
      {
        localObject1 = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController();
        localObject2 = ((b)localObject3).mediaId;
        localObject3 = (com.tencent.mm.plugin.thumbplayer.b.b)new m((b)localObject3);
        localObject4 = (com.tencent.mm.plugin.thumbplayer.b.d)new l(this);
        d.g.b.p.h(localObject2, "mediaId");
        d.g.b.p.h(localObject3, "createCallback");
        if (((CharSequence)localObject2).length() == 0) {
          i = 1;
        }
        if (i == 0) {
          com.tencent.mm.ad.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new a.e((com.tencent.mm.plugin.thumbplayer.b.a)localObject1, (com.tencent.mm.plugin.thumbplayer.b.b)localObject3, (String)localObject2, (com.tencent.mm.plugin.thumbplayer.b.d)localObject4));
        }
        this.sOg = true;
      }
    }
  }
  
  public final boolean play()
  {
    AppMethodBeat.i(204693);
    boolean bool = FX(0);
    AppMethodBeat.o(204693);
    return bool;
  }
  
  public final void setDownloadCallback(t paramt)
  {
    this.sOm = paramt;
  }
  
  public final void setFinderVideoCore(i parami) {}
  
  public final void setFirstStart(boolean paramBoolean)
  {
    this.sOe = paramBoolean;
  }
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(204711);
    d.g.b.p.h(paramb, "_callback");
    this.sOj = paramb;
    AppMethodBeat.o(204711);
  }
  
  public final void setIOnlineVideoProxy(com.tencent.mm.modelvideo.b paramb)
  {
    AppMethodBeat.i(204713);
    d.g.b.p.h(paramb, "_proxy");
    AppMethodBeat.o(204713);
  }
  
  public final void setInterceptDetach(boolean paramBoolean)
  {
    AppMethodBeat.i(204692);
    MMThumbPlayerTextureView localMMThumbPlayerTextureView = this.sNV;
    if (localMMThumbPlayerTextureView == null) {
      d.g.b.p.bcb("textureView");
    }
    localMMThumbPlayerTextureView.setInterceptDetach(paramBoolean);
    AppMethodBeat.o(204692);
  }
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    this.sOc = paramBoolean;
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean) {}
  
  public final void setLifecycle(u paramu)
  {
    this.sOk = paramu;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(204714);
    com.tencent.mm.plugin.thumbplayer.c.a locala = this.sNU;
    if (locala == null) {
      d.g.b.p.bcb("tpPlayer");
    }
    locala.zv(paramBoolean);
    AppMethodBeat.o(204714);
  }
  
  public final void setMediaInfo(p paramp)
  {
    this.sOh = paramp;
  }
  
  public final void setMediaPreloadCore(MediaPreloadCore paramMediaPreloadCore)
  {
    this.sOn = paramMediaPreloadCore;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(204709);
    com.tencent.mm.plugin.thumbplayer.c.a locala = this.sNU;
    if (locala == null) {
      d.g.b.p.bcb("tpPlayer");
    }
    locala.zw(paramBoolean);
    AppMethodBeat.o(204709);
  }
  
  public final void setOnMuteListener(q paramq)
  {
    this.sOl = paramq;
  }
  
  public final void setOnPlayerStopListener(r paramr)
  {
    this.sOa = paramr;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    this.rqM = paramBoolean;
  }
  
  public final void setProgressTimer(Timer paramTimer)
  {
    this.sNZ = paramTimer;
  }
  
  public final void setResourceLoaderProxy(b paramb)
  {
    this.sOi = paramb;
  }
  
  public final void setScaleType(i.e parame)
  {
    AppMethodBeat.i(204712);
    d.g.b.p.h(parame, "scaleType");
    AppMethodBeat.o(204712);
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.sOc = paramBoolean;
  }
  
  public final void setStartCdn(boolean paramBoolean)
  {
    this.sOf = paramBoolean;
  }
  
  public final void setStartCdnPreload(boolean paramBoolean)
  {
    this.sOg = paramBoolean;
  }
  
  public final void setStartProgressTimer(boolean paramBoolean)
  {
    this.sOd = paramBoolean;
  }
  
  public final void setVideoMuteListener(q paramq)
  {
    AppMethodBeat.i(204716);
    d.g.b.p.h(paramq, "muteListener");
    this.sOl = paramq;
    AppMethodBeat.o(204716);
  }
  
  public final void setVideoPlayLifecycle(u paramu)
  {
    AppMethodBeat.i(204715);
    d.g.b.p.h(paramu, "lifecycle");
    this.sOk = paramu;
    AppMethodBeat.o(204715);
  }
  
  public final void setVideoViewCallback(i.b paramb)
  {
    this.sOj = paramb;
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(204691);
    ad.i(this.TAG, "setVideoViewFocused " + paramBoolean + ' ' + cMc());
    this.sOb = paramBoolean;
    AppMethodBeat.o(204691);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.sOb = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(204703);
    ad.i(this.TAG, "stop " + cMc());
    if (!cMl())
    {
      AppMethodBeat.o(204703);
      return;
    }
    Object localObject = this.sOk;
    if (localObject != null) {
      ((u)localObject).b(this.sOh);
    }
    localObject = this.sNU;
    if (localObject == null) {
      d.g.b.p.bcb("tpPlayer");
    }
    ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).stop();
    localObject = this.sNU;
    if (localObject == null) {
      d.g.b.p.bcb("tpPlayer");
    }
    ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).reset();
    cMe();
    cMi();
    cMj();
    this.sOe = false;
    setBgPrepareStatus(0);
    AppMethodBeat.o(204703);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$Companion;", "", "()V", "currentKeepProxySet", "Ljava/util/HashSet;", "", "getCurrentKeepProxySet", "()Ljava/util/HashSet;", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnResourceLoaderListener;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "mediaId", "", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "(Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "MAX_REQUEST_BUFFER", "", "getMAX_REQUEST_BUFFER", "()I", "MIN_CHECK_BUFFER", "getMIN_CHECK_BUFFER", "isRequestingData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setRequestingData", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "lastOnReadDataEnd", "", "getLastOnReadDataEnd", "()J", "setLastOnReadDataEnd", "(J)V", "mediaCache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "getMediaCache", "()Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "setMediaCache", "(Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;)V", "getMediaId", "()Ljava/lang/String;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "requestOffset", "getRequestOffset", "setRequestOffset", "baseInfo", "callback", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "checkRequestData", "", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "createVideoPreloadCDNTask", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "buff", "Ljava/io/ByteArrayOutputStream;", "getContentType", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "taskId", "fileKey", "getDataFilePath", "getDataTotalSize", "onDataAvailable", "offset", "length", "onFinish", "ret", "onMoovReady", "svrflag", "onPreloadCompleted", "onProgress", "total", "onReadData", "onReplay", "onStartReadData", "requestStart", "requestEnd", "onStopReadData", "updateMediaCache", "updateRequestingData", "value", "plugin-finder_release"})
  public final class b
    implements g.a, g.b, h.a, b.f
  {
    final String mediaId;
    final p sOh;
    private final int sOr;
    private final int sOs;
    long sOt;
    private AtomicBoolean sOu;
    long sOv;
    y sjE;
    
    public b(p paramp)
    {
      AppMethodBeat.i(204663);
      this.mediaId = paramp;
      this.sOh = ((p)localObject);
      this.sOr = 1048576;
      this.sOs = 131072;
      this.sOu = new AtomicBoolean(false);
      this$1 = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
      this.sjE = com.tencent.mm.plugin.finder.storage.logic.c.bf(this.mediaId, true);
      switch (this.sjE.field_state)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(204663);
        return;
        this$1 = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
        localObject = this.mediaId;
        String str = this.sOh.rQu.siC.mediaId;
        d.g.b.p.g(str, "mediaInfo.video.mediaObj.mediaId");
        paramp = this.sOh.downloadUrl;
        this$1 = paramp;
        if (paramp == null) {
          this$1 = "";
        }
        com.tencent.mm.plugin.finder.storage.logic.c.a((String)localObject, str, FinderThumbPlayerProxy.this, this.sOh.path, this.sOh.rQu.sjm, this.sOh.rQu.siD.detail, 0L, 0L, 1, this.sOh.rQu.siC.videoDuration, "", "");
        cMn();
      }
    }
    
    public final int a(com.tencent.thumbplayer.b.a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(204652);
      ad.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "onStartReadData taskId:" + paramLong + " fileKey:" + paramString + ' ' + cMo());
      AppMethodBeat.o(204652);
      return 0;
    }
    
    public final int a(com.tencent.thumbplayer.b.a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(204650);
      ad.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "onStartReadData taskId:" + paramLong1 + " fileKey:" + paramString + " requestStart:" + paramLong2 + " requestEnd" + paramLong3 + ' ' + cMo());
      this.sOt = paramLong2;
      int i = (int)paramLong1;
      AppMethodBeat.o(204650);
      return i;
    }
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      int i = 1;
      AppMethodBeat.i(204661);
      d.g.b.p.h(paramString, "mediaId");
      String str = FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this);
      StringBuilder localStringBuilder = new StringBuilder("[onPreloadProgress] mediaId=").append(paramString).append(" startRet=").append(paramInt).append(" finishedLength=");
      if (paramc != null)
      {
        paramd = Long.valueOf(paramc.field_finishedLength);
        ad.i(str, paramd + ' ' + cMo());
        if (paramc != null)
        {
          if ((paramInt != 0) || (paramc.field_finishedLength <= 0L)) {
            break label185;
          }
          paramInt = 1;
          label115:
          if (paramInt == 0) {
            break label190;
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
          paramd = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
          com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, paramc.field_finishedLength, paramc.field_toltalLength, paramInt);
          cMn();
          paramc = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
          com.tencent.mm.plugin.finder.storage.logic.c.aiC(paramString);
        }
        AppMethodBeat.o(204661);
        return 0;
        paramd = null;
        break;
        label185:
        paramInt = 0;
        break label115;
        label190:
        paramc = null;
      }
    }
    
    public final void a(String paramString, final int paramInt, final com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(204656);
      d.g.b.p.h(paramString, "mediaId");
      d.g.b.p.h(paramd, "sceneResult");
      ad.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "[onFinish] mediaId=" + paramString + " ret=" + paramInt + " recvedBytes=" + paramd.field_recvedBytes + " fileLength=" + paramd.field_fileLength + "  finderformat:" + paramd.field_videoFormat);
      Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
      com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, paramd.field_fileLength, paramd.field_fileLength, 3);
      cMn();
      mh(false);
      localObject = new long[3];
      int i = CdnLogic.queryDownloadedSize(paramString, (long[])localObject);
      ad.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "check download size " + i + ' ' + localObject[0] + ' ' + localObject[1] + ' ' + localObject[2]);
      com.tencent.mm.ad.c.g((d.g.a.a)new b(this, paramInt, paramd));
      paramd = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
      com.tencent.mm.plugin.finder.storage.logic.c.aiC(paramString);
      AppMethodBeat.o(204656);
    }
    
    public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(204659);
      d.g.b.p.h(paramString1, "mediaId");
      ad.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "[onMoovReady] mediaId=" + paramString1 + " offset=" + paramLong1 + " length=" + paramLong2 + " svrflag=" + paramString2 + ' ' + cMo());
      Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
      localObject = paramString2;
      if (paramString2 == null) {
        localObject = "";
      }
      com.tencent.mm.plugin.finder.storage.logic.c.gp(paramString1, (String)localObject);
      cMn();
      if ((!FinderThumbPlayerProxy.e(FinderThumbPlayerProxy.this)) && (!FinderThumbPlayerProxy.f(FinderThumbPlayerProxy.this)))
      {
        ad.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "try to prepared");
        FinderThumbPlayerProxy.g(FinderThumbPlayerProxy.this);
      }
      paramString2 = FinderThumbPlayerProxy.this.getDownloadCallback();
      if (paramString2 != null) {
        paramString2.a((int)paramLong1, (int)paramLong2, this.sOh.rQu);
      }
      paramString2 = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
      com.tencent.mm.plugin.finder.storage.logic.c.aiC(paramString1);
      com.tencent.mm.ad.c.c(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), (d.g.a.a)new c(this));
      AppMethodBeat.o(204659);
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(204660);
      d.g.b.p.h(paramString, "mediaId");
      AppMethodBeat.o(204660);
    }
    
    public final int b(com.tencent.thumbplayer.b.a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(204651);
      int m = 0;
      int n = (int)paramLong2;
      int i1 = (int)paramLong2;
      int j;
      if (paramLong3 < this.sOr)
      {
        j = (int)paramLong3;
        if (paramLong3 <= this.sOs) {
          break label171;
        }
      }
      label153:
      label171:
      for (int k = this.sOs;; k = (int)paramLong3)
      {
        if (!this.sjE.cCW()) {
          break label179;
        }
        i = (int)paramLong3;
        this.sOv = (paramLong2 + paramLong3);
        if (i <= 0) {
          break label481;
        }
        ad.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "onReadData taskId:" + paramLong1 + " requestOffset:" + n + " returnLength:" + i + " checkRet:-1 originLength:" + paramLong3 + ' ' + cMo());
        AppMethodBeat.o(204651);
        return i;
        j = this.sOr;
        break;
      }
      label179:
      parama = new long[3];
      int i = m;
      if (CdnLogic.queryDownloadedSize(this.mediaId, parama) == 0)
      {
        i = m;
        if (parama[0] > i1)
        {
          if (parama[0] >= i1 + paramLong3) {
            break label445;
          }
          i = (int)(parama[0] - i1);
        }
      }
      label235:
      if (i == 0)
      {
        m = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().az(this.mediaId, i1, k);
        if (m != 1) {
          break label556;
        }
        i = k;
        k = m;
      }
      for (;;)
      {
        if ((k == 0) && (!FinderThumbPlayerProxy.c(FinderThumbPlayerProxy.this)) && (this.sjE.field_moovReady) && (!this.sOu.get()))
        {
          k = j;
          if (n + j > this.sjE.field_totalSize) {
            k = (int)(this.sjE.field_totalSize - n);
          }
          ad.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "start to request data requestOffset:" + n + " requestLength:" + k + ' ' + cMo());
          if (((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().a(this.mediaId, n, k, (com.tencent.mm.plugin.thumbplayer.b.c)new d(this)) > 0) {
            mh(true);
          }
        }
        break;
        label445:
        i = (int)paramLong3;
        break label235;
        k = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().az(this.mediaId, i1, j);
        continue;
        label481:
        ad.d(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "onReadData taskId:" + paramLong1 + " requestOffset:" + n + " returnLength:" + i + " checkRet:-1 originLength:" + paramLong3 + ' ' + cMo());
        break label153;
        label556:
        k = m;
      }
    }
    
    public final long b(com.tencent.thumbplayer.b.a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(204654);
      ad.d(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "getDataTotalSize " + this.sjE.field_totalSize + ' ' + FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this));
      paramLong = this.sjE.field_totalSize;
      AppMethodBeat.o(204654);
      return paramLong;
    }
    
    public final void b(String paramString, com.tencent.mm.i.d paramd)
    {
      Object localObject = null;
      AppMethodBeat.i(204662);
      d.g.b.p.h(paramString, "mediaId");
      String str = FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this);
      StringBuilder localStringBuilder = new StringBuilder("[onPreloadCompleted] mediaId=").append(paramString).append(" Ret=");
      if (paramd != null) {}
      for (paramString = Integer.valueOf(paramd.field_retCode);; paramString = null)
      {
        localStringBuilder = localStringBuilder.append(paramString).append(" finishedLength=");
        paramString = localObject;
        if (paramd != null) {
          paramString = Long.valueOf(paramd.field_recvedBytes);
        }
        ad.i(str, paramString + ' ' + cMo());
        FinderThumbPlayerProxy.h(FinderThumbPlayerProxy.this);
        AppMethodBeat.o(204662);
        return;
      }
    }
    
    public final String c(com.tencent.thumbplayer.b.a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(204655);
      parama = com.tencent.mm.vfs.i.k(this.sjE.getFilePath(), false);
      ad.d(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "getDataFilePath origin:" + this.sjE.getFilePath() + " export:" + parama + ' ' + com.tencent.mm.vfs.i.fv(this.sjE.getFilePath()));
      d.g.b.p.g(parama, "filePath");
      AppMethodBeat.o(204655);
      return parama;
    }
    
    public final void cMn()
    {
      AppMethodBeat.i(204647);
      com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
      this.sjE = com.tencent.mm.plugin.finder.storage.logic.c.aiD(this.mediaId);
      AppMethodBeat.o(204647);
    }
    
    public final String cMo()
    {
      AppMethodBeat.i(204649);
      String str = FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this) + " moov:" + this.sjE.field_moovReady + " request:" + this.sOu.get() + " isFinish:" + this.sjE.cCW() + " requestOffset:" + this.sOt + " total:" + this.sjE.field_totalSize;
      AppMethodBeat.o(204649);
      return str;
    }
    
    public final void cMp()
    {
      AppMethodBeat.i(204653);
      if (!FinderThumbPlayerProxy.c(FinderThumbPlayerProxy.this))
      {
        AppMethodBeat.o(204653);
        return;
      }
      ad.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "checkRequestData " + cMo());
      long l1;
      if ((this.sjE.field_moovReady) && (!this.sOu.get()) && (!this.sjE.cCW()))
      {
        if (this.sjE.field_totalSize <= 0L) {
          break label479;
        }
        l1 = FinderThumbPlayerProxy.d(FinderThumbPlayerProxy.this).getDurationMs();
        if (l1 != 0L) {
          break label486;
        }
        l1 = this.sOh.rQu.siC.videoDuration * 1000L;
      }
      label479:
      label486:
      for (;;)
      {
        long l3 = FinderThumbPlayerProxy.d(FinderThumbPlayerProxy.this).getCurrentPositionMs();
        long l2 = (5000L + l3) * 100L / l1;
        int i = (int)(d.k.h.aI(this.sjE.field_totalSize * l2 / 100L + 131072L, this.sjE.field_totalSize) - this.sOt);
        i = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().az(this.mediaId, (int)this.sOt, i);
        MediaPreloadCore localMediaPreloadCore;
        if (i == 1)
        {
          localMediaPreloadCore = FinderThumbPlayerProxy.this.getMediaPreloadCore();
          if (localMediaPreloadCore != null)
          {
            localMediaPreloadCore.ahD(this.mediaId);
            AppMethodBeat.o(204653);
            return;
          }
          AppMethodBeat.o(204653);
          return;
        }
        if (i == 0)
        {
          l1 = (10000L + l3) * 100L / l1;
          i = (int)(d.k.h.aI(this.sjE.field_totalSize * l1 / 100L + 131072L, this.sjE.field_totalSize) - this.sOt);
          ad.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "start to request data minCachePlayPercent:" + l2 + " targetPlayPercent:" + l1 + " requestOffset:" + this.sOt + " requestLength:" + i + ' ' + cMo());
          if (((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().a(this.mediaId, (int)this.sOt, i, (com.tencent.mm.plugin.thumbplayer.b.c)new a(this)) > 0) {
            mh(true);
          }
        }
        AppMethodBeat.o(204653);
        return;
        if (this.sjE.cCW())
        {
          localMediaPreloadCore = FinderThumbPlayerProxy.this.getMediaPreloadCore();
          if (localMediaPreloadCore != null)
          {
            localMediaPreloadCore.ahD(this.mediaId);
            AppMethodBeat.o(204653);
            return;
          }
        }
        AppMethodBeat.o(204653);
        return;
      }
    }
    
    public final String d(com.tencent.thumbplayer.b.a parama, long paramLong, String paramString)
    {
      return "video/mp4";
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return null;
    }
    
    public final void i(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(204657);
      d.g.b.p.h(paramString, "mediaId");
      ad.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "[onProgress] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2 + ' ' + cMo());
      Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
      com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, paramLong1, paramLong2, 1);
      cMn();
      localObject = FinderThumbPlayerProxy.this.getDownloadCallback();
      if (localObject != null) {
        ((t)localObject).b((int)paramLong1, (int)paramLong2, this.sOh.rQu);
      }
      localObject = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
      com.tencent.mm.plugin.finder.storage.logic.c.aiC(paramString);
      AppMethodBeat.o(204657);
    }
    
    public final void mh(boolean paramBoolean)
    {
      AppMethodBeat.i(204648);
      ad.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "setRequestingData " + paramBoolean + ' ' + cMo());
      this.sOu.set(paramBoolean);
      AppMethodBeat.o(204648);
    }
    
    public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(204658);
      d.g.b.p.h(paramString, "mediaId");
      mh(false);
      ad.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "[onDataAvailable] mediaId=" + paramString + " offset=" + paramLong1 + " length=" + paramLong2 + ' ' + cMo());
      AppMethodBeat.o(204658);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy$checkRequestData$requestDataRet$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "onRequest", "", "ret", "", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.plugin.thumbplayer.b.c
    {
      public final void FZ(int paramInt)
      {
        AppMethodBeat.i(204643);
        if (paramInt != 0)
        {
          ad.i(FinderThumbPlayerProxy.a(this.sOx.sOw), "request data fail " + this.sOx.cMo());
          this.sOx.mh(false);
          AppMethodBeat.o(204643);
          return;
        }
        ad.i(FinderThumbPlayerProxy.a(this.sOx.sOw), "real start request data " + this.sOx.cMo());
        AppMethodBeat.o(204643);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      b(FinderThumbPlayerProxy.b paramb, int paramInt, com.tencent.mm.i.d paramd)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      c(FinderThumbPlayerProxy.b paramb)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy$onReadData$requestDataRet$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "onRequest", "", "ret", "", "plugin-finder_release"})
    public static final class d
      implements com.tencent.mm.plugin.thumbplayer.b.c
    {
      public final void FZ(int paramInt)
      {
        AppMethodBeat.i(204646);
        if (paramInt != 0)
        {
          ad.i(FinderThumbPlayerProxy.a(this.sOx.sOw), "request data fail " + this.sOx.cMo());
          this.sOx.mh(false);
        }
        AppMethodBeat.o(204646);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-finder_release"})
  public static final class c
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Object localObject = null;
      String str = null;
      AppMethodBeat.i(204666);
      Surface localSurface;
      if (FinderThumbPlayerProxy.m(this.sOw) == null)
      {
        ad.i(FinderThumbPlayerProxy.a(this.sOw), "onSurfaceTextureAvailable " + FinderThumbPlayerProxy.b(this.sOw) + " texture:" + hashCode() + " width:" + paramInt1 + " height:" + paramInt2);
        localObject = FinderThumbPlayerProxy.d(this.sOw);
        if (paramSurfaceTexture != null)
        {
          FinderThumbPlayerProxy.a(this.sOw, new Surface(paramSurfaceTexture));
          ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).setSurface(FinderThumbPlayerProxy.m(this.sOw));
          if (this.sOw.getMediaInfo() != null) {
            this.sOw.FX(1);
          }
          localObject = FinderThumbPlayerProxy.a(this.sOw);
          localStringBuilder = new StringBuilder("set surface ");
          localSurface = FinderThumbPlayerProxy.m(this.sOw);
          paramSurfaceTexture = str;
          if (localSurface != null) {
            paramSurfaceTexture = Boolean.valueOf(localSurface.isValid());
          }
          ad.i((String)localObject, paramSurfaceTexture + ' ' + FinderThumbPlayerProxy.b(this.sOw));
          AppMethodBeat.o(204666);
          return;
        }
        AppMethodBeat.o(204666);
        return;
      }
      str = FinderThumbPlayerProxy.a(this.sOw);
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable ").append(FinderThumbPlayerProxy.b(this.sOw)).append(" texture:").append(hashCode()).append(" surface:");
      paramSurfaceTexture = FinderThumbPlayerProxy.m(this.sOw);
      if (paramSurfaceTexture != null) {}
      for (paramSurfaceTexture = Boolean.valueOf(paramSurfaceTexture.isValid());; paramSurfaceTexture = null)
      {
        localStringBuilder = localStringBuilder.append(paramSurfaceTexture).append('_');
        localSurface = FinderThumbPlayerProxy.m(this.sOw);
        paramSurfaceTexture = (SurfaceTexture)localObject;
        if (localSurface != null) {
          paramSurfaceTexture = Integer.valueOf(localSurface.hashCode());
        }
        ad.i(str, paramSurfaceTexture + " width:" + paramInt1 + " height:" + paramInt2);
        AppMethodBeat.o(204666);
        return;
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(204665);
      ad.i(FinderThumbPlayerProxy.a(this.sOw), "onSurfaceTextureDestroyed " + FinderThumbPlayerProxy.b(this.sOw) + " texture:" + hashCode());
      FinderThumbPlayerProxy.l(this.sOw);
      AppMethodBeat.o(204665);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204667);
      ad.i(FinderThumbPlayerProxy.a(this.sOw), "onSurfaceTextureSizeChanged " + FinderThumbPlayerProxy.b(this.sOw) + " texture:" + hashCode() + ' ' + paramInt1 + ' ' + paramInt2);
      AppMethodBeat.o(204667);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(204664);
      paramSurfaceTexture = this.sOw;
      FinderThumbPlayerProxy.a(paramSurfaceTexture, FinderThumbPlayerProxy.i(paramSurfaceTexture) + 1);
      paramSurfaceTexture = this.sOw.getMediaInfo();
      if (paramSurfaceTexture != null)
      {
        if ((FinderThumbPlayerProxy.i(this.sOw) == 1) && (FinderThumbPlayerProxy.j(this.sOw) == 1))
        {
          FinderThumbPlayerProxy.b(this.sOw, 2);
          u localu = this.sOw.getLifecycle();
          if (localu != null) {
            localu.e(paramSurfaceTexture.sQp);
          }
          FinderThumbPlayerProxy.k(this.sOw).setInterceptDetach(true);
          ad.i(FinderThumbPlayerProxy.a(this.sOw), "background prepared first frame " + FinderThumbPlayerProxy.b(this.sOw));
        }
        if ((FinderThumbPlayerProxy.i(this.sOw) == 1) && (FinderThumbPlayerProxy.j(this.sOw) == 0))
        {
          ad.i(FinderThumbPlayerProxy.a(this.sOw), "onFirstFrameDraw " + FinderThumbPlayerProxy.b(this.sOw));
          paramSurfaceTexture = this.sOw.getLifecycle();
          if (paramSurfaceTexture != null)
          {
            paramSurfaceTexture.xq(FinderThumbPlayerProxy.d(this.sOw).eoh());
            AppMethodBeat.o(204664);
            return;
          }
        }
        AppMethodBeat.o(204664);
        return;
      }
      AppMethodBeat.o(204664);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "errorType", "", "errorCode", "arg1", "", "arg2", "onError"})
  static final class d
    implements b.c
  {
    d(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void a(com.tencent.thumbplayer.b.a parama, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(204668);
      ad.i(FinderThumbPlayerProxy.a(this.sOw), "error " + paramInt1 + ' ' + paramInt2 + ' ' + FinderThumbPlayerProxy.b(this.sOw));
      if (FinderThumbPlayerProxy.j(this.sOw) != 0)
      {
        FinderThumbPlayerProxy.d(this.sOw).reset();
        this.sOw.cLS();
        FinderThumbPlayerProxy.dy("bg prepared error", paramInt2);
        AppMethodBeat.o(204668);
        return;
      }
      parama = this.sOw.getMediaInfo();
      if (parama != null)
      {
        i.b localb = this.sOw.getVideoViewCallback();
        if (localb != null) {
          localb.c("", parama.mediaId, "", paramInt2, paramInt1);
        }
      }
      FinderThumbPlayerProxy.dy("play error", paramInt2);
      AppMethodBeat.o(204668);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "preState", "", "curState", "onStateChange"})
  static final class e
    implements b.h
  {
    e(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void fW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204669);
      ad.i(FinderThumbPlayerProxy.a(this.sOw), "proxy player preState " + paramInt1 + " curState " + paramInt2 + ' ' + FinderThumbPlayerProxy.b(this.sOw));
      Object localObject = this.sOw.getMediaInfo();
      if (localObject != null) {
        switch (paramInt2)
        {
        }
      }
      while ((paramInt2 == 8) || (paramInt2 == 1))
      {
        ad.i(FinderThumbPlayerProxy.a(this.sOw), "proxy player stop or idle " + FinderThumbPlayerProxy.b(this.sOw));
        localObject = this.sOw.getOnPlayerStopListener();
        if (localObject == null) {
          break;
        }
        ((r)localObject).cMK();
        AppMethodBeat.o(204669);
        return;
        i.b localb = this.sOw.getVideoViewCallback();
        if (localb != null) {
          localb.dq("", ((p)localObject).mediaId);
        }
        if (this.sOw.sOb) {
          this.sOw.FX(2);
        }
        for (;;)
        {
          localObject = this.sOw.getResourceLoaderProxy();
          if (localObject == null) {
            break;
          }
          localObject = ((FinderThumbPlayerProxy.b)localObject).sjE;
          if (localObject == null) {
            break;
          }
          ((y)localObject).field_audioBitrate = ((int)FinderThumbPlayerProxy.d(this.sOw).getPropertyLong(com.tencent.thumbplayer.b.l.LONG_AUDIO_BIT_RATE));
          ((y)localObject).field_videoBitrate = ((int)FinderThumbPlayerProxy.d(this.sOw).getPropertyLong(com.tencent.thumbplayer.b.l.LONG_VIDEO_BIT_RATE));
          ((y)localObject).field_frameRate = ((int)FinderThumbPlayerProxy.d(this.sOw).getPropertyLong(com.tencent.thumbplayer.b.l.LONG_VIDEO_FRAME_RATE));
          ad.i(FinderThumbPlayerProxy.a(this.sOw), "update video info when prepared audioBitrate:" + ((y)localObject).field_audioBitrate + " videoBitrate:" + ((y)localObject).field_videoBitrate + " frameRate:" + ((y)localObject).field_frameRate + ' ' + FinderThumbPlayerProxy.b(this.sOw));
          break;
          ad.i(FinderThumbPlayerProxy.a(this.sOw), "background prepared " + FinderThumbPlayerProxy.b(this.sOw));
          FinderThumbPlayerProxy.b(this.sOw, 1);
          FinderThumbPlayerProxy.d(this.sOw).pauseDownload();
        }
        localb = this.sOw.getVideoViewCallback();
        if (localb != null) {
          localb.dt("", ((p)localObject).mediaId);
        }
        localObject = this.sOw.getLifecycle();
        if (localObject != null)
        {
          ((u)localObject).cME();
          continue;
          localb = this.sOw.getVideoViewCallback();
          if (localb != null) {
            localb.ds("", ((p)localObject).mediaId);
          }
          localObject = this.sOw.getLifecycle();
          if (localObject != null)
          {
            ((u)localObject).cMC();
            continue;
            localb = this.sOw.getVideoViewCallback();
            if (localb != null) {
              localb.dr("", ((p)localObject).mediaId);
            }
          }
        }
      }
      AppMethodBeat.o(204669);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "what", "", "arg1", "", "arg2", "extraObject", "", "onInfo"})
  static final class f
    implements b.d
  {
    f(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void a(com.tencent.thumbplayer.b.a parama, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(204670);
      parama = this.sOw.getMediaInfo();
      if (parama != null)
      {
        switch (paramInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(204670);
          return;
          FinderThumbPlayerProxy.n(this.sOw).removeMessages(0);
          FinderThumbPlayerProxy.n(this.sOw).sendMessageDelayed(FinderThumbPlayerProxy.n(this.sOw).obtainMessage(0, parama.mediaId), 500L);
          AppMethodBeat.o(204670);
          return;
          FinderThumbPlayerProxy.n(this.sOw).removeMessages(0);
          if (FinderThumbPlayerProxy.o(this.sOw))
          {
            FinderThumbPlayerProxy.a(this.sOw, false);
            paramObject = this.sOw.getVideoViewCallback();
            if (paramObject != null)
            {
              paramObject.dv("", parama.mediaId);
              AppMethodBeat.o(204670);
              return;
            }
            AppMethodBeat.o(204670);
            return;
          }
          AppMethodBeat.o(204670);
          return;
          parama = this.sOw.getLifecycle();
          if (parama != null) {
            parama.cMD();
          }
          parama = this.sOw.getResourceLoaderProxy();
          if (parama != null)
          {
            ad.i(FinderThumbPlayerProxy.a(parama.sOw), "onReplay " + parama.cMo());
            parama.sOt = 0L;
            AppMethodBeat.o(204670);
            return;
          }
          AppMethodBeat.o(204670);
          return;
          ad.i(FinderThumbPlayerProxy.a(this.sOw), "first video frame ready " + FinderThumbPlayerProxy.b(this.sOw));
          AppMethodBeat.o(204670);
          return;
          ad.i(FinderThumbPlayerProxy.a(this.sOw), "first audio frame ready " + FinderThumbPlayerProxy.b(this.sOw));
          AppMethodBeat.o(204670);
          return;
          if ((paramObject instanceof i.c)) {
            ad.i(FinderThumbPlayerProxy.a(this.sOw), "playableDurationMS: " + ((i.c)paramObject).LZc);
          }
        }
      }
      AppMethodBeat.o(204670);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    g(FinderThumbPlayerProxy paramFinderThumbPlayerProxy)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    h(FinderThumbPlayerProxy paramFinderThumbPlayerProxy)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnDownload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
  public static final class j
    implements e
  {
    j(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void EJ(int paramInt)
    {
      AppMethodBeat.i(204674);
      ad.i(FinderThumbPlayerProxy.a(this.sOw), "real start download task " + FinderThumbPlayerProxy.b(this.sOw) + ' ' + paramInt);
      FinderThumbPlayerProxy.dy("startStreamTask", paramInt);
      AppMethodBeat.o(204674);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-finder_release"})
  public static final class k
    implements com.tencent.mm.plugin.thumbplayer.b.b
  {
    k(FinderThumbPlayerProxy.b paramb) {}
    
    public final com.tencent.mm.i.h ajg(String paramString)
    {
      AppMethodBeat.i(204675);
      d.g.b.p.h(paramString, "id");
      FinderThumbPlayerProxy.b localb = this.sOy;
      paramString = com.tencent.mm.plugin.finder.utils.p.sMo;
      String str2 = localb.mediaId;
      Object localObject1 = localb.sOh.downloadUrl;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      String str3 = localb.sOh.path;
      localObject1 = localb.sOh;
      if (localObject1 != null) {}
      for (localObject1 = ((p)localObject1).path;; localObject1 = null)
      {
        int i = com.tencent.mm.modelcontrol.d.I(1, (String)localObject1);
        Object localObject2 = localb.sjE.field_fileFormat;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        String str4 = localb.sOh.rQu.cCz();
        String str1 = localb.sOh.rQu.siC.decodeKey;
        localObject2 = str1;
        if (str1 == null) {
          localObject2 = "";
        }
        paramString = com.tencent.mm.plugin.finder.utils.p.a(str2, paramString, str3, i, (String)localObject1, str4, (String)localObject2, (h.a)localb, FinderThumbPlayerProxy.a(localb.sOw));
        AppMethodBeat.o(204675);
        return paramString;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnPreload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
  public static final class l
    implements com.tencent.mm.plugin.thumbplayer.b.d
  {
    l(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void EJ(int paramInt)
    {
      AppMethodBeat.i(204676);
      ad.i(FinderThumbPlayerProxy.a(this.sOw), "real start download preload task " + FinderThumbPlayerProxy.b(this.sOw) + ' ' + paramInt);
      FinderThumbPlayerProxy.dy("startPreloadTask", paramInt);
      AppMethodBeat.o(204676);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnPreload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-finder_release"})
  public static final class m
    implements com.tencent.mm.plugin.thumbplayer.b.b
  {
    m(FinderThumbPlayerProxy.b paramb) {}
    
    public final com.tencent.mm.i.h ajg(String paramString)
    {
      AppMethodBeat.i(204677);
      d.g.b.p.h(paramString, "id");
      FinderThumbPlayerProxy.b localb = this.sOz;
      paramString = com.tencent.mm.plugin.finder.utils.p.sMo;
      String str2 = localb.mediaId;
      Object localObject1 = localb.sOh.downloadUrl;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      String str3 = localb.sOh.path;
      localObject1 = localb.sOh;
      if (localObject1 != null) {}
      for (localObject1 = ((p)localObject1).path;; localObject1 = null)
      {
        int i = com.tencent.mm.modelcontrol.d.I(1, (String)localObject1);
        Object localObject2 = localb.sjE.field_fileFormat;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        String str4 = localb.sOh.rQu.cCz();
        String str1 = localb.sOh.rQu.siC.decodeKey;
        localObject2 = str1;
        if (str1 == null) {
          localObject2 = "";
        }
        paramString = com.tencent.mm.plugin.finder.utils.p.a(str2, paramString, str3, i, (String)localObject1, str4, (String)localObject2, (g.a)localb, (g.b)localb, (int)(localb.sOv * 100L / localb.sjE.field_totalSize), localb.sOv, FinderThumbPlayerProxy.a(localb.sOw));
        AppMethodBeat.o(204677);
        return paramString;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startProgressTimer$1", "Ljava/util/TimerTask;", "run", "", "plugin-finder_release"})
  public static final class n
    extends TimerTask
  {
    n(p paramp) {}
    
    public final void run()
    {
      AppMethodBeat.i(204679);
      com.tencent.mm.ad.c.g((d.g.a.a)new a(this));
      FinderThumbPlayerProxy.b localb = this.sOw.getResourceLoaderProxy();
      if (localb != null)
      {
        localb.cMp();
        AppMethodBeat.o(204679);
        return;
      }
      AppMethodBeat.o(204679);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      a(FinderThumbPlayerProxy.n paramn)
      {
        super();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$stopCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "onStop", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-finder_release"})
  public static final class o
    implements com.tencent.mm.plugin.thumbplayer.b.g
  {
    o(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void a(int paramInt, com.tencent.mm.i.h paramh, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(204680);
      FinderThumbPlayerProxy.dy("stopStreamTask", paramInt);
      p localp = this.sOw.getMediaInfo();
      if (localp != null)
      {
        t localt = this.sOw.getDownloadCallback();
        if (localt != null) {
          localt.a(localp.rQu, paramh, paramd);
        }
      }
      ad.i(FinderThumbPlayerProxy.a(this.sOw), "real cancel download task " + FinderThumbPlayerProxy.b(this.sOw) + ' ' + paramInt);
      AppMethodBeat.o(204680);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$stopCdnPreload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "onStop", "", "ret", "", "plugin-finder_release"})
  public static final class p
    implements com.tencent.mm.plugin.thumbplayer.b.f
  {
    p(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void EI(int paramInt)
    {
      AppMethodBeat.i(204681);
      FinderThumbPlayerProxy.dy("stopPreloadTask", paramInt);
      ad.i(FinderThumbPlayerProxy.a(this.sOw), "real cancel preload download task " + FinderThumbPlayerProxy.b(this.sOw) + ' ' + paramInt);
      AppMethodBeat.o(204681);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class q
    implements ap.a
  {
    q(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(204682);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(204682);
        return false;
        paramMessage = paramMessage.obj;
        if ((paramMessage != null) && ((paramMessage instanceof String)) && (this.sOw.sOb))
        {
          FinderThumbPlayerProxy.a(this.sOw, true);
          i.b localb = this.sOw.getVideoViewCallback();
          if (localb != null) {
            localb.du("", (String)paramMessage);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy
 * JD-Core Version:    0.7.0.1
 */