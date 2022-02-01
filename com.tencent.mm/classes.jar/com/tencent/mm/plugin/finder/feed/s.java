package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.e;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.v.c;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class s
{
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedId", "", "username", "", "cacheId", "initPos", "", "scene", "(Lcom/tencent/mm/ui/MMActivity;JLjava/lang/String;JII)V", "getCacheId", "()J", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getFeedId", "getInitPos", "()I", "getScene", "getUsername", "()Ljava/lang/String;", "getInitRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
  public static final class a
    extends e.a
  {
    private final long feedId;
    final int qvB;
    private final e qvy;
    private final long qxT;
    private final int scene;
    private final String username;
    
    public a(MMActivity paramMMActivity, long paramLong1, String paramString, long paramLong2, int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(197728);
      this.feedId = paramLong1;
      this.username = paramString;
      this.qxT = paramLong2;
      this.qvB = paramInt1;
      this.scene = paramInt2;
      this.qvy = new e(paramMMActivity);
      AppMethodBeat.o(197728);
    }
    
    public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, e.b paramb)
    {
      AppMethodBeat.i(197726);
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
          AppMethodBeat.o(197726);
          return;
        }
      }
      AppMethodBeat.o(197726);
    }
    
    public final void aJq()
    {
      AppMethodBeat.i(197725);
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestLoadMore();
        AppMethodBeat.o(197725);
        return;
      }
      AppMethodBeat.o(197725);
    }
    
    public final h clZ()
    {
      AppMethodBeat.i(197723);
      h localh = (h)new v.c(this.qxT, (g)new a(this));
      AppMethodBeat.o(197723);
      return localh;
    }
    
    public final void onDetach()
    {
      AppMethodBeat.i(197727);
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
      AppMethodBeat.o(197727);
    }
    
    public final void requestRefresh()
    {
      AppMethodBeat.i(197724);
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestRefresh();
        AppMethodBeat.o(197724);
        return;
      }
      AppMethodBeat.o(197724);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$Presenter$getInitRequest$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class a
      implements g
    {
      public final void call(int paramInt)
      {
        AppMethodBeat.i(197721);
        Object localObject = this.KNt.qtZ;
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
                AppMethodBeat.o(197721);
                throw ((Throwable)localObject);
              }
              ((FinderLayoutManager)localObject).af(this.KNt.qvB, 0);
              AppMethodBeat.o(197721);
              return;
            }
          }
        }
        AppMethodBeat.o(197721);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements b<Integer, BaseFinderFeed>
    {
      b(s.a parama)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
  public static final class b
    extends e.b
  {
    public b(MMActivity paramMMActivity, s.a parama, int paramInt)
    {
      super((e.a)parama, paramInt, 14);
      AppMethodBeat.i(197730);
      AppMethodBeat.o(197730);
    }
    
    public final void O(ArrayList<BaseFinderFeed> paramArrayList)
    {
      AppMethodBeat.i(197729);
      k.h(paramArrayList, "data");
      super.O(paramArrayList);
      paramArrayList = this.quj;
      View localView = y.js((Context)this.imP).inflate(2131494590, null);
      k.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramArrayList.setLoadMoreFooter(localView);
      AppMethodBeat.o(197729);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.s
 * JD-Core Version:    0.7.0.1
 */