package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class af
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "setMapBoundary";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(329471);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSetMapBoundary", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(329471);
      return;
    }
    Log.i("MicroMsg.JsApiSetMapBoundary", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiSetMapBoundary", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(329471);
      return;
    }
    b.j localj = new b.j();
    if (paramJSONObject.has("southwest"))
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("southwest");
      localj.sdU = new b.i(localJSONObject.optDouble("latitude", 0.0D), localJSONObject.optDouble("longitude", 0.0D));
    }
    if (paramJSONObject.has("northeast"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("northeast");
      localj.sdV = new b.i(paramJSONObject.optDouble("latitude", 0.0D), paramJSONObject.optDouble("longitude", 0.0D));
    }
    if ((localj.sdV == null) || (localj.sdU == null))
    {
      Log.e("MicroMsg.JsApiSetMapBoundary", "data is invalid");
      paramf.callback(paramInt, ZP("fail:data is invalid"));
      AppMethodBeat.o(329471);
      return;
    }
    if (localb.a(localj))
    {
      Log.i("MicroMsg.JsApiSetMapBoundary", "setMapBoundary success");
      paramf.callback(paramInt, ZP("ok"));
      AppMethodBeat.o(329471);
      return;
    }
    Log.e("MicroMsg.JsApiSetMapBoundary", "data is invalid");
    paramf.callback(paramInt, ZP("fail:setMapBoundary is fail"));
    AppMethodBeat.o(329471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.af
 * JD-Core Version:    0.7.0.1
 */