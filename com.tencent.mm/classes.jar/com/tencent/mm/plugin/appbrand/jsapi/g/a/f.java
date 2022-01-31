package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.Map;
import org.json.JSONObject;

public final class f
{
  private static double hPR = -85.0D;
  private static double hPS = -1000.0D;
  private static double hPT = -85.0D;
  private static double hPU = -1000.0D;
  
  public static int G(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(93892);
    try
    {
      int i = paramJSONObject.optInt("mapId");
      AppMethodBeat.o(93892);
      return i;
    }
    catch (Exception paramJSONObject)
    {
      AppMethodBeat.o(93892);
    }
    return -1;
  }
  
  public static int a(Map<String, Object> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(93894);
    paramMap = bk(paramMap.get(paramString));
    if (paramMap != null)
    {
      paramInt = paramMap.intValue();
      AppMethodBeat.o(93894);
      return paramInt;
    }
    AppMethodBeat.o(93894);
    return paramInt;
  }
  
  public static String a(Map<String, Object> paramMap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(93893);
    paramMap = paramMap.get(paramString1);
    if ((paramMap instanceof String)) {
      paramMap = (String)paramMap;
    }
    while (paramMap != null)
    {
      AppMethodBeat.o(93893);
      return paramMap;
      if (paramMap != null) {
        paramMap = String.valueOf(paramMap);
      } else {
        paramMap = null;
      }
    }
    AppMethodBeat.o(93893);
    return paramString2;
  }
  
  public static boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, String paramString, double paramDouble5)
  {
    AppMethodBeat.i(93889);
    boolean bool = false;
    if (a.hPV.name().equalsIgnoreCase(paramString))
    {
      if (paramDouble5 == 0.0D) {
        bool = false;
      }
      while (paramDouble5 <= 0.0D)
      {
        AppMethodBeat.o(93889);
        return bool;
      }
    }
    label246:
    for (;;)
    {
      bool = true;
      break;
      if (!a.hPW.name().equalsIgnoreCase(paramString)) {
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
  
  public static float av(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      return paramFloat % 360.0F;
    }
    return (((int)paramFloat * -1 / 360 + 1) * 360 + paramFloat) % 360.0F;
  }
  
  private static Integer bk(Object paramObject)
  {
    AppMethodBeat.i(93895);
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      AppMethodBeat.o(93895);
      return paramObject;
    }
    int i;
    if ((paramObject instanceof Number))
    {
      i = ((Number)paramObject).intValue();
      AppMethodBeat.o(93895);
      return Integer.valueOf(i);
    }
    if ((paramObject instanceof String)) {
      try
      {
        i = (int)Double.parseDouble((String)paramObject);
        AppMethodBeat.o(93895);
        return Integer.valueOf(i);
      }
      catch (NumberFormatException paramObject) {}
    }
    AppMethodBeat.o(93895);
    return null;
  }
  
  public static String g(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(93891);
    int i = G(paramJSONObject);
    if (i == -1)
    {
      AppMethodBeat.o(93891);
      return "invalid_map_id";
    }
    paramc = paramc.aAN() + "&" + i;
    AppMethodBeat.o(93891);
    return paramc;
  }
  
  public static double h(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(93890);
    hPT = paramDouble1;
    hPU = paramDouble2;
    if ((hPR == -85.0D) || (hPS == -1000.0D)) {}
    for (paramDouble1 = 0.0D;; paramDouble1 = Math.atan2(hPU - hPS, hPT - hPR) * 180.0D / 3.141592D)
    {
      hPR = hPT;
      hPS = hPU;
      AppMethodBeat.o(93890);
      return paramDouble1;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(93888);
      hPV = new a("GPS", 0);
      hPW = new a("NETWORK", 1);
      hPX = new a[] { hPV, hPW };
      AppMethodBeat.o(93888);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.f
 * JD-Core Version:    0.7.0.1
 */