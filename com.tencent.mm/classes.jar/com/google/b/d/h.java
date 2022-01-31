package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class h
  extends o
{
  private static int a(boolean[] paramArrayOfBoolean, int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    if (i < 9)
    {
      if (paramArrayOfInt[i] != 0) {}
      for (int j = 1;; j = 0)
      {
        paramArrayOfBoolean[paramInt] = j;
        i += 1;
        paramInt += 1;
        break;
      }
    }
    return 9;
  }
  
  private static void b(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    if (i < 9)
    {
      if ((1 << 8 - i & paramInt) == 0) {}
      for (int j = 0;; j = 1)
      {
        paramArrayOfInt[i] = j;
        i += 1;
        break;
      }
    }
  }
  
  private static int k(String paramString, int paramInt)
  {
    AppMethodBeat.i(57175);
    int k = 0;
    int j = paramString.length() - 1;
    int i = 1;
    while (j >= 0)
    {
      k += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(paramString.charAt(j)) * i;
      int m = i + 1;
      i = m;
      if (m > paramInt) {
        i = 1;
      }
      j -= 1;
    }
    AppMethodBeat.o(57175);
    return k % 47;
  }
  
  public final b a(String paramString, a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(57173);
    if (parama != a.bhj)
    {
      paramString = new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(57173);
      throw paramString;
    }
    paramString = super.a(paramString, parama, paramInt1, paramInt2, paramMap);
    AppMethodBeat.o(57173);
    return paramString;
  }
  
  public final boolean[] bj(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(57174);
    int k = paramString.length();
    if (k > 80)
    {
      paramString = new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(k)));
      AppMethodBeat.o(57174);
      throw paramString;
    }
    int[] arrayOfInt = new int[9];
    boolean[] arrayOfBoolean = new boolean[(paramString.length() + 2 + 2) * 9 + 1];
    b(g.bjN[47], arrayOfInt);
    int i = a(arrayOfBoolean, 0, arrayOfInt);
    while (j < k)
    {
      int m = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(paramString.charAt(j));
      b(g.bjN[m], arrayOfInt);
      i += a(arrayOfBoolean, i, arrayOfInt);
      j += 1;
    }
    j = k(paramString, 20);
    b(g.bjN[j], arrayOfInt);
    i += a(arrayOfBoolean, i, arrayOfInt);
    j = k(paramString + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(j), 15);
    b(g.bjN[j], arrayOfInt);
    i = a(arrayOfBoolean, i, arrayOfInt) + i;
    b(g.bjN[47], arrayOfInt);
    arrayOfBoolean[(i + a(arrayOfBoolean, i, arrayOfInt))] = true;
    AppMethodBeat.o(57174);
    return arrayOfBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.b.d.h
 * JD-Core Version:    0.7.0.1
 */