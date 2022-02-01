package com.google.b;

import java.util.Arrays;

public abstract class h
{
  int bPn;
  int bPo = 100;
  int bPp = 2147483647;
  boolean bPq = false;
  
  static h c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramArrayOfByte = new a(paramArrayOfByte, paramInt1, paramInt2, paramBoolean, (byte)0);
    try
    {
      paramArrayOfByte.gA(paramInt2);
      return paramArrayOfByte;
    }
    catch (bf paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  public static h z(byte[] paramArrayOfByte)
  {
    return c(paramArrayOfByte, 0, paramArrayOfByte.length, false);
  }
  
  public abstract int AA();
  
  public abstract boolean AB();
  
  public abstract String AC();
  
  public abstract g AD();
  
  public abstract int AE();
  
  public abstract int AF();
  
  public abstract int AG();
  
  public abstract long AH();
  
  public abstract int AI();
  
  public abstract long AJ();
  
  public abstract int AK();
  
  abstract long AL();
  
  public abstract int AM();
  
  public abstract int Av();
  
  public abstract long Aw();
  
  public abstract long Ax();
  
  public abstract int Ay();
  
  public abstract long Az();
  
  public abstract <T extends bw> T a(ci<T> paramci, ap paramap);
  
  public abstract void a(int paramInt, bw.a parama, ap paramap);
  
  public abstract void a(bw.a parama, ap paramap);
  
  public abstract int gA(int paramInt);
  
  public abstract void gB(int paramInt);
  
  public abstract void gy(int paramInt);
  
  public abstract boolean gz(int paramInt);
  
  public abstract double readDouble();
  
  public abstract float readFloat();
  
  public abstract String readString();
  
  static final class a
    extends h
  {
    private final boolean bPr;
    private int bPs;
    private int bPt;
    private int bPu;
    private boolean bPv;
    private int bPw = 2147483647;
    private final byte[] buffer;
    private int limit;
    private int pos;
    
    private a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      super();
      this.buffer = paramArrayOfByte;
      this.limit = (paramInt1 + paramInt2);
      this.pos = paramInt1;
      this.bPt = this.pos;
      this.bPr = paramBoolean;
    }
    
    private long AN()
    {
      int i = this.pos;
      byte[] arrayOfByte;
      int j;
      int k;
      long l;
      if (this.limit != i)
      {
        arrayOfByte = this.buffer;
        j = i + 1;
        k = arrayOfByte[i];
        if (k >= 0)
        {
          this.pos = j;
          return k;
        }
        if (this.limit - j >= 9)
        {
          i = j + 1;
          k ^= arrayOfByte[j] << 7;
          if (k < 0) {
            l = k ^ 0xFFFFFF80;
          }
        }
      }
      for (;;)
      {
        this.pos = i;
        return l;
        j = i + 1;
        k ^= arrayOfByte[i] << 14;
        if (k >= 0)
        {
          l = k ^ 0x3F80;
          i = j;
        }
        else
        {
          i = j + 1;
          j = k ^ arrayOfByte[j] << 21;
          if (j < 0)
          {
            l = j ^ 0xFFE03F80;
          }
          else
          {
            l = j;
            j = i + 1;
            l ^= arrayOfByte[i] << 28;
            if (l >= 0L)
            {
              l ^= 0xFE03F80;
              i = j;
            }
            else
            {
              i = j + 1;
              l ^= arrayOfByte[j] << 35;
              if (l < 0L)
              {
                l ^= 0xFE03F80;
              }
              else
              {
                j = i + 1;
                l ^= arrayOfByte[i] << 42;
                if (l >= 0L)
                {
                  l ^= 0xFE03F80;
                  i = j;
                }
                else
                {
                  i = j + 1;
                  l ^= arrayOfByte[j] << 49;
                  if (l < 0L)
                  {
                    l ^= 0xFE03F80;
                  }
                  else
                  {
                    j = i + 1;
                    l = l ^ arrayOfByte[i] << 56 ^ 0xFE03F80;
                    if (l < 0L)
                    {
                      i = j + 1;
                      if (arrayOfByte[j] < 0L) {
                        return AL();
                      }
                    }
                    else
                    {
                      i = j;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    private int AO()
    {
      int i = this.pos;
      if (this.limit - i < 4) {
        throw bf.In();
      }
      byte[] arrayOfByte = this.buffer;
      this.pos = (i + 4);
      int j = arrayOfByte[i];
      int k = arrayOfByte[(i + 1)];
      int m = arrayOfByte[(i + 2)];
      return (arrayOfByte[(i + 3)] & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
    }
    
    private long AP()
    {
      int i = this.pos;
      if (this.limit - i < 8) {
        throw bf.In();
      }
      byte[] arrayOfByte = this.buffer;
      this.pos = (i + 8);
      long l1 = arrayOfByte[i];
      long l2 = arrayOfByte[(i + 1)];
      long l3 = arrayOfByte[(i + 2)];
      long l4 = arrayOfByte[(i + 3)];
      long l5 = arrayOfByte[(i + 4)];
      long l6 = arrayOfByte[(i + 5)];
      long l7 = arrayOfByte[(i + 6)];
      return (arrayOfByte[(i + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
    }
    
    private void AQ()
    {
      this.limit += this.bPs;
      int i = this.limit - this.bPt;
      if (i > this.bPw)
      {
        this.bPs = (i - this.bPw);
        this.limit -= this.bPs;
        return;
      }
      this.bPs = 0;
    }
    
    private int AR()
    {
      return this.pos - this.bPt;
    }
    
    private byte AS()
    {
      if (this.pos == this.limit) {
        throw bf.In();
      }
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = (i + 1);
      return arrayOfByte[i];
    }
    
    private void gC(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt <= this.limit - this.pos))
      {
        this.pos += paramInt;
        return;
      }
      if (paramInt < 0) {
        throw bf.Io();
      }
      throw bf.In();
    }
    
    public final int AA()
    {
      return AO();
    }
    
    public final boolean AB()
    {
      return AN() != 0L;
    }
    
    public final String AC()
    {
      int i = AK();
      if ((i > 0) && (i <= this.limit - this.pos))
      {
        String str = dg.t(this.buffer, this.pos, i);
        this.pos = (i + this.pos);
        return str;
      }
      if (i == 0) {
        return "";
      }
      if (i <= 0) {
        throw bf.Io();
      }
      throw bf.In();
    }
    
    public final g AD()
    {
      int i = AK();
      if ((i > 0) && (i <= this.limit - this.pos))
      {
        if ((this.bPr) && (this.bPv)) {}
        for (localObject = g.q(this.buffer, this.pos, i);; localObject = g.p(this.buffer, this.pos, i))
        {
          this.pos = (i + this.pos);
          return localObject;
        }
      }
      if (i == 0) {
        return g.bPf;
      }
      int j;
      if ((i > 0) && (i <= this.limit - this.pos))
      {
        j = this.pos;
        this.pos = (i + this.pos);
      }
      for (Object localObject = Arrays.copyOfRange(this.buffer, j, this.pos);; localObject = be.EMPTY_BYTE_ARRAY)
      {
        return g.y((byte[])localObject);
        if (i > 0) {
          break label154;
        }
        if (i != 0) {
          break;
        }
      }
      throw bf.Io();
      label154:
      throw bf.In();
    }
    
    public final int AE()
    {
      return AK();
    }
    
    public final int AF()
    {
      return AK();
    }
    
    public final int AG()
    {
      return AO();
    }
    
    public final long AH()
    {
      return AP();
    }
    
    public final int AI()
    {
      int i = AK();
      return -(i & 0x1) ^ i >>> 1;
    }
    
    public final long AJ()
    {
      long l = AN();
      return -(l & 1L) ^ l >>> 1;
    }
    
    public final int AK()
    {
      int i = this.pos;
      byte[] arrayOfByte;
      int j;
      int k;
      if (this.limit != i)
      {
        arrayOfByte = this.buffer;
        j = i + 1;
        k = arrayOfByte[i];
        if (k >= 0)
        {
          this.pos = j;
          return k;
        }
        if (this.limit - j >= 9)
        {
          i = j + 1;
          k ^= arrayOfByte[j] << 7;
          if (k < 0) {
            j = k ^ 0xFFFFFF80;
          }
        }
      }
      for (;;)
      {
        this.pos = i;
        return j;
        j = i + 1;
        k ^= arrayOfByte[i] << 14;
        if (k >= 0)
        {
          k ^= 0x3F80;
          i = j;
          j = k;
        }
        else
        {
          i = j + 1;
          k ^= arrayOfByte[j] << 21;
          if (k < 0)
          {
            j = k ^ 0xFFE03F80;
          }
          else
          {
            int m = i + 1;
            j = arrayOfByte[i];
            k = k ^ j << 28 ^ 0xFE03F80;
            i = m;
            if (j < 0)
            {
              int n = m + 1;
              j = k;
              i = n;
              if (arrayOfByte[m] >= 0) {
                continue;
              }
              m = n + 1;
              i = m;
              if (arrayOfByte[n] < 0)
              {
                n = m + 1;
                j = k;
                i = n;
                if (arrayOfByte[m] >= 0) {
                  continue;
                }
                m = n + 1;
                i = m;
                if (arrayOfByte[n] < 0)
                {
                  i = m + 1;
                  j = k;
                  if (arrayOfByte[m] >= 0) {
                    continue;
                  }
                  return (int)AL();
                }
              }
            }
            j = k;
          }
        }
      }
    }
    
    final long AL()
    {
      long l = 0L;
      int i = 0;
      while (i < 64)
      {
        int j = AS();
        l |= (j & 0x7F) << i;
        if ((j & 0x80) == 0) {
          return l;
        }
        i += 7;
      }
      throw bf.Ip();
    }
    
    public final int AM()
    {
      if (this.bPw == 2147483647) {
        return -1;
      }
      return this.bPw - AR();
    }
    
    public final int Av()
    {
      if (this.pos == this.limit) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.bPu = 0;
        return 0;
      }
      this.bPu = AK();
      if (dh.hP(this.bPu) == 0) {
        throw bf.Iq();
      }
      return this.bPu;
    }
    
    public final long Aw()
    {
      return AN();
    }
    
    public final long Ax()
    {
      return AN();
    }
    
    public final int Ay()
    {
      return AK();
    }
    
    public final long Az()
    {
      return AP();
    }
    
    public final <T extends bw> T a(ci<T> paramci, ap paramap)
    {
      int i = AK();
      if (this.bPn >= this.bPo) {
        throw bf.It();
      }
      i = gA(i);
      this.bPn += 1;
      paramci = (bw)paramci.d(this, paramap);
      gy(0);
      this.bPn -= 1;
      gB(i);
      return paramci;
    }
    
    public final void a(int paramInt, bw.a parama, ap paramap)
    {
      if (this.bPn >= this.bPo) {
        throw bf.It();
      }
      this.bPn += 1;
      parama.c(this, paramap);
      gy(dh.bT(paramInt, 4));
      this.bPn -= 1;
    }
    
    public final void a(bw.a parama, ap paramap)
    {
      int i = AK();
      if (this.bPn >= this.bPo) {
        throw bf.It();
      }
      i = gA(i);
      this.bPn += 1;
      parama.c(this, paramap);
      gy(0);
      this.bPn -= 1;
      gB(i);
    }
    
    public final int gA(int paramInt)
    {
      if (paramInt < 0) {
        throw bf.Io();
      }
      paramInt = AR() + paramInt;
      int i = this.bPw;
      if (paramInt > i) {
        throw bf.In();
      }
      this.bPw = paramInt;
      AQ();
      return i;
    }
    
    public final void gB(int paramInt)
    {
      this.bPw = paramInt;
      AQ();
    }
    
    public final void gy(int paramInt)
    {
      if (this.bPu != paramInt) {
        throw bf.Ir();
      }
    }
    
    public final boolean gz(int paramInt)
    {
      int j = 0;
      int i = 0;
      switch (dh.hO(paramInt))
      {
      default: 
        throw bf.Is();
      case 0: 
        paramInt = j;
        if (this.limit - this.pos >= 10)
        {
          paramInt = i;
          while (paramInt < 10)
          {
            byte[] arrayOfByte = this.buffer;
            i = this.pos;
            this.pos = (i + 1);
            if (arrayOfByte[i] >= 0) {
              break label142;
            }
            paramInt += 1;
          }
          throw bf.Ip();
        }
        while (paramInt < 10)
        {
          if (AS() >= 0) {
            break label142;
          }
          paramInt += 1;
        }
        throw bf.Ip();
      case 1: 
        gC(8);
        return true;
      case 2: 
        gC(AK());
        return true;
      case 3: 
        do
        {
          i = Av();
        } while ((i != 0) && (gz(i)));
        gy(dh.bT(dh.hP(paramInt), 4));
        return true;
      case 4: 
        label142:
        return false;
      }
      gC(4);
      return true;
    }
    
    public final double readDouble()
    {
      return Double.longBitsToDouble(AP());
    }
    
    public final float readFloat()
    {
      return Float.intBitsToFloat(AO());
    }
    
    public final String readString()
    {
      int i = AK();
      if ((i > 0) && (i <= this.limit - this.pos))
      {
        String str = new String(this.buffer, this.pos, i, be.UTF_8);
        this.pos = (i + this.pos);
        return str;
      }
      if (i == 0) {
        return "";
      }
      if (i < 0) {
        throw bf.Io();
      }
      throw bf.In();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.h
 * JD-Core Version:    0.7.0.1
 */