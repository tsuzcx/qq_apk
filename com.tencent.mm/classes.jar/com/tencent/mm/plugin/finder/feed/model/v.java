package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.cgi.as;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dyu;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "feedId", "", "nonceId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getFinderUserName", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getNonceId", "setNonceId", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "request", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "onFetchDone", "response", "requestLoadMore", "requestRefresh", "Companion", "FinderFoldedListData", "FinderFoldedListInit", "FinderFoldedListResponse", "FinderFoldedRequest", "plugin-finder_release"})
public final class v
  extends BaseFinderFeedLoader
{
  private static final ConcurrentHashMap<Long, v.a.a> KPT;
  public static final a KPU;
  private String KJv;
  public d.g.a.b<? super IResponse<BaseFinderFeed>, y> KPL;
  private final String KPM;
  private String TAG;
  private final long feedId;
  private com.tencent.mm.bx.b lastBuffer;
  
  static
  {
    AppMethodBeat.i(198209);
    KPU = new a((byte)0);
    KPT = new ConcurrentHashMap();
    AppMethodBeat.o(198209);
  }
  
  public v(String paramString1, long paramLong, String paramString2, dzp paramdzp)
  {
    super(null, paramdzp, 1, null);
    AppMethodBeat.i(198208);
    this.KPM = paramString1;
    this.feedId = paramLong;
    this.KJv = paramString2;
    this.TAG = "Finder.FinderFriendFoldedFeedLoader";
    AppMethodBeat.o(198208);
  }
  
  public final f<Object, Object, i> createDataFetch(dzp paramdzp)
  {
    AppMethodBeat.i(198202);
    paramdzp = (f)new b(paramdzp);
    AppMethodBeat.o(198202);
    return paramdzp;
  }
  
  public final int findMergeIndex(ArrayList<BaseFinderFeed> paramArrayList, List<? extends BaseFinderFeed> paramList, int paramInt, com.tencent.mm.plugin.finder.feed.model.internal.j paramj)
  {
    AppMethodBeat.i(198203);
    k.h(paramArrayList, "srcList");
    k.h(paramList, "newList");
    paramInt = getDataList().size();
    AppMethodBeat.o(198203);
    return paramInt;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(198207);
    k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse instanceof d)) {
      this.lastBuffer = paramIResponse.getLastBuffer();
    }
    if (!paramIResponse.getHasMore())
    {
      d.g.a.b localb = this.KPL;
      if (localb != null)
      {
        localb.aA(paramIResponse);
        AppMethodBeat.o(198207);
        return;
      }
    }
    AppMethodBeat.o(198207);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(198206);
    e locale = new e(this.KPM, this.feedId, this.KJv, this.lastBuffer, 2);
    ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locale)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)locale);
    AppMethodBeat.o(198206);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(198205);
    e locale = new e(this.KPM, this.feedId, this.KJv, this.lastBuffer, 0);
    ad.i(getTAG(), "requestRefresh ".concat(String.valueOf(locale)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)locale);
    AppMethodBeat.o(198205);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(198204);
    k.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(198204);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$Companion;", "", "()V", "foldedDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$Companion$FoldedFeedCache;", "getFoldedDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearCache", "", "getCache", "id", "putCache", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "FoldedFeedCache", "plugin-finder_release"})
  public static final class a
  {
    public static void c(long paramLong, List<? extends BaseFinderFeed> paramList)
    {
      AppMethodBeat.i(198193);
      k.h(paramList, "dataList");
      ad.i("Finder.FinderFriendFoldedFeedLoader", "putCache " + paramLong + ", list size:" + paramList.size());
      List localList = (List)new ArrayList();
      localList.addAll((Collection)paramList);
      v.fTw().put(Long.valueOf(paramLong), new a(localList));
      AppMethodBeat.o(198193);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$Companion$FoldedFeedCache;", "", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/util/List;Lcom/tencent/mm/protobuf/ByteString;)V", "getDataList", "()Ljava/util/List;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class a
    {
      final List<BaseFinderFeed> dataList;
      private final com.tencent.mm.bx.b lastBuffer;
      
      public a(List<? extends BaseFinderFeed> paramList)
      {
        AppMethodBeat.i(198189);
        this.dataList = paramList;
        this.lastBuffer = null;
        AppMethodBeat.o(198189);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(198192);
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
          AppMethodBeat.o(198192);
          return true;
        }
        AppMethodBeat.o(198192);
        return false;
      }
      
      public final int hashCode()
      {
        int j = 0;
        AppMethodBeat.i(198191);
        Object localObject = this.dataList;
        if (localObject != null) {}
        for (int i = localObject.hashCode();; i = 0)
        {
          localObject = this.lastBuffer;
          if (localObject != null) {
            j = localObject.hashCode();
          }
          AppMethodBeat.o(198191);
          return i * 31 + j;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(198190);
        String str = "FoldedFeedCache(dataList=" + this.dataList + ", lastBuffer=" + this.lastBuffer + ")";
        AppMethodBeat.o(198190);
        return str;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListInit;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "map", "", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFoldedList;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene1", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class b
    extends f<v.c, v.e, BaseFinderFeed>
    implements com.tencent.mm.al.g
  {
    private final String TAG;
    private final Map<as, e<BaseFinderFeed>> map;
    
    public b(dzp paramdzp)
    {
      super();
      AppMethodBeat.i(198199);
      this.TAG = "Finder.FinderFoldedListData";
      this.map = ((Map)new LinkedHashMap());
      AppMethodBeat.o(198199);
    }
    
    public final void alive()
    {
      AppMethodBeat.i(198195);
      com.tencent.mm.kernel.g.aeS().a(3904, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(198195);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(198196);
      com.tencent.mm.kernel.g.aeS().b(3904, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(198196);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(198197);
      e locale = (e)this.map.get(paramn);
      if (locale != null)
      {
        if (paramn == null)
        {
          paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFoldedList");
          AppMethodBeat.o(198197);
          throw paramString;
        }
        as localas = (as)paramn;
        this.map.remove(paramn);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramn = localas.rr.auM();
          if (paramn == null)
          {
            paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
            AppMethodBeat.o(198197);
            throw paramString;
          }
          if (((dyu)paramn).continueFlag != 0) {}
        }
        for (boolean bool = false;; bool = true)
        {
          paramn = new v.d(paramInt1, paramInt2, paramString);
          localObject1 = (Iterable)localas.fRX();
          paramString = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (FinderObject)((Iterator)localObject1).next();
            Object localObject3 = FinderItem.qJU;
            localObject2 = FinderItem.a.a((FinderObject)localObject2, 256);
            localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
            paramString.add(b.a.h((FinderItem)localObject2));
          }
        }
        paramn.setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
        b.a.a((List)localas.fRX(), 1, false, null, true, this.contextObj, 40);
        Object localObject1 = this.TAG;
        Object localObject2 = new StringBuilder("incrementList size: ");
        paramString = paramn.getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          ad.i((String)localObject1, paramString);
          paramn.setPullType(localas.pullType);
          paramString = localas.rr.auM();
          if (paramString != null) {
            break;
          }
          paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
          AppMethodBeat.o(198197);
          throw paramString;
        }
        paramn.setLastBuffer(((dyu)paramString).lastBuffer);
        paramn.setHasMore(bool);
        locale.onFetchDone((IResponse)paramn);
        AppMethodBeat.o(198197);
        return;
      }
      AppMethodBeat.o(198197);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "cacheId", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(JLcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "getCacheId", "()J", "plugin-finder_release"})
  public static final class c
    extends h
  {
    final long qxT;
    
    public c(long paramLong, com.tencent.mm.plugin.finder.feed.model.internal.g paramg)
    {
      super();
      AppMethodBeat.i(198200);
      this.qxT = paramLong;
      AppMethodBeat.o(198200);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class d
    extends IResponse<BaseFinderFeed>
  {
    public d(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendFoldedFeedLoader$FinderFoldedRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "finderUserName", "", "feedId", "", "nonceId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getFeedId", "()J", "getFinderUserName", "()Ljava/lang/String;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getNonceId", "getPullType", "()I", "plugin-finder_release"})
  public static final class e
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    final String KJv;
    final String KPM;
    final long feedId;
    final com.tencent.mm.bx.b lastBuffer;
    final int pullType;
    
    public e(String paramString1, long paramLong, String paramString2, com.tencent.mm.bx.b paramb, int paramInt)
    {
      AppMethodBeat.i(198201);
      this.KPM = paramString1;
      this.feedId = paramLong;
      this.KJv = paramString2;
      this.lastBuffer = paramb;
      this.pullType = paramInt;
      AppMethodBeat.o(198201);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.v
 * JD-Core Version:    0.7.0.1
 */