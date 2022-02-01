package com.tencent.mm.plugin.finder.live.component.msginterceptor;

import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IAfterCheckInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveMsgRespInterceptor;", "()V", "intercept", "", "cgiResp", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp;", "respWrapper", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e
  implements h
{
  public abstract boolean a(a.a parama);
  
  public final boolean b(a parama)
  {
    s.u(parama, "cgiResp");
    parama = parama.CBl;
    if (parama == null) {}
    for (parama = null; parama == null; parama = Boolean.TRUE)
    {
      return false;
      a(parama);
    }
    return parama.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.e
 * JD-Core Version:    0.7.0.1
 */