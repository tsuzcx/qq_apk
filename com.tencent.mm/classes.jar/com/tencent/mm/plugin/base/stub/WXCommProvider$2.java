package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.h.a.fa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class WXCommProvider$2
  implements am.a
{
  WXCommProvider$2(WXCommProvider paramWXCommProvider) {}
  
  public final boolean tC()
  {
    if ((a.udP != null) && (a.udP.T(fa.class))) {
      synchronized (WXCommProvider.awe())
      {
        y.i("MicroMsg.WXCommProvider", "The lock was released.");
        WXCommProvider.asL();
        WXCommProvider.awe().notifyAll();
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCommProvider.2
 * JD-Core Version:    0.7.0.1
 */