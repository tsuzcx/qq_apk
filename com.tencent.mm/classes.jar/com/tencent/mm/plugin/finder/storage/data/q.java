package com.tencent.mm.plugin.finder.storage.data;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.aqs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.f;
import d.g.a.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/data/PageRecovery;", "", "()V", "SENSITIVE_CRASH_DURATION", "", "SENSITIVE_DURATION", "TAG", "", "lastEnterTimeMs", "", "getLastEnterTimeMs", "()J", "setLastEnterTimeMs", "(J)V", "touchFile", "getTouchFile", "()Ljava/lang/String;", "touchFile$delegate", "Lkotlin/Lazy;", "enterActivity", "", "setup", "plugin-finder_release"})
public final class q
{
  private static long sAl;
  private static final f sAm;
  public static final q sAn;
  
  static
  {
    AppMethodBeat.i(203852);
    sAn = new q();
    sAm = d.g.O((a)b.sAp);
    AppMethodBeat.o(203852);
  }
  
  public static long cJl()
  {
    return sAl;
  }
  
  public static String cJm()
  {
    AppMethodBeat.i(203850);
    String str = (String)sAm.getValue();
    AppMethodBeat.o(203850);
    return str;
  }
  
  public static void cJn()
  {
    AppMethodBeat.i(203851);
    sAl = SystemClock.uptimeMillis();
    AppMethodBeat.o(203851);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "ueh", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler;", "kotlin.jvm.PlatformType", "msg", "", "ex", "", "uncaughtException"})
  public static final class a
    implements au.c
  {
    public a(aqs paramaqs) {}
    
    public final void a(au paramau, String paramString, Throwable paramThrowable)
    {
      paramThrowable = null;
      AppMethodBeat.i(203847);
      paramau = this.sAo;
      if (paramau == null)
      {
        paramau = new aqs();
        paramau.crashCount = 0;
        paramau.GoL = 0L;
      }
      for (;;)
      {
        paramString = new StringBuilder("get crash msg ").append(paramString).append(", isInFinder ").append(((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder()).append(" lastEnterTimeMs:");
        Object localObject = q.sAn;
        paramString = paramString.append(q.cJl()).append(" pass: ");
        long l = SystemClock.uptimeMillis();
        localObject = q.sAn;
        localObject = paramString.append(l - q.cJl()).append(" info: ");
        paramString = this.sAo;
        if (paramString != null)
        {
          paramString = Integer.valueOf(paramString.crashCount);
          localObject = ((StringBuilder)localObject).append(paramString).append(' ');
          paramString = this.sAo;
          if (paramString == null) {
            break label402;
          }
          paramString = Long.valueOf(paramString.GoL);
          label164:
          ad.i("Finder.PageRecovery", paramString);
          if (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder())
          {
            l = SystemClock.uptimeMillis();
            paramString = q.sAn;
            if (l - q.cJl() <= 5000L)
            {
              if (System.currentTimeMillis() - paramau.GoL >= 300000L) {
                break label407;
              }
              paramau.crashCount += 1;
              label239:
              paramau.GoL = System.currentTimeMillis();
              paramString = q.sAn;
              i.aYg(new e(q.cJo()).getParent());
              paramString = q.sAn;
              i.C(q.cJo(), paramau.toByteArray());
              paramString = new StringBuilder("[setup] crash happen =");
              localObject = q.sAn;
              paramString = paramString.append(i.fv(q.cJo())).append(" touchFile=");
              localObject = q.sAn;
              localObject = paramString.append(q.cJo()).append(" info: ");
              if (paramau == null) {
                break label415;
              }
            }
          }
        }
        label402:
        label407:
        label415:
        for (paramString = Integer.valueOf(paramau.crashCount);; paramString = null)
        {
          localObject = ((StringBuilder)localObject).append(paramString.intValue()).append(' ');
          paramString = paramThrowable;
          if (paramau != null) {
            paramString = Long.valueOf(paramau.GoL);
          }
          ad.i("Finder.PageRecovery", paramString.longValue());
          AppMethodBeat.o(203847);
          return;
          paramString = null;
          break;
          paramString = null;
          break label164;
          paramau.crashCount = 1;
          break label239;
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements a<String>
  {
    public static final b sAp;
    
    static
    {
      AppMethodBeat.i(203849);
      sAp = new b();
      AppMethodBeat.o(203849);
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