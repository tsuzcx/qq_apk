package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/config/WxaDevExtJsonInfoUtils;", "", "()V", "parseDevVersionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "", "data-model_release"})
public final class z
{
  public static final z kdH;
  
  static
  {
    AppMethodBeat.i(179493);
    kdH = new z();
    AppMethodBeat.o(179493);
  }
  
  public static final WxaAttributes.WxaVersionInfo OB(String paramString)
  {
    AppMethodBeat.i(179492);
    for (;;)
    {
      boolean bool;
      try
      {
        localObject = (CharSequence)paramString;
        if (localObject == null) {
          break label188;
        }
        if (((CharSequence)localObject).length() != 0) {
          break label193;
        }
      }
      catch (JSONException paramString)
      {
        Object localObject;
        WxaAttributes.WxaVersionInfo localWxaVersionInfo;
        AppMethodBeat.o(179492);
        return null;
      }
      if (i != 0)
      {
        AppMethodBeat.o(179492);
        return null;
      }
      localObject = new JSONObject(paramString);
      localWxaVersionInfo = new WxaAttributes.WxaVersionInfo();
      localWxaVersionInfo.aDD = 0;
      localWxaVersionInfo.moduleList = WxaAttributes.WxaVersionModuleInfo.Oz(((JSONObject)localObject).optString("module_list"));
      localWxaVersionInfo.irC = WxaAttributes.WxaWidgetInfo.OA(((JSONObject)localObject).optString("widget_list"));
      if (!bu.ht(localWxaVersionInfo.moduleList))
      {
        bool = true;
        localWxaVersionInfo.kds = bool;
        if (localWxaVersionInfo.kds)
        {
          paramString = ((JSONObject)localObject).optString("entrance_module");
          localWxaVersionInfo.kdt = paramString;
          localWxaVersionInfo.kdq = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionInfo.irC, ((JSONObject)localObject).optString("separated_plugin_list"), 22);
          localWxaVersionInfo.kdu = ((JSONObject)localObject).optString("client_js_ext_info");
          AppMethodBeat.o(179492);
          return localWxaVersionInfo;
        }
      }
      else
      {
        bool = false;
        continue;
      }
      paramString = "";
      continue;
      label188:
      int i = 1;
      continue;
      label193:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.z
 * JD-Core Version:    0.7.0.1
 */