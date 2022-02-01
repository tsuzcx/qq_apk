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
  private VelocityTracker oj;
  private int ok = -1;
  private Runnable rS;
  OverScroller rT;
  private boolean rU;
  private int rV;
  private int rW = -1;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void cL()
  {
    if (this.oj == null) {
      this.oj = VelocityTracker.obtain();
    }
  }
  
  int a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = bR();
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
    if (this.rW < 0) {
      this.rW = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    int i;
    int j;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
      for (;;)
      {
        if (this.oj != null) {
          this.oj.addMovement(paramMotionEvent);
        }
        return true;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if ((!paramCoordinatorLayout.d(paramV, i, j)) || (!bP())) {
          break;
        }
        this.rV = j;
        this.ok = paramMotionEvent.getPointerId(0);
        cL();
      }
      return false;
    case 2: 
      i = paramMotionEvent.findPointerIndex(this.ok);
      if (i == -1) {
        return false;
      }
      int k = (int)paramMotionEvent.getY(i);
      j = this.rV - k;
      i = j;
      if (!this.rU)
      {
        i = j;
        if (Math.abs(j) > this.rW)
        {
          this.rU = true;
          if (j <= 0) {
            break label243;
          }
        }
      }
      for (i = j - this.rW; this.rU; i = j + this.rW)
      {
        this.rV = k;
        b(paramCoordinatorLayout, paramV, i, g(paramV), 0);
        break;
      }
    case 1: 
      label243:
      if (this.oj != null)
      {
        this.oj.addMovement(paramMotionEvent);
        this.oj.computeCurrentVelocity(1000);
        float f = this.oj.getYVelocity(this.ok);
        i = -f(paramV);
        if (this.rS != null)
        {
          paramV.removeCallbacks(this.rS);
          this.rS = null;
        }
        if (this.rT == null) {
          this.rT = new OverScroller(paramV.getContext());
        }
        this.rT.fling(0, bR(), 0, Math.round(f), 0, 0, i, 0);
        if (!this.rT.computeScrollOffset()) {
          break label431;
        }
        this.rS = new a(paramCoordinatorLayout, paramV);
        t.b(paramV, this.rS);
      }
      break;
    }
    for (;;)
    {
      this.rU = false;
      this.ok = -1;
      if (this.oj == null) {
        break;
      }
      this.oj.recycle();
      this.oj = null;
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
    return a(paramCoordinatorLayout, paramV, bO() - paramInt1, paramInt2, paramInt3);
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.rW < 0) {
      this.rW = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    if ((paramMotionEvent.getAction() == 2) && (this.rU)) {
      return true;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      if (this.oj != null) {
        this.oj.addMovement(paramMotionEvent);
      }
      return this.rU;
      this.rU = false;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((bP()) && (paramCoordinatorLayout.d(paramV, i, j)))
      {
        this.rV = j;
        this.ok = paramMotionEvent.getPointerId(0);
        cL();
        continue;
        i = this.ok;
        if (i != -1)
        {
          i = paramMotionEvent.findPointerIndex(i);
          if (i != -1)
          {
            i = (int)paramMotionEvent.getY(i);
            if (Math.abs(i - this.rV) > this.rW)
            {
              this.rU = true;
              this.rV = i;
              continue;
              this.rU = false;
              this.ok = -1;
              if (this.oj != null)
              {
                this.oj.recycle();
                this.oj = null;
              }
            }
          }
        }
      }
    }
  }
  
  int bO()
  {
    return bR();
  }
  
  boolean bP()
  {
    return false;
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
    private final CoordinatorLayout rX;
    private final V rY;
    
    a(V paramV)
    {
      this.rX = paramV;
      Object localObject;
      this.rY = localObject;
    }
    
    public final void run()
    {
      if ((this.rY != null) && (HeaderBehavior.this.rT != null))
      {
        if (HeaderBehavior.this.rT.computeScrollOffset())
        {
          HeaderBehavior.this.b(this.rX, this.rY, HeaderBehavior.this.rT.getCurrY());
          t.b(this.rY, this);
        }
      }
      else {
        return;
      }
      HeaderBehavior.this.a(this.rX, this.rY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.HeaderBehavior
 * JD-Core Version:    0.7.0.1
 */