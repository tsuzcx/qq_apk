package com.google.android.material.textfield;

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
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
  extends GradientDrawable
{
  private final Paint bFX;
  private final RectF bFY;
  private int bFZ;
  
  a()
  {
    AppMethodBeat.i(240100);
    this.bFX = new Paint(1);
    this.bFX.setStyle(Paint.Style.FILL_AND_STROKE);
    this.bFX.setColor(-1);
    this.bFX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.bFY = new RectF();
    AppMethodBeat.o(240100);
  }
  
  final void c(RectF paramRectF)
  {
    AppMethodBeat.i(240107);
    k(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
    AppMethodBeat.o(240107);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(240110);
    Drawable.Callback localCallback = getCallback();
    if ((localCallback instanceof View)) {
      ((View)localCallback).setLayerType(2, null);
    }
    for (;;)
    {
      super.draw(paramCanvas);
      paramCanvas.drawRect(this.bFY, this.bFX);
      if (!(getCallback() instanceof View)) {
        paramCanvas.restoreToCount(this.bFZ);
      }
      AppMethodBeat.o(240110);
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        this.bFZ = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null);
      } else {
        this.bFZ = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
      }
    }
  }
  
  final void k(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(240105);
    if ((paramFloat1 != this.bFY.left) || (paramFloat2 != this.bFY.top) || (paramFloat3 != this.bFY.right) || (paramFloat4 != this.bFY.bottom))
    {
      this.bFY.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      invalidateSelf();
    }
    AppMethodBeat.o(240105);
  }
  
  final boolean xJ()
  {
    AppMethodBeat.i(240102);
    if (!this.bFY.isEmpty())
    {
      AppMethodBeat.o(240102);
      return true;
    }
    AppMethodBeat.o(240102);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.material.textfield.a
 * JD-Core Version:    0.7.0.1
 */