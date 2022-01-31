package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;

final class ViewPager$4
  implements m
{
  private final Rect ec = new Rect();
  
  ViewPager$4(ViewPager paramViewPager) {}
  
  public final y a(View paramView, y paramy)
  {
    paramView = q.a(paramView, paramy);
    if (paramView.isConsumed()) {
      return paramView;
    }
    paramy = this.ec;
    paramy.left = paramView.getSystemWindowInsetLeft();
    paramy.top = paramView.getSystemWindowInsetTop();
    paramy.right = paramView.getSystemWindowInsetRight();
    paramy.bottom = paramView.getSystemWindowInsetBottom();
    int i = 0;
    int j = this.Hp.getChildCount();
    while (i < j)
    {
      y localy = q.b(this.Hp.getChildAt(i), paramView);
      paramy.left = Math.min(localy.getSystemWindowInsetLeft(), paramy.left);
      paramy.top = Math.min(localy.getSystemWindowInsetTop(), paramy.top);
      paramy.right = Math.min(localy.getSystemWindowInsetRight(), paramy.right);
      paramy.bottom = Math.min(localy.getSystemWindowInsetBottom(), paramy.bottom);
      i += 1;
    }
    return paramView.f(paramy.left, paramy.top, paramy.right, paramy.bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.view.ViewPager.4
 * JD-Core Version:    0.7.0.1
 */