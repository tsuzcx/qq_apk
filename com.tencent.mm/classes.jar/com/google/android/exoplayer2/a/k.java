package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class k
{
  float aNo;
  final int aQe;
  private final int aQf;
  private final int aQg;
  final int aQh;
  private final short[] aQi;
  private int aQj;
  short[] aQk;
  private int aQl;
  short[] aQm;
  private int aQn;
  private short[] aQo;
  private int aQp;
  private int aQq;
  int aQr;
  int aQs;
  int aQt;
  int aQu;
  private int aQv;
  private int aQw;
  private int aQx;
  private int aQy;
  float pitch;
  private final int sampleRate;
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91833);
    this.sampleRate = paramInt1;
    this.aQe = paramInt2;
    this.aQf = (paramInt1 / 400);
    this.aQg = (paramInt1 / 65);
    this.aQh = (this.aQg * 2);
    this.aQi = new short[this.aQh];
    this.aQj = this.aQh;
    this.aQk = new short[this.aQh * paramInt2];
    this.aQl = this.aQh;
    this.aQm = new short[this.aQh * paramInt2];
    this.aQn = this.aQh;
    this.aQo = new short[this.aQh * paramInt2];
    this.aQp = 0;
    this.aQq = 0;
    this.aQv = 0;
    this.aNo = 1.0F;
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
    int i2 = paramInt1 * this.aQe;
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
      this.aQx = (m / k);
      this.aQy = (i / j);
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
    dW(paramInt2);
    System.arraycopy(paramArrayOfShort, this.aQe * paramInt1, this.aQm, this.aQs * this.aQe, this.aQe * paramInt2);
    this.aQs += paramInt2;
    AppMethodBeat.o(91836);
  }
  
  private void b(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int k = this.aQh / paramInt2;
    int m = this.aQe * paramInt2;
    int n = this.aQe;
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
      this.aQi[paramInt2] = ((short)i);
      paramInt2 += 1;
    }
  }
  
  private void dW(int paramInt)
  {
    AppMethodBeat.i(91834);
    if (this.aQs + paramInt > this.aQl)
    {
      this.aQl += this.aQl / 2 + paramInt;
      this.aQm = Arrays.copyOf(this.aQm, this.aQl * this.aQe);
    }
    AppMethodBeat.o(91834);
  }
  
  final void dX(int paramInt)
  {
    AppMethodBeat.i(91835);
    if (this.aQr + paramInt > this.aQj)
    {
      this.aQj += this.aQj / 2 + paramInt;
      this.aQk = Arrays.copyOf(this.aQk, this.aQj * this.aQe);
    }
    AppMethodBeat.o(91835);
  }
  
  final void rT()
  {
    AppMethodBeat.i(91838);
    int n = this.aQs;
    float f = this.aNo / this.pitch;
    int i1;
    int k;
    int i;
    int j;
    label154:
    short[] arrayOfShort1;
    if ((f > 1.00001D) || (f < 0.9999900000000001D))
    {
      if (this.aQr >= this.aQh)
      {
        i1 = this.aQr;
        k = 0;
        do
        {
          if (this.aQu <= 0) {
            break;
          }
          i = Math.min(this.aQh, this.aQu);
          a(this.aQk, k, i);
          this.aQu -= i;
          i = k + i;
          k = i;
        } while (this.aQh + i <= i1);
        j = this.aQr - i;
        System.arraycopy(this.aQk, this.aQe * i, this.aQk, 0, this.aQe * j);
        this.aQr = j;
      }
      if (this.pitch == 1.0F) {
        break label1163;
      }
      f = this.pitch;
      if (this.aQs == n) {
        break label1163;
      }
      j = (int)(this.sampleRate / f);
      i = this.sampleRate;
      while ((j > 16384) || (i > 16384))
      {
        j /= 2;
        i /= 2;
      }
      arrayOfShort1 = this.aQk;
      if (this.sampleRate > 4000)
      {
        i = this.sampleRate / 4000;
        label241:
        if ((this.aQe != 1) || (i != 1)) {
          break label400;
        }
        i = a(arrayOfShort1, k, this.aQf, this.aQg);
      }
    }
    for (;;)
    {
      label271:
      j = this.aQx;
      int m = this.aQy;
      if ((j == 0) || (this.aQv == 0))
      {
        j = 0;
        label295:
        if (j == 0) {
          break label561;
        }
        j = this.aQv;
        label304:
        this.aQw = this.aQx;
        this.aQv = i;
        if (f <= 1.0D) {
          break label586;
        }
        arrayOfShort1 = this.aQk;
        if (f < 2.0F) {
          break label566;
        }
        i = (int)(j / (f - 1.0F));
        label344:
        dW(i);
        a(i, this.aQe, this.aQm, this.aQs, arrayOfShort1, k, arrayOfShort1, k + j);
        this.aQs += i;
        i = k + (i + j);
        break;
        i = 1;
        break label241;
        label400:
        b(arrayOfShort1, k, i);
        j = a(this.aQi, 0, this.aQf / i, this.aQg / i);
        if (i == 1) {
          break label1178;
        }
        j *= i;
        m = j - i * 4;
        j += i * 4;
        if (m >= this.aQf) {
          break label1172;
        }
      }
      label1163:
      label1172:
      for (i = this.aQf;; i = m)
      {
        if (j > this.aQg) {
          j = this.aQg;
        }
        for (;;)
        {
          if (this.aQe == 1)
          {
            i = a(arrayOfShort1, k, i, j);
            break label271;
          }
          b(arrayOfShort1, k, 1);
          i = a(this.aQi, 0, i, j);
          break label271;
          if (m > j * 3)
          {
            j = 0;
            break label295;
          }
          if (j * 2 <= this.aQw * 3)
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
          this.aQu = ((int)(j * (2.0F - f) / (f - 1.0F)));
          i = j;
          break label344;
          label586:
          arrayOfShort1 = this.aQk;
          if (f < 0.5F) {}
          for (i = (int)(j * f / (1.0F - f));; i = j)
          {
            dW(j + i);
            System.arraycopy(arrayOfShort1, this.aQe * k, this.aQm, this.aQs * this.aQe, this.aQe * j);
            a(i, this.aQe, this.aQm, this.aQs + j, arrayOfShort1, k + j, arrayOfShort1, k);
            this.aQs += j + i;
            i = k + i;
            break;
            this.aQu = ((int)(j * (2.0F * f - 1.0F) / (1.0F - f)));
          }
          a(this.aQk, 0, this.aQr);
          this.aQr = 0;
          break label154;
          k = this.aQs - n;
          if (this.aQt + k > this.aQn)
          {
            this.aQn += this.aQn / 2 + k;
            this.aQo = Arrays.copyOf(this.aQo, this.aQn * this.aQe);
          }
          System.arraycopy(this.aQm, this.aQe * n, this.aQo, this.aQt * this.aQe, this.aQe * k);
          this.aQs = n;
          this.aQt = (k + this.aQt);
          k = 0;
          if (k < this.aQt - 1)
          {
            while ((this.aQp + 1) * j > this.aQq * i)
            {
              dW(1);
              m = 0;
              while (m < this.aQe)
              {
                arrayOfShort1 = this.aQm;
                n = this.aQs;
                i1 = this.aQe;
                short[] arrayOfShort2 = this.aQo;
                int i3 = this.aQe * k + m;
                int i2 = arrayOfShort2[i3];
                i3 = arrayOfShort2[(i3 + this.aQe)];
                int i6 = this.aQq;
                int i4 = this.aQp;
                int i5 = (this.aQp + 1) * j;
                i6 = i5 - i6 * i;
                i4 = i5 - i4 * j;
                arrayOfShort1[(n * i1 + m)] = ((short)((i3 * (i4 - i6) + i2 * i6) / i4));
                m += 1;
              }
              this.aQq += 1;
              this.aQs += 1;
            }
            this.aQp += 1;
            if (this.aQp == i)
            {
              this.aQp = 0;
              if (this.aQq != j) {
                break label1107;
              }
            }
            label1107:
            for (boolean bool = true;; bool = false)
            {
              a.checkState(bool);
              this.aQq = 0;
              k += 1;
              break;
            }
          }
          i = this.aQt - 1;
          if (i != 0)
          {
            System.arraycopy(this.aQo, this.aQe * i, this.aQo, 0, (this.aQt - i) * this.aQe);
            this.aQt -= i;
          }
          AppMethodBeat.o(91838);
          return;
        }
      }
      label1178:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a.k
 * JD-Core Version:    0.7.0.1
 */