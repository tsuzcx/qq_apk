package android.support.v7.d;

import java.util.Arrays;

final class a$a
{
  private int Rh;
  int Ri;
  private int Rj;
  private int Rk;
  private int Rl;
  private int Rm;
  private int Rn;
  private int Ro;
  private int Rp;
  
  a$a(a parama, int paramInt1, int paramInt2)
  {
    this.Rh = paramInt1;
    this.Ri = paramInt2;
    ff();
  }
  
  private int fe()
  {
    return this.Ri + 1 - this.Rh;
  }
  
  final boolean fd()
  {
    return fe() > 1;
  }
  
  final void ff()
  {
    int[] arrayOfInt1 = this.Rq.Aq;
    int[] arrayOfInt2 = this.Rq.mHistogram;
    int i4 = 0;
    int n = this.Rh;
    int i5 = -2147483648;
    int j = -2147483648;
    int m = -2147483648;
    int i3 = 2147483647;
    int i = 2147483647;
    int k = 2147483647;
    int i1;
    int i8;
    int i6;
    int i2;
    if (n <= this.Ri)
    {
      i1 = arrayOfInt1[n];
      i8 = i4 + arrayOfInt2[i1];
      int i7 = a.aW(i1);
      i6 = a.aX(i1);
      i4 = a.aY(i1);
      i1 = i5;
      if (i7 > i5) {
        i1 = i7;
      }
      i2 = i3;
      if (i7 < i3) {
        i2 = i7;
      }
      if (i6 <= j) {
        break label242;
      }
      j = i6;
    }
    label242:
    for (;;)
    {
      if (i6 < i) {
        i = i6;
      }
      for (;;)
      {
        i3 = m;
        if (i4 > m) {
          i3 = i4;
        }
        i6 = k;
        if (i4 < k) {
          i6 = i4;
        }
        n += 1;
        i4 = i8;
        i5 = i1;
        m = i3;
        i3 = i2;
        k = i6;
        break;
        this.Rk = i3;
        this.Rl = i5;
        this.Rm = i;
        this.Rn = j;
        this.Ro = k;
        this.Rp = m;
        this.Rj = i4;
        return;
      }
    }
  }
  
  final int fg()
  {
    int i = this.Rl - this.Rk;
    int j = this.Rn - this.Rm;
    int k = this.Rp - this.Ro;
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    if ((i >= j) && (i >= k))
    {
      i = -3;
      arrayOfInt1 = this.Rq.Aq;
      arrayOfInt2 = this.Rq.mHistogram;
      a.a(arrayOfInt1, i, this.Rh, this.Ri);
      Arrays.sort(arrayOfInt1, this.Rh, this.Ri + 1);
      a.a(arrayOfInt1, i, this.Rh, this.Ri);
      k = this.Rj / 2;
      i = this.Rh;
      j = 0;
    }
    for (;;)
    {
      if (i > this.Ri) {
        break label180;
      }
      j += arrayOfInt2[arrayOfInt1[i]];
      if (j >= k)
      {
        return Math.min(this.Ri - 1, i);
        if ((j >= i) && (j >= k))
        {
          i = -2;
          break;
        }
        i = -1;
        break;
      }
      i += 1;
    }
    label180:
    return this.Rh;
  }
  
  final b.c fh()
  {
    int[] arrayOfInt1 = this.Rq.Aq;
    int[] arrayOfInt2 = this.Rq.mHistogram;
    int j = this.Rh;
    int n = 0;
    int i = 0;
    int k = 0;
    int m = 0;
    while (j <= this.Ri)
    {
      int i2 = arrayOfInt1[j];
      int i1 = arrayOfInt2[i2];
      n += i1;
      m += a.aW(i2) * i1;
      k += a.aX(i2) * i1;
      i2 = a.aY(i2);
      j += 1;
      i = i2 * i1 + i;
    }
    return new b.c(a.i(Math.round(m / n), Math.round(k / n), Math.round(i / n)), n);
  }
  
  final int getVolume()
  {
    return (this.Rl - this.Rk + 1) * (this.Rn - this.Rm + 1) * (this.Rp - this.Ro + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.d.a.a
 * JD-Core Version:    0.7.0.1
 */