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
  private final Paint nX = new Paint(1);
  private final RectF nY;
  private int nZ;
  
  e()
  {
    this.nX.setStyle(Paint.Style.FILL_AND_STROKE);
    this.nX.setColor(-1);
    this.nX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.nY = new RectF();
  }
  
  final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramFloat1 != this.nY.left) || (paramFloat2 != this.nY.top) || (paramFloat3 != this.nY.right) || (paramFloat4 != this.nY.bottom))
    {
      this.nY.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      invalidateSelf();
    }
  }
  
  final void b(RectF paramRectF)
  {
    a(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
  }
  
  final boolean ca()
  {
    return !this.nY.isEmpty();
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
      paramCanvas.drawRect(this.nY, this.nX);
      if (!(getCallback() instanceof View)) {
        paramCanvas.restoreToCount(this.nZ);
      }
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        this.nZ = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null);
      } else {
        this.nZ = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.e
 * JD-Core Version:    0.7.0.1
 */