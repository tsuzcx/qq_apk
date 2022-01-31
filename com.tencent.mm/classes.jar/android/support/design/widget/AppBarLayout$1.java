package android.support.design.widget;

import android.support.v4.f.i;
import android.support.v4.view.m;
import android.support.v4.view.q;
import android.support.v4.view.y;
import android.view.View;

final class AppBarLayout$1
  implements m
{
  AppBarLayout$1(AppBarLayout paramAppBarLayout) {}
  
  public final y a(View paramView, y paramy)
  {
    AppBarLayout localAppBarLayout = this.ez;
    paramView = null;
    if (q.ae(localAppBarLayout)) {
      paramView = paramy;
    }
    if (!i.equals(localAppBarLayout.ev, paramView))
    {
      localAppBarLayout.ev = paramView;
      localAppBarLayout.aa();
    }
    return paramy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.AppBarLayout.1
 * JD-Core Version:    0.7.0.1
 */