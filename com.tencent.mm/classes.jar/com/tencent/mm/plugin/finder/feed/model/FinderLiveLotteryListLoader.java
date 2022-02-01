package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.live.model.cgi.aa;
import com.tencent.mm.plugin.finder.model.aq;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awk;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lotteryId", "", "liveId", "", "objectId", "objectNonceId", "(Ljava/lang/String;JJLjava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getLiveId", "()J", "getLotteryId", "()Ljava/lang/String;", "getObjectId", "getObjectNonceId", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "Companion", "LotteryListFetcher", "LotteryWinnerListResponse", "plugin-finder_release"})
public final class FinderLiveLotteryListLoader
  extends BaseFeedLoader<bo>
{
  public static final a tWc;
  public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
  public final long hFK;
  private boolean hasMore;
  final long liveId;
  final String objectNonceId;
  public final String tWb;
  
  static
  {
    AppMethodBeat.i(244719);
    tWc = new a((byte)0);
    AppMethodBeat.o(244719);
  }
  
  public FinderLiveLotteryListLoader(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    super(null);
    AppMethodBeat.i(244718);
    this.tWb = paramString1;
    this.liveId = paramLong1;
    this.hFK = paramLong2;
    this.objectNonceId = paramString2;
    AppMethodBeat.o(244718);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(244716);
    g localg = (g)new b();
    AppMethodBeat.o(244716);
    return localg;
  }
  
  public final void onFetchDone(final IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244717);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.axR());
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(244717);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new d(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(244717);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader$LotteryListFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      boolean bool2 = true;
      AppMethodBeat.i(244714);
      p.h(paramq, "scene");
      Log.i(getTAG(), "onSceneEnd: errType " + paramInt1 + ", errCode " + paramInt2 + " errMsg " + paramString);
      Object localObject2 = new FinderLiveLotteryListLoader.c(paramInt1, paramInt2, paramString);
      Object localObject1 = localObject2;
      if ((paramq instanceof aa))
      {
        localObject1 = localObject2;
        if (paramInt1 == 0)
        {
          localObject1 = localObject2;
          if (paramInt2 == 0)
          {
            localObject1 = ((aa)paramq).rr.aYK();
            if (localObject1 == null)
            {
              paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryRecordResponse");
              AppMethodBeat.o(244714);
              throw paramString;
            }
            localObject1 = ((avy)localObject1).tWe;
            localObject2 = ((aa)paramq).rr.aYK();
            if (localObject2 == null)
            {
              paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryRecordResponse");
              AppMethodBeat.o(244714);
              throw paramString;
            }
            if (((avy)localObject2).LGu == 0) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              localObject1 = new FinderLiveLotteryListLoader.c(paramInt1, paramInt2, paramString, (awi)localObject1, bool1);
              paramString = ((aa)paramq).rr.aYK();
              if (paramString != null) {
                break;
              }
              paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryRecordResponse");
              AppMethodBeat.o(244714);
              throw paramString;
            }
            ((FinderLiveLotteryListLoader.c)localObject1).setLastBuffer(((avy)paramString).lastBuffer);
            paramString = ((aa)paramq).rr.aYK();
            if (paramString == null)
            {
              paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryRecordResponse");
              AppMethodBeat.o(244714);
              throw paramString;
            }
            if (((avy)paramString).continueFlag == 1) {}
            for (bool1 = bool2;; bool1 = false)
            {
              ((FinderLiveLotteryListLoader.c)localObject1).setHasMore(bool1);
              paramString = ((aa)paramq).rr.aYK();
              if (paramString != null) {
                break;
              }
              paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryRecordResponse");
              AppMethodBeat.o(244714);
              throw paramString;
            }
            paramString = ((avy)paramString).LGt;
            if (paramString != null)
            {
              localObject2 = paramString.LHf;
              paramString = (String)localObject2;
              if (localObject2 != null) {}
            }
            else
            {
              paramString = new LinkedList();
            }
            localObject2 = (Iterable)paramString;
            paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              awh localawh = (awh)((Iterator)localObject2).next();
              p.g(localawh, "it");
              paramString.add(new aq(localawh));
            }
            ((FinderLiveLotteryListLoader.c)localObject1).setIncrementList((List)paramString);
            ((FinderLiveLotteryListLoader.c)localObject1).setPullType(((aa)paramq).pullType);
          }
        }
      }
      paramString = (IResponse)localObject1;
      AppMethodBeat.o(244714);
      return paramString;
    }
    
    public final com.tencent.mm.ak.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(244713);
      Object localObject = new aa(this.tWd.liveId, this.tWd.hFK, com.tencent.mm.ac.d.Ga(this.tWd.objectNonceId), this.tWd.tWb, this.tWd.getLastBuffer());
      ((aa)localObject).pullType = 2;
      localObject = (com.tencent.mm.ak.q)localObject;
      AppMethodBeat.o(244713);
      return localObject;
    }
    
    public final com.tencent.mm.ak.q genRefreshNetScene()
    {
      AppMethodBeat.i(244712);
      Object localObject = new aa(this.tWd.liveId, this.tWd.hFK, com.tencent.mm.ac.d.Ga(this.tWd.objectNonceId), this.tWd.tWb, this.tWd.getLastBuffer());
      ((aa)localObject).pullType = 0;
      localObject = (com.tencent.mm.ak.q)localObject;
      AppMethodBeat.o(244712);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(244711);
      List localList = j.listOf(Integer.valueOf(5258));
      AppMethodBeat.o(244711);
      return localList;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader$LotteryWinnerListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "isMessageOpen", "", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;Z)V", "()Z", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "plugin-finder_release"})
  public static final class c
    extends IResponse<bo>
  {
    public final awi tWe;
    public final boolean tWf;
    
    public c(int paramInt1, int paramInt2, String paramString, awi paramawi, boolean paramBoolean)
    {
      super(paramInt2, paramString);
      this.tWe = paramawi;
      this.tWf = paramBoolean;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(FinderLiveLotteryListLoader paramFinderLiveLotteryListLoader, IResponse paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader
 * JD-Core Version:    0.7.0.1
 */