package com.tencent.mm.plugin.appbrand.jsapi.s.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.t.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends d
{
  public static final int CTRL_INDEX = 1060;
  public static final String NAME = "createCellularNetworkRequestTaskAsync";
  
  public b(d.b paramb)
  {
    super(a.sjD, paramb);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(327290);
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("forceCellularNetwork", true);
      super.a(paramf, localJSONObject, paramString);
      AppMethodBeat.o(327290);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.JsApiCreateCellularNetworkRequestTaskAsync", paramJSONObject, "put forceCellularNetwork fail, are you kidding me?", new Object[0]);
        this.skk.b(paramf, paramString, "internal error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.b.b
 * JD-Core Version:    0.7.0.1
 */