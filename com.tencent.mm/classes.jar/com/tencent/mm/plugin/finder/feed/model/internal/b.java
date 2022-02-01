package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.mm.an.c.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.dyy;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchCgi;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "dead", "", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "requestCgi", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "resp", "fetch", "request", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchPreload", "fetchRefresh", "genLoadMoreCgi", "genRefreshCgi", "plugin-finder-base_release"})
public abstract class b
  extends i<bu>
{
  private final com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> xbq = new com.tencent.mm.vending.e.c();
  
  public abstract IResponse<bu> a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.c<? extends dyy> paramc, dyy paramdyy);
  
  public IResponse<bu> callInit()
  {
    return (IResponse)new e();
  }
  
  public void dead()
  {
    super.dead();
    this.xbq.dead();
  }
  
  public abstract com.tencent.mm.an.c<? extends dyy> duq();
  
  public abstract com.tencent.mm.an.c<? extends dyy> dur();
  
  public void fetch(final Object paramObject, final h<bu> paramh)
  {
    p.k(paramh, "callback");
    if ((paramObject != null) && ((paramObject instanceof com.tencent.mm.an.c))) {
      ((com.tencent.mm.an.c)paramObject).bhW().a((com.tencent.mm.vending.e.b)this.xbq).g((com.tencent.mm.vending.c.a)new a(this, paramObject, paramh));
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
    fetch(dur(), paramh);
  }
  
  public void fetchPreload(h<bu> paramh)
  {
    p.k(paramh, "callback");
    super.fetchPreload(paramh);
    fetch(duq(), paramh);
  }
  
  public void fetchRefresh(h<bu> paramh)
  {
    p.k(paramh, "callback");
    fetch(duq(), paramh);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(b paramb, Object paramObject, h paramh) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.b
 * JD-Core Version:    0.7.0.1
 */