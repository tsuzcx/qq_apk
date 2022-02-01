package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppJoinGroup;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class ak
  extends a<c>
{
  public static final int CTRL_INDEX = 876;
  public static final String NAME = "joinGroup";
  public static final a krw;
  
  static
  {
    AppMethodBeat.i(189058);
    krw = new a((byte)0);
    AppMethodBeat.o(189058);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(189057);
    p.h(paramc, "env");
    p.h(paramJSONObject, "data");
    String str1 = paramc.getAppId();
    Object localObject = (CharSequence)str1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramc.h(paramInt, Pg("fail:appId is null"));
      AppMethodBeat.o(189057);
      return;
    }
    localObject = paramJSONObject.optString("signature");
    String str2 = paramJSONObject.optString("groupId");
    paramJSONObject = paramJSONObject.optString("nonceStr");
    c.b localb = new c.b();
    localb.appId = str1;
    localb.signature = ((String)localObject);
    localb.vJO = str2;
    localb.vJP = paramJSONObject;
    ((com.tencent.mm.plugin.messenger.foundation.a.c)g.ab(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a(paramc.getContext(), localb);
    paramc.h(paramInt, Pg("ok"));
    AppMethodBeat.o(189057);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppJoinGroup$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ak
 * JD-Core Version:    0.7.0.1
 */