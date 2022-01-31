package android.support.design.widget;

import android.support.v4.f.i;
import android.support.v4.view.m;
import android.support.v4.view.q;
import android.support.v4.view.y;
import android.view.View;

final class CollapsingToolbarLayout$1
  implements m
{
  CollapsingToolbarLayout$1(CollapsingToolbarLayout paramCollapsingToolbarLayout) {}
  
  public final y a(View paramView, y paramy)
  {
    CollapsingToolbarLayout localCollapsingToolbarLayout = this.hp;
    paramView = null;
    if (q.ae(localCollapsingToolbarLayout)) {
      paramView = paramy;
    }
    if (!i.equals(localCollapsingToolbarLayout.ev, paramView))
    {
      localCollapsingToolbarLayout.ev = paramView;
      localCollapsingToolbarLayout.requestLayout();
    }
    return paramy.dv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.CollapsingToolbarLayout.1
 * JD-Core Version:    0.7.0.1
 */