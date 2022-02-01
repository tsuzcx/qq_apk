package com.google.c.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends o
{
  private static final char[] bLJ = { 65, 66, 67, 68 };
  private static final char[] bLK = { 84, 78, 42, 69 };
  private static final char[] bLL = { 47, 58, 43, 46 };
  private static final char bLM = bLJ[0];
  
  public final boolean[] bw(String paramString)
  {
    AppMethodBeat.i(12237);
    String str;
    int i;
    if (paramString.length() < 2)
    {
      str = bLM + paramString + bLM;
      i = 20;
      j = 1;
      label49:
      if (j >= str.length() - 1) {
        break label384;
      }
      if ((!Character.isDigit(str.charAt(j))) && (str.charAt(j) != '-') && (str.charAt(j) != '$')) {
        break label315;
      }
      i += 9;
    }
    boolean bool1;
    for (;;)
    {
      j += 1;
      break label49;
      char c1 = Character.toUpperCase(paramString.charAt(0));
      char c2 = Character.toUpperCase(paramString.charAt(paramString.length() - 1));
      bool1 = a.a(bLJ, c1);
      boolean bool2 = a.a(bLJ, c2);
      boolean bool3 = a.a(bLK, c1);
      boolean bool4 = a.a(bLK, c2);
      if (bool1)
      {
        str = paramString;
        if (bool2) {
          break;
        }
        paramString = new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(12237);
        throw paramString;
      }
      if (bool3)
      {
        str = paramString;
        if (bool4) {
          break;
        }
        paramString = new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(12237);
        throw paramString;
      }
      if ((bool2) || (bool4))
      {
        paramString = new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(12237);
        throw paramString;
      }
      str = bLM + paramString + bLM;
      break;
      label315:
      if (!a.a(bLL, str.charAt(j))) {
        break label341;
      }
      i += 10;
    }
    label341:
    paramString = new IllegalArgumentException("Cannot encode : '" + str.charAt(j) + '\'');
    AppMethodBeat.o(12237);
    throw paramString;
    label384:
    paramString = new boolean[str.length() - 1 + i];
    int k = 0;
    int j = 0;
    if (k < str.length())
    {
      m = Character.toUpperCase(str.charAt(k));
      if (k != 0)
      {
        i = m;
        if (k != str.length() - 1) {
          break label496;
        }
      }
      switch (m)
      {
      default: 
        i = m;
        label496:
        m = 0;
        label499:
        if (m < a.bLG.length) {
          if (i != a.bLG[m]) {
            break;
          }
        }
        break;
      }
    }
    for (int m = a.bLH[m];; m = 0)
    {
      int n = 0;
      bool1 = true;
      i = j;
      j = 0;
      for (;;)
      {
        label540:
        if (n >= 7) {
          break label650;
        }
        paramString[i] = bool1;
        i += 1;
        if (((m >> 6 - n & 0x1) == 0) || (j == 1))
        {
          if (!bool1) {}
          for (bool1 = true;; bool1 = false)
          {
            n += 1;
            j = 0;
            break label540;
            i = 65;
            break;
            i = 66;
            break;
            i = 67;
            break;
            i = 68;
            break;
            m += 1;
            break label499;
          }
        }
        j += 1;
      }
      label650:
      if (k < str.length() - 1) {
        paramString[i] = 0;
      }
      for (j = i + 1;; j = i)
      {
        k += 1;
        break;
        AppMethodBeat.o(12237);
        return paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.d.b
 * JD-Core Version:    0.7.0.1
 */