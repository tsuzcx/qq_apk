package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class o$2
  implements WakerLock.IAutoUnlockCallback
{
  o$2(o paramo) {}
  
  public final void autoUnlockCallback()
  {
    AppMethodBeat.i(146145);
    ab.e("MicroMsg.SyncService", "ERROR: %s auto unlock syncWakerLock", new Object[] { o.a(this.fJA) });
    o.b(o.a(this.fJA));
    AppMethodBeat.o(146145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.2
 * JD-Core Version:    0.7.0.1
 */