package com.tencent.mm.plugin.hp.tinker;

import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tinkerboots.sdk.a.a;
import com.tinkerboots.sdk.tinker.service.TinkerServerResultService;

public final class d
{
  private static boolean lnq = false;
  
  public static void Fs(String paramString)
  {
    if (!lnq) {
      throw new RuntimeException("upgrade patch but tinker is not installed");
    }
    com.tencent.tinker.lib.e.c.bR(com.tencent.mm.app.b.applicationLike.getApplication(), paramString);
  }
  
  public static void b(ApplicationLike paramApplicationLike)
  {
    y.i("Tinker.TinkerPatchManager", "try installing tinker");
    if (lnq)
    {
      y.w("Tinker.TinkerPatchManager", "install tinker, but has installed, ignore");
      return;
    }
    long l1 = 0L;
    long l2;
    try
    {
      l2 = com.tencent.mm.kernel.a.De() & 0xFFFFFFFF;
      l1 = l2;
      y.i("Tinker.TinkerPatchManager", "uin is %s", new Object[] { bk.aac(String.valueOf(l2)) });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.a locala;
        y.printErrStackTrace("Tinker.TinkerPatchManager", localException, "tinker patch manager get uin failed.", new Object[0]);
        l2 = l1;
      }
      localException.wWl = ((com.tencent.tinker.lib.d.c)localObject);
      Object localObject = new e(paramApplicationLike.getApplication());
      if (localException.wWm == null) {
        break label158;
      }
      throw new TinkerRuntimeException("patchReporter is already set.");
      localException.wWm = ((com.tencent.tinker.lib.d.d)localObject);
      paramApplicationLike = new b(paramApplicationLike.getApplication());
      if (localException.wWk == null) {
        break label195;
      }
      throw new TinkerRuntimeException("listener is already set.");
      localException.wWk = paramApplicationLike;
      if (localException.xnI == null) {
        break label219;
      }
      throw new TinkerRuntimeException("resultServiceClass is already set.");
      localException.xnI = TinkerPatchResultService.class;
      if (localException.wWl != null) {
        break label251;
      }
      localException.wWl = new com.tinkerboots.sdk.tinker.b.a(localException.context);
      if (localException.wWm != null) {
        break label276;
      }
      localException.wWm = new com.tinkerboots.sdk.tinker.b.c(localException.context);
      if (localException.wWk != null) {
        break label301;
      }
      localException.wWk = new com.tinkerboots.sdk.tinker.b.b(localException.context);
      if (localException.xnH != null) {
        break label321;
      }
      localException.xnH = new com.tencent.tinker.lib.c.f();
      if (localException.xnI != null) {
        break label336;
      }
      localException.xnI = TinkerServerResultService.class;
      if (localException.xnJ != null) {
        break label356;
      }
      localException.xnJ = new com.tinkerboots.sdk.a.a.a();
      paramApplicationLike = new com.tinkerboots.sdk.a(localException.context, localException.applicationLike, localException.wWl, localException.wWm, localException.wWk, localException.xnH, localException.xnI, localException.xnJ);
      if (com.tinkerboots.sdk.a.xnC == null) {
        break label420;
      }
      throw new TinkerRuntimeException("TinkerClient instance is already set.");
      com.tinkerboots.sdk.a.xnC = paramApplicationLike;
      paramApplicationLike = com.tinkerboots.sdk.a.cTY().KL(g.dF(ae.getContext()));
      bool = com.tencent.mm.sdk.a.b.cqk();
      if (paramApplicationLike.xnE == null) {
        break label456;
      }
    }
    locala = new a.a(paramApplicationLike);
    localObject = new c(paramApplicationLike.getApplication());
    if (locala.wWl != null) {
      throw new TinkerRuntimeException("loadReporter is already set.");
    }
    label158:
    label195:
    label219:
    label251:
    boolean bool;
    label276:
    label301:
    label321:
    label336:
    label356:
    int i;
    label420:
    label456:
    label510:
    f localf;
    if (paramApplicationLike.xnD == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
      paramApplicationLike = com.tinkerboots.sdk.a.xnC;
      paramApplicationLike = paramApplicationLike.gV("uin", String.valueOf(l2)).gV("code-version", com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION).gV("code-reversion", com.tencent.mm.sdk.platformtools.d.REV);
      if (!aq.isWifi(ae.getContext())) {
        break label643;
      }
      i = 3;
      paramApplicationLike = paramApplicationLike.gV("network", String.valueOf(i)).gV("sdk", String.valueOf(Build.VERSION.SDK_INT)).gV("os-name", com.tencent.mm.protocal.d.soX).gV("device-brand", com.tencent.mm.protocal.d.soU).gV("device-name", com.tencent.mm.protocal.d.DEVICE_NAME);
      localf = new f();
      if ((paramApplicationLike.xnE != null) && (paramApplicationLike.xnD != null)) {
        break label648;
      }
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
    }
    for (;;)
    {
      y.i("Tinker.TinkerPatchManager", "try installing end");
      lnq = true;
      return;
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "set debugger to %b", new Object[] { Boolean.valueOf(bool) });
      paramApplicationLike.xnE.isDebug = bool;
      paramApplicationLike = com.tinkerboots.sdk.a.xnC;
      break;
      label643:
      i = 2;
      break label510;
      label648:
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setPatchRequestCallback with hashcode %d", new Object[] { Integer.valueOf(localf.hashCode()) });
      paramApplicationLike.xnE.xnJ = localf;
    }
  }
  
  public static void bbi()
  {
    com.tencent.tinker.lib.f.a.a(new d.1());
  }
  
  public static void bbj()
  {
    if (!lnq) {
      throw new RuntimeException("cleanPatch but tinker is not installed");
    }
    com.tencent.tinker.lib.e.a.hN(com.tencent.mm.app.b.applicationLike.getApplication()).bbj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.d
 * JD-Core Version:    0.7.0.1
 */