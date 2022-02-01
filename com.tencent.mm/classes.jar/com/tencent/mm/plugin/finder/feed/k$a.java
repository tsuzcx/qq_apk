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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedId", "", "scene", "", "(Lcom/tencent/mm/ui/MMActivity;JI)V", "cacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getFeedId", "()J", "getScene", "()I", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class k$a
  extends u.a
{
  private final long dtq;
  private final com.tencent.mm.plugin.finder.feed.model.d rTq;
  private final FinderTimelineRefCacheVM rVP;
  private final int scene;
  
  public k$a(MMActivity paramMMActivity, long paramLong, int paramInt)
  {
    super(paramMMActivity);
    AppMethodBeat.i(201813);
    this.dtq = paramLong;
    this.scene = paramInt;
    a locala = a.KiD;
    this.rTq = ((FinderCommentPreloaderUIC)a.s(paramMMActivity).get(FinderCommentPreloaderUIC.class)).rTq;
    paramMMActivity = a.KiD;
    paramMMActivity = a.bi(PluginFinder.class).get(FinderTimelineRefCacheVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…neRefCacheVM::class.java)");
    this.rVP = ((FinderTimelineRefCacheVM)paramMMActivity);
    AppMethodBeat.o(201813);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, u.b paramb)
  {
    AppMethodBeat.i(201811);
    p.h(paramBaseFinderFeedLoader, "model");
    p.h(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.rTq.a(this.scene, this.rTD, (b)new a(this));
    paramBaseFinderFeedLoader = FinderReporterUIC.tcM;
    paramBaseFinderFeedLoader = FinderReporterUIC.a.eY((Context)this.fLP);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.rTq);
        AppMethodBeat.o(201811);
        return;
      }
    }
    AppMethodBeat.o(201811);
  }
  
  public final void aTt()
  {
    AppMethodBeat.i(201810);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rTS;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(201810);
      return;
    }
    AppMethodBeat.o(201810);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201812);
    this.rTq.onDetach();
    Object localObject2 = this.rVP;
    String str = String.valueOf(this.dtq);
    Object localObject1 = this.rTS;
    if (localObject1 != null)
    {
      localObject1 = ((BaseFinderFeedLoader)localObject1).getDataListJustForAdapter();
      if (localObject1 == null) {}
    }
    for (localObject1 = (ArrayList)localObject1;; localObject1 = new ArrayList())
    {
      p.h(str, "key");
      p.h(localObject1, "lastDataList");
      ad.i("Finder.TimelineCacheVM", "[store] key=" + str + " lastExitPosition=0 lastExitFromTopPx=0 lastDataList size=" + ((ArrayList)localObject1).size() + ' ' + "current=" + i.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L));
      localObject2 = ((FinderTimelineRefCacheVM)localObject2).taB;
      FinderTimelineRefCacheVM.a locala = new FinderTimelineRefCacheVM.a(str);
      locala.sZo = 0;
      locala.sZp = 0;
      localObject1 = (List)localObject1;
      p.h(localObject1, "<set-?>");
      locala.sZm = ((List)localObject1);
      locala.sZq = System.currentTimeMillis();
      ((com.tencent.mm.loader.h.d)localObject2).put(str, locala);
      localObject1 = FinderReporterUIC.tcM;
      localObject1 = FinderReporterUIC.a.eY((Context)this.fLP);
      if (localObject1 != null)
      {
        localObject1 = FinderReporterUIC.a((FinderReporterUIC)localObject1);
        if (localObject1 != null) {
          ((c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)this.rTq);
        }
      }
      super.onDetach();
      AppMethodBeat.o(201812);
      return;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(201809);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rTS;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(201809);
      return;
    }
    AppMethodBeat.o(201809);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.k.a
 * JD-Core Version:    0.7.0.1
 */