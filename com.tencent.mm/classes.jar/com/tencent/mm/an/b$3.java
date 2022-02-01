package com.tencent.mm.an;

import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;

final class b$3
  extends n.a
{
  b$3(b paramb) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(150393);
    ac.d("MicroMsg.CdnTransportService", "cdntra onNetworkChange st:%d ", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 4) && (paramInt != 6))
    {
      AppMethodBeat.o(150393);
      return;
    }
    if (!g.agP().afY())
    {
      AppMethodBeat.o(150393);
      return;
    }
    this.hBq.hBg.removeMessages(1);
    if (!ai.eVb()) {
      Mars.onNetworkChange();
    }
    AppMethodBeat.o(150393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.b.3
 * JD-Core Version:    0.7.0.1
 */