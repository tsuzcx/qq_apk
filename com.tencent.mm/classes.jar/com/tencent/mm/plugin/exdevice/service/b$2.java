package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements Runnable
{
  b$2(b paramb, int paramInt, r paramr, int[] paramArrayOfInt) {}
  
  public final void run()
  {
    if (!b.a(this.jyO, this.jtO, this.jyP, this.jyQ)) {
      y.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.scanImp failed!!!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.b.2
 * JD-Core Version:    0.7.0.1
 */