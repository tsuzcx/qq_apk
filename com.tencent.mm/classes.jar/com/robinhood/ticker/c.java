package com.robinhood.ticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class c
{
  final int bNV;
  final char[] bNW;
  final Map<Character, Integer> bNX;
  
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
    this.bNV = k;
    this.bNX = new HashMap(k);
    int i = 0;
    while (i < k)
    {
      this.bNX.put(Character.valueOf(paramString[i]), Integer.valueOf(i));
      i += 1;
    }
    this.bNW = new char[k * 2 + 1];
    this.bNW[0] = '\000';
    i = j;
    while (i < k)
    {
      this.bNW[(i + 1)] = paramString[i];
      this.bNW[(k + 1 + i)] = paramString[i];
      i += 1;
    }
    AppMethodBeat.o(39843);
  }
  
  final int n(char paramChar)
  {
    AppMethodBeat.i(39844);
    if (paramChar == 0)
    {
      AppMethodBeat.o(39844);
      return 0;
    }
    if (this.bNX.containsKey(Character.valueOf(paramChar)))
    {
      int i = ((Integer)this.bNX.get(Character.valueOf(paramChar))).intValue();
      AppMethodBeat.o(39844);
      return i + 1;
    }
    AppMethodBeat.o(39844);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.robinhood.ticker.c
 * JD-Core Version:    0.7.0.1
 */