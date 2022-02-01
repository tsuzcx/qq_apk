package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  private int bpM;
  public int bpN;
  public int bpO;
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
    this.bpM = paramInt;
  }
  
  private void wT()
  {
    AppMethodBeat.i(93158);
    int i = this.bpO + 1;
    this.bpO = i;
    if (i == 8)
    {
      this.bpO = 0;
      this.bpN += 1;
    }
    uE();
    AppMethodBeat.o(93158);
  }
  
  public final int es(int paramInt)
  {
    AppMethodBeat.i(93161);
    if (paramInt == 0)
    {
      AppMethodBeat.o(93161);
      return 0;
    }
    this.bpO += paramInt;
    int i = 0;
    while (this.bpO > 8)
    {
      this.bpO -= 8;
      byte[] arrayOfByte = this.data;
      j = this.bpN;
      this.bpN = (j + 1);
      i |= (arrayOfByte[j] & 0xFF) << this.bpO;
    }
    int j = this.data[this.bpN];
    int k = this.bpO;
    if (this.bpO == 8)
    {
      this.bpO = 0;
      this.bpN += 1;
    }
    uE();
    AppMethodBeat.o(93161);
    return (i | (j & 0xFF) >> 8 - k) & -1 >>> 32 - paramInt;
  }
  
  public final void et(int paramInt)
  {
    AppMethodBeat.i(93159);
    int i = paramInt / 8;
    this.bpN += i;
    this.bpO = (paramInt - i * 8 + this.bpO);
    if (this.bpO > 7)
    {
      this.bpN += 1;
      this.bpO -= 8;
    }
    uE();
    AppMethodBeat.o(93159);
  }
  
  public final void n(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.bpN = 0;
    this.bpO = 0;
    this.bpM = paramInt;
  }
  
  public final void p(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(93163);
    if (this.bpO == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      System.arraycopy(this.data, this.bpN, paramArrayOfByte, 0, paramInt);
      this.bpN += paramInt;
      uE();
      AppMethodBeat.o(93163);
      return;
    }
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(93157);
    this.bpN = (paramInt / 8);
    this.bpO = (paramInt - this.bpN * 8);
    uE();
    AppMethodBeat.o(93157);
  }
  
  public final boolean uD()
  {
    AppMethodBeat.i(93160);
    if ((this.data[this.bpN] & 128 >> this.bpO) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      wT();
      AppMethodBeat.o(93160);
      return bool;
    }
  }
  
  public final void uE()
  {
    AppMethodBeat.i(93164);
    if ((this.bpN >= 0) && ((this.bpN < this.bpM) || ((this.bpN == this.bpM) && (this.bpO == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(93164);
      return;
    }
  }
  
  public final int wR()
  {
    return (this.bpM - this.bpN) * 8 - this.bpO;
  }
  
  public final int wS()
  {
    AppMethodBeat.i(93156);
    if (this.bpO == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      int i = this.bpN;
      AppMethodBeat.o(93156);
      return i;
    }
  }
  
  public final void wU()
  {
    AppMethodBeat.i(93162);
    if (this.bpO == 0)
    {
      AppMethodBeat.o(93162);
      return;
    }
    this.bpO = 0;
    this.bpN += 1;
    uE();
    AppMethodBeat.o(93162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.l
 * JD-Core Version:    0.7.0.1
 */