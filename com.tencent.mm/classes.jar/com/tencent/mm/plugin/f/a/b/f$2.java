package com.tencent.mm.plugin.f.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.y;

final class f$2
  implements Runnable
{
  f$2(f paramf) {}
  
  public final void run()
  {
    y.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Write data timeout, mac=%s, name=%s", new Object[] { b.ee(f.g(this.hUU)), f.h(this.hUU).getName() });
    if (f.i(this.hUU) != null) {
      f.i(this.hUU).j(f.g(this.hUU), false);
    }
    f.j(this.hUU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.f.2
 * JD-Core Version:    0.7.0.1
 */