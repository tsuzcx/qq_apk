package com.tencent.mm.plugin.hp.tinker;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tinkerboots.sdk.a.a;
import com.tinkerboots.sdk.tinker.service.TinkerServerResultService;

public final class e
{
  private static boolean nKJ = false;
  
  public static void QQ(String paramString)
  {
    AppMethodBeat.i(90649);
    if (!nKJ)
    {
      paramString = new RuntimeException("upgrade patch but tinker is not installed");
      AppMethodBeat.o(90649);
      throw paramString;
    }
    com.tencent.tinker.lib.e.c.ce(com.tencent.mm.app.b.bXD.getApplication(), paramString);
    AppMethodBeat.o(90649);
  }
  
  public static void b(ApplicationLike paramApplicationLike)
  {
    AppMethodBeat.i(90646);
    ab.i("Tinker.TinkerPatchManager", "try installing tinker");
    if (nKJ)
    {
      ab.w("Tinker.TinkerPatchManager", "install tinker, but has installed, ignore");
      AppMethodBeat.o(90646);
      return;
    }
    long l1 = 0L;
    long l2;
    label182:
    label226:
    label359:
    label374:
    boolean bool;
    try
    {
      l2 = com.tencent.mm.kernel.a.QW() & 0xFFFFFFFF;
      l1 = l2;
      ab.i("Tinker.TinkerPatchManager", "uin is %s", new Object[] { bo.aqg(String.valueOf(l2)) });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.a locala;
        ab.printErrStackTrace("Tinker.TinkerPatchManager", localException, "tinker patch manager get uin failed.", new Object[0]);
        l2 = l1;
      }
      localException.BsO = ((com.tencent.tinker.lib.d.c)localObject);
      Object localObject = new f(paramApplicationLike.getApplication());
      if (localException.BsP == null) {
        break label182;
      }
      paramApplicationLike = new TinkerRuntimeException("patchReporter is already set.");
      AppMethodBeat.o(90646);
      throw paramApplicationLike;
      localException.BsP = ((com.tencent.tinker.lib.d.d)localObject);
      paramApplicationLike = new c(paramApplicationLike.getApplication());
      if (localException.BsN == null) {
        break label226;
      }
      paramApplicationLike = new TinkerRuntimeException("listener is already set.");
      AppMethodBeat.o(90646);
      throw paramApplicationLike;
      localException.BsN = paramApplicationLike;
      if (localException.BLE == null) {
        break label257;
      }
      paramApplicationLike = new TinkerRuntimeException("resultServiceClass is already set.");
      AppMethodBeat.o(90646);
      throw paramApplicationLike;
      label257:
      localException.BLE = TinkerPatchResultService.class;
      if (localException.BsO != null) {
        break label289;
      }
      localException.BsO = new com.tinkerboots.sdk.tinker.b.a(localException.context);
      label289:
      if (localException.BsP != null) {
        break label314;
      }
      localException.BsP = new com.tinkerboots.sdk.tinker.b.c(localException.context);
      label314:
      if (localException.BsN != null) {
        break label339;
      }
      localException.BsN = new com.tinkerboots.sdk.tinker.b.b(localException.context);
      label339:
      if (localException.BLD != null) {
        break label359;
      }
      localException.BLD = new com.tencent.tinker.lib.c.f();
      if (localException.BLE != null) {
        break label374;
      }
      localException.BLE = TinkerServerResultService.class;
      if (localException.BLF != null) {
        break label394;
      }
      localException.BLF = new com.tinkerboots.sdk.a.a.a();
      label394:
      paramApplicationLike = new com.tinkerboots.sdk.a(localException.context, localException.bXD, localException.BsO, localException.BsP, localException.BsN, localException.BLD, localException.BLE, localException.BLF);
      if (com.tinkerboots.sdk.a.BLy == null) {
        break label465;
      }
      paramApplicationLike = new TinkerRuntimeException("TinkerClient instance is already set.");
      AppMethodBeat.o(90646);
      throw paramApplicationLike;
      label465:
      com.tinkerboots.sdk.a.BLy = paramApplicationLike;
      paramApplicationLike = com.tinkerboots.sdk.a.eaJ().TO(h.eq(ah.getContext()));
      bool = com.tencent.mm.sdk.a.b.dsf();
      if (paramApplicationLike.BLA == null) {
        break label501;
      }
    }
    locala = new a.a(paramApplicationLike);
    localObject = new d(paramApplicationLike.getApplication());
    if (locala.BsO != null)
    {
      paramApplicationLike = new TinkerRuntimeException("loadReporter is already set.");
      AppMethodBeat.o(90646);
      throw paramApplicationLike;
    }
    label501:
    int i;
    label555:
    g localg;
    if (paramApplicationLike.BLz == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
      paramApplicationLike = com.tinkerboots.sdk.a.BLy;
      paramApplicationLike = paramApplicationLike.ji("uin", String.valueOf(l2)).ji("code-version", com.tencent.mm.sdk.platformtools.f.CLIENT_VERSION).ji("code-reversion", com.tencent.mm.sdk.platformtools.f.REV);
      if (!at.isWifi(ah.getContext())) {
        break label694;
      }
      i = 3;
      paramApplicationLike = paramApplicationLike.ji("network", String.valueOf(i)).ji("sdk", String.valueOf(Build.VERSION.SDK_INT)).ji("os-name", com.tencent.mm.protocal.d.whE).ji("device-brand", com.tencent.mm.protocal.d.whB).ji("device-name", com.tencent.mm.protocal.d.DEVICE_NAME);
      localg = new g();
      if ((paramApplicationLike.BLA != null) && (paramApplicationLike.BLz != null)) {
        break label699;
      }
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
    }
    for (;;)
    {
      ab.i("Tinker.TinkerPatchManager", "try installing end");
      nKJ = true;
      AppMethodBeat.o(90646);
      return;
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "set debugger to %b", new Object[] { Boolean.valueOf(bool) });
      paramApplicationLike.BLA.isDebug = bool;
      paramApplicationLike = com.tinkerboots.sdk.a.BLy;
      break;
      label694:
      i = 2;
      break label555;
      label699:
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setPatchRequestCallback with hashcode %d", new Object[] { Integer.valueOf(localg.hashCode()) });
      paramApplicationLike.BLA.BLF = localg;
    }
  }
  
  public static void bIn()
  {
    AppMethodBeat.i(90647);
    com.tencent.tinker.lib.f.a.a(new e.1());
    AppMethodBeat.o(90647);
  }
  
  public static void bIo()
  {
    AppMethodBeat.i(90648);
    if (!nKJ)
    {
      RuntimeException localRuntimeException = new RuntimeException("cleanPatch but tinker is not installed");
      AppMethodBeat.o(90648);
      throw localRuntimeException;
    }
    com.tencent.tinker.lib.e.a.jo(com.tencent.mm.app.b.bXD.getApplication()).bIo();
    AppMethodBeat.o(90648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.e
 * JD-Core Version:    0.7.0.1
 */