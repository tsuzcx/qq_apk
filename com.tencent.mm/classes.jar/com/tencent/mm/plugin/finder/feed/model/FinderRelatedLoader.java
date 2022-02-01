package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.finder.cgi.bt;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "tabType", "", "commentScene", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IIFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getCommentScene", "()I", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getLat", "()F", "getLng", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "FinderFeedRelResponse", "RelatedDataFetcher", "plugin-finder_release"})
public final class FinderRelatedLoader
  extends BaseFinderFeedLoader
{
  final int fEH;
  public b<? super IResponse<bu>, x> fetchEndCallback;
  final float lLr;
  final float lLs;
  final biv xcZ;
  private final int xkX;
  
  public FinderRelatedLoader(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, biv parambiv, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(253964);
    this.fEH = paramInt1;
    this.xkX = paramInt2;
    this.lLs = paramFloat1;
    this.lLr = paramFloat2;
    this.xcZ = parambiv;
    AppMethodBeat.o(253964);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(253960);
    i locali = (i)new b();
    AppMethodBeat.o(253960);
    return locali;
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(253962);
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(253962);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      b localb = this.fetchEndCallback;
      if (localb != null)
      {
        localb.invoke(paramIResponse);
        AppMethodBeat.o(253962);
        return;
      }
    }
    AppMethodBeat.o(253962);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class a
    extends IResponse<bu>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$RelatedDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(280391);
      p.k(paramq, "scene");
      if ((paramq instanceof bt))
      {
        Object localObject1;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject1 = ((bt)paramq).rr;
          if (localObject1 == null) {
            p.bGy("rr");
          }
          localObject1 = ((d)localObject1).bhY();
          if (localObject1 == null)
          {
            paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
            AppMethodBeat.o(280391);
            throw paramString;
          }
          if (((avs)localObject1).continueFlag != 0) {}
        }
        for (boolean bool = false;; bool = true)
        {
          localObject1 = new FinderRelatedLoader.a(paramInt1, paramInt2, paramString);
          localObject2 = (Iterable)((bt)paramq).dof();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderObject)((Iterator)localObject2).next();
            Object localObject4 = FinderItem.Companion;
            localObject3 = FinderItem.a.b((FinderObject)localObject3, 256);
            localObject4 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
            paramString.add(c.a.a((FinderItem)localObject3));
          }
        }
        ((FinderRelatedLoader.a)localObject1).setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        c.a.a((List)((bt)paramq).dof(), 1, this.xJi.getContextObj());
        Object localObject2 = getTAG();
        Object localObject3 = new StringBuilder("incrementList size: ");
        paramString = ((FinderRelatedLoader.a)localObject1).getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          Log.i((String)localObject2, paramString);
          ((FinderRelatedLoader.a)localObject1).setPullType(((bt)paramq).pullType);
          paramString = ((bt)paramq).rr;
          if (paramString == null) {
            p.bGy("rr");
          }
          paramString = paramString.bhY();
          if (paramString != null) {
            break;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
          AppMethodBeat.o(280391);
          throw paramString;
        }
        ((FinderRelatedLoader.a)localObject1).setLastBuffer(((avs)paramString).lastBuffer);
        ((FinderRelatedLoader.a)localObject1).setHasMore(bool);
        paramString = (IResponse)localObject1;
        AppMethodBeat.o(280391);
        return paramString;
      }
      AppMethodBeat.o(280391);
      return null;
    }
    
    public final q genLoadMoreNetScene()
    {
      AppMethodBeat.i(280389);
      Object localObject = new bt(this.xJi.fEH, this.xJi.getLastBuffer(), this.xJi.lLs, this.xJi.lLr, this.xJi.xcZ, this.xJi.getContextObj());
      ((bt)localObject).pullType = 2;
      localObject = (q)localObject;
      AppMethodBeat.o(280389);
      return localObject;
    }
    
    public final q genRefreshNetScene()
    {
      return null;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(280388);
      List localList = j.listOf(Integer.valueOf(3688));
      AppMethodBeat.o(280388);
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader
 * JD-Core Version:    0.7.0.1
 */