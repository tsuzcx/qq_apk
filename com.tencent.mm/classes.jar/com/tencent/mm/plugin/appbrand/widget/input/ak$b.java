package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ak$b
  extends Drawable
{
  private Rect joz;
  private final TextPaint mPaint;
  private final int mSize;
  private final String mText;
  
  private ak$b(String paramString, int paramInt)
  {
    AppMethodBeat.i(134289);
    this.mText = paramString;
    this.mSize = paramInt;
    this.mPaint = new TextPaint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setTextAlign(Paint.Align.CENTER);
    this.mPaint.setTextSize(this.mSize);
    this.joz = new Rect();
    this.mPaint.getTextBounds(this.mText, 0, this.mText.length(), this.joz);
    AppMethodBeat.o(134289);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(134292);
    paramCanvas.drawText(this.mText, getBounds().width() / 2, getBounds().height() / 2 - (this.mPaint.descent() + this.mPaint.ascent()) / 2.0F, this.mPaint);
    AppMethodBeat.o(134292);
  }
  
  public final int getIntrinsicHeight()
  {
    AppMethodBeat.i(134291);
    int i = this.joz.height();
    AppMethodBeat.o(134291);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(134290);
    int i = this.joz.width();
    AppMethodBeat.o(134290);
    return i;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(134293);
    this.mPaint.setAlpha(paramInt);
    AppMethodBeat.o(134293);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(134294);
    this.mPaint.setColorFilter(paramColorFilter);
    AppMethodBeat.o(134294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ak.b
 * JD-Core Version:    0.7.0.1
 */