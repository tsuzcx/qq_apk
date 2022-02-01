package com.tencent.mm.plugin.finder.storage.data;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.btu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/PageRecovery;", "", "()V", "SENSITIVE_CRASH_DURATION", "", "SENSITIVE_DURATION", "TAG", "", "lastEnterTimeMs", "", "getLastEnterTimeMs", "()J", "setLastEnterTimeMs", "(J)V", "touchFile", "getTouchFile", "()Ljava/lang/String;", "touchFile$delegate", "Lkotlin/Lazy;", "enterActivity", "", "setup", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
{
  public static final v FNs;
  private static long FNt;
  private static final j FNu;
  
  static
  {
    AppMethodBeat.i(339339);
    FNs = new v();
    FNu = kotlin.k.cm((kotlin.g.a.a)a.FNv);
    AppMethodBeat.o(339339);
  }
  
  private static final void a(btu parambtu, MMUncaughtExceptionHandler paramMMUncaughtExceptionHandler, String paramString, Throwable paramThrowable)
  {
    paramThrowable = null;
    AppMethodBeat.i(339332);
    if (parambtu == null)
    {
      paramMMUncaughtExceptionHandler = new btu();
      paramMMUncaughtExceptionHandler.aabv = 0;
      paramMMUncaughtExceptionHandler.aabu = 0L;
      StringBuilder localStringBuilder = new StringBuilder("get crash msg ").append(paramString).append(", isInFinder ").append(((PluginFinder)h.az(PluginFinder.class)).isInFinder()).append(" lastEnterTimeMs:").append(FNt).append(" pass: ").append(SystemClock.uptimeMillis() - FNt).append(" info: ");
      if (parambtu != null) {
        break label303;
      }
      paramString = null;
      label100:
      paramString = localStringBuilder.append(paramString).append(' ');
      if (parambtu != null) {
        break label314;
      }
      parambtu = paramThrowable;
      label118:
      Log.i("Finder.PageRecovery", parambtu);
      if ((((PluginFinder)h.az(PluginFinder.class)).isInFinder()) && (SystemClock.uptimeMillis() - FNt <= 5000L)) {
        if (System.currentTimeMillis() - paramMMUncaughtExceptionHandler.aabu >= 300000L) {
          break label325;
        }
      }
    }
    label303:
    label314:
    label325:
    for (paramMMUncaughtExceptionHandler.aabv += 1;; paramMMUncaughtExceptionHandler.aabv = 1)
    {
      paramMMUncaughtExceptionHandler.aabu = System.currentTimeMillis();
      y.bDX(new com.tencent.mm.vfs.u(fak()).jKO());
      parambtu = fak();
      paramString = paramMMUncaughtExceptionHandler.toByteArray();
      y.f(parambtu, paramString, paramString.length);
      Log.i("Finder.PageRecovery", "[setup] crash happen =" + y.ZC(fak()) + " touchFile=" + fak() + " info: " + Integer.valueOf(paramMMUncaughtExceptionHandler.aabv) + ' ' + Long.valueOf(paramMMUncaughtExceptionHandler.aabu));
      AppMethodBeat.o(339332);
      return;
      paramMMUncaughtExceptionHandler = parambtu;
      break;
      paramString = Integer.valueOf(parambtu.aabv);
      break label100;
      parambtu = Long.valueOf(parambtu.aabu);
      break label118;
    }
  }
  
  private static String fak()
  {
    AppMethodBeat.i(339305);
    String str = (String)FNu.getValue();
    AppMethodBeat.o(339305);
    return str;
  }
  
  public static void fal()
  {
    AppMethodBeat.i(339312);
    FNt = SystemClock.uptimeMillis();
    AppMethodBeat.o(339312);
  }
  
  public static void setup()
  {
    k.a locala = null;
    AppMethodBeat.i(339326);
    Object localObject1 = (com.tencent.mm.bx.a)new btu();
    Object localObject3 = y.bi(fak(), 0, -1);
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
      localObject3 = (btu)localObject1;
      StringBuilder localStringBuilder = new StringBuilder("[setup] isExist=").append(y.ZC(fak())).append(" touchFile=").append(fak()).append(" info: ");
      if (localObject3 == null)
      {
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(' ');
        if (localObject3 != null) {
          break label212;
        }
        localObject1 = null;
        Log.i("Finder.PageRecovery", localObject1);
        if (localObject3 != null)
        {
          if (((btu)localObject3).aabv < 2) {
            break label223;
          }
          i = 1;
          localObject1 = locala;
          if (i != 0) {
            localObject1 = localObject3;
          }
          if (localObject1 != null)
          {
            locala = k.FNg;
            k.a.clearAll();
            y.deleteFile(fak());
            ((btu)localObject1).aabv = 0;
            ((btu)localObject1).aabu = 0L;
          }
        }
        MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(new v..ExternalSyntheticLambda0((btu)localObject3));
        AppMethodBeat.o(339326);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
        continue;
        localObject2 = Integer.valueOf(((btu)localObject3).aabv);
        continue;
        label212:
        localObject2 = Long.valueOf(((btu)localObject3).aabu);
        continue;
        label223:
        int i = 0;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    public static final a FNv;
    
    static
    {
      AppMethodBeat.i(339285);
      FNv = new a();
      AppMethodBeat.o(339285);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.v
 * JD-Core Version:    0.7.0.1
 */