package com.tencent.mm.plugin.ext.openapi.provider;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.fo.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bo;

final class ExtControlProviderOpenApi$2
  extends bo<MatrixCursor>
{
  ExtControlProviderOpenApi$2(ExtControlProviderOpenApi paramExtControlProviderOpenApi, String[] paramArrayOfString)
  {
    super(20000L, null);
  }
  
  private MatrixCursor ceV()
  {
    AppMethodBeat.i(24385);
    try
    {
      ad.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
      final fo localfo = new fo();
      localfo.dii.dik = this.fHR;
      localfo.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24384);
          ad.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList run");
          if ((localfo == null) || (localfo.dij == null) || (localfo.dij.dhQ == 0))
          {
            AppMethodBeat.o(24384);
            return;
          }
          ad.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList return cursor");
          ExtControlProviderOpenApi.2.this.aH(localfo.dij.dil);
          AppMethodBeat.o(24384);
        }
      };
      if (!com.tencent.mm.sdk.b.a.ESL.l(localfo))
      {
        ad.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList publish getWifiListEvent fail");
        aH(com.tencent.mm.pluginsdk.d.a.a.Ue(8));
      }
      AppMethodBeat.o(24385);
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.ExtControlProviderOpenApi", "exception in getWifiList syncTaskCur.", new Object[] { localException });
        aH(com.tencent.mm.pluginsdk.d.a.a.Ue(12));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.2
 * JD-Core Version:    0.7.0.1
 */