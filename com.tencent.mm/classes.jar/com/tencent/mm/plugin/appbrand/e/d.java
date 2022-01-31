package com.tencent.mm.plugin.appbrand.e;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Locale;
import org.json.JSONObject;

public final class d
{
  private static void a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    try
    {
      paramJSONObject.put(paramString, paramObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      y.e("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginUtil", "build json object fail", new Object[] { paramJSONObject });
    }
  }
  
  public static String aK(String paramString, int paramInt)
  {
    return String.format(Locale.US, "%s#%d", new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public static void o(JSONObject paramJSONObject)
  {
    boolean bool = ae.getContext().getSharedPreferences("wcwebview", 4).getBoolean("appbrand_xwebview_video", false);
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginUtil", "checkXWebSameLayerRenderingConfig, abtestFlag:%b", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      a(paramJSONObject, "useXWebVideo", Boolean.valueOf(true));
    }
    for (;;)
    {
      a(paramJSONObject, "XWebVideoMinVersion", Integer.valueOf(300));
      return;
      a(paramJSONObject, "useXWebVideo", Boolean.valueOf(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e.d
 * JD-Core Version:    0.7.0.1
 */