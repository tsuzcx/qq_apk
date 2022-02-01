package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.finder.cgi.aq;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "tabType", "", "commentScene", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IIFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getCommentScene", "()I", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getLat", "()F", "getLng", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "FinderFeedRelResponse", "RelatedDataFetcher", "plugin-finder_release"})
public final class FinderRelatedLoader
  extends BaseFinderFeedLoader
{
  final int dvm;
  public d.g.a.b<? super IResponse<am>, z> fetchEndCallback;
  final float iab;
  final float iac;
  final arv rRJ;
  private final int sch;
  
  public FinderRelatedLoader(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, arv paramarv, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(202919);
    this.dvm = paramInt1;
    this.sch = paramInt2;
    this.iac = paramFloat1;
    this.iab = paramFloat2;
    this.rRJ = paramarv;
    AppMethodBeat.o(202919);
  }
  
  public final g<am> createDataFetch()
  {
    AppMethodBeat.i(202917);
    g localg = (g)new b();
    AppMethodBeat.o(202917);
    return localg;
  }
  
  public final void onFetchDone(IResponse<am> paramIResponse)
  {
    AppMethodBeat.i(202918);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(202918);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      d.g.a.b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(202918);
        return;
      }
    }
    AppMethodBeat.o(202918);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class a
    extends IResponse<am>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$RelatedDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "plugin-finder_release"})
  public final class b
    extends a
  {
    public final IResponse<am> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(202915);
      p.h(paramn, "scene");
      if ((paramn instanceof aq))
      {
        Object localObject1;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject1 = ((aq)paramn).rr;
          if (localObject1 == null) {
            p.bdF("rr");
          }
          localObject1 = ((com.tencent.mm.ak.b)localObject1).aEV();
          if (localObject1 == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
            AppMethodBeat.o(202915);
            throw paramString;
          }
          if (((aox)localObject1).continueFlag != 0) {}
        }
        for (boolean bool = false;; bool = true)
        {
          localObject1 = new FinderRelatedLoader.a(paramInt1, paramInt2, paramString);
          localObject2 = (Iterable)((aq)paramn).czJ();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            Object localObject4 = FinderItem.sJb;
            localObject3 = FinderItem.a.a((FinderObject)localObject3, 256);
            localObject4 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
            paramString.add(b.a.j((FinderItem)localObject3));
          }
        }
        ((FinderRelatedLoader.a)localObject1).setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
        b.a.a((List)((aq)paramn).czJ(), 1, this.skG.getContextObj(), 4);
        Object localObject2 = getTAG();
        Object localObject3 = new StringBuilder("incrementList size: ");
        paramString = ((FinderRelatedLoader.a)localObject1).getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          ae.i((String)localObject2, paramString);
          ((FinderRelatedLoader.a)localObject1).setPullType(((aq)paramn).pullType);
          paramString = ((aq)paramn).rr;
          if (paramString == null) {
            p.bdF("rr");
          }
          paramString = paramString.aEV();
          if (paramString != null) {
            break;
          }
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
          AppMethodBeat.o(202915);
          throw paramString;
        }
        ((FinderRelatedLoader.a)localObject1).setLastBuffer(((aox)paramString).lastBuffer);
        ((FinderRelatedLoader.a)localObject1).setHasMore(bool);
        paramString = (IResponse)localObject1;
        AppMethodBeat.o(202915);
        return paramString;
      }
      AppMethodBeat.o(202915);
      return null;
    }
    
    public final n genLoadMoreNetScene()
    {
      AppMethodBeat.i(202914);
      Object localObject = new aq(this.skG.dvm, this.skG.getLastBuffer(), this.skG.iac, this.skG.iab, this.skG.rRJ, this.skG.getContextObj());
      ((aq)localObject).pullType = 2;
      localObject = (n)localObject;
      AppMethodBeat.o(202914);
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