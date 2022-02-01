package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public final class k
  implements q
{
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
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
      ae.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "onNewXmlReceived appId %s, userName %s, path %s, url %s, md5 %s, extInfo %s", new Object[] { paramString, parama, str1, localObject, str2, paramMap });
      if ((bu.isNullOrNil(paramString)) || (bu.isNullOrNil(parama)) || (bu.isNullOrNil((String)localObject)))
      {
        ae.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "appId = %s, username = %s, codeURL = %s, invalid, return", new Object[] { paramString, parama, localObject });
        AppMethodBeat.o(44951);
        return;
      }
      if (j.aZu().a(paramString, 1, (String)localObject, str2, 0L, bu.aRi() + 7200L)) {
        f.cc(paramString, 1);
      }
      localObject = new LaunchParamsOptional();
      ((LaunchParamsOptional)localObject).hNn = paramMap;
      ((t)j.T(t.class)).v(paramString, 1, paramMap);
      paramMap = new AppBrandStatObject();
      paramMap.scene = 1101;
      paramMap.dlj = (paramString + ":" + parama);
      AppBrandLaunchProxyUI.a(ak.getContext(), parama, str1, 1, -1, paramMap, (LaunchParamsOptional)localObject);
    }
    AppMethodBeat.o(44951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.k
 * JD-Core Version:    0.7.0.1
 */