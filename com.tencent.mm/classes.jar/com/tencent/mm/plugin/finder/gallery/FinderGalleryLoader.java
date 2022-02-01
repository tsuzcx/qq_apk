package com.tencent.mm.plugin.finder.gallery;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.plugin.finder.cgi.du;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.model.internal.r;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aum;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "cgiParams", "Lcom/tencent/mm/protocal/protobuf/FinderGalleryCgiParams;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isTimeline", "", "(Lcom/tencent/mm/protocal/protobuf/FinderGalleryCgiParams;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getCgiParams", "()Lcom/tencent/mm/protocal/protobuf/FinderGalleryCgiParams;", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "isObservePostEvent", "onFetchDone", "response", "FavDataFetcher", "FinderGalleryResponse", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderGalleryLoader
  extends BaseFinderFeedLoader
{
  final boolean AxW;
  final axz BuO;
  public kotlin.g.a.b<? super IResponse<cc>, ah> fetchEndCallback;
  private boolean hasMore;
  
  public FinderGalleryLoader(axz paramaxz, bui parambui, boolean paramBoolean)
  {
    super(parambui);
    AppMethodBeat.i(334349);
    this.BuO = paramaxz;
    this.AxW = paramBoolean;
    AppMethodBeat.o(334349);
  }
  
  public i<cc> createDataFetch()
  {
    AppMethodBeat.i(334359);
    i locali = (i)new a();
    AppMethodBeat.o(334359);
    return locali;
  }
  
  public com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(334376);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new c(this);
    AppMethodBeat.o(334376);
    return locald;
  }
  
  public int getPageName()
  {
    return 10;
  }
  
  public boolean isObservePostEvent()
  {
    return this.BuO.tab_type == 5;
  }
  
  public void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(334391);
    kotlin.g.b.s.u(paramIResponse, "response");
    Object localObject1 = this.BuO.ZIY;
    Object localObject2;
    if ((isRefreshOperation(paramIResponse)) && (localObject1 != null))
    {
      localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      localObject2 = FinderItem.Companion;
      localObject2 = d.a.a(FinderItem.a.e((FinderObject)localObject1, 256));
      ((BaseFinderFeed)localObject2).currentUsed = true;
      localObject1 = paramIResponse.getIncrementList();
      if (!(localObject1 instanceof ArrayList)) {
        break label101;
      }
    }
    label101:
    for (localObject1 = (ArrayList)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        ((ArrayList)localObject1).add(0, localObject2);
      }
      super.onFetchDone(paramIResponse);
      if (!isInitOperation(paramIResponse)) {
        break;
      }
      AppMethodBeat.o(334391);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    localObject1 = this.fetchEndCallback;
    if (localObject1 != null) {
      ((kotlin.g.a.b)localObject1).invoke(paramIResponse);
    }
    AppMethodBeat.o(334391);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryLoader$FavDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public a()
    {
      AppMethodBeat.i(334166);
      AppMethodBeat.o(334166);
    }
    
    public final IResponse<cc> callInit()
    {
      Object localObject2 = null;
      AppMethodBeat.i(334211);
      Log.i(getTAG(), "fetchInit ");
      FinderGalleryLoader.b localb = new FinderGalleryLoader.b(0, 0, "");
      Object localObject1;
      if (this.BuP.AxW)
      {
        localObject1 = this.BuP.getCache();
        if (localObject1 == null)
        {
          localObject1 = null;
          localb.setIncrementList((List)localObject1);
          localObject1 = this.BuP.getCache();
          if (localObject1 != null) {
            break label99;
          }
          localObject1 = localObject2;
          label74:
          localb.setLastBuffer((com.tencent.mm.bx.b)localObject1);
        }
      }
      for (;;)
      {
        localObject1 = (IResponse)localb;
        AppMethodBeat.o(334211);
        return localObject1;
        localObject1 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject1).pUj;
        break;
        label99:
        localObject1 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject1).lastBuffer;
        break label74;
        localb.setIncrementList((List)ab.aivy);
      }
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(334203);
      kotlin.g.b.s.u(paramp, "scene");
      if ((paramp instanceof du))
      {
        if (this.BuP.BuO.tab_type == 5)
        {
          localObject1 = av.GiL;
          if (av.ffR()) {}
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            paramInt2 = 0;
            paramInt1 = 0;
          }
          localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eQb().bmg()).intValue() != 2)
          {
            localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.eQb().bmg()).intValue() != 3) {}
          }
          else
          {
            paramInt1 = -4;
            paramInt2 = -1;
          }
          if (i == 0)
          {
            localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.eQb().bmg()).intValue() == 0) {
              break label278;
            }
          }
          localObject1 = c.c.b(((du)paramp).rr.otC);
          if (localObject1 != null) {
            break;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCatelogStreamResponse");
          AppMethodBeat.o(334203);
          throw paramString;
        }
        ((aum)localObject1).ZEQ = null;
        Object localObject1 = c.c.b(((du)paramp).rr.otC);
        if (localObject1 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCatelogStreamResponse");
          AppMethodBeat.o(334203);
          throw paramString;
        }
        ((aum)localObject1).object.clear();
        localObject1 = c.c.b(((du)paramp).rr.otC);
        if (localObject1 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCatelogStreamResponse");
          AppMethodBeat.o(334203);
          throw paramString;
        }
        ((aum)localObject1).BeA = 0;
        label278:
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject1 = c.c.b(((du)paramp).rr.otC);
          if (localObject1 == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCatelogStreamResponse");
            AppMethodBeat.o(334203);
            throw paramString;
          }
          if (((aum)localObject1).BeA != 0) {}
        }
        for (boolean bool = false;; bool = true)
        {
          localObject1 = new FinderGalleryLoader.b(paramInt1, paramInt2, paramString);
          localObject2 = (Iterable)((du)paramp).dVW();
          paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (FinderObject)((Iterator)localObject2).next();
            Object localObject4 = FinderItem.Companion;
            localObject3 = FinderItem.a.e((FinderObject)localObject3, 256);
            localObject4 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
            paramString.add(d.a.a((FinderItem)localObject3));
          }
        }
        ((FinderGalleryLoader.b)localObject1).setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        d.a.a((List)((du)paramp).dVW(), 256, this.BuP.getContextObj());
        Object localObject2 = getTAG();
        paramString = ((FinderGalleryLoader.b)localObject1).getIncrementList();
        if (paramString == null) {}
        for (paramString = null;; paramString = Integer.valueOf(paramString.size()))
        {
          Log.i((String)localObject2, kotlin.g.b.s.X("incrementList size: ", paramString));
          ((FinderGalleryLoader.b)localObject1).setPullType(((du)paramp).pullType);
          paramString = c.c.b(((du)paramp).rr.otC);
          if (paramString != null) {
            break;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCatelogStreamResponse");
          AppMethodBeat.o(334203);
          throw paramString;
        }
        ((FinderGalleryLoader.b)localObject1).setLastBuffer(((aum)paramString).ZEQ);
        ((FinderGalleryLoader.b)localObject1).setHasMore(bool);
        paramString = (IResponse)localObject1;
        AppMethodBeat.o(334203);
        return paramString;
      }
      AppMethodBeat.o(334203);
      return null;
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(334188);
      com.tencent.mm.am.p localp = (com.tencent.mm.am.p)new du(2, this.BuP.BuO.tab_type, this.BuP.BuO.scene, this.BuP.BuO.ZEP, this.BuP.getLastBuffer());
      AppMethodBeat.o(334188);
      return localp;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(334179);
      com.tencent.mm.am.p localp = (com.tencent.mm.am.p)new du(0, this.BuP.BuO.tab_type, this.BuP.BuO.scene, this.BuP.BuO.ZEP, null);
      AppMethodBeat.o(334179);
      return localp;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(334173);
      List localList = kotlin.a.p.listOf(Integer.valueOf(4239));
      AppMethodBeat.o(334173);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryLoader$FinderGalleryResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends IResponse<cc>
  {
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/gallery/FinderGalleryLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends BaseFeedLoader<cc>.a
  {
    c(FinderGalleryLoader paramFinderGalleryLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(334164);
      AppMethodBeat.o(334164);
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      int j = 1;
      AppMethodBeat.i(334181);
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
        Log.i(this.BuP.getTAG(), kotlin.g.b.s.X("[onFetchRefreshDone]  reason=", locald));
        localList = paramIResponse.getIncrementList();
        if (localList != null) {
          break label258;
        }
        i = 0;
        label154:
        if (!paramIResponse.getHasMore()) {
          break label269;
        }
        if (i > this.BuP.getDataList().size()) {
          break label395;
        }
        i = 2;
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((a)new a(this, new r(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), locald, this.BuP, paramb, paramIResponse));
        AppMethodBeat.o(334181);
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
        if ((this.BuP.getDataList().size() == 0) || (i == 0) || (this.BuP.getDataList().size() <= i))
        {
          localList = paramIResponse.getIncrementList();
          if ((localList != null) && (localList.isEmpty() == true)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label339;
            }
            i = 7;
            break;
          }
          label339:
          localList = paramIResponse.getIncrementList();
          if ((localList != null) && (localList.containsAll((Collection)kotlin.a.p.p((Iterable)this.BuP.getDataList())) == true)) {}
          for (i = j;; i = 0)
          {
            if (i == 0) {
              break label395;
            }
            i = 6;
            break;
          }
        }
        label395:
        i = 4;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(FinderGalleryLoader.c paramc, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd, FinderGalleryLoader paramFinderGalleryLoader, kotlin.g.a.b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.FinderGalleryLoader
 * JD-Core Version:    0.7.0.1
 */