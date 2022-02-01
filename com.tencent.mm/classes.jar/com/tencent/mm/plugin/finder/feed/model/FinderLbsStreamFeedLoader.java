package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ab.a;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.e.c;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.v;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getFinderUserName", "()Ljava/lang/String;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Companion", "FinderLbsStreamListRequest", "FinderLbsStreamListResponse", "LbsStreamDataFetcher", "plugin-finder_release"})
public final class FinderLbsStreamFeedLoader
  extends BaseFinderFeedLoader
{
  private static final String TAG = "Finder.LbsStreamFeedLoader";
  private static final ConcurrentHashMap<Long, Object> xHC;
  public static final a xHD;
  public kotlin.g.a.b<? super IResponse<bu>, x> fetchEndCallback;
  private boolean hasMore;
  public int jlf;
  final String whH;
  
  static
  {
    AppMethodBeat.i(280143);
    xHD = new a((byte)0);
    TAG = "Finder.LbsStreamFeedLoader";
    xHC = new ConcurrentHashMap();
    AppMethodBeat.o(280143);
  }
  
  public FinderLbsStreamFeedLoader(String paramString, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(280142);
    this.whH = paramString;
    AppMethodBeat.o(280142);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.i<bu> createDataFetch()
  {
    AppMethodBeat.i(280139);
    com.tencent.mm.plugin.finder.feed.model.internal.i locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new d();
    AppMethodBeat.o(280139);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(280140);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new e(this);
    AppMethodBeat.o(280140);
    return locald;
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(280141);
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse.getPullType() == 0) && ((paramIResponse instanceof c))) {
      this.jlf = ((c)paramIResponse).jlf;
    }
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(280141);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    if (!paramIResponse.getHasMore())
    {
      kotlin.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(280141);
        return;
      }
    }
    AppMethodBeat.o(280141);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion;", "", "()V", "TAG", "", "lbsStreamDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion$LbsStreamFeedCache;", "getLbsStreamDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearCache", "", "getCache", "id", "putCache", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "removeCache", "key", "LbsStreamFeedCache", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListRequest;", "", "finderUserName", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getFinderUserName", "()Ljava/lang/String;", "getLastBuff", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "plugin-finder_release"})
  public static final class b
  {
    final int pullType;
    private final String whH;
    final com.tencent.mm.cd.b xHE;
    
    public b(String paramString, com.tencent.mm.cd.b paramb, int paramInt)
    {
      AppMethodBeat.i(223693);
      this.whH = paramString;
      this.xHE = paramb;
      this.pullType = paramInt;
      AppMethodBeat.o(223693);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "(IILjava/lang/String;I)V", "getTotalCount", "()I", "setTotalCount", "(I)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<bu>
  {
    int jlf;
    
    public c(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      super(paramInt2, paramString);
      this.jlf = paramInt3;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$LbsStreamDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;)V", "dataFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"})
  public final class d
    extends com.tencent.mm.plugin.finder.feed.model.internal.i<bu>
  {
    private final com.tencent.mm.plugin.finder.cgi.fetcher.d xHF;
    private com.tencent.mm.loader.g.i xeM;
    
    public d()
    {
      AppMethodBeat.i(285784);
      this.xHF = new com.tencent.mm.plugin.finder.cgi.fetcher.d(this$1.getContextObj());
      this.xeM = new com.tencent.mm.loader.g.i("LbsStreamListData");
      AppMethodBeat.o(285784);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(285781);
      super.alive();
      this.xeM.start();
      AppMethodBeat.o(285781);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(285782);
      super.dead();
      this.xHF.xbq.dead();
      this.xeM.stop();
      AppMethodBeat.o(285782);
    }
    
    public final void fetch(final Object paramObject, final com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(285783);
      p.k(paramh, "callback");
      if ((paramObject instanceof FinderLbsStreamFeedLoader.b)) {
        this.xeM.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new a(this, paramh, paramObject)));
      }
      AppMethodBeat.o(285783);
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(285780);
      p.k(paramh, "callback");
      Object localObject = this.xHG.getCache();
      FinderLbsStreamFeedLoader.c localc;
      if (localObject != null)
      {
        localObject = ((q)localObject).mXB;
        if (localObject != null)
        {
          localObject = (List)localObject;
          Log.i(getTAG(), "[fetchInit] ret=".concat(String.valueOf(localObject)));
          localc = new FinderLbsStreamFeedLoader.c(0, 0, "", ((List)localObject).size());
          localc.setIncrementList((List)localObject);
          localObject = this.xHG.getCache();
          if (localObject == null) {
            break label131;
          }
        }
      }
      label131:
      for (localObject = ((q)localObject).lastBuffer;; localObject = null)
      {
        localc.setLastBuffer((com.tencent.mm.cd.b)localObject);
        localc.setPullType(1000);
        paramh.onFetchDone((IResponse)localc);
        AppMethodBeat.o(285780);
        return;
        localObject = (List)v.aaAd;
        break;
      }
    }
    
    public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(285778);
      p.k(paramh, "callback");
      fetch(new FinderLbsStreamFeedLoader.b(this.xHG.whH, this.xHG.getLastBuffer(), 2), paramh);
      AppMethodBeat.o(285778);
    }
    
    public final void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.h<bu> paramh)
    {
      AppMethodBeat.i(285777);
      p.k(paramh, "callback");
      fetch(new FinderLbsStreamFeedLoader.b(this.xHG.whH, this.xHG.getLastBuffer(), 0), paramh);
      AppMethodBeat.o(285777);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
    {
      a(FinderLbsStreamFeedLoader.d paramd, com.tencent.mm.plugin.finder.feed.model.internal.h paramh, Object paramObject)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class e
    extends BaseFeedLoader<bu>.a
  {
    e()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bu> paramIResponse, final kotlin.g.a.b<? super IResponse<bu>, x> paramb)
    {
      AppMethodBeat.i(288093);
      p.k(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      Context localContext;
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        localc.YNE = ((CharSequence)localContext.getResources().getString(b.j.finder_timeline_refresh_nothing_tip));
        localc.YND = 1;
        if (paramIResponse.getPullType() == 0) {
          break label243;
        }
        bool = true;
        label85:
        localc.mCI = bool;
        localc.YNF = paramIResponse.getHasMore();
        if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.YNG > 0)) {
          localc.YNE = null;
        }
        Log.i(this.xHG.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        if (!paramIResponse.getHasMore()) {
          break label249;
        }
      }
      label243:
      label249:
      for (int i = 4;; i = 6)
      {
        com.tencent.mm.ae.d.uiThread((a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.q(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(288093);
        return;
        localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        localc.YNE = ((CharSequence)localContext.getResources().getString(b.j.finder_touch_to_retry));
        localc.YND = -1;
        break;
        bool = false;
        break label85;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements a<x>
    {
      a(FinderLbsStreamFeedLoader.e parame, com.tencent.mm.plugin.finder.feed.model.internal.q paramq, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader
 * JD-Core Version:    0.7.0.1
 */