package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public class NumberUtils
{
  public static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 == paramInt2) {
      return 0;
    }
    return 1;
  }
  
  public static int compare(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 == paramLong2) {
      return 0;
    }
    return 1;
  }
  
  public static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(5274);
    try
    {
      Long.parseLong(paramString);
      AppMethodBeat.o(5274);
      return true;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(5274);
    }
    return false;
  }
  
  public static long parseHexLong(String paramString)
  {
    AppMethodBeat.i(5273);
    if (paramString.length() > 16)
    {
      paramString = new NumberFormatException(String.valueOf(paramString).length() + 37 + "Invalid input: " + paramString + " exceeds 16 characters");
      AppMethodBeat.o(5273);
      throw paramString;
    }
    if (paramString.length() == 16)
    {
      l1 = Long.parseLong(paramString.substring(8), 16);
      long l2 = Long.parseLong(paramString.substring(0, 8), 16);
      AppMethodBeat.o(5273);
      return l1 | l2 << 32;
    }
    long l1 = Long.parseLong(paramString, 16);
    AppMethodBeat.o(5273);
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.util.NumberUtils
 * JD-Core Version:    0.7.0.1
 */