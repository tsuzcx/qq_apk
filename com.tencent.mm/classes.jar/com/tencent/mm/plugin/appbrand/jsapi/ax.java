package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ax
  extends a
{
  public static final int CTRL_INDEX = 711;
  public static final String NAME = "getOAID";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45492);
    paramJSONObject = q.aaL();
    ae.i("MicroMsg.JsApiGetOAID", "getOAID, oaid=".concat(String.valueOf(paramJSONObject)));
    if (bu.isNullOrNil(paramJSONObject))
    {
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(45492);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("result", paramJSONObject);
    paramc.h(paramInt, n("ok", localHashMap));
    AppMethodBeat.o(45492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ax
 * JD-Core Version:    0.7.0.1
 */