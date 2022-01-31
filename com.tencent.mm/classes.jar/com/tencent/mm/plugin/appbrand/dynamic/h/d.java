package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static Set<String> fWZ = new HashSet();
  
  static
  {
    if (!TextUtils.isEmpty("drawCanvas")) {
      fWZ.add("drawCanvas");
    }
  }
  
  public static void a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("__session_id", paramString1);
      paramJSONObject.put("__invoke_jsapi_timestamp", System.nanoTime());
      paramString1 = c.rT(paramString1);
      if (paramString1 != null) {
        paramString1.bOY.putInt("__invoke_jsapi_data_size", paramString2.length());
      }
      return;
    }
    catch (JSONException paramString1)
    {
      y.e("MicroMsg.JsApiCostTimeStrategy", "%s", new Object[] { Log.getStackTraceString(paramString1) });
    }
  }
  
  public static String n(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("__session_id");
  }
  
  public static boolean rZ(String paramString)
  {
    return fWZ.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.d
 * JD-Core Version:    0.7.0.1
 */