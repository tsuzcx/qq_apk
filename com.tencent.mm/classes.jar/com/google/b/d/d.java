package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class d
  extends o
{
  private static int c(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57316);
    a locala2 = d(paramCharSequence, paramInt1);
    if ((locala2 == a.bjU) || (locala2 == a.bjV))
    {
      AppMethodBeat.o(57316);
      return 100;
    }
    if (paramInt2 == 99)
    {
      AppMethodBeat.o(57316);
      return paramInt2;
    }
    if (paramInt2 == 100)
    {
      if (locala2 == a.bjX)
      {
        AppMethodBeat.o(57316);
        return paramInt2;
      }
      locala1 = d(paramCharSequence, paramInt1 + 2);
      if ((locala1 == a.bjU) || (locala1 == a.bjV))
      {
        AppMethodBeat.o(57316);
        return paramInt2;
      }
      if (locala1 == a.bjX)
      {
        if (d(paramCharSequence, paramInt1 + 3) == a.bjW)
        {
          AppMethodBeat.o(57316);
          return 99;
        }
        AppMethodBeat.o(57316);
        return 100;
      }
      paramInt1 += 4;
      for (;;)
      {
        locala1 = d(paramCharSequence, paramInt1);
        if (locala1 != a.bjW) {
          break;
        }
        paramInt1 += 2;
      }
      if (locala1 == a.bjV)
      {
        AppMethodBeat.o(57316);
        return 100;
      }
      AppMethodBeat.o(57316);
      return 99;
    }
    a locala1 = locala2;
    if (locala2 == a.bjX) {
      locala1 = d(paramCharSequence, paramInt1 + 1);
    }
    if (locala1 == a.bjW)
    {
      AppMethodBeat.o(57316);
      return 99;
    }
    AppMethodBeat.o(57316);
    return 100;
  }
  
  private static a d(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(57315);
    int i = paramCharSequence.length();
    if (paramInt >= i)
    {
      paramCharSequence = a.bjU;
      AppMethodBeat.o(57315);
      return paramCharSequence;
    }
    int j = paramCharSequence.charAt(paramInt);
    if (j == 241)
    {
      paramCharSequence = a.bjX;
      AppMethodBeat.o(57315);
      return paramCharSequence;
    }
    if ((j < 48) || (j > 57))
    {
      paramCharSequence = a.bjU;
      AppMethodBeat.o(57315);
      return paramCharSequence;
    }
    if (paramInt + 1 >= i)
    {
      paramCharSequence = a.bjV;
      AppMethodBeat.o(57315);
      return paramCharSequence;
    }
    paramInt = paramCharSequence.charAt(paramInt + 1);
    if ((paramInt < 48) || (paramInt > 57))
    {
      paramCharSequence = a.bjV;
      AppMethodBeat.o(57315);
      return paramCharSequence;
    }
    paramCharSequence = a.bjW;
    AppMethodBeat.o(57315);
    return paramCharSequence;
  }
  
  public final b a(String paramString, a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(57313);
    if (parama != a.bhk)
    {
      paramString = new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(57313);
      throw paramString;
    }
    paramString = super.a(paramString, parama, paramInt1, paramInt2, paramMap);
    AppMethodBeat.o(57313);
    return paramString;
  }
  
  public final boolean[] bj(String paramString)
  {
    int i2 = 0;
    AppMethodBeat.i(57314);
    int i3 = paramString.length();
    if ((i3 <= 0) || (i3 > 80))
    {
      paramString = new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(i3)));
      AppMethodBeat.o(57314);
      throw paramString;
    }
    int i = 0;
    while (i < i3)
    {
      char c = paramString.charAt(i);
      if ((c < ' ') || (c > '~')) {
        switch (c)
        {
        default: 
          paramString = new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(c)));
          AppMethodBeat.o(57314);
          throw paramString;
        }
      }
      i += 1;
    }
    Object localObject = new ArrayList();
    int k = 0;
    int m = 0;
    int j = 1;
    int n = 0;
    int i1;
    if (k < i3)
    {
      i1 = c(paramString, k, m);
      if (i1 == m) {
        switch (paramString.charAt(k))
        {
        default: 
          if (m == 100)
          {
            i = paramString.charAt(k) - ' ';
            label237:
            i1 = k + 1;
            k = m;
            m = i1;
            label251:
            ((Collection)localObject).add(c.bjT[i]);
            n += i * j;
            if (m == 0) {
              break label558;
            }
          }
          break;
        }
      }
    }
    label558:
    for (i = j + 1;; i = j)
    {
      j = k;
      k = m;
      m = j;
      j = i;
      break;
      i = 102;
      break label237;
      i = 97;
      break label237;
      i = 96;
      break label237;
      i = 100;
      break label237;
      i = Integer.parseInt(paramString.substring(k, k + 2));
      k += 1;
      break label237;
      if (m == 0)
      {
        if (i1 == 100)
        {
          i = 104;
          m = k;
          k = i1;
          break label251;
        }
        i = 105;
        m = k;
        k = i1;
        break label251;
      }
      i = i1;
      m = k;
      k = i1;
      break label251;
      ((Collection)localObject).add(c.bjT[(n % 103)]);
      ((Collection)localObject).add(c.bjT[106]);
      paramString = ((Collection)localObject).iterator();
      i = 0;
      if (paramString.hasNext())
      {
        int[] arrayOfInt = (int[])paramString.next();
        m = arrayOfInt.length;
        k = 0;
        j = i;
        for (;;)
        {
          i = j;
          if (k >= m) {
            break;
          }
          j += arrayOfInt[k];
          k += 1;
        }
      }
      paramString = new boolean[i];
      localObject = ((Collection)localObject).iterator();
      i = i2;
      while (((Iterator)localObject).hasNext()) {
        i += a(paramString, i, (int[])((Iterator)localObject).next(), true);
      }
      AppMethodBeat.o(57314);
      return paramString;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(57154);
      bjU = new a("UNCODABLE", 0);
      bjV = new a("ONE_DIGIT", 1);
      bjW = new a("TWO_DIGITS", 2);
      bjX = new a("FNC_1", 3);
      bjY = new a[] { bjU, bjV, bjW, bjX };
      AppMethodBeat.o(57154);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.b.d.d
 * JD-Core Version:    0.7.0.1
 */