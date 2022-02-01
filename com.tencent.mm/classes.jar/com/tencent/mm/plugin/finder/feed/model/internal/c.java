package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.model.cc;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "map", "", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "dead", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "fetch", "netscene", "", "callback", "isAuto", "", "fetchInit", "fetchLoadMore", "fetchPreload", "fetchRefresh", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "onSceneEnd", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends i<cc>
  implements com.tencent.mm.am.h
{
  private final Map<p, h<cc>> map = (Map)new LinkedHashMap();
  
  public void alive()
  {
    super.alive();
    Iterator localIterator = ((Iterable)getCmdIds()).iterator();
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      com.tencent.mm.kernel.h.aZW().a(i, (com.tencent.mm.am.h)this);
    }
  }
  
  public IResponse<cc> callInit()
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
      com.tencent.mm.kernel.h.aZW().b(i, (com.tencent.mm.am.h)this);
    }
  }
  
  public abstract IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp);
  
  public void fetch(Object paramObject, h<cc> paramh, boolean paramBoolean)
  {
    kotlin.g.b.s.u(paramh, "callback");
    if ((paramObject != null) && ((paramObject instanceof p)))
    {
      this.map.put(paramObject, paramh);
      com.tencent.mm.kernel.h.aZW().a((p)paramObject, 0);
    }
  }
  
  public void fetchInit(h<cc> paramh)
  {
    kotlin.g.b.s.u(paramh, "callback");
    IResponse localIResponse = callInit();
    localIResponse.setPullType(1000);
    ah localah = ah.aiuX;
    paramh.onFetchDone(localIResponse);
  }
  
  public void fetchLoadMore(h<cc> paramh, boolean paramBoolean)
  {
    kotlin.g.b.s.u(paramh, "callback");
    p localp = genLoadMoreNetScene();
    i.fetch$default((i)this, localp, paramh, false, 4, null);
  }
  
  public void fetchPreload(h<cc> paramh)
  {
    kotlin.g.b.s.u(paramh, "callback");
    super.fetchPreload(paramh);
    p localp = genRefreshNetScene();
    i.fetch$default((i)this, localp, paramh, false, 4, null);
  }
  
  public void fetchRefresh(h<cc> paramh)
  {
    kotlin.g.b.s.u(paramh, "callback");
    p localp = genRefreshNetScene();
    i.fetch$default((i)this, localp, paramh, false, 4, null);
  }
  
  public abstract p genLoadMoreNetScene();
  
  public abstract p genRefreshNetScene();
  
  public abstract List<Integer> getCmdIds();
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    kotlin.g.b.s.u(paramp, "scene");
    h localh = (h)this.map.get(paramp);
    if (localh != null)
    {
      this.map.remove(paramp);
      paramString = dealOnSceneEnd(paramInt1, paramInt2, paramString, paramp);
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