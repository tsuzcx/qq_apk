package android.support.design.widget;

import android.support.v4.b.a;
import android.support.v4.widget.t.a;
import android.view.View;
import java.lang.ref.WeakReference;

final class BottomSheetBehavior$2
  extends t.a
{
  BottomSheetBehavior$2(BottomSheetBehavior paramBottomSheetBehavior) {}
  
  public final void a(View paramView, float paramFloat1, float paramFloat2)
  {
    int j = 3;
    int i;
    if (paramFloat2 < 0.0F) {
      i = this.gC.gm;
    }
    while (this.gC.gq.y(paramView.getLeft(), i))
    {
      this.gC.u(2);
      android.support.v4.view.t.b(paramView, new BottomSheetBehavior.b(this.gC, paramView, j));
      return;
      if ((this.gC.go) && (this.gC.a(paramView, paramFloat2)))
      {
        i = this.gC.gu;
        j = 5;
      }
      else if (paramFloat2 == 0.0F)
      {
        i = paramView.getTop();
        if (Math.abs(i - this.gC.gm) < Math.abs(i - this.gC.gn))
        {
          i = this.gC.gm;
        }
        else
        {
          i = this.gC.gn;
          j = 4;
        }
      }
      else
      {
        i = this.gC.gn;
        j = 4;
      }
    }
    this.gC.u(j);
  }
  
  public final int aY()
  {
    if (this.gC.go) {
      return this.gC.gu - this.gC.gm;
    }
    return this.gC.gn - this.gC.gm;
  }
  
  public final void b(View paramView, int paramInt1, int paramInt2)
  {
    this.gC.v(paramInt2);
  }
  
  public final boolean b(View paramView, int paramInt)
  {
    if (this.gC.mState == 1) {
      return false;
    }
    if (this.gC.gy) {
      return false;
    }
    if ((this.gC.mState == 3) && (this.gC.mActivePointerId == paramInt))
    {
      View localView = (View)this.gC.gv.get();
      if ((localView != null) && (localView.canScrollVertically(-1))) {
        return false;
      }
    }
    return (this.gC.mViewRef != null) && (this.gC.mViewRef.get() == paramView);
  }
  
  public final int c(View paramView, int paramInt)
  {
    int j = this.gC.gm;
    if (this.gC.go) {}
    for (int i = this.gC.gu;; i = this.gC.gn) {
      return a.clamp(paramInt, j, i);
    }
  }
  
  public final int d(View paramView, int paramInt)
  {
    return paramView.getLeft();
  }
  
  public final void w(int paramInt)
  {
    if (paramInt == 1) {
      this.gC.u(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.BottomSheetBehavior.2
 * JD-Core Version:    0.7.0.1
 */