package com.tencent.mm.plugin.appbrand.widget.h;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements LineHeightSpan
{
  private final int gravity;
  public int height;
  
  public a(float paramFloat)
  {
    AppMethodBeat.i(126818);
    this.gravity = 16;
    setHeight(paramFloat);
    AppMethodBeat.o(126818);
  }
  
  public final boolean aF(float paramFloat)
  {
    AppMethodBeat.i(126817);
    if (this.height != Math.round(paramFloat))
    {
      AppMethodBeat.o(126817);
      return true;
    }
    AppMethodBeat.o(126817);
    return false;
  }
  
  public final void chooseHeight(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(126819);
    if (-paramFontMetricsInt.ascent > this.height)
    {
      paramInt1 = -this.height;
      paramFontMetricsInt.ascent = paramInt1;
      paramFontMetricsInt.top = paramInt1;
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.bottom = 0;
      AppMethodBeat.o(126819);
      return;
    }
    if (-paramFontMetricsInt.ascent + paramFontMetricsInt.descent > this.height)
    {
      paramFontMetricsInt.descent = paramFontMetricsInt.bottom;
      paramInt1 = paramFontMetricsInt.descent - this.height;
      paramFontMetricsInt.ascent = paramInt1;
      paramFontMetricsInt.top = paramInt1;
      AppMethodBeat.o(126819);
      return;
    }
    if (-paramFontMetricsInt.ascent + paramFontMetricsInt.bottom > this.height)
    {
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = (paramFontMetricsInt.ascent + this.height);
      AppMethodBeat.o(126819);
      return;
    }
    if (-paramFontMetricsInt.top + paramFontMetricsInt.bottom > this.height)
    {
      paramFontMetricsInt.top = (paramFontMetricsInt.bottom - this.height);
      AppMethodBeat.o(126819);
      return;
    }
    paramInt1 = this.height - (-paramFontMetricsInt.ascent + paramFontMetricsInt.descent);
    if (this.gravity == 48)
    {
      paramFontMetricsInt.descent += paramInt1;
      paramFontMetricsInt.bottom = (paramInt1 + paramFontMetricsInt.bottom);
      AppMethodBeat.o(126819);
      return;
    }
    if (this.gravity == 80)
    {
      paramFontMetricsInt.top -= paramInt1;
      paramFontMetricsInt.ascent -= paramInt1;
      AppMethodBeat.o(126819);
      return;
    }
    if (this.gravity == 16)
    {
      paramInt1 = Math.round(paramInt1 / 2.0F);
      paramFontMetricsInt.top -= paramInt1;
      paramFontMetricsInt.ascent -= paramInt1;
      paramFontMetricsInt.bottom += paramInt1;
      paramFontMetricsInt.descent = (paramInt1 + paramFontMetricsInt.descent);
    }
    AppMethodBeat.o(126819);
  }
  
  public final void setHeight(float paramFloat)
  {
    AppMethodBeat.i(145978);
    this.height = Math.round(paramFloat);
    AppMethodBeat.o(145978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.h.a
 * JD-Core Version:    0.7.0.1
 */