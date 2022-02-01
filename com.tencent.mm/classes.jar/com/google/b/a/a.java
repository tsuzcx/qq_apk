package com.google.b.a;

public final class a
{
  private int bPn;
  private int bPo = 64;
  private int bPp = 67108864;
  private int bPs;
  private int bPu;
  private int bPw = 2147483647;
  private final byte[] buffer;
  private int bufferSize;
  private int ccO;
  private int ccP;
  
  a(byte[] paramArrayOfByte, int paramInt)
  {
    this.buffer = paramArrayOfByte;
    this.ccO = 0;
    this.bufferSize = (paramInt + 0);
    this.ccP = 0;
  }
  
  private void AQ()
  {
    this.bufferSize += this.bPs;
    int i = this.bufferSize;
    if (i > this.bPw)
    {
      this.bPs = (i - this.bPw);
      this.bufferSize -= this.bPs;
      return;
    }
    this.bPs = 0;
  }
  
  private byte AS()
  {
    if (this.ccP == this.bufferSize) {
      throw d.Jy();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.ccP;
    this.ccP = (i + 1);
    return arrayOfByte[i];
  }
  
  private void gC(int paramInt)
  {
    if (paramInt < 0) {
      throw d.Jz();
    }
    if (this.ccP + paramInt > this.bPw)
    {
      gC(this.bPw - this.ccP);
      throw d.Jy();
    }
    if (paramInt <= this.bufferSize - this.ccP)
    {
      this.ccP += paramInt;
      return;
    }
    throw d.Jy();
  }
  
  private byte[] hR(int paramInt)
  {
    if (paramInt < 0) {
      throw d.Jz();
    }
    if (this.ccP + paramInt > this.bPw)
    {
      gC(this.bPw - this.ccP);
      throw d.Jy();
    }
    if (paramInt <= this.bufferSize - this.ccP)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.ccP, arrayOfByte, 0, paramInt);
      this.ccP += paramInt;
      return arrayOfByte;
    }
    throw d.Jy();
  }
  
  public final int AK()
  {
    int i = AS();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = AS();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = AS();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = AS();
      if (k >= 0) {
        return i | k << 21;
      }
      j = AS();
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
      if (AS() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw d.JA();
  }
  
  public final int AM()
  {
    if (this.bPw == 2147483647) {
      return -1;
    }
    int i = this.ccP;
    return this.bPw - i;
  }
  
  public final long AN()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = AS();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw d.JA();
  }
  
  public final int Av()
  {
    if (this.ccP == this.bufferSize) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.bPu = 0;
      return 0;
    }
    this.bPu = AK();
    if (this.bPu == 0) {
      throw d.JB();
    }
    return this.bPu;
  }
  
  public final void a(e parame)
  {
    int i = AK();
    if (this.bPn >= this.bPo) {
      throw d.JE();
    }
    i = gA(i);
    this.bPn += 1;
    parame.a(this);
    gy(0);
    this.bPn -= 1;
    gB(i);
  }
  
  public final int gA(int paramInt)
  {
    if (paramInt < 0) {
      throw d.Jz();
    }
    paramInt = this.ccP + paramInt;
    int i = this.bPw;
    if (paramInt > i) {
      throw d.Jy();
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
  
  public final int getPosition()
  {
    return this.ccP - this.ccO;
  }
  
  public final void gy(int paramInt)
  {
    if (this.bPu != paramInt) {
      throw d.JC();
    }
  }
  
  public final boolean gz(int paramInt)
  {
    switch (g.hO(paramInt))
    {
    default: 
      throw d.JD();
    case 0: 
      AK();
      return true;
    case 1: 
      AS();
      AS();
      AS();
      AS();
      AS();
      AS();
      AS();
      AS();
      return true;
    case 2: 
      gC(AK());
      return true;
    case 3: 
      int i;
      do
      {
        i = Av();
      } while ((i != 0) && (gz(i)));
      gy(g.bT(g.hP(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    AS();
    AS();
    AS();
    AS();
    return true;
  }
  
  public final void hQ(int paramInt)
  {
    if (paramInt > this.ccP - this.ccO) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.ccP - this.ccO));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position ".concat(String.valueOf(paramInt)));
    }
    this.ccP = (this.ccO + paramInt);
  }
  
  public final byte[] readBytes()
  {
    int i = AK();
    if ((i <= this.bufferSize - this.ccP) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.ccP, arrayOfByte, 0, i);
      this.ccP = (i + this.ccP);
      return arrayOfByte;
    }
    return hR(i);
  }
  
  public final String readString()
  {
    int i = AK();
    if ((i <= this.bufferSize - this.ccP) && (i > 0))
    {
      String str = new String(this.buffer, this.ccP, i, "UTF-8");
      this.ccP = (i + this.ccP);
      return str;
    }
    return new String(hR(i), "UTF-8");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.a.a
 * JD-Core Version:    0.7.0.1
 */