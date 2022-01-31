package android.support.design.widget;

import android.support.v4.widget.r;
import android.support.v4.widget.r.a;
import android.view.MotionEvent;
import android.view.View;

public class n<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private final r.a fF = new n.1(this);
  r ft;
  n.a jR;
  private boolean jS;
  private float jT = 0.0F;
  private boolean jU;
  int jV = 2;
  float jW = 0.5F;
  float jX = 0.0F;
  float jY = 0.5F;
  
  static float c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  static float n(float paramFloat)
  {
    return Math.min(Math.max(0.0F, paramFloat), 1.0F);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = this.jS;
    boolean bool1 = bool3;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      bool1 = bool3;
    case 2: 
      if (bool1) {
        if (this.ft == null) {
          if (!this.jU) {
            break label142;
          }
        }
      }
      break;
    }
    label142:
    for (paramCoordinatorLayout = r.a(paramCoordinatorLayout, this.jT, this.fF);; paramCoordinatorLayout = r.a(paramCoordinatorLayout, this.fF))
    {
      this.ft = paramCoordinatorLayout;
      bool2 = this.ft.f(paramMotionEvent);
      return bool2;
      this.jS = paramCoordinatorLayout.b(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool1 = this.jS;
      break;
      this.jS = false;
      bool1 = bool3;
      break;
    }
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.ft != null)
    {
      this.ft.g(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public boolean g(View paramView)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.n
 * JD-Core Version:    0.7.0.1
 */