package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  private int cTe;
  private int cTf;
  private int cTg;
  private byte[] data;
  
  public n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93182);
    l(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(93182);
  }
  
  private void Sh()
  {
    AppMethodBeat.i(93192);
    if ((this.cTf >= 0) && ((this.cTf < this.cTe) || ((this.cTf == this.cTe) && (this.cTg == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(93192);
      return;
    }
  }
  
  private boolean iK(int paramInt)
  {
    return (2 <= paramInt) && (paramInt < this.cTe) && (this.data[paramInt] == 3) && (this.data[(paramInt - 2)] == 0) && (this.data[(paramInt - 1)] == 0);
  }
  
  public final boolean Sg()
  {
    AppMethodBeat.i(93187);
    if ((this.data[this.cTf] & 128 >> this.cTg) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      UD();
      AppMethodBeat.o(93187);
      return bool;
    }
  }
  
  public final void UD()
  {
    AppMethodBeat.i(93184);
    int i = this.cTg + 1;
    this.cTg = i;
    int j;
    if (i == 8)
    {
      this.cTg = 0;
      j = this.cTf;
      if (!iK(this.cTf + 1)) {
        break label65;
      }
    }
    label65:
    for (i = 2;; i = 1)
    {
      this.cTf = (i + j);
      Sh();
      AppMethodBeat.o(93184);
      return;
    }
  }
  
  public final boolean UR()
  {
    AppMethodBeat.i(93189);
    int k = this.cTf;
    int m = this.cTg;
    int i = 0;
    while ((this.cTf < this.cTe) && (!Sg())) {
      i += 1;
    }
    if (this.cTf == this.cTe) {}
    for (int j = 1;; j = 0)
    {
      this.cTf = k;
      this.cTg = m;
      if ((j != 0) || (!iJ(i * 2 + 1))) {
        break;
      }
      AppMethodBeat.o(93189);
      return true;
    }
    AppMethodBeat.o(93189);
    return false;
  }
  
  public final int US()
  {
    AppMethodBeat.i(93190);
    int j = UT();
    if (j % 2 == 0) {}
    for (int i = -1;; i = 1)
    {
      j = (j + 1) / 2;
      AppMethodBeat.o(93190);
      return i * j;
    }
  }
  
  public final int UT()
  {
    int j = 0;
    AppMethodBeat.i(93191);
    int i = 0;
    while (!Sg()) {
      i += 1;
    }
    if (i > 0) {
      j = hQ(i);
    }
    AppMethodBeat.o(93191);
    return (1 << i) - 1 + j;
  }
  
  public final int hQ(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(93188);
    this.cTg += paramInt;
    int i = 0;
    if (this.cTg > 8)
    {
      this.cTg -= 8;
      k = i | (this.data[this.cTf] & 0xFF) << this.cTg;
      m = this.cTf;
      if (iK(this.cTf + 1)) {}
      for (i = 2;; i = 1)
      {
        this.cTf = (i + m);
        i = k;
        break;
      }
    }
    int k = this.data[this.cTf];
    int m = this.cTg;
    int n;
    if (this.cTg == 8)
    {
      this.cTg = 0;
      n = this.cTf;
      if (!iK(this.cTf + 1)) {
        break label190;
      }
    }
    for (;;)
    {
      this.cTf = (n + j);
      Sh();
      AppMethodBeat.o(93188);
      return (i | (k & 0xFF) >> 8 - m) & -1 >>> 32 - paramInt;
      label190:
      j = 1;
    }
  }
  
  public final void hR(int paramInt)
  {
    AppMethodBeat.i(93185);
    int i = this.cTf;
    int j = paramInt / 8;
    this.cTf += j;
    this.cTg = (paramInt - j * 8 + this.cTg);
    if (this.cTg > 7)
    {
      this.cTf += 1;
      this.cTg -= 8;
    }
    for (paramInt = i + 1; paramInt <= this.cTf; paramInt = i + 1)
    {
      i = paramInt;
      if (iK(paramInt))
      {
        this.cTf += 1;
        i = paramInt + 2;
      }
    }
    Sh();
    AppMethodBeat.o(93185);
  }
  
  public final boolean iJ(int paramInt)
  {
    AppMethodBeat.i(93186);
    int m = this.cTf;
    int j = paramInt / 8;
    int i = this.cTf + j;
    int k = this.cTg + paramInt - j * 8;
    paramInt = i;
    j = k;
    if (k > 7)
    {
      paramInt = i + 1;
      j = k - 8;
    }
    i = m + 1;
    while ((i <= paramInt) && (paramInt < this.cTe))
    {
      k = paramInt;
      m = i;
      if (iK(i))
      {
        k = paramInt + 1;
        m = i + 2;
      }
      i = m + 1;
      paramInt = k;
    }
    if ((paramInt < this.cTe) || ((paramInt == this.cTe) && (j == 0)))
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
    this.cTf = paramInt1;
    this.cTe = paramInt2;
    this.cTg = 0;
    Sh();
    AppMethodBeat.o(93183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.i.n
 * JD-Core Version:    0.7.0.1
 */