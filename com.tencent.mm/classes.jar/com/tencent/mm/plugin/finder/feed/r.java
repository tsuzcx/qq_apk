package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.b.a;
import com.tencent.mm.plugin.finder.feed.model.e;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTimelineRefCacheVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.a.b;
import d.g.b.k;
import java.util.ArrayList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class r
{
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedId", "", "scene", "", "(Lcom/tencent/mm/ui/MMActivity;JI)V", "cacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getFeedId", "()J", "getScene", "()I", "getInitRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
  public static final class a
    extends e.a
  {
    private final FinderTimelineRefCacheVM KNr;
    private final long feedId;
    private final e qvy;
    private final int scene;
    
    public a(MMActivity paramMMActivity, long paramLong, int paramInt)
    {
      super();
      AppMethodBeat.i(197718);
      this.feedId = paramLong;
      this.scene = paramInt;
      this.qvy = new e(paramMMActivity);
      paramMMActivity = a.LCX;
      paramMMActivity = a.bE(PluginFinder.class).get(FinderTimelineRefCacheVM.class);
      k.g(paramMMActivity, "UICProvider.of(PluginFin…neRefCacheVM::class.java)");
      this.KNr = ((FinderTimelineRefCacheVM)paramMMActivity);
      AppMethodBeat.o(197718);
    }
    
    public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, e.b paramb)
    {
      AppMethodBeat.i(197716);
      k.h(paramBaseFinderFeedLoader, "model");
      k.h(paramb, "callback");
      super.a(paramBaseFinderFeedLoader, paramb);
      this.qvy.a(this.scene, this.qqE, (b)new b(this));
      paramBaseFinderFeedLoader = FinderReporterUIC.Ljl;
      paramBaseFinderFeedLoader = FinderReporterUIC.a.lB((Context)this.imP);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
        if (paramBaseFinderFeedLoader != null)
        {
          paramBaseFinderFeedLoader.a((f)this.qvy);
          AppMethodBeat.o(197716);
          return;
        }
      }
      AppMethodBeat.o(197716);
    }
    
    public final void aJq()
    {
      AppMethodBeat.i(197715);
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestLoadMore();
        AppMethodBeat.o(197715);
        return;
      }
      AppMethodBeat.o(197715);
    }
    
    public final com.tencent.mm.plugin.finder.feed.model.internal.h clZ()
    {
      AppMethodBeat.i(197713);
      com.tencent.mm.plugin.finder.feed.model.internal.h localh = (com.tencent.mm.plugin.finder.feed.model.internal.h)new b.a(this.feedId, (g)new a());
      AppMethodBeat.o(197713);
      return localh;
    }
    
    public final void onDetach()
    {
      AppMethodBeat.i(197717);
      this.qvy.onDetach();
      Object localObject2 = this.KNr;
      String str = String.valueOf(this.feedId);
      Object localObject1 = this.qvo;
      if (localObject1 != null)
      {
        localObject1 = ((BaseFinderFeedLoader)localObject1).getDataListJustForAdapter();
        if (localObject1 == null) {}
      }
      for (localObject1 = (ArrayList)localObject1;; localObject1 = new ArrayList())
      {
        k.h(str, "key");
        k.h(localObject1, "lastDataList");
        ad.i("Finder.TimelineCacheVM", "[store] key=" + str + " lastExitPosition=0 lastExitFromTopPx=0 lastDataList size=" + ((ArrayList)localObject1).size() + ' ' + "current=" + com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L));
        localObject2 = ((FinderTimelineRefCacheVM)localObject2).Lhx;
        FinderTimelineRefCacheVM.a locala = new FinderTimelineRefCacheVM.a(str);
        locala.Lhf = 0;
        locala.Lhg = 0;
        localObject1 = (List)localObject1;
        k.h(localObject1, "<set-?>");
        locala.Lhe = ((List)localObject1);
        locala.Lhh = System.currentTimeMillis();
        ((com.tencent.mm.loader.h.d)localObject2).put(str, locala);
        localObject1 = FinderReporterUIC.Ljl;
        localObject1 = FinderReporterUIC.a.lB((Context)this.imP);
        if (localObject1 != null)
        {
          localObject1 = FinderReporterUIC.a((FinderReporterUIC)localObject1);
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.event.base.d)localObject1).b((f)this.qvy);
          }
        }
        super.onDetach();
        AppMethodBeat.o(197717);
        return;
      }
    }
    
    public final void requestRefresh()
    {
      AppMethodBeat.i(197714);
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestRefresh();
        AppMethodBeat.o(197714);
        return;
      }
      AppMethodBeat.o(197714);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter$getInitRequest$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class a
      implements g
    {
      public final void call(int paramInt) {}
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements b<Integer, BaseFinderFeed>
    {
      b(r.a parama)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
  public static final class b
    extends e.b
  {
    public b(MMActivity paramMMActivity, r.a parama, int paramInt)
    {
      super((e.a)parama, paramInt, 20);
      AppMethodBeat.i(197720);
      AppMethodBeat.o(197720);
    }
    
    public final void O(ArrayList<BaseFinderFeed> paramArrayList)
    {
      AppMethodBeat.i(197719);
      k.h(paramArrayList, "data");
      super.O(paramArrayList);
      paramArrayList = this.quj;
      View localView = y.js((Context)this.imP).inflate(2131494590, null);
      k.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramArrayList.setLoadMoreFooter(localView);
      AppMethodBeat.o(197719);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.r
 * JD-Core Version:    0.7.0.1
 */