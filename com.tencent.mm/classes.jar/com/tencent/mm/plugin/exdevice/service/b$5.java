package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$5
  implements Runnable
{
  b$5(b paramb, long paramLong, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(19543);
    if (!b.a(this.lIn, this.lIs, this.lIt)) {
      ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.sendDataImp failed!!!");
    }
    AppMethodBeat.o(19543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.b.5
 * JD-Core Version:    0.7.0.1
 */