package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static Set<String> hqz;
  
  static
  {
    AppMethodBeat.i(10958);
    hqz = new HashSet();
    if (!TextUtils.isEmpty("drawCanvas")) {
      hqz.add("drawCanvas");
    }
    AppMethodBeat.o(10958);
  }
  
  public static void a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(10956);
    try
    {
      paramJSONObject.put("__session_id", paramString1);
      paramJSONObject.put("__invoke_jsapi_timestamp", System.nanoTime());
      paramString1 = c.zJ(paramString1);
      if (paramString1 != null) {
        paramString1.cwp.putInt("__invoke_jsapi_data_size", paramString2.length());
      }
      AppMethodBeat.o(10956);
      return;
    }
    catch (JSONException paramString1)
    {
      ab.e("MicroMsg.JsApiCostTimeStrategy", "%s", new Object[] { Log.getStackTraceString(paramString1) });
      AppMethodBeat.o(10956);
    }
  }
  
  public static String u(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(10957);
    paramJSONObject = paramJSONObject.optString("__session_id");
    AppMethodBeat.o(10957);
    return paramJSONObject;
  }
  
  public static boolean zP(String paramString)
  {
    AppMethodBeat.i(10955);
    boolean bool = hqz.contains(paramString);
    AppMethodBeat.o(10955);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.d
 * JD-Core Version:    0.7.0.1
 */