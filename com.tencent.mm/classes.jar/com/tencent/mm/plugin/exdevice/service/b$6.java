package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.y;

final class b$6
  implements Runnable
{
  b$6(b paramb, long paramLong) {}
  
  public final void run()
  {
    if (!b.a(this.jyO, this.jyT)) {
      y.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.connectImp failed!!!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.b.6
 * JD-Core Version:    0.7.0.1
 */