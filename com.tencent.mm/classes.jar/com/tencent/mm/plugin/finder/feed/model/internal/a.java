package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "getDataFetch", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "dataFetch$delegate", "Lkotlin/Lazy;", "createDataFetch", "fetchData", "", "request", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "callback", "findMergeIndex", "", "srcList", "Ljava/util/ArrayList;", "newList", "", "cmd", "initData", "initRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "isSyncLoad", "", "isInsertOperation", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "isRefreshOperation", "mergeDataAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher$MergeResult;", "insList", "isNeedClear", "onAlive", "onDead", "onFetchDone", "onFetchInsertedDone", "onFetchLoadMoreDone", "onFetchRefreshDone", "requestInsert", "requestLoadMore", "requestRefresh", "plugin-finder_release"})
public abstract class a<T extends i>
  extends c<T>
  implements e<T>
{
  private final dzp contextObj;
  private final d.f dataFetch$delegate;
  
  public a()
  {
    this(null, 1, null);
  }
  
  public a(dzp paramdzp)
  {
    this.contextObj = paramdzp;
    this.dataFetch$delegate = g.E((d.g.a.a)new a(this));
  }
  
  private final f<Object, Object, i> getDataFetch()
  {
    return (f)this.dataFetch$delegate.getValue();
  }
  
  private final boolean isInsertOperation(IResponse<T> paramIResponse)
  {
    return -1 == paramIResponse.getPullType();
  }
  
  private final boolean isRefreshOperation(IResponse<T> paramIResponse)
  {
    return (1 == paramIResponse.getPullType()) || (paramIResponse.getPullType() == 0) || (4 == paramIResponse.getPullType()) || (3 == paramIResponse.getPullType());
  }
  
  public abstract f<Object, Object, i> createDataFetch(dzp paramdzp);
  
  public final void fetchData(j paramj)
  {
    k.h(paramj, "request");
    fetchData(paramj, (e)this);
  }
  
  public final void fetchData(j paramj, e<i> parame)
  {
    k.h(paramj, "request");
    k.h(parame, "callback");
    getDataFetch().fetchData(paramj, parame);
  }
  
  public int findMergeIndex(ArrayList<T> paramArrayList, List<? extends T> paramList, int paramInt, j paramj)
  {
    int j = 0;
    k.h(paramArrayList, "srcList");
    k.h(paramList, "newList");
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
  
  public final dzp getContextObj()
  {
    return this.contextObj;
  }
  
  public void initData(final h paramh, boolean paramBoolean)
  {
    k.h(paramh, "initRequest");
    ad.i(getTAG(), "initData " + paramh + "  loader:" + getClass().getSimpleName() + " from " + bt.eGN());
    paramh = (d.g.a.a)new b(this, paramh);
    if (paramBoolean)
    {
      paramh.invoke();
      return;
    }
    d.c.a.V((d.g.a.a)new c(paramh));
  }
  
  public c.c mergeDataAndNotify(int paramInt, List<? extends T> paramList, boolean paramBoolean, j paramj)
  {
    if (paramList == null) {
      return new c.c(new LinkedList());
    }
    if (!paramBoolean)
    {
      ad.i(getTAG(), "nothing need to notify, just return. cmd=" + paramInt + " size =" + paramList.size());
      return new c.c(new LinkedList());
    }
    int j = getDataList().size();
    if (((paramInt == 4) || (paramInt == 7)) && (needCleanWhenRefresh(paramList)))
    {
      if (((Collection)paramList).isEmpty()) {
        break label338;
      }
      i = 1;
      if ((i != 0) || (paramInt == 7))
      {
        getDataList().clear();
        if (paramInt == 4) {
          dispatcher().au(0, j);
        }
      }
    }
    paramList = merge(paramList, paramInt, paramj);
    paramj = getTAG();
    StringBuilder localStringBuilder = new StringBuilder("mergeDataAndNotify insertIndex=").append(paramList.qzm).append(" insertCount=").append(paramList.qzn).append(" changeIndex=").append(paramList.qzo).append(' ').append("size: ").append(getDataList().size()).append("  loader:").append(getClass().getSimpleName()).append(" cmd:");
    l.a locala = l.qzA;
    ad.i(paramj, l.a.CI(paramInt) + '}');
    if (!((Collection)paramList.qzo).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (paramList.qzn > 0)) {
        break label350;
      }
      ad.i(getTAG(), "just change all. cmd=".concat(String.valueOf(paramInt)));
      dispatcher().onChanged();
      return paramList;
      label338:
      i = 0;
      break;
    }
    label350:
    if ((paramInt == 3) || (paramInt == 2) || (paramInt == 6) || (paramInt == 7)) {
      dispatcher().onChanged();
    }
    for (;;)
    {
      return paramList;
      if (paramList.KQx)
      {
        paramj = dispatcher();
        paramInt = paramList.qzm;
        paramj.au(paramInt, j - paramInt);
      }
      com.tencent.mm.ad.c.g((d.g.a.a)new c.a.c(dispatcher(), paramList.qzm, paramList.qzn));
    }
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
  
  public void onFetchDone(IResponse<T> paramIResponse)
  {
    k.h(paramIResponse, "response");
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
    k.h(paramIResponse, "response");
    Object localObject = RefreshLoadMoreLayout.c.HXu;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.gaw());
    ((RefreshLoadMoreLayout.c)localObject).hSO = true;
    ((RefreshLoadMoreLayout.c)localObject).HXq = true;
    l locall = new l(8, paramIResponse.getIncrementList(), false, 12);
    locall.request = paramIResponse.getRequest();
    paramIResponse = dispatcher();
    k.h(locall, "op");
    k.h(localObject, "reason");
    com.tencent.mm.ad.c.g((d.g.a.a)new c.a.g(paramIResponse, locall));
  }
  
  public void onFetchLoadMoreDone(IResponse<T> paramIResponse)
  {
    int i = 1;
    k.h(paramIResponse, "response");
    Object localObject = RefreshLoadMoreLayout.c.HXu;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fiI());
    List localList = paramIResponse.getIncrementList();
    boolean bool;
    if (localList != null)
    {
      bool = localList.isEmpty();
      ((RefreshLoadMoreLayout.c)localObject).hSO = bool;
      ((RefreshLoadMoreLayout.c)localObject).HXq = paramIResponse.getHasMore();
      if (!paramIResponse.getHasMore()) {
        break label99;
      }
    }
    for (;;)
    {
      paramIResponse = new l(i, paramIResponse.getIncrementList(), false, 12);
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
    k.h(paramIResponse, "response");
    Object localObject = RefreshLoadMoreLayout.c.HXu;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fiH());
    if (paramIResponse.getHasMore()) {}
    for (int i = 2;; i = 6)
    {
      paramIResponse = new l(i, paramIResponse.getIncrementList(), false, 12);
      dispatcher().a(paramIResponse, (RefreshLoadMoreLayout.c)localObject);
      return;
    }
  }
  
  public void requestInsert(j paramj)
  {
    k.h(paramj, "request");
  }
  
  public abstract void requestLoadMore();
  
  public final void requestLoadMore(j paramj)
  {
    k.h(paramj, "request");
  }
  
  public abstract void requestRefresh();
  
  public void requestRefresh(j paramj)
  {
    k.h(paramj, "request");
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "T", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<f<Object, Object, i>>
  {
    a(a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(a parama, h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(d.g.a.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.a
 * JD-Core Version:    0.7.0.1
 */