package com.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

final class j
{
  final b bXA;
  private final b bXB;
  private double[] bXz;
  
  j()
  {
    AppMethodBeat.i(87966);
    this.bXz = new double[4];
    this.bXA = new b((byte)0);
    this.bXB = new b((byte)0);
    AppMethodBeat.o(87966);
  }
  
  private void a(double paramDouble, boolean paramBoolean)
  {
    double d3 = paramDouble - this.bXA.bXC;
    double d4 = d3 * d3;
    double d2;
    double d1;
    label97:
    Object localObject;
    if (paramBoolean)
    {
      this.bXA.bYm[2][2] = this.bXA.bYg;
      this.bXA.bYm[2][3] = 0L;
      this.bXA.bYm[3][2] = 0L;
      this.bXA.bYm[3][3] = this.bXA.bYg;
      if (d3 > 0.5D)
      {
        d2 = 1.0D;
        d1 = 0.0D;
        if (d1 < d3) {
          break label496;
        }
        localObject = this.bXA;
        ((b)localObject).bYo = (d2 * ((b)localObject).bYo);
      }
      this.bXA.bYl[0] += this.bXA.bYl[2] * d3;
      this.bXA.bYl[1] += this.bXA.bYl[3] * d3;
      if (!this.bXA.bYq) {
        break label517;
      }
      this.bXA.bYm[0][0] += this.bXA.bYm[2][2] * d4;
      this.bXA.bYm[0][1] += this.bXA.bYm[2][3] * d4;
      this.bXA.bYm[1][0] += this.bXA.bYm[3][2] * d4;
      this.bXA.bYm[1][1] += this.bXA.bYm[3][3] * d4;
    }
    for (;;)
    {
      this.bXA.bXC = paramDouble;
      return;
      d1 = 1.0D;
      d2 = d1;
      if (d3 > 0.5D) {}
      for (d2 = 0.0D;; d2 += 1.0D)
      {
        if (d2 >= d3)
        {
          d2 = d1;
          localObject = this.bXA.bYm[2];
          localObject[2] *= d2;
          localObject = this.bXA.bYm[2];
          localObject[3] *= d2;
          localObject = this.bXA.bYm[3];
          localObject[2] *= d2;
          localObject = this.bXA.bYm[3];
          localObject[3] = (d2 * localObject[3]);
          break;
        }
        d1 *= this.bXA.bXP;
      }
      label496:
      d2 *= this.bXA.bYp;
      d1 += 1.0D;
      break label97;
      label517:
      this.bXA.bYm[0][0] = (this.bXA.bYm[0][0] + (this.bXA.bYm[0][2] + this.bXA.bYm[2][0]) * d3 + this.bXA.bYm[2][2] * d4);
      this.bXA.bYm[1][1] = (this.bXA.bYm[1][1] + (this.bXA.bYm[1][3] + this.bXA.bYm[3][1]) * d3 + d4 * this.bXA.bYm[3][3]);
      this.bXA.bYm[0][2] += this.bXA.bYm[2][2] * d3;
      this.bXA.bYm[2][0] += this.bXA.bYm[2][2] * d3;
      this.bXA.bYm[1][3] += this.bXA.bYm[3][3] * d3;
      this.bXA.bYm[3][1] += d3 * this.bXA.bYm[3][3];
    }
  }
  
