package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c.a;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dyq;
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
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "response", "onFetchRefreshDone", "requestLoadMore", "requestRefresh", "Companion", "FinderFavListData", "FinderFavListInit", "FinderFavListRequest", "FinderFavListResponse", "plugin-finder_release"})
public final class a
  extends BaseFinderFeedLoader
{
  private static final ConcurrentHashMap<Long, a.a.a> KPN;
  public static final a KPO;
  private static final String TAG = "Finder.FinderFavFeedLoader";
  public d.g.a.b<? super IResponse<BaseFinderFeed>, y> KPL;
  private final String KPM;
  public int fwP;
  public boolean hasMore;
  public com.tencent.mm.bx.b lastBuffer;
  
  static
  {
    AppMethodBeat.i(198162);
    KPO = new a((byte)0);
    TAG = "Finder.FinderFavFeedLoader";
    KPN = new ConcurrentHashMap();
    AppMethodBeat.o(198162);
  }
  
  public a(String paramString, dzp paramdzp)
  {
    super(null, paramdzp, 1, null);
    AppMethodBeat.i(198161);
    this.KPM = paramString;
    AppMethodBeat.o(198161);
  }
  
  public final f<Object, Object, i> createDataFetch(dzp paramdzp)
  {
    AppMethodBeat.i(198156);
    paramdzp = (f)new b(paramdzp);
    AppMethodBeat.o(198156);
    return paramdzp;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(198159);
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
      AppMethodBeat.o(198159);
      return;
    }
    AppMethodBeat.o(198159);
  }
  
  public final void onFetchRefreshDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    int i = 0;
    AppMethodBeat.i(198160);
    k.h(paramIResponse, "response");
    RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
    Object localObject;
    boolean bool;
    if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
    {
      localObject = aj.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      localc.HXp = ((CharSequence)((Context)localObject).getResources().getString(2131759373));
      localc.HXo = 1;
      if (paramIResponse.getPullType() == 0) {
        break label266;
      }
      bool = true;
      label85:
      localc.hSO = bool;
      localc.HXq = paramIResponse.getHasMore();
      if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.HXr > 0)) {
        localc.HXp = null;
      }
      localc.gVl = Integer.valueOf(((e)paramIResponse).fwP);
      ad.i(getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
      localObject = paramIResponse.getIncrementList();
      if (localObject != null) {
        i = ((List)localObject).size();
      }
      if (!paramIResponse.getHasMore()) {
        break label271;
      }
      i = 2;
    }
    for (;;)
    {
      paramIResponse = new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8);
      dispatcher().a(paramIResponse, localc);
      AppMethodBeat.o(198160);
      return;
      localObject = aj.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      localc.HXp = ((CharSequence)((Context)localObject).getResources().getString(2131759383));
      localc.HXo = -1;
      break;
      label266:
      bool = false;
      break label85;
      label271:
      if ((getDataList().size() != 0) && (i != 0) && (getDataList().size() > i)) {
        i = 4;
      } else {
        i = 6;
      }
    }
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(198158);
    d locald = new d(this.KPM, this.lastBuffer, 2);
    ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)locald);
    AppMethodBeat.o(198158);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(198157);
    d locald = new d(this.KPM, this.lastBuffer, 0);
    ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)locald);
    AppMethodBeat.o(198157);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$Companion;", "", "()V", "TAG", "", "favDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$Companion$FavFeedCache;", "getFavDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearCache", "", "getCache", "id", "putCache", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "FavFeedCache", "plugin-finder_release"})
  public static final class a
  {
    public static a BJ(long paramLong)
    {
      AppMethodBeat.i(198148);
      ad.i(a.access$getTAG$cp(), "getCache " + paramLong + ", exist:" + a.fTv().containsKey(Long.valueOf(paramLong)));
      a locala2 = (a)a.fTv().get(Long.valueOf(paramLong));
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a((List)new ArrayList(), null);
      }
      AppMethodBeat.o(198148);
      return locala1;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$Companion$FavFeedCache;", "", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/util/List;Lcom/tencent/mm/protobuf/ByteString;)V", "getDataList", "()Ljava/util/List;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class a
    {
      final List<BaseFinderFeed> dataList;
      public final com.tencent.mm.bx.b lastBuffer;
      
      public a(List<? extends BaseFinderFeed> paramList, com.tencent.mm.bx.b paramb)
      {
        AppMethodBeat.i(198144);
        this.dataList = paramList;
        this.lastBuffer = paramb;
        AppMethodBeat.o(198144);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(198147);
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
          AppMethodBeat.o(198147);
          return true;
        }
        AppMethodBeat.o(198147);
        return false;
      }
      
      public final int hashCode()
      {
        int j = 0;
        AppMethodBeat.i(198146);
        Object localObject = this.dataList;
        if (localObject != null) {}
        for (int i = localObject.hashCode();; i = 0)
        {
          localObject = this.lastBuffer;
          if (localObject != null) {
            j = localObject.hashCode();
          }
          AppMethodBeat.o(198146);
          return i * 31 + j;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(198145);
        String str = "FavFeedCache(dataList=" + this.dataList + ", lastBuffer=" + this.lastBuffer + ")";
        AppMethodBeat.o(198145);
        return str;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListInit;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "favCallBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getFavCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setFavCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class b
    extends f<a.c, a.d, BaseFinderFeed>
    implements com.tencent.mm.al.g
  {
    private e<BaseFinderFeed> KPP;
    private final String TAG = "Finder.FinderFavListData";
    
    public b(dzp paramdzp)
    {
      super();
    }
    
    public final void alive()
    {
      AppMethodBeat.i(198150);
      com.tencent.mm.kernel.g.aeS().a(3966, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(198150);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(198151);
      com.tencent.mm.kernel.g.aeS().b(3966, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(198151);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      Object localObject1 = null;
      AppMethodBeat.i(198152);
      if ((paramn instanceof ay))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject2 = ((ay)paramn).rr.auM();
          if (localObject2 == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
            AppMethodBeat.o(198152);
            throw paramString;
          }
          if (((dyq)localObject2).continueFlag != 0) {}
        }
        for (boolean bool1 = false;; bool1 = true)
        {
          localObject2 = ((ay)paramn).rr.auM();
          if (localObject2 != null) {
            break;
          }
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(198152);
          throw paramString;
        }
        Object localObject2 = new a.e(paramInt1, paramInt2, paramString, ((dyq)localObject2).fwP);
        Object localObject3 = (Iterable)((ay)paramn).ckL();
        paramString = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        Object localObject4;
        Object localObject5;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FinderObject)((Iterator)localObject3).next();
          localObject5 = FinderItem.qJU;
          localObject4 = FinderItem.a.a((FinderObject)localObject4, 256);
          localObject5 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
          paramString.add(b.a.h((FinderItem)localObject4));
        }
        ((a.e)localObject2).setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
        paramString = ((ay)paramn).ckL();
        if (((ay)paramn).pullType != 2) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          b.a.a(paramString, 256, bool2, null, true, this.contextObj, 40);
          localObject3 = this.TAG;
          localObject4 = new StringBuilder("incrementList size: ");
          localObject5 = ((a.e)localObject2).getIncrementList();
          paramString = localObject1;
          if (localObject5 != null) {
            paramString = Integer.valueOf(((List)localObject5).size());
          }
          ad.i((String)localObject3, paramString);
          ((a.e)localObject2).setPullType(((ay)paramn).pullType);
          paramString = ((ay)paramn).rr.auM();
          if (paramString != null) {
            break;
          }
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(198152);
          throw paramString;
        }
        ((a.e)localObject2).setLastBuffer(((dyq)paramString).lastBuffer);
        ((a.e)localObject2).setHasMore(bool1);
        paramString = this.KPP;
        if (paramString != null)
        {
          paramString.onFetchDone((IResponse)localObject2);
          AppMethodBeat.o(198152);
          return;
        }
      }
      AppMethodBeat.o(198152);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "cacheId", "", "isTimeLine", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(JZLcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "getCacheId", "()J", "()Z", "plugin-finder_release"})
  public static final class c
    extends h
  {
    final boolean hyH;
    final long qxT;
    
    public c(long paramLong, boolean paramBoolean, com.tencent.mm.plugin.finder.feed.model.internal.g paramg)
    {
      super();
      AppMethodBeat.i(198154);
      this.qxT = paramLong;
      this.hyH = paramBoolean;
      AppMethodBeat.o(198154);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "finderUserName", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getFinderUserName", "()Ljava/lang/String;", "getLastBuff", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    final String KPM;
    final int pullType;
    final com.tencent.mm.bx.b qHz;
    
    public d(String paramString, com.tencent.mm.bx.b paramb, int paramInt)
    {
      AppMethodBeat.i(198155);
      this.KPM = paramString;
      this.qHz = paramb;
      this.pullType = paramInt;
      AppMethodBeat.o(198155);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "(IILjava/lang/String;I)V", "getTotalCount", "()I", "setTotalCount", "(I)V", "plugin-finder_release"})
  public static final class e
    extends IResponse<BaseFinderFeed>
  {
    int fwP;
    
    public e(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      super(paramInt2, paramString);
      this.fwP = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.a
 * JD-Core Version:    0.7.0.1
 */