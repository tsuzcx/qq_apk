package com.tencent.mm.plugin.appbrand.permission.appidABTest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static String TAG = "MicroMsg.AppBrandPermission.AppidABTestConfig";
  private static int qAc = 1;
  private static int qAd = 0;
  
  public static final boolean o(com.tencent.luggage.sdk.e.d paramd)
  {
    AppMethodBeat.i(243985);
    if (paramd == null) {
      Log.i(TAG, "fail:runtime is nil");
    }
    for (paramd = null;; paramd = paramd.qAa)
    {
      if ((paramd == null) || (paramd.length <= b.a.qAg.qAh) || (paramd[b.a.qAg.qAh] != qAc)) {
        break label114;
      }
      AppMethodBeat.o(243985);
      return true;
      com.tencent.mm.plugin.appbrand.permission.d locald = paramd.cCQ;
      if (locald == null)
      {
        Log.e(TAG, "NULL permissionController with appId:%s", new Object[] { paramd.mAppId });
        break;
      }
      paramd = locald.cC(paramd.mAppId, paramd.ntz.cBI);
      if (paramd == null) {
        break;
      }
    }
    label114:
    AppMethodBeat.o(243985);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.appidABTest.b
 * JD-Core Version:    0.7.0.1
 */