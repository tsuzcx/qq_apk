package com.tencent.mm.plugin.ext.openapi.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.fp.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bt;

final class ExtControlProviderOpenApi$3
  extends bo<Integer>
{
  ExtControlProviderOpenApi$3(ExtControlProviderOpenApi paramExtControlProviderOpenApi, String[] paramArrayOfString)
  {
    super(20000L, null);
  }
  
  private Integer aOQ()
  {
    AppMethodBeat.i(24388);
    try
    {
      ad.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
      final fp localfp = new fp();
      localfp.dqE.version = bt.getInt(this.geX[0], 0);
      localfp.dqE.ssid = this.geX[1];
      localfp.dqE.bssid = this.geX[2];
      localfp.dqE.dqG = bt.getInt(this.geX[3], 0);
      localfp.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24387);
          ad.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi run");
          if ((localfp == null) || (localfp.dqF == null) || (localfp.dqF.dqH == 0))
          {
            AppMethodBeat.o(24387);
            return;
          }
          ad.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi errcode = %s,errmsg = %s", new Object[] { Integer.valueOf(localfp.dqF.dqI), localfp.dqF.dqJ });
          ExtControlProviderOpenApi.3.this.aG(Integer.valueOf(localfp.dqF.dqI));
          AppMethodBeat.o(24387);
        }
      };
      if (!a.IbL.l(localfp))
      {
        ad.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi publish getWifiListEvent fail");
        aG(Integer.valueOf(8));
      }
      AppMethodBeat.o(24388);
      return Integer.valueOf(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.ExtControlProviderOpenApi", "exception in connectWifi syncTaskInt.", new Object[] { localException });
        aG(Integer.valueOf(12));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.3
 * JD-Core Version:    0.7.0.1
 */