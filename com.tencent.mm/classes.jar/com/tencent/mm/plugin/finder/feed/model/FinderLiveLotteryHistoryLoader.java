package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.ap;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.azq;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.bam;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "scene", "", "liveId", "", "objectId", "objectNonceId", "", "(IJJLjava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getLiveId", "()J", "getObjectId", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "Companion", "LotteryHistoryFetcher", "LotteryHistoryResponse", "plugin-finder_release"})
public final class FinderLiveLotteryHistoryLoader
  extends BaseFeedLoader<bu>
{
  public static final a xHQ;
  public kotlin.g.a.b<? super IResponse<bu>, x> fetchEndCallback;
  private boolean hasMore;
  final long liveId;
  final String objectNonceId;
  public final int scene;
  final long xbk;
  
  static
  {
    AppMethodBeat.i(273673);
    xHQ = new a((byte)0);
    AppMethodBeat.o(273673);
  }
  
  public FinderLiveLotteryHistoryLoader(int paramInt, long paramLong1, long paramLong2, String paramString)
  {
    super(null);
    AppMethodBeat.i(273672);
    this.scene = paramInt;
    this.liveId = paramLong1;
    this.xbk = paramLong2;
    this.objectNonceId = paramString;
    AppMethodBeat.o(273672);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(273670);
    i locali = (i)new b();
    AppMethodBeat.o(273670);
    return locali;
  }
  
  public final void onFetchDone(final IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(273671);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aFi());
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(273671);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(273671);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader$LotteryHistoryFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends c
  {
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(224896);
      p.k(paramq, "scene");
      Log.i(getTAG(), "onSceneEnd: errType " + paramInt1 + ", errCode " + paramInt2 + " errMsg " + paramString);
      Object localObject2 = new FinderLiveLotteryHistoryLoader.c(paramInt1, paramInt2, paramString);
      Object localObject1 = localObject2;
      if ((paramq instanceof com.tencent.mm.plugin.finder.live.model.cgi.aq))
      {
        localObject1 = localObject2;
        if (paramInt1 == 0)
        {
          localObject1 = localObject2;
          label441:
          if (paramInt2 == 0)
          {
            localObject2 = (bam)j.lp((List)((com.tencent.mm.plugin.finder.live.model.cgi.aq)paramq).dAb());
            if (localObject2 != null) {}
            for (localObject1 = new com.tencent.mm.plugin.finder.model.aq(((bam)localObject2).SMt * 1000L, ((bam)localObject2).SMu.size());; localObject1 = null)
            {
              localObject1 = new FinderLiveLotteryHistoryLoader.c(paramInt1, paramInt2, paramString, (com.tencent.mm.plugin.finder.model.aq)localObject1);
              paramString = ((com.tencent.mm.plugin.finder.live.model.cgi.aq)paramq).rr.bhY();
              if (paramString != null) {
                break;
              }
              paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
              AppMethodBeat.o(224896);
              throw paramString;
            }
            paramString = ((azq)paramString).SLo;
            if (paramString != null)
            {
              paramString = paramString.SOA;
              if (paramString != null)
              {
                paramString = (bam)j.lp((List)paramString);
                if (paramString == null) {}
              }
            }
            for (paramString = paramString.SDI;; paramString = null)
            {
              ((FinderLiveLotteryHistoryLoader.c)localObject1).setLastBuffer(paramString);
              paramString = ((com.tencent.mm.plugin.finder.live.model.cgi.aq)paramq).rr.bhY();
              if (paramString != null) {
                break;
              }
              paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
              AppMethodBeat.o(224896);
              throw paramString;
            }
            paramString = ((azq)paramString).SLo;
            if (paramString != null)
            {
              paramString = paramString.SOA;
              if (paramString != null)
              {
                paramString = (bam)j.lp((List)paramString);
                if (paramString != null)
                {
                  paramString = Integer.valueOf(paramString.xFI);
                  if (paramString != null) {
                    break label441;
                  }
                }
              }
            }
            label330:
            for (boolean bool = false;; bool = true)
            {
              ((FinderLiveLotteryHistoryLoader.c)localObject1).setHasMore(bool);
              if (localObject2 == null) {
                break label492;
              }
              paramString = ((bam)localObject2).SMu;
              if (paramString == null) {
                break label492;
              }
              localObject2 = (Iterable)paramString;
              paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
              localObject2 = ((Iterable)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                bal localbal = (bal)((Iterator)localObject2).next();
                p.j(localbal, "it");
                paramString.add(new ap(localbal));
              }
              paramString = null;
              break;
              if (paramString.intValue() != 1) {
                break label330;
              }
            }
          }
        }
      }
      label492:
      for (paramString = (List)paramString;; paramString = null)
      {
        ((FinderLiveLotteryHistoryLoader.c)localObject1).setIncrementList(paramString);
        ((FinderLiveLotteryHistoryLoader.c)localObject1).setPullType(((com.tencent.mm.plugin.finder.live.model.cgi.aq)paramq).pullType);
        paramString = (IResponse)localObject1;
        AppMethodBeat.o(224896);
        return paramString;
      }
    }
    
    public final com.tencent.mm.an.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(224873);
      Object localObject = new com.tencent.mm.plugin.finder.live.model.cgi.aq(this.xHR.scene, this.xHR.liveId, this.xHR.xbk, this.xHR.objectNonceId, this.xHR.getLastBuffer());
      ((com.tencent.mm.plugin.finder.live.model.cgi.aq)localObject).pullType = 2;
      localObject = (com.tencent.mm.an.q)localObject;
      AppMethodBeat.o(224873);
      return localObject;
    }
    
    public final com.tencent.mm.an.q genRefreshNetScene()
    {
      AppMethodBeat.i(224870);
      Object localObject = new com.tencent.mm.plugin.finder.live.model.cgi.aq(this.xHR.scene, this.xHR.liveId, this.xHR.xbk, this.xHR.objectNonceId, this.xHR.getLastBuffer());
      ((com.tencent.mm.plugin.finder.live.model.cgi.aq)localObject).pullType = 0;
      localObject = (com.tencent.mm.an.q)localObject;
      AppMethodBeat.o(224870);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(224866);
      List localList = j.listOf(Integer.valueOf(6484));
      AppMethodBeat.o(224866);
      return localList;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader$LotteryHistoryResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "header", "Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryHeader;", "(IILjava/lang/String;Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryHeader;)V", "getHeader", "()Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryHeader;", "plugin-finder_release"})
  public static final class c
    extends IResponse<bu>
  {
    public final com.tencent.mm.plugin.finder.model.aq xHS;
    
    public c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.plugin.finder.model.aq paramaq)
    {
      super(paramInt2, paramString);
      this.xHS = paramaq;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(FinderLiveLotteryHistoryLoader paramFinderLiveLotteryHistoryLoader, IResponse paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryHistoryLoader
 * JD-Core Version:    0.7.0.1
 */