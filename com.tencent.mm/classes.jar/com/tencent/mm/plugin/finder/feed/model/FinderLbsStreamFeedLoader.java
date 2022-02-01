package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.plugin.finder.cgi.ar.a;
import com.tencent.mm.plugin.finder.cgi.fetcher.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.r;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.e.c;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getFinderUserName", "()Ljava/lang/String;", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Companion", "FinderLbsStreamListRequest", "FinderLbsStreamListResponse", "LbsStreamDataFetcher", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLbsStreamFeedLoader
  extends BaseFinderFeedLoader
{
  public static final a BgQ;
  private static final ConcurrentHashMap<Long, Object> BgR;
  private static final String TAG;
  public kotlin.g.a.b<? super IResponse<cc>, ah> fetchEndCallback;
  private boolean hasMore;
  public int lNX;
  final String zDJ;
  
  static
  {
    AppMethodBeat.i(366479);
    BgQ = new a((byte)0);
    TAG = "Finder.LbsStreamFeedLoader";
    BgR = new ConcurrentHashMap();
    AppMethodBeat.o(366479);
  }
  
  public FinderLbsStreamFeedLoader(String paramString, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(366464);
    this.zDJ = paramString;
    AppMethodBeat.o(366464);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.i<cc> createDataFetch()
  {
    AppMethodBeat.i(366489);
    com.tencent.mm.plugin.finder.feed.model.internal.i locali = (com.tencent.mm.plugin.finder.feed.model.internal.i)new d();
    AppMethodBeat.o(366489);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(366497);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new e(this);
    AppMethodBeat.o(366497);
    return locald;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366503);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse.getPullType() == 0) && ((paramIResponse instanceof c))) {
      this.lNX = ((c)paramIResponse).lNX;
    }
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(366503);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    if (!paramIResponse.getHasMore())
    {
      kotlin.g.a.b localb = this.fetchEndCallback;
      if (localb != null) {
        localb.invoke(paramIResponse);
      }
    }
    AppMethodBeat.o(366503);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion;", "", "()V", "TAG", "", "lbsStreamDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$Companion$LbsStreamFeedCache;", "getLbsStreamDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearCache", "", "getCache", "id", "putCache", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "removeCache", "key", "LbsStreamFeedCache", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListRequest;", "", "finderUserName", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getFinderUserName", "()Ljava/lang/String;", "getLastBuff", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final com.tencent.mm.bx.b BgS;
    final int pullType;
    private final String zDJ;
    
    public b(String paramString, com.tencent.mm.bx.b paramb, int paramInt)
    {
      AppMethodBeat.i(366422);
      this.zDJ = paramString;
      this.BgS = paramb;
      this.pullType = paramInt;
      AppMethodBeat.o(366422);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$FinderLbsStreamListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "(IILjava/lang/String;I)V", "getTotalCount", "()I", "setTotalCount", "(I)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends IResponse<cc>
  {
    int lNX;
    
    public c(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      super(paramInt2, paramString);
      this.lNX = paramInt3;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$LbsStreamDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;)V", "dataFetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/loader/loader/SingleTaskExecutor;", "alive", "", "dead", "fetch", "request", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "isAuto", "", "fetchInit", "fetchLoadMore", "fetchRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends com.tencent.mm.plugin.finder.feed.model.internal.i<cc>
  {
    private com.tencent.mm.loader.f.h ADY;
    private final e BgT;
    
    public d()
    {
      AppMethodBeat.i(366458);
      this.BgT = new e(this.BgU.getContextObj());
      this.ADY = new com.tencent.mm.loader.f.h("LbsStreamListData");
      AppMethodBeat.o(366458);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(366491);
      super.alive();
      this.ADY.start();
      AppMethodBeat.o(366491);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(366499);
      super.dead();
      this.BgT.AAh.dead();
      ar.a(this.BgT.scope, kotlin.g.b.s.X(getTAG(), ":onDead"));
      this.ADY.stop();
      AppMethodBeat.o(366499);
    }
    
    public final void fetch(final Object paramObject, final com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(366504);
      kotlin.g.b.s.u(paramh, "callback");
      if ((paramObject instanceof FinderLbsStreamFeedLoader.b)) {
        this.ADY.a(new g((kotlin.g.a.b)new a(this, paramObject, paramh)));
      }
      AppMethodBeat.o(366504);
    }
    
    public final void fetchInit(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh)
    {
      AppMethodBeat.i(366483);
      kotlin.g.b.s.u(paramh, "callback");
      Object localObject = this.BgU.getCache();
      label36:
      FinderLbsStreamFeedLoader.c localc;
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          break label126;
        }
        localObject = (List)ab.aivy;
        Log.i(getTAG(), kotlin.g.b.s.X("[fetchInit] ret=", localObject));
        localc = new FinderLbsStreamFeedLoader.c(0, 0, "", ((List)localObject).size());
        FinderLbsStreamFeedLoader localFinderLbsStreamFeedLoader = this.BgU;
        localc.setIncrementList((List)localObject);
        localObject = localFinderLbsStreamFeedLoader.getCache();
        if (localObject != null) {
          break label134;
        }
      }
      label134:
      for (localObject = null;; localObject = ((s)localObject).lastBuffer)
      {
        localc.setLastBuffer((com.tencent.mm.bx.b)localObject);
        localc.setPullType(1000);
        paramh.onFetchDone((IResponse)localc);
        AppMethodBeat.o(366483);
        return;
        localObject = ((s)localObject).pUj;
        break;
        label126:
        localObject = (List)localObject;
        break label36;
      }
    }
    
    public final void fetchLoadMore(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(366476);
      kotlin.g.b.s.u(paramh, "callback");
      FinderLbsStreamFeedLoader.b localb = new FinderLbsStreamFeedLoader.b(this.BgU.zDJ, this.BgU.getLastBuffer(), 2);
      com.tencent.mm.plugin.finder.feed.model.internal.i.fetch$default((com.tencent.mm.plugin.finder.feed.model.internal.i)this, localb, paramh, false, 4, null);
      AppMethodBeat.o(366476);
    }
    
    public final void fetchRefresh(com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh)
    {
      AppMethodBeat.i(366470);
      kotlin.g.b.s.u(paramh, "callback");
      FinderLbsStreamFeedLoader.b localb = new FinderLbsStreamFeedLoader.b(this.BgU.zDJ, this.BgU.getLastBuffer(), 0);
      com.tencent.mm.plugin.finder.feed.model.internal.i.fetch$default((com.tencent.mm.plugin.finder.feed.model.internal.i)this, localb, paramh, false, 4, null);
      AppMethodBeat.o(366470);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "task", "Lcom/tencent/mm/loader/loader/SingleTask;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<g, ah>
    {
      a(FinderLbsStreamFeedLoader.d paramd, Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.h<cc> paramh)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends BaseFeedLoader<cc>.a
  {
    e(FinderLbsStreamFeedLoader paramFinderLbsStreamFeedLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(366443);
      AppMethodBeat.o(366443);
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(366456);
      kotlin.g.b.s.u(paramIResponse, "response");
      final RefreshLoadMoreLayout.d locald = new RefreshLoadMoreLayout.d(paramIResponse.getPullType());
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        locald.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_timeline_refresh_nothing_tip));
        locald.agJs = 1;
        if (paramIResponse.getPullType() == 0) {
          break label222;
        }
        bool = true;
        label74:
        locald.pzq = bool;
        locald.agJu = paramIResponse.getHasMore();
        if (((locald.actionType == 0) || (locald.actionType == 4)) && (locald.agJv > 0)) {
          locald.agJt = null;
        }
        Log.i(this.BgU.getTAG(), kotlin.g.b.s.X("[onFetchRefreshDone]  reason=", locald));
        if (!paramIResponse.getHasMore()) {
          break label228;
        }
      }
      label222:
      label228:
      for (int i = 4;; i = 6)
      {
        com.tencent.mm.ae.d.uiThread((a)new a(this, new r(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), locald, this.BgU, paramb, paramIResponse));
        AppMethodBeat.o(366456);
        return;
        locald.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_touch_to_retry));
        locald.agJs = -1;
        break;
        bool = false;
        break label74;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(FinderLbsStreamFeedLoader.e parame, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd, FinderLbsStreamFeedLoader paramFinderLbsStreamFeedLoader, kotlin.g.a.b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
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