package com.tencent.mm.plugin.appbrand.dynamic.k;

import com.tencent.mm.kernel.api.g;
import java.util.concurrent.CountDownLatch;

final class a$1
  implements g
{
  a$1(CountDownLatch paramCountDownLatch) {}
  
  public final void aP(boolean paramBoolean)
  {
    this.eez.countDown();
  }
  
  public final void tj()
  {
    this.eez.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.k.a.1
 * JD-Core Version:    0.7.0.1
 */