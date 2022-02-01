package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.cgi.r;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c.a;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getTargetUsername", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "response", "onFetchRefreshDone", "requestLoadMore", "requestRefresh", "Companion", "LikedTimeLineData", "LikedTimeLineInit", "LikedTimeLineRequest", "LikedTimelineResponse", "plugin-finder_release"})
public final class w
  extends BaseFinderFeedLoader
{
  private static final ConcurrentHashMap<Long, w.a.a> KPV;
  public static final a KPW;
  private static final String TAG = "Finder.FinderFriendLikeLoader";
  public d.g.a.b<? super IResponse<BaseFinderFeed>, y> KPL;
  private boolean hasMore;
  public com.tencent.mm.bx.b lastBuffer;
  private final String qwI;
  
  static
  {
    AppMethodBeat.i(198229);
    KPW = new a((byte)0);
    TAG = "Finder.FinderFriendLikeLoader";
    KPV = new ConcurrentHashMap();
    AppMethodBeat.o(198229);
  }
  
  public w(String paramString, dzp paramdzp)
  {
    super(null, paramdzp, 1, null);
    AppMethodBeat.i(198228);
    this.qwI = paramString;
    AppMethodBeat.o(198228);
  }
  
  public final f<Object, Object, i> createDataFetch(dzp paramdzp)
  {
    AppMethodBeat.i(198223);
    paramdzp = (f)new b(paramdzp);
    AppMethodBeat.o(198223);
    return paramdzp;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(198226);
    k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse instanceof e)) {
      this.lastBuffer = paramIResponse.getLastBuffer();
    }
    this.hasMore = paramIResponse.getHasMore();
    d.g.a.b localb = this.KPL;
    if (localb != null)
    {
      localb.aA(paramIResponse);
      AppMethodBeat.o(198226);
      return;
    }
    AppMethodBeat.o(198226);
  }
  
  public final void onFetchRefreshDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(198227);
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
        break label230;
      }
      bool = true;
      label83:
      localc.hSO = bool;
      localc.HXq = paramIResponse.getHasMore();
      if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.HXr > 0)) {
        localc.HXp = null;
      }
      ad.i(getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
      if (!paramIResponse.getHasMore()) {
        break label235;
      }
    }
    label230:
    label235:
    for (int i = 4;; i = 6)
    {
      paramIResponse = new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8);
      dispatcher().a(paramIResponse, localc);
      AppMethodBeat.o(198227);
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
    AppMethodBeat.i(198225);
    d locald = new d(this.qwI, this.lastBuffer, 2);
    ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)locald);
    AppMethodBeat.o(198225);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(198224);
    d locald = new d(this.qwI, this.lastBuffer, 0);
    ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)locald);
    AppMethodBeat.o(198224);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$Companion;", "", "()V", "TAG", "", "friendLikeDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$Companion$FriendLikeFeedCache;", "getFriendLikeDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearCache", "", "getCache", "id", "putCache", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "FriendLikeFeedCache", "plugin-finder_release"})
  public static final class a
  {
    public static a BK(long paramLong)
    {
      AppMethodBeat.i(198214);
      ad.i(w.access$getTAG$cp(), "getCache " + paramLong + ", exist:" + w.fTx().containsKey(Long.valueOf(paramLong)));
      a locala2 = (a)w.fTx().get(Long.valueOf(paramLong));
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a((List)new ArrayList(), null);
      }
      AppMethodBeat.o(198214);
      return locala1;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$Companion$FriendLikeFeedCache;", "", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/util/List;Lcom/tencent/mm/protobuf/ByteString;)V", "getDataList", "()Ljava/util/List;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class a
    {
      final List<BaseFinderFeed> dataList;
      public final com.tencent.mm.bx.b lastBuffer;
      
      public a(List<? extends BaseFinderFeed> paramList, com.tencent.mm.bx.b paramb)
      {
        AppMethodBeat.i(198210);
        this.dataList = paramList;
        this.lastBuffer = paramb;
        AppMethodBeat.o(198210);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(198213);
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
          AppMethodBeat.o(198213);
          return true;
        }
        AppMethodBeat.o(198213);
        return false;
      }
      
      public final int hashCode()
      {
        int j = 0;
        AppMethodBeat.i(198212);
        Object localObject = this.dataList;
        if (localObject != null) {}
        for (int i = localObject.hashCode();; i = 0)
        {
          localObject = this.lastBuffer;
          if (localObject != null) {
            j = localObject.hashCode();
          }
          AppMethodBeat.o(198212);
          return i * 31 + j;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(198211);
        String str = "FriendLikeFeedCache(dataList=" + this.dataList + ", lastBuffer=" + this.lastBuffer + ")";
        AppMethodBeat.o(198211);
        return str;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimeLineData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimeLineInit;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimeLineRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "map", "", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetLikedList;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class b
    extends f<w.c, w.d, BaseFinderFeed>
    implements com.tencent.mm.al.g
  {
    private final Map<r, e<BaseFinderFeed>> map;
    
    public b(dzp paramdzp)
    {
      super();
      AppMethodBeat.i(198220);
      this.map = ((Map)new LinkedHashMap());
      AppMethodBeat.o(198220);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(198216);
      com.tencent.mm.kernel.g.aeS().a(3965, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(198216);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(198217);
      com.tencent.mm.kernel.g.aeS().b(3965, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(198217);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(198218);
      e locale = (e)this.map.get(paramn);
      if (locale != null)
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetLikedList");
          AppMethodBeat.o(198218);
          throw paramString;
        }
        r localr = (r)paramn;
        this.map.remove(paramn);
        if ((paramInt1 == 0) && (paramInt2 == 0) && (localr.ckO() != 1)) {}
        for (boolean bool = false;; bool = true)
        {
          paramn = new w.e(paramInt1, paramInt2, paramString);
          paramString = localr.qpi;
          if (paramString == null) {
            break label246;
          }
          Object localObject = (Iterable)paramString;
          paramString = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
            b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
            paramString.add(b.a.h(localFinderItem));
          }
        }
        label246:
        for (paramString = (List)paramString;; paramString = null)
        {
          paramn.setIncrementList(paramString);
          paramn.setPullType(localr.pullType);
          paramn.setLastBuffer(localr.ckN());
          paramn.setHasMore(bool);
          locale.onFetchDone((IResponse)paramn);
          AppMethodBeat.o(198218);
          return;
        }
      }
      AppMethodBeat.o(198218);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimeLineInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "cacheId", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(JLcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "getCacheId", "()J", "plugin-finder_release"})
  public static final class c
    extends h
  {
    final long qxT;
    
    public c(long paramLong, com.tencent.mm.plugin.finder.feed.model.internal.g paramg)
    {
      super();
      AppMethodBeat.i(198221);
      this.qxT = paramLong;
      AppMethodBeat.o(198221);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimeLineRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "targetUsername", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "getTargetUsername", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    final com.tencent.mm.bx.b lastBuffer;
    final int pullType;
    final String qwI;
    
    public d(String paramString, com.tencent.mm.bx.b paramb, int paramInt)
    {
      AppMethodBeat.i(198222);
      this.qwI = paramString;
      this.lastBuffer = paramb;
      this.pullType = paramInt;
      AppMethodBeat.o(198222);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader$LikedTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class e
    extends IResponse<BaseFinderFeed>
  {
    public e(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.w
 * JD-Core Version:    0.7.0.1
 */