package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class cp
  extends c
{
  public static final int CTRL_INDEX = 731;
  public static final String NAME = "saveWaid";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45633);
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("result", "0");
      parame.j(paramInt, m("ok", localHashMap));
      Log.i("MicroMsg.JsApiSaveWaid", "appBrand JsApiSaveWaid, data=" + paramJSONObject + ", waidNum=0");
      AppMethodBeat.o(45633);
      return;
    }
    catch (Exception paramJSONObject)
    {
      localHashMap.put("result", "0");
      parame.j(paramInt, m("fail", localHashMap));
      Log.e("MicroMsg.JsApiSaveWaid", "appBrand JsApiSaveWaid, exp=" + paramJSONObject.toString());
      AppMethodBeat.o(45633);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cp
 * JD-Core Version:    0.7.0.1
 */