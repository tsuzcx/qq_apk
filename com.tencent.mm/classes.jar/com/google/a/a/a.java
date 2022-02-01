package com.google.a.a;

public final class a
{
  private int bNo;
  private int bNp = 64;
  private int bNq = 67108864;
  private int bNt;
  private int bNv;
  private int bNx = 2147483647;
  private final byte[] buffer;
  private int bufferSize;
  private int cbl;
  private int cbm;
  
  a(byte[] paramArrayOfByte, int paramInt)
  {
    this.buffer = paramArrayOfByte;
    this.cbl = 0;
    this.bufferSize = (paramInt + 0);
    this.cbm = 0;
  }
  
  private void fJ(int paramInt)
  {
    if (paramInt < 0) {
      throw d.HZ();
    }
    if (this.cbm + paramInt > this.bNx)
    {
      fJ(this.bNx - this.cbm);
      throw d.HY();
    }
    if (paramInt <= this.bufferSize - this.cbm)
    {
      this.cbm += paramInt;
      return;
    }
    throw d.HY();
  }
  
  private byte[] ha(int paramInt)
  {
    if (paramInt < 0) {
      throw d.HZ();
    }
    if (this.cbm + paramInt > this.bNx)
    {
      fJ(this.bNx - this.cbm);
      throw d.HY();
    }
    if (paramInt <= this.bufferSize - this.cbm)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.cbm, arrayOfByte, 0, paramInt);
      this.cbm += paramInt;
      return arrayOfByte;
    }
    throw d.HY();
  }
  
  private void zo()
  {
    this.bufferSize += this.bNt;
    int i = this.bufferSize;
    if (i > this.bNx)
    {
      this.bNt = (i - this.bNx);
      this.bufferSize -= this.bNt;
      return;
    }
    this.bNt = 0;
  }
  
  private byte zq()
  {
    if (this.cbm == this.bufferSize) {
      throw d.HY();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.cbm;
    this.cbm = (i + 1);
    return arrayOfByte[i];
  }
  
  public final void a(e parame)
  {
    int i = zi();
    if (this.bNo >= this.bNp) {
      throw d.Ie();
    }
    i = fH(i);
    this.bNo += 1;
    parame.a(this);
    fF(0);
    this.bNo -= 1;
    fI(i);
  }
  
  public final void fF(int paramInt)
  {
    if (this.bNv != paramInt) {
      throw d.Ic();
    }
  }
  
  public final boolean fG(int paramInt)
  {
    switch (g.gX(paramInt))
    {
    default: 
      throw d.Id();
    case 0: 
      zi();
      return true;
    case 1: 
      zq();
      zq();
      zq();
      zq();
      zq();
      zq();
      zq();
      zq();
      return true;
    case 2: 
      fJ(zi());
      return true;
    case 3: 
      int i;
      do
      {
        i = yT();
      } while ((i != 0) && (fG(i)));
      fF(g.bA(g.gY(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    zq();
    zq();
    zq();
    zq();
    return true;
  }
  
  public final int fH(int paramInt)
  {
    if (paramInt < 0) {
      throw d.HZ();
    }
    paramInt = this.cbm + paramInt;
    int i = this.bNx;
    if (paramInt > i) {
      throw d.HY();
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
  
  public final void gZ(int paramInt)
  {
    if (paramInt > this.cbm - this.cbl) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.cbm - this.cbl));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position ".concat(String.valueOf(paramInt)));
    }
    this.cbm = (this.cbl + paramInt);
  }
  
  public final int getPosition()
  {
    return this.cbm - this.cbl;
  }
  
  public final byte[] readBytes()
  {
    int i = zi();
    if ((i <= this.bufferSize - this.cbm) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.cbm, arrayOfByte, 0, i);
      this.cbm = (i + this.cbm);
      return arrayOfByte;
    }
    return ha(i);
  }
  
  public final String readString()
  {
    int i = zi();
    if ((i <= this.bufferSize - this.cbm) && (i > 0))
    {
      String str = new String(this.buffer, this.cbm, i, "UTF-8");
      this.cbm = (i + this.cbm);
      return str;
    }
    return new String(ha(i), "UTF-8");
  }
  
  public final int yT()
  {
    if (this.cbm == this.bufferSize) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.bNv = 0;
      return 0;
    }
    this.bNv = zi();
    if (this.bNv == 0) {
      throw d.Ib();
    }
    return this.bNv;
  }
  
  public final int zi()
  {
    int i = zq();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = zq();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = zq();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = zq();
      if (k >= 0) {
        return i | k << 21;
      }
      j = zq();
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
      if (zq() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw d.Ia();
  }
  
  public final int zk()
  {
    if (this.bNx == 2147483647) {
      return -1;
    }
    int i = this.cbm;
    return this.bNx - i;
  }
  
  public final long zl()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = zq();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw d.Ia();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.a.a
 * JD-Core Version:    0.7.0.1
 */