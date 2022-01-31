package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class l
{
  float bop;
  long bot;
  private final float[] bou;
  private int bov;
  private long bow;
  long box;
  
  l()
  {
    AppMethodBeat.i(55604);
    this.bou = new float[3];
    AppMethodBeat.o(55604);
  }
  
  final void a(float paramFloat, int paramInt, long paramLong)
  {
    AppMethodBeat.i(55605);
    long l = paramLong - this.bow;
    if (l > this.bot)
    {
      Arrays.fill(this.bou, 0.0F);
      this.bov = 0;
      this.bow = 0L;
      this.box = 0L;
      this.bop = 0.0F;
      this.bou[0] = this.bou[1];
      this.bou[1] = this.bou[2];
      this.bou[2] = paramFloat;
      if (this.bou[2] != 0.0F)
      {
        if (this.bou[0] == 0.0F) {
          break label206;
        }
        paramFloat = (this.bou[0] + this.bou[1] + this.bou[2]) / 3.0F;
      }
    }
    for (;;)
    {
      float f = y.bsu;
      this.bop = (paramInt / (paramFloat + this.bou[2] * 3.0F) * f + y.bsv * (paramInt - this.bov) / (this.bov + paramInt + 1));
      this.bov = paramInt;
      this.bow = paramLong;
      AppMethodBeat.o(55605);
      return;
      this.box = (l + this.box);
      break;
      label206:
      if (this.bou[1] != 0.0F) {
        paramFloat = (this.bou[1] + this.bou[2]) / 2.0F;
      } else {
        paramFloat = this.bou[2];
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.b.a.a.l
 * JD-Core Version:    0.7.0.1
 */