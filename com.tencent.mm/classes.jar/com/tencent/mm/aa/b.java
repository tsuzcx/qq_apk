package com.tencent.mm.aa;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.a;

public final class b
  implements Cloneable
{
  private static Paint gau;
  private float cHQ;
  public int mColor;
  private Path uW;
  private float uz;
  
  static
  {
    AppMethodBeat.i(9248);
    Paint localPaint = new Paint();
    gau = localPaint;
    localPaint.setAntiAlias(true);
    gau.setStyle(Paint.Style.STROKE);
    gau.setStrokeCap(Paint.Cap.ROUND);
    AppMethodBeat.o(9248);
  }
  
  public b(Path paramPath, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(9246);
    this.cHQ = 1.0F;
    this.uz = a.bP(5.0F);
    this.uW = paramPath;
    this.cHQ = paramFloat;
    this.mColor = paramInt;
    AppMethodBeat.o(9246);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9247);
    gau.setColor(this.mColor);
    gau.setStrokeWidth(this.uz * this.cHQ);
    if (!this.uW.isEmpty()) {
      paramCanvas.drawPath(this.uW, gau);
    }
    AppMethodBeat.o(9247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aa.b
 * JD-Core Version:    0.7.0.1
 */