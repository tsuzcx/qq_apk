package com.tencent.mm.plugin.finder.storage.data;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.ang;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.at.c;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.f;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/data/PageRecovery;", "", "()V", "SENSITIVE_CRASH_DURATION", "", "SENSITIVE_DURATION", "TAG", "", "lastEnterTimeMs", "", "getLastEnterTimeMs", "()J", "setLastEnterTimeMs", "(J)V", "touchFile", "getTouchFile", "()Ljava/lang/String;", "touchFile$delegate", "Lkotlin/Lazy;", "enterActivity", "", "setup", "plugin-finder_release"})
public final class k
{
  private static long rFe;
  private static final f rFf;
  public static final k rFg;
  
  static
  {
    AppMethodBeat.i(203050);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(k.class), "touchFile", "getTouchFile()Ljava/lang/String;")) };
    rFg = new k();
    rFf = d.g.K((a)k.b.rFi);
    AppMethodBeat.o(203050);
  }
  
  public static long cBk()
  {
    return rFe;
  }
  
  public static String cBl()
  {
    AppMethodBeat.i(203051);
    String str = (String)rFf.getValue();
    AppMethodBeat.o(203051);
    return str;
  }
  
  public static void cBm()
  {
    AppMethodBeat.i(203052);
    rFe = SystemClock.uptimeMillis();
    AppMethodBeat.o(203052);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "ueh", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler;", "kotlin.jvm.PlatformType", "msg", "", "ex", "", "uncaughtException"})
  public static final class a
    implements at.c
  {
    public a(ang paramang) {}
    
    public final void a(at paramat, String paramString, Throwable paramThrowable)
    {
      paramThrowable = null;
      AppMethodBeat.i(203047);
      paramat = this.rFh;
      if (paramat == null)
      {
        paramat = new ang();
        paramat.crashCount = 0;
        paramat.EGo = 0L;
      }
      for (;;)
      {
        paramString = new StringBuilder("get crash msg ").append(paramString).append(", isInFinder ").append(((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder()).append(" lastEnterTimeMs:");
        Object localObject = k.rFg;
        paramString = paramString.append(k.cBk()).append(" pass: ");
        long l = SystemClock.uptimeMillis();
        localObject = k.rFg;
        localObject = paramString.append(l - k.cBk()).append(" info: ");
        paramString = this.rFh;
        if (paramString != null)
        {
          paramString = Integer.valueOf(paramString.crashCount);
          localObject = ((StringBuilder)localObject).append(paramString).append(' ');
          paramString = this.rFh;
          if (paramString == null) {
            break label402;
          }
          paramString = Long.valueOf(paramString.EGo);
          label164:
          ac.i("Finder.PageRecovery", paramString);
          if (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder())
          {
            l = SystemClock.uptimeMillis();
            paramString = k.rFg;
            if (l - k.cBk() <= 5000L)
            {
              if (System.currentTimeMillis() - paramat.EGo >= 300000L) {
                break label407;
              }
              paramat.crashCount += 1;
              label239:
              paramat.EGo = System.currentTimeMillis();
              paramString = k.rFg;
              i.aSh(new e(k.cBn()).getParent());
              paramString = k.rFg;
              i.B(k.cBn(), paramat.toByteArray());
              paramString = new StringBuilder("[setup] crash happen =");
              localObject = k.rFg;
              paramString = paramString.append(i.eA(k.cBn())).append(" touchFile=");
              localObject = k.rFg;
              localObject = paramString.append(k.cBn()).append(" info: ");
              if (paramat == null) {
                break label415;
              }
            }
          }
        }
        label402:
        label407:
        label415:
        for (paramString = Integer.valueOf(paramat.crashCount);; paramString = null)
        {
          localObject = ((StringBuilder)localObject).append(paramString.intValue()).append(' ');
          paramString = paramThrowable;
          if (paramat != null) {
            paramString = Long.valueOf(paramat.EGo);
          }
          ac.i("Finder.PageRecovery", paramString.longValue());
          AppMethodBeat.o(203047);
          return;
          paramString = null;
          break;
          paramString = null;
          break label164;
          paramat.crashCount = 1;
          break label239;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.k
 * JD-Core Version:    0.7.0.1
 */