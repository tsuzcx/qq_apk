package com.tencent.mm.plugin.appbrand.permission.appidABTest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static String TAG = "MicroMsg.AppBrandPermission.AppidABTestConfig";
  private static int tFb = 1;
  private static int tFc = 0;
  
  public static final boolean o(com.tencent.luggage.sdk.e.d paramd)
  {
    AppMethodBeat.i(318766);
    if (paramd == null) {
      Log.i(TAG, "fail:runtime is nil");
    }
    for (paramd = null;; paramd = paramd.tEZ)
    {
      if ((paramd == null) || (paramd.length <= b.a.tFf.tFg) || (paramd[b.a.tFf.tFg] != tFb)) {
        break label114;
      }
      AppMethodBeat.o(318766);
      return true;
      com.tencent.mm.plugin.appbrand.permission.d locald = paramd.evw;
      if (locald == null)
      {
        Log.e(TAG, "NULL permissionController with appId:%s", new Object[] { paramd.mAppId });
        break;
      }
      paramd = locald.dc(paramd.mAppId, paramd.qsh.eul);
      if (paramd == null) {
        break;
      }
    }
    label114:
    AppMethodBeat.o(318766);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.appidABTest.b
 * JD-Core Version:    0.7.0.1
 */