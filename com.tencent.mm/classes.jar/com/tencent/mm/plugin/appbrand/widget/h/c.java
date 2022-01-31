package com.tencent.mm.plugin.appbrand.widget.h;

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
  private final int paddingLeft;
  private final int paddingRight;
  private final int radius;
  private final String text;
  private final int textColor;
  private final float textSize;
  
  public c(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(77509);
    this.textSize = paramInt3;
    this.text = paramString;
    this.textColor = -1;
    this.backgroundColor = paramInt4;
    this.radius = paramInt5;
    this.paddingLeft = paramInt1;
    this.paddingRight = paramInt2;
    AppMethodBeat.o(77509);
  }
  
  public final int b(Paint paramPaint)
  {
    AppMethodBeat.i(77510);
    Paint localPaint = paramPaint;
    if (paramPaint == null) {
      localPaint = new Paint();
    }
    localPaint.setTextSize(this.textSize);
    int i = (int)localPaint.measureText(this.text);
    int j = this.paddingLeft;
    int k = this.paddingRight;
    int m = this.radius;
    AppMethodBeat.o(77510);
    return i + j + k + m * 2;
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(77512);
    paramPaint.setTextSize(this.textSize);
    paramPaint.setAntiAlias(true);
    paramCharSequence = new RectF();
    paramCharSequence.left = ((int)paramFloat + this.paddingLeft);
    Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
    paramInt1 = Math.max(0, (paramInt5 - paramInt3 - localFontMetricsInt.descent + localFontMetricsInt.top) / 2 - this.radius);
    paramCharSequence.top = (paramInt3 + paramInt1);
    paramCharSequence.bottom = (paramInt5 - paramInt1);
    paramCharSequence.right = (paramCharSequence.left + (int)paramPaint.measureText(this.text) + this.radius * 2);
    paramPaint.setColor(this.backgroundColor);
    paramCanvas.drawRoundRect(paramCharSequence, this.radius, this.radius, paramPaint);
    paramPaint.setColor(this.textColor);
    paramCanvas.drawText(this.text, paramCharSequence.left + this.radius, paramCharSequence.top + this.radius - localFontMetricsInt.top, paramPaint);
    AppMethodBeat.o(77512);
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(77511);
    paramInt1 = b(paramPaint);
    AppMethodBeat.o(77511);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.h.c
 * JD-Core Version:    0.7.0.1
 */