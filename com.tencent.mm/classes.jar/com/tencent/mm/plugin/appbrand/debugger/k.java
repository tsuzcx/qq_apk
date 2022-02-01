package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class k
  implements q
{
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, h.a parama)
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
      Log.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "onNewXmlReceived appId %s, userName %s, path %s, url %s, md5 %s, extInfo %s", new Object[] { paramString, parama, str1, localObject, str2, paramMap });
      if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(parama)) || (Util.isNullOrNil((String)localObject)))
      {
        Log.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "appId = %s, username = %s, codeURL = %s, invalid, return", new Object[] { paramString, parama, localObject });
        AppMethodBeat.o(44951);
        return;
      }
      if (n.buL().a(paramString, 1, (String)localObject, str2, 0L, Util.nowSecond() + 7200L)) {
        h.bWb().cl(paramString, 1);
      }
      localObject = new LaunchParamsOptional();
      ((LaunchParamsOptional)localObject).iIt = paramMap;
      ((t)n.W(t.class)).A(paramString, 1, paramMap);
      paramMap = new AppBrandStatObject();
      paramMap.scene = 1101;
      paramMap.dCw = (paramString + ":" + parama);
      AppBrandLaunchProxyUI.a(MMApplicationContext.getContext(), parama, str1, 1, -1, paramMap, (LaunchParamsOptional)localObject);
    }
    AppMethodBeat.o(44951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.k
 * JD-Core Version:    0.7.0.1
 */