package com.google.c.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e
{
  private final CharSequence bIK;
  private final int bIL;
  public final int bIM;
  public final byte[] bIN;
  
  public e(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12232);
    this.bIK = paramCharSequence;
    this.bIM = paramInt1;
    this.bIL = paramInt2;
    this.bIN = new byte[paramInt1 * paramInt2];
    Arrays.fill(this.bIN, (byte)-1);
    AppMethodBeat.o(12232);
  }
  
  private void B(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(12235);
    q(paramInt1 - 2, paramInt2 - 2, paramInt3, 1);
    q(paramInt1 - 2, paramInt2 - 1, paramInt3, 2);
    q(paramInt1 - 1, paramInt2 - 2, paramInt3, 3);
    q(paramInt1 - 1, paramInt2 - 1, paramInt3, 4);
    q(paramInt1 - 1, paramInt2, paramInt3, 5);
    q(paramInt1, paramInt2 - 2, paramInt3, 6);
    q(paramInt1, paramInt2 - 1, paramInt3, 7);
    q(paramInt1, paramInt2, paramInt3, 8);
    AppMethodBeat.o(12235);
  }
  
  private boolean bK(int paramInt1, int paramInt2)
  {
    return this.bIN[(this.bIM * paramInt2 + paramInt1)] >= 0;
  }
  
  private void g(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte = this.bIN;
    int j = this.bIM;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      arrayOfByte[(j * paramInt2 + paramInt1)] = ((byte)i);
      return;
    }
  }
  
  private void q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    AppMethodBeat.i(12234);
    if (paramInt1 < 0)
    {
      paramInt1 += this.bIL;
      paramInt2 = 4 - (this.bIL + 4) % 8 + paramInt2;
    }
    for (;;)
    {
      int j = paramInt2;
      int i = paramInt1;
      if (paramInt2 < 0)
      {
        j = paramInt2 + this.bIM;
        i = paramInt1 + (4 - (this.bIM + 4) % 8);
      }
      if ((this.bIK.charAt(paramInt3) & 1 << 8 - paramInt4) != 0) {}
      for (;;)
      {
        g(j, i, bool);
        AppMethodBeat.o(12234);
        return;
        bool = false;
      }
    }
  }
  
  public final void xY()
  {
    AppMethodBeat.i(12233);
    int k = 0;
    int j = 4;
    int m = 0;
    int i = m;
    if (j == this.bIL)
    {
      i = m;
      if (k == 0)
      {
        q(this.bIL - 1, 0, m, 1);
        q(this.bIL - 1, 1, m, 2);
        q(this.bIL - 1, 2, m, 3);
        q(0, this.bIM - 2, m, 4);
        q(0, this.bIM - 1, m, 5);
        q(1, this.bIM - 1, m, 6);
        q(2, this.bIM - 1, m, 7);
        q(3, this.bIM - 1, m, 8);
        i = m + 1;
      }
    }
    int n = i;
    if (j == this.bIL - 2)
    {
      n = i;
      if (k == 0)
      {
        n = i;
        if (this.bIM % 4 != 0)
        {
          q(this.bIL - 3, 0, i, 1);
          q(this.bIL - 2, 0, i, 2);
          q(this.bIL - 1, 0, i, 3);
          q(0, this.bIM - 4, i, 4);
          q(0, this.bIM - 3, i, 5);
          q(0, this.bIM - 2, i, 6);
          q(0, this.bIM - 1, i, 7);
          q(1, this.bIM - 1, i, 8);
          n = i + 1;
        }
      }
    }
    m = n;
    if (j == this.bIL - 2)
    {
      m = n;
      if (k == 0)
      {
        m = n;
        if (this.bIM % 8 == 4)
        {
          q(this.bIL - 3, 0, n, 1);
          q(this.bIL - 2, 0, n, 2);
          q(this.bIL - 1, 0, n, 3);
          q(0, this.bIM - 2, n, 4);
          q(0, this.bIM - 1, n, 5);
          q(1, this.bIM - 1, n, 6);
          q(2, this.bIM - 1, n, 7);
          q(3, this.bIM - 1, n, 8);
          m = n + 1;
        }
      }
    }
    n = k;
    int i1 = j;
    i = m;
    if (j == this.bIL + 4)
    {
      n = k;
      i1 = j;
      i = m;
      if (k == 2)
      {
        n = k;
        i1 = j;
        i = m;
        if (this.bIM % 8 == 0)
        {
          q(this.bIL - 1, 0, m, 1);
          q(this.bIL - 1, this.bIM - 1, m, 2);
          q(0, this.bIM - 3, m, 3);
          q(0, this.bIM - 2, m, 4);
          q(0, this.bIM - 1, m, 5);
          q(1, this.bIM - 3, m, 6);
          q(1, this.bIM - 2, m, 7);
          q(1, this.bIM - 1, m, 8);
          i = m + 1;
          i1 = j;
          n = k;
        }
      }
    }
    do
    {
      j = i;
      if (i1 < this.bIL)
      {
        j = i;
        if (n >= 0)
        {
          j = i;
          if (!bK(n, i1))
          {
            B(i1, n, i);
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
    } while (m < this.bIM);
    m += 3;
    k += 1;
    i = j;
    j = m;
    label728:
    if ((k >= 0) && (j < this.bIM) && (!bK(j, k)))
    {
      m = i + 1;
      B(k, j, i);
      i = m;
    }
    for (;;)
    {
      k += 2;
      j -= 2;
      if ((k >= this.bIL) || (j < 0))
      {
        n = k + 3;
        i1 = j + 1;
        k = i1;
        j = n;
        m = i;
        if (n < this.bIL) {
          break;
        }
        k = i1;
        j = n;
        m = i;
        if (i1 < this.bIM) {
          break;
        }
        if (!bK(this.bIM - 1, this.bIL - 1))
        {
          g(this.bIM - 1, this.bIL - 1, true);
          g(this.bIM - 2, this.bIL - 2, true);
        }
        AppMethodBeat.o(12233);
        return;
      }
      break label728;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.c.a.e
 * JD-Core Version:    0.7.0.1
 */