package com.tencent.mm.live.view.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.particles.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/confetti/LiveLikeConfetti;", "Lcom/tencent/mm/particles/confetti/Confetti;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "TAG", "", "getBitmap", "()Landroid/graphics/Bitmap;", "centerX", "", "centerY", "drawInternal", "", "canvas", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "x", "", "y", "rotation", "percentAnimated", "getHeight", "getWidth", "plugin-logic_release"})
public final class a
  extends b
{
  private final String TAG;
  private final Bitmap bitmap;
  private final int centerX;
  private final int centerY;
  
  public a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(203560);
    this.bitmap = paramBitmap;
    this.TAG = "MicroMsg.LiveLikeConfetti";
    this.centerX = (this.bitmap.getWidth() / 2);
    this.centerY = (this.bitmap.getHeight() / 2);
    AppMethodBeat.o(203560);
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat3 = 1.0F;
    AppMethodBeat.i(203559);
    k.h(paramCanvas, "canvas");
    k.h(paramMatrix, "matrix");
    k.h(paramPaint, "paint");
    float f = Math.max(1.0F - paramFloat4, 0.5F);
    if (paramFloat4 > 0.5D) {
      paramFloat3 = (1.0F - paramFloat4) / 0.5F;
    }
    int i = paramPaint.getAlpha();
    paramMatrix.preTranslate(paramFloat1, paramFloat2);
    paramMatrix.preScale(f, f, this.centerX, this.centerY);
    paramPaint.setAlpha((int)(255.0F * paramFloat3));
    ad.i(this.TAG, "alpha:" + paramFloat3 + " scale:" + f);
    paramCanvas.drawBitmap(this.bitmap, paramMatrix, paramPaint);
    paramPaint.setAlpha(i);
    AppMethodBeat.o(203559);
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(203558);
    int i = this.bitmap.getHeight();
    AppMethodBeat.o(203558);
    return i;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(203557);
    int i = this.bitmap.getWidth();
    AppMethodBeat.o(203557);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.view.b.a
 * JD-Core Version:    0.7.0.1
 */