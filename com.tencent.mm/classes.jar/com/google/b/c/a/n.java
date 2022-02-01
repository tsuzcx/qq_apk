package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class n
  extends c
{
  public final int Ij()
  {
    return 3;
  }
  
  final int a(char paramChar, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(12288);
    if (paramChar == '\r') {
      paramStringBuilder.append('\000');
    }
    for (;;)
    {
      AppMethodBeat.o(12288);
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
    AppMethodBeat.i(12287);
    StringBuilder localStringBuilder = new StringBuilder();
    while (paramh.In())
    {
      char c = paramh.Im();
      paramh.pos += 1;
      a(c, localStringBuilder);
      if (localStringBuilder.length() % 3 == 0)
      {
        a(paramh, localStringBuilder);
        int i = j.b(paramh.msg, paramh.pos, 3);
        if (i != 3) {
          paramh.cdF = i;
        }
      }
    }
    b(paramh, localStringBuilder);
    AppMethodBeat.o(12287);
  }
  
  final void b(h paramh, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(12289);
    paramh.Iq();
    int i = paramh.cdG.cdP - paramh.cdE.length();
    int j = paramStringBuilder.length();
    paramh.pos -= j;
    if ((paramh.Ip() > 1) || (i > 1) || (paramh.Ip() != i)) {
      paramh.g('þ');
    }
    if (paramh.cdF < 0) {
      paramh.cdF = 0;
    }
    AppMethodBeat.o(12289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.c.a.n
 * JD-Core Version:    0.7.0.1
 */