package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  private int bfr;
  public int bft;
  public int bfu;
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
    this.bfr = paramInt;
  }
  
  private void vw()
  {
    AppMethodBeat.i(93158);
    int i = this.bfu + 1;
    this.bfu = i;
    if (i == 8)
    {
      this.bfu = 0;
      this.bft += 1;
    }
    tf();
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
    this.bfu += paramInt;
    int i = 0;
    while (this.bfu > 8)
    {
      this.bfu -= 8;
      byte[] arrayOfByte = this.data;
      j = this.bft;
      this.bft = (j + 1);
      i |= (arrayOfByte[j] & 0xFF) << this.bfu;
    }
    int j = this.data[this.bft];
    int k = this.bfu;
    if (this.bfu == 8)
    {
      this.bfu = 0;
      this.bft += 1;
    }
    tf();
    AppMethodBeat.o(93161);
    return (i | (j & 0xFF) >> 8 - k) & -1 >>> 32 - paramInt;
  }
  
  public final void ep(int paramInt)
  {
    AppMethodBeat.i(93159);
    int i = paramInt / 8;
    this.bft += i;
    this.bfu = (paramInt - i * 8 + this.bfu);
    if (this.bfu > 7)
    {
      this.bft += 1;
      this.bfu -= 8;
    }
    tf();
    AppMethodBeat.o(93159);
  }
  
  public final void n(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.bft = 0;
    this.bfu = 0;
    this.bfr = paramInt;
  }
  
  public final void p(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(93163);
    if (this.bfu == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      System.arraycopy(this.data, this.bft, paramArrayOfByte, 0, paramInt);
      this.bft += paramInt;
      tf();
      AppMethodBeat.o(93163);
      return;
    }
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(93157);
    this.bft = (paramInt / 8);
    this.bfu = (paramInt - this.bft * 8);
    tf();
    AppMethodBeat.o(93157);
  }
  
  public final boolean te()
  {
    AppMethodBeat.i(93160);
    if ((this.data[this.bft] & 128 >> this.bfu) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      vw();
      AppMethodBeat.o(93160);
      return bool;
    }
  }
  
  public final void tf()
  {
    AppMethodBeat.i(93164);
    if ((this.bft >= 0) && ((this.bft < this.bfr) || ((this.bft == this.bfr) && (this.bfu == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(93164);
      return;
    }
  }
  
  public final int vu()
  {
    return (this.bfr - this.bft) * 8 - this.bfu;
  }
  
  public final int vv()
  {
    AppMethodBeat.i(93156);
    if (this.bfu == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      int i = this.bft;
      AppMethodBeat.o(93156);
      return i;
    }
  }
  
  public final void vx()
  {
    AppMethodBeat.i(93162);
    if (this.bfu == 0)
    {
      AppMethodBeat.o(93162);
      return;
    }
    this.bfu = 0;
    this.bft += 1;
    tf();
    AppMethodBeat.o(93162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.l
 * JD-Core Version:    0.7.0.1
 */