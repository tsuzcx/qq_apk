package com.google.c.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
  implements g
{
  public final void a(h paramh)
  {
    AppMethodBeat.i(12271);
    String str = paramh.msg;
    int j = paramh.pos;
    int n = str.length();
    if (j < n)
    {
      c1 = str.charAt(j);
      i = 0;
      for (;;)
      {
        k = i;
        if (!j.l(c1)) {
          break;
        }
        k = i;
        if (j >= n) {
          break;
        }
        k = i + 1;
        int m = j + 1;
        j = m;
        i = k;
        if (m < n)
        {
          c1 = str.charAt(m);
          j = m;
          i = k;
        }
      }
    }
    int k = 0;
    if (k >= 2)
    {
      c1 = paramh.msg.charAt(paramh.pos);
      char c2 = paramh.msg.charAt(paramh.pos + 1);
      if ((j.l(c1)) && (j.l(c2)))
      {
        paramh.k((char)((c1 - '0') * 10 + (c2 - '0') + 130));
        paramh.pos += 2;
        AppMethodBeat.o(12271);
        return;
      }
      paramh = new IllegalArgumentException("not digits: " + c1 + c2);
      AppMethodBeat.o(12271);
      throw paramh;
    }
    char c1 = paramh.JM();
    int i = j.b(paramh.msg, paramh.pos, 0);
    if (i != 0)
    {
      switch (i)
      {
      default: 
        paramh = new IllegalStateException("Illegal mode: ".concat(String.valueOf(i)));
        AppMethodBeat.o(12271);
        throw paramh;
      case 5: 
        paramh.k('ç');
        paramh.cfj = 5;
        AppMethodBeat.o(12271);
        return;
      case 1: 
        paramh.k('æ');
        paramh.cfj = 1;
        AppMethodBeat.o(12271);
        return;
      case 3: 
        paramh.k('î');
        paramh.cfj = 3;
        AppMethodBeat.o(12271);
        return;
      case 2: 
        paramh.k('ï');
        paramh.cfj = 2;
        AppMethodBeat.o(12271);
        return;
      }
      paramh.k('ð');
      paramh.cfj = 4;
      AppMethodBeat.o(12271);
      return;
    }
    if (j.m(c1))
    {
      paramh.k('ë');
      paramh.k((char)(c1 - '' + 1));
      paramh.pos += 1;
      AppMethodBeat.o(12271);
      return;
    }
    paramh.k((char)(c1 + '\001'));
    paramh.pos += 1;
    AppMethodBeat.o(12271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.c.c.a.a
 * JD-Core Version:    0.7.0.1
 */