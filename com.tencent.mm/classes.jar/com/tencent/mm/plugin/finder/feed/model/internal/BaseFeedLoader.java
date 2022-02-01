package com.tencent.mm.plugin.finder.feed.model.internal;

import android.content.Intent;
import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.c;
import com.tencent.mm.plugin.finder.feed.model.u.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "backCache", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "getBackCache", "()Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "cache", "getCache", "value", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "getDataFetch", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "dataFetch$delegate", "Lkotlin/Lazy;", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "getInitDone", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "setInitDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "initPos", "", "getInitPos", "()I", "Lcom/tencent/mm/protobuf/ByteString;", "lastBuffer", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "preload", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IPreload;", "store", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore;", "getStore", "()Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore;", "checkIsNeedUiThread", "", "isNeed", "", "block", "Lkotlin/Function0;", "createDataFetch", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "initBackCache", "intent", "Landroid/content/Intent;", "initFromCache", "isInitOperation", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "isInsertOperation", "isInsertSpecifyOperation", "isRefreshOperation", "onAlive", "onDead", "onFetchDone", "onFetchInitDone", "initResponse", "onFetchInsertedDone", "onFetchLoadMoreDone", "onFetchRefreshDone", "onSaveLastBuffer", "request", "", "callback", "requestInit", "isSyncLoad", "requestInsert", "requestLoadMore", "isAuto", "requestPreload", "requestRefresh", "saveCache", "position", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "saveCacheToIntent", "feedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "setPreload", "preloader", "DefaultDataMerger", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseFeedLoader<T extends k>
  extends Dispatcher<T>
  implements h<T>
{
  private final kotlin.j dataFetch$delegate;
  private j initDone;
  private l<T> preload;
  private final com.tencent.mm.plugin.finder.feed.model.u store = new com.tencent.mm.plugin.finder.feed.model.u();
  
  public BaseFeedLoader()
  {
    this(null, 1, null);
  }
  
  public BaseFeedLoader(bui parambui)
  {
    this.store.Auc = parambui;
    this.dataFetch$delegate = kotlin.k.cm((kotlin.g.a.a)new b(this));
  }
  
  private final i<T> getDataFetch()
  {
    return (i)this.dataFetch$delegate.getValue();
  }
  
  public final void checkIsNeedUiThread(boolean paramBoolean, kotlin.g.a.a<ah> parama)
  {
    kotlin.g.b.s.u(parama, "block");
    if (paramBoolean)
    {
      com.tencent.mm.ae.d.uiThread(parama);
      return;
    }
    parama.invoke();
  }
  
  public abstract i<T> createDataFetch();
  
  public d<T> createDataMerger()
  {
    return (d)new a(false, 1, null);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.s getBackCache()
  {
    return this.store.BjK;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.s getCache()
  {
    return this.store.BjJ;
  }
  
  public final bui getContextObj()
  {
    return this.store.Auc;
  }
  
  public final j getInitDone()
  {
    return this.initDone;
  }
  
  public final int getInitPos()
  {
    com.tencent.mm.plugin.finder.feed.model.s locals = this.store.BjJ;
    if (locals == null) {}
    for (int i = 0;; i = locals.position) {
      return Math.max(i, 0);
    }
  }
  
  public final com.tencent.mm.bx.b getLastBuffer()
  {
    return this.store.lastBuffer;
  }
  
  protected final com.tencent.mm.plugin.finder.feed.model.u getStore()
  {
    return this.store;
  }
  
  public final void initBackCache(Intent paramIntent)
  {
    kotlin.g.b.s.u(paramIntent, "intent");
    com.tencent.mm.plugin.finder.feed.model.u localu = this.store;
    kotlin.g.b.s.u(paramIntent, "intent");
    u.a locala = com.tencent.mm.plugin.finder.feed.model.u.BjI;
    localu.BjK = u.a.as(paramIntent);
  }
  
  public final void initFromCache(Intent paramIntent)
  {
    kotlin.g.b.s.u(paramIntent, "intent");
    com.tencent.mm.plugin.finder.feed.model.u.a(this.store, paramIntent);
  }
  
  public final boolean isInitOperation(IResponse<T> paramIResponse)
  {
    kotlin.g.b.s.u(paramIResponse, "response");
    return 1000 == paramIResponse.getPullType();
  }
  
  public final boolean isInsertOperation(IResponse<T> paramIResponse)
  {
    kotlin.g.b.s.u(paramIResponse, "response");
    return -1 == paramIResponse.getPullType();
  }
  
  public final boolean isInsertSpecifyOperation(IResponse<T> paramIResponse)
  {
    kotlin.g.b.s.u(paramIResponse, "response");
    return 16 == paramIResponse.getPullType();
  }
  
  public final boolean isRefreshOperation(IResponse<T> paramIResponse)
  {
    kotlin.g.b.s.u(paramIResponse, "response");
    return (1 == paramIResponse.getPullType()) || (paramIResponse.getPullType() == 0) || (4 == paramIResponse.getPullType()) || (3 == paramIResponse.getPullType()) || (10 == paramIResponse.getPullType()) || (11 == paramIResponse.getPullType()) || (12 == paramIResponse.getPullType()) || (14 == paramIResponse.getPullType()) || (15 == paramIResponse.getPullType()) || (18 == paramIResponse.getPullType());
  }
  
  public void onAlive()
  {
    Log.i(getTAG(), "onAlive");
    getDataFetch().alive();
  }
  
  public void onDead()
  {
    Log.i(getTAG(), "onDead");
    getDataFetch().dead();
  }
  
  public void onFetchDone(final IResponse<T> paramIResponse)
  {
    kotlin.g.b.s.u(paramIResponse, "response");
    if (isInitOperation(paramIResponse)) {
      getMerger().mergeInit(paramIResponse, (kotlin.g.a.b)new c(this));
    }
    for (;;)
    {
      onSaveLastBuffer(paramIResponse);
      return;
      if (isRefreshOperation(paramIResponse)) {
        getMerger().mergeRefresh(paramIResponse, (kotlin.g.a.b)new d(this, paramIResponse));
      } else if (isInsertOperation(paramIResponse)) {
        getMerger().mergeInsert(paramIResponse, (kotlin.g.a.b)new e(this, paramIResponse));
      } else if (!isInsertSpecifyOperation(paramIResponse)) {
        getMerger().mergeLoadMore(paramIResponse, (kotlin.g.a.b)new f(this, paramIResponse));
      }
    }
  }
  
  protected void onFetchInitDone(IResponse<T> paramIResponse)
  {
    kotlin.g.b.s.u(paramIResponse, "initResponse");
    j localj = this.initDone;
    if (localj != null)
    {
      paramIResponse = paramIResponse.getIncrementList();
      if (paramIResponse != null) {
        break label40;
      }
    }
    label40:
    for (int i = 0;; i = paramIResponse.size())
    {
      localj.call(i);
      this.initDone = null;
      return;
    }
  }
  
  protected void onFetchInsertedDone(IResponse<T> paramIResponse)
  {
    kotlin.g.b.s.u(paramIResponse, "response");
  }
  
  protected void onFetchLoadMoreDone(IResponse<T> paramIResponse)
  {
    kotlin.g.b.s.u(paramIResponse, "response");
  }
  
  protected void onFetchRefreshDone(IResponse<T> paramIResponse)
  {
    kotlin.g.b.s.u(paramIResponse, "response");
  }
  
  public void onSaveLastBuffer(IResponse<T> paramIResponse)
  {
    kotlin.g.b.s.u(paramIResponse, "response");
    setLastBuffer(paramIResponse.getLastBuffer());
  }
  
  public final void request(final Object paramObject, final h<T> paramh)
  {
    Log.i(getTAG(), "request");
    if (paramh == null)
    {
      paramh = this.preload;
      if (paramh == null)
      {
        paramh = null;
        if (paramh == null)
        {
          paramh = (BaseFeedLoader)this;
          i.fetch$default(paramh.getDataFetch(), paramObject, (h)paramh, false, 4, null);
        }
      }
    }
    for (;;)
    {
      return;
      paramh.al((kotlin.g.a.b)new g(this, paramObject));
      paramh = ah.aiuX;
      break;
      Object localObject = this.preload;
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = ah.aiuX)
      {
        i.fetch$default(((BaseFeedLoader)this).getDataFetch(), paramObject, paramh, false, 4, null);
        return;
        ((l)localObject).al((kotlin.g.a.b)new h(this, paramObject, paramh));
      }
    }
  }
  
  public final void requestInit(boolean paramBoolean)
  {
    Log.i(getTAG(), kotlin.g.b.s.X("initData from ", Util.getStack()));
    if (paramBoolean)
    {
      getDataFetch().fetchInit((h)this);
      return;
    }
    kotlin.c.a.cn((kotlin.g.a.a)new i(this));
  }
  
  public void requestInsert(Object paramObject)
  {
    kotlin.g.b.s.u(paramObject, "request");
    Log.i(getTAG(), kotlin.g.b.s.X("requestInsert ", paramObject));
    request$default(this, paramObject, null, 2, null);
  }
  
  public void requestLoadMore(final boolean paramBoolean)
  {
    Log.i(getTAG(), "requestLoadMore");
    Object localObject = this.preload;
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null)
      {
        localObject = (BaseFeedLoader)this;
        ((BaseFeedLoader)localObject).getDataFetch().fetchLoadMore((h)localObject, paramBoolean);
      }
      return;
      ((l)localObject).al((kotlin.g.a.b)new j(this, paramBoolean));
    }
  }
  
  public final void requestPreload()
  {
    requestPreload((h)this);
  }
  
  public void requestPreload(final h<T> paramh)
  {
    l locall = this.preload;
    if (locall != null) {
      locall.aT((kotlin.g.a.a)new k(this, paramh));
    }
  }
  
  public void requestRefresh()
  {
    Log.i(getTAG(), "requestRefresh");
    Object localObject = this.preload;
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null)
      {
        localObject = (BaseFeedLoader)this;
        ((BaseFeedLoader)localObject).getDataFetch().fetchRefresh((h)localObject);
      }
      return;
      ((l)localObject).al((kotlin.g.a.b)new l(this));
    }
  }
  
  public final void saveCache(Intent paramIntent, int paramInt, c paramc)
  {
    kotlin.g.b.s.u(paramIntent, "intent");
    ArrayList localArrayList = new ArrayList();
    DataBuffer localDataBuffer = getDataList();
    if ((localDataBuffer instanceof DataBuffer)) {}
    for (;;)
    {
      if (localDataBuffer != null) {
        localArrayList.addAll((Collection)localDataBuffer);
      }
      paramc = new com.tencent.mm.plugin.finder.feed.model.s(localArrayList, getLastBuffer(), paramInt, paramc);
      this.store.a(paramc, paramIntent);
      return;
      localDataBuffer = null;
    }
  }
  
  public final void saveCacheToIntent(Intent paramIntent, List<? extends cc> paramList, com.tencent.mm.bx.b paramb, int paramInt, c paramc)
  {
    kotlin.g.b.s.u(paramIntent, "intent");
    kotlin.g.b.s.u(paramList, "feedList");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)paramList);
    paramList = new com.tencent.mm.plugin.finder.feed.model.s(localArrayList, paramb, paramInt, paramc);
    this.store.a(paramList, paramIntent);
  }
  
  public final void setContextObj(bui parambui)
  {
    this.store.Auc = parambui;
  }
  
  public final void setInitDone(j paramj)
  {
    this.initDone = paramj;
  }
  
  public final void setLastBuffer(com.tencent.mm.bx.b paramb)
  {
    this.store.lastBuffer = paramb;
  }
  
  public final void setPreload(l<T> paraml)
  {
    kotlin.g.b.s.u(paraml, "preloader");
    this.preload = paraml;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "runUiThread", "", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;Z)V", "calculateIndex", "", "data", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeInsertData;", "canFinallyHandleMergeList", "cmd", "cleanDataList", "", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "convertOpToReason", "op", "Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp;", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findMergeIndex", "srcList", "Ljava/util/ArrayList;", "newList", "", "request", "getListUpdateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "getOffestIndex", "currentIndex", "merge", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "mergeDataAndNotify", "insList", "isNeedClear", "mergeInit", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeInsert", "mergeInsertData", "startIndex", "mergeInsertSpecifiedLocation", "mergeLoadMore", "mergeRefresh", "onDataReplace", "feed", "existIndex", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;I)Z", "printList", "tag", "", "mmlist", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public class a
    extends d<T>
  {
    private final boolean runUiThread;
    
    public a()
    {
      AppMethodBeat.i(366606);
      boolean bool;
      this.runUiThread = bool;
      AppMethodBeat.o(366606);
    }
    
    private final int getOffestIndex(int paramInt)
    {
      int n = 1;
      int m = 1;
      int i1 = 0;
      AppMethodBeat.i(366616);
      int j;
      int k;
      int i;
      if (paramInt >= 0)
      {
        j = 0;
        k = 0;
        i = k;
        if (!(BaseFeedLoader.this.getDataList().get(j) instanceof x)) {
          i = k + 1;
        }
        if (j != paramInt) {}
      }
      for (;;)
      {
        if (i % 2 == 0) {}
        for (i = i1; paramInt % 2 == 0; i = 1)
        {
          j = m;
          if (i == 0) {
            j = 2;
          }
          AppMethodBeat.o(366616);
          return paramInt + j;
        }
        if (i == 0) {}
        for (i = n;; i = 2)
        {
          AppMethodBeat.o(366616);
          return paramInt + i;
        }
        j += 1;
        k = i;
        break;
        i = 0;
      }
    }
    
    public int calculateIndex(n paramn)
    {
      AppMethodBeat.i(366654);
      kotlin.g.b.s.u(paramn, "data");
      Iterator localIterator = ((List)BaseFeedLoader.this.getDataList()).iterator();
      int i = 0;
      int j;
      if (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        if ((localk instanceof x))
        {
          bip localbip = ((x)localk).feedObject.getLiveInfo();
          if ((localbip != null) && (localbip.liveStatus == 1))
          {
            j = 1;
            label89:
            if ((j == 0) || (((x)localk).feedObject.getFeedObject().id != paramn.hKN)) {
              break label138;
            }
            j = 1;
            label117:
            if (j == 0) {
              break label143;
            }
          }
        }
      }
      for (;;)
      {
        if (i != -1) {
          break label155;
        }
        AppMethodBeat.o(366654);
        return -1;
        j = 0;
        break label89;
        label138:
        j = 0;
        break label117;
        label143:
        i += 1;
        break;
        i = -1;
      }
      label155:
      i = getOffestIndex(i);
      AppMethodBeat.o(366654);
      return i;
    }
    
    public boolean canFinallyHandleMergeList(int paramInt)
    {
      return false;
    }
    
    public void cleanDataList(DataBuffer<T> paramDataBuffer)
    {
      AppMethodBeat.i(366676);
      kotlin.g.b.s.u(paramDataBuffer, "dataList");
      paramDataBuffer.clear();
      AppMethodBeat.o(366676);
    }
    
    public final void convertOpToReason(r<T> paramr, RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(366701);
      kotlin.g.b.s.u(paramr, "op");
      kotlin.g.b.s.u(paramd, "reason");
      paramr = mergeDataAndNotify(paramr.bUl, paramr.BkQ, paramr.isNeedClear, paramr.request);
      paramd.extra = paramr;
      paramd.agJv = paramr.apS;
      AppMethodBeat.o(366701);
    }
    
    public int findMergeIndex(ArrayList<T> paramArrayList, List<? extends T> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(366669);
      kotlin.g.b.s.u(paramArrayList, "srcList");
      kotlin.g.b.s.u(paramList, "newList");
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        case 3: 
        case 5: 
        default: 
          AppMethodBeat.o(366669);
          return 0;
        }
        break;
      }
      paramInt = BaseFeedLoader.this.getDataList().size();
      AppMethodBeat.o(366669);
      return paramInt;
      AppMethodBeat.o(366669);
      return 0;
    }
    
    public q getListUpdateCallback()
    {
      AppMethodBeat.i(366711);
      q localq = (q)new a(BaseFeedLoader.this);
      AppMethodBeat.o(366711);
      return localq;
    }
    
    protected final o merge(List<? extends T> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(366694);
      kotlin.g.b.s.u(paramList, "newList");
      printList("newList", paramInt, paramList);
      DataBuffer localDataBuffer = BaseFeedLoader.this.getDataList();
      LinkedList localLinkedList1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      Object localObject1 = (Iterable)paramList;
      paramList = BaseFeedLoader.this;
      localObject1 = ((Iterable)localObject1).iterator();
      boolean bool1 = false;
      int i;
      while (((Iterator)localObject1).hasNext())
      {
        k localk = (k)((Iterator)localObject1).next();
        Object localObject2 = (List)localDataBuffer;
        i = 0;
        localObject2 = ((List)localObject2).iterator();
        label111:
        int k;
        if (((Iterator)localObject2).hasNext()) {
          if (((k)((Iterator)localObject2).next()).a(localk) == 0)
          {
            j = 1;
            label144:
            if (j == 0) {
              break label239;
            }
            j = i;
            label153:
            localObject2 = (List)localLinkedList1;
            i = 0;
            localObject2 = ((List)localObject2).iterator();
            label172:
            if (!((Iterator)localObject2).hasNext()) {
              break label269;
            }
            if (((k)((Iterator)localObject2).next()).a(localk) != 0) {
              break label254;
            }
            k = 1;
            label205:
            if (k == 0) {
              break label260;
            }
          }
        }
        for (;;)
        {
          if ((j != -1) || (i != -1)) {
            break label275;
          }
          localLinkedList1.add(localk);
          break;
          j = 0;
          break label144;
          label239:
          i += 1;
          break label111;
          j = -1;
          break label153;
          label254:
          k = 0;
          break label205;
          label260:
          i += 1;
          break label172;
          label269:
          i = -1;
        }
        label275:
        if (j != -1)
        {
          localDataBuffer.set(j, localk);
          bool1 = onDataReplace(localk, j);
          localLinkedList2.add(Integer.valueOf(j));
        }
        else
        {
          Log.w(paramList.getTAG(), "newList exist a same feed[" + localLinkedList1.get(i) + "], just ignore this feed=" + localk + " existIndex=" + j + " existIndexInIncrementList=" + i);
        }
      }
      printList("incrementList", paramInt, (List)localLinkedList1);
      int j = 0;
      boolean bool2 = false;
      if ((localLinkedList1.size() > 0) || (canFinallyHandleMergeList(paramInt)))
      {
        i = 1;
        if (i == 0) {
          break label589;
        }
      }
      label589:
      for (paramList = localLinkedList1;; paramList = null)
      {
        i = j;
        if (paramList != null)
        {
          paramList = BaseFeedLoader.this;
          i = findMergeIndex((ArrayList)localDataBuffer, (List)localLinkedList1, paramInt, paramObject);
          bool2 = finallyHandleMergeList((ArrayList)localDataBuffer, localLinkedList1, i, paramInt, paramObject);
          Log.i(paramList.getTAG(), "merge list index " + i + " incrementList:" + localLinkedList1.size() + " cmd=" + paramInt);
          localDataBuffer.addAll(i, (Collection)localLinkedList1);
        }
        paramList = new o(i, localLinkedList1.size(), localLinkedList2, bool2, bool1);
        printList("dataList", paramInt, (List)BaseFeedLoader.this.getDataList());
        AppMethodBeat.o(366694);
        return paramList;
        i = 0;
        break;
      }
    }
    
    public o mergeDataAndNotify(int paramInt, List<? extends T> paramList, boolean paramBoolean, Object paramObject)
    {
      AppMethodBeat.i(366684);
      if (paramList == null)
      {
        paramList = new o(new LinkedList());
        AppMethodBeat.o(366684);
        return paramList;
      }
      if (!paramBoolean)
      {
        Log.i(BaseFeedLoader.this.getTAG(), "nothing need to notify, just return. cmd=" + paramInt + " size =" + paramList.size());
        paramList = new o(new LinkedList());
        AppMethodBeat.o(366684);
        return paramList;
      }
      int j = BaseFeedLoader.this.getDataList().size();
      if (((paramInt == 4) || (paramInt == 3) || (paramInt == 7)) && (needCleanWhenRefresh(paramList)))
      {
        if (((Collection)paramList).isEmpty()) {
          break label411;
        }
        i = 1;
        if ((i != 0) || (paramInt == 7))
        {
          cleanDataList(BaseFeedLoader.this.getDataList());
          if (paramInt == 4) {
            BaseFeedLoader.this.dispatcher().onItemRangeRemoved(0, j);
          }
        }
      }
      paramList = merge(paramList, paramInt, paramObject);
      paramObject = BaseFeedLoader.this.getTAG();
      Object localObject = new StringBuilder("mergeDataAndNotify insertIndex=").append(paramList.BkC).append(" insertCount=").append(paramList.apS).append(" changeIndex=").append(paramList.BkD).append(" size: ").append(BaseFeedLoader.this.getDataList().size()).append(" isRemoveBeforeInsert=").append(paramList.BkE).append(" loader:").append(getClass().getSimpleName()).append(" cmd:");
      r.a locala = r.BkP;
      Log.i(paramObject, r.a.Oe(paramInt) + '}');
      if (!((Collection)paramList.BkD).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (paramList.apS > 0) || (paramInt == 9)) {
          break label423;
        }
        Log.i(BaseFeedLoader.this.getTAG(), kotlin.g.b.s.X("just change all. cmd=", Integer.valueOf(paramInt)));
        BaseFeedLoader.this.dispatcher().onChanged();
        AppMethodBeat.o(366684);
        return paramList;
        label411:
        i = 0;
        break;
      }
      switch (paramInt)
      {
      case 4: 
      case 5: 
      default: 
        label423:
        if (paramList.BkE)
        {
          paramObject = BaseFeedLoader.this.dispatcher();
          i = paramList.BkC;
          paramObject.onItemRangeRemoved(i, j - i);
        }
        if (paramInt == 9)
        {
          paramObject = (Integer)p.oL((List)paramList.BkD);
          if (paramObject != null)
          {
            localObject = BaseFeedLoader.this;
            if (((Number)paramObject).intValue() == 0) {
              ((BaseFeedLoader)localObject).dispatcher().onItemRangeChanged(0, 1, Integer.valueOf(1));
            }
          }
        }
        if (paramList.apS > 0) {
          BaseFeedLoader.this.dispatcher().onItemRangeInserted(paramList.BkC, paramList.apS);
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(366684);
        return paramList;
        BaseFeedLoader.this.dispatcher().onChanged();
      }
    }
    
    public void mergeInit(final IResponse<T> paramIResponse, final kotlin.g.a.b<? super IResponse<T>, ah> paramb)
    {
      AppMethodBeat.i(366623);
      kotlin.g.b.s.u(paramIResponse, "response");
      if (paramIResponse.getIncrementList() == null) {
        paramIResponse.setIncrementList((List)ab.aivy);
      }
      String str = BaseFeedLoader.this.getTAG();
      Object localObject = paramIResponse.getIncrementList();
      if (localObject == null) {}
      for (localObject = null;; localObject = Integer.valueOf(((List)localObject).size()))
      {
        Log.i(str, kotlin.g.b.s.X("initData dataFetch.initData ", localObject));
        BaseFeedLoader.this.checkIsNeedUiThread(this.runUiThread, (kotlin.g.a.a)new b(BaseFeedLoader.this, paramIResponse, paramb));
        AppMethodBeat.o(366623);
        return;
      }
    }
    
    public void mergeInsert(final IResponse<T> paramIResponse, final kotlin.g.a.b<? super IResponse<T>, ah> paramb)
    {
      AppMethodBeat.i(366644);
      kotlin.g.b.s.u(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.d.agJr;
      localObject = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMI());
      ((RefreshLoadMoreLayout.d)localObject).pzq = true;
      ((RefreshLoadMoreLayout.d)localObject).agJu = true;
      final r localr = new r(8, paramIResponse.getIncrementList(), false, 12);
      localr.request = paramIResponse.getRequest();
      BaseFeedLoader.this.checkIsNeedUiThread(this.runUiThread, (kotlin.g.a.a)new c(this, localr, (RefreshLoadMoreLayout.d)localObject, paramb, paramIResponse));
      AppMethodBeat.o(366644);
    }
    
    public final o mergeInsertData(List<? extends T> paramList, int paramInt)
    {
      AppMethodBeat.i(366661);
      kotlin.g.b.s.u(paramList, "newList");
      LinkedList localLinkedList = new LinkedList();
      paramList = (Iterable)paramList;
      BaseFeedLoader localBaseFeedLoader = BaseFeedLoader.this;
      Iterator localIterator = paramList.iterator();
      label132:
      label165:
      label177:
      label182:
      label185:
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        paramList = ((List)localBaseFeedLoader.getDataList()).iterator();
        int i = 0;
        label78:
        int j;
        if (paramList.hasNext()) {
          if (((k)paramList.next()).a(localk) == 0)
          {
            j = 1;
            label109:
            if (j == 0) {
              break label165;
            }
            label114:
            paramList = Integer.valueOf(i);
            if (((Number)paramList).intValue() != -1) {
              break label177;
            }
            i = 1;
            if (i == 0) {
              break label182;
            }
          }
        }
        for (;;)
        {
          if (paramList == null) {
            break label185;
          }
          ((Number)paramList).intValue();
          localLinkedList.add(localk);
          break;
          j = 0;
          break label109;
          i += 1;
          break label78;
          i = -1;
          break label114;
          i = 0;
          break label132;
          paramList = null;
        }
      }
      Log.i(BaseFeedLoader.this.getTAG(), "mergeInsertData startIndex = " + paramInt + ", incrementSize: " + localLinkedList.size());
      BaseFeedLoader.this.getDataList().addAll(paramInt, (Collection)localLinkedList);
      paramList = new o(paramInt, localLinkedList.size(), new LinkedList(), true, false);
      AppMethodBeat.o(366661);
      return paramList;
    }
    
    public void mergeInsertSpecifiedLocation(final IResponse<T> paramIResponse, final n paramn, final kotlin.g.a.b<? super IResponse<T>, ah> paramb)
    {
      AppMethodBeat.i(366649);
      kotlin.g.b.s.u(paramIResponse, "response");
      kotlin.g.b.s.u(paramn, "data");
      Object localObject = RefreshLoadMoreLayout.d.agJr;
      localObject = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMI());
      ((RefreshLoadMoreLayout.d)localObject).pzq = true;
      ((RefreshLoadMoreLayout.d)localObject).agJu = true;
      final List localList = paramIResponse.getIncrementList();
      if (localList != null) {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, paramn, localList, BaseFeedLoader.this, (RefreshLoadMoreLayout.d)localObject, paramb, paramIResponse));
      }
      AppMethodBeat.o(366649);
    }
    
    public void mergeLoadMore(final IResponse<T> paramIResponse, final kotlin.g.a.b<? super IResponse<T>, ah> paramb)
    {
      int i = 1;
      AppMethodBeat.i(366637);
      kotlin.g.b.s.u(paramIResponse, "response");
      Object localObject1 = RefreshLoadMoreLayout.d.agJr;
      localObject1 = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMH());
      Object localObject2 = paramIResponse.getIncrementList();
      boolean bool;
      if (localObject2 == null)
      {
        bool = true;
        ((RefreshLoadMoreLayout.d)localObject1).pzq = bool;
        ((RefreshLoadMoreLayout.d)localObject1).agJu = paramIResponse.getHasMore();
        if (!paramIResponse.getHasMore()) {
          break label137;
        }
      }
      for (;;)
      {
        localObject2 = new r(i, paramIResponse.getIncrementList(), false, 12);
        BaseFeedLoader.this.checkIsNeedUiThread(this.runUiThread, (kotlin.g.a.a)new e(this, (r)localObject2, (RefreshLoadMoreLayout.d)localObject1, BaseFeedLoader.this, paramb, paramIResponse));
        AppMethodBeat.o(366637);
        return;
        bool = ((List)localObject2).isEmpty();
        break;
        label137:
        i = 5;
      }
    }
    
    public void mergeRefresh(final IResponse<T> paramIResponse, final kotlin.g.a.b<? super IResponse<T>, ah> paramb)
    {
      AppMethodBeat.i(366632);
      kotlin.g.b.s.u(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.d.agJr;
      localObject = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMG());
      if (paramIResponse.getHasMore()) {}
      for (int i = 2;; i = 6)
      {
        final r localr = new r(i, paramIResponse.getIncrementList(), false, 12);
        BaseFeedLoader.this.checkIsNeedUiThread(this.runUiThread, (kotlin.g.a.a)new f(this, localr, (RefreshLoadMoreLayout.d)localObject, paramb, paramIResponse, BaseFeedLoader.this));
        AppMethodBeat.o(366632);
        return;
      }
    }
    
    public boolean onDataReplace(T paramT, int paramInt)
    {
      AppMethodBeat.i(366709);
      kotlin.g.b.s.u(paramT, "feed");
      AppMethodBeat.o(366709);
      return false;
    }
    
    public final void printList(String paramString, int paramInt, List<? extends T> paramList)
    {
      AppMethodBeat.i(366721);
      kotlin.g.b.s.u(paramString, "tag");
      kotlin.g.b.s.u(paramList, "mmlist");
      if (getDEBUG())
      {
        Object localObject1 = (Iterable)paramList;
        paramList = BaseFeedLoader.this;
        localObject1 = ((Iterable)localObject1).iterator();
        int i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          if (i < 0) {
            p.kkW();
          }
          localObject2 = (k)localObject2;
          String str = paramList.getTAG();
          StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(" index ").append(i).append(" cmd:");
          r.a locala = r.BkP;
          Log.i(str, r.a.Oe(paramInt) + ' ' + localObject2);
          i += 1;
        }
      }
      AppMethodBeat.o(366721);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger$getListUpdateCallback$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "positionStart", "", "itemCount", "payload", "", "onInserted", "onMoved", "p0", "p1", "onRemoved", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements q
    {
      a(BaseFeedLoader<T> paramBaseFeedLoader) {}
      
      public final void aR(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(366550);
        this.this$0.dispatcher().onItemRangeInserted(paramInt1, paramInt2);
        AppMethodBeat.o(366550);
      }
      
      public final void aS(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(366556);
        this.this$0.dispatcher().onItemRangeRemoved(paramInt1, paramInt2);
        AppMethodBeat.o(366556);
      }
      
      public final void aW(int paramInt1, int paramInt2) {}
      
      public final void c(int paramInt1, int paramInt2, Object paramObject)
      {
        AppMethodBeat.i(366536);
        this.this$0.dispatcher().onItemRangeChanged(paramInt1, paramInt2, paramObject);
        AppMethodBeat.o(366536);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      b(BaseFeedLoader<T> paramBaseFeedLoader, IResponse<T> paramIResponse, kotlin.g.a.b<? super IResponse<T>, ah> paramb)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      c(BaseFeedLoader<T>.a paramBaseFeedLoader, r<T> paramr, RefreshLoadMoreLayout.d<Object> paramd, kotlin.g.a.b<? super IResponse<T>, ah> paramb, IResponse<T> paramIResponse)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      d(BaseFeedLoader<T>.a paramBaseFeedLoader, n paramn, List<? extends T> paramList, BaseFeedLoader<T> paramBaseFeedLoader1, RefreshLoadMoreLayout.d<Object> paramd, kotlin.g.a.b<? super IResponse<T>, ah> paramb, IResponse<T> paramIResponse)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class e
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      e(BaseFeedLoader<T>.a paramBaseFeedLoader, r<T> paramr, RefreshLoadMoreLayout.d<Object> paramd, BaseFeedLoader<T> paramBaseFeedLoader1, kotlin.g.a.b<? super IResponse<T>, ah> paramb, IResponse<T> paramIResponse)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class f
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      f(BaseFeedLoader<T>.a paramBaseFeedLoader, r<T> paramr, RefreshLoadMoreLayout.d<Object> paramd, kotlin.g.a.b<? super IResponse<T>, ah> paramb, IResponse<T> paramIResponse, BaseFeedLoader<T> paramBaseFeedLoader1)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<i<T>>
  {
    b(BaseFeedLoader<T> paramBaseFeedLoader)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<IResponse<T>, ah>
  {
    c(BaseFeedLoader<T> paramBaseFeedLoader)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<IResponse<T>, ah>
  {
    d(BaseFeedLoader<T> paramBaseFeedLoader, IResponse<T> paramIResponse)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<IResponse<T>, ah>
  {
    e(BaseFeedLoader<T> paramBaseFeedLoader, IResponse<T> paramIResponse)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.b<IResponse<T>, ah>
  {
    f(BaseFeedLoader<T> paramBaseFeedLoader, IResponse<T> paramIResponse)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "cache", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.b<IResponse<T>, ah>
  {
    g(BaseFeedLoader<T> paramBaseFeedLoader, Object paramObject)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "cache", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.b<IResponse<T>, ah>
  {
    h(BaseFeedLoader<T> paramBaseFeedLoader, Object paramObject, h<T> paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    i(BaseFeedLoader<T> paramBaseFeedLoader)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "cache", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.b<IResponse<T>, ah>
  {
    j(BaseFeedLoader<T> paramBaseFeedLoader, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    k(BaseFeedLoader<T> paramBaseFeedLoader, h<T> paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "cache", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.b<IResponse<T>, ah>
  {
    l(BaseFeedLoader<T> paramBaseFeedLoader)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
 * JD-Core Version:    0.7.0.1
 */