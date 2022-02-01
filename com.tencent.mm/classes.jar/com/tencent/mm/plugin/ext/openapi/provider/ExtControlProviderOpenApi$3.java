package com.tencent.mm.plugin.ext.openapi.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.g.a.fq.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.bu;

final class ExtControlProviderOpenApi$3
  extends bp<Integer>
{
  ExtControlProviderOpenApi$3(ExtControlProviderOpenApi paramExtControlProviderOpenApi, String[] paramArrayOfString)
  {
    super(20000L, null);
  }
  
  private Integer aPn()
  {
    AppMethodBeat.i(24388);
    try
    {
      ae.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
      final fq localfq = new fq();
      localfq.drJ.version = bu.getInt(this.ghh[0], 0);
      localfq.drJ.ssid = this.ghh[1];
      localfq.drJ.bssid = this.ghh[2];
      localfq.drJ.drL = bu.getInt(this.ghh[3], 0);
      localfq.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24387);
          ae.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi run");
          if ((localfq == null) || (localfq.drK == null) || (localfq.drK.drM == 0))
          {
            AppMethodBeat.o(24387);
            return;
          }
          ae.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi errcode = %s,errmsg = %s", new Object[] { Integer.valueOf(localfq.drK.drN), localfq.drK.drO });
          ExtControlProviderOpenApi.3.this.aG(Integer.valueOf(localfq.drK.drN));
          AppMethodBeat.o(24387);
        }
      };
      if (!a.IvT.l(localfq))
      {
        ae.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi publish getWifiListEvent fail");
        aG(Integer.valueOf(8));
      }
      AppMethodBeat.o(24388);
      return Integer.valueOf(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.ExtControlProviderOpenApi", "exception in connectWifi syncTaskInt.", new Object[] { localException });
        aG(Integer.valueOf(12));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.3
 * JD-Core Version:    0.7.0.1
 */