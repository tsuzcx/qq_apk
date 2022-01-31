package android.support.v7.widget.a;

import android.animation.Animator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import java.util.List;

final class a$3
  extends a.c
{
  a$3(a parama, RecyclerView.v paramv1, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt3, RecyclerView.v paramv2)
  {
    super(paramv1, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this.aos) {}
    for (;;)
    {
      return;
      if (this.aob <= 0) {
        this.aoa.anN.a(this.aoa.acI, this.aoc);
      }
      while (this.aoa.anU == this.aoc.aie)
      {
        this.aoa.bH(this.aoc.aie);
        return;
        this.aoa.anC.add(this.aoc.aie);
        this.aop = true;
        if (this.aob > 0)
        {
          paramAnimator = this.aoa;
          int i = this.aob;
          paramAnimator.acI.post(new a.4(paramAnimator, this, i));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.a.a.3
 * JD-Core Version:    0.7.0.1
 */