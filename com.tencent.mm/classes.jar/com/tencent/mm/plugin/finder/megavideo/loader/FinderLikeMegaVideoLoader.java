package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bp;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "megaVideoCount", "", "getMegaVideoCount", "()I", "setMegaVideoCount", "(I)V", "totalCount", "getTotalCount", "setTotalCount", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "FinderLikeMegaVideoListResponse", "LikeMegaVideoDataFetcher", "plugin-finder_release"})
public final class FinderLikeMegaVideoLoader
  extends BaseMegaVideoLoader
{
  public int jlf;
  public int xGy;
  
  public FinderLikeMegaVideoLoader(bid parambid)
  {
    super(parambid);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(280051);
    i locali = (i)new b();
    AppMethodBeat.o(280051);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(280053);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new c(this);
    AppMethodBeat.o(280053);
    return locald;
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(280054);
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(280054);
      return;
    }
    if (((paramIResponse instanceof a)) && (paramIResponse.getPullType() == 0))
    {
      this.jlf = ((a)paramIResponse).jlf;
      this.xGy = ((a)paramIResponse).zwD;
    }
    this.hasMore = paramIResponse.getHasMore();
    kotlin.g.a.b localb = this.fetchEndCallback;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(280054);
      return;
    }
    AppMethodBeat.o(280054);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader$FinderLikeMegaVideoListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "megaVideoTotalCount", "totalCount", "(IILjava/lang/String;II)V", "getMegaVideoTotalCount", "()I", "setMegaVideoTotalCount", "(I)V", "getTotalCount", "setTotalCount", "plugin-finder_release"})
  public static final class a
    extends IResponse<bu>
  {
    int jlf;
    int zwD;
    
    public a(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
    {
      super(paramInt2, paramString);
      this.zwD = paramInt3;
      this.jlf = paramInt4;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader$LikeMegaVideoDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public final IResponse<bu> callInit()
    {
      AppMethodBeat.i(241085);
      Log.i(getTAG(), "fetchInit");
      FinderLikeMegaVideoLoader.a locala = new FinderLikeMegaVideoLoader.a(0, 0, "", 0, 0);
      locala.setPullType(1000);
      Object localObject = this.zwF.getCache();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.feed.model.q)localObject).mXB;
        if (localObject != null)
        {
          Log.i(getTAG(), "fetchInit: use old data list, size: " + ((ArrayList)localObject).size());
          locala.setIncrementList((List)localObject);
          locala.zwD = ((ArrayList)localObject).size();
          localObject = this.zwF.getCache();
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.finder.feed.model.q)localObject).lastBuffer;
            locala.setLastBuffer((com.tencent.mm.cd.b)localObject);
          }
        }
      }
      for (;;)
      {
        localObject = (IResponse)locala;
        AppMethodBeat.o(241085);
        return localObject;
        localObject = null;
        break;
        localObject = k.a.a(k.Anu, 11);
        Log.i(getTAG(), "fetchInit: use first page data list, size: " + ((List)localObject).size());
        locala.setIncrementList((List)localObject);
        locala.zwD = ((List)localObject).size();
      }
    }
    
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      Object localObject1 = null;
      AppMethodBeat.i(241081);
      p.k(paramq, "scene");
      if ((paramq instanceof bp))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((bp)paramq).doo() == 0)) {}
        FinderLikeMegaVideoLoader.a locala;
        Object localObject2;
        for (boolean bool = false;; bool = true)
        {
          locala = new FinderLikeMegaVideoLoader.a(paramInt1, paramInt2, paramString, ((bp)paramq).dom(), ((bp)paramq).getCount());
          locala.setPullType(((bp)paramq).pullType);
          paramString = ((bp)paramq).xcV;
          if (paramString == null) {
            break label342;
          }
          localObject2 = (Iterable)paramString;
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            paramString.add(new bs(((FinderItem)((Iterator)localObject2).next()).getFeedObject()));
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
          locala.setLastBuffer(((bp)paramq).don());
          locala.setHasMore(bool);
          if (paramString == null) {
            break label362;
          }
          paramq = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          localObject1 = (Iterable)paramString;
          paramq = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            paramq.add(((bs)((Iterator)localObject1).next()).getFeedObject());
          }
        }
        c.a.b((List)paramq, this.zwF.getContextObj());
        label362:
        if (locala.getPullType() != 2)
        {
          paramq = new LinkedList();
          if (paramString != null)
          {
            paramString = ((Iterable)paramString).iterator();
            while (paramString.hasNext())
            {
              localObject1 = (bs)paramString.next();
              paramq.add(new t(((bs)localObject1).mf(), 1, ((bs)localObject1).getFeedObject()));
            }
          }
          if (paramq.size() > 0)
          {
            paramString = k.Anu;
            paramString = z.bdh();
            p.j(paramString, "ConfigStorageLogic.getMyFinderUsername()");
            k.a.a(11, paramString, paramq);
          }
          Log.i(getTAG(), "LikeMegaVideoDataFetcher FinderPage size: " + paramq.size());
        }
        paramString = (IResponse)locala;
        AppMethodBeat.o(241081);
        return paramString;
      }
      AppMethodBeat.o(241081);
      return null;
    }
    
    public final com.tencent.mm.an.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(241075);
      Object localObject = (BaseFinderFeed)this.zwF.getLastItemOfType(BaseFinderFeed.class);
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
        localObject = (com.tencent.mm.an.q)new bp(l, this.zwF.getLastBuffer(), 2, null, this.zwF.getContextObj(), 1, false, 72);
        AppMethodBeat.o(241075);
        return localObject;
      }
    }
    
    public final com.tencent.mm.an.q genRefreshNetScene()
    {
      AppMethodBeat.i(241071);
      com.tencent.mm.an.q localq = (com.tencent.mm.an.q)new bp(0L, this.zwF.getLastBuffer(), 0, null, this.zwF.getContextObj(), 1, false, 72);
      AppMethodBeat.o(241071);
      return localq;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(241068);
      List localList = j.listOf(Integer.valueOf(3965));
      AppMethodBeat.o(241068);
      return localList;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<bu>.a
  {
    c()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bu> paramIResponse, final kotlin.g.a.b<? super IResponse<bu>, x> paramb)
    {
      AppMethodBeat.i(264316);
      p.k(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.YNO;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.ihs());
      com.tencent.mm.ae.d.uiThread((a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.q(7, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
      AppMethodBeat.o(264316);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements a<x>
    {
      a(FinderLikeMegaVideoLoader.c paramc, com.tencent.mm.plugin.finder.feed.model.internal.q paramq, RefreshLoadMoreLayout.c paramc1, kotlin.g.a.b paramb, IResponse paramIResponse)
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