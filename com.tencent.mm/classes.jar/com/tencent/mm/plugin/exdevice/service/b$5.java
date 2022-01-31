package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.y;

final class b$5
  implements Runnable
{
  b$5(b paramb, long paramLong, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    if (!b.a(this.jyO, this.jyT, this.jyU)) {
      y.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.sendDataImp failed!!!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.b.5
 * JD-Core Version:    0.7.0.1
 */