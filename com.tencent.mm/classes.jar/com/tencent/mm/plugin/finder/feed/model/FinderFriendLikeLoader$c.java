package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
public final class FinderFriendLikeLoader$c
  extends BaseFeedLoader<am>.a
{
  FinderFriendLikeLoader$c()
  {
    super(localBaseFeedLoader);
  }
  
  public final void mergeRefresh(final IResponse<am> paramIResponse, final b<? super IResponse<am>, z> paramb)
  {
    AppMethodBeat.i(202850);
    p.h(paramIResponse, "response");
    final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
    Context localContext;
    boolean bool;
    if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
    {
      localContext = ak.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      localc.LNS = ((CharSequence)localContext.getResources().getString(2131759373));
      localc.LNR = 1;
      if (paramIResponse.getPullType() == 0) {
        break label241;
      }
      bool = true;
      label84:
      localc.iOP = bool;
      localc.LNT = paramIResponse.getHasMore();
      if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.LNU > 0)) {
        localc.LNS = null;
      }
      ae.i(this.skl.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
      if (!paramIResponse.getHasMore()) {
        break label247;
      }
    }
    label241:
    label247:
    for (int i = 4;; i = 6)
    {
      c.h((a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
      AppMethodBeat.o(202850);
      return;
      localContext = ak.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      localc.LNS = ((CharSequence)localContext.getResources().getString(2131759383));
      localc.LNR = -1;
      break;
      bool = false;
      break label84;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<z>
  {
    a(FinderFriendLikeLoader.c paramc, com.tencent.mm.plugin.finder.feed.model.internal.l paraml, RefreshLoadMoreLayout.c paramc1, b paramb, IResponse paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFriendLikeLoader.c
 * JD-Core Version:    0.7.0.1
 */