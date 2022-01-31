package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class aa$1
  implements ap.a
{
  aa$1(aa paramaa) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(19358);
    ab.i("MicroMsg.exdevice.ScanDeviceLogic", "Restart scanning...");
    ad.bqf().a(0, this.lFJ);
    AppMethodBeat.o(19358);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.aa.1
 * JD-Core Version:    0.7.0.1
 */