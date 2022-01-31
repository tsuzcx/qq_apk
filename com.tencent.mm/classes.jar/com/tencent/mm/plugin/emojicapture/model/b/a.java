package com.tencent.mm.plugin.emojicapture.model.b;

import a.d.b.g;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements c
{
  private final Paint gaZ = new Paint();
  private int height = 640;
  public List<com.tencent.mm.plugin.emojicapture.model.a.a> jkF = (List)new ArrayList();
  private final Path jkG = new Path();
  private final Matrix jkH = new Matrix();
  private long jku;
  private int width = 640;
  
  public a(RectF paramRectF)
  {
    Object localObject = com.tencent.mm.plugin.emojicapture.model.c.jko;
    float f1 = this.width * 0.0666667F;
    this.jkG.addRoundRect(new RectF(0.0F, 0.0F, this.width, this.height), f1, f1, Path.Direction.CW);
    localObject = this.jkH;
    f1 = paramRectF.left;
    float f2 = paramRectF.top;
    float f3 = paramRectF.right;
    float f4 = paramRectF.bottom;
    float f5 = this.width;
    float f6 = this.height;
    ((Matrix)localObject).setPolyToPoly(new float[] { f1, f2, f3, f4 }, 0, new float[] { 0.0F, 0.0F, f5, f6 }, 0, 2);
    this.gaZ.setAntiAlias(true);
  }
  
  public final b aKj()
  {
    if (this.jkF.size() <= 0) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.clipPath(this.jkG);
    localCanvas.concat(this.jkH);
    Iterator localIterator = this.jkF.iterator();
    long l1 = 9223372036854775807L;
    if (localIterator.hasNext())
    {
      com.tencent.mm.plugin.emojicapture.model.a.a locala = (com.tencent.mm.plugin.emojicapture.model.a.a)localIterator.next();
      long l2 = locala.du(this.jku);
      locala.draw(localCanvas, this.gaZ);
      if (l2 >= l1) {
        break label155;
      }
      l1 = l2;
    }
    label155:
    for (;;)
    {
      break;
      this.jku = l1;
      g.j(localBitmap, "bitmap");
      return new b(localBitmap, this.jku);
    }
  }
  
  public final void start()
  {
    Iterator localIterator = this.jkF.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.emojicapture.model.a.a)localIterator.next()).init();
    }
  }
  
  public final void stop()
  {
    Iterator localIterator = this.jkF.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.emojicapture.model.a.a)localIterator.next()).destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.a
 * JD-Core Version:    0.7.0.1
 */