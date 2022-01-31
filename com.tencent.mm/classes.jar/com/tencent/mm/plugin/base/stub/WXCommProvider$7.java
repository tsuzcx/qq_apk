package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bi;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.platformtools.y;

final class WXCommProvider$7
  implements Runnable
{
  WXCommProvider$7(WXCommProvider paramWXCommProvider, b paramb) {}
  
  public final void run()
  {
    try
    {
      if (!au.DK()) {
        return;
      }
      au.Dk().a(new bi(new WXCommProvider.7.1(this)), 0);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy");
      this.hSx.countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCommProvider.7
 * JD-Core Version:    0.7.0.1
 */