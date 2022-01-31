package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e
{
  private final CharSequence bji;
  private final int bjj;
  public final int bjk;
  public final byte[] bjl;
  
  public e(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57167);
    this.bji = paramCharSequence;
    this.bjk = paramInt1;
    this.bjj = paramInt2;
    this.bjl = new byte[paramInt1 * paramInt2];
    Arrays.fill(this.bjl, (byte)-1);
    AppMethodBeat.o(57167);
  }
  
  private boolean by(int paramInt1, int paramInt2)
  {
    return this.bjl[(this.bjk * paramInt2 + paramInt1)] >= 0;
  }
  
  private void f(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte = this.bjl;
    int j = this.bjk;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      arrayOfByte[(j * paramInt2 + paramInt1)] = ((byte)i);
      return;
    }
  }
  
  private void p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    AppMethodBeat.i(57169);
    if (paramInt1 < 0)
    {
      paramInt1 += this.bjj;
      paramInt2 = 4 - (this.bjj + 4) % 8 + paramInt2;
    }
    for (;;)
    {
      int j = paramInt2;
      int i = paramInt1;
      if (paramInt2 < 0)
      {
        j = paramInt2 + this.bjk;
        i = paramInt1 + (4 - (this.bjk + 4) % 8);
      }
      if ((this.bji.charAt(paramInt3) & 1 << 8 - paramInt4) != 0) {}
      for (;;)
      {
        f(j, i, bool);
        AppMethodBeat.o(57169);
        return;
        bool = false;
      }
    }
  }
  
  private void z(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(57170);
    p(paramInt1 - 2, paramInt2 - 2, paramInt3, 1);
    p(paramInt1 - 2, paramInt2 - 1, paramInt3, 2);
    p(paramInt1 - 1, paramInt2 - 2, paramInt3, 3);
    p(paramInt1 - 1, paramInt2 - 1, paramInt3, 4);
    p(paramInt1 - 1, paramInt2, paramInt3, 5);
    p(paramInt1, paramInt2 - 2, paramInt3, 6);
    p(paramInt1, paramInt2 - 1, paramInt3, 7);
    p(paramInt1, paramInt2, paramInt3, 8);
    AppMethodBeat.o(57170);
  }
  
  public final void sE()
  {
    AppMethodBeat.i(57168);
    int k = 0;
    int j = 4;
    int m = 0;
    int i = m;
    if (j == this.bjj)
    {
      i = m;
      if (k == 0)
      {
        p(this.bjj - 1, 0, m, 1);
        p(this.bjj - 1, 1, m, 2);
        p(this.bjj - 1, 2, m, 3);
        p(0, this.bjk - 2, m, 4);
        p(0, this.bjk - 1, m, 5);
        p(1, this.bjk - 1, m, 6);
        p(2, this.bjk - 1, m, 7);
        p(3, this.bjk - 1, m, 8);
        i = m + 1;
      }
    }
    int n = i;
    if (j == this.bjj - 2)
    {
      n = i;
      if (k == 0)
      {
        n = i;
        if (this.bjk % 4 != 0)
        {
          p(this.bjj - 3, 0, i, 1);
          p(this.bjj - 2, 0, i, 2);
          p(this.bjj - 1, 0, i, 3);
          p(0, this.bjk - 4, i, 4);
          p(0, this.bjk - 3, i, 5);
          p(0, this.bjk - 2, i, 6);
          p(0, this.bjk - 1, i, 7);
          p(1, this.bjk - 1, i, 8);
          n = i + 1;
        }
      }
    }
    m = n;
    if (j == this.bjj - 2)
    {
      m = n;
      if (k == 0)
      {
        m = n;
        if (this.bjk % 8 == 4)
        {
          p(this.bjj - 3, 0, n, 1);
          p(this.bjj - 2, 0, n, 2);
          p(this.bjj - 1, 0, n, 3);
          p(0, this.bjk - 2, n, 4);
          p(0, this.bjk - 1, n, 5);
          p(1, this.bjk - 1, n, 6);
          p(2, this.bjk - 1, n, 7);
          p(3, this.bjk - 1, n, 8);
          m = n + 1;
        }
      }
    }
    n = k;
    int i1 = j;
    i = m;
    if (j == this.bjj + 4)
    {
      n = k;
      i1 = j;
      i = m;
      if (k == 2)
      {
        n = k;
        i1 = j;
        i = m;
        if (this.bjk % 8 == 0)
        {
          p(this.bjj - 1, 0, m, 1);
          p(this.bjj - 1, this.bjk - 1, m, 2);
          p(0, this.bjk - 3, m, 3);
          p(0, this.bjk - 2, m, 4);
          p(0, this.bjk - 1, m, 5);
          p(1, this.bjk - 3, m, 6);
          p(1, this.bjk - 2, m, 7);
          p(1, this.bjk - 1, m, 8);
          i = m + 1;
          i1 = j;
          n = k;
        }
      }
    }
    do
    {
      j = i;
      if (i1 < this.bjj)
      {
        j = i;
        if (n >= 0)
        {
          j = i;
          if (!by(n, i1))
          {
            z(i1, n, i);
            j = i + 1;
          }
        }
      }
      k = i1 - 2;
      m = n + 2;
      if (k < 0) {
        break;
      }
      n = m;
      i1 = k;
      i = j;
    } while (m < this.bjk);
    m += 3;
    k += 1;
    i = j;
    j = m;
    label727:
    if ((k >= 0) && (j < this.bjk) && (!by(j, k)))
    {
      m = i + 1;
      z(k, j, i);
      i = m;
    }
    for (;;)
    {
      k += 2;
      j -= 2;
      if ((k >= this.bjj) || (j < 0))
      {
        n = k + 3;
        i1 = j + 1;
        k = i1;
        j = n;
        m = i;
        if (n < this.bjj) {
          break;
        }
        k = i1;
        j = n;
        m = i;
        if (i1 < this.bjk) {
          break;
        }
        if (!by(this.bjk - 1, this.bjj - 1))
        {
          f(this.bjk - 1, this.bjj - 1, true);
          f(this.bjk - 2, this.bjj - 2, true);
        }
        AppMethodBeat.o(57168);
        return;
      }
      break label727;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.b.c.a.e
 * JD-Core Version:    0.7.0.1
 */