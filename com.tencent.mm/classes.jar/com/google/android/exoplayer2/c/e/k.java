package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k
{
  static void a(int paramInt, i parami)
  {
    AppMethodBeat.i(92179);
    int m = parami.hQ(6);
    int i = 0;
    if (i < m + 1)
    {
      switch (parami.hQ(16))
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (parami.Sg()) {}
        for (int j = parami.hQ(4) + 1; parami.Sg(); j = 1)
        {
          int n = parami.hQ(8);
          k = 0;
          while (k < n + 1)
          {
            parami.hR(hS(paramInt - 1));
            parami.hR(hS(paramInt - 1));
            k += 1;
          }
        }
        if (parami.hQ(2) != 0)
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
            parami.hR(4);
            k += 1;
          }
        }
        int k = 0;
        while (k < j)
        {
          parami.hR(8);
          parami.hR(8);
          parami.hR(8);
          k += 1;
        }
      }
    }
    AppMethodBeat.o(92179);
  }
  
  public static boolean a(int paramInt, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(92177);
    if (paramm.UF() < 7)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(92177);
        return false;
      }
      paramm = new o("too short header: " + paramm.UF());
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
    int j = parami.hQ(6) + 1;
    c[] arrayOfc = new c[j];
    int i = 0;
    while (i < j)
    {
      arrayOfc[i] = new c(parami.Sg(), parami.hQ(16), parami.hQ(16), parami.hQ(8));
      i += 1;
    }
    AppMethodBeat.o(92178);
    return arrayOfc;
  }
  
  static void b(i parami)
  {
    AppMethodBeat.i(92180);
    int m = parami.hQ(6);
    int i = 0;
    int n;
    int[] arrayOfInt;
    int j;
    label92:
    int i1;
    if (i < m + 1)
    {
      if (parami.hQ(16) > 2)
      {
        parami = new o("residueType greater than 2 is not decodable");
        AppMethodBeat.o(92180);
        throw parami;
      }
      parami.hR(24);
      parami.hR(24);
      parami.hR(24);
      n = parami.hQ(6) + 1;
      parami.hR(8);
      arrayOfInt = new int[n];
      j = 0;
      if (j < n)
      {
        i1 = parami.hQ(3);
        if (!parami.Sg()) {
          break label196;
        }
      }
    }
    label196:
    for (int k = parami.hQ(5);; k = 0)
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
            parami.hR(8);
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
    int n = parami.hQ(6);
    int i = 0;
    while (i < n + 1)
    {
      int j = parami.hQ(16);
      int k;
      switch (j)
      {
      default: 
        parami = new o("floor type greater than 1 not decodable: ".concat(String.valueOf(j)));
        AppMethodBeat.o(92181);
        throw parami;
      case 0: 
        parami.hR(8);
        parami.hR(16);
        parami.hR(16);
        parami.hR(6);
        parami.hR(8);
        k = parami.hQ(4);
        j = 0;
      }
      while (j < k + 1)
      {
        parami.hR(8);
        j += 1;
        continue;
        int i1 = parami.hQ(5);
        k = -1;
        int[] arrayOfInt1 = new int[i1];
        j = 0;
        while (j < i1)
        {
          arrayOfInt1[j] = parami.hQ(4);
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
          arrayOfInt2[j] = (parami.hQ(3) + 1);
          m = parami.hQ(2);
          if (m > 0) {
            parami.hR(8);
          }
          k = 0;
          while (k < 1 << m)
          {
            parami.hR(8);
            k += 1;
          }
          j += 1;
        }
        parami.hR(2);
        int i2 = parami.hQ(4);
        k = 0;
        j = 0;
        int m = 0;
        while (j < i1)
        {
          m += arrayOfInt2[arrayOfInt1[j]];
          while (k < m)
          {
            parami.hR(i2);
            k += 1;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(92181);
  }
  
  public static int hS(int paramInt)
  {
    int i = 0;
    while (paramInt > 0)
    {
      i += 1;
      paramInt >>>= 1;
    }
    return i;
  }
  
  public static final class c
  {
    public final boolean cTv;
    public final int cTw;
    public final int cTx;
    public final int cTy;
    
    public c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
    {
      this.cTv = paramBoolean;
      this.cTw = paramInt1;
      this.cTx = paramInt2;
      this.cTy = paramInt3;
    }
  }
  
  public static final class d
  {
    public final int cTA;
    public final int cTB;
    public final int cTC;
    public final int cTD;
    public final int cTE;
    public final boolean cTF;
    public final long cTz;
    public final int channels;
    public final byte[] data;
    public final long sampleRate;
    
    public d(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, byte[] paramArrayOfByte)
    {
      this.cTz = paramLong1;
      this.channels = paramInt1;
      this.sampleRate = paramLong2;
      this.cTA = paramInt2;
      this.cTB = paramInt3;
      this.cTC = paramInt4;
      this.cTD = paramInt5;
      this.cTE = paramInt6;
      this.cTF = paramBoolean;
      this.data = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.k
 * JD-Core Version:    0.7.0.1
 */