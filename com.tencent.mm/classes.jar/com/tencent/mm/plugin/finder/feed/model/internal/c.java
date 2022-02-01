package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.finder.model.bu;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "map", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "dead", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "fetch", "netscene", "", "callback", "fetchInit", "fetchLoadMore", "fetchPreload", "fetchRefresh", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "onSceneEnd", "plugin-finder-base_release"})
public abstract class c
  extends i<bu>
  implements com.tencent.mm.an.i
{
  private final Map<q, h<bu>> map = (Map)new LinkedHashMap();
  
  public void alive()
  {
    super.alive();
    Iterator localIterator = ((Iterable)getCmdIds()).iterator();
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      com.tencent.mm.kernel.h.aGY().a(i, (com.tencent.mm.an.i)this);
    }
  }
  
  public IResponse<bu> callInit()
  {
    return (IResponse)new e();
  }
  
  public void dead()
  {
    super.dead();
    Iterator localIterator = ((Iterable)getCmdIds()).iterator();
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      com.tencent.mm.kernel.h.aGY().b(i, (com.tencent.mm.an.i)this);
    }
  }
  
  public abstract IResponse<bu> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public void fetch(Object paramObject, h<bu> paramh)
  {
    p.k(paramh, "callback");
    if ((paramObject != null) && ((paramObject instanceof q)))
    {
      this.map.put(paramObject, paramh);
      com.tencent.mm.kernel.h.aGY().b((q)paramObject);
    }
  }
  
  public void fetchInit(h<bu> paramh)
  {
    p.k(paramh, "callback");
    IResponse localIResponse = callInit();
    localIResponse.setPullType(1000);
    paramh.onFetchDone(localIResponse);
  }
  
  public void fetchLoadMore(h<bu> paramh)
  {
    p.k(paramh, "callback");
    fetch(genLoadMoreNetScene(), paramh);
  }
  
  public void fetchPreload(h<bu> paramh)
  {
    p.k(paramh, "callback");
    super.fetchPreload(paramh);
    fetch(genRefreshNetScene(), paramh);
  }
  
  public void fetchRefresh(h<bu> paramh)
  {
    p.k(paramh, "callback");
    fetch(genRefreshNetScene(), paramh);
  }
  
  public abstract q genLoadMoreNetScene();
  
  public abstract q genRefreshNetScene();
  
  public abstract List<Integer> getCmdIds();
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    p.k(paramq, "scene");
    h localh = (h)this.map.get(paramq);
    if (localh != null)
    {
      this.map.remove(paramq);
      paramString = dealOnSceneEnd(paramInt1, paramInt2, paramString, paramq);
      if (paramString != null) {
        localh.onFetchDone(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.c
 * JD-Core Version:    0.7.0.1
 */