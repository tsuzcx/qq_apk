package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

final class p$1
  implements ao.a
{
  p$1(p paramp) {}
  
  public final void a(Canvas paramCanvas, RectF paramRectF, float paramFloat, Paint paramPaint)
  {
    float f1 = 2.0F * paramFloat;
    float f2 = paramRectF.width() - f1 - 1.0F;
    float f3 = paramRectF.height();
    if (paramFloat >= 1.0F)
    {
      float f4 = paramFloat + 0.5F;
      this.abR.abQ.set(-f4, -f4, f4, f4);
      int i = paramCanvas.save();
      paramCanvas.translate(paramRectF.left + f4, paramRectF.top + f4);
      paramCanvas.drawArc(this.abR.abQ, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.translate(f2, 0.0F);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawArc(this.abR.abQ, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.translate(f3 - f1 - 1.0F, 0.0F);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawArc(this.abR.abQ, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.translate(f2, 0.0F);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawArc(this.abR.abQ, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.restoreToCount(i);
      paramCanvas.drawRect(paramRectF.left + f4 - 1.0F, paramRectF.top, 1.0F + (paramRectF.right - f4), paramRectF.top + f4, paramPaint);
      paramCanvas.drawRect(paramRectF.left + f4 - 1.0F, paramRectF.bottom - f4, 1.0F + (paramRectF.right - f4), paramRectF.bottom, paramPaint);
    }
    paramCanvas.drawRect(paramRectF.left, paramRectF.top + paramFloat, paramRectF.right, paramRectF.bottom - paramFloat, paramPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.p.1
 * JD-Core Version:    0.7.0.1
 */