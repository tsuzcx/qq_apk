package com.tencent.mm.plugin.luckymoney.particles.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public final class a
  extends b
{
  private final Bitmap bitmap;
  private final float lSV;
  private final float lSW;
  
  public a(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    this.lSV = (paramBitmap.getWidth() / 2.0F);
    this.lSW = (paramBitmap.getHeight() / 2.0F);
  }
  
  protected final void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramMatrix.preTranslate(paramFloat1, paramFloat2);
    paramMatrix.preRotate(paramFloat3, this.lSV, this.lSW);
    paramCanvas.drawBitmap(this.bitmap, paramMatrix, paramPaint);
  }
  
  public final int getHeight()
  {
    return this.bitmap.getHeight();
  }
  
  public final int getWidth()
  {
    return this.bitmap.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.particles.a.a
 * JD-Core Version:    0.7.0.1
 */