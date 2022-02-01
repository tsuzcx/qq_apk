package com.google.d.a;

public final class a
{
  private final byte[] buffer;
  private int bufferSize;
  private int dIR;
  private int dIS = 64;
  private int dIT = 67108864;
  private int dIX;
  private int dIZ;
  private int dJb = 2147483647;
  private int dXs;
  private int dXt;
  
  a(byte[] paramArrayOfByte, int paramInt)
  {
    this.buffer = paramArrayOfByte;
    this.dXs = 0;
    this.bufferSize = (paramInt + 0);
    this.dXt = 0;
  }
  
  private byte aaA()
  {
    if (this.dXt == this.bufferSize) {
      throw d.ajU();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.dXt;
    this.dXt = (i + 1);
    return arrayOfByte[i];
  }
  
  private void aaz()
  {
    this.bufferSize += this.dIX;
    int i = this.bufferSize;
    if (i > this.dJb)
    {
      this.dIX = (i - this.dJb);
      this.bufferSize -= this.dIX;
      return;
    }
    this.dIX = 0;
  }
  
  private void jR(int paramInt)
  {
    if (paramInt < 0) {
      throw d.ajV();
    }
    if (this.dXt + paramInt > this.dJb)
    {
      jR(this.dJb - this.dXt);
      throw d.ajU();
    }
    if (paramInt <= this.bufferSize - this.dXt)
    {
      this.dXt += paramInt;
      return;
    }
    throw d.ajU();
  }
  
  private byte[] lG(int paramInt)
  {
    if (paramInt < 0) {
      throw d.ajV();
    }
    if (this.dXt + paramInt > this.dJb)
    {
      jR(this.dJb - this.dXt);
      throw d.ajU();
    }
    if (paramInt <= this.bufferSize - this.dXt)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.dXt, arrayOfByte, 0, paramInt);
      this.dXt += paramInt;
      return arrayOfByte;
    }
    throw d.ajU();
  }
  
  public final void a(e parame)
  {
    int i = aar();
    if (this.dIR >= this.dIS) {
      throw d.aka();
    }
    i = jO(i);
    this.dIR += 1;
    parame.a(this);
    jM(0);
    this.dIR -= 1;
    jP(i);
  }
  
  public final int aac()
  {
    if (this.dXt == this.bufferSize) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.dIZ = 0;
      return 0;
    }
    this.dIZ = aar();
    if (this.dIZ == 0) {
      throw d.ajX();
    }
    return this.dIZ;
  }
  
  public final int aar()
  {
    int i = aaA();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = aaA();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = aaA();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = aaA();
      if (k >= 0) {
        return i | k << 21;
      }
      j = aaA();
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
      if (aaA() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw d.ajW();
  }
  
  public final int aat()
  {
    if (this.dJb == 2147483647) {
      return -1;
    }
    int i = this.dXt;
    return this.dJb - i;
  }
  
  public final long aaw()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = aaA();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw d.ajW();
  }
  
  public final int getPosition()
  {
    return this.dXt - this.dXs;
  }
  
  public final void jM(int paramInt)
  {
    if (this.dIZ != paramInt) {
      throw d.ajY();
    }
  }
  
  public final boolean jN(int paramInt)
  {
    switch (g.lD(paramInt))
    {
    default: 
      throw d.ajZ();
    case 0: 
      aar();
      return true;
    case 1: 
      aaA();
      aaA();
      aaA();
      aaA();
      aaA();
      aaA();
      aaA();
      aaA();
      return true;
    case 2: 
      jR(aar());
      return true;
    case 3: 
      int i;
      do
      {
        i = aac();
      } while ((i != 0) && (jN(i)));
      jM(g.cU(g.lE(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    aaA();
    aaA();
    aaA();
    aaA();
    return true;
  }
  
  public final int jO(int paramInt)
  {
    if (paramInt < 0) {
      throw d.ajV();
    }
    paramInt = this.dXt + paramInt;
    int i = this.dJb;
    if (paramInt > i) {
      throw d.ajU();
    }
    this.dJb = paramInt;
    aaz();
    return i;
  }
  
  public final void jP(int paramInt)
  {
    this.dJb = paramInt;
    aaz();
  }
  
  public final void lF(int paramInt)
  {
    if (paramInt > this.dXt - this.dXs) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.dXt - this.dXs));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position ".concat(String.valueOf(paramInt)));
    }
    this.dXt = (this.dXs + paramInt);
  }
  
  public final byte[] readBytes()
  {
    int i = aar();
    if ((i <= this.bufferSize - this.dXt) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.dXt, arrayOfByte, 0, i);
      this.dXt = (i + this.dXt);
      return arrayOfByte;
    }
    return lG(i);
  }
  
  public final String readString()
  {
    int i = aar();
    if ((i <= this.bufferSize - this.dXt) && (i > 0))
    {
      String str = new String(this.buffer, this.dXt, i, "UTF-8");
      this.dXt = (i + this.dXt);
      return str;
    }
    return new String(lG(i), "UTF-8");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.d.a.a
 * JD-Core Version:    0.7.0.1
 */