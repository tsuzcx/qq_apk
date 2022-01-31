package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.model.au;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class ad$9
  implements m.b
{
  ad$9(ad paramad) {}
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    try
    {
      if (!au.DK())
      {
        y.w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
        return;
      }
      if ((paramObject instanceof String))
      {
        au.DS().k(new ad.9.1(this, paramObject), 2000L);
        return;
      }
    }
    catch (Exception paramm)
    {
      y.e("MicroMsg.exdevice.SubCoreExDevice", "ap : onNotifyChange exception %s", new Object[] { paramm.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad.9
 * JD-Core Version:    0.7.0.1
 */