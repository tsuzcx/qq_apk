package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.finder.cgi.ai;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.al;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "feedId", "", "nonceId", "", "tabType", "", "category", "relatedListScene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;ILjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getFeedId", "()J", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getNonceId", "refreshCallback", "getRefreshCallback", "setRefreshCallback", "getRelatedListScene", "()I", "setRelatedListScene", "(I)V", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "isObservePostEvent", "", "onFetchDone", "response", "onFetchRefreshDone", "FeedRelDataFetcher", "FinderFeedRelResponse", "plugin-finder_release"})
public final class FinderFeedRelTimelineLoader
  extends BaseFinderFeedLoader
{
  public String category;
  final long dtq;
  final int duh;
  public d.g.a.b<? super IResponse<al>, z> fetchEndCallback;
  final String rHO;
  public int rHP;
  public d.g.a.b<? super IResponse<al>, z> sbo;
  
  private FinderFeedRelTimelineLoader(long paramLong, String paramString1, int paramInt1, String paramString2, int paramInt2, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(202348);
    this.dtq = paramLong;
    this.rHO = paramString1;
    this.duh = paramInt1;
    this.category = paramString2;
    this.rHP = paramInt2;
    AppMethodBeat.o(202348);
  }
  
  public final g<al> createDataFetch()
  {
    AppMethodBeat.i(202345);
    g localg = (g)new a();
    AppMethodBeat.o(202345);
    return localg;
  }
  
  public final boolean isObservePostEvent()
  {
    return true;
  }
  
  public final void onFetchDone(IResponse<al> paramIResponse)
  {
    AppMethodBeat.i(202346);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(202346);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      d.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(202346);
        return;
      }
    }
    AppMethodBeat.o(202346);
  }
  
  public final void onFetchRefreshDone(IResponse<al> paramIResponse)
  {
    AppMethodBeat.i(202347);
    p.h(paramIResponse, "response");
    super.onFetchRefreshDone(paramIResponse);
    d.g.a.b localb = this.sbo;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(202347);
      return;
    }
    AppMethodBeat.o(202347);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FeedRelDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "plugin-finder_release"})
  public final class a
    extends a
  {
    public final IResponse<al> callInit()
    {
      Object localObject2 = null;
      AppMethodBeat.i(202343);
      FinderFeedRelTimelineLoader.b localb = new FinderFeedRelTimelineLoader.b("", 0, 0, "");
      Object localObject1 = this.sbp.getCache();
      if (localObject1 != null) {}
      for (localObject1 = ((e)localObject1).jfg;; localObject1 = null)
      {
        localb.setIncrementList((List)localObject1);
        e locale = this.sbp.getCache();
        localObject1 = localObject2;
        if (locale != null) {
          localObject1 = locale.lastBuffer;
        }
        localb.setLastBuffer((com.tencent.mm.bx.b)localObject1);
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(202343);
        return localObject1;
      }
    }
    
    public final IResponse<al> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202342);
      p.h(paramn, "scene");
      if ((paramn instanceof ai))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        Object localObject1;
        for (boolean bool = ((ai)paramn).cyj();; bool = true)
        {
          localObject2 = ((ai)paramn).getWording();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject1 = new FinderFeedRelTimelineLoader.b((String)localObject1, paramInt1, paramInt2, paramString);
          localObject2 = (Iterable)((ai)paramn).cyi();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            Object localObject4 = FinderItem.syk;
            localObject3 = FinderItem.a.a((FinderObject)localObject3, 256);
            localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
            paramString.add(b.a.j((FinderItem)localObject3));
          }
        }
        ((FinderFeedRelTimelineLoader.b)localObject1).setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
        b.a.a((List)((ai)paramn).cyi(), 1, this.sbp.getContextObj(), 4);
        Object localObject2 = getTAG();
        Object localObject3 = new StringBuilder("incrementList size: ");
        paramString = ((FinderFeedRelTimelineLoader.b)localObject1).getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          ad.i((String)localObject2, paramString);
          ((FinderFeedRelTimelineLoader.b)localObject1).setPullType(((ai)paramn).pullType);
          ((FinderFeedRelTimelineLoader.b)localObject1).setLastBuffer(((ai)paramn).cyh());
          ((FinderFeedRelTimelineLoader.b)localObject1).setHasMore(bool);
          paramString = (IResponse)localObject1;
          AppMethodBeat.o(202342);
          return paramString;
        }
      }
      AppMethodBeat.o(202342);
      return null;
    }
    
    public final n genLoadMoreNetScene()
    {
      AppMethodBeat.i(202341);
      Object localObject = new ai(this.sbp.dtq, this.sbp.rHO, this.sbp.duh, this.sbp.getLastBuffer(), this.sbp.category, this.sbp.rHP, this.sbp.getContextObj());
      ((ai)localObject).pullType = 2;
      localObject = (n)localObject;
      AppMethodBeat.o(202341);
      return localObject;
    }
    
    public final n genRefreshNetScene()
    {
      AppMethodBeat.i(202340);
      Object localObject = new ai(this.sbp.dtq, this.sbp.rHO, this.sbp.duh, this.sbp.getLastBuffer(), this.sbp.category, this.sbp.rHP, this.sbp.getContextObj());
      ((ai)localObject).pullType = 0;
      localObject = (n)localObject;
      AppMethodBeat.o(202340);
      return localObject;
    }
    
    public final int getCmdId()
    {
      return 3688;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderFeedRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "title", "", "errType", "", "errCode", "errMsg", "(Ljava/lang/String;IILjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class b
    extends IResponse<al>
  {
    public final String title;
    
    public b(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      super(paramInt2, paramString2);
      AppMethodBeat.i(202344);
      this.title = paramString1;
      AppMethodBeat.o(202344);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader
 * JD-Core Version:    0.7.0.1
 */