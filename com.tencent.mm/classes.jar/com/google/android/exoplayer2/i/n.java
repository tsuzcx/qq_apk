package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  private int bfr;
  private int bft;
  private int bfu;
  private byte[] data;
  
  public n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93182);
    l(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(93182);
  }
  
  private boolean fa(int paramInt)
  {
    return (2 <= paramInt) && (paramInt < this.bfr) && (this.data[paramInt] == 3) && (this.data[(paramInt - 2)] == 0) && (this.data[(paramInt - 1)] == 0);
  }
  
  private void tf()
  {
    AppMethodBeat.i(93192);
    if ((this.bft >= 0) && ((this.bft < this.bfr) || ((this.bft == this.bfr) && (this.bfu == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(93192);
      return;
    }
  }
  
  public final boolean eZ(int paramInt)
  {
    AppMethodBeat.i(93186);
    int m = this.bft;
    int j = paramInt / 8;
    int i = this.bft + j;
    int k = this.bfu + paramInt - j * 8;
    paramInt = i;
    j = k;
    if (k > 7)
    {
      paramInt = i + 1;
      j = k - 8;
    }
    i = m + 1;
    while ((i <= paramInt) && (paramInt < this.bfr))
    {
      k = paramInt;
      m = i;
      if (fa(i))
      {
        k = paramInt + 1;
        m = i + 2;
      }
      i = m + 1;
      paramInt = k;
    }
    if ((paramInt < this.bfr) || ((paramInt == this.bfr) && (j == 0)))
    {
      AppMethodBeat.o(93186);
      return true;
    }
    AppMethodBeat.o(93186);
    return false;
  }
  
  public final int eo(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(93188);
    this.bfu += paramInt;
    int i = 0;
    if (this.bfu > 8)
    {
      this.bfu -= 8;
      k = i | (this.data[this.bft] & 0xFF) << this.bfu;
      m = this.bft;
      if (fa(this.bft + 1)) {}
      for (i = 2;; i = 1)
      {
        this.bft = (i + m);
        i = k;
        break;
      }
    }
    int k = this.data[this.bft];
    int m = this.bfu;
    int n;
    if (this.bfu == 8)
    {
      this.bfu = 0;
      n = this.bft;
      if (!fa(this.bft + 1)) {
        break label190;
      }
    }
    for (;;)
    {
      this.bft = (n + j);
      tf();
      AppMethodBeat.o(93188);
      return (i | (k & 0xFF) >> 8 - m) & -1 >>> 32 - paramInt;
      label190:
      j = 1;
    }
  }
  
  public final void ep(int paramInt)
  {
    AppMethodBeat.i(93185);
    int i = this.bft;
    int j = paramInt / 8;
    this.bft += j;
    this.bfu = (paramInt - j * 8 + this.bfu);
    if (this.bfu > 7)
    {
      this.bft += 1;
      this.bfu -= 8;
    }
    for (paramInt = i + 1; paramInt <= this.bft; paramInt = i + 1)
    {
      i = paramInt;
      if (fa(paramInt))
      {
        this.bft += 1;
        i = paramInt + 2;
      }
    }
    tf();
    AppMethodBeat.o(93185);
  }
  
  public final void l(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93183);
    this.data = paramArrayOfByte;
    this.bft = paramInt1;
    this.bfr = paramInt2;
    this.bfu = 0;
    tf();
    AppMethodBeat.o(93183);
  }
  
  public final boolean te()
  {
    AppMethodBeat.i(93187);
    if ((this.data[this.bft] & 128 >> this.bfu) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      vw();
      AppMethodBeat.o(93187);
      return bool;
    }
  }
  
  public final boolean vJ()
  {
    AppMethodBeat.i(93189);
    int k = this.bft;
    int m = this.bfu;
    int i = 0;
    while ((this.bft < this.bfr) && (!te())) {
      i += 1;
    }
    if (this.bft == this.bfr) {}
    for (int j = 1;; j = 0)
    {
      this.bft = k;
      this.bfu = m;
      if ((j != 0) || (!eZ(i * 2 + 1))) {
        break;
      }
      AppMethodBeat.o(93189);
      return true;
    }
    AppMethodBeat.o(93189);
    return false;
  }
  
  public final int vK()
  {
    AppMethodBeat.i(93190);
    int j = vL();
    if (j % 2 == 0) {}
    for (int i = -1;; i = 1)
    {
      j = (j + 1) / 2;
      AppMethodBeat.o(93190);
      return i * j;
    }
  }
  
  public final int vL()
  {
    int j = 0;
    AppMethodBeat.i(93191);
    int i = 0;
    while (!te()) {
      i += 1;
    }
    if (i > 0) {
      j = eo(i);
    }
    AppMethodBeat.o(93191);
    return (1 << i) - 1 + j;
  }
  
  public final void vw()
  {
    AppMethodBeat.i(93184);
    int i = this.bfu + 1;
    this.bfu = i;
    int j;
    if (i == 8)
    {
      this.bfu = 0;
      j = this.bft;
      if (!fa(this.bft + 1)) {
        break label65;
      }
    }
    label65:
    for (i = 2;; i = 1)
    {
      this.bft = (i + j);
      tf();
      AppMethodBeat.o(93184);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.n
 * JD-Core Version:    0.7.0.1
 */