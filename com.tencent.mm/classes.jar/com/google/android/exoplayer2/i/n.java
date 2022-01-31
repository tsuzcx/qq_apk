package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  private int aJm;
  private int aJn;
  private int aJo;
  private byte[] data;
  
  public n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95920);
    l(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(95920);
  }
  
  private boolean eq(int paramInt)
  {
    return (2 <= paramInt) && (paramInt < this.aJm) && (this.data[paramInt] == 3) && (this.data[(paramInt - 2)] == 0) && (this.data[(paramInt - 1)] == 0);
  }
  
  private void ok()
  {
    AppMethodBeat.i(95930);
    if ((this.aJn >= 0) && ((this.aJn < this.aJm) || ((this.aJn == this.aJm) && (this.aJo == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(95930);
      return;
    }
  }
  
  public final int dD(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(95926);
    this.aJo += paramInt;
    int i = 0;
    if (this.aJo > 8)
    {
      this.aJo -= 8;
      k = i | (this.data[this.aJn] & 0xFF) << this.aJo;
      m = this.aJn;
      if (eq(this.aJn + 1)) {}
      for (i = 2;; i = 1)
      {
        this.aJn = (i + m);
        i = k;
        break;
      }
    }
    int k = this.data[this.aJn];
    int m = this.aJo;
    int n;
    if (this.aJo == 8)
    {
      this.aJo = 0;
      n = this.aJn;
      if (!eq(this.aJn + 1)) {
        break label190;
      }
    }
    for (;;)
    {
      this.aJn = (n + j);
      ok();
      AppMethodBeat.o(95926);
      return (i | (k & 0xFF) >> 8 - m) & -1 >>> 32 - paramInt;
      label190:
      j = 1;
    }
  }
  
  public final void dE(int paramInt)
  {
    AppMethodBeat.i(95923);
    int i = this.aJn;
    int j = paramInt / 8;
    this.aJn += j;
    this.aJo = (paramInt - j * 8 + this.aJo);
    if (this.aJo > 7)
    {
      this.aJn += 1;
      this.aJo -= 8;
    }
    for (paramInt = i + 1; paramInt <= this.aJn; paramInt = i + 1)
    {
      i = paramInt;
      if (eq(paramInt))
      {
        this.aJn += 1;
        i = paramInt + 2;
      }
    }
    ok();
    AppMethodBeat.o(95923);
  }
  
  public final boolean ep(int paramInt)
  {
    AppMethodBeat.i(95924);
    int m = this.aJn;
    int j = paramInt / 8;
    int i = this.aJn + j;
    int k = this.aJo + paramInt - j * 8;
    paramInt = i;
    j = k;
    if (k > 7)
    {
      paramInt = i + 1;
      j = k - 8;
    }
    i = m + 1;
    while ((i <= paramInt) && (paramInt < this.aJm))
    {
      k = paramInt;
      m = i;
      if (eq(i))
      {
        k = paramInt + 1;
        m = i + 2;
      }
      i = m + 1;
      paramInt = k;
    }
    if ((paramInt < this.aJm) || ((paramInt == this.aJm) && (j == 0)))
    {
      AppMethodBeat.o(95924);
      return true;
    }
    AppMethodBeat.o(95924);
    return false;
  }
  
  public final void l(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95921);
    this.data = paramArrayOfByte;
    this.aJn = paramInt1;
    this.aJm = paramInt2;
    this.aJo = 0;
    ok();
    AppMethodBeat.o(95921);
  }
  
  public final boolean oj()
  {
    AppMethodBeat.i(95925);
    if ((this.data[this.aJn] & 128 >> this.aJo) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      qK();
      AppMethodBeat.o(95925);
      return bool;
    }
  }
  
  public final void qK()
  {
    AppMethodBeat.i(95922);
    int i = this.aJo + 1;
    this.aJo = i;
    int j;
    if (i == 8)
    {
      this.aJo = 0;
      j = this.aJn;
      if (!eq(this.aJn + 1)) {
        break label65;
      }
    }
    label65:
    for (i = 2;; i = 1)
    {
      this.aJn = (i + j);
      ok();
      AppMethodBeat.o(95922);
      return;
    }
  }
  
  public final boolean qX()
  {
    AppMethodBeat.i(95927);
    int k = this.aJn;
    int m = this.aJo;
    int i = 0;
    while ((this.aJn < this.aJm) && (!oj())) {
      i += 1;
    }
    if (this.aJn == this.aJm) {}
    for (int j = 1;; j = 0)
    {
      this.aJn = k;
      this.aJo = m;
      if ((j != 0) || (!ep(i * 2 + 1))) {
        break;
      }
      AppMethodBeat.o(95927);
      return true;
    }
    AppMethodBeat.o(95927);
    return false;
  }
  
  public final int qY()
  {
    AppMethodBeat.i(95928);
    int j = qZ();
    if (j % 2 == 0) {}
    for (int i = -1;; i = 1)
    {
      j = (j + 1) / 2;
      AppMethodBeat.o(95928);
      return i * j;
    }
  }
  
  public final int qZ()
  {
    int j = 0;
    AppMethodBeat.i(95929);
    int i = 0;
    while (!oj()) {
      i += 1;
    }
    if (i > 0) {
      j = dD(i);
    }
    AppMethodBeat.o(95929);
    return (1 << i) - 1 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.i.n
 * JD-Core Version:    0.7.0.1
 */