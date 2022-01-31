package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class f$4
  implements ap.a
{
  f$4(f paramf) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(18337);
    ab.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]make isScanning status false");
    f.aVQ();
    AppMethodBeat.o(18337);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.f.4
 * JD-Core Version:    0.7.0.1
 */