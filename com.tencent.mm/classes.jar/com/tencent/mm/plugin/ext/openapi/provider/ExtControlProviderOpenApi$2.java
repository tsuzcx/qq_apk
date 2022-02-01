package com.tencent.mm.plugin.ext.openapi.provider;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.g.a.ft.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bp;

final class ExtControlProviderOpenApi$2
  extends bp<MatrixCursor>
{
  ExtControlProviderOpenApi$2(ExtControlProviderOpenApi paramExtControlProviderOpenApi, String[] paramArrayOfString)
  {
    super(20000L, null);
  }
  
  private MatrixCursor ctJ()
  {
    AppMethodBeat.i(24385);
    try
    {
      ae.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
      final ft localft = new ft();
      localft.dse.dsg = this.ghh;
      localft.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24384);
          ae.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList run");
          if ((localft == null) || (localft.dsf == null) || (localft.dsf.drM == 0))
          {
            AppMethodBeat.o(24384);
            return;
          }
          ae.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList return cursor");
          ExtControlProviderOpenApi.2.this.aG(localft.dsf.dsh);
          AppMethodBeat.o(24384);
        }
      };
      if (!com.tencent.mm.sdk.b.a.IvT.l(localft))
      {
        ae.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList publish getWifiListEvent fail");
        aG(com.tencent.mm.pluginsdk.d.a.a.YL(8));
      }
      AppMethodBeat.o(24385);
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.ExtControlProviderOpenApi", "exception in getWifiList syncTaskCur.", new Object[] { localException });
        aG(com.tencent.mm.pluginsdk.d.a.a.YL(12));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.2
 * JD-Core Version:    0.7.0.1
 */