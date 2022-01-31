package com.tencent.mm.ah;

import com.tencent.mm.protocal.c.bly;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

final class x$1
  implements w.a
{
  x$1(AtomicReference paramAtomicReference, CountDownLatch paramCountDownLatch) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    this.eey.set(a.a.a(paramInt1, paramInt2, paramString, (bly)paramb.ecF.ecN, paramm, null));
    this.eez.countDown();
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ah.x.1
 * JD-Core Version:    0.7.0.1
 */