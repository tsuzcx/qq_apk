package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "feedId", "", "nonceId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getFinderUserName", "()Ljava/lang/String;", "getNonceId", "setNonceId", "(Ljava/lang/String;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FinderFoldedListResponse", "FoldedDataFetcher", "plugin-finder_release"})
public final class FinderFriendFoldedFeedLoader
  extends BaseFinderFeedLoader
{
  final long feedId;
  public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
  String hwg;
  final String sBN;
  
  public FinderFriendFoldedFeedLoader(String paramString1, long paramLong, String paramString2, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(244638);
    this.sBN = paramString1;
    this.feedId = paramLong;
    this.hwg = paramString2;
    AppMethodBeat.o(244638);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(244635);
    g localg = (g)new b();
    AppMethodBeat.o(244635);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(244636);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new c(this);
    AppMethodBeat.o(244636);
    return localb;
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244637);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(244637);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      kotlin.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(244637);
        return;
      }
    }
    AppMethodBeat.o(244637);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class a
    extends IResponse<bo>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FoldedDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene1", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFoldedList;", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends a
  {
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(244632);
      p.h(paramq, "scene1");
      paramq = (bi)paramq;
      Object localObject1;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = paramq.rr.aYK();
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
          AppMethodBeat.o(244632);
          throw paramString;
        }
        if (((ase)localObject1).continueFlag != 0) {}
      }
      for (boolean bool = false;; bool = true)
      {
        localObject1 = new FinderFriendFoldedFeedLoader.a(paramInt1, paramInt2, paramString);
        localObject2 = (Iterable)paramq.cYs();
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FinderObject)((Iterator)localObject2).next();
          Object localObject4 = FinderItem.Companion;
          localObject3 = FinderItem.a.a((FinderObject)localObject3, 256);
          localObject4 = c.vGN;
          paramString.add(c.a.s((FinderItem)localObject3));
        }
      }
      ((FinderFriendFoldedFeedLoader.a)localObject1).setIncrementList((List)paramString);
      paramString = c.vGN;
      c.a.a((List)paramq.cYs(), 1, this.tVy.getContextObj());
      Object localObject2 = getTAG();
      Object localObject3 = new StringBuilder("incrementList size: ");
      paramString = ((FinderFriendFoldedFeedLoader.a)localObject1).getIncrementList();
      if (paramString != null) {}
      for (paramString = Integer.valueOf(paramString.size());; paramString = null)
      {
        Log.i((String)localObject2, paramString);
        ((FinderFriendFoldedFeedLoader.a)localObject1).setPullType(paramq.pullType);
        paramString = paramq.rr.aYK();
        if (paramString != null) {
          break;
        }
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
        AppMethodBeat.o(244632);
        throw paramString;
      }
      ((FinderFriendFoldedFeedLoader.a)localObject1).setLastBuffer(((ase)paramString).lastBuffer);
      ((FinderFriendFoldedFeedLoader.a)localObject1).setHasMore(bool);
      paramString = (IResponse)localObject1;
      AppMethodBeat.o(244632);
      return paramString;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(244629);
      List localList = j.listOf(Integer.valueOf(3904));
      AppMethodBeat.o(244629);
      return localList;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "request", "", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<bo>.a
  {
    c()
    {
      super();
    }
    
    public final int findMergeIndex(ArrayList<bo> paramArrayList, List<? extends bo> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(244634);
      p.h(paramArrayList, "srcList");
      p.h(paramList, "newList");
      paramInt = this.tVy.getDataList().size();
      AppMethodBeat.o(244634);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFriendFoldedFeedLoader
 * JD-Core Version:    0.7.0.1
 */