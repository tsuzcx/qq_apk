package android.support.design.widget;

import android.support.v4.c.a;
import android.support.v4.view.q;
import android.support.v4.view.y;
import android.view.View;

final class CollapsingToolbarLayout$a
  implements AppBarLayout.a
{
  CollapsingToolbarLayout$a(CollapsingToolbarLayout paramCollapsingToolbarLayout) {}
  
  public final void r(int paramInt)
  {
    this.hp.ho = paramInt;
    int i;
    label41:
    View localView;
    CollapsingToolbarLayout.LayoutParams localLayoutParams;
    p localp;
    if (this.hp.ev != null)
    {
      i = this.hp.ev.getSystemWindowInsetTop();
      k = this.hp.getChildCount();
      j = 0;
      if (j >= k) {
        break label165;
      }
      localView = this.hp.getChildAt(j);
      localLayoutParams = (CollapsingToolbarLayout.LayoutParams)localView.getLayoutParams();
      localp = CollapsingToolbarLayout.k(localView);
      switch (localLayoutParams.hq)
      {
      }
    }
    for (;;)
    {
      j += 1;
      break label41;
      i = 0;
      break;
      localp.q(a.clamp(-paramInt, 0, this.hp.l(localView)));
      continue;
      float f = -paramInt;
      localp.q(Math.round(localLayoutParams.hr * f));
    }
    label165:
    this.hp.aD();
    if ((this.hp.hh != null) && (i > 0)) {
      q.O(this.hp);
    }
    int j = this.hp.getHeight();
    int k = q.X(this.hp);
    this.hp.hd.h(Math.abs(paramInt) / (j - k - i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.CollapsingToolbarLayout.a
 * JD-Core Version:    0.7.0.1
 */