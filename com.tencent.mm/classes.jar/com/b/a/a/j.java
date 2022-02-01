package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

final class j
{
  private double[] cig;
  final b cih;
  private final b cii;
  
  j()
  {
    AppMethodBeat.i(87966);
    this.cig = new double[4];
    this.cih = new b((byte)0);
    this.cii = new b((byte)0);
    AppMethodBeat.o(87966);
  }
  
  private void a(double paramDouble, boolean paramBoolean)
  {
    double d3 = paramDouble - this.cih.cij;
    double d4 = d3 * d3;
    double d2;
    double d1;
    label97:
    Object localObject;
    if (paramBoolean)
    {
      this.cih.ciT[2][2] = this.cih.ciN;
      this.cih.ciT[2][3] = 0L;
      this.cih.ciT[3][2] = 0L;
      this.cih.ciT[3][3] = this.cih.ciN;
      if (d3 > 0.5D)
      {
        d2 = 1.0D;
        d1 = 0.0D;
        if (d1 < d3) {
          break label496;
        }
        localObject = this.cih;
        ((b)localObject).ciV = (d2 * ((b)localObject).ciV);
      }
      this.cih.ciS[0] += this.cih.ciS[2] * d3;
      this.cih.ciS[1] += this.cih.ciS[3] * d3;
      if (!this.cih.ciX) {
        break label517;
      }
      this.cih.ciT[0][0] += this.cih.ciT[2][2] * d4;
      this.cih.ciT[0][1] += this.cih.ciT[2][3] * d4;
      this.cih.ciT[1][0] += this.cih.ciT[3][2] * d4;
      this.cih.ciT[1][1] += this.cih.ciT[3][3] * d4;
    }
    for (;;)
    {
      this.cih.cij = paramDouble;
      return;
      d1 = 1.0D;
      d2 = d1;
      if (d3 > 0.5D) {}
      for (d2 = 0.0D;; d2 += 1.0D)
      {
        if (d2 >= d3)
        {
          d2 = d1;
          localObject = this.cih.ciT[2];
          localObject[2] *= d2;
          localObject = this.cih.ciT[2];
          localObject[3] *= d2;
          localObject = this.cih.ciT[3];
          localObject[2] *= d2;
          localObject = this.cih.ciT[3];
          localObject[3] = (d2 * localObject[3]);
          break;
        }
        d1 *= this.cih.ciw;
      }
      label496:
      d2 *= this.cih.ciW;
      d1 += 1.0D;
      break label97;
      label517:
      this.cih.ciT[0][0] = (this.cih.ciT[0][0] + (this.cih.ciT[0][2] + this.cih.ciT[2][0]) * d3 + this.cih.ciT[2][2] * d4);
      this.cih.ciT[1][1] = (this.cih.ciT[1][1] + (this.cih.ciT[1][3] + this.cih.ciT[3][1]) * d3 + d4 * this.cih.ciT[3][3]);
      this.cih.ciT[0][2] += this.cih.ciT[2][2] * d3;
      this.cih.ciT[2][0] += this.cih.ciT[2][2] * d3;
      this.cih.ciT[1][3] += this.cih.ciT[3][3] * d3;
      this.cih.ciT[3][1] += d3 * this.cih.ciT[3][3];
    }
  }
  
