package com.google.b.a;

public final class a
{
  private int bGr;
  private int bGs;
  private int bGt;
  private int bGu;
  private int bGv = 2147483647;
  private int bGw;
  private int bGx = 64;
  private int bGy = 67108864;
  private final byte[] buffer;
  private int bufferSize;
  
  a(byte[] paramArrayOfByte, int paramInt)
  {
    this.buffer = paramArrayOfByte;
    this.bGr = 0;
    this.bufferSize = (paramInt + 0);
    this.bGt = 0;
  }
  
  private byte[] fG(int paramInt)
  {
    if (paramInt < 0) {
      throw d.xL();
    }
    if (this.bGt + paramInt > this.bGv)
    {
      fH(this.bGv - this.bGt);
      throw d.xK();
    }
    if (paramInt <= this.bufferSize - this.bGt)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.bGt, arrayOfByte, 0, paramInt);
      this.bGt += paramInt;
      return arrayOfByte;
    }
    throw d.xK();
  }
  
  private void fH(int paramInt)
  {
    if (paramInt < 0) {
      throw d.xL();
    }
    if (this.bGt + paramInt > this.bGv)
    {
      fH(this.bGv - this.bGt);
      throw d.xK();
    }
    if (paramInt <= this.bufferSize - this.bGt)
    {
      this.bGt += paramInt;
      return;
    }
    throw d.xK();
  }
  
  private void xH()
  {
    this.bufferSize += this.bGs;
    int i = this.bufferSize;
    if (i > this.bGv)
    {
      this.bGs = (i - this.bGv);
      this.bufferSize -= this.bGs;
      return;
    }
    this.bGs = 0;
  }
  
  private byte xJ()
  {
    if (this.bGt == this.bufferSize) {
      throw d.xK();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bGt;
    this.bGt = (i + 1);
    return arrayOfByte[i];
  }
  
  public final void a(e parame)
  {
    int i = xF();
    if (this.bGw >= this.bGx) {
      throw d.xQ();
    }
    i = fD(i);
    this.bGw += 1;
    parame.a(this);
    fB(0);
    this.bGw -= 1;
    fE(i);
  }
  
  public final void fB(int paramInt)
  {
    if (this.bGu != paramInt) {
      throw d.xO();
    }
  }
  
  public final boolean fC(int paramInt)
  {
    switch (g.fN(paramInt))
    {
    default: 
      throw d.xP();
    case 0: 
      xF();
      return true;
    case 1: 
      xJ();
      xJ();
      xJ();
      xJ();
      xJ();
      xJ();
      xJ();
      xJ();
      return true;
    case 2: 
      fH(xF());
      return true;
    case 3: 
      int i;
      do
      {
        i = xE();
      } while ((i != 0) && (fC(i)));
      fB(g.bA(g.fO(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    xJ();
    xJ();
    xJ();
    xJ();
    return true;
  }
  
  public final int fD(int paramInt)
  {
    if (paramInt < 0) {
      throw d.xL();
    }
    paramInt = this.bGt + paramInt;
    int i = this.bGv;
    if (paramInt > i) {
      throw d.xK();
    }
    this.bGv = paramInt;
    xH();
    return i;
  }
  
  public final void fE(int paramInt)
  {
    this.bGv = paramInt;
    xH();
  }
  
  public final void fF(int paramInt)
  {
    if (paramInt > this.bGt - this.bGr) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.bGt - this.bGr));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position ".concat(String.valueOf(paramInt)));
    }
    this.bGt = (this.bGr + paramInt);
  }
  
  public final int getPosition()
  {
    return this.bGt - this.bGr;
  }
  
  public final byte[] readBytes()
  {
    int i = xF();
    if ((i <= this.bufferSize - this.bGt) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.bGt, arrayOfByte, 0, i);
      this.bGt = (i + this.bGt);
      return arrayOfByte;
    }
    return fG(i);
  }
  
  public final String readString()
  {
    int i = xF();
    if ((i <= this.bufferSize - this.bGt) && (i > 0))
    {
      String str = new String(this.buffer, this.bGt, i, "UTF-8");
      this.bGt = (i + this.bGt);
      return str;
    }
    return new String(fG(i), "UTF-8");
  }
  
  public final int xE()
  {
    if (this.bGt == this.bufferSize) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.bGu = 0;
      return 0;
    }
    this.bGu = xF();
    if (this.bGu == 0) {
      throw d.xN();
    }
    return this.bGu;
  }
  
  public final int xF()
  {
    int i = xJ();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = xJ();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = xJ();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = xJ();
      if (k >= 0) {
        return i | k << 21;
      }
      j = xJ();
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
      if (xJ() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw d.xM();
  }
  
  public final long xG()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = xJ();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw d.xM();
  }
  
  public final int xI()
  {
    if (this.bGv == 2147483647) {
      return -1;
    }
    int i = this.bGt;
    return this.bGv - i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.a
 * JD-Core Version:    0.7.0.1
 */