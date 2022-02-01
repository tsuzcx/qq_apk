package com.google.android.material.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static float h(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(238409);
    paramFloat1 = (float)Math.hypot(paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
    AppMethodBeat.o(238409);
    return paramFloat1;
  }
  
  public static float i(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(238412);
    paramFloat1 = j(h(paramFloat1, paramFloat2, 0.0F, 0.0F), h(paramFloat1, paramFloat2, paramFloat3, 0.0F), h(paramFloat1, paramFloat2, paramFloat3, paramFloat4), h(paramFloat1, paramFloat2, 0.0F, paramFloat4));
    AppMethodBeat.o(238412);
    return paramFloat1;
  }
  
  private static float j(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
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
  
  public static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (1.0F - paramFloat3) * paramFloat1 + paramFloat3 * paramFloat2;
  }
  
  public static boolean s(float paramFloat1, float paramFloat2)
  {
    return 1.0E-004F + paramFloat1 >= paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.d.a
 * JD-Core Version:    0.7.0.1
 */