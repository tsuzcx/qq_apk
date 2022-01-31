package android.support.design.widget;

import android.support.v4.b.a;
import android.support.v4.widget.t.a;
import android.view.View;
import java.lang.ref.WeakReference;

final class MMBottomSheetBehavior$2
  extends t.a
{
  MMBottomSheetBehavior$2(MMBottomSheetBehavior paramMMBottomSheetBehavior) {}
  
  public final void a(View paramView, float paramFloat1, float paramFloat2)
  {
    int j = 3;
    int i;
    if (paramFloat2 < 0.0F) {
      i = this.kg.gm;
    }
    while (this.kg.gq.y(paramView.getLeft(), i))
    {
      this.kg.u(2);
      android.support.v4.view.t.b(paramView, new MMBottomSheetBehavior.c(this.kg, paramView, j));
      return;
      if ((this.kg.go) && (this.kg.a(paramView, paramFloat2)))
      {
        i = this.kg.gu;
        j = 5;
      }
      else if (paramFloat2 == 0.0F)
      {
        i = paramView.getTop();
        if (Math.abs(i - this.kg.gm) < Math.abs(i - this.kg.gn))
        {
          i = this.kg.gm;
        }
        else
        {
          i = this.kg.gn;
          j = 4;
        }
      }
      else
      {
        i = this.kg.gn;
        j = 4;
      }
    }
    this.kg.u(j);
  }
  
  public final int aY()
  {
    if (this.kg.go) {
      return this.kg.gu - this.kg.gm;
    }
    return this.kg.gn - this.kg.gm;
  }
  
  public final void b(View paramView, int paramInt1, int paramInt2)
  {
    this.kg.v(paramInt2);
  }
  
  public final boolean b(View paramView, int paramInt)
  {
    if (this.kg.mState == 1) {
      return false;
    }
    if (this.kg.gy) {
      return false;
    }
    if ((this.kg.mState == 3) && (this.kg.mActivePointerId == paramInt))
    {
      View localView = (View)this.kg.gv.get();
      if ((localView != null) && (localView.canScrollVertically(-1))) {
        return false;
      }
    }
    return (this.kg.mViewRef != null) && (this.kg.mViewRef.get() == paramView);
  }
  
  public final int c(View paramView, int paramInt)
  {
    int j = this.kg.gm;
    if (this.kg.go) {}
    for (int i = this.kg.gu;; i = this.kg.gn) {
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
      this.kg.u(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.widget.MMBottomSheetBehavior.2
 * JD-Core Version:    0.7.0.1
 */