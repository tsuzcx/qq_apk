package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class l
{
  float cjo;
  long cjs;
  private final float[] cjt;
  private int cju;
  private long cjv;
  long cjw;
  
  l()
  {
    AppMethodBeat.i(87949);
    this.cjt = new float[3];
    AppMethodBeat.o(87949);
  }
  
  final void a(float paramFloat, int paramInt, long paramLong)
  {
    AppMethodBeat.i(87950);
    long l = paramLong - this.cjv;
    if (l > this.cjs)
    {
      Arrays.fill(this.cjt, 0.0F);
      this.cju = 0;
      this.cjv = 0L;
      this.cjw = 0L;
      this.cjo = 0.0F;
      this.cjt[0] = this.cjt[1];
      this.cjt[1] = this.cjt[2];
      this.cjt[2] = paramFloat;
      if (this.cjt[2] != 0.0F)
      {
        if (this.cjt[0] == 0.0F) {
          break label206;
        }
        paramFloat = (this.cjt[0] + this.cjt[1] + this.cjt[2]) / 3.0F;
      }
    }
    for (;;)
    {
      float f = y.cnq;
      this.cjo = (paramInt / (paramFloat + this.cjt[2] * 3.0F) * f + y.cnr * (paramInt - this.cju) / (this.cju + paramInt + 1));
      this.cju = paramInt;
      this.cjv = paramLong;
      AppMethodBeat.o(87950);
      return;
      this.cjw = (l + this.cjw);
      break;
      label206:
      if (this.cjt[1] != 0.0F) {
        paramFloat = (this.cjt[1] + this.cjt[2]) / 2.0F;
      } else {
        paramFloat = this.cjt[2];
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.b.a.a.l
 * JD-Core Version:    0.7.0.1
 */