package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.h.a.ih;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class WXCommProvider$3
  implements Runnable
{
  WXCommProvider$3(WXCommProvider paramWXCommProvider, ih paramih) {}
  
  public final void run()
  {
    if (!a.udP.m(this.hSs)) {
      y.e("MicroMsg.WXCommProvider", "handle scan result failed again");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCommProvider.3
 * JD-Core Version:    0.7.0.1
 */