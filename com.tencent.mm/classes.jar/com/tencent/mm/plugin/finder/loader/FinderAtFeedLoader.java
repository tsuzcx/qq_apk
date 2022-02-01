package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hz;
import com.tencent.mm.plugin.finder.cgi.bs;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "loaderScene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "finderUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "cachedState", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$CacheState;", "getCachedState", "()Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$CacheState;", "setCachedState", "(Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$CacheState;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderUsername", "fromScene", "", "getFromScene", "()I", "setFromScene", "(I)V", "increment", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getIncrement", "()Ljava/util/List;", "setIncrement", "(Ljava/util/List;)V", "isLoading", "", "()Z", "setLoading", "(Z)V", "getLoaderScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "mentionCount", "getMentionCount", "setMentionCount", "refreshCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lkotlin/ParameterName;", "name", "response", "getRefreshCallback", "()Lkotlin/jvm/functions/Function1;", "setRefreshCallback", "(Lkotlin/jvm/functions/Function1;)V", "state", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$State;", "setState", "(Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$State;)V", "updateAtFeedListener", "com/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$updateAtFeedListener$1", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$updateAtFeedListener$1;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "isObservePostEvent", "notifyAtFeedChange", "feedId", "", "type", "(Ljava/lang/Long;Ljava/lang/Integer;)V", "notifyFeedTip", "position", "isShow", "onAlive", "onDead", "onFetchDone", "revertVisibleState", "changedVisibleList", "visible", "AtDataFetcher", "AtDataMerge", "CacheState", "Companion", "FinderAtTimelineResponse", "State", "plugin-finder_release"})
public final class FinderAtFeedLoader
  extends BaseFinderFeedLoader
{
  public static final d zsO;
  private String TAG;
  final String finderUsername;
  public int fromScene;
  public volatile int mentionCount;
  public a<x> xEI;
  public kotlin.g.a.b<? super IResponse<bu>, x> xGJ;
  public f zsJ;
  public c zsK;
  public List<? extends bu> zsL;
  private final g zsM;
  final g zsN;
  
  static
  {
    AppMethodBeat.i(288039);
    zsO = new d((byte)0);
    AppMethodBeat.o(288039);
  }
  
  public FinderAtFeedLoader(g paramg, String paramString, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(288038);
    this.zsN = paramg;
    this.finderUsername = paramString;
    this.TAG = "Finder.AtTimelineLoader";
    this.zsJ = f.zsX;
    this.zsK = c.zsS;
    this.zsM = new g(this);
    AppMethodBeat.o(288038);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(288030);
    p.k(paramc, "<set-?>");
    this.zsK = paramc;
    AppMethodBeat.o(288030);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(288029);
    p.k(paramf, "<set-?>");
    this.zsJ = paramf;
    AppMethodBeat.o(288029);
  }
  
  public final void a(Long paramLong, Integer paramInteger)
  {
    boolean bool = false;
    AppMethodBeat.i(288031);
    Log.i(getTAG(), "notifyAtFeedChange feedId:" + paramLong + ", type:" + paramInteger);
    Iterator localIterator = ((List)getDataList()).iterator();
    int i = 0;
    long l;
    label103:
    int j;
    if (localIterator.hasNext())
    {
      bu localbu = (bu)localIterator.next();
      if ((localbu instanceof BaseFinderFeed))
      {
        l = ((BaseFinderFeed)localbu).feedObject.getId();
        if (paramLong != null) {}
      }
      else
      {
        j = 0;
        label106:
        if (j == 0) {
          break label141;
        }
        label111:
        if (paramInteger != null) {
          break label153;
        }
      }
    }
    label141:
    label153:
    while (paramInteger.intValue() != 3)
    {
      if (paramInteger != null) {
        break label197;
      }
      AppMethodBeat.o(288031);
      return;
      if (l != paramLong.longValue()) {
        break label103;
      }
      j = 1;
      break label106;
      i += 1;
      break;
      i = -1;
      break label111;
    }
    label197:
    while (paramInteger.intValue() == 4)
    {
      if (i == -1) {
        break;
      }
      paramLong = getDataList().get(i);
      if (paramLong != null) {
        break label211;
      }
      paramLong = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
      AppMethodBeat.o(288031);
      throw paramLong;
    }
    AppMethodBeat.o(288031);
    return;
    label211:
    paramLong = ((BaseFinderFeed)paramLong).feedObject;
    if (paramInteger == null)
    {
      label223:
      j = 3;
      bool = true;
    }
    for (;;)
    {
      paramLong.setMentionListSelected(j);
      dispatcher().onItemRangeChanged(i, 1, new o(Integer.valueOf(23), Boolean.valueOf(bool)));
      break;
      if (paramInteger.intValue() != 3) {
        break label223;
      }
      j = 2;
    }
  }
  
  public final void am(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(288037);
    if ((paramInt >= 0) && (paramInt < getDataList().size()))
    {
      Log.i(getTAG(), "notifyFeedTip position:" + paramInt + " isShow:" + paramBoolean);
      dispatcher().onItemRangeChanged(paramInt, 1, new o(Integer.valueOf(23), Boolean.valueOf(paramBoolean)));
    }
    AppMethodBeat.o(288037);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(288027);
    i locali = (i)new a();
    AppMethodBeat.o(288027);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<bu> createDataMerger()
  {
    AppMethodBeat.i(288028);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new b();
    AppMethodBeat.o(288028);
    return locald;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final boolean isObservePostEvent()
  {
    return false;
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(288033);
    super.onAlive();
    this.zsM.alive();
    AppMethodBeat.o(288033);
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(288035);
    super.onDead();
    this.zsM.dead();
    AppMethodBeat.o(288035);
  }
  
  public final void onFetchDone(IResponse<bu> paramIResponse)
  {
    AppMethodBeat.i(288036);
    p.k(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    Object localObject;
    if (getDataListJustForAdapter().size() > 0) {
      localObject = c.zsU;
    }
    for (;;)
    {
      this.zsK = ((c)localObject);
      if (!isInitOperation(paramIResponse)) {
        break;
      }
      AppMethodBeat.o(288036);
      return;
      if (((paramIResponse instanceof e)) && (((e)paramIResponse).jlf > 0)) {
        localObject = c.zsV;
      } else {
        localObject = c.zsT;
      }
    }
    if (isRefreshOperation(paramIResponse))
    {
      localObject = this.xGJ;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(paramIResponse);
      }
    }
    if (!paramIResponse.getHasMore())
    {
      paramIResponse = this.xEI;
      if (paramIResponse != null)
      {
        paramIResponse.invoke();
        AppMethodBeat.o(288036);
        return;
      }
    }
    AppMethodBeat.o(288036);
  }
  
  public final void q(List<Long> paramList, int paramInt)
  {
    AppMethodBeat.i(288032);
    p.k(paramList, "changedVisibleList");
    Iterator localIterator1 = paramList.iterator();
    label62:
    label222:
    label234:
    label240:
    label243:
    while (localIterator1.hasNext())
    {
      long l = ((Number)localIterator1.next()).longValue();
      Iterator localIterator2 = ((List)getDataList()).iterator();
      int i = 0;
      bu localbu;
      int j;
      if (localIterator2.hasNext())
      {
        localbu = (bu)localIterator2.next();
        paramList = localbu;
        if (!(localbu instanceof BaseFinderFeed)) {
          paramList = null;
        }
        paramList = (BaseFinderFeed)paramList;
        if (paramList != null)
        {
          paramList = paramList.feedObject;
          if ((paramList != null) && (paramList.getId() == l))
          {
            j = 1;
            if (j == 0) {
              break label222;
            }
            paramList = getDataList();
            if ((i < 0) || (i >= paramList.size())) {
              break label234;
            }
            j = 1;
            if (j == 0) {
              break label240;
            }
          }
        }
      }
      for (;;)
      {
        if (paramList == null) {
          break label243;
        }
        localbu = (bu)paramList.get(i);
        if (localbu == null) {
          break;
        }
        paramList = localbu;
        if (!(localbu instanceof BaseFinderFeed)) {
          paramList = null;
        }
        paramList = (BaseFinderFeed)paramList;
        if (paramList == null) {
          break;
        }
        paramList = paramList.feedObject;
        if (paramList == null) {
          break;
        }
        paramList.setMentionListSelected(paramInt);
        break;
        j = 0;
        break label128;
        i += 1;
        break label62;
        i = -1;
        break label133;
        j = 0;
        break label153;
        paramList = null;
      }
    }
    label128:
    label133:
    label153:
    AppMethodBeat.o(288032);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(288026);
    p.k(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(288026);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$AtDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"})
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public final IResponse<bu> callInit()
    {
      List localList = null;
      AppMethodBeat.i(290963);
      Object localObject1 = this.zsP.getCache();
      Object localObject2;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.finder.feed.model.q)localObject1).mXB != null))
      {
        localObject2 = new FinderAtFeedLoader.e(0, 0, "");
        localObject1 = this.zsP.getCache();
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.feed.model.q)localObject1).mXB;
          ((FinderAtFeedLoader.e)localObject2).setIncrementList((List)localObject1);
          com.tencent.mm.plugin.finder.feed.model.q localq = this.zsP.getCache();
          localObject1 = localList;
          if (localq != null) {
            localObject1 = localq.lastBuffer;
          }
          ((FinderAtFeedLoader.e)localObject2).setLastBuffer((com.tencent.mm.cd.b)localObject1);
          ((FinderAtFeedLoader.e)localObject2).setHasMore(true);
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        localObject1 = (IResponse)localObject1;
        AppMethodBeat.o(290963);
        return localObject1;
        localObject1 = null;
        break;
        localObject2 = (a)this;
        localObject1 = this.zsP.zsN;
        switch (b.tKM[localObject1.ordinal()])
        {
        default: 
          localObject1 = new FinderAtFeedLoader.e(0, 0, "");
          localList = k.Anu.bc(14, this.zsP.finderUsername);
          Log.i(((a)localObject2).getTAG(), "[callInit] page list=" + localList.size());
          ((FinderAtFeedLoader.e)localObject1).setIncrementList(localList);
          ((FinderAtFeedLoader.e)localObject1).setLastBuffer(null);
          ((FinderAtFeedLoader.e)localObject1).setHasMore(true);
          break;
        case 1: 
        case 2: 
          localObject1 = new FinderAtFeedLoader.e(0, 0, "");
          Log.i(((a)localObject2).getTAG(), "[callInit] init list=0");
          ((FinderAtFeedLoader.e)localObject1).setIncrementList((List)new LinkedList());
          ((FinderAtFeedLoader.e)localObject1).setLastBuffer(null);
          ((FinderAtFeedLoader.e)localObject1).setHasMore(true);
          break;
        case 3: 
          localObject1 = new FinderAtFeedLoader.e(0, 0, "");
          localList = k.Anu.bc(18, this.zsP.finderUsername);
          Log.i(((a)localObject2).getTAG(), "[callInit] page list=" + localList.size());
          ((FinderAtFeedLoader.e)localObject1).setIncrementList(localList);
          ((FinderAtFeedLoader.e)localObject1).setLastBuffer(null);
          ((FinderAtFeedLoader.e)localObject1).setHasMore(true);
        }
      }
    }
    
    public final IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(290964);
      p.k(paramq, "scene");
      Object localObject2 = this.zsP;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (Object localObject1 = FinderAtFeedLoader.f.zsZ;; localObject1 = FinderAtFeedLoader.f.zta)
      {
        ((FinderAtFeedLoader)localObject2).a((FinderAtFeedLoader.f)localObject1);
        localObject1 = (bs)paramq;
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label243;
        }
        localObject2 = ((bs)localObject1).rr.bhY();
        if (localObject2 != null) {
          break;
        }
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
        AppMethodBeat.o(290964);
        throw paramString;
      }
      if (((avj)localObject2).xFI == 0) {}
      label243:
      for (boolean bool = false;; bool = true)
      {
        localObject2 = new FinderAtFeedLoader.e(paramInt1, paramInt2, paramString);
        localObject3 = (Iterable)((bs)paramq).dor();
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FinderObject)((Iterator)localObject3).next();
          Object localObject5 = FinderItem.Companion;
          localObject4 = FinderItem.a.b((FinderObject)localObject4, 8192);
          localObject5 = FinderAtTimelineUI.xLF;
          ((Map)FinderAtTimelineUI.duS()).put(Long.valueOf(((FinderItem)localObject4).getId()), localObject4);
          localObject5 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
          paramString.add(c.a.a((FinderItem)localObject4));
        }
      }
      ((FinderAtFeedLoader.e)localObject2).setIncrementList((List)paramString);
      if ((this.zsP.zsN == g.xKE) && (((bs)localObject1).pullType == 2)) {
        this.zsP.zsL = ((FinderAtFeedLoader.e)localObject2).getIncrementList();
      }
      Object localObject3 = getTAG();
      Object localObject4 = new StringBuilder("pullType=").append(((bs)localObject1).pullType).append(" username=").append(this.zsP.finderUsername).append(" incrementList size: ");
      paramString = ((FinderAtFeedLoader.e)localObject2).getIncrementList();
      if (paramString != null) {}
      for (paramString = Integer.valueOf(paramString.size());; paramString = null)
      {
        Log.i((String)localObject3, paramString + " totalCount: " + ((bs)paramq).dos());
        ((FinderAtFeedLoader.e)localObject2).setPullType(((bs)localObject1).pullType);
        paramString = ((bs)localObject1).rr.bhY();
        if (paramString != null) {
          break;
        }
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
        AppMethodBeat.o(290964);
        throw paramString;
      }
      ((FinderAtFeedLoader.e)localObject2).setLastBuffer(((avj)paramString).SDI);
      ((FinderAtFeedLoader.e)localObject2).setHasMore(bool);
      ((FinderAtFeedLoader.e)localObject2).jlf = ((bs)paramq).dos();
      this.zsP.mentionCount = ((FinderAtFeedLoader.e)localObject2).jlf;
      if (((bs)localObject1).pullType == 1)
      {
        paramString = ((FinderAtFeedLoader.e)localObject2).getIncrementList();
        if (paramString != null) {
          com.tencent.mm.ae.d.h((a)new a(paramString, this));
        }
      }
      paramString = (IResponse)localObject2;
      AppMethodBeat.o(290964);
      return paramString;
    }
    
    public final void fetch(Object paramObject, h<bu> paramh)
    {
      AppMethodBeat.i(290960);
      p.k(paramh, "callback");
      super.fetch(paramObject, paramh);
      this.zsP.a(FinderAtFeedLoader.f.zsY);
      AppMethodBeat.o(290960);
    }
    
    public final com.tencent.mm.an.q genLoadMoreNetScene()
    {
      AppMethodBeat.i(290962);
      Object localObject = this.zsP.zsN;
      switch (b.jLJ[localObject.ordinal()])
      {
      default: 
        localObject = new bs(this.zsP.finderUsername, this.zsP.getLastBuffer());
        ((bs)localObject).pullType = 2;
        localObject = (com.tencent.mm.an.q)localObject;
        AppMethodBeat.o(290962);
        return localObject;
      case 1: 
      case 2: 
        localObject = new bs(this.zsP.finderUsername, this.zsP.getLastBuffer(), 2);
        ((bs)localObject).pullType = 2;
        localObject = (com.tencent.mm.an.q)localObject;
        AppMethodBeat.o(290962);
        return localObject;
      case 3: 
        if ((this.zsP.fromScene == g.xKC.value) || (this.zsP.fromScene == g.xKu.value)) {
          localObject = new bs(this.zsP.finderUsername, this.zsP.getLastBuffer(), 2);
        }
        for (((bs)localObject).pullType = 2;; ((bs)localObject).pullType = 2)
        {
          localObject = (com.tencent.mm.an.q)localObject;
          AppMethodBeat.o(290962);
          return localObject;
          localObject = new bs(this.zsP.finderUsername, this.zsP.getLastBuffer(), 1);
        }
      }
      localObject = new bs(this.zsP.finderUsername, this.zsP.getLastBuffer(), 1);
      ((bs)localObject).pullType = 2;
      localObject = (com.tencent.mm.an.q)localObject;
      AppMethodBeat.o(290962);
      return localObject;
    }
    
    public final com.tencent.mm.an.q genRefreshNetScene()
    {
      Object localObject2 = null;
      AppMethodBeat.i(290961);
      Object localObject1 = this.zsP.zsN;
      switch (b.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        localObject1 = new bs(this.zsP.finderUsername, this.zsP.getLastBuffer());
        ((bs)localObject1).pullType = 1;
        localObject1 = (com.tencent.mm.an.q)localObject1;
        AppMethodBeat.o(290961);
        return localObject1;
      case 1: 
      case 2: 
      case 3: 
        String str = this.zsP.finderUsername;
        localObject1 = localObject2;
        if (this.zsP.zsN != g.xKC) {
          if (this.zsP.zsN != g.xKD) {
            break label167;
          }
        }
        for (localObject1 = localObject2;; localObject1 = this.zsP.getLastBuffer())
        {
          localObject1 = new bs(str, (com.tencent.mm.cd.b)localObject1, 2);
          ((bs)localObject1).pullType = 1;
          localObject1 = (com.tencent.mm.an.q)localObject1;
          AppMethodBeat.o(290961);
          return localObject1;
        }
      case 4: 
        label167:
        if ((this.zsP.fromScene == g.xKC.value) || (this.zsP.fromScene == g.xKu.value)) {
          localObject1 = new bs(this.zsP.finderUsername, this.zsP.getLastBuffer(), 2);
        }
        for (((bs)localObject1).pullType = 1;; ((bs)localObject1).pullType = 1)
        {
          localObject1 = (com.tencent.mm.an.q)localObject1;
          AppMethodBeat.o(290961);
          return localObject1;
          localObject1 = new bs(this.zsP.finderUsername, this.zsP.getLastBuffer(), 1);
        }
      }
      localObject1 = new bs(this.zsP.finderUsername, null, 1);
      ((bs)localObject1).pullType = 1;
      localObject1 = (com.tencent.mm.an.q)localObject1;
      AppMethodBeat.o(290961);
      return localObject1;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(290959);
      List localList = j.listOf(Integer.valueOf(3810));
      AppMethodBeat.o(290959);
      return localList;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$AtDataFetcher$dealOnSceneEnd$2$1"})
    static final class a
      extends kotlin.g.b.q
      implements a<x>
    {
      a(List paramList, FinderAtFeedLoader.a parama)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$AtDataMerge;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;)V", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
  public final class b
    extends BaseFeedLoader<bu>.a
  {
    public b()
    {
      super();
    }
    
    public final void mergeRefresh(final IResponse<bu> paramIResponse, final kotlin.g.a.b<? super IResponse<bu>, x> paramb)
    {
      AppMethodBeat.i(290520);
      p.k(paramIResponse, "response");
      Object localObject = this.zsP.zsN;
      switch (c.$EnumSwitchMapping$0[localObject.ordinal()])
      {
      default: 
        super.mergeRefresh(paramIResponse, paramb);
        AppMethodBeat.o(290520);
        return;
      }
      localObject = RefreshLoadMoreLayout.c.YNO;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.ihs());
      com.tencent.mm.ae.d.uiThread((a)new a(this, new com.tencent.mm.plugin.finder.feed.model.internal.q(7, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
      AppMethodBeat.o(290520);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements a<x>
    {
      a(FinderAtFeedLoader.b paramb, com.tencent.mm.plugin.finder.feed.model.internal.q paramq, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb1, IResponse paramIResponse)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$CacheState;", "", "(Ljava/lang/String;I)V", "INIT", "NO_CACHE", "WITH_CACHED", "WITH_INVISIBLE_CACHE", "plugin-finder_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(277909);
      c localc1 = new c("INIT", 0);
      zsS = localc1;
      c localc2 = new c("NO_CACHE", 1);
      zsT = localc2;
      c localc3 = new c("WITH_CACHED", 2);
      zsU = localc3;
      c localc4 = new c("WITH_INVISIBLE_CACHE", 3);
      zsV = localc4;
      zsW = new c[] { localc1, localc2, localc3, localc4 };
      AppMethodBeat.o(277909);
    }
    
    private c() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$Companion;", "", "()V", "MMFinderMentionedListOption_ALL", "", "MMFinderMentionedListOption_NOT_SELECTED", "MMFinderMentionedListOption_SELECTED", "plugin-finder_release"})
  public static final class d {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$FinderAtTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "totalCount", "getTotalCount", "()I", "setTotalCount", "(I)V", "plugin-finder_release"})
  public static final class e
    extends IResponse<bu>
  {
    public int jlf;
    
    public e(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$State;", "", "(Ljava/lang/String;I)V", "INIT", "LOADING", "LOADED", "FAILURE", "plugin-finder_release"})
  public static enum f
  {
    static
    {
      AppMethodBeat.i(270400);
      f localf1 = new f("INIT", 0);
      zsX = localf1;
      f localf2 = new f("LOADING", 1);
      zsY = localf2;
      f localf3 = new f("LOADED", 2);
      zsZ = localf3;
      f localf4 = new f("FAILURE", 3);
      zta = localf4;
      ztb = new f[] { localf1, localf2, localf3, localf4 };
      AppMethodBeat.o(270400);
    }
    
    private f() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$updateAtFeedListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderAtFeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class g
    extends IListener<hz>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader
 * JD-Core Version:    0.7.0.1
 */