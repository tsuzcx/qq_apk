package com.tencent.mm.plugin.appbrand.jsapi.g.a;

public final class e
{
  private static double guV = -85.0D;
  private static double guW = -1000.0D;
  private static double guX = -85.0D;
  private static double guY = -1000.0D;
  
  public static boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, String paramString, double paramDouble5)
  {
    if (e.a.guZ.name().equalsIgnoreCase(paramString))
    {
      if (paramDouble5 == 0.0D) {}
      while (paramDouble5 <= 0.0D) {
        return false;
      }
    }
    for (;;)
    {
      return true;
      if (!e.a.gva.name().equalsIgnoreCase(paramString)) {
        break;
      }
      int i;
      if ((paramDouble2 == -85.0D) || (paramDouble1 == -1000.0D)) {
        i = 0;
      }
      while (i == 0)
      {
        return false;
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
  
  public static float ag(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      return paramFloat % 360.0F;
    }
    return (((int)paramFloat * -1 / 360 + 1) * 360 + paramFloat) % 360.0F;
  }
  
  public static double f(double paramDouble1, double paramDouble2)
  {
    guX = paramDouble1;
    guY = paramDouble2;
    if ((guV == -85.0D) || (guW == -1000.0D)) {}
    for (paramDouble1 = 0.0D;; paramDouble1 = Math.atan2(guY - guW, guX - guV) * 180.0D / 3.141592D)
    {
      guV = guX;
      guW = guY;
      return paramDouble1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.e
 * JD-Core Version:    0.7.0.1
 */