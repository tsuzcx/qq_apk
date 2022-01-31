package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$6
  implements Runnable
{
  b$6(b paramb, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(19544);
    if (!b.a(this.lIn, this.lIs)) {
      ab.e("MicroMsg.exdevice.BluetoothSDKAdapter", "instance.connectImp failed!!!");
    }
    AppMethodBeat.o(19544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.b.6
 * JD-Core Version:    0.7.0.1
 */