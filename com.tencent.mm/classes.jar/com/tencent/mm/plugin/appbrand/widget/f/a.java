package com.tencent.mm.plugin.appbrand.widget.f;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  extends Drawable
{
  private Paint borderPaint;
  float borderRadius;
  private int borderWidth;
  private final RectF ctb;
  private Paint paint;
  private Path rAX;
  private Path rAY;
  private int rAZ;
  private int rBa;
  
  public a()
  {
    AppMethodBeat.i(146565);
    this.ctb = new RectF();
    this.borderRadius = 0.0F;
    this.borderWidth = 0;
    this.rAZ = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 3);
    this.rBa = this.rAZ;
    this.paint = new Paint(1);
    this.paint.setStyle(Paint.Style.FILL);
    this.borderPaint = new Paint(1);
    this.borderPaint.setStyle(Paint.Style.FILL);
    this.rAX = new Path();
    this.rAY = new Path();
    AppMethodBeat.o(146565);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(146566);
    float f5 = this.ctb.width();
    float f6 = this.ctb.height();
    float f1 = this.ctb.left;
    float f2 = this.ctb.top;
    float f3 = this.ctb.right;
    float f4 = this.ctb.bottom;
    f5 = Math.min(this.borderRadius, Math.min(f5, f6) * 0.5F);
    paramCanvas.drawRoundRect(new RectF(this.rBa + f1, this.rBa + f2, f3 - this.rBa, f4 - this.rBa), f5, f5, this.borderPaint);
    paramCanvas.drawPath(this.rAY, this.borderPaint);
    paramCanvas.drawRoundRect(new RectF(f1 + this.rBa + this.borderWidth, f2 + this.rBa + this.borderWidth, f3 - this.rBa - this.borderWidth, f4 - this.rBa - this.borderWidth), f5, f5, this.paint);
    paramCanvas.drawPath(this.rAX, this.paint);
    AppMethodBeat.o(146566);
  }
  
  public final void fl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146571);
    this.borderWidth = paramInt1;
    this.rBa = (paramInt1 / 3 + this.rAZ);
    this.borderPaint.setColor(paramInt2);
    AppMethodBeat.o(146571);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(146568);
    this.paint.setAlpha(paramInt);
    this.borderPaint.setAlpha(paramInt);
    AppMethodBeat.o(146568);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(146567);
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.ctb.set(paramInt1, paramInt2, paramInt3, paramInt4);
    float f = (paramInt1 + paramInt3) / 2.0F;
    this.rAY.moveTo(f, paramInt4);
    this.rAY.lineTo(f - this.rBa, paramInt4 - this.rBa);
    this.rAY.lineTo(this.rBa + f, paramInt4 - this.rBa);
    this.rAY.close();
    this.rAX.moveTo(f, paramInt4 - this.borderWidth);
    this.rAX.lineTo(f - this.rBa, paramInt4 - this.rBa - this.borderWidth);
    this.rAX.lineTo(f + this.rBa, paramInt4 - this.rBa - this.borderWidth);
    this.rAX.close();
    AppMethodBeat.o(146567);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(146570);
    this.paint.setColor(paramInt);
    AppMethodBeat.o(146570);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(146569);
    this.paint.setColorFilter(paramColorFilter);
    this.borderPaint.setColorFilter(paramColorFilter);
    AppMethodBeat.o(146569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f.a
 * JD-Core Version:    0.7.0.1
 */