package com.tencent.luggage.sdk.processes.main;

import android.util.Log;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"bundleRuntimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "luggage-wechat-full-sdk_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final RuntimeInfo d(d paramd)
  {
    AppMethodBeat.i(220473);
    s.u(paramd, "runtime");
    int i = paramd.asA().epc;
    String str1 = paramd.mAppId;
    s.s(str1, "runtime.appId");
    int j = paramd.qsh.eul;
    boolean bool1 = paramd.asA().aqJ();
    int k = paramd.asA().appServiceType;
    String str2 = paramd.asA().eoQ;
    s.s(str2, "runtime.initConfig.wxaLaunchInstanceId");
    String str3 = paramd.asA().username;
    s.s(str3, "runtime.initConfig.username");
    Object localObject = paramd.asA();
    s.s(localObject, "runtime.initConfig");
    localObject = (AppBrandInitConfig)localObject;
    boolean bool2 = paramd.asA().epd;
    if (BuildInfo.DEBUG) {}
    for (paramd = Log.getStackTraceString(new Throwable());; paramd = "debug use only")
    {
      s.s(paramd, "if (BuildInfo.DEBUG) {\n …debug use only\"\n        }");
      paramd = new RuntimeInfo(i, str1, j, bool1, k + 1000, str2, str3, (AppBrandInitConfig)localObject, bool2, paramd);
      AppMethodBeat.o(220473);
      return paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.a
 * JD-Core Version:    0.7.0.1
 */