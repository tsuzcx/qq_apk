package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Build.VERSION;
import android.system.Os;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

final class i
{
  static boolean bA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(105365);
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        long l = bo.aoy();
        new i.a();
        Os.rename(paramString1, paramString2);
        ab.d("MicroMsg.AppBrand.FileMove", "move, os rename works, cost = %d", new Object[] { Long.valueOf(bo.aoy() - l) });
        AppMethodBeat.o(105365);
        return true;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.AppBrand.FileMove", "move, os rename exp = %s", new Object[] { bo.l(localException) });
      }
    }
    boolean bool = new File(paramString1).renameTo(new File(paramString2));
    AppMethodBeat.o(105365);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.i
 * JD-Core Version:    0.7.0.1
 */