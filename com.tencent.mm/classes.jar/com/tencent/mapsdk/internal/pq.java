package com.tencent.mapsdk.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pq
  extends Drawable
{
  private static final int a = -12028419;
  private Paint b;
  
  public pq()
  {
    AppMethodBeat.i(225770);
    this.b = new Paint();
    this.b.setAntiAlias(true);
    if (ry.c.equals("wechat"))
    {
      this.b.setColor(-16531104);
      AppMethodBeat.o(225770);
      return;
    }
    this.b.setColor(-12028419);
    AppMethodBeat.o(225770);
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(225780);
    this.b.setColor(paramInt);
    invalidateSelf();
    AppMethodBeat.o(225780);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(225789);
    paramCanvas.drawCircle(getBounds().width() / 2.0F, getBounds().height() / 2.0F, getBounds().width() / 2.0F, this.b);
    AppMethodBeat.o(225789);
  }
  
  public final int getIntrinsicHeight()
  {
    AppMethodBeat.i(225830);
    int i = getBounds().height();
    AppMethodBeat.o(225830);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(225823);
    int i = getBounds().width();
    AppMethodBeat.o(225823);
    return i;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(225798);
    this.b.setAlpha(paramInt);
    AppMethodBeat.o(225798);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(225807);
    this.b.setColorFilter(paramColorFilter);
    AppMethodBeat.o(225807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pq
 * JD-Core Version:    0.7.0.1
 */