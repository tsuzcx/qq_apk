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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/JsApiLaunchDevMiniProgram;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/JsApiLaunchMiniProgram;", "()V", "dispatchInJsThread", "", "onNavigationWillPerform", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends f
{
  public static final int CTRL_INDEX = 967;
  public static final String NAME = "launchDevMiniProgram";
  public static final a meQ;
  
  static
  {
    AppMethodBeat.i(228429);
    meQ = new a((byte)0);
    AppMethodBeat.o(228429);
  }
  
  protected final boolean a(d paramd, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(228428);
    p.h(paramd, "service");
    p.h(paramJSONObject, "data");
    String str1 = paramJSONObject.optString("appId");
    Object localObject = b.a(paramJSONObject.optString("envVersion"), b.meL);
    String str2 = paramJSONObject.optString("downloadURL");
    String str3 = paramJSONObject.optString("checkSumMd5");
    paramJSONObject = paramJSONObject.optString("extoptions");
    if (b.meM == localObject)
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
          ((JsApiNavigateToDevMiniProgram.DevPkgInfo)localObject).ecN = str2;
          ((JsApiNavigateToDevMiniProgram.DevPkgInfo)localObject).ecO = str3;
          ((JsApiNavigateToDevMiniProgram.DevPkgInfo)localObject).meX = paramJSONObject;
          try
          {
            paramJSONObject = (IPCVoid)XIPCInvoker.a(MainProcessIPCService.dkO, localObject, JsApiNavigateToDevMiniProgram.a.class);
            if (paramJSONObject != null)
            {
              i = 1;
              if (i != 0) {
                break label225;
              }
              paramd.i(paramInt, "fail save packageInfo failed");
              AppMethodBeat.o(228428);
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
    AppMethodBeat.o(228428);
    return true;
  }
  
  public final boolean bEa()
  {
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/JsApiLaunchDevMiniProgram$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e
 * JD-Core Version:    0.7.0.1
 */