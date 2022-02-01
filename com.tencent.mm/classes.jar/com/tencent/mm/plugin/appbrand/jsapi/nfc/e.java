package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import java.util.Map;
import kotlin.a.ae;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/JsApiIsSupportNFC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class e
  extends c<com.tencent.mm.plugin.appbrand.jsapi.e>
{
  public static final int CTRL_INDEX = 788;
  public static final String NAME = "isSupportNFC";
  public static final a pfh;
  
  static
  {
    AppMethodBeat.i(183639);
    pfh = new a((byte)0);
    AppMethodBeat.o(183639);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(183638);
    if (parame == null)
    {
      AppMethodBeat.o(183638);
      return;
    }
    paramJSONObject = (ai)com.tencent.luggage.a.e.K(ai.class);
    if ((paramJSONObject != null) && (!paramJSONObject.bPK()))
    {
      parame.j(paramInt, m("fail:user is not authorized", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183638);
      return;
    }
    if (d.bTG())
    {
      parame.j(paramInt, agS("ok"));
      AppMethodBeat.o(183638);
      return;
    }
    parame.j(paramInt, m("fail", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13000)) })));
    AppMethodBeat.o(183638);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/JsApiIsSupportNFC$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.e
 * JD-Core Version:    0.7.0.1
 */