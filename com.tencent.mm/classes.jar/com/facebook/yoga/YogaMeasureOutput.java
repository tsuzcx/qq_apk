package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YogaMeasureOutput
{
  public static float getHeight(long paramLong)
  {
    AppMethodBeat.i(18103);
    float f = Float.intBitsToFloat((int)(0xFFFFFFFF & paramLong));
    AppMethodBeat.o(18103);
    return f;
  }
  
  public static float getWidth(long paramLong)
  {
    AppMethodBeat.i(18102);
    float f = Float.intBitsToFloat((int)(0xFFFFFFFF & paramLong >> 32));
    AppMethodBeat.o(18102);
    return f;
  }
  
  public static long make(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(18100);
    int i = Float.floatToRawIntBits(paramFloat1);
    int j = Float.floatToRawIntBits(paramFloat2);
    long l1 = i;
    long l2 = j;
    AppMethodBeat.o(18100);
    return l2 | l1 << 32;
  }
  
  public static long make(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18101);
    long l = make(paramInt1, paramInt2);
    AppMethodBeat.o(18101);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.yoga.YogaMeasureOutput
 * JD-Core Version:    0.7.0.1
 */