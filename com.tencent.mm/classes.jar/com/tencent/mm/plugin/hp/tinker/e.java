package com.tencent.mm.plugin.hp.tinker;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tinkerboots.sdk.a.a;

public final class e
{
  private static boolean JEC = false;
  
  public static void aIK(String paramString)
  {
    AppMethodBeat.i(117485);
    if (!JEC)
    {
      paramString = new RuntimeException("upgrade patch but tinker is not installed");
      AppMethodBeat.o(117485);
      throw paramString;
    }
    com.tencent.tinker.lib.e.c.ds(com.tencent.mm.app.e.hfI.getApplication(), paramString);
    AppMethodBeat.o(117485);
  }
  
  public static void b(ApplicationLike paramApplicationLike)
  {
    AppMethodBeat.i(117482);
    Log.i("Tinker.TinkerPatchManager", "try installing tinker");
    if (JEC)
    {
      Log.w("Tinker.TinkerPatchManager", "install tinker, but has installed, ignore");
      AppMethodBeat.o(117482);
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = com.tencent.mm.kernel.b.aZP() & 0xFFFFFFFF;
      l1 = l2;
      Log.i("Tinker.TinkerPatchManager", "uin is %s", new Object[] { Util.secPrint(String.valueOf(l2)) });
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.a locala;
        Log.printErrStackTrace("Tinker.TinkerPatchManager", localException, "tinker patch manager get uin failed.", new Object[0]);
      }
      localException.ahRH = ((com.tencent.tinker.lib.d.c)localObject2);
      localObject1 = localException.a(new f(paramApplicationLike.getApplication()));
      Object localObject2 = new c(paramApplicationLike.getApplication());
      if (((a.a)localObject1).ahRG == null) {
        break label200;
      }
      paramApplicationLike = new TinkerRuntimeException("listener is already set.");
      AppMethodBeat.o(117482);
      throw paramApplicationLike;
      ((a.a)localObject1).ahRG = ((com.tencent.tinker.lib.b.b)localObject2);
      if (((a.a)localObject1).aisj == null) {
        break label232;
      }
      paramApplicationLike = new TinkerRuntimeException("resultServiceClass is already set.");
      AppMethodBeat.o(117482);
      throw paramApplicationLike;
      ((a.a)localObject1).aisj = TinkerPatchResultService.class;
      com.tinkerboots.sdk.a.a(((a.a)localObject1).kks());
      localObject1 = com.tinkerboots.sdk.a.kkr().aJY(h.iG(paramApplicationLike.getApplication()));
      bool = CrashReportFactory.hasDebuger();
      if (((com.tinkerboots.sdk.a)localObject1).aisf == null) {
        break label284;
      }
    }
    locala = new a.a(paramApplicationLike);
    localObject2 = new d(paramApplicationLike.getApplication());
    if (locala.ahRH != null)
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
    if (((com.tinkerboots.sdk.a)localObject1).aise == null)
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
      localObject1 = com.tinkerboots.sdk.a.aisd;
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).rg("uin", String.valueOf(l1)).rg("code-version", BuildInfo.CLIENT_VERSION).rg("code-reversion", BuildInfo.REV);
      if (!NetStatusUtil.isWifi(paramApplicationLike.getApplication())) {
        break label519;
      }
      i = 3;
      label341:
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).rg("network", String.valueOf(i)).rg("sdk", String.valueOf(Build.VERSION.SDK_INT)).rg("os-name", com.tencent.mm.protocal.d.Yxd).rg("device-brand", com.tencent.mm.protocal.d.Yxa).rg("device-name", com.tencent.mm.protocal.d.Yxf);
      if (Build.SUPPORTED_64_BIT_ABIS.length <= 0) {
        break label524;
      }
      paramApplicationLike = "1";
      label399:
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).rg("support-64-bit", paramApplicationLike);
      if (!q.awm()) {
        break label531;
      }
      paramApplicationLike = "1";
      label418:
      paramApplicationLike = ((com.tinkerboots.sdk.a)localObject1).rg("device-is-64-bit-runtime", paramApplicationLike);
      localObject1 = new g();
      if ((paramApplicationLike.aisf != null) && (paramApplicationLike.aise != null)) {
        break label538;
      }
      ShareTinkerLog.v("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
    }
    for (;;)
    {
      Log.i("Tinker.TinkerPatchManager", "try installing end");
      JEC = true;
      AppMethodBeat.o(117482);
      return;
      ShareTinkerLog.v("Tinker.TinkerClient", "set debugger to %b", new Object[] { Boolean.valueOf(bool) });
      ((com.tinkerboots.sdk.a)localObject1).aisf.eYL = bool;
      localObject1 = com.tinkerboots.sdk.a.aisd;
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
      paramApplicationLike.aisf.aisk = ((com.tinkerboots.sdk.a.a.b)localObject1);
    }
  }
  
  public static void fQc()
  {
    AppMethodBeat.i(117483);
    ShareTinkerLog.setTinkerLogImp(new e.1());
    AppMethodBeat.o(117483);
  }
  
  public static void fQd()
  {
    AppMethodBeat.i(117484);
    if (!JEC)
    {
      RuntimeException localRuntimeException = new RuntimeException("cleanPatch but tinker is not installed");
      AppMethodBeat.o(117484);
      throw localRuntimeException;
    }
    com.tencent.tinker.lib.e.a.oy(com.tencent.mm.app.e.hfI.getApplication()).fQd();
    AppMethodBeat.o(117484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.e
 * JD-Core Version:    0.7.0.1
 */