package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.e.b;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppJoinGroup;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class as
  extends c<f>
{
  public static final int CTRL_INDEX = 876;
  public static final String NAME = "joinGroup";
  public static final a rxy;
  
  static
  {
    AppMethodBeat.i(325564);
    rxy = new a((byte)0);
    AppMethodBeat.o(325564);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(325569);
    s.u(paramf, "env");
    s.u(paramJSONObject, "data");
    String str1 = paramf.getAppId();
    Object localObject = (CharSequence)str1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramf.callback(paramInt, ZP("fail:appId is null"));
      AppMethodBeat.o(325569);
      return;
    }
    localObject = paramJSONObject.optString("signature");
    String str2 = paramJSONObject.optString("groupId");
    paramJSONObject = paramJSONObject.optString("nonceStr");
    e.b localb = new e.b();
    localb.appId = str1;
    localb.signature = ((String)localObject);
    localb.KQX = str2;
    localb.KQY = paramJSONObject;
    ((e)h.ax(e.class)).a(paramf.getContext(), localb);
    paramf.callback(paramInt, ZP("ok"));
    AppMethodBeat.o(325569);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppJoinGroup$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.as
 * JD-Core Version:    0.7.0.1
 */