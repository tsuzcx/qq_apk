package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/WxaDevExtJsonInfoUtils;", "", "()V", "parseDevVersionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "", "data-model_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
{
  public static final aj rcJ;
  
  static
  {
    AppMethodBeat.i(179493);
    rcJ = new aj();
    AppMethodBeat.o(179493);
  }
  
  public static final WxaAttributes.WxaVersionInfo Ya(String paramString)
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
      localWxaVersionInfo.moduleList = WxaAttributes.WxaVersionModuleInfo.XX(((JSONObject)localObject).optString("module_list"));
      localWxaVersionInfo.oVI = WxaAttributes.WxaWidgetInfo.XY(((JSONObject)localObject).optString("widget_list"));
      if (!Util.isNullOrNil(localWxaVersionInfo.moduleList))
      {
        bool = true;
        localWxaVersionInfo.rcq = bool;
        if (localWxaVersionInfo.rcq)
        {
          paramString = ((JSONObject)localObject).optString("entrance_module");
          localWxaVersionInfo.rcr = paramString;
          localWxaVersionInfo.rco = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionInfo.oVI, ((JSONObject)localObject).optString("separated_plugin_list"), 22);
          localWxaVersionInfo.rcs = ((JSONObject)localObject).optString("client_js_ext_info");
          localWxaVersionInfo.rcm = ((JSONObject)localObject).optString("device_orientation");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.aj
 * JD-Core Version:    0.7.0.1
 */