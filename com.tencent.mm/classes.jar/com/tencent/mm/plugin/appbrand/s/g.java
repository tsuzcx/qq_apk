package com.tencent.mm.plugin.appbrand.s;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
{
  private static DisplayMetrics iXq;
  private static Float iXr;
  
  static
  {
    AppMethodBeat.i(91161);
    iXr = null;
    iXq = new DisplayMetrics();
    ((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(iXq);
    AppMethodBeat.o(91161);
  }
  
  public static int Fm(String paramString)
  {
    AppMethodBeat.i(91146);
    int i = bA(paramString, 0);
    AppMethodBeat.o(91146);
    return i;
  }
  
  public static int Fn(String paramString)
  {
    AppMethodBeat.i(91147);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("colorString isEmpty");
      AppMethodBeat.o(91147);
      throw paramString;
    }
    if (f.iXp.containsKey(paramString))
    {
      i = ((Integer)f.iXp.get(paramString)).intValue();
      AppMethodBeat.o(91147);
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
        AppMethodBeat.o(91147);
        return i;
        if (((String)localObject).length() != 9)
        {
          ab.b("MicroMsg.JsValueUtil", "hy: Unknown color, given string is %s", new Object[] { localObject });
          paramString = new IllegalArgumentException("Unknown color");
          AppMethodBeat.o(91147);
          throw paramString;
        }
      }
    }
    int i = Color.parseColor(paramString);
    AppMethodBeat.o(91147);
    return i;
  }
  
  public static float a(JSONObject paramJSONObject, String paramString, float paramFloat)
  {
    AppMethodBeat.i(91153);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(91153);
      return paramFloat;
    }
    double d = paramFloat;
    try
    {
      float f1 = (float)paramJSONObject.optDouble(paramString, d);
      float f2 = aNP();
      AppMethodBeat.o(91153);
      return f2 * f1;
    }
    catch (Exception paramJSONObject)
    {
      AppMethodBeat.o(91153);
    }
    return paramFloat;
  }
  
  public static int a(JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(91154);
    paramInt = b(paramJSONArray, paramInt);
    AppMethodBeat.o(91154);
    return paramInt;
  }
  
  public static int a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    AppMethodBeat.i(91150);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(91150);
      return paramInt;
    }
    try
    {
      int i = Math.round((float)paramJSONObject.getDouble(paramString) * aNP());
      AppMethodBeat.o(91150);
      return i;
    }
    catch (Exception paramJSONObject)
    {
      AppMethodBeat.o(91150);
    }
    return paramInt;
  }
  
  public static float aA(float paramFloat)
  {
    AppMethodBeat.i(141836);
    float f = aNP();
    AppMethodBeat.o(141836);
    return f * paramFloat;
  }
  
  public static void aB(float paramFloat)
  {
    AppMethodBeat.i(141837);
    if (paramFloat > 0.0F) {
      iXr = Float.valueOf(paramFloat);
    }
    AppMethodBeat.o(141837);
  }
  
  public static float aNP()
  {
    AppMethodBeat.i(141838);
    Object localObject = iXr;
    if (localObject != null)
    {
      f = ((Float)localObject).floatValue();
      AppMethodBeat.o(141838);
      return f;
    }
    localObject = iXq;
    if (localObject == null)
    {
      AppMethodBeat.o(141838);
      return 1.0F;
    }
    float f = ((DisplayMetrics)localObject).density;
    AppMethodBeat.o(141838);
    return f;
  }
  
  public static float az(float paramFloat)
  {
    AppMethodBeat.i(141834);
    paramFloat /= aNP();
    AppMethodBeat.o(141834);
    return paramFloat;
  }
  
  private static int b(JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(91155);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(91155);
      return 0;
    }
    try
    {
      paramInt = Math.round((float)paramJSONArray.getDouble(paramInt) * aNP());
      AppMethodBeat.o(91155);
      return paramInt;
    }
    catch (Exception paramJSONArray)
    {
      AppMethodBeat.o(91155);
    }
    return 0;
  }
  
  public static int bA(String paramString, int paramInt)
  {
    AppMethodBeat.i(91145);
    try
    {
      int i = Fn(paramString);
      AppMethodBeat.o(91145);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(91145);
    }
    return paramInt;
  }
  
  public static float c(JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(91158);
    float f1 = (float)paramJSONArray.getDouble(paramInt);
    float f2 = aNP();
    AppMethodBeat.o(91158);
    return f1 * f2;
  }
  
  public static float d(JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(91159);
    float f = e(paramJSONArray, paramInt);
    AppMethodBeat.o(91159);
    return f;
  }
  
  private static float e(JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(91160);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(91160);
      return 0.0F;
    }
    try
    {
      float f1 = (float)paramJSONArray.getDouble(paramInt);
      float f2 = aNP();
      AppMethodBeat.o(91160);
      return f2 * f1;
    }
    catch (Exception paramJSONArray)
    {
      AppMethodBeat.o(91160);
    }
    return 0.0F;
  }
  
  public static int f(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(91149);
    int i = a(paramJSONObject, paramString, 0);
    AppMethodBeat.o(91149);
    return i;
  }
  
  public static int g(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(91151);
    int i = Math.round((float)paramJSONObject.getDouble(paramString) * aNP());
    AppMethodBeat.o(91151);
    return i;
  }
  
  public static float h(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(91152);
    float f = a(paramJSONObject, paramString, 0.0F);
    AppMethodBeat.o(91152);
    return f;
  }
  
  public static float i(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(91157);
    float f1 = (float)paramJSONObject.getDouble(paramString);
    float f2 = aNP();
    AppMethodBeat.o(91157);
    return f1 * f2;
  }
  
  public static int o(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(91144);
    if ((paramJSONArray == null) || (paramJSONArray.length() < 3))
    {
      AppMethodBeat.o(91144);
      return 0;
    }
    if (paramJSONArray.length() == 3) {}
    for (int i = Color.rgb(paramJSONArray.optInt(0) & 0xFF, paramJSONArray.optInt(1) & 0xFF, paramJSONArray.optInt(2) & 0xFF);; i = Color.argb(paramJSONArray.optInt(3) & 0xFF, paramJSONArray.optInt(0) & 0xFF, paramJSONArray.optInt(1) & 0xFF, paramJSONArray.optInt(2) & 0xFF))
    {
      AppMethodBeat.o(91144);
      return i;
    }
  }
  
  public static int p(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(91156);
    int i = Math.round((float)paramJSONArray.getDouble(0) * aNP());
    AppMethodBeat.o(91156);
    return i;
  }
  
  public static int pM(int paramInt)
  {
    AppMethodBeat.i(91148);
    paramInt = (int)Math.ceil(paramInt / aNP());
    AppMethodBeat.o(91148);
    return paramInt;
  }
  
  public static int pN(int paramInt)
  {
    AppMethodBeat.i(141833);
    paramInt = (int)(paramInt / aNP());
    AppMethodBeat.o(141833);
    return paramInt;
  }
  
  public static int pO(int paramInt)
  {
    AppMethodBeat.i(141835);
    paramInt = Math.round(aNP() * paramInt);
    AppMethodBeat.o(141835);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.g
 * JD-Core Version:    0.7.0.1
 */