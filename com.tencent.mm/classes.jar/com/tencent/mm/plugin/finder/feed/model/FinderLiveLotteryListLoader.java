package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.c;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lotteryId", "", "liveId", "", "objectId", "objectNonceId", "scene", "", "(Ljava/lang/String;JJLjava/lang/String;I)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getLiveId", "()J", "getLotteryId", "()Ljava/lang/String;", "getObjectId", "getObjectNonceId", "getScene", "()I", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "Companion", "LotteryListFetcher", "LotteryWinnerListResponse", "plugin-finder_release"})
public final class FinderLiveLotteryListLoader
  extends BaseFeedLoader<bu>
{
  public static final a xHU;
  public kotlin.g.a.b<? super IResponse<bu>, kotlin.x> fetchEndCallback;
  private boolean hasMore;
  final long liveId;
  final String objectNonceId;
  final int scene;
  public final String xHT;
  public final long xbk;
  
  static
  {
    AppMethodBeat.i(224203);
    xHU = new a((byte)0);
    AppMethodBeat.o(224203);
  }
  
  public FinderLiveLotteryListLoader(String paramString1, long paramLong1, long paramLong2, String paramString2, int paramInt)
  {
    super(null);
    AppMethodBeat.i(224200);
    this.xHT = paramString1;
    this.liveId = paramLong1;
    this.xbk = paramLong2;
    this.objectNonceId = paramString2;
    this.scene = paramInt;
    AppMethodBeat.o(224200);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(224187);
    i locali = (i)new b();
    AppMethodBeat.o(224187);
    return locali;
  }
  
  public final void onFetchDone(final IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(224193);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aFi());
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(224193);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    d.uiThread((kotlin.g.a.a)new d(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(224193);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader$LotteryListFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchCgi;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "requestCgi", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "resp", "genLoadMoreCgi", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord;", "genRefreshCgi", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.b
  {
    public final IResponse<bu> a(int paramInt1, int paramInt2, String paramString, c<? extends dyy> paramc, dyy paramdyy)
    {
      boolean bool2 = true;
      int i = 0;
      AppMethodBeat.i(270592);
      Log.i(getTAG(), "onSceneEnd: errType " + paramInt1 + ", errCode " + paramInt2 + " errMsg " + paramString);
      Object localObject2 = new FinderLiveLotteryListLoader.c(paramInt1, paramInt2, paramString);
      Object localObject1 = localObject2;
      if ((paramdyy instanceof azs))
      {
        localObject1 = localObject2;
        if (paramInt1 == 0)
        {
          localObject1 = localObject2;
          if (paramInt2 == 0)
          {
            localObject1 = ((azs)paramdyy).xHW;
            if (((azs)paramdyy).SLq == 0)
            {
              bool1 = true;
              localObject1 = new FinderLiveLotteryListLoader.c(paramInt1, paramInt2, paramString, (bal)localObject1, bool1);
              ((FinderLiveLotteryListLoader.c)localObject1).setLastBuffer(((azs)paramdyy).lastBuffer);
              if (((azs)paramdyy).continueFlag != 1) {
                break label290;
              }
            }
            label290:
            for (boolean bool1 = bool2;; bool1 = false)
            {
              ((FinderLiveLotteryListLoader.c)localObject1).setHasMore(bool1);
              paramString = ((azs)paramdyy).SLp;
              if (paramString != null)
              {
                paramdyy = paramString.SMv;
                paramString = paramdyy;
                if (paramdyy != null) {}
              }
              else
              {
                paramString = new LinkedList();
              }
              paramdyy = (Iterable)paramString;
              paramString = (Collection)new ArrayList(j.a(paramdyy, 10));
              paramdyy = paramdyy.iterator();
              while (paramdyy.hasNext())
              {
                localObject2 = (bak)paramdyy.next();
                p.j(localObject2, "it");
                paramString.add(new as((bak)localObject2));
              }
              bool1 = false;
              break;
            }
            ((FinderLiveLotteryListLoader.c)localObject1).setIncrementList((List)paramString);
            if ((paramc instanceof com.tencent.mm.plugin.finder.live.model.cgi.x)) {
              break label351;
            }
          }
        }
      }
      label351:
      for (paramString = null;; paramString = paramc)
      {
        paramString = (com.tencent.mm.plugin.finder.live.model.cgi.x)paramString;
        paramInt1 = i;
        if (paramString != null) {
          paramInt1 = paramString.pullType;
        }
        ((FinderLiveLotteryListLoader.c)localObject1).setPullType(paramInt1);
        paramString = (IResponse)localObject1;
        AppMethodBeat.o(270592);
        return paramString;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader$LotteryWinnerListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "isMessageOpen", "", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;Z)V", "()Z", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "plugin-finder_release"})
  public static final class c
    extends IResponse<bu>
  {
    public final bal xHW;
    public final boolean xHX;
    
    public c(int paramInt1, int paramInt2, String paramString, bal parambal, boolean paramBoolean)
    {
      super(paramInt2, paramString);
      this.xHW = parambal;
      this.xHX = paramBoolean;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<kotlin.x>
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