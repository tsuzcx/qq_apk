package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.al;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/JsApiIsSupportNFC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends c<f>
{
  public static final int CTRL_INDEX = 788;
  public static final String NAME = "isSupportNFC";
  public static final e.a skA;
  
  static
  {
    AppMethodBeat.i(183639);
    skA = new e.a((byte)0);
    AppMethodBeat.o(183639);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(183638);
    if (paramf == null)
    {
      AppMethodBeat.o(183638);
      return;
    }
    paramJSONObject = (al)com.tencent.luggage.a.e.T(al.class);
    if ((paramJSONObject != null) && (!paramJSONObject.cpS()))
    {
      paramf.callback(paramInt, j.a((p)this, 13019, "fail:user is not authorized", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183638);
      return;
    }
    if (d.ctL())
    {
      paramf.callback(paramInt, j.a((p)this, 0, "ok", null));
      AppMethodBeat.o(183638);
      return;
    }
    paramf.callback(paramInt, j.a((p)this, 13000, "fail", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13000)) })));
    AppMethodBeat.o(183638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.e
 * JD-Core Version:    0.7.0.1
 */