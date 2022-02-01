package com.tencent.mapsdk.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class po
  extends Drawable
{
  private static final int c = -2829100;
  private static final int d = -10066330;
  private static final int e = 16777215;
  boolean a;
  boolean b;
  private Paint f;
  
  public po()
  {
    AppMethodBeat.i(225805);
    this.a = false;
    this.f = new Paint();
    this.f.setAntiAlias(true);
    this.f.setStrokeJoin(Paint.Join.BEVEL);
    AppMethodBeat.o(225805);
  }
  
  private void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  private void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final void a(float paramFloat)
  {
    AppMethodBeat.i(225828);
    this.f.setStrokeWidth(paramFloat);
    AppMethodBeat.o(225828);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(225837);
    Paint localPaint;
    int i;
    if (this.a)
    {
      localPaint = this.f;
      if (this.b)
      {
        i = -10066330;
        localPaint.setColor(i);
      }
    }
    for (;;)
    {
      float f1 = getBounds().height();
      float f2 = getBounds().width() / 2.0F;
      float f3 = getBounds().width() / 2.0F;
      float f4 = getBounds().width();
      float f5 = getBounds().height();
      localPaint = this.f;
      paramCanvas.drawLines(new float[] { 0.0F, f1, f2, 0.0F, f3, 0.0F, f4, f5 }, localPaint);
      AppMethodBeat.o(225837);
      return;
      i = -2829100;
      break;
      this.f.setColor(16777215);
    }
  }
  
  public final int getIntrinsicHeight()
  {
    AppMethodBeat.i(225868);
    int i = getBounds().height();
    AppMethodBeat.o(225868);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(225863);
    int i = getBounds().width();
    AppMethodBeat.o(225863);
    return i;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(225845);
    this.f.setAlpha(paramInt);
    AppMethodBeat.o(225845);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(225852);
    this.f.setColorFilter(paramColorFilter);
    AppMethodBeat.o(225852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.internal.po
 * JD-Core Version:    0.7.0.1
 */