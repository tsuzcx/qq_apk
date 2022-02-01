package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.bp;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "finderUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "cachedState", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$CacheState;", "getCachedState", "()Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$CacheState;", "setCachedState", "(Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$CacheState;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderUsername", "isLoading", "", "()Z", "setLoading", "(Z)V", "refreshCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/ParameterName;", "name", "response", "getRefreshCallback", "()Lkotlin/jvm/functions/Function1;", "setRefreshCallback", "(Lkotlin/jvm/functions/Function1;)V", "state", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$State;", "setState", "(Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$State;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "isObservePostEvent", "onFetchDone", "AtDataFetcher", "CacheState", "FinderAtTimelineResponse", "State", "plugin-finder_release"})
public final class FinderAtFeedLoader
  extends BaseFinderFeedLoader
{
  private String TAG;
  final String finderUsername;
  public kotlin.g.a.a<x> tTS;
  public kotlin.g.a.b<? super IResponse<bo>, x> tVa;
  public d uHR;
  public b uHS;
  
  public FinderAtFeedLoader(e parame, String paramString, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(248205);
    this.finderUsername = paramString;
    this.TAG = "Finder.AtTimelineLoader";
    this.uHR = d.uHY;
    this.uHS = b.uHU;
    AppMethodBeat.o(248205);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(248203);
    p.h(paramd, "<set-?>");
    this.uHR = paramd;
    AppMethodBeat.o(248203);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(248202);
    g localg = (g)new a();
    AppMethodBeat.o(248202);
    return localg;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final boolean isObservePostEvent()
  {
    return false;
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(248204);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (getDataListJustForAdapter().size() > 0) {}
    for (Object localObject = b.uHW;; localObject = b.uHV)
    {
      this.uHS = ((b)localObject);
      if (!isInitOperation(paramIResponse)) {
        break;
      }
      AppMethodBeat.o(248204);
      return;
    }
    if (isRefreshOperation(paramIResponse))
    {
      localObject = this.tVa;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(paramIResponse);
      }
    }
    if (!paramIResponse.getHasMore())
    {
      paramIResponse = this.tTS;
      if (paramIResponse != null)
      {
        paramIResponse.invoke();
        AppMethodBeat.o(248204);
        return;
      }
    }
    AppMethodBeat.o(248204);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(248201);
    p.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(248201);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$AtDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<bo> callInit()
    {
      FinderAtFeedLoader.c localc = null;
      AppMethodBeat.i(248193);
      Object localObject1 = this.uHT.getCache();
      if ((localObject1 != null) && (((h)localObject1).kgc != null))
      {
        localObject2 = new FinderAtFeedLoader.c(0, 0, "");
        localObject1 = this.uHT.getCache();
        if (localObject1 != null) {}
        for (localObject1 = ((h)localObject1).kgc;; localObject1 = null)
        {
          ((FinderAtFeedLoader.c)localObject2).setIncrementList((List)localObject1);
          h localh = this.uHT.getCache();
          localObject1 = localc;
          if (localh != null) {
            localObject1 = localh.lastBuffer;
          }
          ((FinderAtFeedLoader.c)localObject2).setLastBuffer((com.tencent.mm.bw.b)localObject1);
          ((FinderAtFeedLoader.c)localObject2).setHasMore(true);
          localObject1 = (IResponse)localObject2;
          AppMethodBeat.o(248193);
          return localObject1;
        }
      }
      localObject1 = (a)this;
      localc = new FinderAtFeedLoader.c(0, 0, "");
      Object localObject2 = com.tencent.mm.plugin.finder.storage.data.l.vGw.bc(14, this.uHT.finderUsername);
      Log.i(((a)localObject1).getTAG(), "[callInit] page list=" + ((List)localObject2).size());
      localc.setIncrementList((List)localObject2);
      localc.setLastBuffer(null);
      localc.setHasMore(true);
      localObject1 = (IResponse)localc;
      AppMethodBeat.o(248193);
      return localObject1;
    }
    
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(248194);
      p.h(paramq, "scene");
      Object localObject2 = this.uHT;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (Object localObject1 = FinderAtFeedLoader.d.uIa;; localObject1 = FinderAtFeedLoader.d.uIb)
      {
        ((FinderAtFeedLoader)localObject2).a((FinderAtFeedLoader.d)localObject1);
        localObject1 = (bp)paramq;
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label243;
        }
        localObject2 = ((bp)localObject1).rr.aYK();
        if (localObject2 != null) {
          break;
        }
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
        AppMethodBeat.o(248194);
        throw paramString;
      }
      if (((atg)localObject2).tUC == 0) {}
      label243:
      for (boolean bool = false;; bool = true)
      {
        localObject2 = new FinderAtFeedLoader.c(paramInt1, paramInt2, paramString);
        paramq = (Iterable)((bp)paramq).cYD();
        paramString = (Collection)new ArrayList(j.a(paramq, 10));
        paramq = paramq.iterator();
        while (paramq.hasNext())
        {
          localObject3 = (FinderObject)paramq.next();
          Object localObject4 = FinderItem.Companion;
          localObject3 = FinderItem.a.a((FinderObject)localObject3, 8192);
          localObject4 = FinderAtTimelineUI.tZp;
          ((Map)FinderAtTimelineUI.ddO()).put(Long.valueOf(((FinderItem)localObject3).getId()), localObject3);
          localObject4 = c.vGN;
          paramString.add(c.a.s((FinderItem)localObject3));
        }
      }
      ((FinderAtFeedLoader.c)localObject2).setIncrementList((List)paramString);
      paramq = getTAG();
      Object localObject3 = new StringBuilder("pullType=").append(((bp)localObject1).pullType).append(" username=").append(this.uHT.finderUsername).append(" incrementList size: ");
      paramString = ((FinderAtFeedLoader.c)localObject2).getIncrementList();
      if (paramString != null) {}
      for (paramString = Integer.valueOf(paramString.size());; paramString = null)
      {
        Log.i(paramq, paramString);
        ((FinderAtFeedLoader.c)localObject2).setPullType(((bp)localObject1).pullType);
        paramString = ((bp)localObject1).rr.aYK();
        if (paramString != null) {
          break;
        }
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
        AppMethodBeat.o(248194);
        throw paramString;
      }
      ((FinderAtFeedLoader.c)localObject2).setLastBuffer(((atg)paramString).LDs);
      ((FinderAtFeedLoader.c)localObject2).setHasMore(bool);
      if (((bp)localObject1).pullType == 1)
      {
        paramString = ((FinderAtFeedLoader.c)localObject2).getIncrementList();
        if (paramString != null)
        {
          paramq = c.vGN;
          c.a.a(paramString, 8192, this.uHT.finderUsername, true);
        }
      }
      paramString = (IResponse)localObject2;
      AppMethodBeat.o(248194);
      return paramString;
    }
    
    public final void fetch(Object paramObject, f<bo> paramf)
    {
      AppMethodBeat.i(248190);
      p.h(paramf, "callback");
      super.fetch(paramObject, paramf);
      this.uHT.a(FinderAtFeedLoader.d.uHZ);
      AppMethodBeat.o(248190);
    }
    
    public final q genLoadMoreNetScene()
    {
      AppMethodBeat.i(248192);
      Object localObject = new bp(this.uHT.finderUsername, this.uHT.getLastBuffer());
      ((bp)localObject).pullType = 2;
      localObject = (q)localObject;
      AppMethodBeat.o(248192);
      return localObject;
    }
    
    public final q genRefreshNetScene()
    {
      AppMethodBeat.i(248191);
      Object localObject = new bp(this.uHT.finderUsername, this.uHT.getLastBuffer());
      ((bp)localObject).pullType = 1;
      localObject = (q)localObject;
      AppMethodBeat.o(248191);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(248189);
      List localList = j.listOf(Integer.valueOf(3810));
      AppMethodBeat.o(248189);
      return localList;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$CacheState;", "", "(Ljava/lang/String;I)V", "INIT", "NO_CACHE", "WITH_CACHED", "plugin-finder_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(248195);
      b localb1 = new b("INIT", 0);
      uHU = localb1;
      b localb2 = new b("NO_CACHE", 1);
      uHV = localb2;
      b localb3 = new b("WITH_CACHED", 2);
      uHW = localb3;
      uHX = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(248195);
    }
    
    private b() {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$FinderAtTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<bo>
  {
    public c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$State;", "", "(Ljava/lang/String;I)V", "INIT", "LOADING", "LOADED", "FAILURE", "plugin-finder_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(248198);
      d locald1 = new d("INIT", 0);
      uHY = locald1;
      d locald2 = new d("LOADING", 1);
      uHZ = locald2;
      d locald3 = new d("LOADED", 2);
      uIa = locald3;
      d locald4 = new d("FAILURE", 3);
      uIb = locald4;
      uIc = new d[] { locald1, locald2, locald3, locald4 };
      AppMethodBeat.o(248198);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader
 * JD-Core Version:    0.7.0.1
 */