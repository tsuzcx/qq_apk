package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.plugin.finder.cgi.ci;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "feedId", "", "nonceId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getFinderUserName", "()Ljava/lang/String;", "getNonceId", "setNonceId", "(Ljava/lang/String;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FinderFoldedListResponse", "FoldedDataFetcher", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFriendFoldedFeedLoader
  extends BaseFinderFeedLoader
{
  final long feedId;
  public b<? super IResponse<cc>, ah> fetchEndCallback;
  String nonceId;
  final String zDJ;
  
  public FinderFriendFoldedFeedLoader(String paramString1, long paramLong, String paramString2, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(366353);
    this.zDJ = paramString1;
    this.feedId = paramLong;
    this.nonceId = paramString2;
    AppMethodBeat.o(366353);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(366359);
    i locali = (i)new b();
    AppMethodBeat.o(366359);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(366367);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new c(this);
    AppMethodBeat.o(366367);
    return locald;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366375);
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(366375);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      b localb = this.fetchEndCallback;
      if (localb != null) {
        localb.invoke(paramIResponse);
      }
    }
    AppMethodBeat.o(366375);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends IResponse<cc>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FoldedDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene1", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFoldedList;", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public b()
    {
      AppMethodBeat.i(365825);
      AppMethodBeat.o(365825);
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(365847);
      s.u(paramp, "scene1");
      paramp = (ci)paramp;
      Object localObject1;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = c.c.b(paramp.rr.otC);
        if (localObject1 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
          AppMethodBeat.o(365847);
          throw paramString;
        }
        if (((ayx)localObject1).continueFlag != 0) {}
      }
      for (boolean bool = false;; bool = true)
      {
        localObject1 = new FinderFriendFoldedFeedLoader.a(paramInt1, paramInt2, paramString);
        localObject2 = (Iterable)paramp.dVQ();
        paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (FinderObject)((Iterator)localObject2).next();
          Object localObject4 = FinderItem.Companion;
          localObject3 = FinderItem.a.e((FinderObject)localObject3, 256);
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          paramString.add(d.a.a((FinderItem)localObject3));
        }
      }
      ((FinderFriendFoldedFeedLoader.a)localObject1).setIncrementList((List)paramString);
      paramString = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      d.a.a((List)paramp.dVQ(), 1, this.Bgt.getContextObj());
      Object localObject2 = getTAG();
      paramString = ((FinderFriendFoldedFeedLoader.a)localObject1).getIncrementList();
      if (paramString == null) {}
      for (paramString = null;; paramString = Integer.valueOf(paramString.size()))
      {
        Log.i((String)localObject2, s.X("incrementList size: ", paramString));
        ((FinderFriendFoldedFeedLoader.a)localObject1).setPullType(paramp.pullType);
        paramString = c.c.b(paramp.rr.otC);
        if (paramString != null) {
          break;
        }
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
        AppMethodBeat.o(365847);
        throw paramString;
      }
      ((FinderFriendFoldedFeedLoader.a)localObject1).setLastBuffer(((ayx)paramString).lastBuffer);
      ((FinderFriendFoldedFeedLoader.a)localObject1).setHasMore(bool);
      paramString = (IResponse)localObject1;
      AppMethodBeat.o(365847);
      return paramString;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(365831);
      List localList = kotlin.a.p.listOf(Integer.valueOf(3904));
      AppMethodBeat.o(365831);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "request", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends BaseFeedLoader<cc>.a
  {
    c(FinderFriendFoldedFeedLoader paramFinderFriendFoldedFeedLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(365822);
      AppMethodBeat.o(365822);
    }
    
    public final int findMergeIndex(ArrayList<cc> paramArrayList, List<? extends cc> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(365837);
      s.u(paramArrayList, "srcList");
      s.u(paramList, "newList");
      paramInt = this.Bgt.getDataList().size();
      AppMethodBeat.o(365837);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFriendFoldedFeedLoader
 * JD-Core Version:    0.7.0.1
 */