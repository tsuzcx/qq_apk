package com.tencent.mm.plugin.appbrand.u;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h
{
  private static DisplayMetrics hkX = ae.getContext().getResources().getDisplayMetrics();
  
  public static float a(JSONObject paramJSONObject, String paramString, float paramFloat)
  {
    if (paramJSONObject == null) {
      return paramFloat;
    }
    double d = paramFloat;
    try
    {
      float f = am((float)paramJSONObject.optDouble(paramString, d));
      return f;
    }
    catch (Exception paramJSONObject) {}
    return paramFloat;
  }
  
  public static int a(JSONArray paramJSONArray, int paramInt)
  {
    return b(paramJSONArray, paramInt);
  }
  
  public static int a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if (paramJSONObject == null) {
      return paramInt;
    }
    try
    {
      int i = Math.round(am((float)paramJSONObject.getDouble(paramString)));
      return i;
    }
    catch (Exception paramJSONObject) {}
    return paramInt;
  }
  
  public static float al(float paramFloat)
  {
    if (hkX == null) {
      return paramFloat;
    }
    return paramFloat / hkX.density;
  }
  
  public static float am(float paramFloat)
  {
    if (hkX == null) {
      return paramFloat;
    }
    return paramFloat * hkX.density;
  }
  
  public static float aqo()
  {
    if (hkX == null) {
      return 1.0F;
    }
    return hkX.density;
  }
  
  private static int b(JSONArray paramJSONArray, int paramInt)
  {
    if (paramJSONArray == null) {
      return 0;
    }
    try
    {
      paramInt = Math.round(am((float)paramJSONArray.getDouble(paramInt)));
      return paramInt;
    }
    catch (Exception paramJSONArray) {}
    return 0;
  }
  
  public static int bd(String paramString, int paramInt)
  {
    try
    {
      int i = wE(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public static float c(JSONArray paramJSONArray, int paramInt)
  {
    return am((float)paramJSONArray.getDouble(paramInt));
  }
  
  public static float d(JSONArray paramJSONArray, int paramInt)
  {
    return e(paramJSONArray, paramInt);
  }
  
  private static float e(JSONArray paramJSONArray, int paramInt)
  {
    if (paramJSONArray == null) {
      return 0.0F;
    }
    try
    {
      float f = am((float)paramJSONArray.getDouble(paramInt));
      return f;
    }
    catch (Exception paramJSONArray) {}
    return 0.0F;
  }
  
  public static int h(JSONObject paramJSONObject, String paramString)
  {
    return a(paramJSONObject, paramString, 0);
  }
  
  public static int i(JSONObject paramJSONObject, String paramString)
  {
    return Math.round(am((float)paramJSONObject.getDouble(paramString)));
  }
  
  public static float j(JSONObject paramJSONObject, String paramString)
  {
    return a(paramJSONObject, paramString, 0.0F);
  }
  
  public static float k(JSONObject paramJSONObject, String paramString)
  {
    return am((float)paramJSONObject.getDouble(paramString));
  }
  
  public static int l(JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() < 3)) {
      return 0;
    }
    if (paramJSONArray.length() == 3) {
      return Color.rgb(paramJSONArray.optInt(0) & 0xFF, paramJSONArray.optInt(1) & 0xFF, paramJSONArray.optInt(2) & 0xFF);
    }
    return Color.argb(paramJSONArray.optInt(3) & 0xFF, paramJSONArray.optInt(0) & 0xFF, paramJSONArray.optInt(1) & 0xFF, paramJSONArray.optInt(2) & 0xFF);
  }
  
  public static int m(JSONArray paramJSONArray)
  {
    return Math.round(am((float)paramJSONArray.getDouble(0)));
  }
  
  public static int mw(int paramInt)
  {
    if (hkX == null) {
      return paramInt;
    }
    return Math.round(paramInt / hkX.density);
  }
  
  public static int mx(int paramInt)
  {
    if (hkX == null) {
      return paramInt;
    }
    return (int)(paramInt / hkX.density);
  }
  
  public static int my(int paramInt)
  {
    if (hkX == null) {
      return paramInt;
    }
    return (int)(hkX.density * paramInt);
  }
  
  public static int wE(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0;
    }
    if (g.hkW.containsKey(paramString)) {
      return ((Integer)g.hkW.get(paramString)).intValue();
    }
    if (paramString.charAt(0) == '#')
    {
      Object localObject = paramString;
      if (paramString.length() == 4)
      {
        localObject = new StringBuilder(paramString);
        ((StringBuilder)localObject).insert(2, paramString.charAt(1));
        ((StringBuilder)localObject).insert(4, paramString.charAt(2));
        ((StringBuilder)localObject).insert(6, paramString.charAt(3));
        localObject = ((StringBuilder)localObject).toString();
      }
      if (((String)localObject).length() == 7) {}
      for (long l = Long.parseLong(((String)localObject).substring(1), 16) | 0xFF000000;; l = Long.parseLong(((String)localObject).substring(1, 7), 16) | Long.parseLong(((String)localObject).substring(7, 9), 16) << 24)
      {
        return (int)l;
        if (((String)localObject).length() != 9)
        {
          y.l("MicroMsg.JsValueUtil", "hy: Unknown color, given string is %s", new Object[] { localObject });
          return 0;
        }
      }
    }
    try
    {
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (IllegalArgumentException paramString) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.h
 * JD-Core Version:    0.7.0.1
 */