package com.d.a.a;

import java.lang.reflect.Array;

final class j
{
  private double[] aWA = new double[4];
  final j.b aWB = new j.b((byte)0);
  private final j.b aWC = new j.b((byte)0);
  
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
    double d3 = paramDouble - this.aWB.aWD;
    double d4 = d3 * d3;
    double d2;
    double d1;
    label97:
    Object localObject;
    if (paramBoolean)
    {
      this.aWB.aXn[2][2] = this.aWB.aXh;
      this.aWB.aXn[2][3] = 0L;
      this.aWB.aXn[3][2] = 0L;
      this.aWB.aXn[3][3] = this.aWB.aXh;
      if (d3 > 0.5D)
      {
        d2 = 1.0D;
        d1 = 0.0D;
        if (d1 < d3) {
          break label496;
        }
        localObject = this.aWB;
        ((j.b)localObject).aXp = (d2 * ((j.b)localObject).aXp);
      }
      this.aWB.aXm[0] += this.aWB.aXm[2] * d3;
      this.aWB.aXm[1] += this.aWB.aXm[3] * d3;
      if (!this.aWB.aXr) {
        break label517;
      }
      this.aWB.aXn[0][0] += this.aWB.aXn[2][2] * d4;
      this.aWB.aXn[0][1] += this.aWB.aXn[2][3] * d4;
      this.aWB.aXn[1][0] += this.aWB.aXn[3][2] * d4;
      this.aWB.aXn[1][1] += this.aWB.aXn[3][3] * d4;
    }
    for (;;)
    {
      this.aWB.aWD = paramDouble;
      return;
      d1 = 1.0D;
      d2 = d1;
      if (d3 > 0.5D) {}
      for (d2 = 0.0D;; d2 += 1.0D)
      {
        if (d2 >= d3)
        {
          d2 = d1;
          localObject = this.aWB.aXn[2];
          localObject[2] *= d2;
          localObject = this.aWB.aXn[2];
          localObject[3] *= d2;
          localObject = this.aWB.aXn[3];
          localObject[2] *= d2;
          localObject = this.aWB.aXn[3];
          localObject[3] = (d2 * localObject[3]);
          break;
        }
        d1 *= this.aWB.aWQ;
      }
      label496:
      d2 *= this.aWB.aXq;
      d1 += 1.0D;
      break label97;
      label517:
      this.aWB.aXn[0][0] = (this.aWB.aXn[0][0] + (this.aWB.aXn[0][2] + this.aWB.aXn[2][0]) * d3 + this.aWB.aXn[2][2] * d4);
      this.aWB.aXn[1][1] = (this.aWB.aXn[1][1] + (this.aWB.aXn[1][3] + this.aWB.aXn[3][1]) * d3 + d4 * this.aWB.aXn[3][3]);
      this.aWB.aXn[0][2] += this.aWB.aXn[2][2] * d3;
      this.aWB.aXn[2][0] += this.aWB.aXn[2][2] * d3;
      this.aWB.aXn[1][3] += this.aWB.aXn[3][3] * d3;
      this.aWB.aXn[3][1] += d3 * this.aWB.aXn[3][3];
    }
  }
  
  private void b(double[] paramArrayOfDouble)
  {
    double d3;
    double d1;
    double d4;
    int i;
    if ((this.aWB.aXk) && (this.aWB.aWU))
    {
      Object localObject = new double[2];
      double[] arrayOfDouble = new double[2];
      double d5 = this.aWB.aXw;
      localObject[0] = (this.aWB.aXm[0] - this.aWB.aWV[0]);
      localObject[1] = (this.aWB.aXm[1] - this.aWB.aWV[1]);
      paramArrayOfDouble[0] -= this.aWB.aWV[0];
      paramArrayOfDouble[1] -= this.aWB.aWV[1];
      double d2 = Math.sqrt(localObject[0] * localObject[0] + localObject[1] * localObject[1]);
      d3 = Math.sqrt(arrayOfDouble[0] * arrayOfDouble[0] + arrayOfDouble[1] * arrayOfDouble[1]);
      if ((d2 > this.aWB.aXc) && (d3 > this.aWB.aXc))
      {
        d1 = Math.atan2(localObject[1], localObject[0]);
        d4 = Math.atan2(arrayOfDouble[1], arrayOfDouble[0]) - d1;
        if (d4 <= 3.141592653589793D) {
          break label370;
        }
        d1 = d4 - 6.283185307179586D;
        localObject = this.aWB;
        ((j.b)localObject).aXo = (d5 * d1 + ((j.b)localObject).aXo);
        if (d1 * d1 <= 4.0D * this.aWB.aXp) {
          break label392;
        }
        i = 1;
        label278:
        d4 = Math.sqrt(this.aWB.aXn[0][0] + this.aWB.aXn[1][1]);
        if (d2 >= d3) {
          break label398;
        }
        d1 = d2;
        label317:
        d1 = d4 / d1;
        if (i == 0) {
          break label404;
        }
      }
    }
    label392:
    label398:
    label404:
    for (this.aWB.aXp = (d1 * d1);; this.aWB.aXp = (1.0D / (1.0D / (d1 * d1) + 1.0D / this.aWB.aXp)))
    {
      this.aWB.aWV[0] = paramArrayOfDouble[0];
      this.aWB.aWV[1] = paramArrayOfDouble[1];
      this.aWB.aWU = true;
      return;
      label370:
      d1 = d4;
      if (d4 >= -3.141592653589793D) {
        break;
      }
      d1 = d4 + 6.283185307179586D;
      break;
      i = 0;
      break label278;
      d1 = d3;
      break label317;
    }
  }
  
  private static void b(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    double d = 1.0D / (paramArrayOfDouble1[0] * paramArrayOfDouble1[3] - paramArrayOfDouble1[1] * paramArrayOfDouble1[2]);
    paramArrayOfDouble2[0] = (paramArrayOfDouble1[3] * d);
    paramArrayOfDouble2[3] = (paramArrayOfDouble1[0] * d);
    paramArrayOfDouble2[1] = (-paramArrayOfDouble1[1] * d);
    paramArrayOfDouble2[2] = (d * -paramArrayOfDouble1[2]);
  }
  
  private void c(double paramDouble, boolean paramBoolean)
  {
    double d3 = paramDouble - this.aWC.aWD;
    double d4 = d3 * d3;
    double d2;
    double d1;
    label97:
    Object localObject;
    if (paramBoolean)
    {
      this.aWC.aXn[2][2] = this.aWC.aXh;
      this.aWC.aXn[2][3] = 0L;
      this.aWC.aXn[3][2] = 0L;
      this.aWC.aXn[3][3] = this.aWC.aXh;
      if (d3 > 0.5D)
      {
        d2 = 1.0D;
        d1 = 0.0D;
        if (d1 < d3) {
          break label496;
        }
        localObject = this.aWC;
        ((j.b)localObject).aXp = (d2 * ((j.b)localObject).aXp);
      }
      this.aWC.aXm[0] += this.aWC.aXm[2] * d3;
      this.aWC.aXm[1] += this.aWC.aXm[3] * d3;
      if (!this.aWC.aXr) {
        break label517;
      }
      this.aWC.aXn[0][0] += this.aWC.aXn[2][2] * d4;
      this.aWC.aXn[0][1] += this.aWC.aXn[2][3] * d4;
      this.aWC.aXn[1][0] += this.aWC.aXn[3][2] * d4;
      this.aWC.aXn[1][1] += this.aWC.aXn[3][3] * d4;
    }
    for (;;)
    {
      this.aWC.aWD = paramDouble;
      return;
      d1 = 1.0D;
      d2 = d1;
      if (d3 > 0.5D) {}
      for (d2 = 0.0D;; d2 += 1.0D)
      {
        if (d2 >= d3)
        {
          d2 = d1;
          localObject = this.aWC.aXn[2];
          localObject[2] *= d2;
          localObject = this.aWC.aXn[2];
          localObject[3] *= d2;
          localObject = this.aWC.aXn[3];
          localObject[2] *= d2;
          localObject = this.aWC.aXn[3];
          localObject[3] = (d2 * localObject[3]);
          break;
        }
        d1 *= this.aWC.aWQ;
      }
      label496:
      d2 *= this.aWC.aXq;
      d1 += 1.0D;
      break label97;
      label517:
      this.aWC.aXn[0][0] = (this.aWC.aXn[0][0] + (this.aWC.aXn[0][2] + this.aWC.aXn[2][0]) * d3 + this.aWC.aXn[2][2] * d4);
      this.aWC.aXn[1][1] = (this.aWC.aXn[1][1] + (this.aWC.aXn[1][3] + this.aWC.aXn[3][1]) * d3 + d4 * this.aWC.aXn[3][3]);
      this.aWC.aXn[0][2] += this.aWC.aXn[2][2] * d3;
      this.aWC.aXn[2][0] += this.aWC.aXn[2][2] * d3;
      this.aWC.aXn[1][3] += this.aWC.aXn[3][3] * d3;
      this.aWC.aXn[3][1] += d3 * this.aWC.aXn[3][3];
    }
  }
  
  final void a(int paramInt, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramArrayOfDouble2[0] = ((paramArrayOfDouble1[1] - this.aWB.aXi[1]) * 6378137.0D * Math.cos(this.aWB.aXi[0]));
      paramArrayOfDouble2[1] = ((paramArrayOfDouble1[0] - this.aWB.aXi[0]) * 6378137.0D);
      return;
    }
    paramArrayOfDouble2[0] = (paramArrayOfDouble1[1] / 6378137.0D + this.aWB.aXi[0]);
    paramArrayOfDouble2[1] = (paramArrayOfDouble1[0] / (Math.cos(this.aWB.aXi[0]) * 6378137.0D) + this.aWB.aXi[1]);
  }
  
  protected final void a(long paramLong, double paramDouble1, double paramDouble2, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    double d1 = paramLong;
    double d2 = paramFloat * paramFloat;
    double[] arrayOfDouble1 = new double[2];
    double[] tmp19_17 = arrayOfDouble1;
    tmp19_17[0] = 0.0D;
    double[] tmp23_19 = tmp19_17;
    tmp23_19[1] = 0.0D;
    tmp23_19;
    if (paramBoolean1) {}
    for (int i = 3;; i = 5)
    {
      double[] arrayOfDouble2 = new double[2];
      arrayOfDouble2[0] = paramDouble1;
      arrayOfDouble2[1] = paramDouble2;
      this.aWB.aXr = true;
      this.aWB.aXy[0] = 3.0D;
      this.aWB.aXy[1] = 1.2D;
      this.aWB.aXw = 0.5D;
      this.aWB.aWQ = 1.2D;
      this.aWB.aWW = 4.0D;
      this.aWB.aWX = 0;
      this.aWB.aWZ = true;
      this.aWB.aWY = i;
      this.aWB.aWR = false;
      this.aWB.aWU = false;
      this.aWB.aXf = 40.0D;
      this.aWB.aXg = 0.1570796326794897D;
      this.aWB.aXh = 1.0D;
      this.aWB.aXx[0] = 400.0D;
      this.aWB.aXx[1] = 1.0D;
      this.aWB.aXk = paramBoolean2;
      this.aWB.aXl = false;
      this.aWB.aXa = true;
      this.aWB.aXb = 0.3333333333333333D;
      this.aWB.aXc = 5.0D;
      this.aWB.aXd = 0.5D;
      this.aWB.aXe = 1.0D;
      this.aWB.aXs = 0.5D;
      this.aWB.aXt = 1.0D;
      this.aWB.aXu = 0;
      this.aWB.aXv = 2;
      this.aWB.aXz = false;
      this.aWB.aXi[0] = arrayOfDouble2[0];
      this.aWB.aXi[1] = arrayOfDouble2[1];
      arrayOfDouble2 = new double[2];
      a(0, new double[] { paramDouble1, paramDouble2 }, arrayOfDouble2);
      this.aWB.aWD = d1;
      this.aWB.aXm[0] = arrayOfDouble2[0];
      this.aWB.aXm[1] = arrayOfDouble2[1];
      this.aWB.aXm[2] = arrayOfDouble1[0];
      this.aWB.aXm[3] = arrayOfDouble1[1];
      this.aWB.aXo = 0.0D;
      this.aWB.aXp = 1.0D;
      this.aWB.aXq = 1.005D;
      this.aWB.aXn[0][0] = tmp19_17;
      this.aWB.aXn[0][1] = 0L;
      this.aWB.aXn[0][2] = 0L;
      this.aWB.aXn[0][3] = 0L;
      this.aWB.aXn[1][0] = 0L;
      this.aWB.aXn[1][1] = tmp19_17;
      this.aWB.aXn[1][2] = 0L;
      this.aWB.aXn[1][3] = 0L;
      this.aWB.aXn[2][0] = 0L;
      this.aWB.aXn[2][1] = 0L;
      this.aWB.aXn[2][2] = 4607182418800017408L;
      this.aWB.aXn[2][3] = 0L;
      this.aWB.aXn[3][0] = 0L;
      this.aWB.aXn[3][1] = 0L;
      this.aWB.aXn[3][2] = 0L;
      this.aWB.aXn[3][3] = 4607182418800017408L;
      aH(paramBoolean1);
      return;
    }
  }
  
  protected final void a(j.a parama)
  {
    if (parama.aWI <= 0.0D) {}
    double[] arrayOfDouble1;
    Object localObject1;
    label1101:
    int i;
    for (;;)
    {
      return;
      if (this.aWB.aWR)
      {
        d1 = parama.aWD - this.aWB.aWT;
        if (d1 < -10.0D) {
          continue;
        }
        if (d1 <= 0.0D) {
          parama.aWD = (this.aWB.aWT + 0.5D);
        }
      }
      arrayOfDouble1 = new double[2];
      a(0, new double[] { parama.aWE, parama.aWF }, arrayOfDouble1);
      parama.aWG[0] = arrayOfDouble1[0];
      parama.aWG[1] = arrayOfDouble1[1];
      if (this.aWB.aXr)
      {
        double d5;
        if ((parama.mType != 3) || (this.aWB.aWR))
        {
          if (parama.mType != 3) {
            break label1171;
          }
          d5 = parama.aWD - this.aWB.aWT;
          if (d5 > 0.0D)
          {
            localObject2 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
            localObject1 = new double[2];
            d4 = arrayOfDouble1[0] - this.aWB.aWS[0];
            d3 = arrayOfDouble1[1] - this.aWB.aWS[1];
            d1 = d3;
            d2 = d4;
            if (this.aWB.aXk)
            {
              d2 = d4 * Math.cos(this.aWB.aXo) - Math.sin(this.aWB.aXo) * d3;
              d1 = Math.sin(this.aWB.aXo);
              d1 = d3 * Math.cos(this.aWB.aXo) + d1 * d2;
            }
            d4 = Math.sqrt(d2 * d2 + d1 * d1);
            d3 = d4 / this.aWB.aXf;
            d3 *= d3;
            if (d3 <= 0.0625D) {
              break label1155;
            }
            d4 *= this.aWB.aXg;
            d4 *= d4;
            if (d4 <= 0.0625D) {
              break label1163;
            }
          }
        }
        for (;;)
        {
          d3 = (d3 + d4) / d5;
          d4 = this.aWB.aXn[2][2];
          double d6 = this.aWB.aXn[2][3];
          double d7 = this.aWB.aXn[3][2];
          double d8 = this.aWB.aXn[3][3];
          localObject3 = this.aWA;
          b(new double[] { d4, d6, d7, d8 }, (double[])localObject3);
          localObject2[0][0] = this.aWA[0];
          localObject2[0][1] = this.aWA[1];
          localObject2[1][0] = this.aWA[2];
          localObject2[1][1] = this.aWA[3];
          d4 = d2 / d5 - this.aWB.aXm[2];
          d6 = d1 / d5 - this.aWB.aXm[3];
          d7 = localObject2[0][0];
          d8 = localObject2[0][1];
          if (Math.sqrt(d4 * d6 * localObject2[1][0] + (d4 * d4 * d7 + d4 * d6 * d8) + d6 * d6 * localObject2[1][1]) > 2.0D)
          {
            this.aWB.aXn[2][2] = this.aWB.aXh;
            this.aWB.aXn[2][3] = 0L;
            this.aWB.aXn[3][2] = 0L;
            this.aWB.aXn[3][3] = this.aWB.aXh;
            localObject2[0][0] = (1.0D / this.aWB.aXh);
            localObject2[0][1] = 0L;
            localObject2[1][0] = 0L;
            localObject2[1][1] = (1.0D / this.aWB.aXh);
          }
          localObject1[0] = (localObject2[0][0] * this.aWB.aXm[2] + localObject2[0][1] * this.aWB.aXm[3]);
          localObject1[1] = (localObject2[1][0] * this.aWB.aXm[2] + localObject2[1][1] * this.aWB.aXm[3]);
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
          localObject2 = this.aWA;
          b(new double[] { d1, d2, d3, d4 }, (double[])localObject2);
          this.aWB.aXn[2][2] = this.aWA[0];
          this.aWB.aXn[2][3] = this.aWA[1];
          this.aWB.aXn[3][2] = this.aWA[2];
          this.aWB.aXn[3][3] = this.aWA[3];
          this.aWB.aXm[2] = (this.aWB.aXn[2][2] * localObject1[0] + this.aWB.aXn[2][3] * localObject1[1]);
          this.aWB.aXm[3] = (this.aWB.aXn[3][2] * localObject1[0] + this.aWB.aXn[3][3] * localObject1[1]);
          b(parama.aWD, false);
          if (parama.mType != 3) {
            break label2450;
          }
          this.aWB.aWS[0] = arrayOfDouble1[0];
          this.aWB.aWS[1] = arrayOfDouble1[1];
          this.aWB.aWT = parama.aWD;
          this.aWB.aWR = true;
          return;
          label1155:
          d3 = 0.0625D;
          break;
          label1163:
          d4 = 0.0625D;
        }
        label1171:
        d2 = 0.0D;
        d1 = 0.0D;
        localObject2 = new double[2];
        localObject1 = new double[2];
        b(parama.aWD, false);
        if (this.aWB.aXa)
        {
          if (!this.aWB.aWU)
          {
            i = 1;
            j = 1;
            label1221:
            if (i == 0) {
              break label2022;
            }
            if (this.aWB.aWU)
            {
              if (d2 >= d1) {
                break label2024;
              }
              d3 = this.aWB.aXd;
              label1252:
              d1 = d3 + d1 / d2 * (1.0D - d3);
              arrayOfDouble1[0] = (this.aWB.aWV[0] + localObject1[0] * d1);
              d2 = this.aWB.aWV[1];
              arrayOfDouble1[1] = (d1 * localObject1[1] + d2);
            }
            if (j == 0) {
              break label2036;
            }
            b(arrayOfDouble1);
          }
          for (;;)
          {
            this.aWB.aXm[0] = arrayOfDouble1[0];
            this.aWB.aXm[1] = arrayOfDouble1[1];
            this.aWB.aXn[0][0] = (parama.aWI * parama.aWI);
            this.aWB.aXn[0][1] = 0L;
            this.aWB.aXn[1][0] = 0L;
            this.aWB.aXn[1][1] = (parama.aWI * parama.aWI);
            break;
            localObject2[0] = (this.aWB.aXm[0] - this.aWB.aWV[0]);
            localObject2[1] = (this.aWB.aXm[1] - this.aWB.aWV[1]);
            arrayOfDouble1[0] -= this.aWB.aWV[0];
            arrayOfDouble1[1] -= this.aWB.aWV[1];
            d4 = Math.sqrt(localObject2[0] * localObject2[0] + localObject2[1] * localObject2[1]);
            d3 = Math.sqrt(localObject1[0] * localObject1[0] + localObject1[1] * localObject1[1]);
            if ((d3 > this.aWB.aXc) && (d4 > this.aWB.aXc))
            {
              d1 = d3 / d4;
              d2 = d3 - d4;
              d5 = Math.sqrt(this.aWB.aXn[0][0] + this.aWB.aXn[1][1]);
              if (d4 > 3.0D * this.aWB.aXc)
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
                  label1690:
                  d2 = d1;
                  if (d1 < 0.0D) {
                    d2 = -d1;
                  }
                  d1 = d2 / Math.sqrt(this.aWB.aXp);
                  d2 = Math.sqrt(d1 * d1 + d5 * d5);
                  if (d2 >= this.aWB.aWW) {
                    break label1805;
                  }
                  this.aWB.aXu = 0;
                  d1 = d2;
                }
                for (;;)
                {
                  if (d1 <= this.aWB.aWW) {
                    break label1872;
                  }
                  i = 0;
                  j = 0;
                  d1 = d4;
                  d2 = d3;
                  break;
                  d1 = d2;
                  if (d2 >= -3.141592653589793D) {
                    break label1690;
                  }
                  d1 = d2 + 6.283185307179586D;
                  break label1690;
                  label1805:
                  d1 = d2;
                  if (d5 < this.aWB.aWW)
                  {
                    localObject2 = this.aWB;
                    i = ((j.b)localObject2).aXu + 1;
                    ((j.b)localObject2).aXu = i;
                    d1 = d2;
                    if (i >= this.aWB.aXv)
                    {
                      this.aWB.aXu = 0;
                      d1 = d5;
                    }
                  }
                }
                label1872:
                i = 1;
                j = 1;
                d1 = d4;
                d2 = d3;
                break label1221;
              }
              if ((d1 < this.aWB.aXb) || (1.0D / d1 < this.aWB.aXb))
              {
                i = 0;
                j = 0;
                d1 = d4;
                d2 = d3;
                break label1221;
              }
              i = 1;
              j = 0;
              d1 = d4;
              d2 = d3;
              break label1221;
            }
            if (((d3 < this.aWB.aXc) && (parama.mType == 2)) || ((d3 < this.aWB.aXc * 0.5D) && (parama.mType == 1)))
            {
              i = 0;
              j = 0;
              d1 = d4;
              d2 = d3;
              break label1221;
            }
            i = 1;
            j = 0;
            d1 = d4;
            d2 = d3;
            break label1221;
            label2022:
            break;
            label2024:
            d3 = this.aWB.aXe;
            break label1252;
            label2036:
            this.aWB.aWV[0] = arrayOfDouble1[0];
            this.aWB.aWV[1] = arrayOfDouble1[1];
          }
        }
        j.b.a(this.aWC, this.aWB);
        c(parama.aWD, false);
        if (this.aWC.aWZ) {
          if (!this.aWB.aWU)
          {
            d1 = 0.0D;
            label2107:
            if (d1 <= this.aWB.aWW) {
              break label3150;
            }
            j.b.a(this.aWC, this.aWB);
            c(parama.aWD, true);
            if (!this.aWB.aWZ) {
              break label2860;
            }
            d3 = this.aWB.aWV[0] - this.aWC.aXm[0];
            d4 = this.aWB.aWV[1] - this.aWC.aXm[1];
            d1 = this.aWB.aWV[0] - arrayOfDouble1[0];
            d2 = this.aWB.aWV[1] - arrayOfDouble1[1];
            d3 = Math.sqrt(d3 * d3 + d4 * d4);
            d1 = Math.sqrt(d1 * d1 + d2 * d2);
            d2 = Math.sqrt(this.aWC.aXn[0][0] * this.aWC.aXn[0][0] + this.aWC.aXn[1][1] * this.aWC.aXn[1][1]);
            d1 = Math.abs(d3 - d1) / d2;
            label2314:
            if (d1 <= this.aWC.aWW) {
              break label3122;
            }
            if (this.aWB.aWX >= this.aWB.aWY) {
              break label3100;
            }
            this.aWB.aWX += 1;
          }
        }
        for (;;)
        {
          this.aWB.aXm[0] = arrayOfDouble1[0];
          this.aWB.aXm[1] = arrayOfDouble1[1];
          this.aWB.aXn[0][0] = (parama.aWI * parama.aWI);
          this.aWB.aXn[0][1] = 0L;
          this.aWB.aXn[1][0] = 0L;
          this.aWB.aXn[1][1] = (parama.aWI * parama.aWI);
          break label1101;
          label2450:
          break;
          d3 = this.aWB.aWV[0] - this.aWC.aXm[0];
          d4 = this.aWB.aWV[1] - this.aWC.aXm[1];
          d1 = this.aWB.aWV[0] - arrayOfDouble1[0];
          d2 = this.aWB.aWV[1] - arrayOfDouble1[1];
          d3 = Math.sqrt(d3 * d3 + d4 * d4);
          d1 = Math.sqrt(d1 * d1 + d2 * d2);
          d2 = Math.sqrt(this.aWB.aXn[0][0] * this.aWB.aXn[0][0] + this.aWB.aXn[1][1] * this.aWB.aXn[1][1]);
          d1 = Math.abs(d3 - d1) / d2;
          break label2107;
          d1 = arrayOfDouble1[0] - this.aWC.aXm[0];
          d2 = arrayOfDouble1[1] - this.aWC.aXm[1];
          localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
          d3 = 1.0D / (this.aWC.aXn[0][0] * this.aWC.aXn[1][1] - this.aWC.aXn[0][1] * this.aWC.aXn[1][0]);
          localObject1[0][0] = (this.aWC.aXn[1][1] * d3);
          localObject1[1][1] = (this.aWC.aXn[0][0] * d3);
          localObject1[0][1] = (-this.aWC.aXn[0][1] * d3);
          localObject1[1][0] = (d3 * -this.aWC.aXn[1][0]);
          d3 = localObject1[0][0];
          d4 = localObject1[1][0];
          d1 = Math.sqrt(localObject1[1][1] * (d2 * d2) + (d1 * 2.0D * d2 * d4 + d1 * d1 * d3));
          break label2107;
          label2860:
          d1 = arrayOfDouble1[0] - this.aWC.aXm[0];
          d2 = arrayOfDouble1[1] - this.aWC.aXm[1];
          localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
          d3 = 1.0D / (this.aWC.aXn[0][0] * this.aWC.aXn[1][1] - this.aWC.aXn[0][1] * this.aWC.aXn[1][0]);
          localObject1[0][0] = (this.aWC.aXn[1][1] * d3);
          localObject1[1][1] = (this.aWC.aXn[0][0] * d3);
          localObject1[0][1] = (-this.aWC.aXn[0][1] * d3);
          localObject1[1][0] = (d3 * -this.aWC.aXn[1][0]);
          d3 = localObject1[0][0];
          d4 = localObject1[1][0];
          d1 = Math.sqrt(localObject1[1][1] * (d2 * d2) + (d1 * 2.0D * d2 * d4 + d1 * d1 * d3));
          break label2314;
          label3100:
          j.b.a(this.aWB, this.aWC);
          this.aWB.aWX = 0;
          continue;
          label3122:
          j.b.a(this.aWB, this.aWC);
          this.aWB.aWX = 0;
          b(arrayOfDouble1);
          continue;
          label3150:
          j.b.a(this.aWB, this.aWC);
          this.aWB.aWX = 0;
          b(arrayOfDouble1);
        }
      }
      if (parama.mType != 3)
      {
        localObject2 = new double[2];
        localObject1 = new double[2];
        arrayOfDouble1 = new double[2];
        b(parama.aWD, false);
        if (!this.aWB.aWU)
        {
          i = 0;
          this.aWB.aWX = 0;
          j = 1;
        }
        while (j != 0)
        {
          if (i != 0) {
            break label3894;
          }
          this.aWB.aXm[0] = parama.aWG[0];
          this.aWB.aXm[1] = parama.aWG[1];
          this.aWB.aXm[2] = 0.0D;
          this.aWB.aXm[3] = 0.0D;
          this.aWB.aXn[0][0] = (parama.aWI * parama.aWI);
          this.aWB.aXn[0][1] = 0L;
          this.aWB.aXn[0][2] = 0L;
          this.aWB.aXn[0][3] = 0L;
          this.aWB.aXn[1][0] = 0L;
          this.aWB.aXn[1][1] = this.aWB.aXn[0][0];
          this.aWB.aXn[1][2] = 0L;
          this.aWB.aXn[1][2] = 0L;
          this.aWB.aXn[2][0] = 0L;
          this.aWB.aXn[2][1] = 0L;
          this.aWB.aXn[2][2] = this.aWB.aXh;
          this.aWB.aXn[2][3] = 0L;
          this.aWB.aXn[3][0] = 0L;
          this.aWB.aXn[3][1] = 0L;
          this.aWB.aXn[3][2] = 0L;
          this.aWB.aXn[3][3] = this.aWB.aXh;
          this.aWB.aWV[0] = parama.aWG[0];
          this.aWB.aWV[1] = parama.aWG[1];
          this.aWB.aWU = true;
          return;
          localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
          localObject2[0] = (parama.aWG[0] - this.aWB.aXm[0]);
          localObject2[1] = (parama.aWG[1] - this.aWB.aXm[1]);
          d1 = this.aWB.aXn[0][0];
          d2 = this.aWB.aXn[0][1];
          d3 = this.aWB.aXn[1][0];
          d4 = this.aWB.aXn[1][1];
          double[] arrayOfDouble2 = this.aWA;
          b(new double[] { d1, d2, d3, d4 }, arrayOfDouble2);
          localObject3[0][0] = this.aWA[0];
          localObject3[0][1] = this.aWA[1];
          localObject3[1][0] = this.aWA[2];
          localObject3[1][1] = this.aWA[3];
          if (Math.sqrt(localObject2[0] * localObject2[0] * localObject3[0][0] + 2.0D * localObject2[0] * localObject2[1] * localObject3[1][0] + localObject2[1] * localObject2[1] * localObject3[1][1]) > this.aWB.aWW)
          {
            localObject2 = this.aWB;
            i = ((j.b)localObject2).aWX + 1;
            ((j.b)localObject2).aWX = i;
            if (i >= this.aWB.aWY)
            {
              i = 0;
              this.aWB.aWX = 0;
              j = 1;
            }
            else
            {
              j = 0;
              i = 0;
            }
          }
          else
          {
            this.aWB.aWX = 0;
            i = 1;
            j = 1;
          }
        }
      }
    }
    label3894:
    Object localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 });
    Object localObject2 = new double[2];
    localObject1[0] = (this.aWB.aXm[0] - this.aWB.aWV[0]);
    localObject1[1] = (this.aWB.aXm[1] - this.aWB.aWV[1]);
    arrayOfDouble1[0] = (parama.aWG[0] - this.aWB.aWV[0]);
    arrayOfDouble1[1] = (parama.aWG[1] - this.aWB.aWV[1]);
    double d2 = Math.sqrt(arrayOfDouble1[0] * arrayOfDouble1[0] + arrayOfDouble1[1] * arrayOfDouble1[1]);
    double d1 = localObject1[0];
    double d3 = localObject1[0];
    double d4 = localObject1[1];
    d4 = Math.sqrt(localObject1[1] * d4 + d1 * d3);
    if (d2 < d4)
    {
      d1 = this.aWB.aXs;
      label4081:
      if (!a(this.aWB.aXn, (double[][])localObject3)) {
        break label4309;
      }
      d3 = 1.0D / (parama.aWI * parama.aWI);
      localObject1 = new double[4];
      if (!this.aWB.aXz) {
        break label4311;
      }
      d1 += d4 / d2 * (1.0D - d1);
      localObject2[0] = (this.aWB.aWV[0] + arrayOfDouble1[0] * d1);
      d2 = this.aWB.aWV[1];
      localObject2[1] = (d1 * arrayOfDouble1[1] + d2);
    }
    for (;;)
    {
      i = 0;
      if (i < 4) {
        break label4370;
      }
      parama = localObject3[0];
      parama[0] += d3;
      parama = localObject3[1];
      parama[1] += d3;
      if (!a((double[][])localObject3, this.aWB.aXn)) {
        break;
      }
      localObject1[0] += localObject2[0] * d3;
      localObject1[1] += localObject2[1] * d3;
      i = 0;
      if (i < 4) {
        break label4433;
      }
      this.aWB.aWV[0] = localObject2[0];
      this.aWB.aWV[1] = localObject2[1];
      return;
      d1 = this.aWB.aXt;
      break label4081;
      label4309:
      break;
      label4311:
      localObject2[0] = (this.aWB.aXm[0] * (1.0D - d1) + parama.aWG[0] * d1);
      d2 = this.aWB.aXm[1];
      localObject2[1] = (d1 * parama.aWG[1] + d2 * (1.0D - d1));
    }
    label4370:
    localObject1[i] = 0.0D;
    int j = 0;
    for (;;)
    {
      if (j >= 4)
      {
        i += 1;
        break;
      }
      localObject1[i] += localObject3[i][j] * this.aWB.aXm[j];
      j += 1;
    }
    label4433:
    this.aWB.aXm[i] = 0.0D;
    j = 0;
    for (;;)
    {
      if (j >= 4)
      {
        i += 1;
        break;
      }
      parama = this.aWB.aXm;
      parama[i] += this.aWB.aXn[i][j] * localObject1[j];
      j += 1;
    }
  }
  
  protected final void aH(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      if (this.aWB.aXr != paramBoolean)
      {
        this.aWB.aXr = paramBoolean;
        if (!paramBoolean) {
          break;
        }
        this.aWB.aWQ = this.aWB.aXy[1];
        this.aWB.aXh = this.aWB.aXx[1];
        b(this.aWB.aWD, true);
      }
      return;
    }
    this.aWB.aWQ = this.aWB.aXy[0];
    this.aWB.aXh = this.aWB.aXx[0];
    b(this.aWB.aWD, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.d.a.a.j
 * JD-Core Version:    0.7.0.1
 */