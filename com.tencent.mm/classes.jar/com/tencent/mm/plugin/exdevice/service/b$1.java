package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.CountDownLatch;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    b.a(this.jyN, new com.tencent.mm.plugin.f.a.d.b(ae.getContext(), this.jyN, v.aMo().eAg));
    y.i("MicroMsg.exdevice.BluetoothSDKAdapter", "now notify");
    b.a(this.jyN).countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.b.1
 * JD-Core Version:    0.7.0.1
 */