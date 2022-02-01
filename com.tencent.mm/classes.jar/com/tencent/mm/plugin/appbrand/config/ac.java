package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/WxaDevExtJsonInfoUtils;", "", "()V", "parseDevVersionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "", "data-model_release"})
public final class ac
{
  public static final ac obV;
  
  static
  {
    AppMethodBeat.i(179493);
    obV = new ac();
    AppMethodBeat.o(179493);
  }
  
  public static final WxaAttributes.WxaVersionInfo afy(String paramString)
  {
    AppMethodBeat.i(179492);
    for (;;)
    {
      boolean bool;
      try
      {
        localObject = (CharSequence)paramString;
        if (localObject == null) {
          break label199;
        }
        if (((CharSequence)localObject).length() != 0) {
          break label204;
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
      localWxaVersionInfo.appVersion = 0;
      localWxaVersionInfo.moduleList = WxaAttributes.WxaVersionModuleInfo.afw(((JSONObject)localObject).optString("module_list"));
      localWxaVersionInfo.mcN = WxaAttributes.WxaWidgetInfo.afx(((JSONObject)localObject).optString("widget_list"));
      if (!Util.isNullOrNil(localWxaVersionInfo.moduleList))
      {
        bool = true;
        localWxaVersionInfo.obD = bool;
        if (localWxaVersionInfo.obD)
        {
          paramString = ((JSONObject)localObject).optString("entrance_module");
          localWxaVersionInfo.obE = paramString;
          localWxaVersionInfo.obB = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionInfo.mcN, ((JSONObject)localObject).optString("separated_plugin_list"), 22);
          localWxaVersionInfo.obF = ((JSONObject)localObject).optString("client_js_ext_info");
          localWxaVersionInfo.obz = ((JSONObject)localObject).optString("device_orientation");
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
      label199:
      int i = 1;
      continue;
      label204:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.ac
 * JD-Core Version:    0.7.0.1
 */