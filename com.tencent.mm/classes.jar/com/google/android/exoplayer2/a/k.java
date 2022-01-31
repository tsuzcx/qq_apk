package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class k
{
  private int aAA;
  final int aAg;
  private final int aAh;
  private final int aAi;
  final int aAj;
  private final short[] aAk;
  private int aAl;
  short[] aAm;
  private int aAn;
  short[] aAo;
  private int aAp;
  private short[] aAq;
  private int aAr;
  private int aAs;
  int aAt;
  int aAu;
  int aAv;
  int aAw;
  private int aAx;
  private int aAy;
  private int aAz;
  float pitch;
  private final int sampleRate;
  float speed;
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94722);
    this.sampleRate = paramInt1;
    this.aAg = paramInt2;
    this.aAh = (paramInt1 / 400);
    this.aAi = (paramInt1 / 65);
    this.aAj = (this.aAi * 2);
    this.aAk = new short[this.aAj];
    this.aAl = this.aAj;
    this.aAm = new short[this.aAj * paramInt2];
    this.aAn = this.aAj;
    this.aAo = new short[this.aAj * paramInt2];
    this.aAp = this.aAj;
    this.aAq = new short[this.aAj * paramInt2];
    this.aAr = 0;
    this.aAs = 0;
    this.aAx = 0;
    this.speed = 1.0F;
    this.pitch = 1.0F;
    AppMethodBeat.o(94722);
  }
  
  private int a(short[] paramArrayOfShort, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94726);
    int k = 0;
    int j = 255;
    int m = 1;
    int i = 0;
    int i2 = paramInt1 * this.aAg;
    paramInt1 = paramInt2;
    int n;
    int i1;
    if (paramInt1 <= paramInt3)
    {
      paramInt2 = 0;
      n = 0;
      while (n < paramInt1)
      {
        paramInt2 += Math.abs(paramArrayOfShort[(i2 + n)] - paramArrayOfShort[(i2 + paramInt1 + n)]);
        n += 1;
      }
      i1 = m;
      n = k;
      if (paramInt2 * k < m * paramInt1)
      {
        i1 = paramInt2;
        n = paramInt1;
      }
      if (paramInt2 * j <= i * paramInt1) {
        break label161;
      }
      j = paramInt1;
    }
    for (;;)
    {
      paramInt1 += 1;
      i = paramInt2;
      m = i1;
      k = n;
      break;
      this.aAz = (m / k);
      this.aAA = (i / j);
      AppMethodBeat.o(94726);
      return k;
      label161:
      paramInt2 = i;
    }
  }
  
  private static void a(int paramInt1, int paramInt2, short[] paramArrayOfShort1, int paramInt3, short[] paramArrayOfShort2, int paramInt4, short[] paramArrayOfShort3, int paramInt5)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int n = paramInt3 * paramInt2 + i;
      int j = paramInt5 * paramInt2 + i;
      int m = paramInt4 * paramInt2 + i;
      int k = 0;
      while (k < paramInt1)
      {
        paramArrayOfShort1[n] = ((short)((paramArrayOfShort2[m] * (paramInt1 - k) + paramArrayOfShort3[j] * k) / paramInt1));
        n += paramInt2;
        m += paramInt2;
        j += paramInt2;
        k += 1;
      }
      i += 1;
    }
  }
  
  private void a(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94725);
    cZ(paramInt2);
    System.arraycopy(paramArrayOfShort, this.aAg * paramInt1, this.aAo, this.aAu * this.aAg, this.aAg * paramInt2);
    this.aAu += paramInt2;
    AppMethodBeat.o(94725);
  }
  
  private void b(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int k = this.aAj / paramInt2;
    int m = this.aAg * paramInt2;
    int n = this.aAg;
    paramInt2 = 0;
    while (paramInt2 < k)
    {
      int i = 0;
      int j = 0;
      while (i < m)
      {
        j += paramArrayOfShort[(paramInt2 * m + paramInt1 * n + i)];
        i += 1;
      }
      i = j / m;
      this.aAk[paramInt2] = ((short)i);
      paramInt2 += 1;
    }
  }
  
  private void cZ(int paramInt)
  {
    AppMethodBeat.i(94723);
    if (this.aAu + paramInt > this.aAn)
    {
      this.aAn += this.aAn / 2 + paramInt;
      this.aAo = Arrays.copyOf(this.aAo, this.aAn * this.aAg);
    }
    AppMethodBeat.o(94723);
  }
  
  final void da(int paramInt)
  {
    AppMethodBeat.i(94724);
    if (this.aAt + paramInt > this.aAl)
    {
      this.aAl += this.aAl / 2 + paramInt;
      this.aAm = Arrays.copyOf(this.aAm, this.aAl * this.aAg);
    }
    AppMethodBeat.o(94724);
  }
  
  final void nC()
  {
    AppMethodBeat.i(94727);
    int n = this.aAu;
    float f = this.speed / this.pitch;
    int i1;
    int k;
    int i;
    int j;
    label154:
    short[] arrayOfShort1;
    if ((f > 1.00001D) || (f < 0.9999900000000001D))
    {
      if (this.aAt >= this.aAj)
      {
        i1 = this.aAt;
        k = 0;
        do
        {
          if (this.aAw <= 0) {
            break;
          }
          i = Math.min(this.aAj, this.aAw);
          a(this.aAm, k, i);
          this.aAw -= i;
          i = k + i;
          k = i;
        } while (this.aAj + i <= i1);
        j = this.aAt - i;
        System.arraycopy(this.aAm, this.aAg * i, this.aAm, 0, this.aAg * j);
        this.aAt = j;
      }
      if (this.pitch == 1.0F) {
        break label1163;
      }
      f = this.pitch;
      if (this.aAu == n) {
        break label1163;
      }
      j = (int)(this.sampleRate / f);
      i = this.sampleRate;
      while ((j > 16384) || (i > 16384))
      {
        j /= 2;
        i /= 2;
      }
      arrayOfShort1 = this.aAm;
      if (this.sampleRate > 4000)
      {
        i = this.sampleRate / 4000;
        label241:
        if ((this.aAg != 1) || (i != 1)) {
          break label400;
        }
        i = a(arrayOfShort1, k, this.aAh, this.aAi);
      }
    }
    for (;;)
    {
      label271:
      j = this.aAz;
      int m = this.aAA;
      if ((j == 0) || (this.aAx == 0))
      {
        j = 0;
        label295:
        if (j == 0) {
          break label561;
        }
        j = this.aAx;
        label304:
        this.aAy = this.aAz;
        this.aAx = i;
        if (f <= 1.0D) {
          break label586;
        }
        arrayOfShort1 = this.aAm;
        if (f < 2.0F) {
          break label566;
        }
        i = (int)(j / (f - 1.0F));
        label344:
        cZ(i);
        a(i, this.aAg, this.aAo, this.aAu, arrayOfShort1, k, arrayOfShort1, k + j);
        this.aAu += i;
        i = k + (i + j);
        break;
        i = 1;
        break label241;
        label400:
        b(arrayOfShort1, k, i);
        j = a(this.aAk, 0, this.aAh / i, this.aAi / i);
        if (i == 1) {
          break label1178;
        }
        j *= i;
        m = j - i * 4;
        j += i * 4;
        if (m >= this.aAh) {
          break label1172;
        }
      }
      label1163:
      label1172:
      for (i = this.aAh;; i = m)
      {
        if (j > this.aAi) {
          j = this.aAi;
        }
        for (;;)
        {
          if (this.aAg == 1)
          {
            i = a(arrayOfShort1, k, i, j);
            break label271;
          }
          b(arrayOfShort1, k, 1);
          i = a(this.aAk, 0, i, j);
          break label271;
          if (m > j * 3)
          {
            j = 0;
            break label295;
          }
          if (j * 2 <= this.aAy * 3)
          {
            j = 0;
            break label295;
          }
          j = 1;
          break label295;
          label561:
          j = i;
          break label304;
          label566:
          this.aAw = ((int)(j * (2.0F - f) / (f - 1.0F)));
          i = j;
          break label344;
          label586:
          arrayOfShort1 = this.aAm;
          if (f < 0.5F) {}
          for (i = (int)(j * f / (1.0F - f));; i = j)
          {
            cZ(j + i);
            System.arraycopy(arrayOfShort1, this.aAg * k, this.aAo, this.aAu * this.aAg, this.aAg * j);
            a(i, this.aAg, this.aAo, this.aAu + j, arrayOfShort1, k + j, arrayOfShort1, k);
            this.aAu += j + i;
            i = k + i;
            break;
            this.aAw = ((int)(j * (2.0F * f - 1.0F) / (1.0F - f)));
          }
          a(this.aAm, 0, this.aAt);
          this.aAt = 0;
          break label154;
          k = this.aAu - n;
          if (this.aAv + k > this.aAp)
          {
            this.aAp += this.aAp / 2 + k;
            this.aAq = Arrays.copyOf(this.aAq, this.aAp * this.aAg);
          }
          System.arraycopy(this.aAo, this.aAg * n, this.aAq, this.aAv * this.aAg, this.aAg * k);
          this.aAu = n;
          this.aAv = (k + this.aAv);
          k = 0;
          if (k < this.aAv - 1)
          {
            while ((this.aAr + 1) * j > this.aAs * i)
            {
              cZ(1);
              m = 0;
              while (m < this.aAg)
              {
                arrayOfShort1 = this.aAo;
                n = this.aAu;
                i1 = this.aAg;
                short[] arrayOfShort2 = this.aAq;
                int i3 = this.aAg * k + m;
                int i2 = arrayOfShort2[i3];
                i3 = arrayOfShort2[(i3 + this.aAg)];
                int i6 = this.aAs;
                int i4 = this.aAr;
                int i5 = (this.aAr + 1) * j;
                i6 = i5 - i6 * i;
                i4 = i5 - i4 * j;
                arrayOfShort1[(n * i1 + m)] = ((short)((i3 * (i4 - i6) + i2 * i6) / i4));
                m += 1;
              }
              this.aAs += 1;
              this.aAu += 1;
            }
            this.aAr += 1;
            if (this.aAr == i)
            {
              this.aAr = 0;
              if (this.aAs != j) {
                break label1107;
              }
            }
            label1107:
            for (boolean bool = true;; bool = false)
            {
              a.checkState(bool);
              this.aAs = 0;
              k += 1;
              break;
            }
          }
          i = this.aAv - 1;
          if (i != 0)
          {
            System.arraycopy(this.aAq, this.aAg * i, this.aAq, 0, (this.aAv - i) * this.aAg);
            this.aAv -= i;
          }
          AppMethodBeat.o(94727);
          return;
        }
      }
      label1178:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.a.k
 * JD-Core Version:    0.7.0.1
 */