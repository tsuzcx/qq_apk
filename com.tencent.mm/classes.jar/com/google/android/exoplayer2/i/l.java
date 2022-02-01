package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  private int aZj;
  public int aZk;
  public int aZl;
  public byte[] data;
  
  public l() {}
  
  public l(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.i(93155);
    AppMethodBeat.o(93155);
  }
  
  public l(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.aZj = paramInt;
  }
  
  private void ve()
  {
    AppMethodBeat.i(93158);
    int i = this.aZl + 1;
    this.aZl = i;
    if (i == 8)
    {
      this.aZl = 0;
      this.aZk += 1;
    }
    sE();
    AppMethodBeat.o(93158);
  }
  
  public final int eA(int paramInt)
  {
    AppMethodBeat.i(93161);
    if (paramInt == 0)
    {
      AppMethodBeat.o(93161);
      return 0;
    }
    this.aZl += paramInt;
    int i = 0;
    while (this.aZl > 8)
    {
      this.aZl -= 8;
      byte[] arrayOfByte = this.data;
      j = this.aZk;
      this.aZk = (j + 1);
      i |= (arrayOfByte[j] & 0xFF) << this.aZl;
    }
    int j = this.data[this.aZk];
    int k = this.aZl;
    if (this.aZl == 8)
    {
      this.aZl = 0;
      this.aZk += 1;
    }
    sE();
    AppMethodBeat.o(93161);
    return (i | (j & 0xFF) >> 8 - k) & -1 >>> 32 - paramInt;
  }
  
  public final void eB(int paramInt)
  {
    AppMethodBeat.i(93159);
    int i = paramInt / 8;
    this.aZk += i;
    this.aZl = (paramInt - i * 8 + this.aZl);
    if (this.aZl > 7)
    {
      this.aZk += 1;
      this.aZl -= 8;
    }
    sE();
    AppMethodBeat.o(93159);
  }
  
  public final void n(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.aZk = 0;
    this.aZl = 0;
    this.aZj = paramInt;
  }
  
  public final void p(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(93163);
    if (this.aZl == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      System.arraycopy(this.data, this.aZk, paramArrayOfByte, 0, paramInt);
      this.aZk += paramInt;
      sE();
      AppMethodBeat.o(93163);
      return;
    }
  }
  
  public final boolean sD()
  {
    AppMethodBeat.i(93160);
    if ((this.data[this.aZk] & 128 >> this.aZl) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ve();
      AppMethodBeat.o(93160);
      return bool;
    }
  }
  
  public final void sE()
  {
    AppMethodBeat.i(93164);
    if ((this.aZk >= 0) && ((this.aZk < this.aZj) || ((this.aZk == this.aZj) && (this.aZl == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(93164);
      return;
    }
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(93157);
    this.aZk = (paramInt / 8);
    this.aZl = (paramInt - this.aZk * 8);
    sE();
    AppMethodBeat.o(93157);
  }
  
  public final int vc()
  {
    return (this.aZj - this.aZk) * 8 - this.aZl;
  }
  
  public final int vd()
  {
    AppMethodBeat.i(93156);
    if (this.aZl == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      int i = this.aZk;
      AppMethodBeat.o(93156);
      return i;
    }
  }
  
  public final void vf()
  {
    AppMethodBeat.i(93162);
    if (this.aZl == 0)
    {
      AppMethodBeat.o(93162);
      return;
    }
    this.aZl = 0;
    this.aZk += 1;
    sE();
    AppMethodBeat.o(93162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.i.l
 * JD-Core Version:    0.7.0.1
 */