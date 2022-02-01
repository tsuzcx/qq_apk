package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "megaVideoCount", "", "getMegaVideoCount", "()I", "setMegaVideoCount", "(I)V", "totalCount", "getTotalCount", "setTotalCount", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "FinderLikeMegaVideoListResponse", "LikeMegaVideoDataFetcher", "plugin-finder_release"})
public final class FinderLikeMegaVideoLoader
  extends BaseMegaVideoLoader
{
  public int gAZ;
  public int tUU;
  
  public FinderLikeMegaVideoLoader(bbn parambbn)
  {
    super(parambbn);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(248385);
    g localg = (g)new b();
    AppMethodBeat.o(248385);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(248386);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new c(this);
    AppMethodBeat.o(248386);
    return localb;
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(248387);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(248387);
      return;
    }
    if (((paramIResponse instanceof a)) && (paramIResponse.getPullType() == 0))
    {
      this.gAZ = ((a)paramIResponse).gAZ;
      this.tUU = ((a)paramIResponse).uKM;
    }
    this.hasMore = paramIResponse.getHasMore();
    kotlin.g.a.b localb = this.fetchEndCallback;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(248387);
      return;
    }
    AppMethodBeat.o(248387);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader$FinderLikeMegaVideoListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "megaVideoTotalCount", "totalCount", "(IILjava/lang/String;II)V", "getMegaVideoTotalCount", "()I", "setMegaVideoTotalCount", "(I)V", "getTotalCount", "setTotalCount", "plugin-finder_release"})
  public static final class a
    extends IResponse<bo>
  {
    int gAZ;
    int uKM;
    
    public a(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
    {
      super(paramInt2, paramString);
      this.uKM = paramInt3;
      this.gAZ = paramInt4;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader$LikeMegaVideoDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<bo> callInit()
    {
      AppMethodBeat.i(248382);
      Log.i(getTAG(), "fetchInit");
      FinderLikeMegaVideoLoader.a locala = new FinderLikeMegaVideoLoader.a(0, 0, "", 0, 0);
      locala.setPullType(1000);
      Object localObject = this.uKO.getCache();
      if (localObject != null)
      {
        localObject = ((h)localObject).kgc;
        if (localObject != null)
        {
          Log.i(getTAG(), "fetchInit: use old data list, size: " + ((ArrayList)localObject).size());
          locala.setIncrementList((List)localObject);
          locala.uKM = ((ArrayList)localObject).size();
          localObject = this.uKO.getCache();
          if (localObject != null)
          {
            localObject = ((h)localObject).lastBuffer;
            locala.setLastBuffer((com.tencent.mm.bw.b)localObject);
          }
        }
      }
      for (;;)
      {
        localObject = (IResponse)locala;
        AppMethodBeat.o(248382);
        return localObject;
        localObject = null;
        break;
        localObject = l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGw, 11);
        Log.i(getTAG(), "fetchInit: use first page data list, size: " + ((List)localObject).size());
        locala.setIncrementList((List)localObject);
        locala.uKM = ((List)localObject).size();
      }
    }
    
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      Object localObject1 = null;
      AppMethodBeat.i(248381);
      p.h(paramq, "scene");
      if ((paramq instanceof com.tencent.mm.plugin.finder.cgi.bm))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((com.tencent.mm.plugin.finder.cgi.bm)paramq).cYA() == 0)) {}
        FinderLikeMegaVideoLoader.a locala;
        Object localObject2;
        for (boolean bool = false;; bool = true)
        {
          locala = new FinderLikeMegaVideoLoader.a(paramInt1, paramInt2, paramString, ((com.tencent.mm.plugin.finder.cgi.bm)paramq).cYy(), ((com.tencent.mm.plugin.finder.cgi.bm)paramq).getCount());
          locala.setPullType(((com.tencent.mm.plugin.finder.cgi.bm)paramq).pullType);
          paramString = ((com.tencent.mm.plugin.finder.cgi.bm)paramq).tvo;
          if (paramString == null) {
            break label342;
          }
          localObject2 = (Iterable)paramString;
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            paramString.add(new com.tencent.mm.plugin.finder.model.bm(((FinderItem)((Iterator)localObject2).next()).getFeedObject()));
          }
        }
        label342:
        for (paramString = (List)paramString;; paramString = null)
        {
          locala.setIncrementList(paramString);
          localObject2 = getTAG();
          StringBuilder localStringBuilder = new StringBuilder("incrementList size: ");
          List localList = locala.getIncrementList();
          if (localList != null) {
            localObject1 = Integer.valueOf(localList.size());
          }
          Log.i((String)localObject2, localObject1);
          locala.setLastBuffer(((com.tencent.mm.plugin.finder.cgi.bm)paramq).cYz());
          locala.setHasMore(bool);
          if (paramString == null) {
            break label362;
          }
          paramq = c.vGN;
          localObject1 = (Iterable)paramString;
          paramq = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            paramq.add(((com.tencent.mm.plugin.finder.model.bm)((Iterator)localObject1).next()).getFeedObject());
          }
        }
        c.a.b((List)paramq, this.uKO.getContextObj());
        label362:
        if (locala.getPullType() != 2)
        {
          paramq = new LinkedList();
          if (paramString != null)
          {
            paramString = ((Iterable)paramString).iterator();
            while (paramString.hasNext())
            {
              localObject1 = (com.tencent.mm.plugin.finder.model.bm)paramString.next();
              paramq.add(new u(((com.tencent.mm.plugin.finder.model.bm)localObject1).lT(), 1, ((com.tencent.mm.plugin.finder.model.bm)localObject1).getFeedObject()));
            }
          }
          if (paramq.size() > 0)
          {
            paramString = com.tencent.mm.plugin.finder.storage.data.l.vGw;
            paramString = z.aUg();
            p.g(paramString, "ConfigStorageLogic.getMyFinderUsername()");
            l.a.a(11, paramString, paramq);
          }
          Log.i(getTAG(), "LikeMegaVideoDataFetcher FinderPage size: " + paramq.size());
        }
        paramString = (IResponse)locala;
        AppMethodBeat.o(248381);
        return paramString;
      }
      AppMethodBeat.o(248381);
      return null;
    }
    
    public final com.tencent.mm.ak.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(248380);
      Object localObject = (BaseFinderFeed)this.uKO.getLastItemOfType(BaseFinderFeed.class);
      if (localObject != null)
      {
        localObject = ((BaseFinderFeed)localObject).feedObject;
        if (localObject != null)
        {
          localObject = ((FinderItem)localObject).getFeedObject();
          if (localObject == null) {}
        }
      }
      for (long l = ((FinderObject)localObject).displayId;; l = 0L)
      {
        localObject = (com.tencent.mm.ak.q)new com.tencent.mm.plugin.finder.cgi.bm(l, this.uKO.getLastBuffer(), 2, null, this.uKO.getContextObj(), 1, false, 72);
        AppMethodBeat.o(248380);
        return localObject;
      }
    }
    
    public final com.tencent.mm.ak.q genRefreshNetScene()
    {
      AppMethodBeat.i(248379);
      com.tencent.mm.ak.q localq = (com.tencent.mm.ak.q)new com.tencent.mm.plugin.finder.cgi.bm(0L, this.uKO.getLastBuffer(), 0, null, this.uKO.getContextObj(), 1, false, 72);
      AppMethodBeat.o(248379);
      return localq;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(248378);
      List localList = j.listOf(Integer.valueOf(3965));
      AppMethodBeat.o(248378);
      return localList;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<bo>.a
  {
    c()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, x> paramb)
    {
      AppMethodBeat.i(248384);
      p.h(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.Rms;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.hfT());
      d.h((kotlin.g.a.a)new a(this, new n(7, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
      AppMethodBeat.o(248384);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderLikeMegaVideoLoader.c paramc, n paramn, RefreshLoadMoreLayout.c paramc1, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.loader.FinderLikeMegaVideoLoader
 * JD-Core Version:    0.7.0.1
 */