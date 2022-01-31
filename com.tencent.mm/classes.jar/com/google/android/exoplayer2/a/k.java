package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.i.a;
import java.util.Arrays;

final class k
{
  float auT;
  final int axR;
  private final int axS;
  private final int axT;
  final int axU;
  private final short[] axV;
  private int axW;
  short[] axX;
  private int axY;
  short[] axZ;
  private int aya;
  private short[] ayb;
  private int ayc;
  private int ayd;
  int aye;
  int ayf;
  int ayg;
  int ayh;
  private int ayi;
  private int ayj;
  private int ayk;
  private int ayl;
  float pitch;
  private final int sampleRate;
  
  public k(int paramInt1, int paramInt2)
  {
    this.sampleRate = paramInt1;
    this.axR = paramInt2;
    this.axS = (paramInt1 / 400);
    this.axT = (paramInt1 / 65);
    this.axU = (this.axT * 2);
    this.axV = new short[this.axU];
    this.axW = this.axU;
    this.axX = new short[this.axU * paramInt2];
    this.axY = this.axU;
    this.axZ = new short[this.axU * paramInt2];
    this.aya = this.axU;
    this.ayb = new short[this.axU * paramInt2];
    this.ayc = 0;
    this.ayd = 0;
    this.ayi = 0;
    this.auT = 1.0F;
    this.pitch = 1.0F;
  }
  
  private int a(short[] paramArrayOfShort, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 255;
    int m = 1;
    int i2 = paramInt1 * this.axR;
    int i = 0;
    int k = 0;
    paramInt1 = paramInt2;
    int n;
    int i1;
    if (paramInt1 <= paramInt3)
    {
      n = 0;
      paramInt2 = 0;
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
        break label151;
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
      this.ayk = (m / k);
      this.ayl = (i / j);
      return k;
      label151:
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
    cE(paramInt2);
    System.arraycopy(paramArrayOfShort, this.axR * paramInt1, this.axZ, this.ayf * this.axR, this.axR * paramInt2);
    this.ayf += paramInt2;
  }
  
  private void b(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int k = this.axU / paramInt2;
    int m = this.axR * paramInt2;
    int n = this.axR;
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
      this.axV[paramInt2] = ((short)i);
      paramInt2 += 1;
    }
  }
  
  private void cE(int paramInt)
  {
    if (this.ayf + paramInt > this.axY)
    {
      this.axY += this.axY / 2 + paramInt;
      this.axZ = Arrays.copyOf(this.axZ, this.axY * this.axR);
    }
  }
  
  final void cF(int paramInt)
  {
    if (this.aye + paramInt > this.axW)
    {
      this.axW += this.axW / 2 + paramInt;
      this.axX = Arrays.copyOf(this.axX, this.axW * this.axR);
    }
  }
  
