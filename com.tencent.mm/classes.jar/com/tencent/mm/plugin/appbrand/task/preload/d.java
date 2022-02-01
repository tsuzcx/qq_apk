package com.tencent.mm.plugin.appbrand.task.preload;

import android.content.SharedPreferences.Editor;
import android.util.SparseLongArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import d.g.b.p;
import d.l;
import java.util.concurrent.TimeUnit;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter;", "", "()V", "FREQUENCY_LIMIT_INTERVAL_SECONDS", "", "KEY", "", "KEY_TEST_DISABLE", "MEMORY_PRESSURE_INTERVAL_MIN_DEFAULT_MINUTES", "SP", "TAG", "mLastPreloadTimestampMap", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PreloadTypeTimestampMap;", "forceDisablePreload", "", "getPreloadLevel", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "hitLimitByCounter", "hitLimitByMemoryPressure", "onTrimMemory", "", "level", "test_disablePreload", "disabled", "PRELOAD_SCENE", "PRELOAD_TYPE", "PreloadTypeTimestampMap", "plugin-appbrand-integration_release"})
public final class d
{
  private static final c mDY;
  public static final d mDZ;
  
  static
  {
    AppMethodBeat.i(51089);
    mDZ = new d();
    mDY = new c();
    AppMethodBeat.o(51089);
  }
  
