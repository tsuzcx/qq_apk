package com.tencent.mm.plugin.emojicapture.model.a;

import a.d.b.g;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class d
  extends a
{
  private final Matrix aqv;
  private int jkx;
  private final List<Bitmap> jky;
  private final long jkz = 100L;
  
  public d(Bitmap[] paramArrayOfBitmap, Matrix paramMatrix)
  {
    super(paramMatrix);
    this.aqv = paramMatrix;
    this.jky = ((List)new ArrayList());
    if (paramArrayOfBitmap != null)
    {
      int j = paramArrayOfBitmap.length;
      int i = 0;
      while (i < j)
      {
        paramMatrix = paramArrayOfBitmap[i];
        if (paramMatrix != null) {
          this.jky.add(paramMatrix);
        }
        i += 1;
      }
    }
  }
  
  public final long aKf()
  {
    if (this.jky.isEmpty()) {
      return 9223372036854775807L;
    }
    this.jkx += 1;
    this.jkx %= ((Collection)this.jky).size();
    return this.jkz;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    g.k(paramCanvas, "canvas");
    g.k(paramPaint, "paint");
    if (this.jky.isEmpty()) {
      return;
    }
    Bitmap localBitmap = (Bitmap)this.jky.get(this.jkx);
    paramCanvas.save();
    paramCanvas.concat(this.aqv);
    paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
    paramCanvas.restore();
  }
  
  public final void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.d
 * JD-Core Version:    0.7.0.1
 */