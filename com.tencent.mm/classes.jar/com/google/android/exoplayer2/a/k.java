package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class k
{
  float aSD;
  private final int aVA;
  private final int aVB;
  final int aVC;
  private final short[] aVD;
  private int aVE;
  short[] aVF;
  private int aVG;
  short[] aVH;
  private int aVI;
  private short[] aVJ;
  private int aVK;
  private int aVL;
  int aVM;
  int aVN;
  int aVO;
  int aVP;
  private int aVQ;
  private int aVR;
  private int aVS;
  private int aVT;
  final int aVz;
  float pitch;
  private final int sampleRate;
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91833);
    this.sampleRate = paramInt1;
    this.aVz = paramInt2;
    this.aVA = (paramInt1 / 400);
    this.aVB = (paramInt1 / 65);
    this.aVC = (this.aVB * 2);
    this.aVD = new short[this.aVC];
    this.aVE = this.aVC;
    this.aVF = new short[this.aVC * paramInt2];
    this.aVG = this.aVC;
    this.aVH = new short[this.aVC * paramInt2];
    this.aVI = this.aVC;
    this.aVJ = new short[this.aVC * paramInt2];
    this.aVK = 0;
    this.aVL = 0;
    this.aVQ = 0;
    this.aSD = 1.0F;
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
    int i2 = paramInt1 * this.aVz;
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
      this.aVS = (m / k);
      this.aVT = (i / j);
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
    dK(paramInt2);
    System.arraycopy(paramArrayOfShort, this.aVz * paramInt1, this.aVH, this.aVN * this.aVz, this.aVz * paramInt2);
    this.aVN += paramInt2;
    AppMethodBeat.o(91836);
  }
  
  private void b(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int k = this.aVC / paramInt2;
    int m = this.aVz * paramInt2;
    int n = this.aVz;
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
      this.aVD[paramInt2] = ((short)i);
      paramInt2 += 1;
    }
  }
  
  private void dK(int paramInt)
  {
    AppMethodBeat.i(91834);
    if (this.aVN + paramInt > this.aVG)
    {
      this.aVG += this.aVG / 2 + paramInt;
      this.aVH = Arrays.copyOf(this.aVH, this.aVG * this.aVz);
    }
    AppMethodBeat.o(91834);
  }
  
  final void dL(int paramInt)
  {
    AppMethodBeat.i(91835);
    if (this.aVM + paramInt > this.aVE)
    {
      this.aVE += this.aVE / 2 + paramInt;
      this.aVF = Arrays.copyOf(this.aVF, this.aVE * this.aVz);
    }
    AppMethodBeat.o(91835);
  }
  
  final void so()
  {
    AppMethodBeat.i(91838);
    int n = this.aVN;
    float f = this.aSD / this.pitch;
    int i1;
    int k;
    int i;
    int j;
    label154:
    short[] arrayOfShort1;
    if ((f > 1.00001D) || (f < 0.9999900000000001D))
    {
      if (this.aVM >= this.aVC)
      {
        i1 = this.aVM;
        k = 0;
        do
        {
          if (this.aVP <= 0) {
            break;
          }
          i = Math.min(this.aVC, this.aVP);
          a(this.aVF, k, i);
          this.aVP -= i;
          i = k + i;
          k = i;
        } while (this.aVC + i <= i1);
        j = this.aVM - i;
        System.arraycopy(this.aVF, this.aVz * i, this.aVF, 0, this.aVz * j);
        this.aVM = j;
      }
      if (this.pitch == 1.0F) {
        break label1163;
      }
      f = this.pitch;
      if (this.aVN == n) {
        break label1163;
      }
      j = (int)(this.sampleRate / f);
      i = this.sampleRate;
      while ((j > 16384) || (i > 16384))
      {
        j /= 2;
        i /= 2;
      }
      arrayOfShort1 = this.aVF;
      if (this.sampleRate > 4000)
      {
        i = this.sampleRate / 4000;
        label241:
        if ((this.aVz != 1) || (i != 1)) {
          break label400;
        }
        i = a(arrayOfShort1, k, this.aVA, this.aVB);
      }
    }
    for (;;)
    {
      label271:
      j = this.aVS;
      int m = this.aVT;
      if ((j == 0) || (this.aVQ == 0))
      {
        j = 0;
        label295:
        if (j == 0) {
          break label561;
        }
        j = this.aVQ;
        label304:
        this.aVR = this.aVS;
        this.aVQ = i;
        if (f <= 1.0D) {
          break label586;
        }
        arrayOfShort1 = this.aVF;
        if (f < 2.0F) {
          break label566;
        }
        i = (int)(j / (f - 1.0F));
        label344:
        dK(i);
        a(i, this.aVz, this.aVH, this.aVN, arrayOfShort1, k, arrayOfShort1, k + j);
        this.aVN += i;
        i = k + (i + j);
        break;
        i = 1;
        break label241;
        label400:
        b(arrayOfShort1, k, i);
        j = a(this.aVD, 0, this.aVA / i, this.aVB / i);
        if (i == 1) {
          break label1178;
        }
        j *= i;
        m = j - i * 4;
        j += i * 4;
        if (m >= this.aVA) {
          break label1172;
        }
      }
      label1163:
      label1172:
      for (i = this.aVA;; i = m)
      {
        if (j > this.aVB) {
          j = this.aVB;
        }
        for (;;)
        {
          if (this.aVz == 1)
          {
            i = a(arrayOfShort1, k, i, j);
            break label271;
          }
          b(arrayOfShort1, k, 1);
          i = a(this.aVD, 0, i, j);
          break label271;
          if (m > j * 3)
          {
            j = 0;
            break label295;
          }
          if (j * 2 <= this.aVR * 3)
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
          this.aVP = ((int)(j * (2.0F - f) / (f - 1.0F)));
          i = j;
          break label344;
          label586:
          arrayOfShort1 = this.aVF;
          if (f < 0.5F) {}
          for (i = (int)(j * f / (1.0F - f));; i = j)
          {
            dK(j + i);
            System.arraycopy(arrayOfShort1, this.aVz * k, this.aVH, this.aVN * this.aVz, this.aVz * j);
            a(i, this.aVz, this.aVH, this.aVN + j, arrayOfShort1, k + j, arrayOfShort1, k);
            this.aVN += j + i;
            i = k + i;
            break;
            this.aVP = ((int)(j * (2.0F * f - 1.0F) / (1.0F - f)));
          }
          a(this.aVF, 0, this.aVM);
          this.aVM = 0;
          break label154;
          k = this.aVN - n;
          if (this.aVO + k > this.aVI)
          {
            this.aVI += this.aVI / 2 + k;
            this.aVJ = Arrays.copyOf(this.aVJ, this.aVI * this.aVz);
          }
          System.arraycopy(this.aVH, this.aVz * n, this.aVJ, this.aVO * this.aVz, this.aVz * k);
          this.aVN = n;
          this.aVO = (k + this.aVO);
          k = 0;
          if (k < this.aVO - 1)
          {
            while ((this.aVK + 1) * j > this.aVL * i)
            {
              dK(1);
              m = 0;
              while (m < this.aVz)
              {
                arrayOfShort1 = this.aVH;
                n = this.aVN;
                i1 = this.aVz;
                short[] arrayOfShort2 = this.aVJ;
                int i3 = this.aVz * k + m;
                int i2 = arrayOfShort2[i3];
                i3 = arrayOfShort2[(i3 + this.aVz)];
                int i6 = this.aVL;
                int i4 = this.aVK;
                int i5 = (this.aVK + 1) * j;
                i6 = i5 - i6 * i;
                i4 = i5 - i4 * j;
                arrayOfShort1[(n * i1 + m)] = ((short)((i3 * (i4 - i6) + i2 * i6) / i4));
                m += 1;
              }
              this.aVL += 1;
              this.aVN += 1;
            }
            this.aVK += 1;
            if (this.aVK == i)
            {
              this.aVK = 0;
              if (this.aVL != j) {
                break label1107;
              }
            }
            label1107:
            for (boolean bool = true;; bool = false)
            {
              a.checkState(bool);
              this.aVL = 0;
              k += 1;
              break;
            }
          }
          i = this.aVO - 1;
          if (i != 0)
          {
            System.arraycopy(this.aVJ, this.aVz * i, this.aVJ, 0, (this.aVO - i) * this.aVz);
            this.aVO -= i;
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