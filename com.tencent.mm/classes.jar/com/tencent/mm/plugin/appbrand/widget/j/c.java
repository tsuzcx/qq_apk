package com.tencent.mm.plugin.appbrand.widget.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends ReplacementSpan
{
  private final int backgroundColor;
  private final int pmp;
  private final int radius;
  private final String text;
  private final int textColor;
  private final float textSize;
  private final int uRw;
  
  public c(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(323958);
    this.textSize = paramInt3;
    this.text = paramString;
    this.textColor = paramInt4;
    this.backgroundColor = paramInt5;
    this.radius = paramInt6;
    this.pmp = paramInt1;
    this.uRw = paramInt2;
    AppMethodBeat.o(323958);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(323966);
    paramPaint.setTextSize(this.textSize);
    paramPaint.setAntiAlias(true);
    paramCharSequence = new RectF();
    paramCharSequence.left = ((int)paramFloat + this.pmp);
    Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
    paramInt1 = Math.max(0, (paramInt5 - paramInt3 - localFontMetricsInt.descent + localFontMetricsInt.top) / 2 - this.radius);
    paramCharSequence.top = (paramInt3 + paramInt1);
    paramCharSequence.bottom = (paramInt5 - paramInt1);
    paramCharSequence.right = (paramCharSequence.left + (int)paramPaint.measureText(this.text) + this.radius * 2);
    paramPaint.setColor(this.backgroundColor);
    paramCanvas.drawRoundRect(paramCharSequence, this.radius, this.radius, paramPaint);
    paramPaint.setColor(this.textColor);
    paramCanvas.drawText(this.text, paramCharSequence.left + this.radius, paramCharSequence.top + this.radius - localFontMetricsInt.top, paramPaint);
    AppMethodBeat.o(323966);
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(323962);
    paramCharSequence = paramPaint;
    if (paramPaint == null) {
      paramCharSequence = new Paint();
    }
    paramCharSequence.setTextSize(this.textSize);
    paramInt1 = (int)paramCharSequence.measureText(this.text);
    paramInt2 = this.pmp;
    int i = this.uRw;
    int j = this.radius;
    AppMethodBeat.o(323962);
    return paramInt1 + paramInt2 + i + j * 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.j.c
 * JD-Core Version:    0.7.0.1
 */