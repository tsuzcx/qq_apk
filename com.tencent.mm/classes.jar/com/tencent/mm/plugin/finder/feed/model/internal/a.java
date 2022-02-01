package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.ac.c;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.f;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "getDataFetch", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "dataFetch$delegate", "Lkotlin/Lazy;", "cleanDataList", "", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "createDataFetch", "fetchData", "request", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "callback", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "initData", "initRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "isSyncLoad", "", "isInsertOperation", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "isRefreshOperation", "mergeDataAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher$MergeResult;", "insList", "isNeedClear", "onAlive", "onDead", "onFetchDone", "onFetchInsertedDone", "onFetchLoadMoreDone", "onFetchRefreshDone", "requestInsert", "requestLoadMore", "requestRefresh", "plugin-finder_release"})
public abstract class a<T extends h>
  extends b<T>
  implements d<T>
{
  private final anm contextObj;
  private final f dataFetch$delegate;
  
  public a()
  {
    this(null, 1, null);
  }
  
  public a(anm paramanm)
  {
    this.contextObj = paramanm;
    this.dataFetch$delegate = d.g.K((d.g.a.a)new a(this));
  }
  
  private final e<Object, Object, h> getDataFetch()
  {
    return (e)this.dataFetch$delegate.getValue();
  }
  
  private final boolean isInsertOperation(IResponse<T> paramIResponse)
  {
    return -1 == paramIResponse.getPullType();
  }
  
  private final boolean isRefreshOperation(IResponse<T> paramIResponse)
  {
    return (1 == paramIResponse.getPullType()) || (paramIResponse.getPullType() == 0) || (4 == paramIResponse.getPullType()) || (3 == paramIResponse.getPullType());
  }
  
  public void cleanDataList(DataBuffer<T> paramDataBuffer)
  {
    d.g.b.k.h(paramDataBuffer, "dataList");
  }
  
  public abstract e<Object, Object, h> createDataFetch(anm paramanm);
  
  public final void fetchData(i parami)
  {
    d.g.b.k.h(parami, "request");
    fetchData(parami, (d)this);
  }
  
  public final void fetchData(i parami, d<h> paramd)
  {
    d.g.b.k.h(parami, "request");
    d.g.b.k.h(paramd, "callback");
    getDataFetch().fetchData(parami, paramd);
  }
  
  public int findMergeIndex(ArrayList<T> paramArrayList, List<? extends T> paramList, int paramInt, i parami)
  {
    int j = 0;
    d.g.b.k.h(paramArrayList, "srcList");
    d.g.b.k.h(paramList, "newList");
    int i;
    if ((paramInt == 1) || (paramInt == 5)) {
      i = getDataList().size();
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramInt == 2);
        i = j;
      } while (paramInt == 6);
      i = j;
    } while (paramInt != 4);
    return 0;
  }
  
  public final anm getContextObj()
  {
    return this.contextObj;
  }
  
  public void initData(final g paramg, boolean paramBoolean)
  {
    d.g.b.k.h(paramg, "initRequest");
    ac.i(getTAG(), "initData " + paramg + "  loader:" + getClass().getSimpleName() + " from " + bs.eWi());
    paramg = (d.g.a.a)new c(this, paramg);
    if (paramBoolean)
    {
      paramg.invoke();
      return;
    }
    d.c.a.L((d.g.a.a)new a.b(paramg));
  }
  
  public b.c mergeDataAndNotify(int paramInt, List<? extends T> paramList, boolean paramBoolean, i parami)
  {
    if (paramList == null) {
      return new b.c(new LinkedList());
    }
    if (!paramBoolean)
    {
      ac.i(getTAG(), "nothing need to notify, just return. cmd=" + paramInt + " size =" + paramList.size());
      return new b.c(new LinkedList());
    }
    int j = getDataList().size();
    if (((paramInt == 4) || (paramInt == 7)) && (needCleanWhenRefresh(paramList)))
    {
      if (((Collection)paramList).isEmpty()) {
        break label346;
      }
      i = 1;
      if ((i != 0) || (paramInt == 7))
      {
        cleanDataList(getDataList());
        getDataList().clear();
        if (paramInt == 4) {
          dispatcher().au(0, j);
        }
      }
    }
    paramList = merge(paramList, paramInt, parami);
    parami = getTAG();
    StringBuilder localStringBuilder = new StringBuilder("mergeDataAndNotify insertIndex=").append(paramList.rnS).append(" insertCount=").append(paramList.rnT).append(" changeIndex=").append(paramList.rnU).append(' ').append("size: ").append(getDataList().size()).append("  loader:").append(getClass().getSimpleName()).append(" cmd:");
    k.a locala = k.roB;
    ac.i(parami, k.a.DL(paramInt) + '}');
    if (!((Collection)paramList.rnU).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (paramList.rnT > 0)) {
        break label358;
      }
      ac.i(getTAG(), "just change all. cmd=".concat(String.valueOf(paramInt)));
      dispatcher().onChanged();
      return paramList;
      label346:
      i = 0;
      break;
    }
    label358:
    if ((paramInt == 3) || (paramInt == 2) || (paramInt == 6) || (paramInt == 7)) {
      dispatcher().onChanged();
    }
    for (;;)
    {
      return paramList;
      if (paramList.rnV)
      {
        parami = dispatcher();
        paramInt = paramList.rnS;
        parami.au(paramInt, j - paramInt);
      }
      c.g((d.g.a.a)new b.a.c(dispatcher(), paramList.rnS, paramList.rnT));
    }
  }
  
  public void onAlive()
  {
    ac.i(getTAG(), "onAlive");
    getDataFetch().alive();
  }
  
  public void onDead()
  {
    ac.i(getTAG(), "onDead");
    getDataFetch().dead();
  }
  
  public void onFetchDone(IResponse<T> paramIResponse)
  {
    d.g.b.k.h(paramIResponse, "response");
    if (isRefreshOperation(paramIResponse))
    {
      onFetchRefreshDone(paramIResponse);
      return;
    }
    if (isInsertOperation(paramIResponse))
    {
      onFetchInsertedDone(paramIResponse);
      return;
    }
    onFetchLoadMoreDone(paramIResponse);
  }
  
  public void onFetchInsertedDone(IResponse<T> paramIResponse)
  {
    d.g.b.k.h(paramIResponse, "response");
    Object localObject = RefreshLoadMoreLayout.c.Jyi;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fyU());
    ((RefreshLoadMoreLayout.c)localObject).isT = true;
    ((RefreshLoadMoreLayout.c)localObject).Jyb = true;
    k localk = new k(8, paramIResponse.getIncrementList(), false, 12);
    localk.request = paramIResponse.getRequest();
    paramIResponse = dispatcher();
    d.g.b.k.h(localk, "op");
    d.g.b.k.h(localObject, "reason");
    c.g((d.g.a.a)new b.a.e(paramIResponse, localk));
  }
  
  public void onFetchLoadMoreDone(IResponse<T> paramIResponse)
  {
    int i = 1;
    d.g.b.k.h(paramIResponse, "response");
    Object localObject = RefreshLoadMoreLayout.c.Jyi;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fyT());
    List localList = paramIResponse.getIncrementList();
    boolean bool;
    if (localList != null)
    {
      bool = localList.isEmpty();
      ((RefreshLoadMoreLayout.c)localObject).isT = bool;
      ((RefreshLoadMoreLayout.c)localObject).Jyb = paramIResponse.getHasMore();
      if (!paramIResponse.getHasMore()) {
        break label99;
      }
    }
    for (;;)
    {
      paramIResponse = new k(i, paramIResponse.getIncrementList(), false, 12);
      dispatcher().b(paramIResponse, (RefreshLoadMoreLayout.c)localObject);
      return;
      bool = true;
      break;
      label99:
      i = 5;
    }
  }
  
  public void onFetchRefreshDone(IResponse<T> paramIResponse)
  {
    d.g.b.k.h(paramIResponse, "response");
    Object localObject = RefreshLoadMoreLayout.c.Jyi;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fyS());
    if (paramIResponse.getHasMore()) {}
    for (int i = 2;; i = 6)
    {
      paramIResponse = new k(i, paramIResponse.getIncrementList(), false, 12);
      dispatcher().a(paramIResponse, (RefreshLoadMoreLayout.c)localObject);
      return;
    }
  }
  
  public void requestInsert(i parami)
  {
    d.g.b.k.h(parami, "request");
  }
  
  public abstract void requestLoadMore();
  
  public final void requestLoadMore(i parami)
  {
    d.g.b.k.h(parami, "request");
  }
  
  public abstract void requestRefresh();
  
  public void requestRefresh(i parami)
  {
    d.g.b.k.h(parami, "request");
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "T", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<e<Object, Object, h>>
  {
    a(a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(a parama, g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.a
 * JD-Core Version:    0.7.0.1
 */