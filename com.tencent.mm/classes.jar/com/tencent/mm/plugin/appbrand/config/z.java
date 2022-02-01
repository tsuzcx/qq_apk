package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/config/WxaDevExtJsonInfoUtils;", "", "()V", "parseDevVersionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "", "data-model_release"})
public final class z
{
  public static final z kaq;
  
  static
  {
    AppMethodBeat.i(179493);
    kaq = new z();
    AppMethodBeat.o(179493);
  }
  
  public static final WxaAttributes.WxaVersionInfo NU(String paramString)
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
      localWxaVersionInfo.moduleList = WxaAttributes.WxaVersionModuleInfo.NS(((JSONObject)localObject).optString("module_list"));
      localWxaVersionInfo.ioH = WxaAttributes.WxaWidgetInfo.NT(((JSONObject)localObject).optString("widget_list"));
      if (!bt.hj(localWxaVersionInfo.moduleList))
      {
        bool = true;
        localWxaVersionInfo.kab = bool;
        if (localWxaVersionInfo.kab)
        {
          paramString = ((JSONObject)localObject).optString("entrance_module");
          localWxaVersionInfo.kac = paramString;
          localWxaVersionInfo.jZZ = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionInfo.ioH, ((JSONObject)localObject).optString("separated_plugin_list"), 22);
          localWxaVersionInfo.kad = ((JSONObject)localObject).optString("client_js_ext_info");
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