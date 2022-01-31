package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class q$3
  extends n.a
{
  q$3(q paramq) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(78791);
    if ((paramInt != 4) && (paramInt != 6))
    {
      AppMethodBeat.o(78791);
      return;
    }
    g.RO().o(new q.3.1(this), 3000L);
    ab.d("MicroMsg.SubCoreStat", "NetTypeReporter st:%d", new Object[] { Integer.valueOf(paramInt) });
    o.run(2);
    AppMethodBeat.o(78791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.q.3
 * JD-Core Version:    0.7.0.1
 */