package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class aa
  extends b
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "removeMapArc";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(329477);
    super.a(paramf, paramJSONObject, paramInt);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiRemoveMapArc", "data is null");
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(329477);
      return;
    }
    Log.i("MicroMsg.JsApiRemoveMapArc", "data:%s", new Object[] { paramJSONObject });
    com.tencent.mm.plugin.appbrand.jsapi.o.a.b localb = g(paramf, paramJSONObject);
    if (localb == null)
    {
      Log.e("MicroMsg.JsApiRemoveMapArc", "mapView is null, return");
      paramf.callback(paramInt, ZP("fail:mapview is null"));
      AppMethodBeat.o(329477);
      return;
    }
    if (paramJSONObject.has("id"))
    {
      Log.i("MicroMsg.JsApiRemoveMapArc", "removeMapArc success");
      localb.AP(paramJSONObject.optInt("id"));
      paramf.callback(paramInt, ZP("ok"));
      AppMethodBeat.o(329477);
      return;
    }
    Log.e("MicroMsg.JsApiRemoveMapArc", "id is empty");
    paramf.callback(paramInt, ZP("fail:invalid data"));
    AppMethodBeat.o(329477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.aa
 * JD-Core Version:    0.7.0.1
 */