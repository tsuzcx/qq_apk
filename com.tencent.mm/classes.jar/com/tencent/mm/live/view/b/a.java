package com.tencent.mm.live.view.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.particles.a.b;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j.c;
import kotlin.j.c.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/confetti/LiveLikeConfetti;", "Lcom/tencent/mm/particles/confetti/Confetti;", "bitmap", "Landroid/graphics/Bitmap;", "alpha", "", "(Landroid/graphics/Bitmap;F)V", "TAG", "", "getAlpha", "()F", "setAlpha", "(F)V", "getBitmap", "()Landroid/graphics/Bitmap;", "centerX", "", "centerY", "scaleMax", "slope", "split", "turningY", "drawInternal", "", "canvas", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "x", "y", "rotation", "percentAnimated", "getHeight", "getWidth", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  private final String TAG;
  private float alpha;
  private final Bitmap bitmap;
  private final int centerX;
  private final int centerY;
  private final int noj;
  private final float nok;
  private final float nol;
  private final int nom;
  
  public a(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(246073);
    this.bitmap = paramBitmap;
    this.alpha = paramFloat;
    this.TAG = "MicroMsg.LiveLikeConfetti";
    this.centerX = (this.bitmap.getWidth() / 2);
    this.centerY = (this.bitmap.getHeight() / 2);
    this.noj = c.aixl.qq(0, 2);
    this.nok = 0.685F;
    this.nol = 1.4F;
    this.nom = 250;
    AppMethodBeat.o(246073);
  }
  
  public final void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(246107);
    s.u(paramCanvas, "canvas");
    s.u(paramMatrix, "matrix");
    s.u(paramPaint, "paint");
    int i;
    if (paramFloat4 <= this.nok)
    {
      paramFloat1 = Math.max(paramFloat4 / (this.nok / this.nol), 0.5F);
      i = paramPaint.getAlpha();
      if (paramFloat2 <= this.pxa - this.nom) {
        break label168;
      }
    }
    label168:
    for (paramFloat3 = this.pwZ;; paramFloat3 = this.pwZ - this.noj * 0.5F * (this.pxa - this.nom - paramFloat2))
    {
      paramMatrix.preTranslate(paramFloat3, paramFloat2);
      paramMatrix.preScale(paramFloat1, paramFloat1, this.centerX, this.centerY);
      paramPaint.setAlpha((int)(255.0F * this.alpha));
      paramCanvas.drawBitmap(this.bitmap, paramMatrix, paramPaint);
      paramPaint.setAlpha(i);
      AppMethodBeat.o(246107);
      return;
      paramFloat1 = Math.max((1.0F - paramFloat4) / ((1.0F - this.nok) / this.nol), 0.5F);
      break;
    }
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(246096);
    int i = this.bitmap.getHeight();
    AppMethodBeat.o(246096);
    return i;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(246091);
    int i = this.bitmap.getWidth();
    AppMethodBeat.o(246091);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.view.b.a
 * JD-Core Version:    0.7.0.1
 */