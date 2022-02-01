package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCSetTimeout;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends c<f>
{
  public static final int CTRL_INDEX = 814;
  public static final String NAME = "NFCSetTimeout";
  public static final k.a slG;
  
  static
  {
    AppMethodBeat.i(328053);
    slG = new k.a((byte)0);
    AppMethodBeat.o(328053);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(328061);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, env is null");
      AppMethodBeat.o(328061);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, data is null");
      paramf.callback(paramInt, j.a((p)this, 13011, "fail:invalid parameter", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(328061);
      return;
    }
    Object localObject = (al)e.T(al.class);
    if ((localObject != null) && (!((al)localObject).cpS()))
    {
      paramf.callback(paramInt, j.a((p)this, 13019, "fail:user is not authorized", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(328061);
      return;
    }
    localObject = g.smq;
    localObject = g.a.B(paramf);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, can not get activity");
      paramf.callback(paramInt, j.a((p)this, 13010, "fail:unknown", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(328061);
      return;
    }
    Log.d("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, appId: " + paramf.getAppId() + ", data: " + paramJSONObject);
    try
    {
      String str = paramJSONObject.getString("tech");
      int i;
      return;
    }
    catch (Exception paramJSONObject)
    {
      try
      {
        i = paramJSONObject.getInt("timeout");
        s.s(str, "tech");
        ((g)localObject).c(str, i, (b)new b(paramf, paramInt, this));
        AppMethodBeat.o(328061);
        return;
      }
      catch (Exception paramJSONObject)
      {
        Log.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "parse timeout failed");
        paramf.callback(paramInt, j.a((p)this, 13011, "fail:invalid parameter", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13011)) })));
        AppMethodBeat.o(328061);
      }
      paramJSONObject = paramJSONObject;
      Log.w("MicroMsg.AppBrand.JsApiNFCSetTimeout", "parse tech failed");
      paramf.callback(paramInt, j.a((p)this, 13011, "fail:invalid parameter", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(328061);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<h<ah>, ah>
  {
    b(f paramf, int paramInt, k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.k
 * JD-Core Version:    0.7.0.1
 */