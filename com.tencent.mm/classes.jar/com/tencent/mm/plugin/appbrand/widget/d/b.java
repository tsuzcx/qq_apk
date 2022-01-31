package com.tencent.mm.plugin.appbrand.widget.d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends Drawable
{
  int borderWidth = 0;
  Paint gaZ = new Paint(1);
  private final RectF gba = new RectF();
  Paint hzj;
  private Path hzk;
  private Path hzl;
  float hzm = 0.0F;
  int hzn = a.fromDPToPix(ae.getContext(), 3);
  int hzo = this.hzn;
  
  public b()
  {
    this.gaZ.setStyle(Paint.Style.FILL);
    this.hzj = new Paint(1);
    this.hzj.setStyle(Paint.Style.FILL);
    this.hzk = new Path();
    this.hzl = new Path();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    float f5 = this.gba.width();
    float f6 = this.gba.height();
    float f1 = this.gba.left;
    float f2 = this.gba.top;
    float f3 = this.gba.right;
    float f4 = this.gba.bottom;
    f5 = Math.min(this.hzm, Math.min(f5, f6) * 0.5F);
    paramCanvas.drawRoundRect(new RectF(this.hzo + f1, this.hzo + f2, f3 - this.hzo, f4 - this.hzo), f5, f5, this.hzj);
    paramCanvas.drawPath(this.hzl, this.hzj);
    paramCanvas.drawRoundRect(new RectF(f1 + this.hzo + this.borderWidth, f2 + this.hzo + this.borderWidth, f3 - this.hzo - this.borderWidth, f4 - this.hzo - this.borderWidth), f5, f5, this.gaZ);
    paramCanvas.drawPath(this.hzk, this.gaZ);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    this.gaZ.setAlpha(paramInt);
    this.hzj.setAlpha(paramInt);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.gba.set(paramInt1, paramInt2, paramInt3, paramInt4);
    float f = (paramInt1 + paramInt3) / 2.0F;
    this.hzl.moveTo(f, paramInt4);
    this.hzl.lineTo(f - this.hzo, paramInt4 - this.hzo);
    this.hzl.lineTo(this.hzo + f, paramInt4 - this.hzo);
    this.hzl.close();
    this.hzk.moveTo(f, paramInt4 - this.borderWidth);
    this.hzk.lineTo(f - this.hzo, paramInt4 - this.hzo - this.borderWidth);
    this.hzk.lineTo(f + this.hzo, paramInt4 - this.hzo - this.borderWidth);
    this.hzk.close();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.gaZ.setColorFilter(paramColorFilter);
    this.hzj.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.b
 * JD-Core Version:    0.7.0.1
 */