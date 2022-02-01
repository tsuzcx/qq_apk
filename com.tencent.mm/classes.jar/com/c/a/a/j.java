package com.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

final class j
{
  private double[] bPE;
  final b bPF;
  private final b bPG;
  
  j()
  {
    AppMethodBeat.i(87966);
    this.bPE = new double[4];
    this.bPF = new b((byte)0);
    this.bPG = new b((byte)0);
    AppMethodBeat.o(87966);
  }
  
  private void a(double paramDouble, boolean paramBoolean)
  {
    double d3 = paramDouble - this.bPF.bPH;
    double d4 = d3 * d3;
    double d2;
    double d1;
    label97:
    Object localObject;
    if (paramBoolean)
    {
      this.bPF.bQr[2][2] = this.bPF.bQl;
      this.bPF.bQr[2][3] = 0L;
      this.bPF.bQr[3][2] = 0L;
      this.bPF.bQr[3][3] = this.bPF.bQl;
      if (d3 > 0.5D)
      {
        d2 = 1.0D;
        d1 = 0.0D;
        if (d1 < d3) {
          break label496;
        }
        localObject = this.bPF;
        ((b)localObject).bQt = (d2 * ((b)localObject).bQt);
      }
      this.bPF.bQq[0] += this.bPF.bQq[2] * d3;
      this.bPF.bQq[1] += this.bPF.bQq[3] * d3;
      if (!this.bPF.bQv) {
        break label517;
      }
      this.bPF.bQr[0][0] += this.bPF.bQr[2][2] * d4;
      this.bPF.bQr[0][1] += this.bPF.bQr[2][3] * d4;
      this.bPF.bQr[1][0] += this.bPF.bQr[3][2] * d4;
      this.bPF.bQr[1][1] += this.bPF.bQr[3][3] * d4;
    }
    for (;;)
    {
      this.bPF.bPH = paramDouble;
      return;
      d1 = 1.0D;
      d2 = d1;
      if (d3 > 0.5D) {}
      for (d2 = 0.0D;; d2 += 1.0D)
      {
        if (d2 >= d3)
        {
          d2 = d1;
          localObject = this.bPF.bQr[2];
          localObject[2] *= d2;
          localObject = this.bPF.bQr[2];
          localObject[3] *= d2;
          localObject = this.bPF.bQr[3];
          localObject[2] *= d2;
          localObject = this.bPF.bQr[3];
          localObject[3] = (d2 * localObject[3]);
          break;
        }
        d1 *= this.bPF.bPU;
      }
      label496:
      d2 *= this.bPF.bQu;
      d1 += 1.0D;
      break label97;
      label517:
      this.bPF.bQr[0][0] = (this.bPF.bQr[0][0] + (this.bPF.bQr[0][2] + this.bPF.bQr[2][0]) * d3 + this.bPF.bQr[2][2] * d4);
      this.bPF.bQr[1][1] = (this.bPF.bQr[1][1] + (this.bPF.bQr[1][3] + this.bPF.bQr[3][1]) * d3 + d4 * this.bPF.bQr[3][3]);
      this.bPF.bQr[0][2] += this.bPF.bQr[2][2] * d3;
      this.bPF.bQr[2][0] += this.bPF.bQr[2][2] * d3;
      this.bPF.bQr[1][3] += this.bPF.bQr[3][3] * d3;
      this.bPF.bQr[3][1] += d3 * this.bPF.bQr[3][3];
    }
  }
  
