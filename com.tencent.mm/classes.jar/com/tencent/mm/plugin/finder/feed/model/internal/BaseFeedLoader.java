package com.tencent.mm.plugin.finder.feed.model.internal;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.c;
import com.tencent.mm.plugin.finder.feed.model.s.a;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "backCache", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "getBackCache", "()Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "cache", "getCache", "value", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "setContextObj", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "getDataFetch", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "dataFetch$delegate", "Lkotlin/Lazy;", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "getInitDone", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "setInitDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "initPos", "", "getInitPos", "()I", "Lcom/tencent/mm/protobuf/ByteString;", "lastBuffer", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "preload", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IPreload;", "store", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore;", "getStore", "()Lcom/tencent/mm/plugin/finder/feed/model/LoaderStateStore;", "createDataFetch", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "initBackCache", "", "intent", "Landroid/content/Intent;", "initFromCache", "isInitOperation", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "isInsertOperation", "isRefreshOperation", "onAlive", "onDead", "onFetchDone", "onFetchInitDone", "initResponse", "onFetchInsertedDone", "onFetchLoadMoreDone", "onFetchRefreshDone", "onSaveLastBuffer", "request", "", "callback", "requestInit", "isSyncLoad", "requestInsert", "requestLoadMore", "requestPreload", "requestRefresh", "saveCache", "position", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "saveCacheToIntent", "feedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "setPreload", "preloader", "DefaultDataMerger", "plugin-finder-base_release"})
public abstract class BaseFeedLoader<T extends k>
  extends Dispatcher<T>
  implements h<T>
{
  private final kotlin.f dataFetch$delegate;
  private j initDone;
  private l<T> preload;
  private final com.tencent.mm.plugin.finder.feed.model.s store = new com.tencent.mm.plugin.finder.feed.model.s();
  
  public BaseFeedLoader()
  {
    this(null, 1, null);
  }
  
  public BaseFeedLoader(bid parambid)
  {
    this.store.xbu = parambid;
    this.dataFetch$delegate = g.ar((kotlin.g.a.a)new b(this));
  }
  
  private final i<T> getDataFetch()
  {
    return (i)this.dataFetch$delegate.getValue();
  }
  
  public abstract i<T> createDataFetch();
  
  public d<T> createDataMerger()
  {
    return (d)new a();
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.q getBackCache()
  {
    return this.store.xJW;
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.q getCache()
  {
    return this.store.xJV;
  }
  
  public final bid getContextObj()
  {
    return this.store.xbu;
  }
  
  public final j getInitDone()
  {
    return this.initDone;
  }
  
  public final int getInitPos()
  {
    com.tencent.mm.plugin.finder.feed.model.q localq = this.store.xJV;
    if (localq != null) {}
    for (int i = localq.position;; i = 0) {
      return Math.max(i, 0);
    }
  }
  
  public final com.tencent.mm.cd.b getLastBuffer()
  {
    return this.store.lastBuffer;
  }
  
  protected final com.tencent.mm.plugin.finder.feed.model.s getStore()
  {
    return this.store;
  }
  
  public final void initBackCache(Intent paramIntent)
  {
    p.k(paramIntent, "intent");
    com.tencent.mm.plugin.finder.feed.model.s locals = this.store;
    p.k(paramIntent, "intent");
    s.a locala = com.tencent.mm.plugin.finder.feed.model.s.xKa;
    locals.xJW = s.a.ai(paramIntent);
  }
  
  public final void initFromCache(Intent paramIntent)
  {
    p.k(paramIntent, "intent");
    com.tencent.mm.plugin.finder.feed.model.s.a(this.store, paramIntent);
  }
  
  public final boolean isInitOperation(IResponse<T> paramIResponse)
  {
    p.k(paramIResponse, "response");
    return 1000 == paramIResponse.getPullType();
  }
  
  public final boolean isInsertOperation(IResponse<T> paramIResponse)
  {
    p.k(paramIResponse, "response");
    return -1 == paramIResponse.getPullType();
  }
  
  public final boolean isRefreshOperation(IResponse<T> paramIResponse)
  {
    p.k(paramIResponse, "response");
    return (1 == paramIResponse.getPullType()) || (paramIResponse.getPullType() == 0) || (4 == paramIResponse.getPullType()) || (3 == paramIResponse.getPullType()) || (10 == paramIResponse.getPullType()) || (11 == paramIResponse.getPullType()) || (12 == paramIResponse.getPullType());
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
    p.k(paramIResponse, "response");
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
    p.k(paramIResponse, "initResponse");
    j localj = this.initDone;
    if (localj != null)
    {
      paramIResponse = paramIResponse.getIncrementList();
      if (paramIResponse == null) {
        break label45;
      }
    }
    label45:
    for (int i = paramIResponse.size();; i = 0)
    {
      localj.call(i);
      this.initDone = null;
      return;
    }
  }
  
  protected void onFetchInsertedDone(IResponse<T> paramIResponse)
  {
    p.k(paramIResponse, "response");
  }
  
  protected void onFetchLoadMoreDone(IResponse<T> paramIResponse)
  {
    p.k(paramIResponse, "response");
  }
  
  protected void onFetchRefreshDone(IResponse<T> paramIResponse)
  {
    p.k(paramIResponse, "response");
  }
  
  public void onSaveLastBuffer(IResponse<T> paramIResponse)
  {
    p.k(paramIResponse, "response");
    setLastBuffer(paramIResponse.getLastBuffer());
  }
  
  public final void request(final Object paramObject, final h<T> paramh)
  {
    Log.i(getTAG(), "request");
    if (paramh == null)
    {
      paramh = this.preload;
      if (paramh != null)
      {
        paramh.I((kotlin.g.a.b)new g(this, paramObject));
        return;
      }
      paramh = (BaseFeedLoader)this;
      paramh.getDataFetch().fetch(paramObject, (h)paramh);
      return;
    }
    l locall = this.preload;
    if (locall != null)
    {
      locall.I((kotlin.g.a.b)new h(this, paramObject, paramh));
      return;
    }
    ((BaseFeedLoader)this).getDataFetch().fetch(paramObject, paramh);
  }
  
  public final void requestInit(boolean paramBoolean)
  {
    Log.i(getTAG(), "initData from " + Util.getStack());
    if (paramBoolean)
    {
      getDataFetch().fetchInit((h)this);
      return;
    }
    kotlin.c.a.as((kotlin.g.a.a)new i(this));
  }
  
  public void requestInsert(Object paramObject)
  {
    p.k(paramObject, "request");
    Log.i(getTAG(), "requestInsert ".concat(String.valueOf(paramObject)));
    request$default(this, paramObject, null, 2, null);
  }
  
  public void requestLoadMore()
  {
    Log.i(getTAG(), "requestLoadMore");
    Object localObject = this.preload;
    if (localObject != null)
    {
      ((l)localObject).I((kotlin.g.a.b)new j(this));
      return;
    }
    localObject = (BaseFeedLoader)this;
    ((BaseFeedLoader)localObject).getDataFetch().fetchLoadMore((h)localObject);
  }
  
  public final void requestPreload()
  {
    requestPreload((h)this);
  }
  
  public void requestPreload(final h<T> paramh)
  {
    l locall = this.preload;
    if (locall != null) {
      locall.F((kotlin.g.a.a)new k(this, paramh));
    }
  }
  
  public void requestRefresh()
  {
    Log.i(getTAG(), "requestRefresh");
    Object localObject = this.preload;
    if (localObject != null)
    {
      ((l)localObject).I((kotlin.g.a.b)new l(this));
      return;
    }
    localObject = (BaseFeedLoader)this;
    ((BaseFeedLoader)localObject).getDataFetch().fetchRefresh((h)localObject);
  }
  
  public final void saveCache(Intent paramIntent, int paramInt, c paramc)
  {
    p.k(paramIntent, "intent");
    ArrayList localArrayList = new ArrayList();
    DataBuffer localDataBuffer2 = getDataList();
    DataBuffer localDataBuffer1 = localDataBuffer2;
    if (!(localDataBuffer2 instanceof DataBuffer)) {
      localDataBuffer1 = null;
    }
    if (localDataBuffer1 != null) {
      localArrayList.addAll((Collection)localDataBuffer1);
    }
    paramc = new com.tencent.mm.plugin.finder.feed.model.q(localArrayList, getLastBuffer(), paramInt, paramc);
    this.store.a(paramc, paramIntent);
  }
  
  public final void saveCacheToIntent(Intent paramIntent, List<? extends bu> paramList, com.tencent.mm.cd.b paramb, int paramInt, c paramc)
  {
    p.k(paramIntent, "intent");
    p.k(paramList, "feedList");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)paramList);
    paramList = new com.tencent.mm.plugin.finder.feed.model.q(localArrayList, paramb, paramInt, paramc);
    this.store.a(paramList, paramIntent);
  }
  
  public final void setContextObj(bid parambid)
  {
    this.store.xbu = parambid;
  }
  
  public final void setInitDone(j paramj)
  {
    this.initDone = paramj;
  }
  
  public final void setLastBuffer(com.tencent.mm.cd.b paramb)
  {
    this.store.lastBuffer = paramb;
  }
  
  public final void setPreload(l<T> paraml)
  {
    p.k(paraml, "preloader");
    this.preload = paraml;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;)V", "canFinallyHandleMergeList", "", "cmd", "", "cleanDataList", "", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "convertOpToReason", "op", "Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp;", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findMergeIndex", "srcList", "Ljava/util/ArrayList;", "newList", "", "request", "getListUpdateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "merge", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "mergeDataAndNotify", "insList", "isNeedClear", "mergeInit", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeInsert", "mergeLoadMore", "mergeRefresh", "onDataReplace", "feed", "existIndex", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;I)Z", "printList", "tag", "", "mmlist", "plugin-finder-base_release"})
  public class a
    extends d<T>
  {
    public boolean canFinallyHandleMergeList(int paramInt)
    {
      return false;
    }
    
    public void cleanDataList(DataBuffer<T> paramDataBuffer)
    {
      AppMethodBeat.i(259186);
      p.k(paramDataBuffer, "dataList");
      paramDataBuffer.clear();
      AppMethodBeat.o(259186);
    }
    
    public final void convertOpToReason(q<T> paramq, RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(259195);
      p.k(paramq, "op");
      p.k(paramc, "reason");
      paramq = mergeDataAndNotify(paramq.Vh, paramq.xLb, paramq.isNeedClear, paramq.request);
      paramc.lCh = paramq;
      paramc.YNG = paramq.xKO;
      AppMethodBeat.o(259195);
    }
    
    public int findMergeIndex(ArrayList<T> paramArrayList, List<? extends T> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(259185);
      p.k(paramArrayList, "srcList");
      p.k(paramList, "newList");
      if ((paramInt == 1) || (paramInt == 5))
      {
        paramInt = this.this$0.getDataList().size();
        AppMethodBeat.o(259185);
        return paramInt;
      }
      if ((paramInt == 2) || (paramInt == 6) || (paramInt == 4))
      {
        AppMethodBeat.o(259185);
        return 0;
      }
      AppMethodBeat.o(259185);
      return 0;
    }
    
    public androidx.recyclerview.widget.s getListUpdateCallback()
    {
      AppMethodBeat.i(259200);
      androidx.recyclerview.widget.s locals = (androidx.recyclerview.widget.s)new a(this);
      AppMethodBeat.o(259200);
      return locals;
    }
    
    protected final n merge(List<? extends T> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(259190);
      p.k(paramList, "newList");
      printList("newList", paramInt, paramList);
      DataBuffer localDataBuffer = this.this$0.getDataList();
      LinkedList localLinkedList1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      paramList = ((Iterable)paramList).iterator();
      boolean bool1 = false;
      int i;
      while (paramList.hasNext())
      {
        k localk = (k)paramList.next();
        Object localObject = (List)localDataBuffer;
        i = 0;
        localObject = ((List)localObject).iterator();
        label98:
        int k;
        if (((Iterator)localObject).hasNext()) {
          if (((k)((Iterator)localObject).next()).a(localk) == 0)
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
            if (((k)((Iterator)localObject).next()).a(localk) != 0) {
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
          localLinkedList1.add(localk);
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
          localDataBuffer.set(j, localk);
          bool1 = onDataReplace(localk, j);
          localLinkedList2.add(Integer.valueOf(j));
        }
        else
        {
          Log.w(this.this$0.getTAG(), "newList exist a same feed[" + (k)localLinkedList1.get(i) + "], just ignore this feed=" + localk + " existIndex=" + j + " existIndexInIncrementList=" + i);
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
        paramList = new n(i, localLinkedList1.size(), localLinkedList2, bool2, bool1);
        printList("dataList", paramInt, (List)this.this$0.getDataList());
        AppMethodBeat.o(259190);
        return paramList;
        i = 0;
        break;
      }
    }
    
    public n mergeDataAndNotify(int paramInt, List<? extends T> paramList, boolean paramBoolean, Object paramObject)
    {
      AppMethodBeat.i(259187);
      if (paramList == null)
      {
        paramList = new n(new LinkedList());
        AppMethodBeat.o(259187);
        return paramList;
      }
      if (!paramBoolean)
      {
        Log.i(this.this$0.getTAG(), "nothing need to notify, just return. cmd=" + paramInt + " size =" + paramList.size());
        paramList = new n(new LinkedList());
        AppMethodBeat.o(259187);
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
      StringBuilder localStringBuilder = new StringBuilder("mergeDataAndNotify insertIndex=").append(paramList.xKN).append(" insertCount=").append(paramList.xKO).append(" changeIndex=").append(paramList.xKP).append(' ').append("size: ").append(this.this$0.getDataList().size()).append(" isRemoveBeforeInsert=").append(paramList.xKQ).append(" loader:").append(getClass().getSimpleName()).append(" cmd:");
      q.a locala = q.xLc;
      Log.i(paramObject, q.a.MH(paramInt) + '}');
      if (!((Collection)paramList.xKP).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (paramList.xKO > 0)) {
          break label422;
        }
        Log.i(this.this$0.getTAG(), "just change all. cmd=".concat(String.valueOf(paramInt)));
        this.this$0.dispatcher().onChanged();
        AppMethodBeat.o(259187);
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
        AppMethodBeat.o(259187);
        return paramList;
        if (paramList.xKQ)
        {
          paramObject = this.this$0.dispatcher();
          paramInt = paramList.xKN;
          paramObject.onItemRangeRemoved(paramInt, j - paramInt);
        }
        this.this$0.dispatcher().onItemRangeInserted(paramList.xKN, paramList.xKO);
      }
    }
    
    public void mergeInit(final IResponse<T> paramIResponse, final kotlin.g.a.b<? super IResponse<T>, x> paramb)
    {
      AppMethodBeat.i(259178);
      p.k(paramIResponse, "response");
      if (paramIResponse.getIncrementList() == null) {
        paramIResponse.setIncrementList((List)v.aaAd);
      }
      String str = this.this$0.getTAG();
      StringBuilder localStringBuilder = new StringBuilder("initData dataFetch.initData ");
      Object localObject = paramIResponse.getIncrementList();
      if (localObject != null) {}
      for (localObject = Integer.valueOf(((List)localObject).size());; localObject = null)
      {
        Log.i(str, localObject);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramIResponse, paramb));
        AppMethodBeat.o(259178);
        return;
      }
    }
    
    public void mergeInsert(final IResponse<T> paramIResponse, final kotlin.g.a.b<? super IResponse<T>, x> paramb)
    {
      AppMethodBeat.i(259183);
      p.k(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.YNO;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.ihu());
      ((RefreshLoadMoreLayout.c)localObject).mCI = true;
      ((RefreshLoadMoreLayout.c)localObject).YNF = true;
      final q localq = new q(8, paramIResponse.getIncrementList(), false, 12);
      localq.request = paramIResponse.getRequest();
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, localq, (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
      AppMethodBeat.o(259183);
    }
    
    public void mergeLoadMore(final IResponse<T> paramIResponse, final kotlin.g.a.b<? super IResponse<T>, x> paramb)
    {
      int i = 1;
      AppMethodBeat.i(259181);
      p.k(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.YNO;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.iht());
      List localList = paramIResponse.getIncrementList();
      boolean bool;
      if (localList != null)
      {
        bool = localList.isEmpty();
        ((RefreshLoadMoreLayout.c)localObject).mCI = bool;
        ((RefreshLoadMoreLayout.c)localObject).YNF = paramIResponse.getHasMore();
        if (!paramIResponse.getHasMore()) {
          break label121;
        }
      }
      for (;;)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, new q(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
        AppMethodBeat.o(259181);
        return;
        bool = true;
        break;
        label121:
        i = 5;
      }
    }
    
    public void mergeRefresh(final IResponse<T> paramIResponse, final kotlin.g.a.b<? super IResponse<T>, x> paramb)
    {
      AppMethodBeat.i(259180);
      p.k(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.YNO;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.ihs());
      if (paramIResponse.getHasMore()) {}
      for (int i = 2;; i = 6)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, new q(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
        AppMethodBeat.o(259180);
        return;
      }
    }
    
    public boolean onDataReplace(T paramT, int paramInt)
    {
      AppMethodBeat.i(259198);
      p.k(paramT, "feed");
      AppMethodBeat.o(259198);
      return false;
    }
    
    public final void printList(String paramString, int paramInt, List<? extends T> paramList)
    {
      AppMethodBeat.i(259201);
      p.k(paramString, "tag");
      p.k(paramList, "mmlist");
      if (getDEBUG())
      {
        paramList = ((Iterable)paramList).iterator();
        int i = 0;
        while (paramList.hasNext())
        {
          Object localObject = paramList.next();
          if (i < 0) {
            kotlin.a.j.iBO();
          }
          localObject = (k)localObject;
          String str = this.this$0.getTAG();
          StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(" index ").append(i).append(" cmd:");
          q.a locala = q.xLc;
          Log.i(str, q.a.MH(paramInt) + ' ' + localObject);
          i += 1;
        }
      }
      AppMethodBeat.o(259201);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger$getListUpdateCallback$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "positionStart", "", "itemCount", "payload", "", "onInserted", "onMoved", "p0", "p1", "onRemoved", "plugin-finder-base_release"})
    public static final class a
      implements androidx.recyclerview.widget.s
    {
      public final void W(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(263561);
        this.xKe.this$0.dispatcher().onItemRangeInserted(paramInt1, paramInt2);
        AppMethodBeat.o(263561);
      }
      
      public final void ac(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(263562);
        this.xKe.this$0.dispatcher().onItemRangeRemoved(paramInt1, paramInt2);
        AppMethodBeat.o(263562);
      }
      
      public final void ad(int paramInt1, int paramInt2) {}
      
      public final void c(int paramInt1, int paramInt2, Object paramObject)
      {
        AppMethodBeat.i(263559);
        this.xKe.this$0.dispatcher().onItemRangeChanged(paramInt1, paramInt2, paramObject);
        AppMethodBeat.o(263559);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      b(BaseFeedLoader.a parama, IResponse paramIResponse, kotlin.g.a.b paramb)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      c(BaseFeedLoader.a parama, q paramq, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    static final class d
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      d(BaseFeedLoader.a parama, q paramq, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    static final class e
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      e(BaseFeedLoader.a parama, q paramq, RefreshLoadMoreLayout.c paramc, kotlin.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<i<T>>
  {
    b(BaseFeedLoader paramBaseFeedLoader)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<T>, x>
  {
    c(BaseFeedLoader paramBaseFeedLoader)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<T>, x>
  {
    d(BaseFeedLoader paramBaseFeedLoader, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<T>, x>
  {
    e(BaseFeedLoader paramBaseFeedLoader, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<T>, x>
  {
    f(BaseFeedLoader paramBaseFeedLoader, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "cache", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<T>, x>
  {
    g(BaseFeedLoader paramBaseFeedLoader, Object paramObject)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "cache", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<T>, x>
  {
    h(BaseFeedLoader paramBaseFeedLoader, Object paramObject, h paramh)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(BaseFeedLoader paramBaseFeedLoader)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "cache", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<T>, x>
  {
    j(BaseFeedLoader paramBaseFeedLoader)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    k(BaseFeedLoader paramBaseFeedLoader, h paramh)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "cache", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class l
    extends kotlin.g.b.q
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