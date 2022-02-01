package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.finder.cgi.n.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.v;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getFinderUserName", "()Ljava/lang/String;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Companion", "FinderLbsStreamListRequest", "FinderLbsStreamListResponse", "LbsStreamDataFetcher", "plugin-finder_release"})
public final class FinderLbsStreamFeedLoader
  extends BaseFinderFeedLoader
{
  private static final String TAG = "Finder.LbsStreamFeedLoader";
  private static final ConcurrentHashMap<Long, Object> sku;
  public static final a skv;
  public int fVS;
  public d.g.a.b<? super IResponse<am>, z> fetchEndCallback;
  private boolean hasMore;
  final String sjZ;
  
  static
  {
    AppMethodBeat.i(202886);
    skv = new a((byte)0);
    TAG = "Finder.LbsStreamFeedLoader";
    sku = new ConcurrentHashMap();
    AppMethodBeat.o(202886);
  }
  
  public FinderLbsStreamFeedLoader(String paramString, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(202885);
    this.sjZ = paramString;
    AppMethodBeat.o(202885);
  }
  
  public final g<am> createDataFetch()
  {
    AppMethodBeat.i(202882);
    g localg = (g)new d();
    AppMethodBeat.o(202882);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<am> createDataMerger()
  {
    AppMethodBeat.i(202883);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new FinderLbsStreamFeedLoader.e(this);
    AppMethodBeat.o(202883);
    return localb;
  }
  
  public final void onFetchDone(IResponse<am> paramIResponse)
  {
    AppMethodBeat.i(202884);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse.getPullType() == 0) && ((paramIResponse instanceof c))) {
      this.fVS = ((c)paramIResponse).fVS;
    }
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(202884);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    if (!paramIResponse.getHasMore())
    {
      d.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(202884);
        return;
      }
    }
    AppMethodBeat.o(202884);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion;", "", "()V", "TAG", "", "lbsStreamDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion$LbsStreamFeedCache;", "getLbsStreamDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearCache", "", "getCache", "id", "putCache", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "removeCache", "key", "LbsStreamFeedCache", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListRequest;", "", "finderUserName", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getFinderUserName", "()Ljava/lang/String;", "getLastBuff", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "plugin-finder_release"})
  public static final class b
  {
    final int pullType;
    private final String sjZ;
    final com.tencent.mm.bw.b skw;
    
    public b(String paramString, com.tencent.mm.bw.b paramb, int paramInt)
    {
      AppMethodBeat.i(202870);
      this.sjZ = paramString;
      this.skw = paramb;
      this.pullType = paramInt;
      AppMethodBeat.o(202870);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "(IILjava/lang/String;I)V", "getTotalCount", "()I", "setTotalCount", "(I)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<am>
  {
    int fVS;
    
    public c(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      super(paramInt2, paramString);
      this.fVS = paramInt3;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$LbsStreamDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;)V", "dataFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"})
  public final class d
    extends g<am>
  {
    private i sdq;
    final com.tencent.mm.plugin.finder.cgi.fetcher.c skx;
    
    public d()
    {
      AppMethodBeat.i(202879);
      this.skx = new com.tencent.mm.plugin.finder.cgi.fetcher.c(2, this$1.getContextObj());
      this.sdq = new i("LbsStreamListData");
      AppMethodBeat.o(202879);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(202876);
      super.alive();
      this.sdq.start();
      AppMethodBeat.o(202876);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(202877);
      super.dead();
      this.skx.rQs.dead();
      this.sdq.stop();
      AppMethodBeat.o(202877);
    }
    
    public final void fetch(final Object paramObject, final f<am> paramf)
    {
      AppMethodBeat.i(202878);
      p.h(paramf, "callback");
      if ((paramObject instanceof FinderLbsStreamFeedLoader.b)) {
        this.sdq.a(new h((d.g.a.b)new a(this, paramf, paramObject)));
      }
      AppMethodBeat.o(202878);
    }
    
    public final void fetchInit(f<am> paramf)
    {
      AppMethodBeat.i(202875);
      p.h(paramf, "callback");
      Object localObject = this.sky.getCache();
      FinderLbsStreamFeedLoader.c localc;
      if (localObject != null)
      {
        localObject = ((e)localObject).jhZ;
        if (localObject != null)
        {
          localObject = (List)localObject;
          ae.i(getTAG(), "[fetchInit] ret=".concat(String.valueOf(localObject)));
          localc = new FinderLbsStreamFeedLoader.c(0, 0, "", ((List)localObject).size());
          localc.setIncrementList((List)localObject);
          localObject = this.sky.getCache();
          if (localObject == null) {
            break label131;
          }
        }
      }
      label131:
      for (localObject = ((e)localObject).lastBuffer;; localObject = null)
      {
        localc.setLastBuffer((com.tencent.mm.bw.b)localObject);
        localc.setPullType(1000);
        paramf.onFetchDone((IResponse)localc);
        AppMethodBeat.o(202875);
        return;
        localObject = (List)v.NhH;
        break;
      }
    }
    
    public final void fetchLoadMore(f<am> paramf)
    {
      AppMethodBeat.i(202874);
      p.h(paramf, "callback");
      fetch(new FinderLbsStreamFeedLoader.b(this.sky.sjZ, this.sky.getLastBuffer(), 2), paramf);
      AppMethodBeat.o(202874);
    }
    
    public final void fetchRefresh(f<am> paramf)
    {
      AppMethodBeat.i(202873);
      p.h(paramf, "callback");
      fetch(new FinderLbsStreamFeedLoader.b(this.sky.sjZ, this.sky.getLastBuffer(), 0), paramf);
      AppMethodBeat.o(202873);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
    static final class a
      extends q
      implements d.g.a.b<h, z>
    {
      a(FinderLbsStreamFeedLoader.d paramd, f paramf, Object paramObject)
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