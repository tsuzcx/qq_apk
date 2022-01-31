package android.support.design.widget;

import android.content.Context;
import android.support.v4.b.a;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

abstract class HeaderBehavior<V extends View>
  extends ViewOffsetBehavior<V>
{
  private Runnable jQ;
  OverScroller jR;
  private int jS;
  private int mActivePointerId = -1;
  private boolean mIsBeingDragged;
  private int mTouchSlop = -1;
  private VelocityTracker mVelocityTracker;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void bB()
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  int a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = aO();
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
            p(paramInt1);
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
    if (this.mTouchSlop < 0) {
      this.mTouchSlop = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    if ((paramMotionEvent.getAction() == 2) && (this.mIsBeingDragged)) {
      return true;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      if (this.mVelocityTracker != null) {
        this.mVelocityTracker.addMovement(paramMotionEvent);
      }
      return this.mIsBeingDragged;
      this.mIsBeingDragged = false;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((aN()) && (paramCoordinatorLayout.d(paramV, i, j)))
      {
        this.jS = j;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        bB();
        continue;
        i = this.mActivePointerId;
        if (i != -1)
        {
          i = paramMotionEvent.findPointerIndex(i);
          if (i != -1)
          {
            i = (int)paramMotionEvent.getY(i);
            if (Math.abs(i - this.jS) > this.mTouchSlop)
            {
              this.mIsBeingDragged = true;
              this.jS = i;
              continue;
              this.mIsBeingDragged = false;
              this.mActivePointerId = -1;
              if (this.mVelocityTracker != null)
              {
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
              }
            }
          }
        }
      }
    }
  }
  
  int aM()
  {
    return aO();
  }
  
  boolean aN()
  {
    return false;
  }
  
  final int b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramCoordinatorLayout, paramV, aM() - paramInt1, paramInt2, paramInt3);
  }
  
  int b(V paramV)
  {
    return paramV.getHeight();
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.mTouchSlop < 0) {
      this.mTouchSlop = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    int i;
    int j;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
      for (;;)
      {
        if (this.mVelocityTracker != null) {
          this.mVelocityTracker.addMovement(paramMotionEvent);
        }
        return true;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if ((!paramCoordinatorLayout.d(paramV, i, j)) || (!aN())) {
          break;
        }
        this.jS = j;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        bB();
      }
      return false;
    case 2: 
      i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      if (i == -1) {
        return false;
      }
      int k = (int)paramMotionEvent.getY(i);
      j = this.jS - k;
      i = j;
      if (!this.mIsBeingDragged)
      {
        i = j;
        if (Math.abs(j) > this.mTouchSlop)
        {
          this.mIsBeingDragged = true;
          if (j <= 0) {
            break label243;
          }
        }
      }
      for (i = j - this.mTouchSlop; this.mIsBeingDragged; i = j + this.mTouchSlop)
      {
        this.jS = k;
        b(paramCoordinatorLayout, paramV, i, c(paramV), 0);
        break;
      }
    case 1: 
      label243:
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.addMovement(paramMotionEvent);
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float f = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        i = -b(paramV);
        if (this.jQ != null)
        {
          paramV.removeCallbacks(this.jQ);
          this.jQ = null;
        }
        if (this.jR == null) {
          this.jR = new OverScroller(paramV.getContext());
        }
        this.jR.fling(0, aO(), 0, Math.round(f), 0, 0, i, 0);
        if (!this.jR.computeScrollOffset()) {
          break label431;
        }
        this.jQ = new HeaderBehavior.a(this, paramCoordinatorLayout, paramV);
        t.b(paramV, this.jQ);
      }
      break;
    }
    for (;;)
    {
      this.mIsBeingDragged = false;
      this.mActivePointerId = -1;
      if (this.mVelocityTracker == null) {
        break;
      }
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.HeaderBehavior
 * JD-Core Version:    0.7.0.1
 */