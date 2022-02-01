package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.cgi.ba.a;
import com.tencent.mm.protocal.protobuf.bif;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$getProductReplayUrl$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiGetProductReplayUrl$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetReplayUrlResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$o
  implements ba.a
{
  f$o(m<? super Boolean, ? super bif, ah> paramm) {}
  
  public final void a(int paramInt1, int paramInt2, bif parambif)
  {
    AppMethodBeat.i(359620);
    s.u(parambif, "resp");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      m localm = this.tGw;
      if (localm != null)
      {
        localm.invoke(Boolean.TRUE, parambif);
        AppMethodBeat.o(359620);
      }
    }
    else
    {
      parambif = this.tGw;
      if (parambif != null) {
        parambif.invoke(Boolean.FALSE, null);
      }
    }
    AppMethodBeat.o(359620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.f.o
 * JD-Core Version:    0.7.0.1
 */