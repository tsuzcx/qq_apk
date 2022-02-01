package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.finder.cgi.aj;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "feedId", "", "nonceId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getFinderUserName", "()Ljava/lang/String;", "getNonceId", "setNonceId", "(Ljava/lang/String;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FinderFoldedListResponse", "FoldedDataFetcher", "plugin-finder_release"})
public final class FinderFriendFoldedFeedLoader
  extends BaseFinderFeedLoader
{
  final long dtq;
  public d.g.a.b<? super IResponse<al>, z> fetchEndCallback;
  String rHO;
  final String sbk;
  
  public FinderFriendFoldedFeedLoader(String paramString1, long paramLong, String paramString2, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(202368);
    this.sbk = paramString1;
    this.dtq = paramLong;
    this.rHO = paramString2;
    AppMethodBeat.o(202368);
  }
  
  public final g<al> createDataFetch()
  {
    AppMethodBeat.i(202365);
    g localg = (g)new b();
    AppMethodBeat.o(202365);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<al> createDataMerger()
  {
    AppMethodBeat.i(202366);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new c(this);
    AppMethodBeat.o(202366);
    return localb;
  }
  
  public final void onFetchDone(IResponse<al> paramIResponse)
  {
    AppMethodBeat.i(202367);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(202367);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      d.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(202367);
        return;
      }
    }
    AppMethodBeat.o(202367);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class a
    extends IResponse<al>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FoldedDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene1", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFoldedList;", "genRefreshNetScene", "getCmdId", "plugin-finder_release"})
  public final class b
    extends a
  {
    public final IResponse<al> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202362);
      p.h(paramn, "scene1");
      paramn = (aj)paramn;
      Object localObject1;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = paramn.rr.aEF();
        if (localObject1 == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
          AppMethodBeat.o(202362);
          throw paramString;
        }
        if (((anr)localObject1).continueFlag != 0) {}
      }
      for (boolean bool = false;; bool = true)
      {
        localObject1 = new FinderFriendFoldedFeedLoader.a(paramInt1, paramInt2, paramString);
        localObject2 = (Iterable)paramn.cyk();
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FinderObject)((Iterator)localObject2).next();
          Object localObject4 = FinderItem.syk;
          localObject3 = FinderItem.a.a((FinderObject)localObject3, 256);
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
          paramString.add(b.a.j((FinderItem)localObject3));
        }
      }
      ((FinderFriendFoldedFeedLoader.a)localObject1).setIncrementList((List)paramString);
      paramString = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
      b.a.a((List)paramn.cyk(), 1, this.sbt.getContextObj(), 4);
      Object localObject2 = getTAG();
      Object localObject3 = new StringBuilder("incrementList size: ");
      paramString = ((FinderFriendFoldedFeedLoader.a)localObject1).getIncrementList();
      if (paramString != null) {}
      for (paramString = Integer.valueOf(paramString.size());; paramString = null)
      {
        ad.i((String)localObject2, paramString);
        ((FinderFriendFoldedFeedLoader.a)localObject1).setPullType(paramn.pullType);
        paramString = paramn.rr.aEF();
        if (paramString != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
        AppMethodBeat.o(202362);
        throw paramString;
      }
      ((FinderFriendFoldedFeedLoader.a)localObject1).setLastBuffer(((anr)paramString).lastBuffer);
      ((FinderFriendFoldedFeedLoader.a)localObject1).setHasMore(bool);
      paramString = (IResponse)localObject1;
      AppMethodBeat.o(202362);
      return paramString;
    }
    
    public final int getCmdId()
    {
      return 3904;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "request", "", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<al>.a
  {
    c()
    {
      super();
    }
    
    public final int findMergeIndex(ArrayList<al> paramArrayList, List<? extends al> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(202364);
      p.h(paramArrayList, "srcList");
      p.h(paramList, "newList");
      paramInt = this.sbt.getDataList().size();
      AppMethodBeat.o(202364);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFriendFoldedFeedLoader
 * JD-Core Version:    0.7.0.1
 */