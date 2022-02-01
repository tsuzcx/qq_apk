package com.tencent.mm.plugin.ext.openapi.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.g.a.ft.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;

final class ExtControlProviderOpenApi$3
  extends SyncTask<Integer>
{
  ExtControlProviderOpenApi$3(ExtControlProviderOpenApi paramExtControlProviderOpenApi, String[] paramArrayOfString)
  {
    super(20000L, null, true);
  }
  
  private Integer bjO()
  {
    AppMethodBeat.i(24388);
    try
    {
      Log.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
      final ft localft = new ft();
      localft.dIV.version = Util.getInt(this.gMN[0], 0);
      localft.dIV.ssid = this.gMN[1];
      localft.dIV.bssid = this.gMN[2];
      localft.dIV.dIX = Util.getInt(this.gMN[3], 0);
      localft.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24387);
          Log.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi run");
          if ((localft == null) || (localft.dIW == null) || (localft.dIW.dIY == 0))
          {
            AppMethodBeat.o(24387);
            return;
          }
          Log.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi errcode = %s,errmsg = %s", new Object[] { Integer.valueOf(localft.dIW.dIZ), localft.dIW.dJa });
          ExtControlProviderOpenApi.3.this.setResultFinish(Integer.valueOf(localft.dIW.dIZ));
          AppMethodBeat.o(24387);
        }
      };
      if (!EventCenter.instance.publish(localft))
      {
        Log.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi publish getWifiListEvent fail");
        setResultFinish(Integer.valueOf(8));
      }
      AppMethodBeat.o(24388);
      return Integer.valueOf(0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.ExtControlProviderOpenApi", "exception in connectWifi syncTaskInt.", new Object[] { localException });
        setResultFinish(Integer.valueOf(12));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.3
 * JD-Core Version:    0.7.0.1
 */