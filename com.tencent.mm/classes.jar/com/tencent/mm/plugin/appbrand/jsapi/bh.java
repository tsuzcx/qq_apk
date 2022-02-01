package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class bh
  extends d
{
  public static final int CTRL_INDEX = 711;
  public static final String NAME = "getOAID";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45492);
    paramJSONObject = q.aoK();
    Log.i("MicroMsg.JsApiGetOAID", "getOAID, oaid=".concat(String.valueOf(paramJSONObject)));
    if (Util.isNullOrNil(paramJSONObject))
    {
      paramf.i(paramInt, h("fail", null));
      AppMethodBeat.o(45492);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("result", paramJSONObject);
    paramf.i(paramInt, n("ok", localHashMap));
    AppMethodBeat.o(45492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bh
 * JD-Core Version:    0.7.0.1
 */