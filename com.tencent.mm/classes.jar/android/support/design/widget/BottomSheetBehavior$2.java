package android.support.design.widget;

import android.support.v4.c.a;
import android.support.v4.view.q;
import android.support.v4.widget.r;
import android.support.v4.widget.r.a;
import android.view.View;
import java.lang.ref.WeakReference;

final class BottomSheetBehavior$2
  extends r.a
{
  BottomSheetBehavior$2(BottomSheetBehavior paramBottomSheetBehavior) {}
  
  public final void a(View paramView, float paramFloat1, float paramFloat2)
  {
    int j = 3;
    int i;
    if (paramFloat2 < 0.0F) {
      i = this.fI.fo;
    }
    while (this.fI.ft.x(paramView.getLeft(), i))
    {
      this.fI.v(2);
      q.b(paramView, new BottomSheetBehavior.b(this.fI, paramView, j));
      return;
      if ((this.fI.fq) && (this.fI.a(paramView, paramFloat2)))
      {
        i = this.fI.fx;
        j = 5;
      }
      else if (paramFloat2 == 0.0F)
      {
        i = paramView.getTop();
        if (Math.abs(i - this.fI.fo) < Math.abs(i - this.fI.fp))
        {
          i = this.fI.fo;
        }
        else
        {
          i = this.fI.fp;
          j = 4;
        }
      }
      else
      {
        i = this.fI.fp;
        j = 4;
      }
    }
    this.fI.v(j);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2)
  {
    this.fI.w(paramInt2);
  }
  
  public final int au()
  {
    if (this.fI.fq) {
      return this.fI.fx - this.fI.fo;
    }
    return this.fI.fp - this.fI.fo;
  }
  
  public final boolean b(View paramView, int paramInt)
  {
    if (this.fI.mState == 1) {
      return false;
    }
    if (this.fI.fE) {
      return false;
    }
    if ((this.fI.mState == 3) && (this.fI.fC == paramInt))
    {
      View localView = (View)this.fI.fz.get();
      if ((localView != null) && (localView.canScrollVertically(-1))) {
        return false;
      }
    }
    return (this.fI.fy != null) && (this.fI.fy.get() == paramView);
  }
  
  public final int c(View paramView, int paramInt)
  {
    int j = this.fI.fo;
    if (this.fI.fq) {}
    for (int i = this.fI.fx;; i = this.fI.fp) {
      return a.clamp(paramInt, j, i);
    }
  }
  
  public final int d(View paramView, int paramInt)
  {
    return paramView.getLeft();
  }
  
  public final void x(int paramInt)
  {
    if (paramInt == 1) {
      this.fI.v(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.BottomSheetBehavior.2
 * JD-Core Version:    0.7.0.1
 */