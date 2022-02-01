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
import kotlin.g.a.b;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCConnectClose;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "function", "Lkotlin/Function3;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/ConnectClosePrototype;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)V", "invoke", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends c<f>
{
  public static final a.a slj = new a.a((byte)0);
  private final q<g, String, b<? super h<ah>, ah>, ah> slk;
  
  public a(q<? super g, ? super String, ? super b<? super h<ah>, ah>, ah> paramq)
  {
    this.slk = paramq;
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, env is null");
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, data is null");
      paramf.callback(paramInt, j.a((p)this, 13011, "fail:invalid parameter", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13011)) })));
      return;
    }
    Object localObject = (al)e.T(al.class);
    if ((localObject != null) && (!((al)localObject).cpS()))
    {
      paramf.callback(paramInt, j.a((p)this, 13019, "fail:user is not authorized", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13019)) })));
      return;
    }
    localObject = g.smq;
    localObject = g.a.B(paramf);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, can not get activity");
      paramf.callback(paramInt, j.a((p)this, 13010, "fail:unknown", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13010)) })));
      return;
    }
    Log.d("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, appId: " + paramf.getAppId() + ", data: " + paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.getString("tech");
      q localq = this.slk;
      s.s(paramJSONObject, "tech");
      localq.invoke(localObject, paramJSONObject, new b(paramf, paramInt, this));
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.w("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "parse tech failed");
      paramf.callback(paramInt, j.a((p)this, 13011, "fail:invalid parameter", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13011)) })));
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<h<ah>, ah>
  {
    b(f paramf, int paramInt, a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a
 * JD-Core Version:    0.7.0.1
 */