package com.tencent.mm.plugin.emojicapture.model.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public abstract class a
{
  private final Matrix aqv;
  long jku;
  
  public a(Matrix paramMatrix)
  {
    this.aqv = paramMatrix;
  }
  
  public abstract long aKf();
  
  public abstract void destroy();
  
  public abstract void draw(Canvas paramCanvas, Paint paramPaint);
  
  public long du(long paramLong)
  {
    if (this.jku <= paramLong) {}
    for (this.jku = (this.jku + aKf() - paramLong);; this.jku -= paramLong) {
      return this.jku;
    }
  }
  
  public abstract void init();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.a
 * JD-Core Version:    0.7.0.1
 */