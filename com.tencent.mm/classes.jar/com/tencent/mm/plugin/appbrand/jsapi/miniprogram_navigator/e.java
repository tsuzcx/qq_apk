package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/JsApiLaunchDevMiniProgram;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/JsApiLaunchMiniProgram;", "()V", "dispatchInJsThread", "", "onNavigationWillPerform", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends f
{
  public static final int CTRL_INDEX = 967;
  public static final String NAME = "launchDevMiniProgram";
  public static final e.a pcM;
  
  static
  {
    AppMethodBeat.i(265418);
    pcM = new e.a((byte)0);
    AppMethodBeat.o(265418);
  }
  
  protected final boolean a(d paramd, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(265417);
    p.k(paramd, "service");
    p.k(paramJSONObject, "data");
    String str1 = paramJSONObject.optString("appId");
    Object localObject = b.a(paramJSONObject.optString("envVersion"), b.pcD);
    String str2 = paramJSONObject.optString("downloadURL");
    String str3 = paramJSONObject.optString("checkSumMd5");
    paramJSONObject = paramJSONObject.optString("extoptions");
    if (b.pcE == localObject)
    {
      localObject = (CharSequence)str3;
      int i;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0)
        {
          localObject = new JsApiNavigateToDevMiniProgram.DevPkgInfo();
          ((JsApiNavigateToDevMiniProgram.DevPkgInfo)localObject).appId = str1;
          ((JsApiNavigateToDevMiniProgram.DevPkgInfo)localObject).fWS = str2;
          ((JsApiNavigateToDevMiniProgram.DevPkgInfo)localObject).fWT = str3;
          ((JsApiNavigateToDevMiniProgram.DevPkgInfo)localObject).pcT = paramJSONObject;
          try
          {
            paramJSONObject = (IPCVoid)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localObject, JsApiNavigateToDevMiniProgram.a.class);
            if (paramJSONObject != null)
            {
              i = 1;
              if (i != 0) {
                break label225;
              }
              paramd.j(paramInt, "fail save packageInfo failed");
              AppMethodBeat.o(265417);
              return false;
              i = 0;
            }
          }
          catch (Exception paramJSONObject)
          {
            for (;;)
            {
              Log.e("MicroMsg.AppBrand.JsApiLaunchDevMiniProgram", "invoke IPCFlushDevPkg, parcel:" + localObject + ", exception:" + paramJSONObject);
              paramJSONObject = null;
              continue;
              i = 0;
            }
          }
        }
      }
    }
    label225:
    AppMethodBeat.o(265417);
    return true;
  }
  
  public final boolean bPy()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e
 * JD-Core Version:    0.7.0.1
 */