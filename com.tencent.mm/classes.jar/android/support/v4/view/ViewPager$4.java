package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;

final class ViewPager$4
  implements p
{
  private final Rect mTempRect = new Rect();
  
  ViewPager$4(ViewPager paramViewPager) {}
  
  public final ab a(View paramView, ab paramab)
  {
    paramView = t.a(paramView, paramab);
    if (paramView.isConsumed()) {
      return paramView;
    }
    paramab = this.mTempRect;
    paramab.left = paramView.getSystemWindowInsetLeft();
    paramab.top = paramView.getSystemWindowInsetTop();
    paramab.right = paramView.getSystemWindowInsetRight();
    paramab.bottom = paramView.getSystemWindowInsetBottom();
    int i = 0;
    int j = this.Ha.getChildCount();
    while (i < j)
    {
      ab localab = t.b(this.Ha.getChildAt(i), paramView);
      paramab.left = Math.min(localab.getSystemWindowInsetLeft(), paramab.left);
      paramab.top = Math.min(localab.getSystemWindowInsetTop(), paramab.top);
      paramab.right = Math.min(localab.getSystemWindowInsetRight(), paramab.right);
      paramab.bottom = Math.min(localab.getSystemWindowInsetBottom(), paramab.bottom);
      i += 1;
    }
    return paramView.f(paramab.left, paramab.top, paramab.right, paramab.bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.view.ViewPager.4
 * JD-Core Version:    0.7.0.1
 */