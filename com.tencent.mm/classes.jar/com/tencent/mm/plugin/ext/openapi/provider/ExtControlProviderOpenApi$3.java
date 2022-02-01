package com.tencent.mm.plugin.ext.openapi.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.fl.b;
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
  
  private Integer aEP()
  {
    AppMethodBeat.i(24388);
    try
    {
      ad.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
      final fl localfl = new fl();
      localfl.dhN.version = bt.getInt(this.fHR[0], 0);
      localfl.dhN.ssid = this.fHR[1];
      localfl.dhN.bssid = this.fHR[2];
      localfl.dhN.dhP = bt.getInt(this.fHR[3], 0);
      localfl.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24387);
          ad.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi run");
          if ((localfl == null) || (localfl.dhO == null) || (localfl.dhO.dhQ == 0))
          {
            AppMethodBeat.o(24387);
            return;
          }
          ad.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi errcode = %s,errmsg = %s", new Object[] { Integer.valueOf(localfl.dhO.dhR), localfl.dhO.dhS });
          ExtControlProviderOpenApi.3.this.aH(Integer.valueOf(localfl.dhO.dhR));
          AppMethodBeat.o(24387);
        }
      };
      if (!a.ESL.l(localfl))
      {
        ad.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi publish getWifiListEvent fail");
        aH(Integer.valueOf(8));
      }
      AppMethodBeat.o(24388);
      return Integer.valueOf(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.ExtControlProviderOpenApi", "exception in connectWifi syncTaskInt.", new Object[] { localException });
        aH(Integer.valueOf(12));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.3
 * JD-Core Version:    0.7.0.1
 */