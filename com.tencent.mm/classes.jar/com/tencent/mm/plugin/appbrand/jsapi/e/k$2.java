package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.a;
import com.tencent.mm.sdk.platformtools.ai;

final class k$2
  implements Runnable
{
  k$2(k paramk, i parami) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis() - this.grJ.grI;
    if (l < 3000L)
    {
      ai.l(new k.2.1(this), 3000L - l);
      return;
    }
    a.t(this.fAy).lX(this.grJ.giU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.k.2
 * JD-Core Version:    0.7.0.1
 */