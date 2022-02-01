package com.tencent.mm.plugin.finder.gallery;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cs;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.protocal.protobuf.atl;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "cgiParams", "Lcom/tencent/mm/protocal/protobuf/FinderGalleryCgiParams;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderGalleryCgiParams;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getCgiParams", "()Lcom/tencent/mm/protocal/protobuf/FinderGalleryCgiParams;", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "refObjectId", "", "getRefObjectId", "()J", "setRefObjectId", "(J)V", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "isObservePostEvent", "onFetchDone", "response", "FavDataFetcher", "FinderGalleryResponse", "plugin-finder_release"})
public class FinderGalleryLoader
  extends BaseFinderFeedLoader
{
  kotlin.g.a.b<? super IResponse<bu>, x> fetchEndCallback;
  private boolean hasMore;
  final atl xTV;
  
  public FinderGalleryLoader(atl paramatl, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(291261);
    this.xTV = paramatl;
    AppMethodBeat.o(291261);
  }
  
  public i<bu> createDataFetch()
  {
    AppMethodBeat.i(291258);
    i locali = (i)new a();
    AppMethodBeat.o(291258);
    return locali;
  }
  
  public com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(291259);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new c(this);
    AppMethodBeat.o(291259);
    return locald;
  }
  
  public int getPageName()
  {
    return 10;
  }
  
  public boolean isObservePostEvent()
  {
    return this.xTV.tab_type == 5;
  }
  
  public void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(291260);
    p.k(paramIResponse, "response");
    Object localObject1 = this.xTV.SGo;
    if ((isRefreshOperation(paramIResponse)) && (localObject1 != null))
    {
      Object localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
      localObject2 = FinderItem.Companion;
      BaseFinderFeed localBaseFinderFeed = c.a.a(FinderItem.a.b((FinderObject)localObject1, 256));
      localBaseFinderFeed.currentUsed = true;
      localObject2 = paramIResponse.getIncrementList();
      localObject1 = localObject2;
      if (!(localObject2 instanceof ArrayList)) {
        localObject1 = null;
      }
      localObject1 = (ArrayList)localObject1;
      if (localObject1 != null) {
        ((ArrayList)localObject1).add(0, localBaseFinderFeed);
      }
    }
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(291260);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    localObject1 = this.fetchEndCallback;
    if (localObject1 != null)
    {
      ((kotlin.g.a.b)localObject1).invoke(paramIResponse);
      AppMethodBeat.o(291260);
      return;
    }
    AppMethodBeat.o(291260);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryLoader$FavDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public final IResponse<bu> callInit()
    {
      AppMethodBeat.i(253309);
      Log.i(getTAG(), "fetchInit ");
      Object localObject = new FinderGalleryLoader.b(0, 0, "");
      ((FinderGalleryLoader.b)localObject).setIncrementList((List)v.aaAd);
      localObject = (IResponse)localObject;
      AppMethodBeat.o(253309);
      return localObject;
    }
    
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(253307);
      p.k(paramq, "scene");
      if ((paramq instanceof cs))
      {
        if (this.xTW.xTV.tab_type == 5)
        {
          localObject1 = aj.AGc;
          if (aj.edY()) {}
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            paramInt2 = 0;
            paramInt1 = 0;
          }
          localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.dRP().aSr()).intValue() != 2)
          {
            localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.dRP().aSr()).intValue() != 3) {}
          }
          else
          {
            paramInt1 = -4;
            paramInt2 = -1;
          }
          if (i == 0)
          {
            localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.dRP().aSr()).intValue() == 0) {
              break label269;
            }
          }
          localObject1 = ((cs)paramq).rr.bhY();
          if (localObject1 != null) {
            break;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCatelogStreamResponse");
          AppMethodBeat.o(253307);
          throw paramString;
        }
        ((aqm)localObject1).SDI = null;
        Object localObject1 = ((cs)paramq).rr.bhY();
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCatelogStreamResponse");
          AppMethodBeat.o(253307);
          throw paramString;
        }
        ((aqm)localObject1).object.clear();
        localObject1 = ((cs)paramq).rr.bhY();
        if (localObject1 == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCatelogStreamResponse");
          AppMethodBeat.o(253307);
          throw paramString;
        }
        ((aqm)localObject1).xFI = 0;
        label269:
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject1 = ((cs)paramq).rr.bhY();
          if (localObject1 == null)
          {
            paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCatelogStreamResponse");
            AppMethodBeat.o(253307);
            throw paramString;
          }
          if (((aqm)localObject1).xFI != 0) {}
        }
        for (boolean bool = false;; bool = true)
        {
          localObject1 = new FinderGalleryLoader.b(paramInt1, paramInt2, paramString);
          localObject2 = (Iterable)((cs)paramq).dow();
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
        ((FinderGalleryLoader.b)localObject1).setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        c.a.a((List)((cs)paramq).dow(), 256, this.xTW.getContextObj());
        Object localObject2 = getTAG();
        Object localObject3 = new StringBuilder("incrementList size: ");
        paramString = ((FinderGalleryLoader.b)localObject1).getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          Log.i((String)localObject2, paramString);
          ((FinderGalleryLoader.b)localObject1).setPullType(((cs)paramq).pullType);
          paramString = ((cs)paramq).rr.bhY();
          if (paramString != null) {
            break;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCatelogStreamResponse");
          AppMethodBeat.o(253307);
          throw paramString;
        }
        ((FinderGalleryLoader.b)localObject1).setLastBuffer(((aqm)paramString).SDI);
        ((FinderGalleryLoader.b)localObject1).setHasMore(bool);
        paramString = (IResponse)localObject1;
        AppMethodBeat.o(253307);
        return paramString;
      }
      AppMethodBeat.o(253307);
      return null;
    }
    
    public final com.tencent.mm.an.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(253304);
      com.tencent.mm.an.q localq = (com.tencent.mm.an.q)new cs(2, this.xTW.xTV.tab_type, this.xTW.xTV.scene, this.xTW.xTV.SDH, this.xTW.getLastBuffer());
      AppMethodBeat.o(253304);
      return localq;
    }
    
    public final com.tencent.mm.an.q genRefreshNetScene()
    {
      AppMethodBeat.i(253301);
      com.tencent.mm.an.q localq = (com.tencent.mm.an.q)new cs(0, this.xTW.xTV.tab_type, this.xTW.xTV.scene, this.xTW.xTV.SDH, null);
      AppMethodBeat.o(253301);
      return localq;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(253300);
      List localList = j.listOf(Integer.valueOf(4239));
      AppMethodBeat.o(253300);
      return localList;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryLoader$FinderGalleryResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<bu>
  {
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/gallery/FinderGalleryLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class c
    extends BaseFeedLoader<bu>.a
  {
    c()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bu> paramIResponse, final kotlin.g.a.b<? super IResponse<bu>, x> paramb)
    {
      int i = 0;
      AppMethodBeat.i(289716);
      p.k(paramIResponse, "response");
      final RefreshLoadMoreLayout.c localc = new RefreshLoadMoreLayout.c(paramIResponse.getPullType());
      Object localObject;
      boolean bool;
      if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
      {
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        localc.YNE = ((CharSequence)((Context)localObject).getResources().getString(b.j.finder_timeline_refresh_nothing_tip));
        localc.YND = 1;
        if (paramIResponse.getPullType() == 0) {
          break label278;
        }
        bool = true;
        label87:
        localc.mCI = bool;
        localc.YNF = paramIResponse.getHasMore();
        if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.YNG > 0)) {
          localc.YNE = null;
        }
        Log.i(this.xTW.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        localObject = paramIResponse.getIncrementList();
        if (localObject != null) {
          i = ((List)localObject).size();
        }
        if (!paramIResponse.getHasMore()) {
          break label284;
        }
        if (i > this.xTW.getDataList().size()) {
          break label387;
        }
        i = 2;
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.q(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(289716);
        return;
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        localc.YNE = ((CharSequence)((Context)localObject).getResources().getString(b.j.finder_touch_to_retry));
        localc.YND = -1;
        break;
        label278:
        bool = false;
        break label87;
        label284:
        if ((this.xTW.getDataList().size() == 0) || (i == 0) || (this.xTW.getDataList().size() <= i))
        {
          localObject = paramIResponse.getIncrementList();
          if ((localObject != null) && (((List)localObject).isEmpty() == true))
          {
            i = 7;
            continue;
          }
          localObject = paramIResponse.getIncrementList();
          if ((localObject != null) && (((List)localObject).containsAll((Collection)j.p((Iterable)this.xTW.getDataList())) == true))
          {
            i = 6;
            continue;
          }
        }
        label387:
        i = 4;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements a<x>
    {
      a(FinderGalleryLoader.c paramc, com.tencent.mm.plugin.finder.feed.model.internal.q paramq, RefreshLoadMoreLayout.c paramc1, kotlin.g.a.b paramb, IResponse paramIResponse)
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