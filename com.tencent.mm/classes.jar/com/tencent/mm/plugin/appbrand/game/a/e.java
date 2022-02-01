package com.tencent.mm.plugin.appbrand.game.a;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.z;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigGCFactor;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "clicfg_magicbrush_autogcfactor_max_canvas", "getClicfg_magicbrush_autogcfactor_max_canvas", "()F", "clicfg_magicbrush_autogcfactor_max_canvas$delegate", "Lkotlin/Lazy;", "clicfg_magicbrush_autogcfactor_min_canvas", "getClicfg_magicbrush_autogcfactor_min_canvas", "clicfg_magicbrush_autogcfactor_min_canvas$delegate", "clicfg_magicbrush_autogcfactor_total_memory_ratio", "getClicfg_magicbrush_autogcfactor_total_memory_ratio", "clicfg_magicbrush_autogcfactor_total_memory_ratio$delegate", "configMemory", "Ljava/lang/Float;", "memoryInfo", "Landroid/app/ActivityManager$MemoryInfo;", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableKv", "getActuallyGcFactor", "context", "Landroid/content/Context;", "getAvailableMemory", "", "getConfig", "()Ljava/lang/Float;", "getConfigDefaultValue", "getGcFactorAutomatic", "getMemoryUnit", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Float;", "plugin-appbrand-integration_release"})
public final class e
  extends x<Float>
{
  private static final String TAG;
  private static Float omo;
  private static final f omp;
  private static final f omq;
  private static final f omr;
  private static ActivityManager.MemoryInfo oms;
  public static final e omt;
  
  static
  {
    AppMethodBeat.i(50366);
    omt = new e();
    StringBuilder localStringBuilder = new StringBuilder("MicroMsg.WAGameGcFactor");
    String str1 = MMApplicationContext.getProcessName();
    p.j(str1, "MMApplicationContext.getProcessName()");
    String str2 = MMApplicationContext.getPackageName();
    p.j(str2, "MMApplicationContext.getPackageName()");
    TAG = n.l(str1, str2, "", false);
    omp = g.ar((a)b.omv);
    omq = g.ar((a)a.omu);
    omr = g.ar((a)c.omw);
    AppMethodBeat.o(50366);
  }
  
  protected final String bOt()
  {
    return "gcfactor";
  }
  
  protected final b.a bOu()
  {
    return b.a.vCu;
  }
  
  public final float dI(Context paramContext)
  {
    AppMethodBeat.i(50370);
    p.k(paramContext, "context");
    if (omo != null)
    {
      paramContext = omo;
      if (paramContext == null) {
        p.iCn();
      }
      f1 = paramContext.floatValue();
      AppMethodBeat.o(50370);
      return f1;
    }
    float f1 = ((Number)super.aUb()).floatValue();
    if (f1 != -1.0F)
    {
      Log.i(TAG, "rawConfig == [" + f1 + "] != -1, just return");
      omo = Float.valueOf(f1);
      AppMethodBeat.o(50370);
      return f1;
    }
    Object localObject = paramContext.getResources();
    p.j(localObject, "context.resources");
    f1 = ((Resources)localObject).getDisplayMetrics().density;
    localObject = paramContext.getResources();
    p.j(localObject, "context.resources");
    float f2 = ((Resources)localObject).getDisplayMetrics().widthPixels / f1;
    localObject = paramContext.getResources();
    p.j(localObject, "context.resources");
    f1 = 2.0F * (((Resources)localObject).getDisplayMetrics().heightPixels / f1 * f2 * 4.0F);
    if (f1 > 0.0F) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
    {
      paramContext = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(50370);
      throw paramContext;
    }
    if (oms == null)
    {
      paramContext = paramContext.getSystemService("activity");
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.app.ActivityManager");
        AppMethodBeat.o(50370);
        throw paramContext;
      }
      paramContext = (ActivityManager)paramContext;
      oms = new ActivityManager.MemoryInfo();
      paramContext.getMemoryInfo(oms);
      paramContext = TAG;
      localObject = new StringBuilder("getAvailableMemory avail = [");
      ActivityManager.MemoryInfo localMemoryInfo = oms;
      if (localMemoryInfo == null) {
        p.iCn();
      }
      localObject = ((StringBuilder)localObject).append(localMemoryInfo.availMem).append("] total = [");
      localMemoryInfo = oms;
      if (localMemoryInfo == null) {
        p.iCn();
      }
      Log.i(paramContext, localMemoryInfo.totalMem + ']');
    }
    paramContext = oms;
    if (paramContext == null) {
      p.iCn();
    }
    f2 = (float)paramContext.totalMem;
    long l = (((Number)omr.getValue()).floatValue() * f2);
    f2 = (float)l / f1;
    f2 = Math.max(((Number)omp.getValue()).floatValue(), f2);
    f2 = Math.min(((Number)omq.getValue()).floatValue(), f2);
    float f3 = 67108864.0F / (f2 * f1);
    Log.i(TAG, "calculate gc_factor automatically unit = [" + f1 / 1024.0F + "]kb limit = [65536]kb system = [" + l / 1024L + "]kb raw = [" + f2 + ':' + (float)l / f1 + "] actually = [" + f3 + ']');
    paramContext = Float.valueOf(f3);
    omo = paramContext;
    if (paramContext == null) {
      p.iCn();
    }
    f1 = paramContext.floatValue();
    AppMethodBeat.o(50370);
    return f1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Float>
  {
    public static final a omu;
    
    static
    {
      AppMethodBeat.i(50361);
      omu = new a();
      AppMethodBeat.o(50361);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Float>
  {
    public static final b omv;
    
    static
    {
      AppMethodBeat.i(50363);
      omv = new b();
      AppMethodBeat.o(50363);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<Float>
  {
    public static final c omw;
    
    static
    {
      AppMethodBeat.i(50365);
      omw = new c();
      AppMethodBeat.o(50365);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.e
 * JD-Core Version:    0.7.0.1
 */