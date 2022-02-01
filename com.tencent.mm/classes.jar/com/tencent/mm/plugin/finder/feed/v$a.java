package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.l.a;
import com.tencent.mm.plugin.finder.feed.model.l.a.a;
import com.tencent.mm.plugin.finder.feed.model.l.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.a.b;
import d.g.b.k;
import d.v;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "cacheId", "", "initPos", "", "scene", "(Lcom/tencent/mm/ui/MMActivity;JII)V", "getCacheId", "()J", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getInitPos", "()I", "getScene", "getInitRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class v$a
  extends r.a
{
  private final com.tencent.mm.plugin.finder.feed.model.c rfE;
  final long rhr;
  final int rht;
  private final int scene;
  
  public v$a(MMActivity paramMMActivity, long paramLong, int paramInt1, int paramInt2)
  {
    super(paramMMActivity);
    AppMethodBeat.i(201796);
    this.rhr = paramLong;
    this.rht = paramInt1;
    this.scene = paramInt2;
    this.rfE = new com.tencent.mm.plugin.finder.feed.model.c(paramMMActivity);
    AppMethodBeat.o(201796);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, r.b paramb)
  {
    AppMethodBeat.i(201794);
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
        AppMethodBeat.o(201794);
        return;
      }
    }
    AppMethodBeat.o(201794);
  }
  
  public final void aQh()
  {
    AppMethodBeat.i(201793);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rgh;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(201793);
      return;
    }
    AppMethodBeat.o(201793);
  }
  
  public final g cup()
  {
    AppMethodBeat.i(201792);
    g localg = (g)new l.b(null, this.rhr, (f)new a(this));
    AppMethodBeat.o(201792);
    return localg;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201795);
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
    localObject = com.tencent.mm.plugin.finder.feed.model.l.rng;
    l.a.clearCache();
    super.onDetach();
    AppMethodBeat.o(201795);
  }
  
  public final void requestRefresh() {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$Presenter$getInitRequest$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements f
  {
    public final void call(int paramInt)
    {
      AppMethodBeat.i(201790);
      Object localObject = this.rjy.rfN;
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
              AppMethodBeat.o(201790);
              throw ((Throwable)localObject);
            }
            ((FinderLayoutManager)localObject).af(this.rjy.rht, 0);
          }
        }
      }
      localObject = this.rjy.rgh;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader");
        AppMethodBeat.o(201790);
        throw ((Throwable)localObject);
      }
      localObject = (com.tencent.mm.plugin.finder.feed.model.l)localObject;
      l.a locala = com.tencent.mm.plugin.finder.feed.model.l.rng;
      ((com.tencent.mm.plugin.finder.feed.model.l)localObject).lastBuffer = l.a.uo(this.rjy.rhr).lastBuffer;
      AppMethodBeat.o(201790);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<Integer, BaseFinderFeed>
  {
    b(v.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.v.a
 * JD-Core Version:    0.7.0.1
 */