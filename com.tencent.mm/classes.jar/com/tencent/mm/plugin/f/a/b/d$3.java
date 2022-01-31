package com.tencent.mm.plugin.f.a.b;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class d$3
  implements Runnable
{
  d$3(d paramd) {}
  
  public final void run()
  {
    y.e("MicroMsg.exdevice.BluetoothLESession", "Write descriptor timeout!!!");
    if (3 == this.hUA.hUy) {
      y.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
    }
    do
    {
      return;
      this.hUA.mHandler.removeCallbacks(this.hUA.hUu);
      this.hUA.hUy = 2;
    } while (this.hUA.hUo == null);
    this.hUA.hUo.hTT.i(this.hUA.mSessionId, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.d.3
 * JD-Core Version:    0.7.0.1
 */