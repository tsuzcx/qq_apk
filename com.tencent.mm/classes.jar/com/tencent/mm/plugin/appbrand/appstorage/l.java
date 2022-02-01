package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Build.VERSION;
import android.system.Os;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;

public final class l
{
  public static boolean cq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134327);
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        long l = bu.fpO();
        String str1 = o.k(paramString1, true);
        String str2 = o.k(paramString2, true);
        new a();
        Os.rename(str1, str2);
        ae.d("MicroMsg.AppBrand.FileMove", "move, os rename works, cost = %d", new Object[] { Long.valueOf(bu.fpO() - l) });
        AppMethodBeat.o(134327);
        return true;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.AppBrand.FileMove", "move, os rename exp = %s", new Object[] { bu.o(localException) });
      }
    }
    boolean bool = new k(paramString1).ag(new k(paramString2));
    AppMethodBeat.o(134327);
    return bool;
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.l
 * JD-Core Version:    0.7.0.1
 */