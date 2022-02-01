package com.tencent.mm.plugin.appbrand.task.preload;

import android.content.SharedPreferences.Editor;
import android.util.SparseLongArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.TimeUnit;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter;", "", "()V", "FREQUENCY_LIMIT_INTERVAL_SECONDS", "", "KEY", "", "KEY_TEST_DISABLE", "MEMORY_PRESSURE_INTERVAL_MIN_DEFAULT_MINUTES", "SP", "TAG", "mLastPreloadTimestampMap", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PreloadTypeTimestampMap;", "forceDisablePreload", "", "getPreloadLevel", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "reasons", "Lkotlin/Function2;", "", "getPreloadReportIDKey", "isGame", "hitLimitByCounter", "hitLimitByMemoryPressure", "isOpenPreloadDowngrade", "onTrimMemory", "level", "reportPreloadLimited", "test_disablePreload", "disabled", "PRELOAD_TYPE", "PreloadTypeTimestampMap", "plugin-appbrand-integration_release"})
public final class e
{
  private static final b nQV;
  public static final e nQW;
  
  static
  {
    AppMethodBeat.i(51089);
    nQW = new e();
    nQV = new b();
    AppMethodBeat.o(51089);
  }
  
  public static final int a(a parama, m<? super Boolean, ? super Boolean, x> paramm)
  {
    boolean bool2 = false;
    AppMethodBeat.i(229451);
    p.h(parama, "type");
    p.h(paramm, "reasons");
    boolean bool3 = a(parama);
    long l1 = Util.nowMilliSecond();
    long l2 = MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").getLong("hold_until_ms", l1);
    int j;
    label92:
    int i;
    if (l2 - l1 >= TimeUnit.DAYS.toMillis(1L))
    {
      Log.w("MicroMsg.AppBrand.PreloadIntervalLimiter", "hitLimit, interval >= 1day, clear sp");
      MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").edit().putLong("hold_until_ms", l1).apply();
      j = 0;
      if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED)) {
        break label179;
      }
      i = 1;
    }
    for (;;)
    {
      boolean bool1 = bool2;
      if (j != 0)
      {
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
      paramm.invoke(Boolean.valueOf(bool3), Boolean.valueOf(bool1));
      if ((!bool3) && (j == 0)) {
        break label217;
      }
      if ((j == 0) || (i == 0)) {
        break label210;
      }
      AppMethodBeat.o(229451);
      return 1;
      if (l2 <= l1) {
        break;
      }
      j = 1;
      break label92;
      label179:
      if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rXL, 0) == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label210:
    AppMethodBeat.o(229451);
    return -1;
    label217:
    nQV.c(parama);
    AppMethodBeat.o(229451);
    return 2;
  }
  
  public static final void a(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(229452);
    p.h(parama, "type");
    switch (g.$EnumSwitchMapping$0[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(229452);
      return;
      if (paramBoolean1)
      {
        h.CyF.dN(915, 36);
        AppMethodBeat.o(229452);
        return;
      }
      if (paramBoolean2) {
        h.CyF.dN(915, 23);
      }
      AppMethodBeat.o(229452);
      return;
      if (paramBoolean1)
      {
        h.CyF.dN(915, 35);
        AppMethodBeat.o(229452);
        return;
      }
      if (paramBoolean2) {
        h.CyF.dN(915, 22);
      }
    }
  }
  
  private static boolean a(a parama)
  {
    AppMethodBeat.i(51087);
    if (a.nRa == parama)
    {
      AppMethodBeat.o(51087);
      return false;
    }
    try
    {
      l = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rOn, 30L);
      if (Util.ticksToNow(nQV.b(parama)) <= TimeUnit.SECONDS.toMillis(l))
      {
        AppMethodBeat.o(51087);
        return true;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        long l = 30L;
      }
      AppMethodBeat.o(51087);
    }
    return false;
  }
  
  public static final boolean bWG()
  {
    AppMethodBeat.i(51086);
    boolean bool = MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").getBoolean("__key_test_disable__", false);
    AppMethodBeat.o(51086);
    return bool;
  }
  
  public static final int iF(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1539;
    }
    return 1144;
  }
  
  public static final void iG(boolean paramBoolean)
  {
    AppMethodBeat.i(51084);
    MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").putBoolean("__key_test_disable__", paramBoolean).commit();
    AppMethodBeat.o(51084);
  }
  
  public static final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(51088);
    Log.i("MicroMsg.AppBrand.PreloadIntervalLimiter", "onTrimMemory level=" + paramInt + ", process=" + MMApplicationContext.getProcessName());
    h.CyF.F(915L, 21L);
    switch (paramInt)
    {
    }
    for (;;)
    {
      long l1 = TimeUnit.MINUTES.toMillis(((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rOm, 10L));
      long l2 = Util.nowMilliSecond();
      MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").edit().putLong("hold_until_ms", l1 + l2).apply();
      AppMethodBeat.o(51088);
      return;
      h.CyF.F(915L, 24L);
      continue;
      h.CyF.F(915L, 25L);
      continue;
      h.CyF.F(915L, 26L);
      continue;
      h.CyF.F(915L, 27L);
      continue;
      h.CyF.F(915L, 28L);
      continue;
      h.CyF.F(915L, 29L);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "", "(Ljava/lang/String;I)V", "WASERVICE", "WAGAME", "WASERVICE_FAKE_NATIVE", "NIL", "Companion", "plugin-appbrand-integration_release"})
  public static enum a
  {
    public static final a nRc;
    
    static
    {
      AppMethodBeat.i(51077);
      a locala1 = new a("WASERVICE", 0);
      nQX = locala1;
      a locala2 = new a("WAGAME", 1);
      nQY = locala2;
      a locala3 = new a("WASERVICE_FAKE_NATIVE", 2);
      nQZ = locala3;
      a locala4 = new a("NIL", 3);
      nRa = locala4;
      nRb = new a[] { locala1, locala2, locala3, locala4 };
      nRc = new a((byte)0);
      AppMethodBeat.o(51077);
    }
    
    private a() {}
    
    public static final a A(com.tencent.mm.plugin.appbrand.task.g paramg)
    {
      AppMethodBeat.i(51080);
      paramg = a.A(paramg);
      AppMethodBeat.o(51080);
      return paramg;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE$Companion;", "", "()V", "valueOf", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "type", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "plugin-appbrand-integration_release"})
    public static final class a
    {
      public static e.a A(com.tencent.mm.plugin.appbrand.task.g paramg)
      {
        AppMethodBeat.i(229449);
        p.h(paramg, "type");
        switch (f.$EnumSwitchMapping$0[paramg.ordinal()])
        {
        default: 
          paramg = e.a.nRa;
          AppMethodBeat.o(229449);
          return paramg;
        case 1: 
          paramg = e.a.nQX;
          AppMethodBeat.o(229449);
          return paramg;
        }
        paramg = e.a.nQY;
        AppMethodBeat.o(229449);
        return paramg;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PreloadTypeTimestampMap;", "Landroid/util/SparseLongArray;", "()V", "get", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "update", "", "plugin-appbrand-integration_release"})
  static final class b
    extends SparseLongArray
  {
    public b()
    {
      super();
      AppMethodBeat.i(51083);
      AppMethodBeat.o(51083);
    }
    
    public final long b(e.a parama)
    {
      AppMethodBeat.i(51081);
      p.h(parama, "type");
      if (e.a.nRa == parama)
      {
        AppMethodBeat.o(51081);
        return 0L;
      }
      long l = super.get(parama.ordinal(), 0L);
      AppMethodBeat.o(51081);
      return l;
    }
    
    public final void c(e.a parama)
    {
      AppMethodBeat.i(51082);
      p.h(parama, "type");
      super.put(parama.ordinal(), Util.currentTicks());
      AppMethodBeat.o(51082);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.e
 * JD-Core Version:    0.7.0.1
 */