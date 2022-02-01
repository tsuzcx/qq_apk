package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class k
{
  float bdQ;
  final int bgH;
  private final int bgI;
  private final int bgJ;
  final int bgK;
  private final short[] bgL;
  private int bgM;
  short[] bgN;
  private int bgO;
  short[] bgP;
  private int bgQ;
  private short[] bgR;
  private int bgS;
  private int bgT;
  int bgU;
  int bgV;
  int bgW;
  int bgX;
  private int bgY;
  private int bgZ;
  private int bha;
  private int bhb;
  float pitch;
  private final int sampleRate;
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91833);
    this.sampleRate = paramInt1;
    this.bgH = paramInt2;
    this.bgI = (paramInt1 / 400);
    this.bgJ = (paramInt1 / 65);
    this.bgK = (this.bgJ * 2);
    this.bgL = new short[this.bgK];
    this.bgM = this.bgK;
    this.bgN = new short[this.bgK * paramInt2];
    this.bgO = this.bgK;
    this.bgP = new short[this.bgK * paramInt2];
    this.bgQ = this.bgK;
    this.bgR = new short[this.bgK * paramInt2];
    this.bgS = 0;
    this.bgT = 0;
    this.bgY = 0;
    this.bdQ = 1.0F;
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
    int i2 = paramInt1 * this.bgH;
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
      this.bha = (m / k);
      this.bhb = (i / j);
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
    dN(paramInt2);
    System.arraycopy(paramArrayOfShort, this.bgH * paramInt1, this.bgP, this.bgV * this.bgH, this.bgH * paramInt2);
    this.bgV += paramInt2;
    AppMethodBeat.o(91836);
  }
  
  private void b(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int k = this.bgK / paramInt2;
    int m = this.bgH * paramInt2;
    int n = this.bgH;
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
      this.bgL[paramInt2] = ((short)i);
      paramInt2 += 1;
    }
  }
  
  private void dN(int paramInt)
  {
    AppMethodBeat.i(91834);
    if (this.bgV + paramInt > this.bgO)
    {
      this.bgO += this.bgO / 2 + paramInt;
      this.bgP = Arrays.copyOf(this.bgP, this.bgO * this.bgH);
    }
    AppMethodBeat.o(91834);
  }
  
  final void dO(int paramInt)
  {
    AppMethodBeat.i(91835);
    if (this.bgU + paramInt > this.bgM)
    {
      this.bgM += this.bgM / 2 + paramInt;
      this.bgN = Arrays.copyOf(this.bgN, this.bgM * this.bgH);
    }
    AppMethodBeat.o(91835);
  }
  
  final void tW()
  {
    AppMethodBeat.i(91838);
    int n = this.bgV;
    float f = this.bdQ / this.pitch;
    int i1;
    int k;
    int i;
    int j;
    label154:
    short[] arrayOfShort1;
    if ((f > 1.00001D) || (f < 0.9999900000000001D))
    {
      if (this.bgU >= this.bgK)
      {
        i1 = this.bgU;
        k = 0;
        do
        {
          if (this.bgX <= 0) {
            break;
          }
          i = Math.min(this.bgK, this.bgX);
          a(this.bgN, k, i);
          this.bgX -= i;
          i = k + i;
          k = i;
        } while (this.bgK + i <= i1);
        j = this.bgU - i;
        System.arraycopy(this.bgN, this.bgH * i, this.bgN, 0, this.bgH * j);
        this.bgU = j;
      }
      if (this.pitch == 1.0F) {
        break label1163;
      }
      f = this.pitch;
      if (this.bgV == n) {
        break label1163;
      }
      j = (int)(this.sampleRate / f);
      i = this.sampleRate;
      while ((j > 16384) || (i > 16384))
      {
        j /= 2;
        i /= 2;
      }
      arrayOfShort1 = this.bgN;
      if (this.sampleRate > 4000)
      {
        i = this.sampleRate / 4000;
        label241:
        if ((this.bgH != 1) || (i != 1)) {
          break label400;
        }
        i = a(arrayOfShort1, k, this.bgI, this.bgJ);
      }
    }
    for (;;)
    {
      label271:
      j = this.bha;
      int m = this.bhb;
      if ((j == 0) || (this.bgY == 0))
      {
        j = 0;
        label295:
        if (j == 0) {
          break label561;
        }
        j = this.bgY;
        label304:
        this.bgZ = this.bha;
        this.bgY = i;
        if (f <= 1.0D) {
          break label586;
        }
        arrayOfShort1 = this.bgN;
        if (f < 2.0F) {
          break label566;
        }
        i = (int)(j / (f - 1.0F));
        label344:
        dN(i);
        a(i, this.bgH, this.bgP, this.bgV, arrayOfShort1, k, arrayOfShort1, k + j);
        this.bgV += i;
        i = k + (i + j);
        break;
        i = 1;
        break label241;
        label400:
        b(arrayOfShort1, k, i);
        j = a(this.bgL, 0, this.bgI / i, this.bgJ / i);
        if (i == 1) {
          break label1178;
        }
        j *= i;
        m = j - i * 4;
        j += i * 4;
        if (m >= this.bgI) {
          break label1172;
        }
      }
      label1163:
      label1172:
      for (i = this.bgI;; i = m)
      {
        if (j > this.bgJ) {
          j = this.bgJ;
        }
        for (;;)
        {
          if (this.bgH == 1)
          {
            i = a(arrayOfShort1, k, i, j);
            break label271;
          }
          b(arrayOfShort1, k, 1);
          i = a(this.bgL, 0, i, j);
          break label271;
          if (m > j * 3)
          {
            j = 0;
            break label295;
          }
          if (j * 2 <= this.bgZ * 3)
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
          this.bgX = ((int)(j * (2.0F - f) / (f - 1.0F)));
          i = j;
          break label344;
          label586:
          arrayOfShort1 = this.bgN;
          if (f < 0.5F) {}
          for (i = (int)(j * f / (1.0F - f));; i = j)
          {
            dN(j + i);
            System.arraycopy(arrayOfShort1, this.bgH * k, this.bgP, this.bgV * this.bgH, this.bgH * j);
            a(i, this.bgH, this.bgP, this.bgV + j, arrayOfShort1, k + j, arrayOfShort1, k);
            this.bgV += j + i;
            i = k + i;
            break;
            this.bgX = ((int)(j * (2.0F * f - 1.0F) / (1.0F - f)));
          }
          a(this.bgN, 0, this.bgU);
          this.bgU = 0;
          break label154;
          k = this.bgV - n;
          if (this.bgW + k > this.bgQ)
          {
            this.bgQ += this.bgQ / 2 + k;
            this.bgR = Arrays.copyOf(this.bgR, this.bgQ * this.bgH);
          }
          System.arraycopy(this.bgP, this.bgH * n, this.bgR, this.bgW * this.bgH, this.bgH * k);
          this.bgV = n;
          this.bgW = (k + this.bgW);
          k = 0;
          if (k < this.bgW - 1)
          {
            while ((this.bgS + 1) * j > this.bgT * i)
            {
              dN(1);
              m = 0;
              while (m < this.bgH)
              {
                arrayOfShort1 = this.bgP;
                n = this.bgV;
                i1 = this.bgH;
                short[] arrayOfShort2 = this.bgR;
                int i3 = this.bgH * k + m;
                int i2 = arrayOfShort2[i3];
                i3 = arrayOfShort2[(i3 + this.bgH)];
                int i6 = this.bgT;
                int i4 = this.bgS;
                int i5 = (this.bgS + 1) * j;
                i6 = i5 - i6 * i;
                i4 = i5 - i4 * j;
                arrayOfShort1[(n * i1 + m)] = ((short)((i3 * (i4 - i6) + i2 * i6) / i4));
                m += 1;
              }
              this.bgT += 1;
              this.bgV += 1;
            }
            this.bgS += 1;
            if (this.bgS == i)
            {
              this.bgS = 0;
              if (this.bgT != j) {
                break label1107;
              }
            }
            label1107:
            for (boolean bool = true;; bool = false)
            {
              a.checkState(bool);
              this.bgT = 0;
              k += 1;
              break;
            }
          }
          i = this.bgW - 1;
          if (i != 0)
          {
            System.arraycopy(this.bgR, this.bgH * i, this.bgR, 0, (this.bgW - i) * this.bgH);
            this.bgW -= i;
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