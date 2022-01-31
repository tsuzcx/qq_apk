package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;

final class aj$b
  extends Drawable
{
  private final String hnV;
  private Rect hwn;
  private final TextPaint mPaint;
  private final int mSize;
  
  private aj$b(String paramString, int paramInt)
  {
    this.hnV = paramString;
    this.mSize = paramInt;
    this.mPaint = new TextPaint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setTextAlign(Paint.Align.CENTER);
    this.mPaint.setTextSize(this.mSize);
    this.hwn = new Rect();
    this.mPaint.getTextBounds(this.hnV, 0, this.hnV.length(), this.hwn);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    paramCanvas.drawText(this.hnV, getBounds().width() / 2, getBounds().height() / 2 - (this.mPaint.descent() + this.mPaint.ascent()) / 2.0F, this.mPaint);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.hwn.height();
  }
  
  public final int getIntrinsicWidth()
  {
    return this.hwn.width();
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.aj.b
 * JD-Core Version:    0.7.0.1
 */