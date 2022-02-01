package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.Map;
import kotlin.a.ae;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/JsApiIsSupportNFC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.d<f>
{
  public static final int CTRL_INDEX = 788;
  public static final String NAME = "isSupportNFC";
  public static final a mha;
  
  static
  {
    AppMethodBeat.i(183639);
    mha = new a((byte)0);
    AppMethodBeat.o(183639);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(183638);
    if (paramf == null)
    {
      AppMethodBeat.o(183638);
      return;
    }
    paramJSONObject = (ai)com.tencent.luggage.a.e.M(ai.class);
    if ((paramJSONObject != null) && (!paramJSONObject.bEm()))
    {
      paramf.i(paramInt, n("fail:user is not authorized", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183638);
      return;
    }
    if (com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bHX())
    {
      paramf.i(paramInt, Zf("ok"));
      AppMethodBeat.o(183638);
      return;
    }
    paramf.i(paramInt, n("fail", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13000)) })));
    AppMethodBeat.o(183638);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/JsApiIsSupportNFC$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.e
 * JD-Core Version:    0.7.0.1
 */