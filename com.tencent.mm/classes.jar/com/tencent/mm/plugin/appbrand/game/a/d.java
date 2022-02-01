package com.tencent.mm.plugin.appbrand.game.a;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.ac;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigGCFactor;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "clicfg_magicbrush_autogcfactor_max_canvas", "getClicfg_magicbrush_autogcfactor_max_canvas", "()F", "clicfg_magicbrush_autogcfactor_max_canvas$delegate", "Lkotlin/Lazy;", "clicfg_magicbrush_autogcfactor_min_canvas", "getClicfg_magicbrush_autogcfactor_min_canvas", "clicfg_magicbrush_autogcfactor_min_canvas$delegate", "clicfg_magicbrush_autogcfactor_total_memory_ratio", "getClicfg_magicbrush_autogcfactor_total_memory_ratio", "clicfg_magicbrush_autogcfactor_total_memory_ratio$delegate", "configMemory", "Ljava/lang/Float;", "memoryInfo", "Landroid/app/ActivityManager$MemoryInfo;", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableKv", "getActuallyGcFactor", "context", "Landroid/content/Context;", "getAvailableMemory", "", "getConfig", "()Ljava/lang/Float;", "getConfigDefaultValue", "getGcFactorAutomatic", "getMemoryUnit", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Float;", "plugin-appbrand-integration_release"})
public final class d
  extends t<Float>
{
  private static final String TAG;
  private static Float knM;
  private static final f knN;
  private static final f knO;
  private static final f knP;
  private static ActivityManager.MemoryInfo knQ;
  public static final d knR;
  
  static
  {
    AppMethodBeat.i(50366);
    knR = new d();
    StringBuilder localStringBuilder = new StringBuilder("MicroMsg.WAGameGcFactor");
    String str = ak.getProcessName();
    p.g(str, "MMApplicationContext.getProcessName()");
    TAG = n.h(str, "com.tencent.mm", "", false);
    knN = g.O((a)b.knT);
    knO = g.O((a)a.knS);
    knP = g.O((a)c.knU);
    AppMethodBeat.o(50366);
  }
  
  protected final String bhJ()
  {
    return "gcfactor";
  }
  
  protected final b.a bhK()
  {
    return b.a.qDb;
  }
  
  public final float jdMethod_do(Context paramContext)
  {
    AppMethodBeat.i(50370);
    p.h(paramContext, "context");
    if (knM != null)
    {
      paramContext = knM;
      if (paramContext == null) {
        p.gkB();
      }
      f1 = paramContext.floatValue();
      AppMethodBeat.o(50370);
      return f1;
    }
    float f1 = ((Number)super.att()).floatValue();
    if (f1 != -1.0F)
    {
      ae.i(TAG, "rawConfig == [" + f1 + "] != -1, just return");
      knM = Float.valueOf(f1);
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
    for (int i = 1; (ac.Nhs) && (i == 0); i = 0)
    {
      paramContext = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(50370);
      throw paramContext;
    }
    if (knQ == null)
    {
      paramContext = paramContext.getSystemService("activity");
      if (paramContext == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.app.ActivityManager");
        AppMethodBeat.o(50370);
        throw paramContext;
      }
      paramContext = (ActivityManager)paramContext;
      knQ = new ActivityManager.MemoryInfo();
      paramContext.getMemoryInfo(knQ);
      paramContext = TAG;
      localObject = new StringBuilder("getAvailableMemory avail = [");
      ActivityManager.MemoryInfo localMemoryInfo = knQ;
      if (localMemoryInfo == null) {
        p.gkB();
      }
      localObject = ((StringBuilder)localObject).append(localMemoryInfo.availMem).append("] total = [");
      localMemoryInfo = knQ;
      if (localMemoryInfo == null) {
        p.gkB();
      }
      ae.i(paramContext, localMemoryInfo.totalMem + ']');
    }
    paramContext = knQ;
    if (paramContext == null) {
      p.gkB();
    }
    f2 = (float)paramContext.totalMem;
    long l = (((Number)knP.getValue()).floatValue() * f2);
    f2 = (float)l / f1;
    f2 = Math.max(((Number)knN.getValue()).floatValue(), f2);
    f2 = Math.min(((Number)knO.getValue()).floatValue(), f2);
    float f3 = 67108864.0F / (f2 * f1);
    ae.i(TAG, "calculate gc_factor automatically unit = [" + f1 / 1024.0F + "]kb limit = [65536]kb system = [" + l / 1024L + "]kb raw = [" + f2 + ':' + (float)l / f1 + "] actually = [" + f3 + ']');
    paramContext = Float.valueOf(f3);
    knM = paramContext;
    if (paramContext == null) {
      p.gkB();
    }
    f1 = paramContext.floatValue();
    AppMethodBeat.o(50370);
    return f1;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Float>
  {
    public static final a knS;
    
    static
    {
      AppMethodBeat.i(50361);
      knS = new a();
      AppMethodBeat.o(50361);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Float>
  {
    public static final b knT;
    
    static
    {
      AppMethodBeat.i(50363);
      knT = new b();
      AppMethodBeat.o(50363);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<Float>
  {
    public static final c knU;
    
    static
    {
      AppMethodBeat.i(50365);
      knU = new c();
      AppMethodBeat.o(50365);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.d
 * JD-Core Version:    0.7.0.1
 */