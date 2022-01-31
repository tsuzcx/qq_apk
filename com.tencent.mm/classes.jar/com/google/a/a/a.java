package com.google.a.a;

public final class a
{
  private int aUA;
  private int aUB;
  private int aUC;
  private int aUD = 2147483647;
  private int aUE;
  private int aUF = 64;
  private int aUG = 67108864;
  private int aUz;
  private final byte[] buffer;
  private int bufferSize;
  
  a(byte[] paramArrayOfByte, int paramInt)
  {
    this.buffer = paramArrayOfByte;
    this.aUz = 0;
    this.bufferSize = (paramInt + 0);
    this.aUB = 0;
  }
  
  private byte[] dM(int paramInt)
  {
    if (paramInt < 0) {
      throw d.oJ();
    }
    if (this.aUB + paramInt > this.aUD)
    {
      dN(this.aUD - this.aUB);
      throw d.oI();
    }
    if (paramInt <= this.bufferSize - this.aUB)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.aUB, arrayOfByte, 0, paramInt);
      this.aUB += paramInt;
      return arrayOfByte;
    }
    throw d.oI();
  }
  
  private void dN(int paramInt)
  {
    if (paramInt < 0) {
      throw d.oJ();
    }
    if (this.aUB + paramInt > this.aUD)
    {
      dN(this.aUD - this.aUB);
      throw d.oI();
    }
    if (paramInt <= this.bufferSize - this.aUB)
    {
      this.aUB += paramInt;
      return;
    }
    throw d.oI();
  }
  
  private void oF()
  {
    this.bufferSize += this.aUA;
    int i = this.bufferSize;
    if (i > this.aUD)
    {
      this.aUA = (i - this.aUD);
      this.bufferSize -= this.aUA;
      return;
    }
    this.aUA = 0;
  }
  
  private byte oH()
  {
    if (this.aUB == this.bufferSize) {
      throw d.oI();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.aUB;
    this.aUB = (i + 1);
    return arrayOfByte[i];
  }
  
  public final void a(e parame)
  {
    int i = oD();
    if (this.aUE >= this.aUF) {
      throw d.oO();
    }
    i = dJ(i);
    this.aUE += 1;
    parame.a(this);
    dH(0);
    this.aUE -= 1;
    dK(i);
  }
  
  public final void dH(int paramInt)
  {
    if (this.aUC != paramInt) {
      throw d.oM();
    }
  }
  
  public final boolean dI(int paramInt)
  {
    switch (g.dT(paramInt))
    {
    default: 
      throw d.oN();
    case 0: 
      oD();
      return true;
    case 1: 
      oH();
      oH();
      oH();
      oH();
      oH();
      oH();
      oH();
      oH();
      return true;
    case 2: 
      dN(oD());
      return true;
    case 3: 
      int i;
      do
      {
        i = oC();
      } while ((i != 0) && (dI(i)));
      dH(g.aQ(g.dU(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    oH();
    oH();
    oH();
    oH();
    return true;
  }
  
  public final int dJ(int paramInt)
  {
    if (paramInt < 0) {
      throw d.oJ();
    }
    paramInt = this.aUB + paramInt;
    int i = this.aUD;
    if (paramInt > i) {
      throw d.oI();
    }
    this.aUD = paramInt;
    oF();
    return i;
  }
  
  public final void dK(int paramInt)
  {
    this.aUD = paramInt;
    oF();
  }
  
  public final void dL(int paramInt)
  {
    if (paramInt > this.aUB - this.aUz) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.aUB - this.aUz));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position " + paramInt);
    }
    this.aUB = (this.aUz + paramInt);
  }
  
  public final int getPosition()
  {
    return this.aUB - this.aUz;
  }
  
  public final int oC()
  {
    if (this.aUB == this.bufferSize) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.aUC = 0;
      return 0;
    }
    this.aUC = oD();
    if (this.aUC == 0) {
      throw d.oL();
    }
    return this.aUC;
  }
  
  public final int oD()
  {
    int i = oH();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = oH();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = oH();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = oH();
      if (k >= 0) {
        return i | k << 21;
      }
      j = oH();
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
      if (oH() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw d.oK();
  }
  
  public final long oE()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = oH();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw d.oK();
  }
  
  public final int oG()
  {
    if (this.aUD == 2147483647) {
      return -1;
    }
    int i = this.aUB;
    return this.aUD - i;
  }
  
  public final byte[] readBytes()
  {
    int i = oD();
    if ((i <= this.bufferSize - this.aUB) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.aUB, arrayOfByte, 0, i);
      this.aUB = (i + this.aUB);
      return arrayOfByte;
    }
    return dM(i);
  }
  
  public final String readString()
  {
    int i = oD();
    if ((i <= this.bufferSize - this.aUB) && (i > 0))
    {
      String str = new String(this.buffer, this.aUB, i, "UTF-8");
      this.aUB = (i + this.aUB);
      return str;
    }
    return new String(dM(i), "UTF-8");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.a.a
 * JD-Core Version:    0.7.0.1
 */