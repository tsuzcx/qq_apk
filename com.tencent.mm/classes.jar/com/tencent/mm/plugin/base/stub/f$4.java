package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.g.d.a;
import java.util.concurrent.CountDownLatch;

final class f$4
  implements d.a
{
  f$4(CountDownLatch paramCountDownLatch) {}
  
  public final void ce(Object paramObject)
  {
    AppMethodBeat.i(186407);
    ae.e("MicroMsg.WXBizLogic", "onInterrupt error");
    this.val$countDownLatch.countDown();
    AppMethodBeat.o(186407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.f.4
 * JD-Core Version:    0.7.0.1
 */