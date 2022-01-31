package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class f
  implements g
{
  private static String p(CharSequence paramCharSequence)
  {
    int k = 0;
    AppMethodBeat.i(57295);
    int m = paramCharSequence.length() + 0;
    if (m == 0)
    {
      paramCharSequence = new IllegalStateException("StringBuilder must not be empty");
      AppMethodBeat.o(57295);
      throw paramCharSequence;
    }
    int n = paramCharSequence.charAt(0);
    int i;
    if (m >= 2)
    {
      i = paramCharSequence.charAt(1);
      if (m < 3) {
        break label203;
      }
    }
    label203:
    for (int j = paramCharSequence.charAt(2);; j = 0)
    {
      if (m >= 4) {
        k = paramCharSequence.charAt(3);
      }
      i = k + ((j << 6) + ((i << 12) + (n << 18)));
      char c1 = (char)(i >> 16 & 0xFF);
      char c2 = (char)(i >> 8 & 0xFF);
      char c3 = (char)(i & 0xFF);
      paramCharSequence = new StringBuilder(3);
      paramCharSequence.append(c1);
      if (m >= 2) {
        paramCharSequence.append(c2);
      }
      if (m >= 3) {
        paramCharSequence.append(c3);
      }
      paramCharSequence = paramCharSequence.toString();
      AppMethodBeat.o(57295);
      return paramCharSequence;
      i = 0;
      break;
    }
  }
  
  public final void a(h paramh)
  {
    int j = 1;
    AppMethodBeat.i(57294);
    Object localObject = new StringBuilder();
    char c;
    if (paramh.sG())
    {
      c = paramh.sF();
      if ((c < ' ') || (c > '?')) {
        break label136;
      }
      ((StringBuilder)localObject).append(c);
    }
    int i;
    for (;;)
    {
      paramh.pos += 1;
      if (((StringBuilder)localObject).length() < 4) {
        break;
      }
      paramh.bi(p((CharSequence)localObject));
      ((StringBuilder)localObject).delete(0, 4);
      if (j.b(paramh.bjm, paramh.pos, 4) == 4) {
        break;
      }
      paramh.bjr = 0;
      ((StringBuilder)localObject).append('\037');
      try
      {
        i = ((CharSequence)localObject).length();
        if (i == 0)
        {
          return;
          label136:
          if ((c >= '@') && (c <= '^')) {
            ((StringBuilder)localObject).append((char)(c - '@'));
          } else {
            j.k(c);
          }
        }
        else
        {
          if (i == 1)
          {
            paramh.sJ();
            k = paramh.bjs.bjB;
            int m = paramh.bjq.length();
            int n = paramh.sI();
            if ((n == 0) && (k - m <= 2)) {
              return;
            }
          }
          if (i > 4)
          {
            localObject = new IllegalStateException("Count must not exceed 4");
            AppMethodBeat.o(57294);
            throw ((Throwable)localObject);
          }
        }
      }
      finally
      {
        paramh.bjr = 0;
        AppMethodBeat.o(57294);
      }
    }
    int k = i - 1;
    String str = p(localCharSequence);
    if (!paramh.sG()) {
      i = 1;
    }
    for (;;)
    {
      j = i;
      if (k <= 2)
      {
        paramh.fg(paramh.bjq.length() + k);
        j = i;
        if (paramh.bjs.bjB - paramh.bjq.length() >= 3)
        {
          paramh.fg(paramh.bjq.length() + str.length());
          j = 0;
        }
      }
      if (j != 0)
      {
        paramh.bjs = null;
        paramh.pos -= k;
        label376:
        paramh.bjr = 0;
        AppMethodBeat.o(57294);
        return;
        i = 0;
      }
      while ((i == 0) || (k > 2))
      {
        i = 0;
        break;
        paramh.bi(str);
        break label376;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.b.c.a.f
 * JD-Core Version:    0.7.0.1
 */