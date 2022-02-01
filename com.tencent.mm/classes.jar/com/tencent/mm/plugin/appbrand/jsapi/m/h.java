package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class h
  extends f<y>
{
  private static final int CTRL_INDEX = 587;
  private static final String NAME = "disableLocationUpdate";
  
  public void a(y paramy, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138192);
    super.a(paramy, paramJSONObject, paramInt);
    if (!(this.rZZ instanceof v))
    {
      Log.w("MicroMsg.AppBrand.JsApiDisableLocationUpdateWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
      paramy.callback(paramInt, ZP("fail:system error"));
      AppMethodBeat.o(138192);
      return;
    }
    ((v)this.rZZ).am(paramy.getRuntime());
    AppMethodBeat.o(138192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.h
 * JD-Core Version:    0.7.0.1
 */