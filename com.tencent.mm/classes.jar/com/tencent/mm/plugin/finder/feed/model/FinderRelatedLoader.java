package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.bq;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "tabType", "", "commentScene", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IIFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getCommentScene", "()I", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getLat", "()F", "getLng", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "FinderFeedRelResponse", "RelatedDataFetcher", "plugin-finder_release"})
public final class FinderRelatedLoader
  extends BaseFinderFeedLoader
{
  final int dLS;
  public b<? super IResponse<bo>, x> fetchEndCallback;
  final float iUY;
  final float iUZ;
  private final int tCE;
  final bcc tvs;
  
  public FinderRelatedLoader(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, bcc parambcc, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(244859);
    this.dLS = paramInt1;
    this.tCE = paramInt2;
    this.iUZ = paramFloat1;
    this.iUY = paramFloat2;
    this.tvs = parambcc;
    AppMethodBeat.o(244859);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(244857);
    g localg = (g)new b();
    AppMethodBeat.o(244857);
    return localg;
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244858);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(244858);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(244858);
        return;
      }
    }
    AppMethodBeat.o(244858);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class a
    extends IResponse<bo>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$RelatedDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends a
  {
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(244855);
      p.h(paramq, "scene");
      if ((paramq instanceof bq))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {}
        FinderRelatedLoader.a locala;
        for (boolean bool = ((bq)paramq).cYp();; bool = true)
        {
          locala = new FinderRelatedLoader.a(paramInt1, paramInt2, paramString);
          localObject1 = (Iterable)((bq)paramq).cYr();
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
        locala.setIncrementList((List)paramString);
        paramString = c.vGN;
        c.a.a((List)((bq)paramq).cYr(), 1, this.tXi.getContextObj());
        Object localObject1 = getTAG();
        Object localObject2 = new StringBuilder("incrementList size: ");
        paramString = locala.getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          Log.i((String)localObject1, paramString);
          locala.setPullType(((bq)paramq).pullType);
          locala.setLastBuffer(((bq)paramq).cYm());
          locala.setHasMore(bool);
          paramString = (IResponse)locala;
          AppMethodBeat.o(244855);
          return paramString;
        }
      }
      AppMethodBeat.o(244855);
      return null;
    }
    
    public final q genLoadMoreNetScene()
    {
      AppMethodBeat.i(244854);
      Object localObject = new bq(this.tXi.dLS, this.tXi.getLastBuffer(), this.tXi.iUZ, this.tXi.iUY, this.tXi.tvs, this.tXi.getContextObj());
      ((bq)localObject).pullType = 2;
      localObject = (q)localObject;
      AppMethodBeat.o(244854);
      return localObject;
    }
    
    public final q genRefreshNetScene()
    {
      return null;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(244853);
      List localList = j.listOf(Integer.valueOf(3688));
      AppMethodBeat.o(244853);
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader
 * JD-Core Version:    0.7.0.1
 */