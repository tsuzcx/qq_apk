package android.support.design.widget;

import android.support.v4.b.a;
import android.support.v4.view.ab;
import android.support.v4.view.t;
import android.view.View;

final class CollapsingToolbarLayout$a
  implements AppBarLayout.a
{
  CollapsingToolbarLayout$a(CollapsingToolbarLayout paramCollapsingToolbarLayout) {}
  
  public final void q(int paramInt)
  {
    this.ij.ii = paramInt;
    int i;
    label41:
    View localView;
    CollapsingToolbarLayout.LayoutParams localLayoutParams;
    o localo;
    if (this.ij.fu != null)
    {
      i = this.ij.fu.getSystemWindowInsetTop();
      k = this.ij.getChildCount();
      j = 0;
      if (j >= k) {
        break label165;
      }
      localView = this.ij.getChildAt(j);
      localLayoutParams = (CollapsingToolbarLayout.LayoutParams)localView.getLayoutParams();
      localo = CollapsingToolbarLayout.l(localView);
      switch (localLayoutParams.ik)
      {
      }
    }
    for (;;)
    {
      j += 1;
      break label41;
      i = 0;
      break;
      localo.p(a.clamp(-paramInt, 0, this.ij.m(localView)));
      continue;
      float f = -paramInt;
      localo.p(Math.round(localLayoutParams.il * f));
    }
    label165:
    this.ij.bl();
    if ((this.ij.ia != null) && (i > 0)) {
      t.R(this.ij);
    }
    int j = this.ij.getHeight();
    int k = t.aa(this.ij);
    this.ij.hW.h(Math.abs(paramInt) / (j - k - i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.CollapsingToolbarLayout.a
 * JD-Core Version:    0.7.0.1
 */