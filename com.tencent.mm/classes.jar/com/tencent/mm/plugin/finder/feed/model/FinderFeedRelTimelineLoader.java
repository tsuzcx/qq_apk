package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.feed.av;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.viewmodel.f;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.protocal.protobuf.chq;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.fvu;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "feedId", "", "nonceId", "", "tabType", "", "category", "relatedListScene", "hasMoreAfterInit", "", "sessionBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "get_column_feed_info", "Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;", "cardBuffer", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "loadScene", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "poiLatitude", "", "poiLongitude", "(JLjava/lang/String;ILjava/lang/String;IZLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/Stats;ILcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;FF)V", "getCardBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setCardBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getGet_column_feed_info", "()Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;", "setGet_column_feed_info", "(Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;)V", "getHasMoreAfterInit", "()Z", "setHasMoreAfterInit", "(Z)V", "isLoading", "setLoading", "loadMoreCallback", "getLoadMoreCallback", "setLoadMoreCallback", "getLoadScene", "()I", "setLoadScene", "(I)V", "getNonceId", "getPoiLatitude", "()F", "getPoiLongitude", "refreshCallback", "getRefreshCallback", "setRefreshCallback", "getRelatedListScene", "setRelatedListScene", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;)V", "getSessionBuffer", "setSessionBuffer", "getStats", "()Lcom/tencent/mm/protocal/protobuf/Stats;", "setStats", "(Lcom/tencent/mm/protocal/protobuf/Stats;)V", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "isObservePostEvent", "onFetchDone", "response", "onFetchInitDone", "initResponse", "onFetchLoadMoreDone", "onFetchRefreshDone", "FeedRelDataFetcher", "FinderFeedRelResponse", "FinderStreamCardDataFetcher", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderFeedRelTimelineLoader
  extends BaseFinderFeedLoader
{
  private com.tencent.mm.bx.b ACg;
  com.tencent.mm.bx.b AEA;
  final float AXq;
  final float AXr;
  public int BfR;
  public boolean BfS;
  chq BfT;
  fhp BfU;
  int BfV;
  public bav BfW;
  public kotlin.g.a.b<? super IResponse<cc>, ah> BfX;
  public kotlin.g.a.b<? super IResponse<cc>, ah> BfY;
  final long feedId;
  public kotlin.g.a.b<? super IResponse<cc>, ah> fetchEndCallback;
  final int hJx;
  boolean isLoading;
  public String kDf;
  final String nonceId;
  
  private FinderFeedRelTimelineLoader(long paramLong, String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean, chq paramchq, com.tencent.mm.bx.b paramb, fhp paramfhp, int paramInt3, bui parambui, float paramFloat1, float paramFloat2)
  {
    super(parambui);
    AppMethodBeat.i(366289);
    this.feedId = paramLong;
    this.nonceId = paramString1;
    this.hJx = paramInt1;
    this.kDf = paramString2;
    this.BfR = paramInt2;
    this.BfS = paramBoolean;
    this.ACg = null;
    this.BfT = paramchq;
    this.AEA = paramb;
    this.BfU = paramfhp;
    this.BfV = paramInt3;
    this.BfW = null;
    this.AXq = paramFloat1;
    this.AXr = paramFloat2;
    AppMethodBeat.o(366289);
  }
  
  public i<cc> createDataFetch()
  {
    AppMethodBeat.i(366303);
    i locali = (i)new a();
    AppMethodBeat.o(366303);
    return locali;
  }
  
  public boolean isObservePostEvent()
  {
    return true;
  }
  
  public void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366313);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(366313);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      kotlin.g.a.b localb = this.fetchEndCallback;
      if (localb != null) {
        localb.invoke(paramIResponse);
      }
    }
    AppMethodBeat.o(366313);
  }
  
  public void onFetchInitDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366322);
    kotlin.g.b.s.u(paramIResponse, "initResponse");
    super.onFetchInitDone(paramIResponse);
    if (!paramIResponse.getHasMore())
    {
      kotlin.g.a.b localb = this.fetchEndCallback;
      if (localb != null) {
        localb.invoke(paramIResponse);
      }
    }
    AppMethodBeat.o(366322);
  }
  
  public void onFetchLoadMoreDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366331);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchLoadMoreDone(paramIResponse);
    kotlin.g.a.b localb = this.BfY;
    if (localb != null) {
      localb.invoke(paramIResponse);
    }
    AppMethodBeat.o(366331);
  }
  
  public void onFetchRefreshDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366326);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchRefreshDone(paramIResponse);
    kotlin.g.a.b localb = this.BfX;
    if (localb != null) {
      localb.invoke(paramIResponse);
    }
    AppMethodBeat.o(366326);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FeedRelDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "isAuto", "", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public class a
    extends c
  {
    public a()
    {
      AppMethodBeat.i(366160);
      AppMethodBeat.o(366160);
    }
    
    public IResponse<cc> callInit()
    {
      Object localObject2 = null;
      AppMethodBeat.i(366225);
      FinderFeedRelTimelineLoader.b localb = new FinderFeedRelTimelineLoader.b("", 0, 0, "");
      FinderFeedRelTimelineLoader localFinderFeedRelTimelineLoader = this.BfZ;
      Object localObject1 = localFinderFeedRelTimelineLoader.getCache();
      if (localObject1 == null)
      {
        localObject1 = null;
        localb.setIncrementList((List)localObject1);
        localObject1 = localFinderFeedRelTimelineLoader.getCache();
        if (localObject1 != null) {
          break label95;
        }
      }
      label95:
      for (localObject1 = localObject2;; localObject1 = ((s)localObject1).lastBuffer)
      {
        localb.setLastBuffer((com.tencent.mm.bx.b)localObject1);
        localb.setHasMore(this.BfZ.BfS);
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(366225);
        return localObject1;
        localObject1 = ((s)localObject1).pUj;
        break;
      }
    }
    
    public IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(366216);
      kotlin.g.b.s.u(paramp, "scene");
      this.BfZ.isLoading = false;
      if ((paramp instanceof ch))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        for (boolean bool = ((ch)paramp).dVN();; bool = true)
        {
          localObject2 = ((ch)paramp).getWording();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          paramString = new FinderFeedRelTimelineLoader.b((String)localObject1, paramInt1, paramInt2, paramString);
          localObject2 = (Iterable)((ch)paramp).dVP();
          localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            Object localObject4 = FinderItem.Companion;
            localObject3 = FinderItem.a.e((FinderObject)localObject3, 256);
            localObject4 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
            ((Collection)localObject1).add(d.a.a((FinderItem)localObject3));
          }
        }
        Object localObject1 = new LinkedList((Collection)localObject1);
        Object localObject2 = ((ch)paramp).dVO().ZLK;
        kotlin.g.b.s.s(localObject2, "scene.getResponse().txt_card");
        Object localObject3 = (bwm)kotlin.a.p.oL((List)localObject2);
        if (localObject3 != null)
        {
          localObject2 = paramString.title;
          kotlin.g.b.s.u(localObject3, "<this>");
          kotlin.g.b.s.u(localObject2, "streamCardTitle");
          localObject3 = new av((bwm)localObject3);
          kotlin.g.b.s.u(localObject2, "<set-?>");
          ((av)localObject3).AZb = ((String)localObject2);
          ((LinkedList)localObject1).add(localObject3);
        }
        localObject2 = ah.aiuX;
        paramString.setIncrementList((List)localObject1);
        paramString.Bga.addAll((Collection)((ch)paramp).dVO().ZLJ);
        paramString.ACl = ((List)new LinkedList((Collection)((ch)paramp).dVP()));
        paramString.setPullType(((ch)paramp).pullType);
        paramString.setLastBuffer(((ch)paramp).dVJ());
        paramString.setHasMore(bool);
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        d.a.a((List)((ch)paramp).dVP(), 1, this.BfZ.getContextObj());
        paramString = (IResponse)paramString;
        AppMethodBeat.o(366216);
        return paramString;
      }
      AppMethodBeat.o(366216);
      return null;
    }
    
    public void fetch(Object paramObject, h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(366194);
      kotlin.g.b.s.u(paramh, "callback");
      this.BfZ.isLoading = true;
      super.fetch(paramObject, paramh, paramBoolean);
      AppMethodBeat.o(366194);
    }
    
    public com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(366181);
      Object localObject = new ch(this.BfZ.feedId, this.BfZ.nonceId, this.BfZ.hJx, this.BfZ.getLastBuffer(), this.BfZ.kDf, this.BfZ.BfR, null, null, null, this.BfZ.getContextObj(), this.BfZ.AXq, this.BfZ.AXr, 960);
      ((ch)localObject).pullType = 2;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(366181);
      return localObject;
    }
    
    public com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(366174);
      Object localObject = new ch(this.BfZ.feedId, this.BfZ.nonceId, this.BfZ.hJx, this.BfZ.getLastBuffer(), this.BfZ.kDf, this.BfZ.BfR, null, null, null, this.BfZ.getContextObj(), this.BfZ.AXq, this.BfZ.AXr, 960);
      ((ch)localObject).pullType = 0;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(366174);
      return localObject;
    }
    
    public List<Integer> getCmdIds()
    {
      AppMethodBeat.i(366165);
      List localList = kotlin.a.p.listOf(Integer.valueOf(3688));
      AppMethodBeat.o(366165);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "title", "", "errType", "", "errCode", "errMsg", "(Ljava/lang/String;IILjava/lang/String;)V", "cards", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "getCards", "()Ljava/util/LinkedList;", "setCards", "(Ljava/util/LinkedList;)V", "objectList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends IResponse<cc>
  {
    public List<? extends FinderObject> ACl;
    public LinkedList<bwa> Bga;
    public final String title;
    
    public b(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      super(paramInt2, paramString2);
      AppMethodBeat.i(366157);
      this.title = paramString1;
      this.Bga = new LinkedList();
      AppMethodBeat.o(366157);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderStreamCardDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FeedRelDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;)V", "dead", "", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "genStats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "read", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public class c
    extends FinderFeedRelTimelineLoader.a
  {
    public c()
    {
      super();
      AppMethodBeat.i(366153);
      AppMethodBeat.o(366153);
    }
    
    public void dead()
    {
      AppMethodBeat.i(366183);
      super.dead();
      k localk = k.aeZF;
      ((f)k.cn(PluginFinder.class).q(f.class)).vi(true);
      AppMethodBeat.o(366183);
    }
    
    public IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      long l2 = 0L;
      boolean bool2 = true;
      Object localObject1 = null;
      AppMethodBeat.i(366198);
      kotlin.g.b.s.u(paramp, "scene");
      IResponse localIResponse = super.dealOnSceneEnd(paramInt1, paramInt2, paramString, paramp);
      Object localObject2;
      boolean bool1;
      label169:
      long l1;
      if ((paramp instanceof ch))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject2 = k.aeZF;
          localObject2 = k.cn(PluginFinder.class).q(f.class);
          kotlin.g.b.s.s(localObject2, "UICProvider.of(PluginFin…StreamCardVM::class.java)");
          f.a((f)localObject2);
        }
        localObject2 = getTAG();
        paramString = new StringBuilder("[dealOnSceneEnd] errType=").append(paramInt1).append(" errCode=").append(paramString).append(" pullType=").append(((ch)paramp).pullType).append(" lastBuffer=");
        if (this.BfZ.getLastBuffer() == null) {
          break label297;
        }
        bool1 = true;
        paramString = paramString.append(bool1).append(" cardBuffer=");
        if (this.BfZ.AEA == null) {
          break label303;
        }
        bool1 = bool2;
        paramString = paramString.append(bool1).append(" stats=");
        paramp = this.BfZ.BfU;
        if (paramp != null) {
          break label309;
        }
        l1 = 0L;
        label198:
        paramString = paramString.append(com.tencent.mm.ae.d.hF(l1)).append(" get_column_feed_info=");
        paramp = this.BfZ.BfT;
        if (paramp != null) {
          break label319;
        }
        l1 = l2;
        label231:
        paramp = paramString.append(com.tencent.mm.ae.d.hF(l1)).append(" hasMore=");
        if (localIResponse != null) {
          break label329;
        }
        paramString = null;
        label254:
        paramp = paramp.append(paramString).append(" size=");
        if (localIResponse != null) {
          break label341;
        }
        paramString = localObject1;
      }
      for (;;)
      {
        Log.i((String)localObject2, paramString);
        AppMethodBeat.o(366198);
        return localIResponse;
        label297:
        bool1 = false;
        break;
        label303:
        bool1 = false;
        break label169;
        label309:
        l1 = paramp.hKN;
        break label198;
        label319:
        l1 = paramp.id;
        break label231;
        label329:
        paramString = Boolean.valueOf(localIResponse.getHasMore());
        break label254;
        label341:
        List localList = localIResponse.getIncrementList();
        paramString = localObject1;
        if (localList != null) {
          paramString = Integer.valueOf(localList.size());
        }
      }
    }
    
    public com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(366175);
      Object localObject1 = k.aeZF;
      Object localObject2 = (Iterable)((f)k.cn(PluginFinder.class).q(f.class)).fmO();
      localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        dmk localdmk = (dmk)((Iterator)localObject2).next();
        fhp localfhp = new fhp();
        localfhp.abIi = new fvu();
        localfhp.abIh = new ni();
        localfhp.abIj = new dzj();
        localfhp.hKN = localdmk.hKN;
        localfhp.AJo = localdmk.aaSt;
        localfhp.sessionBuffer = localdmk.sessionBuffer;
        localfhp.finderUsername = z.bAW();
        localfhp.abIk = cn.bDw();
        localfhp.mediaType = 11;
        ((Collection)localObject1).add(localfhp);
      }
      localObject1 = (List)localObject1;
      localObject1 = new ch(this.BfZ.getLastBuffer(), this.BfZ.BfV, (List)localObject1, this.BfZ.BfT, this.BfZ.getContextObj());
      ((ch)localObject1).pullType = 2;
      localObject1 = (com.tencent.mm.am.p)localObject1;
      AppMethodBeat.o(366175);
      return localObject1;
    }
    
    public com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(366162);
      com.tencent.mm.bx.b localb = this.BfZ.AEA;
      int i = this.BfZ.BfV;
      Object localObject = this.BfZ.BfU;
      if (localObject == null) {}
      for (localObject = null;; localObject = kotlin.a.p.listOf(localObject))
      {
        localObject = new ch(localb, i, (List)localObject, this.BfZ.BfT, this.BfZ.getContextObj());
        ((ch)localObject).pullType = 0;
        localObject = (com.tencent.mm.am.p)localObject;
        AppMethodBeat.o(366162);
        return localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader
 * JD-Core Version:    0.7.0.1
 */