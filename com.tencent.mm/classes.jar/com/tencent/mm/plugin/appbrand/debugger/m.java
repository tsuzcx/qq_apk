package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.b.p;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.config.aj;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.at;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class m
  implements com.tencent.mm.plugin.messenger.foundation.a.t
{
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(44951);
    if (paramMap != null)
    {
      paramString = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.AppID");
      parama = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.UserName");
      String str = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.Path");
      Object localObject2 = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.URL");
      Object localObject3 = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.MD5");
      Object localObject1 = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.ExtInfo");
      Object localObject4 = (String)paramMap.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.WsEndpoint");
      Log.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "onNewXmlReceived appId %s, userName %s, path %s, url %s, md5 %s, extInfo %s, wsEndpoint:%s", new Object[] { paramString, parama, str, localObject2, localObject3, localObject1, localObject4 });
      if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(parama)) || (Util.isNullOrNil((String)localObject2)))
      {
        Log.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "appId = %s, username = %s, codeURL = %s, invalid, return", new Object[] { paramString, parama, localObject2 });
        AppMethodBeat.o(44951);
        return;
      }
      if (n.cfm().a(paramString, 1, (String)localObject2, (String)localObject3, 0L, Util.nowSecond() + 7200L)) {
        i.cJV().F(paramString, 1);
      }
      paramMap = new LaunchParamsOptional();
      paramMap.opW = ((String)localObject1);
      paramMap.eoY = ((String)localObject4);
      ((com.tencent.mm.plugin.appbrand.launching.t)n.ag(com.tencent.mm.plugin.appbrand.launching.t.class)).D(paramString, 1, (String)localObject1);
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject2 = aj.Ya((String)localObject1);
        localObject1 = ((WxaAttributes.WxaVersionInfo)localObject2).rco;
        localObject2 = ((WxaAttributes.WxaVersionInfo)localObject2).moduleList;
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          localObject1 = ((List)localObject2).iterator();
        }
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WxaAttributes.WxaVersionModuleInfo)((Iterator)localObject1).next();
          if ((((WxaAttributes.WxaVersionModuleInfo)localObject2).rcC != null) && (((WxaAttributes.WxaVersionModuleInfo)localObject2).rcC.size() > 0))
          {
            localObject3 = ((WxaAttributes.WxaVersionModuleInfo)localObject2).rcC.iterator();
            boolean bool;
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject3).next();
              if (!Util.isNullOrNil(((WxaAttributes.WxaPluginCodeInfo)localObject4).qGf))
              {
                bool = ((at)n.ag(at.class)).j(((WxaAttributes.WxaPluginCodeInfo)localObject4).provider, ((WxaAttributes.WxaPluginCodeInfo)localObject4).qGf, ((WxaAttributes.WxaPluginCodeInfo)localObject4).rci);
                Log.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "start: module :%s dev plugin provider:%s,versionDesc:%s,devUin:%d saveRet:%b", new Object[] { ((WxaAttributes.WxaVersionModuleInfo)localObject2).name, ((WxaAttributes.WxaPluginCodeInfo)localObject4).provider, ((WxaAttributes.WxaPluginCodeInfo)localObject4).qGf, Integer.valueOf(new p(((WxaAttributes.WxaPluginCodeInfo)localObject4).rci).intValue()), Boolean.valueOf(bool) });
              }
            }
            continue;
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject1).next();
                if (!Util.isNullOrNil(((WxaAttributes.WxaPluginCodeInfo)localObject2).qGf))
                {
                  bool = ((at)n.ag(at.class)).j(((WxaAttributes.WxaPluginCodeInfo)localObject2).provider, ((WxaAttributes.WxaPluginCodeInfo)localObject2).qGf, ((WxaAttributes.WxaPluginCodeInfo)localObject2).rci);
                  Log.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "start: dev plugin provider:%s,versionDesc:%s,devUin:%d saveRet:%b", new Object[] { ((WxaAttributes.WxaPluginCodeInfo)localObject2).provider, ((WxaAttributes.WxaPluginCodeInfo)localObject2).qGf, Integer.valueOf(new p(((WxaAttributes.WxaPluginCodeInfo)localObject2).rci).intValue()), Boolean.valueOf(bool) });
                }
              }
            }
          }
        }
      }
      localObject1 = new AppBrandStatObject();
      ((AppBrandStatObject)localObject1).scene = 1101;
      ((AppBrandStatObject)localObject1).hzx = (paramString + ":" + parama);
      AppBrandLaunchProxyUI.a(MMApplicationContext.getContext(), parama, str, 1, -1, (AppBrandStatObject)localObject1, paramMap);
    }
    AppMethodBeat.o(44951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.m
 * JD-Core Version:    0.7.0.1
 */