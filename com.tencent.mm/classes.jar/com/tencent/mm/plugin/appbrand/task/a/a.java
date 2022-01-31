package com.tencent.mm.plugin.appbrand.task.a;

import a.f.b.j;
import a.l;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.TimeUnit;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter;", "", "()V", "FREQUENCY_LIMIT_INTERVAL_SECONDS", "", "KEY", "", "KEY_TEST_DISABLE", "MEMORY_PRESSURE_INTERVAL_MIN_DEFAULT_MINUTES", "SP", "TAG", "mLastPreloadTimestampMap", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PreloadTypeTimestampMap;", "hitLimit", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "hitLimitByCounter", "hitLimitByMemoryPressure", "onTrimMemory", "", "level", "", "test_disablePreload", "disabled", "PRELOAD_TYPE", "PreloadTypeTimestampMap", "plugin-appbrand-integration_release"})
public final class a
{
  private static final a.b iLm;
  public static final a iLn;
  
  static
  {
    AppMethodBeat.i(134970);
    iLn = new a();
    iLm = new a.b();
    AppMethodBeat.o(134970);
  }
  
  public static final boolean a(a.a parama)
  {
    AppMethodBeat.i(143983);
    j.q(parama, "type");
    if (as.apq("__appbrand__preload__interval__limiter__").getBoolean("__key_test_disable__", false))
    {
      AppMethodBeat.o(143983);
      return true;
    }
    long l1;
    long l2;
    if (!b(parama))
    {
      l1 = bo.aoy();
      l2 = as.apq("__appbrand__preload__interval__limiter__").getLong("hold_until_ms", l1);
      if (l2 - l1 < TimeUnit.DAYS.toMillis(1L)) {
        break label112;
      }
      ab.w("MicroMsg.AppBrand.PreloadIntervalLimiter", "hitLimit, interval >= 1day, clear sp");
      as.apq("__appbrand__preload__interval__limiter__").edit().putLong("hold_until_ms", l1).apply();
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label124;
      }
      AppMethodBeat.o(143983);
      return true;
      label112:
      if (l2 <= l1) {
        break;
      }
    }
    label124:
    iLm.d(parama);
    AppMethodBeat.o(143983);
    return false;
  }
  
  private static boolean b(a.a parama)
  {
    AppMethodBeat.i(143984);
    if (a.a.iLr == parama)
    {
      AppMethodBeat.o(143984);
      return false;
    }
    try
    {
      l = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lRH, 30L);
      if (bo.av(iLm.c(parama)) <= TimeUnit.SECONDS.toMillis(l))
      {
        AppMethodBeat.o(143984);
        return true;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        long l = 30L;
      }
      AppMethodBeat.o(143984);
    }
    return false;
  }
  
  public static final void eN(boolean paramBoolean)
  {
    AppMethodBeat.i(134966);
    as.apq("__appbrand__preload__interval__limiter__").putBoolean("__key_test_disable__", paramBoolean).commit();
    AppMethodBeat.o(134966);
  }
  
  public static final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(134969);
    ab.i("MicroMsg.AppBrand.PreloadIntervalLimiter", "onTrimMemory level=" + paramInt + ", process=" + ah.getProcessName());
    h.qsU.B(915L, 21L);
    long l1 = TimeUnit.MINUTES.toMillis(((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lRG, 10L));
    long l2 = bo.aoy();
    as.apq("__appbrand__preload__interval__limiter__").edit().putLong("hold_until_ms", l1 + l2).apply();
    AppMethodBeat.o(134969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.a.a
 * JD-Core Version:    0.7.0.1
 */