package android.support.design.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.view.View;

final class e
  extends GradientDrawable
{
  private final Paint qT = new Paint(1);
  private final RectF qU;
  private int qV;
  
  e()
  {
    this.qT.setStyle(Paint.Style.FILL_AND_STROKE);
    this.qT.setColor(-1);
    this.qT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.qU = new RectF();
  }
  
  final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramFloat1 != this.qU.left) || (paramFloat2 != this.qU.top) || (paramFloat3 != this.qU.right) || (paramFloat4 != this.qU.bottom))
    {
      this.qU.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      invalidateSelf();
    }
  }
  
  final void b(RectF paramRectF)
  {
    a(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
  }
  
  final boolean cz()
  {
    return !this.qU.isEmpty();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Drawable.Callback localCallback = getCallback();
    if ((localCallback instanceof View)) {
      ((View)localCallback).setLayerType(2, null);
    }
    for (;;)
    {
      super.draw(paramCanvas);
      paramCanvas.drawRect(this.qU, this.qT);
      if (!(getCallback() instanceof View)) {
        paramCanvas.restoreToCount(this.qV);
      }
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        this.qV = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null);
      } else {
        this.qV = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.e
 * JD-Core Version:    0.7.0.1
 */