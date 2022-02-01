package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class k
{
  float aTw;
  int aWA;
  int aWB;
  int aWC;
  private int aWD;
  private int aWE;
  private int aWF;
  private int aWG;
  final int aWm;
  private final int aWn;
  private final int aWo;
  final int aWp;
  private final short[] aWq;
  private int aWr;
  short[] aWs;
  private int aWt;
  short[] aWu;
  private int aWv;
  private short[] aWw;
  private int aWx;
  private int aWy;
  int aWz;
  float pitch;
  private final int sampleRate;
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91833);
    this.sampleRate = paramInt1;
    this.aWm = paramInt2;
    this.aWn = (paramInt1 / 400);
    this.aWo = (paramInt1 / 65);
    this.aWp = (this.aWo * 2);
    this.aWq = new short[this.aWp];
    this.aWr = this.aWp;
    this.aWs = new short[this.aWp * paramInt2];
    this.aWt = this.aWp;
    this.aWu = new short[this.aWp * paramInt2];
    this.aWv = this.aWp;
    this.aWw = new short[this.aWp * paramInt2];
    this.aWx = 0;
    this.aWy = 0;
    this.aWD = 0;
    this.aTw = 1.0F;
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
    int i2 = paramInt1 * this.aWm;
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
      this.aWF = (m / k);
      this.aWG = (i / j);
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
    dJ(paramInt2);
    System.arraycopy(paramArrayOfShort, this.aWm * paramInt1, this.aWu, this.aWA * this.aWm, this.aWm * paramInt2);
    this.aWA += paramInt2;
    AppMethodBeat.o(91836);
  }
  
  private void b(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int k = this.aWp / paramInt2;
    int m = this.aWm * paramInt2;
    int n = this.aWm;
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
      this.aWq[paramInt2] = ((short)i);
      paramInt2 += 1;
    }
  }
  
  private void dJ(int paramInt)
  {
    AppMethodBeat.i(91834);
    if (this.aWA + paramInt > this.aWt)
    {
      this.aWt += this.aWt / 2 + paramInt;
      this.aWu = Arrays.copyOf(this.aWu, this.aWt * this.aWm);
    }
    AppMethodBeat.o(91834);
  }
  
  final void dK(int paramInt)
  {
    AppMethodBeat.i(91835);
    if (this.aWz + paramInt > this.aWr)
    {
      this.aWr += this.aWr / 2 + paramInt;
      this.aWs = Arrays.copyOf(this.aWs, this.aWr * this.aWm);
    }
    AppMethodBeat.o(91835);
  }
  
  final void sx()
  {
    AppMethodBeat.i(91838);
    int n = this.aWA;
    float f = this.aTw / this.pitch;
    int i1;
    int k;
    int i;
    int j;
    label154:
    short[] arrayOfShort1;
    if ((f > 1.00001D) || (f < 0.9999900000000001D))
    {
      if (this.aWz >= this.aWp)
      {
        i1 = this.aWz;
        k = 0;
        do
        {
          if (this.aWC <= 0) {
            break;
          }
          i = Math.min(this.aWp, this.aWC);
          a(this.aWs, k, i);
          this.aWC -= i;
          i = k + i;
          k = i;
        } while (this.aWp + i <= i1);
        j = this.aWz - i;
        System.arraycopy(this.aWs, this.aWm * i, this.aWs, 0, this.aWm * j);
        this.aWz = j;
      }
      if (this.pitch == 1.0F) {
        break label1163;
      }
      f = this.pitch;
      if (this.aWA == n) {
        break label1163;
      }
      j = (int)(this.sampleRate / f);
      i = this.sampleRate;
      while ((j > 16384) || (i > 16384))
      {
        j /= 2;
        i /= 2;
      }
      arrayOfShort1 = this.aWs;
      if (this.sampleRate > 4000)
      {
        i = this.sampleRate / 4000;
        label241:
        if ((this.aWm != 1) || (i != 1)) {
          break label400;
        }
        i = a(arrayOfShort1, k, this.aWn, this.aWo);
      }
    }
    for (;;)
    {
      label271:
      j = this.aWF;
      int m = this.aWG;
      if ((j == 0) || (this.aWD == 0))
      {
        j = 0;
        label295:
        if (j == 0) {
          break label561;
        }
        j = this.aWD;
        label304:
        this.aWE = this.aWF;
        this.aWD = i;
        if (f <= 1.0D) {
          break label586;
        }
        arrayOfShort1 = this.aWs;
        if (f < 2.0F) {
          break label566;
        }
        i = (int)(j / (f - 1.0F));
        label344:
        dJ(i);
        a(i, this.aWm, this.aWu, this.aWA, arrayOfShort1, k, arrayOfShort1, k + j);
        this.aWA += i;
        i = k + (i + j);
        break;
        i = 1;
        break label241;
        label400:
        b(arrayOfShort1, k, i);
        j = a(this.aWq, 0, this.aWn / i, this.aWo / i);
        if (i == 1) {
          break label1178;
        }
        j *= i;
        m = j - i * 4;
        j += i * 4;
        if (m >= this.aWn) {
          break label1172;
        }
      }
      label1163:
      label1172:
      for (i = this.aWn;; i = m)
      {
        if (j > this.aWo) {
          j = this.aWo;
        }
        for (;;)
        {
          if (this.aWm == 1)
          {
            i = a(arrayOfShort1, k, i, j);
            break label271;
          }
          b(arrayOfShort1, k, 1);
          i = a(this.aWq, 0, i, j);
          break label271;
          if (m > j * 3)
          {
            j = 0;
            break label295;
          }
          if (j * 2 <= this.aWE * 3)
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
          this.aWC = ((int)(j * (2.0F - f) / (f - 1.0F)));
          i = j;
          break label344;
          label586:
          arrayOfShort1 = this.aWs;
          if (f < 0.5F) {}
          for (i = (int)(j * f / (1.0F - f));; i = j)
          {
            dJ(j + i);
            System.arraycopy(arrayOfShort1, this.aWm * k, this.aWu, this.aWA * this.aWm, this.aWm * j);
            a(i, this.aWm, this.aWu, this.aWA + j, arrayOfShort1, k + j, arrayOfShort1, k);
            this.aWA += j + i;
            i = k + i;
            break;
            this.aWC = ((int)(j * (2.0F * f - 1.0F) / (1.0F - f)));
          }
          a(this.aWs, 0, this.aWz);
          this.aWz = 0;
          break label154;
          k = this.aWA - n;
          if (this.aWB + k > this.aWv)
          {
            this.aWv += this.aWv / 2 + k;
            this.aWw = Arrays.copyOf(this.aWw, this.aWv * this.aWm);
          }
          System.arraycopy(this.aWu, this.aWm * n, this.aWw, this.aWB * this.aWm, this.aWm * k);
          this.aWA = n;
          this.aWB = (k + this.aWB);
          k = 0;
          if (k < this.aWB - 1)
          {
            while ((this.aWx + 1) * j > this.aWy * i)
            {
              dJ(1);
              m = 0;
              while (m < this.aWm)
              {
                arrayOfShort1 = this.aWu;
                n = this.aWA;
                i1 = this.aWm;
                short[] arrayOfShort2 = this.aWw;
                int i3 = this.aWm * k + m;
                int i2 = arrayOfShort2[i3];
                i3 = arrayOfShort2[(i3 + this.aWm)];
                int i6 = this.aWy;
                int i4 = this.aWx;
                int i5 = (this.aWx + 1) * j;
                i6 = i5 - i6 * i;
                i4 = i5 - i4 * j;
                arrayOfShort1[(n * i1 + m)] = ((short)((i3 * (i4 - i6) + i2 * i6) / i4));
                m += 1;
              }
              this.aWy += 1;
              this.aWA += 1;
            }
            this.aWx += 1;
            if (this.aWx == i)
            {
              this.aWx = 0;
              if (this.aWy != j) {
                break label1107;
              }
            }
            label1107:
            for (boolean bool = true;; bool = false)
            {
              a.checkState(bool);
              this.aWy = 0;
              k += 1;
              break;
            }
          }
          i = this.aWB - 1;
          if (i != 0)
          {
            System.arraycopy(this.aWw, this.aWm * i, this.aWw, 0, (this.aWB - i) * this.aWm);
            this.aWB -= i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.k
 * JD-Core Version:    0.7.0.1
 */