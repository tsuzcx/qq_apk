package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.y;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiPredownloadMiniProgramPackage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-luggage-wechat-impl_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class co
  extends c<f>
{
  @Deprecated
  public static final int CTRL_INDEX = 678;
  @Deprecated
  public static final String NAME = "predownloadMiniProgramPackage";
  private static final a rAi;
  
  static
  {
    AppMethodBeat.i(50409);
    rAi = new a((byte)0);
    AppMethodBeat.o(50409);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(50408);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(50408);
      return;
    }
    if (paramf == null)
    {
      AppMethodBeat.o(50408);
      return;
    }
    String str = paramJSONObject.optString("username");
    Object localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(50408);
      return;
    }
    localObject = paramJSONObject.optString("path");
    i = paramJSONObject.optInt("scene", 0);
    ((y)h.ax(y.class)).y(str, (String)localObject, i);
    paramf.callback(paramInt, ZP("ok"));
    AppMethodBeat.o(50408);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiPredownloadMiniProgramPackage$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-luggage-wechat-impl_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.co
 * JD-Core Version:    0.7.0.1
 */