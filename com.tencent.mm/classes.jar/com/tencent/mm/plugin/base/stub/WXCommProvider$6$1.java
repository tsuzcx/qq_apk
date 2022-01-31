package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.model.bi.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.y;

final class WXCommProvider$6$1
  implements bi.a
{
  WXCommProvider$6$1(WXCommProvider.6 param6) {}
  
  public final void a(e parame)
  {
    y.i("MicroMsg.WXCommProvider", "checkIsLogin onSceneEnd() hasLogin:%s", new Object[] { Boolean.valueOf(WXCommProvider.hSq) });
    this.hSw.bS(Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCommProvider.6.1
 * JD-Core Version:    0.7.0.1
 */