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
    AppMethodBeat.i(12381);
    a locala2 = d(paramCharSequence, paramInt1);
    if ((locala2 == a.cei) || (locala2 == a.cej))
    {
      AppMethodBeat.o(12381);
      return 100;
    }
    if (paramInt2 == 99)
    {
      AppMethodBeat.o(12381);
      return paramInt2;
    }
    if (paramInt2 == 100)
    {
      if (locala2 == a.cel)
      {
        AppMethodBeat.o(12381);
        return paramInt2;
      }
      locala1 = d(paramCharSequence, paramInt1 + 2);
      if ((locala1 == a.cei) || (locala1 == a.cej))
      {
        AppMethodBeat.o(12381);
        return paramInt2;
      }
      if (locala1 == a.cel)
      {
        if (d(paramCharSequence, paramInt1 + 3) == a.cek)
        {
          AppMethodBeat.o(12381);
          return 99;
        }
        AppMethodBeat.o(12381);
        return 100;
      }
      paramInt1 += 4;
      for (;;)
      {
        locala1 = d(paramCharSequence, paramInt1);
        if (locala1 != a.cek) {
          break;
        }
        paramInt1 += 2;
      }
      if (locala1 == a.cej)
      {
        AppMethodBeat.o(12381);
        return 100;
      }
      AppMethodBeat.o(12381);
      return 99;
    }
    a locala1 = locala2;
    if (locala2 == a.cel) {
      locala1 = d(paramCharSequence, paramInt1 + 1);
    }
    if (locala1 == a.cek)
    {
      AppMethodBeat.o(12381);
      return 99;
    }
    AppMethodBeat.o(12381);
    return 100;
  }
  
  private static a d(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(12380);
    int i = paramCharSequence.length();
    if (paramInt >= i)
    {
      paramCharSequence = a.cei;
      AppMethodBeat.o(12380);
      return paramCharSequence;
    }
    int j = paramCharSequence.charAt(paramInt);
    if (j == 241)
    {
      paramCharSequence = a.cel;
      AppMethodBeat.o(12380);
      return paramCharSequence;
    }
    if ((j < 48) || (j > 57))
    {
      paramCharSequence = a.cei;
      AppMethodBeat.o(12380);
      return paramCharSequence;
    }
    if (paramInt + 1 >= i)
    {
      paramCharSequence = a.cej;
      AppMethodBeat.o(12380);
      return paramCharSequence;
    }
    paramInt = paramCharSequence.charAt(paramInt + 1);
    if ((paramInt < 48) || (paramInt > 57))
    {
      paramCharSequence = a.cej;
      AppMethodBeat.o(12380);
      return paramCharSequence;
    }
    paramCharSequence = a.cek;
    AppMethodBeat.o(12380);
    return paramCharSequence;
  }
  
  public final b a(String paramString, a parama, int paramInt1, int paramInt2, Map<c, ?> paramMap)
  {
    AppMethodBeat.i(12378);
    if (parama != a.cbz)
    {
      paramString = new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(parama)));
      AppMethodBeat.o(12378);
      throw paramString;
    }
    paramString = super.a(paramString, parama, paramInt1, paramInt2, paramMap);
    AppMethodBeat.o(12378);
    return paramString;
  }
  
  public final boolean[] ct(String paramString)
  {
    int i2 = 0;
    AppMethodBeat.i(12379);
    int i3 = paramString.length();
    if ((i3 <= 0) || (i3 > 80))
    {
      paramString = new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(i3)));
      AppMethodBeat.o(12379);
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
          AppMethodBeat.o(12379);
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
            label241:
            i1 = k + 1;
            k = m;
            m = i1;
            label255:
            ((Collection)localObject).add(c.ceh[i]);
            n += i * j;
            if (m == 0) {
              break label563;
            }
          }
          break;
        }
      }
    }
    label563:
    for (i = j + 1;; i = j)
    {
      j = k;
      k = m;
      m = j;
      j = i;
      break;
      i = 102;
      break label241;
      i = 97;
      break label241;
      i = 96;
      break label241;
      i = 100;
      break label241;
      i = Integer.parseInt(paramString.substring(k, k + 2));
      k += 1;
      break label241;
      if (m == 0)
      {
        if (i1 == 100)
        {
          i = 104;
          m = k;
          k = i1;
          break label255;
        }
        i = 105;
        m = k;
        k = i1;
        break label255;
      }
      i = i1;
      m = k;
      k = i1;
      break label255;
      ((Collection)localObject).add(c.ceh[(n % 103)]);
      ((Collection)localObject).add(c.ceh[106]);
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
      AppMethodBeat.o(12379);
      return paramString;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(12219);
      cei = new a("UNCODABLE", 0);
      cej = new a("ONE_DIGIT", 1);
      cek = new a("TWO_DIGITS", 2);
      cel = new a("FNC_1", 3);
      cem = new a[] { cei, cej, cek, cel };
      AppMethodBeat.o(12219);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.d.d
 * JD-Core Version:    0.7.0.1
 */