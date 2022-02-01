package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bk;
import com.tencent.mm.plugin.finder.feed.ao;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.bjy;
import com.tencent.mm.protocal.protobuf.bsx;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.protocal.protobuf.ezq;
import com.tencent.mm.protocal.protobuf.mf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "feedId", "", "nonceId", "", "tabType", "", "category", "relatedListScene", "hasMoreAfterInit", "", "sessionBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "get_column_feed_info", "Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;", "cardBuffer", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "loadScene", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "poiLatitude", "", "poiLongitude", "(JLjava/lang/String;ILjava/lang/String;IZLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/Stats;ILcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;FF)V", "getCardBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setCardBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getGet_column_feed_info", "()Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;", "setGet_column_feed_info", "(Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;)V", "getHasMoreAfterInit", "()Z", "setHasMoreAfterInit", "(Z)V", "isLoading", "setLoading", "loadMoreCallback", "getLoadMoreCallback", "setLoadMoreCallback", "getLoadScene", "()I", "setLoadScene", "(I)V", "getNonceId", "getPoiLatitude", "()F", "getPoiLongitude", "refreshCallback", "getRefreshCallback", "setRefreshCallback", "getRelatedListScene", "setRelatedListScene", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;)V", "getSessionBuffer", "setSessionBuffer", "getStats", "()Lcom/tencent/mm/protocal/protobuf/Stats;", "setStats", "(Lcom/tencent/mm/protocal/protobuf/Stats;)V", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "isObservePostEvent", "onFetchDone", "response", "onFetchInitDone", "initResponse", "onFetchLoadMoreDone", "onFetchRefreshDone", "FeedRelDataFetcher", "FinderFeedRelResponse", "FinderStreamCardDataFetcher", "plugin-finder_release"})
public class FinderFeedRelTimelineLoader
  extends BaseFinderFeedLoader
{
  final int fEH;
  final long feedId;
  public kotlin.g.a.b<? super IResponse<bu>, x> fetchEndCallback;
  public String idV;
  boolean isLoading;
  final String nonceId;
  public kotlin.g.a.b<? super IResponse<bu>, x> xGJ;
  public kotlin.g.a.b<? super IResponse<bu>, x> xGK;
  public int xGL;
  public boolean xGM;
  bsx xGN;
  com.tencent.mm.cd.b xGO;
  emr xGP;
  int xGQ;
  public avr xGR;
  private com.tencent.mm.cd.b xcQ;
  final float xzR;
  final float xzS;
  
  private FinderFeedRelTimelineLoader(long paramLong, String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean, bsx parambsx, com.tencent.mm.cd.b paramb, emr paramemr, int paramInt3, bid parambid, float paramFloat1, float paramFloat2)
  {
    super(parambid);
    AppMethodBeat.i(269396);
    this.feedId = paramLong;
    this.nonceId = paramString1;
    this.fEH = paramInt1;
    this.idV = paramString2;
    this.xGL = paramInt2;
    this.xGM = paramBoolean;
    this.xcQ = null;
    this.xGN = parambsx;
    this.xGO = paramb;
    this.xGP = paramemr;
    this.xGQ = paramInt3;
    this.xGR = null;
    this.xzR = paramFloat1;
    this.xzS = paramFloat2;
    AppMethodBeat.o(269396);
  }
  
  public i<bu> createDataFetch()
  {
    AppMethodBeat.i(269388);
    i locali = (i)new a();
    AppMethodBeat.o(269388);
    return locali;
  }
  
  public boolean isObservePostEvent()
  {
    return true;
  }
  
  public void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(269389);
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(269389);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      kotlin.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(269389);
        return;
      }
    }
    AppMethodBeat.o(269389);
  }
  
  public void onFetchInitDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(269390);
    p.k(paramIResponse, "initResponse");
    super.onFetchInitDone(paramIResponse);
    if (!paramIResponse.getHasMore())
    {
      kotlin.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(269390);
        return;
      }
    }
    AppMethodBeat.o(269390);
  }
  
  public void onFetchLoadMoreDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(269392);
    p.k(paramIResponse, "response");
    super.onFetchLoadMoreDone(paramIResponse);
    kotlin.g.a.b localb = this.xGK;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(269392);
      return;
    }
    AppMethodBeat.o(269392);
  }
  
  public void onFetchRefreshDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(269391);
    p.k(paramIResponse, "response");
    super.onFetchRefreshDone(paramIResponse);
    kotlin.g.a.b localb = this.xGJ;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(269391);
      return;
    }
    AppMethodBeat.o(269391);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FeedRelDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public IResponse<bu> callInit()
    {
      Object localObject2 = null;
      AppMethodBeat.i(281568);
      FinderFeedRelTimelineLoader.b localb = new FinderFeedRelTimelineLoader.b("", 0, 0, "");
      Object localObject1 = this.xGS.getCache();
      if (localObject1 != null) {}
      for (localObject1 = ((q)localObject1).mXB;; localObject1 = null)
      {
        localb.setIncrementList((List)localObject1);
        q localq = this.xGS.getCache();
        localObject1 = localObject2;
        if (localq != null) {
          localObject1 = localq.lastBuffer;
        }
        localb.setLastBuffer((com.tencent.mm.cd.b)localObject1);
        localb.setHasMore(this.xGS.xGM);
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(281568);
        return localObject1;
      }
    }
    
    public IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(281567);
      p.k(paramq, "scene");
      this.xGS.isLoading = false;
      if ((paramq instanceof bk))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        for (boolean bool = ((bk)paramq).dod();; bool = true)
        {
          localObject2 = ((bk)paramq).getWording();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          paramString = new FinderFeedRelTimelineLoader.b((String)localObject1, paramInt1, paramInt2, paramString);
          localObject2 = (Iterable)((bk)paramq).dof();
          localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            Object localObject4 = FinderItem.Companion;
            localObject3 = FinderItem.a.b((FinderObject)localObject3, 256);
            localObject4 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
            ((Collection)localObject1).add(c.a.a((FinderItem)localObject3));
          }
        }
        Object localObject1 = new LinkedList((Collection)localObject1);
        Object localObject2 = ((bk)paramq).doe().SIg;
        p.j(localObject2, "scene.getResponse().txt_card");
        Object localObject3 = (bjy)j.lp((List)localObject2);
        if (localObject3 != null)
        {
          localObject2 = paramString.title;
          p.k(localObject3, "$this$toRVFeed");
          p.k(localObject2, "streamCardTitle");
          localObject3 = new ao((bjy)localObject3);
          p.k(localObject2, "<set-?>");
          ((ao)localObject3).xBM = ((String)localObject2);
          ((LinkedList)localObject1).add(localObject3);
        }
        paramString.setIncrementList((List)localObject1);
        paramString.xGT.addAll((Collection)((bk)paramq).doe().SIf);
        paramString.xcV = ((List)new LinkedList((Collection)((bk)paramq).dof()));
        paramString.setPullType(((bk)paramq).pullType);
        paramString.setLastBuffer(((bk)paramq).doa());
        paramString.setHasMore(bool);
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        c.a.a((List)((bk)paramq).dof(), 1, this.xGS.getContextObj());
        paramString = (IResponse)paramString;
        AppMethodBeat.o(281567);
        return paramString;
      }
      AppMethodBeat.o(281567);
      return null;
    }
    
    public void fetch(Object paramObject, h<bu> paramh)
    {
      AppMethodBeat.i(281566);
      p.k(paramh, "callback");
      this.xGS.isLoading = true;
      super.fetch(paramObject, paramh);
      AppMethodBeat.o(281566);
    }
    
    public com.tencent.mm.an.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(281565);
      Object localObject = new bk(this.xGS.feedId, this.xGS.nonceId, this.xGS.fEH, this.xGS.getLastBuffer(), this.xGS.idV, this.xGS.xGL, null, null, null, this.xGS.getContextObj(), this.xGS.xzR, this.xGS.xzS, 960);
      ((bk)localObject).pullType = 2;
      localObject = (com.tencent.mm.an.q)localObject;
      AppMethodBeat.o(281565);
      return localObject;
    }
    
    public com.tencent.mm.an.q genRefreshNetScene()
    {
      AppMethodBeat.i(281564);
      Object localObject = new bk(this.xGS.feedId, this.xGS.nonceId, this.xGS.fEH, this.xGS.getLastBuffer(), this.xGS.idV, this.xGS.xGL, null, null, null, this.xGS.getContextObj(), this.xGS.xzR, this.xGS.xzS, 960);
      ((bk)localObject).pullType = 0;
      localObject = (com.tencent.mm.an.q)localObject;
      AppMethodBeat.o(281564);
      return localObject;
    }
    
    public List<Integer> getCmdIds()
    {
      AppMethodBeat.i(281563);
      List localList = j.listOf(Integer.valueOf(3688));
      AppMethodBeat.o(281563);
      return localList;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "title", "", "errType", "", "errCode", "errMsg", "(Ljava/lang/String;IILjava/lang/String;)V", "cards", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "getCards", "()Ljava/util/LinkedList;", "setCards", "(Ljava/util/LinkedList;)V", "objectList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class b
    extends IResponse<bu>
  {
    public final String title;
    public LinkedList<bjp> xGT;
    public List<? extends FinderObject> xcV;
    
    public b(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      super(paramInt2, paramString2);
      AppMethodBeat.i(271031);
      this.title = paramString1;
      this.xGT = new LinkedList();
      AppMethodBeat.o(271031);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderStreamCardDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FeedRelDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;)V", "dead", "", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "genStats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "read", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "plugin-finder_release"})
  public class c
    extends FinderFeedRelTimelineLoader.a
  {
    public c()
    {
      super();
    }
    
    public void dead()
    {
      AppMethodBeat.i(284995);
      super.dead();
      g localg = g.Xox;
      ((com.tencent.mm.plugin.finder.viewmodel.d)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.d.class)).rz(true);
      AppMethodBeat.o(284995);
    }
    
    public IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      Object localObject1 = null;
      boolean bool2 = true;
      AppMethodBeat.i(284996);
      p.k(paramq, "scene");
      IResponse localIResponse = super.dealOnSceneEnd(paramInt1, paramInt2, paramString, paramq);
      Object localObject2;
      boolean bool1;
      label160:
      long l;
      if ((paramq instanceof bk))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject2 = g.Xox;
          com.tencent.mm.plugin.finder.viewmodel.d.a((com.tencent.mm.plugin.finder.viewmodel.d)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.d.class));
        }
        localObject2 = getTAG();
        paramString = new StringBuilder("[dealOnSceneEnd] errType=").append(paramInt1).append(" errCode=").append(paramString).append(" pullType=").append(((bk)paramq).pullType).append(' ').append("lastBuffer=");
        if (this.xGS.getLastBuffer() == null) {
          break label338;
        }
        bool1 = true;
        paramString = paramString.append(bool1).append(" cardBuffer=");
        if (this.xGS.xGO == null) {
          break label344;
        }
        bool1 = bool2;
        paramString = paramString.append(bool1).append(' ').append("stats=");
        paramq = this.xGS.xGP;
        if (paramq == null) {
          break label350;
        }
        l = paramq.xbk;
        label198:
        paramString = paramString.append(com.tencent.mm.ae.d.Fw(l)).append(" get_column_feed_info=");
        paramq = this.xGS.xGN;
        if (paramq == null) {
          break label356;
        }
        l = paramq.id;
        label234:
        paramq = paramString.append(com.tencent.mm.ae.d.Fw(l)).append(' ').append("hasMore=");
        if (localIResponse == null) {
          break label362;
        }
      }
      label338:
      label344:
      label350:
      label356:
      label362:
      for (paramString = Boolean.valueOf(localIResponse.getHasMore());; paramString = null)
      {
        paramq = paramq.append(paramString).append(" size=");
        paramString = localObject1;
        if (localIResponse != null)
        {
          List localList = localIResponse.getIncrementList();
          paramString = localObject1;
          if (localList != null) {
            paramString = Integer.valueOf(localList.size());
          }
        }
        Log.i((String)localObject2, paramString);
        AppMethodBeat.o(284996);
        return localIResponse;
        bool1 = false;
        break;
        bool1 = false;
        break label160;
        l = 0L;
        break label198;
        l = 0L;
        break label234;
      }
    }
    
    public com.tencent.mm.an.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(284993);
      Object localObject1 = g.Xox;
      Object localObject2 = (Iterable)((com.tencent.mm.plugin.finder.viewmodel.d)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.d.class)).ekd();
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        cve localcve = (cve)((Iterator)localObject2).next();
        emr localemr = new emr();
        localemr.Upk = new ezq();
        localemr.Upj = new mf();
        localemr.Upl = new dhb();
        localemr.xbk = localcve.xbk;
        localemr.xkX = localcve.TCM;
        localemr.sessionBuffer = localcve.sessionBuffer;
        localemr.finderUsername = z.bdh();
        localemr.Upm = cm.bfE();
        localemr.mediaType = 11;
        ((Collection)localObject1).add(localemr);
      }
      localObject1 = (List)localObject1;
      localObject1 = new bk(this.xGS.getLastBuffer(), this.xGS.xGQ, (List)localObject1, this.xGS.xGN, this.xGS.getContextObj());
      ((bk)localObject1).pullType = 2;
      localObject1 = (com.tencent.mm.an.q)localObject1;
      AppMethodBeat.o(284993);
      return localObject1;
    }
    
    public com.tencent.mm.an.q genRefreshNetScene()
    {
      AppMethodBeat.i(284991);
      com.tencent.mm.cd.b localb = this.xGS.xGO;
      int i = this.xGS.xGQ;
      Object localObject = this.xGS.xGP;
      if (localObject != null) {}
      for (localObject = j.listOf(localObject);; localObject = null)
      {
        localObject = new bk(localb, i, (List)localObject, this.xGS.xGN, this.xGS.getContextObj());
        ((bk)localObject).pullType = 0;
        localObject = (com.tencent.mm.an.q)localObject;
        AppMethodBeat.o(284991);
        return localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader
 * JD-Core Version:    0.7.0.1
 */