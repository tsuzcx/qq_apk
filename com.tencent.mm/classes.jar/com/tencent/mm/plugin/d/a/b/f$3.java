package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;

final class f$3
  implements Runnable
{
  f$3(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(18422);
    ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected timeout!!!, mac=%s, name=%s", new Object[] { b.jw(f.g(this.jOO)), f.h(this.jOO).getName() });
    if (3 == f.e(this.jOO))
    {
      ab.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already disconnet or close, just leave");
      AppMethodBeat.o(18422);
      return;
    }
    if (f.e(this.jOO) == 1)
    {
      ab.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already connected, just leave.");
      AppMethodBeat.o(18422);
      return;
    }
    this.jOO.aVY();
    AppMethodBeat.o(18422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.f.3
 * JD-Core Version:    0.7.0.1
 */