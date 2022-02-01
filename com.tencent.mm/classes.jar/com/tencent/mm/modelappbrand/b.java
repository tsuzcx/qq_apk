package com.tencent.mm.modelappbrand;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
{
  public static String hNg;
  public static String hNh;
  
  public static void CB(String paramString)
  {
    AppMethodBeat.i(153190);
    try
    {
      Object localObject = MultiProcessSharedPreferences.getSharedPreferences(ak.getContext(), "pref_appbrand_process", 4);
      String str = paramString + ":start_time";
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove(str);
      ((SharedPreferences.Editor)localObject).commit();
      e.ywz.idkeyStat(365L, 5L, 1L, false);
      ae.v("MicroMsg.AppBrandReporter", "onProcessExit");
      AppMethodBeat.o(153190);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.AppBrandReporter", localThrowable, "onProcessExit(%s)", new Object[] { paramString });
      AppMethodBeat.o(153190);
    }
  }
  
  public static String aDR()
  {
    AppMethodBeat.i(153189);
    Object localObject = new StringBuilder("sid_");
    g.ajP();
    hNg = a.getUin() + "_" + bu.fpO();
    ae.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchSessionId : %s", new Object[] { hNg });
    localObject = hNg;
    AppMethodBeat.o(153189);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.b
 * JD-Core Version:    0.7.0.1
 */