  private void a(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(87971);
    double d3;
    double d1;
    double d4;
    int i;
    if ((this.bXA.bYj) && (this.bXA.bXT))
    {
      Object localObject = new double[2];
      double[] arrayOfDouble = new double[2];
      double d5 = this.bXA.bYv;
      localObject[0] = (this.bXA.bYl[0] - this.bXA.bXU[0]);
      localObject[1] = (this.bXA.bYl[1] - this.bXA.bXU[1]);
      paramArrayOfDouble[0] -= this.bXA.bXU[0];
      paramArrayOfDouble[1] -= this.bXA.bXU[1];
      double d2 = Math.sqrt(localObject[0] * localObject[0] + localObject[1] * localObject[1]);
      d3 = Math.sqrt(arrayOfDouble[0] * arrayOfDouble[0] + arrayOfDouble[1] * arrayOfDouble[1]);
      if ((d2 > this.bXA.bYb) && (d3 > this.bXA.bYb))
      {
        d1 = Math.atan2(localObject[1], localObject[0]);
        d4 = Math.atan2(arrayOfDouble[1], arrayOfDouble[0]) - d1;
        if (d4 <= 3.141592653589793D) {
          break label380;
        }
        d1 = d4 - 6.283185307179586D;
        localObject = this.bXA;
        ((b)localObject).bYn = (d5 * d1 + ((b)localObject).bYn);
        if (d1 * d1 <= 4.0D * this.bXA.bYo) {
          break label402;
        }
        i = 1;
        label283:
        d4 = Math.sqrt(this.bXA.bYm[0][0] + this.bXA.bYm[1][1]);
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
    for (this.bXA.bYo = (d1 * d1);; this.bXA.bYo = (1.0D / (1.0D / (d1 * d1) + 1.0D / this.bXA.bYo)))
    {
      this.bXA.bXU[0] = paramArrayOfDouble[0];
      this.bXA.bXU[1] = paramArrayOfDouble[1];
      this.bXA.bXT = true;
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
    double d3 = paramDouble - this.bXB.bXC;
    double d4 = d3 * d3;
    double d2;
    double d1;
    label97:
    Object localObject;
    if (paramBoolean)
    {
      this.bXB.bYm[2][2] = this.bXB.bYg;
      this.bXB.bYm[2][3] = 0L;
      this.bXB.bYm[3][2] = 0L;
      this.bXB.bYm[3][3] = this.bXB.bYg;
      if (d3 > 0.5D)
      {
        d2 = 1.0D;
        d1 = 0.0D;
        if (d1 < d3) {
          break label496;
        }
        localObject = this.bXB;
        ((b)localObject).bYo = (d2 * ((b)localObject).bYo);
      }
      this.bXB.bYl[0] += this.bXB.bYl[2] * d3;
      this.bXB.bYl[1] += this.bXB.bYl[3] * d3;
      if (!this.bXB.bYq) {
        break label517;
      }
      this.bXB.bYm[0][0] += this.bXB.bYm[2][2] * d4;
      this.bXB.bYm[0][1] += this.bXB.bYm[2][3] * d4;
      this.bXB.bYm[1][0] += this.bXB.bYm[3][2] * d4;
      this.bXB.bYm[1][1] += this.bXB.bYm[3][3] * d4;
    }
    for (;;)
    {
      this.bXB.bXC = paramDouble;
      return;
      d1 = 1.0D;
      d2 = d1;
      if (d3 > 0.5D) {}
      for (d2 = 0.0D;; d2 += 1.0D)
      {
        if (d2 >= d3)
        {
          d2 = d1;
          localObject = this.bXB.bYm[2];
          localObject[2] *= d2;
          localObject = this.bXB.bYm[2];
          localObject[3] *= d2;
          localObject = this.bXB.bYm[3];
          localObject[2] *= d2;
          localObject = this.bXB.bYm[3];
          localObject[3] = (d2 * localObject[3]);
          break;
        }
        d1 *= this.bXB.bXP;
      }
      label496:
      d2 *= this.bXB.bYp;
      d1 += 1.0D;
      break label97;
      label517:
      this.bXB.bYm[0][0] = (this.bXB.bYm[0][0] + (this.bXB.bYm[0][2] + this.bXB.bYm[2][0]) * d3 + this.bXB.bYm[2][2] * d4);
      this.bXB.bYm[1][1] = (this.bXB.bYm[1][1] + (this.bXB.bYm[1][3] + this.bXB.bYm[3][1]) * d3 + d4 * this.bXB.bYm[3][3]);
      this.bXB.bYm[0][2] += this.bXB.bYm[2][2] * d3;
      this.bXB.bYm[2][0] += this.bXB.bYm[2][2] * d3;
      this.bXB.bYm[1][3] += this.bXB.bYm[3][3] * d3;
      this.bXB.bYm[3][1] += d3 * this.bXB.bYm[3][3];
    }
  }
  
  private void bl(boolean paramBoolean)
  {
    AppMethodBeat.i(87969);
    if (this.bXA.bYq != paramBoolean)
    {
      this.bXA.bYq = paramBoolean;
      if (paramBoolean)
      {
        this.bXA.bXP = this.bXA.bYx[1];
        this.bXA.bYg = this.bXA.bYw[1];
        a(this.bXA.bXC, true);
        AppMethodBeat.o(87969);
        return;
      }
      this.bXA.bXP = this.bXA.bYx[0];
      this.bXA.bYg = this.bXA.bYw[0];
      a(this.bXA.bXC, true);
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
      paramArrayOfDouble2[0] = ((paramArrayOfDouble1[1] - this.bXA.bYh[1]) * 6378137.0D * Math.cos(this.bXA.bYh[0]));
      paramArrayOfDouble2[1] = ((paramArrayOfDouble1[0] - this.bXA.bYh[0]) * 6378137.0D);
      AppMethodBeat.o(87972);
      return;
      paramArrayOfDouble2[0] = (paramArrayOfDouble1[1] / 6378137.0D + this.bXA.bYh[0]);
      paramArrayOfDouble2[1] = (paramArrayOfDouble1[0] / (Math.cos(this.bXA.bYh[0]) * 6378137.0D) + this.bXA.bYh[1]);
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
      this.bXA.bYq = true;
      this.bXA.bYx[0] = 3.0D;
      this.bXA.bYx[1] = 1.2D;
      this.bXA.bYv = 0.5D;
      this.bXA.bXP = 1.2D;
      this.bXA.bXV = 4.0D;
      this.bXA.bXW = 0;
      this.bXA.bXY = true;
      this.bXA.bXX = i;
      this.bXA.bXQ = false;
      this.bXA.bXT = false;
      this.bXA.bYe = 40.0D;
      this.bXA.bYf = 0.1570796326794897D;
      this.bXA.bYg = 1.0D;
      this.bXA.bYw[0] = 400.0D;
      this.bXA.bYw[1] = 1.0D;
      this.bXA.bYj = paramBoolean2;
      this.bXA.bYk = false;
      this.bXA.bXZ = true;
      this.bXA.bYa = 0.3333333333333333D;
      this.bXA.bYb = 5.0D;
      this.bXA.bYc = 0.5D;
      this.bXA.bYd = 1.0D;
      this.bXA.bYr = 0.5D;
      this.bXA.bYs = 1.0D;
      this.bXA.bYt = 0;
      this.bXA.bYu = 2;
      this.bXA.bYy = false;
      this.bXA.bYh[0] = arrayOfDouble2[0];
      this.bXA.bYh[1] = arrayOfDouble2[1];
      arrayOfDouble2 = new double[2];
      a(0, new double[] { paramDouble1, paramDouble2 }, arrayOfDouble2);
      this.bXA.bXC = d1;
      this.bXA.bYl[0] = arrayOfDouble2[0];
      this.bXA.bYl[1] = arrayOfDouble2[1];
      this.bXA.bYl[2] = arrayOfDouble1[0];
      this.bXA.bYl[3] = arrayOfDouble1[1];
      this.bXA.bYn = 0.0D;
      this.bXA.bYo = 1.0D;
      this.bXA.bYp = 1.005D;
      this.bXA.bYm[0][0] = tmp24_22;
      this.bXA.bYm[0][1] = 0L;
      this.bXA.bYm[0][2] = 0L;
      this.bXA.bYm[0][3] = 0L;
      this.bXA.bYm[1][0] = 0L;
      this.bXA.bYm[1][1] = tmp24_22;
      this.bXA.bYm[1][2] = 0L;
      this.bXA.bYm[1][3] = 0L;
      this.bXA.bYm[2][0] = 0L;
      this.bXA.bYm[2][1] = 0L;
      this.bXA.bYm[2][2] = 4607182418800017408L;
      this.bXA.bYm[2][3] = 0L;
      this.bXA.bYm[3][0] = 0L;
      this.bXA.bYm[3][1] = 0L;
      this.bXA.bYm[3][2] = 0L;
      this.bXA.bYm[3][3] = 4607182418800017408L;
      bk(paramBoolean1);
      AppMethodBeat.o(87967);
      return;
    }
  }
  
  protected final void a(a parama)
  {
    AppMethodBeat.i(87970);
    if (parama.bXH <= 0.0D)
    {
      AppMethodBeat.o(87970);
      return;
    }
    double d1;
    if (this.bXA.bXQ)
    {
      d1 = parama.bXC - this.bXA.bXS;
      if (d1 < -10.0D)
      {
        AppMethodBeat.o(87970);
        return;
      }
      if (d1 <= 0.0D) {
        parama.bXC = (this.bXA.bXS + 0.5D);
      }
    }
    double[] arrayOfDouble1 = new double[2];
    a(0, new double[] { parama.bXD, parama.bXE }, arrayOfDouble1);
    parama.bXF[0] = arrayOfDouble1[0];
    parama.bXF[1] = arrayOfDouble1[1];
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
    if (this.bXA.bYq)
    {
      double d5;
      if ((parama.mType != 3) || (this.bXA.bXQ))
      {
        if (parama.mType != 3) {
          break label1192;
        }
        d5 = parama.bXC - this.bXA.bXS;
        if (d5 > 0.0D)
        {
          localObject2 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
          localObject1 = new double[2];
          d4 = arrayOfDouble1[0] - this.bXA.bXR[0];
          d3 = arrayOfDouble1[1] - this.bXA.bXR[1];
          d1 = d3;
          d2 = d4;
          if (this.bXA.bYj)
          {
            d2 = d4 * Math.cos(this.bXA.bYn) - Math.sin(this.bXA.bYn) * d3;
            d1 = Math.sin(this.bXA.bYn);
            d1 = d3 * Math.cos(this.bXA.bYn) + d1 * d2;
          }
          d4 = Math.sqrt(d2 * d2 + d1 * d1);
          d3 = d4 / this.bXA.bYe;
          d3 *= d3;
          if (d3 <= 0.0625D) {
            break label1176;
          }
          d4 *= this.bXA.bYf;
          d4 *= d4;
          if (d4 <= 0.0625D) {
            break label1184;
          }
        }
      }
      for (;;)
      {
        d3 = (d3 + d4) / d5;
        d4 = this.bXA.bYm[2][2];
        double d6 = this.bXA.bYm[2][3];
        double d7 = this.bXA.bYm[3][2];
        double d8 = this.bXA.bYm[3][3];
        localObject3 = this.bXz;
        a(new double[] { d4, d6, d7, d8 }, (double[])localObject3);
        localObject2[0][0] = this.bXz[0];
        localObject2[0][1] = this.bXz[1];
        localObject2[1][0] = this.bXz[2];
        localObject2[1][1] = this.bXz[3];
        d4 = d2 / d5 - this.bXA.bYl[2];
        d6 = d1 / d5 - this.bXA.bYl[3];
        d7 = localObject2[0][0];
        d8 = localObject2[0][1];
        if (Math.sqrt(d4 * d6 * localObject2[1][0] + (d4 * d4 * d7 + d4 * d6 * d8) + d6 * d6 * localObject2[1][1]) > 2.0D)
        {
          this.bXA.bYm[2][2] = this.bXA.bYg;
          this.bXA.bYm[2][3] = 0L;
          this.bXA.bYm[3][2] = 0L;
          this.bXA.bYm[3][3] = this.bXA.bYg;
          localObject2[0][0] = (1.0D / this.bXA.bYg);
          localObject2[0][1] = 0L;
          localObject2[1][0] = 0L;
          localObject2[1][1] = (1.0D / this.bXA.bYg);
        }
        localObject1[0] = (localObject2[0][0] * this.bXA.bYl[2] + localObject2[0][1] * this.bXA.bYl[3]);
        localObject1[1] = (localObject2[1][0] * this.bXA.bYl[2] + localObject2[1][1] * this.bXA.bYl[3]);
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
        localObject2 = this.bXz;
        a(new double[] { d1, d2, d3, d4 }, (double[])localObject2);
        this.bXA.bYm[2][2] = this.bXz[0];
        this.bXA.bYm[2][3] = this.bXz[1];
        this.bXA.bYm[3][2] = this.bXz[2];
        this.bXA.bYm[3][3] = this.bXz[3];
        this.bXA.bYl[2] = (this.bXA.bYm[2][2] * localObject1[0] + this.bXA.bYm[2][3] * localObject1[1]);
        this.bXA.bYl[3] = (this.bXA.bYm[3][2] * localObject1[0] + this.bXA.bYm[3][3] * localObject1[1]);
        a(parama.bXC, false);
        if (parama.mType != 3) {
          break label4325;
        }
        this.bXA.bXR[0] = arrayOfDouble1[0];
        this.bXA.bXR[1] = arrayOfDouble1[1];
        this.bXA.bXS = parama.bXC;
        this.bXA.bXQ = true;
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
      a(parama.bXC, false);
      if (this.bXA.bXZ)
      {
        if (!this.bXA.bXT)
        {
          i = 1;
          j = 1;
          label1242:
          if (i == 0) {
            break label2043;
          }
          if (this.bXA.bXT)
          {
            if (d2 >= d1) {
              break label2045;
            }
            d3 = this.bXA.bYc;
            label1273:
            d1 = d3 + d1 / d2 * (1.0D - d3);
            arrayOfDouble1[0] = (this.bXA.bXU[0] + localObject1[0] * d1);
            d2 = this.bXA.bXU[1];
            arrayOfDouble1[1] = (d1 * localObject1[1] + d2);
          }
          if (j == 0) {
            break label2057;
          }
          a(arrayOfDouble1);
        }
        for (;;)
        {
          this.bXA.bYl[0] = arrayOfDouble1[0];
          this.bXA.bYl[1] = arrayOfDouble1[1];
          this.bXA.bYm[0][0] = (parama.bXH * parama.bXH);
          this.bXA.bYm[0][1] = 0L;
          this.bXA.bYm[1][0] = 0L;
          this.bXA.bYm[1][1] = (parama.bXH * parama.bXH);
          break;
          localObject2[0] = (this.bXA.bYl[0] - this.bXA.bXU[0]);
          localObject2[1] = (this.bXA.bYl[1] - this.bXA.bXU[1]);
          arrayOfDouble1[0] -= this.bXA.bXU[0];
          arrayOfDouble1[1] -= this.bXA.bXU[1];
          d4 = Math.sqrt(localObject2[0] * localObject2[0] + localObject2[1] * localObject2[1]);
          d3 = Math.sqrt(localObject1[0] * localObject1[0] + localObject1[1] * localObject1[1]);
          if ((d3 > this.bXA.bYb) && (d4 > this.bXA.bYb))
          {
            d1 = d3 / d4;
            d2 = d3 - d4;
            d5 = Math.sqrt(this.bXA.bYm[0][0] + this.bXA.bYm[1][1]);
            if (d4 > 3.0D * this.bXA.bYb)
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
                d1 = d2 / Math.sqrt(this.bXA.bYo);
                d2 = Math.sqrt(d1 * d1 + d5 * d5);
                if (d2 >= this.bXA.bXV) {
                  break label1826;
                }
                this.bXA.bYt = 0;
                d1 = d2;
              }
              for (;;)
              {
                if (d1 <= this.bXA.bXV) {
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
                if (d5 < this.bXA.bXV)
                {
                  localObject2 = this.bXA;
                  i = ((b)localObject2).bYt + 1;
                  ((b)localObject2).bYt = i;
                  d1 = d2;
                  if (i >= this.bXA.bYu)
                  {
                    this.bXA.bYt = 0;
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
            if ((d1 < this.bXA.bYa) || (1.0D / d1 < this.bXA.bYa))
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
          if (((d3 < this.bXA.bYb) && (parama.mType == 2)) || ((d3 < this.bXA.bYb * 0.5D) && (parama.mType == 1)))
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
          d3 = this.bXA.bYd;
          break label1273;
          label2057:
          this.bXA.bXU[0] = arrayOfDouble1[0];
          this.bXA.bXU[1] = arrayOfDouble1[1];
        }
      }
      b.a(this.bXB, this.bXA);
      b(parama.bXC, false);
      if (this.bXB.bXY) {
        if (!this.bXA.bXT)
        {
          d1 = 0.0D;
          label2128:
          if (d1 <= this.bXA.bXV) {
            break label3171;
          }
          b.a(this.bXB, this.bXA);
          b(parama.bXC, true);
          if (!this.bXA.bXY) {
            break label2881;
          }
          d3 = this.bXA.bXU[0] - this.bXB.bYl[0];
          d4 = this.bXA.bXU[1] - this.bXB.bYl[1];
          d1 = this.bXA.bXU[0] - arrayOfDouble1[0];
          d2 = this.bXA.bXU[1] - arrayOfDouble1[1];
          d3 = Math.sqrt(d3 * d3 + d4 * d4);
          d1 = Math.sqrt(d1 * d1 + d2 * d2);
          d2 = Math.sqrt(this.bXB.bYm[0][0] * this.bXB.bYm[0][0] + this.bXB.bYm[1][1] * this.bXB.bYm[1][1]);
          d1 = Math.abs(d3 - d1) / d2;
          label2335:
          if (d1 <= this.bXB.bXV) {
            break label3143;
          }
          if (this.bXA.bXW >= this.bXA.bXX) {
            break label3121;
          }
          this.bXA.bXW += 1;
        }
      }
      for (;;)
      {
        this.bXA.bYl[0] = arrayOfDouble1[0];
        this.bXA.bYl[1] = arrayOfDouble1[1];
        this.bXA.bYm[0][0] = (parama.bXH * parama.bXH);
        this.bXA.bYm[0][1] = 0L;
        this.bXA.bYm[1][0] = 0L;
        this.bXA.bYm[1][1] = (parama.bXH * parama.bXH);
        break;
        d3 = this.bXA.bXU[0] - this.bXB.bYl[0];
        d4 = this.bXA.bXU[1] - this.bXB.bYl[1];
        d1 = this.bXA.bXU[0] - arrayOfDouble1[0];
        d2 = this.bXA.bXU[1] - arrayOfDouble1[1];
        d3 = Math.sqrt(d3 * d3 + d4 * d4);
        d1 = Math.sqrt(d1 * d1 + d2 * d2);
        d2 = Math.sqrt(this.bXA.bYm[0][0] * this.bXA.bYm[0][0] + this.bXA.bYm[1][1] * this.bXA.bYm[1][1]);
        d1 = Math.abs(d3 - d1) / d2;
        break label2128;
        d1 = arrayOfDouble1[0] - this.bXB.bYl[0];
        d2 = arrayOfDouble1[1] - this.bXB.bYl[1];
        localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
        d3 = 1.0D / (this.bXB.bYm[0][0] * this.bXB.bYm[1][1] - this.bXB.bYm[0][1] * this.bXB.bYm[1][0]);
        localObject1[0][0] = (this.bXB.bYm[1][1] * d3);
        localObject1[1][1] = (this.bXB.bYm[0][0] * d3);
        localObject1[0][1] = (-this.bXB.bYm[0][1] * d3);
        localObject1[1][0] = (d3 * -this.bXB.bYm[1][0]);
        d3 = localObject1[0][0];
        d4 = localObject1[1][0];
        d1 = Math.sqrt(localObject1[1][1] * (d2 * d2) + (d1 * 2.0D * d2 * d4 + d1 * d1 * d3));
        break label2128;
        label2881:
        d1 = arrayOfDouble1[0] - this.bXB.bYl[0];
        d2 = arrayOfDouble1[1] - this.bXB.bYl[1];
        localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
        d3 = 1.0D / (this.bXB.bYm[0][0] * this.bXB.bYm[1][1] - this.bXB.bYm[0][1] * this.bXB.bYm[1][0]);
        localObject1[0][0] = (this.bXB.bYm[1][1] * d3);
        localObject1[1][1] = (this.bXB.bYm[0][0] * d3);
        localObject1[0][1] = (-this.bXB.bYm[0][1] * d3);
        localObject1[1][0] = (d3 * -this.bXB.bYm[1][0]);
        d3 = localObject1[0][0];
        d4 = localObject1[1][0];
        d1 = Math.sqrt(localObject1[1][1] * (d2 * d2) + (d1 * 2.0D * d2 * d4 + d1 * d1 * d3));
        break label2335;
        label3121:
        b.a(this.bXA, this.bXB);
        this.bXA.bXW = 0;
        continue;
        label3143:
        b.a(this.bXA, this.bXB);
        this.bXA.bXW = 0;
        a(arrayOfDouble1);
        continue;
        label3171:
        b.a(this.bXA, this.bXB);
        this.bXA.bXW = 0;
        a(arrayOfDouble1);
      }
    }
    if (parama.mType != 3)
    {
      j = 0;
      localObject2 = new double[2];
      localObject1 = new double[2];
      arrayOfDouble1 = new double[2];
      a(parama.bXC, false);
      if (!this.bXA.bXT)
      {
        i = 1;
        j = 0;
        this.bXA.bXW = 0;
      }
      while (i != 0) {
        if (j == 0)
        {
          this.bXA.bYl[0] = parama.bXF[0];
          this.bXA.bYl[1] = parama.bXF[1];
          this.bXA.bYl[2] = 0.0D;
          this.bXA.bYl[3] = 0.0D;
          this.bXA.bYm[0][0] = (parama.bXH * parama.bXH);
          this.bXA.bYm[0][1] = 0L;
          this.bXA.bYm[0][2] = 0L;
          this.bXA.bYm[0][3] = 0L;
          this.bXA.bYm[1][0] = 0L;
          this.bXA.bYm[1][1] = this.bXA.bYm[0][0];
          this.bXA.bYm[1][2] = 0L;
          this.bXA.bYm[1][2] = 0L;
          this.bXA.bYm[2][0] = 0L;
          this.bXA.bYm[2][1] = 0L;
          this.bXA.bYm[2][2] = this.bXA.bYg;
          this.bXA.bYm[2][3] = 0L;
          this.bXA.bYm[3][0] = 0L;
          this.bXA.bYm[3][1] = 0L;
          this.bXA.bYm[3][2] = 0L;
          this.bXA.bYm[3][3] = this.bXA.bYg;
          this.bXA.bXU[0] = parama.bXF[0];
          this.bXA.bXU[1] = parama.bXF[1];
          this.bXA.bXT = true;
          AppMethodBeat.o(87970);
          return;
          localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
          localObject2[0] = (parama.bXF[0] - this.bXA.bYl[0]);
          localObject2[1] = (parama.bXF[1] - this.bXA.bYl[1]);
          d1 = this.bXA.bYm[0][0];
          d2 = this.bXA.bYm[0][1];
          d3 = this.bXA.bYm[1][0];
          d4 = this.bXA.bYm[1][1];
          double[] arrayOfDouble2 = this.bXz;
          a(new double[] { d1, d2, d3, d4 }, arrayOfDouble2);
          localObject3[0][0] = this.bXz[0];
          localObject3[0][1] = this.bXz[1];
          localObject3[1][0] = this.bXz[2];
          localObject3[1][1] = this.bXz[3];
          if (Math.sqrt(localObject2[0] * localObject2[0] * localObject3[0][0] + 2.0D * localObject2[0] * localObject2[1] * localObject3[1][0] + localObject2[1] * localObject2[1] * localObject3[1][1]) > this.bXA.bXV)
          {
            localObject2 = this.bXA;
            i = ((b)localObject2).bXW + 1;
            ((b)localObject2).bXW = i;
            if (i >= this.bXA.bXX)
            {
              i = 1;
              j = 0;
              this.bXA.bXW = 0;
            }
            else
            {
              i = 0;
            }
          }
          else
          {
            this.bXA.bXW = 0;
            i = 1;
            j = 1;
          }
        }
        else
        {
          localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 });
          localObject2 = new double[2];
          localObject1[0] = (this.bXA.bYl[0] - this.bXA.bXU[0]);
          localObject1[1] = (this.bXA.bYl[1] - this.bXA.bXU[1]);
          arrayOfDouble1[0] = (parama.bXF[0] - this.bXA.bXU[0]);
          arrayOfDouble1[1] = (parama.bXF[1] - this.bXA.bXU[1]);
          d2 = Math.sqrt(arrayOfDouble1[0] * arrayOfDouble1[0] + arrayOfDouble1[1] * arrayOfDouble1[1]);
          d1 = localObject1[0];
          d3 = localObject1[0];
          d4 = localObject1[1];
          d4 = Math.sqrt(localObject1[1] * d4 + d1 * d3);
          if (d2 >= d4) {
            break label4331;
          }
          d1 = this.bXA.bYr;
          if (a(this.bXA.bYm, (double[][])localObject3))
          {
            d3 = 1.0D / (parama.bXH * parama.bXH);
            localObject1 = new double[4];
            if (!this.bXA.bYy) {
              break label4342;
            }
            d1 += d4 / d2 * (1.0D - d1);
            localObject2[0] = (this.bXA.bXU[0] + arrayOfDouble1[0] * d1);
            d2 = this.bXA.bXU[1];
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
      if (a((double[][])localObject3, this.bXA.bYm))
      {
        localObject1[0] += localObject2[0] * d3;
        localObject1[1] += localObject2[1] * d3;
        i = 0;
        if (i < 4) {
          break label4464;
        }
        this.bXA.bXU[0] = localObject2[0];
        this.bXA.bXU[1] = localObject2[1];
      }
      label4325:
      AppMethodBeat.o(87970);
      return;
      label4331:
      d1 = this.bXA.bYs;
      break;
      label4342:
      localObject2[0] = (this.bXA.bYl[0] * (1.0D - d1) + parama.bXF[0] * d1);
      d2 = this.bXA.bYl[1];
      localObject2[1] = (d1 * parama.bXF[1] + d2 * (1.0D - d1));
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
      localObject1[i] += localObject3[i][j] * this.bXA.bYl[j];
      j += 1;
    }
    label4464:
    this.bXA.bYl[i] = 0.0D;
    j = 0;
    for (;;)
    {
      if (j >= 4)
      {
        i += 1;
        break;
      }
      parama = this.bXA.bYl;
      parama[i] += this.bXA.bYm[i][j] * localObject1[j];
      j += 1;
    }
  }
  
  protected final void bk(boolean paramBoolean)
  {
    AppMethodBeat.i(87968);
    if (paramBoolean) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      bl(paramBoolean);
      AppMethodBeat.o(87968);
      return;
    }
  }
  
  protected static final class a
  {
    double bXC;
    double bXD;
    double bXE;
    double[] bXF;
    double bXG;
    double bXH;
    int bXI;
    double bXJ;
    double bXK;
    int bXL;
    double bXM;
    double bXN;
    double bXO;
    int mType;
    
    protected a(int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, int paramInt2, double paramDouble6, int paramInt3, double paramDouble7, double paramDouble8)
    {
      AppMethodBeat.i(87961);
      this.bXF = new double[2];
      this.mType = paramInt1;
      this.bXC = paramDouble1;
      this.bXD = paramDouble2;
      this.bXE = paramDouble3;
      this.bXG = paramDouble4;
      this.bXH = paramDouble5;
      this.bXI = paramInt2;
      this.bXJ = paramDouble6;
      this.bXK = 0.0D;
      this.bXL = paramInt3;
      this.bXM = 0.0D;
      this.bXN = paramDouble7;
      this.bXO = paramDouble8;
      AppMethodBeat.o(87961);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(87962);
      String str = String.valueOf(this.mType) + ',' + this.bXC + ',' + this.bXD + ',' + this.bXE + ',' + this.bXG + ',' + this.bXH + ',' + this.bXI + ',' + this.bXJ + ',' + this.bXK + ',' + this.bXL + ',' + this.bXN + ',' + this.bXO;
      AppMethodBeat.o(87962);
      return str;
    }
  }
  
  static final class b
  {
    double bXC;
    double bXP;
    boolean bXQ;
    double[] bXR;
    double bXS;
    boolean bXT;
    double[] bXU;
    double bXV;
    int bXW;
    int bXX;
    boolean bXY;
    boolean bXZ;
    double bYa;
    double bYb;
    double bYc;
    double bYd;
    double bYe;
    double bYf;
    double bYg;
    double[] bYh;
    private boolean bYi;
    boolean bYj;
    boolean bYk;
    double[] bYl;
    double[][] bYm;
    double bYn;
    double bYo;
    double bYp;
    boolean bYq;
    double bYr;
    double bYs;
    int bYt;
    int bYu;
    double bYv;
    double[] bYw;
    double[] bYx;
    boolean bYy;
    
    private b()
    {
      AppMethodBeat.i(87963);
      this.bXR = new double[2];
      this.bXU = new double[2];
      this.bYh = new double[2];
      this.bYl = new double[4];
      this.bYm = ((double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 }));
      this.bYw = new double[2];
      this.bYx = new double[2];
      AppMethodBeat.o(87963);
    }
    
    private void a(b paramb)
    {
      AppMethodBeat.i(87964);
      this.bXP = paramb.bXP;
      this.bXQ = paramb.bXQ;
      this.bXR = ((double[])paramb.bXR.clone());
      this.bXS = paramb.bXS;
      this.bXT = paramb.bXT;
      this.bXU = ((double[])paramb.bXU.clone());
      this.bXV = paramb.bXV;
      this.bXW = paramb.bXW;
      this.bXX = paramb.bXX;
      this.bXY = paramb.bXY;
      this.bXZ = paramb.bXZ;
      this.bYa = paramb.bYa;
      this.bYb = paramb.bYb;
      this.bYc = paramb.bYc;
      this.bYd = paramb.bYd;
      this.bYe = paramb.bYe;
      this.bYf = paramb.bYf;
      this.bYg = paramb.bYg;
      this.bYh = ((double[])paramb.bYh.clone());
      this.bYi = paramb.bYi;
      this.bYj = paramb.bYj;
      this.bYk = paramb.bYk;
      this.bXC = paramb.bXC;
      this.bYl = ((double[])paramb.bYl.clone());
      this.bYm[0] = ((double[])paramb.bYm[0].clone());
      this.bYm[1] = ((double[])paramb.bYm[1].clone());
      this.bYm[2] = ((double[])paramb.bYm[2].clone());
      this.bYm[3] = ((double[])paramb.bYm[3].clone());
      this.bYn = paramb.bYn;
      this.bYo = paramb.bYo;
      this.bYp = paramb.bYp;
      this.bYq = paramb.bYq;
      this.bYr = paramb.bYr;
      this.bYs = paramb.bYs;
      this.bYt = paramb.bYt;
      this.bYu = paramb.bYu;
      this.bYv = paramb.bYv;
      this.bYw = ((double[])paramb.bYw.clone());
      this.bYx = ((double[])paramb.bYx.clone());
      this.bYy = paramb.bYy;
      AppMethodBeat.o(87964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.j
 * JD-Core Version:    0.7.0.1
 */