package com.tencent.mm.cg;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends ReplacementSpan
{
  private int acAp;
  
  public a(int paramInt)
  {
    this.acAp = paramInt;
  }
  
  private TextPaint b(Paint paramPaint)
  {
    AppMethodBeat.i(152792);
    paramPaint = new TextPaint(paramPaint);
    paramPaint.setTextSize(this.acAp);
    AppMethodBeat.o(152792);
    return paramPaint;
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(152791);
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
    paramPaint = b(paramPaint);
    Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
    paramCharSequence = paramCharSequence.toString();
    paramInt1 = localFontMetricsInt.descent;
    paramCanvas.drawText(paramCharSequence, paramFloat, paramInt4 - ((localFontMetricsInt.ascent + (paramInt1 + paramInt4 + paramInt4)) / 2 - (paramInt5 + paramInt3) / 2), paramPaint);
    AppMethodBeat.o(152791);
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(152790);
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
    paramInt1 = (int)b(paramPaint).measureText(paramCharSequence.toString());
    AppMethodBeat.o(152790);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cg.a
 * JD-Core Version:    0.7.0.1
 */