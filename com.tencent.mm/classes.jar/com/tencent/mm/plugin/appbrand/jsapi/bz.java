package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.waid.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class bz
  extends a
{
  public static final int CTRL_INDEX = 731;
  public static final String NAME = "saveWaid";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45633);
    HashMap localHashMap = new HashMap();
    try
    {
      int i = g.aqX(paramJSONObject.toString());
      localHashMap.put("result", String.valueOf(i));
      paramc.h(paramInt, k("ok", localHashMap));
      ad.i("MicroMsg.JsApiSaveWaid", "appBrand JsApiSaveWaid, data=" + paramJSONObject + ", waidNum=" + i);
      AppMethodBeat.o(45633);
      return;
    }
    catch (Exception paramJSONObject)
    {
      localHashMap.put("result", "0");
      paramc.h(paramInt, k("fail", localHashMap));
      ad.e("MicroMsg.JsApiSaveWaid", "appBrand JsApiSaveWaid, exp=" + paramJSONObject.toString());
      AppMethodBeat.o(45633);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bz
 * JD-Core Version:    0.7.0.1
 */