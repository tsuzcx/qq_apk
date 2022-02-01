package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiOpenBizProfile;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  private static final int CTRL_INDEX = 560;
  private static final String NAME = "openBizProfile";
  public static final a kHV;
  
  static
  {
    AppMethodBeat.i(50637);
    kHV = new a((byte)0);
    NAME = "openBizProfile";
    CTRL_INDEX = 560;
    AppMethodBeat.o(50637);
  }
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(50636);
    k.h(paramc, "env");
    k.h(paramJSONObject, "data");
    Object localObject = paramJSONObject.optString("username");
    final int i = paramJSONObject.optInt("scene", 122);
    final String str = paramJSONObject.optString("profileReportInfo");
    if (bs.isNullOrNil((String)localObject))
    {
      paramc.h(paramInt, LM("fail:invalid data"));
      AppMethodBeat.o(50636);
      return;
    }
    paramJSONObject = new ProfileRequest();
    paramJSONObject.username = ((String)localObject);
    paramJSONObject.scene = i;
    localObject = (AppBrandProxyUIProcessTask.b)new b(this, paramc, paramInt, str, i, (String)localObject);
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramc.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)paramJSONObject, (AppBrandProxyUIProcessTask.b)localObject);
    AppMethodBeat.o(50636);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiOpenBizProfile$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "NAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<ProfileResult>
  {
    b(a parama, c paramc, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.a
 * JD-Core Version:    0.7.0.1
 */