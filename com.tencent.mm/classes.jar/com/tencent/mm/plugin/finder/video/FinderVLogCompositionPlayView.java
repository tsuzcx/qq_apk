package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.plugin.vlog.model.f;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.videocomposition.h;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a;
import com.tencent.mm.videocomposition.play.a.a.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVLogCompositionPlayView;", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "_isPreviewing", "", "get_isPreviewing", "()Z", "set_isPreviewing", "(Z)V", "finderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "isFirstTimeStarted", "isNeverStart", "setNeverStart", "isShouldPlayResume", "setShouldPlayResume", "isViewFocused", "setViewFocused", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaId", "", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "sessionId", "createPlayer", "", "getCurrentPlaySecond", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getPlayStart", "", "getVideoDuration", "getVideoMediaId", "getVideoMediaInfo", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "isPreviewing", "onRelease", "onSurfaceTextureDestroyed", "surface", "Landroid/graphics/SurfaceTexture;", "onUIDestroy", "pause", "pauseWithCancel", "play", "prepareToPlay", "removeVideoFooterView", "seekTo", "seconds", "", "afterPlay", "time", "afterSeekPlay", "setFinderVideoCore", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setIMMVideoViewCallback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setMute", "mute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isLocal", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setVideoMuteListener", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "start", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "startOrPlay", "stop", "Companion", "plugin-finder_release"})
public final class FinderVLogCompositionPlayView
  extends VideoCompositionPlayView
  implements o
{
  public static final a sOI;
  private String mediaId;
  private c sNg;
  private boolean sOC;
  private volatile boolean sOD;
  private q sOE;
  private i.b sOF;
  private bvf sOG;
  private boolean sOH;
  private boolean sOb;
  private boolean sOc;
  private p sOh;
  private u sOk;
  private String sessionId;
  
  static
  {
    AppMethodBeat.i(204767);
    sOI = new a((byte)0);
    AppMethodBeat.o(204767);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(204766);
    this.sOb = true;
    this.sOD = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.sOH = true;
    setPlayerCallback((a.a.a)new a.a.a()
    {
      public final void cLW()
      {
        AppMethodBeat.i(204738);
        Object localObject = FinderVLogCompositionPlayView.a(this.sOJ);
        if (localObject != null) {
          ((i.b)localObject).dt(FinderVLogCompositionPlayView.b(this.sOJ), FinderVLogCompositionPlayView.c(this.sOJ));
        }
        if ((FinderVLogCompositionPlayView.d(this.sOJ)) || (!this.sOJ.loop))
        {
          localObject = this.sOJ.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.sOJ);
            ((u)localObject).cME();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.sOJ);
          AppMethodBeat.o(204738);
          return;
          if (this.sOJ.loop)
          {
            localObject = this.sOJ.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.sOJ);
              ((u)localObject).cMD();
            }
          }
        }
      }
      
      public final void cLX() {}
      
      public final void cLY()
      {
        AppMethodBeat.i(204739);
        i.b localb = FinderVLogCompositionPlayView.a(this.sOJ);
        if (localb != null)
        {
          localb.dr(FinderVLogCompositionPlayView.b(this.sOJ), FinderVLogCompositionPlayView.c(this.sOJ));
          AppMethodBeat.o(204739);
          return;
        }
        AppMethodBeat.o(204739);
      }
      
      public final void cLZ()
      {
        AppMethodBeat.i(204741);
        Object localObject = FinderVLogCompositionPlayView.a(this.sOJ);
        if (localObject != null) {
          ((i.b)localObject).eT(FinderVLogCompositionPlayView.b(this.sOJ), FinderVLogCompositionPlayView.c(this.sOJ));
        }
        localObject = this.sOJ.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.sOJ);
          ((u)localObject).xq(0L);
          AppMethodBeat.o(204741);
          return;
        }
        AppMethodBeat.o(204741);
      }
      
      public final void cMa()
      {
        AppMethodBeat.i(204742);
        i.b localb = FinderVLogCompositionPlayView.a(this.sOJ);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.sOJ), FinderVLogCompositionPlayView.c(this.sOJ), "", -1, -1);
          AppMethodBeat.o(204742);
          return;
        }
        AppMethodBeat.o(204742);
      }
      
      public final void xp(long paramAnonymousLong)
      {
        AppMethodBeat.i(204740);
        u localu = this.sOJ.getLifecycle();
        if (localu != null)
        {
          FinderVLogCompositionPlayView.f(this.sOJ);
          localu.fX((int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.sOJ)) / 1000L), this.sOJ.getVideoDuration());
          AppMethodBeat.o(204740);
          return;
        }
        AppMethodBeat.o(204740);
      }
    });
    AppMethodBeat.o(204766);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204765);
    this.sOb = true;
    this.sOD = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.sOH = true;
    setPlayerCallback((a.a.a)new a.a.a()
    {
      public final void cLW()
      {
        AppMethodBeat.i(204738);
        Object localObject = FinderVLogCompositionPlayView.a(this.sOJ);
        if (localObject != null) {
          ((i.b)localObject).dt(FinderVLogCompositionPlayView.b(this.sOJ), FinderVLogCompositionPlayView.c(this.sOJ));
        }
        if ((FinderVLogCompositionPlayView.d(this.sOJ)) || (!this.sOJ.loop))
        {
          localObject = this.sOJ.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.sOJ);
            ((u)localObject).cME();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.sOJ);
          AppMethodBeat.o(204738);
          return;
          if (this.sOJ.loop)
          {
            localObject = this.sOJ.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.sOJ);
              ((u)localObject).cMD();
            }
          }
        }
      }
      
      public final void cLX() {}
      
      public final void cLY()
      {
        AppMethodBeat.i(204739);
        i.b localb = FinderVLogCompositionPlayView.a(this.sOJ);
        if (localb != null)
        {
          localb.dr(FinderVLogCompositionPlayView.b(this.sOJ), FinderVLogCompositionPlayView.c(this.sOJ));
          AppMethodBeat.o(204739);
          return;
        }
        AppMethodBeat.o(204739);
      }
      
      public final void cLZ()
      {
        AppMethodBeat.i(204741);
        Object localObject = FinderVLogCompositionPlayView.a(this.sOJ);
        if (localObject != null) {
          ((i.b)localObject).eT(FinderVLogCompositionPlayView.b(this.sOJ), FinderVLogCompositionPlayView.c(this.sOJ));
        }
        localObject = this.sOJ.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.sOJ);
          ((u)localObject).xq(0L);
          AppMethodBeat.o(204741);
          return;
        }
        AppMethodBeat.o(204741);
      }
      
      public final void cMa()
      {
        AppMethodBeat.i(204742);
        i.b localb = FinderVLogCompositionPlayView.a(this.sOJ);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.sOJ), FinderVLogCompositionPlayView.c(this.sOJ), "", -1, -1);
          AppMethodBeat.o(204742);
          return;
        }
        AppMethodBeat.o(204742);
      }
      
      public final void xp(long paramAnonymousLong)
      {
        AppMethodBeat.i(204740);
        u localu = this.sOJ.getLifecycle();
        if (localu != null)
        {
          FinderVLogCompositionPlayView.f(this.sOJ);
          localu.fX((int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.sOJ)) / 1000L), this.sOJ.getVideoDuration());
          AppMethodBeat.o(204740);
          return;
        }
        AppMethodBeat.o(204740);
      }
    });
    AppMethodBeat.o(204765);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204764);
    this.sOb = true;
    this.sOD = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.sOH = true;
    setPlayerCallback((a.a.a)new a.a.a()
    {
      public final void cLW()
      {
        AppMethodBeat.i(204738);
        Object localObject = FinderVLogCompositionPlayView.a(this.sOJ);
        if (localObject != null) {
          ((i.b)localObject).dt(FinderVLogCompositionPlayView.b(this.sOJ), FinderVLogCompositionPlayView.c(this.sOJ));
        }
        if ((FinderVLogCompositionPlayView.d(this.sOJ)) || (!this.sOJ.loop))
        {
          localObject = this.sOJ.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.sOJ);
            ((u)localObject).cME();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.sOJ);
          AppMethodBeat.o(204738);
          return;
          if (this.sOJ.loop)
          {
            localObject = this.sOJ.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.sOJ);
              ((u)localObject).cMD();
            }
          }
        }
      }
      
      public final void cLX() {}
      
      public final void cLY()
      {
        AppMethodBeat.i(204739);
        i.b localb = FinderVLogCompositionPlayView.a(this.sOJ);
        if (localb != null)
        {
          localb.dr(FinderVLogCompositionPlayView.b(this.sOJ), FinderVLogCompositionPlayView.c(this.sOJ));
          AppMethodBeat.o(204739);
          return;
        }
        AppMethodBeat.o(204739);
      }
      
      public final void cLZ()
      {
        AppMethodBeat.i(204741);
        Object localObject = FinderVLogCompositionPlayView.a(this.sOJ);
        if (localObject != null) {
          ((i.b)localObject).eT(FinderVLogCompositionPlayView.b(this.sOJ), FinderVLogCompositionPlayView.c(this.sOJ));
        }
        localObject = this.sOJ.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.sOJ);
          ((u)localObject).xq(0L);
          AppMethodBeat.o(204741);
          return;
        }
        AppMethodBeat.o(204741);
      }
      
      public final void cMa()
      {
        AppMethodBeat.i(204742);
        i.b localb = FinderVLogCompositionPlayView.a(this.sOJ);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.sOJ), FinderVLogCompositionPlayView.c(this.sOJ), "", -1, -1);
          AppMethodBeat.o(204742);
          return;
        }
        AppMethodBeat.o(204742);
      }
      
      public final void xp(long paramAnonymousLong)
      {
        AppMethodBeat.i(204740);
        u localu = this.sOJ.getLifecycle();
        if (localu != null)
        {
          FinderVLogCompositionPlayView.f(this.sOJ);
          localu.fX((int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.sOJ)) / 1000L), this.sOJ.getVideoDuration());
          AppMethodBeat.o(204740);
          return;
        }
        AppMethodBeat.o(204740);
      }
    });
    AppMethodBeat.o(204764);
  }
  
  private final long getPlayStart()
  {
    AppMethodBeat.i(204763);
    h localh = getComposition();
    if (localh != null)
    {
      long l = localh.getPlayStart();
      AppMethodBeat.o(204763);
      return l;
    }
    AppMethodBeat.o(204763);
    return 0L;
  }
  
  public final void a(m paramm, boolean paramBoolean, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(204755);
    d.g.b.p.h(paramm, "video");
    d.g.b.p.h(paramFinderItem, "finderItem");
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " setVideoMedia video:" + paramm + ", isLocal:" + paramBoolean);
    this.sOG = paramm.siC;
    this.mediaId = paramm.aeA();
    this.sOh = new p("", "", this.mediaId, this.sOG, paramm, paramFinderItem);
    AppMethodBeat.o(204755);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(204753);
    d.g.b.p.h(paramh, "composition");
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " start");
    if (!this.sOb)
    {
      ad.w("MicroMsg.FinderVLogCompositionPlayView", "isViewFocused=" + this.sOb);
      AppMethodBeat.o(204753);
      return;
    }
    if (this.sOD)
    {
      u localu = this.sOk;
      if (localu != null) {
        localu.Ga(0);
      }
    }
    if (this.aLU) {
      if (!isPlaying()) {
        super.resume();
      }
    }
    for (;;)
    {
      this.sOD = false;
      AppMethodBeat.o(204753);
      return;
      super.a(paramh);
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(204761);
    super.seekTo((1000.0D * paramDouble) + getPlayStart());
    if (paramBoolean) {
      cMf();
    }
    AppMethodBeat.o(204761);
    return true;
  }
  
  public final boolean cLS()
  {
    return false;
  }
  
  public final boolean cLT()
  {
    return this.sOC;
  }
  
  public final boolean cMf()
  {
    AppMethodBeat.i(204752);
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " startOrPlay, " + this.aLU + ", " + isPlaying());
    boolean bool = this.sOD;
    if (!this.aLU) {
      setFirstFrame(true);
    }
    Object localObject1;
    if (getComposition() == null)
    {
      localObject1 = this.sNg;
      if (localObject1 != null) {
        ((c)localObject1).destroy();
      }
      this.sNg = null;
      localObject1 = this.sOG;
      if (localObject1 != null)
      {
        localObject1 = ((bvf)localObject1).GPu;
        if (localObject1 != null)
        {
          this.sNg = f.b((aan)localObject1);
          Object localObject2 = this.sNg;
          if (localObject2 != null) {
            ((c)localObject2).start();
          }
          localObject2 = f.a((aan)localObject1);
          c localc = this.sNg;
          if (localc == null) {
            d.g.b.p.gfZ();
          }
          ((v)localObject2).E((d.g.a.b)localc);
          ((v)localObject2).TA(((aan)localObject1).BEZ.fps);
          a(((v)localObject2).getComposition());
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(204752);
      return bool;
      localObject1 = null;
      break;
      if (!isPlaying()) {
        resume();
      }
    }
  }
  
  public final int cMg()
  {
    AppMethodBeat.i(204744);
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  pauseWithCancel");
    super.pause();
    AppMethodBeat.o(204744);
    return 0;
  }
  
  public final void cMk() {}
  
  public final void cMq()
  {
    AppMethodBeat.i(204743);
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " createPlayer");
    super.cMq();
    Object localObject = this.sOF;
    if (localObject != null) {
      ((i.b)localObject).dq(this.sessionId, this.mediaId);
    }
    localObject = getComposition();
    if (localObject != null) {
      if (((h)localObject).LmP.isEmpty()) {
        localObject = ((h)localObject).fPF();
      }
    }
    while (localObject != null)
    {
      i.b localb = this.sOF;
      if (localb != null)
      {
        localb.d(this.sessionId, this.mediaId, ((Size)localObject).getWidth(), ((Size)localObject).getHeight());
        AppMethodBeat.o(204743);
        return;
        localObject = new Size(((h)localObject).LmP.width(), ((h)localObject).LmP.height());
        continue;
        localObject = null;
      }
      else
      {
        AppMethodBeat.o(204743);
        return;
      }
    }
    AppMethodBeat.o(204743);
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(204746);
    a locala = getPlayer();
    if (locala != null) {}
    for (long l = locala.fPJ();; l = 0L)
    {
      int i = (int)(l - getPlayStart()) / 1000;
      AppMethodBeat.o(204746);
      return i;
    }
  }
  
  public final boolean getIsNeverStart()
  {
    return this.sOD;
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
  
  public final q getMuteListener()
  {
    return this.sOE;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(204748);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(204748);
    return localViewParent;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(204747);
    h localh = getComposition();
    if (localh != null) {}
    for (long l = localh.getDurationMs();; l = 0L)
    {
      int i = (int)l / 1000;
      AppMethodBeat.o(204747);
      return i;
    }
  }
  
  public final String getVideoMediaId()
  {
    p localp = this.sOh;
    if (localp != null) {
      return localp.mediaId;
    }
    return null;
  }
  
  public final p getVideoMediaInfo()
  {
    return this.sOh;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.sOb;
  }
  
  public final boolean get_isPreviewing()
  {
    return this.sOC;
  }
  
  public final void onRelease() {}
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(204762);
    c localc = this.sNg;
    if (localc != null) {
      localc.destroy();
    }
    this.sNg = null;
    setComposition(null);
    boolean bool = super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    setPlayer(null);
    AppMethodBeat.o(204762);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(204751);
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " onUIDestroy");
    this.sOb = false;
    release();
    c localc = this.sNg;
    if (localc != null)
    {
      localc.destroy();
      AppMethodBeat.o(204751);
      return;
    }
    AppMethodBeat.o(204751);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(204745);
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  pause");
    boolean bool = super.pause();
    Object localObject = this.sOF;
    if (localObject != null) {
      ((i.b)localObject).ds(this.sessionId, this.mediaId);
    }
    localObject = this.sOk;
    if (localObject != null) {
      ((u)localObject).cMC();
    }
    AppMethodBeat.o(204745);
    return bool;
  }
  
  public final boolean play()
  {
    AppMethodBeat.i(204749);
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " play");
    if (!this.aLU)
    {
      localObject = getPlayer();
      if (localObject != null) {
        ((a)localObject).start();
      }
    }
    Object localObject = this.sOF;
    if (localObject != null) {
      ((i.b)localObject).dt(this.sessionId, this.mediaId);
    }
    localObject = this.sOk;
    if (localObject != null) {
      ((u)localObject).cME();
    }
    AppMethodBeat.o(204749);
    return true;
  }
  
  public final void setFinderVideoCore(i parami) {}
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(204756);
    d.g.b.p.h(paramb, "_callback");
    this.sOF = paramb;
    AppMethodBeat.o(204756);
  }
  
  public final void setIOnlineVideoProxy(com.tencent.mm.modelvideo.b paramb)
  {
    AppMethodBeat.i(204758);
    d.g.b.p.h(paramb, "_proxy");
    AppMethodBeat.o(204758);
  }
  
  public final void setInterceptDetach(boolean paramBoolean) {}
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    this.sOc = paramBoolean;
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean) {}
  
  public final void setLifecycle(u paramu)
  {
    this.sOk = paramu;
  }
  
  public final void setMediaInfo(p paramp)
  {
    this.sOh = paramp;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(204750);
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  setMute:" + paramBoolean);
    super.zc(paramBoolean);
    AppMethodBeat.o(204750);
  }
  
  public final void setMuteListener(q paramq)
  {
    this.sOE = paramq;
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.sOD = paramBoolean;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    this.sOC = paramBoolean;
  }
  
  public final void setScaleType(i.e parame)
  {
    AppMethodBeat.i(204757);
    d.g.b.p.h(parame, "scaleType");
    AppMethodBeat.o(204757);
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.sOc = paramBoolean;
  }
  
  public final void setVideoMuteListener(q paramq)
  {
    AppMethodBeat.i(204760);
    d.g.b.p.h(paramq, "muteListener");
    this.sOE = paramq;
    AppMethodBeat.o(204760);
  }
  
  public final void setVideoPlayLifecycle(u paramu)
  {
    AppMethodBeat.i(204759);
    d.g.b.p.h(paramu, "lifecycle");
    this.sOk = paramu;
    AppMethodBeat.o(204759);
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    this.sOb = paramBoolean;
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.sOb = paramBoolean;
  }
  
  public final void set_isPreviewing(boolean paramBoolean)
  {
    this.sOC = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(204754);
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " stop");
    super.stop();
    u localu = this.sOk;
    if (localu != null) {
      localu.b(this.sOh);
    }
    this.sOD = true;
    this.sOH = true;
    this.sOb = false;
    AppMethodBeat.o(204754);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVLogCompositionPlayView$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView
 * JD-Core Version:    0.7.0.1
 */