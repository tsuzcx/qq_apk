package com.tencent.mm.an;

import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;

final class b$4
  extends n.a
{
  b$4(b paramb) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(150393);
    ae.d("MicroMsg.CdnTransportService", "cdntra onNetworkChange st:%d ", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 4) && (paramInt != 6))
    {
      AppMethodBeat.o(150393);
      return;
    }
    if (!g.ajP().aiZ())
    {
      AppMethodBeat.o(150393);
      return;
    }
    b.a(this.hWL).removeMessages(1);
    if (!ak.foA()) {
      Mars.onNetworkChange();
    }
    AppMethodBeat.o(150393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.b.4
 * JD-Core Version:    0.7.0.1
 */