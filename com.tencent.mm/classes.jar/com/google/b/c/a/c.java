package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

class c
  implements g
{
  private int a(h paramh, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, int paramInt)
  {
    AppMethodBeat.i(57290);
    int i = paramStringBuilder1.length();
    paramStringBuilder1.delete(i - paramInt, i);
    paramh.pos -= 1;
    paramInt = a(paramh.sF(), paramStringBuilder2);
    paramh.bjs = null;
    AppMethodBeat.o(57290);
    return paramInt;
  }
  
  static void a(h paramh, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(57291);
    int i = paramStringBuilder.charAt(0) * 'ـ' + paramStringBuilder.charAt(1) * '(' + paramStringBuilder.charAt(2) + 1;
    paramh.bi(new String(new char[] { (char)(i / 256), (char)(i % 256) }));
    paramStringBuilder.delete(0, 3);
    AppMethodBeat.o(57291);
  }
  
  int a(char paramChar, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(57293);
    if (paramChar == ' ')
    {
      paramStringBuilder.append('\003');
      AppMethodBeat.o(57293);
      return 1;
    }
    if ((paramChar >= '0') && (paramChar <= '9'))
    {
      paramStringBuilder.append((char)(paramChar - '0' + 4));
      AppMethodBeat.o(57293);
      return 1;
    }
    if ((paramChar >= 'A') && (paramChar <= 'Z'))
    {
      paramStringBuilder.append((char)(paramChar - 'A' + 14));
      AppMethodBeat.o(57293);
      return 1;
    }
    if ((paramChar >= 0) && (paramChar <= '\037'))
    {
      paramStringBuilder.append('\000');
      paramStringBuilder.append(paramChar);
      AppMethodBeat.o(57293);
      return 2;
    }
    if ((paramChar >= '!') && (paramChar <= '/'))
    {
      paramStringBuilder.append('\001');
      paramStringBuilder.append((char)(paramChar - '!'));
      AppMethodBeat.o(57293);
      return 2;
    }
    if ((paramChar >= ':') && (paramChar <= '@'))
    {
      paramStringBuilder.append('\001');
      paramStringBuilder.append((char)(paramChar - ':' + 15));
      AppMethodBeat.o(57293);
      return 2;
    }
    if ((paramChar >= '[') && (paramChar <= '_'))
    {
      paramStringBuilder.append('\001');
      paramStringBuilder.append((char)(paramChar - '[' + 22));
      AppMethodBeat.o(57293);
      return 2;
    }
    if ((paramChar >= '`') && (paramChar <= ''))
    {
      paramStringBuilder.append('\002');
      paramStringBuilder.append((char)(paramChar - '`'));
      AppMethodBeat.o(57293);
      return 2;
    }
    if (paramChar >= '')
    {
      paramStringBuilder.append("\001\036");
      int i = a((char)(paramChar - ''), paramStringBuilder);
      AppMethodBeat.o(57293);
      return i + 2;
    }
    paramStringBuilder = new IllegalArgumentException("Illegal character: ".concat(String.valueOf(paramChar)));
    AppMethodBeat.o(57293);
    throw paramStringBuilder;
  }
  
  public void a(h paramh)
  {
    AppMethodBeat.i(57289);
    StringBuilder localStringBuilder1 = new StringBuilder();
    while (paramh.sG())
    {
      char c = paramh.sF();
      paramh.pos += 1;
      int j = a(c, localStringBuilder1);
      int i = (localStringBuilder1.length() / 3 << 1) + paramh.bjq.length();
      paramh.fg(i);
      int k = paramh.bjs.bjB - i;
      if (!paramh.sG())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        i = j;
        if (localStringBuilder1.length() % 3 == 2) {
          if (k >= 2)
          {
            i = j;
            if (k <= 2) {
              break label136;
            }
          }
        }
        label136:
        for (i = a(paramh, localStringBuilder1, localStringBuilder2, j); (localStringBuilder1.length() % 3 == 1) && (((i <= 3) && (k != 1)) || (i > 3)); i = a(paramh, localStringBuilder1, localStringBuilder2, i)) {}
      }
      if (localStringBuilder1.length() % 3 == 0)
      {
        i = j.b(paramh.bjm, paramh.pos, sC());
        if (i != sC()) {
          paramh.bjr = i;
        }
      }
    }
    b(paramh, localStringBuilder1);
    AppMethodBeat.o(57289);
  }
  
  void b(h paramh, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(57292);
    int j = paramStringBuilder.length() / 3;
    int i = paramStringBuilder.length() % 3;
    j = (j << 1) + paramh.bjq.length();
    paramh.fg(j);
    j = paramh.bjs.bjB - j;
    if (i == 2)
    {
      paramStringBuilder.append('\000');
      while (paramStringBuilder.length() >= 3) {
        a(paramh, paramStringBuilder);
      }
      if (paramh.sG()) {
        paramh.g('þ');
      }
    }
    for (;;)
    {
      paramh.bjr = 0;
      AppMethodBeat.o(57292);
      return;
      if ((j == 1) && (i == 1))
      {
        while (paramStringBuilder.length() >= 3) {
          a(paramh, paramStringBuilder);
        }
        if (paramh.sG()) {
          paramh.g('þ');
        }
        paramh.pos -= 1;
      }
      else
      {
        if (i != 0) {
          break;
        }
        while (paramStringBuilder.length() >= 3) {
          a(paramh, paramStringBuilder);
        }
        if ((j > 0) || (paramh.sG())) {
          paramh.g('þ');
        }
      }
    }
    paramh = new IllegalStateException("Unexpected case. Please report!");
    AppMethodBeat.o(57292);
    throw paramh;
  }
  
  public int sC()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.b.c.a.c
 * JD-Core Version:    0.7.0.1
 */