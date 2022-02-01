package com.tencent.mm.particles.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends b
{
  private final Bitmap bitmap;
  private final float iMs;
  private final float iMt;
  
  public a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(151371);
    this.bitmap = paramBitmap;
    this.iMs = (paramBitmap.getWidth() / 2.0F);
    this.iMt = (paramBitmap.getHeight() / 2.0F);
    AppMethodBeat.o(151371);
  }
  
  protected final void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(151374);
    paramMatrix.preTranslate(paramFloat1, paramFloat2);
    paramMatrix.preRotate(paramFloat3, this.iMs, this.iMt);
    paramCanvas.drawBitmap(this.bitmap, paramMatrix, paramPaint);
    AppMethodBeat.o(151374);
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(151373);
    int i = this.bitmap.getHeight();
    AppMethodBeat.o(151373);
    return i;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(151372);
    int i = this.bitmap.getWidth();
    AppMethodBeat.o(151372);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.particles.a.a
 * JD-Core Version:    0.7.0.1
 */