package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.g.d.a;
import java.util.concurrent.CountDownLatch;

final class f$3
  implements d.a
{
  f$3(CountDownLatch paramCountDownLatch) {}
  
  public final void cc(Object paramObject)
  {
    AppMethodBeat.i(22229);
    ac.e("MicroMsg.WXBizLogic", "onInterrupt error");
    this.nnd.countDown();
    AppMethodBeat.o(22229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.f.3
 * JD-Core Version:    0.7.0.1
 */