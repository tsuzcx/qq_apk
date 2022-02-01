package com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.a.a;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.b;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.c;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.d;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.g;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.h;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.i;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.j;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.k;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.l;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.m;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.n;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.o;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.q;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.r;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.f;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/respinterceptor/LiveMsgRespAppMsgInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IAfterCheckInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "msgInterceptorChain", "", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "intercept", "", "respWrapper", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.plugin.finder.live.component.msginterceptor.e
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  private final List<f> CBY;
  
  public e(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(353179);
    this.CBK = parama;
    this.CBY = kotlin.a.p.listOf(new f[] { (f)new c(this.CBK), (f)new o(this.CBK), (f)new k(this.CBK), (f)new l(this.CBK), (f)new m(this.CBK), (f)new i(this.CBK), (f)new h(this.CBK), (f)new r(this.CBK), (f)new com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.e(this.CBK), (f)new com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.a(this.CBK), (f)new j(this.CBK), (f)new n(this.CBK), (f)new d(this.CBK), (f)new b(this.CBK), (f)new com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.p(this.CBK), (f)new q(this.CBK), (f)new g(this.CBK) });
    AppMethodBeat.o(353179);
  }
  
  public final boolean a(a.a parama)
  {
    AppMethodBeat.i(353188);
    s.u(parama, "respWrapper");
    Iterator localIterator = ((Iterable)this.CBY).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).a(parama);
    }
    AppMethodBeat.o(353188);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.e
 * JD-Core Version:    0.7.0.1
 */