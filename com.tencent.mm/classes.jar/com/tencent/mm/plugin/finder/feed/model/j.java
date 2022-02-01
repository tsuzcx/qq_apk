package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.l.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.b.a;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.utils.q;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vending.e.c;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getFinderUserName", "()Ljava/lang/String;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "response", "onFetchRefreshDone", "requestLoadMore", "requestRefresh", "Companion", "FinderLbsStreamListData", "FinderLbsStreamListInit", "FinderLbsStreamListRequest", "FinderLbsStreamListResponse", "plugin-finder_release"})
public final class j
  extends BaseFinderFeedLoader
{
  private static final String TAG = "Finder.LbsStreamFeedLoader";
  private static final ConcurrentHashMap<Long, j.a.a> rmY;
  public static final a rmZ;
  public int fAw;
  private boolean hasMore;
  public com.tencent.mm.bw.b lastBuffer;
  public d.g.a.b<? super IResponse<BaseFinderFeed>, y> rmE;
  private final String rmF;
  
  static
  {
    AppMethodBeat.i(202178);
    rmZ = new a((byte)0);
    TAG = "Finder.LbsStreamFeedLoader";
    rmY = new ConcurrentHashMap();
    AppMethodBeat.o(202178);
  }
  
  public j(String paramString, anm paramanm)
  {
    super(null, paramanm, 1, null);
    AppMethodBeat.i(202177);
    this.rmF = paramString;
    AppMethodBeat.o(202177);
  }
  
  public final e<Object, Object, com.tencent.mm.plugin.finder.feed.model.internal.h> createDataFetch(anm paramanm)
  {
    AppMethodBeat.i(202172);
    paramanm = (e)new b(paramanm);
    AppMethodBeat.o(202172);
    return paramanm;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(202175);
    d.g.b.k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse instanceof e)) {
      this.lastBuffer = paramIResponse.getLastBuffer();
    }
    if ((paramIResponse.getPullType() == 0) && ((paramIResponse instanceof e))) {
      this.fAw = ((e)paramIResponse).fAw;
    }
    this.hasMore = paramIResponse.getHasMore();
    if (!this.hasMore)
    {
      d.g.a.b localb = this.rmE;
      if (localb != null)
      {
        localb.ay(paramIResponse);
        AppMethodBeat.o(202175);
        return;
      }
    }
    AppMethodBeat.o(202175);
  }
  
  public final void onFetchRefreshDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(202176);
    d.g.b.k.h(paramIResponse, "response");
    RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
    Context localContext;
    boolean bool;
    if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
    {
      localContext = ai.getContext();
      d.g.b.k.g(localContext, "MMApplicationContext.getContext()");
      localc.Jya = ((CharSequence)localContext.getResources().getString(2131759373));
      localc.JxZ = 1;
      if (paramIResponse.getPullType() == 0) {
        break label246;
      }
      bool = true;
      label83:
      localc.isT = bool;
      localc.Jyb = paramIResponse.getHasMore();
      if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.Jyc > 0)) {
        localc.Jya = null;
      }
      localc.hvK = Integer.valueOf(((e)paramIResponse).fAw);
      ac.i(getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
      if (!paramIResponse.getHasMore()) {
        break label251;
      }
    }
    label246:
    label251:
    for (int i = 4;; i = 6)
    {
      paramIResponse = new com.tencent.mm.plugin.finder.feed.model.internal.k(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8);
      dispatcher().a(paramIResponse, localc);
      AppMethodBeat.o(202176);
      return;
      localContext = ai.getContext();
      d.g.b.k.g(localContext, "MMApplicationContext.getContext()");
      localc.Jya = ((CharSequence)localContext.getResources().getString(2131759383));
      localc.JxZ = -1;
      break;
      bool = false;
      break label83;
    }
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(202174);
    d locald = new d(this.rmF, this.lastBuffer, 2);
    ac.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((i)locald);
    AppMethodBeat.o(202174);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(202173);
    d locald = new d(this.rmF, this.lastBuffer, 0);
    ac.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((i)locald);
    AppMethodBeat.o(202173);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion;", "", "()V", "TAG", "", "lbsStreamDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion$LbsStreamFeedCache;", "getLbsStreamDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearCache", "", "getCache", "id", "putCache", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "removeCache", "key", "LbsStreamFeedCache", "plugin-finder_release"})
  public static final class a
  {
    public static void a(long paramLong, List<? extends BaseFinderFeed> paramList, com.tencent.mm.bw.b paramb)
    {
      AppMethodBeat.i(202160);
      d.g.b.k.h(paramList, "dataList");
      ac.i(j.access$getTAG$cp(), "putCache " + paramLong + ", list size:" + paramList.size());
      List localList = (List)new ArrayList();
      localList.addAll((Collection)paramList);
      j.cvD().put(Long.valueOf(paramLong), new j.a.a(localList, paramb));
      AppMethodBeat.o(202160);
    }
    
    public static void ui(long paramLong)
    {
      AppMethodBeat.i(202161);
      j.cvD().remove(Long.valueOf(paramLong));
      AppMethodBeat.o(202161);
    }
    
    public static j.a.a un(long paramLong)
    {
      AppMethodBeat.i(202162);
      ac.i(j.access$getTAG$cp(), "getCache " + paramLong + ", exist:" + j.cvD().containsKey(Long.valueOf(paramLong)));
      j.a.a locala2 = (j.a.a)j.cvD().get(Long.valueOf(paramLong));
      j.a.a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new j.a.a((List)new ArrayList(), null);
      }
      AppMethodBeat.o(202162);
      return locala1;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListInit;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "dataFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "alive", "", "call", "request", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "callInitData", "", "init", "dead", "plugin-finder_release"})
  public static final class b
    extends e<j.c, j.d, BaseFinderFeed>
  {
    private final String TAG;
    private r rgF;
    private final com.tencent.mm.plugin.finder.cgi.fetcher.b rna;
    
    public b(anm paramanm)
    {
      super();
      AppMethodBeat.i(202169);
      this.TAG = "Finder.LbsStreamListData";
      this.rna = new com.tencent.mm.plugin.finder.cgi.fetcher.b(2, paramanm);
      this.rgF = new r("LbsStreamListData");
      AppMethodBeat.o(202169);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(202166);
      this.rgF.start();
      AppMethodBeat.o(202166);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(202167);
      this.rna.qXf.dead();
      this.rgF.stop();
      AppMethodBeat.o(202167);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<q, y>
    {
      a(j.b paramb, d paramd, j.d paramd1)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "cacheId", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(JLcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "getCacheId", "()J", "plugin-finder_release"})
  public static final class c
    extends g
  {
    final long rhr;
    
    public c(long paramLong, f paramf)
    {
      super();
      AppMethodBeat.i(202170);
      this.rhr = paramLong;
      AppMethodBeat.o(202170);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "finderUserName", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getFinderUserName", "()Ljava/lang/String;", "getLastBuff", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "plugin-finder_release"})
  public static final class d
    implements i
  {
    final int pullType;
    private final String rmF;
    final com.tencent.mm.bw.b rmJ;
    
    public d(String paramString, com.tencent.mm.bw.b paramb, int paramInt)
    {
      AppMethodBeat.i(202171);
      this.rmF = paramString;
      this.rmJ = paramb;
      this.pullType = paramInt;
      AppMethodBeat.o(202171);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "(IILjava/lang/String;I)V", "getTotalCount", "()I", "setTotalCount", "(I)V", "plugin-finder_release"})
  public static final class e
    extends IResponse<BaseFinderFeed>
  {
    int fAw = 0;
    
    public e(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.j
 * JD-Core Version:    0.7.0.1
 */