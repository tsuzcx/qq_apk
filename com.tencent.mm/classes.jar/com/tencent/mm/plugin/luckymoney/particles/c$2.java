package com.tencent.mm.plugin.luckymoney.particles;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.Interpolator;
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Random;

final class c$2
  implements ValueAnimator.AnimatorUpdateListener
{
  c$2(c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    long l1 = paramValueAnimator.getCurrentPlayTime();
    paramValueAnimator = this.lSM;
    Iterator localIterator;
    if (l1 < paramValueAnimator.lSk)
    {
      if (paramValueAnimator.lSi == 0L) {
        paramValueAnimator.lSi = l1;
      }
    }
    else
    {
      paramValueAnimator = this.lSM;
      localIterator = paramValueAnimator.lSh.iterator();
    }
    label49:
    label436:
    label439:
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label441;
      }
      b localb = (b)localIterator.next();
      if (localb.lSY == -1L) {
        localb.lSY = l1;
      }
      long l2 = l1 - localb.lSY;
      boolean bool;
      if (l2 >= 0L)
      {
        bool = true;
        label108:
        localb.lTn = bool;
        if ((localb.lTn) && (!localb.terminated))
        {
          localb.lTk = b.a(l2, localb.lSZ, localb.lTb, localb.lSt, localb.lTd, localb.lSx);
          localb.lTl = b.a(l2, localb.lTa, localb.lTc, localb.lSv, localb.lTe, localb.lSz);
          localb.lTm = b.a(l2, localb.lTf, localb.lTg, localb.lSF, localb.lTh, localb.lSH);
          if (localb.lSn == null) {
            break label419;
          }
          localb.alpha = ((int)(localb.lSn.getInterpolation((float)l2 / localb.lTi) * 255.0F));
          if ((localb.lTo) || ((float)l2 < localb.lTi)) {
            break label430;
          }
          bool = true;
          localb.terminated = bool;
          localb.lTj = Math.min(1.0F, (float)l2 / localb.lTi);
        }
        if (localb.terminated) {
          break label436;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label439;
        }
        localIterator.remove();
        paramValueAnimator.lSg.add(localb);
        break label49;
        l2 = paramValueAnimator.lSi;
        i = (int)(paramValueAnimator.random.nextFloat() * paramValueAnimator.lSl * (float)(l1 - l2));
        if (i <= 0) {
          break;
        }
        paramValueAnimator.lSi = (((float)paramValueAnimator.lSi + paramValueAnimator.lSm * i));
        paramValueAnimator.E(i, l1);
        break;
        bool = false;
        break label108;
        localb.alpha = 255;
        break label272;
        bool = false;
        break label295;
      }
    }
    label272:
    label295:
    label430:
    label441:
    if ((this.lSM.lSh.size() == 0) && (l1 >= this.lSM.lSk))
    {
      this.lSM.bfS();
      return;
    }
    label419:
    this.lSM.lSf.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.particles.c.2
 * JD-Core Version:    0.7.0.1
 */