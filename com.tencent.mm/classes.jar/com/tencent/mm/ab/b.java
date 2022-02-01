package com.tencent.mm.ab;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.a;

public final class b
  implements Cloneable
{
  private static Paint mAa;
  private Path cja;
  private float hco;
  public int mColor;
  private float mStrokeWidth;
  
  static
  {
    AppMethodBeat.i(9248);
    Paint localPaint = new Paint();
    mAa = localPaint;
    localPaint.setAntiAlias(true);
    mAa.setStyle(Paint.Style.STROKE);
    mAa.setStrokeCap(Paint.Cap.ROUND);
    AppMethodBeat.o(9248);
  }
  
  public b(Path paramPath, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(9246);
    this.hco = 1.0F;
    this.mStrokeWidth = a.eo(5.0F);
    this.cja = paramPath;
    this.hco = paramFloat;
    this.mColor = paramInt;
    AppMethodBeat.o(9246);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9247);
    mAa.setColor(this.mColor);
    mAa.setStrokeWidth(this.mStrokeWidth * this.hco);
    if (!this.cja.isEmpty()) {
      paramCanvas.drawPath(this.cja, mAa);
    }
    AppMethodBeat.o(9247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ab.b
 * JD-Core Version:    0.7.0.1
 */