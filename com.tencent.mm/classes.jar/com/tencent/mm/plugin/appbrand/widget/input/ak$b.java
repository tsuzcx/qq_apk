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
  private final TextPaint Mh;
  private Rect mGn;
  private final int mSize;
  private final String mText;
  
  private ak$b(String paramString, int paramInt)
  {
    AppMethodBeat.i(49911);
    this.mText = paramString;
    this.mSize = paramInt;
    this.Mh = new TextPaint();
    this.Mh.setAntiAlias(true);
    this.Mh.setTextAlign(Paint.Align.CENTER);
    this.Mh.setTextSize(this.mSize);
    this.mGn = new Rect();
    this.Mh.getTextBounds(this.mText, 0, this.mText.length(), this.mGn);
    AppMethodBeat.o(49911);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(49914);
    paramCanvas.drawText(this.mText, getBounds().width() / 2, getBounds().height() / 2 - (this.Mh.descent() + this.Mh.ascent()) / 2.0F, this.Mh);
    AppMethodBeat.o(49914);
  }
  
  public final int getIntrinsicHeight()
  {
    AppMethodBeat.i(49913);
    int i = this.mGn.height();
    AppMethodBeat.o(49913);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(49912);
    int i = this.mGn.width();
    AppMethodBeat.o(49912);
    return i;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(49915);
    this.Mh.setAlpha(paramInt);
    AppMethodBeat.o(49915);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(49916);
    this.Mh.setColorFilter(paramColorFilter);
    AppMethodBeat.o(49916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ak.b
 * JD-Core Version:    0.7.0.1
 */