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
  private final Paint dyX;
  private final RectF dyY;
  private int dyZ;
  
  a()
  {
    AppMethodBeat.i(209713);
    this.dyX = new Paint(1);
    this.dyX.setStyle(Paint.Style.FILL_AND_STROKE);
    this.dyX.setColor(-1);
    this.dyX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.dyY = new RectF();
    AppMethodBeat.o(209713);
  }
  
  final boolean Xg()
  {
    AppMethodBeat.i(209719);
    if (!this.dyY.isEmpty())
    {
      AppMethodBeat.o(209719);
      return true;
    }
    AppMethodBeat.o(209719);
    return false;
  }
  
  final void c(RectF paramRectF)
  {
    AppMethodBeat.i(209737);
    m(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
    AppMethodBeat.o(209737);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209743);
    Drawable.Callback localCallback = getCallback();
    if ((localCallback instanceof View)) {
      ((View)localCallback).setLayerType(2, null);
    }
    for (;;)
    {
      super.draw(paramCanvas);
      paramCanvas.drawRect(this.dyY, this.dyX);
      if (!(getCallback() instanceof View)) {
        paramCanvas.restoreToCount(this.dyZ);
      }
      AppMethodBeat.o(209743);
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        this.dyZ = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null);
      } else {
        this.dyZ = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
      }
    }
  }
  
  final void m(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(209728);
    if ((paramFloat1 != this.dyY.left) || (paramFloat2 != this.dyY.top) || (paramFloat3 != this.dyY.right) || (paramFloat4 != this.dyY.bottom))
    {
      this.dyY.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      invalidateSelf();
    }
    AppMethodBeat.o(209728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.material.textfield.a
 * JD-Core Version:    0.7.0.1
 */