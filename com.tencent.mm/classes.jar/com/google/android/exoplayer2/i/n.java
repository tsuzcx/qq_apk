package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  private int bpH;
  private int bpI;
  private int bpJ;
  private byte[] data;
  
  public n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93182);
    l(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(93182);
  }
  
  private boolean fc(int paramInt)
  {
    return (2 <= paramInt) && (paramInt < this.bpH) && (this.data[paramInt] == 3) && (this.data[(paramInt - 2)] == 0) && (this.data[(paramInt - 1)] == 0);
  }
  
  private void uJ()
  {
    AppMethodBeat.i(93192);
    if ((this.bpI >= 0) && ((this.bpI < this.bpH) || ((this.bpI == this.bpH) && (this.bpJ == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(93192);
      return;
    }
  }
  
  public final int em(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(93188);
    this.bpJ += paramInt;
    int i = 0;
    if (this.bpJ > 8)
    {
      this.bpJ -= 8;
      k = i | (this.data[this.bpI] & 0xFF) << this.bpJ;
      m = this.bpI;
      if (fc(this.bpI + 1)) {}
      for (i = 2;; i = 1)
      {
        this.bpI = (i + m);
        i = k;
        break;
      }
    }
    int k = this.data[this.bpI];
    int m = this.bpJ;
    int n;
    if (this.bpJ == 8)
    {
      this.bpJ = 0;
      n = this.bpI;
      if (!fc(this.bpI + 1)) {
        break label190;
      }
    }
    for (;;)
    {
      this.bpI = (n + j);
      uJ();
      AppMethodBeat.o(93188);
      return (i | (k & 0xFF) >> 8 - m) & -1 >>> 32 - paramInt;
      label190:
      j = 1;
    }
  }
  
  public final void en(int paramInt)
  {
    AppMethodBeat.i(93185);
    int i = this.bpI;
    int j = paramInt / 8;
    this.bpI += j;
    this.bpJ = (paramInt - j * 8 + this.bpJ);
    if (this.bpJ > 7)
    {
      this.bpI += 1;
      this.bpJ -= 8;
    }
    for (paramInt = i + 1; paramInt <= this.bpI; paramInt = i + 1)
    {
      i = paramInt;
      if (fc(paramInt))
      {
        this.bpI += 1;
        i = paramInt + 2;
      }
    }
    uJ();
    AppMethodBeat.o(93185);
  }
  
  public final boolean fb(int paramInt)
  {
    AppMethodBeat.i(93186);
    int m = this.bpI;
    int j = paramInt / 8;
    int i = this.bpI + j;
    int k = this.bpJ + paramInt - j * 8;
    paramInt = i;
    j = k;
    if (k > 7)
    {
      paramInt = i + 1;
      j = k - 8;
    }
    i = m + 1;
    while ((i <= paramInt) && (paramInt < this.bpH))
    {
      k = paramInt;
      m = i;
      if (fc(i))
      {
        k = paramInt + 1;
        m = i + 2;
      }
      i = m + 1;
      paramInt = k;
    }
    if ((paramInt < this.bpH) || ((paramInt == this.bpH) && (j == 0)))
    {
      AppMethodBeat.o(93186);
      return true;
    }
    AppMethodBeat.o(93186);
    return false;
  }
  
  public final void l(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93183);
    this.data = paramArrayOfByte;
    this.bpI = paramInt1;
    this.bpH = paramInt2;
    this.bpJ = 0;
    uJ();
    AppMethodBeat.o(93183);
  }
  
  public final boolean uI()
  {
    AppMethodBeat.i(93187);
    if ((this.data[this.bpI] & 128 >> this.bpJ) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      xb();
      AppMethodBeat.o(93187);
      return bool;
    }
  }
  
  public final void xb()
  {
    AppMethodBeat.i(93184);
    int i = this.bpJ + 1;
    this.bpJ = i;
    int j;
    if (i == 8)
    {
      this.bpJ = 0;
      j = this.bpI;
      if (!fc(this.bpI + 1)) {
        break label65;
      }
    }
    label65:
    for (i = 2;; i = 1)
    {
      this.bpI = (i + j);
      uJ();
      AppMethodBeat.o(93184);
      return;
    }
  }
  
  public final boolean xo()
  {
    AppMethodBeat.i(93189);
    int k = this.bpI;
    int m = this.bpJ;
    int i = 0;
    while ((this.bpI < this.bpH) && (!uI())) {
      i += 1;
    }
    if (this.bpI == this.bpH) {}
    for (int j = 1;; j = 0)
    {
      this.bpI = k;
      this.bpJ = m;
      if ((j != 0) || (!fb(i * 2 + 1))) {
        break;
      }
      AppMethodBeat.o(93189);
      return true;
    }
    AppMethodBeat.o(93189);
    return false;
  }
  
  public final int xp()
  {
    AppMethodBeat.i(93190);
    int j = xq();
    if (j % 2 == 0) {}
    for (int i = -1;; i = 1)
    {
      j = (j + 1) / 2;
      AppMethodBeat.o(93190);
      return i * j;
    }
  }
  
  public final int xq()
  {
    int j = 0;
    AppMethodBeat.i(93191);
    int i = 0;
    while (!uI()) {
      i += 1;
    }
    if (i > 0) {
      j = em(i);
    }
    AppMethodBeat.o(93191);
    return (1 << i) - 1 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.i.n
 * JD-Core Version:    0.7.0.1
 */