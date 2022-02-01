package com.tencent.mm.plugin.appbrand.widget.e;

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
  private final RectF cuN;
  private Path oyr;
  private Path oys;
  private int oyt;
  private int oyu;
  private Paint paint;
  private int rc;
  
  public a()
  {
    AppMethodBeat.i(146565);
    this.cuN = new RectF();
    this.borderRadius = 0.0F;
    this.rc = 0;
    this.oyt = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 3);
    this.oyu = this.oyt;
    this.paint = new Paint(1);
    this.paint.setStyle(Paint.Style.FILL);
    this.borderPaint = new Paint(1);
    this.borderPaint.setStyle(Paint.Style.FILL);
    this.oyr = new Path();
    this.oys = new Path();
    AppMethodBeat.o(146565);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(146566);
    float f5 = this.cuN.width();
    float f6 = this.cuN.height();
    float f1 = this.cuN.left;
    float f2 = this.cuN.top;
    float f3 = this.cuN.right;
    float f4 = this.cuN.bottom;
    f5 = Math.min(this.borderRadius, Math.min(f5, f6) * 0.5F);
    paramCanvas.drawRoundRect(new RectF(this.oyu + f1, this.oyu + f2, f3 - this.oyu, f4 - this.oyu), f5, f5, this.borderPaint);
    paramCanvas.drawPath(this.oys, this.borderPaint);
    paramCanvas.drawRoundRect(new RectF(f1 + this.oyu + this.rc, f2 + this.oyu + this.rc, f3 - this.oyu - this.rc, f4 - this.oyu - this.rc), f5, f5, this.paint);
    paramCanvas.drawPath(this.oyr, this.paint);
    AppMethodBeat.o(146566);
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
    this.cuN.set(paramInt1, paramInt2, paramInt3, paramInt4);
    float f = (paramInt1 + paramInt3) / 2.0F;
    this.oys.moveTo(f, paramInt4);
    this.oys.lineTo(f - this.oyu, paramInt4 - this.oyu);
    this.oys.lineTo(this.oyu + f, paramInt4 - this.oyu);
    this.oys.close();
    this.oyr.moveTo(f, paramInt4 - this.rc);
    this.oyr.lineTo(f - this.oyu, paramInt4 - this.oyu - this.rc);
    this.oyr.lineTo(f + this.oyu, paramInt4 - this.oyu - this.rc);
    this.oyr.close();
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
  
  public final void setStroke(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146571);
    this.rc = paramInt1;
    this.oyu = (paramInt1 / 3 + this.oyt);
    this.borderPaint.setColor(paramInt2);
    AppMethodBeat.o(146571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.a
 * JD-Core Version:    0.7.0.1
 */