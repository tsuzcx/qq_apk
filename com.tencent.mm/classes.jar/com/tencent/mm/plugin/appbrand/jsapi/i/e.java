package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class e<CONTEXT extends f>
  extends d<CONTEXT>
{
  private static final int CTRL_INDEX = 587;
  private static final String NAME = "disableLocationUpdate";
  protected s lXb;
  
  public void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143627);
    Log.i("MicroMsg.AppBrand.JsApiDisableLocationUpdate", "disableLocationUpdate invoke");
    this.lXb = ((s)paramCONTEXT.aw(s.class));
    if (this.lXb == null)
    {
      Log.i("MicroMsg.AppBrand.JsApiDisableLocationUpdate", "fail:location update not enabled");
      paramCONTEXT.i(paramInt, h("fail:location update not enabled", null));
      AppMethodBeat.o(143627);
      return;
    }
    this.lXb.bGK();
    paramCONTEXT.i(paramInt, h("ok", null));
    AppMethodBeat.o(143627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.e
 * JD-Core Version:    0.7.0.1
 */