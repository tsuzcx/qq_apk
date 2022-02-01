package com.tencent.mm.modelappbrand;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
{
  public static String hrV;
  public static String hrW;
  
  public static String aAy()
  {
    AppMethodBeat.i(153189);
    Object localObject = new StringBuilder("sid_");
    g.agP();
    hrV = a.getUin() + "_" + bs.eWj();
    ac.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchSessionId : %s", new Object[] { hrV });
    localObject = hrV;
    AppMethodBeat.o(153189);
    return localObject;
  }
  
  public static void za(String paramString)
  {
    AppMethodBeat.i(153190);
    try
    {
      Object localObject = MultiProcessSharedPreferences.getSharedPreferences(ai.getContext(), "pref_appbrand_process", 4);
      String str = paramString + ":start_time";
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove(str);
      ((SharedPreferences.Editor)localObject).commit();
      e.wTc.idkeyStat(365L, 5L, 1L, false);
      ac.v("MicroMsg.AppBrandReporter", "onProcessExit");
      AppMethodBeat.o(153190);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("MicroMsg.AppBrandReporter", localThrowable, "onProcessExit(%s)", new Object[] { paramString });
      AppMethodBeat.o(153190);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.b
 * JD-Core Version:    0.7.0.1
 */