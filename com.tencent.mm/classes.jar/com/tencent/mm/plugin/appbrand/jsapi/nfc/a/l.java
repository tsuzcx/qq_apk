package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.m;
import com.tencent.mm.plugin.appbrand.z.d;
import d.a.ae;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.o;
import d.u;
import d.v;
import d.z;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCTransceive;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class l
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 792;
  public static final String NAME = "NFCTransceive";
  public static final a kZk;
  
  static
  {
    AppMethodBeat.i(183651);
    kZk = new a((byte)0);
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
      paramc.h(paramInt, m("fail:invalid parameter", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(183650);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.jsapi.ad)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.ad.class);
    if ((localObject != null) && (!((com.tencent.mm.plugin.appbrand.jsapi.ad)localObject).bin()))
    {
      paramc.h(paramInt, m("fail:user is not authorized", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183650);
      return;
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.kZM;
    localObject = c.a.w(paramc);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, can not get activity");
      paramc.h(paramInt, m("fail:unknown", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13010)) })));
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
        paramc.h(paramInt, m("fail:invalid parameter", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13011)) })));
        AppMethodBeat.o(183650);
        return;
      }
      paramJSONObject = d.p((ByteBuffer)paramJSONObject);
    }
    catch (Exception paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiNFCTransceive", "parse tech failed");
      paramc.h(paramInt, m("fail:invalid parameter", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(183650);
      return;
    }
    p.g(str1, "tech");
    p.g(paramJSONObject, "reqData");
    paramc = (b)new b(this, paramc, paramInt);
    p.h(str1, "techName");
    p.h(paramJSONObject, "reqData");
    p.h(paramc, "callback");
    StringBuilder localStringBuilder = new StringBuilder("transceive, techName: ").append(str1).append(", reqData: ");
    String str2 = Arrays.toString(paramJSONObject);
    p.g(str2, "java.util.Arrays.toString(this)");
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrand.NFCReadWriteManager", str2);
    h.LTJ.f((Runnable)new c.m((com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c)localObject, paramc, str1, paramJSONObject), "NFC-IO");
    AppMethodBeat.o(183650);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCTransceive$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_RESULT_DATA", "PARAM_TECH", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "invoke"})
  static final class b
    extends q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<byte[]>, z>
  {
    b(l paraml, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.l
 * JD-Core Version:    0.7.0.1
 */