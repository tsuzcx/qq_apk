package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.finder.model.bo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "map", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "dead", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "fetch", "netscene", "", "callback", "fetchInit", "fetchLoadMore", "fetchPreload", "fetchRefresh", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "onSceneEnd", "plugin-finder_release"})
public abstract class a
  extends g<bo>
  implements i
{
  private final Map<q, f<bo>> map = (Map)new LinkedHashMap();
  
  public void alive()
  {
    super.alive();
    Iterator localIterator = ((Iterable)getCmdIds()).iterator();
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      com.tencent.mm.kernel.g.azz().a(i, (i)this);
    }
  }
  
  public IResponse<bo> callInit()
  {
    return (IResponse)new c();
  }
  
  public void dead()
  {
    super.dead();
    Iterator localIterator = ((Iterable)getCmdIds()).iterator();
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      com.tencent.mm.kernel.g.azz().b(i, (i)this);
    }
  }
  
  public abstract IResponse<bo> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public void fetch(Object paramObject, f<bo> paramf)
  {
    p.h(paramf, "callback");
    if ((paramObject != null) && ((paramObject instanceof q)))
    {
      this.map.put(paramObject, paramf);
      com.tencent.mm.kernel.g.azz().b((q)paramObject);
    }
  }
  
  public void fetchInit(f<bo> paramf)
  {
    p.h(paramf, "callback");
    IResponse localIResponse = callInit();
    localIResponse.setPullType(1000);
    paramf.onFetchDone(localIResponse);
  }
  
  public void fetchLoadMore(f<bo> paramf)
  {
    p.h(paramf, "callback");
    fetch(genLoadMoreNetScene(), paramf);
  }
  
  public void fetchPreload(f<bo> paramf)
  {
    p.h(paramf, "callback");
    super.fetchPreload(paramf);
    fetch(genRefreshNetScene(), paramf);
  }
  
  public void fetchRefresh(f<bo> paramf)
  {
    p.h(paramf, "callback");
    fetch(genRefreshNetScene(), paramf);
  }
  
  public abstract q genLoadMoreNetScene();
  
  public abstract q genRefreshNetScene();
  
  public abstract List<Integer> getCmdIds();
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    p.h(paramq, "scene");
    f localf = (f)this.map.get(paramq);
    if (localf != null)
    {
      this.map.remove(paramq);
      paramString = dealOnSceneEnd(paramInt1, paramInt2, paramString, paramq);
      if (paramString != null) {
        localf.onFetchDone(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.a
 * JD-Core Version:    0.7.0.1
 */