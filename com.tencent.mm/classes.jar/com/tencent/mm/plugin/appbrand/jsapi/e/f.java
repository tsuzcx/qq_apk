package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public class f
  extends d<q>
{
  private static final int CTRL_INDEX = 587;
  private static final String NAME = "disableLocationUpdate";
  
  public void a(q paramq, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138192);
    super.a(paramq, paramJSONObject, paramInt);
    if (!(this.jSl instanceof r))
    {
      ad.w("MicroMsg.AppBrand.JsApiDisableLocationUpdateWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramq.h(paramInt, e("fail:system error", null));
      AppMethodBeat.o(138192);
      return;
    }
    ((r)this.jSl).ad(paramq.getRuntime());
    AppMethodBeat.o(138192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.f
 * JD-Core Version:    0.7.0.1
 */