package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.e.b;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppJoinGroup;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class ap
  extends c<e>
{
  public static final int CTRL_INDEX = 876;
  public static final String NAME = "joinGroup";
  public static final a otR;
  
  static
  {
    AppMethodBeat.i(246547);
    otR = new a((byte)0);
    AppMethodBeat.o(246547);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(246546);
    p.k(parame, "env");
    p.k(paramJSONObject, "data");
    String str1 = parame.getAppId();
    Object localObject = (CharSequence)str1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parame.j(paramInt, agS("fail:appId is null"));
      AppMethodBeat.o(246546);
      return;
    }
    localObject = paramJSONObject.optString("signature");
    String str2 = paramJSONObject.optString("groupId");
    paramJSONObject = paramJSONObject.optString("nonceStr");
    e.b localb = new e.b();
    localb.appId = str1;
    localb.signature = ((String)localObject);
    localb.EVw = str2;
    localb.EVx = paramJSONObject;
    ((com.tencent.mm.plugin.messenger.foundation.a.e)h.ae(com.tencent.mm.plugin.messenger.foundation.a.e.class)).a(parame.getContext(), localb);
    parame.j(paramInt, agS("ok"));
    AppMethodBeat.o(246546);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppJoinGroup$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ap
 * JD-Core Version:    0.7.0.1
 */