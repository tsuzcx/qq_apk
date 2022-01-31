package android.support.design.widget;

import android.support.v4.widget.t;
import android.support.v4.widget.t.a;
import android.view.MotionEvent;
import android.view.View;

public class SwipeDismissBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  t gq;
  private final t.a gz = new SwipeDismissBehavior.1(this);
  SwipeDismissBehavior.a kP;
  private boolean kQ;
  private float kR = 0.0F;
  private boolean kS;
  int kT = 2;
  float kU = 0.5F;
  float kV = 0.0F;
  float kW = 0.5F;
  
  static float c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  static float o(float paramFloat)
  {
    return Math.min(Math.max(0.0F, paramFloat), 1.0F);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = this.kQ;
    boolean bool1 = bool3;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      bool1 = bool3;
    case 2: 
      if (bool1) {
        if (this.gq == null) {
          if (!this.kS) {
            break label142;
          }
        }
      }
      break;
    }
    label142:
    for (paramCoordinatorLayout = t.a(paramCoordinatorLayout, this.kR, this.gz);; paramCoordinatorLayout = t.a(paramCoordinatorLayout, this.gz))
    {
      this.gq = paramCoordinatorLayout;
      bool2 = this.gq.f(paramMotionEvent);
      return bool2;
      this.kQ = paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool1 = this.kQ;
      break;
      this.kQ = false;
      bool1 = bool3;
      break;
    }
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.gq != null)
    {
      this.gq.g(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public boolean g(View paramView)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.SwipeDismissBehavior
 * JD-Core Version:    0.7.0.1
 */