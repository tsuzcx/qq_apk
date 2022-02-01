package android.support.design.widget;

import android.support.v4.widget.t.a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  android.support.v4.widget.t lj;
  private final t.a lv = new t.a()
  {
    private int ls = -1;
    private int rc;
    
    public final void M(int paramAnonymousInt)
    {
      if (SwipeDismissBehavior.this.qU != null) {
        SwipeDismissBehavior.this.qU.I(paramAnonymousInt);
      }
    }
    
    public final void a(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      boolean bool = true;
      this.ls = -1;
      int j = paramAnonymousView.getWidth();
      int i;
      if (paramAnonymousFloat1 != 0.0F) {
        if (android.support.v4.view.t.Y(paramAnonymousView) == 1)
        {
          i = 1;
          if (SwipeDismissBehavior.this.qY != 2) {
            break label114;
          }
          i = 1;
          label45:
          if (i == 0) {
            break label290;
          }
          if (paramAnonymousView.getLeft() >= this.rc) {
            break label278;
          }
          i = this.rc - j;
          label70:
          if (!SwipeDismissBehavior.this.lj.A(i, paramAnonymousView.getTop())) {
            break label302;
          }
          android.support.v4.view.t.b(paramAnonymousView, new SwipeDismissBehavior.b(SwipeDismissBehavior.this, paramAnonymousView, bool));
        }
      }
      label114:
      while ((!bool) || (SwipeDismissBehavior.this.qU == null))
      {
        return;
        i = 0;
        break;
        if (SwipeDismissBehavior.this.qY == 0)
        {
          if (i != 0)
          {
            if (paramAnonymousFloat1 < 0.0F)
            {
              i = 1;
              break label45;
            }
            i = 0;
            break label45;
          }
          if (paramAnonymousFloat1 > 0.0F)
          {
            i = 1;
            break label45;
          }
          i = 0;
          break label45;
        }
        if (SwipeDismissBehavior.this.qY == 1)
        {
          if (i != 0)
          {
            if (paramAnonymousFloat1 > 0.0F)
            {
              i = 1;
              break label45;
            }
            i = 0;
            break label45;
          }
          if (paramAnonymousFloat1 < 0.0F)
          {
            i = 1;
            break label45;
          }
          i = 0;
          break label45;
          i = paramAnonymousView.getLeft();
          int k = this.rc;
          int m = Math.round(paramAnonymousView.getWidth() * SwipeDismissBehavior.this.qZ);
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
        i = this.rc + j;
        break label70;
        i = this.rc;
        bool = false;
        break label70;
      }
      label278:
      label290:
      label302:
      SwipeDismissBehavior.this.qU.onDismiss(paramAnonymousView);
    }
    
    public final void b(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      float f1 = this.rc + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.ra;
      float f2 = this.rc + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.rb;
      if (paramAnonymousInt1 <= f1)
      {
        paramAnonymousView.setAlpha(1.0F);
        return;
      }
      if (paramAnonymousInt1 >= f2)
      {
        paramAnonymousView.setAlpha(0.0F);
        return;
      }
      paramAnonymousView.setAlpha(SwipeDismissBehavior.s(1.0F - SwipeDismissBehavior.e(f1, f2, paramAnonymousInt1)));
    }
    
    public final boolean c(View paramAnonymousView, int paramAnonymousInt)
    {
      return (this.ls == -1) && (SwipeDismissBehavior.this.j(paramAnonymousView));
    }
    
    public final int d(View paramAnonymousView, int paramAnonymousInt)
    {
      return paramAnonymousView.getTop();
    }
    
    public final int e(View paramAnonymousView, int paramAnonymousInt)
    {
      int i;
      int j;
      if (android.support.v4.view.t.Y(paramAnonymousView) == 1)
      {
        i = 1;
        if (SwipeDismissBehavior.this.qY != 0) {
          break label72;
        }
        if (i == 0) {
          break label53;
        }
        i = this.rc - paramAnonymousView.getWidth();
        j = this.rc;
      }
      for (;;)
      {
        return SwipeDismissBehavior.clamp(i, paramAnonymousInt, j);
        i = 0;
        break;
        label53:
        i = this.rc;
        j = this.rc + paramAnonymousView.getWidth();
        continue;
        label72:
        if (SwipeDismissBehavior.this.qY == 1)
        {
          if (i != 0)
          {
            i = this.rc;
            j = this.rc + paramAnonymousView.getWidth();
          }
          else
          {
            i = this.rc - paramAnonymousView.getWidth();
            j = this.rc;
          }
        }
        else
        {
          i = this.rc - paramAnonymousView.getWidth();
          j = this.rc + paramAnonymousView.getWidth();
        }
      }
    }
    
    public final void l(View paramAnonymousView, int paramAnonymousInt)
    {
      this.ls = paramAnonymousInt;
      this.rc = paramAnonymousView.getLeft();
      paramAnonymousView = paramAnonymousView.getParent();
      if (paramAnonymousView != null) {
        paramAnonymousView.requestDisallowInterceptTouchEvent(true);
      }
    }
    
    public final int x(View paramAnonymousView)
    {
      return paramAnonymousView.getWidth();
    }
  };
  a qU;
  private boolean qV;
  private float qW = 0.0F;
  private boolean qX;
  int qY = 2;
  float qZ = 0.5F;
  float ra = 0.0F;
  float rb = 0.5F;
  
  static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  static float e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  static float s(float paramFloat)
  {
    return Math.min(Math.max(0.0F, paramFloat), 1.0F);
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.lj != null)
    {
      this.lj.h(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = this.qV;
    boolean bool1 = bool3;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      bool1 = bool3;
    case 2: 
      if (bool1) {
        if (this.lj == null) {
          if (!this.qX) {
            break label142;
          }
        }
      }
      break;
    }
    label142:
    for (paramCoordinatorLayout = android.support.v4.widget.t.a(paramCoordinatorLayout, this.qW, this.lv);; paramCoordinatorLayout = android.support.v4.widget.t.a(paramCoordinatorLayout, this.lv))
    {
      this.lj = paramCoordinatorLayout;
      bool2 = this.lj.g(paramMotionEvent);
      return bool2;
      this.qV = paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool1 = this.qV;
      break;
      this.qV = false;
      bool1 = bool3;
      break;
    }
  }
  
  public boolean j(View paramView)
  {
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void I(int paramInt);
    
    public abstract void onDismiss(View paramView);
  }
  
  final class b
    implements Runnable
  {
    private final boolean re;
    private final View view;
    
    b(View paramView, boolean paramBoolean)
    {
      this.view = paramView;
      this.re = paramBoolean;
    }
    
    public final void run()
    {
      if ((SwipeDismissBehavior.this.lj != null) && (SwipeDismissBehavior.this.lj.fH())) {
        android.support.v4.view.t.b(this.view, this);
      }
      while ((!this.re) || (SwipeDismissBehavior.this.qU == null)) {
        return;
      }
      SwipeDismissBehavior.this.qU.onDismiss(this.view);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.SwipeDismissBehavior
 * JD-Core Version:    0.7.0.1
 */