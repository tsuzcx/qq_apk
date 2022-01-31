package com.tencent.mm.plugin.ext.openapi.provider;

import com.tencent.mm.h.a.fc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ExtControlProviderOpenApi$2
  extends bf<Integer>
{
  ExtControlProviderOpenApi$2(ExtControlProviderOpenApi paramExtControlProviderOpenApi, String[] paramArrayOfString)
  {
    super(20000L, null);
  }
  
  private Integer Uc()
  {
    try
    {
      y.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
      fc localfc = new fc();
      localfc.bLx.version = bk.getInt(this.dAS[0], 0);
      localfc.bLx.ssid = this.dAS[1];
      localfc.bLx.bssid = this.dAS[2];
      localfc.bLx.bLz = bk.getInt(this.dAS[3], 0);
      localfc.bFJ = new ExtControlProviderOpenApi.2.1(this, localfc);
      if (!a.udP.m(localfc))
      {
        y.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi publish getWifiListEvent fail");
        bS(Integer.valueOf(8));
      }
      return Integer.valueOf(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.ExtControlProviderOpenApi", "exception in connectWifi syncTaskInt.", new Object[] { localException });
        bS(Integer.valueOf(12));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.2
 * JD-Core Version:    0.7.0.1
 */