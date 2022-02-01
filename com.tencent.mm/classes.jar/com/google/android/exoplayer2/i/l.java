package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  private int bpH;
  public int bpI;
  public int bpJ;
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
    this.bpH = paramInt;
  }
  
  private void xb()
  {
    AppMethodBeat.i(93158);
    int i = this.bpJ + 1;
    this.bpJ = i;
    if (i == 8)
    {
      this.bpJ = 0;
      this.bpI += 1;
    }
    uJ();
    AppMethodBeat.o(93158);
  }
  
  public final int em(int paramInt)
  {
    AppMethodBeat.i(93161);
    if (paramInt == 0)
    {
      AppMethodBeat.o(93161);
      return 0;
    }
    this.bpJ += paramInt;
    int i = 0;
    while (this.bpJ > 8)
    {
      this.bpJ -= 8;
      byte[] arrayOfByte = this.data;
      j = this.bpI;
      this.bpI = (j + 1);
      i |= (arrayOfByte[j] & 0xFF) << this.bpJ;
    }
    int j = this.data[this.bpI];
    int k = this.bpJ;
    if (this.bpJ == 8)
    {
      this.bpJ = 0;
      this.bpI += 1;
    }
    uJ();
    AppMethodBeat.o(93161);
    return (i | (j & 0xFF) >> 8 - k) & -1 >>> 32 - paramInt;
  }
  
  public final void en(int paramInt)
  {
    AppMethodBeat.i(93159);
    int i = paramInt / 8;
    this.bpI += i;
    this.bpJ = (paramInt - i * 8 + this.bpJ);
    if (this.bpJ > 7)
    {
      this.bpI += 1;
      this.bpJ -= 8;
    }
    uJ();
    AppMethodBeat.o(93159);
  }
  
  public final void n(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.bpI = 0;
    this.bpJ = 0;
    this.bpH = paramInt;
  }
  
  public final void p(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(93163);
    if (this.bpJ == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      System.arraycopy(this.data, this.bpI, paramArrayOfByte, 0, paramInt);
      this.bpI += paramInt;
      uJ();
      AppMethodBeat.o(93163);
      return;
    }
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(93157);
    this.bpI = (paramInt / 8);
    this.bpJ = (paramInt - this.bpI * 8);
    uJ();
    AppMethodBeat.o(93157);
  }
  
  public final boolean uI()
  {
    AppMethodBeat.i(93160);
    if ((this.data[this.bpI] & 128 >> this.bpJ) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      xb();
      AppMethodBeat.o(93160);
      return bool;
    }
  }
  
  public final void uJ()
  {
    AppMethodBeat.i(93164);
    if ((this.bpI >= 0) && ((this.bpI < this.bpH) || ((this.bpI == this.bpH) && (this.bpJ == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(93164);
      return;
    }
  }
  
  public final int wZ()
  {
    return (this.bpH - this.bpI) * 8 - this.bpJ;
  }
  
  public final int xa()
  {
    AppMethodBeat.i(93156);
    if (this.bpJ == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      int i = this.bpI;
      AppMethodBeat.o(93156);
      return i;
    }
  }
  
  public final void xc()
  {
    AppMethodBeat.i(93162);
    if (this.bpJ == 0)
    {
      AppMethodBeat.o(93162);
      return;
    }
    this.bpJ = 0;
    this.bpI += 1;
    uJ();
    AppMethodBeat.o(93162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.i.l
 * JD-Core Version:    0.7.0.1
 */