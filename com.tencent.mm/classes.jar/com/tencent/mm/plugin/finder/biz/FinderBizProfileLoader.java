package com.tencent.mm.plugin.finder.biz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.as;
import com.tencent.mm.plugin.finder.cgi.dt;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.g.a.m;
import kotlin.g.b.ah.d;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/biz/FinderBizProfileLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "bizUsername", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isTimeline", "", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "allowPrefetch", "", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "hasShowjustWatchedIndex", "isLoadingJustWatched", "setLoadingJustWatched", "isLoadingMore", "setLoadingMore", "justWatchedCallback", "maxId", "", "readId", "getReadId", "()J", "setReadId", "(J)V", "showJustWatch", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "getIncrementList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLastItem", "getPageName", "position", "jumpToJustWatchedReq", "justWatchedDoCgi", "markRead", "response", "onFetchDone", "onFetchLoadMoreDone", "requestLoadMore", "isAuto", "showJustWatchIsTrue", "BizDataFetcher", "BizProfileResponse", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderBizProfileLoader
  extends BaseFinderFeedLoader
{
  final boolean AxW;
  long AxX;
  boolean AxY;
  kotlin.g.a.b<? super Integer, ah> AxZ;
  boolean Aya;
  private int allowPrefetch;
  public kotlin.g.a.b<? super IResponse<cc>, ah> fetchEndCallback;
  private final String hUQ;
  private boolean hasMore;
  private boolean isLoadingMore;
  int showJustWatch;
  
  public FinderBizProfileLoader(String paramString, bui parambui, boolean paramBoolean)
  {
    super(parambui);
    AppMethodBeat.i(330441);
    this.hUQ = paramString;
    this.AxW = paramBoolean;
    AppMethodBeat.o(330441);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(330476);
    i locali = (i)new a();
    AppMethodBeat.o(330476);
    return locali;
  }
  
  final void dVc()
  {
    AppMethodBeat.i(330514);
    if (!this.AxY)
    {
      this.AxY = true;
      final ah.d locald = new ah.d();
      locald.aixb = 4;
      j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCh(), null, (m)new c(this, locald, null), 2);
    }
    AppMethodBeat.o(330514);
  }
  
  public final long getLastItem()
  {
    AppMethodBeat.i(330507);
    int i = getDataList().size() - 1;
    if (i >= 0) {}
    for (;;)
    {
      int j = i - 1;
      cc localcc = (cc)getDataList().get(i);
      if (((localcc instanceof BaseFinderFeed)) && (((BaseFinderFeed)localcc).feedObject.getId() != 0L))
      {
        long l = ((BaseFinderFeed)localcc).feedObject.getId();
        AppMethodBeat.o(330507);
        return l;
      }
      if (j < 0)
      {
        AppMethodBeat.o(330507);
        return 0L;
      }
      i = j;
    }
  }
  
  public final int getPageName()
  {
    return 21;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(330493);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    kotlin.g.b.s.u(paramIResponse, "response");
    long l = this.AxX;
    Object localObject1;
    if (l != 0L)
    {
      localObject1 = paramIResponse.getIncrementList();
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          if (i < 0) {
            kotlin.a.p.kkW();
          }
          localObject2 = (cc)localObject2;
          if (((localObject2 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject2).feedObject.getId() == l))
          {
            if ((isRefreshOperation(paramIResponse)) && (i <= 7)) {
              this.showJustWatch = 0;
            }
            ((BaseFinderFeed)localObject2).markRead = true;
            dispatcher().onChanged();
          }
          i += 1;
        }
      }
    }
    if (isInitOperation(paramIResponse))
    {
      if (this.allowPrefetch == 1) {
        dVc();
      }
      AppMethodBeat.o(330493);
      return;
    }
    if (2 == paramIResponse.getPullType()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.isLoadingMore = false;
      }
      this.hasMore = paramIResponse.getHasMore();
      localObject1 = this.fetchEndCallback;
      if (localObject1 != null) {
        ((kotlin.g.a.b)localObject1).invoke(paramIResponse);
      }
      AppMethodBeat.o(330493);
      return;
    }
  }
  
  public final void onFetchLoadMoreDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(330503);
    kotlin.g.b.s.u(paramIResponse, "response");
    super.onFetchLoadMoreDone(paramIResponse);
    if (this.AxY)
    {
      paramIResponse = ((Iterable)getDataList()).iterator();
      int i = 0;
      while (paramIResponse.hasNext())
      {
        Object localObject = paramIResponse.next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        localObject = (cc)localObject;
        if (((localObject instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject).feedObject.getId() == this.AxX))
        {
          ((BaseFinderFeed)localObject).markRead = true;
          dispatcher().Oc(i);
          this.AxY = false;
          paramIResponse = this.AxZ;
          if (paramIResponse != null) {
            paramIResponse.invoke(Integer.valueOf(i));
          }
          AppMethodBeat.o(330503);
          return;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(330503);
  }
  
  public final void requestLoadMore(boolean paramBoolean)
  {
    AppMethodBeat.i(330482);
    if ((this.AxY) && (this.isLoadingMore))
    {
      AppMethodBeat.o(330482);
      return;
    }
    this.isLoadingMore = true;
    super.requestLoadMore(paramBoolean);
    AppMethodBeat.o(330482);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/biz/FinderBizProfileLoader$BizDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/biz/FinderBizProfileLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "genLoadMoreNetScene", "genRefreshNetScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "getCmdIds", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends c
  {
    public a()
    {
      AppMethodBeat.i(330461);
      AppMethodBeat.o(330461);
    }
    
    public final IResponse<cc> callInit()
    {
      Object localObject2 = null;
      AppMethodBeat.i(330502);
      Log.i(getTAG(), "fetchInit initCount ");
      FinderBizProfileLoader.b localb = new FinderBizProfileLoader.b(0, 0, "");
      Object localObject1;
      if (this.Ayb.AxW)
      {
        localObject1 = this.Ayb.getCache();
        if (localObject1 == null)
        {
          localObject1 = null;
          localb.setIncrementList((List)localObject1);
          localObject1 = this.Ayb.getCache();
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
        AppMethodBeat.o(330502);
        return localObject1;
        localObject1 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject1).pUj;
        break;
        label99:
        localObject1 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject1).lastBuffer;
        break label74;
        localb.setIncrementList(com.tencent.mm.plugin.finder.storage.data.k.FNg.bE(this.Ayb.getPageName(), FinderBizProfileLoader.a(this.Ayb)));
      }
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      Object localObject = null;
      AppMethodBeat.i(330517);
      kotlin.g.b.s.u(paramp, "scene");
      if ((paramp instanceof dt))
      {
        boolean bool;
        FinderBizProfileLoader.b localb;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          bool = ((dt)paramp).ABD;
          localb = new FinderBizProfileLoader.b(paramInt1, paramInt2, paramString);
          paramString = ((dt)paramp).ACl;
          if (paramString != null) {
            break label169;
          }
        }
        for (paramString = (String)localObject;; paramString = (List)paramString)
        {
          localb.setIncrementList(paramString);
          localb.setPullType(((dt)paramp).pullType);
          localb.setHasMore(bool);
          localb.setLastBuffer(((dt)paramp).getLastBuffer());
          if (((dt)paramp).pullType == 1)
          {
            FinderBizProfileLoader.a(this.Ayb, ((dt)paramp).allowPrefetch);
            FinderBizProfileLoader.b(this.Ayb, ((dt)paramp).showJustWatch);
          }
          paramString = (IResponse)localb;
          AppMethodBeat.o(330517);
          return paramString;
          bool = true;
          break;
          label169:
          localObject = (Iterable)paramString;
          paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
            d.a locala = com.tencent.mm.plugin.finder.storage.logic.d.FND;
            paramString.add(d.a.a(localFinderItem));
          }
        }
      }
      AppMethodBeat.o(330517);
      return null;
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(330485);
      com.tencent.mm.am.p localp = (com.tencent.mm.am.p)new dt("", this.Ayb.getLastItem(), this.Ayb.getLastBuffer(), 2, this.Ayb.getContextObj(), 0, 0L, false, FinderBizProfileLoader.a(this.Ayb), this.Ayb.AxX, null, null, null, 7392);
      AppMethodBeat.o(330485);
      return localp;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(330473);
      List localList = kotlin.a.p.listOf(Integer.valueOf(3736));
      AppMethodBeat.o(330473);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/biz/FinderBizProfileLoader$BizProfileResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends IResponse<cc>
  {
    public b(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(FinderBizProfileLoader paramFinderBizProfileLoader, ah.d paramd, kotlin.d.d<? super c> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(330492);
      paramObject = (kotlin.d.d)new c(this.Ayb, locald, paramd);
      AppMethodBeat.o(330492);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(330481);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(330481);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      int i;
      Object localObject1;
      Object localObject4;
      Object localObject5;
      try
      {
        while (this.Ayb.AxY)
        {
          i = locald.aixb;
          locald.aixb = (i - 1);
          if (i != 0)
          {
            paramObject = (com.tencent.mm.am.b)new as("", this.Ayb.getLastItem(), this.Ayb.getLastBuffer(), 2, this.Ayb.getContextObj(), 0L, FinderBizProfileLoader.a(this.Ayb), this.Ayb.AxX);
            localObject1 = (kotlin.d.d)this;
            this.label = 1;
            paramObject = com.tencent.mm.af.b.a(paramObject, (kotlin.d.d)localObject1);
            localObject1 = paramObject;
            if (paramObject == locala)
            {
              AppMethodBeat.o(330481);
              return locala;
              ResultKt.throwOnFailure(paramObject);
              localObject1 = paramObject;
            }
            paramObject = (FinderUserPageResponse)localObject1;
            if (paramObject != null)
            {
              localObject1 = this.Ayb;
              localObject2 = paramObject.object;
              kotlin.g.b.s.checkNotNull(localObject2);
              kotlin.g.b.s.u(localObject2, "list");
              localObject3 = (Iterable)localObject2;
              localObject2 = (Collection)new ArrayList();
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = ((Iterator)localObject3).next();
                localObject5 = (FinderObject)localObject4;
                av localav = av.GiL;
                if (av.y((FinderObject)localObject5)) {
                  ((Collection)localObject2).add(localObject4);
                }
              }
            }
          }
        }
        localObject2 = (List)localObject2;
      }
      catch (Exception paramObject)
      {
        paramObject = FinderBizProfileLoader.b(this.Ayb);
        if (paramObject != null) {
          paramObject.invoke(Integer.valueOf(-2));
        }
        this.Ayb.AxY = false;
        paramObject = ah.aiuX;
        AppMethodBeat.o(330481);
        return paramObject;
      }
      Object localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      localObject3 = (Iterable)d.a.a((List)localObject2, 2, ((FinderBizProfileLoader)localObject1).getContextObj());
      Object localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (FinderItem)((Iterator)localObject3).next();
        localObject5 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        ((Collection)localObject2).add(d.a.a((FinderItem)localObject4));
      }
      localObject2 = (List)localObject2;
      if (paramObject.continueFlag == 1)
      {
        i = 1;
        label455:
        localObject3 = new FinderBizProfileLoader.b(0, 0, "");
        ((FinderBizProfileLoader.b)localObject3).setIncrementList((List)localObject2);
        ((FinderBizProfileLoader.b)localObject3).setLastBuffer(paramObject.lastBuffer);
        ((FinderBizProfileLoader.b)localObject3).setPullType(2);
        if (i == 0) {
          break label520;
        }
      }
      label520:
      for (boolean bool = true;; bool = false)
      {
        ((FinderBizProfileLoader.b)localObject3).setHasMore(bool);
        ((FinderBizProfileLoader)localObject1).onFetchDone((IResponse)localObject3);
        break;
        i = 0;
        break label455;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.biz.FinderBizProfileLoader
 * JD-Core Version:    0.7.0.1
 */