package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.g.c;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.a.b;
import d.g.b.k;
import d.v;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedId", "", "username", "", "cacheId", "initPos", "", "scene", "(Lcom/tencent/mm/ui/MMActivity;JLjava/lang/String;JII)V", "getCacheId", "()J", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getFeedId", "getInitPos", "()I", "getScene", "getUsername", "()Ljava/lang/String;", "getInitRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class k$a
  extends r.a
{
  private final long dig;
  private final com.tencent.mm.plugin.finder.feed.model.c rfE;
  private final long rhr;
  final int rht;
  private final int scene;
  private final String username;
  
  public k$a(MMActivity paramMMActivity, long paramLong1, String paramString, long paramLong2, int paramInt1, int paramInt2)
  {
    super(paramMMActivity);
    AppMethodBeat.i(201625);
    this.dig = paramLong1;
    this.username = paramString;
    this.rhr = paramLong2;
    this.rht = paramInt1;
    this.scene = paramInt2;
    this.rfE = new com.tencent.mm.plugin.finder.feed.model.c(paramMMActivity);
    AppMethodBeat.o(201625);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, r.b paramb)
  {
    AppMethodBeat.i(201623);
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
        paramBaseFinderFeedLoader.a((d)this.rfE);
        AppMethodBeat.o(201623);
        return;
      }
    }
    AppMethodBeat.o(201623);
  }
  
  public final void aQh()
  {
    AppMethodBeat.i(201622);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rgh;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(201622);
      return;
    }
    AppMethodBeat.o(201622);
  }
  
  public final g cup()
  {
    AppMethodBeat.i(201620);
    g localg = (g)new g.c(this.rhr, (f)new a(this));
    AppMethodBeat.o(201620);
    return localg;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201624);
    this.rfE.onDetach();
    Object localObject = FinderReporterUIC.seQ;
    localObject = FinderReporterUIC.a.eV((Context)this.iMV);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((d)this.rfE);
      }
    }
    super.onDetach();
    AppMethodBeat.o(201624);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(201621);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rgh;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(201621);
      return;
    }
    AppMethodBeat.o(201621);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$Presenter$getInitRequest$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements f
  {
    public final void call(int paramInt)
    {
      AppMethodBeat.i(201618);
      Object localObject = this.rhL.rfN;
      if (localObject != null)
      {
        localObject = ((b.b)localObject).rfT.getRecyclerView();
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getLayoutManager();
          if (localObject != null)
          {
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager");
              AppMethodBeat.o(201618);
              throw ((Throwable)localObject);
            }
            ((FinderLayoutManager)localObject).af(this.rhL.rht, 0);
            AppMethodBeat.o(201618);
            return;
          }
        }
      }
      AppMethodBeat.o(201618);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<Integer, BaseFinderFeed>
  {
    b(k.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.k.a
 * JD-Core Version:    0.7.0.1
 */