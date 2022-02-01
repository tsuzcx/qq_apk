package com.tencent.mm.plugin.finder.video;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "Lcom/tencent/mm/app/IAppForegroundListener;", "tabType", "", "(I)V", "autoPlayManager", "Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "getAutoPlayManager", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "setAutoPlayManager", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;)V", "isDefaultMute", "", "Ljava/lang/Boolean;", "playEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "getPlayEventSubscriber", "()Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "setPlayEventSubscriber", "(Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;)V", "playingFeedId", "", "getPlayingFeedId", "()J", "setPlayingFeedId", "(J)V", "preloadCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "getPreloadCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "setPreloadCore", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "recycler", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "getRecycler", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "setRecycler", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getTabType", "()I", "videoDownloader", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "getVideoDownloader", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "setVideoDownloader", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;)V", "onAppBackground", "", "activity", "", "onAppForeground", "onInitialize", "context", "Lcom/tencent/mm/ui/MMActivity;", "initializer", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "isPreInflate", "pauseAllVideo", "setDefaultMute", "isMute", "Companion", "Initializer", "plugin-finder_release"})
public final class i
  extends com.tencent.mm.plugin.finder.life.a
  implements com.tencent.mm.app.n
{
  public static final i.a rSv;
  private final int diw;
  private RecyclerView fTr;
  public FinderVideoRecycler rSl;
  com.tencent.mm.plugin.finder.loader.n rSq;
  public FinderVideoAutoPlayManager rSr;
  com.tencent.mm.plugin.finder.event.b rSs;
  public MediaPreloadCore rSt;
  public long rSu;
  
  static
  {
    AppMethodBeat.i(168046);
    rSv = new i.a((byte)0);
    AppMethodBeat.o(168046);
  }
  
  public i(int paramInt)
  {
    AppMethodBeat.i(203849);
    this.diw = paramInt;
    this.rSq = new com.tencent.mm.plugin.finder.loader.n();
    AppMethodBeat.o(203849);
  }
  
  public final void a(MMActivity paramMMActivity, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(203847);
    k.h(paramMMActivity, "context");
    Object localObject1 = com.tencent.mm.ui.component.a.IrY;
    localObject1 = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderVideoRecycler.class);
    k.g(localObject1, "UICProvider.of(PluginFin…ideoRecycler::class.java)");
    this.rSl = ((FinderVideoRecycler)localObject1);
    localObject1 = this.rSl;
    if (localObject1 == null) {
      k.aVY("recycler");
    }
    ((FinderVideoRecycler)localObject1).b(paramMMActivity, paramBoolean);
    if (paramb != null)
    {
      localObject1 = paramb.cuw();
      this.fTr = ((RecyclerView)localObject1);
      paramb = paramb.cux();
      Object localObject2 = com.tencent.mm.ui.component.a.IrY;
      localObject2 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(paramMMActivity).get(FinderReporterUIC.class)).Fd(this.diw);
      if (localObject2 != null) {
        this.rSs = new com.tencent.mm.plugin.finder.event.b((c)localObject2);
      }
      localObject2 = com.tencent.mm.ui.component.a.IrY;
      localObject2 = com.tencent.mm.ui.component.a.q(paramMMActivity).get(MediaPreloadCore.class);
      MediaPreloadCore localMediaPreloadCore = (MediaPreloadCore)localObject2;
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
      localMediaPreloadCore.a(paramb, ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(paramMMActivity).get(FinderReporterUIC.class)).Fd(this.diw));
      this.rSt = ((MediaPreloadCore)localObject2);
      this.rSq = new com.tencent.mm.plugin.finder.loader.n(this.rSt);
      paramb = this.rSl;
      if (paramb == null) {
        k.aVY("recycler");
      }
      this.rSr = new FinderVideoAutoPlayManager(paramMMActivity, (RecyclerView)localObject1, paramb, this.diw);
      paramb = this.rSr;
      if (paramb == null) {
        k.fOy();
      }
      paramb.setup();
    }
    a(paramMMActivity, (UILifecycleObserver)new FinderVideoCore.onInitialize.2(this, paramMMActivity));
    AppMethodBeat.o(203847);
  }
  
  public final FinderVideoRecycler cDX()
  {
    AppMethodBeat.i(203846);
    FinderVideoRecycler localFinderVideoRecycler = this.rSl;
    if (localFinderVideoRecycler == null) {
      k.aVY("recycler");
    }
    AppMethodBeat.o(203846);
    return localFinderVideoRecycler;
  }
  
  public final void cDY()
  {
    AppMethodBeat.i(168043);
    FinderVideoRecycler localFinderVideoRecycler = this.rSl;
    if (localFinderVideoRecycler == null) {
      k.aVY("recycler");
    }
    localFinderVideoRecycler.C((d.g.a.b)i.c.rSx);
    AppMethodBeat.o(168043);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(168044);
    paramString = this.rSl;
    if (paramString == null) {
      k.aVY("recycler");
    }
    paramString.eX(null);
    AppMethodBeat.o(168044);
  }
  
  public final void onAppForeground(String paramString) {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract RecyclerView cuw();
    
    public abstract DataBuffer<BaseFinderFeed> cux();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.i
 * JD-Core Version:    0.7.0.1
 */