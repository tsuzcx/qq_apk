package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class y$3
  implements Runnable
{
  y$3(y paramy, int paramInt, j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(19655);
    if (!y.a(this.lJc, this.lDn, this.lJd)) {
      ab.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scanImp failed!!!");
    }
    AppMethodBeat.o(19655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.y.3
 * JD-Core Version:    0.7.0.1
 */