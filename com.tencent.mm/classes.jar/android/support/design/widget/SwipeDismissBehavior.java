package android.support.design.widget;

import android.support.v4.widget.t.a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  android.support.v4.widget.t mi;
  private final t.a mu = new t.a()
  {
    private int mr = -1;
    private int sd;
    
    public final void M(int paramAnonymousInt)
    {
      if (SwipeDismissBehavior.this.rU != null) {
        SwipeDismissBehavior.this.rU.I(paramAnonymousInt);
      }
    }
    
    public final void a(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      boolean bool = true;
      this.mr = -1;
      int j = paramAnonymousView.getWidth();
      int i;
      if (paramAnonymousFloat1 != 0.0F) {
        if (android.support.v4.view.t.Y(paramAnonymousView) == 1)
        {
          i = 1;
          if (SwipeDismissBehavior.this.rY != 2) {
            break label114;
          }
          i = 1;
          label45:
          if (i == 0) {
            break label290;
          }
          if (paramAnonymousView.getLeft() >= this.sd) {
            break label278;
          }
          i = this.sd - j;
          label70:
          if (!SwipeDismissBehavior.this.mi.A(i, paramAnonymousView.getTop())) {
            break label302;
          }
          android.support.v4.view.t.b(paramAnonymousView, new SwipeDismissBehavior.b(SwipeDismissBehavior.this, paramAnonymousView, bool));
        }
      }
      label114:
      while ((!bool) || (SwipeDismissBehavior.this.rU == null))
      {
        return;
        i = 0;
        break;
        if (SwipeDismissBehavior.this.rY == 0)
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
        if (SwipeDismissBehavior.this.rY == 1)
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
          int k = this.sd;
          int m = Math.round(paramAnonymousView.getWidth() * SwipeDismissBehavior.this.rZ);
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
        i = this.sd + j;
        break label70;
        i = this.sd;
        bool = false;
        break label70;
      }
      label278:
      label290:
      label302:
      SwipeDismissBehavior.this.rU.onDismiss(paramAnonymousView);
    }
    
    public final void b(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      float f1 = this.sd + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.sa;
      float f2 = this.sd + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.sc;
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
      paramAnonymousView.setAlpha(SwipeDismissBehavior.w(1.0F - SwipeDismissBehavior.d(f1, f2, paramAnonymousInt1)));
    }
    
    public final boolean c(View paramAnonymousView, int paramAnonymousInt)
    {
      return (this.mr == -1) && (SwipeDismissBehavior.this.j(paramAnonymousView));
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
        if (SwipeDismissBehavior.this.rY != 0) {
          break label72;
        }
        if (i == 0) {
          break label53;
        }
        i = this.sd - paramAnonymousView.getWidth();
        j = this.sd;
      }
      for (;;)
      {
        return SwipeDismissBehavior.clamp(i, paramAnonymousInt, j);
        i = 0;
        break;
        label53:
        i = this.sd;
        j = this.sd + paramAnonymousView.getWidth();
        continue;
        label72:
        if (SwipeDismissBehavior.this.rY == 1)
        {
          if (i != 0)
          {
            i = this.sd;
            j = this.sd + paramAnonymousView.getWidth();
          }
          else
          {
            i = this.sd - paramAnonymousView.getWidth();
            j = this.sd;
          }
        }
        else
        {
          i = this.sd - paramAnonymousView.getWidth();
          j = this.sd + paramAnonymousView.getWidth();
        }
      }
    }
    
    public final void l(View paramAnonymousView, int paramAnonymousInt)
    {
      this.mr = paramAnonymousInt;
      this.sd = paramAnonymousView.getLeft();
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
  a rU;
  private boolean rV;
  private float rW = 0.0F;
  private boolean rX;
  int rY = 2;
  float rZ = 0.5F;
  float sa = 0.0F;
  float sc = 0.5F;
  
  static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  static float d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  static float w(float paramFloat)
  {
    return Math.min(Math.max(0.0F, paramFloat), 1.0F);
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.mi != null)
    {
      this.mi.h(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = this.rV;
    boolean bool1 = bool3;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      bool1 = bool3;
    case 2: 
      if (bool1) {
        if (this.mi == null) {
          if (!this.rX) {
            break label142;
          }
        }
      }
      break;
    }
    label142:
    for (paramCoordinatorLayout = android.support.v4.widget.t.a(paramCoordinatorLayout, this.rW, this.mu);; paramCoordinatorLayout = android.support.v4.widget.t.a(paramCoordinatorLayout, this.mu))
    {
      this.mi = paramCoordinatorLayout;
      bool2 = this.mi.g(paramMotionEvent);
      return bool2;
      this.rV = paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool1 = this.rV;
      break;
      this.rV = false;
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
    private final boolean sf;
    private final View view;
    
    b(View paramView, boolean paramBoolean)
    {
      this.view = paramView;
      this.sf = paramBoolean;
    }
    
    public final void run()
    {
      if ((SwipeDismissBehavior.this.mi != null) && (SwipeDismissBehavior.this.mi.fP())) {
        android.support.v4.view.t.b(this.view, this);
      }
      while ((!this.sf) || (SwipeDismissBehavior.this.rU == null)) {
        return;
      }
      SwipeDismissBehavior.this.rU.onDismiss(this.view);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.SwipeDismissBehavior
 * JD-Core Version:    0.7.0.1
 */