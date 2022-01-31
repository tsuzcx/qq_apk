package com.tencent.mm.plugin.appbrand.game.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

final class a$a
  extends Drawable
{
  Paint gaZ = new Paint(1);
  RectF gba = new RectF();
  
  private a$a(a parama)
  {
    this.gaZ.setColor(-12748166);
    this.gaZ.setStyle(Paint.Style.FILL);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    float f1 = paramCanvas.getHeight() / 2.0F;
    RectF localRectF1 = this.gba;
    this.gba.top = 0.0F;
    localRectF1.left = 0.0F;
    localRectF1 = this.gba;
    RectF localRectF2 = this.gba;
    float f2 = f1 * 2.0F;
    localRectF2.bottom = f2;
    localRectF1.right = f2;
    paramCanvas.drawArc(this.gba, 90.0F, 180.0F, false, this.gaZ);
    this.gba.left = (paramCanvas.getWidth() - f1 * 2.0F);
    this.gba.top = 0.0F;
    this.gba.right = paramCanvas.getWidth();
    this.gba.bottom = paramCanvas.getHeight();
    paramCanvas.drawArc(this.gba, -90.0F, 180.0F, false, this.gaZ);
    paramCanvas.drawRect(f1 - 1.0F, 0.0F, this.gbb.getWidth() - f1 + 1.0F, this.gbb.getHeight(), this.gaZ);
  }
  
  public final int getOpacity()
  {
    return -1;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.a.a
 * JD-Core Version:    0.7.0.1
 */