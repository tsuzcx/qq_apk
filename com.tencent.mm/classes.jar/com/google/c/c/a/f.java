package com.google.c.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class f
  implements g
{
  private static String C(CharSequence paramCharSequence)
  {
    int k = 0;
    AppMethodBeat.i(12360);
    int m = paramCharSequence.length() + 0;
    if (m == 0)
    {
      paramCharSequence = new IllegalStateException("StringBuilder must not be empty");
      AppMethodBeat.o(12360);
      throw paramCharSequence;
    }
    int n = paramCharSequence.charAt(0);
    int i;
    if (m >= 2)
    {
      i = paramCharSequence.charAt(1);
      if (m < 3) {
        break label206;
      }
    }
    label206:
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
      AppMethodBeat.o(12360);
      return paramCharSequence;
      i = 0;
      break;
    }
  }
  
  public final void a(h paramh)
  {
    int j = 1;
    AppMethodBeat.i(12359);
    Object localObject = new StringBuilder();
    char c;
    if (paramh.JN())
    {
      c = paramh.JM();
      if ((c < ' ') || (c > '?')) {
        break label138;
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
      paramh.cM(C((CharSequence)localObject));
      ((StringBuilder)localObject).delete(0, 4);
      if (j.b(paramh.msg, paramh.pos, 4) == 4) {
        break;
      }
      paramh.cfj = 0;
      ((StringBuilder)localObject).append('\037');
      try
      {
        i = ((CharSequence)localObject).length();
        if (i == 0)
        {
          return;
          label138:
          if ((c >= '@') && (c <= '^')) {
            ((StringBuilder)localObject).append((char)(c - '@'));
          } else {
            j.p(c);
          }
        }
        else
        {
          if (i == 1)
          {
            paramh.JQ();
            k = paramh.cfk.cft;
            int m = paramh.cfi.length();
            int n = paramh.JP();
            if ((n == 0) && (k - m <= 2)) {
              return;
            }
          }
          if (i > 4)
          {
            localObject = new IllegalStateException("Count must not exceed 4");
            AppMethodBeat.o(12359);
            throw ((Throwable)localObject);
          }
        }
      }
      finally
      {
        paramh.cfj = 0;
        AppMethodBeat.o(12359);
      }
    }
    int k = i - 1;
    String str = C(localCharSequence);
    if (!paramh.JN()) {
      i = 1;
    }
    for (;;)
    {
      j = i;
      if (k <= 2)
      {
        paramh.hZ(paramh.cfi.length() + k);
        j = i;
        if (paramh.cfk.cft - paramh.cfi.length() >= 3)
        {
          paramh.hZ(paramh.cfi.length() + str.length());
          j = 0;
        }
      }
      if (j != 0)
      {
        paramh.cfk = null;
        paramh.pos -= k;
        label381:
        paramh.cfj = 0;
        AppMethodBeat.o(12359);
        return;
        i = 0;
      }
      while ((i == 0) || (k > 2))
      {
        i = 0;
        break;
        paramh.cM(str);
        break label381;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.c.c.a.f
 * JD-Core Version:    0.7.0.1
 */