package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.Map;
import org.json.JSONObject;

public final class f
{
  private static double jVG = -85.0D;
  private static double jVH = -1000.0D;
  private static double jVI = -85.0D;
  private static double jVJ = -1000.0D;
  
  public static int Q(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143714);
    try
    {
      int i = paramJSONObject.optInt("mapId");
      AppMethodBeat.o(143714);
      return i;
    }
    catch (Exception paramJSONObject)
    {
      AppMethodBeat.o(143714);
    }
    return -1;
  }
  
  public static int a(Map<String, Object> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(143716);
    paramMap = cw(paramMap.get(paramString));
    if (paramMap != null)
    {
      paramInt = paramMap.intValue();
      AppMethodBeat.o(143716);
      return paramInt;
    }
    AppMethodBeat.o(143716);
    return paramInt;
  }
  
  public static String a(Map<String, Object> paramMap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(143715);
    paramMap = paramMap.get(paramString1);
    if ((paramMap instanceof String)) {
      paramMap = (String)paramMap;
    }
    while (paramMap != null)
    {
      AppMethodBeat.o(143715);
      return paramMap;
      if (paramMap != null) {
        paramMap = String.valueOf(paramMap);
      } else {
        paramMap = null;
      }
    }
    AppMethodBeat.o(143715);
    return paramString2;
  }
  
  public static boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, String paramString, double paramDouble5)
  {
    AppMethodBeat.i(143711);
    boolean bool = false;
    if (f.a.jVK.name().equalsIgnoreCase(paramString))
    {
      if (paramDouble5 == 0.0D) {
        bool = false;
      }
      while (paramDouble5 <= 0.0D)
      {
        AppMethodBeat.o(143711);
        return bool;
      }
    }
    label246:
    for (;;)
    {
      bool = true;
      break;
      if (!f.a.jVL.name().equalsIgnoreCase(paramString)) {
        break;
      }
      int i;
      if ((paramDouble2 == -85.0D) || (paramDouble1 == -1000.0D)) {
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          break label246;
        }
        bool = false;
        break;
        if ((paramDouble3 == -1000.0D) || (paramDouble4 == -85.0D))
        {
          i = 0;
        }
        else
        {
          paramDouble2 = 3.141592653589793D * paramDouble2 / 180.0D;
          paramDouble4 = 3.141592653589793D * paramDouble4 / 180.0D;
          paramDouble1 = (paramDouble1 - paramDouble3) * 3.141592653589793D / 180.0D;
          paramDouble3 = Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D);
          if (Math.round(Math.asin(Math.sqrt(Math.cos(paramDouble2) * Math.cos(paramDouble4) * Math.pow(Math.sin(paramDouble1 / 2.0D), 2.0D) + paramDouble3)) * 2.0D * 6378137.0D * 10000.0D) / 10000L >= 5.0D) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    }
  }
  
  public static float au(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      return paramFloat % 360.0F;
    }
    return (((int)paramFloat * -1 / 360 + 1) * 360 + paramFloat) % 360.0F;
  }
  
  private static Integer cw(Object paramObject)
  {
    AppMethodBeat.i(143717);
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      AppMethodBeat.o(143717);
      return paramObject;
    }
    int i;
    if ((paramObject instanceof Number))
    {
      i = ((Number)paramObject).intValue();
      AppMethodBeat.o(143717);
      return Integer.valueOf(i);
    }
    if ((paramObject instanceof String)) {
      try
      {
        i = (int)Double.parseDouble((String)paramObject);
        AppMethodBeat.o(143717);
        return Integer.valueOf(i);
      }
      catch (NumberFormatException paramObject) {}
    }
    AppMethodBeat.o(143717);
    return null;
  }
  
  public static double h(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(143712);
    jVI = paramDouble1;
    jVJ = paramDouble2;
    if ((jVG == -85.0D) || (jVH == -1000.0D)) {}
    for (paramDouble1 = 0.0D;; paramDouble1 = Math.atan2(jVJ - jVH, jVI - jVG) * 180.0D / 3.141592D)
    {
      jVG = jVI;
      jVH = jVJ;
      AppMethodBeat.o(143712);
      return paramDouble1;
    }
  }
  
  public static String i(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143713);
    int i = Q(paramJSONObject);
    if (i == -1)
    {
      AppMethodBeat.o(143713);
      return "invalid_map_id";
    }
    paramc = paramc.aOd() + "&" + i;
    AppMethodBeat.o(143713);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.f
 * JD-Core Version:    0.7.0.1
 */