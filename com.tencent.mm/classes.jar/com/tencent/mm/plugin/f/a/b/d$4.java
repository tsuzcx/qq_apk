package com.tencent.mm.plugin.f.a.b;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class d$4
  implements Runnable
{
  d$4(d paramd) {}
  
  public final void run()
  {
    y.e("MicroMsg.exdevice.BluetoothLESession", "Connected timeout!!!");
    if (3 == this.hUA.hUy) {
      y.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
    }
    do
    {
      return;
      this.hUA.mHandler.removeCallbacks(this.hUA.hUt);
      this.hUA.hUy = 2;
    } while (this.hUA.hUo == null);
    this.hUA.hUo.hTT.i(this.hUA.mSessionId, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.d.4
 * JD-Core Version:    0.7.0.1
 */