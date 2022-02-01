package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ce;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.findersdk.a.y.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bgs;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.protocal.protobuf.ekk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$PoiDataFetcher;", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "fromScene", "", "getFromScene", "()Ljava/lang/Integer;", "setFromScene", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "fromType", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "getFromType", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;", "setFromType", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiFromType;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "location", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "setLocation", "(Lcom/tencent/mm/protocal/protobuf/SnsLocation;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "onFetchDone", "response", "Companion", "FinderPoiStreamListResponse", "PoiDataFetcher", "plugin-finder_release"})
public final class FinderPoiFeedLoader
  extends BaseFinderFeedLoader
{
  public static final a xIu;
  public b<? super IResponse<bu>, x> fetchEndCallback;
  private boolean hasMore;
  private c xIq;
  public eka xIr;
  public y.a xIs;
  public Integer xIt;
  
  static
  {
    AppMethodBeat.i(236175);
    xIu = new a((byte)0);
    AppMethodBeat.o(236175);
  }
  
  private FinderPoiFeedLoader(byte paramByte)
  {
    this();
  }
  
  public FinderPoiFeedLoader(bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(236172);
    this.xIq = new c();
    AppMethodBeat.o(236172);
  }
  
  public final i<bu> createDataFetch()
  {
    return (i)this.xIq;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(236167);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new d(this);
    AppMethodBeat.o(236167);
    return locald;
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(236170);
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(236170);
      return;
    }
    this.hasMore = paramIResponse.getHasMore();
    b localb = this.fetchEndCallback;
    if (localb != null)
    {
      localb.invoke(paramIResponse);
      AppMethodBeat.o(236170);
      return;
    }
    AppMethodBeat.o(236170);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$FinderPoiStreamListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "hasFeedData", "", "getHasFeedData", "()Z", "setHasFeedData", "(Z)V", "noticeWording", "getNoticeWording", "()Ljava/lang/String;", "setNoticeWording", "(Ljava/lang/String;)V", "onlyShowPoiName", "getOnlyShowPoiName", "setOnlyShowPoiName", "poiDetail", "Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;", "getPoiDetail", "()Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;", "setPoiDetail", "(Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;)V", "videoCount", "getVideoCount", "()I", "setVideoCount", "(I)V", "plugin-finder_release"})
  public static final class b
    extends IResponse<bu>
  {
    public ekk xIv;
    public boolean xIw;
    public String xIx = "";
    public boolean xIy;
    public int xzT;
    
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$PoiDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      boolean bool2 = true;
      AppMethodBeat.i(267612);
      p.k(paramq, "scene");
      if ((paramq instanceof ce))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((ce)paramq).doo() == 0)) {}
        FinderPoiFeedLoader.b localb;
        for (boolean bool1 = false;; bool1 = true)
        {
          localb = new FinderPoiFeedLoader.b(paramInt1, paramInt2, paramString);
          localObject1 = (Iterable)((ce)paramq).dor();
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (FinderObject)((Iterator)localObject1).next();
            Object localObject3 = FinderItem.Companion;
            localObject2 = FinderItem.a.b((FinderObject)localObject2, 33040);
            localObject3 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
            paramString.add(c.a.a((FinderItem)localObject2));
          }
        }
        localb.setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        c.a.a(((ce)paramq).dor(), 33040, this.xIz.getContextObj());
        if (((ce)paramq).pullType != 2)
        {
          paramString = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          paramString = localb.getIncrementList();
          if (paramString == null)
          {
            paramString = new t("null cannot be cast to non-null type kotlin.collections.List<com.tencent.mm.plugin.finder.model.BaseFinderFeed>");
            AppMethodBeat.o(267612);
            throw paramString;
          }
          c.a.b(paramString, 33040, true);
        }
        Object localObject1 = new StringBuilder("incrementList size: ");
        paramString = localb.getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          Log.i("Finder.FinderPoiFeedLoader", paramString);
          localb.setPullType(((ce)paramq).pullType);
          localb.setLastBuffer(((ce)paramq).don());
          localb.setHasMore(bool1);
          paramString = ((ce)paramq).rr.bhY();
          if (paramString != null) {
            break;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
          AppMethodBeat.o(267612);
          throw paramString;
        }
        localb.xIv = ((bgs)paramString).SRq;
        if (localb.xIv != null)
        {
          paramString = localb.getIncrementList();
          if (paramString == null) {
            break label443;
          }
          paramInt1 = paramString.size();
          if (paramInt1 <= 0) {
            break label448;
          }
        }
        label443:
        label448:
        for (bool1 = true;; bool1 = false)
        {
          localb.xIw = bool1;
          paramString = ((ce)paramq).rr.bhY();
          if (paramString != null) {
            break label454;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
          AppMethodBeat.o(267612);
          throw paramString;
          paramInt1 = 0;
          break;
        }
        label454:
        localObject1 = ((bgs)paramString).Sae;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        p.k(paramString, "<set-?>");
        localb.xIx = paramString;
        paramString = ((ce)paramq).rr.bhY();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
          AppMethodBeat.o(267612);
          throw paramString;
        }
        if (((bgs)paramString).SRr == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          localb.xIy = bool1;
          paramString = ((ce)paramq).rr.bhY();
          if (paramString != null) {
            break;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPoiStreamResponse");
          AppMethodBeat.o(267612);
          throw paramString;
        }
        localb.xzT = ((bgs)paramString).SRs;
        paramString = (IResponse)localb;
        AppMethodBeat.o(267612);
        return paramString;
      }
      AppMethodBeat.o(267612);
      return null;
    }
    
    public final com.tencent.mm.an.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(267611);
      Object localObject = this.xIz.xIr;
      y.a locala = this.xIz.xIs;
      if ((localObject != null) && (locala != null))
      {
        localObject = new ce((eka)localObject, locala, this.xIz.getLastBuffer(), this.xIz.xIt, (byte)0);
        ((ce)localObject).pullType = 2;
      }
      for (;;)
      {
        localObject = (com.tencent.mm.an.q)localObject;
        AppMethodBeat.o(267611);
        return localObject;
        localObject = null;
      }
    }
    
    public final com.tencent.mm.an.q genRefreshNetScene()
    {
      AppMethodBeat.i(267610);
      Object localObject = this.xIz.xIr;
      y.a locala = this.xIz.xIs;
      if ((localObject != null) && (locala != null))
      {
        localObject = new ce((eka)localObject, locala, this.xIz.getLastBuffer(), this.xIz.xIt, (byte)0);
        ((ce)localObject).pullType = 0;
      }
      for (;;)
      {
        localObject = (com.tencent.mm.an.q)localObject;
        AppMethodBeat.o(267610);
        return localObject;
        localObject = null;
      }
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(267608);
      List localList = j.listOf(Integer.valueOf(5225));
      AppMethodBeat.o(267608);
      return localList;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class d
    extends BaseFeedLoader<bu>.a
  {
    d()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bu> paramIResponse, final b<? super IResponse<bu>, x> paramb)
    {
      int i = 0;
      AppMethodBeat.i(289727);
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
          break label273;
        }
        bool = true;
        label87:
        localc.mCI = bool;
        localc.YNF = paramIResponse.getHasMore();
        if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.YNG > 0)) {
          localc.YNE = null;
        }
        Log.i("Finder.FinderPoiFeedLoader", "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        localObject = paramIResponse.getIncrementList();
        if (localObject != null) {
          i = ((List)localObject).size();
        }
        if (!paramIResponse.getHasMore()) {
          break label279;
        }
        if (i > this.xIz.getDataList().size()) {
          break label354;
        }
        i = 2;
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.q(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(289727);
        return;
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        localc.YNE = ((CharSequence)((Context)localObject).getResources().getString(b.j.finder_touch_to_retry));
        localc.YND = -1;
        break;
        label273:
        bool = false;
        break label87;
        label279:
        if ((this.xIz.getDataList().size() == 0) || (i == 0) || (this.xIz.getDataList().size() <= i))
        {
          localObject = paramIResponse.getIncrementList();
          if ((localObject != null) && (((List)localObject).containsAll((Collection)j.p((Iterable)this.xIz.getDataList())) == true))
          {
            i = 6;
            continue;
          }
        }
        label354:
        i = 4;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements a<x>
    {
      a(FinderPoiFeedLoader.d paramd, com.tencent.mm.plugin.finder.feed.model.internal.q paramq, RefreshLoadMoreLayout.c paramc, b paramb, IResponse paramIResponse)
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