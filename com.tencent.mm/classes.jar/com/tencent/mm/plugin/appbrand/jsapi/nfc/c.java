package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import d.a.ae;
import d.l;
import d.o;
import d.u;
import java.util.Map;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/JsApiIsSupportNFC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class c
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 788;
  public static final String NAME = "isSupportNFC";
  public static final a kBT;
  
  static
  {
    AppMethodBeat.i(183639);
    kBT = new a((byte)0);
    AppMethodBeat.o(183639);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(183638);
    if (paramc == null)
    {
      AppMethodBeat.o(183638);
      return;
    }
    paramJSONObject = (ad)e.K(ad.class);
    if ((paramJSONObject != null) && (!paramJSONObject.beJ()))
    {
      paramc.h(paramInt, k("fail:user is not authorized", (Map)ae.c(new o[] { u.Q("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183638);
      return;
    }
    if (d.bif())
    {
      paramc.h(paramInt, LM("ok"));
      AppMethodBeat.o(183638);
      return;
    }
    paramc.h(paramInt, k("fail", (Map)ae.c(new o[] { u.Q("errCode", Integer.valueOf(13000)) })));
    AppMethodBeat.o(183638);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/JsApiIsSupportNFC$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.c
 * JD-Core Version:    0.7.0.1
 */