package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.model.al;
import d.g.b.p;
import d.l;
import java.util.LinkedHashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "map", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "dead", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "fetch", "netscene", "", "callback", "fetchInit", "fetchLoadMore", "fetchRefresh", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdId", "onSceneEnd", "plugin-finder_release"})
public abstract class a
  extends g<al>
  implements com.tencent.mm.al.f
{
  private final Map<n, f<al>> map = (Map)new LinkedHashMap();
  
  public void alive()
  {
    super.alive();
    com.tencent.mm.kernel.g.aiU().a(getCmdId(), (com.tencent.mm.al.f)this);
  }
  
  public IResponse<al> callInit()
  {
    return (IResponse)new c();
  }
  
  public void dead()
  {
    super.dead();
    com.tencent.mm.kernel.g.aiU().b(getCmdId(), (com.tencent.mm.al.f)this);
  }
  
  public abstract IResponse<al> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn);
  
  public void fetch(Object paramObject, f<al> paramf)
  {
    p.h(paramf, "callback");
    if ((paramObject != null) && ((paramObject instanceof n)))
    {
      this.map.put(paramObject, paramf);
      com.tencent.mm.kernel.g.aiU().b((n)paramObject);
    }
  }
  
  public void fetchInit(f<al> paramf)
  {
    p.h(paramf, "callback");
    IResponse localIResponse = callInit();
    localIResponse.setPullType(1000);
    paramf.onFetchDone(localIResponse);
  }
  
  public void fetchLoadMore(f<al> paramf)
  {
    p.h(paramf, "callback");
    fetch(genLoadMoreNetScene(), paramf);
  }
  
  public void fetchRefresh(f<al> paramf)
  {
    p.h(paramf, "callback");
    fetch(genRefreshNetScene(), paramf);
  }
  
  public abstract n genLoadMoreNetScene();
  
  public abstract n genRefreshNetScene();
  
  public abstract int getCmdId();
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    p.h(paramn, "scene");
    f localf = (f)this.map.get(paramn);
    if (localf != null)
    {
      this.map.remove(paramn);
      paramString = dealOnSceneEnd(paramInt1, paramInt2, paramString, paramn);
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