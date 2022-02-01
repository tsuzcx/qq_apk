package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.a.j;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.Collection;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
public final class FinderFavFeedLoader$c
  extends BaseFeedLoader<am>.a
{
  FinderFavFeedLoader$c()
  {
    super(localBaseFeedLoader);
  }
  
  public final void mergeRefresh(final IResponse<am> paramIResponse, final b<? super IResponse<am>, z> paramb)
  {
    int i = 0;
    AppMethodBeat.i(202801);
    p.h(paramIResponse, "response");
    final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
    Object localObject;
    boolean bool;
    if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
    {
      localObject = ak.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      localc.LNS = ((CharSequence)((Context)localObject).getResources().getString(2131759373));
      localc.LNR = 1;
      if (paramIResponse.getPullType() == 0) {
        break label291;
      }
      bool = true;
      label86:
      localc.iOP = bool;
      localc.LNT = paramIResponse.getHasMore();
      if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.LNU > 0)) {
        localc.LNS = null;
      }
      localc.hQS = Integer.valueOf(((FinderFavFeedLoader.b)paramIResponse).fVS);
      ae.i(this.skb.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
      localObject = paramIResponse.getIncrementList();
      if (localObject != null) {
        i = ((List)localObject).size();
      }
      if (!paramIResponse.getHasMore()) {
        break label297;
      }
      if (i > this.skb.getDataList().size()) {
        break label372;
      }
      i = 2;
    }
    for (;;)
    {
      c.h((a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
      AppMethodBeat.o(202801);
      return;
      localObject = ak.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      localc.LNS = ((CharSequence)((Context)localObject).getResources().getString(2131759383));
      localc.LNR = -1;
      break;
      label291:
      bool = false;
      break label86;
      label297:
      if ((this.skb.getDataList().size() == 0) || (i == 0) || (this.skb.getDataList().size() <= i))
      {
        localObject = paramIResponse.getIncrementList();
        if ((localObject != null) && (((List)localObject).containsAll((Collection)j.l((Iterable)this.skb.getDataList())) == true))
        {
          i = 6;
          continue;
        }
      }
      label372:
      i = 4;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<z>
  {
    a(FinderFavFeedLoader.c paramc, com.tencent.mm.plugin.finder.feed.model.internal.l paraml, RefreshLoadMoreLayout.c paramc1, b paramb, IResponse paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader.c
 * JD-Core Version:    0.7.0.1
 */