package com.d.a.a;

import java.util.Arrays;

final class l
{
  float aXI;
  long aXM;
  private final float[] aXN = new float[3];
  private int aXO;
  private long aXP;
  long aXQ;
  
  final void a(float paramFloat, int paramInt, long paramLong)
  {
    long l = paramLong - this.aXP;
    if (l > this.aXM)
    {
      Arrays.fill(this.aXN, 0.0F);
      this.aXO = 0;
      this.aXP = 0L;
      this.aXQ = 0L;
      this.aXI = 0.0F;
      this.aXN[0] = this.aXN[1];
      this.aXN[1] = this.aXN[2];
      this.aXN[2] = paramFloat;
      if (this.aXN[2] != 0.0F)
      {
        if (this.aXN[0] == 0.0F) {
          break label196;
        }
        paramFloat = (this.aXN[0] + this.aXN[1] + this.aXN[2]) / 3.0F;
      }
    }
    for (;;)
    {
      float f = y.bbO;
      this.aXI = (paramInt / (paramFloat + this.aXN[2] * 3.0F) * f + y.bbP * (paramInt - this.aXO) / (this.aXO + paramInt + 1));
      this.aXO = paramInt;
      this.aXP = paramLong;
      return;
      this.aXQ = (l + this.aXQ);
      break;
      label196:
      if (this.aXN[1] != 0.0F) {
        paramFloat = (this.aXN[1] + this.aXN[2]) / 2.0F;
      } else {
        paramFloat = this.aXN[2];
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.d.a.a.l
 * JD-Core Version:    0.7.0.1
 */