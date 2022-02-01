package com.tencent.mm.plugin.finder.storage.data;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.f;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/PageRecovery;", "", "()V", "SENSITIVE_CRASH_DURATION", "", "SENSITIVE_DURATION", "TAG", "", "lastEnterTimeMs", "", "getLastEnterTimeMs", "()J", "setLastEnterTimeMs", "(J)V", "touchFile", "getTouchFile", "()Ljava/lang/String;", "touchFile$delegate", "Lkotlin/Lazy;", "enterActivity", "", "setup", "plugin-finder_release"})
public final class k
{
  private static final f KXA;
  public static final k KXB;
  private static long KXz;
  
  static
  {
    AppMethodBeat.i(199082);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(k.class), "touchFile", "getTouchFile()Ljava/lang/String;")) };
    KXB = new k();
    KXA = d.g.E((a)b.KXD);
    AppMethodBeat.o(199082);
  }
  
  public static long fVh()
  {
    return KXz;
  }
  
  public static String fVi()
  {
    AppMethodBeat.i(199083);
    String str = (String)KXA.getValue();
    AppMethodBeat.o(199083);
    return str;
  }
  
  public static void fVj()
  {
    AppMethodBeat.i(199084);
    KXz = SystemClock.uptimeMillis();
    AppMethodBeat.o(199084);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "ueh", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler;", "kotlin.jvm.PlatformType", "msg", "", "ex", "", "uncaughtException"})
  public static final class a
    implements au.c
  {
    public a(dzo paramdzo) {}
    
    public final void b(String paramString, Throwable paramThrowable)
    {
      Object localObject1 = null;
      AppMethodBeat.i(199079);
      paramThrowable = this.KXC;
      if (paramThrowable == null)
      {
        paramThrowable = new dzo();
        paramThrowable.crashCount = 0;
        paramThrowable.Lyb = 0L;
      }
      for (;;)
      {
        paramString = new StringBuilder("get crash msg ").append(paramString).append(", isInFinder ").append(((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder()).append(" lastEnterTimeMs:");
        Object localObject2 = k.KXB;
        paramString = paramString.append(k.fVh()).append(" pass: ");
        long l = SystemClock.uptimeMillis();
        localObject2 = k.KXB;
        localObject2 = paramString.append(l - k.fVh()).append(" info: ");
        paramString = this.KXC;
        if (paramString != null)
        {
          paramString = Integer.valueOf(paramString.crashCount);
          localObject2 = ((StringBuilder)localObject2).append(paramString).append(' ');
          paramString = this.KXC;
          if (paramString == null) {
            break label400;
          }
          paramString = Long.valueOf(paramString.Lyb);
          label163:
          ad.i("Finder.PageRecovery", paramString);
          if (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).isInFinder())
          {
            l = SystemClock.uptimeMillis();
            paramString = k.KXB;
            if (l - k.fVh() <= 5000L)
            {
              if (System.currentTimeMillis() - paramThrowable.Lyb >= 300000L) {
                break label405;
              }
              paramThrowable.crashCount += 1;
              label236:
              paramThrowable.Lyb = System.currentTimeMillis();
              paramString = k.KXB;
              i.aMF(new e(k.fVk()).getParent());
              paramString = k.KXB;
              i.B(k.fVk(), paramThrowable.toByteArray());
              paramString = new StringBuilder("[setup] crash happen =");
              localObject2 = k.KXB;
              paramString = paramString.append(i.eK(k.fVk())).append(" touchFile=");
              localObject2 = k.KXB;
              localObject2 = paramString.append(k.fVk()).append(" info: ");
              if (paramThrowable == null) {
                break label413;
              }
            }
          }
        }
        label400:
        label405:
        label413:
        for (paramString = Integer.valueOf(paramThrowable.crashCount);; paramString = null)
        {
          localObject2 = ((StringBuilder)localObject2).append(paramString.intValue()).append(' ');
          paramString = localObject1;
          if (paramThrowable != null) {
            paramString = Long.valueOf(paramThrowable.Lyb);
          }
          ad.i("Finder.PageRecovery", paramString.longValue());
          AppMethodBeat.o(199079);
          return;
          paramString = null;
          break;
          paramString = null;
          break label163;
          paramThrowable.crashCount = 1;
          break label236;
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<String>
  {
    public static final b KXD;
    
    static
    {
      AppMethodBeat.i(199081);
      KXD = new b();
      AppMethodBeat.o(199081);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.k
 * JD-Core Version:    0.7.0.1
 */