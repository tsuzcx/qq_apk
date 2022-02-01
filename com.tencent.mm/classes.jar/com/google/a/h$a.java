package com.google.a;

import java.util.Arrays;

final class h$a
  extends h
{
  private final boolean bNs;
  private int bNt;
  private int bNu;
  private int bNv;
  private boolean bNw;
  private int bNx = 2147483647;
  private final byte[] buffer;
  private int limit;
  private int pos;
  
  private h$a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super((byte)0);
    this.buffer = paramArrayOfByte;
    this.limit = (paramInt1 + paramInt2);
    this.pos = paramInt1;
    this.bNu = this.pos;
    this.bNs = paramBoolean;
  }
  
  private void fJ(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.limit - this.pos))
    {
      this.pos += paramInt;
      return;
    }
    if (paramInt < 0) {
      throw af.GH();
    }
    throw af.GG();
  }
  
  private long zl()
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
                      return zj();
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
  
  private int zm()
  {
    int i = this.pos;
    if (this.limit - i < 4) {
      throw af.GG();
    }
    byte[] arrayOfByte = this.buffer;
    this.pos = (i + 4);
    int j = arrayOfByte[i];
    int k = arrayOfByte[(i + 1)];
    int m = arrayOfByte[(i + 2)];
    return (arrayOfByte[(i + 3)] & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
  }
  
  private long zn()
  {
    int i = this.pos;
    if (this.limit - i < 8) {
      throw af.GG();
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
  
  private void zo()
  {
    this.limit += this.bNt;
    int i = this.limit - this.bNu;
    if (i > this.bNx)
    {
      this.bNt = (i - this.bNx);
      this.limit -= this.bNt;
      return;
    }
    this.bNt = 0;
  }
  
  private int zp()
  {
    return this.pos - this.bNu;
  }
  
  private byte zq()
  {
    if (this.pos == this.limit) {
      throw af.GG();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.pos;
    this.pos = (i + 1);
    return arrayOfByte[i];
  }
  
  public final <T extends aw> T a(bj<T> parambj, r paramr)
  {
    int i = zi();
    if (this.bNo >= this.bNp) {
      throw af.GM();
    }
    i = fH(i);
    this.bNo += 1;
    parambj = (aw)parambj.d(this, paramr);
    fF(0);
    this.bNo -= 1;
    fI(i);
    return parambj;
  }
  
  public final void a(int paramInt, aw.a parama, r paramr)
  {
    if (this.bNo >= this.bNp) {
      throw af.GM();
    }
    this.bNo += 1;
    parama.c(this, paramr);
    fF(cj.bA(paramInt, 4));
    this.bNo -= 1;
  }
  
  public final void a(aw.a parama, r paramr)
  {
    int i = zi();
    if (this.bNo >= this.bNp) {
      throw af.GM();
    }
    i = fH(i);
    this.bNo += 1;
    parama.c(this, paramr);
    fF(0);
    this.bNo -= 1;
    fI(i);
  }
  
  public final void fF(int paramInt)
  {
    if (this.bNv != paramInt) {
      throw af.GK();
    }
  }
  
  public final boolean fG(int paramInt)
  {
    int j = 0;
    int i = 0;
    switch (cj.gX(paramInt))
    {
    default: 
      throw af.GL();
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
        throw af.GI();
      }
      while (paramInt < 10)
      {
        if (zq() >= 0) {
          break label142;
        }
        paramInt += 1;
      }
      throw af.GI();
    case 1: 
      fJ(8);
      return true;
    case 2: 
      fJ(zi());
      return true;
    case 3: 
      do
      {
        i = yT();
      } while ((i != 0) && (fG(i)));
      fF(cj.bA(cj.gY(paramInt), 4));
      return true;
    case 4: 
      label142:
      return false;
    }
    fJ(4);
    return true;
  }
  
  public final int fH(int paramInt)
  {
    if (paramInt < 0) {
      throw af.GH();
    }
    paramInt = zp() + paramInt;
    int i = this.bNx;
    if (paramInt > i) {
      throw af.GG();
    }
    this.bNx = paramInt;
    zo();
    return i;
  }
  
  public final void fI(int paramInt)
  {
    this.bNx = paramInt;
    zo();
  }
  
  public final double readDouble()
  {
    return Double.longBitsToDouble(zn());
  }
  
  public final float readFloat()
  {
    return Float.intBitsToFloat(zm());
  }
  
  public final String readString()
  {
    int i = zi();
    if ((i > 0) && (i <= this.limit - this.pos))
    {
      String str = new String(this.buffer, this.pos, i, ae.UTF_8);
      this.pos = (i + this.pos);
      return str;
    }
    if (i == 0) {
      return "";
    }
    if (i < 0) {
      throw af.GH();
    }
    throw af.GG();
  }
  
  public final int yT()
  {
    if (this.pos == this.limit) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.bNv = 0;
      return 0;
    }
    this.bNv = zi();
    if (cj.gY(this.bNv) == 0) {
      throw af.GJ();
    }
    return this.bNv;
  }
  
  public final long yU()
  {
    return zl();
  }
  
  public final long yV()
  {
    return zl();
  }
  
  public final int yW()
  {
    return zi();
  }
  
  public final long yX()
  {
    return zn();
  }
  
  public final int yY()
  {
    return zm();
  }
  
  public final boolean yZ()
  {
    return zl() != 0L;
  }
  
  public final String za()
  {
    int i = zi();
    if ((i > 0) && (i <= this.limit - this.pos))
    {
      String str = ci.t(this.buffer, this.pos, i);
      this.pos = (i + this.pos);
      return str;
    }
    if (i == 0) {
      return "";
    }
    if (i <= 0) {
      throw af.GH();
    }
    throw af.GG();
  }
  
  public final g zb()
  {
    int i = zi();
    if ((i > 0) && (i <= this.limit - this.pos))
    {
      if ((this.bNs) && (this.bNw)) {}
      for (localObject = g.q(this.buffer, this.pos, i);; localObject = g.p(this.buffer, this.pos, i))
      {
        this.pos = (i + this.pos);
        return localObject;
      }
    }
    if (i == 0) {
      return g.bNg;
    }
    int j;
    if ((i > 0) && (i <= this.limit - this.pos))
    {
      j = this.pos;
      this.pos = (i + this.pos);
    }
    for (Object localObject = Arrays.copyOfRange(this.buffer, j, this.pos);; localObject = ae.EMPTY_BYTE_ARRAY)
    {
      return g.A((byte[])localObject);
      if (i > 0) {
        break label154;
      }
      if (i != 0) {
        break;
      }
    }
    throw af.GH();
    label154:
    throw af.GG();
  }
  
  public final int zc()
  {
    return zi();
  }
  
  public final int zd()
  {
    return zi();
  }
  
  public final int ze()
  {
    return zm();
  }
  
  public final long zf()
  {
    return zn();
  }
  
  public final int zg()
  {
    int i = zi();
    return -(i & 0x1) ^ i >>> 1;
  }
  
  public final long zh()
  {
    long l = zl();
    return -(l & 1L) ^ l >>> 1;
  }
  
  public final int zi()
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
                return (int)zj();
              }
            }
          }
          j = k;
        }
      }
    }
  }
  
  final long zj()
  {
    long l = 0L;
    int i = 0;
    while (i < 64)
    {
      int j = zq();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw af.GI();
  }
  
  public final int zk()
  {
    if (this.bNx == 2147483647) {
      return -1;
    }
    return this.bNx - zp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.h.a
 * JD-Core Version:    0.7.0.1
 */