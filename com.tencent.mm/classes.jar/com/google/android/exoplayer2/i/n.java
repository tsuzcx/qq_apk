package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  private int beF;
  private int beG;
  private int beH;
  private byte[] data;
  
  public n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93182);
    m(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(93182);
  }
  
  private boolean fo(int paramInt)
  {
    return (2 <= paramInt) && (paramInt < this.beF) && (this.data[paramInt] == 3) && (this.data[(paramInt - 2)] == 0) && (this.data[(paramInt - 1)] == 0);
  }
  
  private void sW()
  {
    AppMethodBeat.i(93192);
    if ((this.beG >= 0) && ((this.beG < this.beF) || ((this.beG == this.beF) && (this.beH == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(93192);
      return;
    }
  }
  
  public final int eo(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(93188);
    this.beH += paramInt;
    int i = 0;
    if (this.beH > 8)
    {
      this.beH -= 8;
      k = i | (this.data[this.beG] & 0xFF) << this.beH;
      m = this.beG;
      if (fo(this.beG + 1)) {}
      for (i = 2;; i = 1)
      {
        this.beG = (i + m);
        i = k;
        break;
      }
    }
    int k = this.data[this.beG];
    int m = this.beH;
    int n;
    if (this.beH == 8)
    {
      this.beH = 0;
      n = this.beG;
      if (!fo(this.beG + 1)) {
        break label190;
      }
    }
    for (;;)
    {
      this.beG = (n + j);
      sW();
      AppMethodBeat.o(93188);
      return (i | (k & 0xFF) >> 8 - m) & -1 >>> 32 - paramInt;
      label190:
      j = 1;
    }
  }
  
  public final void ep(int paramInt)
  {
    AppMethodBeat.i(93185);
    int i = this.beG;
    int j = paramInt / 8;
    this.beG += j;
    this.beH = (paramInt - j * 8 + this.beH);
    if (this.beH > 7)
    {
      this.beG += 1;
      this.beH -= 8;
    }
    for (paramInt = i + 1; paramInt <= this.beG; paramInt = i + 1)
    {
      i = paramInt;
      if (fo(paramInt))
      {
        this.beG += 1;
        i = paramInt + 2;
      }
    }
    sW();
    AppMethodBeat.o(93185);
  }
  
  public final boolean fn(int paramInt)
  {
    AppMethodBeat.i(93186);
    int m = this.beG;
    int j = paramInt / 8;
    int i = this.beG + j;
    int k = this.beH + paramInt - j * 8;
    paramInt = i;
    j = k;
    if (k > 7)
    {
      paramInt = i + 1;
      j = k - 8;
    }
    i = m + 1;
    while ((i <= paramInt) && (paramInt < this.beF))
    {
      k = paramInt;
      m = i;
      if (fo(i))
      {
        k = paramInt + 1;
        m = i + 2;
      }
      i = m + 1;
      paramInt = k;
    }
    if ((paramInt < this.beF) || ((paramInt == this.beF) && (j == 0)))
    {
      AppMethodBeat.o(93186);
      return true;
    }
    AppMethodBeat.o(93186);
    return false;
  }
  
  public final void m(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93183);
    this.data = paramArrayOfByte;
    this.beG = paramInt1;
    this.beF = paramInt2;
    this.beH = 0;
    sW();
    AppMethodBeat.o(93183);
  }
  
  public final boolean sV()
  {
    AppMethodBeat.i(93187);
    if ((this.data[this.beG] & 128 >> this.beH) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      vH();
      AppMethodBeat.o(93187);
      return bool;
    }
  }
  
  public final void vH()
  {
    AppMethodBeat.i(93184);
    int i = this.beH + 1;
    this.beH = i;
    int j;
    if (i == 8)
    {
      this.beH = 0;
      j = this.beG;
      if (!fo(this.beG + 1)) {
        break label65;
      }
    }
    label65:
    for (i = 2;; i = 1)
    {
      this.beG = (i + j);
      sW();
      AppMethodBeat.o(93184);
      return;
    }
  }
  
  public final boolean vU()
  {
    AppMethodBeat.i(93189);
    int k = this.beG;
    int m = this.beH;
    int i = 0;
    while ((this.beG < this.beF) && (!sV())) {
      i += 1;
    }
    if (this.beG == this.beF) {}
    for (int j = 1;; j = 0)
    {
      this.beG = k;
      this.beH = m;
      if ((j != 0) || (!fn(i * 2 + 1))) {
        break;
      }
      AppMethodBeat.o(93189);
      return true;
    }
    AppMethodBeat.o(93189);
    return false;
  }
  
  public final int vV()
  {
    AppMethodBeat.i(93190);
    int j = vW();
    if (j % 2 == 0) {}
    for (int i = -1;; i = 1)
    {
      j = (j + 1) / 2;
      AppMethodBeat.o(93190);
      return i * j;
    }
  }
  
  public final int vW()
  {
    int j = 0;
    AppMethodBeat.i(93191);
    int i = 0;
    while (!sV()) {
      i += 1;
    }
    if (i > 0) {
      j = eo(i);
    }
    AppMethodBeat.o(93191);
    return (1 << i) - 1 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.n
 * JD-Core Version:    0.7.0.1
 */