  private void a(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(87971);
    double d3;
    double d1;
    double d4;
    int i;
    if ((this.bPF.bQo) && (this.bPF.bPY))
    {
      Object localObject = new double[2];
      double[] arrayOfDouble = new double[2];
      double d5 = this.bPF.bQA;
      localObject[0] = (this.bPF.bQq[0] - this.bPF.bPZ[0]);
      localObject[1] = (this.bPF.bQq[1] - this.bPF.bPZ[1]);
      paramArrayOfDouble[0] -= this.bPF.bPZ[0];
      paramArrayOfDouble[1] -= this.bPF.bPZ[1];
      double d2 = Math.sqrt(localObject[0] * localObject[0] + localObject[1] * localObject[1]);
      d3 = Math.sqrt(arrayOfDouble[0] * arrayOfDouble[0] + arrayOfDouble[1] * arrayOfDouble[1]);
      if ((d2 > this.bPF.bQg) && (d3 > this.bPF.bQg))
      {
        d1 = Math.atan2(localObject[1], localObject[0]);
        d4 = Math.atan2(arrayOfDouble[1], arrayOfDouble[0]) - d1;
        if (d4 <= 3.141592653589793D) {
          break label380;
        }
        d1 = d4 - 6.283185307179586D;
        localObject = this.bPF;
        ((b)localObject).bQs = (d5 * d1 + ((b)localObject).bQs);
        if (d1 * d1 <= 4.0D * this.bPF.bQt) {
          break label402;
        }
        i = 1;
        label283:
        d4 = Math.sqrt(this.bPF.bQr[0][0] + this.bPF.bQr[1][1]);
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
    for (this.bPF.bQt = (d1 * d1);; this.bPF.bQt = (1.0D / (1.0D / (d1 * d1) + 1.0D / this.bPF.bQt)))
    {
      this.bPF.bPZ[0] = paramArrayOfDouble[0];
      this.bPF.bPZ[1] = paramArrayOfDouble[1];
      this.bPF.bPY = true;
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
    double d3 = paramDouble - this.bPG.bPH;
    double d4 = d3 * d3;
    double d2;
    double d1;
    label97:
    Object localObject;
    if (paramBoolean)
    {
      this.bPG.bQr[2][2] = this.bPG.bQl;
      this.bPG.bQr[2][3] = 0L;
      this.bPG.bQr[3][2] = 0L;
      this.bPG.bQr[3][3] = this.bPG.bQl;
      if (d3 > 0.5D)
      {
        d2 = 1.0D;
        d1 = 0.0D;
        if (d1 < d3) {
          break label496;
        }
        localObject = this.bPG;
        ((b)localObject).bQt = (d2 * ((b)localObject).bQt);
      }
      this.bPG.bQq[0] += this.bPG.bQq[2] * d3;
      this.bPG.bQq[1] += this.bPG.bQq[3] * d3;
      if (!this.bPG.bQv) {
        break label517;
      }
      this.bPG.bQr[0][0] += this.bPG.bQr[2][2] * d4;
      this.bPG.bQr[0][1] += this.bPG.bQr[2][3] * d4;
      this.bPG.bQr[1][0] += this.bPG.bQr[3][2] * d4;
      this.bPG.bQr[1][1] += this.bPG.bQr[3][3] * d4;
    }
    for (;;)
    {
      this.bPG.bPH = paramDouble;
      return;
      d1 = 1.0D;
      d2 = d1;
      if (d3 > 0.5D) {}
      for (d2 = 0.0D;; d2 += 1.0D)
      {
        if (d2 >= d3)
        {
          d2 = d1;
          localObject = this.bPG.bQr[2];
          localObject[2] *= d2;
          localObject = this.bPG.bQr[2];
          localObject[3] *= d2;
          localObject = this.bPG.bQr[3];
          localObject[2] *= d2;
          localObject = this.bPG.bQr[3];
          localObject[3] = (d2 * localObject[3]);
          break;
        }
        d1 *= this.bPG.bPU;
      }
      label496:
      d2 *= this.bPG.bQu;
      d1 += 1.0D;
      break label97;
      label517:
      this.bPG.bQr[0][0] = (this.bPG.bQr[0][0] + (this.bPG.bQr[0][2] + this.bPG.bQr[2][0]) * d3 + this.bPG.bQr[2][2] * d4);
      this.bPG.bQr[1][1] = (this.bPG.bQr[1][1] + (this.bPG.bQr[1][3] + this.bPG.bQr[3][1]) * d3 + d4 * this.bPG.bQr[3][3]);
      this.bPG.bQr[0][2] += this.bPG.bQr[2][2] * d3;
      this.bPG.bQr[2][0] += this.bPG.bQr[2][2] * d3;
      this.bPG.bQr[1][3] += this.bPG.bQr[3][3] * d3;
      this.bPG.bQr[3][1] += d3 * this.bPG.bQr[3][3];
    }
  }
  
  private void bl(boolean paramBoolean)
  {
    AppMethodBeat.i(87969);
    if (this.bPF.bQv != paramBoolean)
    {
      this.bPF.bQv = paramBoolean;
      if (paramBoolean)
      {
        this.bPF.bPU = this.bPF.bQC[1];
        this.bPF.bQl = this.bPF.bQB[1];
        a(this.bPF.bPH, true);
        AppMethodBeat.o(87969);
        return;
      }
      this.bPF.bPU = this.bPF.bQC[0];
      this.bPF.bQl = this.bPF.bQB[0];
      a(this.bPF.bPH, true);
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
      paramArrayOfDouble2[0] = ((paramArrayOfDouble1[1] - this.bPF.bQm[1]) * 6378137.0D * Math.cos(this.bPF.bQm[0]));
      paramArrayOfDouble2[1] = ((paramArrayOfDouble1[0] - this.bPF.bQm[0]) * 6378137.0D);
      AppMethodBeat.o(87972);
      return;
      paramArrayOfDouble2[0] = (paramArrayOfDouble1[1] / 6378137.0D + this.bPF.bQm[0]);
      paramArrayOfDouble2[1] = (paramArrayOfDouble1[0] / (Math.cos(this.bPF.bQm[0]) * 6378137.0D) + this.bPF.bQm[1]);
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
      this.bPF.bQv = true;
      this.bPF.bQC[0] = 3.0D;
      this.bPF.bQC[1] = 1.2D;
      this.bPF.bQA = 0.5D;
      this.bPF.bPU = 1.2D;
      this.bPF.bQa = 4.0D;
      this.bPF.bQb = 0;
      this.bPF.bQd = true;
      this.bPF.bQc = i;
      this.bPF.bPV = false;
      this.bPF.bPY = false;
      this.bPF.bQj = 40.0D;
      this.bPF.bQk = 0.1570796326794897D;
      this.bPF.bQl = 1.0D;
      this.bPF.bQB[0] = 400.0D;
      this.bPF.bQB[1] = 1.0D;
      this.bPF.bQo = paramBoolean2;
      this.bPF.bQp = false;
      this.bPF.bQe = true;
      this.bPF.bQf = 0.3333333333333333D;
      this.bPF.bQg = 5.0D;
      this.bPF.bQh = 0.5D;
      this.bPF.bQi = 1.0D;
      this.bPF.bQw = 0.5D;
      this.bPF.bQx = 1.0D;
      this.bPF.bQy = 0;
      this.bPF.bQz = 2;
      this.bPF.bQD = false;
      this.bPF.bQm[0] = arrayOfDouble2[0];
      this.bPF.bQm[1] = arrayOfDouble2[1];
      arrayOfDouble2 = new double[2];
      a(0, new double[] { paramDouble1, paramDouble2 }, arrayOfDouble2);
      this.bPF.bPH = d1;
      this.bPF.bQq[0] = arrayOfDouble2[0];
      this.bPF.bQq[1] = arrayOfDouble2[1];
      this.bPF.bQq[2] = arrayOfDouble1[0];
      this.bPF.bQq[3] = arrayOfDouble1[1];
      this.bPF.bQs = 0.0D;
      this.bPF.bQt = 1.0D;
      this.bPF.bQu = 1.005D;
      this.bPF.bQr[0][0] = tmp24_22;
      this.bPF.bQr[0][1] = 0L;
      this.bPF.bQr[0][2] = 0L;
      this.bPF.bQr[0][3] = 0L;
      this.bPF.bQr[1][0] = 0L;
      this.bPF.bQr[1][1] = tmp24_22;
      this.bPF.bQr[1][2] = 0L;
      this.bPF.bQr[1][3] = 0L;
      this.bPF.bQr[2][0] = 0L;
      this.bPF.bQr[2][1] = 0L;
      this.bPF.bQr[2][2] = 4607182418800017408L;
      this.bPF.bQr[2][3] = 0L;
      this.bPF.bQr[3][0] = 0L;
      this.bPF.bQr[3][1] = 0L;
      this.bPF.bQr[3][2] = 0L;
      this.bPF.bQr[3][3] = 4607182418800017408L;
      bk(paramBoolean1);
      AppMethodBeat.o(87967);
      return;
    }
  }
  
  protected final void a(a parama)
  {
    AppMethodBeat.i(87970);
    if (parama.bPM <= 0.0D)
    {
      AppMethodBeat.o(87970);
      return;
    }
    double d1;
    if (this.bPF.bPV)
    {
      d1 = parama.bPH - this.bPF.bPX;
      if (d1 < -10.0D)
      {
        AppMethodBeat.o(87970);
        return;
      }
      if (d1 <= 0.0D) {
        parama.bPH = (this.bPF.bPX + 0.5D);
      }
    }
    double[] arrayOfDouble1 = new double[2];
    a(0, new double[] { parama.bPI, parama.bPJ }, arrayOfDouble1);
    parama.bPK[0] = arrayOfDouble1[0];
    parama.bPK[1] = arrayOfDouble1[1];
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
    if (this.bPF.bQv)
    {
      double d5;
      if ((parama.mType != 3) || (this.bPF.bPV))
      {
        if (parama.mType != 3) {
          break label1192;
        }
        d5 = parama.bPH - this.bPF.bPX;
        if (d5 > 0.0D)
        {
          localObject2 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
          localObject1 = new double[2];
          d4 = arrayOfDouble1[0] - this.bPF.bPW[0];
          d3 = arrayOfDouble1[1] - this.bPF.bPW[1];
          d1 = d3;
          d2 = d4;
          if (this.bPF.bQo)
          {
            d2 = d4 * Math.cos(this.bPF.bQs) - Math.sin(this.bPF.bQs) * d3;
            d1 = Math.sin(this.bPF.bQs);
            d1 = d3 * Math.cos(this.bPF.bQs) + d1 * d2;
          }
          d4 = Math.sqrt(d2 * d2 + d1 * d1);
          d3 = d4 / this.bPF.bQj;
          d3 *= d3;
          if (d3 <= 0.0625D) {
            break label1176;
          }
          d4 *= this.bPF.bQk;
          d4 *= d4;
          if (d4 <= 0.0625D) {
            break label1184;
          }
        }
      }
      for (;;)
      {
        d3 = (d3 + d4) / d5;
        d4 = this.bPF.bQr[2][2];
        double d6 = this.bPF.bQr[2][3];
        double d7 = this.bPF.bQr[3][2];
        double d8 = this.bPF.bQr[3][3];
        localObject3 = this.bPE;
        a(new double[] { d4, d6, d7, d8 }, (double[])localObject3);
        localObject2[0][0] = this.bPE[0];
        localObject2[0][1] = this.bPE[1];
        localObject2[1][0] = this.bPE[2];
        localObject2[1][1] = this.bPE[3];
        d4 = d2 / d5 - this.bPF.bQq[2];
        d6 = d1 / d5 - this.bPF.bQq[3];
        d7 = localObject2[0][0];
        d8 = localObject2[0][1];
        if (Math.sqrt(d4 * d6 * localObject2[1][0] + (d4 * d4 * d7 + d4 * d6 * d8) + d6 * d6 * localObject2[1][1]) > 2.0D)
        {
          this.bPF.bQr[2][2] = this.bPF.bQl;
          this.bPF.bQr[2][3] = 0L;
          this.bPF.bQr[3][2] = 0L;
          this.bPF.bQr[3][3] = this.bPF.bQl;
          localObject2[0][0] = (1.0D / this.bPF.bQl);
          localObject2[0][1] = 0L;
          localObject2[1][0] = 0L;
          localObject2[1][1] = (1.0D / this.bPF.bQl);
        }
        localObject1[0] = (localObject2[0][0] * this.bPF.bQq[2] + localObject2[0][1] * this.bPF.bQq[3]);
        localObject1[1] = (localObject2[1][0] * this.bPF.bQq[2] + localObject2[1][1] * this.bPF.bQq[3]);
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
        localObject2 = this.bPE;
        a(new double[] { d1, d2, d3, d4 }, (double[])localObject2);
        this.bPF.bQr[2][2] = this.bPE[0];
        this.bPF.bQr[2][3] = this.bPE[1];
        this.bPF.bQr[3][2] = this.bPE[2];
        this.bPF.bQr[3][3] = this.bPE[3];
        this.bPF.bQq[2] = (this.bPF.bQr[2][2] * localObject1[0] + this.bPF.bQr[2][3] * localObject1[1]);
        this.bPF.bQq[3] = (this.bPF.bQr[3][2] * localObject1[0] + this.bPF.bQr[3][3] * localObject1[1]);
        a(parama.bPH, false);
        if (parama.mType != 3) {
          break label4325;
        }
        this.bPF.bPW[0] = arrayOfDouble1[0];
        this.bPF.bPW[1] = arrayOfDouble1[1];
        this.bPF.bPX = parama.bPH;
        this.bPF.bPV = true;
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
      a(parama.bPH, false);
      if (this.bPF.bQe)
      {
        if (!this.bPF.bPY)
        {
          i = 1;
          j = 1;
          label1242:
          if (i == 0) {
            break label2043;
          }
          if (this.bPF.bPY)
          {
            if (d2 >= d1) {
              break label2045;
            }
            d3 = this.bPF.bQh;
            label1273:
            d1 = d3 + d1 / d2 * (1.0D - d3);
            arrayOfDouble1[0] = (this.bPF.bPZ[0] + localObject1[0] * d1);
            d2 = this.bPF.bPZ[1];
            arrayOfDouble1[1] = (d1 * localObject1[1] + d2);
          }
          if (j == 0) {
            break label2057;
          }
          a(arrayOfDouble1);
        }
        for (;;)
        {
          this.bPF.bQq[0] = arrayOfDouble1[0];
          this.bPF.bQq[1] = arrayOfDouble1[1];
          this.bPF.bQr[0][0] = (parama.bPM * parama.bPM);
          this.bPF.bQr[0][1] = 0L;
          this.bPF.bQr[1][0] = 0L;
          this.bPF.bQr[1][1] = (parama.bPM * parama.bPM);
          break;
          localObject2[0] = (this.bPF.bQq[0] - this.bPF.bPZ[0]);
          localObject2[1] = (this.bPF.bQq[1] - this.bPF.bPZ[1]);
          arrayOfDouble1[0] -= this.bPF.bPZ[0];
          arrayOfDouble1[1] -= this.bPF.bPZ[1];
          d4 = Math.sqrt(localObject2[0] * localObject2[0] + localObject2[1] * localObject2[1]);
          d3 = Math.sqrt(localObject1[0] * localObject1[0] + localObject1[1] * localObject1[1]);
          if ((d3 > this.bPF.bQg) && (d4 > this.bPF.bQg))
          {
            d1 = d3 / d4;
            d2 = d3 - d4;
            d5 = Math.sqrt(this.bPF.bQr[0][0] + this.bPF.bQr[1][1]);
            if (d4 > 3.0D * this.bPF.bQg)
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
                d1 = d2 / Math.sqrt(this.bPF.bQt);
                d2 = Math.sqrt(d1 * d1 + d5 * d5);
                if (d2 >= this.bPF.bQa) {
                  break label1826;
                }
                this.bPF.bQy = 0;
                d1 = d2;
              }
              for (;;)
              {
                if (d1 <= this.bPF.bQa) {
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
                if (d5 < this.bPF.bQa)
                {
                  localObject2 = this.bPF;
                  i = ((b)localObject2).bQy + 1;
                  ((b)localObject2).bQy = i;
                  d1 = d2;
                  if (i >= this.bPF.bQz)
                  {
                    this.bPF.bQy = 0;
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
            if ((d1 < this.bPF.bQf) || (1.0D / d1 < this.bPF.bQf))
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
          if (((d3 < this.bPF.bQg) && (parama.mType == 2)) || ((d3 < this.bPF.bQg * 0.5D) && (parama.mType == 1)))
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
          d3 = this.bPF.bQi;
          break label1273;
          label2057:
          this.bPF.bPZ[0] = arrayOfDouble1[0];
          this.bPF.bPZ[1] = arrayOfDouble1[1];
        }
      }
      b.a(this.bPG, this.bPF);
      b(parama.bPH, false);
      if (this.bPG.bQd) {
        if (!this.bPF.bPY)
        {
          d1 = 0.0D;
          label2128:
          if (d1 <= this.bPF.bQa) {
            break label3171;
          }
          b.a(this.bPG, this.bPF);
          b(parama.bPH, true);
          if (!this.bPF.bQd) {
            break label2881;
          }
          d3 = this.bPF.bPZ[0] - this.bPG.bQq[0];
          d4 = this.bPF.bPZ[1] - this.bPG.bQq[1];
          d1 = this.bPF.bPZ[0] - arrayOfDouble1[0];
          d2 = this.bPF.bPZ[1] - arrayOfDouble1[1];
          d3 = Math.sqrt(d3 * d3 + d4 * d4);
          d1 = Math.sqrt(d1 * d1 + d2 * d2);
          d2 = Math.sqrt(this.bPG.bQr[0][0] * this.bPG.bQr[0][0] + this.bPG.bQr[1][1] * this.bPG.bQr[1][1]);
          d1 = Math.abs(d3 - d1) / d2;
          label2335:
          if (d1 <= this.bPG.bQa) {
            break label3143;
          }
          if (this.bPF.bQb >= this.bPF.bQc) {
            break label3121;
          }
          this.bPF.bQb += 1;
        }
      }
      for (;;)
      {
        this.bPF.bQq[0] = arrayOfDouble1[0];
        this.bPF.bQq[1] = arrayOfDouble1[1];
        this.bPF.bQr[0][0] = (parama.bPM * parama.bPM);
        this.bPF.bQr[0][1] = 0L;
        this.bPF.bQr[1][0] = 0L;
        this.bPF.bQr[1][1] = (parama.bPM * parama.bPM);
        break;
        d3 = this.bPF.bPZ[0] - this.bPG.bQq[0];
        d4 = this.bPF.bPZ[1] - this.bPG.bQq[1];
        d1 = this.bPF.bPZ[0] - arrayOfDouble1[0];
        d2 = this.bPF.bPZ[1] - arrayOfDouble1[1];
        d3 = Math.sqrt(d3 * d3 + d4 * d4);
        d1 = Math.sqrt(d1 * d1 + d2 * d2);
        d2 = Math.sqrt(this.bPF.bQr[0][0] * this.bPF.bQr[0][0] + this.bPF.bQr[1][1] * this.bPF.bQr[1][1]);
        d1 = Math.abs(d3 - d1) / d2;
        break label2128;
        d1 = arrayOfDouble1[0] - this.bPG.bQq[0];
        d2 = arrayOfDouble1[1] - this.bPG.bQq[1];
        localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
        d3 = 1.0D / (this.bPG.bQr[0][0] * this.bPG.bQr[1][1] - this.bPG.bQr[0][1] * this.bPG.bQr[1][0]);
        localObject1[0][0] = (this.bPG.bQr[1][1] * d3);
        localObject1[1][1] = (this.bPG.bQr[0][0] * d3);
        localObject1[0][1] = (-this.bPG.bQr[0][1] * d3);
        localObject1[1][0] = (d3 * -this.bPG.bQr[1][0]);
        d3 = localObject1[0][0];
        d4 = localObject1[1][0];
        d1 = Math.sqrt(localObject1[1][1] * (d2 * d2) + (d1 * 2.0D * d2 * d4 + d1 * d1 * d3));
        break label2128;
        label2881:
        d1 = arrayOfDouble1[0] - this.bPG.bQq[0];
        d2 = arrayOfDouble1[1] - this.bPG.bQq[1];
        localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
        d3 = 1.0D / (this.bPG.bQr[0][0] * this.bPG.bQr[1][1] - this.bPG.bQr[0][1] * this.bPG.bQr[1][0]);
        localObject1[0][0] = (this.bPG.bQr[1][1] * d3);
        localObject1[1][1] = (this.bPG.bQr[0][0] * d3);
        localObject1[0][1] = (-this.bPG.bQr[0][1] * d3);
        localObject1[1][0] = (d3 * -this.bPG.bQr[1][0]);
        d3 = localObject1[0][0];
        d4 = localObject1[1][0];
        d1 = Math.sqrt(localObject1[1][1] * (d2 * d2) + (d1 * 2.0D * d2 * d4 + d1 * d1 * d3));
        break label2335;
        label3121:
        b.a(this.bPF, this.bPG);
        this.bPF.bQb = 0;
        continue;
        label3143:
        b.a(this.bPF, this.bPG);
        this.bPF.bQb = 0;
        a(arrayOfDouble1);
        continue;
        label3171:
        b.a(this.bPF, this.bPG);
        this.bPF.bQb = 0;
        a(arrayOfDouble1);
      }
    }
    if (parama.mType != 3)
    {
      j = 0;
      localObject2 = new double[2];
      localObject1 = new double[2];
      arrayOfDouble1 = new double[2];
      a(parama.bPH, false);
      if (!this.bPF.bPY)
      {
        i = 1;
        j = 0;
        this.bPF.bQb = 0;
      }
      while (i != 0) {
        if (j == 0)
        {
          this.bPF.bQq[0] = parama.bPK[0];
          this.bPF.bQq[1] = parama.bPK[1];
          this.bPF.bQq[2] = 0.0D;
          this.bPF.bQq[3] = 0.0D;
          this.bPF.bQr[0][0] = (parama.bPM * parama.bPM);
          this.bPF.bQr[0][1] = 0L;
          this.bPF.bQr[0][2] = 0L;
          this.bPF.bQr[0][3] = 0L;
          this.bPF.bQr[1][0] = 0L;
          this.bPF.bQr[1][1] = this.bPF.bQr[0][0];
          this.bPF.bQr[1][2] = 0L;
          this.bPF.bQr[1][2] = 0L;
          this.bPF.bQr[2][0] = 0L;
          this.bPF.bQr[2][1] = 0L;
          this.bPF.bQr[2][2] = this.bPF.bQl;
          this.bPF.bQr[2][3] = 0L;
          this.bPF.bQr[3][0] = 0L;
          this.bPF.bQr[3][1] = 0L;
          this.bPF.bQr[3][2] = 0L;
          this.bPF.bQr[3][3] = this.bPF.bQl;
          this.bPF.bPZ[0] = parama.bPK[0];
          this.bPF.bPZ[1] = parama.bPK[1];
          this.bPF.bPY = true;
          AppMethodBeat.o(87970);
          return;
          localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
          localObject2[0] = (parama.bPK[0] - this.bPF.bQq[0]);
          localObject2[1] = (parama.bPK[1] - this.bPF.bQq[1]);
          d1 = this.bPF.bQr[0][0];
          d2 = this.bPF.bQr[0][1];
          d3 = this.bPF.bQr[1][0];
          d4 = this.bPF.bQr[1][1];
          double[] arrayOfDouble2 = this.bPE;
          a(new double[] { d1, d2, d3, d4 }, arrayOfDouble2);
          localObject3[0][0] = this.bPE[0];
          localObject3[0][1] = this.bPE[1];
          localObject3[1][0] = this.bPE[2];
          localObject3[1][1] = this.bPE[3];
          if (Math.sqrt(localObject2[0] * localObject2[0] * localObject3[0][0] + 2.0D * localObject2[0] * localObject2[1] * localObject3[1][0] + localObject2[1] * localObject2[1] * localObject3[1][1]) > this.bPF.bQa)
          {
            localObject2 = this.bPF;
            i = ((b)localObject2).bQb + 1;
            ((b)localObject2).bQb = i;
            if (i >= this.bPF.bQc)
            {
              i = 1;
              j = 0;
              this.bPF.bQb = 0;
            }
            else
            {
              i = 0;
            }
          }
          else
          {
            this.bPF.bQb = 0;
            i = 1;
            j = 1;
          }
        }
        else
        {
          localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 });
          localObject2 = new double[2];
          localObject1[0] = (this.bPF.bQq[0] - this.bPF.bPZ[0]);
          localObject1[1] = (this.bPF.bQq[1] - this.bPF.bPZ[1]);
          arrayOfDouble1[0] = (parama.bPK[0] - this.bPF.bPZ[0]);
          arrayOfDouble1[1] = (parama.bPK[1] - this.bPF.bPZ[1]);
          d2 = Math.sqrt(arrayOfDouble1[0] * arrayOfDouble1[0] + arrayOfDouble1[1] * arrayOfDouble1[1]);
          d1 = localObject1[0];
          d3 = localObject1[0];
          d4 = localObject1[1];
          d4 = Math.sqrt(localObject1[1] * d4 + d1 * d3);
          if (d2 >= d4) {
            break label4331;
          }
          d1 = this.bPF.bQw;
          if (a(this.bPF.bQr, (double[][])localObject3))
          {
            d3 = 1.0D / (parama.bPM * parama.bPM);
            localObject1 = new double[4];
            if (!this.bPF.bQD) {
              break label4342;
            }
            d1 += d4 / d2 * (1.0D - d1);
            localObject2[0] = (this.bPF.bPZ[0] + arrayOfDouble1[0] * d1);
            d2 = this.bPF.bPZ[1];
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
      if (a((double[][])localObject3, this.bPF.bQr))
      {
        localObject1[0] += localObject2[0] * d3;
        localObject1[1] += localObject2[1] * d3;
        i = 0;
        if (i < 4) {
          break label4464;
        }
        this.bPF.bPZ[0] = localObject2[0];
        this.bPF.bPZ[1] = localObject2[1];
      }
      label4325:
      AppMethodBeat.o(87970);
      return;
      label4331:
      d1 = this.bPF.bQx;
      break;
      label4342:
      localObject2[0] = (this.bPF.bQq[0] * (1.0D - d1) + parama.bPK[0] * d1);
      d2 = this.bPF.bQq[1];
      localObject2[1] = (d1 * parama.bPK[1] + d2 * (1.0D - d1));
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
      localObject1[i] += localObject3[i][j] * this.bPF.bQq[j];
      j += 1;
    }
    label4464:
    this.bPF.bQq[i] = 0.0D;
    j = 0;
    for (;;)
    {
      if (j >= 4)
      {
        i += 1;
        break;
      }
      parama = this.bPF.bQq;
      parama[i] += this.bPF.bQr[i][j] * localObject1[j];
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
    double bPH;
    double bPI;
    double bPJ;
    double[] bPK;
    double bPL;
    double bPM;
    int bPN;
    double bPO;
    double bPP;
    int bPQ;
    double bPR;
    double bPS;
    double bPT;
    int mType;
    
    protected a(int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, int paramInt2, double paramDouble6, int paramInt3, double paramDouble7, double paramDouble8)
    {
      AppMethodBeat.i(87961);
      this.bPK = new double[2];
      this.mType = paramInt1;
      this.bPH = paramDouble1;
      this.bPI = paramDouble2;
      this.bPJ = paramDouble3;
      this.bPL = paramDouble4;
      this.bPM = paramDouble5;
      this.bPN = paramInt2;
      this.bPO = paramDouble6;
      this.bPP = 0.0D;
      this.bPQ = paramInt3;
      this.bPR = 0.0D;
      this.bPS = paramDouble7;
      this.bPT = paramDouble8;
      AppMethodBeat.o(87961);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(87962);
      String str = String.valueOf(this.mType) + ',' + this.bPH + ',' + this.bPI + ',' + this.bPJ + ',' + this.bPL + ',' + this.bPM + ',' + this.bPN + ',' + this.bPO + ',' + this.bPP + ',' + this.bPQ + ',' + this.bPS + ',' + this.bPT;
      AppMethodBeat.o(87962);
      return str;
    }
  }
  
  static final class b
  {
    double bPH;
    double bPU;
    boolean bPV;
    double[] bPW;
    double bPX;
    boolean bPY;
    double[] bPZ;
    double bQA;
    double[] bQB;
    double[] bQC;
    boolean bQD;
    double bQa;
    int bQb;
    int bQc;
    boolean bQd;
    boolean bQe;
    double bQf;
    double bQg;
    double bQh;
    double bQi;
    double bQj;
    double bQk;
    double bQl;
    double[] bQm;
    private boolean bQn;
    boolean bQo;
    boolean bQp;
    double[] bQq;
    double[][] bQr;
    double bQs;
    double bQt;
    double bQu;
    boolean bQv;
    double bQw;
    double bQx;
    int bQy;
    int bQz;
    
    private b()
    {
      AppMethodBeat.i(87963);
      this.bPW = new double[2];
      this.bPZ = new double[2];
      this.bQm = new double[2];
      this.bQq = new double[4];
      this.bQr = ((double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 }));
      this.bQB = new double[2];
      this.bQC = new double[2];
      AppMethodBeat.o(87963);
    }
    
    private void a(b paramb)
    {
      AppMethodBeat.i(87964);
      this.bPU = paramb.bPU;
      this.bPV = paramb.bPV;
      this.bPW = ((double[])paramb.bPW.clone());
      this.bPX = paramb.bPX;
      this.bPY = paramb.bPY;
      this.bPZ = ((double[])paramb.bPZ.clone());
      this.bQa = paramb.bQa;
      this.bQb = paramb.bQb;
      this.bQc = paramb.bQc;
      this.bQd = paramb.bQd;
      this.bQe = paramb.bQe;
      this.bQf = paramb.bQf;
      this.bQg = paramb.bQg;
      this.bQh = paramb.bQh;
      this.bQi = paramb.bQi;
      this.bQj = paramb.bQj;
      this.bQk = paramb.bQk;
      this.bQl = paramb.bQl;
      this.bQm = ((double[])paramb.bQm.clone());
      this.bQn = paramb.bQn;
      this.bQo = paramb.bQo;
      this.bQp = paramb.bQp;
      this.bPH = paramb.bPH;
      this.bQq = ((double[])paramb.bQq.clone());
      this.bQr[0] = ((double[])paramb.bQr[0].clone());
      this.bQr[1] = ((double[])paramb.bQr[1].clone());
      this.bQr[2] = ((double[])paramb.bQr[2].clone());
      this.bQr[3] = ((double[])paramb.bQr[3].clone());
      this.bQs = paramb.bQs;
      this.bQt = paramb.bQt;
      this.bQu = paramb.bQu;
      this.bQv = paramb.bQv;
      this.bQw = paramb.bQw;
      this.bQx = paramb.bQx;
      this.bQy = paramb.bQy;
      this.bQz = paramb.bQz;
      this.bQA = paramb.bQA;
      this.bQB = ((double[])paramb.bQB.clone());
      this.bQC = ((double[])paramb.bQC.clone());
      this.bQD = paramb.bQD;
      AppMethodBeat.o(87964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.j
 * JD-Core Version:    0.7.0.1
 */