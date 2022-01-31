package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class h
  implements o
{
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    String str1;
    String str2;
    if (paramMap != null)
    {
      paramString = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.AppID");
      parama = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.UserName");
      str1 = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.Path");
      localObject = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.URL");
      str2 = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.MD5");
      paramMap = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.ExtInfo");
      y.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "onNewXmlReceived appId %s, userName %s, path %s, url %s, md5 %s, extInfo %s", new Object[] { paramString, parama, str1, localObject, str2, paramMap });
      if ((bk.bl(paramString)) || (bk.bl(parama)) || (bk.bl((String)localObject))) {
        y.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "appId = %s, username = %s, codeURL = %s, invalid, return", new Object[] { paramString, parama, localObject });
      }
    }
    else
    {
      return;
    }
    if (e.abb().a(paramString, 1, (String)localObject, str2, 0L, bk.UX() + 7200L)) {
      g.aZ(paramString, 1);
    }
    Object localObject = new LaunchParamsOptional();
    ((LaunchParamsOptional)localObject).dZO = paramMap;
    ((com.tencent.mm.plugin.appbrand.launching.h)e.G(com.tencent.mm.plugin.appbrand.launching.h.class)).l(paramString, 1, paramMap);
    paramMap = new AppBrandStatObject();
    paramMap.scene = 1101;
    paramMap.bFv = (paramString + ":" + parama);
    AppBrandLaunchProxyUI.a(ae.getContext(), parama, str1, 1, -1, paramMap, null, (LaunchParamsOptional)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.h
 * JD-Core Version:    0.7.0.1
 */