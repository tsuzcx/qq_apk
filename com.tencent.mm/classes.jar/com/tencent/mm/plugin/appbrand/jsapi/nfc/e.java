package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import d.a.ae;
import d.l;
import d.o;
import d.u;
import java.util.Map;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/JsApiIsSupportNFC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class e
  extends a<c>
{
  public static final int CTRL_INDEX = 788;
  public static final String NAME = "isSupportNFC";
  public static final a kYa;
  
  static
  {
    AppMethodBeat.i(183639);
    kYa = new a((byte)0);
    AppMethodBeat.o(183639);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(183638);
    if (paramc == null)
    {
      AppMethodBeat.o(183638);
      return;
    }
    paramJSONObject = (ad)com.tencent.luggage.a.e.K(ad.class);
    if ((paramJSONObject != null) && (!paramJSONObject.bin()))
    {
      paramc.h(paramInt, m("fail:user is not authorized", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183638);
      return;
    }
    if (d.blP())
    {
      paramc.h(paramInt, Pg("ok"));
      AppMethodBeat.o(183638);
      return;
    }
    paramc.h(paramInt, m("fail", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13000)) })));
    AppMethodBeat.o(183638);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/JsApiIsSupportNFC$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.e
 * JD-Core Version:    0.7.0.1
 */