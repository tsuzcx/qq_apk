package com.tencent.mm.particles;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private static final Paint pwT;
  private static Interpolator pwU;
  
  static
  {
    AppMethodBeat.i(151370);
    Paint localPaint = new Paint();
    pwT = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(151370);
  }
  
  public static Interpolator bSN()
  {
    AppMethodBeat.i(151369);
    if (pwU == null) {
      pwU = new Interpolator()
      {
        public final float getInterpolation(float paramAnonymousFloat)
        {
          float f = 1.0F;
          if (paramAnonymousFloat >= 0.9F) {
            f = 1.0F - (paramAnonymousFloat - 0.9F) * 10.0F;
          }
          return f;
        }
      };
    }
    Interpolator localInterpolator = pwU;
    AppMethodBeat.o(151369);
    return localInterpolator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.particles.e
 * JD-Core Version:    0.7.0.1
 */