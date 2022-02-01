package com.tencent.mm.plugin.appbrand.jsapi.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiProfile;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  private static final int CTRL_INDEX = 508;
  private static final String NAME = "profile";
  public static final c.a plK;
  
  static
  {
    AppMethodBeat.i(50643);
    plK = new c.a((byte)0);
    NAME = "profile";
    CTRL_INDEX = 508;
    AppMethodBeat.o(50643);
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(50642);
    p.k(parame, "env");
    p.k(paramJSONObject, "data");
    Object localObject = paramJSONObject.optString("username");
    final int i = paramJSONObject.optInt("scene", 122);
    final String str1 = paramJSONObject.optString("profileReportInfo");
    final String str2 = paramJSONObject.optString("tabType");
    if (Util.isNullOrNil((String)localObject))
    {
      parame.j(paramInt, agS("fail:invalid data"));
      AppMethodBeat.o(50642);
      return;
    }
    paramJSONObject = new ProfileRequest();
    paramJSONObject.username = ((String)localObject);
    paramJSONObject.scene = i;
    localObject = (AppBrandProxyUIProcessTask.b)new b(this, parame, paramInt, str1, i, str2, (String)localObject);
    a.a(parame.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)paramJSONObject, (AppBrandProxyUIProcessTask.b)localObject);
    AppMethodBeat.o(50642);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<ProfileResult>
  {
    b(c paramc, e parame, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.c
 * JD-Core Version:    0.7.0.1
 */