package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.live.model.cgi.ad;
import com.tencent.mm.plugin.finder.model.aw;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lotteryId", "", "liveId", "", "objectId", "objectNonceId", "scene", "", "(Ljava/lang/String;JJLjava/lang/String;I)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getLiveId", "()J", "getLotteryId", "()Ljava/lang/String;", "getObjectId", "getObjectNonceId", "getScene", "()I", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "Companion", "LotteryListFetcher", "LotteryWinnerListResponse", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveLotteryListLoader
  extends BaseFeedLoader<cc>
{
  public static final a Bhj;
  public final String Bhk;
  public kotlin.g.a.b<? super IResponse<cc>, ah> fetchEndCallback;
  public final long hKN;
  private boolean hasMore;
  final long liveId;
  final String objectNonceId;
  final int scene;
  
  static
  {
    AppMethodBeat.i(366434);
    Bhj = new a((byte)0);
    AppMethodBeat.o(366434);
  }
  
  public FinderLiveLotteryListLoader(String paramString1, long paramLong1, long paramLong2, String paramString2, int paramInt)
  {
    super(null);
    AppMethodBeat.i(366427);
    this.Bhk = paramString1;
    this.liveId = paramLong1;
    this.hKN = paramLong2;
    this.objectNonceId = paramString2;
    this.scene = paramInt;
    AppMethodBeat.o(366427);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(366441);
    i locali = (i)new b();
    AppMethodBeat.o(366441);
    return locali;
  }
  
  public final void onFetchDone(final IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366448);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aYj());
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
      AppMethodBeat.o(366448);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    d.uiThread((kotlin.g.a.a)new d(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(366448);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader$LotteryListFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchCgi;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "requestCgi", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "resp", "genLoadMoreCgi", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord;", "genRefreshCgi", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.b
  {
    public b()
    {
      AppMethodBeat.i(365858);
      AppMethodBeat.o(365858);
    }
    
    public final IResponse<cc> a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.b<? extends esc> paramb, esc paramesc)
    {
      boolean bool2 = true;
      int i = 0;
      AppMethodBeat.i(365867);
      Log.i(getTAG(), "onSceneEnd: errType " + paramInt1 + ", errCode " + paramInt2 + " errMsg " + paramString);
      Object localObject2 = new FinderLiveLotteryListLoader.c(paramInt1, paramInt2, paramString);
      Object localObject1 = localObject2;
      if ((paramesc instanceof bib))
      {
        localObject1 = localObject2;
        if (paramInt1 == 0)
        {
          localObject1 = localObject2;
          if (paramInt2 == 0)
          {
            localObject1 = ((bib)paramesc).Bhm;
            boolean bool1;
            if (((bib)paramesc).ZRi == 0)
            {
              bool1 = true;
              localObject1 = new FinderLiveLotteryListLoader.c(paramInt1, paramInt2, paramString, (bjc)localObject1, bool1);
              ((FinderLiveLotteryListLoader.c)localObject1).setLastBuffer(((bib)paramesc).lastBuffer);
              if (((bib)paramesc).continueFlag != 1) {
                break label287;
              }
              bool1 = bool2;
              label161:
              ((FinderLiveLotteryListLoader.c)localObject1).setHasMore(bool1);
              paramString = ((bib)paramesc).ZRh;
              if (paramString != null) {
                break label293;
              }
            }
            label287:
            label293:
            for (paramString = null;; paramString = paramString.ZSS)
            {
              paramesc = paramString;
              if (paramString == null) {
                paramesc = new LinkedList();
              }
              paramesc = (Iterable)paramesc;
              paramString = (Collection)new ArrayList(p.a(paramesc, 10));
              paramesc = paramesc.iterator();
              while (paramesc.hasNext())
              {
                localObject2 = (bjb)paramesc.next();
                s.s(localObject2, "it");
                paramString.add(new aw((bjb)localObject2));
              }
              bool1 = false;
              break;
              bool1 = false;
              break label161;
            }
            ((FinderLiveLotteryListLoader.c)localObject1).setIncrementList((List)paramString);
            if (!(paramb instanceof ad)) {
              break label350;
            }
            paramString = (ad)paramb;
            if (paramString != null) {
              break label355;
            }
          }
        }
      }
      label350:
      label355:
      for (paramInt1 = i;; paramInt1 = paramString.pullType)
      {
        ((FinderLiveLotteryListLoader.c)localObject1).setPullType(paramInt1);
        paramString = (IResponse)localObject1;
        AppMethodBeat.o(365867);
        return paramString;
        paramString = null;
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader$LotteryWinnerListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "isMessageOpen", "", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;Z)V", "()Z", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends IResponse<cc>
  {
    public final bjc Bhm;
    public final boolean Bhn;
    
    public c(int paramInt1, int paramInt2, String paramString, bjc parambjc, boolean paramBoolean)
    {
      super(paramInt2, paramString);
      this.Bhm = parambjc;
      this.Bhn = paramBoolean;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(FinderLiveLotteryListLoader paramFinderLiveLotteryListLoader, IResponse<cc> paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader
 * JD-Core Version:    0.7.0.1
 */