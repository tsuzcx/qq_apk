package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k
{
  static void a(int paramInt, i parami)
  {
    AppMethodBeat.i(92179);
    int m = parami.eA(6);
    int i = 0;
    if (i < m + 1)
    {
      switch (parami.eA(16))
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (parami.sD()) {}
        for (int j = parami.eA(4) + 1; parami.sD(); j = 1)
        {
          int n = parami.eA(8);
          k = 0;
          while (k < n + 1)
          {
            parami.eB(eC(paramInt - 1));
            parami.eB(eC(paramInt - 1));
            k += 1;
          }
        }
        if (parami.eA(2) != 0)
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
            parami.eB(4);
            k += 1;
          }
        }
        int k = 0;
        while (k < j)
        {
          parami.eB(8);
          parami.eB(8);
          parami.eB(8);
          k += 1;
        }
      }
    }
    AppMethodBeat.o(92179);
  }
  
  public static boolean a(int paramInt, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(92177);
    if (paramm.vg() < 7)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(92177);
        return false;
      }
      paramm = new o("too short header: " + paramm.vg());
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
  
  static c[] a(i parami)
  {
    AppMethodBeat.i(92178);
    int j = parami.eA(6) + 1;
    c[] arrayOfc = new c[j];
    int i = 0;
    while (i < j)
    {
      arrayOfc[i] = new c(parami.sD(), parami.eA(16), parami.eA(16), parami.eA(8));
      i += 1;
    }
    AppMethodBeat.o(92178);
    return arrayOfc;
  }
  
  static void b(i parami)
  {
    AppMethodBeat.i(92180);
    int m = parami.eA(6);
    int i = 0;
    int n;
    int[] arrayOfInt;
    int j;
    label92:
    int i1;
    if (i < m + 1)
    {
      if (parami.eA(16) > 2)
      {
        parami = new o("residueType greater than 2 is not decodable");
        AppMethodBeat.o(92180);
        throw parami;
      }
      parami.eB(24);
      parami.eB(24);
      parami.eB(24);
      n = parami.eA(6) + 1;
      parami.eB(8);
      arrayOfInt = new int[n];
      j = 0;
      if (j < n)
      {
        i1 = parami.eA(3);
        if (!parami.sD()) {
          break label196;
        }
      }
    }
    label196:
    for (int k = parami.eA(5);; k = 0)
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
            parami.eB(8);
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
    int n = parami.eA(6);
    int i = 0;
    while (i < n + 1)
    {
      int j = parami.eA(16);
      int k;
      switch (j)
      {
      default: 
        parami = new o("floor type greater than 1 not decodable: ".concat(String.valueOf(j)));
        AppMethodBeat.o(92181);
        throw parami;
      case 0: 
        parami.eB(8);
        parami.eB(16);
        parami.eB(16);
        parami.eB(6);
        parami.eB(8);
        k = parami.eA(4);
        j = 0;
      }
      while (j < k + 1)
      {
        parami.eB(8);
        j += 1;
        continue;
        int i1 = parami.eA(5);
        k = -1;
        int[] arrayOfInt1 = new int[i1];
        j = 0;
        while (j < i1)
        {
          arrayOfInt1[j] = parami.eA(4);
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
          arrayOfInt2[j] = (parami.eA(3) + 1);
          m = parami.eA(2);
          if (m > 0) {
            parami.eB(8);
          }
          k = 0;
          while (k < 1 << m)
          {
            parami.eB(8);
            k += 1;
          }
          j += 1;
        }
        parami.eB(2);
        int i2 = parami.eA(4);
        k = 0;
        j = 0;
        int m = 0;
        while (j < i1)
        {
          m += arrayOfInt2[arrayOfInt1[j]];
          while (k < m)
          {
            parami.eB(i2);
            k += 1;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(92181);
  }
  
  public static int eC(int paramInt)
  {
    int i = 0;
    while (paramInt > 0)
    {
      i += 1;
      paramInt >>>= 1;
    }
    return i;
  }
  
  public static final class a
  {
    public final int aZv;
    public final long[] aZw;
    public final int aZx;
    public final boolean aZy;
    public final int entries;
    
    public a(int paramInt1, int paramInt2, long[] paramArrayOfLong, int paramInt3, boolean paramBoolean)
    {
      this.aZv = paramInt1;
      this.entries = paramInt2;
      this.aZw = paramArrayOfLong;
      this.aZx = paramInt3;
      this.aZy = paramBoolean;
    }
  }
  
  public static final class b
  {
    public final String[] aZz;
    public final int length;
    public final String vendor;
    
    public b(String paramString, String[] paramArrayOfString, int paramInt)
    {
      this.vendor = paramString;
      this.aZz = paramArrayOfString;
      this.length = paramInt;
    }
  }
  
  public static final class c
  {
    public final boolean aZA;
    public final int aZB;
    public final int aZC;
    public final int aZD;
    
    public c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
    {
      this.aZA = paramBoolean;
      this.aZB = paramInt1;
      this.aZC = paramInt2;
      this.aZD = paramInt3;
    }
  }
  
  public static final class d
  {
    public final long aZE;
    public final int aZF;
    public final int aZG;
    public final int aZH;
    public final int aZI;
    public final int aZJ;
    public final boolean aZK;
    public final int channels;
    public final byte[] data;
    public final long sampleRate;
    
    public d(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, byte[] paramArrayOfByte)
    {
      this.aZE = paramLong1;
      this.channels = paramInt1;
      this.sampleRate = paramLong2;
      this.aZF = paramInt2;
      this.aZG = paramInt3;
      this.aZH = paramInt4;
      this.aZI = paramInt5;
      this.aZJ = paramInt6;
      this.aZK = paramBoolean;
      this.data = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.k
 * JD-Core Version:    0.7.0.1
 */