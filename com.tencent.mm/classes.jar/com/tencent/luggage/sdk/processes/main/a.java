package com.tencent.luggage.sdk.processes.main;

import android.util.Log;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"bundleRuntimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "luggage-wechat-full-sdk_release"})
public final class a
{
  public static final RuntimeInfo d(d paramd)
  {
    AppMethodBeat.i(245732);
    p.k(paramd, "runtime");
    int i = paramd.Sk().cxa;
    String str1 = paramd.getAppId();
    p.j(str1, "runtime.appId");
    int j = paramd.bBV();
    Object localObject1 = paramd.Sk();
    p.j(localObject1, "runtime.initConfig");
    boolean bool1 = ((AppBrandInitConfigLU)localObject1).Qv();
    int k = paramd.Sk().cwR;
    localObject1 = paramd.Sk();
    p.j(localObject1, "runtime.initConfig");
    localObject1 = ((AppBrandInitConfigLU)localObject1).Qx();
    p.j(localObject1, "runtime.initConfig.wxaLaunchInstanceId");
    String str2 = paramd.Sk().username;
    p.j(str2, "runtime.initConfig.username");
    Object localObject2 = paramd.Sk();
    p.j(localObject2, "runtime.initConfig");
    localObject2 = (AppBrandInitConfig)localObject2;
    boolean bool2 = paramd.Sk().cxb;
    if (BuildInfo.DEBUG) {}
    for (paramd = Log.getStackTraceString(new Throwable());; paramd = "debug use only")
    {
      p.j(paramd, "if (BuildInfo.DEBUG) {\n …debug use only\"\n        }");
      paramd = new RuntimeInfo(i, str1, j, bool1, k + 1000, (String)localObject1, str2, (AppBrandInitConfig)localObject2, bool2, paramd);
      AppMethodBeat.o(245732);
      return paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.a
 * JD-Core Version:    0.7.0.1
 */