  public static final int a(b paramb)
  {
    AppMethodBeat.i(223885);
    p.h(paramb, "type");
    boolean bool = b(paramb);
    int i;
    if ((j.DEBUG) || (j.IS_FLAVOR_RED))
    {
      Object localObject = com.tencent.mm.plugin.appbrand.app.d.jGw;
      localObject = com.tencent.mm.plugin.appbrand.app.d.LD();
      if (localObject == null) {
        p.gkB();
      }
      if (((ay)localObject).getBoolean("is_pre_load_downgrade_env", false))
      {
        i = 1;
        if ((!bool) && (i == 0)) {
          break label207;
        }
        if ((!j.DEBUG) && (!j.IS_FLAVOR_RED)) {
          break label179;
        }
      }
    }
    label179:
    for (int j = 1;; j = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qEC, 0))
    {
      if ((i == 0) || (j != 1)) {
        break label200;
      }
      AppMethodBeat.o(223885);
      return 1;
      long l1 = bu.fpO();
      long l2 = ay.aRW("__appbrand__preload__interval__limiter__").getLong("hold_until_ms", l1);
      if (l2 - l1 >= TimeUnit.DAYS.toMillis(1L))
      {
        ae.w("MicroMsg.AppBrand.PreloadIntervalLimiter", "hitLimit, interval >= 1day, clear sp");
        ay.aRW("__appbrand__preload__interval__limiter__").edit().putLong("hold_until_ms", l1).apply();
      }
      while (l2 <= l1)
      {
        i = 0;
        break;
      }
      i = 1;
      break;
    }
    label200:
    AppMethodBeat.o(223885);
    return -1;
    label207:
    mDY.d(paramb);
    AppMethodBeat.o(223885);
    return 2;
  }
  
  private static boolean b(b paramb)
  {
    AppMethodBeat.i(51087);
    if ((j.DEBUG) || (j.IS_FLAVOR_RED))
    {
      Object localObject = com.tencent.mm.plugin.appbrand.app.d.jGw;
      localObject = com.tencent.mm.plugin.appbrand.app.d.LD();
      if (localObject == null) {
        p.gkB();
      }
      if (((ay)localObject).getBoolean("is_pre_load_downgrade_env", false))
      {
        AppMethodBeat.o(51087);
        return false;
      }
    }
    if (b.mEl == paramb)
    {
      AppMethodBeat.o(51087);
      return false;
    }
    try
    {
      l = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qwC, 30L);
      if (bu.aO(mDY.c(paramb)) <= TimeUnit.SECONDS.toMillis(l))
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
  
  public static final boolean bzM()
  {
    AppMethodBeat.i(51086);
    boolean bool = ay.aRW("__appbrand__preload__interval__limiter__").getBoolean("__key_test_disable__", false);
    AppMethodBeat.o(51086);
    return bool;
  }
  
  public static final void hC(boolean paramBoolean)
  {
    AppMethodBeat.i(51084);
    ay.aRW("__appbrand__preload__interval__limiter__").putBoolean("__key_test_disable__", paramBoolean).commit();
    AppMethodBeat.o(51084);
  }
  
  public static final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(51088);
    ae.i("MicroMsg.AppBrand.PreloadIntervalLimiter", "onTrimMemory level=" + paramInt + ", process=" + ak.getProcessName());
    com.tencent.mm.plugin.report.service.g.yxI.A(915L, 21L);
    switch (paramInt)
    {
    }
    for (;;)
    {
      long l1 = TimeUnit.MINUTES.toMillis(((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qwB, 10L));
      long l2 = bu.fpO();
      ay.aRW("__appbrand__preload__interval__limiter__").edit().putLong("hold_until_ms", l1 + l2).apply();
      AppMethodBeat.o(51088);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.A(915L, 24L);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.A(915L, 25L);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.A(915L, 26L);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.A(915L, 27L);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.A(915L, 28L);
      continue;
      com.tencent.mm.plugin.report.service.g.yxI.A(915L, 29L);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_SCENE;", "", "(Ljava/lang/String;I)V", "DEFAULT", "ACCOUNT_INIT", "APP_FOREGROUND", "MAIN_PULLDOWN", "APPBRAND_LAUNCHER", "SYNC_WXA_ATTRS_ON_APP_LAUNCH", "Companion", "plugin-appbrand-integration_release"})
  public static enum a
  {
    public static final a mEh;
    
    static
    {
      AppMethodBeat.i(51072);
      a locala1 = new a("DEFAULT", 0);
      mEa = locala1;
      a locala2 = new a("ACCOUNT_INIT", 1);
      mEb = locala2;
      a locala3 = new a("APP_FOREGROUND", 2);
      mEc = locala3;
      a locala4 = new a("MAIN_PULLDOWN", 3);
      mEd = locala4;
      a locala5 = new a("APPBRAND_LAUNCHER", 4);
      mEe = locala5;
      a locala6 = new a("SYNC_WXA_ATTRS_ON_APP_LAUNCH", 5);
      mEf = locala6;
      mEg = new a[] { locala1, locala2, locala3, locala4, locala5, locala6 };
      mEh = new a((byte)0);
      AppMethodBeat.o(51072);
    }
    
    private a() {}
    
    public static final boolean b(a parama)
    {
      AppMethodBeat.i(51075);
      if (parama == null)
      {
        AppMethodBeat.o(51075);
        return false;
      }
      if (d.a.e.contains(new a[] { mEb, mEc, mEd, mEe, mEf }, parama))
      {
        AppMethodBeat.o(51075);
        return true;
      }
      AppMethodBeat.o(51075);
      return false;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_SCENE$Companion;", "", "()V", "shouldIgnoreFrequencyLimit", "", "scene", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_SCENE;", "plugin-appbrand-integration_release"})
    public static final class a {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "", "(Ljava/lang/String;I)V", "WASERVICE", "WAGAME", "WASERVICE_FAKE_NATIVE", "NIL", "Companion", "plugin-appbrand-integration_release"})
  public static enum b
  {
    @Deprecated
    public static final a mEn;
    
    static
    {
      AppMethodBeat.i(51077);
      b localb1 = new b("WASERVICE", 0);
      mEi = localb1;
      b localb2 = new b("WAGAME", 1);
      mEj = localb2;
      b localb3 = new b("WASERVICE_FAKE_NATIVE", 2);
      mEk = localb3;
      b localb4 = new b("NIL", 3);
      mEl = localb4;
      mEm = new b[] { localb1, localb2, localb3, localb4 };
      mEn = new a((byte)0);
      AppMethodBeat.o(51077);
    }
    
    private b() {}
    
    public static final b m(com.tencent.mm.plugin.appbrand.task.e parame)
    {
      AppMethodBeat.i(51080);
      p.h(parame, "type");
      switch (e.cqt[parame.ordinal()])
      {
      default: 
        parame = mEl;
        AppMethodBeat.o(51080);
        return parame;
      case 1: 
        parame = mEi;
        AppMethodBeat.o(51080);
        return parame;
      }
      parame = mEj;
      AppMethodBeat.o(51080);
      return parame;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE$Companion;", "", "()V", "valueOf", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "type", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "plugin-appbrand-integration_release"})
    static final class a {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PreloadTypeTimestampMap;", "Landroid/util/SparseLongArray;", "()V", "get", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "update", "", "plugin-appbrand-integration_release"})
  static final class c
    extends SparseLongArray
  {
    public c()
    {
      super();
      AppMethodBeat.i(51083);
      AppMethodBeat.o(51083);
    }
    
    public final long c(d.b paramb)
    {
      AppMethodBeat.i(51081);
      p.h(paramb, "type");
      if (d.b.mEl == paramb)
      {
        AppMethodBeat.o(51081);
        return 0L;
      }
      long l = super.get(paramb.ordinal(), 0L);
      AppMethodBeat.o(51081);
      return l;
    }
    
    public final void d(d.b paramb)
    {
      AppMethodBeat.i(51082);
      p.h(paramb, "type");
      super.put(paramb.ordinal(), bu.HQ());
      AppMethodBeat.o(51082);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.d
 * JD-Core Version:    0.7.0.1
 */