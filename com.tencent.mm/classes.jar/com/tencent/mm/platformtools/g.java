package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public static String wq(String paramString)
  {
    AppMethodBeat.i(58717);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      AppMethodBeat.o(58717);
      return paramString;
    }
    paramString = paramString.toCharArray();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j = paramString.length;
    while (i < j)
    {
      String str = SpellMap.u(paramString[i]);
      if (str != null) {
        localStringBuffer.append(str);
      }
      i += 1;
    }
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(58717);
    return paramString;
  }
  
  public static String wr(String paramString)
  {
    AppMethodBeat.i(58718);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      AppMethodBeat.o(58718);
      return paramString;
    }
    paramString = paramString.toCharArray();
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      if (!Character.isSpace(paramString[i]))
      {
        String str = SpellMap.u(paramString[i]);
        if ((str != null) && (str.length() > 0)) {
          localStringBuffer.append(str.charAt(0));
        }
      }
      i += 1;
    }
    paramString = localStringBuffer.toString().toUpperCase();
    AppMethodBeat.o(58718);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.g
 * JD-Core Version:    0.7.0.1
 */