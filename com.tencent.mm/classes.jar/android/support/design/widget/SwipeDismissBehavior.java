package android.support.design.widget;

import android.support.v4.view.u;
import android.support.v4.widget.t;
import android.support.v4.widget.t.a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  t od;
  private final t.a or = new t.a()
  {
    private int om = -1;
    private int uc;
    
    public final void L(int paramAnonymousInt)
    {
      if (SwipeDismissBehavior.this.tU != null) {
        SwipeDismissBehavior.this.tU.I(paramAnonymousInt);
      }
    }
    
    public final void a(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      boolean bool = true;
      this.om = -1;
      int j = paramAnonymousView.getWidth();
      int i;
      if (paramAnonymousFloat1 != 0.0F) {
        if (u.Z(paramAnonymousView) == 1)
        {
          i = 1;
          if (SwipeDismissBehavior.this.tY != 2) {
            break label114;
          }
          i = 1;
          label45:
          if (i == 0) {
            break label290;
          }
          if (paramAnonymousView.getLeft() >= this.uc) {
            break label278;
          }
          i = this.uc - j;
          label70:
          if (!SwipeDismissBehavior.this.od.H(i, paramAnonymousView.getTop())) {
            break label302;
          }
          u.b(paramAnonymousView, new SwipeDismissBehavior.b(SwipeDismissBehavior.this, paramAnonymousView, bool));
        }
      }
      label114:
      while ((!bool) || (SwipeDismissBehavior.this.tU == null))
      {
        return;
        i = 0;
        break;
        if (SwipeDismissBehavior.this.tY == 0)
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
        if (SwipeDismissBehavior.this.tY == 1)
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
          int k = this.uc;
          int m = Math.round(paramAnonymousView.getWidth() * SwipeDismissBehavior.this.tZ);
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
        i = this.uc + j;
        break label70;
        i = this.uc;
        bool = false;
        break label70;
      }
      label278:
      label290:
      label302:
      SwipeDismissBehavior.this.tU.onDismiss(paramAnonymousView);
    }
    
    public final void b(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      float f1 = this.uc + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.ua;
      float f2 = this.uc + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.ub;
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
      paramAnonymousView.setAlpha(SwipeDismissBehavior.u(1.0F - SwipeDismissBehavior.d(f1, f2, paramAnonymousInt1)));
    }
    
    public final boolean c(View paramAnonymousView, int paramAnonymousInt)
    {
      return (this.om == -1) && (SwipeDismissBehavior.this.j(paramAnonymousView));
    }
    
    public final int d(View paramAnonymousView, int paramAnonymousInt)
    {
      return paramAnonymousView.getTop();
    }
    
    public final int e(View paramAnonymousView, int paramAnonymousInt)
    {
      int i;
      int j;
      if (u.Z(paramAnonymousView) == 1)
      {
        i = 1;
        if (SwipeDismissBehavior.this.tY != 0) {
          break label72;
        }
        if (i == 0) {
          break label53;
        }
        i = this.uc - paramAnonymousView.getWidth();
        j = this.uc;
      }
      for (;;)
      {
        return SwipeDismissBehavior.clamp(i, paramAnonymousInt, j);
        i = 0;
        break;
        label53:
        i = this.uc;
        j = this.uc + paramAnonymousView.getWidth();
        continue;
        label72:
        if (SwipeDismissBehavior.this.tY == 1)
        {
          if (i != 0)
          {
            i = this.uc;
            j = this.uc + paramAnonymousView.getWidth();
          }
          else
          {
            i = this.uc - paramAnonymousView.getWidth();
            j = this.uc;
          }
        }
        else
        {
          i = this.uc - paramAnonymousView.getWidth();
          j = this.uc + paramAnonymousView.getWidth();
        }
      }
    }
    
    public final void l(View paramAnonymousView, int paramAnonymousInt)
    {
      this.om = paramAnonymousInt;
      this.uc = paramAnonymousView.getLeft();
      paramAnonymousView = paramAnonymousView.getParent();
      if (paramAnonymousView != null) {
        paramAnonymousView.requestDisallowInterceptTouchEvent(true);
      }
    }
    
    public final int y(View paramAnonymousView)
    {
      return paramAnonymousView.getWidth();
    }
  };
  a tU;
  private boolean tV;
  private float tW = 0.0F;
  private boolean tX;
  int tY = 2;
  float tZ = 0.5F;
  float ua = 0.0F;
  float ub = 0.5F;
  
  static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  static float d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  static float u(float paramFloat)
  {
    return Math.min(Math.max(0.0F, paramFloat), 1.0F);
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.od != null)
    {
      this.od.k(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = this.tV;
    boolean bool1 = bool3;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      bool1 = bool3;
    case 2: 
      if (bool1) {
        if (this.od == null) {
          if (!this.tX) {
            break label142;
          }
        }
      }
      break;
    }
    label142:
    for (paramCoordinatorLayout = t.a(paramCoordinatorLayout, this.tW, this.or);; paramCoordinatorLayout = t.a(paramCoordinatorLayout, this.or))
    {
      this.od = paramCoordinatorLayout;
      bool2 = this.od.j(paramMotionEvent);
      return bool2;
      this.tV = paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool1 = this.tV;
      break;
      this.tV = false;
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
    private final boolean ue;
    private final View view;
    
    b(View paramView, boolean paramBoolean)
    {
      this.view = paramView;
      this.ue = paramBoolean;
    }
    
    public final void run()
    {
      if ((SwipeDismissBehavior.this.od != null) && (SwipeDismissBehavior.this.od.go())) {
        u.b(this.view, this);
      }
      while ((!this.ue) || (SwipeDismissBehavior.this.tU == null)) {
        return;
      }
      SwipeDismissBehavior.this.tU.onDismiss(this.view);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.design.widget.SwipeDismissBehavior
 * JD-Core Version:    0.7.0.1
 */