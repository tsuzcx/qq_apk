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
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.videocomposition.h;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a;
import com.tencent.mm.videocomposition.play.a.a.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderVLogCompositionPlayView;", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "_isPreviewing", "", "get_isPreviewing", "()Z", "set_isPreviewing", "(Z)V", "finderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "isFirstTimeStarted", "isNeverStart", "setNeverStart", "isShouldPlayResume", "setShouldPlayResume", "isViewFocused", "setViewFocused", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaId", "", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "sessionId", "createPlayer", "", "getCurrentPlaySecond", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getPlayStart", "", "getVideoDuration", "getVideoMediaId", "getVideoMediaInfo", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "isPreviewing", "onRelease", "onSurfaceTextureDestroyed", "surface", "Landroid/graphics/SurfaceTexture;", "onUIDestroy", "pause", "pauseWithCancel", "play", "prepareToPlay", "removeVideoFooterView", "seekTo", "seconds", "", "afterPlay", "time", "afterSeekPlay", "setFinderVideoCore", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setIMMVideoViewCallback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setMute", "mute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isLocal", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setVideoMuteListener", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "start", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "startOrPlay", "stop", "Companion", "plugin-finder_release"})
public final class FinderVLogCompositionPlayView
  extends VideoCompositionPlayView
  implements o
{
  public static final FinderVLogCompositionPlayView.a sZT;
  private String mediaId;
  private c sYr;
  private boolean sZN;
  private volatile boolean sZO;
  private q sZP;
  private i.b sZQ;
  private bvz sZR;
  private boolean sZS;
  private boolean sZm;
  private boolean sZn;
  private p sZs;
  private u sZv;
  private String sessionId;
  
  static
  {
    AppMethodBeat.i(205389);
    sZT = new FinderVLogCompositionPlayView.a((byte)0);
    AppMethodBeat.o(205389);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(205388);
    this.sZm = true;
    this.sZO = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.sZS = true;
    setPlayerCallback((a.a.a)new a.a.a()
    {
      public final void cOE()
      {
        AppMethodBeat.i(205360);
        Object localObject = FinderVLogCompositionPlayView.a(this.sZU);
        if (localObject != null) {
          ((i.b)localObject).dv(FinderVLogCompositionPlayView.b(this.sZU), FinderVLogCompositionPlayView.c(this.sZU));
        }
        if ((FinderVLogCompositionPlayView.d(this.sZU)) || (!this.sZU.loop))
        {
          localObject = this.sZU.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.sZU);
            ((u)localObject).cPn();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.sZU);
          AppMethodBeat.o(205360);
          return;
          if (this.sZU.loop)
          {
            localObject = this.sZU.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.sZU);
              ((u)localObject).cPm();
            }
          }
        }
      }
      
      public final void cOF() {}
      
      public final void cOG()
      {
        AppMethodBeat.i(205361);
        i.b localb = FinderVLogCompositionPlayView.a(this.sZU);
        if (localb != null)
        {
          localb.dt(FinderVLogCompositionPlayView.b(this.sZU), FinderVLogCompositionPlayView.c(this.sZU));
          AppMethodBeat.o(205361);
          return;
        }
        AppMethodBeat.o(205361);
      }
      
      public final void cOH()
      {
        AppMethodBeat.i(205363);
        Object localObject = FinderVLogCompositionPlayView.a(this.sZU);
        if (localObject != null) {
          ((i.b)localObject).eX(FinderVLogCompositionPlayView.b(this.sZU), FinderVLogCompositionPlayView.c(this.sZU));
        }
        localObject = this.sZU.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.sZU);
          ((u)localObject).xK(0L);
          AppMethodBeat.o(205363);
          return;
        }
        AppMethodBeat.o(205363);
      }
      
      public final void cOI()
      {
        AppMethodBeat.i(205364);
        i.b localb = FinderVLogCompositionPlayView.a(this.sZU);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.sZU), FinderVLogCompositionPlayView.c(this.sZU), "", -1, -1);
          AppMethodBeat.o(205364);
          return;
        }
        AppMethodBeat.o(205364);
      }
      
      public final void xH(long paramAnonymousLong)
      {
        AppMethodBeat.i(205362);
        u localu = this.sZU.getLifecycle();
        if (localu != null)
        {
          FinderVLogCompositionPlayView.f(this.sZU);
          localu.fX((int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.sZU)) / 1000L), this.sZU.getVideoDuration());
          AppMethodBeat.o(205362);
          return;
        }
        AppMethodBeat.o(205362);
      }
    });
    AppMethodBeat.o(205388);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205387);
    this.sZm = true;
    this.sZO = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.sZS = true;
    setPlayerCallback((a.a.a)new a.a.a()
    {
      public final void cOE()
      {
        AppMethodBeat.i(205360);
        Object localObject = FinderVLogCompositionPlayView.a(this.sZU);
        if (localObject != null) {
          ((i.b)localObject).dv(FinderVLogCompositionPlayView.b(this.sZU), FinderVLogCompositionPlayView.c(this.sZU));
        }
        if ((FinderVLogCompositionPlayView.d(this.sZU)) || (!this.sZU.loop))
        {
          localObject = this.sZU.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.sZU);
            ((u)localObject).cPn();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.sZU);
          AppMethodBeat.o(205360);
          return;
          if (this.sZU.loop)
          {
            localObject = this.sZU.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.sZU);
              ((u)localObject).cPm();
            }
          }
        }
      }
      
      public final void cOF() {}
      
      public final void cOG()
      {
        AppMethodBeat.i(205361);
        i.b localb = FinderVLogCompositionPlayView.a(this.sZU);
        if (localb != null)
        {
          localb.dt(FinderVLogCompositionPlayView.b(this.sZU), FinderVLogCompositionPlayView.c(this.sZU));
          AppMethodBeat.o(205361);
          return;
        }
        AppMethodBeat.o(205361);
      }
      
      public final void cOH()
      {
        AppMethodBeat.i(205363);
        Object localObject = FinderVLogCompositionPlayView.a(this.sZU);
        if (localObject != null) {
          ((i.b)localObject).eX(FinderVLogCompositionPlayView.b(this.sZU), FinderVLogCompositionPlayView.c(this.sZU));
        }
        localObject = this.sZU.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.sZU);
          ((u)localObject).xK(0L);
          AppMethodBeat.o(205363);
          return;
        }
        AppMethodBeat.o(205363);
      }
      
      public final void cOI()
      {
        AppMethodBeat.i(205364);
        i.b localb = FinderVLogCompositionPlayView.a(this.sZU);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.sZU), FinderVLogCompositionPlayView.c(this.sZU), "", -1, -1);
          AppMethodBeat.o(205364);
          return;
        }
        AppMethodBeat.o(205364);
      }
      
      public final void xH(long paramAnonymousLong)
      {
        AppMethodBeat.i(205362);
        u localu = this.sZU.getLifecycle();
        if (localu != null)
        {
          FinderVLogCompositionPlayView.f(this.sZU);
          localu.fX((int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.sZU)) / 1000L), this.sZU.getVideoDuration());
          AppMethodBeat.o(205362);
          return;
        }
        AppMethodBeat.o(205362);
      }
    });
    AppMethodBeat.o(205387);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205386);
    this.sZm = true;
    this.sZO = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.sZS = true;
    setPlayerCallback((a.a.a)new a.a.a()
    {
      public final void cOE()
      {
        AppMethodBeat.i(205360);
        Object localObject = FinderVLogCompositionPlayView.a(this.sZU);
        if (localObject != null) {
          ((i.b)localObject).dv(FinderVLogCompositionPlayView.b(this.sZU), FinderVLogCompositionPlayView.c(this.sZU));
        }
        if ((FinderVLogCompositionPlayView.d(this.sZU)) || (!this.sZU.loop))
        {
          localObject = this.sZU.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.sZU);
            ((u)localObject).cPn();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.sZU);
          AppMethodBeat.o(205360);
          return;
          if (this.sZU.loop)
          {
            localObject = this.sZU.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.sZU);
              ((u)localObject).cPm();
            }
          }
        }
      }
      
      public final void cOF() {}
      
      public final void cOG()
      {
        AppMethodBeat.i(205361);
        i.b localb = FinderVLogCompositionPlayView.a(this.sZU);
        if (localb != null)
        {
          localb.dt(FinderVLogCompositionPlayView.b(this.sZU), FinderVLogCompositionPlayView.c(this.sZU));
          AppMethodBeat.o(205361);
          return;
        }
        AppMethodBeat.o(205361);
      }
      
      public final void cOH()
      {
        AppMethodBeat.i(205363);
        Object localObject = FinderVLogCompositionPlayView.a(this.sZU);
        if (localObject != null) {
          ((i.b)localObject).eX(FinderVLogCompositionPlayView.b(this.sZU), FinderVLogCompositionPlayView.c(this.sZU));
        }
        localObject = this.sZU.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.sZU);
          ((u)localObject).xK(0L);
          AppMethodBeat.o(205363);
          return;
        }
        AppMethodBeat.o(205363);
      }
      
      public final void cOI()
      {
        AppMethodBeat.i(205364);
        i.b localb = FinderVLogCompositionPlayView.a(this.sZU);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.sZU), FinderVLogCompositionPlayView.c(this.sZU), "", -1, -1);
          AppMethodBeat.o(205364);
          return;
        }
        AppMethodBeat.o(205364);
      }
      
      public final void xH(long paramAnonymousLong)
      {
        AppMethodBeat.i(205362);
        u localu = this.sZU.getLifecycle();
        if (localu != null)
        {
          FinderVLogCompositionPlayView.f(this.sZU);
          localu.fX((int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.sZU)) / 1000L), this.sZU.getVideoDuration());
          AppMethodBeat.o(205362);
          return;
        }
        AppMethodBeat.o(205362);
      }
    });
    AppMethodBeat.o(205386);
  }
  
  private final long getPlayStart()
  {
    AppMethodBeat.i(205385);
    h localh = getComposition();
    if (localh != null)
    {
      long l = localh.getPlayStart();
      AppMethodBeat.o(205385);
      return l;
    }
    AppMethodBeat.o(205385);
    return 0L;
  }
  
  public final void a(m paramm, boolean paramBoolean, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(205377);
    d.g.b.p.h(paramm, "video");
    d.g.b.p.h(paramFinderItem, "finderItem");
    ae.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " setVideoMedia video:" + paramm + ", isLocal:" + paramBoolean);
    this.sZR = paramm.srx;
    this.mediaId = paramm.aeM();
    this.sZs = new p("", "", this.mediaId, this.sZR, paramm, paramFinderItem);
    AppMethodBeat.o(205377);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(205375);
    d.g.b.p.h(paramh, "composition");
    ae.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " start");
    if (!this.sZm)
    {
      ae.w("MicroMsg.FinderVLogCompositionPlayView", "isViewFocused=" + this.sZm);
      AppMethodBeat.o(205375);
      return;
    }
    if (this.sZO)
    {
      u localu = this.sZv;
      if (localu != null) {
        localu.GA(0);
      }
    }
    if (this.aLU) {
      if (!isPlaying()) {
        super.resume();
      }
    }
    for (;;)
    {
      this.sZO = false;
      AppMethodBeat.o(205375);
      return;
      super.a(paramh);
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(205383);
    super.seekTo((1000.0D * paramDouble) + getPlayStart());
    if (paramBoolean) {
      cON();
    }
    AppMethodBeat.o(205383);
    return true;
  }
  
  public final boolean cOA()
  {
    return false;
  }
  
  public final boolean cOB()
  {
    return this.sZN;
  }
  
  public final boolean cON()
  {
    AppMethodBeat.i(205374);
    ae.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " startOrPlay, " + this.aLU + ", " + isPlaying());
    boolean bool = this.sZO;
    if (!this.aLU) {
      setFirstFrame(true);
    }
    Object localObject1;
    if (getComposition() == null)
    {
      localObject1 = this.sYr;
      if (localObject1 != null) {
        ((c)localObject1).destroy();
      }
      this.sYr = null;
      localObject1 = this.sZR;
      if (localObject1 != null)
      {
        localObject1 = ((bvz)localObject1).HiW;
        if (localObject1 != null)
        {
          this.sYr = f.b((aaq)localObject1);
          Object localObject2 = this.sYr;
          if (localObject2 != null) {
            ((c)localObject2).start();
          }
          localObject2 = f.a((aaq)localObject1);
          c localc = this.sYr;
          if (localc == null) {
            d.g.b.p.gkB();
          }
          ((v)localObject2).F((d.g.a.b)localc);
          ((v)localObject2).Uh(((aaq)localObject1).BWx.fps);
          a(((v)localObject2).getComposition());
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(205374);
      return bool;
      localObject1 = null;
      break;
      if (!isPlaying()) {
        resume();
      }
    }
  }
  
  public final int cOO()
  {
    AppMethodBeat.i(205366);
    ae.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  pauseWithCancel");
    super.pause();
    AppMethodBeat.o(205366);
    return 0;
  }
  
  public final void cOS() {}
  
  public final void cOZ()
  {
    AppMethodBeat.i(205365);
    ae.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " createPlayer");
    super.cOZ();
    Object localObject = this.sZQ;
    if (localObject != null) {
      ((i.b)localObject).ds(this.sessionId, this.mediaId);
    }
    localObject = getComposition();
    if (localObject != null) {
      if (((h)localObject).LJz.isEmpty()) {
        localObject = ((h)localObject).fUb();
      }
    }
    while (localObject != null)
    {
      i.b localb = this.sZQ;
      if (localb != null)
      {
        localb.d(this.sessionId, this.mediaId, ((Size)localObject).getWidth(), ((Size)localObject).getHeight());
        AppMethodBeat.o(205365);
        return;
        localObject = new Size(((h)localObject).LJz.width(), ((h)localObject).LJz.height());
        continue;
        localObject = null;
      }
      else
      {
        AppMethodBeat.o(205365);
        return;
      }
    }
    AppMethodBeat.o(205365);
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(205368);
    a locala = getPlayer();
    if (locala != null) {}
    for (long l = locala.fUf();; l = 0L)
    {
      int i = (int)(l - getPlayStart()) / 1000;
      AppMethodBeat.o(205368);
      return i;
    }
  }
  
  public final boolean getIsNeverStart()
  {
    return this.sZO;
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
  
  public final q getMuteListener()
  {
    return this.sZP;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(205370);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(205370);
    return localViewParent;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(205369);
    h localh = getComposition();
    if (localh != null) {}
    for (long l = localh.getDurationMs();; l = 0L)
    {
      int i = (int)l / 1000;
      AppMethodBeat.o(205369);
      return i;
    }
  }
  
  public final String getVideoMediaId()
  {
    p localp = this.sZs;
    if (localp != null) {
      return localp.mediaId;
    }
    return null;
  }
  
  public final p getVideoMediaInfo()
  {
    return this.sZs;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.sZm;
  }
  
  public final boolean get_isPreviewing()
  {
    return this.sZN;
  }
  
  public final void onRelease() {}
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(205384);
    c localc = this.sYr;
    if (localc != null) {
      localc.destroy();
    }
    this.sYr = null;
    setComposition(null);
    boolean bool = super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    setPlayer(null);
    AppMethodBeat.o(205384);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(205373);
    ae.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " onUIDestroy");
    this.sZm = false;
    release();
    c localc = this.sYr;
    if (localc != null)
    {
      localc.destroy();
      AppMethodBeat.o(205373);
      return;
    }
    AppMethodBeat.o(205373);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(205367);
    ae.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  pause");
    boolean bool = super.pause();
    Object localObject = this.sZQ;
    if (localObject != null) {
      ((i.b)localObject).du(this.sessionId, this.mediaId);
    }
    localObject = this.sZv;
    if (localObject != null) {
      ((u)localObject).cPl();
    }
    AppMethodBeat.o(205367);
    return bool;
  }
  
  public final boolean play()
  {
    AppMethodBeat.i(205371);
    ae.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " play");
    if (!this.aLU)
    {
      localObject = getPlayer();
      if (localObject != null) {
        ((a)localObject).start();
      }
    }
    Object localObject = this.sZQ;
    if (localObject != null) {
      ((i.b)localObject).dv(this.sessionId, this.mediaId);
    }
    localObject = this.sZv;
    if (localObject != null) {
      ((u)localObject).cPn();
    }
    AppMethodBeat.o(205371);
    return true;
  }
  
  public final void setFinderVideoCore(i parami) {}
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(205378);
    d.g.b.p.h(paramb, "_callback");
    this.sZQ = paramb;
    AppMethodBeat.o(205378);
  }
  
  public final void setIOnlineVideoProxy(com.tencent.mm.modelvideo.b paramb)
  {
    AppMethodBeat.i(205380);
    d.g.b.p.h(paramb, "_proxy");
    AppMethodBeat.o(205380);
  }
  
  public final void setInterceptDetach(boolean paramBoolean) {}
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    this.sZn = paramBoolean;
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean) {}
  
  public final void setLifecycle(u paramu)
  {
    this.sZv = paramu;
  }
  
  public final void setMediaInfo(p paramp)
  {
    this.sZs = paramp;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(205372);
    ae.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  setMute:" + paramBoolean);
    super.zq(paramBoolean);
    AppMethodBeat.o(205372);
  }
  
  public final void setMuteListener(q paramq)
  {
    this.sZP = paramq;
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.sZO = paramBoolean;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    this.sZN = paramBoolean;
  }
  
  public final void setScaleType(i.e parame)
  {
    AppMethodBeat.i(205379);
    d.g.b.p.h(parame, "scaleType");
    AppMethodBeat.o(205379);
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.sZn = paramBoolean;
  }
  
  public final void setVideoMuteListener(q paramq)
  {
    AppMethodBeat.i(205382);
    d.g.b.p.h(paramq, "muteListener");
    this.sZP = paramq;
    AppMethodBeat.o(205382);
  }
  
  public final void setVideoPlayLifecycle(u paramu)
  {
    AppMethodBeat.i(205381);
    d.g.b.p.h(paramu, "lifecycle");
    this.sZv = paramu;
    AppMethodBeat.o(205381);
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    this.sZm = paramBoolean;
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.sZm = paramBoolean;
  }
  
  public final void set_isPreviewing(boolean paramBoolean)
  {
    this.sZN = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(205376);
    ae.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " stop");
    super.stop();
    u localu = this.sZv;
    if (localu != null) {
      localu.b(this.sZs);
    }
    this.sZO = true;
    this.sZS = true;
    this.sZm = false;
    AppMethodBeat.o(205376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView
 * JD-Core Version:    0.7.0.1
 */