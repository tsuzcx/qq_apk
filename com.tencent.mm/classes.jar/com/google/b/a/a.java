package com.google.b.a;

public final class a
{
  private int bIJ;
  private int bIK;
  private int bIL;
  private int bIM;
  private int bIN = 2147483647;
  private int bIO;
  private int bIP = 64;
  private int bIQ = 67108864;
  private final byte[] buffer;
  private int bufferSize;
  
  a(byte[] paramArrayOfByte, int paramInt)
  {
    this.buffer = paramArrayOfByte;
    this.bIJ = 0;
    this.bufferSize = (paramInt + 0);
    this.bIL = 0;
  }
  
  private byte[] fU(int paramInt)
  {
    if (paramInt < 0) {
      throw d.xY();
    }
    if (this.bIL + paramInt > this.bIN)
    {
      fV(this.bIN - this.bIL);
      throw d.xX();
    }
    if (paramInt <= this.bufferSize - this.bIL)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.bIL, arrayOfByte, 0, paramInt);
      this.bIL += paramInt;
      return arrayOfByte;
    }
    throw d.xX();
  }
  
  private void fV(int paramInt)
  {
    if (paramInt < 0) {
      throw d.xY();
    }
    if (this.bIL + paramInt > this.bIN)
    {
      fV(this.bIN - this.bIL);
      throw d.xX();
    }
    if (paramInt <= this.bufferSize - this.bIL)
    {
      this.bIL += paramInt;
      return;
    }
    throw d.xX();
  }
  
  private void xU()
  {
    this.bufferSize += this.bIK;
    int i = this.bufferSize;
    if (i > this.bIN)
    {
      this.bIK = (i - this.bIN);
      this.bufferSize -= this.bIK;
      return;
    }
    this.bIK = 0;
  }
  
  private byte xW()
  {
    if (this.bIL == this.bufferSize) {
      throw d.xX();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bIL;
    this.bIL = (i + 1);
    return arrayOfByte[i];
  }
  
  public final void a(e parame)
  {
    int i = xS();
    if (this.bIO >= this.bIP) {
      throw d.yd();
    }
    i = fR(i);
    this.bIO += 1;
    parame.a(this);
    fP(0);
    this.bIO -= 1;
    fS(i);
  }
  
  public final void fP(int paramInt)
  {
    if (this.bIM != paramInt) {
      throw d.yb();
    }
  }
  
  public final boolean fQ(int paramInt)
  {
    switch (g.gb(paramInt))
    {
    default: 
      throw d.yc();
    case 0: 
      xS();
      return true;
    case 1: 
      xW();
      xW();
      xW();
      xW();
      xW();
      xW();
      xW();
      xW();
      return true;
    case 2: 
      fV(xS());
      return true;
    case 3: 
      int i;
      do
      {
        i = xR();
      } while ((i != 0) && (fQ(i)));
      fP(g.bD(g.gc(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    xW();
    xW();
    xW();
    xW();
    return true;
  }
  
  public final int fR(int paramInt)
  {
    if (paramInt < 0) {
      throw d.xY();
    }
    paramInt = this.bIL + paramInt;
    int i = this.bIN;
    if (paramInt > i) {
      throw d.xX();
    }
    this.bIN = paramInt;
    xU();
    return i;
  }
  
  public final void fS(int paramInt)
  {
    this.bIN = paramInt;
    xU();
  }
  
  public final void fT(int paramInt)
  {
    if (paramInt > this.bIL - this.bIJ) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.bIL - this.bIJ));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position ".concat(String.valueOf(paramInt)));
    }
    this.bIL = (this.bIJ + paramInt);
  }
  
  public final int getPosition()
  {
    return this.bIL - this.bIJ;
  }
  
  public final byte[] readBytes()
  {
    int i = xS();
    if ((i <= this.bufferSize - this.bIL) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.bIL, arrayOfByte, 0, i);
      this.bIL = (i + this.bIL);
      return arrayOfByte;
    }
    return fU(i);
  }
  
  public final String readString()
  {
    int i = xS();
    if ((i <= this.bufferSize - this.bIL) && (i > 0))
    {
      String str = new String(this.buffer, this.bIL, i, "UTF-8");
      this.bIL = (i + this.bIL);
      return str;
    }
    return new String(fU(i), "UTF-8");
  }
  
  public final int xR()
  {
    if (this.bIL == this.bufferSize) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.bIM = 0;
      return 0;
    }
    this.bIM = xS();
    if (this.bIM == 0) {
      throw d.ya();
    }
    return this.bIM;
  }
  
  public final int xS()
  {
    int i = xW();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = xW();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = xW();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = xW();
      if (k >= 0) {
        return i | k << 21;
      }
      j = xW();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        break label133;
      }
      i = k;
      if (xW() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw d.xZ();
  }
  
  public final long xT()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = xW();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw d.xZ();
  }
  
  public final int xV()
  {
    if (this.bIN == 2147483647) {
      return -1;
    }
    int i = this.bIL;
    return this.bIN - i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.a
 * JD-Core Version:    0.7.0.1
 */