  final void lx()
  {
    int n = this.ayf;
    float f = this.auT / this.pitch;
    int i1;
    int k;
    int i;
    int j;
    label149:
    short[] arrayOfShort1;
    if ((f > 1.00001D) || (f < 0.9999900000000001D))
    {
      if (this.aye >= this.axU)
      {
        i1 = this.aye;
        k = 0;
        do
        {
          if (this.ayh <= 0) {
            break;
          }
          i = Math.min(this.axU, this.ayh);
          a(this.axX, k, i);
          this.ayh -= i;
          i = k + i;
          k = i;
        } while (this.axU + i <= i1);
        j = this.aye - i;
        System.arraycopy(this.axX, this.axR * i, this.axX, 0, this.axR * j);
        this.aye = j;
      }
      if (this.pitch == 1.0F) {
        break label1158;
      }
      f = this.pitch;
      if (this.ayf == n) {
        break label1158;
      }
      j = (int)(this.sampleRate / f);
      i = this.sampleRate;
      while ((j > 16384) || (i > 16384))
      {
        j /= 2;
        i /= 2;
      }
      arrayOfShort1 = this.axX;
      if (this.sampleRate > 4000)
      {
        i = this.sampleRate / 4000;
        label236:
        if ((this.axR != 1) || (i != 1)) {
          break label395;
        }
        i = a(arrayOfShort1, k, this.axS, this.axT);
      }
    }
    for (;;)
    {
      label266:
      j = this.ayk;
      int m = this.ayl;
      if ((j == 0) || (this.ayi == 0))
      {
        j = 0;
        label290:
        if (j == 0) {
          break label556;
        }
        j = this.ayi;
        label299:
        this.ayj = this.ayk;
        this.ayi = i;
        if (f <= 1.0D) {
          break label581;
        }
        arrayOfShort1 = this.axX;
        if (f < 2.0F) {
          break label561;
        }
        i = (int)(j / (f - 1.0F));
        label339:
        cE(i);
        a(i, this.axR, this.axZ, this.ayf, arrayOfShort1, k, arrayOfShort1, k + j);
        this.ayf += i;
        i = k + (i + j);
        break;
        i = 1;
        break label236;
        label395:
        b(arrayOfShort1, k, i);
        j = a(this.axV, 0, this.axS / i, this.axT / i);
        if (i == 1) {
          break label1168;
        }
        j *= i;
        m = j - i * 4;
        j += i * 4;
        if (m >= this.axS) {
          break label1162;
        }
      }
      label1158:
      label1162:
      for (i = this.axS;; i = m)
      {
        if (j > this.axT) {
          j = this.axT;
        }
        for (;;)
        {
          if (this.axR == 1)
          {
            i = a(arrayOfShort1, k, i, j);
            break label266;
          }
          b(arrayOfShort1, k, 1);
          i = a(this.axV, 0, i, j);
          break label266;
          if (m > j * 3)
          {
            j = 0;
            break label290;
          }
          if (j * 2 <= this.ayj * 3)
          {
            j = 0;
            break label290;
          }
          j = 1;
          break label290;
          label556:
          j = i;
          break label299;
          label561:
          this.ayh = ((int)(j * (2.0F - f) / (f - 1.0F)));
          i = j;
          break label339;
          label581:
          arrayOfShort1 = this.axX;
          if (f < 0.5F) {}
          for (i = (int)(j * f / (1.0F - f));; i = j)
          {
            cE(j + i);
            System.arraycopy(arrayOfShort1, this.axR * k, this.axZ, this.ayf * this.axR, this.axR * j);
            a(i, this.axR, this.axZ, this.ayf + j, arrayOfShort1, k + j, arrayOfShort1, k);
            this.ayf += j + i;
            i = k + i;
            break;
            this.ayh = ((int)(j * (2.0F * f - 1.0F) / (1.0F - f)));
          }
          a(this.axX, 0, this.aye);
          this.aye = 0;
          break label149;
          k = this.ayf - n;
          if (this.ayg + k > this.aya)
          {
            this.aya += this.aya / 2 + k;
            this.ayb = Arrays.copyOf(this.ayb, this.aya * this.axR);
          }
          System.arraycopy(this.axZ, this.axR * n, this.ayb, this.ayg * this.axR, this.axR * k);
          this.ayf = n;
          this.ayg = (k + this.ayg);
          k = 0;
          if (k < this.ayg - 1)
          {
            while ((this.ayc + 1) * j > this.ayd * i)
            {
              cE(1);
              m = 0;
              while (m < this.axR)
              {
                arrayOfShort1 = this.axZ;
                n = this.ayf;
                i1 = this.axR;
                short[] arrayOfShort2 = this.ayb;
                int i3 = this.axR * k + m;
                int i2 = arrayOfShort2[i3];
                i3 = arrayOfShort2[(i3 + this.axR)];
                int i6 = this.ayd;
                int i4 = this.ayc;
                int i5 = (this.ayc + 1) * j;
                i6 = i5 - i6 * i;
                i4 = i5 - i4 * j;
                arrayOfShort1[(n * i1 + m)] = ((short)((i3 * (i4 - i6) + i2 * i6) / i4));
                m += 1;
              }
              this.ayd += 1;
              this.ayf += 1;
            }
            this.ayc += 1;
            if (this.ayc == i)
            {
              this.ayc = 0;
              if (this.ayd != j) {
                break label1102;
              }
            }
            label1102:
            for (boolean bool = true;; bool = false)
            {
              a.aC(bool);
              this.ayd = 0;
              k += 1;
              break;
            }
          }
          i = this.ayg - 1;
          if (i != 0)
          {
            System.arraycopy(this.ayb, this.axR * i, this.ayb, 0, (this.ayg - i) * this.axR);
            this.ayg -= i;
          }
          return;
        }
      }
      label1168:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.a.k
 * JD-Core Version:    0.7.0.1
 */