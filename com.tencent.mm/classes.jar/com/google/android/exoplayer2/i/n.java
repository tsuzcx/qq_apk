package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  private int aZj;
  private int aZk;
  private int aZl;
  private byte[] data;
  
  public n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93182);
    l(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(93182);
  }
  
  private boolean fx(int paramInt)
  {
    return (2 <= paramInt) && (paramInt < this.aZj) && (this.data[paramInt] == 3) && (this.data[(paramInt - 2)] == 0) && (this.data[(paramInt - 1)] == 0);
  }
  
  private void sE()
  {
    AppMethodBeat.i(93192);
    if ((this.aZk >= 0) && ((this.aZk < this.aZj) || ((this.aZk == this.aZj) && (this.aZl == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(93192);
      return;
    }
  }
  
  public final int eA(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(93188);
    this.aZl += paramInt;
    int i = 0;
    if (this.aZl > 8)
    {
      this.aZl -= 8;
      k = i | (this.data[this.aZk] & 0xFF) << this.aZl;
      m = this.aZk;
      if (fx(this.aZk + 1)) {}
      for (i = 2;; i = 1)
      {
        this.aZk = (i + m);
        i = k;
        break;
      }
    }
    int k = this.data[this.aZk];
    int m = this.aZl;
    int n;
    if (this.aZl == 8)
    {
      this.aZl = 0;
      n = this.aZk;
      if (!fx(this.aZk + 1)) {
        break label190;
      }
    }
    for (;;)
    {
      this.aZk = (n + j);
      sE();
      AppMethodBeat.o(93188);
      return (i | (k & 0xFF) >> 8 - m) & -1 >>> 32 - paramInt;
      label190:
      j = 1;
    }
  }
  
  public final void eB(int paramInt)
  {
    AppMethodBeat.i(93185);
    int i = this.aZk;
    int j = paramInt / 8;
    this.aZk += j;
    this.aZl = (paramInt - j * 8 + this.aZl);
    if (this.aZl > 7)
    {
      this.aZk += 1;
      this.aZl -= 8;
    }
    for (paramInt = i + 1; paramInt <= this.aZk; paramInt = i + 1)
    {
      i = paramInt;
      if (fx(paramInt))
      {
        this.aZk += 1;
        i = paramInt + 2;
      }
    }
    sE();
    AppMethodBeat.o(93185);
  }
  
  public final boolean fw(int paramInt)
  {
    AppMethodBeat.i(93186);
    int m = this.aZk;
    int j = paramInt / 8;
    int i = this.aZk + j;
    int k = this.aZl + paramInt - j * 8;
    paramInt = i;
    j = k;
    if (k > 7)
    {
      paramInt = i + 1;
      j = k - 8;
    }
    i = m + 1;
    while ((i <= paramInt) && (paramInt < this.aZj))
    {
      k = paramInt;
      m = i;
      if (fx(i))
      {
        k = paramInt + 1;
        m = i + 2;
      }
      i = m + 1;
      paramInt = k;
    }
    if ((paramInt < this.aZj) || ((paramInt == this.aZj) && (j == 0)))
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
    this.aZk = paramInt1;
    this.aZj = paramInt2;
    this.aZl = 0;
    sE();
    AppMethodBeat.o(93183);
  }
  
  public final boolean sD()
  {
    AppMethodBeat.i(93187);
    if ((this.data[this.aZk] & 128 >> this.aZl) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ve();
      AppMethodBeat.o(93187);
      return bool;
    }
  }
  
  public final void ve()
  {
    AppMethodBeat.i(93184);
    int i = this.aZl + 1;
    this.aZl = i;
    int j;
    if (i == 8)
    {
      this.aZl = 0;
      j = this.aZk;
      if (!fx(this.aZk + 1)) {
        break label65;
      }
    }
    label65:
    for (i = 2;; i = 1)
    {
      this.aZk = (i + j);
      sE();
      AppMethodBeat.o(93184);
      return;
    }
  }
  
  public final boolean vs()
  {
    AppMethodBeat.i(93189);
    int k = this.aZk;
    int m = this.aZl;
    int i = 0;
    while ((this.aZk < this.aZj) && (!sD())) {
      i += 1;
    }
    if (this.aZk == this.aZj) {}
    for (int j = 1;; j = 0)
    {
      this.aZk = k;
      this.aZl = m;
      if ((j != 0) || (!fw(i * 2 + 1))) {
        break;
      }
      AppMethodBeat.o(93189);
      return true;
    }
    AppMethodBeat.o(93189);
    return false;
  }
  
  public final int vt()
  {
    AppMethodBeat.i(93190);
    int j = vu();
    if (j % 2 == 0) {}
    for (int i = -1;; i = 1)
    {
      j = (j + 1) / 2;
      AppMethodBeat.o(93190);
      return i * j;
    }
  }
  
  public final int vu()
  {
    int j = 0;
    AppMethodBeat.i(93191);
    int i = 0;
    while (!sD()) {
      i += 1;
    }
    if (i > 0) {
      j = eA(i);
    }
    AppMethodBeat.o(93191);
    return (1 << i) - 1 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.i.n
 * JD-Core Version:    0.7.0.1
 */