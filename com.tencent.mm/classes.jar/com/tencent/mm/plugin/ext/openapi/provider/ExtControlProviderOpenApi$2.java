package com.tencent.mm.plugin.ext.openapi.provider;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.a.fw.b;
import com.tencent.mm.pluginsdk.d.a.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SyncTask;

final class ExtControlProviderOpenApi$2
  extends SyncTask<MatrixCursor>
{
  ExtControlProviderOpenApi$2(ExtControlProviderOpenApi paramExtControlProviderOpenApi, String[] paramArrayOfString)
  {
    super(20000L, null, true);
  }
  
  private MatrixCursor cSr()
  {
    AppMethodBeat.i(24385);
    try
    {
      Log.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
      final fw localfw = new fw();
      localfw.dJq.dJs = this.gMN;
      localfw.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24384);
          Log.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList run");
          if ((localfw == null) || (localfw.dJr == null) || (localfw.dJr.dIY == 0))
          {
            AppMethodBeat.o(24384);
            return;
          }
          Log.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList return cursor");
          ExtControlProviderOpenApi.2.this.setResultFinish(localfw.dJr.dJt);
          AppMethodBeat.o(24384);
        }
      };
      if (!EventCenter.instance.publish(localfw))
      {
        Log.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList publish getWifiListEvent fail");
        setResultFinish(a.ahx(8));
      }
      AppMethodBeat.o(24385);
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.ExtControlProviderOpenApi", "exception in getWifiList syncTaskCur.", new Object[] { localException });
        setResultFinish(a.ahx(12));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.2
 * JD-Core Version:    0.7.0.1
 */