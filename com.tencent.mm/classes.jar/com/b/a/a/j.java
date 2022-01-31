package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

final class j
{
  private double[] bnh;
  final j.b bni;
  private final j.b bnj;
  
  j()
  {
    AppMethodBeat.i(55621);
    this.bnh = new double[4];
    this.bni = new j.b((byte)0);
    this.bnj = new j.b((byte)0);
    AppMethodBeat.o(55621);
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
  
  private void aW(boolean paramBoolean)
  {
    AppMethodBeat.i(55624);
    if (this.bni.bnY != paramBoolean)
    {
      this.bni.bnY = paramBoolean;
      if (paramBoolean)
      {
        this.bni.bnx = this.bni.bof[1];
        this.bni.bnO = this.bni.boe[1];
        b(this.bni.bnk, true);
        AppMethodBeat.o(55624);
        return;
      }
      this.bni.bnx = this.bni.bof[0];
      this.bni.bnO = this.bni.boe[0];
      b(this.bni.bnk, true);
    }
    AppMethodBeat.o(55624);
  }
  
  private void b(double paramDouble, boolean paramBoolean)
  {
    double d3 = paramDouble - this.bni.bnk;
    double d4 = d3 * d3;
    double d2;
    double d1;
    label97:
    Object localObject;
    if (paramBoolean)
    {
      this.bni.bnU[2][2] = this.bni.bnO;
      this.bni.bnU[2][3] = 0L;
      this.bni.bnU[3][2] = 0L;
      this.bni.bnU[3][3] = this.bni.bnO;
      if (d3 > 0.5D)
      {
        d2 = 1.0D;
        d1 = 0.0D;
        if (d1 < d3) {
          break label496;
        }
        localObject = this.bni;
        ((j.b)localObject).bnW = (d2 * ((j.b)localObject).bnW);
      }
      this.bni.bnT[0] += this.bni.bnT[2] * d3;
      this.bni.bnT[1] += this.bni.bnT[3] * d3;
      if (!this.bni.bnY) {
        break label517;
      }
      this.bni.bnU[0][0] += this.bni.bnU[2][2] * d4;
      this.bni.bnU[0][1] += this.bni.bnU[2][3] * d4;
      this.bni.bnU[1][0] += this.bni.bnU[3][2] * d4;
      this.bni.bnU[1][1] += this.bni.bnU[3][3] * d4;
    }
    for (;;)
    {
      this.bni.bnk = paramDouble;
      return;
      d1 = 1.0D;
      d2 = d1;
      if (d3 > 0.5D) {}
      for (d2 = 0.0D;; d2 += 1.0D)
      {
        if (d2 >= d3)
        {
          d2 = d1;
          localObject = this.bni.bnU[2];
          localObject[2] *= d2;
          localObject = this.bni.bnU[2];
          localObject[3] *= d2;
          localObject = this.bni.bnU[3];
          localObject[2] *= d2;
          localObject = this.bni.bnU[3];
          localObject[3] = (d2 * localObject[3]);
          break;
        }
        d1 *= this.bni.bnx;
      }
      label496:
      d2 *= this.bni.bnX;
      d1 += 1.0D;
      break label97;
      label517:
      this.bni.bnU[0][0] = (this.bni.bnU[0][0] + (this.bni.bnU[0][2] + this.bni.bnU[2][0]) * d3 + this.bni.bnU[2][2] * d4);
      this.bni.bnU[1][1] = (this.bni.bnU[1][1] + (this.bni.bnU[1][3] + this.bni.bnU[3][1]) * d3 + d4 * this.bni.bnU[3][3]);
      this.bni.bnU[0][2] += this.bni.bnU[2][2] * d3;
      this.bni.bnU[2][0] += this.bni.bnU[2][2] * d3;
      this.bni.bnU[1][3] += this.bni.bnU[3][3] * d3;
      this.bni.bnU[3][1] += d3 * this.bni.bnU[3][3];
    }
  }
  
  private void b(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(55626);
    double d3;
    double d1;
    double d4;
    int i;
    if ((this.bni.bnR) && (this.bni.bnB))
    {
      Object localObject = new double[2];
      double[] arrayOfDouble = new double[2];
      double d5 = this.bni.bod;
      localObject[0] = (this.bni.bnT[0] - this.bni.bnC[0]);
      localObject[1] = (this.bni.bnT[1] - this.bni.bnC[1]);
      paramArrayOfDouble[0] -= this.bni.bnC[0];
      paramArrayOfDouble[1] -= this.bni.bnC[1];
      double d2 = Math.sqrt(localObject[0] * localObject[0] + localObject[1] * localObject[1]);
      d3 = Math.sqrt(arrayOfDouble[0] * arrayOfDouble[0] + arrayOfDouble[1] * arrayOfDouble[1]);
      if ((d2 > this.bni.bnJ) && (d3 > this.bni.bnJ))
      {
        d1 = Math.atan2(localObject[1], localObject[0]);
        d4 = Math.atan2(arrayOfDouble[1], arrayOfDouble[0]) - d1;
        if (d4 <= 3.141592653589793D) {
          break label380;
        }
        d1 = d4 - 6.283185307179586D;
        localObject = this.bni;
        ((j.b)localObject).bnV = (d5 * d1 + ((j.b)localObject).bnV);
        if (d1 * d1 <= 4.0D * this.bni.bnW) {
          break label402;
        }
        i = 1;
        label283:
        d4 = Math.sqrt(this.bni.bnU[0][0] + this.bni.bnU[1][1]);
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
    for (this.bni.bnW = (d1 * d1);; this.bni.bnW = (1.0D / (1.0D / (d1 * d1) + 1.0D / this.bni.bnW)))
    {
      this.bni.bnC[0] = paramArrayOfDouble[0];
      this.bni.bnC[1] = paramArrayOfDouble[1];
      this.bni.bnB = true;
      AppMethodBeat.o(55626);
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
  
  private void c(double paramDouble, boolean paramBoolean)
  {
    double d3 = paramDouble - this.bnj.bnk;
    double d4 = d3 * d3;
    double d2;
    double d1;
    label97:
    Object localObject;
    if (paramBoolean)
    {
      this.bnj.bnU[2][2] = this.bnj.bnO;
      this.bnj.bnU[2][3] = 0L;
      this.bnj.bnU[3][2] = 0L;
      this.bnj.bnU[3][3] = this.bnj.bnO;
      if (d3 > 0.5D)
      {
        d2 = 1.0D;
        d1 = 0.0D;
        if (d1 < d3) {
          break label496;
        }
        localObject = this.bnj;
        ((j.b)localObject).bnW = (d2 * ((j.b)localObject).bnW);
      }
      this.bnj.bnT[0] += this.bnj.bnT[2] * d3;
      this.bnj.bnT[1] += this.bnj.bnT[3] * d3;
      if (!this.bnj.bnY) {
        break label517;
      }
      this.bnj.bnU[0][0] += this.bnj.bnU[2][2] * d4;
      this.bnj.bnU[0][1] += this.bnj.bnU[2][3] * d4;
      this.bnj.bnU[1][0] += this.bnj.bnU[3][2] * d4;
      this.bnj.bnU[1][1] += this.bnj.bnU[3][3] * d4;
    }
    for (;;)
    {
      this.bnj.bnk = paramDouble;
      return;
      d1 = 1.0D;
      d2 = d1;
      if (d3 > 0.5D) {}
      for (d2 = 0.0D;; d2 += 1.0D)
      {
        if (d2 >= d3)
        {
          d2 = d1;
          localObject = this.bnj.bnU[2];
          localObject[2] *= d2;
          localObject = this.bnj.bnU[2];
          localObject[3] *= d2;
          localObject = this.bnj.bnU[3];
          localObject[2] *= d2;
          localObject = this.bnj.bnU[3];
          localObject[3] = (d2 * localObject[3]);
          break;
        }
        d1 *= this.bnj.bnx;
      }
      label496:
      d2 *= this.bnj.bnX;
      d1 += 1.0D;
      break label97;
      label517:
      this.bnj.bnU[0][0] = (this.bnj.bnU[0][0] + (this.bnj.bnU[0][2] + this.bnj.bnU[2][0]) * d3 + this.bnj.bnU[2][2] * d4);
      this.bnj.bnU[1][1] = (this.bnj.bnU[1][1] + (this.bnj.bnU[1][3] + this.bnj.bnU[3][1]) * d3 + d4 * this.bnj.bnU[3][3]);
      this.bnj.bnU[0][2] += this.bnj.bnU[2][2] * d3;
      this.bnj.bnU[2][0] += this.bnj.bnU[2][2] * d3;
      this.bnj.bnU[1][3] += this.bnj.bnU[3][3] * d3;
      this.bnj.bnU[3][1] += d3 * this.bnj.bnU[3][3];
    }
  }
  
  final void a(int paramInt, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    AppMethodBeat.i(55627);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(55627);
      return;
      paramArrayOfDouble2[0] = ((paramArrayOfDouble1[1] - this.bni.bnP[1]) * 6378137.0D * Math.cos(this.bni.bnP[0]));
      paramArrayOfDouble2[1] = ((paramArrayOfDouble1[0] - this.bni.bnP[0]) * 6378137.0D);
      AppMethodBeat.o(55627);
      return;
      paramArrayOfDouble2[0] = (paramArrayOfDouble1[1] / 6378137.0D + this.bni.bnP[0]);
      paramArrayOfDouble2[1] = (paramArrayOfDouble1[0] / (Math.cos(this.bni.bnP[0]) * 6378137.0D) + this.bni.bnP[1]);
    }
  }
  
  protected final void a(long paramLong, double paramDouble1, double paramDouble2, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(55622);
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
      this.bni.bnY = true;
      this.bni.bof[0] = 3.0D;
      this.bni.bof[1] = 1.2D;
      this.bni.bod = 0.5D;
      this.bni.bnx = 1.2D;
      this.bni.bnD = 4.0D;
      this.bni.bnE = 0;
      this.bni.bnG = true;
      this.bni.bnF = i;
      this.bni.bny = false;
      this.bni.bnB = false;
      this.bni.bnM = 40.0D;
      this.bni.bnN = 0.1570796326794897D;
      this.bni.bnO = 1.0D;
      this.bni.boe[0] = 400.0D;
      this.bni.boe[1] = 1.0D;
      this.bni.bnR = paramBoolean2;
      this.bni.bnS = false;
      this.bni.bnH = true;
      this.bni.bnI = 0.3333333333333333D;
      this.bni.bnJ = 5.0D;
      this.bni.bnK = 0.5D;
      this.bni.bnL = 1.0D;
      this.bni.bnZ = 0.5D;
      this.bni.boa = 1.0D;
      this.bni.bob = 0;
      this.bni.boc = 2;
      this.bni.bog = false;
      this.bni.bnP[0] = arrayOfDouble2[0];
      this.bni.bnP[1] = arrayOfDouble2[1];
      arrayOfDouble2 = new double[2];
      a(0, new double[] { paramDouble1, paramDouble2 }, arrayOfDouble2);
      this.bni.bnk = d1;
      this.bni.bnT[0] = arrayOfDouble2[0];
      this.bni.bnT[1] = arrayOfDouble2[1];
      this.bni.bnT[2] = arrayOfDouble1[0];
      this.bni.bnT[3] = arrayOfDouble1[1];
      this.bni.bnV = 0.0D;
      this.bni.bnW = 1.0D;
      this.bni.bnX = 1.005D;
      this.bni.bnU[0][0] = tmp24_22;
      this.bni.bnU[0][1] = 0L;
      this.bni.bnU[0][2] = 0L;
      this.bni.bnU[0][3] = 0L;
      this.bni.bnU[1][0] = 0L;
      this.bni.bnU[1][1] = tmp24_22;
      this.bni.bnU[1][2] = 0L;
      this.bni.bnU[1][3] = 0L;
      this.bni.bnU[2][0] = 0L;
      this.bni.bnU[2][1] = 0L;
      this.bni.bnU[2][2] = 4607182418800017408L;
      this.bni.bnU[2][3] = 0L;
      this.bni.bnU[3][0] = 0L;
      this.bni.bnU[3][1] = 0L;
      this.bni.bnU[3][2] = 0L;
      this.bni.bnU[3][3] = 4607182418800017408L;
      aV(paramBoolean1);
      AppMethodBeat.o(55622);
      return;
    }
  }
  
  protected final void a(j.a parama)
  {
    AppMethodBeat.i(55625);
    if (parama.bnp <= 0.0D)
    {
      AppMethodBeat.o(55625);
      return;
    }
    double d1;
    if (this.bni.bny)
    {
      d1 = parama.bnk - this.bni.bnA;
      if (d1 < -10.0D)
      {
        AppMethodBeat.o(55625);
        return;
      }
      if (d1 <= 0.0D) {
        parama.bnk = (this.bni.bnA + 0.5D);
      }
    }
    double[] arrayOfDouble1 = new double[2];
    a(0, new double[] { parama.bnl, parama.bnm }, arrayOfDouble1);
    parama.bnn[0] = arrayOfDouble1[0];
    parama.bnn[1] = arrayOfDouble1[1];
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
    if (this.bni.bnY)
    {
      double d5;
      if ((parama.mType != 3) || (this.bni.bny))
      {
        if (parama.mType != 3) {
          break label1192;
        }
        d5 = parama.bnk - this.bni.bnA;
        if (d5 > 0.0D)
        {
          localObject2 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
          localObject1 = new double[2];
          d4 = arrayOfDouble1[0] - this.bni.bnz[0];
          d3 = arrayOfDouble1[1] - this.bni.bnz[1];
          d1 = d3;
          d2 = d4;
          if (this.bni.bnR)
          {
            d2 = d4 * Math.cos(this.bni.bnV) - Math.sin(this.bni.bnV) * d3;
            d1 = Math.sin(this.bni.bnV);
            d1 = d3 * Math.cos(this.bni.bnV) + d1 * d2;
          }
          d4 = Math.sqrt(d2 * d2 + d1 * d1);
          d3 = d4 / this.bni.bnM;
          d3 *= d3;
          if (d3 <= 0.0625D) {
            break label1176;
          }
          d4 *= this.bni.bnN;
          d4 *= d4;
          if (d4 <= 0.0625D) {
            break label1184;
          }
        }
      }
      for (;;)
      {
        d3 = (d3 + d4) / d5;
        d4 = this.bni.bnU[2][2];
        double d6 = this.bni.bnU[2][3];
        double d7 = this.bni.bnU[3][2];
        double d8 = this.bni.bnU[3][3];
        localObject3 = this.bnh;
        a(new double[] { d4, d6, d7, d8 }, (double[])localObject3);
        localObject2[0][0] = this.bnh[0];
        localObject2[0][1] = this.bnh[1];
        localObject2[1][0] = this.bnh[2];
        localObject2[1][1] = this.bnh[3];
        d4 = d2 / d5 - this.bni.bnT[2];
        d6 = d1 / d5 - this.bni.bnT[3];
        d7 = localObject2[0][0];
        d8 = localObject2[0][1];
        if (Math.sqrt(d4 * d6 * localObject2[1][0] + (d4 * d4 * d7 + d4 * d6 * d8) + d6 * d6 * localObject2[1][1]) > 2.0D)
        {
          this.bni.bnU[2][2] = this.bni.bnO;
          this.bni.bnU[2][3] = 0L;
          this.bni.bnU[3][2] = 0L;
          this.bni.bnU[3][3] = this.bni.bnO;
          localObject2[0][0] = (1.0D / this.bni.bnO);
          localObject2[0][1] = 0L;
          localObject2[1][0] = 0L;
          localObject2[1][1] = (1.0D / this.bni.bnO);
        }
        localObject1[0] = (localObject2[0][0] * this.bni.bnT[2] + localObject2[0][1] * this.bni.bnT[3]);
        localObject1[1] = (localObject2[1][0] * this.bni.bnT[2] + localObject2[1][1] * this.bni.bnT[3]);
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
        localObject2 = this.bnh;
        a(new double[] { d1, d2, d3, d4 }, (double[])localObject2);
        this.bni.bnU[2][2] = this.bnh[0];
        this.bni.bnU[2][3] = this.bnh[1];
        this.bni.bnU[3][2] = this.bnh[2];
        this.bni.bnU[3][3] = this.bnh[3];
        this.bni.bnT[2] = (this.bni.bnU[2][2] * localObject1[0] + this.bni.bnU[2][3] * localObject1[1]);
        this.bni.bnT[3] = (this.bni.bnU[3][2] * localObject1[0] + this.bni.bnU[3][3] * localObject1[1]);
        b(parama.bnk, false);
        if (parama.mType != 3) {
          break label4325;
        }
        this.bni.bnz[0] = arrayOfDouble1[0];
        this.bni.bnz[1] = arrayOfDouble1[1];
        this.bni.bnA = parama.bnk;
        this.bni.bny = true;
        AppMethodBeat.o(55625);
        return;
        d3 = 0.0625D;
        break;
        d4 = 0.0625D;
      }
      d2 = 0.0D;
      d1 = 0.0D;
      localObject2 = new double[2];
      localObject1 = new double[2];
      b(parama.bnk, false);
      if (this.bni.bnH)
      {
        if (!this.bni.bnB)
        {
          i = 1;
          j = 1;
          label1242:
          if (i == 0) {
            break label2043;
          }
          if (this.bni.bnB)
          {
            if (d2 >= d1) {
              break label2045;
            }
            d3 = this.bni.bnK;
            label1273:
            d1 = d3 + d1 / d2 * (1.0D - d3);
            arrayOfDouble1[0] = (this.bni.bnC[0] + localObject1[0] * d1);
            d2 = this.bni.bnC[1];
            arrayOfDouble1[1] = (d1 * localObject1[1] + d2);
          }
          if (j == 0) {
            break label2057;
          }
          b(arrayOfDouble1);
        }
        for (;;)
        {
          this.bni.bnT[0] = arrayOfDouble1[0];
          this.bni.bnT[1] = arrayOfDouble1[1];
          this.bni.bnU[0][0] = (parama.bnp * parama.bnp);
          this.bni.bnU[0][1] = 0L;
          this.bni.bnU[1][0] = 0L;
          this.bni.bnU[1][1] = (parama.bnp * parama.bnp);
          break;
          localObject2[0] = (this.bni.bnT[0] - this.bni.bnC[0]);
          localObject2[1] = (this.bni.bnT[1] - this.bni.bnC[1]);
          arrayOfDouble1[0] -= this.bni.bnC[0];
          arrayOfDouble1[1] -= this.bni.bnC[1];
          d4 = Math.sqrt(localObject2[0] * localObject2[0] + localObject2[1] * localObject2[1]);
          d3 = Math.sqrt(localObject1[0] * localObject1[0] + localObject1[1] * localObject1[1]);
          if ((d3 > this.bni.bnJ) && (d4 > this.bni.bnJ))
          {
            d1 = d3 / d4;
            d2 = d3 - d4;
            d5 = Math.sqrt(this.bni.bnU[0][0] + this.bni.bnU[1][1]);
            if (d4 > 3.0D * this.bni.bnJ)
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
                d1 = d2 / Math.sqrt(this.bni.bnW);
                d2 = Math.sqrt(d1 * d1 + d5 * d5);
                if (d2 >= this.bni.bnD) {
                  break label1826;
                }
                this.bni.bob = 0;
                d1 = d2;
              }
              for (;;)
              {
                if (d1 <= this.bni.bnD) {
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
                if (d5 < this.bni.bnD)
                {
                  localObject2 = this.bni;
                  i = ((j.b)localObject2).bob + 1;
                  ((j.b)localObject2).bob = i;
                  d1 = d2;
                  if (i >= this.bni.boc)
                  {
                    this.bni.bob = 0;
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
            if ((d1 < this.bni.bnI) || (1.0D / d1 < this.bni.bnI))
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
          if (((d3 < this.bni.bnJ) && (parama.mType == 2)) || ((d3 < this.bni.bnJ * 0.5D) && (parama.mType == 1)))
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
          d3 = this.bni.bnL;
          break label1273;
          label2057:
          this.bni.bnC[0] = arrayOfDouble1[0];
          this.bni.bnC[1] = arrayOfDouble1[1];
        }
      }
      j.b.a(this.bnj, this.bni);
      c(parama.bnk, false);
      if (this.bnj.bnG) {
        if (!this.bni.bnB)
        {
          d1 = 0.0D;
          label2128:
          if (d1 <= this.bni.bnD) {
            break label3171;
          }
          j.b.a(this.bnj, this.bni);
          c(parama.bnk, true);
          if (!this.bni.bnG) {
            break label2881;
          }
          d3 = this.bni.bnC[0] - this.bnj.bnT[0];
          d4 = this.bni.bnC[1] - this.bnj.bnT[1];
          d1 = this.bni.bnC[0] - arrayOfDouble1[0];
          d2 = this.bni.bnC[1] - arrayOfDouble1[1];
          d3 = Math.sqrt(d3 * d3 + d4 * d4);
          d1 = Math.sqrt(d1 * d1 + d2 * d2);
          d2 = Math.sqrt(this.bnj.bnU[0][0] * this.bnj.bnU[0][0] + this.bnj.bnU[1][1] * this.bnj.bnU[1][1]);
          d1 = Math.abs(d3 - d1) / d2;
          label2335:
          if (d1 <= this.bnj.bnD) {
            break label3143;
          }
          if (this.bni.bnE >= this.bni.bnF) {
            break label3121;
          }
          this.bni.bnE += 1;
        }
      }
      for (;;)
      {
        this.bni.bnT[0] = arrayOfDouble1[0];
        this.bni.bnT[1] = arrayOfDouble1[1];
        this.bni.bnU[0][0] = (parama.bnp * parama.bnp);
        this.bni.bnU[0][1] = 0L;
        this.bni.bnU[1][0] = 0L;
        this.bni.bnU[1][1] = (parama.bnp * parama.bnp);
        break;
        d3 = this.bni.bnC[0] - this.bnj.bnT[0];
        d4 = this.bni.bnC[1] - this.bnj.bnT[1];
        d1 = this.bni.bnC[0] - arrayOfDouble1[0];
        d2 = this.bni.bnC[1] - arrayOfDouble1[1];
        d3 = Math.sqrt(d3 * d3 + d4 * d4);
        d1 = Math.sqrt(d1 * d1 + d2 * d2);
        d2 = Math.sqrt(this.bni.bnU[0][0] * this.bni.bnU[0][0] + this.bni.bnU[1][1] * this.bni.bnU[1][1]);
        d1 = Math.abs(d3 - d1) / d2;
        break label2128;
        d1 = arrayOfDouble1[0] - this.bnj.bnT[0];
        d2 = arrayOfDouble1[1] - this.bnj.bnT[1];
        localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
        d3 = 1.0D / (this.bnj.bnU[0][0] * this.bnj.bnU[1][1] - this.bnj.bnU[0][1] * this.bnj.bnU[1][0]);
        localObject1[0][0] = (this.bnj.bnU[1][1] * d3);
        localObject1[1][1] = (this.bnj.bnU[0][0] * d3);
        localObject1[0][1] = (-this.bnj.bnU[0][1] * d3);
        localObject1[1][0] = (d3 * -this.bnj.bnU[1][0]);
        d3 = localObject1[0][0];
        d4 = localObject1[1][0];
        d1 = Math.sqrt(localObject1[1][1] * (d2 * d2) + (d1 * 2.0D * d2 * d4 + d1 * d1 * d3));
        break label2128;
        label2881:
        d1 = arrayOfDouble1[0] - this.bnj.bnT[0];
        d2 = arrayOfDouble1[1] - this.bnj.bnT[1];
        localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
        d3 = 1.0D / (this.bnj.bnU[0][0] * this.bnj.bnU[1][1] - this.bnj.bnU[0][1] * this.bnj.bnU[1][0]);
        localObject1[0][0] = (this.bnj.bnU[1][1] * d3);
        localObject1[1][1] = (this.bnj.bnU[0][0] * d3);
        localObject1[0][1] = (-this.bnj.bnU[0][1] * d3);
        localObject1[1][0] = (d3 * -this.bnj.bnU[1][0]);
        d3 = localObject1[0][0];
        d4 = localObject1[1][0];
        d1 = Math.sqrt(localObject1[1][1] * (d2 * d2) + (d1 * 2.0D * d2 * d4 + d1 * d1 * d3));
        break label2335;
        label3121:
        j.b.a(this.bni, this.bnj);
        this.bni.bnE = 0;
        continue;
        label3143:
        j.b.a(this.bni, this.bnj);
        this.bni.bnE = 0;
        b(arrayOfDouble1);
        continue;
        label3171:
        j.b.a(this.bni, this.bnj);
        this.bni.bnE = 0;
        b(arrayOfDouble1);
      }
    }
    if (parama.mType != 3)
    {
      j = 0;
      localObject2 = new double[2];
      localObject1 = new double[2];
      arrayOfDouble1 = new double[2];
      b(parama.bnk, false);
      if (!this.bni.bnB)
      {
        i = 1;
        j = 0;
        this.bni.bnE = 0;
      }
      while (i != 0) {
        if (j == 0)
        {
          this.bni.bnT[0] = parama.bnn[0];
          this.bni.bnT[1] = parama.bnn[1];
          this.bni.bnT[2] = 0.0D;
          this.bni.bnT[3] = 0.0D;
          this.bni.bnU[0][0] = (parama.bnp * parama.bnp);
          this.bni.bnU[0][1] = 0L;
          this.bni.bnU[0][2] = 0L;
          this.bni.bnU[0][3] = 0L;
          this.bni.bnU[1][0] = 0L;
          this.bni.bnU[1][1] = this.bni.bnU[0][0];
          this.bni.bnU[1][2] = 0L;
          this.bni.bnU[1][2] = 0L;
          this.bni.bnU[2][0] = 0L;
          this.bni.bnU[2][1] = 0L;
          this.bni.bnU[2][2] = this.bni.bnO;
          this.bni.bnU[2][3] = 0L;
          this.bni.bnU[3][0] = 0L;
          this.bni.bnU[3][1] = 0L;
          this.bni.bnU[3][2] = 0L;
          this.bni.bnU[3][3] = this.bni.bnO;
          this.bni.bnC[0] = parama.bnn[0];
          this.bni.bnC[1] = parama.bnn[1];
          this.bni.bnB = true;
          AppMethodBeat.o(55625);
          return;
          localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
          localObject2[0] = (parama.bnn[0] - this.bni.bnT[0]);
          localObject2[1] = (parama.bnn[1] - this.bni.bnT[1]);
          d1 = this.bni.bnU[0][0];
          d2 = this.bni.bnU[0][1];
          d3 = this.bni.bnU[1][0];
          d4 = this.bni.bnU[1][1];
          double[] arrayOfDouble2 = this.bnh;
          a(new double[] { d1, d2, d3, d4 }, arrayOfDouble2);
          localObject3[0][0] = this.bnh[0];
          localObject3[0][1] = this.bnh[1];
          localObject3[1][0] = this.bnh[2];
          localObject3[1][1] = this.bnh[3];
          if (Math.sqrt(localObject2[0] * localObject2[0] * localObject3[0][0] + 2.0D * localObject2[0] * localObject2[1] * localObject3[1][0] + localObject2[1] * localObject2[1] * localObject3[1][1]) > this.bni.bnD)
          {
            localObject2 = this.bni;
            i = ((j.b)localObject2).bnE + 1;
            ((j.b)localObject2).bnE = i;
            if (i >= this.bni.bnF)
            {
              i = 1;
              j = 0;
              this.bni.bnE = 0;
            }
            else
            {
              i = 0;
            }
          }
          else
          {
            this.bni.bnE = 0;
            i = 1;
            j = 1;
          }
        }
        else
        {
          localObject3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 4, 4 });
          localObject2 = new double[2];
          localObject1[0] = (this.bni.bnT[0] - this.bni.bnC[0]);
          localObject1[1] = (this.bni.bnT[1] - this.bni.bnC[1]);
          arrayOfDouble1[0] = (parama.bnn[0] - this.bni.bnC[0]);
          arrayOfDouble1[1] = (parama.bnn[1] - this.bni.bnC[1]);
          d2 = Math.sqrt(arrayOfDouble1[0] * arrayOfDouble1[0] + arrayOfDouble1[1] * arrayOfDouble1[1]);
          d1 = localObject1[0];
          d3 = localObject1[0];
          d4 = localObject1[1];
          d4 = Math.sqrt(localObject1[1] * d4 + d1 * d3);
          if (d2 >= d4) {
            break label4331;
          }
          d1 = this.bni.bnZ;
          if (a(this.bni.bnU, (double[][])localObject3))
          {
            d3 = 1.0D / (parama.bnp * parama.bnp);
            localObject1 = new double[4];
            if (!this.bni.bog) {
              break label4342;
            }
            d1 += d4 / d2 * (1.0D - d1);
            localObject2[0] = (this.bni.bnC[0] + arrayOfDouble1[0] * d1);
            d2 = this.bni.bnC[1];
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
      if (a((double[][])localObject3, this.bni.bnU))
      {
        localObject1[0] += localObject2[0] * d3;
        localObject1[1] += localObject2[1] * d3;
        i = 0;
        if (i < 4) {
          break label4464;
        }
        this.bni.bnC[0] = localObject2[0];
        this.bni.bnC[1] = localObject2[1];
      }
      label4325:
      AppMethodBeat.o(55625);
      return;
      label4331:
      d1 = this.bni.boa;
      break;
      label4342:
      localObject2[0] = (this.bni.bnT[0] * (1.0D - d1) + parama.bnn[0] * d1);
      d2 = this.bni.bnT[1];
      localObject2[1] = (d1 * parama.bnn[1] + d2 * (1.0D - d1));
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
      localObject1[i] += localObject3[i][j] * this.bni.bnT[j];
      j += 1;
    }
    label4464:
    this.bni.bnT[i] = 0.0D;
    j = 0;
    for (;;)
    {
      if (j >= 4)
      {
        i += 1;
        break;
      }
      parama = this.bni.bnT;
      parama[i] += this.bni.bnU[i][j] * localObject1[j];
      j += 1;
    }
  }
  
  protected final void aV(boolean paramBoolean)
  {
    AppMethodBeat.i(55623);
    if (paramBoolean) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      aW(paramBoolean);
      AppMethodBeat.o(55623);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.b.a.a.j
 * JD-Core Version:    0.7.0.1
 */