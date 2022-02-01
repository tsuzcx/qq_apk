package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/config/WxaDevExtJsonInfoUtils;", "", "()V", "parseDevVersionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "", "data-model_release"})
public final class y
{
  public static final y jfS;
  
  static
  {
    AppMethodBeat.i(179493);
    jfS = new y();
    AppMethodBeat.o(179493);
  }
  
  public static final WxaAttributes.WxaVersionInfo Gx(String paramString)
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
      localWxaVersionInfo.aAS = 0;
      localWxaVersionInfo.moduleList = WxaAttributes.WxaVersionModuleInfo.Gv(((JSONObject)localObject).optString("module_list"));
      localWxaVersionInfo.huK = WxaAttributes.WxaWidgetInfo.Gw(((JSONObject)localObject).optString("widget_list"));
      if (!bt.gL(localWxaVersionInfo.moduleList))
      {
        bool = true;
        localWxaVersionInfo.jfD = bool;
        if (localWxaVersionInfo.jfD)
        {
          paramString = ((JSONObject)localObject).optString("entrance_module");
          localWxaVersionInfo.jfE = paramString;
          localWxaVersionInfo.jfB = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionInfo.huK, ((JSONObject)localObject).optString("separated_plugin_list"), 22);
          localWxaVersionInfo.jfF = ((JSONObject)localObject).optString("client_js_ext_info");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.y
 * JD-Core Version:    0.7.0.1
 */