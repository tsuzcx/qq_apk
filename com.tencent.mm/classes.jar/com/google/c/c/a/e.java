package com.google.c.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e
{
  private final CharSequence cfa;
  private final int cfb;
  public final int cfc;
  public final byte[] cfd;
  
  public e(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12232);
    this.cfa = paramCharSequence;
    this.cfc = paramInt1;
    this.cfb = paramInt2;
    this.cfd = new byte[paramInt1 * paramInt2];
    Arrays.fill(this.cfd, (byte)-1);
    AppMethodBeat.o(12232);
  }
  
  private void D(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(12235);
    s(paramInt1 - 2, paramInt2 - 2, paramInt3, 1);
    s(paramInt1 - 2, paramInt2 - 1, paramInt3, 2);
    s(paramInt1 - 1, paramInt2 - 2, paramInt3, 3);
    s(paramInt1 - 1, paramInt2 - 1, paramInt3, 4);
    s(paramInt1 - 1, paramInt2, paramInt3, 5);
    s(paramInt1, paramInt2 - 2, paramInt3, 6);
    s(paramInt1, paramInt2 - 1, paramInt3, 7);
    s(paramInt1, paramInt2, paramInt3, 8);
    AppMethodBeat.o(12235);
  }
  
  private boolean ce(int paramInt1, int paramInt2)
  {
    return this.cfd[(this.cfc * paramInt2 + paramInt1)] >= 0;
  }
  
  private void h(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte = this.cfd;
    int j = this.cfc;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      arrayOfByte[(j * paramInt2 + paramInt1)] = ((byte)i);
      return;
    }
  }
  
  private void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    AppMethodBeat.i(12234);
    if (paramInt1 < 0)
    {
      paramInt1 += this.cfb;
      paramInt2 = 4 - (this.cfb + 4) % 8 + paramInt2;
    }
    for (;;)
    {
      int j = paramInt2;
      int i = paramInt1;
      if (paramInt2 < 0)
      {
        j = paramInt2 + this.cfc;
        i = paramInt1 + (4 - (this.cfc + 4) % 8);
      }
      if ((this.cfa.charAt(paramInt3) & 1 << 8 - paramInt4) != 0) {}
      for (;;)
      {
        h(j, i, bool);
        AppMethodBeat.o(12234);
        return;
        bool = false;
      }
    }
  }
  
  public final void JL()
  {
    AppMethodBeat.i(12233);
    int k = 0;
    int j = 4;
    int m = 0;
    int i = m;
    if (j == this.cfb)
    {
      i = m;
      if (k == 0)
      {
        s(this.cfb - 1, 0, m, 1);
        s(this.cfb - 1, 1, m, 2);
        s(this.cfb - 1, 2, m, 3);
        s(0, this.cfc - 2, m, 4);
        s(0, this.cfc - 1, m, 5);
        s(1, this.cfc - 1, m, 6);
        s(2, this.cfc - 1, m, 7);
        s(3, this.cfc - 1, m, 8);
        i = m + 1;
      }
    }
    int n = i;
    if (j == this.cfb - 2)
    {
      n = i;
      if (k == 0)
      {
        n = i;
        if (this.cfc % 4 != 0)
        {
          s(this.cfb - 3, 0, i, 1);
          s(this.cfb - 2, 0, i, 2);
          s(this.cfb - 1, 0, i, 3);
          s(0, this.cfc - 4, i, 4);
          s(0, this.cfc - 3, i, 5);
          s(0, this.cfc - 2, i, 6);
          s(0, this.cfc - 1, i, 7);
          s(1, this.cfc - 1, i, 8);
          n = i + 1;
        }
      }
    }
    m = n;
    if (j == this.cfb - 2)
    {
      m = n;
      if (k == 0)
      {
        m = n;
        if (this.cfc % 8 == 4)
        {
          s(this.cfb - 3, 0, n, 1);
          s(this.cfb - 2, 0, n, 2);
          s(this.cfb - 1, 0, n, 3);
          s(0, this.cfc - 2, n, 4);
          s(0, this.cfc - 1, n, 5);
          s(1, this.cfc - 1, n, 6);
          s(2, this.cfc - 1, n, 7);
          s(3, this.cfc - 1, n, 8);
          m = n + 1;
        }
      }
    }
    n = k;
    int i1 = j;
    i = m;
    if (j == this.cfb + 4)
    {
      n = k;
      i1 = j;
      i = m;
      if (k == 2)
      {
        n = k;
        i1 = j;
        i = m;
        if (this.cfc % 8 == 0)
        {
          s(this.cfb - 1, 0, m, 1);
          s(this.cfb - 1, this.cfc - 1, m, 2);
          s(0, this.cfc - 3, m, 3);
          s(0, this.cfc - 2, m, 4);
          s(0, this.cfc - 1, m, 5);
          s(1, this.cfc - 3, m, 6);
          s(1, this.cfc - 2, m, 7);
          s(1, this.cfc - 1, m, 8);
          i = m + 1;
          i1 = j;
          n = k;
        }
      }
    }
    do
    {
      j = i;
      if (i1 < this.cfb)
      {
        j = i;
        if (n >= 0)
        {
          j = i;
          if (!ce(n, i1))
          {
            D(i1, n, i);
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
    } while (m < this.cfc);
    m += 3;
    k += 1;
    i = j;
    j = m;
    label728:
    if ((k >= 0) && (j < this.cfc) && (!ce(j, k)))
    {
      m = i + 1;
      D(k, j, i);
      i = m;
    }
    for (;;)
    {
      k += 2;
      j -= 2;
      if ((k >= this.cfb) || (j < 0))
      {
        n = k + 3;
        i1 = j + 1;
        k = i1;
        j = n;
        m = i;
        if (n < this.cfb) {
          break;
        }
        k = i1;
        j = n;
        m = i;
        if (i1 < this.cfc) {
          break;
        }
        if (!ce(this.cfc - 1, this.cfb - 1))
        {
          h(this.cfc - 1, this.cfb - 1, true);
          h(this.cfc - 2, this.cfb - 2, true);
        }
        AppMethodBeat.o(12233);
        return;
      }
      break label728;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.c.a.e
 * JD-Core Version:    0.7.0.1
 */