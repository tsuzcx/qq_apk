package com.tencent.mm.particles;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private static final Paint ghI;
  private static Interpolator ghJ;
  
  static
  {
    AppMethodBeat.i(151594);
    Paint localPaint = new Paint();
    ghI = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(151594);
  }
  
  public static Interpolator aoa()
  {
    AppMethodBeat.i(151593);
    if (ghJ == null) {
      ghJ = new e.1();
    }
    Interpolator localInterpolator = ghJ;
    AppMethodBeat.o(151593);
    return localInterpolator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.particles.e
 * JD-Core Version:    0.7.0.1
 */