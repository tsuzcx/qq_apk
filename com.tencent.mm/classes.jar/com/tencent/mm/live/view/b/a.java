package com.tencent.mm.live.view.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.particles.a.b;
import kotlin.g.b.p;
import kotlin.j.c;
import kotlin.j.c.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/confetti/LiveLikeConfetti;", "Lcom/tencent/mm/particles/confetti/Confetti;", "bitmap", "Landroid/graphics/Bitmap;", "alpha", "", "(Landroid/graphics/Bitmap;F)V", "TAG", "", "getAlpha", "()F", "setAlpha", "(F)V", "getBitmap", "()Landroid/graphics/Bitmap;", "centerX", "", "centerY", "scaleMax", "slope", "split", "turningY", "drawInternal", "", "canvas", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "x", "y", "rotation", "percentAnimated", "getHeight", "getWidth", "plugin-logic_release"})
public final class a
  extends b
{
  private final String TAG;
  private float alpha;
  private final Bitmap bitmap;
  private final int centerX;
  private final int centerY;
  private final int kMs;
  private final float kMt;
  private final float kMu;
  private final int kMv;
  
  public a(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(188278);
    this.bitmap = paramBitmap;
    this.alpha = paramFloat;
    this.TAG = "MicroMsg.LiveLikeConfetti";
    this.centerX = (this.bitmap.getWidth() / 2);
    this.centerY = (this.bitmap.getHeight() / 2);
    this.kMs = c.aaBL.os(0, 2);
    this.kMt = 0.685F;
    this.kMu = 1.4F;
    this.kMv = 250;
    AppMethodBeat.o(188278);
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(188273);
    p.k(paramCanvas, "canvas");
    p.k(paramMatrix, "matrix");
    p.k(paramPaint, "paint");
    int i;
    if (paramFloat4 <= this.kMt)
    {
      paramFloat1 = Math.max(paramFloat4 / (this.kMt / this.kMu), 0.5F);
      i = paramPaint.getAlpha();
      if (paramFloat2 <= buE() - this.kMv) {
        break label168;
      }
    }
    label168:
    for (paramFloat3 = buD();; paramFloat3 = buD() - this.kMs * 0.5F * (buE() - this.kMv - paramFloat2))
    {
      paramMatrix.preTranslate(paramFloat3, paramFloat2);
      paramMatrix.preScale(paramFloat1, paramFloat1, this.centerX, this.centerY);
      paramPaint.setAlpha((int)(255.0F * this.alpha));
      paramCanvas.drawBitmap(this.bitmap, paramMatrix, paramPaint);
      paramPaint.setAlpha(i);
      AppMethodBeat.o(188273);
      return;
      paramFloat1 = Math.max((1.0F - paramFloat4) / ((1.0F - this.kMt) / this.kMu), 0.5F);
      break;
    }
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(188266);
    int i = this.bitmap.getHeight();
    AppMethodBeat.o(188266);
    return i;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(188263);
    int i = this.bitmap.getWidth();
    AppMethodBeat.o(188263);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.b.a
 * JD-Core Version:    0.7.0.1
 */