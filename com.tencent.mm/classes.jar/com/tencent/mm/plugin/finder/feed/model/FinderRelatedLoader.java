package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.finder.cgi.ap;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "tabType", "", "commentScene", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IIFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getCommentScene", "()I", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getLat", "()F", "getLng", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "FinderFeedRelResponse", "RelatedDataFetcher", "plugin-finder_release"})
public final class FinderRelatedLoader
  extends BaseFinderFeedLoader
{
  final int duh;
  public d.g.a.b<? super IResponse<al>, z> fetchEndCallback;
  final float hXj;
  final float hXk;
  final arg rJv;
  private final int rTD;
  
  public FinderRelatedLoader(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, arg paramarg, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(202443);
    this.duh = paramInt1;
    this.rTD = paramInt2;
    this.hXk = paramFloat1;
    this.hXj = paramFloat2;
    this.rJv = paramarg;
    AppMethodBeat.o(202443);
  }
  
  public final g<al> createDataFetch()
  {
    AppMethodBeat.i(202441);
    g localg = (g)new b();
    AppMethodBeat.o(202441);
    return localg;
  }
  
  public final void onFetchDone(IResponse<al> paramIResponse)
  {
    AppMethodBeat.i(202442);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(202442);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      d.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(202442);
        return;
      }
    }
    AppMethodBeat.o(202442);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class a
    extends IResponse<al>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$RelatedDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "plugin-finder_release"})
  public final class b
    extends a
  {
    public final IResponse<al> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202439);
      p.h(paramn, "scene");
      if ((paramn instanceof ap))
      {
        Object localObject1;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject1 = ((ap)paramn).rr;
          if (localObject1 == null) {
            p.bcb("rr");
          }
          localObject1 = ((com.tencent.mm.al.b)localObject1).aEF();
          if (localObject1 == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
            AppMethodBeat.o(202439);
            throw paramString;
          }
          if (((aok)localObject1).continueFlag != 0) {}
        }
        for (boolean bool = false;; bool = true)
        {
          localObject1 = new FinderRelatedLoader.a(paramInt1, paramInt2, paramString);
          localObject2 = (Iterable)((ap)paramn).cyi();
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
        ((FinderRelatedLoader.a)localObject1).setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
        b.a.a((List)((ap)paramn).cyi(), 1, this.sbP.getContextObj(), 4);
        Object localObject2 = getTAG();
        Object localObject3 = new StringBuilder("incrementList size: ");
        paramString = ((FinderRelatedLoader.a)localObject1).getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          ad.i((String)localObject2, paramString);
          ((FinderRelatedLoader.a)localObject1).setPullType(((ap)paramn).pullType);
          paramString = ((ap)paramn).rr;
          if (paramString == null) {
            p.bcb("rr");
          }
          paramString = paramString.aEF();
          if (paramString != null) {
            break;
          }
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
          AppMethodBeat.o(202439);
          throw paramString;
        }
        ((FinderRelatedLoader.a)localObject1).setLastBuffer(((aok)paramString).lastBuffer);
        ((FinderRelatedLoader.a)localObject1).setHasMore(bool);
        paramString = (IResponse)localObject1;
        AppMethodBeat.o(202439);
        return paramString;
      }
      AppMethodBeat.o(202439);
      return null;
    }
    
    public final n genLoadMoreNetScene()
    {
      AppMethodBeat.i(202438);
      Object localObject = new ap(this.sbP.duh, this.sbP.getLastBuffer(), this.sbP.hXk, this.sbP.hXj, this.sbP.rJv, this.sbP.getContextObj());
      ((ap)localObject).pullType = 2;
      localObject = (n)localObject;
      AppMethodBeat.o(202438);
      return localObject;
    }
    
    public final n genRefreshNetScene()
    {
      return null;
    }
    
    public final int getCmdId()
    {
      return 3688;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader
 * JD-Core Version:    0.7.0.1
 */