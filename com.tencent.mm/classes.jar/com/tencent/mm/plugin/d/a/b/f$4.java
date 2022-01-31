package com.tencent.mm.plugin.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class f$4
  implements Runnable
{
  f$4(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(18423);
    if (f.k(this.jOO))
    {
      if (f.i(this.jOO) != null) {
        f.i(this.jOO).a(f.g(this.jOO), false, f.l(this.jOO));
      }
      ab.d("MicroMsg.exdevice.BluetoothLESimpleSession", "close timeout!!! stop handle thread.");
      f.m(this.jOO);
    }
    AppMethodBeat.o(18423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.f.4
 * JD-Core Version:    0.7.0.1
 */