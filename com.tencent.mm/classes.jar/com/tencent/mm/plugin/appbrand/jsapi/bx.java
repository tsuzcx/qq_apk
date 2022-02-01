package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.c;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenAddressWithLightMode;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenAddress;", "()V", "onSetupIntent", "", "intent", "Landroid/content/Intent;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bx
  extends bw
{
  public static final int CTRL_INDEX = 905;
  public static final String NAME = "openAddressWithLightMode";
  public static final a rzF;
  
  static
  {
    AppMethodBeat.i(325528);
    rzF = new a((byte)0);
    AppMethodBeat.o(325528);
  }
  
  public bx()
  {
    AppMethodBeat.i(325527);
    c.afo("openAddressWithLightMode");
    AppMethodBeat.o(325527);
  }
  
  protected final void a(Intent paramIntent, k paramk, JSONObject paramJSONObject)
  {
    boolean bool = false;
    AppMethodBeat.i(325530);
    s.u(paramIntent, "intent");
    super.a(paramIntent, paramk, paramJSONObject);
    if (paramJSONObject == null) {}
    for (;;)
    {
      paramIntent.putExtra("force_light_mode", bool);
      AppMethodBeat.o(325530);
      return;
      bool = paramJSONObject.optBoolean("forceLightMode", false);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiOpenAddressWithLightMode$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bx
 * JD-Core Version:    0.7.0.1
 */