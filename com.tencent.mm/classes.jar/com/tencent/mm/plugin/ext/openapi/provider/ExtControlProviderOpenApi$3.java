package com.tencent.mm.plugin.ext.openapi.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.g.a.fm.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.bs;

final class ExtControlProviderOpenApi$3
  extends bn<Integer>
{
  ExtControlProviderOpenApi$3(ExtControlProviderOpenApi paramExtControlProviderOpenApi, String[] paramArrayOfString)
  {
    super(20000L, null);
  }
  
  private Integer aLG()
  {
    AppMethodBeat.i(24388);
    try
    {
      ac.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
      final fm localfm = new fm();
      localfm.dfi.version = bs.getInt(this.fLx[0], 0);
      localfm.dfi.ssid = this.fLx[1];
      localfm.dfi.bssid = this.fLx[2];
      localfm.dfi.dfk = bs.getInt(this.fLx[3], 0);
      localfm.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24387);
          ac.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi run");
          if ((localfm == null) || (localfm.dfj == null) || (localfm.dfj.dfl == 0))
          {
            AppMethodBeat.o(24387);
            return;
          }
          ac.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi errcode = %s,errmsg = %s", new Object[] { Integer.valueOf(localfm.dfj.dfm), localfm.dfj.dfn });
          ExtControlProviderOpenApi.3.this.aE(Integer.valueOf(localfm.dfj.dfm));
          AppMethodBeat.o(24387);
        }
      };
      if (!a.GpY.l(localfm))
      {
        ac.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi publish getWifiListEvent fail");
        aE(Integer.valueOf(8));
      }
      AppMethodBeat.o(24388);
      return Integer.valueOf(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.ExtControlProviderOpenApi", "exception in connectWifi syncTaskInt.", new Object[] { localException });
        aE(Integer.valueOf(12));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.3
 * JD-Core Version:    0.7.0.1
 */