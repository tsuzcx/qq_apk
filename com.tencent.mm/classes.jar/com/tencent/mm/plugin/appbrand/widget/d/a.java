package com.tencent.mm.plugin.appbrand.widget.d;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
  extends Drawable
{
  private Paint borderPaint;
  float borderRadius;
  private int borderWidth;
  private final RectF ciS;
  private Path noK;
  private Path noL;
  private int noM;
  private int noN;
  private Paint paint;
  
  public a()
  {
    AppMethodBeat.i(146565);
    this.ciS = new RectF();
    this.borderRadius = 0.0F;
    this.borderWidth = 0;
    this.noM = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 3);
    this.noN = this.noM;
    this.paint = new Paint(1);
    this.paint.setStyle(Paint.Style.FILL);
    this.borderPaint = new Paint(1);
    this.borderPaint.setStyle(Paint.Style.FILL);
    this.noK = new Path();
    this.noL = new Path();
    AppMethodBeat.o(146565);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(146566);
    float f5 = this.ciS.width();
    float f6 = this.ciS.height();
    float f1 = this.ciS.left;
    float f2 = this.ciS.top;
    float f3 = this.ciS.right;
    float f4 = this.ciS.bottom;
    f5 = Math.min(this.borderRadius, Math.min(f5, f6) * 0.5F);
    paramCanvas.drawRoundRect(new RectF(this.noN + f1, this.noN + f2, f3 - this.noN, f4 - this.noN), f5, f5, this.borderPaint);
    paramCanvas.drawPath(this.noL, this.borderPaint);
    paramCanvas.drawRoundRect(new RectF(f1 + this.noN + this.borderWidth, f2 + this.noN + this.borderWidth, f3 - this.noN - this.borderWidth, f4 - this.noN - this.borderWidth), f5, f5, this.paint);
    paramCanvas.drawPath(this.noK, this.paint);
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
    this.ciS.set(paramInt1, paramInt2, paramInt3, paramInt4);
    float f = (paramInt1 + paramInt3) / 2.0F;
    this.noL.moveTo(f, paramInt4);
    this.noL.lineTo(f - this.noN, paramInt4 - this.noN);
    this.noL.lineTo(this.noN + f, paramInt4 - this.noN);
    this.noL.close();
    this.noK.moveTo(f, paramInt4 - this.borderWidth);
    this.noK.lineTo(f - this.noN, paramInt4 - this.noN - this.borderWidth);
    this.noK.lineTo(f + this.noN, paramInt4 - this.noN - this.borderWidth);
    this.noK.close();
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
    this.noN = (paramInt1 / 3 + this.noM);
    this.borderPaint.setColor(paramInt2);
    AppMethodBeat.o(146571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.a
 * JD-Core Version:    0.7.0.1
 */