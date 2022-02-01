package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class f<CONTEXT extends com.tencent.mm.plugin.appbrand.jsapi.f>
  extends c<CONTEXT>
{
  private static final int CTRL_INDEX = 587;
  private static final String NAME = "disableLocationUpdate";
  protected u rZZ;
  
  public void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143627);
    Log.i("MicroMsg.AppBrand.JsApiDisableLocationUpdate", "disableLocationUpdate invoke");
    this.rZZ = ((u)paramCONTEXT.aO(u.class));
    if (this.rZZ == null)
    {
      Log.i("MicroMsg.AppBrand.JsApiDisableLocationUpdate", "fail:location update not enabled");
      paramCONTEXT.callback(paramInt, ZP("fail:location update not enabled"));
      AppMethodBeat.o(143627);
      return;
    }
    this.rZZ.csw();
    paramCONTEXT.callback(paramInt, ZP("ok"));
    AppMethodBeat.o(143627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.f
 * JD-Core Version:    0.7.0.1
 */