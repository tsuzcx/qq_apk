package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.finder.cgi.ad;
import com.tencent.mm.plugin.finder.cgi.aj;
import com.tencent.mm.plugin.finder.cgi.y;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.model.an;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "feedId", "", "encryptedFeedId", "", "nonceId", "tabType", "", "isFromAd", "", "shareScene", "sessionId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Ljava/lang/String;IZILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getEncryptedFeedId", "()Ljava/lang/String;", "getFeedId", "()J", "setFeedId", "(J)V", "fetchCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchCallback", "(Lkotlin/jvm/functions/Function1;)V", "fetchEndCallback", "getFetchEndCallback", "setFetchEndCallback", "finderUserName", "getFinderUserName", "setFinderUserName", "(Ljava/lang/String;)V", "fromUserName", "getFromUserName", "setFromUserName", "hasRefreshFinish", "getHasRefreshFinish", "()Z", "setHasRefreshFinish", "(Z)V", "getNonceId", "getSessionId", "getShareScene", "()I", "getTabType", "toUserName", "getToUserName", "setToUserName", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getLastItem", "onFetchDone", "response", "FeedShareRelDataFetcher", "FinderShareRelativeListResponse", "UserPageDataFetcher", "plugin-finder_release"})
public final class FinderFeedShareRelativeListLoader
  extends BaseFinderFeedLoader
{
  public String dGJ;
  public String dsk;
  public long duw;
  final int dvm;
  public d.g.a.b<? super IResponse<am>, z> fetchEndCallback;
  final String rPZ;
  final String rRi;
  final String sessionId;
  final int shareScene;
  public String sjZ;
  public d.g.a.b<? super IResponse<am>, z> skg;
  private boolean skh;
  private final boolean ski;
  
  public FinderFeedShareRelativeListLoader(long paramLong, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, String paramString3, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(202835);
    this.duw = paramLong;
    this.rRi = paramString1;
    this.rPZ = paramString2;
    this.dvm = paramInt1;
    this.ski = paramBoolean;
    this.shareScene = paramInt2;
    this.sessionId = paramString3;
    this.sjZ = "";
    this.dGJ = "";
    this.dsk = "";
    AppMethodBeat.o(202835);
  }
  
  public final g<am> createDataFetch()
  {
    AppMethodBeat.i(202832);
    if (this.ski)
    {
      localg = (g)new c();
      AppMethodBeat.o(202832);
      return localg;
    }
    g localg = (g)new a();
    AppMethodBeat.o(202832);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<am> createDataMerger()
  {
    AppMethodBeat.i(202833);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new d(this);
    AppMethodBeat.o(202833);
    return localb;
  }
  
  public final void onFetchDone(IResponse<am> paramIResponse)
  {
    AppMethodBeat.i(202834);
    p.h(paramIResponse, "response");
    if (paramIResponse.getPullType() == 0)
    {
      this.skh = true;
      ae.d(getTAG(), "refresh finish");
    }
    if ((paramIResponse.getPullType() == 2) && (!this.skh))
    {
      ae.d(getTAG(), "loadmore before refresh");
      AppMethodBeat.o(202834);
      return;
    }
    if (!isInitOperation(paramIResponse))
    {
      localb = this.skg;
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
      AppMethodBeat.o(202834);
      return;
    }
    d.g.a.b localb = this.fetchEndCallback;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(202834);
      return;
    }
    AppMethodBeat.o(202834);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FeedShareRelDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "plugin-finder_release"})
  public final class a
    extends a
  {
    public final IResponse<am> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202825);
      p.h(paramn, "scene");
      if ((paramn instanceof aj))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        Object localObject1;
        Object localObject4;
        Object localObject5;
        for (boolean bool = ((aj)paramn).czK();; bool = true)
        {
          localObject1 = new FinderFeedShareRelativeListLoader.b(paramInt1, paramInt2, paramString, "");
          localObject2 = ((aj)paramn).czJ();
          localObject3 = (List)new ArrayList();
          localObject4 = (Iterable)localObject2;
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (FinderObject)((Iterator)localObject4).next();
            Object localObject6 = FinderItem.sJb;
            localObject5 = FinderItem.a.a((FinderObject)localObject5, 256);
            localObject6 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
            paramString.add(b.a.j((FinderItem)localObject5));
          }
          localObject1 = com.tencent.mm.plugin.finder.report.f.syc;
          com.tencent.mm.plugin.finder.report.f.Fo(0);
        }
        ((List)localObject3).addAll((Collection)paramString);
        if (((aj)paramn).pullType == 0)
        {
          localObject4 = ((Iterable)localObject3).iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label463;
          }
          paramString = ((Iterator)localObject4).next();
          localObject5 = (am)paramString;
          if ((!(localObject5 instanceof BaseFinderFeed)) || (((am)localObject5).lP() == ((aj)paramn).duw)) {
            break label458;
          }
          paramInt1 = 1;
          label271:
          if (paramInt1 == 0) {
            break label461;
          }
          label275:
          paramString = (am)paramString;
          if ((paramString != null) && (((List)localObject3).indexOf(paramString) > 0))
          {
            paramString = an.stA;
            ((List)localObject3).add(1, an.cEM());
          }
        }
        ((FinderFeedShareRelativeListLoader.b)localObject1).setIncrementList((List)localObject3);
        paramString = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
        b.a.a((List)localObject2, 1, null, 12);
        Object localObject2 = getTAG();
        Object localObject3 = new StringBuilder("incrementList size: ");
        paramString = ((FinderFeedShareRelativeListLoader.b)localObject1).getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          ae.i((String)localObject2, paramString);
          ((FinderFeedShareRelativeListLoader.b)localObject1).setPullType(((aj)paramn).pullType);
          ((FinderFeedShareRelativeListLoader.b)localObject1).setLastBuffer(((aj)paramn).czI());
          ((FinderFeedShareRelativeListLoader.b)localObject1).setHasMore(bool);
          paramn = ((aj)paramn).getWording();
          paramString = paramn;
          if (paramn == null) {
            paramString = "";
          }
          ((FinderFeedShareRelativeListLoader.b)localObject1).aio(paramString);
          paramString = (IResponse)localObject1;
          AppMethodBeat.o(202825);
          return paramString;
          label458:
          paramInt1 = 0;
          break label271;
          label461:
          break;
          label463:
          paramString = null;
          break label275;
        }
      }
      AppMethodBeat.o(202825);
      return null;
    }
    
    public final void fetch(Object paramObject, com.tencent.mm.plugin.finder.feed.model.internal.f<am> paramf)
    {
      AppMethodBeat.i(202823);
      p.h(paramf, "callback");
      if (!(paramObject instanceof aj)) {}
      for (Object localObject = null;; localObject = paramObject)
      {
        localObject = (aj)localObject;
        if (localObject != null)
        {
          com.tencent.mm.plugin.finder.report.f localf = com.tencent.mm.plugin.finder.report.f.syc;
          com.tencent.mm.plugin.finder.report.f.a(((aj)localObject).dvm, ((aj)localObject).pullType, ((ad)localObject).rQw, 4L);
        }
        localObject = com.tencent.mm.plugin.finder.report.f.syc;
        com.tencent.mm.plugin.finder.report.f.ah(this.skj.dvm, true);
        super.fetch(paramObject, paramf);
        AppMethodBeat.o(202823);
        return;
      }
    }
    
    public final n genLoadMoreNetScene()
    {
      AppMethodBeat.i(202824);
      Object localObject = new aj(this.skj.duw, this.skj.rPZ, this.skj.dvm, this.skj.getLastBuffer(), null, this.skj.shareScene, this.skj.dGJ, this.skj.dsk, this.skj.sessionId, this.skj.getContextObj());
      ((aj)localObject).pullType = 2;
      localObject = (n)localObject;
      AppMethodBeat.o(202824);
      return localObject;
    }
    
    public final n genRefreshNetScene()
    {
      AppMethodBeat.i(202822);
      Object localObject = new aj(this.skj.duw, this.skj.rPZ, this.skj.dvm, this.skj.getLastBuffer(), null, this.skj.shareScene, this.skj.dGJ, this.skj.dsk, this.skj.sessionId, this.skj.getContextObj());
      ((aj)localObject).pullType = 0;
      localObject = (n)localObject;
      AppMethodBeat.o(202822);
      return localObject;
    }
    
    public final int getCmdId()
    {
      return 3688;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$FinderShareRelativeListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "tipsWording", "(IILjava/lang/String;Ljava/lang/String;)V", "getTipsWording", "()Ljava/lang/String;", "setTipsWording", "(Ljava/lang/String;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<am>
  {
    public String tipsWording;
    
    public b(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      super(paramInt2, paramString1);
      AppMethodBeat.i(202827);
      this.tipsWording = paramString2;
      AppMethodBeat.o(202827);
    }
    
    public final void aio(String paramString)
    {
      AppMethodBeat.i(202826);
      p.h(paramString, "<set-?>");
      this.tipsWording = paramString;
      AppMethodBeat.o(202826);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$UserPageDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneAdFeedList;", "getCmdId", "plugin-finder_release"})
  public final class c
    extends a
  {
    public final IResponse<am> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      int j = 1;
      AppMethodBeat.i(202830);
      p.h(paramn, "scene");
      if ((paramn instanceof y))
      {
        Object localObject1 = ((y)paramn).rr.aEV();
        if (localObject1 == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
          AppMethodBeat.o(202830);
          throw paramString;
        }
        int i;
        FinderFeedShareRelativeListLoader.b localb;
        if (((alt)localObject1).privateLock == 1)
        {
          i = 1;
          if (i != 0) {
            break label492;
          }
          localb = new FinderFeedShareRelativeListLoader.b(paramInt1, paramInt2, paramString, "");
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label162;
          }
        }
        label162:
        for (boolean bool = ((y)paramn).rRg;; bool = true)
        {
          localb.setPullType(((y)paramn).pullType);
          paramString = ((y)paramn).rr.aEV();
          if (paramString != null) {
            break label168;
          }
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
          AppMethodBeat.o(202830);
          throw paramString;
          i = 0;
          break;
        }
        label168:
        localb.setLastBuffer(((alt)paramString).lastBuffer);
        localb.setHasMore(bool);
        paramString = ((y)paramn).rr.aEV();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
          AppMethodBeat.o(202830);
          throw paramString;
        }
        localObject1 = ((alt)paramString).GEf;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        localb.aio(paramString);
        paramString = ((y)paramn).rr.aEV();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
          AppMethodBeat.o(202830);
          throw paramString;
        }
        localObject1 = ((alt)paramString).object;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = new LinkedList();
        }
        localObject1 = (List)new ArrayList();
        Object localObject2 = (Iterable)paramString;
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (FinderObject)((Iterator)localObject2).next();
          Object localObject4 = FinderItem.sJb;
          localObject3 = FinderItem.a.a((FinderObject)localObject3, 256);
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
          paramString.add(b.a.j((FinderItem)localObject3));
        }
        ((List)localObject1).addAll((Collection)paramString);
        if (((y)paramn).pullType == 0) {
          if (!((Collection)localObject1).isEmpty()) {
            break label487;
          }
        }
        label487:
        for (paramInt1 = j;; paramInt1 = 0)
        {
          if (paramInt1 == 0)
          {
            paramString = an.stA;
            ((List)localObject1).add(0, an.cEM());
          }
          localb.setIncrementList((List)localObject1);
          paramString = (IResponse)localb;
          AppMethodBeat.o(202830);
          return paramString;
        }
      }
      label492:
      AppMethodBeat.o(202830);
      return null;
    }
    
    public final n genLoadMoreNetScene()
    {
      long l2 = 0L;
      AppMethodBeat.i(202829);
      Object localObject = this.skj;
      int i = ((FinderFeedShareRelativeListLoader)localObject).getDataList().size() - 1;
      for (;;)
      {
        long l1 = l2;
        if (i >= 0)
        {
          am localam = (am)((FinderFeedShareRelativeListLoader)localObject).getDataList().get(i);
          if (((localam instanceof BaseFinderFeed)) && (((BaseFinderFeed)localam).feedObject.getId() != 0L)) {
            l1 = ((BaseFinderFeed)localam).feedObject.getId();
          }
        }
        else
        {
          localObject = (n)new y(this.skj.sjZ, this.skj.duw, this.skj.rRi, l1, this.skj.getLastBuffer(), 2, this.skj.getContextObj());
          AppMethodBeat.o(202829);
          return localObject;
        }
        i -= 1;
      }
    }
    
    public final int getCmdId()
    {
      return 6692;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "request", "", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<am>.a
  {
    d()
    {
      super();
    }
    
    public final int findMergeIndex(ArrayList<am> paramArrayList, List<? extends am> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(202831);
      p.h(paramArrayList, "srcList");
      p.h(paramList, "newList");
      paramInt = this.skj.getDataList().size();
      AppMethodBeat.o(202831);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader
 * JD-Core Version:    0.7.0.1
 */