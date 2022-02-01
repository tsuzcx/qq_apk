package com.robinhood.ticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class c
{
  final int dYY;
  final char[] dYZ;
  final Map<Character, Integer> dZa;
  
  c(String paramString)
  {
    AppMethodBeat.i(39843);
    if (paramString.contains(Character.toString('\000')))
    {
      paramString = new IllegalArgumentException("You cannot include TickerUtils.EMPTY_CHAR in the character list.");
      AppMethodBeat.o(39843);
      throw paramString;
    }
    paramString = paramString.toCharArray();
    int k = paramString.length;
    this.dYY = k;
    this.dZa = new HashMap(k);
    int i = 0;
    while (i < k)
    {
      this.dZa.put(Character.valueOf(paramString[i]), Integer.valueOf(i));
      i += 1;
    }
    this.dYZ = new char[k * 2 + 1];
    this.dYZ[0] = '\000';
    i = j;
    while (i < k)
    {
      this.dYZ[(i + 1)] = paramString[i];
      this.dYZ[(k + 1 + i)] = paramString[i];
      i += 1;
    }
    AppMethodBeat.o(39843);
  }
  
  final int l(char paramChar)
  {
    AppMethodBeat.i(39844);
    if (paramChar == 0)
    {
      AppMethodBeat.o(39844);
      return 0;
    }
    if (this.dZa.containsKey(Character.valueOf(paramChar)))
    {
      int i = ((Integer)this.dZa.get(Character.valueOf(paramChar))).intValue();
      AppMethodBeat.o(39844);
      return i + 1;
    }
    AppMethodBeat.o(39844);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.robinhood.ticker.c
 * JD-Core Version:    0.7.0.1
 */