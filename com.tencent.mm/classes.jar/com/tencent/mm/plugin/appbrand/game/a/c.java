package com.tencent.mm.plugin.appbrand.game.a;

import a.aa;
import a.f;
import a.f.a.a;
import a.f.b.j;
import a.f.b.t;
import a.j.k;
import a.l;
import a.l.m;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ah;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigGCFactor;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "clicfg_magicbrush_autogcfactor_max_canvas", "getClicfg_magicbrush_autogcfactor_max_canvas", "()F", "clicfg_magicbrush_autogcfactor_max_canvas$delegate", "Lkotlin/Lazy;", "clicfg_magicbrush_autogcfactor_min_canvas", "getClicfg_magicbrush_autogcfactor_min_canvas", "clicfg_magicbrush_autogcfactor_min_canvas$delegate", "clicfg_magicbrush_autogcfactor_total_memory_ratio", "getClicfg_magicbrush_autogcfactor_total_memory_ratio", "clicfg_magicbrush_autogcfactor_total_memory_ratio$delegate", "configMemory", "Ljava/lang/Float;", "memoryInfo", "Landroid/app/ActivityManager$MemoryInfo;", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableKv", "getActuallyGcFactor", "context", "Landroid/content/Context;", "getAvailableMemory", "", "getConfig", "()Ljava/lang/Float;", "getConfigDefaultValue", "getGcFactorAutomatic", "getMemoryUnit", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Float;", "plugin-appbrand-integration_release"})
public final class c
  extends g<Float>
{
  private static final String TAG;
  private static Float hse;
  private static final f hsf;
  private static final f hsg;
  private static final f hsh;
  private static ActivityManager.MemoryInfo hsi;
  public static final c hsj;
  
  static
  {
    AppMethodBeat.i(134612);
    eOJ = new k[] { (k)a.f.b.v.a(new t(a.f.b.v.aG(c.class), "clicfg_magicbrush_autogcfactor_min_canvas", "getClicfg_magicbrush_autogcfactor_min_canvas()F")), (k)a.f.b.v.a(new t(a.f.b.v.aG(c.class), "clicfg_magicbrush_autogcfactor_max_canvas", "getClicfg_magicbrush_autogcfactor_max_canvas()F")), (k)a.f.b.v.a(new t(a.f.b.v.aG(c.class), "clicfg_magicbrush_autogcfactor_total_memory_ratio", "getClicfg_magicbrush_autogcfactor_total_memory_ratio()F")) };
    hsj = new c();
    StringBuilder localStringBuilder = new StringBuilder("MicroMsg.WAGameGcFactor");
    String str = ah.getProcessName();
    j.p(str, "MMApplicationContext.getProcessName()");
    TAG = m.h(str, "com.tencent.mm", "", false);
    hsf = a.g.j((a)c.b.hsl);
    hsg = a.g.j((a)c.a.hsk);
    hsh = a.g.j((a)c.c.hsm);
    AppMethodBeat.o(134612);
  }
  
  protected final String aAs()
  {
    return "gcfactor";
  }
  
  protected final a.a aAt()
  {
    return a.a.lUW;
  }
  
  public final float cI(Context paramContext)
  {
    AppMethodBeat.i(134616);
    j.q(paramContext, "context");
    if (hse != null)
    {
      paramContext = hse;
      if (paramContext == null) {
        j.ebi();
      }
      f1 = paramContext.floatValue();
      AppMethodBeat.o(134616);
      return f1;
    }
    float f1 = ((Number)super.Uw()).floatValue();
    if (f1 != -1.0F)
    {
      d.i(TAG, "rawConfig == [" + f1 + "] != -1, just return");
      hse = Float.valueOf(f1);
      AppMethodBeat.o(134616);
      return f1;
    }
    Object localObject = paramContext.getResources();
    j.p(localObject, "context.resources");
    f1 = ((Resources)localObject).getDisplayMetrics().density;
    localObject = paramContext.getResources();
    j.p(localObject, "context.resources");
    float f2 = ((Resources)localObject).getDisplayMetrics().widthPixels / f1;
    localObject = paramContext.getResources();
    j.p(localObject, "context.resources");
    f1 = 2.0F * (((Resources)localObject).getDisplayMetrics().heightPixels / f1 * f2 * 4.0F);
    if (f1 > 0.0F) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramContext = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(134616);
      throw paramContext;
    }
    if (hsi == null)
    {
      paramContext = paramContext.getSystemService("activity");
      if (paramContext == null)
      {
        paramContext = new a.v("null cannot be cast to non-null type android.app.ActivityManager");
        AppMethodBeat.o(134616);
        throw paramContext;
      }
      paramContext = (ActivityManager)paramContext;
      hsi = new ActivityManager.MemoryInfo();
      paramContext.getMemoryInfo(hsi);
      paramContext = TAG;
      localObject = new StringBuilder("getAvailableMemory avail = [");
      ActivityManager.MemoryInfo localMemoryInfo = hsi;
      if (localMemoryInfo == null) {
        j.ebi();
      }
      localObject = ((StringBuilder)localObject).append(localMemoryInfo.availMem).append("] total = [");
      localMemoryInfo = hsi;
      if (localMemoryInfo == null) {
        j.ebi();
      }
      d.i(paramContext, localMemoryInfo.totalMem + ']');
    }
    paramContext = hsi;
    if (paramContext == null) {
      j.ebi();
    }
    f2 = (float)paramContext.totalMem;
    long l = (((Number)hsh.getValue()).floatValue() * f2);
    f2 = (float)l / f1;
    f2 = Math.max(((Number)hsf.getValue()).floatValue(), f2);
    f2 = Math.min(((Number)hsg.getValue()).floatValue(), f2);
    float f3 = 67108864.0F / (f2 * f1);
    d.i(TAG, "calculate gc_factor automatically unit = [" + f1 / 1024.0F + "]kb limit = [65536]kb system = [" + l / 1024L + "]kb raw = [" + f2 + ':' + (float)l / f1 + "] actually = [" + f3 + ']');
    paramContext = Float.valueOf(f3);
    hse = paramContext;
    if (paramContext == null) {
      j.ebi();
    }
    f1 = paramContext.floatValue();
    AppMethodBeat.o(134616);
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.c
 * JD-Core Version:    0.7.0.1
 */