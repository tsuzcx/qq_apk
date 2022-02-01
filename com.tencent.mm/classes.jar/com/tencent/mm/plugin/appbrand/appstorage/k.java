package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Build.VERSION;
import android.system.Os;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public final class k
{
  public static boolean cp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134327);
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        long l = bt.flT();
        String str1 = i.k(paramString1, true);
        String str2 = i.k(paramString2, true);
        new a();
        Os.rename(str1, str2);
        ad.d("MicroMsg.AppBrand.FileMove", "move, os rename works, cost = %d", new Object[] { Long.valueOf(bt.flT() - l) });
        AppMethodBeat.o(134327);
        return true;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.AppBrand.FileMove", "move, os rename exp = %s", new Object[] { bt.n(localException) });
      }
    }
    boolean bool = new e(paramString1).ag(new e(paramString2));
    AppMethodBeat.o(134327);
    return bool;
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.k
 * JD-Core Version:    0.7.0.1
 */