package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k
{
  static void a(int paramInt, i parami)
  {
    AppMethodBeat.i(92179);
    int m = parami.es(6);
    int i = 0;
    if (i < m + 1)
    {
      switch (parami.es(16))
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (parami.uD()) {}
        for (int j = parami.es(4) + 1; parami.uD(); j = 1)
        {
          int n = parami.es(8);
          k = 0;
          while (k < n + 1)
          {
            parami.et(eu(paramInt - 1));
            parami.et(eu(paramInt - 1));
            k += 1;
          }
        }
        if (parami.es(2) != 0)
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
            parami.et(4);
            k += 1;
          }
        }
        int k = 0;
        while (k < j)
        {
          parami.et(8);
          parami.et(8);
          parami.et(8);
          k += 1;
        }
      }
    }
    AppMethodBeat.o(92179);
  }
  
  public static boolean a(int paramInt, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(92177);
    if (paramm.wV() < 7)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(92177);
        return false;
      }
      paramm = new o("too short header: " + paramm.wV());
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
    int j = parami.es(6) + 1;
    c[] arrayOfc = new c[j];
    int i = 0;
    while (i < j)
    {
      arrayOfc[i] = new c(parami.uD(), parami.es(16), parami.es(16), parami.es(8));
      i += 1;
    }
    AppMethodBeat.o(92178);
    return arrayOfc;
  }
  
  static void b(i parami)
  {
    AppMethodBeat.i(92180);
    int m = parami.es(6);
    int i = 0;
    int n;
    int[] arrayOfInt;
    int j;
    label92:
    int i1;
    if (i < m + 1)
    {
      if (parami.es(16) > 2)
      {
        parami = new o("residueType greater than 2 is not decodable");
        AppMethodBeat.o(92180);
        throw parami;
      }
      parami.et(24);
      parami.et(24);
      parami.et(24);
      n = parami.es(6) + 1;
      parami.et(8);
      arrayOfInt = new int[n];
      j = 0;
      if (j < n)
      {
        i1 = parami.es(3);
        if (!parami.uD()) {
          break label196;
        }
      }
    }
    label196:
    for (int k = parami.es(5);; k = 0)
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
            parami.et(8);
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
    int n = parami.es(6);
    int i = 0;
    while (i < n + 1)
    {
      int j = parami.es(16);
      int k;
      switch (j)
      {
      default: 
        parami = new o("floor type greater than 1 not decodable: ".concat(String.valueOf(j)));
        AppMethodBeat.o(92181);
        throw parami;
      case 0: 
        parami.et(8);
        parami.et(16);
        parami.et(16);
        parami.et(6);
        parami.et(8);
        k = parami.es(4);
        j = 0;
      }
      while (j < k + 1)
      {
        parami.et(8);
        j += 1;
        continue;
        int i1 = parami.es(5);
        k = -1;
        int[] arrayOfInt1 = new int[i1];
        j = 0;
        while (j < i1)
        {
          arrayOfInt1[j] = parami.es(4);
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
          arrayOfInt2[j] = (parami.es(3) + 1);
          m = parami.es(2);
          if (m > 0) {
            parami.et(8);
          }
          k = 0;
          while (k < 1 << m)
          {
            parami.et(8);
            k += 1;
          }
          j += 1;
        }
        parami.et(2);
        int i2 = parami.es(4);
        k = 0;
        j = 0;
        int m = 0;
        while (j < i1)
        {
          m += arrayOfInt2[arrayOfInt1[j]];
          while (k < m)
          {
            parami.et(i2);
            k += 1;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(92181);
  }
  
  public static int eu(int paramInt)
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
    public final int bpY;
    public final long[] bpZ;
    public final int bqa;
    public final boolean bqb;
    public final int entries;
    
    public a(int paramInt1, int paramInt2, long[] paramArrayOfLong, int paramInt3, boolean paramBoolean)
    {
      this.bpY = paramInt1;
      this.entries = paramInt2;
      this.bpZ = paramArrayOfLong;
      this.bqa = paramInt3;
      this.bqb = paramBoolean;
    }
  }
  
  public static final class b
  {
    public final String[] bqc;
    public final int length;
    public final String vendor;
    
    public b(String paramString, String[] paramArrayOfString, int paramInt)
    {
      this.vendor = paramString;
      this.bqc = paramArrayOfString;
      this.length = paramInt;
    }
  }
  
  public static final class c
  {
    public final boolean bqd;
    public final int bqe;
    public final int bqf;
    public final int bqg;
    
    public c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
    {
      this.bqd = paramBoolean;
      this.bqe = paramInt1;
      this.bqf = paramInt2;
      this.bqg = paramInt3;
    }
  }
  
  public static final class d
  {
    public final long bqh;
    public final int bqi;
    public final int bqj;
    public final int bqk;
    public final int bql;
    public final int bqm;
    public final boolean bqn;
    public final int channels;
    public final byte[] data;
    public final long sampleRate;
    
    public d(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, byte[] paramArrayOfByte)
    {
      this.bqh = paramLong1;
      this.channels = paramInt1;
      this.sampleRate = paramLong2;
      this.bqi = paramInt2;
      this.bqj = paramInt3;
      this.bqk = paramInt4;
      this.bql = paramInt5;
      this.bqm = paramInt6;
      this.bqn = paramBoolean;
      this.data = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.k
 * JD-Core Version:    0.7.0.1
 */