package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.plugin.finder.cgi.dv;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.model.internal.r;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxv;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "finderUserName", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isTimeline", "", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "activeTopicId", "", "getActiveTopicId", "()J", "setActiveTopicId", "(J)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "onFilterDataChanged", "Lkotlin/Function0;", "getOnFilterDataChanged", "()Lkotlin/jvm/functions/Function0;", "setOnFilterDataChanged", "(Lkotlin/jvm/functions/Function0;)V", "refObjectId", "getRefObjectId", "setRefObjectId", "state", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$State;", "setState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$State;)V", "topics", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTopics", "()Ljava/util/ArrayList;", "totalCount", "", "getTotalCount", "()I", "setTotalCount", "(I)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "getPageName", "initTopics", "topicList", "", "isCurrentAllData", "isShouldRefreshFooter", "onFetchDone", "response", "remove", "feedId", "notify", "requestLoadMore", "isAuto", "switchTopic", "topicId", "Companion", "FavDataFetcher", "FinderFavListResponse", "State", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFavFeedLoader
  extends BaseFinderFeedLoader
{
  public static final a Bfy;
  final boolean AxW;
  public long BfA;
  public final ArrayList<bxv> BfB;
  d Bfz;
  public kotlin.g.a.b<? super IResponse<cc>, ah> fetchEndCallback;
  public boolean hasMore;
  public int lNX;
  public a<ah> onFilterDataChanged;
  private final String zDJ;
  
  static
  {
    AppMethodBeat.i(366169);
    Bfy = new a((byte)0);
    AppMethodBeat.o(366169);
  }
  
  public FinderFavFeedLoader(String paramString, bui parambui, boolean paramBoolean)
  {
    super(parambui);
    AppMethodBeat.i(366159);
    this.zDJ = paramString;
    this.AxW = paramBoolean;
    this.Bfz = d.BfE;
    this.BfB = new ArrayList(5);
    AppMethodBeat.o(366159);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(366190);
    kotlin.g.b.s.u(paramd, "<set-?>");
    this.Bfz = paramd;
    AppMethodBeat.o(366190);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(366176);
    i locali = (i)new b();
    AppMethodBeat.o(366176);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(366182);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new e(this);
    AppMethodBeat.o(366182);
    return locald;
  }
  
  public final int getPageName()
  {
    return 10;
  }
  
  public final boolean nD(long paramLong)
  {
    AppMethodBeat.i(366218);
    Log.i(getTAG(), kotlin.g.b.s.X("switchToTopic ", Long.valueOf(paramLong)));
    Object localObject;
    if (this.BfA != paramLong)
    {
      if (this.Bfz == d.BfG)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).addAll((Collection)getDataList());
        ah localah = ah.aiuX;
        localObject = new s((ArrayList)localObject, getLastBuffer(), 0, null);
        ((s)localObject).hasMore = this.hasMore;
        getStore().a(String.valueOf(this.BfA), (s)localObject);
        Log.i(getTAG(), "save cache of TopicId:" + this.BfA + ", size:" + getDataList().size());
      }
      getDataList().clear();
      this.Bfz = d.BfE;
      this.BfA = paramLong;
      localObject = getStore().avZ(String.valueOf(paramLong));
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          break label316;
        }
        setLastBuffer(null);
        this.hasMore = false;
        requestRefresh();
        dispatcher().onChanged();
      }
    }
    label316:
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(366218);
      return bool;
      a(d.BfG);
      getDataList().addAll((Collection)((s)localObject).pUj);
      setLastBuffer(((s)localObject).lastBuffer);
      this.hasMore = ((s)localObject).hasMore;
      Log.i(getTAG(), "restore cache, topicId:" + paramLong + ", size:" + ((s)localObject).pUj);
      dispatcher().onChanged();
      break;
    }
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    int j = 0;
    AppMethodBeat.i(366201);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (isInitOperation(paramIResponse))
    {
      AppMethodBeat.o(366201);
      return;
    }
    if ((paramIResponse.getPullType() == 0) && ((paramIResponse instanceof c)))
    {
      this.lNX = ((c)paramIResponse).lNX;
      if (this.BfA == 0L)
      {
        localObject = ((c)paramIResponse).topicList;
        String str = getTAG();
        int i;
        if (localObject == null)
        {
          i = 0;
          Log.i(str, kotlin.g.b.s.X("initTopics size:", Integer.valueOf(i)));
          if (localObject == null) {
            break label193;
          }
          if (((List)localObject).size() <= 5) {
            break label163;
          }
          i = 5;
        }
        for (;;)
        {
          if (j >= i) {
            break label174;
          }
          this.BfB.add(((List)localObject).get(j));
          j += 1;
          continue;
          i = ((List)localObject).size();
          break;
          label163:
          i = ((List)localObject).size();
        }
        label174:
        localObject = this.onFilterDataChanged;
        if (localObject != null) {
          ((a)localObject).invoke();
        }
      }
    }
    label193:
    this.hasMore = paramIResponse.getHasMore();
    Object localObject = this.fetchEndCallback;
    if (localObject != null) {
      ((kotlin.g.a.b)localObject).invoke(paramIResponse);
    }
    AppMethodBeat.o(366201);
  }
  
  public final int remove(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(366240);
    s locals;
    int i;
    int j;
    if (this.BfA != 0L)
    {
      locals = getStore().avZ("0");
      if (locals != null)
      {
        Iterator localIterator = ((List)locals.pUj).iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break label155;
        }
        if (((cc)localIterator.next()).bZA() != paramLong) {
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
        locals.pUj.remove(i);
      }
      Log.i(getTAG(), kotlin.g.b.s.X("remove from all index:", Integer.valueOf(i)));
      i = super.remove(paramLong, paramBoolean);
      AppMethodBeat.o(366240);
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
  
  public final void requestLoadMore(boolean paramBoolean)
  {
    AppMethodBeat.i(366233);
    Log.i(getTAG(), kotlin.g.b.s.X("requestLoadMore hasMore:", Boolean.valueOf(this.hasMore)));
    if (this.AxW)
    {
      super.requestLoadMore(paramBoolean);
      AppMethodBeat.o(366233);
      return;
    }
    if (this.hasMore) {
      super.requestLoadMore(paramBoolean);
    }
    AppMethodBeat.o(366233);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$Companion;", "", "()V", "TAG", "", "TOPIC_MAX_SIZE", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FavDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "isAuto", "", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public b()
    {
      AppMethodBeat.i(366284);
      AppMethodBeat.o(366284);
    }
    
    public final IResponse<cc> callInit()
    {
      Object localObject2 = null;
      AppMethodBeat.i(366338);
      Log.i(getTAG(), "fetchInit initCount ");
      FinderFavFeedLoader.c localc = new FinderFavFeedLoader.c("");
      Object localObject1;
      if (this.BfC.AxW)
      {
        localObject1 = this.BfC.getCache();
        if (localObject1 == null)
        {
          localObject1 = null;
          localc.setIncrementList((List)localObject1);
          localObject1 = this.BfC.getCache();
          if (localObject1 != null) {
            break label97;
          }
          localObject1 = localObject2;
          label72:
          localc.setLastBuffer((com.tencent.mm.bx.b)localObject1);
        }
      }
      for (;;)
      {
        localObject1 = (IResponse)localc;
        AppMethodBeat.o(366338);
        return localObject1;
        localObject1 = ((s)localObject1).pUj;
        break;
        label97:
        localObject1 = ((s)localObject1).lastBuffer;
        break label72;
        localc.setIncrementList(k.a.a(k.FNg, this.BfC.getPageName()));
      }
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(366328);
      kotlin.g.b.s.u(paramp, "scene");
      if ((paramp instanceof dv))
      {
        long l = ((dv)paramp).dWG();
        Log.i(getTAG(), "dealOnSceneEnd activeTopicId:" + this.BfC.BfA + " topicId:" + l);
        if (this.BfC.BfA != ((dv)paramp).dWG())
        {
          AppMethodBeat.o(366328);
          return null;
        }
        boolean bool;
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((dv)paramp).dVZ() == 0))
        {
          bool = false;
          localObject2 = this.BfC;
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label197;
          }
        }
        int i;
        label197:
        for (Object localObject1 = FinderFavFeedLoader.d.BfG;; localObject1 = FinderFavFeedLoader.d.BfH)
        {
          ((FinderFavFeedLoader)localObject2).a((FinderFavFeedLoader.d)localObject1);
          i = ((dv)paramp).dWF();
          localObject1 = c.c.b(((dv)paramp).rr.otC);
          if (localObject1 != null) {
            break label205;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(366328);
          throw paramString;
          bool = true;
          break;
        }
        label205:
        localObject1 = ((ayt)localObject1).usualTopics;
        kotlin.g.b.s.s(localObject1, "rr.responseProtoBuf as F…ListResponse).usualTopics");
        localObject1 = new FinderFavFeedLoader.c(paramInt1, paramInt2, paramString, i, (List)localObject1);
        Object localObject2 = (Iterable)((dv)paramp).dVW();
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
        ((FinderFavFeedLoader.c)localObject1).setIncrementList((List)paramString);
        paramString = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        d.a.a((List)((dv)paramp).dVW(), 256, this.BfC.getContextObj());
        if (((dv)paramp).pullType != 2)
        {
          if ((l == 0L) && (this.BfC.Bfz == FinderFavFeedLoader.d.BfG))
          {
            paramString = com.tencent.mm.plugin.finder.storage.logic.d.FND;
            paramString = ((FinderFavFeedLoader.c)localObject1).getIncrementList();
            if (paramString == null)
            {
              paramString = new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.tencent.mm.plugin.finder.model.BaseFinderFeed>");
              AppMethodBeat.o(366328);
              throw paramString;
            }
            d.a.c(paramString, 256, true);
          }
          ((FinderFavFeedLoader.c)localObject1).lNX = ((dv)paramp).dWF();
          ((FinderFavFeedLoader.c)localObject1).BfD = ((dv)paramp).dVX();
        }
        localObject2 = getTAG();
        paramString = ((FinderFavFeedLoader.c)localObject1).getIncrementList();
        if (paramString == null) {}
        for (paramString = null;; paramString = Integer.valueOf(paramString.size()))
        {
          Log.i((String)localObject2, kotlin.g.b.s.X("incrementList size: ", paramString));
          ((FinderFavFeedLoader.c)localObject1).setPullType(((dv)paramp).pullType);
          ((FinderFavFeedLoader.c)localObject1).setLastBuffer(((dv)paramp).dVY());
          ((FinderFavFeedLoader.c)localObject1).setHasMore(bool);
          paramString = (IResponse)localObject1;
          AppMethodBeat.o(366328);
          return paramString;
        }
      }
      AppMethodBeat.o(366328);
      return null;
    }
    
    public final void fetch(Object paramObject, h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(366291);
      kotlin.g.b.s.u(paramh, "callback");
      super.fetch(paramObject, paramh, paramBoolean);
      this.BfC.a(FinderFavFeedLoader.d.BfF);
      AppMethodBeat.o(366291);
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(366312);
      Object localObject = new dv(FinderFavFeedLoader.a(this.BfC), this.BfC.getLastBuffer(), this.BfC.getContextObj(), this.BfC.BfA, (byte)0);
      ((dv)localObject).pullType = 2;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(366312);
      return localObject;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(366304);
      Object localObject = new dv(FinderFavFeedLoader.a(this.BfC), this.BfC.getLastBuffer(), this.BfC.getContextObj(), this.BfC.BfA, (byte)0);
      ((dv)localObject).pullType = 0;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(366304);
      return localObject;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(366297);
      List localList = kotlin.a.p.listOf(Integer.valueOf(3966));
      AppMethodBeat.o(366297);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$FinderFavListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "totalCount", "megaVideoCount", "topicList", "", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "(IILjava/lang/String;IILjava/util/List;)V", "getMegaVideoCount", "()I", "setMegaVideoCount", "(I)V", "getTopicList", "()Ljava/util/List;", "setTopicList", "(Ljava/util/List;)V", "getTotalCount", "setTotalCount", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends IResponse<cc>
  {
    public int BfD;
    int lNX;
    List<? extends bxv> topicList;
    
    public c(int paramInt1, int paramInt2, String paramString, int paramInt3, List<? extends bxv> paramList)
    {
      super(paramInt2, paramString);
      this.lNX = paramInt3;
      this.BfD = 0;
      this.topicList = paramList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$State;", "", "(Ljava/lang/String;I)V", "INIT", "LOADING", "LOADED", "FAILURE", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum d
  {
    static
    {
      AppMethodBeat.i(366298);
      BfE = new d("INIT", 0);
      BfF = new d("LOADING", 1);
      BfG = new d("LOADED", 2);
      BfH = new d("FAILURE", 3);
      BfI = new d[] { BfE, BfF, BfG, BfH };
      AppMethodBeat.o(366298);
    }
    
    private d() {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends BaseFeedLoader<cc>.a
  {
    e(FinderFavFeedLoader paramFinderFavFeedLoader)
    {
      super(false, 1, null);
      AppMethodBeat.i(366275);
      AppMethodBeat.o(366275);
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      int j = 1;
      AppMethodBeat.i(366287);
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
          break label267;
        }
        bool = true;
        locald.pzq = bool;
        locald.agJu = paramIResponse.getHasMore();
        if (((locald.actionType == 0) || (locald.actionType == 4)) && (locald.agJv > 0)) {
          locald.agJt = null;
        }
        locald.extra = Integer.valueOf(((FinderFavFeedLoader.c)paramIResponse).lNX);
        Log.i(this.BfC.getTAG(), kotlin.g.b.s.X("[onFetchRefreshDone]  reason=", locald));
        localList = paramIResponse.getIncrementList();
        if (localList != null) {
          break label273;
        }
        i = 0;
        label169:
        if (!paramIResponse.getHasMore()) {
          break label284;
        }
        if (i > this.BfC.getDataList().size()) {
          break label371;
        }
        i = 2;
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((a)new a(this, new r(i, paramIResponse.getIncrementList(), paramIResponse.isNeedClear(), 8), locald, this.BfC, paramb, paramIResponse));
        AppMethodBeat.o(366287);
        return;
        locald.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(e.h.finder_touch_to_retry));
        locald.agJs = -1;
        break;
        label267:
        bool = false;
        break label77;
        label273:
        i = localList.size();
        break label169;
        label284:
        if ((this.BfC.getDataList().size() == 0) || (i == 0) || (this.BfC.getDataList().size() <= i))
        {
          localList = paramIResponse.getIncrementList();
          if ((localList != null) && (localList.containsAll((Collection)kotlin.a.p.p((Iterable)this.BfC.getDataList())) == true)) {}
          for (i = j;; i = 0)
          {
            if (i == 0) {
              break label371;
            }
            i = 6;
            break;
          }
        }
        label371:
        i = 4;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements a<ah>
    {
      a(FinderFavFeedLoader.e parame, r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd, FinderFavFeedLoader paramFinderFavFeedLoader, kotlin.g.a.b<? super IResponse<cc>, ah> paramb, IResponse<cc> paramIResponse)
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