package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.opengles.GL10;

public final class hm
  extends hl
{
  private float g;
  private float h;
  
  private hm(float paramFloat1, float paramFloat2, long paramLong)
  {
    super(paramLong);
    this.g = paramFloat1;
    this.h = paramFloat2;
  }
  
  protected final void a(GL10 paramGL10, long paramLong)
  {
    AppMethodBeat.i(226031);
    float f1 = this.h;
    float f2 = this.g;
    float f3 = this.g;
    f1 = (f1 - f2) * (float)paramLong / (float)this.e + f3;
    paramGL10.glColor4f(f1, f1, f1, f1);
    AppMethodBeat.o(226031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hm
 * JD-Core Version:    0.7.0.1
 */