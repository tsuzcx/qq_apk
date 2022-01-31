package com.tencent.mm.particles;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.particles.a.b;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

final class c$2
  implements ValueAnimator.AnimatorUpdateListener
{
  c$2(c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(151574);
    long l1 = paramValueAnimator.getCurrentPlayTime();
    c.a(this.ghB, l1);
    paramValueAnimator = this.ghB;
    Iterator localIterator = paramValueAnimator.ggW.iterator();
    label93:
    label358:
    label364:
    label367:
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.ghN == -1L) {
        localb.ghN = l1;
      }
      long l2 = l1 - localb.ghN;
      boolean bool;
      if (l2 >= 0L)
      {
        bool = true;
        localb.gic = bool;
        if ((localb.gic) && (!localb.terminated))
        {
          localb.ghZ = b.a(l2, localb.ghO, localb.ghQ, localb.ghi, localb.ghS, localb.ghm);
          localb.gia = b.a(l2, localb.ghP, localb.ghR, localb.ghk, localb.ghT, localb.gho);
          localb.gib = b.a(l2, localb.ghU, localb.ghV, localb.ghu, localb.ghW, localb.ghw);
          if (localb.ghc == null) {
            break label347;
          }
          localb.alpha = ((int)(localb.ghc.getInterpolation((float)l2 / localb.ghX) * 255.0F));
          if ((localb.gid) || ((float)l2 < localb.ghX)) {
            break label358;
          }
          bool = true;
          localb.terminated = bool;
          localb.ghY = Math.min(1.0F, (float)l2 / localb.ghX);
        }
        if (localb.terminated) {
          break label364;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label367;
        }
        localIterator.remove();
        paramValueAnimator.ggV.add(localb);
        break;
        bool = false;
        break label93;
        localb.alpha = 255;
        break label257;
        bool = false;
        break label280;
      }
    }
    label257:
    label280:
    label347:
    if ((this.ghB.ggW.size() == 0) && (l1 >= this.ghB.gha))
    {
      this.ghB.anW();
      AppMethodBeat.o(151574);
      return;
    }
    this.ghB.ggU.invalidate();
    AppMethodBeat.o(151574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.particles.c.2
 * JD-Core Version:    0.7.0.1
 */