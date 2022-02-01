package com.tencent.mm.plugin.hp.tinker;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tinkerboots.sdk.a.a;

public final class e
{
  private static boolean uUL = false;
  
  public static void aoq(String paramString)
  {
    AppMethodBeat.i(117485);
    if (!uUL)
    {
      paramString = new RuntimeException("upgrade patch but tinker is not installed");
      AppMethodBeat.o(117485);
      throw paramString;
    }
    com.tencent.tinker.lib.e.c.cE(com.tencent.mm.app.d.cTZ.getApplication(), paramString);
    AppMethodBeat.o(117485);
  }
  
  public static void b(ApplicationLike paramApplicationLike)
  {
    AppMethodBeat.i(117482);
    ae.i("Tinker.TinkerPatchManager", "try installing tinker");
    if (uUL)
    {
      ae.w("Tinker.TinkerPatchManager", "install tinker, but has installed, ignore");
      AppMethodBeat.o(117482);
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = com.tencent.mm.kernel.a.ajc() & 0xFFFFFFFF;
      l1 = l2;
      ae.i("Tinker.TinkerPatchManager", "uin is %s", new Object[] { bu.aSM(String.valueOf(l2)) });
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.a locala;
        ae.printErrStackTrace("Tinker.TinkerPatchManager", localException, "tinker patch manager get uin failed.", new Object[0]);
      }
      localException.MDS = ((com.tencent.tinker.lib.d.c)localObject2);
      localObject1 = localException.a(new f(paramApplicationLike.getApplication()));
      Object localObject2 = new c(paramApplicationLike.getApplication());
      if (((a.a)localObject1).MDR == null) {
        break label200;
      }
      paramApplicationLike = new TinkerRuntimeException("listener is already set.");
      AppMethodBeat.o(117482);
      throw paramApplicationLike;
      ((a.a)localObject1).MDR = ((com.tencent.tinker.lib.b.b)localObject2);
      if (((a.a)localObject1).MXu == null) {
        break label232;
      }
      paramApplicationLike = new TinkerRuntimeException("resultServiceClass is already set.");
      AppMethodBeat.o(117482);
      throw paramApplicationLike;
      ((a.a)localObject1).MXu = TinkerPatchResultService.class;
      com.tinkerboots.sdk.a.a(((a.a)localObject1).giy());
      localObject1 = com.tinkerboots.sdk.a.gix().ajC(h.fI(paramApplicationLike.getApplication()));
      bool = com.tencent.mm.sdk.a.b.fnF();
      if (((com.tinkerboots.sdk.a)localObject1).MXq == null) {
        break label284;
      }
    }
    locala = new a.a(paramApplicationLike);
    localObject2 = new d(paramApplicationLike.getApplication());
    if (locala.MDS != null)
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
    if (((com.tinkerboots.sdk.a)localObject1).MXp == null)
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
      localObject1 = com.tinkerboots.sdk.a.MXo;
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).ns("uin", String.valueOf(l1)).ns("code-version", j.hju).ns("code-reversion", j.REV);
      if (!az.isWifi(paramApplicationLike.getApplication())) {
        break label519;
      }
      i = 3;
      label341:
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).ns("network", String.valueOf(i)).ns("sdk", String.valueOf(Build.VERSION.SDK_INT)).ns("os-name", com.tencent.mm.protocal.d.FFE).ns("device-brand", com.tencent.mm.protocal.d.FFB).ns("device-name", com.tencent.mm.protocal.d.DEVICE_NAME);
      if (Build.SUPPORTED_64_BIT_ABIS.length <= 0) {
        break label524;
      }
      paramApplicationLike = "1";
      label399:
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).ns("support-64-bit", paramApplicationLike);
      if (!q.is64BitRuntime()) {
        break label531;
      }
      paramApplicationLike = "1";
      label418:
      paramApplicationLike = ((com.tinkerboots.sdk.a)localObject1).ns("device-is-64-bit-runtime", paramApplicationLike);
      localObject1 = new g();
      if ((paramApplicationLike.MXq != null) && (paramApplicationLike.MXp != null)) {
        break label538;
      }
      ShareTinkerLog.v("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
    }
    for (;;)
    {
      ae.i("Tinker.TinkerPatchManager", "try installing end");
      uUL = true;
      AppMethodBeat.o(117482);
      return;
      ShareTinkerLog.v("Tinker.TinkerClient", "set debugger to %b", new Object[] { Boolean.valueOf(bool) });
      ((com.tinkerboots.sdk.a)localObject1).MXq.cFS = bool;
      localObject1 = com.tinkerboots.sdk.a.MXo;
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
      paramApplicationLike.MXq.MXv = ((com.tinkerboots.sdk.a.a.b)localObject1);
    }
  }
  
  public static void dfs()
  {
    AppMethodBeat.i(117483);
    ShareTinkerLog.setTinkerLogImp(new e.1());
    AppMethodBeat.o(117483);
  }
  
  public static void dft()
  {
    AppMethodBeat.i(117484);
    if (!uUL)
    {
      RuntimeException localRuntimeException = new RuntimeException("cleanPatch but tinker is not installed");
      AppMethodBeat.o(117484);
      throw localRuntimeException;
    }
    com.tencent.tinker.lib.e.a.lq(com.tencent.mm.app.d.cTZ.getApplication()).dft();
    AppMethodBeat.o(117484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.e
 * JD-Core Version:    0.7.0.1
 */