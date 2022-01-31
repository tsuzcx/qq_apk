package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class y$4
  implements Runnable
{
  y$4(y paramy, int paramInt, j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(19656);
    if (!y.b(this.lJc, this.lDn, this.lJd)) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp failed!!!");
    }
    AppMethodBeat.o(19656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.y.4
 * JD-Core Version:    0.7.0.1
 */