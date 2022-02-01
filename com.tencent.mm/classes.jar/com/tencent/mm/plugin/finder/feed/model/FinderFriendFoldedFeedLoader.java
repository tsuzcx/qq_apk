package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.finder.cgi.ak;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "feedId", "", "nonceId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getFinderUserName", "()Ljava/lang/String;", "getNonceId", "setNonceId", "(Ljava/lang/String;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FinderFoldedListResponse", "FoldedDataFetcher", "plugin-finder_release"})
public final class FinderFriendFoldedFeedLoader
  extends BaseFinderFeedLoader
{
  final long duw;
  public d.g.a.b<? super IResponse<am>, z> fetchEndCallback;
  String rPZ;
  final String sjZ;
  
  public FinderFriendFoldedFeedLoader(String paramString1, long paramLong, String paramString2, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(202844);
    this.sjZ = paramString1;
    this.duw = paramLong;
    this.rPZ = paramString2;
    AppMethodBeat.o(202844);
  }
  
  public final g<am> createDataFetch()
  {
    AppMethodBeat.i(202841);
    g localg = (g)new b();
    AppMethodBeat.o(202841);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<am> createDataMerger()
  {
    AppMethodBeat.i(202842);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new c(this);
    AppMethodBeat.o(202842);
    return localb;
  }
  
  public final void onFetchDone(IResponse<am> paramIResponse)
  {
    AppMethodBeat.i(202843);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(202843);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      d.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(202843);
        return;
      }
    }
    AppMethodBeat.o(202843);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class a
    extends IResponse<am>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FoldedDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene1", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFoldedList;", "genRefreshNetScene", "getCmdId", "plugin-finder_release"})
  public final class b
    extends a
  {
    public final IResponse<am> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202838);
      p.h(paramn, "scene1");
      paramn = (ak)paramn;
      Object localObject1;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = paramn.rr.aEV();
        if (localObject1 == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
          AppMethodBeat.o(202838);
          throw paramString;
        }
        if (((aoe)localObject1).continueFlag != 0) {}
      }
      for (boolean bool = false;; bool = true)
      {
        localObject1 = new FinderFriendFoldedFeedLoader.a(paramInt1, paramInt2, paramString);
        localObject2 = (Iterable)paramn.czL();
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FinderObject)((Iterator)localObject2).next();
          Object localObject4 = FinderItem.sJb;
          localObject3 = FinderItem.a.a((FinderObject)localObject3, 256);
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
          paramString.add(b.a.j((FinderItem)localObject3));
        }
      }
      ((FinderFriendFoldedFeedLoader.a)localObject1).setIncrementList((List)paramString);
      paramString = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
      b.a.a((List)paramn.czL(), 1, this.skk.getContextObj(), 4);
      Object localObject2 = getTAG();
      Object localObject3 = new StringBuilder("incrementList size: ");
      paramString = ((FinderFriendFoldedFeedLoader.a)localObject1).getIncrementList();
      if (paramString != null) {}
      for (paramString = Integer.valueOf(paramString.size());; paramString = null)
      {
        ae.i((String)localObject2, paramString);
        ((FinderFriendFoldedFeedLoader.a)localObject1).setPullType(paramn.pullType);
        paramString = paramn.rr.aEV();
        if (paramString != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
        AppMethodBeat.o(202838);
        throw paramString;
      }
      ((FinderFriendFoldedFeedLoader.a)localObject1).setLastBuffer(((aoe)paramString).lastBuffer);
      ((FinderFriendFoldedFeedLoader.a)localObject1).setHasMore(bool);
      paramString = (IResponse)localObject1;
      AppMethodBeat.o(202838);
      return paramString;
    }
    
    public final int getCmdId()
    {
      return 3904;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "request", "", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<am>.a
  {
    c()
    {
      super();
    }
    
    public final int findMergeIndex(ArrayList<am> paramArrayList, List<? extends am> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(202840);
      p.h(paramArrayList, "srcList");
      p.h(paramList, "newList");
      paramInt = this.skk.getDataList().size();
      AppMethodBeat.o(202840);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFriendFoldedFeedLoader
 * JD-Core Version:    0.7.0.1
 */