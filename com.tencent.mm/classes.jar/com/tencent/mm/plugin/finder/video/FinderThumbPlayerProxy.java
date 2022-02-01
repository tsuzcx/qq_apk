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
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.a.e;
import com.tencent.mm.plugin.thumbplayer.b.e;
import com.tencent.mm.plugin.thumbplayer.texture.MMThumbPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.thumbplayer.b.b.c;
import com.tencent.thumbplayer.b.b.d;
import com.tencent.thumbplayer.b.b.f;
import com.tencent.thumbplayer.b.b.h;
import com.tencent.thumbplayer.b.i.c;
import com.tencent.thumbplayer.b.p.a;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "bgPrepareStatus", "downloadCallback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "getDownloadCallback", "()Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "setDownloadCallback", "(Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;)V", "firstStart", "", "getFirstStart", "()Z", "setFirstStart", "(Z)V", "isOpenFlowControl", "isPreviewing", "isShouldPlayResume", "setShouldPlayResume", "isStartCdn", "setStartCdn", "isStartCdnPreload", "setStartCdnPreload", "isStartProgressTimer", "setStartProgressTimer", "isViewFocused", "setViewFocused", "isWaiting", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "mediaPreloadCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "getMediaPreloadCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "setMediaPreloadCore", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "onMuteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getOnMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setOnMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "onPlayerStopListener", "Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;", "getOnPlayerStopListener", "()Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;", "setOnPlayerStopListener", "(Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;)V", "progressTimer", "Ljava/util/Timer;", "getProgressTimer", "()Ljava/util/Timer;", "setProgressTimer", "(Ljava/util/Timer;)V", "resourceLoaderProxy", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "getResourceLoaderProxy", "()Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "setResourceLoaderProxy", "(Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;)V", "surface", "Landroid/view/Surface;", "textureUpdateTimes", "textureView", "Lcom/tencent/mm/plugin/thumbplayer/texture/MMThumbPlayerTextureView;", "tpPlayer", "Lcom/tencent/mm/plugin/thumbplayer/player/IMMTPPlayer;", "videoViewCallback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "getVideoViewCallback", "()Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setVideoViewCallback", "(Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;)V", "waitingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "basePlayInfo", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrentPlaySecond", "getCurrentPlayerState", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoMediaId", "getVideoMediaInfo", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "init", "", "initTextureView", "isPause", "isPlaying", "isPrepared", "isPreparing", "isStartPlay", "onRelease", "onUIDestroy", "pause", "pauseWithCancel", "play", "playWithSource", "source", "prepareToPlay", "prepareVideo", "realPlay", "releaseSurface", "detach", "removeVideoFooterView", "seekTo", "timestamp", "", "afterSeekPlay", "setBgPrepareStatus", "status", "setFinderVideoCore", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setIMMVideoViewCallback", "_callback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setLoop", "loop", "setMute", "isMute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isLocal", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setVideoMuteListener", "muteListener", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "showErrToast", "stage", "ret", "startCdnDownload", "startCdnPreload", "startOrPlay", "startProgressTimer", "info", "stop", "stopCdnDownload", "stopCdnPreload", "stopProgressTimer", "Companion", "ResourceLoaderProxy", "plugin-finder_release"})
public final class FinderThumbPlayerProxy
  extends FrameLayout
  implements o
{
  private static final HashSet<Integer> sZA;
  public static final FinderThumbPlayerProxy.a sZB;
  private final String TAG;
  private boolean isWaiting;
  private boolean rzb;
  private com.tencent.mm.plugin.thumbplayer.c.a sZf;
  private MMThumbPlayerTextureView sZg;
  private int sZh;
  private boolean sZi;
  private int sZj;
  private Timer sZk;
  private r sZl;
  boolean sZm;
  private boolean sZn;
  private boolean sZo;
  private boolean sZp;
  private boolean sZq;
  private boolean sZr;
  private p sZs;
  private b sZt;
  private i.b sZu;
  private u sZv;
  private q sZw;
  private t sZx;
  private MediaPreloadCore sZy;
  private aq sZz;
  private Surface surface;
  
  static
  {
    AppMethodBeat.i(205350);
    sZB = new FinderThumbPlayerProxy.a((byte)0);
    sZA = new HashSet();
    AppMethodBeat.o(205350);
  }
  
  public FinderThumbPlayerProxy(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(205347);
    this.TAG = "Finder.FinderThumbPlayerProxy";
    paramContext = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
    d.g.b.p.g(paramContext, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
    this.sZi = ((com.tencent.mm.plugin.thumbplayer.a.a)paramContext).isOpenTPFlowControl();
    this.sZp = true;
    this.sZz = new aq(Looper.getMainLooper(), (aq.a)new p(this));
    init();
    AppMethodBeat.o(205347);
  }
  
  public FinderThumbPlayerProxy(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205348);
    this.TAG = "Finder.FinderThumbPlayerProxy";
    paramContext = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
    d.g.b.p.g(paramContext, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
    this.sZi = ((com.tencent.mm.plugin.thumbplayer.a.a)paramContext).isOpenTPFlowControl();
    this.sZp = true;
    this.sZz = new aq(Looper.getMainLooper(), (aq.a)new p(this));
    init();
    AppMethodBeat.o(205348);
  }
  
  public FinderThumbPlayerProxy(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205349);
    this.TAG = "Finder.FinderThumbPlayerProxy";
    paramContext = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.thumbplayer.a.a.class);
    d.g.b.p.g(paramContext, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
    this.sZi = ((com.tencent.mm.plugin.thumbplayer.a.a)paramContext).isOpenTPFlowControl();
    this.sZp = true;
    this.sZz = new aq(Looper.getMainLooper(), (aq.a)new p(this));
    init();
    AppMethodBeat.o(205349);
  }
  
  private final boolean Gy(int paramInt)
  {
    com.tencent.mm.plugin.thumbplayer.c.a locala = null;
    AppMethodBeat.i(205319);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("prepareVideo source:").append(paramInt).append(" isAllCompleted:");
    Object localObject1 = this.sZt;
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).ssB;
      if (localObject1 != null)
      {
        localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.model.z)localObject1).cEJ());
        localStringBuilder = localStringBuilder.append(localObject1).append(" isMoovReady:");
        localObject1 = this.sZt;
        if (localObject1 == null) {
          break label257;
        }
        localObject1 = ((b)localObject1).ssB;
        if (localObject1 == null) {
          break label257;
        }
      }
    }
    label257:
    for (localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.model.z)localObject1).field_moovReady);; localObject1 = null)
    {
      ae.i((String)localObject2, localObject1 + ' ' + cOK());
      localObject2 = this.surface;
      if (localObject2 != null)
      {
        localObject1 = locala;
        if (((Surface)localObject2).isValid()) {
          localObject1 = localObject2;
        }
        if (localObject1 != null)
        {
          locala = this.sZf;
          if (locala == null) {
            d.g.b.p.bdF("tpPlayer");
          }
          locala.setSurface((Surface)localObject1);
        }
      }
      localObject1 = this.sZt;
      if (localObject1 != null) {
        ((b)localObject1).cOW();
      }
      localObject1 = this.sZt;
      if (localObject1 == null) {
        break label262;
      }
      localObject1 = ((b)localObject1).ssB;
      if ((localObject1 == null) || ((!((com.tencent.mm.plugin.finder.model.z)localObject1).field_moovReady) && (!((com.tencent.mm.plugin.finder.model.z)localObject1).cEJ()))) {
        break label262;
      }
      localObject1 = this.sZf;
      if (localObject1 == null) {
        d.g.b.p.bdF("tpPlayer");
      }
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).prepareAsync();
      AppMethodBeat.o(205319);
      return true;
      localObject1 = null;
      break;
    }
    label262:
    AppMethodBeat.o(205319);
    return false;
  }
  
  private final void a(final p paramp)
  {
    AppMethodBeat.i(205320);
    if (!this.sZo)
    {
      ae.i(this.TAG, "startProgressTimer " + cOK());
      this.sZk = new Timer();
      Timer localTimer = this.sZk;
      if (localTimer != null) {
        localTimer.scheduleAtFixedRate((TimerTask)new m(this, paramp), 0L, 1000L);
      }
      this.sZo = true;
    }
    AppMethodBeat.o(205320);
  }
  
  private final boolean bpC()
  {
    AppMethodBeat.i(205344);
    switch (getCurrentPlayerState())
    {
    default: 
      AppMethodBeat.o(205344);
      return false;
    }
    AppMethodBeat.o(205344);
    return true;
  }
  
  private final String cOK()
  {
    AppMethodBeat.i(205307);
    Object localObject1 = new StringBuilder("loader:");
    Object localObject2 = this.sZt;
    int i;
    if (localObject2 != null)
    {
      i = ((b)localObject2).hashCode();
      StringBuilder localStringBuilder = ((StringBuilder)localObject1).append(i).append(" proxy:").append(hashCode()).append(" mediaId: ");
      localObject1 = this.sZs;
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
      localObject2 = this.sZf;
      if (localObject2 == null) {
        d.g.b.p.bdF("tpPlayer");
      }
      localObject2 = ((StringBuilder)localObject1).append(localObject2.hashCode()).append(" currentStat:").append(getCurrentPlayerState()).append(" viewFocus:").append(this.sZm).append(" alpha:").append(getAlpha()).append(" surface:");
      localObject1 = this.surface;
      if (localObject1 == null) {
        break label202;
      }
    }
    label202:
    for (localObject1 = Boolean.valueOf(((Surface)localObject1).isValid());; localObject1 = null)
    {
      localObject1 = localObject1;
      AppMethodBeat.o(205307);
      return localObject1;
      i = 0;
      break;
    }
  }
  
  private final void cOL()
  {
    AppMethodBeat.i(205318);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("real play ").append(cOK()).append(" surface:");
    Object localObject1 = this.surface;
    if (localObject1 != null) {}
    for (localObject1 = Boolean.valueOf(((Surface)localObject1).isValid());; localObject1 = null)
    {
      ae.i((String)localObject2, localObject1);
      localObject1 = this.sZg;
      if (localObject1 == null) {
        d.g.b.p.bdF("textureView");
      }
      ((MMThumbPlayerTextureView)localObject1).setInterceptDetach(false);
      setBgPrepareStatus(0);
      localObject1 = this.sZf;
      if (localObject1 == null) {
        d.g.b.p.bdF("tpPlayer");
      }
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).start();
      localObject1 = this.sZs;
      if (localObject1 != null)
      {
        localObject2 = this.sZv;
        if (localObject2 != null) {
          ((u)localObject2).cPn();
        }
        a((p)localObject1);
      }
      com.tencent.mm.ac.c.c(this.TAG, (d.g.a.a)new h(this));
      AppMethodBeat.o(205318);
      return;
    }
  }
  
  private final void cOM()
  {
    AppMethodBeat.i(205321);
    if (this.sZo)
    {
      ae.i(this.TAG, "stopProgressTimer " + cOK());
      Timer localTimer = this.sZk;
      if (localTimer != null) {
        localTimer.cancel();
      }
      this.sZk = null;
      this.sZo = false;
    }
    AppMethodBeat.o(205321);
  }
  
  private final void cOP()
  {
    AppMethodBeat.i(205328);
    if (this.sZq)
    {
      ae.i(this.TAG, "already start cdn " + cOK());
      AppMethodBeat.o(205328);
      return;
    }
    cOR();
    Object localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
    Object localObject2 = this.sZt;
    localObject1 = this.sZt;
    if (localObject1 != null) {
      localObject1 = ((b)localObject1).ssB;
    }
    while ((localObject2 != null) && (localObject1 != null))
    {
      ae.i(this.TAG, "startCdnDownload " + cOK());
      MediaPreloadCore localMediaPreloadCore = this.sZy;
      if (localMediaPreloadCore != null) {
        localMediaPreloadCore.bd(((b)localObject2).mediaId, true);
      }
      if (!((com.tencent.mm.plugin.finder.model.z)localObject1).cEJ())
      {
        if (this.sZi)
        {
          localObject1 = this.sZy;
          if (localObject1 != null) {
            ((MediaPreloadCore)localObject1).aiz(((b)localObject2).mediaId);
          }
        }
        ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().a(((b)localObject2).mediaId, (com.tencent.mm.plugin.thumbplayer.b.b)new j((b)localObject2), (e)new i(this));
        this.sZq = true;
        localObject1 = this.sZs;
        if (localObject1 != null)
        {
          localObject2 = this.sZx;
          if (localObject2 != null)
          {
            ((t)localObject2).b(((p)localObject1).rYW);
            AppMethodBeat.o(205328);
            return;
            localObject1 = null;
          }
          else
          {
            AppMethodBeat.o(205328);
          }
        }
        else
        {
          AppMethodBeat.o(205328);
        }
      }
      else
      {
        ae.i(this.TAG, "downloadFinish " + cOK());
      }
    }
    AppMethodBeat.o(205328);
  }
  
  private final void cOQ()
  {
    AppMethodBeat.i(205329);
    if (!this.sZq)
    {
      ae.i(this.TAG, "not start cdn " + cOK());
      AppMethodBeat.o(205329);
      return;
    }
    b localb = this.sZt;
    if (localb != null)
    {
      ae.i(this.TAG, "stopCdnDownload " + cOK());
      MediaPreloadCore localMediaPreloadCore = this.sZy;
      if (localMediaPreloadCore != null) {
        localMediaPreloadCore.bd(localb.mediaId, false);
      }
      localb.mm(false);
      ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().a(localb.mediaId, (com.tencent.mm.plugin.thumbplayer.b.g)new n(this));
      this.sZq = false;
      AppMethodBeat.o(205329);
      return;
    }
    AppMethodBeat.o(205329);
  }
  
  private final void cOR()
  {
    AppMethodBeat.i(205330);
    if (!this.sZr)
    {
      ae.i(this.TAG, "not start preload cdn " + cOK());
      AppMethodBeat.o(205330);
      return;
    }
    b localb = this.sZt;
    if (localb != null)
    {
      ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().a(localb.mediaId, (com.tencent.mm.plugin.thumbplayer.b.f)new o(this));
      this.sZr = false;
      AppMethodBeat.o(205330);
      return;
    }
    AppMethodBeat.o(205330);
  }
  
  private final boolean cOT()
  {
    AppMethodBeat.i(205342);
    switch (getCurrentPlayerState())
    {
    default: 
      AppMethodBeat.o(205342);
      return false;
    }
    AppMethodBeat.o(205342);
    return true;
  }
  
  private final boolean cOU()
  {
    AppMethodBeat.i(205345);
    if (getCurrentPlayerState() == 3)
    {
      AppMethodBeat.o(205345);
      return true;
    }
    AppMethodBeat.o(205345);
    return false;
  }
  
  private final int getCurrentPlayerState()
  {
    AppMethodBeat.i(205341);
    com.tencent.mm.plugin.thumbplayer.c.a locala = this.sZf;
    if (locala == null) {
      d.g.b.p.bdF("tpPlayer");
    }
    int i = locala.gaA().gaW();
    AppMethodBeat.o(205341);
    return i;
  }
  
  private void init()
  {
    AppMethodBeat.i(205306);
    sZA.add(Integer.valueOf(hashCode()));
    ae.i(this.TAG, "create FinderThumbPlayerProxy " + hashCode() + ' ' + sZA);
    Object localObject = com.tencent.mm.plugin.thumbplayer.c.c.BHJ;
    localObject = getContext();
    d.g.b.p.g(localObject, "context");
    localObject = ((Context)localObject).getApplicationContext();
    d.g.b.p.g(localObject, "context.applicationContext");
    d.g.b.p.h(localObject, "context");
    this.sZf = ((com.tencent.mm.plugin.thumbplayer.c.a)new com.tencent.mm.plugin.thumbplayer.c.b((Context)localObject));
    localObject = getContext();
    d.g.b.p.g(localObject, "context");
    this.sZg = new MMThumbPlayerTextureView(((Context)localObject).getApplicationContext());
    localObject = this.sZg;
    if (localObject == null) {
      d.g.b.p.bdF("textureView");
    }
    ((MMThumbPlayerTextureView)localObject).setTextureListenerCallback((TextureView.SurfaceTextureListener)new c(this));
    localObject = this.sZg;
    if (localObject == null) {
      d.g.b.p.bdF("textureView");
    }
    ((MMThumbPlayerTextureView)localObject).setOpaqueInfo(true);
    localObject = this.sZf;
    if (localObject == null) {
      d.g.b.p.bdF("tpPlayer");
    }
    ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).a((b.c)new d(this));
    localObject = this.sZf;
    if (localObject == null) {
      d.g.b.p.bdF("tpPlayer");
    }
    ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).a((b.h)new e(this));
    localObject = this.sZf;
    if (localObject == null) {
      d.g.b.p.bdF("tpPlayer");
    }
    ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).a((b.d)new f(this));
    AppMethodBeat.o(205306);
  }
  
  private final void ml(boolean paramBoolean)
  {
    AppMethodBeat.i(205308);
    ae.i(this.TAG, "releaseSurface " + cOK());
    Object localObject = this.sZf;
    if (localObject == null) {
      d.g.b.p.bdF("tpPlayer");
    }
    ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).setSurface(null);
    localObject = this.surface;
    if (localObject != null) {
      ((Surface)localObject).release();
    }
    this.surface = null;
    if (paramBoolean)
    {
      localObject = this.sZg;
      if (localObject == null) {
        d.g.b.p.bdF("textureView");
      }
      ((MMThumbPlayerTextureView)localObject).fDk();
    }
    AppMethodBeat.o(205308);
  }
  
  private final void setBgPrepareStatus(int paramInt)
  {
    AppMethodBeat.i(205346);
    ae.i(this.TAG, "setBgPrepareStatus " + paramInt + ' ' + cOK());
    this.sZh = paramInt;
    AppMethodBeat.o(205346);
  }
  
  public final boolean Gx(int paramInt)
  {
    AppMethodBeat.i(205317);
    ae.i(this.TAG, "play " + cOK() + " source=" + paramInt);
    if (!this.sZm)
    {
      AppMethodBeat.o(205317);
      return false;
    }
    if (!cOT())
    {
      AppMethodBeat.o(205317);
      return false;
    }
    if (isPlaying())
    {
      AppMethodBeat.o(205317);
      return false;
    }
    Object localObject;
    if (bpC())
    {
      localObject = this.surface;
      if (localObject != null)
      {
        if (!((Surface)localObject).isValid()) {
          break label152;
        }
        if (localObject != null) {
          cOL();
        }
      }
    }
    for (;;)
    {
      cOP();
      localObject = this.sZf;
      if (localObject == null) {
        d.g.b.p.bdF("tpPlayer");
      }
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).gaT();
      AppMethodBeat.o(205317);
      return true;
      label152:
      localObject = null;
      break;
      if (!cOU()) {
        Gy(0);
      }
    }
  }
  
  public final void a(m paramm, boolean paramBoolean, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(205333);
    d.g.b.p.h(paramm, "video");
    d.g.b.p.h(paramFinderItem, "finderItem");
    Object localObject2;
    if (paramBoolean)
    {
      localObject2 = paramm.srx.url;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramm = new p("", (String)localObject1, paramm.aeM(), paramm.srx, paramm, paramFinderItem);
      this.sZs = paramm;
      paramFinderItem = this.sZs;
      if (paramFinderItem != null)
      {
        paramm = this.sZt;
        if (paramm == null) {
          break label439;
        }
        paramm = paramm.mediaId;
        label98:
        if (!(d.g.b.p.i(paramm, paramFinderItem.mediaId) ^ true)) {
          break label444;
        }
        this.sZt = new b(paramFinderItem.mediaId, paramFinderItem);
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("init proxy ");
        paramm = this.sZt;
        if (paramm != null)
        {
          paramFinderItem = paramm.cOX();
          paramm = paramFinderItem;
          if (paramFinderItem != null) {}
        }
        else
        {
          paramm = cOK();
        }
        ae.i((String)localObject1, paramm);
      }
    }
    for (;;)
    {
      paramm = this.sZg;
      if (paramm == null) {
        d.g.b.p.bdF("textureView");
      }
      if (paramm.getParent() != null)
      {
        paramm = this.sZg;
        if (paramm == null) {
          d.g.b.p.bdF("textureView");
        }
        removeView((View)paramm);
      }
      paramm = this.sZs;
      if (paramm == null) {
        break label504;
      }
      paramFinderItem = com.tencent.mm.plugin.finder.utils.p.sXz;
      paramm = com.tencent.mm.plugin.finder.utils.p.fS((int)paramm.rYW.srx.width, (int)paramm.rYW.srx.height);
      int i = paramm.getInt("media_layout_width", 0);
      int j = paramm.getInt("media_layout_height", 0);
      paramm = new FrameLayout.LayoutParams(i, j);
      paramFinderItem = this.sZg;
      if (paramFinderItem == null) {
        d.g.b.p.bdF("textureView");
      }
      addView((View)paramFinderItem, (ViewGroup.LayoutParams)paramm);
      paramm = this.sZg;
      if (paramm == null) {
        d.g.b.p.bdF("textureView");
      }
      paramm.videoWidth = i;
      paramm.videoHeight = j;
      ae.i(this.TAG, "initTextureView videoWidth:" + i + " videoHeight:" + j + ' ' + cOK());
      AppMethodBeat.o(205333);
      return;
      paramm = new p(paramm.getUrl(), paramm.getPath(), paramm.aeM(), paramm.srx, paramm, paramFinderItem);
      break;
      label439:
      paramm = null;
      break label98;
      label444:
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("duplicated mediaId ");
      paramm = this.sZt;
      if (paramm != null)
      {
        paramFinderItem = paramm.cOX();
        paramm = paramFinderItem;
        if (paramFinderItem != null) {}
      }
      else
      {
        paramm = cOK();
      }
      ae.i((String)localObject1, paramm);
    }
    label504:
    paramm = (FinderThumbPlayerProxy)this;
    paramFinderItem = new FrameLayout.LayoutParams(-1, -1);
    Object localObject1 = paramm.sZg;
    if (localObject1 == null) {
      d.g.b.p.bdF("textureView");
    }
    paramm.addView((View)localObject1, (ViewGroup.LayoutParams)paramFinderItem);
    AppMethodBeat.o(205333);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(205331);
    if (!cOT())
    {
      AppMethodBeat.o(205331);
      return false;
    }
    if (!bpC())
    {
      AppMethodBeat.o(205331);
      return false;
    }
    ae.i(this.TAG, "seekTo " + paramDouble + ' ' + paramBoolean);
    Object localObject = this.sZf;
    if (localObject == null) {
      d.g.b.p.bdF("tpPlayer");
    }
    paramDouble = 1000.0D * paramDouble;
    if (Double.isNaN(paramDouble))
    {
      localObject = (Throwable)new IllegalArgumentException("Cannot round NaN value.");
      AppMethodBeat.o(205331);
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
        Gx(0);
      }
      AppMethodBeat.o(205331);
      return true;
      if (paramDouble < -2147483648.0D) {
        i = -2147483648;
      } else {
        i = (int)Math.round(paramDouble);
      }
    }
  }
  
  public final boolean cOA()
  {
    AppMethodBeat.i(205323);
    if (this.sZm)
    {
      AppMethodBeat.o(205323);
      return false;
    }
    if (cOT())
    {
      if ((getCurrentPlayerState() == 2) && (Gy(1)))
      {
        AppMethodBeat.o(205323);
        return true;
      }
      AppMethodBeat.o(205323);
      return false;
    }
    Object localObject1 = this.sZt;
    if (localObject1 != null) {
      ((b)localObject1).cOW();
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
    p localp = this.sZs;
    Object localObject2 = this.sZt;
    localObject1 = this.sZt;
    if (localObject1 != null) {
      localObject1 = ((b)localObject1).ssB;
    }
    while ((localp != null) && (localObject2 != null) && (localObject1 != null))
    {
      ae.i(this.TAG, "prepare to play isAllCompleted:" + ((com.tencent.mm.plugin.finder.model.z)localObject1).cEJ() + " isMoovReady:" + ((com.tencent.mm.plugin.finder.model.z)localObject1).field_moovReady + ' ' + cOK());
      com.tencent.mm.plugin.thumbplayer.c.a locala = this.sZf;
      if (locala == null) {
        d.g.b.p.bdF("tpPlayer");
      }
      locala.aEd(localp.mediaId);
      if ((((com.tencent.mm.plugin.finder.model.z)localObject1).cEJ()) || (bu.isNullOrNil(localp.downloadUrl)))
      {
        localObject1 = com.tencent.mm.vfs.o.k(localp.path, false);
        localObject2 = this.sZf;
        if (localObject2 == null) {
          d.g.b.p.bdF("tpPlayer");
        }
        ((com.tencent.mm.plugin.thumbplayer.c.a)localObject2).setDataSource((String)localObject1);
        Gy(2);
        AppMethodBeat.o(205323);
        return true;
        localObject1 = null;
      }
      else
      {
        localObject1 = new p.a();
        ((p.a)localObject1).bbm(localp.mediaId);
        ((p.a)localObject1).a(new com.tencent.thumbplayer.b.b.b((byte)0));
        locala = this.sZf;
        if (locala == null) {
          d.g.b.p.bdF("tpPlayer");
        }
        locala.b(new com.tencent.thumbplayer.b.f().aV(102, 1000L));
        locala = this.sZf;
        if (locala == null) {
          d.g.b.p.bdF("tpPlayer");
        }
        locala.a(((p.a)localObject1).gaX());
        localObject1 = this.sZf;
        if (localObject1 == null) {
          d.g.b.p.bdF("tpPlayer");
        }
        ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).setDataSource(localp.downloadUrl);
        localObject1 = this.sZf;
        if (localObject1 == null) {
          d.g.b.p.bdF("tpPlayer");
        }
        ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).a((b.f)localObject2);
        if (Gy(3))
        {
          AppMethodBeat.o(205323);
          return true;
        }
      }
    }
    AppMethodBeat.o(205323);
    return false;
  }
  
  public final boolean cOB()
  {
    return this.rzb;
  }
  
  public final boolean cON()
  {
    AppMethodBeat.i(205322);
    if (!this.sZm)
    {
      AppMethodBeat.o(205322);
      return false;
    }
    if (this.sZp)
    {
      ae.i(this.TAG, "first time to play " + cOK());
      localObject1 = this.sZv;
      if (localObject1 != null) {
        ((u)localObject1).GA(this.sZh);
      }
      this.sZp = false;
    }
    if (cOT())
    {
      if (Gx(3)) {
        this.sZj = 0;
      }
      AppMethodBeat.o(205322);
      return false;
    }
    Object localObject1 = this.sZt;
    if (localObject1 != null) {
      ((b)localObject1).cOW();
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
    p localp = this.sZs;
    Object localObject2 = this.sZt;
    localObject1 = this.sZt;
    com.tencent.mm.plugin.thumbplayer.c.a locala;
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).ssB;
      if ((localp == null) || (localObject2 == null) || (localObject1 == null)) {
        break label472;
      }
      ae.i(this.TAG, "start or play isAllCompleted:" + ((com.tencent.mm.plugin.finder.model.z)localObject1).cEJ() + " isMoovReady:" + ((com.tencent.mm.plugin.finder.model.z)localObject1).field_moovReady + ' ' + cOK());
      this.sZj = 0;
      locala = this.sZf;
      if (locala == null) {
        d.g.b.p.bdF("tpPlayer");
      }
      locala.aEd(localp.mediaId);
      if ((!((com.tencent.mm.plugin.finder.model.z)localObject1).cEJ()) && (!bu.isNullOrNil(localp.downloadUrl))) {
        break label312;
      }
      localObject1 = com.tencent.mm.vfs.o.k(localp.path, false);
      localObject2 = this.sZf;
      if (localObject2 == null) {
        d.g.b.p.bdF("tpPlayer");
      }
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject2).setDataSource((String)localObject1);
      Gy(4);
    }
    for (;;)
    {
      AppMethodBeat.o(205322);
      return true;
      localObject1 = null;
      break;
      label312:
      localObject1 = new p.a();
      ((p.a)localObject1).bbm(localp.mediaId);
      ((p.a)localObject1).a(new com.tencent.thumbplayer.b.b.b((byte)0));
      locala = this.sZf;
      if (locala == null) {
        d.g.b.p.bdF("tpPlayer");
      }
      locala.b(new com.tencent.thumbplayer.b.f().aV(102, 1000L));
      locala = this.sZf;
      if (locala == null) {
        d.g.b.p.bdF("tpPlayer");
      }
      locala.a(((p.a)localObject1).gaX());
      localObject1 = this.sZf;
      if (localObject1 == null) {
        d.g.b.p.bdF("tpPlayer");
      }
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).setDataSource(localp.downloadUrl);
      localObject1 = this.sZf;
      if (localObject1 == null) {
        d.g.b.p.bdF("tpPlayer");
      }
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).a((b.f)localObject2);
      Gy(5);
      cOP();
    }
    label472:
    AppMethodBeat.o(205322);
    return false;
  }
  
  public final int cOO()
  {
    AppMethodBeat.i(205325);
    ae.i(this.TAG, "pauseWithCancel " + cOK());
    pause();
    AppMethodBeat.o(205325);
    return 0;
  }
  
  public final void cOS() {}
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(205309);
    Object localObject = this.sZg;
    if (localObject == null) {
      d.g.b.p.bdF("textureView");
    }
    localObject = ((MMThumbPlayerTextureView)localObject).getBitmap();
    AppMethodBeat.o(205309);
    return localObject;
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(205310);
    com.tencent.mm.plugin.thumbplayer.c.a locala = this.sZf;
    if (locala == null) {
      d.g.b.p.bdF("tpPlayer");
    }
    int i = (int)(locala.getCurrentPositionMs() / 1000L);
    AppMethodBeat.o(205310);
    return i;
  }
  
  public final t getDownloadCallback()
  {
    return this.sZx;
  }
  
  public final boolean getFirstStart()
  {
    return this.sZp;
  }
  
  public final boolean getIsNeverStart()
  {
    AppMethodBeat.i(205312);
    if (!cOT())
    {
      AppMethodBeat.o(205312);
      return true;
    }
    AppMethodBeat.o(205312);
    return false;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.sZn;
  }
  
  public final u getLifecycle()
  {
    return this.sZv;
  }
  
  public final p getMediaInfo()
  {
    return this.sZs;
  }
  
  public final MediaPreloadCore getMediaPreloadCore()
  {
    return this.sZy;
  }
  
  public final q getOnMuteListener()
  {
    return this.sZw;
  }
  
  public final r getOnPlayerStopListener()
  {
    return this.sZl;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(205313);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(205313);
    return localViewParent;
  }
  
  public final Timer getProgressTimer()
  {
    return this.sZk;
  }
  
  public final b getResourceLoaderProxy()
  {
    return this.sZt;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(205311);
    com.tencent.mm.plugin.thumbplayer.c.a locala = this.sZf;
    if (locala == null) {
      d.g.b.p.bdF("tpPlayer");
    }
    int i = (int)(locala.getDurationMs() / 1000L);
    AppMethodBeat.o(205311);
    return i;
  }
  
  public final String getVideoMediaId()
  {
    Object localObject = this.sZs;
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
    return this.sZs;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final i.b getVideoViewCallback()
  {
    return this.sZu;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.sZm;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(205343);
    if (getCurrentPlayerState() == 5)
    {
      AppMethodBeat.o(205343);
      return true;
    }
    AppMethodBeat.o(205343);
    return false;
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(205340);
    ae.i(this.TAG, "release " + cOK());
    ml(true);
    this.sZx = null;
    this.sZt = null;
    com.tencent.mm.ac.c.c(this.TAG, (d.g.a.a)new g(this));
    sZA.remove(Integer.valueOf(hashCode()));
    AppMethodBeat.o(205340);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(205327);
    ae.i(this.TAG, "onUIDestroy " + cOK());
    stop();
    AppMethodBeat.o(205327);
  }
  
  public final boolean pause()
  {
    Object localObject3 = null;
    int i = 0;
    AppMethodBeat.i(205324);
    ae.i(this.TAG, "pause  " + cOK());
    if (!cOT())
    {
      AppMethodBeat.o(205324);
      return false;
    }
    Object localObject1;
    if (isPlaying())
    {
      localObject1 = this.sZf;
      if (localObject1 == null) {
        d.g.b.p.bdF("tpPlayer");
      }
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).pause();
      localObject1 = this.sZf;
      if (localObject1 == null) {
        d.g.b.p.bdF("tpPlayer");
      }
      ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).pauseDownload();
      localObject1 = this.sZg;
      if (localObject1 == null) {
        d.g.b.p.bdF("textureView");
      }
      ((MMThumbPlayerTextureView)localObject1).setInterceptDetach(true);
      cOQ();
      if (this.sZn)
      {
        if (!this.sZr) {
          break label396;
        }
        ae.i(this.TAG, "already start preload cdn " + cOK());
      }
    }
    for (;;)
    {
      cOM();
      if (this.sZs != null)
      {
        localObject1 = this.sZv;
        if (localObject1 != null) {
          ((u)localObject1).cPl();
        }
      }
      AppMethodBeat.o(205324);
      return true;
      if (!cOU()) {
        break;
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      Object localObject4 = this.sZt;
      localObject1 = this.sZt;
      label232:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((b)localObject1).ssB;
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject2 = localObject3;
          if (localObject1 != null)
          {
            if (((com.tencent.mm.plugin.finder.model.z)localObject1).field_moovReady) {
              break label383;
            }
            ae.i(this.TAG, "preparing, but moov not ready, try stop");
            localObject1 = this.sZf;
            if (localObject1 == null) {
              d.g.b.p.bdF("tpPlayer");
            }
            ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).stop();
            localObject1 = this.sZf;
            if (localObject1 == null) {
              d.g.b.p.bdF("tpPlayer");
            }
            ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).reset();
          }
        }
      }
      for (;;)
      {
        localObject2 = d.z.Nhr;
        if (localObject2 != null) {
          break;
        }
        localObject1 = (FinderThumbPlayerProxy)this;
        ae.w(((FinderThumbPlayerProxy)localObject1).TAG, "occur error, stop and reset");
        localObject2 = ((FinderThumbPlayerProxy)localObject1).sZf;
        if (localObject2 == null) {
          d.g.b.p.bdF("tpPlayer");
        }
        ((com.tencent.mm.plugin.thumbplayer.c.a)localObject2).stop();
        localObject1 = ((FinderThumbPlayerProxy)localObject1).sZf;
        if (localObject1 == null) {
          d.g.b.p.bdF("tpPlayer");
        }
        ((com.tencent.mm.plugin.thumbplayer.c.a)localObject1).reset();
        localObject1 = d.z.Nhr;
        break;
        localObject1 = null;
        break label232;
        label383:
        ae.i(this.TAG, "preparing, but moov ready, wait for prepared");
      }
      label396:
      localObject3 = this.sZt;
      if ((localObject3 != null) && (((b)localObject3).ssB.field_cacheSize < ((b)localObject3).sZG) && (((b)localObject3).ssB.field_totalSize > 0L))
      {
        localObject1 = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController();
        localObject2 = ((b)localObject3).mediaId;
        localObject3 = (com.tencent.mm.plugin.thumbplayer.b.b)new l((b)localObject3);
        localObject4 = (com.tencent.mm.plugin.thumbplayer.b.d)new k(this);
        d.g.b.p.h(localObject2, "mediaId");
        d.g.b.p.h(localObject3, "createCallback");
        if (((CharSequence)localObject2).length() == 0) {
          i = 1;
        }
        if (i == 0) {
          com.tencent.mm.ac.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new a.e((com.tencent.mm.plugin.thumbplayer.b.a)localObject1, (com.tencent.mm.plugin.thumbplayer.b.b)localObject3, (String)localObject2, (com.tencent.mm.plugin.thumbplayer.b.d)localObject4));
        }
        this.sZr = true;
      }
    }
  }
  
  public final boolean play()
  {
    AppMethodBeat.i(205316);
    boolean bool = Gx(0);
    AppMethodBeat.o(205316);
    return bool;
  }
  
  public final void setDownloadCallback(t paramt)
  {
    this.sZx = paramt;
  }
  
  public final void setFinderVideoCore(i parami) {}
  
  public final void setFirstStart(boolean paramBoolean)
  {
    this.sZp = paramBoolean;
  }
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(205334);
    d.g.b.p.h(paramb, "_callback");
    this.sZu = paramb;
    AppMethodBeat.o(205334);
  }
  
  public final void setIOnlineVideoProxy(com.tencent.mm.modelvideo.b paramb)
  {
    AppMethodBeat.i(205336);
    d.g.b.p.h(paramb, "_proxy");
    AppMethodBeat.o(205336);
  }
  
  public final void setInterceptDetach(boolean paramBoolean)
  {
    AppMethodBeat.i(205315);
    MMThumbPlayerTextureView localMMThumbPlayerTextureView = this.sZg;
    if (localMMThumbPlayerTextureView == null) {
      d.g.b.p.bdF("textureView");
    }
    localMMThumbPlayerTextureView.setInterceptDetach(paramBoolean);
    AppMethodBeat.o(205315);
  }
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    this.sZn = paramBoolean;
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean) {}
  
  public final void setLifecycle(u paramu)
  {
    this.sZv = paramu;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(205337);
    com.tencent.mm.plugin.thumbplayer.c.a locala = this.sZf;
    if (locala == null) {
      d.g.b.p.bdF("tpPlayer");
    }
    locala.zJ(paramBoolean);
    AppMethodBeat.o(205337);
  }
  
  public final void setMediaInfo(p paramp)
  {
    this.sZs = paramp;
  }
  
  public final void setMediaPreloadCore(MediaPreloadCore paramMediaPreloadCore)
  {
    this.sZy = paramMediaPreloadCore;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(205332);
    com.tencent.mm.plugin.thumbplayer.c.a locala = this.sZf;
    if (locala == null) {
      d.g.b.p.bdF("tpPlayer");
    }
    locala.zK(paramBoolean);
    AppMethodBeat.o(205332);
  }
  
  public final void setOnMuteListener(q paramq)
  {
    this.sZw = paramq;
  }
  
  public final void setOnPlayerStopListener(r paramr)
  {
    this.sZl = paramr;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    this.rzb = paramBoolean;
  }
  
  public final void setProgressTimer(Timer paramTimer)
  {
    this.sZk = paramTimer;
  }
  
  public final void setResourceLoaderProxy(b paramb)
  {
    this.sZt = paramb;
  }
  
  public final void setScaleType(i.e parame)
  {
    AppMethodBeat.i(205335);
    d.g.b.p.h(parame, "scaleType");
    AppMethodBeat.o(205335);
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.sZn = paramBoolean;
  }
  
  public final void setStartCdn(boolean paramBoolean)
  {
    this.sZq = paramBoolean;
  }
  
  public final void setStartCdnPreload(boolean paramBoolean)
  {
    this.sZr = paramBoolean;
  }
  
  public final void setStartProgressTimer(boolean paramBoolean)
  {
    this.sZo = paramBoolean;
  }
  
  public final void setVideoMuteListener(q paramq)
  {
    AppMethodBeat.i(205339);
    d.g.b.p.h(paramq, "muteListener");
    this.sZw = paramq;
    AppMethodBeat.o(205339);
  }
  
  public final void setVideoPlayLifecycle(u paramu)
  {
    AppMethodBeat.i(205338);
    d.g.b.p.h(paramu, "lifecycle");
    this.sZv = paramu;
    AppMethodBeat.o(205338);
  }
  
  public final void setVideoViewCallback(i.b paramb)
  {
    this.sZu = paramb;
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(205314);
    ae.i(this.TAG, "setVideoViewFocused " + paramBoolean + ' ' + cOK());
    this.sZm = paramBoolean;
    AppMethodBeat.o(205314);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.sZm = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(205326);
    ae.i(this.TAG, "stop " + cOK());
    if (!cOT())
    {
      AppMethodBeat.o(205326);
      return;
    }
    Object localObject = this.sZv;
    if (localObject != null) {
      ((u)localObject).b(this.sZs);
    }
    localObject = this.sZf;
    if (localObject == null) {
      d.g.b.p.bdF("tpPlayer");
    }
    ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).stop();
    localObject = this.sZf;
    if (localObject == null) {
      d.g.b.p.bdF("tpPlayer");
    }
    ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).reset();
    cOM();
    cOQ();
    cOR();
    this.sZp = false;
    setBgPrepareStatus(0);
    AppMethodBeat.o(205326);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnResourceLoaderListener;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "mediaId", "", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "(Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "MAX_REQUEST_BUFFER", "", "getMAX_REQUEST_BUFFER", "()I", "MIN_CHECK_BUFFER", "getMIN_CHECK_BUFFER", "isRequestingData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setRequestingData", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "lastOnReadDataEnd", "", "getLastOnReadDataEnd", "()J", "setLastOnReadDataEnd", "(J)V", "mediaCache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "getMediaCache", "()Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "setMediaCache", "(Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;)V", "getMediaId", "()Ljava/lang/String;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "requestOffset", "getRequestOffset", "setRequestOffset", "baseInfo", "callback", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "checkRequestData", "", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "createVideoPreloadCDNTask", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "buff", "Ljava/io/ByteArrayOutputStream;", "getContentType", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "taskId", "fileKey", "getDataFilePath", "getDataTotalSize", "onDataAvailable", "offset", "length", "onFinish", "ret", "onMoovReady", "svrflag", "onPreloadCompleted", "onProgress", "total", "onReadData", "onReplay", "onStartReadData", "requestStart", "requestEnd", "onStopReadData", "updateMediaCache", "updateRequestingData", "value", "plugin-finder_release"})
  public final class b
    implements g.a, g.b, h.a, b.f
  {
    final String mediaId;
    private final int sZC;
    private final int sZD;
    long sZE;
    private AtomicBoolean sZF;
    long sZG;
    final p sZs;
    com.tencent.mm.plugin.finder.model.z ssB;
    
    public b(p paramp)
    {
      AppMethodBeat.i(205287);
      this.mediaId = paramp;
      this.sZs = ((p)localObject);
      this.sZC = 1048576;
      this.sZD = 131072;
      this.sZF = new AtomicBoolean(false);
      paramp = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
      this.ssB = com.tencent.mm.plugin.finder.storage.logic.c.bi(this.mediaId, true);
      ae.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "create ResourceLoaderProxy, mediaCache path:" + this.ssB.getFilePath() + ", mediaInfo path:" + this.sZs.path);
      switch (this.ssB.field_state)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(205287);
        return;
        this$1 = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
        String str = this.mediaId;
        paramp = this.sZs.rYW.srx.mediaId;
        this$1 = paramp;
        if (paramp == null) {
          this$1 = "";
        }
        localObject = this.sZs.downloadUrl;
        paramp = (p)localObject;
        if (localObject == null) {
          paramp = "";
        }
        com.tencent.mm.plugin.finder.storage.logic.c.a(str, FinderThumbPlayerProxy.this, paramp, this.sZs.rYW.ssj, this.sZs.rYW.sry.detail, 0L, 0L, 1, this.sZs.rYW.srx.videoDuration, "", "");
        cOW();
      }
    }
    
    public final int a(com.tencent.thumbplayer.b.a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(205276);
      ae.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "onStartReadData taskId:" + paramLong + " fileKey:" + paramString + ' ' + cOX());
      AppMethodBeat.o(205276);
      return 0;
    }
    
    public final int a(com.tencent.thumbplayer.b.a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(205274);
      ae.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "onStartReadData taskId:" + paramLong1 + " fileKey:" + paramString + " requestStart:" + paramLong2 + " requestEnd" + paramLong3 + ' ' + cOX());
      this.sZE = paramLong2;
      int i = (int)paramLong1;
      AppMethodBeat.o(205274);
      return i;
    }
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      int i = 1;
      AppMethodBeat.i(205285);
      d.g.b.p.h(paramString, "mediaId");
      String str = FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this);
      StringBuilder localStringBuilder = new StringBuilder("[onPreloadProgress] mediaId=").append(paramString).append(" startRet=").append(paramInt).append(" finishedLength=");
      if (paramc != null)
      {
        paramd = Long.valueOf(paramc.field_finishedLength);
        ae.i(str, paramd + ' ' + cOX());
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
          paramd = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
          com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, paramc.field_finishedLength, paramc.field_toltalLength, paramInt);
          cOW();
          paramc = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
          com.tencent.mm.plugin.finder.storage.logic.c.ajz(paramString);
        }
        AppMethodBeat.o(205285);
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
      AppMethodBeat.i(205280);
      d.g.b.p.h(paramString, "mediaId");
      d.g.b.p.h(paramd, "sceneResult");
      ae.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "[onFinish] mediaId=" + paramString + " ret=" + paramInt + " recvedBytes=" + paramd.field_recvedBytes + " fileLength=" + paramd.field_fileLength + "  finderformat:" + paramd.field_videoFormat);
      Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
      com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, paramd.field_fileLength, paramd.field_fileLength, 3);
      cOW();
      mm(false);
      localObject = new long[3];
      int i = CdnLogic.queryDownloadedSize(paramString, (long[])localObject);
      ae.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "check download size " + i + ' ' + localObject[0] + ' ' + localObject[1] + ' ' + localObject[2]);
      com.tencent.mm.ac.c.h((d.g.a.a)new b(this, paramInt, paramd));
      paramd = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
      com.tencent.mm.plugin.finder.storage.logic.c.ajz(paramString);
      AppMethodBeat.o(205280);
    }
    
    public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(205283);
      d.g.b.p.h(paramString1, "mediaId");
      ae.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "[onMoovReady] mediaId=" + paramString1 + " offset=" + paramLong1 + " length=" + paramLong2 + " svrflag=" + paramString2 + ' ' + cOX());
      Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
      localObject = paramString2;
      if (paramString2 == null) {
        localObject = "";
      }
      com.tencent.mm.plugin.finder.storage.logic.c.gu(paramString1, (String)localObject);
      cOW();
      if ((!FinderThumbPlayerProxy.e(FinderThumbPlayerProxy.this)) && (!FinderThumbPlayerProxy.f(FinderThumbPlayerProxy.this)))
      {
        ae.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "try to prepared");
        FinderThumbPlayerProxy.g(FinderThumbPlayerProxy.this);
      }
      paramString2 = FinderThumbPlayerProxy.this.getDownloadCallback();
      if (paramString2 != null) {
        paramString2.a((int)paramLong1, (int)paramLong2, this.sZs.rYW);
      }
      paramString2 = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
      com.tencent.mm.plugin.finder.storage.logic.c.ajz(paramString1);
      com.tencent.mm.ac.c.c(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), (d.g.a.a)new c(this));
      AppMethodBeat.o(205283);
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(205284);
      d.g.b.p.h(paramString, "mediaId");
      AppMethodBeat.o(205284);
    }
    
    public final int b(com.tencent.thumbplayer.b.a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(205275);
      int m = 0;
      int n = (int)paramLong2;
      int i1 = (int)paramLong2;
      int j;
      if (paramLong3 < this.sZC)
      {
        j = (int)paramLong3;
        if (paramLong3 <= this.sZD) {
          break label185;
        }
      }
      label167:
      label185:
      for (int k = this.sZD;; k = (int)paramLong3)
      {
        i = -1;
        if (!this.ssB.cEJ()) {
          break label193;
        }
        j = (int)paramLong3;
        this.sZG = (paramLong2 + paramLong3);
        if (j <= 0) {
          break label499;
        }
        ae.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "onReadData taskId:" + paramLong1 + " requestOffset:" + n + " returnLength:" + j + " checkRet:" + i + " originLength:" + paramLong3 + ' ' + cOX());
        AppMethodBeat.o(205275);
        return j;
        j = this.sZC;
        break;
      }
      label193:
      parama = new long[3];
      int i = m;
      if (CdnLogic.queryDownloadedSize(this.mediaId, parama) == 0)
      {
        i = m;
        if (parama[0] > i1)
        {
          if (parama[0] >= i1 + paramLong3) {
            break label463;
          }
          i = (int)(parama[0] - i1);
        }
      }
      label249:
      if (i == 0)
      {
        m = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().aA(this.mediaId, i1, k);
        if (m != 1) {
          break label585;
        }
        i = k;
      }
      label585:
      for (;;)
      {
        if ((m == 0) && (!FinderThumbPlayerProxy.c(FinderThumbPlayerProxy.this)) && (this.ssB.field_moovReady) && (!this.sZF.get()))
        {
          k = j;
          if (n + j > this.ssB.field_totalSize) {
            k = (int)(this.ssB.field_totalSize - n);
          }
          ae.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "start to request data requestOffset:" + n + " requestLength:" + k + ' ' + cOX());
          if (((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().a(this.mediaId, n, k, (com.tencent.mm.plugin.thumbplayer.b.c)new d(this)) > 0) {
            mm(true);
          }
        }
        j = i;
        i = m;
        break;
        label463:
        i = (int)paramLong3;
        break label249;
        m = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().aA(this.mediaId, i1, j);
        continue;
        label499:
        ae.d(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "onReadData taskId:" + paramLong1 + " requestOffset:" + n + " returnLength:" + j + " checkRet:" + i + " originLength:" + paramLong3 + ' ' + cOX());
        break label167;
      }
    }
    
    public final long b(com.tencent.thumbplayer.b.a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(205278);
      ae.d(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "getDataTotalSize " + this.ssB.field_totalSize + ' ' + FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this));
      paramLong = this.ssB.field_totalSize;
      AppMethodBeat.o(205278);
      return paramLong;
    }
    
    public final void b(String paramString, com.tencent.mm.i.d paramd)
    {
      Object localObject = null;
      AppMethodBeat.i(205286);
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
        ae.i(str, paramString + ' ' + cOX());
        FinderThumbPlayerProxy.h(FinderThumbPlayerProxy.this);
        AppMethodBeat.o(205286);
        return;
      }
    }
    
    public final String c(com.tencent.thumbplayer.b.a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(205279);
      parama = com.tencent.mm.vfs.o.k(this.ssB.getFilePath(), false);
      ae.d(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "getDataFilePath origin:" + this.ssB.getFilePath() + " export:" + parama + ' ' + com.tencent.mm.vfs.o.fB(this.ssB.getFilePath()));
      d.g.b.p.g(parama, "filePath");
      AppMethodBeat.o(205279);
      return parama;
    }
    
    public final void cOW()
    {
      AppMethodBeat.i(205271);
      com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
      this.ssB = com.tencent.mm.plugin.finder.storage.logic.c.ajA(this.mediaId);
      AppMethodBeat.o(205271);
    }
    
    public final String cOX()
    {
      AppMethodBeat.i(205273);
      String str = FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this) + " moov:" + this.ssB.field_moovReady + " request:" + this.sZF.get() + " isFinish:" + this.ssB.cEJ() + " requestOffset:" + this.sZE + " total:" + this.ssB.field_totalSize;
      AppMethodBeat.o(205273);
      return str;
    }
    
    public final void cOY()
    {
      AppMethodBeat.i(205277);
      if (!FinderThumbPlayerProxy.c(FinderThumbPlayerProxy.this))
      {
        AppMethodBeat.o(205277);
        return;
      }
      ae.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "checkRequestData " + cOX());
      long l1;
      if ((this.ssB.field_moovReady) && (!this.sZF.get()) && (!this.ssB.cEJ()))
      {
        if (this.ssB.field_totalSize <= 0L) {
          break label479;
        }
        l1 = FinderThumbPlayerProxy.d(FinderThumbPlayerProxy.this).getDurationMs();
        if (l1 != 0L) {
          break label486;
        }
        l1 = this.sZs.rYW.srx.videoDuration * 1000L;
      }
      label479:
      label486:
      for (;;)
      {
        long l3 = FinderThumbPlayerProxy.d(FinderThumbPlayerProxy.this).getCurrentPositionMs();
        long l2 = (5000L + l3) * 100L / l1;
        int i = (int)(d.k.j.aH(this.ssB.field_totalSize * l2 / 100L + 131072L, this.ssB.field_totalSize) - this.sZE);
        i = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().aA(this.mediaId, (int)this.sZE, i);
        MediaPreloadCore localMediaPreloadCore;
        if (i == 1)
        {
          localMediaPreloadCore = FinderThumbPlayerProxy.this.getMediaPreloadCore();
          if (localMediaPreloadCore != null)
          {
            localMediaPreloadCore.aiA(this.mediaId);
            AppMethodBeat.o(205277);
            return;
          }
          AppMethodBeat.o(205277);
          return;
        }
        if (i == 0)
        {
          l1 = (10000L + l3) * 100L / l1;
          i = (int)(d.k.j.aH(this.ssB.field_totalSize * l1 / 100L + 131072L, this.ssB.field_totalSize) - this.sZE);
          ae.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "start to request data minCachePlayPercent:" + l2 + " targetPlayPercent:" + l1 + " requestOffset:" + this.sZE + " requestLength:" + i + ' ' + cOX());
          if (((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().a(this.mediaId, (int)this.sZE, i, (com.tencent.mm.plugin.thumbplayer.b.c)new a(this)) > 0) {
            mm(true);
          }
        }
        AppMethodBeat.o(205277);
        return;
        if (this.ssB.cEJ())
        {
          localMediaPreloadCore = FinderThumbPlayerProxy.this.getMediaPreloadCore();
          if (localMediaPreloadCore != null)
          {
            localMediaPreloadCore.aiA(this.mediaId);
            AppMethodBeat.o(205277);
            return;
          }
        }
        AppMethodBeat.o(205277);
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
      AppMethodBeat.i(205281);
      d.g.b.p.h(paramString, "mediaId");
      ae.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "[onProgress] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2 + ' ' + cOX());
      Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
      com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, paramLong1, paramLong2, 1);
      cOW();
      localObject = FinderThumbPlayerProxy.this.getDownloadCallback();
      if (localObject != null) {
        ((t)localObject).b((int)paramLong1, (int)paramLong2, this.sZs.rYW);
      }
      localObject = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
      com.tencent.mm.plugin.finder.storage.logic.c.ajz(paramString);
      AppMethodBeat.o(205281);
    }
    
    public final void mm(boolean paramBoolean)
    {
      AppMethodBeat.i(205272);
      ae.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "setRequestingData " + paramBoolean + ' ' + cOX());
      this.sZF.set(paramBoolean);
      AppMethodBeat.o(205272);
    }
    
    public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(205282);
      d.g.b.p.h(paramString, "mediaId");
      mm(false);
      ae.i(FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this), "[onDataAvailable] mediaId=" + paramString + " offset=" + paramLong1 + " length=" + paramLong2 + ' ' + cOX());
      AppMethodBeat.o(205282);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy$checkRequestData$requestDataRet$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "onRequest", "", "ret", "", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.plugin.thumbplayer.b.c
    {
      public final void Gz(int paramInt)
      {
        AppMethodBeat.i(205267);
        if (paramInt != 0)
        {
          ae.i(FinderThumbPlayerProxy.a(this.sZI.sZH), "request data fail " + this.sZI.cOX());
          this.sZI.mm(false);
          AppMethodBeat.o(205267);
          return;
        }
        ae.i(FinderThumbPlayerProxy.a(this.sZI.sZH), "real start request data " + this.sZI.cOX());
        AppMethodBeat.o(205267);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<d.z>
    {
      b(FinderThumbPlayerProxy.b paramb, int paramInt, com.tencent.mm.i.d paramd)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.q
      implements d.g.a.a<d.z>
    {
      c(FinderThumbPlayerProxy.b paramb)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy$onReadData$requestDataRet$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "onRequest", "", "ret", "", "plugin-finder_release"})
    public static final class d
      implements com.tencent.mm.plugin.thumbplayer.b.c
    {
      public final void Gz(int paramInt)
      {
        AppMethodBeat.i(205270);
        if (paramInt != 0)
        {
          ae.i(FinderThumbPlayerProxy.a(this.sZI.sZH), "request data fail " + this.sZI.cOX());
          this.sZI.mm(false);
        }
        AppMethodBeat.o(205270);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-finder_release"})
  public static final class c
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Object localObject = null;
      String str = null;
      AppMethodBeat.i(205290);
      Surface localSurface;
      if (FinderThumbPlayerProxy.m(this.sZH) == null)
      {
        ae.i(FinderThumbPlayerProxy.a(this.sZH), "onSurfaceTextureAvailable " + FinderThumbPlayerProxy.b(this.sZH) + " texture:" + hashCode() + " width:" + paramInt1 + " height:" + paramInt2);
        localObject = FinderThumbPlayerProxy.d(this.sZH);
        if (paramSurfaceTexture != null)
        {
          FinderThumbPlayerProxy.a(this.sZH, new Surface(paramSurfaceTexture));
          ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).setSurface(FinderThumbPlayerProxy.m(this.sZH));
          if (this.sZH.getMediaInfo() != null) {
            this.sZH.Gx(1);
          }
          localObject = FinderThumbPlayerProxy.a(this.sZH);
          localStringBuilder = new StringBuilder("set surface ");
          localSurface = FinderThumbPlayerProxy.m(this.sZH);
          paramSurfaceTexture = str;
          if (localSurface != null) {
            paramSurfaceTexture = Boolean.valueOf(localSurface.isValid());
          }
          ae.i((String)localObject, paramSurfaceTexture + ' ' + FinderThumbPlayerProxy.b(this.sZH));
          AppMethodBeat.o(205290);
          return;
        }
        AppMethodBeat.o(205290);
        return;
      }
      str = FinderThumbPlayerProxy.a(this.sZH);
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable ").append(FinderThumbPlayerProxy.b(this.sZH)).append(" texture:").append(hashCode()).append(" surface:");
      paramSurfaceTexture = FinderThumbPlayerProxy.m(this.sZH);
      if (paramSurfaceTexture != null) {}
      for (paramSurfaceTexture = Boolean.valueOf(paramSurfaceTexture.isValid());; paramSurfaceTexture = null)
      {
        localStringBuilder = localStringBuilder.append(paramSurfaceTexture).append('_');
        localSurface = FinderThumbPlayerProxy.m(this.sZH);
        paramSurfaceTexture = (SurfaceTexture)localObject;
        if (localSurface != null) {
          paramSurfaceTexture = Integer.valueOf(localSurface.hashCode());
        }
        ae.i(str, paramSurfaceTexture + " width:" + paramInt1 + " height:" + paramInt2);
        AppMethodBeat.o(205290);
        return;
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(205289);
      ae.i(FinderThumbPlayerProxy.a(this.sZH), "onSurfaceTextureDestroyed " + FinderThumbPlayerProxy.b(this.sZH) + " texture:" + hashCode());
      FinderThumbPlayerProxy.l(this.sZH);
      AppMethodBeat.o(205289);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205291);
      ae.i(FinderThumbPlayerProxy.a(this.sZH), "onSurfaceTextureSizeChanged " + FinderThumbPlayerProxy.b(this.sZH) + " texture:" + hashCode() + ' ' + paramInt1 + ' ' + paramInt2);
      AppMethodBeat.o(205291);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(205288);
      paramSurfaceTexture = this.sZH;
      FinderThumbPlayerProxy.a(paramSurfaceTexture, FinderThumbPlayerProxy.i(paramSurfaceTexture) + 1);
      paramSurfaceTexture = this.sZH.getMediaInfo();
      if (paramSurfaceTexture != null)
      {
        if ((FinderThumbPlayerProxy.i(this.sZH) == 1) && (FinderThumbPlayerProxy.j(this.sZH) == 1))
        {
          FinderThumbPlayerProxy.b(this.sZH, 2);
          u localu = this.sZH.getLifecycle();
          if (localu != null) {
            localu.e(paramSurfaceTexture.tbA);
          }
          FinderThumbPlayerProxy.k(this.sZH).setInterceptDetach(true);
          ae.i(FinderThumbPlayerProxy.a(this.sZH), "background prepared first frame " + FinderThumbPlayerProxy.b(this.sZH));
        }
        if ((FinderThumbPlayerProxy.i(this.sZH) == 1) && (FinderThumbPlayerProxy.j(this.sZH) == 0))
        {
          ae.i(FinderThumbPlayerProxy.a(this.sZH), "onFirstFrameDraw " + FinderThumbPlayerProxy.b(this.sZH));
          paramSurfaceTexture = this.sZH.getLifecycle();
          if (paramSurfaceTexture != null)
          {
            paramSurfaceTexture.xK(FinderThumbPlayerProxy.d(this.sZH).erO());
            AppMethodBeat.o(205288);
            return;
          }
        }
        AppMethodBeat.o(205288);
        return;
      }
      AppMethodBeat.o(205288);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "errorType", "", "errorCode", "arg1", "", "arg2", "onError"})
  static final class d
    implements b.c
  {
    d(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void a(com.tencent.thumbplayer.b.a parama, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(205292);
      ae.i(FinderThumbPlayerProxy.a(this.sZH), "error " + paramInt1 + ' ' + paramInt2 + ' ' + FinderThumbPlayerProxy.b(this.sZH));
      if (FinderThumbPlayerProxy.j(this.sZH) != 0)
      {
        FinderThumbPlayerProxy.d(this.sZH).reset();
        this.sZH.cOA();
        FinderThumbPlayerProxy.cOV();
        AppMethodBeat.o(205292);
        return;
      }
      parama = this.sZH.getMediaInfo();
      if (parama != null)
      {
        i.b localb = this.sZH.getVideoViewCallback();
        if (localb != null) {
          localb.c("", parama.mediaId, "", paramInt2, paramInt1);
        }
      }
      FinderThumbPlayerProxy.cOV();
      AppMethodBeat.o(205292);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "preState", "", "curState", "onStateChange"})
  static final class e
    implements b.h
  {
    e(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void fW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205293);
      ae.i(FinderThumbPlayerProxy.a(this.sZH), "proxy player preState " + paramInt1 + " curState " + paramInt2 + ' ' + FinderThumbPlayerProxy.b(this.sZH));
      Object localObject = this.sZH.getMediaInfo();
      if (localObject != null) {
        switch (paramInt2)
        {
        }
      }
      while ((paramInt2 == 8) || (paramInt2 == 1))
      {
        ae.i(FinderThumbPlayerProxy.a(this.sZH), "proxy player stop or idle " + FinderThumbPlayerProxy.b(this.sZH));
        localObject = this.sZH.getOnPlayerStopListener();
        if (localObject == null) {
          break;
        }
        ((r)localObject).cPt();
        AppMethodBeat.o(205293);
        return;
        i.b localb = this.sZH.getVideoViewCallback();
        if (localb != null) {
          localb.ds("", ((p)localObject).mediaId);
        }
        if (this.sZH.sZm) {
          this.sZH.Gx(2);
        }
        for (;;)
        {
          localObject = this.sZH.getResourceLoaderProxy();
          if (localObject == null) {
            break;
          }
          localObject = ((FinderThumbPlayerProxy.b)localObject).ssB;
          if (localObject == null) {
            break;
          }
          ((com.tencent.mm.plugin.finder.model.z)localObject).field_audioBitrate = ((int)FinderThumbPlayerProxy.d(this.sZH).getPropertyLong(com.tencent.thumbplayer.b.l.LONG_AUDIO_BIT_RATE));
          ((com.tencent.mm.plugin.finder.model.z)localObject).field_videoBitrate = ((int)FinderThumbPlayerProxy.d(this.sZH).getPropertyLong(com.tencent.thumbplayer.b.l.LONG_VIDEO_BIT_RATE));
          ((com.tencent.mm.plugin.finder.model.z)localObject).field_frameRate = ((int)FinderThumbPlayerProxy.d(this.sZH).getPropertyLong(com.tencent.thumbplayer.b.l.LONG_VIDEO_FRAME_RATE));
          ae.i(FinderThumbPlayerProxy.a(this.sZH), "update video info when prepared audioBitrate:" + ((com.tencent.mm.plugin.finder.model.z)localObject).field_audioBitrate + " videoBitrate:" + ((com.tencent.mm.plugin.finder.model.z)localObject).field_videoBitrate + " frameRate:" + ((com.tencent.mm.plugin.finder.model.z)localObject).field_frameRate + ' ' + FinderThumbPlayerProxy.b(this.sZH));
          break;
          ae.i(FinderThumbPlayerProxy.a(this.sZH), "background prepared " + FinderThumbPlayerProxy.b(this.sZH));
          FinderThumbPlayerProxy.b(this.sZH, 1);
          FinderThumbPlayerProxy.d(this.sZH).pauseDownload();
        }
        localb = this.sZH.getVideoViewCallback();
        if (localb != null) {
          localb.dv("", ((p)localObject).mediaId);
        }
        localObject = this.sZH.getLifecycle();
        if (localObject != null)
        {
          ((u)localObject).cPn();
          continue;
          localb = this.sZH.getVideoViewCallback();
          if (localb != null) {
            localb.du("", ((p)localObject).mediaId);
          }
          localObject = this.sZH.getLifecycle();
          if (localObject != null)
          {
            ((u)localObject).cPl();
            continue;
            localb = this.sZH.getVideoViewCallback();
            if (localb != null) {
              localb.dt("", ((p)localObject).mediaId);
            }
          }
        }
      }
      AppMethodBeat.o(205293);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "what", "", "arg1", "", "arg2", "extraObject", "", "onInfo"})
  static final class f
    implements b.d
  {
    f(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void a(com.tencent.thumbplayer.b.a parama, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(205294);
      p localp = this.sZH.getMediaInfo();
      if (localp != null)
      {
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(205294);
          return;
        case 200: 
          FinderThumbPlayerProxy.n(this.sZH).removeMessages(0);
          FinderThumbPlayerProxy.n(this.sZH).sendMessageDelayed(FinderThumbPlayerProxy.n(this.sZH).obtainMessage(0, localp.mediaId), 500L);
          AppMethodBeat.o(205294);
          return;
        case 201: 
          FinderThumbPlayerProxy.n(this.sZH).removeMessages(0);
          if (FinderThumbPlayerProxy.o(this.sZH))
          {
            FinderThumbPlayerProxy.a(this.sZH, false);
            parama = this.sZH.getVideoViewCallback();
            if (parama != null)
            {
              parama.dx("", localp.mediaId);
              AppMethodBeat.o(205294);
              return;
            }
            AppMethodBeat.o(205294);
            return;
          }
          AppMethodBeat.o(205294);
          return;
        case 150: 
          parama = this.sZH.getLifecycle();
          if (parama != null) {
            parama.cPm();
          }
          parama = this.sZH.getResourceLoaderProxy();
          if (parama != null)
          {
            ae.i(FinderThumbPlayerProxy.a(parama.sZH), "onReplay " + parama.cOX());
            parama.sZE = 0L;
            AppMethodBeat.o(205294);
            return;
          }
          AppMethodBeat.o(205294);
          return;
        case 106: 
          ae.i(FinderThumbPlayerProxy.a(this.sZH), "first video frame ready " + FinderThumbPlayerProxy.b(this.sZH));
          AppMethodBeat.o(205294);
          return;
        case 105: 
          ae.i(FinderThumbPlayerProxy.a(this.sZH), "first audio frame ready " + FinderThumbPlayerProxy.b(this.sZH));
          AppMethodBeat.o(205294);
          return;
        case 1006: 
          if ((paramObject instanceof i.c))
          {
            ae.i(FinderThumbPlayerProxy.a(this.sZH), "playableDurationMS: " + ((i.c)paramObject).MvX);
            AppMethodBeat.o(205294);
            return;
          }
          AppMethodBeat.o(205294);
          return;
        }
        ae.i(FinderThumbPlayerProxy.a(this.sZH), "VIDEO_DECODER_TYPE=" + paramLong1 + ' ' + localp.mediaId);
        parama = localp.tbA;
        if (parama != null) {}
        for (parama = parama.HiY;; parama = null)
        {
          if (parama == null)
          {
            parama = localp.tbA;
            if (parama != null) {
              parama.HiY = new FinderMediaReportObject();
            }
          }
          parama = localp.tbA;
          if (parama == null) {
            break;
          }
          parama = parama.HiY;
          if (parama == null) {
            break;
          }
          parama.playDecoderType = ((int)paramLong1);
          AppMethodBeat.o(205294);
          return;
        }
      }
      AppMethodBeat.o(205294);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    g(FinderThumbPlayerProxy paramFinderThumbPlayerProxy)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    h(FinderThumbPlayerProxy paramFinderThumbPlayerProxy)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnDownload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
  public static final class i
    implements e
  {
    i(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void Fc(int paramInt)
    {
      AppMethodBeat.i(205297);
      ae.i(FinderThumbPlayerProxy.a(this.sZH), "real start download task " + FinderThumbPlayerProxy.b(this.sZH) + ' ' + paramInt);
      FinderThumbPlayerProxy.cOV();
      AppMethodBeat.o(205297);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.plugin.thumbplayer.b.b
  {
    j(FinderThumbPlayerProxy.b paramb) {}
    
    public final h akd(String paramString)
    {
      AppMethodBeat.i(205298);
      d.g.b.p.h(paramString, "id");
      FinderThumbPlayerProxy.b localb = this.sZJ;
      paramString = com.tencent.mm.plugin.finder.utils.p.sXz;
      String str2 = localb.mediaId;
      Object localObject1 = localb.sZs.downloadUrl;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      String str3 = localb.sZs.path;
      localObject1 = localb.sZs;
      if (localObject1 != null) {}
      for (localObject1 = ((p)localObject1).path;; localObject1 = null)
      {
        int i = com.tencent.mm.modelcontrol.d.I(1, (String)localObject1);
        Object localObject2 = localb.ssB.field_fileFormat;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        String str4 = localb.sZs.rYW.cEl();
        String str1 = localb.sZs.rYW.srx.decodeKey;
        localObject2 = str1;
        if (str1 == null) {
          localObject2 = "";
        }
        paramString = com.tencent.mm.plugin.finder.utils.p.a(str2, paramString, str3, i, (String)localObject1, str4, (String)localObject2, (h.a)localb, FinderThumbPlayerProxy.a(localb.sZH));
        AppMethodBeat.o(205298);
        return paramString;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnPreload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
  public static final class k
    implements com.tencent.mm.plugin.thumbplayer.b.d
  {
    k(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void Fc(int paramInt)
    {
      AppMethodBeat.i(205299);
      ae.i(FinderThumbPlayerProxy.a(this.sZH), "real start download preload task " + FinderThumbPlayerProxy.b(this.sZH) + ' ' + paramInt);
      AppMethodBeat.o(205299);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnPreload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-finder_release"})
  public static final class l
    implements com.tencent.mm.plugin.thumbplayer.b.b
  {
    l(FinderThumbPlayerProxy.b paramb) {}
    
    public final h akd(String paramString)
    {
      AppMethodBeat.i(205300);
      d.g.b.p.h(paramString, "id");
      FinderThumbPlayerProxy.b localb = this.sZK;
      paramString = com.tencent.mm.plugin.finder.utils.p.sXz;
      String str2 = localb.mediaId;
      Object localObject1 = localb.sZs.downloadUrl;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      String str3 = localb.sZs.path;
      localObject1 = localb.sZs;
      if (localObject1 != null) {}
      for (localObject1 = ((p)localObject1).path;; localObject1 = null)
      {
        int i = com.tencent.mm.modelcontrol.d.I(1, (String)localObject1);
        Object localObject2 = localb.ssB.field_fileFormat;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        String str4 = localb.sZs.rYW.cEl();
        String str1 = localb.sZs.rYW.srx.decodeKey;
        localObject2 = str1;
        if (str1 == null) {
          localObject2 = "";
        }
        paramString = com.tencent.mm.plugin.finder.utils.p.a(str2, paramString, str3, i, (String)localObject1, str4, (String)localObject2, (g.a)localb, (g.b)localb, (int)(localb.sZG * 100L / localb.ssB.field_totalSize), localb.sZG, FinderThumbPlayerProxy.a(localb.sZH));
        AppMethodBeat.o(205300);
        return paramString;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startProgressTimer$1", "Ljava/util/TimerTask;", "run", "", "plugin-finder_release"})
  public static final class m
    extends TimerTask
  {
    m(p paramp) {}
    
    public final void run()
    {
      AppMethodBeat.i(205302);
      com.tencent.mm.ac.c.h((d.g.a.a)new a(this));
      FinderThumbPlayerProxy.b localb = this.sZH.getResourceLoaderProxy();
      if (localb != null)
      {
        localb.cOY();
        AppMethodBeat.o(205302);
        return;
      }
      AppMethodBeat.o(205302);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<d.z>
    {
      a(FinderThumbPlayerProxy.m paramm)
      {
        super();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$stopCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "onStop", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-finder_release"})
  public static final class n
    implements com.tencent.mm.plugin.thumbplayer.b.g
  {
    n(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void a(int paramInt, h paramh, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(205303);
      FinderThumbPlayerProxy.cOV();
      p localp = this.sZH.getMediaInfo();
      if (localp != null)
      {
        t localt = this.sZH.getDownloadCallback();
        if (localt != null) {
          localt.a(localp.rYW, paramh, paramd);
        }
      }
      ae.i(FinderThumbPlayerProxy.a(this.sZH), "real cancel download task " + FinderThumbPlayerProxy.b(this.sZH) + ' ' + paramInt);
      AppMethodBeat.o(205303);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$stopCdnPreload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "onStop", "", "ret", "", "plugin-finder_release"})
  public static final class o
    implements com.tencent.mm.plugin.thumbplayer.b.f
  {
    o(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void Fb(int paramInt)
    {
      AppMethodBeat.i(205304);
      FinderThumbPlayerProxy.cOV();
      ae.i(FinderThumbPlayerProxy.a(this.sZH), "real cancel preload download task " + FinderThumbPlayerProxy.b(this.sZH) + ' ' + paramInt);
      AppMethodBeat.o(205304);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class p
    implements aq.a
  {
    p(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(205305);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(205305);
        return false;
        paramMessage = paramMessage.obj;
        if ((paramMessage != null) && ((paramMessage instanceof String)) && (this.sZH.sZm))
        {
          FinderThumbPlayerProxy.a(this.sZH, true);
          i.b localb = this.sZH.getVideoViewCallback();
          if (localb != null) {
            localb.dw("", (String)paramMessage);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy
 * JD-Core Version:    0.7.0.1
 */