package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.c;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.live.model.cgi.be;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bhz;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "objectId", "", "liveId", "nonceId", "", "scene", "", "(JJLjava/lang/String;I)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getLiveId", "()J", "getNonceId", "()Ljava/lang/String;", "getObjectId", "getScene", "()I", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "Companion", "LotteryAllHistoryFetcher", "LotteryAllHistoryResponse", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveLotteryAnchorAllHistoryLoader
  extends BaseFeedLoader<cc>
{
  public static final a Bhd;
  public kotlin.g.a.b<? super IResponse<cc>, ah> fetchEndCallback;
  final long hKN;
  private boolean hasMore;
  final long liveId;
  private final String nonceId;
  final int scene;
  
  static
  {
    AppMethodBeat.i(365923);
    Bhd = new a((byte)0);
    AppMethodBeat.o(365923);
  }
  
  public FinderLiveLotteryAnchorAllHistoryLoader(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    super(null);
    AppMethodBeat.i(365920);
    this.hKN = paramLong1;
    this.liveId = paramLong2;
    this.nonceId = paramString;
    this.scene = paramInt;
    AppMethodBeat.o(365920);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(365931);
    i locali = (i)new b();
    AppMethodBeat.o(365931);
    return locali;
  }
  
  public final void onFetchDone(final IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(365940);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aYj());
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(365940);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    d.uiThread((kotlin.g.a.a)new d(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(365940);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader$LotteryAllHistoryFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public b()
    {
      AppMethodBeat.i(366215);
      AppMethodBeat.o(366215);
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(366250);
      s.u(paramp, "scene");
      Log.i(getTAG(), "onSceneEnd: errType " + paramInt1 + ", errCode " + paramInt2 + " errMsg " + paramString);
      paramString = new FinderLiveLotteryAnchorAllHistoryLoader.c(paramInt1, paramInt2, paramString);
      if (((paramp instanceof be)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject1 = c.c.b(((be)paramp).rr.otC);
        if (localObject1 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
          AppMethodBeat.o(366250);
          throw paramString;
        }
        paramString.setLastBuffer(((bhz)localObject1).lastBuffer);
        localObject1 = c.c.b(((be)paramp).rr.otC);
        if (localObject1 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
          AppMethodBeat.o(366250);
          throw paramString;
        }
        if (((bhz)localObject1).continueFlag == 1) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.setHasMore(bool);
          Object localObject2 = (Iterable)((be)paramp).emI();
          localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            bje localbje = (bje)((Iterator)localObject2).next();
            s.s(localbje, "it");
            ((Collection)localObject1).add(new av(localbje));
          }
        }
        paramString.setIncrementList((List)localObject1);
        paramString.setPullType(((be)paramp).pullType);
      }
      paramString = (IResponse)paramString;
      AppMethodBeat.o(366250);
      return paramString;
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(366239);
      Object localObject = new be(this.Bhe.scene, this.Bhe.liveId, this.Bhe.hKN, "", this.Bhe.getLastBuffer(), 1);
      ((be)localObject).pullType = 2;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(366239);
      return localObject;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(366234);
      Object localObject = new be(this.Bhe.scene, this.Bhe.liveId, this.Bhe.hKN, "", this.Bhe.getLastBuffer(), 1);
      ((be)localObject).pullType = 0;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(366234);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(366223);
      List localList = kotlin.a.p.listOf(Integer.valueOf(6484));
      AppMethodBeat.o(366223);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader$LotteryAllHistoryResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends IResponse<cc>
  {
    public c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(FinderLiveLotteryAnchorAllHistoryLoader paramFinderLiveLotteryAnchorAllHistoryLoader, IResponse<cc> paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryAnchorAllHistoryLoader
 * JD-Core Version:    0.7.0.1
 */