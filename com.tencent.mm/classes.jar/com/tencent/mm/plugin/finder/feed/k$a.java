package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedId", "", "scene", "", "(Lcom/tencent/mm/ui/MMActivity;JI)V", "cacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getFeedId", "()J", "getScene", "()I", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class k$a
  extends u.a
{
  private final long duw;
  private final com.tencent.mm.plugin.finder.feed.model.d sbU;
  private final int scene;
  private final FinderTimelineRefCacheVM sew;
  
  public k$a(MMActivity paramMMActivity, long paramLong, int paramInt)
  {
    super(paramMMActivity);
    AppMethodBeat.i(202272);
    this.duw = paramLong;
    this.scene = paramInt;
    a locala = a.KEX;
    this.sbU = ((FinderCommentPreloaderUIC)a.s(paramMMActivity).get(FinderCommentPreloaderUIC.class)).sbU;
    paramMMActivity = a.KEX;
    paramMMActivity = a.bi(PluginFinder.class).get(FinderTimelineRefCacheVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…neRefCacheVM::class.java)");
    this.sew = ((FinderTimelineRefCacheVM)paramMMActivity);
    AppMethodBeat.o(202272);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, u.b paramb)
  {
    AppMethodBeat.i(202270);
    p.h(paramBaseFinderFeedLoader, "model");
    p.h(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.sbU.a(this.scene, this.sch, (b)new a(this));
    paramBaseFinderFeedLoader = FinderReporterUIC.tnG;
    paramBaseFinderFeedLoader = FinderReporterUIC.a.fc((Context)this.fNT);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.sbU);
        AppMethodBeat.o(202270);
        return;
      }
    }
    AppMethodBeat.o(202270);
  }
  
  public final void aTS()
  {
    AppMethodBeat.i(202269);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.scw;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(202269);
      return;
    }
    AppMethodBeat.o(202269);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(202271);
    this.sbU.onDetach();
    Object localObject2 = this.sew;
    String str = String.valueOf(this.duw);
    Object localObject1 = this.scw;
    if (localObject1 != null)
    {
      localObject1 = ((BaseFinderFeedLoader)localObject1).getDataListJustForAdapter();
      if (localObject1 == null) {}
    }
    for (localObject1 = (ArrayList)localObject1;; localObject1 = new ArrayList())
    {
      p.h(str, "key");
      p.h(localObject1, "lastDataList");
      ae.i("Finder.TimelineCacheVM", "[store] key=" + str + " lastExitPosition=0 lastExitFromTopPx=0 lastDataList size=" + ((ArrayList)localObject1).size() + ' ' + "current=" + i.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L));
      localObject2 = ((FinderTimelineRefCacheVM)localObject2).tlp;
      FinderTimelineRefCacheVM.a locala = new FinderTimelineRefCacheVM.a(str);
      locala.tkC = 0;
      locala.tkD = 0;
      localObject1 = (List)localObject1;
      p.h(localObject1, "<set-?>");
      locala.tkA = ((List)localObject1);
      locala.tkE = System.currentTimeMillis();
      ((com.tencent.mm.loader.h.d)localObject2).put(str, locala);
      localObject1 = FinderReporterUIC.tnG;
      localObject1 = FinderReporterUIC.a.fc((Context)this.fNT);
      if (localObject1 != null)
      {
        localObject1 = FinderReporterUIC.a((FinderReporterUIC)localObject1);
        if (localObject1 != null) {
          ((c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)this.sbU);
        }
      }
      super.onDetach();
      AppMethodBeat.o(202271);
      return;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(202268);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.scw;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(202268);
      return;
    }
    AppMethodBeat.o(202268);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
  static final class a
    extends q
    implements b<Integer, BaseFinderFeed>
  {
    a(k.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.k.a
 * JD-Core Version:    0.7.0.1
 */