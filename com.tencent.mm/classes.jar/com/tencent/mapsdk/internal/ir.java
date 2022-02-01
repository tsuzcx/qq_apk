package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ir
{
  public static double a(long paramLong, float paramFloat)
  {
    float f = (float)paramLong / 5000.0F;
    return (f - 2.0F) * (-paramFloat * f) + 0.0F;
  }
  
  public static double a(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    return (float)paramLong1 * paramFloat2 / (float)paramLong2 + paramFloat1;
  }
  
  private static double b(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    float f = (float)paramLong1 / (float)paramLong2;
    return f * (paramFloat2 * f) + paramFloat1;
  }
  
  private static double c(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    paramLong1 = ((float)paramLong1 / ((float)paramLong2 / 2.0F));
    if (paramLong1 < 1L)
    {
      paramFloat2 /= 2.0F;
      float f = (float)paramLong1;
      return (float)paramLong1 * (paramFloat2 * f) + paramFloat1;
    }
    paramFloat2 = -paramFloat2 / 2.0F;
    paramLong1 -= 1L;
    return (float)(paramLong1 * (paramLong1 - 2L) - 1L) * paramFloat2 + paramFloat1;
  }
  
  private static double d(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    AppMethodBeat.i(223129);
    double d1 = paramFloat2;
    double d2 = Math.pow(paramLong1 / paramLong2, 3.0D);
    double d3 = paramFloat1;
    AppMethodBeat.o(223129);
    return d1 * d2 + d3;
  }
  
  private static double e(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    AppMethodBeat.i(223137);
    double d1 = paramFloat2;
    double d2 = Math.pow((float)paramLong1 / (float)paramLong2 - 1.0F, 3.0D);
    double d3 = paramFloat1;
    AppMethodBeat.o(223137);
    return d1 * (d2 + 1.0D) + d3;
  }
  
  private static double f(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    AppMethodBeat.i(223146);
    paramLong1 /= paramLong2 / 2L;
    if (paramLong1 < 1L)
    {
      d1 = paramFloat2 / 2.0F;
      d2 = Math.pow(paramLong1, 3.0D);
      d3 = paramFloat1;
      AppMethodBeat.o(223146);
      return d2 * d1 + d3;
    }
    double d1 = paramFloat2 / 2.0F;
    double d2 = Math.pow(paramLong1 - 2L, 3.0D);
    double d3 = paramFloat1;
    AppMethodBeat.o(223146);
    return (d2 + 2.0D) * d1 + d3;
  }
  
  private static double g(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    float f = (float)paramLong1 / (float)paramLong2;
    return f * (paramFloat2 * f * f * f) + paramFloat1;
  }
  
  private static double h(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    float f = (float)(paramLong1 / (paramLong2 - 1L));
    return (f * (f * f * f) - 1.0F) * -paramFloat2 + paramFloat1;
  }
  
  private static double i(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    paramLong1 /= paramLong2 / 2L;
    if (paramLong1 < 1L)
    {
      paramFloat2 /= 2.0F;
      float f1 = (float)paramLong1;
      float f2 = (float)paramLong1;
      float f3 = (float)paramLong1;
      return (float)paramLong1 * (paramFloat2 * f1 * f2 * f3) + paramFloat1;
    }
    paramFloat2 = -paramFloat2 / 2.0F;
    paramLong1 -= 2L;
    return (float)(paramLong1 * (paramLong1 * paramLong1 * paramLong1) - 2L) * paramFloat2 + paramFloat1;
  }
  
  private static double j(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    paramLong1 /= paramLong2;
    float f1 = (float)paramLong1;
    float f2 = (float)paramLong1;
    float f3 = (float)paramLong1;
    float f4 = (float)paramLong1;
    return (float)paramLong1 * (f1 * paramFloat2 * f2 * f3 * f4) + paramFloat1;
  }
  
  private static double k(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    paramLong1 = paramLong1 / paramLong2 - 1L;
    return (float)(paramLong1 * (paramLong1 * paramLong1 * paramLong1 * paramLong1) + 1L) * paramFloat2 + paramFloat1;
  }
  
  private static double l(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    paramLong1 /= paramLong2 / 2L;
    if (paramLong1 < 1L)
    {
      paramFloat2 /= 2.0F;
      float f1 = (float)paramLong1;
      float f2 = (float)paramLong1;
      float f3 = (float)paramLong1;
      float f4 = (float)paramLong1;
      return (float)paramLong1 * (paramFloat2 * f1 * f2 * f3 * f4) + paramFloat1;
    }
    paramFloat2 /= 2.0F;
    paramLong1 -= 2L;
    return (float)(paramLong1 * (paramLong1 * paramLong1 * paramLong1 * paramLong1) + 2L) * paramFloat2 + paramFloat1;
  }
  
  private static double m(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    AppMethodBeat.i(223201);
    double d1 = paramFloat2;
    double d2 = Math.cos(paramLong1 / paramLong2 * 1.570796326794897D);
    double d3 = paramFloat1;
    AppMethodBeat.o(223201);
    return d1 * (1.0D - d2) + d3;
  }
  
  private static double n(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    AppMethodBeat.i(223208);
    double d1 = paramFloat2;
    double d2 = Math.sin(paramLong1 / paramLong2 * 1.570796326794897D);
    double d3 = paramFloat1;
    AppMethodBeat.o(223208);
    return d1 * d2 + d3;
  }
  
  private static double o(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    AppMethodBeat.i(223219);
    double d1 = paramFloat2 / 2.0F;
    double d2 = Math.cos(3.141592653589793D * paramLong1 / paramLong2);
    double d3 = paramFloat1;
    AppMethodBeat.o(223219);
    return d1 * (1.0D - d2) + d3;
  }
  
  private static double p(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    AppMethodBeat.i(223226);
    double d1 = paramFloat2;
    double d2 = Math.pow(2.0D, 10L * (paramLong1 / paramLong2 - 1L));
    double d3 = paramFloat1;
    AppMethodBeat.o(223226);
    return d1 * d2 + d3;
  }
  
  private static double q(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    AppMethodBeat.i(223234);
    double d1 = paramFloat2;
    double d2 = -Math.pow(2.0D, -10L * paramLong1 / paramLong2);
    double d3 = paramFloat1;
    AppMethodBeat.o(223234);
    return d1 * (d2 + 1.0D) + d3;
  }
  
  private static double r(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    AppMethodBeat.i(223246);
    double d1 = paramFloat2;
    paramLong1 /= paramLong2;
    double d2 = Math.sqrt(1L - paramLong1 * paramLong1);
    double d3 = paramFloat1;
    AppMethodBeat.o(223246);
    return d1 * (1.0D - d2) + d3;
  }
  
  private static double s(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    AppMethodBeat.i(223256);
    double d1 = paramFloat2;
    paramLong1 /= (paramLong2 - 1L);
    double d2 = Math.sqrt(1L - paramLong1 * paramLong1);
    double d3 = paramFloat1;
    AppMethodBeat.o(223256);
    return d1 * d2 + d3;
  }
  
  private static double t(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    AppMethodBeat.i(223270);
    paramLong1 /= paramLong2 / 2L;
    if (paramLong1 < 1L)
    {
      d1 = paramFloat2 / 2.0F;
      d2 = Math.sqrt(1L - paramLong1 * paramLong1);
      d3 = paramFloat1;
      AppMethodBeat.o(223270);
      return (1.0D - d2) * d1 + d3;
    }
    double d1 = paramFloat2 / 2.0F;
    paramLong1 -= 2L;
    double d2 = Math.sqrt(1L - paramLong1 * paramLong1);
    double d3 = paramFloat1;
    AppMethodBeat.o(223270);
    return (d2 + 1.0D) * d1 + d3;
  }
  
  private static double u(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    paramLong1 /= paramLong2 / 2L;
    if (paramLong1 < 1L)
    {
      paramFloat2 /= 2.0F;
      return (float)((paramLong1 * 4L - 3L) * (paramLong1 * paramLong1)) * paramFloat2 + paramFloat1;
    }
    paramFloat2 /= 2.0F;
    paramLong1 -= 2L;
    return (float)((paramLong1 * 4L + 3L) * (paramLong1 * paramLong1) + 2L) * paramFloat2 + paramFloat1;
  }
  
  private static double v(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    paramLong1 /= paramLong2;
    float f1 = (float)paramLong1;
    float f2 = (float)paramLong1;
    return (float)(paramLong1 * 21L - 20L) * (f1 * paramFloat2 * f2) + paramFloat1;
  }
  
  private static double w(long paramLong1, float paramFloat1, float paramFloat2, long paramLong2)
  {
    paramLong1 = paramLong1 / paramLong2 - 1L;
    return (float)((paramLong1 * 21L + 20L) * (paramLong1 * paramLong1) + 1L) * paramFloat2 + paramFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ir
 * JD-Core Version:    0.7.0.1
 */