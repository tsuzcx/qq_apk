package com.tencent.mm.c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.b.a;

public final class d
  extends b
{
  public ValueAnimator hbU;
  a hcn;
  float hco = 1.0F;
  float hcp;
  float hcq;
  boolean hcr = true;
  boolean hcs = false;
  
  public d(a parama)
  {
    this.hcn = parama;
  }
  
  public final void play()
  {
    AppMethodBeat.i(236243);
    if (!this.hcg)
    {
      AppMethodBeat.o(236243);
      return;
    }
    Log.d("MicroMsg.StickRoundAnim", "[play] start");
    RectF localRectF = this.hcn.getCurValidImageRect();
    Rect localRect = this.hcn.getBoardRect();
    this.hcp = localRectF.centerX();
    this.hcq = localRectF.centerY();
    float f2 = localRect.centerY() - localRectF.centerY();
    float f1 = localRect.centerX() - localRectF.centerX();
    final float f4 = this.hcn.getCurScale();
    float f5 = this.hcn.getMaxScale();
    float f3 = this.hcn.getMinScale();
    int i;
    label150:
    int j;
    if (f4 > f5)
    {
      this.hco = f5;
      this.hcr = true;
      if (localRect.height() >= localRectF.height()) {
        break label453;
      }
      i = 1;
      if (localRect.width() >= localRectF.width()) {
        break label459;
      }
      j = 1;
      label168:
      if (i != 0) {
        f2 = 0.0F;
      }
      if (j != 0) {
        f1 = 0.0F;
      }
      if ((localRectF.top <= localRect.top) || (i == 0)) {
        break label465;
      }
      f2 = localRect.top - localRectF.top;
    }
    label541:
    label549:
    for (;;)
    {
      label215:
      if ((localRectF.left > localRect.left) && (j != 0))
      {
        f3 = localRect.left - localRectF.left;
        label248:
        Log.d("MicroMsg.StickRoundAnim", "%s %s ", new Object[] { Float.valueOf(f3), Float.valueOf(f2) });
        if (f4 <= f5) {
          break label541;
        }
      }
      for (this.hcs = true;; this.hcs = false)
      {
        this.hbU = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, f2 }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, f3 }), PropertyValuesHolder.ofFloat("scale", new float[] { 0.0F, 80.0F }) });
        this.hbU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          float hck;
          float hcl;
          float hct;
          int scaleCount;
          
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            float f1 = 0.0F;
            AppMethodBeat.i(9114);
            float f4 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaY")).floatValue();
            float f5 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaX")).floatValue();
            if ((this.scaleCount < 4) && (d.this.hcr))
            {
              d.this.hcn.getMainMatrix().postScale(this.hct, this.hct);
              this.scaleCount += 1;
            }
            paramAnonymousValueAnimator = d.this.hcn.getCurValidImageRect();
            Object localObject = d.this.hcn.getBoardRect();
            float f3;
            if (!d.this.hcs)
            {
              localObject = d.this;
              ((d)localObject).hcp += f5 - this.hcl;
              localObject = d.this;
              ((d)localObject).hcq += f4 - this.hck;
              f1 = d.this.hcp - paramAnonymousValueAnimator.centerX();
              f3 = d.this.hcq - paramAnonymousValueAnimator.centerY();
              d.this.hcn.getMainMatrix().postTranslate(f1, f3);
              d.this.hcn.postInvalidate();
              this.hck = f4;
              this.hcl = f5;
              AppMethodBeat.o(9114);
              return;
            }
            if (paramAnonymousValueAnimator.top > ((Rect)localObject).top) {}
            for (float f2 = ((Rect)localObject).top - paramAnonymousValueAnimator.top;; f2 = 0.0F)
            {
              if (paramAnonymousValueAnimator.right < ((Rect)localObject).right) {
                f1 = ((Rect)localObject).right - paramAnonymousValueAnimator.right;
              }
              if (paramAnonymousValueAnimator.bottom < ((Rect)localObject).bottom) {
                f2 = ((Rect)localObject).bottom - paramAnonymousValueAnimator.bottom;
              }
              f3 = f2;
              if (paramAnonymousValueAnimator.left <= ((Rect)localObject).left) {
                break;
              }
              f1 = ((Rect)localObject).left - paramAnonymousValueAnimator.left;
              f3 = f2;
              break;
            }
          }
        });
        this.hbU.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator)
          {
            d.this.hcg = true;
          }
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            d.this.hcg = true;
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            d.this.hcg = false;
          }
        });
        this.hbU.setInterpolator(new LinearInterpolator());
        this.hbU.setDuration(80L);
        this.hbU.start();
        AppMethodBeat.o(236243);
        return;
        if (f4 < f3)
        {
          this.hco = f3;
          this.hcr = true;
          break;
        }
        this.hcr = false;
        break;
        label453:
        i = 0;
        break label150;
        label459:
        j = 0;
        break label168;
        label465:
        if ((localRectF.bottom >= localRect.bottom) || (i == 0)) {
          break label549;
        }
        f2 = localRect.bottom - localRectF.bottom;
        break label215;
        f3 = f1;
        if (localRectF.right >= localRect.right) {
          break label248;
        }
        f3 = f1;
        if (j == 0) {
          break label248;
        }
        f3 = localRect.right - localRectF.right;
        break label248;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.c.d
 * JD-Core Version:    0.7.0.1
 */