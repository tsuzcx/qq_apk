package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.a;
import com.tencent.mm.plugin.finder.feed.model.a.a.a;
import com.tencent.mm.plugin.finder.feed.model.a.c;
import com.tencent.mm.plugin.finder.feed.model.e;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.a.b;
import d.g.b.k;
import d.v;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class p
{
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "cacheId", "", "initPos", "", "scene", "(Lcom/tencent/mm/ui/MMActivity;JII)V", "getCacheId", "()J", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getInitPos", "()I", "getScene", "getInitRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
  public static final class a
    extends e.a
  {
    final int qvB;
    private final e qvy;
    final long qxT;
    private final int scene;
    
    public a(MMActivity paramMMActivity, long paramLong, int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(197677);
      this.qxT = paramLong;
      this.qvB = paramInt1;
      this.scene = paramInt2;
      this.qvy = new e(paramMMActivity);
      AppMethodBeat.o(197677);
    }
    
    public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, e.b paramb)
    {
      AppMethodBeat.i(197675);
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
          AppMethodBeat.o(197675);
          return;
        }
      }
      AppMethodBeat.o(197675);
    }
    
    public final void aJq()
    {
      AppMethodBeat.i(197674);
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestLoadMore();
        AppMethodBeat.o(197674);
        return;
      }
      AppMethodBeat.o(197674);
    }
    
    public final h clZ()
    {
      AppMethodBeat.i(197673);
      h localh = (h)new a.c(this.qxT, true, (g)new a(this));
      AppMethodBeat.o(197673);
      return localh;
    }
    
    public final void onDetach()
    {
      AppMethodBeat.i(197676);
      this.qvy.onDetach();
      Object localObject = FinderReporterUIC.Ljl;
      localObject = FinderReporterUIC.a.lB((Context)this.imP);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
        if (localObject != null) {
          ((d)localObject).b((f)this.qvy);
        }
      }
      super.onDetach();
      AppMethodBeat.o(197676);
    }
    
    public final void requestRefresh() {}
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$Presenter$getInitRequest$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class a
      implements g
    {
      public final void call(int paramInt)
      {
        AppMethodBeat.i(197671);
        Object localObject = this.KNf.qtZ;
        if (localObject != null)
        {
          localObject = ((a.b)localObject).quj.getRecyclerView();
          if (localObject != null)
          {
            localObject = ((RecyclerView)localObject).getLayoutManager();
            if (localObject != null)
            {
              if (localObject == null)
              {
                localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager");
                AppMethodBeat.o(197671);
                throw ((Throwable)localObject);
              }
              ((FinderLayoutManager)localObject).af(this.KNf.qvB, 0);
            }
          }
        }
        localObject = this.KNf.qvo;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
          AppMethodBeat.o(197671);
          throw ((Throwable)localObject);
        }
        localObject = (a)localObject;
        com.tencent.mm.plugin.finder.feed.model.a.a locala = a.KPO;
        ((a)localObject).lastBuffer = com.tencent.mm.plugin.finder.feed.model.a.a.BJ(this.KNf.qxT).lastBuffer;
        AppMethodBeat.o(197671);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements b<Integer, BaseFinderFeed>
    {
      b(p.a parama)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
  public static final class b
    extends e.b
  {
    public b(MMActivity paramMMActivity, p.a parama, int paramInt)
    {
      super((e.a)parama, paramInt, 21);
      AppMethodBeat.i(197679);
      AppMethodBeat.o(197679);
    }
    
    public final void O(ArrayList<BaseFinderFeed> paramArrayList)
    {
      AppMethodBeat.i(197678);
      k.h(paramArrayList, "data");
      super.O(paramArrayList);
      paramArrayList = this.quj;
      View localView = y.js((Context)this.imP).inflate(2131494590, null);
      k.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramArrayList.setLoadMoreFooter(localView);
      AppMethodBeat.o(197678);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.p
 * JD-Core Version:    0.7.0.1
 */