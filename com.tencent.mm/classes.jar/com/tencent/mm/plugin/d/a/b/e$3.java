package com.tencent.mm.plugin.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class e$3
  implements Runnable
{
  e$3(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(18409);
    this.jOA.jNQ.a(false, this.jOA.jNT);
    ab.i("MicroMsg.exdevice.BluetoothLESimpleManager", "Time out for discovering. Stop it");
    AppMethodBeat.o(18409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.e.3
 * JD-Core Version:    0.7.0.1
 */