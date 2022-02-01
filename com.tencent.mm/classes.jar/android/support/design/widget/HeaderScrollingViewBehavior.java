package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.b.a;
import android.support.v4.view.ab;
import android.support.v4.view.d;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import java.util.List;

abstract class HeaderScrollingViewBehavior
  extends ViewOffsetBehavior<View>
{
  final Rect ph = new Rect();
  final Rect pi = new Rect();
  int pj = 0;
  int pk;
  
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
      View localView = f(paramCoordinatorLayout.s(paramView));
      if (localView != null)
      {
        if ((t.aq(localView)) && (!t.aq(paramView)))
        {
          t.e(paramView, true);
          if (t.aq(paramView))
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
        int m = i(localView);
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
  
  protected final void c(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    View localView = f(paramCoordinatorLayout.s(paramView));
    if (localView != null)
    {
      CoordinatorLayout.d locald = (CoordinatorLayout.d)paramView.getLayoutParams();
      Rect localRect = this.ph;
      localRect.set(paramCoordinatorLayout.getPaddingLeft() + locald.leftMargin, localView.getBottom() + locald.topMargin, paramCoordinatorLayout.getWidth() - paramCoordinatorLayout.getPaddingRight() - locald.rightMargin, paramCoordinatorLayout.getHeight() + localView.getBottom() - paramCoordinatorLayout.getPaddingBottom() - locald.bottomMargin);
      ab localab = paramCoordinatorLayout.getLastWindowInsets();
      if ((localab != null) && (t.aq(paramCoordinatorLayout)) && (!t.aq(paramView)))
      {
        localRect.left += localab.getSystemWindowInsetLeft();
        localRect.right -= localab.getSystemWindowInsetRight();
      }
      paramCoordinatorLayout = this.pi;
      int j = locald.gravity;
      int i = j;
      if (j == 0) {
        i = 8388659;
      }
      d.apply(i, paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect, paramCoordinatorLayout, paramInt);
      paramInt = v(localView);
      paramView.layout(paramCoordinatorLayout.left, paramCoordinatorLayout.top - paramInt, paramCoordinatorLayout.right, paramCoordinatorLayout.bottom - paramInt);
      this.pj = (paramCoordinatorLayout.top - localView.getBottom());
      return;
    }
    super.c(paramCoordinatorLayout, paramView, paramInt);
    this.pj = 0;
  }
  
  abstract View f(List<View> paramList);
  
  float h(View paramView)
  {
    return 1.0F;
  }
  
  int i(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  final int v(View paramView)
  {
    if (this.pk == 0) {
      return 0;
    }
    return a.clamp((int)(h(paramView) * this.pk), 0, this.pk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.HeaderScrollingViewBehavior
 * JD-Core Version:    0.7.0.1
 */