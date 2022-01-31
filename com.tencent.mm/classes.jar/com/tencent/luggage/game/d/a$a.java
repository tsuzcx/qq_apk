package com.tencent.luggage.game.d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a
  extends Drawable
{
  Paint paint;
  RectF rect;
  
  private a$a(a parama)
  {
    AppMethodBeat.i(140362);
    this.paint = new Paint(1);
    this.rect = new RectF();
    this.paint.setColor(-12748166);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(140362);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(140363);
    float f1 = paramCanvas.getHeight() / 2.0F;
    RectF localRectF1 = this.rect;
    this.rect.top = 0.0F;
    localRectF1.left = 0.0F;
    localRectF1 = this.rect;
    RectF localRectF2 = this.rect;
    float f2 = f1 * 2.0F;
    localRectF2.bottom = f2;
    localRectF1.right = f2;
    paramCanvas.drawArc(this.rect, 90.0F, 180.0F, false, this.paint);
    this.rect.left = (paramCanvas.getWidth() - f1 * 2.0F);
    this.rect.top = 0.0F;
    this.rect.right = paramCanvas.getWidth();
    this.rect.bottom = paramCanvas.getHeight();
    paramCanvas.drawArc(this.rect, -90.0F, 180.0F, false, this.paint);
    paramCanvas.drawRect(f1 - 1.0F, 0.0F, this.bAl.getWidth() - f1 + 1.0F, this.bAl.getHeight(), this.paint);
    AppMethodBeat.o(140363);
  }
  
  public final int getOpacity()
  {
    return -1;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a
 * JD-Core Version:    0.7.0.1
 */