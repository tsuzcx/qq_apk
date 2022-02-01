package com.robinhood.ticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class c
{
  final char[] ciA;
  final Map<Character, Integer> ciB;
  final int ciz;
  
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
    this.ciz = k;
    this.ciB = new HashMap(k);
    int i = 0;
    while (i < k)
    {
      this.ciB.put(Character.valueOf(paramString[i]), Integer.valueOf(i));
      i += 1;
    }
    this.ciA = new char[k * 2 + 1];
    this.ciA[0] = '\000';
    i = j;
    while (i < k)
    {
      this.ciA[(i + 1)] = paramString[i];
      this.ciA[(k + 1 + i)] = paramString[i];
      i += 1;
    }
    AppMethodBeat.o(39843);
  }
  
  final int u(char paramChar)
  {
    AppMethodBeat.i(39844);
    if (paramChar == 0)
    {
      AppMethodBeat.o(39844);
      return 0;
    }
    if (this.ciB.containsKey(Character.valueOf(paramChar)))
    {
      int i = ((Integer)this.ciB.get(Character.valueOf(paramChar))).intValue();
      AppMethodBeat.o(39844);
      return i + 1;
    }
    AppMethodBeat.o(39844);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.robinhood.ticker.c
 * JD-Core Version:    0.7.0.1
 */