package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.live.model.cgi.ab;
import com.tencent.mm.plugin.finder.model.an;
import com.tencent.mm.plugin.finder.model.ao;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.avw;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.protocal.protobuf.axv;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "scene", "", "liveId", "", "objectId", "objectNonceId", "", "(IJJLjava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getLiveId", "()J", "getObjectId", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "Companion", "LotteryHistoryFetcher", "LotteryHistoryResponse", "plugin-finder_release"})
public final class FinderLiveLotteryHistoryLoader
  extends BaseFeedLoader<bo>
{
  public static final a tVY;
  public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
  final long hFK;
  private boolean hasMore;
  final long liveId;
  final String objectNonceId;
  public final int scene;
  
  static
  {
    AppMethodBeat.i(244710);
    tVY = new a((byte)0);
    AppMethodBeat.o(244710);
  }
  
  public FinderLiveLotteryHistoryLoader(int paramInt, long paramLong1, long paramLong2, String paramString)
  {
    super(null);
    AppMethodBeat.i(244709);
    this.scene = paramInt;
    this.liveId = paramLong1;
    this.hFK = paramLong2;
    this.objectNonceId = paramString;
    AppMethodBeat.o(244709);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(244707);
    g localg = (g)new b();
    AppMethodBeat.o(244707);
    return localg;
  }
  
  public final void onFetchDone(final IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244708);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.axR());
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(244708);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new d(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(244708);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader$LotteryHistoryFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(244705);
      p.h(paramq, "scene");
      Log.i(getTAG(), "onSceneEnd: errType " + paramInt1 + ", errCode " + paramInt2 + " errMsg " + paramString);
      Object localObject2 = new FinderLiveLotteryHistoryLoader.c(paramInt1, paramInt2, paramString);
      Object localObject1 = localObject2;
      if ((paramq instanceof ab))
      {
        localObject1 = localObject2;
        if (paramInt1 == 0)
        {
          localObject1 = localObject2;
          label441:
          if (paramInt2 == 0)
          {
            localObject2 = (awj)j.kt((List)((ab)paramq).dgI());
            if (localObject2 != null) {}
            for (localObject1 = new ao(((awj)localObject2).LHd * 1000L, ((awj)localObject2).LHe.size());; localObject1 = null)
            {
              localObject1 = new FinderLiveLotteryHistoryLoader.c(paramInt1, paramInt2, paramString, (ao)localObject1);
              paramString = ((ab)paramq).rr.aYK();
              if (paramString != null) {
                break;
              }
              paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
              AppMethodBeat.o(244705);
              throw paramString;
            }
            paramString = ((avw)paramString).LGr;
            if (paramString != null)
            {
              paramString = paramString.LIc;
              if (paramString != null)
              {
                paramString = (awj)j.kt((List)paramString);
                if (paramString == null) {}
              }
            }
            for (paramString = paramString.LDs;; paramString = null)
            {
              ((FinderLiveLotteryHistoryLoader.c)localObject1).setLastBuffer(paramString);
              paramString = ((ab)paramq).rr.aYK();
              if (paramString != null) {
                break;
              }
              paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
              AppMethodBeat.o(244705);
              throw paramString;
            }
            paramString = ((avw)paramString).LGr;
            if (paramString != null)
            {
              paramString = paramString.LIc;
              if (paramString != null)
              {
                paramString = (awj)j.kt((List)paramString);
                if (paramString != null)
                {
                  paramString = Integer.valueOf(paramString.tUC);
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
              paramString = ((awj)localObject2).LHe;
              if (paramString == null) {
                break label492;
              }
              localObject2 = (Iterable)paramString;
              paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
              localObject2 = ((Iterable)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                awi localawi = (awi)((Iterator)localObject2).next();
                p.g(localawi, "it");
                paramString.add(new an(localawi));
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
        ((FinderLiveLotteryHistoryLoader.c)localObject1).setPullType(((ab)paramq).pullType);
        paramString = (IResponse)localObject1;
        AppMethodBeat.o(244705);
        return paramString;
      }
    }
    
    public final com.tencent.mm.ak.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(244704);
      Object localObject = new ab(this.tVZ.scene, this.tVZ.liveId, this.tVZ.hFK, this.tVZ.objectNonceId, this.tVZ.getLastBuffer());
      ((ab)localObject).pullType = 2;
      localObject = (com.tencent.mm.ak.q)localObject;
      AppMethodBeat.o(244704);
      return localObject;
    }
    
    public final com.tencent.mm.ak.q genRefreshNetScene()
    {
      AppMethodBeat.i(244703);
      Object localObject = new ab(this.tVZ.scene, this.tVZ.liveId, this.tVZ.hFK, this.tVZ.objectNonceId, this.tVZ.getLastBuffer());
      ((ab)localObject).pullType = 0;
      localObject = (com.tencent.mm.ak.q)localObject;
      AppMethodBeat.o(244703);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(244702);
      List localList = j.listOf(Integer.valueOf(6484));
      AppMethodBeat.o(244702);
      return localList;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader$LotteryHistoryResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "header", "Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryHeader;", "(IILjava/lang/String;Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryHeader;)V", "getHeader", "()Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryHeader;", "plugin-finder_release"})
  public static final class c
    extends IResponse<bo>
  {
    public final ao tWa;
    
    public c(int paramInt1, int paramInt2, String paramString, ao paramao)
    {
      super(paramInt2, paramString);
      this.tWa = paramao;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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