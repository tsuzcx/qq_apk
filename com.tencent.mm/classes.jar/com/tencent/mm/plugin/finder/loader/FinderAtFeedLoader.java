package com.tencent.mm.plugin.finder.loader;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.ik;
import com.tencent.mm.plugin.finder.cgi.cq;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "loaderScene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "finderUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "cachedState", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$CacheState;", "getCachedState", "()Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$CacheState;", "setCachedState", "(Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$CacheState;)V", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderUsername", "fromScene", "", "getFromScene", "()I", "setFromScene", "(I)V", "increment", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getIncrement", "()Ljava/util/List;", "setIncrement", "(Ljava/util/List;)V", "isLoading", "", "()Z", "setLoading", "(Z)V", "getLoaderScene", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "mentionCount", "getMentionCount", "setMentionCount", "refreshCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lkotlin/ParameterName;", "name", "response", "getRefreshCallback", "()Lkotlin/jvm/functions/Function1;", "setRefreshCallback", "(Lkotlin/jvm/functions/Function1;)V", "state", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$State;", "setState", "(Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$State;)V", "updateAtFeedListener", "com/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$updateAtFeedListener$1", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$updateAtFeedListener$1;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "isObservePostEvent", "notifyAtFeedChange", "feedId", "", "type", "(Ljava/lang/Long;Ljava/lang/Integer;)V", "notifyFeedTip", "position", "isShow", "onAlive", "onDead", "onFetchDone", "onFetchInitDone", "initResponse", "revertVisibleState", "changedVisibleList", "visible", "AtDataFetcher", "AtDataMerge", "CacheState", "Companion", "FinderAtTimelineResponse", "State", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderAtFeedLoader
  extends BaseFinderFeedLoader
{
  public static final d EwB;
  public a<ah> BbB;
  public kotlin.g.a.b<? super IResponse<cc>, ah> BfX;
  final g EwC;
  public f EwD;
  public c EwE;
  public List<? extends cc> EwF;
  private final updateAtFeedListener.1 EwG;
  private String TAG;
  final String finderUsername;
  public int fromScene;
  public volatile int mentionCount;
  
  static
  {
    AppMethodBeat.i(331828);
    EwB = new d((byte)0);
    AppMethodBeat.o(331828);
  }
  
  public FinderAtFeedLoader(g paramg, String paramString, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(331824);
    this.EwC = paramg;
    this.finderUsername = paramString;
    this.TAG = "Finder.AtTimelineLoader";
    this.EwD = f.EwQ;
    this.EwE = c.EwL;
    this.EwG = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(331824);
  }
  
  public final void J(List<Long> paramList, int paramInt)
  {
    AppMethodBeat.i(331879);
    kotlin.g.b.s.u(paramList, "changedVisibleList");
    Iterator localIterator1 = paramList.iterator();
    label60:
    label93:
    label225:
    label228:
    label230:
    label235:
    label241:
    while (localIterator1.hasNext())
    {
      long l = ((Number)localIterator1.next()).longValue();
      Iterator localIterator2 = ((List)getDataList()).iterator();
      int i = 0;
      int j;
      if (localIterator2.hasNext())
      {
        paramList = (cc)localIterator2.next();
        if ((paramList instanceof BaseFinderFeed))
        {
          paramList = (BaseFinderFeed)paramList;
          if (paramList == null) {
            break label201;
          }
          paramList = paramList.feedObject;
          if ((paramList == null) || (paramList.getId() != l)) {
            break label201;
          }
          j = 1;
          label119:
          if (j == 0) {
            break label207;
          }
          label124:
          paramList = getDataList();
          if ((i < 0) || (i >= paramList.size())) {
            break label219;
          }
          j = 1;
          if (j == 0) {
            break label225;
          }
          if (paramList == null) {
            break label228;
          }
          paramList = (cc)paramList.get(i);
          if (paramList == null) {
            continue;
          }
          if (!(paramList instanceof BaseFinderFeed)) {
            break label230;
          }
          paramList = (BaseFinderFeed)paramList;
          if (paramList != null) {
            break label235;
          }
        }
      }
      for (paramList = null;; paramList = paramList.feedObject)
      {
        if (paramList == null) {
          break label241;
        }
        paramList.setMentionListSelected(paramInt);
        break;
        paramList = null;
        break label93;
        j = 0;
        break label119;
        i += 1;
        break label60;
        i = -1;
        break label124;
        j = 0;
        break label144;
        paramList = null;
        break label149;
        break;
        paramList = null;
        break label178;
      }
    }
    label144:
    label149:
    label178:
    label201:
    label207:
    label219:
    AppMethodBeat.o(331879);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(331859);
    kotlin.g.b.s.u(paramc, "<set-?>");
    this.EwE = paramc;
    AppMethodBeat.o(331859);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(331852);
    kotlin.g.b.s.u(paramf, "<set-?>");
    this.EwD = paramf;
    AppMethodBeat.o(331852);
  }
  
  public final void a(Long paramLong, Integer paramInteger)
  {
    boolean bool = false;
    AppMethodBeat.i(331872);
    Log.i(getTAG(), "notifyAtFeedChange feedId:" + paramLong + ", type:" + paramInteger);
    Iterator localIterator = ((List)getDataList()).iterator();
    int i = 0;
    long l;
    label106:
    int j;
    if (localIterator.hasNext())
    {
      cc localcc = (cc)localIterator.next();
      if ((localcc instanceof BaseFinderFeed))
      {
        l = ((BaseFinderFeed)localcc).feedObject.getId();
        if (paramLong != null) {}
      }
      else
      {
        j = 0;
        label109:
        if (j == 0) {
          break label145;
        }
        label114:
        if (paramInteger != null) {
          break label157;
        }
      }
    }
    for (;;)
    {
      if (paramInteger == null)
      {
        AppMethodBeat.o(331872);
        return;
        if (l != paramLong.longValue()) {
          break label106;
        }
        j = 1;
        break label109;
        label145:
        i += 1;
        break;
        i = -1;
        break label114;
        label157:
        if (paramInteger.intValue() == 3) {
          if (i != -1)
          {
            paramLong = ((BaseFinderFeed)getDataList().get(i)).feedObject;
            if (paramInteger != null) {
              break label245;
            }
            label189:
            j = 3;
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      paramLong.setMentionListSelected(j);
      dispatcher().onItemRangeChanged(i, 1, new kotlin.r(Integer.valueOf(23), Boolean.valueOf(bool)));
      do
      {
        AppMethodBeat.o(331872);
        return;
      } while (paramInteger.intValue() != 4);
      break;
      label245:
      if (paramInteger.intValue() != 3) {
        break label189;
      }
      j = 2;
    }
  }
  
  public final void aF(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(331918);
    if ((paramInt >= 0) && (paramInt < getDataList().size()))
    {
      Log.i(getTAG(), "notifyFeedTip position:" + paramInt + " isShow:" + paramBoolean);
      dispatcher().onItemRangeChanged(paramInt, 1, new kotlin.r(Integer.valueOf(23), Boolean.valueOf(paramBoolean)));
    }
    AppMethodBeat.o(331918);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(331840);
    i locali = (i)new a();
    AppMethodBeat.o(331840);
    return locali;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.d<cc> createDataMerger()
  {
    AppMethodBeat.i(331845);
    com.tencent.mm.plugin.finder.feed.model.internal.d locald = (com.tencent.mm.plugin.finder.feed.model.internal.d)new b();
    AppMethodBeat.o(331845);
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
    AppMethodBeat.i(331884);
    super.onAlive();
    this.EwG.alive();
    AppMethodBeat.o(331884);
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(331889);
    super.onDead();
    this.EwG.dead();
    AppMethodBeat.o(331889);
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(331906);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    Object localObject;
    if (getDataListJustForAdapter().size() > 0) {
      localObject = c.EwN;
    }
    for (;;)
    {
      this.EwE = ((c)localObject);
      if (!isInitOperation(paramIResponse)) {
        break;
      }
      AppMethodBeat.o(331906);
      return;
      if (((paramIResponse instanceof e)) && (((e)paramIResponse).lNX > 0)) {
        localObject = c.EwO;
      } else {
        localObject = c.EwM;
      }
    }
    if (isRefreshOperation(paramIResponse))
    {
      localObject = this.BfX;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(paramIResponse);
      }
    }
    if (!paramIResponse.getHasMore())
    {
      paramIResponse = this.BbB;
      if (paramIResponse != null) {
        paramIResponse.invoke();
      }
    }
    AppMethodBeat.o(331906);
  }
  
  public final void onFetchInitDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(331895);
    kotlin.g.b.s.u(paramIResponse, "initResponse");
    super.onFetchInitDone(paramIResponse);
    AppMethodBeat.o(331895);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(331836);
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(331836);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$AtDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "isAuto", "", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public a()
    {
      AppMethodBeat.i(331638);
      AppMethodBeat.o(331638);
    }
    
    public final IResponse<cc> callInit()
    {
      AppMethodBeat.i(331678);
      Object localObject1 = this.EwH.getCache();
      Object localObject3;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label355;
        }
        localObject3 = this.EwH;
        localObject2 = (a)this;
        localObject1 = ((FinderAtFeedLoader)localObject3).EwC;
        switch (a.$EnumSwitchMapping$0[localObject1.ordinal()])
        {
        case 2: 
        case 4: 
        default: 
          localObject1 = new FinderAtFeedLoader.e(0, 0, "");
          localObject3 = k.FNg.bE(14, ((FinderAtFeedLoader)localObject3).finderUsername);
          Log.i(((a)localObject2).getTAG(), kotlin.g.b.s.X("[callInit] page list=", Integer.valueOf(((List)localObject3).size())));
          ((FinderAtFeedLoader.e)localObject1).setIncrementList((List)localObject3);
          ((FinderAtFeedLoader.e)localObject1).setLastBuffer(null);
          ((FinderAtFeedLoader.e)localObject1).setHasMore(true);
        }
      }
      for (;;)
      {
        localObject1 = (IResponse)localObject1;
        AppMethodBeat.o(331678);
        return localObject1;
        if (((com.tencent.mm.plugin.finder.feed.model.s)localObject1).pUj == null)
        {
          localObject1 = null;
          break;
        }
        localObject3 = this.EwH;
        localObject2 = new FinderAtFeedLoader.e(0, 0, "");
        localObject1 = ((FinderAtFeedLoader)localObject3).getCache();
        if (localObject1 == null)
        {
          localObject1 = null;
          label193:
          ((FinderAtFeedLoader.e)localObject2).setIncrementList((List)localObject1);
          localObject1 = ((FinderAtFeedLoader)localObject3).getCache();
          if (localObject1 != null) {
            break label235;
          }
        }
        label235:
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject1).lastBuffer)
        {
          ((FinderAtFeedLoader.e)localObject2).setLastBuffer((com.tencent.mm.bx.b)localObject1);
          ((FinderAtFeedLoader.e)localObject2).setHasMore(true);
          localObject1 = localObject2;
          break;
          localObject1 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject1).pUj;
          break label193;
        }
        localObject1 = new FinderAtFeedLoader.e(0, 0, "");
        Log.i(((a)localObject2).getTAG(), "[callInit] init list=0");
        ((FinderAtFeedLoader.e)localObject1).setIncrementList((List)new LinkedList());
        ((FinderAtFeedLoader.e)localObject1).setLastBuffer(null);
        ((FinderAtFeedLoader.e)localObject1).setHasMore(true);
        continue;
        localObject1 = new FinderAtFeedLoader.e(0, 0, "");
        localObject3 = k.FNg.bE(18, ((FinderAtFeedLoader)localObject3).finderUsername);
        Log.i(((a)localObject2).getTAG(), kotlin.g.b.s.X("[callInit] page list=", Integer.valueOf(((List)localObject3).size())));
        ((FinderAtFeedLoader.e)localObject1).setIncrementList((List)localObject3);
        ((FinderAtFeedLoader.e)localObject1).setLastBuffer(null);
        ((FinderAtFeedLoader.e)localObject1).setHasMore(true);
      }
      label355:
      localObject1 = (IResponse)localObject1;
      AppMethodBeat.o(331678);
      return localObject1;
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(331694);
      kotlin.g.b.s.u(paramp, "scene");
      Object localObject2 = this.EwH;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (Object localObject1 = FinderAtFeedLoader.f.EwS;; localObject1 = FinderAtFeedLoader.f.EwT)
      {
        ((FinderAtFeedLoader)localObject2).a((FinderAtFeedLoader.f)localObject1);
        localObject1 = (cq)paramp;
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label246;
        }
        localObject2 = c.c.b(((cq)localObject1).rr.otC);
        if (localObject2 != null) {
          break;
        }
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
        AppMethodBeat.o(331694);
        throw paramString;
      }
      if (((bah)localObject2).BeA == 0) {}
      label246:
      for (boolean bool = false;; bool = true)
      {
        localObject2 = new FinderAtFeedLoader.e(paramInt1, paramInt2, paramString);
        localObject3 = (Iterable)((cq)paramp).dWd();
        paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FinderObject)((Iterator)localObject3).next();
          Object localObject5 = FinderItem.Companion;
          localObject4 = FinderItem.a.e((FinderObject)localObject4, 8192);
          localObject5 = FinderAtTimelineUI.BlG;
          ((Map)FinderAtTimelineUI.eeA()).put(Long.valueOf(((FinderItem)localObject4).getId()), localObject4);
          localObject5 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          paramString.add(d.a.a((FinderItem)localObject4));
        }
      }
      ((FinderAtFeedLoader.e)localObject2).setIncrementList((List)paramString);
      if ((this.EwH.EwC == g.Bkt) && (((cq)localObject1).pullType == 2)) {
        this.EwH.EwF = ((FinderAtFeedLoader.e)localObject2).getIncrementList();
      }
      Object localObject3 = getTAG();
      Object localObject4 = new StringBuilder("pullType=").append(((cq)localObject1).pullType).append(" username=").append(this.EwH.finderUsername).append(" incrementList size: ");
      paramString = ((FinderAtFeedLoader.e)localObject2).getIncrementList();
      if (paramString == null) {}
      for (paramString = null;; paramString = Integer.valueOf(paramString.size()))
      {
        Log.i((String)localObject3, paramString + " totalCount: " + ((cq)paramp).dWe());
        ((FinderAtFeedLoader.e)localObject2).setPullType(((cq)localObject1).pullType);
        paramString = c.c.b(((cq)localObject1).rr.otC);
        if (paramString != null) {
          break;
        }
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
        AppMethodBeat.o(331694);
        throw paramString;
      }
      ((FinderAtFeedLoader.e)localObject2).setLastBuffer(((bah)paramString).ZEQ);
      ((FinderAtFeedLoader.e)localObject2).setHasMore(bool);
      ((FinderAtFeedLoader.e)localObject2).lNX = ((cq)paramp).dWe();
      this.EwH.mentionCount = ((FinderAtFeedLoader.e)localObject2).lNX;
      if (((cq)localObject1).pullType == 1)
      {
        paramString = ((FinderAtFeedLoader.e)localObject2).getIncrementList();
        if (paramString != null) {
          com.tencent.mm.ae.d.B((a)new b(this.EwH, paramString, this));
        }
      }
      paramString = (IResponse)localObject2;
      AppMethodBeat.o(331694);
      return paramString;
    }
    
    public final void fetch(Object paramObject, h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(331653);
      kotlin.g.b.s.u(paramh, "callback");
      super.fetch(paramObject, paramh, paramBoolean);
      this.EwH.a(FinderAtFeedLoader.f.EwR);
      AppMethodBeat.o(331653);
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(331668);
      Object localObject = this.EwH.EwC;
      switch (a.$EnumSwitchMapping$0[localObject.ordinal()])
      {
      case 3: 
      default: 
        localObject = new cq(this.EwH.finderUsername, this.EwH.getLastBuffer());
        ((cq)localObject).pullType = 2;
        localObject = (com.tencent.mm.am.p)localObject;
        AppMethodBeat.o(331668);
        return localObject;
      case 1: 
      case 2: 
        localObject = new cq(this.EwH.finderUsername, this.EwH.getLastBuffer(), 2);
        ((cq)localObject).pullType = 2;
        localObject = (com.tencent.mm.am.p)localObject;
        AppMethodBeat.o(331668);
        return localObject;
      case 4: 
        if ((this.EwH.fromScene == g.Bkr.value) || (this.EwH.fromScene == g.Bkj.value)) {
          localObject = new cq(this.EwH.finderUsername, this.EwH.getLastBuffer(), 2);
        }
        for (((cq)localObject).pullType = 2;; ((cq)localObject).pullType = 2)
        {
          localObject = (com.tencent.mm.am.p)localObject;
          AppMethodBeat.o(331668);
          return localObject;
          localObject = new cq(this.EwH.finderUsername, this.EwH.getLastBuffer(), 1);
        }
      }
      localObject = new cq(this.EwH.finderUsername, this.EwH.getLastBuffer(), 1);
      ((cq)localObject).pullType = 2;
      localObject = (com.tencent.mm.am.p)localObject;
      AppMethodBeat.o(331668);
      return localObject;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      Object localObject2 = null;
      AppMethodBeat.i(331662);
      Object localObject1 = this.EwH.EwC;
      switch (a.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        localObject1 = new cq(this.EwH.finderUsername, this.EwH.getLastBuffer());
        ((cq)localObject1).pullType = 1;
        localObject1 = (com.tencent.mm.am.p)localObject1;
        AppMethodBeat.o(331662);
        return localObject1;
      case 1: 
      case 2: 
      case 3: 
        String str = this.EwH.finderUsername;
        localObject1 = localObject2;
        if (this.EwH.EwC != g.Bkr) {
          if (this.EwH.EwC != g.Bks) {
            break label167;
          }
        }
        for (localObject1 = localObject2;; localObject1 = this.EwH.getLastBuffer())
        {
          localObject1 = new cq(str, (com.tencent.mm.bx.b)localObject1, 2);
          ((cq)localObject1).pullType = 1;
          localObject1 = (com.tencent.mm.am.p)localObject1;
          AppMethodBeat.o(331662);
          return localObject1;
        }
      case 4: 
        label167:
        if ((this.EwH.fromScene == g.Bkr.value) || (this.EwH.fromScene == g.Bkj.value)) {
          localObject1 = new cq(this.EwH.finderUsername, this.EwH.getLastBuffer(), 2);
        }
        for (((cq)localObject1).pullType = 1;; ((cq)localObject1).pullType = 1)
        {
          localObject1 = (com.tencent.mm.am.p)localObject1;
          AppMethodBeat.o(331662);
          return localObject1;
          localObject1 = new cq(this.EwH.finderUsername, this.EwH.getLastBuffer(), 1);
        }
      }
      localObject1 = new cq(this.EwH.finderUsername, null, 1);
      ((cq)localObject1).pullType = 1;
      localObject1 = (com.tencent.mm.am.p)localObject1;
      AppMethodBeat.o(331662);
      return localObject1;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(331644);
      List localList = kotlin.a.p.listOf(Integer.valueOf(3810));
      AppMethodBeat.o(331644);
      return localList;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements a<ah>
    {
      b(FinderAtFeedLoader paramFinderAtFeedLoader, List<? extends cc> paramList, FinderAtFeedLoader.a parama)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$AtDataMerge;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;)V", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends BaseFeedLoader<cc>.a
  {
    public b()
    {
      super(false, 1, null);
      AppMethodBeat.i(331628);
      AppMethodBeat.o(331628);
    }
    
    public final void mergeRefresh(final IResponse<cc> paramIResponse, final kotlin.g.a.b<? super IResponse<cc>, ah> paramb)
    {
      AppMethodBeat.i(331642);
      kotlin.g.b.s.u(paramIResponse, "response");
      Object localObject = this.EwH.EwC;
      if (a.$EnumSwitchMapping$0[localObject.ordinal()] == 1)
      {
        localObject = RefreshLoadMoreLayout.d.agJr;
        localObject = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMG());
        com.tencent.mm.ae.d.uiThread((a)new b(this, new com.tencent.mm.plugin.finder.feed.model.internal.r(7, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.d)localObject, paramb, paramIResponse, this.EwH));
        AppMethodBeat.o(331642);
        return;
      }
      super.mergeRefresh(paramIResponse, paramb);
      AppMethodBeat.o(331642);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements a<ah>
    {
      b(FinderAtFeedLoader.b paramb, com.tencent.mm.plugin.finder.feed.model.internal.r<cc> paramr, RefreshLoadMoreLayout.d<Object> paramd, kotlin.g.a.b<? super IResponse<cc>, ah> paramb1, IResponse<cc> paramIResponse, FinderAtFeedLoader paramFinderAtFeedLoader)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$CacheState;", "", "(Ljava/lang/String;I)V", "INIT", "NO_CACHE", "WITH_CACHED", "WITH_INVISIBLE_CACHE", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    static
    {
      AppMethodBeat.i(331649);
      EwL = new c("INIT", 0);
      EwM = new c("NO_CACHE", 1);
      EwN = new c("WITH_CACHED", 2);
      EwO = new c("WITH_INVISIBLE_CACHE", 3);
      EwP = new c[] { EwL, EwM, EwN, EwO };
      AppMethodBeat.o(331649);
    }
    
    private c() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$Companion;", "", "()V", "MMFinderMentionedListOption_ALL", "", "MMFinderMentionedListOption_NOT_SELECTED", "MMFinderMentionedListOption_SELECTED", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$FinderAtTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "totalCount", "getTotalCount", "()I", "setTotalCount", "(I)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends IResponse<cc>
  {
    public int lNX;
    
    public e(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader$State;", "", "(Ljava/lang/String;I)V", "INIT", "LOADING", "LOADED", "FAILURE", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum f
  {
    static
    {
      AppMethodBeat.i(331646);
      EwQ = new f("INIT", 0);
      EwR = new f("LOADING", 1);
      EwS = new f("LOADED", 2);
      EwT = new f("FAILURE", 3);
      EwU = new f[] { EwQ, EwR, EwS, EwT };
      AppMethodBeat.o(331646);
    }
    
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader
 * JD-Core Version:    0.7.0.1
 */