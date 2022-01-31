package com.tencent.mm.plugin.appbrand.widget.e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
  extends Drawable
{
  private Paint borderPaint;
  float borderRadius;
  private int borderWidth;
  private Path jro;
  private Path jrp;
  private int jrq;
  private int jrr;
  private Paint paint;
  private final RectF rect;
  
  public a()
  {
    AppMethodBeat.i(51244);
    this.rect = new RectF();
    this.borderRadius = 0.0F;
    this.borderWidth = 0;
    this.jrq = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 3);
    this.jrr = this.jrq;
    this.paint = new Paint(1);
    this.paint.setStyle(Paint.Style.FILL);
    this.borderPaint = new Paint(1);
    this.borderPaint.setStyle(Paint.Style.FILL);
    this.jro = new Path();
    this.jrp = new Path();
    AppMethodBeat.o(51244);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51245);
    float f5 = this.rect.width();
    float f6 = this.rect.height();
    float f1 = this.rect.left;
    float f2 = this.rect.top;
    float f3 = this.rect.right;
    float f4 = this.rect.bottom;
    f5 = Math.min(this.borderRadius, Math.min(f5, f6) * 0.5F);
    paramCanvas.drawRoundRect(new RectF(this.jrr + f1, this.jrr + f2, f3 - this.jrr, f4 - this.jrr), f5, f5, this.borderPaint);
    paramCanvas.drawPath(this.jrp, this.borderPaint);
    paramCanvas.drawRoundRect(new RectF(f1 + this.jrr + this.borderWidth, f2 + this.jrr + this.borderWidth, f3 - this.jrr - this.borderWidth, f4 - this.jrr - this.borderWidth), f5, f5, this.paint);
    paramCanvas.drawPath(this.jro, this.paint);
    AppMethodBeat.o(51245);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(51247);
    this.paint.setAlpha(paramInt);
    this.borderPaint.setAlpha(paramInt);
    AppMethodBeat.o(51247);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(51246);
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.rect.set(paramInt1, paramInt2, paramInt3, paramInt4);
    float f = (paramInt1 + paramInt3) / 2.0F;
    this.jrp.moveTo(f, paramInt4);
    this.jrp.lineTo(f - this.jrr, paramInt4 - this.jrr);
    this.jrp.lineTo(this.jrr + f, paramInt4 - this.jrr);
    this.jrp.close();
    this.jro.moveTo(f, paramInt4 - this.borderWidth);
    this.jro.lineTo(f - this.jrr, paramInt4 - this.jrr - this.borderWidth);
    this.jro.lineTo(f + this.jrr, paramInt4 - this.jrr - this.borderWidth);
    this.jro.close();
    AppMethodBeat.o(51246);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(51249);
    this.paint.setColor(paramInt);
    AppMethodBeat.o(51249);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(51248);
    this.paint.setColorFilter(paramColorFilter);
    this.borderPaint.setColorFilter(paramColorFilter);
    AppMethodBeat.o(51248);
  }
  
  public final void setStroke(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51250);
    this.borderWidth = paramInt1;
    this.jrr = (paramInt1 / 3 + this.jrq);
    this.borderPaint.setColor(paramInt2);
    AppMethodBeat.o(51250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.a
 * JD-Core Version:    0.7.0.1
 */