package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.g.i;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.finder.cgi.n.a;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.a.v;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getFinderUserName", "()Ljava/lang/String;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Companion", "FinderLbsStreamListRequest", "FinderLbsStreamListResponse", "LbsStreamDataFetcher", "plugin-finder_release"})
public final class FinderLbsStreamFeedLoader
  extends BaseFinderFeedLoader
{
  private static final String TAG = "Finder.LbsStreamFeedLoader";
  private static final ConcurrentHashMap<Long, Object> sbD;
  public static final a sbE;
  public int fTM;
  public d.g.a.b<? super IResponse<al>, z> fetchEndCallback;
  private boolean hasMore;
  final String sbk;
  
  static
  {
    AppMethodBeat.i(202410);
    sbE = new a((byte)0);
    TAG = "Finder.LbsStreamFeedLoader";
    sbD = new ConcurrentHashMap();
    AppMethodBeat.o(202410);
  }
  
  public FinderLbsStreamFeedLoader(String paramString, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(202409);
    this.sbk = paramString;
    AppMethodBeat.o(202409);
  }
  
  public final g<al> createDataFetch()
  {
    AppMethodBeat.i(202406);
    g localg = (g)new d();
    AppMethodBeat.o(202406);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<al> createDataMerger()
  {
    AppMethodBeat.i(202407);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new e(this);
    AppMethodBeat.o(202407);
    return localb;
  }
  
  public final void onFetchDone(IResponse<al> paramIResponse)
  {
    AppMethodBeat.i(202408);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse.getPullType() == 0) && ((paramIResponse instanceof c))) {
      this.fTM = ((c)paramIResponse).fTM;
    }
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(202408);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    if (!paramIResponse.getHasMore())
    {
      d.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(202408);
        return;
      }
    }
    AppMethodBeat.o(202408);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion;", "", "()V", "TAG", "", "lbsStreamDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion$LbsStreamFeedCache;", "getLbsStreamDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearCache", "", "getCache", "id", "putCache", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "removeCache", "key", "LbsStreamFeedCache", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListRequest;", "", "finderUserName", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getFinderUserName", "()Ljava/lang/String;", "getLastBuff", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "plugin-finder_release"})
  public static final class b
  {
    final int pullType;
    final com.tencent.mm.bx.b sbF;
    private final String sbk;
    
    public b(String paramString, com.tencent.mm.bx.b paramb, int paramInt)
    {
      AppMethodBeat.i(202394);
      this.sbk = paramString;
      this.sbF = paramb;
      this.pullType = paramInt;
      AppMethodBeat.o(202394);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "(IILjava/lang/String;I)V", "getTotalCount", "()I", "setTotalCount", "(I)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<al>
  {
    int fTM;
    
    public c(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      super(paramInt2, paramString);
      this.fTM = paramInt3;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$LbsStreamDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;)V", "dataFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"})
  public final class d
    extends g<al>
  {
    private i rUM;
    final com.tencent.mm.plugin.finder.cgi.fetcher.c sbG;
    
    public d()
    {
      AppMethodBeat.i(202403);
      this.sbG = new com.tencent.mm.plugin.finder.cgi.fetcher.c(2, this$1.getContextObj());
      this.rUM = new i("LbsStreamListData");
      AppMethodBeat.o(202403);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(202400);
      super.alive();
      this.rUM.start();
      AppMethodBeat.o(202400);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(202401);
      super.dead();
      this.sbG.rIh.dead();
      this.rUM.stop();
      AppMethodBeat.o(202401);
    }
    
    public final void fetch(final Object paramObject, final f<al> paramf)
    {
      AppMethodBeat.i(202402);
      p.h(paramf, "callback");
      if ((paramObject instanceof FinderLbsStreamFeedLoader.b)) {
        this.rUM.a(new h((d.g.a.b)new a(this, paramf, paramObject)));
      }
      AppMethodBeat.o(202402);
    }
    
    public final void fetchInit(f<al> paramf)
    {
      AppMethodBeat.i(202399);
      p.h(paramf, "callback");
      Object localObject = this.sbH.getCache();
      FinderLbsStreamFeedLoader.c localc;
      if (localObject != null)
      {
        localObject = ((e)localObject).jfg;
        if (localObject != null)
        {
          localObject = (List)localObject;
          ad.i(getTAG(), "[fetchInit] ret=".concat(String.valueOf(localObject)));
          localc = new FinderLbsStreamFeedLoader.c(0, 0, "", ((List)localObject).size());
          localc.setIncrementList((List)localObject);
          localObject = this.sbH.getCache();
          if (localObject == null) {
            break label131;
          }
        }
      }
      label131:
      for (localObject = ((e)localObject).lastBuffer;; localObject = null)
      {
        localc.setLastBuffer((com.tencent.mm.bx.b)localObject);
        localc.setPullType(1000);
        paramf.onFetchDone((IResponse)localc);
        AppMethodBeat.o(202399);
        return;
        localObject = (List)v.MKE;
        break;
      }
    }
    
    public final void fetchLoadMore(f<al> paramf)
    {
      AppMethodBeat.i(202398);
      p.h(paramf, "callback");
      fetch(new FinderLbsStreamFeedLoader.b(this.sbH.sbk, this.sbH.getLastBuffer(), 2), paramf);
      AppMethodBeat.o(202398);
    }
    
    public final void fetchRefresh(f<al> paramf)
    {
      AppMethodBeat.i(202397);
      p.h(paramf, "callback");
      fetch(new FinderLbsStreamFeedLoader.b(this.sbH.sbk, this.sbH.getLastBuffer(), 0), paramf);
      AppMethodBeat.o(202397);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;", "invoke"})
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class e
    extends BaseFeedLoader<al>.a
  {
    e()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<al> paramIResponse, final d.g.a.b<? super IResponse<al>, z> paramb)
    {
      AppMethodBeat.i(202405);
      p.h(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      Context localContext;
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        localContext = aj.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        localc.Lrh = ((CharSequence)localContext.getResources().getString(2131759373));
        localc.Lrg = 1;
        if (paramIResponse.getPullType() == 0) {
          break label241;
        }
        bool = true;
        label84:
        localc.iLW = bool;
        localc.Lri = paramIResponse.getHasMore();
        if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.Lrj > 0)) {
          localc.Lrh = null;
        }
        ad.i(this.sbH.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        if (!paramIResponse.getHasMore()) {
          break label247;
        }
      }
      label241:
      label247:
      for (int i = 4;; i = 6)
      {
        com.tencent.mm.ad.c.g((a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(202405);
        return;
        localContext = aj.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
        localc.Lrh = ((CharSequence)localContext.getResources().getString(2131759383));
        localc.Lrg = -1;
        break;
        bool = false;
        break label84;
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<z>
    {
      a(FinderLbsStreamFeedLoader.e parame, com.tencent.mm.plugin.finder.feed.model.internal.l paraml, RefreshLoadMoreLayout.c paramc, d.g.a.b paramb, IResponse paramIResponse)
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