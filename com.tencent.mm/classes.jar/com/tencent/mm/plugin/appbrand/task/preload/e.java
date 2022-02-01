package com.tencent.mm.plugin.appbrand.task.preload;

import android.content.SharedPreferences.Editor;
import android.util.SparseLongArray;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.task.o;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter;", "", "()V", "FREQUENCY_LIMIT_INTERVAL_SECONDS", "", "KEY", "", "KEY_TEST_DISABLE", "MEMORY_PRESSURE_INTERVAL_MIN_DEFAULT_MINUTES", "SP", "TAG", "mLastPreloadTimestampMap", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PreloadTypeTimestampMap;", "forceDisablePreload", "", "getPreloadLevel", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "reasons", "Lkotlin/Function2;", "", "getPreloadReportIDKey", "isGame", "hitLimitByCounter", "hitLimitByMemoryPressure", "isOpenPreloadDowngrade", "isPreloadInBackgroundDisallowed", "scene", "Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE;", "onTrimMemory", "level", "reportPreloadLimited", "test_disablePreload", "disabled", "PRELOAD_TYPE", "PreloadTypeTimestampMap", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e tXf;
  private static final b tXg;
  
  static
  {
    AppMethodBeat.i(51089);
    tXf = new e();
    tXg = new b();
    AppMethodBeat.o(51089);
  }
  
  public static final int a(a parama, m<? super Boolean, ? super Boolean, ah> paramm)
  {
    int i = 1;
    AppMethodBeat.i(318721);
    s.u(parama, "type");
    s.u(paramm, "reasons");
    boolean bool2 = a(parama);
    long l1 = Util.nowMilliSecond();
    long l2 = MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").getLong("hold_until_ms", l1);
    boolean bool1;
    if (l2 - l1 >= TimeUnit.DAYS.toMillis(1L))
    {
      Log.w("MicroMsg.AppBrand.PreloadIntervalLimiter", "hitLimit, interval >= 1day, clear sp");
      MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").edit().putLong("hold_until_ms", l1).apply();
      bool1 = false;
      label91:
      paramm.invoke(Boolean.valueOf(bool2), Boolean.FALSE);
      if ((!bool2) && (!bool1)) {
        break label205;
      }
      if (!bool1) {
        break label200;
      }
      tXg.c(parama);
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.PreloadIntervalLimiter", "getPreloadLevel, returns " + i + " for: type:" + parama + ", hitLimitByCounter:" + bool2 + ", hitLimitByMemoryPressure:" + bool1 + ", isOpenPreloadDowngrade:true");
      AppMethodBeat.o(318721);
      return i;
      if (l2 <= l1) {
        break;
      }
      bool1 = true;
      break label91;
      label200:
      i = -1;
      continue;
      label205:
      tXg.c(parama);
      i = 2;
    }
  }
  
  public static final void a(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(318723);
    s.u(parama, "type");
    switch (c.$EnumSwitchMapping$0[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(318723);
      return;
      if (paramBoolean1)
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(915, 36);
        AppMethodBeat.o(318723);
        return;
      }
      if (paramBoolean2)
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(915, 23);
        AppMethodBeat.o(318723);
        return;
        if (paramBoolean1)
        {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(915, 35);
          AppMethodBeat.o(318723);
          return;
        }
        if (paramBoolean2) {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(915, 22);
        }
      }
    }
  }
  
  private static boolean a(a parama)
  {
    AppMethodBeat.i(51087);
    if (a.tXl == parama)
    {
      AppMethodBeat.o(51087);
      return false;
    }
    try
    {
      l = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yGN, 30L);
      if (Util.ticksToNow(tXg.b(parama)) <= TimeUnit.SECONDS.toMillis(l))
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
  
  public static final boolean cKl()
  {
    AppMethodBeat.i(51086);
    if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) && (MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").getBoolean("__key_test_disable__", false)))
    {
      AppMethodBeat.o(51086);
      return true;
    }
    AppMethodBeat.o(51086);
    return false;
  }
  
  public static boolean e(ab paramab)
  {
    AppMethodBeat.i(318717);
    s.u(paramab, "scene");
    if (ab.tTQ == paramab)
    {
      AppMethodBeat.o(318717);
      return false;
    }
    boolean bool = o.cKc();
    AppMethodBeat.o(318717);
    return bool;
  }
  
  public static final int kP(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1539;
    }
    return 1144;
  }
  
  public static final void kQ(boolean paramBoolean)
  {
    AppMethodBeat.i(51084);
    MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").putBoolean("__key_test_disable__", paramBoolean).commit();
    AppMethodBeat.o(51084);
  }
  
  public static final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(51088);
    Log.i("MicroMsg.AppBrand.PreloadIntervalLimiter", "onTrimMemory level=" + paramInt + ", process=" + MMApplicationContext.getProcessName());
    com.tencent.mm.plugin.report.service.h.OAn.p(915L, 21L, 1L);
    switch (paramInt)
    {
    }
    for (;;)
    {
      long l1 = TimeUnit.MINUTES.toMillis(((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yGM, 10L));
      long l2 = Util.nowMilliSecond();
      MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").edit().putLong("hold_until_ms", l1 + l2).apply();
      AppMethodBeat.o(51088);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(915L, 24L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.p(915L, 25L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.p(915L, 26L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.p(915L, 27L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.p(915L, 28L, 1L);
      continue;
      com.tencent.mm.plugin.report.service.h.OAn.p(915L, 29L, 1L);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "", "(Ljava/lang/String;I)V", "WASERVICE", "WAGAME", "WASERVICE_FAKE_NATIVE", "NIL", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    public static final a tXh;
    
    static
    {
      AppMethodBeat.i(51077);
      tXi = new a("WASERVICE", 0);
      tXj = new a("WAGAME", 1);
      tXk = new a("WASERVICE_FAKE_NATIVE", 2);
      tXl = new a("NIL", 3);
      tXm = new a[] { tXi, tXj, tXk, tXl };
      tXh = new a((byte)0);
      AppMethodBeat.o(51077);
    }
    
    private a() {}
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE$Companion;", "", "()V", "valueOf", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "type", "Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static e.a h(LuggageServiceType paramLuggageServiceType)
      {
        AppMethodBeat.i(318683);
        s.u(paramLuggageServiceType, "type");
        switch (a.$EnumSwitchMapping$0[paramLuggageServiceType.ordinal()])
        {
        default: 
          paramLuggageServiceType = e.a.tXl;
          AppMethodBeat.o(318683);
          return paramLuggageServiceType;
        case 1: 
          paramLuggageServiceType = e.a.tXi;
          AppMethodBeat.o(318683);
          return paramLuggageServiceType;
        }
        paramLuggageServiceType = e.a.tXj;
        AppMethodBeat.o(318683);
        return paramLuggageServiceType;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PreloadTypeTimestampMap;", "Landroid/util/SparseLongArray;", "()V", "get", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "update", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      s.u(parama, "type");
      if (e.a.tXl == parama)
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
      s.u(parama, "type");
      super.put(parama.ordinal(), Util.currentTicks());
      AppMethodBeat.o(51082);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.e
 * JD-Core Version:    0.7.0.1
 */