package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.f;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.vlog.model.m;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.plugin.vlog.player.g;
import com.tencent.mm.plugin.vlog.player.g.a.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.Player;
import com.tencent.tavkit.composition.TAVComposition;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVLogCompositionPlayView;", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "_isPreviewing", "", "get_isPreviewing", "()Z", "set_isPreviewing", "(Z)V", "finderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "frameRetriever", "Lcom/tencent/mm/media/mix/FrameSeeker;", "isFirstTimeStarted", "isNeverStart", "setNeverStart", "isShouldPlayResume", "setShouldPlayResume", "isViewFocused", "setViewFocused", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaId", "", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "sessionId", "createPlayer", "", "getCurrentPlaySecond", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoMediaId", "getVideoMediaInfo", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "isPreviewing", "onRelease", "onUIDestroy", "pause", "pauseWithCancel", "play", "removeVideoFooterView", "seekTo", "seconds", "", "afterPlay", "time", "afterSeekPlay", "setIMMVideoViewCallback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setMute", "mute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isLocal", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setVideoMuteListener", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "start", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "startOrPlay", "stop", "Companion", "plugin-finder_release"})
public final class FinderVLogCompositionPlayView
  extends VLogCompositionPlayView
  implements o
{
  public static final a Lco;
  private f LbE;
  private p Lch;
  private boolean Lci;
  private q Lcj;
  private t Lck;
  private h.b Lcl;
  private bmd Lcm;
  private boolean Lcn;
  private String mediaId;
  private boolean qUO;
  private boolean qUP;
  private volatile boolean qUQ;
  private String sessionId;
  
  static
  {
    AppMethodBeat.i(199774);
    Lco = new a((byte)0);
    AppMethodBeat.o(199774);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(199773);
    this.qUO = true;
    this.qUQ = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.Lcn = true;
    setPlayerCallback((g.a.a)new g.a.a()
    {
      public final void Ca(long paramAnonymousLong)
      {
        AppMethodBeat.i(199749);
        t localt = this.Lcp.getLifecycle();
        if (localt != null)
        {
          FinderVLogCompositionPlayView.f(this.Lcp);
          localt.fD((int)(paramAnonymousLong / 1000L), this.Lcp.getVideoDuration());
          AppMethodBeat.o(199749);
          return;
        }
        AppMethodBeat.o(199749);
      }
      
      public final void fWi()
      {
        AppMethodBeat.i(199747);
        Object localObject = FinderVLogCompositionPlayView.a(this.Lcp);
        if (localObject != null) {
          ((h.b)localObject).de(FinderVLogCompositionPlayView.b(this.Lcp), FinderVLogCompositionPlayView.c(this.Lcp));
        }
        if ((FinderVLogCompositionPlayView.d(this.Lcp)) || (!this.Lcp.loop))
        {
          localObject = this.Lcp.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.Lcp);
            ((t)localObject).csx();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.Lcp);
          AppMethodBeat.o(199747);
          return;
          if (this.Lcp.loop)
          {
            localObject = this.Lcp.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.Lcp);
              ((t)localObject).csw();
            }
          }
        }
      }
      
      public final void fWj() {}
      
      public final void fWk()
      {
        AppMethodBeat.i(199748);
        h.b localb = FinderVLogCompositionPlayView.a(this.Lcp);
        if (localb != null)
        {
          localb.dc(FinderVLogCompositionPlayView.b(this.Lcp), FinderVLogCompositionPlayView.c(this.Lcp));
          AppMethodBeat.o(199748);
          return;
        }
        AppMethodBeat.o(199748);
      }
      
      public final void fWl()
      {
        AppMethodBeat.i(199750);
        Object localObject = FinderVLogCompositionPlayView.a(this.Lcp);
        if (localObject != null) {
          ((h.b)localObject).jw(FinderVLogCompositionPlayView.b(this.Lcp), FinderVLogCompositionPlayView.c(this.Lcp));
        }
        localObject = this.Lcp.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.Lcp);
          ((t)localObject).csu();
          AppMethodBeat.o(199750);
          return;
        }
        AppMethodBeat.o(199750);
      }
      
      public final void fWm()
      {
        AppMethodBeat.i(199751);
        h.b localb = FinderVLogCompositionPlayView.a(this.Lcp);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.Lcp), FinderVLogCompositionPlayView.c(this.Lcp), "", -1, -1);
          AppMethodBeat.o(199751);
          return;
        }
        AppMethodBeat.o(199751);
      }
    });
    AppMethodBeat.o(199773);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(199772);
    this.qUO = true;
    this.qUQ = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.Lcn = true;
    setPlayerCallback((g.a.a)new g.a.a()
    {
      public final void Ca(long paramAnonymousLong)
      {
        AppMethodBeat.i(199749);
        t localt = this.Lcp.getLifecycle();
        if (localt != null)
        {
          FinderVLogCompositionPlayView.f(this.Lcp);
          localt.fD((int)(paramAnonymousLong / 1000L), this.Lcp.getVideoDuration());
          AppMethodBeat.o(199749);
          return;
        }
        AppMethodBeat.o(199749);
      }
      
      public final void fWi()
      {
        AppMethodBeat.i(199747);
        Object localObject = FinderVLogCompositionPlayView.a(this.Lcp);
        if (localObject != null) {
          ((h.b)localObject).de(FinderVLogCompositionPlayView.b(this.Lcp), FinderVLogCompositionPlayView.c(this.Lcp));
        }
        if ((FinderVLogCompositionPlayView.d(this.Lcp)) || (!this.Lcp.loop))
        {
          localObject = this.Lcp.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.Lcp);
            ((t)localObject).csx();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.Lcp);
          AppMethodBeat.o(199747);
          return;
          if (this.Lcp.loop)
          {
            localObject = this.Lcp.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.Lcp);
              ((t)localObject).csw();
            }
          }
        }
      }
      
      public final void fWj() {}
      
      public final void fWk()
      {
        AppMethodBeat.i(199748);
        h.b localb = FinderVLogCompositionPlayView.a(this.Lcp);
        if (localb != null)
        {
          localb.dc(FinderVLogCompositionPlayView.b(this.Lcp), FinderVLogCompositionPlayView.c(this.Lcp));
          AppMethodBeat.o(199748);
          return;
        }
        AppMethodBeat.o(199748);
      }
      
      public final void fWl()
      {
        AppMethodBeat.i(199750);
        Object localObject = FinderVLogCompositionPlayView.a(this.Lcp);
        if (localObject != null) {
          ((h.b)localObject).jw(FinderVLogCompositionPlayView.b(this.Lcp), FinderVLogCompositionPlayView.c(this.Lcp));
        }
        localObject = this.Lcp.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.Lcp);
          ((t)localObject).csu();
          AppMethodBeat.o(199750);
          return;
        }
        AppMethodBeat.o(199750);
      }
      
      public final void fWm()
      {
        AppMethodBeat.i(199751);
        h.b localb = FinderVLogCompositionPlayView.a(this.Lcp);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.Lcp), FinderVLogCompositionPlayView.c(this.Lcp), "", -1, -1);
          AppMethodBeat.o(199751);
          return;
        }
        AppMethodBeat.o(199751);
      }
    });
    AppMethodBeat.o(199772);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199771);
    this.qUO = true;
    this.qUQ = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.Lcn = true;
    setPlayerCallback((g.a.a)new g.a.a()
    {
      public final void Ca(long paramAnonymousLong)
      {
        AppMethodBeat.i(199749);
        t localt = this.Lcp.getLifecycle();
        if (localt != null)
        {
          FinderVLogCompositionPlayView.f(this.Lcp);
          localt.fD((int)(paramAnonymousLong / 1000L), this.Lcp.getVideoDuration());
          AppMethodBeat.o(199749);
          return;
        }
        AppMethodBeat.o(199749);
      }
      
      public final void fWi()
      {
        AppMethodBeat.i(199747);
        Object localObject = FinderVLogCompositionPlayView.a(this.Lcp);
        if (localObject != null) {
          ((h.b)localObject).de(FinderVLogCompositionPlayView.b(this.Lcp), FinderVLogCompositionPlayView.c(this.Lcp));
        }
        if ((FinderVLogCompositionPlayView.d(this.Lcp)) || (!this.Lcp.loop))
        {
          localObject = this.Lcp.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.Lcp);
            ((t)localObject).csx();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.Lcp);
          AppMethodBeat.o(199747);
          return;
          if (this.Lcp.loop)
          {
            localObject = this.Lcp.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.Lcp);
              ((t)localObject).csw();
            }
          }
        }
      }
      
      public final void fWj() {}
      
      public final void fWk()
      {
        AppMethodBeat.i(199748);
        h.b localb = FinderVLogCompositionPlayView.a(this.Lcp);
        if (localb != null)
        {
          localb.dc(FinderVLogCompositionPlayView.b(this.Lcp), FinderVLogCompositionPlayView.c(this.Lcp));
          AppMethodBeat.o(199748);
          return;
        }
        AppMethodBeat.o(199748);
      }
      
      public final void fWl()
      {
        AppMethodBeat.i(199750);
        Object localObject = FinderVLogCompositionPlayView.a(this.Lcp);
        if (localObject != null) {
          ((h.b)localObject).jw(FinderVLogCompositionPlayView.b(this.Lcp), FinderVLogCompositionPlayView.c(this.Lcp));
        }
        localObject = this.Lcp.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.Lcp);
          ((t)localObject).csu();
          AppMethodBeat.o(199750);
          return;
        }
        AppMethodBeat.o(199750);
      }
      
      public final void fWm()
      {
        AppMethodBeat.i(199751);
        h.b localb = FinderVLogCompositionPlayView.a(this.Lcp);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.Lcp), FinderVLogCompositionPlayView.c(this.Lcp), "", -1, -1);
          AppMethodBeat.o(199751);
          return;
        }
        AppMethodBeat.o(199751);
      }
    });
    AppMethodBeat.o(199771);
  }
  
  public final void a(com.tencent.mm.plugin.finder.loader.l paraml, boolean paramBoolean, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(199764);
    k.h(paraml, "video");
    k.h(paramFinderItem, "finderItem");
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " setVideoMedia video:" + paraml + ", isLocal:" + paramBoolean);
    this.Lcm = paraml.qCj;
    this.mediaId = paraml.aaX();
    this.Lch = new p("", "", this.mediaId, this.Lcm, paraml, paramFinderItem);
    paraml = this.LbE;
    if (paraml != null) {
      paraml.destroy();
    }
    paraml = this.Lcm;
    if (paraml != null) {
      paraml = paraml.LzL;
    }
    while (paraml != null)
    {
      this.LbE = m.b(paraml);
      paramFinderItem = this.LbE;
      if (paramFinderItem != null) {
        paramFinderItem.start();
      }
      setComposition(m.a(paraml));
      paraml = getComposition();
      if (paraml != null)
      {
        paramFinderItem = this.LbE;
        if (paramFinderItem == null) {
          k.fvU();
        }
        paraml.K((d.g.a.b)paramFinderItem);
        AppMethodBeat.o(199764);
        return;
        paraml = null;
      }
      else
      {
        AppMethodBeat.o(199764);
        return;
      }
    }
    this.LbE = null;
    AppMethodBeat.o(199764);
  }
  
  public final void a(v paramv)
  {
    AppMethodBeat.i(199762);
    k.h(paramv, "composition");
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " start");
    if (!this.qUO)
    {
      ad.w("MicroMsg.FinderVLogCompositionPlayView", "isViewFocused=" + this.qUO);
      AppMethodBeat.o(199762);
      return;
    }
    if (this.qUQ)
    {
      t localt = this.Lck;
      if (localt != null) {
        localt.fWu();
      }
    }
    super.a(paramv);
    this.qUQ = false;
    AppMethodBeat.o(199762);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(199770);
    super.seekTo((1000.0D * paramDouble));
    AppMethodBeat.o(199770);
    return true;
  }
  
  public final void cCC() {}
  
  public final boolean cPP()
  {
    return this.Lci;
  }
  
  public final void csz()
  {
    AppMethodBeat.i(199753);
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  pauseWithCancel");
    super.pause();
    AppMethodBeat.o(199753);
  }
  
  public final void fWo()
  {
    AppMethodBeat.i(199752);
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " createPlayer");
    super.fWo();
    Object localObject = this.Lcl;
    if (localObject != null) {
      ((h.b)localObject).db(this.sessionId, this.mediaId);
    }
    localObject = getComposition();
    if (localObject != null) {
      localObject = new Size((int)((v)localObject).LqJ.getRenderSize().width, (int)((v)localObject).LqJ.getRenderSize().height);
    }
    while (localObject != null)
    {
      h.b localb = this.Lcl;
      if (localb != null)
      {
        localb.d(this.sessionId, this.mediaId, ((Size)localObject).getWidth(), ((Size)localObject).getHeight());
        AppMethodBeat.o(199752);
        return;
        localObject = null;
      }
      else
      {
        AppMethodBeat.o(199752);
        return;
      }
    }
    AppMethodBeat.o(199752);
  }
  
  public final boolean fWp()
  {
    AppMethodBeat.i(199761);
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " startOrPlay");
    boolean bool = this.qUQ;
    v localv = getComposition();
    if (localv != null) {
      a(localv);
    }
    AppMethodBeat.o(199761);
    return bool;
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(199755);
    g localg = getPlayer();
    if (localg != null) {}
    for (int i = (int)localg.fYU();; i = 0)
    {
      i /= 1000;
      AppMethodBeat.o(199755);
      return i;
    }
  }
  
  public final boolean getIsNeverStart()
  {
    return this.qUQ;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.qUP;
  }
  
  public final t getLifecycle()
  {
    return this.Lck;
  }
  
  public final p getMediaInfo()
  {
    return this.Lch;
  }
  
  public final q getMuteListener()
  {
    return this.Lcj;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(199757);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(199757);
    return localViewParent;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(199756);
    Object localObject = getPlayer();
    long l;
    if (localObject != null)
    {
      localObject = ((g)localObject).player;
      if (localObject != null)
      {
        localObject = ((Player)localObject).duration();
        if (localObject != null) {
          l = ((CMTime)localObject).getTimeUs();
        }
      }
    }
    for (int i = (int)(l / 1000L);; i = 0)
    {
      i /= 1000;
      AppMethodBeat.o(199756);
      return i;
      l = 0L;
      break;
    }
  }
  
  public final String getVideoMediaId()
  {
    p localp = this.Lch;
    if (localp != null) {
      return localp.mediaId;
    }
    return null;
  }
  
  public final p getVideoMediaInfo()
  {
    return this.Lch;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.qUO;
  }
  
  public final boolean get_isPreviewing()
  {
    return this.Lci;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(199760);
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " onUIDestroy");
    this.qUO = false;
    release();
    f localf = this.LbE;
    if (localf != null)
    {
      localf.destroy();
      AppMethodBeat.o(199760);
      return;
    }
    AppMethodBeat.o(199760);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(199754);
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  pause");
    boolean bool = super.pause();
    Object localObject = this.Lcl;
    if (localObject != null) {
      ((h.b)localObject).dd(this.sessionId, this.mediaId);
    }
    localObject = this.Lck;
    if (localObject != null) {
      ((t)localObject).csv();
    }
    AppMethodBeat.o(199754);
    return bool;
  }
  
  public final boolean play()
  {
    AppMethodBeat.i(199758);
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " play");
    boolean bool = super.play();
    Object localObject = this.Lcl;
    if (localObject != null) {
      ((h.b)localObject).de(this.sessionId, this.mediaId);
    }
    localObject = this.Lck;
    if (localObject != null) {
      ((t)localObject).csx();
    }
    AppMethodBeat.o(199758);
    return bool;
  }
  
  public final void setIMMVideoViewCallback(h.b paramb)
  {
    AppMethodBeat.i(199765);
    k.h(paramb, "_callback");
    this.Lcl = paramb;
    AppMethodBeat.o(199765);
  }
  
  public final void setIOnlineVideoProxy(com.tencent.mm.modelvideo.b paramb)
  {
    AppMethodBeat.i(199767);
    k.h(paramb, "_proxy");
    AppMethodBeat.o(199767);
  }
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    this.qUP = paramBoolean;
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean) {}
  
  public final void setLifecycle(t paramt)
  {
    this.Lck = paramt;
  }
  
  public final void setMediaInfo(p paramp)
  {
    this.Lch = paramp;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(199759);
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  setMute:" + paramBoolean);
    super.ze(paramBoolean);
    AppMethodBeat.o(199759);
  }
  
  public final void setMuteListener(q paramq)
  {
    this.Lcj = paramq;
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.qUQ = paramBoolean;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    this.Lci = paramBoolean;
  }
  
  public final void setScaleType(h.e parame)
  {
    AppMethodBeat.i(199766);
    k.h(parame, "scaleType");
    AppMethodBeat.o(199766);
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.qUP = paramBoolean;
  }
  
  public final void setVideoMuteListener(q paramq)
  {
    AppMethodBeat.i(199769);
    k.h(paramq, "muteListener");
    this.Lcj = paramq;
    AppMethodBeat.o(199769);
  }
  
  public final void setVideoPlayLifecycle(t paramt)
  {
    AppMethodBeat.i(199768);
    k.h(paramt, "lifecycle");
    this.Lck = paramt;
    AppMethodBeat.o(199768);
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    this.qUO = paramBoolean;
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.qUO = paramBoolean;
  }
  
  public final void set_isPreviewing(boolean paramBoolean)
  {
    this.Lci = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(199763);
    ad.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " stop");
    super.stop();
    t localt = this.Lck;
    if (localt != null) {
      localt.a(this.Lch);
    }
    this.qUQ = true;
    this.Lcn = true;
    this.qUO = false;
    AppMethodBeat.o(199763);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVLogCompositionPlayView$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView
 * JD-Core Version:    0.7.0.1
 */