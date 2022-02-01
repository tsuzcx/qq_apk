package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class iz
  implements Interpolator
{
  public iz() {}
  
  private iz(byte paramByte) {}
  
  public final float getInterpolation(float paramFloat)
  {
    AppMethodBeat.i(223681);
    paramFloat -= 1.0F;
    paramFloat = (float)Math.sqrt(1.0F - paramFloat * paramFloat);
    AppMethodBeat.o(223681);
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.iz
 * JD-Core Version:    0.7.0.1
 */