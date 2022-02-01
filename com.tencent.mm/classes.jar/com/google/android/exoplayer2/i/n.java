package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  private int bpM;
  private int bpN;
  private int bpO;
  private byte[] data;
  
  public n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93182);
    l(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(93182);
  }
  
  private boolean fd(int paramInt)
  {
    return (2 <= paramInt) && (paramInt < this.bpM) && (this.data[paramInt] == 3) && (this.data[(paramInt - 2)] == 0) && (this.data[(paramInt - 1)] == 0);
  }
  
  private void uE()
  {
    AppMethodBeat.i(93192);
    if ((this.bpN >= 0) && ((this.bpN < this.bpM) || ((this.bpN == this.bpM) && (this.bpO == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(93192);
      return;
    }
  }
  
  public final int es(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(93188);
    this.bpO += paramInt;
    int i = 0;
    if (this.bpO > 8)
    {
      this.bpO -= 8;
      k = i | (this.data[this.bpN] & 0xFF) << this.bpO;
      m = this.bpN;
      if (fd(this.bpN + 1)) {}
      for (i = 2;; i = 1)
      {
        this.bpN = (i + m);
        i = k;
        break;
      }
    }
    int k = this.data[this.bpN];
    int m = this.bpO;
    int n;
    if (this.bpO == 8)
    {
      this.bpO = 0;
      n = this.bpN;
      if (!fd(this.bpN + 1)) {
        break label190;
      }
    }
    for (;;)
    {
      this.bpN = (n + j);
      uE();
      AppMethodBeat.o(93188);
      return (i | (k & 0xFF) >> 8 - m) & -1 >>> 32 - paramInt;
      label190:
      j = 1;
    }
  }
  
  public final void et(int paramInt)
  {
    AppMethodBeat.i(93185);
    int i = this.bpN;
    int j = paramInt / 8;
    this.bpN += j;
    this.bpO = (paramInt - j * 8 + this.bpO);
    if (this.bpO > 7)
    {
      this.bpN += 1;
      this.bpO -= 8;
    }
    for (paramInt = i + 1; paramInt <= this.bpN; paramInt = i + 1)
    {
      i = paramInt;
      if (fd(paramInt))
      {
        this.bpN += 1;
        i = paramInt + 2;
      }
    }
    uE();
    AppMethodBeat.o(93185);
  }
  
  public final boolean fc(int paramInt)
  {
    AppMethodBeat.i(93186);
    int m = this.bpN;
    int j = paramInt / 8;
    int i = this.bpN + j;
    int k = this.bpO + paramInt - j * 8;
    paramInt = i;
    j = k;
    if (k > 7)
    {
      paramInt = i + 1;
      j = k - 8;
    }
    i = m + 1;
    while ((i <= paramInt) && (paramInt < this.bpM))
    {
      k = paramInt;
      m = i;
      if (fd(i))
      {
        k = paramInt + 1;
        m = i + 2;
      }
      i = m + 1;
      paramInt = k;
    }
    if ((paramInt < this.bpM) || ((paramInt == this.bpM) && (j == 0)))
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
    this.bpN = paramInt1;
    this.bpM = paramInt2;
    this.bpO = 0;
    uE();
    AppMethodBeat.o(93183);
  }
  
  public final boolean uD()
  {
    AppMethodBeat.i(93187);
    if ((this.data[this.bpN] & 128 >> this.bpO) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      wT();
      AppMethodBeat.o(93187);
      return bool;
    }
  }
  
  public final void wT()
  {
    AppMethodBeat.i(93184);
    int i = this.bpO + 1;
    this.bpO = i;
    int j;
    if (i == 8)
    {
      this.bpO = 0;
      j = this.bpN;
      if (!fd(this.bpN + 1)) {
        break label65;
      }
    }
    label65:
    for (i = 2;; i = 1)
    {
      this.bpN = (i + j);
      uE();
      AppMethodBeat.o(93184);
      return;
    }
  }
  
  public final boolean xg()
  {
    AppMethodBeat.i(93189);
    int k = this.bpN;
    int m = this.bpO;
    int i = 0;
    while ((this.bpN < this.bpM) && (!uD())) {
      i += 1;
    }
    if (this.bpN == this.bpM) {}
    for (int j = 1;; j = 0)
    {
      this.bpN = k;
      this.bpO = m;
      if ((j != 0) || (!fc(i * 2 + 1))) {
        break;
      }
      AppMethodBeat.o(93189);
      return true;
    }
    AppMethodBeat.o(93189);
    return false;
  }
  
  public final int xh()
  {
    AppMethodBeat.i(93190);
    int j = xi();
    if (j % 2 == 0) {}
    for (int i = -1;; i = 1)
    {
      j = (j + 1) / 2;
      AppMethodBeat.o(93190);
      return i * j;
    }
  }
  
  public final int xi()
  {
    int j = 0;
    AppMethodBeat.i(93191);
    int i = 0;
    while (!uD()) {
      i += 1;
    }
    if (i > 0) {
      j = es(i);
    }
    AppMethodBeat.o(93191);
    return (1 << i) - 1 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.i.n
 * JD-Core Version:    0.7.0.1
 */