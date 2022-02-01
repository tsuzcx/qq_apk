package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static Set<String> jnI;
  
  static
  {
    AppMethodBeat.i(121439);
    jnI = new HashSet();
    if (!TextUtils.isEmpty("drawCanvas")) {
      jnI.add("drawCanvas");
    }
    AppMethodBeat.o(121439);
  }
  
  public static boolean FD(String paramString)
  {
    AppMethodBeat.i(121436);
    boolean bool = jnI.contains(paramString);
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
      paramString1 = c.Fx(paramString1);
      if (paramString1 != null) {
        paramString1.dlO.putInt("__invoke_jsapi_data_size", paramString2.length());
      }
      AppMethodBeat.o(121437);
      return;
    }
    catch (JSONException paramString1)
    {
      ad.e("MicroMsg.JsApiCostTimeStrategy", "%s", new Object[] { Log.getStackTraceString(paramString1) });
      AppMethodBeat.o(121437);
    }
  }
  
  public static String z(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(121438);
    paramJSONObject = paramJSONObject.optString("__session_id");
    AppMethodBeat.o(121438);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.d
 * JD-Core Version:    0.7.0.1
 */