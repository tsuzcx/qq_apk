package com.google.a.a;

public final class a
{
  private int bgP;
  private int bgQ;
  private int bgR;
  private int bgS;
  private int bgT = 2147483647;
  private int bgU;
  private int bgV = 64;
  private int bgW = 67108864;
  private final byte[] buffer;
  private int bufferSize;
  
  a(byte[] paramArrayOfByte, int paramInt)
  {
    this.buffer = paramArrayOfByte;
    this.bgP = 0;
    this.bufferSize = (paramInt + 0);
    this.bgR = 0;
  }
  
  private byte[] eS(int paramInt)
  {
    if (paramInt < 0) {
      throw d.sr();
    }
    if (this.bgR + paramInt > this.bgT)
    {
      eT(this.bgT - this.bgR);
      throw d.sq();
    }
    if (paramInt <= this.bufferSize - this.bgR)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.bgR, arrayOfByte, 0, paramInt);
      this.bgR += paramInt;
      return arrayOfByte;
    }
    throw d.sq();
  }
  
  private void eT(int paramInt)
  {
    if (paramInt < 0) {
      throw d.sr();
    }
    if (this.bgR + paramInt > this.bgT)
    {
      eT(this.bgT - this.bgR);
      throw d.sq();
    }
    if (paramInt <= this.bufferSize - this.bgR)
    {
      this.bgR += paramInt;
      return;
    }
    throw d.sq();
  }
  
  private void sn()
  {
    this.bufferSize += this.bgQ;
    int i = this.bufferSize;
    if (i > this.bgT)
    {
      this.bgQ = (i - this.bgT);
      this.bufferSize -= this.bgQ;
      return;
    }
    this.bgQ = 0;
  }
  
  private byte sp()
  {
    if (this.bgR == this.bufferSize) {
      throw d.sq();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bgR;
    this.bgR = (i + 1);
    return arrayOfByte[i];
  }
  
  public final void a(e parame)
  {
    int i = sl();
    if (this.bgU >= this.bgV) {
      throw d.sw();
    }
    i = eP(i);
    this.bgU += 1;
    parame.a(this);
    eN(0);
    this.bgU -= 1;
    eQ(i);
  }
  
  public final void eN(int paramInt)
  {
    if (this.bgS != paramInt) {
      throw d.su();
    }
  }
  
  public final boolean eO(int paramInt)
  {
    switch (g.eZ(paramInt))
    {
    default: 
      throw d.sv();
    case 0: 
      sl();
      return true;
    case 1: 
      sp();
      sp();
      sp();
      sp();
      sp();
      sp();
      sp();
      sp();
      return true;
    case 2: 
      eT(sl());
      return true;
    case 3: 
      int i;
      do
      {
        i = sk();
      } while ((i != 0) && (eO(i)));
      eN(g.bo(g.fa(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    sp();
    sp();
    sp();
    sp();
    return true;
  }
  
  public final int eP(int paramInt)
  {
    if (paramInt < 0) {
      throw d.sr();
    }
    paramInt = this.bgR + paramInt;
    int i = this.bgT;
    if (paramInt > i) {
      throw d.sq();
    }
    this.bgT = paramInt;
    sn();
    return i;
  }
  
  public final void eQ(int paramInt)
  {
    this.bgT = paramInt;
    sn();
  }
  
  public final void eR(int paramInt)
  {
    if (paramInt > this.bgR - this.bgP) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.bgR - this.bgP));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position ".concat(String.valueOf(paramInt)));
    }
    this.bgR = (this.bgP + paramInt);
  }
  
  public final int getPosition()
  {
    return this.bgR - this.bgP;
  }
  
  public final byte[] readBytes()
  {
    int i = sl();
    if ((i <= this.bufferSize - this.bgR) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.bgR, arrayOfByte, 0, i);
      this.bgR = (i + this.bgR);
      return arrayOfByte;
    }
    return eS(i);
  }
  
  public final String readString()
  {
    int i = sl();
    if ((i <= this.bufferSize - this.bgR) && (i > 0))
    {
      String str = new String(this.buffer, this.bgR, i, "UTF-8");
      this.bgR = (i + this.bgR);
      return str;
    }
    return new String(eS(i), "UTF-8");
  }
  
  public final int sk()
  {
    if (this.bgR == this.bufferSize) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.bgS = 0;
      return 0;
    }
    this.bgS = sl();
    if (this.bgS == 0) {
      throw d.st();
    }
    return this.bgS;
  }
  
  public final int sl()
  {
    int i = sp();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = sp();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = sp();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = sp();
      if (k >= 0) {
        return i | k << 21;
      }
      j = sp();
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
      if (sp() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw d.ss();
  }
  
  public final long sm()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = sp();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw d.ss();
  }
  
  public final int so()
  {
    if (this.bgT == 2147483647) {
      return -1;
    }
    int i = this.bgR;
    return this.bgT - i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.a.a
 * JD-Core Version:    0.7.0.1
 */