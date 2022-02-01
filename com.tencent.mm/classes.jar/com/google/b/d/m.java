package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class m
  extends o
{
  private static final int[] ceq = { 1, 1, 1, 1 };
  private static final int[] cet = { 3, 1, 1 };
  
  public final b a(String paramString, a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(12382);
    if (parama != a.cbD)
    {
      paramString = new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(12382);
      throw paramString;
    }
    paramString = super.a(paramString, parama, paramInt1, paramInt2, paramMap);
    AppMethodBeat.o(12382);
    return paramString;
  }
  
  public final boolean[] ct(String paramString)
  {
    AppMethodBeat.i(12383);
    int m = paramString.length();
    if (m % 2 != 0)
    {
      paramString = new IllegalArgumentException("The length of the input should be even");
      AppMethodBeat.o(12383);
      throw paramString;
    }
    if (m > 80)
    {
      paramString = new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(m)));
      AppMethodBeat.o(12383);
      throw paramString;
    }
    boolean[] arrayOfBoolean = new boolean[m * 9 + 9];
    int j = a(arrayOfBoolean, 0, ceq, true);
    int i = 0;
    while (i < m)
    {
      int n = Character.digit(paramString.charAt(i), 10);
      int i1 = Character.digit(paramString.charAt(i + 1), 10);
      int[] arrayOfInt = new int[18];
      int k = 0;
      while (k < 5)
      {
        arrayOfInt[(k * 2)] = l.ces[n][k];
        arrayOfInt[(k * 2 + 1)] = l.ces[i1][k];
        k += 1;
      }
      j += a(arrayOfBoolean, j, arrayOfInt, true);
      i += 2;
    }
    a(arrayOfBoolean, j, cet, true);
    AppMethodBeat.o(12383);
    return arrayOfBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.d.m
 * JD-Core Version:    0.7.0.1
 */