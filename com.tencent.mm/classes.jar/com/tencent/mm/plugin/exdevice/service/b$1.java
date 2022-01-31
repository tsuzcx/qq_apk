package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.CountDownLatch;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(19539);
    b.a(this.lIm, new com.tencent.mm.plugin.d.a.d.b(ah.getContext(), this.lIm, v.bqB().fPW));
    ab.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now notify");
    b.a(this.lIm).countDown();
    AppMethodBeat.o(19539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.b.1
 * JD-Core Version:    0.7.0.1
 */