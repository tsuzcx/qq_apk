package com.tencent.mm.plugin.appbrand.widget.g;

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
  float borderRadius;
  private int borderWidth;
  private final RectF ekW;
  private Paint paint;
  private Paint uMn;
  private Path uMo;
  private Path uMp;
  private int uMq;
  private int uMr;
  
  public a()
  {
    AppMethodBeat.i(146565);
    this.ekW = new RectF();
    this.borderRadius = 0.0F;
    this.borderWidth = 0;
    this.uMq = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 3);
    this.uMr = this.uMq;
    this.paint = new Paint(1);
    this.paint.setStyle(Paint.Style.FILL);
    this.uMn = new Paint(1);
    this.uMn.setStyle(Paint.Style.FILL);
    this.uMo = new Path();
    this.uMp = new Path();
    AppMethodBeat.o(146565);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(146566);
    float f5 = this.ekW.width();
    float f6 = this.ekW.height();
    float f1 = this.ekW.left;
    float f2 = this.ekW.top;
    float f3 = this.ekW.right;
    float f4 = this.ekW.bottom;
    f5 = Math.min(this.borderRadius, Math.min(f5, f6) * 0.5F);
    paramCanvas.drawRoundRect(new RectF(this.uMr + f1, this.uMr + f2, f3 - this.uMr, f4 - this.uMr), f5, f5, this.uMn);
    paramCanvas.drawPath(this.uMp, this.uMn);
    paramCanvas.drawRoundRect(new RectF(f1 + this.uMr + this.borderWidth, f2 + this.uMr + this.borderWidth, f3 - this.uMr - this.borderWidth, f4 - this.uMr - this.borderWidth), f5, f5, this.paint);
    paramCanvas.drawPath(this.uMo, this.paint);
    AppMethodBeat.o(146566);
  }
  
  public final void ge(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146571);
    this.borderWidth = paramInt1;
    this.uMr = (paramInt1 / 3 + this.uMq);
    this.uMn.setColor(paramInt2);
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
    this.uMn.setAlpha(paramInt);
    AppMethodBeat.o(146568);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(146567);
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.ekW.set(paramInt1, paramInt2, paramInt3, paramInt4);
    float f = (paramInt1 + paramInt3) / 2.0F;
    this.uMp.moveTo(f, paramInt4);
    this.uMp.lineTo(f - this.uMr, paramInt4 - this.uMr);
    this.uMp.lineTo(this.uMr + f, paramInt4 - this.uMr);
    this.uMp.close();
    this.uMo.moveTo(f, paramInt4 - this.borderWidth);
    this.uMo.lineTo(f - this.uMr, paramInt4 - this.uMr - this.borderWidth);
    this.uMo.lineTo(f + this.uMr, paramInt4 - this.uMr - this.borderWidth);
    this.uMo.close();
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
    this.uMn.setColorFilter(paramColorFilter);
    AppMethodBeat.o(146569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.g.a
 * JD-Core Version:    0.7.0.1
 */