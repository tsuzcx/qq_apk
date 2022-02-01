package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.opengles.GL10;

public final class hp
  extends ho
{
  private long k;
  private long l;
  
  private hp(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong1, long paramLong2)
  {
    super(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramLong1 + paramLong2);
    AppMethodBeat.i(225979);
    this.k = paramLong1;
    this.l = paramLong2;
    AppMethodBeat.o(225979);
  }
  
  protected final void a(GL10 paramGL10, long paramLong)
  {
    AppMethodBeat.i(225988);
    float f1 = this.h - this.g;
    float f2 = this.j - this.i;
    float f3;
    if (paramLong < this.k)
    {
      f3 = this.g;
      f1 = f1 * (float)paramLong / (float)this.k + f3;
      f3 = this.i;
    }
    for (f2 = f2 * (float)paramLong / (float)this.k + f3;; f2 = this.j - f2 * (float)paramLong / (float)this.l)
    {
      paramGL10.glScalef(f1, f2, 1.0F);
      AppMethodBeat.o(225988);
      return;
      paramLong -= this.k;
      f1 = this.h - f1 * (float)paramLong / (float)this.l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hp
 * JD-Core Version:    0.7.0.1
 */