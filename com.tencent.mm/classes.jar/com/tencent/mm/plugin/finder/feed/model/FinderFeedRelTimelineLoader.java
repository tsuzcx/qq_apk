package com.tencent.mm.plugin.finder.feed.model;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.feed.ah;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bdb;
import com.tencent.mm.protocal.protobuf.blo;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "feedId", "", "nonceId", "", "tabType", "", "category", "relatedListScene", "hasMoreAfterInit", "", "sessionBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "get_column_feed_info", "Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;", "cardBuffer", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "loadScene", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;ILjava/lang/String;IZLcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/Stats;ILcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getCardBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setCardBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getGet_column_feed_info", "()Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;", "setGet_column_feed_info", "(Lcom/tencent/mm/protocal/protobuf/GetColumnFeedInfo;)V", "getHasMoreAfterInit", "()Z", "setHasMoreAfterInit", "(Z)V", "isLoading", "setLoading", "loadMoreCallback", "getLoadMoreCallback", "setLoadMoreCallback", "getLoadScene", "()I", "setLoadScene", "(I)V", "getNonceId", "refreshCallback", "getRefreshCallback", "setRefreshCallback", "getRelatedListScene", "setRelatedListScene", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;)V", "getSessionBuffer", "setSessionBuffer", "getStats", "()Lcom/tencent/mm/protocal/protobuf/Stats;", "setStats", "(Lcom/tencent/mm/protocal/protobuf/Stats;)V", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "isObservePostEvent", "onFetchDone", "response", "onFetchInitDone", "initResponse", "onFetchLoadMoreDone", "onFetchRefreshDone", "FeedRelDataFetcher", "FinderFeedRelResponse", "FinderStreamCardDataFetcher", "plugin-finder_release"})
public class FinderFeedRelTimelineLoader
  extends BaseFinderFeedLoader
{
  public String category;
  final int dLS;
  final long feedId;
  public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
  final String hwg;
  boolean isLoading;
  public kotlin.g.a.b<? super IResponse<bo>, x> tVa;
  public kotlin.g.a.b<? super IResponse<bo>, x> tVb;
  public boolean tVc;
  blo tVd;
  com.tencent.mm.bw.b tVe;
  ecq tVf;
  int tVg;
  public ato tta;
  public int ttb;
  private com.tencent.mm.bw.b tvj;
  
  private FinderFeedRelTimelineLoader(long paramLong, String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean, blo paramblo, com.tencent.mm.bw.b paramb, ecq paramecq, int paramInt3, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(244603);
    this.feedId = paramLong;
    this.hwg = paramString1;
    this.dLS = paramInt1;
    this.category = paramString2;
    this.ttb = paramInt2;
    this.tVc = paramBoolean;
    this.tvj = null;
    this.tVd = paramblo;
    this.tVe = paramb;
    this.tVf = paramecq;
    this.tVg = paramInt3;
    this.tta = null;
    AppMethodBeat.o(244603);
  }
  
  public g<bo> createDataFetch()
  {
    AppMethodBeat.i(244598);
    g localg = (g)new a();
    AppMethodBeat.o(244598);
    return localg;
  }
  
  public boolean isObservePostEvent()
  {
    return true;
  }
  
  public void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244599);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(244599);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      kotlin.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(244599);
        return;
      }
    }
    AppMethodBeat.o(244599);
  }
  
  public void onFetchInitDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244600);
    p.h(paramIResponse, "initResponse");
    super.onFetchInitDone(paramIResponse);
    if (!paramIResponse.getHasMore())
    {
      kotlin.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(244600);
        return;
      }
    }
    AppMethodBeat.o(244600);
  }
  
  public void onFetchLoadMoreDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244602);
    p.h(paramIResponse, "response");
    super.onFetchLoadMoreDone(paramIResponse);
    kotlin.g.a.b localb = this.tVb;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(244602);
      return;
    }
    AppMethodBeat.o(244602);
  }
  
  public void onFetchRefreshDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244601);
    p.h(paramIResponse, "response");
    super.onFetchRefreshDone(paramIResponse);
    kotlin.g.a.b localb = this.tVa;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(244601);
      return;
    }
    AppMethodBeat.o(244601);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FeedRelDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public IResponse<bo> callInit()
    {
      Object localObject2 = null;
      AppMethodBeat.i(244592);
      FinderFeedRelTimelineLoader.b localb = new FinderFeedRelTimelineLoader.b("", 0, 0, "");
      Object localObject1 = this.tVh.getCache();
      if (localObject1 != null) {}
      for (localObject1 = ((h)localObject1).kgc;; localObject1 = null)
      {
        localb.setIncrementList((List)localObject1);
        h localh = this.tVh.getCache();
        localObject1 = localObject2;
        if (localh != null) {
          localObject1 = localh.lastBuffer;
        }
        localb.setLastBuffer((com.tencent.mm.bw.b)localObject1);
        localb.setHasMore(this.tVh.tVc);
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(244592);
        return localObject1;
      }
    }
    
    public IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(244591);
      p.h(paramq, "scene");
      this.tVh.isLoading = false;
      if ((paramq instanceof bh))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        for (boolean bool = ((bh)paramq).cYp();; bool = true)
        {
          localObject2 = ((bh)paramq).getWording();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          paramString = new FinderFeedRelTimelineLoader.b((String)localObject1, paramInt1, paramInt2, paramString);
          localObject2 = (Iterable)((bh)paramq).cYr();
          localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            Object localObject4 = FinderItem.Companion;
            localObject3 = FinderItem.a.a((FinderObject)localObject3, 256);
            localObject4 = c.vGN;
            ((Collection)localObject1).add(c.a.s((FinderItem)localObject3));
          }
        }
        Object localObject1 = new LinkedList((Collection)localObject1);
        Object localObject2 = ((bh)paramq).cYq().LEz;
        p.g(localObject2, "scene.getResponse().txt_card");
        Object localObject3 = (bdb)j.kt((List)localObject2);
        if (localObject3 != null)
        {
          localObject2 = paramString.title;
          p.h(localObject3, "$this$toRVFeed");
          p.h(localObject2, "streamCardTitle");
          localObject3 = new ah((bdb)localObject3);
          p.h(localObject2, "<set-?>");
          ((ah)localObject3).tQV = ((String)localObject2);
          ((LinkedList)localObject1).add(localObject3);
        }
        paramString.setIncrementList((List)localObject1);
        paramString.tVi.addAll((Collection)((bh)paramq).cYq().LEy);
        paramString.tvo = ((List)new LinkedList((Collection)((bh)paramq).cYr()));
        paramString.setPullType(((bh)paramq).pullType);
        paramString.setLastBuffer(((bh)paramq).cYm());
        paramString.setHasMore(bool);
        localObject1 = c.vGN;
        c.a.a((List)((bh)paramq).cYr(), 1, this.tVh.getContextObj());
        paramString = (IResponse)paramString;
        AppMethodBeat.o(244591);
        return paramString;
      }
      AppMethodBeat.o(244591);
      return null;
    }
    
    public void fetch(Object paramObject, f<bo> paramf)
    {
      AppMethodBeat.i(244590);
      p.h(paramf, "callback");
      this.tVh.isLoading = true;
      super.fetch(paramObject, paramf);
      AppMethodBeat.o(244590);
    }
    
    public q genLoadMoreNetScene()
    {
      AppMethodBeat.i(244589);
      Object localObject = new bh(this.tVh.feedId, this.tVh.hwg, this.tVh.dLS, this.tVh.getLastBuffer(), this.tVh.category, this.tVh.ttb, null, null, null, this.tVh.getContextObj(), 960);
      ((bh)localObject).pullType = 2;
      localObject = (q)localObject;
      AppMethodBeat.o(244589);
      return localObject;
    }
    
    public q genRefreshNetScene()
    {
      AppMethodBeat.i(244588);
      Object localObject = new bh(this.tVh.feedId, this.tVh.hwg, this.tVh.dLS, this.tVh.getLastBuffer(), this.tVh.category, this.tVh.ttb, null, null, null, this.tVh.getContextObj(), 960);
      ((bh)localObject).pullType = 0;
      localObject = (q)localObject;
      AppMethodBeat.o(244588);
      return localObject;
    }
    
    public List<Integer> getCmdIds()
    {
      AppMethodBeat.i(244587);
      List localList = j.listOf(Integer.valueOf(3688));
      AppMethodBeat.o(244587);
      return localList;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "title", "", "errType", "", "errCode", "errMsg", "(Ljava/lang/String;IILjava/lang/String;)V", "cards", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "getCards", "()Ljava/util/LinkedList;", "setCards", "(Ljava/util/LinkedList;)V", "objectList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class b
    extends IResponse<bo>
  {
    public LinkedList<bcu> tVi;
    public final String title;
    public List<? extends FinderObject> tvo;
    
    public b(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      super(paramInt2, paramString2);
      AppMethodBeat.i(244593);
      this.title = paramString1;
      this.tVi = new LinkedList();
      AppMethodBeat.o(244593);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderStreamCardDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FeedRelDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;)V", "dead", "", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "genStats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "read", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "plugin-finder_release"})
  public class c
    extends FinderFeedRelTimelineLoader.a
  {
    public c()
    {
      super();
    }
    
    public void dead()
    {
      AppMethodBeat.i(244596);
      super.dead();
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
      ((FinderStreamCardVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamCardVM.class)).pg(true);
      AppMethodBeat.o(244596);
    }
    
    public IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      Object localObject1 = null;
      boolean bool2 = true;
      AppMethodBeat.i(244597);
      p.h(paramq, "scene");
      IResponse localIResponse = super.dealOnSceneEnd(paramInt1, paramInt2, paramString, paramq);
      Object localObject2;
      boolean bool1;
      label160:
      long l;
      if ((paramq instanceof bh))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject2 = com.tencent.mm.ui.component.a.PRN;
          FinderStreamCardVM.a((FinderStreamCardVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamCardVM.class));
        }
        localObject2 = getTAG();
        paramString = new StringBuilder("[dealOnSceneEnd] errType=").append(paramInt1).append(" errCode=").append(paramString).append(" pullType=").append(((bh)paramq).pullType).append(' ').append("lastBuffer=");
        if (this.tVh.getLastBuffer() == null) {
          break label338;
        }
        bool1 = true;
        paramString = paramString.append(bool1).append(" cardBuffer=");
        if (this.tVh.tVe == null) {
          break label344;
        }
        bool1 = bool2;
        paramString = paramString.append(bool1).append(' ').append("stats=");
        paramq = this.tVh.tVf;
        if (paramq == null) {
          break label350;
        }
        l = paramq.hFK;
        label198:
        paramString = paramString.append(d.zs(l)).append(" get_column_feed_info=");
        paramq = this.tVh.tVd;
        if (paramq == null) {
          break label356;
        }
        l = paramq.id;
        label234:
        paramq = paramString.append(d.zs(l)).append(' ').append("hasMore=");
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
        AppMethodBeat.o(244597);
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
    
    public q genLoadMoreNetScene()
    {
      AppMethodBeat.i(244595);
      Object localObject1 = com.tencent.mm.ui.component.a.PRN;
      Object localObject2 = (Iterable)((FinderStreamCardVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamCardVM.class)).dHT();
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        cmm localcmm = (cmm)((Iterator)localObject2).next();
        ecq localecq = new ecq();
        localecq.NcN = new epf();
        localecq.NcM = new mp();
        localecq.NcO = new cxr();
        localecq.hFK = localcmm.hFK;
        localecq.tCE = localcmm.MrI;
        localecq.sessionBuffer = localcmm.sessionBuffer;
        localecq.finderUsername = z.aUg();
        localecq.NcP = cl.aWA();
        localecq.mediaType = 11;
        ((Collection)localObject1).add(localecq);
      }
      localObject1 = (List)localObject1;
      localObject1 = new bh(this.tVh.getLastBuffer(), this.tVh.tVg, (List)localObject1, this.tVh.tVd, this.tVh.getContextObj());
      ((bh)localObject1).pullType = 2;
      localObject1 = (q)localObject1;
      AppMethodBeat.o(244595);
      return localObject1;
    }
    
    public q genRefreshNetScene()
    {
      AppMethodBeat.i(244594);
      com.tencent.mm.bw.b localb = this.tVh.tVe;
      int i = this.tVh.tVg;
      Object localObject = this.tVh.tVf;
      if (localObject != null) {}
      for (localObject = j.listOf(localObject);; localObject = null)
      {
        localObject = new bh(localb, i, (List)localObject, this.tVh.tVd, this.tVh.getContextObj());
        ((bh)localObject).pullType = 0;
        localObject = (q)localObject;
        AppMethodBeat.o(244594);
        return localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader
 * JD-Core Version:    0.7.0.1
 */