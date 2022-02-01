package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.g.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c.a;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getFinderUserName", "()Ljava/lang/String;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "response", "onFetchRefreshDone", "requestLoadMore", "requestRefresh", "Companion", "FinderLbsStreamListData", "FinderLbsStreamListInit", "FinderLbsStreamListRequest", "FinderLbsStreamListResponse", "plugin-finder_release"})
public final class y
  extends BaseFinderFeedLoader
{
  private static final ConcurrentHashMap<Long, y.a.a> KQd;
  public static final a KQe;
  private static final String TAG = "Finder.LbsStreamFeedLoader";
  public d.g.a.b<? super IResponse<BaseFinderFeed>, d.y> KPL;
  private final String KPM;
  public int fwP;
  private boolean hasMore;
  public com.tencent.mm.bx.b lastBuffer;
  
  static
  {
    AppMethodBeat.i(198268);
    KQe = new a((byte)0);
    TAG = "Finder.LbsStreamFeedLoader";
    KQd = new ConcurrentHashMap();
    AppMethodBeat.o(198268);
  }
  
  public y(String paramString, dzp paramdzp)
  {
    super(null, paramdzp, 1, null);
    AppMethodBeat.i(198267);
    this.KPM = paramString;
    AppMethodBeat.o(198267);
  }
  
  public final f<Object, Object, i> createDataFetch(dzp paramdzp)
  {
    AppMethodBeat.i(198262);
    paramdzp = (f)new b(paramdzp);
    AppMethodBeat.o(198262);
    return paramdzp;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(198265);
    k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse instanceof e)) {
      this.lastBuffer = paramIResponse.getLastBuffer();
    }
    if ((paramIResponse.getPullType() == 0) && ((paramIResponse instanceof e))) {
      this.fwP = ((e)paramIResponse).fwP;
    }
    this.hasMore = paramIResponse.getHasMore();
    d.g.a.b localb = this.KPL;
    if (localb != null)
    {
      localb.aA(paramIResponse);
      AppMethodBeat.o(198265);
      return;
    }
    AppMethodBeat.o(198265);
  }
  
  public final void onFetchRefreshDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(198266);
    k.h(paramIResponse, "response");
    RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
    Context localContext;
    boolean bool;
    if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
    {
      localContext = aj.getContext();
      k.g(localContext, "MMApplicationContext.getContext()");
      localc.HXp = ((CharSequence)localContext.getResources().getString(2131759373));
      localc.HXo = 1;
      if (paramIResponse.getPullType() == 0) {
        break label246;
      }
      bool = true;
      label83:
      localc.hSO = bool;
      localc.HXq = paramIResponse.getHasMore();
      if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.HXr > 0)) {
        localc.HXp = null;
      }
      localc.gVl = Integer.valueOf(((e)paramIResponse).fwP);
      ad.i(getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
      if (!paramIResponse.getHasMore()) {
        break label251;
      }
    }
    label246:
    label251:
    for (int i = 4;; i = 6)
    {
      paramIResponse = new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8);
      dispatcher().a(paramIResponse, localc);
      AppMethodBeat.o(198266);
      return;
      localContext = aj.getContext();
      k.g(localContext, "MMApplicationContext.getContext()");
      localc.HXp = ((CharSequence)localContext.getResources().getString(2131759383));
      localc.HXo = -1;
      break;
      bool = false;
      break label83;
    }
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(198264);
    d locald = new d(this.KPM, this.lastBuffer, 2);
    ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((j)locald);
    AppMethodBeat.o(198264);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(198263);
    d locald = new d(this.KPM, this.lastBuffer, 0);
    ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((j)locald);
    AppMethodBeat.o(198263);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion;", "", "()V", "TAG", "", "lbsStreamDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion$LbsStreamFeedCache;", "getLbsStreamDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearCache", "", "getCache", "id", "putCache", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "removeCache", "key", "LbsStreamFeedCache", "plugin-finder_release"})
  public static final class a
  {
    public static void BI(long paramLong)
    {
      AppMethodBeat.i(198251);
      y.fTy().remove(Long.valueOf(paramLong));
      AppMethodBeat.o(198251);
    }
    
    public static a BL(long paramLong)
    {
      AppMethodBeat.i(198252);
      ad.i(y.access$getTAG$cp(), "getCache " + paramLong + ", exist:" + y.fTy().containsKey(Long.valueOf(paramLong)));
      a locala2 = (a)y.fTy().get(Long.valueOf(paramLong));
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a((List)new ArrayList(), null);
      }
      AppMethodBeat.o(198252);
      return locala1;
    }
    
    public static void a(long paramLong, List<? extends BaseFinderFeed> paramList, com.tencent.mm.bx.b paramb)
    {
      AppMethodBeat.i(198250);
      k.h(paramList, "dataList");
      ad.i(y.access$getTAG$cp(), "putCache " + paramLong + ", list size:" + paramList.size());
      List localList = (List)new ArrayList();
      localList.addAll((Collection)paramList);
      y.fTy().put(Long.valueOf(paramLong), new a(localList, paramb));
      AppMethodBeat.o(198250);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion$LbsStreamFeedCache;", "", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/util/List;Lcom/tencent/mm/protobuf/ByteString;)V", "getDataList", "()Ljava/util/List;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class a
    {
      public final List<BaseFinderFeed> dataList;
      public final com.tencent.mm.bx.b lastBuffer;
      
      public a(List<? extends BaseFinderFeed> paramList, com.tencent.mm.bx.b paramb)
      {
        AppMethodBeat.i(198246);
        this.dataList = paramList;
        this.lastBuffer = paramb;
        AppMethodBeat.o(198246);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(198249);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((!k.g(this.dataList, paramObject.dataList)) || (!k.g(this.lastBuffer, paramObject.lastBuffer))) {}
          }
        }
        else
        {
          AppMethodBeat.o(198249);
          return true;
        }
        AppMethodBeat.o(198249);
        return false;
      }
      
      public final int hashCode()
      {
        int j = 0;
        AppMethodBeat.i(198248);
        Object localObject = this.dataList;
        if (localObject != null) {}
        for (int i = localObject.hashCode();; i = 0)
        {
          localObject = this.lastBuffer;
          if (localObject != null) {
            j = localObject.hashCode();
          }
          AppMethodBeat.o(198248);
          return i * 31 + j;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(198247);
        String str = "LbsStreamFeedCache(dataList=" + this.dataList + ", lastBuffer=" + this.lastBuffer + ")";
        AppMethodBeat.o(198247);
        return str;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListInit;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "dataFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "alive", "", "call", "request", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "callInitData", "", "init", "dead", "plugin-finder_release"})
  public static final class b
    extends f<y.c, y.d, BaseFinderFeed>
  {
    private final com.tencent.mm.plugin.finder.cgi.a.b KQf;
    private final String TAG;
    private m quD;
    
    public b(dzp paramdzp)
    {
      super();
      AppMethodBeat.i(198259);
      this.TAG = "Finder.LbsStreamListData";
      this.KQf = new com.tencent.mm.plugin.finder.cgi.a.b(2, paramdzp);
      this.quD = new m("LbsStreamListData");
      AppMethodBeat.o(198259);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(198256);
      this.quD.start();
      AppMethodBeat.o(198256);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(198257);
      this.KQf.KJT.dead();
      this.quD.stop();
      AppMethodBeat.o(198257);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<com.tencent.mm.plugin.finder.utils.l, d.y>
    {
      a(y.b paramb, e parame, y.d paramd)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "cacheId", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(JLcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "getCacheId", "()J", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.h
  {
    final long qxT;
    
    public c(long paramLong, g paramg)
    {
      super();
      AppMethodBeat.i(198260);
      this.qxT = paramLong;
      AppMethodBeat.o(198260);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "finderUserName", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getFinderUserName", "()Ljava/lang/String;", "getLastBuff", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "plugin-finder_release"})
  public static final class d
    implements j
  {
    private final String KPM;
    final int pullType;
    final com.tencent.mm.bx.b qHz;
    
    public d(String paramString, com.tencent.mm.bx.b paramb, int paramInt)
    {
      AppMethodBeat.i(198261);
      this.KPM = paramString;
      this.qHz = paramb;
      this.pullType = paramInt;
      AppMethodBeat.o(198261);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "(IILjava/lang/String;I)V", "getTotalCount", "()I", "setTotalCount", "(I)V", "plugin-finder_release"})
  public static final class e
    extends IResponse<BaseFinderFeed>
  {
    int fwP = 0;
    
    public e(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.y
 * JD-Core Version:    0.7.0.1
 */