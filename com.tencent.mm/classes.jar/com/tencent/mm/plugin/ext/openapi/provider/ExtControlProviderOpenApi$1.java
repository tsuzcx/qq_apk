package com.tencent.mm.plugin.ext.openapi.provider;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bj;

final class ExtControlProviderOpenApi$1
  extends bj<MatrixCursor>
{
  ExtControlProviderOpenApi$1(ExtControlProviderOpenApi paramExtControlProviderOpenApi, String[] paramArrayOfString)
  {
    super(20000L, null);
  }
  
  private MatrixCursor btB()
  {
    AppMethodBeat.i(20310);
    try
    {
      ab.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
      fi localfi = new fi();
      localfi.ctn.ctp = this.eut;
      localfi.callback = new ExtControlProviderOpenApi.1.1(this, localfi);
      if (!com.tencent.mm.sdk.b.a.ymk.l(localfi))
      {
        ab.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList publish getWifiListEvent fail");
        cv(com.tencent.mm.pluginsdk.d.a.a.Ls(8));
      }
      AppMethodBeat.o(20310);
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.ExtControlProviderOpenApi", "exception in getWifiList syncTaskCur.", new Object[] { localException });
        cv(com.tencent.mm.pluginsdk.d.a.a.Ls(12));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.1
 * JD-Core Version:    0.7.0.1
 */