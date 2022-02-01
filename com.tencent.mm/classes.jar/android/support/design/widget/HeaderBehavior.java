package android.support.design.widget;

import android.content.Context;
import android.support.v4.b.a;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

public abstract class HeaderBehavior<V extends View>
  extends ViewOffsetBehavior<V>
{
  private VelocityTracker ol;
  private int om = -1;
  private Runnable rV;
  OverScroller rW;
  private boolean rX;
  private int rY;
  private int rZ = -1;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void cN()
  {
    if (this.ol == null) {
      this.ol = VelocityTracker.obtain();
    }
  }
  
  int a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = bT();
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
    if (this.rZ < 0) {
      this.rZ = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    int i;
    int j;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
      for (;;)
      {
        if (this.ol != null) {
          this.ol.addMovement(paramMotionEvent);
        }
        return true;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if ((!paramCoordinatorLayout.d(paramV, i, j)) || (!bR())) {
          break;
        }
        this.rY = j;
        this.om = paramMotionEvent.getPointerId(0);
        cN();
      }
      return false;
    case 2: 
      i = paramMotionEvent.findPointerIndex(this.om);
      if (i == -1) {
        return false;
      }
      int k = (int)paramMotionEvent.getY(i);
      j = this.rY - k;
      i = j;
      if (!this.rX)
      {
        i = j;
        if (Math.abs(j) > this.rZ)
        {
          this.rX = true;
          if (j <= 0) {
            break label243;
          }
        }
      }
      for (i = j - this.rZ; this.rX; i = j + this.rZ)
      {
        this.rY = k;
        b(paramCoordinatorLayout, paramV, i, g(paramV), 0);
        break;
      }
    case 1: 
      label243:
      if (this.ol != null)
      {
        this.ol.addMovement(paramMotionEvent);
        this.ol.computeCurrentVelocity(1000);
        float f = this.ol.getYVelocity(this.om);
        i = -f(paramV);
        if (this.rV != null)
        {
          paramV.removeCallbacks(this.rV);
          this.rV = null;
        }
        if (this.rW == null) {
          this.rW = new OverScroller(paramV.getContext());
        }
        this.rW.fling(0, bT(), 0, Math.round(f), 0, 0, i, 0);
        if (!this.rW.computeScrollOffset()) {
          break label431;
        }
        this.rV = new a(paramCoordinatorLayout, paramV);
        u.b(paramV, this.rV);
      }
      break;
    }
    for (;;)
    {
      this.rX = false;
      this.om = -1;
      if (this.ol == null) {
        break;
      }
      this.ol.recycle();
      this.ol = null;
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
    return a(paramCoordinatorLayout, paramV, bQ() - paramInt1, paramInt2, paramInt3);
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.rZ < 0) {
      this.rZ = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    if ((paramMotionEvent.getAction() == 2) && (this.rX)) {
      return true;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      if (this.ol != null) {
        this.ol.addMovement(paramMotionEvent);
      }
      return this.rX;
      this.rX = false;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((bR()) && (paramCoordinatorLayout.d(paramV, i, j)))
      {
        this.rY = j;
        this.om = paramMotionEvent.getPointerId(0);
        cN();
        continue;
        i = this.om;
        if (i != -1)
        {
          i = paramMotionEvent.findPointerIndex(i);
          if (i != -1)
          {
            i = (int)paramMotionEvent.getY(i);
            if (Math.abs(i - this.rY) > this.rZ)
            {
              this.rX = true;
              this.rY = i;
              continue;
              this.rX = false;
              this.om = -1;
              if (this.ol != null)
              {
                this.ol.recycle();
                this.ol = null;
              }
            }
          }
        }
      }
    }
  }
  
  int bQ()
  {
    return bT();
  }
  
  boolean bR()
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
    private final CoordinatorLayout sa;
    private final V sc;
    
    a(V paramV)
    {
      this.sa = paramV;
      Object localObject;
      this.sc = localObject;
    }
    
    public final void run()
    {
      if ((this.sc != null) && (HeaderBehavior.this.rW != null))
      {
        if (HeaderBehavior.this.rW.computeScrollOffset())
        {
          HeaderBehavior.this.b(this.sa, this.sc, HeaderBehavior.this.rW.getCurrY());
          u.b(this.sc, this);
        }
      }
      else {
        return;
      }
      HeaderBehavior.this.a(this.sa, this.sc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.HeaderBehavior
 * JD-Core Version:    0.7.0.1
 */