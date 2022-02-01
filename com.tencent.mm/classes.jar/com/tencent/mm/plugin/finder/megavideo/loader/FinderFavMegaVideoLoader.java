package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ct;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.data.t;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "megaVideoCount", "", "getMegaVideoCount", "()I", "setMegaVideoCount", "(I)V", "totalCount", "getTotalCount", "setTotalCount", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "FavMegaVideoDataFetcher", "FinderFavMegaVideoListResponse", "plugin-finder_release"})
public final class FinderFavMegaVideoLoader
  extends BaseMegaVideoLoader
{
  public int jlf;
  private final String whH;
  public int xGy;
  
  public FinderFavMegaVideoLoader(String paramString, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(271851);
    this.whH = paramString;
    AppMethodBeat.o(271851);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(271848);
    i locali = (i)new a();
    AppMethodBeat.o(271848);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(271849);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new c(this);
    AppMethodBeat.o(271849);
    return locald;
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(271850);
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(271850);
      return;
    }
    if (((paramIResponse instanceof b)) && (paramIResponse.getPullType() == 0))
    {
      this.jlf = ((b)paramIResponse).jlf;
      this.xGy = ((b)paramIResponse).zwD;
    }
    this.hasMore = paramIResponse.getHasMore();
    kotlin.g.a.b localb = this.fetchEndCallback;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(271850);
      return;
    }
    AppMethodBeat.o(271850);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader$FavMegaVideoDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public final IResponse<bu> callInit()
    {
      AppMethodBeat.i(258329);
      Log.i(getTAG(), "fetchInit");
      FinderFavMegaVideoLoader.b localb = new FinderFavMegaVideoLoader.b(0, 0, "", 0, 0);
      localb.setPullType(1000);
      Object localObject = this.zwC.getCache();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.feed.model.q)localObject).mXB;
        if (localObject != null)
        {
          Log.i(getTAG(), "fetchInit: use old data list, size: " + ((ArrayList)localObject).size());
          localb.setIncrementList((List)localObject);
          localb.zwD = ((ArrayList)localObject).size();
          localObject = this.zwC.getCache();
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.finder.feed.model.q)localObject).lastBuffer;
            localb.setLastBuffer((com.tencent.mm.cd.b)localObject);
          }
        }
      }
      for (;;)
      {
        localObject = (IResponse)localb;
        AppMethodBeat.o(258329);
        return localObject;
        localObject = null;
        break;
        localObject = k.a.a(k.Anu, 12);
        Log.i(getTAG(), "fetchInit: use first page data list, size: " + ((List)localObject).size());
        localb.setIncrementList((List)localObject);
        localb.zwD = ((List)localObject).size();
      }
    }
    
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(258328);
      p.k(paramq, "scene");
      if ((paramq instanceof ct))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((ct)paramq).doo() == 0)) {}
        FinderFavMegaVideoLoader.b localb;
        for (boolean bool = false;; bool = true)
        {
          localb = new FinderFavMegaVideoLoader.b(paramInt1, paramInt2, paramString, ((ct)paramq).dom(), ((ct)paramq).dpe());
          localb.setPullType(((ct)paramq).pullType);
          localObject = (Iterable)((ct)paramq).dow();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramString.add(new bs((FinderObject)((Iterator)localObject).next()));
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
          localb.setLastBuffer(((ct)paramq).don());
          localb.setHasMore(bool);
          paramString = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          c.a.b((List)((ct)paramq).dow(), this.zwC.getContextObj());
          if (localb.getPullType() == 2) {
            break label417;
          }
          paramString = new LinkedList();
          paramq = ((Iterable)localObject).iterator();
          while (paramq.hasNext())
          {
            localObject = (bs)paramq.next();
            paramString.add(new t(((bs)localObject).mf(), 1, ((bs)localObject).getFeedObject()));
          }
        }
        if (paramString.size() > 0)
        {
          paramq = k.Anu;
          paramq = z.bdh();
          p.j(paramq, "ConfigStorageLogic.getMyFinderUsername()");
          k.a.a(12, paramq, paramString);
        }
        Log.i(getTAG(), "FavMegaVideoDataFetcher FinderPage size: " + paramString.size());
        label417:
        paramString = (IResponse)localb;
        AppMethodBeat.o(258328);
        return paramString;
      }
      AppMethodBeat.o(258328);
      return null;
    }
    
    public final com.tencent.mm.an.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(258327);
      Object localObject = new ct(FinderFavMegaVideoLoader.a(this.zwC), this.zwC.getLastBuffer(), this.zwC.getContextObj(), 1L, (byte)0);
      ((ct)localObject).pullType = 2;
      localObject = (com.tencent.mm.an.q)localObject;
      AppMethodBeat.o(258327);
      return localObject;
    }
    
    public final com.tencent.mm.an.q genRefreshNetScene()
    {
      AppMethodBeat.i(258326);
      Object localObject = new ct(FinderFavMegaVideoLoader.a(this.zwC), this.zwC.getLastBuffer(), this.zwC.getContextObj(), 1L, (byte)0);
      ((ct)localObject).pullType = 0;
      localObject = (com.tencent.mm.an.q)localObject;
      AppMethodBeat.o(258326);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(258325);
      List localList = j.listOf(Integer.valueOf(3966));
      AppMethodBeat.o(258325);
      return localList;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader$FinderFavMegaVideoListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "megaVideoTotalCount", "totalCount", "(IILjava/lang/String;II)V", "getMegaVideoTotalCount", "()I", "setMegaVideoTotalCount", "(I)V", "getTotalCount", "setTotalCount", "plugin-finder_release"})
  public static final class b
    extends IResponse<bu>
  {
    int jlf;
    int zwD;
    
    public b(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
    {
      super(paramInt2, paramString);
      this.zwD = paramInt3;
      this.jlf = paramInt4;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<bu>.a
  {
    c()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bu> paramIResponse, final kotlin.g.a.b<? super IResponse<bu>, x> paramb)
    {
      AppMethodBeat.i(282869);
      p.k(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.YNO;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.ihs());
      com.tencent.mm.ae.d.uiThread((a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.q(7, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
      AppMethodBeat.o(282869);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements a<x>
    {
      a(FinderFavMegaVideoLoader.c paramc, com.tencent.mm.plugin.finder.feed.model.internal.q paramq, RefreshLoadMoreLayout.c paramc1, kotlin.g.a.b paramb, IResponse paramIResponse)
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