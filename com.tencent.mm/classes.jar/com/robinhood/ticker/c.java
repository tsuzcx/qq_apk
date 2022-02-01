package com.robinhood.ticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class c
{
  final Map<Character, Integer> cgA;
  final int cgy;
  final char[] cgz;
  
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
    this.cgy = k;
    this.cgA = new HashMap(k);
    int i = 0;
    while (i < k)
    {
      this.cgA.put(Character.valueOf(paramString[i]), Integer.valueOf(i));
      i += 1;
    }
    this.cgz = new char[k * 2 + 1];
    this.cgz[0] = '\000';
    i = j;
    while (i < k)
    {
      this.cgz[(i + 1)] = paramString[i];
      this.cgz[(k + 1 + i)] = paramString[i];
      i += 1;
    }
    AppMethodBeat.o(39843);
  }
  
  final int p(char paramChar)
  {
    AppMethodBeat.i(39844);
    if (paramChar == 0)
    {
      AppMethodBeat.o(39844);
      return 0;
    }
    if (this.cgA.containsKey(Character.valueOf(paramChar)))
    {
      int i = ((Integer)this.cgA.get(Character.valueOf(paramChar))).intValue();
      AppMethodBeat.o(39844);
      return i + 1;
    }
    AppMethodBeat.o(39844);
    return -1;
  }
  
  final class a
  {
    final int endIndex;
    final int startIndex;
    
    public a(int paramInt1, int paramInt2)
    {
      this.startIndex = paramInt1;
      this.endIndex = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.robinhood.ticker.c
 * JD-Core Version:    0.7.0.1
 */