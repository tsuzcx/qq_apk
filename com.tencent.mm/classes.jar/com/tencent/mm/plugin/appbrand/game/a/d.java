package com.tencent.mm.plugin.appbrand.game.a;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.aa;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import d.v;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigGCFactor;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "clicfg_magicbrush_autogcfactor_max_canvas", "getClicfg_magicbrush_autogcfactor_max_canvas", "()F", "clicfg_magicbrush_autogcfactor_max_canvas$delegate", "Lkotlin/Lazy;", "clicfg_magicbrush_autogcfactor_min_canvas", "getClicfg_magicbrush_autogcfactor_min_canvas", "clicfg_magicbrush_autogcfactor_min_canvas$delegate", "clicfg_magicbrush_autogcfactor_total_memory_ratio", "getClicfg_magicbrush_autogcfactor_total_memory_ratio", "clicfg_magicbrush_autogcfactor_total_memory_ratio$delegate", "configMemory", "Ljava/lang/Float;", "memoryInfo", "Landroid/app/ActivityManager$MemoryInfo;", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableKv", "getActuallyGcFactor", "context", "Landroid/content/Context;", "getAvailableMemory", "", "getConfig", "()Ljava/lang/Float;", "getConfigDefaultValue", "getGcFactorAutomatic", "getMemoryUnit", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Float;", "plugin-appbrand-integration_release"})
public final class d
  extends n<Float>
{
  private static final String TAG;
  private static Float jpV;
  private static final f jpW;
  private static final f jpX;
  private static final f jpY;
  private static ActivityManager.MemoryInfo jpZ;
  public static final d jqa;
  
  static
  {
    AppMethodBeat.i(50366);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(d.class), "clicfg_magicbrush_autogcfactor_min_canvas", "getClicfg_magicbrush_autogcfactor_min_canvas()F")), (d.l.k)w.a(new u(w.bk(d.class), "clicfg_magicbrush_autogcfactor_max_canvas", "getClicfg_magicbrush_autogcfactor_max_canvas()F")), (d.l.k)w.a(new u(w.bk(d.class), "clicfg_magicbrush_autogcfactor_total_memory_ratio", "getClicfg_magicbrush_autogcfactor_total_memory_ratio()F")) };
    jqa = new d();
    StringBuilder localStringBuilder = new StringBuilder("MicroMsg.WAGameGcFactor");
    String str = aj.getProcessName();
    d.g.b.k.g(str, "MMApplicationContext.getProcessName()");
    TAG = d.n.n.h(str, "com.tencent.mm", "", false);
    jpW = g.E((a)b.jqc);
    jpX = g.E((a)a.jqb);
    jpY = g.E((a)c.jqd);
    AppMethodBeat.o(50366);
  }
  
  protected final b.a aWA()
  {
    return b.a.pof;
  }
  
  protected final String aWz()
  {
    return "gcfactor";
  }
  
  public final float df(Context paramContext)
  {
    AppMethodBeat.i(50370);
    d.g.b.k.h(paramContext, "context");
    if (jpV != null)
    {
      paramContext = jpV;
      if (paramContext == null) {
        d.g.b.k.fvU();
      }
      f1 = paramContext.floatValue();
      AppMethodBeat.o(50370);
      return f1;
    }
    float f1 = ((Number)super.ajp()).floatValue();
    if (f1 != -1.0F)
    {
      ad.i(TAG, "rawConfig == [" + f1 + "] != -1, just return");
      jpV = Float.valueOf(f1);
      AppMethodBeat.o(50370);
      return f1;
    }
    Object localObject = paramContext.getResources();
    d.g.b.k.g(localObject, "context.resources");
    f1 = ((Resources)localObject).getDisplayMetrics().density;
    localObject = paramContext.getResources();
    d.g.b.k.g(localObject, "context.resources");
    float f2 = ((Resources)localObject).getDisplayMetrics().widthPixels / f1;
    localObject = paramContext.getResources();
    d.g.b.k.g(localObject, "context.resources");
    f1 = 2.0F * (((Resources)localObject).getDisplayMetrics().heightPixels / f1 * f2 * 4.0F);
    if (f1 > 0.0F) {}
    for (int i = 1; (aa.JfW) && (i == 0); i = 0)
    {
      paramContext = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(50370);
      throw paramContext;
    }
    if (jpZ == null)
    {
      paramContext = paramContext.getSystemService("activity");
      if (paramContext == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.app.ActivityManager");
        AppMethodBeat.o(50370);
        throw paramContext;
      }
      paramContext = (ActivityManager)paramContext;
      jpZ = new ActivityManager.MemoryInfo();
      paramContext.getMemoryInfo(jpZ);
      paramContext = TAG;
      localObject = new StringBuilder("getAvailableMemory avail = [");
      ActivityManager.MemoryInfo localMemoryInfo = jpZ;
      if (localMemoryInfo == null) {
        d.g.b.k.fvU();
      }
      localObject = ((StringBuilder)localObject).append(localMemoryInfo.availMem).append("] total = [");
      localMemoryInfo = jpZ;
      if (localMemoryInfo == null) {
        d.g.b.k.fvU();
      }
      ad.i(paramContext, localMemoryInfo.totalMem + ']');
    }
    paramContext = jpZ;
    if (paramContext == null) {
      d.g.b.k.fvU();
    }
    f2 = (float)paramContext.totalMem;
    long l = (((Number)jpY.getValue()).floatValue() * f2);
    f2 = (float)l / f1;
    f2 = Math.max(((Number)jpW.getValue()).floatValue(), f2);
    f2 = Math.min(((Number)jpX.getValue()).floatValue(), f2);
    float f3 = 67108864.0F / (f2 * f1);
    ad.i(TAG, "calculate gc_factor automatically unit = [" + f1 / 1024.0F + "]kb limit = [65536]kb system = [" + l / 1024L + "]kb raw = [" + f2 + ':' + (float)l / f1 + "] actually = [" + f3 + ']');
    paramContext = Float.valueOf(f3);
    jpV = paramContext;
    if (paramContext == null) {
      d.g.b.k.fvU();
    }
    f1 = paramContext.floatValue();
    AppMethodBeat.o(50370);
    return f1;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<Float>
  {
    public static final a jqb;
    
    static
    {
      AppMethodBeat.i(50361);
      jqb = new a();
      AppMethodBeat.o(50361);
    }
    
    a()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<Float>
  {
    public static final b jqc;
    
    static
    {
      AppMethodBeat.i(50363);
      jqc = new b();
      AppMethodBeat.o(50363);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<Float>
  {
    public static final c jqd;
    
    static
    {
      AppMethodBeat.i(50365);
      jqd = new c();
      AppMethodBeat.o(50365);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.d
 * JD-Core Version:    0.7.0.1
 */