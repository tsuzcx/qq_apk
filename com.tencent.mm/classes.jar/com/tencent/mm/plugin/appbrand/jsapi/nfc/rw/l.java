package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCTransceive;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class l
  extends com.tencent.mm.plugin.appbrand.jsapi.d<f>
{
  public static final int CTRL_INDEX = 792;
  public static final String NAME = "NFCTransceive";
  public static final a mik;
  
  static
  {
    AppMethodBeat.i(183651);
    mik = new a((byte)0);
    AppMethodBeat.o(183651);
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(183650);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, env is null");
      AppMethodBeat.o(183650);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, data is null");
      paramf.i(paramInt, n("fail:invalid parameter", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(183650);
      return;
    }
    Object localObject = (ai)com.tencent.luggage.a.e.M(ai.class);
    if ((localObject != null) && (!((ai)localObject).bEm()))
    {
      paramf.i(paramInt, n("fail:user is not authorized", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183650);
      return;
    }
    localObject = c.miO;
    localObject = c.a.w(paramf);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, can not get activity");
      paramf.i(paramInt, n("fail:unknown", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(183650);
      return;
    }
    Log.d("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, appId: " + paramf.getAppId() + ", data: " + paramJSONObject);
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
        paramf.i(paramInt, n("fail:invalid parameter", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13011)) })));
        AppMethodBeat.o(183650);
        return;
      }
      paramJSONObject = com.tencent.mm.plugin.appbrand.ac.d.p((ByteBuffer)paramJSONObject);
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCTransceive", "parse tech failed");
      paramf.i(paramInt, n("fail:invalid parameter", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(183650);
      return;
    }
    p.g(str1, "tech");
    p.g(paramJSONObject, "reqData");
    paramf = (b)new b(this, paramf, paramInt);
    p.h(str1, "techName");
    p.h(paramJSONObject, "reqData");
    p.h(paramf, "callback");
    StringBuilder localStringBuilder = new StringBuilder("transceive, techName: ").append(str1).append(", reqData: ");
    String str2 = Arrays.toString(paramJSONObject);
    p.g(str2, "java.util.Arrays.toString(this)");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", str2);
    h.RTc.b((Runnable)new c.m((c)localObject, paramf, str1, paramJSONObject), "NFC-IO");
    AppMethodBeat.o(183650);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCTransceive$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_RESULT_DATA", "PARAM_TECH", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "invoke"})
  static final class b
    extends q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<byte[]>, x>
  {
    b(l paraml, f paramf, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.l
 * JD-Core Version:    0.7.0.1
 */