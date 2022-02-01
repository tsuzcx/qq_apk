package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiOpenBizProfile;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends d<f>
{
  private static final int CTRL_INDEX = 560;
  private static final String NAME = "openBizProfile";
  public static final a mny;
  
  static
  {
    AppMethodBeat.i(50637);
    mny = new a((byte)0);
    NAME = "openBizProfile";
    CTRL_INDEX = 560;
    AppMethodBeat.o(50637);
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(50636);
    p.h(paramf, "env");
    p.h(paramJSONObject, "data");
    Object localObject = paramJSONObject.optString("username");
    final int i = paramJSONObject.optInt("scene", 122);
    final String str = paramJSONObject.optString("profileReportInfo");
    if (Util.isNullOrNil((String)localObject))
    {
      paramf.i(paramInt, Zf("fail:invalid data"));
      AppMethodBeat.o(50636);
      return;
    }
    paramJSONObject = new ProfileRequest();
    paramJSONObject.username = ((String)localObject);
    paramJSONObject.scene = i;
    localObject = (AppBrandProxyUIProcessTask.b)new b(this, paramf, paramInt, str, i, (String)localObject);
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramf.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)paramJSONObject, (AppBrandProxyUIProcessTask.b)localObject);
    AppMethodBeat.o(50636);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiOpenBizProfile$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "NAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<ProfileResult>
  {
    b(a parama, f paramf, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.a
 * JD-Core Version:    0.7.0.1
 */