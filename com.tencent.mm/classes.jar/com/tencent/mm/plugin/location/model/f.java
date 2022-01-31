package com.tencent.mm.plugin.location.model;

import com.tencent.mm.pluginsdk.q;

public final class f
{
  private static double guV = -85.0D;
  private static double guW = -1000.0D;
  private static double guX = -85.0D;
  private static double guY = -1000.0D;
  
  public static boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt, double paramDouble5)
  {
    if (paramInt == 0)
    {
      if (paramDouble5 == 0.0D) {}
      while (paramDouble5 <= 0.0D) {
        return false;
      }
    }
    for (;;)
    {
      return true;
      if (paramInt != 1) {
        break;
      }
      if ((paramDouble2 == -85.0D) || (paramDouble1 == -1000.0D)) {
        paramInt = 0;
      }
      while (paramInt == 0)
      {
        return false;
        if ((paramDouble3 == -1000.0D) || (paramDouble4 == -85.0D)) {
          paramInt = 0;
        } else if (q.c(paramDouble2, paramDouble1, paramDouble4, paramDouble3) >= 5.0D) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
      }
    }
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
  
  public static double s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return Math.sqrt((paramInt1 - paramInt3) * (paramInt1 - paramInt3) + (paramInt2 - paramInt4) * (paramInt2 - paramInt4));
  }
  
  public static boolean t(double paramDouble)
  {
    return paramDouble >= 4.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.f
 * JD-Core Version:    0.7.0.1
 */