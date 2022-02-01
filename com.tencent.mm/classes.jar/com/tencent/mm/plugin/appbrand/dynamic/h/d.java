package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static Set<String> lpg;
  
  static
  {
    AppMethodBeat.i(121439);
    lpg = new HashSet();
    if (!TextUtils.isEmpty("drawCanvas")) {
      lpg.add("drawCanvas");
    }
    AppMethodBeat.o(121439);
  }
  
  public static String G(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(121438);
    paramJSONObject = paramJSONObject.optString("__session_id");
    AppMethodBeat.o(121438);
    return paramJSONObject;
  }
  
  public static boolean WP(String paramString)
  {
    AppMethodBeat.i(121436);
    boolean bool = lpg.contains(paramString);
    AppMethodBeat.o(121436);
    return bool;
  }
  
  public static void a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(121437);
    try
    {
      paramJSONObject.put("__session_id", paramString1);
      paramJSONObject.put("__invoke_jsapi_timestamp", System.nanoTime());
      paramString1 = c.WJ(paramString1);
      if (paramString1 != null) {
        paramString1.dNV.putInt("__invoke_jsapi_data_size", paramString2.length());
      }
      AppMethodBeat.o(121437);
      return;
    }
    catch (JSONException paramString1)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.JsApiCostTimeStrategy", "%s", new Object[] { android.util.Log.getStackTraceString(paramString1) });
      AppMethodBeat.o(121437);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.d
 * JD-Core Version:    0.7.0.1
 */