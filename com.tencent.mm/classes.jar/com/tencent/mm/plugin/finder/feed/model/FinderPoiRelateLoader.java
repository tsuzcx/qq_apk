package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.plugin.finder.cgi.de;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.model.internal.r;
import com.tencent.mm.plugin.finder.model.br;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.protocal.protobuf.epd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiRelateLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "targetUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getTargetUsername", "()Ljava/lang/String;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "FinderPoiRelateListResponse", "PoiRelateDataFetcher", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderPoiRelateLoader
  extends BaseFinderFeedLoader
{
  final String ACm;
  public kotlin.g.a.b<? super IResponse<cc>, ah> fetchEndCallback;
  private boolean hasMore;
  
  public FinderPoiRelateLoader(String paramString, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(365998);
    this.ACm = paramString;
    AppMethodBeat.o(365998);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(366005);
    i locali = (i)new b();
    AppMethodBeat.o(366005);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(366010);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new c(this);
    AppMethodBeat.o(366010);
    return locald;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366018);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(366018);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    if (!paramIResponse.getHasMore())
    {
      kotlin.g.a.b localb = this.fetchEndCallback;
      if (localb != null) {
        localb.invoke(paramIResponse);
      }
    }
    AppMethodBeat.o(366018);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiRelateLoader$FinderPoiRelateListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends IResponse<cc>
  {
    public a(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiRelateLoader$PoiRelateDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiRelateLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public b()
    {
      AppMethodBeat.i(366069);
      AppMethodBeat.o(366069);
    }
    
    public final IResponse<cc> callInit()
    {
      Object localObject2 = null;
      AppMethodBeat.i(366099);
      FinderPoiRelateLoader.a locala = new FinderPoiRelateLoader.a(0, 0, "");
      FinderPoiRelateLoader localFinderPoiRelateLoader = this.BhT;
      Object localObject1 = localFinderPoiRelateLoader.getCache();
      if (localObject1 == null)
      {
        localObject1 = null;
        locala.setIncrementList((List)localObject1);
        localObject1 = localFinderPoiRelateLoader.getCache();
        if (localObject1 != null) {
          break label82;
        }
      }
      label82:
      for (localObject1 = localObject2;; localObject1 = ((s)localObject1).lastBuffer)
      {
        locala.setLastBuffer((com.tencent.mm.bx.b)localObject1);
        localObject1 = (IResponse)locala;
        AppMethodBeat.o(366099);
        return localObject1;
        localObject1 = ((s)localObject1).pUj;
        break;
      }
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      Object localObject1 = null;
      AppMethodBeat.i(366096);
      kotlin.g.b.s.u(paramp, "scene");
      if ((paramp instanceof de))
      {
        Object localObject2;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject2 = c.c.b(((de)paramp).rr.otC);
          if (localObject2 == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetFinderRelativePoiListResponse");
            AppMethodBeat.o(366096);
            throw paramString;
          }
          if (((ckf)localObject2).BeA != 0) {}
        }
        for (boolean bool = false;; bool = true)
        {
          localObject2 = new FinderPoiRelateLoader.a(paramInt1, paramInt2, paramString);
          ((FinderPoiRelateLoader.a)localObject2).setHasMore(bool);
          paramString = c.c.b(((de)paramp).rr.otC);
          if (paramString != null) {
            break;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetFinderRelativePoiListResponse");
          AppMethodBeat.o(366096);
          throw paramString;
        }
        paramString = ((ckf)paramString).ZEK;
        if (paramString == null) {}
        for (paramString = (String)localObject1;; paramString = (List)paramString)
        {
          ((FinderPoiRelateLoader.a)localObject2).setIncrementList(paramString);
          paramString = c.c.b(((de)paramp).rr.otC);
          if (paramString != null) {
            break;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetFinderRelativePoiListResponse");
          AppMethodBeat.o(366096);
          throw paramString;
          localObject1 = (Iterable)paramString;
          paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            paramString.add(new br((epd)((Iterator)localObject1).next()));
          }
        }
        ((FinderPoiRelateLoader.a)localObject2).setLastBuffer(((ckf)paramString).ZEQ);
        ((FinderPoiRelateLoader.a)localObject2).setPullType(((de)paramp).pullType);
        paramString = (IResponse)localObject2;
        AppMethodBeat.o(366096);
        return paramString;
      }
      AppMethodBeat.o(366096);
      return null;
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(366086);
      Object localObject = new de(this.BhT.ACm, this.BhT.getLastBuffer(), this.BhT.getContextObj());
      ((de)localObject).pullType = 2;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(366086);
      return localObject;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(366079);
      Object localObject = new de(this.BhT.ACm, this.BhT.getLastBuffer(), this.BhT.getContextObj());
      ((de)localObject).pullType = 0;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(366079);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(366074);
      List localList = kotlin.a.p.listOf(Integer.valueOf(6208));
      AppMethodBeat.o(366074);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/FinderPoiRelateLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends BaseFeedLoader<cc>.a
  {
    c(FinderPoiRelateLoader paramFinderPoiRelateLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(366070);
      AppMethodBeat.o(366070);
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      int j = 1;
      AppMethodBeat.i(366081);
      kotlin.g.b.s.u(paramIResponse, "response");
      final RefreshLoadMoreLayout.d locald = new RefreshLoadMoreLayout.d(paramIResponse.getPullType());
      boolean bool;
      label77:
      List localList;
      int i;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        locald.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_timeline_refresh_nothing_tip));
        locald.agJs = 1;
        if (paramIResponse.getPullType() == 0) {
          break label252;
        }
        bool = true;
        locald.pzq = bool;
        locald.agJu = paramIResponse.getHasMore();
        if (((locald.actionType == 0) || (locald.actionType == 4)) && (locald.agJv > 0)) {
          locald.agJt = null;
        }
        Log.i(this.BhT.getTAG(), kotlin.g.b.s.X("[onFetchRefreshDone]  reason=", locald));
        localList = paramIResponse.getIncrementList();
        if (localList != null) {
          break label258;
        }
        i = 0;
        label154:
        if (!paramIResponse.getHasMore()) {
          break label269;
        }
        if (i > this.BhT.getDataList().size()) {
          break label356;
        }
        i = 2;
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((a)new a(this, new r(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), locald, this.BhT, paramb, paramIResponse));
        AppMethodBeat.o(366081);
        return;
        locald.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_touch_to_retry));
        locald.agJs = -1;
        break;
        label252:
        bool = false;
        break label77;
        label258:
        i = localList.size();
        break label154;
        label269:
        if ((this.BhT.getDataList().size() == 0) || (i == 0) || (this.BhT.getDataList().size() <= i))
        {
          localList = paramIResponse.getIncrementList();
          if ((localList != null) && (localList.containsAll((Collection)kotlin.a.p.p((Iterable)this.BhT.getDataList())) == true)) {}
          for (i = j;; i = 0)
          {
            if (i == 0) {
              break label356;
            }
            i = 6;
            break;
          }
        }
        label356:
        i = 4;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(FinderPoiRelateLoader.c paramc, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd, FinderPoiRelateLoader paramFinderPoiRelateLoader, kotlin.g.a.b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderPoiRelateLoader
 * JD-Core Version:    0.7.0.1
 */