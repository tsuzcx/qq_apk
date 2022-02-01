package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.e;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.ae;
import d.g.b.k;
import d.o;
import d.u;
import d.y;
import java.util.Map;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCTechGetAsync;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "techName", "", "function", "resultKey", "retConverter", "Lkotlin/Function1;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/RetConverter;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public abstract class b
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final a kCK = new a((byte)0);
  private final String kCG;
  private final String kCH;
  private final String kCI;
  private final d.g.a.b<Object, Object> kCJ;
  
  public b(String paramString1, String paramString2, String paramString3, d.g.a.b<Object, ? extends Object> paramb)
  {
    this.kCG = paramString1;
    this.kCH = paramString2;
    this.kCI = paramString3;
    this.kCJ = paramb;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    if (paramc == null)
    {
      ac.w("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, env is null");
      return;
    }
    paramJSONObject = (ad)com.tencent.luggage.a.e.K(ad.class);
    if ((paramJSONObject != null) && (!paramJSONObject.beJ()))
    {
      paramc.h(paramInt, k("fail:user is not authorized", (Map)ae.c(new o[] { u.Q("errCode", Integer.valueOf(13019)) })));
      return;
    }
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.kDD;
    paramJSONObject = c.a.w(paramc);
    if (paramJSONObject == null)
    {
      ac.w("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, can not get activity");
      paramc.h(paramInt, LM("fail:unknown"));
      return;
    }
    ac.i("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, appId: " + paramc.getAppId());
    String str1 = this.kCG;
    String str2 = this.kCH;
    paramc = (d.g.a.b)new b(this, paramc, paramInt);
    k.h(str1, "techName");
    k.h(str2, "function");
    k.h(paramc, "callback");
    ac.d("MicroMsg.AppBrand.NFCReadWriteManager", "execTechLogicAsync, techName: " + str1 + ", function: " + str2 + ", params: " + null);
    h.JZN.f((Runnable)new c.e(paramJSONObject, paramc, str1, str2), "NFC-IO");
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCTechGetAsync$Companion;", "", "()V", "TAG", "", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<Object>, y>
  {
    b(b paramb, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b
 * JD-Core Version:    0.7.0.1
 */