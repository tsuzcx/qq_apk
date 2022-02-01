package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.luggage.sdk.b.a.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/JsApiLaunchDevMiniProgram;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/JsApiLaunchMiniProgram;", "()V", "dispatchInJsThread", "", "onNavigationWillPerform", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends f
{
  public static final int CTRL_INDEX = 967;
  public static final String NAME = "launchDevMiniProgram";
  public static final a sib;
  
  static
  {
    AppMethodBeat.i(326199);
    sib = new a((byte)0);
    AppMethodBeat.o(326199);
  }
  
  protected final boolean a(d paramd, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(326204);
    s.u(paramd, "service");
    s.u(paramJSONObject, "data");
    String str1 = paramJSONObject.optString("appId");
    Object localObject = b.a(paramJSONObject.optString("envVersion"), b.shS);
    String str2 = paramJSONObject.optString("downloadURL");
    String str3 = paramJSONObject.optString("checkSumMd5");
    paramJSONObject = paramJSONObject.optString("extoptions");
    if (b.shT == localObject)
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
          ((JsApiNavigateToDevMiniProgram.DevPkgInfo)localObject).icR = str2;
          ((JsApiNavigateToDevMiniProgram.DevPkgInfo)localObject).icS = str3;
          ((JsApiNavigateToDevMiniProgram.DevPkgInfo)localObject).sij = paramJSONObject;
          try
          {
            paramJSONObject = (IPCVoid)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localObject, JsApiNavigateToDevMiniProgram.a.class);
            if (paramJSONObject != null)
            {
              i = 1;
              if (i != 0) {
                break label225;
              }
              paramd.callback(paramInt, "fail save packageInfo failed");
              AppMethodBeat.o(326204);
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
    AppMethodBeat.o(326204);
    return true;
  }
  
  public final boolean cpE()
  {
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/JsApiLaunchDevMiniProgram$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e
 * JD-Core Version:    0.7.0.1
 */