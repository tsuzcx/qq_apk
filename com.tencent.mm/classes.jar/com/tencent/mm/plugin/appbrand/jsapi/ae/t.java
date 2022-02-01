package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiOpenSystemSetting;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "Companion", "luggage-commons-jsapi-default-impl_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends ab<f>
{
  private static final int CTRL_INDEX = 1063;
  private static final String NAME = "openSystemSetting";
  public static final a sxa;
  private static final j<Map<String, b<Context, Boolean>>> sxb;
  
  static
  {
    AppMethodBeat.i(326034);
    sxa = new a((byte)0);
    sxb = k.cm((a)b.sxc);
    AppMethodBeat.o(326034);
  }
  
  public final String a(f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(326036);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenSystemSetting", "invoke, env is null");
      paramf = a(null, a.e.rVx, null);
      s.s(paramf, "makeReturnJson(AppBrandE…s.General.INTERNAL_ERROR)");
      AppMethodBeat.o(326036);
      return paramf;
    }
    paramf = paramf.getContext();
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenSystemSetting", "invoke, context is null");
      paramf = a(null, a.e.rVx, null);
      s.s(paramf, "makeReturnJson(AppBrandE…s.General.INTERNAL_ERROR)");
      AppMethodBeat.o(326036);
      return paramf;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("type")))
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenSystemSetting", s.X("invoke, data is illegal, data: ", paramJSONObject));
      paramf = a(null, a.e.rVz, null);
      s.s(paramf, "makeReturnJson(AppBrandE…ral.INVALID_REQUEST_DATA)");
      AppMethodBeat.o(326036);
      return paramf;
    }
    paramJSONObject = paramJSONObject.optString("type");
    Log.i("MicroMsg.AppBrand.JsApiOpenSystemSetting", s.X("invoke, openType: ", paramJSONObject));
    paramJSONObject = (b)((Map)sxb.getValue()).get(paramJSONObject);
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiOpenSystemSetting", "invoke, openAction is null");
      paramf = a(null, a.e.rVz, null);
      s.s(paramf, "makeReturnJson(AppBrandE…ral.INVALID_REQUEST_DATA)");
      AppMethodBeat.o(326036);
      return paramf;
    }
    if (!((Boolean)paramJSONObject.invoke(paramf)).booleanValue())
    {
      Log.i("MicroMsg.AppBrand.JsApiOpenSystemSetting", "invoke, open fail");
      paramf = a(null, a.b.rUD, null);
      s.s(paramf, "makeReturnJson(AppBrandE….SETTINGS_PAGE_NOT_FOUND)");
      AppMethodBeat.o(326036);
      return paramf;
    }
    paramf = a(null, a.e.rVt, null);
    s.s(paramf, "makeReturnJson(AppBrandErrors.General.OK)");
    AppMethodBeat.o(326036);
    return paramf;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiOpenSystemSetting$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "OPEN_TYPE_APP_AUTHORIZE", "OPEN_TYPE_SYSTEM_BLUETOOTH", "PARAM_KEY_TYPE", "TAG", "openActions", "", "Lkotlin/Function1;", "Landroid/content/Context;", "", "getOpenActions", "()Ljava/util/Map;", "openActions$delegate", "Lkotlin/Lazy;", "luggage-commons-jsapi-default-impl_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "Lkotlin/Function1;", "Landroid/content/Context;", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Map<String, ? extends b<? super Context, ? extends Boolean>>>
  {
    public static final b sxc;
    
    static
    {
      AppMethodBeat.i(326064);
      sxc = new b();
      AppMethodBeat.o(326064);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.t
 * JD-Core Version:    0.7.0.1
 */