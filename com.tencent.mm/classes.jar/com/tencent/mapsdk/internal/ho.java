package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.opengles.GL10;

public class ho
  extends hl
{
  protected float g;
  protected float h;
  protected float i;
  protected float j;
  
  public ho(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong)
  {
    super(paramLong);
    this.g = paramFloat1;
    this.h = paramFloat2;
    this.i = paramFloat3;
    this.j = paramFloat4;
  }
  
  protected void a(GL10 paramGL10, long paramLong)
  {
    AppMethodBeat.i(226006);
    float f4 = this.h;
    float f5 = this.g;
    float f1 = this.j;
    float f2 = this.i;
    float f3 = this.g;
    f4 = (f4 - f5) * (float)paramLong / (float)this.e;
    f5 = this.i;
    paramGL10.glScalef(f4 + f3, (f1 - f2) * (float)paramLong / (float)this.e + f5, 1.0F);
    AppMethodBeat.o(226006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ho
 * JD-Core Version:    0.7.0.1
 */