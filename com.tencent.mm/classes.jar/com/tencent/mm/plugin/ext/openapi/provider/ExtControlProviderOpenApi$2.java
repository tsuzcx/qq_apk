package com.tencent.mm.plugin.ext.openapi.provider;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.fp.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bn;

final class ExtControlProviderOpenApi$2
  extends bn<MatrixCursor>
{
  ExtControlProviderOpenApi$2(ExtControlProviderOpenApi paramExtControlProviderOpenApi, String[] paramArrayOfString)
  {
    super(20000L, null);
  }
  
  private MatrixCursor cmC()
  {
    AppMethodBeat.i(24385);
    try
    {
      ac.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
      final fp localfp = new fp();
      localfp.dfD.dfF = this.fLx;
      localfp.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24384);
          ac.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList run");
          if ((localfp == null) || (localfp.dfE == null) || (localfp.dfE.dfl == 0))
          {
            AppMethodBeat.o(24384);
            return;
          }
          ac.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList return cursor");
          ExtControlProviderOpenApi.2.this.aE(localfp.dfE.dfG);
          AppMethodBeat.o(24384);
        }
      };
      if (!com.tencent.mm.sdk.b.a.GpY.l(localfp))
      {
        ac.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList publish getWifiListEvent fail");
        aE(com.tencent.mm.pluginsdk.d.a.a.Wo(8));
      }
      AppMethodBeat.o(24385);
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.ExtControlProviderOpenApi", "exception in getWifiList syncTaskCur.", new Object[] { localException });
        aE(com.tencent.mm.pluginsdk.d.a.a.Wo(12));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.2
 * JD-Core Version:    0.7.0.1
 */