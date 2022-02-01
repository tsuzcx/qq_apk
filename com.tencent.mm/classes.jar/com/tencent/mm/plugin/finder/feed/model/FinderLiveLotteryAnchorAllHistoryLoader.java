package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.live.model.cgi.aq;
import com.tencent.mm.plugin.finder.model.ar;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.azq;
import com.tencent.mm.protocal.protobuf.bam;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "Companion", "LotteryAllHistoryFetcher", "LotteryAllHistoryResponse", "plugin-finder_release"})
public final class FinderLiveLotteryAnchorAllHistoryLoader
  extends BaseFeedLoader<bu>
{
  public static final a xHO;
  public kotlin.g.a.b<? super IResponse<bu>, x> fetchEndCallback;
  private boolean hasMore;
  
  static
  {
    AppMethodBeat.i(279612);
    xHO = new a((byte)0);
    AppMethodBeat.o(279612);
  }
  
  public FinderLiveLotteryAnchorAllHistoryLoader()
  {
    super(null);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(279610);
    i locali = (i)new b();
    AppMethodBeat.o(279610);
    return locali;
  }
  
  public final void onFetchDone(final IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(279611);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aFi());
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(279611);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(279611);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader$LotteryAllHistoryFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends c
  {
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(279217);
      p.k(paramq, "scene");
      Log.i(getTAG(), "onSceneEnd: errType " + paramInt1 + ", errCode " + paramInt2 + " errMsg " + paramString);
      paramString = new FinderLiveLotteryAnchorAllHistoryLoader.c(paramInt1, paramInt2, paramString);
      if (((paramq instanceof aq)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject1 = ((aq)paramq).rr.bhY();
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
          AppMethodBeat.o(279217);
          throw paramString;
        }
        paramString.setLastBuffer(((azq)localObject1).lastBuffer);
        localObject1 = ((aq)paramq).rr.bhY();
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
          AppMethodBeat.o(279217);
          throw paramString;
        }
        if (((azq)localObject1).continueFlag == 1) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.setHasMore(bool);
          Object localObject2 = (Iterable)((aq)paramq).dAb();
          localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            bam localbam = (bam)((Iterator)localObject2).next();
            p.j(localbam, "it");
            ((Collection)localObject1).add(new ar(localbam));
          }
        }
        paramString.setIncrementList((List)localObject1);
        paramString.setPullType(((aq)paramq).pullType);
      }
      paramString = (IResponse)paramString;
      AppMethodBeat.o(279217);
      return paramString;
    }
    
    public final com.tencent.mm.an.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(279216);
      Object localObject = new aq(1, 0L, 0L, "", this.xHP.getLastBuffer());
      ((aq)localObject).pullType = 2;
      localObject = (com.tencent.mm.an.q)localObject;
      AppMethodBeat.o(279216);
      return localObject;
    }
    
    public final com.tencent.mm.an.q genRefreshNetScene()
    {
      AppMethodBeat.i(279215);
      Object localObject = new aq(1, 0L, 0L, "", this.xHP.getLastBuffer());
      ((aq)localObject).pullType = 0;
      localObject = (com.tencent.mm.an.q)localObject;
      AppMethodBeat.o(279215);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(279214);
      List localList = j.listOf(Integer.valueOf(6484));
      AppMethodBeat.o(279214);
      return localList;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader$LotteryAllHistoryResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<bu>
  {
    public c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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