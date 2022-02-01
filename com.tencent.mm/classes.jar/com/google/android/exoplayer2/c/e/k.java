package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k
{
  static void a(int paramInt, i parami)
  {
    AppMethodBeat.i(92179);
    int m = parami.eo(6);
    int i = 0;
    if (i < m + 1)
    {
      switch (parami.eo(16))
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (parami.te()) {}
        for (int j = parami.eo(4) + 1; parami.te(); j = 1)
        {
          int n = parami.eo(8);
          k = 0;
          while (k < n + 1)
          {
            parami.ep(eq(paramInt - 1));
            parami.ep(eq(paramInt - 1));
            k += 1;
          }
        }
        if (parami.eo(2) != 0)
        {
          parami = new o("to reserved bits must be zero after mapping coupling steps");
          AppMethodBeat.o(92179);
          throw parami;
        }
        if (j > 1)
        {
          k = 0;
          while (k < paramInt)
          {
            parami.ep(4);
            k += 1;
          }
        }
        int k = 0;
        while (k < j)
        {
          parami.ep(8);
          parami.ep(8);
          parami.ep(8);
          k += 1;
        }
      }
    }
    AppMethodBeat.o(92179);
  }
  
  public static boolean a(int paramInt, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(92177);
    if (paramm.vy() < 7)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(92177);
        return false;
      }
      paramm = new o("too short header: " + paramm.vy());
      AppMethodBeat.o(92177);
      throw paramm;
    }
    if (paramm.readUnsignedByte() != paramInt)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(92177);
        return false;
      }
      paramm = new o("expected header type " + Integer.toHexString(paramInt));
      AppMethodBeat.o(92177);
      throw paramm;
    }
    if ((paramm.readUnsignedByte() != 118) || (paramm.readUnsignedByte() != 111) || (paramm.readUnsignedByte() != 114) || (paramm.readUnsignedByte() != 98) || (paramm.readUnsignedByte() != 105) || (paramm.readUnsignedByte() != 115))
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(92177);
        return false;
      }
      paramm = new o("expected characters 'vorbis'");
      AppMethodBeat.o(92177);
      throw paramm;
    }
    AppMethodBeat.o(92177);
    return true;
  }
  
  static k.c[] a(i parami)
  {
    AppMethodBeat.i(92178);
    int j = parami.eo(6) + 1;
    k.c[] arrayOfc = new k.c[j];
    int i = 0;
    while (i < j)
    {
      arrayOfc[i] = new k.c(parami.te(), parami.eo(16), parami.eo(16), parami.eo(8));
      i += 1;
    }
    AppMethodBeat.o(92178);
    return arrayOfc;
  }
  
  static void b(i parami)
  {
    AppMethodBeat.i(92180);
    int m = parami.eo(6);
    int i = 0;
    int n;
    int[] arrayOfInt;
    int j;
    label92:
    int i1;
    if (i < m + 1)
    {
      if (parami.eo(16) > 2)
      {
        parami = new o("residueType greater than 2 is not decodable");
        AppMethodBeat.o(92180);
        throw parami;
      }
      parami.ep(24);
      parami.ep(24);
      parami.ep(24);
      n = parami.eo(6) + 1;
      parami.ep(8);
      arrayOfInt = new int[n];
      j = 0;
      if (j < n)
      {
        i1 = parami.eo(3);
        if (!parami.te()) {
          break label196;
        }
      }
    }
    label196:
    for (int k = parami.eo(5);; k = 0)
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
            parami.ep(8);
          }
          k += 1;
        }
        j += 1;
      }
      i += 1;
      break;
      AppMethodBeat.o(92180);
      return;
    }
  }
  
  static void c(i parami)
  {
    AppMethodBeat.i(92181);
    int n = parami.eo(6);
    int i = 0;
    while (i < n + 1)
    {
      int j = parami.eo(16);
      int k;
      switch (j)
      {
      default: 
        parami = new o("floor type greater than 1 not decodable: ".concat(String.valueOf(j)));
        AppMethodBeat.o(92181);
        throw parami;
      case 0: 
        parami.ep(8);
        parami.ep(16);
        parami.ep(16);
        parami.ep(6);
        parami.ep(8);
        k = parami.eo(4);
        j = 0;
      }
      while (j < k + 1)
      {
        parami.ep(8);
        j += 1;
        continue;
        int i1 = parami.eo(5);
        k = -1;
        int[] arrayOfInt1 = new int[i1];
        j = 0;
        while (j < i1)
        {
          arrayOfInt1[j] = parami.eo(4);
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
          arrayOfInt2[j] = (parami.eo(3) + 1);
          m = parami.eo(2);
          if (m > 0) {
            parami.ep(8);
          }
          k = 0;
          while (k < 1 << m)
          {
            parami.ep(8);
            k += 1;
          }
          j += 1;
        }
        parami.ep(2);
        int i2 = parami.eo(4);
        k = 0;
        j = 0;
        int m = 0;
        while (j < i1)
        {
          m += arrayOfInt2[arrayOfInt1[j]];
          while (k < m)
          {
            parami.ep(i2);
            k += 1;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(92181);
  }
  
  public static int eq(int paramInt)
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
    public final String[] bfI;
    public final int length;
    public final String vendor;
    
    public b(String paramString, String[] paramArrayOfString, int paramInt)
    {
      this.vendor = paramString;
      this.bfI = paramArrayOfString;
      this.length = paramInt;
    }
  }
  
  public static final class d
  {
    public final long bfN;
    public final int bfO;
    public final int bfP;
    public final int bfQ;
    public final int bfR;
    public final int bfS;
    public final boolean bfT;
    public final int channels;
    public final byte[] data;
    public final long sampleRate;
    
    public d(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, byte[] paramArrayOfByte)
    {
      this.bfN = paramLong1;
      this.channels = paramInt1;
      this.sampleRate = paramLong2;
      this.bfO = paramInt2;
      this.bfP = paramInt3;
      this.bfQ = paramInt4;
      this.bfR = paramInt5;
      this.bfS = paramInt6;
      this.bfT = paramBoolean;
      this.data = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.k
 * JD-Core Version:    0.7.0.1
 */