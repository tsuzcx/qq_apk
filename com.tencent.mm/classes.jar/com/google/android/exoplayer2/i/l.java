package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  private int cTe;
  public int cTf;
  public int cTg;
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
    this.cTe = paramInt;
  }
  
  private void UD()
  {
    AppMethodBeat.i(93158);
    int i = this.cTg + 1;
    this.cTg = i;
    if (i == 8)
    {
      this.cTg = 0;
      this.cTf += 1;
    }
    Sh();
    AppMethodBeat.o(93158);
  }
  
  public final boolean Sg()
  {
    AppMethodBeat.i(93160);
    if ((this.data[this.cTf] & 128 >> this.cTg) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      UD();
      AppMethodBeat.o(93160);
      return bool;
    }
  }
  
  public final void Sh()
  {
    AppMethodBeat.i(93164);
    if ((this.cTf >= 0) && ((this.cTf < this.cTe) || ((this.cTf == this.cTe) && (this.cTg == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(93164);
      return;
    }
  }
  
  public final int UB()
  {
    return (this.cTe - this.cTf) * 8 - this.cTg;
  }
  
  public final int UC()
  {
    AppMethodBeat.i(93156);
    if (this.cTg == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      int i = this.cTf;
      AppMethodBeat.o(93156);
      return i;
    }
  }
  
  public final void UE()
  {
    AppMethodBeat.i(93162);
    if (this.cTg == 0)
    {
      AppMethodBeat.o(93162);
      return;
    }
    this.cTg = 0;
    this.cTf += 1;
    Sh();
    AppMethodBeat.o(93162);
  }
  
  public final int hQ(int paramInt)
  {
    AppMethodBeat.i(93161);
    if (paramInt == 0)
    {
      AppMethodBeat.o(93161);
      return 0;
    }
    this.cTg += paramInt;
    int i = 0;
    while (this.cTg > 8)
    {
      this.cTg -= 8;
      byte[] arrayOfByte = this.data;
      j = this.cTf;
      this.cTf = (j + 1);
      i |= (arrayOfByte[j] & 0xFF) << this.cTg;
    }
    int j = this.data[this.cTf];
    int k = this.cTg;
    if (this.cTg == 8)
    {
      this.cTg = 0;
      this.cTf += 1;
    }
    Sh();
    AppMethodBeat.o(93161);
    return (i | (j & 0xFF) >> 8 - k) & -1 >>> 32 - paramInt;
  }
  
  public final void hR(int paramInt)
  {
    AppMethodBeat.i(93159);
    int i = paramInt / 8;
    this.cTf += i;
    this.cTg = (paramInt - i * 8 + this.cTg);
    if (this.cTg > 7)
    {
      this.cTf += 1;
      this.cTg -= 8;
    }
    Sh();
    AppMethodBeat.o(93159);
  }
  
  public final void n(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.cTf = 0;
    this.cTg = 0;
    this.cTe = paramInt;
  }
  
  public final void p(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(93163);
    if (this.cTg == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      System.arraycopy(this.data, this.cTf, paramArrayOfByte, 0, paramInt);
      this.cTf += paramInt;
      Sh();
      AppMethodBeat.o(93163);
      return;
    }
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(93157);
    this.cTf = (paramInt / 8);
    this.cTg = (paramInt - this.cTf * 8);
    Sh();
    AppMethodBeat.o(93157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.i.l
 * JD-Core Version:    0.7.0.1
 */