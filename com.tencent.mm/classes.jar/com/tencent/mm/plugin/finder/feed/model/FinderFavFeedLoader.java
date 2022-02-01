package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.finder.cgi.bf;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isTimeline", "", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FavDataFetcher", "FinderFavListResponse", "plugin-finder_release"})
public final class FinderFavFeedLoader
  extends BaseFinderFeedLoader
{
  public int fTM;
  public d.g.a.b<? super IResponse<al>, z> fetchEndCallback;
  public boolean hasMore;
  private final String sbk;
  final boolean sbl;
  
  public FinderFavFeedLoader(String paramString, aqy paramaqy, boolean paramBoolean)
  {
    super(paramaqy);
    AppMethodBeat.i(202339);
    this.sbk = paramString;
    this.sbl = paramBoolean;
    AppMethodBeat.o(202339);
  }
  
  public final g<al> createDataFetch()
  {
    AppMethodBeat.i(202336);
    g localg = (g)new a();
    AppMethodBeat.o(202336);
    return localg;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<al> createDataMerger()
  {
    AppMethodBeat.i(202337);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new c(this);
    AppMethodBeat.o(202337);
    return localb;
  }
  
  public final void onFetchDone(IResponse<al> paramIResponse)
  {
    AppMethodBeat.i(202338);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(202338);
      return;
    }
    if ((paramIResponse.getPullType() == 0) && ((paramIResponse instanceof b))) {
      this.fTM = ((b)paramIResponse).fTM;
    }
    this.hasMore = paramIResponse.getHasMore();
    d.g.a.b localb = this.fetchEndCallback;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(202338);
      return;
    }
    AppMethodBeat.o(202338);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FavDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<al> callInit()
    {
      Object localObject2 = null;
      AppMethodBeat.i(202333);
      ad.i(getTAG(), "fetchInit initCount ");
      FinderFavFeedLoader.b localb = new FinderFavFeedLoader.b(0, 0, "", 0);
      Object localObject1;
      if (this.sbm.sbl)
      {
        localObject1 = this.sbm.getCache();
        if (localObject1 != null)
        {
          localObject1 = ((e)localObject1).jfg;
          localb.setIncrementList((List)localObject1);
          e locale = this.sbm.getCache();
          localObject1 = localObject2;
          if (locale != null) {
            localObject1 = locale.lastBuffer;
          }
          localb.setLastBuffer((com.tencent.mm.bx.b)localObject1);
        }
      }
      for (;;)
      {
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(202333);
        return localObject1;
        localObject1 = null;
        break;
        localObject1 = k.sAe;
        localb.setIncrementList(k.a.Fu(10));
      }
    }
    
    public final IResponse<al> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202332);
      p.h(paramn, "scene");
      if ((paramn instanceof bf))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject1 = ((bf)paramn).rr.aEF();
          if (localObject1 == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
            AppMethodBeat.o(202332);
            throw paramString;
          }
          if (((ann)localObject1).continueFlag != 0) {}
        }
        Object localObject4;
        for (boolean bool = false;; bool = true)
        {
          localObject1 = (bf)paramn;
          localObject2 = ((bf)localObject1).TAG;
          localObject3 = new StringBuilder("favCount = ");
          localObject4 = ((bf)localObject1).rr.aEF();
          if (localObject4 != null) {
            break;
          }
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(202332);
          throw paramString;
        }
        ad.i((String)localObject2, ((ann)localObject4).fTM);
        Object localObject1 = ((bf)localObject1).rr.aEF();
        if (localObject1 == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(202332);
          throw paramString;
        }
        localObject1 = new FinderFavFeedLoader.b(paramInt1, paramInt2, paramString, ((ann)localObject1).fTM);
        Object localObject2 = (Iterable)((bf)paramn).cyt();
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FinderObject)((Iterator)localObject2).next();
          localObject4 = FinderItem.syk;
          localObject3 = FinderItem.a.a((FinderObject)localObject3, 256);
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
          paramString.add(b.a.j((FinderItem)localObject3));
        }
        ((FinderFavFeedLoader.b)localObject1).setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
        b.a.a(((bf)paramn).cyt(), 256, this.sbm.getContextObj(), 4);
        if (((bf)paramn).pullType != 2)
        {
          paramString = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
          paramString = ((FinderFavFeedLoader.b)localObject1).getIncrementList();
          if (paramString == null)
          {
            paramString = new v("null cannot be cast to non-null type kotlin.collections.List<com.tencent.mm.plugin.finder.model.BaseFinderFeed>");
            AppMethodBeat.o(202332);
            throw paramString;
          }
          b.a.b(paramString, 256, true);
        }
        localObject2 = getTAG();
        Object localObject3 = new StringBuilder("incrementList size: ");
        paramString = ((FinderFavFeedLoader.b)localObject1).getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          ad.i((String)localObject2, paramString);
          ((FinderFavFeedLoader.b)localObject1).setPullType(((bf)paramn).pullType);
          paramString = ((bf)paramn).rr.aEF();
          if (paramString != null) {
            break;
          }
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(202332);
          throw paramString;
        }
        ((FinderFavFeedLoader.b)localObject1).setLastBuffer(((ann)paramString).lastBuffer);
        ((FinderFavFeedLoader.b)localObject1).setHasMore(bool);
        paramString = (IResponse)localObject1;
        AppMethodBeat.o(202332);
        return paramString;
      }
      AppMethodBeat.o(202332);
      return null;
    }
    
    public final n genLoadMoreNetScene()
    {
      AppMethodBeat.i(202331);
      Object localObject = new bf(FinderFavFeedLoader.a(this.sbm), this.sbm.getLastBuffer(), this.sbm.getContextObj());
      ((bf)localObject).pullType = 2;
      localObject = (n)localObject;
      AppMethodBeat.o(202331);
      return localObject;
    }
    
    public final n genRefreshNetScene()
    {
      AppMethodBeat.i(202330);
      Object localObject = new bf(FinderFavFeedLoader.a(this.sbm), this.sbm.getLastBuffer(), this.sbm.getContextObj());
      ((bf)localObject).pullType = 0;
      localObject = (n)localObject;
      AppMethodBeat.o(202330);
      return localObject;
    }
    
    public final int getCmdId()
    {
      return 3966;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "(IILjava/lang/String;I)V", "getTotalCount", "()I", "setTotalCount", "(I)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<al>
  {
    int fTM;
    
    public b(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      super(paramInt2, paramString);
      this.fTM = paramInt3;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<al>.a
  {
    c()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<al> paramIResponse, final d.g.a.b<? super IResponse<al>, z> paramb)
    {
      int i = 0;
      AppMethodBeat.i(202335);
      p.h(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      Object localObject;
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        localObject = aj.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        localc.Lrh = ((CharSequence)((Context)localObject).getResources().getString(2131759373));
        localc.Lrg = 1;
        if (paramIResponse.getPullType() == 0) {
          break label291;
        }
        bool = true;
        label86:
        localc.iLW = bool;
        localc.Lri = paramIResponse.getHasMore();
        if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.Lrj > 0)) {
          localc.Lrh = null;
        }
        localc.hNZ = Integer.valueOf(((FinderFavFeedLoader.b)paramIResponse).fTM);
        ad.i(this.sbm.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        localObject = paramIResponse.getIncrementList();
        if (localObject != null) {
          i = ((List)localObject).size();
        }
        if (!paramIResponse.getHasMore()) {
          break label297;
        }
        if (i > this.sbm.getDataList().size()) {
          break label372;
        }
        i = 2;
      }
      for (;;)
      {
        c.g((d.g.a.a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.l(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(202335);
        return;
        localObject = aj.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        localc.Lrh = ((CharSequence)((Context)localObject).getResources().getString(2131759383));
        localc.Lrg = -1;
        break;
        label291:
        bool = false;
        break label86;
        label297:
        if ((this.sbm.getDataList().size() == 0) || (i == 0) || (this.sbm.getDataList().size() <= i))
        {
          localObject = paramIResponse.getIncrementList();
          if ((localObject != null) && (((List)localObject).containsAll((Collection)j.l((Iterable)this.sbm.getDataList())) == true))
          {
            i = 6;
            continue;
          }
        }
        label372:
        i = 4;
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(FinderFavFeedLoader.c paramc, com.tencent.mm.plugin.finder.feed.model.internal.l paraml, RefreshLoadMoreLayout.c paramc1, d.g.a.b paramb, IResponse paramIResponse)
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