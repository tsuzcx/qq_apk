package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.t;

public final class f
{
  private static double hPR = -85.0D;
  private static double hPS = -1000.0D;
  private static double hPT = -85.0D;
  private static double hPU = -1000.0D;
  
  public static boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt, double paramDouble5)
  {
    AppMethodBeat.i(113310);
    boolean bool = false;
    if (paramInt == 0)
    {
      if (paramDouble5 == 0.0D) {
        bool = false;
      }
      while (paramDouble5 <= 0.0D)
      {
        AppMethodBeat.o(113310);
        return bool;
      }
    }
    label130:
    for (;;)
    {
      bool = true;
      break;
      if (paramInt != 1) {
        break;
      }
      if ((paramDouble2 == -85.0D) || (paramDouble1 == -1000.0D)) {
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt != 0) {
          break label130;
        }
        bool = false;
        break;
        if ((paramDouble3 == -1000.0D) || (paramDouble4 == -85.0D)) {
          paramInt = 0;
        } else if (t.c(paramDouble2, paramDouble1, paramDouble4, paramDouble3) >= 5.0D) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
      }
    }
  }
  
  public static double h(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(113309);
    hPT = paramDouble1;
    hPU = paramDouble2;
    if ((hPR == -85.0D) || (hPS == -1000.0D)) {}
    for (paramDouble1 = 0.0D;; paramDouble1 = Math.atan2(hPU - hPS, hPT - hPR) * 180.0D / 3.141592D)
    {
      hPR = hPT;
      hPS = hPU;
      AppMethodBeat.o(113309);
      return paramDouble1;
    }
  }
  
  public static boolean w(double paramDouble)
  {
    return paramDouble >= 4.0D;
  }
  
  public static double y(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(113311);
    double d = Math.sqrt((paramInt1 - paramInt3) * (paramInt1 - paramInt3) + (paramInt2 - paramInt4) * (paramInt2 - paramInt4));
    AppMethodBeat.o(113311);
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.f
 * JD-Core Version:    0.7.0.1
 */