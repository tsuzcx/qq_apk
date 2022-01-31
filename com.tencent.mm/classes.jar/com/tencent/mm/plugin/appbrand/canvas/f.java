package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region.Op;

public final class f
  extends Canvas
{
  public Bitmap mBitmap;
  
  public f() {}
  
  public f(Bitmap paramBitmap)
  {
    super(paramBitmap);
    this.mBitmap = paramBitmap;
  }
  
  public final void e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Bitmap localBitmap1 = this.mBitmap;
    RectF localRectF1 = new RectF(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    RectF localRectF2 = new RectF(0.0F, 0.0F, this.mBitmap.getWidth(), this.mBitmap.getHeight());
    Region.Op localOp = Region.Op.XOR;
    Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth(), localBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap2);
    localCanvas.clipRect(localRectF1);
    localCanvas.clipRect(localRectF2, localOp);
    localCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, null);
    if ((localBitmap2 != null) && (!localBitmap2.isRecycled()))
    {
      this.mBitmap.eraseColor(0);
      drawBitmap(localBitmap2, 0.0F, 0.0F, null);
      localBitmap2.recycle();
    }
  }
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    super.setBitmap(paramBitmap);
    this.mBitmap = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.f
 * JD-Core Version:    0.7.0.1
 */