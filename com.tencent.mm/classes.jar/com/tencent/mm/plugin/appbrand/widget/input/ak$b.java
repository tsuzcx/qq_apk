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
  private final TextPaint NZ;
  private final int mSize;
  private final String mText;
  private Rect nlT;
  
  private ak$b(String paramString, int paramInt)
  {
    AppMethodBeat.i(49911);
    this.mText = paramString;
    this.mSize = paramInt;
    this.NZ = new TextPaint();
    this.NZ.setAntiAlias(true);
    this.NZ.setTextAlign(Paint.Align.CENTER);
    this.NZ.setTextSize(this.mSize);
    this.nlT = new Rect();
    this.NZ.getTextBounds(this.mText, 0, this.mText.length(), this.nlT);
    AppMethodBeat.o(49911);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(49914);
    paramCanvas.drawText(this.mText, getBounds().width() / 2, getBounds().height() / 2 - (this.NZ.descent() + this.NZ.ascent()) / 2.0F, this.NZ);
    AppMethodBeat.o(49914);
  }
  
  public final int getIntrinsicHeight()
  {
    AppMethodBeat.i(49913);
    int i = this.nlT.height();
    AppMethodBeat.o(49913);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(49912);
    int i = this.nlT.width();
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
    this.NZ.setAlpha(paramInt);
    AppMethodBeat.o(49915);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(49916);
    this.NZ.setColorFilter(paramColorFilter);
    AppMethodBeat.o(49916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ak.b
 * JD-Core Version:    0.7.0.1
 */