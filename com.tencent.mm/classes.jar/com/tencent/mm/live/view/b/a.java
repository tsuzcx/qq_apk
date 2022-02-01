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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/confetti/LiveLikeConfetti;", "Lcom/tencent/mm/particles/confetti/Confetti;", "bitmap", "Landroid/graphics/Bitmap;", "needHalfAlpha", "", "(Landroid/graphics/Bitmap;Z)V", "TAG", "", "getBitmap", "()Landroid/graphics/Bitmap;", "centerX", "", "centerY", "getNeedHalfAlpha", "()Z", "setNeedHalfAlpha", "(Z)V", "scaleMax", "", "slope", "split", "turningY", "drawInternal", "", "canvas", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "x", "y", "rotation", "percentAnimated", "getHeight", "getWidth", "plugin-logic_release"})
public final class a
  extends b
{
  private final String TAG;
  private final Bitmap bitmap;
  private final int centerX;
  private final int centerY;
  private final int hXN;
  private final float hXO;
  private final float hXP;
  private final int hXQ;
  private boolean hXR;
  
  public a(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(208693);
    this.bitmap = paramBitmap;
    this.hXR = paramBoolean;
    this.TAG = "MicroMsg.LiveLikeConfetti";
    this.centerX = (this.bitmap.getWidth() / 2);
    this.centerY = (this.bitmap.getHeight() / 2);
    this.hXN = c.SYP.nextInt(0, 2);
    this.hXO = 0.685F;
    this.hXP = 1.4F;
    this.hXQ = 250;
    AppMethodBeat.o(208693);
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(208692);
    p.h(paramCanvas, "canvas");
    p.h(paramMatrix, "matrix");
    p.h(paramPaint, "paint");
    int i;
    if (paramFloat4 <= this.hXO)
    {
      paramFloat1 = Math.max(paramFloat4 / (this.hXO / this.hXP), 0.5F);
      i = paramPaint.getAlpha();
      if (paramFloat2 <= bkQ() - this.hXQ) {
        break label177;
      }
      paramFloat3 = bkP();
      label80:
      paramMatrix.preTranslate(paramFloat3, paramFloat2);
      paramMatrix.preScale(paramFloat1, paramFloat1, this.centerX, this.centerY);
      if (!this.hXR) {
        break label209;
      }
    }
    label177:
    label209:
    for (paramFloat1 = 0.5F;; paramFloat1 = 1.0F)
    {
      paramPaint.setAlpha((int)(paramFloat1 * 255.0F));
      paramCanvas.drawBitmap(this.bitmap, paramMatrix, paramPaint);
      paramPaint.setAlpha(i);
      AppMethodBeat.o(208692);
      return;
      paramFloat1 = Math.max((1.0F - paramFloat4) / ((1.0F - this.hXO) / this.hXP), 0.5F);
      break;
      paramFloat3 = bkP() - this.hXN * 0.5F * (bkQ() - this.hXQ - paramFloat2);
      break label80;
    }
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(208691);
    int i = this.bitmap.getHeight();
    AppMethodBeat.o(208691);
    return i;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(208690);
    int i = this.bitmap.getWidth();
    AppMethodBeat.o(208690);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.view.b.a
 * JD-Core Version:    0.7.0.1
 */