package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class d$2
  implements ap.a
{
  d$2(d paramd, boolean paramBoolean) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(21819);
    if (!this.nOb)
    {
      ab.i("MicroMsg.IPCallSensorManager", "off screen");
      if (this.nOa.nNZ != null) {
        this.nOa.nNZ.iG(true);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(21819);
      return false;
      ab.i("MicroMsg.IPCallSensorManager", "light screen");
      if (this.nOa.nNZ != null) {
        this.nOa.nNZ.iG(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.b.d.2
 * JD-Core Version:    0.7.0.1
 */