package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Build.VERSION;
import android.system.Os;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class l
{
  public static boolean cE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134327);
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        long l = Util.nowMilliSecond();
        String str1 = s.k(paramString1, true);
        String str2 = s.k(paramString2, true);
        new a();
        Os.rename(str1, str2);
        Log.d("MicroMsg.AppBrand.FileMove", "move, os rename works, cost = %d", new Object[] { Long.valueOf(Util.nowMilliSecond() - l) });
        AppMethodBeat.o(134327);
        return true;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AppBrand.FileMove", "move, os rename exp = %s", new Object[] { Util.stackTraceToString(localException) });
        FilesCopy.copy(s.k(paramString1, true), s.k(paramString2, true), true);
      }
    }
    boolean bool = new o(paramString1).am(new o(paramString2));
    AppMethodBeat.o(134327);
    return bool;
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.l
 * JD-Core Version:    0.7.0.1
 */