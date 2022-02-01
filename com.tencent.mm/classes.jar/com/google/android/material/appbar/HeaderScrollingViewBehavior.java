package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import androidx.core.b.a;
import androidx.core.g.ah;
import androidx.core.g.e;
import androidx.core.g.z;
import java.util.List;

abstract class HeaderScrollingViewBehavior
  extends ViewOffsetBehavior<View>
{
  final Rect doP = new Rect();
  final Rect doQ = new Rect();
  private int doR = 0;
  int doS;
  
  public HeaderScrollingViewBehavior() {}
  
  public HeaderScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  final int VD()
  {
    return this.doR;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramView.getLayoutParams().height;
    if ((j == -1) || (j == -2))
    {
      View localView = ap(paramCoordinatorLayout.G(paramView));
      if (localView != null)
      {
        if ((z.al(localView)) && (!z.al(paramView)))
        {
          z.c(paramView, true);
          if (z.al(paramView))
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
        int m = cs(localView);
        if (j == -1) {}
        for (i = 1073741824;; i = -2147483648)
        {
          paramCoordinatorLayout.e(paramView, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(m + (paramInt3 - k), i), paramInt4);
          return true;
        }
      }
    }
    return false;
  }
  
  abstract View ap(List<View> paramList);
  
  protected final void c(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    View localView = ap(paramCoordinatorLayout.G(paramView));
    if (localView != null)
    {
      CoordinatorLayout.d locald = (CoordinatorLayout.d)paramView.getLayoutParams();
      Rect localRect = this.doP;
      localRect.set(paramCoordinatorLayout.getPaddingLeft() + locald.leftMargin, localView.getBottom() + locald.topMargin, paramCoordinatorLayout.getWidth() - paramCoordinatorLayout.getPaddingRight() - locald.rightMargin, paramCoordinatorLayout.getHeight() + localView.getBottom() - paramCoordinatorLayout.getPaddingBottom() - locald.bottomMargin);
      ah localah = paramCoordinatorLayout.getLastWindowInsets();
      if ((localah != null) && (z.al(paramCoordinatorLayout)) && (!z.al(paramView)))
      {
        localRect.left += localah.Em();
        localRect.right -= localah.Eo();
      }
      paramCoordinatorLayout = this.doQ;
      int j = locald.fl;
      int i = j;
      if (j == 0) {
        i = 8388659;
      }
      e.a(i, paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect, paramCoordinatorLayout, paramInt);
      paramInt = cx(localView);
      paramView.layout(paramCoordinatorLayout.left, paramCoordinatorLayout.top - paramInt, paramCoordinatorLayout.right, paramCoordinatorLayout.bottom - paramInt);
      this.doR = (paramCoordinatorLayout.top - localView.getBottom());
      return;
    }
    super.c(paramCoordinatorLayout, paramView, paramInt);
    this.doR = 0;
  }
  
  float cr(View paramView)
  {
    return 1.0F;
  }
  
  int cs(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  final int cx(View paramView)
  {
    if (this.doS == 0) {
      return 0;
    }
    return a.clamp((int)(cr(paramView) * this.doS), 0, this.doS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.appbar.HeaderScrollingViewBehavior
 * JD-Core Version:    0.7.0.1
 */