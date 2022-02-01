package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public final class j
  implements p
{
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(44951);
    if (paramMap != null)
    {
      paramString = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.AppID");
      parama = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.UserName");
      String str1 = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.Path");
      Object localObject = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.URL");
      String str2 = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.MD5");
      paramMap = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.ExtInfo");
      ac.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "onNewXmlReceived appId %s, userName %s, path %s, url %s, md5 %s, extInfo %s", new Object[] { paramString, parama, str1, localObject, str2, paramMap });
      if ((bs.isNullOrNil(paramString)) || (bs.isNullOrNil(parama)) || (bs.isNullOrNil((String)localObject)))
      {
        ac.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "appId = %s, username = %s, codeURL = %s, invalid, return", new Object[] { paramString, parama, localObject });
        AppMethodBeat.o(44951);
        return;
      }
      if (com.tencent.mm.plugin.appbrand.app.j.aVC().a(paramString, 1, (String)localObject, str2, 0L, bs.aNx() + 7200L)) {
        f.bV(paramString, 1);
      }
      localObject = new LaunchParamsOptional();
      ((LaunchParamsOptional)localObject).hsc = paramMap;
      ((t)com.tencent.mm.plugin.appbrand.app.j.T(t.class)).s(paramString, 1, paramMap);
      paramMap = new AppBrandStatObject();
      paramMap.scene = 1101;
      paramMap.cYP = (paramString + ":" + parama);
      AppBrandLaunchProxyUI.a(ai.getContext(), parama, str1, 1, -1, paramMap, null, (LaunchParamsOptional)localObject);
    }
    AppMethodBeat.o(44951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.j
 * JD-Core Version:    0.7.0.1
 */