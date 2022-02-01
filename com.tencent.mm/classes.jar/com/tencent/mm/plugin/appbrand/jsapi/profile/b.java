package com.tencent.mm.plugin.appbrand.jsapi.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiOpenUserProfile;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  private static final int CTRL_INDEX = 559;
  private static final String NAME = "openUserProfile";
  public static final b.a khi;
  
  static
  {
    AppMethodBeat.i(50640);
    khi = new b.a((byte)0);
    NAME = "openUserProfile";
    CTRL_INDEX = 559;
    AppMethodBeat.o(50640);
  }
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(50639);
    k.h(paramc, "env");
    k.h(paramJSONObject, "data");
    Object localObject = paramJSONObject.optString("username");
    int i = paramJSONObject.optInt("scene", 122);
    final String str = paramJSONObject.optString("profileReportInfo");
    if (bt.isNullOrNil((String)localObject))
    {
      paramc.h(paramInt, HI("fail:invalid data"));
      AppMethodBeat.o(50639);
      return;
    }
    paramJSONObject = new ProfileRequest();
    paramJSONObject.username = ((String)localObject);
    paramJSONObject.scene = i;
    localObject = (AppBrandProxyUIProcessTask.b)new b(this, paramc, paramInt, str, (String)localObject);
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramc.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)paramJSONObject, (AppBrandProxyUIProcessTask.b)localObject);
    AppMethodBeat.o(50639);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<ProfileResult>
  {
    b(b paramb, c paramc, int paramInt, String paramString1, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.b
 * JD-Core Version:    0.7.0.1
 */