package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class k
{
  float cHk;
  final int cKa;
  private final int cKb;
  private final int cKc;
  final int cKd;
  private final short[] cKe;
  private int cKf;
  short[] cKg;
  private int cKh;
  short[] cKi;
  private int cKj;
  private short[] cKk;
  private int cKl;
  private int cKm;
  int cKn;
  int cKo;
  int cKp;
  int cKq;
  private int cKr;
  private int cKs;
  private int cKt;
  private int cKu;
  float pitch;
  private final int sampleRate;
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91833);
    this.sampleRate = paramInt1;
    this.cKa = paramInt2;
    this.cKb = (paramInt1 / 400);
    this.cKc = (paramInt1 / 65);
    this.cKd = (this.cKc * 2);
    this.cKe = new short[this.cKd];
    this.cKf = this.cKd;
    this.cKg = new short[this.cKd * paramInt2];
    this.cKh = this.cKd;
    this.cKi = new short[this.cKd * paramInt2];
    this.cKj = this.cKd;
    this.cKk = new short[this.cKd * paramInt2];
    this.cKl = 0;
    this.cKm = 0;
    this.cKr = 0;
    this.cHk = 1.0F;
    this.pitch = 1.0F;
    AppMethodBeat.o(91833);
  }
  
  private int a(short[] paramArrayOfShort, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(91837);
    int k = 0;
    int j = 255;
    int m = 1;
    int i = 0;
    int i2 = paramInt1 * this.cKa;
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
      this.cKt = (m / k);
      this.cKu = (i / j);
      AppMethodBeat.o(91837);
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
    AppMethodBeat.i(91836);
    hn(paramInt2);
    System.arraycopy(paramArrayOfShort, this.cKa * paramInt1, this.cKi, this.cKo * this.cKa, this.cKa * paramInt2);
    this.cKo += paramInt2;
    AppMethodBeat.o(91836);
  }
  
  private void b(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int k = this.cKd / paramInt2;
    int m = this.cKa * paramInt2;
    int n = this.cKa;
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
      this.cKe[paramInt2] = ((short)i);
      paramInt2 += 1;
    }
  }
  
  private void hn(int paramInt)
  {
    AppMethodBeat.i(91834);
    if (this.cKo + paramInt > this.cKh)
    {
      this.cKh += this.cKh / 2 + paramInt;
      this.cKi = Arrays.copyOf(this.cKi, this.cKh * this.cKa);
    }
    AppMethodBeat.o(91834);
  }
  
  final void Rw()
  {
    AppMethodBeat.i(91838);
    int n = this.cKo;
    float f = this.cHk / this.pitch;
    int i1;
    int k;
    int i;
    int j;
    label154:
    short[] arrayOfShort1;
    if ((f > 1.00001D) || (f < 0.9999900000000001D))
    {
      if (this.cKn >= this.cKd)
      {
        i1 = this.cKn;
        k = 0;
        do
        {
          if (this.cKq <= 0) {
            break;
          }
          i = Math.min(this.cKd, this.cKq);
          a(this.cKg, k, i);
          this.cKq -= i;
          i = k + i;
          k = i;
        } while (this.cKd + i <= i1);
        j = this.cKn - i;
        System.arraycopy(this.cKg, this.cKa * i, this.cKg, 0, this.cKa * j);
        this.cKn = j;
      }
      if (this.pitch == 1.0F) {
        break label1163;
      }
      f = this.pitch;
      if (this.cKo == n) {
        break label1163;
      }
      j = (int)(this.sampleRate / f);
      i = this.sampleRate;
      while ((j > 16384) || (i > 16384))
      {
        j /= 2;
        i /= 2;
      }
      arrayOfShort1 = this.cKg;
      if (this.sampleRate > 4000)
      {
        i = this.sampleRate / 4000;
        label241:
        if ((this.cKa != 1) || (i != 1)) {
          break label400;
        }
        i = a(arrayOfShort1, k, this.cKb, this.cKc);
      }
    }
    for (;;)
    {
      label271:
      j = this.cKt;
      int m = this.cKu;
      if ((j == 0) || (this.cKr == 0))
      {
        j = 0;
        label295:
        if (j == 0) {
          break label561;
        }
        j = this.cKr;
        label304:
        this.cKs = this.cKt;
        this.cKr = i;
        if (f <= 1.0D) {
          break label586;
        }
        arrayOfShort1 = this.cKg;
        if (f < 2.0F) {
          break label566;
        }
        i = (int)(j / (f - 1.0F));
        label344:
        hn(i);
        a(i, this.cKa, this.cKi, this.cKo, arrayOfShort1, k, arrayOfShort1, k + j);
        this.cKo += i;
        i = k + (i + j);
        break;
        i = 1;
        break label241;
        label400:
        b(arrayOfShort1, k, i);
        j = a(this.cKe, 0, this.cKb / i, this.cKc / i);
        if (i == 1) {
          break label1178;
        }
        j *= i;
        m = j - i * 4;
        j += i * 4;
        if (m >= this.cKb) {
          break label1172;
        }
      }
      label1163:
      label1172:
      for (i = this.cKb;; i = m)
      {
        if (j > this.cKc) {
          j = this.cKc;
        }
        for (;;)
        {
          if (this.cKa == 1)
          {
            i = a(arrayOfShort1, k, i, j);
            break label271;
          }
          b(arrayOfShort1, k, 1);
          i = a(this.cKe, 0, i, j);
          break label271;
          if (m > j * 3)
          {
            j = 0;
            break label295;
          }
          if (j * 2 <= this.cKs * 3)
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
          this.cKq = ((int)(j * (2.0F - f) / (f - 1.0F)));
          i = j;
          break label344;
          label586:
          arrayOfShort1 = this.cKg;
          if (f < 0.5F) {}
          for (i = (int)(j * f / (1.0F - f));; i = j)
          {
            hn(j + i);
            System.arraycopy(arrayOfShort1, this.cKa * k, this.cKi, this.cKo * this.cKa, this.cKa * j);
            a(i, this.cKa, this.cKi, this.cKo + j, arrayOfShort1, k + j, arrayOfShort1, k);
            this.cKo += j + i;
            i = k + i;
            break;
            this.cKq = ((int)(j * (2.0F * f - 1.0F) / (1.0F - f)));
          }
          a(this.cKg, 0, this.cKn);
          this.cKn = 0;
          break label154;
          k = this.cKo - n;
          if (this.cKp + k > this.cKj)
          {
            this.cKj += this.cKj / 2 + k;
            this.cKk = Arrays.copyOf(this.cKk, this.cKj * this.cKa);
          }
          System.arraycopy(this.cKi, this.cKa * n, this.cKk, this.cKp * this.cKa, this.cKa * k);
          this.cKo = n;
          this.cKp = (k + this.cKp);
          k = 0;
          if (k < this.cKp - 1)
          {
            while ((this.cKl + 1) * j > this.cKm * i)
            {
              hn(1);
              m = 0;
              while (m < this.cKa)
              {
                arrayOfShort1 = this.cKi;
                n = this.cKo;
                i1 = this.cKa;
                short[] arrayOfShort2 = this.cKk;
                int i3 = this.cKa * k + m;
                int i2 = arrayOfShort2[i3];
                i3 = arrayOfShort2[(i3 + this.cKa)];
                int i6 = this.cKm;
                int i4 = this.cKl;
                int i5 = (this.cKl + 1) * j;
                i6 = i5 - i6 * i;
                i4 = i5 - i4 * j;
                arrayOfShort1[(n * i1 + m)] = ((short)((i3 * (i4 - i6) + i2 * i6) / i4));
                m += 1;
              }
              this.cKm += 1;
              this.cKo += 1;
            }
            this.cKl += 1;
            if (this.cKl == i)
            {
              this.cKl = 0;
              if (this.cKm != j) {
                break label1107;
              }
            }
            label1107:
            for (boolean bool = true;; bool = false)
            {
              a.checkState(bool);
              this.cKm = 0;
              k += 1;
              break;
            }
          }
          i = this.cKp - 1;
          if (i != 0)
          {
            System.arraycopy(this.cKk, this.cKa * i, this.cKk, 0, (this.cKp - i) * this.cKa);
            this.cKp -= i;
          }
          AppMethodBeat.o(91838);
          return;
        }
      }
      label1178:
      i = j;
    }
  }
  
  final void ho(int paramInt)
  {
    AppMethodBeat.i(91835);
    if (this.cKn + paramInt > this.cKf)
    {
      this.cKf += this.cKf / 2 + paramInt;
      this.cKg = Arrays.copyOf(this.cKg, this.cKf * this.cKa);
    }
    AppMethodBeat.o(91835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a.k
 * JD-Core Version:    0.7.0.1
 */