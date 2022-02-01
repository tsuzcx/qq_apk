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
import androidx.core.g.ae;
import androidx.core.g.e;
import androidx.core.g.w;
import java.util.List;

abstract class HeaderScrollingViewBehavior
  extends ViewOffsetBehavior<View>
{
  final Rect bvM = new Rect();
  final Rect bvN = new Rect();
  private int bvO = 0;
  int bvP;
  
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
      View localView = w(paramCoordinatorLayout.x(paramView));
      if (localView != null)
      {
        if ((w.Z(localView)) && (!w.Z(paramView)))
        {
          w.c(paramView, true);
          if (w.Z(paramView))
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
        int m = bW(localView);
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
  
  float bV(View paramView)
  {
    return 1.0F;
  }
  
  int bW(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  protected final void c(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    View localView = w(paramCoordinatorLayout.x(paramView));
    if (localView != null)
    {
      CoordinatorLayout.d locald = (CoordinatorLayout.d)paramView.getLayoutParams();
      Rect localRect = this.bvM;
      localRect.set(paramCoordinatorLayout.getPaddingLeft() + locald.leftMargin, localView.getBottom() + locald.topMargin, paramCoordinatorLayout.getWidth() - paramCoordinatorLayout.getPaddingRight() - locald.rightMargin, paramCoordinatorLayout.getHeight() + localView.getBottom() - paramCoordinatorLayout.getPaddingBottom() - locald.bottomMargin);
      ae localae = paramCoordinatorLayout.getLastWindowInsets();
      if ((localae != null) && (w.Z(paramCoordinatorLayout)) && (!w.Z(paramView)))
      {
        localRect.left += localae.hc();
        localRect.right -= localae.he();
      }
      paramCoordinatorLayout = this.bvN;
      int j = locald.ek;
      int i = j;
      if (j == 0) {
        i = 8388659;
      }
      e.a(i, paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect, paramCoordinatorLayout, paramInt);
      paramInt = cb(localView);
      paramView.layout(paramCoordinatorLayout.left, paramCoordinatorLayout.top - paramInt, paramCoordinatorLayout.right, paramCoordinatorLayout.bottom - paramInt);
      this.bvO = (paramCoordinatorLayout.top - localView.getBottom());
      return;
    }
    super.c(paramCoordinatorLayout, paramView, paramInt);
    this.bvO = 0;
  }
  
  final int cb(View paramView)
  {
    if (this.bvP == 0) {
      return 0;
    }
    return a.clamp((int)(bV(paramView) * this.bvP), 0, this.bvP);
  }
  
  abstract View w(List<View> paramList);
  
  final int we()
  {
    return this.bvO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.appbar.HeaderScrollingViewBehavior
 * JD-Core Version:    0.7.0.1
 */