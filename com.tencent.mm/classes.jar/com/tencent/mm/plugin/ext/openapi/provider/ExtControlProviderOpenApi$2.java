package com.tencent.mm.plugin.ext.openapi.provider;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fs;
import com.tencent.mm.g.a.fs.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bo;

final class ExtControlProviderOpenApi$2
  extends bo<MatrixCursor>
{
  ExtControlProviderOpenApi$2(ExtControlProviderOpenApi paramExtControlProviderOpenApi, String[] paramArrayOfString)
  {
    super(20000L, null);
  }
  
  private MatrixCursor csh()
  {
    AppMethodBeat.i(24385);
    try
    {
      ad.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
      final fs localfs = new fs();
      localfs.dqZ.drb = this.geX;
      localfs.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24384);
          ad.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList run");
          if ((localfs == null) || (localfs.dra == null) || (localfs.dra.dqH == 0))
          {
            AppMethodBeat.o(24384);
            return;
          }
          ad.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList return cursor");
          ExtControlProviderOpenApi.2.this.aG(localfs.dra.drc);
          AppMethodBeat.o(24384);
        }
      };
      if (!com.tencent.mm.sdk.b.a.IbL.l(localfs))
      {
        ad.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList publish getWifiListEvent fail");
        aG(com.tencent.mm.pluginsdk.d.a.a.Yf(8));
      }
      AppMethodBeat.o(24385);
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.ExtControlProviderOpenApi", "exception in getWifiList syncTaskCur.", new Object[] { localException });
        aG(com.tencent.mm.pluginsdk.d.a.a.Yf(12));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.2
 * JD-Core Version:    0.7.0.1
 */