package com.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

final class j
{
  private double[] bNm;
  final b bNn;
  private final b bNo;
  
  j()
  {
    AppMethodBeat.i(87966);
    this.bNm = new double[4];
    this.bNn = new b((byte)0);
    this.bNo = new b((byte)0);
    AppMethodBeat.o(87966);
  }
  
  private void a(double paramDouble, boolean paramBoolean)
  {
    double d3 = paramDouble - this.bNn.bNp;
    double d4 = d3 * d3;
    double d2;
    double d1;
    label97:
    Object localObject;
    if (paramBoolean)
    {
      this.bNn.bNZ[2][2] = this.bNn.bNT;
      this.bNn.bNZ[2][3] = 0L;
      this.bNn.bNZ[3][2] = 0L;
      this.bNn.bNZ[3][3] = this.bNn.bNT;
      if (d3 > 0.5D)
      {
        d2 = 1.0D;
        d1 = 0.0D;
        if (d1 < d3) {
          break label496;
        }
        localObject = this.bNn;
        ((b)localObject).bOb = (d2 * ((b)localObject).bOb);
      }
      this.bNn.bNY[0] += this.bNn.bNY[2] * d3;
      this.bNn.bNY[1] += this.bNn.bNY[3] * d3;
      if (!this.bNn.bOd) {
        break label517;
      }
      this.bNn.bNZ[0][0] += this.bNn.bNZ[2][2] * d4;
      this.bNn.bNZ[0][1] += this.bNn.bNZ[2][3] * d4;
      this.bNn.bNZ[1][0] += this.bNn.bNZ[3][2] * d4;
      this.bNn.bNZ[1][1] += this.bNn.bNZ[3][3] * d4;
    }
    for (;;)
    {
      this.bNn.bNp = paramDouble;
      return;
      d1 = 1.0D;
      d2 = d1;
      if (d3 > 0.5D) {}
      for (d2 = 0.0D;; d2 += 1.0D)
      {
        if (d2 >= d3)
        {
          d2 = d1;
          localObject = this.bNn.bNZ[2];
          localObject[2] *= d2;
          localObject = this.bNn.bNZ[2];
          localObject[3] *= d2;
          localObject = this.bNn.bNZ[3];
          localObject[2] *= d2;
          localObject = this.bNn.bNZ[3];
          localObject[3] = (d2 * localObject[3]);
          break;
        }
        d1 *= this.bNn.bNC;
      }
      label496:
      d2 *= this.bNn.bOc;
      d1 += 1.0D;
      break label97;
      label517:
      this.bNn.bNZ[0][0] = (this.bNn.bNZ[0][0] + (this.bNn.bNZ[0][2] + this.bNn.bNZ[2][0]) * d3 + this.bNn.bNZ[2][2] * d4);
      this.bNn.bNZ[1][1] = (this.bNn.bNZ[1][1] + (this.bNn.bNZ[1][3] + this.bNn.bNZ[3][1]) * d3 + d4 * this.bNn.bNZ[3][3]);
      this.bNn.bNZ[0][2] += this.bNn.bNZ[2][2] * d3;
      this.bNn.bNZ[2][0] += this.bNn.bNZ[2][2] * d3;
      this.bNn.bNZ[1][3] += this.bNn.bNZ[3][3] * d3;
      this.bNn.bNZ[3][1] += d3 * this.bNn.bNZ[3][3];
    }
  }
  
  private void a(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(87971);
    double d3;
    double d1;
    double d4;
    int i;
    if ((this.bNn.bNW) && (this.bNn.bNG))
    {
      Object localObject = new double[2];
      double[] arrayOfDouble = new double[2];
      double d5 = this.bNn.bOi;
      localObject[0] = (this.bNn.bNY[0] - this.bNn.bNH[0]);
      localObject[1] = (this.bNn.bNY[1] - this.bNn.bNH[1]);
      paramArrayOfDouble[0] -= this.bNn.bNH[0];
      paramArrayOfDouble[1] -= this.bNn.bNH[1];
      double d2 = Math.sqrt(localObject[0] * localObject[0] + localObject[1] * localObject[1]);
      d3 = Math.sqrt(arrayOfDouble[0] * arrayOfDouble[0] + arrayOfDouble[1] * arrayOfDouble[1]);
      if ((d2 > this.bNn.bNO) && (d3 > this.bNn.bNO))
      {
        d1 = Math.atan2(localObject[1], localObject[0]);
        d4 = Math.atan2(arrayOfDouble[1], arrayOfDouble[0]) - d1;
        if (d4 <= 3.141592653589793D) {
          break label380;
        }
        d1 = d4 - 6.283185307179586D;
        localObject = this.bNn;
        ((b)localObject).bOa = (d5 * d1 + ((b)localObject).bOa);
        if (d1 * d1 <= 4.0D * this.bNn.bOb) {
          break label402;
        }
        i = 1;
        label283:
        d4 = Math.sqrt(this.bNn.bNZ[0][0] + this.bNn.bNZ[1][1]);
        if (d2 >= d3) {
          break label408;
        }
        d1 = d2;
        label322:
        d1 = d4 / d1;
        if (i == 0) {
          break label414;
        }
      }
    }
    label402:
    label408:
    label414:
    for (this.bNn.bOb = (d1 * d1);; this.bNn.bOb = (1.0D / (1.0D / (d1 * d1) + 1.0D / this.bNn.bOb)))
    {
      this.bNn.bNH[0] = paramArrayOfDouble[0];
      this.bNn.bNH[1] = paramArrayOfDouble[1];
      this.bNn.bNG = true;
      AppMethodBeat.o(87971);
      return;
      label380:
      d1 = d4;
      if (d4 >= -3.141592653589793D) {
        break;
      }
      d1 = d4 + 6.283185307179586D;
      break;
      i = 0;
      break label283;
      d1 = d3;
      break label322;
    }
  }
  
