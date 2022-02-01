package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class rd$e
  extends View
{
  private static final int b = -16777216;
  private static final int c = -7368817;
  private static final int d = 35;
  private Paint e;
  private Paint f;
  private int g;
  
  public rd$e(rd paramrd, Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(225595);
    this.g = -16777216;
    this.e = new Paint();
    this.e.setAntiAlias(true);
    this.e.setStrokeWidth(1.0F * rd.f(paramrd));
    this.e.setStyle(Paint.Style.STROKE);
    this.f = new Paint(65);
    this.f.setStyle(Paint.Style.FILL);
    this.f.setColor(0);
    AppMethodBeat.o(225595);
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    AppMethodBeat.i(225598);
    int i = (int)(6.0F * rd.f(this.a));
    paramInt /= 2;
    paramCanvas.drawPaint(this.f);
    paramCanvas.drawLine(i, paramInt, rd.g(this.a) + i, paramInt, this.e);
    paramCanvas.drawLine(i, paramInt - rd.f(this.a) * 3.0F, i, paramInt + 1, this.e);
    paramCanvas.drawLine(rd.g(this.a) + i, paramInt - rd.f(this.a) * 3.0F, rd.g(this.a) + i, paramInt + 1, this.e);
    AppMethodBeat.o(225598);
  }
  
  private void a(boolean paramBoolean)
  {
    AppMethodBeat.i(225606);
    if (paramBoolean) {}
    for (int i = -7368817;; i = -16777216)
    {
      if (i != this.g)
      {
        this.g = i;
        if (rd.e(this.a) != null) {
          rd.e(this.a).setTextColor(i);
        }
      }
      AppMethodBeat.o(225606);
      return;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(225620);
    super.draw(paramCanvas);
    this.e.setColor(this.g);
    int j = getHeight();
    int i = (int)(6.0F * rd.f(this.a));
    j /= 2;
    paramCanvas.drawPaint(this.f);
    paramCanvas.drawLine(i, j, rd.g(this.a) + i, j, this.e);
    paramCanvas.drawLine(i, j - rd.f(this.a) * 3.0F, i, j + 1, this.e);
    paramCanvas.drawLine(rd.g(this.a) + i, j - rd.f(this.a) * 3.0F, rd.g(this.a) + i, j + 1, this.e);
    AppMethodBeat.o(225620);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225627);
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(Math.min(Math.round(rd.g(this.a) + 12.0F * rd.f(this.a)), rd.h(this.a) / 2), Math.round(rd.i(this.a) * rd.f(this.a)));
    AppMethodBeat.o(225627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rd.e
 * JD-Core Version:    0.7.0.1
 */