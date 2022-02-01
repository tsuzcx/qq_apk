package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class jb
  implements Interpolator
{
  public final float getInterpolation(float paramFloat)
  {
    AppMethodBeat.i(223597);
    double d = paramFloat / 0.5D;
    if (d < 1.0D)
    {
      paramFloat = (float)(Math.pow(d, 3.0D) * 0.5D);
      AppMethodBeat.o(223597);
      return paramFloat;
    }
    paramFloat = (float)((Math.pow(d - 2.0D, 3.0D) + 2.0D) * 0.5D);
    AppMethodBeat.o(223597);
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jb
 * JD-Core Version:    0.7.0.1
 */