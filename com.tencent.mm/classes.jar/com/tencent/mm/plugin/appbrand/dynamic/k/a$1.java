package com.tencent.mm.plugin.appbrand.dynamic.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.g;
import java.util.concurrent.CountDownLatch;

final class a$1
  implements g
{
  a$1(CountDownLatch paramCountDownLatch) {}
  
  public final void BN()
  {
    AppMethodBeat.i(11034);
    this.val$latch.countDown();
    AppMethodBeat.o(11034);
  }
  
  public final void br(boolean paramBoolean)
  {
    AppMethodBeat.i(11035);
    this.val$latch.countDown();
    AppMethodBeat.o(11035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.k.a.1
 * JD-Core Version:    0.7.0.1
 */