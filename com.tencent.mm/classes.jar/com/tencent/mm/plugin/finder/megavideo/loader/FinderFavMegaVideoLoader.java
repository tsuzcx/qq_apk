package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.co;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.storage.data.u;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "megaVideoCount", "", "getMegaVideoCount", "()I", "setMegaVideoCount", "(I)V", "totalCount", "getTotalCount", "setTotalCount", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "FavMegaVideoDataFetcher", "FinderFavMegaVideoListResponse", "plugin-finder_release"})
public final class FinderFavMegaVideoLoader
  extends BaseMegaVideoLoader
{
  public int gAZ;
  private final String sBN;
  public int tUU;
  
  public FinderFavMegaVideoLoader(String paramString, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(248377);
    this.sBN = paramString;
    AppMethodBeat.o(248377);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(248374);
    g localg = (g)new a();
    AppMethodBeat.o(248374);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(248375);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new c(this);
    AppMethodBeat.o(248375);
    return localb;
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(248376);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(248376);
      return;
    }
    if (((paramIResponse instanceof b)) && (paramIResponse.getPullType() == 0))
    {
      this.gAZ = ((b)paramIResponse).gAZ;
      this.tUU = ((b)paramIResponse).uKM;
    }
    this.hasMore = paramIResponse.getHasMore();
    kotlin.g.a.b localb = this.fetchEndCallback;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(248376);
      return;
    }
    AppMethodBeat.o(248376);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader$FavMegaVideoDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<bo> callInit()
    {
      AppMethodBeat.i(248371);
      Log.i(getTAG(), "fetchInit");
      FinderFavMegaVideoLoader.b localb = new FinderFavMegaVideoLoader.b(0, 0, "", 0, 0);
      localb.setPullType(1000);
      Object localObject = this.uKL.getCache();
      if (localObject != null)
      {
        localObject = ((h)localObject).kgc;
        if (localObject != null)
        {
          Log.i(getTAG(), "fetchInit: use old data list, size: " + ((ArrayList)localObject).size());
          localb.setIncrementList((List)localObject);
          localb.uKM = ((ArrayList)localObject).size();
          localObject = this.uKL.getCache();
          if (localObject != null)
          {
            localObject = ((h)localObject).lastBuffer;
            localb.setLastBuffer((com.tencent.mm.bw.b)localObject);
          }
        }
      }
      for (;;)
      {
        localObject = (IResponse)localb;
        AppMethodBeat.o(248371);
        return localObject;
        localObject = null;
        break;
        localObject = l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGw, 12);
        Log.i(getTAG(), "fetchInit: use first page data list, size: " + ((List)localObject).size());
        localb.setIncrementList((List)localObject);
        localb.uKM = ((List)localObject).size();
      }
    }
    
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(248370);
      p.h(paramq, "scene");
      if ((paramq instanceof co))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((co)paramq).cYA() == 0)) {}
        FinderFavMegaVideoLoader.b localb;
        for (boolean bool = false;; bool = true)
        {
          localb = new FinderFavMegaVideoLoader.b(paramInt1, paramInt2, paramString, ((co)paramq).cYy(), ((co)paramq).cZm());
          localb.setPullType(((co)paramq).pullType);
          localObject = (Iterable)((co)paramq).cYD();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramString.add(new bm((FinderObject)((Iterator)localObject).next()));
          }
        }
        Object localObject = (List)paramString;
        localb.setIncrementList((List)localObject);
        String str = getTAG();
        StringBuilder localStringBuilder = new StringBuilder("incrementList size: ");
        paramString = localb.getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          Log.i(str, paramString);
          localb.setLastBuffer(((co)paramq).cYz());
          localb.setHasMore(bool);
          paramString = c.vGN;
          c.a.b(((co)paramq).cYD(), this.uKL.getContextObj());
          if (localb.getPullType() == 2) {
            break label414;
          }
          paramString = new LinkedList();
          paramq = ((Iterable)localObject).iterator();
          while (paramq.hasNext())
          {
            localObject = (bm)paramq.next();
            paramString.add(new u(((bm)localObject).lT(), 1, ((bm)localObject).getFeedObject()));
          }
        }
        if (paramString.size() > 0)
        {
          paramq = com.tencent.mm.plugin.finder.storage.data.l.vGw;
          paramq = z.aUg();
          p.g(paramq, "ConfigStorageLogic.getMyFinderUsername()");
          l.a.a(12, paramq, paramString);
        }
        Log.i(getTAG(), "FavMegaVideoDataFetcher FinderPage size: " + paramString.size());
        label414:
        paramString = (IResponse)localb;
        AppMethodBeat.o(248370);
        return paramString;
      }
      AppMethodBeat.o(248370);
      return null;
    }
    
    public final com.tencent.mm.ak.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(248369);
      Object localObject = new co(FinderFavMegaVideoLoader.a(this.uKL), this.uKL.getLastBuffer(), this.uKL.getContextObj(), 1);
      ((co)localObject).pullType = 2;
      localObject = (com.tencent.mm.ak.q)localObject;
      AppMethodBeat.o(248369);
      return localObject;
    }
    
    public final com.tencent.mm.ak.q genRefreshNetScene()
    {
      AppMethodBeat.i(248368);
      Object localObject = new co(FinderFavMegaVideoLoader.a(this.uKL), this.uKL.getLastBuffer(), this.uKL.getContextObj(), 1);
      ((co)localObject).pullType = 0;
      localObject = (com.tencent.mm.ak.q)localObject;
      AppMethodBeat.o(248368);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(248367);
      List localList = j.listOf(Integer.valueOf(3966));
      AppMethodBeat.o(248367);
      return localList;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader$FinderFavMegaVideoListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "megaVideoTotalCount", "totalCount", "(IILjava/lang/String;II)V", "getMegaVideoTotalCount", "()I", "setMegaVideoTotalCount", "(I)V", "getTotalCount", "setTotalCount", "plugin-finder_release"})
  public static final class b
    extends IResponse<bo>
  {
    int gAZ;
    int uKM;
    
    public b(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
    {
      super(paramInt2, paramString);
      this.uKM = paramInt3;
      this.gAZ = paramInt4;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<bo>.a
  {
    c()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, x> paramb)
    {
      AppMethodBeat.i(248373);
      p.h(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.Rms;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.hfT());
      d.h((kotlin.g.a.a)new a(this, new n(7, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
      AppMethodBeat.o(248373);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderFavMegaVideoLoader.c paramc, n paramn, RefreshLoadMoreLayout.c paramc1, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader
 * JD-Core Version:    0.7.0.1
 */