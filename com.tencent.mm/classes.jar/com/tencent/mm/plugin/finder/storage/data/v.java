package com.tencent.mm.plugin.finder.storage.data;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/PageRecovery;", "", "()V", "SENSITIVE_CRASH_DURATION", "", "SENSITIVE_DURATION", "TAG", "", "lastEnterTimeMs", "", "getLastEnterTimeMs", "()J", "setLastEnterTimeMs", "(J)V", "touchFile", "getTouchFile", "()Ljava/lang/String;", "touchFile$delegate", "Lkotlin/Lazy;", "enterActivity", "", "setup", "plugin-finder_release"})
public final class v
{
  private static long vGE;
  private static final f vGF;
  public static final v vGG;
  
  static
  {
    AppMethodBeat.i(252052);
    vGG = new v();
    vGF = kotlin.g.ah((a)b.vGI);
    AppMethodBeat.o(252052);
  }
  
  public static long dyI()
  {
    return vGE;
  }
  
  public static String dyJ()
  {
    AppMethodBeat.i(252050);
    String str = (String)vGF.getValue();
    AppMethodBeat.o(252050);
    return str;
  }
  
  public static void dyK()
  {
    AppMethodBeat.i(252051);
    vGE = SystemClock.uptimeMillis();
    AppMethodBeat.o(252051);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ueh", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler;", "kotlin.jvm.PlatformType", "msg", "", "ex", "", "uncaughtException"})
  public static final class a
    implements MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
  {
    public a(bbg parambbg) {}
    
    public final void uncaughtException(MMUncaughtExceptionHandler paramMMUncaughtExceptionHandler, String paramString, Throwable paramThrowable)
    {
      paramThrowable = null;
      AppMethodBeat.i(252047);
      paramMMUncaughtExceptionHandler = this.vGH;
      if (paramMMUncaughtExceptionHandler == null)
      {
        paramMMUncaughtExceptionHandler = new bbg();
        paramMMUncaughtExceptionHandler.crashCount = 0;
        paramMMUncaughtExceptionHandler.LKH = 0L;
      }
      for (;;)
      {
        paramString = new StringBuilder("get crash msg ").append(paramString).append(", isInFinder ").append(((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).isInFinder()).append(" lastEnterTimeMs:");
        Object localObject = v.vGG;
        paramString = paramString.append(v.dyI()).append(" pass: ");
        long l = SystemClock.uptimeMillis();
        localObject = v.vGG;
        localObject = paramString.append(l - v.dyI()).append(" info: ");
        paramString = this.vGH;
        if (paramString != null)
        {
          paramString = Integer.valueOf(paramString.crashCount);
          localObject = ((StringBuilder)localObject).append(paramString).append(' ');
          paramString = this.vGH;
          if (paramString == null) {
            break label402;
          }
          paramString = Long.valueOf(paramString.LKH);
          label164:
          Log.i("Finder.PageRecovery", paramString);
          if (((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).isInFinder())
          {
            l = SystemClock.uptimeMillis();
            paramString = v.vGG;
            if (l - v.dyI() <= 5000L)
            {
              if (System.currentTimeMillis() - paramMMUncaughtExceptionHandler.LKH >= 300000L) {
                break label407;
              }
              paramMMUncaughtExceptionHandler.crashCount += 1;
              label239:
              paramMMUncaughtExceptionHandler.LKH = System.currentTimeMillis();
              paramString = v.vGG;
              s.boN(new o(v.dyL()).getParent());
              paramString = v.vGG;
              s.C(v.dyL(), paramMMUncaughtExceptionHandler.toByteArray());
              paramString = new StringBuilder("[setup] crash happen =");
              localObject = v.vGG;
              paramString = paramString.append(s.YS(v.dyL())).append(" touchFile=");
              localObject = v.vGG;
              localObject = paramString.append(v.dyL()).append(" info: ");
              if (paramMMUncaughtExceptionHandler == null) {
                break label415;
              }
            }
          }
        }
        label402:
        label407:
        label415:
        for (paramString = Integer.valueOf(paramMMUncaughtExceptionHandler.crashCount);; paramString = null)
        {
          localObject = ((StringBuilder)localObject).append(paramString.intValue()).append(' ');
          paramString = paramThrowable;
          if (paramMMUncaughtExceptionHandler != null) {
            paramString = Long.valueOf(paramMMUncaughtExceptionHandler.LKH);
          }
          Log.i("Finder.PageRecovery", paramString.longValue());
          AppMethodBeat.o(252047);
          return;
          paramString = null;
          break;
          paramString = null;
          break label164;
          paramMMUncaughtExceptionHandler.crashCount = 1;
          break label239;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<String>
  {
    public static final b vGI;
    
    static
    {
      AppMethodBeat.i(252049);
      vGI = new b();
      AppMethodBeat.o(252049);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.v
 * JD-Core Version:    0.7.0.1
 */