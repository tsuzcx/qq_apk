package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.f;
import d.a.ae;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.o;
import d.u;
import d.z;
import java.util.Map;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCTechGetAsync;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "techName", "", "function", "resultKey", "retConverter", "Lkotlin/Function1;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/RetConverter;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public abstract class b
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final a kYR = new a((byte)0);
  private final String kYN;
  private final String kYO;
  private final String kYP;
  private final d.g.a.b<Object, Object> kYQ;
  
  public b(String paramString1, String paramString2, String paramString3, d.g.a.b<Object, ? extends Object> paramb)
  {
    this.kYN = paramString1;
    this.kYO = paramString2;
    this.kYP = paramString3;
    this.kYQ = paramb;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, env is null");
      return;
    }
    paramJSONObject = (com.tencent.mm.plugin.appbrand.jsapi.ad)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.ad.class);
    if ((paramJSONObject != null) && (!paramJSONObject.bin()))
    {
      paramc.h(paramInt, m("fail:user is not authorized", (Map)ae.c(new o[] { u.S("errCode", Integer.valueOf(13019)) })));
      return;
    }
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.kZM;
    paramJSONObject = c.a.w(paramc);
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, can not get activity");
      paramc.h(paramInt, Pg("fail:unknown"));
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, appId: " + paramc.getAppId());
    String str1 = this.kYN;
    String str2 = this.kYO;
    paramc = (d.g.a.b)new b(this, paramc, paramInt);
    p.h(str1, "techName");
    p.h(str2, "function");
    p.h(paramc, "callback");
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrand.NFCReadWriteManager", "execTechLogicAsync, techName: " + str1 + ", function: " + str2 + ", params: " + null);
    h.LTJ.f((Runnable)new c.f(paramJSONObject, paramc, str1, str2), "NFC-IO");
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCTechGetAsync$Companion;", "", "()V", "TAG", "", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<Object>, z>
  {
    b(b paramb, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b
 * JD-Core Version:    0.7.0.1
 */