package com.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  int pos;
  long value;
  
  d(long paramLong, int paramInt)
  {
    this.value = paramLong;
    this.pos = paramInt;
  }
  
  static d e(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214734);
    long l = 0L;
    if (paramInt1 >= paramInt2)
    {
      AppMethodBeat.o(214734);
      return null;
    }
    int i = paramInt1;
    while (i < paramInt2)
    {
      int j = paramString.charAt(i);
      if ((j < 48) || (j > 57)) {
        break;
      }
      l = l * 10L + (j - 48);
      if (l > 2147483647L)
      {
        AppMethodBeat.o(214734);
        return null;
      }
      i += 1;
    }
    if (i == paramInt1)
    {
      AppMethodBeat.o(214734);
      return null;
    }
    paramString = new d(l, i);
    AppMethodBeat.o(214734);
    return paramString;
  }
  
  static d f(String paramString, int paramInt)
  {
    AppMethodBeat.i(214735);
    long l = 0L;
    int i;
    if (1 >= paramInt)
    {
      AppMethodBeat.o(214735);
      return null;
      i += 1;
    }
    for (;;)
    {
      if (i < paramInt)
      {
        int j = paramString.charAt(i);
        if ((j >= 48) && (j <= 57)) {
          l = l * 16L + (j - 48);
        }
        while (l > 4294967295L)
        {
          AppMethodBeat.o(214735);
          return null;
          if ((j >= 65) && (j <= 70))
          {
            l = l * 16L + (j - 65) + 10L;
          }
          else
          {
            if ((j < 97) || (j > 102)) {
              break label143;
            }
            l = l * 16L + (j - 97) + 10L;
          }
        }
        break;
      }
      label143:
      if (i == 1)
      {
        AppMethodBeat.o(214735);
        return null;
      }
      paramString = new d(l, i);
      AppMethodBeat.o(214735);
      return paramString;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.a.a.d
 * JD-Core Version:    0.7.0.1
 */