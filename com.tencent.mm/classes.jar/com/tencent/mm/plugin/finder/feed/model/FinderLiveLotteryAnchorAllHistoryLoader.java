package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.live.model.cgi.ab;
import com.tencent.mm.plugin.finder.model.ap;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.avw;
import com.tencent.mm.protocal.protobuf.awj;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "Companion", "LotteryAllHistoryFetcher", "LotteryAllHistoryResponse", "plugin-finder_release"})
public final class FinderLiveLotteryAnchorAllHistoryLoader
  extends BaseFeedLoader<bo>
{
  public static final a tVW;
  public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
  private boolean hasMore;
  
  static
  {
    AppMethodBeat.i(244701);
    tVW = new a((byte)0);
    AppMethodBeat.o(244701);
  }
  
  public FinderLiveLotteryAnchorAllHistoryLoader()
  {
    super(null);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(244699);
    g localg = (g)new b();
    AppMethodBeat.o(244699);
    return localg;
  }
  
  public final void onFetchDone(final IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244700);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.axR());
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(244700);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new d(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(244700);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader$LotteryAllHistoryFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(244697);
      p.h(paramq, "scene");
      Log.i(getTAG(), "onSceneEnd: errType " + paramInt1 + ", errCode " + paramInt2 + " errMsg " + paramString);
      paramString = new FinderLiveLotteryAnchorAllHistoryLoader.c(paramInt1, paramInt2, paramString);
      if (((paramq instanceof ab)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject1 = ((ab)paramq).rr.aYK();
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
          AppMethodBeat.o(244697);
          throw paramString;
        }
        paramString.setLastBuffer(((avw)localObject1).lastBuffer);
        localObject1 = ((ab)paramq).rr.aYK();
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
          AppMethodBeat.o(244697);
          throw paramString;
        }
        if (((avw)localObject1).continueFlag == 1) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.setHasMore(bool);
          Object localObject2 = (Iterable)((ab)paramq).dgI();
          localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            awj localawj = (awj)((Iterator)localObject2).next();
            p.g(localawj, "it");
            ((Collection)localObject1).add(new ap(localawj));
          }
        }
        paramString.setIncrementList((List)localObject1);
        paramString.setPullType(((ab)paramq).pullType);
      }
      paramString = (IResponse)paramString;
      AppMethodBeat.o(244697);
      return paramString;
    }
    
    public final com.tencent.mm.ak.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(244696);
      Object localObject = new ab(1, 0L, 0L, "", this.tVX.getLastBuffer());
      ((ab)localObject).pullType = 2;
      localObject = (com.tencent.mm.ak.q)localObject;
      AppMethodBeat.o(244696);
      return localObject;
    }
    
    public final com.tencent.mm.ak.q genRefreshNetScene()
    {
      AppMethodBeat.i(244695);
      Object localObject = new ab(1, 0L, 0L, "", this.tVX.getLastBuffer());
      ((ab)localObject).pullType = 0;
      localObject = (com.tencent.mm.ak.q)localObject;
      AppMethodBeat.o(244695);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(244694);
      List localList = j.listOf(Integer.valueOf(6484));
      AppMethodBeat.o(244694);
      return localList;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader$LotteryAllHistoryResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<bo>
  {
    public c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(FinderLiveLotteryAnchorAllHistoryLoader paramFinderLiveLotteryAnchorAllHistoryLoader, IResponse paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryAnchorAllHistoryLoader
 * JD-Core Version:    0.7.0.1
 */