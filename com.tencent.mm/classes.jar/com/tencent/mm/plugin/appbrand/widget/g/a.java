package com.tencent.mm.plugin.appbrand.widget.g;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;

public final class a
  implements LineHeightSpan
{
  private final int gravity;
  public int height;
  
  public a(float paramFloat)
  {
    this.height = Math.round(paramFloat);
    this.gravity = 16;
  }
  
  public final boolean an(float paramFloat)
  {
    return this.height != Math.round(paramFloat);
  }
  
  public final void chooseHeight(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (-paramFontMetricsInt.ascent > this.height)
    {
      paramInt1 = -this.height;
      paramFontMetricsInt.ascent = paramInt1;
      paramFontMetricsInt.top = paramInt1;
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.bottom = 0;
    }
    do
    {
      return;
      if (-paramFontMetricsInt.ascent + paramFontMetricsInt.descent > this.height)
      {
        paramFontMetricsInt.descent = paramFontMetricsInt.bottom;
        paramInt1 = paramFontMetricsInt.descent - this.height;
        paramFontMetricsInt.ascent = paramInt1;
        paramFontMetricsInt.top = paramInt1;
        return;
      }
      if (-paramFontMetricsInt.ascent + paramFontMetricsInt.bottom > this.height)
      {
        paramFontMetricsInt.top = paramFontMetricsInt.ascent;
        paramFontMetricsInt.bottom = (paramFontMetricsInt.ascent + this.height);
        return;
      }
      if (-paramFontMetricsInt.top + paramFontMetricsInt.bottom > this.height)
      {
        paramFontMetricsInt.top = (paramFontMetricsInt.bottom - this.height);
        return;
      }
      paramInt1 = this.height - (-paramFontMetricsInt.ascent + paramFontMetricsInt.descent);
      if (this.gravity == 48)
      {
        paramFontMetricsInt.descent += paramInt1;
        paramFontMetricsInt.bottom = (paramInt1 + paramFontMetricsInt.bottom);
        return;
      }
      if (this.gravity == 80)
      {
        paramFontMetricsInt.top -= paramInt1;
        paramFontMetricsInt.ascent -= paramInt1;
        return;
      }
    } while (this.gravity != 16);
    paramInt1 = Math.round(paramInt1 / 2.0F);
    paramFontMetricsInt.top -= paramInt1;
    paramFontMetricsInt.ascent -= paramInt1;
    paramFontMetricsInt.bottom += paramInt1;
    paramFontMetricsInt.descent = (paramInt1 + paramFontMetricsInt.descent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.g.a
 * JD-Core Version:    0.7.0.1
 */