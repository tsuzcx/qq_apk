package com.google.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private static final int dFC;
  
  static
  {
    AppMethodBeat.i(108108);
    String str = System.getProperty("java.version");
    int j = dJ(str);
    int i = j;
    if (j == -1) {
      i = dK(str);
    }
    j = i;
    if (i == -1) {
      j = 6;
    }
    dFC = j;
    AppMethodBeat.o(108108);
  }
  
  public static int YZ()
  {
    return dFC;
  }
  
  public static boolean Za()
  {
    return dFC >= 9;
  }
  
  private static int dJ(String paramString)
  {
    AppMethodBeat.i(108106);
    try
    {
      paramString = paramString.split("[._]");
      int i = Integer.parseInt(paramString[0]);
      if ((i == 1) && (paramString.length > 1))
      {
        i = Integer.parseInt(paramString[1]);
        AppMethodBeat.o(108106);
        return i;
      }
      AppMethodBeat.o(108106);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(108106);
    }
    return -1;
  }
  
  private static int dK(String paramString)
  {
    AppMethodBeat.i(108107);
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if (!Character.isDigit(c)) {
          break;
        }
        localStringBuilder.append(c);
        i += 1;
      }
      i = Integer.parseInt(localStringBuilder.toString());
      AppMethodBeat.o(108107);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(108107);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.c.b.e
 * JD-Core Version:    0.7.0.1
 */