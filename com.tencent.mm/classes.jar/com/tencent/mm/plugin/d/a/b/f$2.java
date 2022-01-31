package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;

final class f$2
  implements Runnable
{
  f$2(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(18421);
    ab.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Write data timeout, mac=%s, name=%s", new Object[] { b.jw(f.g(this.jOO)), f.h(this.jOO).getName() });
    if (f.i(this.jOO) != null) {
      f.i(this.jOO).m(f.g(this.jOO), false);
    }
    f.j(this.jOO);
    AppMethodBeat.o(18421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.f.2
 * JD-Core Version:    0.7.0.1
 */