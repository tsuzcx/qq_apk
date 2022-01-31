package com.tencent.mm.al;

import com.tencent.mars.BaseEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class b$3
  extends n.a
{
  b$3(b paramb) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(78033);
    ab.d("MicroMsg.CdnTransportService", "cdntra onNetworkChange st:%d ", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 4) && (paramInt != 6))
    {
      AppMethodBeat.o(78033);
      return;
    }
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(78033);
      return;
    }
    this.fyR.fyH.removeMessages(1);
    BaseEvent.onNetworkChange();
    AppMethodBeat.o(78033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.al.b.3
 * JD-Core Version:    0.7.0.1
 */