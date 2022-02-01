package com.tencent.mm.plugin.lite.a.b.a;

import com.tencent.liteapp.jsapi.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import java.util.HashMap;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/jsapi/bridge/appbrand/LiteAppBridgeAppBrandJsApi;", "Lcom/tencent/mm/plugin/lite/api/LiteAppJsApi;", "appBrandJsApi", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;)V", "getAppBrandJsApi", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "setAppBrandJsApi", "invoke", "", "appId", "", "data", "Lorg/json/JSONObject;", "isFromView", "", "Companion", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.plugin.lite.api.e
{
  public static final a JZP;
  p JZQ;
  
  static
  {
    AppMethodBeat.i(271567);
    JZP = new a((byte)0);
    AppMethodBeat.o(271567);
  }
  
  public e(p paramp)
  {
    AppMethodBeat.i(271559);
    this.JZQ = paramp;
    AppMethodBeat.o(271559);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271571);
    paramString = g.fTY();
    p localp = this.JZQ;
    if ((localp instanceof c))
    {
      int i = (int)this.JZi.efY;
      paramString.JZV.put(Integer.valueOf(i), this.JZi);
      ((c)localp).a(paramString.JZU, paramJSONObject, i);
      AppMethodBeat.o(271571);
      return;
    }
    ((ab)localp).a(paramString.JZU, paramJSONObject);
    AppMethodBeat.o(271571);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/jsapi/bridge/appbrand/LiteAppBridgeAppBrandJsApi$Companion;", "", "()V", "TAG", "", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */