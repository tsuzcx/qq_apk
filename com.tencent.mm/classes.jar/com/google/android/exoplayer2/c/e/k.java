package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k
{
  static void a(int paramInt, i parami)
  {
    AppMethodBeat.i(95063);
    int m = parami.dD(6);
    int i = 0;
    if (i < m + 1)
    {
      switch (parami.dD(16))
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (parami.oj()) {}
        for (int j = parami.dD(4) + 1; parami.oj(); j = 1)
        {
          int n = parami.dD(8);
          k = 0;
          while (k < n + 1)
          {
            parami.dE(dF(paramInt - 1));
            parami.dE(dF(paramInt - 1));
            k += 1;
          }
        }
        if (parami.dD(2) != 0)
        {
          parami = new o("to reserved bits must be zero after mapping coupling steps");
          AppMethodBeat.o(95063);
          throw parami;
        }
        if (j > 1)
        {
          k = 0;
          while (k < paramInt)
          {
            parami.dE(4);
            k += 1;
          }
        }
        int k = 0;
        while (k < j)
        {
          parami.dE(8);
          parami.dE(8);
          parami.dE(8);
          k += 1;
        }
      }
    }
    AppMethodBeat.o(95063);
  }
  
  public static boolean a(int paramInt, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(95061);
    if (paramm.qM() < 7)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(95061);
        return false;
      }
      paramm = new o("too short header: " + paramm.qM());
      AppMethodBeat.o(95061);
      throw paramm;
    }
    if (paramm.readUnsignedByte() != paramInt)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(95061);
        return false;
      }
      paramm = new o("expected header type " + Integer.toHexString(paramInt));
      AppMethodBeat.o(95061);
      throw paramm;
    }
    if ((paramm.readUnsignedByte() != 118) || (paramm.readUnsignedByte() != 111) || (paramm.readUnsignedByte() != 114) || (paramm.readUnsignedByte() != 98) || (paramm.readUnsignedByte() != 105) || (paramm.readUnsignedByte() != 115))
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(95061);
        return false;
      }
      paramm = new o("expected characters 'vorbis'");
      AppMethodBeat.o(95061);
      throw paramm;
    }
    AppMethodBeat.o(95061);
    return true;
  }
  
  static k.c[] a(i parami)
  {
    AppMethodBeat.i(95062);
    int j = parami.dD(6) + 1;
    k.c[] arrayOfc = new k.c[j];
    int i = 0;
    while (i < j)
    {
      arrayOfc[i] = new k.c(parami.oj(), parami.dD(16), parami.dD(16), parami.dD(8));
      i += 1;
    }
    AppMethodBeat.o(95062);
    return arrayOfc;
  }
  
  static void b(i parami)
  {
    AppMethodBeat.i(95064);
    int m = parami.dD(6);
    int i = 0;
    int n;
    int[] arrayOfInt;
    int j;
    label92:
    int i1;
    if (i < m + 1)
    {
      if (parami.dD(16) > 2)
      {
        parami = new o("residueType greater than 2 is not decodable");
        AppMethodBeat.o(95064);
        throw parami;
      }
      parami.dE(24);
      parami.dE(24);
      parami.dE(24);
      n = parami.dD(6) + 1;
      parami.dE(8);
      arrayOfInt = new int[n];
      j = 0;
      if (j < n)
      {
        i1 = parami.dD(3);
        if (!parami.oj()) {
          break label196;
        }
      }
    }
    label196:
    for (int k = parami.dD(5);; k = 0)
    {
      arrayOfInt[j] = (k * 8 + i1);
      j += 1;
      break label92;
      j = 0;
      while (j < n)
      {
        k = 0;
        while (k < 8)
        {
          if ((arrayOfInt[j] & 1 << k) != 0) {
            parami.dE(8);
          }
          k += 1;
        }
        j += 1;
      }
      i += 1;
      break;
      AppMethodBeat.o(95064);
      return;
    }
  }
  
  static void c(i parami)
  {
    AppMethodBeat.i(95065);
    int n = parami.dD(6);
    int i = 0;
    while (i < n + 1)
    {
      int j = parami.dD(16);
      int k;
      switch (j)
      {
      default: 
        parami = new o("floor type greater than 1 not decodable: ".concat(String.valueOf(j)));
        AppMethodBeat.o(95065);
        throw parami;
      case 0: 
        parami.dE(8);
        parami.dE(16);
        parami.dE(16);
        parami.dE(6);
        parami.dE(8);
        k = parami.dD(4);
        j = 0;
      }
      while (j < k + 1)
      {
        parami.dE(8);
        j += 1;
        continue;
        int i1 = parami.dD(5);
        k = -1;
        int[] arrayOfInt1 = new int[i1];
        j = 0;
        while (j < i1)
        {
          arrayOfInt1[j] = parami.dD(4);
          m = k;
          if (arrayOfInt1[j] > k) {
            m = arrayOfInt1[j];
          }
          j += 1;
          k = m;
        }
        int[] arrayOfInt2 = new int[k + 1];
        j = 0;
        while (j < arrayOfInt2.length)
        {
          arrayOfInt2[j] = (parami.dD(3) + 1);
          m = parami.dD(2);
          if (m > 0) {
            parami.dE(8);
          }
          k = 0;
          while (k < 1 << m)
          {
            parami.dE(8);
            k += 1;
          }
          j += 1;
        }
        parami.dE(2);
        int i2 = parami.dD(4);
        k = 0;
        j = 0;
        int m = 0;
        while (j < i1)
        {
          m += arrayOfInt2[arrayOfInt1[j]];
          while (k < m)
          {
            parami.dE(i2);
            k += 1;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(95065);
  }
  
  public static int dF(int paramInt)
  {
    int i = 0;
    while (paramInt > 0)
    {
      i += 1;
      paramInt >>>= 1;
    }
    return i;
  }
  
  public static final class b
  {
    public final String aJC;
    public final String[] aJD;
    public final int length;
    
    public b(String paramString, String[] paramArrayOfString, int paramInt)
    {
      this.aJC = paramString;
      this.aJD = paramArrayOfString;
      this.length = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.k
 * JD-Core Version:    0.7.0.1
 */