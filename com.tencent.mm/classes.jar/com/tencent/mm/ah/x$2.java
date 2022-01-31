package com.tencent.mm.ah;

import com.tencent.mm.sdk.platformtools.am.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

final class x$2
  implements am.a
{
  x$2(AtomicReference paramAtomicReference, CountDownLatch paramCountDownLatch) {}
  
  public final boolean tC()
  {
    this.eey.set(new x.a());
    this.eez.countDown();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ah.x.2
 * JD-Core Version:    0.7.0.1
 */