package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.l;
import d.a.ae;
import d.g.a.b;
import d.g.b.k;
import d.o;
import d.u;
import d.v;
import d.y;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCTransceive;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class l
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 792;
  public static final String NAME = "NFCTransceive";
  public static final a kcq;
  
  static
  {
    AppMethodBeat.i(183651);
    kcq = new a((byte)0);
    AppMethodBeat.o(183651);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(183650);
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, env is null");
      AppMethodBeat.o(183650);
      return;
    }
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, data is null");
      paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new o[] { u.P("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(183650);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.ad)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.ad.class);
    if ((localObject != null) && (!((com.tencent.mm.plugin.appbrand.jsapi.ad)localObject).aXM()))
    {
      paramc.h(paramInt, k("fail:user is not authorized", (Map)ae.c(new o[] { u.P("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183650);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.kcQ;
    localObject = c.a.w(paramc);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, can not get activity");
      paramc.h(paramInt, k("fail:unknown", (Map)ae.c(new o[] { u.P("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(183650);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, appId: " + paramc.getAppId() + ", data: " + paramJSONObject);
    String str1;
    try
    {
      str1 = paramJSONObject.getString("tech");
      try
      {
        paramJSONObject = paramJSONObject.get("data");
        if (paramJSONObject == null)
        {
          paramJSONObject = new v("null cannot be cast to non-null type java.nio.ByteBuffer");
          AppMethodBeat.o(183650);
          throw paramJSONObject;
        }
      }
      catch (Exception paramJSONObject)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiNFCTransceive", "parse data failed since ".concat(String.valueOf(paramJSONObject)));
        paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new o[] { u.P("errCode", Integer.valueOf(13011)) })));
        AppMethodBeat.o(183650);
        return;
      }
      paramJSONObject = d.q((ByteBuffer)paramJSONObject);
    }
    catch (Exception paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiNFCTransceive", "parse tech failed");
      paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new o[] { u.P("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(183650);
      return;
    }
    k.g(str1, "tech");
    k.g(paramJSONObject, "reqData");
    paramc = (b)new b(this, paramc, paramInt);
    k.h(str1, "techName");
    k.h(paramJSONObject, "reqData");
    k.h(paramc, "callback");
    StringBuilder localStringBuilder = new StringBuilder("transceive, techName: ").append(str1).append(", reqData: ");
    String str2 = Arrays.toString(paramJSONObject);
    k.g(str2, "java.util.Arrays.toString(this)");
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrand.NFCReadWriteManager", str2);
    h.Iye.f((Runnable)new c.l((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c)localObject, paramc, str1, paramJSONObject), "NFC-IO");
    AppMethodBeat.o(183650);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCTransceive$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_RESULT_DATA", "PARAM_TECH", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<byte[]>, y>
  {
    b(l paraml, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.l
 * JD-Core Version:    0.7.0.1
 */