  private static void a(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    double d = 1.0D / (paramArrayOfDouble1[0] * paramArrayOfDouble1[3] - paramArrayOfDouble1[1] * paramArrayOfDouble1[2]);
    paramArrayOfDouble2[0] = (paramArrayOfDouble1[3] * d);
    paramArrayOfDouble2[3] = (paramArrayOfDouble1[0] * d);
    paramArrayOfDouble2[1] = (-paramArrayOfDouble1[1] * d);
    paramArrayOfDouble2[2] = (d * -paramArrayOfDouble1[2]);
  }
  
  private static boolean a(double[][] paramArrayOfDouble1, double[][] paramArrayOfDouble2)
  {
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 });
    arrayOfDouble[0][0] = (paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[2][1] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[2][1] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[3][1] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[3][1] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][2]);
    arrayOfDouble[1][0] = (-paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][2]);
    arrayOfDouble[2][0] = (paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][1] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][1]);
    arrayOfDouble[3][0] = (-paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][1] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][2] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][1]);
    arrayOfDouble[0][1] = (-paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[2][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[2][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[3][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[3][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][2]);
    arrayOfDouble[1][1] = (paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][2]);
    arrayOfDouble[2][1] = (-paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][1] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][3] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][1]);
    arrayOfDouble[3][1] = (paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][1] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[0][0] * paramArrayOfDouble1[2][2] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][2] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][1]);
    arrayOfDouble[0][2] = (paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[1][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[1][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[3][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][3] - paramArrayOfDouble1[3][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][2]);
    arrayOfDouble[1][2] = (-paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][3] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][2]);
    arrayOfDouble[2][2] = (paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[3][3] - paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[3][3] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][3] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][1]);
    arrayOfDouble[3][2] = (-paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[3][2] + paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[3][1] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[3][2] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[3][1] - paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][2] + paramArrayOfDouble1[3][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][1]);
    arrayOfDouble[0][3] = (-paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][2] + paramArrayOfDouble1[1][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[1][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][2] - paramArrayOfDouble1[2][1] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][3] + paramArrayOfDouble1[2][1] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][2]);
    arrayOfDouble[1][3] = (paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][2] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][2] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][3] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][2]);
    arrayOfDouble[2][3] = (-paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][3] + paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][3] * paramArrayOfDouble1[2][1] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][3] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[2][1] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][3] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][3] * paramArrayOfDouble1[1][1]);
    arrayOfDouble[3][3] = (paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][1] * paramArrayOfDouble1[2][2] - paramArrayOfDouble1[0][0] * paramArrayOfDouble1[1][2] * paramArrayOfDouble1[2][1] - paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[2][2] + paramArrayOfDouble1[1][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[2][1] + paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][1] * paramArrayOfDouble1[1][2] - paramArrayOfDouble1[2][0] * paramArrayOfDouble1[0][2] * paramArrayOfDouble1[1][1]);
    double d = paramArrayOfDouble1[0][0] * arrayOfDouble[0][0] + paramArrayOfDouble1[0][1] * arrayOfDouble[1][0] + paramArrayOfDouble1[0][2] * arrayOfDouble[2][0] + paramArrayOfDouble1[0][3] * arrayOfDouble[3][0];
    if (d == 0.0D) {
      return false;
    }
    d = 1.0D / d;
    int i = 0;
    if (i >= 4) {
      return true;
    }
    int j = 0;
    for (;;)
    {
      if (j >= 4)
      {
        i += 1;
        break;
      }
      arrayOfDouble[i][j] *= d;
      j += 1;
    }
  }
  
  private void b(double paramDouble, boolean paramBoolean)
  {
    double d3 = paramDouble - this.bNo.bNp;
    double d4 = d3 * d3;
    double d2;
    double d1;
    label97:
    Object localObject;
    if (paramBoolean)
    {
      this.bNo.bNZ[2][2] = this.bNo.bNT;
      this.bNo.bNZ[2][3] = 0L;
      this.bNo.bNZ[3][2] = 0L;
      this.bNo.bNZ[3][3] = this.bNo.bNT;
      if (d3 > 0.5D)
      {
        d2 = 1.0D;
        d1 = 0.0D;
        if (d1 < d3) {
          break label496;
        }
        localObject = this.bNo;
        ((b)localObject).bOb = (d2 * ((b)localObject).bOb);
      }
      this.bNo.bNY[0] += this.bNo.bNY[2] * d3;
      this.bNo.bNY[1] += this.bNo.bNY[3] * d3;
      if (!this.bNo.bOd) {
        break label517;
      }
      this.bNo.bNZ[0][0] += this.bNo.bNZ[2][2] * d4;
      this.bNo.bNZ[0][1] += this.bNo.bNZ[2][3] * d4;
      this.bNo.bNZ[1][0] += this.bNo.bNZ[3][2] * d4;
      this.bNo.bNZ[1][1] += this.bNo.bNZ[3][3] * d4;
    }
    for (;;)
    {
      this.bNo.bNp = paramDouble;
      return;
      d1 = 1.0D;
      d2 = d1;
      if (d3 > 0.5D) {}
      for (d2 = 0.0D;; d2 += 1.0D)
      {
        if (d2 >= d3)
        {
          d2 = d1;
          localObject = this.bNo.bNZ[2];
          localObject[2] *= d2;
          localObject = this.bNo.bNZ[2];
          localObject[3] *= d2;
          localObject = this.bNo.bNZ[3];
          localObject[2] *= d2;
          localObject = this.bNo.bNZ[3];
          localObject[3] = (d2 * localObject[3]);
          break;
        }
        d1 *= this.bNo.bNC;
      }
      label496:
      d2 *= this.bNo.bOc;
      d1 += 1.0D;
      break label97;
      label517:
      this.bNo.bNZ[0][0] = (this.bNo.bNZ[0][0] + (this.bNo.bNZ[0][2] + this.bNo.bNZ[2][0]) * d3 + this.bNo.bNZ[2][2] * d4);
      this.bNo.bNZ[1][1] = (this.bNo.bNZ[1][1] + (this.bNo.bNZ[1][3] + this.bNo.bNZ[3][1]) * d3 + d4 * this.bNo.bNZ[3][3]);
      this.bNo.bNZ[0][2] += this.bNo.bNZ[2][2] * d3;
      this.bNo.bNZ[2][0] += this.bNo.bNZ[2][2] * d3;
      this.bNo.bNZ[1][3] += this.bNo.bNZ[3][3] * d3;
      this.bNo.bNZ[3][1] += d3 * this.bNo.bNZ[3][3];
    }
  }
  
  private void bk(boolean paramBoolean)
  {
    AppMethodBeat.i(87969);
    if (this.bNn.bOd != paramBoolean)
    {
      this.bNn.bOd = paramBoolean;
      if (paramBoolean)
      {
        this.bNn.bNC = this.bNn.bOk[1];
        this.bNn.bNT = this.bNn.bOj[1];
        a(this.bNn.bNp, true);
        AppMethodBeat.o(87969);
        return;
      }
      this.bNn.bNC = this.bNn.bOk[0];
      this.bNn.bNT = this.bNn.bOj[0];
      a(this.bNn.bNp, true);
    }
    AppMethodBeat.o(87969);
  }
  
  final void a(int paramInt, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    AppMethodBeat.i(87972);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(87972);
      return;
      paramArrayOfDouble2[0] = ((paramArrayOfDouble1[1] - this.bNn.bNU[1]) * 6378137.0D * Math.cos(this.bNn.bNU[0]));
      paramArrayOfDouble2[1] = ((paramArrayOfDouble1[0] - this.bNn.bNU[0]) * 6378137.0D);
      AppMethodBeat.o(87972);
      return;
      paramArrayOfDouble2[0] = (paramArrayOfDouble1[1] / 6378137.0D + this.bNn.bNU[0]);
      paramArrayOfDouble2[1] = (paramArrayOfDouble1[0] / (Math.cos(this.bNn.bNU[0]) * 6378137.0D) + this.bNn.bNU[1]);
    }
  }
  
  protected final void a(long paramLong, double paramDouble1, double paramDouble2, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(87967);
    double d1 = paramLong;
    double d2 = paramFloat * paramFloat;
    double[] arrayOfDouble1 = new double[2];
    double[] tmp24_22 = arrayOfDouble1;
    tmp24_22[0] = 0.0D;
    double[] tmp28_24 = tmp24_22;
    tmp28_24[1] = 0.0D;
    tmp28_24;
    if (paramBoolean1) {}
    for (int i = 3;; i = 5)
    {
      double[] arrayOfDouble2 = new double[2];
      arrayOfDouble2[0] = paramDouble1;
      arrayOfDouble2[1] = paramDouble2;
      this.bNn.bOd = true;
      this.bNn.bOk[0] = 3.0D;
      this.bNn.bOk[1] = 1.2D;
      this.bNn.bOi = 0.5D;
      this.bNn.bNC = 1.2D;
      this.bNn.bNI = 4.0D;
      this.bNn.bNJ = 0;
      this.bNn.bNL = true;
      this.bNn.bNK = i;
      this.bNn.bND = false;
      this.bNn.bNG = false;
      this.bNn.bNR = 40.0D;
      this.bNn.bNS = 0.1570796326794897D;
      this.bNn.bNT = 1.0D;
      this.bNn.bOj[0] = 400.0D;
      this.bNn.bOj[1] = 1.0D;
      this.bNn.bNW = paramBoolean2;
      this.bNn.bNX = false;
      this.bNn.bNM = true;
      this.bNn.bNN = 0.3333333333333333D;
      this.bNn.bNO = 5.0D;
      this.bNn.bNP = 0.5D;
      this.bNn.bNQ = 1.0D;
      this.bNn.bOe = 0.5D;
      this.bNn.bOf = 1.0D;
      this.bNn.bOg = 0;
      this.bNn.bOh = 2;
      this.bNn.bOl = false;
      this.bNn.bNU[0] = arrayOfDouble2[0];
      this.bNn.bNU[1] = arrayOfDouble2[1];
      arrayOfDouble2 = new double[2];
      a(0, new double[] { paramDouble1, paramDouble2 }, arrayOfDouble2);
      this.bNn.bNp = d1;
      this.bNn.bNY[0] = arrayOfDouble2[0];
      this.bNn.bNY[1] = arrayOfDouble2[1];
      this.bNn.bNY[2] = arrayOfDouble1[0];
      this.bNn.bNY[3] = arrayOfDouble1[1];
      this.bNn.bOa = 0.0D;
      this.bNn.bOb = 1.0D;
      this.bNn.bOc = 1.005D;
      this.bNn.bNZ[0][0] = tmp24_22;
      this.bNn.bNZ[0][1] = 0L;
      this.bNn.bNZ[0][2] = 0L;
      this.bNn.bNZ[0][3] = 0L;
      this.bNn.bNZ[1][0] = 0L;
      this.bNn.bNZ[1][1] = tmp24_22;
      this.bNn.bNZ[1][2] = 0L;
      this.bNn.bNZ[1][3] = 0L;
      this.bNn.bNZ[2][0] = 0L;
      this.bNn.bNZ[2][1] = 0L;
      this.bNn.bNZ[2][2] = 4607182418800017408L;
      this.bNn.bNZ[2][3] = 0L;
      this.bNn.bNZ[3][0] = 0L;
      this.bNn.bNZ[3][1] = 0L;
      this.bNn.bNZ[3][2] = 0L;
      this.bNn.bNZ[3][3] = 4607182418800017408L;
      bj(paramBoolean1);
      AppMethodBeat.o(87967);
      return;
    }
  }
  
  protected final void a(a parama)
  {
    AppMethodBeat.i(87970);
    if (parama.bNu <= 0.0D)
    {
      AppMethodBeat.o(87970);
      return;
    }
    double d1;
    if (this.bNn.bND)
    {
      d1 = parama.bNp - this.bNn.bNF;
      if (d1 < -10.0D)
      {
        AppMethodBeat.o(87970);
        return;
      }
      if (d1 <= 0.0D) {
        parama.bNp = (this.bNn.bNF + 0.5D);
      }
    }
    double[] arrayOfDouble1 = new double[2];
    a(0, new double[] { parama.bNq, parama.bNr }, arrayOfDouble1);
    parama.bNs[0] = arrayOfDouble1[0];
    parama.bNs[1] = arrayOfDouble1[1];
    Object localObject2;
    Object localObject1;
    double d4;
    double d3;
    double d2;
    Object localObject3;
    label1176:
    label1184:
    label1192:
    int i;
    if (this.bNn.bOd)
    {
      double d5;
      if ((parama.mType != 3) || (this.bNn.bND))
      {
        if (parama.mType != 3) {
          break label1192;
        }
        d5 = parama.bNp - this.bNn.bNF;
        if (d5 > 0.0D)
        {
          localObject2 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
          localObject1 = new double[2];
          d4 = arrayOfDouble1[0] - this.bNn.bNE[0];
          d3 = arrayOfDouble1[1] - this.bNn.bNE[1];
          d1 = d3;
          d2 = d4;
          if (this.bNn.bNW)
          {
            d2 = d4 * Math.cos(this.bNn.bOa) - Math.sin(this.bNn.bOa) * d3;
            d1 = Math.sin(this.bNn.bOa);
            d1 = d3 * Math.cos(this.bNn.bOa) + d1 * d2;
          }
          d4 = Math.sqrt(d2 * d2 + d1 * d1);
          d3 = d4 / this.bNn.bNR;
          d3 *= d3;
          if (d3 <= 0.0625D) {
            break label1176;
          }
          d4 *= this.bNn.bNS;
          d4 *= d4;
          if (d4 <= 0.0625D) {
            break label1184;
          }
        }
      }
      for (;;)
      {
        d3 = (d3 + d4) / d5;
        d4 = this.bNn.bNZ[2][2];
        double d6 = this.bNn.bNZ[2][3];
        double d7 = this.bNn.bNZ[3][2];
        double d8 = this.bNn.bNZ[3][3];
        localObject3 = this.bNm;
        a(new double[] { d4, d6, d7, d8 }, (double[])localObject3);
        localObject2[0][0] = this.bNm[0];
        localObject2[0][1] = this.bNm[1];
        localObject2[1][0] = this.bNm[2];
        localObject2[1][1] = this.bNm[3];
        d4 = d2 / d5 - this.bNn.bNY[2];
        d6 = d1 / d5 - this.bNn.bNY[3];
        d7 = localObject2[0][0];
        d8 = localObject2[0][1];
        if (Math.sqrt(d4 * d6 * localObject2[1][0] + (d4 * d4 * d7 + d4 * d6 * d8) + d6 * d6 * localObject2[1][1]) > 2.0D)
        {
          this.bNn.bNZ[2][2] = this.bNn.bNT;
          this.bNn.bNZ[2][3] = 0L;
          this.bNn.bNZ[3][2] = 0L;
          this.bNn.bNZ[3][3] = this.bNn.bNT;
          localObject2[0][0] = (1.0D / this.bNn.bNT);
          localObject2[0][1] = 0L;
          localObject2[1][0] = 0L;
          localObject2[1][1] = (1.0D / this.bNn.bNT);
        }
        localObject1[0] = (localObject2[0][0] * this.bNn.bNY[2] + localObject2[0][1] * this.bNn.bNY[3]);
        localObject1[1] = (localObject2[1][0] * this.bNn.bNY[2] + localObject2[1][1] * this.bNn.bNY[3]);
        localObject3 = localObject2[0];
        localObject3[0] += 1.0D / d3;
        localObject3 = localObject2[1];
        localObject3[1] += 1.0D / d3;
        d4 = localObject1[0];
        localObject1[0] = (d2 / (d5 * d3) + d4);
        d2 = localObject1[1];
        localObject1[1] = (d1 / (d3 * d5) + d2);
        d1 = localObject2[0][0];
        d2 = localObject2[0][1];
        d3 = localObject2[1][0];
        d4 = localObject2[1][1];
        localObject2 = this.bNm;
        a(new double[] { d1, d2, d3, d4 }, (double[])localObject2);
        this.bNn.bNZ[2][2] = this.bNm[0];
        this.bNn.bNZ[2][3] = this.bNm[1];
        this.bNn.bNZ[3][2] = this.bNm[2];
        this.bNn.bNZ[3][3] = this.bNm[3];
        this.bNn.bNY[2] = (this.bNn.bNZ[2][2] * localObject1[0] + this.bNn.bNZ[2][3] * localObject1[1]);
        this.bNn.bNY[3] = (this.bNn.bNZ[3][2] * localObject1[0] + this.bNn.bNZ[3][3] * localObject1[1]);
        a(parama.bNp, false);
        if (parama.mType != 3) {
          break label4325;
        }
        this.bNn.bNE[0] = arrayOfDouble1[0];
        this.bNn.bNE[1] = arrayOfDouble1[1];
        this.bNn.bNF = parama.bNp;
        this.bNn.bND = true;
        AppMethodBeat.o(87970);
        return;
        d3 = 0.0625D;
        break;
        d4 = 0.0625D;
      }
      d2 = 0.0D;
      d1 = 0.0D;
      localObject2 = new double[2];
      localObject1 = new double[2];
      a(parama.bNp, false);
      if (this.bNn.bNM)
      {
        if (!this.bNn.bNG)
        {
          i = 1;
          j = 1;
          label1242:
          if (i == 0) {
            break label2043;
          }
          if (this.bNn.bNG)
          {
            if (d2 >= d1) {
              break label2045;
            }
            d3 = this.bNn.bNP;
            label1273:
            d1 = d3 + d1 / d2 * (1.0D - d3);
            arrayOfDouble1[0] = (this.bNn.bNH[0] + localObject1[0] * d1);
            d2 = this.bNn.bNH[1];
            arrayOfDouble1[1] = (d1 * localObject1[1] + d2);
          }
          if (j == 0) {
            break label2057;
          }
          a(arrayOfDouble1);
        }
        for (;;)
        {
          this.bNn.bNY[0] = arrayOfDouble1[0];
          this.bNn.bNY[1] = arrayOfDouble1[1];
          this.bNn.bNZ[0][0] = (parama.bNu * parama.bNu);
          this.bNn.bNZ[0][1] = 0L;
          this.bNn.bNZ[1][0] = 0L;
          this.bNn.bNZ[1][1] = (parama.bNu * parama.bNu);
          break;
          localObject2[0] = (this.bNn.bNY[0] - this.bNn.bNH[0]);
          localObject2[1] = (this.bNn.bNY[1] - this.bNn.bNH[1]);
          arrayOfDouble1[0] -= this.bNn.bNH[0];
          arrayOfDouble1[1] -= this.bNn.bNH[1];
          d4 = Math.sqrt(localObject2[0] * localObject2[0] + localObject2[1] * localObject2[1]);
          d3 = Math.sqrt(localObject1[0] * localObject1[0] + localObject1[1] * localObject1[1]);
          if ((d3 > this.bNn.bNO) && (d4 > this.bNn.bNO))
          {
            d1 = d3 / d4;
            d2 = d3 - d4;
            d5 = Math.sqrt(this.bNn.bNZ[0][0] + this.bNn.bNZ[1][1]);
            if (d4 > 3.0D * this.bNn.bNO)
            {
              d1 = d2;
              if (d2 < 0.0D) {
                d1 = -d2;
              }
              d5 = d1 / d5;
              d1 = Math.atan2(localObject2[1], localObject2[0]);
              d2 = Math.atan2(localObject1[1], localObject1[0]) - d1;
              if (d2 > 3.141592653589793D)
              {
                d1 = d2 - 6.283185307179586D;
                label1711:
                d2 = d1;
                if (d1 < 0.0D) {
                  d2 = -d1;
                }
                d1 = d2 / Math.sqrt(this.bNn.bOb);
                d2 = Math.sqrt(d1 * d1 + d5 * d5);
                if (d2 >= this.bNn.bNI) {
                  break label1826;
                }
                this.bNn.bOg = 0;
                d1 = d2;
              }
              for (;;)
              {
                if (d1 <= this.bNn.bNI) {
                  break label1893;
                }
                i = 0;
                j = 0;
                d1 = d4;
                d2 = d3;
                break;
                d1 = d2;
                if (d2 >= -3.141592653589793D) {
                  break label1711;
                }
                d1 = d2 + 6.283185307179586D;
                break label1711;
                label1826:
                d1 = d2;
                if (d5 < this.bNn.bNI)
                {
                  localObject2 = this.bNn;
                  i = ((b)localObject2).bOg + 1;
                  ((b)localObject2).bOg = i;
                  d1 = d2;
                  if (i >= this.bNn.bOh)
                  {
                    this.bNn.bOg = 0;
                    d1 = d5;
                  }
                }
              }
              label1893:
              i = 1;
              j = 1;
              d1 = d4;
              d2 = d3;
              break label1242;
            }
            if ((d1 < this.bNn.bNN) || (1.0D / d1 < this.bNn.bNN))
            {
              i = 0;
              j = 0;
              d1 = d4;
              d2 = d3;
              break label1242;
            }
            i = 1;
            j = 0;
            d1 = d4;
            d2 = d3;
            break label1242;
          }
          if (((d3 < this.bNn.bNO) && (parama.mType == 2)) || ((d3 < this.bNn.bNO * 0.5D) && (parama.mType == 1)))
          {
            i = 0;
            j = 0;
            d1 = d4;
            d2 = d3;
            break label1242;
          }
          i = 1;
          j = 0;
          d1 = d4;
          d2 = d3;
          break label1242;
          label2043:
          break;
          label2045:
          d3 = this.bNn.bNQ;
          break label1273;
          label2057:
          this.bNn.bNH[0] = arrayOfDouble1[0];
          this.bNn.bNH[1] = arrayOfDouble1[1];
        }
      }
      b.a(this.bNo, this.bNn);
      b(parama.bNp, false);
      if (this.bNo.bNL) {
        if (!this.bNn.bNG)
        {
          d1 = 0.0D;
          label2128:
          if (d1 <= this.bNn.bNI) {
            break label3171;
          }
          b.a(this.bNo, this.bNn);
          b(parama.bNp, true);
          if (!this.bNn.bNL) {
            break label2881;
          }
          d3 = this.bNn.bNH[0] - this.bNo.bNY[0];
          d4 = this.bNn.bNH[1] - this.bNo.bNY[1];
          d1 = this.bNn.bNH[0] - arrayOfDouble1[0];
          d2 = this.bNn.bNH[1] - arrayOfDouble1[1];
          d3 = Math.sqrt(d3 * d3 + d4 * d4);
          d1 = Math.sqrt(d1 * d1 + d2 * d2);
          d2 = Math.sqrt(this.bNo.bNZ[0][0] * this.bNo.bNZ[0][0] + this.bNo.bNZ[1][1] * this.bNo.bNZ[1][1]);
          d1 = Math.abs(d3 - d1) / d2;
          label2335:
          if (d1 <= this.bNo.bNI) {
            break label3143;
          }
          if (this.bNn.bNJ >= this.bNn.bNK) {
            break label3121;
          }
          this.bNn.bNJ += 1;
        }
      }
      for (;;)
      {
        this.bNn.bNY[0] = arrayOfDouble1[0];
        this.bNn.bNY[1] = arrayOfDouble1[1];
        this.bNn.bNZ[0][0] = (parama.bNu * parama.bNu);
        this.bNn.bNZ[0][1] = 0L;
        this.bNn.bNZ[1][0] = 0L;
        this.bNn.bNZ[1][1] = (parama.bNu * parama.bNu);
        break;
        d3 = this.bNn.bNH[0] - this.bNo.bNY[0];
        d4 = this.bNn.bNH[1] - this.bNo.bNY[1];
        d1 = this.bNn.bNH[0] - arrayOfDouble1[0];
        d2 = this.bNn.bNH[1] - arrayOfDouble1[1];
        d3 = Math.sqrt(d3 * d3 + d4 * d4);
        d1 = Math.sqrt(d1 * d1 + d2 * d2);
        d2 = Math.sqrt(this.bNn.bNZ[0][0] * this.bNn.bNZ[0][0] + this.bNn.bNZ[1][1] * this.bNn.bNZ[1][1]);
        d1 = Math.abs(d3 - d1) / d2;
        break label2128;
        d1 = arrayOfDouble1[0] - this.bNo.bNY[0];
        d2 = arrayOfDouble1[1] - this.bNo.bNY[1];
        localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
        d3 = 1.0D / (this.bNo.bNZ[0][0] * this.bNo.bNZ[1][1] - this.bNo.bNZ[0][1] * this.bNo.bNZ[1][0]);
        localObject1[0][0] = (this.bNo.bNZ[1][1] * d3);
        localObject1[1][1] = (this.bNo.bNZ[0][0] * d3);
        localObject1[0][1] = (-this.bNo.bNZ[0][1] * d3);
        localObject1[1][0] = (d3 * -this.bNo.bNZ[1][0]);
        d3 = localObject1[0][0];
        d4 = localObject1[1][0];
        d1 = Math.sqrt(localObject1[1][1] * (d2 * d2) + (d1 * 2.0D * d2 * d4 + d1 * d1 * d3));
        break label2128;
        label2881:
        d1 = arrayOfDouble1[0] - this.bNo.bNY[0];
        d2 = arrayOfDouble1[1] - this.bNo.bNY[1];
        localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
        d3 = 1.0D / (this.bNo.bNZ[0][0] * this.bNo.bNZ[1][1] - this.bNo.bNZ[0][1] * this.bNo.bNZ[1][0]);
        localObject1[0][0] = (this.bNo.bNZ[1][1] * d3);
        localObject1[1][1] = (this.bNo.bNZ[0][0] * d3);
        localObject1[0][1] = (-this.bNo.bNZ[0][1] * d3);
        localObject1[1][0] = (d3 * -this.bNo.bNZ[1][0]);
        d3 = localObject1[0][0];
        d4 = localObject1[1][0];
        d1 = Math.sqrt(localObject1[1][1] * (d2 * d2) + (d1 * 2.0D * d2 * d4 + d1 * d1 * d3));
        break label2335;
        label3121:
        b.a(this.bNn, this.bNo);
        this.bNn.bNJ = 0;
        continue;
        label3143:
        b.a(this.bNn, this.bNo);
        this.bNn.bNJ = 0;
        a(arrayOfDouble1);
        continue;
        label3171:
        b.a(this.bNn, this.bNo);
        this.bNn.bNJ = 0;
        a(arrayOfDouble1);
      }
    }
    if (parama.mType != 3)
    {
      j = 0;
      localObject2 = new double[2];
      localObject1 = new double[2];
      arrayOfDouble1 = new double[2];
      a(parama.bNp, false);
      if (!this.bNn.bNG)
      {
        i = 1;
        j = 0;
        this.bNn.bNJ = 0;
      }
      while (i != 0) {
        if (j == 0)
        {
          this.bNn.bNY[0] = parama.bNs[0];
          this.bNn.bNY[1] = parama.bNs[1];
          this.bNn.bNY[2] = 0.0D;
          this.bNn.bNY[3] = 0.0D;
          this.bNn.bNZ[0][0] = (parama.bNu * parama.bNu);
          this.bNn.bNZ[0][1] = 0L;
          this.bNn.bNZ[0][2] = 0L;
          this.bNn.bNZ[0][3] = 0L;
          this.bNn.bNZ[1][0] = 0L;
          this.bNn.bNZ[1][1] = this.bNn.bNZ[0][0];
          this.bNn.bNZ[1][2] = 0L;
          this.bNn.bNZ[1][2] = 0L;
          this.bNn.bNZ[2][0] = 0L;
          this.bNn.bNZ[2][1] = 0L;
          this.bNn.bNZ[2][2] = this.bNn.bNT;
          this.bNn.bNZ[2][3] = 0L;
          this.bNn.bNZ[3][0] = 0L;
          this.bNn.bNZ[3][1] = 0L;
          this.bNn.bNZ[3][2] = 0L;
          this.bNn.bNZ[3][3] = this.bNn.bNT;
          this.bNn.bNH[0] = parama.bNs[0];
          this.bNn.bNH[1] = parama.bNs[1];
          this.bNn.bNG = true;
          AppMethodBeat.o(87970);
          return;
          localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
          localObject2[0] = (parama.bNs[0] - this.bNn.bNY[0]);
          localObject2[1] = (parama.bNs[1] - this.bNn.bNY[1]);
          d1 = this.bNn.bNZ[0][0];
          d2 = this.bNn.bNZ[0][1];
          d3 = this.bNn.bNZ[1][0];
          d4 = this.bNn.bNZ[1][1];
          double[] arrayOfDouble2 = this.bNm;
          a(new double[] { d1, d2, d3, d4 }, arrayOfDouble2);
          localObject3[0][0] = this.bNm[0];
          localObject3[0][1] = this.bNm[1];
          localObject3[1][0] = this.bNm[2];
          localObject3[1][1] = this.bNm[3];
          if (Math.sqrt(localObject2[0] * localObject2[0] * localObject3[0][0] + 2.0D * localObject2[0] * localObject2[1] * localObject3[1][0] + localObject2[1] * localObject2[1] * localObject3[1][1]) > this.bNn.bNI)
          {
            localObject2 = this.bNn;
            i = ((b)localObject2).bNJ + 1;
            ((b)localObject2).bNJ = i;
            if (i >= this.bNn.bNK)
            {
              i = 1;
              j = 0;
              this.bNn.bNJ = 0;
            }
            else
            {
              i = 0;
            }
          }
          else
          {
            this.bNn.bNJ = 0;
            i = 1;
            j = 1;
          }
        }
        else
        {
          localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 });
          localObject2 = new double[2];
          localObject1[0] = (this.bNn.bNY[0] - this.bNn.bNH[0]);
          localObject1[1] = (this.bNn.bNY[1] - this.bNn.bNH[1]);
          arrayOfDouble1[0] = (parama.bNs[0] - this.bNn.bNH[0]);
          arrayOfDouble1[1] = (parama.bNs[1] - this.bNn.bNH[1]);
          d2 = Math.sqrt(arrayOfDouble1[0] * arrayOfDouble1[0] + arrayOfDouble1[1] * arrayOfDouble1[1]);
          d1 = localObject1[0];
          d3 = localObject1[0];
          d4 = localObject1[1];
          d4 = Math.sqrt(localObject1[1] * d4 + d1 * d3);
          if (d2 >= d4) {
            break label4331;
          }
          d1 = this.bNn.bOe;
          if (a(this.bNn.bNZ, (double[][])localObject3))
          {
            d3 = 1.0D / (parama.bNu * parama.bNu);
            localObject1 = new double[4];
            if (!this.bNn.bOl) {
              break label4342;
            }
            d1 += d4 / d2 * (1.0D - d1);
            localObject2[0] = (this.bNn.bNH[0] + arrayOfDouble1[0] * d1);
            d2 = this.bNn.bNH[1];
            localObject2[1] = (d1 * arrayOfDouble1[1] + d2);
          }
        }
      }
    }
    for (;;)
    {
      i = 0;
      if (i < 4) {
        break label4401;
      }
      parama = localObject3[0];
      parama[0] += d3;
      parama = localObject3[1];
      parama[1] += d3;
      if (a((double[][])localObject3, this.bNn.bNZ))
      {
        localObject1[0] += localObject2[0] * d3;
        localObject1[1] += localObject2[1] * d3;
        i = 0;
        if (i < 4) {
          break label4464;
        }
        this.bNn.bNH[0] = localObject2[0];
        this.bNn.bNH[1] = localObject2[1];
      }
      label4325:
      AppMethodBeat.o(87970);
      return;
      label4331:
      d1 = this.bNn.bOf;
      break;
      label4342:
      localObject2[0] = (this.bNn.bNY[0] * (1.0D - d1) + parama.bNs[0] * d1);
      d2 = this.bNn.bNY[1];
      localObject2[1] = (d1 * parama.bNs[1] + d2 * (1.0D - d1));
    }
    label4401:
    localObject1[i] = 0.0D;
    int j = 0;
    for (;;)
    {
      if (j >= 4)
      {
        i += 1;
        break;
      }
      localObject1[i] += localObject3[i][j] * this.bNn.bNY[j];
      j += 1;
    }
    label4464:
    this.bNn.bNY[i] = 0.0D;
    j = 0;
    for (;;)
    {
      if (j >= 4)
      {
        i += 1;
        break;
      }
      parama = this.bNn.bNY;
      parama[i] += this.bNn.bNZ[i][j] * localObject1[j];
      j += 1;
    }
  }
  
  protected final void bj(boolean paramBoolean)
  {
    AppMethodBeat.i(87968);
    if (paramBoolean) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      bk(paramBoolean);
      AppMethodBeat.o(87968);
      return;
    }
  }
  
  protected static final class a
  {
    double bNA;
    double bNB;
    double bNp;
    double bNq;
    double bNr;
    double[] bNs;
    double bNt;
    double bNu;
    int bNv;
    double bNw;
    double bNx;
    int bNy;
    double bNz;
    int mType;
    
    protected a(int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, int paramInt2, double paramDouble6, int paramInt3, double paramDouble7, double paramDouble8)
    {
      AppMethodBeat.i(87961);
      this.bNs = new double[2];
      this.mType = paramInt1;
      this.bNp = paramDouble1;
      this.bNq = paramDouble2;
      this.bNr = paramDouble3;
      this.bNt = paramDouble4;
      this.bNu = paramDouble5;
      this.bNv = paramInt2;
      this.bNw = paramDouble6;
      this.bNx = 0.0D;
      this.bNy = paramInt3;
      this.bNz = 0.0D;
      this.bNA = paramDouble7;
      this.bNB = paramDouble8;
      AppMethodBeat.o(87961);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(87962);
      String str = String.valueOf(this.mType) + ',' + this.bNp + ',' + this.bNq + ',' + this.bNr + ',' + this.bNt + ',' + this.bNu + ',' + this.bNv + ',' + this.bNw + ',' + this.bNx + ',' + this.bNy + ',' + this.bNA + ',' + this.bNB;
      AppMethodBeat.o(87962);
      return str;
    }
  }
  
  static final class b
  {
    double bNC;
    boolean bND;
    double[] bNE;
    double bNF;
    boolean bNG;
    double[] bNH;
    double bNI;
    int bNJ;
    int bNK;
    boolean bNL;
    boolean bNM;
    double bNN;
    double bNO;
    double bNP;
    double bNQ;
    double bNR;
    double bNS;
    double bNT;
    double[] bNU;
    private boolean bNV;
    boolean bNW;
    boolean bNX;
    double[] bNY;
    double[][] bNZ;
    double bNp;
    double bOa;
    double bOb;
    double bOc;
    boolean bOd;
    double bOe;
    double bOf;
    int bOg;
    int bOh;
    double bOi;
    double[] bOj;
    double[] bOk;
    boolean bOl;
    
    private b()
    {
      AppMethodBeat.i(87963);
      this.bNE = new double[2];
      this.bNH = new double[2];
      this.bNU = new double[2];
      this.bNY = new double[4];
      this.bNZ = ((double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 }));
      this.bOj = new double[2];
      this.bOk = new double[2];
      AppMethodBeat.o(87963);
    }
    
    private void a(b paramb)
    {
      AppMethodBeat.i(87964);
      this.bNC = paramb.bNC;
      this.bND = paramb.bND;
      this.bNE = ((double[])paramb.bNE.clone());
      this.bNF = paramb.bNF;
      this.bNG = paramb.bNG;
      this.bNH = ((double[])paramb.bNH.clone());
      this.bNI = paramb.bNI;
      this.bNJ = paramb.bNJ;
      this.bNK = paramb.bNK;
      this.bNL = paramb.bNL;
      this.bNM = paramb.bNM;
      this.bNN = paramb.bNN;
      this.bNO = paramb.bNO;
      this.bNP = paramb.bNP;
      this.bNQ = paramb.bNQ;
      this.bNR = paramb.bNR;
      this.bNS = paramb.bNS;
      this.bNT = paramb.bNT;
      this.bNU = ((double[])paramb.bNU.clone());
      this.bNV = paramb.bNV;
      this.bNW = paramb.bNW;
      this.bNX = paramb.bNX;
      this.bNp = paramb.bNp;
      this.bNY = ((double[])paramb.bNY.clone());
      this.bNZ[0] = ((double[])paramb.bNZ[0].clone());
      this.bNZ[1] = ((double[])paramb.bNZ[1].clone());
      this.bNZ[2] = ((double[])paramb.bNZ[2].clone());
      this.bNZ[3] = ((double[])paramb.bNZ[3].clone());
      this.bOa = paramb.bOa;
      this.bOb = paramb.bOb;
      this.bOc = paramb.bOc;
      this.bOd = paramb.bOd;
      this.bOe = paramb.bOe;
      this.bOf = paramb.bOf;
      this.bOg = paramb.bOg;
      this.bOh = paramb.bOh;
      this.bOi = paramb.bOi;
      this.bOj = ((double[])paramb.bOj.clone());
      this.bOk = ((double[])paramb.bOk.clone());
      this.bOl = paramb.bOl;
      AppMethodBeat.o(87964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.j
 * JD-Core Version:    0.7.0.1
 */