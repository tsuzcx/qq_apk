package com.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class l
{
  float bQM;
  long bQQ;
  private final float[] bQR;
  private int bQS;
  private long bQT;
  long bQU;
  
  l()
  {
    AppMethodBeat.i(87949);
    this.bQR = new float[3];
    AppMethodBeat.o(87949);
  }
  
  final void a(float paramFloat, int paramInt, long paramLong)
  {
    AppMethodBeat.i(87950);
    long l = paramLong - this.bQT;
    if (l > this.bQQ)
    {
      Arrays.fill(this.bQR, 0.0F);
      this.bQS = 0;
      this.bQT = 0L;
      this.bQU = 0L;
      this.bQM = 0.0F;
      this.bQR[0] = this.bQR[1];
      this.bQR[1] = this.bQR[2];
      this.bQR[2] = paramFloat;
      if (this.bQR[2] != 0.0F)
      {
        if (this.bQR[0] == 0.0F) {
          break label206;
        }
        paramFloat = (this.bQR[0] + this.bQR[1] + this.bQR[2]) / 3.0F;
      }
    }
    for (;;)
    {
      float f = y.bUP;
      this.bQM = (paramInt / (paramFloat + this.bQR[2] * 3.0F) * f + y.bUQ * (paramInt - this.bQS) / (this.bQS + paramInt + 1));
      this.bQS = paramInt;
      this.bQT = paramLong;
      AppMethodBeat.o(87950);
      return;
      this.bQU = (l + this.bQU);
      break;
      label206:
      if (this.bQR[1] != 0.0F) {
        paramFloat = (this.bQR[1] + this.bQR[2]) / 2.0F;
      } else {
        paramFloat = this.bQR[2];
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.l
 * JD-Core Version:    0.7.0.1
 */