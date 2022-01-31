package android.support.design.widget;

import android.support.v4.widget.t.a;
import android.view.View;
import android.view.ViewParent;

final class SwipeDismissBehavior$1
  extends t.a
{
  private int kX;
  private int mActivePointerId = -1;
  
  SwipeDismissBehavior$1(SwipeDismissBehavior paramSwipeDismissBehavior) {}
  
  public final void a(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    this.mActivePointerId = -1;
    int j = paramView.getWidth();
    int i;
    if (paramFloat1 != 0.0F) {
      if (android.support.v4.view.t.T(paramView) == 1)
      {
        i = 1;
        if (this.kY.kT != 2) {
          break label114;
        }
        i = 1;
        label45:
        if (i == 0) {
          break label290;
        }
        if (paramView.getLeft() >= this.kX) {
          break label278;
        }
        i = this.kX - j;
        label70:
        if (!this.kY.gq.y(i, paramView.getTop())) {
          break label302;
        }
        android.support.v4.view.t.b(paramView, new SwipeDismissBehavior.b(this.kY, paramView, bool));
      }
    }
    label114:
    while ((!bool) || (this.kY.kP == null))
    {
      return;
      i = 0;
      break;
      if (this.kY.kT == 0)
      {
        if (i != 0)
        {
          if (paramFloat1 < 0.0F)
          {
            i = 1;
            break label45;
          }
          i = 0;
          break label45;
        }
        if (paramFloat1 > 0.0F)
        {
          i = 1;
          break label45;
        }
        i = 0;
        break label45;
      }
      if (this.kY.kT == 1)
      {
        if (i != 0)
        {
          if (paramFloat1 > 0.0F)
          {
            i = 1;
            break label45;
          }
          i = 0;
          break label45;
        }
        if (paramFloat1 < 0.0F)
        {
          i = 1;
          break label45;
        }
        i = 0;
        break label45;
        i = paramView.getLeft();
        int k = this.kX;
        int m = Math.round(paramView.getWidth() * this.kY.kU);
        if (Math.abs(i - k) >= m)
        {
          i = 1;
          break label45;
        }
        i = 0;
        break label45;
      }
      i = 0;
      break label45;
      i = this.kX + j;
      break label70;
      i = this.kX;
      bool = false;
      break label70;
    }
    label278:
    label290:
    label302:
    this.kY.kP.onDismiss(paramView);
  }
  
  public final void b(View paramView, int paramInt1, int paramInt2)
  {
    float f1 = this.kX + paramView.getWidth() * this.kY.kV;
    float f2 = this.kX + paramView.getWidth() * this.kY.kW;
    if (paramInt1 <= f1)
    {
      paramView.setAlpha(1.0F);
      return;
    }
    if (paramInt1 >= f2)
    {
      paramView.setAlpha(0.0F);
      return;
    }
    paramView.setAlpha(SwipeDismissBehavior.o(1.0F - SwipeDismissBehavior.c(f1, f2, paramInt1)));
  }
  
  public final boolean b(View paramView, int paramInt)
  {
    return (this.mActivePointerId == -1) && (this.kY.g(paramView));
  }
  
  public final int c(View paramView, int paramInt)
  {
    return paramView.getTop();
  }
  
  public final int d(View paramView, int paramInt)
  {
    int i;
    int j;
    if (android.support.v4.view.t.T(paramView) == 1)
    {
      i = 1;
      if (this.kY.kT != 0) {
        break label72;
      }
      if (i == 0) {
        break label53;
      }
      i = this.kX - paramView.getWidth();
      j = this.kX;
    }
    for (;;)
    {
      return SwipeDismissBehavior.clamp(i, paramInt, j);
      i = 0;
      break;
      label53:
      i = this.kX;
      j = this.kX + paramView.getWidth();
      continue;
      label72:
      if (this.kY.kT == 1)
      {
        if (i != 0)
        {
          i = this.kX;
          j = this.kX + paramView.getWidth();
        }
        else
        {
          i = this.kX - paramView.getWidth();
          j = this.kX;
        }
      }
      else
      {
        i = this.kX - paramView.getWidth();
        j = this.kX + paramView.getWidth();
      }
    }
  }
  
  public final void k(View paramView, int paramInt)
  {
    this.mActivePointerId = paramInt;
    this.kX = paramView.getLeft();
    paramView = paramView.getParent();
    if (paramView != null) {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  public final int s(View paramView)
  {
    return paramView.getWidth();
  }
  
  public final void w(int paramInt)
  {
    if (this.kY.kP != null) {
      this.kY.kP.r(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.SwipeDismissBehavior.1
 * JD-Core Version:    0.7.0.1
 */