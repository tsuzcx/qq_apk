package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.c;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.live.model.cgi.be;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bhz;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bok;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "scene", "", "liveId", "", "objectId", "objectNonceId", "", "(IJJLjava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getLiveId", "()J", "getObjectId", "getObjectNonceId", "()Ljava/lang/String;", "getScene", "()I", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "Companion", "LotteryHistoryFetcher", "LotteryHistoryResponse", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveLotteryHistoryLoader
  extends BaseFeedLoader<cc>
{
  public static final a Bhf;
  public kotlin.g.a.b<? super IResponse<cc>, ah> fetchEndCallback;
  final long hKN;
  private boolean hasMore;
  final long liveId;
  final String objectNonceId;
  public final int scene;
  
  static
  {
    AppMethodBeat.i(366300);
    Bhf = new a((byte)0);
    AppMethodBeat.o(366300);
  }
  
  public FinderLiveLotteryHistoryLoader(int paramInt, long paramLong1, long paramLong2, String paramString)
  {
    super(null);
    AppMethodBeat.i(366295);
    this.scene = paramInt;
    this.liveId = paramLong1;
    this.hKN = paramLong2;
    this.objectNonceId = paramString;
    AppMethodBeat.o(366295);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(366307);
    i locali = (i)new b();
    AppMethodBeat.o(366307);
    return locali;
  }
  
  public final void onFetchDone(final IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366319);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aYj());
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(366319);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    d.uiThread((kotlin.g.a.a)new d(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(366319);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader$LotteryHistoryFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader;)V", "getType", "", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    private final int Bhg;
    
    public b()
    {
      AppMethodBeat.i(365865);
      AppMethodBeat.o(365865);
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      Object localObject2 = null;
      AppMethodBeat.i(365901);
      s.u(paramp, "scene");
      Log.i(getTAG(), "onSceneEnd: errType " + paramInt1 + ", errCode " + paramInt2 + " errMsg " + paramString);
      Object localObject3 = new FinderLiveLotteryHistoryLoader.c(paramInt1, paramInt2, paramString);
      Object localObject1 = localObject3;
      label319:
      boolean bool;
      if ((paramp instanceof be))
      {
        localObject1 = localObject3;
        if (paramInt1 == 0)
        {
          localObject1 = localObject3;
          if (paramInt2 == 0)
          {
            localObject3 = (bje)kotlin.a.p.oL((List)((be)paramp).emI());
            if (localObject3 == null) {}
            for (localObject1 = null;; localObject1 = new au(((bje)localObject3).ZSQ * 1000L, ((bje)localObject3).ZSR.size()))
            {
              localObject1 = new FinderLiveLotteryHistoryLoader.c(paramInt1, paramInt2, paramString, (au)localObject1);
              paramString = c.c.b(((be)paramp).rr.otC);
              if (paramString != null) {
                break;
              }
              paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
              AppMethodBeat.o(365901);
              throw paramString;
            }
            paramString = ((bhz)paramString).ZRg;
            if (paramString == null) {
              paramString = null;
            }
            for (;;)
            {
              ((FinderLiveLotteryHistoryLoader.c)localObject1).setLastBuffer(paramString);
              paramString = c.c.b(((be)paramp).rr.otC);
              if (paramString != null) {
                break;
              }
              paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
              AppMethodBeat.o(365901);
              throw paramString;
              paramString = paramString.ZWH;
              if (paramString == null)
              {
                paramString = null;
              }
              else
              {
                paramString = (bje)kotlin.a.p.oL((List)paramString);
                if (paramString == null) {
                  paramString = null;
                } else {
                  paramString = paramString.ZEQ;
                }
              }
            }
            paramString = ((bhz)paramString).ZRg;
            if (paramString != null) {
              break label369;
            }
            paramString = null;
            if (paramString != null) {
              break label414;
            }
            bool = false;
            label322:
            ((FinderLiveLotteryHistoryLoader.c)localObject1).setHasMore(bool);
            if (localObject3 != null) {
              break label428;
            }
            paramString = (String)localObject2;
          }
        }
      }
      for (;;)
      {
        ((FinderLiveLotteryHistoryLoader.c)localObject1).setIncrementList(paramString);
        ((FinderLiveLotteryHistoryLoader.c)localObject1).setPullType(((be)paramp).pullType);
        paramString = (IResponse)localObject1;
        AppMethodBeat.o(365901);
        return paramString;
        label369:
        paramString = paramString.ZWH;
        if (paramString == null)
        {
          paramString = null;
          break;
        }
        paramString = (bje)kotlin.a.p.oL((List)paramString);
        if (paramString == null)
        {
          paramString = null;
          break;
        }
        paramString = Integer.valueOf(paramString.BeA);
        break;
        label414:
        if (paramString.intValue() != 1) {
          break label319;
        }
        bool = true;
        break label322;
        label428:
        paramString = ((bje)localObject3).ZSR;
        if (paramString == null)
        {
          paramString = (String)localObject2;
        }
        else
        {
          localObject2 = (Iterable)paramString;
          paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (bjc)((Iterator)localObject2).next();
            s.s(localObject3, "it");
            paramString.add(new at((bjc)localObject3));
          }
          paramString = (List)paramString;
        }
      }
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(365884);
      Object localObject = new be(this.Bhh.scene, this.Bhh.liveId, this.Bhh.hKN, this.Bhh.objectNonceId, this.Bhh.getLastBuffer(), this.Bhg);
      ((be)localObject).pullType = 2;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(365884);
      return localObject;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(365877);
      Object localObject = new be(this.Bhh.scene, this.Bhh.liveId, this.Bhh.hKN, this.Bhh.objectNonceId, this.Bhh.getLastBuffer(), this.Bhg);
      ((be)localObject).pullType = 0;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(365877);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(365871);
      List localList = kotlin.a.p.listOf(Integer.valueOf(6484));
      AppMethodBeat.o(365871);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader$LotteryHistoryResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "header", "Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryHeader;", "(IILjava/lang/String;Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryHeader;)V", "getHeader", "()Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryHeader;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends IResponse<cc>
  {
    public final au Bhi;
    
    public c(int paramInt1, int paramInt2, String paramString, au paramau)
    {
      super(paramInt2, paramString);
      this.Bhi = paramau;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(FinderLiveLotteryHistoryLoader paramFinderLiveLotteryHistoryLoader, IResponse<cc> paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryHistoryLoader
 * JD-Core Version:    0.7.0.1
 */