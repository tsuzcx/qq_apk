package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.finder.cgi.ab.a;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.v;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getFinderUserName", "()Ljava/lang/String;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Companion", "FinderLbsStreamListRequest", "FinderLbsStreamListResponse", "LbsStreamDataFetcher", "plugin-finder_release"})
public final class FinderLbsStreamFeedLoader
  extends BaseFinderFeedLoader
{
  private static final String TAG = "Finder.LbsStreamFeedLoader";
  private static final ConcurrentHashMap<Long, Object> tVK;
  public static final a tVL;
  public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
  public int gAZ;
  private boolean hasMore;
  final String sBN;
  
  static
  {
    AppMethodBeat.i(244682);
    tVL = new a((byte)0);
    TAG = "Finder.LbsStreamFeedLoader";
    tVK = new ConcurrentHashMap();
    AppMethodBeat.o(244682);
  }
  
  public FinderLbsStreamFeedLoader(String paramString, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(244681);
    this.sBN = paramString;
    AppMethodBeat.o(244681);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(244678);
    g localg = (g)new d();
    AppMethodBeat.o(244678);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(244679);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new e(this);
    AppMethodBeat.o(244679);
    return localb;
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244680);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse.getPullType() == 0) && ((paramIResponse instanceof c))) {
      this.gAZ = ((c)paramIResponse).gAZ;
    }
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(244680);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    if (!paramIResponse.getHasMore())
    {
      kotlin.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(244680);
        return;
      }
    }
    AppMethodBeat.o(244680);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion;", "", "()V", "TAG", "", "lbsStreamDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion$LbsStreamFeedCache;", "getLbsStreamDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearCache", "", "getCache", "id", "putCache", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "removeCache", "key", "LbsStreamFeedCache", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListRequest;", "", "finderUserName", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getFinderUserName", "()Ljava/lang/String;", "getLastBuff", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "plugin-finder_release"})
  public static final class b
  {
    final int pullType;
    private final String sBN;
    final com.tencent.mm.bw.b tVM;
    
    public b(String paramString, com.tencent.mm.bw.b paramb, int paramInt)
    {
      AppMethodBeat.i(244666);
      this.sBN = paramString;
      this.tVM = paramb;
      this.pullType = paramInt;
      AppMethodBeat.o(244666);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "(IILjava/lang/String;I)V", "getTotalCount", "()I", "setTotalCount", "(I)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<bo>
  {
    int gAZ;
    
    public c(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      super(paramInt2, paramString);
      this.gAZ = paramInt3;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$LbsStreamDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;)V", "dataFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"})
  public final class d
    extends g<bo>
  {
    private i tMX;
    final com.tencent.mm.plugin.finder.cgi.fetcher.c tVN;
    
    public d()
    {
      AppMethodBeat.i(244675);
      this.tVN = new com.tencent.mm.plugin.finder.cgi.fetcher.c(2, this$1.getContextObj());
      this.tMX = new i("LbsStreamListData");
      AppMethodBeat.o(244675);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(244672);
      super.alive();
      this.tMX.start();
      AppMethodBeat.o(244672);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(244673);
      super.dead();
      this.tVN.ttK.dead();
      this.tMX.stop();
      AppMethodBeat.o(244673);
    }
    
    public final void fetch(final Object paramObject, final f<bo> paramf)
    {
      AppMethodBeat.i(244674);
      p.h(paramf, "callback");
      if ((paramObject instanceof FinderLbsStreamFeedLoader.b)) {
        this.tMX.a(new com.tencent.mm.loader.g.h((kotlin.g.a.b)new a(this, paramf, paramObject)));
      }
      AppMethodBeat.o(244674);
    }
    
    public final void fetchInit(f<bo> paramf)
    {
      AppMethodBeat.i(244671);
      p.h(paramf, "callback");
      Object localObject = this.tVO.getCache();
      FinderLbsStreamFeedLoader.c localc;
      if (localObject != null)
      {
        localObject = ((h)localObject).kgc;
        if (localObject != null)
        {
          localObject = (List)localObject;
          Log.i(getTAG(), "[fetchInit] ret=".concat(String.valueOf(localObject)));
          localc = new FinderLbsStreamFeedLoader.c(0, 0, "", ((List)localObject).size());
          localc.setIncrementList((List)localObject);
          localObject = this.tVO.getCache();
          if (localObject == null) {
            break label131;
          }
        }
      }
      label131:
      for (localObject = ((h)localObject).lastBuffer;; localObject = null)
      {
        localc.setLastBuffer((com.tencent.mm.bw.b)localObject);
        localc.setPullType(1000);
        paramf.onFetchDone((IResponse)localc);
        AppMethodBeat.o(244671);
        return;
        localObject = (List)v.SXr;
        break;
      }
    }
    
    public final void fetchLoadMore(f<bo> paramf)
    {
      AppMethodBeat.i(244670);
      p.h(paramf, "callback");
      fetch(new FinderLbsStreamFeedLoader.b(this.tVO.sBN, this.tVO.getLastBuffer(), 2), paramf);
      AppMethodBeat.o(244670);
    }
    
    public final void fetchRefresh(f<bo> paramf)
    {
      AppMethodBeat.i(244669);
      p.h(paramf, "callback");
      fetch(new FinderLbsStreamFeedLoader.b(this.tVO.sBN, this.tVO.getLastBuffer(), 0), paramf);
      AppMethodBeat.o(244669);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<com.tencent.mm.loader.g.h, x>
    {
      a(FinderLbsStreamFeedLoader.d paramd, f paramf, Object paramObject)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class e
    extends BaseFeedLoader<bo>.a
  {
    e()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, x> paramb)
    {
      AppMethodBeat.i(244677);
      p.h(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      Context localContext;
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        localContext = MMApplicationContext.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        localc.Rmi = ((CharSequence)localContext.getResources().getString(2131760628));
        localc.Rmh = 1;
        if (paramIResponse.getPullType() == 0) {
          break label241;
        }
        bool = true;
        label84:
        localc.jLE = bool;
        localc.Rmj = paramIResponse.getHasMore();
        if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.Rmk > 0)) {
          localc.Rmi = null;
        }
        Log.i(this.tVO.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        if (!paramIResponse.getHasMore()) {
          break label247;
        }
      }
      label241:
      label247:
      for (int i = 4;; i = 6)
      {
        d.h((a)new a(this, new n(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(244677);
        return;
        localContext = MMApplicationContext.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        localc.Rmi = ((CharSequence)localContext.getResources().getString(2131760645));
        localc.Rmh = -1;
        break;
        bool = false;
        break label84;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<x>
    {
      a(FinderLbsStreamFeedLoader.e parame, n paramn, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
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