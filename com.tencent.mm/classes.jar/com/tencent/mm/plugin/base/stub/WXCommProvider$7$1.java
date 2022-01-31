package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.model.bi.a;
import com.tencent.mm.network.e;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.platformtools.y;

final class WXCommProvider$7$1
  implements bi.a
{
  WXCommProvider$7$1(WXCommProvider.7 param7) {}
  
  public final void a(e parame)
  {
    y.i("MicroMsg.WXCommProvider", "checkIsLogin() onSceneEnd()");
    this.hSy.hSx.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCommProvider.7.1
 * JD-Core Version:    0.7.0.1
 */