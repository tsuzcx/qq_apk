package com.tencent.mm.plugin.f.a.b;

import com.tencent.mm.sdk.platformtools.y;

final class d$2
  implements Runnable
{
  d$2(d paramd) {}
  
  public final void run()
  {
    y.e("MicroMsg.exdevice.BluetoothLESession", "Write data timeout");
    if (this.hUA.hUo != null) {
      this.hUA.hUo.hTT.j(this.hUA.mSessionId, false);
    }
    this.hUA.awu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.d.2
 * JD-Core Version:    0.7.0.1
 */