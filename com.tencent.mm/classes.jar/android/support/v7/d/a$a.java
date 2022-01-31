package android.support.v7.d;

import java.util.Arrays;

final class a$a
{
  private int RA;
  int RB;
  private int RC;
  private int RD;
  private int RE;
  private int RF;
  private int RG;
  private int RH;
  private int RI;
  
  a$a(a parama, int paramInt1, int paramInt2)
  {
    this.RA = paramInt1;
    this.RB = paramInt2;
    eA();
  }
  
  final void eA()
  {
    int[] arrayOfInt1 = this.RJ.Jq;
    int[] arrayOfInt2 = this.RJ.Ru;
    int i4 = 0;
    int m = this.RA;
    int n = -2147483648;
    int j = -2147483648;
    int i5 = -2147483648;
    int k = 2147483647;
    int i = 2147483647;
    int i3 = 2147483647;
    int i1;
    int i8;
    int i6;
    int i2;
    if (m <= this.RB)
    {
      i1 = arrayOfInt1[m];
      i8 = i4 + arrayOfInt2[i1];
      int i7 = a.ba(i1);
      i6 = a.bb(i1);
      i4 = a.bc(i1);
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
        i5 = n;
        if (i4 > n) {
          i5 = i4;
        }
        i3 = k;
        if (i4 < k) {
          i3 = i4;
        }
        m += 1;
        i4 = i8;
        n = i5;
        i5 = i1;
        k = i3;
        i3 = i2;
        break;
        this.RD = i3;
        this.RE = i5;
        this.RF = i;
        this.RG = j;
        this.RH = k;
        this.RI = n;
        this.RC = i4;
        return;
      }
    }
  }
  
  final int eB()
  {
    int i = this.RE - this.RD;
    int j = this.RG - this.RF;
    int k = this.RI - this.RH;
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    if ((i >= j) && (i >= k))
    {
      i = -3;
      arrayOfInt1 = this.RJ.Jq;
      arrayOfInt2 = this.RJ.Ru;
      a.a(arrayOfInt1, i, this.RA, this.RB);
      Arrays.sort(arrayOfInt1, this.RA, this.RB + 1);
      a.a(arrayOfInt1, i, this.RA, this.RB);
      k = this.RC / 2;
      i = this.RA;
      j = 0;
    }
    for (;;)
    {
      if (i > this.RB) {
        break label180;
      }
      j += arrayOfInt2[arrayOfInt1[i]];
      if (j >= k)
      {
        return Math.min(this.RB - 1, i);
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
    return this.RA;
  }
  
  final b.c eC()
  {
    int[] arrayOfInt1 = this.RJ.Jq;
    int[] arrayOfInt2 = this.RJ.Ru;
    int j = this.RA;
    int n = 0;
    int i = 0;
    int k = 0;
    int m = 0;
    while (j <= this.RB)
    {
      int i2 = arrayOfInt1[j];
      int i1 = arrayOfInt2[i2];
      n += i1;
      m += a.ba(i2) * i1;
      k += a.bb(i2) * i1;
      i2 = a.bc(i2);
      j += 1;
      i = i2 * i1 + i;
    }
    return new b.c(a.i(Math.round(m / n), Math.round(k / n), Math.round(i / n)), n);
  }
  
  final boolean ez()
  {
    return this.RB + 1 - this.RA > 1;
  }
  
  final int getVolume()
  {
    return (this.RE - this.RD + 1) * (this.RG - this.RF + 1) * (this.RI - this.RH + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.d.a.a
 * JD-Core Version:    0.7.0.1
 */