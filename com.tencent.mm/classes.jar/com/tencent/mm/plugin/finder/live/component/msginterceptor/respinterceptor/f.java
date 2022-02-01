package com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.a.a;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.e;
import com.tencent.mm.plugin.finder.live.model.af;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.protocal.protobuf.azp;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/respinterceptor/LiveMsgRespCmdInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IAfterCheckInterceptor;", "()V", "intercept", "", "respWrapper", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends e
{
  public final boolean a(a.a parama)
  {
    AppMethodBeat.i(353205);
    s.u(parama, "respWrapper");
    parama = parama.CBm;
    if (parama != null)
    {
      Object localObject = parama.ZKf;
      if (localObject != null)
      {
        aj localaj = aj.CGT;
        aj.elm().gt((List)localObject);
      }
      parama = parama.ZKe;
      if (parama != null)
      {
        localObject = aj.CGT;
        aj.elm().gs((List)parama);
      }
    }
    AppMethodBeat.o(353205);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.f
 * JD-Core Version:    0.7.0.1
 */