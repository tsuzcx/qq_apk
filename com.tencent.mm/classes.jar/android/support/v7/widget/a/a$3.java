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
    super(paramv1, paramInt1, paramInt2, paramFloat1, paramFloat2, 0.0F, 0.0F);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this.aqH) {}
    for (;;)
    {
      return;
      if (this.aqs <= 0) {
        this.aqr.aqe.a(this.aqr.adt, this.aqt);
      }
      while (this.aqr.aql == this.aqt.aku)
      {
        this.aqr.ca(this.aqt.aku);
        return;
        this.aqr.apT.add(this.aqt.aku);
        this.aqG = true;
        if (this.aqs > 0)
        {
          paramAnimator = this.aqr;
          int i = this.aqs;
          paramAnimator.adt.post(new a.4(paramAnimator, this, i));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.a.a.3
 * JD-Core Version:    0.7.0.1
 */