package com.tencent.mm.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mm.view.b.a;

public final class d$1
  implements ValueAnimator.AnimatorUpdateListener
{
  int buE = 0;
  float buF = (float)Math.pow(this.buH.mScale / this.buG, 0.25D);
  float buw = 0.0F;
  float bux = 0.0F;
  
  public d$1(d paramd, float paramFloat) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = 0.0F;
    float f4 = ((Float)paramValueAnimator.getAnimatedValue("deltaY")).floatValue();
    float f5 = ((Float)paramValueAnimator.getAnimatedValue("deltaX")).floatValue();
    if ((this.buE < 4) && (this.buH.buC))
    {
      this.buH.buz.getMainMatrix().postScale(this.buF, this.buF);
      this.buE += 1;
    }
    paramValueAnimator = this.buH.buz.getCurImageRect();
    Object localObject = this.buH.buz.getBoardRect();
    float f3;
    if (!this.buH.buD)
    {
      localObject = this.buH;
      ((d)localObject).buA += f5 - this.bux;
      localObject = this.buH;
      ((d)localObject).buB += f4 - this.buw;
      f1 = this.buH.buA - paramValueAnimator.centerX();
      f3 = this.buH.buB - paramValueAnimator.centerY();
      this.buH.buz.getMainMatrix().postTranslate(f1, f3);
      this.buH.buz.postInvalidate();
      this.buw = f4;
      this.bux = f5;
      return;
    }
    if (paramValueAnimator.top > ((Rect)localObject).top) {}
    for (float f2 = ((Rect)localObject).top - paramValueAnimator.top;; f2 = 0.0F)
    {
      if (paramValueAnimator.right < ((Rect)localObject).right) {
        f1 = ((Rect)localObject).right - paramValueAnimator.right;
      }
      if (paramValueAnimator.bottom < ((Rect)localObject).bottom) {
        f2 = ((Rect)localObject).bottom - paramValueAnimator.bottom;
      }
      f3 = f2;
      if (paramValueAnimator.left <= ((Rect)localObject).left) {
        break;
      }
      f1 = ((Rect)localObject).left - paramValueAnimator.left;
      f3 = f2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.b.d.1
 * JD-Core Version:    0.7.0.1
 */