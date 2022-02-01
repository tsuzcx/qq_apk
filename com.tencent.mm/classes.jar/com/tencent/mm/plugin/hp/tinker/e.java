package com.tencent.mm.plugin.hp.tinker;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tinkerboots.sdk.a.a;

public final class e
{
  private static boolean uIY = false;
  
  public static void ano(String paramString)
  {
    AppMethodBeat.i(117485);
    if (!uIY)
    {
      paramString = new RuntimeException("upgrade patch but tinker is not installed");
      AppMethodBeat.o(117485);
      throw paramString;
    }
    com.tencent.tinker.lib.e.c.cD(com.tencent.mm.app.d.cTo.getApplication(), paramString);
    AppMethodBeat.o(117485);
  }
  
  public static void b(ApplicationLike paramApplicationLike)
  {
    AppMethodBeat.i(117482);
    ad.i("Tinker.TinkerPatchManager", "try installing tinker");
    if (uIY)
    {
      ad.w("Tinker.TinkerPatchManager", "install tinker, but has installed, ignore");
      AppMethodBeat.o(117482);
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = com.tencent.mm.kernel.a.aiN() & 0xFFFFFFFF;
      l1 = l2;
      ad.i("Tinker.TinkerPatchManager", "uin is %s", new Object[] { bt.aRp(String.valueOf(l2)) });
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.a locala;
        ad.printErrStackTrace("Tinker.TinkerPatchManager", localException, "tinker patch manager get uin failed.", new Object[0]);
      }
      localException.MgV = ((com.tencent.tinker.lib.d.c)localObject2);
      localObject1 = localException.a(new f(paramApplicationLike.getApplication()));
      Object localObject2 = new c(paramApplicationLike.getApplication());
      if (((a.a)localObject1).MgU == null) {
        break label200;
      }
      paramApplicationLike = new TinkerRuntimeException("listener is already set.");
      AppMethodBeat.o(117482);
      throw paramApplicationLike;
      ((a.a)localObject1).MgU = ((com.tencent.tinker.lib.b.b)localObject2);
      if (((a.a)localObject1).MAn == null) {
        break label232;
      }
      paramApplicationLike = new TinkerRuntimeException("resultServiceClass is already set.");
      AppMethodBeat.o(117482);
      throw paramApplicationLike;
      ((a.a)localObject1).MAn = TinkerPatchResultService.class;
      com.tinkerboots.sdk.a.a(((a.a)localObject1).gdV());
      localObject1 = com.tinkerboots.sdk.a.gdU().aiS(h.fD(paramApplicationLike.getApplication()));
      bool = com.tencent.mm.sdk.a.b.fjN();
      if (((com.tinkerboots.sdk.a)localObject1).MAj == null) {
        break label284;
      }
    }
    locala = new a.a(paramApplicationLike);
    localObject2 = new d(paramApplicationLike.getApplication());
    if (locala.MgV != null)
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
    if (((com.tinkerboots.sdk.a)localObject1).MAi == null)
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
      localObject1 = com.tinkerboots.sdk.a.MAh;
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).nm("uin", String.valueOf(l1)).nm("code-version", i.hgG).nm("code-reversion", i.REV);
      if (!ay.isWifi(paramApplicationLike.getApplication())) {
        break label519;
      }
      i = 3;
      label341:
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).nm("network", String.valueOf(i)).nm("sdk", String.valueOf(Build.VERSION.SDK_INT)).nm("os-name", com.tencent.mm.protocal.d.Fng).nm("device-brand", com.tencent.mm.protocal.d.Fnd).nm("device-name", com.tencent.mm.protocal.d.DEVICE_NAME);
      if (Build.SUPPORTED_64_BIT_ABIS.length <= 0) {
        break label524;
      }
      paramApplicationLike = "1";
      label399:
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).nm("support-64-bit", paramApplicationLike);
      if (!q.is64BitRuntime()) {
        break label531;
      }
      paramApplicationLike = "1";
      label418:
      paramApplicationLike = ((com.tinkerboots.sdk.a)localObject1).nm("device-is-64-bit-runtime", paramApplicationLike);
      localObject1 = new g();
      if ((paramApplicationLike.MAj != null) && (paramApplicationLike.MAi != null)) {
        break label538;
      }
      ShareTinkerLog.v("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
    }
    for (;;)
    {
      ad.i("Tinker.TinkerPatchManager", "try installing end");
      uIY = true;
      AppMethodBeat.o(117482);
      return;
      ShareTinkerLog.v("Tinker.TinkerClient", "set debugger to %b", new Object[] { Boolean.valueOf(bool) });
      ((com.tinkerboots.sdk.a)localObject1).MAj.cFj = bool;
      localObject1 = com.tinkerboots.sdk.a.MAh;
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
      paramApplicationLike.MAj.MAo = ((com.tinkerboots.sdk.a.a.b)localObject1);
    }
  }
  
  public static void dcA()
  {
    AppMethodBeat.i(117483);
    ShareTinkerLog.setTinkerLogImp(new e.1());
    AppMethodBeat.o(117483);
  }
  
  public static void dcB()
  {
    AppMethodBeat.i(117484);
    if (!uIY)
    {
      RuntimeException localRuntimeException = new RuntimeException("cleanPatch but tinker is not installed");
      AppMethodBeat.o(117484);
      throw localRuntimeException;
    }
    com.tencent.tinker.lib.e.a.lk(com.tencent.mm.app.d.cTo.getApplication()).dcB();
    AppMethodBeat.o(117484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.e
 * JD-Core Version:    0.7.0.1
 */