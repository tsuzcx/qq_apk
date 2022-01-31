package android.support.design.widget;

import android.content.Context;
import android.support.v4.c.a;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

abstract class HeaderBehavior<V extends View>
  extends ViewOffsetBehavior<V>
{
  private VelocityTracker fB;
  private int fC = -1;
  private Runnable iX;
  OverScroller iY;
  private boolean iZ;
  private int ja;
  private int jb = -1;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void aS()
  {
    if (this.fB == null) {
      this.fB = VelocityTracker.obtain();
    }
  }
  
  int a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = ag();
    int j = 0;
    int i = j;
    if (paramInt2 != 0)
    {
      i = j;
      if (k >= paramInt2)
      {
        i = j;
        if (k <= paramInt3)
        {
          paramInt1 = a.clamp(paramInt1, paramInt2, paramInt3);
          i = j;
          if (k != paramInt1)
          {
            q(paramInt1);
            i = k - paramInt1;
          }
        }
      }
    }
    return i;
  }
  
  void a(CoordinatorLayout paramCoordinatorLayout, V paramV) {}
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.jb < 0) {
      this.jb = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    if ((paramMotionEvent.getAction() == 2) && (this.iZ)) {
      return true;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      if (this.fB != null) {
        this.fB.addMovement(paramMotionEvent);
      }
      return this.iZ;
      this.iZ = false;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((af()) && (paramCoordinatorLayout.b(paramV, i, j)))
      {
        this.ja = j;
        this.fC = paramMotionEvent.getPointerId(0);
        aS();
        continue;
        i = this.fC;
        if (i != -1)
        {
          i = paramMotionEvent.findPointerIndex(i);
          if (i != -1)
          {
            i = (int)paramMotionEvent.getY(i);
            if (Math.abs(i - this.ja) > this.jb)
            {
              this.iZ = true;
              this.ja = i;
              continue;
              this.iZ = false;
              this.fC = -1;
              if (this.fB != null)
              {
                this.fB.recycle();
                this.fB = null;
              }
            }
          }
        }
      }
    }
  }
  
  int ad()
  {
    return ag();
  }
  
  boolean af()
  {
    return false;
  }
  
  final int b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramCoordinatorLayout, paramV, ad() - paramInt1, paramInt2, paramInt3);
  }
  
  int b(V paramV)
  {
    return paramV.getHeight();
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.jb < 0) {
      this.jb = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    int i;
    int j;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
      for (;;)
      {
        if (this.fB != null) {
          this.fB.addMovement(paramMotionEvent);
        }
        return true;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if ((!paramCoordinatorLayout.b(paramV, i, j)) || (!af())) {
          break;
        }
        this.ja = j;
        this.fC = paramMotionEvent.getPointerId(0);
        aS();
      }
      return false;
    case 2: 
      i = paramMotionEvent.findPointerIndex(this.fC);
      if (i == -1) {
        return false;
      }
      int k = (int)paramMotionEvent.getY(i);
      j = this.ja - k;
      i = j;
      if (!this.iZ)
      {
        i = j;
        if (Math.abs(j) > this.jb)
        {
          this.iZ = true;
          if (j <= 0) {
            break label243;
          }
        }
      }
      for (i = j - this.jb; this.iZ; i = j + this.jb)
      {
        this.ja = k;
        b(paramCoordinatorLayout, paramV, i, c(paramV), 0);
        break;
      }
    case 1: 
      label243:
      if (this.fB != null)
      {
        this.fB.addMovement(paramMotionEvent);
        this.fB.computeCurrentVelocity(1000);
        float f = this.fB.getYVelocity(this.fC);
        i = -b(paramV);
        if (this.iX != null)
        {
          paramV.removeCallbacks(this.iX);
          this.iX = null;
        }
        if (this.iY == null) {
          this.iY = new OverScroller(paramV.getContext());
        }
        this.iY.fling(0, ag(), 0, Math.round(f), 0, 0, i, 0);
        if (!this.iY.computeScrollOffset()) {
          break label431;
        }
        this.iX = new HeaderBehavior.a(this, paramCoordinatorLayout, paramV);
        q.b(paramV, this.iX);
      }
      break;
    }
    for (;;)
    {
      this.iZ = false;
      this.fC = -1;
      if (this.fB == null) {
        break;
      }
      this.fB.recycle();
      this.fB = null;
      break;
      label431:
      a(paramCoordinatorLayout, paramV);
    }
  }
  
  final int c(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return a(paramCoordinatorLayout, paramV, paramInt, -2147483648, 2147483647);
  }
  
  int c(V paramV)
  {
    return -paramV.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.HeaderBehavior
 * JD-Core Version:    0.7.0.1
 */