package com.tencent.mm.plugin.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class d$2
  implements Runnable
{
  d$2(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(18393);
    ab.e("MicroMsg.exdevice.BluetoothLESession", "Write data timeout");
    if (this.jOu.jOi != null) {
      this.jOu.jOi.jNN.m(this.jOu.mSessionId, false);
    }
    this.jOu.aVX();
    AppMethodBeat.o(18393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.d.2
 * JD-Core Version:    0.7.0.1
 */