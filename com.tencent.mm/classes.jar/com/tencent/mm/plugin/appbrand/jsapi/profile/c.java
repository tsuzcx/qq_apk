package com.tencent.mm.plugin.appbrand.jsapi.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiProfile;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  private static final int CTRL_INDEX = 508;
  private static final String NAME = "profile";
  public static final a lev;
  
  static
  {
    AppMethodBeat.i(50643);
    lev = new a((byte)0);
    NAME = "profile";
    CTRL_INDEX = 508;
    AppMethodBeat.o(50643);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(50642);
    p.h(paramc, "env");
    p.h(paramJSONObject, "data");
    Object localObject = paramJSONObject.optString("username");
    final int i = paramJSONObject.optInt("scene", 122);
    final String str = paramJSONObject.optString("profileReportInfo");
    if (bt.isNullOrNil((String)localObject))
    {
      paramc.h(paramInt, Pg("fail:invalid data"));
      AppMethodBeat.o(50642);
      return;
    }
    paramJSONObject = new ProfileRequest();
    paramJSONObject.username = ((String)localObject);
    paramJSONObject.scene = i;
    localObject = (AppBrandProxyUIProcessTask.b)new b(this, paramc, paramInt, str, i, (String)localObject);
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramc.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)paramJSONObject, (AppBrandProxyUIProcessTask.b)localObject);
    AppMethodBeat.o(50642);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiProfile$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "NAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<ProfileResult>
  {
    b(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.c
 * JD-Core Version:    0.7.0.1
 */