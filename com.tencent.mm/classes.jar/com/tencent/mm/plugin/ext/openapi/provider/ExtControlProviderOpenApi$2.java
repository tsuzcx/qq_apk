package com.tencent.mm.plugin.ext.openapi.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;

final class ExtControlProviderOpenApi$2
  extends bj<Integer>
{
  ExtControlProviderOpenApi$2(ExtControlProviderOpenApi paramExtControlProviderOpenApi, String[] paramArrayOfString)
  {
    super(20000L, null);
  }
  
  private Integer anp()
  {
    AppMethodBeat.i(20313);
    try
    {
      ab.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
      ff localff = new ff();
      localff.csR.version = bo.getInt(this.eut[0], 0);
      localff.csR.ssid = this.eut[1];
      localff.csR.bssid = this.eut[2];
      localff.csR.csT = bo.getInt(this.eut[3], 0);
      localff.callback = new ExtControlProviderOpenApi.2.1(this, localff);
      if (!a.ymk.l(localff))
      {
        ab.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi publish getWifiListEvent fail");
        cv(Integer.valueOf(8));
      }
      AppMethodBeat.o(20313);
      return Integer.valueOf(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.ExtControlProviderOpenApi", "exception in connectWifi syncTaskInt.", new Object[] { localException });
        cv(Integer.valueOf(12));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.2
 * JD-Core Version:    0.7.0.1
 */