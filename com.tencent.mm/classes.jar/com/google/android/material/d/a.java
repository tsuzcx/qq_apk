package com.google.android.material.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static boolean Y(float paramFloat1, float paramFloat2)
  {
    return 1.0E-004F + paramFloat1 >= paramFloat2;
  }
  
  private static float k(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(208911);
    paramFloat1 = (float)Math.hypot(paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
    AppMethodBeat.o(208911);
    return paramFloat1;
  }
  
  public static float l(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(208919);
    paramFloat1 = max(k(paramFloat1, paramFloat2, 0.0F, 0.0F), k(paramFloat1, paramFloat2, paramFloat3, 0.0F), k(paramFloat1, paramFloat2, paramFloat3, paramFloat4), k(paramFloat1, paramFloat2, 0.0F, paramFloat4));
    AppMethodBeat.o(208919);
    return paramFloat1;
  }
  
  public static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (1.0F - paramFloat3) * paramFloat1 + paramFloat3 * paramFloat2;
  }
  
  private static float max(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramFloat1 > paramFloat2) && (paramFloat1 > paramFloat3) && (paramFloat1 > paramFloat4)) {
      return paramFloat1;
    }
    if ((paramFloat2 > paramFloat3) && (paramFloat2 > paramFloat4)) {
      return paramFloat2;
    }
    if (paramFloat3 > paramFloat4) {
      return paramFloat3;
    }
    return paramFloat4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.d.a
 * JD-Core Version:    0.7.0.1
 */