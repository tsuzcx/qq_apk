package com.tencent.mm.plugin.finder.video;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "Lcom/tencent/mm/app/IAppForegroundListener;", "tabType", "", "(I)V", "autoPlayManager", "Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "getAutoPlayManager", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;", "setAutoPlayManager", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoAutoPlayManager;)V", "isDefaultMute", "", "Ljava/lang/Boolean;", "playEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "getPlayEventSubscriber", "()Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "setPlayEventSubscriber", "(Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;)V", "playingFeedId", "", "getPlayingFeedId", "()J", "setPlayingFeedId", "(J)V", "preloadCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "getPreloadCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "setPreloadCore", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "recycler", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "getRecycler", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;", "setRecycler", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getTabType", "()I", "videoDownloader", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "getVideoDownloader", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "setVideoDownloader", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;)V", "onAppBackground", "", "activity", "", "onAppForeground", "onInitialize", "context", "Lcom/tencent/mm/ui/MMActivity;", "initializer", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "isPreInflate", "pauseAllVideo", "setDefaultMute", "isMute", "Companion", "Initializer", "plugin-finder_release"})
public final class i
  extends com.tencent.mm.plugin.finder.life.a
  implements n
{
  public static final a sPd;
  private final int duh;
  private RecyclerView gmV;
  public FinderVideoRecycler sOP;
  com.tencent.mm.plugin.finder.loader.o sOY;
  public FinderVideoAutoPlayManager sOZ;
  com.tencent.mm.plugin.finder.event.b sPa;
  public MediaPreloadCore sPb;
  public long sPc;
  
  static
  {
    AppMethodBeat.i(168046);
    sPd = new a((byte)0);
    AppMethodBeat.o(168046);
  }
  
  public i(int paramInt)
  {
    AppMethodBeat.i(204786);
    this.duh = paramInt;
    this.sOY = new com.tencent.mm.plugin.finder.loader.o();
    AppMethodBeat.o(204786);
  }
  
  public final void a(MMActivity paramMMActivity, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(204784);
    p.h(paramMMActivity, "context");
    Object localObject1 = com.tencent.mm.ui.component.a.KiD;
    localObject1 = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class);
    p.g(localObject1, "UICProvider.of(PluginFin…ideoRecycler::class.java)");
    this.sOP = ((FinderVideoRecycler)localObject1);
    localObject1 = this.sOP;
    if (localObject1 == null) {
      p.bcb("recycler");
    }
    ((FinderVideoRecycler)localObject1).b(paramMMActivity, paramBoolean);
    if (paramb != null)
    {
      localObject1 = paramb.cAH();
      this.gmV = ((RecyclerView)localObject1);
      paramb = paramb.cAI();
      Object localObject2 = com.tencent.mm.ui.component.a.KiD;
      localObject2 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class)).Gt(this.duh);
      if (localObject2 != null) {
        this.sPa = new com.tencent.mm.plugin.finder.event.b((c)localObject2);
      }
      localObject2 = com.tencent.mm.ui.component.a.KiD;
      localObject2 = com.tencent.mm.ui.component.a.s(paramMMActivity).get(MediaPreloadCore.class);
      MediaPreloadCore localMediaPreloadCore = (MediaPreloadCore)localObject2;
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
      localMediaPreloadCore.a(paramb, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(paramMMActivity).get(FinderReporterUIC.class)).Gt(this.duh));
      this.sPb = ((MediaPreloadCore)localObject2);
      this.sOY = new com.tencent.mm.plugin.finder.loader.o(this.sPb);
      paramb = this.sOP;
      if (paramb == null) {
        p.bcb("recycler");
      }
      this.sOZ = new FinderVideoAutoPlayManager(paramMMActivity, (RecyclerView)localObject1, paramb, this.duh);
      paramb = this.sOZ;
      if (paramb == null) {
        p.gfZ();
      }
      paramb.setup();
    }
    a(paramMMActivity, (UILifecycleObserver)new FinderVideoCore.onInitialize.2(this, paramMMActivity));
    AppMethodBeat.o(204784);
  }
  
  public final FinderVideoRecycler cMr()
  {
    AppMethodBeat.i(204783);
    FinderVideoRecycler localFinderVideoRecycler = this.sOP;
    if (localFinderVideoRecycler == null) {
      p.bcb("recycler");
    }
    AppMethodBeat.o(204783);
    return localFinderVideoRecycler;
  }
  
  public final void cMs()
  {
    AppMethodBeat.i(168043);
    FinderVideoRecycler localFinderVideoRecycler = this.sOP;
    if (localFinderVideoRecycler == null) {
      p.bcb("recycler");
    }
    localFinderVideoRecycler.D((d.g.a.b)c.sPf);
    AppMethodBeat.o(168043);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(168044);
    paramString = this.sOP;
    if (paramString == null) {
      p.bcb("recycler");
    }
    paramString.fa(null);
    AppMethodBeat.o(168044);
  }
  
  public final void onAppForeground(String paramString) {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract RecyclerView cAH();
    
    public abstract DataBuffer<al> cAI();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<o, Boolean>
  {
    public static final c sPf;
    
    static
    {
      AppMethodBeat.i(168037);
      sPf = new c();
      AppMethodBeat.o(168037);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.i
 * JD-Core Version:    0.7.0.1
 */