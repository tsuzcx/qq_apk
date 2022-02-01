package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.config.s.c;
import com.tencent.mm.plugin.appbrand.ipc.f;
import com.tencent.mm.protocal.protobuf.fxf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.Map;

final class bj$a
  implements bj.c
{
  public final void k(final String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(320241);
    if (paramMap.get(".sysmsg.mmbizwxaconfig") == null)
    {
      AppMethodBeat.o(320241);
      return;
    }
    int i = Util.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.command"), -1);
    final int j = Util.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.type"), 0);
    paramString = (String)paramMap.get(".sysmsg.mmbizwxaconfig.appid");
    int k = Util.getInt((String)paramMap.get(".sysmsg.mmbizwxaconfig.configversion"), 0);
    Log.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle common config, command = %d, type = %d, appid = %s, configversion = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString, Integer.valueOf(k) });
    paramMap = new LinkedList();
    fxf localfxf = new fxf();
    localfxf.version = k;
    localfxf.type = j;
    paramMap.add(localfxf);
    s.a(paramString, paramMap, false);
    s.a(paramString, j, i, new s.c()
    {
      public final void Vv(String paramAnonymousString)
      {
        AppMethodBeat.i(44358);
        Log.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "CommonConfigManager.getConfig config:%s", new Object[] { paramAnonymousString });
        f.z(paramString, j, paramAnonymousString);
        AppMethodBeat.o(44358);
      }
    }, true);
    AppMethodBeat.o(320241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bj.a
 * JD-Core Version:    0.7.0.1
 */