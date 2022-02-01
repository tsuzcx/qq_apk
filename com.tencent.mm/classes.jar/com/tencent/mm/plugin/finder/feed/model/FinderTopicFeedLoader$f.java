package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeLoadMore", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeRefresh", "plugin-finder_release"})
public final class FinderTopicFeedLoader$f
  extends BaseFeedLoader<am>.a
{
  FinderTopicFeedLoader$f()
  {
    super(localBaseFeedLoader);
  }
  
  public final void mergeLoadMore(final IResponse<am> paramIResponse, final b<? super IResponse<am>, z> paramb)
  {
    int i = 1;
    AppMethodBeat.i(202972);
    p.h(paramIResponse, "response");
    Object localObject = RefreshLoadMoreLayout.c.LOa;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fUy());
    List localList = paramIResponse.getIncrementList();
    boolean bool;
    if (localList != null)
    {
      bool = localList.isEmpty();
      ((RefreshLoadMoreLayout.c)localObject).iOP = bool;
      ((RefreshLoadMoreLayout.c)localObject).LNT = paramIResponse.getHasMore();
      ((RefreshLoadMoreLayout.c)localObject).skU = paramIResponse;
      if (!paramIResponse.getHasMore()) {
        break label124;
      }
    }
    for (;;)
    {
      c.h((a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
      AppMethodBeat.o(202972);
      return;
      bool = true;
      break;
      label124:
      i = 5;
    }
  }
  
  public final void mergeRefresh(final IResponse<am> paramIResponse, final b<? super IResponse<am>, z> paramb)
  {
    int j = 3;
    AppMethodBeat.i(202971);
    p.h(paramIResponse, "response");
    final RefreshLoadMoreLayout.c localc;
    if (paramIResponse.getPullType() == 1)
    {
      i = 3;
      localc = new RefreshLoadMoreLayout.c(i);
      if (paramIResponse.getPullType() != 1) {
        break label99;
      }
    }
    label99:
    for (int i = j;; i = 4)
    {
      final com.tencent.mm.plugin.finder.feed.model.internal.l locall = new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), false, 12);
      localc.skU = paramIResponse;
      c.h((a)new b(this, locall, localc, paramb, paramIResponse));
      AppMethodBeat.o(202971);
      return;
      i = 4;
      break;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<z>
  {
    a(FinderTopicFeedLoader.f paramf, com.tencent.mm.plugin.finder.feed.model.internal.l paraml, RefreshLoadMoreLayout.c paramc, b paramb, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<z>
  {
    b(FinderTopicFeedLoader.f paramf, com.tencent.mm.plugin.finder.feed.model.internal.l paraml, RefreshLoadMoreLayout.c paramc, b paramb, IResponse paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader.f
 * JD-Core Version:    0.7.0.1
 */