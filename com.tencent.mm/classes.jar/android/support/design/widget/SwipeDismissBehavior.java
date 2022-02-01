package android.support.design.widget;

import android.support.v4.widget.t.a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  android.support.v4.widget.t ob;
  private final t.a oo = new t.a()
  {
    private int ok = -1;
    private int tV;
    
    public final void L(int paramAnonymousInt)
    {
      if (SwipeDismissBehavior.this.tN != null) {
        SwipeDismissBehavior.this.tN.I(paramAnonymousInt);
      }
    }
    
    public final void a(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      boolean bool = true;
      this.ok = -1;
      int j = paramAnonymousView.getWidth();
      int i;
      if (paramAnonymousFloat1 != 0.0F) {
        if (android.support.v4.view.t.Y(paramAnonymousView) == 1)
        {
          i = 1;
          if (SwipeDismissBehavior.this.tR != 2) {
            break label114;
          }
          i = 1;
          label45:
          if (i == 0) {
            break label290;
          }
          if (paramAnonymousView.getLeft() >= this.tV) {
            break label278;
          }
          i = this.tV - j;
          label70:
          if (!SwipeDismissBehavior.this.ob.H(i, paramAnonymousView.getTop())) {
            break label302;
          }
          android.support.v4.view.t.b(paramAnonymousView, new SwipeDismissBehavior.b(SwipeDismissBehavior.this, paramAnonymousView, bool));
        }
      }
      label114:
      while ((!bool) || (SwipeDismissBehavior.this.tN == null))
      {
        return;
        i = 0;
        break;
        if (SwipeDismissBehavior.this.tR == 0)
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
        if (SwipeDismissBehavior.this.tR == 1)
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
          int k = this.tV;
          int m = Math.round(paramAnonymousView.getWidth() * SwipeDismissBehavior.this.tS);
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
        i = this.tV + j;
        break label70;
        i = this.tV;
        bool = false;
        break label70;
      }
      label278:
      label290:
      label302:
      SwipeDismissBehavior.this.tN.onDismiss(paramAnonymousView);
    }
    
    public final void b(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      float f1 = this.tV + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.tT;
      float f2 = this.tV + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.tU;
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
      return (this.ok == -1) && (SwipeDismissBehavior.this.j(paramAnonymousView));
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
        if (SwipeDismissBehavior.this.tR != 0) {
          break label72;
        }
        if (i == 0) {
          break label53;
        }
        i = this.tV - paramAnonymousView.getWidth();
        j = this.tV;
      }
      for (;;)
      {
        return SwipeDismissBehavior.clamp(i, paramAnonymousInt, j);
        i = 0;
        break;
        label53:
        i = this.tV;
        j = this.tV + paramAnonymousView.getWidth();
        continue;
        label72:
        if (SwipeDismissBehavior.this.tR == 1)
        {
          if (i != 0)
          {
            i = this.tV;
            j = this.tV + paramAnonymousView.getWidth();
          }
          else
          {
            i = this.tV - paramAnonymousView.getWidth();
            j = this.tV;
          }
        }
        else
        {
          i = this.tV - paramAnonymousView.getWidth();
          j = this.tV + paramAnonymousView.getWidth();
        }
      }
    }
    
    public final void l(View paramAnonymousView, int paramAnonymousInt)
    {
      this.ok = paramAnonymousInt;
      this.tV = paramAnonymousView.getLeft();
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
  a tN;
  private boolean tO;
  private float tP = 0.0F;
  private boolean tQ;
  int tR = 2;
  float tS = 0.5F;
  float tT = 0.0F;
  float tU = 0.5F;
  
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
    if (this.ob != null)
    {
      this.ob.h(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = this.tO;
    boolean bool1 = bool3;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      bool1 = bool3;
    case 2: 
      if (bool1) {
        if (this.ob == null) {
          if (!this.tQ) {
            break label142;
          }
        }
      }
      break;
    }
    label142:
    for (paramCoordinatorLayout = android.support.v4.widget.t.a(paramCoordinatorLayout, this.tP, this.oo);; paramCoordinatorLayout = android.support.v4.widget.t.a(paramCoordinatorLayout, this.oo))
    {
      this.ob = paramCoordinatorLayout;
      bool2 = this.ob.g(paramMotionEvent);
      return bool2;
      this.tO = paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool1 = this.tO;
      break;
      this.tO = false;
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
    private final boolean tX;
    private final View view;
    
    b(View paramView, boolean paramBoolean)
    {
      this.view = paramView;
      this.tX = paramBoolean;
    }
    
    public final void run()
    {
      if ((SwipeDismissBehavior.this.ob != null) && (SwipeDismissBehavior.this.ob.gh())) {
        android.support.v4.view.t.b(this.view, this);
      }
      while ((!this.tX) || (SwipeDismissBehavior.this.tN == null)) {
        return;
      }
      SwipeDismissBehavior.this.tN.onDismiss(this.view);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.SwipeDismissBehavior
 * JD-Core Version:    0.7.0.1
 */