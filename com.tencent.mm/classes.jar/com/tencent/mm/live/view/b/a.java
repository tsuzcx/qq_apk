package com.tencent.mm.live.view.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.particles.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/confetti/LiveLikeConfetti;", "Lcom/tencent/mm/particles/confetti/Confetti;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "TAG", "", "getBitmap", "()Landroid/graphics/Bitmap;", "centerX", "", "centerY", "drawInternal", "", "canvas", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "x", "", "y", "rotation", "percentAnimated", "getHeight", "getWidth", "plugin-logic_release"})
public final class a
  extends b
{
  private final String TAG;
  private final Bitmap bitmap;
  private final int centerX;
  private final int centerY;
  
  public a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(216719);
    this.bitmap = paramBitmap;
    this.TAG = "MicroMsg.LiveLikeConfetti";
    this.centerX = (this.bitmap.getWidth() / 2);
    this.centerY = (this.bitmap.getHeight() / 2);
    AppMethodBeat.o(216719);
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(216718);
    p.h(paramCanvas, "canvas");
    p.h(paramMatrix, "matrix");
    p.h(paramPaint, "paint");
    float f;
    if (paramFloat4 <= 0.2D)
    {
      f = Math.max(paramFloat4 / 0.2F, 0.5F);
      if (paramFloat4 > 0.2D) {
        break label179;
      }
      paramFloat3 = paramFloat4 / 0.2F;
    }
    for (;;)
    {
      int i = paramPaint.getAlpha();
      paramMatrix.preTranslate(paramFloat1, paramFloat2);
      paramMatrix.preScale(f, f, this.centerX, this.centerY);
      paramPaint.setAlpha((int)(255.0F * paramFloat3));
      ae.i(this.TAG, "alpha:" + paramFloat3 + " scale:" + f);
      paramCanvas.drawBitmap(this.bitmap, paramMatrix, paramPaint);
      paramPaint.setAlpha(i);
      AppMethodBeat.o(216718);
      return;
      f = Math.max((1.0F - paramFloat4) / 0.8F, 0.5F);
      break;
      label179:
      if (paramFloat4 > 0.5D) {
        paramFloat3 = (1.0F - paramFloat4) / 0.5F;
      } else {
        paramFloat3 = 1.0F;
      }
    }
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(216717);
    int i = this.bitmap.getHeight();
    AppMethodBeat.o(216717);
    return i;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(216716);
    int i = this.bitmap.getWidth();
    AppMethodBeat.o(216716);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.view.b.a
 * JD-Core Version:    0.7.0.1
 */