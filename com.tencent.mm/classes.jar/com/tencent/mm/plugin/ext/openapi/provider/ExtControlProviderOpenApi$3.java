package com.tencent.mm.plugin.ext.openapi.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.gl;
import com.tencent.mm.autogen.a.gl.b;
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
  
  private Integer bRc()
  {
    AppMethodBeat.i(24388);
    try
    {
      Log.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
      final gl localgl = new gl();
      localgl.hGB.version = Util.getInt(this.val$args[0], 0);
      localgl.hGB.ssid = this.val$args[1];
      localgl.hGB.bssid = this.val$args[2];
      localgl.hGB.rssi = Util.getInt(this.val$args[3], 0);
      localgl.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24387);
          Log.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi run");
          if ((localgl == null) || (localgl.hGC == null) || (localgl.hGC.hGD == 0))
          {
            AppMethodBeat.o(24387);
            return;
          }
          Log.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi errcode = %s,errmsg = %s", new Object[] { Integer.valueOf(localgl.hGC.hGE), localgl.hGC.errmsg });
          ExtControlProviderOpenApi.3.this.setResultFinish(Integer.valueOf(localgl.hGC.hGE));
          AppMethodBeat.o(24387);
        }
      };
      if (!localgl.publish())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.3
 * JD-Core Version:    0.7.0.1
 */