package com.tencent.mm.modelcdntran;

import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class g$3
  extends p.a
{
  g$3(g paramg) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(150393);
    Log.d("MicroMsg.CdnTransportService", "cdntra onNetworkChange st:%d ", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 4) && (paramInt != 6))
    {
      AppMethodBeat.o(150393);
      return;
    }
    if (!h.baC().aZN())
    {
      AppMethodBeat.o(150393);
      return;
    }
    g.a(this.oAA).removeMessages(1);
    if (!MMApplicationContext.isPushProcess()) {
      Mars.onNetworkChange();
    }
    AppMethodBeat.o(150393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelcdntran.g.3
 * JD-Core Version:    0.7.0.1
 */