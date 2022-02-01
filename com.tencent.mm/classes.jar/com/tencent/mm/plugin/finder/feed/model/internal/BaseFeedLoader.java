package com.tencent.mm.plugin.finder.feed.model.internal;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.j.a;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "backCache", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "getBackCache", "()Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "cache", "getCache", "value", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "getDataFetch", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "dataFetch$delegate", "Lkotlin/Lazy;", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "getInitDone", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "setInitDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "initPos", "", "getInitPos", "()I", "Lcom/tencent/mm/protobuf/ByteString;", "lastBuffer", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "preload", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IPreload;", "store", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore;", "getStore", "()Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore;", "createDataFetch", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "initBackCache", "", "intent", "Landroid/content/Intent;", "initFromCache", "isInitOperation", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "isInsertOperation", "isRefreshOperation", "onAlive", "onDead", "onFetchDone", "onFetchInitDone", "initResponse", "onFetchInsertedDone", "onFetchLoadMoreDone", "onFetchRefreshDone", "onSaveLastBuffer", "request", "", "callback", "requestInit", "isSyncLoad", "requestInsert", "requestLoadMore", "requestPreload", "requestRefresh", "saveCache", "position", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "saveCacheToIntent", "feedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "setPreload", "preloader", "DefaultDataMerger", "plugin-finder_release"})
public abstract class BaseFeedLoader<T extends i>
  extends Dispatcher<T>
  implements f<T>
{
  private final kotlin.f dataFetch$delegate;
  private h initDone;
  private j<T> preload;
  private final com.tencent.mm.plugin.finder.feed.model.j store = new com.tencent.mm.plugin.finder.feed.model.j();
  
  public BaseFeedLoader()
  {
    this(null, 1, null);
  }
  
  public BaseFeedLoader(bbn parambbn)
  {
    this.store.ttO = parambbn;
    this.dataFetch$delegate = kotlin.g.ah((kotlin.g.a.a)new b(this));
  }
  
  private final g<T> getDataFetch()
  {
    return (g)this.dataFetch$delegate.getValue();
  }
  
  public abstract g<T> createDataFetch();
  
  public b<T> createDataMerger()
  {
    return (b)new a();
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.h getBackCache()
  {
    return this.store.tXX;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.h getCache()
  {
    return this.store.tXW;
  }
  
  public final bbn getContextObj()
  {
    return this.store.ttO;
  }
  
  public final h getInitDone()
  {
    return this.initDone;
  }
  
  public final int getInitPos()
  {
    com.tencent.mm.plugin.finder.feed.model.h localh = this.store.tXW;
    if (localh != null) {}
    for (int i = localh.position;; i = 0) {
      return Math.max(i, 0);
    }
  }
  
  public final com.tencent.mm.bw.b getLastBuffer()
  {
    return this.store.lastBuffer;
  }
  
  protected final com.tencent.mm.plugin.finder.feed.model.j getStore()
  {
    return this.store;
  }
  
  public final void initBackCache(Intent paramIntent)
  {
    p.h(paramIntent, "intent");
    com.tencent.mm.plugin.finder.feed.model.j localj = this.store;
    p.h(paramIntent, "intent");
    j.a locala = com.tencent.mm.plugin.finder.feed.model.j.tYb;
    localj.tXX = j.a.al(paramIntent);
  }
  
  public final void initFromCache(Intent paramIntent)
  {
    p.h(paramIntent, "intent");
    com.tencent.mm.plugin.finder.feed.model.j.a(this.store, paramIntent);
  }
  
  public final boolean isInitOperation(IResponse<T> paramIResponse)
  {
    p.h(paramIResponse, "response");
    return 1000 == paramIResponse.getPullType();
  }
  
  public final boolean isInsertOperation(IResponse<T> paramIResponse)
  {
    p.h(paramIResponse, "response");
    return -1 == paramIResponse.getPullType();
  }
  
  public final boolean isRefreshOperation(IResponse<T> paramIResponse)
  {
    p.h(paramIResponse, "response");
    return (1 == paramIResponse.getPullType()) || (paramIResponse.getPullType() == 0) || (4 == paramIResponse.getPullType()) || (3 == paramIResponse.getPullType());
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
    p.h(paramIResponse, "response");
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
      } else {
        getMerger().mergeLoadMore(paramIResponse, (kotlin.g.a.b)new f(this, paramIResponse));
      }
    }
  }
  
  protected void onFetchInitDone(IResponse<T> paramIResponse)
  {
    p.h(paramIResponse, "initResponse");
    h localh = this.initDone;
    if (localh != null)
    {
      paramIResponse = paramIResponse.getIncrementList();
      if (paramIResponse == null) {
        break label40;
      }
    }
    label40:
    for (int i = paramIResponse.size();; i = 0)
    {
      localh.call(i);
      return;
    }
  }
  
  protected void onFetchInsertedDone(IResponse<T> paramIResponse)
  {
    p.h(paramIResponse, "response");
  }
  
  protected void onFetchLoadMoreDone(IResponse<T> paramIResponse)
  {
    p.h(paramIResponse, "response");
  }
  
  protected void onFetchRefreshDone(IResponse<T> paramIResponse)
  {
    p.h(paramIResponse, "response");
  }
  
  public void onSaveLastBuffer(IResponse<T> paramIResponse)
  {
    p.h(paramIResponse, "response");
    setLastBuffer(paramIResponse.getLastBuffer());
  }
  
  public final void request(final Object paramObject, final f<T> paramf)
  {
    Log.i(getTAG(), "request");
    if (paramf == null)
    {
      paramf = this.preload;
      if (paramf != null)
      {
        paramf.D((kotlin.g.a.b)new g(this, paramObject));
        return;
      }
      paramf = (BaseFeedLoader)this;
      paramf.getDataFetch().fetch(paramObject, (f)paramf);
      return;
    }
    j localj = this.preload;
    if (localj != null)
    {
      localj.D((kotlin.g.a.b)new h(this, paramObject, paramf));
      return;
    }
    ((BaseFeedLoader)this).getDataFetch().fetch(paramObject, paramf);
  }
  
  public final void requestInit(boolean paramBoolean)
  {
    Log.i(getTAG(), "initData from " + Util.getStack());
    if (paramBoolean)
    {
      getDataFetch().fetchInit((f)this);
      return;
    }
    kotlin.c.a.ai((kotlin.g.a.a)new i(this));
  }
  
  public void requestInsert(Object paramObject)
  {
    p.h(paramObject, "request");
    Log.i(getTAG(), "requestInsert ".concat(String.valueOf(paramObject)));
    request$default(this, paramObject, null, 2, null);
  }
  
  public void requestLoadMore()
  {
    Log.i(getTAG(), "requestLoadMore");
    Object localObject = this.preload;
    if (localObject != null)
    {
      ((j)localObject).D((kotlin.g.a.b)new j(this));
      return;
    }
    localObject = (BaseFeedLoader)this;
    ((BaseFeedLoader)localObject).getDataFetch().fetchLoadMore((f)localObject);
  }
  
  public final void requestPreload()
  {
    requestPreload((f)this);
  }
  
  public void requestPreload(final f<T> paramf)
  {
    j localj = this.preload;
    if (localj != null) {
      localj.G((kotlin.g.a.a)new k(this, paramf));
    }
  }
  
  public void requestRefresh()
  {
    Log.i(getTAG(), "requestRefresh");
    Object localObject = this.preload;
    if (localObject != null)
    {
      ((j)localObject).D((kotlin.g.a.b)new l(this));
      return;
    }
    localObject = (BaseFeedLoader)this;
    ((BaseFeedLoader)localObject).getDataFetch().fetchRefresh((f)localObject);
  }
  
  public final void saveCache(Intent paramIntent, int paramInt, com.tencent.mm.plugin.finder.feed.model.a parama)
  {
    p.h(paramIntent, "intent");
    ArrayList localArrayList = new ArrayList();
    DataBuffer localDataBuffer2 = getDataList();
    DataBuffer localDataBuffer1 = localDataBuffer2;
    if (!(localDataBuffer2 instanceof DataBuffer)) {
      localDataBuffer1 = null;
    }
    if (localDataBuffer1 != null) {
      localArrayList.addAll((Collection)localDataBuffer1);
    }
    parama = new com.tencent.mm.plugin.finder.feed.model.h(localArrayList, getLastBuffer(), paramInt, parama);
    this.store.a(parama, paramIntent);
  }
  
  public final void saveCacheToIntent(Intent paramIntent, List<? extends bo> paramList, com.tencent.mm.bw.b paramb, int paramInt, com.tencent.mm.plugin.finder.feed.model.a parama)
  {
    p.h(paramIntent, "intent");
    p.h(paramList, "feedList");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)paramList);
    paramList = new com.tencent.mm.plugin.finder.feed.model.h(localArrayList, paramb, paramInt, parama);
    this.store.a(paramList, paramIntent);
  }
  
  public final void setContextObj(bbn parambbn)
  {
    this.store.ttO = parambbn;
  }
  
  public final void setInitDone(h paramh)
  {
    this.initDone = paramh;
  }
  
  public final void setLastBuffer(com.tencent.mm.bw.b paramb)
  {
    this.store.lastBuffer = paramb;
  }
  
  public final void setPreload(j<T> paramj)
  {
    p.h(paramj, "preloader");
    this.preload = paramj;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;)V", "canFinallyHandleMergeList", "", "cmd", "", "cleanDataList", "", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "convertOpToReason", "op", "Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp;", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findMergeIndex", "srcList", "Ljava/util/ArrayList;", "newList", "", "request", "getListUpdateCallback", "Landroid/support/v7/util/ListUpdateCallback;", "merge", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "mergeDataAndNotify", "insList", "isNeedClear", "mergeInit", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeInsert", "mergeLoadMore", "mergeRefresh", "onDataReplace", "feed", "existIndex", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;I)Z", "printList", "tag", "", "mmlist", "plugin-finder_release"})
  public class a
    extends b<T>
  {
    public boolean canFinallyHandleMergeList(int paramInt)
    {
      return false;
    }
    
    public void cleanDataList(DataBuffer<T> paramDataBuffer)
    {
      AppMethodBeat.i(244960);
      p.h(paramDataBuffer, "dataList");
      paramDataBuffer.clear();
      AppMethodBeat.o(244960);
    }
    
    public final void convertOpToReason(n<T> paramn, RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(244964);
      p.h(paramn, "op");
      p.h(paramc, "reason");
      paramn = mergeDataAndNotify(paramn.EX, paramn.tYQ, paramn.isNeedClear, paramn.request);
      paramc.iMa = paramn;
      paramc.Rmk = paramn.tYD;
      AppMethodBeat.o(244964);
    }
    
    public int findMergeIndex(ArrayList<T> paramArrayList, List<? extends T> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(244959);
      p.h(paramArrayList, "srcList");
      p.h(paramList, "newList");
      if ((paramInt == 1) || (paramInt == 5))
      {
        paramInt = this.this$0.getDataList().size();
        AppMethodBeat.o(244959);
        return paramInt;
      }
      if ((paramInt == 2) || (paramInt == 6) || (paramInt == 4))
      {
        AppMethodBeat.o(244959);
        return 0;
      }
      AppMethodBeat.o(244959);
      return 0;
    }
    
    public android.support.v7.h.d getListUpdateCallback()
    {
      AppMethodBeat.i(244966);
      android.support.v7.h.d locald = (android.support.v7.h.d)new a(this);
      AppMethodBeat.o(244966);
      return locald;
    }
    
    protected final k merge(List<? extends T> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(244962);
      p.h(paramList, "newList");
      printList("newList", paramInt, paramList);
      DataBuffer localDataBuffer = this.this$0.getDataList();
      LinkedList localLinkedList1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      paramList = ((Iterable)paramList).iterator();
      boolean bool1 = false;
      int i;
      while (paramList.hasNext())
      {
        i locali = (i)paramList.next();
        Object localObject = (List)localDataBuffer;
        i = 0;
        localObject = ((List)localObject).iterator();
        label98:
        int k;
        if (((Iterator)localObject).hasNext()) {
          if (((i)((Iterator)localObject).next()).a(locali) == 0)
          {
            j = 1;
            label131:
            if (j == 0) {
              break label226;
            }
            j = i;
            label140:
            localObject = (List)localLinkedList1;
            i = 0;
            localObject = ((List)localObject).iterator();
            label159:
            if (!((Iterator)localObject).hasNext()) {
              break label256;
            }
            if (((i)((Iterator)localObject).next()).a(locali) != 0) {
              break label241;
            }
            k = 1;
            label192:
            if (k == 0) {
              break label247;
            }
          }
        }
        for (;;)
        {
          if ((j != -1) || (i != -1)) {
            break label262;
          }
          localLinkedList1.add(locali);
          break;
          j = 0;
          break label131;
          label226:
          i += 1;
          break label98;
          j = -1;
          break label140;
          label241:
          k = 0;
          break label192;
          label247:
          i += 1;
          break label159;
          label256:
          i = -1;
        }
        label262:
        if (j != -1)
        {
          localDataBuffer.set(j, locali);
          bool1 = onDataReplace(locali, j);
          localLinkedList2.add(Integer.valueOf(j));
        }
        else
        {
          Log.w(this.this$0.getTAG(), "newList exist a same feed[" + (i)localLinkedList1.get(i) + "], just ignore this feed=" + locali + " existIndex=" + j + " existIndexInIncrementList=" + i);
        }
      }
      printList("incrementList", paramInt, (List)localLinkedList1);
      int j = 0;
      boolean bool2 = false;
      if ((localLinkedList1.size() > 0) || (canFinallyHandleMergeList(paramInt)))
      {
        i = 1;
        if (i == 0) {
          break label575;
        }
      }
      label575:
      for (paramList = localLinkedList1;; paramList = null)
      {
        i = j;
        if (paramList != null)
        {
          i = findMergeIndex((ArrayList)localDataBuffer, (List)localLinkedList1, paramInt, paramObject);
          bool2 = finallyHandleMergeList((ArrayList)localDataBuffer, localLinkedList1, i, paramInt, paramObject);
          Log.i(this.this$0.getTAG(), "merge list index " + i + " incrementList:" + localLinkedList1.size() + " cmd=" + paramInt);
          localDataBuffer.addAll(i, (Collection)localLinkedList1);
        }
        paramList = new k(i, localLinkedList1.size(), localLinkedList2, bool2, bool1);
        printList("dataList", paramInt, (List)this.this$0.getDataList());
        AppMethodBeat.o(244962);
        return paramList;
        i = 0;
        break;
      }
    }
    
    public k mergeDataAndNotify(int paramInt, List<? extends T> paramList, boolean paramBoolean, Object paramObject)
    {
      AppMethodBeat.i(244961);
      if (paramList == null)
      {
        paramList = new k(new LinkedList());
        AppMethodBeat.o(244961);
        return paramList;
      }
      if (!paramBoolean)
      {
        Log.i(this.this$0.getTAG(), "nothing need to notify, just return. cmd=" + paramInt + " size =" + paramList.size());
        paramList = new k(new LinkedList());
        AppMethodBeat.o(244961);
        return paramList;
      }
      int j = this.this$0.getDataList().size();
      if (((paramInt == 4) || (paramInt == 3) || (paramInt == 7)) && (needCleanWhenRefresh(paramList)))
      {
        if (((Collection)paramList).isEmpty()) {
          break label410;
        }
        i = 1;
        if ((i != 0) || (paramInt == 7))
        {
          cleanDataList(this.this$0.getDataList());
          if (paramInt == 4) {
            this.this$0.dispatcher().onItemRangeRemoved(0, j);
          }
        }
      }
      paramList = merge(paramList, paramInt, paramObject);
      paramObject = this.this$0.getTAG();
      StringBuilder localStringBuilder = new StringBuilder("mergeDataAndNotify insertIndex=").append(paramList.tYC).append(" insertCount=").append(paramList.tYD).append(" changeIndex=").append(paramList.tYE).append(' ').append("size: ").append(this.this$0.getDataList().size()).append(" isRemoveBeforeInsert=").append(paramList.tYF).append(" loader:").append(getClass().getSimpleName()).append(" cmd:");
      n.a locala = n.tYR;
      Log.i(paramObject, n.a.IP(paramInt) + '}');
      if (!((Collection)paramList.tYE).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (paramList.tYD > 0)) {
          break label422;
        }
        Log.i(this.this$0.getTAG(), "just change all. cmd=".concat(String.valueOf(paramInt)));
        this.this$0.dispatcher().onChanged();
        AppMethodBeat.o(244961);
        return paramList;
        label410:
        i = 0;
        break;
      }
      label422:
      if ((paramInt == 3) || (paramInt == 2) || (paramInt == 6) || (paramInt == 7)) {
        this.this$0.dispatcher().onChanged();
      }
      for (;;)
      {
        AppMethodBeat.o(244961);
        return paramList;
        if (paramList.tYF)
        {
          paramObject = this.this$0.dispatcher();
          paramInt = paramList.tYC;
          paramObject.onItemRangeRemoved(paramInt, j - paramInt);
        }
        this.this$0.dispatcher().onItemRangeInserted(paramList.tYC, paramList.tYD);
      }
    }
    
    public void mergeInit(final IResponse<T> paramIResponse, final kotlin.g.a.b<? super IResponse<T>, x> paramb)
    {
      AppMethodBeat.i(244955);
      p.h(paramIResponse, "response");
      if (paramIResponse.getIncrementList() == null) {
        paramIResponse.setIncrementList((List)v.SXr);
      }
      String str = this.this$0.getTAG();
      StringBuilder localStringBuilder = new StringBuilder("initData dataFetch.initData ");
      Object localObject = paramIResponse.getIncrementList();
      if (localObject != null) {}
      for (localObject = Integer.valueOf(((List)localObject).size());; localObject = null)
      {
        Log.i(str, localObject);
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(this, paramIResponse, paramb));
        AppMethodBeat.o(244955);
        return;
      }
    }
    
    public void mergeInsert(final IResponse<T> paramIResponse, final kotlin.g.a.b<? super IResponse<T>, x> paramb)
    {
      AppMethodBeat.i(244958);
      p.h(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.Rms;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.hfV());
      ((RefreshLoadMoreLayout.c)localObject).jLE = true;
      ((RefreshLoadMoreLayout.c)localObject).Rmj = true;
      final n localn = new n(8, paramIResponse.getIncrementList(), false, 12);
      localn.request = paramIResponse.getRequest();
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new c(this, localn, (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
      AppMethodBeat.o(244958);
    }
    
    public void mergeLoadMore(final IResponse<T> paramIResponse, final kotlin.g.a.b<? super IResponse<T>, x> paramb)
    {
      int i = 1;
      AppMethodBeat.i(244957);
      p.h(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.Rms;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.hfU());
      List localList = paramIResponse.getIncrementList();
      boolean bool;
      if (localList != null)
      {
        bool = localList.isEmpty();
        ((RefreshLoadMoreLayout.c)localObject).jLE = bool;
        ((RefreshLoadMoreLayout.c)localObject).Rmj = paramIResponse.getHasMore();
        if (!paramIResponse.getHasMore()) {
          break label121;
        }
      }
      for (;;)
      {
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new d(this, new n(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
        AppMethodBeat.o(244957);
        return;
        bool = true;
        break;
        label121:
        i = 5;
      }
    }
    
    public void mergeRefresh(final IResponse<T> paramIResponse, final kotlin.g.a.b<? super IResponse<T>, x> paramb)
    {
      AppMethodBeat.i(244956);
      p.h(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.Rms;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.hfT());
      if (paramIResponse.getHasMore()) {}
      for (int i = 2;; i = 6)
      {
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new e(this, new n(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
        AppMethodBeat.o(244956);
        return;
      }
    }
    
    public boolean onDataReplace(T paramT, int paramInt)
    {
      AppMethodBeat.i(244965);
      p.h(paramT, "feed");
      AppMethodBeat.o(244965);
      return false;
    }
    
    public final void printList(String paramString, int paramInt, List<? extends T> paramList)
    {
      AppMethodBeat.i(244967);
      p.h(paramString, "tag");
      p.h(paramList, "mmlist");
      if (getDEBUG())
      {
        paramList = ((Iterable)paramList).iterator();
        int i = 0;
        while (paramList.hasNext())
        {
          Object localObject = paramList.next();
          if (i < 0) {
            kotlin.a.j.hxH();
          }
          localObject = (i)localObject;
          String str = this.this$0.getTAG();
          StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(" index ").append(i).append(" cmd:");
          n.a locala = n.tYR;
          Log.i(str, n.a.IP(paramInt) + ' ' + localObject);
          i += 1;
        }
      }
      AppMethodBeat.o(244967);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger$getListUpdateCallback$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "positionStart", "", "itemCount", "payload", "", "onInserted", "onMoved", "p0", "p1", "onRemoved", "plugin-finder_release"})
    public static final class a
      implements android.support.v7.h.d
    {
      public final void c(int paramInt1, int paramInt2, Object paramObject)
      {
        AppMethodBeat.i(244948);
        this.tYc.this$0.dispatcher().onItemRangeChanged(paramInt1, paramInt2, paramObject);
        AppMethodBeat.o(244948);
      }
      
      public final void f(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(244949);
        this.tYc.this$0.dispatcher().onItemRangeInserted(paramInt1, paramInt2);
        AppMethodBeat.o(244949);
      }
      
      public final void k(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(244950);
        this.tYc.this$0.dispatcher().onItemRangeRemoved(paramInt1, paramInt2);
        AppMethodBeat.o(244950);
      }
      
      public final void l(int paramInt1, int paramInt2) {}
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(BaseFeedLoader.a parama, IResponse paramIResponse, kotlin.g.a.b paramb)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      c(BaseFeedLoader.a parama, n paramn, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<x>
    {
      d(BaseFeedLoader.a parama, n paramn, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    static final class e
      extends q
      implements kotlin.g.a.a<x>
    {
      e(BaseFeedLoader.a parama, n paramn, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<g<T>>
  {
    b(BaseFeedLoader paramBaseFeedLoader)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<IResponse<T>, x>
  {
    c(BaseFeedLoader paramBaseFeedLoader)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<IResponse<T>, x>
  {
    d(BaseFeedLoader paramBaseFeedLoader, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<IResponse<T>, x>
  {
    e(BaseFeedLoader paramBaseFeedLoader, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<IResponse<T>, x>
  {
    f(BaseFeedLoader paramBaseFeedLoader, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "cache", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.b<IResponse<T>, x>
  {
    g(BaseFeedLoader paramBaseFeedLoader, Object paramObject)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "cache", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.b<IResponse<T>, x>
  {
    h(BaseFeedLoader paramBaseFeedLoader, Object paramObject, f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(BaseFeedLoader paramBaseFeedLoader)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "cache", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<IResponse<T>, x>
  {
    j(BaseFeedLoader paramBaseFeedLoader)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<x>
  {
    k(BaseFeedLoader paramBaseFeedLoader, f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "cache", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.b<IResponse<T>, x>
  {
    l(BaseFeedLoader paramBaseFeedLoader)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
 * JD-Core Version:    0.7.0.1
 */