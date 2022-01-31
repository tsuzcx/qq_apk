package com.tencent.mm.plugin.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(18363);
    this.jNV.jNP = false;
    this.jNV.fJ(false);
    ab.i("MicroMsg.exdevice.BluetoothLEManager", "Time out for discovering. Stop it");
    this.jNV.aVS();
    if (this.jNV.jNN != null) {
      this.jNV.jNN.aVU();
    }
    AppMethodBeat.o(18363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.b.1
 * JD-Core Version:    0.7.0.1
 */