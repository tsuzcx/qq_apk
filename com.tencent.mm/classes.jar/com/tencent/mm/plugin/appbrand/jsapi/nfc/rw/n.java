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
import kotlin.g.b.u;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStopNFCDiscovery;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends c<f>
{
  public static final int CTRL_INDEX = 794;
  public static final String NAME = "stopNFCDiscovery";
  public static final n.a slP;
  
  static
  {
    AppMethodBeat.i(183663);
    slP = new n.a((byte)0);
    AppMethodBeat.o(183663);
  }
  
  public final void a(f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(183662);
    if (paramf == null)
    {
      AppMethodBeat.o(183662);
      return;
    }
    paramJSONObject = (al)e.T(al.class);
    if ((paramJSONObject != null) && (!paramJSONObject.cpS()))
    {
      paramf.callback(paramInt, j.a((p)this, 13019, "fail:user is not authorized", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183662);
      return;
    }
    paramJSONObject = g.smq;
    paramJSONObject = g.a.B(paramf);
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiStopNFCDiscovery", "invoke, can not get activity");
      paramf.callback(paramInt, j.a((p)this, 13010, "fail:unknown", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(183662);
      return;
    }
    paramJSONObject.S((b)new b(paramf, paramInt, this, paramJSONObject));
    AppMethodBeat.o(183662);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<h<ah>, ah>
  {
    b(f paramf, int paramInt, n paramn, g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.n
 * JD-Core Version:    0.7.0.1
 */