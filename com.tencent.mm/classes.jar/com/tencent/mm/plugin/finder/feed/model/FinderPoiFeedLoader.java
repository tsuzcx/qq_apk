package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ca;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.i.a.y.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.eak;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$PoiDataFetcher;", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "getFromType", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "setFromType", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "location", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/SnsLocation;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Companion", "FinderPoiStreamListResponse", "PoiDataFetcher", "plugin-finder_release"})
public final class FinderPoiFeedLoader
  extends BaseFinderFeedLoader
{
  public static final a tWA;
  public kotlin.g.a.b<? super IResponse<bo>, x> fetchEndCallback;
  private boolean hasMore;
  private c tWx;
  public eaa tWy;
  public y.a tWz;
  
  static
  {
    AppMethodBeat.i(244759);
    tWA = new a((byte)0);
    AppMethodBeat.o(244759);
  }
  
  public FinderPoiFeedLoader(bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(244758);
    this.tWx = new c();
    AppMethodBeat.o(244758);
  }
  
  public final g<bo> createDataFetch()
  {
    return (g)this.tWx;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.b<bo> createDataMerger()
  {
    AppMethodBeat.i(244756);
    com.tencent.mm.plugin.finder.feed.model.internal.b localb = (com.tencent.mm.plugin.finder.feed.model.internal.b)new d(this);
    AppMethodBeat.o(244756);
    return localb;
  }
  
  public final void onFetchDone(IResponse<bo> paramIResponse)
  {
    AppMethodBeat.i(244757);
    p.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    this.hasMore = paramIResponse.getHasMore();
    kotlin.g.a.b localb = this.fetchEndCallback;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(244757);
      return;
    }
    AppMethodBeat.o(244757);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$FinderPoiStreamListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "hasFeedData", "", "getHasFeedData", "()Z", "setHasFeedData", "(Z)V", "noticeWording", "getNoticeWording", "()Ljava/lang/String;", "setNoticeWording", "(Ljava/lang/String;)V", "poiDetail", "Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;", "getPoiDetail", "()Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;", "setPoiDetail", "(Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<bo>
  {
    public eak tWB;
    public boolean tWC;
    public String tWD = "";
    
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$PoiDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.a
  {
    public final IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      boolean bool2 = true;
      AppMethodBeat.i(244753);
      p.h(paramq, "scene");
      if ((paramq instanceof ca))
      {
        Object localObject1;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject1 = ((ca)paramq).rr.aYK();
          if (localObject1 == null)
          {
            paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
            AppMethodBeat.o(244753);
            throw paramString;
          }
          if (((bah)localObject1).tUC != 0) {}
        }
        for (boolean bool1 = false;; bool1 = true)
        {
          localObject1 = new FinderPoiFeedLoader.b(paramInt1, paramInt2, paramString);
          localObject2 = (Iterable)((ca)paramq).cYD();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (FinderObject)((Iterator)localObject2).next();
            Object localObject4 = FinderItem.Companion;
            localObject3 = FinderItem.a.a((FinderObject)localObject3, 33040);
            localObject4 = c.vGN;
            paramString.add(c.a.s((FinderItem)localObject3));
          }
        }
        ((FinderPoiFeedLoader.b)localObject1).setIncrementList((List)paramString);
        paramString = c.vGN;
        c.a.a(((ca)paramq).cYD(), 33040, this.tWE.getContextObj());
        if (((ca)paramq).pullType != 2)
        {
          paramString = c.vGN;
          paramString = ((FinderPoiFeedLoader.b)localObject1).getIncrementList();
          if (paramString == null)
          {
            paramString = new t("null cannot be cast to non-null type kotlin.collections.List<com.tencent.mm.plugin.finder.model.BaseFinderFeed>");
            AppMethodBeat.o(244753);
            throw paramString;
          }
          c.a.b(paramString, 33040, true);
        }
        Object localObject2 = new StringBuilder("incrementList size: ");
        paramString = ((FinderPoiFeedLoader.b)localObject1).getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          Log.i("Finder.FinderPoiFeedLoader", paramString);
          ((FinderPoiFeedLoader.b)localObject1).setPullType(((ca)paramq).pullType);
          paramString = ((ca)paramq).rr.aYK();
          if (paramString != null) {
            break;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
          AppMethodBeat.o(244753);
          throw paramString;
        }
        ((FinderPoiFeedLoader.b)localObject1).setLastBuffer(((bah)paramString).LDs);
        ((FinderPoiFeedLoader.b)localObject1).setHasMore(bool1);
        paramString = ((ca)paramq).rr.aYK();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
          AppMethodBeat.o(244753);
          throw paramString;
        }
        ((FinderPoiFeedLoader.b)localObject1).tWB = ((bah)paramString).LJX;
        if (((FinderPoiFeedLoader.b)localObject1).tWB != null)
        {
          paramString = ((FinderPoiFeedLoader.b)localObject1).getIncrementList();
          if (paramString == null) {
            break label511;
          }
          paramInt1 = paramString.size();
          if (paramInt1 <= 0) {
            break label516;
          }
        }
        label516:
        for (bool1 = bool2;; bool1 = false)
        {
          ((FinderPoiFeedLoader.b)localObject1).tWC = bool1;
          paramString = ((ca)paramq).rr.aYK();
          if (paramString != null) {
            break label522;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
          AppMethodBeat.o(244753);
          throw paramString;
          label511:
          paramInt1 = 0;
          break;
        }
        label522:
        paramq = ((bah)paramString).KYV;
        paramString = paramq;
        if (paramq == null) {
          paramString = "";
        }
        p.h(paramString, "<set-?>");
        ((FinderPoiFeedLoader.b)localObject1).tWD = paramString;
        paramString = (IResponse)localObject1;
        AppMethodBeat.o(244753);
        return paramString;
      }
      AppMethodBeat.o(244753);
      return null;
    }
    
    public final com.tencent.mm.ak.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(244752);
      Object localObject = this.tWE.tWy;
      y.a locala = this.tWE.tWz;
      if ((localObject != null) && (locala != null))
      {
        localObject = new ca((eaa)localObject, locala, this.tWE.getLastBuffer(), (byte)0);
        ((ca)localObject).pullType = 2;
      }
      for (;;)
      {
        localObject = (com.tencent.mm.ak.q)localObject;
        AppMethodBeat.o(244752);
        return localObject;
        localObject = null;
      }
    }
    
    public final com.tencent.mm.ak.q genRefreshNetScene()
    {
      AppMethodBeat.i(244751);
      Object localObject = this.tWE.tWy;
      y.a locala = this.tWE.tWz;
      if ((localObject != null) && (locala != null))
      {
        localObject = new ca((eaa)localObject, locala, this.tWE.getLastBuffer(), (byte)0);
        ((ca)localObject).pullType = 0;
      }
      for (;;)
      {
        localObject = (com.tencent.mm.ak.q)localObject;
        AppMethodBeat.o(244751);
        return localObject;
        localObject = null;
      }
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(244750);
      List localList = j.listOf(Integer.valueOf(5225));
      AppMethodBeat.o(244750);
      return localList;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<bo>.a
  {
    d()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bo> paramIResponse, final kotlin.g.a.b<? super IResponse<bo>, x> paramb)
    {
      int i = 0;
      AppMethodBeat.i(244755);
      p.h(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      Object localObject;
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        localc.Rmi = ((CharSequence)((Context)localObject).getResources().getString(2131760628));
        localc.Rmh = 1;
        if (paramIResponse.getPullType() == 0) {
          break label271;
        }
        bool = true;
        label86:
        localc.jLE = bool;
        localc.Rmj = paramIResponse.getHasMore();
        if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.Rmk > 0)) {
          localc.Rmi = null;
        }
        Log.i("Finder.FinderPoiFeedLoader", "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        localObject = paramIResponse.getIncrementList();
        if (localObject != null) {
          i = ((List)localObject).size();
        }
        if (!paramIResponse.getHasMore()) {
          break label277;
        }
        if (i > this.tWE.getDataList().size()) {
          break label352;
        }
        i = 2;
      }
      for (;;)
      {
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, new n(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(244755);
        return;
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        localc.Rmi = ((CharSequence)((Context)localObject).getResources().getString(2131760645));
        localc.Rmh = -1;
        break;
        label271:
        bool = false;
        break label86;
        label277:
        if ((this.tWE.getDataList().size() == 0) || (i == 0) || (this.tWE.getDataList().size() <= i))
        {
          localObject = paramIResponse.getIncrementList();
          if ((localObject != null) && (((List)localObject).containsAll((Collection)j.p((Iterable)this.tWE.getDataList())) == true))
          {
            i = 6;
            continue;
          }
        }
        label352:
        i = 4;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderPoiFeedLoader.d paramd, n paramn, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderPoiFeedLoader
 * JD-Core Version:    0.7.0.1
 */