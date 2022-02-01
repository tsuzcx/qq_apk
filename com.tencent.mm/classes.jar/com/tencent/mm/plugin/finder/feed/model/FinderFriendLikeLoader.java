package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getTargetUsername", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FriendLikeDataFetcher", "LikedTimelineResponse", "plugin-finder_release"})
public final class FinderFriendLikeLoader
  extends BaseFinderFeedLoader
{
  public d.g.a.b<? super IResponse<al>, z> fetchEndCallback;
  private boolean hasMore;
  final String rJp;
  
  public FinderFriendLikeLoader(String paramString, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(202378);
    this.rJp = paramString;
    AppMethodBeat.o(202378);
  }
  
  public final g<al> createDataFetch()
  {
    AppMethodBeat.i(202375);
    g localg = (g)new a();
    AppMethodBeat.o(202375);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<al> createDataMerger()
  {
    AppMethodBeat.i(202376);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new c(this);
    AppMethodBeat.o(202376);
    return localb;
  }
  
  public final void onFetchDone(IResponse<al> paramIResponse)
  {
    AppMethodBeat.i(202377);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(202377);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    if (!paramIResponse.getHasMore())
    {
      d.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(202377);
        return;
      }
    }
    AppMethodBeat.o(202377);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$FriendLikeDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimelineResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "genRefreshNetScene", "getCmdId", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<al> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202371);
      p.h(paramn, "scene");
      paramn = (am)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn.cyq() != 1)) {}
      FinderFriendLikeLoader.b localb;
      for (boolean bool = false;; bool = true)
      {
        localb = new FinderFriendLikeLoader.b(paramInt1, paramInt2, paramString);
        paramString = paramn.rJo;
        if (paramString == null) {
          break label193;
        }
        Object localObject = (Iterable)paramString;
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
          b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
          paramString.add(b.a.j(localFinderItem));
        }
      }
      label193:
      for (paramString = (List)paramString;; paramString = null)
      {
        localb.setIncrementList(paramString);
        localb.setPullType(paramn.pullType);
        localb.setLastBuffer(paramn.cyp());
        localb.setHasMore(bool);
        paramString = (IResponse)localb;
        AppMethodBeat.o(202371);
        return paramString;
      }
    }
    
    public final int getCmdId()
    {
      return 3965;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<al>
  {
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<al>.a
  {
    c()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<al> paramIResponse, final d.g.a.b<? super IResponse<al>, z> paramb)
    {
      AppMethodBeat.i(202374);
      p.h(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      Context localContext;
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        localContext = aj.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        localc.Lrh = ((CharSequence)localContext.getResources().getString(2131759373));
        localc.Lrg = 1;
        if (paramIResponse.getPullType() == 0) {
          break label241;
        }
        bool = true;
        label84:
        localc.iLW = bool;
        localc.Lri = paramIResponse.getHasMore();
        if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.Lrj > 0)) {
          localc.Lrh = null;
        }
        ad.i(this.sbu.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        if (!paramIResponse.getHasMore()) {
          break label247;
        }
      }
      label241:
      label247:
      for (int i = 4;; i = 6)
      {
        c.g((d.g.a.a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(202374);
        return;
        localContext = aj.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        localc.Lrh = ((CharSequence)localContext.getResources().getString(2131759383));
        localc.Lrg = -1;
        break;
        bool = false;
        break label84;
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(FinderFriendLikeLoader.c paramc, com.tencent.mm.plugin.finder.feed.model.internal.l paraml, RefreshLoadMoreLayout.c paramc1, d.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFriendLikeLoader
 * JD-Core Version:    0.7.0.1
 */