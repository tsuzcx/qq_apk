package com.tencent.mm.plugin.appbrand.af;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.luggage.l.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
{
  private static DisplayMetrics uqe;
  private static Float uqf;
  private static boolean uqg;
  
  static
  {
    AppMethodBeat.i(140832);
    uqf = null;
    uqe = MMApplicationContext.getContext().getResources().getDisplayMetrics();
    uqg = true;
    AppMethodBeat.o(140832);
  }
  
  public static int DA(int paramInt)
  {
    AppMethodBeat.i(140813);
    paramInt = (int)Math.ceil(paramInt / mn());
    AppMethodBeat.o(140813);
    return paramInt;
  }
  
  public static int DB(int paramInt)
  {
    AppMethodBeat.i(140814);
    paramInt = (int)(paramInt / mn());
    AppMethodBeat.o(140814);
    return paramInt;
  }
  
  public static int DC(int paramInt)
  {
    AppMethodBeat.i(140816);
    paramInt = Math.round(mn() * paramInt);
    AppMethodBeat.o(140816);
    return paramInt;
  }
  
  public static float a(JSONObject paramJSONObject, String paramString, float paramFloat)
  {
    AppMethodBeat.i(140822);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(140822);
      return paramFloat;
    }
    double d = paramFloat;
    try
    {
      float f1 = (float)paramJSONObject.optDouble(paramString, d);
      float f2 = mn();
      AppMethodBeat.o(140822);
      return f2 * f1;
    }
    catch (Exception paramJSONObject)
    {
      AppMethodBeat.o(140822);
    }
    return paramFloat;
  }
  
  public static int a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    AppMethodBeat.i(140819);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(140819);
      return paramInt;
    }
    try
    {
      int i = Math.round((float)paramJSONObject.getDouble(paramString) * mn());
      AppMethodBeat.o(140819);
      return i;
    }
    catch (Exception paramJSONObject)
    {
      AppMethodBeat.o(140819);
    }
    return paramInt;
  }
  
  public static int agv(String paramString)
  {
    AppMethodBeat.i(140811);
    int i = dq(paramString, 0);
    AppMethodBeat.o(140811);
    return i;
  }
  
  public static int agw(String paramString)
  {
    AppMethodBeat.i(140812);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("colorString isEmpty");
      AppMethodBeat.o(140812);
      throw paramString;
    }
    if (g.uqd.containsKey(paramString))
    {
      i = ((Integer)g.uqd.get(paramString)).intValue();
      AppMethodBeat.o(140812);
      return i;
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
        i = (int)l;
        AppMethodBeat.o(140812);
        return i;
        if (((String)localObject).length() != 9)
        {
          Log.printInfoStack("MicroMsg.JsValueUtil", "hy: Unknown color, given string is %s", new Object[] { localObject });
          paramString = new IllegalArgumentException("Unknown color");
          AppMethodBeat.o(140812);
          throw paramString;
        }
      }
    }
    int i = Color.parseColor(paramString);
    AppMethodBeat.o(140812);
    return i;
  }
  
  public static float bV(float paramFloat)
  {
    AppMethodBeat.i(140815);
    paramFloat /= mn();
    AppMethodBeat.o(140815);
    return paramFloat;
  }
  
  public static float bW(float paramFloat)
  {
    AppMethodBeat.i(140817);
    float f = mn();
    AppMethodBeat.o(140817);
    return f * paramFloat;
  }
  
  public static void bX(float paramFloat)
  {
    AppMethodBeat.i(140830);
    if (paramFloat > 0.0F) {
      uqf = Float.valueOf(paramFloat);
    }
    AppMethodBeat.o(140830);
  }
  
  public static int c(JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(140823);
    paramInt = d(paramJSONArray, paramInt);
    AppMethodBeat.o(140823);
    return paramInt;
  }
  
  public static void cNj()
  {
    uqg = false;
  }
  
  private static int d(JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(140824);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(140824);
      return 0;
    }
    try
    {
      paramInt = Math.round((float)paramJSONArray.getDouble(paramInt) * mn());
      AppMethodBeat.o(140824);
      return paramInt;
    }
    catch (Exception paramJSONArray)
    {
      AppMethodBeat.o(140824);
    }
    return 0;
  }
  
  public static int dq(String paramString, int paramInt)
  {
    AppMethodBeat.i(140810);
    try
    {
      int i = agw(paramString);
      AppMethodBeat.o(140810);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(140810);
    }
    return paramInt;
  }
  
  public static float e(JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(140827);
    float f1 = (float)paramJSONArray.getDouble(paramInt);
    float f2 = mn();
    AppMethodBeat.o(140827);
    return f1 * f2;
  }
  
  public static float f(JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(140828);
    float f = g(paramJSONArray, paramInt);
    AppMethodBeat.o(140828);
    return f;
  }
  
  private static float g(JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(140829);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(140829);
      return 0.0F;
    }
    try
    {
      float f1 = (float)paramJSONArray.getDouble(paramInt);
      float f2 = mn();
      AppMethodBeat.o(140829);
      return f2 * f1;
    }
    catch (Exception paramJSONArray)
    {
      AppMethodBeat.o(140829);
    }
    return 0.0F;
  }
  
  public static int g(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(140818);
    int i = a(paramJSONObject, paramString, 0);
    AppMethodBeat.o(140818);
    return i;
  }
  
  public static int h(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(140820);
    int i = Math.round((float)paramJSONObject.getDouble(paramString) * mn());
    AppMethodBeat.o(140820);
    return i;
  }
  
  public static float i(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(140821);
    float f = a(paramJSONObject, paramString, 0.0F);
    AppMethodBeat.o(140821);
    return f;
  }
  
  public static float j(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(140826);
    float f1 = (float)paramJSONObject.getDouble(paramString);
    float f2 = mn();
    AppMethodBeat.o(140826);
    return f1 * f2;
  }
  
  public static float mn()
  {
    AppMethodBeat.i(140831);
    Object localObject = uqf;
    if (localObject != null)
    {
      f = ((Float)localObject).floatValue();
      AppMethodBeat.o(140831);
      return f;
    }
    localObject = uqe;
    if (localObject == null)
    {
      AppMethodBeat.o(140831);
      return 1.0F;
    }
    float f = ((DisplayMetrics)localObject).density;
    AppMethodBeat.o(140831);
    return f;
  }
  
  public static int u(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(140809);
    if ((paramJSONArray == null) || (paramJSONArray.length() < 3))
    {
      AppMethodBeat.o(140809);
      return 0;
    }
    if (paramJSONArray.length() == 3) {}
    for (int i = Color.rgb(paramJSONArray.optInt(0) & 0xFF, paramJSONArray.optInt(1) & 0xFF, paramJSONArray.optInt(2) & 0xFF);; i = Color.argb(paramJSONArray.optInt(3) & 0xFF, paramJSONArray.optInt(0) & 0xFF, paramJSONArray.optInt(1) & 0xFF, paramJSONArray.optInt(2) & 0xFF))
    {
      int j = i;
      if (uqg) {
        j = k.exm.mx(i);
      }
      AppMethodBeat.o(140809);
      return j;
    }
  }
  
  public static int v(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(140825);
    int i = Math.round((float)paramJSONArray.getDouble(0) * mn());
    AppMethodBeat.o(140825);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.i
 * JD-Core Version:    0.7.0.1
 */