package com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.a.a;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.e;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.g;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.msg.b;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.msg.c;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/respinterceptor/LiveMsgRespMsgInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IAfterCheckInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "msgInterceptorChain", "", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveMsgInterceptor;", "intercept", "", "respWrapper", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends e
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  private final List<g> CBY;
  
  public j(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(353204);
    this.CBK = parama;
    this.CBY = p.listOf(new g[] { (g)new b(this.CBK), (g)new com.tencent.mm.plugin.finder.live.component.msginterceptor.msg.a(this.CBK), (g)new c(this.CBK) });
    AppMethodBeat.o(353204);
  }
  
  public final boolean a(a.a parama)
  {
    AppMethodBeat.i(353217);
    s.u(parama, "respWrapper");
    Iterator localIterator = ((Iterable)this.CBY).iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).a(parama);
    }
    AppMethodBeat.o(353217);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.j
 * JD-Core Version:    0.7.0.1
 */