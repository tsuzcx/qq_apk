package com.tencent.luggage.sdk.config;

import android.util.ArrayMap;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap.c.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/config/AppBrandRuntimePluginInfoConfig;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandConfig;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "call_plugin_info", "Lorg/json/JSONArray;", "getPluginInnerVersion", "", "appId", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements m
{
  private static final c.a epv;
  private final d epw;
  private JSONArray epx;
  
  static
  {
    AppMethodBeat.i(220249);
    epv = new c.a((byte)0);
    AppMethodBeat.o(220249);
  }
  
  public c(d paramd)
  {
    AppMethodBeat.i(220245);
    this.epw = paramd;
    AppMethodBeat.o(220245);
  }
  
  public final int fm(String paramString)
  {
    AppMethodBeat.i(220254);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(220254);
      return 0;
    }
    localObject1 = this.epw.asz();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((AppBrandSysConfigLU)localObject1).qYY;
      if (localObject1 != null)
      {
        localObject1 = ((WxaPkgWrappingInfo)localObject1).qHT;
        if (localObject1 != null)
        {
          s.u(paramString, "pluginId");
          localObject2 = ((WxaRuntimeModulePluginListMap)localObject1).qId;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("mSecondaryMap");
            localObject1 = null;
          }
          localObject1 = (LinkedList)((ArrayMap)localObject1).get(new WxaRuntimeModulePluginListMap.c.b(paramString));
          if (localObject1 == null) {}
          for (localObject1 = null; localObject1 != null; localObject1 = (WxaPluginPkgInfo)p.oL((List)localObject1))
          {
            i = ((WxaPluginPkgInfo)localObject1).pkgVersion();
            AppMethodBeat.o(220254);
            return i;
          }
        }
      }
    }
    int k;
    if (this.epx == null)
    {
      localObject1 = this.epw.asA().epa.rcs;
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label343;
        }
        localObject1 = new JSONArray();
        this.epx = ((JSONArray)localObject1);
      }
    }
    else
    {
      localObject2 = this.epx;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("call_plugin_info");
        localObject1 = null;
      }
      k = ((JSONArray)localObject1).length();
      if (k <= 0) {
        break label415;
      }
    }
    int j;
    for (i = 0;; i = j)
    {
      for (;;)
      {
        j = i + 1;
        localObject2 = this.epx;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("call_plugin_info");
          localObject1 = null;
        }
        localObject1 = ((JSONArray)localObject1).optJSONObject(i);
        if (s.p(paramString, ((JSONObject)localObject1).optString("plugin_id")))
        {
          i = ((JSONObject)localObject1).optInt("inner_version");
          AppMethodBeat.o(220254);
          return i;
          i = 0;
          break;
          try
          {
            label343:
            localObject1 = new JSONObject((String)localObject1).optJSONArray("call_plugin_info");
            s.s(localObject1, "{\n                try {\n…          }\n            }");
          }
          catch (JSONException localJSONException)
          {
            Log.e("MicroMsg.AppBrandRuntimePluginInfoConfig", "getPluginInnerVersion(appId:" + paramString + ") parse call_plugin_info get exception:" + localJSONException);
            AppMethodBeat.o(220254);
            return 0;
          }
        }
      }
      if (j >= k)
      {
        label415:
        AppMethodBeat.o(220254);
        return 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.c
 * JD-Core Version:    0.7.0.1
 */