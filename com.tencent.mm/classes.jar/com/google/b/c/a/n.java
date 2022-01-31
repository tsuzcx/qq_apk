package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class n
  extends c
{
  final int a(char paramChar, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(57223);
    if (paramChar == '\r') {
      paramStringBuilder.append('\000');
    }
    for (;;)
    {
      AppMethodBeat.o(57223);
      return 1;
      if (paramChar == '*') {
        paramStringBuilder.append('\001');
      } else if (paramChar == '>') {
        paramStringBuilder.append('\002');
      } else if (paramChar == ' ') {
        paramStringBuilder.append('\003');
      } else if ((paramChar >= '0') && (paramChar <= '9')) {
        paramStringBuilder.append((char)(paramChar - '0' + 4));
      } else if ((paramChar >= 'A') && (paramChar <= 'Z')) {
        paramStringBuilder.append((char)(paramChar - 'A' + 14));
      } else {
        j.k(paramChar);
      }
    }
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(57222);
    StringBuilder localStringBuilder = new StringBuilder();
    while (paramh.sG())
    {
      char c = paramh.sF();
      paramh.pos += 1;
      a(c, localStringBuilder);
      if (localStringBuilder.length() % 3 == 0)
      {
        a(paramh, localStringBuilder);
        int i = j.b(paramh.bjm, paramh.pos, 3);
        if (i != 3) {
          paramh.bjr = i;
        }
      }
    }
    b(paramh, localStringBuilder);
    AppMethodBeat.o(57222);
  }
  
  final void b(h paramh, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(57224);
    paramh.sJ();
    int i = paramh.bjs.bjB - paramh.bjq.length();
    int j = paramStringBuilder.length();
    paramh.pos -= j;
    if ((paramh.sI() > 1) || (i > 1) || (paramh.sI() != i)) {
      paramh.g('þ');
    }
    if (paramh.bjr < 0) {
      paramh.bjr = 0;
    }
    AppMethodBeat.o(57224);
  }
  
  public final int sC()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.b.c.a.n
 * JD-Core Version:    0.7.0.1
 */