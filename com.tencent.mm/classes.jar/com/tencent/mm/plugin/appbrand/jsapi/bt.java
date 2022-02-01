package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.c;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenAddressWithLightMode;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenAddress;", "()V", "onSetupIntent", "", "intent", "Landroid/content/Intent;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "Companion", "plugin-appbrand-integration_release"})
public final class bt
  extends bs
{
  public static final int CTRL_INDEX = 905;
  public static final String NAME = "openAddressWithLightMode";
  public static final a owl;
  
  static
  {
    AppMethodBeat.i(281792);
    owl = new a((byte)0);
    AppMethodBeat.o(281792);
  }
  
  public bt()
  {
    AppMethodBeat.i(281791);
    c.amg("openAddressWithLightMode");
    AppMethodBeat.o(281791);
  }
  
  protected final void a(Intent paramIntent, j paramj, JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(281790);
    p.k(paramIntent, "intent");
    super.a(paramIntent, paramj, paramJSONObject);
    if (paramJSONObject != null) {
      bool = paramJSONObject.optBoolean("forceLightMode", false);
    }
    paramIntent.putExtra("force_light_mode", bool);
    AppMethodBeat.o(281790);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenAddressWithLightMode$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bt
 * JD-Core Version:    0.7.0.1
 */