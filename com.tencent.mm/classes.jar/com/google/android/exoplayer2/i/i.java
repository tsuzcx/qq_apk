package com.google.android.exoplayer2.i;

public final class i
{
  public int aSA;
  public int aSB;
  private int aSC;
  public byte[] data;
  
  public i() {}
  
  public i(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public i(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.aSC = paramInt;
  }
  
  public final void dy(int paramInt)
  {
    int i = paramInt / 8;
    this.aSA += i;
    this.aSB = (paramInt - i * 8 + this.aSB);
    if (this.aSB > 7)
    {
      this.aSA += 1;
      this.aSB -= 8;
    }
    od();
  }
  
  public final int dz(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    this.aSB += paramInt;
    int i = 0;
    while (this.aSB > 8)
    {
      this.aSB -= 8;
      byte[] arrayOfByte = this.data;
      j = this.aSA;
      this.aSA = (j + 1);
      i |= (arrayOfByte[j] & 0xFF) << this.aSB;
    }
    int j = this.data[this.aSA];
    int k = this.aSB;
    if (this.aSB == 8)
    {
      this.aSB = 0;
      this.aSA += 1;
    }
    od();
    return (i | (j & 0xFF) >> 8 - k) & -1 >>> 32 - paramInt;
  }
  
  public final void m(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.aSA = 0;
    this.aSB = 0;
    this.aSC = paramInt;
  }
  
  public final void n(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.aSB == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.aC(bool);
      System.arraycopy(this.data, this.aSA, paramArrayOfByte, 0, paramInt);
      this.aSA += paramInt;
      od();
      return;
    }
  }
  
  public final int nZ()
  {
    return (this.aSC - this.aSA) * 8 - this.aSB;
  }
  
  public final int oa()
  {
    if (this.aSB == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.aC(bool);
      return this.aSA;
    }
  }
  
  public final boolean ob()
  {
    if ((this.data[this.aSA] & 128 >> this.aSB) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      int i = this.aSB + 1;
      this.aSB = i;
      if (i == 8)
      {
        this.aSB = 0;
        this.aSA += 1;
      }
      od();
      return bool;
    }
  }
  
  public final void oc()
  {
    if (this.aSB == 0) {
      return;
    }
    this.aSB = 0;
    this.aSA += 1;
    od();
  }
  
  public final void od()
  {
    if ((this.aSA >= 0) && ((this.aSA < this.aSC) || ((this.aSA == this.aSC) && (this.aSB == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.aC(bool);
      return;
    }
  }
  
  public final void setPosition(int paramInt)
  {
    this.aSA = (paramInt / 8);
    this.aSB = (paramInt - this.aSA * 8);
    od();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.i.i
 * JD-Core Version:    0.7.0.1
 */