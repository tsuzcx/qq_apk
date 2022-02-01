package com.tencent.mm.plugin.appbrand.task.preload;

import android.content.SharedPreferences.Editor;
import android.util.SparseLongArray;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.TimeUnit;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter;", "", "()V", "FREQUENCY_LIMIT_INTERVAL_SECONDS", "", "KEY", "", "KEY_TEST_DISABLE", "MEMORY_PRESSURE_INTERVAL_MIN_DEFAULT_MINUTES", "SP", "TAG", "mLastPreloadTimestampMap", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PreloadTypeTimestampMap;", "forceDisablePreload", "", "getPreloadLevel", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "reasons", "Lkotlin/Function2;", "", "getPreloadReportIDKey", "isGame", "hitLimitByCounter", "hitLimitByMemoryPressure", "isOpenPreloadDowngrade", "onTrimMemory", "level", "reportPreloadLimited", "test_disablePreload", "disabled", "PRELOAD_TYPE", "PreloadTypeTimestampMap", "plugin-appbrand-integration_release"})
public final class e
{
  private static final b qSA;
  public static final e qSB;
  
  static
  {
    AppMethodBeat.i(51089);
    qSB = new e();
    qSA = new b();
    AppMethodBeat.o(51089);
  }
  
  public static final int a(a parama, m<? super Boolean, ? super Boolean, x> paramm)
  {
    AppMethodBeat.i(282255);
    p.k(parama, "type");
    p.k(paramm, "reasons");
    boolean bool = a(parama);
    long l1 = Util.nowMilliSecond();
    long l2 = MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").getLong("hold_until_ms", l1);
    if (l2 - l1 >= TimeUnit.DAYS.toMillis(1L))
    {
      Log.w("MicroMsg.AppBrand.PreloadIntervalLimiter", "hitLimit, interval >= 1day, clear sp");
      MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").edit().putLong("hold_until_ms", l1).apply();
    }
    for (int i = 0;; i = 1)
    {
      paramm.invoke(Boolean.valueOf(bool), Boolean.FALSE);
      if ((!bool) && (i == 0)) {
        break label141;
      }
      if (i == 0) {
        break label134;
      }
      AppMethodBeat.o(282255);
      return 1;
      if (l2 <= l1) {
        break;
      }
    }
    label134:
    AppMethodBeat.o(282255);
    return -1;
    label141:
    qSA.c(parama);
    AppMethodBeat.o(282255);
    return 2;
  }
  
  public static final void a(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(282258);
    p.k(parama, "type");
    switch (g.$EnumSwitchMapping$0[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(282258);
      return;
      if (paramBoolean1)
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(915, 36);
        AppMethodBeat.o(282258);
        return;
      }
      if (paramBoolean2) {
        com.tencent.mm.plugin.report.service.h.IzE.el(915, 23);
      }
      AppMethodBeat.o(282258);
      return;
      if (paramBoolean1)
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(915, 35);
        AppMethodBeat.o(282258);
        return;
      }
      if (paramBoolean2) {
        com.tencent.mm.plugin.report.service.h.IzE.el(915, 22);
      }
    }
  }
  
  private static boolean a(a parama)
  {
    AppMethodBeat.i(51087);
    if (a.qSF == parama)
    {
      AppMethodBeat.o(51087);
      return false;
    }
    try
    {
      l = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vui, 30L);
      if (Util.ticksToNow(qSA.b(parama)) <= TimeUnit.SECONDS.toMillis(l))
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
  
  public static final boolean cjl()
  {
    AppMethodBeat.i(51086);
    boolean bool = MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").getBoolean("__key_test_disable__", false);
    AppMethodBeat.o(51086);
    return bool;
  }
  
  public static final int jB(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1539;
    }
    return 1144;
  }
  
  public static final void jC(boolean paramBoolean)
  {
    AppMethodBeat.i(51084);
    MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").putBoolean("__key_test_disable__", paramBoolean).commit();
    AppMethodBeat.o(51084);
  }
  
  public static final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(51088);
    Log.i("MicroMsg.AppBrand.PreloadIntervalLimiter", "onTrimMemory level=" + paramInt + ", process=" + MMApplicationContext.getProcessName());
    com.tencent.mm.plugin.report.service.h.IzE.F(915L, 21L);
    switch (paramInt)
    {
    }
    for (;;)
    {
      long l1 = TimeUnit.MINUTES.toMillis(((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vuh, 10L));
      long l2 = Util.nowMilliSecond();
      MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").edit().putLong("hold_until_ms", l1 + l2).apply();
      AppMethodBeat.o(51088);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.F(915L, 24L);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.F(915L, 25L);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.F(915L, 26L);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.F(915L, 27L);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.F(915L, 28L);
      continue;
      com.tencent.mm.plugin.report.service.h.IzE.F(915L, 29L);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "", "(Ljava/lang/String;I)V", "WASERVICE", "WAGAME", "WASERVICE_FAKE_NATIVE", "NIL", "Companion", "plugin-appbrand-integration_release"})
  public static enum a
  {
    public static final a qSH;
    
    static
    {
      AppMethodBeat.i(51077);
      a locala1 = new a("WASERVICE", 0);
      qSC = locala1;
      a locala2 = new a("WAGAME", 1);
      qSD = locala2;
      a locala3 = new a("WASERVICE_FAKE_NATIVE", 2);
      qSE = locala3;
      a locala4 = new a("NIL", 3);
      qSF = locala4;
      qSG = new a[] { locala1, locala2, locala3, locala4 };
      qSH = new a((byte)0);
      AppMethodBeat.o(51077);
    }
    
    private a() {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE$Companion;", "", "()V", "valueOf", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "type", "Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "plugin-appbrand-integration_release"})
    public static final class a
    {
      public static e.a h(LuggageServiceType paramLuggageServiceType)
      {
        AppMethodBeat.i(278466);
        p.k(paramLuggageServiceType, "type");
        switch (f.$EnumSwitchMapping$0[paramLuggageServiceType.ordinal()])
        {
        default: 
          paramLuggageServiceType = e.a.qSF;
          AppMethodBeat.o(278466);
          return paramLuggageServiceType;
        case 1: 
          paramLuggageServiceType = e.a.qSC;
          AppMethodBeat.o(278466);
          return paramLuggageServiceType;
        }
        paramLuggageServiceType = e.a.qSD;
        AppMethodBeat.o(278466);
        return paramLuggageServiceType;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PreloadTypeTimestampMap;", "Landroid/util/SparseLongArray;", "()V", "get", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "update", "", "plugin-appbrand-integration_release"})
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
      p.k(parama, "type");
      if (e.a.qSF == parama)
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
      p.k(parama, "type");
      super.put(parama.ordinal(), Util.currentTicks());
      AppMethodBeat.o(51082);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.e
 * JD-Core Version:    0.7.0.1
 */