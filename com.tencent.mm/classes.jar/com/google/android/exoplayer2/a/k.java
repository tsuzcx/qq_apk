package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class k
{
  float bdN;
  final int bgE;
  private final int bgF;
  private final int bgG;
  final int bgH;
  private final short[] bgI;
  private int bgJ;
  short[] bgK;
  private int bgL;
  short[] bgM;
  private int bgN;
  private short[] bgO;
  private int bgP;
  private int bgQ;
  int bgR;
  int bgS;
  int bgT;
  int bgU;
  private int bgV;
  private int bgW;
  private int bgX;
  private int bgY;
  float pitch;
  private final int sampleRate;
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91833);
    this.sampleRate = paramInt1;
    this.bgE = paramInt2;
    this.bgF = (paramInt1 / 400);
    this.bgG = (paramInt1 / 65);
    this.bgH = (this.bgG * 2);
    this.bgI = new short[this.bgH];
    this.bgJ = this.bgH;
    this.bgK = new short[this.bgH * paramInt2];
    this.bgL = this.bgH;
    this.bgM = new short[this.bgH * paramInt2];
    this.bgN = this.bgH;
    this.bgO = new short[this.bgH * paramInt2];
    this.bgP = 0;
    this.bgQ = 0;
    this.bgV = 0;
    this.bdN = 1.0F;
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
    int i2 = paramInt1 * this.bgE;
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
      this.bgX = (m / k);
      this.bgY = (i / j);
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
    dI(paramInt2);
    System.arraycopy(paramArrayOfShort, this.bgE * paramInt1, this.bgM, this.bgS * this.bgE, this.bgE * paramInt2);
    this.bgS += paramInt2;
    AppMethodBeat.o(91836);
  }
  
  private void b(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int k = this.bgH / paramInt2;
    int m = this.bgE * paramInt2;
    int n = this.bgE;
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
      this.bgI[paramInt2] = ((short)i);
      paramInt2 += 1;
    }
  }
  
  private void dI(int paramInt)
  {
    AppMethodBeat.i(91834);
    if (this.bgS + paramInt > this.bgL)
    {
      this.bgL += this.bgL / 2 + paramInt;
      this.bgM = Arrays.copyOf(this.bgM, this.bgL * this.bgE);
    }
    AppMethodBeat.o(91834);
  }
  
  final void dJ(int paramInt)
  {
    AppMethodBeat.i(91835);
    if (this.bgR + paramInt > this.bgJ)
    {
      this.bgJ += this.bgJ / 2 + paramInt;
      this.bgK = Arrays.copyOf(this.bgK, this.bgJ * this.bgE);
    }
    AppMethodBeat.o(91835);
  }
  
  final void ub()
  {
    AppMethodBeat.i(91838);
    int n = this.bgS;
    float f = this.bdN / this.pitch;
    int i1;
    int k;
    int i;
    int j;
    label154:
    short[] arrayOfShort1;
    if ((f > 1.00001D) || (f < 0.9999900000000001D))
    {
      if (this.bgR >= this.bgH)
      {
        i1 = this.bgR;
        k = 0;
        do
        {
          if (this.bgU <= 0) {
            break;
          }
          i = Math.min(this.bgH, this.bgU);
          a(this.bgK, k, i);
          this.bgU -= i;
          i = k + i;
          k = i;
        } while (this.bgH + i <= i1);
        j = this.bgR - i;
        System.arraycopy(this.bgK, this.bgE * i, this.bgK, 0, this.bgE * j);
        this.bgR = j;
      }
      if (this.pitch == 1.0F) {
        break label1163;
      }
      f = this.pitch;
      if (this.bgS == n) {
        break label1163;
      }
      j = (int)(this.sampleRate / f);
      i = this.sampleRate;
      while ((j > 16384) || (i > 16384))
      {
        j /= 2;
        i /= 2;
      }
      arrayOfShort1 = this.bgK;
      if (this.sampleRate > 4000)
      {
        i = this.sampleRate / 4000;
        label241:
        if ((this.bgE != 1) || (i != 1)) {
          break label400;
        }
        i = a(arrayOfShort1, k, this.bgF, this.bgG);
      }
    }
    for (;;)
    {
      label271:
      j = this.bgX;
      int m = this.bgY;
      if ((j == 0) || (this.bgV == 0))
      {
        j = 0;
        label295:
        if (j == 0) {
          break label561;
        }
        j = this.bgV;
        label304:
        this.bgW = this.bgX;
        this.bgV = i;
        if (f <= 1.0D) {
          break label586;
        }
        arrayOfShort1 = this.bgK;
        if (f < 2.0F) {
          break label566;
        }
        i = (int)(j / (f - 1.0F));
        label344:
        dI(i);
        a(i, this.bgE, this.bgM, this.bgS, arrayOfShort1, k, arrayOfShort1, k + j);
        this.bgS += i;
        i = k + (i + j);
        break;
        i = 1;
        break label241;
        label400:
        b(arrayOfShort1, k, i);
        j = a(this.bgI, 0, this.bgF / i, this.bgG / i);
        if (i == 1) {
          break label1178;
        }
        j *= i;
        m = j - i * 4;
        j += i * 4;
        if (m >= this.bgF) {
          break label1172;
        }
      }
      label1163:
      label1172:
      for (i = this.bgF;; i = m)
      {
        if (j > this.bgG) {
          j = this.bgG;
        }
        for (;;)
        {
          if (this.bgE == 1)
          {
            i = a(arrayOfShort1, k, i, j);
            break label271;
          }
          b(arrayOfShort1, k, 1);
          i = a(this.bgI, 0, i, j);
          break label271;
          if (m > j * 3)
          {
            j = 0;
            break label295;
          }
          if (j * 2 <= this.bgW * 3)
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
          this.bgU = ((int)(j * (2.0F - f) / (f - 1.0F)));
          i = j;
          break label344;
          label586:
          arrayOfShort1 = this.bgK;
          if (f < 0.5F) {}
          for (i = (int)(j * f / (1.0F - f));; i = j)
          {
            dI(j + i);
            System.arraycopy(arrayOfShort1, this.bgE * k, this.bgM, this.bgS * this.bgE, this.bgE * j);
            a(i, this.bgE, this.bgM, this.bgS + j, arrayOfShort1, k + j, arrayOfShort1, k);
            this.bgS += j + i;
            i = k + i;
            break;
            this.bgU = ((int)(j * (2.0F * f - 1.0F) / (1.0F - f)));
          }
          a(this.bgK, 0, this.bgR);
          this.bgR = 0;
          break label154;
          k = this.bgS - n;
          if (this.bgT + k > this.bgN)
          {
            this.bgN += this.bgN / 2 + k;
            this.bgO = Arrays.copyOf(this.bgO, this.bgN * this.bgE);
          }
          System.arraycopy(this.bgM, this.bgE * n, this.bgO, this.bgT * this.bgE, this.bgE * k);
          this.bgS = n;
          this.bgT = (k + this.bgT);
          k = 0;
          if (k < this.bgT - 1)
          {
            while ((this.bgP + 1) * j > this.bgQ * i)
            {
              dI(1);
              m = 0;
              while (m < this.bgE)
              {
                arrayOfShort1 = this.bgM;
                n = this.bgS;
                i1 = this.bgE;
                short[] arrayOfShort2 = this.bgO;
                int i3 = this.bgE * k + m;
                int i2 = arrayOfShort2[i3];
                i3 = arrayOfShort2[(i3 + this.bgE)];
                int i6 = this.bgQ;
                int i4 = this.bgP;
                int i5 = (this.bgP + 1) * j;
                i6 = i5 - i6 * i;
                i4 = i5 - i4 * j;
                arrayOfShort1[(n * i1 + m)] = ((short)((i3 * (i4 - i6) + i2 * i6) / i4));
                m += 1;
              }
              this.bgQ += 1;
              this.bgS += 1;
            }
            this.bgP += 1;
            if (this.bgP == i)
            {
              this.bgP = 0;
              if (this.bgQ != j) {
                break label1107;
              }
            }
            label1107:
            for (boolean bool = true;; bool = false)
            {
              a.checkState(bool);
              this.bgQ = 0;
              k += 1;
              break;
            }
          }
          i = this.bgT - 1;
          if (i != 0)
          {
            System.arraycopy(this.bgO, this.bgE * i, this.bgO, 0, (this.bgT - i) * this.bgE);
            this.bgT -= i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.a.k
 * JD-Core Version:    0.7.0.1
 */