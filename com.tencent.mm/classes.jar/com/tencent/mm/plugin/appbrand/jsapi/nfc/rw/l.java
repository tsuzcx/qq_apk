package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.o;
import kotlin.s;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCTransceive;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class l
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.jsapi.e>
{
  public static final int CTRL_INDEX = 792;
  public static final String NAME = "NFCTransceive";
  public static final a pgn;
  
  static
  {
    AppMethodBeat.i(183651);
    pgn = new a((byte)0);
    AppMethodBeat.o(183651);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(183650);
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, env is null");
      AppMethodBeat.o(183650);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, data is null");
      parame.j(paramInt, m("fail:invalid parameter", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(183650);
      return;
    }
    Object localObject = (ai)com.tencent.luggage.a.e.K(ai.class);
    if ((localObject != null) && (!((ai)localObject).bPK()))
    {
      parame.j(paramInt, m("fail:user is not authorized", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183650);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.pgQ;
    localObject = c.a.z(parame);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, can not get activity");
      parame.j(paramInt, m("fail:unknown", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(183650);
      return;
    }
    Log.d("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, appId: " + parame.getAppId() + ", data: " + paramJSONObject);
    String str1;
    try
    {
      str1 = paramJSONObject.getString("tech");
      try
      {
        paramJSONObject = paramJSONObject.get("data");
        if (paramJSONObject == null)
        {
          paramJSONObject = new t("null cannot be cast to non-null type java.nio.ByteBuffer");
          AppMethodBeat.o(183650);
          throw paramJSONObject;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.w("MicroMsg.AppBrand.JsApiNFCTransceive", "parse data failed since ".concat(String.valueOf(paramJSONObject)));
        parame.j(paramInt, m("fail:invalid parameter", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13011)) })));
        AppMethodBeat.o(183650);
        return;
      }
      paramJSONObject = d.m((ByteBuffer)paramJSONObject);
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCTransceive", "parse tech failed");
      parame.j(paramInt, m("fail:invalid parameter", (Map)ae.g(new o[] { s.M("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(183650);
      return;
    }
    p.j(str1, "tech");
    p.j(paramJSONObject, "reqData");
    parame = (b)new b(this, parame, paramInt);
    p.k(str1, "techName");
    p.k(paramJSONObject, "reqData");
    p.k(parame, "callback");
    StringBuilder localStringBuilder = new StringBuilder("transceive, techName: ").append(str1).append(", reqData: ");
    String str2 = Arrays.toString(paramJSONObject);
    p.j(str2, "java.util.Arrays.toString(this)");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", str2);
    h.ZvG.d((Runnable)new c.m((com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c)localObject, parame, str1, paramJSONObject), "NFC-IO");
    AppMethodBeat.o(183650);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCTransceive$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_RESULT_DATA", "PARAM_TECH", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "invoke"})
  static final class b
    extends q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<byte[]>, x>
  {
    b(l paraml, com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.l
 * JD-Core Version:    0.7.0.1
 */