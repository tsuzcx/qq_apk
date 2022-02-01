package com.tencent.mm.plugin.hp.tinker;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tinkerboots.sdk.a.a;

public final class e
{
  private static boolean syw = false;
  
  public static void adJ(String paramString)
  {
    AppMethodBeat.i(117485);
    if (!syw)
    {
      paramString = new RuntimeException("upgrade patch but tinker is not installed");
      AppMethodBeat.o(117485);
      throw paramString;
    }
    com.tencent.tinker.lib.e.c.cx(com.tencent.mm.app.d.cKY.getApplication(), paramString);
    AppMethodBeat.o(117485);
  }
  
  public static void b(ApplicationLike paramApplicationLike)
  {
    AppMethodBeat.i(117482);
    ad.i("Tinker.TinkerPatchManager", "try installing tinker");
    if (syw)
    {
      ad.w("Tinker.TinkerPatchManager", "install tinker, but has installed, ignore");
      AppMethodBeat.o(117482);
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = com.tencent.mm.kernel.a.aeL() & 0xFFFFFFFF;
      l1 = l2;
      ad.i("Tinker.TinkerPatchManager", "uin is %s", new Object[] { bt.aGs(String.valueOf(l2)) });
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.a locala;
        ad.printErrStackTrace("Tinker.TinkerPatchManager", localException, "tinker patch manager get uin failed.", new Object[0]);
      }
      localException.IEL = ((com.tencent.tinker.lib.d.c)localObject2);
      localObject1 = localException.a(new f(paramApplicationLike.getApplication()));
      Object localObject2 = new c(paramApplicationLike.getApplication());
      if (((a.a)localObject1).IEK == null) {
        break label200;
      }
      paramApplicationLike = new TinkerRuntimeException("listener is already set.");
      AppMethodBeat.o(117482);
      throw paramApplicationLike;
      ((a.a)localObject1).IEK = ((com.tencent.tinker.lib.b.b)localObject2);
      if (((a.a)localObject1).IWp == null) {
        break label232;
      }
      paramApplicationLike = new TinkerRuntimeException("resultServiceClass is already set.");
      AppMethodBeat.o(117482);
      throw paramApplicationLike;
      ((a.a)localObject1).IWp = TinkerPatchResultService.class;
      com.tinkerboots.sdk.a.a(((a.a)localObject1).ftN());
      localObject1 = com.tinkerboots.sdk.a.ftM().adw(h.fl(paramApplicationLike.getApplication()));
      bool = com.tencent.mm.sdk.a.b.eEQ();
      if (((com.tinkerboots.sdk.a)localObject1).IWl == null) {
        break label284;
      }
    }
    locala = new a.a(paramApplicationLike);
    localObject2 = new d(paramApplicationLike.getApplication());
    if (locala.IEL != null)
    {
      paramApplicationLike = new TinkerRuntimeException("loadReporter is already set.");
      AppMethodBeat.o(117482);
      throw paramApplicationLike;
    }
    Object localObject1;
    label200:
    label232:
    boolean bool;
    label284:
    int i;
    if (((com.tinkerboots.sdk.a)localObject1).IWk == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
      localObject1 = com.tinkerboots.sdk.a.IWj;
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).mn("uin", String.valueOf(l1)).mn("code-version", com.tencent.mm.sdk.platformtools.h.glW).mn("code-reversion", com.tencent.mm.sdk.platformtools.h.REV);
      if (!ay.isWifi(paramApplicationLike.getApplication())) {
        break label519;
      }
      i = 3;
      label341:
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).mn("network", String.valueOf(i)).mn("sdk", String.valueOf(Build.VERSION.SDK_INT)).mn("os-name", com.tencent.mm.protocal.d.CpH).mn("device-brand", com.tencent.mm.protocal.d.CpE).mn("device-name", com.tencent.mm.protocal.d.DEVICE_NAME);
      if (Build.SUPPORTED_64_BIT_ABIS.length <= 0) {
        break label524;
      }
      paramApplicationLike = "1";
      label399:
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).mn("support-64-bit", paramApplicationLike);
      if (!q.is64BitRuntime()) {
        break label531;
      }
      paramApplicationLike = "1";
      label418:
      paramApplicationLike = ((com.tinkerboots.sdk.a)localObject1).mn("device-is-64-bit-runtime", paramApplicationLike);
      localObject1 = new g();
      if ((paramApplicationLike.IWl != null) && (paramApplicationLike.IWk != null)) {
        break label538;
      }
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
    }
    for (;;)
    {
      ad.i("Tinker.TinkerPatchManager", "try installing end");
      syw = true;
      AppMethodBeat.o(117482);
      return;
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "set debugger to %b", new Object[] { Boolean.valueOf(bool) });
      ((com.tinkerboots.sdk.a)localObject1).IWl.cxf = bool;
      localObject1 = com.tinkerboots.sdk.a.IWj;
      break;
      label519:
      i = 2;
      break label341;
      label524:
      paramApplicationLike = "0";
      break label399;
      label531:
      paramApplicationLike = "0";
      break label418;
      label538:
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setPatchRequestCallback with hashcode %d", new Object[] { Integer.valueOf(localObject1.hashCode()) });
      paramApplicationLike.IWl.IWq = ((com.tinkerboots.sdk.a.a.b)localObject1);
    }
  }
  
  public static void cGg()
  {
    AppMethodBeat.i(117483);
    com.tencent.tinker.lib.f.a.a(new e.1());
    AppMethodBeat.o(117483);
  }
  
  public static void cGh()
  {
    AppMethodBeat.i(117484);
    if (!syw)
    {
      RuntimeException localRuntimeException = new RuntimeException("cleanPatch but tinker is not installed");
      AppMethodBeat.o(117484);
      throw localRuntimeException;
    }
    com.tencent.tinker.lib.e.a.kI(com.tencent.mm.app.d.cKY.getApplication()).cGh();
    AppMethodBeat.o(117484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.e
 * JD-Core Version:    0.7.0.1
 */