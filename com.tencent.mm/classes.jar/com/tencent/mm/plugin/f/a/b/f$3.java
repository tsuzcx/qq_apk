package com.tencent.mm.plugin.f.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.y;

final class f$3
  implements Runnable
{
  f$3(f paramf) {}
  
  public final void run()
  {
    y.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected timeout!!!, mac=%s, name=%s", new Object[] { b.ee(f.g(this.hUU)), f.h(this.hUU).getName() });
    if (3 == f.e(this.hUU))
    {
      y.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already disconnet or close, just leave");
      return;
    }
    if (f.e(this.hUU) == 1)
    {
      y.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already connected, just leave.");
      return;
    }
    this.hUU.awv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.f.3
 * JD-Core Version:    0.7.0.1
 */