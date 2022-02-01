package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.finder.cgi.ac;
import com.tencent.mm.plugin.finder.cgi.ai;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "feedId", "", "nonceId", "", "tabType", "", "shareScene", "sessionId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFeedId", "()J", "setFeedId", "(J)V", "fetchCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchCallback", "(Lkotlin/jvm/functions/Function1;)V", "fetchEndCallback", "getFetchEndCallback", "setFetchEndCallback", "fromUserName", "getFromUserName", "()Ljava/lang/String;", "setFromUserName", "(Ljava/lang/String;)V", "hasRefreshFinish", "", "getHasRefreshFinish", "()Z", "setHasRefreshFinish", "(Z)V", "getNonceId", "getSessionId", "getShareScene", "()I", "getTabType", "toUserName", "getToUserName", "setToUserName", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FeedShareRelDataFetcher", "FinderShareRelativeListResponse", "plugin-finder_release"})
public final class FinderFeedShareRelativeListLoader
  extends BaseFinderFeedLoader
{
  public String dFE;
  public String drf;
  public long dtq;
  final int duh;
  public d.g.a.b<? super IResponse<al>, z> fetchEndCallback;
  final String rHO;
  public d.g.a.b<? super IResponse<al>, z> sbq;
  private boolean sbr;
  final String sessionId;
  final int shareScene;
  
  public FinderFeedShareRelativeListLoader(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(221469);
    this.dtq = paramLong;
    this.rHO = paramString1;
    this.duh = paramInt1;
    this.shareScene = paramInt2;
    this.sessionId = paramString2;
    this.dFE = "";
    this.drf = "";
    AppMethodBeat.o(221469);
  }
  
  public final g<al> createDataFetch()
  {
    AppMethodBeat.i(202356);
    g localg = (g)new a();
    AppMethodBeat.o(202356);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<al> createDataMerger()
  {
    AppMethodBeat.i(202357);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new c(this);
    AppMethodBeat.o(202357);
    return localb;
  }
  
  public final void onFetchDone(IResponse<al> paramIResponse)
  {
    AppMethodBeat.i(202358);
    p.h(paramIResponse, "response");
    if (paramIResponse.getPullType() == 0)
    {
      this.sbr = true;
      ad.d(getTAG(), "refresh finish");
    }
    if ((paramIResponse.getPullType() == 2) && (!this.sbr))
    {
      ad.d(getTAG(), "loadmore before refresh");
      AppMethodBeat.o(202358);
      return;
    }
    if (!isInitOperation(paramIResponse))
    {
      localb = this.sbq;
      if (localb != null) {
        localb.invoke(paramIResponse);
      }
    }
    if (paramIResponse.getPullType() == 0) {
      paramIResponse.setPullType(2);
    }
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(202358);
      return;
    }
    d.g.a.b localb = this.fetchEndCallback;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(202358);
      return;
    }
    AppMethodBeat.o(202358);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "plugin-finder_release"})
  public final class a
    extends a
  {
    public final IResponse<al> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202353);
      p.h(paramn, "scene");
      if ((paramn instanceof ai))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        Object localObject1;
        Object localObject4;
        Object localObject5;
        for (boolean bool = ((ai)paramn).cyj();; bool = true)
        {
          localObject1 = new FinderFeedShareRelativeListLoader.b(paramInt1, paramInt2, paramString, "");
          localObject2 = ((ai)paramn).cyi();
          localObject3 = (List)new ArrayList();
          localObject4 = (Iterable)localObject2;
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (FinderObject)((Iterator)localObject4).next();
            Object localObject6 = FinderItem.syk;
            localObject5 = FinderItem.a.a((FinderObject)localObject5, 256);
            localObject6 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
            paramString.add(b.a.j((FinderItem)localObject5));
          }
          localObject1 = e.snY;
          e.ES(0);
        }
        ((List)localObject3).addAll((Collection)paramString);
        if (((ai)paramn).pullType == 0)
        {
          localObject4 = ((Iterable)localObject3).iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label476;
          }
          paramString = ((Iterator)localObject4).next();
          localObject5 = (al)paramString;
          if ((!(localObject5 instanceof BaseFinderFeed)) || (((al)localObject5).lP() == ((ai)paramn).dtq)) {
            break label471;
          }
          paramInt1 = 1;
          label271:
          if (paramInt1 == 0) {
            break label474;
          }
          label275:
          paramString = (al)paramString;
          if ((paramString != null) && (((List)localObject3).indexOf(paramString) > 0))
          {
            paramString = am.skD;
            ((List)localObject3).add(1, new com.tencent.mm.plugin.finder.model.b(am.cCZ()));
          }
        }
        ((FinderFeedShareRelativeListLoader.b)localObject1).setIncrementList((List)localObject3);
        paramString = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
        b.a.a((List)localObject2, 1, null, 12);
        Object localObject2 = getTAG();
        Object localObject3 = new StringBuilder("incrementList size: ");
        paramString = ((FinderFeedShareRelativeListLoader.b)localObject1).getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          ad.i((String)localObject2, paramString);
          ((FinderFeedShareRelativeListLoader.b)localObject1).setPullType(((ai)paramn).pullType);
          ((FinderFeedShareRelativeListLoader.b)localObject1).setLastBuffer(((ai)paramn).cyh());
          ((FinderFeedShareRelativeListLoader.b)localObject1).setHasMore(bool);
          paramn = ((ai)paramn).getWording();
          paramString = paramn;
          if (paramn == null) {
            paramString = "";
          }
          p.h(paramString, "<set-?>");
          ((FinderFeedShareRelativeListLoader.b)localObject1).tipsWording = paramString;
          paramString = (IResponse)localObject1;
          AppMethodBeat.o(202353);
          return paramString;
          label471:
          paramInt1 = 0;
          break label271;
          label474:
          break;
          label476:
          paramString = null;
          break label275;
        }
      }
      AppMethodBeat.o(202353);
      return null;
    }
    
    public final void fetch(Object paramObject, f<al> paramf)
    {
      AppMethodBeat.i(202351);
      p.h(paramf, "callback");
      if (!(paramObject instanceof ai)) {}
      for (Object localObject = null;; localObject = paramObject)
      {
        localObject = (ai)localObject;
        if (localObject != null)
        {
          e locale = e.snY;
          e.a(((ai)localObject).duh, ((ai)localObject).pullType, ((ac)localObject).rIl, 4L);
        }
        localObject = e.snY;
        e.ae(this.sbs.duh, true);
        super.fetch(paramObject, paramf);
        AppMethodBeat.o(202351);
        return;
      }
    }
    
    public final n genLoadMoreNetScene()
    {
      AppMethodBeat.i(202352);
      Object localObject = new ai(this.sbs.dtq, this.sbs.rHO, this.sbs.duh, this.sbs.getLastBuffer(), null, this.sbs.shareScene, this.sbs.dFE, this.sbs.drf, this.sbs.sessionId, this.sbs.getContextObj());
      ((ai)localObject).pullType = 2;
      localObject = (n)localObject;
      AppMethodBeat.o(202352);
      return localObject;
    }
    
    public final n genRefreshNetScene()
    {
      AppMethodBeat.i(202350);
      Object localObject = new ai(this.sbs.dtq, this.sbs.rHO, this.sbs.duh, this.sbs.getLastBuffer(), null, this.sbs.shareScene, this.sbs.dFE, this.sbs.drf, this.sbs.sessionId, this.sbs.getContextObj());
      ((ai)localObject).pullType = 0;
      localObject = (n)localObject;
      AppMethodBeat.o(202350);
      return localObject;
    }
    
    public final int getCmdId()
    {
      return 3688;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderShareRelativeListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "tipsWording", "(IILjava/lang/String;Ljava/lang/String;)V", "getTipsWording", "()Ljava/lang/String;", "setTipsWording", "(Ljava/lang/String;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<al>
  {
    public String tipsWording;
    
    public b(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      super(paramInt2, paramString1);
      AppMethodBeat.i(202354);
      this.tipsWording = paramString2;
      AppMethodBeat.o(202354);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "request", "", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<al>.a
  {
    c()
    {
      super();
    }
    
    public final int findMergeIndex(ArrayList<al> paramArrayList, List<? extends al> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(202355);
      p.h(paramArrayList, "srcList");
      p.h(paramList, "newList");
      paramInt = this.sbs.getDataList().size();
      AppMethodBeat.o(202355);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader
 * JD-Core Version:    0.7.0.1
 */