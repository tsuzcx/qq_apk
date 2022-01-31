package com.tencent.mm.modelappbrand;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
{
  public static String fpQ;
  public static String fpR;
  
  public static String ach()
  {
    AppMethodBeat.i(114902);
    Object localObject = new StringBuilder("sid_");
    g.RJ();
    fpQ = a.getUin() + "_" + bo.aoy();
    ab.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchSessionId : %s", new Object[] { fpQ });
    localObject = fpQ;
    AppMethodBeat.o(114902);
    return localObject;
  }
  
  public static long aci()
  {
    AppMethodBeat.i(114904);
    long l;
    try
    {
      SharedPreferences localSharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "pref_appbrand_process", 4);
      String str = ah.getProcessName() + ":start_time";
      l = System.currentTimeMillis();
      if (localSharedPreferences.contains(str))
      {
        l = localSharedPreferences.getLong(str, l);
        AppMethodBeat.o(114904);
        return l;
      }
      AppMethodBeat.o(114904);
      return l;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandReporter", localThrowable, "getProcessStartTime", new Object[0]);
      l = System.currentTimeMillis();
      AppMethodBeat.o(114904);
    }
    return l;
  }
  
  public static void qf(String paramString)
  {
    AppMethodBeat.i(114903);
    try
    {
      Object localObject = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "pref_appbrand_process", 4);
      String str = paramString + ":start_time";
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove(str);
      ((SharedPreferences.Editor)localObject).commit();
      e.qrI.idkeyStat(365L, 5L, 1L, false);
      ab.v("MicroMsg.AppBrandReporter", "onProcessExit");
      AppMethodBeat.o(114903);
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandReporter", localThrowable, "onProcessExit(%s)", new Object[] { paramString });
      AppMethodBeat.o(114903);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.b
 * JD-Core Version:    0.7.0.1
 */