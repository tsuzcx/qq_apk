package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d.a;
import java.util.concurrent.CountDownLatch;

final class f$4
  implements d.a
{
  f$4(CountDownLatch paramCountDownLatch) {}
  
  public final void onInterrupt(Object paramObject)
  {
    AppMethodBeat.i(269038);
    Log.e("MicroMsg.WXBizLogic", "onInterrupt error");
    this.val$countDownLatch.countDown();
    AppMethodBeat.o(269038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.f.4
 * JD-Core Version:    0.7.0.1
 */