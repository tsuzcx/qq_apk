package com.tencent.mm.plugin.finder.storage.data;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.c;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import d.f;
import d.g.a.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/PageRecovery;", "", "()V", "SENSITIVE_CRASH_DURATION", "", "SENSITIVE_DURATION", "TAG", "", "lastEnterTimeMs", "", "getLastEnterTimeMs", "()J", "setLastEnterTimeMs", "(J)V", "touchFile", "getTouchFile", "()Ljava/lang/String;", "touchFile$delegate", "Lkotlin/Lazy;", "enterActivity", "", "setup", "plugin-finder_release"})
public final class q
{
  private static long sLj;
  private static final f sLk;
  public static final q sLl;
  
  static
  {
    AppMethodBeat.i(204443);
    sLl = new q();
    sLk = d.g.O((a)b.sLn);
    AppMethodBeat.o(204443);
  }
  
  public static long cLO()
  {
    return sLj;
  }
  
  public static String cLP()
  {
    AppMethodBeat.i(204441);
    String str = (String)sLk.getValue();
    AppMethodBeat.o(204441);
    return str;
  }
  
  public static void cLQ()
  {
    AppMethodBeat.i(204442);
    sLj = SystemClock.uptimeMillis();
    AppMethodBeat.o(204442);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "ueh", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler;", "kotlin.jvm.PlatformType", "msg", "", "ex", "", "uncaughtException"})
  public static final class a
    implements av.c
  {
    public a(arh paramarh) {}
    
    public final void a(av paramav, String paramString, Throwable paramThrowable)
    {
      paramThrowable = null;
      AppMethodBeat.i(204438);
      paramav = this.sLm;
      if (paramav == null)
      {
        paramav = new arh();
        paramav.crashCount = 0;
        paramav.GIb = 0L;
      }
      for (;;)
      {
        paramString = new StringBuilder("get crash msg ").append(paramString).append(", isInFinder ").append(((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder()).append(" lastEnterTimeMs:");
        Object localObject = q.sLl;
        paramString = paramString.append(q.cLO()).append(" pass: ");
        long l = SystemClock.uptimeMillis();
        localObject = q.sLl;
        localObject = paramString.append(l - q.cLO()).append(" info: ");
        paramString = this.sLm;
        if (paramString != null)
        {
          paramString = Integer.valueOf(paramString.crashCount);
          localObject = ((StringBuilder)localObject).append(paramString).append(' ');
          paramString = this.sLm;
          if (paramString == null) {
            break label402;
          }
          paramString = Long.valueOf(paramString.GIb);
          label164:
          ae.i("Finder.PageRecovery", paramString);
          if (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder())
          {
            l = SystemClock.uptimeMillis();
            paramString = q.sLl;
            if (l - q.cLO() <= 5000L)
            {
              if (System.currentTimeMillis() - paramav.GIb >= 300000L) {
                break label407;
              }
              paramav.crashCount += 1;
              label239:
              paramav.GIb = System.currentTimeMillis();
              paramString = q.sLl;
              o.aZI(new k(q.cLR()).getParent());
              paramString = q.sLl;
              o.C(q.cLR(), paramav.toByteArray());
              paramString = new StringBuilder("[setup] crash happen =");
              localObject = q.sLl;
              paramString = paramString.append(o.fB(q.cLR())).append(" touchFile=");
              localObject = q.sLl;
              localObject = paramString.append(q.cLR()).append(" info: ");
              if (paramav == null) {
                break label415;
              }
            }
          }
        }
        label402:
        label407:
        label415:
        for (paramString = Integer.valueOf(paramav.crashCount);; paramString = null)
        {
          localObject = ((StringBuilder)localObject).append(paramString.intValue()).append(' ');
          paramString = paramThrowable;
          if (paramav != null) {
            paramString = Long.valueOf(paramav.GIb);
          }
          ae.i("Finder.PageRecovery", paramString.longValue());
          AppMethodBeat.o(204438);
          return;
          paramString = null;
          break;
          paramString = null;
          break label164;
          paramav.crashCount = 1;
          break label239;
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements a<String>
  {
    public static final b sLn;
    
    static
    {
      AppMethodBeat.i(204440);
      sLn = new b();
      AppMethodBeat.o(204440);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.q
 * JD-Core Version:    0.7.0.1
 */