package android.support.design.widget;

import android.support.v4.e.i;
import android.support.v4.view.ab;
import android.support.v4.view.p;
import android.support.v4.view.t;
import android.view.View;

final class AppBarLayout$1
  implements p
{
  AppBarLayout$1(AppBarLayout paramAppBarLayout) {}
  
  public final ab a(View paramView, ab paramab)
  {
    AppBarLayout localAppBarLayout = this.fz;
    paramView = null;
    if (t.al(localAppBarLayout)) {
      paramView = paramab;
    }
    if (!i.equals(localAppBarLayout.fu, paramView))
    {
      localAppBarLayout.fu = paramView;
      localAppBarLayout.aL();
    }
    return paramab;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.AppBarLayout.1
 * JD-Core Version:    0.7.0.1
 */