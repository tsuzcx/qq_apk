package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  private int beF;
  public int beG;
  public int beH;
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
    this.beF = paramInt;
  }
  
  private void vH()
  {
    AppMethodBeat.i(93158);
    int i = this.beH + 1;
    this.beH = i;
    if (i == 8)
    {
      this.beH = 0;
      this.beG += 1;
    }
    sW();
    AppMethodBeat.o(93158);
  }
  
  public final int eo(int paramInt)
  {
    AppMethodBeat.i(93161);
    if (paramInt == 0)
    {
      AppMethodBeat.o(93161);
      return 0;
    }
    this.beH += paramInt;
    int i = 0;
    while (this.beH > 8)
    {
      this.beH -= 8;
      byte[] arrayOfByte = this.data;
      j = this.beG;
      this.beG = (j + 1);
      i |= (arrayOfByte[j] & 0xFF) << this.beH;
    }
    int j = this.data[this.beG];
    int k = this.beH;
    if (this.beH == 8)
    {
      this.beH = 0;
      this.beG += 1;
    }
    sW();
    AppMethodBeat.o(93161);
    return (i | (j & 0xFF) >> 8 - k) & -1 >>> 32 - paramInt;
  }
  
  public final void ep(int paramInt)
  {
    AppMethodBeat.i(93159);
    int i = paramInt / 8;
    this.beG += i;
    this.beH = (paramInt - i * 8 + this.beH);
    if (this.beH > 7)
    {
      this.beG += 1;
      this.beH -= 8;
    }
    sW();
    AppMethodBeat.o(93159);
  }
  
  public final void q(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.beG = 0;
    this.beH = 0;
    this.beF = paramInt;
  }
  
  public final void r(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(93163);
    if (this.beH == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      System.arraycopy(this.data, this.beG, paramArrayOfByte, 0, paramInt);
      this.beG += paramInt;
      sW();
      AppMethodBeat.o(93163);
      return;
    }
  }
  
  public final boolean sV()
  {
    AppMethodBeat.i(93160);
    if ((this.data[this.beG] & 128 >> this.beH) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      vH();
      AppMethodBeat.o(93160);
      return bool;
    }
  }
  
  public final void sW()
  {
    AppMethodBeat.i(93164);
    if ((this.beG >= 0) && ((this.beG < this.beF) || ((this.beG == this.beF) && (this.beH == 0)))) {}
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
    this.beG = (paramInt / 8);
    this.beH = (paramInt - this.beG * 8);
    sW();
    AppMethodBeat.o(93157);
  }
  
  public final int vF()
  {
    return (this.beF - this.beG) * 8 - this.beH;
  }
  
  public final int vG()
  {
    AppMethodBeat.i(93156);
    if (this.beH == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      int i = this.beG;
      AppMethodBeat.o(93156);
      return i;
    }
  }
  
  public final void vI()
  {
    AppMethodBeat.i(93162);
    if (this.beH == 0)
    {
      AppMethodBeat.o(93162);
      return;
    }
    this.beH = 0;
    this.beG += 1;
    sW();
    AppMethodBeat.o(93162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.l
 * JD-Core Version:    0.7.0.1
 */