package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
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
import com.tencent.mm.an.f;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.a.c;
import com.tencent.mm.plugin.thumbplayer.b.e;
import com.tencent.mm.plugin.thumbplayer.texture.MMThumbPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.vfs.i;
import com.tencent.thumbplayer.b.b.c;
import com.tencent.thumbplayer.b.b.d;
import com.tencent.thumbplayer.b.b.f;
import com.tencent.thumbplayer.b.b.h;
import com.tencent.thumbplayer.b.i.c;
import com.tencent.thumbplayer.b.p.a;
import d.g.b.k;
import d.g.b.v.f;
import d.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "cropView", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "getCropView", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "setCropView", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout;)V", "downloadCallback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "getDownloadCallback", "()Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "setDownloadCallback", "(Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;)V", "firstStart", "", "getFirstStart", "()Z", "setFirstStart", "(Z)V", "isPreviewing", "isShouldPlayResume", "setShouldPlayResume", "isStartCdn", "setStartCdn", "isStartProgressTimer", "setStartProgressTimer", "isViewFocused", "setViewFocused", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "mediaPreloadCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "getMediaPreloadCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "setMediaPreloadCore", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "onMuteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getOnMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setOnMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "onPlayerStopListener", "Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;", "getOnPlayerStopListener", "()Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;", "setOnPlayerStopListener", "(Lcom/tencent/mm/plugin/finder/video/OnPlayerRecycleListener;)V", "progressTimer", "Ljava/util/Timer;", "getProgressTimer", "()Ljava/util/Timer;", "setProgressTimer", "(Ljava/util/Timer;)V", "resourceLoaderProxy", "Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "getResourceLoaderProxy", "()Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "setResourceLoaderProxy", "(Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;)V", "surface", "Landroid/view/Surface;", "textureUpdateTimes", "textureView", "Lcom/tencent/mm/plugin/thumbplayer/texture/MMThumbPlayerTextureView;", "tpPlayer", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "videoViewCallback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "getVideoViewCallback", "()Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setVideoViewCallback", "(Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;)V", "basePlayInfo", "getCurrentPlaySecond", "getCurrentPlayerState", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoMediaId", "getVideoMediaInfo", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "init", "", "isPause", "isPlaying", "isPrepared", "isPreparing", "isStartPlay", "onRelease", "onUIDestroy", "pause", "pauseWithCancel", "play", "playWithSource", "source", "prepareToPlay", "realPlay", "releaseSurface", "detach", "removeVideoFooterView", "resetTextureView", "seekTo", "timestamp", "", "afterSeekPlay", "setIMMVideoViewCallback", "_callback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setLoop", "loop", "setMute", "isMute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isLocal", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setVideoMuteListener", "muteListener", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "showErrToast", "stage", "ret", "startCdnDownload", "startOrPlay", "startProgressTimer", "info", "stop", "stopCdnDownload", "stopProgressTimer", "Companion", "ResourceLoaderProxy", "plugin-finder_release"})
public final class FinderThumbPlayerProxy
  extends FrameLayout
  implements o
{
  private static final HashSet<Integer> rRM;
  public static final FinderThumbPlayerProxy.a rRN;
  private final String TAG;
  private boolean qGN;
  boolean rRA;
  private boolean rRB;
  private boolean rRC;
  private boolean rRD;
  private CropLayout rRE;
  private p rRF;
  private b rRG;
  private h.b rRH;
  private u rRI;
  private q rRJ;
  private t rRK;
  private MediaPreloadCore rRL;
  private com.tencent.thumbplayer.b.a rRv;
  private MMThumbPlayerTextureView rRw;
  private int rRx;
  private Timer rRy;
  private r rRz;
  private Surface surface;
  private boolean uGL;
  
  static
  {
    AppMethodBeat.i(203799);
    rRN = new FinderThumbPlayerProxy.a((byte)0);
    rRM = new HashSet();
    AppMethodBeat.o(203799);
  }
  
  public FinderThumbPlayerProxy(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(203796);
    this.TAG = "Finder.FinderThumbPlayerProxy";
    this.uGL = true;
    init();
    AppMethodBeat.o(203796);
  }
  
  public FinderThumbPlayerProxy(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(203797);
    this.TAG = "Finder.FinderThumbPlayerProxy";
    this.uGL = true;
    init();
    AppMethodBeat.o(203797);
  }
  
  public FinderThumbPlayerProxy(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203798);
    this.TAG = "Finder.FinderThumbPlayerProxy";
    this.uGL = true;
    init();
    AppMethodBeat.o(203798);
  }
  
  private final void a(final p paramp)
  {
    AppMethodBeat.i(203771);
    if (!this.rRC)
    {
      ac.i(this.TAG, "startProgressTimer " + cDJ());
      this.rRy = new Timer();
      Timer localTimer = this.rRy;
      if (localTimer != null) {
        localTimer.scheduleAtFixedRate((TimerTask)new l(this, paramp), 0L, 1000L);
      }
      this.rRC = true;
    }
    AppMethodBeat.o(203771);
  }
  
  private final boolean blh()
  {
    AppMethodBeat.i(203794);
    switch (getCurrentPlayerState())
    {
    default: 
      AppMethodBeat.o(203794);
      return false;
    }
    AppMethodBeat.o(203794);
    return true;
  }
  
  private final String cDJ()
  {
    AppMethodBeat.i(203761);
    Object localObject1 = new StringBuilder("loader:");
    Object localObject2 = this.rRG;
    if (localObject2 != null) {}
    for (int i = ((b)localObject2).hashCode();; i = 0)
    {
      StringBuilder localStringBuilder = ((StringBuilder)localObject1).append(i).append(" proxy:").append(hashCode()).append(" mediaId: ");
      localObject1 = this.rRF;
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
      localObject2 = this.rRv;
      if (localObject2 == null) {
        k.aVY("tpPlayer");
      }
      localObject1 = localObject2.hashCode() + " currentStat:" + getCurrentPlayerState() + " viewFocus:" + this.rRA;
      AppMethodBeat.o(203761);
      return localObject1;
    }
  }
  
  private final void cDK()
  {
    AppMethodBeat.i(203770);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("real play ").append(cDJ()).append(" surface:");
    Object localObject1 = this.surface;
    if (localObject1 != null) {}
    for (localObject1 = Boolean.valueOf(((Surface)localObject1).isValid());; localObject1 = null)
    {
      ac.i((String)localObject2, localObject1);
      localObject1 = this.rRw;
      if (localObject1 == null) {
        k.aVY("textureView");
      }
      ((MMThumbPlayerTextureView)localObject1).setInterceptDetach(false);
      localObject1 = this.rRv;
      if (localObject1 == null) {
        k.aVY("tpPlayer");
      }
      ((com.tencent.thumbplayer.b.a)localObject1).start();
      localObject1 = this.rRF;
      if (localObject1 == null) {
        break;
      }
      localObject2 = this.rRI;
      if (localObject2 != null) {
        ((u)localObject2).cEk();
      }
      a((p)localObject1);
      AppMethodBeat.o(203770);
      return;
    }
    AppMethodBeat.o(203770);
  }
  
  private final void cDL()
  {
    AppMethodBeat.i(203772);
    if (this.rRC)
    {
      ac.i(this.TAG, "stopProgressTimer " + cDJ());
      Timer localTimer = this.rRy;
      if (localTimer != null) {
        localTimer.cancel();
      }
      this.rRy = null;
      this.rRC = false;
    }
    AppMethodBeat.o(203772);
  }
  
  private final void cDO()
  {
    AppMethodBeat.i(203778);
    if (this.rRD)
    {
      ac.i(this.TAG, "already start cdn " + cDJ());
      AppMethodBeat.o(203778);
      return;
    }
    Object localObject1 = n.rPN;
    Object localObject2 = this.rRG;
    localObject1 = this.rRG;
    if (localObject1 != null) {
      localObject1 = ((b)localObject1).ruo;
    }
    while ((localObject2 != null) && (localObject1 != null))
    {
      ac.i(this.TAG, "startCdnDownload " + cDJ());
      MediaPreloadCore localMediaPreloadCore = this.rRL;
      if (localMediaPreloadCore != null) {
        localMediaPreloadCore.aY(((b)localObject2).mediaId, true);
      }
      if (!((w)localObject1).cwG())
      {
        ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().a(((b)localObject2).mediaId, (com.tencent.mm.plugin.thumbplayer.b.b)new k((b)localObject2), (e)new j(this));
        if (this.rRL != null) {
          MediaPreloadCore.adH(((b)localObject2).mediaId);
        }
        this.rRD = true;
        localObject1 = this.rRF;
        if (localObject1 != null)
        {
          localObject2 = this.rRK;
          if (localObject2 != null)
          {
            ((t)localObject2).b(((p)localObject1).rcZ);
            AppMethodBeat.o(203778);
            return;
            localObject1 = null;
          }
          else
          {
            AppMethodBeat.o(203778);
          }
        }
        else
        {
          AppMethodBeat.o(203778);
        }
      }
      else
      {
        ac.i(this.TAG, "downloadFinish " + cDJ());
      }
    }
    AppMethodBeat.o(203778);
  }
  
  private final void cDP()
  {
    AppMethodBeat.i(203779);
    if (!this.rRD)
    {
      ac.i(this.TAG, "not start cdn " + cDJ());
      AppMethodBeat.o(203779);
      return;
    }
    b localb = this.rRG;
    if (localb != null)
    {
      ac.i(this.TAG, "stopCdnDownload " + cDJ());
      MediaPreloadCore localMediaPreloadCore = this.rRL;
      if (localMediaPreloadCore != null) {
        localMediaPreloadCore.aY(localb.mediaId, false);
      }
      localb.yn(false);
      ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController().a(localb.mediaId, (com.tencent.mm.plugin.thumbplayer.b.g)new m(this));
      this.rRD = false;
      AppMethodBeat.o(203779);
      return;
    }
    AppMethodBeat.o(203779);
  }
  
  private final void cDQ()
  {
    AppMethodBeat.i(203783);
    Object localObject1 = this.rRE;
    if (localObject1 != null) {
      ((CropLayout)localObject1).reset();
    }
    localObject1 = this.rRw;
    if (localObject1 == null) {
      k.aVY("textureView");
    }
    if (((MMThumbPlayerTextureView)localObject1).getParent() != null)
    {
      localObject1 = this.rRE;
      if (localObject1 != null)
      {
        localObject2 = this.rRw;
        if (localObject2 == null) {
          k.aVY("textureView");
        }
        ((CropLayout)localObject1).removeView((View)localObject2);
      }
    }
    localObject1 = this.rRF;
    if (localObject1 != null)
    {
      localObject2 = n.rPN;
      localObject1 = n.fE((int)((p)localObject1).rcZ.rtl.width, (int)((p)localObject1).rcZ.rtl.height);
      int i = ((Bundle)localObject1).getInt("media_layout_width", 0);
      int j = ((Bundle)localObject1).getInt("media_layout_height", 0);
      localObject1 = new FrameLayout.LayoutParams(i, j);
      localObject2 = this.rRE;
      if (localObject2 != null)
      {
        localObject3 = this.rRw;
        if (localObject3 == null) {
          k.aVY("textureView");
        }
        ((CropLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = this.rRw;
      if (localObject1 == null) {
        k.aVY("textureView");
      }
      ((MMThumbPlayerTextureView)localObject1).hS(i, j);
      ac.i(this.TAG, "resetTextureView videoWidth:" + i + " videoHeight:" + j);
      AppMethodBeat.o(203783);
      return;
    }
    Object localObject3 = (FinderThumbPlayerProxy)this;
    localObject1 = new FrameLayout.LayoutParams(-1, -1);
    Object localObject2 = ((FinderThumbPlayerProxy)localObject3).rRE;
    if (localObject2 != null)
    {
      localObject3 = ((FinderThumbPlayerProxy)localObject3).rRw;
      if (localObject3 == null) {
        k.aVY("textureView");
      }
      ((CropLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(203783);
      return;
    }
    AppMethodBeat.o(203783);
  }
  
  private final boolean cDS()
  {
    AppMethodBeat.i(203792);
    switch (getCurrentPlayerState())
    {
    default: 
      AppMethodBeat.o(203792);
      return false;
    }
    AppMethodBeat.o(203792);
    return true;
  }
  
  private final boolean cDT()
  {
    AppMethodBeat.i(203795);
    if (getCurrentPlayerState() == 3)
    {
      AppMethodBeat.o(203795);
      return true;
    }
    AppMethodBeat.o(203795);
    return false;
  }
  
  private final int getCurrentPlayerState()
  {
    AppMethodBeat.i(203791);
    com.tencent.thumbplayer.b.a locala = this.rRv;
    if (locala == null) {
      k.aVY("tpPlayer");
    }
    int i = locala.fEJ().fFg();
    AppMethodBeat.o(203791);
    return i;
  }
  
  private void init()
  {
    AppMethodBeat.i(203760);
    rRM.add(Integer.valueOf(hashCode()));
    ac.i(this.TAG, "create FinderThumbPlayerProxy " + hashCode() + ' ' + rRM);
    Object localObject = getContext();
    k.g(localObject, "context");
    localObject = com.tencent.thumbplayer.b.g.kU(((Context)localObject).getApplicationContext());
    k.g(localObject, "TPPlayerFactory.createTP…ntext.applicationContext)");
    this.rRv = ((com.tencent.thumbplayer.b.a)localObject);
    localObject = getContext();
    k.g(localObject, "context");
    this.rRw = new MMThumbPlayerTextureView(((Context)localObject).getApplicationContext());
    localObject = this.rRw;
    if (localObject == null) {
      k.aVY("textureView");
    }
    ((MMThumbPlayerTextureView)localObject).setTextureListenerCallback((TextureView.SurfaceTextureListener)new c(this));
    localObject = this.rRw;
    if (localObject == null) {
      k.aVY("textureView");
    }
    ((MMThumbPlayerTextureView)localObject).setOpaqueInfo(true);
    localObject = this.rRv;
    if (localObject == null) {
      k.aVY("tpPlayer");
    }
    ((com.tencent.thumbplayer.b.a)localObject).a((b.c)new d(this));
    localObject = this.rRv;
    if (localObject == null) {
      k.aVY("tpPlayer");
    }
    ((com.tencent.thumbplayer.b.a)localObject).a((b.h)new e(this));
    localObject = this.rRv;
    if (localObject == null) {
      k.aVY("tpPlayer");
    }
    ((com.tencent.thumbplayer.b.a)localObject).a((b.d)new f(this));
    localObject = getContext();
    k.g(localObject, "context");
    this.rRE = new CropLayout((Context)localObject);
    localObject = new FrameLayout.LayoutParams(-1, -1);
    addView((View)this.rRE, (ViewGroup.LayoutParams)localObject);
    cDQ();
    AppMethodBeat.o(203760);
  }
  
  private final void sP(boolean paramBoolean)
  {
    AppMethodBeat.i(210198);
    ac.i(this.TAG, "releaseSurface " + cDJ());
    Object localObject = this.surface;
    if (localObject != null) {
      ((Surface)localObject).release();
    }
    this.surface = null;
    if (paramBoolean)
    {
      localObject = this.rRw;
      if (localObject == null) {
        k.aVY("textureView");
      }
      ((MMThumbPlayerTextureView)localObject).fiT();
    }
    AppMethodBeat.o(210198);
  }
  
  public final boolean EM(int paramInt)
  {
    AppMethodBeat.i(203769);
    ac.i(this.TAG, "play " + cDJ() + " source=" + paramInt);
    if (!this.rRA)
    {
      AppMethodBeat.o(203769);
      return false;
    }
    if (!cDS())
    {
      AppMethodBeat.o(203769);
      return false;
    }
    if (isPlaying())
    {
      AppMethodBeat.o(203769);
      return false;
    }
    Object localObject;
    if (blh())
    {
      localObject = this.surface;
      if (localObject != null)
      {
        if (!((Surface)localObject).isValid()) {
          break label152;
        }
        if (localObject != null) {
          cDK();
        }
      }
    }
    for (;;)
    {
      cDO();
      localObject = this.rRv;
      if (localObject == null) {
        k.aVY("tpPlayer");
      }
      ((com.tencent.thumbplayer.b.a)localObject).fFd();
      AppMethodBeat.o(203769);
      return true;
      label152:
      localObject = null;
      break;
      if (!cDT())
      {
        localObject = this.rRG;
        if (localObject != null)
        {
          localObject = ((b)localObject).ruo;
          if ((localObject != null) && (((w)localObject).field_moovReady))
          {
            localObject = this.rRv;
            if (localObject == null) {
              k.aVY("tpPlayer");
            }
            ((com.tencent.thumbplayer.b.a)localObject).prepareAsync();
          }
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.loader.l paraml, boolean paramBoolean, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(203782);
    k.h(paraml, "video");
    k.h(paramFinderItem, "finderItem");
    if (paramBoolean)
    {
      Object localObject = paraml.rtl.url;
      k.g(localObject, "video.mediaObj.url");
      paraml = new p("", (String)localObject, paraml.abW(), paraml.rtl, paraml, paramFinderItem);
      this.rRG = new b(paraml.mediaId, paraml);
      this.rRF = paraml;
      paraml = this.rRF;
      if (paraml != null)
      {
        paramFinderItem = paraml.rTE;
        if (paramFinderItem != null)
        {
          if (!paramFinderItem.FfP) {
            break label393;
          }
          paraml = this.rRE;
          if (paraml != null) {
            paraml.reset();
          }
          if (paramFinderItem.rvh.Fgk.EHU.size() != 9) {
            break label382;
          }
          paraml = new Matrix();
          paramFinderItem = paramFinderItem.rvh.Fgk.EHU;
          k.g(paramFinderItem, "it.cropInfo.matrix.value");
          paraml.setValues(d.a.j.p((Collection)paramFinderItem));
          localObject = new v.f();
          ((v.f)localObject).KUQ = new Matrix(paraml);
          paraml = com.tencent.mm.plugin.gallery.a.c.sTV;
          paraml = this.rRF;
          if (paraml != null)
          {
            paramFinderItem = paraml.path;
            paraml = paramFinderItem;
            if (paramFinderItem != null) {}
          }
          else
          {
            paraml = "";
          }
          paraml = com.tencent.mm.plugin.gallery.a.c.aeB(paraml);
          paramFinderItem = this.rRE;
          if (paramFinderItem == null) {
            break label377;
          }
          MMThumbPlayerTextureView localMMThumbPlayerTextureView = this.rRw;
          if (localMMThumbPlayerTextureView == null) {
            k.aVY("textureView");
          }
          paramFinderItem.a((View)localMMThumbPlayerTextureView, paraml.width, paraml.height, (Matrix)((v.f)localObject).KUQ, CropLayout.e.Jef, (d.g.a.b)new FinderThumbPlayerProxy.h((v.f)localObject));
          paraml = y.KTp;
        }
      }
    }
    for (;;)
    {
      if (paraml == null)
      {
        ((FinderThumbPlayerProxy)this).cDQ();
        paraml = y.KTp;
      }
      AppMethodBeat.o(203782);
      return;
      paraml = new p(paraml.getUrl(), paraml.getPath(), paraml.abW(), paraml.rtl, paraml, paramFinderItem);
      this.rRG = new b(paraml.mediaId, paraml);
      this.rRF = paraml;
      break;
      label377:
      paraml = null;
      continue;
      label382:
      cDQ();
      paraml = y.KTp;
      continue;
      label393:
      cDQ();
      paraml = y.KTp;
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(203780);
    if (!cDS())
    {
      AppMethodBeat.o(203780);
      return false;
    }
    if (!blh())
    {
      AppMethodBeat.o(203780);
      return false;
    }
    ac.i(this.TAG, "seekTo " + paramDouble + ' ' + paramBoolean);
    Object localObject = this.rRv;
    if (localObject == null) {
      k.aVY("tpPlayer");
    }
    paramDouble = 1000.0D * paramDouble;
    if (Double.isNaN(paramDouble))
    {
      localObject = (Throwable)new IllegalArgumentException("Cannot round NaN value.");
      AppMethodBeat.o(203780);
      throw ((Throwable)localObject);
    }
    int i;
    if (paramDouble > 2147483647.0D) {
      i = 2147483647;
    }
    for (;;)
    {
      ((com.tencent.thumbplayer.b.a)localObject).seekTo(i);
      if (paramBoolean) {
        EM(0);
      }
      AppMethodBeat.o(203780);
      return true;
      if (paramDouble < -2147483648.0D) {
        i = -2147483648;
      } else {
        i = (int)Math.round(paramDouble);
      }
    }
  }
  
  public final boolean cBe()
  {
    AppMethodBeat.i(210199);
    if (this.rRA)
    {
      AppMethodBeat.o(210199);
      return false;
    }
    if (cDS())
    {
      AppMethodBeat.o(210199);
      return false;
    }
    Object localObject = this.rRG;
    if (localObject != null) {
      ((b)localObject).cDU();
    }
    localObject = n.rPN;
    p localp = this.rRF;
    com.tencent.thumbplayer.b.a locala = this.rRv;
    if (locala == null) {
      k.aVY("tpPlayer");
    }
    b localb = this.rRG;
    localObject = this.rRG;
    if (localObject != null) {
      localObject = ((b)localObject).ruo;
    }
    while ((localp != null) && (locala != null) && (localb != null) && (localObject != null))
    {
      ac.i(this.TAG, "prepare to play isAllCompleted:" + ((w)localObject).cwG() + " isMoovReady:" + ((w)localObject).field_moovReady + ' ' + cDJ());
      this.rRx = 0;
      if ((((w)localObject).cwG()) || (bs.isNullOrNil(localp.downloadUrl)))
      {
        locala.setDataSource(i.k(localp.path, false));
        locala.prepareAsync();
        AppMethodBeat.o(210199);
        return true;
        localObject = null;
      }
      else if (((w)localObject).field_moovReady)
      {
        localObject = new p.a();
        ((p.a)localObject).aTJ(localp.mediaId);
        ((p.a)localObject).a(new com.tencent.thumbplayer.b.b.b((byte)0));
        locala.a(((p.a)localObject).fFh());
        locala.setDataSource(localp.downloadUrl);
        locala.a((b.f)localb);
        locala.prepareAsync();
        AppMethodBeat.o(210199);
        return true;
      }
    }
    AppMethodBeat.o(210199);
    return false;
  }
  
  public final boolean cDM()
  {
    AppMethodBeat.i(203773);
    if (!this.rRA)
    {
      AppMethodBeat.o(203773);
      return false;
    }
    if (this.uGL)
    {
      localObject = this.rRI;
      if (localObject != null) {
        ((u)localObject).cEg();
      }
      this.uGL = false;
    }
    if (cDS())
    {
      if (EM(3)) {
        this.rRx = 0;
      }
      AppMethodBeat.o(203773);
      return false;
    }
    Object localObject = this.rRG;
    if (localObject != null) {
      ((b)localObject).cDU();
    }
    localObject = n.rPN;
    p localp = this.rRF;
    com.tencent.thumbplayer.b.a locala = this.rRv;
    if (locala == null) {
      k.aVY("tpPlayer");
    }
    b localb = this.rRG;
    localObject = this.rRG;
    if (localObject != null)
    {
      localObject = ((b)localObject).ruo;
      if ((localp == null) || (locala == null) || (localb == null) || (localObject == null)) {
        break label342;
      }
      ac.i(this.TAG, "start or play isAllCompleted:" + ((w)localObject).cwG() + " isMoovReady:" + ((w)localObject).field_moovReady + ' ' + cDJ());
      this.rRx = 0;
      if ((!((w)localObject).cwG()) && (!bs.isNullOrNil(localp.downloadUrl))) {
        break label257;
      }
      locala.setDataSource(i.k(localp.path, false));
      locala.prepareAsync();
    }
    for (;;)
    {
      AppMethodBeat.o(203773);
      return true;
      localObject = null;
      break;
      label257:
      p.a locala1 = new p.a();
      locala1.aTJ(localp.mediaId);
      locala1.a(new com.tencent.thumbplayer.b.b.b((byte)0));
      locala.a(locala1.fFh());
      locala.setDataSource(localp.downloadUrl);
      cDO();
      locala.a((b.f)localb);
      if (((w)localObject).field_moovReady) {
        locala.prepareAsync();
      }
    }
    label342:
    AppMethodBeat.o(203773);
    return false;
  }
  
  public final int cDN()
  {
    AppMethodBeat.i(203775);
    ac.i(this.TAG, "pauseWithCancel " + cDJ());
    pause();
    AppMethodBeat.o(203775);
    return 0;
  }
  
  public final void cDR() {}
  
  public final boolean cDz()
  {
    return this.qGN;
  }
  
  public final CropLayout getCropView()
  {
    return this.rRE;
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(203762);
    com.tencent.thumbplayer.b.a locala = this.rRv;
    if (locala == null) {
      k.aVY("tpPlayer");
    }
    int i = (int)(locala.getCurrentPositionMs() / 1000L);
    AppMethodBeat.o(203762);
    return i;
  }
  
  public final t getDownloadCallback()
  {
    return this.rRK;
  }
  
  public final boolean getFirstStart()
  {
    return this.uGL;
  }
  
  public final boolean getIsNeverStart()
  {
    AppMethodBeat.i(203764);
    if (!cDS())
    {
      AppMethodBeat.o(203764);
      return true;
    }
    AppMethodBeat.o(203764);
    return false;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.rRB;
  }
  
  public final u getLifecycle()
  {
    return this.rRI;
  }
  
  public final p getMediaInfo()
  {
    return this.rRF;
  }
  
  public final MediaPreloadCore getMediaPreloadCore()
  {
    return this.rRL;
  }
  
  public final q getOnMuteListener()
  {
    return this.rRJ;
  }
  
  public final r getOnPlayerStopListener()
  {
    return this.rRz;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(203765);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(203765);
    return localViewParent;
  }
  
  public final Timer getProgressTimer()
  {
    return this.rRy;
  }
  
  public final b getResourceLoaderProxy()
  {
    return this.rRG;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(203763);
    com.tencent.thumbplayer.b.a locala = this.rRv;
    if (locala == null) {
      k.aVY("tpPlayer");
    }
    int i = (int)(locala.getDurationMs() / 1000L);
    AppMethodBeat.o(203763);
    return i;
  }
  
  public final String getVideoMediaId()
  {
    Object localObject = this.rRF;
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
    return this.rRF;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final h.b getVideoViewCallback()
  {
    return this.rRH;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.rRA;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(203793);
    if (getCurrentPlayerState() == 5)
    {
      AppMethodBeat.o(203793);
      return true;
    }
    AppMethodBeat.o(203793);
    return false;
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(203790);
    ac.i(this.TAG, "release " + cDJ());
    sP(true);
    this.rRK = null;
    this.rRG = null;
    com.tencent.mm.ac.c.c(this.TAG, (d.g.a.a)new g(this));
    rRM.remove(Integer.valueOf(hashCode()));
    AppMethodBeat.o(203790);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(203777);
    ac.i(this.TAG, "onUIDestroy " + cDJ());
    stop();
    AppMethodBeat.o(203777);
  }
  
  public final boolean pause()
  {
    Object localObject3 = null;
    AppMethodBeat.i(203774);
    ac.i(this.TAG, "pause  " + cDJ());
    if (!cDS())
    {
      AppMethodBeat.o(203774);
      return false;
    }
    if (isPlaying())
    {
      localObject1 = this.rRv;
      if (localObject1 == null) {
        k.aVY("tpPlayer");
      }
      ((com.tencent.thumbplayer.b.a)localObject1).pause();
      localObject1 = this.rRv;
      if (localObject1 == null) {
        k.aVY("tpPlayer");
      }
      ((com.tencent.thumbplayer.b.a)localObject1).pauseDownload();
      localObject1 = this.rRw;
      if (localObject1 == null) {
        k.aVY("textureView");
      }
      ((MMThumbPlayerTextureView)localObject1).setInterceptDetach(true);
    }
    while (!cDT())
    {
      cDP();
      cDL();
      if (this.rRF != null)
      {
        localObject1 = this.rRI;
        if (localObject1 != null) {
          ((u)localObject1).cEi();
        }
      }
      AppMethodBeat.o(203774);
      return true;
    }
    Object localObject1 = n.rPN;
    b localb = this.rRG;
    localObject1 = this.rRG;
    label188:
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).ruo;
      localObject2 = localObject3;
      if (localb != null)
      {
        localObject2 = localObject3;
        if (localObject1 != null)
        {
          if (((w)localObject1).field_moovReady) {
            break label337;
          }
          ac.i(this.TAG, "preparing, but moov not ready, try stop");
          localObject1 = this.rRv;
          if (localObject1 == null) {
            k.aVY("tpPlayer");
          }
          ((com.tencent.thumbplayer.b.a)localObject1).stop();
          localObject1 = this.rRv;
          if (localObject1 == null) {
            k.aVY("tpPlayer");
          }
          ((com.tencent.thumbplayer.b.a)localObject1).reset();
        }
      }
    }
    for (;;)
    {
      localObject2 = y.KTp;
      if (localObject2 != null) {
        break;
      }
      localObject1 = (FinderThumbPlayerProxy)this;
      ac.w(((FinderThumbPlayerProxy)localObject1).TAG, "occur error, stop and reset");
      localObject2 = ((FinderThumbPlayerProxy)localObject1).rRv;
      if (localObject2 == null) {
        k.aVY("tpPlayer");
      }
      ((com.tencent.thumbplayer.b.a)localObject2).stop();
      localObject1 = ((FinderThumbPlayerProxy)localObject1).rRv;
      if (localObject1 == null) {
        k.aVY("tpPlayer");
      }
      ((com.tencent.thumbplayer.b.a)localObject1).reset();
      localObject1 = y.KTp;
      break;
      localObject1 = null;
      break label188;
      label337:
      ac.i(this.TAG, "preparing, but moov ready, wait for prepared");
    }
  }
  
  public final boolean play()
  {
    AppMethodBeat.i(203768);
    boolean bool = EM(0);
    AppMethodBeat.o(203768);
    return bool;
  }
  
  public final void setCropView(CropLayout paramCropLayout)
  {
    this.rRE = paramCropLayout;
  }
  
  public final void setDownloadCallback(t paramt)
  {
    this.rRK = paramt;
  }
  
  public final void setFirstStart(boolean paramBoolean)
  {
    this.uGL = paramBoolean;
  }
  
  public final void setIMMVideoViewCallback(h.b paramb)
  {
    AppMethodBeat.i(203784);
    k.h(paramb, "_callback");
    this.rRH = paramb;
    AppMethodBeat.o(203784);
  }
  
  public final void setIOnlineVideoProxy(com.tencent.mm.modelvideo.b paramb)
  {
    AppMethodBeat.i(203786);
    k.h(paramb, "_proxy");
    AppMethodBeat.o(203786);
  }
  
  public final void setInterceptDetach(boolean paramBoolean)
  {
    AppMethodBeat.i(203767);
    MMThumbPlayerTextureView localMMThumbPlayerTextureView = this.rRw;
    if (localMMThumbPlayerTextureView == null) {
      k.aVY("textureView");
    }
    localMMThumbPlayerTextureView.setInterceptDetach(paramBoolean);
    AppMethodBeat.o(203767);
  }
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    this.rRB = paramBoolean;
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean) {}
  
  public final void setLifecycle(u paramu)
  {
    this.rRI = paramu;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(203787);
    com.tencent.thumbplayer.b.a locala = this.rRv;
    if (locala == null) {
      k.aVY("tpPlayer");
    }
    locala.yI(paramBoolean);
    AppMethodBeat.o(203787);
  }
  
  public final void setMediaInfo(p paramp)
  {
    this.rRF = paramp;
  }
  
  public final void setMediaPreloadCore(MediaPreloadCore paramMediaPreloadCore)
  {
    this.rRL = paramMediaPreloadCore;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(203781);
    com.tencent.thumbplayer.b.a locala = this.rRv;
    if (locala == null) {
      k.aVY("tpPlayer");
    }
    locala.yJ(paramBoolean);
    AppMethodBeat.o(203781);
  }
  
  public final void setOnMuteListener(q paramq)
  {
    this.rRJ = paramq;
  }
  
  public final void setOnPlayerStopListener(r paramr)
  {
    this.rRz = paramr;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    this.qGN = paramBoolean;
  }
  
  public final void setProgressTimer(Timer paramTimer)
  {
    this.rRy = paramTimer;
  }
  
  public final void setResourceLoaderProxy(b paramb)
  {
    this.rRG = paramb;
  }
  
  public final void setScaleType(h.e parame)
  {
    AppMethodBeat.i(203785);
    k.h(parame, "scaleType");
    AppMethodBeat.o(203785);
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.rRB = paramBoolean;
  }
  
  public final void setStartCdn(boolean paramBoolean)
  {
    this.rRD = paramBoolean;
  }
  
  public final void setStartProgressTimer(boolean paramBoolean)
  {
    this.rRC = paramBoolean;
  }
  
  public final void setVideoMuteListener(q paramq)
  {
    AppMethodBeat.i(203789);
    k.h(paramq, "muteListener");
    this.rRJ = paramq;
    AppMethodBeat.o(203789);
  }
  
  public final void setVideoPlayLifecycle(u paramu)
  {
    AppMethodBeat.i(203788);
    k.h(paramu, "lifecycle");
    this.rRI = paramu;
    AppMethodBeat.o(203788);
  }
  
  public final void setVideoViewCallback(h.b paramb)
  {
    this.rRH = paramb;
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(203766);
    ac.i(this.TAG, "setVideoViewFocused " + paramBoolean + ' ' + cDJ());
    this.rRA = paramBoolean;
    AppMethodBeat.o(203766);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.rRA = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(203776);
    ac.i(this.TAG, "stop " + cDJ());
    if (!cDS())
    {
      AppMethodBeat.o(203776);
      return;
    }
    Object localObject = this.rRI;
    if (localObject != null) {
      ((u)localObject).b(this.rRF);
    }
    localObject = this.rRv;
    if (localObject == null) {
      k.aVY("tpPlayer");
    }
    ((com.tencent.thumbplayer.b.a)localObject).stop();
    localObject = this.rRv;
    if (localObject == null) {
      k.aVY("tpPlayer");
    }
    ((com.tencent.thumbplayer.b.a)localObject).reset();
    cDL();
    cDP();
    this.uGL = false;
    AppMethodBeat.o(203776);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnResourceLoaderListener;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "mediaId", "", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "(Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "MAX_REQUEST_BUFFER", "", "getMAX_REQUEST_BUFFER", "()I", "MIN_CHECK_BUFFER", "getMIN_CHECK_BUFFER", "isRequestingData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setRequestingData", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "mediaCache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "getMediaCache", "()Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "setMediaCache", "(Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;)V", "getMediaId", "()Ljava/lang/String;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "requestOffset", "", "getRequestOffset", "()J", "setRequestOffset", "(J)V", "baseInfo", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getContentType", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "taskId", "fileKey", "getDataFilePath", "getDataTotalSize", "onDataAvailable", "", "offset", "length", "onFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReady", "svrflag", "onProgress", "total", "onReadData", "onStartReadData", "requestStart", "requestEnd", "onStopReadData", "updateMediaCache", "updateRequestingData", "value", "", "plugin-finder_release"})
  public final class b
    implements h.a, b.f
  {
    final String mediaId;
    final p rRF;
    private final int rRO;
    private final int rRP;
    private long rRQ;
    w ruo;
    private AtomicBoolean uGM;
    
    public b(p paramp)
    {
      AppMethodBeat.i(203744);
      this.mediaId = paramp;
      this.rRF = ((p)localObject);
      this.rRO = 1048576;
      this.rRP = 131072;
      this.uGM = new AtomicBoolean(false);
      paramp = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
      this.ruo = com.tencent.mm.plugin.finder.storage.logic.c.aei(this.mediaId);
      switch (this.ruo.field_state)
      {
      }
      for (;;)
      {
        ac.i(FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this), "init proxy " + this.ruo.field_mediaId + ' ' + this.ruo.getFilePath());
        AppMethodBeat.o(203744);
        return;
        paramp = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
        String str1 = this.mediaId;
        String str2 = this.rRF.rcZ.rtl.mediaId;
        k.g(str2, "mediaInfo.video.mediaObj.mediaId");
        localObject = this.rRF.downloadUrl;
        paramp = (p)localObject;
        if (localObject == null) {
          paramp = "";
        }
        com.tencent.mm.plugin.finder.storage.logic.c.a(str1, str2, paramp, this.rRF.path, this.rRF.rcZ.rtW, this.rRF.rcZ.rtm.detail, 0L, 0L, 1);
        cDU();
      }
    }
    
    public final int a(com.tencent.thumbplayer.b.a parama, long paramLong, String paramString)
    {
      return 0;
    }
    
    public final int a(com.tencent.thumbplayer.b.a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(203736);
      this.rRQ = paramLong2;
      int i = this.mediaId.hashCode();
      AppMethodBeat.o(203736);
      return i;
    }
    
    public final void a(String paramString, final int paramInt, final com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(203740);
      k.h(paramString, "mediaId");
      k.h(paramd, "sceneResult");
      ac.i(FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this), "[onFinish] mediaId=" + paramString + " ret=" + paramInt + " recvedBytes=" + paramd.field_recvedBytes + " fileLength=" + paramd.field_fileLength + "  finderformat:" + paramd.field_videoFormat);
      Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
      com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, paramd.field_fileLength, paramd.field_fileLength, 3);
      cDU();
      yn(false);
      localObject = new long[3];
      int i = CdnLogic.queryDownloadedSize(paramString, (long[])localObject);
      ac.i(FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this), "check download size " + i + ' ' + localObject[0] + ' ' + localObject[1] + ' ' + localObject[2]);
      com.tencent.mm.ac.c.g((d.g.a.a)new a(this, paramInt, paramd));
      AppMethodBeat.o(203740);
    }
    
    public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(203743);
      k.h(paramString1, "mediaId");
      ac.i(FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this), "[onMoovReady] mediaId=" + paramString1 + " offset=" + paramLong1 + " length=" + paramLong2 + ' ' + cDV());
      Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
      localObject = paramString2;
      if (paramString2 == null) {
        localObject = "";
      }
      com.tencent.mm.plugin.finder.storage.logic.c.gf(paramString1, (String)localObject);
      paramString2 = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
      com.tencent.mm.plugin.finder.storage.logic.c.aeh(paramString1);
      cDU();
      if ((!FinderThumbPlayerProxy.d(FinderThumbPlayerProxy.this)) && (!FinderThumbPlayerProxy.e(FinderThumbPlayerProxy.this)))
      {
        ac.i(FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this), "try to prepared");
        FinderThumbPlayerProxy.a(FinderThumbPlayerProxy.this).prepareAsync();
      }
      paramString1 = FinderThumbPlayerProxy.this.getDownloadCallback();
      if (paramString1 != null)
      {
        paramString1.a((int)paramLong1, (int)paramLong2, this.rRF.rcZ);
        AppMethodBeat.o(203743);
        return;
      }
      AppMethodBeat.o(203743);
    }
    
    public final int b(com.tencent.thumbplayer.b.a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(203737);
      int m = (int)paramLong2;
      int n = (int)paramLong2;
      int k;
      if (paramLong3 < this.rRO)
      {
        k = (int)paramLong3;
        if (paramLong3 <= this.rRP) {
          break label162;
        }
      }
      int i;
      label144:
      label162:
      for (int j = this.rRP;; j = (int)paramLong3)
      {
        i = -1;
        if (!this.ruo.cwG()) {
          break label170;
        }
        j = (int)paramLong3;
        if (j <= 0) {
          break label685;
        }
        ac.i(FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this), "onReadData taskId:" + paramLong1 + " requestOffset:" + m + " returnLength:" + j + " checkRet:" + i + ' ' + cDV());
        AppMethodBeat.o(203737);
        return j;
        k = this.rRO;
        break;
      }
      label170:
      parama = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController();
      paramString = this.mediaId;
      k.h(paramString, "mediaId");
      if (parama.zYi.containsKey(paramString))
      {
        f.aDE();
        if (com.tencent.mm.an.a.isVideoDataAvailable(paramString, n, j)) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 1) {
          break label250;
        }
        break;
        i = 0;
        continue;
        i = -1;
      }
      label250:
      if (i == 0)
      {
        if ((!this.ruo.field_moovReady) || (this.uGM.get())) {
          break label679;
        }
        if (m + k <= this.ruo.field_totalSize) {
          break label760;
        }
      }
      label679:
      label685:
      label760:
      for (j = (int)(this.ruo.field_totalSize - m);; j = k)
      {
        ac.i(FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this), "start to request data requestOffset:" + m + " requestLength:" + j + ' ' + cDV());
        parama = ((PluginThumbPlayer)com.tencent.mm.kernel.g.ad(PluginThumbPlayer.class)).getCdnTaskController();
        paramString = this.mediaId;
        com.tencent.mm.plugin.thumbplayer.b.c localc = (com.tencent.mm.plugin.thumbplayer.b.c)new b(this);
        k.h(paramString, "mediaId");
        ac.i(parama.TAG, "requestVideoData in caller thread mediaId:" + paramString + " offset:" + m + " length:" + j);
        if (parama.zYi.containsKey(paramString))
        {
          com.tencent.mm.ac.c.c("MicroMsg.Cdn.ThreadName", (d.g.a.a)new a.c(parama, paramString, m, j, localc));
          j = 1;
        }
        for (;;)
        {
          if (j > 0)
          {
            yn(true);
            j = 0;
            break;
            j = 0;
            continue;
            parama = new long[3];
            if (CdnLogic.queryDownloadedSize(this.mediaId, parama) == 0)
            {
              if (parama[0] > n)
              {
                if (parama[0] < n + j)
                {
                  j = (int)(parama[0] - n);
                  break;
                }
                break;
              }
              ac.d(FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this), "query download size " + FinderThumbPlayerProxy.c(FinderThumbPlayerProxy.this) + " Index1:" + parama[0] + " Index2:" + parama[1] + " Index3:" + parama[2] + " cdn task exist");
              j = 0;
              break;
            }
            ac.d(FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this), "onReadData " + FinderThumbPlayerProxy.c(FinderThumbPlayerProxy.this) + " cdn task not exist");
          }
        }
        j = 0;
        break;
        ac.d(FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this), "onReadData taskId:" + paramLong1 + " requestOffset:" + m + " returnLength:" + j + " checkRet:" + i + ' ' + cDV());
        break label144;
      }
    }
    
    public final long b(com.tencent.thumbplayer.b.a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(203738);
      ac.d(FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this), "getDataTotalSize " + this.ruo.field_totalSize);
      paramLong = this.ruo.field_totalSize;
      AppMethodBeat.o(203738);
      return paramLong;
    }
    
    public final String c(com.tencent.thumbplayer.b.a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(203739);
      parama = i.k(this.ruo.getFilePath(), false);
      ac.d(FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this), "getDataFilePath origin:" + this.ruo.getFilePath() + " export:" + parama + ' ' + i.eA(this.ruo.getFilePath()));
      k.g(parama, "filePath");
      AppMethodBeat.o(203739);
      return parama;
    }
    
    public final void cDU()
    {
      AppMethodBeat.i(203734);
      com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
      this.ruo = com.tencent.mm.plugin.finder.storage.logic.c.aei(this.mediaId);
      AppMethodBeat.o(203734);
    }
    
    final String cDV()
    {
      AppMethodBeat.i(203735);
      String str = FinderThumbPlayerProxy.c(FinderThumbPlayerProxy.this) + " moov:" + this.ruo.field_moovReady + " request:" + this.uGM.get() + " isFinish:" + this.ruo.cwG() + " requestOffset:" + this.rRQ + " total:" + this.ruo.field_totalSize;
      AppMethodBeat.o(203735);
      return str;
    }
    
    public final String d(com.tencent.thumbplayer.b.a parama, long paramLong, String paramString)
    {
      return "video/mp4";
    }
    
    public final void i(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(203741);
      k.h(paramString, "mediaId");
      ac.i(FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this), "[onProgress] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2 + ' ' + cDV());
      this.ruo.field_totalSize = paramLong2;
      com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
      com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, paramLong1, paramLong2, 1);
      cDU();
      if (FinderThumbPlayerProxy.this.getMediaPreloadCore() != null) {
        MediaPreloadCore.adH(paramString);
      }
      paramString = FinderThumbPlayerProxy.this.getDownloadCallback();
      if (paramString != null)
      {
        paramString.b((int)paramLong1, (int)paramLong2, this.rRF.rcZ);
        AppMethodBeat.o(203741);
        return;
      }
      AppMethodBeat.o(203741);
    }
    
    public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(203742);
      k.h(paramString, "mediaId");
      yn(false);
      ac.i(FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this), "[onDataAvailable] mediaId=" + paramString + " offset=" + paramLong1 + " length=" + paramLong2 + ' ' + cDV());
      AppMethodBeat.o(203742);
    }
    
    public final void yn(boolean paramBoolean)
    {
      AppMethodBeat.i(210197);
      ac.d(FinderThumbPlayerProxy.b(FinderThumbPlayerProxy.this), "setRequestingData " + paramBoolean + ' ' + cDV());
      this.uGM.set(paramBoolean);
      AppMethodBeat.o(210197);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(FinderThumbPlayerProxy.b paramb, int paramInt, com.tencent.mm.i.d paramd)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$ResourceLoaderProxy$onReadData$requestDataRet$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/RequestStreamingVideoDataCallback;", "onRequest", "", "ret", "", "plugin-finder_release"})
    public static final class b
      implements com.tencent.mm.plugin.thumbplayer.b.c
    {
      public final void EN(int paramInt)
      {
        AppMethodBeat.i(210196);
        FinderThumbPlayerProxy.di("requestVideoData", paramInt);
        if (paramInt != 0)
        {
          ac.i(FinderThumbPlayerProxy.b(this.rRT.rRS), "request data fail " + this.rRT.cDV());
          this.rRT.yn(false);
        }
        AppMethodBeat.o(210196);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "surface", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-finder_release"})
  public static final class c
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      Object localObject = null;
      String str = null;
      AppMethodBeat.i(203747);
      Surface localSurface;
      if (FinderThumbPlayerProxy.g(this.rRS) == null)
      {
        ac.i(FinderThumbPlayerProxy.b(this.rRS), "onSurfaceTextureAvailable " + FinderThumbPlayerProxy.c(this.rRS) + " texture:" + hashCode() + " width:" + paramInt1 + " height:" + paramInt2);
        localObject = FinderThumbPlayerProxy.a(this.rRS);
        if (paramSurfaceTexture != null)
        {
          FinderThumbPlayerProxy.a(this.rRS, new Surface(paramSurfaceTexture));
          ((com.tencent.thumbplayer.b.a)localObject).setSurface(FinderThumbPlayerProxy.g(this.rRS));
          if (this.rRS.getMediaInfo() != null) {
            this.rRS.EM(1);
          }
          localObject = FinderThumbPlayerProxy.b(this.rRS);
          localStringBuilder = new StringBuilder("set surface ");
          localSurface = FinderThumbPlayerProxy.g(this.rRS);
          paramSurfaceTexture = str;
          if (localSurface != null) {
            paramSurfaceTexture = Boolean.valueOf(localSurface.isValid());
          }
          ac.i((String)localObject, paramSurfaceTexture);
          AppMethodBeat.o(203747);
          return;
        }
        AppMethodBeat.o(203747);
        return;
      }
      str = FinderThumbPlayerProxy.b(this.rRS);
      StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable ").append(FinderThumbPlayerProxy.c(this.rRS)).append(" texture:").append(hashCode()).append(" surface:");
      paramSurfaceTexture = FinderThumbPlayerProxy.g(this.rRS);
      if (paramSurfaceTexture != null) {}
      for (paramSurfaceTexture = Boolean.valueOf(paramSurfaceTexture.isValid());; paramSurfaceTexture = null)
      {
        localStringBuilder = localStringBuilder.append(paramSurfaceTexture).append('_');
        localSurface = FinderThumbPlayerProxy.g(this.rRS);
        paramSurfaceTexture = (SurfaceTexture)localObject;
        if (localSurface != null) {
          paramSurfaceTexture = Integer.valueOf(localSurface.hashCode());
        }
        ac.i(str, paramSurfaceTexture + " width:" + paramInt1 + " height:" + paramInt2);
        AppMethodBeat.o(203747);
        return;
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(203746);
      ac.i(FinderThumbPlayerProxy.b(this.rRS), "onSurfaceTextureDestroyed " + FinderThumbPlayerProxy.c(this.rRS) + " texture:" + hashCode());
      FinderThumbPlayerProxy.h(this.rRS);
      AppMethodBeat.o(203746);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(203748);
      ac.i(FinderThumbPlayerProxy.b(this.rRS), "onSurfaceTextureSizeChanged " + FinderThumbPlayerProxy.c(this.rRS) + " texture:" + hashCode() + ' ' + paramInt1 + ' ' + paramInt2);
      AppMethodBeat.o(203748);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(203745);
      paramSurfaceTexture = this.rRS;
      FinderThumbPlayerProxy.a(paramSurfaceTexture, FinderThumbPlayerProxy.f(paramSurfaceTexture) + 1);
      if ((this.rRS.getMediaInfo() != null) && (FinderThumbPlayerProxy.f(this.rRS) == 2))
      {
        ac.i(FinderThumbPlayerProxy.b(this.rRS), "onFirstFrameDraw " + FinderThumbPlayerProxy.c(this.rRS));
        paramSurfaceTexture = this.rRS.getLifecycle();
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture.cEh();
          AppMethodBeat.o(203745);
          return;
        }
      }
      AppMethodBeat.o(203745);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "errorType", "", "errorCode", "arg1", "", "arg2", "onError"})
  static final class d
    implements b.c
  {
    d(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void a(com.tencent.thumbplayer.b.a parama, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(203749);
      p localp = this.rRS.getMediaInfo();
      if (localp != null)
      {
        h.b localb = this.rRS.getVideoViewCallback();
        if (localb != null) {
          localb.c("", localp.mediaId, "", paramInt2, paramInt1);
        }
      }
      ac.i(FinderThumbPlayerProxy.b(this.rRS), FinderThumbPlayerProxy.c(this.rRS) + ' ' + parama + " error " + paramInt1 + ' ' + paramInt2);
      FinderThumbPlayerProxy.di("error", paramInt2);
      AppMethodBeat.o(203749);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "preState", "", "curState", "onStateChange"})
  static final class e
    implements b.h
  {
    e(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void fI(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(203750);
      ac.i(FinderThumbPlayerProxy.b(this.rRS), "proxy player preState " + paramInt1 + " curState " + paramInt2 + ' ' + FinderThumbPlayerProxy.c(this.rRS));
      Object localObject = this.rRS.getMediaInfo();
      if (localObject != null) {
        switch (paramInt2)
        {
        }
      }
      while (paramInt2 == 8)
      {
        ac.i(FinderThumbPlayerProxy.b(this.rRS), "proxy player stop " + FinderThumbPlayerProxy.c(this.rRS));
        localObject = this.rRS.getOnPlayerStopListener();
        if (localObject == null) {
          break;
        }
        ((r)localObject).cEq();
        AppMethodBeat.o(203750);
        return;
        h.b localb = this.rRS.getVideoViewCallback();
        if (localb != null) {
          localb.jdMethod_do("", ((p)localObject).mediaId);
        }
        if (this.rRS.rRA)
        {
          this.rRS.EM(2);
        }
        else
        {
          ac.i(FinderThumbPlayerProxy.b(this.rRS), "background prepared " + FinderThumbPlayerProxy.c(this.rRS));
          FinderThumbPlayerProxy.di("background prepared", -1);
          continue;
          localb = this.rRS.getVideoViewCallback();
          if (localb != null) {
            localb.dr("", ((p)localObject).mediaId);
          }
          localObject = this.rRS.getLifecycle();
          if (localObject != null)
          {
            ((u)localObject).cEk();
            continue;
            localb = this.rRS.getVideoViewCallback();
            if (localb != null) {
              localb.dq("", ((p)localObject).mediaId);
            }
            localObject = this.rRS.getLifecycle();
            if (localObject != null)
            {
              ((u)localObject).cEi();
              continue;
              localb = this.rRS.getVideoViewCallback();
              if (localb != null) {
                localb.dp("", ((p)localObject).mediaId);
              }
            }
          }
        }
      }
      AppMethodBeat.o(203750);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "what", "", "arg1", "", "arg2", "extraObject", "", "onInfo"})
  static final class f
    implements b.d
  {
    f(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void a(com.tencent.thumbplayer.b.a parama, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(203751);
      parama = this.rRS.getMediaInfo();
      if (parama != null)
      {
        switch (paramInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(203751);
          return;
          paramObject = this.rRS.getVideoViewCallback();
          if (paramObject != null)
          {
            paramObject.ds("", parama.mediaId);
            AppMethodBeat.o(203751);
            return;
          }
          AppMethodBeat.o(203751);
          return;
          paramObject = this.rRS.getVideoViewCallback();
          if (paramObject != null)
          {
            paramObject.dt("", parama.mediaId);
            AppMethodBeat.o(203751);
            return;
          }
          AppMethodBeat.o(203751);
          return;
          parama = this.rRS.getLifecycle();
          if (parama != null)
          {
            parama.cEj();
            AppMethodBeat.o(203751);
            return;
          }
          AppMethodBeat.o(203751);
          return;
          if ((paramObject instanceof i.c)) {
            ac.i(FinderThumbPlayerProxy.b(this.rRS), "playableDurationMS: " + ((i.c)paramObject).Kfg);
          }
        }
      }
      AppMethodBeat.o(203751);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(FinderThumbPlayerProxy paramFinderThumbPlayerProxy)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnDownload$1$2", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartStreamingDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
  public static final class j
    implements e
  {
    j(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void DP(int paramInt)
    {
      AppMethodBeat.i(203755);
      ac.i(FinderThumbPlayerProxy.b(this.rRS), "real start download task " + FinderThumbPlayerProxy.c(this.rRS) + ' ' + paramInt);
      FinderThumbPlayerProxy.di("startStreamTask", paramInt);
      FinderThumbPlayerProxy.a(this.rRS).fFd();
      AppMethodBeat.o(203755);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CreateCdnDownloadTaskCallback;", "createCdnStreamTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "id", "", "plugin-finder_release"})
  public static final class k
    implements com.tencent.mm.plugin.thumbplayer.b.b
  {
    k(FinderThumbPlayerProxy.b paramb) {}
    
    public final h aeM(String paramString)
    {
      AppMethodBeat.i(203756);
      k.h(paramString, "id");
      FinderThumbPlayerProxy.b localb = this.rRV;
      paramString = n.rPN;
      String str2 = localb.mediaId;
      Object localObject1 = localb.rRF.downloadUrl;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      String str3 = localb.rRF.path;
      localObject1 = localb.rRF;
      if (localObject1 != null) {}
      for (localObject1 = ((p)localObject1).path;; localObject1 = null)
      {
        int i = com.tencent.mm.modelcontrol.d.I(1, (String)localObject1);
        Object localObject2 = localb.ruo.field_fileFormat;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        String str4 = localb.rRF.rcZ.cwl();
        String str1 = localb.rRF.rcZ.rtl.decodeKey;
        localObject2 = str1;
        if (str1 == null) {
          localObject2 = "";
        }
        paramString = n.a(str2, paramString, str3, i, (String)localObject1, str4, (String)localObject2, (h.a)localb, FinderThumbPlayerProxy.b(localb.rRS));
        AppMethodBeat.o(203756);
        return paramString;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$startProgressTimer$1", "Ljava/util/TimerTask;", "run", "", "plugin-finder_release"})
  public static final class l
    extends TimerTask
  {
    l(p paramp) {}
    
    public final void run()
    {
      AppMethodBeat.i(203758);
      com.tencent.mm.ac.c.g((d.g.a.a)new a(this));
      AppMethodBeat.o(203758);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(FinderThumbPlayerProxy.l paraml)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy$stopCdnDownload$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopStreamingDownloadCallback;", "onStop", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-finder_release"})
  public static final class m
    implements com.tencent.mm.plugin.thumbplayer.b.g
  {
    m(FinderThumbPlayerProxy paramFinderThumbPlayerProxy) {}
    
    public final void a(int paramInt, h paramh, com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(203759);
      FinderThumbPlayerProxy.a(this.rRS).fFd();
      FinderThumbPlayerProxy.di("stopStreamTask", paramInt);
      p localp = this.rRS.getMediaInfo();
      if (localp != null)
      {
        t localt = this.rRS.getDownloadCallback();
        if (localt != null) {
          localt.a(localp.rcZ, paramh, paramd);
        }
      }
      ac.i(FinderThumbPlayerProxy.b(this.rRS), "real cancel download task " + FinderThumbPlayerProxy.c(this.rRS) + ' ' + paramInt);
      AppMethodBeat.o(203759);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy
 * JD-Core Version:    0.7.0.1
 */