  private void a(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(87971);
    double d3;
    double d1;
    double d4;
    int i;
    if ((this.cih.ciQ) && (this.cih.ciA))
    {
      Object localObject = new double[2];
      double[] arrayOfDouble = new double[2];
      double d5 = this.cih.cjc;
      localObject[0] = (this.cih.ciS[0] - this.cih.ciB[0]);
      localObject[1] = (this.cih.ciS[1] - this.cih.ciB[1]);
      paramArrayOfDouble[0] -= this.cih.ciB[0];
      paramArrayOfDouble[1] -= this.cih.ciB[1];
      double d2 = Math.sqrt(localObject[0] * localObject[0] + localObject[1] * localObject[1]);
      d3 = Math.sqrt(arrayOfDouble[0] * arrayOfDouble[0] + arrayOfDouble[1] * arrayOfDouble[1]);
      if ((d2 > this.cih.ciI) && (d3 > this.cih.ciI))
      {
        d1 = Math.atan2(localObject[1], localObject[0]);
        d4 = Math.atan2(arrayOfDouble[1], arrayOfDouble[0]) - d1;
        if (d4 <= 3.141592653589793D) {
          break label380;
        }
        d1 = d4 - 6.283185307179586D;
        localObject = this.cih;
        ((b)localObject).ciU = (d5 * d1 + ((b)localObject).ciU);
        if (d1 * d1 <= 4.0D * this.cih.ciV) {
          break label402;
        }
        i = 1;
        label283:
        d4 = Math.sqrt(this.cih.ciT[0][0] + this.cih.ciT[1][1]);
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
    for (this.cih.ciV = (d1 * d1);; this.cih.ciV = (1.0D / (1.0D / (d1 * d1) + 1.0D / this.cih.ciV)))
    {
      this.cih.ciB[0] = paramArrayOfDouble[0];
      this.cih.ciB[1] = paramArrayOfDouble[1];
      this.cih.ciA = true;
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
    double d3 = paramDouble - this.cii.cij;
    double d4 = d3 * d3;
    double d2;
    double d1;
    label97:
    Object localObject;
    if (paramBoolean)
    {
      this.cii.ciT[2][2] = this.cii.ciN;
      this.cii.ciT[2][3] = 0L;
      this.cii.ciT[3][2] = 0L;
      this.cii.ciT[3][3] = this.cii.ciN;
      if (d3 > 0.5D)
      {
        d2 = 1.0D;
        d1 = 0.0D;
        if (d1 < d3) {
          break label496;
        }
        localObject = this.cii;
        ((b)localObject).ciV = (d2 * ((b)localObject).ciV);
      }
      this.cii.ciS[0] += this.cii.ciS[2] * d3;
      this.cii.ciS[1] += this.cii.ciS[3] * d3;
      if (!this.cii.ciX) {
        break label517;
      }
      this.cii.ciT[0][0] += this.cii.ciT[2][2] * d4;
      this.cii.ciT[0][1] += this.cii.ciT[2][3] * d4;
      this.cii.ciT[1][0] += this.cii.ciT[3][2] * d4;
      this.cii.ciT[1][1] += this.cii.ciT[3][3] * d4;
    }
    for (;;)
    {
      this.cii.cij = paramDouble;
      return;
      d1 = 1.0D;
      d2 = d1;
      if (d3 > 0.5D) {}
      for (d2 = 0.0D;; d2 += 1.0D)
      {
        if (d2 >= d3)
        {
          d2 = d1;
          localObject = this.cii.ciT[2];
          localObject[2] *= d2;
          localObject = this.cii.ciT[2];
          localObject[3] *= d2;
          localObject = this.cii.ciT[3];
          localObject[2] *= d2;
          localObject = this.cii.ciT[3];
          localObject[3] = (d2 * localObject[3]);
          break;
        }
        d1 *= this.cii.ciw;
      }
      label496:
      d2 *= this.cii.ciW;
      d1 += 1.0D;
      break label97;
      label517:
      this.cii.ciT[0][0] = (this.cii.ciT[0][0] + (this.cii.ciT[0][2] + this.cii.ciT[2][0]) * d3 + this.cii.ciT[2][2] * d4);
      this.cii.ciT[1][1] = (this.cii.ciT[1][1] + (this.cii.ciT[1][3] + this.cii.ciT[3][1]) * d3 + d4 * this.cii.ciT[3][3]);
      this.cii.ciT[0][2] += this.cii.ciT[2][2] * d3;
      this.cii.ciT[2][0] += this.cii.ciT[2][2] * d3;
      this.cii.ciT[1][3] += this.cii.ciT[3][3] * d3;
      this.cii.ciT[3][1] += d3 * this.cii.ciT[3][3];
    }
  }
  
  private void bL(boolean paramBoolean)
  {
    AppMethodBeat.i(87969);
    if (this.cih.ciX != paramBoolean)
    {
      this.cih.ciX = paramBoolean;
      if (paramBoolean)
      {
        this.cih.ciw = this.cih.cje[1];
        this.cih.ciN = this.cih.cjd[1];
        a(this.cih.cij, true);
        AppMethodBeat.o(87969);
        return;
      }
      this.cih.ciw = this.cih.cje[0];
      this.cih.ciN = this.cih.cjd[0];
      a(this.cih.cij, true);
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
      paramArrayOfDouble2[0] = ((paramArrayOfDouble1[1] - this.cih.ciO[1]) * 6378137.0D * Math.cos(this.cih.ciO[0]));
      paramArrayOfDouble2[1] = ((paramArrayOfDouble1[0] - this.cih.ciO[0]) * 6378137.0D);
      AppMethodBeat.o(87972);
      return;
      paramArrayOfDouble2[0] = (paramArrayOfDouble1[1] / 6378137.0D + this.cih.ciO[0]);
      paramArrayOfDouble2[1] = (paramArrayOfDouble1[0] / (Math.cos(this.cih.ciO[0]) * 6378137.0D) + this.cih.ciO[1]);
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
      this.cih.ciX = true;
      this.cih.cje[0] = 3.0D;
      this.cih.cje[1] = 1.2D;
      this.cih.cjc = 0.5D;
      this.cih.ciw = 1.2D;
      this.cih.ciC = 4.0D;
      this.cih.ciD = 0;
      this.cih.ciF = true;
      this.cih.ciE = i;
      this.cih.cix = false;
      this.cih.ciA = false;
      this.cih.ciL = 40.0D;
      this.cih.ciM = 0.1570796326794897D;
      this.cih.ciN = 1.0D;
      this.cih.cjd[0] = 400.0D;
      this.cih.cjd[1] = 1.0D;
      this.cih.ciQ = paramBoolean2;
      this.cih.ciR = false;
      this.cih.ciG = true;
      this.cih.ciH = 0.3333333333333333D;
      this.cih.ciI = 5.0D;
      this.cih.ciJ = 0.5D;
      this.cih.ciK = 1.0D;
      this.cih.ciY = 0.5D;
      this.cih.ciZ = 1.0D;
      this.cih.cja = 0;
      this.cih.cjb = 2;
      this.cih.cjf = false;
      this.cih.ciO[0] = arrayOfDouble2[0];
      this.cih.ciO[1] = arrayOfDouble2[1];
      arrayOfDouble2 = new double[2];
      a(0, new double[] { paramDouble1, paramDouble2 }, arrayOfDouble2);
      this.cih.cij = d1;
      this.cih.ciS[0] = arrayOfDouble2[0];
      this.cih.ciS[1] = arrayOfDouble2[1];
      this.cih.ciS[2] = arrayOfDouble1[0];
      this.cih.ciS[3] = arrayOfDouble1[1];
      this.cih.ciU = 0.0D;
      this.cih.ciV = 1.0D;
      this.cih.ciW = 1.005D;
      this.cih.ciT[0][0] = tmp24_22;
      this.cih.ciT[0][1] = 0L;
      this.cih.ciT[0][2] = 0L;
      this.cih.ciT[0][3] = 0L;
      this.cih.ciT[1][0] = 0L;
      this.cih.ciT[1][1] = tmp24_22;
      this.cih.ciT[1][2] = 0L;
      this.cih.ciT[1][3] = 0L;
      this.cih.ciT[2][0] = 0L;
      this.cih.ciT[2][1] = 0L;
      this.cih.ciT[2][2] = 4607182418800017408L;
      this.cih.ciT[2][3] = 0L;
      this.cih.ciT[3][0] = 0L;
      this.cih.ciT[3][1] = 0L;
      this.cih.ciT[3][2] = 0L;
      this.cih.ciT[3][3] = 4607182418800017408L;
      bK(paramBoolean1);
      AppMethodBeat.o(87967);
      return;
    }
  }
  
  protected final void a(j.a parama)
  {
    AppMethodBeat.i(87970);
    if (parama.cio <= 0.0D)
    {
      AppMethodBeat.o(87970);
      return;
    }
    double d1;
    if (this.cih.cix)
    {
      d1 = parama.cij - this.cih.ciz;
      if (d1 < -10.0D)
      {
        AppMethodBeat.o(87970);
        return;
      }
      if (d1 <= 0.0D) {
        parama.cij = (this.cih.ciz + 0.5D);
      }
    }
    double[] arrayOfDouble1 = new double[2];
    a(0, new double[] { parama.cik, parama.cil }, arrayOfDouble1);
    parama.cim[0] = arrayOfDouble1[0];
    parama.cim[1] = arrayOfDouble1[1];
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
    if (this.cih.ciX)
    {
      double d5;
      if ((parama.mType != 3) || (this.cih.cix))
      {
        if (parama.mType != 3) {
          break label1192;
        }
        d5 = parama.cij - this.cih.ciz;
        if (d5 > 0.0D)
        {
          localObject2 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
          localObject1 = new double[2];
          d4 = arrayOfDouble1[0] - this.cih.ciy[0];
          d3 = arrayOfDouble1[1] - this.cih.ciy[1];
          d1 = d3;
          d2 = d4;
          if (this.cih.ciQ)
          {
            d2 = d4 * Math.cos(this.cih.ciU) - Math.sin(this.cih.ciU) * d3;
            d1 = Math.sin(this.cih.ciU);
            d1 = d3 * Math.cos(this.cih.ciU) + d1 * d2;
          }
          d4 = Math.sqrt(d2 * d2 + d1 * d1);
          d3 = d4 / this.cih.ciL;
          d3 *= d3;
          if (d3 <= 0.0625D) {
            break label1176;
          }
          d4 *= this.cih.ciM;
          d4 *= d4;
          if (d4 <= 0.0625D) {
            break label1184;
          }
        }
      }
      for (;;)
      {
        d3 = (d3 + d4) / d5;
        d4 = this.cih.ciT[2][2];
        double d6 = this.cih.ciT[2][3];
        double d7 = this.cih.ciT[3][2];
        double d8 = this.cih.ciT[3][3];
        localObject3 = this.cig;
        a(new double[] { d4, d6, d7, d8 }, (double[])localObject3);
        localObject2[0][0] = this.cig[0];
        localObject2[0][1] = this.cig[1];
        localObject2[1][0] = this.cig[2];
        localObject2[1][1] = this.cig[3];
        d4 = d2 / d5 - this.cih.ciS[2];
        d6 = d1 / d5 - this.cih.ciS[3];
        d7 = localObject2[0][0];
        d8 = localObject2[0][1];
        if (Math.sqrt(d4 * d6 * localObject2[1][0] + (d4 * d4 * d7 + d4 * d6 * d8) + d6 * d6 * localObject2[1][1]) > 2.0D)
        {
          this.cih.ciT[2][2] = this.cih.ciN;
          this.cih.ciT[2][3] = 0L;
          this.cih.ciT[3][2] = 0L;
          this.cih.ciT[3][3] = this.cih.ciN;
          localObject2[0][0] = (1.0D / this.cih.ciN);
          localObject2[0][1] = 0L;
          localObject2[1][0] = 0L;
          localObject2[1][1] = (1.0D / this.cih.ciN);
        }
        localObject1[0] = (localObject2[0][0] * this.cih.ciS[2] + localObject2[0][1] * this.cih.ciS[3]);
        localObject1[1] = (localObject2[1][0] * this.cih.ciS[2] + localObject2[1][1] * this.cih.ciS[3]);
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
        localObject2 = this.cig;
        a(new double[] { d1, d2, d3, d4 }, (double[])localObject2);
        this.cih.ciT[2][2] = this.cig[0];
        this.cih.ciT[2][3] = this.cig[1];
        this.cih.ciT[3][2] = this.cig[2];
        this.cih.ciT[3][3] = this.cig[3];
        this.cih.ciS[2] = (this.cih.ciT[2][2] * localObject1[0] + this.cih.ciT[2][3] * localObject1[1]);
        this.cih.ciS[3] = (this.cih.ciT[3][2] * localObject1[0] + this.cih.ciT[3][3] * localObject1[1]);
        a(parama.cij, false);
        if (parama.mType != 3) {
          break label4325;
        }
        this.cih.ciy[0] = arrayOfDouble1[0];
        this.cih.ciy[1] = arrayOfDouble1[1];
        this.cih.ciz = parama.cij;
        this.cih.cix = true;
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
      a(parama.cij, false);
      if (this.cih.ciG)
      {
        if (!this.cih.ciA)
        {
          i = 1;
          j = 1;
          label1242:
          if (i == 0) {
            break label2043;
          }
          if (this.cih.ciA)
          {
            if (d2 >= d1) {
              break label2045;
            }
            d3 = this.cih.ciJ;
            label1273:
            d1 = d3 + d1 / d2 * (1.0D - d3);
            arrayOfDouble1[0] = (this.cih.ciB[0] + localObject1[0] * d1);
            d2 = this.cih.ciB[1];
            arrayOfDouble1[1] = (d1 * localObject1[1] + d2);
          }
          if (j == 0) {
            break label2057;
          }
          a(arrayOfDouble1);
        }
        for (;;)
        {
          this.cih.ciS[0] = arrayOfDouble1[0];
          this.cih.ciS[1] = arrayOfDouble1[1];
          this.cih.ciT[0][0] = (parama.cio * parama.cio);
          this.cih.ciT[0][1] = 0L;
          this.cih.ciT[1][0] = 0L;
          this.cih.ciT[1][1] = (parama.cio * parama.cio);
          break;
          localObject2[0] = (this.cih.ciS[0] - this.cih.ciB[0]);
          localObject2[1] = (this.cih.ciS[1] - this.cih.ciB[1]);
          arrayOfDouble1[0] -= this.cih.ciB[0];
          arrayOfDouble1[1] -= this.cih.ciB[1];
          d4 = Math.sqrt(localObject2[0] * localObject2[0] + localObject2[1] * localObject2[1]);
          d3 = Math.sqrt(localObject1[0] * localObject1[0] + localObject1[1] * localObject1[1]);
          if ((d3 > this.cih.ciI) && (d4 > this.cih.ciI))
          {
            d1 = d3 / d4;
            d2 = d3 - d4;
            d5 = Math.sqrt(this.cih.ciT[0][0] + this.cih.ciT[1][1]);
            if (d4 > 3.0D * this.cih.ciI)
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
                d1 = d2 / Math.sqrt(this.cih.ciV);
                d2 = Math.sqrt(d1 * d1 + d5 * d5);
                if (d2 >= this.cih.ciC) {
                  break label1826;
                }
                this.cih.cja = 0;
                d1 = d2;
              }
              for (;;)
              {
                if (d1 <= this.cih.ciC) {
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
                if (d5 < this.cih.ciC)
                {
                  localObject2 = this.cih;
                  i = ((b)localObject2).cja + 1;
                  ((b)localObject2).cja = i;
                  d1 = d2;
                  if (i >= this.cih.cjb)
                  {
                    this.cih.cja = 0;
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
            if ((d1 < this.cih.ciH) || (1.0D / d1 < this.cih.ciH))
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
          if (((d3 < this.cih.ciI) && (parama.mType == 2)) || ((d3 < this.cih.ciI * 0.5D) && (parama.mType == 1)))
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
          d3 = this.cih.ciK;
          break label1273;
          label2057:
          this.cih.ciB[0] = arrayOfDouble1[0];
          this.cih.ciB[1] = arrayOfDouble1[1];
        }
      }
      b.a(this.cii, this.cih);
      b(parama.cij, false);
      if (this.cii.ciF) {
        if (!this.cih.ciA)
        {
          d1 = 0.0D;
          label2128:
          if (d1 <= this.cih.ciC) {
            break label3171;
          }
          b.a(this.cii, this.cih);
          b(parama.cij, true);
          if (!this.cih.ciF) {
            break label2881;
          }
          d3 = this.cih.ciB[0] - this.cii.ciS[0];
          d4 = this.cih.ciB[1] - this.cii.ciS[1];
          d1 = this.cih.ciB[0] - arrayOfDouble1[0];
          d2 = this.cih.ciB[1] - arrayOfDouble1[1];
          d3 = Math.sqrt(d3 * d3 + d4 * d4);
          d1 = Math.sqrt(d1 * d1 + d2 * d2);
          d2 = Math.sqrt(this.cii.ciT[0][0] * this.cii.ciT[0][0] + this.cii.ciT[1][1] * this.cii.ciT[1][1]);
          d1 = Math.abs(d3 - d1) / d2;
          label2335:
          if (d1 <= this.cii.ciC) {
            break label3143;
          }
          if (this.cih.ciD >= this.cih.ciE) {
            break label3121;
          }
          this.cih.ciD += 1;
        }
      }
      for (;;)
      {
        this.cih.ciS[0] = arrayOfDouble1[0];
        this.cih.ciS[1] = arrayOfDouble1[1];
        this.cih.ciT[0][0] = (parama.cio * parama.cio);
        this.cih.ciT[0][1] = 0L;
        this.cih.ciT[1][0] = 0L;
        this.cih.ciT[1][1] = (parama.cio * parama.cio);
        break;
        d3 = this.cih.ciB[0] - this.cii.ciS[0];
        d4 = this.cih.ciB[1] - this.cii.ciS[1];
        d1 = this.cih.ciB[0] - arrayOfDouble1[0];
        d2 = this.cih.ciB[1] - arrayOfDouble1[1];
        d3 = Math.sqrt(d3 * d3 + d4 * d4);
        d1 = Math.sqrt(d1 * d1 + d2 * d2);
        d2 = Math.sqrt(this.cih.ciT[0][0] * this.cih.ciT[0][0] + this.cih.ciT[1][1] * this.cih.ciT[1][1]);
        d1 = Math.abs(d3 - d1) / d2;
        break label2128;
        d1 = arrayOfDouble1[0] - this.cii.ciS[0];
        d2 = arrayOfDouble1[1] - this.cii.ciS[1];
        localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
        d3 = 1.0D / (this.cii.ciT[0][0] * this.cii.ciT[1][1] - this.cii.ciT[0][1] * this.cii.ciT[1][0]);
        localObject1[0][0] = (this.cii.ciT[1][1] * d3);
        localObject1[1][1] = (this.cii.ciT[0][0] * d3);
        localObject1[0][1] = (-this.cii.ciT[0][1] * d3);
        localObject1[1][0] = (d3 * -this.cii.ciT[1][0]);
        d3 = localObject1[0][0];
        d4 = localObject1[1][0];
        d1 = Math.sqrt(localObject1[1][1] * (d2 * d2) + (d1 * 2.0D * d2 * d4 + d1 * d1 * d3));
        break label2128;
        label2881:
        d1 = arrayOfDouble1[0] - this.cii.ciS[0];
        d2 = arrayOfDouble1[1] - this.cii.ciS[1];
        localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
        d3 = 1.0D / (this.cii.ciT[0][0] * this.cii.ciT[1][1] - this.cii.ciT[0][1] * this.cii.ciT[1][0]);
        localObject1[0][0] = (this.cii.ciT[1][1] * d3);
        localObject1[1][1] = (this.cii.ciT[0][0] * d3);
        localObject1[0][1] = (-this.cii.ciT[0][1] * d3);
        localObject1[1][0] = (d3 * -this.cii.ciT[1][0]);
        d3 = localObject1[0][0];
        d4 = localObject1[1][0];
        d1 = Math.sqrt(localObject1[1][1] * (d2 * d2) + (d1 * 2.0D * d2 * d4 + d1 * d1 * d3));
        break label2335;
        label3121:
        b.a(this.cih, this.cii);
        this.cih.ciD = 0;
        continue;
        label3143:
        b.a(this.cih, this.cii);
        this.cih.ciD = 0;
        a(arrayOfDouble1);
        continue;
        label3171:
        b.a(this.cih, this.cii);
        this.cih.ciD = 0;
        a(arrayOfDouble1);
      }
    }
    if (parama.mType != 3)
    {
      j = 0;
      localObject2 = new double[2];
      localObject1 = new double[2];
      arrayOfDouble1 = new double[2];
      a(parama.cij, false);
      if (!this.cih.ciA)
      {
        i = 1;
        j = 0;
        this.cih.ciD = 0;
      }
      while (i != 0) {
        if (j == 0)
        {
          this.cih.ciS[0] = parama.cim[0];
          this.cih.ciS[1] = parama.cim[1];
          this.cih.ciS[2] = 0.0D;
          this.cih.ciS[3] = 0.0D;
          this.cih.ciT[0][0] = (parama.cio * parama.cio);
          this.cih.ciT[0][1] = 0L;
          this.cih.ciT[0][2] = 0L;
          this.cih.ciT[0][3] = 0L;
          this.cih.ciT[1][0] = 0L;
          this.cih.ciT[1][1] = this.cih.ciT[0][0];
          this.cih.ciT[1][2] = 0L;
          this.cih.ciT[1][2] = 0L;
          this.cih.ciT[2][0] = 0L;
          this.cih.ciT[2][1] = 0L;
          this.cih.ciT[2][2] = this.cih.ciN;
          this.cih.ciT[2][3] = 0L;
          this.cih.ciT[3][0] = 0L;
          this.cih.ciT[3][1] = 0L;
          this.cih.ciT[3][2] = 0L;
          this.cih.ciT[3][3] = this.cih.ciN;
          this.cih.ciB[0] = parama.cim[0];
          this.cih.ciB[1] = parama.cim[1];
          this.cih.ciA = true;
          AppMethodBeat.o(87970);
          return;
          localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
          localObject2[0] = (parama.cim[0] - this.cih.ciS[0]);
          localObject2[1] = (parama.cim[1] - this.cih.ciS[1]);
          d1 = this.cih.ciT[0][0];
          d2 = this.cih.ciT[0][1];
          d3 = this.cih.ciT[1][0];
          d4 = this.cih.ciT[1][1];
          double[] arrayOfDouble2 = this.cig;
          a(new double[] { d1, d2, d3, d4 }, arrayOfDouble2);
          localObject3[0][0] = this.cig[0];
          localObject3[0][1] = this.cig[1];
          localObject3[1][0] = this.cig[2];
          localObject3[1][1] = this.cig[3];
          if (Math.sqrt(localObject2[0] * localObject2[0] * localObject3[0][0] + 2.0D * localObject2[0] * localObject2[1] * localObject3[1][0] + localObject2[1] * localObject2[1] * localObject3[1][1]) > this.cih.ciC)
          {
            localObject2 = this.cih;
            i = ((b)localObject2).ciD + 1;
            ((b)localObject2).ciD = i;
            if (i >= this.cih.ciE)
            {
              i = 1;
              j = 0;
              this.cih.ciD = 0;
            }
            else
            {
              i = 0;
            }
          }
          else
          {
            this.cih.ciD = 0;
            i = 1;
            j = 1;
          }
        }
        else
        {
          localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 });
          localObject2 = new double[2];
          localObject1[0] = (this.cih.ciS[0] - this.cih.ciB[0]);
          localObject1[1] = (this.cih.ciS[1] - this.cih.ciB[1]);
          arrayOfDouble1[0] = (parama.cim[0] - this.cih.ciB[0]);
          arrayOfDouble1[1] = (parama.cim[1] - this.cih.ciB[1]);
          d2 = Math.sqrt(arrayOfDouble1[0] * arrayOfDouble1[0] + arrayOfDouble1[1] * arrayOfDouble1[1]);
          d1 = localObject1[0];
          d3 = localObject1[0];
          d4 = localObject1[1];
          d4 = Math.sqrt(localObject1[1] * d4 + d1 * d3);
          if (d2 >= d4) {
            break label4331;
          }
          d1 = this.cih.ciY;
          if (a(this.cih.ciT, (double[][])localObject3))
          {
            d3 = 1.0D / (parama.cio * parama.cio);
            localObject1 = new double[4];
            if (!this.cih.cjf) {
              break label4342;
            }
            d1 += d4 / d2 * (1.0D - d1);
            localObject2[0] = (this.cih.ciB[0] + arrayOfDouble1[0] * d1);
            d2 = this.cih.ciB[1];
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
      if (a((double[][])localObject3, this.cih.ciT))
      {
        localObject1[0] += localObject2[0] * d3;
        localObject1[1] += localObject2[1] * d3;
        i = 0;
        if (i < 4) {
          break label4464;
        }
        this.cih.ciB[0] = localObject2[0];
        this.cih.ciB[1] = localObject2[1];
      }
      label4325:
      AppMethodBeat.o(87970);
      return;
      label4331:
      d1 = this.cih.ciZ;
      break;
      label4342:
      localObject2[0] = (this.cih.ciS[0] * (1.0D - d1) + parama.cim[0] * d1);
      d2 = this.cih.ciS[1];
      localObject2[1] = (d1 * parama.cim[1] + d2 * (1.0D - d1));
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
      localObject1[i] += localObject3[i][j] * this.cih.ciS[j];
      j += 1;
    }
    label4464:
    this.cih.ciS[i] = 0.0D;
    j = 0;
    for (;;)
    {
      if (j >= 4)
      {
        i += 1;
        break;
      }
      parama = this.cih.ciS;
      parama[i] += this.cih.ciT[i][j] * localObject1[j];
      j += 1;
    }
  }
  
  protected final void bK(boolean paramBoolean)
  {
    AppMethodBeat.i(87968);
    if (paramBoolean) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      bL(paramBoolean);
      AppMethodBeat.o(87968);
      return;
    }
  }
  
  static final class b
  {
    boolean ciA;
    double[] ciB;
    double ciC;
    int ciD;
    int ciE;
    boolean ciF;
    boolean ciG;
    double ciH;
    double ciI;
    double ciJ;
    double ciK;
    double ciL;
    double ciM;
    double ciN;
    double[] ciO;
    private boolean ciP;
    boolean ciQ;
    boolean ciR;
    double[] ciS;
    double[][] ciT;
    double ciU;
    double ciV;
    double ciW;
    boolean ciX;
    double ciY;
    double ciZ;
    double cij;
    double ciw;
    boolean cix;
    double[] ciy;
    double ciz;
    int cja;
    int cjb;
    double cjc;
    double[] cjd;
    double[] cje;
    boolean cjf;
    
    private b()
    {
      AppMethodBeat.i(87963);
      this.ciy = new double[2];
      this.ciB = new double[2];
      this.ciO = new double[2];
      this.ciS = new double[4];
      this.ciT = ((double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 }));
      this.cjd = new double[2];
      this.cje = new double[2];
      AppMethodBeat.o(87963);
    }
    
    private void a(b paramb)
    {
      AppMethodBeat.i(87964);
      this.ciw = paramb.ciw;
      this.cix = paramb.cix;
      this.ciy = ((double[])paramb.ciy.clone());
      this.ciz = paramb.ciz;
      this.ciA = paramb.ciA;
      this.ciB = ((double[])paramb.ciB.clone());
      this.ciC = paramb.ciC;
      this.ciD = paramb.ciD;
      this.ciE = paramb.ciE;
      this.ciF = paramb.ciF;
      this.ciG = paramb.ciG;
      this.ciH = paramb.ciH;
      this.ciI = paramb.ciI;
      this.ciJ = paramb.ciJ;
      this.ciK = paramb.ciK;
      this.ciL = paramb.ciL;
      this.ciM = paramb.ciM;
      this.ciN = paramb.ciN;
      this.ciO = ((double[])paramb.ciO.clone());
      this.ciP = paramb.ciP;
      this.ciQ = paramb.ciQ;
      this.ciR = paramb.ciR;
      this.cij = paramb.cij;
      this.ciS = ((double[])paramb.ciS.clone());
      this.ciT[0] = ((double[])paramb.ciT[0].clone());
      this.ciT[1] = ((double[])paramb.ciT[1].clone());
      this.ciT[2] = ((double[])paramb.ciT[2].clone());
      this.ciT[3] = ((double[])paramb.ciT[3].clone());
      this.ciU = paramb.ciU;
      this.ciV = paramb.ciV;
      this.ciW = paramb.ciW;
      this.ciX = paramb.ciX;
      this.ciY = paramb.ciY;
      this.ciZ = paramb.ciZ;
      this.cja = paramb.cja;
      this.cjb = paramb.cjb;
      this.cjc = paramb.cjc;
      this.cjd = ((double[])paramb.cjd.clone());
      this.cje = ((double[])paramb.cje.clone());
      this.cjf = paramb.cjf;
      AppMethodBeat.o(87964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.b.a.a.j
 * JD-Core Version:    0.7.0.1
 */