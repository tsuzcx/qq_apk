package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class f$5
  implements ap.a
{
  f$5(f paramf) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(18338);
    ab.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]time out ,let's stop this new method scan");
    f.k(this.jNt);
    AppMethodBeat.o(18338);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.f.5
 * JD-Core Version:    0.7.0.1
 */