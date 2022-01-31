package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.y;

final class b$3
  implements Runnable
{
  b$3(b paramb, int paramInt) {}
  
  public final void run()
  {
    if (!b.a(this.jyO, this.jtO)) {
      y.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.stopScanImp failed!!!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.b.3
 * JD-Core Version:    0.7.0.1
 */