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

public abstract class HeaderBehavior<V extends View>
  extends ViewOffsetBehavior<V>
{
  private VelocityTracker mq;
  private int mr = -1;
  private Runnable pY;
  OverScroller pZ;
  private boolean qa;
  private int qb;
  private int qc = -1;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void cv()
  {
    if (this.mq == null) {
      this.mq = VelocityTracker.obtain();
    }
  }
  
  int a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = bC();
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
            G(paramInt1);
            i = k - paramInt1;
          }
        }
      }
    }
    return i;
  }
  
  void a(CoordinatorLayout paramCoordinatorLayout, V paramV) {}
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.qc < 0) {
      this.qc = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    int i;
    int j;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
      for (;;)
      {
        if (this.mq != null) {
          this.mq.addMovement(paramMotionEvent);
        }
        return true;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if ((!paramCoordinatorLayout.d(paramV, i, j)) || (!bA())) {
          break;
        }
        this.qb = j;
        this.mr = paramMotionEvent.getPointerId(0);
        cv();
      }
      return false;
    case 2: 
      i = paramMotionEvent.findPointerIndex(this.mr);
      if (i == -1) {
        return false;
      }
      int k = (int)paramMotionEvent.getY(i);
      j = this.qb - k;
      i = j;
      if (!this.qa)
      {
        i = j;
        if (Math.abs(j) > this.qc)
        {
          this.qa = true;
          if (j <= 0) {
            break label243;
          }
        }
      }
      for (i = j - this.qc; this.qa; i = j + this.qc)
      {
        this.qb = k;
        b(paramCoordinatorLayout, paramV, i, g(paramV), 0);
        break;
      }
    case 1: 
      label243:
      if (this.mq != null)
      {
        this.mq.addMovement(paramMotionEvent);
        this.mq.computeCurrentVelocity(1000);
        float f = this.mq.getYVelocity(this.mr);
        i = -f(paramV);
        if (this.pY != null)
        {
          paramV.removeCallbacks(this.pY);
          this.pY = null;
        }
        if (this.pZ == null) {
          this.pZ = new OverScroller(paramV.getContext());
        }
        this.pZ.fling(0, bC(), 0, Math.round(f), 0, 0, i, 0);
        if (!this.pZ.computeScrollOffset()) {
          break label431;
        }
        this.pY = new a(paramCoordinatorLayout, paramV);
        t.b(paramV, this.pY);
      }
      break;
    }
    for (;;)
    {
      this.qa = false;
      this.mr = -1;
      if (this.mq == null) {
        break;
      }
      this.mq.recycle();
      this.mq = null;
      break;
      label431:
      a(paramCoordinatorLayout, paramV);
    }
  }
  
  final int b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return a(paramCoordinatorLayout, paramV, paramInt, -2147483648, 2147483647);
  }
  
  final int b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramCoordinatorLayout, paramV, bz() - paramInt1, paramInt2, paramInt3);
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.qc < 0) {
      this.qc = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    if ((paramMotionEvent.getAction() == 2) && (this.qa)) {
      return true;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      if (this.mq != null) {
        this.mq.addMovement(paramMotionEvent);
      }
      return this.qa;
      this.qa = false;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((bA()) && (paramCoordinatorLayout.d(paramV, i, j)))
      {
        this.qb = j;
        this.mr = paramMotionEvent.getPointerId(0);
        cv();
        continue;
        i = this.mr;
        if (i != -1)
        {
          i = paramMotionEvent.findPointerIndex(i);
          if (i != -1)
          {
            i = (int)paramMotionEvent.getY(i);
            if (Math.abs(i - this.qb) > this.qc)
            {
              this.qa = true;
              this.qb = i;
              continue;
              this.qa = false;
              this.mr = -1;
              if (this.mq != null)
              {
                this.mq.recycle();
                this.mq = null;
              }
            }
          }
        }
      }
    }
  }
  
  boolean bA()
  {
    return false;
  }
  
  int bz()
  {
    return bC();
  }
  
  int f(V paramV)
  {
    return paramV.getHeight();
  }
  
  int g(V paramV)
  {
    return -paramV.getHeight();
  }
  
  final class a
    implements Runnable
  {
    private final CoordinatorLayout qd;
    private final V qe;
    
    a(V paramV)
    {
      this.qd = paramV;
      Object localObject;
      this.qe = localObject;
    }
    
    public final void run()
    {
      if ((this.qe != null) && (HeaderBehavior.this.pZ != null))
      {
        if (HeaderBehavior.this.pZ.computeScrollOffset())
        {
          HeaderBehavior.this.b(this.qd, this.qe, HeaderBehavior.this.pZ.getCurrY());
          t.b(this.qe, this);
        }
      }
      else {
        return;
      }
      HeaderBehavior.this.a(this.qd, this.qe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.HeaderBehavior
 * JD-Core Version:    0.7.0.1
 */