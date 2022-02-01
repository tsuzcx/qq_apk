package com.tencent.mm.plugin.appbrand.widget.d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
  extends Drawable
{
  private Paint borderPaint;
  float borderRadius;
  private int borderWidth;
  private final RectF ciQ;
  private Path njC;
  private Path njD;
  private int njE;
  private int njF;
  private Paint paint;
  
  public a()
  {
    AppMethodBeat.i(146565);
    this.ciQ = new RectF();
    this.borderRadius = 0.0F;
    this.borderWidth = 0;
    this.njE = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 3);
    this.njF = this.njE;
    this.paint = new Paint(1);
    this.paint.setStyle(Paint.Style.FILL);
    this.borderPaint = new Paint(1);
    this.borderPaint.setStyle(Paint.Style.FILL);
    this.njC = new Path();
    this.njD = new Path();
    AppMethodBeat.o(146565);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(146566);
    float f5 = this.ciQ.width();
    float f6 = this.ciQ.height();
    float f1 = this.ciQ.left;
    float f2 = this.ciQ.top;
    float f3 = this.ciQ.right;
    float f4 = this.ciQ.bottom;
    f5 = Math.min(this.borderRadius, Math.min(f5, f6) * 0.5F);
    paramCanvas.drawRoundRect(new RectF(this.njF + f1, this.njF + f2, f3 - this.njF, f4 - this.njF), f5, f5, this.borderPaint);
    paramCanvas.drawPath(this.njD, this.borderPaint);
    paramCanvas.drawRoundRect(new RectF(f1 + this.njF + this.borderWidth, f2 + this.njF + this.borderWidth, f3 - this.njF - this.borderWidth, f4 - this.njF - this.borderWidth), f5, f5, this.paint);
    paramCanvas.drawPath(this.njC, this.paint);
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
    this.ciQ.set(paramInt1, paramInt2, paramInt3, paramInt4);
    float f = (paramInt1 + paramInt3) / 2.0F;
    this.njD.moveTo(f, paramInt4);
    this.njD.lineTo(f - this.njF, paramInt4 - this.njF);
    this.njD.lineTo(this.njF + f, paramInt4 - this.njF);
    this.njD.close();
    this.njC.moveTo(f, paramInt4 - this.borderWidth);
    this.njC.lineTo(f - this.njF, paramInt4 - this.njF - this.borderWidth);
    this.njC.lineTo(f + this.njF, paramInt4 - this.njF - this.borderWidth);
    this.njC.close();
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
    this.borderWidth = paramInt1;
    this.njF = (paramInt1 / 3 + this.njE);
    this.borderPaint.setColor(paramInt2);
    AppMethodBeat.o(146571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.a
 * JD-Core Version:    0.7.0.1
 */