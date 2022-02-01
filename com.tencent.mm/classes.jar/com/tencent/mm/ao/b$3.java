package com.tencent.mm.ao;

import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;

final class b$3
  extends n.a
{
  b$3(b paramb) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(150393);
    ad.d("MicroMsg.CdnTransportService", "cdntra onNetworkChange st:%d ", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 4) && (paramInt != 6))
    {
      AppMethodBeat.o(150393);
      return;
    }
    if (!g.afz().aeI())
    {
      AppMethodBeat.o(150393);
      return;
    }
    this.haP.haF.removeMessages(1);
    if (!aj.eFH()) {
      Mars.onNetworkChange();
    }
    AppMethodBeat.o(150393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ao.b.3
 * JD-Core Version:    0.7.0.1
 */