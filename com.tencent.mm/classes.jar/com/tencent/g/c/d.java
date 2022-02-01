package com.tencent.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public static final int[] ahVX = { 118, 28, 44, -104, -48, -42, -86, -20, 116, 86, -120, 116, 15, -72, 74, -76 };
  public static final int[] ahVY = { 104, -106, -82, 24, 97, -80, -13, -105, 108, 37, -93, -89, 21, 59, 9, -61, -78, -48, 72, -128 };
  public static final int[] ahVZ = { 31, -84, 34, 64, -111, -91, 81, -125, -40, -22, 33, -67, -73, 123, -23, -93 };
  
  public static String W(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(212035);
    byte[] arrayOfByte = new byte[paramArrayOfInt.length];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      arrayOfByte[i] = ((byte)paramArrayOfInt[i]);
      i += 1;
    }
    paramArrayOfInt = b.r(arrayOfByte, b.jXz());
    if (paramArrayOfInt == null)
    {
      AppMethodBeat.o(212035);
      return null;
    }
    paramArrayOfInt = new String(paramArrayOfInt);
    AppMethodBeat.o(212035);
    return paramArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.g.c.d
 * JD-Core Version:    0.7.0.1
 */