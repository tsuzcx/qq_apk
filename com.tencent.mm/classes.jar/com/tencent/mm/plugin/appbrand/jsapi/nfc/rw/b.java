package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.luggage.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.al;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.j;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.g;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.h;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCTechGetAsync;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "techName", "", "function", "resultKey", "retConverter", "Lkotlin/Function1;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/RetConverter;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  extends c<f>
{
  public static final b.a slm = new b.a((byte)0);
  private final String function;
  private final String sln;
  private final String slo;
  private final kotlin.g.a.b<Object, Object> slp;
  
  public b(String paramString1, String paramString2, String paramString3, kotlin.g.a.b<Object, ? extends Object> paramb)
  {
    this.sln = paramString1;
    this.function = paramString2;
    this.slo = paramString3;
    this.slp = paramb;
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, env is null");
      return;
    }
    paramJSONObject = (al)e.T(al.class);
    if ((paramJSONObject != null) && (!paramJSONObject.cpS()))
    {
      paramf.callback(paramInt, j.a((p)this, 13019, "fail:user is not authorized", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13019)) })));
      return;
    }
    paramJSONObject = g.smq;
    paramJSONObject = g.a.B(paramf);
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, can not get activity");
      paramf.callback(paramInt, j.a((p)this, 13010, "fail:unknown", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13010)) })));
      return;
    }
    Log.i("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", s.X("invoke, appId: ", paramf.getAppId()));
    paramJSONObject.a(this.sln, this.function, (kotlin.g.a.b)new b(paramf, paramInt, this));
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<h<Object>, ah>
  {
    b(f paramf, int paramInt, b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.b
 * JD-Core Version:    0.7.0.1
 */