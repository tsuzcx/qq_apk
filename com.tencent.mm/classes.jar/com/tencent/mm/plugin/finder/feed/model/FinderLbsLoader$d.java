package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
public final class FinderLbsLoader$d
  extends BaseFeedLoader<com.tencent.mm.plugin.finder.model.c>.a
{
  FinderLbsLoader$d()
  {
    super(localBaseFeedLoader);
  }
  
  public final void mergeRefresh(final IResponse<com.tencent.mm.plugin.finder.model.c> paramIResponse, final b<? super IResponse<com.tencent.mm.plugin.finder.model.c>, z> paramb)
  {
    AppMethodBeat.i(202865);
    p.h(paramIResponse, "response");
    Object localObject = RefreshLoadMoreLayout.c.LOa;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fUx());
    boolean bool;
    if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
    {
      ((RefreshLoadMoreLayout.c)localObject).LNR = 1;
      if (paramIResponse.getPullType() == 0) {
        break label203;
      }
      bool = true;
      label57:
      ((RefreshLoadMoreLayout.c)localObject).iOP = bool;
      ((RefreshLoadMoreLayout.c)localObject).LNT = paramIResponse.getHasMore();
      if ((((RefreshLoadMoreLayout.c)localObject).actionType == 0) || (((RefreshLoadMoreLayout.c)localObject).actionType == 4) || (((RefreshLoadMoreLayout.c)localObject).actionType == 4)) {
        if ((((RefreshLoadMoreLayout.c)localObject).LNU <= 0) && (this.sko.getDataListJustForAdapter().size() > 0)) {
          break label208;
        }
      }
    }
    Context localContext;
    for (((RefreshLoadMoreLayout.c)localObject).LNS = null;; ((RefreshLoadMoreLayout.c)localObject).LNS = ((CharSequence)localContext.getResources().getString(2131766506)))
    {
      com.tencent.mm.ac.c.h((a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.l(4, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
      AppMethodBeat.o(202865);
      return;
      localContext = ak.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      ((RefreshLoadMoreLayout.c)localObject).LNS = ((CharSequence)localContext.getResources().getString(2131766505));
      ((RefreshLoadMoreLayout.c)localObject).LNR = -1;
      break;
      label203:
      bool = false;
      break label57;
      label208:
      localContext = ak.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<z>
  {
    a(FinderLbsLoader.d paramd, com.tencent.mm.plugin.finder.feed.model.internal.l paraml, RefreshLoadMoreLayout.c paramc, b paramb, IResponse paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader.d
 * JD-Core Version:    0.7.0.1
 */