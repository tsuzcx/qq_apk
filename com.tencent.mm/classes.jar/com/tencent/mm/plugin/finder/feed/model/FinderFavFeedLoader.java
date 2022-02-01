package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ct;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isTimeline", "", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "activeTopicId", "", "getActiveTopicId", "()J", "setActiveTopicId", "(J)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "onFilterDataChanged", "Lkotlin/Function0;", "getOnFilterDataChanged", "()Lkotlin/jvm/functions/Function0;", "setOnFilterDataChanged", "(Lkotlin/jvm/functions/Function0;)V", "refObjectId", "getRefObjectId", "setRefObjectId", "state", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$State;", "setState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$State;)V", "topics", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTopics", "()Ljava/util/ArrayList;", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "initTopics", "topicList", "", "isCurrentAllData", "isShouldRefreshFooter", "onFetchDone", "response", "remove", "feedId", "notify", "requestLoadMore", "switchTopic", "topicId", "Companion", "FavDataFetcher", "FinderFavListResponse", "State", "plugin-finder_release"})
public final class FinderFavFeedLoader
  extends BaseFinderFeedLoader
{
  public static final a xGw;
  public kotlin.g.a.b<? super IResponse<bu>, x> fetchEndCallback;
  public boolean hasMore;
  public int jlf;
  public a<x> onFilterDataChanged;
  private final String whH;
  d xGs;
  public long xGt;
  public final ArrayList<bkr> xGu;
  final boolean xGv;
  
  static
  {
    AppMethodBeat.i(277004);
    xGw = new a((byte)0);
    AppMethodBeat.o(277004);
  }
  
  public FinderFavFeedLoader(String paramString, bid parambid, boolean paramBoolean)
  {
    super(parambid);
    AppMethodBeat.i(277002);
    this.whH = paramString;
    this.xGv = paramBoolean;
    this.xGs = d.xGz;
    this.xGu = new ArrayList(5);
    AppMethodBeat.o(277002);
  }
  
  public final boolean KX(long paramLong)
  {
    AppMethodBeat.i(276998);
    Log.i(getTAG(), "switchToTopic ".concat(String.valueOf(paramLong)));
    boolean bool;
    if (this.xGt != paramLong)
    {
      if (this.xGs == d.xGB)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).addAll((Collection)getDataList());
        localObject = new q((ArrayList)localObject, getLastBuffer(), 0, null);
        ((q)localObject).hasMore = this.hasMore;
        getStore().a(String.valueOf(this.xGt), (q)localObject);
        Log.i(getTAG(), "save cache of TopicId:" + this.xGt + ", size:" + getDataList().size());
      }
      getDataList().clear();
      this.xGs = d.xGz;
      this.xGt = paramLong;
      Object localObject = getStore().aBJ(String.valueOf(paramLong));
      if (localObject != null)
      {
        this.xGs = d.xGB;
        getDataList().addAll((Collection)((q)localObject).mXB);
        setLastBuffer(((q)localObject).lastBuffer);
        this.hasMore = ((q)localObject).hasMore;
        Log.i(getTAG(), "restore cache, topicId:" + paramLong + ", size:" + ((q)localObject).mXB);
        dispatcher().onChanged();
        if (localObject != null) {}
      }
      else
      {
        setLastBuffer(null);
        this.hasMore = false;
        requestRefresh();
        dispatcher().onChanged();
        bool = true;
        localObject = x.aazN;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(276998);
      return bool;
      bool = false;
    }
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(276996);
    p.k(paramd, "<set-?>");
    this.xGs = paramd;
    AppMethodBeat.o(276996);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(276993);
    i locali = (i)new b();
    AppMethodBeat.o(276993);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(276994);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new e(this);
    AppMethodBeat.o(276994);
    return locald;
  }
  
  public final int getPageName()
  {
    return 10;
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    int j = 0;
    AppMethodBeat.i(276997);
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(276997);
      return;
    }
    if ((paramIResponse.getPullType() == 0) && ((paramIResponse instanceof c)))
    {
      this.jlf = ((c)paramIResponse).jlf;
      if (this.xGt == 0L)
      {
        localObject = ((c)paramIResponse).topicList;
        String str = getTAG();
        StringBuilder localStringBuilder = new StringBuilder("initTopics size:");
        int i;
        if (localObject != null)
        {
          i = ((List)localObject).size();
          Log.i(str, i);
          if (localObject == null) {
            break label204;
          }
          if (((List)localObject).size() <= 5) {
            break label174;
          }
          i = 5;
        }
        for (;;)
        {
          if (j >= i) {
            break label185;
          }
          this.xGu.add(((List)localObject).get(j));
          j += 1;
          continue;
          i = 0;
          break;
          label174:
          i = ((List)localObject).size();
        }
        label185:
        localObject = this.onFilterDataChanged;
        if (localObject != null) {
          ((a)localObject).invoke();
        }
      }
    }
    label204:
    this.hasMore = paramIResponse.getHasMore();
    Object localObject = this.fetchEndCallback;
    if (localObject != null)
    {
      ((kotlin.g.a.b)localObject).invoke(paramIResponse);
      AppMethodBeat.o(276997);
      return;
    }
    AppMethodBeat.o(276997);
  }
  
  public final int remove(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(277001);
    q localq;
    int i;
    int j;
    if (this.xGt != 0L)
    {
      localq = getStore().aBJ("0");
      if (localq != null)
      {
        Iterator localIterator = ((List)localq.mXB).iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break label155;
        }
        if (((bu)localIterator.next()).mf() != paramLong) {
          break label140;
        }
        j = 1;
        label83:
        if (j == 0) {
          break label146;
        }
      }
    }
    for (;;)
    {
      if (i != -1) {
        localq.mXB.remove(i);
      }
      Log.i(getTAG(), "remove from all index:".concat(String.valueOf(i)));
      i = super.remove(paramLong, paramBoolean);
      AppMethodBeat.o(277001);
      return i;
      label140:
      j = 0;
      break label83;
      label146:
      i += 1;
      break;
      label155:
      i = -1;
    }
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(276999);
    Log.i(getTAG(), "requestLoadMore hasMore:" + this.hasMore);
    if (this.xGv)
    {
      super.requestLoadMore();
      AppMethodBeat.o(276999);
      return;
    }
    if (this.hasMore) {
      super.requestLoadMore();
    }
    AppMethodBeat.o(276999);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$Companion;", "", "()V", "TAG", "", "TOPIC_MAX_SIZE", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FavDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public final IResponse<bu> callInit()
    {
      Object localObject2 = null;
      AppMethodBeat.i(254985);
      Log.i(getTAG(), "fetchInit initCount ");
      FinderFavFeedLoader.c localc = new FinderFavFeedLoader.c("");
      Object localObject1;
      if (this.xGx.xGv)
      {
        localObject1 = this.xGx.getCache();
        if (localObject1 != null)
        {
          localObject1 = ((q)localObject1).mXB;
          localc.setIncrementList((List)localObject1);
          q localq = this.xGx.getCache();
          localObject1 = localObject2;
          if (localq != null) {
            localObject1 = localq.lastBuffer;
          }
          localc.setLastBuffer((com.tencent.mm.cd.b)localObject1);
        }
      }
      for (;;)
      {
        localObject1 = (IResponse)localc;
        AppMethodBeat.o(254985);
        return localObject1;
        localObject1 = null;
        break;
        localc.setIncrementList(k.a.a(k.Anu, this.xGx.getPageName()));
      }
    }
    
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(254981);
      p.k(paramq, "scene");
      if ((paramq instanceof ct))
      {
        long l = ((ct)paramq).dpf();
        Log.i(getTAG(), "dealOnSceneEnd activeTopicId:" + this.xGx.xGt + " topicId:" + l);
        if (this.xGx.xGt != ((ct)paramq).dpf())
        {
          AppMethodBeat.o(254981);
          return null;
        }
        boolean bool;
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((ct)paramq).doo() == 0))
        {
          bool = false;
          localObject2 = this.xGx;
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label194;
          }
        }
        int i;
        label194:
        for (Object localObject1 = FinderFavFeedLoader.d.xGB;; localObject1 = FinderFavFeedLoader.d.xGC)
        {
          ((FinderFavFeedLoader)localObject2).a((FinderFavFeedLoader.d)localObject1);
          i = ((ct)paramq).dpe();
          localObject1 = ((ct)paramq).rr.bhY();
          if (localObject1 != null) {
            break label202;
          }
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(254981);
          throw paramString;
          bool = true;
          break;
        }
        label202:
        localObject1 = ((aub)localObject1).usualTopics;
        p.j(localObject1, "(rr.responseProtoBuf as …ListResponse).usualTopics");
        localObject1 = new FinderFavFeedLoader.c(paramInt1, paramInt2, paramString, i, (List)localObject1);
        Object localObject2 = (Iterable)((ct)paramq).dow();
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
        ((FinderFavFeedLoader.c)localObject1).setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        c.a.a((List)((ct)paramq).dow(), 256, this.xGx.getContextObj());
        if (((ct)paramq).pullType != 2)
        {
          if ((l == 0L) && (this.xGx.xGs == FinderFavFeedLoader.d.xGB))
          {
            paramString = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
            paramString = ((FinderFavFeedLoader.c)localObject1).getIncrementList();
            if (paramString == null)
            {
              paramString = new t("null cannot be cast to non-null type kotlin.collections.List<com.tencent.mm.plugin.finder.model.BaseFinderFeed>");
              AppMethodBeat.o(254981);
              throw paramString;
            }
            c.a.b(paramString, 256, true);
          }
          ((FinderFavFeedLoader.c)localObject1).jlf = ((ct)paramq).dpe();
          ((FinderFavFeedLoader.c)localObject1).xGy = ((ct)paramq).dom();
        }
        localObject2 = getTAG();
        Object localObject3 = new StringBuilder("incrementList size: ");
        paramString = ((FinderFavFeedLoader.c)localObject1).getIncrementList();
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.size());; paramString = null)
        {
          Log.i((String)localObject2, paramString);
          ((FinderFavFeedLoader.c)localObject1).setPullType(((ct)paramq).pullType);
          ((FinderFavFeedLoader.c)localObject1).setLastBuffer(((ct)paramq).don());
          ((FinderFavFeedLoader.c)localObject1).setHasMore(bool);
          paramString = (IResponse)localObject1;
          AppMethodBeat.o(254981);
          return paramString;
        }
      }
      AppMethodBeat.o(254981);
      return null;
    }
    
    public final void fetch(Object paramObject, h<bu> paramh)
    {
      AppMethodBeat.i(254968);
      p.k(paramh, "callback");
      super.fetch(paramObject, paramh);
      this.xGx.a(FinderFavFeedLoader.d.xGA);
      AppMethodBeat.o(254968);
    }
    
    public final com.tencent.mm.an.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(254976);
      Object localObject = new ct(FinderFavFeedLoader.a(this.xGx), this.xGx.getLastBuffer(), this.xGx.getContextObj(), this.xGx.xGt, (byte)0);
      ((ct)localObject).pullType = 2;
      localObject = (com.tencent.mm.an.q)localObject;
      AppMethodBeat.o(254976);
      return localObject;
    }
    
    public final com.tencent.mm.an.q genRefreshNetScene()
    {
      AppMethodBeat.i(254974);
      Object localObject = new ct(FinderFavFeedLoader.a(this.xGx), this.xGx.getLastBuffer(), this.xGx.getContextObj(), this.xGx.xGt, (byte)0);
      ((ct)localObject).pullType = 0;
      localObject = (com.tencent.mm.an.q)localObject;
      AppMethodBeat.o(254974);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(254971);
      List localList = j.listOf(Integer.valueOf(3966));
      AppMethodBeat.o(254971);
      return localList;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "megaVideoCount", "topicList", "", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "(IILjava/lang/String;IILjava/util/List;)V", "getMegaVideoCount", "()I", "setMegaVideoCount", "(I)V", "getTopicList", "()Ljava/util/List;", "setTopicList", "(Ljava/util/List;)V", "getTotalCount", "setTotalCount", "plugin-finder_release"})
  public static final class c
    extends IResponse<bu>
  {
    int jlf;
    List<? extends bkr> topicList;
    public int xGy;
    
    public c(int paramInt1, int paramInt2, String paramString, int paramInt3, List<? extends bkr> paramList)
    {
      super(paramInt2, paramString);
      this.jlf = paramInt3;
      this.xGy = 0;
      this.topicList = paramList;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$State;", "", "(Ljava/lang/String;I)V", "INIT", "LOADING", "LOADED", "FAILURE", "plugin-finder_release"})
  public static enum d
  {
    static
    {
      AppMethodBeat.i(274582);
      d locald1 = new d("INIT", 0);
      xGz = locald1;
      d locald2 = new d("LOADING", 1);
      xGA = locald2;
      d locald3 = new d("LOADED", 2);
      xGB = locald3;
      d locald4 = new d("FAILURE", 3);
      xGC = locald4;
      xGD = new d[] { locald1, locald2, locald3, locald4 };
      AppMethodBeat.o(274582);
    }
    
    private d() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public static final class e
    extends BaseFeedLoader<bu>.a
  {
    e()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bu> paramIResponse, final kotlin.g.a.b<? super IResponse<bu>, x> paramb)
    {
      int i = 0;
      AppMethodBeat.i(286932);
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
          break label293;
        }
        bool = true;
        label87:
        localc.mCI = bool;
        localc.YNF = paramIResponse.getHasMore();
        if (((localc.actionType == 0) || (localc.actionType == 4)) && (localc.YNG > 0)) {
          localc.YNE = null;
        }
        localc.lCh = Integer.valueOf(((FinderFavFeedLoader.c)paramIResponse).jlf);
        Log.i(this.xGx.getTAG(), "[onFetchRefreshDone]  reason=".concat(String.valueOf(localc)));
        localObject = paramIResponse.getIncrementList();
        if (localObject != null) {
          i = ((List)localObject).size();
        }
        if (!paramIResponse.getHasMore()) {
          break label299;
        }
        if (i > this.xGx.getDataList().size()) {
          break label374;
        }
        i = 2;
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.q(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), localc, paramb, paramIResponse));
        AppMethodBeat.o(286932);
        return;
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        localc.YNE = ((CharSequence)((Context)localObject).getResources().getString(b.j.finder_touch_to_retry));
        localc.YND = -1;
        break;
        label293:
        bool = false;
        break label87;
        label299:
        if ((this.xGx.getDataList().size() == 0) || (i == 0) || (this.xGx.getDataList().size() <= i))
        {
          localObject = paramIResponse.getIncrementList();
          if ((localObject != null) && (((List)localObject).containsAll((Collection)j.p((Iterable)this.xGx.getDataList())) == true))
          {
            i = 6;
            continue;
          }
        }
        label374:
        i = 4;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements a<x>
    {
      a(FinderFavFeedLoader.e parame, com.tencent.mm.plugin.finder.feed.model.internal.q paramq, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader
 * JD-Core Version:    0.7.0.1
 */