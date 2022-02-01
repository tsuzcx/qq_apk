package com.tencent.mm.aa;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a;

public final class b
  implements Cloneable
{
  private static Paint gyK;
  private float cQd;
  public int mColor;
  private Path xN;
  private float xq;
  
  static
  {
    AppMethodBeat.i(9248);
    Paint localPaint = new Paint();
    gyK = localPaint;
    localPaint.setAntiAlias(true);
    gyK.setStyle(Paint.Style.STROKE);
    gyK.setStrokeCap(Paint.Cap.ROUND);
    AppMethodBeat.o(9248);
  }
  
  public b(Path paramPath, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(9246);
    this.cQd = 1.0F;
    this.xq = a.cd(5.0F);
    this.xN = paramPath;
    this.cQd = paramFloat;
    this.mColor = paramInt;
    AppMethodBeat.o(9246);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9247);
    gyK.setColor(this.mColor);
    gyK.setStrokeWidth(this.xq * this.cQd);
    if (!this.xN.isEmpty()) {
      paramCanvas.drawPath(this.xN, gyK);
    }
    AppMethodBeat.o(9247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aa.b
 * JD-Core Version:    0.7.0.1
 */