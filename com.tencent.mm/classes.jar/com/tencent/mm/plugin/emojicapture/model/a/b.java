package com.tencent.mm.plugin.emojicapture.model.a;

import a.d.b.g;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public final class b
  extends a
{
  private final Matrix aqv;
  private Bitmap bitmap;
  
  public b(Bitmap paramBitmap, Matrix paramMatrix)
  {
    super(paramMatrix);
    this.bitmap = paramBitmap;
    this.aqv = paramMatrix;
  }
  
  public final long aKf()
  {
    return 9223372036854775807L;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    g.k(paramCanvas, "canvas");
    g.k(paramPaint, "paint");
    paramCanvas.save();
    paramCanvas.concat(this.aqv);
    paramCanvas.drawBitmap(this.bitmap, 0.0F, 0.0F, paramPaint);
    paramCanvas.restore();
  }
  
  public final void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.b
 * JD-Core Version:    0.7.0.1
 */