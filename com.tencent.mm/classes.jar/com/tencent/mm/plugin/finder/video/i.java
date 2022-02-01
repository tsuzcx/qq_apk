package com.tencent.mm.plugin.finder.video;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "Lcom/tencent/mm/app/IAppForegroundListener;", "tabType", "", "(I)V", "autoPlayManager", "Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "getAutoPlayManager", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "setAutoPlayManager", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;)V", "isDefaultMute", "", "Ljava/lang/Boolean;", "playEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "getPlayEventSubscriber", "()Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "setPlayEventSubscriber", "(Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;)V", "playingFeedId", "", "getPlayingFeedId", "()J", "setPlayingFeedId", "(J)V", "preloadCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "getPreloadCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "setPreloadCore", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "recycler", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "getRecycler", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "setRecycler", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getTabType", "()I", "videoDownloader", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "getVideoDownloader", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "setVideoDownloader", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;)V", "onAppBackground", "", "activity", "", "onAppForeground", "onInitialize", "context", "Lcom/tencent/mm/ui/MMActivity;", "initializer", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "isPreInflate", "pauseAllVideo", "setDefaultMute", "isMute", "Companion", "Initializer", "plugin-finder_release"})
public final class i
  extends com.tencent.mm.plugin.finder.life.a
  implements com.tencent.mm.app.o
{
  public static final i.a taq;
  private final int dvm;
  private RecyclerView gpr;
  public FinderVideoRecycler tab;
  com.tencent.mm.plugin.finder.loader.o tal;
  public FinderVideoAutoPlayManager tam;
  com.tencent.mm.plugin.finder.event.c tan;
  public MediaPreloadCore tao;
  public long tap;
  
  static
  {
    AppMethodBeat.i(168046);
    taq = new i.a((byte)0);
    AppMethodBeat.o(168046);
  }
  
  public i(int paramInt)
  {
    AppMethodBeat.i(205410);
    this.dvm = paramInt;
    this.tal = new com.tencent.mm.plugin.finder.loader.o();
    AppMethodBeat.o(205410);
  }
  
  public final void a(MMActivity paramMMActivity, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(205408);
    p.h(paramMMActivity, "context");
    Object localObject1 = com.tencent.mm.ui.component.a.KEX;
    localObject1 = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class);
    p.g(localObject1, "UICProvider.of(PluginFin…ideoRecycler::class.java)");
    this.tab = ((FinderVideoRecycler)localObject1);
    localObject1 = this.tab;
    if (localObject1 == null) {
      p.bdF("recycler");
    }
    ((FinderVideoRecycler)localObject1).b(paramMMActivity, paramBoolean);
    if (paramb != null)
    {
      localObject1 = paramb.cCt();
      this.gpr = ((RecyclerView)localObject1);
      paramb = paramb.cCu();
      Object localObject2 = com.tencent.mm.ui.component.a.KEX;
      localObject2 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class)).GQ(this.dvm);
      if (localObject2 != null) {
        this.tan = new com.tencent.mm.plugin.finder.event.c((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      }
      localObject2 = com.tencent.mm.ui.component.a.KEX;
      localObject2 = com.tencent.mm.ui.component.a.s(paramMMActivity).get(MediaPreloadCore.class);
      MediaPreloadCore localMediaPreloadCore = (MediaPreloadCore)localObject2;
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
      localMediaPreloadCore.a(paramb, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class)).GQ(this.dvm));
      this.tao = ((MediaPreloadCore)localObject2);
      this.tal = new com.tencent.mm.plugin.finder.loader.o(this.tao);
      paramb = this.tab;
      if (paramb == null) {
        p.bdF("recycler");
      }
      this.tam = new FinderVideoAutoPlayManager(paramMMActivity, (RecyclerView)localObject1, paramb, this.dvm);
      paramb = this.tam;
      if (paramb == null) {
        p.gkB();
      }
      paramb.setup();
    }
    a(paramMMActivity, (UILifecycleObserver)new FinderVideoCore.onInitialize.2(this, paramMMActivity));
    AppMethodBeat.o(205408);
  }
  
  public final FinderVideoRecycler cPa()
  {
    AppMethodBeat.i(205407);
    FinderVideoRecycler localFinderVideoRecycler = this.tab;
    if (localFinderVideoRecycler == null) {
      p.bdF("recycler");
    }
    AppMethodBeat.o(205407);
    return localFinderVideoRecycler;
  }
  
  public final void cPb()
  {
    AppMethodBeat.i(168043);
    FinderVideoRecycler localFinderVideoRecycler = this.tab;
    if (localFinderVideoRecycler == null) {
      p.bdF("recycler");
    }
    localFinderVideoRecycler.E((b)i.c.tas);
    AppMethodBeat.o(168043);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(168044);
    paramString = this.tab;
    if (paramString == null) {
      p.bdF("recycler");
    }
    paramString.fe(null);
    AppMethodBeat.o(168044);
  }
  
  public final void onAppForeground(String paramString) {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract RecyclerView cCt();
    
    public abstract DataBuffer<am> cCu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.i
 * JD-Core Version:    0.7.0.1
 */