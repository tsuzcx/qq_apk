package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.plugin.finder.cgi.cr;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "tabType", "", "commentScene", "lng", "", "lat", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(IIFFLcom/tencent/mm/protocal/protobuf/FinderSectionInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getCommentScene", "()I", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "getLat", "()F", "getLng", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getTabType", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "FinderFeedRelResponse", "RelatedDataFetcher", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderRelatedLoader
  extends BaseFinderFeedLoader
{
  final bve ACr;
  private final int AJo;
  public b<? super IResponse<cc>, ah> fetchEndCallback;
  final int hJx;
  final float oDT;
  final float oDU;
  
  public FinderRelatedLoader(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, bve parambve, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(366080);
    this.hJx = paramInt1;
    this.AJo = paramInt2;
    this.oDU = paramFloat1;
    this.oDT = paramFloat2;
    this.ACr = parambve;
    AppMethodBeat.o(366080);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(366087);
    i locali = (i)new b();
    AppMethodBeat.o(366087);
    return locali;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366091);
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(366091);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      b localb = this.fetchEndCallback;
      if (localb != null) {
        localb.invoke(paramIResponse);
      }
    }
    AppMethodBeat.o(366091);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends IResponse<cc>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$RelatedDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/FinderRelatedLoader$FinderFeedRelResponse;", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public b()
    {
      AppMethodBeat.i(366145);
      AppMethodBeat.o(366145);
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      Object localObject2 = null;
      AppMethodBeat.i(366179);
      s.u(paramp, "scene");
      if ((paramp instanceof cr))
      {
        Object localObject1;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject3 = ((cr)paramp).rr;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("rr");
            localObject1 = null;
          }
          localObject1 = c.c.b(((com.tencent.mm.am.c)localObject1).otC);
          if (localObject1 == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
            AppMethodBeat.o(366179);
            throw paramString;
          }
          if (((baw)localObject1).continueFlag != 0) {}
        }
        for (boolean bool = false;; bool = true)
        {
          localObject1 = new FinderRelatedLoader.a(paramInt1, paramInt2, paramString);
          localObject3 = (Iterable)((cr)paramp).dVP();
          paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Object localObject4 = (FinderObject)((Iterator)localObject3).next();
            Object localObject5 = FinderItem.Companion;
            localObject4 = FinderItem.a.e((FinderObject)localObject4, 256);
            localObject5 = d.FND;
            paramString.add(d.a.a((FinderItem)localObject4));
          }
        }
        ((FinderRelatedLoader.a)localObject1).setIncrementList((List)paramString);
        paramString = d.FND;
        d.a.a((List)((cr)paramp).dVP(), 1, this.BiS.getContextObj());
        Object localObject3 = getTAG();
        paramString = ((FinderRelatedLoader.a)localObject1).getIncrementList();
        if (paramString == null)
        {
          paramString = null;
          Log.i((String)localObject3, s.X("incrementList size: ", paramString));
          ((FinderRelatedLoader.a)localObject1).setPullType(((cr)paramp).pullType);
          paramString = ((cr)paramp).rr;
          if (paramString != null) {
            break label360;
          }
          s.bIx("rr");
          paramString = localObject2;
        }
        label360:
        for (;;)
        {
          paramString = c.c.b(paramString.otC);
          if (paramString != null) {
            break label363;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetRelatedListResp");
          AppMethodBeat.o(366179);
          throw paramString;
          paramString = Integer.valueOf(paramString.size());
          break;
        }
        label363:
        ((FinderRelatedLoader.a)localObject1).setLastBuffer(((baw)paramString).lastBuffer);
        ((FinderRelatedLoader.a)localObject1).setHasMore(bool);
        paramString = (IResponse)localObject1;
        AppMethodBeat.o(366179);
        return paramString;
      }
      AppMethodBeat.o(366179);
      return null;
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(366164);
      Object localObject = new cr(this.BiS.hJx, this.BiS.getLastBuffer(), this.BiS.oDU, this.BiS.oDT, this.BiS.ACr, this.BiS.getContextObj());
      ((cr)localObject).pullType = 2;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(366164);
      return localObject;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      return null;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(366151);
      List localList = kotlin.a.p.listOf(Integer.valueOf(3688));
      AppMethodBeat.o(366151);
      return localList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader
 * JD-Core Version:    0.7.0.1
 */