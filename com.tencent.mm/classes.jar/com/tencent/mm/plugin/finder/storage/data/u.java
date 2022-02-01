package com.tencent.mm.plugin.finder.storage.data;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.bhu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/PageRecovery;", "", "()V", "SENSITIVE_CRASH_DURATION", "", "SENSITIVE_DURATION", "TAG", "", "lastEnterTimeMs", "", "getLastEnterTimeMs", "()J", "setLastEnterTimeMs", "(J)V", "touchFile", "getTouchFile", "()Ljava/lang/String;", "touchFile$delegate", "Lkotlin/Lazy;", "enterActivity", "", "setup", "plugin-finder_release"})
public final class u
{
  private static long AnC;
  private static final f AnD;
  public static final u AnE;
  
  static
  {
    AppMethodBeat.i(288195);
    AnE = new u();
    AnD = g.ar((a)b.AnG);
    AppMethodBeat.o(288195);
  }
  
  public static long dZB()
  {
    return AnC;
  }
  
  public static String dZC()
  {
    AppMethodBeat.i(288193);
    String str = (String)AnD.getValue();
    AppMethodBeat.o(288193);
    return str;
  }
  
  public static void dZD()
  {
    AppMethodBeat.i(288194);
    AnC = SystemClock.uptimeMillis();
    AppMethodBeat.o(288194);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ueh", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler;", "kotlin.jvm.PlatformType", "msg", "", "ex", "", "uncaughtException"})
  public static final class a
    implements MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
  {
    public a(bhu parambhu) {}
    
    public final void uncaughtException(MMUncaughtExceptionHandler paramMMUncaughtExceptionHandler, String paramString, Throwable paramThrowable)
    {
      paramThrowable = null;
      AppMethodBeat.i(267250);
      paramMMUncaughtExceptionHandler = this.AnF;
      if (paramMMUncaughtExceptionHandler == null)
      {
        paramMMUncaughtExceptionHandler = new bhu();
        paramMMUncaughtExceptionHandler.SSh = 0;
        paramMMUncaughtExceptionHandler.SSg = 0L;
      }
      for (;;)
      {
        paramString = new StringBuilder("get crash msg ").append(paramString).append(", isInFinder ").append(((PluginFinder)h.ag(PluginFinder.class)).isInFinder()).append(" lastEnterTimeMs:");
        Object localObject = u.AnE;
        paramString = paramString.append(u.dZB()).append(" pass: ");
        long l = SystemClock.uptimeMillis();
        localObject = u.AnE;
        localObject = paramString.append(l - u.dZB()).append(" info: ");
        paramString = this.AnF;
        if (paramString != null)
        {
          paramString = Integer.valueOf(paramString.SSh);
          localObject = ((StringBuilder)localObject).append(paramString).append(' ');
          paramString = this.AnF;
          if (paramString == null) {
            break label402;
          }
          paramString = Long.valueOf(paramString.SSg);
          label164:
          Log.i("Finder.PageRecovery", paramString);
          if (((PluginFinder)h.ag(PluginFinder.class)).isInFinder())
          {
            l = SystemClock.uptimeMillis();
            paramString = u.AnE;
            if (l - u.dZB() <= 5000L)
            {
              if (System.currentTimeMillis() - paramMMUncaughtExceptionHandler.SSg >= 300000L) {
                break label407;
              }
              paramMMUncaughtExceptionHandler.SSh += 1;
              label239:
              paramMMUncaughtExceptionHandler.SSg = System.currentTimeMillis();
              paramString = u.AnE;
              com.tencent.mm.vfs.u.bBD(new com.tencent.mm.vfs.q(u.dZE()).ifA());
              paramString = u.AnE;
              com.tencent.mm.vfs.u.H(u.dZE(), paramMMUncaughtExceptionHandler.toByteArray());
              paramString = new StringBuilder("[setup] crash happen =");
              localObject = u.AnE;
              paramString = paramString.append(com.tencent.mm.vfs.u.agG(u.dZE())).append(" touchFile=");
              localObject = u.AnE;
              localObject = paramString.append(u.dZE()).append(" info: ");
              if (paramMMUncaughtExceptionHandler == null) {
                break label415;
              }
            }
          }
        }
        label402:
        label407:
        label415:
        for (paramString = Integer.valueOf(paramMMUncaughtExceptionHandler.SSh);; paramString = null)
        {
          localObject = ((StringBuilder)localObject).append(paramString.intValue()).append(' ');
          paramString = paramThrowable;
          if (paramMMUncaughtExceptionHandler != null) {
            paramString = Long.valueOf(paramMMUncaughtExceptionHandler.SSg);
          }
          Log.i("Finder.PageRecovery", paramString.longValue());
          AppMethodBeat.o(267250);
          return;
          paramString = null;
          break;
          paramString = null;
          break label164;
          paramMMUncaughtExceptionHandler.SSh = 1;
          break label239;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements a<String>
  {
    public static final b AnG;
    
    static
    {
      AppMethodBeat.i(287153);
      AnG = new b();
      AppMethodBeat.o(287153);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.u
 * JD-Core Version:    0.7.0.1
 */