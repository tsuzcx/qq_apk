package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.finder.cgi.an;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.arn;
import d.a.j;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getTargetUsername", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FriendLikeDataFetcher", "LikedTimelineResponse", "plugin-finder_release"})
public final class FinderFriendLikeLoader
  extends BaseFinderFeedLoader
{
  public d.g.a.b<? super IResponse<am>, z> fetchEndCallback;
  private boolean hasMore;
  final String rRD;
  
  public FinderFriendLikeLoader(String paramString, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(202854);
    this.rRD = paramString;
    AppMethodBeat.o(202854);
  }
  
  public final g<am> createDataFetch()
  {
    AppMethodBeat.i(202851);
    g localg = (g)new a();
    AppMethodBeat.o(202851);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<am> createDataMerger()
  {
    AppMethodBeat.i(202852);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new FinderFriendLikeLoader.c(this);
    AppMethodBeat.o(202852);
    return localb;
  }
  
  public final void onFetchDone(IResponse<am> paramIResponse)
  {
    AppMethodBeat.i(202853);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(202853);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    if (!paramIResponse.getHasMore())
    {
      d.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(202853);
        return;
      }
    }
    AppMethodBeat.o(202853);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$FriendLikeDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimelineResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "genRefreshNetScene", "getCmdId", "plugin-finder_release"})
  public final class a
    extends a
  {
    public final IResponse<am> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202847);
      p.h(paramn, "scene");
      paramn = (an)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn.czR() != 1)) {}
      FinderFriendLikeLoader.b localb;
      for (boolean bool = false;; bool = true)
      {
        localb = new FinderFriendLikeLoader.b(paramInt1, paramInt2, paramString);
        paramString = paramn.rRC;
        if (paramString == null) {
          break label193;
        }
        Object localObject = (Iterable)paramString;
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
          b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
          paramString.add(b.a.j(localFinderItem));
        }
      }
      label193:
      for (paramString = (List)paramString;; paramString = null)
      {
        localb.setIncrementList(paramString);
        localb.setPullType(paramn.pullType);
        localb.setLastBuffer(paramn.czQ());
        localb.setHasMore(bool);
        paramString = (IResponse)localb;
        AppMethodBeat.o(202847);
        return paramString;
      }
    }
    
    public final int getCmdId()
    {
      return 3965;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<am>
  {
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFriendLikeLoader
 * JD-Core Version:    0.7.0.1
 */