package com.tencent.mm.plugin.hp.tinker;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tinkerboots.sdk.a.a;

public final class e
{
  private static boolean tGm = false;
  
  public static void aiB(String paramString)
  {
    AppMethodBeat.i(117485);
    if (!tGm)
    {
      paramString = new RuntimeException("upgrade patch but tinker is not installed");
      AppMethodBeat.o(117485);
      throw paramString;
    }
    com.tencent.tinker.lib.e.c.cz(com.tencent.mm.app.d.cIg.getApplication(), paramString);
    AppMethodBeat.o(117485);
  }
  
  public static void b(ApplicationLike paramApplicationLike)
  {
    AppMethodBeat.i(117482);
    ac.i("Tinker.TinkerPatchManager", "try installing tinker");
    if (tGm)
    {
      ac.w("Tinker.TinkerPatchManager", "install tinker, but has installed, ignore");
      AppMethodBeat.o(117482);
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = com.tencent.mm.kernel.a.agb() & 0xFFFFFFFF;
      l1 = l2;
      ac.i("Tinker.TinkerPatchManager", "uin is %s", new Object[] { bs.aLJ(String.valueOf(l2)) });
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.a locala;
        ac.printErrStackTrace("Tinker.TinkerPatchManager", localException, "tinker patch manager get uin failed.", new Object[0]);
      }
      localException.KqU = ((com.tencent.tinker.lib.d.c)localObject2);
      localObject1 = localException.a(new f(paramApplicationLike.getApplication()));
      Object localObject2 = new c(paramApplicationLike.getApplication());
      if (((a.a)localObject1).KqT == null) {
        break label200;
      }
      paramApplicationLike = new TinkerRuntimeException("listener is already set.");
      AppMethodBeat.o(117482);
      throw paramApplicationLike;
      ((a.a)localObject1).KqT = ((com.tencent.tinker.lib.b.b)localObject2);
      if (((a.a)localObject1).KJA == null) {
        break label232;
      }
      paramApplicationLike = new TinkerRuntimeException("resultServiceClass is already set.");
      AppMethodBeat.o(117482);
      throw paramApplicationLike;
      ((a.a)localObject1).KJA = TinkerPatchResultService.class;
      com.tinkerboots.sdk.a.a(((a.a)localObject1).fMy());
      localObject1 = com.tinkerboots.sdk.a.fMx().agr(h.fy(paramApplicationLike.getApplication()));
      bool = com.tencent.mm.sdk.a.b.eUk();
      if (((com.tinkerboots.sdk.a)localObject1).KJw == null) {
        break label284;
      }
    }
    locala = new a.a(paramApplicationLike);
    localObject2 = new d(paramApplicationLike.getApplication());
    if (locala.KqU != null)
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
    if (((com.tinkerboots.sdk.a)localObject1).KJv == null)
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
      localObject1 = com.tinkerboots.sdk.a.KJu;
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).mO("uin", String.valueOf(l1)).mO("code-version", com.tencent.mm.sdk.platformtools.h.gMJ).mO("code-reversion", com.tencent.mm.sdk.platformtools.h.REV);
      if (!ax.isWifi(paramApplicationLike.getApplication())) {
        break label519;
      }
      i = 3;
      label341:
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).mO("network", String.valueOf(i)).mO("sdk", String.valueOf(Build.VERSION.SDK_INT)).mO("os-name", com.tencent.mm.protocal.d.DHZ).mO("device-brand", com.tencent.mm.protocal.d.DHW).mO("device-name", com.tencent.mm.protocal.d.DEVICE_NAME);
      if (Build.SUPPORTED_64_BIT_ABIS.length <= 0) {
        break label524;
      }
      paramApplicationLike = "1";
      label399:
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).mO("support-64-bit", paramApplicationLike);
      if (!q.is64BitRuntime()) {
        break label531;
      }
      paramApplicationLike = "1";
      label418:
      paramApplicationLike = ((com.tinkerboots.sdk.a)localObject1).mO("device-is-64-bit-runtime", paramApplicationLike);
      localObject1 = new g();
      if ((paramApplicationLike.KJw != null) && (paramApplicationLike.KJv != null)) {
        break label538;
      }
      ShareTinkerLog.v("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
    }
    for (;;)
    {
      ac.i("Tinker.TinkerPatchManager", "try installing end");
      tGm = true;
      AppMethodBeat.o(117482);
      return;
      ShareTinkerLog.v("Tinker.TinkerClient", "set debugger to %b", new Object[] { Boolean.valueOf(bool) });
      ((com.tinkerboots.sdk.a)localObject1).KJw.cuo = bool;
      localObject1 = com.tinkerboots.sdk.a.KJu;
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
      ShareTinkerLog.v("Tinker.TinkerClient", "setPatchRequestCallback with hashcode %d", new Object[] { Integer.valueOf(localObject1.hashCode()) });
      paramApplicationLike.KJw.KJB = ((com.tinkerboots.sdk.a.a.b)localObject1);
    }
  }
  
  public static void cTq()
  {
    AppMethodBeat.i(117483);
    ShareTinkerLog.setTinkerLogImp(new e.1());
    AppMethodBeat.o(117483);
  }
  
  public static void cTr()
  {
    AppMethodBeat.i(117484);
    if (!tGm)
    {
      RuntimeException localRuntimeException = new RuntimeException("cleanPatch but tinker is not installed");
      AppMethodBeat.o(117484);
      throw localRuntimeException;
    }
    com.tencent.tinker.lib.e.a.kX(com.tencent.mm.app.d.cIg.getApplication()).cTr();
    AppMethodBeat.o(117484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.e
 * JD-Core Version:    0.7.0.1
 */