package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.cgi.co;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isTimeline", "", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "onFetchDone", "response", "FavDataFetcher", "FinderFavListResponse", "plugin-finder_release"})
public final class FinderFavFeedLoader
  extends BaseFinderFeedLoader
{
  public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
  public int gAZ;
  public boolean hasMore;
  private final String sBN;
  final boolean tUS;
  
  public FinderFavFeedLoader(String paramString, bbn parambbn, boolean paramBoolean)
  {
    super(parambbn);
    AppMethodBeat.i(244576);
    this.sBN = paramString;
    this.tUS = paramBoolean;
    AppMethodBeat.o(244576);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(244573);
    g localg = (g)new a();
    AppMethodBeat.o(244573);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(244574);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new c(this);
    AppMethodBeat.o(244574);
    return localb;
  }
  
  public final int getPageName()
  {
    return 10;
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244575);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(244575);
      return;
    }
    if ((paramIResponse.getPullType() == 0) && ((paramIResponse instanceof b))) {
      this.gAZ = ((b)paramIResponse).gAZ;
    }
    this.hasMore = paramIResponse.getHasMore();
    kotlin.g.a.b localb = this.fetchEndCallback;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(244575);
      return;
    }
    AppMethodBeat.o(244575);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FavDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<bo> callInit()
    {
      Object localObject2 = null;
      AppMethodBeat.i(244570);
      Log.i(getTAG(), "fetchInit initCount ");
      FinderFavFeedLoader.b localb = new FinderFavFeedLoader.b(0, 0, "", 0, (byte)0);
      Object localObject1;
      if (this.tUT.tUS)
      {
        localObject1 = this.tUT.getCache();
        if (localObject1 != null)
        {
          localObject1 = ((h)localObject1).kgc;
          localb.setIncrementList((List)localObject1);
          h localh = this.tUT.getCache();
          localObject1 = localObject2;
          if (localh != null) {
            localObject1 = localh.lastBuffer;
          }
          localb.setLastBuffer((com.tencent.mm.bw.b)localObject1);
        }
      }
      for (;;)
      {
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(244570);
        return localObject1;
        localObject1 = null;
        break;
        localb.setIncrementList(l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGw, this.tUT.getPageName()));
      }
    }
    
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(244569);
      p.h(paramq, "scene");
      if ((paramq instanceof co))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((co)paramq).cYA() == 0)) {}
        FinderFavFeedLoader.b localb;
        for (boolean bool = false;; bool = true)
        {
          localb = new FinderFavFeedLoader.b(paramInt1, paramInt2, paramString, ((co)paramq).cZm(), (byte)0);
          localObject1 = (Iterable)((co)paramq).cYD();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (FinderObject)((Iterator)localObject1).next();
            Object localObject3 = FinderItem.Companion;
            localObject2 = FinderItem.a.a((FinderObject)localObject2, 256);
            localObject3 = c.vGN;
            paramString.add(c.a.s((FinderItem)localObject2));
          }
        }
        localb.setIncrementList((List)paramString);
        paramString = c.vGN;
        c.a.a(((co)paramq).cYD(), 256, this.tUT.getContextObj());
        if (((co)paramq).pullType != 2)
        {
          paramString = c.vGN;
          paramString = localb.getIncrementList();
          if (paramString == null)
          {
            paramString = new t("null cannot be cast to non-null type kotlin.collections.List<com.tencent.mm.plugin.finder.model.BaseFinderFeed>");
            AppMethodBeat.o(244569);
            throw paramString;
          }
          c.a.b(paramString, 256, true);
          localb.gAZ = ((co)paramq).cZm();
          localb.tUU = ((co)paramq).cYy();
        }
        Object localObject1 = getTAG();
        Object localObject2 = new StringBuilder("incrementList size: ");
        paramString = localb.getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          Log.i((String)localObject1, paramString);
          localb.setPullType(((co)paramq).pullType);
          localb.setLastBuffer(((co)paramq).cYz());
          localb.setHasMore(bool);
          paramString = (IResponse)localb;
          AppMethodBeat.o(244569);
          return paramString;
        }
      }
      AppMethodBeat.o(244569);
      return null;
    }
    
    public final com.tencent.mm.ak.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(244568);
      Object localObject = new co(FinderFavFeedLoader.a(this.tUT), this.tUT.getLastBuffer(), this.tUT.getContextObj());
      ((co)localObject).pullType = 2;
      localObject = (com.tencent.mm.ak.q)localObject;
      AppMethodBeat.o(244568);
      return localObject;
    }
    
    public final com.tencent.mm.ak.q genRefreshNetScene()
    {
      AppMethodBeat.i(244567);
      Object localObject = new co(FinderFavFeedLoader.a(this.tUT), this.tUT.getLastBuffer(), this.tUT.getContextObj());
      ((co)localObject).pullType = 0;
      localObject = (com.tencent.mm.ak.q)localObject;
      AppMethodBeat.o(244567);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(244566);
      List localList = j.listOf(Integer.valueOf(3966));
      AppMethodBeat.o(244566);
      return localList;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "megaVideoCount", "(IILjava/lang/String;II)V", "getMegaVideoCount", "()I", "setMegaVideoCount", "(I)V", "getTotalCount", "setTotalCount", "plugin-finder_release"})
  public static final class b
    extends IResponse<bo>
  {
    int gAZ;
    public int tUU;
    
    private b(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      super(paramInt2, paramString);
      this.gAZ = paramInt3;
      this.tUU = 0;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<bo>.a
  {
    c()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, x> paramb)
    {
      int i = 0;
      AppMethodBeat.i(244572);
      p.h(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      Object localObject;
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        localc.Rmi = ((CharSequence)((Context)localObject).getResources().getString(2131760628));
        localc.Rmh = 1;
        if (paramIResponse.getPullType() == 0) {
          break label291;
        }
        bool = true;
        label86:
        localc.jLE = bool;
        localc.Rmj = paramIResponse.getHasMore();
        if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.Rmk > 0)) {
          localc.Rmi = null;
        }
        localc.iMa = Integer.valueOf(((FinderFavFeedLoader.b)paramIResponse).gAZ);
        Log.i(this.tUT.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        localObject = paramIResponse.getIncrementList();
        if (localObject != null) {
          i = ((List)localObject).size();
        }
        if (!paramIResponse.getHasMore()) {
          break label297;
        }
        if (i > this.tUT.getDataList().size()) {
          break label372;
        }
        i = 2;
      }
      for (;;)
      {
        d.h((kotlin.g.a.a)new a(this, new n(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(244572);
        return;
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        localc.Rmi = ((CharSequence)((Context)localObject).getResources().getString(2131760645));
        localc.Rmh = -1;
        break;
        label291:
        bool = false;
        break label86;
        label297:
        if ((this.tUT.getDataList().size() == 0) || (i == 0) || (this.tUT.getDataList().size() <= i))
        {
          localObject = paramIResponse.getIncrementList();
          if ((localObject != null) && (((List)localObject).containsAll((Collection)j.p((Iterable)this.tUT.getDataList())) == true))
          {
            i = 6;
            continue;
          }
        }
        label372:
        i = 4;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderFavFeedLoader.c paramc, n paramn, RefreshLoadMoreLayout.c paramc1, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader
 * JD-Core Version:    0.7.0.1
 */