package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.cgi.av;
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
import com.tencent.mm.protocal.protobuf.dza;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "tabType", "", "commentScene", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IIFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "TAG$1", "getCommentScene", "()I", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getLat", "()F", "getLng", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "response", "requestLoadMore", "requestRefresh", "Companion", "FinderFeedRelInit", "FinderFeedRelListData", "FinderFeedRelRequest", "FinderFeedRelResponse", "plugin-finder_release"})
public final class z
  extends BaseFinderFeedLoader
{
  private static final ConcurrentHashMap<Long, z.a.a> KQk;
  public static final a KQl;
  private static final String TAG = "Finder.FinderRelatedLoader";
  private final int IoU;
  private final dzq KJJ;
  public d.g.a.b<? super IResponse<BaseFinderFeed>, y> KPL;
  private String fLc;
  private final float heb;
  private final float hec;
  public com.tencent.mm.bx.b lastBuffer;
  private final int qqE;
  
  static
  {
    AppMethodBeat.i(198295);
    KQl = new a((byte)0);
    TAG = "Finder.FinderRelatedLoader";
    KQk = new ConcurrentHashMap();
    AppMethodBeat.o(198295);
  }
  
  public z(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, dzq paramdzq, dzp paramdzp)
  {
    super(null, paramdzp, 1, null);
    AppMethodBeat.i(198294);
    this.IoU = paramInt1;
    this.qqE = paramInt2;
    this.hec = paramFloat1;
    this.heb = paramFloat2;
    this.KJJ = paramdzq;
    this.fLc = "Finder.FinderRelatedLoader";
    AppMethodBeat.o(198294);
  }
  
  public final f<Object, Object, i> createDataFetch(dzp paramdzp)
  {
    AppMethodBeat.i(198290);
    paramdzp = (f)new c(paramdzp);
    AppMethodBeat.o(198290);
    return paramdzp;
  }
  
  public final String getTAG()
  {
    return this.fLc;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(198293);
    k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse instanceof e)) {
      this.lastBuffer = paramIResponse.getLastBuffer();
    }
    if (!paramIResponse.getHasMore())
    {
      d.g.a.b localb = this.KPL;
      if (localb != null)
      {
        localb.aA(paramIResponse);
        AppMethodBeat.o(198293);
        return;
      }
    }
    AppMethodBeat.o(198293);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(198292);
    d locald = new d(this.hec, this.heb, this.KJJ, this.IoU, this.lastBuffer);
    ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)locald);
    AppMethodBeat.o(198292);
  }
  
  public final void requestRefresh() {}
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(198291);
    k.h(paramString, "<set-?>");
    this.fLc = paramString;
    AppMethodBeat.o(198291);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$Companion;", "", "()V", "TAG", "", "relatedDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$Companion$RelatedFeedCache;", "getRelatedDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearCache", "", "getCache", "id", "putCache", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "RelatedFeedCache", "plugin-finder_release"})
  public static final class a
  {
    public static a BM(long paramLong)
    {
      AppMethodBeat.i(198282);
      ad.i(z.access$getTAG$cp(), "getCache " + paramLong + ", exist:" + z.fTz().containsKey(Long.valueOf(paramLong)));
      a locala2 = (a)z.fTz().get(Long.valueOf(paramLong));
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a((List)new ArrayList(), null);
      }
      AppMethodBeat.o(198282);
      return locala1;
    }
    
    public static void a(long paramLong, List<? extends BaseFinderFeed> paramList, com.tencent.mm.bx.b paramb)
    {
      AppMethodBeat.i(198280);
      k.h(paramList, "dataList");
      ad.i(z.access$getTAG$cp(), "putCache " + paramLong + ", list size:" + paramList.size());
      List localList = (List)new ArrayList();
      localList.addAll((Collection)paramList);
      z.fTz().put(Long.valueOf(paramLong), new a(localList, paramb));
      AppMethodBeat.o(198280);
    }
    
    public static void clearCache()
    {
      AppMethodBeat.i(198281);
      ad.i(z.access$getTAG$cp(), "clearCache");
      z.fTz().clear();
      AppMethodBeat.o(198281);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$Companion$RelatedFeedCache;", "", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/util/List;Lcom/tencent/mm/protobuf/ByteString;)V", "getDataList", "()Ljava/util/List;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class a
    {
      public final List<BaseFinderFeed> dataList;
      public final com.tencent.mm.bx.b lastBuffer;
      
      public a(List<? extends BaseFinderFeed> paramList, com.tencent.mm.bx.b paramb)
      {
        AppMethodBeat.i(198276);
        this.dataList = paramList;
        this.lastBuffer = paramb;
        AppMethodBeat.o(198276);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(198279);
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
          AppMethodBeat.o(198279);
          return true;
        }
        AppMethodBeat.o(198279);
        return false;
      }
      
      public final int hashCode()
      {
        int j = 0;
        AppMethodBeat.i(198278);
        Object localObject = this.dataList;
        if (localObject != null) {}
        for (int i = localObject.hashCode();; i = 0)
        {
          localObject = this.lastBuffer;
          if (localObject != null) {
            j = localObject.hashCode();
          }
          AppMethodBeat.o(198278);
          return i * 31 + j;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(198277);
        String str = "RelatedFeedCache(dataList=" + this.dataList + ", lastBuffer=" + this.lastBuffer + ")";
        AppMethodBeat.o(198277);
        return str;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "initDataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "cacheId", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(Ljava/util/List;JLcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "getCacheId", "()J", "getInitDataList", "()Ljava/util/List;", "plugin-finder_release"})
  public static final class b
    extends h
  {
    final List<BaseFinderFeed> KNU;
    final long qxT;
    
    public b(List<? extends BaseFinderFeed> paramList, long paramLong, com.tencent.mm.plugin.finder.feed.model.internal.g paramg)
    {
      super();
      AppMethodBeat.i(198283);
      this.KNU = paramList;
      this.qxT = paramLong;
      AppMethodBeat.o(198283);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelListData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelInit;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class c
    extends f<z.b, z.d, BaseFinderFeed>
    implements com.tencent.mm.al.g
  {
    private e<BaseFinderFeed> KPR;
    private final String TAG = "Finder.FinderFeedRelListData";
    
    public c(dzp paramdzp)
    {
      super();
    }
    
    public final void alive()
    {
      AppMethodBeat.i(198285);
      com.tencent.mm.kernel.g.aeS().a(3688, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(198285);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(198286);
      com.tencent.mm.kernel.g.aeS().b(3688, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(198286);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      Object localObject1 = null;
      AppMethodBeat.i(198287);
      if ((paramn instanceof av))
      {
        Object localObject2;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject2 = ((av)paramn).rr;
          if (localObject2 == null) {
            k.aPZ("rr");
          }
          localObject2 = ((com.tencent.mm.al.b)localObject2).auM();
          if (localObject2 == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
            AppMethodBeat.o(198287);
            throw paramString;
          }
          if (((dza)localObject2).continueFlag != 0) {}
        }
        for (boolean bool = false;; bool = true)
        {
          localObject2 = new z.e(paramInt1, paramInt2, paramString);
          localObject3 = (Iterable)((av)paramn).fRV();
          paramString = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (FinderObject)((Iterator)localObject3).next();
            localObject5 = FinderItem.qJU;
            localObject4 = FinderItem.a.a((FinderObject)localObject4, 256);
            localObject5 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
            paramString.add(b.a.h((FinderItem)localObject4));
          }
        }
        ((z.e)localObject2).setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
        b.a.a((List)((av)paramn).fRV(), 1, false, null, true, this.contextObj, 40);
        Object localObject3 = this.TAG;
        Object localObject4 = new StringBuilder("incrementList size: ");
        Object localObject5 = ((z.e)localObject2).getIncrementList();
        paramString = localObject1;
        if (localObject5 != null) {
          paramString = Integer.valueOf(((List)localObject5).size());
        }
        ad.i((String)localObject3, paramString);
        ((z.e)localObject2).setPullType(((av)paramn).pullType);
        paramString = ((av)paramn).rr;
        if (paramString == null) {
          k.aPZ("rr");
        }
        paramString = paramString.auM();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
          AppMethodBeat.o(198287);
          throw paramString;
        }
        ((z.e)localObject2).setLastBuffer(((dza)paramString).lastBuffer);
        ((z.e)localObject2).setHasMore(bool);
        paramString = this.KPR;
        if (paramString != null)
        {
          paramString.onFetchDone((IResponse)localObject2);
          AppMethodBeat.o(198287);
          return;
        }
      }
      AppMethodBeat.o(198287);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "(FFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;ILcom/tencent/mm/protobuf/ByteString;I)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLat", "()F", "getLng", "getPullType", "()I", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    final int IoU;
    final dzq KJJ;
    final float heb;
    final float hec;
    final com.tencent.mm.bx.b lastBuffer;
    final int pullType;
    
    public d(float paramFloat1, float paramFloat2, dzq paramdzq, int paramInt, com.tencent.mm.bx.b paramb)
    {
      AppMethodBeat.i(198289);
      this.hec = paramFloat1;
      this.heb = paramFloat2;
      this.KJJ = paramdzq;
      this.IoU = paramInt;
      this.lastBuffer = paramb;
      this.pullType = 2;
      AppMethodBeat.o(198289);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
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
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.z
 * JD-Core Version:    0.7.0.1
 */