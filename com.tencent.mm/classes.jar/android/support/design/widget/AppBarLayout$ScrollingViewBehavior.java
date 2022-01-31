package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.design.a.k;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

public class AppBarLayout$ScrollingViewBehavior
  extends HeaderScrollingViewBehavior
{
  public AppBarLayout$ScrollingViewBehavior() {}
  
  public AppBarLayout$ScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ScrollingViewBehavior_Layout);
    this.ji = paramContext.getDimensionPixelSize(a.k.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
    paramContext.recycle();
  }
  
  private static AppBarLayout e(List<View> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)paramList.get(i);
      if ((localView instanceof AppBarLayout)) {
        return (AppBarLayout)localView;
      }
      i += 1;
    }
    return null;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, Rect paramRect, boolean paramBoolean)
  {
    AppBarLayout localAppBarLayout = e(paramCoordinatorLayout.n(paramView));
    if (localAppBarLayout != null)
    {
      paramRect.offset(paramView.getLeft(), paramView.getTop());
      paramView = this.jf;
      paramView.set(0, 0, paramCoordinatorLayout.getWidth(), paramCoordinatorLayout.getHeight());
      if (!paramView.contains(paramRect))
      {
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          localAppBarLayout.d(false, paramBoolean, true);
          return true;
        }
      }
    }
    return false;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    paramCoordinatorLayout = ((CoordinatorLayout.d)paramView2.getLayoutParams()).hP;
    if ((paramCoordinatorLayout instanceof AppBarLayout.Behavior))
    {
      paramCoordinatorLayout = (AppBarLayout.Behavior)paramCoordinatorLayout;
      int i = paramView2.getBottom();
      int j = paramView1.getTop();
      q.p(paramView1, AppBarLayout.Behavior.a(paramCoordinatorLayout) + (i - j) + this.jh - p(paramView2));
    }
    return false;
  }
  
  public final boolean d(View paramView)
  {
    return paramView instanceof AppBarLayout;
  }
  
  final float e(View paramView)
  {
    if ((paramView instanceof AppBarLayout))
    {
      paramView = (AppBarLayout)paramView;
      int j = paramView.getTotalScrollRange();
      int k = paramView.getDownNestedPreScrollRange();
      paramView = ((CoordinatorLayout.d)paramView.getLayoutParams()).hP;
      if ((paramView instanceof AppBarLayout.Behavior)) {}
      for (int i = ((AppBarLayout.Behavior)paramView).ad(); (k != 0) && (j + i <= k); i = 0) {
        return 0.0F;
      }
      j -= k;
      if (j != 0) {
        return i / j + 1.0F;
      }
    }
    return 0.0F;
  }
  
  final int f(View paramView)
  {
    if ((paramView instanceof AppBarLayout)) {
      return ((AppBarLayout)paramView).getTotalScrollRange();
    }
    return super.f(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.AppBarLayout.ScrollingViewBehavior
 * JD-Core Version:    0.7.0.1
 */