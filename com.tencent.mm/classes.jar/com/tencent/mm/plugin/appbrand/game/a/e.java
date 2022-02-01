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
import kotlin.aa;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigGCFactor;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "clicfg_magicbrush_autogcfactor_max_canvas", "getClicfg_magicbrush_autogcfactor_max_canvas", "()F", "clicfg_magicbrush_autogcfactor_max_canvas$delegate", "Lkotlin/Lazy;", "clicfg_magicbrush_autogcfactor_min_canvas", "getClicfg_magicbrush_autogcfactor_min_canvas", "clicfg_magicbrush_autogcfactor_min_canvas$delegate", "clicfg_magicbrush_autogcfactor_total_memory_ratio", "getClicfg_magicbrush_autogcfactor_total_memory_ratio", "clicfg_magicbrush_autogcfactor_total_memory_ratio$delegate", "configMemory", "Ljava/lang/Float;", "memoryInfo", "Landroid/app/ActivityManager$MemoryInfo;", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableKv", "getActuallyGcFactor", "context", "Landroid/content/Context;", "getAvailableMemory", "", "getConfig", "()Ljava/lang/Float;", "getConfigDefaultValue", "getGcFactorAutomatic", "getMemoryUnit", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Float;", "plugin-appbrand-integration_release"})
public final class e
  extends v<Float>
{
  private static final String TAG;
  private static Float lrt;
  private static final f lru;
  private static final f lrv;
  private static final f lrw;
  private static ActivityManager.MemoryInfo lrx;
  public static final e lry;
  
  static
  {
    AppMethodBeat.i(50366);
    lry = new e();
    StringBuilder localStringBuilder = new StringBuilder("MicroMsg.WAGameGcFactor");
    String str1 = MMApplicationContext.getProcessName();
    p.g(str1, "MMApplicationContext.getProcessName()");
    String str2 = MMApplicationContext.getPackageName();
    p.g(str2, "MMApplicationContext.getPackageName()");
    TAG = n.j(str1, str2, "", false);
    lru = g.ah((a)b.lrA);
    lrv = g.ah((a)a.lrz);
    lrw = g.ah((a)c.lrB);
    AppMethodBeat.o(50366);
  }
  
  protected final String bCY()
  {
    return "gcfactor";
  }
  
  protected final b.a bCZ()
  {
    return b.a.rVU;
  }
  
  public final float dJ(Context paramContext)
  {
    AppMethodBeat.i(50370);
    p.h(paramContext, "context");
    if (lrt != null)
    {
      paramContext = lrt;
      if (paramContext == null) {
        p.hyc();
      }
      f1 = paramContext.floatValue();
      AppMethodBeat.o(50370);
      return f1;
    }
    float f1 = ((Number)super.aLT()).floatValue();
    if (f1 != -1.0F)
    {
      Log.i(TAG, "rawConfig == [" + f1 + "] != -1, just return");
      lrt = Float.valueOf(f1);
      AppMethodBeat.o(50370);
      return f1;
    }
    Object localObject = paramContext.getResources();
    p.g(localObject, "context.resources");
    f1 = ((Resources)localObject).getDisplayMetrics().density;
    localObject = paramContext.getResources();
    p.g(localObject, "context.resources");
    float f2 = ((Resources)localObject).getDisplayMetrics().widthPixels / f1;
    localObject = paramContext.getResources();
    p.g(localObject, "context.resources");
    f1 = 2.0F * (((Resources)localObject).getDisplayMetrics().heightPixels / f1 * f2 * 4.0F);
    if (f1 > 0.0F) {}
    for (int i = 1; (aa.SXc) && (i == 0); i = 0)
    {
      paramContext = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(50370);
      throw paramContext;
    }
    if (lrx == null)
    {
      paramContext = paramContext.getSystemService("activity");
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.app.ActivityManager");
        AppMethodBeat.o(50370);
        throw paramContext;
      }
      paramContext = (ActivityManager)paramContext;
      lrx = new ActivityManager.MemoryInfo();
      paramContext.getMemoryInfo(lrx);
      paramContext = TAG;
      localObject = new StringBuilder("getAvailableMemory avail = [");
      ActivityManager.MemoryInfo localMemoryInfo = lrx;
      if (localMemoryInfo == null) {
        p.hyc();
      }
      localObject = ((StringBuilder)localObject).append(localMemoryInfo.availMem).append("] total = [");
      localMemoryInfo = lrx;
      if (localMemoryInfo == null) {
        p.hyc();
      }
      Log.i(paramContext, localMemoryInfo.totalMem + ']');
    }
    paramContext = lrx;
    if (paramContext == null) {
      p.hyc();
    }
    f2 = (float)paramContext.totalMem;
    long l = (((Number)lrw.getValue()).floatValue() * f2);
    f2 = (float)l / f1;
    f2 = Math.max(((Number)lru.getValue()).floatValue(), f2);
    f2 = Math.min(((Number)lrv.getValue()).floatValue(), f2);
    float f3 = 67108864.0F / (f2 * f1);
    Log.i(TAG, "calculate gc_factor automatically unit = [" + f1 / 1024.0F + "]kb limit = [65536]kb system = [" + l / 1024L + "]kb raw = [" + f2 + ':' + (float)l / f1 + "] actually = [" + f3 + ']');
    paramContext = Float.valueOf(f3);
    lrt = paramContext;
    if (paramContext == null) {
      p.hyc();
    }
    f1 = paramContext.floatValue();
    AppMethodBeat.o(50370);
    return f1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Float>
  {
    public static final a lrz;
    
    static
    {
      AppMethodBeat.i(50361);
      lrz = new a();
      AppMethodBeat.o(50361);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Float>
  {
    public static final b lrA;
    
    static
    {
      AppMethodBeat.i(50363);
      lrA = new b();
      AppMethodBeat.o(50363);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<Float>
  {
    public static final c lrB;
    
    static
    {
      AppMethodBeat.i(50365);
      lrB = new c();
      AppMethodBeat.o(50365);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.e
 * JD-Core Version:    0.7.0.1
 */