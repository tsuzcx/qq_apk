package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.ai;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.alf;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "tabType", "", "commentScene", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IIFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "TAG$1", "getCommentScene", "()I", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getLat", "()F", "getLng", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "response", "requestLoadMore", "requestRefresh", "Companion", "FinderFeedRelInit", "FinderFeedRelListData", "FinderFeedRelRequest", "FinderFeedRelResponse", "plugin-finder_release"})
public final class l
  extends BaseFinderFeedLoader
{
  private static final String TAG = "Finder.FinderRelatedLoader";
  private static final ConcurrentHashMap<Long, l.a.a> rnf;
  public static final a rng;
  private final int diw;
  private String fOO;
  private final float hEE;
  private final float hEF;
  public com.tencent.mm.bw.b lastBuffer;
  private final anu qYj;
  private final int rfR;
  public d.g.a.b<? super IResponse<BaseFinderFeed>, y> rmE;
  
  static
  {
    AppMethodBeat.i(202205);
    rng = new a((byte)0);
    TAG = "Finder.FinderRelatedLoader";
    rnf = new ConcurrentHashMap();
    AppMethodBeat.o(202205);
  }
  
  public l(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, anu paramanu, anm paramanm)
  {
    super(null, paramanm, 1, null);
    AppMethodBeat.i(202204);
    this.diw = paramInt1;
    this.rfR = paramInt2;
    this.hEF = paramFloat1;
    this.hEE = paramFloat2;
    this.qYj = paramanu;
    this.fOO = "Finder.FinderRelatedLoader";
    AppMethodBeat.o(202204);
  }
  
  public final e<Object, Object, h> createDataFetch(anm paramanm)
  {
    AppMethodBeat.i(202200);
    paramanm = (e)new c(paramanm);
    AppMethodBeat.o(202200);
    return paramanm;
  }
  
  public final String getTAG()
  {
    return this.fOO;
  }
  
  public final void onFetchDone(IResponse<BaseFinderFeed> paramIResponse)
  {
    AppMethodBeat.i(202203);
    k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if ((paramIResponse instanceof e)) {
      this.lastBuffer = paramIResponse.getLastBuffer();
    }
    if (!paramIResponse.getHasMore())
    {
      d.g.a.b localb = this.rmE;
      if (localb != null)
      {
        localb.ay(paramIResponse);
        AppMethodBeat.o(202203);
        return;
      }
    }
    AppMethodBeat.o(202203);
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(202202);
    d locald = new d(this.hEF, this.hEE, this.qYj, this.diw, this.lastBuffer);
    ac.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((i)locald);
    AppMethodBeat.o(202202);
  }
  
  public final void requestRefresh() {}
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(202201);
    k.h(paramString, "<set-?>");
    this.fOO = paramString;
    AppMethodBeat.o(202201);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$Companion;", "", "()V", "TAG", "", "relatedDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$Companion$RelatedFeedCache;", "getRelatedDataCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "clearCache", "", "getCache", "id", "putCache", "dataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "RelatedFeedCache", "plugin-finder_release"})
  public static final class a
  {
    public static void a(long paramLong, List<? extends BaseFinderFeed> paramList, com.tencent.mm.bw.b paramb)
    {
      AppMethodBeat.i(202190);
      k.h(paramList, "dataList");
      ac.i(l.access$getTAG$cp(), "putCache " + paramLong + ", list size:" + paramList.size());
      List localList = (List)new ArrayList();
      localList.addAll((Collection)paramList);
      l.cvE().put(Long.valueOf(paramLong), new l.a.a(localList, paramb));
      AppMethodBeat.o(202190);
    }
    
    public static void clearCache()
    {
      AppMethodBeat.i(202191);
      ac.i(l.access$getTAG$cp(), "clearCache");
      l.cvE().clear();
      AppMethodBeat.o(202191);
    }
    
    public static l.a.a uo(long paramLong)
    {
      AppMethodBeat.i(202192);
      ac.i(l.access$getTAG$cp(), "getCache " + paramLong + ", exist:" + l.cvE().containsKey(Long.valueOf(paramLong)));
      l.a.a locala2 = (l.a.a)l.cvE().get(Long.valueOf(paramLong));
      l.a.a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new l.a.a((List)new ArrayList(), null);
      }
      AppMethodBeat.o(202192);
      return locala1;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "initDataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "cacheId", "", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(Ljava/util/List;JLcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "getCacheId", "()J", "getInitDataList", "()Ljava/util/List;", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.g
  {
    final long rhr;
    final List<BaseFinderFeed> rjv;
    
    public b(List<? extends BaseFinderFeed> paramList, long paramLong, f paramf)
    {
      super();
      AppMethodBeat.i(202193);
      this.rjv = paramList;
      this.rhr = paramLong;
      AppMethodBeat.o(202193);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelListData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelInit;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class c
    extends e<l.b, l.d, BaseFinderFeed>
    implements com.tencent.mm.ak.g
  {
    private final String TAG = "Finder.FinderFeedRelListData";
    private d<BaseFinderFeed> rmL;
    
    public c(anm paramanm)
    {
      super();
    }
    
    public final void alive()
    {
      AppMethodBeat.i(202195);
      com.tencent.mm.kernel.g.agi().a(3688, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(202195);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(202196);
      com.tencent.mm.kernel.g.agi().b(3688, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(202196);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      Object localObject1 = null;
      AppMethodBeat.i(202197);
      if ((paramn instanceof ai))
      {
        Object localObject2;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject2 = ((ai)paramn).rr;
          if (localObject2 == null) {
            k.aVY("rr");
          }
          localObject2 = ((com.tencent.mm.ak.b)localObject2).aBD();
          if (localObject2 == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
            AppMethodBeat.o(202197);
            throw paramString;
          }
          if (((alf)localObject2).continueFlag != 0) {}
        }
        for (boolean bool = false;; bool = true)
        {
          localObject2 = new l.e(paramInt1, paramInt2, paramString);
          localObject3 = (Iterable)((ai)paramn).csr();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (FinderObject)((Iterator)localObject3).next();
            localObject5 = FinderItem.rDA;
            localObject4 = FinderItem.a.a((FinderObject)localObject4, 256);
            localObject5 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
            paramString.add(b.a.i((FinderItem)localObject4));
          }
        }
        ((l.e)localObject2).setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
        b.a.a((List)((ai)paramn).csr(), 1, false, null, true, this.contextObj, 40);
        Object localObject3 = this.TAG;
        Object localObject4 = new StringBuilder("incrementList size: ");
        Object localObject5 = ((l.e)localObject2).getIncrementList();
        paramString = localObject1;
        if (localObject5 != null) {
          paramString = Integer.valueOf(((List)localObject5).size());
        }
        ac.i((String)localObject3, paramString);
        ((l.e)localObject2).setPullType(((ai)paramn).pullType);
        paramString = ((ai)paramn).rr;
        if (paramString == null) {
          k.aVY("rr");
        }
        paramString = paramString.aBD();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
          AppMethodBeat.o(202197);
          throw paramString;
        }
        ((l.e)localObject2).setLastBuffer(((alf)paramString).lastBuffer);
        ((l.e)localObject2).setHasMore(bool);
        paramString = this.rmL;
        if (paramString != null)
        {
          paramString.onFetchDone((IResponse)localObject2);
          AppMethodBeat.o(202197);
          return;
        }
      }
      AppMethodBeat.o(202197);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "tabType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "(FFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;ILcom/tencent/mm/protobuf/ByteString;I)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getLat", "()F", "getLng", "getPullType", "()I", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "plugin-finder_release"})
  public static final class d
    implements i
  {
    final int diw;
    final float hEE;
    final float hEF;
    final com.tencent.mm.bw.b lastBuffer;
    final int pullType;
    final anu qYj;
    
    public d(float paramFloat1, float paramFloat2, anu paramanu, int paramInt, com.tencent.mm.bw.b paramb)
    {
      AppMethodBeat.i(202199);
      this.hEF = paramFloat1;
      this.hEE = paramFloat2;
      this.qYj = paramanu;
      this.diw = paramInt;
      this.lastBuffer = paramb;
      this.pullType = 2;
      AppMethodBeat.o(202199);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class e
    extends IResponse<BaseFinderFeed>
  {
    public e(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.l
 * JD-Core Version:    0.7.0.1
 */