package com.tencent.mm.plugin.appbrand.game.a;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ak;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigGCFactor;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "clicfg_magicbrush_autogcfactor_max_canvas", "getClicfg_magicbrush_autogcfactor_max_canvas", "()F", "clicfg_magicbrush_autogcfactor_max_canvas$delegate", "Lkotlin/Lazy;", "clicfg_magicbrush_autogcfactor_min_canvas", "getClicfg_magicbrush_autogcfactor_min_canvas", "clicfg_magicbrush_autogcfactor_min_canvas$delegate", "clicfg_magicbrush_autogcfactor_total_memory_ratio", "getClicfg_magicbrush_autogcfactor_total_memory_ratio", "clicfg_magicbrush_autogcfactor_total_memory_ratio$delegate", "configMemory", "Ljava/lang/Float;", "memoryInfo", "Landroid/app/ActivityManager$MemoryInfo;", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableKv", "getActuallyGcFactor", "context", "Landroid/content/Context;", "getAvailableMemory", "", "getConfig", "()Ljava/lang/Float;", "getConfigDefaultValue", "getGcFactorAutomatic", "getMemoryUnit", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Float;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends z<Float>
{
  private static final String TAG;
  public static final f rpY;
  private static Float rpZ;
  private static final j rqa;
  private static final j rqb;
  private static final j rqc;
  private static ActivityManager.MemoryInfo rqd;
  
  static
  {
    AppMethodBeat.i(50366);
    rpY = new f();
    String str1 = MMApplicationContext.getProcessName();
    s.s(str1, "getProcessName()");
    String str2 = MMApplicationContext.getPackageName();
    s.s(str2, "getPackageName()");
    TAG = s.X("MicroMsg.WAGameGcFactor", n.m(str1, str2, "", false));
    rqa = k.cm((a)b.rqf);
    rqb = k.cm((a)a.rqe);
    rqc = k.cm((a)c.rqg);
    AppMethodBeat.o(50366);
  }
  
  protected final String coJ()
  {
    return "gcfactor";
  }
  
  protected final c.a coK()
  {
    return c.a.yQO;
  }
  
  public final float eB(Context paramContext)
  {
    AppMethodBeat.i(50370);
    s.u(paramContext, "context");
    if (rpZ != null)
    {
      paramContext = rpZ;
      s.checkNotNull(paramContext);
      f1 = paramContext.floatValue();
      AppMethodBeat.o(50370);
      return f1;
    }
    float f1 = ((Number)super.boF()).floatValue();
    if (f1 == -1.0F) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i(TAG, "rawConfig == [" + f1 + "] != -1, just return");
      rpZ = Float.valueOf(f1);
      AppMethodBeat.o(50370);
      return f1;
    }
    f1 = paramContext.getResources().getDisplayMetrics().density;
    float f2 = paramContext.getResources().getDisplayMetrics().widthPixels / f1;
    f1 = 2.0F * (paramContext.getResources().getDisplayMetrics().heightPixels / f1 * f2 * 4.0F);
    if (f1 > 0.0F) {}
    for (i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramContext = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(50370);
      throw paramContext;
    }
    if (rqd == null)
    {
      paramContext = paramContext.getSystemService("activity");
      if (paramContext == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
        AppMethodBeat.o(50370);
        throw paramContext;
      }
      paramContext = (ActivityManager)paramContext;
      rqd = new ActivityManager.MemoryInfo();
      paramContext.getMemoryInfo(rqd);
      paramContext = TAG;
      StringBuilder localStringBuilder = new StringBuilder("getAvailableMemory avail = [");
      ActivityManager.MemoryInfo localMemoryInfo = rqd;
      s.checkNotNull(localMemoryInfo);
      localStringBuilder = localStringBuilder.append(localMemoryInfo.availMem).append("] total = [");
      localMemoryInfo = rqd;
      s.checkNotNull(localMemoryInfo);
      Log.i(paramContext, localMemoryInfo.totalMem + ']');
    }
    paramContext = rqd;
    s.checkNotNull(paramContext);
    f2 = (float)paramContext.totalMem;
    long l = (((Number)rqc.getValue()).floatValue() * f2);
    f2 = (float)l / f1;
    f2 = Math.max(((Number)rqa.getValue()).floatValue(), f2);
    f2 = Math.min(((Number)rqb.getValue()).floatValue(), f2);
    float f3 = 67108864.0F / (f2 * f1);
    Log.i(TAG, "calculate gc_factor automatically unit = [" + f1 / 1024.0F + "]kb limit = [65536]kb system = [" + l / 1024L + "]kb raw = [" + f2 + ':' + (float)l / f1 + "] actually = [" + f3 + ']');
    paramContext = Float.valueOf(f3);
    rpZ = paramContext;
    s.checkNotNull(paramContext);
    f1 = paramContext.floatValue();
    AppMethodBeat.o(50370);
    return f1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Float>
  {
    public static final a rqe;
    
    static
    {
      AppMethodBeat.i(50361);
      rqe = new a();
      AppMethodBeat.o(50361);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Float>
  {
    public static final b rqf;
    
    static
    {
      AppMethodBeat.i(50363);
      rqf = new b();
      AppMethodBeat.o(50363);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<Float>
  {
    public static final c rqg;
    
    static
    {
      AppMethodBeat.i(50365);
      rqg = new c();
      AppMethodBeat.o(50365);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.f
 * JD-Core Version:    0.7.0.1
 */