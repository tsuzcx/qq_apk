package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.c.a;
import android.support.v4.view.d;
import android.support.v4.view.q;
import android.support.v4.view.y;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import java.util.List;

abstract class HeaderScrollingViewBehavior
  extends ViewOffsetBehavior<View>
{
  final Rect jf = new Rect();
  final Rect jg = new Rect();
  int jh = 0;
  int ji;
  
  public HeaderScrollingViewBehavior() {}
  
  public HeaderScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramView.getLayoutParams().height;
    if ((j == -1) || (j == -2))
    {
      View localView = f(paramCoordinatorLayout.n(paramView));
      if (localView != null)
      {
        if ((q.ae(localView)) && (!q.ae(paramView)))
        {
          q.e(paramView, true);
          if (q.ae(paramView))
          {
            paramView.requestLayout();
            return true;
          }
        }
        int i = View.MeasureSpec.getSize(paramInt3);
        paramInt3 = i;
        if (i == 0) {
          paramInt3 = paramCoordinatorLayout.getHeight();
        }
        int k = localView.getMeasuredHeight();
        int m = f(localView);
        if (j == -1) {}
        for (i = 1073741824;; i = -2147483648)
        {
          paramCoordinatorLayout.a(paramView, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(m + (paramInt3 - k), i), paramInt4);
          return true;
        }
      }
    }
    return false;
  }
  
  protected final void d(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    View localView = f(paramCoordinatorLayout.n(paramView));
    if (localView != null)
    {
      CoordinatorLayout.d locald = (CoordinatorLayout.d)paramView.getLayoutParams();
      Rect localRect = this.jf;
      localRect.set(paramCoordinatorLayout.getPaddingLeft() + locald.leftMargin, localView.getBottom() + locald.topMargin, paramCoordinatorLayout.getWidth() - paramCoordinatorLayout.getPaddingRight() - locald.rightMargin, paramCoordinatorLayout.getHeight() + localView.getBottom() - paramCoordinatorLayout.getPaddingBottom() - locald.bottomMargin);
      y localy = paramCoordinatorLayout.getLastWindowInsets();
      if ((localy != null) && (q.ae(paramCoordinatorLayout)) && (!q.ae(paramView)))
      {
        localRect.left += localy.getSystemWindowInsetLeft();
        localRect.right -= localy.getSystemWindowInsetRight();
      }
      paramCoordinatorLayout = this.jg;
      int j = locald.gravity;
      int i = j;
      if (j == 0) {
        i = 8388659;
      }
      d.apply(i, paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect, paramCoordinatorLayout, paramInt);
      paramInt = p(localView);
      paramView.layout(paramCoordinatorLayout.left, paramCoordinatorLayout.top - paramInt, paramCoordinatorLayout.right, paramCoordinatorLayout.bottom - paramInt);
      this.jh = (paramCoordinatorLayout.top - localView.getBottom());
      return;
    }
    super.d(paramCoordinatorLayout, paramView, paramInt);
    this.jh = 0;
  }
  
  float e(View paramView)
  {
    return 1.0F;
  }
  
  int f(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  abstract View f(List<View> paramList);
  
  final int p(View paramView)
  {
    if (this.ji == 0) {
      return 0;
    }
    return a.clamp((int)(e(paramView) * this.ji), 0, this.ji);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.HeaderScrollingViewBehavior
 * JD-Core Version:    0.7.0.1
 */