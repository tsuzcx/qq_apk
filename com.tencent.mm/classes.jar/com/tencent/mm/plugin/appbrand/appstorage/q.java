package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Build.VERSION;
import android.system.Os;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class q
{
  public static boolean de(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134327);
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        long l = Util.nowMilliSecond();
        String str1 = y.n(paramString1, true);
        String str2 = y.n(paramString2, true);
        new a();
        Os.rename(str1, str2);
        Log.d("MicroMsg.AppBrand.FileMove", "move, os rename works, cost = %d", new Object[] { Long.valueOf(Util.nowMilliSecond() - l) });
        AppMethodBeat.o(134327);
        return true;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AppBrand.FileMove", "move, os rename exp = %s", new Object[] { Util.stackTraceToString(localException) });
      }
    }
    boolean bool2 = y.qn(paramString1, paramString2);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = FilesCopy.copy(y.n(paramString1, true), y.n(paramString2, true), true);
    }
    AppMethodBeat.o(134327);
    return bool1;
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q
 * JD-Core Version:    0.7.0.1
 */