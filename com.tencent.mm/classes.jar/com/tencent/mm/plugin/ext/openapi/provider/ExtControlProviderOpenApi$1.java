package com.tencent.mm.plugin.ext.openapi.provider;

import android.database.MatrixCursor;
import com.tencent.mm.h.a.ff;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.y;

final class ExtControlProviderOpenApi$1
  extends bf<MatrixCursor>
{
  ExtControlProviderOpenApi$1(ExtControlProviderOpenApi paramExtControlProviderOpenApi, String[] paramArrayOfString)
  {
    super(20000L, null);
  }
  
  private MatrixCursor aNy()
  {
    try
    {
      y.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
      ff localff = new ff();
      localff.bLT.bLV = this.dAS;
      localff.bFJ = new ExtControlProviderOpenApi.1.1(this, localff);
      if (!com.tencent.mm.sdk.b.a.udP.m(localff))
      {
        y.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList publish getWifiListEvent fail");
        bS(com.tencent.mm.pluginsdk.d.a.a.DA(8));
      }
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.ExtControlProviderOpenApi", "exception in getWifiList syncTaskCur.", new Object[] { localException });
        bS(com.tencent.mm.pluginsdk.d.a.a.DA(12));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.1
 * JD-Core Version:    0.7.0.1
 */