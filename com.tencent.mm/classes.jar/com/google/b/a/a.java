package com.google.b.a;

public final class a
{
  private int bQF;
  private int bQG;
  private int bQH;
  private int bQI;
  private int bQJ = 2147483647;
  private int bQK;
  private int bQL = 64;
  private int bQM = 67108864;
  private final byte[] buffer;
  private int bufferSize;
  
  a(byte[] paramArrayOfByte, int paramInt)
  {
    this.buffer = paramArrayOfByte;
    this.bQF = 0;
    this.bufferSize = (paramInt + 0);
    this.bQH = 0;
  }
  
  private byte[] fJ(int paramInt)
  {
    if (paramInt < 0) {
      throw d.zi();
    }
    if (this.bQH + paramInt > this.bQJ)
    {
      fK(this.bQJ - this.bQH);
      throw d.zh();
    }
    if (paramInt <= this.bufferSize - this.bQH)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.bQH, arrayOfByte, 0, paramInt);
      this.bQH += paramInt;
      return arrayOfByte;
    }
    throw d.zh();
  }
  
  private void fK(int paramInt)
  {
    if (paramInt < 0) {
      throw d.zi();
    }
    if (this.bQH + paramInt > this.bQJ)
    {
      fK(this.bQJ - this.bQH);
      throw d.zh();
    }
    if (paramInt <= this.bufferSize - this.bQH)
    {
      this.bQH += paramInt;
      return;
    }
    throw d.zh();
  }
  
  private void ze()
  {
    this.bufferSize += this.bQG;
    int i = this.bufferSize;
    if (i > this.bQJ)
    {
      this.bQG = (i - this.bQJ);
      this.bufferSize -= this.bQG;
      return;
    }
    this.bQG = 0;
  }
  
  private byte zg()
  {
    if (this.bQH == this.bufferSize) {
      throw d.zh();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bQH;
    this.bQH = (i + 1);
    return arrayOfByte[i];
  }
  
  public final void a(e parame)
  {
    int i = zc();
    if (this.bQK >= this.bQL) {
      throw d.zn();
    }
    i = fG(i);
    this.bQK += 1;
    parame.a(this);
    fE(0);
    this.bQK -= 1;
    fH(i);
  }
  
  public final void fE(int paramInt)
  {
    if (this.bQI != paramInt) {
      throw d.zl();
    }
  }
  
  public final boolean fF(int paramInt)
  {
    switch (g.fQ(paramInt))
    {
    default: 
      throw d.zm();
    case 0: 
      zc();
      return true;
    case 1: 
      zg();
      zg();
      zg();
      zg();
      zg();
      zg();
      zg();
      zg();
      return true;
    case 2: 
      fK(zc());
      return true;
    case 3: 
      int i;
      do
      {
        i = zb();
      } while ((i != 0) && (fF(i)));
      fE(g.bC(g.fR(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    zg();
    zg();
    zg();
    zg();
    return true;
  }
  
  public final int fG(int paramInt)
  {
    if (paramInt < 0) {
      throw d.zi();
    }
    paramInt = this.bQH + paramInt;
    int i = this.bQJ;
    if (paramInt > i) {
      throw d.zh();
    }
    this.bQJ = paramInt;
    ze();
    return i;
  }
  
  public final void fH(int paramInt)
  {
    this.bQJ = paramInt;
    ze();
  }
  
  public final void fI(int paramInt)
  {
    if (paramInt > this.bQH - this.bQF) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.bQH - this.bQF));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position ".concat(String.valueOf(paramInt)));
    }
    this.bQH = (this.bQF + paramInt);
  }
  
  public final int getPosition()
  {
    return this.bQH - this.bQF;
  }
  
  public final byte[] readBytes()
  {
    int i = zc();
    if ((i <= this.bufferSize - this.bQH) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.bQH, arrayOfByte, 0, i);
      this.bQH = (i + this.bQH);
      return arrayOfByte;
    }
    return fJ(i);
  }
  
  public final String readString()
  {
    int i = zc();
    if ((i <= this.bufferSize - this.bQH) && (i > 0))
    {
      String str = new String(this.buffer, this.bQH, i, "UTF-8");
      this.bQH = (i + this.bQH);
      return str;
    }
    return new String(fJ(i), "UTF-8");
  }
  
  public final int zb()
  {
    if (this.bQH == this.bufferSize) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.bQI = 0;
      return 0;
    }
    this.bQI = zc();
    if (this.bQI == 0) {
      throw d.zk();
    }
    return this.bQI;
  }
  
  public final int zc()
  {
    int i = zg();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = zg();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = zg();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = zg();
      if (k >= 0) {
        return i | k << 21;
      }
      j = zg();
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
      if (zg() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw d.zj();
  }
  
  public final long zd()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = zg();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw d.zj();
  }
  
  public final int zf()
  {
    if (this.bQJ == 2147483647) {
      return -1;
    }
    int i = this.bQH;
    return this.bQJ - i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.b.a.a
 * JD-Core Version:    0.7.0.1
 */