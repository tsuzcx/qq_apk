package com.tencent.mm.modelcdntran;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.misc.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;

final class d$1
  implements a.a
{
  d$1(d paramd) {}
  
  public final void onSIMCardChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237826);
    Log.i("MicroMsg.CdnTransportEngine", "simtype " + paramInt1 + " reason " + paramInt2);
    d.a(this.ozI, false);
    if ((paramInt2 == 3) && (paramInt1 == 1))
    {
      d.a(this.ozI, true);
      Log.w("MicroMsg.CdnTransportEngine", "simfree user.");
    }
    AppMethodBeat.o(237826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelcdntran.d.1
 * JD-Core Version:    0.7.0.1
 */