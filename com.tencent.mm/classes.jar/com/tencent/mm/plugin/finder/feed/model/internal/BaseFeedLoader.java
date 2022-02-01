package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Dispatcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "()V", "dataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "getDataFetch", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "dataFetch$delegate", "Lkotlin/Lazy;", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "getInitDone", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "setInitDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "createDataFetch", "createDataMerger", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataMerger;", "isInitOperation", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "isInsertOperation", "isRefreshOperation", "onAlive", "", "onDead", "onFetchDone", "onFetchInitDone", "initResponse", "onFetchInsertedDone", "onFetchLoadMoreDone", "onFetchRefreshDone", "request", "", "callback", "requestInit", "isSyncLoad", "requestInsert", "requestLoadMore", "requestRefresh", "DefaultDataMerger", "plugin-finder_release"})
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
    return (b)new BaseFeedLoader.a(this);
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
    ae.i(getTAG(), "onAlive");
    getDataFetch().alive();
  }
  
  public void onDead()
  {
    ae.i(getTAG(), "onDead");
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
    ae.i(getTAG(), "request");
    if (paramf == null)
    {
      getDataFetch().fetch(paramObject, (f)this);
      return;
    }
    getDataFetch().fetch(paramObject, paramf);
  }
  
  public final void requestInit(boolean paramBoolean)
  {
    ae.i(getTAG(), "initData from " + bu.fpN());
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
    ae.i(getTAG(), "requestInsert ".concat(String.valueOf(paramObject)));
    request$default(this, paramObject, null, 2, null);
  }
  
  public void requestLoadMore()
  {
    ae.i(getTAG(), "requestLoadMore");
    getDataFetch().fetchLoadMore((f)this);
  }
  
  public void requestRefresh()
  {
    ae.i(getTAG(), "requestRefresh");
    getDataFetch().fetchRefresh((f)this);
  }
  
  public final void setInitDone(h paramh)
  {
    this.initDone = paramh;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<g<T>>
  {
    b(BaseFeedLoader paramBaseFeedLoader)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<IResponse<T>, z>
  {
    c(BaseFeedLoader paramBaseFeedLoader)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<IResponse<T>, z>
  {
    d(BaseFeedLoader paramBaseFeedLoader, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<IResponse<T>, z>
  {
    e(BaseFeedLoader paramBaseFeedLoader, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<IResponse<T>, z>
  {
    f(BaseFeedLoader paramBaseFeedLoader, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
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