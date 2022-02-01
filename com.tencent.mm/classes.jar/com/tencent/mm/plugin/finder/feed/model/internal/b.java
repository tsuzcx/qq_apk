package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.vending.e.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchCgi;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "alive", "", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "dead", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "requestCgi", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "resp", "fetch", "request", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "isAuto", "", "fetchInit", "fetchLoadMore", "fetchPreload", "fetchRefresh", "genLoadMoreCgi", "genRefreshCgi", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  extends i<cc>
{
  private c<com.tencent.mm.vending.e.a> AAh = new c();
  
  private static final ah g(kotlin.g.a.b paramb, Object paramObject)
  {
    s.u(paramb, "$tmp0");
    return (ah)paramb.invoke(paramObject);
  }
  
  public abstract IResponse<cc> a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.b<? extends esc> paramb, esc paramesc);
  
  public void alive()
  {
    super.alive();
    this.AAh = new c();
  }
  
  public IResponse<cc> callInit()
  {
    return (IResponse)new e();
  }
  
  public void dead()
  {
    super.dead();
    this.AAh.dead();
  }
  
  public abstract com.tencent.mm.am.b<? extends esc> edO();
  
  public abstract com.tencent.mm.am.b<? extends esc> edP();
  
  public void fetch(final Object paramObject, final h<cc> paramh, boolean paramBoolean)
  {
    s.u(paramh, "callback");
    if ((paramObject != null) && ((paramObject instanceof com.tencent.mm.am.b))) {
      ((com.tencent.mm.am.b)paramObject).bFJ().a((com.tencent.mm.vending.e.b)this.AAh).g(new b..ExternalSyntheticLambda0((kotlin.g.a.b)new a(this, paramObject, paramh)));
    }
  }
  
  public void fetchInit(h<cc> paramh)
  {
    s.u(paramh, "callback");
    IResponse localIResponse = callInit();
    localIResponse.setPullType(1000);
    ah localah = ah.aiuX;
    paramh.onFetchDone(localIResponse);
  }
  
  public void fetchLoadMore(h<cc> paramh, boolean paramBoolean)
  {
    s.u(paramh, "callback");
    i.fetch$default((i)this, edP(), paramh, false, 4, null);
  }
  
  public void fetchPreload(h<cc> paramh)
  {
    s.u(paramh, "callback");
    super.fetchPreload(paramh);
    i.fetch$default((i)this, edO(), paramh, false, 4, null);
  }
  
  public void fetchRefresh(h<cc> paramh)
  {
    s.u(paramh, "callback");
    i.fetch$default((i)this, edO(), paramh, false, 4, null);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<com.tencent.mm.am.b.a<? extends esc>, ah>
  {
    a(b paramb, Object paramObject, h<cc> paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.b
 * JD-Core Version:    0.7.0.1
 */