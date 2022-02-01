package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.a.v;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "()V", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "getDataFetch", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "dataFetch$delegate", "Lkotlin/Lazy;", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "getInitDone", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "setInitDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "createDataFetch", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "isInitOperation", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "isInsertOperation", "isRefreshOperation", "onAlive", "", "onDead", "onFetchDone", "onFetchInitDone", "initResponse", "onFetchInsertedDone", "onFetchLoadMoreDone", "onFetchRefreshDone", "request", "", "callback", "requestInit", "isSyncLoad", "requestInsert", "requestLoadMore", "requestRefresh", "DefaultDataMerger", "plugin-finder_release"})
public abstract class BaseFeedLoader<T extends i>
  extends Dispatcher<T>
  implements f<T>
{
  private final d.f dataFetch$delegate = d.g.O((d.g.a.a)new b(this));
  private h initDone;
  
  private final g<T> getDataFetch()
  {
    return (g)this.dataFetch$delegate.getValue();
  }
  
  public abstract g<T> createDataFetch();
  
  public b<T> createDataMerger()
  {
    return (b)new a();
  }
  
  public final h getInitDone()
  {
    return this.initDone;
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
    ad.i(getTAG(), "onAlive");
    getDataFetch().alive();
  }
  
  public void onDead()
  {
    ad.i(getTAG(), "onDead");
    getDataFetch().dead();
  }
  
  public void onFetchDone(final IResponse<T> paramIResponse)
  {
    p.h(paramIResponse, "response");
    if (isInitOperation(paramIResponse))
    {
      getMerger().mergeInit(paramIResponse, (d.g.a.b)new c(this));
      return;
    }
    if (isRefreshOperation(paramIResponse))
    {
      getMerger().mergeRefresh(paramIResponse, (d.g.a.b)new d(this, paramIResponse));
      return;
    }
    if (isInsertOperation(paramIResponse))
    {
      getMerger().mergeInsert(paramIResponse, (d.g.a.b)new e(this, paramIResponse));
      return;
    }
    getMerger().mergeLoadMore(paramIResponse, (d.g.a.b)new f(this, paramIResponse));
  }
  
  protected void onFetchInitDone(IResponse<T> paramIResponse)
  {
    p.h(paramIResponse, "initResponse");
    h localh = this.initDone;
    if (localh != null)
    {
      paramIResponse = paramIResponse.getIncrementList();
      if (paramIResponse == null) {
        break label39;
      }
    }
    label39:
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
  
  public final void request(Object paramObject, f<T> paramf)
  {
    ad.i(getTAG(), "request");
    if (paramf == null)
    {
      getDataFetch().fetch(paramObject, (f)this);
      return;
    }
    getDataFetch().fetch(paramObject, paramf);
  }
  
  public final void requestInit(boolean paramBoolean)
  {
    ad.i(getTAG(), "initData from " + bt.flS());
    if (paramBoolean)
    {
      getDataFetch().fetchInit((f)this);
      return;
    }
    d.c.a.P((d.g.a.a)new g(this));
  }
  
  public void requestInsert(Object paramObject)
  {
    p.h(paramObject, "request");
    ad.i(getTAG(), "requestInsert ".concat(String.valueOf(paramObject)));
    request$default(this, paramObject, null, 2, null);
  }
  
  public void requestLoadMore()
  {
    ad.i(getTAG(), "requestLoadMore");
    getDataFetch().fetchLoadMore((f)this);
  }
  
  public void requestRefresh()
  {
    ad.i(getTAG(), "requestRefresh");
    getDataFetch().fetchRefresh((f)this);
  }
  
  public final void setInitDone(h paramh)
  {
    this.initDone = paramh;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;)V", "cleanDataList", "", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "convertOpToReason", "op", "Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp;", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "request", "getListUpdateCallback", "Landroid/support/v7/util/ListUpdateCallback;", "merge", "Lcom/tencent/mm/plugin/finder/feed/model/internal/MergeResult;", "mergeDataAndNotify", "insList", "isNeedClear", "", "mergeInit", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "mergeInsert", "mergeLoadMore", "mergeRefresh", "printList", "tag", "", "mmlist", "plugin-finder_release"})
  public class a
    extends b<T>
  {
    public void cleanDataList(DataBuffer<T> paramDataBuffer)
    {
      AppMethodBeat.i(202528);
      p.h(paramDataBuffer, "dataList");
      paramDataBuffer.clear();
      AppMethodBeat.o(202528);
    }
    
    public final void convertOpToReason(l<T> paraml, RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202532);
      p.h(paraml, "op");
      p.h(paramc, "reason");
      paraml = mergeDataAndNotify(paraml.EN, paraml.sdi, paraml.isNeedClear, paraml.request);
      paramc.hNZ = paraml;
      paramc.Lrj = paraml.scY;
      AppMethodBeat.o(202532);
    }
    
    public int findMergeIndex(ArrayList<T> paramArrayList, List<? extends T> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(202527);
      p.h(paramArrayList, "srcList");
      p.h(paramList, "newList");
      if ((paramInt == 1) || (paramInt == 5))
      {
        paramInt = this.this$0.getDataList().size();
        AppMethodBeat.o(202527);
        return paramInt;
      }
      if ((paramInt == 2) || (paramInt == 6) || (paramInt == 4))
      {
        AppMethodBeat.o(202527);
        return 0;
      }
      AppMethodBeat.o(202527);
      return 0;
    }
    
    public android.support.v7.h.d getListUpdateCallback()
    {
      AppMethodBeat.i(202533);
      android.support.v7.h.d locald = (android.support.v7.h.d)new a(this);
      AppMethodBeat.o(202533);
      return locald;
    }
    
    protected final j merge(List<? extends T> paramList, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(202530);
      p.h(paramList, "newList");
      printList("newList", paramInt, paramList);
      DataBuffer localDataBuffer = this.this$0.getDataList();
      LinkedList localLinkedList1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      paramList = ((Iterable)paramList).iterator();
      int i;
      while (paramList.hasNext())
      {
        i locali = (i)paramList.next();
        Object localObject = (List)localDataBuffer;
        i = 0;
        localObject = ((List)localObject).iterator();
        label95:
        int k;
        if (((Iterator)localObject).hasNext()) {
          if (((i)((Iterator)localObject).next()).a(locali) == 0)
          {
            j = 1;
            label128:
            if (j == 0) {
              break label223;
            }
            j = i;
            label137:
            localObject = (List)localLinkedList1;
            i = 0;
            localObject = ((List)localObject).iterator();
            label156:
            if (!((Iterator)localObject).hasNext()) {
              break label253;
            }
            if (((i)((Iterator)localObject).next()).a(locali) != 0) {
              break label238;
            }
            k = 1;
            label189:
            if (k == 0) {
              break label244;
            }
          }
        }
        for (;;)
        {
          if ((j != -1) || (i != -1)) {
            break label259;
          }
          localLinkedList1.add(locali);
          break;
          j = 0;
          break label128;
          label223:
          i += 1;
          break label95;
          j = -1;
          break label137;
          label238:
          k = 0;
          break label189;
          label244:
          i += 1;
          break label156;
          label253:
          i = -1;
        }
        label259:
        if (j != -1)
        {
          localDataBuffer.set(j, locali);
          localLinkedList2.add(Integer.valueOf(j));
        }
        else
        {
          ad.w(this.this$0.getTAG(), "newList exist a same feed[" + (i)localLinkedList1.get(i) + "], just ignore this feed=" + locali + " existIndex=" + j + " existIndexInIncrementList=" + i);
        }
      }
      printList("incrementList", paramInt, (List)localLinkedList1);
      int j = 0;
      boolean bool = false;
      if (localLinkedList1.size() > 0)
      {
        i = 1;
        if (i == 0) {
          break label551;
        }
      }
      label551:
      for (paramList = localLinkedList1;; paramList = null)
      {
        i = j;
        if (paramList != null)
        {
          i = findMergeIndex((ArrayList)localDataBuffer, (List)localLinkedList1, paramInt, paramObject);
          bool = finallyHandleMergeList((ArrayList)localDataBuffer, localLinkedList1, i, paramInt, paramObject);
          ad.i(this.this$0.getTAG(), "merge list index " + i + " incrementList:" + localLinkedList1.size() + " cmd=" + paramInt);
          localDataBuffer.addAll(i, (Collection)localLinkedList1);
        }
        paramList = new j(i, localLinkedList1.size(), localLinkedList2, bool);
        printList("dataList", paramInt, (List)this.this$0.getDataList());
        AppMethodBeat.o(202530);
        return paramList;
        i = 0;
        break;
      }
    }
    
    public j mergeDataAndNotify(int paramInt, List<? extends T> paramList, boolean paramBoolean, Object paramObject)
    {
      AppMethodBeat.i(202529);
      if (paramList == null)
      {
        paramList = new j(new LinkedList());
        AppMethodBeat.o(202529);
        return paramList;
      }
      if (!paramBoolean)
      {
        ad.i(this.this$0.getTAG(), "nothing need to notify, just return. cmd=" + paramInt + " size =" + paramList.size());
        paramList = new j(new LinkedList());
        AppMethodBeat.o(202529);
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
            this.this$0.dispatcher().av(0, j);
          }
        }
      }
      paramList = merge(paramList, paramInt, paramObject);
      paramObject = this.this$0.getTAG();
      StringBuilder localStringBuilder = new StringBuilder("mergeDataAndNotify insertIndex=").append(paramList.scX).append(" insertCount=").append(paramList.scY).append(" changeIndex=").append(paramList.scZ).append(' ').append("size: ").append(this.this$0.getDataList().size()).append(" isRemoveBeforeInsert=").append(paramList.sda).append(" loader:").append(getClass().getSimpleName()).append(" cmd:");
      l.a locala = l.sdj;
      ad.i(paramObject, l.a.EF(paramInt) + '}');
      if (!((Collection)paramList.scZ).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (paramList.scY > 0)) {
          break label422;
        }
        ad.i(this.this$0.getTAG(), "just change all. cmd=".concat(String.valueOf(paramInt)));
        this.this$0.dispatcher().onChanged();
        AppMethodBeat.o(202529);
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
        AppMethodBeat.o(202529);
        return paramList;
        if (paramList.sda)
        {
          paramObject = this.this$0.dispatcher();
          paramInt = paramList.scX;
          paramObject.av(paramInt, j - paramInt);
        }
        this.this$0.dispatcher().au(paramList.scX, paramList.scY);
      }
    }
    
    public void mergeInit(final IResponse<T> paramIResponse, final d.g.a.b<? super IResponse<T>, z> paramb)
    {
      AppMethodBeat.i(202523);
      p.h(paramIResponse, "response");
      if (paramIResponse.getIncrementList() == null) {
        paramIResponse.setIncrementList((List)v.MKE);
      }
      String str = this.this$0.getTAG();
      StringBuilder localStringBuilder = new StringBuilder("initData dataFetch.initData ");
      Object localObject = paramIResponse.getIncrementList();
      if (localObject != null) {}
      for (localObject = Integer.valueOf(((List)localObject).size());; localObject = null)
      {
        ad.i(str, localObject);
        c.g((d.g.a.a)new b(this, paramIResponse, paramb));
        AppMethodBeat.o(202523);
        return;
      }
    }
    
    public void mergeInsert(final IResponse<T> paramIResponse, final d.g.a.b<? super IResponse<T>, z> paramb)
    {
      AppMethodBeat.i(202526);
      p.h(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.Lrp;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fQd());
      ((RefreshLoadMoreLayout.c)localObject).iLW = true;
      ((RefreshLoadMoreLayout.c)localObject).Lri = true;
      final l locall = new l(8, paramIResponse.getIncrementList(), false, 12);
      locall.request = paramIResponse.getRequest();
      c.g((d.g.a.a)new c(this, locall, (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
      AppMethodBeat.o(202526);
    }
    
    public void mergeLoadMore(final IResponse<T> paramIResponse, final d.g.a.b<? super IResponse<T>, z> paramb)
    {
      int i = 1;
      AppMethodBeat.i(202525);
      p.h(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.Lrp;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fQc());
      List localList = paramIResponse.getIncrementList();
      boolean bool;
      if (localList != null)
      {
        bool = localList.isEmpty();
        ((RefreshLoadMoreLayout.c)localObject).iLW = bool;
        ((RefreshLoadMoreLayout.c)localObject).Lri = paramIResponse.getHasMore();
        if (!paramIResponse.getHasMore()) {
          break label121;
        }
      }
      for (;;)
      {
        c.g((d.g.a.a)new d(this, new l(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
        AppMethodBeat.o(202525);
        return;
        bool = true;
        break;
        label121:
        i = 5;
      }
    }
    
    public void mergeRefresh(final IResponse<T> paramIResponse, final d.g.a.b<? super IResponse<T>, z> paramb)
    {
      AppMethodBeat.i(202524);
      p.h(paramIResponse, "response");
      Object localObject = RefreshLoadMoreLayout.c.Lrp;
      localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fQb());
      if (paramIResponse.getHasMore()) {}
      for (int i = 2;; i = 6)
      {
        c.g((d.g.a.a)new e(this, new l(i, paramIResponse.getIncrementList(), false, 12), (RefreshLoadMoreLayout.c)localObject, paramb, paramIResponse));
        AppMethodBeat.o(202524);
        return;
      }
    }
    
    public final void printList(String paramString, int paramInt, List<? extends T> paramList)
    {
      AppMethodBeat.i(202534);
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
            d.a.j.gfB();
          }
          localObject = (i)localObject;
          String str = this.this$0.getTAG();
          StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(" index ").append(i).append(" cmd:");
          l.a locala = l.sdj;
          ad.i(str, l.a.EF(paramInt) + ' ' + localObject);
          i += 1;
        }
      }
      AppMethodBeat.o(202534);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger$getListUpdateCallback$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "positionStart", "", "itemCount", "payload", "", "onInserted", "onMoved", "p0", "p1", "onRemoved", "plugin-finder_release"})
    public static final class a
      implements android.support.v7.h.d
    {
      public final void c(int paramInt1, int paramInt2, Object paramObject)
      {
        AppMethodBeat.i(202516);
        this.scz.this$0.dispatcher().f(paramInt1, paramInt2, paramObject);
        AppMethodBeat.o(202516);
      }
      
      public final void f(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(202517);
        this.scz.this$0.dispatcher().au(paramInt1, paramInt2);
        AppMethodBeat.o(202517);
      }
      
      public final void k(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(202518);
        this.scz.this$0.dispatcher().av(paramInt1, paramInt2);
        AppMethodBeat.o(202518);
      }
      
      public final void l(int paramInt1, int paramInt2) {}
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(BaseFeedLoader.a parama, IResponse paramIResponse, d.g.a.b paramb)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<z>
    {
      c(BaseFeedLoader.a parama, l paraml, RefreshLoadMoreLayout.c paramc, d.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    static final class d
      extends q
      implements d.g.a.a<z>
    {
      d(BaseFeedLoader.a parama, l paraml, RefreshLoadMoreLayout.c paramc, d.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    static final class e
      extends q
      implements d.g.a.a<z>
    {
      e(BaseFeedLoader.a parama, l paraml, RefreshLoadMoreLayout.c paramc, d.g.a.b paramb, IResponse paramIResponse)
      {
        super();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<g<T>>
  {
    b(BaseFeedLoader paramBaseFeedLoader)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<IResponse<T>, z>
  {
    c(BaseFeedLoader paramBaseFeedLoader)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<IResponse<T>, z>
  {
    d(BaseFeedLoader paramBaseFeedLoader, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<IResponse<T>, z>
  {
    e(BaseFeedLoader paramBaseFeedLoader, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<IResponse<T>, z>
  {
    f(BaseFeedLoader paramBaseFeedLoader, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(BaseFeedLoader paramBaseFeedLoader)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
 * JD-Core Version:    0.7.0.1
 */