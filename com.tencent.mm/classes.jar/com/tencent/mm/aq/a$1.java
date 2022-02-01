package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.misc.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;

final class a$1
  implements a.a
{
  a$1(a parama) {}
  
  public final void dM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199614);
    Log.i("MicroMsg.CdnTransportEngine", "simtype " + paramInt1 + " reason " + paramInt2);
    a.a(this.lHH, false);
    if ((paramInt2 == 3) && (paramInt1 == 1))
    {
      a.a(this.lHH, true);
      Log.w("MicroMsg.CdnTransportEngine", "simfree user.");
    }
    AppMethodBeat.o(199614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.aq.a.1
 * JD-Core Version:    0.7.0.1
 */