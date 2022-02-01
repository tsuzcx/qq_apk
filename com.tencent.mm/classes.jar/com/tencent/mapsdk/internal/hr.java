package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.opengles.GL10;

public final class hr
  extends hl
{
  private float g;
  private float h;
  private float i;
  private float j;
  
  private hr(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong)
  {
    super(paramLong);
    this.g = paramFloat1;
    this.h = paramFloat2;
    this.i = paramFloat3;
    this.j = paramFloat4;
  }
  
  protected final void a(GL10 paramGL10, long paramLong)
  {
    AppMethodBeat.i(225932);
    float f4 = this.h;
    float f5 = this.g;
    float f1 = this.j;
    float f2 = this.i;
    float f3 = this.g;
    f4 = (f4 - f5) * (float)paramLong / (float)this.e;
    f5 = this.i;
    paramGL10.glTranslatef(f4 + f3, (f1 - f2) * (float)paramLong / (float)this.e + f5, 0.0F);
    AppMethodBeat.o(225932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hr
 * JD-Core Version:    0.7.0.1
 */