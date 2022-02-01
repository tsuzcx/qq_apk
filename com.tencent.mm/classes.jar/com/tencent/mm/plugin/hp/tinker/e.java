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
  private static boolean ynm = false;
  
  public static void aBJ(String paramString)
  {
    AppMethodBeat.i(117485);
    if (!ynm)
    {
      paramString = new RuntimeException("upgrade patch but tinker is not installed");
      AppMethodBeat.o(117485);
      throw paramString;
    }
    com.tencent.tinker.lib.e.c.cY(com.tencent.mm.app.d.dks.getApplication(), paramString);
    AppMethodBeat.o(117485);
  }
  
  public static void b(ApplicationLike paramApplicationLike)
  {
    AppMethodBeat.i(117482);
    Log.i("Tinker.TinkerPatchManager", "try installing tinker");
    if (ynm)
    {
      Log.w("Tinker.TinkerPatchManager", "install tinker, but has installed, ignore");
      AppMethodBeat.o(117482);
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = com.tencent.mm.kernel.a.azs() & 0xFFFFFFFF;
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
      localException.SjU = ((com.tencent.tinker.lib.d.c)localObject2);
      localObject1 = localException.a(new f(paramApplicationLike.getApplication()));
      Object localObject2 = new c(paramApplicationLike.getApplication());
      if (((a.a)localObject1).SjT == null) {
        break label200;
      }
      paramApplicationLike = new TinkerRuntimeException("listener is already set.");
      AppMethodBeat.o(117482);
      throw paramApplicationLike;
      ((a.a)localObject1).SjT = ((com.tencent.tinker.lib.b.b)localObject2);
      if (((a.a)localObject1).SKC == null) {
        break label232;
      }
      paramApplicationLike = new TinkerRuntimeException("resultServiceClass is already set.");
      AppMethodBeat.o(117482);
      throw paramApplicationLike;
      ((a.a)localObject1).SKC = TinkerPatchResultService.class;
      com.tinkerboots.sdk.a.a(((a.a)localObject1).hvY());
      localObject1 = com.tinkerboots.sdk.a.hvX().atk(h.go(paramApplicationLike.getApplication()));
      bool = CrashReportFactory.hasDebuger();
      if (((com.tinkerboots.sdk.a)localObject1).SKy == null) {
        break label284;
      }
    }
    locala = new a.a(paramApplicationLike);
    localObject2 = new d(paramApplicationLike.getApplication());
    if (locala.SjU != null)
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
    if (((com.tinkerboots.sdk.a)localObject1).SKx == null)
    {
      ShareTinkerLog.v("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
      localObject1 = com.tinkerboots.sdk.a.SKw;
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).ol("uin", String.valueOf(l1)).ol("code-version", BuildInfo.CLIENT_VERSION).ol("code-reversion", BuildInfo.REV);
      if (!NetStatusUtil.isWifi(paramApplicationLike.getApplication())) {
        break label519;
      }
      i = 3;
      label341:
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).ol("network", String.valueOf(i)).ol("sdk", String.valueOf(Build.VERSION.SDK_INT)).ol("os-name", com.tencent.mm.protocal.d.KyL).ol("device-brand", com.tencent.mm.protocal.d.KyI).ol("device-name", com.tencent.mm.protocal.d.DEVICE_NAME);
      if (Build.SUPPORTED_64_BIT_ABIS.length <= 0) {
        break label524;
      }
      paramApplicationLike = "1";
      label399:
      localObject1 = ((com.tinkerboots.sdk.a)localObject1).ol("support-64-bit", paramApplicationLike);
      if (!q.is64BitRuntime()) {
        break label531;
      }
      paramApplicationLike = "1";
      label418:
      paramApplicationLike = ((com.tinkerboots.sdk.a)localObject1).ol("device-is-64-bit-runtime", paramApplicationLike);
      localObject1 = new g();
      if ((paramApplicationLike.SKy != null) && (paramApplicationLike.SKx != null)) {
        break label538;
      }
      ShareTinkerLog.v("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
    }
    for (;;)
    {
      Log.i("Tinker.TinkerPatchManager", "try installing end");
      ynm = true;
      AppMethodBeat.o(117482);
      return;
      ShareTinkerLog.v("Tinker.TinkerClient", "set debugger to %b", new Object[] { Boolean.valueOf(bool) });
      ((com.tinkerboots.sdk.a)localObject1).SKy.cWq = bool;
      localObject1 = com.tinkerboots.sdk.a.SKw;
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
      paramApplicationLike.SKy.SKD = ((com.tinkerboots.sdk.a.a.b)localObject1);
    }
  }
  
  public static void dZm()
  {
    AppMethodBeat.i(117483);
    ShareTinkerLog.setTinkerLogImp(new e.1());
    AppMethodBeat.o(117483);
  }
  
  public static void dZn()
  {
    AppMethodBeat.i(117484);
    if (!ynm)
    {
      RuntimeException localRuntimeException = new RuntimeException("cleanPatch but tinker is not installed");
      AppMethodBeat.o(117484);
      throw localRuntimeException;
    }
    com.tencent.tinker.lib.e.a.lk(com.tencent.mm.app.d.dks.getApplication()).dZn();
    AppMethodBeat.o(117484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.e
 * JD-Core Version:    0.7.0.1
 */