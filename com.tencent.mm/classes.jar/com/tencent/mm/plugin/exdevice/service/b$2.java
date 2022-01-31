package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$2
  implements Runnable
{
  b$2(b paramb, int paramInt, r paramr, int[] paramArrayOfInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(19540);
    if (!b.a(this.lIn, this.lDn, this.lIo, this.lIp)) {
      ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.scanImp failed!!!");
    }
    AppMethodBeat.o(19540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.b.2
 * JD-Core Version:    0.7.0.1
 */