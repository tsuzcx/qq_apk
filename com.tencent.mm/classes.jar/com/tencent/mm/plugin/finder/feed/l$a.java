package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedId", "", "scene", "", "(Lcom/tencent/mm/ui/MMActivity;JI)V", "cacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getFeedId", "()J", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getScene", "()I", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class l$a
  extends v.a
{
  private final long feedId;
  private final int scene;
  private final com.tencent.mm.plugin.finder.feed.model.d tLy;
  private final com.tencent.mm.plugin.finder.feed.model.f tLz;
  private final FinderTimelineRefCacheVM tOc;
  
  public l$a(MMActivity paramMMActivity, long paramLong, int paramInt)
  {
    super(paramMMActivity);
    AppMethodBeat.i(243822);
    this.feedId = paramLong;
    this.scene = paramInt;
    a locala = a.PRN;
    this.tLy = ((FinderCommentPreloaderUIC)a.b((AppCompatActivity)paramMMActivity).get(FinderCommentPreloaderUIC.class)).tLy;
    locala = a.PRN;
    this.tLz = ((FinderLiveNoticePreLoadUIC)a.b((AppCompatActivity)paramMMActivity).get(FinderLiveNoticePreLoadUIC.class)).wyi;
    paramMMActivity = a.PRN;
    paramMMActivity = a.bi(PluginFinder.class).get(FinderTimelineRefCacheVM.class);
    p.g(paramMMActivity, "UICProvider.of(PluginFin…neRefCacheVM::class.java)");
    this.tOc = ((FinderTimelineRefCacheVM)paramMMActivity);
    AppMethodBeat.o(243822);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, v.b paramb)
  {
    AppMethodBeat.i(243820);
    p.h(paramBaseFinderFeedLoader, "model");
    p.h(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.tLy.a(this.scene, this.tCE, (b)new a(this));
    paramBaseFinderFeedLoader = FinderReporterUIC.wzC;
    paramBaseFinderFeedLoader = FinderReporterUIC.a.fH((Context)this.gte);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.tLy);
      }
    }
    this.tLz.e((m)new b(this));
    paramBaseFinderFeedLoader = FinderReporterUIC.wzC;
    paramBaseFinderFeedLoader = FinderReporterUIC.a.fH((Context)this.gte);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.tLz);
        AppMethodBeat.o(243820);
        return;
      }
    }
    AppMethodBeat.o(243820);
  }
  
  public final void boE()
  {
    AppMethodBeat.i(243819);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(243819);
      return;
    }
    AppMethodBeat.o(243819);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(243821);
    this.tLy.onDetach();
    Object localObject2 = this.tOc;
    String str = String.valueOf(this.feedId);
    Object localObject1 = this.tFM;
    if (localObject1 != null)
    {
      localObject1 = ((BaseFinderFeedLoader)localObject1).getDataListJustForAdapter();
      if (localObject1 == null) {}
    }
    for (localObject1 = (ArrayList)localObject1;; localObject1 = new ArrayList())
    {
      p.h(str, "key");
      p.h(localObject1, "lastDataList");
      Log.i("Finder.TimelineCacheVM", "[store] key=" + str + " lastExitPosition=0 lastExitFromTopPx=0 lastDataList size=" + ((ArrayList)localObject1).size() + ' ' + "current=" + com.tencent.mm.pluginsdk.i.f.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L));
      localObject2 = ((FinderTimelineRefCacheVM)localObject2).wuV;
      FinderTimelineRefCacheVM.a locala = new FinderTimelineRefCacheVM.a(str);
      locala.wuf = 0;
      locala.wug = 0;
      localObject1 = (List)localObject1;
      p.h(localObject1, "<set-?>");
      locala.wuc = ((List)localObject1);
      locala.wuh = System.currentTimeMillis();
      ((com.tencent.mm.loader.h.d)localObject2).put(str, locala);
      localObject1 = FinderReporterUIC.wzC;
      localObject1 = FinderReporterUIC.a.fH((Context)this.gte);
      if (localObject1 != null)
      {
        localObject1 = FinderReporterUIC.a((FinderReporterUIC)localObject1);
        if (localObject1 != null) {
          ((c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)this.tLy);
        }
      }
      this.tLz.onDetach();
      localObject1 = FinderReporterUIC.wzC;
      localObject1 = FinderReporterUIC.a.fH((Context)this.gte);
      if (localObject1 != null)
      {
        localObject1 = FinderReporterUIC.a((FinderReporterUIC)localObject1);
        if (localObject1 != null) {
          ((c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)this.tLz);
        }
      }
      super.onDetach();
      AppMethodBeat.o(243821);
      return;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(243818);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(243818);
      return;
    }
    AppMethodBeat.o(243818);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class a
    extends q
    implements b<Integer, bo>
  {
    a(l.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
  static final class b
    extends q
    implements m<Integer, Integer, LinkedList<bo>>
  {
    b(l.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.l.a
 * JD-Core Version:    0.7.0.1
 */