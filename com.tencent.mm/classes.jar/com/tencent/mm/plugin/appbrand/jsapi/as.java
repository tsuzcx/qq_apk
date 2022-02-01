package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppJoinGroup;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class as
  extends d<f>
{
  public static final int CTRL_INDEX = 876;
  public static final String NAME = "joinGroup";
  public static final a lyM;
  
  static
  {
    AppMethodBeat.i(228275);
    lyM = new a((byte)0);
    AppMethodBeat.o(228275);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(228274);
    p.h(paramf, "env");
    p.h(paramJSONObject, "data");
    String str1 = paramf.getAppId();
    Object localObject = (CharSequence)str1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramf.i(paramInt, Zf("fail:appId is null"));
      AppMethodBeat.o(228274);
      return;
    }
    localObject = paramJSONObject.optString("signature");
    String str2 = paramJSONObject.optString("groupId");
    paramJSONObject = paramJSONObject.optString("nonceStr");
    c.b localb = new c.b();
    localb.appId = str1;
    localb.signature = ((String)localObject);
    localb.zpX = str2;
    localb.zpY = paramJSONObject;
    ((c)g.af(c.class)).a(paramf.getContext(), localb);
    paramf.i(paramInt, Zf("ok"));
    AppMethodBeat.o(228274);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAppJoinGroup$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.as
 * JD-Core Version:    0.7.0.1
 */