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
  private VelocityTracker lr;
  private int ls = -1;
  private Runnable oZ;
  OverScroller pa;
  private boolean pb;
  private int pc;
  private int pd = -1;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void co()
  {
    if (this.lr == null) {
      this.lr = VelocityTracker.obtain();
    }
  }
  
  int a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = bv();
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
    if (this.pd < 0) {
      this.pd = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    int i;
    int j;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
      for (;;)
      {
        if (this.lr != null) {
          this.lr.addMovement(paramMotionEvent);
        }
        return true;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if ((!paramCoordinatorLayout.d(paramV, i, j)) || (!bt())) {
          break;
        }
        this.pc = j;
        this.ls = paramMotionEvent.getPointerId(0);
        co();
      }
      return false;
    case 2: 
      i = paramMotionEvent.findPointerIndex(this.ls);
      if (i == -1) {
        return false;
      }
      int k = (int)paramMotionEvent.getY(i);
      j = this.pc - k;
      i = j;
      if (!this.pb)
      {
        i = j;
        if (Math.abs(j) > this.pd)
        {
          this.pb = true;
          if (j <= 0) {
            break label243;
          }
        }
      }
      for (i = j - this.pd; this.pb; i = j + this.pd)
      {
        this.pc = k;
        b(paramCoordinatorLayout, paramV, i, g(paramV), 0);
        break;
      }
    case 1: 
      label243:
      if (this.lr != null)
      {
        this.lr.addMovement(paramMotionEvent);
        this.lr.computeCurrentVelocity(1000);
        float f = this.lr.getYVelocity(this.ls);
        i = -f(paramV);
        if (this.oZ != null)
        {
          paramV.removeCallbacks(this.oZ);
          this.oZ = null;
        }
        if (this.pa == null) {
          this.pa = new OverScroller(paramV.getContext());
        }
        this.pa.fling(0, bv(), 0, Math.round(f), 0, 0, i, 0);
        if (!this.pa.computeScrollOffset()) {
          break label431;
        }
        this.oZ = new a(paramCoordinatorLayout, paramV);
        t.b(paramV, this.oZ);
      }
      break;
    }
    for (;;)
    {
      this.pb = false;
      this.ls = -1;
      if (this.lr == null) {
        break;
      }
      this.lr.recycle();
      this.lr = null;
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
    return a(paramCoordinatorLayout, paramV, bs() - paramInt1, paramInt2, paramInt3);
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.pd < 0) {
      this.pd = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    if ((paramMotionEvent.getAction() == 2) && (this.pb)) {
      return true;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      if (this.lr != null) {
        this.lr.addMovement(paramMotionEvent);
      }
      return this.pb;
      this.pb = false;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((bt()) && (paramCoordinatorLayout.d(paramV, i, j)))
      {
        this.pc = j;
        this.ls = paramMotionEvent.getPointerId(0);
        co();
        continue;
        i = this.ls;
        if (i != -1)
        {
          i = paramMotionEvent.findPointerIndex(i);
          if (i != -1)
          {
            i = (int)paramMotionEvent.getY(i);
            if (Math.abs(i - this.pc) > this.pd)
            {
              this.pb = true;
              this.pc = i;
              continue;
              this.pb = false;
              this.ls = -1;
              if (this.lr != null)
              {
                this.lr.recycle();
                this.lr = null;
              }
            }
          }
        }
      }
    }
  }
  
  int bs()
  {
    return bv();
  }
  
  boolean bt()
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
    private final CoordinatorLayout pe;
    private final V pf;
    
    a(V paramV)
    {
      this.pe = paramV;
      Object localObject;
      this.pf = localObject;
    }
    
    public final void run()
    {
      if ((this.pf != null) && (HeaderBehavior.this.pa != null))
      {
        if (HeaderBehavior.this.pa.computeScrollOffset())
        {
          HeaderBehavior.this.b(this.pe, this.pf, HeaderBehavior.this.pa.getCurrY());
          t.b(this.pf, this);
        }
      }
      else {
        return;
      }
      HeaderBehavior.this.a(this.pe, this.pf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.HeaderBehavior
 * JD-Core Version:    0.7.0.1
 */