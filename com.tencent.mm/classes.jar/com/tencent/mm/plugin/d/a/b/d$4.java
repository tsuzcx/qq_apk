package com.tencent.mm.plugin.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class d$4
  implements Runnable
{
  d$4(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(18395);
    ab.e("MicroMsg.exdevice.BluetoothLESession", "Connected timeout!!!");
    if (3 == this.jOu.jOs)
    {
      ab.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
      AppMethodBeat.o(18395);
      return;
    }
    this.jOu.mHandler.removeCallbacks(this.jOu.jOn);
    this.jOu.jOs = 2;
    if (this.jOu.jOi != null) {
      this.jOu.jOi.jNN.l(this.jOu.mSessionId, false);
    }
    AppMethodBeat.o(18395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.d.4
 * JD-Core Version:    0.7.0.1
 */