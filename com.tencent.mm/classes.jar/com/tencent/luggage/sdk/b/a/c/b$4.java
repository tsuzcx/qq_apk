package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.utils.r.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import d.g.b.p;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class b$4
  implements Runnable
{
  b$4(b paramb, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(192192);
    if (this.coL.coF) {
      try
      {
        localObject3 = new f(this.coO);
        com.tencent.mm.plugin.appbrand.q localq = (com.tencent.mm.plugin.appbrand.q)Objects.requireNonNull(this.coL.El());
        p.h(localq, "service");
        JSONObject localJSONObject1;
        for (;;)
        {
          try
          {
            localJSONObject1 = new JSONObject();
            localJSONObject1.put("moduleName", ((f)localObject3).coW);
            Object localObject1 = (AppBrandSysConfigLU)localq.ar(AppBrandSysConfigLU.class);
            if (localObject1 != null)
            {
              localObject1 = ((AppBrandSysConfigLU)localObject1).jYh;
              localObject1 = ((WxaPkgWrappingInfo)localObject1).jIZ;
              if (localObject1 == null) {
                break label276;
              }
              Object localObject4 = ((WxaRuntimeModulePluginListMap)localObject1).LN(((f)localObject3).coW);
              if (localObject4 == null) {
                break label276;
              }
              localObject1 = new JSONArray();
              localObject4 = ((Iterable)localObject4).iterator();
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              WxaPluginPkgInfo localWxaPluginPkgInfo = (WxaPluginPkgInfo)((Iterator)localObject4).next();
              JSONObject localJSONObject2 = new JSONObject();
              localJSONObject2.put("plugin_id", localWxaPluginPkgInfo.provider);
              localJSONObject2.put("custom_version", localWxaPluginPkgInfo.stringVersion);
              localJSONObject2.put("prefix_path", localWxaPluginPkgInfo.prefixPath);
              localJSONObject2.put("inner_version", localWxaPluginPkgInfo.version);
              ((JSONArray)localObject1).put(localJSONObject2);
              continue;
            }
            localObject2 = null;
          }
          catch (JSONException localJSONException)
          {
            ad.e(((f)localObject3).TAG, "dispatch with service(" + localq.getAppId() + "), create data failed");
            AppMethodBeat.o(192192);
            return;
          }
        }
        localJSONObject1.put("separatedPlugins", localObject2);
        label276:
        Object localObject2 = localJSONObject1.toString();
        p.g(localObject2, "try {\n            JSONOb…         return\n        }");
        ad.i(((f)localObject3).TAG, "dispatch appId(" + localq.getAppId() + ") onSubPackageReady(" + (String)localObject2 + ')');
        localq.bX("onSubPackageReady", (String)localObject2);
        AppMethodBeat.o(192192);
        return;
      }
      catch (Exception localException)
      {
        ad.e("Luggage.AppBrandMiniProgramServiceLogicImp", "loadModule using isolate context, notify but get exception %s");
        AppMethodBeat.o(192192);
        return;
      }
    }
    if ("__APP__".equals(this.coO))
    {
      b.a(this.coL);
      AppMethodBeat.o(192192);
      return;
    }
    Object localObject3 = new StringBuilder().append(this.coO);
    if (this.coO.endsWith("/")) {}
    for (String str = "";; str = "/")
    {
      str = str + "app-service.js";
      localObject3 = com.tencent.mm.vfs.q.B(bf.O(((c)this.coL.El()).En()).Lj(str).gdT.fOK());
      r.a(((c)this.coL.El()).En(), ((c)this.coL.El()).aYh(), (String)localObject3, str, "", "", r.a.mOX, new b.d(str, (c)this.coL.El(), (byte)0));
      AppMethodBeat.o(192192);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.b.4
 * JD-Core Version:    0.7.0.1
 */