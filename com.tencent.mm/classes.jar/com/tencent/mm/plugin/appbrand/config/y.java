package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/config/WxaDevExtJsonInfoUtils;", "", "()V", "parseDevVersionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "", "data-model_release"})
public final class y
{
  public static final y jGh;
  
  static
  {
    AppMethodBeat.i(179493);
    jGh = new y();
    AppMethodBeat.o(179493);
  }
  
  public static final WxaAttributes.WxaVersionInfo KB(String paramString)
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
      localWxaVersionInfo.aBM = 0;
      localWxaVersionInfo.moduleList = WxaAttributes.WxaVersionModuleInfo.Kz(((JSONObject)localObject).optString("module_list"));
      localWxaVersionInfo.hVm = WxaAttributes.WxaWidgetInfo.KA(((JSONObject)localObject).optString("widget_list"));
      if (!bs.gY(localWxaVersionInfo.moduleList))
      {
        bool = true;
        localWxaVersionInfo.jFS = bool;
        if (localWxaVersionInfo.jFS)
        {
          paramString = ((JSONObject)localObject).optString("entrance_module");
          localWxaVersionInfo.jFT = paramString;
          localWxaVersionInfo.jFQ = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionInfo.hVm, ((JSONObject)localObject).optString("separated_plugin_list"), 22);
          localWxaVersionInfo.jFU = ((JSONObject)localObject).optString("client_js_ext_info");
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.y
 * JD-Core Version:    0.7.0.1
 */