package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.finder.cgi.an;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aok;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "isTimeLine", "", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ZLcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "fetchRefreshCallback", "Lkotlin/Function1;", "", "getFetchRefreshCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchRefreshCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "getScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "totalCount", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onFetchRefreshDone", "LikedDataFetcher", "LikedTimelineResponse", "plugin-finder_release"})
public final class FinderLikedFeedLoader
  extends BaseFinderFeedLoader
{
  public int fVS;
  public boolean hasMore;
  final boolean ivy;
  public d.g.a.a<z> sbQ;
  public d.g.a.b<? super Integer, z> skC;
  private final e skD;
  
  public FinderLikedFeedLoader(boolean paramBoolean, e parame, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(202896);
    this.ivy = paramBoolean;
    this.skD = parame;
    this.hasMore = true;
    AppMethodBeat.o(202896);
  }
  
  public final g<am> createDataFetch()
  {
    AppMethodBeat.i(202893);
    g localg = (g)new a();
    AppMethodBeat.o(202893);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<am> createDataMerger()
  {
    AppMethodBeat.i(202894);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new FinderLikedFeedLoader.c(this);
    AppMethodBeat.o(202894);
    return localb;
  }
  
  public final void onFetchDone(IResponse<am> paramIResponse)
  {
    AppMethodBeat.i(166040);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(166040);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    if (2 == paramIResponse.getPullType()) {}
    for (int i = 1; (i != 0) && (!paramIResponse.getHasMore()); i = 0)
    {
      paramIResponse = this.sbQ;
      if (paramIResponse == null) {
        break;
      }
      paramIResponse.invoke();
      AppMethodBeat.o(166040);
      return;
    }
    AppMethodBeat.o(166040);
  }
  
  public final void onFetchRefreshDone(IResponse<am> paramIResponse)
  {
    AppMethodBeat.i(202895);
    p.h(paramIResponse, "response");
    super.onFetchRefreshDone(paramIResponse);
    if ((paramIResponse instanceof b))
    {
      this.fVS = ((b)paramIResponse).count;
      paramIResponse = this.skC;
      if (paramIResponse != null)
      {
        paramIResponse.invoke(Integer.valueOf(this.fVS));
        AppMethodBeat.o(202895);
        return;
      }
    }
    AppMethodBeat.o(202895);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "getCmdId", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<am> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202889);
      p.h(paramn, "scene");
      paramn = (an)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn.czR() != 1)) {}
      FinderLikedFeedLoader.b localb;
      Object localObject1;
      Object localObject2;
      for (boolean bool = false;; bool = true)
      {
        localb = new FinderLikedFeedLoader.b(paramInt1, paramInt2, paramString);
        paramString = paramn.rRC;
        if (paramString == null) {
          break label229;
        }
        localObject1 = (Iterable)paramString;
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FinderItem)((Iterator)localObject1).next();
          b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
          paramString.add(b.a.j((FinderItem)localObject2));
        }
      }
      label229:
      for (paramString = (List)paramString;; paramString = null)
      {
        localb.setIncrementList(paramString);
        localb.setPullType(paramn.pullType);
        localb.setLastBuffer(paramn.czQ());
        localb.setHasMore(bool);
        paramString = paramn.TAG;
        localObject1 = new StringBuilder("total count = ");
        localObject2 = paramn.rr.aEV();
        if (localObject2 != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(202889);
        throw paramString;
      }
      ae.i(paramString, ((aok)localObject2).fVS);
      paramString = paramn.rr.aEV();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
        AppMethodBeat.o(202889);
        throw paramString;
      }
      localb.count = ((aok)paramString).fVS;
      paramString = (IResponse)localb;
      AppMethodBeat.o(202889);
      return paramString;
    }
    
    public final n genLoadMoreNetScene()
    {
      AppMethodBeat.i(202888);
      Object localObject = (BaseFinderFeed)this.skE.getLastItemOfType(BaseFinderFeed.class);
      if (localObject != null)
      {
        localObject = ((BaseFinderFeed)localObject).feedObject;
        if (localObject != null)
        {
          localObject = ((FinderItem)localObject).getFeedObject();
          if (localObject == null) {}
        }
      }
      for (long l = ((FinderObject)localObject).displayId;; l = 0L)
      {
        localObject = (n)new an(l, this.skE.getLastBuffer(), 2, this.skE.getContextObj());
        AppMethodBeat.o(202888);
        return localObject;
      }
    }
    
    public final int getCmdId()
    {
      return 3965;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "count", "(IILjava/lang/String;I)V", "getCount", "()I", "setCount", "(I)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<am>
  {
    int count = 0;
    
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader
 * JD-Core Version:    0.7.0.1
 */