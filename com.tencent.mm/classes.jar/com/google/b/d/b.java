package com.google.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends o
{
  private static final char[] bjP = { 65, 66, 67, 68 };
  private static final char[] bjQ = { 84, 78, 42, 69 };
  private static final char[] bjR = { 47, 58, 43, 46 };
  private static final char bjS = bjP[0];
  
  public final boolean[] bj(String paramString)
  {
    AppMethodBeat.i(57172);
    String str;
    int i;
    if (paramString.length() < 2)
    {
      str = bjS + paramString + bjS;
      i = 20;
      j = 1;
      label48:
      if (j >= str.length() - 1) {
        break label379;
      }
      if ((!Character.isDigit(str.charAt(j))) && (str.charAt(j) != '-') && (str.charAt(j) != '$')) {
        break label311;
      }
      i += 9;
    }
    boolean bool1;
    for (;;)
    {
      j += 1;
      break label48;
      char c1 = Character.toUpperCase(paramString.charAt(0));
      char c2 = Character.toUpperCase(paramString.charAt(paramString.length() - 1));
      bool1 = a.a(bjP, c1);
      boolean bool2 = a.a(bjP, c2);
      boolean bool3 = a.a(bjQ, c1);
      boolean bool4 = a.a(bjQ, c2);
      if (bool1)
      {
        str = paramString;
        if (bool2) {
          break;
        }
        paramString = new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(57172);
        throw paramString;
      }
      if (bool3)
      {
        str = paramString;
        if (bool4) {
          break;
        }
        paramString = new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(57172);
        throw paramString;
      }
      if ((bool2) || (bool4))
      {
        paramString = new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(57172);
        throw paramString;
      }
      str = bjS + paramString + bjS;
      break;
      label311:
      if (!a.a(bjR, str.charAt(j))) {
        break label337;
      }
      i += 10;
    }
    label337:
    paramString = new IllegalArgumentException("Cannot encode : '" + str.charAt(j) + '\'');
    AppMethodBeat.o(57172);
    throw paramString;
    label379:
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
          break label488;
        }
      }
      switch (m)
      {
      default: 
        i = m;
        label488:
        m = 0;
        label491:
        if (m < a.bjM.length) {
          if (i != a.bjM[m]) {
            break;
          }
        }
        break;
      }
    }
    for (int m = a.bjN[m];; m = 0)
    {
      int n = 0;
      bool1 = true;
      i = j;
      j = 0;
      for (;;)
      {
        label532:
        if (n >= 7) {
          break label642;
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
            break label532;
            i = 65;
            break;
            i = 66;
            break;
            i = 67;
            break;
            i = 68;
            break;
            m += 1;
            break label491;
          }
        }
        j += 1;
      }
      label642:
      if (k < str.length() - 1) {
        paramString[i] = 0;
      }
      for (j = i + 1;; j = i)
      {
        k += 1;
        break;
        AppMethodBeat.o(57172);
        return paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.b.d.b
 * JD-Core Version:    0.7.0.1
 */