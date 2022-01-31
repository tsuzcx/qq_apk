package com.google.android.exoplayer2.i;

public final class k
{
  private int aSA;
  private int aSB;
  private int aSC;
  private byte[] data;
  
  public k(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    k(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private boolean dD(int paramInt)
  {
    return (2 <= paramInt) && (paramInt < this.aSC) && (this.data[paramInt] == 3) && (this.data[(paramInt - 2)] == 0) && (this.data[(paramInt - 1)] == 0);
  }
  
  private void od()
  {
    if ((this.aSA >= 0) && ((this.aSA < this.aSC) || ((this.aSA == this.aSC) && (this.aSB == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.aC(bool);
      return;
    }
  }
  
  public final boolean dC(int paramInt)
  {
    int m = this.aSA;
    int j = paramInt / 8;
    int i = this.aSA + j;
    int k = this.aSB + paramInt - j * 8;
    paramInt = i;
    j = k;
    if (k > 7)
    {
      paramInt = i + 1;
      j = k - 8;
    }
    i = m + 1;
    while ((i <= paramInt) && (paramInt < this.aSC))
    {
      k = paramInt;
      m = i;
      if (dD(i))
      {
        k = paramInt + 1;
        m = i + 2;
      }
      i = m + 1;
      paramInt = k;
    }
    return (paramInt < this.aSC) || ((paramInt == this.aSC) && (j == 0));
  }
  
  public final void dy(int paramInt)
  {
    int i = this.aSA;
    int j = paramInt / 8;
    this.aSA += j;
    this.aSB = (paramInt - j * 8 + this.aSB);
    if (this.aSB > 7)
    {
      this.aSA += 1;
      this.aSB -= 8;
    }
    for (paramInt = i + 1; paramInt <= this.aSA; paramInt = i + 1)
    {
      i = paramInt;
      if (dD(paramInt))
      {
        this.aSA += 1;
        i = paramInt + 2;
      }
    }
    od();
  }
  
  public final int dz(int paramInt)
  {
    int j = 2;
    this.aSB += paramInt;
    int i = 0;
    if (this.aSB > 8)
    {
      this.aSB -= 8;
      k = i | (this.data[this.aSA] & 0xFF) << this.aSB;
      m = this.aSA;
      if (dD(this.aSA + 1)) {}
      for (i = 2;; i = 1)
      {
        this.aSA = (i + m);
        i = k;
        break;
      }
    }
    int k = this.data[this.aSA];
    int m = this.aSB;
    int n;
    if (this.aSB == 8)
    {
      this.aSB = 0;
      n = this.aSA;
      if (!dD(this.aSA + 1)) {
        break label180;
      }
    }
    for (;;)
    {
      this.aSA = (n + j);
      od();
      return (i | (k & 0xFF) >> 8 - m) & -1 >>> 32 - paramInt;
      label180:
      j = 1;
    }
  }
  
  public final void k(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.data = paramArrayOfByte;
    this.aSA = paramInt1;
    this.aSC = paramInt2;
    this.aSB = 0;
    od();
  }
  
  public final boolean ob()
  {
    if ((this.data[this.aSA] & 128 >> this.aSB) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ok();
      return bool;
    }
  }
  
  public final void ok()
  {
    int i = this.aSB + 1;
    this.aSB = i;
    int j;
    if (i == 8)
    {
      this.aSB = 0;
      j = this.aSA;
      if (!dD(this.aSA + 1)) {
        break label55;
      }
    }
    label55:
    for (i = 2;; i = 1)
    {
      this.aSA = (i + j);
      od();
      return;
    }
  }
  
  public final boolean ol()
  {
    int k = this.aSA;
    int m = this.aSB;
    int i = 0;
    while ((this.aSA < this.aSC) && (!ob())) {
      i += 1;
    }
    if (this.aSA == this.aSC) {}
    for (int j = 1;; j = 0)
    {
      this.aSA = k;
      this.aSB = m;
      if ((j != 0) || (!dC(i * 2 + 1))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public final int om()
  {
    int j = on();
    if (j % 2 == 0) {}
    for (int i = -1;; i = 1) {
      return i * ((j + 1) / 2);
    }
  }
  
  public final int on()
  {
    int j = 0;
    int i = 0;
    while (!ob()) {
      i += 1;
    }
    if (i > 0) {
      j = dz(i);
    }
    return (1 << i) - 1 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.i.k
 * JD-Core Version:    0.7.0.1
 */