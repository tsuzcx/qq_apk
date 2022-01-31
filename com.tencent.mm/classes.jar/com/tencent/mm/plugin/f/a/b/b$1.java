package com.tencent.mm.plugin.f.a.b;

import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    this.hUb.hTV = false;
    this.hUb.eo(false);
    y.i("MicroMsg.exdevice.BluetoothLEManager", "Time out for discovering. Stop it");
    this.hUb.awp();
    if (this.hUb.hTT != null) {
      this.hUb.hTT.awr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.b.1
 * JD-Core Version:    0.7.0.1
 */