package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.c;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenAddressWithLightMode;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenAddress;", "()V", "onSetupIntent", "", "intent", "Landroid/content/Intent;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "Companion", "plugin-appbrand-integration_release"})
public final class bu
  extends bt
{
  public static final int CTRL_INDEX = 905;
  public static final String NAME = "openAddressWithLightMode";
  public static final a lAV;
  
  static
  {
    AppMethodBeat.i(228297);
    lAV = new a((byte)0);
    AppMethodBeat.o(228297);
  }
  
  public bu()
  {
    AppMethodBeat.i(228296);
    c.aem("openAddressWithLightMode");
    AppMethodBeat.o(228296);
  }
  
  protected final void a(Intent paramIntent, k paramk, JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(228295);
    p.h(paramIntent, "intent");
    super.a(paramIntent, paramk, paramJSONObject);
    if (paramJSONObject != null) {
      bool = paramJSONObject.optBoolean("forceLightMode", false);
    }
    paramIntent.putExtra("force_light_mode", bool);
    AppMethodBeat.o(228295);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenAddressWithLightMode$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bu
 * JD-Core Version:    0.7.0.1
 */