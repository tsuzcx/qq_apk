package com.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class l
{
  private int bOA;
  private long bOB;
  long bOC;
  float bOu;
  long bOy;
  private final float[] bOz;
  
  l()
  {
    AppMethodBeat.i(87949);
    this.bOz = new float[3];
    AppMethodBeat.o(87949);
  }
  
  final void a(float paramFloat, int paramInt, long paramLong)
  {
    AppMethodBeat.i(87950);
    long l = paramLong - this.bOB;
    if (l > this.bOy)
    {
      Arrays.fill(this.bOz, 0.0F);
      this.bOA = 0;
      this.bOB = 0L;
      this.bOC = 0L;
      this.bOu = 0.0F;
      this.bOz[0] = this.bOz[1];
      this.bOz[1] = this.bOz[2];
      this.bOz[2] = paramFloat;
      if (this.bOz[2] != 0.0F)
      {
        if (this.bOz[0] == 0.0F) {
          break label206;
        }
        paramFloat = (this.bOz[0] + this.bOz[1] + this.bOz[2]) / 3.0F;
      }
    }
    for (;;)
    {
      float f = y.bSx;
      this.bOu = (paramInt / (paramFloat + this.bOz[2] * 3.0F) * f + y.bSy * (paramInt - this.bOA) / (this.bOA + paramInt + 1));
      this.bOA = paramInt;
      this.bOB = paramLong;
      AppMethodBeat.o(87950);
      return;
      this.bOC = (l + this.bOC);
      break;
      label206:
      if (this.bOz[1] != 0.0F) {
        paramFloat = (this.bOz[1] + this.bOz[2]) / 2.0F;
      } else {
        paramFloat = this.bOz[2];
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.l
 * JD-Core Version:    0.7.0.1
 */