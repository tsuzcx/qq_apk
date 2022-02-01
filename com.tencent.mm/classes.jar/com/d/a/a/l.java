package com.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class l
{
  float bYH;
  long bYL;
  private final float[] bYM;
  private int bYN;
  private long bYO;
  long bYP;
  
  l()
  {
    AppMethodBeat.i(87949);
    this.bYM = new float[3];
    AppMethodBeat.o(87949);
  }
  
  final void a(float paramFloat, int paramInt, long paramLong)
  {
    AppMethodBeat.i(87950);
    long l = paramLong - this.bYO;
    if (l > this.bYL)
    {
      Arrays.fill(this.bYM, 0.0F);
      this.bYN = 0;
      this.bYO = 0L;
      this.bYP = 0L;
      this.bYH = 0.0F;
      this.bYM[0] = this.bYM[1];
      this.bYM[1] = this.bYM[2];
      this.bYM[2] = paramFloat;
      if (this.bYM[2] != 0.0F)
      {
        if (this.bYM[0] == 0.0F) {
          break label206;
        }
        paramFloat = (this.bYM[0] + this.bYM[1] + this.bYM[2]) / 3.0F;
      }
    }
    for (;;)
    {
      float f = y.ccK;
      this.bYH = (paramInt / (paramFloat + this.bYM[2] * 3.0F) * f + y.ccL * (paramInt - this.bYN) / (this.bYN + paramInt + 1));
      this.bYN = paramInt;
      this.bYO = paramLong;
      AppMethodBeat.o(87950);
      return;
      this.bYP = (l + this.bYP);
      break;
      label206:
      if (this.bYM[1] != 0.0F) {
        paramFloat = (this.bYM[1] + this.bYM[2]) / 2.0F;
      } else {
        paramFloat = this.bYM[2];
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.l
 * JD-Core Version:    0.7.0.1
 */