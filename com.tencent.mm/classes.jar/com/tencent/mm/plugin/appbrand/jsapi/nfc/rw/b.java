package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCTechGetAsync;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "techName", "", "function", "resultKey", "retConverter", "Lkotlin/Function1;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/RetConverter;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public abstract class b
  extends d<f>
{
  public static final a mhR = new a((byte)0);
  private final String mhN;
  private final String mhO;
  private final String mhP;
  private final kotlin.g.a.b<Object, Object> mhQ;
  
  public b(String paramString1, String paramString2, String paramString3, kotlin.g.a.b<Object, ? extends Object> paramb)
  {
    this.mhN = paramString1;
    this.mhO = paramString2;
    this.mhP = paramString3;
    this.mhQ = paramb;
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, env is null");
      return;
    }
    paramJSONObject = (ai)com.tencent.luggage.a.e.M(ai.class);
    if ((paramJSONObject != null) && (!paramJSONObject.bEm()))
    {
      paramf.i(paramInt, n("fail:user is not authorized", (Map)ae.g(new o[] { s.U("errCode", Integer.valueOf(13019)) })));
      return;
    }
    paramJSONObject = c.miO;
    paramJSONObject = c.a.w(paramf);
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, can not get activity");
      paramf.i(paramInt, Zf("fail:unknown"));
      return;
    }
    Log.i("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, appId: " + paramf.getAppId());
    String str1 = this.mhN;
    String str2 = this.mhO;
    paramf = (kotlin.g.a.b)new b(this, paramf, paramInt);
    p.h(str1, "techName");
    p.h(str2, "function");
    p.h(paramf, "callback");
    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "execTechLogicAsync, techName: " + str1 + ", function: " + str2 + ", params: " + null);
    h.RTc.b((Runnable)new c.f(paramJSONObject, paramf, str1, str2), "NFC-IO");
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCTechGetAsync$Companion;", "", "()V", "TAG", "", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<Object>, x>
  {
    b(b paramb, f paramf, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.b
 * JD-Core Version:    0.7.0.1
 */