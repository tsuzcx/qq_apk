package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.e.a;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.g.b.k;
import java.util.ArrayList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedId", "", "scene", "", "(Lcom/tencent/mm/ui/MMActivity;JI)V", "cacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getFeedId", "()J", "getScene", "()I", "getInitRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class j$a
  extends r.a
{
  private final long dig;
  private final com.tencent.mm.plugin.finder.feed.model.c rfE;
  private final FinderTimelineRefCacheVM rhJ;
  private final int scene;
  
  public j$a(MMActivity paramMMActivity, long paramLong, int paramInt)
  {
    super(paramMMActivity);
    AppMethodBeat.i(201615);
    this.dig = paramLong;
    this.scene = paramInt;
    this.rfE = new com.tencent.mm.plugin.finder.feed.model.c(paramMMActivity);
    paramMMActivity = a.IrY;
    paramMMActivity = a.bg(PluginFinder.class).get(FinderTimelineRefCacheVM.class);
    k.g(paramMMActivity, "UICProvider.of(PluginFin…neRefCacheVM::class.java)");
    this.rhJ = ((FinderTimelineRefCacheVM)paramMMActivity);
    AppMethodBeat.o(201615);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, r.b paramb)
  {
    AppMethodBeat.i(201613);
    k.h(paramBaseFinderFeedLoader, "model");
    k.h(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.rfE.a(this.scene, this.rfR, (b)new b(this));
    paramBaseFinderFeedLoader = FinderReporterUIC.seQ;
    paramBaseFinderFeedLoader = FinderReporterUIC.a.eV((Context)this.iMV);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.rfE);
        AppMethodBeat.o(201613);
        return;
      }
    }
    AppMethodBeat.o(201613);
  }
  
  public final void aQh()
  {
    AppMethodBeat.i(201612);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rgh;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(201612);
      return;
    }
    AppMethodBeat.o(201612);
  }
  
  public final g cup()
  {
    AppMethodBeat.i(201610);
    g localg = (g)new e.a(this.dig, (f)new a());
    AppMethodBeat.o(201610);
    return localg;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201614);
    this.rfE.onDetach();
    Object localObject2 = this.rhJ;
    String str = String.valueOf(this.dig);
    Object localObject1 = this.rgh;
    if (localObject1 != null)
    {
      localObject1 = ((BaseFinderFeedLoader)localObject1).getDataListJustForAdapter();
      if (localObject1 == null) {}
    }
    for (localObject1 = (ArrayList)localObject1;; localObject1 = new ArrayList())
    {
      k.h(str, "key");
      k.h(localObject1, "lastDataList");
      ac.i("Finder.TimelineCacheVM", "[store] key=" + str + " lastExitPosition=0 lastExitFromTopPx=0 lastDataList size=" + ((ArrayList)localObject1).size() + ' ' + "current=" + h.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L));
      localObject2 = ((FinderTimelineRefCacheVM)localObject2).sda;
      FinderTimelineRefCacheVM.a locala = new FinderTimelineRefCacheVM.a(str);
      locala.sbW = 0;
      locala.sbX = 0;
      localObject1 = (List)localObject1;
      k.h(localObject1, "<set-?>");
      locala.sbU = ((List)localObject1);
      locala.sbY = System.currentTimeMillis();
      ((com.tencent.mm.loader.h.d)localObject2).put(str, locala);
      localObject1 = FinderReporterUIC.seQ;
      localObject1 = FinderReporterUIC.a.eV((Context)this.iMV);
      if (localObject1 != null)
      {
        localObject1 = FinderReporterUIC.a((FinderReporterUIC)localObject1);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)this.rfE);
        }
      }
      super.onDetach();
      AppMethodBeat.o(201614);
      return;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(201611);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rgh;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(201611);
      return;
    }
    AppMethodBeat.o(201611);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter$getInitRequest$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements f
  {
    public final void call(int paramInt) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<Integer, BaseFinderFeed>
  {
    b(j.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.j.a
 * JD-Core Version:    0.7.0.1
 */