package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bi;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.y;

final class WXCommProvider$6
  extends bf<Boolean>
{
  WXCommProvider$6(WXCommProvider paramWXCommProvider, Boolean paramBoolean)
  {
    super(4000L, paramBoolean);
  }
  
  private Boolean anE()
  {
    try
    {
      y.i("MicroMsg.WXCommProvider", "checkIsLogin run");
      if (!au.DK()) {
        return Boolean.valueOf(false);
      }
      y.i("MicroMsg.WXCommProvider", "checkIsLogin doScene");
      boolean bool = au.Dk().a(new bi(new WXCommProvider.6.1(this)), 0);
      return Boolean.valueOf(bool);
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy.");
      bS(Boolean.valueOf(false));
    }
    return Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCommProvider.6
 * JD-Core Version:    0.7.0.1
 */