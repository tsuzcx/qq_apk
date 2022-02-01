package com.tencent.mm.ab;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cs.a;

public final class b
  implements Cloneable
{
  private static Paint jZX;
  private Path auD;
  private float eYO;
  public int mColor;
  private float mStrokeWidth;
  
  static
  {
    AppMethodBeat.i(9248);
    Paint localPaint = new Paint();
    jZX = localPaint;
    localPaint.setAntiAlias(true);
    jZX.setStyle(Paint.Style.STROKE);
    jZX.setStrokeCap(Paint.Cap.ROUND);
    AppMethodBeat.o(9248);
  }
  
  public b(Path paramPath, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(9246);
    this.eYO = 1.0F;
    this.mStrokeWidth = a.an(5.0F);
    this.auD = paramPath;
    this.eYO = paramFloat;
    this.mColor = paramInt;
    AppMethodBeat.o(9246);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9247);
    jZX.setColor(this.mColor);
    jZX.setStrokeWidth(this.mStrokeWidth * this.eYO);
    if (!this.auD.isEmpty()) {
      paramCanvas.drawPath(this.auD, jZX);
    }
    AppMethodBeat.o(9247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ab.b
 * JD-Core Version:    0.7.0.1
 */