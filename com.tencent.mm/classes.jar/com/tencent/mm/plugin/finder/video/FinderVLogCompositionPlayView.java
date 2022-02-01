package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.vlog.model.r;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.plugin.vlog.player.c.a.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavkit.composition.TAVComposition;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderVLogCompositionPlayView;", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "_isPreviewing", "", "get_isPreviewing", "()Z", "set_isPreviewing", "(Z)V", "finderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "frameRetriever", "Lcom/tencent/mm/media/mix/FrameSeeker;", "isFirstTimeStarted", "isNeverStart", "setNeverStart", "isShouldPlayResume", "setShouldPlayResume", "isViewFocused", "setViewFocused", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaId", "", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "sessionId", "createPlayer", "", "getCurrentPlaySecond", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getPlayStart", "", "getVideoDuration", "getVideoMediaId", "getVideoMediaInfo", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "isPreviewing", "onRelease", "onSurfaceTextureDestroyed", "surface", "Landroid/graphics/SurfaceTexture;", "onUIDestroy", "pause", "pauseWithCancel", "play", "prepareToPlay", "removeVideoFooterView", "seekTo", "seconds", "", "afterPlay", "time", "afterSeekPlay", "setIMMVideoViewCallback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setMute", "mute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isLocal", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setVideoMuteListener", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "start", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "startOrPlay", "stop", "Companion", "plugin-finder_release"})
public final class FinderVLogCompositionPlayView
  extends VLogCompositionPlayView
  implements o
{
  public static final FinderVLogCompositionPlayView.a rSe;
  private String mediaId;
  private e rQG;
  private boolean rRA;
  private boolean rRB;
  private p rRF;
  private u rRI;
  private boolean rRY;
  private volatile boolean rRZ;
  private q rSa;
  private h.b rSb;
  private bqs rSc;
  private boolean rSd;
  private String sessionId;
  
  static
  {
    AppMethodBeat.i(203834);
    rSe = new FinderVLogCompositionPlayView.a((byte)0);
    AppMethodBeat.o(203834);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(203833);
    this.rRA = true;
    this.rRZ = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.rSd = true;
    setPlayerCallback((c.a.a)new c.a.a()
    {
      public final void cDC()
      {
        AppMethodBeat.i(203805);
        Object localObject = FinderVLogCompositionPlayView.a(this.rSf);
        if (localObject != null) {
          ((h.b)localObject).dr(FinderVLogCompositionPlayView.b(this.rSf), FinderVLogCompositionPlayView.c(this.rSf));
        }
        if ((FinderVLogCompositionPlayView.d(this.rSf)) || (!this.rSf.loop))
        {
          localObject = this.rSf.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.rSf);
            ((u)localObject).cEk();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.rSf);
          AppMethodBeat.o(203805);
          return;
          if (this.rSf.loop)
          {
            localObject = this.rSf.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.rSf);
              ((u)localObject).cEj();
            }
          }
        }
      }
      
      public final void cDD() {}
      
      public final void cDE()
      {
        AppMethodBeat.i(203806);
        h.b localb = FinderVLogCompositionPlayView.a(this.rSf);
        if (localb != null)
        {
          localb.dp(FinderVLogCompositionPlayView.b(this.rSf), FinderVLogCompositionPlayView.c(this.rSf));
          AppMethodBeat.o(203806);
          return;
        }
        AppMethodBeat.o(203806);
      }
      
      public final void cDF()
      {
        AppMethodBeat.i(203808);
        Object localObject = FinderVLogCompositionPlayView.a(this.rSf);
        if (localObject != null) {
          ((h.b)localObject).eJ(FinderVLogCompositionPlayView.b(this.rSf), FinderVLogCompositionPlayView.c(this.rSf));
        }
        localObject = this.rSf.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.rSf);
          ((u)localObject).cEh();
          AppMethodBeat.o(203808);
          return;
        }
        AppMethodBeat.o(203808);
      }
      
      public final void cDG()
      {
        AppMethodBeat.i(203809);
        h.b localb = FinderVLogCompositionPlayView.a(this.rSf);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.rSf), FinderVLogCompositionPlayView.c(this.rSf), "", -1, -1);
          AppMethodBeat.o(203809);
          return;
        }
        AppMethodBeat.o(203809);
      }
      
      public final void vm(long paramAnonymousLong)
      {
        AppMethodBeat.i(203807);
        u localu = this.rSf.getLifecycle();
        if (localu != null)
        {
          FinderVLogCompositionPlayView.f(this.rSf);
          localu.fJ((int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.rSf)) / 1000L), this.rSf.getVideoDuration());
          AppMethodBeat.o(203807);
          return;
        }
        AppMethodBeat.o(203807);
      }
    });
    AppMethodBeat.o(203833);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(203832);
    this.rRA = true;
    this.rRZ = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.rSd = true;
    setPlayerCallback((c.a.a)new c.a.a()
    {
      public final void cDC()
      {
        AppMethodBeat.i(203805);
        Object localObject = FinderVLogCompositionPlayView.a(this.rSf);
        if (localObject != null) {
          ((h.b)localObject).dr(FinderVLogCompositionPlayView.b(this.rSf), FinderVLogCompositionPlayView.c(this.rSf));
        }
        if ((FinderVLogCompositionPlayView.d(this.rSf)) || (!this.rSf.loop))
        {
          localObject = this.rSf.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.rSf);
            ((u)localObject).cEk();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.rSf);
          AppMethodBeat.o(203805);
          return;
          if (this.rSf.loop)
          {
            localObject = this.rSf.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.rSf);
              ((u)localObject).cEj();
            }
          }
        }
      }
      
      public final void cDD() {}
      
      public final void cDE()
      {
        AppMethodBeat.i(203806);
        h.b localb = FinderVLogCompositionPlayView.a(this.rSf);
        if (localb != null)
        {
          localb.dp(FinderVLogCompositionPlayView.b(this.rSf), FinderVLogCompositionPlayView.c(this.rSf));
          AppMethodBeat.o(203806);
          return;
        }
        AppMethodBeat.o(203806);
      }
      
      public final void cDF()
      {
        AppMethodBeat.i(203808);
        Object localObject = FinderVLogCompositionPlayView.a(this.rSf);
        if (localObject != null) {
          ((h.b)localObject).eJ(FinderVLogCompositionPlayView.b(this.rSf), FinderVLogCompositionPlayView.c(this.rSf));
        }
        localObject = this.rSf.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.rSf);
          ((u)localObject).cEh();
          AppMethodBeat.o(203808);
          return;
        }
        AppMethodBeat.o(203808);
      }
      
      public final void cDG()
      {
        AppMethodBeat.i(203809);
        h.b localb = FinderVLogCompositionPlayView.a(this.rSf);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.rSf), FinderVLogCompositionPlayView.c(this.rSf), "", -1, -1);
          AppMethodBeat.o(203809);
          return;
        }
        AppMethodBeat.o(203809);
      }
      
      public final void vm(long paramAnonymousLong)
      {
        AppMethodBeat.i(203807);
        u localu = this.rSf.getLifecycle();
        if (localu != null)
        {
          FinderVLogCompositionPlayView.f(this.rSf);
          localu.fJ((int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.rSf)) / 1000L), this.rSf.getVideoDuration());
          AppMethodBeat.o(203807);
          return;
        }
        AppMethodBeat.o(203807);
      }
    });
    AppMethodBeat.o(203832);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203831);
    this.rRA = true;
    this.rRZ = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.rSd = true;
    setPlayerCallback((c.a.a)new c.a.a()
    {
      public final void cDC()
      {
        AppMethodBeat.i(203805);
        Object localObject = FinderVLogCompositionPlayView.a(this.rSf);
        if (localObject != null) {
          ((h.b)localObject).dr(FinderVLogCompositionPlayView.b(this.rSf), FinderVLogCompositionPlayView.c(this.rSf));
        }
        if ((FinderVLogCompositionPlayView.d(this.rSf)) || (!this.rSf.loop))
        {
          localObject = this.rSf.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.rSf);
            ((u)localObject).cEk();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.rSf);
          AppMethodBeat.o(203805);
          return;
          if (this.rSf.loop)
          {
            localObject = this.rSf.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.rSf);
              ((u)localObject).cEj();
            }
          }
        }
      }
      
      public final void cDD() {}
      
      public final void cDE()
      {
        AppMethodBeat.i(203806);
        h.b localb = FinderVLogCompositionPlayView.a(this.rSf);
        if (localb != null)
        {
          localb.dp(FinderVLogCompositionPlayView.b(this.rSf), FinderVLogCompositionPlayView.c(this.rSf));
          AppMethodBeat.o(203806);
          return;
        }
        AppMethodBeat.o(203806);
      }
      
      public final void cDF()
      {
        AppMethodBeat.i(203808);
        Object localObject = FinderVLogCompositionPlayView.a(this.rSf);
        if (localObject != null) {
          ((h.b)localObject).eJ(FinderVLogCompositionPlayView.b(this.rSf), FinderVLogCompositionPlayView.c(this.rSf));
        }
        localObject = this.rSf.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.rSf);
          ((u)localObject).cEh();
          AppMethodBeat.o(203808);
          return;
        }
        AppMethodBeat.o(203808);
      }
      
      public final void cDG()
      {
        AppMethodBeat.i(203809);
        h.b localb = FinderVLogCompositionPlayView.a(this.rSf);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.rSf), FinderVLogCompositionPlayView.c(this.rSf), "", -1, -1);
          AppMethodBeat.o(203809);
          return;
        }
        AppMethodBeat.o(203809);
      }
      
      public final void vm(long paramAnonymousLong)
      {
        AppMethodBeat.i(203807);
        u localu = this.rSf.getLifecycle();
        if (localu != null)
        {
          FinderVLogCompositionPlayView.f(this.rSf);
          localu.fJ((int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.rSf)) / 1000L), this.rSf.getVideoDuration());
          AppMethodBeat.o(203807);
          return;
        }
        AppMethodBeat.o(203807);
      }
    });
    AppMethodBeat.o(203831);
  }
  
  private final long getPlayStart()
  {
    AppMethodBeat.i(203830);
    r localr = getComposition();
    if (localr != null)
    {
      long l = localr.efB();
      AppMethodBeat.o(203830);
      return l;
    }
    AppMethodBeat.o(203830);
    return 0L;
  }
  
  public final void a(com.tencent.mm.plugin.finder.loader.l paraml, boolean paramBoolean, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(203822);
    k.h(paraml, "video");
    k.h(paramFinderItem, "finderItem");
    ac.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " setVideoMedia video:" + paraml + ", isLocal:" + paramBoolean);
    this.rSc = paraml.rtl;
    this.mediaId = paraml.abW();
    this.rRF = new p("", "", this.mediaId, this.rSc, paraml, paramFinderItem);
    AppMethodBeat.o(203822);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(203820);
    k.h(paramr, "composition");
    ac.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " start");
    if (!this.rRA)
    {
      ac.w("MicroMsg.FinderVLogCompositionPlayView", "isViewFocused=" + this.rRA);
      AppMethodBeat.o(203820);
      return;
    }
    if (this.rRZ)
    {
      u localu = this.rRI;
      if (localu != null) {
        localu.cEg();
      }
    }
    if (!this.aKd) {
      setFirstFrame(true);
    }
    super.a(paramr);
    this.rRZ = false;
    AppMethodBeat.o(203820);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(203828);
    super.seekTo((1000.0D * paramDouble) + getPlayStart());
    AppMethodBeat.o(203828);
    return true;
  }
  
  public final boolean cBe()
  {
    return false;
  }
  
  public final boolean cDM()
  {
    Object localObject1 = null;
    AppMethodBeat.i(203819);
    ac.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " startOrPlay");
    boolean bool = this.rRZ;
    Object localObject2;
    if (getComposition() == null)
    {
      localObject2 = this.rQG;
      if (localObject2 != null) {
        ((e)localObject2).destroy();
      }
      this.rQG = null;
      localObject2 = this.rSc;
      if (localObject2 != null) {
        localObject1 = ((bqs)localObject2).FfQ;
      }
      if (localObject1 != null)
      {
        this.rQG = com.tencent.mm.plugin.vlog.model.c.b((yo)localObject1);
        localObject2 = this.rQG;
        if (localObject2 != null) {
          ((e)localObject2).start();
        }
        localObject1 = com.tencent.mm.plugin.vlog.model.c.a((yo)localObject1);
        localObject2 = this.rQG;
        if (localObject2 == null) {
          k.fOy();
        }
        ((r)localObject1).D((d.g.a.b)localObject2);
      }
    }
    for (;;)
    {
      a((r)localObject1);
      AppMethodBeat.o(203819);
      return bool;
      localObject2 = getComposition();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        k.fOy();
        localObject1 = localObject2;
      }
    }
  }
  
  public final int cDN()
  {
    AppMethodBeat.i(203811);
    ac.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  pauseWithCancel");
    super.pause();
    AppMethodBeat.o(203811);
    return 0;
  }
  
  public final void cDR() {}
  
  public final void cDW()
  {
    AppMethodBeat.i(203810);
    ac.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " createPlayer");
    super.cDW();
    Object localObject = this.rSb;
    if (localObject != null) {
      ((h.b)localObject).jdMethod_do(this.sessionId, this.mediaId);
    }
    localObject = getComposition();
    if (localObject != null) {
      localObject = new Size((int)((r)localObject).AnR.getRenderSize().width, (int)((r)localObject).AnR.getRenderSize().height);
    }
    while (localObject != null)
    {
      h.b localb = this.rSb;
      if (localb != null)
      {
        localb.d(this.sessionId, this.mediaId, ((Size)localObject).getWidth(), ((Size)localObject).getHeight());
        AppMethodBeat.o(203810);
        return;
        localObject = null;
      }
      else
      {
        AppMethodBeat.o(203810);
        return;
      }
    }
    AppMethodBeat.o(203810);
  }
  
  public final boolean cDz()
  {
    return this.rRY;
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(203813);
    com.tencent.mm.plugin.vlog.player.c localc = getPlayer();
    if (localc != null) {}
    for (long l = localc.efR();; l = 0L)
    {
      int i = (int)(l - getPlayStart()) / 1000;
      AppMethodBeat.o(203813);
      return i;
    }
  }
  
  public final boolean getIsNeverStart()
  {
    return this.rRZ;
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
  
  public final q getMuteListener()
  {
    return this.rSa;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(203815);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(203815);
    return localViewParent;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(203814);
    r localr = getComposition();
    if (localr != null) {}
    for (long l = localr.getDurationMs();; l = 0L)
    {
      int i = (int)l / 1000;
      AppMethodBeat.o(203814);
      return i;
    }
  }
  
  public final String getVideoMediaId()
  {
    p localp = this.rRF;
    if (localp != null) {
      return localp.mediaId;
    }
    return null;
  }
  
  public final p getVideoMediaInfo()
  {
    return this.rRF;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.rRA;
  }
  
  public final boolean get_isPreviewing()
  {
    return this.rRY;
  }
  
  public final void onRelease() {}
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(203829);
    e locale = this.rQG;
    if (locale != null) {
      locale.destroy();
    }
    this.rQG = null;
    boolean bool = super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    AppMethodBeat.o(203829);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(203818);
    ac.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " onUIDestroy");
    this.rRA = false;
    release();
    e locale = this.rQG;
    if (locale != null)
    {
      locale.destroy();
      AppMethodBeat.o(203818);
      return;
    }
    AppMethodBeat.o(203818);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(203812);
    ac.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  pause");
    boolean bool = super.pause();
    Object localObject = this.rSb;
    if (localObject != null) {
      ((h.b)localObject).dq(this.sessionId, this.mediaId);
    }
    localObject = this.rRI;
    if (localObject != null) {
      ((u)localObject).cEi();
    }
    AppMethodBeat.o(203812);
    return bool;
  }
  
  public final boolean play()
  {
    AppMethodBeat.i(203816);
    ac.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " play");
    boolean bool = super.play();
    Object localObject = this.rSb;
    if (localObject != null) {
      ((h.b)localObject).dr(this.sessionId, this.mediaId);
    }
    localObject = this.rRI;
    if (localObject != null) {
      ((u)localObject).cEk();
    }
    AppMethodBeat.o(203816);
    return bool;
  }
  
  public final void setIMMVideoViewCallback(h.b paramb)
  {
    AppMethodBeat.i(203823);
    k.h(paramb, "_callback");
    this.rSb = paramb;
    AppMethodBeat.o(203823);
  }
  
  public final void setIOnlineVideoProxy(com.tencent.mm.modelvideo.b paramb)
  {
    AppMethodBeat.i(203825);
    k.h(paramb, "_proxy");
    AppMethodBeat.o(203825);
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
  
  public final void setMediaInfo(p paramp)
  {
    this.rRF = paramp;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(203817);
    ac.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  setMute:" + paramBoolean);
    super.sl(paramBoolean);
    AppMethodBeat.o(203817);
  }
  
  public final void setMuteListener(q paramq)
  {
    this.rSa = paramq;
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.rRZ = paramBoolean;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    this.rRY = paramBoolean;
  }
  
  public final void setScaleType(h.e parame)
  {
    AppMethodBeat.i(203824);
    k.h(parame, "scaleType");
    AppMethodBeat.o(203824);
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.rRB = paramBoolean;
  }
  
  public final void setVideoMuteListener(q paramq)
  {
    AppMethodBeat.i(203827);
    k.h(paramq, "muteListener");
    this.rSa = paramq;
    AppMethodBeat.o(203827);
  }
  
  public final void setVideoPlayLifecycle(u paramu)
  {
    AppMethodBeat.i(203826);
    k.h(paramu, "lifecycle");
    this.rRI = paramu;
    AppMethodBeat.o(203826);
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    this.rRA = paramBoolean;
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.rRA = paramBoolean;
  }
  
  public final void set_isPreviewing(boolean paramBoolean)
  {
    this.rRY = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(203821);
    ac.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " stop");
    super.stop();
    u localu = this.rRI;
    if (localu != null) {
      localu.b(this.rRF);
    }
    this.rRZ = true;
    this.rSd = true;
    this.rRA = false;
    AppMethodBeat.o(203821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView
 * JD-Core Version:    0.7.0.1
 */